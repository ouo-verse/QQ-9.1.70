package com.tencent.ecommerce.biz.orders.address.picker;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/picker/ECTabItemView;", "Landroid/widget/LinearLayout;", "", "setSelected", "a", "", HippyControllerProps.STRING, "setTitle", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "title", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "indicator", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECTabItemView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final TextView title;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ImageView indicator;

    public ECTabItemView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.f167355cv3, this);
        this.title = (TextView) findViewById(R.id.oc7);
        this.indicator = (ImageView) findViewById(R.id.obv);
    }

    public final void a() {
        this.indicator.setVisibility(4);
    }

    public final void setSelected() {
        this.indicator.setVisibility(0);
    }

    public final void setTitle(String string) {
        this.title.setText(string);
    }
}
