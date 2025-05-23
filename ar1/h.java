package ar1;

import android.view.View;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.channellist.AppChannelData;
import com.tencent.mobileqq.guild.channellist.TextChannelData;
import com.tencent.mobileqq.guild.home.viewmodels.header.uidata.GuildCapsuleInfo;
import com.tencent.mobileqq.guild.home.viewmodels.header.uidata.NoticeBubbleInfo;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.quibadge.QUIBadgeDragLayout;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import os1.NoticeFeedMsgInfo;
import os1.NoticeFeedSquare;
import zq1.GuildChannelGroupUnread;
import zq1.GuildChannelUnread;
import zq1.GuildFeedSquareUnread;
import zq1.GuildNoticeMsgInboxUnread;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0002\u0015\u0016B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u00a2\u0006\u0004\b \u0010!J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J \u0010\u0010\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lar1/h;", "Lcom/tencent/mobileqq/activity/recent/cur/DragFrameLayout$a;", "Lcom/tencent/mobileqq/activity/recent/cur/DragFrameLayout$b;", "", "distanceX", "distanceY", "", "dragType", "Landroid/view/View;", "draggedView", "", "onDrag", "", "done", "Lcom/tencent/mobileqq/quibadge/QUIBadgeDragLayout;", "from", "onChange", "Lcom/tencent/mobileqq/activity/recent/cur/b;", "c", "Lcom/tencent/mobileqq/activity/recent/cur/DragFrameLayout;", "dragHost", "a", "b", "Lar1/h$b;", "d", "Lar1/h$b;", "onItemDragged", "e", "Lcom/tencent/mobileqq/activity/recent/cur/DragFrameLayout;", "Ljava/lang/ref/WeakReference;", "f", "Ljava/lang/ref/WeakReference;", "<init>", "(Lar1/h$b;)V", tl.h.F, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class h implements DragFrameLayout.a, DragFrameLayout.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b onItemDragged;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private DragFrameLayout dragHost;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private WeakReference<View> draggedView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&\u00a8\u0006\b"}, d2 = {"Lar1/h$b;", "", "", "b", "a", "Lzq1/e;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public interface b {
        void a();

        void b();

        void c(@NotNull zq1.e item);
    }

    public h(@NotNull b onItemDragged) {
        Intrinsics.checkNotNullParameter(onItemDragged, "onItemDragged");
        this.onItemDragged = onItemDragged;
        this.draggedView = new WeakReference<>(null);
    }

    public final void a(@NotNull DragFrameLayout dragHost) {
        Intrinsics.checkNotNullParameter(dragHost, "dragHost");
        Logger.f235387a.d().i("Guild.CLST.ChannelUnreadRedPointDragHandler", 1, "attachToDragHost(" + dragHost + ")");
        this.dragHost = dragHost;
        dragHost.addOnDragModeChangeListenerByGroup("guild", this, false);
        dragHost.addOnDragModeChangeListener(this, false);
        cr1.a.INSTANCE.a(dragHost, this);
    }

    public final void b(@NotNull DragFrameLayout dragHost) {
        Intrinsics.checkNotNullParameter(dragHost, "dragHost");
        Logger.f235387a.d().i("Guild.CLST.ChannelUnreadRedPointDragHandler", 1, "detachFromDragHost(" + dragHost + ")");
        this.dragHost = null;
        dragHost.removeOnDragModeChangeListenerByGroup("guild", this);
        dragHost.removeOnDragModeChangeListener(this);
        cr1.a.INSTANCE.b(dragHost, this);
    }

    @Nullable
    public final com.tencent.mobileqq.activity.recent.cur.b c() {
        return this.dragHost;
    }

    @Override // com.tencent.mobileqq.quibadge.QUIBadgeDragLayout.OnDragModeChangedListener
    public void onChange(boolean done, int dragType, @NotNull QUIBadgeDragLayout from) {
        Intrinsics.checkNotNullParameter(from, "from");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            Logger.a d16 = logger.d();
            int mode = from.getMode();
            View dragView = from.getDragView();
            d16.d("Guild.CLST.ChannelUnreadRedPointDragHandler", 2, "onChange(" + done + ", " + dragType + ", " + mode + ", " + (dragView != null ? dragView.getTag() : null));
        }
        if (from.getMode() == -1) {
            ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).setDrawerFrameEnable(false);
            this.draggedView.clear();
            this.onItemDragged.a();
        }
        if (from.getMode() == -1 && from.getDragView() != null && from.getDragView().getId() == R.id.f114296sy) {
            Object tag = from.getDragView().getTag();
            if (tag instanceof com.tencent.mobileqq.guild.main.data.e) {
                if (QLog.isColorLevel()) {
                    logger.d().d("Guild.CLST.ChannelUnreadRedPointDragHandler", 2, "onChange() item = " + tag);
                }
                b bVar = this.onItemDragged;
                com.tencent.mobileqq.guild.main.data.e eVar = (com.tencent.mobileqq.guild.main.data.e) tag;
                String i3 = eVar.i();
                Intrinsics.checkNotNullExpressionValue(i3, "item.guildId");
                String channelUin = eVar.f227155f.getChannelUin();
                Intrinsics.checkNotNullExpressionValue(channelUin, "item.mChannelInfo.channelUin");
                bVar.c(new GuildChannelUnread(i3, channelUin));
                return;
            }
            if (tag instanceof com.tencent.mobileqq.guild.main.data.f) {
                if (QLog.isColorLevel()) {
                    logger.d().d("Guild.CLST.ChannelUnreadRedPointDragHandler", 2, "onChange() item = " + tag);
                }
                b bVar2 = this.onItemDragged;
                com.tencent.mobileqq.guild.main.data.f fVar = (com.tencent.mobileqq.guild.main.data.f) tag;
                String guildID = fVar.D.getGuildID();
                Intrinsics.checkNotNullExpressionValue(guildID, "item.mGuildInfo.guildID");
                bVar2.c(new GuildChannelGroupUnread(guildID, fVar.f227154e));
                return;
            }
            if (tag instanceof NoticeFeedSquare) {
                if (QLog.isColorLevel()) {
                    logger.d().d("Guild.CLST.ChannelUnreadRedPointDragHandler", 2, "onChange() item = " + tag);
                }
                this.onItemDragged.c(new GuildFeedSquareUnread(((NoticeFeedSquare) tag).getGuildId()));
                return;
            }
            if (tag instanceof NoticeFeedMsgInfo) {
                if (QLog.isColorLevel()) {
                    logger.d().d("Guild.CLST.ChannelUnreadRedPointDragHandler", 1, "onChange() item = " + tag);
                }
                this.onItemDragged.c(new GuildNoticeMsgInboxUnread(((NoticeFeedMsgInfo) tag).getGuildId()));
                return;
            }
            if (tag instanceof TextChannelData) {
                if (QLog.isColorLevel()) {
                    logger.d().d("Guild.CLST.ChannelUnreadRedPointDragHandler", 1, "onChange() item = " + tag);
                }
                TextChannelData textChannelData = (TextChannelData) tag;
                this.onItemDragged.c(new GuildChannelUnread(String.valueOf(textChannelData.getGuildId()), String.valueOf(textChannelData.getChannelUin())));
                return;
            }
            if (tag instanceof AppChannelData) {
                if (QLog.isColorLevel()) {
                    logger.d().d("Guild.CLST.ChannelUnreadRedPointDragHandler", 1, "onChange() item = " + tag);
                }
                AppChannelData appChannelData = (AppChannelData) tag;
                this.onItemDragged.c(new GuildChannelUnread(String.valueOf(appChannelData.getGuildId()), String.valueOf(appChannelData.getChannelUin())));
                return;
            }
            if (tag instanceof GuildCapsuleInfo) {
                if (QLog.isColorLevel()) {
                    logger.d().d("Guild.CLST.ChannelUnreadRedPointDragHandler", 1, "onChange() item = " + tag);
                }
                GuildCapsuleInfo guildCapsuleInfo = (GuildCapsuleInfo) tag;
                this.onItemDragged.c(new GuildChannelUnread(guildCapsuleInfo.getGuildId(), guildCapsuleInfo.getChannelId()));
                return;
            }
            Logger.b bVar3 = new Logger.b();
            String str = "onChange: unknown item type " + tag;
            if (str instanceof String) {
                bVar3.a().add(str);
            }
            Iterator<T> it = bVar3.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.CLST.ChannelUnreadRedPointDragHandler", 1, (String) it.next(), null);
            }
            return;
        }
        if (from.getMode() == -1) {
            View dragView2 = from.getDragView();
            if ((dragView2 != null ? dragView2.getTag() : null) instanceof NoticeFeedMsgInfo) {
                Object tag2 = from.getDragView().getTag();
                Intrinsics.checkNotNull(tag2, "null cannot be cast to non-null type com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.rightlist.headerbars.uidata.NoticeFeedMsg.NoticeFeedMsgInfo");
                NoticeFeedMsgInfo noticeFeedMsgInfo = (NoticeFeedMsgInfo) tag2;
                if (QLog.isColorLevel()) {
                    logger.d().d("Guild.CLST.ChannelUnreadRedPointDragHandler", 1, "onChange() item = " + noticeFeedMsgInfo);
                }
                this.onItemDragged.c(new GuildNoticeMsgInboxUnread(noticeFeedMsgInfo.getGuildId()));
            }
        }
        if (from.getMode() == -1) {
            View dragView3 = from.getDragView();
            if ((dragView3 != null ? dragView3.getTag() : null) instanceof NoticeBubbleInfo) {
                Object tag3 = from.getDragView().getTag();
                Intrinsics.checkNotNull(tag3, "null cannot be cast to non-null type com.tencent.mobileqq.guild.home.viewmodels.header.uidata.NoticeBubbleInfo");
                NoticeBubbleInfo noticeBubbleInfo = (NoticeBubbleInfo) tag3;
                if (QLog.isColorLevel()) {
                    logger.d().d("Guild.CLST.ChannelUnreadRedPointDragHandler", 1, "onChange() item = " + noticeBubbleInfo);
                }
                this.onItemDragged.c(new GuildNoticeMsgInboxUnread(noticeBubbleInfo.getGuildId()));
            }
        }
    }

    @Override // com.tencent.mobileqq.quibadge.QUIBadgeDragLayout.OnDragListener
    public void onDrag(float distanceX, float distanceY, int dragType, @NotNull View draggedView) {
        Intrinsics.checkNotNullParameter(draggedView, "draggedView");
        if (!Intrinsics.areEqual(this.draggedView.get(), draggedView)) {
            DragFrameLayout dragFrameLayout = this.dragHost;
            if (dragFrameLayout != null) {
                dragFrameLayout.removeOnDragModeChangeListener(this);
            }
            DragFrameLayout dragFrameLayout2 = this.dragHost;
            if (dragFrameLayout2 != null) {
                dragFrameLayout2.addOnDragModeChangeListener(this, false);
            }
            this.draggedView = new WeakReference<>(draggedView);
        }
        this.onItemDragged.b();
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.CLST.ChannelUnreadRedPointDragHandler", 2, "onDrag(" + distanceX + ", " + distanceY + ", " + dragType + ", " + draggedView + ")");
        }
    }
}
