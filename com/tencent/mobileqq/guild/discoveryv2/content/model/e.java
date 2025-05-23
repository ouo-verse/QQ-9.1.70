package com.tencent.mobileqq.guild.discoveryv2.content.model;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRecommendTabContentRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProTabContentCommonRsp;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0019\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/model/e;", "", "", "toString", "Lri1/a;", "a", "", "b", "", "hashCode", "other", "", "equals", "Lri1/a;", "e", "()Lri1/a;", "result", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGetRecommendTabContentRsp;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGetRecommendTabContentRsp;", "d", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGetRecommendTabContentRsp;", "raw", "c", "[B", "()[B", "buffer", "<init>", "(Lri1/a;Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGetRecommendTabContentRsp;[B)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final /* data */ class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ri1.a result;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final IGProGetRecommendTabContentRsp raw;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final byte[] buffer;

    public e(@NotNull ri1.a result, @Nullable IGProGetRecommendTabContentRsp iGProGetRecommendTabContentRsp, @NotNull byte[] buffer) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        this.result = result;
        this.raw = iGProGetRecommendTabContentRsp;
        this.buffer = buffer;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final ri1.a getResult() {
        return this.result;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final byte[] getBuffer() {
        return this.buffer;
    }

    @NotNull
    public final byte[] c() {
        return this.buffer;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final IGProGetRecommendTabContentRsp getRaw() {
        return this.raw;
    }

    @NotNull
    public final ri1.a e() {
        return this.result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof e)) {
            return false;
        }
        e eVar = (e) other;
        if (Intrinsics.areEqual(this.result, eVar.result) && Intrinsics.areEqual(this.raw, eVar.raw) && Intrinsics.areEqual(this.buffer, eVar.buffer)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = this.result.hashCode() * 31;
        IGProGetRecommendTabContentRsp iGProGetRecommendTabContentRsp = this.raw;
        if (iGProGetRecommendTabContentRsp == null) {
            hashCode = 0;
        } else {
            hashCode = iGProGetRecommendTabContentRsp.hashCode();
        }
        return ((hashCode2 + hashCode) * 31) + Arrays.hashCode(this.buffer);
    }

    @NotNull
    public String toString() {
        String str;
        IGProTabContentCommonRsp commonRsp;
        ri1.a aVar = this.result;
        IGProGetRecommendTabContentRsp iGProGetRecommendTabContentRsp = this.raw;
        if (iGProGetRecommendTabContentRsp != null && (commonRsp = iGProGetRecommendTabContentRsp.getCommonRsp()) != null) {
            str = com.tencent.mobileqq.guild.discoveryv2.net.g.a(commonRsp);
        } else {
            str = null;
        }
        return "GWGProGetRecommendTabContentRsp(result=" + aVar + " " + str + " buffer.size=" + this.buffer.length + ")";
    }

    public /* synthetic */ e(ri1.a aVar, IGProGetRecommendTabContentRsp iGProGetRecommendTabContentRsp, byte[] bArr, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar, (i3 & 2) != 0 ? null : iGProGetRecommendTabContentRsp, (i3 & 4) != 0 ? new byte[0] : bArr);
    }
}
