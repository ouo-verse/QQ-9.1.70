package com.tencent.kuikly.core.base;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0096\u0002R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\t\u001a\u0004\b\b\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/kuikly/core/base/w;", "", "", "toString", "other", "", "equals", "", "a", UserInfo.SEX_FEMALE, "b", "()F", "width", "height", "<init>", "(FF)V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final float width;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final float height;

    public w(float f16, float f17) {
        this.width = f16;
        this.height = f17;
    }

    /* renamed from: a, reason: from getter */
    public final float getHeight() {
        return this.height;
    }

    /* renamed from: b, reason: from getter */
    public final float getWidth() {
        return this.width;
    }

    public String toString() {
        return "width:" + this.width + ", height:" + this.height;
    }

    public boolean equals(Object other) {
        if (other == null || !(other instanceof w)) {
            return false;
        }
        w wVar = (w) other;
        if (wVar.width == this.width) {
            return (wVar.height > this.height ? 1 : (wVar.height == this.height ? 0 : -1)) == 0;
        }
        return false;
    }
}
