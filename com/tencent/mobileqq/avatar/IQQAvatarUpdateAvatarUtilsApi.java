package com.tencent.mobileqq.avatar;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0001\u000eJN\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062(\b\u0002\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u0001`\nH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/avatar/IQQAvatarUpdateAvatarUtilsApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "path", "", "syncQzone", "Lcom/tencent/mobileqq/avatar/IQQAvatarUpdateAvatarUtilsApi$a;", "callback", "Ljava/util/HashMap;", "Ljava/io/Serializable;", "Lkotlin/collections/HashMap;", "extensionInfoMap", "", "setUserAvatar", "a", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {""})
/* loaded from: classes11.dex */
public interface IQQAvatarUpdateAvatarUtilsApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/avatar/IQQAvatarUpdateAvatarUtilsApi$a;", "", "", "success", "", "msg", "", "onResult", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public interface a {

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.tencent.mobileqq.avatar.IQQAvatarUpdateAvatarUtilsApi$a$a, reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public static final class C7430a {
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

    void setUserAvatar(@Nullable String path, boolean syncQzone, @Nullable a callback, @Nullable HashMap<String, Serializable> extensionInfoMap);
}
