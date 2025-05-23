package com.tencent.mobileqq.util;

import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicSearchEmojiInfo;
import com.tencent.qqnt.kernel.nativeinterface.HotPicInfo;
import com.tencent.qqnt.kernel.nativeinterface.ThirdPartyInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/util/an;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/HotPicInfo;", "hotPicInfo", "Lcom/tencent/mobileqq/emosm/emosearch/EmotionSearchItem;", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/EmojiHotPicSearchEmojiInfo;", "emojiHotPicSearchEmojiInfo", "a", "<init>", "()V", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class an {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final an f306578a = new an();

    an() {
    }

    @NotNull
    public final EmotionSearchItem a(@NotNull EmojiHotPicSearchEmojiInfo emojiHotPicSearchEmojiInfo) {
        Intrinsics.checkNotNullParameter(emojiHotPicSearchEmojiInfo, "emojiHotPicSearchEmojiInfo");
        EmotionSearchItem emotionSearchItem = new EmotionSearchItem();
        emotionSearchItem.appid = emojiHotPicSearchEmojiInfo.packageID;
        emotionSearchItem.iconUrl = emojiHotPicSearchEmojiInfo.srcIconUrl;
        emotionSearchItem.name = emojiHotPicSearchEmojiInfo.srcName;
        emotionSearchItem.jumpUrl = emojiHotPicSearchEmojiInfo.srcWebUrl;
        emotionSearchItem.url = emojiHotPicSearchEmojiInfo.thumbnailUrl;
        emotionSearchItem.md5 = emojiHotPicSearchEmojiInfo.thumbnailMD5;
        emotionSearchItem.fileSize = emojiHotPicSearchEmojiInfo.thumbnailSize;
        emotionSearchItem.width = emojiHotPicSearchEmojiInfo.thumbnailWidth;
        emotionSearchItem.height = emojiHotPicSearchEmojiInfo.thumbnailHeight;
        emotionSearchItem.originalMD5 = emojiHotPicSearchEmojiInfo.imageMD5;
        emotionSearchItem.oringinalSize = emojiHotPicSearchEmojiInfo.imageSize;
        emotionSearchItem.originalWidth = emojiHotPicSearchEmojiInfo.imageWidth;
        emotionSearchItem.originalHeight = emojiHotPicSearchEmojiInfo.imageHeight;
        emotionSearchItem.originalUrl = emojiHotPicSearchEmojiInfo.imageUrl;
        emotionSearchItem.emojiType = emojiHotPicSearchEmojiInfo.emojiType;
        emotionSearchItem.textComposeInfo = emojiHotPicSearchEmojiInfo.textComposeInfo;
        emotionSearchItem.mallEmojiInfo = emojiHotPicSearchEmojiInfo.mallEmojiInfo;
        return emotionSearchItem;
    }

    @NotNull
    public final EmotionSearchItem b(@NotNull HotPicInfo hotPicInfo) {
        Intrinsics.checkNotNullParameter(hotPicInfo, "hotPicInfo");
        EmotionSearchItem emotionSearchItem = new EmotionSearchItem();
        ThirdPartyInfo thirdPartyInfo = hotPicInfo.thirdPartyInfo;
        emotionSearchItem.appid = thirdPartyInfo.appId;
        emotionSearchItem.iconUrl = thirdPartyInfo.iconUrl;
        emotionSearchItem.name = thirdPartyInfo.name;
        emotionSearchItem.jumpUrl = thirdPartyInfo.jumpUrl;
        emotionSearchItem.url = hotPicInfo.thumbDownloadUrl;
        emotionSearchItem.md5 = hotPicInfo.thumbMd5;
        emotionSearchItem.fileSize = hotPicInfo.thumbFileSize;
        emotionSearchItem.width = hotPicInfo.thumbFileWidth;
        emotionSearchItem.height = hotPicInfo.thumbFileHeight;
        emotionSearchItem.originalMD5 = hotPicInfo.fileMd5;
        emotionSearchItem.oringinalSize = hotPicInfo.fileSize;
        emotionSearchItem.originalWidth = hotPicInfo.fileWidth;
        emotionSearchItem.originalHeight = hotPicInfo.fileHeight;
        emotionSearchItem.originalUrl = hotPicInfo.downloadUrl;
        emotionSearchItem.fileType = hotPicInfo.fileType;
        emotionSearchItem.picIndex = hotPicInfo.picIndex;
        emotionSearchItem.sourceType = hotPicInfo.sourceType;
        emotionSearchItem.filePath = hotPicInfo.path;
        emotionSearchItem.picId = hotPicInfo.picId;
        return emotionSearchItem;
    }
}
