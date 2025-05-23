package com.tencent.mobileqq.zootopia.ipc;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import com.tencent.zplan.luabridge.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ipc/ZootopiaLuaRemoteManagerImpl;", "Lcom/tencent/mobileqq/zootopia/ipc/x;", "", AdMetricTag.EVENT_NAME, "params", "Lcom/tencent/mobileqq/zootopia/ipc/ah;", "callback", "", "sendLuaCall", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaLuaRemoteManagerImpl implements x {
    public static final String TAG = "ZootopiaLuaRemoteManagerImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zootopia/ipc/ZootopiaLuaRemoteManagerImpl$b", "Lcom/tencent/zplan/luabridge/a$b;", "", "success", "", "result", "", "onLuaResult", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements a.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ah f328337d;

        b(ah ahVar) {
            this.f328337d = ahVar;
        }

        @Override // com.tencent.zplan.luabridge.a.b
        public void onExecuteLua() {
            a.b.C10064a.a(this);
        }

        @Override // com.tencent.zplan.luabridge.a.b
        public void onLuaResult(boolean success, String result) {
            if (success) {
                ah ahVar = this.f328337d;
                if (ahVar != null) {
                    if (result == null) {
                        result = "";
                    }
                    ahVar.onSuccess(result);
                    return;
                }
                return;
            }
            ah ahVar2 = this.f328337d;
            if (ahVar2 != null) {
                if (result == null) {
                    result = "";
                }
                ahVar2.onFailed(-1, result);
            }
        }
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.x
    public void sendLuaCall(String eventName, String params, ah callback) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(params, "params");
        QLog.i(ZootopiaNetRemoteManagerImpl.TAG, 1, "sendLuaCall start :: eventName == " + eventName + " , param == " + params);
        if (eventName.length() == 0) {
            QLog.e(ZootopiaNetRemoteManagerImpl.TAG, 1, "sendLuaCall error :: eventName is empty");
            return;
        }
        com.tencent.zplan.luabridge.a S = ZPlanServiceHelper.I.S();
        if (S != null) {
            S.callLua(eventName, params, new b(callback));
        }
    }
}
