package com.tencent.mobileqq.config.business.mutualmark;

import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.config.business.ad;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import py2.a;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00032\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/config/business/mutualmark/MutualMarkConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/config/business/ad;", "d", "", "content", "f", "", "success", "", "onCdnDownload", "<init>", "()V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class MutualMarkConfigParser extends BaseConfigParser<ad> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static ad f202695e = new ad();

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007R\u0016\u0010\u0006\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/config/business/mutualmark/MutualMarkConfigParser$a;", "", "", "a", "Lcom/tencent/mobileqq/config/business/ad;", "b", "cacheBean", "Lcom/tencent/mobileqq/config/business/ad;", "", "tag", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.config.business.mutualmark.MutualMarkConfigParser$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/config/business/mutualmark/MutualMarkConfigParser$a$a", "Lpy2/a;", "Lcom/tencent/mobileqq/config/business/ad;", DownloadInfo.spKey_Config, "", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.config.business.mutualmark.MutualMarkConfigParser$a$a, reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public static final class C7471a implements a<ad> {
            C7471a() {
            }

            @Override // py2.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(@Nullable ad config) {
                if (config != null) {
                    MutualMarkConfigParser.f202695e = config;
                }
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a() {
            ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadLargeConfigAsync("elegant_mutualmark_config_524", new C7471a());
        }

        @JvmStatic
        @NotNull
        public final ad b() {
            return MutualMarkConfigParser.f202695e;
        }

        Companion() {
        }
    }

    @JvmStatic
    @NotNull
    public static final ad e() {
        return INSTANCE.b();
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public ad defaultConfig() {
        return new ad();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ad parse(@NotNull byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        ad bean = ad.j(new String(content, UTF_8));
        QLog.i("MutualMarkConfigParser", 1, "configs parse\uff1a" + bean);
        Intrinsics.checkNotNullExpressionValue(bean, "bean");
        return bean;
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onCdnDownload(boolean success) {
        super.onCdnDownload(success);
        QLog.i("MutualMarkConfigParser", 1, "onCdnDownload success\uff1a" + success);
        INSTANCE.a();
    }
}
