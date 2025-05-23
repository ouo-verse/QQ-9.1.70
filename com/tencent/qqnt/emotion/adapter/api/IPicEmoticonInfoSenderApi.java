package com.tencent.qqnt.emotion.adapter.api;

import android.content.Context;
import android.os.Parcelable;
import android.widget.EditText;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticon.StickerInfo;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J:\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH&JH\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H&J.\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0014\u001a\u00020\u0015H&\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/emotion/adapter/api/IPicEmoticonInfoSenderApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "send", "", "runtime", "Lmqq/app/AppRuntime;", "context", "Landroid/content/Context;", "sessionInfoParcelable", "Landroid/os/Parcelable;", "emoticon", "Lcom/tencent/mobileqq/data/Emoticon;", "stickerInfo", "Lcom/tencent/mobileqq/emoticon/StickerInfo;", "input", "Landroid/widget/EditText;", "isFroward", "", "forwardID", "", "picEmoticonInfo", "Lcom/tencent/mobileqq/emoticonview/PicEmoticonInfo;", "sendFromGuild", "app", "sessionInfo", "emotion_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes24.dex */
public interface IPicEmoticonInfoSenderApi extends QRouteApi {
    void send(@Nullable AppRuntime runtime, @Nullable Context context, @Nullable Parcelable sessionInfoParcelable, @Nullable Emoticon emoticon, @Nullable StickerInfo stickerInfo);

    void send(@Nullable AppRuntime runtime, @Nullable Context context, @Nullable EditText input, @Nullable Parcelable sessionInfoParcelable, boolean isFroward, int forwardID, @NotNull PicEmoticonInfo picEmoticonInfo);

    void sendFromGuild(@Nullable AppRuntime app, @Nullable Context context, @Nullable Parcelable sessionInfo, @NotNull PicEmoticonInfo picEmoticonInfo);
}
