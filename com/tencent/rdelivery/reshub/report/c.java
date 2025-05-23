package com.tencent.rdelivery.reshub.report;

import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0003\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\" \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0002\u0010\u0005\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/rdelivery/reshub/report/a;", "", "a", "", "", "Ljava/util/Map;", "ERROR_MESSAGES", "reshub_debug"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<Integer, String> f364569a;

    static {
        Map<Integer, String> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(0, "\u6210\u529f"), TuplesKt.to(1001, "\u62c9\u53d6\u914d\u7f6e\u8bf7\u6c42HTTP\u9519\u8bef"), TuplesKt.to(1002, "\u62c9\u53d6\u914d\u7f6e\u8bf7\u6c42\u5176\u4ed6\u7f51\u7edc\u9519\u8bef"), TuplesKt.to(1003, "\u62c9\u53d6\u914d\u7f6e\u63a5\u53e3\u8fd4\u56de\u9519\u8bef"), TuplesKt.to(1004, "\u62c9\u53d6\u914d\u7f6e\u63a5\u53e3\u8fd4\u56de\u6570\u636e\u4e3a\u7a7a"), TuplesKt.to(1005, "\u62c9\u53d6\u914d\u7f6e\u63a5\u53e3\u8fd4\u56de\u6570\u636e\u6821\u9a8c\u5931\u8d25"), TuplesKt.to(1006, "\u63a5\u53e3\u5165\u53c2\u9519\u8bef"), TuplesKt.to(1007, "\u63a5\u53e3\u8fd4\u56de\u8d44\u6e90\u4e3a\u7a7a(\u6216\u4e0d\u5b58\u5728)"), TuplesKt.to(1008, "\u63a5\u53e3\u8fd4\u56de\u8bbf\u95eeRedis\u8d44\u6e90\u5931\u8d25"), TuplesKt.to(1009, "\u8bf7\u6c42\u7684\u8d44\u6e90ID\u4e0d\u5408\u6cd5"), TuplesKt.to(1010, "CDN\u9ad8\u8d1f\u8f7d\u72b6\u6001\uff0c\u653e\u5f03\u4e0b\u8f7d"), TuplesKt.to(2001, "\u5168\u91cf\u6587\u4ef6\u4e0b\u8f7dHTTP\u9519\u8bef"), TuplesKt.to(2002, "\u5168\u91cf\u6587\u4ef6\u4e0b\u8f7d\u5176\u4ed6\u7f51\u7edc\u9519\u8bef"), TuplesKt.to(2003, "\u5168\u91cf\u6587\u4ef6\u4e0b\u8f7d\u7f51\u7edc\u72b6\u6001\u9650\u5236"), TuplesKt.to(2004, "\u5168\u91cf\u6587\u4ef6\u4e0b\u8f7d\u7a7a\u95f4\u4e0d\u8db3"), TuplesKt.to(2005, "\u5168\u91cf\u6587\u4ef6\u4e0b\u8f7d\u6587\u4ef6\u64cd\u4f5c\u9519\u8bef\uff0c\u6587\u4ef6(\u521b\u5efa/\u79fb\u52a8/\u91cd\u547d\u540d)\u5931\u8d25"), TuplesKt.to(2006, "\u5168\u91cf\u6587\u4ef6MD5\u6821\u9a8c\u5931\u8d25"), TuplesKt.to(2007, "\u5168\u91cf\u6587\u4ef6\u89e3\u5bc6\u5931\u8d25"), TuplesKt.to(3001, "\u89e3\u538b\u5931\u8d25"), TuplesKt.to(3002, "\u89e3\u538b\u540e\u6587\u4ef6\u6821\u9a8c\u5931\u8d25"), TuplesKt.to(3101, "\u4ee5\u538b\u7f29\u65b9\u5f0f\u4e0b\u53d1\u7684\u8d44\u6e90\u89e3\u538b\u5931\u8d25"), TuplesKt.to(3102, "\u4ee5\u538b\u7f29\u65b9\u5f0f\u4e0b\u53d1\u7684\u8d44\u6e90\u89e3\u538b\u540e\u6587\u4ef6\u6821\u9a8c\u5931\u8d25"), TuplesKt.to(4001, "\u66f4\u65b0\u672c\u5730\u8d44\u6e90\u914d\u7f6e\u65f6\u53d1\u751f\u5f02\u5e38"), TuplesKt.to(4002, "\u8bfb\u53d6\u5230\u7684\u672c\u5730\u8d44\u6e90\u662f\u5173\u95ed\u72b6\u6001"), TuplesKt.to(5001, "\u5dee\u91cf\u6587\u4ef6\u4e0b\u8f7dHTTP\u9519\u8bef"), TuplesKt.to(5002, "\u5dee\u91cf\u6587\u4ef6\u4e0b\u8f7d\u5176\u4ed6\u7f51\u7edc\u9519\u8bef"), TuplesKt.to(5003, "\u5dee\u91cf\u6587\u4ef6\u4e0b\u8f7d\u7f51\u7edc\u72b6\u6001\u9650\u5236"), TuplesKt.to(5004, "\u5dee\u91cf\u6587\u4ef6\u4e0b\u8f7d\u7a7a\u95f4\u4e0d\u8db3"), TuplesKt.to(5005, "\u5dee\u91cf\u6587\u4ef6\u4e0b\u8f7d\u6587\u4ef6\u64cd\u4f5c\u9519\u8bef\uff0c\u6587\u4ef6(\u521b\u5efa/\u79fb\u52a8/\u91cd\u547d\u540d)\u5931\u8d25"), TuplesKt.to(5006, "\u5dee\u91cf\u6587\u4ef6MD5\u6821\u9a8c\u5931\u8d25"), TuplesKt.to(5007, "\u5dee\u91cf\u6587\u4ef6Patch\u5931\u8d25"), TuplesKt.to(5008, "Patch\u540e\u6587\u4ef6MD5\u6821\u9a8c\u5931\u8d25"), TuplesKt.to(10001, "\u521d\u59cb\u5316\u9519\u8bef"), TuplesKt.to(10002, "\u5916\u90e8\u914d\u7f6e\u9519\u8bef"), TuplesKt.to(10003, "\u5916\u90e8\u72b6\u6001\u56de\u8c03\u5f02\u5e38"), TuplesKt.to(10004, "\u5185\u90e8\u52a0\u8f7d\u5904\u7406\u53d1\u751f\u5f02\u5e38"), TuplesKt.to(11001, "\u83b7\u53d6\u672c\u5730\u8d44\u6e90\u65f6\uff0c\u8d44\u6e90\u6587\u4ef6\u65e0\u6548"), TuplesKt.to(12001, "\u7528\u6237\u62e6\u622a\u5e76\u53d6\u6d88\u4e86\u8d44\u6e90\u9884\u52a0\u8f7d"));
        f364569a = mapOf;
    }

    @NotNull
    public static final String a(@NotNull a getErrorMessage) {
        Intrinsics.checkParameterIsNotNull(getErrorMessage, "$this$getErrorMessage");
        String str = f364569a.get(Integer.valueOf(getErrorMessage.getErrorCode()));
        if (str == null) {
            str = "[\u65e0\u9519\u8bef\u63cf\u8ff0]";
        }
        if (getErrorMessage.getExtraMessage() != null) {
            return str + ", " + getErrorMessage.getExtraMessage();
        }
        return str;
    }
}
