package com.tencent.mobileqq.guild.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001:\u0003\u000f\u0010\u0011J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\fH&J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u000e\u001a\u00020\u0003H&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/api/IGuildAVChannelApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "exitChannel", "", "guildId", "", "channelId", "cb", "Lcom/tencent/mobileqq/guild/api/IGuildAVChannelApi$MediaChannelCallback;", "getCurrentChannelDetailInfo", "Lcom/tencent/mobileqq/guild/api/IGuildAVChannelApi$ChannelDetailInfo;", "isFloatingWndShowing", "", "isInChannel", "quitAVFloatWindowWithExitRoom", "ChannelDetailInfo", "ChannelSourceParam", "MediaChannelCallback", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGuildAVChannelApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0006H\u00c6\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/api/IGuildAVChannelApi$ChannelDetailInfo;", "", "guildId", "", "channelId", "source", "Lcom/tencent/mobileqq/guild/api/IGuildAVChannelApi$ChannelSourceParam;", "(JJLcom/tencent/mobileqq/guild/api/IGuildAVChannelApi$ChannelSourceParam;)V", "getChannelId", "()J", "getGuildId", "getSource", "()Lcom/tencent/mobileqq/guild/api/IGuildAVChannelApi$ChannelSourceParam;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final /* data */ class ChannelDetailInfo {
        private final long channelId;
        private final long guildId;

        @NotNull
        private final ChannelSourceParam source;

        public ChannelDetailInfo() {
            this(0L, 0L, null, 7, null);
        }

        public static /* synthetic */ ChannelDetailInfo copy$default(ChannelDetailInfo channelDetailInfo, long j3, long j16, ChannelSourceParam channelSourceParam, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                j3 = channelDetailInfo.guildId;
            }
            long j17 = j3;
            if ((i3 & 2) != 0) {
                j16 = channelDetailInfo.channelId;
            }
            long j18 = j16;
            if ((i3 & 4) != 0) {
                channelSourceParam = channelDetailInfo.source;
            }
            return channelDetailInfo.copy(j17, j18, channelSourceParam);
        }

        /* renamed from: component1, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        /* renamed from: component2, reason: from getter */
        public final long getChannelId() {
            return this.channelId;
        }

        @NotNull
        /* renamed from: component3, reason: from getter */
        public final ChannelSourceParam getSource() {
            return this.source;
        }

        @NotNull
        public final ChannelDetailInfo copy(long guildId, long channelId, @NotNull ChannelSourceParam source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new ChannelDetailInfo(guildId, channelId, source);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChannelDetailInfo)) {
                return false;
            }
            ChannelDetailInfo channelDetailInfo = (ChannelDetailInfo) other;
            if (this.guildId == channelDetailInfo.guildId && this.channelId == channelDetailInfo.channelId && Intrinsics.areEqual(this.source, channelDetailInfo.source)) {
                return true;
            }
            return false;
        }

        public final long getChannelId() {
            return this.channelId;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        @NotNull
        public final ChannelSourceParam getSource() {
            return this.source;
        }

        public int hashCode() {
            return (((androidx.fragment.app.a.a(this.guildId) * 31) + androidx.fragment.app.a.a(this.channelId)) * 31) + this.source.hashCode();
        }

        @NotNull
        public String toString() {
            return "ChannelDetailInfo(guildId=" + this.guildId + ", channelId=" + this.channelId + ", source=" + this.source + ')';
        }

        public ChannelDetailInfo(long j3, long j16, @NotNull ChannelSourceParam source) {
            Intrinsics.checkNotNullParameter(source, "source");
            this.guildId = j3;
            this.channelId = j16;
            this.source = source;
        }

        public /* synthetic */ ChannelDetailInfo(long j3, long j16, ChannelSourceParam channelSourceParam, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) == 0 ? j16 : 0L, (i3 & 4) != 0 ? new ChannelSourceParam(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0) : channelSourceParam);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/api/IGuildAVChannelApi$ChannelSourceParam;", "", "mainSourceId", "", "subSourceId", "(Ljava/lang/String;Ljava/lang/String;)V", "getMainSourceId", "()Ljava/lang/String;", "getSubSourceId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final /* data */ class ChannelSourceParam {

        @Nullable
        private final String mainSourceId;

        @Nullable
        private final String subSourceId;

        public ChannelSourceParam() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ ChannelSourceParam copy$default(ChannelSourceParam channelSourceParam, String str, String str2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = channelSourceParam.mainSourceId;
            }
            if ((i3 & 2) != 0) {
                str2 = channelSourceParam.subSourceId;
            }
            return channelSourceParam.copy(str, str2);
        }

        @Nullable
        /* renamed from: component1, reason: from getter */
        public final String getMainSourceId() {
            return this.mainSourceId;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final String getSubSourceId() {
            return this.subSourceId;
        }

        @NotNull
        public final ChannelSourceParam copy(@Nullable String mainSourceId, @Nullable String subSourceId) {
            return new ChannelSourceParam(mainSourceId, subSourceId);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChannelSourceParam)) {
                return false;
            }
            ChannelSourceParam channelSourceParam = (ChannelSourceParam) other;
            if (Intrinsics.areEqual(this.mainSourceId, channelSourceParam.mainSourceId) && Intrinsics.areEqual(this.subSourceId, channelSourceParam.subSourceId)) {
                return true;
            }
            return false;
        }

        @Nullable
        public final String getMainSourceId() {
            return this.mainSourceId;
        }

        @Nullable
        public final String getSubSourceId() {
            return this.subSourceId;
        }

        public int hashCode() {
            int hashCode;
            String str = this.mainSourceId;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode * 31;
            String str2 = this.subSourceId;
            if (str2 != null) {
                i3 = str2.hashCode();
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            return "ChannelSourceParam(mainSourceId=" + this.mainSourceId + ", subSourceId=" + this.subSourceId + ')';
        }

        public ChannelSourceParam(@Nullable String str, @Nullable String str2) {
            this.mainSourceId = str;
            this.subSourceId = str2;
        }

        public /* synthetic */ ChannelSourceParam(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2);
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void exitChannel$default(IGuildAVChannelApi iGuildAVChannelApi, long j3, long j16, MediaChannelCallback mediaChannelCallback, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    mediaChannelCallback = null;
                }
                iGuildAVChannelApi.exitChannel(j3, j16, mediaChannelCallback);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: exitChannel");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\u0003H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/api/IGuildAVChannelApi$MediaChannelCallback;", "", "onFailed", "", "errCode", "", "errMsg", "", "promptMsg", "onSuccess", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public interface MediaChannelCallback {

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes12.dex */
        public static final class DefaultImpls {
            public static /* synthetic */ void onFailed$default(MediaChannelCallback mediaChannelCallback, int i3, String str, String str2, int i16, Object obj) {
                if (obj == null) {
                    if ((i16 & 4) != 0) {
                        str2 = "";
                    }
                    mediaChannelCallback.onFailed(i3, str, str2);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onFailed");
            }
        }

        void onFailed(int errCode, @NotNull String errMsg, @NotNull String promptMsg);

        void onSuccess();
    }

    void exitChannel(long guildId, long channelId, @Nullable MediaChannelCallback cb5);

    @NotNull
    ChannelDetailInfo getCurrentChannelDetailInfo();

    boolean isFloatingWndShowing();

    boolean isInChannel();

    boolean isInChannel(long guildId, long channelId);

    void quitAVFloatWindowWithExitRoom();
}
