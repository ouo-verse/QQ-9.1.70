package com.tencent.sqshow.zootopia.nativeui.view.action;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n74.ae;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J\u000e\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005R$\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/action/BaseAvatarPanelTopOptView;", "Landroid/widget/FrameLayout;", ParseCommon.CONTAINER, "", tl.h.F, "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "i", "g", "d", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "f", "()Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "setMChannel", "(Lcom/tencent/sqshow/zootopia/nativeui/data/j;)V", "mChannel", "Ln74/ae;", "e", "Ln74/ae;", "mBinding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public abstract class BaseAvatarPanelTopOptView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.sqshow.zootopia.nativeui.data.j mChannel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ae mBinding;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseAvatarPanelTopOptView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: f, reason: from getter */
    public final com.tencent.sqshow.zootopia.nativeui.data.j getMChannel() {
        return this.mChannel;
    }

    public final void g(com.tencent.sqshow.zootopia.nativeui.data.j channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.mChannel = channel;
        i(channel);
        FrameLayout frameLayout = this.mBinding.f418605b;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "mBinding.contentContainer");
        h(frameLayout);
    }

    public abstract void h(FrameLayout container);

    protected void i(com.tencent.sqshow.zootopia.nativeui.data.j channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseAvatarPanelTopOptView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ BaseAvatarPanelTopOptView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseAvatarPanelTopOptView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        ae f16 = ae.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.mBinding = f16;
    }
}
