package ar1;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewStub;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderConstant;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.base.extension.q;
import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.main.data.FirstActivePositionAndData;
import com.tencent.mobileqq.guild.main.data.QQGuildChannelLive;
import com.tencent.mobileqq.guild.main.view.GuildUnreadBubbleLayout;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bd;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.guild.widget.banner.titlelayout.ChannelTitleLayout;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.WeakReferenceHandler;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 N2\u00020\u00012\u00020\u0002:\u0001OJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\u0003H\u0003J\b\u0010\u0015\u001a\u00020\u0003H\u0003J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0012\u0010\u001b\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016R\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001dR\u0014\u0010!\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010 R\u0016\u0010$\u001a\u0004\u0018\u00010\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010#R\u0014\u0010'\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010&R2\u0010,\u001a \u0012\f\u0012\n **\u0004\u0018\u00010)0) **\t\u0012\u0002\b\u00030(\u00a8\u0006\u00010(\u00a8\u0006\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010+R\u0014\u0010/\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010.R\u0016\u00102\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00105\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010>\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u00107R\"\u0010F\u001a\u00020?8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\"\u0010M\u001a\u00020G8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010L\u00a8\u0006P"}, d2 = {"Lar1/e;", "Landroid/os/Handler$Callback;", "Landroid/view/View$OnClickListener;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "g", "Lcom/tencent/mobileqq/guild/main/data/a;", tl.h.F, "Lkotlin/ranges/IntRange;", "f", DownloaderConstant.KEY_RANGE, "", "isActiveRedPointFlag", "d", "i", "k", "l", "Lcom/tencent/mobileqq/guild/main/view/GuildUnreadBubbleLayout;", "e", "c", "j", "Landroid/os/Message;", "msg", "handleMessage", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Landroid/view/ViewStub;", "Landroid/view/ViewStub;", "stubBubbleLayout", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/mobileqq/guild/widget/banner/titlelayout/ChannelTitleLayout;", "Lcom/tencent/mobileqq/guild/widget/banner/titlelayout/ChannelTitleLayout;", "headTitleAboveList", "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "guildFacadeType", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "kotlin.jvm.PlatformType", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "Lcom/tencent/util/WeakReferenceHandler;", "Lcom/tencent/util/WeakReferenceHandler;", "handler", BdhLogUtil.LogTag.Tag_Conn, "Z", "addedListeners", "D", "Lcom/tencent/mobileqq/guild/main/view/GuildUnreadBubbleLayout;", "bubbleLayout", "E", "I", "itemAdapterLocation", "", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "curGuildId", "G", "tabHeight", "Lcom/tencent/mobileqq/guild/util/bd;", "H", "Lcom/tencent/mobileqq/guild/util/bd;", "getRefreshHandler", "()Lcom/tencent/mobileqq/guild/util/bd;", "setRefreshHandler", "(Lcom/tencent/mobileqq/guild/util/bd;)V", "refreshHandler", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "getRunnable", "()Ljava/lang/Runnable;", "setRunnable", "(Ljava/lang/Runnable;)V", "runnable", "J", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class e implements Handler.Callback, View.OnClickListener {
    private static final float K = cw.d(13);
    private static final float L = cw.d(16);

    /* renamed from: C, reason: from kotlin metadata */
    private boolean addedListeners;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private GuildUnreadBubbleLayout bubbleLayout;

    /* renamed from: E, reason: from kotlin metadata */
    private int itemAdapterLocation;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private String curGuildId;

    /* renamed from: G, reason: from kotlin metadata */
    private final int tabHeight;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private bd refreshHandler;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private Runnable runnable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewStub stubBubbleLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclerView recyclerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final ChannelTitleLayout headTitleAboveList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildFacadeType guildFacadeType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclerView.Adapter adapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReferenceHandler handler;

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public final void c() {
        if (this.addedListeners) {
            return;
        }
        this.recyclerView.addOnScrollListener(null);
        RecyclerView.Adapter adapter = this.recyclerView.getAdapter();
        Intrinsics.checkNotNull(adapter);
        adapter.registerAdapterDataObserver(null);
        this.addedListeners = true;
        this.refreshHandler.c(this.runnable, 60000L);
    }

    private final boolean d(IntRange range, boolean isActiveRedPointFlag) {
        RecyclerView.LayoutManager layoutManager = this.recyclerView.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int first = range.getFirst();
        int last = range.getLast();
        if (first > last) {
            return false;
        }
        while (true) {
            View childAt = linearLayoutManager.getChildAt(first - findFirstVisibleItemPosition);
            if (childAt != null) {
                Object tag = childAt.getTag(R.id.w1p);
                if (tag instanceof com.tencent.mobileqq.guild.main.data.d) {
                    Logger logger = Logger.f235387a;
                    if (QLog.isDevelopLevel()) {
                        Log.d("Guild.BubbleLayoutUiLogic", "checkRedPointVisible: [" + first + "] " + tag);
                    }
                    if (!isActiveRedPointFlag && ((com.tencent.mobileqq.guild.main.data.d) tag).b()) {
                        return true;
                    }
                    if (isActiveRedPointFlag) {
                        if (tag instanceof QQGuildChannelLive) {
                            Boolean q16 = ((QQGuildChannelLive) tag).q();
                            Intrinsics.checkNotNullExpressionValue(q16, "tag.isLiving");
                            if (q16.booleanValue()) {
                                return true;
                            }
                        }
                        if ((tag instanceof com.tencent.mobileqq.guild.main.data.g) && ((com.tencent.mobileqq.guild.main.data.g) tag).o() > 3) {
                            return true;
                        }
                    }
                }
            }
            if (first != last) {
                first++;
            } else {
                return false;
            }
        }
    }

    private final GuildUnreadBubbleLayout e() {
        GuildUnreadBubbleLayout guildUnreadBubbleLayout = this.bubbleLayout;
        if (guildUnreadBubbleLayout == null) {
            View inflate = this.stubBubbleLayout.inflate();
            Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type com.tencent.mobileqq.guild.main.view.GuildUnreadBubbleLayout");
            guildUnreadBubbleLayout = (GuildUnreadBubbleLayout) inflate;
            this.bubbleLayout = guildUnreadBubbleLayout;
            ChannelTitleLayout channelTitleLayout = this.headTitleAboveList;
            if (channelTitleLayout != null) {
                guildUnreadBubbleLayout.setTitleAboveList(channelTitleLayout);
            }
            guildUnreadBubbleLayout.setOnClickListener(this);
        }
        return guildUnreadBubbleLayout;
    }

    private final IntRange f() {
        RecyclerView.LayoutManager layoutManager = this.recyclerView.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        if (findFirstVisibleItemPosition != -1 && findLastVisibleItemPosition != -1) {
            int i3 = findFirstVisibleItemPosition;
            if (findFirstVisibleItemPosition <= findLastVisibleItemPosition) {
                int i16 = i3;
                while (true) {
                    if (linearLayoutManager.getChildAt(i3 - findFirstVisibleItemPosition) != null) {
                        if (r9.getTop() + K + L > 0.0f) {
                            break;
                        }
                        i16 = -1;
                    }
                    if (i3 != findLastVisibleItemPosition) {
                        i3++;
                    } else {
                        i3 = i16;
                        break;
                    }
                }
            }
            if (i3 <= findLastVisibleItemPosition) {
                int i17 = findLastVisibleItemPosition;
                while (true) {
                    if (linearLayoutManager.getChildAt(findLastVisibleItemPosition - findFirstVisibleItemPosition) != null) {
                        if (r9.getTop() + K < this.recyclerView.getHeight() - this.tabHeight) {
                            break;
                        }
                        i17 = -1;
                    }
                    if (findLastVisibleItemPosition != i3) {
                        findLastVisibleItemPosition--;
                    } else {
                        findLastVisibleItemPosition = i17;
                        break;
                    }
                }
            }
            if (i3 != -1 && findLastVisibleItemPosition != -1) {
                if (this.guildFacadeType != GuildFacadeType.FeedsGuildHomeSubChannel9015) {
                    i3++;
                }
                IntRange intRange = new IntRange(i3, findLastVisibleItemPosition);
                Logger logger = Logger.f235387a;
                if (QLog.isDevelopLevel()) {
                    Log.d("Guild.BubbleLayoutUiLogic", "findVisibleRange: " + intRange);
                }
                return intRange;
            }
            Logger logger2 = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "checkRedPointVisible again: NO_POSITION, " + i3 + " / " + findLastVisibleItemPosition;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.BubbleLayoutUiLogic", 1, (String) it.next(), null);
            }
            return new IntRange(0, -1);
        }
        Logger logger3 = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.BubbleLayoutUiLogic", "checkRedPointVisible: NO_POSITION, " + findFirstVisibleItemPosition + " / " + findLastVisibleItemPosition);
        }
        return new IntRange(0, -1);
    }

    private final int g() {
        return -1;
    }

    private final FirstActivePositionAndData h() {
        if (this.adapter instanceof RFWConcatAdapter) {
            return new FirstActivePositionAndData(-1, null);
        }
        throw new IllegalArgumentException("adapter must be RFWConcatAdapter".toString());
    }

    private final void i() {
        Logger.f235387a.d().i("Guild.BubbleLayoutUiLogic", 1, "checkBubble: hide");
        GuildUnreadBubbleLayout guildUnreadBubbleLayout = this.bubbleLayout;
        if (guildUnreadBubbleLayout != null) {
            guildUnreadBubbleLayout.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public final void j() {
        this.recyclerView.removeOnScrollListener(null);
        RecyclerView.Adapter adapter = this.recyclerView.getAdapter();
        Intrinsics.checkNotNull(adapter);
        adapter.unregisterAdapterDataObserver(null);
        this.addedListeners = false;
        this.handler.removeMessages(1);
        this.refreshHandler.e(this.runnable);
    }

    private final void k() {
        Logger.f235387a.d().i("Guild.BubbleLayoutUiLogic", 1, "checkBubble: show above");
        e().n(true);
    }

    private final void l() {
        Logger.f235387a.d().i("Guild.BubbleLayoutUiLogic", 1, "checkBubble: show below");
        e().n(false);
    }

    private final void m() {
        boolean z16;
        com.tencent.mobileqq.guild.main.data.d data;
        boolean z17 = false;
        if (this.recyclerView.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            i();
            return;
        }
        int g16 = g();
        IntRange f16 = f();
        boolean d16 = d(f16, false);
        if (!d16 && g16 != -1) {
            data = null;
        } else {
            g16 = h().getPosition();
            data = h().getData();
            if (g16 > 0) {
                d16 = d(f16, true);
            }
            z17 = ch.j0(this.curGuildId);
        }
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.BubbleLayoutUiLogic", "hasVisibleRedPoint " + d16 + ", firstRedPointPosition " + g16 + ", visibleRange " + f16 + " ,isGuest" + z17 + " ");
        }
        this.itemAdapterLocation = g16;
        if (!z17 && !d16 && g16 != -1) {
            if (g16 < f16.getFirst()) {
                e().setUnreadMsgTips(data);
                k();
                return;
            }
            if (g16 > f16.getLast()) {
                e().setUnreadMsgTips(data);
                l();
                return;
            }
            IllegalStateException illegalStateException = new IllegalStateException("");
            Logger.b bVar = new Logger.b();
            bVar.a().add("checkBubble: should not happen!");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.BubbleLayoutUiLogic", 1, (String) it.next(), illegalStateException);
            }
            return;
        }
        i();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NotNull Message msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2.what == 1) {
            m();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        int i3;
        EventCollector.getInstance().onViewClickedBefore(v3);
        int i16 = this.itemAdapterLocation;
        if (i16 == -1) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("onClick but itemAdapterLocation is -1");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.BubbleLayoutUiLogic", 1, (String) it.next(), null);
            }
        } else {
            RecyclerView recyclerView = this.recyclerView;
            ChannelTitleLayout channelTitleLayout = this.headTitleAboveList;
            if (channelTitleLayout != null) {
                i3 = channelTitleLayout.getHeight();
            } else {
                i3 = 0;
            }
            q.d(recyclerView, i16, i3);
            e().h("clck");
        }
        EventCollector.getInstance().onViewClicked(v3);
    }
}
