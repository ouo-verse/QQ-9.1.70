package com.tencent.sqshow.zootopia.nativeui.view.detail.recommend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.sqshow.zootopia.nativeui.ue.u;
import com.tencent.sqshow.zootopia.utils.aa;
import k94.DialogCustomData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n74.bq;
import uv4.az;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 !2\u00020\u0001:\u0001\"B'\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u0010\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u0002R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0011R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006#"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/detail/recommend/PortalStoreAvatarDetailFloatView;", "Landroid/widget/FrameLayout;", "", "c", "g", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "b", "Luv4/az;", "storeItem", "setCurrentClickStoreItem", "f", "e", "Ln74/bq;", "d", "Ln74/bq;", "mBinding", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "mChannel", "Luv4/az;", "mCurrentClickStoreItem", "Lid3/d;", tl.h.F, "Lid3/d;", "dtReporter", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "i", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class PortalStoreAvatarDetailFloatView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final bq mBinding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.sqshow.zootopia.nativeui.data.j mChannel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private az mCurrentClickStoreItem;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final id3.d dtReporter;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PortalStoreAvatarDetailFloatView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void c() {
        View mRv = this.mBinding.getMRv();
        Intrinsics.checkNotNullExpressionValue(mRv, "mBinding.root");
        aa.d(mRv, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.detail.recommend.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PortalStoreAvatarDetailFloatView.d(PortalStoreAvatarDetailFloatView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(PortalStoreAvatarDetailFloatView this$0, View view) {
        com.tencent.sqshow.zootopia.nativeui.data.j jVar;
        ga4.g a16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mCurrentClickStoreItem == null || (jVar = this$0.mChannel) == null || !u.a.a(jVar.getUeStatusController(), false, 1, null)) {
            return;
        }
        ga4.j jVar2 = ga4.j.f401682a;
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        a16 = jVar2.a(3, jVar, context, (r22 & 8) != 0 ? new DialogCustomData(null, null, null, null, null, 0, 63, null) : new DialogCustomData(this$0.mCurrentClickStoreItem, null, null, null, null, 0, 62, null), (r22 & 16) != 0 ? false : false);
        a16.show();
    }

    private final void g() {
        az azVar = this.mCurrentClickStoreItem;
        if (azVar != null) {
            this.mBinding.f418895b.setText(azVar.f440277d);
        }
    }

    public final void b(com.tencent.sqshow.zootopia.nativeui.data.j channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.mChannel = channel;
    }

    public final void setCurrentClickStoreItem(az storeItem) {
        this.mCurrentClickStoreItem = storeItem;
        g();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PortalStoreAvatarDetailFloatView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ PortalStoreAvatarDetailFloatView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PortalStoreAvatarDetailFloatView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.dtReporter = new id3.d(null, 1, null);
        bq f16 = bq.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.mBinding = f16;
        c();
    }

    public final void e() {
    }

    public final void f() {
    }
}
