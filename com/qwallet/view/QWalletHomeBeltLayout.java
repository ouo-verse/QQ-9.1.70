package com.qwallet.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$Belt;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qwallet.home.QWalletHomeFragment;
import com.tencent.mobileqq.qwallet.home.QWalletHomeViewModel;
import com.tencent.mobileqq.qwallet.home.tips.QWalletHomeBeltConfig;
import com.tencent.mobileqq.qwallet.home.u;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qwallet.plugin.QWalletPicHelper;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001+B1\b\u0007\u0012\u0006\u0010\"\u001a\u00020!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\b\b\u0002\u0010&\u001a\u00020%\u0012\b\b\u0002\u0010'\u001a\u00020%\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0002H\u0014J\b\u0010\u0006\u001a\u00020\u0002H\u0014R\u001b\u0010\f\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R \u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006,"}, d2 = {"Lcom/qwallet/view/QWalletHomeBeltLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "initView", "onFinishInflate", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Lcom/tencent/mobileqq/qwallet/home/QWalletHomeViewModel;", "d", "Lkotlin/Lazy;", "B0", "()Lcom/tencent/mobileqq/qwallet/home/QWalletHomeViewModel;", "viewModel", "Landroid/view/View;", "e", "Landroid/view/View;", "operationBeltLayout", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "operationBeltIcon", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "operationBeltText", "i", "operationBeltBtn", "Landroidx/lifecycle/Observer;", "", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$Belt;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/Observer;", "operationBeltObserver", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class QWalletHomeBeltLayout extends ConstraintLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View operationBeltLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView operationBeltIcon;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView operationBeltText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView operationBeltBtn;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<List<QWalletHomePage$Belt>> operationBeltObserver;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QWalletHomeBeltLayout(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final QWalletHomeViewModel B0() {
        return (QWalletHomeViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(QWalletHomeBeltLayout this$0, final Context context, List belts) {
        View view;
        Object obj;
        Unit unit;
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullExpressionValue(belts, "belts");
        Iterator it = belts.iterator();
        while (true) {
            view = null;
            if (it.hasNext()) {
                obj = it.next();
                QWalletHomePage$Belt qWalletHomePage$Belt = (QWalletHomePage$Belt) obj;
                if (c4.a.o(qWalletHomePage$Belt) && c4.a.p(qWalletHomePage$Belt)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        final QWalletHomePage$Belt qWalletHomePage$Belt2 = (QWalletHomePage$Belt) obj;
        if (qWalletHomePage$Belt2 != null) {
            String str = qWalletHomePage$Belt2.f41689pv.get();
            Intrinsics.checkNotNullExpressionValue(str, "belt.pv.get()");
            u.m("index.operate_bar.show", str, String.valueOf(qWalletHomePage$Belt2.f41688id.get()), null, null, 0, 56, null);
            View view2 = this$0.operationBeltLayout;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("operationBeltLayout");
                view2 = null;
            }
            view2.setVisibility(0);
            ImageView imageView = this$0.operationBeltIcon;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("operationBeltIcon");
                imageView = null;
            }
            imageView.setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(qWalletHomePage$Belt2.icon.get()));
            TextView textView = this$0.operationBeltText;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("operationBeltText");
                textView = null;
            }
            textView.setText(qWalletHomePage$Belt2.text.get());
            TextView textView2 = this$0.operationBeltBtn;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("operationBeltBtn");
                textView2 = null;
            }
            textView2.setText(qWalletHomePage$Belt2.close_btn_title.get());
            View view3 = this$0.operationBeltLayout;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("operationBeltLayout");
                view3 = null;
            }
            view3.setOnClickListener(new View.OnClickListener() { // from class: com.qwallet.view.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    QWalletHomeBeltLayout.D0(context, qWalletHomePage$Belt2, view4);
                }
            });
            QLog.i("QWalletHomeBeltLayout", 1, "show belt: " + qWalletHomePage$Belt2.text.get());
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            View view4 = this$0.operationBeltLayout;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("operationBeltLayout");
            } else {
                view = view4;
            }
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(Context context, QWalletHomePage$Belt belt, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(belt, "$belt");
        com.tencent.mobileqq.qwallet.utils.k.h(context, belt.url.get());
        String str = belt.f41689pv.get();
        Intrinsics.checkNotNullExpressionValue(str, "belt.pv.get()");
        u.m("index.operate_bar.click", str, String.valueOf(belt.f41688id.get()), null, null, 0, 56, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void initView() {
        View findViewById = findViewById(R.id.f2109003);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.operation_belt_layout)");
        this.operationBeltLayout = findViewById;
        View findViewById2 = findViewById(R.id.f2108002);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.operation_belt_icon)");
        this.operationBeltIcon = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.f2110004);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.operation_belt_text)");
        TextView textView = (TextView) findViewById3;
        this.operationBeltText = textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("operationBeltText");
            textView = null;
        }
        ol2.b.f(textView, 0, false, 6, null);
        View findViewById4 = findViewById(R.id.f2107001);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.operation_belt_btn)");
        TextView textView2 = (TextView) findViewById4;
        this.operationBeltBtn = textView2;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("operationBeltBtn");
            textView2 = null;
        }
        ol2.b.f(textView2, 0, false, 6, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!QWalletHomeBeltConfig.INSTANCE.b()) {
            B0().R1().observeForever(this.operationBeltObserver);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (!QWalletHomeBeltConfig.INSTANCE.b()) {
            B0().R1().removeObserver(this.operationBeltObserver);
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        View.inflate(getContext(), R.layout.hik, this);
        initView();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QWalletHomeBeltLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QWalletHomeBeltLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ QWalletHomeBeltLayout(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QWalletHomeBeltLayout(@NotNull final Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QWalletHomeViewModel>() { // from class: com.qwallet.view.QWalletHomeBeltLayout$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QWalletHomeViewModel invoke() {
                return ((QWalletHomeFragment) FragmentManager.findFragment(QWalletHomeBeltLayout.this)).Oh();
            }
        });
        this.viewModel = lazy;
        this.operationBeltObserver = new Observer() { // from class: com.qwallet.view.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QWalletHomeBeltLayout.C0(QWalletHomeBeltLayout.this, context, (List) obj);
            }
        };
    }
}
