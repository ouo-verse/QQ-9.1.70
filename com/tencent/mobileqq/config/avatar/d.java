package com.tencent.mobileqq.config.avatar;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.avatar.AvatarViewConfig;
import com.tencent.mobileqq.config.avatar.d;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.square.detail.DetailMeFragmentConfig;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bJ\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bJ=\u0010\u0017\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u000b2#\u0010\u0016\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\u00102\b\b\u0002\u0010\r\u001a\u00020\u000bJ\u0016\u0010\u0019\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bJ\u0016\u0010\u001a\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bR\u0014\u0010\u001c\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/config/avatar/d;", "", "", "f", tl.h.F, "Lcom/tencent/mobileqq/config/avatar/h;", "baseConfigItem", "g", "Lcom/tencent/mobileqq/config/avatar/i;", "configItem", "c", "", DetailMeFragmentConfig.CURRENT_STATUS_ID, "subIndex", "Lcom/tencent/mobileqq/onlinestatus/model/a;", "d", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/onlinestatus/model/b;", "Lkotlin/ParameterName;", "name", "res", "", "callback", "e", "", "i", "b", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f202369a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TAG = "AvatarResUtil";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/config/avatar/d$a", "Lcom/tencent/mobileqq/config/avatar/a;", "Lcom/tencent/mobileqq/onlinestatus/model/b;", "avatarRes", "", "a", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class a implements com.tencent.mobileqq.config.avatar.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f202371a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<com.tencent.mobileqq.onlinestatus.model.b, Unit> f202372b;

        /* JADX WARN: Multi-variable type inference failed */
        a(int i3, Function1<? super com.tencent.mobileqq.onlinestatus.model.b, Unit> function1) {
            this.f202371a = i3;
            this.f202372b = function1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(Function1 callback, com.tencent.mobileqq.onlinestatus.model.b bVar) {
            Intrinsics.checkNotNullParameter(callback, "$callback");
            callback.invoke(bVar);
        }

        @Override // com.tencent.mobileqq.config.avatar.a
        public void a(@Nullable final com.tencent.mobileqq.onlinestatus.model.b avatarRes) {
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final Function1<com.tencent.mobileqq.onlinestatus.model.b, Unit> function1 = this.f202372b;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.config.avatar.c
                @Override // java.lang.Runnable
                public final void run() {
                    d.a.c(Function1.this, avatarRes);
                }
            });
            QLog.i(d.TAG, 1, "avatarRes is " + avatarRes + ", statusId is " + this.f202371a);
        }
    }

    d() {
    }

    public final void b(int statusId, int subIndex) {
        new ActionResDownloadTask(statusId, null, subIndex).i();
        com.tencent.mobileqq.config.avatar.download.g.f202388a.f(statusId, subIndex);
    }

    @NotNull
    public final String c(@NotNull ConfigData configItem) {
        Intrinsics.checkNotNullParameter(configItem, "configItem");
        String h16 = h();
        String str = File.separator;
        return h16 + str + configItem.getActionId() + str + configItem.getActionResUrlMd5();
    }

    @Nullable
    public final com.tencent.mobileqq.onlinestatus.model.a d(int statusId, int subIndex) {
        AvatarViewConfig.Companion companion = AvatarViewConfig.INSTANCE;
        ConfigData f16 = companion.a().f(statusId, subIndex);
        BaseConfigItem g16 = companion.a().g();
        if (f16 != null && g16 != null) {
            return new com.tencent.mobileqq.onlinestatus.model.a(g16.getActionResUrlMd5(), f16.getActionResUrlMd5());
        }
        QLog.e(TAG, 1, "config is null, getActionKey err, statusId is " + statusId);
        return null;
    }

    public final void e(int statusId, @NotNull Function1<? super com.tencent.mobileqq.onlinestatus.model.b, Unit> callback, int subIndex) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        new ActionResDownloadTask(statusId, new a(statusId, callback), subIndex).i();
    }

    @NotNull
    public final String f() {
        return MobileQQ.sMobileQQ.getFilesDir().getAbsolutePath() + File.separator + "onlineStatus/avatar";
    }

    @NotNull
    public final String g(@NotNull BaseConfigItem baseConfigItem) {
        Intrinsics.checkNotNullParameter(baseConfigItem, "baseConfigItem");
        return h() + File.separator + baseConfigItem.getActionResUrlMd5();
    }

    @NotNull
    public final String h() {
        return f() + File.separator + "action_res";
    }

    public final boolean i(int statusId, int subIndex) {
        boolean z16;
        AvatarViewConfig.Companion companion = AvatarViewConfig.INSTANCE;
        ConfigData f16 = companion.a().f(statusId, subIndex);
        BaseConfigItem g16 = companion.a().g();
        boolean z17 = false;
        if (f16 != null && g16 != null) {
            try {
                z16 = new File(g(g16)).exists();
                try {
                    z17 = new File(c(f16)).exists();
                } catch (Exception e16) {
                    e = e16;
                    QLog.e(TAG, 1, "isActionResReady exception " + e);
                    return z16 & z17;
                }
            } catch (Exception e17) {
                e = e17;
                z16 = false;
            }
            return z16 & z17;
        }
        QLog.e(TAG, 1, "config is null, isResReady false, statusId is " + statusId);
        return false;
    }
}
