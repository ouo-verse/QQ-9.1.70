package com.tencent.zplan.luabridge;

import android.text.TextUtils;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u001a\u0010\n\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001a\u0010\r\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\f\u0010\tR\u001a\u0010\u0013\u001a\u00020\u000e8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/zplan/luabridge/b;", "Lp0/a;", "", "result", "", "callback", "a", "Ljava/lang/String;", "getEventName", "()Ljava/lang/String;", AdMetricTag.EVENT_NAME, "b", "getParams", "params", "", "c", "I", "getCallbackId", "()I", "callbackId", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class b implements p0.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String eventName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String params;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int callbackId;

    public b(@NotNull String eventName, @NotNull String params, int i3) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(params, "params");
        this.eventName = eventName;
        this.params = params;
        this.callbackId = i3;
    }

    @Override // p0.a
    public void callback(@Nullable String result) {
        if (getF440572a() > 0 && !TextUtils.isEmpty(result)) {
            ZPlanServiceHelper zPlanServiceHelper = ZPlanServiceHelper.I;
            int f440572a = getF440572a();
            Intrinsics.checkNotNull(result);
            zPlanServiceHelper.H(f440572a, result);
        }
    }

    @Override // p0.a
    /* renamed from: getCallbackId, reason: from getter */
    public int getF440572a() {
        return this.callbackId;
    }

    @Override // p0.a
    @NotNull
    /* renamed from: getEventName, reason: from getter */
    public String getF440573b() {
        return this.eventName;
    }

    @Override // p0.a
    @NotNull
    /* renamed from: getParams, reason: from getter */
    public String getF440574c() {
        return this.params;
    }

    @Override // p0.a
    public boolean isASync() {
        return a.C10971a.a(this);
    }
}
