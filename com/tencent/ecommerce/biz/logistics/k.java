package com.tencent.ecommerce.biz.logistics;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.biz.orders.common.Coordinate;
import com.tencent.ecommerce.biz.orders.common.LogisticsInfo;
import com.tencent.ecommerce.biz.orders.common.LogisticsTraceItem;
import com.tencent.ecommerce.biz.orders.common.TrailStatus;
import com.tencent.ecommerce.biz.util.DateFormat;
import com.tencent.mobileqq.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002\u001a \u0010\t\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002\u001a\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0002\u001a(\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002\u001a\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002\u001a\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000fH\u0002\"\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0018"}, d2 = {"Landroid/content/Context;", "context", "Lcom/tencent/ecommerce/biz/orders/common/c;", "senderAddress", "Lcom/tencent/ecommerce/biz/orders/common/e;", "info", "Landroid/view/View;", "g", "receiverAddress", "f", "e", "address", "", "isSender", "d", "", "time", "i", "preTime", tl.h.F, "Ljava/text/SimpleDateFormat;", "a", "Ljava/text/SimpleDateFormat;", "simpleFormat", "ecommerce_sdk_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    private static final SimpleDateFormat f102908a = new SimpleDateFormat("yyyy\u5e74MM\u6708dd\u65e5");

    private static final String h(Context context, String str) {
        long d16 = com.tencent.ecommerce.biz.util.d.f104866a.d(str, DateFormat.YMD);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(d16));
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(new Date());
        if (calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2) && calendar.get(5) == calendar2.get(5)) {
            return context.getString(R.string.wk5);
        }
        calendar.add(5, 1);
        if (calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2) && calendar.get(5) == calendar2.get(5)) {
            return context.getString(R.string.wk6);
        }
        calendar.add(5, 1);
        if (calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2) && calendar.get(5) == calendar2.get(5)) {
            return context.getString(R.string.f169608wk4);
        }
        return i(str);
    }

    private static final String i(String str) {
        long d16 = com.tencent.ecommerce.biz.util.d.f104866a.d(str, DateFormat.YMD);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(d16));
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(new Date());
        String format = f102908a.format(Long.valueOf(d16));
        if (calendar.get(1) != calendar2.get(1)) {
            return format;
        }
        if (format != null) {
            String substring = format.substring(5);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
            return substring;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View f(Context context, Coordinate coordinate, LogisticsInfo logisticsInfo) {
        return d(context, coordinate, false, logisticsInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View g(Context context, Coordinate coordinate, LogisticsInfo logisticsInfo) {
        return d(context, coordinate, true, logisticsInfo);
    }

    private static final View d(Context context, Coordinate coordinate, boolean z16, LogisticsInfo logisticsInfo) {
        View inflate = View.inflate(context, R.layout.f167337cs0, null);
        a aVar = new a();
        aVar.b(ResourcesCompat.getColor(inflate.getResources(), R.color.f59307, null));
        aVar.a(ResourcesCompat.getColor(inflate.getResources(), R.color.f59307, null));
        Unit unit = Unit.INSTANCE;
        inflate.setBackground(aVar);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.o0z);
        TextView textView = (TextView) inflate.findViewById(R.id.nt9);
        TextView textView2 = (TextView) inflate.findViewById(R.id.nv6);
        if (z16) {
            textView.setText(coordinate.getCityName());
            if (logisticsInfo.currentStatus.status == TrailStatus.PICKED_UP) {
                imageView.setImageDrawable(ECSkin.INSTANCE.getDrawable(R.drawable.f159696dw2));
                textView.setTextColor(ResourcesCompat.getColor(context.getResources(), R.color.f6401g, null));
                if (logisticsInfo.estimatedDeliveryTime.length() > 0) {
                    textView2.setText(context.getResources().getString(R.string.wpc, h(context, logisticsInfo.estimatedDeliveryTime)));
                    textView2.setVisibility(0);
                } else {
                    textView2.setVisibility(8);
                }
            } else {
                imageView.setImageDrawable(ECSkin.INSTANCE.getDrawable(R.drawable.duq));
                textView.setTextColor(ResourcesCompat.getColor(context.getResources(), R.color.f6421i, null));
                textView2.setVisibility(8);
            }
        } else {
            textView.setText(coordinate.getCityName());
            int i3 = j.f102907a[logisticsInfo.currentStatus.status.ordinal()];
            if (i3 == 1) {
                imageView.setImageDrawable(ECSkin.INSTANCE.getDrawable(R.drawable.f159718er1));
                for (LogisticsTraceItem logisticsTraceItem : logisticsInfo.f()) {
                    if (logisticsTraceItem.status == TrailStatus.SIGNED) {
                        textView2.setText(context.getResources().getString(R.string.wto, i(logisticsTraceItem.acceptTime)));
                        textView2.setVisibility(0);
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            if (i3 != 2) {
                imageView.setImageDrawable(ECSkin.INSTANCE.getDrawable(R.drawable.dwj));
                textView2.setVisibility(8);
            } else {
                inflate.setBackground(new a());
                imageView.setVisibility(8);
                textView.setText(context.getString(R.string.wuf));
                textView2.setText(context.getString(R.string.wue));
                textView2.setVisibility(0);
                int color = ECSkin.INSTANCE.getColor(R.color.f59307);
                textView.setTextColor(color);
                textView2.setTextColor(color);
            }
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View e(Context context, LogisticsInfo logisticsInfo) {
        View inflate = View.inflate(context, R.layout.cry, null);
        inflate.setBackground(new a());
        ((TextView) inflate.findViewById(R.id.oc7)).setText(context.getResources().getString(R.string.f169607wk3, h(context, logisticsInfo.estimatedDeliveryTime)));
        return inflate;
    }
}
