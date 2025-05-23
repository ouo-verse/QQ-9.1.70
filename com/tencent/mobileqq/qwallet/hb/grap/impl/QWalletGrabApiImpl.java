package com.tencent.mobileqq.qwallet.hb.grap.impl;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qwallet.hb.grap.IQWalletGrabApi;
import com.tencent.mobileqq.qwallet.hb.grap.a;
import com.tencent.mobileqq.qwallet.impl.d;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b \u0010!J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016JB\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\nj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016JB\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\nj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H\u0016RV\u0010\u0016\u001aB\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00140\u0014 \u0013* \u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00140\u0014\u0018\u00010\u00150\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00188BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/grap/impl/QWalletGrabApiImpl;", "Lcom/tencent/mobileqq/qwallet/hb/grap/IQWalletGrabApi;", "", "guildId", "", "requestCode", "", "initGuildObserver", "", "tinyIds", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getGuildAvatarUrls", "getGuildNicks", "removeAllGuildCallback", "tinyId", "getGuildAvatarUrl", "getGuildNick", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mobileqq/qwallet/hb/grap/a;", "", "observerMap", "Ljava/util/Map;", "Lmqq/app/AppRuntime;", "getApp", "()Lmqq/app/AppRuntime;", "app", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "getGProService", "()Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gProService", "<init>", "()V", "Companion", "a", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QWalletGrabApiImpl implements IQWalletGrabApi {

    @NotNull
    private static final String TAG = "QWalletGrabApi";
    private volatile Map<Integer, a> observerMap = Collections.synchronizedMap(new HashMap());

    private final AppRuntime getApp() {
        AppRuntime g16 = d.g();
        Intrinsics.checkNotNullExpressionValue(g16, "getAppRuntime()");
        return g16;
    }

    private final IGPSService getGProService() {
        IRuntimeService runtimeService = getApp().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IG\u2026va, ProcessConstant.MAIN)");
        return (IGPSService) runtimeService;
    }

    @Override // com.tencent.mobileqq.qwallet.hb.grap.IQWalletGrabApi
    @Nullable
    public String getGuildAvatarUrl(@NotNull String guildId, @NotNull String tinyId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        return getGProService().getFullGuildUserUserAvatarUrl(guildId, tinyId, 0);
    }

    @Override // com.tencent.mobileqq.qwallet.hb.grap.IQWalletGrabApi
    @NotNull
    public HashMap<String, String> getGuildAvatarUrls(int requestCode, @NotNull String guildId, @NotNull List<String> tinyIds) {
        HashMap<String, String> f16;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(tinyIds, "tinyIds");
        if (this.observerMap.get(Integer.valueOf(requestCode)) == null) {
            QLog.w(TAG, 1, "getGuildAvatarUrls observer is null");
            initGuildObserver(guildId, requestCode);
        }
        QLog.i(TAG, 1, "getGuildAvatarUrls guildId " + guildId + " requestCode " + requestCode + " tinyIds " + tinyIds);
        a aVar = this.observerMap.get(Integer.valueOf(requestCode));
        if (aVar == null || (f16 = aVar.f(tinyIds)) == null) {
            return new HashMap<>();
        }
        return f16;
    }

    @Override // com.tencent.mobileqq.qwallet.hb.grap.IQWalletGrabApi
    @NotNull
    public String getGuildNick(@NotNull String guildId, @NotNull String tinyId) {
        boolean z16;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        String guildUserDisplayName = getGProService().getGuildUserDisplayName(guildId, tinyId);
        Intrinsics.checkNotNullExpressionValue(guildUserDisplayName, "gProService.getGuildUser\u2026playName(guildId, tinyId)");
        if (guildUserDisplayName.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            String qqStr = HardCodeUtil.qqStr(R.string.f143020ky);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(com.tencent.mobile\u2026.guild_default_nick_name)");
            return qqStr;
        }
        return guildUserDisplayName;
    }

    @Override // com.tencent.mobileqq.qwallet.hb.grap.IQWalletGrabApi
    @NotNull
    public HashMap<String, String> getGuildNicks(int requestCode, @NotNull String guildId, @NotNull List<String> tinyIds) {
        HashMap<String, String> g16;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(tinyIds, "tinyIds");
        if (this.observerMap.get(Integer.valueOf(requestCode)) == null) {
            QLog.w(TAG, 1, "getGuildNicks observer is null");
            initGuildObserver(guildId, requestCode);
        }
        QLog.i(TAG, 1, "getGuildNicks guildId " + guildId + " requestCode " + requestCode + " tinyIds " + tinyIds);
        a aVar = this.observerMap.get(Integer.valueOf(requestCode));
        if (aVar == null || (g16 = aVar.g(tinyIds)) == null) {
            return new HashMap<>();
        }
        return g16;
    }

    @Override // com.tencent.mobileqq.qwallet.hb.grap.IQWalletGrabApi
    public synchronized void initGuildObserver(@NotNull String guildId, int requestCode) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        QLog.i(TAG, 1, "initGuildObserver guildId " + guildId + " requestCode " + requestCode);
        if (this.observerMap.get(Integer.valueOf(requestCode)) == null) {
            Map<Integer, a> observerMap = this.observerMap;
            Intrinsics.checkNotNullExpressionValue(observerMap, "observerMap");
            observerMap.put(Integer.valueOf(requestCode), new a(guildId));
        }
    }

    @Override // com.tencent.mobileqq.qwallet.hb.grap.IQWalletGrabApi
    public void removeAllGuildCallback(int requestCode) {
        QLog.i(TAG, 1, "removeAllGuildCallback requestCode " + requestCode);
        this.observerMap.remove(Integer.valueOf(requestCode));
    }
}
