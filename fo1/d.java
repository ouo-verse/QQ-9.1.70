package fo1;

import android.os.Handler;
import android.view.KeyEvent;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.mobileqq.guild.feed.video.GuildFeedListBaseVideoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import ij1.g;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 *2\u00020\u0001:\u00015B\u0007\u00a2\u0006\u0004\b3\u00104J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0007H\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0002J\u001a\u0010\u0011\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u0014\u001a\u00020\u0007H\u0016JJ\u0010\u001c\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010 \u001a\u00020\u0007H\u0016J\b\u0010!\u001a\u00020\u0007H\u0016J\b\u0010\"\u001a\u00020\u0007H\u0016J\b\u0010#\u001a\u00020\u0007H\u0016J\u0010\u0010%\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u001aH\u0016R\u0018\u0010(\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u00066"}, d2 = {"Lfo1/d;", "Lcom/tencent/mobileqq/guild/feed/manager/b;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "manager", "", "firstVisiblePosition", "lastVisiblePosition", "", "t", "Leo1/a;", "view", "index", "v", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "u", "controller", com.tencent.luggage.wxa.c8.c.G, "B", "firstVisiblePos", "w", h.F, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "newState", "firstCompletelyVisible", "lastCompletelyVisible", "", "isScrollUp", "j", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "l", "onResume", "g", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "o", "pageIn", "e", "E", "Leo1/a;", "mCurrentPlayController", UserInfo.SEX_FEMALE, "I", "mCurrentPlayPos", "Ljava/lang/Runnable;", "G", "Ljava/lang/Runnable;", "mStartRunnable", "H", "Z", "isPageIn", "<init>", "()V", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d extends com.tencent.mobileqq.guild.feed.manager.b {

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private eo1.a mCurrentPlayController;

    /* renamed from: F, reason: from kotlin metadata */
    private int mCurrentPlayPos;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private Runnable mStartRunnable;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isPageIn = true;

    private final void A() {
        if (this.mCurrentPlayController == null) {
            return;
        }
        QLog.d("GuildFeedVideoPlayScroller", 1, "[pauseCurrentPlayer]  pos = " + this.mCurrentPlayPos);
        eo1.a aVar = this.mCurrentPlayController;
        if (aVar != null) {
            aVar.pause();
        }
    }

    private final void B(eo1.a controller, int pos) {
        if (controller == null) {
            return;
        }
        QLog.d("GuildFeedVideoPlayScroller", 1, "releasePlay controller, pos = " + pos);
        controller.a();
    }

    private final void t(RecyclerView.LayoutManager manager, int firstVisiblePosition, int lastVisiblePosition) {
        int w3 = w(firstVisiblePosition);
        int i3 = (lastVisiblePosition - firstVisiblePosition) + w3;
        ArrayList arrayList = new ArrayList();
        boolean z16 = false;
        if (w3 <= i3) {
            int i16 = w3;
            while (true) {
                int i17 = (firstVisiblePosition + i16) - w3;
                KeyEvent.Callback findViewByPosition = manager.findViewByPosition(i16);
                if (findViewByPosition instanceof eo1.a) {
                    eo1.a aVar = (eo1.a) findViewByPosition;
                    GuildFeedListBaseVideoView d16 = aVar.d();
                    if (d16 != null && c(d16) && !z16) {
                        v(aVar, i16);
                        QLog.d("GuildFeedVideoPlayScroller", 1, "[checkPlayStatus]| doPlay | pos = " + i17);
                        z16 = true;
                    } else {
                        aVar.pause();
                        arrayList.add(Integer.valueOf(i17));
                        QLog.d("GuildFeedVideoPlayScroller", 1, "[checkPlayStatus]| stop play | pos = " + i17);
                    }
                }
                if (i16 == i3) {
                    break;
                } else {
                    i16++;
                }
            }
        }
        if (!z16) {
            A();
        }
    }

    private final void u() {
        int[] b16 = b();
        if (b16 != null && b16.length >= 2) {
            RecyclerView.LayoutManager layoutManager = this.f220164e.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager);
            t(layoutManager, b16[0], b16[1]);
        }
    }

    private final void v(eo1.a view, int index) {
        view.play();
        this.mCurrentPlayController = view;
        this.mCurrentPlayPos = index;
    }

    private final int w(int firstVisiblePos) {
        List<g> list;
        int coerceAtLeast;
        BaseListViewAdapter<g> baseListViewAdapter = this.f220168m;
        if (baseListViewAdapter != null) {
            list = baseListViewAdapter.getDataList();
        } else {
            list = null;
        }
        if (list != null && !list.isEmpty()) {
            BaseListViewAdapter<g> baseListViewAdapter2 = this.f220168m;
            if (baseListViewAdapter2 instanceof MultiViewBlock) {
                Intrinsics.checkNotNull(baseListViewAdapter2, "null cannot be cast to non-null type com.tencent.biz.richframework.part.block.MultiViewBlock<*>");
                int max = Math.max(((MultiViewBlock) baseListViewAdapter2).getPositionOffsetStart(), 0);
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(firstVisiblePos + max, 0);
                QLog.d("GuildFeedVideoPlayScroller", 4, "[checkPreload] offsetStart: " + max + ", firstVisiblePos " + coerceAtLeast);
                return coerceAtLeast;
            }
        }
        QLog.e("GuildFeedVideoPlayScroller", 4, "feeds is null or empty! ");
        return firstVisiblePos;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(d this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(d this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SimpleEventBus.getInstance().registerReceiver(this$0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(d this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.u();
    }

    @Override // com.tencent.mobileqq.guild.feed.manager.b
    public void e(boolean pageIn) {
        this.isPageIn = pageIn;
        if (pageIn) {
            RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: fo1.b
                @Override // java.lang.Runnable
                public final void run() {
                    d.x(d.this);
                }
            }, 500L);
        } else {
            A();
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.manager.b
    public void g() {
        super.g();
        QLog.d("GuildFeedVideoPlayScroller", 1, "pause player onPause");
        A();
    }

    @Override // com.tencent.mobileqq.guild.feed.manager.b
    public void h() {
        super.h();
        QLog.d("GuildFeedVideoPlayScroller", 1, "onRefreshData ");
        B(this.mCurrentPlayController, this.mCurrentPlayPos);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: fo1.c
            @Override // java.lang.Runnable
            public final void run() {
                d.y(d.this);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.feed.manager.b
    public void j(@Nullable RecyclerView recyclerView, int newState, @NotNull RecyclerView.LayoutManager manager, int firstVisiblePosition, int lastVisiblePosition, int firstCompletelyVisible, int lastCompletelyVisible, boolean isScrollUp) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        if (newState != 0 || !d()) {
            return;
        }
        t(manager, firstVisiblePosition, lastVisiblePosition);
    }

    @Override // com.tencent.mobileqq.guild.feed.manager.b
    public void l(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.l(holder);
        KeyEvent.Callback callback = holder.itemView;
        if (!(callback instanceof eo1.a)) {
            return;
        }
        Intrinsics.checkNotNull(callback, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.video.controller.IGuildFeedScrollPlayController");
        B((eo1.a) callback, holder.getAdapterPosition());
    }

    @Override // com.tencent.mobileqq.guild.feed.manager.b
    public void o() {
        A();
    }

    @Override // com.tencent.mobileqq.guild.feed.manager.b
    public void onDestroy() {
        super.onDestroy();
        B(this.mCurrentPlayController, this.mCurrentPlayPos);
        if (this.mStartRunnable != null) {
            Handler uIHandler = RFWThreadManager.getUIHandler();
            Runnable runnable = this.mStartRunnable;
            Intrinsics.checkNotNull(runnable);
            uIHandler.removeCallbacks(runnable);
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.mobileqq.guild.feed.manager.b
    public void onResume() {
        super.onResume();
        QLog.d("GuildFeedVideoPlayScroller", 1, "onResume ,computeWhichToPlay");
        if (this.isPageIn) {
            RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: fo1.a
                @Override // java.lang.Runnable
                public final void run() {
                    d.z(d.this);
                }
            }, 500L);
        }
        SimpleEventBus.getInstance().registerReceiver(this);
    }
}
