package com.tencent.mobileqq.activity.aio.intimate.config;

import android.text.TextUtils;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import e61.b;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/intimate/config/InteractSendMsgConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Le61/b;", "b", "", "content", "d", DownloadInfo.spKey_Config, "", "c", "<init>", "()V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class InteractSendMsgConfigParser extends BaseConfigParser<b> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b defaultConfig() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(@Nullable b config) {
        super.doOnConfigUpdate(config);
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public b parse(@NotNull byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        String str = new String(content, UTF_8);
        if (TextUtils.isEmpty(str)) {
            return new b();
        }
        return b.INSTANCE.a(str);
    }
}
