package com.tencent.mobileqq.guild.live.viewmodel;

import android.os.Bundle;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.live.danmu.dispatch.GuildLiveDanmuStore;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import fn0.GuildLiveAioMsgListWrap;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001.B\u0007\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u0011J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015J\u001e\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0019j\b\u0012\u0004\u0012\u00020\u001a`\u001b2\u0006\u0010\u0018\u001a\u00020\nR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010&\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/guild/live/viewmodel/GLiveDanmuLogicVM;", "Lcom/tencent/mobileqq/guild/live/viewmodel/a;", "Lfn0/c;", "", "R1", "destroy", "init", "Lfn0/b;", "data", "L0", "", "event", "Landroid/os/Bundle;", "extra", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/guild/live/danmu/dispatch/GuildLiveDanmuStore;", "O1", "Lcom/tencent/mobileqq/guild/live/danmu/dispatch/a;", "M1", "Ljava/lang/Runnable;", "runnable", "", "delay", "P1", "size", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/live/danmu/item/a;", "Lkotlin/collections/ArrayList;", "N1", "Lcom/tencent/mobileqq/guild/live/danmu/dispatch/d;", "i", "Lcom/tencent/mobileqq/guild/live/danmu/dispatch/d;", "danmuProducer", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/live/danmu/dispatch/a;", "danmuConsumer", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/live/danmu/dispatch/GuildLiveDanmuStore;", "danmuStore", "Ljava/util/Timer;", "D", "Ljava/util/Timer;", "msgGetTimer", "<init>", "()V", "E", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GLiveDanmuLogicVM extends a implements fn0.c {

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Timer msgGetTimer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.live.danmu.dispatch.d danmuProducer = new com.tencent.mobileqq.guild.live.danmu.dispatch.d(this);

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.live.danmu.dispatch.a danmuConsumer = new com.tencent.mobileqq.guild.live.danmu.dispatch.a(this);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final GuildLiveDanmuStore danmuStore = new GuildLiveDanmuStore(this);

    public static /* synthetic */ void Q1(GLiveDanmuLogicVM gLiveDanmuLogicVM, Runnable runnable, long j3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j3 = 0;
        }
        gLiveDanmuLogicVM.P1(runnable, j3);
    }

    private final void R1() {
        Timer timer = this.msgGetTimer;
        if (timer != null) {
            Intrinsics.checkNotNull(timer);
            timer.cancel();
        }
        BaseTimer baseTimer = new BaseTimer();
        this.msgGetTimer = baseTimer;
        Intrinsics.checkNotNull(baseTimer);
        baseTimer.schedule(new TimerTask() { // from class: com.tencent.mobileqq.guild.live.viewmodel.GLiveDanmuLogicVM$startMsgTimeConsume$1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                for (com.tencent.mobileqq.guild.live.danmu.item.a aVar : GLiveDanmuLogicVM.this.N1(5)) {
                    QLog.d("QGL.GLiveDanmuLogicVM", 1, "schedule viewType: " + aVar.b() + ", seq " + aVar.e());
                    GLiveChannelCore.f226698a.j().a(aVar.b(), aVar);
                }
            }
        }, 0L, 2000L);
    }

    @Override // fn0.c
    public void L0(@NotNull GuildLiveAioMsgListWrap data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.danmuProducer.L0(data);
    }

    @NotNull
    /* renamed from: M1, reason: from getter */
    public final com.tencent.mobileqq.guild.live.danmu.dispatch.a getDanmuConsumer() {
        return this.danmuConsumer;
    }

    @NotNull
    public final ArrayList<com.tencent.mobileqq.guild.live.danmu.item.a> N1(int size) {
        ArrayList<com.tencent.mobileqq.guild.live.danmu.item.a> a16 = getDanmuConsumer().a(size);
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger.d().d("QGL.GLiveDanmuLogicVM", 1, "[getDanmuItemList] size " + size + ", final size " + a16.size());
        }
        return a16;
    }

    @NotNull
    /* renamed from: O1, reason: from getter */
    public final GuildLiveDanmuStore getDanmuStore() {
        return this.danmuStore;
    }

    public final void P1(@NotNull Runnable runnable, long delay) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        GLiveChannelCore.f226698a.l().b(runnable, delay);
    }

    @Override // com.tencent.mobileqq.guild.live.viewmodel.a
    public void destroy() {
        super.destroy();
        Logger.f235387a.d().d("QGL.GLiveDanmuLogicVM", 1, "[destroy] ");
        this.danmuProducer.c();
        this.danmuStore.a();
        Timer timer = this.msgGetTimer;
        if (timer != null) {
            timer.cancel();
        }
        this.msgGetTimer = null;
    }

    @Override // com.tencent.mobileqq.guild.live.viewmodel.a
    public void init() {
        super.init();
        Logger.f235387a.d().d("QGL.GLiveDanmuLogicVM", 1, "[init] ");
        this.danmuProducer.d();
        if (d.INSTANCE.a()) {
            R1();
        }
    }

    @Override // fn0.c
    public void x(int event, @NotNull Bundle extra) {
        Intrinsics.checkNotNullParameter(extra, "extra");
        this.danmuProducer.x(event, extra);
    }
}
