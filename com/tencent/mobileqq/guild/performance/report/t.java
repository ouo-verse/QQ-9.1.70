package com.tencent.mobileqq.guild.performance.report;

import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.performance.report.r;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/performance/report/t;", "", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "bizType", "", "b", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final t f231060a = new t();

    t() {
    }

    @JvmStatic
    public static final void b(@NotNull final LoadState state, @NotNull final Option option, @NotNull final String bizType) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(option, "option");
        Intrinsics.checkNotNullParameter(bizType, "bizType");
        if (state != LoadState.STATE_DOWNLOAD_FAILED && state != LoadState.STATE_DOWNLOAD_SUCCESS) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.performance.report.s
            @Override // java.lang.Runnable
            public final void run() {
                t.c(bizType, option, state);
            }
        }, 64, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void c(String bizType, Option option, LoadState state) {
        String valueOf;
        long j3;
        Intrinsics.checkNotNullParameter(bizType, "$bizType");
        Intrinsics.checkNotNullParameter(option, "$option");
        Intrinsics.checkNotNullParameter(state, "$state");
        r.a aVar = new r.a();
        aVar.f231044a = bizType;
        aVar.f231045b = option.getUrl();
        if (state == LoadState.STATE_DOWNLOAD_SUCCESS) {
            valueOf = "0";
        } else {
            valueOf = String.valueOf(state);
        }
        aVar.f231051h = valueOf;
        aVar.f231054k = option.getLocalPath();
        aVar.f231048e = "0";
        Long l3 = option.mStartTime;
        if (l3 != null) {
            Intrinsics.checkNotNullExpressionValue(l3, "option.mStartTime");
            if (l3.longValue() > 0) {
                aVar.f231049f = String.valueOf(option.mStartTime);
                long currentTimeMillis = System.currentTimeMillis();
                Long l16 = option.mStartTime;
                Intrinsics.checkNotNullExpressionValue(l16, "option.mStartTime");
                j3 = currentTimeMillis - l16.longValue();
                aVar.f231050g = String.valueOf(j3);
                if (option.getLocalPath() != null) {
                    File file = new File(option.getLocalPath());
                    if (file.exists()) {
                        long length = file.length();
                        aVar.f231046c = String.valueOf(length);
                        if (j3 > 0) {
                            aVar.f231053j = (((((float) length) * 1.0f) / ((float) j3)) * 1000) + "B/s";
                        }
                    }
                }
                r.c(GuildTelemetryTask.DOWNLOAD_PIC, aVar);
                u.a("guild_pic_download_cost", j3);
            }
        }
        j3 = 0;
        if (option.getLocalPath() != null) {
        }
        r.c(GuildTelemetryTask.DOWNLOAD_PIC, aVar);
        u.a("guild_pic_download_cost", j3);
    }
}
