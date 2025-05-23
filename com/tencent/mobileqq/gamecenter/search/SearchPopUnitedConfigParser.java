package com.tencent.mobileqq.gamecenter.search;

import com.tencent.freesia.BaseConfigParser;
import com.tencent.freesia.IConfigData;
import com.tencent.freesia.NetworkResult;
import com.tencent.mobileqq.gamecenter.api.ISearchPopService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0015\rB\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/search/SearchPopUnitedConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/gamecenter/search/SearchPopUnitedConfigParser$b;", "", "success", "", "c", "", "version", "onSend", "", "content", "d", "b", "onReceive", "Lcom/tencent/freesia/NetworkResult;", "result", "onReceiveNotUpdate", "onCdnDownload", "<init>", "()V", "a", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class SearchPopUnitedConfigParser extends BaseConfigParser<b> {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/search/SearchPopUnitedConfigParser$b;", "Lcom/tencent/freesia/IConfigData;", "", "content", "<init>", "([B)V", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements IConfigData {
        public b(@Nullable byte[] bArr) {
        }
    }

    private final void c(boolean success) {
        ISearchPopService iSearchPopService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iSearchPopService = (ISearchPopService) peekAppRuntime.getRuntimeService(ISearchPopService.class, "all")) != null) {
            iSearchPopService.onRequestPopConfigFinished(success);
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b defaultConfig() {
        return new b(null);
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public b parse(@NotNull byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        return new b(content);
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onCdnDownload(boolean success) {
        QLog.i("SearchPopUnitedConfigParser", 1, "onCdnDownload success:" + success);
        c(success);
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onReceive(boolean success) {
        Integer num;
        ISearchPopService iSearchPopService;
        if (!success) {
            QLog.i("SearchPopUnitedConfigParser", 1, "onReceive failed");
            c(false);
            return;
        }
        int configVersion = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).getConfigVersion("103007");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iSearchPopService = (ISearchPopService) peekAppRuntime.getRuntimeService(ISearchPopService.class, "all")) != null) {
            num = Integer.valueOf(iSearchPopService.getRequestPopConfigVersion());
        } else {
            num = null;
        }
        QLog.i("SearchPopUnitedConfigParser", 1, "onReceive success curVersion: " + configVersion + " reqVersion:" + num);
        if (num != null && configVersion == num.intValue()) {
            c(true);
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onReceiveNotUpdate(@NotNull NetworkResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onSend(@NotNull String version) {
        Intrinsics.checkNotNullParameter(version, "version");
    }
}
