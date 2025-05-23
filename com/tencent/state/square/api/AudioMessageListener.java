package com.tencent.state.square.api;

import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/state/square/api/AudioMessageListener;", "", "onComplete", "", "uin", "", "onInterrupt", "onNewMessagePlay", "message", "Lcom/tencent/state/square/api/PttMessage;", "onPlayError", "onPlayPause", HippyQQPagView.EventName.ON_PLAY_START, "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public interface AudioMessageListener {
    void onComplete(@NotNull String uin);

    void onInterrupt(@NotNull String uin);

    void onNewMessagePlay(@NotNull PttMessage message);

    void onPlayError(@NotNull String uin);

    void onPlayPause(@NotNull String uin);

    void onPlayStart(@NotNull String uin);
}
