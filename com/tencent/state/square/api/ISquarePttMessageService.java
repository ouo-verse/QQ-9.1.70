package com.tencent.state.square.api;

import cooperation.qqcircle.report.QCircleLpReportDc05507;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH&J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\u0017\u001a\u00020\u0003H&\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/state/square/api/ISquarePttMessageService;", "", "addAudioMessageListener", "", "listener", "Lcom/tencent/state/square/api/AudioMessageListener;", QCircleLpReportDc05507.KEY_CLEAR, "clearTargetUinMessage", "uin", "", "deleteAudioMessageListener", "destroy", "getLoudSpeakerState", "", "hasUnreadPttMessage", "init", "messageService", "Lcom/tencent/state/square/api/ISquareBaseMessageService;", "pause", "preLoadPttMessage", "unreadCount", "", "requestPlay", "updateSpeakPhone", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public interface ISquarePttMessageService {
    void addAudioMessageListener(@NotNull AudioMessageListener listener);

    void clear();

    void clearTargetUinMessage(@NotNull String uin);

    void deleteAudioMessageListener(@NotNull AudioMessageListener listener);

    void destroy();

    boolean getLoudSpeakerState();

    boolean hasUnreadPttMessage(@NotNull String uin);

    void init(@Nullable ISquareBaseMessageService messageService);

    void pause(@NotNull String uin);

    void preLoadPttMessage(@NotNull String uin, int unreadCount);

    void requestPlay(@NotNull String uin);

    void updateSpeakPhone();
}
