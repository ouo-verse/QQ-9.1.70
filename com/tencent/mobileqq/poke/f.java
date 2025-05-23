package com.tencent.mobileqq.poke;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.ReportConst;
import com.tencent.qqnt.aio.adapter.api.IAIOPokeApi;
import cooperation.photoplus.sticker.Sticker;
import java.io.File;
import java.io.IOException;
import java.util.BitSet;
import java.util.Vector;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes16.dex */
public class f {
    static IPatchRedirector $redirector_;
    public static int A;
    public static int B;
    private static String C;
    public static final String D;
    public static final String E;
    public static final String F;
    public static final String G;
    public static final String H;
    public static final Vector<Integer> I;
    public static final Vector<Integer> J;
    public static final Vector<Integer> K;
    public static final Vector<Integer> L;
    public static int M;
    public static boolean N;
    public static volatile boolean O;
    public static volatile boolean P;
    public static int Q;
    public static boolean R;
    public static volatile boolean S;
    public static final String T;
    private static BitSet U;
    private static final String[] V;
    private static final int[] W;

    /* renamed from: a, reason: collision with root package name */
    public static String f259014a;

    /* renamed from: b, reason: collision with root package name */
    private static String f259015b;

    /* renamed from: c, reason: collision with root package name */
    private static String f259016c;

    /* renamed from: d, reason: collision with root package name */
    private static String f259017d;

    /* renamed from: e, reason: collision with root package name */
    private static String f259018e;

    /* renamed from: f, reason: collision with root package name */
    private static String f259019f;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f259020g;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f259021h;

    /* renamed from: i, reason: collision with root package name */
    private static boolean f259022i;

    /* renamed from: j, reason: collision with root package name */
    private static boolean f259023j;

    /* renamed from: k, reason: collision with root package name */
    private static boolean f259024k;

    /* renamed from: l, reason: collision with root package name */
    public static int f259025l;

    /* renamed from: m, reason: collision with root package name */
    public static int f259026m;

    /* renamed from: n, reason: collision with root package name */
    public static int f259027n;

    /* renamed from: o, reason: collision with root package name */
    public static int f259028o;

    /* renamed from: p, reason: collision with root package name */
    public static int f259029p;

    /* renamed from: q, reason: collision with root package name */
    public static int f259030q;

    /* renamed from: r, reason: collision with root package name */
    public static int f259031r;

    /* renamed from: s, reason: collision with root package name */
    public static int f259032s;

    /* renamed from: t, reason: collision with root package name */
    public static int f259033t;

    /* renamed from: u, reason: collision with root package name */
    public static int f259034u;

    /* renamed from: v, reason: collision with root package name */
    public static String f259035v;

    /* renamed from: w, reason: collision with root package name */
    public static String f259036w;

    /* renamed from: x, reason: collision with root package name */
    public static String f259037x;

    /* renamed from: y, reason: collision with root package name */
    public static String f259038y;

    /* renamed from: z, reason: collision with root package name */
    public static int f259039z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a implements INetEngineListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f259040d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f259041e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.tencent.aio.api.runtime.a f259042f;

