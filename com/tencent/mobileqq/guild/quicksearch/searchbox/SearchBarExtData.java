package com.tencent.mobileqq.guild.quicksearch.searchbox;

import com.tencent.mobileqq.guild.quicksearch.searchbox.SearchBarExtData;
import com.tencent.mobileqq.guild.util.ay;
import com.tencent.mobileqq.vaswebviewplugin.MessageRoamJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/searchbox/SearchBarExtData;", "", "<init>", "()V", "DateExtData", "a", "Lcom/tencent/mobileqq/guild/quicksearch/searchbox/SearchBarExtData$DateExtData;", "Lcom/tencent/mobileqq/guild/quicksearch/searchbox/SearchBarExtData$a;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public abstract class SearchBarExtData {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0013\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000b\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/searchbox/SearchBarExtData$DateExtData;", "Lcom/tencent/mobileqq/guild/quicksearch/searchbox/SearchBarExtData;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "a", "J", "c", "()J", PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "b", "Lkotlin/Lazy;", "()Ljava/lang/String;", "formatStringMD", "formatStringYMD", "<init>", "(J)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final /* data */ class DateExtData extends SearchBarExtData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final long timeStamp;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Lazy formatStringMD;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Lazy formatStringYMD;

        public DateExtData(long j3) {
            super(null);
            Lazy lazy;
            Lazy lazy2;
            this.timeStamp = j3;
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.guild.quicksearch.searchbox.SearchBarExtData$DateExtData$formatStringMD$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return new SimpleDateFormat("MM-dd").format(new Date(SearchBarExtData.DateExtData.this.getTimeStamp()));
                }
            });
            this.formatStringMD = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.guild.quicksearch.searchbox.SearchBarExtData$DateExtData$formatStringYMD$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT).format(new Date(SearchBarExtData.DateExtData.this.getTimeStamp()));
                }
            });
            this.formatStringYMD = lazy2;
        }

        @NotNull
        public final String a() {
            Object value = this.formatStringMD.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-formatStringMD>(...)");
            return (String) value;
        }

        @NotNull
        public final String b() {
            Object value = this.formatStringYMD.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-formatStringYMD>(...)");
            return (String) value;
        }

        /* renamed from: c, reason: from getter */
        public final long getTimeStamp() {
            return this.timeStamp;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof DateExtData) && this.timeStamp == ((DateExtData) other).timeStamp) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return androidx.fragment.app.a.a(this.timeStamp);
        }

        @NotNull
        public String toString() {
            return "DateExtData(" + b() + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/searchbox/SearchBarExtData$a;", "Lcom/tencent/mobileqq/guild/quicksearch/searchbox/SearchBarExtData;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "guildId", "b", "c", "tinyId", "name", "d", "I", "getUserType", "()I", MessageRoamJsPlugin.USERTYPE, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.quicksearch.searchbox.SearchBarExtData$a, reason: from toString */
    /* loaded from: classes14.dex */
    public static final /* data */ class GuildMemberExtData extends SearchBarExtData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String guildId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String tinyId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String name;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int userType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildMemberExtData(@NotNull String guildId, @NotNull String tinyId, @NotNull String name, int i3) {
            super(null);
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(tinyId, "tinyId");
            Intrinsics.checkNotNullParameter(name, "name");
            this.guildId = guildId;
            this.tinyId = tinyId;
            this.name = name;
            this.userType = i3;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getGuildId() {
            return this.guildId;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getTinyId() {
            return this.tinyId;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuildMemberExtData)) {
                return false;
            }
            GuildMemberExtData guildMemberExtData = (GuildMemberExtData) other;
            if (Intrinsics.areEqual(this.guildId, guildMemberExtData.guildId) && Intrinsics.areEqual(this.tinyId, guildMemberExtData.tinyId) && Intrinsics.areEqual(this.name, guildMemberExtData.name) && this.userType == guildMemberExtData.userType) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.guildId.hashCode() * 31) + this.tinyId.hashCode()) * 31) + this.name.hashCode()) * 31) + this.userType;
        }

        @NotNull
        public String toString() {
            return "GuildMemberExtData(tinyId='" + this.tinyId + "', name='" + ay.a(this.name) + "', userType=" + this.userType + ")";
        }
    }

    public /* synthetic */ SearchBarExtData(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    SearchBarExtData() {
    }
}
