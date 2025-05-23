package com.tencent.mobileqq.profilecard.view.head;

import android.graphics.Point;
import android.view.MotionEvent;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/profilecard/view/head/MiniHomeViewActionConfig;", "", "()V", "TAG", "", "downPoint", "Landroid/graphics/Point;", "isDownEvent", "", "moveThreshold", "", QCircleLpReportDc05507.KEY_CLEAR, "", "handleMotion", "event", "Landroid/view/MotionEvent;", "profilecard_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class MiniHomeViewActionConfig {
    private static boolean isDownEvent = false;
    private static final int moveThreshold = 10;
    public static final MiniHomeViewActionConfig INSTANCE = new MiniHomeViewActionConfig();
    private static Point downPoint = new Point(0, 0);
    private static String TAG = "MiniHomeViewActionConfig";

    MiniHomeViewActionConfig() {
    }

    public final boolean handleMotion(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getAction() == 0) {
            clear();
            isDownEvent = true;
            downPoint.x = (int) event.getX();
            downPoint.y = (int) event.getY();
            QLog.i(TAG, 1, "handleMotion downpoint= " + downPoint);
            return false;
        }
        if (event.getAction() == 3) {
            clear();
            return false;
        }
        if (event.getAction() != 1 || !isDownEvent) {
            return false;
        }
        Point point = new Point((int) event.getX(), (int) event.getY());
        QLog.i(TAG, 1, "handleMotion upPoint " + point);
        return Math.abs(point.x - downPoint.x) <= 10 || Math.abs(point.y - downPoint.y) <= 10;
    }

    private final void clear() {
        isDownEvent = false;
        downPoint = new Point(0, 0);
    }
}
