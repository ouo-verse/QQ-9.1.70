package com.tencent.mobileqq.guild.home.parts;

import android.app.Activity;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.guild.event.GuildBehaviorUpdateListenerEvent;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000b0\nH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/home/parts/ch;", "Lcom/tencent/mobileqq/guild/home/parts/a;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "onPartDestroy", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "<init>", "()V", "e", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class ch extends a implements SimpleEventReceiver<SimpleBaseEvent> {
    public ch() {
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GuildBehaviorUpdateListenerEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.NewHome.subFrag.GuildSubFragmentDragEventPart", 1, "onReceiveEvent " + event);
        }
        if (event instanceof GuildBehaviorUpdateListenerEvent) {
            GuildBehaviorUpdateListenerEvent guildBehaviorUpdateListenerEvent = (GuildBehaviorUpdateListenerEvent) event;
            if (!guildBehaviorUpdateListenerEvent.isAdd()) {
                A9().C(guildBehaviorUpdateListenerEvent.getListener());
            } else {
                if (!Intrinsics.areEqual(guildBehaviorUpdateListenerEvent.getGuildId(), z9().f227656e) || guildBehaviorUpdateListenerEvent.getActivityId() != System.identityHashCode(x9())) {
                    return;
                }
                A9().h(guildBehaviorUpdateListenerEvent.getListener());
            }
        }
    }
}
