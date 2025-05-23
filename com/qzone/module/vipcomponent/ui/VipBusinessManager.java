package com.qzone.module.vipcomponent.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.qzone.proxy.vipcomponent.VipComponentProxy;
import com.qzone.proxy.vipcomponent.adapter.EventCenterWrapper;
import com.qzone.proxy.vipcomponent.adapter.VipEnv;
import com.qzone.proxy.vipcomponent.adapter.VipObserver;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import cooperation.vip.vipcomponent.util.a;
import cooperation.vip.vipcomponent.util.b;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;

/* compiled from: P */
/* loaded from: classes39.dex */
public class VipBusinessManager implements VipObserver {
    public static final int COMM_VIP = 1;
    public static final String COMM_VIP_OFFER_ID = "1450000153";
    public static final String COMM_VIP_SERVICE_CODE = "xxjzgw";
    public static final String COMM_VIP_SERVICE_NAME = "\u9ec4\u94bb\u8d35\u65cf";
    public static final int DEFAULT_VIP = 0;
    public static final int OPEN_CANCEL = 137;
    public static final int OPEN_SUCCESS = 153;
    public static final int RETURN_CODE_OFFSET = 20000;
    public static final int SPECIAL_VIP = 2;
    public static final String SPECIAL_VIP_OFFER_ID = "1450001557";
    public static final String SPECIAL_VIP_SERVICE_CODE = "XXJZGHH";
    public static final String SPECIAL_VIP_SERVICE_NAME = "\u8c6a\u534e\u8d35\u65cf";
    public static final int STAR_VIP = 3;
    public static final String TAG = "VipBusinessManager";
    public static boolean haveBeenToPayPage = false;
    public static boolean havePaid = false;
    private String C;

    /* renamed from: a, reason: collision with root package name */
    private Context f49091a;

    /* renamed from: b, reason: collision with root package name */
    private Handler f49092b;

    /* renamed from: c, reason: collision with root package name */
    private DialogInterface.OnClickListener f49093c;

    /* renamed from: d, reason: collision with root package name */
    private DialogInterface.OnClickListener f49094d;

    /* renamed from: h, reason: collision with root package name */
    private String f49098h;

    /* renamed from: i, reason: collision with root package name */
    private Dialog f49099i;

    /* renamed from: j, reason: collision with root package name */
    private Dialog f49100j;

    /* renamed from: r, reason: collision with root package name */
    private long f49108r;

    /* renamed from: s, reason: collision with root package name */
    private int f49109s;

    /* renamed from: t, reason: collision with root package name */
    private String f49110t;

    /* renamed from: u, reason: collision with root package name */
    private String f49111u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f49112v;

    /* renamed from: w, reason: collision with root package name */
    private int f49113w;

    /* renamed from: x, reason: collision with root package name */
    private String f49114x;

    /* renamed from: y, reason: collision with root package name */
    private String f49115y;

    /* renamed from: e, reason: collision with root package name */
    private boolean f49095e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f49096f = false;
    public boolean directGo = false;

    /* renamed from: g, reason: collision with root package name */
    private int f49097g = 2;

    /* renamed from: k, reason: collision with root package name */
    private String f49101k = null;

    /* renamed from: l, reason: collision with root package name */
    private String f49102l = null;

    /* renamed from: m, reason: collision with root package name */
    private String f49103m = null;

    /* renamed from: n, reason: collision with root package name */
    private String f49104n = null;

    /* renamed from: o, reason: collision with root package name */
    private boolean f49105o = true;

    /* renamed from: p, reason: collision with root package name */
    private boolean f49106p = true;

    /* renamed from: q, reason: collision with root package name */
    private String f49107q = null;

    /* renamed from: z, reason: collision with root package name */
    private int f49116z = 3;
    private boolean A = false;
    public boolean needDisPathResult = false;
    private boolean B = false;

    public VipBusinessManager(Context context, Handler handler) {
        this.f49091a = context;
        this.f49092b = handler;
        EventCenterWrapper.addUIObserver(this, a.C10129a.f391398a, 11, 12);
        this.f49098h = VipEnv.getReferId(this.f49091a);
    }

