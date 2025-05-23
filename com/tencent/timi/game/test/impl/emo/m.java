package com.tencent.timi.game.test.impl.emo;

import com.tencent.mobileqq.emoticonview.CameraEmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.IFavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "", "a", "timi-game-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class m {
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final String a(@NotNull EmoticonInfo emoticonInfo) {
        Intrinsics.checkNotNullParameter(emoticonInfo, "<this>");
        if (emoticonInfo instanceof SystemAndEmojiEmoticonInfo) {
            SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo) emoticonInfo;
            return "code:" + systemAndEmojiEmoticonInfo.code + ", emotionType:" + systemAndEmojiEmoticonInfo.emotionType + ", title:" + systemAndEmojiEmoticonInfo.title + ", isCommonUsed:$" + systemAndEmojiEmoticonInfo.isCommonUsed;
        }
        if (emoticonInfo instanceof IFavoriteEmoticonInfo) {
            IFavoriteEmoticonInfo iFavoriteEmoticonInfo = (IFavoriteEmoticonInfo) emoticonInfo;
            return " eId:" + iFavoriteEmoticonInfo.getEid() + ", path:" + iFavoriteEmoticonInfo.getPath() + ",url:" + iFavoriteEmoticonInfo.getUrl() + ",resID:" + iFavoriteEmoticonInfo.getResID();
        }
        if (emoticonInfo instanceof CameraEmoticonInfo) {
            CameraEmoticonInfo cameraEmoticonInfo = (CameraEmoticonInfo) emoticonInfo;
            return "contextKey:" + cameraEmoticonInfo.contextKey + ", thumbPath:" + cameraEmoticonInfo.thumbPath + ", templateId:" + cameraEmoticonInfo.templateId + ", eId:" + cameraEmoticonInfo.eId + ",path:" + cameraEmoticonInfo.path + ",url:" + cameraEmoticonInfo.url + ",resID:" + cameraEmoticonInfo.resID + ",roamingType:" + cameraEmoticonInfo.roamingType + ",";
        }
        return "";
    }
}
