package g43;

import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \n2\u00020\u0001:\u0001\u0005B\u0011\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lg43/b;", "Lcom/tencent/freesia/IConfigData;", "", "d", "Z", "a", "()Z", "fellowStepReport", "<init>", "(Z)V", "e", "health-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class b implements IConfigData {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean fellowStepReport;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lg43/b$a;", "", "", "content", "Lg43/b;", "a", "FELLOW_REPORT_KEY", "Ljava/lang/String;", "TAG", "<init>", "()V", "health-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: g43.b$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final b a(@NotNull String content) {
            boolean z16;
            Intrinsics.checkNotNullParameter(content, "content");
            if (QLog.isColorLevel()) {
                QLog.d("HealthCommonConfigData", 2, "parse from:" + content + " ");
            }
            boolean z17 = false;
            int i3 = 1;
            try {
                if (new JSONObject(content).optInt("fellowReport", 0) == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                return new b(z16);
            } catch (JSONException e16) {
                QLog.e("HealthCommonConfigData", 1, "error parse HealthCommonConfigData content:" + content, e16);
                return new b(z17, i3, null);
            }
        }

        Companion() {
        }
    }

    public b() {
        this(false, 1, null);
    }

    /* renamed from: a, reason: from getter */
    public final boolean getFellowStepReport() {
        return this.fellowStepReport;
    }

    public b(boolean z16) {
        this.fellowStepReport = z16;
    }

    public /* synthetic */ b(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16);
    }
}
