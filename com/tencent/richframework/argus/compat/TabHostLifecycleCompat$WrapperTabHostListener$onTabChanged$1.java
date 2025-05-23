package com.tencent.richframework.argus.compat;

import android.util.Log;
import android.view.View;
import androidx.fragment.app.Argus;
import com.tencent.map.geolocation.TencentLocation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE}, k = 3, mv = {1, 4, 1})
/* loaded from: classes25.dex */
final class TabHostLifecycleCompat$WrapperTabHostListener$onTabChanged$1 implements Runnable {
    final /* synthetic */ View $currentTabContent;
    final /* synthetic */ View $currentTabView;
    final /* synthetic */ TabHostLifecycleCompat$WrapperTabHostListener this$0;

    @Override // java.lang.Runnable
    public final void run() {
        View currentTabContent = this.$currentTabContent;
        Intrinsics.checkNotNullExpressionValue(currentTabContent, "currentTabContent");
        if (currentTabContent.isShown()) {
            Log.i(Argus.TAG, "currentTabContent:" + this.$currentTabContent + " tabView:" + this.$currentTabView);
            Argus argus = Argus.INSTANCE;
            View currentTabContent2 = this.$currentTabContent;
            Intrinsics.checkNotNullExpressionValue(currentTabContent2, "currentTabContent");
            argus.getNode(currentTabContent2, TabHostLifecycleCompat$WrapperTabHostListener.access$getMTabHost$p(null), true);
            View currentTabContent3 = this.$currentTabContent;
            Intrinsics.checkNotNullExpressionValue(currentTabContent3, "currentTabContent");
            argus.updatePage(currentTabContent3);
        }
    }
}
