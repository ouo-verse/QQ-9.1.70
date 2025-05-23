package com.tencent.mobileqq.aio.background;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.background.FullBackgroundMviIntent;
import com.tencent.mobileqq.aio.background.FullBackgroundUIState;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.IFeatureServiceProxy;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOChatBackgroundApi;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 32\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00014B\u0007\u00a2\u0006\u0004\b1\u00102J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\b\u0010\u0018\u001a\u00020\u0006H\u0016J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0003H\u0016J\u001c\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bH\u0016R\u001b\u0010#\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/aio/background/FullBackgroundVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/mobileqq/aio/background/FullBackgroundMviIntent;", "Lcom/tencent/mobileqq/aio/background/FullBackgroundUIState;", "", "stop", "", "g1", "Landroid/view/View;", "view", "toRemove", "p1", "k1", "e1", "m1", "", "watermarkText", "i1", "q1", ICustomDataEditor.NUMBER_PARAM_1, "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "bindViewAndData", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "state", "o1", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/aio/api/runtime/a;", "createVM", "Landroid/widget/FrameLayout;", "d", "Lkotlin/Lazy;", "f1", "()Landroid/widget/FrameLayout;", "bgViewContainer", "e", "Landroid/view/View;", "bgView", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "watermarkImageView", h.F, "Ljava/lang/String;", "Landroid/graphics/Bitmap;", "i", "Landroid/graphics/Bitmap;", "watermarkBitmap", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class FullBackgroundVB extends com.tencent.aio.base.mvvm.a<FullBackgroundMviIntent, FullBackgroundUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy bgViewContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View bgView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView watermarkImageView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String watermarkText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bitmap watermarkBitmap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/aio/background/FullBackgroundVB$a;", "", "", "FEATURE_PAUSE_BG_ANIM_WHEN_SCROLL", "Ljava/lang/String;", "TAG", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.background.FullBackgroundVB$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32380);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public FullBackgroundVB() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.mobileqq.aio.background.FullBackgroundVB$bgViewContainer$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FullBackgroundVB.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final FrameLayout invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (FrameLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    FrameLayout frameLayout = new FrameLayout(FullBackgroundVB.this.getMContext());
                    FullBackgroundVB fullBackgroundVB = FullBackgroundVB.this;
                    frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    frameLayout.setId(R.id.vgi);
                    frameLayout.setBackgroundColor(fullBackgroundVB.getMContext().getResources().getColor(R.color.qui_common_bg_aio_01));
                    return frameLayout;
                }
            });
            this.bgViewContainer = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void e1(View view, boolean toRemove) {
        boolean z16;
        Activity activity;
        boolean z17 = true;
        if (toRemove) {
            if (f1().indexOfChild(view) == -1) {
                z17 = false;
            }
            if (z17) {
                f1().setBackgroundColor(getMContext().getResources().getColor(R.color.qui_common_bg_aio_01));
                f1().removeView(view);
            }
        } else {
            if (f1().indexOfChild(view) != -1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                if (view.getParent() != null) {
                    QLog.i("FullBackgroundVB", 1, "view parent is not null: " + view.getParent() + ", forbid to add view: " + view);
                    return;
                }
                f1().removeAllViews();
                f1().addView(view, 0);
                f1().setBackgroundResource(0);
                Context context = f1().getContext();
                if (context instanceof Activity) {
                    activity = (Activity) context;
                } else {
                    activity = null;
                }
                if (activity != null) {
                    ((IAIOChatBackgroundApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOChatBackgroundApi.class)).setWindowFit(activity);
                }
            }
        }
        q1();
    }

    private final FrameLayout f1() {
        return (FrameLayout) this.bgViewContainer.getValue();
    }

    private final void g1(final boolean stop) {
        View view = this.bgView;
        if (!(view instanceof com.tencent.qqnt.aio.api.b)) {
            QLog.i("FullBackgroundVB", 1, "handleAIOBackgroundPlayEvent --> the view: " + view + " is not aio backgroundView, return");
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.aio.background.b
            @Override // java.lang.Runnable
            public final void run() {
                FullBackgroundVB.h1(FullBackgroundVB.this, stop);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h1(FullBackgroundVB this$0, boolean z16) {
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        KeyEvent.Callback callback = this$0.bgView;
        Intrinsics.checkNotNull(callback, "null cannot be cast to non-null type com.tencent.qqnt.aio.api.IAIOBackgroundView");
        com.tencent.qqnt.aio.api.b bVar = (com.tencent.qqnt.aio.api.b) callback;
        boolean isFeatureSwitchOn = ((IFeatureServiceProxy) QRoute.api(IFeatureServiceProxy.class)).isFeatureSwitchOn("pause_bg_anim_when_scroll");
        View view = this$0.bgView;
        if (view != null) {
            i3 = view.hashCode();
        } else {
            i3 = 0;
        }
        QLog.i("FullBackgroundVB", 1, "handleAIOBackgroundPlayEvent --> stop: " + z16 + ", scrollPauseAnim: " + isFeatureSwitchOn + ", bgView: " + i3);
        if (isFeatureSwitchOn) {
            if (z16) {
                bVar.backgroundPause();
            } else {
                bVar.backgroundResume();
            }
        }
    }

    private final void i1(final String watermarkText) {
        if (Intrinsics.areEqual(this.watermarkText, watermarkText)) {
            return;
        }
        this.watermarkText = watermarkText;
        f1().post(new Runnable() { // from class: com.tencent.mobileqq.aio.background.a
            @Override // java.lang.Runnable
            public final void run() {
                FullBackgroundVB.j1(FullBackgroundVB.this, watermarkText);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j1(FullBackgroundVB this$0, String watermarkText) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(watermarkText, "$watermarkText");
        this$0.watermarkBitmap = f.f188221a.a(watermarkText, 16, this$0.f1().getWidth(), this$0.f1().getHeight());
        ImageView imageView = this$0.watermarkImageView;
        if (imageView != null) {
            this$0.f1().removeView(imageView);
        }
        ImageView imageView2 = new ImageView(this$0.getMContext());
        imageView2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        imageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView2.setImageBitmap(this$0.watermarkBitmap);
        this$0.watermarkImageView = imageView2;
        this$0.q1();
    }

    private final void k1() {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.aio.background.c
            @Override // java.lang.Runnable
            public final void run() {
                FullBackgroundVB.l1(FullBackgroundVB.this);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l1(FullBackgroundVB this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Bitmap bitmap = this$0.watermarkBitmap;
        if (bitmap != null) {
            this$0.sendIntent(new FullBackgroundMviIntent.PushShotWaterMarkBitmap(bitmap));
        }
    }

    private final void m1() {
        QLog.i("FullBackgroundVB", 1, "[handleRemoveAIOBackground]: bgView is " + this.bgView);
        View view = this.bgView;
        if (view != null) {
            e1(view, true);
        }
    }

    private final void n1() {
        ImageView imageView = this.watermarkImageView;
        if (imageView != null) {
            f1().removeView(imageView);
        }
        this.watermarkImageView = null;
        this.watermarkText = null;
        this.watermarkBitmap = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void p1(View view, boolean toRemove) {
        if (!(view instanceof com.tencent.qqnt.aio.api.b)) {
            QLog.i("FullBackgroundVB", 1, "the view: " + view + " is not aio backgroundView, forbid to add");
            return;
        }
        this.bgView = view;
        QLog.i("FullBackgroundVB", 1, "change background view: " + view + ", toRemove? " + toRemove + ",  type: " + ((com.tencent.qqnt.aio.api.b) view).type());
        e1(view, toRemove);
    }

    private final void q1() {
        ViewParent viewParent;
        ImageView imageView = this.watermarkImageView;
        if (imageView != null) {
            if (imageView != null) {
                viewParent = imageView.getParent();
            } else {
                viewParent = null;
            }
            if (viewParent == null) {
                f1().addView(this.watermarkImageView);
            }
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.bindViewAndData();
        f1().removeAllViews();
        q1();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    /* renamed from: createVM */
    public BaseVM<FullBackgroundMviIntent, FullBackgroundUIState, com.tencent.aio.api.runtime.a> getViewModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (BaseVM) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new FullBackgroundVM();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: o1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull FullBackgroundUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof FullBackgroundUIState.UpdateAIOBackgroundView) {
            FullBackgroundUIState.UpdateAIOBackgroundView updateAIOBackgroundView = (FullBackgroundUIState.UpdateAIOBackgroundView) state;
            p1(updateAIOBackgroundView.b(), updateAIOBackgroundView.a());
            return;
        }
        if (state instanceof FullBackgroundUIState.UpdateAIOBackgroundPlayEvent) {
            g1(((FullBackgroundUIState.UpdateAIOBackgroundPlayEvent) state).a());
            return;
        }
        if (state instanceof FullBackgroundUIState.RemoveAIOBackgroundView) {
            m1();
            return;
        }
        if (state instanceof FullBackgroundUIState.UpdateAIOWatermark) {
            i1(((FullBackgroundUIState.UpdateAIOWatermark) state).a());
            return;
        }
        if (state instanceof FullBackgroundUIState.RemoveAIOWatermark) {
            n1();
        } else if (state instanceof FullBackgroundUIState.PushShotWatermarkBitmap) {
            k1();
        } else if (state instanceof FullBackgroundUIState.SetImmersiveBottomDrawable) {
            ((IAIOChatBackgroundApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOChatBackgroundApi.class)).setImmersiveBottomDrawable(f1(), ((FullBackgroundUIState.SetImmersiveBottomDrawable) state).a());
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        return f1();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            n1();
            super.onDestroy();
        }
    }
}
