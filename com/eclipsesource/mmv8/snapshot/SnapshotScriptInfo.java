package com.eclipsesource.mmv8.snapshot;

import java.util.Objects;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class SnapshotScriptInfo {
    public static final int INVALID_FD = -1;
    public final String content;

    /* renamed from: fd, reason: collision with root package name */
    public final int f32586fd;
    public long length;
    public final String name;
    public final long startOffset;

    public SnapshotScriptInfo(String str, int i3, long j3, long j16) {
        if (!Utils.isNullOrEmpty(str)) {
            if (!Utils.isInvalidFd(i3)) {
                this.name = str;
                this.f32586fd = i3;
                this.startOffset = j3;
                this.length = j16;
                this.content = null;
                return;
            }
            throw new IllegalArgumentException("fd is illegal");
        }
        throw new IllegalArgumentException("name is empty");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && SnapshotScriptInfo.class == obj.getClass()) {
            return Objects.equals(this.name, ((SnapshotScriptInfo) obj).name);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.name);
    }

    public String toString() {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("SnapshotScriptInfo{name='");
        sb5.append(this.name);
        sb5.append('\'');
        sb5.append(", fd=");
        sb5.append(this.f32586fd);
        sb5.append(", startOffset=");
        sb5.append(this.startOffset);
        sb5.append(", length=");
        sb5.append(this.length);
        sb5.append(", content='");
        String str2 = this.content;
        if (str2 != null) {
            str = str2.substring(0, Math.min(str2.length(), 1024));
        } else {
            str = null;
        }
        sb5.append(str);
        sb5.append('\'');
        sb5.append('}');
        return sb5.toString();
    }

    public SnapshotScriptInfo(String str, String str2) {
        if (!Utils.isNullOrEmpty(str)) {
            if (!Utils.isNullOrEmpty(str2)) {
                this.name = str;
                this.f32586fd = -1;
                this.startOffset = 0L;
                this.length = 0L;
                this.content = str2;
                return;
            }
            throw new IllegalArgumentException("content is empty");
        }
        throw new IllegalArgumentException("name is empty");
    }
}
