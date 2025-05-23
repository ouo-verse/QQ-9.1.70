package com.tencent.robot.discover.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.module.feedcomponent.manage.FeedManager;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobot;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotStoreSearchReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotStoreSearchRsp;
import com.tencent.qqnt.kernel.nativeinterface.IRobotStoreSearchCallback;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0007\u0018\u0000 .2\u00020\u0001:\u00016B\u0007\u00a2\u0006\u0004\b4\u00105J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\r\u001a\u00020\u000bH\u0016J\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u000eJ\u001e\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0002J\u0006\u0010\u0019\u001a\u00020\u0005R$\u0010\u001d\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u000f0\u000f0\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\"\u0010\u001f\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u000f0\u000f0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR \u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u001cR%\u0010%\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00020\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u001c\u001a\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u00067"}, d2 = {"Lcom/tencent/robot/discover/viewmodel/n;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "state", "mask", "", "W1", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotStoreSearchRsp;", "rsp", "S1", "T1", "", "N1", "getLogTag", "Landroidx/lifecycle/MutableLiveData;", "", "P1", "O1", "", "Lk34/a;", "Q1", "keyword", "troopUin", WadlProxyConsts.SCENE_ID, "X1", FeedManager.LOAD_MORE, "kotlin.jvm.PlatformType", "i", "Landroidx/lifecycle/MutableLiveData;", "isEnd", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isSearching", BdhLogUtil.LogTag.Tag_Conn, "mResultList", "D", "R1", "()Landroidx/lifecycle/MutableLiveData;", "resultPageState", "E", "Ljava/lang/String;", "curKeyWord", "", UserInfo.SEX_FEMALE, "J", "curGroupId", "G", "I", "curSceneID", "", "H", "[B", "curSessionInfo", "<init>", "()V", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class n extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<k34.a>> mResultList;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Integer> resultPageState;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private String curKeyWord;

    /* renamed from: F, reason: from kotlin metadata */
    private long curGroupId;

    /* renamed from: G, reason: from kotlin metadata */
    private int curSceneID;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private byte[] curSessionInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableLiveData<Boolean> isEnd;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> isSearching;

    public n() {
        Boolean bool = Boolean.FALSE;
        this.isEnd = new MutableLiveData<>(bool);
        this.isSearching = new MutableLiveData<>(bool);
        this.mResultList = new MutableLiveData<>();
        this.resultPageState = new MutableLiveData<>(0);
        this.curKeyWord = "";
        this.curSessionInfo = new byte[0];
    }

    private final String N1() {
        String str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getAccount();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        StringBuilder sb5 = new StringBuilder(50);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMddHHmmss");
        Random random = new Random();
        random.setSeed(System.nanoTime());
        sb5.append(str);
        sb5.append("_");
        sb5.append(simpleDateFormat.format(new Date()));
        sb5.append(System.currentTimeMillis() % 1000);
        sb5.append("_");
        sb5.append(random.nextInt(90000) + 10000);
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "builder.toString()");
        return sb6;
    }

    private final void S1(GroupRobotStoreSearchRsp rsp) {
        this.isEnd.postValue(Boolean.valueOf(rsp.isEnd));
        byte[] bArr = rsp.sessionInfo;
        Intrinsics.checkNotNullExpressionValue(bArr, "rsp.sessionInfo");
        this.curSessionInfo = bArr;
        ArrayList arrayList = new ArrayList();
        Iterator<GroupRobot> it = rsp.robots.iterator();
        while (it.hasNext()) {
            GroupRobot robot = it.next();
            String valueOf = String.valueOf(this.curGroupId);
            Intrinsics.checkNotNullExpressionValue(robot, "robot");
            arrayList.add(new k34.f(valueOf, robot, this.curKeyWord));
        }
        this.mResultList.postValue(arrayList);
        W1(2, -2);
    }

    private final void T1(GroupRobotStoreSearchRsp rsp) {
        this.isEnd.postValue(Boolean.valueOf(rsp.isEnd));
        byte[] bArr = rsp.sessionInfo;
        Intrinsics.checkNotNullExpressionValue(bArr, "rsp.sessionInfo");
        this.curSessionInfo = bArr;
        List<k34.a> value = this.mResultList.getValue();
        if (value != null) {
            Iterator<GroupRobot> it = rsp.robots.iterator();
            while (it.hasNext()) {
                GroupRobot robot = it.next();
                String valueOf = String.valueOf(this.curGroupId);
                Intrinsics.checkNotNullExpressionValue(robot, "robot");
                value.add(new k34.f(valueOf, robot, this.curKeyWord));
            }
            this.mResultList.postValue(value);
        }
        W1(2, -2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U1(n this$0, int i3, String str, GroupRobotStoreSearchRsp groupRobotStoreSearchRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isSearching.postValue(Boolean.FALSE);
        if (i3 == 0 && groupRobotStoreSearchRsp != null) {
            this$0.T1(groupRobotStoreSearchRsp);
            return;
        }
        QLog.e(this$0.getTAG(), 1, "sendGroupRobotStoreSearch result:" + i3 + " errMsg:" + str + " " + this$0.curGroupId);
        this$0.W1(4, -2);
    }

    private final void W1(int state, int mask) {
        MutableLiveData<Integer> mutableLiveData = this.resultPageState;
        Integer value = mutableLiveData.getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveData.postValue(Integer.valueOf(state | ((~mask) & value.intValue())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z1(n this$0, Ref.LongRef groupId, int i3, String str, GroupRobotStoreSearchRsp groupRobotStoreSearchRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(groupId, "$groupId");
        this$0.isSearching.postValue(Boolean.FALSE);
        if (i3 == 0 && groupRobotStoreSearchRsp != null) {
            this$0.S1(groupRobotStoreSearchRsp);
            return;
        }
        QLog.e(this$0.getTAG(), 1, "sendGroupRobotStoreSearch result:" + i3 + " errMsg:" + str + " " + groupId.element);
        this$0.W1(4, -2);
    }

    @NotNull
    public final MutableLiveData<Boolean> O1() {
        return this.isEnd;
    }

    @NotNull
    public final MutableLiveData<Boolean> P1() {
        return this.isSearching;
    }

    @NotNull
    public final MutableLiveData<List<k34.a>> Q1() {
        return this.mResultList;
    }

    @NotNull
    public final MutableLiveData<Integer> R1() {
        return this.resultPageState;
    }

    public final void X1(@NotNull String keyword, @NotNull String troopUin, int sceneId) {
        Long longOrNull;
        long j3;
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        final Ref.LongRef longRef = new Ref.LongRef();
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
        if (longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        longRef.element = j3;
        this.curKeyWord = keyword;
        this.curGroupId = j3;
        this.curSceneID = sceneId;
        this.curSessionInfo = new byte[0];
        this.isSearching.setValue(Boolean.TRUE);
        this.mResultList.postValue(new ArrayList());
        GroupRobotStoreSearchReq groupRobotStoreSearchReq = new GroupRobotStoreSearchReq();
        groupRobotStoreSearchReq.traceId = N1();
        groupRobotStoreSearchReq.keywords = keyword;
        groupRobotStoreSearchReq.groupId = longRef.element;
        groupRobotStoreSearchReq.sessionInfo = this.curSessionInfo;
        groupRobotStoreSearchReq.sceneId = sceneId;
        ac a16 = n34.a.a();
        if (a16 != null) {
            a16.sendGroupRobotStoreSearch(groupRobotStoreSearchReq, new IRobotStoreSearchCallback() { // from class: com.tencent.robot.discover.viewmodel.l
                @Override // com.tencent.qqnt.kernel.nativeinterface.IRobotStoreSearchCallback
                public final void onResult(int i3, String str, GroupRobotStoreSearchRsp groupRobotStoreSearchRsp) {
                    n.Z1(n.this, longRef, i3, str, groupRobotStoreSearchRsp);
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "RobotSearchViewModel";
    }

    public final void loadMore() {
        this.isSearching.postValue(Boolean.TRUE);
        GroupRobotStoreSearchReq groupRobotStoreSearchReq = new GroupRobotStoreSearchReq();
        groupRobotStoreSearchReq.traceId = N1();
        groupRobotStoreSearchReq.keywords = this.curKeyWord;
        groupRobotStoreSearchReq.groupId = this.curGroupId;
        groupRobotStoreSearchReq.sessionInfo = this.curSessionInfo;
        groupRobotStoreSearchReq.sceneId = this.curSceneID;
        ac a16 = n34.a.a();
        if (a16 != null) {
            a16.sendGroupRobotStoreSearch(groupRobotStoreSearchReq, new IRobotStoreSearchCallback() { // from class: com.tencent.robot.discover.viewmodel.m
                @Override // com.tencent.qqnt.kernel.nativeinterface.IRobotStoreSearchCallback
                public final void onResult(int i3, String str, GroupRobotStoreSearchRsp groupRobotStoreSearchRsp) {
                    n.U1(n.this, i3, str, groupRobotStoreSearchRsp);
                }
            });
        }
    }
}
