package com.tencent.mobileqq.qwallet.home.tips;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.lifecycle.Observer;
import com.qwallet.data.TenPayInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qwallet.home.HomeLegacyBizManager;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import cooperation.qwallet.plugin.IQWalletHelper;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0004\u001a\u00020\u0002H\u0014R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/tips/TopTipsV2Layout;", "Landroid/widget/FrameLayout;", "", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Lcom/tencent/mobileqq/qwallet/home/tips/q;", "d", "Lcom/tencent/mobileqq/qwallet/home/tips/q;", "mBeltTipsManager", "Landroidx/lifecycle/Observer;", "Lcom/qwallet/data/TenPayInfo;", "e", "Landroidx/lifecycle/Observer;", "tenpayInfoObserver", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "f", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class TopTipsV2Layout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final q mBeltTipsManager;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<TenPayInfo> tenpayInfoObserver;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TopTipsV2Layout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(TopTipsV2Layout this$0, TenPayInfo tenPayInfo) {
        JSONObject jSONObject;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean c16 = com.tencent.mobileqq.qwallet.utils.g.c(IQWalletHelper.PREF_KEY_MULTI_IS_TENPAY_YELLOWTIP_VALID, true);
        if (tenPayInfo.c() && c16 && (jSONObject = tenPayInfo.f41534g) != null) {
            this$0.mBeltTipsManager.n(new com.qwallet.data.d(0, jSONObject.optString("tips_title"), tenPayInfo.f41534g.optString("tips_url"), 0, 4, null, 41, null));
        } else {
            this$0.mBeltTipsManager.n(null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (QWalletHomeBeltConfig.INSTANCE.b()) {
            HomeLegacyBizManager.f277929d.m().observeForever(this.tenpayInfoObserver);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (QWalletHomeBeltConfig.INSTANCE.b()) {
            HomeLegacyBizManager.f277929d.m().removeObserver(this.tenpayInfoObserver);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TopTipsV2Layout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ TopTipsV2Layout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TopTipsV2Layout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mBeltTipsManager = new q(context, this);
        this.tenpayInfoObserver = new Observer() { // from class: com.tencent.mobileqq.qwallet.home.tips.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TopTipsV2Layout.b(TopTipsV2Layout.this, (TenPayInfo) obj);
            }
        };
    }
}
