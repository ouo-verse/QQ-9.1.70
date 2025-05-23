package com.tencent.rdelivery.reshub.api;

import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JP\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/rdelivery/reshub/api/j;", "", "", "appId", com.heytap.mcssdk.a.a.f36102l, "Lcom/tencent/rdelivery/reshub/api/TargetType;", "target", MosaicConstants$JsProperty.PROP_ENV, "Liz3/e;", "listener", "Lcom/tencent/rdelivery/reshub/api/f;", "interceptor", "Lcom/tencent/rdelivery/reshub/api/r;", QQBrowserActivity.APP_PARAM, "Lcom/tencent/rdelivery/reshub/api/i;", "a", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public interface j {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes25.dex */
    public static final class a {
        @NotNull
        public static i a(j jVar, @NotNull String appId, @NotNull String appKey, @NotNull TargetType target, @NotNull String env, @Nullable iz3.e eVar) {
            Intrinsics.checkParameterIsNotNull(appId, "appId");
            Intrinsics.checkParameterIsNotNull(appKey, "appKey");
            Intrinsics.checkParameterIsNotNull(target, "target");
            Intrinsics.checkParameterIsNotNull(env, "env");
            return jVar.a(appId, appKey, target, env, eVar, null, null);
        }

        public static /* synthetic */ i b(j jVar, String str, String str2, TargetType targetType, String str3, iz3.e eVar, f fVar, r rVar, int i3, Object obj) {
            TargetType targetType2;
            String str4;
            iz3.e eVar2;
            f fVar2;
            r rVar2;
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    targetType2 = TargetType.AndroidApp;
                } else {
                    targetType2 = targetType;
                }
                if ((i3 & 8) != 0) {
                    str4 = TPReportKeys.Common.COMMON_ONLINE;
                } else {
                    str4 = str3;
                }
                if ((i3 & 16) != 0) {
                    eVar2 = null;
                } else {
                    eVar2 = eVar;
                }
                if ((i3 & 32) != 0) {
                    fVar2 = null;
                } else {
                    fVar2 = fVar;
                }
                if ((i3 & 64) != 0) {
                    rVar2 = null;
                } else {
                    rVar2 = rVar;
                }
                return jVar.a(str, str2, targetType2, str4, eVar2, fVar2, rVar2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getResHub");
        }
    }

    @NotNull
    i a(@NotNull String appId, @NotNull String appKey, @NotNull TargetType target, @NotNull String env, @Nullable iz3.e listener, @Nullable f interceptor, @Nullable r extraParams);
}
