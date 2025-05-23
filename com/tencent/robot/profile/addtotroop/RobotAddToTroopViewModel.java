package com.tencent.robot.profile.addtotroop;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.aa;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.AddRobotGroupInfo;
import com.tencent.qqnt.kernel.nativeinterface.IGetAddRobotGroupListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelRecentGetContactCallback;
import com.tencent.qqnt.kernel.nativeinterface.QueryAddRobotGroupListReq;
import com.tencent.qqnt.kernel.nativeinterface.QueryAddRobotGroupListRsp;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.robot.profile.data.AddToTroopData;
import com.tencent.robot.profile.data.AddToTroopTitleData;
import com.tencent.robot.profile.data.ShareToTroopData;
import java.util.ArrayList;
import java.util.List;
import kotlin.C11736d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 .2\u00020\u0001:\u0001/B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u00a2\u0006\u0004\b,\u0010-J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u0017\u0010\n\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\r\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\f\u0010\tR \u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u001aR\"\u0010'\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u001a\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001d\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0(8F\u00a2\u0006\u0006\u001a\u0004\b)\u0010*\u00a8\u00060"}, d2 = {"Lcom/tencent/robot/profile/addtotroop/RobotAddToTroopViewModel;", "Landroidx/lifecycle/ViewModel;", "", "T1", "W1", "", "i", "Ljava/lang/String;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "()Ljava/lang/String;", "robotUin", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getTroopUin", "troopUin", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/tencent/robot/profile/data/a;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "_addToTroopListLiveData", "", "D", "[B", "cookie", "", "E", "Z", "hasShowShareTitle", "", UserInfo.SEX_FEMALE, "Ljava/util/List;", "recentGroupIdList", "G", "isFetching", "H", "b2", "()Z", "c2", "(Z)V", "isEnd", "Landroidx/lifecycle/LiveData;", "Z1", "()Landroidx/lifecycle/LiveData;", "addToTroopListLiveData", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "I", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotAddToTroopViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<com.tencent.robot.profile.data.a>> _addToTroopListLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private byte[] cookie;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean hasShowShareTitle;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final List<String> recentGroupIdList;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isFetching;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isEnd;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String robotUin;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    public RobotAddToTroopViewModel(@NotNull String robotUin, @NotNull String troopUin) {
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        this.robotUin = robotUin;
        this.troopUin = troopUin;
        this._addToTroopListLiveData = new MutableLiveData<>();
        this.cookie = new byte[0];
        this.recentGroupIdList = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U1(final RobotAddToTroopViewModel this$0, final int i3, final String str, final QueryAddRobotGroupListRsp queryAddRobotGroupListRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        C11736d.c(new Function0<Unit>() { // from class: com.tencent.robot.profile.addtotroop.RobotAddToTroopViewModel$fetchAddToTroopListData$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                boolean z16;
                MutableLiveData mutableLiveData3;
                List list;
                MutableLiveData mutableLiveData4;
                MutableLiveData mutableLiveData5;
                RobotAddToTroopViewModel.this.isFetching = false;
                int i16 = i3;
                String str2 = str;
                int size = queryAddRobotGroupListRsp.groupList.size();
                byte[] bArr = queryAddRobotGroupListRsp.cookie;
                Intrinsics.checkNotNullExpressionValue(bArr, "rsp.cookie");
                QLog.i("RobotAddToTroopViewModel", 2, "fetchAddToTroopListData res=" + i16 + " errMsg=" + str2 + " listSize=" + size + " cookie=" + new String(bArr, Charsets.UTF_8));
                ArrayList arrayList = new ArrayList();
                mutableLiveData = RobotAddToTroopViewModel.this._addToTroopListLiveData;
                List list2 = (List) mutableLiveData.getValue();
                if (list2 != null) {
                    arrayList.addAll(list2);
                }
                if (i3 != 0) {
                    mutableLiveData5 = RobotAddToTroopViewModel.this._addToTroopListLiveData;
                    mutableLiveData5.setValue(arrayList);
                    return;
                }
                RobotAddToTroopViewModel robotAddToTroopViewModel = RobotAddToTroopViewModel.this;
                byte[] bArr2 = queryAddRobotGroupListRsp.cookie;
                Intrinsics.checkNotNullExpressionValue(bArr2, "rsp.cookie");
                robotAddToTroopViewModel.cookie = bArr2;
                if (queryAddRobotGroupListRsp.groupList.isEmpty()) {
                    RobotAddToTroopViewModel.this.c2(true);
                    mutableLiveData4 = RobotAddToTroopViewModel.this._addToTroopListLiveData;
                    mutableLiveData4.setValue(arrayList);
                    return;
                }
                ArrayList<AddRobotGroupInfo> arrayList2 = new ArrayList();
                ArrayList<AddRobotGroupInfo> arrayList3 = queryAddRobotGroupListRsp.groupList;
                Intrinsics.checkNotNullExpressionValue(arrayList3, "rsp.groupList");
                RobotAddToTroopViewModel robotAddToTroopViewModel2 = RobotAddToTroopViewModel.this;
                for (AddRobotGroupInfo it : arrayList3) {
                    if (!it.canAdd) {
                        list = robotAddToTroopViewModel2.recentGroupIdList;
                        if (list.contains(String.valueOf(it.groupId))) {
                        }
                    }
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    arrayList2.add(it);
                }
                if (arrayList.isEmpty()) {
                    if ((!arrayList2.isEmpty()) && !((AddRobotGroupInfo) arrayList2.get(0)).canAdd) {
                        QLog.e("RobotAddToTroopViewModel", 1, "backend return err");
                        mutableLiveData3 = RobotAddToTroopViewModel.this._addToTroopListLiveData;
                        mutableLiveData3.setValue(arrayList);
                        return;
                    }
                    arrayList.add(new AddToTroopTitleData(false, "addTitle"));
                }
                RobotAddToTroopViewModel robotAddToTroopViewModel3 = RobotAddToTroopViewModel.this;
                for (AddRobotGroupInfo addRobotGroupInfo : arrayList2) {
                    z16 = robotAddToTroopViewModel3.hasShowShareTitle;
                    if (!z16 && !addRobotGroupInfo.canAdd) {
                        arrayList.add(new AddToTroopTitleData(true, "shareTitle"));
                        robotAddToTroopViewModel3.hasShowShareTitle = true;
                    }
                    if (addRobotGroupInfo.canAdd) {
                        String robotUin = robotAddToTroopViewModel3.getRobotUin();
                        String str3 = addRobotGroupInfo.groupName;
                        Intrinsics.checkNotNullExpressionValue(str3, "it.groupName");
                        arrayList.add(new AddToTroopData(robotUin, str3, String.valueOf(addRobotGroupInfo.groupId), addRobotGroupInfo.inGroup));
                    } else {
                        String robotUin2 = robotAddToTroopViewModel3.getRobotUin();
                        String str4 = addRobotGroupInfo.groupName;
                        Intrinsics.checkNotNullExpressionValue(str4, "it.groupName");
                        arrayList.add(new ShareToTroopData(robotUin2, str4, String.valueOf(addRobotGroupInfo.groupId)));
                    }
                }
                mutableLiveData2 = RobotAddToTroopViewModel.this._addToTroopListLiveData;
                mutableLiveData2.setValue(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X1(RobotAddToTroopViewModel this$0, int i3, String str, ArrayList relation) {
        List<RecentContactInfo> list;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("RobotAddToTroopViewModel", 1, "firstFetch result=" + i3 + " errMsg=" + str + " relationSize=" + relation.size());
        if (i3 == 0) {
            Intrinsics.checkNotNullExpressionValue(relation, "relation");
            if (!relation.isEmpty()) {
                list = CollectionsKt___CollectionsKt.toList(relation);
                for (RecentContactInfo recentContactInfo : list) {
                    if (recentContactInfo.chatType == 2) {
                        List<String> list2 = this$0.recentGroupIdList;
                        String str2 = recentContactInfo.peerUid;
                        Intrinsics.checkNotNullExpressionValue(str2, "it.peerUid");
                        list2.add(str2);
                    }
                }
                QLog.i("RobotAddToTroopViewModel", 2, "firstFetch recentGroupIdList=" + this$0.recentGroupIdList);
            }
        }
        this$0.T1();
    }

    public final void T1() {
        Long longOrNull;
        long j3;
        IRuntimeService iRuntimeService;
        ac robotService;
        if (!this.isFetching) {
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(this.robotUin);
            if (longOrNull != null) {
                j3 = longOrNull.longValue();
            } else {
                j3 = 0;
            }
            QueryAddRobotGroupListReq queryAddRobotGroupListReq = new QueryAddRobotGroupListReq(j3, this.cookie);
            QLog.i("RobotAddToTroopViewModel", 2, "fetchAddToTroopListData ruin=" + this.robotUin + " cookie=" + new String(this.cookie, Charsets.UTF_8));
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                iRuntimeService = peekAppRuntime.getRuntimeService(IKernelService.class, "");
            } else {
                iRuntimeService = null;
            }
            IKernelService iKernelService = (IKernelService) iRuntimeService;
            if (iKernelService != null && (robotService = iKernelService.getRobotService()) != null) {
                this.isFetching = true;
                robotService.fetchAddRobotGroupList(queryAddRobotGroupListReq, new IGetAddRobotGroupListCallback() { // from class: com.tencent.robot.profile.addtotroop.f
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IGetAddRobotGroupListCallback
                    public final void onResult(int i3, String str, QueryAddRobotGroupListRsp queryAddRobotGroupListRsp) {
                        RobotAddToTroopViewModel.U1(RobotAddToTroopViewModel.this, i3, str, queryAddRobotGroupListRsp);
                    }
                });
                return;
            }
            return;
        }
        QLog.i("RobotAddToTroopViewModel", 1, "fetchAddToTroopListData isFetching return");
    }

    public final void W1() {
        IRuntimeService iRuntimeService;
        aa recentContactService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            iRuntimeService = peekAppRuntime.getRuntimeService(IKernelService.class, "");
        } else {
            iRuntimeService = null;
        }
        IKernelService iKernelService = (IKernelService) iRuntimeService;
        if (iKernelService != null && (recentContactService = iKernelService.getRecentContactService()) != null) {
            recentContactService.getRecentContactInfos(new IKernelRecentGetContactCallback() { // from class: com.tencent.robot.profile.addtotroop.g
                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRecentGetContactCallback
                public final void onResult(int i3, String str, ArrayList arrayList) {
                    RobotAddToTroopViewModel.X1(RobotAddToTroopViewModel.this, i3, str, arrayList);
                }
            });
        }
    }

    @NotNull
    public final LiveData<List<com.tencent.robot.profile.data.a>> Z1() {
        return this._addToTroopListLiveData;
    }

    @NotNull
    /* renamed from: a2, reason: from getter */
    public final String getRobotUin() {
        return this.robotUin;
    }

    /* renamed from: b2, reason: from getter */
    public final boolean getIsEnd() {
        return this.isEnd;
    }

    public final void c2(boolean z16) {
        this.isEnd = z16;
    }
}
