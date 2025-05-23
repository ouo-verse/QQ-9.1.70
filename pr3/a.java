package pr3;

import android.text.TextUtils;
import com.tencent.qmethod.monitor.base.util.f;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 \t2\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lpr3/a;", "", "", "appUniqueID", "", "c", "a", "Ljava/lang/String;", "lastAppUniqueID", "b", "()Ljava/lang/String;", "lastAppUniqueIDFromSp", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String lastAppUniqueID;

    private final String b() {
        String d16 = f.d("last_save_app_unique_id");
        if (TextUtils.isEmpty(d16)) {
            d16 = UUID.randomUUID().toString();
            f.g("last_save_app_unique_id", d16);
        }
        if (d16 == null) {
            Intrinsics.throwNpe();
        }
        return d16;
    }

    @NotNull
    public final String a() {
        if (TextUtils.isEmpty(this.lastAppUniqueID)) {
            this.lastAppUniqueID = b();
        }
        String str = this.lastAppUniqueID;
        if (str == null) {
            Intrinsics.throwNpe();
        }
        return str;
    }

    public final void c(@NotNull String appUniqueID) {
        Intrinsics.checkParameterIsNotNull(appUniqueID, "appUniqueID");
        if (!TextUtils.isEmpty(appUniqueID) && !TextUtils.equals(this.lastAppUniqueID, appUniqueID)) {
            this.lastAppUniqueID = appUniqueID;
            if (appUniqueID == null) {
                Intrinsics.throwNpe();
            }
            f.g("last_save_app_unique_id", appUniqueID);
        }
    }
}
