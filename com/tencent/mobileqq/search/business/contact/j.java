package com.tencent.mobileqq.search.business.contact;

import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0004H\u0007R\u0016\u0010\u000e\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/search/business/contact/j;", "", "", "keyWorld", "", "usNT", "", "c", "", "searchedCount", "a", "isSucc", "b", "Z", "isSearching", "Ljava/lang/String;", "keyWord", "d", "", "e", "J", "startTime", "f", "I", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class j {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean isSearching;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static boolean usNT;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static long startTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static int searchedCount;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j f282950a = new j();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String keyWord = "";

    j() {
    }

    @JvmStatic
    public static final void a(int searchedCount2) {
        searchedCount = searchedCount2;
        isSearching = false;
    }

    @JvmStatic
    public static final void b(boolean isSucc) {
        if (startTime <= 0) {
            return;
        }
        String currentUin = MobileQQ.sMobileQQ.peekAppRuntime().getAccount();
        long currentTimeMillis = System.currentTimeMillis() - startTime;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("keyword", keyWord);
        linkedHashMap.put("duration", String.valueOf(currentTimeMillis));
        linkedHashMap.put("searchCount", String.valueOf(searchedCount));
        Intrinsics.checkNotNullExpressionValue(currentUin, "currentUin");
        linkedHashMap.put("user_uin", currentUin);
        linkedHashMap.put("isNTVersion", String.valueOf(usNT ? 1 : 0));
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("ContactsSearchReporter", 2, " report Search detail: " + linkedHashMap);
        }
        QQBeaconReport.reportWithAppKey("0DOU0TYBSY4OEY1K", currentUin, "friend_selector_search_cost", isSucc, linkedHashMap, true);
        startTime = 0L;
    }

    @JvmStatic
    public static final void c(@NotNull String keyWorld, boolean usNT2) {
        Intrinsics.checkNotNullParameter(keyWorld, "keyWorld");
        keyWord = keyWorld;
        usNT = usNT2;
        startTime = System.currentTimeMillis();
        isSearching = true;
    }
}
