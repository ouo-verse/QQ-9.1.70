package com.tencent.open.api.impl;

import android.app.Activity;
import android.content.Intent;
import bq3.a;
import bq3.b;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.open.api.IOpenSdkJumpActionStashApi;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\t\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/open/api/impl/OpenSdkJumpActionStashApiImpl;", "Lcom/tencent/open/api/IOpenSdkJumpActionStashApi;", "Landroid/content/Intent;", "intent", "", "recordJumpAction", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "targetIntent", "passThroughParams", "restoreHandleJumpAction", "<init>", "()V", "Companion", "a", "opensdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class OpenSdkJumpActionStashApiImpl implements IOpenSdkJumpActionStashApi {

    @NotNull
    private static final String TAG = "OpenSdkJumpActionStashApiImpl";

    @NotNull
    private static final List<a> handlerList;

    @NotNull
    private static final Map<String, a> todoHandlerMap = new LinkedHashMap();

    static {
        List<a> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new b());
        handlerList = listOf;
    }

    @Override // com.tencent.open.api.IOpenSdkJumpActionStashApi
    public void passThroughParams(@Nullable Activity activity, @Nullable Intent targetIntent) {
        Map map;
        if (activity != null && targetIntent != null) {
            Map<String, a> map2 = todoHandlerMap;
            synchronized (map2) {
                map = MapsKt__MapsKt.toMap(map2);
            }
            for (Map.Entry entry : map.entrySet()) {
                ((a) entry.getValue()).c(activity, targetIntent, (String) entry.getKey());
            }
        }
    }

    @Override // com.tencent.open.api.IOpenSdkJumpActionStashApi
    public void recordJumpAction(@Nullable Intent intent) {
        boolean z16;
        if (intent == null) {
            return;
        }
        for (a aVar : handlerList) {
            String b16 = aVar.b(intent);
            if (b16 != null && b16.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                QLog.i(TAG, 1, "recordJumpAction sign: " + b16);
                Map<String, a> map = todoHandlerMap;
                synchronized (map) {
                    map.put(b16, aVar);
                    Unit unit = Unit.INSTANCE;
                }
                return;
            }
        }
    }

    @Override // com.tencent.open.api.IOpenSdkJumpActionStashApi
    public void restoreHandleJumpAction(@Nullable Activity activity) {
        Map map;
        if (activity == null) {
            return;
        }
        Map<String, a> map2 = todoHandlerMap;
        synchronized (map2) {
            map = MapsKt__MapsKt.toMap(map2);
            map2.clear();
        }
        for (Map.Entry entry : map.entrySet()) {
            ((a) entry.getValue()).a(activity, (String) entry.getKey());
        }
    }
}
