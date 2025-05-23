package com.tencent.robot.discoveryv2.troop.repository;

import a54.a;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotBaseInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotInfoFor0x91ee;
import com.tencent.qqnt.kernel.nativeinterface.ListNode;
import com.tencent.qqnt.kernel.nativeinterface.ListRobotRsp;
import com.tencent.robot.discoveryv2.common.data.FirstScreenFetchArgs;
import com.tencent.robot.discoveryv2.common.data.LoadState;
import com.tencent.robot.discoveryv2.common.data.RecommendRobotsData;
import com.tencent.robot.discoveryv2.common.data.SingleCategoryDetailData;
import com.tencent.robot.discoveryv2.common.data.SingleCategoryFetchArgs;
import com.tencent.robot.discoveryv2.common.data.SingleCategoryLoadData;
import com.tencent.robot.discoveryv2.common.data.SingleCategoryNextPageData;
import com.tencent.robot.discoveryv2.common.data.SingleCategoryRsp;
import com.tencent.robot.discoveryv2.common.platform.RobotPlatformApiImpl;
import com.tencent.robot.discoveryv2.common.repository.core.RepositoryParams;
import com.tencent.robot.discoveryv2.common.repository.proxy.AddedRobotsDataProxy;
import com.tencent.robot.discoveryv2.common.repository.proxy.CategoryTabDataProxy;
import com.tencent.robot.discoveryv2.common.repository.proxy.FirstScreenLoadStateProxy;
import com.tencent.robot.discoveryv2.common.repository.proxy.RecommendRobotsDataProxy;
import com.tencent.robot.discoveryv2.common.repository.proxy.SingleCategoryLoadStateProxy;
import com.tencent.robot.discoveryv2.troop.added.AddedRobotsData;
import com.tencent.robot.relation.api.IRobotRelationService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00cf\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0006*\u0001O\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u0001(B\u0007\u00a2\u0006\u0004\bR\u0010SJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J \u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J,\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010!\u001a\u00020 2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\"H\u0016J\b\u0010%\u001a\u00020\u0005H\u0016J\u0010\u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020&H\u0016J\u0010\u0010*\u001a\u00020\u00052\u0006\u0010'\u001a\u00020)H\u0016J\u000e\u0010-\u001a\b\u0012\u0004\u0012\u00020,0+H\u0016J\u000e\u0010/\u001a\b\u0012\u0004\u0012\u00020.0+H\u0016J\u000e\u00101\u001a\b\u0012\u0004\u0012\u0002000+H\u0016J\u000e\u00103\u001a\b\u0012\u0004\u0012\u0002020+H\u0016J\u0014\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00130+H\u0016J\u000e\u00106\u001a\b\u0012\u0004\u0012\u0002050+H\u0016J\u0012\u00108\u001a\u0004\u0018\u00010\u000f2\u0006\u00107\u001a\u00020 H\u0016J\u0010\u00109\u001a\u00020.2\u0006\u00107\u001a\u00020 H\u0016J\u0010\u0010:\u001a\u00020\r2\u0006\u00107\u001a\u00020 H\u0016R\u0014\u0010=\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010<R\u0014\u0010@\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010?R\u0014\u0010C\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010BR\u0014\u0010F\u001a\u00020D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u0010ER\u0014\u0010I\u001a\u00020G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010HR\u0016\u0010L\u001a\u00020J8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u0010KR\u0016\u0010N\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u0010MR\u0014\u0010Q\u001a\u00020O8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010P\u00a8\u0006T"}, d2 = {"Lcom/tencent/robot/discoveryv2/troop/repository/TroopRobotRepositoryDelegate;", "Lcom/tencent/robot/discoveryv2/common/repository/core/a;", "Lcom/tencent/robot/discoveryv2/troop/repository/a;", "Lcom/tencent/robot/discoveryv2/common/data/b;", "serverRspData", "", HippyTKDListViewAdapter.X, "y", "Lcom/tencent/qqnt/kernel/nativeinterface/ListRobotRsp;", "listRobotRsp", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/qqnt/kernel/nativeinterface/ListNode;", "category", "", "needAddCurRecommendList", "Lcom/tencent/robot/discoveryv2/common/data/e;", ReportConstant.COSTREPORT_PREFIX, "", "beginIndex", "", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotInfoFor0x91ee;", "robotList", "", "Ls34/b;", "r", "Lcom/tencent/robot/discoveryv2/common/data/j;", "singleCategoryRsp", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", BdhLogUtil.LogTag.Tag_Conn, "t", "u", "", "D", "Lcom/tencent/robot/discoveryv2/common/repository/core/c;", "repositoryParams", h.F, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/robot/discoveryv2/common/data/a;", "fetchArgs", "a", "Lcom/tencent/robot/discoveryv2/common/data/f;", "j", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/robot/discoveryv2/common/data/LoadState;", "b", "Lcom/tencent/robot/discoveryv2/common/data/g;", "i", "Lcom/tencent/robot/discoveryv2/troop/added/a;", "e", "Lcom/tencent/robot/discoveryv2/common/data/d;", "k", "d", "Lcom/tencent/robot/discoveryv2/common/data/i;", "g", "categoryId", "f", "c", "l", "Lcom/tencent/robot/discoveryv2/common/repository/proxy/FirstScreenLoadStateProxy;", "Lcom/tencent/robot/discoveryv2/common/repository/proxy/FirstScreenLoadStateProxy;", "mFirstScreenLoadStateProxy", "Lcom/tencent/robot/discoveryv2/common/repository/proxy/AddedRobotsDataProxy;", "Lcom/tencent/robot/discoveryv2/common/repository/proxy/AddedRobotsDataProxy;", "mAddedRobotsDataProxy", "Lcom/tencent/robot/discoveryv2/common/repository/proxy/CategoryTabDataProxy;", "Lcom/tencent/robot/discoveryv2/common/repository/proxy/CategoryTabDataProxy;", "mCategoryTabDataProxy", "Lcom/tencent/robot/discoveryv2/common/repository/proxy/SingleCategoryLoadStateProxy;", "Lcom/tencent/robot/discoveryv2/common/repository/proxy/SingleCategoryLoadStateProxy;", "mSingleCategoryLoadStateProxy", "Lcom/tencent/robot/discoveryv2/common/repository/proxy/RecommendRobotsDataProxy;", "Lcom/tencent/robot/discoveryv2/common/repository/proxy/RecommendRobotsDataProxy;", "mRecommendRobotsDataProxy", "Lp34/a;", "Lp34/a;", "mPlatformApi", "Lcom/tencent/robot/discoveryv2/common/repository/core/c;", "mRepositoryParams", "com/tencent/robot/discoveryv2/troop/repository/TroopRobotRepositoryDelegate$b", "Lcom/tencent/robot/discoveryv2/troop/repository/TroopRobotRepositoryDelegate$b;", "mRobotRelationObserver", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class TroopRobotRepositoryDelegate implements com.tencent.robot.discoveryv2.common.repository.core.a, a {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private p34.a mPlatformApi;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private RepositoryParams mRepositoryParams;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FirstScreenLoadStateProxy mFirstScreenLoadStateProxy = new FirstScreenLoadStateProxy();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AddedRobotsDataProxy mAddedRobotsDataProxy = new AddedRobotsDataProxy();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CategoryTabDataProxy mCategoryTabDataProxy = new CategoryTabDataProxy();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SingleCategoryLoadStateProxy mSingleCategoryLoadStateProxy = new SingleCategoryLoadStateProxy();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecommendRobotsDataProxy mRecommendRobotsDataProxy = new RecommendRobotsDataProxy();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mRobotRelationObserver = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/robot/discoveryv2/troop/repository/TroopRobotRepositoryDelegate$b", "La54/a;", "", "robotUin", "troopUin", "", WadlProxyConsts.EXTRA_DATA, "", "d", "f", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements a54.a {
        b() {
        }

        @Override // a54.a
        public void a(@NotNull String str) {
            a.C0013a.e(this, str);
        }

        @Override // a54.a
        public void b(@NotNull String str) {
            a.C0013a.d(this, str);
        }

        @Override // a54.a
        public void c(@NotNull String str) {
            a.C0013a.a(this, str);
        }

        @Override // a54.a
        public void d(@NotNull String robotUin, @NotNull String troopUin, @Nullable Object extraData) {
            Intrinsics.checkNotNullParameter(robotUin, "robotUin");
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            RepositoryParams repositoryParams = TroopRobotRepositoryDelegate.this.mRepositoryParams;
            GroupRobotBaseInfo groupRobotBaseInfo = null;
            if (repositoryParams == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRepositoryParams");
                repositoryParams = null;
            }
            if (!Intrinsics.areEqual(repositoryParams.getUin(), troopUin)) {
                return;
            }
            QLog.i("TroopRobotRepository", 1, "onAddRobotToGroupSucc robotUin = " + robotUin);
            if (extraData instanceof GroupRobotBaseInfo) {
                groupRobotBaseInfo = (GroupRobotBaseInfo) extraData;
            }
            if (groupRobotBaseInfo == null) {
                groupRobotBaseInfo = TroopRobotRepositoryDelegate.this.mRecommendRobotsDataProxy.e(robotUin);
            }
            if (groupRobotBaseInfo != null) {
                TroopRobotRepositoryDelegate.this.mAddedRobotsDataProxy.g(robotUin, groupRobotBaseInfo);
                TroopRobotRepositoryDelegate.this.mRecommendRobotsDataProxy.m(robotUin);
                return;
            }
            QLog.e("TroopRobotRepository", 1, "onAddRobotToGroupSucc robotUin = " + robotUin + " info is null");
        }

        @Override // a54.a
        public void e(@NotNull String str, @NotNull String str2, @Nullable Object obj) {
            a.C0013a.b(this, str, str2, obj);
        }

        @Override // a54.a
        public void f(@NotNull String robotUin, @NotNull String troopUin) {
            Intrinsics.checkNotNullParameter(robotUin, "robotUin");
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            RepositoryParams repositoryParams = TroopRobotRepositoryDelegate.this.mRepositoryParams;
            if (repositoryParams == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRepositoryParams");
                repositoryParams = null;
            }
            if (!Intrinsics.areEqual(repositoryParams.getUin(), troopUin)) {
                return;
            }
            QLog.i("TroopRobotRepository", 1, "onRemoveRobotFromGroupSucc robotUin = " + robotUin);
            TroopRobotRepositoryDelegate.this.mAddedRobotsDataProxy.h(robotUin);
            TroopRobotRepositoryDelegate.this.mRecommendRobotsDataProxy.n(robotUin);
        }
    }

    private final void A(SingleCategoryRsp singleCategoryRsp) {
        if (singleCategoryRsp.getResult() == 0 && singleCategoryRsp.getRsp() != null) {
            C(singleCategoryRsp);
        } else {
            B(singleCategoryRsp);
        }
    }

    private final void B(SingleCategoryRsp singleCategoryRsp) {
        QLog.i("TroopRobotRepository", 1, "onReceiveSingleCategoryDataFailed result = " + singleCategoryRsp.getResult() + " errorMsg = " + singleCategoryRsp.getErrorMsg());
        SingleCategoryLoadStateProxy singleCategoryLoadStateProxy = this.mSingleCategoryLoadStateProxy;
        singleCategoryLoadStateProxy.f(singleCategoryRsp.getFetchArgs().getCategoryId(), LoadState.LOAD_FAILED, singleCategoryRsp.getFetchArgs().getLoadType());
        singleCategoryLoadStateProxy.d(singleCategoryRsp.getFetchArgs().getCategoryId());
    }

    private final void C(SingleCategoryRsp singleCategoryRsp) {
        ListRobotRsp rsp = singleCategoryRsp.getRsp();
        Intrinsics.checkNotNull(rsp);
        if (!rsp.isPoolRefresh) {
            t(singleCategoryRsp);
        } else {
            u(singleCategoryRsp);
        }
    }

    private final String D(ListRobotRsp listRobotRsp) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("tabRobotsSize = " + listRobotRsp.tabRobots.size());
        sb5.append("addedRobots = " + listRobotRsp.addedRobots.size() + " ");
        sb5.append("tabsSize = " + listRobotRsp.tabInfo.tabs.size() + " ");
        sb5.append("curCategoryId = " + listRobotRsp.tabInfo.curTab.listId);
        sb5.append("haveNextPage = " + listRobotRsp.haveNextPage);
        sb5.append("isPoolRefresh = " + listRobotRsp.isPoolRefresh);
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder()\n        \u2026)\n            .toString()");
        return sb6;
    }

    private final List<s34.b> r(int beginIndex, ListNode category, List<GroupRobotInfoFor0x91ee> robotList) {
        ListNode listNode = category;
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (Object obj : robotList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            GroupRobotInfoFor0x91ee groupRobotInfoFor0x91ee = (GroupRobotInfoFor0x91ee) obj;
            RepositoryParams repositoryParams = this.mRepositoryParams;
            if (repositoryParams == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRepositoryParams");
                repositoryParams = null;
            }
            String uin = repositoryParams.getUin();
            String valueOf = String.valueOf(groupRobotInfoFor0x91ee.baseInfo.robotUin);
            String str = groupRobotInfoFor0x91ee.baseInfo.robotName;
            Intrinsics.checkNotNullExpressionValue(str, "groupRobotInfoFor0x91ee.baseInfo.robotName");
            String str2 = groupRobotInfoFor0x91ee.baseInfo.robotAvatar;
            Intrinsics.checkNotNullExpressionValue(str2, "groupRobotInfoFor0x91ee.baseInfo.robotAvatar");
            String str3 = groupRobotInfoFor0x91ee.baseInfo.robotDesc;
            Intrinsics.checkNotNullExpressionValue(str3, "groupRobotInfoFor0x91ee.baseInfo.robotDesc");
            ArrayList<String> arrayList2 = groupRobotInfoFor0x91ee.labels;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "groupRobotInfoFor0x91ee.labels");
            int i17 = beginIndex + i3 + 1;
            String str4 = listNode.listId;
            Intrinsics.checkNotNullExpressionValue(str4, "category.listId");
            String str5 = listNode.listName;
            Intrinsics.checkNotNullExpressionValue(str5, "category.listName");
            arrayList.add(new s34.b(uin, valueOf, str, str2, str3, arrayList2, i17, str4, str5, groupRobotInfoFor0x91ee.isAdded));
            listNode = category;
            i3 = i16;
        }
        return arrayList;
    }

    private final SingleCategoryDetailData s(ListNode category, ListRobotRsp listRobotRsp, boolean needAddCurRecommendList) {
        List<s34.b> emptyList;
        ArrayList arrayList = new ArrayList();
        if (needAddCurRecommendList) {
            RecommendRobotsDataProxy recommendRobotsDataProxy = this.mRecommendRobotsDataProxy;
            String str = category.listId;
            Intrinsics.checkNotNullExpressionValue(str, "category.listId");
            SingleCategoryDetailData f16 = recommendRobotsDataProxy.f(str);
            if (f16 == null || (emptyList = f16.c()) == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            }
            arrayList.addAll(emptyList);
        }
        int size = arrayList.size();
        ArrayList<GroupRobotInfoFor0x91ee> arrayList2 = listRobotRsp.tabRobots;
        Intrinsics.checkNotNullExpressionValue(arrayList2, "listRobotRsp.tabRobots");
        arrayList.addAll(r(size, category, arrayList2));
        HashSet hashSet = new HashSet();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            hashSet.add(((s34.b) it.next()).k());
        }
        String str2 = category.listId;
        Intrinsics.checkNotNullExpressionValue(str2, "category.listId");
        byte[] bArr = listRobotRsp.rspPagingCookie;
        String str3 = listRobotRsp.dataVersion;
        Intrinsics.checkNotNullExpressionValue(str3, "listRobotRsp.dataVersion");
        return new SingleCategoryDetailData(str2, bArr, str3, listRobotRsp.haveNextPage, arrayList, hashSet);
    }

    private final void t(SingleCategoryRsp singleCategoryRsp) {
        ListRobotRsp rsp = singleCategoryRsp.getRsp();
        Intrinsics.checkNotNull(rsp);
        QLog.i("TroopRobotRepository", 1, "handleSingleCategoryRspDataCommon categoryId = " + singleCategoryRsp.getFetchArgs().getCategoryId() + " uin = " + singleCategoryRsp.getFetchArgs().getUin() + " " + D(rsp));
        ListNode listNode = new ListNode();
        listNode.listId = singleCategoryRsp.getFetchArgs().getCategoryId();
        listNode.listName = singleCategoryRsp.getFetchArgs().getCategoryName();
        SingleCategoryDetailData s16 = s(listNode, rsp, true);
        RecommendRobotsDataProxy recommendRobotsDataProxy = this.mRecommendRobotsDataProxy;
        String str = listNode.listId;
        Intrinsics.checkNotNullExpressionValue(str, "category.listId");
        recommendRobotsDataProxy.o(str, s16);
        SingleCategoryLoadStateProxy singleCategoryLoadStateProxy = this.mSingleCategoryLoadStateProxy;
        singleCategoryLoadStateProxy.f(singleCategoryRsp.getFetchArgs().getCategoryId(), LoadState.LOAD_SUCCESS, singleCategoryRsp.getFetchArgs().getLoadType());
        singleCategoryLoadStateProxy.d(singleCategoryRsp.getFetchArgs().getCategoryId());
        RecommendRobotsDataProxy recommendRobotsDataProxy2 = this.mRecommendRobotsDataProxy;
        String str2 = listNode.listId;
        Intrinsics.checkNotNullExpressionValue(str2, "category.listId");
        recommendRobotsDataProxy2.j(str2);
        String str3 = listNode.listId;
        Intrinsics.checkNotNullExpressionValue(str3, "category.listId");
        recommendRobotsDataProxy2.i(str3);
    }

    private final void u(SingleCategoryRsp singleCategoryRsp) {
        int collectionSizeOrDefault;
        ListRobotRsp rsp = singleCategoryRsp.getRsp();
        Intrinsics.checkNotNull(rsp);
        QLog.i("TroopRobotRepository", 1, "handleSingleCategoryRspDataPoolChanged " + D(rsp));
        CategoryTabDataProxy categoryTabDataProxy = this.mCategoryTabDataProxy;
        ArrayList<ListNode> arrayList = rsp.tabInfo.tabs;
        Intrinsics.checkNotNullExpressionValue(arrayList, "listRobotRsp.tabInfo.tabs");
        categoryTabDataProxy.d(arrayList);
        ListNode category = rsp.tabInfo.curTab;
        Intrinsics.checkNotNullExpressionValue(category, "category");
        SingleCategoryDetailData s16 = s(category, rsp, false);
        AddedRobotsDataProxy addedRobotsDataProxy = this.mAddedRobotsDataProxy;
        int i3 = rsp.maxRobotNum;
        ArrayList<GroupRobotInfoFor0x91ee> arrayList2 = rsp.addedRobots;
        Intrinsics.checkNotNullExpressionValue(arrayList2, "listRobotRsp.addedRobots");
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(((GroupRobotInfoFor0x91ee) it.next()).baseInfo);
        }
        addedRobotsDataProxy.i(i3, arrayList3);
        RecommendRobotsDataProxy recommendRobotsDataProxy = this.mRecommendRobotsDataProxy;
        recommendRobotsDataProxy.d();
        String str = category.listId;
        Intrinsics.checkNotNullExpressionValue(str, "category.listId");
        recommendRobotsDataProxy.o(str, s16);
        SingleCategoryLoadStateProxy singleCategoryLoadStateProxy = this.mSingleCategoryLoadStateProxy;
        singleCategoryLoadStateProxy.f(singleCategoryRsp.getFetchArgs().getCategoryId(), LoadState.LOAD_SUCCESS, singleCategoryRsp.getFetchArgs().getLoadType());
        singleCategoryLoadStateProxy.d(singleCategoryRsp.getFetchArgs().getCategoryId());
        RecommendRobotsDataProxy recommendRobotsDataProxy2 = this.mRecommendRobotsDataProxy;
        String str2 = category.listId;
        Intrinsics.checkNotNullExpressionValue(str2, "category.listId");
        recommendRobotsDataProxy2.j(str2);
        String str3 = category.listId;
        Intrinsics.checkNotNullExpressionValue(str3, "category.listId");
        recommendRobotsDataProxy2.i(str3);
        this.mCategoryTabDataProxy.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object v(TroopRobotRepositoryDelegate troopRobotRepositoryDelegate, com.tencent.robot.discoveryv2.common.data.b bVar, Continuation continuation) {
        troopRobotRepositoryDelegate.x(bVar);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object w(TroopRobotRepositoryDelegate troopRobotRepositoryDelegate, SingleCategoryRsp singleCategoryRsp, Continuation continuation) {
        troopRobotRepositoryDelegate.A(singleCategoryRsp);
        return Unit.INSTANCE;
    }

    private final void x(com.tencent.robot.discoveryv2.common.data.b serverRspData) {
        if (serverRspData.getResult() == 0 && serverRspData.getRsp() != null) {
            z(serverRspData.getRsp());
        } else {
            y(serverRspData);
        }
    }

    private final void y(com.tencent.robot.discoveryv2.common.data.b serverRspData) {
        QLog.i("TroopRobotRepository", 1, "onReceiveFirstScreenDataFailed result = " + serverRspData.getResult() + " + errorMsg = " + serverRspData.getErrorMsg());
        FirstScreenLoadStateProxy firstScreenLoadStateProxy = this.mFirstScreenLoadStateProxy;
        firstScreenLoadStateProxy.e(LoadState.LOAD_FAILED);
        firstScreenLoadStateProxy.d();
    }

    private final void z(ListRobotRsp listRobotRsp) {
        int collectionSizeOrDefault;
        QLog.i("TroopRobotRepository", 1, "onReceiveFirstScreenDataSuccess " + D(listRobotRsp));
        AddedRobotsDataProxy addedRobotsDataProxy = this.mAddedRobotsDataProxy;
        int i3 = listRobotRsp.maxRobotNum;
        ArrayList<GroupRobotInfoFor0x91ee> arrayList = listRobotRsp.addedRobots;
        Intrinsics.checkNotNullExpressionValue(arrayList, "listRobotRsp.addedRobots");
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((GroupRobotInfoFor0x91ee) it.next()).baseInfo);
        }
        addedRobotsDataProxy.i(i3, arrayList2);
        CategoryTabDataProxy categoryTabDataProxy = this.mCategoryTabDataProxy;
        ArrayList<ListNode> arrayList3 = listRobotRsp.tabInfo.tabs;
        Intrinsics.checkNotNullExpressionValue(arrayList3, "listRobotRsp.tabInfo.tabs");
        categoryTabDataProxy.d(arrayList3);
        ListNode category = listRobotRsp.tabInfo.curTab;
        Intrinsics.checkNotNullExpressionValue(category, "category");
        SingleCategoryDetailData s16 = s(category, listRobotRsp, false);
        RecommendRobotsDataProxy recommendRobotsDataProxy = this.mRecommendRobotsDataProxy;
        recommendRobotsDataProxy.d();
        String str = category.listId;
        Intrinsics.checkNotNullExpressionValue(str, "category.listId");
        recommendRobotsDataProxy.o(str, s16);
        FirstScreenLoadStateProxy firstScreenLoadStateProxy = this.mFirstScreenLoadStateProxy;
        firstScreenLoadStateProxy.e(LoadState.LOAD_SUCCESS);
        firstScreenLoadStateProxy.d();
        this.mAddedRobotsDataProxy.d();
        RecommendRobotsDataProxy recommendRobotsDataProxy2 = this.mRecommendRobotsDataProxy;
        String str2 = category.listId;
        Intrinsics.checkNotNullExpressionValue(str2, "category.listId");
        recommendRobotsDataProxy2.j(str2);
        String str3 = category.listId;
        Intrinsics.checkNotNullExpressionValue(str3, "category.listId");
        recommendRobotsDataProxy2.i(str3);
        this.mCategoryTabDataProxy.c();
    }

    @Override // com.tencent.robot.discoveryv2.common.repository.core.b
    public void a(@NotNull FirstScreenFetchArgs fetchArgs) {
        Intrinsics.checkNotNullParameter(fetchArgs, "fetchArgs");
        FirstScreenLoadStateProxy firstScreenLoadStateProxy = this.mFirstScreenLoadStateProxy;
        if (firstScreenLoadStateProxy.c()) {
            return;
        }
        firstScreenLoadStateProxy.e(LoadState.LOADING);
        firstScreenLoadStateProxy.d();
        QLog.i("TroopRobotRepository", 1, "fetchFirstScreenDataFromServer uin = " + fetchArgs.getUin());
        p34.a aVar = this.mPlatformApi;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlatformApi");
            aVar = null;
        }
        aVar.a(fetchArgs);
    }

    @Override // com.tencent.robot.discoveryv2.common.repository.core.b
    @NotNull
    public Flow<LoadState> b() {
        return this.mFirstScreenLoadStateProxy.b();
    }

    @Override // com.tencent.robot.discoveryv2.common.repository.core.b
    @NotNull
    public SingleCategoryLoadData c(@NotNull String categoryId) {
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        return this.mSingleCategoryLoadStateProxy.b(categoryId);
    }

    @Override // com.tencent.robot.discoveryv2.common.repository.core.b
    @NotNull
    public Flow<List<ListNode>> d() {
        return this.mCategoryTabDataProxy.b();
    }

    @Override // com.tencent.robot.discoveryv2.troop.repository.a
    @NotNull
    public Flow<AddedRobotsData> e() {
        return this.mAddedRobotsDataProxy.b();
    }

    @Override // com.tencent.robot.discoveryv2.common.repository.core.b
    @Nullable
    public SingleCategoryDetailData f(@NotNull String categoryId) {
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        return this.mRecommendRobotsDataProxy.f(categoryId);
    }

    @Override // com.tencent.robot.discoveryv2.common.repository.core.b
    @NotNull
    public Flow<SingleCategoryNextPageData> g() {
        return this.mRecommendRobotsDataProxy.g();
    }

    @Override // com.tencent.robot.discoveryv2.common.repository.core.b
    public void h(@NotNull RepositoryParams repositoryParams) {
        Intrinsics.checkNotNullParameter(repositoryParams, "repositoryParams");
        this.mRepositoryParams = repositoryParams;
        RepositoryParams repositoryParams2 = this.mRepositoryParams;
        IRuntimeService iRuntimeService = null;
        if (repositoryParams2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRepositoryParams");
            repositoryParams2 = null;
        }
        RobotPlatformApiImpl robotPlatformApiImpl = new RobotPlatformApiImpl(repositoryParams2.getLifecycleOwner());
        this.mPlatformApi = robotPlatformApiImpl;
        Flow flowOn = FlowKt.flowOn(FlowKt.onEach(robotPlatformApiImpl.c(), new TroopRobotRepositoryDelegate$onCreate$1(this)), Dispatchers.getMain());
        RepositoryParams repositoryParams3 = this.mRepositoryParams;
        if (repositoryParams3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRepositoryParams");
            repositoryParams3 = null;
        }
        FlowKt.launchIn(flowOn, LifecycleOwnerKt.getLifecycleScope(repositoryParams3.getLifecycleOwner()));
        p34.a aVar = this.mPlatformApi;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlatformApi");
            aVar = null;
        }
        Flow flowOn2 = FlowKt.flowOn(FlowKt.onEach(aVar.d(), new TroopRobotRepositoryDelegate$onCreate$2(this)), Dispatchers.getMain());
        RepositoryParams repositoryParams4 = this.mRepositoryParams;
        if (repositoryParams4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRepositoryParams");
            repositoryParams4 = null;
        }
        FlowKt.launchIn(flowOn2, LifecycleOwnerKt.getLifecycleScope(repositoryParams4.getLifecycleOwner()));
        AddedRobotsDataProxy addedRobotsDataProxy = this.mAddedRobotsDataProxy;
        RepositoryParams repositoryParams5 = this.mRepositoryParams;
        if (repositoryParams5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRepositoryParams");
            repositoryParams5 = null;
        }
        addedRobotsDataProxy.e(repositoryParams5);
        RecommendRobotsDataProxy recommendRobotsDataProxy = this.mRecommendRobotsDataProxy;
        RepositoryParams repositoryParams6 = this.mRepositoryParams;
        if (repositoryParams6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRepositoryParams");
            repositoryParams6 = null;
        }
        recommendRobotsDataProxy.k(repositoryParams6);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            iRuntimeService = peekAppRuntime.getRuntimeService(IRobotRelationService.class, "");
        }
        IRobotRelationService iRobotRelationService = (IRobotRelationService) iRuntimeService;
        if (iRobotRelationService != null) {
            iRobotRelationService.addRelationObserver(this.mRobotRelationObserver);
        }
    }

    @Override // com.tencent.robot.discoveryv2.common.repository.core.b
    @NotNull
    public Flow<SingleCategoryLoadData> i() {
        return this.mSingleCategoryLoadStateProxy.e();
    }

    @Override // com.tencent.robot.discoveryv2.common.repository.core.b
    public void j(@NotNull SingleCategoryFetchArgs fetchArgs) {
        byte[] bArr;
        String str;
        Intrinsics.checkNotNullParameter(fetchArgs, "fetchArgs");
        SingleCategoryDetailData f16 = this.mRecommendRobotsDataProxy.f(fetchArgs.getCategoryId());
        if (f16 != null && !f16.getHaveNextPage()) {
            QLog.i("TroopRobotRepository", 1, "fetchSingleCategoryData haveNextPage false");
            return;
        }
        SingleCategoryLoadStateProxy singleCategoryLoadStateProxy = this.mSingleCategoryLoadStateProxy;
        if (singleCategoryLoadStateProxy.c(fetchArgs.getCategoryId())) {
            return;
        }
        singleCategoryLoadStateProxy.f(fetchArgs.getCategoryId(), LoadState.LOADING, fetchArgs.getLoadType());
        singleCategoryLoadStateProxy.d(fetchArgs.getCategoryId());
        QLog.i("TroopRobotRepository", 1, "fetchSingleCategoryDataFromServer uin = " + fetchArgs.getUin());
        p34.a aVar = this.mPlatformApi;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlatformApi");
            aVar = null;
        }
        if (f16 == null || (bArr = f16.getSvrCookie()) == null) {
            bArr = new byte[0];
        }
        if (f16 == null || (str = f16.getSvrDataVersion()) == null) {
            str = "";
        }
        aVar.b(fetchArgs, bArr, str);
    }

    @Override // com.tencent.robot.discoveryv2.common.repository.core.b
    @NotNull
    public Flow<RecommendRobotsData> k() {
        return this.mRecommendRobotsDataProxy.c();
    }

    @Override // com.tencent.robot.discoveryv2.common.repository.core.b
    public boolean l(@NotNull String categoryId) {
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        SingleCategoryDetailData f16 = this.mRecommendRobotsDataProxy.f(categoryId);
        if (f16 != null) {
            return f16.getHaveNextPage();
        }
        return true;
    }

    @Override // com.tencent.robot.discoveryv2.common.repository.core.b
    public void onDestroy() {
        IRuntimeService iRuntimeService;
        this.mAddedRobotsDataProxy.f();
        this.mRecommendRobotsDataProxy.l();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            iRuntimeService = peekAppRuntime.getRuntimeService(IRobotRelationService.class, "");
        } else {
            iRuntimeService = null;
        }
        IRobotRelationService iRobotRelationService = (IRobotRelationService) iRuntimeService;
        if (iRobotRelationService != null) {
            iRobotRelationService.removeRelationObserver(this.mRobotRelationObserver);
        }
    }
}
