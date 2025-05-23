package com.tencent.robot.discover.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotStoreDiscoveryReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotStoreDiscoveryRsp;
import com.tencent.qqnt.kernel.nativeinterface.IGroupRobotStoreDiscoveryCallback;
import com.tencent.qqnt.kernel.nativeinterface.RobotBase;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n0\tJ\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\tJ,\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\r2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000bJ\u0006\u0010\u0015\u001a\u00020\u0006J\u0010\u0010\u0016\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R \u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R&\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/robot/discover/viewmodel/d;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "troopUin", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotStoreDiscoveryRsp;", "rsp", "", "T1", "getLogTag", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Pair;", "", "S1", "", "Lk34/a;", "R1", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotBase;", "robotList", "maxNum", "robotNum", "W1", "O1", "P1", "i", "Landroidx/lifecycle/MutableLiveData;", "mListData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mTitleData", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class d extends BaseViewModel {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<k34.a>> mListData = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Pair<Integer, Integer>> mTitleData = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q1(d this$0, String str, int i3, String str2, GroupRobotStoreDiscoveryRsp groupRobotStoreDiscoveryRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0 && groupRobotStoreDiscoveryRsp != null) {
            this$0.T1(str, groupRobotStoreDiscoveryRsp);
            return;
        }
        QLog.e(this$0.getTAG(), 1, "fetchRobotDiscoverList result:" + i3 + " errMsg:" + str2 + " " + str);
    }

    private final void T1(String troopUin, final GroupRobotStoreDiscoveryRsp rsp) {
        final ArrayList arrayList = new ArrayList();
        Iterator<RobotBase> it = rsp.addedRobots.iterator();
        while (it.hasNext()) {
            RobotBase robot = it.next();
            Intrinsics.checkNotNullExpressionValue(robot, "robot");
            arrayList.add(new k34.c(robot, troopUin));
        }
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.robot.discover.viewmodel.c
            @Override // java.lang.Runnable
            public final void run() {
                d.U1(d.this, arrayList, rsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U1(d this$0, List list, GroupRobotStoreDiscoveryRsp rsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(list, "$list");
        Intrinsics.checkNotNullParameter(rsp, "$rsp");
        this$0.mListData.setValue(list);
        this$0.mTitleData.setValue(new Pair<>(Integer.valueOf(list.size()), Integer.valueOf(rsp.maxRobotNum)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X1(d this$0, List list, int i3, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(list, "$list");
        this$0.mListData.setValue(list);
        this$0.mTitleData.setValue(new Pair<>(Integer.valueOf(i3), Integer.valueOf(i16)));
    }

    public final void O1() {
        this.mListData.postValue(new ArrayList());
    }

    public final void P1(@Nullable final String troopUin) {
        Long longOrNull;
        if (troopUin != null) {
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
            if (longOrNull != null) {
                long longValue = longOrNull.longValue();
                GroupRobotStoreDiscoveryReq groupRobotStoreDiscoveryReq = new GroupRobotStoreDiscoveryReq();
                groupRobotStoreDiscoveryReq.groupId = longValue;
                groupRobotStoreDiscoveryReq.sceneId = 0;
                ac a16 = n34.a.a();
                if (a16 != null) {
                    a16.fetchGroupRobotStoreDiscovery(groupRobotStoreDiscoveryReq, new IGroupRobotStoreDiscoveryCallback() { // from class: com.tencent.robot.discover.viewmodel.a
                        @Override // com.tencent.qqnt.kernel.nativeinterface.IGroupRobotStoreDiscoveryCallback
                        public final void onResult(int i3, String str, GroupRobotStoreDiscoveryRsp groupRobotStoreDiscoveryRsp) {
                            d.Q1(d.this, troopUin, i3, str, groupRobotStoreDiscoveryRsp);
                        }
                    });
                    return;
                }
                return;
            }
            return;
        }
        QLog.d(getTAG(), 1, "[fetchRobotDiscoverList] troopUin is null");
    }

    @NotNull
    public final MutableLiveData<List<k34.a>> R1() {
        return this.mListData;
    }

    @NotNull
    public final MutableLiveData<Pair<Integer, Integer>> S1() {
        return this.mTitleData;
    }

    public final void W1(@NotNull String troopUin, @NotNull List<RobotBase> robotList, final int maxNum, final int robotNum) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(robotList, "robotList");
        final ArrayList arrayList = new ArrayList();
        Iterator<RobotBase> it = robotList.iterator();
        while (it.hasNext()) {
            arrayList.add(new k34.c(it.next(), troopUin));
        }
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.robot.discover.viewmodel.b
            @Override // java.lang.Runnable
            public final void run() {
                d.X1(d.this, arrayList, robotNum, maxNum);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "RobotAddedDetailViewModel";
    }
}
