package com.tencent.robot.adelie.kuikly.module;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.gson.Gson;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.kuikly.core.render.android.c;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.troop.troopselector.TroopSelectorConfig;
import com.tencent.mobileqq.troop.troopselector.api.ITroopSelectorApi;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.adelie.kuikly.module.p;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J?\u0010\f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002JI\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016R;\u0010\u0011\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/robot/adelie/kuikly/module/l;", "Li01/e;", "", "params", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "d", "method", "call", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lkotlin/jvm/functions/Function1;", "kuiklyCallback", "Lcom/tencent/kuikly/core/render/android/c;", "e", "Lcom/tencent/kuikly/core/render/android/c;", "renderLifecycleCallback", "<init>", "()V", "f", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class l extends i01.e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> kuiklyCallback;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.kuikly.core.render.android.c renderLifecycleCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/robot/adelie/kuikly/module/l$b", "Lcom/tencent/kuikly/core/render/android/c;", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "", "onActivityResult", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements com.tencent.kuikly.core.render.android.c {
        b() {
        }

        @Override // com.tencent.kuikly.core.render.android.c
        public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            ArrayList<ResultRecord> arrayList;
            int collectionSizeOrDefault;
            c.a.a(this, requestCode, resultCode, data);
            if (requestCode == 10001 && resultCode == -1) {
                if (data != null) {
                    arrayList = data.getParcelableArrayListExtra("selected_target_list");
                } else {
                    arrayList = null;
                }
                JSONArray jSONArray = new JSONArray();
                if (arrayList != null) {
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                    ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                    for (ResultRecord resultRecord : arrayList) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("uin", resultRecord.uin);
                        jSONObject.put("name", resultRecord.name);
                        arrayList2.add(jSONArray.mo162put(jSONObject));
                    }
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("troopInfoList", jSONArray);
                Function1 function1 = l.this.kuiklyCallback;
                if (function1 != null) {
                    r.d(function1, jSONObject2.toString());
                }
                l.this.kuiklyCallback = null;
            }
        }
    }

    private final void d(String params, Function1<Object, Unit> callback) {
        boolean z16;
        Object obj;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("AdelieKuiklyManagerPageModule", 1, "call openRobotBindTroop params is null, return");
            return;
        }
        p.Companion companion = p.INSTANCE;
        try {
            obj = new Gson().fromJson(params, (Class<Object>) RobotBindTroopData.class);
        } catch (Exception e16) {
            QLog.e("AdelieModuleData", 1, "AdelieModuleData fromJson exception = " + e16);
            obj = null;
        }
        RobotBindTroopData robotBindTroopData = (RobotBindTroopData) obj;
        if (robotBindTroopData == null) {
            return;
        }
        this.kuiklyCallback = callback;
        if (this.renderLifecycleCallback == null) {
            this.renderLifecycleCallback = new b();
        }
        Activity activity = getActivity();
        if (activity != null) {
            if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("106129", true)) {
                Context context = getContext();
                if (context != null) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<T> it = robotBindTroopData.b().iterator();
                    while (it.hasNext()) {
                        arrayList.add(new ResultRecord((String) it.next(), "", 1, "", ""));
                    }
                    ((ITroopSelectorApi) QRoute.api(ITroopSelectorApi.class)).openNewTroopSelector(context, new Intent(), new TroopSelectorConfig(true, robotBindTroopData.getMaxSize(), false, false, false, arrayList, 2, 28, null), 10001);
                }
            } else {
                ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startBindRobotTroop(activity, robotBindTroopData.getMaxSize(), robotBindTroopData.b(), 10001);
            }
            com.tencent.kuikly.core.render.android.c cVar = this.renderLifecycleCallback;
            if (cVar != null) {
                removeKuiklyRenderLifeCycleCallback(cVar);
                addKuiklyRenderLifecycleCallback(cVar);
            }
        }
    }

    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (Intrinsics.areEqual(method, "openRobotBindTroop")) {
            d(params, callback);
            return Unit.INSTANCE;
        }
        return super.call(method, params, callback);
    }

    @Override // i01.e, i01.a
    public void onDestroy() {
        super.onDestroy();
        com.tencent.kuikly.core.render.android.c cVar = this.renderLifecycleCallback;
        if (cVar != null) {
            removeKuiklyRenderLifeCycleCallback(cVar);
        }
        this.kuiklyCallback = null;
    }
}
