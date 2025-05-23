package com.tencent.mobileqq.troop.enterEffect;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.troop.TroopMemberNickInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder;
import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.surfaceviewaction.gl.e;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService;
import com.tencent.mobileqq.troop.entereffect.e;
import com.tencent.mobileqq.troop.entereffect.f;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.am;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.i;
import com.tencent.mobileqq.vas.quickupdate.TroopEnterEffectBusiness;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.troop.IceBreakHelper;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.mobileqq.widget.ColorClearableEditText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.vas.update.entity.UpdateListenerParams;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.io.File;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopEnterEffectController {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected SpriteGLView f295175a;

    /* renamed from: b, reason: collision with root package name */
    protected LinearLayout f295176b;

    /* renamed from: c, reason: collision with root package name */
    protected ScrollView f295177c;

    /* renamed from: d, reason: collision with root package name */
    protected RelativeLayout f295178d;

    /* renamed from: e, reason: collision with root package name */
    protected Handler f295179e;

    /* renamed from: f, reason: collision with root package name */
    protected SparseArray<f> f295180f;

    /* renamed from: g, reason: collision with root package name */
    protected boolean f295181g;

    /* renamed from: h, reason: collision with root package name */
    protected String f295182h;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f295183i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController$5, reason: invalid class name */
    /* loaded from: classes19.dex */
    public class AnonymousClass5 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ f f295187d;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController$5$3, reason: invalid class name */
        /* loaded from: classes19.dex */
        class AnonymousClass3 implements SceneBuilder.e {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ QQAppInterface f295191a;

            AnonymousClass3(QQAppInterface qQAppInterface) {
                this.f295191a = qQAppInterface;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass5.this, (Object) qQAppInterface);
                }
            }

            @Override // com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder.e
            public Bitmap a(com.tencent.mobileqq.surfaceviewaction.d dVar, String str, String str2) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Bitmap) iPatchRedirector.redirect((short) 2, this, dVar, str, str2);
                }
                Bitmap bitmap = null;
                try {
                    if (str2.equals("$AVATAR$")) {
                        Drawable defaultDrawable = FaceDrawable.getDefaultDrawable(1, 3);
                        bitmap = TroopUtils.p(FaceDrawable.getFaceDrawable(this.f295191a, 1, AnonymousClass5.this.f295187d.f295259b, 3, defaultDrawable, defaultDrawable, new FaceDrawable.OnLoadingStateChangeListener(dVar) { // from class: com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.5.3.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ com.tencent.mobileqq.surfaceviewaction.d f295193d;

                            {
                                this.f295193d = dVar;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this, (Object) dVar);
                                }
                            }

                            @Override // com.tencent.mobileqq.app.face.FaceDrawable.OnLoadingStateChangeListener
                            public void onLoadingStateChanged(int i3, int i16) {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
                                    return;
                                }
                                if (i3 == 0 && i16 == 1) {
                                    try {
                                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                        AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                                        if (TroopEnterEffectController.this.f295175a != null) {
                                            TroopEnterEffectController.this.f295175a.t(new Runnable(Bitmap.createScaledBitmap(TroopUtils.p(FaceDrawable.getFaceDrawable(anonymousClass3.f295191a, 1, anonymousClass5.f295187d.f295259b)), ((e) this.f295193d).F(), ((e) this.f295193d).C(), true)) { // from class: com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.5.3.1.1
                                                static IPatchRedirector $redirector_;

                                                /* renamed from: d, reason: collision with root package name */
                                                final /* synthetic */ Bitmap f295195d;

                                                {
                                                    this.f295195d = r5;
                                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) r5);
                                                    }
                                                }

                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                                    } else {
                                                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                                        anonymousClass1.f295193d.a(TroopEnterEffectController.this.f295175a, this.f295195d);
                                                    }
                                                }
                                            });
                                        }
                                    } catch (Exception e16) {
                                        QLog.e("TroopEnterEffect.Controller", 2, "onLoadingStateChanged: " + e16);
                                    }
                                }
                            }
                        }));
                    } else {
                        if (str2.equals("$SVIP$")) {
                            Bitmap i3 = TroopEnterEffectController.i(str, AnonymousClass5.this.f295187d);
                            if (i3 == null) {
                                i3 = TroopEnterEffectController.i(TroopEnterEffectController.j(), AnonymousClass5.this.f295187d);
                            }
                            Bitmap bitmap2 = i3;
                            if (bitmap2 == null) {
                                return Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
                            }
                            return bitmap2;
                        }
                        bitmap = BaseImageUtil.decodeFileWithBufferedStream(str + "/" + str2, null);
                    }
                    return bitmap;
                } catch (OutOfMemoryError unused) {
                    return bitmap;
                }
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController$5$a */
        /* loaded from: classes19.dex */
        class a implements SceneBuilder.g {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass5.this);
                }
            }

            @Override // com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder.g
            public void a(int i3, int i16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
                    return;
                }
                ScrollView scrollView = TroopEnterEffectController.this.f295177c;
                if (scrollView == null) {
                    return;
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) scrollView.getLayoutParams();
                layoutParams.width = i3;
                layoutParams.height = i16;
                TroopEnterEffectController.this.f295177c.setLayoutParams(layoutParams);
            }
        }

        AnonymousClass5(f fVar) {
            this.f295187d = fVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopEnterEffectController.this, (Object) fVar);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                if (TroopEnterEffectController.this.f295175a == null) {
                    return;
                }
                TroopEnterEffectController.e();
                QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
                new SceneBuilder().q(TroopEnterEffectController.this.f295175a.getWidth()).p(((TroopEnterEffectBusiness) QQVasUpdateBusiness.getBusiness(TroopEnterEffectBusiness.class)).getAnimFile(this.f295187d.f295258a)).r(new FrameSprite.a() { // from class: com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.5.4
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass5.this);
                        }
                    }

                    @Override // com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.a
                    public void a() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        SpriteGLView spriteGLView = TroopEnterEffectController.this.f295175a;
                        if (spriteGLView != null) {
                            spriteGLView.u();
                            TroopEnterEffectController.this.f295179e.post(new Runnable() { // from class: com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.5.4.1
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
                                    TroopEnterEffectController troopEnterEffectController = TroopEnterEffectController.this;
                                    troopEnterEffectController.f295176b.removeView(troopEnterEffectController.f295175a);
                                    TroopEnterEffectController troopEnterEffectController2 = TroopEnterEffectController.this;
                                    troopEnterEffectController2.f295178d.removeView(troopEnterEffectController2.f295177c);
                                    TroopEnterEffectController troopEnterEffectController3 = TroopEnterEffectController.this;
                                    troopEnterEffectController3.f295175a = null;
                                    troopEnterEffectController3.f295183i = false;
                                }
                            });
                        }
                    }
                }).t(new c(qQAppInterface, this.f295187d)).s(new AnonymousClass3(qQAppInterface)).u(new a()).g(TroopEnterEffectController.this.f295175a, new SceneBuilder.h() { // from class: com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.5.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass5.this);
                        }
                    }

                    @Override // com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder.h
                    public void a(com.tencent.mobileqq.surfaceviewaction.c cVar) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) cVar);
                            return;
                        }
                        TroopEnterEffectController troopEnterEffectController = TroopEnterEffectController.this;
                        if (troopEnterEffectController.f295175a == null) {
                            return;
                        }
                        troopEnterEffectController.f295179e.post(new Runnable(cVar) { // from class: com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.5.1.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ com.tencent.mobileqq.surfaceviewaction.c f295189d;

                            {
                                this.f295189d = cVar;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) cVar);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                    return;
                                }
                                SpriteGLView spriteGLView = TroopEnterEffectController.this.f295175a;
                                if (spriteGLView != null) {
                                    spriteGLView.i((com.tencent.mobileqq.surfaceviewaction.gl.d) this.f295189d);
                                }
                            }
                        });
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a extends ScrollView {
        static IPatchRedirector $redirector_;

        a(Context context) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopEnterEffectController.this, (Object) context);
            }
        }

        @Override // android.view.View
        public void setOverScrollMode(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            } else {
                super.setOverScrollMode(2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ f f295207d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f295208e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f295209f;

        b(f fVar, QQAppInterface qQAppInterface, String str) {
            this.f295207d = fVar;
            this.f295208e = qQAppInterface;
            this.f295209f = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopEnterEffectController.this, fVar, qQAppInterface, str);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            if (motionEvent.getAction() == 1) {
                String url = ((TroopEnterEffectBusiness) QQVasUpdateBusiness.getBusiness(TroopEnterEffectBusiness.class)).getUrl(this.f295207d.f295258a);
                ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openSchema(TroopEnterEffectController.this.f295178d.getContext(), url + "&gc=" + TroopEnterEffectController.this.f295182h);
                int i3 = 0;
                ((ITroopEnterEffectService) this.f295208e.getRuntimeService(ITroopEnterEffectService.class, "all")).report("Grp_AIO", "action_clk", TroopEnterEffectController.this.f295182h);
                if (!TextUtils.isEmpty(this.f295209f) && this.f295209f.equals(this.f295207d.f295259b)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                JSONObject jSONObject = new JSONObject();
                if (!z16) {
                    i3 = 1;
                }
                try {
                    jSONObject.put("user_master", i3);
                    jSONObject.put("ipid", url);
                    MobileReportManager.getInstance().reportAction("" + this.f295207d.f295258a, "4", "DressVip", "pg_aio", "visual_effects", 102, 0, System.currentTimeMillis(), jSONObject.toString());
                } catch (JSONException e16) {
                    throw new RuntimeException(e16);
                }
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    private class c implements SceneBuilder.f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private QQAppInterface f295211a;

        /* renamed from: b, reason: collision with root package name */
        private f f295212b;

        /* renamed from: c, reason: collision with root package name */
        List<ColorClearableEditText.a> f295213c;

        /* renamed from: d, reason: collision with root package name */
        Rect f295214d;

        /* renamed from: e, reason: collision with root package name */
        private ColorClearableEditText.b f295215e;

        public c(QQAppInterface qQAppInterface, f fVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopEnterEffectController.this, qQAppInterface, fVar);
                return;
            }
            this.f295214d = new Rect();
            this.f295215e = new ColorClearableEditText.b();
            this.f295211a = qQAppInterface;
            this.f295212b = fVar;
        }

        private void e(List<ColorClearableEditText.a> list, Canvas canvas, Paint paint, float f16, float f17, float f18, Rect rect, int i3, int i16) {
            ColorClearableEditText.a aVar = list.get(0);
            if (aVar.f315542e == 3) {
                i iVar = (i) aVar.f315541d;
                int i17 = iVar.f309559d;
                if (i17 == 2) {
                    paint.setColor(iVar.f309560e);
                } else if (i17 == 3) {
                    AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                    if (runtime instanceof QQAppInterface) {
                        paint.setShader(com.tencent.mobileqq.vas.f.h((QQAppInterface) runtime).l(iVar.f309560e, list, f16, f17, rect, paint, i3, i16));
                    }
                }
            }
            float f19 = f16;
            for (ColorClearableEditText.a aVar2 : list) {
                int i18 = aVar2.f315542e;
                if (i18 != 1) {
                    if (i18 == 2) {
                        int height = (int) (r15.getDrawable().getBounds().height() + f17);
                        ((EmoticonSpan) aVar2.f315541d).draw(canvas, "", 0, 0, f19, (int) f17, height, height, paint);
                        f19 += r15.getDrawable().getBounds().width();
                    }
                } else {
                    canvas.drawText(aVar2.f315540c, f19, f17 + f18, paint);
                    f19 += paint.measureText(aVar2.f315540c);
                }
            }
            paint.setShader(null);
        }

        @Override // com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder.f
        public void a(int i3, String str, Paint paint) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), str, paint);
            } else {
                this.f295213c = com.tencent.mobileqq.vas.f.d(i3, str, paint, this.f295215e, 32);
            }
        }

        @Override // com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder.f
        public int b(int i3, int i16, int i17, String str, Paint paint) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str, paint)).intValue();
            }
            return com.tencent.mobileqq.vas.f.n(this.f295213c, paint, this.f295214d);
        }

        @Override // com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder.f
        public String c(com.tencent.mobileqq.surfaceviewaction.d dVar, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) dVar, (Object) str);
            }
            return str.replace("$NICK$", this.f295212b.f295266i);
        }

        @Override // com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder.f
        public boolean d(Canvas canvas, String str, float f16, float f17, float f18, int i3, int i16, Paint paint) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, this, canvas, str, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Integer.valueOf(i3), Integer.valueOf(i16), paint)).booleanValue();
            }
            e(this.f295213c, canvas, paint, f16, f17, f18, this.f295214d, i3, i16);
            return true;
        }
    }

    public TroopEnterEffectController(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f295179e = new Handler(Looper.getMainLooper());
        this.f295180f = new SparseArray<>();
        this.f295183i = false;
        if (context != null) {
            this.f295178d = new RelativeLayout(context);
        }
    }

    public static void e() {
        String j3 = j();
        if (TextUtils.isEmpty(j3)) {
            QLog.e("TroopEnterEffect.Controller", 1, "checkVipIconsExists get null path");
        } else {
            ThreadManagerV2.excute(new Runnable(j3) { // from class: com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.6
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f295200d;

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController$6$a */
                /* loaded from: classes19.dex */
                class a implements IDownLoadListener {
                    static IPatchRedirector $redirector_;

                    a() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass6.this);
                        }
                    }

                    @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
                    public void onLoadFail(@NonNull UpdateListenerParams updateListenerParams) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                            iPatchRedirector.redirect((short) 3, (Object) this, (Object) updateListenerParams);
                            return;
                        }
                        QLog.w("TroopEnterEffect.Controller", 1, "onLoadFail:" + updateListenerParams);
                    }

                    @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
                    public void onLoadSuccess(@NonNull UpdateListenerParams updateListenerParams) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) updateListenerParams);
                            return;
                        }
                        QLog.w("TroopEnterEffect.Controller", 1, "onLoadSuccess:" + updateListenerParams);
                    }
                }

                {
                    this.f295200d = j3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) j3);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (ThemeUtil.getFileNumInFile(new File(this.f295200d)) == 0) {
                        QQVasUpdateBusiness<?> newBusiness = VasUpdateConstants.getNewBusiness(1004L);
                        if (newBusiness != null) {
                            newBusiness.addDownLoadListener(VasUpdateConstants.SCID_ENTER_EFFECT_VIP_ICONS, new a());
                            newBusiness.startDownload(VasUpdateConstants.SCID_ENTER_EFFECT_VIP_ICONS);
                        } else {
                            ((IVasQuickUpdateService) ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getRuntimeService(IVasQuickUpdateService.class, "")).downloadItem(1004L, VasUpdateConstants.SCID_ENTER_EFFECT_VIP_ICONS, "TroopEnterEffectController");
                        }
                    }
                }
            }, 64, null, false);
        }
    }

    private e.d g() {
        int i3;
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        ITroopEnterEffectService iTroopEnterEffectService = (ITroopEnterEffectService) qQAppInterface.getRuntimeService(ITroopEnterEffectService.class, "all");
        boolean hasShowGrayTipsToday = iTroopEnterEffectService.hasShowGrayTipsToday();
        if (QLog.isColorLevel()) {
            QLog.d("TroopEnterEffect.Controller", 2, "getGrayTips isShowEnterEffectEveryTime = false hasShowToday = " + hasShowGrayTipsToday);
        }
        if (!hasShowGrayTipsToday) {
            com.tencent.mobileqq.troop.entereffect.e troopEnterEffectConfig = iTroopEnterEffectService.getTroopEnterEffectConfig();
            if (troopEnterEffectConfig.f295229d.size() > 0) {
                if (iTroopEnterEffectService.hasSetEffect(this.f295182h)) {
                    i3 = 2;
                } else {
                    i3 = 1;
                }
                for (int i16 = 0; i16 < troopEnterEffectConfig.f295229d.size(); i16++) {
                    e.d dVar = troopEnterEffectConfig.f295229d.get(i16);
                    boolean z16 = iTroopEnterEffectService.getSharedPreferences().getBoolean(ITroopEnterEffectService.SP_KEY_NO_LONGER_TIPS_ID + dVar.f295241a, false);
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopEnterEffect.Controller", 2, "getGrayTips id = " + dVar.f295241a + " nolongerShow = " + z16);
                    }
                    if (!z16 && dVar.b(i3, qQAppInterface)) {
                        return dVar;
                    }
                }
                return null;
            }
            return null;
        }
        return null;
    }

    public static Bitmap i(String str, f fVar) {
        int i3 = fVar.f295263f;
        Bitmap bitmap = null;
        if (i3 == 2) {
            bitmap = BaseImageUtil.decodeFileWithBufferedStream(str + "/yearsvip/yearsvip_s" + fVar.f295262e + ".png", null);
        } else {
            if (i3 == 1) {
                bitmap = BaseImageUtil.decodeFileWithBufferedStream(str + "/svip/svip_s" + fVar.f295262e + ".png", null);
            }
            return bitmap;
        }
        return bitmap;
    }

    public static String j() {
        QQVasUpdateBusiness<?> newBusiness = VasUpdateConstants.getNewBusiness(1004L);
        if (newBusiness != null) {
            return newBusiness.getSavePath(VasUpdateConstants.SCID_ENTER_EFFECT_VIP_ICONS);
        }
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        if (application != null) {
            return new File(application.getFilesDir(), VasUpdateConstants.SCID_ENTER_EFFECT_VIP_ICONS).getAbsolutePath();
        }
        return null;
    }

    public static String k() {
        QQVasUpdateBusiness<?> newBusiness = VasUpdateConstants.getNewBusiness(1004L);
        if (newBusiness != null) {
            return newBusiness.getSavePath(VasUpdateConstants.SCID_ENTER_EFFECT_VIP_ICONS) + "/1004_" + VasUpdateConstants.SCID_ENTER_EFFECT_VIP_ICONS + ".sge";
        }
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        if (application != null) {
            return new File(application.getFilesDir(), "enterEffectVipIcons.zip").getAbsolutePath();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m() {
        ITroopEnterEffectService iTroopEnterEffectService = (ITroopEnterEffectService) ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getRuntimeService(ITroopEnterEffectService.class, "all");
        final f firstEffectData = iTroopEnterEffectService.getFirstEffectData(this.f295182h);
        if (firstEffectData != null && f(firstEffectData)) {
            if (System.currentTimeMillis() - firstEffectData.f295261d < 60000) {
                this.f295179e.post(new Runnable() { // from class: com.tencent.mobileqq.troop.enterEffect.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        TroopEnterEffectController.this.l(firstEffectData);
                    }
                });
            } else {
                iTroopEnterEffectService.removeEnterEffectData(firstEffectData);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit n(f fVar, TroopMemberNickInfo troopMemberNickInfo) {
        if (troopMemberNickInfo != null) {
            fVar.f295266i = troopMemberNickInfo.getShowName();
        }
        if (ar.b("kenaiyu", "2024-10-15", "vas_bug_132208713").isEnable(true)) {
            this.f295179e.postDelayed(new Runnable(fVar) { // from class: com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ f f295184d;

                {
                    this.f295184d = fVar;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopEnterEffectController.this, (Object) fVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        TroopEnterEffectController.this.u(this.f295184d);
                    }
                }
            }, r4.getInt(500));
            return null;
        }
        u(fVar);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void l(final f fVar) {
        if (QLog.isColorLevel()) {
            QLog.d("TroopEnterEffect.Controller", 2, "showAnimation: enterEffectData = " + fVar + " isAio = " + this.f295181g);
        }
        if (this.f295183i) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopEnterEffect.Controller", 2, "isPlaying");
                return;
            }
            return;
        }
        ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberName(fVar.f295260c, fVar.f295259b, "TroopEnterEffect.Controller", new Function1() { // from class: com.tencent.mobileqq.troop.enterEffect.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit n3;
                n3 = TroopEnterEffectController.this.n(fVar, (TroopMemberNickInfo) obj);
                return n3;
            }
        });
    }

    public boolean f(f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) fVar)).booleanValue();
        }
        int i3 = fVar.f295258a;
        if (QLog.isColorLevel()) {
            QLog.d("TroopEnterEffect.Controller", 2, "downloadAnimationResources: id = " + i3);
        }
        TroopEnterEffectBusiness troopEnterEffectBusiness = (TroopEnterEffectBusiness) QQVasUpdateBusiness.getBusiness(TroopEnterEffectBusiness.class);
        if (am.n(new File(troopEnterEffectBusiness.getAnimFile(i3)))) {
            return true;
        }
        if (this.f295180f.get(i3) != null) {
            return false;
        }
        FileUtils.deleteDirectory(troopEnterEffectBusiness.getAnimFile(i3));
        troopEnterEffectBusiness.addDownLoadListener(i3, new Runnable(i3, troopEnterEffectBusiness) { // from class: com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.7
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f295202d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ TroopEnterEffectBusiness f295203e;

            {
                this.f295202d = i3;
                this.f295203e = troopEnterEffectBusiness;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, TroopEnterEffectController.this, Integer.valueOf(i3), troopEnterEffectBusiness);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                f fVar2 = TroopEnterEffectController.this.f295180f.get(this.f295202d);
                TroopEnterEffectController.this.f295180f.remove(this.f295202d);
                if (fVar2 != null) {
                    if (am.n(new File(this.f295203e.getAnimFile(this.f295202d)))) {
                        TroopEnterEffectController.this.f295179e.post(new Runnable(fVar2) { // from class: com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.7.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ f f295204d;

                            {
                                this.f295204d = fVar2;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass7.this, (Object) fVar2);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                    return;
                                }
                                QLog.d("TroopEnterEffect.Controller", 2, "download Res isAIO = " + TroopEnterEffectController.this.f295181g);
                                if (TroopEnterEffectController.this.f295181g) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d("TroopEnterEffect.Controller", 2, "download Res callback success id = " + AnonymousClass7.this.f295202d + " showAnimation");
                                    }
                                    TroopEnterEffectController.this.l(this.f295204d);
                                }
                            }
                        });
                    }
                } else {
                    QLog.e("TroopEnterEffect.Controller", 1, "mResDownloadCallback effectData = null id = " + this.f295202d);
                }
            }
        });
        troopEnterEffectBusiness.startDownload(i3);
        this.f295180f.put(i3, fVar);
        return false;
    }

    public View h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f295178d;
    }

    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.f295183i = false;
            IceBreakHelper.INSTANCE.clearPlayEnterEffect();
        }
    }

    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        SpriteGLView spriteGLView = this.f295175a;
        if (spriteGLView != null) {
            spriteGLView.u();
            this.f295177c.removeAllViews();
            this.f295176b.removeView(this.f295175a);
            this.f295178d.removeView(this.f295177c);
            this.f295175a = null;
            this.f295177c = null;
            this.f295176b = null;
        }
        this.f295181g = false;
        this.f295179e.removeCallbacksAndMessages(null);
        ((ITroopEnterEffectService) ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getRuntimeService(ITroopEnterEffectService.class, "all")).removeAllEffectDatas(this.f295182h);
    }

    public void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopEnterEffect.Controller", 2, "onResume");
        }
        this.f295181g = true;
    }

    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (ah.k0()) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopEnterEffect.Controller", 2, "playAnimaions: isLowEndPhoneForPreDownload = true");
            }
        } else {
            if (SimpleUIUtil.getSimpleUISwitch()) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopEnterEffect.Controller", 2, "playAnimaions: isSimpleUISwitch = true");
                    return;
                }
                return;
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troop.enterEffect.a
                @Override // java.lang.Runnable
                public final void run() {
                    TroopEnterEffectController.this.m();
                }
            }, 16, null, true);
        }
    }

    public void s(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else {
            this.f295182h = str;
        }
    }

    protected void u(f fVar) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) fVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopEnterEffect.Controller", 2, "showAnimationAfterGetTroopName: enterEffectData = " + fVar + " isAio = " + this.f295181g);
        }
        if (this.f295183i) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopEnterEffect.Controller", 2, "isPlaying");
                return;
            }
            return;
        }
        if (this.f295175a == null) {
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
            String currentUin = qQAppInterface.getCurrentUin();
            if (!TextUtils.isEmpty(currentUin) && currentUin.equals(fVar.f295259b)) {
                z16 = true;
            } else {
                z16 = false;
            }
            ThreadManagerV2.excute(new Runnable(fVar, z16) { // from class: com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ f f295185d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ boolean f295186e;

                {
                    this.f295185d = fVar;
                    this.f295186e = z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TroopEnterEffectController.this, fVar, Boolean.valueOf(z16));
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
                    String url = ((TroopEnterEffectBusiness) QQVasUpdateBusiness.getBusiness(TroopEnterEffectBusiness.class)).getUrl(this.f295185d.f295258a);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        if (this.f295186e) {
                            i3 = 0;
                        } else {
                            i3 = 1;
                        }
                        jSONObject.put("user_master", i3);
                        jSONObject.put("ipid", url);
                        MobileReportManager.getInstance().reportAction("" + this.f295185d.f295258a, "4", "DressVip", "pg_aio", "visual_effects", 101, 0, System.currentTimeMillis(), jSONObject.toString());
                    } catch (JSONException e16) {
                        throw new RuntimeException(e16);
                    }
                }
            }, 16, null, false);
            ITroopEnterEffectService iTroopEnterEffectService = (ITroopEnterEffectService) qQAppInterface.getRuntimeService(ITroopEnterEffectService.class, "all");
            iTroopEnterEffectService.removeEnterEffectData(fVar);
            this.f295183i = true;
            SpriteGLView spriteGLView = new SpriteGLView(this.f295178d.getContext(), 1);
            this.f295175a = spriteGLView;
            spriteGLView.H = true;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, 0);
            View findViewById = this.f295178d.findViewById(R.id.jwo);
            View findViewById2 = this.f295178d.findViewById(R.id.k0p);
            View findViewById3 = this.f295178d.findViewById(R.id.gp5);
            if (findViewById != null && findViewById.getVisibility() == 0) {
                layoutParams.topMargin = findViewById.getBottom();
            } else if (findViewById2 != null && findViewById2.getVisibility() == 0) {
                layoutParams.topMargin = findViewById2.getBottom();
            } else if (findViewById3 != null && findViewById3.getVisibility() == 0) {
                layoutParams.topMargin = findViewById3.getBottom();
            } else {
                layoutParams.topMargin = x.c(this.f295178d.getContext(), 50.0f);
            }
            layoutParams.topMargin += ImmersiveUtils.getStatusBarHeight(this.f295178d.getContext());
            if (this.f295176b == null) {
                this.f295176b = new LinearLayout(this.f295178d.getContext());
            }
            if (this.f295177c == null) {
                a aVar = new a(this.f295178d.getContext());
                this.f295177c = aVar;
                aVar.setClickable(false);
                this.f295177c.setEnabled(false);
                this.f295177c.addView(this.f295176b, -1, x.c(this.f295178d.getContext(), this.f295178d.getHeight()));
            }
            this.f295178d.addView(this.f295177c, layoutParams);
            this.f295176b.addView(this.f295175a, -1, 0);
            this.f295175a.setOnTouchListener(new b(fVar, qQAppInterface, currentUin));
            this.f295175a.post(new AnonymousClass5(fVar));
            d dVar = (d) qQAppInterface.getManager(QQManagerFactory.TROOP_ENTER_EFFECT_MANAGER);
            e.d g16 = g();
            if (g16 != null) {
                dVar.a(g16, this.f295182h);
            }
            iTroopEnterEffectService.report("Grp_AIO", "action_play", new String[0]);
        }
    }
}