    public static String getDiamondPayPageUrl(String str) {
        String diamondPayPageUrl = VipEnv.getDiamondPayPageUrl();
        if (diamondPayPageUrl.indexOf("{openuin}") > 0) {
            diamondPayPageUrl = diamondPayPageUrl.replaceAll("\\{openuin\\}", VipEnv.getLoginUin() + "");
        }
        if (diamondPayPageUrl.indexOf("{vipType}") > 0) {
            diamondPayPageUrl = diamondPayPageUrl.replaceAll("\\{vipType\\}", COMM_VIP_SERVICE_CODE);
        }
        if (diamondPayPageUrl.indexOf("{LEVEL}") > 0) {
            diamondPayPageUrl = diamondPayPageUrl.replaceAll("\\{LEVEL\\}", VipComponentProxy.f50997g.getServiceInterface().getVipLevel() + "");
        }
        if (diamondPayPageUrl.indexOf("{month}") > 0) {
            diamondPayPageUrl = diamondPayPageUrl.replaceAll("\\{month\\}", "1");
        }
        if (diamondPayPageUrl.indexOf("{as}") > 0) {
            diamondPayPageUrl = diamondPayPageUrl.replaceAll("\\{as\\}", "0");
        }
        if (diamondPayPageUrl.indexOf("{NICKNAME}") > 0) {
            String nickName = VipEnv.getNickName();
            try {
                nickName = URLEncoder.encode(nickName, "utf-8");
            } catch (UnsupportedEncodingException unused) {
            }
            diamondPayPageUrl = diamondPayPageUrl.replaceAll("\\{NICKNAME\\}", nickName);
        }
        if (diamondPayPageUrl.indexOf("{AID}") <= 0) {
            return diamondPayPageUrl;
        }
        if (TextUtils.isEmpty(str)) {
            str = "an-qzone";
        }
        return diamondPayPageUrl.replaceAll("\\{AID\\}", str);
    }

    public static boolean haveBeentoPayPage() {
        return haveBeenToPayPage;
    }

    public static boolean havePaid() {
        return havePaid;
    }

    private void j() {
        Dialog dialog = this.f49099i;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.f49099i.dismiss();
    }

    private DialogInterface.OnCancelListener k() {
        return new DialogInterface.OnCancelListener() { // from class: com.qzone.module.vipcomponent.ui.VipBusinessManager.4
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                DiamondYellowOpenActivity.lock = false;
                if (!VipBusinessManager.this.f49095e) {
                    if (TextUtils.isEmpty(VipBusinessManager.this.f49098h)) {
                        VipBusinessManager.this.f49098h = "";
                    }
                    VipEnv.reportVipDialogCannel(VipBusinessManager.this.f49098h);
                }
                VipBusinessManager.this.f49095e = false;
                Message obtain = Message.obtain();
                obtain.what = 137;
                VipComponentProxy vipComponentProxy = VipComponentProxy.f50997g;
                obtain.arg1 = vipComponentProxy.getServiceInterface().getVipType();
                obtain.arg2 = vipComponentProxy.getServiceInterface().getVipLevel();
                if (VipBusinessManager.this.f49092b != null) {
                    VipBusinessManager.this.f49092b.sendMessage(obtain);
                }
                try {
                    Field declaredField = dialogInterface.getClass().getSuperclass().getDeclaredField("mShowing");
                    declaredField.setAccessible(true);
                    declaredField.set(dialogInterface, Boolean.TRUE);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        };
    }

    private DialogInterface.OnClickListener l() {
        return new DialogInterface.OnClickListener() { // from class: com.qzone.module.vipcomponent.ui.VipBusinessManager.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                DiamondYellowOpenActivity.lock = false;
                dialogInterface.cancel();
                if (VipBusinessManager.this.f49091a == null || !(VipBusinessManager.this.f49091a instanceof Activity)) {
                    return;
                }
                ((Activity) VipBusinessManager.this.f49091a).finish();
            }
        };
    }

