package com.tencent.mobileqq.emoticon.kernel;

import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.qqnt.kernel.nativeinterface.EmojiPanelCategory;
import com.tencent.qqnt.kernel.nativeinterface.SysEmoji;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/EmojiPanelCategory;", "emojiPanelCategory", "", "groupName", "Lcom/tencent/qqnt/kernel/nativeinterface/SysEmoji;", "sysEmoji", "Lcom/tencent/mobileqq/emoticon/QQSysAndEmojiResInfo$a;", "a", "emotionpanel_kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class j {
    @NotNull
    public static final QQSysAndEmojiResInfo.a a(@NotNull EmojiPanelCategory emojiPanelCategory, @NotNull String groupName, @NotNull SysEmoji sysEmoji) throws Throwable {
        int convertToLocal;
        String str;
        Intrinsics.checkNotNullParameter(emojiPanelCategory, "emojiPanelCategory");
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        Intrinsics.checkNotNullParameter(sysEmoji, "sysEmoji");
        QQSysAndEmojiResInfo.a aVar = new QQSysAndEmojiResInfo.a();
        aVar.QSid = sysEmoji.emojiId;
        aVar.QDes = sysEmoji.describe;
        aVar.QCid = String.valueOf(sysEmoji.qcid);
        int i3 = sysEmoji.qcid;
        if (i3 > 0) {
            convertToLocal = QQEmojiUtil.getEmojiLocalId(i3);
        } else {
            String str2 = aVar.QSid;
            Intrinsics.checkNotNullExpressionValue(str2, "this.QSid");
            convertToLocal = QQSysFaceUtil.convertToLocal(Integer.parseInt(str2));
        }
        aVar.AQLid = String.valueOf(convertToLocal);
        if (sysEmoji.isHide) {
            str = "1";
        } else {
            str = "0";
        }
        aVar.QHide = str;
        aVar.EMCode = sysEmoji.qzoneCode;
        aVar.AniStickerType = sysEmoji.emojiType.ordinal();
        aVar.AniStickerPackName = groupName;
        aVar.AniStickerPackId = String.valueOf(sysEmoji.aniStickerPackId);
        aVar.AniStickerId = String.valueOf(sysEmoji.aniStickerId);
        aVar.AniStickerWidth = String.valueOf(sysEmoji.animationWidth);
        aVar.AniStickerHeight = String.valueOf(sysEmoji.animationHeigh);
        if (sysEmoji.associateWords != null) {
            StringBuilder sb5 = new StringBuilder();
            int size = sysEmoji.associateWords.size();
            for (int i16 = 0; i16 < size; i16++) {
                String str3 = sysEmoji.associateWords.get(i16);
                if (i16 < sysEmoji.associateWords.size() - 1) {
                    sb5.append(str3);
                    sb5.append("|");
                } else {
                    sb5.append(str3);
                }
            }
            aVar.keywords = sb5.toString();
        }
        aVar.f204650a = sysEmoji.downloadInfo;
        aVar.f204651b = emojiPanelCategory;
        return aVar;
    }
}
