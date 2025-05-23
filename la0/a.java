package la0;

import android.app.Activity;
import android.view.View;
import cooperation.qqcircle.report.QCircleReportBean;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0006H&J\n\u0010\n\u001a\u0004\u0018\u00010\tH&J\b\u0010\f\u001a\u00020\u000bH&J\b\u0010\u000e\u001a\u00020\rH&\u00a8\u0006\u000f"}, d2 = {"Lla0/a;", "", "Landroid/view/View;", "v", "", "w8", "", "getPageId", "G", "Landroid/app/Activity;", "getActivity", "Lcooperation/qqcircle/report/QCircleReportBean;", "getReportBean", "", "L8", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public interface a {
    int G();

    @NotNull
    String L8();

    @Nullable
    Activity getActivity();

    int getPageId();

    @NotNull
    QCircleReportBean getReportBean();

    boolean w8(@Nullable View v3);
}
