package hv2;

import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes19.dex */
public interface a {
    void a(@Nullable Object obj, @Nullable String str, @Nullable Object obj2);

    void b(String str, Map<String, ?> map);

    Map<String, Object> c(View view);

    void d(Object obj, @QAdVrReport.ReportPolicy int i3);

    void e(@Nullable Object obj, @Nullable String str, @Nullable Map<String, ?> map);

    Map<String, Object> f();

    void setLogicParent(View view, View view2);

    void setPageParams(Object obj, @Nullable Map<String, ?> map);
}
