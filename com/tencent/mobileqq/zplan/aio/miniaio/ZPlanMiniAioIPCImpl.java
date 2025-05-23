package com.tencent.mobileqq.zplan.aio.miniaio;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.luabridge.ZPlanLuaBridge;
import com.tencent.zplan.luabridge.a;
import ke3.a;
import ke3.b;
import ke3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/miniaio/ZPlanMiniAioIPCImpl;", "Lke3/a;", "Lke3/b;", "", "notifyOpenAIO", "", "count", "notifyUnreadCount", "Lke3/c;", "msgInterface", "getUnreadCount", "notifyCloseMiniAIO", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanMiniAioIPCImpl implements a, b {
    private final String TAG = "ZPlanMiniAIOImpl";

    @Override // ke3.b
    public void getUnreadCount(c msgInterface) {
        if (BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface) {
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            Intrinsics.checkNotNull(runtime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
            int b16 = com.tencent.mobileqq.activity.home.chats.unread.c.b();
            if (msgInterface != null) {
                msgInterface.a(b16);
            }
            if (QLog.isColorLevel()) {
                QLog.d(this.TAG, 2, "getUnreadCount count is " + b16);
            }
        }
    }

    @Override // ke3.a
    public void notifyCloseMiniAIO() {
        JSONObject jSONObject = new JSONObject();
        ZPlanLuaBridge zPlanLuaBridge = ZPlanLuaBridge.INSTANCE;
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
        a.C10063a.b(zPlanLuaBridge, "N2L_CloseMiniAIO", jSONObject2, null, 4, null);
    }

    @Override // ke3.a
    public void notifyOpenAIO() {
        if (QLog.isColorLevel()) {
            QLog.i(this.TAG, 2, "notifyOpenAIO");
        }
        ZPlanLuaBridge zPlanLuaBridge = ZPlanLuaBridge.INSTANCE;
        String jSONObject = new JSONObject().toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject().toString()");
        a.C10063a.b(zPlanLuaBridge, "N2L_OnMiniAIOShowed", jSONObject, null, 4, null);
    }

    @Override // ke3.a
    public void notifyUnreadCount(int count) {
        if (QLog.isColorLevel()) {
            QLog.i(this.TAG, 2, "notifyUnreadCount count is " + count);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("curCount", count);
        ZPlanLuaBridge zPlanLuaBridge = ZPlanLuaBridge.INSTANCE;
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
        a.C10063a.b(zPlanLuaBridge, "N2L_UpdateUnreadMsgCount", jSONObject2, null, 4, null);
    }
}
