package com.tencent.guild.aio.util;

import com.tencent.guild.api.emoji.IGuildEmojiApi;
import com.tencent.guild.api.emoji.ILottieEmoProxyApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/guild/aio/util/o;", "", "", "content", "", "a", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final o f112412a = new o();

    o() {
    }

    public final boolean a(@NotNull String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        int length = content.length();
        int i3 = -1;
        int i16 = 0;
        for (int i17 = 0; i17 < length; i17++) {
            if (i17 > i3) {
                if (!e.f112380a.j(content, i17)) {
                    QLog.d("LottieCheckUtil", 2, "is not EmoHeaderCode");
                    return false;
                }
                if (!((IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class)).isValidEmojiFaceId(content, i17)) {
                    QLog.d("LottieCheckUtil", 2, "is Valid EmojiFaceId");
                    return false;
                }
                if (!((ILottieEmoProxyApi) QRoute.api(ILottieEmoProxyApi.class)).isSupportLottie(((IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class)).parseEmojiFaceStrToServerId(content, i17)) || (i16 = i16 + 1) > 1) {
                    return false;
                }
                i3 = i17 + 1;
            }
        }
        if (i16 != 1) {
            return false;
        }
        return true;
    }
}
