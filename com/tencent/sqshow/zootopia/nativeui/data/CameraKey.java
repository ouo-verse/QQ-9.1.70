package com.tencent.sqshow.zootopia.nativeui.data;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u0000 \u00052\u00020\u0001:\u0001\fB\u0019\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\b\b\u0002\u0010\u0013\u001a\u00020\n\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0006\u0010\u0005\u001a\u00020\u0003J\u0006\u0010\u0007\u001a\u00020\u0006J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\nH\u00d6\u0001R\u0017\u0010\u0010\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0013\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\r\u001a\u0004\b\f\u0010\u000f\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/data/m;", "", "other", "", "equals", "c", "", "d", "", "toString", "", "hashCode", "a", "I", "b", "()I", "cameraId", "setBodyItemId", "(I)V", "bodyItemId", "<init>", "(II)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.zootopia.nativeui.data.m, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class CameraKey {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int cameraId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private int bodyItemId;

    public CameraKey(int i3, int i16) {
        this.cameraId = i3;
        this.bodyItemId = i16;
    }

    /* renamed from: a, reason: from getter */
    public final int getBodyItemId() {
        return this.bodyItemId;
    }

    /* renamed from: b, reason: from getter */
    public final int getCameraId() {
        return this.cameraId;
    }

    public final boolean c() {
        return this.cameraId != 0;
    }

    public final void d() {
        int i3 = this.bodyItemId;
        int d16 = r94.b.d(c.f370920a.m().b().getAvatarCharacter());
        this.bodyItemId = d16;
        QLog.i("CameraKey_", 1, "refreshBodyId old:" + i3 + ", new:" + d16);
    }

    public boolean equals(Object other) {
        if (!(other instanceof CameraKey)) {
            return false;
        }
        CameraKey cameraKey = (CameraKey) other;
        return this.cameraId == cameraKey.cameraId && this.bodyItemId == cameraKey.bodyItemId;
    }

    public int hashCode() {
        return (this.cameraId * 31) + this.bodyItemId;
    }

    public String toString() {
        return "CameraKey(cameraId=" + this.cameraId + ", bodyItemId=" + this.bodyItemId + ")";
    }

    public /* synthetic */ CameraKey(int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i17 & 2) != 0 ? r94.b.d(c.f370920a.m().b().getAvatarCharacter()) : i16);
    }
}
