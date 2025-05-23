package com.tencent.mobileqq.qwallet.hb.panel.viewholder;

import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qwallet.hb.panel.SkinHeaderData;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u001c\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/panel/viewholder/b;", "Lcom/tencent/mobileqq/qwallet/hb/panel/viewholder/a;", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", DomainData.DOMAIN_NAME, "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "H", "Landroid/widget/TextView;", "titleView", "Lcom/tencent/mobileqq/qwallet/hb/panel/a;", "panelHost", "Landroid/view/View;", "view", "<init>", "(Lcom/tencent/mobileqq/qwallet/hb/panel/a;Landroid/view/View;)V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b extends a {

    /* renamed from: H, reason: from kotlin metadata */
    private final TextView titleView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull com.tencent.mobileqq.qwallet.hb.panel.a panelHost, @NotNull View view) {
        super(panelHost, view);
        Intrinsics.checkNotNullParameter(panelHost, "panelHost");
        Intrinsics.checkNotNullParameter(view, "view");
        this.titleView = (TextView) view.findViewById(R.id.d4r);
    }

    @Override // com.tencent.mobileqq.qwallet.hb.panel.viewholder.a
    public void n(@Nullable Object item) {
        boolean z16;
        SkinHeaderData skinHeaderData = (SkinHeaderData) l(item);
        if (skinHeaderData == null) {
            return;
        }
        String title = skinHeaderData.getTitle();
        if (title != null && title.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            this.titleView.setVisibility(8);
        } else {
            this.titleView.setText(skinHeaderData.getTitle());
            this.titleView.setVisibility(0);
        }
    }
}
