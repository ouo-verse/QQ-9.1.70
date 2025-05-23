package com.tencent.ecommerce.biz.logistics;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.biz.orders.address.ECAddress;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001c\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u001c\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u001c\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\tR\u001c\u0010\u0012\u001a\n \u0007*\u0004\u0018\u00010\u000f0\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/ecommerce/biz/logistics/p;", "Lcom/tencent/ecommerce/biz/logistics/o;", "Lcom/tencent/ecommerce/biz/logistics/s;", "data", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "E", "Landroid/widget/TextView;", "address", UserInfo.SEX_FEMALE, "name", "G", "phone", "Landroid/widget/ImageView;", "H", "Landroid/widget/ImageView;", "statusImage", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class p extends o<ReceiverAddressData> {

    /* renamed from: E, reason: from kotlin metadata */
    private final TextView address;

    /* renamed from: F, reason: from kotlin metadata */
    private final TextView name;

    /* renamed from: G, reason: from kotlin metadata */
    private final TextView phone;

    /* renamed from: H, reason: from kotlin metadata */
    private final ImageView statusImage;

    @Override // com.tencent.ecommerce.biz.logistics.o
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void l(ReceiverAddressData data) {
        CharSequence replaceRange;
        ECAddress eCAddress = data.address;
        this.address.setText(eCAddress.province + eCAddress.city + eCAddress.district + eCAddress.street + eCAddress.detailAddress);
        this.name.setText(eCAddress.consignee);
        TextView textView = this.phone;
        String str = eCAddress.maskedPhoneNumber;
        if (str.length() == 0) {
            String str2 = eCAddress.phoneNumber;
            IntRange intRange = new IntRange(3, 6);
            if (str2 != null) {
                replaceRange = StringsKt__StringsKt.replaceRange((CharSequence) str2, intRange, (CharSequence) "****");
                str = replaceRange.toString();
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            }
        }
        textView.setText(str);
        ImageView imageView = this.statusImage;
        ECSkin eCSkin = ECSkin.INSTANCE;
        imageView.setImageDrawable(eCSkin.getDrawable(data.statusIconResId));
        int color = eCSkin.getColor(data.getTextColorResID());
        this.address.setTextColor(color);
        this.name.setTextColor(color);
        this.phone.setTextColor(color);
    }

    public p(View view) {
        super(view, null);
        this.address = (TextView) view.findViewById(R.id.npi);
        this.name = (TextView) view.findViewById(R.id.o4z);
        this.phone = (TextView) view.findViewById(R.id.o6l);
        this.statusImage = (ImageView) view.findViewById(R.id.ob5);
    }
}
