package com.tencent.now.linkscreengame.model;

import hn3.LinkScreenAnchorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import or4.g;
import or4.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0016\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/now/linkscreengame/model/a;", "", "", "anchorId", "Lor4/g;", "rsp", "Lhn3/a;", "a", "", "modeType", "bizID", "", "b", "<init>", "()V", "qq-live-linkscreen-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f338500a = new a();

    a() {
    }

    @Nullable
    public final LinkScreenAnchorInfo a(long anchorId, @Nullable g rsp) {
        k[] kVarArr;
        if (rsp != null && (kVarArr = rsp.f423489d) != null) {
            for (k kVar : kVarArr) {
                long j3 = kVar.f423504a;
                if (j3 != anchorId) {
                    long j16 = kVar.f423506c;
                    String str = kVar.f423507d;
                    Intrinsics.checkNotNullExpressionValue(str, "linkMicInfo.nickName");
                    String str2 = kVar.f423508e;
                    Intrinsics.checkNotNullExpressionValue(str2, "linkMicInfo.logoUrl");
                    return new LinkScreenAnchorInfo(j16, j3, str, str2, rsp.f423495j);
                }
            }
            return null;
        }
        return null;
    }

    public final boolean b(int modeType, int bizID) {
        if (modeType == 2) {
            if (bizID == 6 || bizID == 8) {
                return true;
            }
            return false;
        }
        return false;
    }
}
