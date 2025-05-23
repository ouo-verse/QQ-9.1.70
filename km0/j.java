package km0;

import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0011\u0018\u0000 \u00152\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0005R\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\rR\u0016\u0010\u0010\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\r\u00a8\u0006\u0016"}, d2 = {"Lkm0/j;", "Lcom/tencent/freesia/IConfigData;", "", "content", "e", "", "b", "c", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "CONTENT_KEY", "J", "checkJumpAppDelayTimeMs", "f", "checkResultAfterJumpTimeMs", tl.h.F, "unregisterGuardCallbackDelayTimeMs", "<init>", "()V", "i", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class j implements IConfigData {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String CONTENT_KEY = "SplashAdJumpDelayConfigDataContent";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long checkJumpAppDelayTimeMs = 5000;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long checkResultAfterJumpTimeMs = 2500;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long unregisterGuardCallbackDelayTimeMs = 7000;

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getCONTENT_KEY() {
        return this.CONTENT_KEY;
    }

    /* renamed from: b, reason: from getter */
    public final long getCheckJumpAppDelayTimeMs() {
        return this.checkJumpAppDelayTimeMs;
    }

    /* renamed from: c, reason: from getter */
    public final long getCheckResultAfterJumpTimeMs() {
        return this.checkResultAfterJumpTimeMs;
    }

    /* renamed from: d, reason: from getter */
    public final long getUnregisterGuardCallbackDelayTimeMs() {
        return this.unregisterGuardCallbackDelayTimeMs;
    }

    @NotNull
    public final j e(@Nullable String content) {
        boolean z16;
        j jVar = new j();
        if (content != null && content.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("SplashAdJumpDelayConfigData", 1, "data is null");
            return jVar;
        }
        try {
            JSONObject jSONObject = new JSONObject(content);
            this.checkJumpAppDelayTimeMs = jSONObject.optLong("dpToH5CheckJumpAppDelayTimeMs", 5000L);
            this.checkResultAfterJumpTimeMs = jSONObject.optLong("dpToH5CheckResultAfterJumpTimeMs", 2500L);
            this.unregisterGuardCallbackDelayTimeMs = jSONObject.optLong("unRegisterGuardCallbackTimeMs", 7000L);
        } catch (JSONException e16) {
            QLog.e("SplashAdJumpDelayConfigData", 1, e16, new Object[0]);
        }
        return jVar;
    }
}
