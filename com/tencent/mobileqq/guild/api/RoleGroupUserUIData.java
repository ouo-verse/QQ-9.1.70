package com.tencent.mobileqq.guild.api;

import android.text.TextUtils;
import com.tencent.mobileqq.qqguildsdk.data.IGProIdentityInfo;
import com.tencent.mobileqq.vaswebviewplugin.MessageRoamJsPlugin;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 &2\u00020\u0001:\u0001'B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b$\u0010\rB\u0019\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0000J\b\u0010\u0006\u001a\u00020\u0005H\u0016R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\"\u0010\u0017\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\"\u0010\u001a\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\t\u001a\u0004\b\u001b\u0010\u000b\"\u0004\b\u001c\u0010\rR$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/guild/api/RoleGroupUserUIData;", "Ljava/io/Serializable;", "uiData", "", "isEqual", "", "toString", "", "type", "I", "getType", "()I", "setType", "(I)V", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "tinyId", "getTinyId", "setTinyId", "titleName", "getTitleName", "setTitleName", MessageRoamJsPlugin.USERTYPE, "getUserType", "setUserType", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProIdentityInfo;", "userIdentity", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProIdentityInfo;", "getUserIdentity", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProIdentityInfo;", "setUserIdentity", "(Lcom/tencent/mobileqq/qqguildsdk/data/IGProIdentityInfo;)V", "<init>", "(ILjava/lang/String;)V", "Companion", "a", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class RoleGroupUserUIData implements Serializable {
    public static final int MEMBER_TYPE_EMPTY = 0;
    public static final int MEMBER_TYPE_SPACE = 3;
    public static final int MEMBER_TYPE_TITLE = 2;
    public static final int MEMBER_TYPE_USER = 1;

    /* renamed from: name, reason: from kotlin metadata and from toString */
    @NotNull
    private String mName;

    /* renamed from: tinyId, reason: from kotlin metadata and from toString */
    @NotNull
    private String mTinyId;

    /* renamed from: titleName, reason: from kotlin metadata and from toString */
    @NotNull
    private String mTitleName;
    private int type;

    @Nullable
    private IGProIdentityInfo userIdentity;
    private int userType;

    public RoleGroupUserUIData(int i3) {
        this.mName = "";
        this.mTinyId = "";
        this.mTitleName = "";
        this.type = i3;
    }

    @NotNull
    /* renamed from: getName, reason: from getter */
    public final String getMName() {
        return this.mName;
    }

    @NotNull
    /* renamed from: getTinyId, reason: from getter */
    public final String getMTinyId() {
        return this.mTinyId;
    }

    @NotNull
    /* renamed from: getTitleName, reason: from getter */
    public final String getMTitleName() {
        return this.mTitleName;
    }

    public final int getType() {
        return this.type;
    }

    @Nullable
    public final IGProIdentityInfo getUserIdentity() {
        return this.userIdentity;
    }

    public final int getUserType() {
        return this.userType;
    }

    public final boolean isEqual(@Nullable RoleGroupUserUIData uiData) {
        if (uiData == null) {
            return false;
        }
        if (!TextUtils.isEmpty(this.mTinyId) && !Intrinsics.areEqual(this.mTinyId, uiData.mTinyId)) {
            return false;
        }
        if (!TextUtils.isEmpty(this.mName) && !Intrinsics.areEqual(this.mName, uiData.mName)) {
            return false;
        }
        if ((!TextUtils.isEmpty(this.mTitleName) && !Intrinsics.areEqual(this.mTitleName, uiData.mTitleName)) || this.type != uiData.type) {
            return false;
        }
        return true;
    }

    public final void setName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mName = str;
    }

    public final void setTinyId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mTinyId = str;
    }

    public final void setTitleName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mTitleName = str;
    }

    public final void setType(int i3) {
        this.type = i3;
    }

    public final void setUserIdentity(@Nullable IGProIdentityInfo iGProIdentityInfo) {
        this.userIdentity = iGProIdentityInfo;
    }

    public final void setUserType(int i3) {
        this.userType = i3;
    }

    @NotNull
    public String toString() {
        return "RoleGroupUserUIData{mType=" + this.type + ", mName='" + this.mName + "', mTinyId='" + this.mTinyId + "', mTitleName='" + this.mTitleName + "'}";
    }

    public RoleGroupUserUIData(int i3, @NotNull String titleName) {
        Intrinsics.checkNotNullParameter(titleName, "titleName");
        this.mName = "";
        this.mTinyId = "";
        this.type = i3;
        this.mTitleName = titleName;
    }
}
