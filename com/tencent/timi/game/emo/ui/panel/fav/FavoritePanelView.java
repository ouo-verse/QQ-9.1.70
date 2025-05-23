package com.tencent.timi.game.emo.ui.panel.fav;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.timi.game.utils.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.YesGameInfoOuterClass$GameConfigInfo;
import xg4.e;
import xg4.m;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 82\u00020\u00012\u00020\u0002:\u0001\u000eB;\b\u0007\u0012\u0006\u00102\u001a\u000201\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u000103\u0012\b\b\u0002\u00105\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0017\u00a2\u0006\u0004\b6\u00107J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u0016\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001c\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R \u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(0'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00069"}, d2 = {"Lcom/tencent/timi/game/emo/ui/panel/fav/FavoritePanelView;", "Landroid/widget/FrameLayout;", "Lbh4/a;", "", "yesGameId", "", "f", "Landroid/view/View;", "getView", "destroy", "a", "", "onBackEvent", "d", "b", com.tencent.luggage.wxa.c8.c.G, "onPageSelected", "g", "Lxg4/m;", "Lxg4/m;", "getPanelParam", "()Lxg4/m;", "panelParam", "Lxg4/a;", "e", "Lxg4/a;", "getPanelData", "()Lxg4/a;", "panelData", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "mRecyclerView", "Lcom/tencent/timi/game/emo/ui/panel/fav/a;", tl.h.F, "Lcom/tencent/timi/game/emo/ui/panel/fav/a;", "mAdapter", "i", "Z", "mNeedEditAction", "Landroidx/lifecycle/Observer;", "", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/Observer;", "mDataObserver", "Lah4/a;", BdhLogUtil.LogTag.Tag_Conn, "Lah4/a;", "mReportHelper", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILxg4/m;Lxg4/a;)V", "D", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class FavoritePanelView extends FrameLayout implements bh4.a {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ah4.a mReportHelper;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final m panelParam;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final xg4.a panelData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclerView mRecyclerView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.timi.game.emo.ui.panel.fav.a mAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mNeedEditAction;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<List<EmoticonInfo>> mDataObserver;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/timi/game/emo/ui/panel/fav/FavoritePanelView$a", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            l.i("FavoritePanelView_", "onScrollStateChanged newState:" + newState);
            if (newState == 0) {
                AbstractGifImage.resumeAll();
            } else {
                AbstractGifImage.pauseAll();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FavoritePanelView(@NotNull Context context) {
        this(context, null, 0, null, null, 30, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(FavoritePanelView this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ArrayList arrayList = new ArrayList();
        l.i("FavoritePanelView_", "refresh data. mNeedEditAction:" + this$0.mNeedEditAction);
        if (this$0.mNeedEditAction) {
            EmoticonInfo emoticonInfo = new EmoticonInfo();
            emoticonInfo.action = EmoticonInfo.FAV_EDIT_ACTION;
            arrayList.add(emoticonInfo);
        }
        EmoticonInfo emoticonInfo2 = new EmoticonInfo();
        emoticonInfo2.action = "funny_pic";
        arrayList.add(emoticonInfo2);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            EmoticonInfo emoticonInfo3 = (EmoticonInfo) it.next();
            if (emoticonInfo3 instanceof EmoticonInfo) {
                arrayList.add(emoticonInfo3);
            }
        }
        this$0.mAdapter.refresh(arrayList);
        this$0.mReportHelper.a(arrayList.size());
    }

    private final void f(int yesGameId) {
        l.i("FavoritePanelView_", "updateNeedEditAction yesGameId:" + yesGameId);
        if (yesGameId == -1) {
            return;
        }
        YesGameInfoOuterClass$GameConfigInfo l16 = ((ag4.h) mm4.b.b(ag4.h.class)).l1(yesGameId);
        Intrinsics.checkNotNullExpressionValue(l16, "getService(IGameConfigSe\u2026GameConfigInfo(yesGameId)");
        boolean z16 = true;
        if (l16.game_input_common.add_fav_emo_entrance.get() != 1) {
            z16 = false;
        }
        this.mNeedEditAction = z16;
        l.i("FavoritePanelView_", "mNeedEditAction:" + z16);
    }

    @Override // bh4.a
    public void a() {
        e.b.f447979b.d();
    }

    @Override // bh4.a
    @Nullable
    public View b() {
        return null;
    }

    @Override // bh4.a
    public boolean d() {
        return false;
    }

    @Override // bh4.a
    public void destroy() {
        e.b.f447979b.b().removeObserver(this.mDataObserver);
    }

    @Override // bh4.a
    public void g(int yesGameId) {
        l.i("FavoritePanelView_", "updateYesGameId:" + yesGameId);
        f(yesGameId);
    }

    @Override // bh4.a
    public boolean onBackEvent() {
        return false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FavoritePanelView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, null, null, 28, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FavoritePanelView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, null, null, 24, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ FavoritePanelView(Context context, AttributeSet attributeSet, int i3, m mVar, xg4.a aVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3, (i16 & 8) != 0 ? new m(context, null, 0L, null, null, null, 0, 126, null) : mVar, (i16 & 16) != 0 ? new xg4.a(0L, 0L, 0, null, 15, null) : aVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FavoritePanelView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, @NotNull m panelParam, @NotNull xg4.a panelData) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(panelParam, "panelParam");
        Intrinsics.checkNotNullParameter(panelData, "panelData");
        this.panelParam = panelParam;
        this.panelData = panelData;
        RecyclerView recyclerView = new RecyclerView(context);
        this.mRecyclerView = recyclerView;
        com.tencent.timi.game.emo.ui.panel.fav.a aVar = new com.tencent.timi.game.emo.ui.panel.fav.a(context, 4, panelParam, panelData);
        this.mAdapter = aVar;
        Observer<List<EmoticonInfo>> observer = new Observer() { // from class: com.tencent.timi.game.emo.ui.panel.fav.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FavoritePanelView.e(FavoritePanelView.this, (List) obj);
            }
        };
        this.mDataObserver = observer;
        ah4.a aVar2 = new ah4.a(1L);
        this.mReportHelper = aVar2;
        f(panelParam.getYesGameId());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(1);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setOverScrollMode(2);
        addView(recyclerView, new FrameLayout.LayoutParams(-1, -1));
        recyclerView.setAdapter(aVar);
        aVar2.b();
        e.b bVar = e.b.f447979b;
        bVar.b().observeForever(observer);
        bVar.d();
        AbstractGifImage.resumeAll();
        recyclerView.addOnScrollListener(new a());
    }

    @Override // bh4.a
    @NotNull
    public View getView() {
        return this;
    }

    @Override // bh4.a
    public void onPageSelected(int pos) {
    }
}
