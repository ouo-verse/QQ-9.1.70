package com.tencent.mobileqq.gamecenter.qa.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.gamecenter.qa.data.GameStrategyChannelEntry;
import com.tencent.mobileqq.gamecenter.qa.fragment.QQGameStrategyGameListFragment;
import com.tencent.mobileqq.gamecenter.qa.model.GameListItem;
import com.tencent.mobileqq.gamecenter.qa.util.GameQAUtil;
import com.tencent.mobileqq.gamecenter.qa.view.GameQAUI;
import com.tencent.mobileqq.gamecenter.qa.view.bi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.x;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 _2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002`aB\u001d\u0012\u0006\u0010,\u001a\u00020)\u0012\f\u00101\u001a\b\u0012\u0004\u0012\u00020.0-\u00a2\u0006\u0004\b]\u0010^J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J0\u0010\u0011\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J$\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0012\u0010\u001f\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010 \u001a\u00020\u0006H\u0016J0\u0010'\u001a\u00020\u00062\f\u0010\"\u001a\b\u0012\u0002\b\u0003\u0018\u00010!2\b\u0010#\u001a\u0004\u0018\u00010\u00192\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\tH\u0016J\b\u0010(\u001a\u00020\u0006H\u0016R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020.0-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00108\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010:\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00107R\u0018\u0010<\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u00107R\u0018\u0010>\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u00107R\u0018\u0010@\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u00107R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010P\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010S\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010V\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u001c\u0010Y\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010\\\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[\u00a8\u0006b"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/fragment/QQGameStrategyGameListFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/widget/AdapterView$OnItemClickListener;", "Landroid/view/ViewGroup;", "contentView", "", "sh", "rh", "", "errorCode", "", "Lcom/tencent/mobileqq/gamecenter/qa/model/GameListItem;", "list", "nextPage", "", "isOver", "uh", "vh", "xh", "Landroid/view/LayoutInflater;", "inflater", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "Lvd1/b;", "sessionInfo", "wh", "v", NodeProps.ON_CLICK, "onStart", "Lcom/tencent/widget/AdapterView;", HippyNestedScrollComponent.PRIORITY_PARENT, "view", "", "position", "id", "onItemClick", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/gamecenter/qa/view/GameQAUI;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/gamecenter/qa/view/GameQAUI;", "mGameQAUI", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/app/QBaseActivity;", "D", "Lmqq/util/WeakReference;", "mActivityRef", "Lcom/tencent/widget/GridView;", "E", "Lcom/tencent/widget/GridView;", "mGameGridView", UserInfo.SEX_FEMALE, "Landroid/view/View;", "mRootView", "G", "mCloseBtn", "H", "mApplyGameView", "I", "mLoadingView", "J", "mLoadingFailedView", "Lcom/tencent/image/URLImageView;", "K", "Lcom/tencent/image/URLImageView;", "mLoadingFailedImg", "Lcom/tencent/mobileqq/gamecenter/qa/fragment/QQGameStrategyGameListFragment$b;", "L", "Lcom/tencent/mobileqq/gamecenter/qa/fragment/QQGameStrategyGameListFragment$b;", "mGameListAdapter", "Lfe1/a;", "M", "Lfe1/a;", "mGameStrategyListener", "Lfe1/c;", "N", "Lfe1/c;", "mGameStrategyHandler", "P", "Ljava/lang/Long;", "mNextPageIndex", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/lang/Boolean;", "mIsPullOver", BdhLogUtil.LogTag.Tag_Req, "Ljava/util/List;", "mGameList", ExifInterface.LATITUDE_SOUTH, "Lvd1/b;", "mSessionInfo", "<init>", "(Lcom/tencent/mobileqq/gamecenter/qa/view/GameQAUI;Lmqq/util/WeakReference;)V", "T", "a", "b", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class QQGameStrategyGameListFragment extends BottomSheetDialogFragment implements View.OnClickListener, AdapterView.OnItemClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final GameQAUI mGameQAUI;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final WeakReference<QBaseActivity> mActivityRef;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private GridView mGameGridView;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private View mRootView;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private View mCloseBtn;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private View mApplyGameView;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private View mLoadingView;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private View mLoadingFailedView;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private URLImageView mLoadingFailedImg;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private b mGameListAdapter;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private fe1.a mGameStrategyListener;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private fe1.c mGameStrategyHandler;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private Long mNextPageIndex;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private Boolean mIsPullOver;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private List<GameListItem> mGameList;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private vd1.b mSessionInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J$\u0010\r\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0014\u0010\u0011\u001a\u00020\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eR\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/fragment/QQGameStrategyGameListFragment$b;", "Landroid/widget/BaseAdapter;", "", "getCount", "position", "Lcom/tencent/mobileqq/gamecenter/qa/model/GameListItem;", "a", "", "getItemId", "Landroid/view/View;", "convertView", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "getView", "", "list", "", "b", "Landroid/content/Context;", "d", "Landroid/content/Context;", "mContext", "e", "Ljava/util/List;", "mGameList", "<init>", "(Landroid/content/Context;)V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b extends BaseAdapter {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Context mContext;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private List<GameListItem> mGameList;

        public b(@NotNull Context mContext) {
            List<GameListItem> emptyList;
            Intrinsics.checkNotNullParameter(mContext, "mContext");
            this.mContext = mContext;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.mGameList = emptyList;
        }

        @Override // android.widget.Adapter
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GameListItem getItem(int position) {
            return this.mGameList.get(position);
        }

        public final void b(@NotNull List<GameListItem> list) {
            Intrinsics.checkNotNullParameter(list, "list");
            this.mGameList = list;
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.mGameList.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int position) {
            return position;
        }

        @Override // android.widget.Adapter
        @NotNull
        public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent) {
            bi biVar;
            View view;
            if (convertView == null) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.ebx, parent, false);
                biVar = new bi(view);
                if (view != null) {
                    view.setTag(biVar);
                }
            } else {
                Object tag = convertView.getTag();
                Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.gamecenter.qa.view.QQGameStrategyGameGridViewHolder");
                biVar = (bi) tag;
                view = convertView;
            }
            biVar.a(this.mGameList.get(position));
            Intrinsics.checkNotNull(view);
            EventCollector.getInstance().onListGetView(position, convertView, parent, getItemId(position));
            return view;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/gamecenter/qa/fragment/QQGameStrategyGameListFragment$c", "Lfe1/a;", "", "errorCode", "", "Lcom/tencent/mobileqq/gamecenter/qa/model/GameListItem;", "list", "nextPage", "", "isOver", "", "onGetGameList", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c extends fe1.a {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(QQGameStrategyGameListFragment this$0, long j3, List list, long j16, boolean z16) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.uh(j3, list, j16, z16);
        }

        @Override // fe1.a, fe1.d
        public void onGetGameList(final long errorCode, @Nullable final List<GameListItem> list, final long nextPage, final boolean isOver) {
            MqqHandler uIHandler = ThreadManager.getUIHandler();
            final QQGameStrategyGameListFragment qQGameStrategyGameListFragment = QQGameStrategyGameListFragment.this;
            uIHandler.post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.fragment.k
                @Override // java.lang.Runnable
                public final void run() {
                    QQGameStrategyGameListFragment.c.b(QQGameStrategyGameListFragment.this, errorCode, list, nextPage, isOver);
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/gamecenter/qa/fragment/QQGameStrategyGameListFragment$d", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$e;", "Landroid/view/View;", "bottomSheet", "", "newState", "", "onStateChanged", "", "slideOffset", "onSlide", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class d extends BottomSheetBehavior.e {
        d() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onSlide(@NotNull View bottomSheet, float slideOffset) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onStateChanged(@NotNull View bottomSheet, int newState) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            if (newState == 4) {
                QQGameStrategyGameListFragment.this.dismiss();
            }
        }
    }

    public QQGameStrategyGameListFragment(@NotNull GameQAUI mGameQAUI, @NotNull WeakReference<QBaseActivity> mActivityRef) {
        Intrinsics.checkNotNullParameter(mGameQAUI, "mGameQAUI");
        Intrinsics.checkNotNullParameter(mActivityRef, "mActivityRef");
        this.mGameQAUI = mGameQAUI;
        this.mActivityRef = mActivityRef;
        this.mNextPageIndex = 0L;
        this.mIsPullOver = Boolean.FALSE;
        this.mGameList = new ArrayList();
    }

    private final void rh() {
        QLog.d("QQGameStrategyGameListFragment", 1, "getGameList, pageIndex=", this.mNextPageIndex);
        fe1.c cVar = this.mGameStrategyHandler;
        if (cVar != null) {
            cVar.Z0(this.mGameStrategyListener);
        }
        Long l3 = this.mNextPageIndex;
        if (l3 != null) {
            long longValue = l3.longValue();
            fe1.c cVar2 = this.mGameStrategyHandler;
            if (cVar2 != null) {
                cVar2.O(longValue, 80);
            }
        }
    }

    private final void sh(ViewGroup contentView) {
        this.mRootView = contentView;
        View findViewById = contentView.findViewById(R.id.xdi);
        this.mCloseBtn = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(this);
        }
        View findViewById2 = contentView.findViewById(R.id.u6_);
        this.mApplyGameView = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(this);
        }
        this.mLoadingView = contentView.findViewById(R.id.b98);
        this.mLoadingFailedView = contentView.findViewById(R.id.u6w);
        this.mLoadingFailedImg = (URLImageView) contentView.findViewById(R.id.xk_);
        GridView gridView = (GridView) contentView.findViewById(R.id.f165324vj2);
        this.mGameGridView = gridView;
        if (gridView != null) {
            gridView.setNumColumns(4);
        }
        GridView gridView2 = this.mGameGridView;
        if (gridView2 != null) {
            gridView2.setColumnWidth(x.a(66.0f));
        }
        GridView gridView3 = this.mGameGridView;
        if (gridView3 != null) {
            gridView3.setVerticalScrollBarEnabled(false);
        }
        GridView gridView4 = this.mGameGridView;
        if (gridView4 != null) {
            gridView4.setVerticalSpacing(x.a(10.0f));
        }
        GridView gridView5 = this.mGameGridView;
        if (gridView5 != null) {
            gridView5.setHorizontalSpacing((ViewUtils.getScreenWidth() - x.a(272.0f)) / 3);
        }
        GridView gridView6 = this.mGameGridView;
        if (gridView6 != null) {
            gridView6.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.gamecenter.qa.fragment.j
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean th5;
                    th5 = QQGameStrategyGameListFragment.th(QQGameStrategyGameListFragment.this, view, motionEvent);
                    return th5;
                }
            });
        }
        GridView gridView7 = this.mGameGridView;
        if (gridView7 != null) {
            gridView7.setOnItemClickListener(this);
        }
        QBaseActivity qBaseActivity = this.mActivityRef.get();
        Intrinsics.checkNotNull(qBaseActivity, "null cannot be cast to non-null type android.content.Context");
        b bVar = new b(qBaseActivity);
        this.mGameListAdapter = bVar;
        GridView gridView8 = this.mGameGridView;
        if (gridView8 != null) {
            gridView8.setAdapter((ListAdapter) bVar);
        }
        this.mGameStrategyHandler = new fe1.c();
        this.mGameStrategyListener = new c();
        View view = this.mLoadingView;
        if (view != null) {
            view.setVisibility(0);
        }
        GridView gridView9 = this.mGameGridView;
        if (gridView9 != null) {
            gridView9.setVisibility(8);
        }
        View view2 = this.mLoadingFailedView;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        rh();
        GameStrategyChannelEntry gameStrategyChannelEntry = new GameStrategyChannelEntry();
        vd1.b bVar2 = this.mSessionInfo;
        Intrinsics.checkNotNull(bVar2);
        gameStrategyChannelEntry.guildId = bVar2.f441456a;
        vd1.b bVar3 = this.mSessionInfo;
        Intrinsics.checkNotNull(bVar3);
        gameStrategyChannelEntry.channelId = bVar3.f441457b;
        com.tencent.mobileqq.gamecenter.qa.util.e.a("5", "122", "9072", "907207", "907715", "8", "", GameQAUtil.i(this.mGameQAUI.U(), gameStrategyChannelEntry));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean th(QQGameStrategyGameListFragment this$0, View view, MotionEvent motionEvent) {
        ViewParent parent;
        ViewParent parent2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent.getAction() == 1) {
            GridView gridView = this$0.mGameGridView;
            if (gridView != null && (parent2 = gridView.getParent()) != null) {
                parent2.requestDisallowInterceptTouchEvent(false);
            }
        } else {
            GridView gridView2 = this$0.mGameGridView;
            if (gridView2 != null && (parent = gridView2.getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void uh(long errorCode, List<GameListItem> list, long nextPage, boolean isOver) {
        QLog.d("QQGameStrategyGameListFragment", 1, "onGetGameListResult, errorCode=", Long.valueOf(errorCode), ", nextPage=", Long.valueOf(nextPage), ", isOver=", Boolean.valueOf(isOver));
        if (errorCode == 0) {
            GridView gridView = this.mGameGridView;
            if (gridView != null) {
                gridView.setVisibility(0);
            }
            View view = this.mLoadingView;
            if (view != null) {
                view.setVisibility(8);
            }
            View view2 = this.mLoadingFailedView;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            if (list != null) {
                this.mGameList.addAll(list);
                b bVar = this.mGameListAdapter;
                if (bVar != null) {
                    bVar.b(this.mGameList);
                }
            }
            this.mNextPageIndex = Long.valueOf(nextPage);
            Boolean valueOf = Boolean.valueOf(isOver);
            this.mIsPullOver = valueOf;
            Intrinsics.checkNotNull(valueOf);
            if (!valueOf.booleanValue()) {
                rh();
                return;
            }
            return;
        }
        Long l3 = this.mNextPageIndex;
        if (l3 != null && l3.longValue() == 0) {
            xh();
        }
    }

    private final void vh() {
        QLog.d("QQGameStrategyGameListFragment", 1, "openApplyGamePage");
        Intent intent = new Intent();
        intent.putExtra("url", "https://wj.qq.com/s2/9739973/ee69/");
        QBaseActivity qBaseActivity = this.mActivityRef.get();
        Intrinsics.checkNotNull(qBaseActivity, "null cannot be cast to non-null type android.content.Context");
        RouteUtils.startActivity(qBaseActivity, intent, RouterConstants.UI_ROUTE_BROWSER);
    }

    private final void xh() {
        String str;
        QLog.d("QQGameStrategyGameListFragment", 1, "showLoadingFailedView");
        GridView gridView = this.mGameGridView;
        if (gridView != null) {
            gridView.setVisibility(8);
        }
        View view = this.mLoadingView;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.mLoadingFailedView;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        if (ThemeUtil.isNowThemeIsNight(null, false, null)) {
            str = "https://img.gamecenter.qq.com/xgame/gm/1650618453196_6572a5221a7fc03ccd4fdd0f2d642287.png";
        } else {
            str = "https://img.gamecenter.qq.com/xgame/gm/1650618485350_547ab1c160705bb4c750a60ea2ef4da6.png";
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = new ColorDrawable(0);
        obtain.mFailedDrawable = new ColorDrawable(0);
        URLImageView uRLImageView = this.mLoadingFailedImg;
        if (uRLImageView != null) {
            uRLImageView.setImageDrawable(URLDrawable.getDrawable(str, obtain));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            num = Integer.valueOf(v3.getId());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == R.id.xdi) {
            dismiss();
        } else if (num != null && num.intValue() == R.id.u6_) {
            vh();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.ebw, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) inflate;
        sh(viewGroup);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, viewGroup);
        return viewGroup;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        QLog.d("QQGameStrategyGameListFragment", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        super.onDestroy();
        fe1.c cVar = this.mGameStrategyHandler;
        Intrinsics.checkNotNull(cVar);
        cVar.N0();
    }

    @Override // com.tencent.widget.AdapterView.OnItemClickListener
    public void onItemClick(@Nullable AdapterView<?> parent, @Nullable View view, int position, long id5) {
        Integer num;
        GameListItem gameListItem;
        b bVar = this.mGameListAdapter;
        Integer num2 = null;
        if (bVar != null) {
            num = Integer.valueOf(bVar.getCount());
        } else {
            num = null;
        }
        Intrinsics.checkNotNull(num);
        if (position < num.intValue()) {
            b bVar2 = this.mGameListAdapter;
            if (bVar2 != null) {
                gameListItem = bVar2.getItem(position);
            } else {
                gameListItem = null;
            }
            this.mGameQAUI.H0(gameListItem);
            dismiss();
            GameStrategyChannelEntry gameStrategyChannelEntry = new GameStrategyChannelEntry();
            vd1.b bVar3 = this.mSessionInfo;
            Intrinsics.checkNotNull(bVar3);
            gameStrategyChannelEntry.guildId = bVar3.f441456a;
            vd1.b bVar4 = this.mSessionInfo;
            Intrinsics.checkNotNull(bVar4);
            gameStrategyChannelEntry.channelId = bVar4.f441457b;
            if (gameListItem != null) {
                num2 = Integer.valueOf(gameListItem.getAppid());
            }
            com.tencent.mobileqq.gamecenter.qa.util.e.a("5", "122", "9072", "907207", "907716", "20", String.valueOf(num2), GameQAUtil.i(this.mGameQAUI.U(), gameStrategyChannelEntry));
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        View view = this.mRootView;
        Intrinsics.checkNotNull(view);
        Object parent = view.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        ((View) parent).setBackgroundColor(0);
        Dialog dialog = getDialog();
        Intrinsics.checkNotNull(dialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        BottomSheetBehavior<FrameLayout> behavior = ((com.google.android.material.bottomsheet.a) dialog).getBehavior();
        Intrinsics.checkNotNullExpressionValue(behavior, "dialog.behavior");
        behavior.setState(3);
        behavior.setPeekHeight(0);
        behavior.addBottomSheetCallback(new d());
    }

    public void wh(@NotNull vd1.b sessionInfo) {
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        this.mSessionInfo = sessionInfo;
    }
}
