package com.tencent.ecommerce.biz.orders.buyerorders.submit.viewholder;

import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.ktx.ViewExtKt;
import com.tencent.ecommerce.base.ktx.h;
import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.AccountInfoItemData;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.OrderSubmitListItemOperationListener;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.VirtualProductAccount;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.j;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.q;
import com.tencent.ecommerce.biz.orders.realname.RealNameAccount;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ;2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001<B\u0017\u0012\u0006\u00106\u001a\u000205\u0012\u0006\u00108\u001a\u000207\u00a2\u0006\u0004\b9\u0010:J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J\u001e\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00022\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0016R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010\u001bR\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u0006="}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/viewholder/ECOrderSubmitVirtualProductAccountViewHolder;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/q;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/a;", "", HippyTKDListViewAdapter.X, "v", "w", "", "tradeType", BdhLogUtil.LogTag.Tag_Conn, "accountType", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/k;", "account", "D", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/j$b;", "productType", "B", "y", "o", "data", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "", "payloads", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "titleTv", "G", "accountNameTv", "Landroid/widget/EditText;", "H", "Landroid/widget/EditText;", "accountValueEdt", "Landroid/widget/ImageView;", "I", "Landroid/widget/ImageView;", "accountValueClearBtn", "Landroid/widget/LinearLayout;", "J", "Landroid/widget/LinearLayout;", "selectAccountLayout", "K", "selectAccountValueText", "", "L", "Ljava/lang/String;", "lastAccountValue", "Lcom/tencent/ecommerce/biz/orders/realname/a;", "M", "Lcom/tencent/ecommerce/biz/orders/realname/a;", "lastAccount", "Landroid/view/View;", "view", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/OrderSubmitListItemOperationListener;", "itemOperationListener", "<init>", "(Landroid/view/View;Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/OrderSubmitListItemOperationListener;)V", "N", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECOrderSubmitVirtualProductAccountViewHolder extends q<AccountInfoItemData> {

    /* renamed from: F, reason: from kotlin metadata */
    private TextView titleTv;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView accountNameTv;

    /* renamed from: H, reason: from kotlin metadata */
    private EditText accountValueEdt;

    /* renamed from: I, reason: from kotlin metadata */
    private ImageView accountValueClearBtn;

    /* renamed from: J, reason: from kotlin metadata */
    private LinearLayout selectAccountLayout;

    /* renamed from: K, reason: from kotlin metadata */
    private TextView selectAccountValueText;

    /* renamed from: L, reason: from kotlin metadata */
    private String lastAccountValue;

    /* renamed from: M, reason: from kotlin metadata */
    private RealNameAccount lastAccount;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n\u00a2\u0006\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "hasFocus", "", "onFocusChange", "com/tencent/ecommerce/biz/orders/buyerorders/submit/viewholder/ECOrderSubmitVirtualProductAccountViewHolder$initAccountText$1$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements View.OnFocusChangeListener {
        b() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x001f, code lost:
        
            if ((r4.length() > 0) == true) goto L13;
         */
        @Override // android.view.View.OnFocusChangeListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void onFocusChange(View view, boolean z16) {
            boolean z17;
            ImageView q16 = ECOrderSubmitVirtualProductAccountViewHolder.q(ECOrderSubmitVirtualProductAccountViewHolder.this);
            if (z16 && (r4 = ECOrderSubmitVirtualProductAccountViewHolder.r(ECOrderSubmitVirtualProductAccountViewHolder.this).getText()) != null) {
                z17 = true;
            }
            z17 = false;
            q16.setVisibility(z17 ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            OrderSubmitListItemOperationListener orderSubmitListItemOperationListener = ((q) ECOrderSubmitVirtualProductAccountViewHolder.this).itemOperationListener;
            if (orderSubmitListItemOperationListener != null) {
                orderSubmitListItemOperationListener.onSelectRealAccount(ECOrderSubmitVirtualProductAccountViewHolder.this.lastAccount, 2);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e implements View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name */
        public static final e f103672d = new e();

        e() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            Map emptyMap;
            if (motionEvent.getAction() != 0) {
                return false;
            }
            com.tencent.ecommerce.base.report.service.b bVar = com.tencent.ecommerce.base.report.service.b.f100913b;
            emptyMap = MapsKt__MapsKt.emptyMap();
            IECDataReport.a.a(bVar, "qstore_order_submit_account_input_ck", emptyMap, false, 4, null);
            return false;
        }
    }

    public ECOrderSubmitVirtualProductAccountViewHolder(View view, OrderSubmitListItemOperationListener orderSubmitListItemOperationListener) {
        super(view, orderSubmitListItemOperationListener);
        this.lastAccountValue = "";
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void B(j.VirtualProduct productType) {
        String string;
        TextView textView;
        RealNameAccount realNameAccount = productType.getRealNameAccount();
        if (productType.id != 3) {
            LinearLayout linearLayout = this.selectAccountLayout;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectAccountLayout");
            }
            linearLayout.setVisibility(8);
            return;
        }
        LinearLayout linearLayout2 = this.selectAccountLayout;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectAccountLayout");
        }
        linearLayout2.setVisibility(0);
        if (realNameAccount != null) {
            if (!(realNameAccount.name.length() == 0)) {
                string = realNameAccount.name;
                textView = this.selectAccountValueText;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("selectAccountValueText");
                }
                textView.setText(string);
            }
        }
        string = getContext().getString(R.string.wsj);
        textView = this.selectAccountValueText;
        if (textView == null) {
        }
        textView.setText(string);
    }

    private final void D(int accountType, VirtualProductAccount account) {
        String string;
        TextView textView = this.accountNameTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountNameTv");
        }
        textView.setText(account.platformName);
        EditText editText = this.accountValueEdt;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountValueEdt");
        }
        if (account.type == 1) {
            string = getContext().getString(R.string.f169655wv4);
        } else {
            string = getContext().getString(R.string.f169654wv3);
        }
        editText.setHint(string);
        EditText editText2 = this.accountValueEdt;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountValueEdt");
        }
        String str = account.id;
        if (str == null) {
            str = "";
        }
        com.tencent.ecommerce.base.ktx.d.a(editText2, str);
        if (accountType == 2 || accountType == 3) {
            EditText editText3 = this.accountValueEdt;
            if (editText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("accountValueEdt");
            }
            editText3.setOnTouchListener(e.f103672d);
        }
    }

    public static final /* synthetic */ ImageView q(ECOrderSubmitVirtualProductAccountViewHolder eCOrderSubmitVirtualProductAccountViewHolder) {
        ImageView imageView = eCOrderSubmitVirtualProductAccountViewHolder.accountValueClearBtn;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountValueClearBtn");
        }
        return imageView;
    }

    public static final /* synthetic */ EditText r(ECOrderSubmitVirtualProductAccountViewHolder eCOrderSubmitVirtualProductAccountViewHolder) {
        EditText editText = eCOrderSubmitVirtualProductAccountViewHolder.accountValueEdt;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountValueEdt");
        }
        return editText;
    }

    private final void v() {
        Object[] plus;
        this.accountNameTv = (TextView) this.itemView.findViewById(R.id.np8);
        EditText editText = (EditText) this.itemView.findViewById(R.id.npa);
        editText.setOnFocusChangeListener(new b());
        Unit unit = Unit.INSTANCE;
        this.accountValueEdt = editText;
        this.accountValueClearBtn = (ImageView) this.itemView.findViewById(R.id.np7);
        EditText editText2 = this.accountValueEdt;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountValueEdt");
        }
        editText2.addTextChangedListener(new c());
        EditText editText3 = this.accountValueEdt;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountValueEdt");
        }
        plus = ArraysKt___ArraysJvmKt.plus((h[]) editText3.getFilters(), new h(100, new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.viewholder.ECOrderSubmitVirtualProductAccountViewHolder$initAccountText$$inlined$doOnReachMaxLength$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                i.f101155b.c(R.string.f169652wv1, ECToastIcon.ICON_ERROR, 0);
            }
        }));
        editText3.setFilters((InputFilter[]) plus);
        ImageView imageView = this.accountValueClearBtn;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountValueClearBtn");
        }
        ViewExtKt.c(imageView, 0L, new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.viewholder.ECOrderSubmitVirtualProductAccountViewHolder$initAccountText$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                ECOrderSubmitVirtualProductAccountViewHolder.r(ECOrderSubmitVirtualProductAccountViewHolder.this).setText("");
            }
        }, 1, null);
    }

    private final void w() {
        this.selectAccountLayout = (LinearLayout) this.itemView.findViewById(R.id.o_8);
        this.selectAccountValueText = (TextView) this.itemView.findViewById(R.id.o_9);
        LinearLayout linearLayout = this.selectAccountLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectAccountLayout");
        }
        linearLayout.setOnClickListener(new d());
    }

    private final void x() {
        this.titleTv = (TextView) this.itemView.findViewById(R.id.f163115od4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y() {
        OrderSubmitListItemOperationListener orderSubmitListItemOperationListener;
        EditText editText = this.accountValueEdt;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountValueEdt");
        }
        String obj = editText.getText().toString();
        if (!(!Intrinsics.areEqual(this.lastAccountValue, obj)) || (orderSubmitListItemOperationListener = this.itemOperationListener) == null) {
            return;
        }
        orderSubmitListItemOperationListener.onChangeAccountValue(obj);
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.submit.q
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void n(AccountInfoItemData data, List<? extends Object> payloads) {
        m(data);
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.submit.q
    public void o() {
        super.o();
        x();
        v();
        w();
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.submit.q
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void m(AccountInfoItemData data) {
        j.VirtualProduct virtualProduct = data.productType;
        String str = virtualProduct.account.id;
        if (str == null) {
            str = "";
        }
        this.lastAccountValue = str;
        this.lastAccount = virtualProduct.getRealNameAccount();
        C(virtualProduct.virtualType);
        D(virtualProduct.virtualType, virtualProduct.account);
        B(virtualProduct);
    }

    private final void C(int tradeType) {
        int i3 = (tradeType == 2 || tradeType == 3) ? R.string.wka : R.string.f169653wv2;
        TextView textView = this.titleTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTv");
        }
        textView.setText(getContext().getString(i3));
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u000f\u00b8\u0006\u0010"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "Landroid/text/Editable;", ReportConstant.COSTREPORT_PREFIX, "", "afterTextChanged", "L;", "text", "", "start", "count", "kotlin/Int", "beforeTextChanged", "before", "onTextChanged", "core-ktx_release", "androidx/core/widget/TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$1"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements TextWatcher {
        public c() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x0024, code lost:
        
            if (com.tencent.ecommerce.biz.orders.buyerorders.submit.viewholder.ECOrderSubmitVirtualProductAccountViewHolder.r(r3.f103670d).hasFocus() != false) goto L13;
         */
        @Override // android.text.TextWatcher
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void afterTextChanged(Editable s16) {
            boolean z16;
            ECOrderSubmitVirtualProductAccountViewHolder.this.y();
            ImageView q16 = ECOrderSubmitVirtualProductAccountViewHolder.q(ECOrderSubmitVirtualProductAccountViewHolder.this);
            if (s16 != null) {
                z16 = true;
                if (s16.length() > 0) {
                }
            }
            z16 = false;
            q16.setVisibility(z16 ? 0 : 8);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
