package com.tencent.ntcompose.material;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004R\u0016\u0010\t\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\bR\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\bR\u0016\u0010\f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ntcompose/material/ah;", "", "", "b", "", "c", "a", "", "J", "lastUpdateTimeMs", "startTimeMs", UserInfo.SEX_FEMALE, "deltaTimeMs", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
final class ah {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long lastUpdateTimeMs;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long startTimeMs;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private float deltaTimeMs;

    /* renamed from: a, reason: from getter */
    public final float getDeltaTimeMs() {
        return this.deltaTimeMs;
    }

    public final void b() {
        long a16 = zz0.a.f453719a.a();
        this.lastUpdateTimeMs = a16;
        this.startTimeMs = a16;
        this.deltaTimeMs = 0.0f;
    }

    public final float c() {
        long a16 = zz0.a.f453719a.a();
        float f16 = (float) (a16 - this.lastUpdateTimeMs);
        this.deltaTimeMs = f16;
        this.lastUpdateTimeMs = a16;
        return f16;
    }
}
