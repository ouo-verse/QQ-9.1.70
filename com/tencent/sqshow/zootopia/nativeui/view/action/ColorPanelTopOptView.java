package com.tencent.sqshow.zootopia.nativeui.view.action;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.sqshow.zootopia.nativeui.view.experience.ExperienceCountdownView;
import k94.ColorPanelData;
import k94.DialogCustomData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import m94.DressErrorMsg;
import n74.af;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\u0006\u0010\u000e\u001a\u00020\u0003J\u0006\u0010\u000f\u001a\u00020\u0003J\u0006\u0010\u0010\u001a\u00020\u0003J\u000e\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0018\u00a8\u0006\""}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/action/ColorPanelTopOptView;", "Lcom/tencent/sqshow/zootopia/nativeui/view/action/BaseAvatarPanelTopOptView;", "Lcom/tencent/sqshow/zootopia/nativeui/view/history/f;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "panelChannel", "l", "Landroid/widget/FrameLayout;", ParseCommon.CONTAINER, tl.h.F, "a", "b", "e", DomainData.DOMAIN_NAME, "k", "j", "Lk94/b;", "colorPanelData", "setColorPanelData", "Ln74/af;", "f", "Ln74/af;", "mBinding", "Lk94/b;", "mColorPanelData", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ColorPanelTopOptView extends BaseAvatarPanelTopOptView implements com.tencent.sqshow.zootopia.nativeui.view.history.f {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private af mBinding;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ColorPanelData mColorPanelData;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/action/ColorPanelTopOptView$a", "Lm94/h;", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/b;", "task", "Lm94/e;", "errorMsg", "", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements m94.h {
        a() {
        }

        @Override // m94.h
        public void a(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task, DressErrorMsg errorMsg) {
            Intrinsics.checkNotNullParameter(task, "task");
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        }

        @Override // m94.h
        public void b(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task) {
            Intrinsics.checkNotNullParameter(task, "task");
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/action/ColorPanelTopOptView$b", "Lm94/h;", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/b;", "task", "Lm94/e;", "errorMsg", "", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements m94.h {
        b() {
        }

        @Override // m94.h
        public void a(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task, DressErrorMsg errorMsg) {
            Intrinsics.checkNotNullParameter(task, "task");
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        }

        @Override // m94.h
        public void b(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task) {
            Intrinsics.checkNotNullParameter(task, "task");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ColorPanelTopOptView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void l(com.tencent.sqshow.zootopia.nativeui.data.j panelChannel) {
        af afVar = this.mBinding;
        if (afVar == null) {
            return;
        }
        afVar.f418607b.e(panelChannel);
    }

    private final void m() {
        af afVar;
        com.tencent.sqshow.zootopia.nativeui.data.j mChannel = getMChannel();
        if (mChannel == null || (afVar = this.mBinding) == null) {
            return;
        }
        afVar.f418608c.n(mChannel);
        l(mChannel);
        afVar.f418608c.setListener(this);
        LifecycleOwner lifecycleOwner = mChannel.getLifecycleOwner();
        if (lifecycleOwner == null) {
            return;
        }
        afVar.f418608c.j(lifecycleOwner, mChannel.r());
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.history.f
    public void a() {
        b94.d avatarDressController;
        com.tencent.sqshow.zootopia.nativeui.data.j mChannel = getMChannel();
        if (mChannel == null || (avatarDressController = mChannel.getAvatarDressController()) == null) {
            return;
        }
        avatarDressController.Y6(new a());
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.history.f
    public void b() {
        b94.d avatarDressController;
        com.tencent.sqshow.zootopia.nativeui.data.j mChannel = getMChannel();
        if (mChannel == null || (avatarDressController = mChannel.getAvatarDressController()) == null) {
            return;
        }
        avatarDressController.E9(new b());
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.history.f
    public void e() {
        ga4.g a16;
        com.tencent.sqshow.zootopia.nativeui.data.j mChannel = getMChannel();
        if (mChannel == null) {
            return;
        }
        ga4.j jVar = ga4.j.f401682a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        DialogCustomData dialogCustomData = new DialogCustomData(null, null, null, null, null, 0, 63, null);
        dialogCustomData.g(this.mColorPanelData);
        Unit unit = Unit.INSTANCE;
        a16 = jVar.a(17, mChannel, context, (r22 & 8) != 0 ? new DialogCustomData(null, null, null, null, null, 0, 63, null) : dialogCustomData, (r22 & 16) != 0 ? false : false);
        a16.show();
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.action.BaseAvatarPanelTopOptView
    public void h(FrameLayout container) {
        Intrinsics.checkNotNullParameter(container, "container");
        this.mBinding = af.f(LayoutInflater.from(getContext()), container);
        m();
    }

    public final void j() {
        ExperienceCountdownView experienceCountdownView;
        af afVar = this.mBinding;
        if (afVar == null || (experienceCountdownView = afVar.f418607b) == null) {
            return;
        }
        experienceCountdownView.h();
    }

    public final void k() {
        af afVar = this.mBinding;
        ExperienceCountdownView experienceCountdownView = afVar != null ? afVar.f418607b : null;
        if (experienceCountdownView == null) {
            return;
        }
        experienceCountdownView.setVisibility(8);
    }

    public final void n() {
        af afVar = this.mBinding;
        ExperienceCountdownView experienceCountdownView = afVar != null ? afVar.f418607b : null;
        if (experienceCountdownView == null) {
            return;
        }
        experienceCountdownView.setVisibility(0);
    }

    public final void setColorPanelData(ColorPanelData colorPanelData) {
        Intrinsics.checkNotNullParameter(colorPanelData, "colorPanelData");
        this.mColorPanelData = colorPanelData;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ColorPanelTopOptView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ColorPanelTopOptView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ColorPanelTopOptView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
