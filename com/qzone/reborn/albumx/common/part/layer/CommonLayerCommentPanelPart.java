package com.qzone.reborn.albumx.common.part.layer;

import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.reborn.albumx.common.layer.part.i;
import com.qzone.reborn.albumx.common.viewmodel.CommonCommentBusinessViewModel;
import com.qzone.reborn.feedx.block.aa;
import com.qzone.reborn.widget.GroupAlbumBlankStateView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenImmersiveFloatingView;
import com.tencent.mobileqq.widget.qus.e;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l9.g;
import tl.h;

@Metadata(d1 = {"\u0000\u00ac\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\b&\u0018\u0000 i*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u0003:\u0001jB\u0007\u00a2\u0006\u0004\bg\u0010hJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u0016\u0010\u0010\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u0016\u0010\u0011\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0003J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0002J\u0016\u0010\u0018\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\b\u0010\u001a\u001a\u00020\u0019H$J\b\u0010\u001c\u001a\u00020\u001bH$J\u0012\u0010\u001e\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010!\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0007H\u0014J\b\u0010$\u001a\u00020\u0004H\u0016J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u001c\u0010)\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010\u001b2\b\u0010(\u001a\u0004\u0018\u00010'H\u0016J\b\u0010*\u001a\u00020\u0004H\u0014J\b\u0010+\u001a\u00020\u0012H\u0016J\u0014\u0010/\u001a\u0004\u0018\u00010.2\b\u0010-\u001a\u0004\u0018\u00010,H\u0014R\u0018\u00102\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010R\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010V\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010X\u001a\u00020?8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bW\u0010AR\u001b\u0010]\u001a\u00020\u00198DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\R\u0016\u0010`\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u001c\u0010f\u001a\n d*\u0004\u0018\u00010\u001b0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\be\u0010b\u00a8\u0006k"}, d2 = {"Lcom/qzone/reborn/albumx/common/part/layer/CommonLayerCommentPanelPart;", "T", "Lcom/qzone/reborn/albumx/common/layer/part/i;", "Lcom/tencent/biz/richframework/preload/recyclerview/ILoadMoreProvider$LoadMoreListener;", "", "initViewModel", "R9", "Landroid/view/View;", "contentView", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenImmersiveFloatingView;", "K9", "X9", "J9", "Lcom/tencent/richframework/data/base/UIStateData;", "Lci/d;", "uiStateData", "P9", "Y9", "", "isLoading", "hasMore", "Z9", "Q9", "aa", "ba", "Lcom/qzone/reborn/albumx/common/viewmodel/CommonCommentBusinessViewModel;", "L9", "", "O9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "commentView", "V9", "onLoadMoreStart", "onLoadMoreEnd", "action", "", "args", "handleBroadcastMessage", "showCommentPanel", "onBackEvent", "Landroid/content/Context;", "context", "Luc/a;", "M9", h.F, "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenImmersiveFloatingView;", "halfScreenFloatingView", "Landroid/widget/LinearLayout;", "i", "Landroid/widget/LinearLayout;", "mAnimView", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "mCloseIcon", "Landroidx/recyclerview/widget/RecyclerView;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/recyclerview/widget/RecyclerView;", "mRecyclerView", "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "mTitleTextView", "Landroid/widget/FrameLayout;", "E", "Landroid/widget/FrameLayout;", "recyclerViewContainer", "Lcom/qzone/reborn/widget/GroupAlbumBlankStateView;", UserInfo.SEX_FEMALE, "Lcom/qzone/reborn/widget/GroupAlbumBlankStateView;", "mBlankView", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "G", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "mConcatAdapter", "Lcom/qzone/reborn/feedx/block/aa;", "H", "Lcom/qzone/reborn/feedx/block/aa;", "mLoadMoreAdapter", "Li9/d;", "I", "Li9/d;", "mCommentListAdapter", "J", "commentTextView", "K", "Lkotlin/Lazy;", "N9", "()Lcom/qzone/reborn/albumx/common/viewmodel/CommonCommentBusinessViewModel;", "mCommentViewModel", "L", "Z", "mIsInit", "M", "Ljava/lang/String;", "mLastUniqueId", "kotlin.jvm.PlatformType", "N", "mTitle", "<init>", "()V", "P", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class CommonLayerCommentPanelPart<T> extends i<T> implements ILoadMoreProvider$LoadMoreListener {

    /* renamed from: P, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String Q = "open_comment_panel_view";
    private static final int R = ImmersiveUtils.dpToPx(400.0f);
    private static final int S = ImmersiveUtils.dpToPx(568.0f);

    /* renamed from: C, reason: from kotlin metadata */
    private RecyclerView mRecyclerView;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView mTitleTextView;

    /* renamed from: E, reason: from kotlin metadata */
    private FrameLayout recyclerViewContainer;

    /* renamed from: F, reason: from kotlin metadata */
    private GroupAlbumBlankStateView mBlankView;

    /* renamed from: G, reason: from kotlin metadata */
    private RFWConcatAdapter mConcatAdapter;

    /* renamed from: H, reason: from kotlin metadata */
    private aa mLoadMoreAdapter;

    /* renamed from: I, reason: from kotlin metadata */
    private i9.d mCommentListAdapter;

    /* renamed from: J, reason: from kotlin metadata */
    private TextView commentTextView;

    /* renamed from: K, reason: from kotlin metadata */
    private final Lazy mCommentViewModel;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean mIsInit;

    /* renamed from: M, reason: from kotlin metadata */
    private String mLastUniqueId;

    /* renamed from: N, reason: from kotlin metadata */
    private final String mTitle;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QUSHalfScreenImmersiveFloatingView halfScreenFloatingView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mAnimView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView mCloseIcon;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004\u00a8\u0006\u000e"}, d2 = {"Lcom/qzone/reborn/albumx/common/part/layer/CommonLayerCommentPanelPart$a;", "", "", "OPEN_COMMENT_PANEL_VIEW", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "", "LANDSCAPE_HEIGHT", "I", "PORTRAIT_HEIGHT", "TAG", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.albumx.common.part.layer.CommonLayerCommentPanelPart$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return CommonLayerCommentPanelPart.Q;
        }

        Companion() {
        }
    }

    public CommonLayerCommentPanelPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<CommonCommentBusinessViewModel>(this) { // from class: com.qzone.reborn.albumx.common.part.layer.CommonLayerCommentPanelPart$mCommentViewModel$2
            final /* synthetic */ CommonLayerCommentPanelPart<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CommonCommentBusinessViewModel invoke() {
                return this.this$0.L9();
            }
        });
        this.mCommentViewModel = lazy;
        this.mTitle = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewCommentReply", "\u8bc4\u8bba\u56de\u590d");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void J9() {
        int i3;
        ViewGroup.LayoutParams layoutParams;
        FrameLayout frameLayout;
        if (this.recyclerViewContainer == null) {
            return;
        }
        pl.a aVar = pl.a.f426446a;
        if (aVar.x()) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            if (aVar.z(context)) {
                i3 = R;
                FrameLayout frameLayout2 = this.recyclerViewContainer;
                layoutParams = frameLayout2 == null ? frameLayout2.getLayoutParams() : null;
                if (layoutParams != null) {
                    layoutParams.height = i3;
                }
                frameLayout = this.recyclerViewContainer;
                if (frameLayout != null) {
                    return;
                }
                frameLayout.setLayoutParams(layoutParams);
                return;
            }
        }
        i3 = S;
        FrameLayout frameLayout22 = this.recyclerViewContainer;
        if (frameLayout22 == null) {
        }
        if (layoutParams != null) {
        }
        frameLayout = this.recyclerViewContainer;
        if (frameLayout != null) {
        }
    }

    private final QUSHalfScreenImmersiveFloatingView K9(View contentView) {
        QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView = new QUSHalfScreenImmersiveFloatingView(getContext());
        qUSHalfScreenImmersiveFloatingView.setBackgroundColor(0);
        qUSHalfScreenImmersiveFloatingView.setIgnoreHorizontalMove(true);
        qUSHalfScreenImmersiveFloatingView.setIsContentDraggable(false);
        qUSHalfScreenImmersiveFloatingView.q();
        qUSHalfScreenImmersiveFloatingView.setIsHeightWrapContent(true);
        qUSHalfScreenImmersiveFloatingView.setQUSDragFloatController(new b(contentView));
        return qUSHalfScreenImmersiveFloatingView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P9(UIStateData<ci.d> uiStateData) {
        int state = uiStateData.getState();
        if (state == 0) {
            aa();
        } else if (state == 2 || state == 3) {
            if (Intrinsics.areEqual(O9(), uiStateData.getData().getId())) {
                Y9(uiStateData);
            }
        } else if (state == 4) {
            ba(uiStateData);
        }
        Z9(uiStateData.isLoading(), !uiStateData.getIsFinish());
    }

    private final void Q9() {
        RFWLog.d(getTAG(), RFWLog.USR, "hide empty view");
        GroupAlbumBlankStateView groupAlbumBlankStateView = this.mBlankView;
        if (groupAlbumBlankStateView != null) {
            groupAlbumBlankStateView.o0();
        }
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            return;
        }
        recyclerView.setVisibility(0);
    }

    private final void R9() {
        GroupAlbumBlankStateView groupAlbumBlankStateView;
        View partRootView = getPartRootView();
        final View commentView = LayoutInflater.from(partRootView != null ? partRootView.getContext() : null).inflate(R.layout.f1275610, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(commentView, "commentView");
        V9(commentView);
        this.recyclerViewContainer = (FrameLayout) commentView.findViewById(R.id.f19886w);
        View findViewById = commentView.findViewById(R.id.f20107h);
        Intrinsics.checkNotNullExpressionValue(findViewById, "commentView.findViewById(R.id.common_text_input)");
        TextView textView = (TextView) findViewById;
        this.commentTextView = textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commentTextView");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.albumx.common.part.layer.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommonLayerCommentPanelPart.S9(commentView, view);
            }
        });
        this.mTitleTextView = (TextView) commentView.findViewById(R.id.f20117i);
        this.mAnimView = (LinearLayout) commentView.findViewById(R.id.f19866u);
        ImageView imageView = (ImageView) commentView.findViewById(R.id.f19896x);
        this.mCloseIcon = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.albumx.common.part.layer.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CommonLayerCommentPanelPart.U9(CommonLayerCommentPanelPart.this, view);
                }
            });
        }
        this.mRecyclerView = (RecyclerView) commentView.findViewById(R.id.f19876v);
        this.mBlankView = (GroupAlbumBlankStateView) commentView.findViewById(R.id.f19856t);
        View partRootView2 = getPartRootView();
        uc.a M9 = M9(partRootView2 != null ? partRootView2.getContext() : null);
        if (M9 != null && (groupAlbumBlankStateView = this.mBlankView) != null) {
            groupAlbumBlankStateView.setData(M9);
        }
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.setItemAnimator(null);
        }
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(new SafeLinearLayoutManager(getContext()));
        }
        X9();
        RecyclerView recyclerView3 = this.mRecyclerView;
        if (recyclerView3 != null) {
            recyclerView3.setAdapter(this.mConcatAdapter);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        commentView.setLayoutParams(layoutParams);
        QUSHalfScreenImmersiveFloatingView K9 = K9(commentView);
        this.halfScreenFloatingView = K9;
        if ((K9 != null ? K9.getParent() : null) == null) {
            View partRootView3 = getPartRootView();
            Intrinsics.checkNotNull(partRootView3, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) partRootView3).addView(this.halfScreenFloatingView);
        }
        QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView = this.halfScreenFloatingView;
        if (qUSHalfScreenImmersiveFloatingView == null) {
            return;
        }
        qUSHalfScreenImmersiveFloatingView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(View view, View view2) {
        EventCollector.getInstance().onViewClickedBefore(view2);
        RFWIocAbilityProvider.g().getIoc(g.class).originView(view).done(new OnPromiseResolved() { // from class: com.qzone.reborn.albumx.common.part.layer.d
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                CommonLayerCommentPanelPart.T9((g) obj);
            }
        }).run();
        EventCollector.getInstance().onViewClicked(view2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(g gVar) {
        gVar.d6();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(CommonLayerCommentPanelPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView = this$0.halfScreenFloatingView;
        if (qUSHalfScreenImmersiveFloatingView != null) {
            qUSHalfScreenImmersiveFloatingView.t();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void X9() {
        i9.d dVar = new i9.d();
        dVar.setHasStableIds(true);
        this.mCommentListAdapter = dVar;
        aa aaVar = new aa();
        aaVar.registerLoadMoreListener(this);
        aaVar.p0(new aa.a().e(HardCodeUtil.qqStr(R.string.f133235k)).f(HardCodeUtil.qqStr(R.string.f133245l)));
        aaVar.setHasStableIds(true);
        this.mLoadMoreAdapter = aaVar;
        this.mConcatAdapter = new RFWConcatAdapter(new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build(), (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{this.mCommentListAdapter, this.mLoadMoreAdapter});
    }

    private final void Y9(UIStateData<ci.d> uiStateData) {
        i9.d dVar = this.mCommentListAdapter;
        if (dVar != null) {
            RFWLog.i(getTAG(), RFWLog.USR, "set data to comment list");
            List<Comment> a16 = uiStateData.getData().a();
            if (a16 == null) {
                QLog.e(getTAG(), 1, "list is null");
                return;
            }
            List<Comment> list = a16;
            if (true ^ list.isEmpty()) {
                Q9();
            } else {
                aa();
            }
            dVar.setItems(new ArrayList(list));
        }
        int f26 = N9().f2(O9());
        if (f26 > 0) {
            TextView textView = this.mTitleTextView;
            if (textView == null) {
                return;
            }
            textView.setText(this.mTitle + "(" + f26 + ")");
            return;
        }
        TextView textView2 = this.mTitleTextView;
        if (textView2 == null) {
            return;
        }
        textView2.setText(HardCodeUtil.qqStr(R.string.f133646o));
    }

    private final void Z9(boolean isLoading, boolean hasMore) {
        aa aaVar = this.mLoadMoreAdapter;
        if (aaVar != null) {
            aaVar.setLoadState(isLoading, hasMore);
        }
    }

    private final void aa() {
        RecyclerView recyclerView;
        GroupAlbumBlankStateView groupAlbumBlankStateView = this.mBlankView;
        boolean z16 = false;
        if (groupAlbumBlankStateView != null && groupAlbumBlankStateView.q0()) {
            z16 = true;
        }
        if (!z16 || (recyclerView = this.mRecyclerView) == null) {
            return;
        }
        recyclerView.setVisibility(8);
    }

    private final void ba(UIStateData<ci.d> uiStateData) {
        RecyclerView recyclerView;
        if (uiStateData.getIsLoadMore()) {
            return;
        }
        GroupAlbumBlankStateView groupAlbumBlankStateView = this.mBlankView;
        boolean z16 = false;
        if (groupAlbumBlankStateView != null && groupAlbumBlankStateView.r0()) {
            z16 = true;
        }
        if (!z16 || (recyclerView = this.mRecyclerView) == null) {
            return;
        }
        recyclerView.setVisibility(8);
    }

    private final void initViewModel() {
        MutableLiveData<UIStateData<ci.d>> b26 = N9().b2();
        final Function1<UIStateData<ci.d>, Unit> function1 = new Function1<UIStateData<ci.d>, Unit>(this) { // from class: com.qzone.reborn.albumx.common.part.layer.CommonLayerCommentPanelPart$initViewModel$1
            final /* synthetic */ CommonLayerCommentPanelPart<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<ci.d> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<ci.d> it) {
                CommonLayerCommentPanelPart<T> commonLayerCommentPanelPart = this.this$0;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                commonLayerCommentPanelPart.P9(it);
            }
        };
        b26.observeForever(new Observer() { // from class: com.qzone.reborn.albumx.common.part.layer.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CommonLayerCommentPanelPart.W9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract CommonCommentBusinessViewModel L9();

    protected abstract uc.a M9(Context context);

    /* JADX INFO: Access modifiers changed from: protected */
    public final CommonCommentBusinessViewModel N9() {
        return (CommonCommentBusinessViewModel) this.mCommentViewModel.getValue();
    }

    protected abstract String O9();

    /* JADX INFO: Access modifiers changed from: protected */
    public void V9(View commentView) {
        Intrinsics.checkNotNullParameter(commentView, "commentView");
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String action, Object args) {
        super.handleBroadcastMessage(action, args);
        if (Intrinsics.areEqual(action, Q)) {
            showCommentPanel();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView = this.halfScreenFloatingView;
        if (qUSHalfScreenImmersiveFloatingView != null) {
            Intrinsics.checkNotNull(qUSHalfScreenImmersiveFloatingView);
            if (qUSHalfScreenImmersiveFloatingView.getVisibility() == 0) {
                QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView2 = this.halfScreenFloatingView;
                Intrinsics.checkNotNull(qUSHalfScreenImmersiveFloatingView2);
                qUSHalfScreenImmersiveFloatingView2.t();
                return true;
            }
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView = this.halfScreenFloatingView;
        boolean z16 = false;
        if (qUSHalfScreenImmersiveFloatingView != null && qUSHalfScreenImmersiveFloatingView.getVisibility() == 0) {
            z16 = true;
        }
        if (!z16) {
            R9();
            QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView2 = this.halfScreenFloatingView;
            if (qUSHalfScreenImmersiveFloatingView2 != null) {
                qUSHalfScreenImmersiveFloatingView2.setVisibility(8);
            }
            this.halfScreenFloatingView = null;
        } else {
            QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView3 = this.halfScreenFloatingView;
            if (qUSHalfScreenImmersiveFloatingView3 != null) {
                qUSHalfScreenImmersiveFloatingView3.L();
            }
        }
        J9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        initViewModel();
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean hasMore) {
        QLog.i(getTAG(), 1, "onLoadMoreEnd  hasMore" + hasMore);
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        QLog.i(getTAG(), 1, "onLoadMoreStart");
        N9().B2(O9(), true);
    }

    protected void showCommentPanel() {
        QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView;
        List<T> emptyList;
        if (!this.mIsInit) {
            this.mIsInit = true;
            R9();
        }
        J9();
        String O9 = O9();
        String str = this.mLastUniqueId;
        if (str != null && !Intrinsics.areEqual(str, O9)) {
            Q9();
            i9.d dVar = this.mCommentListAdapter;
            if (dVar != null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                dVar.setItems(emptyList);
            }
        }
        this.mLastUniqueId = O9;
        QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView2 = this.halfScreenFloatingView;
        if (!(qUSHalfScreenImmersiveFloatingView2 != null && qUSHalfScreenImmersiveFloatingView2.getVisibility() == 0) && (qUSHalfScreenImmersiveFloatingView = this.halfScreenFloatingView) != null) {
            qUSHalfScreenImmersiveFloatingView.P(0);
        }
        N9().w2(O9, false);
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/qzone/reborn/albumx/common/part/layer/CommonLayerCommentPanelPart$b", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", "showMode", NodeProps.MAX_HEIGHT, "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b extends e {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f52508d;

        b(View view) {
            this.f52508d = view;
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        /* renamed from: createContentView, reason: from getter */
        public View getF52508d() {
            return this.f52508d;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int maxHeight() {
            return ImmersiveUtils.dpToPx(1000.0f);
        }
    }
}
