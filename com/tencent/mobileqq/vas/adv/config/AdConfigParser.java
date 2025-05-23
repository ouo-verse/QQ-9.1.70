package com.tencent.mobileqq.vas.adv.config;

import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.qphone.base.util.QLog;
import fz2.AdConfigBean;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\b\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/config/AdConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lfz2/a;", "", "bytes", "c", "b", "<init>", "()V", "d", "a", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class AdConfigParser extends BaseConfigParser<AdConfigBean> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public AdConfigBean defaultConfig() {
        return new AdConfigBean(false, false, false, false, null, null, null, null, null, null, 0, 0, null, InitSkin.DRAWABLE_COUNT, null);
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public AdConfigBean parse(@NotNull byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        AdConfigBean.Companion companion = AdConfigBean.INSTANCE;
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        AdConfigBean a16 = companion.a(new String(bytes, UTF_8));
        QLog.d("AdConfigParser", 1, "configs parse\uff1a" + a16);
        return a16;
    }
}
