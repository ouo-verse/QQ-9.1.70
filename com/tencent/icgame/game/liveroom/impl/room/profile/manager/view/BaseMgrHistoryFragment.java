package com.tencent.icgame.game.liveroom.impl.room.profile.manager.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.pull2refresh.XRecyclerView;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bS\u0010TJ&\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\r\u001a\u00020\u000bH&J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001b\u001a\u00020\u00108\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\"\u0010\u001f\u001a\u00020\u00108\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016R\"\u0010'\u001a\u00020 8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010+\u001a\u00020 8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\"\u001a\u0004\b)\u0010$\"\u0004\b*\u0010&R2\u00105\u001a\u0012\u0012\u0004\u0012\u00020-0,j\b\u0012\u0004\u0012\u00020-`.8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u0010=\u001a\u0002068\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010B\u001a\u00020>8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010?\u001a\u0004\b@\u0010AR\"\u0010J\u001a\u00020C8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\"\u0010R\u001a\u00020K8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010Q\u00a8\u0006U"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/profile/manager/view/BaseMgrHistoryFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "loadData", "", "isWrapContent", "", BdhLogUtil.LogTag.Tag_Conn, "J", "getAnchorId", "()J", "setAnchorId", "(J)V", "anchorId", "D", "getRoomId", "setRoomId", "roomId", "E", "uh", "setSubRoomID", "subRoomID", "", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "vh", "()Ljava/lang/String;", OcrConfig.CHINESE, "(Ljava/lang/String;)V", "TAG", "G", "getTabId", "Ah", "tabId", "Ljava/util/ArrayList;", "Lsw0/a;", "Lkotlin/collections/ArrayList;", "H", "Ljava/util/ArrayList;", "qh", "()Ljava/util/ArrayList;", "setHistoryList", "(Ljava/util/ArrayList;)V", "historyList", "Lrw0/a;", "I", "Lrw0/a;", "rh", "()Lrw0/a;", "xh", "(Lrw0/a;)V", "mAdapter", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "sh", "()Lcom/tencent/icgame/common/api/IAegisLogApi;", "mAegisLog", "Landroid/widget/LinearLayout;", "K", "Landroid/widget/LinearLayout;", "ph", "()Landroid/widget/LinearLayout;", "wh", "(Landroid/widget/LinearLayout;)V", "errEmptyLayout", "Lcom/tencent/icgame/game/liveroom/impl/room/profile/manager/view/RefreshRecyclerView;", "L", "Lcom/tencent/icgame/game/liveroom/impl/room/profile/manager/view/RefreshRecyclerView;", "th", "()Lcom/tencent/icgame/game/liveroom/impl/room/profile/manager/view/RefreshRecyclerView;", "yh", "(Lcom/tencent/icgame/game/liveroom/impl/room/profile/manager/view/RefreshRecyclerView;)V", "refreshXRv", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public abstract class BaseMgrHistoryFragment extends QPublicBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private long anchorId;

    /* renamed from: D, reason: from kotlin metadata */
    private long roomId;

    /* renamed from: E, reason: from kotlin metadata */
    private long subRoomID;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private String TAG = "BaseMgrHistoryFragment";

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private String tabId = "0";

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private ArrayList<sw0.a> historyList = new ArrayList<>();

    /* renamed from: I, reason: from kotlin metadata */
    protected rw0.a mAdapter;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final IAegisLogApi mAegisLog;

    /* renamed from: K, reason: from kotlin metadata */
    protected LinearLayout errEmptyLayout;

    /* renamed from: L, reason: from kotlin metadata */
    protected RefreshRecyclerView refreshXRv;

    public BaseMgrHistoryFragment() {
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.mAegisLog = (IAegisLogApi) api;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Ah(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tabId = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long getAnchorId() {
        return this.anchorId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long getRoomId() {
        return this.roomId;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    public abstract void loadData();

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View view = inflater.inflate(R.layout.f168199fb4, container, false);
        View findViewById = view.findViewById(R.id.f72223q_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.refreshXRv)");
        yh((RefreshRecyclerView) findViewById);
        View findViewById2 = view.findViewById(R.id.uwj);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.errEmptyLayout)");
        wh((LinearLayout) findViewById2);
        VideoReport.setPageId(view, "pg_icgame_anchorlive_show");
        ConcurrentHashMap map = kw0.a.a(this.roomId);
        Intrinsics.checkNotNullExpressionValue(map, "map");
        map.put("icgame_administrator_history_tab", this.tabId);
        ru0.a aVar = (ru0.a) qx0.a.b(ru0.a.class);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        aVar.i(this, view, "pg_icgame_anchorlive_show", map);
        ((ru0.a) qx0.a.b(ru0.a.class)).a(view, true, null, "em_icgame_administrator_history", map);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        th().setRefreshCallback(new a());
        this.anchorId = requireArguments().getLong("anchorID", -1L);
        this.roomId = requireArguments().getLong("roomID", -1L);
        long j3 = requireArguments().getLong("subRoomID", -1L);
        this.subRoomID = j3;
        this.mAegisLog.e(this.TAG, "anchorID:" + this.anchorId + " roomID:" + this.roomId + " subRoomID:" + j3);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        xh(new rw0.a(requireContext));
        th().getRecyclerView().setAdapter(rh());
        th().getRecyclerView().setLayoutManager(new LinearLayoutManager(getActivity()));
        th().setRefreshEnable(false);
        th().setIsAutoScrolling(true);
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final LinearLayout ph() {
        LinearLayout linearLayout = this.errEmptyLayout;
        if (linearLayout != null) {
            return linearLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("errEmptyLayout");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final ArrayList<sw0.a> qh() {
        return this.historyList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final rw0.a rh() {
        rw0.a aVar = this.mAdapter;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: sh, reason: from getter */
    public final IAegisLogApi getMAegisLog() {
        return this.mAegisLog;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final RefreshRecyclerView th() {
        RefreshRecyclerView refreshRecyclerView = this.refreshXRv;
        if (refreshRecyclerView != null) {
            return refreshRecyclerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("refreshXRv");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: uh, reason: from getter */
    public final long getSubRoomID() {
        return this.subRoomID;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: vh, reason: from getter */
    public final String getTAG() {
        return this.TAG;
    }

    protected final void wh(@NotNull LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.errEmptyLayout = linearLayout;
    }

    protected final void xh(@NotNull rw0.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.mAdapter = aVar;
    }

    protected final void yh(@NotNull RefreshRecyclerView refreshRecyclerView) {
        Intrinsics.checkNotNullParameter(refreshRecyclerView, "<set-?>");
        this.refreshXRv = refreshRecyclerView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zh(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.TAG = str;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/icgame/game/liveroom/impl/room/profile/manager/view/BaseMgrHistoryFragment$a", "Lcom/tencent/widget/pull2refresh/XRecyclerView$RefreshCallback;", "Lcom/tencent/widget/pull2refresh/XRecyclerView;", "recyclerView", "", "isMachineRefresh", "", "startTopRefresh", "", "reqType", "startLoadMore", "endOfRefresh", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class a implements XRecyclerView.RefreshCallback {
        a() {
        }

        @Override // com.tencent.widget.pull2refresh.XRecyclerView.RefreshCallback
        public void startLoadMore(@Nullable XRecyclerView recyclerView, int reqType) {
            BaseMgrHistoryFragment.this.loadData();
        }

        @Override // com.tencent.widget.pull2refresh.XRecyclerView.RefreshCallback
        public void endOfRefresh() {
        }

        @Override // com.tencent.widget.pull2refresh.XRecyclerView.RefreshCallback
        public void startTopRefresh(@Nullable XRecyclerView recyclerView, boolean isMachineRefresh) {
        }
    }
}
