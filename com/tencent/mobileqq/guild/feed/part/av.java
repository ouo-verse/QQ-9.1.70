package com.tencent.mobileqq.guild.feed.part;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.util.Supplier;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.mobileqq.guild.feed.event.GuildFeedDeleteEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedGalleryShareViewEvent;
import com.tencent.mobileqq.guild.feed.morepanel.cooperate.TroopFeedMorePanelCooperateHelper;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.GProStFeedDetailRspWrapper;
import com.tencent.mobileqq.guild.feed.publish.event.GuildFeedMoveEvent2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import zp1.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 (2\u00020\u0001:\u0001)B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0006\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001c\u0010\r\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0013H\u0016J$\u0010\u0018\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0016\u0018\u00010\u0015j\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0016\u0018\u0001`\u0017H\u0016R\u0014\u0010\u001b\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010!\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u001aR\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/part/av;", "Lcom/tencent/mobileqq/guild/feed/part/f;", "Lcom/tencent/mobileqq/guild/feed/event/GuildFeedGalleryShareViewEvent;", "event", "", "D9", "", "eventFeedId", "C9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "action", "", "args", "handleBroadcastMessage", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", tl.h.F, "Ljava/lang/String;", "troopUin", "", "i", "Z", "isPartDestroyed", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "servedFeedId", "Lcom/tencent/mobileqq/guild/feed/morepanel/cooperate/TroopFeedMorePanelCooperateHelper;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/feed/morepanel/cooperate/TroopFeedMorePanelCooperateHelper;", "morePanelCooperateHelper", "<init>", "(Ljava/lang/String;)V", "D", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class av extends f {

    /* renamed from: C, reason: from kotlin metadata */
    private TroopFeedMorePanelCooperateHelper morePanelCooperateHelper;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isPartDestroyed;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String servedFeedId;

    public av(@NotNull String troopUin) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        this.troopUin = troopUin;
    }

    private final void C9(String eventFeedId) {
        Activity activity;
        if (TextUtils.equals(this.servedFeedId, eventFeedId) && !this.isPartDestroyed && (activity = getActivity()) != null) {
            activity.onBackPressed();
        }
    }

    private final void D9(GuildFeedGalleryShareViewEvent event) {
        GProStFeed feed = event.getGalleryShareInfo().c();
        this.servedFeedId = feed.idd;
        Intrinsics.checkNotNullExpressionValue(feed, "feed");
        GProStFeedDetailRspWrapper gProStFeedDetailRspWrapper = new GProStFeedDetailRspWrapper(feed, event.getGalleryShareInfo().f());
        TroopFeedMorePanelCooperateHelper troopFeedMorePanelCooperateHelper = this.morePanelCooperateHelper;
        if (troopFeedMorePanelCooperateHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("morePanelCooperateHelper");
            troopFeedMorePanelCooperateHelper = null;
        }
        a.C11708a.a(troopFeedMorePanelCooperateHelper, -1, gProStFeedDetailRspWrapper, new Supplier() { // from class: com.tencent.mobileqq.guild.feed.part.au
            @Override // androidx.core.util.Supplier
            public final Object get() {
                Map E9;
                E9 = av.E9();
                return E9;
            }
        }, 0, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map E9() {
        Map emptyMap;
        emptyMap = MapsKt__MapsKt.emptyMap();
        return emptyMap;
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @Nullable
    public ArrayList<Class<?>> getEventClass() {
        ArrayList<Class<?>> eventClass = super.getEventClass();
        eventClass.add(GuildFeedGalleryShareViewEvent.class);
        eventClass.add(GuildFeedDeleteEvent.class);
        eventClass.add(GuildFeedMoveEvent2.class);
        return eventClass;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@NotNull String action, @Nullable Object args) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (Intrinsics.areEqual("message_on_page_select", action) && (args instanceof jk1.a)) {
            this.servedFeedId = ((jk1.a) args).b().idd;
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.part.f, com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        TroopFeedMorePanelCooperateHelper troopFeedMorePanelCooperateHelper = new TroopFeedMorePanelCooperateHelper(this, this.troopUin, true);
        getPartHost().getLifecycleOwner().getLifecycle().addObserver(troopFeedMorePanelCooperateHelper);
        this.morePanelCooperateHelper = troopFeedMorePanelCooperateHelper;
        RFWIocAbilityProvider g16 = RFWIocAbilityProvider.g();
        View partRootView = getPartRootView();
        TroopFeedMorePanelCooperateHelper troopFeedMorePanelCooperateHelper2 = this.morePanelCooperateHelper;
        TroopFeedMorePanelCooperateHelper troopFeedMorePanelCooperateHelper3 = null;
        if (troopFeedMorePanelCooperateHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("morePanelCooperateHelper");
            troopFeedMorePanelCooperateHelper2 = null;
        }
        g16.registerIoc(partRootView, troopFeedMorePanelCooperateHelper2, zp1.a.class);
        TroopFeedMorePanelCooperateHelper troopFeedMorePanelCooperateHelper4 = this.morePanelCooperateHelper;
        if (troopFeedMorePanelCooperateHelper4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("morePanelCooperateHelper");
        } else {
            troopFeedMorePanelCooperateHelper3 = troopFeedMorePanelCooperateHelper4;
        }
        troopFeedMorePanelCooperateHelper3.r();
    }

    @Override // com.tencent.mobileqq.guild.feed.part.f, com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        this.isPartDestroyed = true;
        TroopFeedMorePanelCooperateHelper troopFeedMorePanelCooperateHelper = this.morePanelCooperateHelper;
        if (troopFeedMorePanelCooperateHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("morePanelCooperateHelper");
            troopFeedMorePanelCooperateHelper = null;
        }
        troopFeedMorePanelCooperateHelper.onDestroy();
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        QLog.d("GuildTroopFeedGallerySharePart", 1, "onReceiveEvent_event:", event);
        super.onReceiveEvent(event);
        if (event instanceof GuildFeedGalleryShareViewEvent) {
            D9((GuildFeedGalleryShareViewEvent) event);
            return;
        }
        if (event instanceof GuildFeedDeleteEvent) {
            String feedId = ((GuildFeedDeleteEvent) event).getFeedId();
            Intrinsics.checkNotNullExpressionValue(feedId, "event.feedId");
            C9(feedId);
        } else if (event instanceof GuildFeedMoveEvent2) {
            C9(((GuildFeedMoveEvent2) event).getFeedId());
        }
    }
}
