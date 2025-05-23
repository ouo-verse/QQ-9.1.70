package com.tencent.mobileqq.zootopia.api.impl;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.zootopia.api.IZootopiaResidenceAuthApi;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.mobileqq.zootopia.service.j;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import hw4.i;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J*\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J8\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u001e\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u000bH\u0016J@\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u001e\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u000bH\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/zootopia/api/impl/ZootopiaResidenceAuthApiImpl;", "Lcom/tencent/mobileqq/zootopia/api/IZootopiaResidenceAuthApi;", "", IProfileProtocolConst.PARAM_TARGET_UIN, "Lkotlin/Function2;", "", "", "callback", "checkResidenceVisitAuth", "", "groupId", "Lkotlin/Function3;", "sendResidenceAuthArk", "", ISchemeApi.KEY_GUILD_ID_TYPE, "guildId", "ownerUin", "sendChannelResidenceAuthArk", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaResidenceAuthApiImpl implements IZootopiaResidenceAuthApi {
    private static final String TAG = "IZootopiaResidenceAuthApi";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zootopia/api/impl/ZootopiaResidenceAuthApiImpl$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lhw4/i;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements e<i> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function2<Boolean, String, Unit> f327905d;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function2<? super Boolean, ? super String, Unit> function2) {
            this.f327905d = function2;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(i result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i(ZootopiaResidenceAuthApiImpl.TAG, 1, "ZootopiaSmallHomeAuthService check success");
            this.f327905d.invoke(Boolean.valueOf(result.f406523a == 1), "get check result");
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.i(ZootopiaResidenceAuthApiImpl.TAG, 1, "ZootopiaSmallHomeAuthService check false");
            Function2<Boolean, String, Unit> function2 = this.f327905d;
            Boolean bool = Boolean.FALSE;
            if (message == null) {
                message = "";
            }
            function2.invoke(bool, message);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaResidenceAuthApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void checkResidenceVisitAuth(String targetUin, Function2<? super Boolean, ? super String, Unit> callback) {
        boolean z16;
        boolean isBlank;
        boolean isBlank2;
        Intrinsics.checkNotNullParameter(targetUin, "targetUin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        AppInterface appInterface = waitAppRuntime instanceof AppInterface ? (AppInterface) waitAppRuntime : null;
        if (appInterface == null) {
            callback.invoke(Boolean.FALSE, "app is null");
            return;
        }
        String currentUin = appInterface.getCurrentUin();
        if (currentUin != null) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(currentUin);
            if (!isBlank2) {
                z16 = false;
                if (!z16) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(targetUin);
                    if (!isBlank) {
                        if (TextUtils.equals(currentUin, targetUin)) {
                            callback.invoke(Boolean.TRUE, "self");
                            return;
                        } else {
                            new j(0, 1, null).e(appInterface, targetUin, new b(callback));
                            return;
                        }
                    }
                }
                callback.invoke(Boolean.FALSE, "uin is illegal");
            }
        }
        z16 = true;
        if (!z16) {
        }
        callback.invoke(Boolean.FALSE, "uin is illegal");
    }

    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaResidenceAuthApi
    public void sendChannelResidenceAuthArk(int guildIdType, long guildId, long ownerUin, final Function3<? super Boolean, ? super Boolean, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            Boolean bool = Boolean.FALSE;
            callback.invoke(bool, bool, "app is null");
        } else {
            if (ownerUin <= 0) {
                Boolean bool2 = Boolean.FALSE;
                callback.invoke(bool2, bool2, "uin is illegal");
                return;
            }
            try {
                new com.tencent.mobileqq.zootopia.service.i().e(appInterface, guildIdType, guildId, ownerUin, 0, new Function3<Boolean, Boolean, String, Unit>() { // from class: com.tencent.mobileqq.zootopia.api.impl.ZootopiaResidenceAuthApiImpl$sendChannelResidenceAuthArk$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool3, Boolean bool4, String str) {
                        invoke(bool3.booleanValue(), bool4.booleanValue(), str);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16, boolean z17, String errMsg) {
                        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                        callback.invoke(Boolean.valueOf(z16), Boolean.valueOf(z17), errMsg);
                    }
                });
            } catch (Throwable th5) {
                Boolean bool3 = Boolean.FALSE;
                callback.invoke(bool3, bool3, "throwable");
                QLog.e(TAG, 1, th5, new Object[0]);
            }
        }
    }

    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaResidenceAuthApi
    public void sendResidenceAuthArk(String targetUin, long groupId, final Function3<? super Boolean, ? super Boolean, ? super String, Unit> callback) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(targetUin, "targetUin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        AppInterface appInterface = waitAppRuntime instanceof AppInterface ? (AppInterface) waitAppRuntime : null;
        if (appInterface != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(targetUin);
            if (!isBlank) {
                try {
                    new com.tencent.mobileqq.zootopia.service.i().f(appInterface, Long.parseLong(targetUin), (r18 & 4) != 0 ? 0L : groupId, (r18 & 8) != 0 ? 4 : 0, new Function3<Boolean, Boolean, String, Unit>() { // from class: com.tencent.mobileqq.zootopia.api.impl.ZootopiaResidenceAuthApiImpl$sendResidenceAuthArk$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Boolean bool2, String str) {
                            invoke(bool.booleanValue(), bool2.booleanValue(), str);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z16, boolean z17, String errMsg) {
                            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                            callback.invoke(Boolean.valueOf(z16), Boolean.valueOf(z17), errMsg);
                        }
                    });
                    return;
                } catch (Throwable th5) {
                    Boolean bool = Boolean.FALSE;
                    callback.invoke(bool, bool, "");
                    QLog.e(TAG, 1, th5, new Object[0]);
                    return;
                }
            }
            Boolean bool2 = Boolean.FALSE;
            callback.invoke(bool2, bool2, "uin is illegal");
            return;
        }
        Boolean bool3 = Boolean.FALSE;
        callback.invoke(bool3, bool3, "app is null");
    }
}
