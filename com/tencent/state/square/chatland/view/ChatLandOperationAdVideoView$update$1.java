package com.tencent.state.square.chatland.view;

import android.view.TextureView;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.template.data.OperationAd;
import com.tencent.state.template.data.OperationAdVideo;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ChatLandOperationAdVideoView$update$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ OperationAd $ad;
    final /* synthetic */ OperationAdVideo $info;
    final /* synthetic */ ChatLandOperationAdVideoView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatLandOperationAdVideoView$update$1(ChatLandOperationAdVideoView chatLandOperationAdVideoView, OperationAdVideo operationAdVideo, OperationAd operationAd) {
        super(0);
        this.this$0 = chatLandOperationAdVideoView;
        this.$info = operationAdVideo;
        this.$ad = operationAd;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        AdVideoPlayer adVideoPlayer;
        AdVideoPlayer adVideoPlayer2;
        TextureView textureView;
        TextureView textureView2;
        adVideoPlayer = this.this$0.player;
        if (adVideoPlayer == null) {
            textureView = this.this$0.view;
            if (textureView.getSurfaceTexture() != null) {
                ChatLandOperationAdVideoView chatLandOperationAdVideoView = this.this$0;
                textureView2 = this.this$0.view;
                chatLandOperationAdVideoView.player = new AdVideoPlayer(textureView2);
            }
        }
        adVideoPlayer2 = this.this$0.player;
        if (adVideoPlayer2 != null) {
            adVideoPlayer2.stopVideo();
            adVideoPlayer2.playVideo(this.$info.getUrl(), new Function0<Unit>() { // from class: com.tencent.state.square.chatland.view.ChatLandOperationAdVideoView$update$1$$special$$inlined$let$lambda$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ChatLandOperationAdVideoView$update$1.this.this$0.getListener().onPlayEnd();
                }
            });
        }
        this.this$0.updateVideoSize(this.$info);
        SquareBaseKt.getSquareReporter().reportEvent("imp", this.this$0, new LinkedHashMap());
        this.this$0.currentAd = this.$ad;
    }
}
