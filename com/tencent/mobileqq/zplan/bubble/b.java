package com.tencent.mobileqq.zplan.bubble;

import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0006H&J\u0012\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\u0006H&J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\u0012\u0010\u0013\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H&J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H&J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H&\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/zplan/bubble/b;", "", "", "text", "", "showExpire", "", "f", "c", "", "uin", "g", "e", "Landroid/view/MotionEvent;", "event", "", "onTouch", "Landroid/widget/FrameLayout;", HippyNestedScrollComponent.PRIORITY_PARENT, "a", HippyTKDListViewAdapter.X, "y", "d", "Lcom/tencent/mobileqq/zplan/bubble/a;", "callback", "b", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface b {
    void a(@Nullable FrameLayout parent);

    void b(@NotNull a callback);

    void c();

    boolean d(int x16, int y16);

    void e();

    void f(@NotNull String text, int showExpire);

    void g(long uin);

    boolean onTouch(@Nullable MotionEvent event);
}
