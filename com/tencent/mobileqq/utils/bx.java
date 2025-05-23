package com.tencent.mobileqq.utils;

import android.os.Bundle;
import android.view.View;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u00a2\u0006\u0004\b\u001f\u0010 J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0014J\u0018\u0010\u000e\u001a\u00020\u00052\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\fH\u0014J\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H\u0014J\"\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0014J\u0006\u0010\u0018\u001a\u00020\u0005R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001b\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/utils/bx;", "Landroidx/customview/widget/ExploreByTouchHelper;", "", "Lcom/tencent/mobileqq/utils/bz;", "newList", "", "b", "", HippyTKDListViewAdapter.X, "y", "", "getVirtualViewAt", "", "virtualViewIds", "getVisibleVirtualViews", "virtualViewId", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "node", "onPopulateNodeForVirtualView", "action", "Landroid/os/Bundle;", "arguments", "", "onPerformActionForVirtualView", "a", "Ljava/util/List;", "ocrImageBeanList", "I", "selectedId", "Landroid/view/View;", "host", "<init>", "(Landroid/view/View;)V", "c", "qqocr-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class bx extends ExploreByTouchHelper {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<OCRImageBean> ocrImageBeanList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int selectedId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/utils/bx$a;", "", "", "a", "()Z", "disable", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqocr-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.utils.bx$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("ocr_revert_accessibility", false);
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bx(@NotNull View host) {
        super(host);
        Intrinsics.checkNotNullParameter(host, "host");
        this.ocrImageBeanList = new ArrayList();
        this.selectedId = -1;
    }

    public final void a() {
        int i3 = this.selectedId;
        if (i3 >= 0 && i3 < this.ocrImageBeanList.size()) {
            invalidateVirtualView(this.selectedId, 4);
        }
    }

    public final void b(@NotNull List<OCRImageBean> newList) {
        Intrinsics.checkNotNullParameter(newList, "newList");
        this.ocrImageBeanList.clear();
        this.ocrImageBeanList.addAll(newList);
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    protected int getVirtualViewAt(float x16, float y16) {
        int size = this.ocrImageBeanList.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.ocrImageBeanList.get(i3).getPosition().contains((int) x16, (int) y16)) {
                return i3;
            }
        }
        return Integer.MIN_VALUE;
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    protected void getVisibleVirtualViews(@Nullable List<Integer> virtualViewIds) {
        if (virtualViewIds == null) {
            return;
        }
        int size = this.ocrImageBeanList.size();
        for (int i3 = 0; i3 < size; i3++) {
            virtualViewIds.add(Integer.valueOf(i3));
        }
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    protected boolean onPerformActionForVirtualView(int virtualViewId, int action, @Nullable Bundle arguments) {
        if (action == 16) {
            this.selectedId = virtualViewId;
            return false;
        }
        return false;
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    protected void onPopulateNodeForVirtualView(int virtualViewId, @NotNull AccessibilityNodeInfoCompat node) {
        String desc;
        Intrinsics.checkNotNullParameter(node, "node");
        if (virtualViewId >= 0 && virtualViewId < this.ocrImageBeanList.size()) {
            OCRImageBean oCRImageBean = this.ocrImageBeanList.get(virtualViewId);
            if (oCRImageBean.getIsSelected()) {
                desc = "\u5df2\u9009\u4e2d\uff0c" + oCRImageBean.getDesc();
            } else {
                desc = oCRImageBean.getDesc();
            }
            node.setContentDescription(desc);
            node.setClassName(null);
            node.addAction(16);
            node.setBoundsInParent(oCRImageBean.getPosition());
        }
    }
}
