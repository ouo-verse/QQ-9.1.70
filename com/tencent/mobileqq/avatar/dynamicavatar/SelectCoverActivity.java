package com.tencent.mobileqq.avatar.dynamicavatar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.k;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.DrawableSeekbar;
import com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.VideoDrawableHandler;
import com.tencent.mobileqq.mini.share.MiniProgramOpenSdkUtil;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.api.IVasFragmentRoute;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ap;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import com.tencent.widget.CustomImgView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes11.dex */
public class SelectCoverActivity extends IphoneTitleBarActivity implements DrawableSeekbar.a, Handler.Callback, View.OnClickListener, VideoDrawableHandler.a, View.OnTouchListener, DialogInterface.OnCancelListener {
    static IPatchRedirector $redirector_;
    View A0;
    int B0;
    int C0;
    ap D0;
    String E0;
    private boolean F0;
    private String G0;
    int H0;
    String I0;
    String J0;
    boolean K0;
    volatile boolean L0;
    DynamicAvatarManager M0;
    d N0;
    private final Object O0;
    private boolean P0;

    /* renamed from: a0, reason: collision with root package name */
    CustomImgView f200012a0;

    /* renamed from: b0, reason: collision with root package name */
    DrawableSeekbar f200013b0;

    /* renamed from: c0, reason: collision with root package name */
    VideoDrawableHandler f200014c0;

    /* renamed from: d0, reason: collision with root package name */
    LinearLayout f200015d0;

    /* renamed from: e0, reason: collision with root package name */
    Drawable f200016e0;

    /* renamed from: f0, reason: collision with root package name */
    com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.a f200017f0;

    /* renamed from: g0, reason: collision with root package name */
    com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.a f200018g0;

    /* renamed from: h0, reason: collision with root package name */
    com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.a f200019h0;

    /* renamed from: i0, reason: collision with root package name */
    Handler f200020i0;

    /* renamed from: j0, reason: collision with root package name */
    Handler f200021j0;

    /* renamed from: k0, reason: collision with root package name */
    int f200022k0;

    /* renamed from: l0, reason: collision with root package name */
    int f200023l0;

    /* renamed from: m0, reason: collision with root package name */
    int f200024m0;

    /* renamed from: n0, reason: collision with root package name */
    String f200025n0;

    /* renamed from: o0, reason: collision with root package name */
    long f200026o0;

    /* renamed from: p0, reason: collision with root package name */
    long f200027p0;

    /* renamed from: q0, reason: collision with root package name */
    boolean f200028q0;

    /* renamed from: r0, reason: collision with root package name */
    int f200029r0;

    /* renamed from: s0, reason: collision with root package name */
    Animator f200030s0;

    /* renamed from: t0, reason: collision with root package name */
    float f200031t0;

    /* renamed from: u0, reason: collision with root package name */
    Rect f200032u0;

    /* renamed from: v0, reason: collision with root package name */
    Rect f200033v0;

    /* renamed from: w0, reason: collision with root package name */
    View f200034w0;

    /* renamed from: x0, reason: collision with root package name */
    View f200035x0;

    /* renamed from: y0, reason: collision with root package name */
    View f200036y0;

    /* renamed from: z0, reason: collision with root package name */
    View f200037z0;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity$1, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass1 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ SelectCoverActivity this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            Bitmap d16 = VideoDrawableHandler.d(this.this$0.f200025n0);
            if (this.this$0.L0) {
                return;
            }
            if (d16 != null) {
                this.this$0.f200021j0.obtainMessage(4, d16).sendToTarget();
            } else {
                this.this$0.f200021j0.sendEmptyMessage(6);
            }
            SelectCoverActivity selectCoverActivity = this.this$0;
            int i3 = selectCoverActivity.B0;
            if (i3 == 1 || i3 == 3) {
                selectCoverActivity.M2();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a extends com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.a {
        static IPatchRedirector $redirector_;

        a(Bitmap bitmap, Resources resources) {
            super(bitmap, resources);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, SelectCoverActivity.this, bitmap, resources);
            }
        }

