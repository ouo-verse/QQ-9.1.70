package com.tencent.mobileqq.troopgift;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.utils.az;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.maxvideo.common.MessageStruct;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.surfaceviewaction.action.a;
import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.surfaceviewaction.gl.a;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.ak;
import com.tencent.mobileqq.troop.utils.al;
import com.tencent.mobileqq.troop.utils.am;
import com.tencent.mobileqq.troopgift.TroopGiftToAllSurfaceView;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.cl;
import com.tencent.mobileqq.webview.swift.u;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopGiftAnimationController implements View.OnClickListener, TopGestureLayout.OnGestureListener {
    static IPatchRedirector $redirector_;
    private static int T;
    private ActionGlobalData C;
    private a61.c D;
    private Activity E;
    private WindowManager F;
    protected Handler G;
    private FrameSprite.a H;
    private TextView I;
    private AlphaAnimation J;
    private MessageForDeliverGiftTips K;
    protected Drawable L;
    protected Drawable M;
    protected int N;
    private Runnable P;
    private e Q;
    private ak R;
    private a.InterfaceC8634a S;

    /* renamed from: d, reason: collision with root package name */
    protected SpriteGLView f302752d;

    /* renamed from: e, reason: collision with root package name */
    protected TopGestureLayout f302753e;

    /* renamed from: f, reason: collision with root package name */
    protected ImageView f302754f;

    /* renamed from: h, reason: collision with root package name */
    protected xk2.a f302755h;

    /* renamed from: i, reason: collision with root package name */
    private long f302756i;

    /* renamed from: m, reason: collision with root package name */
    public d f302757m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.troopgift.TroopGiftAnimationController$1, reason: invalid class name */
    /* loaded from: classes19.dex */
    class AnonymousClass1 implements Runnable {
        static IPatchRedirector $redirector_;

        AnonymousClass1() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopGiftAnimationController.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            SpriteGLView spriteGLView = TroopGiftAnimationController.this.f302752d;
            if (spriteGLView instanceof TroopGiftToAllSurfaceView) {
                ((TroopGiftToAllSurfaceView) spriteGLView).C(new a.InterfaceC8631a() { // from class: com.tencent.mobileqq.troopgift.TroopGiftAnimationController.1.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                        }
                    }

                    @Override // com.tencent.mobileqq.surfaceviewaction.action.a.InterfaceC8631a
                    public void a() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            TroopGiftAnimationController.this.G.post(new Runnable() { // from class: com.tencent.mobileqq.troopgift.TroopGiftAnimationController.1.1.1
                                static IPatchRedirector $redirector_;

                                {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) C88371.this);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                    } else {
                                        TroopGiftAnimationController.this.l();
                                    }
                                }
                            });
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.troopgift.TroopGiftAnimationController$5, reason: invalid class name */
    /* loaded from: classes19.dex */
    public class AnonymousClass5 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MessageForDeliverGiftTips f302762d;

        AnonymousClass5(MessageForDeliverGiftTips messageForDeliverGiftTips) {
            this.f302762d = messageForDeliverGiftTips;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopGiftAnimationController.this, (Object) messageForDeliverGiftTips);
            }
        }

        /* JADX WARN: Can't wrap try/catch for region: R(12:8|(2:10|(3:12|(1:14)|15)(1:55))(2:56|(1:61)(1:60))|16|(2:18|(4:22|(2:24|(1:49)(1:28))(1:50)|29|(9:31|(1:47)(1:35)|36|37|38|39|40|41|42)(6:48|38|39|40|41|42)))|(1:52)|(1:54)|37|38|39|40|41|42) */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x01b2, code lost:
        
            if (com.tencent.qphone.base.util.QLog.isColorLevel() != false) goto L58;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x01b4, code lost:
        
            com.tencent.qphone.base.util.QLog.d("TroopGiftAnimationController", 2, "decode avatarAnimRes failed");
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            Bitmap bitmap;
            Bitmap bitmap2;
            Bitmap bitmap3;
            Bitmap bitmap4;
            Bitmap defaultFaceBitmap;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            TroopGiftAnimationController.this.f302756i = System.currentTimeMillis();
            Bitmap bitmap5 = null;
            if (TroopGiftAnimationController.this.D != null) {
                TroopGiftAnimationController troopGiftAnimationController = TroopGiftAnimationController.this;
                troopGiftAnimationController.L = troopGiftAnimationController.p(String.valueOf(this.f302762d.senderUin), new FaceDrawable.OnLoadingStateChangeListener() { // from class: com.tencent.mobileqq.troopgift.TroopGiftAnimationController.5.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass5.this);
                        }
                    }

                    @Override // com.tencent.mobileqq.app.face.FaceDrawable.OnLoadingStateChangeListener
                    public void onLoadingStateChanged(int i3, int i16) {
                        SpriteGLView spriteGLView;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
                            return;
                        }
                        AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                        Bitmap p16 = TroopUtils.p(TroopGiftAnimationController.this.p(String.valueOf(anonymousClass5.f302762d.senderUin), null));
                        if (i3 == 0 && i16 == 1 && (spriteGLView = TroopGiftAnimationController.this.f302752d) != null) {
                            spriteGLView.t(new Runnable(p16) { // from class: com.tencent.mobileqq.troopgift.TroopGiftAnimationController.5.1.1
                                static IPatchRedirector $redirector_;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ Bitmap f302764d;

                                {
                                    this.f302764d = p16;
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) p16);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                        return;
                                    }
                                    SpriteGLView spriteGLView2 = TroopGiftAnimationController.this.f302752d;
                                    if (spriteGLView2 instanceof TroopGiftToPersonalSurfaceView) {
                                        ((TroopGiftToPersonalSurfaceView) spriteGLView2).setSendHeadBitmap(this.f302764d);
                                    }
                                }
                            });
                        }
                    }
                });
                bitmap = TroopUtils.p(TroopGiftAnimationController.this.L);
                if (!TextUtils.isEmpty(this.f302762d.receiverHead)) {
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    obtain.mRequestHeight = x.c(BaseApplication.getContext(), 70.0f);
                    obtain.mRequestWidth = x.c(BaseApplication.getContext(), 70.0f);
                    obtain.mLoadingDrawable = FaceDrawable.getDefaultDrawable(1, 3);
                    obtain.mFailedDrawable = FaceDrawable.getDefaultDrawable(1, 3);
                    URLDrawable drawable = URLDrawable.getDrawable(this.f302762d.receiverHead, obtain);
                    if (drawable.getStatus() != 1) {
                        drawable.setDownloadListener(new URLDrawable.DownloadListener(drawable) { // from class: com.tencent.mobileqq.troopgift.TroopGiftAnimationController.5.2
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ URLDrawable f302766d;

                            {
                                this.f302766d = drawable;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass5.this, (Object) drawable);
                                }
                            }

                            @Override // com.tencent.image.URLDrawable.DownloadListener
                            public void onFileDownloadFailed(int i3) {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                                    iPatchRedirector2.redirect((short) 4, (Object) this, i3);
                                }
                            }

                            @Override // com.tencent.image.URLDrawable.DownloadListener
                            public void onFileDownloadStarted() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                }
                            }

                            @Override // com.tencent.image.URLDrawable.DownloadListener
                            public void onFileDownloadSucceed(long j3) {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                                    iPatchRedirector2.redirect((short) 3, (Object) this, j3);
                                } else {
                                    if (TroopGiftAnimationController.this.f302752d == null) {
                                        return;
                                    }
                                    TroopGiftAnimationController.this.f302752d.t(new Runnable(TroopUtils.p(this.f302766d)) { // from class: com.tencent.mobileqq.troopgift.TroopGiftAnimationController.5.2.1
                                        static IPatchRedirector $redirector_;

                                        /* renamed from: d, reason: collision with root package name */
                                        final /* synthetic */ Bitmap f302768d;

                                        {
                                            this.f302768d = r5;
                                            IPatchRedirector iPatchRedirector3 = $redirector_;
                                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this, (Object) r5);
                                            }
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            IPatchRedirector iPatchRedirector3 = $redirector_;
                                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                                return;
                                            }
                                            SpriteGLView spriteGLView = TroopGiftAnimationController.this.f302752d;
                                            if (spriteGLView != null) {
                                                ((TroopGiftToPersonalSurfaceView) spriteGLView).setReceiveHeadBitmap(this.f302768d);
                                            }
                                        }
                                    });
                                }
                            }
                        });
                        drawable.startDownload();
                    }
                    drawable.setURLDrawableListener(new URLDrawable.URLDrawableListener(drawable) { // from class: com.tencent.mobileqq.troopgift.TroopGiftAnimationController.5.3
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ URLDrawable f302770d;

                        {
                            this.f302770d = drawable;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass5.this, (Object) drawable);
                            }
                        }

                        @Override // com.tencent.image.URLDrawable.URLDrawableListener
                        public void onLoadCanceled(URLDrawable uRLDrawable) {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                                iPatchRedirector2.redirect((short) 4, (Object) this, (Object) uRLDrawable);
                            }
                        }

                        @Override // com.tencent.image.URLDrawable.URLDrawableListener
                        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                                iPatchRedirector2.redirect((short) 3, (Object) this, (Object) uRLDrawable, (Object) th5);
                            }
                        }

                        @Override // com.tencent.image.URLDrawable.URLDrawableListener
                        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                                iPatchRedirector2.redirect((short) 5, (Object) this, (Object) uRLDrawable, i3);
                            }
                        }

                        @Override // com.tencent.image.URLDrawable.URLDrawableListener
                        public void onLoadSuccessed(URLDrawable uRLDrawable) {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this, (Object) uRLDrawable);
                            } else {
                                if (TroopGiftAnimationController.this.f302752d == null) {
                                    return;
                                }
                                TroopGiftAnimationController.this.f302752d.t(new Runnable(TroopUtils.p(this.f302770d)) { // from class: com.tencent.mobileqq.troopgift.TroopGiftAnimationController.5.3.1
                                    static IPatchRedirector $redirector_;

                                    /* renamed from: d, reason: collision with root package name */
                                    final /* synthetic */ Bitmap f302772d;

                                    {
                                        this.f302772d = r5;
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this, (Object) r5);
                                        }
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                            iPatchRedirector3.redirect((short) 2, (Object) this);
                                            return;
                                        }
                                        SpriteGLView spriteGLView = TroopGiftAnimationController.this.f302752d;
                                        if (spriteGLView != null) {
                                            ((TroopGiftToPersonalSurfaceView) spriteGLView).setReceiveHeadBitmap(this.f302772d);
                                        }
                                    }
                                });
                            }
                        }
                    });
                    TroopGiftAnimationController.this.M = drawable;
                    bitmap2 = TroopUtils.p(drawable);
                } else {
                    TroopGiftAnimationController troopGiftAnimationController2 = TroopGiftAnimationController.this;
                    troopGiftAnimationController2.M = troopGiftAnimationController2.p(String.valueOf(this.f302762d.receiverUin), new FaceDrawable.OnLoadingStateChangeListener() { // from class: com.tencent.mobileqq.troopgift.TroopGiftAnimationController.5.4
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass5.this);
                            }
                        }

                        @Override // com.tencent.mobileqq.app.face.FaceDrawable.OnLoadingStateChangeListener
                        public void onLoadingStateChanged(int i3, int i16) {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
                                return;
                            }
                            if (i3 == 0 && i16 == 1 && (TroopGiftAnimationController.this.f302752d instanceof TroopGiftToPersonalSurfaceView)) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("TroopGiftAnimationController", 2, "onLoadingStateChanged: curState = " + i16);
                                }
                                AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                                TroopGiftAnimationController.this.f302752d.t(new Runnable(TroopUtils.p(TroopGiftAnimationController.this.p(String.valueOf(anonymousClass5.f302762d.receiverUin), null))) { // from class: com.tencent.mobileqq.troopgift.TroopGiftAnimationController.5.4.1
                                    static IPatchRedirector $redirector_;

                                    /* renamed from: d, reason: collision with root package name */
                                    final /* synthetic */ Bitmap f302775d;

                                    {
                                        this.f302775d = r5;
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this, (Object) r5);
                                        }
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                            iPatchRedirector3.redirect((short) 2, (Object) this);
                                            return;
                                        }
                                        SpriteGLView spriteGLView = TroopGiftAnimationController.this.f302752d;
                                        if (spriteGLView != null) {
                                            ((TroopGiftToPersonalSurfaceView) spriteGLView).setReceiveHeadBitmap(this.f302775d);
                                        }
                                    }
                                });
                            }
                        }
                    });
                    bitmap2 = TroopUtils.p(TroopGiftAnimationController.this.M);
                }
            } else if (TroopGiftAnimationController.this.E != null && (TroopGiftAnimationController.this.E instanceof c)) {
                c cVar = (c) TroopGiftAnimationController.this.E;
                Bitmap a16 = cVar.a(String.valueOf(this.f302762d.senderUin), this.f302762d.frienduin);
                bitmap2 = cVar.a(String.valueOf(this.f302762d.receiverUin), this.f302762d.frienduin);
                bitmap = a16;
            } else {
                bitmap = null;
                bitmap2 = null;
            }
            if (!this.f302762d.isToAll()) {
                MessageForDeliverGiftTips messageForDeliverGiftTips = this.f302762d;
                if (messageForDeliverGiftTips.senderUin <= 0 && messageForDeliverGiftTips.receiverUin <= 0) {
                    if (!TextUtils.isEmpty(messageForDeliverGiftTips.senderAvatarUrl)) {
                        URLDrawable drawable2 = URLDrawable.getDrawable(this.f302762d.senderAvatarUrl, URLDrawable.URLDrawableOptions.obtain());
                        drawable2.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306322b);
                        if (drawable2.getStatus() == 1 && drawable2.getCurrDrawable() != null) {
                            bitmap = BaseImageUtil.drawabletoBitmap(drawable2.getCurrDrawable());
                        } else {
                            drawable2.startDownload();
                            bitmap = BaseImageUtil.getDefaultFaceBitmap();
                        }
                    } else {
                        bitmap = null;
                    }
                    if (!TextUtils.isEmpty(this.f302762d.receiveAvatarUrl)) {
                        URLDrawable drawable3 = URLDrawable.getDrawable(this.f302762d.receiveAvatarUrl, URLDrawable.URLDrawableOptions.obtain());
                        drawable3.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306322b);
                        if (drawable3.getStatus() == 1 && drawable3.getCurrDrawable() != null) {
                            defaultFaceBitmap = BaseImageUtil.drawabletoBitmap(drawable3.getCurrDrawable());
                        } else {
                            drawable3.startDownload();
                            defaultFaceBitmap = BaseImageUtil.getDefaultFaceBitmap();
                        }
                        bitmap2 = defaultFaceBitmap;
                        bitmap4 = bitmap;
                        bitmap3 = bitmap2;
                        String d16 = am.d(this.f302762d);
                        bitmap5 = BitmapFactory.decodeFile(d16 + "/avatar/avatar_anim_res.png");
                        TroopGiftAnimationController.this.G.postDelayed(new Runnable(d16, bitmap4, bitmap3, bitmap5) { // from class: com.tencent.mobileqq.troopgift.TroopGiftAnimationController.5.5
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ String f302777d;

                            /* renamed from: e, reason: collision with root package name */
                            final /* synthetic */ Bitmap f302778e;

                            /* renamed from: f, reason: collision with root package name */
                            final /* synthetic */ Bitmap f302779f;

                            /* renamed from: h, reason: collision with root package name */
                            final /* synthetic */ Bitmap f302780h;

                            /* compiled from: P */
                            /* renamed from: com.tencent.mobileqq.troopgift.TroopGiftAnimationController$5$5$a */
                            /* loaded from: classes19.dex */
                            class a implements a.InterfaceC8634a {
                                static IPatchRedirector $redirector_;

                                a() {
                                    IPatchRedirector iPatchRedirector = $redirector_;
                                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) RunnableC88405.this);
                                    }
                                }

                                @Override // com.tencent.mobileqq.surfaceviewaction.gl.a.InterfaceC8634a
                                public void a(com.tencent.mobileqq.surfaceviewaction.gl.e eVar) {
                                    IPatchRedirector iPatchRedirector = $redirector_;
                                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                                    } else {
                                        TroopGiftAnimationController.this.n();
                                    }
                                }
                            }

                            {
                                this.f302777d = d16;
                                this.f302778e = bitmap4;
                                this.f302779f = bitmap3;
                                this.f302780h = bitmap5;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, this, AnonymousClass5.this, d16, bitmap4, bitmap3, bitmap5);
                                }
                            }

                            /* JADX WARN: Code restructure failed: missing block: B:34:0x0118, code lost:
                            
                                if (r1.getCurrentWebViewFragment().isActivityResume() == false) goto L44;
                             */
                            /* JADX WARN: Removed duplicated region for block: B:104:0x022e A[EXC_TOP_SPLITTER, SYNTHETIC] */
                            /* JADX WARN: Removed duplicated region for block: B:134:0x0212  */
                            /* JADX WARN: Removed duplicated region for block: B:43:0x020e  */
                            /* JADX WARN: Removed duplicated region for block: B:50:0x0373  */
                            @Override // java.lang.Runnable
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public void run() {
                                Activity activity;
                                int i3;
                                int i16;
                                int i17;
                                String[] strArr;
                                int i18;
                                Bitmap decodeFileWithBufferedStream;
                                int width;
                                int i19;
                                int i26;
                                Bitmap bitmap6;
                                int i27;
                                int i28;
                                int i29;
                                int i36;
                                int i37;
                                int i38;
                                boolean z16;
                                float f16;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                    return;
                                }
                                SpriteGLView spriteGLView = TroopGiftAnimationController.this.f302752d;
                                if (spriteGLView != null && spriteGLView.getVisibility() != 8 && !TroopGiftAnimationController.this.E.isFinishing()) {
                                    String packageName = TroopGiftAnimationController.this.E.getApplicationContext().getPackageName();
                                    Bitmap bitmap7 = null;
                                    if (TroopGiftAnimationController.this.E instanceof SplashActivity) {
                                        activity = TroopGiftAnimationController.this.E;
                                    } else if (TroopGiftAnimationController.this.E instanceof BasePluginActivity) {
                                        activity = ((BasePluginActivity) TroopGiftAnimationController.this.E).getOutActivity();
                                        int i39 = TroopGiftAnimationController.this.N;
                                        if (i39 == 2) {
                                            packageName = packageName + ":groupvideo";
                                        } else if (i39 == 20) {
                                            packageName = packageName + ":nearby_video";
                                        }
                                    } else if (TroopGiftAnimationController.this.E instanceof QQBrowserActivity) {
                                        packageName = packageName + ":tool";
                                        activity = TroopGiftAnimationController.this.E;
                                    } else {
                                        activity = null;
                                    }
                                    if ((activity == null || cl.b(activity, packageName)) && (!(activity instanceof SplashActivity) || SplashActivity.currentFragment == 2)) {
                                        if (activity instanceof u) {
                                            u uVar = (u) activity;
                                            if (uVar.getCurrentWebViewFragment() != null) {
                                            }
                                        }
                                        if (!AnonymousClass5.this.f302762d.isToAll()) {
                                            i3 = TroopGiftAnimationController.q(TroopGiftAnimationController.this.E);
                                        } else {
                                            i3 = 0;
                                        }
                                        int dimension = (int) TroopGiftAnimationController.this.E.getResources().getDimension(R.dimen.abs);
                                        int width2 = TroopGiftAnimationController.this.E.getWindowManager().getDefaultDisplay().getWidth();
                                        int height = TroopGiftAnimationController.this.E.getWindowManager().getDefaultDisplay().getHeight() - i3;
                                        List<String> c16 = am.c(AnonymousClass5.this.f302762d);
                                        String f17 = am.f(AnonymousClass5.this.f302762d);
                                        if (AnonymousClass5.this.f302762d.animationType == 1) {
                                            strArr = null;
                                            i17 = (int) ((TroopGiftAnimationController.this.C.f243364q * ah.f307408i) / 2.0f);
                                            i18 = (int) ((TroopGiftAnimationController.this.C.f243365r * ah.f307408i) / 2.0f);
                                        } else {
                                            if (am.p(c16)) {
                                                if (QLog.isColorLevel()) {
                                                    QLog.d("TroopGiftAnimationController", 2, "filePaths null");
                                                    return;
                                                }
                                                return;
                                            }
                                            Collections.sort(c16);
                                            int size = c16.size();
                                            String[] strArr2 = new String[size];
                                            for (int i46 = 0; i46 < size; i46++) {
                                                strArr2[i46] = c16.get(i46);
                                            }
                                            try {
                                                decodeFileWithBufferedStream = BaseImageUtil.decodeFileWithBufferedStream(strArr2[0], null);
                                                width = decodeFileWithBufferedStream.getWidth();
                                            } catch (Throwable unused) {
                                                i16 = 0;
                                            }
                                            try {
                                                i17 = width;
                                                strArr = strArr2;
                                                i18 = decodeFileWithBufferedStream.getHeight();
                                            } catch (Throwable unused2) {
                                                i16 = width;
                                                i17 = i16;
                                                strArr = strArr2;
                                                i18 = 0;
                                                if (!AnonymousClass5.this.f302762d.isToAll()) {
                                                }
                                                if (activity == null) {
                                                }
                                                i26 = i19;
                                                if (!AnonymousClass5.this.f302762d.isToAll()) {
                                                }
                                            }
                                        }
                                        if (!AnonymousClass5.this.f302762d.isToAll()) {
                                            i19 = MessageStruct.MSG_VIDEOPLAYER_PLAY_BEGIN;
                                        } else {
                                            i19 = 8;
                                        }
                                        if (activity == null && (activity instanceof QQBrowserActivity)) {
                                            i26 = 24;
                                        } else {
                                            i26 = i19;
                                        }
                                        if (!AnonymousClass5.this.f302762d.isToAll()) {
                                            try {
                                                bitmap6 = BitmapFactory.decodeFile(this.f302777d + "/button/group_gift_button_background@2x.png");
                                            } catch (OutOfMemoryError unused3) {
                                                if (QLog.isColorLevel()) {
                                                    QLog.d("TroopGiftAnimationController", 2, "decode buttonBmp failed");
                                                }
                                                bitmap6 = null;
                                            }
                                            try {
                                                bitmap7 = BitmapFactory.decodeFile(this.f302777d + "/faceBG/group_gift_tip_background@2x.png");
                                            } catch (OutOfMemoryError unused4) {
                                                if (QLog.isColorLevel()) {
                                                    QLog.d("TroopGiftAnimationController", 2, "decode giftBgBmp failed");
                                                }
                                            }
                                            Bitmap bitmap8 = bitmap7;
                                            TroopGiftToAllSurfaceView.e eVar = new TroopGiftToAllSurfaceView.e();
                                            eVar.f302799a = width2;
                                            eVar.f302800b = height;
                                            float f18 = width2 / i17;
                                            float f19 = height / i18;
                                            if (f18 > f19) {
                                                eVar.f302801c = f18;
                                            } else {
                                                eVar.f302801c = f19;
                                            }
                                            eVar.f302802d = TroopGiftAnimationController.this.C.f243371x;
                                            eVar.f302806h = TroopGiftAnimationController.this.C.A;
                                            eVar.f302803e = TroopGiftAnimationController.this.C.f243372y;
                                            eVar.f302805g = TroopGiftAnimationController.this.C.f243366s;
                                            eVar.f302807i = TroopGiftAnimationController.this.C.C;
                                            AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                                            eVar.f302808j = anonymousClass5.f302762d.senderName;
                                            eVar.f302809k = TroopGiftAnimationController.this.C.F;
                                            eVar.f302804f = TroopGiftAnimationController.this.C.f243373z;
                                            eVar.f302810l = 20;
                                            a aVar = new a();
                                            AnonymousClass5 anonymousClass52 = AnonymousClass5.this;
                                            if (anonymousClass52.f302762d.animationType == 1) {
                                                ((TroopGiftToAllSurfaceView) TroopGiftAnimationController.this.f302752d).E(bitmap8, this.f302778e, bitmap6, f17, aVar, eVar);
                                            } else {
                                                ((TroopGiftToAllSurfaceView) TroopGiftAnimationController.this.f302752d).F(bitmap8, this.f302778e, bitmap6, strArr, aVar, eVar);
                                            }
                                            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -1, 2, i26, -2);
                                            layoutParams.gravity = 51;
                                            try {
                                                TroopGiftAnimationController.this.F.removeViewImmediate(TroopGiftAnimationController.this.f302753e);
                                            } catch (Exception unused5) {
                                            }
                                            TroopGiftAnimationController.this.F.addView(TroopGiftAnimationController.this.f302753e, layoutParams);
                                            TroopGiftAnimationController.this.f302752d.setVisibility(0);
                                            TroopGiftAnimationController troopGiftAnimationController3 = TroopGiftAnimationController.this;
                                            troopGiftAnimationController3.y(0, troopGiftAnimationController3.C);
                                            return;
                                        }
                                        AnonymousClass5 anonymousClass53 = AnonymousClass5.this;
                                        TroopGiftToPersonalSurfaceView troopGiftToPersonalSurfaceView = (TroopGiftToPersonalSurfaceView) TroopGiftAnimationController.this.f302752d;
                                        if (anonymousClass53.f302762d.animationType == 1) {
                                            i36 = 51;
                                            i27 = i18;
                                            i29 = height;
                                            troopGiftToPersonalSurfaceView.setResourceWithFps(this.f302778e, this.f302779f, this.f302780h, f17, width2, i29);
                                            i28 = i17;
                                        } else {
                                            i27 = i18;
                                            i28 = i17;
                                            i29 = height;
                                            i36 = 51;
                                            troopGiftToPersonalSurfaceView.setResourceWithFps(this.f302778e, this.f302779f, this.f302780h, strArr, 20);
                                        }
                                        if (i28 != 0 && i27 != 0) {
                                            if (TroopGiftAnimationController.this.C.f243364q != 0 && TroopGiftAnimationController.this.C.f243365r != 0) {
                                                i37 = i29;
                                            } else {
                                                TroopGiftAnimationController.this.C.f243364q = width2;
                                                i37 = i29;
                                                TroopGiftAnimationController.this.C.f243365r = i37 - dimension;
                                            }
                                            int i47 = (i27 * width2) / i28;
                                            if (i47 > i37) {
                                                i38 = (width2 * i37) / i47;
                                                i47 = i37;
                                            } else {
                                                i38 = width2;
                                            }
                                            int i48 = ((TroopGiftAnimationController.this.C.f243367t * i37) / 100) - (i47 / 2);
                                            if (i48 < 0) {
                                                i48 = 0;
                                            } else if (i48 + i47 > i37) {
                                                i48 = i37 - i47;
                                            }
                                            int i49 = (width2 - i38) / 2;
                                            int i56 = (TroopGiftAnimationController.this.C.f243366s * i47) / 100;
                                            int c17 = x.c(TroopGiftAnimationController.this.E, 35.0f) + i56 + x.c(TroopGiftAnimationController.this.E, 20.0f);
                                            int i57 = dimension + c17;
                                            if (i57 > i47 && i57 < i37) {
                                                i47 = i57;
                                            }
                                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) TroopGiftAnimationController.this.f302752d.getLayoutParams();
                                            layoutParams2.width = i38;
                                            layoutParams2.height = i47;
                                            layoutParams2.leftMargin = i49;
                                            TroopGiftAnimationController.this.f302752d.setLayoutParams(layoutParams2);
                                            WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(-1, i47, 2, i26, -2);
                                            layoutParams3.gravity = i36;
                                            layoutParams3.x = 0;
                                            layoutParams3.y = i3 + i48;
                                            int c18 = ((i37 / 4) - i48) - x.c(TroopGiftAnimationController.this.E, 30.0f);
                                            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) TroopGiftAnimationController.this.f302754f.getLayoutParams();
                                            layoutParams4.topMargin = c18;
                                            TroopGiftAnimationController.this.f302754f.setLayoutParams(layoutParams4);
                                            if (!TroopGiftAnimationController.this.K.showCloseBtn) {
                                                TroopGiftAnimationController.this.f302754f.setVisibility(8);
                                            }
                                            try {
                                                TroopGiftAnimationController.this.F.removeViewImmediate(TroopGiftAnimationController.this.f302753e);
                                            } catch (Exception unused6) {
                                            }
                                            TroopGiftAnimationController.this.F.addView(TroopGiftAnimationController.this.f302753e, layoutParams3);
                                            if (AnonymousClass5.this.f302762d.animationType == 1) {
                                                z16 = true;
                                            } else {
                                                z16 = false;
                                            }
                                            float f26 = (float) ((i38 * 1.0d) / i28);
                                            if (z16) {
                                                f16 = ah.f307408i / 2.0f;
                                            } else {
                                                f16 = 1.0f;
                                            }
                                            troopGiftToPersonalSurfaceView.setHeadPositionY(i38, i47, f26 * f16, i56, z16);
                                            if (QLog.isColorLevel()) {
                                                QLog.d("TroopGiftAnimationController", 2, "gnerate state ,realWidth:" + i38 + ",realHeight:" + i47);
                                            }
                                            TroopGiftAnimationController troopGiftAnimationController4 = TroopGiftAnimationController.this;
                                            troopGiftAnimationController4.y(c17, troopGiftAnimationController4.C);
                                            return;
                                        }
                                        if (QLog.isColorLevel()) {
                                            QLog.d("TroopGiftAnimationController", 2, "originX=0 or originY=0");
                                        }
                                        if (TroopGiftAnimationController.this.H != null) {
                                            TroopGiftAnimationController.this.H.a();
                                            TroopGiftAnimationController.this.H = null;
                                            return;
                                        }
                                        return;
                                    }
                                    if (QLog.isColorLevel()) {
                                        QLog.d("TroopGiftAnimationController", 2, "chatFragment not chat");
                                        return;
                                    }
                                    return;
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.d("TroopGiftAnimationController", 2, "SendFlowerSurfaceView null or gone");
                                }
                            }
                        }, 300L);
                    }
                    bitmap4 = bitmap;
                    bitmap3 = null;
                    String d162 = am.d(this.f302762d);
                    bitmap5 = BitmapFactory.decodeFile(d162 + "/avatar/avatar_anim_res.png");
                    TroopGiftAnimationController.this.G.postDelayed(new Runnable(d162, bitmap4, bitmap3, bitmap5) { // from class: com.tencent.mobileqq.troopgift.TroopGiftAnimationController.5.5
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ String f302777d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ Bitmap f302778e;

                        /* renamed from: f, reason: collision with root package name */
                        final /* synthetic */ Bitmap f302779f;

                        /* renamed from: h, reason: collision with root package name */
                        final /* synthetic */ Bitmap f302780h;

                        /* compiled from: P */
                        /* renamed from: com.tencent.mobileqq.troopgift.TroopGiftAnimationController$5$5$a */
                        /* loaded from: classes19.dex */
                        class a implements a.InterfaceC8634a {
                            static IPatchRedirector $redirector_;

                            a() {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) RunnableC88405.this);
                                }
                            }

                            @Override // com.tencent.mobileqq.surfaceviewaction.gl.a.InterfaceC8634a
                            public void a(com.tencent.mobileqq.surfaceviewaction.gl.e eVar) {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                                } else {
                                    TroopGiftAnimationController.this.n();
                                }
                            }
                        }

                        {
                            this.f302777d = d162;
                            this.f302778e = bitmap4;
                            this.f302779f = bitmap3;
                            this.f302780h = bitmap5;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, AnonymousClass5.this, d162, bitmap4, bitmap3, bitmap5);
                            }
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:34:0x0118, code lost:
                        
                            if (r1.getCurrentWebViewFragment().isActivityResume() == false) goto L44;
                         */
                        /* JADX WARN: Removed duplicated region for block: B:104:0x022e A[EXC_TOP_SPLITTER, SYNTHETIC] */
                        /* JADX WARN: Removed duplicated region for block: B:134:0x0212  */
                        /* JADX WARN: Removed duplicated region for block: B:43:0x020e  */
                        /* JADX WARN: Removed duplicated region for block: B:50:0x0373  */
                        @Override // java.lang.Runnable
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public void run() {
                            Activity activity;
                            int i3;
                            int i16;
                            int i17;
                            String[] strArr;
                            int i18;
                            Bitmap decodeFileWithBufferedStream;
                            int width;
                            int i19;
                            int i26;
                            Bitmap bitmap6;
                            int i27;
                            int i28;
                            int i29;
                            int i36;
                            int i37;
                            int i38;
                            boolean z16;
                            float f16;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            SpriteGLView spriteGLView = TroopGiftAnimationController.this.f302752d;
                            if (spriteGLView != null && spriteGLView.getVisibility() != 8 && !TroopGiftAnimationController.this.E.isFinishing()) {
                                String packageName = TroopGiftAnimationController.this.E.getApplicationContext().getPackageName();
                                Bitmap bitmap7 = null;
                                if (TroopGiftAnimationController.this.E instanceof SplashActivity) {
                                    activity = TroopGiftAnimationController.this.E;
                                } else if (TroopGiftAnimationController.this.E instanceof BasePluginActivity) {
                                    activity = ((BasePluginActivity) TroopGiftAnimationController.this.E).getOutActivity();
                                    int i39 = TroopGiftAnimationController.this.N;
                                    if (i39 == 2) {
                                        packageName = packageName + ":groupvideo";
                                    } else if (i39 == 20) {
                                        packageName = packageName + ":nearby_video";
                                    }
                                } else if (TroopGiftAnimationController.this.E instanceof QQBrowserActivity) {
                                    packageName = packageName + ":tool";
                                    activity = TroopGiftAnimationController.this.E;
                                } else {
                                    activity = null;
                                }
                                if ((activity == null || cl.b(activity, packageName)) && (!(activity instanceof SplashActivity) || SplashActivity.currentFragment == 2)) {
                                    if (activity instanceof u) {
                                        u uVar = (u) activity;
                                        if (uVar.getCurrentWebViewFragment() != null) {
                                        }
                                    }
                                    if (!AnonymousClass5.this.f302762d.isToAll()) {
                                        i3 = TroopGiftAnimationController.q(TroopGiftAnimationController.this.E);
                                    } else {
                                        i3 = 0;
                                    }
                                    int dimension = (int) TroopGiftAnimationController.this.E.getResources().getDimension(R.dimen.abs);
                                    int width2 = TroopGiftAnimationController.this.E.getWindowManager().getDefaultDisplay().getWidth();
                                    int height = TroopGiftAnimationController.this.E.getWindowManager().getDefaultDisplay().getHeight() - i3;
                                    List<String> c16 = am.c(AnonymousClass5.this.f302762d);
                                    String f17 = am.f(AnonymousClass5.this.f302762d);
                                    if (AnonymousClass5.this.f302762d.animationType == 1) {
                                        strArr = null;
                                        i17 = (int) ((TroopGiftAnimationController.this.C.f243364q * ah.f307408i) / 2.0f);
                                        i18 = (int) ((TroopGiftAnimationController.this.C.f243365r * ah.f307408i) / 2.0f);
                                    } else {
                                        if (am.p(c16)) {
                                            if (QLog.isColorLevel()) {
                                                QLog.d("TroopGiftAnimationController", 2, "filePaths null");
                                                return;
                                            }
                                            return;
                                        }
                                        Collections.sort(c16);
                                        int size = c16.size();
                                        String[] strArr2 = new String[size];
                                        for (int i46 = 0; i46 < size; i46++) {
                                            strArr2[i46] = c16.get(i46);
                                        }
                                        try {
                                            decodeFileWithBufferedStream = BaseImageUtil.decodeFileWithBufferedStream(strArr2[0], null);
                                            width = decodeFileWithBufferedStream.getWidth();
                                        } catch (Throwable unused) {
                                            i16 = 0;
                                        }
                                        try {
                                            i17 = width;
                                            strArr = strArr2;
                                            i18 = decodeFileWithBufferedStream.getHeight();
                                        } catch (Throwable unused2) {
                                            i16 = width;
                                            i17 = i16;
                                            strArr = strArr2;
                                            i18 = 0;
                                            if (!AnonymousClass5.this.f302762d.isToAll()) {
                                            }
                                            if (activity == null) {
                                            }
                                            i26 = i19;
                                            if (!AnonymousClass5.this.f302762d.isToAll()) {
                                            }
                                        }
                                    }
                                    if (!AnonymousClass5.this.f302762d.isToAll()) {
                                        i19 = MessageStruct.MSG_VIDEOPLAYER_PLAY_BEGIN;
                                    } else {
                                        i19 = 8;
                                    }
                                    if (activity == null && (activity instanceof QQBrowserActivity)) {
                                        i26 = 24;
                                    } else {
                                        i26 = i19;
                                    }
                                    if (!AnonymousClass5.this.f302762d.isToAll()) {
                                        try {
                                            bitmap6 = BitmapFactory.decodeFile(this.f302777d + "/button/group_gift_button_background@2x.png");
                                        } catch (OutOfMemoryError unused3) {
                                            if (QLog.isColorLevel()) {
                                                QLog.d("TroopGiftAnimationController", 2, "decode buttonBmp failed");
                                            }
                                            bitmap6 = null;
                                        }
                                        try {
                                            bitmap7 = BitmapFactory.decodeFile(this.f302777d + "/faceBG/group_gift_tip_background@2x.png");
                                        } catch (OutOfMemoryError unused4) {
                                            if (QLog.isColorLevel()) {
                                                QLog.d("TroopGiftAnimationController", 2, "decode giftBgBmp failed");
                                            }
                                        }
                                        Bitmap bitmap8 = bitmap7;
                                        TroopGiftToAllSurfaceView.e eVar = new TroopGiftToAllSurfaceView.e();
                                        eVar.f302799a = width2;
                                        eVar.f302800b = height;
                                        float f18 = width2 / i17;
                                        float f19 = height / i18;
                                        if (f18 > f19) {
                                            eVar.f302801c = f18;
                                        } else {
                                            eVar.f302801c = f19;
                                        }
                                        eVar.f302802d = TroopGiftAnimationController.this.C.f243371x;
                                        eVar.f302806h = TroopGiftAnimationController.this.C.A;
                                        eVar.f302803e = TroopGiftAnimationController.this.C.f243372y;
                                        eVar.f302805g = TroopGiftAnimationController.this.C.f243366s;
                                        eVar.f302807i = TroopGiftAnimationController.this.C.C;
                                        AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                                        eVar.f302808j = anonymousClass5.f302762d.senderName;
                                        eVar.f302809k = TroopGiftAnimationController.this.C.F;
                                        eVar.f302804f = TroopGiftAnimationController.this.C.f243373z;
                                        eVar.f302810l = 20;
                                        a aVar = new a();
                                        AnonymousClass5 anonymousClass52 = AnonymousClass5.this;
                                        if (anonymousClass52.f302762d.animationType == 1) {
                                            ((TroopGiftToAllSurfaceView) TroopGiftAnimationController.this.f302752d).E(bitmap8, this.f302778e, bitmap6, f17, aVar, eVar);
                                        } else {
                                            ((TroopGiftToAllSurfaceView) TroopGiftAnimationController.this.f302752d).F(bitmap8, this.f302778e, bitmap6, strArr, aVar, eVar);
                                        }
                                        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -1, 2, i26, -2);
                                        layoutParams.gravity = 51;
                                        try {
                                            TroopGiftAnimationController.this.F.removeViewImmediate(TroopGiftAnimationController.this.f302753e);
                                        } catch (Exception unused5) {
                                        }
                                        TroopGiftAnimationController.this.F.addView(TroopGiftAnimationController.this.f302753e, layoutParams);
                                        TroopGiftAnimationController.this.f302752d.setVisibility(0);
                                        TroopGiftAnimationController troopGiftAnimationController3 = TroopGiftAnimationController.this;
                                        troopGiftAnimationController3.y(0, troopGiftAnimationController3.C);
                                        return;
                                    }
                                    AnonymousClass5 anonymousClass53 = AnonymousClass5.this;
                                    TroopGiftToPersonalSurfaceView troopGiftToPersonalSurfaceView = (TroopGiftToPersonalSurfaceView) TroopGiftAnimationController.this.f302752d;
                                    if (anonymousClass53.f302762d.animationType == 1) {
                                        i36 = 51;
                                        i27 = i18;
                                        i29 = height;
                                        troopGiftToPersonalSurfaceView.setResourceWithFps(this.f302778e, this.f302779f, this.f302780h, f17, width2, i29);
                                        i28 = i17;
                                    } else {
                                        i27 = i18;
                                        i28 = i17;
                                        i29 = height;
                                        i36 = 51;
                                        troopGiftToPersonalSurfaceView.setResourceWithFps(this.f302778e, this.f302779f, this.f302780h, strArr, 20);
                                    }
                                    if (i28 != 0 && i27 != 0) {
                                        if (TroopGiftAnimationController.this.C.f243364q != 0 && TroopGiftAnimationController.this.C.f243365r != 0) {
                                            i37 = i29;
                                        } else {
                                            TroopGiftAnimationController.this.C.f243364q = width2;
                                            i37 = i29;
                                            TroopGiftAnimationController.this.C.f243365r = i37 - dimension;
                                        }
                                        int i47 = (i27 * width2) / i28;
                                        if (i47 > i37) {
                                            i38 = (width2 * i37) / i47;
                                            i47 = i37;
                                        } else {
                                            i38 = width2;
                                        }
                                        int i48 = ((TroopGiftAnimationController.this.C.f243367t * i37) / 100) - (i47 / 2);
                                        if (i48 < 0) {
                                            i48 = 0;
                                        } else if (i48 + i47 > i37) {
                                            i48 = i37 - i47;
                                        }
                                        int i49 = (width2 - i38) / 2;
                                        int i56 = (TroopGiftAnimationController.this.C.f243366s * i47) / 100;
                                        int c17 = x.c(TroopGiftAnimationController.this.E, 35.0f) + i56 + x.c(TroopGiftAnimationController.this.E, 20.0f);
                                        int i57 = dimension + c17;
                                        if (i57 > i47 && i57 < i37) {
                                            i47 = i57;
                                        }
                                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) TroopGiftAnimationController.this.f302752d.getLayoutParams();
                                        layoutParams2.width = i38;
                                        layoutParams2.height = i47;
                                        layoutParams2.leftMargin = i49;
                                        TroopGiftAnimationController.this.f302752d.setLayoutParams(layoutParams2);
                                        WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(-1, i47, 2, i26, -2);
                                        layoutParams3.gravity = i36;
                                        layoutParams3.x = 0;
                                        layoutParams3.y = i3 + i48;
                                        int c18 = ((i37 / 4) - i48) - x.c(TroopGiftAnimationController.this.E, 30.0f);
                                        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) TroopGiftAnimationController.this.f302754f.getLayoutParams();
                                        layoutParams4.topMargin = c18;
                                        TroopGiftAnimationController.this.f302754f.setLayoutParams(layoutParams4);
                                        if (!TroopGiftAnimationController.this.K.showCloseBtn) {
                                            TroopGiftAnimationController.this.f302754f.setVisibility(8);
                                        }
                                        try {
                                            TroopGiftAnimationController.this.F.removeViewImmediate(TroopGiftAnimationController.this.f302753e);
                                        } catch (Exception unused6) {
                                        }
                                        TroopGiftAnimationController.this.F.addView(TroopGiftAnimationController.this.f302753e, layoutParams3);
                                        if (AnonymousClass5.this.f302762d.animationType == 1) {
                                            z16 = true;
                                        } else {
                                            z16 = false;
                                        }
                                        float f26 = (float) ((i38 * 1.0d) / i28);
                                        if (z16) {
                                            f16 = ah.f307408i / 2.0f;
                                        } else {
                                            f16 = 1.0f;
                                        }
                                        troopGiftToPersonalSurfaceView.setHeadPositionY(i38, i47, f26 * f16, i56, z16);
                                        if (QLog.isColorLevel()) {
                                            QLog.d("TroopGiftAnimationController", 2, "gnerate state ,realWidth:" + i38 + ",realHeight:" + i47);
                                        }
                                        TroopGiftAnimationController troopGiftAnimationController4 = TroopGiftAnimationController.this;
                                        troopGiftAnimationController4.y(c17, troopGiftAnimationController4.C);
                                        return;
                                    }
                                    if (QLog.isColorLevel()) {
                                        QLog.d("TroopGiftAnimationController", 2, "originX=0 or originY=0");
                                    }
                                    if (TroopGiftAnimationController.this.H != null) {
                                        TroopGiftAnimationController.this.H.a();
                                        TroopGiftAnimationController.this.H = null;
                                        return;
                                    }
                                    return;
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.d("TroopGiftAnimationController", 2, "chatFragment not chat");
                                    return;
                                }
                                return;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("TroopGiftAnimationController", 2, "SendFlowerSurfaceView null or gone");
                            }
                        }
                    }, 300L);
                }
            }
            if (bitmap == null) {
                bitmap = BaseImageUtil.getDefaultFaceBitmap();
            }
            if (bitmap2 == null) {
                bitmap2 = BaseImageUtil.getDefaultFaceBitmap();
            }
            bitmap4 = bitmap;
            bitmap3 = bitmap2;
            String d1622 = am.d(this.f302762d);
            bitmap5 = BitmapFactory.decodeFile(d1622 + "/avatar/avatar_anim_res.png");
            TroopGiftAnimationController.this.G.postDelayed(new Runnable(d1622, bitmap4, bitmap3, bitmap5) { // from class: com.tencent.mobileqq.troopgift.TroopGiftAnimationController.5.5
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f302777d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ Bitmap f302778e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ Bitmap f302779f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ Bitmap f302780h;

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.troopgift.TroopGiftAnimationController$5$5$a */
                /* loaded from: classes19.dex */
                class a implements a.InterfaceC8634a {
                    static IPatchRedirector $redirector_;

                    a() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) RunnableC88405.this);
                        }
                    }

                    @Override // com.tencent.mobileqq.surfaceviewaction.gl.a.InterfaceC8634a
                    public void a(com.tencent.mobileqq.surfaceviewaction.gl.e eVar) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                        } else {
                            TroopGiftAnimationController.this.n();
                        }
                    }
                }

                {
                    this.f302777d = d1622;
                    this.f302778e = bitmap4;
                    this.f302779f = bitmap3;
                    this.f302780h = bitmap5;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, AnonymousClass5.this, d1622, bitmap4, bitmap3, bitmap5);
                    }
                }

                /* JADX WARN: Code restructure failed: missing block: B:34:0x0118, code lost:
                
                    if (r1.getCurrentWebViewFragment().isActivityResume() == false) goto L44;
                 */
                /* JADX WARN: Removed duplicated region for block: B:104:0x022e A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:134:0x0212  */
                /* JADX WARN: Removed duplicated region for block: B:43:0x020e  */
                /* JADX WARN: Removed duplicated region for block: B:50:0x0373  */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    Activity activity;
                    int i3;
                    int i16;
                    int i17;
                    String[] strArr;
                    int i18;
                    Bitmap decodeFileWithBufferedStream;
                    int width;
                    int i19;
                    int i26;
                    Bitmap bitmap6;
                    int i27;
                    int i28;
                    int i29;
                    int i36;
                    int i37;
                    int i38;
                    boolean z16;
                    float f16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    SpriteGLView spriteGLView = TroopGiftAnimationController.this.f302752d;
                    if (spriteGLView != null && spriteGLView.getVisibility() != 8 && !TroopGiftAnimationController.this.E.isFinishing()) {
                        String packageName = TroopGiftAnimationController.this.E.getApplicationContext().getPackageName();
                        Bitmap bitmap7 = null;
                        if (TroopGiftAnimationController.this.E instanceof SplashActivity) {
                            activity = TroopGiftAnimationController.this.E;
                        } else if (TroopGiftAnimationController.this.E instanceof BasePluginActivity) {
                            activity = ((BasePluginActivity) TroopGiftAnimationController.this.E).getOutActivity();
                            int i39 = TroopGiftAnimationController.this.N;
                            if (i39 == 2) {
                                packageName = packageName + ":groupvideo";
                            } else if (i39 == 20) {
                                packageName = packageName + ":nearby_video";
                            }
                        } else if (TroopGiftAnimationController.this.E instanceof QQBrowserActivity) {
                            packageName = packageName + ":tool";
                            activity = TroopGiftAnimationController.this.E;
                        } else {
                            activity = null;
                        }
                        if ((activity == null || cl.b(activity, packageName)) && (!(activity instanceof SplashActivity) || SplashActivity.currentFragment == 2)) {
                            if (activity instanceof u) {
                                u uVar = (u) activity;
                                if (uVar.getCurrentWebViewFragment() != null) {
                                }
                            }
                            if (!AnonymousClass5.this.f302762d.isToAll()) {
                                i3 = TroopGiftAnimationController.q(TroopGiftAnimationController.this.E);
                            } else {
                                i3 = 0;
                            }
                            int dimension = (int) TroopGiftAnimationController.this.E.getResources().getDimension(R.dimen.abs);
                            int width2 = TroopGiftAnimationController.this.E.getWindowManager().getDefaultDisplay().getWidth();
                            int height = TroopGiftAnimationController.this.E.getWindowManager().getDefaultDisplay().getHeight() - i3;
                            List<String> c16 = am.c(AnonymousClass5.this.f302762d);
                            String f17 = am.f(AnonymousClass5.this.f302762d);
                            if (AnonymousClass5.this.f302762d.animationType == 1) {
                                strArr = null;
                                i17 = (int) ((TroopGiftAnimationController.this.C.f243364q * ah.f307408i) / 2.0f);
                                i18 = (int) ((TroopGiftAnimationController.this.C.f243365r * ah.f307408i) / 2.0f);
                            } else {
                                if (am.p(c16)) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d("TroopGiftAnimationController", 2, "filePaths null");
                                        return;
                                    }
                                    return;
                                }
                                Collections.sort(c16);
                                int size = c16.size();
                                String[] strArr2 = new String[size];
                                for (int i46 = 0; i46 < size; i46++) {
                                    strArr2[i46] = c16.get(i46);
                                }
                                try {
                                    decodeFileWithBufferedStream = BaseImageUtil.decodeFileWithBufferedStream(strArr2[0], null);
                                    width = decodeFileWithBufferedStream.getWidth();
                                } catch (Throwable unused) {
                                    i16 = 0;
                                }
                                try {
                                    i17 = width;
                                    strArr = strArr2;
                                    i18 = decodeFileWithBufferedStream.getHeight();
                                } catch (Throwable unused2) {
                                    i16 = width;
                                    i17 = i16;
                                    strArr = strArr2;
                                    i18 = 0;
                                    if (!AnonymousClass5.this.f302762d.isToAll()) {
                                    }
                                    if (activity == null) {
                                    }
                                    i26 = i19;
                                    if (!AnonymousClass5.this.f302762d.isToAll()) {
                                    }
                                }
                            }
                            if (!AnonymousClass5.this.f302762d.isToAll()) {
                                i19 = MessageStruct.MSG_VIDEOPLAYER_PLAY_BEGIN;
                            } else {
                                i19 = 8;
                            }
                            if (activity == null && (activity instanceof QQBrowserActivity)) {
                                i26 = 24;
                            } else {
                                i26 = i19;
                            }
                            if (!AnonymousClass5.this.f302762d.isToAll()) {
                                try {
                                    bitmap6 = BitmapFactory.decodeFile(this.f302777d + "/button/group_gift_button_background@2x.png");
                                } catch (OutOfMemoryError unused3) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d("TroopGiftAnimationController", 2, "decode buttonBmp failed");
                                    }
                                    bitmap6 = null;
                                }
                                try {
                                    bitmap7 = BitmapFactory.decodeFile(this.f302777d + "/faceBG/group_gift_tip_background@2x.png");
                                } catch (OutOfMemoryError unused4) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d("TroopGiftAnimationController", 2, "decode giftBgBmp failed");
                                    }
                                }
                                Bitmap bitmap8 = bitmap7;
                                TroopGiftToAllSurfaceView.e eVar = new TroopGiftToAllSurfaceView.e();
                                eVar.f302799a = width2;
                                eVar.f302800b = height;
                                float f18 = width2 / i17;
                                float f19 = height / i18;
                                if (f18 > f19) {
                                    eVar.f302801c = f18;
                                } else {
                                    eVar.f302801c = f19;
                                }
                                eVar.f302802d = TroopGiftAnimationController.this.C.f243371x;
                                eVar.f302806h = TroopGiftAnimationController.this.C.A;
                                eVar.f302803e = TroopGiftAnimationController.this.C.f243372y;
                                eVar.f302805g = TroopGiftAnimationController.this.C.f243366s;
                                eVar.f302807i = TroopGiftAnimationController.this.C.C;
                                AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                                eVar.f302808j = anonymousClass5.f302762d.senderName;
                                eVar.f302809k = TroopGiftAnimationController.this.C.F;
                                eVar.f302804f = TroopGiftAnimationController.this.C.f243373z;
                                eVar.f302810l = 20;
                                a aVar = new a();
                                AnonymousClass5 anonymousClass52 = AnonymousClass5.this;
                                if (anonymousClass52.f302762d.animationType == 1) {
                                    ((TroopGiftToAllSurfaceView) TroopGiftAnimationController.this.f302752d).E(bitmap8, this.f302778e, bitmap6, f17, aVar, eVar);
                                } else {
                                    ((TroopGiftToAllSurfaceView) TroopGiftAnimationController.this.f302752d).F(bitmap8, this.f302778e, bitmap6, strArr, aVar, eVar);
                                }
                                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -1, 2, i26, -2);
                                layoutParams.gravity = 51;
                                try {
                                    TroopGiftAnimationController.this.F.removeViewImmediate(TroopGiftAnimationController.this.f302753e);
                                } catch (Exception unused5) {
                                }
                                TroopGiftAnimationController.this.F.addView(TroopGiftAnimationController.this.f302753e, layoutParams);
                                TroopGiftAnimationController.this.f302752d.setVisibility(0);
                                TroopGiftAnimationController troopGiftAnimationController3 = TroopGiftAnimationController.this;
                                troopGiftAnimationController3.y(0, troopGiftAnimationController3.C);
                                return;
                            }
                            AnonymousClass5 anonymousClass53 = AnonymousClass5.this;
                            TroopGiftToPersonalSurfaceView troopGiftToPersonalSurfaceView = (TroopGiftToPersonalSurfaceView) TroopGiftAnimationController.this.f302752d;
                            if (anonymousClass53.f302762d.animationType == 1) {
                                i36 = 51;
                                i27 = i18;
                                i29 = height;
                                troopGiftToPersonalSurfaceView.setResourceWithFps(this.f302778e, this.f302779f, this.f302780h, f17, width2, i29);
                                i28 = i17;
                            } else {
                                i27 = i18;
                                i28 = i17;
                                i29 = height;
                                i36 = 51;
                                troopGiftToPersonalSurfaceView.setResourceWithFps(this.f302778e, this.f302779f, this.f302780h, strArr, 20);
                            }
                            if (i28 != 0 && i27 != 0) {
                                if (TroopGiftAnimationController.this.C.f243364q != 0 && TroopGiftAnimationController.this.C.f243365r != 0) {
                                    i37 = i29;
                                } else {
                                    TroopGiftAnimationController.this.C.f243364q = width2;
                                    i37 = i29;
                                    TroopGiftAnimationController.this.C.f243365r = i37 - dimension;
                                }
                                int i47 = (i27 * width2) / i28;
                                if (i47 > i37) {
                                    i38 = (width2 * i37) / i47;
                                    i47 = i37;
                                } else {
                                    i38 = width2;
                                }
                                int i48 = ((TroopGiftAnimationController.this.C.f243367t * i37) / 100) - (i47 / 2);
                                if (i48 < 0) {
                                    i48 = 0;
                                } else if (i48 + i47 > i37) {
                                    i48 = i37 - i47;
                                }
                                int i49 = (width2 - i38) / 2;
                                int i56 = (TroopGiftAnimationController.this.C.f243366s * i47) / 100;
                                int c17 = x.c(TroopGiftAnimationController.this.E, 35.0f) + i56 + x.c(TroopGiftAnimationController.this.E, 20.0f);
                                int i57 = dimension + c17;
                                if (i57 > i47 && i57 < i37) {
                                    i47 = i57;
                                }
                                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) TroopGiftAnimationController.this.f302752d.getLayoutParams();
                                layoutParams2.width = i38;
                                layoutParams2.height = i47;
                                layoutParams2.leftMargin = i49;
                                TroopGiftAnimationController.this.f302752d.setLayoutParams(layoutParams2);
                                WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(-1, i47, 2, i26, -2);
                                layoutParams3.gravity = i36;
                                layoutParams3.x = 0;
                                layoutParams3.y = i3 + i48;
                                int c18 = ((i37 / 4) - i48) - x.c(TroopGiftAnimationController.this.E, 30.0f);
                                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) TroopGiftAnimationController.this.f302754f.getLayoutParams();
                                layoutParams4.topMargin = c18;
                                TroopGiftAnimationController.this.f302754f.setLayoutParams(layoutParams4);
                                if (!TroopGiftAnimationController.this.K.showCloseBtn) {
                                    TroopGiftAnimationController.this.f302754f.setVisibility(8);
                                }
                                try {
                                    TroopGiftAnimationController.this.F.removeViewImmediate(TroopGiftAnimationController.this.f302753e);
                                } catch (Exception unused6) {
                                }
                                TroopGiftAnimationController.this.F.addView(TroopGiftAnimationController.this.f302753e, layoutParams3);
                                if (AnonymousClass5.this.f302762d.animationType == 1) {
                                    z16 = true;
                                } else {
                                    z16 = false;
                                }
                                float f26 = (float) ((i38 * 1.0d) / i28);
                                if (z16) {
                                    f16 = ah.f307408i / 2.0f;
                                } else {
                                    f16 = 1.0f;
                                }
                                troopGiftToPersonalSurfaceView.setHeadPositionY(i38, i47, f26 * f16, i56, z16);
                                if (QLog.isColorLevel()) {
                                    QLog.d("TroopGiftAnimationController", 2, "gnerate state ,realWidth:" + i38 + ",realHeight:" + i47);
                                }
                                TroopGiftAnimationController troopGiftAnimationController4 = TroopGiftAnimationController.this;
                                troopGiftAnimationController4.y(c17, troopGiftAnimationController4.C);
                                return;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("TroopGiftAnimationController", 2, "originX=0 or originY=0");
                            }
                            if (TroopGiftAnimationController.this.H != null) {
                                TroopGiftAnimationController.this.H.a();
                                TroopGiftAnimationController.this.H = null;
                                return;
                            }
                            return;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("TroopGiftAnimationController", 2, "chatFragment not chat");
                            return;
                        }
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopGiftAnimationController", 2, "SendFlowerSurfaceView null or gone");
                    }
                }
            }, 300L);
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a extends ak {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopGiftAnimationController.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.utils.ak
        public void a(int i3, String str) {
            String string;
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
                return;
            }
            SpriteGLView spriteGLView = TroopGiftAnimationController.this.f302752d;
            if (spriteGLView == null) {
                return;
            }
            synchronized (spriteGLView) {
                if (TroopGiftAnimationController.this.Q != null) {
                    TroopGiftAnimationController troopGiftAnimationController = TroopGiftAnimationController.this;
                    if (troopGiftAnimationController.f302752d != null) {
                        if (i3 == 20005) {
                            troopGiftAnimationController.Q.f302785a = 3;
                            al alVar = (al) ((AppInterface) BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.TROOP_GIFT_MANAGER);
                            TroopGiftAnimationController troopGiftAnimationController2 = TroopGiftAnimationController.this;
                            int i16 = troopGiftAnimationController2.N;
                            if (i16 > 3) {
                                alVar.f("OidbSvc.0x7f7", 2039, i16, troopGiftAnimationController2.K.frienduin, TroopGiftAnimationController.this.K.bagId, 3000L, TroopGiftAnimationController.this.R);
                            } else {
                                alVar.f("OidbSvc.0x6b5", 1717, i16, troopGiftAnimationController2.K.frienduin, TroopGiftAnimationController.this.K.bagId, 3000L, TroopGiftAnimationController.this.R);
                            }
                        } else {
                            if (i3 == -1) {
                                string = troopGiftAnimationController.E.getResources().getString(R.string.evd);
                                String str3 = AppConstants.NET_TYPE_NAME[NetworkUtil.getSystemNetwork(TroopGiftAnimationController.this.E)];
                                TroopGiftAnimationController troopGiftAnimationController3 = TroopGiftAnimationController.this;
                                if (troopGiftAnimationController3.N >= 4) {
                                    NearbyFlowerManager.c("cartoon", "timeout", troopGiftAnimationController3.K.frienduin, am.i(TroopGiftAnimationController.this.K) + str3, "", "");
                                } else {
                                    if (troopGiftAnimationController3.D != null) {
                                        str2 = "0";
                                    } else {
                                        str2 = "1";
                                    }
                                    String str4 = "" + TroopGiftAnimationController.this.K.frienduin;
                                    ReportController.o(null, "dc00899", "Grp_flower", "", "forall", "timeout", 0, 0, str4, "" + am.i(TroopGiftAnimationController.this.K), str2, str3);
                                }
                            } else {
                                string = troopGiftAnimationController.E.getResources().getString(R.string.evc);
                            }
                            TroopGiftAnimationController troopGiftAnimationController4 = TroopGiftAnimationController.this;
                            SpriteGLView spriteGLView2 = troopGiftAnimationController4.f302752d;
                            if (spriteGLView2 instanceof TroopGiftToAllSurfaceView) {
                                ((TroopGiftToAllSurfaceView) spriteGLView2).J(string, troopGiftAnimationController4.C.E, x.c(TroopGiftAnimationController.this.E, 16.0f));
                                TroopGiftAnimationController.this.Q.f302785a = 2;
                                if (TroopGiftAnimationController.this.Q.f302788d > 0) {
                                    if (TroopGiftAnimationController.this.Q.f302787c > TroopGiftAnimationController.this.Q.f302788d + 3000) {
                                        return;
                                    }
                                    TroopGiftAnimationController troopGiftAnimationController5 = TroopGiftAnimationController.this;
                                    troopGiftAnimationController5.G.removeCallbacks(troopGiftAnimationController5.P);
                                    TroopGiftAnimationController.this.m(2000L);
                                }
                            }
                        }
                    }
                }
            }
        }

        @Override // com.tencent.mobileqq.troop.utils.ak
        public void f(long j3, long j16, int i3, int i16, String str) {
            int i17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), Integer.valueOf(i16), str);
                return;
            }
            SpriteGLView spriteGLView = TroopGiftAnimationController.this.f302752d;
            if (spriteGLView == null) {
                return;
            }
            synchronized (spriteGLView) {
                if (TroopGiftAnimationController.this.Q != null) {
                    TroopGiftAnimationController troopGiftAnimationController = TroopGiftAnimationController.this;
                    if (troopGiftAnimationController.f302752d != null) {
                        troopGiftAnimationController.Q.f302787c = NetConnInfoCenter.getServerTimeMillis();
                        TroopGiftAnimationController.this.Q.f302785a = 2;
                        if (TroopGiftAnimationController.this.Q.f302788d > 0) {
                            if (TroopGiftAnimationController.this.Q.f302787c > TroopGiftAnimationController.this.Q.f302788d + 3000) {
                                return;
                            }
                            TroopGiftAnimationController troopGiftAnimationController2 = TroopGiftAnimationController.this;
                            troopGiftAnimationController2.G.removeCallbacks(troopGiftAnimationController2.P);
                            TroopGiftAnimationController.this.m(2000L);
                        }
                        if (!TextUtils.isEmpty(str)) {
                            if (i3 > 0) {
                                i17 = TroopGiftAnimationController.this.C.D;
                            } else {
                                i17 = TroopGiftAnimationController.this.C.E;
                            }
                            TroopGiftAnimationController troopGiftAnimationController3 = TroopGiftAnimationController.this;
                            ((TroopGiftToAllSurfaceView) troopGiftAnimationController3.f302752d).J(str, i17, x.c(troopGiftAnimationController3.E, 16.0f));
                        }
                        ((TroopGiftToAllSurfaceView) TroopGiftAnimationController.this.f302752d).D();
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class b implements a.InterfaceC8634a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopGiftAnimationController.this);
            }
        }

        @Override // com.tencent.mobileqq.surfaceviewaction.gl.a.InterfaceC8634a
        public void a(com.tencent.mobileqq.surfaceviewaction.gl.e eVar) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                return;
            }
            AppInterface appInterface = (AppInterface) BaseApplicationImpl.getApplication().getRuntime();
            TroopGiftAnimationController troopGiftAnimationController = TroopGiftAnimationController.this;
            if (troopGiftAnimationController.N >= 4) {
                NearbyFlowerManager.c("cartoon", "clk_inter", troopGiftAnimationController.K.frienduin, am.i(TroopGiftAnimationController.this.K) + "", "", "");
            } else {
                if (troopGiftAnimationController.D != null) {
                    str = "0";
                } else {
                    str = "1";
                }
                String str2 = "" + TroopGiftAnimationController.this.K.frienduin;
                String str3 = "" + am.i(TroopGiftAnimationController.this.K);
                ReportController.o(null, "dc00899", "Grp_flower", "", "forall", "Clk_grab", 0, 0, str2, str3, str, "" + az.a(appInterface, appInterface.getCurrentAccountUin(), TroopGiftAnimationController.this.K.frienduin));
            }
            Activity activity = TroopGiftAnimationController.this.E;
            if (activity != null && NetworkUtil.getSystemNetwork(activity) == 0) {
                ((TroopGiftToAllSurfaceView) TroopGiftAnimationController.this.f302752d).D();
                String string = activity.getString(R.string.ers);
                TroopGiftAnimationController troopGiftAnimationController2 = TroopGiftAnimationController.this;
                ((TroopGiftToAllSurfaceView) troopGiftAnimationController2.f302752d).J(string, troopGiftAnimationController2.C.E, x.c(TroopGiftAnimationController.this.E, 16.0f));
                return;
            }
            ((TroopGiftToAllSurfaceView) TroopGiftAnimationController.this.f302752d).D();
            al alVar = (al) appInterface.getManager(QQManagerFactory.TROOP_GIFT_MANAGER);
            TroopGiftAnimationController.this.Q.f302786b = NetConnInfoCenter.getServerTimeMillis();
            TroopGiftAnimationController troopGiftAnimationController3 = TroopGiftAnimationController.this;
            int i3 = troopGiftAnimationController3.N;
            if (i3 > 3) {
                alVar.f("OidbSvc.0x7f7", 2039, i3, troopGiftAnimationController3.K.frienduin, TroopGiftAnimationController.this.K.bagId, 3000L, TroopGiftAnimationController.this.R);
            } else {
                alVar.f("OidbSvc.0x6b5", 1717, i3, troopGiftAnimationController3.K.frienduin, TroopGiftAnimationController.this.K.bagId, 3000L, TroopGiftAnimationController.this.R);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface c {
        Bitmap a(String str, String str2);
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface d {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class e implements FrameSprite.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f302785a;

        /* renamed from: b, reason: collision with root package name */
        public long f302786b;

        /* renamed from: c, reason: collision with root package name */
        public long f302787c;

        /* renamed from: d, reason: collision with root package name */
        public long f302788d;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopGiftAnimationController.this);
                return;
            }
            this.f302785a = 0;
            this.f302786b = 0L;
            this.f302787c = 0L;
            this.f302788d = 0L;
        }

        @Override // com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
            this.f302788d = serverTimeMillis;
            int i3 = this.f302785a;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            TroopGiftAnimationController.this.m(3000L);
                        }
                    } else {
                        long j3 = serverTimeMillis - this.f302787c;
                        if (j3 >= 2000) {
                            TroopGiftAnimationController.this.m(0L);
                        } else {
                            TroopGiftAnimationController.this.m(2000 - j3);
                        }
                    }
                } else {
                    TroopGiftAnimationController.this.m(3000L);
                }
            } else {
                TroopGiftAnimationController.this.m(0L);
            }
            if (QLog.isColorLevel()) {
                QLog.i(".troop.send_giftTroopGiftAnimationController", 2, "animation frame end. requestState:" + this.f302785a);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(76982);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
        } else {
            T = -1;
        }
    }

    public TroopGiftAnimationController(a61.c cVar, Activity activity, AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, cVar, activity, appInterface);
            return;
        }
        this.G = new Handler(Looper.getMainLooper());
        this.P = new AnonymousClass1();
        this.Q = null;
        this.R = new a();
        this.S = new b();
        this.D = cVar;
        this.E = activity;
    }

    public static int q(Activity activity) {
        int i3 = T;
        if (i3 >= 0) {
            return i3;
        }
        if (activity != null && activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
            Rect rect = new Rect();
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            T = rect.top;
        } else {
            T = 0;
        }
        return T;
    }

    private void r(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("TroopGiftAnimationController", 2, "initMagicfaceView begins");
        }
        if (this.f302753e == null) {
            if (z16) {
                this.f302753e = (TopGestureLayout) View.inflate(BaseApplication.getContext(), R.layout.ajz, null);
            } else {
                this.f302753e = (TopGestureLayout) View.inflate(BaseApplication.getContext(), R.layout.f168612ak0, null);
            }
            this.f302753e.setOnFlingGesture(this);
            SpriteGLView spriteGLView = (SpriteGLView) this.f302753e.findViewById(R.id.k1d);
            this.f302752d = spriteGLView;
            if (spriteGLView instanceof TroopGiftToPersonalSurfaceView) {
                ImageView imageView = (ImageView) this.f302753e.findViewById(R.id.k1b);
                this.f302754f = imageView;
                try {
                    imageView.setImageResource(R.drawable.bty);
                } catch (Exception e16) {
                    QLog.e("TroopGiftAnimationController", 2, "mStopBtn setImage failed", e16);
                }
                this.f302754f.setOnClickListener(this);
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener
    public void flingLToR() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener
    public void flingRToL() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        }
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (this.F == null) {
            this.F = (WindowManager) this.E.getSystemService("window");
        }
        SpriteGLView spriteGLView = this.f302752d;
        if (spriteGLView != null) {
            spriteGLView.u();
        }
        TopGestureLayout topGestureLayout = this.f302753e;
        if (topGestureLayout != null) {
            try {
                topGestureLayout.removeAllViews();
                this.F.removeViewImmediate(this.f302753e);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(LogTag.TAG_TROOP_SEND_GIFT, 2, "closeGiftAnimation exception ", e16);
                }
            }
            this.f302753e = null;
            this.f302752d = null;
            this.Q = null;
            this.f302754f = null;
            MessageForDeliverGiftTips messageForDeliverGiftTips = this.K;
            if (messageForDeliverGiftTips != null) {
                messageForDeliverGiftTips.hasFetchButFailed = false;
                int currentTimeMillis = (int) (System.currentTimeMillis() - this.f302756i);
                MessageForDeliverGiftTips messageForDeliverGiftTips2 = this.K;
                ReportController.o(null, "P_CliOper", "BizTechReport", "troop_gift_animation", "", "play_success", 0, currentTimeMillis, messageForDeliverGiftTips2.frienduin, am.i(messageForDeliverGiftTips2), "", "");
            }
            FrameSprite.a aVar = this.H;
            if (aVar != null) {
                aVar.a();
            }
        }
        Drawable drawable = this.L;
        if (drawable != null && (drawable instanceof FaceDrawable)) {
            ((FaceDrawable) drawable).cancel();
        }
        Drawable drawable2 = this.M;
        if (drawable2 != null && (drawable2 instanceof FaceDrawable)) {
            ((FaceDrawable) drawable2).cancel();
        } else if (drawable2 instanceof URLDrawable) {
            ((URLDrawable) drawable2).cancelDownload();
            ((URLDrawable) this.M).setDownloadListener(null);
            ((URLDrawable) this.M).setURLDrawableListener(null);
        }
        xk2.a aVar2 = this.f302755h;
        if (aVar2 != null) {
            aVar2.onDestroy();
            this.f302755h = null;
        }
    }

    public void m(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, j3);
        } else if (j3 == 0) {
            this.G.post(this.P);
        } else {
            this.G.postDelayed(this.P, j3);
        }
    }

    public void n() {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        d dVar = this.f302757m;
        if (dVar != null) {
            dVar.a();
            this.f302757m = null;
            this.H = null;
        }
        AppInterface appInterface = (AppInterface) BaseApplicationImpl.getApplication().getRuntime();
        MessageForDeliverGiftTips messageForDeliverGiftTips = this.K;
        if (messageForDeliverGiftTips != null && messageForDeliverGiftTips.isToAll()) {
            if (this.N >= 4) {
                NearbyFlowerManager.c("cartoon", "clk_close", this.K.frienduin, "", "", "");
            } else {
                if (this.D != null) {
                    str2 = "0";
                } else {
                    str2 = "1";
                }
                ReportController.o(null, "dc00899", "Grp_flower", "", "forall", "Clk_close", 0, 0, "" + this.K.frienduin, "" + am.i(this.K), str2, "" + az.a(appInterface, appInterface.getCurrentAccountUin(), this.K.frienduin));
            }
        } else if (this.K != null && this.N < 4) {
            if (this.D != null) {
                str = "0";
            } else {
                str = "1";
            }
            ReportController.o(null, "dc00899", "Grp_flower", "", "video_mall", "Clk_comctn_close", 0, 0, "" + this.K.frienduin, "" + am.i(this.K), str, "" + az.a(appInterface, appInterface.getCurrentAccountUin(), this.K.frienduin));
        }
        l();
    }

    public Activity o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (Activity) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.E;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else if (view.getId() == R.id.k1b) {
            n();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    protected Drawable p(String str, FaceDrawable.OnLoadingStateChangeListener onLoadingStateChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (Drawable) iPatchRedirector.redirect((short) 18, (Object) this, (Object) str, (Object) onLoadingStateChangeListener);
        }
        AppInterface appInterface = (AppInterface) BaseApplicationImpl.getApplication().getRuntime();
        ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "TroopGiftAnimationController");
        boolean isFriend = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.K.frienduin), "TroopGiftAnimationController");
        int i3 = this.K.istroop;
        if (str.equals("80000000")) {
            Drawable drawable = BaseApplicationImpl.getApplication().getResources().getDrawable(R.drawable.f161530e21);
            return URLDrawable.getDrawable(com.tencent.biz.anonymous.a.f(com.tencent.biz.anonymous.a.e(this.K).f78368d), drawable, drawable);
        }
        if ((i3 == 1010 || i3 == 1001 || i3 == 10002) && !isFriend) {
            FaceDrawable strangerFaceDrawable = FaceDrawable.getStrangerFaceDrawable(appInterface, 200, str, 3, onLoadingStateChangeListener, true);
            if (QLog.isColorLevel()) {
                QLog.d("TroopGiftAnimationController", 2, "getFaceDrawable, uin = " + str);
            }
            return strangerFaceDrawable;
        }
        Drawable defaultDrawable = FaceDrawable.getDefaultDrawable(1, 3);
        return FaceDrawable.getFaceDrawable(appInterface, 1, str, 3, defaultDrawable, defaultDrawable, onLoadingStateChangeListener);
    }

    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            l();
            this.G.removeCallbacksAndMessages(null);
        }
    }

    public void t(MessageForDeliverGiftTips messageForDeliverGiftTips) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) messageForDeliverGiftTips);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopGiftAnimationController", 2, "play TroopGiftAnimation Start,packageId:" + am.i(messageForDeliverGiftTips));
        }
        this.K = messageForDeliverGiftTips;
        if (this.f302753e != null) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopGiftAnimationController", 2, "find troopAnimationLayout");
                return;
            }
            return;
        }
        Emoticon emoticon = new Emoticon();
        emoticon.epId = am.i(this.K);
        ActionGlobalData p16 = MagicfaceActionManager.p(emoticon, 1, 2, messageForDeliverGiftTips.animationType);
        this.C = p16;
        if (p16 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopGiftAnimationController", 2, "find actionGlobaData");
            }
            FrameSprite.a aVar = this.H;
            if (aVar != null) {
                aVar.a();
                this.H = null;
                return;
            }
            return;
        }
        if (this.F == null) {
            this.F = (WindowManager) this.E.getSystemService("window");
        }
        r(messageForDeliverGiftTips.isToAll());
        this.f302752d.setVisibility(0);
        ThreadManagerV2.post(new AnonymousClass5(messageForDeliverGiftTips), 8, null, true);
    }

    public void u(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            this.N = i3;
        }
    }

    public void v(FrameSprite.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            this.H = aVar;
        }
    }

    public void w(xk2.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) aVar);
            return;
        }
        xk2.a aVar2 = this.f302755h;
        if (aVar2 != null) {
            aVar2.onDestroy();
        }
        this.f302755h = aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void x(String str, int i3, int i16, ActionGlobalData actionGlobalData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, str, Integer.valueOf(i3), Integer.valueOf(i16), actionGlobalData);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopGiftAnimationController", 2, "startSendFlowerTip");
        }
        if (!TextUtils.isEmpty(str) && i3 > 0) {
            String str2 = "\u00d7" + i3;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            if (actionGlobalData != null && !actionGlobalData.f243368u) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.rgb(255, 238, 33)), str.length(), str.length(), 18);
            } else {
                spannableStringBuilder.append((CharSequence) str2);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.rgb(255, 238, 33)), str.length(), str.length() + str2.length(), 18);
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan(x.j(this.E, 17.0f)), str.length(), str.length() + 1, 18);
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan(x.j(this.E, 19.0f)), str.length() + 1, str.length() + str2.length(), 18);
            }
            if (this.J == null) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                this.J = alphaAnimation;
                alphaAnimation.setDuration(500L);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, (int) this.E.getResources().getDimension(R.dimen.abs));
            layoutParams.addRule(14);
            layoutParams.setMargins(x.c(this.E, 10.0f), i16, x.c(this.E, 10.0f), 0);
            TextView textView = this.I;
            if (textView == null) {
                TextView textView2 = new TextView(this.E);
                this.I = textView2;
                textView2.setSingleLine();
                this.I.setGravity(17);
                this.I.setTextSize(2, 15.0f);
                this.I.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                this.I.setBackgroundResource(R.drawable.e67);
                this.I.setTextColor(this.E.getResources().getColorStateList(R.color.f158017al3));
                this.I.setPadding(x.c(this.E, 30.0f), this.I.getPaddingTop(), x.c(this.E, 30.0f), this.I.getPaddingBottom());
            } else {
                textView.setLayoutParams(layoutParams);
            }
            this.f302753e.addView(this.I, layoutParams);
            if (actionGlobalData != null) {
                try {
                } catch (IllegalArgumentException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e(LogTag.TAG_TROOP_SEND_GIFT, 2, "parse detail strip bg clor failed. Color value is " + actionGlobalData.f243369v, e16);
                    }
                }
                if (actionGlobalData.f243369v != null) {
                    this.I.getBackground().setColorFilter(new LightingColorFilter(-16777216, Color.parseColor(actionGlobalData.f243369v)));
                    this.I.setVisibility(0);
                    this.I.startAnimation(this.J);
                    this.I.setText(spannableStringBuilder);
                    if (!QLog.isColorLevel()) {
                        QLog.d("TroopGiftAnimationController", 2, "startSendFlowerTip Success");
                        return;
                    }
                    return;
                }
            }
            this.I.getBackground().setColorFilter(null);
            this.I.setVisibility(0);
            this.I.startAnimation(this.J);
            this.I.setText(spannableStringBuilder);
            if (!QLog.isColorLevel()) {
            }
        }
    }

    public void y(int i3, ActionGlobalData actionGlobalData) {
        String str;
        String str2;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) actionGlobalData);
            return;
        }
        if (this.K == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopGiftAnimationController", 2, "startSendGiftHeadAnimation");
        }
        if (this.f302752d != null) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopGiftAnimationController", 2, "\u521b\u5efa\u5934\u50cf\u65f6\u95f4 = " + (System.currentTimeMillis() - this.f302756i));
            }
            if (QLog.isColorLevel()) {
                QLog.d("TroopGiftAnimationController", 2, "sendFlowerSurfaceView show");
            }
            SpriteGLView spriteGLView = this.f302752d;
            if (spriteGLView instanceof TroopGiftToPersonalSurfaceView) {
                ((TroopGiftToPersonalSurfaceView) spriteGLView).x(new FrameSprite.a() { // from class: com.tencent.mobileqq.troopgift.TroopGiftAnimationController.4
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopGiftAnimationController.this);
                        }
                    }

                    @Override // com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.a
                    public void a() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            TroopGiftAnimationController.this.G.post(new Runnable() { // from class: com.tencent.mobileqq.troopgift.TroopGiftAnimationController.4.1
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
                                    } else {
                                        TroopGiftAnimationController.this.l();
                                    }
                                }
                            });
                        }
                    }
                });
                if (!this.K.isToAll() && !TextUtils.isEmpty(this.K.animationBrief)) {
                    MessageForDeliverGiftTips messageForDeliverGiftTips = this.K;
                    x(messageForDeliverGiftTips.animationBrief, messageForDeliverGiftTips.giftCount, i3, actionGlobalData);
                }
            } else if (spriteGLView instanceof TroopGiftToAllSurfaceView) {
                e eVar = new e();
                this.Q = eVar;
                ((TroopGiftToAllSurfaceView) this.f302752d).H(eVar);
                if (this.D != null) {
                    str = "0";
                } else {
                    str = "1";
                }
                AppInterface appInterface = (AppInterface) BaseApplicationImpl.getApplication().getRuntime();
                if (this.N >= 4) {
                    NearbyFlowerManager.c("cartoon", "exp_cartoon", this.K.frienduin, am.i(this.K) + "", "", "");
                    str2 = "";
                } else {
                    str2 = "";
                    ReportController.o(null, "dc00899", "Grp_flower", "", "forall", "exp_anime", 0, 0, "" + this.K.frienduin, "" + am.i(this.K), str, "" + az.a(appInterface, appInterface.getCurrentAccountUin(), this.K.frienduin));
                }
                MessageForDeliverGiftTips messageForDeliverGiftTips2 = this.K;
                if (messageForDeliverGiftTips2.showButton) {
                    ((TroopGiftToAllSurfaceView) this.f302752d).I(this.S);
                    if (this.N >= 4) {
                        NearbyFlowerManager.c("cartoon", "exp_inter", this.K.frienduin, am.i(this.K) + str2, "", "");
                    } else {
                        ReportController.o(null, "dc00899", "Grp_flower", "", "forall", "exp_grab", 0, 0, str2 + this.K.frienduin, str2 + am.i(this.K), str, str2 + az.a(appInterface, appInterface.getCurrentAccountUin(), this.K.frienduin));
                    }
                } else {
                    if (messageForDeliverGiftTips2.resultType == 0) {
                        i16 = actionGlobalData.D;
                    } else {
                        i16 = actionGlobalData.E;
                    }
                    ((TroopGiftToAllSurfaceView) this.f302752d).J(messageForDeliverGiftTips2.resultText, i16, x.c(this.E, 16.0f));
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("TroopGiftAnimationController", 2, "endstartSendGiftHeadAnimation");
            }
        }
    }
}
