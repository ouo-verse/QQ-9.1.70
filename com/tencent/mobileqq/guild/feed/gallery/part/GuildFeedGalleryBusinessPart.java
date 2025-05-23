package com.tencent.mobileqq.guild.feed.gallery.part;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.PartIOCKt;
import com.tencent.mobileqq.guild.feed.event.GuildFeedGalleryCloseEvent;
import com.tencent.mobileqq.guild.feed.gallery.msgintent.FeedPublishFinishMsgResult;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedGalleryInitBean;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u001c\u0010\f\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J$\u0010\u0011\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\rj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e`\u0010H\u0016J\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0012H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/part/GuildFeedGalleryBusinessPart;", "Lcom/tencent/mobileqq/guild/feed/part/d;", "", "D9", "Lcom/tencent/mobileqq/guild/feed/gallery/msgintent/FeedPublishFinishMsgResult;", "event", "A9", "B9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "onReceiveEvent", "<init>", "()V", "d", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedGalleryBusinessPart extends com.tencent.mobileqq.guild.feed.part.d {
    /* JADX INFO: Access modifiers changed from: private */
    public final void A9(FeedPublishFinishMsgResult event) {
        String str;
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            GuildFeedGalleryInitBean initBean = event.getInitBean();
            if (initBean != null) {
                str = initBean.getFeedId();
            } else {
                str = null;
            }
            Log.d("Guild_Feed_GAL_GuildFeedGalleryBusinessPart", "[broadcastInitBeanChanged] initBean.feedId=" + str);
        }
        broadcastMessage("message_on_init_bean_changed", event.getInitBean());
    }

    private final void B9() {
        Logger.f235387a.d().d("Guild_Feed_GAL_GuildFeedGalleryBusinessPart", 1, "[finishActivityWithoutAnim] ");
        jk1.b.INSTANCE.a().c();
        getMainHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.gallery.part.c
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedGalleryBusinessPart.C9(GuildFeedGalleryBusinessPart.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C9(GuildFeedGalleryBusinessPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getPartHost().getHostActivity().onBackPressed();
    }

    private final void D9() {
        Flow callbackFlow;
        com.tencent.mvi.base.route.j jVar = (com.tencent.mvi.base.route.j) PartIOCKt.getIocInterface(this, com.tencent.mvi.base.route.j.class);
        if (jVar != null && (callbackFlow = FlowKt.callbackFlow(new GuildFeedGalleryBusinessPart$initObserver$$inlined$eventFlow$1(jVar, null))) != null) {
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
            Lifecycle.State state = Lifecycle.State.STARTED;
            Lifecycle lifecycle = lifecycleOwner.getLifecycle();
            Intrinsics.checkNotNullExpressionValue(lifecycle, "owner.lifecycle");
            LifecycleKt.getCoroutineScope(lifecycle).launchWhenCreated(new GuildFeedGalleryBusinessPart$initObserver$$inlined$collectIn$default$1(lifecycle, state, callbackFlow, null, this));
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<Object>> getEventClass() {
        ArrayList<Class<Object>> eventClass = super.getEventClass();
        if (eventClass == null) {
            eventClass = new ArrayList<>();
        }
        eventClass.add(GuildFeedGalleryCloseEvent.class);
        return eventClass;
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        D9();
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        super.onReceiveEvent(event);
        if (event instanceof GuildFeedGalleryCloseEvent) {
            B9();
        }
    }
}
