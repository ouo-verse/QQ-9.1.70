package com.tencent.biz.qqcircle.immersive.personal.publishguide;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/publishguide/BannerStyle;", "", "", "code", "I", "getCode", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "UNKNOWN", "SIDESLIP", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public enum BannerStyle {
    UNKNOWN(0),
    SIDESLIP(3);


    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final int code;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/publishguide/BannerStyle$a;", "", "", "style", "Lcom/tencent/biz/qqcircle/immersive/personal/publishguide/BannerStyle;", "a", "(Ljava/lang/Integer;)Lcom/tencent/biz/qqcircle/immersive/personal/publishguide/BannerStyle;", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.immersive.personal.publishguide.BannerStyle$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final BannerStyle a(@Nullable Integer style) {
            BannerStyle bannerStyle;
            boolean z16;
            BannerStyle[] values = BannerStyle.values();
            int length = values.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    bannerStyle = values[i3];
                    int code = bannerStyle.getCode();
                    if (style != null && code == style.intValue()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                    i3++;
                } else {
                    bannerStyle = null;
                    break;
                }
            }
            if (bannerStyle == null) {
                return BannerStyle.UNKNOWN;
            }
            return bannerStyle;
        }

        Companion() {
        }
    }

    BannerStyle(int i3) {
        this.code = i3;
    }

    public final int getCode() {
        return this.code;
    }
}