        @Override // com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.a
        public void c(Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bitmap);
            } else {
                SelectCoverActivity.this.f200012a0.setImageBitmap(bitmap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class b extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectCoverActivity.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
            } else {
                SelectCoverActivity.this.f200030s0 = null;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            } else {
                SelectCoverActivity.this.f200030s0 = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class c extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f200045d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f200046e;

        c(View view, View view2) {
            this.f200045d = view;
            this.f200046e = view2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, SelectCoverActivity.this, view, view2);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
                return;
            }
            this.f200045d.setAlpha(1.0f);
            this.f200046e.setVisibility(8);
            SelectCoverActivity.this.f200030s0 = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
                return;
            }
            this.f200045d.setAlpha(1.0f);
            this.f200046e.setVisibility(8);
            SelectCoverActivity.this.f200030s0 = null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    static class d extends TransProcessorHandler {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        WeakReference<QQAppInterface> f200048a;

        /* renamed from: b, reason: collision with root package name */
        WeakReference<SelectCoverActivity> f200049b;

        d(QQAppInterface qQAppInterface, SelectCoverActivity selectCoverActivity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) selectCoverActivity);
            } else {
                this.f200048a = new WeakReference<>(qQAppInterface);
                this.f200049b = new WeakReference<>(selectCoverActivity);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            QQAppInterface qQAppInterface = this.f200048a.get();
            SelectCoverActivity selectCoverActivity = this.f200049b.get();
            if (qQAppInterface != null && selectCoverActivity != null) {
                FileMsg fileMsg = (FileMsg) message.obj;
                int i3 = message.what;
                if (i3 == 1003) {
                    SelectCoverActivity.U2(qQAppInterface, selectCoverActivity, fileMsg);
                } else if (i3 == 1005) {
                    SelectCoverActivity.T2(selectCoverActivity, fileMsg);
                }
            }
        }
    }

    public SelectCoverActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f200020i0 = new Handler(ThreadManagerV2.getFileThreadLooper(), this);
        this.f200021j0 = new Handler(Looper.getMainLooper(), this);
        this.f200026o0 = -1L;
        this.f200027p0 = -1L;
        this.f200028q0 = true;
        this.f200029r0 = -1;
        this.f200030s0 = null;
        this.f200031t0 = 0.0f;
        this.f200032u0 = null;
        this.f200033v0 = null;
        this.L0 = false;
        this.O0 = new Object();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M2() {
        boolean z16;
        String e16 = DynamicUtils.e(this.f200025n0, 200);
        DynamicUtils.a(this.f200025n0, e16, 200, this);
        this.M0.f199956d = e16;
        String e17 = DynamicUtils.e(this.f200025n0, 100);
        DynamicUtils.a(this.f200025n0, e17, 100, this);
        this.M0.f199957e = e17;
        ap apVar = this.D0;
        if (apVar != null && apVar.c()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (!TextUtils.isEmpty(this.M0.f199956d) && new File(this.M0.f199956d).exists() && !TextUtils.isEmpty(this.M0.f199957e) && new File(this.M0.f199957e).exists()) {
                l3();
            } else {
                this.D0.b();
                j3(2, HardCodeUtil.qqStr(R.string.f172675t90), 0);
            }
        }
    }

    private int P2(int i3) {
        long j3 = this.f200027p0;
        if (j3 <= 0) {
            return -1;
        }
        int i16 = (int) (j3 / this.f200022k0);
        int i17 = 0;
        while (true) {
            int i18 = this.f200022k0;
            if (i17 < i18 - 1) {
                if (i3 >= i16 * i17 && i3 < (i17 + 1) * i16) {
                    return i17;
                }
                i17++;
            } else {
                return i18 - 1;
            }
        }
    }

    private boolean R2() {
        boolean z16;
        synchronized (this.O0) {
            z16 = this.P0;
        }
        return z16;
    }

    private static void S2(QQAppInterface qQAppInterface, SelectCoverActivity selectCoverActivity, FileMsg fileMsg) {
        String str;
        String str2 = ((NearbyPeoplePhotoUploadProcessor) fileMsg.processor).mPhotoUrl;
        if (QLog.isColorLevel()) {
            QLog.i("SelectCoverActivity", 2, "mPhotoUploadHandler.handleMessage(), static avatar upload success. photoId = " + str2);
        }
        CardHandler cardHandler = (CardHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
        if (cardHandler != null) {
            cardHandler.z5(true, qQAppInterface.getCurrentAccountUin(), 0);
        }
        FaceUtil.setTempAvatarFilePath(null);
        if (((Integer) ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).getValue(qQAppInterface.getAccount(), INearbySPUtil.SP_KEY_QQ_AVATAR_TYPE, (Object) (-1))).intValue() != 1) {
            ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).setValue(qQAppInterface.getAccount(), INearbySPUtil.SP_KEY_QQ_AVATAR_TYPE, (Object) 1);
        }
        if (selectCoverActivity.B0 != 3) {
            String valueOf = String.valueOf(selectCoverActivity.H0);
            String str3 = selectCoverActivity.I0;
            String str4 = selectCoverActivity.J0;
            if (selectCoverActivity.K0) {
                str = "1";
            } else {
                str = "0";
            }
            ReportController.o(qQAppInterface, "dc00898", "", "", "0X800711D", "0X800711D", 0, 0, valueOf, str3, str4, str);
        }
        if (selectCoverActivity.F0) {
            Intent intent = new Intent();
            intent.putExtra("key_photo_file_path", selectCoverActivity.G0);
            selectCoverActivity.setResult(-1, intent);
        } else if (selectCoverActivity.B0 == 3) {
            String stringExtra = selectCoverActivity.getIntent().getStringExtra(MiniProgramOpenSdkUtil.ATTR_SHARE_APPID_RICH);
            ((IVasFragmentRoute) QRoute.api(IVasFragmentRoute.class)).openAvatarPendantShop(selectCoverActivity, "7");
            ReportController.o(qQAppInterface, "dc00898", "", "", "0X8009DFA", "0X8009DFA", 0, 0, stringExtra, "", "", "");
        } else {
            selectCoverActivity.setResult(-1);
        }
        selectCoverActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void T2(SelectCoverActivity selectCoverActivity, FileMsg fileMsg) {
        String str;
        if (QLog.isColorLevel()) {
            QLog.i("SelectCoverActivity", 2, String.format("mPhotoUploadHandler.handleMessage() upload photo failed, errorCode=%s", Integer.valueOf(fileMsg.errorCode)));
        }
        if (fileMsg.errorCode == 1503) {
            QQToast.makeText(BaseApplicationImpl.getApplication(), 1, R.string.f20338502, 0).show(selectCoverActivity.getTitleBarHeight());
            ap apVar = selectCoverActivity.D0;
            if (apVar != null) {
                apVar.b();
            }
        } else {
            if (TextUtils.isEmpty(fileMsg.errorMessage)) {
                str = HardCodeUtil.qqStr(R.string.t8x);
            } else {
                str = fileMsg.errorMessage;
            }
            selectCoverActivity.j3(2, str, 0);
        }
        FaceUtil.setTempAvatarFilePath(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void U2(QQAppInterface qQAppInterface, SelectCoverActivity selectCoverActivity, FileMsg fileMsg) {
        if (selectCoverActivity.R2()) {
            if (QLog.isColorLevel()) {
                QLog.d("SelectCoverActivity", 2, "mPhotoUploadHandler.handleMessage upload canceled.");
            }
            FaceUtil.setTempAvatarFilePath(null);
            return;
        }
        int i3 = fileMsg.fileType;
        if (i3 == 48) {
            S2(qQAppInterface, selectCoverActivity, fileMsg);
            return;
        }
        if (i3 == 36) {
            V2(qQAppInterface, selectCoverActivity, fileMsg);
        } else if (i3 == 37) {
            W2(qQAppInterface, selectCoverActivity, fileMsg);
        } else if (i3 == 38) {
            Y2(qQAppInterface, selectCoverActivity, fileMsg);
        }
    }

    private static void V2(QQAppInterface qQAppInterface, SelectCoverActivity selectCoverActivity, FileMsg fileMsg) {
        String str = ((NearbyPeoplePhotoUploadProcessor) fileMsg.processor).mVideoId;
        if (QLog.isColorLevel()) {
            QLog.i("SelectCoverActivity", 2, "mPhotoUploadHandler.handleMessage(), big video upload success. videoId = " + str);
        }
        ThreadManagerV2.post(new Runnable(qQAppInterface) { // from class: com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity.6
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ QQAppInterface f200042e;

            {
                this.f200042e = qQAppInterface;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectCoverActivity.this, (Object) qQAppInterface);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                String str2 = SelectCoverActivity.this.M0.f199956d;
                if (!new File(str2).exists()) {
                    SelectCoverActivity.this.j3(2, HardCodeUtil.qqStr(R.string.f172678t93), 0);
                } else {
                    DynamicUtils.k(this.f200042e, str2, 37, SelectCoverActivity.this.C0, 200);
                    FaceUtil.setTempAvatarFilePath(str2);
                }
            }
        }, 8, null, true);
    }

    private static void W2(QQAppInterface qQAppInterface, SelectCoverActivity selectCoverActivity, FileMsg fileMsg) {
        String str = ((NearbyPeoplePhotoUploadProcessor) fileMsg.processor).mVideoId;
        if (QLog.isColorLevel()) {
            QLog.i("SelectCoverActivity", 2, "mPhotoUploadHandler.handleMessage(), medium video upload success. videoId = " + str);
        }
        ThreadManagerV2.post(new Runnable(qQAppInterface) { // from class: com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity.5
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ QQAppInterface f200040e;

            {
                this.f200040e = qQAppInterface;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectCoverActivity.this, (Object) qQAppInterface);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                String str2 = SelectCoverActivity.this.M0.f199957e;
                if (!new File(str2).exists()) {
                    SelectCoverActivity.this.j3(2, HardCodeUtil.qqStr(R.string.t8w), 0);
                } else {
                    DynamicUtils.k(this.f200040e, str2, 38, SelectCoverActivity.this.C0, 100);
                    FaceUtil.setTempAvatarFilePath(str2);
                }
            }
        }, 8, null, true);
    }

    private static void Y2(QQAppInterface qQAppInterface, SelectCoverActivity selectCoverActivity, FileMsg fileMsg) {
        String str = ((NearbyPeoplePhotoUploadProcessor) fileMsg.processor).mVideoId;
        if (QLog.isColorLevel()) {
            QLog.i("SelectCoverActivity", 2, "mPhotoUploadHandler.handleMessage(), small video upload success. videoId = " + str);
        }
        DynamicUtils.l(qQAppInterface, selectCoverActivity.E0);
        FaceUtil.setTempAvatarFilePath(selectCoverActivity.E0);
    }

    private void Z2(Bitmap bitmap) {
        this.f200018g0 = new com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.a(bitmap, getResources());
        this.f200019h0 = new com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.a(bitmap, getResources());
        this.f200012a0.setImageBitmap(bitmap);
        this.f200034w0.setBackgroundDrawable(this.f200019h0);
        a aVar = new a(null, getResources());
        this.f200017f0 = aVar;
        this.f200014c0.b(aVar);
        this.f200014c0.b(this.f200018g0);
        this.f200014c0.b(this.f200019h0);
        this.f200019h0.d(true);
        this.f200013b0.setOnProgressChangedListener(this);
        this.f200013b0.setThumb(N2(this.f200018g0));
        this.f200013b0.setMax((int) this.f200014c0.h());
        DrawableSeekbar drawableSeekbar = this.f200013b0;
        int i3 = this.f200024m0;
        drawableSeekbar.setThumbSize(i3, i3);
        int i16 = this.f200029r0;
        if (i16 >= 0) {
            this.f200013b0.setProgress(i16);
        }
    }

    private void b3() {
        setRightButton(R.string.b9f, this);
        if (this.B0 == 3) {
            setTitle("\u8bbe\u7f6eQQ\u52a8\u6001\u5934\u50cf");
        } else {
            setTitle(HardCodeUtil.qqStr(R.string.t8y));
        }
        this.rightViewText.setTextColor(getResources().getColorStateList(R.color.f157808a01));
        this.centerView.setTextColor(getResources().getColorStateList(R.color.f157808a01));
        int parseColor = Color.parseColor("#1a1a1a");
        getTitleBarView().setBackgroundDrawable(null);
        getTitleBarView().setBackgroundColor(parseColor);
        if (SystemBarActivityModule.getSystemBarComp(this) != null) {
            SystemBarActivityModule.getSystemBarComp(this).setStatusDrawable(null);
            SystemBarActivityModule.getSystemBarComp(this).setStatusBarDrawable(null);
            SystemBarActivityModule.getSystemBarComp(this).setStatusColor(parseColor);
            SystemBarActivityModule.getSystemBarComp(this).setStatusBarColor(parseColor);
        }
    }

    private void d3(View view, View view2) {
        this.f200032u0 = new Rect();
        this.f200033v0 = new Rect();
        Point point = new Point();
        view.getGlobalVisibleRect(this.f200032u0);
        this.f200037z0.getGlobalVisibleRect(this.f200033v0, point);
        view2.getGlobalVisibleRect(this.f200033v0);
        this.f200032u0.offset(-point.x, -point.y);
        this.f200033v0.offset(-point.x, -point.y);
        if (this.f200033v0.width() / this.f200033v0.height() > this.f200032u0.width() / this.f200032u0.height()) {
            float height = this.f200032u0.height() / this.f200033v0.height();
            this.f200031t0 = height;
            float width = ((height * this.f200033v0.width()) - this.f200032u0.width()) / 2.0f;
            Rect rect = this.f200032u0;
            rect.left = (int) (rect.left - width);
            rect.right = (int) (rect.right + width);
            return;
        }
        float width2 = this.f200032u0.width() / this.f200033v0.width();
        this.f200031t0 = width2;
        float height2 = ((width2 * this.f200033v0.height()) - this.f200032u0.height()) / 2.0f;
        Rect rect2 = this.f200032u0;
        rect2.top = (int) (rect2.top - height2);
        rect2.bottom = (int) (rect2.bottom + height2);
    }

    private boolean e3() {
        String str = Build.MANUFACTURER + "-" + DeviceInfoMonitor.getModel();
        boolean equalsIgnoreCase = str.equalsIgnoreCase("Xiaomi-MI NOTE Pro");
        if (QLog.isColorLevel()) {
            QLog.i("SelectCoverActivity", 2, "isxiaomi:" + equalsIgnoreCase + " deviceinfo:" + str);
        }
        return equalsIgnoreCase;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f3(int i3) {
        int P2 = P2(i3);
        if (P2 != -1 && P2 < this.f200015d0.getChildCount()) {
            Drawable a16 = ((CustomImgView) this.f200015d0.getChildAt(P2)).a();
            if (a16 instanceof BitmapDrawable) {
                Bitmap bitmap = ((BitmapDrawable) a16).getBitmap();
                this.f200012a0.setImageBitmap(bitmap);
                this.f200019h0.c(bitmap);
                this.f200018g0.c(bitmap);
            }
        }
        this.f200014c0.j(i3);
    }

    private boolean g3(int i3) {
        long j3 = this.f200027p0;
        if (j3 <= 0) {
            return false;
        }
        int i16 = (int) (j3 / this.f200022k0);
        if (this.f200013b0.a() < i3 || this.f200013b0.a() >= i3 + i16) {
            return false;
        }
        return true;
    }

    private int getReportFromType() {
        if (this.B0 != 1) {
            return 1;
        }
        return 0;
    }

    private void i3(boolean z16) {
        synchronized (this.O0) {
            this.P0 = z16;
        }
    }

    @TargetApi(11)
    private void initViews() {
        this.f200012a0 = (CustomImgView) findViewById(R.id.fyc);
        this.f200034w0 = findViewById(R.id.head);
        this.f200037z0 = findViewById(R.id.b8q);
        this.f200035x0 = findViewById(R.id.d2w);
        this.f200036y0 = findViewById(R.id.head_layout);
        this.f200013b0 = (DrawableSeekbar) findViewById(R.id.iln);
        this.f200015d0 = (LinearLayout) findViewById(R.id.eei);
        this.A0 = findViewById(R.id.k8k);
        int screenWidth = ImmersiveUtils.getScreenWidth();
        int screenHeight = ImmersiveUtils.getScreenHeight();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f200012a0.getLayoutParams();
        layoutParams.height = screenWidth;
        this.f200012a0.setLayoutParams(layoutParams);
        int i3 = (int) (screenHeight * 0.125d);
        float f16 = screenWidth;
        int i16 = (int) (0.125f * f16);
        int titleBarHeight = (int) (screenHeight - (((getTitleBarHeight() + i3) + (this.mDensity * 100.0f)) + ImmersiveUtils.getStatusBarHeight(this)));
        int i17 = screenWidth - (i16 * 2);
        float f17 = titleBarHeight;
        float f18 = f17 / i17;
        if (QLog.isColorLevel()) {
            QLog.i("SelectCoverActivity", 2, "remainHeight:" + titleBarHeight + " remainWidth:" + i17 + " scale:" + f18);
        }
        if (f18 < 1.2294372f) {
            i16 = (int) ((f16 - (f17 / 1.2294372f)) * 0.5f);
            if (QLog.isColorLevel()) {
                QLog.i("SelectCoverActivity", 2, "recalc margin margin:" + i16);
            }
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f200036y0.getLayoutParams();
        layoutParams2.leftMargin = i16;
        layoutParams2.rightMargin = i16;
        this.f200036y0.setLayoutParams(layoutParams2);
        this.f200023l0 = (int) getResources().getDimension(R.dimen.azh);
        this.f200024m0 = (int) getResources().getDimension(R.dimen.azl);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.A0.getLayoutParams();
        layoutParams3.height = i3;
        this.A0.setLayoutParams(layoutParams3);
        int dimension = screenWidth - (((int) getResources().getDimension(R.dimen.azg)) * 2);
        int i18 = this.f200023l0;
        int i19 = dimension / i18;
        this.f200022k0 = i19;
        if (dimension % i18 != 0) {
            this.f200022k0 = i19 + 1;
        }
        int i26 = this.f200023l0;
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i26, i26);
        if (this.f200016e0 == null) {
            this.f200016e0 = new ColorDrawable(Integer.MIN_VALUE);
        }
        for (int i27 = 0; i27 < this.f200022k0; i27++) {
            CustomImgView customImgView = new CustomImgView(this);
            customImgView.f384543d.setScaleType(ImageView.ScaleType.FIT_XY);
            customImgView.setBackgroundDrawable(this.f200016e0);
            this.f200015d0.addView(customImgView, layoutParams4);
        }
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.f200034w0.getLayoutParams();
        if (e3()) {
            layoutParams5.rightMargin += 10;
            layoutParams5.topMargin += 50;
            layoutParams5.height = 154;
            layoutParams5.width = 154;
            this.f200034w0.setLayoutParams(layoutParams5);
        }
        TextView textView = this.leftView;
        if (textView != null) {
            textView.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.f162689m50), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j3(int i3, String str, int i16) {
        this.f200021j0.obtainMessage(7, i3, i16, str).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l3() {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        this.C0 = currentTimeMillis;
        DynamicUtils.k(this.app, this.f200025n0, 36, currentTimeMillis, 640);
        FaceUtil.setTempAvatarFilePath(this.f200025n0);
        i3(false);
    }

    private void n3() {
        if (VersionUtils.isIceScreamSandwich()) {
            p3(this.f200034w0, this.f200012a0);
            return;
        }
        this.f200012a0.setVisibility(0);
        this.f200034w0.setVisibility(8);
        this.f200035x0.setVisibility(8);
        this.A0.setVisibility(8);
    }

    private void r3() {
        if (VersionUtils.isIceScreamSandwich()) {
            s3(this.f200034w0, this.f200012a0);
            return;
        }
        this.f200012a0.setVisibility(8);
        this.f200034w0.setVisibility(0);
        this.f200035x0.setVisibility(0);
        this.A0.setVisibility(0);
    }

    @Override // com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.DrawableSeekbar.a
    public void F1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("SelectCoverActivity", 2, "onSeekEnd");
        }
        if (this.f200021j0.hasMessages(8)) {
            this.f200021j0.removeMessages(8);
        }
        this.f200021j0.sendEmptyMessageDelayed(8, 400L);
    }

    @Override // com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.DrawableSeekbar.a
    public void G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("SelectCoverActivity", 2, "onSeekStart");
        }
        DynamicUtils.j(this.app, "0X800710B", getReportFromType());
        if (this.f200021j0.hasMessages(8)) {
            this.f200021j0.removeMessages(8);
        }
        n3();
        this.K0 = true;
    }

    Drawable N2(Drawable drawable) {
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable, (GradientDrawable) getResources().getDrawable(R.drawable.ah9)});
        int density = (int) (ImmersiveUtils.getDensity() * 1.0f);
        layerDrawable.setLayerInset(0, density, density, density, density);
        return layerDrawable;
    }

    boolean Q2(int i3) {
        int i16;
        Bitmap g16;
        Animation animation;
        if (i3 > this.f200022k0 - 1) {
            return true;
        }
        long h16 = this.f200014c0.h();
        int i17 = (int) (h16 / (r1 - 1));
        if (i3 == this.f200022k0 - 1) {
            i16 = (int) this.f200014c0.h();
        } else {
            i16 = i3 * i17;
        }
        try {
            Bitmap f16 = this.f200014c0.f(i16);
            if (f16 != null) {
                int i18 = this.f200023l0;
                g16 = DynamicUtils.f(f16, i18, i18);
                if (f16 != g16 && !f16.isRecycled()) {
                    f16.recycle();
                }
            } else {
                g16 = this.f200014c0.g();
            }
            if (i3 == 0) {
                this.f200021j0.obtainMessage(1, g16).sendToTarget();
            }
            try {
                animation = AnimationUtils.loadAnimation(this, R.anim.f154942fe);
            } catch (Throwable th5) {
                th = th5;
                animation = null;
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                e16.printStackTrace();
            }
        } catch (OutOfMemoryError e17) {
            if (QLog.isColorLevel()) {
                QLog.i("SelectCoverActivity", 2, e17.getMessage(), e17);
            }
        }
        try {
            animation.setInterpolator(new DecelerateInterpolator(2.0f));
            animation.setFillAfter(false);
            animation.setDuration(50L);
        } catch (Throwable th6) {
            th = th6;
            if (QLog.isColorLevel()) {
                QLog.i("SelectCoverActivity", 2, th.getMessage(), th);
            }
            this.f200021j0.obtainMessage(0, i3, i16, new Object[]{g16, animation}).sendToTarget();
            return false;
        }
        this.f200021j0.obtainMessage(0, i3, i16, new Object[]{g16, animation}).sendToTarget();
        return false;
    }

    @Override // com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.VideoDrawableHandler.a
    public void U1(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (this.f200021j0.hasMessages(5)) {
            this.f200021j0.removeMessages(5);
        }
        this.f200021j0.sendMessageDelayed(this.f200021j0.obtainMessage(5, i3, i16), 300L);
    }

    boolean c3() {
        VideoDrawableHandler videoDrawableHandler = new VideoDrawableHandler(this.app, this);
        this.f200014c0 = videoDrawableHandler;
        if (!videoDrawableHandler.i(this.f200025n0, this.f200026o0, this.f200027p0, this.f200028q0)) {
            if (QLog.isColorLevel()) {
                QLog.i("SelectCoverActivity", 2, "doOnCreate return file error");
            }
            finish();
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    @TargetApi(14)
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        this.B0 = getIntent().getIntExtra("param_source", 0);
        this.F0 = getIntent().getBooleanExtra("param_from_newer_guide", false);
        if (this.B0 != 0) {
            this.H0 = getIntent().getIntExtra("key_video_duration", 0);
            this.I0 = getIntent().getStringExtra("key_video_has_voice");
            this.J0 = getIntent().getStringExtra("key_camera_id");
            DynamicAvatarManager dynamicAvatarManager = (DynamicAvatarManager) this.app.getManager(QQManagerFactory.DYNAMIC_AVATAR_MANAGER);
            this.M0 = dynamicAvatarManager;
            dynamicAvatarManager.f199956d = null;
            dynamicAvatarManager.f199957e = null;
            setContentView(getLayoutInflater().inflate(R.layout.b0z, (ViewGroup) null));
            b3();
            getWindow().setBackgroundDrawable(null);
            initViews();
            this.f200025n0 = getIntent().getStringExtra("key_video_file_path");
            this.f200026o0 = getIntent().getLongExtra("key_video_start_time", -1L);
            this.f200027p0 = getIntent().getLongExtra("key_video_select_duration", -1L);
            this.f200028q0 = getIntent().getBooleanExtra("key_video_sync_frame", true);
            this.f200029r0 = getIntent().getIntExtra("key_photo_select_time", -1);
            if (!FileUtils.fileExists(this.f200025n0)) {
                if (QLog.isColorLevel()) {
                    QLog.i("SelectCoverActivity", 2, "doOnCreate return filepath:" + this.f200025n0);
                }
                finish();
                return false;
            }
            d dVar = new d(this.app, this);
            this.N0 = dVar;
            dVar.addFilter(NearbyPeoplePhotoUploadProcessor.class);
            ((ITransFileController) this.app.getRuntimeService(ITransFileController.class)).addHandle(this.N0);
            ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SelectCoverActivity.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    SelectCoverActivity selectCoverActivity;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (!SelectCoverActivity.this.L0 && SelectCoverActivity.this.c3() && !SelectCoverActivity.this.L0) {
                        int i3 = 0;
                        while (true) {
                            selectCoverActivity = SelectCoverActivity.this;
                            if (i3 >= selectCoverActivity.f200022k0) {
                                break;
                            }
                            if (!selectCoverActivity.L0) {
                                SelectCoverActivity.this.Q2(i3);
                            }
                            i3++;
                        }
                        int i16 = selectCoverActivity.B0;
                        if (i16 == 1 || i16 == 3) {
                            selectCoverActivity.M2();
                        }
                    }
                }
            }, null, true);
            if (this.B0 == 3) {
                k.d(this, this.f200025n0);
            }
            return true;
        }
        throw new IllegalArgumentException("source must not be null");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    @TargetApi(11)
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.doOnDestroy();
        this.L0 = true;
        this.f200020i0.removeCallbacksAndMessages(null);
        this.f200021j0.removeCallbacksAndMessages(null);
        VideoDrawableHandler videoDrawableHandler = this.f200014c0;
        if (videoDrawableHandler != null) {
            videoDrawableHandler.e();
        }
        Animator animator = this.f200030s0;
        if (animator != null) {
            animator.cancel();
        }
        if (this.N0 != null) {
            ((ITransFileController) this.app.getRuntimeService(ITransFileController.class)).removeHandle(this.N0);
            FaceUtil.setTempAvatarFilePath(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.doOnResume();
            b3();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x010b, code lost:
    
        if (r7 == null) goto L93;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0146 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:128:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x013c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0117 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0112 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0121  */
    /* JADX WARN: Type inference failed for: r10v0, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v1, types: [long] */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.io.OutputStream, java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.io.FileOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    String h3(Bitmap bitmap) {
        String str;
        BufferedOutputStream bufferedOutputStream;
        FileOutputStream fileOutputStream;
        OutputStream outputStream;
        BufferedOutputStream bufferedOutputStream2;
        File file = new File(VFSAssistantUtils.getSDKPrivatePath(AppConstants.DYNAMIC_PROFILE));
        file.mkdirs();
        ?? sb5 = new StringBuilder();
        sb5.append("cover");
        ?? currentTimeMillis = System.currentTimeMillis();
        sb5.append(currentTimeMillis);
        File file2 = new File(file, sb5.toString());
        if (file2.exists()) {
            file2.delete();
        }
        FileOutputStream fileOutputStream2 = null;
        try {
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        try {
            try {
                currentTimeMillis = new FileOutputStream(file2);
                try {
                    bufferedOutputStream2 = new BufferedOutputStream(currentTimeMillis, 4096);
                } catch (FileNotFoundException e17) {
                    e = e17;
                    bufferedOutputStream2 = null;
                } catch (IOException e18) {
                    e = e18;
                    bufferedOutputStream2 = null;
                } catch (Throwable th5) {
                    th = th5;
                    outputStream = null;
                    fileOutputStream2 = currentTimeMillis;
                    if (fileOutputStream2 != null) {
                    }
                    if (outputStream == null) {
                    }
                }
            } catch (FileNotFoundException e19) {
                e = e19;
                currentTimeMillis = 0;
                bufferedOutputStream2 = null;
            } catch (IOException e26) {
                e = e26;
                currentTimeMillis = 0;
                bufferedOutputStream2 = null;
            } catch (Throwable th6) {
                th = th6;
                outputStream = null;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e27) {
                        e27.printStackTrace();
                    }
                }
                if (outputStream == null) {
                    try {
                        outputStream.close();
                        throw th;
                    } catch (IOException e28) {
                        e28.printStackTrace();
                        throw th;
                    }
                }
                throw th;
            }
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream2);
                bufferedOutputStream2.flush();
                str = file2.getAbsolutePath();
                try {
                    currentTimeMillis.close();
                } catch (IOException e29) {
                    e29.printStackTrace();
                }
                try {
                    bufferedOutputStream2.close();
                } catch (IOException e36) {
                    e36.printStackTrace();
                }
            } catch (FileNotFoundException e37) {
                e = e37;
                e.printStackTrace();
                if (currentTimeMillis != 0) {
                    try {
                        currentTimeMillis.close();
                    } catch (IOException e38) {
                        e38.printStackTrace();
                    }
                }
                if (bufferedOutputStream2 != null) {
                    bufferedOutputStream2.close();
                }
                str = null;
                if (this.F0) {
                }
                if (QLog.isColorLevel()) {
                }
                return str;
            } catch (IOException e39) {
                e = e39;
                e.printStackTrace();
                if (currentTimeMillis != 0) {
                    try {
                        currentTimeMillis.close();
                    } catch (IOException e46) {
                        e46.printStackTrace();
                    }
                }
                if (bufferedOutputStream2 != null) {
                    bufferedOutputStream2.close();
                }
                str = null;
                if (this.F0) {
                }
                if (QLog.isColorLevel()) {
                }
                return str;
            }
            if (this.F0) {
                File file3 = new File(AppConstants.PATH_NEWER_GUIDE_DIR_NAME);
                if (!file3.exists()) {
                    file3.mkdirs();
                }
                File file4 = new File(file3, "temp_avatar");
                if (file4.exists()) {
                    file4.delete();
                }
                try {
                    fileOutputStream = new FileOutputStream(file4);
                } catch (Exception e47) {
                    e = e47;
                    fileOutputStream = null;
                    bufferedOutputStream = null;
                } catch (Throwable th7) {
                    th = th7;
                    bufferedOutputStream = null;
                    if (fileOutputStream2 != null) {
                    }
                    if (bufferedOutputStream != null) {
                    }
                }
                try {
                    bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                } catch (Exception e48) {
                    e = e48;
                    bufferedOutputStream = null;
                } catch (Throwable th8) {
                    th = th8;
                    bufferedOutputStream = null;
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                    }
                    if (bufferedOutputStream != null) {
                    }
                }
                try {
                    try {
                        Bitmap.createScaledBitmap(bitmap, 200, 200, true).compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream);
                        bufferedOutputStream.flush();
                        this.G0 = file4.getAbsolutePath();
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused) {
                        }
                    } catch (Throwable th9) {
                        th = th9;
                        fileOutputStream2 = fileOutputStream;
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (Exception unused2) {
                            }
                        }
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                                throw th;
                            } catch (Exception unused3) {
                                throw th;
                            }
                        }
                        throw th;
                    }
                } catch (Exception e49) {
                    e = e49;
                    QLog.e("SelectCoverActivity", 1, "save photo temp file for newer guide fail!", e);
                    this.G0 = null;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused4) {
                        }
                    }
                }
                try {
                    bufferedOutputStream.close();
                } catch (Exception unused5) {
                }
            }
            if (QLog.isColorLevel()) {
                QLog.i("SelectCoverActivity", 2, "saveFile " + str);
            }
            return str;
        } catch (Throwable th10) {
            th = th10;
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        ap apVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) message)).booleanValue();
        }
        switch (message.what) {
            case 0:
                int i3 = message.arg1;
                int i16 = message.arg2;
                Object[] objArr = (Object[]) message.obj;
                Bitmap bitmap = (Bitmap) objArr[0];
                Animation animation = (Animation) objArr[1];
                CustomImgView customImgView = (CustomImgView) this.f200015d0.getChildAt(i3);
                customImgView.setImageBitmap(bitmap);
                customImgView.setTag(Integer.valueOf(i16));
                customImgView.setOnTouchListener(this);
                if (animation != null) {
                    customImgView.startAnimation(animation);
                }
                if (g3(i16)) {
                    this.f200018g0.c(bitmap);
                    break;
                }
                break;
            case 1:
                Z2((Bitmap) message.obj);
                onProgressChanged(0);
                break;
            case 2:
                this.f200014c0.c();
                onProgressChanged(message.arg1);
                break;
            case 4:
                com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.a aVar = new com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.a((Bitmap) message.obj, getResources());
                this.f200019h0 = aVar;
                aVar.d(true);
                this.f200034w0.setBackgroundDrawable(this.f200019h0);
                this.f200034w0.setVisibility(0);
                break;
            case 5:
                int i17 = message.arg1;
                if (message.arg2 != 0) {
                    QQToast.makeText(this, String.format(HardCodeUtil.qqStr(R.string.t8t), Float.valueOf(i17 / 1000.0f)), 0).show();
                    break;
                }
                break;
            case 6:
                QQToast.makeText(this, HardCodeUtil.qqStr(R.string.f172679t94), 0).show();
                break;
            case 7:
                int i18 = message.arg1;
                int i19 = message.arg2;
                String str = (String) message.obj;
                if (!this.L0 && (apVar = this.D0) != null) {
                    apVar.f(i18, str, i19, this);
                    break;
                }
                break;
            case 8:
                r3();
                break;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        DynamicUtils.j(this.app, "0X800710C", getReportFromType());
        return super.onBackEvent();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) dialogInterface);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SelectCoverActivity", 2, "onCancel notify dialog canceled.");
        }
        i3(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Bitmap bitmap;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) view);
        } else if (view == this.rightViewText) {
            DynamicUtils.j(this.app, "0X800710D", getReportFromType());
            if (FaceUtil.isUploadingAvatar()) {
                j3(2, HardCodeUtil.qqStr(R.string.f172678t93), 0);
            } else if (!NetworkUtil.isNetworkAvailable(this)) {
                QQToast.makeText(this, 1, getString(R.string.f171139ci4), 0).show(getTitleBarHeight());
            } else {
                Drawable background = this.f200034w0.getBackground();
                if (background != null && (background instanceof BitmapDrawable)) {
                    bitmap = ((BitmapDrawable) background).getBitmap();
                } else if (background != null && (background instanceof com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.a)) {
                    bitmap = ((com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.a) background).b();
                } else {
                    bitmap = null;
                }
                if (bitmap == null) {
                    QQToast.makeText(this, HardCodeUtil.qqStr(R.string.t8z), 0).show();
                    if (QLog.isColorLevel()) {
                        QLog.i("SelectCoverActivity", 2, "android version:" + Build.VERSION.SDK_INT);
                    }
                } else {
                    if (this.D0 == null) {
                        this.D0 = new ap(this);
                    }
                    j3(0, HardCodeUtil.qqStr(R.string.t8v), 0);
                    ThreadManagerV2.postImmediately(new Runnable(bitmap) { // from class: com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity.4
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ Bitmap f200038d;

                        {
                            this.f200038d = bitmap;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SelectCoverActivity.this, (Object) bitmap);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            if (SelectCoverActivity.this.L0) {
                                return;
                            }
                            SelectCoverActivity selectCoverActivity = SelectCoverActivity.this;
                            selectCoverActivity.E0 = selectCoverActivity.h3(this.f200038d);
                            if (SelectCoverActivity.this.L0) {
                                return;
                            }
                            if (TextUtils.isEmpty(SelectCoverActivity.this.E0)) {
                                SelectCoverActivity.this.j3(2, HardCodeUtil.qqStr(R.string.f172676t91), 0);
                                return;
                            }
                            SelectCoverActivity.this.j3(0, HardCodeUtil.qqStr(R.string.t8u), 0);
                            SelectCoverActivity selectCoverActivity2 = SelectCoverActivity.this;
                            int i3 = selectCoverActivity2.B0;
                            if (i3 != 1 && i3 != 3) {
                                if (i3 == 2 || i3 == 4) {
                                    Intent intent = selectCoverActivity2.getIntent();
                                    intent.putExtra("key_photo_file_path", SelectCoverActivity.this.E0);
                                    intent.putExtra("key_video_duration", SelectCoverActivity.this.H0);
                                    intent.putExtra("key_video_has_voice", SelectCoverActivity.this.I0);
                                    intent.putExtra("key_camera_id", SelectCoverActivity.this.J0);
                                    intent.putExtra("key_photo_selected_by_user", SelectCoverActivity.this.K0);
                                    intent.putExtra("key_photo_select_time", SelectCoverActivity.this.f200013b0.a());
                                    SelectCoverActivity.this.setResult(-1, intent);
                                    SelectCoverActivity.this.finish();
                                    return;
                                }
                                return;
                            }
                            if (!TextUtils.isEmpty(selectCoverActivity2.M0.f199956d) && new File(SelectCoverActivity.this.M0.f199956d).exists() && !TextUtils.isEmpty(SelectCoverActivity.this.M0.f199957e) && new File(SelectCoverActivity.this.M0.f199957e).exists()) {
                                SelectCoverActivity.this.l3();
                            }
                        }
                    }, null, true);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.DrawableSeekbar.a
    public void onProgressChanged(final int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.avatar.dynamicavatar.d
                @Override // java.lang.Runnable
                public final void run() {
                    SelectCoverActivity.this.f3(i3);
                }
            });
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
        }
        if (!(view instanceof CustomImgView)) {
            return false;
        }
        CustomImgView customImgView = (CustomImgView) view;
        if (!this.f200013b0.c()) {
            return false;
        }
        this.f200020i0.obtainMessage(2, ((Integer) customImgView.getTag()).intValue(), 0).sendToTarget();
        this.f200013b0.setThumbOffset(customImgView.getLeft());
        DynamicUtils.j(this.app, "0X800710A", getReportFromType());
        if (QLog.isColorLevel()) {
            QLog.i("SelectCoverActivity", 2, NodeProps.ON_TOUCH_DOWN);
        }
        n3();
        if (this.f200021j0.hasMessages(8)) {
            this.f200021j0.removeMessages(8);
        }
        this.f200021j0.sendEmptyMessageDelayed(8, 400L);
        this.K0 = true;
        return false;
    }

    @TargetApi(14)
    public void p3(View view, View view2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) view, (Object) view2);
            return;
        }
        Animator animator = this.f200030s0;
        if (animator != null) {
            animator.cancel();
        }
        if (this.f200032u0 == null || this.f200033v0 == null || this.f200031t0 <= 0.0f) {
            d3(view, view2);
        }
        view2.setVisibility(0);
        view.setAlpha(0.0f);
        view2.setPivotX(0.0f);
        view2.setPivotY(0.0f);
        this.f200035x0.setVisibility(8);
        this.A0.setVisibility(8);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.X, this.f200032u0.left, this.f200033v0.left)).with(ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.Y, this.f200032u0.top, this.f200033v0.top)).with(ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.SCALE_X, this.f200031t0, 1.0f)).with(ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.SCALE_Y, this.f200031t0, 1.0f));
        animatorSet.setDuration(250L);
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.addListener(new b());
        animatorSet.start();
        this.f200030s0 = animatorSet;
    }

    @TargetApi(14)
    public void s3(View view, View view2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) view, (Object) view2);
            return;
        }
        Animator animator = this.f200030s0;
        if (animator != null) {
            animator.cancel();
        }
        if (this.f200032u0 != null && this.f200033v0 != null && this.f200031t0 > 0.0f) {
            this.f200035x0.setVisibility(0);
            this.A0.setVisibility(0);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.X, this.f200032u0.left)).with(ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.Y, this.f200032u0.top)).with(ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.SCALE_X, this.f200031t0)).with(ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.SCALE_Y, this.f200031t0));
            animatorSet.setDuration(250L);
            animatorSet.setInterpolator(new DecelerateInterpolator());
            animatorSet.addListener(new c(view, view2));
            animatorSet.start();
            this.f200030s0 = animatorSet;
        }
    }
}
