package com.tencent.mobileqq.aio.input.longshot;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.input.longshot.LongShotUIState;
import com.tencent.mobileqq.aio.input.longshot.c;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.x;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 52\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u00016B\u0007\u00a2\u0006\u0004\b3\u00104J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016J\u0014\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0010H\u0016R\u001b\u0010\u001e\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010!\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010\u001b\u001a\u0004\b \u0010\u001dR\u001b\u0010&\u001a\u00020\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010\u001b\u001a\u0004\b$\u0010%R\u001b\u0010+\u001a\u00020'8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b(\u0010\u001b\u001a\u0004\b)\u0010*R\u001b\u0010.\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010\u001b\u001a\u0004\b-\u0010\u001dR\u001b\u00102\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b/\u0010\u001b\u001a\u0004\b0\u00101\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/aio/input/longshot/LongShotBarVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/mobileqq/aio/input/longshot/c;", "Lcom/tencent/mobileqq/aio/input/longshot/LongShotUIState;", "Landroid/view/View$OnClickListener;", "Landroid/content/Context;", "context", "Landroid/widget/LinearLayout;", "barContainer", "", "l1", "", "isEnabled", "k1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "bindViewAndData", "Lcom/tencent/aio/base/mvvm/b;", "c1", "state", "j1", "v", NodeProps.ON_CLICK, "Landroid/widget/TextView;", "d", "Lkotlin/Lazy;", "g1", "()Landroid/widget/TextView;", "mBtnPreview", "e", "e1", "mBtnEdit", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "f", "i1", "()Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "mMosaicCheckBox", "Lcom/tencent/biz/qui/quibutton/QUIButton;", h.F, "d1", "()Lcom/tencent/biz/qui/quibutton/QUIButton;", "mBtnComplete", "i", "f1", "mBtnMosaic", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "h1", "()Landroid/widget/LinearLayout;", "mLongShotBar", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class LongShotBarVB extends com.tencent.aio.base.mvvm.a<c, LongShotUIState> implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mBtnPreview;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mBtnEdit;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mMosaicCheckBox;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mBtnComplete;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mBtnMosaic;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mLongShotBar;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/input/longshot/LongShotBarVB$a;", "", "", "EM_BAS_SCREENSHOT_STATE", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.input.longshot.LongShotBarVB$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56182);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public LongShotBarVB() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.aio.input.longshot.LongShotBarVB$mBtnPreview$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LongShotBarVB.this);
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
                    TextView textView = new TextView(LongShotBarVB.this.getMContext());
                    textView.setOnClickListener(LongShotBarVB.this);
                    return textView;
                }
            });
            this.mBtnPreview = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.aio.input.longshot.LongShotBarVB$mBtnEdit$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LongShotBarVB.this);
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
                    TextView textView = new TextView(LongShotBarVB.this.getMContext());
                    textView.setOnClickListener(LongShotBarVB.this);
                    return textView;
                }
            });
            this.mBtnEdit = lazy2;
            lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<QUICheckBox>() { // from class: com.tencent.mobileqq.aio.input.longshot.LongShotBarVB$mMosaicCheckBox$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LongShotBarVB.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final QUICheckBox invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (QUICheckBox) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    QUICheckBox qUICheckBox = new QUICheckBox(LongShotBarVB.this.getMContext());
                    qUICheckBox.setOnClickListener(LongShotBarVB.this);
                    return qUICheckBox;
                }
            });
            this.mMosaicCheckBox = lazy3;
            lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<QUIButton>() { // from class: com.tencent.mobileqq.aio.input.longshot.LongShotBarVB$mBtnComplete$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LongShotBarVB.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final QUIButton invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (QUIButton) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    QUIButton qUIButton = new QUIButton(LongShotBarVB.this.getMContext());
                    qUIButton.setOnClickListener(LongShotBarVB.this);
                    return qUIButton;
                }
            });
            this.mBtnComplete = lazy4;
            lazy5 = LazyKt__LazyJVMKt.lazy(new LongShotBarVB$mBtnMosaic$2(this));
            this.mBtnMosaic = lazy5;
            lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.mobileqq.aio.input.longshot.LongShotBarVB$mLongShotBar$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LongShotBarVB.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final LinearLayout invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (LinearLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    LinearLayout linearLayout = new LinearLayout(LongShotBarVB.this.getMContext());
                    linearLayout.setOrientation(0);
                    linearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, ViewUtils.dip2px(60.0f)));
                    return linearLayout;
                }
            });
            this.mLongShotBar = lazy6;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final QUIButton d1() {
        return (QUIButton) this.mBtnComplete.getValue();
    }

    private final TextView e1() {
        return (TextView) this.mBtnEdit.getValue();
    }

    private final TextView f1() {
        return (TextView) this.mBtnMosaic.getValue();
    }

    private final TextView g1() {
        return (TextView) this.mBtnPreview.getValue();
    }

    private final LinearLayout h1() {
        return (LinearLayout) this.mLongShotBar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QUICheckBox i1() {
        return (QUICheckBox) this.mMosaicCheckBox.getValue();
    }

    private final void k1(boolean isEnabled) {
        g1().setEnabled(isEnabled);
        e1().setEnabled(isEnabled);
        i1().setEnabled(isEnabled);
        f1().setEnabled(isEnabled);
        d1().setEnabled(isEnabled);
    }

    private final void l1(Context context, LinearLayout barContainer) {
        barContainer.removeAllViews();
        barContainer.setGravity(16);
        barContainer.setOrientation(0);
        barContainer.setLayoutParams(new RelativeLayout.LayoutParams(-1, x.a(60.0f)));
        g1().setId(R.id.au8);
        g1().setText(R.string.f170247k7);
        g1().setTextSize(1, 14.0f);
        g1().setTextColor(AppCompatResources.getColorStateList(context, R.color.a_));
        int a16 = x.a(16.0f);
        int a17 = x.a(12.0f);
        g1().setPadding(a16, 0, a17, 0);
        g1().setGravity(17);
        g1().setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        com.tencent.qqnt.util.b bVar = com.tencent.qqnt.util.b.f362976b;
        if (bVar.enableTalkBack()) {
            AccessibilityUtil.p(g1(), g1().getText());
        }
        barContainer.addView(g1());
        e1().setId(R.id.au5);
        e1().setText(R.string.f170245k5);
        e1().setTextSize(1, 14.0f);
        e1().setTextColor(AppCompatResources.getColorStateList(context, R.color.a_));
        e1().setPadding(a17, 0, a17, 0);
        e1().setGravity(17);
        e1().setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        if (bVar.enableTalkBack()) {
            AccessibilityUtil.p(e1(), e1().getText());
        }
        barContainer.addView(e1());
        i1().setId(R.id.au7);
        i1().setType(0);
        i1().setSizeType(2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewUtils.dpToPx(16.0f), ViewUtils.dpToPx(16.0f));
        layoutParams.leftMargin = a17;
        i1().setLayoutParams(layoutParams);
        if (bVar.enableTalkBack()) {
            i1().setContentDescription(i1().getText());
        }
        barContainer.addView(i1());
        f1().setId(R.id.au6);
        f1().setText(R.string.f170246k6);
        f1().setTextSize(1, 14.0f);
        f1().setTextColor(AppCompatResources.getColorStateList(context, R.color.a_));
        f1().setPadding(x.a(3.0f), 0, a17, 0);
        f1().setGravity(17);
        f1().setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        if (bVar.enableTalkBack()) {
            f1().setContentDescription(f1().getText());
        }
        barContainer.addView(f1());
        View textView = new TextView(context);
        textView.setId(R.id.au9);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1);
        layoutParams2.weight = 1.0f;
        textView.setLayoutParams(layoutParams2);
        barContainer.addView(textView);
        d1().setId(R.id.f164773au4);
        d1().setType(0);
        d1().setSizeType(2);
        d1().setText(R.string.f170244k4);
        d1().setTextColor(AppCompatResources.getColorStateList(context, R.color.qui_button_text_primary));
        d1().setPadding(a17, 0, a17, 0);
        d1().setGravity(17);
        d1().setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.d_6));
        d1().setTypeface(d1().getTypeface(), 1);
        d1().setBackground(ee0.b.g().a(context, 0, 2, 1000));
        if (bVar.enableTalkBack()) {
            d1().setContentDescription(d1().getText());
        }
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(ViewUtils.dpToPx(60.0f), ViewUtils.dpToPx(29.0f));
        layoutParams3.rightMargin = a16;
        layoutParams3.leftMargin = a16;
        barContainer.addView(d1(), layoutParams3);
        com.tencent.mobileqq.aio.utils.b.f194119a.p("em_bas_screenshot_state");
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.bindViewAndData();
        c.d dVar = new c.d(false);
        sendIntent(dVar);
        if (dVar.a()) {
            h1().setBackgroundColor(getMContext().getColor(R.color.qui_common_bg_bottom_dark));
        } else {
            h1().setBackgroundResource(R.drawable.j7j);
        }
        i1().setChecked(false);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<c, LongShotUIState> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.aio.base.mvvm.b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new b();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: j1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull LongShotUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof LongShotUIState.SetLongShotBarStatus) {
            k1(((LongShotUIState.SetLongShotBarStatus) state).a());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) v3);
        } else {
            Intrinsics.checkNotNullParameter(v3, "v");
            int id5 = v3.getId();
            if (id5 == R.id.au8) {
                sendIntent(new c.e(v3));
            } else if (id5 == R.id.au5) {
                sendIntent(new c.b(v3));
            } else if (id5 == R.id.au7) {
                sendIntent(new c.C7275c(((CheckBox) v3).isChecked()));
            } else if (id5 == R.id.f164773au4) {
                sendIntent(new c.a(v3));
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        l1(getMContext(), h1());
        return h1();
    }
}
