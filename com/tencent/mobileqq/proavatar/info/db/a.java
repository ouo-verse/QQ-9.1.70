package com.tencent.mobileqq.proavatar.info.db;

import com.tencent.mobileqq.data.Setting;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/proavatar/info/db/AvatarInfoEntity;", "Lcom/tencent/mobileqq/data/Setting;", "a", "qqavatar-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a {
    @NotNull
    public static final Setting a(@NotNull AvatarInfoEntity avatarInfoEntity) {
        Intrinsics.checkNotNullParameter(avatarInfoEntity, "<this>");
        Setting setting = new Setting();
        setting.uin = avatarInfoEntity.key;
        setting.headImgTimestamp = avatarInfoEntity.headImgTimestamp;
        setting.systemHeadID = avatarInfoEntity.systemHeadID;
        setting.bFaceFlags = avatarInfoEntity.bFaceFlags;
        setting.bUsrType = avatarInfoEntity.bUsrType;
        setting.bHeadType = avatarInfoEntity.bHeadType;
        setting.url = avatarInfoEntity.url;
        setting.bSourceType = avatarInfoEntity.bSourceType;
        setting.updateTimestamp = avatarInfoEntity.updateTimestamp;
        setting.staticZplanFaceFlag = avatarInfoEntity.staticZplanFaceFlag;
        setting.dynamicZplanFaceFlag = avatarInfoEntity.dynamicZplanFaceFlag;
        setting.zplanFaceBgUrl = avatarInfoEntity.zplanFaceBgUrl;
        setting.zplanFaceClipPercent = avatarInfoEntity.zplanFaceClipPercent;
        setting.apngFaceFlag = avatarInfoEntity.apngFaceFlag;
        return setting;
    }
}
