package com.tencent.sqshow.zootopia.utils;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/sqshow/zootopia/utils/ac;", "", "", WidgetCacheConstellationData.NUM, "", "a", "Ljava/text/DecimalFormat;", "b", "Ljava/text/DecimalFormat;", "decimalFormat1", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ac {

    /* renamed from: a, reason: collision with root package name */
    public static final ac f373252a = new ac();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final DecimalFormat decimalFormat1;

    static {
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        DecimalFormatSymbols decimalFormatSymbols = DecimalFormatSymbols.getInstance(Locale.US);
        decimalFormatSymbols.setDecimalSeparator('.');
        decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        decimalFormat1 = decimalFormat;
    }

    ac() {
    }

    public final String a(int num) {
        boolean endsWith$default;
        if (num < 10000) {
            return String.valueOf(num);
        }
        if (num < 100000000) {
            String string = decimalFormat1.format(Float.valueOf(num / 10000.0f));
            Intrinsics.checkNotNullExpressionValue(string, "string");
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(string, ".0", false, 2, null);
            if (endsWith$default) {
                Intrinsics.checkNotNullExpressionValue(string, "string");
                string = StringsKt__StringsKt.substringBefore$default(string, ".", (String) null, 2, (Object) null);
            }
            return string + HardCodeUtil.qqStr(R.string.xry);
        }
        return (num / 100000000) + HardCodeUtil.qqStr(R.string.xrz);
    }
}
