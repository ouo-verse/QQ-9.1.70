package com.tencent.mobileqq.qqguildsdk.api.impl;

import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi;
import com.tencent.mobileqq.qqguildsdk.api.IQQGuildUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\n\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/api/impl/QQGuildUtilApiImpl;", "Lcom/tencent/mobileqq/qqguildsdk/api/IQQGuildUtilApi;", "", "isUserOnLine", "", "guildId", "", "avatarSeq", "", "type", "getAvatarUrl", "coverSeq", "width", "height", "getCoverUrl", "<init>", "()V", "Companion", "a", "qqguild-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQGuildUtilApiImpl implements IQQGuildUtilApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final long ONLINE_TIME_LIMIT = 600000;

    @NotNull
    public static final String TAG = "QQGuildUtilApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J \u0010\b\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J(\u0010\f\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006R\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/api/impl/QQGuildUtilApiImpl$a;", "", "", "guildId", "", "avatarSeq", "", "type", "a", "coverSeq", "width", "height", "b", "ONLINE_TIME_LIMIT", "J", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqguildsdk.api.impl.QQGuildUtilApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String a(@Nullable String guildId, long avatarSeq, int type) {
            StringBuilder sb5 = new StringBuilder("https://");
            sb5.append(com.tencent.mobileqq.qqguildsdk.manager.c.d().c());
            sb5.append("/");
            sb5.append(guildId);
            sb5.append("/");
            sb5.append(type);
            sb5.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
            sb5.append("t=");
            sb5.append(avatarSeq);
            if (avatarSeq == 0) {
                sb5.append("&_r_cache=1");
            }
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "urlBuilder.toString()");
            return sb6;
        }

        @NotNull
        public final String b(@Nullable String guildId, long coverSeq, int width, int height) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.getDefault(), "https://%1$s/%2$s?imageView2/1/w/%3$s/h/%4$s&t=%5$d", Arrays.copyOf(new Object[]{com.tencent.mobileqq.qqguildsdk.manager.c.d().a(), guildId, Integer.valueOf(width), Integer.valueOf(height), Long.valueOf(coverSeq)}, 5));
            Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
            if (coverSeq == 0) {
                return format + "&_r_cache=1";
            }
            return format;
        }

        Companion() {
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IQQGuildUtilApi
    @NotNull
    public String getAvatarUrl(@Nullable String guildId, long avatarSeq, int type) {
        return INSTANCE.a(guildId, avatarSeq, type);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IQQGuildUtilApi
    @NotNull
    public String getCoverUrl(@Nullable String guildId, long coverSeq, int width, int height) {
        return INSTANCE.b(guildId, coverSeq, width, height);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IQQGuildUtilApi
    public boolean isUserOnLine() {
        boolean z16;
        Long onBackgroundTime = ((IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class)).getGuildUserOnBackgroundTime();
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null && guardManager.isApplicationForeground()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        Intrinsics.checkNotNullExpressionValue(onBackgroundTime, "onBackgroundTime");
        if (onBackgroundTime.longValue() <= 0 || System.currentTimeMillis() - onBackgroundTime.longValue() <= 600000) {
            return true;
        }
        return false;
    }
}
