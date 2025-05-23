package com.tencent.state.square;

import com.tencent.state.square.api.AudioMessageListener;
import com.tencent.state.square.api.ISquareBaseMessageService;
import com.tencent.state.square.api.ISquarePttMessageService;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/state/square/DefaultSquarePttMessageService;", "Lcom/tencent/state/square/api/ISquarePttMessageService;", "()V", "addAudioMessageListener", "", "listener", "Lcom/tencent/state/square/api/AudioMessageListener;", QCircleLpReportDc05507.KEY_CLEAR, "clearTargetUinMessage", "uin", "", "deleteAudioMessageListener", "destroy", "getLoudSpeakerState", "", "hasUnreadPttMessage", "init", "messageService", "Lcom/tencent/state/square/api/ISquareBaseMessageService;", "pause", "preLoadPttMessage", "unreadCount", "", "requestPlay", "updateSpeakPhone", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final class DefaultSquarePttMessageService implements ISquarePttMessageService {
    @Override // com.tencent.state.square.api.ISquarePttMessageService
    public void addAudioMessageListener(@NotNull AudioMessageListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // com.tencent.state.square.api.ISquarePttMessageService
    public void clearTargetUinMessage(@NotNull String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
    }

    @Override // com.tencent.state.square.api.ISquarePttMessageService
    public void deleteAudioMessageListener(@NotNull AudioMessageListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // com.tencent.state.square.api.ISquarePttMessageService
    public boolean getLoudSpeakerState() {
        return false;
    }

    @Override // com.tencent.state.square.api.ISquarePttMessageService
    public boolean hasUnreadPttMessage(@NotNull String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return false;
    }

    @Override // com.tencent.state.square.api.ISquarePttMessageService
    public void pause(@NotNull String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
    }

    @Override // com.tencent.state.square.api.ISquarePttMessageService
    public void preLoadPttMessage(@NotNull String uin, int unreadCount) {
        Intrinsics.checkNotNullParameter(uin, "uin");
    }

    @Override // com.tencent.state.square.api.ISquarePttMessageService
    public void requestPlay(@NotNull String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
    }

    @Override // com.tencent.state.square.api.ISquarePttMessageService
    public void clear() {
    }

    @Override // com.tencent.state.square.api.ISquarePttMessageService
    public void destroy() {
    }

    @Override // com.tencent.state.square.api.ISquarePttMessageService
    public void updateSpeakPhone() {
    }

    @Override // com.tencent.state.square.api.ISquarePttMessageService
    public void init(@Nullable ISquareBaseMessageService messageService) {
    }
}
