package com.qzone.reborn.albumx.qzonex.utils;

import com.qzone.common.account.LoginData;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.IAccountCallback;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004R \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/utils/e;", "", "", "g", "", "albumId", "d", "answer", "f", tl.h.F, "c", "", "e", "", "b", "Ljava/util/Map;", "albumAnswers", "Z", "isRegistered", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f53405a = new e();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, String> albumAnswers = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean isRegistered;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/qzone/reborn/albumx/qzonex/utils/e$a", "Lmqq/app/IAccountCallback;", "Lmqq/app/AppRuntime;", "newRuntime", "", "onAccountChanged", "onAccountChangeFailed", "Lmqq/app/Constants$LogoutReason;", "reason", "onLogout", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class a implements IAccountCallback {
        a() {
        }

        @Override // mqq.app.IAccountCallback
        public void onAccountChanged(AppRuntime newRuntime) {
            QLog.i("QZAlbumxAnswerCacheHelper", 1, "onAccountChanged");
        }

        @Override // mqq.app.IAccountCallback
        public void onLogout(Constants.LogoutReason reason) {
            QLog.i("QZAlbumxAnswerCacheHelper", 1, "onLogout");
            e.albumAnswers.clear();
            MobileQQ mobileQQ = MobileQQ.sMobileQQ;
            if (mobileQQ != null) {
                mobileQQ.unregisterAccountCallback(this);
            }
            e.isRegistered = false;
        }

        @Override // mqq.app.IAccountCallback
        public void onAccountChangeFailed(AppRuntime newRuntime) {
        }
    }

    e() {
    }

    private final String d(String albumId) {
        return "album_answer_" + LoginData.getInstance().getUinString() + "_" + albumId;
    }

    private final void g() {
        if (isRegistered) {
            return;
        }
        isRegistered = true;
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null) {
            mobileQQ.registerAccountCallback(new a());
        }
    }

    public final String c(String albumId) {
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        String str = albumAnswers.get(d(albumId));
        return str == null ? "" : str;
    }

    public final boolean e(String albumId) {
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        return albumAnswers.containsKey(d(albumId));
    }

    public final void f(String albumId, String answer) {
        Intrinsics.checkNotNullParameter(answer, "answer");
        if (albumId == null || albumId.length() == 0) {
            return;
        }
        g();
        albumAnswers.put(d(albumId), answer);
    }

    public final void h(String albumId) {
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        albumAnswers.remove(d(albumId));
    }
}
