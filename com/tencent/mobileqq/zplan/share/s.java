package com.tencent.mobileqq.zplan.share;

import com.tencent.mobileqq.zplan.share.ZPlanShareTranslucentActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J(\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004J6\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zplan/share/s;", "", "", "path", "", "shareExtraParams", "Lcom/tencent/mobileqq/zplan/share/e;", "a", "url", "title", "desc", "iconUrl", "directMessage", "", "b", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public static final s f335583a = new s();

    s() {
    }

    public final ZPlanShareParam a(String path, Map<String, ? extends Object> shareExtraParams) {
        Map<String, ? extends Object> map = shareExtraParams;
        Intrinsics.checkNotNullParameter(path, "path");
        QLog.i("StructMsgShareAction", 1, "start buildStructMsgShareParam: " + path);
        Object obj = map != null ? map.get("thumbPath") : null;
        String str = obj instanceof String ? (String) obj : null;
        Object obj2 = map != null ? map.get("title") : null;
        String str2 = obj2 instanceof String ? (String) obj2 : null;
        Object obj3 = map != null ? map.get("desc") : null;
        String str3 = obj3 instanceof String ? (String) obj3 : null;
        Object obj4 = map != null ? map.get("directMessage") : null;
        String str4 = obj4 instanceof String ? (String) obj4 : null;
        if (map == null) {
            map = new HashMap<>();
        }
        return new ZPlanShareParam(2, path, 0, 0, 0, 0, str, str2, str3, str4, map, 60, null);
    }

    public final void b(String url, String title, String desc, String iconUrl, String directMessage) {
        Intrinsics.checkNotNullParameter(url, "url");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (!(iconUrl == null || iconUrl.length() == 0)) {
            linkedHashMap.put("thumbPath", iconUrl);
        }
        if (!(title == null || title.length() == 0)) {
            linkedHashMap.put("title", title);
        }
        if (!(desc == null || desc.length() == 0)) {
            linkedHashMap.put("desc", desc);
        }
        if (!(directMessage == null || directMessage.length() == 0)) {
            linkedHashMap.put("directMessage", directMessage);
        }
        Unit unit = Unit.INSTANCE;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.put("zplan_meeting_url", url);
        ZPlanShareLaunchParam zPlanShareLaunchParam = new ZPlanShareLaunchParam(8, null, 4, url, null, linkedHashMap, null, new Integer[]{0, 1, 3, 2, 5}, null, new Integer[]{2}, false, linkedHashMap2, 1362, null);
        ZPlanShareTranslucentActivity.Companion companion = ZPlanShareTranslucentActivity.INSTANCE;
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        companion.a(context, zPlanShareLaunchParam);
    }
}
