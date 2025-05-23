package com.tencent.aelight.camera.ae.download;

import com.tencent.aelight.camera.download.AEResManagerConfigBean;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00032\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0014J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/aelight/camera/ae/download/AEResNewManagerConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/aelight/camera/download/AEResManagerConfigBean;", "d", "", "content", "f", DownloadInfo.spKey_Config, "", "e", "", "success", "onCdnDownload", "<init>", "()V", "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class AEResNewManagerConfigParser extends BaseConfigParser<AEResManagerConfigBean> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    private static final String f63638e = "AEResNewManagerConfigParser";

    /* renamed from: f, reason: collision with root package name */
    private static final String f63639f = "lightsdk_bundle_hotfix_android";

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/aelight/camera/ae/download/AEResNewManagerConfigParser$a;", "", "Lpy2/a;", "Lcom/tencent/aelight/camera/download/AEResManagerConfigBean;", "callback", "", "c", "", "TAG", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "CONFIG_ID", "a", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.aelight.camera.ae.download.AEResNewManagerConfigParser$a, reason: from kotlin metadata */
    /* loaded from: classes32.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return AEResNewManagerConfigParser.f63639f;
        }

        public final String b() {
            return AEResNewManagerConfigParser.f63638e;
        }

        public final void c(py2.a<AEResManagerConfigBean> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            QLog.i(b(), 1, "loadConfig start");
            callback.a((AEResManagerConfigBean) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(a()));
            QLog.i(b(), 1, "loadConfig end");
        }

        Companion() {
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public AEResManagerConfigBean defaultConfig() {
        return new AEResManagerConfigBean();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(AEResManagerConfigBean config) {
        super.doOnConfigUpdate(config);
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public AEResManagerConfigBean parse(byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        String str = f63638e;
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        ms.a.f(str, "[onParsed] content=" + new String(content, UTF_8));
        Charset UTF_82 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_82, "UTF_8");
        AEResManagerConfigBean j06 = AEResManager.j0(new String(content, UTF_82), true);
        Intrinsics.checkNotNullExpressionValue(j06, "parseConfig(String(conte\u2026ardCharsets.UTF_8), true)");
        return j06;
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onCdnDownload(boolean success) {
        super.onCdnDownload(success);
        ms.a.f(f63638e, "[onCdnDownload]" + success);
        if (success) {
            AEResManager.J().g0();
        }
    }
}
