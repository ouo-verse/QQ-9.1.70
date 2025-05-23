package com.tencent.mobileqq.gamecenter.qa.config;

import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ud1.MetaDreamHippyConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\t\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/config/MetaDreamHippyConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lud1/e;", "", "version", "", "onSend", "", "content", "d", "b", DownloadInfo.spKey_Config, "c", "<init>", "()V", "a", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class MetaDreamHippyConfigParser extends BaseConfigParser<MetaDreamHippyConfig> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public MetaDreamHippyConfig defaultConfig() {
        QLog.d("MetaDreamHippyConfigParser", 1, "get defaultConfig");
        return new MetaDreamHippyConfig();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(@Nullable MetaDreamHippyConfig config) {
        QLog.d("MetaDreamHippyConfigParser", 1, "doOnConfigUpdate");
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public MetaDreamHippyConfig parse(@NotNull byte[] content) {
        boolean z16;
        Intrinsics.checkNotNullParameter(content, "content");
        MetaDreamHippyConfig metaDreamHippyConfig = new MetaDreamHippyConfig();
        if (content.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            metaDreamHippyConfig.h(new String(content, UTF_8));
            QLog.d("MetaDreamHippyConfigParser", 1, "parse, config: " + metaDreamHippyConfig);
        } else {
            QLog.d("MetaDreamHippyConfigParser", 1, "parse empty content");
        }
        return metaDreamHippyConfig;
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onSend(@NotNull String version) {
        Intrinsics.checkNotNullParameter(version, "version");
        QLog.d("MetaDreamHippyConfigParser", 1, "onSend version: ", version);
    }
}
