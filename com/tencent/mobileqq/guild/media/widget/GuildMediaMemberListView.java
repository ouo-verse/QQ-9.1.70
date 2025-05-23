package com.tencent.mobileqq.guild.media.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.guild.media.core.data.TRTCQuality;
import com.tencent.mobileqq.guild.media.widget.user.MediaPageDataRepo;
import com.tencent.mobileqq.guild.media.widget.user.adapter.BaseMediaUserDelegateAdapter;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import rt1.MediaInviteItem;
import rt1.MediaPlayerUserItem;
import rt1.MediaViewerMoreItem;
import rt1.MediaViewerTitleItem;
import rt1.MediaViewerUserItem;
import rt1.PageLoadLoadParams;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildMediaMemberListView extends RecyclerView {
    private final int C;
    private GridLayoutManager D;
    private com.tencent.mobileqq.guild.media.widget.adapter.d E;
    private int F;
    private boolean G;
    private GuildNestedScrollView H;
    private MediaPageDataRepo I;
    private int J;
    private int K;
    private int L;
    private boolean M;
    private ArrayList<rt1.a> N;
    private final ViewTreeObserver.OnGlobalLayoutListener P;
    private final RecyclerView.OnScrollListener Q;
    private final RecyclerView.AdapterDataObserver R;
    private final com.tencent.mobileqq.guild.media.widget.user.b S;
    private final com.tencent.mobileqq.guild.media.core.notify.y T;

    /* renamed from: f, reason: collision with root package name */
    private IGProChannelInfo f229711f;

    /* renamed from: h, reason: collision with root package name */
    protected com.tencent.mobileqq.guild.media.core.data.f f229712h;

    /* renamed from: i, reason: collision with root package name */
    protected BaseMediaUserDelegateAdapter f229713i;

    /* renamed from: m, reason: collision with root package name */
    private int f229714m;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            View childAt;
            if (i3 != 0) {
                GuildMediaMemberListView.this.X();
            } else {
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager != null && (childAt = layoutManager.getChildAt(0)) != null) {
                    GuildMediaMemberListView.this.K = recyclerView.getLayoutManager().getPosition(childAt);
                    GuildMediaMemberListView.this.J = childAt.getTop() - com.tencent.mobileqq.guild.media.widget.adapter.c.f229814b;
                    GuildMediaMemberListView.this.Y();
                    if (GuildMediaMemberListView.this.getItemAnimator() != null) {
                        GuildMediaMemberListView.this.getItemAnimator().runPendingAnimations();
                    }
                    if (GuildMediaMemberListView.this.N != null) {
                        GuildMediaMemberListView guildMediaMemberListView = GuildMediaMemberListView.this;
                        guildMediaMemberListView.k0(guildMediaMemberListView.N);
                    }
                } else {
                    return;
                }
            }
            GuildMediaMemberListView.this.L = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class b extends RecyclerView.AdapterDataObserver {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            GuildMediaMemberListView.this.M = true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i3, int i16) {
            GuildMediaMemberListView.this.M = true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i3, int i16, int i17) {
            GuildMediaMemberListView.this.M = true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i3, int i16) {
            GuildMediaMemberListView.this.M = true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class c implements com.tencent.mobileqq.guild.media.widget.user.b {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.media.widget.user.b
        public void a(@NonNull ArrayList<rt1.a> arrayList) {
            GuildMediaMemberListView.this.Z();
            if (GuildMediaMemberListView.this.L == 0) {
                GuildMediaMemberListView.this.k0(arrayList);
            } else {
                GuildMediaMemberListView.this.N = arrayList;
            }
            QLog.i("QGMC.MemberListView", 1, "set items adapter size: " + GuildMediaMemberListView.this.f229713i.getNUM_BACKGOURND_ICON());
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class d implements Function2<IGProChannelInfo, Boolean, Unit> {
        d() {
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(IGProChannelInfo iGProChannelInfo, Boolean bool) {
            GuildMediaMemberListView.this.f229711f = iGProChannelInfo;
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class e extends GridLayoutManager.SpanSizeLookup {
        e() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i3) {
            rt1.a aVar;
            int size = GuildMediaMemberListView.this.f229713i.getItems().size();
            if (size <= 0) {
                return GuildMediaMemberListView.this.D.getSpanCount();
            }
            if (i3 >= 0 && i3 >= size) {
                aVar = GuildMediaMemberListView.this.f229713i.getItems().get(size - 1);
            } else {
                aVar = GuildMediaMemberListView.this.f229713i.getItems().get(i3);
            }
            if (aVar instanceof MediaViewerTitleItem) {
                return GuildMediaMemberListView.this.D.getSpanCount();
            }
            if (!(aVar instanceof MediaViewerUserItem) && !(aVar instanceof MediaViewerMoreItem)) {
                if (aVar instanceof MediaInviteItem) {
                    if (((MediaInviteItem) aVar).getColumn() == 1) {
                        return GuildMediaMemberListView.this.D.getSpanCount();
                    }
                    return GuildMediaMemberListView.this.D.getSpanCount() / MediaChannelUtils.i(GuildMediaMemberListView.this);
                }
                if ((aVar instanceof MediaPlayerUserItem) && GuildMediaMemberListView.this.f229714m == 1) {
                    return GuildMediaMemberListView.this.D.getSpanCount() / MediaChannelUtils.i(GuildMediaMemberListView.this);
                }
                return GuildMediaMemberListView.this.D.getSpanCount() / GuildMediaMemberListView.this.f229714m;
            }
            return GuildMediaMemberListView.this.D.getSpanCount() / GuildMediaMemberListView.this.F;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class f implements RecyclerView.ItemAnimator.ItemAnimatorFinishedListener {
        f() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator.ItemAnimatorFinishedListener
        public void onAnimationsFinished() {
            if (GuildMediaMemberListView.this.L == 0 && GuildMediaMemberListView.this.N != null) {
                GuildMediaMemberListView guildMediaMemberListView = GuildMediaMemberListView.this;
                guildMediaMemberListView.f229713i.setItems(guildMediaMemberListView.N);
                GuildMediaMemberListView.this.N = null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class g extends com.tencent.mobileqq.guild.media.core.notify.y {
        g() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.q
        public void i() {
            if (com.tencent.mobileqq.guild.media.core.j.a().J0()) {
                GuildMediaMemberListView.this.j0("");
            }
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.y
        public void q(String str, ArrayList<TRTCQuality> arrayList) {
            super.q(str, arrayList);
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.y
        public void u() {
            GuildMediaMemberListView.this.j0("onReRankUserListByAudioRobot");
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.y
        public void w(String str, String str2, com.tencent.mobileqq.guild.media.core.data.f fVar, com.tencent.mobileqq.guild.media.core.data.r rVar) {
            super.w(str, str2, fVar, rVar);
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.y
        public void x(String str, String str2, String str3, com.tencent.mobileqq.guild.media.core.data.f fVar) {
            if (GuildMediaMemberListView.this.f229711f != null && str2.equals(GuildMediaMemberListView.this.f229711f.getGuildId()) && str3.equals(GuildMediaMemberListView.this.f229711f.getChannelUin())) {
                com.tencent.mobileqq.guild.media.core.data.r userInfoList = com.tencent.mobileqq.guild.media.core.j.c().getUserInfoList();
                com.tencent.mobileqq.guild.media.core.data.f selfUserInfo = com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo();
                if (selfUserInfo.R && userInfoList.f228125a.size() == 0) {
                    com.tencent.mobileqq.guild.media.core.data.p g16 = userInfoList.g(selfUserInfo.f228093a);
                    if (g16 != null && g16.f228103k && userInfoList.f228125a.size() == 1) {
                        GuildMediaMemberListView.this.j0(str);
                        return;
                    }
                    return;
                }
                GuildMediaMemberListView.this.j0(str);
            }
        }
    }

    public GuildMediaMemberListView(Context context) {
        super(context);
        this.f229714m = 1;
        this.C = 300;
        this.F = 5;
        this.G = false;
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.M = false;
        this.P = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.mobileqq.guild.media.widget.r
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                GuildMediaMemberListView.this.e0();
            }
        };
        this.Q = new a();
        this.R = new b();
        this.S = new c();
        this.T = new g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        setAnimation(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        int noAnimUserCountLimit = com.tencent.mobileqq.guild.media.core.j.c().getNoAnimUserCountLimit();
        int W = com.tencent.mobileqq.guild.media.core.j.c().W();
        if (W > noAnimUserCountLimit && getItemAnimator() != null) {
            setItemAnimator(null);
        } else {
            if (W > noAnimUserCountLimit || (getItemAnimator() instanceof bf)) {
                return;
            }
            setItemAnimator(new bf());
            Y();
        }
    }

    private void a0() {
        RecyclerView.ItemDecoration itemDecoration = this.E;
        if (itemDecoration != null) {
            removeItemDecoration(itemDecoration);
        }
        com.tencent.mobileqq.guild.media.widget.adapter.d dVar = new com.tencent.mobileqq.guild.media.widget.adapter.d();
        this.E = dVar;
        addItemDecoration(dVar);
    }

    private void b0() {
        QLog.e("QGMC.MemberListView", 1, "[initLayoutParams] " + this.f229714m);
        int h16 = MediaChannelUtils.h(this);
        this.f229714m = h16;
        this.f229713i.u0(h16);
        QLog.i("QGMC.MemberListView", 1, "[initLayoutParams] colCount " + this.f229714m);
        ab abVar = new ab(getContext(), this.f229714m * this.F);
        this.D = abVar;
        abVar.setSpanSizeLookup(new e());
        setLayoutManager(this.D);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0() {
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (this.L == 0 && this.M && (layoutManager instanceof LinearLayoutManager)) {
            this.M = false;
            ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(this.K, this.J);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0() {
        if (this.H != null && this.L == 0 && this.M) {
            post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.widget.s
                @Override // java.lang.Runnable
                public final void run() {
                    GuildMediaMemberListView.this.d0();
                }
            });
        }
    }

    private void f0() {
        boolean z16;
        boolean needIgnoreSelf = this.f229713i.getNeedIgnoreSelf();
        LiveData<Integer> T = com.tencent.mobileqq.guild.media.core.j.c().T();
        if (T.getValue() != null && T.getValue().intValue() == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.mobileqq.guild.media.core.data.r userInfoList = com.tencent.mobileqq.guild.media.core.j.c().getUserInfoList();
        if (MediaChannelUtils.m() == 7) {
            this.I.d(MediaChannelUtils.q(userInfoList), new PageLoadLoadParams(needIgnoreSelf, this.G, z16));
        } else {
            this.I.d(userInfoList, new PageLoadLoadParams(needIgnoreSelf, this.G, z16));
        }
    }

    private void g0() {
        if (this.D == null) {
            return;
        }
        int h16 = MediaChannelUtils.h(this);
        if (h16 != this.f229714m) {
            if (QLog.isColorLevel()) {
                QLog.d("QGMC.MemberListView", 2, " raiseUpAnim [getItemOffsets] lastSpanCount " + this.f229714m + " curColumn " + h16);
            }
            this.f229714m = h16;
            this.f229713i.u0(h16);
            f0();
            if (this.f229714m == 1) {
                this.D.setSpanCount(h16 * this.F * 2);
            } else {
                this.D.setSpanCount(h16 * this.F);
            }
            a0();
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QGMC.MemberListView", 2, " raiseUpAnim [getItemOffsets] lastSpanCount --- " + this.f229714m + " curColumn " + h16);
        }
        this.f229714m = h16;
        f0();
        com.tencent.mobileqq.guild.media.widget.adapter.d dVar = this.E;
        if (dVar != null) {
            removeItemDecoration(dVar);
        }
        a0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0(ArrayList<rt1.a> arrayList) {
        if (getItemAnimator() != null && getItemAnimator().isRunning()) {
            this.N = arrayList;
            getItemAnimator().isRunning(new f());
        } else {
            this.f229713i.setItems(arrayList);
            this.N = null;
        }
    }

    public void V() {
        a0();
    }

    public boolean W() {
        RecyclerView.Adapter adapter = getAdapter();
        GridLayoutManager gridLayoutManager = this.D;
        if (gridLayoutManager == null || adapter == null) {
            return false;
        }
        if (gridLayoutManager.findLastCompletelyVisibleItemPosition() >= adapter.getNUM_BACKGOURND_ICON() - 1 && this.D.findFirstCompletelyVisibleItemPosition() <= 0) {
            return false;
        }
        return true;
    }

    public void Y() {
        setAnimation(300);
    }

    public void c0() {
        QLog.e("QGMC.MemberListView", 1, " setUserList userInfoList " + com.tencent.mobileqq.guild.media.core.j.c().getUserInfoList().f228125a.size());
        this.f229712h = com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo();
        IGProChannelInfo channelInfo = com.tencent.mobileqq.guild.media.core.j.a().getChannelInfo();
        this.f229711f = channelInfo;
        if (channelInfo == null) {
            GuildMainFrameUtils.e(com.tencent.mobileqq.guild.media.core.j.a().getGuildID(), com.tencent.mobileqq.guild.media.core.j.a().E(), new d());
        }
        this.f229713i.n0();
        b0();
        V();
    }

    public void h0(BaseMediaUserDelegateAdapter baseMediaUserDelegateAdapter) {
        i0(baseMediaUserDelegateAdapter, false);
    }

    public void i0(BaseMediaUserDelegateAdapter baseMediaUserDelegateAdapter, boolean z16) {
        QLog.e("QGMC.MemberListView", 1, "onCreate start hashCode " + hashCode());
        Context context = getContext();
        if (context instanceof Activity) {
            View findViewById = ((Activity) context).findViewById(R.id.yzs);
            if (findViewById instanceof GuildNestedScrollView) {
                this.H = (GuildNestedScrollView) findViewById;
            }
        }
        GuildNestedScrollView guildNestedScrollView = this.H;
        if (guildNestedScrollView != null) {
            guildNestedScrollView.setRecyclerView(this);
        }
        this.F = MediaChannelUtils.r(this);
        int i3 = com.tencent.mobileqq.guild.media.widget.adapter.c.f229816d;
        setPadding(i3, 0, i3, 0);
        setItemViewCacheSize(12);
        this.f229713i = baseMediaUserDelegateAdapter;
        setItemAnimator(null);
        setAdapter(this.f229713i);
        setClipChildren(false);
        MediaPageDataRepo mediaPageDataRepo = new MediaPageDataRepo();
        this.I = mediaPageDataRepo;
        mediaPageDataRepo.b(this.S);
        com.tencent.mobileqq.guild.media.core.j.a().l0().b(this.T);
        if (this.H != null) {
            addOnScrollListener(this.Q);
            this.f229713i.registerAdapterDataObserver(this.R);
        }
    }

    public void j0(String str) {
        QLog.d("QGMC.MemberListView", 4, "refreshUI from: " + str + " --- " + hashCode());
        this.f229712h = com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo();
        this.f229713i.n0();
        g0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnGlobalLayoutListener(this.P);
        }
        QLog.i("QGMC.MemberListView", 1, hashCode() + ",onAttachedToWindow," + viewTreeObserver + ",isAlive:" + viewTreeObserver.isAlive());
    }

    public void onDestroy() {
        QLog.d("QGMC.MemberListView", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        GuildNestedScrollView guildNestedScrollView = this.H;
        if (guildNestedScrollView != null) {
            if (guildNestedScrollView.getRecyclerView() == this) {
                this.H.setRecyclerView(null);
            }
            removeOnScrollListener(this.Q);
            this.f229713i.unregisterAdapterDataObserver(this.R);
            this.H = null;
        }
        MediaPageDataRepo mediaPageDataRepo = this.I;
        if (mediaPageDataRepo != null) {
            mediaPageDataRepo.o(this.S);
        }
        com.tencent.mobileqq.guild.media.core.j.a().l0().B(this.T);
        setAdapter(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnGlobalLayoutListener(this.P);
        }
        QLog.i("QGMC.MemberListView", 1, hashCode() + ",onDetachedFromWindow," + viewTreeObserver + ",isAlive:" + viewTreeObserver.isAlive());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int i3, int i16) {
        com.tencent.mobileqq.guild.media.core.w.b("QGMC.MemberListView", "onMeasure");
        GuildNestedScrollView guildNestedScrollView = this.H;
        if (guildNestedScrollView != null) {
            super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(guildNestedScrollView.getMeasuredHeight(), Integer.MIN_VALUE));
        } else {
            super.onMeasure(i3, i16);
        }
        com.tencent.mobileqq.guild.media.core.w.a("QGMC.MemberListView", "onMeasure");
    }

    public void setAnimation(int i3) {
        if (getItemAnimator() == null) {
            return;
        }
        long j3 = i3;
        getItemAnimator().setChangeDuration(j3);
        getItemAnimator().setAddDuration(j3);
        getItemAnimator().setRemoveDuration(j3);
        getItemAnimator().setMoveDuration(j3);
    }

    public void setFromQCircle(boolean z16) {
        QLog.i("QGMC.MemberListView", 1, "[setFromQCircle] " + z16);
        this.G = z16;
    }

    public void setNeedIgnoreSelf(boolean z16) {
        this.f229713i.t0(z16);
    }

    public GuildMediaMemberListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f229714m = 1;
        this.C = 300;
        this.F = 5;
        this.G = false;
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.M = false;
        this.P = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.mobileqq.guild.media.widget.r
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                GuildMediaMemberListView.this.e0();
            }
        };
        this.Q = new a();
        this.R = new b();
        this.S = new c();
        this.T = new g();
        QLog.d("QGMC.MemberListView", 4, "constructor hashCode2 " + hashCode());
        QLog.d("QGMC.MemberListView", 4, "constructor hashCode2 " + QLog.getStackTraceString(new Throwable()));
    }

    public GuildMediaMemberListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f229714m = 1;
        this.C = 300;
        this.F = 5;
        this.G = false;
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.M = false;
        this.P = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.mobileqq.guild.media.widget.r
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                GuildMediaMemberListView.this.e0();
            }
        };
        this.Q = new a();
        this.R = new b();
        this.S = new c();
        this.T = new g();
    }
}
