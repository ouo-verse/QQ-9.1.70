package com.tencent.mobileqq.widget.qus;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/widget/qus/e;", "Lcom/tencent/mobileqq/widget/qus/d;", "", "defaultHeight", "showMode", NodeProps.MAX_HEIGHT, NodeProps.MIN_HEIGHT, "minMarginTop", "initState", "", HippyTKDListViewAdapter.X, "y", "", "canScrollDown", "canScrollUp", "<init>", "()V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public abstract class e implements d {
    @Override // com.tencent.mobileqq.widget.qus.d
    public boolean canScrollDown(float x16, float y16) {
        return false;
    }

    @Override // com.tencent.mobileqq.widget.qus.d
    public boolean canScrollUp(float x16, float y16) {
        return false;
    }

    @Override // com.tencent.mobileqq.widget.qus.d
    public int defaultHeight() {
        return 0;
    }

    @Override // com.tencent.mobileqq.widget.qus.d
    public int initState() {
        return 2;
    }

    @Override // com.tencent.mobileqq.widget.qus.d
    public int maxHeight() {
        return 0;
    }

    @Override // com.tencent.mobileqq.widget.qus.d
    public int minHeight() {
        return 0;
    }

    @Override // com.tencent.mobileqq.widget.qus.d
    public int minMarginTop() {
        return 0;
    }

    @Override // com.tencent.mobileqq.widget.qus.d
    public int showMode() {
        return 0;
    }
}
