package bi1;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.common.IReporter;
import com.tencent.qqlive.module.videoreport.common.ReportEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lbi1/b;", "Lcom/tencent/qqlive/module/videoreport/common/IReporter;", "Lcom/tencent/qqlive/module/videoreport/common/ReportEvent;", "event", "", "report", "<init>", "()V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b implements IReporter {
    @Override // com.tencent.qqlive.module.videoreport.common.IReporter
    public void report(@Nullable ReportEvent event) {
        boolean z16;
        boolean z17;
        if (event == null) {
            return;
        }
        Map<String, String> params = event.getParams();
        boolean z18 = false;
        if (params != null && !params.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            String key = event.getKey();
            if (key != null && key.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17) {
                try {
                    String str = event.getParams().get("udf_kv");
                    String eventKey = event.getKey();
                    if (str == null || str.length() == 0) {
                        z18 = true;
                    }
                    if (z18) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(str);
                    a aVar = a.f28439a;
                    Intrinsics.checkNotNullExpressionValue(eventKey, "eventKey");
                    aVar.b(jSONObject, eventKey);
                } catch (Exception e16) {
                    QLog.e("TianShuAdReporter", 1, "TianShuAdReporter error " + e16);
                }
            }
        }
    }
}
