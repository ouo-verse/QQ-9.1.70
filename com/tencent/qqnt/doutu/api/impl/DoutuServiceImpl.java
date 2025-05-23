package com.tencent.qqnt.doutu.api.impl;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.doutu.DoutuData;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.temp.report.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IReportControllerApi;
import com.tencent.qqnt.doutu.DoutuEmotionHorizonListView;
import com.tencent.qqnt.doutu.DuiButtonImageView;
import com.tencent.qqnt.doutu.api.IDoutuManageApi;
import com.tencent.qqnt.doutu.api.IDoutuSPUtil;
import com.tencent.qqnt.doutu.api.IDoutuService;
import com.tencent.qqnt.doutu.api.IDoutuUtils;
import com.tencent.qqnt.doutu.e;
import com.tencent.qqnt.doutu.f;
import com.tencent.qqnt.doutu.g;
import com.tencent.qqnt.http.api.IHttpService;
import com.tencent.qqnt.http.api.b;
import com.tencent.qqnt.http.api.m;
import com.tencent.widget.HorizontalListView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import mqq.util.LogUtil;
import mqq.util.WeakReference;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes24.dex */
public class DoutuServiceImpl implements IDoutuService, Handler.Callback {
    static IPatchRedirector $redirector_ = null;
    private static final long COMBO_DURATION_DEFAULT = 15;
    private static final long COMBO_KEEP_TIME_DEFAULT = 15;
    private static final boolean COMBO_SWITCH_DEFAULT = false;
    private static final long DOUTU_KEEP_TIME_DEFAULT = 1800;
    private static final long DOUTU_LAYOUT_SHOW_TIME = 5000;
    public static final String DOUTU_RES_DOWNLOAD_REPORT_TAG = "doutuResDownload";
    private static final String DOUTU_RES_INFO_FILE_NAME = "doutuResInfo";
    private static final boolean DOUTU_SWITCH_DEFAULT = false;
    private static final long DUI_DURATION_DEFAULT = 15;
    private static final int DUI_TIMES_DEFAULT = 3;
    private static final long MIN_TIME_SPACE = 1000;
    private static final int RECOMMEND_COUNT_LIMIT = 1;
    private static final int STATUS_GETTING_DOUTU = 1;
    private static final int STATUS_GETTING_DOUTU_IDEL = 0;
    private static final String TAG = "DoutuServiceImpl";
    private static final boolean TIMING_SWITCH = true;
    public static volatile boolean isLoadingRes;
    private ConcurrentHashMap<String, ConcurrentHashMap<String, d>> aioComboMap;
    private ConcurrentHashMap<String, ConcurrentHashMap<String, e>> aioMap;
    private WeakReference<com.tencent.qqnt.doutu.c> catchDoutuItem;
    private long comboDuration;
    private long comboKeepTime;
    private boolean comboShowSwitch;
    private boolean comboSwitch;
    public List<String> dataMd5List;
    public int defaultCount;
    private long doutuKeepTime;
    private List<DoutuData> doutuListPreload;
    private List<DoutuData> doutuListShowing;
    private boolean doutuSettingSwitch;
    private boolean doutuSwitch;
    private long duiDuration;
    private int duiTimes;
    private boolean hasReadConfigFromSP;
    public boolean isSmartSwitchNew;
    private List<com.tencent.qqnt.doutu.d> lastDoutuList;
    private volatile int lastDoutuListSize;
    private volatile int lastReportComboIndex;
    private volatile int lastReportDuiIndex;
    private long lastTimeStamp;
    private com.tencent.aio.api.runtime.a mAIOContext;

