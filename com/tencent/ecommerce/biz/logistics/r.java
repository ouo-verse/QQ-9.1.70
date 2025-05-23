package com.tencent.ecommerce.biz.logistics;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.ktx.ImageViewKt;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.biz.logistics.ECLogisticsTraceAdapter;
import com.tencent.ecommerce.biz.orders.common.PackageInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u0011\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001c\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u001c\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\u0010\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u001c\u0010\u0014\u001a\n \u0007*\u0004\u0018\u00010\u00110\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0016\u001a\n \u0007*\u0004\u0018\u00010\u00110\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/ecommerce/biz/logistics/r;", "Lcom/tencent/ecommerce/biz/logistics/o;", "Lcom/tencent/ecommerce/biz/logistics/u;", "data", "", DomainData.DOMAIN_NAME, "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "E", "Landroid/widget/ImageView;", "productIcon", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "statusDesc", "G", "shipCode", "Landroid/view/View;", "H", "Landroid/view/View;", "copyBtn", "I", "callBtn", "Lcom/tencent/ecommerce/biz/logistics/ECLogisticsTraceAdapter$ActionListener;", "J", "Lcom/tencent/ecommerce/biz/logistics/ECLogisticsTraceAdapter$ActionListener;", "listener", "view", "<init>", "(Landroid/view/View;Lcom/tencent/ecommerce/biz/logistics/ECLogisticsTraceAdapter$ActionListener;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class r extends o<ShipStatusData> {

    /* renamed from: E, reason: from kotlin metadata */
    private final ImageView productIcon;

    /* renamed from: F, reason: from kotlin metadata */
    private final TextView statusDesc;

    /* renamed from: G, reason: from kotlin metadata */
    private final TextView shipCode;

    /* renamed from: H, reason: from kotlin metadata */
    private final View copyBtn;

    /* renamed from: I, reason: from kotlin metadata */
    private final View callBtn;

    /* renamed from: J, reason: from kotlin metadata */
    private final ECLogisticsTraceAdapter.ActionListener listener;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ShipStatusData f102919e;

        a(ShipStatusData shipStatusData) {
            this.f102919e = shipStatusData;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            r.this.listener.copyToClipboard("shipCode", this.f102919e.shipCode);
            com.tencent.ecommerce.base.ui.i.f101155b.c(R.string.wsv, ECToastIcon.ICON_NONE, 0);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ShipStatusData f102921e;

        b(ShipStatusData shipStatusData) {
            this.f102921e = shipStatusData;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            r.this.listener.makePhoneCall(this.f102921e.shipperCompany.tel);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    @Override // com.tencent.ecommerce.biz.logistics.o
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void l(ShipStatusData data) {
        PackageInfo packageInfo = data.packageInfo;
        int i3 = packageInfo.statusIconResId;
        if (i3 > 0) {
            this.productIcon.setImageDrawable(ECSkin.INSTANCE.getDrawable(i3));
            this.productIcon.setScaleX(0.5f);
            this.productIcon.setScaleY(0.5f);
        } else {
            ImageViewKt.b(this.productIcon, packageInfo.productIcon, 0, 0, 0, 14, null);
        }
        this.statusDesc.setText(data.getCurrentStatus().getDesc());
        this.shipCode.setText(data.shipperCompany.name + MsgSummary.STR_COLON + data.shipCode);
        this.copyBtn.setOnClickListener(new a(data));
        this.callBtn.setOnClickListener(new b(data));
    }

    public r(View view, ECLogisticsTraceAdapter.ActionListener actionListener) {
        super(view, null);
        this.listener = actionListener;
        this.productIcon = (ImageView) view.findViewById(R.id.o75);
        this.statusDesc = (TextView) view.findViewById(R.id.f163104ob3);
        this.shipCode = (TextView) view.findViewById(R.id.o_y);
        this.copyBtn = view.findViewById(R.id.nut);
        this.callBtn = view.findViewById(R.id.nsw);
    }
}
