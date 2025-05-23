package com.tencent.sqshow.zootopia.nativeui.view.dialog.views;

import android.content.Context;
import android.util.AttributeSet;
import b94.e;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.sqshow.zootopia.nativeui.data.AvatarNativeViewMode;
import com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView;
import com.tencent.sqshow.zootopia.nativeui.view.title.AvatarNativeTitleView;
import ga4.h;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H'J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/views/BaseSubPanelDialogView;", "Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/BasePanelDialogView;", "", "P", "", "onShow", "onDismiss", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/tencent/sqshow/zootopia/nativeui/data/j;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public abstract class BaseSubPanelDialogView extends BasePanelDialogView {

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/dialog/views/BaseSubPanelDialogView$a", "Lga4/h;", "Lga4/g;", "panelDialog", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements ga4.h {
        a() {
        }

        @Override // ga4.h
        public void a(ga4.g panelDialog) {
            b94.e O;
            Intrinsics.checkNotNullParameter(panelDialog, "panelDialog");
            b94.e O2 = BaseSubPanelDialogView.this.getMChannel().O();
            boolean z16 = O2 != null && O2.getMPanelHasEnter();
            boolean z17 = BaseSubPanelDialogView.this.getMChannel().getNativeViewMode() != AvatarNativeViewMode.ONLY_MAKE_FACE;
            if (z16 && z17 && (O = BaseSubPanelDialogView.this.getMChannel().O()) != null) {
                e.a.i(O, true, null, null, 6, null);
            }
        }

        @Override // ga4.h
        public void b(ga4.g gVar) {
            h.a.a(this, gVar);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseSubPanelDialogView(Context context, AttributeSet attributeSet, int i3, com.tencent.sqshow.zootopia.nativeui.data.j channel) {
        super(context, attributeSet, i3, channel);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channel, "channel");
    }

    @AvatarNativeTitleView.Companion.AvatarNativeTitleViewStyle
    public abstract int P();

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView, ga4.g
    public void onDismiss() {
        setOnDismissListener(new a());
        super.onDismiss();
        b94.e O = getMChannel().O();
        if (O != null) {
            O.n1(true);
        }
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView, ga4.g
    public void onShow() {
        Unit unit;
        b94.e O = getMChannel().O();
        if (O != null) {
            e.a.d(O, true, null, new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.views.BaseSubPanelDialogView$onShow$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    super/*com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView*/.onShow();
                    b94.e O2 = BaseSubPanelDialogView.this.getMChannel().O();
                    if (O2 != null) {
                        O2.he(true, BaseSubPanelDialogView.this.P());
                    }
                }
            }, 2, null);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            super.onShow();
        }
    }
}
