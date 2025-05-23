package com.tencent.mobileqq.guild.discovery;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import org.jetbrains.annotations.NotNull;

@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/discovery/DiscoveryConstants$PageFrom", "", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: classes13.dex */
public @interface DiscoveryConstants$PageFrom {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f216643a;
    public static final int DEFAULT = 0;
    public static final int FROM_DISCOVER_NAVIGATION_BAR = 6;
    public static final int FROM_DISCOVER_TAB = 9;
    public static final int FROM_FRIENDS_RECOMMEND = 7;
    public static final int FROM_HOME_PAGE_CARD = 4;
    public static final int FROM_LIVESTREAM_ALL = 10;
    public static final int FROM_MY_GUILD_PAGE = 5;
    public static final int FROM_SCHEMA = 8;
    public static final int ILLEGAL = -1;
    public static final int NEW_USER_DISCOVER = 2;
    public static final int PUBLIC_ACCOUNT = 1;
    public static final int SUBSCRIBE_CHANNEL = 3;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/DiscoveryConstants$PageFrom$a;", "", "", "pageFrom", "", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.discovery.DiscoveryConstants$PageFrom$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f216643a = new Companion();

        Companion() {
        }

        public final boolean a(int pageFrom) {
            if (pageFrom == 1) {
                return true;
            }
            return false;
        }
    }
}
