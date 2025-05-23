package com.tencent.biz.qqcircle.events;

import android.view.View;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/biz/qqcircle/events/QFSCommentDoubleTapEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "viewWrf", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", HippyTKDListViewAdapter.X, "", "y", "(Ljava/lang/ref/WeakReference;FF)V", "getViewWrf", "()Ljava/lang/ref/WeakReference;", "getX", "()F", "getY", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class QFSCommentDoubleTapEvent extends SimpleBaseEvent {

    @NotNull
    private final WeakReference<View> viewWrf;
    private final float x;
    private final float y;

    public QFSCommentDoubleTapEvent(@NotNull WeakReference<View> viewWrf, float f16, float f17) {
        Intrinsics.checkNotNullParameter(viewWrf, "viewWrf");
        this.viewWrf = viewWrf;
        this.x = f16;
        this.y = f17;
    }

    @NotNull
    public final WeakReference<View> getViewWrf() {
        return this.viewWrf;
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }
}
