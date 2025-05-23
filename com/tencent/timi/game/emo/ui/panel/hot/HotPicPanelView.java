package com.tencent.timi.game.emo.ui.panel.hot;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bh4.a;
import ch4.RefViewPos;
import ch4.ShowAnimParam;
import ch4.n;
import ch4.x;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.AbstractGifImage;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.component.chat.TimiBaseInputViewV2;
import com.tencent.timi.game.emo.ui.panel.hot.HotPicPanelView;
import com.tencent.timi.game.utils.l;
import fh4.g;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nr2.w;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import xg4.e;
import xg4.m;

@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 j2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0017BE\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010f\u001a\u0004\u0018\u00010e\u0012\b\b\u0002\u0010g\u001a\u00020'\u0012\b\b\u0002\u00103\u001a\u00020/\u0012\b\b\u0002\u00108\u001a\u000204\u0012\b\b\u0002\u0010;\u001a\u00020'\u00a2\u0006\u0004\bh\u0010iJ\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002J\b\u0010\r\u001a\u00020\u0007H\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0002J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0002J\b\u0010\u0013\u001a\u00020\u0007H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0007H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u0018H\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0014H\u0016J\u0018\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0018H\u0016J\b\u0010 \u001a\u00020\u001cH\u0016J\b\u0010!\u001a\u00020\u000fH\u0016J\b\u0010\"\u001a\u00020\u0007H\u0016J\b\u0010#\u001a\u00020\u0007H\u0016J\b\u0010$\u001a\u00020\u0007H\u0016J\b\u0010%\u001a\u00020\u0007H\u0016J\b\u0010&\u001a\u00020\u0007H\u0016J\b\u0010(\u001a\u00020'H\u0016J\u0010\u0010*\u001a\u00020\u00072\u0006\u0010)\u001a\u00020'H\u0016J\b\u0010,\u001a\u00020+H\u0016J\u0010\u0010.\u001a\u00020\u00072\u0006\u0010-\u001a\u00020'H\u0016R\u0017\u00103\u001a\u00020/8\u0006\u00a2\u0006\f\n\u0004\b\u001a\u00100\u001a\u0004\b1\u00102R\u0017\u00108\u001a\u0002048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u00105\u001a\u0004\b6\u00107R\u0017\u0010;\u001a\u00020'8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\f\u001a\u0004\b9\u0010:R\u001c\u0010>\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\f\n\u0004\b(\u0010\n\u0012\u0004\b<\u0010=R\u0016\u0010@\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010?R\u0014\u0010D\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010G\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010I\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010FR\u0014\u0010K\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010FR\u0016\u0010N\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010O\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010MR\u0014\u0010P\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010FR\u0014\u0010Q\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010FR\u0016\u0010R\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\fR\u0016\u0010T\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010\fR\u0016\u0010W\u001a\u00020U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010VR\u0014\u0010Z\u001a\u00020X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010YR \u0010`\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020]0\\0[8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0014\u0010d\u001a\u00020a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bb\u0010c\u00a8\u0006k"}, d2 = {"Lcom/tencent/timi/game/emo/ui/panel/hot/HotPicPanelView;", "Landroid/widget/FrameLayout;", "Lbh4/a;", "Lch4/a;", "Landroid/content/Context;", "context", "v", "", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "J", "L", "I", "H", HippyTKDListViewAdapter.X, "", "targetState", "G", "w", "e", "Landroid/view/View;", "getView", "destroy", "a", "", "onBackEvent", "d", "b", "", "keyword", "withHeightAnim", "f", "j", "getState", "updateUI", "t", "i", "u", "M", "", h.F, c.G, "onPageSelected", "Landroid/graphics/Rect;", "c", "yesGameId", "g", "Lxg4/m;", "Lxg4/m;", "getPanelParam", "()Lxg4/m;", "panelParam", "Lxg4/a;", "Lxg4/a;", "getPanelData", "()Lxg4/a;", "panelData", "getPosition", "()I", "position", "getMState$annotations", "()V", "mState", "Ljava/lang/String;", "mKeyword", "Lch4/x;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lch4/x;", "mSearchResultHelper", BdhLogUtil.LogTag.Tag_Conn, "Landroid/graphics/Rect;", "searchHintTxvPos", "D", "searchAreaPos", "E", "inputLayoutPos", UserInfo.SEX_FEMALE, "Z", "posInitFlag", "posInitCalculating", "inputLayoutInitPos", "searchAreaInitPos", "heightDelta", "K", "parentRootNormalHeight", "Lnr2/w;", "Lnr2/w;", "binding", "Lch4/b;", "Lch4/b;", "mAdapter", "Landroidx/lifecycle/Observer;", "", "Lcom/tencent/mobileqq/emosm/emosearch/EmotionSearchItem;", "N", "Landroidx/lifecycle/Observer;", "mDataObserver", "Lah4/a;", "P", "Lah4/a;", "mReportHelper", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILxg4/m;Lxg4/a;I)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class HotPicPanelView extends FrameLayout implements a, ch4.a {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Rect searchHintTxvPos;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Rect searchAreaPos;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Rect inputLayoutPos;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean posInitFlag;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean posInitCalculating;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Rect inputLayoutInitPos;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Rect searchAreaInitPos;

    /* renamed from: J, reason: from kotlin metadata */
    private int heightDelta;

    /* renamed from: K, reason: from kotlin metadata */
    private int parentRootNormalHeight;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private w binding;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final ch4.b mAdapter;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final Observer<List<EmotionSearchItem>> mDataObserver;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final ah4.a mReportHelper;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final m panelParam;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final xg4.a panelData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int position;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long mState;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mKeyword;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final x mSearchResultHelper;

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0016R\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0016\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\"\u0010\u001d\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001e"}, d2 = {"com/tencent/timi/game/emo/ui/panel/hot/HotPicPanelView$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "newState", "onScrollStateChanged", "", "d", "Z", "getAlreadyAtTopFlag", "()Z", "setAlreadyAtTopFlag", "(Z)V", "alreadyAtTopFlag", "e", "getScrolledAfterFirstAtTop", "setScrolledAfterFirstAtTop", "scrolledAfterFirstAtTop", "f", "I", "getLastDy", "()I", "setLastDy", "(I)V", "lastDy", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b extends RecyclerView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean alreadyAtTopFlag;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private boolean scrolledAfterFirstAtTop;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private int lastDy;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ LinearLayoutManager f376853h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ HotPicPanelView f376854i;

        b(LinearLayoutManager linearLayoutManager, HotPicPanelView hotPicPanelView) {
            this.f376853h = linearLayoutManager;
            this.f376854i = hotPicPanelView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            l.b("HotPicPanelView_", "onScrollStateChanged newState=" + newState + " lastDy:" + this.lastDy);
            if (newState == 0) {
                AbstractGifImage.resumeAll();
                int findLastVisibleItemPosition = this.f376853h.findLastVisibleItemPosition();
                l.h("HotPicPanelView_", 1, "onScrollStateChanged lastVisibleItemIndex:" + findLastVisibleItemPosition + ",itemCount:" + this.f376854i.mAdapter.getNUM_BACKGOURND_ICON() + ", alreadyAtTopFlag:" + this.alreadyAtTopFlag + ",scroll:" + this.f376854i.binding.f421152g.computeVerticalScrollOffset() + ",scrolledAfterFirstAtTop:" + this.scrolledAfterFirstAtTop);
                if (this.f376854i.binding.f421152g.computeVerticalScrollOffset() == 0) {
                    if (this.alreadyAtTopFlag && !this.scrolledAfterFirstAtTop) {
                        this.alreadyAtTopFlag = false;
                        this.f376854i.u();
                    } else {
                        this.alreadyAtTopFlag = true;
                        this.scrolledAfterFirstAtTop = false;
                    }
                } else if (this.lastDy > 0) {
                    this.f376854i.t();
                }
                if (findLastVisibleItemPosition + 1 >= this.f376854i.mAdapter.getNUM_BACKGOURND_ICON()) {
                    e.c.f447981b.h();
                    return;
                }
                return;
            }
            AbstractGifImage.pauseAll();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            boolean z16;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            l.b("HotPicPanelView_", "onScrolled dy=" + dy5);
            this.lastDy = dy5;
            if (this.alreadyAtTopFlag && dy5 != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.scrolledAfterFirstAtTop = z16;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HotPicPanelView(@NotNull Context context) {
        this(context, null, 0, null, null, 0, 62, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(HotPicPanelView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.J();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        l.i("HotPicPanelView_", "searchResultTitleArea click");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(HotPicPanelView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.J();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(HotPicPanelView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mKeyword = "";
        this$0.binding.f421159n.setText("");
        this$0.G(2L);
        this$0.J();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(HotPicPanelView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.e();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(HotPicPanelView this$0, List it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ch4.b bVar = this$0.mAdapter;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        bVar.refresh(it);
        this$0.H();
        this$0.updateUI();
        this$0.mReportHelper.a(it.size());
    }

    private final void G(long targetState) {
        this.mState = targetState;
        updateUI();
    }

    private final void H() {
        this.binding.f421152g.setVisibility(0);
        this.binding.f421149d.setVisibility(4);
        this.binding.f421150e.setVisibility(4);
    }

    private final void I() {
        this.binding.f421152g.setVisibility(4);
        this.binding.f421149d.setVisibility(4);
        this.binding.f421150e.setVisibility(0);
    }

    private final void J() {
        int i3;
        View f06;
        View f07;
        View f08;
        if (!this.posInitFlag) {
            w();
        }
        if (this.binding.f421156k.getVisibility() == 0) {
            this.binding.f421156k.getGlobalVisibleRect(this.searchHintTxvPos);
        }
        this.binding.f421153h.getGlobalVisibleRect(this.searchAreaPos);
        TimiBaseInputViewV2 inputView = this.panelParam.getInputView();
        if (inputView != null && (f08 = inputView.f0()) != null) {
            f08.getGlobalVisibleRect(this.inputLayoutPos);
        }
        l.i("HotPicPanelView_", "posInitFlag:" + this.posInitFlag + ", SearchArea:" + this.searchAreaPos + "InputLayout:" + this.inputLayoutPos + ", SearchHintTxv:" + this.searchHintTxvPos);
        String str = this.mKeyword;
        long j3 = this.mState;
        Rect rect = this.searchAreaPos;
        RefViewPos refViewPos = new RefViewPos(rect.left, rect.top, this.binding.f421153h.getWidth(), this.binding.f421153h.getHeight());
        Rect rect2 = this.inputLayoutInitPos;
        int i16 = rect2.left;
        int i17 = rect2.top;
        TimiBaseInputViewV2 inputView2 = this.panelParam.getInputView();
        int i18 = 0;
        if (inputView2 != null && (f07 = inputView2.f0()) != null) {
            i3 = f07.getWidth();
        } else {
            i3 = 0;
        }
        TimiBaseInputViewV2 inputView3 = this.panelParam.getInputView();
        if (inputView3 != null && (f06 = inputView3.f0()) != null) {
            i18 = f06.getHeight();
        }
        RefViewPos refViewPos2 = new RefViewPos(i16, i17, i3, i18);
        Rect rect3 = this.searchHintTxvPos;
        this.mSearchResultHelper.P(new ShowAnimParam(str, j3, refViewPos, refViewPos2, new RefViewPos(rect3.left, rect3.top, this.binding.f421156k.getWidth(), this.binding.f421156k.getHeight())), new Runnable() { // from class: ch4.i
            @Override // java.lang.Runnable
            public final void run() {
                HotPicPanelView.K(HotPicPanelView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(HotPicPanelView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.M();
    }

    private final void L() {
        this.binding.f421152g.setVisibility(4);
        this.binding.f421149d.setVisibility(0);
        this.binding.f421150e.setVisibility(4);
    }

    private final FrameLayout v(Context context) {
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        View findViewById = ((Activity) context).findViewById(R.id.content);
        Intrinsics.checkNotNullExpressionValue(findViewById, "context as Activity).fin\u2026yId(android.R.id.content)");
        return (FrameLayout) findViewById;
    }

    private final void w() {
        int i3;
        View e06;
        View f06;
        if (this.posInitFlag || this.posInitCalculating) {
            return;
        }
        this.posInitCalculating = true;
        TimiBaseInputViewV2 inputView = this.panelParam.getInputView();
        if (inputView != null && (f06 = inputView.f0()) != null) {
            f06.getGlobalVisibleRect(this.inputLayoutInitPos);
        }
        l.h("HotPicPanelView_", 1, "inputLayoutInitPos: " + this.inputLayoutInitPos);
        TimiBaseInputViewV2 inputView2 = this.panelParam.getInputView();
        if (inputView2 != null && (e06 = inputView2.e0()) != null) {
            i3 = e06.getHeight();
        } else {
            i3 = 0;
        }
        this.parentRootNormalHeight = i3;
        this.heightDelta = i3 / 2;
        l.h("HotPicPanelView_", 1, "func Height: " + i3);
        this.binding.f421153h.getGlobalVisibleRect(this.searchAreaInitPos);
        l.h("HotPicPanelView_", 1, "searchAreaInitPos: " + this.searchAreaInitPos);
        this.posInitFlag = true;
    }

    private final void x() {
        List<String> listOf;
        String[] stringArray = getContext().getResources().getStringArray(com.tencent.mobileqq.R.array.f155245ch);
        Intrinsics.checkNotNullExpressionValue(stringArray, "context.resources.getStr\u2026i_emo_hot_pic_search_tag)");
        listOf = CollectionsKt__CollectionsKt.listOf(Arrays.copyOf(stringArray, stringArray.length));
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        n nVar = new n(context, this);
        nVar.setData(listOf);
        this.binding.f421158m.setAdapter(nVar);
    }

    private final void y() {
        this.binding.f421152g.setAdapter(this.mAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.binding.f421152g.setLayoutManager(linearLayoutManager);
        this.binding.f421152g.addOnScrollListener(new b(linearLayoutManager, this));
        e.c cVar = e.c.f447981b;
        cVar.b().observeForever(this.mDataObserver);
        L();
        cVar.j();
    }

    private final void z() {
        this.binding.f421155j.setOnClickListener(new View.OnClickListener() { // from class: ch4.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HotPicPanelView.A(HotPicPanelView.this, view);
            }
        });
        this.binding.f421157l.setOnClickListener(new View.OnClickListener() { // from class: ch4.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HotPicPanelView.B(view);
            }
        });
        this.binding.f421159n.setOnClickListener(new View.OnClickListener() { // from class: ch4.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HotPicPanelView.C(HotPicPanelView.this, view);
            }
        });
        this.binding.f421148c.setOnClickListener(new View.OnClickListener() { // from class: ch4.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HotPicPanelView.D(HotPicPanelView.this, view);
            }
        });
        this.binding.f421147b.setOnClickListener(new View.OnClickListener() { // from class: ch4.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HotPicPanelView.E(HotPicPanelView.this, view);
            }
        });
    }

    public void M() {
        View e06;
        TimiBaseInputViewV2 inputView = this.panelParam.getInputView();
        if (inputView != null && (e06 = inputView.e0()) != null) {
            g.k(e06, this.parentRootNormalHeight);
        }
    }

    @Override // bh4.a
    @Nullable
    public View b() {
        return this.mSearchResultHelper.w();
    }

    @Override // ch4.a
    @NotNull
    /* renamed from: c, reason: from getter */
    public Rect getSearchAreaInitPos() {
        return this.searchAreaInitPos;
    }

    @Override // bh4.a
    public boolean d() {
        return this.mSearchResultHelper.getShowState();
    }

    @Override // bh4.a
    public void destroy() {
        e.c.f447981b.b().removeObserver(this.mDataObserver);
    }

    @Override // ch4.a
    public void e() {
        this.mKeyword = "";
        this.binding.f421159n.setText("");
        G(1L);
        updateUI();
        L();
        e.c.f447981b.j();
        u();
    }

    @Override // ch4.a
    public void f(@NotNull String keyword, boolean withHeightAnim) {
        boolean z16;
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        l.i("HotPicPanelView_", "doSearch " + keyword);
        this.mKeyword = keyword;
        if (keyword.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            e();
            return;
        }
        this.mState = 2L;
        updateUI();
        L();
        e.c.f447981b.k(keyword);
        if (withHeightAnim) {
            t();
        }
    }

    @Override // ch4.a
    /* renamed from: getState, reason: from getter */
    public long getMState() {
        return this.mState;
    }

    @Override // ch4.a
    /* renamed from: h, reason: from getter */
    public int getHeightDelta() {
        return this.heightDelta;
    }

    @Override // ch4.a
    public void i() {
        View e06;
        if (!this.posInitFlag) {
            w();
        }
        TimiBaseInputViewV2 inputView = this.panelParam.getInputView();
        if (inputView != null && (e06 = inputView.e0()) != null) {
            g.k(e06, this.parentRootNormalHeight + this.heightDelta);
        }
    }

    @Override // ch4.a
    @NotNull
    /* renamed from: j, reason: from getter */
    public String getMKeyword() {
        return this.mKeyword;
    }

    @Override // bh4.a
    public boolean onBackEvent() {
        return this.mSearchResultHelper.E();
    }

    public void t() {
        View e06;
        if (!this.posInitFlag) {
            w();
        }
        TimiBaseInputViewV2 inputView = this.panelParam.getInputView();
        if (inputView != null && (e06 = inputView.e0()) != null) {
            g.l(e06, this.parentRootNormalHeight + this.heightDelta, 300L);
        }
    }

    public void u() {
        View e06;
        TimiBaseInputViewV2 inputView = this.panelParam.getInputView();
        if (inputView != null && (e06 = inputView.e0()) != null) {
            g.l(e06, this.parentRootNormalHeight, 300L);
        }
    }

    @Override // ch4.a
    public void updateUI() {
        this.binding.f421159n.setText(this.mKeyword);
        long j3 = this.mState;
        boolean z16 = false;
        if (j3 == 1) {
            this.binding.f421155j.setVisibility(0);
            this.binding.f421157l.setVisibility(8);
            this.binding.f421158m.setVisibility(0);
        } else if (j3 == 2) {
            this.binding.f421155j.setVisibility(8);
            this.binding.f421157l.setVisibility(0);
            this.binding.f421158m.setVisibility(8);
        }
        if (this.mAdapter.getNUM_BACKGOURND_ICON() > 0) {
            H();
            return;
        }
        if (this.mKeyword.length() > 0) {
            z16 = true;
        }
        if (z16) {
            I();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HotPicPanelView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, null, null, 0, 60, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HotPicPanelView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, null, null, 0, 56, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ HotPicPanelView(Context context, AttributeSet attributeSet, int i3, m mVar, xg4.a aVar, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? new m(context, null, 0L, null, null, null, 0, 126, null) : mVar, (i17 & 16) != 0 ? new xg4.a(0L, 0L, 0, null, 15, null) : aVar, (i17 & 32) == 0 ? i16 : 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HotPicPanelView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, @NotNull m panelParam, @NotNull xg4.a panelData, int i16) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(panelParam, "panelParam");
        Intrinsics.checkNotNullParameter(panelData, "panelData");
        this.panelParam = panelParam;
        this.panelData = panelData;
        this.position = i16;
        this.mState = 1L;
        this.mKeyword = "";
        Activity activity = (Activity) context;
        ViewGroup pageRoot = panelParam.getPageRoot();
        this.mSearchResultHelper = new x(activity, pageRoot == null ? v(context) : pageRoot, this);
        this.searchHintTxvPos = new Rect();
        this.searchAreaPos = new Rect();
        this.inputLayoutPos = new Rect();
        this.inputLayoutInitPos = new Rect();
        this.searchAreaInitPos = new Rect();
        this.mAdapter = new ch4.b(context, 4, panelParam, panelData);
        this.mDataObserver = new Observer() { // from class: ch4.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HotPicPanelView.F(HotPicPanelView.this, (List) obj);
            }
        };
        ah4.a aVar = new ah4.a(2L);
        this.mReportHelper = aVar;
        if (panelParam.getPageRoot() == null) {
            l.e("HotPicPanelView_", "panelParam.pageRoot is null!");
        }
        w g16 = w.g(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.binding = g16;
        x();
        z();
        aVar.b();
        y();
    }

    @Override // bh4.a
    public void a() {
    }

    @Override // bh4.a
    @NotNull
    public View getView() {
        return this;
    }

    @Override // bh4.a
    public void g(int yesGameId) {
    }

    @Override // bh4.a
    public void onPageSelected(int pos) {
    }
}
