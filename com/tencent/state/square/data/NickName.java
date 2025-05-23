package com.tencent.state.square.data;

import android.graphics.Point;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0007H\u00c6\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/state/square/data/NickName;", "", "nick", "", "isMe", "", "coordinate", "Landroid/graphics/Point;", "(Ljava/lang/String;ZLandroid/graphics/Point;)V", "getCoordinate", "()Landroid/graphics/Point;", "()Z", "getNick", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class NickName {
    private final Point coordinate;
    private final boolean isMe;
    private final String nick;

    public NickName(String nick, boolean z16, Point coordinate) {
        Intrinsics.checkNotNullParameter(nick, "nick");
        Intrinsics.checkNotNullParameter(coordinate, "coordinate");
        this.nick = nick;
        this.isMe = z16;
        this.coordinate = coordinate;
    }

    /* renamed from: component1, reason: from getter */
    public final String getNick() {
        return this.nick;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsMe() {
        return this.isMe;
    }

    /* renamed from: component3, reason: from getter */
    public final Point getCoordinate() {
        return this.coordinate;
    }

    public final NickName copy(String nick, boolean isMe, Point coordinate) {
        Intrinsics.checkNotNullParameter(nick, "nick");
        Intrinsics.checkNotNullParameter(coordinate, "coordinate");
        return new NickName(nick, isMe, coordinate);
    }

    public final Point getCoordinate() {
        return this.coordinate;
    }

    public final String getNick() {
        return this.nick;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.nick;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z16 = this.isMe;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode + i3) * 31;
        Point point = this.coordinate;
        return i16 + (point != null ? point.hashCode() : 0);
    }

    public final boolean isMe() {
        return this.isMe;
    }

    public String toString() {
        return "NickName(nick=" + this.nick + ", isMe=" + this.isMe + ", coordinate=" + this.coordinate + ")";
    }

    public /* synthetic */ NickName(String str, boolean z16, Point point, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? false : z16, (i3 & 4) != 0 ? new Point(0, 0) : point);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NickName)) {
            return false;
        }
        NickName nickName = (NickName) other;
        return Intrinsics.areEqual(this.nick, nickName.nick) && this.isMe == nickName.isMe && Intrinsics.areEqual(this.coordinate, nickName.coordinate);
    }

    public static /* synthetic */ NickName copy$default(NickName nickName, String str, boolean z16, Point point, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = nickName.nick;
        }
        if ((i3 & 2) != 0) {
            z16 = nickName.isMe;
        }
        if ((i3 & 4) != 0) {
            point = nickName.coordinate;
        }
        return nickName.copy(str, z16, point);
    }
}
