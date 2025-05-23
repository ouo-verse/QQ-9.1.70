package com.tencent.sqshow.zootopia.nativeui.view.action;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import b94.d;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.nativeui.data.AvatarNativeViewMode;
import com.tencent.sqshow.zootopia.nativeui.view.customerface.MakeFaceExitHelper;
import com.tencent.sqshow.zootopia.nativeui.view.customerface.MakeFaceTabView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n74.cg;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0002J\u0012\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0006\u0010\u0011\u001a\u00020\u0002R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/action/PortalStoreFacePanelTopOptView;", "Lcom/tencent/sqshow/zootopia/nativeui/view/action/BaseAvatarPanelTopOptView;", "", "o", "Landroid/view/View;", "view", DomainData.DOMAIN_NAME, "", "", "", "k", "", "showDialog", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/FrameLayout;", ParseCommon.CONTAINER, tl.h.F, "l", "Ln74/cg;", "f", "Ln74/cg;", "mBinding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class PortalStoreFacePanelTopOptView extends BaseAvatarPanelTopOptView {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private cg mBinding;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PortalStoreFacePanelTopOptView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final Map<String, Object> k() {
        String str;
        qu4.j jVar;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        com.tencent.sqshow.zootopia.nativeui.data.j mChannel = getMChannel();
        qu4.j jVar2 = null;
        qu4.j faceInfoWhenEnterMakeFace = mChannel != null ? mChannel.getFaceInfoWhenEnterMakeFace() : null;
        qu4.a k3 = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.k();
        if (k3 != null && (jVar = k3.f429573b) != null) {
            jVar2 = bj3.a.j(jVar);
        }
        if (faceInfoWhenEnterMakeFace != null && !r94.a.i(faceInfoWhenEnterMakeFace, jVar2)) {
            linkedHashMap.put("zplan_is_adjust", "1");
        } else {
            linkedHashMap.put("zplan_is_adjust", "0");
        }
        com.tencent.sqshow.zootopia.nativeui.data.j mChannel2 = getMChannel();
        if (mChannel2 == null || (str = mChannel2.getZplanFaceId()) == null) {
            str = "";
        }
        linkedHashMap.put("zplan_face_id", str);
        return linkedHashMap;
    }

    private final void n(View view) {
        com.tencent.sqshow.zootopia.nativeui.data.j mChannel;
        b94.d avatarDressController;
        com.tencent.sqshow.zootopia.nativeui.ue.t avatarFaceController;
        y94.a reporter;
        ZplanViewReportHelper mReporter;
        com.tencent.sqshow.zootopia.nativeui.data.j mChannel2 = getMChannel();
        qu4.j jVar = null;
        if (mChannel2 != null && (reporter = mChannel2.getReporter()) != null && (mReporter = reporter.getMReporter()) != null) {
            cg cgVar = this.mBinding;
            TextView textView = cgVar != null ? cgVar.f419008c : null;
            if (textView != null) {
                view = textView;
            }
            mReporter.e(view, "em_zplan_avatar_save", k());
        }
        com.tencent.sqshow.zootopia.nativeui.data.j mChannel3 = getMChannel();
        if (mChannel3 != null && (avatarFaceController = mChannel3.getAvatarFaceController()) != null) {
            jVar = avatarFaceController.d();
        }
        qu4.j jVar2 = jVar;
        if (jVar2 != null && (mChannel = getMChannel()) != null && (avatarDressController = mChannel.getAvatarDressController()) != null) {
            d.a.g(avatarDressController, jVar2, false, null, 6, null);
        }
        m(false);
    }

    private final void o() {
        TextView textView;
        MakeFaceTabView makeFaceTabView;
        com.tencent.sqshow.zootopia.nativeui.data.j mChannel = getMChannel();
        if (mChannel == null) {
            return;
        }
        cg cgVar = this.mBinding;
        if (cgVar != null && (makeFaceTabView = cgVar.f419007b) != null) {
            makeFaceTabView.e(mChannel);
        }
        cg cgVar2 = this.mBinding;
        if (cgVar2 == null || (textView = cgVar2.f419008c) == null) {
            return;
        }
        com.tencent.sqshow.zootopia.utils.aa.d(textView, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.action.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PortalStoreFacePanelTopOptView.p(PortalStoreFacePanelTopOptView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(PortalStoreFacePanelTopOptView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(view, "view");
        this$0.n(view);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.action.BaseAvatarPanelTopOptView
    public void h(FrameLayout container) {
        Intrinsics.checkNotNullParameter(container, "container");
        this.mBinding = cg.f(LayoutInflater.from(getContext()), container);
        o();
    }

    public final void l() {
        MakeFaceTabView makeFaceTabView;
        cg cgVar = this.mBinding;
        if (cgVar == null || (makeFaceTabView = cgVar.f419007b) == null) {
            return;
        }
        makeFaceTabView.f();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PortalStoreFacePanelTopOptView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ PortalStoreFacePanelTopOptView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PortalStoreFacePanelTopOptView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final boolean m(boolean showDialog) {
        com.tencent.sqshow.zootopia.nativeui.data.j mChannel;
        Activity attachedActivity;
        ga4.f dialogController;
        com.tencent.sqshow.zootopia.nativeui.ue.t avatarFaceController;
        if (showDialog) {
            com.tencent.sqshow.zootopia.nativeui.data.j mChannel2 = getMChannel();
            boolean z16 = false;
            if (mChannel2 != null && (avatarFaceController = mChannel2.getAvatarFaceController()) != null && avatarFaceController.f()) {
                z16 = true;
            }
            if (z16) {
                MakeFaceExitHelper makeFaceExitHelper = MakeFaceExitHelper.f371595a;
                com.tencent.sqshow.zootopia.nativeui.data.j mChannel3 = getMChannel();
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                makeFaceExitHelper.c(mChannel3, context, new Function1<Boolean, Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.view.action.PortalStoreFacePanelTopOptView$handleBackClickOnMakeFaceStyle$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z17) {
                        com.tencent.sqshow.zootopia.nativeui.data.j mChannel4;
                        Activity attachedActivity2;
                        ga4.f dialogController2;
                        com.tencent.sqshow.zootopia.nativeui.data.j mChannel5 = PortalStoreFacePanelTopOptView.this.getMChannel();
                        if (mChannel5 != null && (dialogController2 = mChannel5.getDialogController()) != null) {
                            dialogController2.d();
                        }
                        com.tencent.sqshow.zootopia.nativeui.data.j mChannel6 = PortalStoreFacePanelTopOptView.this.getMChannel();
                        if ((mChannel6 != null ? mChannel6.getNativeViewMode() : null) != AvatarNativeViewMode.ONLY_MAKE_FACE || (mChannel4 = PortalStoreFacePanelTopOptView.this.getMChannel()) == null || (attachedActivity2 = mChannel4.getAttachedActivity()) == null) {
                            return;
                        }
                        attachedActivity2.finish();
                    }
                });
                return true;
            }
        }
        com.tencent.sqshow.zootopia.nativeui.data.j mChannel4 = getMChannel();
        if (mChannel4 != null && (dialogController = mChannel4.getDialogController()) != null) {
            dialogController.d();
        }
        com.tencent.sqshow.zootopia.nativeui.data.j mChannel5 = getMChannel();
        if ((mChannel5 != null ? mChannel5.getNativeViewMode() : null) == AvatarNativeViewMode.ONLY_MAKE_FACE && (mChannel = getMChannel()) != null && (attachedActivity = mChannel.getAttachedActivity()) != null) {
            attachedActivity.finish();
        }
        return true;
    }
}
