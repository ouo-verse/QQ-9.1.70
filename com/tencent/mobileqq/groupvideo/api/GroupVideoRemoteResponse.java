package com.tencent.mobileqq.groupvideo.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/groupvideo/api/GroupVideoRemoteResponse;", "Ljava/io/Serializable;", "code", "", "msg", "", "data", "", "(ILjava/lang/String;[B)V", "getCode", "()I", "getData", "()[B", "getMsg", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "group-video-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final /* data */ class GroupVideoRemoteResponse implements Serializable {
    static IPatchRedirector $redirector_;
    private final int code;

    @Nullable
    private final byte[] data;

    @NotNull
    private final String msg;

    public GroupVideoRemoteResponse(int i3, @NotNull String msg2, @Nullable byte[] bArr) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), msg2, bArr);
            return;
        }
        this.code = i3;
        this.msg = msg2;
        this.data = bArr;
    }

    public static /* synthetic */ GroupVideoRemoteResponse copy$default(GroupVideoRemoteResponse groupVideoRemoteResponse, int i3, String str, byte[] bArr, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = groupVideoRemoteResponse.code;
        }
        if ((i16 & 2) != 0) {
            str = groupVideoRemoteResponse.msg;
        }
        if ((i16 & 4) != 0) {
            bArr = groupVideoRemoteResponse.data;
        }
        return groupVideoRemoteResponse.copy(i3, str, bArr);
    }

    public final int component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.code;
    }

    @NotNull
    public final String component2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.msg;
    }

    @Nullable
    public final byte[] component3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (byte[]) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.data;
    }

    @NotNull
    public final GroupVideoRemoteResponse copy(int code, @NotNull String msg2, @Nullable byte[] data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (GroupVideoRemoteResponse) iPatchRedirector.redirect((short) 9, this, Integer.valueOf(code), msg2, data);
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        return new GroupVideoRemoteResponse(code, msg2, data);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof GroupVideoRemoteResponse)) {
            return false;
        }
        GroupVideoRemoteResponse groupVideoRemoteResponse = (GroupVideoRemoteResponse) other;
        if (this.code == groupVideoRemoteResponse.code && Intrinsics.areEqual(this.msg, groupVideoRemoteResponse.msg) && Intrinsics.areEqual(this.data, groupVideoRemoteResponse.data)) {
            return true;
        }
        return false;
    }

    public final int getCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.code;
    }

    @Nullable
    public final byte[] getData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (byte[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.data;
    }

    @NotNull
    public final String getMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.msg;
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        int hashCode2 = ((this.code * 31) + this.msg.hashCode()) * 31;
        byte[] bArr = this.data;
        if (bArr == null) {
            hashCode = 0;
        } else {
            hashCode = Arrays.hashCode(bArr);
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return "GroupVideoRemoteResponse(code=" + this.code + ", msg=" + this.msg + ", data=" + Arrays.toString(this.data) + ")";
    }

    public /* synthetic */ GroupVideoRemoteResponse(int i3, String str, byte[] bArr, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, (i16 & 4) != 0 ? null : bArr);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, bArr, Integer.valueOf(i16), defaultConstructorMarker);
    }
}
