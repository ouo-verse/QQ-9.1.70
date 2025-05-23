package com.tencent.mobileqq.zplan.smallhome.reenter;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.zootopia.ipc.f;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import com.tencent.zplan.luabridge.ZPlanLuaBridge;
import com.tencent.zplan.luabridge.a;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.concurrent.atomic.AtomicBoolean;
import k74.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import qk3.a;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0002J \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/zplan/smallhome/reenter/SmallHomeReEnterIPCImpl;", "Lqk3/a;", "", "modId", "", "modName", "", "isSmallHome", "fromSource", "isFromFloatWindow", GetAdInfoRequest.SOURCE_FROM, "", "onModStart", "Lorg/json/JSONObject;", "enterParams", "onModFirstFrameCallback", QCircleLpReportDc05507.KEY_CLEAR, "Ljava/util/concurrent/atomic/AtomicBoolean;", "shouldExecuteReEnter", "Ljava/util/concurrent/atomic/AtomicBoolean;", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class SmallHomeReEnterIPCImpl implements a {
    public static final String TAG = "SmallHomeReEnterIPCImpl";
    private AtomicBoolean shouldExecuteReEnter = new AtomicBoolean(false);

    private final boolean isFromFloatWindow(String fromSource) {
        return Intrinsics.areEqual(fromSource, "2") || Intrinsics.areEqual(fromSource, "3");
    }

    @Override // qk3.a
    public void onModFirstFrameCallback(JSONObject enterParams) {
        Intrinsics.checkNotNullParameter(enterParams, "enterParams");
        boolean z16 = this.shouldExecuteReEnter.get();
        QLog.i(TAG, 1, "onModFirstFrameCallback showReEnter:" + z16);
        if (z16) {
            QLog.i(TAG, 1, "onModFirstFrameCallback call reenter");
            ZPlanLuaBridge zPlanLuaBridge = ZPlanLuaBridge.INSTANCE;
            String jSONObject = enterParams.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "enterParams.toString()");
            zPlanLuaBridge.callLua("N2L_HotEntryParam", jSONObject, (a.b) null, true);
            this.shouldExecuteReEnter.set(false);
        }
    }

    @Override // qk3.a
    public void onModStart(int modId, String modName, String sourceFrom) {
        Intrinsics.checkNotNullParameter(modName, "modName");
        Intrinsics.checkNotNullParameter(sourceFrom, "sourceFrom");
        i.Companion companion = i.INSTANCE;
        boolean isFloat = ((f) companion.a(f.class)).isFloat();
        boolean isShowUE = ((f) companion.a(f.class)).isShowUE();
        boolean isSmallHome = isSmallHome(modId, modName);
        boolean z16 = true;
        QLog.i(TAG, 1, "onModStart modId:" + modId + ", modName:" + modName + " isFloat:" + isFloat + " isShowingUE:" + isShowUE + " isSmallHome:" + isSmallHome + " sourceFrom:" + sourceFrom);
        AtomicBoolean atomicBoolean = this.shouldExecuteReEnter;
        if (!isSmallHome || isFromFloatWindow(sourceFrom) || (!isFloat && !isShowUE)) {
            z16 = false;
        }
        atomicBoolean.set(z16);
    }

    @Override // qk3.a
    public void clear() {
        QLog.i(TAG, 1, QCircleLpReportDc05507.KEY_CLEAR);
        this.shouldExecuteReEnter.set(false);
    }

    private final boolean isSmallHome(int modId, String modName) {
        boolean z16 = modId == 200001;
        String string = MobileQQ.sMobileQQ.getString(R.string.xbm);
        Intrinsics.checkNotNullExpressionValue(string, "sMobileQQ.getString(\n   \u2026name_xiaowo\n            )");
        StringsKt__StringsJVMKt.startsWith$default(modName, string, false, 2, null);
        return z16;
    }
}
