package com.tencent.mobileqq.guild.base.extension;

import android.view.View;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001aQ\u0010\u000b\u001a\u00020\n\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00028\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"Landroid/view/View;", "T", "", "id", "", "expose", "click", "", "", "params", "", "a", "(Landroid/view/View;Ljava/lang/String;ZZLjava/util/Map;)V", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class g {
    public static final <T extends View> void a(@NotNull T t16, @NotNull String id5, boolean z16, boolean z17, @Nullable Map<String, ? extends Object> map) {
        ExposurePolicy exposurePolicy;
        ClickPolicy clickPolicy;
        Intrinsics.checkNotNullParameter(t16, "<this>");
        Intrinsics.checkNotNullParameter(id5, "id");
        VideoReport.setElementId(t16, id5);
        if (map != null) {
            VideoReport.setElementParams(t16, map);
        }
        if (z16) {
            exposurePolicy = ExposurePolicy.REPORT_ALL;
        } else {
            exposurePolicy = ExposurePolicy.REPORT_NONE;
        }
        VideoReport.setElementExposePolicy(t16, exposurePolicy);
        if (z17) {
            clickPolicy = ClickPolicy.REPORT_ALL;
        } else {
            clickPolicy = ClickPolicy.REPORT_NONE;
        }
        VideoReport.setElementClickPolicy(t16, clickPolicy);
    }

    public static /* synthetic */ void b(View view, String str, boolean z16, boolean z17, Map map, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        if ((i3 & 4) != 0) {
            z17 = true;
        }
        if ((i3 & 8) != 0) {
            map = null;
        }
        a(view, str, z16, z17, map);
    }
}
