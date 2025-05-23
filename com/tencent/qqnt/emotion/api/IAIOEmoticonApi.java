package com.tencent.qqnt.emotion.api;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H&J$\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H&J\u0018\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/emotion/api/IAIOEmoticonApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "convertToLocal", "", "serverId", "emojiType", "convertToServer", "localId", "getEmojiDrawable", "Landroid/graphics/drawable/Drawable;", "isDynamicType", "", "isDynamicResReady", "isEmoReady", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes24.dex */
public interface IAIOEmoticonApi extends QRouteApi {
    int convertToLocal(int serverId, int emojiType);

    int convertToServer(int localId, int emojiType);

    @Nullable
    Drawable getEmojiDrawable(int localId, int emojiType, boolean isDynamicType);

    boolean isDynamicResReady(int localId, int emojiType);

    boolean isEmoReady(int localId, int emojiType);
}
