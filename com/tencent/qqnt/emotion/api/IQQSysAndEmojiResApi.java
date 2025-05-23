package com.tencent.qqnt.emotion.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import oa1.c;
import oa1.d;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/emotion/api/IQQSysAndEmojiResApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Loa1/d;", "getSystemAndEmojiConfBean", "Loa1/c;", "getExtAniStickerConfBean", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes24.dex */
public interface IQQSysAndEmojiResApi extends QRouteApi {
    @Nullable
    c getExtAniStickerConfBean();

    @Nullable
    d getSystemAndEmojiConfBean();
}
