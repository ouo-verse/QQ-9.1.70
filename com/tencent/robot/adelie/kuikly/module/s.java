package com.tencent.robot.adelie.kuikly.module;

import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.adelie.reddot.AdelieRedDotManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \f2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J?\u0010\f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J?\u0010\r\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002JI\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/robot/adelie/kuikly/module/s;", "Li01/e;", "", "params", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "d", "c", "a", "method", "call", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class s extends i01.e {
    private final String a(String params) {
        boolean z16;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        Long l3 = null;
        if (!z16) {
            JSONObject jSONObject = new JSONObject(params);
            if (jSONObject.has("robotUin")) {
                l3 = Long.valueOf(jSONObject.optLong("robotUin"));
            }
        }
        return AdelieRedDotManager.f366808a.c(l3);
    }

    private final void c(String params, Function1<Object, Unit> callback) {
        boolean z16;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        Long l3 = null;
        if (!z16) {
            JSONObject jSONObject = new JSONObject(params);
            if (jSONObject.has("robotUin")) {
                l3 = Long.valueOf(jSONObject.optLong("robotUin"));
            }
        }
        AdelieRedDotManager.f366808a.d(l3, callback);
    }

    private final void d(String params, Function1<Object, Unit> callback) {
        boolean z16;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("AdelieRedDotModule", 1, "call updateRedDotNum params is null, return");
            return;
        }
        String id5 = new JSONObject(params).optString("revokeId");
        AdelieRedDotManager adelieRedDotManager = AdelieRedDotManager.f366808a;
        Intrinsics.checkNotNullExpressionValue(id5, "id");
        adelieRedDotManager.j(id5, callback);
    }

    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        int hashCode = method.hashCode();
        if (hashCode != -361054946) {
            if (hashCode != 627065273) {
                if (hashCode == 1304015006 && method.equals("getRedDotInfoListFromCache")) {
                    return a(params);
                }
            } else if (method.equals("getRedDotInfoListFromNet")) {
                c(params, callback);
                return Unit.INSTANCE;
            }
        } else if (method.equals("revokeRedDot")) {
            d(params, callback);
            return Unit.INSTANCE;
        }
        return super.call(method, params, callback);
    }
}
