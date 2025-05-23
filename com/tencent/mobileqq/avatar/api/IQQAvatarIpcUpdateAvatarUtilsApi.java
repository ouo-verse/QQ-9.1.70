package com.tencent.mobileqq.avatar.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0001\nJ$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/avatar/api/IQQAvatarIpcUpdateAvatarUtilsApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "path", "", "syncQzone", "Lcom/tencent/mobileqq/avatar/api/IQQAvatarIpcUpdateAvatarUtilsApi$a;", "callback", "", "setUserAvatar", "a", "qqavatar-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"peak"})
/* loaded from: classes11.dex */
public interface IQQAvatarIpcUpdateAvatarUtilsApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/avatar/api/IQQAvatarIpcUpdateAvatarUtilsApi$a;", "", "", "success", "", "msg", "", "onResult", "qqavatar-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public interface a {

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.tencent.mobileqq.avatar.api.IQQAvatarIpcUpdateAvatarUtilsApi$a$a, reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public static final class C7431a {
            public static /* synthetic */ void a(a aVar, boolean z16, String str, int i3, Object obj) {
                if (obj == null) {
                    if ((i3 & 2) != 0) {
                        str = null;
                    }
                    aVar.onResult(z16, str);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onResult");
            }
        }

        void onResult(boolean success, @Nullable String msg2);
    }

    void setUserAvatar(@Nullable String path, boolean syncQzone, @Nullable a callback);
}