    private void m() {
        VipEnv.toH5PayPage(this.f49091a, getDiamondPayPageUrl(this.f49101k), 2, this.f49106p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        String str;
        String str2;
        String str3;
        Dialog dialog = this.f49099i;
        if (dialog != null) {
            boolean z16 = this.f49095e;
            if (z16) {
                str = "\u662f\u5426\u5df2\u6210\u529f\u4ed8\u8d39";
            } else {
                str = "\u4ec5\u9ec4\u94bb\u8d35\u65cf\u53ef\u4f7f\u7528";
            }
            if (z16) {
                str2 = "\u5df2\u4ed8\u8d39";
            } else {
                str2 = "\u5f00\u901a";
            }
            if (z16) {
                str3 = "\u672a\u4ed8\u8d39";
            } else {
                str3 = "\u53d6\u6d88";
            }
            VipEnv.setDialogMsg(str, str2, str3, this.f49094d, this.f49093c, dialog);
        }
    }

    public void onDestroy() {
        Dialog dialog = this.f49099i;
        if (dialog != null && dialog.isShowing()) {
            this.f49099i.dismiss();
        }
        Dialog dialog2 = this.f49100j;
        if (dialog2 != null && dialog2.isShowing()) {
            this.f49100j.dismiss();
        }
        EventCenterWrapper.removeObserver(this);
        this.f49091a = null;
        this.f49092b = null;
    }

    @Override // com.qzone.proxy.vipcomponent.adapter.VipObserver
    public void onEventMainThread(int i3, String str, Object obj) {
        Dialog dialog = this.f49100j;
        if (dialog != null && dialog.isShowing()) {
            this.f49100j.dismiss();
        }
        if (this.f49096f) {
            Object[] objArr = (Object[]) obj;
            int vipType = VipComponentProxy.f50997g.getServiceInterface().getVipType();
            if (objArr != null && objArr.length >= 1) {
                Object obj2 = objArr[0];
                if (obj2 instanceof Integer) {
                    vipType = ((Integer) obj2).intValue();
                }
            }
            if (havePaid()) {
                sendEndMsg(153);
                if (vipType <= 0) {
                    VipEnv.showToast(this.f49091a, 1, "\u652f\u4ed8\u7ed3\u679c\u786e\u8ba4\u4e2d\uff0c\u8bf7\u7b49\u5f85");
                    return;
                }
                return;
            }
            sendEndMsg(137);
        }
    }

    public void onPayEnd() {
        try {
            b.d(TAG, "onPayEnd");
            VipEnv.refreshYellowDiamondInfo();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void openVipWebPageByNewSDK() {
        long loginUin;
        String replace;
        String str;
        VipEnv.openVipClickReport(this.f49101k);
        String newH5PayUrl = VipEnv.getNewH5PayUrl();
        if (!TextUtils.isEmpty(newH5PayUrl)) {
            long j3 = this.f49108r;
            if (j3 >= 10000 && j3 != VipEnv.getLoginUin()) {
                loginUin = this.f49108r;
            } else {
                loginUin = VipEnv.getLoginUin();
            }
            String replace2 = newH5PayUrl.replace("{openUin}", loginUin + "").replace("{openVipType}", this.f49113w + "");
            if (this.f49116z == 0) {
                if (this.A) {
                    str = "12";
                } else {
                    str = "0";
                }
                replace = replace2.replace("{openMonth}", str);
            } else {
                replace = replace2.replace("{openMonth}", this.f49116z + "");
            }
            String str2 = this.f49101k;
            if (str2 == null) {
                this.f49101k = "";
            } else {
                this.f49101k = str2.replaceAll("-", "_");
            }
            newH5PayUrl = replace.replace("{aid}", this.f49101k);
            if (!TextUtils.isEmpty(this.f49110t)) {
                newH5PayUrl = newH5PayUrl + "&source=" + this.f49110t;
            }
            if (!TextUtils.isEmpty(this.f49111u)) {
                newH5PayUrl = newH5PayUrl + "&switch=" + this.f49111u;
            }
        }
        VipEnv.toH5PayPage(this.f49091a, newH5PayUrl, 2, this.f49106p);
        VipEnv.reportToH5PayPage();
    }

    public void sendEndMsg(int i3) {
        Message obtain = Message.obtain();
        obtain.what = i3;
        VipComponentProxy vipComponentProxy = VipComponentProxy.f50997g;
        obtain.arg1 = vipComponentProxy.getServiceInterface().getVipType();
        obtain.arg2 = vipComponentProxy.getServiceInterface().getVipLevel();
        Handler handler = this.f49092b;
        if (handler != null) {
            handler.sendMessage(obtain);
        }
        VipEnv.reportCheckYellowVip2MM(obtain.arg1 + 20000, havePaid(), obtain.arg1);
        this.f49095e = false;
        this.f49096f = false;
    }

    public void setAid(String str) {
        this.f49101k = str;
    }

    public void setAutopay(boolean z16) {
        this.f49112v = z16;
    }

    public void setIsNianFei(boolean z16) {
        this.A = z16;
    }

    public void setNeedLoadingDialog(boolean z16) {
        this.f49106p = z16;
    }

    public void setNeedReportByAid(boolean z16) {
        this.B = z16;
    }

    public void setNewOpenmonth(int i3) {
        this.f49116z = i3;
    }

    public void setOfferid(String str) {
        this.f49102l = str;
    }

    public void setOpenMonth(String str, boolean z16) {
        this.f49104n = str;
        this.f49105o = z16;
    }

    public void setPayUrl(String str) {
        this.C = str;
    }

    public void setPf(String str) {
        this.f49107q = str;
    }

    public void setProvideUIn(long j3) {
        this.f49108r = j3;
    }

    public void setRemark(String str) {
        this.f49103m = str;
    }

    public void setServiceType(int i3) {
        this.f49109s = i3;
    }

    public void setSource(String str) {
        this.f49110t = str;
    }

    public void setSwitch(String str) {
        this.f49111u = str;
    }

    public void setViptype(int i3) {
        this.f49113w = i3;
        if (i3 == 1 || i3 == 0) {
            this.f49114x = COMM_VIP_SERVICE_CODE;
            this.f49115y = COMM_VIP_SERVICE_NAME;
            this.f49102l = COMM_VIP_OFFER_ID;
        } else if (i3 == 2) {
            this.f49114x = SPECIAL_VIP_SERVICE_CODE;
            this.f49115y = SPECIAL_VIP_SERVICE_NAME;
            this.f49102l = SPECIAL_VIP_OFFER_ID;
        }
    }

    public void showOpenVipDialog(String str) {
        showOpenVipDialog(str, null, null, null);
    }

    public void checkVipState() {
        this.f49096f = true;
        Context context = this.f49091a;
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return;
        }
        if (this.f49100j == null) {
            Dialog createLoadingDialog = VipEnv.createLoadingDialog(this.f49091a, "\u67e5\u8be2\u9ec4\u94bb\u4fe1\u606f");
            this.f49100j = createLoadingDialog;
            if (createLoadingDialog != null) {
                createLoadingDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.qzone.module.vipcomponent.ui.VipBusinessManager.8
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        VipBusinessManager.this.sendEndMsg(137);
                    }
                });
            }
        }
        Dialog dialog = this.f49100j;
        if (dialog != null) {
            dialog.show();
        }
        VipEnv.refreshYellowDiamondInfo();
    }

    public void onPaySuccess() {
        havePaid = true;
        if (VipEnv.isNetworkAvailable()) {
            checkVipState();
        } else {
            sendEndMsg(153);
        }
        b.d(TAG, "has paid");
    }

    public void openVipWebPage(String str) {
        haveBeenToPayPage = true;
        VipEnv.toH5PayPage(this.f49091a, str, 2, this.f49106p);
        this.directGo = true;
        Handler handler = this.f49092b;
        if (handler != null) {
            handler.postDelayed(new Runnable() { // from class: com.qzone.module.vipcomponent.ui.VipBusinessManager.7
                @Override // java.lang.Runnable
                public void run() {
                    VipBusinessManager vipBusinessManager = VipBusinessManager.this;
                    if (vipBusinessManager.directGo) {
                        return;
                    }
                    vipBusinessManager.f49095e = true;
                    VipBusinessManager.this.showOpenVipDialog(null);
                }
            }, 2000L);
        }
    }

    public void showOpenVipDialog(String str, String str2, String str3, String str4) {
        j();
        if (this.f49099i == null) {
            if (TextUtils.isEmpty(str3)) {
                str3 = "\u5f00\u901a";
            }
            String str5 = str3;
            if (TextUtils.isEmpty(str4)) {
                str4 = "\u53d6\u6d88";
            }
            this.f49094d = new DialogInterface.OnClickListener() { // from class: com.qzone.module.vipcomponent.ui.VipBusinessManager.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    DiamondYellowOpenActivity.lock = false;
                    if (VipBusinessManager.this.f49095e) {
                        VipBusinessManager.this.checkVipState();
                        try {
                            Field declaredField = dialogInterface.getClass().getSuperclass().getDeclaredField("mShowing");
                            declaredField.setAccessible(true);
                            declaredField.set(dialogInterface, Boolean.TRUE);
                            return;
                        } catch (Exception e16) {
                            e16.printStackTrace();
                            return;
                        }
                    }
                    if (!VipEnv.isNetworkAvailable()) {
                        VipEnv.showToast(VipBusinessManager.this.f49091a, 0, "\u7f51\u7edc\u65e0\u8fde\u63a5");
                        if (dialogInterface != null) {
                            dialogInterface.cancel();
                            return;
                        }
                        return;
                    }
                    VipBusinessManager.this.openVipWebPageByNewSDK();
                    if (TextUtils.isEmpty(VipBusinessManager.this.f49098h)) {
                        VipBusinessManager.this.f49098h = "";
                    }
                    VipEnv.reportVipDialogOpen(VipBusinessManager.this.f49098h);
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                }
            };
            DialogInterface.OnClickListener l3 = l();
            this.f49093c = l3;
            Dialog alertDialog = VipEnv.getAlertDialog(this.f49091a, str, str2, str4, l3, str5, this.f49094d, k());
            this.f49099i = alertDialog;
            alertDialog.setCancelable(false);
            this.f49099i.setCanceledOnTouchOutside(false);
            this.f49099i.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.qzone.module.vipcomponent.ui.VipBusinessManager.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    DiamondYellowOpenActivity.lock = false;
                    VipBusinessManager.this.n();
                }
            });
        }
        n();
        if (!TextUtils.isEmpty(str)) {
            VipEnv.setDialogMsg(str, null, null, this.f49094d, this.f49093c, this.f49099i);
        }
        this.f49099i.show();
        if (TextUtils.isEmpty(this.f49098h)) {
            this.f49098h = "";
        }
        VipEnv.reportOpenVipEntrance(this.f49098h);
    }

    public void payDirect(int i3, int i16, boolean z16) {
        if (!VipEnv.isYellowPayInBlackList()) {
            VipEnv.enableRedirectWhenPayVip(false);
            ((Activity) this.f49091a).startActivityForResult(VipEnv.generateYellowPayParams(this.f49091a, this.f49102l, this.f49101k, this.f49103m, this.f49107q, this.f49108r, this.f49109s, i3, this.f49105o, i16, z16, this.f49097g, this.f49114x, this.f49115y), 1);
        } else {
            VipEnv.enableRedirectWhenPayVip(true);
            m();
            Handler handler = this.f49092b;
            if (handler != null) {
                handler.postDelayed(new Runnable() { // from class: com.qzone.module.vipcomponent.ui.VipBusinessManager.5
                    @Override // java.lang.Runnable
                    public void run() {
                        VipBusinessManager.haveBeenToPayPage = true;
                        VipBusinessManager vipBusinessManager = VipBusinessManager.this;
                        if (vipBusinessManager.directGo) {
                            return;
                        }
                        vipBusinessManager.f49095e = true;
                        VipBusinessManager.this.showOpenVipDialog(null);
                    }
                }, 2000L);
            }
        }
    }

    public void openVipWebPageByOldSDK() {
        this.needDisPathResult = true;
        VipEnv.reportBySdk();
        haveBeenToPayPage = true;
        if (!VipEnv.isYellowPayInBlackList()) {
            VipEnv.enableRedirectWhenPayVip(false);
            ((Activity) this.f49091a).startActivityForResult(VipEnv.generateYellowPayParams(this.f49091a, this.f49102l, this.f49101k, this.f49103m, this.f49107q, this.f49108r, this.f49109s, VipEnv.strToInt(this.f49104n, 3), this.f49105o, -1, this.f49112v, this.f49097g, this.f49114x, this.f49115y), 1);
        } else {
            VipEnv.enableRedirectWhenPayVip(true);
            m();
            Handler handler = this.f49092b;
            if (handler != null) {
                handler.postDelayed(new Runnable() { // from class: com.qzone.module.vipcomponent.ui.VipBusinessManager.6
                    @Override // java.lang.Runnable
                    public void run() {
                        VipBusinessManager.haveBeenToPayPage = true;
                        VipBusinessManager vipBusinessManager = VipBusinessManager.this;
                        if (vipBusinessManager.directGo) {
                            return;
                        }
                        vipBusinessManager.f49095e = true;
                        VipBusinessManager.this.showOpenVipDialog(null);
                    }
                }, 2000L);
            }
        }
    }

    public void openDialogBySetting(int i3, int i16, int i17, int i18) {
        if (2 == i16) {
            i17 = 1;
        }
        this.f49097g = i17;
        if (i18 == 3) {
            VipEnv.reportOpenVipH5();
            openVipWebPageByNewSDK();
            VipEnv.reportOpenMidsVipDialog();
        } else {
            if (1 != i17 && i16 != 3) {
                openVipWebPageByOldSDK();
                VasCommonReporter.newReport("qzone_old_dialog").setNum1(i17).report();
                VipEnv.reportOpenVipOldDialogShow();
                VipEnv.reportOpenMidsVipDialog();
                return;
            }
            VipEnv.reportOpenVipH5DialogShow();
            setNewOpenmonth(i3);
            setViptype(i16);
            openVipWebPageByNewSDK();
        }
    }

    public void showOpenVipDialog(String str, String str2, String str3, String str4, final int i3, final int i16, final int i17, final int i18) {
        this.f49097g = i17;
        j();
        if (this.f49099i == null) {
            if (this.f49091a == null) {
                b.b(TAG, "mContext is null ,qzone will crash immediately! assign it  with value of ApplicationContext");
                this.f49091a = VipEnv.getContext();
            }
            String str5 = TextUtils.isEmpty(str3) ? "\u5f00\u901a" : str3;
            String str6 = TextUtils.isEmpty(str4) ? "\u53d6\u6d88" : str4;
            this.f49094d = new DialogInterface.OnClickListener() { // from class: com.qzone.module.vipcomponent.ui.VipBusinessManager.9
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i19) {
                    DiamondYellowOpenActivity.lock = false;
                    if (VipBusinessManager.this.f49095e) {
                        VipBusinessManager.this.checkVipState();
                        try {
                            Field declaredField = dialogInterface.getClass().getSuperclass().getDeclaredField("mShowing");
                            declaredField.setAccessible(true);
                            declaredField.set(dialogInterface, Boolean.TRUE);
                            return;
                        } catch (Exception e16) {
                            e16.printStackTrace();
                            return;
                        }
                    }
                    if (!VipEnv.isNetworkAvailable()) {
                        VipEnv.showToast(VipBusinessManager.this.f49091a, 0, "\u7f51\u7edc\u65e0\u8fde\u63a5");
                        if (dialogInterface != null) {
                            dialogInterface.cancel();
                            return;
                        }
                        return;
                    }
                    VipEnv.ReportQzoneVipEntrnce(VipBusinessManager.this.f49101k);
                    VipBusinessManager.this.openDialogBySetting(i3, i16, i17, i18);
                    if (VipBusinessManager.this.B) {
                        VipEnv.reportAfterClickOpen(VipBusinessManager.this.f49101k);
                    }
                    if (TextUtils.isEmpty(VipBusinessManager.this.f49098h)) {
                        VipBusinessManager.this.f49098h = "";
                    }
                    VipEnv.reportVipDialogOpen(VipBusinessManager.this.f49098h);
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                }
            };
            DialogInterface.OnClickListener l3 = l();
            this.f49093c = l3;
            Dialog alertDialog = VipEnv.getAlertDialog(this.f49091a, str, null, str6, l3, str5, this.f49094d, k());
            this.f49099i = alertDialog;
            alertDialog.setCanceledOnTouchOutside(false);
            this.f49099i.setCancelable(false);
            this.f49099i.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.qzone.module.vipcomponent.ui.VipBusinessManager.10
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    DiamondYellowOpenActivity.lock = false;
                    VipBusinessManager.this.n();
                }
            });
        }
        n();
        if (!TextUtils.isEmpty(str)) {
            VipEnv.setDialogMsg(str, null, null, this.f49094d, this.f49093c, this.f49099i);
        }
        this.f49099i.show();
        if (TextUtils.isEmpty(this.f49098h)) {
            this.f49098h = "";
        }
        VipEnv.reportOpenVipEntrance(this.f49098h);
    }

    @Override // com.qzone.proxy.vipcomponent.adapter.VipObserver
    public void onEventAsync(int i3, String str, Object obj) {
    }

    @Override // com.qzone.proxy.vipcomponent.adapter.VipObserver
    public void onEventBackgroundThread(int i3, String str, Object obj) {
    }

    @Override // com.qzone.proxy.vipcomponent.adapter.VipObserver
    public void onEventPostThread(int i3, String str, Object obj) {
    }
}
