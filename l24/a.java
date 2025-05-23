package l24;

import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Ll24/a;", "Lcom/tencent/freesia/IConfigData;", "", "a", "", "b", "", "content", "c", "d", "I", "simpleUpperLimitCount", "<init>", "()V", "e", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a implements IConfigData {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int simpleUpperLimitCount = 1000;

    /* renamed from: a, reason: from getter */
    public final int getSimpleUpperLimitCount() {
        return this.simpleUpperLimitCount;
    }

    public final void b() {
        this.simpleUpperLimitCount = 1000;
    }

    public final void c(@NotNull String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        try {
            this.simpleUpperLimitCount = new JSONObject(content).optInt("simple_upper_limit", 1000);
        } catch (JSONException e16) {
            b();
            QLog.e("RobotMsgReportConfig", 1, "parse error exception = " + e16);
        }
    }
}
