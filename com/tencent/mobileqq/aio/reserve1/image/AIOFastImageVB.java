package com.tencent.mobileqq.aio.reserve1.image;

import android.os.Message;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import at.d;
import com.tencent.aio.base.mvi.part.Reserve1UIState;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.reserve1.image.AIOFastImageUIState;
import com.tencent.mobileqq.aio.reserve1.image.a;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 02\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00011B\u000f\u0012\u0006\u0010-\u001a\u00020\u0012\u00a2\u0006\u0004\b.\u0010/J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0006H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u001c\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\b\u0010\u0018\u001a\u00020\u0006H\u0016R\u001b\u0010\u001e\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010#\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\"R\u001b\u0010(\u001a\u00020$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010\u001b\u001a\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve1/image/AIOFastImageVB;", "Lcom/tencent/qqnt/aio/lazy/lazyInit/a;", "Lat/d;", "Lcom/tencent/aio/base/mvi/part/Reserve1UIState;", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "recentImage", "", "k1", "o1", "m1", "", "isFadeIn", ICustomDataEditor.NUMBER_PARAM_1, "bindViewAndData", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/mvi/base/route/MsgIntent;", "initIntent", "Lcom/tencent/qqnt/aio/lazy/lazyInit/b;", "b1", "state", "l1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/widget/TextView;", "e", "Lkotlin/Lazy;", "i1", "()Landroid/widget/TextView;", "fastImageTip", "Landroid/widget/ImageView;", "f", "h1", "()Landroid/widget/ImageView;", "aioFastImage", "Landroid/widget/LinearLayout;", h.F, "j1", "()Landroid/widget/LinearLayout;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lmqq/os/MqqHandler;", "i", "Lmqq/os/MqqHandler;", "handler", "initMsgIntent", "<init>", "(Lcom/tencent/mvi/base/route/MsgIntent;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOFastImageVB extends com.tencent.qqnt.aio.lazy.lazyInit.a<d, Reserve1UIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy fastImageTip;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy aioFastImage;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy rootView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MqqHandler handler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve1/image/AIOFastImageVB$a;", "", "", "DURATION", "J", "", "TAG", "Ljava/lang/String;", "", "THUMB_SIZE", "I", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.reserve1.image.AIOFastImageVB$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/reserve1/image/AIOFastImageVB$b", "Lmqq/os/MqqHandler;", "Landroid/os/Message;", "msg", "", "handleMessage", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b extends MqqHandler {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOFastImageVB.this);
            }
        }

        @Override // mqq.os.MqqHandler
        public void handleMessage(@NotNull Message msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) msg2);
                return;
            }
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.d("fast_image  AIOFastImageVB", 1, "msg: " + msg2);
            if (msg2.what == 33) {
                AIOFastImageVB.this.m1();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/aio/reserve1/image/AIOFastImageVB$c", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class c implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOFastImageVB.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@Nullable Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            } else {
                AIOFastImageVB.this.j1().setVisibility(8);
                AIOFastImageVB.this.j1().clearAnimation();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@Nullable Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@Nullable Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64705);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOFastImageVB(@NotNull MsgIntent initMsgIntent) {
        super(initMsgIntent);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(initMsgIntent, "initMsgIntent");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.aio.reserve1.image.AIOFastImageVB$fastImageTip$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOFastImageVB.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final TextView invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (TextView) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    TextView textView = new TextView(AIOFastImageVB.this.getMContext());
                    AIOFastImageVB aIOFastImageVB = AIOFastImageVB.this;
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.width = (int) aIOFastImageVB.getMContext().getResources().getDimension(R.dimen.bzg);
                    layoutParams.gravity = 1;
                    textView.setLayoutParams(layoutParams);
                    textView.setId(R.id.v0r);
                    textView.setText(aIOFastImageVB.getMContext().getText(R.string.yql));
                    textView.setTextSize(0, aIOFastImageVB.getMContext().getResources().getDimension(R.dimen.bzf));
                    textView.setSingleLine(false);
                    textView.setTextColor(aIOFastImageVB.getMContext().getColor(R.color.b4s));
                    return textView;
                }
            });
            this.fastImageTip = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.aio.reserve1.image.AIOFastImageVB$aioFastImage$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOFastImageVB.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final ImageView invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (ImageView) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    ImageView imageView = new ImageView(AIOFastImageVB.this.getMContext());
                    AIOFastImageVB aIOFastImageVB = AIOFastImageVB.this;
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.width = (int) aIOFastImageVB.getMContext().getResources().getDimension(R.dimen.bzg);
                    layoutParams.height = (int) aIOFastImageVB.getMContext().getResources().getDimension(R.dimen.bzd);
                    layoutParams.topMargin = (int) aIOFastImageVB.getMContext().getResources().getDimension(R.dimen.bze);
                    imageView.setLayoutParams(layoutParams);
                    imageView.setId(R.id.v0q);
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    return imageView;
                }
            });
            this.aioFastImage = lazy2;
            lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.mobileqq.aio.reserve1.image.AIOFastImageVB$rootView$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOFastImageVB.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final LinearLayout invoke() {
                    TextView i16;
                    ImageView h16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (LinearLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    DisplayMetrics displayMetrics = AIOFastImageVB.this.getMContext().getResources().getDisplayMetrics();
                    LinearLayout linearLayout = new LinearLayout(AIOFastImageVB.this.getMContext());
                    AIOFastImageVB aIOFastImageVB = AIOFastImageVB.this;
                    ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
                    layoutParams.bottomToBottom = R.id.slg;
                    layoutParams.endToEnd = 0;
                    ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = (int) TypedValue.applyDimension(1, 8.0f, displayMetrics);
                    ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = (int) TypedValue.applyDimension(1, 8.0f, displayMetrics);
                    linearLayout.setLayoutParams(layoutParams);
                    linearLayout.setId(R.id.shj);
                    linearLayout.setVisibility(8);
                    linearLayout.setOrientation(1);
                    linearLayout.setBackgroundResource(R.drawable.j6s);
                    i16 = aIOFastImageVB.i1();
                    linearLayout.addView(i16);
                    h16 = aIOFastImageVB.h1();
                    linearLayout.addView(h16);
                    return linearLayout;
                }
            });
            this.rootView = lazy3;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) initMsgIntent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView h1() {
        return (ImageView) this.aioFastImage.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView i1() {
        return (TextView) this.fastImageTip.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LinearLayout j1() {
        return (LinearLayout) this.rootView.getValue();
    }

    private final void k1(LocalMediaInfo recentImage) {
        Message message;
        com.tencent.qqnt.qbasealbum.ktx.d.g(h1(), recentImage);
        o1(recentImage);
        MqqHandler mqqHandler = this.handler;
        if (mqqHandler != null) {
            if (mqqHandler != null) {
                message = mqqHandler.obtainMessage(33);
            } else {
                message = null;
            }
            mqqHandler.sendMessageDelayed(message, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m1() {
        if (j1().getVisibility() != 0) {
            QLog.i("fast_image  AIOFastImageVB", 1, "no view");
        } else {
            n1(false);
        }
    }

    private final void n1(boolean isFadeIn) {
        AlphaAnimation alphaAnimation;
        if (isFadeIn) {
            alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        } else {
            alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setAnimationListener(new c());
        }
        j1().setAnimation(alphaAnimation);
        alphaAnimation.setDuration(500L);
        alphaAnimation.setFillAfter(true);
        j1().startAnimation(alphaAnimation);
    }

    private final void o1(final LocalMediaInfo recentImage) {
        QLog.i("fast_image  AIOFastImageVB", 1, "showFastImage");
        j1().setVisibility(0);
        n1(true);
        j1().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.reserve1.image.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIOFastImageVB.p1(AIOFastImageVB.this, recentImage, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p1(AIOFastImageVB this$0, LocalMediaInfo recentImage, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(recentImage, "$recentImage");
        this$0.sendIntent(new a.C7349a(recentImage));
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.qqnt.aio.lazy.lazyInit.a
    @NotNull
    public com.tencent.qqnt.aio.lazy.lazyInit.b<d, Reserve1UIState> b1(@NotNull MsgIntent initIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.qqnt.aio.lazy.lazyInit.b) iPatchRedirector.redirect((short) 4, (Object) this, (Object) initIntent);
        }
        Intrinsics.checkNotNullParameter(initIntent, "initIntent");
        return new AIOFastImageVM(initIntent);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        j1().setVisibility(8);
        if (this.handler == null) {
            this.handler = new b();
        }
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: l1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull Reserve1UIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (QLog.isColorLevel()) {
            QLog.i("fast_image  AIOFastImageVB", 2, "state: " + state);
        }
        if (state instanceof AIOFastImageUIState.ShowFastImage) {
            QLog.i("fast_image  AIOFastImageVB", 1, "need to show fast image");
            k1(((AIOFastImageUIState.ShowFastImage) state).a());
        } else if (state instanceof AIOFastImageUIState.RemoveFastImage) {
            QLog.i("fast_image  AIOFastImageVB", 1, "need to remove fast image");
            MqqHandler mqqHandler = this.handler;
            if (mqqHandler != null) {
                mqqHandler.removeMessages(33);
            }
            m1();
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        return j1();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onDestroy();
        MqqHandler mqqHandler = this.handler;
        if (mqqHandler != null) {
            if (mqqHandler != null) {
                mqqHandler.removeCallbacksAndMessages(null);
            }
            this.handler = null;
        }
    }
}
