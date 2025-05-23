package com.tencent.sqshow.zootopia.utils;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u0010\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\f"}, d2 = {"Lcom/tencent/sqshow/zootopia/utils/e;", "", "", "str", "b", "", WidgetCacheConstellationData.NUM, "a", "", "c", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f373267a = new e();

    e() {
    }

    public final String a(int num) {
        DecimalFormat decimalFormat = new DecimalFormat("###.0");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        if (num < 100000) {
            return String.valueOf(num);
        }
        if (num < 100000000) {
            return decimalFormat.format((num * 1.0d) / 1000) + "K";
        }
        if (num < 1215752192) {
            return decimalFormat.format((num * 1.0d) / 1000000) + "M";
        }
        return decimalFormat.format((num * 1.0d) / 1000000000) + "B";
    }

    public final String b(String str) {
        if (str == null) {
            return "";
        }
        try {
            return a(Integer.parseInt(str));
        } catch (Exception unused) {
            return "";
        }
    }

    public final boolean c(String str) {
        if (str == null) {
            return false;
        }
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (!Character.isDigit(str.charAt(i3))) {
                return false;
            }
        }
        return true;
    }
}
