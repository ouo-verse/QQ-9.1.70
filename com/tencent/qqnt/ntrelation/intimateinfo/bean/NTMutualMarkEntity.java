package com.tencent.qqnt.ntrelation.intimateinfo.bean;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.MutualMark;
import com.tencent.qqnt.kernel.nativeinterface.ResourceInfo;
import com.tencent.qqnt.ntrelation.protocol.ProfileUpdateMsg$ResourceInfo;
import com.tencent.qqnt.ntrelation.protocol.ProfileUpdateMsg$updateMutualMark;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "uid,type")
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0013\u0010\"\u001a\u00020\f2\b\u0010#\u001a\u0004\u0018\u00010$H\u0096\u0002J\u0010\u0010%\u001a\u00020\f2\b\u0010&\u001a\u0004\u0018\u00010\u0000J&\u0010'\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001aJ\u000e\u0010+\u001a\u00020,2\u0006\u0010*\u001a\u00020\u001aJ\b\u0010-\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u001f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010 \u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010!\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2 = {"Lcom/tencent/qqnt/ntrelation/intimateinfo/bean/NTMutualMarkEntity;", "Lcom/tencent/mobileqq/persistence/Entity;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "continue_days", "", "count", "", "hasRemindInContact", "", "iconFormat", "iconUrl", "icon_dynamic_url", "icon_name", "icon_static_url", "icon_status", "icon_status_end_time", "isWearing", "last_action_time", "last_change_time", "level", "markFlag", "markVersion", "", "orderNum", "remindAnimStartTime", "sub_level", "type", "uid", "uin", "user_close_flag", "equals", "other", "", "isSameIcon", "info", "mergeFromMutualMark", "mutualMark", "Lcom/tencent/qqnt/kernel/nativeinterface/MutualMark;", "curOrderNum", "mergeToMutualMark", "Lcom/tencent/qqnt/ntrelation/protocol/ProfileUpdateMsg$updateMutualMark;", "toString", "contacts_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes22.dex */
public final class NTMutualMarkEntity extends Entity {
    static IPatchRedirector $redirector_;

    @NotNull
    private final String TAG;

    @JvmField
    public long continue_days;

    @JvmField
    public float count;

    @JvmField
    public boolean hasRemindInContact;

    @JvmField
    @Nullable
    public String iconFormat;

    @JvmField
    @NotNull
    public String iconUrl;

    @JvmField
    @NotNull
    public String icon_dynamic_url;

    @JvmField
    @NotNull
    public String icon_name;

    @JvmField
    @NotNull
    public String icon_static_url;

    @JvmField
    public long icon_status;

    @JvmField
    public long icon_status_end_time;

    @JvmField
    public boolean isWearing;

    @JvmField
    public long last_action_time;

    @JvmField
    public long last_change_time;

    @JvmField
    public long level;

    @JvmField
    public long markFlag;

    @JvmField
    public int markVersion;

    @JvmField
    public int orderNum;

    @JvmField
    public long remindAnimStartTime;

    @JvmField
    public long sub_level;

    @JvmField
    public long type;

    @JvmField
    @NotNull
    public String uid;

    @JvmField
    @NotNull
    public String uin;

    @JvmField
    public boolean user_close_flag;