    @IdRes
    private int mAioEmotionAnimaContainerResId;
    private AppRuntime mApp;
    public com.tencent.qqnt.doutu.combo.b mComboUIManager;
    private ViewGroup mContentView;
    public com.tencent.qqnt.doutu.b mDoutuAdapter;
    private MqqHandler mDoutuAnimationHandler;
    private HandlerThread mDoutuAnimationThread;
    public LinearLayout mDoutuLayout;
    private MqqHandler mDoutuUIHandler;
    private boolean mHasChatResumed;
    private boolean mHasInitedChatSession;
    private boolean mHasInitedComboUI;
    public g mListener;
    private IDoutuService.a mOnShowStateListener;
    private List<com.tencent.qqnt.doutu.d> mPendingComboDoutuList;
    private String mUin;
    private String mUinType;
    public ConcurrentHashMap<Long, com.tencent.qqnt.doutu.c> requestCountMap;
    private volatile int status;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes24.dex */
    public class a implements HorizontalListView.OnScrollStateChangedListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DoutuServiceImpl.this);
            }
        }

        @Override // com.tencent.widget.HorizontalListView.OnScrollStateChangedListener
        public void onScrollStateChanged(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            } else if (i3 == 4097) {
                com.tencent.mobileqq.temp.report.a.a(DoutuServiceImpl.this.mApp, "dc00898", "", "", "0X8007FAA", "0X8007FAA", 0, 0, "", "", "", "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes24.dex */
    public class b implements DoutuEmotionHorizonListView.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MqqHandler f356009a;

        b(MqqHandler mqqHandler) {
            this.f356009a = mqqHandler;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DoutuServiceImpl.this, (Object) mqqHandler);
            }
        }

        @Override // com.tencent.qqnt.doutu.DoutuEmotionHorizonListView.a
        public void touchEventActionChanged(int i3) {
            MqqHandler mqqHandler;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            if (i3 != 0) {
                if ((i3 == 1 || i3 == 3) && (mqqHandler = this.f356009a) != null) {
                    mqqHandler.sendEmptyMessageDelayed(82, 5000L);
                    return;
                }
                return;
            }
            MqqHandler mqqHandler2 = this.f356009a;
            if (mqqHandler2 != null) {
                mqqHandler2.removeMessages(82);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes24.dex */
    public class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private boolean f356011a;

        /* renamed from: b, reason: collision with root package name */
        private List<com.tencent.qqnt.doutu.d> f356012b;

        /* renamed from: c, reason: collision with root package name */
        private int f356013c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f356014d;

        /* renamed from: e, reason: collision with root package name */
        private int f356015e;

        public c(List<com.tencent.qqnt.doutu.d> list, int i3, boolean z16, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, DoutuServiceImpl.this, list, Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16));
                return;
            }
            this.f356012b = list;
            this.f356013c = i3;
            this.f356014d = z16;
            this.f356015e = i16;
        }

        private int d(long j3) {
            if (DoutuServiceImpl.this.lastDoutuList == null) {
                return 0;
            }
            int i3 = 0;
            for (int i16 = 0; i16 < DoutuServiceImpl.this.lastDoutuList.size() && ((com.tencent.qqnt.doutu.d) DoutuServiceImpl.this.lastDoutuList.get(i16)).f356092c < j3; i16++) {
                i3++;
            }
            return i3;
        }

        public int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.f356013c;
        }

        public c b() {
            int d16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (c) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            if (DoutuServiceImpl.this.lastDoutuListSize != 0 && this.f356012b.size() == DoutuServiceImpl.this.lastDoutuListSize) {
                if (DoutuServiceImpl.this.lastDoutuList != null && DoutuServiceImpl.this.lastDoutuList.size() > 0 && (d16 = d(this.f356012b.get(0).f356092c)) > 0 && (this.f356012b.size() - 1) - d16 >= 0) {
                    List<com.tencent.qqnt.doutu.d> list = this.f356012b;
                    long j3 = list.get((list.size() - 1) - d16).f356090a;
                    List<com.tencent.qqnt.doutu.d> list2 = this.f356012b;
                    if (list2.get(list2.size() - 1).f356090a - j3 < DoutuServiceImpl.this.comboKeepTime) {
                        this.f356015e = this.f356012b.size() - 1;
                        this.f356013c += d16;
                        this.f356014d = true;
                        DoutuServiceImpl doutuServiceImpl = DoutuServiceImpl.this;
                        doutuServiceImpl.recordComboStamp(doutuServiceImpl.mUin, DoutuServiceImpl.this.mUinType, this.f356012b.get(this.f356015e), this.f356013c, this.f356015e);
                        this.f356011a = true;
                        return this;
                    }
                    this.f356015e = this.f356012b.size() - 1;
                    this.f356013c = 0;
                    DoutuServiceImpl doutuServiceImpl2 = DoutuServiceImpl.this;
                    doutuServiceImpl2.removeComboStamp(doutuServiceImpl2.mUin, DoutuServiceImpl.this.mUinType);
                    this.f356011a = true;
                    return this;
                }
                this.f356015e = this.f356012b.size() - 1;
                DoutuServiceImpl doutuServiceImpl3 = DoutuServiceImpl.this;
                doutuServiceImpl3.recordComboStamp(doutuServiceImpl3.mUin, DoutuServiceImpl.this.mUinType, this.f356012b.get(this.f356015e), this.f356013c, this.f356015e);
                this.f356011a = true;
                return this;
            }
            if (DoutuServiceImpl.this.lastDoutuListSize != 0 && this.f356012b.size() > DoutuServiceImpl.this.lastDoutuListSize) {
                long j16 = this.f356012b.get(DoutuServiceImpl.this.lastDoutuListSize - 1).f356090a;
                List<com.tencent.qqnt.doutu.d> list3 = this.f356012b;
                if (list3.get(list3.size() - 1).f356090a - j16 < DoutuServiceImpl.this.comboKeepTime) {
                    this.f356015e = this.f356012b.size() - 1;
                    this.f356013c += this.f356012b.size() - DoutuServiceImpl.this.lastDoutuListSize;
                    DoutuServiceImpl doutuServiceImpl4 = DoutuServiceImpl.this;
                    doutuServiceImpl4.recordComboStamp(doutuServiceImpl4.mUin, DoutuServiceImpl.this.mUinType, this.f356012b.get(this.f356015e), this.f356013c, this.f356015e);
                    this.f356011a = true;
                    return this;
                }
                this.f356015e = this.f356012b.size() - 1;
                this.f356013c = 0;
                DoutuServiceImpl doutuServiceImpl5 = DoutuServiceImpl.this;
                doutuServiceImpl5.removeComboStamp(doutuServiceImpl5.mUin, DoutuServiceImpl.this.mUinType);
                this.f356011a = true;
                return this;
            }
            this.f356011a = false;
            return this;
        }

        public int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.f356015e;
        }

        boolean e() {
            return this.f356011a;
        }

        public boolean f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return this.f356014d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes24.dex */
    public class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        long f356017a;

        /* renamed from: b, reason: collision with root package name */
        long f356018b;

        /* renamed from: c, reason: collision with root package name */
        String f356019c;

        /* renamed from: d, reason: collision with root package name */
        int f356020d;

        /* renamed from: e, reason: collision with root package name */
        int f356021e;

        public d(long j3, long j16, String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, DoutuServiceImpl.this, Long.valueOf(j3), Long.valueOf(j16), str, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            this.f356017a = j3;
            this.f356018b = j16;
            this.f356019c = str;
            this.f356020d = i3;
            this.f356021e = i16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes24.dex */
    public class e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        long f356023a;

        /* renamed from: b, reason: collision with root package name */
        long f356024b;

        public e(long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, DoutuServiceImpl.this, Long.valueOf(j3), Long.valueOf(j16));
            } else {
                this.f356023a = j3;
                this.f356024b = j16;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31237);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 51)) {
            redirector.redirect((short) 51);
        } else {
            isLoadingRes = false;
        }
    }

    public DoutuServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.duiTimes = 3;
        this.duiDuration = 15L;
        this.comboDuration = 15L;
        this.doutuKeepTime = 1800L;
        this.comboKeepTime = 15L;
        this.lastTimeStamp = 0L;
        this.status = 0;
        this.doutuSwitch = false;
        this.comboSwitch = false;
        this.comboShowSwitch = true;
        this.doutuSettingSwitch = true;
        this.hasReadConfigFromSP = false;
        this.aioMap = new ConcurrentHashMap<>();
        this.aioComboMap = new ConcurrentHashMap<>();
        this.doutuListPreload = new ArrayList();
        this.doutuListShowing = new ArrayList();
        this.isSmartSwitchNew = false;
        this.defaultCount = 4;
        this.requestCountMap = new ConcurrentHashMap<>();
        this.dataMd5List = new ArrayList();
        this.lastReportDuiIndex = 0;
        this.lastReportComboIndex = 0;
        this.mComboUIManager = null;
        this.mDoutuAnimationHandler = new MqqHandler(ThreadManagerV2.getQQCommonThreadLooper());
        this.mDoutuUIHandler = new MqqHandler(Looper.getMainLooper(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAndDownloadRes() {
        if (isLoadingRes) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "checkAndDownloadRes : isLoadingRes = true");
                return;
            }
            return;
        }
        isLoadingRes = true;
        if (!isDoutuOpen() && !isComboOpen()) {
            isLoadingRes = false;
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        String doutuResMd5 = ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).getDoutuResMd5(peekAppRuntime.getApp(), peekAppRuntime.getCurrentAccountUin());
        String doutuResUrl = ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).getDoutuResUrl(peekAppRuntime.getApp(), peekAppRuntime.getCurrentAccountUin());
        if (QLog.isColorLevel() && doutuResMd5 != null && doutuResUrl != null) {
            QLog.d(TAG, 2, "checkAndDownloadRes: md5 = " + doutuResMd5 + ", url = " + doutuResUrl);
        }
        if (doutuResMd5 != null && doutuResMd5.length() != 0 && doutuResUrl != null && doutuResUrl.length() != 0) {
            String str = IDoutuUtils.DOUTU_ANIMA_RES_PATH + "DoutuRes.zip";
            if (!checkLocalResFiles(peekAppRuntime, doutuResMd5)) {
                downloadRes(doutuResUrl, str, doutuResMd5);
                return;
            } else {
                DuiButtonImageView.i();
                isLoadingRes = false;
                return;
            }
        }
        QLog.e(TAG, 2, "checkAndDownloadRes failed! md5 = " + doutuResMd5 + ", url = " + doutuResUrl);
        isLoadingRes = false;
    }

    private int checkCombo(List<com.tencent.qqnt.doutu.d> list, String str, String str2, int i3) {
        boolean z16;
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "checkCombo \uff0cstartIndex = " + i3);
        }
        int i16 = i3;
        int i17 = 0;
        while (i16 <= list.size() - this.duiTimes && list.size() - i3 >= this.duiTimes) {
            int i18 = i16;
            while (i18 < (this.duiTimes + i16) - 1) {
                long j3 = list.get(i18).f356090a;
                i18++;
                long j16 = list.get(i18).f356090a;
                if (j3 <= 0 || j16 <= 0 || j16 - j3 > this.comboDuration) {
                    z16 = false;
                    break;
                }
            }
            z16 = true;
            if (z16) {
                recordComboStamp(str, str2, list.get((this.duiTimes + i16) - 1), 3, i16);
                if (this.duiTimes + i16 == list.size()) {
                    return 3;
                }
                int i19 = i16;
                int i26 = this.duiTimes + i16;
                i17 = 3;
                while (true) {
                    if (i26 < list.size()) {
                        int i27 = i26 - 1;
                        if (list.get(i26).f356090a - list.get(i27).f356090a > this.comboKeepTime) {
                            removeComboStamp(str, str2);
                            i17 = 0;
                            i16 = i27;
                            break;
                        }
                        int i28 = i17 + 1;
                        recordComboStamp(str, str2, list.get(i26), i28, i19);
                        i26++;
                        i19 = i27;
                        i17 = i28;
                    } else {
                        i16 = i19;
                        break;
                    }
                }
            }
            i16++;
        }
        return i17;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0054, code lost:
    
        com.tencent.mobileqq.temp.report.a.a(r28.mApp, "dc00898", "", "", "0X8007FA7", "0X8007FA7", 0, 0, "", "", "", "");
        recordDoutuStamp(r30, r31, r29.get(r4));
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x008b, code lost:
    
        if (r29.get(r4).f356091b != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x008d, code lost:
    
        r6 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0093, code lost:
    
        if (r4 != (r29.size() - 1)) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0095, code lost:
    
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0096, code lost:
    
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x009b, code lost:
    
        if (r4 >= r29.size()) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b4, code lost:
    
        if ((r29.get(r4).f356090a - r29.get(r4 - 1).f356090a) <= r28.doutuKeepTime) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b7, code lost:
    
        recordDoutuStamp(r30, r31, r29.get(r4));
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c8, code lost:
    
        if (r29.get(r4).f356091b != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ca, code lost:
    
        r6 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00cb, code lost:
    
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ce, code lost:
    
        return r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int checkDui(List<com.tencent.qqnt.doutu.d> list, String str, String str2, int i3) {
        boolean z16;
        int i16 = -1;
        if (list.size() - i3 < this.duiTimes) {
            return -1;
        }
        int size = list.size() - 1;
        while (size >= (i3 + this.duiTimes) - 1) {
            int i17 = size;
            while (true) {
                if (i17 > (size - this.duiTimes) + 1) {
                    long j3 = list.get(i17 - 1).f356090a;
                    long j16 = list.get(i17).f356090a;
                    z16 = false;
                    if (j3 <= 0 || j16 <= 0 || j16 - j3 > this.duiDuration) {
                        break;
                    }
                    i17--;
                } else {
                    z16 = true;
                    break;
                }
            }
            size--;
        }
        return -1;
    }

    private boolean checkTime(List<com.tencent.qqnt.doutu.d> list, int i3) {
        if (list.get(i3).f356090a <= 0) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "handleCombo : doutuList.get(i).time <= 0");
                return true;
            }
            return true;
        }
        return false;
    }

    private void downloadRes(String str, String str2, String str3) {
        ThreadManager.getSubThreadHandler().post(new Runnable(str, str2, str3) { // from class: com.tencent.qqnt.doutu.api.impl.DoutuServiceImpl.10
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f355991d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f355992e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f355993f;

            {
                this.f355991d = str;
                this.f355992e = str2;
                this.f355993f = str3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, DoutuServiceImpl.this, str, str2, str3);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                int a16;
                boolean z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                boolean z17 = true;
                m syncExecute = ((IHttpService) QRoute.api(IHttpService.class)).syncExecute(new b.a("doutu", this.f355991d, new File(this.f355992e)).R(true).c());
                if (syncExecute.e()) {
                    if (QLog.isColorLevel()) {
                        QLog.d(DoutuServiceImpl.TAG, 2, "checkAndDownloadRes : [onDone] download finished " + this.f355991d);
                    }
                    if (this.f355993f.equalsIgnoreCase(DoutuServiceImpl.this.getFileMD5(this.f355992e))) {
                        DoutuServiceImpl.this.unzip(this.f355992e);
                        DoutuServiceImpl.this.writeStringToFile(IDoutuUtils.DOUTU_ANIMA_RES_PATH + DoutuServiceImpl.DOUTU_RES_INFO_FILE_NAME, this.f355993f);
                        ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).updateDoutuResDamaged(BaseApplication.getContext(), false);
                        DuiButtonImageView.i();
                        a16 = 0;
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.d(DoutuServiceImpl.TAG, 2, "[onDone] checkMd5 failed: " + this.f355992e);
                        }
                        FileUtils.deleteFile(this.f355992e);
                        a16 = 80704;
                        z17 = false;
                    }
                    z16 = z17;
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d(DoutuServiceImpl.TAG, 2, "checkAndDownloadRes : [onDone] downloadFile failed: " + syncExecute);
                    }
                    a16 = syncExecute.a();
                    z16 = false;
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("param_FailCode", String.valueOf(a16));
                StatisticCollector.d(BaseApplication.getContext()).c(null, DoutuServiceImpl.DOUTU_RES_DOWNLOAD_REPORT_TAG, z16, 0L, 0L, hashMap, "");
                DoutuServiceImpl.isLoadingRes = false;
            }
        });
    }

    private void dropPersistDoutuData() {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "dropPersistDoutuData ");
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.doutu.api.impl.DoutuServiceImpl.9
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) DoutuServiceImpl.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        }, 32, null, false);
    }

    private DoutuEmotionHorizonListView getDoutuEmotionHorizonListView(MqqHandler mqqHandler, com.tencent.qqnt.doutu.c cVar, int i3) {
        DoutuEmotionHorizonListView doutuEmotionHorizonListView;
        LinearLayout linearLayout = (LinearLayout) this.mContentView.findViewById(R.id.bom);
        if (linearLayout != null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "showDoutuEmotionLayout : doutuLayout != null.");
            }
            this.mDoutuLayout = linearLayout;
            doutuEmotionHorizonListView = (DoutuEmotionHorizonListView) linearLayout.findViewById(R.id.bop);
            com.tencent.qqnt.doutu.b bVar = (com.tencent.qqnt.doutu.b) doutuEmotionHorizonListView.getAdapter();
            this.mDoutuAdapter = bVar;
            if (bVar == null) {
                g gVar = this.mListener;
                String str = this.mUin;
                com.tencent.qqnt.doutu.b bVar2 = new com.tencent.qqnt.doutu.b(gVar, str, this.mUinType, str, mqqHandler, this.isSmartSwitchNew, cVar, this.defaultCount);
                this.mDoutuAdapter = bVar2;
                doutuEmotionHorizonListView.setAdapter((ListAdapter) bVar2);
            }
            reportDoutuEventNew();
        } else {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "showDoutuEmotionLayout : doutuLayout == null.");
            }
            LinearLayout linearLayout2 = (LinearLayout) View.inflate(this.mContentView.getContext(), R.layout.fpt, null);
            this.mDoutuLayout = linearLayout2;
            doutuEmotionHorizonListView = (DoutuEmotionHorizonListView) linearLayout2.findViewById(R.id.bop);
            g gVar2 = this.mListener;
            String str2 = this.mUin;
            com.tencent.qqnt.doutu.b bVar3 = new com.tencent.qqnt.doutu.b(gVar2, str2, this.mUinType, str2, mqqHandler, this.isSmartSwitchNew, cVar, this.defaultCount);
            this.mDoutuAdapter = bVar3;
            doutuEmotionHorizonListView.setAdapter((ListAdapter) bVar3);
            setListeners(mqqHandler, doutuEmotionHorizonListView);
            ViewGroup viewGroup = this.mContentView;
            if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(12);
                layoutParams.addRule(11);
                this.mContentView.addView(this.mDoutuLayout, layoutParams);
            } else if (viewGroup instanceof ConstraintLayout) {
                ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-1, -2);
                layoutParams2.bottomToBottom = 0;
                layoutParams2.rightToRight = 0;
                this.mContentView.addView(this.mDoutuLayout, layoutParams2);
            } else {
                QLog.e(TAG, 1, "updateNavigateBar error, invalid content view!");
            }
        }
        return doutuEmotionHorizonListView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getFileMD5(String str) {
        String d16;
        try {
            try {
                String fileMD5String = getFileMD5String(str);
                if (fileMD5String == null) {
                    return "";
                }
                return fileMD5String;
            } catch (UnsatisfiedLinkError unused) {
                File file = new File(str);
                if (file.exists()) {
                    try {
                        d16 = com.tencent.qqprotect.singleupdate.a.d(file);
                        if (d16 == null) {
                            d16 = "";
                        }
                    } catch (IOException unused2) {
                        d16 = null;
                        if (d16 == null) {
                            return "";
                        }
                        return d16;
                    }
                    if (d16 == null) {
                    }
                }
                d16 = null;
                if (d16 == null) {
                }
            }
        } catch (Throwable unused3) {
            return "";
        }
    }

    public static String getFileMD5String(String str) {
        String str2 = null;
        try {
            byte[] partfileMd5 = MD5.getPartfileMd5(str, 0L);
            if (partfileMd5 != null) {
                str2 = com.tencent.qqprotect.singleupdate.a.b(partfileMd5);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.e(TAG, 2, "error ........ error getFileMD5String filePath: " + str + ", error=" + e16.getMessage());
        }
        if (QLog.isDebugVersion()) {
            QLog.e(TAG, 2, "getFileMD5String md5: " + str2);
        }
        return str2;
    }

    private void handleComboUI(int i3, boolean z16, com.tencent.qqnt.doutu.d dVar) {
        initComboUI();
        com.tencent.qqnt.doutu.combo.b bVar = this.mComboUIManager;
        if (bVar != null) {
            long serverTime = (this.comboKeepTime - (NetConnInfoCenter.getServerTime() - dVar.f356090a)) + 1;
            if (i3 == 0) {
                bVar.b(0L);
                return;
            }
            bVar.i();
            bVar.n(new com.tencent.qqnt.doutu.combo.a(dVar.f356100k, i3 - 2, z16, dVar.f356102m));
            bVar.b(serverTime * 1000);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "handleCombo: mComboUIManager is null");
        }
    }

    private void handleData() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "showDoutuEmotionLayout : doutuListPreload.size() > 0.");
        }
        this.doutuListShowing.clear();
        this.dataMd5List.clear();
        moveDataToShowing();
        com.tencent.qqnt.doutu.b bVar = this.mDoutuAdapter;
        if (bVar != null) {
            bVar.f356027e = new ArrayList();
            this.mDoutuAdapter.f356027e.addAll(this.doutuListShowing);
        }
        this.doutuListPreload.clear();
        dropPersistDoutuData();
    }

    private int handleTimeOut(int i3, com.tencent.qqnt.doutu.d dVar) {
        if (dVar.f356090a > 0 && NetConnInfoCenter.getServerTime() - dVar.f356090a > this.comboKeepTime) {
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 2, "handleCombo \uff1atoo long for comboKeepTime ,set combo = 0 ! NetConnInfoCenter.getServerTime() = " + NetConnInfoCenter.getServerTime() + ", lastMsg.time = " + dVar.f356090a);
            }
            removeComboStamp(this.mUin, this.mUinType);
            return 0;
        }
        return i3;
    }

    private void initDebugConfig(AppRuntime appRuntime) {
        String currentAccountUin = appRuntime.getCurrentAccountUin();
        ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).updateDoutuSwitch(appRuntime.getApp(), currentAccountUin, true);
        long j3 = 10;
        ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).updateDoutuDuration(appRuntime.getApp(), currentAccountUin, j3);
        ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).updateDuiTimes(appRuntime.getApp(), currentAccountUin, 3);
        ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).updateDoutuComboSwitch(appRuntime.getApp(), currentAccountUin, true);
        ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).updateDoutuSmartSwitchNew(appRuntime.getApp(), currentAccountUin, false);
        ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).updateDoutuResUrl(appRuntime.getApp(), currentAccountUin, "https://static-res.qq.com/static-res/rich_media/duitu/DoutuRes.zip");
        ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).updateDoutuResMd5(appRuntime.getApp(), currentAccountUin, "373cdc9141668d160ebfa7236d8755f3");
        ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).updateComboDuration(appRuntime.getApp(), currentAccountUin, 20L);
        ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).updateComboKeep(appRuntime.getApp(), currentAccountUin, 10L);
        ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).updateSmartPicCount(appRuntime.getApp(), currentAccountUin, 4);
        updataDoutuConfig(true, true, j3, 20L, 10L, false, 4);
        doOnLogin(true);
    }

    private boolean isComboOpen() {
        if (!this.hasReadConfigFromSP) {
            readFromSP();
        }
        if (this.comboSwitch && this.doutuSettingSwitch && this.comboShowSwitch) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$initComboUI$0() {
        ((IDoutuManageApi) com.tencent.qqnt.aio.adapter.a.b(IDoutuManageApi.class)).loadConfig();
    }

    private void moveDataToShowing() {
        for (DoutuData doutuData : this.doutuListPreload) {
            if (this.doutuListShowing.size() < 20) {
                this.doutuListShowing.add(doutuData);
                if (!TextUtils.isEmpty(doutuData.picMd5)) {
                    this.dataMd5List.add(doutuData.picMd5);
                }
            }
        }
    }

    private boolean needHandleCombo(List<com.tencent.qqnt.doutu.d> list, int i3) {
        int i16 = i3 & 65535;
        if (i16 != 4 && i16 != 7 && i16 != 8) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleCombo, no new msg");
        }
        this.lastDoutuListSize = list.size();
        this.lastDoutuList = list;
        return false;
    }

    private void persistDoutuData(List<DoutuData> list) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "persistDoutuData ");
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.doutu.api.impl.DoutuServiceImpl.8
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) DoutuServiceImpl.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    synchronized (DoutuServiceImpl.this) {
                    }
                } catch (Throwable th5) {
                    QLog.e(DoutuServiceImpl.TAG, 2, "persistDoutuData error ", th5);
                }
            }
        }, 32, null, false);
    }

    private void preLoad(com.tencent.qqnt.doutu.c cVar, String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "preLoad, isDoutuOpen() = " + isDoutuOpen() + ", doutuListPreload.size() = " + this.doutuListPreload.size());
        }
        if (isDoutuOpen() && this.doutuListPreload.size() == 0) {
            postGetDoutuList(cVar, str, str2);
        }
    }

    private List<DoutuData> readDoutuDataFromDB() {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "readDoutuDataFromDB ");
            return null;
        }
        return null;
    }

    private void readFromSP() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e(TAG, 1, "readFromSP, mApp is null");
            return;
        }
        String currentUin = peekAppRuntime.getCurrentUin();
        BaseApplication app = peekAppRuntime.getApp();
        this.doutuSettingSwitch = ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).getDoutuSettingSwitch(app, currentUin);
        this.doutuSwitch = ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).getDoutuSwitch(app, currentUin, false);
        this.comboSwitch = ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).getDoutuComboSwitch(app, currentUin, false);
        this.isSmartSwitchNew = ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).getDoutuSmartSwitchNew(app, currentUin);
        long doutuDuration = ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).getDoutuDuration(app, currentUin);
        int duiTimes = ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).getDuiTimes(app, currentUin);
        long comboDuration = ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).getComboDuration(app, currentUin);
        long comboKeep = ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).getComboKeep(app, currentUin);
        int smartPicCount = ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).getSmartPicCount(app, currentUin);
        if (doutuDuration > 0) {
            this.duiDuration = doutuDuration;
        }
        if (duiTimes > 0) {
            this.duiTimes = duiTimes;
        }
        if (comboDuration > 0) {
            this.comboDuration = comboDuration;
        }
        if (comboKeep > 0) {
            this.comboKeepTime = comboKeep;
        }
        if (smartPicCount > 0) {
            this.defaultCount = smartPicCount;
        }
        this.hasReadConfigFromSP = true;
    }

    private void reportCombo(List<com.tencent.qqnt.doutu.d> list, int i3) {
        if (list.size() - 1 != this.lastReportComboIndex) {
            com.tencent.mobileqq.temp.report.a.a(this.mApp, "dc00898", "", "", "0X8008095", "0X8008095", 0, 0, "", "", "", "");
            this.lastReportComboIndex = list.size() - 1;
            if (i3 == 3) {
                com.tencent.mobileqq.temp.report.a.a(this.mApp, "dc00898", "", "", "0X8008094", "0X8008094", 0, 0, "", "", "", "");
            }
        }
    }

    private void reportSendDoutuPic(com.tencent.qqnt.doutu.d dVar) {
        String str;
        if (dVar.f356091b) {
            if (dVar.f356094e) {
                str = dVar.f356096g;
            } else if (dVar.f356095f) {
                str = dVar.f356097h;
            } else {
                str = "";
            }
            com.tencent.mobileqq.temp.report.a.a(this.mApp, "dc00898", "", "", "0X800AF0B", "0X800AF0B", 0, 0, String.valueOf(dVar.f356098i), "", str, "");
        }
    }

    private void setDoutuAdapter(MqqHandler mqqHandler, com.tencent.qqnt.doutu.c cVar, DoutuEmotionHorizonListView doutuEmotionHorizonListView) {
        g gVar = this.mListener;
        String str = this.mUin;
        com.tencent.qqnt.doutu.b bVar = new com.tencent.qqnt.doutu.b(gVar, str, this.mUinType, str, mqqHandler, this.isSmartSwitchNew, cVar, this.defaultCount);
        this.mDoutuAdapter = bVar;
        doutuEmotionHorizonListView.setAdapter((ListAdapter) bVar);
        if (this.doutuListPreload.size() > 0) {
            handleData();
        } else if (this.status == 0) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "showDoutuEmotionLayout : status == STATUS_GETTING_DOUTU_IDEL.");
            }
            this.doutuListShowing.clear();
            postGetDoutuList(cVar, this.mUin, this.mUinType);
        }
        com.tencent.qqnt.doutu.b bVar2 = this.mDoutuAdapter;
        if (bVar2 != null) {
            bVar2.d();
            this.mDoutuAdapter.notifyDataSetChanged();
        }
    }

    private void setListeners(MqqHandler mqqHandler, DoutuEmotionHorizonListView doutuEmotionHorizonListView) {
        doutuEmotionHorizonListView.setOnScrollStateChangedListener(new a());
        doutuEmotionHorizonListView.setTouchListener(new b(mqqHandler));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRequestReportInfo(NewIntent newIntent, String str, String str2, com.tencent.qqnt.doutu.c cVar) {
        int i3 = 1;
        if (Integer.valueOf(str2).intValue() == 0) {
            try {
                newIntent.putExtra("KEY_SRC_UIN", Long.valueOf(getCurrentAccountUin()).longValue());
            } catch (NumberFormatException e16) {
                QLog.e(TAG, 1, "setRequestReportInfo error.", e16);
            }
        } else {
            newIntent.putExtra("KEY_SRC_UIN", Long.valueOf(str));
        }
        if (Integer.valueOf(str2).intValue() != 0) {
            if (Integer.valueOf(str2).intValue() != 1) {
                Integer.valueOf(str2).intValue();
            }
            i3 = 2;
        }
        newIntent.putExtra("KEY_SESSION_TYPE", i3);
        if (cVar != null) {
            newIntent.putExtra("KEY_TO_UIN", Long.valueOf(cVar.f356042e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unzip(String str) {
        try {
            FileUtils.uncompressZip(str, IDoutuUtils.DOUTU_ANIMA_RES_PATH, false);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "[unzip] success: " + str);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "[unzip]", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean writeStringToFile(String str, String str2) {
        boolean z16;
        FileOutputStream fileOutputStream;
        File file = new File(str);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException unused) {
                z16 = false;
            }
        }
        z16 = true;
        try {
            fileOutputStream = new FileOutputStream(file, false);
        } catch (FileNotFoundException unused2) {
            fileOutputStream = null;
            z16 = false;
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.write(str2.getBytes());
            } catch (IOException unused3) {
                z16 = false;
            }
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.flush();
            } catch (IOException unused4) {
                z16 = false;
            }
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException unused5) {
                return false;
            }
        }
        return z16;
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuService
    public boolean allowPreDownloadAfterLogin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return ((Boolean) iPatchRedirector.redirect((short) 48, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuService
    public void bindAIOContext(com.tencent.aio.api.runtime.a aVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) aVar, i3);
        } else {
            this.mAIOContext = aVar;
            this.mAioEmotionAnimaContainerResId = i3;
        }
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuService
    public void bindDoutuListener(g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) gVar);
        } else {
            this.mListener = gVar;
        }
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuService
    public boolean checkLocalResFiles() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return ((Boolean) iPatchRedirector.redirect((short) 46, (Object) this)).booleanValue();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return false;
        }
        return checkLocalResFiles(peekAppRuntime, ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).getDoutuResMd5(peekAppRuntime.getApp(), peekAppRuntime.getCurrentAccountUin()));
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuService
    public void clearComboViews() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[ComboUIManager]clearComboViews, mComboUIManager == null : ");
            if (this.mComboUIManager == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.i(TAG, 2, sb5.toString());
        }
        com.tencent.qqnt.doutu.combo.b bVar = this.mComboUIManager;
        if (bVar != null) {
            bVar.c();
        }
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuService
    public void doOnChatDestory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "doOnChatPieDestory");
        }
        hideDoutuEmotionLayout();
        removeDoutuEmoLayout();
        ViewGroup viewGroup = this.mContentView;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
            this.mContentView = null;
        }
        this.mAIOContext = null;
        this.mApp = null;
        this.lastReportDuiIndex = 0;
        this.lastDoutuListSize = 0;
        this.lastDoutuList = null;
        this.lastReportComboIndex = 0;
        this.mListener = null;
        com.tencent.qqnt.doutu.combo.b bVar = this.mComboUIManager;
        if (bVar != null) {
            bVar.m();
            this.mComboUIManager = null;
        }
        this.mHasInitedChatSession = false;
        this.mHasInitedComboUI = false;
        this.mHasChatResumed = false;
        this.mPendingComboDoutuList = null;
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuService
    public void doOnChatOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        this.mHasChatResumed = true;
        try {
            handleCombo(this.mPendingComboDoutuList, 0);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "doOnChatOnResume error! ", th5);
        }
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuService
    public void doOnLogin(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "doOnLogin, isFirstLogin = " + z16);
        }
        initData();
    }

    String getCurrentAccountUin() {
        AppRuntime appRuntime = this.mApp;
        if (appRuntime != null) {
            return appRuntime.getCurrentAccountUin();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            return peekAppRuntime.getCurrentAccountUin();
        }
        return null;
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuService
    public MqqHandler getDoutuAnimationHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return (MqqHandler) iPatchRedirector.redirect((short) 44, (Object) this);
        }
        return this.mDoutuAnimationHandler;
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuService
    public MqqHandler getDoutuMainHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return (MqqHandler) iPatchRedirector.redirect((short) 45, (Object) this);
        }
        return this.mDoutuUIHandler;
    }

    public int getRecordCombo(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this, (Object) str, (Object) str2)).intValue();
        }
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0 || this.aioComboMap.get(str) == null || this.aioComboMap.get(str).get(str2) == null) {
            return 0;
        }
        return this.aioComboMap.get(str).get(str2).f356020d;
    }

    public int getRecordComboIndex(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this, (Object) str, (Object) str2)).intValue();
        }
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0 || this.aioComboMap.get(str) == null || this.aioComboMap.get(str).get(str2) == null) {
            return 0;
        }
        return this.aioComboMap.get(str).get(str2).f356021e;
    }

    public long getRecordComboSeq(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Long) iPatchRedirector.redirect((short) 17, (Object) this, (Object) str, (Object) str2)).longValue();
        }
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0 || this.aioComboMap.get(str) == null || this.aioComboMap.get(str).get(str2) == null) {
            return 0L;
        }
        return this.aioComboMap.get(str).get(str2).f356018b;
    }

    public long getRecordComboTime(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Long) iPatchRedirector.redirect((short) 16, (Object) this, (Object) str, (Object) str2)).longValue();
        }
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0 || this.aioComboMap.get(str) == null || this.aioComboMap.get(str).get(str2) == null) {
            return 0L;
        }
        return this.aioComboMap.get(str).get(str2).f356017a;
    }

    public long getRecordDoutuSeq(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Long) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str, (Object) str2)).longValue();
        }
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0 || this.aioMap.get(str) == null || this.aioMap.get(str).get(str2) == null) {
            return 0L;
        }
        return this.aioMap.get(str).get(str2).f356024b;
    }

    public long getRecordDoutuTime(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Long) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str, (Object) str2)).longValue();
        }
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0 || this.aioMap.get(str) == null || this.aioMap.get(str).get(str2) == null) {
            return 0L;
        }
        return this.aioMap.get(str).get(str2).f356023a;
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuService
    public void handleCombo(List<com.tencent.qqnt.doutu.d> list, int i3) {
        boolean z16;
        long j3;
        int i16;
        long j16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, (Object) list, i3);
            return;
        }
        if (isComboOpen() && list != null) {
            boolean z17 = true;
            if (list.size() >= 1) {
                int i17 = 0;
                String valueOf = String.valueOf(list.get(0).f356103n);
                if (!TextUtils.equals(valueOf, this.mUin)) {
                    QLog.e(TAG, 1, "handleCombo uin not match, doutuList peerUin=", LogUtil.wrapLogUin(valueOf), ", mUin=", LogUtil.wrapLogUin(this.mUin));
                    return;
                }
                if (!this.mHasChatResumed) {
                    this.mPendingComboDoutuList = list;
                    return;
                }
                this.mPendingComboDoutuList = null;
                if (!needHandleCombo(list, i3)) {
                    return;
                }
                long recordComboTime = getRecordComboTime(this.mUin, this.mUinType);
                int recordCombo = getRecordCombo(this.mUin, this.mUinType);
                long recordComboSeq = getRecordComboSeq(this.mUin, this.mUinType);
                int i18 = recordCombo;
                if (recordComboTime > 0) {
                    int i19 = 0;
                    int i26 = 0;
                    z16 = false;
                    long j17 = recordComboTime;
                    while (true) {
                        if (i26 < list.size()) {
                            if (checkTime(list, i26)) {
                                return;
                            }
                            int i27 = i26;
                            c b16 = new c(list, i18, z16, i26).b();
                            if (b16.e()) {
                                i17 = i27;
                                break;
                            }
                            int a16 = b16.a();
                            z16 = b16.f();
                            int c16 = b16.c();
                            if (list.get(i27).f356090a < recordComboTime) {
                                j16 = list.get(i27).f356090a;
                            } else if (list.get(i27).f356090a == recordComboTime && recordComboSeq != 0 && list.get(i27).f356092c != 0 && list.get(i27).f356092c <= recordComboSeq) {
                                j16 = list.get(i27).f356090a;
                            } else {
                                j3 = recordComboTime;
                                if (list.get(i27).f356090a - j17 > this.comboKeepTime) {
                                    removeComboStamp(this.mUin, this.mUinType);
                                    i18 = 0;
                                    i17 = c16;
                                    break;
                                }
                                int i28 = a16 + 1;
                                i16 = i27;
                                recordComboStamp(this.mUin, this.mUinType, list.get(i27), i28, i27);
                                j16 = list.get(i16).f356090a;
                                a16 = i28;
                                i26 = i16 + 1;
                                i19 = c16;
                                recordComboTime = j3;
                                i18 = a16;
                                j17 = j16;
                            }
                            j3 = recordComboTime;
                            i16 = i27;
                            i26 = i16 + 1;
                            i19 = c16;
                            recordComboTime = j3;
                            i18 = a16;
                            j17 = j16;
                        } else {
                            i17 = i19;
                            break;
                        }
                    }
                } else {
                    z16 = false;
                }
                if (i17 < list.size() - 1) {
                    i18 = checkCombo(list, this.mUin, this.mUinType, i17);
                }
                com.tencent.qqnt.doutu.d dVar = list.get(list.size() - 1);
                int handleTimeOut = handleTimeOut(i18, dVar);
                if (QLog.isDevelopLevel()) {
                    QLog.d(TAG, 4, "handleCombo \uff1a combo = " + handleTimeOut);
                }
                if (this.lastDoutuListSize == 0 || list.size() <= this.lastDoutuListSize) {
                    z17 = z16;
                }
                if (handleTimeOut > 0) {
                    handleDownRes();
                    reportCombo(list, handleTimeOut);
                }
                handleComboUI(handleTimeOut, z17, dVar);
                this.lastDoutuListSize = list.size();
                this.lastDoutuList = list;
                this.mPendingComboDoutuList = null;
            }
        }
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuService
    public void handleDownRes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this);
        } else if (!DuiButtonImageView.f355986m) {
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.qqnt.doutu.api.impl.DoutuServiceImpl.7
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DoutuServiceImpl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        DoutuServiceImpl.this.checkAndDownloadRes();
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            }, 5, null, true);
        }
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuService
    public int handleDui(List<com.tencent.qqnt.doutu.d> list) {
        int i3;
        char c16;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Integer) iPatchRedirector.redirect((short) 40, (Object) this, (Object) list)).intValue();
        }
        if (!isDoutuOpen() || list == null) {
            return -1;
        }
        long recordDoutuTime = getRecordDoutuTime(this.mUin, this.mUinType);
        int i16 = -1;
        if (recordDoutuTime > 0) {
            long j16 = recordDoutuTime;
            i3 = 0;
            int i17 = 0;
            while (true) {
                if (i3 < list.size()) {
                    long j17 = j16;
                    if (list.get(i3).f356090a <= 0) {
                        if (QLog.isColorLevel()) {
                            QLog.e(TAG, 2, "doutuList.get(i).time <= 0");
                        }
                        return -1;
                    }
                    if (list.get(i3).f356090a < recordDoutuTime) {
                        j3 = list.get(i3).f356090a;
                    } else {
                        if (list.get(i3).f356090a - j17 > this.doutuKeepTime) {
                            i16 = -1;
                            break;
                        }
                        recordDoutuStamp(this.mUin, this.mUinType, list.get(i3));
                        j3 = list.get(i3).f356090a;
                        if (!list.get(i3).f356091b) {
                            i16 = i3;
                        }
                    }
                    j16 = j3;
                    i17 = i3;
                    i3++;
                } else {
                    i3 = i17;
                    break;
                }
            }
        } else {
            i3 = 0;
        }
        if (i3 < list.size() - 1) {
            i16 = checkDui(list, this.mUin, this.mUinType, i3);
        }
        if (i16 >= 0 && i16 <= list.size() - 1) {
            com.tencent.qqnt.doutu.d dVar = list.get(list.size() - 1);
            com.tencent.qqnt.doutu.d dVar2 = list.get(i16);
            dVar2.f356101l = true;
            if (dVar.f356090a > 0 && NetConnInfoCenter.getServerTime() - dVar.f356090a > this.doutuKeepTime) {
                if (QLog.isDevelopLevel()) {
                    QLog.d(TAG, 2, "handleDui \uff1atoo long for doutuKeepTime ,set Dui false ! NetConnInfoCenter.getServerTime() = " + NetConnInfoCenter.getServerTime() + ", lastMsg.time = " + dVar.f356090a);
                }
                c16 = 0;
                dVar2.f356101l = false;
            } else {
                reportSendDoutuPic(dVar);
                if (!dVar2.f356093d && !dVar2.f356091b) {
                    c16 = 0;
                } else {
                    if (QLog.isDevelopLevel()) {
                        QLog.d(TAG, 2, "handleDui \uff1a duiMsg.isFlowMessage = " + dVar2.f356093d + ", duiMsg.isSend() = " + dVar2.f356091b);
                    }
                    c16 = 0;
                    dVar2.f356101l = false;
                }
            }
            if (QLog.isDevelopLevel()) {
                Object[] objArr = new Object[4];
                objArr[c16] = "[handleDui] duiIndex=";
                objArr[1] = Integer.valueOf(i16);
                objArr[2] = ", duiMsg.isDui=";
                objArr[3] = Boolean.valueOf(dVar2.f356101l);
                QLog.d(TAG, 4, objArr);
            }
            if (dVar2.f356101l) {
                if (i16 != this.lastReportDuiIndex) {
                    com.tencent.mobileqq.temp.report.a.a(this.mApp, "dc00898", "", "", "0X8008012", "0X8008012", 0, 0, "", "", "", "");
                    this.lastReportDuiIndex = i16;
                }
                handleDownRes();
                return i16;
            }
        }
        return -1;
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuService
    public synchronized void handleGetDoutuList(boolean z16, List<DoutuData> list) {
        URL url;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, Boolean.valueOf(z16), list);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleGetDoutuList : isSuccess = " + z16);
        }
        if (z16 && list != null && list.size() > 0) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "handleGetDoutuList : dataList.size() = " + list.size());
            }
            this.doutuListPreload.clear();
            Iterator<DoutuData> it = list.iterator();
            while (it.hasNext()) {
                this.doutuListPreload.add(it.next());
            }
            persistDoutuData(this.doutuListPreload);
            if (this.mDoutuAdapter != null && this.doutuListShowing.size() == 0) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "add data to doutuListShowing");
                }
                moveDataToShowing();
                this.mDoutuAdapter.f356027e = new ArrayList();
                this.mDoutuAdapter.f356027e.addAll(this.doutuListShowing);
                this.doutuListPreload.clear();
                dropPersistDoutuData();
                this.mDoutuAdapter.d();
                MqqHandler mqqHandler = this.mDoutuAdapter.G;
                if (mqqHandler != null) {
                    mqqHandler.sendEmptyMessage(83);
                }
            }
            if (this.doutuListPreload.size() > 0) {
                for (int i3 = 0; i3 < 9 && i3 < this.doutuListPreload.size(); i3++) {
                    DoutuData doutuData = this.doutuListPreload.get(i3);
                    if (doutuData != null) {
                        try {
                            String str = doutuData.thumbDownUrl;
                            if (str.startsWith("https")) {
                                str = str.replaceFirst("https", "http");
                            }
                            url = new URL(str);
                        } catch (MalformedURLException e16) {
                            QLog.e(TAG, 1, "getView url exception e = " + e16.getMessage());
                            url = null;
                        }
                        if (url != null) {
                            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                            obtain.mExtraInfo = doutuData;
                            URLDrawable.getDrawable(url, obtain).startDownload();
                        }
                    }
                }
            }
        }
        this.status = 0;
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuService
    public void handleGetRecommendPicList(boolean z16, List<DoutuData> list, long j3) {
        boolean z17;
        URL url;
        int i3;
        int size;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, Boolean.valueOf(z16), list, Long.valueOf(j3));
            return;
        }
        if (this.requestCountMap.get(Long.valueOf(j3)) != null) {
            this.requestCountMap.get(Long.valueOf(j3)).f356044g++;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("handleGetRecommendPicList isSuccess:");
            sb5.append(z16);
            sb5.append(", key:");
            sb5.append(j3);
            sb5.append(", type:, responseCount:");
            if (this.requestCountMap.get(Long.valueOf(j3)) != null) {
                i3 = this.requestCountMap.get(Long.valueOf(j3)).f356044g;
            } else {
                i3 = 0;
            }
            sb5.append(i3);
            sb5.append(", size:");
            if (list == null) {
                size = 0;
            } else {
                size = list.size();
            }
            sb5.append(size);
            QLog.i(TAG, 2, sb5.toString());
        }
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (int i16 = 0; i16 < list.size(); i16++) {
                DoutuData doutuData = list.get(i16);
                if (!TextUtils.isEmpty(doutuData.picMd5) && !this.dataMd5List.contains(doutuData.picMd5)) {
                    arrayList.add(doutuData);
                    this.dataMd5List.add(doutuData.picMd5);
                }
            }
        }
        if (arrayList.size() >= 0) {
            for (int i17 = 0; i17 < arrayList.size(); i17++) {
                DoutuData doutuData2 = (DoutuData) arrayList.get(i17);
                if (doutuData2 != null) {
                    try {
                        String str = doutuData2.thumbDownUrl;
                        if (str.startsWith("https")) {
                            str = str.replaceFirst("https", "http");
                        }
                        url = new URL(str);
                    } catch (MalformedURLException e16) {
                        QLog.e(TAG, 1, "getView url exception e = " + e16.getMessage());
                        url = null;
                    }
                    if (url != null) {
                        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                        obtain.mExtraInfo = doutuData2;
                        URLDrawable.getDrawable(url, obtain).startDownload();
                    }
                }
            }
        }
        if (this.requestCountMap.get(Long.valueOf(j3)) != null && this.requestCountMap.get(Long.valueOf(j3)).f356044g >= 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        com.tencent.qqnt.doutu.b bVar = this.mDoutuAdapter;
        if (bVar != null && bVar.L == j3) {
            ThreadManager.getUIHandler().post(new Runnable(z16, arrayList, z17, j3) { // from class: com.tencent.qqnt.doutu.api.impl.DoutuServiceImpl.5
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ boolean f356003d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ List f356004e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ boolean f356005f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ long f356006h;

                {
                    this.f356003d = z16;
                    this.f356004e = arrayList;
                    this.f356005f = z17;
                    this.f356006h = j3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, DoutuServiceImpl.this, Boolean.valueOf(z16), arrayList, Boolean.valueOf(z17), Long.valueOf(j3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (DoutuServiceImpl.this.mDoutuAdapter != null) {
                        if (this.f356003d && this.f356004e.size() >= 0) {
                            DoutuServiceImpl.this.mDoutuAdapter.b(this.f356004e, this.f356005f, this.f356006h);
                        } else if (this.f356005f) {
                            DoutuServiceImpl.this.mDoutuAdapter.c(this.f356006h);
                        }
                    }
                }
            });
        }
        if (z17) {
            this.requestCountMap.remove(Long.valueOf(j3));
        }
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuService
    public void handleGetRecommendPicTimeOut(long j3) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, j3);
            return;
        }
        if (this.requestCountMap.get(Long.valueOf(j3)) != null) {
            this.requestCountMap.get(Long.valueOf(j3)).f356044g++;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("handleGetRecommendPicTimeOut key:");
            sb5.append(j3);
            sb5.append(", smartCount:");
            if (this.requestCountMap.get(Long.valueOf(j3)) != null) {
                i3 = this.requestCountMap.get(Long.valueOf(j3)).f356044g;
            } else {
                i3 = 0;
            }
            sb5.append(i3);
            QLog.i(TAG, 2, sb5.toString());
        }
        if (this.requestCountMap.get(Long.valueOf(j3)) != null && this.requestCountMap.get(Long.valueOf(j3)).f356044g >= 1) {
            this.requestCountMap.remove(Long.valueOf(j3));
            com.tencent.qqnt.doutu.b bVar = this.mDoutuAdapter;
            if (bVar != null && bVar.L == j3) {
                ThreadManager.getUIHandler().post(new Runnable(j3) { // from class: com.tencent.qqnt.doutu.api.impl.DoutuServiceImpl.6
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ long f356007d;

                    {
                        this.f356007d = j3;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, DoutuServiceImpl.this, Long.valueOf(j3));
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        com.tencent.qqnt.doutu.b bVar2 = DoutuServiceImpl.this.mDoutuAdapter;
                        if (bVar2 != null) {
                            bVar2.c(this.f356007d);
                        }
                    }
                });
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return ((Boolean) iPatchRedirector.redirect((short) 50, (Object) this, (Object) message)).booleanValue();
        }
        switch (message.what) {
            case 81:
                com.tencent.mobileqq.temp.report.a.a(this.mApp, "dc00898", "", "", "0X8007FA8", "0X8007FA8", 0, 0, "", "", "", "");
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "[Doutu] handleMessage : MSG_SHOW_DOUTU_EMOTION_LAYOUT");
                }
                showDoutuEmotionLayout(this.mDoutuUIHandler, (com.tencent.qqnt.doutu.c) message.obj, R.id.inputBar);
                return true;
            case 82:
                hideDoutuEmotionLayout();
                return false;
            case 83:
                refreshDoutuEmoData();
                return false;
            default:
                return false;
        }
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuService
    public boolean hasInitedChatSession() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Boolean) iPatchRedirector.redirect((short) 39, (Object) this)).booleanValue();
        }
        return this.mHasInitedChatSession;
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuService
    public void hideDoutuEmotionLayout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        LinearLayout linearLayout = this.mDoutuLayout;
        if (linearLayout != null && linearLayout.getVisibility() == 0) {
            reportDoutuEventNew();
            this.mDoutuLayout.setVisibility(8);
            com.tencent.qqnt.doutu.c cVar = null;
            this.mDoutuLayout = null;
            this.mDoutuAdapter = null;
            this.doutuListShowing.clear();
            this.dataMd5List.clear();
            WeakReference<com.tencent.qqnt.doutu.c> weakReference = this.catchDoutuItem;
            if (weakReference != null && !weakReference.isEnqueued()) {
                com.tencent.qqnt.doutu.c cVar2 = this.catchDoutuItem.get();
                this.catchDoutuItem = null;
                cVar = cVar2;
            }
            preLoad(cVar, this.mUin, this.mUinType);
            IDoutuService.a aVar = this.mOnShowStateListener;
            if (aVar != null) {
                aVar.a(false);
            }
        }
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuService
    public void initChatSessionInfo(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (!TextUtils.equals(this.mUin, str) && QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "initChatSessionInfo uin=", LogUtil.wrapLogUin(str), ", uinType=", str2);
        }
        this.mUin = str;
        this.mUinType = str2;
        this.mHasInitedChatSession = true;
    }

    public void initComboUI() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this);
            return;
        }
        if (this.mHasInitedComboUI) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "init UI");
        }
        try {
            FragmentActivity requireActivity = this.mAIOContext.c().requireActivity();
            if (requireActivity == null) {
                QLog.e(TAG, 1, "initCombo error, activity is null!");
                return;
            }
            ViewGroup viewGroup = (ViewGroup) requireActivity.findViewById(this.mAioEmotionAnimaContainerResId);
            if (viewGroup == null) {
                QLog.e(TAG, 1, "initCombo error, contentView is null!");
                return;
            }
            BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
            if (!(baseQQAppInterface instanceof BaseQQAppInterface)) {
                QLog.e(TAG, 1, "initCombo error, app is not BaseQQAppInterface!");
                return;
            }
            this.mContentView = viewGroup;
            this.mApp = baseQQAppInterface;
            this.mComboUIManager = new com.tencent.qqnt.doutu.combo.b(baseQQAppInterface, requireActivity, this.mListener, viewGroup);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.doutu.api.impl.a
                @Override // java.lang.Runnable
                public final void run() {
                    DoutuServiceImpl.lambda$initComboUI$0();
                }
            }, 64, null, false);
            this.mHasInitedComboUI = true;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "initCombo error! ", th5);
        }
    }

    public synchronized void initData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "initData ");
        }
        List<DoutuData> readDoutuDataFromDB = readDoutuDataFromDB();
        if (readDoutuDataFromDB != null && readDoutuDataFromDB.size() > 0) {
            this.doutuListPreload.clear();
            Iterator<DoutuData> it = readDoutuDataFromDB.iterator();
            while (it.hasNext()) {
                this.doutuListPreload.add(it.next());
            }
        }
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuService
    public void interruptAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        com.tencent.qqnt.doutu.combo.b bVar = this.mComboUIManager;
        if (bVar != null) {
            bVar.f();
        }
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuService
    public boolean isCurrentAIOContact(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Boolean) iPatchRedirector.redirect((short) 38, (Object) this, (Object) str, (Object) str2)).booleanValue();
        }
        if (TextUtils.isEmpty(this.mUin) || TextUtils.isEmpty(this.mUinType)) {
            return true;
        }
        if (TextUtils.equals(this.mUin, str) && TextUtils.equals(this.mUinType, str2)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuService
    public boolean isDoutuConfigOpen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (!this.hasReadConfigFromSP) {
            readFromSP();
        }
        if (!this.doutuSwitch && !this.comboSwitch) {
            return false;
        }
        return true;
    }

    public boolean isDoutuOpen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        if (!this.hasReadConfigFromSP) {
            readFromSP();
        }
        if (this.doutuSwitch && this.doutuSettingSwitch) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuService
    public boolean isDoutuSettingOpen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (!this.hasReadConfigFromSP) {
            readFromSP();
        }
        return this.doutuSettingSwitch;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
        } else if (com.tencent.qqnt.util.b.f362976b.isDebugVersion() && TextUtils.equals(MobileQQ.sMobileQQ.getPackageName(), "com.tencent.qqnt")) {
            initDebugConfig(appRuntime);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        this.mDoutuLayout = null;
        this.mDoutuAdapter = null;
        try {
            MqqHandler mqqHandler = this.mDoutuAnimationHandler;
            if (mqqHandler != null) {
                mqqHandler.removeCallbacksAndMessages(null);
            }
        } catch (Exception unused) {
        }
        this.mContentView = null;
        this.mApp = null;
        this.mDoutuAnimationHandler = null;
        this.mListener = null;
        com.tencent.qqnt.doutu.combo.b bVar = this.mComboUIManager;
        if (bVar != null) {
            bVar.j();
            this.mComboUIManager = null;
        }
        MqqHandler mqqHandler2 = this.mDoutuUIHandler;
        if (mqqHandler2 != null) {
            mqqHandler2.removeCallbacksAndMessages(null);
            this.mDoutuUIHandler = null;
        }
    }

    public void postGetDoutuList(com.tencent.qqnt.doutu.c cVar, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, cVar, str, str2);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.i(TAG, 2, "postGetDoutuList error, app is null!");
        } else {
            ThreadManagerV2.post(new Runnable(peekAppRuntime, str, str2, cVar) { // from class: com.tencent.qqnt.doutu.api.impl.DoutuServiceImpl.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ AppRuntime f355994d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f355995e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ String f355996f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ com.tencent.qqnt.doutu.c f355997h;

                {
                    this.f355994d = peekAppRuntime;
                    this.f355995e = str;
                    this.f355996f = str2;
                    this.f355997h = cVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, DoutuServiceImpl.this, peekAppRuntime, str, str2, cVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i(DoutuServiceImpl.TAG, 2, "postGetDoutuList : run begin .");
                    }
                    try {
                        DoutuServiceImpl.this.status = 1;
                        NewIntent newIntent = new NewIntent(this.f355994d.getApp(), f.class);
                        newIntent.putExtra("KEY_CMD", 1);
                        DoutuServiceImpl.this.setRequestReportInfo(newIntent, this.f355995e, this.f355996f, this.f355997h);
                        DoutuServiceImpl.this.setCardInfo(newIntent, this.f355995e);
                        this.f355994d.startServlet(newIntent);
                    } catch (Throwable th5) {
                        QLog.e(DoutuServiceImpl.TAG, 1, "postGetDoutuList : error.", th5);
                        DoutuServiceImpl.this.status = 0;
                    }
                }
            }, 5, null, true);
        }
    }

    public void postGetRecommendPicList(com.tencent.qqnt.doutu.c cVar, String str, String str2, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, cVar, str, str2, Long.valueOf(j3));
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.i(TAG, 2, "postGetRecommendPicList error, app is null!");
        } else {
            ThreadManagerV2.post(new Runnable(cVar, j3, str2, str, peekAppRuntime) { // from class: com.tencent.qqnt.doutu.api.impl.DoutuServiceImpl.4
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ com.tencent.qqnt.doutu.c f355998d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ long f355999e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ String f356000f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ String f356001h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ AppRuntime f356002i;

                {
                    this.f355998d = cVar;
                    this.f355999e = j3;
                    this.f356000f = str2;
                    this.f356001h = str;
                    this.f356002i = peekAppRuntime;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, DoutuServiceImpl.this, cVar, Long.valueOf(j3), str2, str, peekAppRuntime);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i(DoutuServiceImpl.TAG, 2, "postGetRecommendPicList item:" + this.f355998d.toString() + ", timeKey:" + this.f355999e + ", uinType:" + this.f356000f + ", uin:" + this.f356001h);
                    }
                    NewIntent newIntent = new NewIntent(this.f356002i.getApp(), f.class);
                    DoutuServiceImpl.this.setRequestReportInfo(newIntent, this.f356001h, this.f356000f, this.f355998d);
                    newIntent.putExtra("KEY_MD5", this.f355998d.f356039b);
                    newIntent.putExtra("key_url", this.f355998d.f356041d);
                    newIntent.putExtra("KEY_CMD", 6);
                    newIntent.putExtra("key_sequence", this.f355999e);
                    DoutuServiceImpl.this.setCardInfo(newIntent, this.f356001h);
                    this.f356002i.startServlet(newIntent);
                }
            }, 5, null, true);
        }
    }

    public void recordComboStamp(String str, String str2, com.tencent.qqnt.doutu.d dVar, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, str, str2, dVar, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        long j3 = dVar.f356090a;
        long j16 = dVar.f356092c;
        if (str != null && str.length() != 0 && str2 != null && str2.length() != 0) {
            if (this.aioComboMap.get(str) != null) {
                this.aioComboMap.get(str).put(str2, new d(j3, j16, dVar.f356100k, i3, i16));
                return;
            }
            ConcurrentHashMap<String, d> concurrentHashMap = new ConcurrentHashMap<>();
            concurrentHashMap.put(str2, new d(j3, j16, dVar.f356100k, i3, i16));
            this.aioComboMap.put(str, concurrentHashMap);
        }
    }

    public void recordDoutuStamp(String str, String str2, com.tencent.qqnt.doutu.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, str, str2, dVar);
            return;
        }
        if (dVar.f356091b) {
            return;
        }
        long j3 = dVar.f356090a;
        long j16 = dVar.f356092c;
        if (str != null && str.length() != 0 && str2 != null && str2.length() != 0) {
            if (this.aioMap.get(str) != null) {
                this.aioMap.get(str).put(str2, new e(j3, j16));
                return;
            }
            ConcurrentHashMap<String, e> concurrentHashMap = new ConcurrentHashMap<>();
            concurrentHashMap.put(str2, new e(j3, j16));
            this.aioMap.put(str, concurrentHashMap);
        }
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuService
    public void refreshDoutuEmoData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        com.tencent.qqnt.doutu.b bVar = this.mDoutuAdapter;
        if (bVar != null) {
            bVar.notifyDataSetChanged();
        }
    }

    public void removeComboStamp(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (str != null && str.length() != 0 && str2 != null && str2.length() != 0 && this.aioComboMap.get(str) != null) {
            this.aioComboMap.get(str).remove(str2);
        }
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuService
    public void removeDoutuEmoLayout() {
        ViewGroup viewGroup;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        LinearLayout linearLayout = this.mDoutuLayout;
        if (linearLayout != null && (viewGroup = this.mContentView) != null) {
            viewGroup.removeView(linearLayout);
        }
    }

    public void reportDoutuEventNew() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        com.tencent.qqnt.doutu.b bVar = this.mDoutuAdapter;
        if (bVar == null) {
            return;
        }
        if (bVar.M == null && bVar.N == null) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.i(TAG, 2, "reportDoutuEventNew error, app is null!");
            return;
        }
        com.tencent.qqnt.doutu.e eVar = new com.tencent.qqnt.doutu.e();
        eVar.f356104a = "dc03631";
        e.a aVar = new e.a();
        aVar.f356106a = getCurrentAccountUin();
        com.tencent.qqnt.doutu.b bVar2 = this.mDoutuAdapter;
        DoutuData doutuData = bVar2.N;
        if (doutuData != null) {
            aVar.f356111f = doutuData.picMd5;
            aVar.f356112g = doutuData.picDownUrl;
        }
        com.tencent.qqnt.doutu.c cVar = bVar2.K;
        if (cVar != null) {
            aVar.f356108c = cVar.f356041d;
            aVar.f356107b = cVar.f356039b;
        }
        HashMap<String, String> hashMap = bVar2.M;
        if (hashMap != null && hashMap.size() > 0) {
            ArrayList<String> arrayList = new ArrayList<>();
            ArrayList<String> arrayList2 = new ArrayList<>();
            for (String str : this.mDoutuAdapter.M.keySet()) {
                arrayList.add(str);
                arrayList2.add(this.mDoutuAdapter.M.get(str));
            }
            aVar.f356109d = arrayList;
            aVar.f356110e = arrayList2;
        }
        String str2 = this.mDoutuAdapter.D;
        if (str2 != null) {
            int intValue = Integer.valueOf(str2).intValue();
            if (intValue == 0) {
                aVar.f356113h = "c2c";
            } else if (intValue == 1) {
                aVar.f356113h = VipFunCallConstants.KEY_GROUP;
            } else if (intValue == 3000) {
                aVar.f356113h = "discuss";
            } else {
                aVar.f356113h = "other";
            }
        }
        String str3 = this.mDoutuAdapter.C;
        if (str3 != null) {
            aVar.f356115j = str3;
        }
        aVar.f356114i = "android";
        eVar.f356105b = aVar;
        JSONObject a16 = eVar.a();
        NewIntent newIntent = new NewIntent(peekAppRuntime.getApp(), f.class);
        newIntent.putExtra("KEY_CMD", 5);
        newIntent.putExtra("key_report_content", a16.toString());
        com.tencent.qqnt.doutu.b bVar3 = this.mDoutuAdapter;
        bVar3.N = null;
        bVar3.M = null;
        peekAppRuntime.startServlet(newIntent);
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuService
    public void setApp(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) appRuntime);
        }
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuService
    public void setComboShowSwitch(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this, z16);
        } else {
            this.comboShowSwitch = z16;
        }
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuService
    public void setOnShowStateListener(IDoutuService.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this, (Object) aVar);
        } else {
            this.mOnShowStateListener = aVar;
        }
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuService
    public synchronized void showDoutuEmotionLayout(MqqHandler mqqHandler, com.tencent.qqnt.doutu.c cVar, int i3) {
        com.tencent.qqnt.doutu.b bVar;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, mqqHandler, cVar, Integer.valueOf(i3));
            return;
        }
        if (this.mContentView == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "showDoutuEmotionLayout : parentView is null.");
            }
            return;
        }
        if (cVar != null) {
            this.catchDoutuItem = new WeakReference<>(cVar);
        }
        DoutuEmotionHorizonListView doutuEmotionHorizonListView = getDoutuEmotionHorizonListView(mqqHandler, cVar, i3);
        if (this.lastTimeStamp <= 0 || System.currentTimeMillis() - this.lastTimeStamp <= 0 || System.currentTimeMillis() - this.lastTimeStamp >= 1000) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "showDoutuEmotionLayout : not frequency click.");
            }
            setDoutuAdapter(mqqHandler, cVar, doutuEmotionHorizonListView);
            this.lastTimeStamp = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("showDoutuEmotionLayout isSmartSwitchNew:");
                sb5.append(this.isSmartSwitchNew);
                sb5.append(", defaultCount:");
                sb5.append(this.defaultCount);
                sb5.append(", ");
                if (cVar != null) {
                    str = cVar.toString();
                } else {
                    str = "";
                }
                sb5.append(str);
                QLog.d(TAG, 2, sb5.toString());
            }
            if (cVar != null && cVar.a() && this.isSmartSwitchNew && (bVar = this.mDoutuAdapter) != null) {
                this.requestCountMap.put(Long.valueOf(bVar.L), new com.tencent.qqnt.doutu.c(this.mDoutuAdapter.L, 0));
                postGetRecommendPicList(cVar, this.mUin, this.mUinType, this.mDoutuAdapter.L);
            }
        }
        doutuEmotionHorizonListView.setScrollX(0);
        this.mContentView.setVisibility(0);
        this.mDoutuLayout.setVisibility(0);
        ((IReportControllerApi) com.tencent.qqnt.aio.adapter.a.b(IReportControllerApi.class)).reportWith898(null, "", "", "0X800B549", "0X800B549", 0, 0, "", "", "", "");
        com.tencent.mobileqq.temp.report.a.a(this.mApp, "dc00898", "", "", "0X8007FA9", "0X8007FA9", 0, 0, "", "", "", "");
        if (mqqHandler != null) {
            mqqHandler.removeMessages(82);
            mqqHandler.sendEmptyMessageDelayed(82, 5000L);
        }
        IDoutuService.a aVar = this.mOnShowStateListener;
        if (aVar != null) {
            aVar.a(true);
        }
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuService
    public void updataDoutuConfig(boolean z16, boolean z17, long j3, long j16, long j17, boolean z18, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Boolean.valueOf(z18), Integer.valueOf(i3));
            return;
        }
        this.doutuSwitch = z16;
        this.comboSwitch = z17;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[updataDoutuConfig] doutuSwitch=", Boolean.valueOf(z16), ", comboSwitch=", Boolean.valueOf(z17));
        }
        this.isSmartSwitchNew = z18;
        if (j3 > 0) {
            this.duiDuration = j3;
        }
        if (j16 > 0) {
            this.comboDuration = j16;
        }
        if (j17 > 0) {
            this.comboKeepTime = j17;
        }
        if (i3 > 0) {
            this.defaultCount = i3;
        }
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuService
    public void updateDoutuSetting(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
            return;
        }
        this.doutuSettingSwitch = z16;
        ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).updateDoutuSettingSwitch(BaseApplication.getContext(), getCurrentAccountUin(), z16);
        if (z16) {
            DuiButtonImageView.i();
        }
    }

    private boolean checkLocalResFiles(AppRuntime appRuntime, String str) {
        String str2 = IDoutuUtils.DOUTU_ANIMA_RES_PATH;
        File file = new File(str2);
        if (file.exists()) {
            if (!file.isDirectory()) {
                file.delete();
                return false;
            }
            if (((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).getDoutuResDamaged(appRuntime.getApp())) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "checkLocalResFiles : isDoutuResDamaged !");
                }
                FileUtils.delete(str2, false);
                return false;
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                File file2 = new File(str2 + DOUTU_RES_INFO_FILE_NAME);
                if (file2.exists() && !file2.isDirectory()) {
                    try {
                        String readFileToString = FileUtils.readFileToString(file2);
                        if (QLog.isColorLevel() && str != null && readFileToString != null) {
                            QLog.d(TAG, 2, "checkLocalResFiles: md5Record = " + readFileToString + ", md5 = " + str);
                        }
                        if (readFileToString != null && str != null && readFileToString.length() != 0 && str.length() != 0 && str.equals(readFileToString)) {
                            return true;
                        }
                        FileUtils.delete(str2, false);
                        return false;
                    } catch (IOException e16) {
                        e16.printStackTrace();
                        FileUtils.delete(IDoutuUtils.DOUTU_ANIMA_RES_PATH, false);
                        return false;
                    }
                }
                FileUtils.delete(str2, false);
                return false;
            }
            FileUtils.delete(str2, false);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCardInfo(NewIntent newIntent, String str) {
    }
}
