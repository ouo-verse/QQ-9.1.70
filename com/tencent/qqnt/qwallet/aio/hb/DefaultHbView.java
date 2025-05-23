package com.tencent.qqnt.qwallet.aio.hb;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010G\u001a\u00020F\u00a2\u0006\u0004\bH\u0010IJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0014J\b\u0010\u000b\u001a\u00020\u0003H\u0014J\b\u0010\f\u001a\u00020\u0003H\u0014J\b\u0010\r\u001a\u00020\u0003H\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\bH\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001f\u001a\u00020\u00188\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010'\u001a\u00020 8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010+\u001a\u00020 8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b(\u0010\"\u001a\u0004\b)\u0010$\"\u0004\b*\u0010&R\u001b\u00101\u001a\u00020,8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001a\u00106\u001a\u00020\b8\u0014X\u0094D\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001a\u0010;\u001a\u0002078\u0014X\u0094\u0004\u00a2\u0006\f\n\u0004\b8\u00102\u001a\u0004\b9\u0010:R\u001a\u0010>\u001a\u0002078\u0014X\u0094\u0004\u00a2\u0006\f\n\u0004\b<\u00102\u001a\u0004\b=\u0010:R\u001a\u0010A\u001a\u0002078\u0014X\u0094\u0004\u00a2\u0006\f\n\u0004\b?\u00102\u001a\u0004\b@\u0010:R\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020\b0B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010D\u00a8\u0006J"}, d2 = {"Lcom/tencent/qqnt/qwallet/aio/hb/DefaultHbView;", "Lcom/tencent/qqnt/qwallet/aio/hb/AbstractHbView;", "Landroidx/lifecycle/LifecycleObserver;", "", "initView", "Landroid/view/View;", "E0", "z0", "", "title", "X0", "D0", "K0", "L0", "stateText", "I0", "Lcom/tencent/qqnt/qwallet/aio/hb/RedPacketCover;", "D", "Lcom/tencent/qqnt/qwallet/aio/hb/RedPacketCover;", "P0", "()Lcom/tencent/qqnt/qwallet/aio/hb/RedPacketCover;", "Y0", "(Lcom/tencent/qqnt/qwallet/aio/hb/RedPacketCover;)V", "coverView", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "U0", "()Landroid/widget/ImageView;", "b1", "(Landroid/widget/ImageView;)V", "topIconView", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "R0", "()Landroid/widget/TextView;", "Z0", "(Landroid/widget/TextView;)V", "mainTitleView", "G", "S0", ICustomDataEditor.STRING_ARRAY_PARAM_1, "tailView", "Lcom/tencent/qqnt/qwallet/aio/hb/j;", "H", "Lkotlin/Lazy;", "W0", "()Lcom/tencent/qqnt/qwallet/aio/hb/j;", "viewModel", "I", "Ljava/lang/String;", "V0", "()Ljava/lang/String;", "typeText", "", "J", "Q0", "()I", "layoutResId", "K", "O0", "bgResId", "L", "T0", "topIconResId", "Landroidx/lifecycle/Observer;", "M", "Landroidx/lifecycle/Observer;", "titleObserver", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public class DefaultHbView extends AbstractHbView {

    /* renamed from: D, reason: from kotlin metadata */
    protected RedPacketCover coverView;

    /* renamed from: E, reason: from kotlin metadata */
    protected ImageView topIconView;

    /* renamed from: F, reason: from kotlin metadata */
    protected TextView mainTitleView;

    /* renamed from: G, reason: from kotlin metadata */
    protected TextView tailView;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final String typeText;

    /* renamed from: J, reason: from kotlin metadata */
    private final int layoutResId;

    /* renamed from: K, reason: from kotlin metadata */
    private final int bgResId;

    /* renamed from: L, reason: from kotlin metadata */
    private final int topIconResId;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Observer<String> titleObserver;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultHbView(@NotNull Context context) {
        super(context);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<j>() { // from class: com.tencent.qqnt.qwallet.aio.hb.DefaultHbView$viewModel$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final j invoke() {
                return new j();
            }
        });
        this.viewModel = lazy;
        this.typeText = "QQ\u7ea2\u5305";
        this.layoutResId = R.layout.hhr;
        this.bgResId = R.drawable.fpw;
        this.topIconResId = R.drawable.f162119fq3;
        this.titleObserver = new Observer() { // from class: com.tencent.qqnt.qwallet.aio.hb.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DefaultHbView.c1(DefaultHbView.this, (String) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c1(DefaultHbView this$0, String title) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d(this$0.getTAG(), 1, "titleObserver: this " + this$0.hashCode() + ", title " + title + ", vm " + this$0.W0().hashCode() + ", msgType " + this$0.W0().M1().getMsgType() + ", listId " + this$0.W0().M1().getBillNo());
        Intrinsics.checkNotNullExpressionValue(title, "title");
        this$0.X0(title);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.qwallet.aio.hb.AbstractHbView
    public void D0() {
        super.D0();
        W0().X1().observeForever(this.titleObserver);
    }

    @Override // com.tencent.qqnt.qwallet.aio.hb.AbstractHbView
    @NotNull
    public View E0() {
        return P0();
    }

    @Override // com.tencent.qqnt.qwallet.aio.hb.AbstractHbView
    public void I0(@NotNull String stateText) {
        Intrinsics.checkNotNullParameter(stateText, "stateText");
        P0().getStateView().setText(stateText);
        P0().getMaskView().setVisibility(0);
        P0().setForeground(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.qwallet.aio.hb.AbstractHbView
    public void K0() {
        super.K0();
        W0().X1().removeObserver(this.titleObserver);
    }

    @Override // com.tencent.qqnt.qwallet.aio.hb.AbstractHbView
    public void L0() {
        P0().getBgView().setImageResource(getBgResId());
        ImageView openIcon = P0().getOpenIcon();
        openIcon.setVisibility(0);
        ViewGroup.MarginLayoutParams marginLayoutParams = null;
        ((IQWalletHbApi) QRoute.api(IQWalletHbApi.class)).updateOpenIcon(openIcon, null);
        P0().getStateView().setText("");
        P0().getMaskView().setVisibility(8);
        U0().setImageResource(getTopIconResId());
        R0().setText(W0().M1().getTitle());
        S0().setText(getTypeText());
        if (W0().M1() instanceof rx3.h) {
            S0().setVisibility(8);
            ViewGroup.LayoutParams layoutParams = P0().getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            }
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = ViewUtils.dpToPx(20.0f);
                return;
            }
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = P0().getLayoutParams();
        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
        }
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = ViewUtils.dpToPx(10.0f);
        }
        S0().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: O0, reason: from getter */
    public int getBgResId() {
        return this.bgResId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final RedPacketCover P0() {
        RedPacketCover redPacketCover = this.coverView;
        if (redPacketCover != null) {
            return redPacketCover;
        }
        Intrinsics.throwUninitializedPropertyAccessException("coverView");
        return null;
    }

    /* renamed from: Q0, reason: from getter */
    protected int getLayoutResId() {
        return this.layoutResId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final TextView R0() {
        TextView textView = this.mainTitleView;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mainTitleView");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final TextView S0() {
        TextView textView = this.tailView;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tailView");
        return null;
    }

    /* renamed from: T0, reason: from getter */
    protected int getTopIconResId() {
        return this.topIconResId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final ImageView U0() {
        ImageView imageView = this.topIconView;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("topIconView");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: V0, reason: from getter */
    public String getTypeText() {
        return this.typeText;
    }

    @Override // com.tencent.qqnt.qwallet.aio.hb.AbstractHbView
    @NotNull
    public j W0() {
        return (j) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void X0(@NotNull String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        R0().setText(title);
    }

    protected final void Y0(@NotNull RedPacketCover redPacketCover) {
        Intrinsics.checkNotNullParameter(redPacketCover, "<set-?>");
        this.coverView = redPacketCover;
    }

    protected final void Z0(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.mainTitleView = textView;
    }

    protected final void a1(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tailView = textView;
    }

    protected final void b1(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.topIconView = imageView;
    }

    @Override // com.tencent.qqnt.qwallet.aio.hb.AbstractHbView
    public void initView() {
        QLog.d(getTAG(), 1, "initView: ");
        View.inflate(getContext(), getLayoutResId(), this);
        View findViewById = findViewById(R.id.x6i);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.hb_envelope)");
        Y0((RedPacketCover) findViewById);
        View findViewById2 = findViewById(R.id.f99905r2);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.top_icon_view)");
        b1((ImageView) findViewById2);
        View findViewById3 = findViewById(R.id.ywl);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.main_title_view)");
        Z0((TextView) findViewById3);
        View findViewById4 = findViewById(R.id.x7f);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.hb_tail_view)");
        a1((TextView) findViewById4);
    }

    @Override // com.tencent.qqnt.qwallet.aio.AIOContentView
    @Nullable
    public View z0() {
        if (this.coverView != null) {
            return P0();
        }
        return null;
    }
}
