package com.tencent.mobileqq.icgame.api.login.impl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r32.QQConnectAuthInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J+\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006H\u00c6\u0001J\t\u0010\f\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\r\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/icgame/api/login/impl/AuthRequestRsp;", "", "", "component1", "", "component2", "Lr32/c;", "component3", "code", "msg", "authInfo", "copy", "toString", "hashCode", "other", "", "equals", "I", "getCode", "()I", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "Lr32/c;", "getAuthInfo", "()Lr32/c;", "<init>", "(ILjava/lang/String;Lr32/c;)V", "ic-game-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final /* data */ class AuthRequestRsp {

    @Nullable
    private final QQConnectAuthInfo authInfo;
    private final int code;

    @Nullable
    private final String msg;

    public AuthRequestRsp(int i3, @Nullable String str, @Nullable QQConnectAuthInfo qQConnectAuthInfo) {
        this.code = i3;
        this.msg = str;
        this.authInfo = qQConnectAuthInfo;
    }

    public static /* synthetic */ AuthRequestRsp copy$default(AuthRequestRsp authRequestRsp, int i3, String str, QQConnectAuthInfo qQConnectAuthInfo, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = authRequestRsp.code;
        }
        if ((i16 & 2) != 0) {
            str = authRequestRsp.msg;
        }
        if ((i16 & 4) != 0) {
            qQConnectAuthInfo = authRequestRsp.authInfo;
        }
        return authRequestRsp.copy(i3, str, qQConnectAuthInfo);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final QQConnectAuthInfo getAuthInfo() {
        return this.authInfo;
    }

    @NotNull
    public final AuthRequestRsp copy(int code, @Nullable String msg2, @Nullable QQConnectAuthInfo authInfo) {
        return new AuthRequestRsp(code, msg2, authInfo);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuthRequestRsp)) {
            return false;
        }
        AuthRequestRsp authRequestRsp = (AuthRequestRsp) other;
        if (this.code == authRequestRsp.code && Intrinsics.areEqual(this.msg, authRequestRsp.msg) && Intrinsics.areEqual(this.authInfo, authRequestRsp.authInfo)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final QQConnectAuthInfo getAuthInfo() {
        return this.authInfo;
    }

    public final int getCode() {
        return this.code;
    }

    @Nullable
    public final String getMsg() {
        return this.msg;
    }

    public int hashCode() {
        int hashCode;
        int i3 = this.code * 31;
        String str = this.msg;
        int i16 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i17 = (i3 + hashCode) * 31;
        QQConnectAuthInfo qQConnectAuthInfo = this.authInfo;
        if (qQConnectAuthInfo != null) {
            i16 = qQConnectAuthInfo.hashCode();
        }
        return i17 + i16;
    }

    @NotNull
    public String toString() {
        return "AuthRequestRsp(code=" + this.code + ", msg=" + this.msg + ", authInfo=" + this.authInfo + ")";
    }
}
