package com.tencent.ecommerce.biz.mainpage;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.config.api.IECLocalConfig;
import com.tencent.ecommerce.base.config.service.ECLocalConfig;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.model.OrderDetailEntrance;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.model.TicketDetail;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.qshop.ECShopOrderDetailFragment;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.sample.ECSampleOrderDetailFragment;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitLauncherFragment;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.SimpleSku;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 -2\u00020\u0001:\u0001.B\u000f\u0012\u0006\u0010*\u001a\u00020)\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\u0010\u0010\u0011\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fH\u0002J\u0012\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0017R\u0016\u0010\u001e\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0017R\u0016\u0010 \u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0017R\u0016\u0010\"\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\u0017R\u0016\u0010$\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010\u0017R\u0016\u0010&\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010\u0017R\u0016\u0010(\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010\u0017\u00a8\u0006/"}, d2 = {"Lcom/tencent/ecommerce/biz/mainpage/h;", "Landroid/app/Dialog;", "", "initViews", "", "isFloat", "", "X", "Z", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "b0", "a0", "sampleOrderId", "c0", "W", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "Y", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "orderSubmitTv", "D", "halfOrderSubmitTv", "E", "orderListTv", UserInfo.SEX_FEMALE, "orderIdTv", "G", "orderDetailTv", "H", "sampleOrderSubmitTv", "I", "sampleOrderIdTv", "J", "sampleOrderDetailTv", "K", "ticketDetailTv", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "L", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class h extends ReportDialog {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView orderSubmitTv;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView halfOrderSubmitTv;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView orderListTv;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView orderIdTv;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView orderDetailTv;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView sampleOrderSubmitTv;

    /* renamed from: I, reason: from kotlin metadata */
    private TextView sampleOrderIdTv;

    /* renamed from: J, reason: from kotlin metadata */
    private TextView sampleOrderDetailTv;

    /* renamed from: K, reason: from kotlin metadata */
    private TextView ticketDetailTv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK, "com/tencent/ecommerce/biz/mainpage/ECQShopOrderEntranceDialog$initViews$1$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECScheme.g(h.this.X(false), null, 2, null);
            h.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK, "com/tencent/ecommerce/biz/mainpage/ECQShopOrderEntranceDialog$initViews$2$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECScheme.g(h.this.X(true), null, 2, null);
            h.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK, "com/tencent/ecommerce/biz/mainpage/ECQShopOrderEntranceDialog$initViews$3$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECScheme.g(h.this.W(), null, 2, null);
            h.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK, "com/tencent/ecommerce/biz/mainpage/ECQShopOrderEntranceDialog$initViews$5$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            String obj = h.Q(h.this).getText().toString();
            if (obj.length() == 0) {
                i.f(i.f101155b, "\u8bf7\u8f93\u5165\u8ba2\u5355ID", null, 0, 6, null);
            } else {
                ECShopOrderDetailFragment.INSTANCE.a(h.this.getContext(), obj, OrderDetailEntrance.FROM_UNKNOWN);
                h.this.b0(obj);
                h.this.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK, "com/tencent/ecommerce/biz/mainpage/ECQShopOrderEntranceDialog$initViews$6$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECScheme.g(h.this.Y().toString(), null, 2, null);
            h.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK, "com/tencent/ecommerce/biz/mainpage/ECQShopOrderEntranceDialog$initViews$8$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            String obj = h.R(h.this).getText().toString();
            if (obj.length() == 0) {
                i.f(i.f101155b, "\u8bf7\u8f93\u5165\u7533\u6837\u8ba2\u5355ID", null, 0, 6, null);
            } else {
                ECSampleOrderDetailFragment.INSTANCE.a(h.this.getContext(), obj, OrderDetailEntrance.FROM_UNKNOWN);
                h.this.c0(obj);
                h.this.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK, "com/tencent/ecommerce/biz/mainpage/ECQShopOrderEntranceDialog$initViews$9$1"}, k = 3, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.mainpage.h$h, reason: collision with other inner class name */
    /* loaded from: classes31.dex */
    public static final class ViewOnClickListenerC1060h implements View.OnClickListener {
        ViewOnClickListenerC1060h() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECScheme.g(li0.b.f414604a.a("492882452665039088", TicketDetail.INSTANCE.a()), null, 2, null);
            h.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public static final /* synthetic */ TextView Q(h hVar) {
        TextView textView = hVar.orderIdTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderIdTv");
        }
        return textView;
    }

    public static final /* synthetic */ TextView R(h hVar) {
        TextView textView = hVar.sampleOrderIdTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sampleOrderIdTv");
        }
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String W() {
        return "mqqapi://ecommerce/open?target=2&channel=2";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String X(boolean isFloat) {
        return ECOrderSubmitLauncherFragment.Companion.b(ECOrderSubmitLauncherFragment.INSTANCE, new SimpleSku("131290351130640385", 1), 3, 5, null, isFloat, 0, 40, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Uri Y() {
        return Uri.parse("mqqapi://ecommerce/open?").buildUpon().appendQueryParameter("target", String.valueOf(52)).appendQueryParameter("page_name", "apply_sample_order_submit_page").appendQueryParameter(WadlProxyConsts.CHANNEL, "2").appendQueryParameter("shop_id", "50369043852427267").appendQueryParameter("sku_id", "50420317927768321").appendQueryParameter("spu_id", "50420317927768066").appendQueryParameter("count", "1").build();
    }

    private final String Z() {
        return IECLocalConfig.a.f(ECLocalConfig.f100650f, "sp_key_order_test_id", "", null, 4, null);
    }

    private final String a0() {
        return IECLocalConfig.a.f(ECLocalConfig.f100650f, "sp_key_sample_order_test_id", "", null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b0(String orderId) {
        IECLocalConfig.a.j(ECLocalConfig.f100650f, "sp_key_order_test_id", orderId, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c0(String sampleOrderId) {
        IECLocalConfig.a.j(ECLocalConfig.f100650f, "sp_key_sample_order_test_id", sampleOrderId, null, 4, null);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ctk);
        setCanceledOnTouchOutside(true);
        initViews();
    }

    public h(Context context) {
        super(context, R.style.f243139);
    }

    private final void initViews() {
        TextView textView = (TextView) findViewById(R.id.odz);
        textView.setOnClickListener(new b());
        Unit unit = Unit.INSTANCE;
        this.orderSubmitTv = textView;
        TextView textView2 = (TextView) findViewById(R.id.f163116oe0);
        textView2.setOnClickListener(new c());
        this.halfOrderSubmitTv = textView2;
        TextView textView3 = (TextView) findViewById(R.id.ody);
        textView3.setOnClickListener(new d());
        this.orderListTv = textView3;
        TextView textView4 = (TextView) findViewById(R.id.nyj);
        textView4.setText(Z());
        this.orderIdTv = textView4;
        TextView textView5 = (TextView) findViewById(R.id.odx);
        textView5.setOnClickListener(new e());
        this.orderDetailTv = textView5;
        TextView textView6 = (TextView) findViewById(R.id.oe6);
        textView6.setOnClickListener(new f());
        this.sampleOrderSubmitTv = textView6;
        TextView textView7 = (TextView) findViewById(R.id.nyn);
        textView7.setText(a0());
        this.sampleOrderIdTv = textView7;
        TextView textView8 = (TextView) findViewById(R.id.oe5);
        textView8.setOnClickListener(new g());
        this.sampleOrderDetailTv = textView8;
        TextView textView9 = (TextView) findViewById(R.id.oek);
        textView9.setOnClickListener(new ViewOnClickListenerC1060h());
        this.ticketDetailTv = textView9;
    }
}
