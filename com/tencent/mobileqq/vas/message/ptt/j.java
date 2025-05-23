package com.tencent.mobileqq.vas.message.ptt;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.state.square.api.AudioMessageListener;
import com.tencent.state.square.api.ISquareBaseMessageService;
import com.tencent.state.square.api.ISquarePttMessageService;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/vas/message/ptt/j;", "Lcom/tencent/state/square/api/ISquarePttMessageService;", "Lcom/tencent/state/square/api/ISquareBaseMessageService;", "messageService", "", "init", "", "uin", "requestPlay", "updateSpeakPhone", "", "getLoudSpeakerState", "hasUnreadPttMessage", "pause", "", "unreadCount", "preLoadPttMessage", "Lcom/tencent/state/square/api/AudioMessageListener;", "listener", "addAudioMessageListener", "deleteAudioMessageListener", QCircleLpReportDc05507.KEY_CLEAR, "clearTargetUinMessage", "destroy", "Lcom/tencent/mobileqq/vas/message/ptt/SquareAudioPlayerManager;", "a", "Lcom/tencent/mobileqq/vas/message/ptt/SquareAudioPlayerManager;", "squareAudioPlayerManager", "<init>", "()V", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class j implements ISquarePttMessageService {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final SquareAudioPlayerManager squareAudioPlayerManager = new SquareAudioPlayerManager();

    @Override // com.tencent.state.square.api.ISquarePttMessageService
    public void addAudioMessageListener(AudioMessageListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.squareAudioPlayerManager.q(listener);
    }

    @Override // com.tencent.state.square.api.ISquarePttMessageService
    public void clear() {
        this.squareAudioPlayerManager.r();
    }

    @Override // com.tencent.state.square.api.ISquarePttMessageService
    public void clearTargetUinMessage(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.squareAudioPlayerManager.s(uin);
    }

    @Override // com.tencent.state.square.api.ISquarePttMessageService
    public void deleteAudioMessageListener(AudioMessageListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.squareAudioPlayerManager.t(listener);
    }

    @Override // com.tencent.state.square.api.ISquarePttMessageService
    public void destroy() {
        this.squareAudioPlayerManager.u();
    }

    @Override // com.tencent.state.square.api.ISquarePttMessageService
    public boolean getLoudSpeakerState() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        return com.tencent.mobileqq.qqaudio.audioplayer.c.b(runtime instanceof QQAppInterface ? (QQAppInterface) runtime : null);
    }

    @Override // com.tencent.state.square.api.ISquarePttMessageService
    public boolean hasUnreadPttMessage(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return this.squareAudioPlayerManager.x(uin);
    }

    @Override // com.tencent.state.square.api.ISquarePttMessageService
    public void init(ISquareBaseMessageService messageService) {
        this.squareAudioPlayerManager.y(messageService);
    }

    @Override // com.tencent.state.square.api.ISquarePttMessageService
    public void pause(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.squareAudioPlayerManager.v(uin);
    }

    @Override // com.tencent.state.square.api.ISquarePttMessageService
    public void preLoadPttMessage(String uin, int unreadCount) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.squareAudioPlayerManager.R(uin, unreadCount);
    }

    @Override // com.tencent.state.square.api.ISquarePttMessageService
    public void requestPlay(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.squareAudioPlayerManager.S(uin);
    }

    @Override // com.tencent.state.square.api.ISquarePttMessageService
    public void updateSpeakPhone() {
        this.squareAudioPlayerManager.X();
    }
}
