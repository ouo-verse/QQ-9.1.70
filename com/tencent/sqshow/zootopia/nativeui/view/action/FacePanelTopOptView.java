package com.tencent.sqshow.zootopia.nativeui.view.action;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.sqshow.zootopia.nativeui.ue.t;
import com.tencent.sqshow.zootopia.nativeui.view.customerface.MakeFaceTabView;
import com.tencent.sqshow.zootopia.nativeui.view.history.AvatarHistoryControlView;
import k94.DialogCustomData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n74.ag;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0014\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\u0006\u0010\u000f\u001a\u00020\u0003R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0015R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00140\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\""}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/action/FacePanelTopOptView;", "Lcom/tencent/sqshow/zootopia/nativeui/view/action/BaseAvatarPanelTopOptView;", "Lcom/tencent/sqshow/zootopia/nativeui/view/history/f;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, DomainData.DOMAIN_NAME, "k", "Landroid/widget/FrameLayout;", ParseCommon.CONTAINER, tl.h.F, "a", "b", "e", "l", "Ln74/ag;", "f", "Ln74/ag;", "mBinding", "", "I", "currentSlotId", "Landroidx/lifecycle/Observer;", "i", "Landroidx/lifecycle/Observer;", "slotIdObserve", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class FacePanelTopOptView extends BaseAvatarPanelTopOptView implements com.tencent.sqshow.zootopia.nativeui.view.history.f {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ag mBinding;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int currentSlotId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Observer<Integer> slotIdObserve;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FacePanelTopOptView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void k() {
        LifecycleOwner lifecycleOwner;
        com.tencent.sqshow.zootopia.nativeui.data.j mChannel;
        ag agVar;
        AvatarHistoryControlView avatarHistoryControlView;
        com.tencent.sqshow.zootopia.nativeui.data.j mChannel2 = getMChannel();
        if (mChannel2 == null || (lifecycleOwner = mChannel2.getLifecycleOwner()) == null || (mChannel = getMChannel()) == null || (agVar = this.mBinding) == null || (avatarHistoryControlView = agVar.f418611c) == null) {
            return;
        }
        avatarHistoryControlView.k(lifecycleOwner, mChannel.t(), this.currentSlotId);
    }

    private final void m() {
        MakeFaceTabView makeFaceTabView;
        AvatarHistoryControlView avatarHistoryControlView;
        com.tencent.sqshow.zootopia.nativeui.data.j mChannel = getMChannel();
        if (mChannel == null) {
            return;
        }
        n(mChannel);
        ag agVar = this.mBinding;
        if (agVar != null && (avatarHistoryControlView = agVar.f418611c) != null) {
            avatarHistoryControlView.n(mChannel);
        }
        ag agVar2 = this.mBinding;
        AvatarHistoryControlView avatarHistoryControlView2 = agVar2 != null ? agVar2.f418611c : null;
        if (avatarHistoryControlView2 != null) {
            avatarHistoryControlView2.setListener(this);
        }
        ag agVar3 = this.mBinding;
        if (agVar3 == null || (makeFaceTabView = agVar3.f418610b) == null) {
            return;
        }
        makeFaceTabView.e(mChannel);
    }

    private final void n(com.tencent.sqshow.zootopia.nativeui.data.j channel) {
        LifecycleOwner lifecycleOwner;
        com.tencent.sqshow.zootopia.nativeui.data.j mChannel = getMChannel();
        if (mChannel == null || (lifecycleOwner = mChannel.getLifecycleOwner()) == null || this.mBinding == null) {
            return;
        }
        g94.e.f401573a.c().observe(lifecycleOwner, this.slotIdObserve);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(FacePanelTopOptView this$0, Integer it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.currentSlotId = it.intValue();
        this$0.k();
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.history.f
    public void a() {
        com.tencent.sqshow.zootopia.nativeui.ue.t avatarFaceController;
        com.tencent.sqshow.zootopia.nativeui.data.j mChannel = getMChannel();
        if (mChannel == null || (avatarFaceController = mChannel.getAvatarFaceController()) == null) {
            return;
        }
        t.a.a(avatarFaceController, this.currentSlotId, null, 2, null);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.history.f
    public void b() {
        com.tencent.sqshow.zootopia.nativeui.ue.t avatarFaceController;
        com.tencent.sqshow.zootopia.nativeui.data.j mChannel = getMChannel();
        if (mChannel == null || (avatarFaceController = mChannel.getAvatarFaceController()) == null) {
            return;
        }
        t.a.b(avatarFaceController, this.currentSlotId, null, 2, null);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.history.f
    public void e() {
        ga4.g a16;
        com.tencent.sqshow.zootopia.nativeui.data.j mChannel = getMChannel();
        if (mChannel != null) {
            ga4.j jVar = ga4.j.f401682a;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            a16 = jVar.a(19, mChannel, context, (r22 & 8) != 0 ? new DialogCustomData(null, null, null, null, null, 0, 63, null) : null, (r22 & 16) != 0 ? false : false);
            a16.show();
        }
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.action.BaseAvatarPanelTopOptView
    public void h(FrameLayout container) {
        Intrinsics.checkNotNullParameter(container, "container");
        this.mBinding = ag.f(LayoutInflater.from(getContext()), container);
        m();
    }

    public final void l() {
        MakeFaceTabView makeFaceTabView;
        ag agVar = this.mBinding;
        if (agVar != null && (makeFaceTabView = agVar.f418610b) != null) {
            makeFaceTabView.f();
        }
        g94.e.f401573a.c().removeObserver(this.slotIdObserve);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FacePanelTopOptView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ FacePanelTopOptView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FacePanelTopOptView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.slotIdObserve = new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.view.action.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FacePanelTopOptView.o(FacePanelTopOptView.this, (Integer) obj);
            }
        };
    }
}
