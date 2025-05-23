package com.tencent.mobileqq.portal;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import android.support.v4.util.SparseArrayCompat;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Xml;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.portal.RedPacketServlet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ac;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import com.tencent.util.LongSparseArray;
import com.tencent.util.notification.NotificationController;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes16.dex */
public class PortalManager implements Manager, Handler.Callback, BusinessObserver, INetEngineListener {
    static IPatchRedirector $redirector_;
    static long Y;
    static long Z;

    /* renamed from: a0, reason: collision with root package name */
    static long f259268a0;

    /* renamed from: b0, reason: collision with root package name */
    static int f259269b0;

    /* renamed from: c0, reason: collision with root package name */
    public static boolean f259270c0;

    /* renamed from: d0, reason: collision with root package name */
    public static final String f259271d0;

    /* renamed from: e0, reason: collision with root package name */
    private static Comparator<TimerConfig> f259272e0;

    /* renamed from: f0, reason: collision with root package name */
    private static TimerConfig f259273f0;

    /* renamed from: g0, reason: collision with root package name */
    static SimpleDateFormat f259274g0;

    /* renamed from: h0, reason: collision with root package name */
    public static long f259275h0;

    /* renamed from: i0, reason: collision with root package name */
    public static long f259276i0;

    /* renamed from: j0, reason: collision with root package name */
    private static long f259277j0;

    /* renamed from: k0, reason: collision with root package name */
    static final String[] f259278k0;
    private BannerConfig C;
    private BannerConfig D;
    private PortalConfig E;
    private PortalConfig F;
    private Context G;
    private Handler H;
    protected volatile RedPacketConfig I;
    private Handler J;
    private boolean K;
    private boolean L;
    public long M;
    Set<String> N;
    private IHttpEngineService P;
    private int Q;
    private int R;
    volatile long S;
    SparseArrayCompat<ArrayList<Long>> T;
    final ConcurrentHashMap<String, b> U;
    c V;
    private com.tencent.mobileqq.avatar.observer.a W;
    private long X;

    /* renamed from: d, reason: collision with root package name */
    private SoundPool f259279d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.olympic.a f259280e;

    /* renamed from: f, reason: collision with root package name */
    private long f259281f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f259282h;

    /* renamed from: i, reason: collision with root package name */
    SparseArrayCompat<ArrayList<Long>> f259283i;

    /* renamed from: m, reason: collision with root package name */
    private d f259284m;

    /* loaded from: classes16.dex */
    public static class AwardConfig implements Serializable {
        static IPatchRedirector $redirector_;
        public String addMsg;
        public int awardId;
        public String awardImg;
        public String awardMd5;
        public String awardMsg;
        public String awardTitle;
        public int awardType;
        public String ctfBgImg;
        public String ctfBgMd5;
        public int logoId;
        public String publicId;
        public String publicWording;
        public int showPublic;
        public String starImg;
        public String starMd5;

        public AwardConfig() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.awardTitle = "";
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "awardId=" + this.awardId + ", logoId=" + this.logoId + ", awardImg=" + this.awardImg + ", awardMd5=" + this.awardMd5 + ", starImg=" + this.starImg + ", starMD5=" + this.starMd5 + ", ctfBgImg=" + this.ctfBgImg + ", ctfBgMd5=" + this.ctfBgMd5 + ", showPublic=" + this.showPublic;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public static class BannerConfig extends TimerConfig {
        static IPatchRedirector $redirector_;
        public String bannarMd5;
        public String bannerImg;

        /* renamed from: id, reason: collision with root package name */
        public int f259293id;
        public String jumpUrl;
        public int useFlag;

        BannerConfig() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "id=" + this.f259293id + ", bannerImg=" + this.bannerImg + ", bannarMd5=" + this.bannarMd5 + ", jumpUrl=" + this.jumpUrl + ", useFlag=" + this.useFlag;
        }
    }

    /* loaded from: classes16.dex */
    public static class ComboNumber implements Serializable {
        static IPatchRedirector $redirector_;
        public String flowerImage2MD5;
        public String flowerImage2Url;
        public String flowerImageMD5;
        public String flowerImageUrl;
        public int number;
        public String numberImageMD5;
        public String numberImageUrl;

        public ComboNumber() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public String getCowJumpAnimFileName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.number + "_anim.png";
        }

