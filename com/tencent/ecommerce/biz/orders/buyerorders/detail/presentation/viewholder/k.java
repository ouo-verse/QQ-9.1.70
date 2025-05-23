package com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.viewholder;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.imageloader.api.IECImageLoader;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.model.TicketDetail;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010!\u001a\u00020 \u00a2\u0006\u0004\b\"\u0010#J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\"\u0010\r\u001a\u00020\u00062\n\u0010\u0005\u001a\u00060\u0004j\u0002`\b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0014R\u0016\u0010\u001b\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0014R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/viewholder/k;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/content/Context;", "context", "", "id", "", "p", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/TicketIdentifier;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/e;", "detail", "", "position", "o", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "bgView", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "titleView", "G", "idView", "H", "copyView", "I", "deadlineView", "Landroid/widget/LinearLayout;", "J", "Landroid/widget/LinearLayout;", "detailLayout", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class k extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    private ImageView bgView;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView titleView;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView idView;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView copyView;

    /* renamed from: I, reason: from kotlin metadata */
    private TextView deadlineView;

    /* renamed from: J, reason: from kotlin metadata */
    private LinearLayout detailLayout;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002#\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007J\u0013\u0010\b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0096\u0002\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/viewholder/k$a", "Lkotlin/Function1;", "Landroid/graphics/drawable/Drawable;", "Lkotlin/ParameterName;", "name", "drawable", "", "Lcom/tencent/ecommerce/base/imageloader/api/Callback;", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a implements Function1<Drawable, Unit> {
        a() {
        }

        public void a(Drawable drawable) {
            k.this.bgView.setImageDrawable(drawable);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Drawable drawable) {
            a(drawable);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class b implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f103373e;

        b(String str) {
            this.f103373e = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            k kVar = k.this;
            kVar.p(kVar.copyView.getContext(), this.f103373e);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f103374d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ TicketDetail f103375e;

        c(String str, TicketDetail ticketDetail) {
            this.f103374d = str;
            this.f103375e = ticketDetail;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECScheme.g(li0.b.f414604a.a(this.f103374d, this.f103375e), null, 2, null);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public k(View view) {
        super(view);
        this.bgView = (ImageView) view.findViewById(R.id.o19);
        this.titleView = (TextView) view.findViewById(R.id.oep);
        this.idView = (TextView) view.findViewById(R.id.oel);
        this.copyView = (TextView) view.findViewById(R.id.odc);
        this.deadlineView = (TextView) view.findViewById(R.id.odh);
        this.detailLayout = (LinearLayout) view.findViewById(R.id.nvd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(Context context, String id5) {
        Object systemService = context.getSystemService("clipboard");
        if (systemService != null) {
            ClipboardMonitor.setPrimaryClip((ClipboardManager) systemService, ClipData.newPlainText("ticketId", id5));
            com.tencent.ecommerce.base.ui.i.f101155b.d(context.getString(R.string.wu6), ECToastIcon.ICON_SUCCESS, 0);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.content.ClipboardManager");
    }

    public final void o(String id5, TicketDetail detail, int position) {
        ColorDrawable colorDrawable = new ColorDrawable(0);
        ECSkin.INSTANCE.getDrawable("qecommerce_skin_img_coupon_little", new IECImageLoader.ImageLoaderOption(this.bgView.getMeasuredWidth(), this.bgView.getMeasuredHeight(), 0, null, colorDrawable, colorDrawable, false, false, null, LocaleManager.MOBILE_COUNTRY_CODE_CN_INT, null), new a());
        this.idView.setText(id5);
        this.titleView.setText(detail.name + (position + 1));
        this.deadlineView.setText(detail.deadlineStr);
        this.copyView.setOnClickListener(new b(id5));
        this.detailLayout.setOnClickListener(new c(id5, detail));
    }
}
