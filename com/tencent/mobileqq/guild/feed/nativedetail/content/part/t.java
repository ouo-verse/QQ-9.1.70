package com.tencent.mobileqq.guild.feed.nativedetail.content.part;

import android.app.Activity;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.event.GuildFeedDetailLikeEvent;
import com.tencent.mobileqq.guild.feed.gallery.widget.GuildFeedDoublePraiseView;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ#\u0010\b\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0012\u0010\u0010\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0013\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J$\u0010\u0017\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00150\u0014j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0015`\u0016H\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/part/t;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/guild/feed/event/GuildFeedDetailLikeEvent;", "", "positionX", "positionY", "", "z9", "(Ljava/lang/Float;Ljava/lang/Float;)V", "x9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/mobileqq/guild/feed/gallery/widget/GuildFeedDoublePraiseView;", "d", "Lcom/tencent/mobileqq/guild/feed/gallery/widget/GuildFeedDoublePraiseView;", "mAnimationView", "<init>", "()V", "e", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class t extends Part implements SimpleEventReceiver<GuildFeedDetailLikeEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildFeedDoublePraiseView mAnimationView;

    private final void x9() {
        broadcastMessage("message_on_do_execute_like", null);
    }

    private final void z9(Float positionX, Float positionY) {
        if (this.mAnimationView == null) {
            this.mAnimationView = (GuildFeedDoublePraiseView) getPartRootView().findViewById(R.id.wge);
        }
        if (positionY != null) {
            float floatValue = positionY.floatValue();
            if (positionX != null) {
                float floatValue2 = positionX.floatValue();
                GuildFeedDoublePraiseView guildFeedDoublePraiseView = this.mAnimationView;
                if (guildFeedDoublePraiseView != null) {
                    guildFeedDoublePraiseView.h(floatValue2, floatValue, 1.5f);
                }
            }
        }
        x9();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<GuildFeedDetailLikeEvent>> getEventClass() {
        ArrayList<Class<GuildFeedDetailLikeEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GuildFeedDetailLikeEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.mAnimationView = (GuildFeedDoublePraiseView) rootView.findViewById(R.id.wge);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof GuildFeedDetailLikeEvent) {
            GuildFeedDetailLikeEvent guildFeedDetailLikeEvent = (GuildFeedDetailLikeEvent) event;
            if (guildFeedDetailLikeEvent.getFromWeb()) {
                return;
            }
            z9(Float.valueOf(guildFeedDetailLikeEvent.getPositionX()), Float.valueOf(guildFeedDetailLikeEvent.getPositionY()));
        }
    }
}
