package com.tencent.mobileqq.qwallet.hb.panel.viewholder;

import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qwallet.hb.panel.c;
import com.tencent.mobileqq.qwallet.hb.send.PanelTabData;
import com.tencent.mobileqq.qwallet.k;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/panel/viewholder/BottomTextLinkViewHolder;", "Lcom/tencent/mobileqq/qwallet/hb/panel/viewholder/a;", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", DomainData.DOMAIN_NAME, "", "Landroid/widget/TextView;", "H", "[Landroid/widget/TextView;", "bottomTabs", "Lcom/tencent/mobileqq/qwallet/hb/panel/a;", "panelHost", "Landroid/view/View;", "view", "<init>", "(Lcom/tencent/mobileqq/qwallet/hb/panel/a;Landroid/view/View;)V", "I", "a", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class BottomTextLinkViewHolder extends a {

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final TextView[] bottomTabs;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomTextLinkViewHolder(@NotNull com.tencent.mobileqq.qwallet.hb.panel.a panelHost, @NotNull View view) {
        super(panelHost, view);
        Intrinsics.checkNotNullParameter(panelHost, "panelHost");
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.f2222035);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.panel_bottom_tab_1)");
        View findViewById2 = view.findViewById(R.id.f2223036);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.panel_bottom_tab_2)");
        View findViewById3 = view.findViewById(R.id.f2224037);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.panel_bottom_tab_3)");
        this.bottomTabs = new TextView[]{(TextView) findViewById, (TextView) findViewById2, (TextView) findViewById3};
    }

    @Override // com.tencent.mobileqq.qwallet.hb.panel.viewholder.a
    public void n(@Nullable Object item) {
        final PanelTabData panelTabData;
        Object orNull;
        c.b bVar = (c.b) l(item);
        if (bVar == null) {
            return;
        }
        TextView[] textViewArr = this.bottomTabs;
        int length = textViewArr.length;
        int i3 = 0;
        int i16 = 0;
        while (i3 < length) {
            TextView textView = textViewArr[i3];
            int i17 = i16 + 1;
            List<PanelTabData> a16 = bVar.a();
            if (a16 != null) {
                orNull = CollectionsKt___CollectionsKt.getOrNull(a16, i16);
                panelTabData = (PanelTabData) orNull;
            } else {
                panelTabData = null;
            }
            if (panelTabData == null) {
                textView.setVisibility(8);
            } else {
                if (panelTabData.getType() == 2) {
                    com.tencent.mobileqq.qwallet.c.f("unGrabHB.entry.show", null, null, null, null, 30, null);
                }
                textView.setVisibility(0);
                textView.setText(panelTabData.getName());
                k.d(textView, 0L, new Function0<Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.panel.viewholder.BottomTextLinkViewHolder$setItem$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        BottomTextLinkViewHolder.this.getPanelHost().M(panelTabData);
                    }
                }, 1, null);
            }
            i3++;
            i16 = i17;
        }
    }
}
