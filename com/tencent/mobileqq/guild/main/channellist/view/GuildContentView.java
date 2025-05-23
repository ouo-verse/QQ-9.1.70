package com.tencent.mobileqq.guild.main.channellist.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewStub;
import androidx.recyclerview.widget.RecyclerView;
import ar1.h;
import ar1.j;
import br1.a;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.guild.main.channellist.logic.AdapterPoolsHolder;
import com.tencent.mobileqq.guild.main.channellist.view.GuildContentView;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.widget.RadiusFrameLayout;
import com.tencent.mobileqq.guild.widget.af;
import com.tencent.mobileqq.guild.widget.y;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vp1.bu;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 82\u00020\u0001:\u00019B\u001d\b\u0007\u0012\u0006\u00103\u001a\u000202\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u000104\u00a2\u0006\u0004\b6\u00107J0\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0014J\b\u0010\u000b\u001a\u00020\tH\u0014J\b\u0010\f\u001a\u00020\tH\u0014R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u001e\u00101\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/guild/main/channellist/view/GuildContentView;", "Lcom/tencent/mobileqq/guild/widget/RadiusFrameLayout;", "", "changed", "", "left", "top", "right", "bottom", "", "onLayout", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Landroidx/recyclerview/widget/RecyclerView;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "D", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "refreshLayout", "Lcom/tencent/mobileqq/guild/main/channellist/view/RefreshHeader;", "E", "Lcom/tencent/mobileqq/guild/main/channellist/view/RefreshHeader;", "refreshHeader", "Landroid/view/ViewStub;", UserInfo.SEX_FEMALE, "Landroid/view/ViewStub;", "stubBubbleLayout", "Lar1/h;", "G", "Lar1/h;", "channelUnreadRedPointDragHandler", "Lbr1/a;", "H", "Lbr1/a;", "hostUiDataProvider", "Lar1/j;", "I", "Lar1/j;", "summaryUpdateHelper", "Lvp1/bu;", "J", "Lvp1/bu;", "binding", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/guild/widget/af;", "K", "Lmqq/util/WeakReference;", "weakRefreshStateAware", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "L", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildContentView extends RadiusFrameLayout {

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static WeakReference<DragFrameLayout> M = new WeakReference<>(null);

    @NotNull
    private static AdapterPoolsHolder N = new AdapterPoolsHolder();
    private static final float P = QQGuildUIUtil.f(8.0f);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final RecyclerView recyclerView;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final SmartRefreshLayout refreshLayout;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final RefreshHeader refreshHeader;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final ViewStub stubBubbleLayout;

    /* renamed from: G, reason: from kotlin metadata */
    private h channelUnreadRedPointDragHandler;

    /* renamed from: H, reason: from kotlin metadata */
    private a hostUiDataProvider;

    /* renamed from: I, reason: from kotlin metadata */
    private j summaryUpdateHelper;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final bu binding;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private WeakReference<af> weakRefreshStateAware;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/main/channellist/view/GuildContentView$a;", "", "", "radiusLeftTop", UserInfo.SEX_FEMALE, "a", "()F", "", "TAG", "Ljava/lang/String;", "Lcom/tencent/mobileqq/guild/main/channellist/logic/AdapterPoolsHolder;", "adapterPoolsHolder", "Lcom/tencent/mobileqq/guild/main/channellist/logic/AdapterPoolsHolder;", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/activity/recent/cur/DragFrameLayout;", "dragViewRef", "Lmqq/util/WeakReference;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.main.channellist.view.GuildContentView$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final float a() {
            return GuildContentView.P;
        }

        Companion() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildContentView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(GuildContentView this$0, boolean z16) {
        af afVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WeakReference<af> weakReference = this$0.weakRefreshStateAware;
        if (weakReference != null && (afVar = weakReference.get()) != null) {
            afVar.setRefreshState(z16);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        h hVar;
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        while (true) {
            hVar = null;
            if (parent != null) {
                if (parent instanceof af) {
                    break;
                } else {
                    parent = parent.getParent();
                }
            } else {
                parent = null;
                break;
            }
        }
        this.weakRefreshStateAware = new WeakReference<>(parent);
        ViewParent parent2 = getParent();
        while (true) {
            if (parent2 != null) {
                if (parent2 instanceof y) {
                    break;
                } else {
                    parent2 = parent2.getParent();
                }
            } else {
                parent2 = null;
                break;
            }
        }
        y yVar = (y) parent2;
        if (yVar != null) {
            yVar.addRecyclerView(this.recyclerView);
        }
        M = new WeakReference<>(null);
        ViewParent parent3 = getParent();
        while (true) {
            if (parent3 != null) {
                if (parent3 instanceof DragFrameLayout) {
                    break;
                } else {
                    parent3 = parent3.getParent();
                }
            } else {
                parent3 = null;
                break;
            }
        }
        DragFrameLayout dragFrameLayout = (DragFrameLayout) parent3;
        if (dragFrameLayout == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("onAttachedToWindow: can not find DragFrameLayout");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.MF.GuildContentView", 1, (String) it.next(), null);
            }
            return;
        }
        M = new WeakReference<>(dragFrameLayout);
        h hVar2 = this.channelUnreadRedPointDragHandler;
        if (hVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelUnreadRedPointDragHandler");
        } else {
            hVar = hVar2;
        }
        hVar.a(dragFrameLayout);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        DragFrameLayout dragFrameLayout = M.get();
        if (dragFrameLayout == null) {
            return;
        }
        h hVar = this.channelUnreadRedPointDragHandler;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelUnreadRedPointDragHandler");
            hVar = null;
        }
        hVar.b(dragFrameLayout);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        Object m476constructorimpl;
        super.onLayout(changed, left, top, right, bottom);
        try {
            Result.Companion companion = Result.INSTANCE;
            Logger.a d16 = Logger.f235387a.d();
            Object obj = M.get();
            a aVar = this.hostUiDataProvider;
            a aVar2 = null;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hostUiDataProvider");
                aVar = null;
            }
            d16.d("Guild.MF.GuildContentView", 1, "onLayout(" + changed + ", " + left + ", " + top + ", " + right + ", " + bottom + "): " + obj + ", tabHeight = " + aVar.a());
            int paddingBottom = this.recyclerView.getPaddingBottom();
            a aVar3 = this.hostUiDataProvider;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hostUiDataProvider");
                aVar3 = null;
            }
            if (paddingBottom != aVar3.a()) {
                RecyclerView recyclerView = this.recyclerView;
                a aVar4 = this.hostUiDataProvider;
                if (aVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("hostUiDataProvider");
                } else {
                    aVar2 = aVar4;
                }
                ViewExtKt.c(recyclerView, aVar2.a());
            }
            m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "onLayout: " + m479exceptionOrNullimpl.getMessage();
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.MF.GuildContentView", 1, (String) it.next(), m479exceptionOrNullimpl);
            }
        }
    }

    public /* synthetic */ GuildContentView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildContentView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        bu f16 = bu.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        e(P, 0.0f, 0.0f, 0.0f);
        View findViewById = findViewById(R.id.f72333qk);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.refresh_layout)");
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) findViewById;
        this.refreshLayout = smartRefreshLayout;
        View findViewById2 = findViewById(R.id.f72303qh);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.refresh_header)");
        RefreshHeader refreshHeader = (RefreshHeader) findViewById2;
        this.refreshHeader = refreshHeader;
        View findViewById3 = findViewById(R.id.ts5);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.channel_list)");
        RecyclerView recyclerView = (RecyclerView) findViewById3;
        this.recyclerView = recyclerView;
        View findViewById4 = findViewById(R.id.f89384zm);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.stub_unread_bubble)");
        this.stubBubbleLayout = (ViewStub) findViewById4;
        recyclerView.setOverScrollMode(2);
        smartRefreshLayout.setEnableLoadMore(false).setEnableOverScrollBounce(true).setEnableOverScrollDrag(true);
        refreshHeader.setRefreshStateListener(new af() { // from class: fr1.a
            @Override // com.tencent.mobileqq.guild.widget.af
            public final void setRefreshState(boolean z16) {
                GuildContentView.g(GuildContentView.this, z16);
            }
        });
        onFinishInflate();
    }
}
