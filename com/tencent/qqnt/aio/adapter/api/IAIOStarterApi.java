package com.tencent.qqnt.aio.adapter.api;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J>\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH&JF\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J>\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J4\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IAIOStarterApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "navigateToAIO", "", "context", "Landroid/content/Context;", "chatType", "", "uid", "", "nick", "uin", "", "data", "Landroid/os/Bundle;", "navigateToAIOActivity", "activityFlag", "navigateToScaleAIO", "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IAIOStarterApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class a {
        public static /* synthetic */ void a(IAIOStarterApi iAIOStarterApi, Context context, int i3, String str, String str2, long j3, Bundle bundle, int i16, Object obj) {
            long j16;
            Bundle bundle2;
            if (obj == null) {
                if ((i16 & 16) != 0) {
                    j16 = 0;
                } else {
                    j16 = j3;
                }
                if ((i16 & 32) != 0) {
                    bundle2 = null;
                } else {
                    bundle2 = bundle;
                }
                iAIOStarterApi.navigateToAIO(context, i3, str, str2, j16, bundle2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: navigateToAIO");
        }

        public static /* synthetic */ void b(IAIOStarterApi iAIOStarterApi, Context context, int i3, String str, String str2, long j3, Bundle bundle, int i16, Object obj) {
            long j16;
            Bundle bundle2;
            if (obj == null) {
                if ((i16 & 16) != 0) {
                    j16 = 0;
                } else {
                    j16 = j3;
                }
                if ((i16 & 32) != 0) {
                    bundle2 = null;
                } else {
                    bundle2 = bundle;
                }
                iAIOStarterApi.navigateToAIOActivity(context, i3, str, str2, j16, bundle2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: navigateToAIOActivity");
        }

        public static /* synthetic */ void c(IAIOStarterApi iAIOStarterApi, Context context, int i3, String str, String str2, Bundle bundle, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 16) != 0) {
                    bundle = null;
                }
                iAIOStarterApi.navigateToScaleAIO(context, i3, str, str2, bundle);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: navigateToScaleAIO");
        }
    }

    void navigateToAIO(@NotNull Context context, int chatType, @NotNull String uid, @NotNull String nick, long uin, @Nullable Bundle data);

    void navigateToAIOActivity(@NotNull Context context, int chatType, @NotNull String uid, @NotNull String nick, int activityFlag, long uin, @Nullable Bundle data);

    void navigateToAIOActivity(@NotNull Context context, int chatType, @NotNull String uid, @NotNull String nick, long uin, @Nullable Bundle data);

    void navigateToScaleAIO(@NotNull Context context, int chatType, @NotNull String uid, @NotNull String nick, @Nullable Bundle data);
}