        public String getFlowerImage1FileName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.number + "_flower1.png";
        }

        public String getFlowerImage2FileName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.number + "_flower2.png";
        }

        public String getNumberImageFileName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.number + "_number.png";
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return "number=" + this.number + ", numUrl=" + this.numberImageUrl + ", numMd5=" + this.numberImageMD5 + ", floUrl=" + this.flowerImageUrl + ", floMd5=" + this.flowerImageMD5 + ", flo2Url=" + this.flowerImage2Url + ", flo2Md5=" + this.flowerImage2MD5;
        }
    }

    /* loaded from: classes16.dex */
    public static class LogoConfig implements Serializable {
        static IPatchRedirector $redirector_;
        public String greetImageMD5;
        public String greetImageUrl;
        public int logoId;
        public String logoImageMD5;
        public String logoImageUrl;
        public String nameMD5;
        public String nameUrl;
        public String padantImageMD5;
        public String padantImageUrl;
        public String relationCompanyLogoMD5;
        public String relationCompanyLogoUrl;
        public String relationCompanyNameMD5;
        public String relationCompanyNameUrl;

        public LogoConfig() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "logoImageUrl=" + this.logoImageUrl + ", logoImageMD5=" + this.logoImageMD5 + ", nameUrl=" + this.nameUrl + ", nameMD5=" + this.nameMD5 + ", greetImageUrl=" + this.greetImageUrl + ", greetImageMD5=" + this.greetImageMD5 + ", padantImageUrl=" + this.padantImageUrl + ", padantImageMD5=" + this.padantImageMD5 + ", relationCompanyLogoUrl=" + this.relationCompanyLogoUrl + ", relationCompanyLogoMD5=" + this.relationCompanyLogoMD5 + ", relationCompanyNameUrl=" + this.relationCompanyNameUrl + ", relationCompanyNameMD5=" + this.relationCompanyNameMD5 + ", logoId=" + this.logoId;
        }
    }

    /* loaded from: classes16.dex */
    public static class PortalConfig extends TimerConfig {
        static IPatchRedirector $redirector_;
        public String actEndWording;
        public String activityTime;
        List<AwardConfig> awardConfigList;
        public String bgImg;
        public String bgMd5;
        public int cardCnt;
        public int continuousRecord;
        public String countDownTips;
        public int countGrab;
        public long countTime;
        public transient int currentCountGrab;
        public String emptyMsg;
        public String grabMsg;
        public int hbCnt;
        public String hotAddMsg;
        public String hotImg;
        public String hotMd5;
        public String hotPublicId;
        public String hotTopic;
        public String hotUrl;

        /* renamed from: id, reason: collision with root package name */
        public int f259294id;
        public boolean isHit;
        public String leftCloudImageMD5;
        public String leftCloudImageUrl;
        List<LogoConfig> logoList;
        public int mode;
        public String nextActTime;
        public long realBegin;
        public long realEnd;
        public String rightCloudImageMD5;
        public String rightCloudImageURL;
        public String rightMsg;
        public long scrollTime;
        public String shareImageMD5;
        public String shareImageUrl;
        public String shareStarImageMD5;
        public String shareStarImageUrl;
        public String shareWording;
        public long showSharePageTime;
        public String starGuiderPhotoMD5;
        public String starGuiderPhotoURL;
        public int starLucytype;
        public int starNoLucyType;
        public transient int starShareType;
        public transient int starShareTypeReqState;
        public String structMsgContentForScore;
        public String structMsgContentForStar;
        public String structMsgTitleForScore;
        public String structMsgTitleForStar;
        public String summaryForScore;
        public String summaryForStar;
        public int type;
        public int useFlag;
        public long useTime;
        public String wishingMsg;

        public PortalConfig() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.isHit = false;
            this.awardConfigList = new ArrayList();
            this.logoList = new ArrayList();
            this.starShareTypeReqState = 0;
            this.starShareType = -1;
            this.shareWording = "";
            this.summaryForStar = "";
            this.structMsgTitleForStar = "";
            this.structMsgContentForStar = "";
            this.summaryForScore = "";
            this.structMsgTitleForScore = "";
            this.structMsgContentForScore = "";
        }

        public AwardConfig findRealAwardConfigById(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (AwardConfig) iPatchRedirector.redirect((short) 4, (Object) this, j3);
            }
            List<AwardConfig> list = this.awardConfigList;
            if (list != null && !list.isEmpty()) {
                for (AwardConfig awardConfig : this.awardConfigList) {
                    if (awardConfig != null && awardConfig.awardId == j3) {
                        return awardConfig;
                    }
                }
            }
            return null;
        }

        public boolean isOver(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, j3)).booleanValue();
            }
            long j16 = this.useTime;
            if (j16 != 0 && j3 > j16 + this.countTime) {
                return true;
            }
            return false;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "id=" + this.f259294id + ", type=" + this.type + ", mode=" + this.mode + ", countTime=" + this.countTime + ", realBegin=" + this.realBegin + ", realEnd=" + this.realEnd + ", useFlag=" + this.useFlag + ", logoList=" + this.logoList + ", awardConfigList=" + this.awardConfigList + ", starLucytype=" + this.starLucytype + ", starNoLucyType=" + this.starNoLucyType + ", shareType=" + this.starShareType;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes16.dex */
    public static class RedPacketConfig implements Serializable {
        static IPatchRedirector $redirector_;
        public ArrayList<BannerConfig> bannerConfigs;
        public ArrayList<ComboNumber> comboNumberConfigs;
        public long grebInterval;

        /* renamed from: id, reason: collision with root package name */
        public int f259295id;
        public long lastGrabTime;
        public ArrayList<PortalConfig> portalConfigs;
        public long reportActiveInterval;
        public long reportNormalInterval;
        public int shareBaseLine;
        public long showGesturesTime;
        public int taskId;
        public int version;

        protected RedPacketConfig() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.grebInterval = -1L;
            this.reportActiveInterval = -1L;
            this.reportNormalInterval = -1L;
            this.lastGrabTime = 0L;
            this.showGesturesTime = 0L;
            this.portalConfigs = new ArrayList<>();
            this.bannerConfigs = new ArrayList<>();
            this.comboNumberConfigs = new ArrayList<>();
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "shareBaseLine=" + this.shareBaseLine + ", portalConfigs=" + this.portalConfigs + ", comboNumberConfigs=" + this.comboNumberConfigs + ", bannerConfigs=" + this.bannerConfigs;
        }
    }

    /* loaded from: classes16.dex */
    public class ReportRunnable implements Runnable {
        static IPatchRedirector $redirector_;
        private boolean C;

        /* renamed from: d, reason: collision with root package name */
        private int f259296d;

        /* renamed from: e, reason: collision with root package name */
        private SparseArrayCompat<ArrayList<Long>> f259297e;

        /* renamed from: f, reason: collision with root package name */
        private int f259298f;

        /* renamed from: h, reason: collision with root package name */
        private int f259299h;

        /* renamed from: i, reason: collision with root package name */
        private int f259300i;

        /* renamed from: m, reason: collision with root package name */
        private long f259301m;

        public ReportRunnable(SparseArrayCompat<ArrayList<Long>> sparseArrayCompat, int i3, int i16, int i17, int i18, long j3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, PortalManager.this, sparseArrayCompat, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Long.valueOf(j3), Boolean.valueOf(z16));
                return;
            }
            this.f259297e = sparseArrayCompat;
            this.f259296d = i3;
            this.f259298f = i16;
            this.f259299h = i17;
            this.f259300i = i18;
            this.f259301m = j3;
            this.C = z16;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z16;
            int i3;
            long j3;
            long nextInt;
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            SparseArrayCompat<ArrayList<Long>> sparseArrayCompat = this.f259297e;
            if (sparseArrayCompat != null && sparseArrayCompat.size() > 0) {
                for (int i17 = 0; i17 < this.f259297e.size(); i17++) {
                    ArrayList arrayList = new ArrayList(100);
                    LongSparseArray longSparseArray = new LongSparseArray(60);
                    int keyAt = this.f259297e.keyAt(i17);
                    Iterator<Long> it = this.f259297e.get(keyAt).iterator();
                    while (true) {
                        z16 = true;
                        if (!it.hasNext()) {
                            break;
                        }
                        Long next = it.next();
                        if (this.f259296d == 1) {
                            i16 = 1000;
                        } else {
                            i16 = 60000;
                        }
                        long j16 = i16;
                        long longValue = (next.longValue() / j16) * j16;
                        if (longSparseArray.get(longValue) != null) {
                            longSparseArray.put(longValue, Integer.valueOf(((Integer) longSparseArray.get(longValue)).intValue() + 1));
                        } else {
                            longSparseArray.put(longValue, 1);
                        }
                    }
                    int i18 = 0;
                    for (int i19 = 0; i19 < longSparseArray.size(); i19++) {
                        RedPacketServlet.BrashReportItem brashReportItem = new RedPacketServlet.BrashReportItem();
                        brashReportItem.time = longSparseArray.keyAt(i19);
                        brashReportItem.count = ((Integer) longSparseArray.get(r10)).intValue();
                        arrayList.add(brashReportItem);
                        i18 += brashReportItem.count;
                    }
                    Handler handler = PortalManager.this.H;
                    if (this.f259296d == 1) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    Message obtainMessage = handler.obtainMessage(14, keyAt, i3, arrayList);
                    if (this.f259296d == 1) {
                        Bundle bundle = new Bundle();
                        int i26 = this.f259298f;
                        if (i26 > 0) {
                            bundle.putInt("k_e_ctr", i26);
                        }
                        int i27 = this.f259299h;
                        if (i27 > 0) {
                            bundle.putInt("k_h_ctr", i27);
                        }
                        int i28 = this.f259300i;
                        if (i28 > 0) {
                            bundle.putInt("k_c_ctr", i28);
                        }
                        bundle.putLong("k_s_time", this.f259301m);
                        obtainMessage.setData(bundle);
                        if (QLog.isColorLevel()) {
                            QLog.d("PortalManager", 2, "reportRunnable " + this.f259298f + ", " + this.f259299h + ", " + this.f259300i + ", " + i18);
                        }
                    }
                    if (this.C) {
                        int i29 = obtainMessage.arg1;
                        if (obtainMessage.arg2 != 1) {
                            z16 = false;
                        }
                        RedPacketServlet.h(i29, arrayList, z16, obtainMessage.getData());
                    } else if (!PortalManager.this.K) {
                        if (this.f259296d == 1) {
                            j3 = PortalManager.Z;
                        } else {
                            j3 = PortalManager.f259268a0;
                        }
                        int i36 = (int) j3;
                        Handler handler2 = PortalManager.this.H;
                        if (i36 <= 0) {
                            nextInt = 0;
                        } else {
                            nextInt = new Random().nextInt(i36);
                        }
                        handler2.sendMessageDelayed(obtainMessage, nextInt);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public static class TimerConfig implements Serializable {
        static IPatchRedirector $redirector_;
        public long uiBegin;
        public long uiEnd;

        TimerConfig() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* loaded from: classes16.dex */
    class a implements Comparator<TimerConfig> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(TimerConfig timerConfig, TimerConfig timerConfig2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) timerConfig, (Object) timerConfig2)).intValue();
            }
            long j3 = timerConfig.uiBegin - timerConfig2.uiBegin;
            if (j3 > 0) {
                return 1;
            }
            if (j3 < 0) {
                return -1;
            }
            return 0;
        }
    }

    /* loaded from: classes16.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f259302a;

        /* renamed from: b, reason: collision with root package name */
        public int f259303b;

        /* renamed from: c, reason: collision with root package name */
        public String f259304c;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* loaded from: classes16.dex */
    private class c extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PortalManager.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            int intExtra = intent.getIntExtra("portal_type_key", -1);
            int intExtra2 = intent.getIntExtra("bc_seq", -1);
            String stringExtra = intent.getStringExtra("portal_agrs");
            if (QLog.isColorLevel()) {
                QLog.i("PortalManager", 2, "PortalSwictherReceiver, " + intent.getExtras());
            }
            int i3 = 1;
            try {
                switch (intExtra) {
                    case 1008:
                        if (TextUtils.isEmpty(stringExtra)) {
                            PortalManager.this.J(intExtra, intExtra2, null, -1, "params is null");
                            return;
                        }
                        JSONObject jSONObject = new JSONObject(stringExtra);
                        int i16 = jSONObject.getInt("type");
                        int i17 = jSONObject.getInt("count");
                        if (i16 != 1) {
                            if (i16 != 2) {
                                if (i16 == 3) {
                                    i3 = 3;
                                }
                            } else {
                                i3 = 2;
                            }
                        }
                        RedPacketServlet.b(i3, i17, intExtra, intExtra2);
                        return;
                    case 1009:
                        QQAppInterface v3 = PortalManager.this.v();
                        if (v3 == null) {
                            return;
                        }
                        if (TextUtils.isEmpty(stringExtra)) {
                            PortalManager.this.J(intExtra, intExtra2, null, -1, "params is null");
                            return;
                        }
                        String string = new JSONObject(stringExtra).getString("key");
                        if (TextUtils.isEmpty(string)) {
                            PortalManager.this.J(intExtra, intExtra2, null, -1, "key is null");
                            return;
                        }
                        String a16 = o.a(string);
                        Bitmap faceBitmap = v3.getFaceBitmap(a16, false);
                        if (faceBitmap != null) {
                            String c16 = o.c(faceBitmap);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("errorCode", 0);
                            jSONObject2.put("key", string);
                            jSONObject2.put("result", c16);
                            PortalManager.this.g(intExtra, jSONObject2.toString(), intExtra2);
                            return;
                        }
                        b bVar = new b();
                        bVar.f259304c = string;
                        bVar.f259303b = intExtra;
                        bVar.f259302a = intExtra2;
                        PortalManager.this.U.put(a16, bVar);
                        if (v3.getFaceBitmap(a16, true) == null && QLog.isColorLevel()) {
                            QLog.d("PortalManager", 2, "\u6635\u79f0\u4e3a" + ac.y(v3, String.valueOf(a16)) + "\uff0c\u672c\u5730\u4e0d\u5b58\u5728\u5934\u50cf\uff0ckey = " + string);
                            return;
                        }
                        return;
                    case 1010:
                        JSONObject jSONObject3 = new JSONObject();
                        JSONObject put = jSONObject3.put("errorCode", 0);
                        if (PortalManager.this.q() == -1) {
                            i3 = 0;
                        }
                        put.put("result", i3);
                        PortalManager.this.g(intExtra, jSONObject3.toString(), intExtra2);
                        return;
                    case 1011:
                        QQAppInterface v16 = PortalManager.this.v();
                        if (v16 == null) {
                            return;
                        }
                        if (TextUtils.isEmpty(stringExtra)) {
                            PortalManager.this.J(intExtra, intExtra2, null, -1, "params is null");
                            return;
                        }
                        JSONObject jSONObject4 = new JSONObject(stringExtra);
                        String string2 = jSONObject4.getString("key");
                        String z16 = ac.z(v16, o.a(string2));
                        if (!TextUtils.isEmpty(z16)) {
                            jSONObject4.put("errorCode", 0).put("result", z16).put("key", string2);
                        } else {
                            jSONObject4.put("errorCode", -1).put("key", string2);
                        }
                        PortalManager.this.g(intExtra, jSONObject4.toString(), intExtra2);
                        return;
                    default:
                        return;
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
                try {
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put("errorCode", -1);
                    PortalManager.this.g(intExtra, jSONObject5.toString(), intExtra2);
                } catch (JSONException e17) {
                    e17.printStackTrace();
                }
            } catch (Exception e18) {
                if (QLog.isColorLevel()) {
                    QLog.e("PortalManager", 2, "", e18);
                }
            }
        }
    }

    /* loaded from: classes16.dex */
    public static class d {
        static IPatchRedirector $redirector_;

        public d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this);
            }
        }

        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this);
            }
        }

        public boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
            }
            return false;
        }

        public boolean d(Bitmap bitmap, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bitmap, (Object) str)).booleanValue();
            }
            return false;
        }

        public boolean e(Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) bitmap)).booleanValue();
            }
            return false;
        }

        public boolean f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
            }
            return false;
        }

        public void g(long j3, int i3, Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6, Bitmap bitmap7, List<LogoConfig> list, String str, long j16, boolean z16, long j17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), Integer.valueOf(i3), bitmap, bitmap2, bitmap3, bitmap4, bitmap5, bitmap6, bitmap7, list, str, Long.valueOf(j16), Boolean.valueOf(z16), Long.valueOf(j17));
        }

        public void h(boolean z16, String str, e eVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, eVar);
            }
        }

        public void i(long j3, int i3, Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, String str, String str2, String str3, String str4, long j16, boolean z16, int i16, Bitmap bitmap4, Bitmap bitmap5, List<LogoConfig> list, List<ComboNumber> list2, Bitmap bitmap6, long j17, Bitmap bitmap7, Bitmap bitmap8) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, this, Long.valueOf(j3), Integer.valueOf(i3), bitmap, bitmap2, bitmap3, str, str2, str3, str4, Long.valueOf(j16), Boolean.valueOf(z16), Integer.valueOf(i16), bitmap4, bitmap5, list, list2, bitmap6, Long.valueOf(j17), bitmap7, bitmap8);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73651);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 30)) {
            redirector.redirect((short) 30);
            return;
        }
        Y = 2500L;
        Z = 180000L;
        f259268a0 = 180000L;
        f259269b0 = 1;
        f259270c0 = false;
        f259271d0 = File.separator + "redPacketRes/";
        f259272e0 = new a();
        f259273f0 = new TimerConfig();
        f259274g0 = null;
        f259275h0 = 0L;
        f259276i0 = 0L;
        f259277j0 = 0L;
        f259278k0 = new String[]{"2016-12-13", "2016-12-14", "2017-1-20", "2017-1-27", "2017-1-28"};
    }

    public PortalManager(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f259281f = 0L;
        this.f259282h = false;
        this.f259283i = new SparseArrayCompat<>(1);
        this.L = false;
        this.M = 0L;
        this.N = Collections.synchronizedSet(new HashSet());
        this.Q = 0;
        this.R = 0;
        this.S = 0L;
        this.T = new SparseArrayCompat<>(100);
        this.U = new ConcurrentHashMap<>(1000);
        this.W = new com.tencent.mobileqq.avatar.observer.a() { // from class: com.tencent.mobileqq.portal.PortalManager.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PortalManager.this);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.avatar.observer.a
            public void onUpdateCustomHead(boolean z16, String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), str);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("PortalManagerhead", 2, "onUpdateCustomHead isSuccess = " + z16 + ", mobileNumber = " + str);
                }
                if (PortalManager.this.U.containsKey(str)) {
                    ThreadManager.getSubThreadHandler().post(new Runnable(str, z16) { // from class: com.tencent.mobileqq.portal.PortalManager.4.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ String f259290d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ boolean f259291e;

                        {
                            this.f259290d = str;
                            this.f259291e = z16;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, this, AnonymousClass4.this, str, Boolean.valueOf(z16));
                            }
                        }

                        /* JADX WARN: Removed duplicated region for block: B:37:0x00d2  */
                        /* JADX WARN: Removed duplicated region for block: B:39:0x00e8  */
                        /* JADX WARN: Removed duplicated region for block: B:41:0x00f8  */
                        @Override // java.lang.Runnable
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                QQAppInterface v3 = PortalManager.this.v();
                                if (v3 == null) {
                                    return;
                                }
                                b bVar = PortalManager.this.U.get(this.f259290d);
                                PortalManager.this.U.remove(this.f259290d);
                                if (this.f259291e) {
                                    boolean z17 = false;
                                    Bitmap faceBitmap = v3.getFaceBitmap(this.f259290d, false);
                                    if (faceBitmap != null) {
                                        String c16 = o.c(faceBitmap);
                                        JSONObject jSONObject = new JSONObject();
                                        try {
                                            try {
                                                jSONObject.put("errorCode", 0);
                                                jSONObject.put("key", bVar.f259304c);
                                                jSONObject.put("result", c16);
                                                if (QLog.isColorLevel()) {
                                                    QLog.d("PortalManagerhead", 2, "onUpdateCustomHead details.key = " + bVar.f259304c);
                                                }
                                                PortalManager.this.g(bVar.f259303b, jSONObject.toString(), bVar.f259302a);
                                                return;
                                            } catch (Throwable th5) {
                                                th = th5;
                                                z17 = true;
                                                if (QLog.isColorLevel()) {
                                                }
                                                if (!z17) {
                                                }
                                            }
                                        } catch (JSONException e16) {
                                            e16.printStackTrace();
                                            try {
                                                if (QLog.isColorLevel()) {
                                                    QLog.d("PortalManagerhead", 2, "error heppened info = " + jSONObject);
                                                }
                                                if (QLog.isColorLevel()) {
                                                    QLog.d("PortalManagerhead", 2, "onUpdateCustomHead details.key = " + bVar.f259304c);
                                                }
                                            } catch (Throwable th6) {
                                                th = th6;
                                                if (QLog.isColorLevel()) {
                                                    QLog.d("PortalManagerhead", 2, "onUpdateCustomHead details.key = " + bVar.f259304c);
                                                }
                                                if (!z17) {
                                                    PortalManager.this.g(bVar.f259303b, jSONObject.toString(), bVar.f259302a);
                                                    return;
                                                }
                                                throw th;
                                            }
                                        }
                                    }
                                }
                                PortalManager.this.J(bVar.f259303b, bVar.f259302a, null, -1, "get bitmap failed!");
                                return;
                            }
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                        }
                    });
                }
            }
        };
        this.X = 0L;
        this.G = BaseApplicationImpl.sApplication;
        this.H = new Handler(ThreadManagerV2.getSubThreadLooper(), this);
        this.J = new Handler(Looper.getMainLooper(), this);
        this.H.sendEmptyMessageDelayed(1, 5000L);
        this.V = new c();
        try {
            qQAppInterface.getApp().registerReceiver(this.V, new IntentFilter("com.tencent.portal.req.action"), "com.tencent.msg.permission.pushnotify", null);
        } catch (Exception e16) {
            QLog.e("PortalManager", 1, "", e16);
        }
        qQAppInterface.registObserver(this);
        qQAppInterface.addObserver(this.W);
    }

    private boolean A(String str) {
        if (!TextUtils.isEmpty(str) && !this.N.contains(str)) {
            if (!new File((MobileQQ.sMobileQQ.getApplicationContext().getFilesDir() + f259271d0) + str).exists()) {
                this.N.add(str);
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void B() {
        boolean z16;
        com.tencent.mobileqq.olympic.a aVar;
        if (this.f259280e == null) {
            this.f259280e = new com.tencent.mobileqq.olympic.a();
            int c16 = (int) ((com.tencent.mobileqq.utils.m.c() / 1024) / 1024);
            int screenWidth = ViewUtils.getScreenWidth();
            String featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.olympic_act_config.name());
            this.f259280e.f255100a = featureValue;
            boolean z17 = false;
            try {
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("PortalManager", 2, "loadDPCConfig Exception:" + e16.toString());
                }
            }
            if (featureValue.length() > 0) {
                String[] split = featureValue.split("\\|");
                if (split.length >= 9) {
                    if (c16 <= Integer.valueOf(split[0]).intValue()) {
                        this.f259280e.f255102c = true;
                    } else if (screenWidth <= Integer.valueOf(split[1]).intValue()) {
                        this.f259280e.f255102c = true;
                    } else if (screenWidth <= Integer.valueOf(split[2]).intValue()) {
                        this.f259280e.f255103d = true;
                    }
                    if (Integer.valueOf(split[3]).intValue() == 1) {
                        this.f259280e.f255104e = true;
                    }
                    this.f259280e.f255105f = Integer.valueOf(split[4]).intValue();
                    this.f259280e.f255106g = Integer.valueOf(split[5]).intValue();
                    this.f259280e.f255107h = Integer.valueOf(split[6]).intValue();
                    this.f259280e.f255108i = Integer.valueOf(split[7]).intValue();
                    this.f259280e.f255109j = Integer.valueOf(split[8]).intValue();
                    z16 = false;
                    aVar = this.f259280e;
                    aVar.f255101b = z16;
                    if (z16) {
                        if (c16 <= 512) {
                            aVar.f255102c = true;
                        } else if (screenWidth <= 480) {
                            aVar.f255102c = true;
                        } else if (screenWidth <= 720) {
                            aVar.f255103d = true;
                        }
                        aVar.f255104e = false;
                        aVar.f255105f = 0;
                        aVar.f255106g = 3;
                        aVar.f255107h = 1000;
                        aVar.f255108i = 1;
                        aVar.f255109j = 1;
                    }
                    if (aVar.f255108i == 1) {
                        z17 = true;
                    }
                    com.tencent.mobileqq.olympic.utils.a.i(z17);
                    if (!QLog.isColorLevel()) {
                        QLog.d("PortalManager", 2, "loadDPCConfig|featureValue:" + featureValue + ",systemTotalMem:" + c16 + ",screenWidth:" + screenWidth + ",isUseDefault:" + z16 + ",dpc:" + this.f259280e.toString());
                        return;
                    }
                    return;
                }
            }
            z16 = true;
            aVar = this.f259280e;
            aVar.f255101b = z16;
            if (z16) {
            }
            if (aVar.f255108i == 1) {
            }
            com.tencent.mobileqq.olympic.utils.a.i(z17);
            if (!QLog.isColorLevel()) {
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:1|(3:2|3|4)|(10:5|(5:(3:12|13|(6:15|(2:17|(2:(1:75)(2:25|(2:27|28)(2:30|(2:32|33)(2:34|(2:36|37)(2:38|(2:40|41)(2:42|(4:44|(1:46)|47|48)(2:49|(1:(2:52|53)(1:54))(2:55|(1:(2:58|59)(1:60))(2:61|(2:64|(2:66|67)(2:68|(2:70|71)(1:72)))))))))))|29)(2:21|22))|76|23|10|11)(2:77|(1:79)(7:80|81|(3:83|(1:(2:85|(4:(2:94|(1:96)(3:97|(2:99|100)(2:102|(2:104|105)(2:106|(2:108|109)(2:110|(2:112|113)(1:114))))|101))|115|116|101)(2:89|90))(1:117))|91)(2:118|(2:120|(1:(2:122|(5:(2:134|(1:136)(2:137|(1:139)(2:140|(1:142)(2:143|(1:145)(2:146|(1:148)(2:149|(1:151)(2:152|(1:154)(2:155|(1:157)(2:158|(1:160)(2:161|(1:163)(2:164|(1:166)(2:167|(1:169)(2:170|(1:172)(3:173|174|(3:176|(2:178|(3:184|(1:216)(2:186|(2:188|189)(2:191|(2:193|194)(2:195|(2:197|198)(2:199|(2:201|202)(2:203|(2:205|206)(2:207|(2:209|210)(2:211|(2:213|214)(1:215))))))))|190)(2:182|183))|217)(2:218|(3:220|(3:223|(3:229|(1:281)(2:231|(2:233|234)(2:236|(2:238|239)(2:240|(2:242|243)(2:244|(2:246|247)(2:248|(2:250|251)(2:252|(2:254|255)(2:256|(2:258|259)(2:260|(2:262|263)(2:264|(2:266|267)(2:268|(2:270|271)(2:272|(2:274|275)(2:276|(2:278|279)(1:280)))))))))))))|235)(2:227|228)|221)|282)(2:283|(1:285)(2:286|(1:288)(2:289|(1:291)(2:292|(1:294)(2:295|(1:297)(4:298|299|(5:301|(3:304|(3:312|(1:352)(2:314|(4:316|(1:318)|319|320)(2:322|(4:324|(1:326)|327|328)(2:329|(4:331|(1:333)|334|335)(2:336|(2:338|339)(2:340|(4:342|(1:344)|345|346)(2:347|(2:349|350)(1:351)))))))|321)|302)|353|354|355)(2:356|(3:358|(3:361|(3:368|(1:397)(2:370|(4:372|(1:374)|375|376)(2:378|(4:380|(1:382)|383|384)(2:385|(4:387|(1:389)|390|391)(2:392|(2:394|395)(1:396)))))|377)|359)|398)(1:399))|311)))))))))))))))))))))(0)|400|354|355|311)(3:126|127|(1:129)(2:130|(1:132)(0))))(1:401)))(0))|92|9|10|11)))|8|9|10|11)(1:418)|402|403|404|(1:406)(1:417)|407|408|(3:410|(1:412)(1:414)|413)|415)|419|420|(1:422)(1:500)|(6:425|426|(2:430|431)|433|(3:435|(4:437|(1:452)(5:441|442|443|444|(1:446))|447|448)(2:453|454)|449)|456)|459|460|461|462|(3:464|(2:465|(2:467|(3:478|479|(1:1)(1:482))(3:471|472|(2:474|475)(1:477))))|476)|485|486|(4:488|489|490|491)(1:497)|492|408|(0)|415|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:498:0x089d, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:499:0x089e, code lost:
    
        r3 = r15;
     */
    /* JADX WARN: Removed duplicated region for block: B:406:0x08ab  */
    /* JADX WARN: Removed duplicated region for block: B:410:0x08cf  */
    /* JADX WARN: Removed duplicated region for block: B:417:0x08c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static RedPacketConfig D(String str, int i3, int i16, ArrayList<Integer> arrayList) {
        String str2;
        String str3;
        Exception exc;
        String str4;
        String str5;
        int eventType;
        ComboNumber comboNumber;
        int i17;
        String str6;
        String str7;
        String str8;
        String str9;
        ComboNumber comboNumber2;
        String str10;
        String str11;
        String str12;
        String str13 = "Activity";
        String str14 = "BBanner";
        String str15 = "Common";
        String str16 = "parseConfig, ";
        String str17 = "PortalManager";
        XmlPullParser newPullParser = Xml.newPullParser();
        RedPacketConfig redPacketConfig = new RedPacketConfig();
        redPacketConfig.version = i3;
        redPacketConfig.taskId = i16;
        int i18 = 2;
        try {
            newPullParser.setInput(new ByteArrayInputStream(str.getBytes()), "UTF-8");
            eventType = newPullParser.getEventType();
            comboNumber = null;
        } catch (Exception e16) {
            e = e16;
            str2 = "parseConfig, ";
            str3 = "PortalManager";
        }
        while (true) {
            int i19 = 1;
            if (eventType == 1) {
                break;
            }
            if (eventType == i18) {
                try {
                    String name = newPullParser.getName();
                    int i26 = 3;
                    if (name.equalsIgnoreCase(str15)) {
                        for (int next = newPullParser.next(); next != 1; next = newPullParser.next()) {
                            String name2 = newPullParser.getName();
                            if (next == 3 && name2.equalsIgnoreCase(str15)) {
                                break;
                            }
                            if (next == i18) {
                                if (name2.equalsIgnoreCase("GrabReqInterval")) {
                                    redPacketConfig.grebInterval = Long.valueOf(newPullParser.nextText()).longValue();
                                } else if (name2.equalsIgnoreCase("ReportActiveInterval")) {
                                    redPacketConfig.reportActiveInterval = Long.valueOf(newPullParser.nextText()).longValue();
                                } else if (name2.equalsIgnoreCase("ReportNormalInterval")) {
                                    redPacketConfig.reportNormalInterval = Long.valueOf(newPullParser.nextText()).longValue();
                                } else if (name2.equalsIgnoreCase("ShareTimes")) {
                                    redPacketConfig.shareBaseLine = Integer.valueOf(newPullParser.nextText()).intValue();
                                } else if (name2.equalsIgnoreCase("ComboNumber")) {
                                    if (redPacketConfig.comboNumberConfigs == null) {
                                        redPacketConfig.comboNumberConfigs = new ArrayList<>();
                                    }
                                    ComboNumber comboNumber3 = new ComboNumber();
                                    redPacketConfig.comboNumberConfigs.add(comboNumber3);
                                    comboNumber = comboNumber3;
                                } else if (name2.equalsIgnoreCase("Number")) {
                                    if (comboNumber != null) {
                                        comboNumber.number = Integer.valueOf(newPullParser.nextText()).intValue();
                                    }
                                } else if (name2.equalsIgnoreCase("NumberImage")) {
                                    if (comboNumber != null) {
                                        Pair<String, String> u16 = u(newPullParser, name2);
                                        comboNumber.numberImageUrl = (String) u16.first;
                                        comboNumber.numberImageMD5 = (String) u16.second;
                                    }
                                } else if (name2.equalsIgnoreCase("FlowerImage") && comboNumber != null) {
                                    Pair<String, String> u17 = u(newPullParser, name2);
                                    if (TextUtils.isEmpty(comboNumber.flowerImageUrl)) {
                                        comboNumber.flowerImageUrl = (String) u17.first;
                                        comboNumber.flowerImageMD5 = (String) u17.second;
                                    } else if (TextUtils.isEmpty(comboNumber.flowerImage2Url)) {
                                        comboNumber.flowerImage2Url = (String) u17.first;
                                        comboNumber.flowerImage2MD5 = (String) u17.second;
                                    }
                                }
                            }
                        }
                        str10 = str13;
                        str7 = str14;
                        str8 = str15;
                        eventType = newPullParser.next();
                        str14 = str7;
                        str15 = str8;
                        str13 = str10;
                        i18 = 2;
                    } else if (name.equalsIgnoreCase("ConfigId")) {
                        redPacketConfig.f259295id = Integer.valueOf(newPullParser.nextText()).intValue();
                    } else {
                        if (name.equalsIgnoreCase(str14)) {
                            BannerConfig bannerConfig = new BannerConfig();
                            int next2 = newPullParser.next();
                            while (true) {
                                if (next2 == i19) {
                                    break;
                                }
                                String name3 = newPullParser.getName();
                                if (next2 == 3 && name3.equalsIgnoreCase(str14)) {
                                    redPacketConfig.bannerConfigs.add(bannerConfig);
                                    break;
                                }
                                if (next2 == i18) {
                                    if (name3.equalsIgnoreCase("Id")) {
                                        bannerConfig.f259293id = Integer.valueOf(newPullParser.nextText()).intValue();
                                    } else {
                                        if (name3.equalsIgnoreCase("Begin")) {
                                            str11 = str14;
                                            str12 = str15;
                                            bannerConfig.uiBegin = i(newPullParser.nextText());
                                        } else {
                                            str11 = str14;
                                            str12 = str15;
                                            if (name3.equalsIgnoreCase("End")) {
                                                bannerConfig.uiEnd = i(newPullParser.nextText());
                                            } else if (name3.equalsIgnoreCase("Image")) {
                                                Pair<String, String> u18 = u(newPullParser, name3);
                                                bannerConfig.bannerImg = (String) u18.first;
                                                bannerConfig.bannarMd5 = (String) u18.second;
                                            } else if (name3.equalsIgnoreCase("JumpH5")) {
                                                bannerConfig.jumpUrl = newPullParser.nextText();
                                            }
                                        }
                                        next2 = newPullParser.next();
                                        str14 = str11;
                                        str15 = str12;
                                        i19 = 1;
                                    }
                                }
                                str11 = str14;
                                str12 = str15;
                                next2 = newPullParser.next();
                                str14 = str11;
                                str15 = str12;
                                i19 = 1;
                            }
                            str7 = str14;
                            str8 = str15;
                        } else {
                            str7 = str14;
                            str8 = str15;
                            if (name.equalsIgnoreCase(str13)) {
                                PortalConfig portalConfig = new PortalConfig();
                                int next3 = newPullParser.next();
                                int i27 = 1;
                                while (true) {
                                    if (next3 == i27) {
                                        break;
                                    }
                                    String name4 = newPullParser.getName();
                                    if (next3 == i26 && name4.equalsIgnoreCase(str13)) {
                                        if (portalConfig.realEnd >= portalConfig.realBegin) {
                                            redPacketConfig.portalConfigs.add(portalConfig);
                                        } else if (QLog.isColorLevel()) {
                                            QLog.d("PortalManager", i18, "parseConfig" + portalConfig.realBegin + ", " + portalConfig.realEnd);
                                        }
                                    } else {
                                        if (next3 == i18) {
                                            if (name4.equalsIgnoreCase("Id")) {
                                                portalConfig.f259294id = Integer.valueOf(newPullParser.nextText()).intValue();
                                            } else if (name4.equalsIgnoreCase("Type")) {
                                                portalConfig.type = Integer.valueOf(newPullParser.nextText()).intValue();
                                            } else if (name4.equalsIgnoreCase("Mode")) {
                                                portalConfig.mode = Integer.valueOf(newPullParser.nextText()).intValue();
                                            } else if (name4.equalsIgnoreCase("BeginTime")) {
                                                long i28 = i(newPullParser.nextText());
                                                portalConfig.realBegin = i28;
                                                portalConfig.uiBegin = i28;
                                            } else if (name4.equalsIgnoreCase("EndTime")) {
                                                long i29 = i(newPullParser.nextText());
                                                portalConfig.realEnd = i29;
                                                portalConfig.uiEnd = i29;
                                            } else if (name4.equalsIgnoreCase("BackGroundImage")) {
                                                Pair<String, String> u19 = u(newPullParser, name4);
                                                portalConfig.bgImg = (String) u19.first;
                                                portalConfig.bgMd5 = (String) u19.second;
                                            } else if (name4.equalsIgnoreCase("activityTime")) {
                                                portalConfig.rightMsg = newPullParser.nextText();
                                            } else if (name4.equalsIgnoreCase("scrollTime")) {
                                                portalConfig.scrollTime = Integer.parseInt(newPullParser.nextText()) * 1000;
                                            } else if (name4.equalsIgnoreCase("Timer")) {
                                                portalConfig.countTime = Integer.parseInt(newPullParser.nextText()) * 1000;
                                            } else if (name4.equalsIgnoreCase("GrabWording")) {
                                                portalConfig.grabMsg = newPullParser.nextText();
                                            } else if (name4.equalsIgnoreCase("NoRPWording")) {
                                                portalConfig.emptyMsg = newPullParser.nextText();
                                            } else if (name4.equalsIgnoreCase("LeftCloudImage")) {
                                                Pair<String, String> u26 = u(newPullParser, name4);
                                                portalConfig.leftCloudImageUrl = (String) u26.first;
                                                portalConfig.leftCloudImageMD5 = (String) u26.second;
                                            } else if (name4.equalsIgnoreCase("RightCloudImage")) {
                                                Pair<String, String> u27 = u(newPullParser, name4);
                                                portalConfig.rightCloudImageURL = (String) u27.first;
                                                portalConfig.rightCloudImageMD5 = (String) u27.second;
                                            } else if (name4.equalsIgnoreCase("Logo")) {
                                                LogoConfig logoConfig = new LogoConfig();
                                                portalConfig.logoList.add(logoConfig);
                                                int next4 = newPullParser.next();
                                                int i36 = 1;
                                                while (next4 != i36) {
                                                    String name5 = newPullParser.getName();
                                                    if (next4 == i26 && name5.equalsIgnoreCase(name4)) {
                                                        break;
                                                    }
                                                    if (next4 == 2) {
                                                        if (name5.equalsIgnoreCase("LogoImage")) {
                                                            Pair<String, String> u28 = u(newPullParser, name5);
                                                            logoConfig.logoImageUrl = (String) u28.first;
                                                            logoConfig.logoImageMD5 = (String) u28.second;
                                                        } else if (name5.equalsIgnoreCase("logoId")) {
                                                            logoConfig.logoId = Integer.parseInt(newPullParser.nextText());
                                                        } else if (name5.equalsIgnoreCase("NameImage")) {
                                                            Pair<String, String> u29 = u(newPullParser, name5);
                                                            logoConfig.nameUrl = (String) u29.first;
                                                            logoConfig.nameMD5 = (String) u29.second;
                                                        } else if (name5.equalsIgnoreCase("GreetImage")) {
                                                            Pair<String, String> u36 = u(newPullParser, name5);
                                                            logoConfig.greetImageUrl = (String) u36.first;
                                                            logoConfig.greetImageMD5 = (String) u36.second;
                                                        } else if (name5.equalsIgnoreCase("padantImage")) {
                                                            Pair<String, String> u37 = u(newPullParser, name5);
                                                            logoConfig.padantImageUrl = (String) u37.first;
                                                            logoConfig.padantImageMD5 = (String) u37.second;
                                                        } else if (name5.equalsIgnoreCase("relationCompanyLogo")) {
                                                            Pair<String, String> u38 = u(newPullParser, name5);
                                                            logoConfig.relationCompanyLogoUrl = (String) u38.first;
                                                            logoConfig.relationCompanyLogoMD5 = (String) u38.second;
                                                        } else if (name5.equalsIgnoreCase("relationCompanyNameImage")) {
                                                            Pair<String, String> u39 = u(newPullParser, name5);
                                                            logoConfig.relationCompanyNameUrl = (String) u39.first;
                                                            logoConfig.relationCompanyNameMD5 = (String) u39.second;
                                                        }
                                                    }
                                                    next4 = newPullParser.next();
                                                    i36 = 1;
                                                    i26 = 3;
                                                }
                                            } else if (name4.equalsIgnoreCase("Award")) {
                                                AwardConfig awardConfig = new AwardConfig();
                                                portalConfig.awardConfigList.add(awardConfig);
                                                for (int next5 = newPullParser.next(); next5 != 1; next5 = newPullParser.next()) {
                                                    String name6 = newPullParser.getName();
                                                    if (next5 == 3 && name6.equalsIgnoreCase(name4)) {
                                                        break;
                                                    }
                                                    if (next5 == 2) {
                                                        if (name6.equalsIgnoreCase("AwardId")) {
                                                            awardConfig.awardId = Integer.valueOf(newPullParser.nextText()).intValue();
                                                        } else if (name6.equalsIgnoreCase("logoId")) {
                                                            awardConfig.logoId = Integer.parseInt(newPullParser.nextText());
                                                        } else if (name6.equalsIgnoreCase("AwardLogoType")) {
                                                            awardConfig.awardType = Integer.valueOf(newPullParser.nextText()).intValue();
                                                        } else if (name6.equalsIgnoreCase("AwardLogo1Image")) {
                                                            Pair<String, String> u46 = u(newPullParser, name6);
                                                            awardConfig.awardImg = (String) u46.first;
                                                            awardConfig.awardMd5 = (String) u46.second;
                                                        } else if (name6.equalsIgnoreCase("AwardLogo2Image")) {
                                                            Pair<String, String> u47 = u(newPullParser, name6);
                                                            awardConfig.starImg = (String) u47.first;
                                                            awardConfig.starMd5 = (String) u47.second;
                                                        } else if (name6.equalsIgnoreCase("AwardLogoBGImage")) {
                                                            Pair<String, String> u48 = u(newPullParser, name6);
                                                            awardConfig.ctfBgImg = (String) u48.first;
                                                            awardConfig.ctfBgMd5 = (String) u48.second;
                                                        } else if (name6.equalsIgnoreCase("Grettings")) {
                                                            awardConfig.awardMsg = newPullParser.nextText();
                                                        } else if (name6.equalsIgnoreCase("AwardName")) {
                                                            awardConfig.awardTitle = newPullParser.nextText();
                                                        } else if (name6.equalsIgnoreCase("AddWording")) {
                                                            awardConfig.addMsg = newPullParser.nextText();
                                                        } else if (name6.equalsIgnoreCase("PublicId")) {
                                                            awardConfig.publicId = newPullParser.nextText();
                                                        } else if (name6.equalsIgnoreCase("showPublic")) {
                                                            awardConfig.showPublic = Integer.parseInt(newPullParser.nextText());
                                                        } else if (name6.equalsIgnoreCase("PublicWording")) {
                                                            awardConfig.publicWording = newPullParser.nextText();
                                                        }
                                                    }
                                                }
                                            } else if (name4.equalsIgnoreCase("NextActTime")) {
                                                portalConfig.nextActTime = newPullParser.nextText();
                                            } else if (name4.equalsIgnoreCase("ActEndWording")) {
                                                portalConfig.actEndWording = newPullParser.nextText();
                                            } else if (name4.equalsIgnoreCase("TipWording")) {
                                                portalConfig.countDownTips = newPullParser.nextText();
                                            } else if (name4.equalsIgnoreCase("StarLuckytype")) {
                                                portalConfig.starLucytype = Integer.parseInt(newPullParser.nextText());
                                            } else if (name4.equalsIgnoreCase("StarNoLuckytype")) {
                                                portalConfig.starNoLucyType = Integer.parseInt(newPullParser.nextText());
                                            } else {
                                                if (name4.equalsIgnoreCase("sharePhoto")) {
                                                    int next6 = newPullParser.next();
                                                    str9 = str13;
                                                    while (next6 != 1) {
                                                        String name7 = newPullParser.getName();
                                                        comboNumber2 = comboNumber;
                                                        if (next6 != 3 || !name7.equalsIgnoreCase(name4)) {
                                                            if (next6 == 2) {
                                                                if (name7.equalsIgnoreCase("summary")) {
                                                                    String nextText = newPullParser.nextText();
                                                                    if (TextUtils.isEmpty(nextText)) {
                                                                        nextText = "";
                                                                    }
                                                                    portalConfig.summaryForStar = nextText;
                                                                } else if (name7.equalsIgnoreCase("structMsgTitle")) {
                                                                    String nextText2 = newPullParser.nextText();
                                                                    if (TextUtils.isEmpty(nextText2)) {
                                                                        nextText2 = "";
                                                                    }
                                                                    portalConfig.structMsgTitleForStar = nextText2;
                                                                } else if (name7.equalsIgnoreCase("structMsgContent")) {
                                                                    String nextText3 = newPullParser.nextText();
                                                                    if (TextUtils.isEmpty(nextText3)) {
                                                                        nextText3 = "";
                                                                    }
                                                                    portalConfig.structMsgContentForStar = nextText3;
                                                                } else if (name7.equalsIgnoreCase("starPhoto")) {
                                                                    Pair<String, String> u49 = u(newPullParser, name7);
                                                                    portalConfig.shareStarImageUrl = (String) u49.first;
                                                                    portalConfig.shareStarImageMD5 = (String) u49.second;
                                                                } else if (name7.equalsIgnoreCase("ShareWording")) {
                                                                    String nextText4 = newPullParser.nextText();
                                                                    if (TextUtils.isEmpty(nextText4)) {
                                                                        nextText4 = "";
                                                                    }
                                                                    portalConfig.shareWording = nextText4;
                                                                } else if (name7.equalsIgnoreCase("starGuiderPhoto")) {
                                                                    Pair<String, String> u56 = u(newPullParser, name7);
                                                                    portalConfig.starGuiderPhotoURL = (String) u56.first;
                                                                    portalConfig.starGuiderPhotoMD5 = (String) u56.second;
                                                                }
                                                            }
                                                            next6 = newPullParser.next();
                                                            comboNumber = comboNumber2;
                                                        }
                                                    }
                                                    comboNumber2 = comboNumber;
                                                } else {
                                                    str9 = str13;
                                                    comboNumber2 = comboNumber;
                                                    if (name4.equalsIgnoreCase("shareScore")) {
                                                        for (int next7 = newPullParser.next(); next7 != 1; next7 = newPullParser.next()) {
                                                            String name8 = newPullParser.getName();
                                                            if (next7 != 3 || !name8.equalsIgnoreCase(name4)) {
                                                                if (next7 == 2) {
                                                                    if (name8.equalsIgnoreCase("summary")) {
                                                                        String nextText5 = newPullParser.nextText();
                                                                        if (TextUtils.isEmpty(nextText5)) {
                                                                            nextText5 = "";
                                                                        }
                                                                        portalConfig.summaryForScore = nextText5;
                                                                    } else if (name8.equalsIgnoreCase("structMsgTitle")) {
                                                                        String nextText6 = newPullParser.nextText();
                                                                        if (TextUtils.isEmpty(nextText6)) {
                                                                            nextText6 = "";
                                                                        }
                                                                        portalConfig.structMsgTitleForScore = nextText6;
                                                                    } else if (name8.equalsIgnoreCase("structMsgContent")) {
                                                                        String nextText7 = newPullParser.nextText();
                                                                        if (TextUtils.isEmpty(nextText7)) {
                                                                            nextText7 = "";
                                                                        }
                                                                        portalConfig.structMsgContentForScore = nextText7;
                                                                    } else if (name8.equalsIgnoreCase("shareIcon")) {
                                                                        Pair<String, String> u57 = u(newPullParser, name8);
                                                                        portalConfig.shareImageUrl = (String) u57.first;
                                                                        portalConfig.shareImageMD5 = (String) u57.second;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                next3 = newPullParser.next();
                                                str13 = str9;
                                                comboNumber = comboNumber2;
                                                i18 = 2;
                                                i27 = 1;
                                                i26 = 3;
                                            }
                                        }
                                        str9 = str13;
                                        comboNumber2 = comboNumber;
                                        next3 = newPullParser.next();
                                        str13 = str9;
                                        comboNumber = comboNumber2;
                                        i18 = 2;
                                        i27 = 1;
                                        i26 = 3;
                                    }
                                }
                            }
                        }
                        str10 = str13;
                        comboNumber = comboNumber;
                        eventType = newPullParser.next();
                        str14 = str7;
                        str15 = str8;
                        str13 = str10;
                        i18 = 2;
                    }
                } catch (Exception e17) {
                    exc = e17;
                    str2 = "parseConfig, ";
                    str3 = "PortalManager";
                }
            }
            str10 = str13;
            str7 = str14;
            str8 = str15;
            comboNumber = comboNumber;
            eventType = newPullParser.next();
            str14 = str7;
            str15 = str8;
            str13 = str10;
            i18 = 2;
            exc = e17;
            str2 = "parseConfig, ";
            str3 = "PortalManager";
            if (!QLog.isColorLevel()) {
                str4 = str3;
                QLog.e(str4, 2, "parseConfig " + str, exc);
            } else {
                str4 = str3;
            }
            redPacketConfig = null;
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str2);
                if (redPacketConfig != null) {
                    str5 = redPacketConfig.toString();
                } else {
                    str5 = "null";
                }
                sb5.append(str5);
                QLog.d(str4, 2, sb5.toString());
            }
            return redPacketConfig;
        }
        int size = redPacketConfig.portalConfigs.size();
        int i37 = 0;
        if (arrayList != null) {
            i17 = arrayList.size();
        } else {
            i17 = 0;
        }
        if (i17 != 0 && size > 0) {
            try {
                Collections.sort(redPacketConfig.portalConfigs, f259272e0);
                PortalConfig portalConfig2 = redPacketConfig.portalConfigs.get(0);
                if (portalConfig2 != null && portalConfig2.type == 2) {
                    portalConfig2.uiBegin = portalConfig2.realBegin + arrayList.get(0 % i17).intValue();
                    i37 = 1;
                }
                int i38 = 1;
                while (i38 < size) {
                    PortalConfig portalConfig3 = redPacketConfig.portalConfigs.get(i38);
                    if (portalConfig3.type == 2) {
                        portalConfig3.uiBegin = portalConfig3.realBegin + (arrayList.get(i37 % i17).intValue() * 1000);
                        if (portalConfig2 != null && portalConfig2.type == 1) {
                            long j3 = portalConfig2.realEnd;
                            str6 = str16;
                            str3 = str17;
                            try {
                                if (2000 + j3 >= portalConfig3.realBegin) {
                                    portalConfig2.uiEnd = j3 + (arrayList.get(i37 % i17).intValue() * 1000);
                                }
                            } catch (Exception e18) {
                                exc = e18;
                                str2 = str6;
                            }
                        } else {
                            str6 = str16;
                            str3 = str17;
                        }
                        i37++;
                    } else {
                        str6 = str16;
                        str3 = str17;
                    }
                    i38++;
                    portalConfig2 = portalConfig3;
                    str16 = str6;
                    str17 = str3;
                }
            } catch (Exception e19) {
                str3 = str17;
                exc = e19;
                str2 = str16;
            }
        }
        str6 = str16;
        str3 = str17;
        Collections.sort(redPacketConfig.portalConfigs, f259272e0);
        for (int size2 = redPacketConfig.bannerConfigs.size() - 1; size2 >= 0; size2--) {
            BannerConfig bannerConfig2 = redPacketConfig.bannerConfigs.get(size2);
            Iterator<PortalConfig> it = redPacketConfig.portalConfigs.iterator();
            while (true) {
                if (it.hasNext()) {
                    PortalConfig next8 = it.next();
                    long j16 = bannerConfig2.uiBegin;
                    long j17 = next8.realBegin;
                    if (j16 >= j17 && j16 < next8.realEnd) {
                        if (j16 == j17) {
                            bannerConfig2.uiBegin = next8.uiBegin;
                        }
                    } else if (next8.uiBegin > j16) {
                        break;
                    }
                }
            }
        }
        Collections.sort(redPacketConfig.bannerConfigs, f259272e0);
        if (QLog.isColorLevel()) {
            StringBuilder sb6 = new StringBuilder();
            str2 = str6;
            try {
                sb6.append(str2);
                sb6.append(arrayList);
                F(redPacketConfig, sb6.toString());
            } catch (Exception e26) {
                e = e26;
                exc = e;
                if (!QLog.isColorLevel()) {
                }
                redPacketConfig = null;
                if (QLog.isColorLevel()) {
                }
                return redPacketConfig;
            }
        } else {
            str2 = str6;
        }
        str4 = str3;
        if (QLog.isColorLevel()) {
        }
        return redPacketConfig;
    }

    public static Bitmap E(String str, int i3) {
        Bitmap bitmap;
        if (QLog.isColorLevel()) {
            QLog.d("PortalManager", 2, "preloadDrawableById, key=" + str + ", id=" + i3);
        }
        Bitmap bitmap2 = null;
        com.tencent.mobileqq.olympic.a aVar = null;
        bitmap2 = null;
        try {
            bitmap = (Bitmap) GlobalImageCache.sImageCache.get("red_packet_" + str);
        } catch (Exception e16) {
            e = e16;
        } catch (OutOfMemoryError e17) {
            e = e17;
        }
        try {
        } catch (Exception e18) {
            e = e18;
            bitmap2 = bitmap;
            if (QLog.isColorLevel()) {
                QLog.e("PortalManager", 2, "preloadDrawableById Exception", e);
            }
            return bitmap2;
        } catch (OutOfMemoryError e19) {
            e = e19;
            bitmap2 = bitmap;
            if (QLog.isColorLevel()) {
                QLog.e("PortalManager", 2, "preloadDrawableById OutOfMemoryError", e);
            }
            return bitmap2;
        }
        if (bitmap != null) {
            if (QLog.isColorLevel()) {
                QLog.d("PortalManager", 2, "preloadDrawableById, already exist");
            }
            return bitmap;
        }
        PortalManager portalManager = (PortalManager) BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.MGR_PORTAL);
        if (portalManager != null) {
            aVar = portalManager.f259280e;
        }
        Pair<Integer, Bitmap> j3 = j("", i3, aVar, 2);
        if (j3 != null) {
            bitmap2 = (Bitmap) j3.second;
        } else {
            bitmap2 = bitmap;
        }
        if (bitmap2 != null) {
            GlobalImageCache.sImageCache.put((MQLruCache<String, Object>) ("red_packet_" + str), (String) bitmap2);
        }
        return bitmap2;
    }

    private static void F(RedPacketConfig redPacketConfig, String str) {
        int size = redPacketConfig.bannerConfigs.size();
        int size2 = redPacketConfig.portalConfigs.size();
        StringBuilder sb5 = new StringBuilder(256);
        sb5.append(str);
        sb5.append(", ");
        sb5.append(redPacketConfig.f259295id);
        sb5.append(", ");
        sb5.append(redPacketConfig.version);
        sb5.append('[');
        for (int i3 = 0; i3 < size; i3++) {
            sb5.append(redPacketConfig.bannerConfigs.get(i3).f259293id);
            sb5.append(", ");
        }
        sb5.append(']');
        sb5.append(", ");
        sb5.append('[');
        for (int i16 = 0; i16 < size2; i16++) {
            sb5.append(redPacketConfig.portalConfigs.get(i16).f259294id);
            sb5.append(", ");
        }
        sb5.append(']');
        QLog.d("PortalManager", 2, sb5.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(RedPacketConfig redPacketConfig) {
        String str;
        Iterator<BannerConfig> it = redPacketConfig.bannerConfigs.iterator();
        boolean z16 = true;
        while (it.hasNext()) {
            z16 &= !A(it.next().bannarMd5);
        }
        ArrayList<ComboNumber> arrayList = redPacketConfig.comboNumberConfigs;
        if (arrayList != null) {
            Iterator<ComboNumber> it5 = arrayList.iterator();
            while (it5.hasNext()) {
                ComboNumber next = it5.next();
                z16 = z16 & (!A(next.flowerImageMD5)) & (!A(next.numberImageMD5)) & (!A(next.flowerImage2MD5));
            }
        }
        Iterator<PortalConfig> it6 = redPacketConfig.portalConfigs.iterator();
        boolean z17 = z16;
        while (it6.hasNext()) {
            PortalConfig next2 = it6.next();
            if (next2 != null) {
                boolean z18 = (!A(next2.bgMd5)) & z17 & (!A(next2.leftCloudImageMD5)) & (!A(next2.rightCloudImageMD5));
                List<LogoConfig> list = next2.logoList;
                if (list != null) {
                    Iterator<LogoConfig> it7 = list.iterator();
                    while (it7.hasNext()) {
                        if (it7.next() != null) {
                            z18 = z18 & (!A(r7.logoImageMD5)) & (!A(r7.nameMD5)) & (!A(r7.greetImageMD5)) & (!A(r7.padantImageMD5)) & (!A(r7.relationCompanyLogoMD5));
                        }
                    }
                }
                List<AwardConfig> list2 = next2.awardConfigList;
                if (list2 != null) {
                    Iterator<AwardConfig> it8 = list2.iterator();
                    while (it8.hasNext()) {
                        if (it8.next() != null) {
                            z18 = z18 & (!A(r7.awardMd5)) & (!A(r7.starMd5)) & (!A(r7.ctfBgMd5));
                        }
                    }
                }
                z17 = z18 & (!A(next2.shareStarImageMD5)) & (!A(next2.starGuiderPhotoMD5));
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("PortalManager", 2, "reportResCover ,resCover=" + z17);
        }
        if (z17) {
            str = "1";
        } else {
            str = "0";
        }
        String valueOf = String.valueOf(redPacketConfig.taskId);
        String valueOf2 = String.valueOf(redPacketConfig.version);
        ReportController.o(BaseApplicationImpl.getApplication().getRuntime(), "dc01440", "", "", "0X80078FA", "0X80078FA", 0, 0, str, valueOf, valueOf2, "");
        if (com.tencent.mobileqq.precover.a.a(this.G, "hongbao_17_res_cover")) {
            com.tencent.mobileqq.precover.a.f(this.G, "hongbao_17_res_cover");
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(NotificationController.Constants.CONFIG_VERSION, valueOf2);
            hashMap.put("cover", str);
            hashMap.put("taskid", valueOf);
            StatisticCollector.getInstance(this.G).collectPerformance(m(), "hongbao_res_precover", z17, 0L, 0L, hashMap, "", false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(int i3, int i16, String str, int i17, String str2) {
        if (TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("errorCode", i17);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("errorMsg", str2);
                }
                str = jSONObject.toString();
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        g(i3, str, i16);
    }

    private void N(RedPacketConfig redPacketConfig) {
        if (FileUtils.getAvailableInnernalMemorySize() < 1048576.0f) {
            return;
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        Iterator<BannerConfig> it = redPacketConfig.bannerConfigs.iterator();
        while (it.hasNext()) {
            BannerConfig next = it.next();
            if (next.uiEnd > serverTimeMillis && A(next.bannarMd5)) {
                k(next.f259293id, next.bannerImg, next.bannarMd5);
            }
        }
        ArrayList<ComboNumber> arrayList = redPacketConfig.comboNumberConfigs;
        if (arrayList != null) {
            Iterator<ComboNumber> it5 = arrayList.iterator();
            while (it5.hasNext()) {
                ComboNumber next2 = it5.next();
                if (A(next2.flowerImageMD5)) {
                    k(-101, next2.flowerImageUrl, next2.flowerImageMD5);
                }
                if (A(next2.numberImageMD5)) {
                    k(-101, next2.numberImageUrl, next2.numberImageMD5);
                }
                if (A(next2.flowerImage2MD5)) {
                    k(-101, next2.flowerImage2Url, next2.flowerImage2MD5);
                }
            }
        }
        Iterator<PortalConfig> it6 = redPacketConfig.portalConfigs.iterator();
        while (it6.hasNext()) {
            PortalConfig next3 = it6.next();
            if (next3 != null && (next3.uiEnd > serverTimeMillis || next3.realEnd > serverTimeMillis)) {
                if (A(next3.bgMd5)) {
                    k(next3.f259294id, next3.bgImg, next3.bgMd5);
                }
                if (A(next3.leftCloudImageMD5)) {
                    k(next3.f259294id, next3.leftCloudImageUrl, next3.leftCloudImageMD5);
                }
                if (A(next3.rightCloudImageMD5)) {
                    k(next3.f259294id, next3.rightCloudImageURL, next3.rightCloudImageMD5);
                }
                List<LogoConfig> list = next3.logoList;
                if (list != null) {
                    for (LogoConfig logoConfig : list) {
                        if (logoConfig != null) {
                            if (A(logoConfig.logoImageMD5)) {
                                k(next3.f259294id, logoConfig.logoImageUrl, logoConfig.logoImageMD5);
                            }
                            if (A(logoConfig.nameMD5)) {
                                k(next3.f259294id, logoConfig.nameUrl, logoConfig.nameMD5);
                            }
                            if (A(logoConfig.greetImageMD5)) {
                                k(next3.f259294id, logoConfig.greetImageUrl, logoConfig.greetImageMD5);
                            }
                            if (A(logoConfig.padantImageMD5)) {
                                k(next3.f259294id, logoConfig.padantImageUrl, logoConfig.padantImageMD5);
                            }
                            if (A(logoConfig.relationCompanyLogoMD5)) {
                                k(next3.f259294id, logoConfig.relationCompanyLogoUrl, logoConfig.relationCompanyLogoMD5);
                            }
                            if (A(logoConfig.relationCompanyNameMD5)) {
                                k(next3.f259294id, logoConfig.relationCompanyNameUrl, logoConfig.relationCompanyNameMD5);
                            }
                        }
                    }
                }
                List<AwardConfig> list2 = next3.awardConfigList;
                if (list2 != null) {
                    for (AwardConfig awardConfig : list2) {
                        if (awardConfig != null) {
                            if (A(awardConfig.awardMd5)) {
                                k(next3.f259294id, awardConfig.awardImg, awardConfig.awardMd5);
                            }
                            if (A(awardConfig.starMd5)) {
                                k(next3.f259294id, awardConfig.starImg, awardConfig.starMd5);
                            }
                            if (A(awardConfig.ctfBgMd5)) {
                                k(next3.f259294id, awardConfig.ctfBgImg, awardConfig.ctfBgMd5);
                            }
                        }
                    }
                }
                if (A(next3.shareStarImageMD5)) {
                    k(next3.f259294id, next3.shareStarImageUrl, next3.shareStarImageMD5);
                }
                if (A(next3.starGuiderPhotoMD5)) {
                    k(next3.f259294id, next3.starGuiderPhotoURL, next3.starGuiderPhotoMD5);
                }
            }
        }
        if (System.currentTimeMillis() - this.M > 1800000) {
            this.M = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                QLog.d("PortalManager", 2, "tryDownload needReport");
            }
            this.H.postDelayed(new Runnable(redPacketConfig) { // from class: com.tencent.mobileqq.portal.PortalManager.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ RedPacketConfig f259288d;

                {
                    this.f259288d = redPacketConfig;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) PortalManager.this, (Object) redPacketConfig);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        try {
                            PortalManager.this.H(this.f259288d);
                            return;
                        } catch (Throwable th5) {
                            if (QLog.isColorLevel()) {
                                QLog.d("PortalManager", 2, "report exception =" + th5.getMessage());
                                th5.printStackTrace();
                                return;
                            }
                            return;
                        }
                    }
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }, 60000L);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0049, code lost:
    
        if (r9.uiEnd < r1) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0082, code lost:
    
        if (r10.uiEnd < r1) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void O(long j3) {
        long j16;
        int i3;
        BannerConfig bannerConfig;
        BannerConfig bannerConfig2;
        int i16;
        PortalConfig portalConfig;
        long j17;
        int i17;
        int i18;
        int i19;
        int i26;
        long j18;
        RedPacketConfig redPacketConfig = this.I;
        if (redPacketConfig == null) {
            return;
        }
        long j19 = f259275h0;
        if (j19 > 0) {
            j16 = j19 + (f259277j0 * (j3 - f259276i0));
        } else {
            j16 = j3;
        }
        this.J.removeMessages(100);
        ArrayList<BannerConfig> arrayList = redPacketConfig.bannerConfigs;
        TimerConfig timerConfig = f259273f0;
        timerConfig.uiBegin = j16;
        int binarySearch = Collections.binarySearch(arrayList, timerConfig, f259272e0);
        if (binarySearch >= 0) {
            i3 = binarySearch + 1;
        } else {
            i3 = (-binarySearch) - 1;
        }
        PortalConfig portalConfig2 = null;
        if (i3 > 0 && i3 <= arrayList.size()) {
            bannerConfig = arrayList.get(i3 - 1);
        }
        bannerConfig = null;
        if (i3 < arrayList.size() && i3 >= 0) {
            bannerConfig2 = arrayList.get(i3);
        } else {
            bannerConfig2 = null;
        }
        ArrayList<PortalConfig> arrayList2 = redPacketConfig.portalConfigs;
        int binarySearch2 = Collections.binarySearch(arrayList2, f259273f0, f259272e0);
        if (binarySearch2 >= 0) {
            i16 = binarySearch2 + 1;
        } else {
            i16 = (-binarySearch2) - 1;
        }
        if (i16 > 0 && i16 <= arrayList2.size()) {
            portalConfig = arrayList2.get(i16 - 1);
        }
        portalConfig = null;
        if (i16 < arrayList2.size() && i16 >= 0) {
            portalConfig2 = arrayList2.get(i16);
        }
        this.C = bannerConfig;
        this.D = bannerConfig2;
        this.E = portalConfig;
        this.F = portalConfig2;
        if (bannerConfig != null) {
            j17 = bannerConfig.uiEnd;
        } else if (bannerConfig2 != null) {
            j17 = bannerConfig2.uiBegin;
        } else {
            j17 = Long.MAX_VALUE;
        }
        if (portalConfig != null) {
            long j26 = portalConfig.realEnd;
            if (j26 > j16 && j26 < j17) {
                j17 = j26;
            } else {
                long j27 = portalConfig.uiEnd;
                if (j27 > j16 && j27 < j17) {
                    j17 = j27;
                }
            }
            if (portalConfig.type == 2) {
                long j28 = j26 - portalConfig.countTime;
                if (j28 >= j16 && j28 < j17) {
                    if (QLog.isColorLevel()) {
                        QLog.d("PortalManager", 2, "updateCurrentTimer last minutes in, countTime = " + this.E.countTime + ", diffTime = " + j28 + ", timeout = " + j28);
                    }
                    j17 = j28;
                }
            }
            this.X = this.E.realEnd;
        } else if (portalConfig2 != null) {
            long j29 = portalConfig2.uiBegin;
            if (j29 < j17) {
                j17 = j29;
            }
        }
        if (j17 != Long.MAX_VALUE) {
            long j36 = 60000;
            if (j17 > j16) {
                j18 = j17 - j16;
            } else {
                j18 = 60000;
            }
            if (j18 <= 60000) {
                j36 = j18;
            }
            if (f259275h0 != 0) {
                j36 = 1000;
            }
            K(true, 100, j36, null);
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("updateCurrentTimer, ");
            BannerConfig bannerConfig3 = this.C;
            int i27 = -1;
            if (bannerConfig3 != null) {
                i17 = bannerConfig3.f259293id;
            } else {
                i17 = -1;
            }
            sb5.append(i17);
            sb5.append(", ");
            BannerConfig bannerConfig4 = this.D;
            if (bannerConfig4 != null) {
                i18 = bannerConfig4.f259293id;
            } else {
                i18 = -1;
            }
            sb5.append(i18);
            sb5.append(", ");
            PortalConfig portalConfig3 = this.E;
            if (portalConfig3 != null) {
                i19 = portalConfig3.f259294id;
            } else {
                i19 = -1;
            }
            sb5.append(i19);
            sb5.append(", ");
            PortalConfig portalConfig4 = this.F;
            if (portalConfig4 != null) {
                i26 = portalConfig4.f259294id;
            } else {
                i26 = -1;
            }
            sb5.append(i26);
            sb5.append(", ");
            sb5.append(j17);
            sb5.append(", ");
            PortalConfig portalConfig5 = this.E;
            if (portalConfig5 != null) {
                i27 = portalConfig5.useFlag;
            }
            sb5.append(i27);
            QLog.d("PortalManager", 2, sb5.toString());
        }
    }

    @SuppressLint({"UseSparseArrays"})
    private boolean P(RedPacketConfig redPacketConfig, RedPacketConfig redPacketConfig2, boolean z16) {
        int i3;
        boolean z17;
        int i16;
        int size = redPacketConfig.portalConfigs.size();
        int i17 = 0;
        if (redPacketConfig2 != null) {
            i3 = redPacketConfig2.portalConfigs.size();
        } else {
            i3 = 0;
        }
        if (redPacketConfig2 != null) {
            redPacketConfig.showGesturesTime = redPacketConfig2.showGesturesTime;
        }
        if (size > 0 && i3 > 0) {
            HashMap hashMap = new HashMap(i3);
            Iterator<PortalConfig> it = redPacketConfig2.portalConfigs.iterator();
            while (it.hasNext()) {
                PortalConfig next = it.next();
                hashMap.put(Integer.valueOf(next.f259294id), next);
            }
            Iterator<PortalConfig> it5 = redPacketConfig.portalConfigs.iterator();
            z17 = false;
            while (it5.hasNext()) {
                PortalConfig next2 = it5.next();
                PortalConfig portalConfig = (PortalConfig) hashMap.get(Integer.valueOf(next2.f259294id));
                if (portalConfig != null) {
                    int i18 = portalConfig.useFlag;
                    if (i18 != next2.useFlag) {
                        next2.useFlag = i18;
                        z17 = true;
                    }
                    long j3 = portalConfig.useTime;
                    if (j3 != next2.useTime) {
                        next2.useTime = j3;
                        z17 = true;
                    }
                    int i19 = portalConfig.countGrab;
                    if (i19 != next2.countGrab) {
                        next2.countGrab = i19;
                        z17 = true;
                    }
                    int i26 = portalConfig.continuousRecord;
                    if (i26 != next2.continuousRecord) {
                        next2.continuousRecord = i26;
                        z17 = true;
                    }
                }
            }
        } else {
            z17 = false;
        }
        int size2 = redPacketConfig.bannerConfigs.size();
        if (redPacketConfig2 != null) {
            i17 = redPacketConfig2.bannerConfigs.size();
        }
        if (size2 > 0 && i17 > 0) {
            HashMap hashMap2 = new HashMap(i17);
            Iterator<BannerConfig> it6 = redPacketConfig2.bannerConfigs.iterator();
            while (it6.hasNext()) {
                BannerConfig next3 = it6.next();
                hashMap2.put(Integer.valueOf(next3.f259293id), next3);
            }
            Iterator<BannerConfig> it7 = redPacketConfig.bannerConfigs.iterator();
            while (it7.hasNext()) {
                BannerConfig next4 = it7.next();
                BannerConfig bannerConfig = (BannerConfig) hashMap2.get(Integer.valueOf(next4.f259293id));
                if (bannerConfig != null && (i16 = bannerConfig.useFlag) != next4.useFlag) {
                    next4.useFlag = i16;
                    z17 = true;
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("PortalManager", 2, "updateUsedFlag, " + z17);
        }
        return z17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i3, String str, int i16) {
        String str2;
        if (QLog.isColorLevel()) {
            if (i3 == 1009) {
                try {
                    str2 = "get head returned , key = " + new JSONObject(str).getString("key");
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
                QLog.d("PortalManager", 2, "sendBroadcastRespData, " + i3 + ", " + i16 + ", " + str2);
            }
            str2 = str;
            QLog.d("PortalManager", 2, "sendBroadcastRespData, " + i3 + ", " + i16 + ", " + str2);
        }
        Intent intent = new Intent("com.tencent.portal.resp.action");
        intent.putExtra("portal_type_key", i3);
        Bundle bundle = new Bundle();
        bundle.putByteArray("bc_data", o.f(str));
        intent.putExtras(bundle);
        if (i16 > 0) {
            intent.putExtra("bc_seq", i16);
        }
        QQAppInterface v3 = v();
        if (v3 == null) {
            return;
        }
        v3.getApp().sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
    }

    public static long i(String str) {
        if (f259274g0 == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            f259274g0 = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(DateUtil.TIME_ZONE_8));
        }
        try {
            return f259274g0.parse(str).getTime();
        } catch (ParseException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("PortalManager", 2, "", e16);
            }
            return -1L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Pair<Integer, Bitmap> j(String str, int i3, com.tencent.mobileqq.olympic.a aVar, int i16) {
        Bitmap bitmap;
        boolean z16;
        boolean z17;
        long rowBytes;
        Pair<Integer, Bitmap> pair = null;
        if (TextUtils.isEmpty(str) && i3 < 0) {
            return null;
        }
        int i17 = 0;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            if (aVar != null) {
                options.inPurgeable = true;
                options.inInputShareable = true;
                if (aVar.f255104e) {
                    options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                } else {
                    options.inPreferredConfig = Bitmap.Config.RGB_565;
                    options.inDither = true;
                }
                if (aVar.f255102c) {
                    options.inSampleSize = 2;
                } else {
                    options.inSampleSize = 1;
                }
            } else {
                options.inPurgeable = true;
                options.inInputShareable = true;
                options.inSampleSize = 1;
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                options.inDither = true;
            }
            if (i16 == 1) {
                bitmap = BitmapFactory.decodeFile(str, options);
            } else if (i16 == 2) {
                bitmap = BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), i3, options);
            } else {
                bitmap = null;
            }
            z17 = false;
            z16 = false;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("PortalManager", 2, "decodeBitmap Exception:" + e16.toString() + ",filePath:" + str);
            }
            z17 = false;
            bitmap = null;
            z16 = true;
        } catch (OutOfMemoryError unused) {
            if (aVar != null && !aVar.f255102c) {
                aVar.f255102c = true;
                if (!aVar.f255103d) {
                    pair = j(str, i3, aVar, i16);
                    bitmap = (Bitmap) pair.second;
                    if (QLog.isColorLevel()) {
                        QLog.d("PortalManager", 2, "decodeBitmap OOM|path:" + str);
                    }
                    z16 = false;
                    z17 = true;
                }
            }
            bitmap = null;
            if (QLog.isColorLevel()) {
            }
            z16 = false;
            z17 = true;
        }
        if (pair != null) {
            if (((Integer) pair.first).intValue() == 0) {
                i17 = 1;
            } else {
                i17 = ((Integer) pair.first).intValue();
            }
        } else if (z17) {
            i17 = 2;
        } else if (z16) {
            i17 = 3;
        }
        if (bitmap == null && !z17 && !z16) {
            try {
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
                if (QLog.isColorLevel()) {
                    QLog.d("PortalManager", 2, "decodeBitmap| file.delete()");
                }
            } catch (Exception unused2) {
            }
        }
        Pair<Integer, Bitmap> pair2 = new Pair<>(Integer.valueOf(i17), bitmap);
        if (QLog.isColorLevel()) {
            if (bitmap == null) {
                rowBytes = 0;
            } else {
                rowBytes = (bitmap.getRowBytes() * bitmap.getHeight()) / 1024;
            }
            QLog.d("PortalManager", 2, "decodeBitmap|size:" + rowBytes + "KB,errCode:" + i17);
        }
        return pair2;
    }

    private void k(int i3, String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.i("PortalManager", 2, "downLoad, " + i3 + ", " + str + ", " + str2);
        }
        QQAppInterface v3 = v();
        if (v3 == null) {
            return;
        }
        if (this.P == null) {
            this.P = (IHttpEngineService) v3.getRuntimeService(IHttpEngineService.class, "all");
        }
        String str3 = v3.getApplication().getFilesDir() + f259271d0;
        HttpNetReq httpNetReq = new HttpNetReq();
        httpNetReq.mCallback = this;
        httpNetReq.mReqUrl = str;
        httpNetReq.mHttpMethod = 0;
        httpNetReq.mOutPath = str3 + str2;
        httpNetReq.mPrioty = 2;
        httpNetReq.setUserData(new String[]{String.valueOf(i3), str2});
        httpNetReq.mSupportBreakResume = true;
        this.P.sendReq(httpNetReq);
    }

    private String m() {
        QQAppInterface v3 = v();
        if (v3 != null) {
            return v3.getAccount();
        }
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap n(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("PortalManager", 2, "getBitmap, path=" + str + ", defaultPath=" + str2);
        }
        String str3 = BaseApplicationImpl.getApplication().getFilesDir() + f259271d0;
        Bitmap bitmap = null;
        try {
        } catch (Exception e16) {
            e = e16;
            if (QLog.isColorLevel()) {
            }
            return bitmap;
        }
        if (TextUtils.isEmpty(str)) {
            return t(str2, true);
        }
        String str4 = "red_packet_" + str;
        Bitmap bitmap2 = (Bitmap) GlobalImageCache.sImageCache.get(str4);
        if (bitmap2 != null) {
            try {
                if (QLog.isColorLevel()) {
                    QLog.d("PortalManager", 2, "getBitmap, hit cache");
                }
                return bitmap2;
            } catch (Exception e17) {
                e = e17;
                bitmap = bitmap2;
                if (QLog.isColorLevel()) {
                    QLog.d("PortalManager", 2, "", e);
                }
                return bitmap;
            }
        }
        try {
            Pair<Integer, Bitmap> j3 = j(str3 + str, -1, ((PortalManager) BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.MGR_PORTAL)).f259280e, 1);
            if (j3 != null) {
                bitmap2 = (Bitmap) j3.second;
            }
            bitmap = bitmap2;
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e("PortalManager", 2, "getBitmap, exception=" + th5.getMessage(), th5);
            }
        }
        if (bitmap != null) {
            GlobalImageCache.sImageCache.put((MQLruCache<String, Object>) str4, (String) bitmap);
            return bitmap;
        }
        bitmap = t(str2, true);
        if (QLog.isColorLevel()) {
            QLog.d("PortalManager", 2, "getBitmap, using default bitmap");
        }
        return bitmap;
    }

    public static Bitmap o(String str) {
        boolean z16;
        try {
            Bitmap bitmap = (Bitmap) GlobalImageCache.sImageCache.get("red_packet_" + str);
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("getBitmapFromCache, hit=");
                if (bitmap != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb5.append(z16);
                QLog.d("PortalManager", 2, sb5.toString());
            }
            return bitmap;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("PortalManager", 2, "preloadDrawableById Exception", e16);
                return null;
            }
            return null;
        }
    }

    private int p() {
        PortalConfig portalConfig = this.E;
        if (portalConfig != null && portalConfig.type == 2) {
            return portalConfig.continuousRecord;
        }
        return 0;
    }

    private RedPacketConfig r() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(30000);
        arrayList.add(20000);
        arrayList.add(10000);
        RedPacketConfig D = D("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<HappyFestival>\n    <ConfigId>113</ConfigId>\n    <Common>\n        <GrabReqInterval>2500</GrabReqInterval>\n        <ReportActiveInterval>0</ReportActiveInterval>\n        <ReportNormalInterval>180000</ReportNormalInterval>\n        <Combo>\n            <ShareTimes>1</ShareTimes>\n            <ComboNumberList>\n                <ComboNumber>\n                    <Number>8</Number>\n                    <NumberImage>\n                        <url>https://sola.gtimg.cn/aoi/sola/20200410152156_UqBMKwJGiv.png</url>\n                        <md5>deafadc7908ab67d63181bc368c7a490</md5>\n                    </NumberImage>\n                    <FlowerImage>\n                        <url>https://sola.gtimg.cn/aoi/sola/20200410152156_UqBMKwJGiv.png</url>\n                        <md5>deafadc7908ab67d63181bc368c7a490</md5>\n                    </FlowerImage>\n                    <FlowerImage>\n                        <url>https://sola.gtimg.cn/aoi/sola/20200410152156_UqBMKwJGiv.png</url>\n                        <md5>deafadc7908ab67d63181bc368c7a490</md5>\n                    </FlowerImage>\n                </ComboNumber>\n            </ComboNumberList>\n        </Combo>\n    </Common>\n    <Activity>\n        <Id>2034</Id>\n        <Type>2</Type>\n        <Mode>3</Mode>\n        <BeginTime>2020-11-10 14:00:00</BeginTime>\n        <EndTime>2020-12-11 23:30:00</EndTime>\n        <scrollTime>5</scrollTime>\n        <OnActivity>\n            <Timer>30</Timer>\n            <TipWording>\u62a2\u7ea2\u5305\u5012\u8ba1\u65f6</TipWording>\n            <GrabWording>\u8fde\u5237\u66f4\u5bb9\u6613\u5f97\u7ea2\u5305\uff01</GrabWording>\n            <NoRPWording>\u6ca1\u4e2d\uff01\u7ee7\u7eed\u5237\u8fd8\u6709\u673a\u4f1a\u3002</NoRPWording>\n            <LogoList>\n                <Logo>\n                    <logoId>1</logoId>\n                    <LogoImage>\n                        <url>https://sola.gtimg.cn/aoi/sola/20200410152156_UqBMKwJGiv.png</url>\n                        <md5>deafadc7908ab67d63181bc368c7a490</md5>\n                    </LogoImage>\n                    <Name>\u968f\u624b\u8bb0</Name>\n                    <NameImage>\n                        <url>https://sola.gtimg.cn/aoi/sola/20200410152156_UqBMKwJGiv.png</url>\n                        <md5>deafadc7908ab67d63181bc368c7a490</md5>\n                    </NameImage>\n                    <padantImage>\n                        <url>https://sola.gtimg.cn/aoi/sola/20200410152156_UqBMKwJGiv.png</url>\n                        <md5>deafadc7908ab67d63181bc368c7a490</md5>\n                    </padantImage>\n                </Logo>\n\n            </LogoList>\n            <NextActTime>23:40-23:59</NextActTime>\n            <AwardList>\n                <Award>\n                    <AwardId>2033</AwardId>\n                    <logoId>1</logoId>\n                    <AwardLogoType>1</AwardLogoType>\n                    <AwardLogo1Image>\n                        <url>https://sola.gtimg.cn/aoi/sola/20200410152156_UqBMKwJGiv.png</url>\n                        <md5>deafadc7908ab67d63181bc368c7a490</md5>\n                    </AwardLogo1Image>\n                    <AwardLogo2Image>\n                        <url>https://sola.gtimg.cn/aoi/sola/20200410152156_UqBMKwJGiv.png</url>\n                        <md5>deafadc7908ab67d63181bc368c7a490</md5>\n                    </AwardLogo2Image>\n                    <AwardLogoBGImage>\n                        <url>https://sola.gtimg.cn/aoi/sola/20200410152156_UqBMKwJGiv.png</url>\n                        <md5>deafadc7908ab67d63181bc368c7a490</md5>\n                    </AwardLogoBGImage>\n                    <AwardName>\u968f\u624b\u8bb0</AwardName>\n                    <Grettings>\u968f\u624b\u8bb0\u7ed9\u4f60\u53d1\u7ea2\u5305\u5566</Grettings>\n                    <AddWording>\u968f\u624b\u8bb0\u7ed9\u4f60\u53d1\u7ea2\u5305\u5566</AddWording>\n                    <showPublic>1</showPublic>\n                    <PublicId>2137362945</PublicId>\n                    <PublicWording>\u5173\u6ce8\u968f\u624b\u8bb0\u516c\u4f17\u53f7</PublicWording>\n                </Award>\n\n            </AwardList>\n            <EndRefresh>\n                <Starluckytype>1</Starluckytype>\n                <StarNoluckyType>1</StarNoluckyType>\n            </EndRefresh>\n            <Share>\n                <shareScore>\n                    <summary>QQ\u7ea2\u5305\u5f00\u62a2\u4e86\uff01\u6211\u5df2\u6210\u529f\u5237\u4e86%d\u6b21\uff0c\u8c01\u6bd4\u6211\u5389\u5bb3\uff01</summary>\n                    <structMsgTitle>\u4ebf\u4e07\u7ea2\u5305\u7b49\u4f60\u6765\u5237\uff01</structMsgTitle>\n                    <structMsgContent>QQ\u5237\u7ea2\u5305\uff0c\u6211\u5df2\u5237%d\u6b21\uff0c\u8c01\u6bd4\u6211\u5389\u5bb3\uff01</structMsgContent>\n                    <shareIcon>\n                        <url>https://sola.gtimg.cn/aoi/sola/20200410152156_UqBMKwJGiv.png</url>\n                        <md5>deafadc7908ab67d63181bc368c7a490</md5>\n                    </shareIcon>\n                </shareScore>\n            </Share>\n        </OnActivity>\n    </Activity>\n\n</HappyFestival>\n", 0, 0, arrayList);
        if (QLog.isColorLevel()) {
            QLog.d("PortalManager", 2, "getDebugRedPacketConfig  newConfig = " + D);
        }
        return D;
    }

    private static int s(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if ("hb_icon_path".equals(str)) {
            return R.drawable.eob;
        }
        if ("hb_name_path".equals(str)) {
            return R.drawable.eu9;
        }
        if ("hb_banner_path".equals(str)) {
            return -1;
        }
        if ("hb_yure_star_logo_path".equals(str)) {
            return R.drawable.f161761ev2;
        }
        if ("hb_yure_star_name_path".equals(str)) {
            return R.drawable.f161762ev3;
        }
        if ("hb_busi_logo_path".equals(str)) {
            return R.drawable.eu5;
        }
        if ("hb_yure_busi_name_path".equals(str)) {
            return R.drawable.eu6;
        }
        if ("hb_bg_name_path".equals(str)) {
            return R.drawable.nej;
        }
        if ("hb_leftclound_name_path".equals(str)) {
            return R.drawable.nep;
        }
        if (!"hb_rightclound_name_path".equals(str)) {
            return -1;
        }
        return R.drawable.neq;
    }

    public static Bitmap t(String str, boolean z16) {
        com.tencent.mobileqq.olympic.a aVar;
        try {
            if (QLog.isColorLevel()) {
                QLog.d("PortalManager", 2, "getDefaultIconBitmap", str);
            }
            Bitmap bitmap = (Bitmap) GlobalImageCache.sImageCache.get("red_packet_" + str);
            if (bitmap != null) {
                return bitmap;
            }
            int s16 = s(str);
            if (s16 < 0) {
                return null;
            }
            PortalManager portalManager = (PortalManager) BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.MGR_PORTAL);
            if (portalManager != null) {
                aVar = portalManager.f259280e;
            } else {
                aVar = null;
            }
            Pair<Integer, Bitmap> j3 = j("", s16, aVar, 2);
            if (j3 != null) {
                bitmap = (Bitmap) j3.second;
            }
            if (bitmap != null && z16) {
                GlobalImageCache.sImageCache.put((MQLruCache<String, Object>) ("red_packet_" + str), (String) bitmap);
            }
            return bitmap;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("PortalManager", 2, "", e16);
            }
            return null;
        } catch (OutOfMemoryError e17) {
            if (QLog.isColorLevel()) {
                QLog.e("PortalManager", 2, "", e17);
            }
            return null;
        }
    }

    public static Pair<String, String> u(XmlPullParser xmlPullParser, String str) throws Exception {
        String str2 = "";
        if (xmlPullParser == null) {
            return new Pair<>("", "");
        }
        int next = xmlPullParser.next();
        String str3 = "";
        while (next != 1) {
            String name = xmlPullParser.getName();
            if (next == 3 && name.equalsIgnoreCase(str)) {
                break;
            }
            if (next == 2) {
                if (name.equalsIgnoreCase("url")) {
                    str2 = xmlPullParser.nextText();
                } else if (name.equalsIgnoreCase("md5")) {
                    str3 = xmlPullParser.nextText();
                }
            }
            next = xmlPullParser.next();
        }
        return new Pair<>(str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public QQAppInterface v() {
        if (MobileQQ.sMobileQQ.peekAppRuntime() instanceof QQAppInterface) {
            return (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        }
        return null;
    }

    private String w() {
        return new File(this.G.getFilesDir(), "red_packet_config2017_" + m()).getAbsolutePath();
    }

    public static boolean z() {
        boolean z16;
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        if (f259270c0) {
            serverTimeMillis = System.currentTimeMillis();
        }
        long j3 = serverTimeMillis;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        int i3 = 1;
        int i16 = calendar.get(1);
        int i17 = calendar.get(2) + 1;
        int i18 = calendar.get(5);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
        Calendar calendar2 = Calendar.getInstance();
        Date date = null;
        int i19 = 0;
        while (true) {
            String[] strArr = f259278k0;
            if (i19 < strArr.length) {
                try {
                    date = simpleDateFormat.parse(strArr[i19]);
                } catch (ParseException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("PortalManager", 2, "isForbidAlert", e16);
                    }
                }
                if (date != null) {
                    calendar2.clear();
                    calendar2.setTime(date);
                    int i26 = calendar2.get(i3);
                    int i27 = calendar2.get(2) + i3;
                    int i28 = calendar2.get(5);
                    if (i16 == i26 && i17 == i27 && i18 == i28) {
                        z16 = true;
                        break;
                    }
                }
                i19++;
                i3 = 1;
            } else {
                z16 = false;
                break;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("PortalManager", 2, "isForbidAlert, current=" + j3 + ", bingo=" + z16 + ", DEBUG_GRAB=" + f259270c0);
        }
        return z16;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected RedPacketConfig C() {
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (RedPacketConfig) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        File file = new File(this.G.getFilesDir(), "red_packet_config2017_" + m());
        RedPacketConfig redPacketConfig = null;
        if (file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    objectInputStream = new ObjectInputStream(new BufferedInputStream(fileInputStream));
                } catch (Throwable th5) {
                    th = th5;
                    objectInputStream = null;
                }
            } catch (Throwable th6) {
                th = th6;
                fileInputStream = null;
                objectInputStream = null;
            }
            try {
                RedPacketConfig redPacketConfig2 = (RedPacketConfig) objectInputStream.readObject();
                try {
                    objectInputStream.close();
                } catch (IOException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("PortalManager", 2, "", e16);
                    }
                }
                try {
                    fileInputStream.close();
                } catch (IOException e17) {
                    if (QLog.isColorLevel()) {
                        QLog.e("PortalManager", 2, "", e17);
                    }
                }
                redPacketConfig = redPacketConfig2;
            } catch (Throwable th7) {
                th = th7;
                try {
                    if (QLog.isColorLevel()) {
                        QLog.e("PortalManager", 2, "", th);
                    }
                    if (redPacketConfig == null) {
                    }
                    if (QLog.isColorLevel()) {
                    }
                    if (this.I == null) {
                    }
                    return redPacketConfig;
                } finally {
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException e18) {
                            if (QLog.isColorLevel()) {
                                QLog.e("PortalManager", 2, "", e18);
                            }
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e19) {
                            if (QLog.isColorLevel()) {
                                QLog.e("PortalManager", 2, "", e19);
                            }
                        }
                    }
                }
            }
        }
        if (redPacketConfig == null) {
            new RedPacketConfig();
            redPacketConfig = r();
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("loadFromLocal, ");
            if (redPacketConfig != null) {
                str = redPacketConfig.toString();
            } else {
                str = "null";
            }
            sb5.append(str);
            QLog.d("PortalManager", 2, sb5.toString());
        }
        if (this.I == null) {
            K(true, 2, 0L, redPacketConfig);
        }
        return redPacketConfig;
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:114:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void G(d dVar, int i3, boolean z16, long j3) {
        boolean z17;
        long j16;
        ArrayList arrayList;
        boolean z18;
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        Bitmap bitmap4;
        Bitmap bitmap5;
        String str;
        long j17;
        String str2;
        Bitmap bitmap6;
        long j18;
        LogoConfig logoConfig;
        Bitmap bitmap7;
        Bitmap bitmap8;
        Bitmap bitmap9;
        Bitmap bitmap10;
        Bitmap n3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, dVar, Integer.valueOf(i3), Boolean.valueOf(z16), Long.valueOf(j3));
            return;
        }
        d dVar2 = this.f259284m;
        if (dVar2 == null) {
            return;
        }
        if (1 == (i3 & 1)) {
            BannerConfig bannerConfig = this.C;
            if (bannerConfig == null) {
                dVar2.a();
            } else if (bannerConfig != null && bannerConfig.useFlag < 2 && (n3 = n(bannerConfig.bannarMd5, "hb_banner_path")) != null && this.f259284m.d(n3, this.C.jumpUrl)) {
                this.C.useFlag = 2;
                z17 = true;
                if (2 == (i3 & 2)) {
                    if (this.E != null) {
                        long j19 = (this.I.version << 30) | this.E.f259294id;
                        if (j3 == 0) {
                            j16 = NetConnInfoCenter.getServerTimeMillis();
                        } else {
                            j16 = j3;
                        }
                        long j26 = f259275h0;
                        if (j26 > 0) {
                            j16 = j26 + (f259277j0 * (j16 - f259276i0));
                        }
                        Bitmap n16 = n(this.E.bgMd5, "hb_bg_name_path");
                        Bitmap n17 = n(this.E.leftCloudImageMD5, "hb_leftclound_name_path");
                        Bitmap n18 = n(this.E.rightCloudImageMD5, "hb_rightclound_name_path");
                        PortalConfig portalConfig = this.E;
                        long j27 = portalConfig.scrollTime;
                        if (j27 == 0) {
                            j27 = 3000;
                        }
                        long j28 = j27;
                        if (portalConfig.logoList.size() > 0 && this.E.mode == 3) {
                            ArrayList arrayList2 = new ArrayList(this.E.logoList);
                            Collections.shuffle(arrayList2);
                            arrayList = arrayList2;
                        } else {
                            arrayList = null;
                        }
                        PortalConfig portalConfig2 = this.E;
                        int i16 = portalConfig2.type;
                        if (i16 == 1) {
                            long j29 = portalConfig2.realEnd;
                            if (j16 <= j29) {
                                str2 = ",currentPortal.realEnd = ";
                                bitmap6 = n16;
                                j18 = -1;
                            } else {
                                long j36 = portalConfig2.uiEnd;
                                str2 = ",currentPortal.realEnd = ";
                                bitmap6 = n16;
                                j18 = Math.min(j36 - j16, j36 - j29);
                            }
                            PortalConfig portalConfig3 = this.E;
                            int i17 = portalConfig3.mode;
                            if (i17 == 1) {
                                LogoConfig logoConfig2 = portalConfig3.logoList.get(0);
                                Bitmap n19 = n(logoConfig2.logoImageMD5, "hb_yure_star_logo_path");
                                Bitmap n26 = n(logoConfig2.nameMD5, "hb_yure_star_name_path");
                                bitmap8 = n(logoConfig2.padantImageMD5, "hb_icon_path");
                                logoConfig = logoConfig2;
                                bitmap7 = n19;
                                bitmap9 = n26;
                            } else if (i17 == 2) {
                                logoConfig = portalConfig3.logoList.get(0);
                                bitmap7 = n(logoConfig.logoImageMD5, "hb_busi_logo_path");
                                bitmap9 = n(logoConfig.nameMD5, "hb_yure_busi_name_path");
                                bitmap8 = n(logoConfig.padantImageMD5, "hb_busi_logo_path");
                            } else {
                                logoConfig = null;
                                bitmap7 = null;
                                bitmap8 = null;
                                bitmap9 = null;
                            }
                            if (logoConfig != null) {
                                bitmap10 = n(logoConfig.greetImageMD5, null);
                            } else {
                                bitmap10 = null;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("PortalManager", 2, "refreshUi showPrepare ,countDown = " + j18 + ",serverTime = " + j16 + ",currentPortal.uiEnd = " + this.E.uiEnd + str2 + this.E.realEnd);
                            }
                            d dVar3 = this.f259284m;
                            PortalConfig portalConfig4 = this.E;
                            dVar3.g(j19, portalConfig4.mode, bitmap6, bitmap7, bitmap8, n17, n18, bitmap10, bitmap9, arrayList, portalConfig4.rightMsg, j18, z16, j28);
                            if (this.E.useFlag < 2 && !this.L && this.f259284m.f()) {
                                this.L = true;
                                this.E.useFlag = 2;
                                z18 = true;
                                z17 = z18;
                            }
                            z18 = z17;
                            z17 = z18;
                        } else {
                            if (i16 == 2) {
                                int i18 = portalConfig2.mode;
                                if (i18 == 1) {
                                    LogoConfig logoConfig3 = portalConfig2.logoList.get(0);
                                    Bitmap n27 = n(logoConfig3.logoImageMD5, "hb_icon_path");
                                    Bitmap n28 = n(logoConfig3.nameMD5, "hb_name_path");
                                    bitmap = n(logoConfig3.padantImageMD5, "hb_icon_path");
                                    Bitmap n29 = n(logoConfig3.relationCompanyLogoMD5, "hb_busi_logo_path");
                                    bitmap5 = n(logoConfig3.relationCompanyNameMD5, "hb_name_path");
                                    bitmap2 = n27;
                                    bitmap3 = n28;
                                    bitmap4 = n29;
                                } else {
                                    if (i18 == 2) {
                                        LogoConfig logoConfig4 = portalConfig2.logoList.get(0);
                                        bitmap2 = n(logoConfig4.logoImageMD5, "hb_busi_logo_path");
                                        Bitmap n36 = n(logoConfig4.nameMD5, "hb_name_path");
                                        bitmap = n(logoConfig4.padantImageMD5, "hb_busi_logo_path");
                                        bitmap3 = n36;
                                    } else {
                                        bitmap = null;
                                        bitmap2 = null;
                                        bitmap3 = null;
                                    }
                                    bitmap4 = null;
                                    bitmap5 = null;
                                }
                                PortalConfig portalConfig5 = this.E;
                                String str3 = portalConfig5.grabMsg;
                                String str4 = portalConfig5.actEndWording;
                                String str5 = portalConfig5.nextActTime;
                                String str6 = portalConfig5.countDownTips;
                                long j37 = j16;
                                long j38 = portalConfig5.useTime;
                                if (j38 > 0) {
                                    j17 = j37 - j38;
                                    str = str6;
                                    if (j17 > portalConfig5.countTime || j17 <= 0) {
                                        j17 = 0;
                                    }
                                } else {
                                    str = str6;
                                    if (j38 == 0 && j37 >= portalConfig5.realEnd - portalConfig5.countTime) {
                                        j17 = 0;
                                    } else {
                                        j17 = -1;
                                    }
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.d("PortalManager", 2, "refreshUI  ,serverTime = " + j37 + ",currentPortal.useTime = " + this.E.useTime + ",currentPortal.countTime = " + this.E.countTime + ",currentPortal.realEnd = " + this.E.realEnd + ",countDown = " + j17);
                                }
                                d dVar4 = this.f259284m;
                                PortalConfig portalConfig6 = this.E;
                                dVar4.i(j19, portalConfig6.mode, n16, bitmap2, bitmap, str3, str4, str5, str, j17, z16, portalConfig6.countGrab, n17, n18, arrayList, this.I.comboNumberConfigs, bitmap3, j28, bitmap4, bitmap5);
                                if (this.I.showGesturesTime <= 0 && this.f259284m.c()) {
                                    this.I.showGesturesTime = j37;
                                    z18 = true;
                                }
                                z18 = z17;
                            } else {
                                if (i16 == 3 && this.f259284m.e(n(portalConfig2.bgMd5, null))) {
                                    this.E.useFlag = 2;
                                    z18 = true;
                                } else {
                                    z18 = z17;
                                }
                                this.f259284m.b();
                            }
                            z17 = z18;
                        }
                    } else {
                        this.f259284m.b();
                    }
                }
                if (!z17) {
                    K(false, 6, 1000L, this.I);
                    return;
                }
                return;
            }
        }
        z17 = false;
        if (2 == (i3 & 2)) {
        }
        if (!z17) {
        }
    }

    protected boolean I(RedPacketConfig redPacketConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, (Object) redPacketConfig)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("PortalManager", 2, "saveRedPacketConfig");
        }
        if (redPacketConfig == null) {
            return false;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(redPacketConfig);
            objectOutputStream.close();
            byteArrayOutputStream.close();
            return FileUtils.pushData2File(w(), byteArrayOutputStream.toByteArray(), false);
        } catch (Throwable th5) {
            th5.printStackTrace();
            return false;
        }
    }

    void K(boolean z16, int i3, long j3, Object obj) {
        Handler handler;
        if (!this.K) {
            synchronized (this) {
                if (!this.K) {
                    if (z16) {
                        handler = this.J;
                    } else {
                        handler = this.H;
                    }
                    handler.sendMessageDelayed(Message.obtain(handler, i3, 0, 0, obj), j3);
                }
            }
        }
    }

    public void L(long j3, long j16, long j17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
        } else {
            this.J.post(new Runnable(j3, j16, j17) { // from class: com.tencent.mobileqq.portal.PortalManager.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ long f259285d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ long f259286e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ long f259287f;

                {
                    this.f259285d = j3;
                    this.f259286e = j16;
                    this.f259287f = j17;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, PortalManager.this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
                    }
                }

                /* JADX WARN: Removed duplicated region for block: B:25:0x0060  */
                /* JADX WARN: Removed duplicated region for block: B:32:0x0083  */
                /* JADX WARN: Removed duplicated region for block: B:34:0x008f  */
                /* JADX WARN: Removed duplicated region for block: B:37:0x00a0  */
                /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    boolean z16;
                    long j18;
                    long j19;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (PortalManager.this.I != null) {
                        long j26 = this.f259285d;
                        boolean z17 = true;
                        if (j26 > 0 && j26 <= 60000 && PortalManager.Y != j26) {
                            PortalManager.Y = j26;
                            if (PortalManager.this.I.grebInterval != PortalManager.Y) {
                                PortalManager.this.I.grebInterval = PortalManager.Y;
                                z16 = true;
                                j18 = this.f259286e;
                                if (j18 != -1 && PortalManager.Z != j18) {
                                    PortalManager.Z = j18;
                                    if (PortalManager.this.I.reportActiveInterval != PortalManager.Z) {
                                        PortalManager.this.I.reportActiveInterval = PortalManager.Z;
                                        z16 = true;
                                    }
                                }
                                j19 = this.f259287f;
                                if (j19 != -1 && PortalManager.f259268a0 != j19) {
                                    PortalManager.f259268a0 = j19;
                                    if (PortalManager.this.I.reportNormalInterval != PortalManager.f259268a0) {
                                        PortalManager.this.I.reportNormalInterval = PortalManager.f259268a0;
                                        if (z17) {
                                            PortalManager portalManager = PortalManager.this;
                                            portalManager.K(false, 6, 1000L, portalManager.I);
                                        }
                                        if (QLog.isColorLevel()) {
                                            QLog.d("PortalManager", 2, "sGrabInterval = " + PortalManager.Y + ",sReportActiveInterval = " + PortalManager.Z + ",sReportNormalInterval = " + PortalManager.f259268a0);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                z17 = z16;
                                if (z17) {
                                }
                                if (QLog.isColorLevel()) {
                                }
                            }
                        }
                        z16 = false;
                        j18 = this.f259286e;
                        if (j18 != -1) {
                            PortalManager.Z = j18;
                            if (PortalManager.this.I.reportActiveInterval != PortalManager.Z) {
                            }
                        }
                        j19 = this.f259287f;
                        if (j19 != -1) {
                            PortalManager.f259268a0 = j19;
                            if (PortalManager.this.I.reportNormalInterval != PortalManager.f259268a0) {
                            }
                        }
                        z17 = z16;
                        if (z17) {
                        }
                        if (QLog.isColorLevel()) {
                        }
                    }
                }
            });
        }
    }

    public void M(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("setStarShareFlag, ");
            sb5.append(i3);
            PortalConfig portalConfig = this.E;
            if (portalConfig != null) {
                i17 = portalConfig.f259294id;
            }
            sb5.append(i17);
            sb5.append(",");
            sb5.append(i16);
            QLog.d("PortalManager", 2, sb5.toString());
        }
        PortalConfig portalConfig2 = this.E;
        if (portalConfig2 != null && portalConfig2.f259294id == i3) {
            portalConfig2.starShareTypeReqState = 2;
            portalConfig2.starShareType = i16;
        }
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PortalManager", 2, "clearData");
        }
        File file = new File(BaseApplicationImpl.sApplication.getFilesDir(), "red_packet_config2017_" + m());
        if (file.delete() && !file.delete()) {
            file.delete();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01b2  */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleMessage(Message message) {
        boolean P;
        long j3;
        boolean z16;
        String qqStr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, (Object) message)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("PortalManager", 2, "handleMessage " + message.what + ", " + message.obj);
        }
        int i3 = message.what;
        boolean z17 = true;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 5) {
                        if (i3 != 6) {
                            if (i3 != 7) {
                                if (i3 != 8) {
                                    if (i3 != 100) {
                                        switch (i3) {
                                            case 13:
                                                if (this.f259284m != null) {
                                                    if (this.E != null) {
                                                        QLog.d("PortalManager", 2, "MSG_GRAB_FAKE_EVENT, mShower" + this.f259284m);
                                                    }
                                                    d dVar = this.f259284m;
                                                    PortalConfig portalConfig = this.E;
                                                    if (portalConfig != null) {
                                                        qqStr = portalConfig.emptyMsg;
                                                    } else {
                                                        qqStr = HardCodeUtil.qqStr(R.string.paz);
                                                    }
                                                    dVar.h(false, qqStr, null);
                                                    break;
                                                }
                                                break;
                                            case 14:
                                                Object obj = message.obj;
                                                if (obj != null && (obj instanceof ArrayList)) {
                                                    int i16 = message.arg1;
                                                    ArrayList arrayList = (ArrayList) obj;
                                                    if (message.arg2 != 1) {
                                                        z17 = false;
                                                    }
                                                    RedPacketServlet.h(i16, arrayList, z17, message.getData());
                                                    break;
                                                }
                                                break;
                                            case 15:
                                                this.H.post(new ReportRunnable(this.T.m1clone(), 2, 0, 0, 0, 0L, false));
                                                this.T.clear();
                                                this.H.removeMessages(15);
                                                this.H.sendEmptyMessageDelayed(15, 600000L);
                                                break;
                                            case 16:
                                                this.H.post(new ReportRunnable(this.f259283i.m1clone(), 1, this.Q, this.R, p(), ((Long) message.obj).longValue(), false));
                                                this.R = 0;
                                                this.Q = 0;
                                                this.f259283i.clear();
                                                if (QLog.isColorLevel() && this.E != null) {
                                                    QLog.d("PortalManager", 2, "MSG_GRAB_TIMEOUT_REPORT | activity id:" + this.E.f259294id + ", total count:" + this.E.countGrab);
                                                    break;
                                                }
                                                break;
                                        }
                                    }
                                    P = false;
                                    long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
                                    O(serverTimeMillis);
                                    j3 = serverTimeMillis;
                                    if (message.what != 5) {
                                        z16 = true;
                                    } else {
                                        z16 = false;
                                    }
                                    G(null, 3, z16, j3);
                                    if (P) {
                                        K(false, 6, 1000L, this.I);
                                    }
                                } else {
                                    d dVar2 = (d) message.obj;
                                    this.f259284m = dVar2;
                                    G(dVar2, message.arg1, false, 0L);
                                }
                            } else {
                                N(this.I);
                            }
                        } else if (!this.H.hasMessages(6)) {
                            I((RedPacketConfig) message.obj);
                        }
                    } else {
                        j3 = 0;
                        P = false;
                        if (message.what != 5) {
                        }
                        G(null, 3, z16, j3);
                        if (P) {
                        }
                    }
                }
            } else if (this.I != null) {
                return true;
            }
            RedPacketConfig redPacketConfig = this.I;
            RedPacketConfig redPacketConfig2 = (RedPacketConfig) message.obj;
            this.I = redPacketConfig2;
            if (redPacketConfig2 != null) {
                P = P(redPacketConfig2, redPacketConfig, true);
                if (this.I != null) {
                    L(this.I.grebInterval, this.I.reportActiveInterval, this.I.reportNormalInterval);
                }
                long serverTimeMillis2 = NetConnInfoCenter.getServerTimeMillis();
                O(serverTimeMillis2);
                j3 = serverTimeMillis2;
                if (message.what != 5) {
                }
                G(null, 3, z16, j3);
                if (P) {
                }
            }
            P = false;
            long serverTimeMillis22 = NetConnInfoCenter.getServerTimeMillis();
            O(serverTimeMillis22);
            j3 = serverTimeMillis22;
            if (message.what != 5) {
            }
            G(null, 3, z16, j3);
            if (P) {
            }
        } else {
            if (this.I == null && NetConnInfoCenter.servetTimeSecondInterv != 0) {
                C();
            }
            B();
        }
        return false;
    }

    public PortalConfig l(long j3) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (PortalConfig) iPatchRedirector.redirect((short) 4, (Object) this, j3);
        }
        PortalConfig portalConfig = null;
        if (this.I != null) {
            if (j3 == -1) {
                j3 = NetConnInfoCenter.getServerTimeMillis();
                long j16 = f259275h0;
                if (j16 > 0) {
                    j3 = j16 + (f259277j0 * (j3 - f259276i0));
                }
            }
            ArrayList<PortalConfig> arrayList = this.I.portalConfigs;
            int size = arrayList.size();
            for (int i16 = 0; i16 < size; i16++) {
                PortalConfig portalConfig2 = arrayList.get(i16);
                if (portalConfig2.f259294id != j3) {
                    long j17 = portalConfig2.realBegin;
                    if (j17 > j3 || portalConfig2.realEnd <= j3) {
                        if (j3 > 536870911 && j17 > j3) {
                            break;
                        }
                    }
                }
                portalConfig = portalConfig2;
                break;
            }
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("findRealPortal, ");
            sb5.append(j3);
            sb5.append(", ");
            if (portalConfig != null) {
                i3 = portalConfig.f259294id;
            } else {
                i3 = -1;
            }
            sb5.append(i3);
            QLog.d("PortalManager", 2, sb5.toString());
        }
        return portalConfig;
    }

    @Override // mqq.manager.Manager
    public synchronized void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PortalManager", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        this.K = true;
        PortalConfig portalConfig = this.E;
        if (this.f259283i.size() > 0 && portalConfig.useTime > 0) {
            this.H.post(new ReportRunnable(this.f259283i.m1clone(), 1, this.Q, this.R, p(), portalConfig.useTime, true));
            this.f259283i.clear();
        }
        if (this.T.size() > 0) {
            this.H.post(new ReportRunnable(this.T.m1clone(), 2, 0, 0, 0, 0L, true));
            this.T.clear();
        }
        this.H.removeMessages(1);
        this.H.removeMessages(15);
        this.J.removeCallbacksAndMessages(null);
        QQAppInterface v3 = v();
        if (v3 != null) {
            v3.unRegistObserver(this);
            v3.removeObserver(this.W);
            try {
                v3.getApp().unregisterReceiver(this.V);
            } catch (Exception e16) {
                QLog.e("PortalManager", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY, e16);
            }
        }
        SoundPool soundPool = this.f259279d;
        if (soundPool != null) {
            soundPool.release();
            this.f259279d = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0247  */
    @Override // mqq.observer.BusinessObserver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        int i16;
        int i17;
        String str;
        boolean z17;
        PortalConfig l3;
        AwardConfig awardConfig;
        e eVar;
        String qqStr;
        String str2;
        boolean z18 = z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PortalManager", 2, "onReceive, cmd = " + i3 + ", isSuccess = " + z18 + ", " + bundle);
        }
        if (QLog.isColorLevel()) {
            QLog.d("PortalManager", 2, "onReceive", Integer.valueOf(i3));
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 8) {
                    int i18 = bundle.getInt("k_code", -1);
                    int i19 = bundle.getInt("k_r_type");
                    int i26 = bundle.getInt("key_seq");
                    if (z18 && i18 == 0) {
                        g(i19, bundle.getString(com.tencent.mobileqq.phonecontact.observer.b.KEY_RESULT), i26);
                        return;
                    } else {
                        J(i19, i26, null, i18, null);
                        return;
                    }
                }
                return;
            }
            int i27 = bundle.getInt("k_code", 2);
            if (i27 == 3) {
                handleMessage(this.J.obtainMessage(3, new RedPacketConfig()));
                return;
            } else {
                if (i27 == 4) {
                    handleMessage(this.J.obtainMessage(3, (RedPacketConfig) bundle.getSerializable("k_cache")));
                    return;
                }
                return;
            }
        }
        String string = bundle.getString("key_url");
        int i28 = bundle.getInt("k_id", -1);
        int i29 = bundle.getInt("k_code", -1);
        int i36 = bundle.getInt("k_money", -1);
        int i37 = bundle.getInt("k_type", -1);
        boolean z19 = bundle.getBoolean("k_s_follow", true);
        int i38 = bundle.getInt("key_award_id", -1);
        int i39 = bundle.getInt("key_promotion_id", -1);
        Long valueOf = Long.valueOf(bundle.getLong("key_send_url", -1L));
        String string2 = bundle.getString("key_wish", "");
        if (z18) {
            this.f259281f = -this.f259281f;
        }
        if (i29 > 0) {
            i16 = 1;
            this.Q++;
        } else {
            i16 = 1;
        }
        if (z18 && i29 == 0) {
            int i46 = this.R + i16;
            this.R = i46;
            if (i37 != 0) {
                if (i37 != i16) {
                    this.R = i46 - i16;
                    this.Q += i16;
                } else {
                    i17 = 0;
                }
            } else {
                i17 = 1;
            }
            if (QLog.isColorLevel()) {
                str = "PortalManager";
                z17 = false;
            } else {
                z17 = false;
                str = "PortalManager";
                QLog.d(str, 2, "onReceive cmd = CMD_RESULT, portId = " + i28 + ", url = " + string + ", showType = " + i17 + ", money = " + i36 + ", awardId = " + i38 + ", promotionId = " + i39, ", sendUrl = " + valueOf + ", wishing " + string2);
            }
            l3 = l(i28);
            if (l3 == null) {
                z18 = z17;
            }
            if (!z18 && l3 != null) {
                AwardConfig findRealAwardConfigById = l3.findRealAwardConfigById(i38);
                if (findRealAwardConfigById == null && (findRealAwardConfigById = l3.findRealAwardConfigById(i39)) == null) {
                    awardConfig = findRealAwardConfigById;
                    z18 = z17;
                } else {
                    awardConfig = findRealAwardConfigById;
                }
            } else {
                awardConfig = null;
            }
            if (!z18 && awardConfig != null) {
                eVar = new e(null, awardConfig.awardTitle, awardConfig.awardMsg, i28, i17, string, i36, z19, i38, i39);
                for (LogoConfig logoConfig : l3.logoList) {
                    if (logoConfig.logoId == awardConfig.logoId) {
                        String str3 = logoConfig.logoImageMD5;
                        if (l3.mode == 1) {
                            str2 = "hb_icon_path";
                        } else {
                            str2 = "hb_busi_logo_path";
                        }
                        eVar.f259323r = n(str3, str2);
                        eVar.f259324s = n(logoConfig.nameMD5, "hb_name_path");
                    }
                }
            } else {
                eVar = null;
            }
            if (this.f259284m != null) {
                if (QLog.isColorLevel()) {
                    QLog.d(str, 2, "onReceive" + eVar + "isSuccess " + z18);
                }
                d dVar = this.f259284m;
                if (l3 != null) {
                    qqStr = l3.emptyMsg;
                } else {
                    qqStr = HardCodeUtil.qqStr(R.string.pax);
                }
                dVar.h(z18, qqStr, eVar);
            }
            if (!z18 && awardConfig != null) {
                l3.isHit = z18;
                if (i17 == 0) {
                    l3.hbCnt++;
                } else if (i17 == 1) {
                    l3.cardCnt++;
                }
                if (!this.H.hasMessages(6)) {
                    K(false, 6, 2000L, this.I);
                    return;
                }
                return;
            }
        }
        z18 = false;
        i17 = -1;
        if (QLog.isColorLevel()) {
        }
        l3 = l(i28);
        if (l3 == null) {
        }
        if (!z18) {
        }
        awardConfig = null;
        if (!z18) {
        }
        eVar = null;
        if (this.f259284m != null) {
        }
        if (!z18) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.mobileqq.transfile.INetEngineListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onResp(NetResp netResp) {
        boolean z16;
        boolean z17;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) netResp);
            return;
        }
        if (netResp.mResult == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        HttpNetReq httpNetReq = (HttpNetReq) netResp.mReq;
        File file = new File(httpNetReq.mOutPath);
        Object userData = httpNetReq.getUserData();
        HashMap<String, String> hashMap = new HashMap<>();
        if (userData != null && (userData instanceof String[])) {
            String[] strArr = (String[]) userData;
            int intValue = Integer.valueOf(strArr[0]).intValue();
            String str2 = strArr[1];
            if (this.N.contains(str2)) {
                this.N.remove(str2);
            }
            if (z16) {
                if (str2.equals(o.e(file.getAbsolutePath()))) {
                    BannerConfig bannerConfig = this.C;
                    PortalConfig portalConfig = this.E;
                    if (bannerConfig != null && bannerConfig.f259293id == intValue) {
                        n(str2, "hb_banner_path");
                        str = str2;
                        K(true, 5, 0L, null);
                    } else {
                        str = str2;
                        if (portalConfig != null && portalConfig.f259294id == intValue) {
                            K(true, 5, 0L, null);
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("PortalManager", 2, "onRespMSG_UPDATE_UI, md5 = " + str);
                    }
                } else {
                    file.delete();
                    hashMap.put("param_checkMd5Fail", "checkMd5Fail");
                }
            }
        } else {
            file.delete();
        }
        if (QLog.isColorLevel()) {
            QLog.i("PortalManager", 2, "onResp" + httpNetReq.mReqUrl + ", " + netResp.mResult + ", " + netResp.mErrCode + ", " + hashMap.get("param_checkMd5Fail"));
        }
        if (!z16) {
            hashMap.put("param_Url", httpNetReq.mReqUrl);
            hashMap.put("param_ResultCode", String.valueOf(netResp.mResult));
            hashMap.put("param_FailCode", String.valueOf(netResp.mErrCode));
        } else if (new Random().nextInt(10000) == 1000) {
            hashMap.put("param_Url", httpNetReq.mReqUrl);
            hashMap.put("param_ResultCode", String.valueOf(netResp.mResult));
        } else {
            z17 = false;
            if (!z17) {
                StatisticCollector.getInstance(MobileQQ.sMobileQQ.getApplicationContext()).collectPerformance(m(), "RedPacketPicDownload", z16, 0L, 0L, hashMap, "", false);
                return;
            }
            return;
        }
        z17 = true;
        if (!z17) {
        }
    }

    @Override // com.tencent.mobileqq.transfile.INetEngineListener
    public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, netReq, Long.valueOf(j3), Long.valueOf(j16));
        }
    }

    public int q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        PortalConfig portalConfig = this.E;
        if (portalConfig != null) {
            return portalConfig.f259294id;
        }
        return -1;
    }

    public e x(int i3, int i16, int i17, int i18) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (e) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        }
        PortalConfig l3 = l(i16);
        if (l3 == null) {
            return null;
        }
        AwardConfig findRealAwardConfigById = l3.findRealAwardConfigById(i17);
        if (findRealAwardConfigById == null && (findRealAwardConfigById = l3.findRealAwardConfigById(i18)) == null) {
            return null;
        }
        e eVar = new e();
        if (i3 != 0 && i3 != 1) {
            return null;
        }
        eVar.f259306a = n(findRealAwardConfigById.awardMd5, null);
        eVar.f259307b = findRealAwardConfigById.addMsg;
        eVar.f259318m = findRealAwardConfigById.publicId;
        eVar.f259317l = findRealAwardConfigById.publicWording;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(BaseApplicationImpl.getApplication().getFilesDir());
        String str2 = f259271d0;
        sb5.append(str2);
        if (findRealAwardConfigById.awardType == 2) {
            str = findRealAwardConfigById.starMd5;
        } else {
            str = findRealAwardConfigById.awardMd5;
        }
        sb5.append(str);
        eVar.f259312g = sb5.toString();
        eVar.f259313h = BaseApplicationImpl.getApplication().getFilesDir() + str2 + findRealAwardConfigById.ctfBgMd5;
        eVar.f259316k = findRealAwardConfigById.awardMsg;
        eVar.f259314i = findRealAwardConfigById.awardTitle;
        eVar.f259315j = findRealAwardConfigById.awardType;
        eVar.f259322q = findRealAwardConfigById.showPublic;
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RedPacketConfig y(RedPacketConfig redPacketConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (RedPacketConfig) iPatchRedirector.redirect((short) 15, (Object) this, (Object) redPacketConfig);
        }
        if (QLog.isColorLevel()) {
            if (redPacketConfig == null) {
                QLog.d("PortalManager", 2, "handleNewConfig");
            } else {
                QLog.d("PortalManager", 2, "handleNewConfig, " + redPacketConfig.version + ", " + redPacketConfig.bannerConfigs.size() + ", " + redPacketConfig.portalConfigs.size());
            }
        }
        RedPacketConfig redPacketConfig2 = this.I;
        if (redPacketConfig2 == null) {
            redPacketConfig2 = C();
        }
        if (redPacketConfig != null) {
            P(redPacketConfig, redPacketConfig2, false);
            I(redPacketConfig);
        } else {
            redPacketConfig = redPacketConfig2;
        }
        if (redPacketConfig != null) {
            N(redPacketConfig);
        }
        return redPacketConfig;
    }

    /* loaded from: classes16.dex */
    public static class e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public Bitmap f259306a;

        /* renamed from: b, reason: collision with root package name */
        public String f259307b;

        /* renamed from: c, reason: collision with root package name */
        public int f259308c;

        /* renamed from: d, reason: collision with root package name */
        public int f259309d;

        /* renamed from: e, reason: collision with root package name */
        public String f259310e;

        /* renamed from: f, reason: collision with root package name */
        public int f259311f;

        /* renamed from: g, reason: collision with root package name */
        public String f259312g;

        /* renamed from: h, reason: collision with root package name */
        public String f259313h;

        /* renamed from: i, reason: collision with root package name */
        public String f259314i;

        /* renamed from: j, reason: collision with root package name */
        public int f259315j;

        /* renamed from: k, reason: collision with root package name */
        public String f259316k;

        /* renamed from: l, reason: collision with root package name */
        public String f259317l;

        /* renamed from: m, reason: collision with root package name */
        public String f259318m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f259319n;

        /* renamed from: o, reason: collision with root package name */
        public int f259320o;

        /* renamed from: p, reason: collision with root package name */
        public int f259321p;

        /* renamed from: q, reason: collision with root package name */
        public int f259322q;

        /* renamed from: r, reason: collision with root package name */
        public Bitmap f259323r;

        /* renamed from: s, reason: collision with root package name */
        public Bitmap f259324s;

        public e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.f259322q = 0;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public e(Bitmap bitmap, String str, String str2, int i3, int i16, String str3, int i17, boolean z16, int i18, int i19) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, bitmap, str, str2, Integer.valueOf(i3), Integer.valueOf(i16), str3, Integer.valueOf(i17), Boolean.valueOf(z16), Integer.valueOf(i18), Integer.valueOf(i19));
                return;
            }
            this.f259322q = 0;
            this.f259306a = bitmap;
            this.f259314i = str;
            this.f259316k = str2;
            this.f259308c = i3;
            this.f259309d = i16;
            this.f259310e = str3;
            this.f259311f = i17;
            this.f259319n = z16;
            this.f259320o = i18;
            this.f259321p = i19;
        }
    }
}