        a(String str, String str2, com.tencent.aio.api.runtime.a aVar) {
            this.f259040d = str;
            this.f259041e = str2;
            this.f259042f = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, str2, aVar);
            }
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp netResp) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) netResp);
                return;
            }
            int i3 = netResp.mResult;
            if (i3 == 3) {
                if (QLog.isColorLevel()) {
                    QLog.d(f.f259014a, 2, "pe res download repeating ");
                    return;
                }
                return;
            }
            if (i3 == 0) {
                String str = netResp.mReq.mOutPath;
                String calcMd5 = FileUtils.calcMd5(str);
                String str2 = this.f259040d;
                if (calcMd5 != null && calcMd5.equalsIgnoreCase(this.f259041e)) {
                    try {
                        FileUtils.uncompressZip(str, str2, false);
                        com.tencent.mobileqq.poke.utils.b.f259090a.a(str2);
                        z16 = true;
                    } catch (IOException unused) {
                        if (QLog.isColorLevel()) {
                            QLog.d(f.f259014a, 2, "downloadRes.onResp download succ but unzip is failed");
                        }
                    }
                    FileUtils.deleteFile(str);
                } else if (QLog.isColorLevel()) {
                    QLog.d(f.f259014a, 2, "downloadRes.onResp download succ but md5 is mismatched");
                }
                z16 = false;
                FileUtils.deleteFile(str);
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d(f.f259014a, 2, "downloadRes.onResp failed ");
                }
                z16 = false;
            }
            if (z16) {
                com.tencent.mobileqq.poke.utils.c.e(true);
                f.O = true;
                QLog.d(f.f259014a, 2, "aioContext.getMessenger().send(AIOMsgListEvent.PokeEmoResReady.INSTANCE);");
                this.f259042f.e().h(AIOMsgListEvent.PokeEmoResReady.f188358d);
            } else {
                f.Q++;
            }
            if (QLog.isColorLevel()) {
                QLog.d(f.f259014a, 2, "downloadRes.onResp download result = " + z16);
            }
            f.P = false;
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, netReq, Long.valueOf(j3), Long.valueOf(j16));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppRuntime f259043d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f259044e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.tencent.qqnt.pluspanel.logic.c f259045f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Activity f259046h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f259047i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ int f259048m;

        b(AppRuntime appRuntime, int i3, com.tencent.qqnt.pluspanel.logic.c cVar, Activity activity, String str, int i16) {
            this.f259043d = appRuntime;
            this.f259044e = i3;
            this.f259045f = cVar;
            this.f259046h = activity;
            this.f259047i = str;
            this.f259048m = i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, appRuntime, Integer.valueOf(i3), cVar, activity, str, Integer.valueOf(i16));
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            if (true == f.N) {
                f.N = false;
            }
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
            if (this.f259043d == null) {
                QLog.d("vaspoke", 4, "dialogInterfaceOnClick mApp is null.");
                return;
            }
            int i16 = this.f259044e;
            if ((2 == i16 || 4 == i16) && i3 == 1) {
                this.f259045f.b(this.f259046h, this.f259047i, this.f259048m, i16);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47412);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f259014a = "NTPokeItemHelper";
        f259015b = "";
        f259016c = "";
        f259017d = "";
        f259018e = "";
        f259019f = "";
        f259020g = false;
        f259021h = false;
        f259022i = false;
        f259023j = false;
        f259024k = false;
        f259025l = -1;
        f259026m = -1;
        f259027n = 10;
        f259028o = 60;
        f259029p = -1;
        f259030q = -1;
        f259031r = 10;
        f259032s = 60;
        f259033t = 0;
        f259034u = 0;
        f259039z = 0;
        A = 0;
        B = 50;
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        D = absolutePath;
        String str = absolutePath + "/Tencent/MobileQQ/";
        E = str;
        F = VFSAssistantUtils.getSDKPrivatePath(str);
        String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(str + ".vaspoke/");
        G = sDKPrivatePath;
        H = sDKPrivatePath + "vasPokeMarket.json";
        I = new Vector<>();
        J = new Vector<>();
        K = new Vector<>();
        L = new Vector<>();
        M = -1;
        N = false;
        O = false;
        P = false;
        Q = 0;
        R = true;
        T = VFSAssistantUtils.getSDKPrivatePath("Tencent/MobileQQ/poke/");
        U = null;
        V = new String[]{"chuo_icon", "bixin_icon", "zan_icon", "xinsui_icon", "666_icon", "dazhao_icon", "chuo_motion", "bixin_motion", "zan_motion", "xinsui_motion", "666_motion", "dazhao_motion"};
        W = new int[]{22, 22, 22, 22, 22, 22, 35, 99, 25, 60, 0, 0};
    }

    public static boolean b(AppRuntime appRuntime, com.tencent.aio.api.runtime.a aVar) {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.d(f259014a, 2, "checkPEResDownloaded mIsPeResDownloaded =  " + O);
        }
        if (O) {
            z16 = true;
        } else {
            z16 = false;
            if (!com.tencent.mobileqq.poke.utils.c.a()) {
                d(appRuntime);
                if (!TextUtils.isEmpty(f259035v) && !TextUtils.isEmpty(f259036w)) {
                    if (QLog.isColorLevel()) {
                        QLog.d(f259014a, 2, "peResUrl = " + f259035v + " ,peResMD5 = " + f259036w);
                    }
                    u((AppInterface) appRuntime, aVar, f259035v, f259036w, F);
                }
            } else if (!S) {
                S = true;
                if (!c.f258994a.a(f((AppInterface) appRuntime, 8))) {
                    O = false;
                    com.tencent.mobileqq.poke.utils.c.e(false);
                } else {
                    O = true;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(f259014a, 2, "checkPEResDownloaded isDownload = false");
                }
            } else {
                O = true;
            }
        }
        if (O) {
            c cVar = c.f258994a;
            if (!cVar.f()) {
                cVar.n(true);
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.poke.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        f.o();
                    }
                }, 64, null, true);
            }
        }
        return z16;
    }

    public static boolean c(AppRuntime appRuntime, CallBacker callBacker, com.tencent.qqnt.pluspanel.logic.c cVar) {
        String str = H;
        QQVasUpdateBusiness e16 = e();
        if (e16 != null) {
            str = e16.getBusinessItemInfo(21L, VasUpdateConstants.SCID_POKE_EFFECT_LIST).mSavePath;
        }
        if (VasUpdateUtil.getFileFromLocal(appRuntime, 21L, VasUpdateConstants.SCID_POKE_EFFECT_LIST, str, true, callBacker) != null) {
            return cVar.a();
        }
        return false;
    }

    public static void d(AppRuntime appRuntime) {
        if (appRuntime != null) {
            String account = appRuntime.getAccount();
            if (!f259020g || !f259015b.equals(account)) {
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(appRuntime.getApp());
                if (defaultSharedPreferences.contains(account + "_" + AppConstants.Preferences.POKE_CONFIG_VERSION)) {
                    f259025l = defaultSharedPreferences.getInt(account + "_" + AppConstants.Preferences.POKE_BAR_SWITCH, f259029p);
                    f259026m = defaultSharedPreferences.getInt(account + "_" + AppConstants.Preferences.POKE_PAD_SWITCH, f259030q);
                    f259028o = defaultSharedPreferences.getInt(account + "_" + AppConstants.Preferences.POKE_SEND_TIME_LIMITED, f259032s);
                    f259027n = defaultSharedPreferences.getInt(account + "_" + AppConstants.Preferences.POKE_SEND_COUNTS_LIMITED, f259031r);
                    f259033t = defaultSharedPreferences.getInt(account + "_" + AppConstants.Preferences.AIO_POKE_ENTRY_TYPE, 0);
                    f259034u = defaultSharedPreferences.getInt(account + "_" + AppConstants.Preferences.AIO_PE_VIEW_TYPE, 0);
                    f259035v = defaultSharedPreferences.getString(account + "_" + AppConstants.Preferences.POKE_EMO_RES_URL, "");
                    f259036w = defaultSharedPreferences.getString(account + "_" + AppConstants.Preferences.POKE_EMO_RES_MD5, "");
                    f259037x = defaultSharedPreferences.getString(account + "_" + AppConstants.Preferences.POKE_EMO_SURPRICE_INDEXS, "");
                    f259038y = defaultSharedPreferences.getString(account + "_" + AppConstants.Preferences.POKE_EMO_ORDER, "");
                    f259039z = defaultSharedPreferences.getInt(account + "_" + AppConstants.Preferences.AIO_PE_INPUT_SWITCH, 0);
                    A = defaultSharedPreferences.getInt(account + "_" + AppConstants.Preferences.AIO_PE_FEED_BACK_SWITCH, 0);
                    B = defaultSharedPreferences.getInt(account + "_" + AppConstants.Preferences.AIO_PE_BUBBLE_LIMIT_COUNT, 50);
                    M = defaultSharedPreferences.getInt(account + "_" + AppConstants.Preferences.AIO_PE_LAST_TAB_INDEX, -1);
                } else {
                    f259025l = f259029p;
                    f259026m = f259030q;
                    f259033t = 0;
                    f259034u = 0;
                    f259039z = 0;
                    A = 0;
                    B = 50;
                }
                f259015b = account;
                f259020g = true;
                if (QLog.isColorLevel()) {
                    QLog.d("pokeMsg", 2, String.format("getPokeSwitch, first init, bar switch: %d, pad switch: %d, uin: %s ,limited count:%d,limited time:%d,peInputSwitch:%d,entryType:%d,viewType:%d", Integer.valueOf(f259025l), Integer.valueOf(f259026m), f259015b, Integer.valueOf(f259027n), Integer.valueOf(f259028o), Integer.valueOf(f259039z), Integer.valueOf(f259033t), Integer.valueOf(f259034u)));
                }
            }
        }
    }

    public static QQVasUpdateBusiness e() {
        if (QQVasUpdateBusiness.isUseUpdateBusinessMigration(21L).booleanValue()) {
            try {
                return ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance((Long) 21L);
            } catch (Exception e16) {
                QLog.w(f259014a, 1, "getNewBusiness", e16);
                return null;
            }
        }
        return null;
    }

    public static String f(AppInterface appInterface, int i3) {
        d(appInterface);
        if (i3 != 5) {
            if (i3 != 6) {
                if (i3 != 7) {
                    if (i3 != 8) {
                        return null;
                    }
                    return f259038y;
                }
                return f259037x;
            }
            return f259036w;
        }
        return f259035v;
    }

    public static int g(AppRuntime appRuntime, int i3) {
        d(appRuntime);
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            switch (i3) {
                                case 9:
                                    return f259039z;
                                case 10:
                                    return B;
                                case 11:
                                    return f259034u;
                                default:
                                    return -1;
                            }
                        }
                        return f259033t;
                    }
                    return f259028o;
                }
                return f259027n;
            }
            return f259025l;
        }
        return f259026m;
    }

    public static String h(AppRuntime appRuntime) {
        if (appRuntime != null) {
            String account = appRuntime.getAccount();
            if (!f259021h || !f259016c.equals(account)) {
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(appRuntime.getApp());
                if (defaultSharedPreferences.contains(account + "_" + AppConstants.Preferences.POKE_CONFIG_VERSION)) {
                    String string = defaultSharedPreferences.getString(account + "_" + AppConstants.Preferences.POKE_PANEL_PLACE_CONFIG, "");
                    C = string;
                    if (string == null) {
                        C = "";
                    }
                }
                f259016c = account;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("pokeMsg", 2, "PokePanelPlaceInfo:" + C);
        }
        f259021h = true;
        return C;
    }

    public static String i() {
        return VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_POKE);
    }

    public static boolean j(int i3) {
        if (U == null) {
            BitSet bitSet = new BitSet(12);
            U = bitSet;
            bitSet.clear();
            U.set(6);
        }
        if (QLog.isColorLevel()) {
            QLog.d(f259014a, 2, "[res check] type:" + i3);
        }
        boolean z16 = U.get(i3);
        if (!z16) {
            StringBuilder sb5 = new StringBuilder();
            String str = F;
            sb5.append(str);
            sb5.append("poke/");
            String[] strArr = V;
            sb5.append(strArr[i3]);
            File file = new File(sb5.toString());
            if (QLog.isColorLevel()) {
                QLog.d(f259014a, 2, "[res dir]" + str + "poke/" + strArr[i3]);
            }
            if (file.exists() && file.isDirectory()) {
                String[] list = file.list();
                if (list != null) {
                    if (list.length == W[i3]) {
                        if (QLog.isColorLevel()) {
                            QLog.d(f259014a, 2, "[res checked]");
                        }
                        return true;
                    }
                    return z16;
                }
                return false;
            }
            return z16;
        }
        return z16;
    }

    public static boolean k() {
        if (A == 1) {
            return true;
        }
        return false;
    }

    private static boolean l(String str) {
        if (!"bubble".equals(str) && !ReportConst.ACTION.FULLSCREEN.equals(str) && !"view_aio".equals(str)) {
            return false;
        }
        return true;
    }

    public static boolean m(int i3) {
        if (i3 >= 0 && i3 <= 6) {
            if (i3 == 0) {
                return true;
            }
            return j(i3 - 1);
        }
        return false;
    }

    public static boolean n(String str) {
        if (!TextUtils.isEmpty(str) && AppSetting.b(str) >= 0) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f259014a, 2, "curr ver: " + AppSetting.f99551k + ", config qqVer:" + str);
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void o() {
        c.f258994a.k();
    }

    public static void p(ImageView imageView, int i3, int i16) {
        File file;
        if (i3 == 126) {
            QQVasUpdateBusiness e16 = e();
            if (e16 != null) {
                file = new File(e16.getSavePath(VasUpdateConstants.SCID_POKE_PANEL_PREFIX + i16) + "/pressed.png");
            } else {
                file = new File(G + i16 + "/pressed.png");
            }
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mLoadingDrawable = BaseApplication.getContext().getResources().getDrawable(R.drawable.fsn);
            obtain.mFailedDrawable = BaseApplication.getContext().getResources().getDrawable(R.drawable.fsn);
            imageView.setImageDrawable(URLDrawable.getDrawable(file, obtain));
            return;
        }
        imageView.setImageResource(i16);
    }

    public static void q(int i3) {
        A = i3;
    }

    public static void r(int i3, String str, String str2, String str3, String str4, int i16, int i17, int i18) {
        f259033t = i3;
        f259034u = i18;
        f259035v = str;
        f259036w = str2;
        f259037x = str3;
        f259038y = str4;
        f259039z = i16;
        B = i17;
        if (QLog.isColorLevel()) {
            QLog.d(f259014a, 2, "setPokeEmoPanelConfig|entryType: " + f259033t + ",peSurpriseIndexs: " + f259037x + ",peOders: " + str4);
        }
    }

    public static void s(String str) {
        f259021h = true;
        C = str;
    }

    public static void t(AppRuntime appRuntime, Activity activity, String str, String str2, int i3, int i16, com.tencent.qqnt.pluspanel.logic.c cVar) {
        b bVar = new b(appRuntime, i16, cVar, activity, str, i3);
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 0, HardCodeUtil.qqStr(R.string.pad), str, HardCodeUtil.qqStr(R.string.j6l), str2, bVar, bVar);
        if (createCustomDialog != null) {
            createCustomDialog.show();
        }
    }

    public static void u(AppInterface appInterface, com.tencent.aio.api.runtime.a aVar, String str, String str2, String str3) {
        if (!R) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f259014a, 2, "startDownloadPERes resUrl " + str + ",resMD5" + str2);
        }
        if (P) {
            if (QLog.isColorLevel()) {
                QLog.d(f259014a, 2, "other request is downloading ");
                return;
            }
            return;
        }
        if (Q > 15) {
            if (QLog.isColorLevel()) {
                QLog.d(f259014a, 2, "pe res download exceed limit 5 ");
                return;
            }
            return;
        }
        P = true;
        a aVar2 = new a(str3, str2, aVar);
        IHttpEngineService iHttpEngineService = (IHttpEngineService) appInterface.getRuntimeService(IHttpEngineService.class, "all");
        HttpNetReq httpNetReq = new HttpNetReq();
        httpNetReq.mCallback = aVar2;
        httpNetReq.mHttpMethod = 0;
        httpNetReq.mReqUrl = str;
        httpNetReq.mOutPath = str3 + "pe.zip";
        httpNetReq.mPrioty = 0;
        iHttpEngineService.sendReq(httpNetReq);
    }

    public static boolean v(String str, int i3) {
        String savePath;
        File file;
        String str2;
        com.tencent.mobileqq.poke.utils.b bVar = com.tencent.mobileqq.poke.utils.b.f259090a;
        String str3 = G;
        bVar.a(str3);
        boolean l3 = l(str);
        QQVasUpdateBusiness e16 = e();
        if (e16 != null) {
            if (!str.endsWith(IAIOPokeApi.VAS_POKE_RES_NORMAL) && !str.endsWith("/pressed.png") && !str.endsWith("effect.gif")) {
                savePath = e16.getSavePath(VasUpdateConstants.SCID_POKE_EFFECT_PREFIX + i3);
            } else {
                savePath = e16.getSavePath(VasUpdateConstants.SCID_POKE_PANEL_PREFIX + i3);
            }
            if (l3) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(savePath);
                String str4 = File.separator;
                sb5.append(str4);
                sb5.append(str);
                sb5.append(str4);
                sb5.append(str);
                sb5.append(Sticker.JSON_SUFFIX);
                file = new File(sb5.toString());
            } else {
                StringBuilder sb6 = new StringBuilder();
                sb6.append(savePath);
                if (str.startsWith("/")) {
                    str2 = "";
                } else {
                    str2 = File.separator;
                }
                sb6.append(str2);
                sb6.append(str);
                file = new File(sb6.toString());
            }
            return file.exists();
        }
        if (l3) {
            StringBuilder sb7 = new StringBuilder();
            sb7.append(str3);
            sb7.append(i3);
            String str5 = File.separator;
            sb7.append(str5);
            sb7.append(str);
            sb7.append(str5);
            sb7.append(str);
            sb7.append(Sticker.JSON_SUFFIX);
            return new File(sb7.toString()).exists();
        }
        return new File(str3 + i3 + "/" + str).exists();
    }
}
