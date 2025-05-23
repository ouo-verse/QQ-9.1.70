package com.tencent.mobileqq.app.msgnotify;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.api.IQQNonMainProcAvatarLoaderApi;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.bk;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class f extends ReportDialog implements DecodeTaskCompletionListener {
    static IPatchRedirector $redirector_;
    private static String J;
    private static String K;
    private static String L;
    private Context C;
    private QQAppInterface D;
    private RoundImageView E;
    private String F;
    private IFaceDecoder G;
    private com.tencent.mobileqq.armap.f H;
    private com.tencent.mobileqq.armap.e I;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements com.tencent.mobileqq.armap.e {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this);
            }
        }

        @Override // com.tencent.mobileqq.armap.e
        public void h(String str, String str2, Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, str2, bitmap);
            } else {
                f.this.E.setImageBitmap(bitmap);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                try {
                    ReportController.o(null, "dc00898", "", "", "0X8009ACC", "0X8009ACC", 0, 0, "", "", "", "");
                    if (MsgNotifyPushDialog.T != null) {
                        f.this.C.startActivity(MsgNotifyPushDialog.T);
                    } else if (f.this.D != null) {
                        if (QLog.isColorLevel()) {
                            QLog.d(f.J, 2, "init MsgNotifyPushDialog.initPushOpeNotifyConfig");
                        }
                        MsgNotifyPushDialog.Y(f.this.D);
                        f.this.C.startActivity(MsgNotifyPushDialog.T);
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.d(f.J, 2, "mAppInterface=null, use default intent");
                        }
                        f.this.C.startActivity(bk.a(f.this.C));
                    }
                } catch (Exception unused) {
                    if (QLog.isColorLevel()) {
                        QLog.d(f.J, 2, "Start Activity Failed");
                        f.this.C.startActivity(bk.b(f.this.C));
                    }
                }
                f.this.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ReportController.o(null, "dc00898", "", "", "0X8009ACD", "0X8009ACD", 0, 0, "", "", "", "");
                f.this.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class d implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImageView f196359d;

        d(ImageView imageView) {
            this.f196359d = imageView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this, (Object) imageView);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            if (motionEvent.getAction() == 1 || motionEvent.getAction() == 0) {
                if (motionEvent.getAction() == 1) {
                    i3 = 255;
                } else {
                    i3 = 127;
                }
                this.f196359d.setImageAlpha(i3);
                return false;
            }
            return false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70454);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        J = "MsgNotifyPushForSpecialCareDialog";
        K = HardCodeUtil.qqStr(R.string.oac);
        L = HardCodeUtil.qqStr(R.string.oa_);
    }

    @TargetApi(14)
    public f(Context context, @Nullable QQAppInterface qQAppInterface, String str) {
        super(context, R.style.qZoneInputDialog);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, qQAppInterface, str);
            return;
        }
        super.getWindow().setWindowAnimations(R.style.f173401cf);
        getWindow().setDimAmount(0.5f);
        this.C = context;
        this.D = qQAppInterface;
        this.F = str;
    }

    public void R() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        IFaceDecoder iFaceDecoder = this.G;
        if (iFaceDecoder != null) {
            iFaceDecoder.destory();
        }
        com.tencent.mobileqq.armap.f fVar = this.H;
        if (fVar != null) {
            fVar.f(this.I);
            this.H.destroy();
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    @Override // android.app.Dialog
    @TargetApi(16)
    protected void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        super.setContentView(R.layout.f167863jv);
        this.E = (RoundImageView) findViewById(R.id.bj8);
        TextView textView = (TextView) findViewById(R.id.dialogTitle);
        TextView textView2 = (TextView) findViewById(R.id.bin);
        Button button = (Button) findViewById(R.id.bik);
        ImageView imageView = (ImageView) findViewById(R.id.az7);
        QQAppInterface qQAppInterface = this.D;
        if (qQAppInterface != null) {
            IFaceDecoder iQQAvatarService = ((IQQAvatarService) qQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.D);
            this.G = iQQAvatarService;
            iQQAvatarService.setDecodeTaskCompletionListener(this);
            Bitmap bitmapFromCache = this.G.getBitmapFromCache(1, this.F, 0);
            if (bitmapFromCache == null) {
                if (!this.G.isPausing()) {
                    this.G.requestDecodeFace(this.F, 1, true);
                }
                this.E.setBackgroundDrawable(BaseImageUtil.getDefaultFaceDrawable140_140());
            } else {
                this.E.setBackgroundDrawable(new BitmapDrawable(bitmapFromCache));
            }
        } else {
            com.tencent.mobileqq.armap.f nonMainAppHeadLoader = ((IQQNonMainProcAvatarLoaderApi) QRoute.api(IQQNonMainProcAvatarLoaderApi.class)).getNonMainAppHeadLoader(this.C, 1);
            this.H = nonMainAppHeadLoader;
            nonMainAppHeadLoader.init();
            a aVar = new a();
            this.I = aVar;
            this.H.a(aVar);
            this.E.setImageBitmap(this.H.b(this.F, true));
        }
        textView.setText(K);
        textView2.setText(L);
        button.setText(HardCodeUtil.qqStr(R.string.oab));
        button.setOnClickListener(new b());
        imageView.setOnClickListener(new c());
        imageView.setOnTouchListener(new d(imageView));
    }

    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bitmap);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(J, 2, "uin=" + str + ", type=" + i16 + ",avatar= " + bitmap);
        }
        if (bitmap != null && !this.G.isPausing()) {
            this.E.setBackgroundDrawable(new BitmapDrawable(bitmap));
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog, android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            super.onWindowFocusChanged(z16);
        }
    }
}
