package com.tencent.robot.discover.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobot;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotStoreCategoryListReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotStoreCategoryListRsp;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback;
import com.tencent.qqnt.kernel.nativeinterface.IRobotStoreCategoryListCallback;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.robot.api.IRobotProfileInfoApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\u0016\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0002J\u0016\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rJ\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0010J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u0010R \u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00140\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0018R\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00140\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u0018\u00a8\u0006$"}, d2 = {"Lcom/tencent/robot/discover/viewmodel/h;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "result", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotStoreCategoryListRsp;", "response", "", "R1", "", "getLogTag", "troopUin", "categoryId", "S1", "", "robotUin", "W1", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobot;", "P1", "", "O1", "Q1", "i", "Landroidx/lifecycle/MutableLiveData;", "dataLive", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "[B", "offsetSession", BdhLogUtil.LogTag.Tag_Conn, "isEndDataLive", "D", "requestErrorMute", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class h extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Boolean> isEndDataLive;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Boolean> requestErrorMute;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<GroupRobot>> dataLive = new MutableLiveData<>(new ArrayList());

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private byte[] offsetSession = new byte[0];

    public h() {
        Boolean bool = Boolean.FALSE;
        this.isEndDataLive = new MutableLiveData<>(bool);
        this.requestErrorMute = new MutableLiveData<>(bool);
    }

    private final void R1(int result, GroupRobotStoreCategoryListRsp response) {
        if (result == 0) {
            byte[] bArr = response.sessionInfo;
            Intrinsics.checkNotNullExpressionValue(bArr, "response.sessionInfo");
            this.offsetSession = bArr;
            this.isEndDataLive.setValue(Boolean.valueOf(response.isEnd));
            List<GroupRobot> value = this.dataLive.getValue();
            if (value != null) {
                ArrayList<GroupRobot> arrayList = response.robots;
                Intrinsics.checkNotNullExpressionValue(arrayList, "response.robots");
                value.addAll(arrayList);
            }
            this.dataLive.setValue(value);
            return;
        }
        MutableLiveData<Boolean> mutableLiveData = this.requestErrorMute;
        Intrinsics.checkNotNull(mutableLiveData.getValue());
        mutableLiveData.setValue(Boolean.valueOf(!r3.booleanValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T1(final h this$0, final int i3, String str, final GroupRobotStoreCategoryListRsp response) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String tag = this$0.getTAG();
        Intrinsics.checkNotNullExpressionValue(response, "response");
        QLog.i(tag, 4, "requestDataSuspend result=" + i3 + " errMsg=" + str + " " + n34.f.a(response));
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.robot.discover.viewmodel.g
            @Override // java.lang.Runnable
            public final void run() {
                h.U1(h.this, i3, response);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U1(h this$0, int i3, GroupRobotStoreCategoryListRsp response) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(response, "response");
        this$0.R1(i3, response);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void X1(h this$0, long j3, int i3, String str, GroupRobotProfile groupRobotProfile) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (groupRobotProfile.robotMembership != -1) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.i(this$0.getTAG(), 1, "updateRobotAddBtnStatus result:" + i3 + " errMsg=" + str + " isAdded=" + z16);
        List<GroupRobot> value = this$0.dataLive.getValue();
        GroupRobot groupRobot = null;
        if (value != null) {
            Iterator<T> it = value.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((GroupRobot) next).baseInfo.robotUin == j3) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    groupRobot = next;
                    break;
                }
            }
            groupRobot = groupRobot;
        }
        if (groupRobot != null) {
            int indexOf = value.indexOf(groupRobot);
            GroupRobot groupRobot2 = new GroupRobot(groupRobot.baseInfo, z16, groupRobot.labels);
            value.remove(indexOf);
            value.add(indexOf, groupRobot2);
            this$0.dataLive.postValue(value);
        }
    }

    @NotNull
    public final MutableLiveData<Boolean> O1() {
        return this.isEndDataLive;
    }

    @NotNull
    public final MutableLiveData<List<GroupRobot>> P1() {
        return this.dataLive;
    }

    @NotNull
    public final MutableLiveData<Boolean> Q1() {
        return this.requestErrorMute;
    }

    public final void S1(@NotNull String troopUin, int categoryId) {
        Long longOrNull;
        long j3;
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        int i3 = 1;
        if (AppNetConnInfo.isNetSupport()) {
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
            if (longOrNull != null) {
                j3 = longOrNull.longValue();
            } else {
                j3 = 0;
            }
            if (j3 != 0) {
                i3 = 0;
            }
            GroupRobotStoreCategoryListReq groupRobotStoreCategoryListReq = new GroupRobotStoreCategoryListReq();
            groupRobotStoreCategoryListReq.groupId = j3;
            groupRobotStoreCategoryListReq.categoryId = categoryId;
            groupRobotStoreCategoryListReq.sessionInfo = this.offsetSession;
            groupRobotStoreCategoryListReq.sceneId = i3;
            ac a16 = n34.a.a();
            if (a16 != null) {
                a16.fetchGroupRobotStoreCategoryList(groupRobotStoreCategoryListReq, new IRobotStoreCategoryListCallback() { // from class: com.tencent.robot.discover.viewmodel.f
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IRobotStoreCategoryListCallback
                    public final void onResult(int i16, String str, GroupRobotStoreCategoryListRsp groupRobotStoreCategoryListRsp) {
                        h.T1(h.this, i16, str, groupRobotStoreCategoryListRsp);
                    }
                });
                return;
            }
            return;
        }
        MutableLiveData<Boolean> mutableLiveData = this.requestErrorMute;
        Intrinsics.checkNotNull(mutableLiveData.getValue());
        mutableLiveData.setValue(Boolean.valueOf(!r8.booleanValue()));
    }

    public final void W1(@NotNull String troopUin, final long robotUin) {
        Long longOrNull;
        long j3;
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
        if (longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        if (j3 == 0) {
            return;
        }
        QLog.i(getTAG(), 1, "updateRobotAddBtnStatus troopUin:" + troopUin + " robotUin=" + robotUin);
        ((IRobotProfileInfoApi) QRoute.api(IRobotProfileInfoApi.class)).fetchRobotProfileInfo(String.valueOf(robotUin), String.valueOf(j3), new IGetGroupRobotProfileCallback() { // from class: com.tencent.robot.discover.viewmodel.e
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback
            public final void onResult(int i3, String str, GroupRobotProfile groupRobotProfile) {
                h.X1(h.this, robotUin, i3, str, groupRobotProfile);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "RobotCategoryViewModel";
    }
}
