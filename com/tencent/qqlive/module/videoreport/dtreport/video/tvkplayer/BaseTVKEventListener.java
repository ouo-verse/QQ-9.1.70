package com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer;

import com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class BaseTVKEventListener implements ITVKPlayerEventListener {
    private final Map<ITVKPlayerEventListener.PlayerEvent, MessageExecutor> mMessageHandler = new HashMap();

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface MessageExecutor {
        void execute(ITVKMediaPlayer iTVKMediaPlayer, ITVKPlayerEventListener.EventParams eventParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements MessageExecutor {
        a() {
        }

        @Override // com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.BaseTVKEventListener.MessageExecutor
        public void execute(ITVKMediaPlayer iTVKMediaPlayer, ITVKPlayerEventListener.EventParams eventParams) {
            BaseTVKEventListener.this.handleADPrepared(iTVKMediaPlayer, eventParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b implements MessageExecutor {
        b() {
        }

        @Override // com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.BaseTVKEventListener.MessageExecutor
        public void execute(ITVKMediaPlayer iTVKMediaPlayer, ITVKPlayerEventListener.EventParams eventParams) {
            BaseTVKEventListener.this.handleADPlay(iTVKMediaPlayer, eventParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class c implements MessageExecutor {
        c() {
        }

        @Override // com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.BaseTVKEventListener.MessageExecutor
        public void execute(ITVKMediaPlayer iTVKMediaPlayer, ITVKPlayerEventListener.EventParams eventParams) {
            BaseTVKEventListener.this.handleADPause(iTVKMediaPlayer, eventParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class d implements MessageExecutor {
        d() {
        }

        @Override // com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.BaseTVKEventListener.MessageExecutor
        public void execute(ITVKMediaPlayer iTVKMediaPlayer, ITVKPlayerEventListener.EventParams eventParams) {
            BaseTVKEventListener.this.handleADStop(iTVKMediaPlayer, eventParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class e implements MessageExecutor {
        e() {
        }

        @Override // com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.BaseTVKEventListener.MessageExecutor
        public void execute(ITVKMediaPlayer iTVKMediaPlayer, ITVKPlayerEventListener.EventParams eventParams) {
            BaseTVKEventListener.this.handleOpenMedia(iTVKMediaPlayer, eventParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class f implements MessageExecutor {
        f() {
        }

        @Override // com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.BaseTVKEventListener.MessageExecutor
        public void execute(ITVKMediaPlayer iTVKMediaPlayer, ITVKPlayerEventListener.EventParams eventParams) {
            BaseTVKEventListener.this.handleNetVideoInfo(iTVKMediaPlayer, eventParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class g implements MessageExecutor {
        g() {
        }

        @Override // com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.BaseTVKEventListener.MessageExecutor
        public void execute(ITVKMediaPlayer iTVKMediaPlayer, ITVKPlayerEventListener.EventParams eventParams) {
            BaseTVKEventListener.this.handleUpdateReportParam(iTVKMediaPlayer, eventParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class h implements MessageExecutor {
        h() {
        }

        @Override // com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.BaseTVKEventListener.MessageExecutor
        public void execute(ITVKMediaPlayer iTVKMediaPlayer, ITVKPlayerEventListener.EventParams eventParams) {
            BaseTVKEventListener.this.handleVideoPreparing(iTVKMediaPlayer, eventParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class i implements MessageExecutor {
        i() {
        }

        @Override // com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.BaseTVKEventListener.MessageExecutor
        public void execute(ITVKMediaPlayer iTVKMediaPlayer, ITVKPlayerEventListener.EventParams eventParams) {
            BaseTVKEventListener.this.handleVideoPrepared(iTVKMediaPlayer, eventParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class j implements MessageExecutor {
        j() {
        }

        @Override // com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.BaseTVKEventListener.MessageExecutor
        public void execute(ITVKMediaPlayer iTVKMediaPlayer, ITVKPlayerEventListener.EventParams eventParams) {
            BaseTVKEventListener.this.handleVideoPlay(iTVKMediaPlayer, eventParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class k implements MessageExecutor {
        k() {
        }

        @Override // com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.BaseTVKEventListener.MessageExecutor
        public void execute(ITVKMediaPlayer iTVKMediaPlayer, ITVKPlayerEventListener.EventParams eventParams) {
            BaseTVKEventListener.this.handleVideoPause(iTVKMediaPlayer, eventParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class l implements MessageExecutor {
        l() {
        }

        @Override // com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.BaseTVKEventListener.MessageExecutor
        public void execute(ITVKMediaPlayer iTVKMediaPlayer, ITVKPlayerEventListener.EventParams eventParams) {
            BaseTVKEventListener.this.handleVideoStop(iTVKMediaPlayer, eventParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class m implements MessageExecutor {
        m() {
        }

        @Override // com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.BaseTVKEventListener.MessageExecutor
        public void execute(ITVKMediaPlayer iTVKMediaPlayer, ITVKPlayerEventListener.EventParams eventParams) {
            BaseTVKEventListener.this.handleADPreparing(iTVKMediaPlayer, eventParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseTVKEventListener() {
        msgFunctionInit();
    }

    private void msgFunctionInit() {
        this.mMessageHandler.put(ITVKPlayerEventListener.PlayerEvent.PLAYER_EVENT_OPEN_MEDIA, new e());
        this.mMessageHandler.put(ITVKPlayerEventListener.PlayerEvent.PLAYER_EVENT_CGI_RECEIVED, new f());
        this.mMessageHandler.put(ITVKPlayerEventListener.PlayerEvent.PLAYER_EVENT_UPDATE_REPORT_PARAM, new g());
        this.mMessageHandler.put(ITVKPlayerEventListener.PlayerEvent.PLAYER_EVENT_VIDEO_PREPARING, new h());
        this.mMessageHandler.put(ITVKPlayerEventListener.PlayerEvent.PLAYER_EVENT_VIDEO_PREPARED, new i());
        this.mMessageHandler.put(ITVKPlayerEventListener.PlayerEvent.PLAYER_EVENT_VIDEO_PLAYING, new j());
        this.mMessageHandler.put(ITVKPlayerEventListener.PlayerEvent.PLAYER_EVENT_VIDEO_PAUSED, new k());
        this.mMessageHandler.put(ITVKPlayerEventListener.PlayerEvent.PLAYER_EVENT_VIDEO_STOPED, new l());
        this.mMessageHandler.put(ITVKPlayerEventListener.PlayerEvent.PLAYER_EVENT_AD_PREPARING, new m());
        this.mMessageHandler.put(ITVKPlayerEventListener.PlayerEvent.PLAYER_EVENT_AD_PREPARED, new a());
        this.mMessageHandler.put(ITVKPlayerEventListener.PlayerEvent.PLAYER_EVENT_AD_PLAYING, new b());
        this.mMessageHandler.put(ITVKPlayerEventListener.PlayerEvent.PLAYER_EVENT_AD_PAUSED, new c());
        this.mMessageHandler.put(ITVKPlayerEventListener.PlayerEvent.PLAYER_EVENT_AD_STOPED, new d());
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener
    public void onPlayerEvent(ITVKMediaPlayer iTVKMediaPlayer, ITVKPlayerEventListener.PlayerEvent playerEvent, ITVKPlayerEventListener.EventParams eventParams) {
        MessageExecutor messageExecutor = this.mMessageHandler.get(playerEvent);
        if (messageExecutor != null) {
            messageExecutor.execute(iTVKMediaPlayer, eventParams);
        }
    }

    protected void handleADPause(ITVKMediaPlayer iTVKMediaPlayer, ITVKPlayerEventListener.EventParams eventParams) {
    }

    protected void handleADPlay(ITVKMediaPlayer iTVKMediaPlayer, ITVKPlayerEventListener.EventParams eventParams) {
    }

    protected void handleADPrepared(ITVKMediaPlayer iTVKMediaPlayer, ITVKPlayerEventListener.EventParams eventParams) {
    }

    protected void handleADPreparing(ITVKMediaPlayer iTVKMediaPlayer, ITVKPlayerEventListener.EventParams eventParams) {
    }

    protected void handleADStop(ITVKMediaPlayer iTVKMediaPlayer, ITVKPlayerEventListener.EventParams eventParams) {
    }

    protected void handleNetVideoInfo(ITVKMediaPlayer iTVKMediaPlayer, ITVKPlayerEventListener.EventParams eventParams) {
    }

    protected void handleOpenMedia(ITVKMediaPlayer iTVKMediaPlayer, ITVKPlayerEventListener.EventParams eventParams) {
    }

    protected void handleUpdateReportParam(ITVKMediaPlayer iTVKMediaPlayer, ITVKPlayerEventListener.EventParams eventParams) {
    }

    protected void handleVideoPause(ITVKMediaPlayer iTVKMediaPlayer, ITVKPlayerEventListener.EventParams eventParams) {
    }

    protected void handleVideoPlay(ITVKMediaPlayer iTVKMediaPlayer, ITVKPlayerEventListener.EventParams eventParams) {
    }

    protected void handleVideoPrepared(ITVKMediaPlayer iTVKMediaPlayer, ITVKPlayerEventListener.EventParams eventParams) {
    }

    protected void handleVideoPreparing(ITVKMediaPlayer iTVKMediaPlayer, ITVKPlayerEventListener.EventParams eventParams) {
    }

    protected void handleVideoStop(ITVKMediaPlayer iTVKMediaPlayer, ITVKPlayerEventListener.EventParams eventParams) {
    }
}
