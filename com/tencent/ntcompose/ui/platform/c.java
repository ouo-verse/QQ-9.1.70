package com.tencent.ntcompose.ui.platform;

import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/ntcompose/ui/platform/c;", "", "", "a", "Ljava/lang/String;", "getActivityPageName", "()Ljava/lang/String;", "activityPageName", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "b", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "getJsonData", "()Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "jsonData", "Lcom/tencent/ntcompose/ui/platform/b;", "context", "<init>", "(Lcom/tencent/ntcompose/ui/platform/b;Ljava/lang/String;Lcom/tencent/kuikly/core/nvi/serialization/json/e;)V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String activityPageName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final e jsonData;

    public c() {
        this(null, null, null, 7, null);
    }

    public c(b bVar, String activityPageName, e jsonData) {
        Intrinsics.checkNotNullParameter(activityPageName, "activityPageName");
        Intrinsics.checkNotNullParameter(jsonData, "jsonData");
        this.activityPageName = activityPageName;
        this.jsonData = jsonData;
    }

    public /* synthetic */ c(b bVar, String str, e eVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : bVar, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? new e() : eVar);
    }
}
