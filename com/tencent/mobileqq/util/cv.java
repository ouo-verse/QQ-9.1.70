package com.tencent.mobileqq.util;

import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import cooperation.qzone.thread.QzoneBaseThread;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0007J\b\u0010\n\u001a\u00020\u0002H\u0007R\u0016\u0010\r\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\fR\u0016\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/util/cv;", "", "", "e", "", "prefix", "c", "d", "tab", "a", "b", "", "J", "startTime", "", "Z", "isJumpToGuild", "isReported", "<init>", "()V", "QQActivity_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class cv {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final cv f306745a = new cv();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static long startTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean isJumpToGuild;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static boolean isReported;

    cv() {
    }

    @JvmStatic
    public static final void a(@NotNull String tab) {
        String str;
        Intrinsics.checkNotNullParameter(tab, "tab");
        if (isReported) {
            return;
        }
        boolean areEqual = Intrinsics.areEqual(TabDataHelper.TAB_CONVERSATION, tab);
        boolean z16 = true;
        if (areEqual && !af.d() && isJumpToGuild) {
            QLog.e("FrameUtil.TabCostUtil", 1, "TabHost\u4e0b\u7b2c\u4e00\u6b21\u5197\u4f59\u7684\u6d88\u606fTab\u4e0a\u62a5\u8fc7\u6ee4\u6389");
            return;
        }
        isReported = true;
        long currentTimeMillis = System.currentTimeMillis() - startTime;
        if (currentTimeMillis > 10000) {
            return;
        }
        if (af.d()) {
            str = "1";
        } else {
            str = "0";
        }
        QLog.e("FrameUtil.TabCostUtil", 1, "first_" + tab + ", opt=" + str + ", cost=" + currentTimeMillis + ", QZoneLooper=" + QzoneBaseThread.cost);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("tab", tab);
        linkedHashMap.put(QCircleWeakNetReporter.KEY_COST, String.valueOf(currentTimeMillis));
        linkedHashMap.put("tabLayout", str);
        linkedHashMap.put("QZoneLooper", String.valueOf(QzoneBaseThread.cost));
        if (!areEqual ? Random.INSTANCE.nextInt(0, 10) != 0 : Random.INSTANCE.nextInt(0, 1000) != 0) {
            z16 = false;
        }
        if (z16) {
            com.tencent.mobileqq.inject.v.c(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin(), "main_tab_first_draw_cost", linkedHashMap);
        }
    }

    @JvmStatic
    public static final void b() {
        isJumpToGuild = true;
        c("jumpToGuild");
    }

    @JvmStatic
    public static final void c(@NotNull String prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (!isReported && QLog.isDevelopLevel()) {
            QLog.e("FrameUtil.TabCostUtil", 1, prefix + ", cost=" + (System.currentTimeMillis() - startTime));
        }
    }

    @JvmStatic
    public static final void d(@NotNull String prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (!isReported && QLog.isDevelopLevel()) {
            QLog.e("FrameUtil.TabCostUtil", 1, prefix + ", cost=" + (System.currentTimeMillis() - startTime));
        }
    }

    @JvmStatic
    public static final void e() {
        startTime = System.currentTimeMillis();
        QLog.e("FrameUtil.TabCostUtil", 1, "start");
    }
}
