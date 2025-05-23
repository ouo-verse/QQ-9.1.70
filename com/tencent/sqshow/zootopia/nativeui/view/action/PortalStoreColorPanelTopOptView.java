package com.tencent.sqshow.zootopia.nativeui.view.action;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import java.util.HashMap;
import k94.ColorPanelData;
import k94.DialogCustomData;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import m94.DressErrorMsg;
import n74.cf;
import uv4.au;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010!\u001a\u00020 \u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\u0006\u0010\u0010\u001a\u00020\u0003J\u0006\u0010\u0011\u001a\u00020\u0003J\u0006\u0010\u0012\u001a\u00020\u0003J\u000e\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0013R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001a\u00a8\u0006$"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/action/PortalStoreColorPanelTopOptView;", "Lcom/tencent/sqshow/zootopia/nativeui/view/action/BaseAvatarPanelTopOptView;", "Lcom/tencent/sqshow/zootopia/nativeui/view/history/f;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "panelChannel", DomainData.DOMAIN_NAME, "l", "Landroid/widget/FrameLayout;", ParseCommon.CONTAINER, tl.h.F, "a", "b", "e", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "Lk94/b;", "colorPanelData", "setColorPanelData", "Ln74/cf;", "f", "Ln74/cf;", "mBinding", "Lk94/b;", "mColorPanelData", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class PortalStoreColorPanelTopOptView extends BaseAvatarPanelTopOptView implements com.tencent.sqshow.zootopia.nativeui.view.history.f {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private cf mBinding;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ColorPanelData mColorPanelData;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/action/PortalStoreColorPanelTopOptView$a", "Lm94/h;", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/b;", "task", "Lm94/e;", "errorMsg", "", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
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

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/action/PortalStoreColorPanelTopOptView$b", "Lm94/h;", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/b;", "task", "Lm94/e;", "errorMsg", "", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
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
    public PortalStoreColorPanelTopOptView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void n(com.tencent.sqshow.zootopia.nativeui.data.j panelChannel) {
        this.mBinding.f419004b.e(panelChannel);
    }

    private final void o() {
        TextView textView = this.mBinding.f419005c;
        Intrinsics.checkNotNullExpressionValue(textView, "mBinding.saveBtn");
        com.tencent.sqshow.zootopia.utils.aa.d(textView, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.action.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PortalStoreColorPanelTopOptView.p(PortalStoreColorPanelTopOptView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(PortalStoreColorPanelTopOptView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.l();
    }

    private final void q() {
        com.tencent.sqshow.zootopia.nativeui.data.j mChannel = getMChannel();
        if (mChannel == null) {
            return;
        }
        n(mChannel);
        o();
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
        q();
    }

    public final void k() {
        this.mBinding.f419004b.h();
    }

    public final void m() {
        this.mBinding.f419004b.setVisibility(8);
    }

    public final void r() {
        this.mBinding.f419004b.setVisibility(0);
    }

    public final void setColorPanelData(ColorPanelData colorPanelData) {
        Intrinsics.checkNotNullParameter(colorPanelData, "colorPanelData");
        this.mColorPanelData = colorPanelData;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PortalStoreColorPanelTopOptView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void l() {
        String str;
        HashMap hashMapOf;
        ga4.f dialogController;
        ga4.g a16;
        qu4.f fVar;
        y94.a reporter;
        ZplanViewReportHelper mReporter;
        String zplanFaceId;
        com.tencent.sqshow.zootopia.nativeui.ue.s avatarColorController;
        Pair[] pairArr = new Pair[2];
        com.tencent.sqshow.zootopia.nativeui.data.j mChannel = getMChannel();
        String str2 = "";
        if (mChannel == null || (avatarColorController = mChannel.getAvatarColorController()) == null || (str = avatarColorController.getMCurrentHexColor()) == null) {
            str = "";
        }
        pairArr[0] = TuplesKt.to("zplan_color_code", str);
        com.tencent.sqshow.zootopia.nativeui.data.j mChannel2 = getMChannel();
        if (mChannel2 != null && (zplanFaceId = mChannel2.getZplanFaceId()) != null) {
            str2 = zplanFaceId;
        }
        pairArr[1] = TuplesKt.to("zplan_face_id", str2);
        hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
        com.tencent.sqshow.zootopia.nativeui.data.j mChannel3 = getMChannel();
        if (mChannel3 != null && (reporter = mChannel3.getReporter()) != null && (mReporter = reporter.getMReporter()) != null) {
            TextView textView = this.mBinding.f419005c;
            Intrinsics.checkNotNullExpressionValue(textView, "mBinding.saveBtn");
            mReporter.e(textView, "em_zplan_avatar_save", hashMapOf);
        }
        if (com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.A()) {
            au value = com.tencent.sqshow.zootopia.nativeui.view.experience.m.f371882a.a().getValue();
            if (((value == null || (fVar = value.f440232a) == null) ? 0L : fVar.f429591b * 1000) < NetConnInfoCenter.getServerTimeMillis()) {
                com.tencent.sqshow.zootopia.nativeui.data.j mChannel4 = getMChannel();
                if (mChannel4 != null) {
                    ga4.j jVar = ga4.j.f401682a;
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    a16 = jVar.a(8, mChannel4, context, (r22 & 8) != 0 ? new DialogCustomData(null, null, null, null, null, 0, 63, null) : null, (r22 & 16) != 0 ? false : false);
                    a16.show();
                    return;
                }
                return;
            }
        }
        com.tencent.sqshow.zootopia.nativeui.data.j mChannel5 = getMChannel();
        if (mChannel5 == null || (dialogController = mChannel5.getDialogController()) == null) {
            return;
        }
        dialogController.d();
    }

    public /* synthetic */ PortalStoreColorPanelTopOptView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PortalStoreColorPanelTopOptView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        cf f16 = cf.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.mBinding = f16;
    }
}
