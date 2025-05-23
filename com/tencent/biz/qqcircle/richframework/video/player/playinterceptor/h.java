package com.tencent.biz.qqcircle.richframework.video.player.playinterceptor;

import com.tencent.biz.qqcircle.immersive.part.window.QQLiveRemoteFloatWindowHelper;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC;
import com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerUpperData;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor;
import com.tencent.mobileqq.qcircle.api.event.QCircleVolumeMuteChangeEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerOption;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001a2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010\u0013\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00110\u0010j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0011`\u0012H\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/biz/qqcircle/richframework/video/player/playinterceptor/h;", "Lcom/tencent/biz/richframework/video/rfw/player/playinterceptor/RFWPlayerBaseInterceptor;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "b", "Lcom/tencent/superplayer/api/SuperPlayerOption;", "superPlayerOption", "Lcom/tencent/superplayer/api/ISuperPlayer;", "superPlayer", "afterOpenMedia", "", "releaseSource", "onRelease", "simpleBaseEvent", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/biz/qqcircle/immersive/part/window/QQLiveRemoteFloatWindowHelper$a;", "d", "Lcom/tencent/biz/qqcircle/immersive/part/window/QQLiveRemoteFloatWindowHelper$a;", "floatStatusChangeListener", "<init>", "()V", "e", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class h extends RFWPlayerBaseInterceptor implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QQLiveRemoteFloatWindowHelper.a floatStatusChangeListener = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/biz/qqcircle/richframework/video/player/playinterceptor/h$a;", "", "", "a", "", "MUTE_KEY", "Ljava/lang/String;", "TAG", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.richframework.video.player.playinterceptor.h$a, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            boolean z16;
            boolean h16 = QQLiveRemoteFloatWindowHelper.f88336d.h();
            boolean b16 = tb0.a.f435779d.b();
            if (!h16 && !b16) {
                z16 = false;
            } else {
                z16 = true;
            }
            QLog.d("QFSPlayerPlayMuteInterceptor", 1, "needMute " + z16 + " ,remoteAudienceFloatWindowShow " + h16 + " ,volumeControllerMute " + b16);
            return z16;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/biz/qqcircle/richframework/video/player/playinterceptor/h$b", "Lcom/tencent/biz/qqcircle/immersive/part/window/QQLiveRemoteFloatWindowHelper$a;", "", "isAudienceFloatWindowShow", "", "changed", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class b implements QQLiveRemoteFloatWindowHelper.a {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.part.window.QQLiveRemoteFloatWindowHelper.a
        public void changed(boolean isAudienceFloatWindowShow) {
            h.this.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b() {
        boolean a16 = INSTANCE.a();
        RFWPlayer rFWPlayer = this.mPlayer;
        if (rFWPlayer != null) {
            rFWPlayer.setOutputMute(a16);
        }
        QLog.d(getTag(), 1, "[tryMutePlayer] mute:" + a16);
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void afterOpenMedia(@NotNull SuperPlayerOption superPlayerOption, @NotNull ISuperPlayer superPlayer) {
        Object obj;
        RFWPlayerIOC ioc;
        RFWPlayerUpperData upperData;
        Intrinsics.checkNotNullParameter(superPlayerOption, "superPlayerOption");
        Intrinsics.checkNotNullParameter(superPlayer, "superPlayer");
        super.afterOpenMedia(superPlayerOption, superPlayer);
        if (!uq3.c.y0()) {
            QLog.d(getTag(), 1, "not enable mute interceptor");
            return;
        }
        RFWPlayerOptions options = getOptions();
        if (options != null && (ioc = options.getIOC()) != null && (upperData = ioc.getUpperData()) != null) {
            obj = upperData.getValue("QFS_PLAYER_MUTE_KEY");
        } else {
            obj = null;
        }
        if (obj == null) {
            obj = Boolean.TRUE;
        }
        if ((obj instanceof Boolean) && !((Boolean) obj).booleanValue()) {
            QLog.d(getTag(), 1, "business request not use mute interceptor");
            return;
        }
        b();
        SimpleEventBus.getInstance().registerReceiver(this);
        QQLiveRemoteFloatWindowHelper.f88336d.b(this.floatStatusChangeListener);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(QCircleVolumeMuteChangeEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCircleVolumeMuteChangeEvent) {
            b();
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onRelease(int releaseSource) {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        QQLiveRemoteFloatWindowHelper.f88336d.j(this.floatStatusChangeListener);
    }
}
