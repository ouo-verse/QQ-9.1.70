package com.tencent.mobileqq.filemanager.util;

import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.nt.NTFileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.IAccountCallback;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/filemanager/util/j;", "", "", "d", "Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;", "entity", "", "ntElementId", "", "chatType", "", "e", "b", "Ljava/lang/Boolean;", "changedElementIdSwitch", "Lmqq/app/IAccountCallback;", "c", "Lmqq/app/IAccountCallback;", "accountCB", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class j {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Boolean changedElementIdSwitch;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j f209387a = new j();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static IAccountCallback accountCB = new a();

    static {
        MobileQQ.sMobileQQ.registerAccountCallback(accountCB);
    }

    j() {
    }

    public final synchronized boolean d() {
        boolean z16;
        z16 = false;
        if (changedElementIdSwitch == null) {
            Boolean valueOf = Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("106013", false));
            changedElementIdSwitch = valueOf;
            QLog.d("FileEntitySessionIdGrayStrategyManager", 1, "changedElementIdSwitch\uff1a " + valueOf);
        }
        Boolean bool = changedElementIdSwitch;
        if (bool != null) {
            z16 = bool.booleanValue();
        }
        return z16;
    }

    public final void e(@NotNull FileManagerEntity entity, long ntElementId, int chatType) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        if (!d()) {
            ntElementId = NTFileUtils.g(chatType);
        }
        entity.nSessionId = ntElementId;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/filemanager/util/j$a", "Lmqq/app/IAccountCallback;", "Lmqq/app/AppRuntime;", "newRuntime", "", "onAccountChanged", "onAccountChangeFailed", "Lmqq/app/Constants$LogoutReason;", "reason", "onLogout", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a implements IAccountCallback {
        a() {
        }

        @Override // mqq.app.IAccountCallback
        public void onAccountChanged(@Nullable AppRuntime newRuntime) {
            MobileQQ.sMobileQQ.unregisterAccountCallback(j.accountCB);
            j.accountCB = null;
            j.changedElementIdSwitch = null;
            QLog.d("FileEntitySessionIdGrayStrategyManager", 1, "onAccountChanged");
        }

        @Override // mqq.app.IAccountCallback
        public void onLogout(@Nullable Constants.LogoutReason reason) {
            MobileQQ.sMobileQQ.unregisterAccountCallback(j.accountCB);
            j.accountCB = null;
            j.changedElementIdSwitch = null;
            QLog.d("FileEntitySessionIdGrayStrategyManager", 1, "onLogout");
        }

        @Override // mqq.app.IAccountCallback
        public void onAccountChangeFailed(@Nullable AppRuntime newRuntime) {
        }
    }
}
