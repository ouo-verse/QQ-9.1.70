package com.tencent.mobileqq.guild.mainframe.helper;

import android.os.Looper;
import android.os.MessageQueue;
import android.text.SpannableStringBuilder;
import androidx.fragment.app.FragmentManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListDataVM;
import com.tencent.guild.aio.msglist.text.util.TextBubbleContentParser;
import com.tencent.guild.api.appsetting.IQQSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.base.GuildToggles;
import com.tencent.mobileqq.guild.emoj.api.IQQGuildEmojiApi;
import com.tencent.mobileqq.guild.main.events.LoadStateEvent;
import com.tencent.mobileqq.guild.mainframe.k;
import com.tencent.mobileqq.guild.media.pic.api.IGuildPicAIO;
import com.tencent.mobileqq.guild.util.TraceUtils;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import java.util.Collections;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes14.dex */
public class i extends k implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<FragmentManager> f227435e;

    public i(com.tencent.mobileqq.guild.mainframe.i iVar) {
        super(iVar);
        this.f227435e = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean l() {
        TraceUtils.h("Guild.Misc.AioPreload1.");
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f227435e != null) {
            com.tencent.aio.main.engine.a.f69376a.c(com.tencent.guild.aio.factory.a.class.getName(), this.f227435e.get(), R.id.tub);
        }
        n();
        QLog.i("Guild.MF.GuildReloadAIOHelper", 1, "preload guild AIO cost: " + (System.currentTimeMillis() - currentTimeMillis));
        TraceUtils.k();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m() {
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.tencent.mobileqq.guild.mainframe.helper.h
            @Override // android.os.MessageQueue.IdleHandler
            public final boolean queueIdle() {
                boolean l3;
                l3 = i.this.l();
                return l3;
            }
        });
    }

    private void n() {
        ((IQQGuildEmojiApi) QRoute.api(IQQGuildEmojiApi.class)).serverToLocal(String.valueOf(10), 1);
        com.tencent.guild.aio.util.h.f112401a.c();
        com.tencent.guild.aio.component.publisher.d.a();
        ((IGuildPicAIO) QRoute.api(IGuildPicAIO.class)).getThumbSize(0L, 0L, true);
        TextBubbleContentParser.f111932a.b(null, new SpannableStringBuilder(), new MsgRecord());
        QLog.d("GuildMsgListRepo", 1, "preload class GuildMsgListRepo");
        new GuildMsgListDataVM();
    }

    private void o() {
        ((IQQGiftManager) QRoute.api(IQQGiftManager.class)).getSDKImpl(10010);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        q();
        o();
    }

    private void q() {
        try {
            TraceUtils.h("Guild.Misc.AioPreload2.");
            ((IQQSetting) QRoute.api(IQQSetting.class)).isEnterSendMsg();
            TraceUtils.k();
        } catch (Exception e16) {
            QLog.i("Guild.MF.GuildReloadAIOHelper", 1, "preloadQQSetting exception: " + e16.toString());
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        return new ArrayList<>(Collections.singletonList(LoadStateEvent.class));
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onCreate() {
        QLog.i("Guild.MF.GuildReloadAIOHelper", 1, "onCreate");
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onDestroy() {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (!GuildToggles.b() && (simpleBaseEvent instanceof LoadStateEvent)) {
            LoadStateEvent loadStateEvent = (LoadStateEvent) simpleBaseEvent;
            if (loadStateEvent.getState() == LoadStateEvent.LoadState.CHANNEL_LIST_VIEW_ITEM_READY) {
                QLog.d("Guild.MF.GuildReloadAIOHelper", 1, "onReceiveEvent: " + loadStateEvent);
                this.f227435e = new WeakReference<>(this.f227466d.getChildFragmentManager());
                ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.mainframe.helper.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        i.this.m();
                    }
                }, 1000L);
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.mainframe.helper.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        i.this.p();
                    }
                }, 16, null, true);
            }
        }
    }
}
