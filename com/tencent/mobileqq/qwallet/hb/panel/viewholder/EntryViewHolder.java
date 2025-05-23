package com.tencent.mobileqq.qwallet.hb.panel.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.send.PanelEntryData;
import com.tencent.mobileqq.qwallet.k;
import com.tencent.mobileqq.qwallet.report.IReportApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import cooperation.qwallet.plugin.QWalletPicHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u001c\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u001c\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/panel/viewholder/EntryViewHolder;", "Lcom/tencent/mobileqq/qwallet/hb/panel/viewholder/a;", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", DomainData.DOMAIN_NAME, "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "H", "Landroid/widget/ImageView;", "image", "Landroid/widget/TextView;", "I", "Landroid/widget/TextView;", "text", "Lcom/tencent/mobileqq/qwallet/hb/panel/a;", "panelHost", "Landroid/view/View;", "view", "<init>", "(Lcom/tencent/mobileqq/qwallet/hb/panel/a;Landroid/view/View;)V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class EntryViewHolder extends a {

    /* renamed from: H, reason: from kotlin metadata */
    private final ImageView image;

    /* renamed from: I, reason: from kotlin metadata */
    private final TextView text;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EntryViewHolder(@NotNull com.tencent.mobileqq.qwallet.hb.panel.a panelHost, @NotNull View view) {
        super(panelHost, view);
        Intrinsics.checkNotNullParameter(panelHost, "panelHost");
        Intrinsics.checkNotNullParameter(view, "view");
        this.image = (ImageView) view.findViewById(R.id.f222903b);
        this.text = (TextView) view.findViewById(R.id.f223003c);
    }

    @Override // com.tencent.mobileqq.qwallet.hb.panel.viewholder.a
    public void n(@Nullable Object item) {
        final PanelEntryData panelEntryData = (PanelEntryData) l(item);
        if (panelEntryData == null) {
            return;
        }
        this.text.setText(panelEntryData.getTitle());
        this.image.setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(panelEntryData.getIcon()));
        final p sessionInfo = getPanelHost().getSessionInfo();
        View itemView = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        k.d(itemView, 0L, new Function0<Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.panel.viewholder.EntryViewHolder$setItem$1
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
                EntryViewHolder.this.getPanelHost().i0(Integer.valueOf(panelEntryData.getType()));
                ((IReportApi) QRoute.api(IReportApi.class)).reportHongbaoTo644("aio.lucky.click", sessionInfo, panelEntryData.getTitle());
            }
        }, 1, null);
        ((IReportApi) QRoute.api(IReportApi.class)).reportHongbaoTo644("aio.lucky.show", sessionInfo, panelEntryData.getTitle());
    }
}
