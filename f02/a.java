package f02;

import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\f"}, d2 = {"Lf02/a;", "", "Landroid/view/View;", "clickView", "", "elementKey", "", "open", "", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f397498a = new a();

    a() {
    }

    public final void a(@NotNull View clickView, @NotNull String elementKey, boolean open) {
        Intrinsics.checkNotNullParameter(clickView, "clickView");
        Intrinsics.checkNotNullParameter(elementKey, "elementKey");
        HashMap hashMap = new HashMap();
        int i3 = 1;
        QLog.i("DtReportUtils", 1, "reportDtClick elementKey=" + elementKey + " open=" + open);
        if (!open) {
            i3 = 2;
        }
        hashMap.put("sgrp_switch_condition", Integer.valueOf(i3));
        VideoReport.setElementClickPolicy(clickView, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(clickView, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementId(clickView, elementKey);
        VideoReport.reportEvent("dt_clck", clickView, hashMap);
    }
}
