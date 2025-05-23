package com.tencent.guild.aio.factory.business.holder.msglist.scrollers;

import androidx.recyclerview.widget.AIOLinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.aio.api.list.IListUIOperationApi;
import com.tencent.guild.aio.factory.business.holder.msglist.a;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0007\b\u0000\u0018\u0000 42\u00020\u0001:\u00015B+\u0012\u0006\u0010 \u001a\u00020\u001a\u0012\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00040\u0013\u0012\u0006\u0010'\u001a\u00020%\u00a2\u0006\u0004\b2\u00103J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J0\u0010\u0012\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0002J!\u0010\u0017\u001a\u00020\u00042\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00040\u0013\u00a2\u0006\u0002\b\u0015H\u0002J\f\u0010\u0018\u001a\u00020\t*\u00020\tH\u0002J\f\u0010\u0019\u001a\u00020\u0006*\u00020\tH\u0002J \u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\u0018\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\tH\u0016R\u0014\u0010 \u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR \u0010$\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00040\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010'\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010&R$\u0010,\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00068\u0002@BX\u0082\u000e\u00a2\u0006\f\n\u0004\b\f\u0010)\"\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010-R\u0016\u00101\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u00100\u00a8\u00066"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/scrollers/GuildMsgListScrollManager;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "", "f", "", "resetScrollParam", "Lcom/tencent/guild/aio/factory/business/holder/msglist/scrollers/ScrollDirection;", "direction", "j", "", "dx", "dy", h.F, "newState", "firstVisiblePos", "lastVisiblePos", "firstCompletelyVisible", "lastCompletelyVisible", "i", "Lkotlin/Function1;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/scrollers/d;", "Lkotlin/ExtensionFunctionType;", "job", "g", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onScrolled", "onScrollStateChanged", "d", "Landroidx/recyclerview/widget/RecyclerView;", "mRecycleView", "Lat/b;", "e", "Lkotlin/jvm/functions/Function1;", "sendIntent", "Lcom/tencent/aio/api/list/IListUIOperationApi;", "Lcom/tencent/aio/api/list/IListUIOperationApi;", "listUIOperationApi", "value", "Lcom/tencent/guild/aio/factory/business/holder/msglist/scrollers/ScrollDirection;", "k", "(Lcom/tencent/guild/aio/factory/business/holder/msglist/scrollers/ScrollDirection;)V", "mLastScrollDirect", "I", "mScrollDisY", "", "J", "mStartComputeTime", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Lkotlin/jvm/functions/Function1;Lcom/tencent/aio/api/list/IListUIOperationApi;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildMsgListScrollManager extends RecyclerView.OnScrollListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclerView mRecycleView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<at.b, Unit> sendIntent;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IListUIOperationApi listUIOperationApi;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ScrollDirection mLastScrollDirect;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mScrollDisY;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long mStartComputeTime;

    /* JADX WARN: Multi-variable type inference failed */
    public GuildMsgListScrollManager(@NotNull RecyclerView mRecycleView, @NotNull Function1<? super at.b, Unit> sendIntent, @NotNull IListUIOperationApi listUIOperationApi) {
        Intrinsics.checkNotNullParameter(mRecycleView, "mRecycleView");
        Intrinsics.checkNotNullParameter(sendIntent, "sendIntent");
        Intrinsics.checkNotNullParameter(listUIOperationApi, "listUIOperationApi");
        this.mRecycleView = mRecycleView;
        this.sendIntent = sendIntent;
        this.listUIOperationApi = listUIOperationApi;
        this.mLastScrollDirect = ScrollDirection.IDLE;
    }

    private final int[] f() {
        int[] iArr = new int[4];
        try {
            RecyclerView.LayoutManager layoutManager = this.mRecycleView.getLayoutManager();
            if (layoutManager instanceof AIOLinearLayoutManager) {
                iArr[0] = l(((AIOLinearLayoutManager) layoutManager).findFirstVisibleItemPosition());
                iArr[1] = l(((AIOLinearLayoutManager) layoutManager).findLastVisibleItemPosition());
                iArr[2] = l(((AIOLinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition());
                iArr[3] = l(((AIOLinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition());
            }
        } catch (Exception e16) {
            QLog.e("GuildMsgListScrollManager", 1, "computePos e:" + e16);
        }
        return iArr;
    }

    private final void g(Function1<? super d, Unit> job) {
        this.sendIntent.invoke(new a.f(job));
    }

    private final void h(final int dx5, final int dy5, final ScrollDirection direction) {
        g(new Function1<d, Unit>() { // from class: com.tencent.guild.aio.factory.business.holder.msglist.scrollers.GuildMsgListScrollManager$sendScroll$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(d dVar) {
                invoke2(dVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull d send) {
                Intrinsics.checkNotNullParameter(send, "$this$send");
                send.c(dx5, dy5, direction);
            }
        });
    }

    private final void i(final int newState, final int firstVisiblePos, final int lastVisiblePos, final int firstCompletelyVisible, final int lastCompletelyVisible) {
        final ScrollDirection scrollDirection = this.mLastScrollDirect;
        g(new Function1<d, Unit>() { // from class: com.tencent.guild.aio.factory.business.holder.msglist.scrollers.GuildMsgListScrollManager$sendScrollStateChanged$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(d dVar) {
                invoke2(dVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull d send) {
                Intrinsics.checkNotNullParameter(send, "$this$send");
                send.a(newState, firstVisiblePos, lastVisiblePos, firstCompletelyVisible, lastCompletelyVisible, scrollDirection);
            }
        });
    }

    private final void j(final ScrollDirection direction) {
        final int[] f16 = f();
        g(new Function1<d, Unit>() { // from class: com.tencent.guild.aio.factory.business.holder.msglist.scrollers.GuildMsgListScrollManager$sendSlowScroll$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(d dVar) {
                invoke2(dVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull d send) {
                Intrinsics.checkNotNullParameter(send, "$this$send");
                int[] iArr = f16;
                send.b(iArr[0], iArr[1], iArr[2], iArr[3], direction);
            }
        });
    }

    private final void k(ScrollDirection scrollDirection) {
        if (scrollDirection != this.mLastScrollDirect) {
            Logger.f235387a.d().i("GuildMsgListScrollManager", 1, "onScrolled directionChanged old " + this.mLastScrollDirect + " new " + scrollDirection);
        }
        this.mLastScrollDirect = scrollDirection;
    }

    private final int l(int i3) {
        return this.listUIOperationApi.w(i3);
    }

    private final ScrollDirection m(int i3) {
        if (i3 == 0) {
            return ScrollDirection.IDLE;
        }
        if (i3 < 0) {
            return ScrollDirection.UP;
        }
        return ScrollDirection.DOWN;
    }

    private final void resetScrollParam() {
        k(ScrollDirection.IDLE);
        this.mScrollDisY = 0;
        this.mStartComputeTime = System.currentTimeMillis();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrollStateChanged(recyclerView, newState);
        if (newState == 0) {
            resetScrollParam();
        }
        int[] f16 = f();
        i(newState, f16[0], f16[1], f16[2], f16[3]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        ScrollDirection m3 = m(dy5);
        if (m3 == ScrollDirection.IDLE) {
            return;
        }
        if (this.mLastScrollDirect != m3) {
            resetScrollParam();
        }
        k(m3);
        this.mScrollDisY += dy5;
        long currentTimeMillis = System.currentTimeMillis() - this.mStartComputeTime;
        float f16 = (float) currentTimeMillis;
        if (f16 > 500.0f) {
            float abs = Math.abs(this.mScrollDisY / f16);
            if (abs < 3.0f) {
                j(m3);
            }
            resetScrollParam();
            Logger.f235387a.d().i("GuildMsgListScrollManager", 1, "onScrolled scrollSpeed:" + abs + " ScrollY:" + this.mScrollDisY + " scrollTime:" + currentTimeMillis);
        }
        h(dx5, dy5, m3);
    }
}
