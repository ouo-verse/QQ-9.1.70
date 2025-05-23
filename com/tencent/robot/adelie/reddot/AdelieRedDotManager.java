package com.tencent.robot.adelie.reddot;

import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.adelie.kuikly.module.r;
import com.tencent.robot.adelie.oidb.MybotCreatePB$GetMyRedDotsReq;
import com.tencent.robot.adelie.oidb.MybotCreatePB$GetMyRedDotsRsp;
import com.tencent.robot.adelie.oidb.MybotCreatePB$MyRedDot;
import com.tencent.robot.adelie.oidb.MybotCreatePB$RedDotsInfo;
import com.tencent.robot.adelie.oidb.MybotCreatePB$RevokeRedDotReq;
import java.util.ArrayList;
import java.util.List;
import kotlin.C11736d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ)\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0014\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00040\nJH\u0010\u0013\u001a\u00020\u00102\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022-\b\u0002\u0010\u0012\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\fj\u0004\u0018\u0001`\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J=\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00072-\b\u0002\u0010\u0012\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\fj\u0004\u0018\u0001`\u0011J\u0019\u0010\u0017\u001a\u00020\u00072\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018JF\u0010\u0019\u001a\u00020\u00102\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u0012\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\fj\u0004\u0018\u0001`\u0011\u00a2\u0006\u0004\b\u0019\u0010\u0014J\u0006\u0010\u001a\u001a\u00020\u0010R\"\u0010\u001d\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00040\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/robot/adelie/reddot/AdelieRedDotManager;", "", "", "robotUin", "", "Lcom/tencent/robot/adelie/reddot/a;", "redDotInfoList", "", "f", "(Ljava/lang/Long;Ljava/util/List;)Ljava/lang/String;", "Landroidx/lifecycle/MutableLiveData;", "e", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", h.F, "(Ljava/lang/Long;Lkotlin/jvm/functions/Function1;)V", "revokeId", "j", "c", "(Ljava/lang/Long;)Ljava/lang/String;", "d", "g", "b", "Landroidx/lifecycle/MutableLiveData;", "_redDotInfoList", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieRedDotManager {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final AdelieRedDotManager f366808a = new AdelieRedDotManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final MutableLiveData<List<RedDotInfo>> _redDotInfoList = new MutableLiveData<>(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/robot/adelie/reddot/AdelieRedDotManager$a", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "", "errorCode", "", "data", "Landroid/os/Bundle;", "bundle", "", "onResult", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a extends ProtoUtils.TroopProtocolObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f366810d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f366811e;

        a(String str, Function1<Object, Unit> function1) {
            this.f366810d = str;
            this.f366811e = function1;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int errorCode, @Nullable byte[] data, @Nullable Bundle bundle) {
            QLog.i("AdelieRedDotManager", 1, "revokeRedDot revokeId:" + this.f366810d + " errorCode:" + errorCode);
            if (errorCode == 0) {
                r.e(this.f366811e, null, 1, null);
            } else {
                r.c(this.f366811e, null, null, 3, null);
            }
        }
    }

    AdelieRedDotManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String f(Long robotUin, List<RedDotInfo> redDotInfoList) {
        boolean z16;
        JSONArray jSONArray = new JSONArray();
        if (robotUin != null) {
            if (redDotInfoList == null) {
                redDotInfoList = CollectionsKt__CollectionsKt.emptyList();
            } else {
                ArrayList arrayList = new ArrayList();
                for (Object obj : redDotInfoList) {
                    if (((RedDotInfo) obj).getRobotUin() == robotUin.longValue()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        arrayList.add(obj);
                    }
                }
                redDotInfoList = arrayList;
            }
        } else if (redDotInfoList == null) {
            redDotInfoList = CollectionsKt__CollectionsKt.emptyList();
        }
        for (RedDotInfo redDotInfo : redDotInfoList) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("revokeId", redDotInfo.getRevokeId());
            jSONObject.put("robotUin", redDotInfo.getRobotUin());
            jSONObject.put("redDotText", redDotInfo.getRedDotText());
            jSONArray.mo162put(jSONObject);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("redDotInfoList", jSONArray);
        QLog.i("AdelieRedDotManager", 1, "getRedDotInfoListString ret:" + jSONObject2);
        String jSONObject3 = jSONObject2.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject3, "ret.toString()");
        return jSONObject3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void i(AdelieRedDotManager adelieRedDotManager, Long l3, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            l3 = null;
        }
        if ((i3 & 2) != 0) {
            function1 = null;
        }
        adelieRedDotManager.h(l3, function1);
    }

    @NotNull
    public final String c(@Nullable Long robotUin) {
        return f(robotUin, _redDotInfoList.getValue());
    }

    public final void d(@Nullable Long robotUin, @Nullable Function1<Object, Unit> callback) {
        h(robotUin, callback);
    }

    @NotNull
    public final MutableLiveData<List<RedDotInfo>> e() {
        return _redDotInfoList;
    }

    public final void g() {
        List<RedDotInfo> emptyList;
        MutableLiveData<List<RedDotInfo>> mutableLiveData = _redDotInfoList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        mutableLiveData.setValue(emptyList);
    }

    public final void h(@Nullable final Long robotUin, @Nullable final Function1<Object, Unit> callback) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        MybotCreatePB$GetMyRedDotsReq mybotCreatePB$GetMyRedDotsReq = new MybotCreatePB$GetMyRedDotsReq();
        if (robotUin != null) {
            mybotCreatePB$GetMyRedDotsReq.robot_uin.set(robotUin.longValue());
        }
        ProtoUtils.a(peekAppRuntime, new ProtoUtils.TroopProtocolObserver() { // from class: com.tencent.robot.adelie.reddot.AdelieRedDotManager$requestMyRedDot$1
            @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
            public void onResult(int errorCode, @Nullable byte[] data, @Nullable Bundle bundle) {
                final List<MybotCreatePB$MyRedDot> list;
                boolean z16 = true;
                QLog.i("AdelieRedDotManager", 1, "requestMyRedDot robotUin:" + robotUin + " errorCode:" + errorCode);
                if (errorCode == 0 && data != null) {
                    MybotCreatePB$GetMyRedDotsRsp mybotCreatePB$GetMyRedDotsRsp = new MybotCreatePB$GetMyRedDotsRsp();
                    try {
                        mybotCreatePB$GetMyRedDotsRsp.mergeFrom(data);
                        PBRepeatMessageField<MybotCreatePB$MyRedDot> pBRepeatMessageField = mybotCreatePB$GetMyRedDotsRsp.red_dots;
                        if (pBRepeatMessageField != null) {
                            list = pBRepeatMessageField.get();
                        } else {
                            list = null;
                        }
                        List<MybotCreatePB$MyRedDot> list2 = list;
                        if (list2 != null && !list2.isEmpty()) {
                            z16 = false;
                        }
                        if (!z16) {
                            final Long l3 = robotUin;
                            final Function1<Object, Unit> function1 = callback;
                            C11736d.c(new Function0<Unit>() { // from class: com.tencent.robot.adelie.reddot.AdelieRedDotManager$requestMyRedDot$1$onResult$1
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
                                    String f16;
                                    PBStringField pBStringField;
                                    ArrayList arrayList = new ArrayList();
                                    for (MybotCreatePB$MyRedDot mybotCreatePB$MyRedDot : list) {
                                        String id5 = mybotCreatePB$MyRedDot.revoke_id.get();
                                        long j3 = mybotCreatePB$MyRedDot.robot_uin.get();
                                        MybotCreatePB$RedDotsInfo mybotCreatePB$RedDotsInfo = mybotCreatePB$MyRedDot.info;
                                        String str = (mybotCreatePB$RedDotsInfo == null || (pBStringField = mybotCreatePB$RedDotsInfo.text) == null) ? null : pBStringField.get();
                                        if (str == null) {
                                            str = "";
                                        }
                                        int i3 = mybotCreatePB$MyRedDot.biz_type.get();
                                        Intrinsics.checkNotNullExpressionValue(id5, "id");
                                        arrayList.add(new RedDotInfo(id5, j3, str, i3));
                                    }
                                    mutableLiveData = AdelieRedDotManager._redDotInfoList;
                                    mutableLiveData.setValue(arrayList);
                                    if (!arrayList.isEmpty()) {
                                        f16 = AdelieRedDotManager.f366808a.f(l3, arrayList);
                                        Function1<Object, Unit> function12 = function1;
                                        if (function12 != null) {
                                            r.a(function12, f16);
                                        }
                                    }
                                }
                            });
                            return;
                        }
                        return;
                    } catch (InvalidProtocolBufferMicroException e16) {
                        QLog.e("AdelieRedDotManager", 1, "sendOIDBRequest fail", e16);
                        return;
                    }
                }
                QLog.e("AdelieRedDotManager", 1, "getShareRobotInfoFromServer result error! errorCode = " + errorCode);
            }
        }, mybotCreatePB$GetMyRedDotsReq.toByteArray(), "OidbSvcTrpcTcp.0x9307_0", 37639, 0);
    }

    public final void j(@NotNull final String revokeId, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(revokeId, "revokeId");
        C11736d.c(new Function0<Unit>() { // from class: com.tencent.robot.adelie.reddot.AdelieRedDotManager$revokeRedDot$1
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
                mutableLiveData = AdelieRedDotManager._redDotInfoList;
                List list = (List) mutableLiveData.getValue();
                if (list == null) {
                    list = CollectionsKt__CollectionsKt.emptyList();
                }
                String str = revokeId;
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (!Intrinsics.areEqual(((RedDotInfo) obj).getRevokeId(), str)) {
                        arrayList.add(obj);
                    }
                }
                mutableLiveData2 = AdelieRedDotManager._redDotInfoList;
                mutableLiveData2.setValue(arrayList);
            }
        });
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        MybotCreatePB$RevokeRedDotReq mybotCreatePB$RevokeRedDotReq = new MybotCreatePB$RevokeRedDotReq();
        mybotCreatePB$RevokeRedDotReq.revoke_id.set(revokeId);
        ProtoUtils.a(peekAppRuntime, new a(revokeId, callback), mybotCreatePB$RevokeRedDotReq.toByteArray(), "OidbSvcTrpcTcp.0x9308_0", 37640, 0);
    }
}
