package com.tencent.mobileqq.wink;

import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import common.config.service.QzoneConfig;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\u0006\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001b\u0010\t\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0005\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/wink/WinkConfig;", "", "", "b", "Lkotlin/Lazy;", "()J", "videoMaxDurationUs", "c", "a", "videoMaxDurationMs", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkConfig {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final WinkConfig f317649a = new WinkConfig();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy videoMaxDurationUs;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy videoMaxDurationMs;

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Long>() { // from class: com.tencent.mobileqq.wink.WinkConfig$videoMaxDurationUs$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Long invoke() {
                return Long.valueOf(WinkConfig.f317649a.a() * 1000);
            }
        });
        videoMaxDurationUs = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Long>() { // from class: com.tencent.mobileqq.wink.WinkConfig$videoMaxDurationMs$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Long invoke() {
                try {
                    MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QCIRCLE);
                    Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QCIRCLE)");
                    int decodeInt = from.decodeInt(QQWinkConstants.KEY_VIDEO_EDIT_MAX_DURATION_SEC, 0);
                    if (decodeInt > 0) {
                        w53.b.f("WinkConfig", "durationSec = " + decodeInt);
                        return Long.valueOf(decodeInt * 1000);
                    }
                    long videoMaxDurationSec = QzoneConfig.getVideoMaxDurationSec();
                    if (videoMaxDurationSec > 0) {
                        w53.b.f("WinkConfig", "wnsDurationSec = " + videoMaxDurationSec);
                        return Long.valueOf(videoMaxDurationSec * 1000);
                    }
                    w53.b.f("WinkConfig", "default durationMs = 900000");
                    return 900000L;
                } catch (Exception e16) {
                    w53.b.d("WinkConfig", "default durationMs = 900000", e16);
                    return 900000L;
                }
            }
        });
        videoMaxDurationMs = lazy2;
    }

    WinkConfig() {
    }

    public final long a() {
        return ((Number) videoMaxDurationMs.getValue()).longValue();
    }

    public final long b() {
        return ((Number) videoMaxDurationUs.getValue()).longValue();
    }
}
