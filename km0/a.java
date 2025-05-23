package km0;

import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0007R\u0016\u0010\u000b\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lkm0/a;", "Lcom/tencent/freesia/IConfigData;", "", "content", "c", "", "a", "", "b", "d", "I", "backgroundDuration", "e", "Z", "isNeedSupplementaryReport", "<init>", "()V", "f", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a implements IConfigData {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int backgroundDuration = 30;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isNeedSupplementaryReport = true;

    /* renamed from: a, reason: from getter */
    public final int getBackgroundDuration() {
        return this.backgroundDuration;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsNeedSupplementaryReport() {
        return this.isNeedSupplementaryReport;
    }

    @NotNull
    public final a c(@Nullable String content) {
        boolean z16;
        boolean z17 = false;
        if (content != null && content.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("AdAppInstallConfigData", 1, "data is null");
            return new a();
        }
        try {
            JSONObject jSONObject = new JSONObject(content);
            this.backgroundDuration = jSONObject.optInt("backgroundDuration", 30);
            if (jSONObject.optInt("isNeedSupplementaryReport", 1) == 1) {
                z17 = true;
            }
            this.isNeedSupplementaryReport = z17;
        } catch (JSONException e16) {
            QLog.e("AdAppInstallConfigData", 1, "json parse error:" + e16);
        }
        return this;
    }
}
