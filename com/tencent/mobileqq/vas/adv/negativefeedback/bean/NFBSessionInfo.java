package com.tencent.mobileqq.vas.adv.negativefeedback.bean;

import androidx.fragment.app.a;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import java.util.Map;
import java.util.UUID;
import jz2.NFBBusinessInfo;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0015\u0012\b\b\u0002\u0010 \u001a\u00020\u0015\u0012\b\b\u0002\u0010#\u001a\u00020\u0015\u00a2\u0006\u0004\b(\u0010)J\u0014\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\t\u0010\u0005\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0014\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010 \u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR\"\u0010#\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u0017\u001a\u0004\b!\u0010\u0019\"\u0004\b\"\u0010\u001bR'\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010$\u001a\u0004\b\u001d\u0010%R\u0011\u0010'\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0013\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/negativefeedback/bean/NFBSessionInfo;", "", "", "", "b", "toString", "", "hashCode", "other", "", "equals", "Ljz2/a;", "a", "Ljz2/a;", "getBusiInfo", "()Ljz2/a;", "busiInfo", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "sessionId", "", "c", "J", "g", "()J", "j", "(J)V", "startTime", "d", h.F, "k", "stopTime", "e", "i", "heartBeatTime", "Lkotlin/Lazy;", "()Ljava/util/Map;", "businessParams", "busiId", "<init>", "(Ljz2/a;Ljava/lang/String;JJJ)V", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final /* data */ class NFBSessionInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final NFBBusinessInfo busiInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String sessionId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private long startTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private long stopTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private long heartBeatTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy businessParams;

    public NFBSessionInfo(@NotNull NFBBusinessInfo busiInfo, @NotNull String sessionId, long j3, long j16, long j17) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(busiInfo, "busiInfo");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        this.busiInfo = busiInfo;
        this.sessionId = sessionId;
        this.startTime = j3;
        this.stopTime = j16;
        this.heartBeatTime = j17;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Map<String, ? extends String>>() { // from class: com.tencent.mobileqq.vas.adv.negativefeedback.bean.NFBSessionInfo$businessParams$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Map<String, ? extends String> invoke() {
                Map<String, ? extends String> b16;
                b16 = NFBSessionInfo.this.b();
                return b16;
            }
        });
        this.businessParams = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, String> b() {
        Map<String, String> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("adpos_id", this.busiInfo.getAdPosId()), TuplesKt.to("ad_id", this.busiInfo.getAdId()), TuplesKt.to("item_id", this.busiInfo.getItemId()), TuplesKt.to("act_id", this.busiInfo.getActId()), TuplesKt.to("bundle_name", this.busiInfo.getBundleName()), TuplesKt.to("page_name", this.busiInfo.getPageName()), TuplesKt.to("domain", this.busiInfo.getDomain()), TuplesKt.to("web_version", this.busiInfo.getWebVersion()), TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.PG_ID, this.busiInfo.getPgId()), TuplesKt.to("module_id", this.busiInfo.getModuleId()), TuplesKt.to("from_src", this.busiInfo.getFromSrc()));
        return mapOf;
    }

    @NotNull
    public final String c() {
        return this.busiInfo.getBusiId();
    }

    @NotNull
    public final Map<String, String> d() {
        return (Map) this.businessParams.getValue();
    }

    /* renamed from: e, reason: from getter */
    public final long getHeartBeatTime() {
        return this.heartBeatTime;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NFBSessionInfo)) {
            return false;
        }
        NFBSessionInfo nFBSessionInfo = (NFBSessionInfo) other;
        if (Intrinsics.areEqual(this.busiInfo, nFBSessionInfo.busiInfo) && Intrinsics.areEqual(this.sessionId, nFBSessionInfo.sessionId) && this.startTime == nFBSessionInfo.startTime && this.stopTime == nFBSessionInfo.stopTime && this.heartBeatTime == nFBSessionInfo.heartBeatTime) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: g, reason: from getter */
    public final long getStartTime() {
        return this.startTime;
    }

    /* renamed from: h, reason: from getter */
    public final long getStopTime() {
        return this.stopTime;
    }

    public int hashCode() {
        return (((((((this.busiInfo.hashCode() * 31) + this.sessionId.hashCode()) * 31) + a.a(this.startTime)) * 31) + a.a(this.stopTime)) * 31) + a.a(this.heartBeatTime);
    }

    public final void i(long j3) {
        this.heartBeatTime = j3;
    }

    public final void j(long j3) {
        this.startTime = j3;
    }

    public final void k(long j3) {
        this.stopTime = j3;
    }

    @NotNull
    public String toString() {
        return "NFBSessionInfo(busiInfo=" + this.busiInfo + ", sessionId=" + this.sessionId + ", startTime=" + this.startTime + ", stopTime=" + this.stopTime + ", heartBeatTime=" + this.heartBeatTime + ')';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ NFBSessionInfo(NFBBusinessInfo nFBBusinessInfo, String str, long j3, long j16, long j17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(nFBBusinessInfo, r0, (i3 & 4) != 0 ? 0L : j3, (i3 & 8) != 0 ? 0L : j16, (i3 & 16) == 0 ? j17 : 0L);
        String str2;
        if ((i3 & 2) != 0) {
            str2 = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(str2, "randomUUID().toString()");
        } else {
            str2 = str;
        }
    }
}
