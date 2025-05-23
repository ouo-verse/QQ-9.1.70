package com.tencent.mobileqq.nearbypro.profile.feeds;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener;
import com.tencent.mobileqq.guild.widget.qqui.RoundRectImageView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.feeds.event.NBPFeedCommentEvent;
import com.tencent.mobileqq.nearbypro.feeds.event.NBPFeedDeleteEvent;
import com.tencent.mobileqq.nearbypro.feeds.event.NBPFeedLikeEvent;
import com.tencent.mobileqq.nearbypro.feeds.event.NBPFeedRefreshEvent;
import com.tencent.mobileqq.nearbypro.utils.PicLoadUtilsKt;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import jb2.UserProfileData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oa2.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ra2.d;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 02\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004:\u00011J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\u0006H\u0014J\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eJ\u0012\u0010\u0012\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0016J\u0014\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00140\u0013H\u0016R\u0017\u0010\u0018\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R$\u0010!\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010$R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/profile/feeds/FeedsContent;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/biz/richframework/preload/recyclerview/ILoadMoreProvider$LoadMoreListener;", "Loa2/a;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "c", "b", "onLoadMoreStart", "", "hasMore", "onLoadMoreEnd", NodeProps.ON_DETACHED_FROM_WINDOW, "Ljb2/a;", "data", "setUserInfo", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "d", "Z", "isSelf", "()Z", "", "e", "Ljava/lang/String;", "getLocalFeedId", "()Ljava/lang/String;", "setLocalFeedId", "(Ljava/lang/String;)V", "localFeedId", "Lcom/tencent/mobileqq/guild/widget/qqui/RoundRectImageView;", "f", "Lcom/tencent/mobileqq/guild/widget/qqui/RoundRectImageView;", "mAvatarDressBorder", h.F, "mAvatar", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "mNickName", "Lra2/d;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lra2/d;", "mViewModel", BdhLogUtil.LogTag.Tag_Conn, "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class FeedsContent extends RelativeLayout implements ILoadMoreProvider$LoadMoreListener, a, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean isSelf;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String localFeedId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RoundRectImageView mAvatarDressBorder;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RoundRectImageView mAvatar;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView mNickName;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private d mViewModel;

    private final void c() {
        RFWIocAbilityProvider.g().unregisterSingleIoc(getRootView(), a.class);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(NBPFeedLikeEvent.class);
        arrayList.add(NBPFeedDeleteEvent.class);
        arrayList.add(NBPFeedRefreshEvent.class);
        arrayList.add(NBPFeedCommentEvent.class);
        return arrayList;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        j.c().c("NBP.NearbyFeedPart.FeedsContent", "onLoadMoreStart");
        d dVar = this.mViewModel;
        if (dVar != null) {
            dVar.loadMore();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        d dVar;
        if (event instanceof NBPFeedLikeEvent) {
            d dVar2 = this.mViewModel;
            if (dVar2 != null) {
                NBPFeedLikeEvent nBPFeedLikeEvent = (NBPFeedLikeEvent) event;
                dVar2.Q1(nBPFeedLikeEvent.getFeedId(), nBPFeedLikeEvent.getLikeInfo());
                return;
            }
            return;
        }
        if (event instanceof NBPFeedDeleteEvent) {
            d dVar3 = this.mViewModel;
            if (dVar3 != null) {
                dVar3.P1(((NBPFeedDeleteEvent) event).getFeedId());
                return;
            }
            return;
        }
        if (event instanceof NBPFeedRefreshEvent) {
            d dVar4 = this.mViewModel;
            if (dVar4 != null) {
                dVar4.T1(((NBPFeedRefreshEvent) event).getStatusFeed());
                return;
            }
            return;
        }
        if ((event instanceof NBPFeedCommentEvent) && (dVar = this.mViewModel) != null) {
            NBPFeedCommentEvent nBPFeedCommentEvent = (NBPFeedCommentEvent) event;
            dVar.O1(nBPFeedCommentEvent.getFeedId(), nBPFeedCommentEvent.getCommentCount());
        }
    }

    public final void setLocalFeedId(@Nullable String str) {
        this.localFeedId = str;
    }

    public final void setUserInfo(@NotNull UserProfileData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        TextView textView = this.mNickName;
        final RoundRectImageView roundRectImageView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNickName");
            textView = null;
        }
        textView.setText(data.getNickName());
        String avatarDressBorderUrl = data.getAvatarDressBorderUrl();
        RoundRectImageView roundRectImageView2 = this.mAvatarDressBorder;
        if (roundRectImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAvatarDressBorder");
            roundRectImageView2 = null;
        }
        PicLoadUtilsKt.d(avatarDressBorderUrl, roundRectImageView2);
        String avatarUrl = data.getAvatarUrl();
        RoundRectImageView roundRectImageView3 = this.mAvatar;
        if (roundRectImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAvatar");
            roundRectImageView3 = null;
        }
        PicLoadUtilsKt.c(avatarUrl, roundRectImageView3);
        if (this.isSelf) {
            final TextView textView2 = this.mNickName;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNickName");
                textView2 = null;
            }
            final long j3 = 200;
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.nearbypro.profile.feeds.FeedsContent$setUserInfo$$inlined$setSingleClickListener$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View it) {
                    EventCollector.getInstance().onViewClickedBefore(it);
                    textView2.setClickable(false);
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    this.b();
                    final View view = textView2;
                    view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.nearbypro.profile.feeds.FeedsContent$setUserInfo$$inlined$setSingleClickListener$1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            view.setClickable(true);
                        }
                    }, j3);
                    EventCollector.getInstance().onViewClicked(it);
                }
            });
            RoundRectImageView roundRectImageView4 = this.mAvatar;
            if (roundRectImageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAvatar");
            } else {
                roundRectImageView = roundRectImageView4;
            }
            roundRectImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.nearbypro.profile.feeds.FeedsContent$setUserInfo$$inlined$setSingleClickListener$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View it) {
                    EventCollector.getInstance().onViewClickedBefore(it);
                    roundRectImageView.setClickable(false);
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    this.b();
                    final View view = roundRectImageView;
                    view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.nearbypro.profile.feeds.FeedsContent$setUserInfo$$inlined$setSingleClickListener$2.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            view.setClickable(true);
                        }
                    }, j3);
                    EventCollector.getInstance().onViewClicked(it);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b() {
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean hasMore) {
    }
}
