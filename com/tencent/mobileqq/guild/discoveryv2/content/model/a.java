package com.tencent.mobileqq.guild.discoveryv2.content.model;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetCategoryTabContentRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProTabContentCommonRsp;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0015\u001a\u0004\b\n\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/model/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lri1/a;", "a", "Lri1/a;", "c", "()Lri1/a;", "result", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGetCategoryTabContentRsp;", "b", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGetCategoryTabContentRsp;", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGetCategoryTabContentRsp;", "raw", "", "[B", "()[B", "buffer", "<init>", "(Lri1/a;Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGetCategoryTabContentRsp;[B)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final /* data */ class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ri1.a result;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final IGProGetCategoryTabContentRsp raw;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final byte[] buffer;

    public a(@NotNull ri1.a result, @Nullable IGProGetCategoryTabContentRsp iGProGetCategoryTabContentRsp, @NotNull byte[] buffer) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        this.result = result;
        this.raw = iGProGetCategoryTabContentRsp;
        this.buffer = buffer;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final byte[] getBuffer() {
        return this.buffer;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final IGProGetCategoryTabContentRsp getRaw() {
        return this.raw;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final ri1.a getResult() {
        return this.result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (Intrinsics.areEqual(this.result, aVar.result) && Intrinsics.areEqual(this.raw, aVar.raw) && Intrinsics.areEqual(this.buffer, aVar.buffer)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = this.result.hashCode() * 31;
        IGProGetCategoryTabContentRsp iGProGetCategoryTabContentRsp = this.raw;
        if (iGProGetCategoryTabContentRsp == null) {
            hashCode = 0;
        } else {
            hashCode = iGProGetCategoryTabContentRsp.hashCode();
        }
        return ((hashCode2 + hashCode) * 31) + Arrays.hashCode(this.buffer);
    }

    @NotNull
    public String toString() {
        String str;
        IGProTabContentCommonRsp commonRsp;
        ri1.a aVar = this.result;
        IGProGetCategoryTabContentRsp iGProGetCategoryTabContentRsp = this.raw;
        if (iGProGetCategoryTabContentRsp != null && (commonRsp = iGProGetCategoryTabContentRsp.getCommonRsp()) != null) {
            str = com.tencent.mobileqq.guild.discoveryv2.net.g.a(commonRsp);
        } else {
            str = null;
        }
        return "GWGProGetCategoryTabContentRsp(result=" + aVar + " " + str + " buffer.size=" + this.buffer.length + ")";
    }

    public /* synthetic */ a(ri1.a aVar, IGProGetCategoryTabContentRsp iGProGetCategoryTabContentRsp, byte[] bArr, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar, (i3 & 2) != 0 ? null : iGProGetCategoryTabContentRsp, (i3 & 4) != 0 ? new byte[0] : bArr);
    }
}
