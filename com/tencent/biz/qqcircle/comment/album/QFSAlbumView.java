package com.tencent.biz.qqcircle.comment.album;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.comment.QFSBaseInputPopupWindow;
import com.tencent.biz.qqcircle.comment.album.QFSHalfScreenAlbumSheetView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.qbasealbum.album.viewmodel.PickerLocalMediaViewModel;
import com.tencent.qqnt.qbasealbum.albumlist.viewmodel.AlbumListViewModel;
import com.tencent.qqnt.qbasealbum.datahub.LocalMediaDataHub;
import com.tencent.qqnt.qbasealbum.ktx.ListExKt;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.model.PageType;
import com.tencent.qqnt.qbasealbum.model.TabType;
import com.tencent.qqnt.qbasealbum.query.QueryViewModel;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.report.QCircleReportBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ^2\u00020\u00012\u00020\u0002:\u0001_B\u0011\b\u0016\u0012\u0006\u0010X\u001a\u00020W\u00a2\u0006\u0004\bY\u0010ZB\u0019\b\u0016\u0012\u0006\u0010X\u001a\u00020W\u0012\u0006\u0010\\\u001a\u00020[\u00a2\u0006\u0004\bY\u0010]J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0003J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\u001c\u0010\u000f\u001a\u00020\u00032\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bH\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0002J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0003H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u0019\u001a\u00020\u0017H\u0002J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0011H\u0002J\b\u0010\u001c\u001a\u00020\u0011H\u0002J\b\u0010\u001d\u001a\u00020\u0011H\u0002J\b\u0010\u001e\u001a\u00020\u0011H\u0002J\u0010\u0010!\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u001fJ\b\u0010\"\u001a\u00020\u0003H\u0014J\b\u0010#\u001a\u00020\u0003H\u0014J\u0018\u0010'\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020$2\u0006\u0010&\u001a\u00020%H\u0016R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00106R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010H\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010GR\u0014\u0010L\u001a\u00020I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010N\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0006\u0010MR\u0016\u0010Q\u001a\u00020O8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\n\u0010PR\u0016\u0010R\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bK\u0010MR\u0018\u0010U\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010V\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010T\u00a8\u0006`"}, d2 = {"Lcom/tencent/biz/qqcircle/comment/album/QFSAlbumView;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnTouchListener;", "", "M", "K", "G", "N", "E", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "H", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "uiStateData", "T", BdhLogUtil.LogTag.Tag_Req, "", NodeProps.VISIBLE, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/biz/qqcircle/comment/album/QFSHalfScreenAlbumSheetView;", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/view/animation/Animation;", "w", HippyTKDListViewAdapter.X, "isBack", "v", "P", "O", "u", "Lcooperation/qqcircle/report/QCircleReportBean;", "reportBean", "setCustomReportBean", NodeProps.ON_DETACHED_FROM_WINDOW, NodeProps.ON_ATTACHED_TO_WINDOW, "Landroid/view/View;", "Landroid/view/MotionEvent;", "event", "onTouch", "Lcom/tencent/qqnt/qbasealbum/query/QueryViewModel;", "d", "Lcom/tencent/qqnt/qbasealbum/query/QueryViewModel;", "queryViewModel", "Lcom/tencent/qqnt/qbasealbum/albumlist/viewmodel/AlbumListViewModel;", "e", "Lcom/tencent/qqnt/qbasealbum/albumlist/viewmodel/AlbumListViewModel;", "mAlbumListViewModel", "Lcom/tencent/qqnt/qbasealbum/album/viewmodel/PickerLocalMediaViewModel;", "f", "Lcom/tencent/qqnt/qbasealbum/album/viewmodel/PickerLocalMediaViewModel;", "mPickerViewModel", "Landroidx/recyclerview/widget/RecyclerView;", tl.h.F, "Landroidx/recyclerview/widget/RecyclerView;", "mAlbumListRecyclerView", "i", "mediaRecyclerView", "Lcom/tencent/biz/qqcircle/comment/album/m;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/biz/qqcircle/comment/album/m;", "mMediaAdapter", "Lcom/tencent/biz/qqcircle/comment/album/b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/qqcircle/comment/album/b;", "mAlbumListAdapter", "Landroidx/recyclerview/widget/GridLayoutManager;", "D", "Landroidx/recyclerview/widget/GridLayoutManager;", "layoutManager", "Lcom/tencent/biz/qqcircle/comment/album/QFSTimelineController;", "Lcom/tencent/biz/qqcircle/comment/album/QFSTimelineController;", "timelineController", "", UserInfo.SEX_FEMALE, "I", "timeBubbleOffset", "Landroid/view/View;", "mAlbumListSelectBtn", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "mTitleTv", "mTitleArrow", "J", "Landroid/view/animation/Animation;", "fadeInAnimation", "fadeOutAnimation", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "L", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSAlbumView extends FrameLayout implements View.OnTouchListener {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private com.tencent.biz.qqcircle.comment.album.b mAlbumListAdapter;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private GridLayoutManager layoutManager;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private QFSTimelineController timelineController;

    /* renamed from: F, reason: from kotlin metadata */
    private final int timeBubbleOffset;

    /* renamed from: G, reason: from kotlin metadata */
    private View mAlbumListSelectBtn;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView mTitleTv;

    /* renamed from: I, reason: from kotlin metadata */
    private View mTitleArrow;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private Animation fadeInAnimation;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private Animation fadeOutAnimation;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private QueryViewModel queryViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AlbumListViewModel mAlbumListViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private PickerLocalMediaViewModel mPickerViewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RecyclerView mAlbumListRecyclerView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private RecyclerView mediaRecyclerView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private m mMediaAdapter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/comment/album/QFSAlbumView$b", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b implements Animation.AnimationListener {
        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@NotNull Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@NotNull Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@NotNull Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            RecyclerView recyclerView = QFSAlbumView.this.mAlbumListRecyclerView;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumListRecyclerView");
                recyclerView = null;
            }
            recyclerView.setVisibility(0);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/comment/album/QFSAlbumView$c", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class c implements Animation.AnimationListener {
        c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@NotNull Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            RecyclerView recyclerView = QFSAlbumView.this.mAlbumListRecyclerView;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumListRecyclerView");
                recyclerView = null;
            }
            recyclerView.setVisibility(4);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@NotNull Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@NotNull Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/biz/qqcircle/comment/album/QFSAlbumView$d", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class d extends RecyclerView.ItemDecoration {
        d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            outRect.top = com.tencent.qqnt.qbasealbum.ktx.d.b(2);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/biz/qqcircle/comment/album/QFSAlbumView$e", "Landroidx/recyclerview/widget/GridLayoutManager;", "", "supportsPredictiveItemAnimations", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class e extends GridLayoutManager {
        e(Context context, int i3) {
            super(context, i3);
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean supportsPredictiveItemAnimations() {
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/biz/qqcircle/comment/album/QFSAlbumView$f", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "", "position", "getSpanSize", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class f extends GridLayoutManager.SpanSizeLookup {
        f() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int position) {
            m mVar = QFSAlbumView.this.mMediaAdapter;
            if (mVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaAdapter");
                mVar = null;
            }
            if (mVar.k0().isEmpty()) {
                return m.INSTANCE.a();
            }
            return 1;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/biz/qqcircle/comment/album/QFSAlbumView$g", "Lcom/tencent/biz/qqcircle/comment/album/QFSHalfScreenAlbumSheetView$b;", "", "newState", "", "a", "", "slideOffset", "b", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class g implements QFSHalfScreenAlbumSheetView.b {
        g() {
        }

        @Override // com.tencent.biz.qqcircle.comment.album.QFSHalfScreenAlbumSheetView.b
        public void a(int newState) {
            QFSTimelineController qFSTimelineController;
            if (newState == 3 && (qFSTimelineController = QFSAlbumView.this.timelineController) != null) {
                RecyclerView recyclerView = QFSAlbumView.this.mediaRecyclerView;
                RecyclerView recyclerView2 = null;
                if (recyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
                    recyclerView = null;
                }
                int height = recyclerView.getHeight();
                RecyclerView recyclerView3 = QFSAlbumView.this.mediaRecyclerView;
                if (recyclerView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
                } else {
                    recyclerView2 = recyclerView3;
                }
                qFSTimelineController.A((height - recyclerView2.getTop()) - QFSAlbumView.this.timeBubbleOffset);
            }
        }

        @Override // com.tencent.biz.qqcircle.comment.album.QFSHalfScreenAlbumSheetView.b
        public void b(float slideOffset) {
            QFSTimelineController qFSTimelineController;
            if (slideOffset > 0.0f && QFSAlbumView.this.P() && (qFSTimelineController = QFSAlbumView.this.timelineController) != null) {
                qFSTimelineController.k(false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSAlbumView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.queryViewModel = new QueryViewModel();
        this.mAlbumListViewModel = new AlbumListViewModel();
        this.mPickerViewModel = new PickerLocalMediaViewModel(PageType.LOCAL_IMAGE);
        this.timeBubbleOffset = com.tencent.qqnt.qbasealbum.ktx.d.b(59);
        LayoutInflater.from(getContext()).inflate(R.layout.g8v, this);
        M();
        this.fadeInAnimation = w();
        this.fadeOutAnimation = x();
        N();
        E();
    }

    private final void A() {
        MutableLiveData<Boolean> U1 = this.mAlbumListViewModel.U1();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.biz.qqcircle.comment.album.QFSAlbumView$initAlbumListViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Boolean bool) {
                QFSAlbumView qFSAlbumView = QFSAlbumView.this;
                Intrinsics.checkNotNull(bool);
                qFSAlbumView.Q(bool.booleanValue());
                QFSAlbumView.this.v(!bool.booleanValue());
            }
        };
        U1.observeForever(new Observer() { // from class: com.tencent.biz.qqcircle.comment.album.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSAlbumView.B(Function1.this, obj);
            }
        });
        LiveData<com.tencent.qqnt.qbasealbum.model.b> W1 = this.mAlbumListViewModel.W1();
        final Function1<com.tencent.qqnt.qbasealbum.model.b, Unit> function12 = new Function1<com.tencent.qqnt.qbasealbum.model.b, Unit>() { // from class: com.tencent.biz.qqcircle.comment.album.QFSAlbumView$initAlbumListViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.qbasealbum.model.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.qqnt.qbasealbum.model.b bVar) {
                TextView textView;
                TextView textView2;
                textView = QFSAlbumView.this.mTitleTv;
                TextView textView3 = null;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleTv");
                    textView = null;
                }
                if (!Intrinsics.areEqual(textView.getText(), bVar.f())) {
                    textView2 = QFSAlbumView.this.mTitleTv;
                    if (textView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTitleTv");
                    } else {
                        textView3 = textView2;
                    }
                    textView3.setText(bVar.f());
                }
            }
        };
        W1.observeForever(new Observer() { // from class: com.tencent.biz.qqcircle.comment.album.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSAlbumView.C(Function1.this, obj);
            }
        });
        LocalMediaDataHub.INSTANCE.a().j0();
        this.mAlbumListViewModel.Z1(TabType.TAB_IMAGE);
        MediatorLiveData<List<com.tencent.qqnt.qbasealbum.model.b>> T1 = this.mAlbumListViewModel.T1();
        final Function1<List<com.tencent.qqnt.qbasealbum.model.b>, Unit> function13 = new Function1<List<com.tencent.qqnt.qbasealbum.model.b>, Unit>() { // from class: com.tencent.biz.qqcircle.comment.album.QFSAlbumView$initAlbumListViewModel$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<com.tencent.qqnt.qbasealbum.model.b> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable List<com.tencent.qqnt.qbasealbum.model.b> list) {
                b bVar;
                AlbumListViewModel albumListViewModel;
                AlbumListViewModel albumListViewModel2;
                AlbumListViewModel albumListViewModel3;
                AlbumListViewModel albumListViewModel4;
                bVar = QFSAlbumView.this.mAlbumListAdapter;
                if (bVar != null) {
                    bVar.p0(list);
                }
                albumListViewModel = QFSAlbumView.this.mAlbumListViewModel;
                if (albumListViewModel.W1().getValue() != null) {
                    albumListViewModel3 = QFSAlbumView.this.mAlbumListViewModel;
                    albumListViewModel4 = QFSAlbumView.this.mAlbumListViewModel;
                    com.tencent.qqnt.qbasealbum.model.b value = albumListViewModel4.W1().getValue();
                    Intrinsics.checkNotNull(value);
                    albumListViewModel3.a2(value);
                    return;
                }
                Intrinsics.checkNotNull(list);
                for (com.tencent.qqnt.qbasealbum.model.b bVar2 : list) {
                    if (Intrinsics.areEqual(com.tencent.qqnt.qbasealbum.model.a.f361348a.a(), bVar2.b())) {
                        albumListViewModel2 = QFSAlbumView.this.mAlbumListViewModel;
                        albumListViewModel2.a2(bVar2);
                        return;
                    }
                }
            }
        };
        T1.observeForever(new Observer() { // from class: com.tencent.biz.qqcircle.comment.album.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSAlbumView.D(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void E() {
        View view = this.mAlbumListSelectBtn;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumListSelectBtn");
            view = null;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.comment.album.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QFSAlbumView.F(QFSAlbumView.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(QFSAlbumView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QFSHalfScreenAlbumSheetView y16 = this$0.y();
        boolean z16 = false;
        if (y16 != null && y16.p()) {
            z16 = true;
        }
        if (z16) {
            com.tencent.xaction.log.b.a("QFSAlbumView", 1, "halfScreenView is dragging. ");
        } else {
            this$0.mAlbumListViewModel.Q1();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void G() {
        this.mMediaAdapter = new m();
        e eVar = new e(getContext(), m.INSTANCE.a());
        this.layoutManager = eVar;
        eVar.setSpanSizeLookup(new f());
        RecyclerView recyclerView = this.mediaRecyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
            recyclerView = null;
        }
        m mVar = this.mMediaAdapter;
        if (mVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaAdapter");
            mVar = null;
        }
        recyclerView.setAdapter(mVar);
        RecyclerView recyclerView3 = this.mediaRecyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
        } else {
            recyclerView2 = recyclerView3;
        }
        recyclerView2.setLayoutManager(this.layoutManager);
    }

    private final void H() {
        MediatorLiveData<UIStateData<List<LocalMediaInfo>>> U1 = this.mPickerViewModel.U1(PageType.LOCAL_IMAGE);
        final Function1<UIStateData<List<LocalMediaInfo>>, Unit> function1 = new Function1<UIStateData<List<LocalMediaInfo>>, Unit>() { // from class: com.tencent.biz.qqcircle.comment.album.QFSAlbumView$initPickerViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<List<LocalMediaInfo>> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<List<LocalMediaInfo>> uiStateData) {
                QFSAlbumView qFSAlbumView = QFSAlbumView.this;
                Intrinsics.checkNotNullExpressionValue(uiStateData, "uiStateData");
                qFSAlbumView.T(uiStateData);
            }
        };
        U1.observeForever(new Observer() { // from class: com.tencent.biz.qqcircle.comment.album.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSAlbumView.I(Function1.this, obj);
            }
        });
        this.mPickerViewModel.x2(this.mAlbumListViewModel.W1());
        MutableLiveData<String> T1 = this.mPickerViewModel.T1();
        final Function1<String, Unit> function12 = new Function1<String, Unit>() { // from class: com.tencent.biz.qqcircle.comment.album.QFSAlbumView$initPickerViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                QFSTimelineController qFSTimelineController = QFSAlbumView.this.timelineController;
                if (qFSTimelineController != null) {
                    qFSTimelineController.E();
                }
            }
        };
        T1.observeForever(new Observer() { // from class: com.tencent.biz.qqcircle.comment.album.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSAlbumView.J(Function1.this, obj);
            }
        });
        this.mPickerViewModel.fetchFirstPageMedia();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void K() {
        View findViewById = findViewById(R.id.f4881210);
        RecyclerView recyclerView = this.mediaRecyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
            recyclerView = null;
        }
        this.timelineController = new QFSTimelineController(this, recyclerView, m.INSTANCE.a(), this.queryViewModel);
        RecyclerView recyclerView3 = this.mediaRecyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
            recyclerView3 = null;
        }
        recyclerView3.setOnTouchListener(this);
        if (findViewById != null) {
            findViewById.setOnTouchListener(this);
        }
        RecyclerView recyclerView4 = this.mediaRecyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
        } else {
            recyclerView2 = recyclerView4;
        }
        recyclerView2.post(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.album.i
            @Override // java.lang.Runnable
            public final void run() {
                QFSAlbumView.L(QFSAlbumView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(QFSAlbumView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QFSTimelineController qFSTimelineController = this$0.timelineController;
        if (qFSTimelineController != null) {
            qFSTimelineController.A(QFSBaseInputPopupWindow.U - this$0.timeBubbleOffset);
        }
    }

    private final void M() {
        View findViewById = findViewById(R.id.f3518116);
        int screenHeight = DisplayUtil.getScreenHeight() - DisplayUtil.dip2px(getContext(), 57.5f);
        com.tencent.xaction.log.b.a("QFSAlbumView", 1, "windowHeight: " + DisplayUtil.getScreenHeight() + ", targetHeight: " + screenHeight);
        findViewById.getLayoutParams().height = screenHeight;
        View findViewById2 = findViewById(R.id.f3519117);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qfs_comment_album_list)");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        this.mAlbumListRecyclerView = recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumListRecyclerView");
            recyclerView = null;
        }
        recyclerView.setVisibility(8);
        View findViewById3 = findViewById(R.id.f3520118);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.qfs_comment_album_picker)");
        this.mediaRecyclerView = (RecyclerView) findViewById3;
        View findViewById4 = findViewById(R.id.f489721f);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.qfs_picker_show_album_btn)");
        this.mAlbumListSelectBtn = findViewById4;
        View findViewById5 = findViewById(R.id.f489921h);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.qfs_picker_title_name)");
        this.mTitleTv = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.f489821g);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.qfs_picker_title_img)");
        this.mTitleArrow = findViewById6;
        z();
        G();
        K();
    }

    private final void N() {
        A();
        H();
    }

    private final boolean O() {
        BottomSheetBehavior<View> j3;
        QFSHalfScreenAlbumSheetView y16 = y();
        if (y16 == null || (j3 = y16.j()) == null || j3.getState() != 3) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean P() {
        BottomSheetBehavior<View> j3;
        QFSHalfScreenAlbumSheetView y16 = y();
        if (y16 == null || (j3 = y16.j()) == null || j3.getState() != 1) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q(boolean visible) {
        Animation animation;
        RecyclerView recyclerView = this.mAlbumListRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumListRecyclerView");
            recyclerView = null;
        }
        if (visible) {
            animation = this.fadeInAnimation;
        } else {
            animation = this.fadeOutAnimation;
        }
        recyclerView.startAnimation(animation);
        QFSHalfScreenAlbumSheetView y16 = y();
        if (y16 != null) {
            y16.j().setDraggable(!visible);
        }
    }

    private final void R() {
        final GridLayoutManager gridLayoutManager = this.layoutManager;
        if (gridLayoutManager != null) {
            RecyclerView recyclerView = this.mediaRecyclerView;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
                recyclerView = null;
            }
            recyclerView.post(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.album.j
                @Override // java.lang.Runnable
                public final void run() {
                    QFSAlbumView.S(GridLayoutManager.this, this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(GridLayoutManager it, QFSAlbumView this$0) {
        int coerceAtLeast;
        int coerceAtMost;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int findFirstCompletelyVisibleItemPosition = it.findFirstCompletelyVisibleItemPosition();
        int findLastCompletelyVisibleItemPosition = it.findLastCompletelyVisibleItemPosition();
        ox3.a.c("QFSAlbumView", new Function0<String>() { // from class: com.tencent.biz.qqcircle.comment.album.QFSAlbumView$updateByAlbumChange$1$1$1
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                return "updateByAlbumChange";
            }
        });
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(findFirstCompletelyVisibleItemPosition - 300, 0);
        int i3 = findLastCompletelyVisibleItemPosition + 300;
        m mVar = this$0.mMediaAdapter;
        m mVar2 = null;
        if (mVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaAdapter");
            mVar = null;
        }
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(i3, mVar.k0().size());
        m mVar3 = this$0.mMediaAdapter;
        if (mVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaAdapter");
        } else {
            mVar2 = mVar3;
        }
        List a16 = ListExKt.a(new ArrayList(mVar2.k0()), coerceAtLeast, coerceAtMost);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(a16, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it5 = a16.iterator();
        while (it5.hasNext()) {
            arrayList.add(((QFSLocalMediaInfo) it5.next()).getLocalMediaInfo());
        }
        QueryViewModel.b2(this$0.queryViewModel, coerceAtLeast, coerceAtMost, arrayList, true, null, true, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T(UIStateData<List<LocalMediaInfo>> uiStateData) {
        com.tencent.xaction.log.b.a("QFSAlbumView", 4, "updateRecyclerViewAfterFetch");
        int state = uiStateData.getState();
        if (state == 2 || state == 3) {
            m mVar = this.mMediaAdapter;
            if (mVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaAdapter");
                mVar = null;
            }
            List<LocalMediaInfo> data = uiStateData.getData();
            Intrinsics.checkNotNullExpressionValue(data, "uiStateData.data");
            mVar.i0(data);
            QFSTimelineController qFSTimelineController = this.timelineController;
            if (qFSTimelineController != null) {
                qFSTimelineController.B(uiStateData);
            }
            R();
        }
    }

    private final boolean u() {
        RecyclerView recyclerView = this.mediaRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
            recyclerView = null;
        }
        return recyclerView.canScrollVertically(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(boolean isBack) {
        float f16;
        String str;
        float f17 = 180.0f;
        if (isBack) {
            f16 = 180.0f;
        } else {
            f16 = 0.0f;
        }
        if (isBack) {
            f17 = 360.0f;
        }
        RotateAnimation rotateAnimation = new RotateAnimation(f16, f17, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(300L);
        rotateAnimation.setFillAfter(true);
        View view = this.mTitleArrow;
        TextView textView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleArrow");
            view = null;
        }
        view.startAnimation(rotateAnimation);
        View view2 = this.mAlbumListSelectBtn;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumListSelectBtn");
            view2 = null;
        }
        TextView textView2 = this.mTitleTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleTv");
        } else {
            textView = textView2;
        }
        CharSequence text = textView.getText();
        if (isBack) {
            str = "\u6536\u8d77";
        } else {
            str = "\u5c55\u5f00";
        }
        view2.setContentDescription(((Object) text) + " \u5df2" + str);
    }

    private final Animation w() {
        Animation slideDownAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f154548b2);
        slideDownAnimation.setAnimationListener(new b());
        Intrinsics.checkNotNullExpressionValue(slideDownAnimation, "slideDownAnimation");
        return slideDownAnimation;
    }

    private final Animation x() {
        Animation slideUpAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f154550b4);
        slideUpAnimation.setAnimationListener(new c());
        Intrinsics.checkNotNullExpressionValue(slideUpAnimation, "slideUpAnimation");
        return slideUpAnimation;
    }

    private final QFSHalfScreenAlbumSheetView y() {
        if (getParent() instanceof QFSHalfScreenAlbumSheetView) {
            ViewParent parent = getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type com.tencent.biz.qqcircle.comment.album.QFSHalfScreenAlbumSheetView");
            return (QFSHalfScreenAlbumSheetView) parent;
        }
        return null;
    }

    private final void z() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.mAlbumListAdapter = new com.tencent.biz.qqcircle.comment.album.b(context, this.mAlbumListViewModel);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 1, false);
        linearLayoutManager.setOrientation(1);
        RecyclerView recyclerView = this.mAlbumListRecyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumListRecyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerView recyclerView3 = this.mAlbumListRecyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumListRecyclerView");
            recyclerView3 = null;
        }
        recyclerView3.addItemDecoration(new d());
        RecyclerView recyclerView4 = this.mAlbumListRecyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumListRecyclerView");
        } else {
            recyclerView2 = recyclerView4;
        }
        recyclerView2.setAdapter(this.mAlbumListAdapter);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        QFSHalfScreenAlbumSheetView y16 = y();
        if (y16 != null) {
            y16.h(new g());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        LocalMediaDataHub.INSTANCE.a().d0();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(@NotNull View v3, @NotNull MotionEvent event) {
        QFSTimelineController qFSTimelineController;
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(event, "event");
        if (P() || !O() || !u() || (qFSTimelineController = this.timelineController) == null) {
            return false;
        }
        return qFSTimelineController.z(v3, event);
    }

    public final void setCustomReportBean(@Nullable QCircleReportBean reportBean) {
        m mVar = this.mMediaAdapter;
        if (mVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaAdapter");
            mVar = null;
        }
        mVar.l0(reportBean);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSAlbumView(@NotNull Context context, @NotNull AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.queryViewModel = new QueryViewModel();
        this.mAlbumListViewModel = new AlbumListViewModel();
        this.mPickerViewModel = new PickerLocalMediaViewModel(PageType.LOCAL_IMAGE);
        this.timeBubbleOffset = com.tencent.qqnt.qbasealbum.ktx.d.b(59);
        LayoutInflater.from(getContext()).inflate(R.layout.g8v, this);
        M();
        this.fadeInAnimation = w();
        this.fadeOutAnimation = x();
        N();
        E();
    }
}
