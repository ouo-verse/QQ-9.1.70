package com.tencent.mobileqq.guild.live.viewmodel;

import android.os.Bundle;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.config.z;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import fn0.GuildLiveAioMsgListWrap;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bR$\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u000fj\b\u0012\u0004\u0012\u00020\u0002`\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/live/viewmodel/d;", "Lcom/tencent/mobileqq/guild/live/viewmodel/a;", "Lfn0/c;", "", "init", "destroy", "", "event", "Landroid/os/Bundle;", "extra", HippyTKDListViewAdapter.X, "Lfn0/b;", "data", "L0", "Q1", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "i", "Ljava/util/ArrayList;", "registerAIOMsgList", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class d extends a implements fn0.c {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<fn0.c> registerAIOMsgList = new ArrayList<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/live/viewmodel/d$a;", "", "", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.live.viewmodel.d$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final boolean a() {
            ArrayList<String> a16 = z.a();
            String guildId = GLiveChannelCore.f226698a.s().getGuildId();
            Logger.f235387a.d().d("QGL.GLiveAIOMsgDispatchVM", 1, "[isEnableDanmu] whiteList " + a16 + ",  currentGuildId " + guildId);
            return a16.contains(guildId);
        }

        Companion() {
        }
    }

    @JvmStatic
    public static final boolean P1() {
        return INSTANCE.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R1(d this$0, int i3, Bundle bundle) {
        Bundle bundle2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator<fn0.c> it = this$0.registerAIOMsgList.iterator();
        while (it.hasNext()) {
            fn0.c next = it.next();
            if (bundle == null) {
                bundle2 = new Bundle();
            } else {
                bundle2 = bundle;
            }
            next.x(i3, bundle2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S1(d this$0, GuildLiveAioMsgListWrap data) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        Iterator<fn0.c> it = this$0.registerAIOMsgList.iterator();
        while (it.hasNext()) {
            it.next().L0(data);
        }
    }

    @Override // fn0.c
    public void L0(@NotNull final GuildLiveAioMsgListWrap data) {
        Intrinsics.checkNotNullParameter(data, "data");
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger.d().d("QGL.GLiveAIOMsgDispatchVM", 1, "[onReceiveAioMsg] size " + this.registerAIOMsgList.size() + " ");
        }
        if (this.registerAIOMsgList.isEmpty()) {
            return;
        }
        GLiveChannelCore.f226698a.l().b(new Runnable() { // from class: com.tencent.mobileqq.guild.live.viewmodel.c
            @Override // java.lang.Runnable
            public final void run() {
                d.S1(d.this, data);
            }
        }, 0L);
    }

    public final void Q1(final int event, @Nullable final Bundle extra) {
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger.d().d("QGL.GLiveAIOMsgDispatchVM", 1, "[notifyEvent] event " + event);
        }
        if (this.registerAIOMsgList.isEmpty()) {
            return;
        }
        GLiveChannelCore.f226698a.l().b(new Runnable() { // from class: com.tencent.mobileqq.guild.live.viewmodel.b
            @Override // java.lang.Runnable
            public final void run() {
                d.R1(d.this, event, extra);
            }
        }, 0L);
    }

    @Override // com.tencent.mobileqq.guild.live.viewmodel.a
    public void destroy() {
        super.destroy();
        Logger.f235387a.d().d("QGL.GLiveAIOMsgDispatchVM", 1, "[destroy] ");
        this.registerAIOMsgList.clear();
    }

    @Override // com.tencent.mobileqq.guild.live.viewmodel.a
    public void init() {
        super.init();
        boolean a16 = INSTANCE.a();
        Logger.f235387a.d().d("QGL.GLiveAIOMsgDispatchVM", 1, "[init] isEnableDanmu " + a16 + " ");
        if (a16) {
            GLiveDanmuLogicVM gLiveDanmuLogicVM = (GLiveDanmuLogicVM) GLiveChannelCore.f226698a.q(GLiveDanmuLogicVM.class);
            gLiveDanmuLogicVM.init();
            this.registerAIOMsgList.add(gLiveDanmuLogicVM);
        }
    }

    @Override // fn0.c
    public void x(int event, @NotNull Bundle extra) {
        Intrinsics.checkNotNullParameter(extra, "extra");
        Q1(event, extra);
    }
}
