package com.tencent.kuikly.core.base;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/kuikly/core/base/s;", "", "", "toString", "", "a", UserInfo.SEX_FEMALE, "number100", "<init>", "(F)V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final float number100;

    public s(float f16) {
        this.number100 = f16;
    }

    public final float a() {
        return this.number100 / 100.0f;
    }

    public String toString() {
        return String.valueOf(this.number100);
    }
}
