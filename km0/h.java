package km0;

import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u0000 \u00152\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0005R\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\rR\u0016\u0010\u0010\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\r\u00a8\u0006\u0016"}, d2 = {"Lkm0/h;", "Lcom/tencent/freesia/IConfigData;", "", "content", "e", "", "c", "b", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "CONTENT_KEY", "Z", "canRefreshData", "f", "canCheckInstall", tl.h.F, "canShowInstall", "<init>", "()V", "i", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class h implements IConfigData {

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private static final String f412678m = "ScheduleAdConfigData";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String CONTENT_KEY = "scheduleAdConfig";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean canRefreshData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean canCheckInstall;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean canShowInstall;

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getCONTENT_KEY() {
        return this.CONTENT_KEY;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getCanCheckInstall() {
        return this.canCheckInstall;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getCanRefreshData() {
        return this.canRefreshData;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getCanShowInstall() {
        return this.canShowInstall;
    }

    @NotNull
    public final h e(@Nullable String content) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        h hVar = new h();
        if (content != null && content.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e(f412678m, 1, "data is null");
            return hVar;
        }
        QLog.e(f412678m, 1, "data is " + content);
        try {
            JSONObject jSONObject = new JSONObject(content);
            if (jSONObject.optInt("scheduleSwitch", 0) == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            this.canRefreshData = z17;
            if (jSONObject.optInt("installCheck", 0) == 1) {
                z18 = true;
            } else {
                z18 = false;
            }
            this.canCheckInstall = z18;
            if (jSONObject.optInt("showInstall", 0) == 1) {
                z19 = true;
            } else {
                z19 = false;
            }
            this.canShowInstall = z19;
        } catch (JSONException e16) {
            QLog.e(f412678m, 1, e16, new Object[0]);
        }
        return hVar;
    }
}
