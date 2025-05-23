package km0;

import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u0000 \u00112\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0006\u001a\u00020\u0005R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lkm0/f;", "Lcom/tencent/freesia/IConfigData;", "", "content", "b", "", "a", "d", "Ljava/lang/String;", "getCONTENT_KEY", "()Ljava/lang/String;", "CONTENT_KEY", "e", "Z", "canOpenNsr", "<init>", "()V", "f", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class f implements IConfigData {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final String f412668h = "NsrConfigData";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String CONTENT_KEY = "openNsr";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean canOpenNsr;

    /* renamed from: a, reason: from getter */
    public final boolean getCanOpenNsr() {
        return this.canOpenNsr;
    }

    @NotNull
    public final f b(@Nullable String content) {
        boolean z16;
        boolean z17;
        if (content != null && content.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e(f412668h, 1, "data is null");
            return new f();
        }
        QLog.e(f412668h, 1, "data is " + content);
        try {
            if (new JSONObject(content).optInt("openNsr", 0) == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            this.canOpenNsr = z17;
        } catch (JSONException e16) {
            QLog.e(f412668h, 1, e16, new Object[0]);
        }
        return this;
    }
}
