package com.tencent.mobileqq.selectfriend.relationlist;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\bH\u00c6\u0003J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\u000bH\u00c6\u0003J\t\u0010#\u001a\u00020\u000bH\u00c6\u0003J\t\u0010$\u001a\u00020\u000eH\u00c6\u0003Jc\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u00c6\u0001J\u0013\u0010&\u001a\u00020\u000b2\b\u0010'\u001a\u0004\u0018\u00010\u000eH\u00d6\u0003J\t\u0010(\u001a\u00020\bH\u00d6\u0001J\t\u0010)\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\f\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/relationlist/SharedNode;", "Ljava/io/Serializable;", "key", "", "type", "bizId", "tips", "avatarType", "", "title", "isRobot", "", "needRightArrow", "bizData", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZZLjava/lang/Object;)V", "getAvatarType", "()I", "getBizData", "()Ljava/lang/Object;", "getBizId", "()Ljava/lang/String;", "()Z", "getKey", "getNeedRightArrow", "getTips", "getTitle", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "qq_selectfriend_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public final /* data */ class SharedNode implements Serializable {
    static IPatchRedirector $redirector_;
    private final int avatarType;

    @NotNull
    private final Object bizData;

    @NotNull
    private final String bizId;
    private final boolean isRobot;

    @NotNull
    private final String key;
    private final boolean needRightArrow;

    @NotNull
    private final String tips;

    @NotNull
    private final String title;

    @NotNull
    private final String type;

    public SharedNode(@NotNull String key, @NotNull String type, @NotNull String bizId, @NotNull String tips, int i3, @NotNull String title, boolean z16, boolean z17, @NotNull Object bizData) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(bizId, "bizId");
        Intrinsics.checkNotNullParameter(tips, "tips");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(bizData, "bizData");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, key, type, bizId, tips, Integer.valueOf(i3), title, Boolean.valueOf(z16), Boolean.valueOf(z17), bizData);
            return;
        }
        this.key = key;
        this.type = type;
        this.bizId = bizId;
        this.tips = tips;
        this.avatarType = i3;
        this.title = title;
        this.isRobot = z16;
        this.needRightArrow = z17;
        this.bizData = bizData;
    }

    public static /* synthetic */ SharedNode copy$default(SharedNode sharedNode, String str, String str2, String str3, String str4, int i3, String str5, boolean z16, boolean z17, Object obj, int i16, Object obj2) {
        String str6;
        String str7;
        String str8;
        String str9;
        int i17;
        String str10;
        boolean z18;
        boolean z19;
        Object obj3;
        if ((i16 & 1) != 0) {
            str6 = sharedNode.key;
        } else {
            str6 = str;
        }
        if ((i16 & 2) != 0) {
            str7 = sharedNode.type;
        } else {
            str7 = str2;
        }
        if ((i16 & 4) != 0) {
            str8 = sharedNode.bizId;
        } else {
            str8 = str3;
        }
        if ((i16 & 8) != 0) {
            str9 = sharedNode.tips;
        } else {
            str9 = str4;
        }
        if ((i16 & 16) != 0) {
            i17 = sharedNode.avatarType;
        } else {
            i17 = i3;
        }
        if ((i16 & 32) != 0) {
            str10 = sharedNode.title;
        } else {
            str10 = str5;
        }
        if ((i16 & 64) != 0) {
            z18 = sharedNode.isRobot;
        } else {
            z18 = z16;
        }
        if ((i16 & 128) != 0) {
            z19 = sharedNode.needRightArrow;
        } else {
            z19 = z17;
        }
        if ((i16 & 256) != 0) {
            obj3 = sharedNode.bizData;
        } else {
            obj3 = obj;
        }
        return sharedNode.copy(str6, str7, str8, str9, i17, str10, z18, z19, obj3);
    }

    @NotNull
    public final String component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.key;
    }

    @NotNull
    public final String component2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.type;
    }

    @NotNull
    public final String component3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.bizId;
    }

    @NotNull
    public final String component4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.tips;
    }

    public final int component5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return this.avatarType;
    }

    @NotNull
    public final String component6() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.title;
    }

    public final boolean component7() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return this.isRobot;
    }

    public final boolean component8() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        return this.needRightArrow;
    }

    @NotNull
    public final Object component9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.bizData;
    }

    @NotNull
    public final SharedNode copy(@NotNull String key, @NotNull String type, @NotNull String bizId, @NotNull String tips, int avatarType, @NotNull String title, boolean isRobot, boolean needRightArrow, @NotNull Object bizData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (SharedNode) iPatchRedirector.redirect((short) 21, this, key, type, bizId, tips, Integer.valueOf(avatarType), title, Boolean.valueOf(isRobot), Boolean.valueOf(needRightArrow), bizData);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(bizId, "bizId");
        Intrinsics.checkNotNullParameter(tips, "tips");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(bizData, "bizData");
        return new SharedNode(key, type, bizId, tips, avatarType, title, isRobot, needRightArrow, bizData);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof SharedNode)) {
            return false;
        }
        SharedNode sharedNode = (SharedNode) other;
        if (Intrinsics.areEqual(this.key, sharedNode.key) && Intrinsics.areEqual(this.type, sharedNode.type) && Intrinsics.areEqual(this.bizId, sharedNode.bizId) && Intrinsics.areEqual(this.tips, sharedNode.tips) && this.avatarType == sharedNode.avatarType && Intrinsics.areEqual(this.title, sharedNode.title) && this.isRobot == sharedNode.isRobot && this.needRightArrow == sharedNode.needRightArrow && Intrinsics.areEqual(this.bizData, sharedNode.bizData)) {
            return true;
        }
        return false;
    }

    public final int getAvatarType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.avatarType;
    }

    @NotNull
    public final Object getBizData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.bizData;
    }

    @NotNull
    public final String getBizId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.bizId;
    }

    @NotNull
    public final String getKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.key;
    }

    public final boolean getNeedRightArrow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.needRightArrow;
    }

    @NotNull
    public final String getTips() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.tips;
    }

    @NotNull
    public final String getTitle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.title;
    }

    @NotNull
    public final String getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        int hashCode = ((((((((((this.key.hashCode() * 31) + this.type.hashCode()) * 31) + this.bizId.hashCode()) * 31) + this.tips.hashCode()) * 31) + this.avatarType) * 31) + this.title.hashCode()) * 31;
        boolean z16 = this.isRobot;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode + i16) * 31;
        boolean z17 = this.needRightArrow;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return ((i17 + i3) * 31) + this.bizData.hashCode();
    }

    public final boolean isRobot() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.isRobot;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return "SharedNode(key=" + this.key + ", type=" + this.type + ", bizId=" + this.bizId + ", tips=" + this.tips + ", avatarType=" + this.avatarType + ", title=" + this.title + ", isRobot=" + this.isRobot + ", needRightArrow=" + this.needRightArrow + ", bizData=" + this.bizData + ')';
    }

    public /* synthetic */ SharedNode(String str, String str2, String str3, String str4, int i3, String str5, boolean z16, boolean z17, Object obj, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i16 & 4) != 0 ? "" : str3, (i16 & 8) != 0 ? "" : str4, i3, str5, z16, (i16 & 128) != 0 ? false : z17, obj);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, str2, str3, str4, Integer.valueOf(i3), str5, Boolean.valueOf(z16), Boolean.valueOf(z17), obj, Integer.valueOf(i16), defaultConstructorMarker);
    }
}
