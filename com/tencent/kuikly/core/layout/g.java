package com.tencent.kuikly.core.layout;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\n\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/kuikly/core/layout/g;", "", "", "a", UserInfo.SEX_FEMALE, "b", "()F", "d", "(F)V", "width", "c", "height", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private float width;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private float height;

    /* renamed from: a, reason: from getter */
    public final float getHeight() {
        return this.height;
    }

    /* renamed from: b, reason: from getter */
    public final float getWidth() {
        return this.width;
    }

    public final void c(float f16) {
        this.height = f16;
    }

    public final void d(float f16) {
        this.width = f16;
    }
}
