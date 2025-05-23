package f92;

import com.tencent.freesia.IConfigData;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u000e2\u00020\u0001:\u0002\u0007\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rR.\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lf92/a;", "Lcom/tencent/freesia/IConfigData;", "", "", "Lf92/a$b;", "d", "Ljava/util/Map;", "a", "()Ljava/util/Map;", "setWhiteList", "(Ljava/util/Map;)V", "whiteList", "<init>", "()V", "e", "b", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a implements IConfigData {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Map<String, KuiklyConfig> whiteList = new LinkedHashMap();

    public final Map<String, KuiklyConfig> a() {
        return this.whiteList;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lf92/a$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "openInfo", "configId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: f92.a$b, reason: from toString */
    /* loaded from: classes38.dex */
    public static final /* data */ class KuiklyConfig {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final String openInfo;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final String configId;

        public KuiklyConfig(String openInfo, String configId) {
            Intrinsics.checkNotNullParameter(openInfo, "openInfo");
            Intrinsics.checkNotNullParameter(configId, "configId");
            this.openInfo = openInfo;
            this.configId = configId;
        }

        /* renamed from: a, reason: from getter */
        public final String getConfigId() {
            return this.configId;
        }

        /* renamed from: b, reason: from getter */
        public final String getOpenInfo() {
            return this.openInfo;
        }

        public int hashCode() {
            return (this.openInfo.hashCode() * 31) + this.configId.hashCode();
        }

        public String toString() {
            return "KuiklyConfig(openInfo=" + this.openInfo + ", configId=" + this.configId + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof KuiklyConfig)) {
                return false;
            }
            KuiklyConfig kuiklyConfig = (KuiklyConfig) other;
            return Intrinsics.areEqual(this.openInfo, kuiklyConfig.openInfo) && Intrinsics.areEqual(this.configId, kuiklyConfig.configId);
        }
    }
}
