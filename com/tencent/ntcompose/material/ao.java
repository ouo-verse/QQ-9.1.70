package com.tencent.ntcompose.material;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002R\u0017\u0010\t\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\bR\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ntcompose/material/ao;", "", "other", "", "equals", "Lcom/tencent/kuikly/core/base/h;", "a", "Lcom/tencent/kuikly/core/base/h;", "()Lcom/tencent/kuikly/core/base/h;", "color", "", "b", UserInfo.SEX_FEMALE, "()F", "width", "<init>", "(Lcom/tencent/kuikly/core/base/h;F)V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ao {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.kuikly.core.base.h color;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final float width;

    public ao(com.tencent.kuikly.core.base.h color, float f16) {
        Intrinsics.checkNotNullParameter(color, "color");
        this.color = color;
        this.width = f16;
    }

    /* renamed from: a, reason: from getter */
    public final com.tencent.kuikly.core.base.h getColor() {
        return this.color;
    }

    /* renamed from: b, reason: from getter */
    public final float getWidth() {
        return this.width;
    }

    public boolean equals(Object other) {
        if (!(other instanceof ao)) {
            return false;
        }
        ao aoVar = (ao) other;
        if (Intrinsics.areEqual(this.color, aoVar.color)) {
            return (this.width > aoVar.width ? 1 : (this.width == aoVar.width ? 0 : -1)) == 0;
        }
        return false;
    }
}
