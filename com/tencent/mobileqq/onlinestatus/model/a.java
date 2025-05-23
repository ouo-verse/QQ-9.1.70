package com.tencent.mobileqq.onlinestatus.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/model/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getBaseMD5", "()Ljava/lang/String;", "baseMD5", "b", "getActionMD5", "actionMD5", "c", "actionKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "qqonlinestatus-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final /* data */ class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String baseMD5;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String actionMD5;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String actionKey;

    public a(@NotNull String baseMD5, @NotNull String actionMD5) {
        Intrinsics.checkNotNullParameter(baseMD5, "baseMD5");
        Intrinsics.checkNotNullParameter(actionMD5, "actionMD5");
        this.baseMD5 = baseMD5;
        this.actionMD5 = actionMD5;
        StringBuilder sb5 = new StringBuilder();
        sb5.append((Object) baseMD5.subSequence(0, 8));
        sb5.append(util.base64_pad_url);
        sb5.append((Object) actionMD5.subSequence(0, 8));
        this.actionKey = sb5.toString();
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getActionKey() {
        return this.actionKey;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (Intrinsics.areEqual(this.baseMD5, aVar.baseMD5) && Intrinsics.areEqual(this.actionMD5, aVar.actionMD5)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.baseMD5.hashCode() * 31) + this.actionMD5.hashCode();
    }

    @NotNull
    public String toString() {
        return "{base:" + this.baseMD5 + ",action:" + this.actionMD5 + '}';
    }
}
