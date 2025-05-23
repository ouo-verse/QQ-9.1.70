package com.tencent.mobileqq.zplan.view;

import android.view.MotionEvent;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0006J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/zplan/view/b;", "", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/zplan/bubble/b;", "avatarBubbleRef", "", "a", "Landroid/view/MotionEvent;", "event", "c", "", "externalEntrance", "b", "Lcom/tencent/mobileqq/zplan/view/b$a;", "listener", "d", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/zplan/view/b$a;", "", "", "jumpType", "", "gotoPortal", "gotoSmallHome", "showMaintain", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface a {
        void gotoPortal(int jumpType);

        void gotoSmallHome();

        void showMaintain();
    }

    void a(@NotNull WeakReference<com.tencent.mobileqq.zplan.bubble.b> avatarBubbleRef);

    void b(@NotNull String externalEntrance);

    void c(@Nullable MotionEvent event);

    void d(@NotNull a listener);
}
