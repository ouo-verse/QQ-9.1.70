package com.tenpay.payment.paymentout;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.qwallet.utils.QWalletUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tenpay.payment.QWalletPaymentExtKt;
import com.tenpay.payment.grouppay.GroupPaymentFragment;
import com.tenpay.payment.paymentin.PaymentInFragment;
import com.tenpay.payment.qrcodehb.QrCodeHbFragment;
import com.tenpay.payment.transfer.PayTransferFragment;
import cooperation.qwallet.plugin.QWalletPicHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import qk2.QrcodeConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0017\u0010\f\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tenpay/payment/paymentout/PaymentOutOtherEntryController;", "", "", "initConfig", "Landroid/view/View;", "view", "initView", "", "tabId", "gotoOtherPage", "init", "Lcom/tenpay/payment/paymentout/PaymentOutFragment;", "fragment", "Lcom/tenpay/payment/paymentout/PaymentOutFragment;", "getFragment", "()Lcom/tenpay/payment/paymentout/PaymentOutFragment;", "", "Lqk2/l$c;", "entryList", "Ljava/util/List;", "<init>", "(Lcom/tenpay/payment/paymentout/PaymentOutFragment;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final class PaymentOutOtherEntryController {

    @NotNull
    private final List<QrcodeConfig.TabbarItem> entryList;

    @NotNull
    private final PaymentOutFragment fragment;

    public PaymentOutOtherEntryController(@NotNull PaymentOutFragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.fragment = fragment;
        this.entryList = new ArrayList();
    }

    private final void gotoOtherPage(int tabId) {
        if (tabId != 2) {
            if (tabId != 3) {
                if (tabId != 4) {
                    if (tabId == 5) {
                        Intent intent = new Intent();
                        intent.putExtra("comeFrom", 1);
                        com.tencent.mobileqq.base.c.f(this.fragment.getContext(), intent, QrCodeHbFragment.class, false, 8, null);
                        return;
                    }
                    return;
                }
                com.tencent.mobileqq.base.c.f(this.fragment.getContext(), new Intent(), PayTransferFragment.class, false, 8, null);
                return;
            }
            com.tencent.mobileqq.base.c.f(this.fragment.getContext(), new Intent(), GroupPaymentFragment.class, false, 8, null);
            return;
        }
        com.tencent.mobileqq.base.c.f(this.fragment.getContext(), new Intent(), PaymentInFragment.class, false, 8, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void initConfig() {
        List list;
        boolean z16;
        boolean z17;
        this.entryList.clear();
        ArrayList<QrcodeConfig.TabbarItem> d16 = ((QrcodeConfig) ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).getConfig("qwallet_qrcode_config", new QrcodeConfig(null, null, null, null, null, 31, null))).d();
        if (d16 != null) {
            list = CollectionsKt___CollectionsKt.filterNotNull(d16);
        } else {
            list = null;
        }
        if (list != null) {
            List list2 = list;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    if (((QrcodeConfig.TabbarItem) it.next()).g()) {
                        z17 = true;
                        break;
                    }
                }
            }
            z17 = false;
            if (z17) {
                z16 = true;
                if (!z16) {
                    this.entryList.addAll(list);
                    return;
                } else {
                    if (this.entryList.isEmpty()) {
                        this.entryList.add(new QrcodeConfig.TabbarItem(2, this.fragment.getString(R.string.f2180362m), null, null, 0, 12, null));
                        this.entryList.add(new QrcodeConfig.TabbarItem(3, this.fragment.getString(R.string.f21782622), null, null, 1, 12, null));
                        this.entryList.add(new QrcodeConfig.TabbarItem(5, this.fragment.getString(R.string.f2184363p), null, null, 1, 12, null));
                        this.entryList.add(new QrcodeConfig.TabbarItem(4, this.fragment.getString(R.string.f21891650), null, null, 0, 12, null));
                        return;
                    }
                    return;
                }
            }
        }
        z16 = false;
        if (!z16) {
        }
    }

    private final void initView(View view) {
        Integer elderModeForbidden;
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.f653338n);
        QWalletUtils.v(viewGroup, 8.0f);
        viewGroup.removeAllViews();
        for (final QrcodeConfig.TabbarItem tabbarItem : this.entryList) {
            if (!TextUtils.isEmpty(tabbarItem.getTitle())) {
                boolean z16 = true;
                if (ol2.a.c() && (elderModeForbidden = tabbarItem.getElderModeForbidden()) != null && elderModeForbidden.intValue() == 1) {
                    QLog.i(QWalletPaymentExtKt.getPaymentTag(this), 1, "elderModeForbidden: " + tabbarItem);
                } else {
                    QLog.d(QWalletPaymentExtKt.getPaymentTag(this), 1, "addEntry:" + tabbarItem);
                    View tabView = View.inflate(view.getContext(), R.layout.fz6, null);
                    Intrinsics.checkNotNullExpressionValue(tabView, "tabView");
                    ol2.b.b(tabView, 0, false, 6, null);
                    View findViewById = tabView.findViewById(R.id.dx8);
                    Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.ImageView");
                    ImageView imageView = (ImageView) findViewById;
                    Drawable colorDrawable = new ColorDrawable(0);
                    int e16 = tabbarItem.e();
                    if (tabbarItem.g() && e16 != 0) {
                        colorDrawable = ContextCompat.getDrawable(imageView.getContext(), e16);
                    }
                    String imgUrl = tabbarItem.getImgUrl();
                    if (imgUrl != null && imgUrl.length() != 0) {
                        z16 = false;
                    }
                    if (!z16) {
                        imageView.setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(tabbarItem.getImgUrl(), colorDrawable, colorDrawable));
                    } else if (colorDrawable != null) {
                        imageView.setImageDrawable(colorDrawable);
                    }
                    View findViewById2 = tabView.findViewById(R.id.k_j);
                    Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
                    final TextView textView = (TextView) findViewById2;
                    textView.setText(tabbarItem.getTitle());
                    tabView.setTag(tabbarItem);
                    tabView.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.payment.paymentout.e
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            PaymentOutOtherEntryController.initView$lambda$1(QrcodeConfig.TabbarItem.this, this, view2);
                        }
                    });
                    ViewCompat.setAccessibilityDelegate(tabView, new AccessibilityDelegateCompat() { // from class: com.tenpay.payment.paymentout.PaymentOutOtherEntryController$initView$2
                        @Override // androidx.core.view.AccessibilityDelegateCompat
                        public void onInitializeAccessibilityNodeInfo(@NotNull View host, @NotNull AccessibilityNodeInfoCompat info) {
                            Intrinsics.checkNotNullParameter(host, "host");
                            Intrinsics.checkNotNullParameter(info, "info");
                            super.onInitializeAccessibilityNodeInfo(host, info);
                            info.setSelected(textView.isSelected());
                        }
                    });
                    viewGroup.addView(tabView, new LinearLayout.LayoutParams(-1, com.tencent.mobileqq.util.x.c(this.fragment.getContext(), 56.0f)));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(QrcodeConfig.TabbarItem item, PaymentOutOtherEntryController this$0, View view) {
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String link = item.getLink();
        if (link != null && link.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            com.tencent.mobileqq.qwallet.utils.k.h(this$0.fragment.getContext(), item.getLink());
        } else {
            this$0.gotoOtherPage(item.getId());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @NotNull
    public final PaymentOutFragment getFragment() {
        return this.fragment;
    }

    public final void init(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        initConfig();
        initView(view);
    }
}
