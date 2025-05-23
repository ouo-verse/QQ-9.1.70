package iz2;

import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005R\u0016\u0010\n\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\t\u00a8\u0006\u0010"}, d2 = {"Liz2/a;", "Lcom/tencent/freesia/IConfigData;", "", "content", "c", "", "b", "a", "d", "I", "weatherMaskAdDayLimit", "e", "sportsMaskAdDayLimit", "<init>", "()V", "f", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a implements IConfigData {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int weatherMaskAdDayLimit = 1;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int sportsMaskAdDayLimit = 1;

    /* renamed from: a, reason: from getter */
    public final int getSportsMaskAdDayLimit() {
        return this.sportsMaskAdDayLimit;
    }

    /* renamed from: b, reason: from getter */
    public final int getWeatherMaskAdDayLimit() {
        return this.weatherMaskAdDayLimit;
    }

    @NotNull
    public final a c(@Nullable String content) {
        boolean z16;
        if (content != null && content.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("MaskAdReqFreqConfigData", 1, "data is null");
            return new a();
        }
        try {
            JSONObject jSONObject = new JSONObject(content);
            this.weatherMaskAdDayLimit = jSONObject.optInt("weatherMaskAdDayLimit", 1);
            this.sportsMaskAdDayLimit = jSONObject.optInt("sportsMaskAdDayLimit", 1);
        } catch (JSONException e16) {
            QLog.e("MaskAdReqFreqConfigData", 1, "json parse error:", e16);
        }
        return this;
    }
}
