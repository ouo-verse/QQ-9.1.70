package com.tencent.mobileqq.guild.homev2.views.embeddable;

import androidx.collection.LruCache;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rp1.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u000e\u0006B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/views/embeddable/Report;", "", "Lcom/tencent/mobileqq/guild/homev2/views/embeddable/Report$a;", "data", "", "b", "a", "Landroidx/collection/LruCache;", "", "", "Landroidx/collection/LruCache;", "timeRecord", "<init>", "()V", "FrameType", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class Report {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final Report f226086a = new Report();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final LruCache<String, Long> timeRecord = new LruCache<>(10);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/views/embeddable/Report$FrameType;", "", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes13.dex */
    public @interface FrameType {
    }

    Report() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x00b6, code lost:
    
        r9 = kotlin.collections.MapsKt___MapsKt.toList(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x00cc, code lost:
    
        if (r9 == null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(@NotNull ReportData data) {
        Pair[] pairArr;
        Map mutableMapOf;
        List list;
        Intrinsics.checkNotNullParameter(data, "data");
        String tabName = data.getTabName();
        String url = data.getUrl();
        int frameType = data.getFrameType();
        Long l3 = timeRecord.get(tabName + ":" + url);
        if (l3 == null) {
            l3 = Long.valueOf(System.currentTimeMillis());
        }
        long currentTimeMillis = System.currentTimeMillis() - l3.longValue();
        SpreadBuilder spreadBuilder = new SpreadBuilder(8);
        spreadBuilder.add(TuplesKt.to("sgrp_page_frame_type", Integer.valueOf(frameType)));
        spreadBuilder.add(TuplesKt.to("sgrp_url", url));
        spreadBuilder.add(TuplesKt.to("sgrp_cost_time", Long.valueOf(currentTimeMillis)));
        spreadBuilder.add(TuplesKt.to("sgrp_tab_zone_name", tabName));
        spreadBuilder.add(TuplesKt.to("sgrp_channel_id", data.getGuildId()));
        spreadBuilder.add(TuplesKt.to("sgrp_category_id", data.getCategoryId()));
        spreadBuilder.add(TuplesKt.to("sgrp_user_type", Integer.valueOf(a.a(ch.L(data.getGuildId())))));
        Map<String, String> b16 = data.b();
        if (b16 != null && list != null) {
            Object[] array = list.toArray(new Pair[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            pairArr = (Pair[]) array;
        }
        pairArr = new Pair[0];
        spreadBuilder.addSpread(pairArr);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf((Pair[]) spreadBuilder.toArray(new Pair[spreadBuilder.size()]));
        VideoReport.reportEvent("ev_sgrp_tab_zone_container_first_frame_finish", mutableMapOf);
        Logger.f235387a.d().i("Guild.NewHome.Report", 1, "reportFinishFrameEvent[" + frameType + "] " + tabName + "[" + url + "], cost: " + currentTimeMillis + " ms");
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0099, code lost:
    
        r9 = kotlin.collections.MapsKt___MapsKt.toList(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x00af, code lost:
    
        if (r9 == null) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(@NotNull ReportData data) {
        Pair[] pairArr;
        Map mutableMapOf;
        List list;
        Intrinsics.checkNotNullParameter(data, "data");
        long currentTimeMillis = System.currentTimeMillis();
        String tabName = data.getTabName();
        String url = data.getUrl();
        int frameType = data.getFrameType();
        timeRecord.put(tabName + ":" + url, Long.valueOf(currentTimeMillis));
        SpreadBuilder spreadBuilder = new SpreadBuilder(7);
        spreadBuilder.add(TuplesKt.to("sgrp_page_frame_type", Integer.valueOf(frameType)));
        spreadBuilder.add(TuplesKt.to("sgrp_url", url));
        spreadBuilder.add(TuplesKt.to("sgrp_tab_zone_name", tabName));
        spreadBuilder.add(TuplesKt.to("sgrp_channel_id", data.getGuildId()));
        spreadBuilder.add(TuplesKt.to("sgrp_category_id", data.getCategoryId()));
        spreadBuilder.add(TuplesKt.to("sgrp_user_type", Integer.valueOf(a.a(ch.L(data.getGuildId())))));
        Map<String, String> b16 = data.b();
        if (b16 != null && list != null) {
            Object[] array = list.toArray(new Pair[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            pairArr = (Pair[]) array;
        }
        pairArr = new Pair[0];
        spreadBuilder.addSpread(pairArr);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf((Pair[]) spreadBuilder.toArray(new Pair[spreadBuilder.size()]));
        VideoReport.reportEvent("ev_sgrp_tab_zone_container_open", mutableMapOf);
        Logger.f235387a.d().i("Guild.NewHome.Report", 1, "reportOpenFrameEvent[" + frameType + "] " + tabName + "[" + url + "]");
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010$\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001e\u00a2\u0006\u0004\b%\u0010&J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u0017R$\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u0017R$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\"\u0004\b\u001c\u0010\u0017R0\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u000e\u0010!\"\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/views/embeddable/Report$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "url", "b", "e", "tabName", "c", "I", "()I", "frameType", "d", "setGuildId", "(Ljava/lang/String;)V", "guildId", "getChannelId", "setChannelId", "channelId", "setCategoryId", "categoryId", "", "g", "Ljava/util/Map;", "()Ljava/util/Map;", "setExtras", "(Ljava/util/Map;)V", "extras", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.homev2.views.embeddable.Report$a, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class ReportData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String url;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String tabName;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int frameType;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private String guildId;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private String channelId;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private String categoryId;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private Map<String, String> extras;

        public ReportData(@NotNull String url, @NotNull String tabName, int i3, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Map<String, String> map) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(tabName, "tabName");
            this.url = url;
            this.tabName = tabName;
            this.frameType = i3;
            this.guildId = str;
            this.channelId = str2;
            this.categoryId = str3;
            this.extras = map;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final String getCategoryId() {
            return this.categoryId;
        }

        @Nullable
        public final Map<String, String> b() {
            return this.extras;
        }

        /* renamed from: c, reason: from getter */
        public final int getFrameType() {
            return this.frameType;
        }

        @Nullable
        /* renamed from: d, reason: from getter */
        public final String getGuildId() {
            return this.guildId;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final String getTabName() {
            return this.tabName;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReportData)) {
                return false;
            }
            ReportData reportData = (ReportData) other;
            if (Intrinsics.areEqual(this.url, reportData.url) && Intrinsics.areEqual(this.tabName, reportData.tabName) && this.frameType == reportData.frameType && Intrinsics.areEqual(this.guildId, reportData.guildId) && Intrinsics.areEqual(this.channelId, reportData.channelId) && Intrinsics.areEqual(this.categoryId, reportData.categoryId) && Intrinsics.areEqual(this.extras, reportData.extras)) {
                return true;
            }
            return false;
        }

        @NotNull
        /* renamed from: f, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            int hashCode4 = ((((this.url.hashCode() * 31) + this.tabName.hashCode()) * 31) + this.frameType) * 31;
            String str = this.guildId;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = (hashCode4 + hashCode) * 31;
            String str2 = this.channelId;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            String str3 = this.categoryId;
            if (str3 == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = str3.hashCode();
            }
            int i18 = (i17 + hashCode3) * 31;
            Map<String, String> map = this.extras;
            if (map != null) {
                i3 = map.hashCode();
            }
            return i18 + i3;
        }

        @NotNull
        public String toString() {
            return "ReportData(url=" + this.url + ", tabName=" + this.tabName + ", frameType=" + this.frameType + ", guildId=" + this.guildId + ", channelId=" + this.channelId + ", categoryId=" + this.categoryId + ", extras=" + this.extras + ")";
        }

        public /* synthetic */ ReportData(String str, String str2, int i3, String str3, String str4, String str5, Map map, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, i3, (i16 & 8) != 0 ? null : str3, (i16 & 16) != 0 ? null : str4, (i16 & 32) != 0 ? null : str5, (i16 & 64) != 0 ? null : map);
        }
    }
}
