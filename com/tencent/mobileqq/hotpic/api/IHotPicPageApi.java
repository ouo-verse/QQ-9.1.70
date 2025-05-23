package com.tencent.mobileqq.hotpic.api;

import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicSearchEmojiInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/hotpic/api/IHotPicPageApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "checkAndDownLoadHotPic", "", "hotPicData", "Lcom/tencent/mobileqq/hotpic/HotPicData;", "getHotPicDrawable", "Lcom/tencent/image/URLDrawable;", "searchInfoToSearchItem", "Lcom/tencent/mobileqq/emosm/emosearch/EmotionSearchItem;", "emojiInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/EmojiHotPicSearchEmojiInfo;", "qqemoticonpanel-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes9.dex */
public interface IHotPicPageApi extends QRouteApi {
    int checkAndDownLoadHotPic(@NotNull HotPicData hotPicData);

    @Nullable
    URLDrawable getHotPicDrawable(@NotNull HotPicData hotPicData);

    @NotNull
    EmotionSearchItem searchInfoToSearchItem(@NotNull EmojiHotPicSearchEmojiInfo emojiInfo);
}
