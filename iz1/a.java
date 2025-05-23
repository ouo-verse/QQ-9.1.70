package iz1;

import android.text.TextUtils;
import com.tencent.freesia.IConfigData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 \u00152\u00020\u0001:\u0001\u000eB\u0017\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\u0005\u0010\tR\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Liz1/a;", "Lcom/tencent/freesia/IConfigData;", "", "toString", "", "d", "Z", "b", "()Z", "(Z)V", NodeProps.ENABLED, "", "e", "I", "a", "()I", "c", "(I)V", "defaultSortType", "<init>", "(ZI)V", "f", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a implements IConfigData {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean enabled;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private int defaultSortType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Liz1/a$a;", "", "", "conf", "Liz1/a;", "a", "CONFIG_ID", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: iz1.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final a a(@NotNull String conf) {
            Intrinsics.checkNotNullParameter(conf, "conf");
            a aVar = new a(false, 0);
            if (TextUtils.isEmpty(conf)) {
                QLog.d("FeedSquareConfBean", 1, "parse null, return default bean");
                return aVar;
            }
            try {
                JSONObject jSONObject = new JSONObject(conf);
                aVar.d(jSONObject.optBoolean(NodeProps.ENABLED, false));
                aVar.c(jSONObject.optInt("defaultSortType", 0));
                if (QLog.isColorLevel()) {
                    QLog.i("FeedSquareConfBean", 2, "parse FeedSquareConfBean =  " + jSONObject);
                }
            } catch (Exception e16) {
                QLog.e("FeedSquareConfBean", 1, "parse FeedSquareConfBean:" + conf + " exception: " + e16);
            }
            return aVar;
        }

        Companion() {
        }
    }

    public a(boolean z16, int i3) {
        this.enabled = z16;
        this.defaultSortType = i3;
    }

    /* renamed from: a, reason: from getter */
    public final int getDefaultSortType() {
        return this.defaultSortType;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    public final void c(int i3) {
        this.defaultSortType = i3;
    }

    public final void d(boolean z16) {
        this.enabled = z16;
    }

    @NotNull
    public String toString() {
        return "FeedSquareConfBean{enabled=" + this.enabled + ", defaultSortType=" + this.defaultSortType + "}";
    }
}
