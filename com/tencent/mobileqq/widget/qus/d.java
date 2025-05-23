package com.tencent.mobileqq.widget.qus;

import android.view.View;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0004H&J\b\u0010\t\u001a\u00020\u0004H&J\b\u0010\n\u001a\u00020\u0004H&J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH&J\u0018\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/widget/qus/d;", "", "Landroid/view/View;", "createContentView", "", "defaultHeight", NodeProps.MAX_HEIGHT, "minMarginTop", NodeProps.MIN_HEIGHT, "showMode", "initState", "", HippyTKDListViewAdapter.X, "y", "", "canScrollUp", "canScrollDown", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public interface d {
    boolean canScrollDown(float x16, float y16);

    boolean canScrollUp(float x16, float y16);

    @Nullable
    View createContentView();

    int defaultHeight();

    int initState();

    int maxHeight();

    int minHeight();

    int minMarginTop();

    int showMode();
}
