package j01;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b \u0018\u0000 \u00052\u00020\u0001:\u0001\u000bB\u0015\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\n\u00a2\u0006\u0004\b(\u0010)J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\t\u001a\u00020\bH\u0016R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0011\u0010\u0010\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0012\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0014\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0016\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\u0018\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\u0019\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\u000fR\u0011\u0010\u001b\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u000fR\u0011\u0010\u001d\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u000fR\u0011\u0010\u001f\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u000fR\u0011\u0010!\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b \u0010\u000fR\u0011\u0010#\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\"\u0010\u000fR\u0011\u0010%\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b$\u0010\u000fR\u0011\u0010'\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b&\u0010\u000f\u00a8\u0006*"}, d2 = {"Lj01/a;", "", "", "event", "", "b", "Lorg/json/JSONObject;", "o", "", "toString", "", "a", "[Ljava/lang/Long;", "eventTimestamps", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()J", "preloadDexClassCost", h.F, "initRenderViewCost", "e", "initRenderCoreCost", "f", "initRenderLayerReadCacheCost", "g", "initRenderLayerRenderCacheCost", "createInstanceCost", "d", "initRenderContextCost", "i", "newPageCost", "j", "pageBuildCost", "l", "pageLayoutCost", "k", "pageCreateCost", DomainData.DOMAIN_NAME, "renderCost", "c", "firstFramePaintCost", "<init>", "([Ljava/lang/Long;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Long[] eventTimestamps;

    public a(@NotNull Long[] eventTimestamps) {
        Intrinsics.checkNotNullParameter(eventTimestamps, "eventTimestamps");
        this.eventTimestamps = eventTimestamps;
    }

    public final long a() {
        Long[] lArr = this.eventTimestamps;
        if (lArr.length < 21) {
            return 0L;
        }
        return lArr[18].longValue() - this.eventTimestamps[10].longValue();
    }

    public final long b(int event) {
        Long[] lArr = this.eventTimestamps;
        if (event >= lArr.length) {
            return 0L;
        }
        return lArr[event].longValue();
    }

    public final long c() {
        Long[] lArr = this.eventTimestamps;
        if (lArr.length < 21) {
            return 0L;
        }
        return lArr[19].longValue() - this.eventTimestamps[0].longValue();
    }

    public final long d() {
        Long[] lArr = this.eventTimestamps;
        if (lArr.length < 21) {
            return 0L;
        }
        return lArr[5].longValue() - this.eventTimestamps[4].longValue();
    }

    public final long e() {
        Long[] lArr = this.eventTimestamps;
        if (lArr.length < 21) {
            return 0L;
        }
        return lArr[3].longValue() - this.eventTimestamps[2].longValue();
    }

    public final long f() {
        Long[] lArr = this.eventTimestamps;
        if (lArr.length < 21) {
            return 0L;
        }
        return lArr[7].longValue() - this.eventTimestamps[6].longValue();
    }

    public final long g() {
        Long[] lArr = this.eventTimestamps;
        if (lArr.length < 21) {
            return 0L;
        }
        return lArr[9].longValue() - this.eventTimestamps[8].longValue();
    }

    public final long h() {
        Long[] lArr = this.eventTimestamps;
        if (lArr.length < 21) {
            return 0L;
        }
        return lArr[2].longValue() - this.eventTimestamps[0].longValue();
    }

    public final long i() {
        Long[] lArr = this.eventTimestamps;
        if (lArr.length < 21) {
            return 0L;
        }
        return lArr[12].longValue() - this.eventTimestamps[11].longValue();
    }

    public final long j() {
        Long[] lArr = this.eventTimestamps;
        if (lArr.length < 21) {
            return 0L;
        }
        return lArr[14].longValue() - this.eventTimestamps[13].longValue();
    }

    public final long k() {
        Long[] lArr = this.eventTimestamps;
        if (lArr.length < 21) {
            return 0L;
        }
        return lArr[17].longValue() - this.eventTimestamps[13].longValue();
    }

    public final long l() {
        Long[] lArr = this.eventTimestamps;
        if (lArr.length < 21) {
            return 0L;
        }
        return lArr[16].longValue() - this.eventTimestamps[15].longValue();
    }

    public final long m() {
        Long[] lArr = this.eventTimestamps;
        if (lArr.length < 21) {
            return 0L;
        }
        return lArr[1].longValue() - this.eventTimestamps[0].longValue();
    }

    public final long n() {
        long longValue;
        long longValue2;
        Long[] lArr = this.eventTimestamps;
        if (lArr.length < 21) {
            return 0L;
        }
        if (lArr[19].longValue() >= this.eventTimestamps[17].longValue()) {
            longValue = this.eventTimestamps[19].longValue();
            longValue2 = this.eventTimestamps[17].longValue();
        } else {
            longValue = this.eventTimestamps[19].longValue();
            longValue2 = this.eventTimestamps[8].longValue();
        }
        return longValue - longValue2;
    }

    @NotNull
    public final JSONObject o() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("firstPaintCost", c());
        jSONObject.put("initViewCost", h());
        jSONObject.put("preloadDexClassCost", m());
        jSONObject.put("fetchContextCodeCost", 0);
        jSONObject.put("initRenderContextCost", d());
        jSONObject.put("initRenderCoreCost", e());
        jSONObject.put("initRenderLayerReadCacheCost", f());
        jSONObject.put("initRenderLayerRenderCacheCost", g());
        jSONObject.put("newPageCost", i());
        jSONObject.put("pageBuildCost", j());
        jSONObject.put("pageLayoutCost", l());
        jSONObject.put("createPageCost", k());
        jSONObject.put("createInstanceCost", a());
        jSONObject.put("renderCost", n());
        return jSONObject;
    }

    @NotNull
    public String toString() {
        if (this.eventTimestamps[8].longValue() > 0) {
            return "[KRLaunchMeta] \nfirstFramePaintCost: " + c() + " \n   -- initRenderViewCost: " + h() + " \n       -- preloadDexClassCost: " + m() + " \n   -- initRenderCoreCost: " + e() + " \n   -- initRenderContextCost: " + d() + " \n   -- initRenderLayerReadCacheCost: " + f() + " \n   -- renderCost: " + n() + " \n";
        }
        return "[KRLaunchMeta] \nfirstFramePaintCost: " + c() + " \n   -- initRenderViewCost: " + h() + " \n       -- preloadDexClassCost: " + m() + " \n   -- initRenderCoreCost: " + e() + " \n   -- initRenderContextCost: " + d() + " \n   -- initRenderLayerReadCacheCost: " + f() + " \n   -- initRenderLayerRenderCacheCost: " + g() + " \n   -- createInstanceCost: " + a() + " \n       -- newPageCost: " + i() + " \n       -- onPageCreateCost: " + k() + " \n           -- pageBuildCost: " + j() + " \n           -- pageLayoutCost: " + l() + " \n   -- renderCost: " + n() + " \n";
    }
}
