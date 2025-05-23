package com.tencent.mobileqq.guild.config;

import com.tencent.mobileqq.guild.util.ch;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\tB\u001d\b\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/config/aa;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "isKaShareNavigate", "()Z", "b", "Ljava/lang/String;", "getKaShareNavigateUrl", "()Ljava/lang/String;", "kaShareNavigateUrl", "<init>", "(ZLjava/lang/String;)V", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.config.aa, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class QQGuildShareConfigBean {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final ConcurrentHashMap<String, QQGuildShareConfigBean> f216106d = new ConcurrentHashMap<>();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isKaShareNavigate;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String kaShareNavigateUrl;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/config/aa$a;", "", "Lcom/tencent/mobileqq/guild/config/aa;", "bean", "", "a", "Ljava/util/concurrent/ConcurrentHashMap;", "", "sBeans", "Ljava/util/concurrent/ConcurrentHashMap;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.config.aa$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull QQGuildShareConfigBean bean) {
            Intrinsics.checkNotNullParameter(bean, "bean");
            String g16 = ch.g();
            Intrinsics.checkNotNullExpressionValue(g16, "accountUin()");
            QQGuildShareConfigBean.f216106d.put(g16, bean);
        }

        Companion() {
        }
    }

    @JvmOverloads
    public QQGuildShareConfigBean() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QQGuildShareConfigBean)) {
            return false;
        }
        QQGuildShareConfigBean qQGuildShareConfigBean = (QQGuildShareConfigBean) other;
        if (this.isKaShareNavigate == qQGuildShareConfigBean.isKaShareNavigate && Intrinsics.areEqual(this.kaShareNavigateUrl, qQGuildShareConfigBean.kaShareNavigateUrl)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z16 = this.isKaShareNavigate;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (r06 * 31) + this.kaShareNavigateUrl.hashCode();
    }

    @NotNull
    public String toString() {
        return "QQGuildShareConfigBean(isKaShareNavigate=" + this.isKaShareNavigate + ", kaShareNavigateUrl=" + this.kaShareNavigateUrl + ")";
    }

    @JvmOverloads
    public QQGuildShareConfigBean(boolean z16, @NotNull String kaShareNavigateUrl) {
        Intrinsics.checkNotNullParameter(kaShareNavigateUrl, "kaShareNavigateUrl");
        this.isKaShareNavigate = z16;
        this.kaShareNavigateUrl = kaShareNavigateUrl;
    }

    public /* synthetic */ QQGuildShareConfigBean(boolean z16, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? "" : str);
    }
}
