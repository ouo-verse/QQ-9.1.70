package com.tencent.mobileqq.troop.findTroop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.exp.viewmodel.e;
import com.tencent.mobileqq.troop.exp.viewmodel.f;
import com.tencent.mobileqq.troop.findTroop.util.a;
import com.tencent.mobileqq.troop.findTroop.util.b;
import com.tencent.mobileqq.troop.recommend.data.RecommendTroopItem;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.guild_search_recommend_svr.guildSearchRecommendSvr$FirstShow;

@Metadata(d1 = {"\u0000\u00a6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u000f*\u0002cg\u0018\u0000 s2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001tB\t\b\u0016\u00a2\u0006\u0004\bq\u0010rJ\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002J&\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0006\u0010\u001b\u001a\u00020\bJ\u0006\u0010\u001c\u001a\u00020\bJ\u0006\u0010\u001d\u001a\u00020\bJ\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eJ\b\u0010 \u001a\u00020\bH\u0016J\b\u0010!\u001a\u00020\bH\u0016J\u0010\u0010$\u001a\u00020\b2\u0006\u0010#\u001a\u00020\"H\u0016J\n\u0010&\u001a\u0004\u0018\u00010%H\u0016J\b\u0010'\u001a\u00020\u0006H\u0016J\u001a\u0010)\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\r2\u0006\u0010(\u001a\u00020\u0004H\u0016J*\u0010-\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\r2\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0004H\u0016R\"\u00105\u001a\u00020.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001b\u0010:\u001a\u00020\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u0018\u0010=\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010@\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bF\u0010GR$\u0010N\u001a\u0012\u0012\u0004\u0012\u00020J0Ij\b\u0012\u0004\u0012\u00020J`K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0014\u0010Q\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u001b\u0010V\u001a\u00020R8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bS\u00107\u001a\u0004\bT\u0010UR\u0016\u0010X\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010LR\u0016\u0010[\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010]\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010ZR\u001b\u0010b\u001a\u00020^8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b_\u00107\u001a\u0004\b`\u0010aR\u0014\u0010f\u001a\u00020c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0014\u0010j\u001a\u00020g8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bh\u0010iR\"\u0010p\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bk\u0010Z\u001a\u0004\bl\u0010m\"\u0004\bn\u0010o\u00a8\u0006u"}, d2 = {"Lcom/tencent/mobileqq/troop/findTroop/AddContactViewPagerTroopFragmentV2;", "Lcom/tencent/mobileqq/app/QBaseFragment;", "Lcom/tencent/mobileqq/troop/findTroop/util/b;", "Lcom/tencent/widget/AbsListView$OnScrollListener;", "", NodeProps.CUSTOM_PROP_IMAGE_TYPE, "", "errorMsg", "", "Mh", "Jh", "xh", "Eh", "Lcom/tencent/widget/AbsListView;", "listView", "", "Ih", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Fh", "Hh", "Kh", "Lcom/tencent/widget/XListView;", "yh", "onResume", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "event", "R2", "Lcom/tencent/mobileqq/troop/findTroop/util/c;", "F5", "af", HippyTKDListViewAdapter.SCROLL_STATE, "onScrollStateChanged", "firstVisibleItem", "visibleItemCount", "totalItemCount", HippyScrollViewEventHelper.EVENT_TYPE_SCROLL, "Lcom/tencent/common/app/AppInterface;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/common/app/AppInterface;", OcrConfig.CHINESE, "()Lcom/tencent/common/app/AppInterface;", "setMApp", "(Lcom/tencent/common/app/AppInterface;)V", "mApp", "D", "Lkotlin/Lazy;", "Bh", "()Ljava/lang/String;", "tabKeyword", "E", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, UserInfo.SEX_FEMALE, "Lcom/tencent/widget/XListView;", "mListView", "Landroid/widget/FrameLayout;", "G", "Landroid/widget/FrameLayout;", "emptyLayout", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", "mFooterView", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/troop/recommend/data/RecommendTroopItem;", "Lkotlin/collections/ArrayList;", "I", "Ljava/util/ArrayList;", "recommendDataList", "J", "Lcom/tencent/mobileqq/troop/findTroop/util/c;", "troopTabManager", "Lcom/tencent/mobileqq/troop/findTroop/adapter/a;", "K", "Ah", "()Lcom/tencent/mobileqq/troop/findTroop/adapter/a;", "recommendTroopAdapter", "L", "curPage", "M", "Z", "isFirstShow", "N", "isNeedToNotifyAfterFetchData", "Lcom/tencent/mobileqq/troop/exp/viewmodel/b;", "P", "Ch", "()Lcom/tencent/mobileqq/troop/exp/viewmodel/b;", "viewModel", "com/tencent/mobileqq/troop/findTroop/AddContactViewPagerTroopFragmentV2$b", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/troop/findTroop/AddContactViewPagerTroopFragmentV2$b;", "searchRecommendObserver", "com/tencent/mobileqq/troop/findTroop/AddContactViewPagerTroopFragmentV2$c", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/troop/findTroop/AddContactViewPagerTroopFragmentV2$c;", "troopMngObserver", ExifInterface.LATITUDE_SOUTH, "getNeedResetListViewPosition", "()Z", "Lh", "(Z)V", "needResetListViewPosition", "<init>", "()V", "T", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class AddContactViewPagerTroopFragmentV2 extends QBaseFragment implements com.tencent.mobileqq.troop.findTroop.util.b, AbsListView.OnScrollListener {
    static IPatchRedirector $redirector_;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private AppInterface mApp;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy tabKeyword;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private View rootView;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private XListView mListView;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private FrameLayout emptyLayout;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView mFooterView;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<RecommendTroopItem> recommendDataList;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.troop.findTroop.util.c troopTabManager;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy recommendTroopAdapter;

    /* renamed from: L, reason: from kotlin metadata */
    private int curPage;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean isFirstShow;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean isNeedToNotifyAfterFetchData;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final b searchRecommendObserver;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final c troopMngObserver;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean needResetListViewPosition;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/troop/findTroop/AddContactViewPagerTroopFragmentV2$a;", "", "", "KEY_TAB_KEYWORD", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.findTroop.AddContactViewPagerTroopFragmentV2$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000=\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JZ\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00022\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0002H\u0016\u00a8\u0006\u0014"}, d2 = {"com/tencent/mobileqq/troop/findTroop/AddContactViewPagerTroopFragmentV2$b", "Lcom/tencent/mobileqq/troop/exp/viewmodel/e;", "", "isSuccess", "", "itemType", "", "keyWord", "serverPageID", "isEnd", "", "Lcom/tencent/mobileqq/troop/recommend/data/RecommendTroopItem;", "dataList", "Ltencent/im/oidb/guild_search_recommend_svr/guildSearchRecommendSvr$FirstShow;", "firstShow", "Lcom/tencent/mobileqq/pb/ByteStringMicro;", "sessionInfo", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements e {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddContactViewPagerTroopFragmentV2.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.exp.viewmodel.e
        public void a(boolean isSuccess, int itemType, @Nullable String keyWord, int serverPageID, boolean isEnd, @Nullable List<? extends RecommendTroopItem> dataList, @NotNull guildSearchRecommendSvr$FirstShow firstShow, @NotNull ByteStringMicro sessionInfo, boolean isLoadMore) {
            Integer num;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), Integer.valueOf(itemType), keyWord, Integer.valueOf(serverPageID), Boolean.valueOf(isEnd), dataList, firstShow, sessionInfo, Boolean.valueOf(isLoadMore));
                return;
            }
            Intrinsics.checkNotNullParameter(firstShow, "firstShow");
            Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
            String Bh = AddContactViewPagerTroopFragmentV2.this.Bh();
            if (dataList != null) {
                num = Integer.valueOf(dataList.size());
            } else {
                num = null;
            }
            QLog.d("AddContactViewPagerTroopFragmentV2", 2, "onGetRecommendGroup(tab:" + Bh + ")  isSuccess:" + isSuccess + "  keyWord:" + keyWord + "   serverPageID:" + serverPageID + "    isEnd:" + isEnd + "   dataList.size:" + num + "   isLoadMore:" + isLoadMore);
            if (Intrinsics.areEqual(keyWord, AddContactViewPagerTroopFragmentV2.this.Bh())) {
                AddContactViewPagerTroopFragmentV2.this.Jh();
                if (isSuccess) {
                    if (!isLoadMore) {
                        AddContactViewPagerTroopFragmentV2.this.recommendDataList.clear();
                        AddContactViewPagerTroopFragmentV2.this.Lh(true);
                    }
                    AddContactViewPagerTroopFragmentV2.this.curPage = serverPageID;
                    if (dataList != null) {
                        AddContactViewPagerTroopFragmentV2.this.recommendDataList.addAll(dataList);
                    }
                    AddContactViewPagerTroopFragmentV2.this.Kh();
                    if (AddContactViewPagerTroopFragmentV2.this.recommendDataList.isEmpty()) {
                        AddContactViewPagerTroopFragmentV2.this.Mh(16, "\u6682\u65e0\u6570\u636e");
                    } else {
                        AddContactViewPagerTroopFragmentV2.this.Eh();
                    }
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/troop/findTroop/AddContactViewPagerTroopFragmentV2$c", "Lcom/tencent/mobileqq/troop/exp/viewmodel/f;", "", "reqtype", "result", "", "troopUin", "", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class c implements f {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddContactViewPagerTroopFragmentV2.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.exp.viewmodel.f
        public void a(int reqtype, int result, @Nullable String troopUin) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(reqtype), Integer.valueOf(result), troopUin);
                return;
            }
            QLog.d("AddContactViewPagerTroopFragmentV2", 1, "onTroopManagerSuccess, result:" + result + ", troopUin:" + troopUin);
            if (result == 0) {
                AddContactViewPagerTroopFragmentV2.this.Ah().y(troopUin);
            } else {
                AddContactViewPagerTroopFragmentV2.this.Ah().x(troopUin);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35554);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 20)) {
            redirector.redirect((short) 20);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AddContactViewPagerTroopFragmentV2() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        this.mApp = (AppInterface) peekAppRuntime;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.troop.findTroop.AddContactViewPagerTroopFragmentV2$tabKeyword$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AddContactViewPagerTroopFragmentV2.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                String string;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                Bundle arguments = AddContactViewPagerTroopFragmentV2.this.getArguments();
                return (arguments == null || (string = arguments.getString("tabKeyword")) == null) ? "" : string;
            }
        });
        this.tabKeyword = lazy;
        this.recommendDataList = new ArrayList<>();
        this.troopTabManager = new com.tencent.mobileqq.troop.findTroop.util.c(this);
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.troop.findTroop.adapter.a>() { // from class: com.tencent.mobileqq.troop.findTroop.AddContactViewPagerTroopFragmentV2$recommendTroopAdapter$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AddContactViewPagerTroopFragmentV2.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.troop.findTroop.adapter.a invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new com.tencent.mobileqq.troop.findTroop.adapter.a(AddContactViewPagerTroopFragmentV2.this.requireContext(), AddContactViewPagerTroopFragmentV2.this.zh(), false, AddContactViewPagerTroopFragmentV2.this.Bh()) : (com.tencent.mobileqq.troop.findTroop.adapter.a) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.recommendTroopAdapter = lazy2;
        this.curPage = -1;
        this.isFirstShow = true;
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(com.tencent.mobileqq.troop.exp.viewmodel.b.class), new Function0<ViewModelStore>() { // from class: com.tencent.mobileqq.troop.findTroop.AddContactViewPagerTroopFragmentV2$special$$inlined$activityViewModels$1
            static IPatchRedirector $redirector_;

            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) Fragment.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelStore invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (ViewModelStore) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                FragmentActivity requireActivity = Fragment.this.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                ViewModelStore viewModelStore = requireActivity.get_viewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.tencent.mobileqq.troop.findTroop.AddContactViewPagerTroopFragmentV2$viewModel$2
            static IPatchRedirector $redirector_;

            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/findTroop/AddContactViewPagerTroopFragmentV2$viewModel$2$a", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes19.dex */
            public static final class a extends ViewModelProvider.NewInstanceFactory {
                static IPatchRedirector $redirector_;

                /* renamed from: c, reason: collision with root package name */
                final /* synthetic */ AddContactViewPagerTroopFragmentV2 f296027c;

                a(AddContactViewPagerTroopFragmentV2 addContactViewPagerTroopFragmentV2) {
                    this.f296027c = addContactViewPagerTroopFragmentV2;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) addContactViewPagerTroopFragmentV2);
                    }
                }

                @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
                public <T extends ViewModel> T create(@NotNull Class<T> modelClass) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (T) iPatchRedirector.redirect((short) 2, (Object) this, (Object) modelClass);
                    }
                    Intrinsics.checkNotNullParameter(modelClass, "modelClass");
                    if (modelClass.isAssignableFrom(com.tencent.mobileqq.troop.exp.viewmodel.b.class)) {
                        AppInterface zh5 = this.f296027c.zh();
                        Intrinsics.checkNotNull(zh5);
                        return new com.tencent.mobileqq.troop.exp.viewmodel.b(zh5);
                    }
                    return (T) super.create(modelClass);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AddContactViewPagerTroopFragmentV2.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelProvider.Factory invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new a(AddContactViewPagerTroopFragmentV2.this) : (ViewModelProvider.Factory) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.searchRecommendObserver = new b();
        this.troopMngObserver = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.troop.findTroop.adapter.a Ah() {
        return (com.tencent.mobileqq.troop.findTroop.adapter.a) this.recommendTroopAdapter.getValue();
    }

    private final com.tencent.mobileqq.troop.exp.viewmodel.b Ch() {
        return (com.tencent.mobileqq.troop.exp.viewmodel.b) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Dh(AddContactViewPagerTroopFragmentV2 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.xh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Eh() {
        FrameLayout frameLayout = this.emptyLayout;
        Intrinsics.checkNotNull(frameLayout);
        if (frameLayout.getVisibility() != 8) {
            FrameLayout frameLayout2 = this.emptyLayout;
            Intrinsics.checkNotNull(frameLayout2);
            frameLayout2.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gh(AddContactViewPagerTroopFragmentV2 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.mFooterView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFooterView");
            textView = null;
        }
        textView.setVisibility(0);
        if (this$0.recommendDataList.isEmpty()) {
            this$0.xh();
        }
    }

    private final boolean Ih(AbsListView listView) {
        View childAt = listView.getChildAt(listView.getChildCount() - 1);
        TextView textView = this.mFooterView;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFooterView");
            textView = null;
        }
        if (childAt == textView) {
            TextView textView3 = this.mFooterView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFooterView");
                textView3 = null;
            }
            int bottom = textView3.getBottom();
            TextView textView4 = this.mFooterView;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFooterView");
            } else {
                textView2 = textView4;
            }
            if (bottom == textView2.getBottom()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Jh() {
        if (this.isNeedToNotifyAfterFetchData) {
            this.isNeedToNotifyAfterFetchData = false;
            this.troopTabManager.d(a.c.f296034a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Mh(int imageType, String errorMsg) {
        boolean z16;
        View view;
        FrameLayout frameLayout;
        FrameLayout frameLayout2 = this.emptyLayout;
        boolean z17 = true;
        if (frameLayout2 != null && frameLayout2.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && (frameLayout = this.emptyLayout) != null) {
            frameLayout.setVisibility(0);
        }
        FrameLayout frameLayout3 = this.emptyLayout;
        if (frameLayout3 == null || frameLayout3.getChildCount() != 0) {
            z17 = false;
        }
        if (z17) {
            QUIEmptyState build = new QUIEmptyState.Builder(requireContext()).setImageType(imageType).setDesc(errorMsg).build();
            FrameLayout frameLayout4 = this.emptyLayout;
            if (frameLayout4 != null) {
                frameLayout4.addView(build, -1, -1);
                return;
            }
            return;
        }
        FrameLayout frameLayout5 = this.emptyLayout;
        if (frameLayout5 != null) {
            view = frameLayout5.getChildAt(0);
        } else {
            view = null;
        }
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.biz.qui.quiemptystate.QUIEmptyState");
        QUIEmptyState qUIEmptyState = (QUIEmptyState) view;
        qUIEmptyState.setImageView(imageType);
        qUIEmptyState.setDesc(errorMsg);
    }

    private final void xh() {
        if (!NetworkUtil.isNetworkAvailable(BaseApplication.getContext())) {
            Jh();
            Mh(5, "\u7f51\u7edc\u9519\u8bef\uff0c\u8bf7\u68c0\u67e5\u540e\u91cd\u8bd5");
        } else {
            this.curPage = -1;
            Ch().S1(Bh(), this.curPage, false);
        }
    }

    @NotNull
    public final String Bh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return (String) this.tabKeyword.getValue();
    }

    @Override // com.tencent.mobileqq.troop.findTroop.util.b
    @Nullable
    public com.tencent.mobileqq.troop.findTroop.util.c F5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (com.tencent.mobileqq.troop.findTroop.util.c) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.troopTabManager;
    }

    public final void Fh() {
        XListView xListView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        View view = this.rootView;
        TextView textView = null;
        if (view != null) {
            xListView = (XListView) view.findViewById(R.id.dmd);
        } else {
            xListView = null;
        }
        this.mListView = xListView;
        if (xListView != null) {
            xListView.setSelector(R.color.ajr);
        }
        if (xListView != null) {
            xListView.setNeedCheckSpringback(true);
        }
        if (xListView != null) {
            xListView.setDivider(null);
        }
        if (xListView != null) {
            xListView.setClipToPadding(false);
        }
        if (xListView != null) {
            xListView.setScrollBarStyle(33554432);
        }
        if (xListView != null) {
            xListView.mForContacts = true;
        }
        if (xListView != null) {
            xListView.setOnScrollListener(this);
        }
        if (xListView != null) {
            xListView.setDividerHeight(0);
        }
        TextView textView2 = new TextView(requireContext());
        this.mFooterView = textView2;
        textView2.setGravity(17);
        int n3 = Utils.n(10.0f, getResources());
        TextView textView3 = this.mFooterView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFooterView");
            textView3 = null;
        }
        textView3.setPadding(n3, n3, n3, n3);
        XListView xListView2 = this.mListView;
        if (xListView2 != null) {
            TextView textView4 = this.mFooterView;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFooterView");
                textView4 = null;
            }
            xListView2.addFooterView(textView4);
        }
        if (xListView != null) {
            xListView.setAdapter((ListAdapter) Ah());
        }
        TextView textView5 = this.mFooterView;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFooterView");
        } else {
            textView = textView5;
        }
        textView.post(new Runnable() { // from class: com.tencent.mobileqq.troop.findTroop.a
            @Override // java.lang.Runnable
            public final void run() {
                AddContactViewPagerTroopFragmentV2.Gh(AddContactViewPagerTroopFragmentV2.this);
            }
        });
    }

    public final void Hh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (!this.recommendDataList.isEmpty()) {
            Kh();
        }
        Ch().P1(this.searchRecommendObserver);
        Ch().Q1(this.troopMngObserver);
    }

    public final void Kh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AddContactViewPagerTroopFragmentV2", 2, "refreshListView,this.dataList.size() = " + this.recommendDataList.size() + ",needResetListViewPosition = " + this.needResetListViewPosition);
        }
        Ah().v(this.recommendDataList);
        Ah().notifyDataSetChanged();
        if (this.needResetListViewPosition) {
            XListView xListView = this.mListView;
            if (xListView != null) {
                xListView.setSelection(0);
            }
            this.needResetListViewPosition = false;
        }
    }

    public final void Lh(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else {
            this.needResetListViewPosition = z16;
        }
    }

    @Override // com.tencent.mobileqq.troop.findTroop.util.b
    public void R2(@NotNull Object event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, event);
            return;
        }
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof a.C8696a) {
            List<RecommendTroopItem> a16 = ((a.C8696a) event).a();
            this.recommendDataList.clear();
            this.recommendDataList.addAll(a16);
            this.curPage = 0;
            if (this.rootView != null) {
                Kh();
                return;
            }
            return;
        }
        if (event instanceof a.d) {
            a.d dVar = (a.d) event;
            QLog.d("AddContactViewPagerTroopFragmentV2", 2, "handlerEvent AddContactsVPTroopEvent.TabShowEvent  getNodeId:" + af() + "  isShow:" + dVar.a());
            if (dVar.a() && this.isFirstShow) {
                this.isFirstShow = false;
                if (this.recommendDataList.isEmpty()) {
                    getMainHandler().post(new Runnable() { // from class: com.tencent.mobileqq.troop.findTroop.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            AddContactViewPagerTroopFragmentV2.Dh(AddContactViewPagerTroopFragmentV2.this);
                        }
                    });
                    return;
                }
                return;
            }
            return;
        }
        if (event instanceof a.b) {
            this.isNeedToNotifyAfterFetchData = true;
            xh();
        } else if (event instanceof a.e) {
            ((a.e) event).a().set(0, yh());
        }
    }

    @Override // com.tencent.mobileqq.troop.findTroop.util.b
    @NotNull
    public String af() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        if (Bh().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return Bh();
        }
        return b.a.a(this);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            view = (View) iPatchRedirector.redirect((short) 5, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            FrameLayout frameLayout = null;
            View inflate = inflater.inflate(R.layout.fok, (ViewGroup) null);
            this.rootView = inflate;
            if (inflate != null) {
                frameLayout = (FrameLayout) inflate.findViewById(R.id.bwi);
            }
            this.emptyLayout = frameLayout;
            Fh();
            view = this.rootView;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        Ch().W1(this.searchRecommendObserver);
        Ch().X1(this.troopMngObserver);
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            super.onResume();
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(@Nullable AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, view, Integer.valueOf(firstVisibleItem), Integer.valueOf(visibleItemCount), Integer.valueOf(totalItemCount));
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(@Nullable AbsListView view, int scrollState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) view, scrollState);
        } else if (view != null && scrollState == 0 && Ih(view) && !Ch().T1()) {
            Ch().S1(Bh(), this.curPage, true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Hh();
    }

    @Nullable
    public final XListView yh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (XListView) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.mListView;
    }

    @NotNull
    public final AppInterface zh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AppInterface) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mApp;
    }
}
