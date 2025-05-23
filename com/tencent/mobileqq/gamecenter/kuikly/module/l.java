package com.tencent.mobileqq.gamecenter.kuikly.module;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.gamecenter.wadl.distribute.widget.IDistributeButton;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002JI\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042+\u0010\u000e\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007j\u0004\u0018\u0001`\rH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/kuikly/module/l;", "Li01/e;", "Lcom/tencent/gamecenter/wadl/distribute/widget/IDistributeButton;", "a", "", "method", "params", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", "<init>", "()V", "d", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class l extends i01.e {
    private final IDistributeButton a() {
        com.tencent.kuikly.core.render.android.d O0;
        ViewGroup view;
        com.tencent.kuikly.core.render.android.a aVar = get_kuiklyRenderContext();
        if (aVar != null && (O0 = aVar.O0()) != null && (view = O0.getView()) != null) {
            for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
                if ((parent instanceof View) && (parent instanceof IDistributeButton)) {
                    return (IDistributeButton) parent;
                }
            }
            return null;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0066, code lost:
    
        if (r16.equals("updateFollowOrSubscribeState") != false) goto L20;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006a A[Catch: all -> 0x00e2, TryCatch #0 {all -> 0x00e2, blocks: (B:6:0x0036, B:11:0x0054, B:15:0x006a, B:16:0x0071, B:21:0x0082, B:25:0x008b, B:29:0x00dd, B:31:0x0094, B:36:0x009f, B:40:0x00b9, B:44:0x00c3, B:47:0x005b, B:50:0x0062), top: B:5:0x0036 }] */
    @Override // i01.e, i01.a
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        JSONObject jSONObject;
        Intrinsics.checkNotNullParameter(method, "method");
        if (QLog.isColorLevel()) {
            QLog.i("QQGameDistributeModule", 2, "[call] method:" + method + ",params:" + params);
        }
        IDistributeButton a16 = a();
        try {
            int hashCode = method.hashCode();
            if (hashCode != -1703265244) {
                if (hashCode != 748305934) {
                    if (hashCode == 1336089467) {
                        if (!method.equals("onClickButton")) {
                        }
                        if (params != null) {
                            jSONObject = new JSONObject(params);
                        }
                    }
                    jSONObject = null;
                } else {
                    if (!method.equals("onDownloadTaskStatusChange")) {
                        jSONObject = null;
                    }
                    if (params != null) {
                    }
                    jSONObject = null;
                }
            }
            int hashCode2 = method.hashCode();
            if (hashCode2 != -1703265244) {
                if (hashCode2 != 748305934) {
                    if (hashCode2 == 1336089467 && method.equals("onClickButton")) {
                        if (a16 == 0) {
                            return null;
                        }
                        a16.onKuiklyWidgetClick((View) a16);
                        return Unit.INSTANCE;
                    }
                } else if (method.equals("onDownloadTaskStatusChange")) {
                    if (jSONObject == null) {
                        return null;
                    }
                    if (a16 != 0) {
                        String optString = jSONObject.optString("gameAppID");
                        Intrinsics.checkNotNullExpressionValue(optString, "optString(\"gameAppID\")");
                        a16.onKuiklyDownloadTaskStatusChange(optString, (float) jSONObject.optDouble("progress"), jSONObject.optInt("taskStatus"));
                    }
                    return jSONObject;
                }
                return super.call(method, params, callback);
            }
            if (method.equals("updateFollowOrSubscribeState")) {
                if (jSONObject == null) {
                    return null;
                }
                if (a16 != 0) {
                    String optString2 = jSONObject.optString("gameAppID");
                    Intrinsics.checkNotNullExpressionValue(optString2, "optString(\"gameAppID\")");
                    a16.onKuiklyFollowOrSubscribeStatusChange(optString2, jSONObject.optInt("followStatus"), jSONObject.optInt("subscribeStatus"));
                }
                return jSONObject;
            }
            return super.call(method, params, callback);
        } catch (Throwable th5) {
            QLog.e("QQGameDistributeModule", 1, th5, new Object[0]);
            return super.call(method, params, callback);
        }
    }
}
