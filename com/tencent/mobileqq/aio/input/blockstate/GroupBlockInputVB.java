package com.tencent.mobileqq.aio.input.blockstate;

import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.input.blockstate.GroupBlockUIState;
import com.tencent.mobileqq.aio.input.blockstate.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mvi.mvvm.BaseVM;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\t\u0018\u0000 %2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\bH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016R\u001b\u0010\u0013\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0018\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001d\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\"\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0010\u001a\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/aio/input/blockstate/GroupBlockInputVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/mobileqq/aio/input/blockstate/a;", "Lcom/tencent/mobileqq/aio/input/blockstate/GroupBlockUIState;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/aio/api/runtime/a;", "createVM", "state", "", "h1", "Landroid/widget/FrameLayout;", "d", "Lkotlin/Lazy;", "d1", "()Landroid/widget/FrameLayout;", "blockContainerView", "Landroid/widget/ImageView;", "e", "g1", "()Landroid/widget/ImageView;", "iconView", "Landroid/widget/TextView;", "f", "f1", "()Landroid/widget/TextView;", "blockTextView", "", h.F, "e1", "()Ljava/lang/CharSequence;", "blockTextHintForOwner", "<init>", "()V", "i", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class GroupBlockInputVB extends com.tencent.aio.base.mvvm.a<a, GroupBlockUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy blockContainerView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy iconView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy blockTextView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy blockTextHintForOwner;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0007R\u0014\u0010\u000f\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/aio/input/blockstate/GroupBlockInputVB$a;", "", "", "BLOCK_FOREVER_CLICK_LEN", "I", "", "BLOCK_FOREVER_HINT_TEXT", "Ljava/lang/String;", "BLOCK_HINT_TEXT", "", "ICON_RIGHT_MARGIN", UserInfo.SEX_FEMALE, "ICON_WH", "LINE_HEIGHT", "TAG", "TEXT_LINE_HEIGHT", "TEXT_SIZE", "VB_HEIGHT", "VB_HOR_PAD", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.input.blockstate.GroupBlockInputVB$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53478);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public GroupBlockInputVB() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.mobileqq.aio.input.blockstate.GroupBlockInputVB$blockContainerView$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupBlockInputVB.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final FrameLayout invoke() {
                    ImageView g16;
                    TextView f16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (FrameLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    FrameLayout frameLayout = new FrameLayout(GroupBlockInputVB.this.getMContext());
                    GroupBlockInputVB groupBlockInputVB = GroupBlockInputVB.this;
                    frameLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, ViewUtils.dip2px(129.0f)));
                    frameLayout.setBackgroundColor(groupBlockInputVB.getMContext().getColor(R.color.qui_common_bg_nav_aio));
                    LinearLayout linearLayout = new LinearLayout(groupBlockInputVB.getMContext());
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 17;
                    linearLayout.setLayoutParams(layoutParams);
                    int dip2px = ViewUtils.dip2px(32.0f);
                    linearLayout.setPadding(dip2px, 0, dip2px, 0);
                    g16 = groupBlockInputVB.g1();
                    linearLayout.addView(g16);
                    f16 = groupBlockInputVB.f1();
                    linearLayout.addView(f16);
                    frameLayout.addView(linearLayout);
                    View textView = new TextView(groupBlockInputVB.getMContext());
                    textView.setLayoutParams(new FrameLayout.LayoutParams(-1, ViewUtils.dip2px(0.5f)));
                    textView.setBackgroundColor(groupBlockInputVB.getMContext().getColor(R.color.qui_common_border_standard));
                    frameLayout.addView(textView);
                    return frameLayout;
                }
            });
            this.blockContainerView = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.aio.input.blockstate.GroupBlockInputVB$iconView$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupBlockInputVB.this);
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
                    ImageView imageView = new ImageView(GroupBlockInputVB.this.getMContext());
                    int dip2px = ViewUtils.dip2px(20.0f);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dip2px, dip2px);
                    layoutParams.rightMargin = ViewUtils.dip2px(6.0f);
                    imageView.setLayoutParams(layoutParams);
                    imageView.setImageResource(R.drawable.qui_caution_circle_icon_secondary);
                    return imageView;
                }
            });
            this.iconView = lazy2;
            lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.aio.input.blockstate.GroupBlockInputVB$blockTextView$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupBlockInputVB.this);
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
                    TextView textView = new TextView(GroupBlockInputVB.this.getMContext());
                    GroupBlockInputVB groupBlockInputVB = GroupBlockInputVB.this;
                    textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                    textView.setIncludeFontPadding(false);
                    textView.setLineSpacing(ViewUtils.dip2px(6.0f), 1.0f);
                    textView.setTextSize(0, ViewUtils.dip2px(16.0f));
                    textView.setTextColor(groupBlockInputVB.getMContext().getColor(R.color.qui_common_text_secondary));
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                    return textView;
                }
            });
            this.blockTextView = lazy3;
            lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<SpannableString>() { // from class: com.tencent.mobileqq.aio.input.blockstate.GroupBlockInputVB$blockTextHintForOwner$2
                static IPatchRedirector $redirector_;

                /* compiled from: P */
                @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/aio/input/blockstate/GroupBlockInputVB$blockTextHintForOwner$2$a", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "Landroid/text/TextPaint;", "ds", "updateDrawState", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
                /* loaded from: classes10.dex */
                public static final class a extends ClickableSpan {
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ GroupBlockInputVB f189332d;

                    a(GroupBlockInputVB groupBlockInputVB) {
                        this.f189332d = groupBlockInputVB;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) groupBlockInputVB);
                        }
                    }

                    @Override // android.text.style.ClickableSpan
                    public void onClick(@NotNull View widget) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) widget);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(widget, "widget");
                        if (!FastClickUtils.isFastDoubleClick("GroupBlockInputVB")) {
                            this.f189332d.sendIntent(a.C7259a.f189340d);
                        }
                    }

                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(@NotNull TextPaint ds5) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                            iPatchRedirector.redirect((short) 3, (Object) this, (Object) ds5);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(ds5, "ds");
                        super.updateDrawState(ds5);
                        ds5.setUnderlineText(false);
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupBlockInputVB.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final SpannableString invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (SpannableString) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    SpannableString spannableString = new SpannableString("\u8be5\u7fa4\u56e0\u6d89\u53ca\u8fdd\u53cd\u76f8\u5173\u6761\u4f8b\uff0c\u5df2\u88ab\u5c01\u7981\u3002\n\u5efa\u8bae\u5c3d\u5feb\u53bb\u5904\u7406");
                    a aVar = new a(GroupBlockInputVB.this);
                    ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(GroupBlockInputVB.this.getMContext().getColor(R.color.qui_common_text_link));
                    spannableString.setSpan(aVar, 22, 25, 33);
                    spannableString.setSpan(foregroundColorSpan, 22, 25, 33);
                    return spannableString;
                }
            });
            this.blockTextHintForOwner = lazy4;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final FrameLayout d1() {
        return (FrameLayout) this.blockContainerView.getValue();
    }

    private final CharSequence e1() {
        return (CharSequence) this.blockTextHintForOwner.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView f1() {
        return (TextView) this.blockTextView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView g1() {
        return (ImageView) this.iconView.getValue();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public BaseVM<a, GroupBlockUIState, com.tencent.aio.api.runtime.a> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (BaseVM) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new d();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: h1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull GroupBlockUIState state) {
        CharSequence charSequence;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof GroupBlockUIState.GroupBlockChange) {
            TextView f16 = f1();
            if (((GroupBlockUIState.GroupBlockChange) state).a()) {
                charSequence = e1();
            } else {
                charSequence = "\u65e0\u6cd5\u5728\u5df2\u5c01\u7981\u7684\u7fa4\u804a\u4e2d\u53d1\u9001\u6d88\u606f";
            }
            f16.setText(charSequence);
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
        return d1();
    }
}
