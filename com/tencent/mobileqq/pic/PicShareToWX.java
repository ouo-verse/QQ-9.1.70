package com.tencent.mobileqq.pic;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.maxvideo.MaxVideoConst;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.config.business.PicShareToWXConfigProcessor;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.File;
import java.util.HashMap;
import tencent.im.msg.im_msg_body$RichText;

/* loaded from: classes16.dex */
public class PicShareToWX implements IWXAPIEventHandler {
    static IPatchRedirector $redirector_;
    private static volatile PicShareToWX G;
    protected int C;
    private long D;
    protected r E;
    protected int F;

    /* renamed from: d, reason: collision with root package name */
    public QQProgressDialog f258558d;

    /* renamed from: e, reason: collision with root package name */
    protected TransferRequest f258559e;

    /* renamed from: f, reason: collision with root package name */
    protected QQAppInterface f258560f;

    /* renamed from: h, reason: collision with root package name */
    private TimeoutRunnable f258561h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f258562i;

    /* renamed from: m, reason: collision with root package name */
    protected Context f258563m;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public class TimeoutRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        TimeoutRunnable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PicShareToWX.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                PicShareToWX.this.f258562i = true;
                PicShareToWX picShareToWX = PicShareToWX.this;
                QQAppInterface qQAppInterface = picShareToWX.f258560f;
                if (qQAppInterface != null && picShareToWX.f258559e != null) {
                    ((ITransFileController) qQAppInterface.getRuntimeService(ITransFileController.class)).stop(PicShareToWX.this.f258559e);
                }
                PicShareToWX picShareToWX2 = PicShareToWX.this;
                r rVar = picShareToWX2.E;
                if (rVar != null) {
                    rVar.callbackResult(picShareToWX2.F, EIPCResult.createResult(-102, null));
                }
                PicShareToWX.k(PicShareToWX.this.C, false);
                PicShareToWX.this.l(false, MaxVideoConst.RESULT_LOCAL, 0);
                PicShareToWX.this.t();
                PicShareToWX.this.o();
                PicShareToWX.this.m();
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class a implements WXShareHelper.a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f258565d;

