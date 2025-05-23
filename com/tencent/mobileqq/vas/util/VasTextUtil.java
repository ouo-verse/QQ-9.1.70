package com.tencent.mobileqq.vas.util;

import com.tencent.mobileqq.emoticonview.ipc.proxy.EmojiManagerServiceProxy;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/vas/util/VasTextUtil;", "", "()V", "Companion", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VasTextUtil {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0004H\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/vas/util/VasTextUtil$Companion;", "", "()V", "hideUinInShowString", "", "uin", "startShow", "", "isNumeral", "", EmojiManagerServiceProxy.EPID, "parseId", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final String hideUinInShowString(@Nullable String uin, int startShow) {
            String substring;
            if (uin != null && uin.length() != 0) {
                if (startShow >= uin.length()) {
                    substring = "-";
                } else {
                    substring = uin.substring(startShow);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                }
                return "**" + substring;
            }
            return "null";
        }

        @JvmStatic
        public final boolean isNumeral(@Nullable String epId) {
            boolean z16 = false;
            if (epId != null && VasTextUtil.INSTANCE.parseId(epId) == -1) {
                z16 = true;
            }
            return !z16;
        }

        @JvmStatic
        public final int parseId(@NotNull String epId) {
            Intrinsics.checkNotNullParameter(epId, "epId");
            try {
                return Integer.parseInt(epId);
            } catch (Exception e16) {
                e16.printStackTrace();
                return -1;
            }
        }

        Companion() {
        }
    }

    @JvmStatic
    @NotNull
    public static final String hideUinInShowString(@Nullable String str, int i3) {
        return INSTANCE.hideUinInShowString(str, i3);
    }

    @JvmStatic
    public static final boolean isNumeral(@Nullable String str) {
        return INSTANCE.isNumeral(str);
    }

    @JvmStatic
    public static final int parseId(@NotNull String str) {
        return INSTANCE.parseId(str);
    }
}
