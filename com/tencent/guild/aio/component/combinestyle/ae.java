package com.tencent.guild.aio.component.combinestyle;

import android.graphics.Color;
import android.widget.TextView;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\u001aD\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022*\u0010\u0007\u001a&\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004j\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u0001`\u0006\u001aD\u0010\n\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022*\u0010\u0007\u001a&\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004j\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u0001`\u0006\"\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0017\u0010\u0013\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000f\"\u0017\u0010\u0015\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0011\u0010\u000f\"\u0017\u0010\u0017\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\r\u001a\u0004\b\u0014\u0010\u000f\"\u0017\u0010\u0019\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0018\u0010\u000f\"\u0017\u0010\u001a\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\r\u001a\u0004\b\u0016\u0010\u000f\"\u0017\u0010\u001b\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\r\u001a\u0004\b\f\u0010\u000f\u00a8\u0006\u001c"}, d2 = {"Landroid/widget/TextView;", "textView", "", "elementId", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "paramMap", "", tl.h.F, "i", "", "a", "I", "f", "()I", "textDrawableIconWidth", "b", "e", "textDrawableIconHeight", "c", "horPaddingL", "d", "horPaddingR", "g", "verPadding", "ivSize", "CLICK_DETAIL_COLOR", "aio-guild-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class ae {

    /* renamed from: a, reason: collision with root package name */
    private static final int f110193a = ViewUtils.dip2px(18.0f);

    /* renamed from: b, reason: collision with root package name */
    private static final int f110194b = ViewUtils.dip2px(18.0f);

    /* renamed from: c, reason: collision with root package name */
    private static final int f110195c = ViewUtils.dip2px(5.0f);

    /* renamed from: d, reason: collision with root package name */
    private static final int f110196d = ViewUtils.dip2px(8.0f);

    /* renamed from: e, reason: collision with root package name */
    private static final int f110197e = ViewUtils.dip2px(6.0f);

    /* renamed from: f, reason: collision with root package name */
    private static final int f110198f = ViewUtils.dip2px(20.0f);

    /* renamed from: g, reason: collision with root package name */
    private static final int f110199g = Color.parseColor("#0099FF");

    public static final int a() {
        return f110199g;
    }

    public static final int b() {
        return f110195c;
    }

    public static final int c() {
        return f110196d;
    }

    public static final int d() {
        return f110198f;
    }

    public static final int e() {
        return f110194b;
    }

    public static final int f() {
        return f110193a;
    }

    public static final int g() {
        return f110197e;
    }

    public static final void h(@NotNull TextView textView, @Nullable String str, @Nullable HashMap<String, Object> hashMap) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        if (str != null) {
            IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
            if (hashMap == null) {
                hashMap = new HashMap<>();
            }
            iGuildDTReportApi.reportDtEventManual(textView, str, "clck", hashMap);
        }
    }

    public static final void i(@NotNull TextView textView, @Nullable String str, @Nullable HashMap<String, Object> hashMap) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        if (str != null) {
            IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
            if (hashMap == null) {
                hashMap = new HashMap<>();
            }
            iGuildDTReportApi.reportDtEventManual(textView, str, "imp", hashMap);
        }
    }
}
