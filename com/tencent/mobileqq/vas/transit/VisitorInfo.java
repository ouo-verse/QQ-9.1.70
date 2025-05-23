package com.tencent.mobileqq.vas.transit;

import java.io.Serializable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/vas/transit/VisitorInfo;", "Ljava/io/Serializable;", "()V", "groupId", "", "getGroupId", "()Ljava/lang/String;", "setGroupId", "(Ljava/lang/String;)V", "isAdmin", "", "()Ljava/lang/Boolean;", "setAdmin", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "source", "", "getSource", "()I", "setSource", "(I)V", "uin", "getUin", "setUin", "toString", "zplan_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VisitorInfo implements Serializable {

    @Nullable
    private String groupId;

    @Nullable
    private Boolean isAdmin;
    private int source = 1;

    @Nullable
    private String uin;

    @Nullable
    public final String getGroupId() {
        return this.groupId;
    }

    public final int getSource() {
        return this.source;
    }

    @Nullable
    public final String getUin() {
        return this.uin;
    }

    @Nullable
    /* renamed from: isAdmin, reason: from getter */
    public final Boolean getIsAdmin() {
        return this.isAdmin;
    }

    public final void setAdmin(@Nullable Boolean bool) {
        this.isAdmin = bool;
    }

    public final void setGroupId(@Nullable String str) {
        this.groupId = str;
    }

    public final void setSource(int i3) {
        this.source = i3;
    }

    public final void setUin(@Nullable String str) {
        this.uin = str;
    }

    @NotNull
    public String toString() {
        return "VisitorInfo(uin=" + this.uin + ", groupId=" + this.groupId + ", isAdmin=" + this.isAdmin + ", source=" + this.source + ')';
    }
}
