package com.tencent.qqnt.aio.mycomputer;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import com.tencent.aio.base.tool.a;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.IFeatureServiceProxy;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.mycomputer.MyComputerUIState;
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
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 52\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00016B\u0007\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\u001c\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0003H\u0016R\u001b\u0010\u001f\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001b\u0010'\u001a\u00020#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010\u001c\u001a\u0004\b%\u0010&R\u001b\u0010,\u001a\u00020(8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010\u001c\u001a\u0004\b*\u0010+R\u001b\u0010/\u001a\u00020(8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010\u001c\u001a\u0004\b.\u0010+R\u0014\u00102\u001a\u00020\u00068\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u00067"}, d2 = {"Lcom/tencent/qqnt/aio/mycomputer/MyComputerBackgroundVB;", "Lcom/tencent/aio/base/mvvm/a;", "", "Lcom/tencent/qqnt/aio/mycomputer/MyComputerUIState;", "", "g1", "", "stop", "l1", "Landroid/view/View;", "view", "toRemove", "q1", "", "drawable", "text", ICustomDataEditor.NUMBER_PARAM_1, "o1", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/aio/api/runtime/a;", "createVM", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "state", "p1", "Landroid/widget/FrameLayout;", "d", "Lkotlin/Lazy;", "h1", "()Landroid/widget/FrameLayout;", "bgViewContainer", "e", "Landroid/view/View;", "bgView", "Landroid/widget/ImageView;", "f", "i1", "()Landroid/widget/ImageView;", "infoImage", "Landroid/widget/TextView;", h.F, "j1", "()Landroid/widget/TextView;", "infoTextView", "i", "k1", "tipsTextView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "isShowNewBg", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class MyComputerBackgroundVB extends com.tencent.aio.base.mvvm.a<Object, MyComputerUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy bgViewContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View bgView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy infoImage;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy infoTextView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy tipsTextView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final boolean isShowNewBg;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/mycomputer/MyComputerBackgroundVB$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.mycomputer.MyComputerBackgroundVB$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/aio/mycomputer/MyComputerBackgroundVB$b", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MyComputerBackgroundVB.this);
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            MyComputerBackgroundVB.this.i1().getViewTreeObserver().removeOnGlobalLayoutListener(this);
            ViewGroup.LayoutParams layoutParams = MyComputerBackgroundVB.this.j1().getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            int height = MyComputerBackgroundVB.this.i1().getHeight() + MyComputerBackgroundVB.this.i1().getTop();
            a.Companion companion = com.tencent.aio.base.tool.a.INSTANCE;
            layoutParams2.topMargin = height + companion.b(MyComputerBackgroundVB.this.getMContext(), 10);
            MyComputerBackgroundVB.this.j1().setLayoutParams(layoutParams2);
            ViewGroup.LayoutParams layoutParams3 = MyComputerBackgroundVB.this.k1().getLayoutParams();
            Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
            layoutParams4.topMargin = MyComputerBackgroundVB.this.i1().getHeight() + MyComputerBackgroundVB.this.i1().getTop() + MyComputerBackgroundVB.this.j1().getHeight() + MyComputerBackgroundVB.this.j1().getTop() + companion.b(MyComputerBackgroundVB.this.getMContext(), 5);
            MyComputerBackgroundVB.this.k1().setLayoutParams(layoutParams4);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60330);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public MyComputerBackgroundVB() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.qqnt.aio.mycomputer.MyComputerBackgroundVB$bgViewContainer$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MyComputerBackgroundVB.this);
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
                    FrameLayout frameLayout = new FrameLayout(MyComputerBackgroundVB.this.getMContext());
                    MyComputerBackgroundVB myComputerBackgroundVB = MyComputerBackgroundVB.this;
                    frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    frameLayout.setId(R.id.vgi);
                    frameLayout.setBackgroundColor(myComputerBackgroundVB.getMContext().getResources().getColor(R.color.qui_common_bg_aio_01));
                    return frameLayout;
                }
            });
            this.bgViewContainer = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.qqnt.aio.mycomputer.MyComputerBackgroundVB$infoImage$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MyComputerBackgroundVB.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final ImageView invoke() {
                    boolean z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (ImageView) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    ImageView imageView = new ImageView(MyComputerBackgroundVB.this.getMContext());
                    MyComputerBackgroundVB myComputerBackgroundVB = MyComputerBackgroundVB.this;
                    imageView.setId(R.id.udm);
                    z16 = myComputerBackgroundVB.isShowNewBg;
                    if (z16) {
                        int intValue = ((Number) com.tencent.aio.view_dsl.dsl.c.e(120)).intValue();
                        if (imageView.getLayoutParams() == null) {
                            imageView.setLayoutParams(new ViewGroup.LayoutParams(intValue, 0));
                        } else {
                            imageView.getLayoutParams().width = intValue;
                        }
                        int intValue2 = ((Number) com.tencent.aio.view_dsl.dsl.c.e(120)).intValue();
                        if (imageView.getLayoutParams() == null) {
                            imageView.setLayoutParams(new ViewGroup.LayoutParams(0, intValue2));
                        } else {
                            imageView.getLayoutParams().height = intValue2;
                        }
                    } else {
                        int intValue3 = ((Number) com.tencent.aio.view_dsl.dsl.c.e(225)).intValue();
                        if (imageView.getLayoutParams() == null) {
                            imageView.setLayoutParams(new ViewGroup.LayoutParams(intValue3, 0));
                        } else {
                            imageView.getLayoutParams().width = intValue3;
                        }
                        int intValue4 = ((Number) com.tencent.aio.view_dsl.dsl.c.e(75)).intValue();
                        if (imageView.getLayoutParams() == null) {
                            imageView.setLayoutParams(new ViewGroup.LayoutParams(0, intValue4));
                        } else {
                            imageView.getLayoutParams().height = intValue4;
                        }
                    }
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    com.tencent.aio.view_dsl.dsl.f.p(imageView, com.tencent.aio.view_dsl.dsl.b.e());
                    com.tencent.aio.view_dsl.dsl.f.n(imageView, true);
                    imageView.setImageDrawable(AppCompatResources.getDrawable(imageView.getContext(), R.drawable.dataline_info));
                    imageView.setVisibility(8);
                    return imageView;
                }
            });
            this.infoImage = lazy2;
            lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.qqnt.aio.mycomputer.MyComputerBackgroundVB$infoTextView$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MyComputerBackgroundVB.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final TextView invoke() {
                    boolean z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (TextView) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    TextView textView = new TextView(MyComputerBackgroundVB.this.getMContext());
                    MyComputerBackgroundVB myComputerBackgroundVB = MyComputerBackgroundVB.this;
                    textView.setId(R.id.udn);
                    int p16 = com.tencent.aio.view_dsl.dsl.b.p();
                    if (textView.getLayoutParams() == null) {
                        textView.setLayoutParams(new ViewGroup.LayoutParams(p16, 0));
                    } else {
                        textView.getLayoutParams().width = p16;
                    }
                    int p17 = com.tencent.aio.view_dsl.dsl.b.p();
                    if (textView.getLayoutParams() == null) {
                        textView.setLayoutParams(new ViewGroup.LayoutParams(0, p17));
                    } else {
                        textView.getLayoutParams().height = p17;
                    }
                    textView.setGravity(com.tencent.aio.view_dsl.dsl.b.e());
                    com.tencent.aio.view_dsl.dsl.f.n(textView, true);
                    textView.setVisibility(8);
                    z16 = myComputerBackgroundVB.isShowNewBg;
                    if (z16) {
                        textView.setTextSize(0, ((Number) com.tencent.aio.view_dsl.dsl.c.e(17)).floatValue());
                        textView.setText(R.string.f170732lu);
                        textView.setTextColor(ContextCompat.getColor(textView.getContext(), R.color.qui_common_text_primary));
                        textView.setTypeface(textView.getTypeface(), 1);
                    } else {
                        textView.setText(R.string.zqe);
                        textView.setTextSize(0, ((Number) com.tencent.aio.view_dsl.dsl.c.e(16)).floatValue());
                        textView.setTextColor(ContextCompat.getColor(textView.getContext(), R.color.qui_common_text_secondary));
                    }
                    return textView;
                }
            });
            this.infoTextView = lazy3;
            lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.qqnt.aio.mycomputer.MyComputerBackgroundVB$tipsTextView$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MyComputerBackgroundVB.this);
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
                    TextView textView = new TextView(MyComputerBackgroundVB.this.getMContext());
                    int p16 = com.tencent.aio.view_dsl.dsl.b.p();
                    if (textView.getLayoutParams() == null) {
                        textView.setLayoutParams(new ViewGroup.LayoutParams(p16, 0));
                    } else {
                        textView.getLayoutParams().width = p16;
                    }
                    int p17 = com.tencent.aio.view_dsl.dsl.b.p();
                    if (textView.getLayoutParams() == null) {
                        textView.setLayoutParams(new ViewGroup.LayoutParams(0, p17));
                    } else {
                        textView.getLayoutParams().height = p17;
                    }
                    textView.setGravity(com.tencent.aio.view_dsl.dsl.b.e());
                    com.tencent.aio.view_dsl.dsl.f.n(textView, true);
                    textView.setText(R.string.zqf);
                    textView.setTextSize(0, ((Number) com.tencent.aio.view_dsl.dsl.c.e(14)).floatValue());
                    textView.setTextColor(ContextCompat.getColor(textView.getContext(), R.color.qui_common_text_secondary));
                    textView.setVisibility(8);
                    return textView;
                }
            });
            this.tipsTextView = lazy4;
            this.isShowNewBg = true;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final void g1() {
        i1().getViewTreeObserver().addOnGlobalLayoutListener(new b());
    }

    private final FrameLayout h1() {
        return (FrameLayout) this.bgViewContainer.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView i1() {
        return (ImageView) this.infoImage.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView j1() {
        return (TextView) this.infoTextView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView k1() {
        return (TextView) this.tipsTextView.getValue();
    }

    private final void l1(final boolean stop) {
        View view = this.bgView;
        if (!(view instanceof com.tencent.qqnt.aio.api.b)) {
            QLog.i("MyComputerBackgroundVB", 1, "handleAIOBackgroundPlayEvent --> the view: " + view + " is not aio backgroundView, return");
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.aio.mycomputer.b
            @Override // java.lang.Runnable
            public final void run() {
                MyComputerBackgroundVB.m1(MyComputerBackgroundVB.this, stop);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m1(MyComputerBackgroundVB this$0, boolean z16) {
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
        QLog.i("MyComputerBackgroundVB", 1, "handleAIOBackgroundPlayEvent --> stop: " + z16 + ", scrollPauseAnim: " + isFeatureSwitchOn + ", bgView: " + i3);
        if (isFeatureSwitchOn) {
            if (z16) {
                bVar.backgroundPause();
            } else {
                bVar.backgroundResume();
            }
        }
    }

    private final void n1(int drawable, int text) {
        QLog.d("MyComputerBackgroundVB", 1, "handleAddBackgroundView");
        g1();
        i1().setImageResource(drawable);
        j1().setText(text);
        i1().setVisibility(0);
        j1().setVisibility(0);
        if (this.isShowNewBg) {
            k1().setVisibility(0);
        }
    }

    private final void o1() {
        QLog.d("MyComputerBackgroundVB", 1, "handleRemoveBackgroundView");
        i1().setVisibility(8);
        j1().setVisibility(8);
        k1().setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void q1(View view, boolean toRemove) {
        boolean z16;
        if (!(view instanceof com.tencent.qqnt.aio.api.b)) {
            QLog.i("MyComputerBackgroundVB", 1, "the view: " + view + " is not aio backgroundView, forbid to add");
            return;
        }
        if (!QQTheme.isVasTheme()) {
            QLog.i("MyComputerBackgroundVB", 1, "this is not vas theme, do not update background!");
            return;
        }
        boolean z17 = false;
        if (!toRemove) {
            if (h1().indexOfChild(view) != -1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                View view2 = this.bgView;
                if (view2 != null) {
                    h1().removeView(view2);
                }
                if (view.getParent() != null) {
                    QLog.i("MyComputerBackgroundVB", 1, "view parent is not null: " + view.getParent() + ", forbid to add view: " + view);
                    return;
                }
                h1().addView(view, 0);
                this.bgView = view;
                QLog.i("MyComputerBackgroundVB", 1, "change background view: " + view + ", toRemove? " + toRemove + ",  type: " + ((com.tencent.qqnt.aio.api.b) view).type());
            }
        }
        if (h1().indexOfChild(view) != -1) {
            z17 = true;
        }
        if (z17) {
            h1().removeView(view);
        }
        this.bgView = view;
        QLog.i("MyComputerBackgroundVB", 1, "change background view: " + view + ", toRemove? " + toRemove + ",  type: " + ((com.tencent.qqnt.aio.api.b) view).type());
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    public BaseVM<Object, MyComputerUIState, com.tencent.aio.api.runtime.a> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (BaseVM) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new c();
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        FrameLayout.LayoutParams layoutParams;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        if (this.isShowNewBg) {
            a.Companion companion = com.tencent.aio.base.tool.a.INSTANCE;
            layoutParams = new FrameLayout.LayoutParams(companion.b(getMContext(), 120), companion.b(getMContext(), 120));
        } else {
            a.Companion companion2 = com.tencent.aio.base.tool.a.INSTANCE;
            layoutParams = new FrameLayout.LayoutParams(companion2.b(getMContext(), 225), companion2.b(getMContext(), 75));
        }
        layoutParams.gravity = com.tencent.aio.view_dsl.dsl.b.e();
        h1().addView(i1(), layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(com.tencent.aio.view_dsl.dsl.b.p(), com.tencent.aio.view_dsl.dsl.b.p());
        layoutParams2.gravity = com.tencent.aio.view_dsl.dsl.b.f();
        h1().addView(j1(), layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(com.tencent.aio.view_dsl.dsl.b.p(), com.tencent.aio.view_dsl.dsl.b.p());
        layoutParams3.gravity = com.tencent.aio.view_dsl.dsl.b.f();
        h1().addView(k1(), layoutParams3);
        g1();
        return h1();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: p1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull MyComputerUIState state) {
        boolean areEqual;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        boolean z16 = true;
        if (state instanceof MyComputerUIState.AddPCBackgroundView) {
            areEqual = true;
        } else {
            areEqual = Intrinsics.areEqual(state, MyComputerUIState.AddPadBackgroundView.f351661d);
        }
        if (!areEqual) {
            z16 = Intrinsics.areEqual(state, MyComputerUIState.AddPhoneBackgroundView.f351662d);
        }
        if (z16) {
            if (this.isShowNewBg) {
                n1(R.drawable.qui_qq_transfer, R.string.f170732lu);
                return;
            } else {
                n1(R.drawable.dataline_info, R.string.zqe);
                return;
            }
        }
        if (state instanceof MyComputerUIState.RemoveBackgroundView) {
            o1();
            return;
        }
        if (state instanceof MyComputerUIState.UpdateAIOBackgroundView) {
            MyComputerUIState.UpdateAIOBackgroundView updateAIOBackgroundView = (MyComputerUIState.UpdateAIOBackgroundView) state;
            q1(updateAIOBackgroundView.b(), updateAIOBackgroundView.a());
        } else if (state instanceof MyComputerUIState.UpdateAIOBackgroundPlayEvent) {
            l1(((MyComputerUIState.UpdateAIOBackgroundPlayEvent) state).a());
        }
    }
}
