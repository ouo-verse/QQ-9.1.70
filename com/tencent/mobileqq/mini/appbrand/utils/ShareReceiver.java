package com.tencent.mobileqq.mini.appbrand.utils;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/mini/appbrand/utils/ShareReceiver;", "", "receiver", "", "scene", "", "(JI)V", "getReceiver", "()J", "getScene", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final /* data */ class ShareReceiver {
    private final long receiver;
    private final int scene;

    public ShareReceiver(long j3, int i3) {
        this.receiver = j3;
        this.scene = i3;
    }

    /* renamed from: component1, reason: from getter */
    public final long getReceiver() {
        return this.receiver;
    }

    /* renamed from: component2, reason: from getter */
    public final int getScene() {
        return this.scene;
    }

    public final ShareReceiver copy(long receiver, int scene) {
        return new ShareReceiver(receiver, scene);
    }

    public final long getReceiver() {
        return this.receiver;
    }

    public final int getScene() {
        return this.scene;
    }

    public int hashCode() {
        return (f.a(this.receiver) * 31) + this.scene;
    }

    public String toString() {
        return "ShareReceiver(receiver=" + this.receiver + ", scene=" + this.scene + ")";
    }

    public static /* synthetic */ ShareReceiver copy$default(ShareReceiver shareReceiver, long j3, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            j3 = shareReceiver.receiver;
        }
        if ((i16 & 2) != 0) {
            i3 = shareReceiver.scene;
        }
        return shareReceiver.copy(j3, i3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShareReceiver)) {
            return false;
        }
        ShareReceiver shareReceiver = (ShareReceiver) other;
        return this.receiver == shareReceiver.receiver && this.scene == shareReceiver.scene;
    }
}
