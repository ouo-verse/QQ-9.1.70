package m94;

import com.tencent.mobileqq.zootopia.ZootopiaSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0004\u0012\u0006\u0010\u001e\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000bR\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0018\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0016\u001a\u0004\b\u0011\u0010\u0017R\"\u0010\u001e\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u001a\u001a\u0004\b\r\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lm94/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "brandId", "b", "d", "schemeParams", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "c", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "e", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "I", "()I", "reqSource", "Lb94/a;", "Lb94/a;", "()Lb94/a;", "setEngineApi", "(Lb94/a;)V", "engineApi", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;ILb94/a;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: m94.d, reason: from toString */
/* loaded from: classes38.dex */
public final /* data */ class DressControllerInitData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String brandId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String schemeParams;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final ZootopiaSource source;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int reqSource;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private b94.a engineApi;

    public DressControllerInitData(String brandId, String schemeParams, ZootopiaSource source, int i3, b94.a engineApi) {
        Intrinsics.checkNotNullParameter(brandId, "brandId");
        Intrinsics.checkNotNullParameter(schemeParams, "schemeParams");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(engineApi, "engineApi");
        this.brandId = brandId;
        this.schemeParams = schemeParams;
        this.source = source;
        this.reqSource = i3;
        this.engineApi = engineApi;
    }

    /* renamed from: a, reason: from getter */
    public final String getBrandId() {
        return this.brandId;
    }

    /* renamed from: b, reason: from getter */
    public final b94.a getEngineApi() {
        return this.engineApi;
    }

    /* renamed from: c, reason: from getter */
    public final int getReqSource() {
        return this.reqSource;
    }

    /* renamed from: d, reason: from getter */
    public final String getSchemeParams() {
        return this.schemeParams;
    }

    /* renamed from: e, reason: from getter */
    public final ZootopiaSource getSource() {
        return this.source;
    }

    public int hashCode() {
        return (((((((this.brandId.hashCode() * 31) + this.schemeParams.hashCode()) * 31) + this.source.hashCode()) * 31) + this.reqSource) * 31) + this.engineApi.hashCode();
    }

    public String toString() {
        return "DressControllerInitData(brandId=" + this.brandId + ", schemeParams=" + this.schemeParams + ", source=" + this.source + ", reqSource=" + this.reqSource + ", engineApi=" + this.engineApi + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DressControllerInitData)) {
            return false;
        }
        DressControllerInitData dressControllerInitData = (DressControllerInitData) other;
        return Intrinsics.areEqual(this.brandId, dressControllerInitData.brandId) && Intrinsics.areEqual(this.schemeParams, dressControllerInitData.schemeParams) && Intrinsics.areEqual(this.source, dressControllerInitData.source) && this.reqSource == dressControllerInitData.reqSource && Intrinsics.areEqual(this.engineApi, dressControllerInitData.engineApi);
    }
}
