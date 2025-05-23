package com.tencent.mobileqq.app;

import SummaryCard.CondFitUser;
import SummaryCard.RespCondSearch;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.room.RoomMasterTable;
import com.qzone.proxy.personalitycomponent.adapter.PersonalityConfig;
import com.qzone.reborn.intimate.request.QZoneIntimateBaseRequest;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;
import com.tencent.mobileqq.conditionsearch.data.AddressData;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.widget.CountrySelect.CountrySelectView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qwallet.preload.IPreloadResource;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.theme.diy.ThemeBackground;
import com.tencent.mobileqq.widget.selectorview.model.BaseAddress;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.ErrorCode;
import common.config.service.QzoneConfig;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
import protocol.KQQConfig.GetResourceRespInfo;
import tencent.im.oidb.cmd0x972.oidb_0x972$ResultItem;
import tencent.im.oidb.cmd0x972.oidb_0x972$ResultItemGroup;
import tencent.im.oidb.cmd0x972.oidb_0x972$RspBody;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ConditionSearchManager implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: k0, reason: collision with root package name */
    private static final String f194483k0;

    /* renamed from: l0, reason: collision with root package name */
    private static final String f194484l0;

    /* renamed from: m0, reason: collision with root package name */
    public static final String[] f194485m0;

    /* renamed from: n0, reason: collision with root package name */
    public static final String[] f194486n0;

    /* renamed from: o0, reason: collision with root package name */
    public static final String[] f194487o0;

    /* renamed from: p0, reason: collision with root package name */
    public static final String[] f194488p0;

    /* renamed from: q0, reason: collision with root package name */
    public static final String[] f194489q0;

    /* renamed from: r0, reason: collision with root package name */
    public static final int[] f194490r0;

    /* renamed from: s0, reason: collision with root package name */
    public static final int[] f194491s0;

    /* renamed from: t0, reason: collision with root package name */
    public static final int[] f194492t0;
    private volatile long C;
    private volatile long D;
    public String E;
    public boolean F;
    private d G;
    private volatile boolean H;
    volatile boolean I;
    volatile boolean J;
    ConcurrentHashMap<Integer, WeakReference<Object>> K;
    volatile boolean L;
    volatile Card M;
    Object N;
    private String[] P;
    private String[] Q;
    private String[] R;
    long S;
    String T;
    int U;
    int V;
    int W;
    int X;
    int Y;
    String[] Z;

    /* renamed from: a0, reason: collision with root package name */
    String[] f194493a0;

    /* renamed from: b0, reason: collision with root package name */
    int f194494b0;

    /* renamed from: c0, reason: collision with root package name */
    long f194495c0;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f194496d;

    /* renamed from: d0, reason: collision with root package name */
    byte[] f194497d0;

    /* renamed from: e, reason: collision with root package name */
    private boolean f194498e;

    /* renamed from: e0, reason: collision with root package name */
    int f194499e0;

    /* renamed from: f, reason: collision with root package name */
    private boolean f194500f;

    /* renamed from: f0, reason: collision with root package name */
    List<CondFitUser> f194501f0;

    /* renamed from: g0, reason: collision with root package name */
    boolean f194502g0;

    /* renamed from: h, reason: collision with root package name */
    private AddressData f194503h;

    /* renamed from: h0, reason: collision with root package name */
    private ar f194504h0;

    /* renamed from: i, reason: collision with root package name */
    private final String f194505i;

    /* renamed from: i0, reason: collision with root package name */
    LinkedList<c> f194506i0;

    /* renamed from: j0, reason: collision with root package name */
    LinkedList<e> f194507j0;

    /* renamed from: m, reason: collision with root package name */
    private SharedPreferences f194508m;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class DownloadTask extends AbsPreDownloadTask {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public GetResourceRespInfo f194513d;

        /* renamed from: e, reason: collision with root package name */
        public File f194514e;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public DownloadTask(QQAppInterface qQAppInterface, String str, GetResourceRespInfo getResourceRespInfo, File file) {
            super(qQAppInterface, r0);
            String str2;
            if (ConditionSearchManager.f()) {
                str2 = com.tencent.relation.common.config.toggle.c.f364697j.d("region_download_url", "");
            } else {
                str2 = str;
            }
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, qQAppInterface, str, getResourceRespInfo, file);
            } else {
                this.f194513d = getResourceRespInfo;
                this.f194514e = file;
            }
        }

        @Override // com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask
        protected void realCancel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else if (QLog.isColorLevel()) {
                QLog.d("ConditionSearch.Manager", 2, "DownloadTask realCancel");
            }
        }

        @Override // com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask
        protected void realStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ConditionSearch.Manager", 2, "DownloadTask realStart");
            }
            ThreadManagerV2.excute(new Runnable(this.key, this.f194514e, this.app, this.f194513d) { // from class: com.tencent.mobileqq.app.ConditionSearchManager.DownloadTask.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f194515d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ File f194516e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ BaseQQAppInterface f194517f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ GetResourceRespInfo f194518h;

                {
                    this.f194515d = r6;
                    this.f194516e = r7;
                    this.f194517f = r8;
                    this.f194518h = r9;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, DownloadTask.this, r6, r7, r8, r9);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    int i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("ConditionSearch.Manager", 2, "DownloadTask runnable start, url=" + this.f194515d);
                    }
                    boolean z16 = false;
                    try {
                        i3 = HttpDownloadUtil.downloadData(((AbsPreDownloadTask) DownloadTask.this).app, MsfSdkUtils.insertMtype("ConfigCheck", this.f194515d), this.f194516e);
                    } catch (NoClassDefFoundError e16) {
                        QLog.e("ConditionSearch.Manager", 1, e16, new Object[0]);
                        i3 = 5;
                    }
                    if (i3 == 0) {
                        z16 = true;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("ConditionSearch.Manager", 2, "onCheckupConfig | download result = " + z16);
                    }
                    ConditionSearchManager conditionSearchManager = (ConditionSearchManager) this.f194517f.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER);
                    if (conditionSearchManager != null) {
                        conditionSearchManager.M(i3, this.f194516e, this.f194518h);
                    }
                    IPreDownloadController iPreDownloadController = (IPreDownloadController) ((AbsPreDownloadTask) DownloadTask.this).app.getRuntimeService(IPreDownloadController.class);
                    String str = this.f194515d;
                    long j3 = -1;
                    if (z16 && this.f194516e.exists()) {
                        j3 = this.f194516e.length();
                    }
                    iPreDownloadController.preDownloadSuccess(str, j3);
                }
            }, 128, null, true);
        }

        @Override // com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return "[DownloadTask] url=" + this.key;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements Comparator<BaseAddress> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ConditionSearchManager.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(BaseAddress baseAddress, BaseAddress baseAddress2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) baseAddress, (Object) baseAddress2)).intValue();
            }
            int compareTo = baseAddress.pinyinFirst.compareTo(baseAddress2.pinyinFirst);
            if (compareTo == 0) {
                return baseAddress.pinyinAll.compareTo(baseAddress2.pinyinAll);
            }
            return compareTo;
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class b extends ar {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ConditionSearchManager.this);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onCondSearchFriendResult(long j3, boolean z16, Object obj, int i3, int i16) {
            int i17;
            boolean z17;
            List<CondFitUser> list;
            boolean z18;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Boolean.valueOf(z16), obj, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ConditionSearch.Manager", 2, "onCondSearchFriendResult searchseq = " + ConditionSearchManager.this.S + " | seq = " + j3 + ", isSuccess=" + z16 + ", ret=" + i3 + ", searchFrom=" + i16);
            }
            ConditionSearchManager conditionSearchManager = ConditionSearchManager.this;
            if (conditionSearchManager.S != j3) {
                return;
            }
            byte[] bArr = null;
            if (z16 && i3 == 0) {
                if (obj instanceof RespCondSearch) {
                    RespCondSearch respCondSearch = (RespCondSearch) obj;
                    if (respCondSearch.cEndFlag == 0) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    conditionSearchManager.f194502g0 = z18;
                    conditionSearchManager.f194494b0 = respCondSearch.iPage;
                    conditionSearchManager.f194495c0 = respCondSearch.dwSessionID;
                    if (conditionSearchManager.f194501f0 == null) {
                        conditionSearchManager.f194501f0 = respCondSearch.vUserList;
                    } else {
                        ArrayList<CondFitUser> arrayList = respCondSearch.vUserList;
                        if (arrayList != null && !arrayList.isEmpty()) {
                            ConditionSearchManager.this.f194501f0.addAll(respCondSearch.vUserList);
                        }
                    }
                } else if (obj instanceof oidb_0x972$RspBody) {
                    oidb_0x972$RspBody oidb_0x972_rspbody = (oidb_0x972$RspBody) obj;
                    if (oidb_0x972_rspbody.is_end.has()) {
                        i17 = oidb_0x972_rspbody.is_end.get();
                    } else {
                        i17 = 0;
                    }
                    if (i17 == 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    conditionSearchManager.f194502g0 = z17;
                    ConditionSearchManager conditionSearchManager2 = ConditionSearchManager.this;
                    if (oidb_0x972_rspbody.cookie.has()) {
                        bArr = oidb_0x972_rspbody.cookie.get().toByteArray();
                    }
                    conditionSearchManager2.f194497d0 = bArr;
                    if (QLog.isColorLevel()) {
                        QLog.d("ConditionSearch.Manager", 2, "onCondSearchFriendResult hasMore = " + ConditionSearchManager.this.f194502g0 + ",cookie = " + ConditionSearchManager.this.f194497d0);
                    }
                    List<CondFitUser> m3 = ConditionSearchManager.this.m(oidb_0x972_rspbody);
                    ConditionSearchManager conditionSearchManager3 = ConditionSearchManager.this;
                    List<CondFitUser> list2 = conditionSearchManager3.f194501f0;
                    if (list2 == null) {
                        conditionSearchManager3.f194501f0 = m3;
                    } else if (m3 != null) {
                        list2.addAll(m3);
                    }
                }
                ConditionSearchManager conditionSearchManager4 = ConditionSearchManager.this;
                if (conditionSearchManager4.f194499e0 < 2 && ((list = conditionSearchManager4.f194501f0) == null || list.size() < 10)) {
                    ConditionSearchManager conditionSearchManager5 = ConditionSearchManager.this;
                    if (conditionSearchManager5.f194502g0) {
                        conditionSearchManager5.f194499e0++;
                        FriendListHandler friendListHandler = (FriendListHandler) conditionSearchManager5.f194496d.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
                        ConditionSearchManager conditionSearchManager6 = ConditionSearchManager.this;
                        friendListHandler.condtionalSearchFriendBy0x972(conditionSearchManager6.S, conditionSearchManager6.f194494b0 + 1, conditionSearchManager6.f194497d0, conditionSearchManager6.T, conditionSearchManager6.U, conditionSearchManager6.V, conditionSearchManager6.W, conditionSearchManager6.Z, conditionSearchManager6.f194493a0, conditionSearchManager6.X, conditionSearchManager6.Y, i16);
                        return;
                    }
                }
                List<CondFitUser> list3 = ConditionSearchManager.this.f194501f0;
                if (list3 == null || list3.size() < 6) {
                    ConditionSearchManager.this.f194502g0 = false;
                }
                ConditionSearchManager conditionSearchManager7 = ConditionSearchManager.this;
                conditionSearchManager7.J(true, conditionSearchManager7.f194501f0, conditionSearchManager7.f194502g0, i16);
                return;
            }
            if (z16 && i3 != 0) {
                conditionSearchManager.f194502g0 = false;
                conditionSearchManager.J(true, conditionSearchManager.f194501f0, false, i16);
            } else if (conditionSearchManager.f194499e0 == 0) {
                conditionSearchManager.J(false, null, conditionSearchManager.f194502g0, i16);
            } else {
                conditionSearchManager.J(true, conditionSearchManager.f194501f0, conditionSearchManager.f194502g0, i16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface c {
        void onGetConfig(int i3, boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface d {
        void a();
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface e {
        void a(boolean z16, List<CondFitUser> list, boolean z17, int i3);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69626);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 48)) {
            redirector.redirect((short) 48);
            return;
        }
        String str = QzoneZipCacheHelper.DIR + File.separator;
        f194483k0 = str;
        f194484l0 = str + "AdminRegionConfig.txt";
        f194485m0 = new String[]{IProfileCardConst.NAME_NO_LIMIT, "\u7537", "\u5973"};
        f194486n0 = new String[]{IProfileCardConst.NAME_NO_LIMIT, "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", WadlProxyConsts.OPER_TYPE_APK_SIGN, WadlProxyConsts.OPER_TYPE_MONITOR, "35", "36", "37", "38", "39", "40", "41", RoomMasterTable.DEFAULT_ID, "43", "44", "45", "46", "47", "48", "49", "50", "51", QzoneConfig.DefaultValue.DEFAULT_MODEL_PHONE, "53", "54", "55", "56", "57", "58", ErrorCode.ERR_NET, "60", "61", "62", "63", IPreloadResource.ABI_64, "65", "66", "67", "68", "69", "70", "71", PersonalityConfig.SUB_ACTION_TYPE_ACTIVE_FEEDS_REDPOCKET_DECORATE_EXPOSED, PersonalityConfig.SUB_ACTION_TYPE_ACTIVE_FEEDS_REDPOCKET_DECORATE_CLICK, "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", QZoneIntimateBaseRequest.QZONE_INTIMATE_REQUEST_CLOUD_APP_ID_VALUE, ThemeBackground.DIY_UPLOAD_BG_ID};
        f194487o0 = new String[]{IProfileCardConst.NAME_NO_LIMIT, "\u6c34\u74f6\u5ea7", "\u53cc\u9c7c\u5ea7", "\u767d\u7f8a\u5ea7", "\u91d1\u725b\u5ea7", "\u53cc\u5b50\u5ea7", "\u5de8\u87f9\u5ea7", "\u72ee\u5b50\u5ea7", "\u5904\u5973\u5ea7", "\u5929\u79e4\u5ea7", "\u5929\u874e\u5ea7", "\u5c04\u624b\u5ea7", "\u6469\u7faf\u5ea7"};
        f194488p0 = new String[]{IProfileCardConst.NAME_NO_LIMIT, "\u8ba1\u7b97\u673a/\u4e92\u8054\u7f51/\u901a\u4fe1", "\u751f\u4ea7/\u5de5\u827a/\u5236\u9020", "\u533b\u7597/\u62a4\u7406/\u5236\u836f", "\u91d1\u878d/\u94f6\u884c/\u6295\u8d44/\u4fdd\u9669", "\u5546\u4e1a/\u670d\u52a1\u4e1a/\u4e2a\u4f53\u7ecf\u8425", "\u6587\u5316/\u5e7f\u544a/\u4f20\u5a92", "\u5a31\u4e50/\u827a\u672f/\u8868\u6f14", "\u5f8b\u5e08/\u6cd5\u52a1", "\u6559\u80b2/\u57f9\u8bad", "\u516c\u52a1\u5458/\u884c\u653f/\u4e8b\u4e1a\u5355\u4f4d", "\u6a21\u7279", "\u7a7a\u59d0", "\u5b66\u751f", "\u5176\u4ed6\u804c\u4e1a"};
        f194489q0 = new String[]{"", "IT", "\u5236\u9020", "\u533b\u7597", "\u91d1\u878d", "\u5546\u4e1a", "\u6587\u5316", "\u827a\u672f", "\u6cd5\u5f8b", "\u6559\u80b2", "\u884c\u653f", "\u6a21\u7279", "\u7a7a\u59d0", "\u5b66\u751f", ""};
        f194490r0 = new int[]{R.drawable.f5n, R.drawable.f161721eo2, R.drawable.f161721eo2, R.drawable.f161721eo2, R.drawable.f1h, R.drawable.f1h, R.drawable.f161856f60, R.drawable.f161856f60, R.drawable.f161781ey1, R.drawable.f161781ey1, R.drawable.f161781ey1, R.drawable.f5n, R.drawable.f5n, R.drawable.f2d, R.drawable.f5n};
        f194491s0 = new int[]{-16777216, -11362561, -11362561, -11362561, -274353, -274353, -893603, -893603, -7745469, -7745469, -7745469, -8291118, -8291118, -16723548, -16777216};
        f194492t0 = new int[]{11, 12};
    }

    public ConditionSearchManager(QQAppInterface qQAppInterface) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f194498e = false;
        this.f194500f = false;
        this.f194503h = null;
        this.f194505i = "condation_search_sp";
        this.C = 0L;
        this.E = null;
        this.F = false;
        this.H = false;
        this.I = false;
        this.J = false;
        this.K = new ConcurrentHashMap<>();
        this.L = false;
        this.M = null;
        this.N = new Object();
        this.S = 0L;
        this.f194494b0 = 0;
        this.f194495c0 = 0L;
        this.f194499e0 = 0;
        this.f194502g0 = false;
        this.f194504h0 = new b();
        this.f194506i0 = null;
        this.f194507j0 = null;
        this.f194496d = qQAppInterface;
        SharedPreferences sharedPreferences = qQAppInterface.getApp().getSharedPreferences("condation_search_sp", 0);
        this.f194508m = sharedPreferences;
        this.f194498e = sharedPreferences.getBoolean("key_first_run" + this.f194496d.getCurrentAccountUin(), true);
        if (H()) {
            j3 = 0;
        } else {
            j3 = this.f194508m.getLong("key_config_version", 0L);
        }
        this.C = j3;
        this.D = this.f194508m.getLong("key_last_checkup_time", 0L);
        this.f194500f = k();
    }

    private static boolean G() {
        if (!new File(u(f194484l0)).exists()) {
            QLog.e("ConditionSearch.Manager", 1, "isToggleConfigUpdate, file not exist! need update and download");
            return true;
        }
        return com.tencent.relation.common.utils.i.c().h(com.tencent.relation.common.config.toggle.c.f364697j.d("region_download_url", ""));
    }

    private static boolean H() {
        com.tencent.relation.common.config.toggle.c cVar = com.tencent.relation.common.config.toggle.c.f364697j;
        boolean g16 = cVar.g(false);
        String d16 = cVar.d("region_download_url", "");
        if (!g16 || d16 == null || TextUtils.isEmpty(d16)) {
            return false;
        }
        return true;
    }

    private void I(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("ConditionSearch.Manager", 2, String.format("notifyRemoteUpdateResult isSuccess=%s", Boolean.valueOf(z16)));
        }
        this.f194496d.runOnUiThread(new Runnable(z16) { // from class: com.tencent.mobileqq.app.ConditionSearchManager.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ boolean f194511d;

            {
                this.f194511d = z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, ConditionSearchManager.this, Boolean.valueOf(z16));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                ConditionSearchManager.this.I = false;
                if (ConditionSearchManager.this.f194506i0 != null) {
                    LinkedList linkedList = new LinkedList();
                    linkedList.addAll(ConditionSearchManager.this.f194506i0);
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        ((c) it.next()).onGetConfig(1, this.f194511d);
                    }
                }
                if (this.f194511d && ConditionSearchManager.this.J) {
                    ConditionSearchManager conditionSearchManager = ConditionSearchManager.this;
                    conditionSearchManager.g0(conditionSearchManager.j());
                }
            }
        });
    }

    static /* bridge */ /* synthetic */ boolean f() {
        return H();
    }

    private int i0() {
        String str;
        if (QLog.isColorLevel()) {
            QLog.d("ConditionSearch.Manager", 2, "updateLocal | isParsing = " + this.H);
        }
        if (this.H) {
            return 0;
        }
        if (H()) {
            str = f194484l0;
        } else {
            str = "admin_region_config";
        }
        File file = new File(u(str));
        if (!file.exists()) {
            if (QLog.isColorLevel()) {
                QLog.d("ConditionSearch.Manager", 2, "updateLocal | file is not exist");
            }
            this.C = 0L;
            return 3;
        }
        this.H = true;
        ThreadManagerV2.excute(new Runnable(file) { // from class: com.tencent.mobileqq.app.ConditionSearchManager.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ File f194509d;

            {
                this.f194509d = file;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ConditionSearchManager.this, (Object) file);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    ConditionSearchManager conditionSearchManager = ConditionSearchManager.this;
                    conditionSearchManager.f194503h = com.tencent.mobileqq.conditionsearch.data.a.a(conditionSearchManager.f194496d, this.f194509d);
                    if (QLog.isColorLevel()) {
                        QLog.d("ConditionSearch.Manager", 2, "updateLocal | doParse cost " + (((float) (System.currentTimeMillis() - currentTimeMillis)) / 1000.0f) + " seconds");
                    }
                    ConditionSearchManager.this.f194496d.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.app.ConditionSearchManager.2.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            boolean z16;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                ConditionSearchManager.this.H = false;
                                if (ConditionSearchManager.this.J) {
                                    try {
                                        if (ConditionSearchManager.this.f194506i0 != null) {
                                            LinkedList linkedList = new LinkedList();
                                            linkedList.addAll(ConditionSearchManager.this.f194506i0);
                                            Iterator it = linkedList.iterator();
                                            while (it.hasNext()) {
                                                c cVar = (c) it.next();
                                                if (ConditionSearchManager.this.f194503h != null) {
                                                    z16 = true;
                                                } else {
                                                    z16 = false;
                                                }
                                                cVar.onGetConfig(2, z16);
                                            }
                                        }
                                    } catch (Exception e16) {
                                        QLog.e("ConditionSearch.Manager", 1, "updateLocal callback fail.", e16);
                                    }
                                    if (ConditionSearchManager.this.L && ConditionSearchManager.this.f194503h != null) {
                                        ConditionSearchManager conditionSearchManager2 = ConditionSearchManager.this;
                                        conditionSearchManager2.P(conditionSearchManager2.M);
                                        return;
                                    } else {
                                        ConditionSearchManager.this.L = false;
                                        ConditionSearchManager.this.M = null;
                                        ConditionSearchManager conditionSearchManager3 = ConditionSearchManager.this;
                                        conditionSearchManager3.o(conditionSearchManager3.N);
                                        return;
                                    }
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.d("ConditionSearch.Manager", 2, "updateLocal | SearchActivity is not running");
                                }
                                ConditionSearchManager.this.f194503h = null;
                                return;
                            }
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                    });
                } catch (OutOfMemoryError e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ConditionSearch.Manager", 2, "", e16);
                    }
                }
            }
        }, 128, null, true);
        return 0;
    }

    private boolean k() {
        if (this.f194498e) {
            return this.f194508m.getBoolean("key_frist_run_add_contact" + this.f194496d.getCurrentAccountUin(), true);
        }
        if (this.f194508m.getBoolean("key_frist_run_in_5_2" + this.f194496d.getCurrentAccountUin(), true)) {
            if (this.f194508m.getInt("key_sex_index" + this.f194496d.getCurrentAccountUin(), 0) == 0) {
                if (this.f194508m.getInt("key_age_index_v2_1" + this.f194496d.getCurrentAccountUin(), 0) == 0) {
                    if (this.f194508m.getInt("key_age_index_v2_2" + this.f194496d.getCurrentAccountUin(), 0) == 0) {
                        if (this.f194508m.getInt("key_job_index" + this.f194496d.getCurrentAccountUin(), 0) == 0) {
                            if (this.f194508m.getInt("key_xingzuo_index" + this.f194496d.getCurrentAccountUin(), 0) == 0) {
                                if (this.f194508m.getString("key_loc_country_code" + this.f194496d.getCurrentAccountUin(), "0").equals("0")) {
                                    if (this.f194508m.getString("key_home_country_code" + this.f194496d.getCurrentAccountUin(), "0").equals("0")) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01a9 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<CondFitUser> m(oidb_0x972$RspBody oidb_0x972_rspbody) {
        List<oidb_0x972$ResultItemGroup> list;
        List<oidb_0x972$ResultItem> list2;
        String str;
        String str2;
        Iterator<oidb_0x972$ResultItem> it;
        JSONObject jSONObject;
        int optInt;
        int optInt2;
        int optInt3;
        long j3;
        if (QLog.isColorLevel()) {
            QLog.d("ConditionSearch.Manager", 2, "convert0x972ResultToCondFitUserList");
        }
        ArrayList arrayList = new ArrayList();
        if (oidb_0x972_rspbody.item_groups.has()) {
            list = oidb_0x972_rspbody.item_groups.get();
        } else {
            list = null;
        }
        if (list != null) {
            if (QLog.isColorLevel()) {
                QLog.d("ConditionSearch.Manager", 2, "convert0x972ResultToCondFitUserList group count = " + list.size());
            }
            for (oidb_0x972$ResultItemGroup oidb_0x972_resultitemgroup : list) {
                if (oidb_0x972_resultitemgroup.result_items.has()) {
                    list2 = oidb_0x972_resultitemgroup.result_items.get();
                } else {
                    list2 = null;
                }
                if (list2 != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ConditionSearch.Manager", 2, "convert0x972ResultToCondFitUserList curGroupItemcount = " + list2.size());
                    }
                    for (Iterator<oidb_0x972$ResultItem> it5 = list2.iterator(); it5.hasNext(); it5 = it) {
                        oidb_0x972$ResultItem next = it5.next();
                        CondFitUser condFitUser = new CondFitUser();
                        if (!next.result_id.has()) {
                            str = "0";
                        } else {
                            str = next.result_id.get().toStringUtf8();
                        }
                        try {
                            condFitUser.lUIN = Long.parseLong(str);
                        } catch (NumberFormatException e16) {
                            if (QLog.isColorLevel()) {
                                QLog.d("ConditionSearch.Manager", 2, "convert0x972ResultToCondFitUserList NumberFormatException", e16);
                            }
                        }
                        String str3 = "";
                        if (!next.name.has()) {
                            str2 = "";
                        } else {
                            str2 = next.name.get().toStringUtf8();
                        }
                        condFitUser.strNick = str2;
                        if (next.extension.has()) {
                            str3 = next.extension.get().toStringUtf8();
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("ConditionSearch.Manager", 2, "convert0x972ResultToCondFitUserList extensionString = " + str3);
                        }
                        try {
                            jSONObject = new JSONObject(str3);
                            int optInt4 = jSONObject.optInt("gender");
                            int optInt5 = jSONObject.optInt("age");
                            int optInt6 = jSONObject.optInt("occupationID");
                            condFitUser.cSex = (byte) optInt4;
                            condFitUser.dwAge = optInt5;
                            condFitUser.iOccupationId = optInt6;
                            int optInt7 = jSONObject.optInt("countryID");
                            optInt = jSONObject.optInt("provinceID");
                            optInt2 = jSONObject.optInt("cityID");
                            optInt3 = jSONObject.optInt("constellationID");
                            j3 = optInt7;
                            condFitUser.dwCountry = j3;
                            it = it5;
                        } catch (JSONException e17) {
                            e = e17;
                            it = it5;
                        }
                        try {
                            condFitUser.dwProvince = optInt;
                            condFitUser.dwCity = optInt2;
                            condFitUser.cConstellationId = (byte) optInt3;
                        } catch (JSONException e18) {
                            e = e18;
                            if (!QLog.isColorLevel()) {
                            }
                            arrayList.add(condFitUser);
                        }
                        try {
                            condFitUser.locDesc = ((ConditionSearchManager) this.f194496d.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER)).Q(new String[]{n(j3), n(condFitUser.dwProvince), n(condFitUser.dwCity), "0"});
                            condFitUser.personalSignature = jSONObject.optString("longnick");
                        } catch (JSONException e19) {
                            e = e19;
                            if (!QLog.isColorLevel()) {
                                QLog.d("ConditionSearch.Manager", 2, "convert0x972ResultToCondFitUserList JSONException", e);
                            }
                            arrayList.add(condFitUser);
                        }
                        arrayList.add(condFitUser);
                    }
                }
            }
        }
        return arrayList;
    }

    public static final String n(long j3) {
        if (j3 == 0) {
            return "0";
        }
        StringBuilder sb5 = new StringBuilder(6);
        while (j3 != 0) {
            try {
                sb5.append((char) (j3 % 256));
                j3 >>= 8;
            } catch (OutOfMemoryError e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("ConditionSearch.Manager", 2, e16, new Object[0]);
                }
                return "0";
            }
        }
        return sb5.reverse().toString();
    }

    public static final int p(String str) {
        if (TextUtils.isEmpty(str) || str.equals("0")) {
            return 0;
        }
        int length = str.length();
        int i3 = 0;
        for (int i16 = 0; i16 < length; i16++) {
            i3 += str.charAt(i16) << (((length - 1) - i16) * 8);
        }
        return i3;
    }

    public static String s() {
        if (H()) {
            return f194484l0;
        }
        return "admin_region_config";
    }

    public static String t() {
        return u(s());
    }

    public static String u(String str) {
        return BaseApplicationImpl.getApplication().getFilesDir() + "/pddata/prd/condition_search/" + str;
    }

    public int A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        if (this.f194500f) {
            return 0;
        }
        return this.f194508m.getInt("key_job_index" + this.f194496d.getCurrentAccountUin(), 0);
    }

    public String[] B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (String[]) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        if (this.Q == null) {
            String[] strArr = new String[4];
            this.Q = strArr;
            strArr[0] = this.f194508m.getString("key_loc_country_code" + this.f194496d.getCurrentAccountUin(), "0");
            this.Q[1] = this.f194508m.getString("key_loc_prov_code" + this.f194496d.getCurrentAccountUin(), "0");
            this.Q[2] = this.f194508m.getString("key_loc_city_code" + this.f194496d.getCurrentAccountUin(), "0");
            this.Q[3] = this.f194508m.getString("key_loc_dist_code" + this.f194496d.getCurrentAccountUin(), "0");
        }
        return this.Q;
    }

    public String C(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (String) iPatchRedirector.redirect((short) 35, (Object) this, i3);
        }
        if (i3 == 0) {
            return this.f194508m.getString("location_string" + this.f194496d.getCurrentAccountUin(), IProfileCardConst.NAME_NO_LIMIT);
        }
        return this.f194508m.getString("home_string" + this.f194496d.getCurrentAccountUin(), IProfileCardConst.NAME_NO_LIMIT);
    }

    public int D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        int i3 = 0;
        if (this.f194500f) {
            Card r16 = ((FriendsManager) this.f194496d.getManager(QQManagerFactory.FRIENDS_MANAGER)).r(this.f194496d.getCurrentAccountUin());
            if (r16 == null) {
                return 0;
            }
            if (r16.shGender == 0) {
                i3 = 2;
            }
            this.f194508m.edit().putInt("key_sex_index" + this.f194496d.getCurrentAccountUin(), i3).commit();
            return i3;
        }
        return this.f194508m.getInt("key_sex_index" + this.f194496d.getCurrentAccountUin(), 0);
    }

    public int E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        if (this.f194500f) {
            return 0;
        }
        return this.f194508m.getInt("key_xingzuo_index" + this.f194496d.getCurrentAccountUin(), 0);
    }

    public boolean F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this)).booleanValue();
        }
        boolean z16 = this.f194508m.getBoolean("key_first_select_location" + this.f194496d.getCurrentAccountUin(), true);
        if (z16) {
            this.f194508m.edit().putBoolean("key_first_select_location" + this.f194496d.getCurrentAccountUin(), false).commit();
        }
        return z16;
    }

    void J(boolean z16, List<CondFitUser> list, boolean z17, int i3) {
        this.f194496d.removeObserver(this.f194504h0);
        if (this.f194507j0 != null) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(this.f194507j0);
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                ((e) it.next()).a(z16, list, z17, i3);
            }
        }
    }

    public void K() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        if (this.f194500f) {
            this.f194500f = false;
            this.f194508m.edit().putBoolean("key_frist_run_in_5_2" + this.f194496d.getCurrentAccountUin(), false).commit();
            this.f194508m.edit().putBoolean("key_frist_run_add_contact" + this.f194496d.getCurrentAccountUin(), false).commit();
        }
    }

    public void L(GetResourceRespInfo getResourceRespInfo) {
        Object obj;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) getResourceRespInfo);
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onCheckupConfig | resp = ");
            sb5.append(getResourceRespInfo);
            sb5.append(" | iResult = ");
            if (getResourceRespInfo != null) {
                i3 = getResourceRespInfo.iResult;
            } else {
                i3 = -1000;
            }
            sb5.append(i3);
            sb5.append(", needDownloadNow=");
            sb5.append(this.F);
            QLog.d("ConditionSearch.Manager", 2, sb5.toString());
        }
        if (!H() && (getResourceRespInfo == null || getResourceRespInfo.iResult != 0)) {
            I(false);
            return;
        }
        String str = "";
        if (QLog.isColorLevel()) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("onCheckupConfig | local version = ");
            sb6.append(this.C);
            sb6.append(" | server version = ");
            if (getResourceRespInfo == null) {
                obj = "";
            } else {
                obj = Long.valueOf(getResourceRespInfo.uiNewVer);
            }
            sb6.append(obj);
            QLog.d("ConditionSearch.Manager", 2, sb6.toString());
        }
        if ((H() && G()) || (!H() && getResourceRespInfo != null && this.C != getResourceRespInfo.uiNewVer)) {
            if (H()) {
                str = com.tencent.relation.common.config.toggle.c.f364697j.d("region_download_url", "");
            } else if (getResourceRespInfo != null) {
                str = getResourceRespInfo.strResURL_big;
            }
            String str2 = str;
            if (H() && G()) {
                com.tencent.relation.common.utils.i.c().l(str2);
            }
            this.E = str2;
            if (TextUtils.isEmpty(str2)) {
                if (QLog.isColorLevel()) {
                    QLog.e("ConditionSearch.Manager", 2, "onCheckupConfig | url is null");
                }
                I(false);
                return;
            }
            File file = new File(u("temp_admin_regin_config"));
            DownloadTask downloadTask = new DownloadTask(this.f194496d, str2, getResourceRespInfo, file);
            if (this.F) {
                this.F = false;
                downloadTask.realStart();
                return;
            }
            boolean requestPreDownload = ((IPreDownloadController) this.f194496d.getRuntimeService(IPreDownloadController.class)).requestPreDownload(10023, PreDownloadConstants.DEPARTMENT_PRD, str2, 0, str2, file.getAbsolutePath(), 2, 0, false, downloadTask);
            if (QLog.isColorLevel()) {
                QLog.d("ConditionSearch.Manager", 2, "innerDownload, IPreDownloadController.ret=" + requestPreDownload);
            }
            if (!requestPreDownload) {
                I(false);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void M(int i3, File file, GetResourceRespInfo getResourceRespInfo) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), file, getResourceRespInfo);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ConditionSearch.Manager", 2, "onConfigFileDownloadSuccess, result=" + i3 + ", file=" + file + ", resp=" + getResourceRespInfo);
        }
        if (i3 == 0) {
            if (H()) {
                try {
                    ZipUtils.unZipFile(file, u(f194483k0));
                } catch (IOException e16) {
                    QLog.e("ConditionSearch.Manager", 1, e16, new Object[0]);
                }
            } else {
                File file2 = new File(u("admin_region_config"));
                if (!file.renameTo(file2) && !file.renameTo(file2) && !file.renameTo(file2)) {
                    z16 = false;
                    if (QLog.isColorLevel()) {
                        QLog.d("ConditionSearch.Manager", 2, "onCheckupConfig | rename result = " + z16);
                    }
                } else {
                    this.C = getResourceRespInfo.uiNewVer;
                    this.f194508m.edit().putLong("key_config_version", this.C).commit();
                }
            }
            z16 = true;
            if (QLog.isColorLevel()) {
            }
        } else {
            z16 = true;
        }
        if (i3 == 0 && z16) {
            z17 = true;
        }
        I(z17);
    }

    public String[] N(String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (String[]) iPatchRedirector.redirect((short) 40, (Object) this, (Object) strArr);
        }
        String[] strArr2 = null;
        if (strArr != null && strArr.length == 4) {
            boolean z16 = false;
            if (!"-1".equals(strArr[0])) {
                if (this.f194503h == null) {
                    if (QLog.isColorLevel()) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("praseCodeArrayToAddress addressData == null is ");
                        if (this.f194503h == null) {
                            z16 = true;
                        }
                        sb5.append(z16);
                        QLog.d("ConditionSearch.Manager", 2, sb5.toString());
                    }
                    return null;
                }
                strArr2 = new String[]{"", "", "", ""};
                if ("-1".equals(strArr[0])) {
                    return strArr2;
                }
                BaseAddress baseAddress = this.f194503h.f202020a.get(strArr[0]);
                if (baseAddress == null) {
                    return strArr2;
                }
                strArr2[0] = baseAddress.name;
                for (int i3 = 1; i3 < 4; i3++) {
                    if (!"0".equals(strArr[i3])) {
                        BaseAddress baseAddress2 = baseAddress.dataMap.get(strArr[i3]);
                        if (baseAddress2 == null) {
                            break;
                        }
                        strArr2[i3] = baseAddress2.name;
                        baseAddress = baseAddress2;
                    }
                }
            }
        }
        return strArr2;
    }

    public String O(String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (String) iPatchRedirector.redirect((short) 37, (Object) this, (Object) strArr);
        }
        String Q = Q(strArr);
        if ("1".equals(strArr[0]) && Q.split("-").length > 1) {
            return Q.substring(Q.indexOf("-") + 1, Q.length());
        }
        return Q;
    }

    public void P(Card card) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) card);
            return;
        }
        this.L = true;
        this.M = card;
        h(this.N);
        this.f194496d.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.app.ConditionSearchManager.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ConditionSearchManager.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                int i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                int j3 = ConditionSearchManager.this.j();
                if (j3 != 0) {
                    i3 = ConditionSearchManager.this.g0(j3);
                } else {
                    i3 = -1;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ConditionSearch.Manager", 2, "pendCardParseRequest | check reuslt = " + j3 + " | update result = " + i3);
                }
                if (j3 == 0) {
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.app.ConditionSearchManager.4.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            try {
                                if (ConditionSearchManager.this.M != null) {
                                    Card card2 = ConditionSearchManager.this.M;
                                    String str = card2.strLocationCodes;
                                    String str2 = "";
                                    if (str != null) {
                                        String[] split = str.split("-");
                                        if (QLog.isColorLevel()) {
                                            QLog.d("ConditionSearch.Manager", 2, "parse location codes: " + card2.strLocationCodes);
                                        }
                                        String O = ConditionSearchManager.this.O(split);
                                        if (O.equals(IProfileCardConst.NAME_NO_LIMIT)) {
                                            O = "";
                                        }
                                        card2.strLocationDesc = O;
                                    }
                                    String str3 = card2.strHometownCodes;
                                    if (str3 != null) {
                                        String[] split2 = str3.split("-");
                                        if (QLog.isColorLevel()) {
                                            QLog.d("ConditionSearch.Manager", 2, "parse hometown codes: " + card2.strHometownCodes);
                                        }
                                        String O2 = ConditionSearchManager.this.O(split2);
                                        if (!O2.equals(IProfileCardConst.NAME_NO_LIMIT)) {
                                            str2 = O2;
                                        }
                                        card2.strHometownDesc = str2;
                                        String[] N = ConditionSearchManager.this.N(split2);
                                        if (N != null && N.length == 4) {
                                            card2.strHometownCountry = N[0];
                                            card2.strHometownProvince = N[1];
                                            card2.strHometownCity = N[2];
                                        }
                                    }
                                    ((FriendsManager) ConditionSearchManager.this.f194496d.getManager(QQManagerFactory.FRIENDS_MANAGER)).p0(card2);
                                    ((CardHandler) ConditionSearchManager.this.f194496d.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).notifyUI(43, true, card2);
                                }
                                ConditionSearchManager.this.L = false;
                                ConditionSearchManager.this.M = null;
                                ConditionSearchManager conditionSearchManager = ConditionSearchManager.this;
                                conditionSearchManager.o(conditionSearchManager.N);
                            } catch (Exception e16) {
                                QLog.e("ConditionSearch.Manager", 1, "pendCardParseRequest fail!", e16);
                            }
                        }
                    }, 128, null, true);
                }
            }
        });
    }

    public String Q(String[] strArr) {
        BaseAddress baseAddress;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return (String) iPatchRedirector.redirect((short) 38, (Object) this, (Object) strArr);
        }
        if (strArr == null || strArr.length != 4 || "-1".equals(strArr[0])) {
            return "0";
        }
        AddressData addressData = this.f194503h;
        if (addressData == null) {
            if (QLog.isColorLevel()) {
                QLog.d("ConditionSearch.Manager", 2, "praseCodeArrayToAddress addressData == null is");
            }
            return IProfileCardConst.NAME_NO_LIMIT;
        }
        if ("-1".equals(strArr[0])) {
            return IProfileCardConst.NAME_NO_LIMIT;
        }
        HashMap<String, BaseAddress> hashMap = addressData.f202020a;
        if (hashMap != null) {
            baseAddress = hashMap.get(strArr[0]);
        } else {
            baseAddress = null;
        }
        if (baseAddress == null) {
            return IProfileCardConst.NAME_NO_LIMIT;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(baseAddress.name);
        for (int i3 = 1; i3 < 4; i3++) {
            if (!"0".equals(strArr[i3])) {
                baseAddress = baseAddress.dataMap.get(strArr[i3]);
                if (baseAddress == null) {
                    break;
                }
                sb5.append("-");
                sb5.append(baseAddress.name);
            }
        }
        return sb5.toString();
    }

    public String R(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return (String) iPatchRedirector.redirect((short) 42, (Object) this, (Object) str);
        }
        if (str.startsWith(CountrySelectView.NAME_CHINA)) {
            String[] split = StringUtil.split(str, '-');
            if (split.length >= 2) {
                StringBuilder sb5 = new StringBuilder();
                for (int i3 = 1; i3 < split.length; i3++) {
                    sb5.append(split[i3]);
                    if (i3 != split.length - 1) {
                        sb5.append("-");
                    }
                }
                return sb5.toString();
            }
            return str;
        }
        return str;
    }

    public void S(Object obj) {
        LinkedList<e> linkedList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, obj);
            return;
        }
        if (obj instanceof c) {
            LinkedList<c> linkedList2 = this.f194506i0;
            if (linkedList2 != null) {
                linkedList2.remove(obj);
                return;
            }
            return;
        }
        if ((obj instanceof e) && (linkedList = this.f194507j0) != null) {
            linkedList.remove(obj);
        }
    }

    public void T(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.f194508m.edit().putInt("key_age_index_v2_1" + this.f194496d.getCurrentAccountUin(), i3).commit();
        this.f194508m.edit().putInt("key_age_index_v2_2" + this.f194496d.getCurrentAccountUin(), i16).commit();
    }

    public void U(String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) strArr);
            return;
        }
        if (strArr == null) {
            return;
        }
        if (strArr.length == 4) {
            this.P = (String[]) strArr.clone();
            this.f194508m.edit().putString("key_cur_loc_country_code" + this.f194496d.getCurrentAccountUin(), this.P[0]).putString("key_cur_loc_prov_code" + this.f194496d.getCurrentAccountUin(), this.P[1]).putString("key_cur_loc_city_code" + this.f194496d.getCurrentAccountUin(), this.P[2]).putString("key_cur_loc_dist_code" + this.f194496d.getCurrentAccountUin(), this.P[3]).commit();
            return;
        }
        throw new IllegalArgumentException("Error size " + strArr.length);
    }

    public void V(String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) strArr);
            return;
        }
        if (strArr == null) {
            return;
        }
        if (strArr.length == 4) {
            this.R = (String[]) strArr.clone();
            this.f194508m.edit().putString("key_home_country_code" + this.f194496d.getCurrentAccountUin(), this.R[0]).putString("key_home_prov_code" + this.f194496d.getCurrentAccountUin(), this.R[1]).putString("key_home_city_code" + this.f194496d.getCurrentAccountUin(), this.R[2]).putString("key_home_dist_code" + this.f194496d.getCurrentAccountUin(), this.R[3]).commit();
            return;
        }
        throw new IllegalArgumentException("Error size " + strArr.length);
    }

    public void W(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
            return;
        }
        this.f194508m.edit().putInt("key_job_index" + this.f194496d.getCurrentAccountUin(), i3).commit();
    }

    public void X(String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) strArr);
            return;
        }
        if (strArr == null) {
            return;
        }
        if (strArr.length == 4) {
            this.Q = (String[]) strArr.clone();
            this.f194508m.edit().putString("key_loc_country_code" + this.f194496d.getCurrentAccountUin(), this.Q[0]).putString("key_loc_prov_code" + this.f194496d.getCurrentAccountUin(), this.Q[1]).putString("key_loc_city_code" + this.f194496d.getCurrentAccountUin(), this.Q[2]).putString("key_loc_dist_code" + this.f194496d.getCurrentAccountUin(), this.Q[3]).commit();
            return;
        }
        throw new IllegalArgumentException("Error size " + strArr.length);
    }

    public void Y(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, i3, (Object) str);
            return;
        }
        if (i3 == 0) {
            this.f194508m.edit().putString("location_string" + this.f194496d.getCurrentAccountUin(), str).commit();
            return;
        }
        this.f194508m.edit().putString("home_string" + this.f194496d.getCurrentAccountUin(), str).commit();
    }

    public void a0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, i3);
            return;
        }
        this.f194508m.edit().putInt("key_sex_index" + this.f194496d.getCurrentAccountUin(), i3).commit();
    }

    public void b0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, i3);
            return;
        }
        this.f194508m.edit().putInt("key_xingzuo_index" + this.f194496d.getCurrentAccountUin(), i3).commit();
    }

    public void c0(boolean z16, String str, int i3, int i16, int i17, String[] strArr, String[] strArr2, int i18, int i19, int i26) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, this, Boolean.valueOf(z16), str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), strArr, strArr2, Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26));
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("seachFriend | restart = ");
            sb5.append(z16);
            sb5.append(" | keyword = ");
            sb5.append(str);
            sb5.append(" | sexIndex = ");
            sb5.append(i3);
            sb5.append(" | ageIndex1 = ");
            sb5.append(i16);
            sb5.append(" | ageIndex2 = ");
            sb5.append(i17);
            sb5.append(" | jobIndex = ");
            sb5.append(i18);
            sb5.append(" | xingzuoIndex = ");
            sb5.append(i19);
            sb5.append(" | searchFromMore = ");
            sb5.append(i26);
            if (strArr != null && strArr.length > 0) {
                sb5.append(" | locCodes = ");
                for (String str2 : strArr) {
                    sb5.append(str2);
                    sb5.append("\u3001");
                }
            }
            if (strArr2 != null && strArr2.length > 0) {
                sb5.append(" | homeCodes = ");
                for (String str3 : strArr2) {
                    sb5.append(str3);
                    sb5.append("\u3001");
                }
            }
            QLog.d("ConditionSearch.Manager", 2, sb5.toString());
        }
        if (z16) {
            this.S++;
            this.T = str;
            this.U = i3;
            this.V = i16;
            this.W = i17;
            this.Z = strArr;
            this.f194493a0 = strArr2;
            this.X = i18;
            this.Y = i19;
            this.f194494b0 = -1;
            this.f194495c0 = 0L;
            this.f194497d0 = null;
        } else if (!this.f194502g0) {
            throw new RuntimeException("No more elements");
        }
        this.f194499e0 = 0;
        this.f194501f0 = null;
        this.f194496d.addObserver(this.f194504h0);
        ((FriendListHandler) this.f194496d.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).condtionalSearchFriendBy0x972(this.S, this.f194494b0 + 1, this.f194497d0, this.T, this.U, this.V, this.W, this.Z, this.f194493a0, this.X, this.Y, i26);
    }

    public void d0(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) dVar);
        } else {
            this.G = dVar;
        }
    }

    public boolean e0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.f194500f;
    }

    public String[] f0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return (String[]) iPatchRedirector.redirect((short) 43, (Object) this, (Object) str);
        }
        String[] strArr = {IProfileCardConst.NAME_NO_LIMIT, IProfileCardConst.NAME_NO_LIMIT};
        if (!TextUtils.isEmpty(str) && !IProfileCardConst.NAME_NO_LIMIT.equals(str)) {
            int indexOf = str.indexOf("-");
            if (indexOf != -1) {
                strArr[0] = str.substring(0, indexOf);
                strArr[1] = str.substring(indexOf + 1);
            } else {
                strArr[0] = str;
            }
        }
        return strArr;
    }

    public void g(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, obj);
            return;
        }
        if (obj instanceof c) {
            if (this.f194506i0 == null) {
                this.f194506i0 = new LinkedList<>();
            }
            if (!this.f194506i0.contains(obj)) {
                this.f194506i0.add((c) obj);
                return;
            }
            return;
        }
        if (obj instanceof e) {
            if (this.f194507j0 == null) {
                this.f194507j0 = new LinkedList<>();
            }
            if (!this.f194507j0.contains(obj)) {
                this.f194507j0.add((e) obj);
            }
        }
    }

    public int g0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, i3)).intValue();
        }
        return h0(i3, false);
    }

    public synchronized void h(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, obj);
            return;
        }
        if (!this.K.containsKey(Integer.valueOf(obj.hashCode()))) {
            this.K.put(Integer.valueOf(obj.hashCode()), new WeakReference<>(obj));
            this.J = true;
            g0(j());
            if (obj instanceof ConditionSearchFriendActivity) {
                this.f194498e = false;
                this.f194508m.edit().putBoolean("key_first_run" + this.f194496d.getCurrentAccountUin(), false).commit();
            }
        }
    }

    public int h0(int i3, boolean z16) {
        boolean z17;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Boolean.valueOf(z16))).intValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("ConditionSearch.Manager", 2, "update, result=" + i3 + ", downloadNow=" + z16);
        }
        if (i3 == 1) {
            long currentTimeMillis = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("update | isCheckingUpdate = ");
                sb5.append(this.I);
                sb5.append(" | interval is enough ");
                if (Math.abs(currentTimeMillis - this.D) >= 60000) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                sb5.append(z18);
                sb5.append(" | isNetAvaiable = ");
                sb5.append(NetworkUtil.isNetSupport(this.f194496d.getApp()));
                QLog.d("ConditionSearch.Manager", 2, sb5.toString());
            }
            if (this.I) {
                if (z16 && !TextUtils.isEmpty(this.E)) {
                    AbsPreDownloadTask cancelPreDownload = ((IPreDownloadController) this.f194496d.getRuntimeService(IPreDownloadController.class)).cancelPreDownload(this.E);
                    if (QLog.isColorLevel()) {
                        QLog.d("ConditionSearch.Manager", 2, "update, find task=" + cancelPreDownload);
                    }
                    if (cancelPreDownload != null && (cancelPreDownload instanceof DownloadTask)) {
                        ((DownloadTask) cancelPreDownload).realStart();
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.d("ConditionSearch.Manager", 2, "update mUrl might be null");
                }
                return 0;
            }
            if (Math.abs(currentTimeMillis - this.D) < 60000) {
                return 1;
            }
            if (!NetworkUtil.isNetSupport(this.f194496d.getApp())) {
                return 2;
            }
            if (!this.F && !z16) {
                z17 = false;
            } else {
                z17 = true;
            }
            this.F = z17;
            ConfigHandler configHandler = (ConfigHandler) this.f194496d.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER);
            configHandler.y3(null, configHandler.H2());
        } else if (i3 == 2) {
            return i0();
        }
        return 0;
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        d dVar = this.G;
        if (dVar != null) {
            dVar.a();
        }
    }

    public int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        int i3 = 1;
        boolean z16 = false;
        if (H()) {
            if (G()) {
                z16 = true;
            } else if (this.f194503h == null) {
                z16 = true;
                i3 = 2;
            } else {
                z16 = true;
                i3 = 0;
            }
        } else if (this.C != 0) {
            if (this.f194503h != null) {
                i3 = 0;
            }
            i3 = 2;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ConditionSearch.Manager", 2, "checkUpdate | result = " + i3 + " | isToggle = " + z16);
        }
        return i3;
    }

    public String l(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return (String) iPatchRedirector.redirect((short) 39, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String[] split = str.split("-");
            if (split[0].equals(CountrySelectView.NAME_CHINA)) {
                if (split.length > 2) {
                    str = split[2];
                    if (split.length > 3) {
                        str = str + "-" + split[3];
                    }
                } else if (split.length > 1) {
                    str = split[1];
                }
            } else if (split.length > 2) {
                str = split[split.length - 2] + "-" + split[split.length - 1];
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("ConditionSearch.Manager", 2, "", e16);
            }
        }
        return str;
    }

    public synchronized void o(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, obj);
            return;
        }
        this.K.remove(Integer.valueOf(obj.hashCode()));
        if (this.K.size() == 0) {
            this.J = false;
            this.f194503h = null;
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this);
            return;
        }
        AddressData addressData = this.f194503h;
        if (addressData != null) {
            addressData.a();
            this.f194503h = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0043, code lost:
    
        if (r4 <= 11) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004c, code lost:
    
        if (r4 <= 17) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0055, code lost:
    
        if (r4 <= 21) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int[] q() {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (int[]) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        if (this.f194500f) {
            Card r16 = ((FriendsManager) this.f194496d.getManager(QQManagerFactory.FRIENDS_MANAGER)).r(this.f194496d.getCurrentAccountUin());
            if (r16 != null) {
                byte b16 = r16.age;
                if (b16 > 5 && b16 < 60) {
                    i3 = 6;
                    if (b16 >= 6) {
                        i16 = 11;
                    }
                    i3 = 12;
                    if (b16 >= 12) {
                        i16 = 17;
                    }
                    i3 = 18;
                    if (b16 >= 18) {
                        i16 = 21;
                    }
                    if (r16.shGender != 0) {
                        i3 = b16 - 5;
                        i16 = b16 + 10;
                    } else {
                        i16 = b16 + 5;
                    }
                } else {
                    i3 = 0;
                    i16 = 0;
                }
                this.f194508m.edit().putInt("key_age_index_v2_1" + this.f194496d.getCurrentAccountUin(), i3).commit();
                this.f194508m.edit().putInt("key_age_index_v2_2" + this.f194496d.getCurrentAccountUin(), i16).commit();
            } else {
                i3 = 0;
                i16 = 0;
            }
        } else {
            i3 = this.f194508m.getInt("key_age_index_v2_1" + this.f194496d.getCurrentAccountUin(), 0);
            i16 = this.f194508m.getInt("key_age_index_v2_2" + this.f194496d.getCurrentAccountUin(), 0);
        }
        return new int[]{i3, i16};
    }

    public String r(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (String) iPatchRedirector.redirect((short) 26, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        if ((i3 <= i16 || i16 == 0) && i3 >= 0 && i16 >= 0) {
            if (i3 == 0 && i16 == 0) {
                return f194486n0[0];
            }
            if (i3 == 0 && i16 != 0) {
                return f194486n0[i16] + "\u5c81\u53ca\u4ee5\u4e0b";
            }
            if (i3 != 0 && i16 == 0) {
                return f194486n0[i3] + "\u5c81\u53ca\u4ee5\u4e0a";
            }
            if (i3 == i16) {
                return f194486n0[i3] + "\u5c81";
            }
            StringBuilder sb5 = new StringBuilder();
            String[] strArr = f194486n0;
            sb5.append(strArr[i3]);
            sb5.append("-");
            sb5.append(strArr[i16]);
            sb5.append("\u5c81");
            return sb5.toString();
        }
        return f194486n0[0];
    }

    public final long v(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, (Object) this, z16)).longValue();
        }
        if (z16) {
            this.D = System.currentTimeMillis();
            this.f194508m.edit().putLong("key_last_checkup_time", this.D).commit();
            this.I = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ConditionSearch.Manager", 2, "getConfigVersion | version = " + this.C);
        }
        return this.C;
    }

    public BaseAddress w(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (BaseAddress) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        AddressData addressData = this.f194503h;
        if (addressData != null) {
            return addressData.f202020a.get(str);
        }
        return null;
    }

    public List<BaseAddress> x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        if (this.f194503h != null) {
            ArrayList arrayList2 = new ArrayList(this.f194503h.f202020a.size());
            arrayList2.addAll(this.f194503h.f202020a.values());
            Collections.sort(arrayList2, new a());
            return arrayList2;
        }
        return arrayList;
    }

    public String[] y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (String[]) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        if (this.P == null) {
            String[] strArr = new String[4];
            this.P = strArr;
            strArr[0] = this.f194508m.getString("key_cur_loc_country_code" + this.f194496d.getCurrentAccountUin(), "0");
            this.P[1] = this.f194508m.getString("key_cur_loc_prov_code" + this.f194496d.getCurrentAccountUin(), "0");
            this.P[2] = this.f194508m.getString("key_cur_loc_city_code" + this.f194496d.getCurrentAccountUin(), "0");
            this.P[3] = this.f194508m.getString("key_cur_loc_dist_code" + this.f194496d.getCurrentAccountUin(), "0");
        }
        return this.P;
    }

    public String[] z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (String[]) iPatchRedirector.redirect((short) 32, (Object) this);
        }
        if (this.R == null) {
            String[] strArr = new String[4];
            this.R = strArr;
            strArr[0] = this.f194508m.getString("key_home_country_code" + this.f194496d.getCurrentAccountUin(), "0");
            this.R[1] = this.f194508m.getString("key_home_prov_code" + this.f194496d.getCurrentAccountUin(), "0");
            this.R[2] = this.f194508m.getString("key_home_city_code" + this.f194496d.getCurrentAccountUin(), "0");
            this.R[3] = this.f194508m.getString("key_home_dist_code" + this.f194496d.getCurrentAccountUin(), "0");
        }
        return this.R;
    }
}