        a(int i3) {
            this.f258565d = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PicShareToWX.this, i3);
            }
        }

        @Override // com.tencent.mobileqq.wxapi.WXShareHelper.a
        public void onWXShareResp(BaseResp baseResp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) baseResp);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("PicShareToWX", 1, "onWXShareResp resp.errCode = " + baseResp.errCode + ", fromType = " + this.f258565d);
            }
            if (baseResp.errCode == 0) {
                PicShareToWX.k(this.f258565d, true);
                PicShareToWX.this.l(true, 0, 1);
            } else {
                PicShareToWX.k(this.f258565d, false);
                PicShareToWX.this.l(false, baseResp.errCode, 1);
            }
            WXShareHelper.b0().q0(this);
        }
    }

    /* loaded from: classes16.dex */
    public class b implements ad {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private String f258567d;

        b(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PicShareToWX.this, (Object) str);
            } else {
                this.f258567d = str;
            }
        }

        @Override // com.tencent.mobileqq.pic.ad
        public MessageRecord g(im_msg_body$RichText im_msg_body_richtext) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (MessageRecord) iPatchRedirector.redirect((short) 2, (Object) this, (Object) im_msg_body_richtext);
            }
            return null;
        }

        @Override // com.tencent.mobileqq.pic.ad
        public void q(ad.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("PicShareToWX", 1, "onSend, result.result = " + aVar.f258597a);
            }
            if (PicShareToWX.this.f258561h != null) {
                ThreadManager.getUIHandler().removeCallbacks(PicShareToWX.this.f258561h);
            }
            QQProgressDialog qQProgressDialog = PicShareToWX.this.f258558d;
            if (qQProgressDialog != null) {
                qQProgressDialog.dismiss();
            }
            if (aVar.f258597a != 0) {
                PicShareToWX picShareToWX = PicShareToWX.this;
                r rVar = picShareToWX.E;
                if (rVar != null) {
                    rVar.callbackResult(picShareToWX.F, EIPCResult.createResult(-102, null));
                }
                Context context = PicShareToWX.this.f258563m;
                if (context != null) {
                    QQToast.makeText(context, R.string.hiu, 0).show();
                }
                PicShareToWX.k(PicShareToWX.this.C, false);
                PicShareToWX.this.l(false, aVar.f258597a, 0);
            } else {
                PicShareToWX picShareToWX2 = PicShareToWX.this;
                r rVar2 = picShareToWX2.E;
                if (rVar2 != null) {
                    rVar2.callbackResult(picShareToWX2.F, EIPCResult.createSuccessResult(null));
                }
            }
            PicShareToWX.this.m();
            if (aVar.f258597a == 0 && !PicShareToWX.this.f258562i) {
                String str = aVar.f258609m;
                BitmapFactory.Options options = new BitmapFactory.Options();
                BaseImageUtil.calculateInSampleSize(options, this.f258567d, 400);
                Bitmap decodeFile = SafeBitmapFactory.decodeFile(this.f258567d, options);
                PicShareToWX picShareToWX3 = PicShareToWX.this;
                picShareToWX3.e(str, decodeFile, picShareToWX3.C);
            }
        }

        @Override // com.tencent.mobileqq.pic.ad
        public void r(ad.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73551);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            G = null;
        }
    }

    PicShareToWX() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    public static PicShareToWX f() {
        if (G == null) {
            synchronized (PicShareToWX.class) {
                if (G == null) {
                    G = new PicShareToWX();
                }
            }
        }
        return G;
    }

    public static void k(int i3, boolean z16) {
        String str;
        if (i3 == 1) {
            if (z16) {
                str = "0X800A500";
            } else {
                str = "0X800A501";
            }
        } else if (i3 == 2) {
            if (z16) {
                str = "0X800A503";
            } else {
                str = "0X800A504";
            }
        } else if (i3 == 3) {
            if (z16) {
                str = "0X800A506";
            } else {
                str = "0X800A507";
            }
        } else {
            str = "";
        }
        String str2 = str;
        ReportController.o(null, "dc00898", "", "", str2, str2, 0, 0, "", "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(boolean z16, int i3, int i16) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (z16) {
            hashMap.put("param_succ_flag", "1");
        } else {
            hashMap.put("param_succ_flag", "0");
        }
        hashMap.put(ReportConstant.KEY_PIC_SIZE, String.valueOf(this.D));
        hashMap.put("param_errorStep", String.valueOf(i16));
        hashMap.put("param_FailCode", String.valueOf(i3));
        hashMap.put("param_fromType", String.valueOf(this.C));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPicShareToWX", z16, 0L, 0L, hashMap, null);
    }

    public static void n(String str, Context context, int i3) {
        Bundle bundle = new Bundle();
        bundle.putString("param_pic_path", str);
        bundle.putInt("param_from_type", i3);
        QIPCClientHelper.getInstance().callServer("PicSTWXQIPCModule", "action_share_pic_to_wx", bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.pic.PicShareToWX.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // eipc.EIPCResultCallback
            public void onCallback(EIPCResult eIPCResult) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) eIPCResult);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("PicShareToWX", 2, "onCallback, eipcResult.code = " + eIPCResult.code);
                }
                ThreadManager.getUIHandler().post(new Runnable(eIPCResult) { // from class: com.tencent.mobileqq.pic.PicShareToWX.2.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ EIPCResult f258564d;

                    {
                        this.f258564d = eIPCResult;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this, (Object) eIPCResult);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        PicShareToWX.f().t();
                        if (this.f258564d.code != 0) {
                            PicShareToWX.f().o();
                        }
                        PicShareToWX.f().m();
                    }
                });
            }
        });
        f().p(context);
    }

    public void e(String str, Bitmap bitmap, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, str, bitmap, Integer.valueOf(i3));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PicShareToWX", 1, "doShareToWX");
        }
        PicShareToWXConfigProcessor.a aVar = (PicShareToWXConfigProcessor.a) am.s().x(530);
        a aVar2 = new a(i3);
        String str2 = aVar.f202461d + "url=" + SearchUtils.m(str);
        WXShareHelper.b0().A(aVar2);
        WXShareHelper.b0().z0(str2, str, aVar.f202460c, bitmap, aVar.f202464g, aVar.f202465h, aVar.f202462e, aVar.f202463f);
    }

    public int g(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) context)).intValue();
        }
        return context.getResources().getDimensionPixelSize(R.dimen.title_bar_height);
    }

    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return ((PicShareToWXConfigProcessor.a) am.s().x(530)).f202458a;
    }

    public boolean i(File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) file)).booleanValue();
        }
        if (file.length() < ((PicShareToWXConfigProcessor.a) am.s().x(530)).f202459b) {
            return true;
        }
        return false;
    }

    public boolean j(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str)).booleanValue();
        }
        if (new File(str).length() < ((PicShareToWXConfigProcessor.a) am.s().x(530)).f202459b) {
            return true;
        }
        return false;
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f258558d = null;
        this.f258559e = null;
        this.f258560f = null;
        this.f258563m = null;
        this.E = null;
        this.F = 0;
    }

    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        Context context = this.f258563m;
        if (context != null) {
            QQToast.makeText(context, R.string.hiu, 0).show();
        }
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onReq(BaseReq baseReq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) baseReq);
        }
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) baseResp);
        }
    }

    public void p(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
            return;
        }
        this.f258563m = context;
        if (this.f258558d == null) {
            this.f258558d = new QQProgressDialog(context, g(context));
        }
        this.f258558d.setMessage(R.string.f6s);
        this.f258558d.show();
    }

    public void q(Context context, QQAppInterface qQAppInterface, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, context, qQAppInterface, str, Integer.valueOf(i3));
            return;
        }
        this.C = i3;
        p(context);
        r(qQAppInterface, str);
    }

    public void r(QQAppInterface qQAppInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) qQAppInterface, (Object) str);
            return;
        }
        this.f258562i = false;
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mFileType = 66;
        transferRequest.mLocalPath = str;
        this.D = new File(str).length();
        transferRequest.mUpCallBack = new b(str);
        transferRequest.mUniseq = System.currentTimeMillis();
        this.f258559e = transferRequest;
        if (qQAppInterface != null) {
            this.f258560f = qQAppInterface;
            ITransFileController iTransFileController = (ITransFileController) qQAppInterface.getRuntimeService(ITransFileController.class);
            if (iTransFileController != null) {
                iTransFileController.transferAsync(transferRequest);
            }
        }
        this.f258561h = new TimeoutRunnable();
        ThreadManager.getUIHandler().postDelayed(this.f258561h, 5000L);
    }

    public void s(r rVar, int i3, QQAppInterface qQAppInterface, String str, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, rVar, Integer.valueOf(i3), qQAppInterface, str, Integer.valueOf(i16));
            return;
        }
        this.C = i16;
        this.E = rVar;
        this.F = i3;
        r(qQAppInterface, str);
    }

    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        QQProgressDialog qQProgressDialog = this.f258558d;
        if (qQProgressDialog != null) {
            qQProgressDialog.dismiss();
        }
    }
}
