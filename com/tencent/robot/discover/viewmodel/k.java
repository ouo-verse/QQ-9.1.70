package com.tencent.robot.discover.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobot;
import com.tencent.qqnt.kernel.nativeinterface.IRecentUsedRobotsCallback;
import com.tencent.qqnt.kernel.nativeinterface.RecentUsedRobotsReq;
import com.tencent.qqnt.kernel.nativeinterface.RecentUsedRobotsRsp;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\u0006\u0010\n\u001a\u00020\u0006J\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bJ\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000bJ\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000bR \u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0016\u0010\u0019\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0013\u00a8\u0006 "}, d2 = {"Lcom/tencent/robot/discover/viewmodel/k;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "result", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentUsedRobotsRsp;", "response", "", "Q1", "", "getLogTag", "R1", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobot;", "O1", "", "N1", "P1", "i", "Landroidx/lifecycle/MutableLiveData;", "robotData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isEndData", BdhLogUtil.LogTag.Tag_Conn, "I", "nextOffset", "D", "requestErrorMute", "<init>", "()V", "E", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class k extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private int nextOffset;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Boolean> requestErrorMute;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<GroupRobot>> robotData = new MutableLiveData<>(new ArrayList());

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableLiveData<Boolean> isEndData;

    public k() {
        Boolean bool = Boolean.FALSE;
        this.isEndData = new MutableLiveData<>(bool);
        this.requestErrorMute = new MutableLiveData<>(bool);
    }

    private final void Q1(int result, RecentUsedRobotsRsp response) {
        if (result == 0) {
            this.nextOffset = response.nextOffset;
            this.isEndData.setValue(Boolean.valueOf(response.isEnd));
            List<GroupRobot> value = this.robotData.getValue();
            if (value != null) {
                ArrayList<GroupRobot> arrayList = response.robots;
                Intrinsics.checkNotNullExpressionValue(arrayList, "response.robots");
                value.addAll(arrayList);
            }
            this.robotData.setValue(value);
            return;
        }
        MutableLiveData<Boolean> mutableLiveData = this.requestErrorMute;
        Intrinsics.checkNotNull(mutableLiveData.getValue());
        mutableLiveData.postValue(Boolean.valueOf(!r3.booleanValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S1(final k this$0, final int i3, String str, final RecentUsedRobotsRsp recentUsedRobotsRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (QLog.isColorLevel()) {
            QLog.i(this$0.getTAG(), 2, "requestData result=" + i3 + " errMsg=" + str + " isEnd=" + recentUsedRobotsRsp.isEnd + " offset=" + recentUsedRobotsRsp.nextOffset);
        }
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.robot.discover.viewmodel.j
            @Override // java.lang.Runnable
            public final void run() {
                k.T1(k.this, i3, recentUsedRobotsRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T1(k this$0, int i3, RecentUsedRobotsRsp response) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(response, "response");
        this$0.Q1(i3, response);
    }

    @NotNull
    public final MutableLiveData<Boolean> N1() {
        return this.isEndData;
    }

    @NotNull
    public final MutableLiveData<List<GroupRobot>> O1() {
        return this.robotData;
    }

    @NotNull
    public final MutableLiveData<Boolean> P1() {
        return this.requestErrorMute;
    }

    public final void R1() {
        if (!AppNetConnInfo.isNetSupport()) {
            MutableLiveData<Boolean> mutableLiveData = this.requestErrorMute;
            Intrinsics.checkNotNull(mutableLiveData.getValue());
            mutableLiveData.postValue(Boolean.valueOf(!r1.booleanValue()));
            return;
        }
        RecentUsedRobotsReq recentUsedRobotsReq = new RecentUsedRobotsReq();
        recentUsedRobotsReq.offset = this.nextOffset;
        recentUsedRobotsReq.num = 20;
        ac a16 = n34.a.a();
        if (a16 != null) {
            a16.fetchRecentUsedRobots(recentUsedRobotsReq, new IRecentUsedRobotsCallback() { // from class: com.tencent.robot.discover.viewmodel.i
                @Override // com.tencent.qqnt.kernel.nativeinterface.IRecentUsedRobotsCallback
                public final void onResult(int i3, String str, RecentUsedRobotsRsp recentUsedRobotsRsp) {
                    k.S1(k.this, i3, str, recentUsedRobotsRsp);
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "RobotRecentUsedViewModel";
    }
}
