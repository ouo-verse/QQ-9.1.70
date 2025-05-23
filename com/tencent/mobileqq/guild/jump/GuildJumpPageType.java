package com.tencent.mobileqq.guild.jump;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/jump/GuildJumpPageType;", "", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: classes13.dex */
public @interface GuildJumpPageType {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f226377a;
    public static final int DEFAULT = 0;
    public static final int DIALOG_JOIN_GUILD = 4;
    public static final int DIALOG_STANDALONE = 3;
    public static final int FEED_CHANNEL = 6;
    public static final int FEED_DETAIL = 11;
    public static final int FULL_STANDALONE = 1;
    public static final int FULL_STANDALONE_GUEST = 2;
    public static final int LIVE_CHANNEL = 7;
    public static final int MEDIA_CHANNEL = 9;
    public static final int SCHEDULE_CHANNEL = 8;
    public static final int SCHEDULE_DETAIL = 12;
    public static final int TEXT_CHANNEL = 5;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/jump/GuildJumpPageType$a;", "", "", "businessType", "a", "(Ljava/lang/Integer;)I", "pageType", "", "b", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.jump.GuildJumpPageType$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f226377a = new Companion();

        Companion() {
        }

        public final int a(@Nullable Integer businessType) {
            if (businessType != null && businessType.intValue() == 1) {
                return 12;
            }
            if (businessType != null && businessType.intValue() == 2) {
                return 11;
            }
            if (businessType != null && businessType.intValue() == 3) {
                return 7;
            }
            if (businessType != null && businessType.intValue() == 4) {
                return 9;
            }
            if (businessType == null || businessType.intValue() != 5) {
                if (businessType == null || businessType.intValue() != 6) {
                    if (businessType != null && businessType.intValue() == 7) {
                        return 5;
                    }
                    if (businessType == null || businessType.intValue() != 8) {
                        if (businessType == null || businessType.intValue() != 9) {
                            if (businessType == null || businessType.intValue() != 10) {
                                if ((businessType == null || businessType.intValue() != 11) && (businessType == null || businessType.intValue() != 13)) {
                                    if (businessType == null || businessType.intValue() != 15) {
                                        if (businessType != null) {
                                            businessType.intValue();
                                        }
                                    }
                                }
                            }
                            return 6;
                        }
                    }
                }
                return 4;
            }
            return 2;
        }

        public final boolean b(int pageType) {
            if (pageType != 5 && pageType != 6 && pageType != 7 && pageType != 9 && pageType != 11 && pageType != 2) {
                return false;
            }
            return true;
        }
    }
}
