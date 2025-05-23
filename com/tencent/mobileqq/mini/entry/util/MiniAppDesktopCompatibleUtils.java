package com.tencent.mobileqq.mini.entry.util;

import android.view.View;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/util/MiniAppDesktopCompatibleUtils;", "", "()V", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public class MiniAppDesktopCompatibleUtils {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "MiniAppDesktopCompatibleUtils";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/util/MiniAppDesktopCompatibleUtils$Companion;", "", "()V", "TAG", "", "compatibleDeviceDraggingState", "", "draggingProhibitClickView", "Landroid/view/View;", "isDragging", "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        public final void compatibleDeviceDraggingState(View draggingProhibitClickView, boolean isDragging) {
            if (draggingProhibitClickView == null) {
                QLog.i(MiniAppDesktopCompatibleUtils.TAG, 1, "compatibleSamSungA52DeviceDraggingState error!");
                return;
            }
            if (isDragging) {
                draggingProhibitClickView.setVisibility(0);
            } else {
                draggingProhibitClickView.setVisibility(8);
            }
            QLog.i(MiniAppDesktopCompatibleUtils.TAG, 1, "compatibleDeviceDraggingState isDragging:" + isDragging);
        }
    }
}