    public NTMutualMarkEntity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.TAG = "NTMutualMarkInfo";
        this.uid = "";
        this.uin = "";
        this.icon_static_url = "";
        this.icon_dynamic_url = "";
        this.icon_name = "";
        this.iconUrl = "";
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
        }
        if (!(other instanceof NTMutualMarkEntity)) {
            return false;
        }
        NTMutualMarkEntity nTMutualMarkEntity = (NTMutualMarkEntity) other;
        if (!Intrinsics.areEqual(this.uid, nTMutualMarkEntity.uid) || this.type != nTMutualMarkEntity.type) {
            return false;
        }
        return true;
    }

    @NotNull
    public final String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.TAG;
    }

    public final boolean isSameIcon(@Nullable NTMutualMarkEntity info) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) info)).booleanValue();
        }
        String str2 = this.uid;
        if (info != null) {
            str = info.uid;
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(str2, str) && this.type == info.type) {
            return true;
        }
        return false;
    }

    @NotNull
    public final NTMutualMarkEntity mergeFromMutualMark(@NotNull String uid, @NotNull String uin, @NotNull MutualMark mutualMark, int curOrderNum) {
        long longValue;
        long longValue2;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (NTMutualMarkEntity) iPatchRedirector.redirect((short) 3, this, uid, uin, mutualMark, Integer.valueOf(curOrderNum));
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(mutualMark, "mutualMark");
        this.uid = uid;
        this.uin = uin;
        this.type = mutualMark.type;
        this.level = mutualMark.level;
        this.count = mutualMark.count;
        this.continue_days = mutualMark.continueDays;
        this.last_action_time = mutualMark.lastActionTime;
        Long l3 = mutualMark.lastChangTime;
        long j3 = 0;
        if (l3 == null) {
            longValue = 0;
        } else {
            longValue = l3.longValue();
        }
        this.last_change_time = longValue;
        this.icon_status = mutualMark.iconStatus;
        Long l16 = mutualMark.iconStatusEndTime;
        if (l16 == null) {
            longValue2 = 0;
        } else {
            longValue2 = l16.longValue();
        }
        this.icon_status_end_time = longValue2;
        this.sub_level = mutualMark.subLevel;
        ResourceInfo resourceInfo = mutualMark.resourceInfo;
        String str = "";
        if (resourceInfo != null) {
            String str2 = resourceInfo.iconStaticUrl;
            if (str2 == null) {
                str2 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str2, "it.iconStaticUrl?:\"\"");
            }
            this.icon_static_url = str2;
            String str3 = resourceInfo.iconDynamicUrl;
            if (str3 == null) {
                str3 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str3, "it.iconDynamicUrl?:\"\"");
            }
            this.icon_dynamic_url = str3;
            String str4 = resourceInfo.iconName;
            if (str4 == null) {
                str4 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str4, "it.iconName?:\"\"");
            }
            this.icon_name = str4;
        }
        Integer num = mutualMark.closeFlag;
        if (num == null || num.intValue() != 1) {
            z16 = false;
        }
        this.user_close_flag = z16;
        this.hasRemindInContact = mutualMark.hasRemindInContact;
        Long l17 = mutualMark.remindAnimStartTime;
        if (l17 != null) {
            j3 = l17.longValue();
        }
        this.remindAnimStartTime = j3;
        String str5 = mutualMark.iconUrl;
        if (str5 == null) {
            str5 = "";
        }
        this.iconUrl = str5;
        Integer num2 = mutualMark.markVersion;
        if (num2 != null) {
            i3 = num2.intValue();
        }
        this.markVersion = i3;
        this.isWearing = mutualMark.isWearing;
        String str6 = mutualMark.iconFormat;
        if (str6 != null) {
            str = str6;
        }
        this.iconFormat = str;
        this.markFlag = mutualMark.markFlag;
        this.orderNum = curOrderNum;
        return this;
    }

    @NotNull
    public final ProfileUpdateMsg$updateMutualMark mergeToMutualMark(int curOrderNum) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ProfileUpdateMsg$updateMutualMark) iPatchRedirector.redirect((short) 4, (Object) this, curOrderNum);
        }
        ProfileUpdateMsg$updateMutualMark profileUpdateMsg$updateMutualMark = new ProfileUpdateMsg$updateMutualMark();
        ProfileUpdateMsg$ResourceInfo profileUpdateMsg$ResourceInfo = new ProfileUpdateMsg$ResourceInfo();
        profileUpdateMsg$updateMutualMark.type.set(this.type);
        profileUpdateMsg$updateMutualMark.level.set(this.level);
        profileUpdateMsg$updateMutualMark.count.set(this.count);
        profileUpdateMsg$updateMutualMark.continueDays.set(this.continue_days);
        profileUpdateMsg$updateMutualMark.lastActionTime.set(this.last_action_time);
        profileUpdateMsg$updateMutualMark.lastChangTime.set(this.last_change_time);
        profileUpdateMsg$updateMutualMark.iconStatus.set(this.icon_status);
        profileUpdateMsg$updateMutualMark.iconStatusEndTime.set(this.icon_status_end_time);
        profileUpdateMsg$updateMutualMark.subLevel.set(this.sub_level);
        profileUpdateMsg$ResourceInfo.iconStaticUrl.set(this.icon_static_url);
        profileUpdateMsg$ResourceInfo.iconDynamicUrl.set(this.icon_dynamic_url);
        profileUpdateMsg$ResourceInfo.iconName.set(this.icon_name);
        profileUpdateMsg$updateMutualMark.resourceInfo.set(profileUpdateMsg$ResourceInfo);
        profileUpdateMsg$updateMutualMark.closeFlag.set(this.user_close_flag ? 1 : 0);
        profileUpdateMsg$updateMutualMark.hasRemindInContact.set(this.hasRemindInContact);
        profileUpdateMsg$updateMutualMark.remindAnimStartTime.set(this.remindAnimStartTime);
        profileUpdateMsg$updateMutualMark.iconUrl.set(this.iconUrl);
        profileUpdateMsg$updateMutualMark.markVersion.set(this.markVersion);
        profileUpdateMsg$updateMutualMark.isWearing.set(this.isWearing);
        profileUpdateMsg$updateMutualMark.iconFormat.set(this.iconFormat);
        profileUpdateMsg$updateMutualMark.markFlag.set(this.markFlag);
        profileUpdateMsg$updateMutualMark.orderNum.set(curOrderNum);
        return profileUpdateMsg$updateMutualMark;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "NTMutualMarkInfo uin " + this.uin + " uid " + this.uid + " icon_static_url " + this.icon_static_url + " icon_dynamic_url " + this.icon_dynamic_url + " icon_url " + this.iconUrl + " orderNum: " + this.orderNum;
    }
}
