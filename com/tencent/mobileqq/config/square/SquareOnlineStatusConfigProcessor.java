package com.tencent.mobileqq.config.square;

import com.google.gson.Gson;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.k;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0014J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/config/square/SquareOnlineStatusConfigProcessor;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/config/square/SquareOnlineStatusBean;", "b", "", "content", "d", DownloadInfo.spKey_Config, "", "c", "", "success", "onCdnDownload", "<init>", "()V", "a", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class SquareOnlineStatusConfigProcessor extends BaseConfigParser<SquareOnlineStatusBean> {

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/config/square/SquareOnlineStatusConfigProcessor$b", "Lpy2/a;", "Lcom/tencent/mobileqq/config/square/SquareOnlineStatusBean;", DownloadInfo.spKey_Config, "", "b", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements py2.a<SquareOnlineStatusBean> {
        b() {
        }

        @Override // py2.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@Nullable SquareOnlineStatusBean config) {
            if (config == null) {
                return;
            }
            a.f202944a.f(config);
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public SquareOnlineStatusBean defaultConfig() {
        return new SquareOnlineStatusBean(null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(@Nullable SquareOnlineStatusBean config) {
        if (config == null) {
            return;
        }
        QLog.d("SquareOnlineStatusConfigProcessor", 1, "doOnConfigUpdate " + config);
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public SquareOnlineStatusBean parse(@NotNull byte[] content) {
        List listOf;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(content, "content");
        try {
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            String str = new String(content, UTF_8);
            listOf = CollectionsKt__CollectionsJVMKt.listOf("title");
            QLog.d("SquareOnlineStatusConfigProcessor", 1, "parse config " + k.f(str, listOf));
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (isBlank) {
                return new SquareOnlineStatusBean(null, 1, null);
            }
            Object fromJson = new Gson().fromJson(str, (Class<Object>) SquareOnlineStatusBean.class);
            Intrinsics.checkNotNullExpressionValue(fromJson, "{\n            val json =\u2026an::class.java)\n        }");
            return (SquareOnlineStatusBean) fromJson;
        } catch (Exception e16) {
            QLog.e("SquareOnlineStatusConfigProcessor", 1, "parse config failed", e16);
            return new SquareOnlineStatusBean(null, 1, null);
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onCdnDownload(boolean success) {
        QLog.d("SquareOnlineStatusConfigProcessor", 1, "onCdnDownload " + success);
        ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadLargeConfigAsync("zplan_status_square_online_status_config", new b());
    }
}
