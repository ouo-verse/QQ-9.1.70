package com.tencent.mobileqq.qcircle.api.impl;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.tencent.common.app.AppInterface;
import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountTechReporter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsJVMKt;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uq3.k;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0012\u0018\u0000 B2\u00020\u0001:\u0007BCDEFGHB\u0005\u00a2\u0006\u0002\u0010\u0002J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J@\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020!H\u0016J\b\u0010'\u001a\u00020\u001cH\u0016J\b\u0010(\u001a\u00020\u001cH\u0016J@\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020!2\u0006\u0010 \u001a\u00020!2\u0006\u0010,\u001a\u00020!2\u0006\u0010-\u001a\u00020!2\u0006\u0010.\u001a\u00020\f2\u0006\u0010/\u001a\u00020!H\u0016J\u0010\u00100\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020\u001fH\u0016J\u0018\u00101\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020\u001f2\u0006\u00102\u001a\u00020!H\u0016J$\u00103\u001a\u00020\u001c2\u0006\u00104\u001a\u00020\u001f2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020706H\u0002J\b\u00108\u001a\u00020\u001cH\u0002J\u0010\u00109\u001a\u00020\u001c2\u0006\u0010:\u001a\u00020\u0010H\u0002J\u0014\u0010;\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010<\u001a\u00020\fH\u0002J\f\u0010=\u001a\u00020\u000e*\u00020!H\u0002J\f\u0010>\u001a\u00020\u001f*\u00020\u001fH\u0002J\u0018\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020706*\u00020\u0004H\u0002J \u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020706*\u00020\u00062\u0006\u0010@\u001a\u00020\u000eH\u0002J\u0018\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020706*\u00020\bH\u0002J\u0018\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020706*\u00020\nH\u0002J\"\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020706*\u00020\u00102\b\b\u0002\u0010A\u001a\u00020!H\u0002J\u0018\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020706*\u00020\u0019H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R/\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u00108B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/qcircle/api/impl/QCirclePublicAccountTechReporterImpl;", "Lcom/tencent/mobileqq/qcircle/api/IQCirclePublicAccountTechReporter;", "()V", "coverExposureInfo", "Lcom/tencent/mobileqq/qcircle/api/impl/QCirclePublicAccountTechReporterImpl$CoverExposureInfo;", "enterInfo", "Lcom/tencent/mobileqq/qcircle/api/impl/QCirclePublicAccountTechReporterImpl$EnterInfo;", "feedExposureInfo", "Lcom/tencent/mobileqq/qcircle/api/impl/QCirclePublicAccountTechReporterImpl$FeedExposureInfo;", "firstFrameExposureInfo", "Lcom/tencent/mobileqq/qcircle/api/impl/QCirclePublicAccountTechReporterImpl$FirstFrameExposureInfo;", "pageInitTimestamp", "", "redDotFeedClickedTimes", "", "<set-?>", "Lcom/tencent/mobileqq/qcircle/api/impl/QCirclePublicAccountTechReporterImpl$RedDotMsgInfo;", "redDotMsgInfo", "getRedDotMsgInfo", "()Lcom/tencent/mobileqq/qcircle/api/impl/QCirclePublicAccountTechReporterImpl$RedDotMsgInfo;", "setRedDotMsgInfo", "(Lcom/tencent/mobileqq/qcircle/api/impl/QCirclePublicAccountTechReporterImpl$RedDotMsgInfo;)V", "redDotMsgInfo$delegate", "Lkotlin/properties/ReadWriteProperty;", "videoPlayerOpenInfo", "Lcom/tencent/mobileqq/qcircle/api/impl/QCirclePublicAccountTechReporterImpl$VideoPlayerOpenInfo;", "getRedDotMsgInfoFromCached", "onCoverExposure", "", "onEnterPage", "enterFeedId", "", "isOnFetchMsgStage", "", "hasRedDot", "needChangeUrl", "coverCacheStatusCode", "needForceRefresh", "isFromStagger", "onFeedExposure", "onPageInit", "onReceiveMsg", "feedId", "isNowOnline", "isPreloadEnabled", "isOfflinePreloadEnabled", "playUrlTimestamp", "needExchangeUrlWhenReceiveMsg", "onVideoPlayerOpen", "onVideoPlayerPrepared", "hitDownloaded", "report", "eventId", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "", "", "reset", "saveRedDotMsgInfoToCached", "info", "toEnterId", "timestamp", "toInt", "toMMKVKey", "toMap", "clickTimes", "needRedDotFeedId", "Companion", "CoverExposureInfo", "EnterInfo", "FeedExposureInfo", "FirstFrameExposureInfo", "RedDotMsgInfo", "VideoPlayerOpenInfo", "qcircle-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class QCirclePublicAccountTechReporterImpl implements IQCirclePublicAccountTechReporter {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(QCirclePublicAccountTechReporterImpl.class, "redDotMsgInfo", "getRedDotMsgInfo()Lcom/tencent/mobileqq/qcircle/api/impl/QCirclePublicAccountTechReporterImpl$RedDotMsgInfo;", 0))};

    @NotNull
    private static final String EV_XSJ_PUBLIC_ACCOUNT_COVER_EXPOSURE = "ev_xsj_public_account_cover_exposure";

    @NotNull
    private static final String EV_XSJ_PUBLIC_ACCOUNT_FEED_EXPOSURE = "ev_xsj_public_account_feed_exposure";

    @NotNull
    private static final String EV_XSJ_PUBLIC_ACCOUNT_FRAME_EXPOSURE = "ev_xsj_public_account_frame_exposure";

    @NotNull
    private static final String EV_XSJ_PUBLIC_ACCOUNT_RECEIVE_MSG = "ev_xsj_public_account_receive_msg";

    @NotNull
    private static final String EV_XSJ_PUBLIC_ACCOUNT_START = "ev_xsj_public_account_start";

    @NotNull
    private static final String EV_XSJ_PUBLIC_ACCOUNT_VIDEO_PLAYER_OPEN = "ev_xsj_public_account_video_player_open";

    @NotNull
    private static final String PUBLIC_ACCOUNT_RED_DOT_INFO = "PUBLIC_ACCOUNT_RED_DOT_INFO";
    private static final int RED_DOT_FEED_CLICK_TIMES_NEVER = -1;

    @NotNull
    private static final String TAG = "QCirclePublicAccountTechReporterImpl";

    @Nullable
    private CoverExposureInfo coverExposureInfo;

    @Nullable
    private EnterInfo enterInfo;

    @Nullable
    private FeedExposureInfo feedExposureInfo;

    @Nullable
    private FirstFrameExposureInfo firstFrameExposureInfo;
    private long pageInitTimestamp;
    private int redDotFeedClickedTimes;

    /* renamed from: redDotMsgInfo$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty redDotMsgInfo;

    @Nullable
    private VideoPlayerOpenInfo videoPlayerOpenInfo;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qcircle/api/impl/QCirclePublicAccountTechReporterImpl$CoverExposureInfo;", "", "coverExposureTimestamp", "", "timeCostFromEnterUntilExposure", "(JJ)V", "getCoverExposureTimestamp", "()J", "getTimeCostFromEnterUntilExposure", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "qcircle-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final /* data */ class CoverExposureInfo {
        private final long coverExposureTimestamp;
        private final long timeCostFromEnterUntilExposure;

        public CoverExposureInfo(long j3, long j16) {
            this.coverExposureTimestamp = j3;
            this.timeCostFromEnterUntilExposure = j16;
        }

        public static /* synthetic */ CoverExposureInfo copy$default(CoverExposureInfo coverExposureInfo, long j3, long j16, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                j3 = coverExposureInfo.coverExposureTimestamp;
            }
            if ((i3 & 2) != 0) {
                j16 = coverExposureInfo.timeCostFromEnterUntilExposure;
            }
            return coverExposureInfo.copy(j3, j16);
        }

        /* renamed from: component1, reason: from getter */
        public final long getCoverExposureTimestamp() {
            return this.coverExposureTimestamp;
        }

        /* renamed from: component2, reason: from getter */
        public final long getTimeCostFromEnterUntilExposure() {
            return this.timeCostFromEnterUntilExposure;
        }

        @NotNull
        public final CoverExposureInfo copy(long coverExposureTimestamp, long timeCostFromEnterUntilExposure) {
            return new CoverExposureInfo(coverExposureTimestamp, timeCostFromEnterUntilExposure);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CoverExposureInfo)) {
                return false;
            }
            CoverExposureInfo coverExposureInfo = (CoverExposureInfo) other;
            if (this.coverExposureTimestamp == coverExposureInfo.coverExposureTimestamp && this.timeCostFromEnterUntilExposure == coverExposureInfo.timeCostFromEnterUntilExposure) {
                return true;
            }
            return false;
        }

        public final long getCoverExposureTimestamp() {
            return this.coverExposureTimestamp;
        }

        public final long getTimeCostFromEnterUntilExposure() {
            return this.timeCostFromEnterUntilExposure;
        }

        public int hashCode() {
            return (androidx.fragment.app.a.a(this.coverExposureTimestamp) * 31) + androidx.fragment.app.a.a(this.timeCostFromEnterUntilExposure);
        }

        @NotNull
        public String toString() {
            return "CoverExposureInfo(coverExposureTimestamp=" + this.coverExposureTimestamp + ", timeCostFromEnterUntilExposure=" + this.timeCostFromEnterUntilExposure + ')';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001d\b\u0082\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\tH\u00c6\u0003J\t\u0010 \u001a\u00020\u0006H\u00c6\u0003J\t\u0010!\u001a\u00020\fH\u00c6\u0003J\t\u0010\"\u001a\u00020\u0006H\u00c6\u0003J\t\u0010#\u001a\u00020\u0006H\u00c6\u0003Jc\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010%\u001a\u00020\u00062\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010'\u001a\u00020\fH\u00d6\u0001J\t\u0010(\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000e\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0018R\u0011\u0010\n\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\r\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/qcircle/api/impl/QCirclePublicAccountTechReporterImpl$EnterInfo;", "", "enterFeedId", "", "enterId", "isOnFetchMsgStage", "", "hasRedDot", "enterTimestamp", "", "needChangeUrl", "coverCacheStatusCode", "", "needForceRefresh", "isFromStagger", "(Ljava/lang/String;Ljava/lang/String;ZZJZIZZ)V", "getCoverCacheStatusCode", "()I", "getEnterFeedId", "()Ljava/lang/String;", "getEnterId", "getEnterTimestamp", "()J", "getHasRedDot", "()Z", "getNeedChangeUrl", "getNeedForceRefresh", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "qcircle-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final /* data */ class EnterInfo {
        private final int coverCacheStatusCode;

        @NotNull
        private final String enterFeedId;

        @NotNull
        private final String enterId;
        private final long enterTimestamp;
        private final boolean hasRedDot;
        private final boolean isFromStagger;
        private final boolean isOnFetchMsgStage;
        private final boolean needChangeUrl;
        private final boolean needForceRefresh;

        public EnterInfo(@NotNull String enterFeedId, @NotNull String enterId, boolean z16, boolean z17, long j3, boolean z18, int i3, boolean z19, boolean z26) {
            Intrinsics.checkNotNullParameter(enterFeedId, "enterFeedId");
            Intrinsics.checkNotNullParameter(enterId, "enterId");
            this.enterFeedId = enterFeedId;
            this.enterId = enterId;
            this.isOnFetchMsgStage = z16;
            this.hasRedDot = z17;
            this.enterTimestamp = j3;
            this.needChangeUrl = z18;
            this.coverCacheStatusCode = i3;
            this.needForceRefresh = z19;
            this.isFromStagger = z26;
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getEnterFeedId() {
            return this.enterFeedId;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getEnterId() {
            return this.enterId;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsOnFetchMsgStage() {
            return this.isOnFetchMsgStage;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getHasRedDot() {
            return this.hasRedDot;
        }

        /* renamed from: component5, reason: from getter */
        public final long getEnterTimestamp() {
            return this.enterTimestamp;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getNeedChangeUrl() {
            return this.needChangeUrl;
        }

        /* renamed from: component7, reason: from getter */
        public final int getCoverCacheStatusCode() {
            return this.coverCacheStatusCode;
        }

        /* renamed from: component8, reason: from getter */
        public final boolean getNeedForceRefresh() {
            return this.needForceRefresh;
        }

        /* renamed from: component9, reason: from getter */
        public final boolean getIsFromStagger() {
            return this.isFromStagger;
        }

        @NotNull
        public final EnterInfo copy(@NotNull String enterFeedId, @NotNull String enterId, boolean isOnFetchMsgStage, boolean hasRedDot, long enterTimestamp, boolean needChangeUrl, int coverCacheStatusCode, boolean needForceRefresh, boolean isFromStagger) {
            Intrinsics.checkNotNullParameter(enterFeedId, "enterFeedId");
            Intrinsics.checkNotNullParameter(enterId, "enterId");
            return new EnterInfo(enterFeedId, enterId, isOnFetchMsgStage, hasRedDot, enterTimestamp, needChangeUrl, coverCacheStatusCode, needForceRefresh, isFromStagger);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EnterInfo)) {
                return false;
            }
            EnterInfo enterInfo = (EnterInfo) other;
            if (Intrinsics.areEqual(this.enterFeedId, enterInfo.enterFeedId) && Intrinsics.areEqual(this.enterId, enterInfo.enterId) && this.isOnFetchMsgStage == enterInfo.isOnFetchMsgStage && this.hasRedDot == enterInfo.hasRedDot && this.enterTimestamp == enterInfo.enterTimestamp && this.needChangeUrl == enterInfo.needChangeUrl && this.coverCacheStatusCode == enterInfo.coverCacheStatusCode && this.needForceRefresh == enterInfo.needForceRefresh && this.isFromStagger == enterInfo.isFromStagger) {
                return true;
            }
            return false;
        }

        public final int getCoverCacheStatusCode() {
            return this.coverCacheStatusCode;
        }

        @NotNull
        public final String getEnterFeedId() {
            return this.enterFeedId;
        }

        @NotNull
        public final String getEnterId() {
            return this.enterId;
        }

        public final long getEnterTimestamp() {
            return this.enterTimestamp;
        }

        public final boolean getHasRedDot() {
            return this.hasRedDot;
        }

        public final boolean getNeedChangeUrl() {
            return this.needChangeUrl;
        }

        public final boolean getNeedForceRefresh() {
            return this.needForceRefresh;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((this.enterFeedId.hashCode() * 31) + this.enterId.hashCode()) * 31;
            boolean z16 = this.isOnFetchMsgStage;
            int i3 = 1;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            int i17 = (hashCode + i16) * 31;
            boolean z17 = this.hasRedDot;
            int i18 = z17;
            if (z17 != 0) {
                i18 = 1;
            }
            int a16 = (((i17 + i18) * 31) + androidx.fragment.app.a.a(this.enterTimestamp)) * 31;
            boolean z18 = this.needChangeUrl;
            int i19 = z18;
            if (z18 != 0) {
                i19 = 1;
            }
            int i26 = (((a16 + i19) * 31) + this.coverCacheStatusCode) * 31;
            boolean z19 = this.needForceRefresh;
            int i27 = z19;
            if (z19 != 0) {
                i27 = 1;
            }
            int i28 = (i26 + i27) * 31;
            boolean z26 = this.isFromStagger;
            if (!z26) {
                i3 = z26 ? 1 : 0;
            }
            return i28 + i3;
        }

        public final boolean isFromStagger() {
            return this.isFromStagger;
        }

        public final boolean isOnFetchMsgStage() {
            return this.isOnFetchMsgStage;
        }

        @NotNull
        public String toString() {
            return "EnterInfo(enterFeedId=" + this.enterFeedId + ", enterId=" + this.enterId + ", isOnFetchMsgStage=" + this.isOnFetchMsgStage + ", hasRedDot=" + this.hasRedDot + ", enterTimestamp=" + this.enterTimestamp + ", needChangeUrl=" + this.needChangeUrl + ", coverCacheStatusCode=" + this.coverCacheStatusCode + ", needForceRefresh=" + this.needForceRefresh + ", isFromStagger=" + this.isFromStagger + ')';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/qcircle/api/impl/QCirclePublicAccountTechReporterImpl$FeedExposureInfo;", "", "feedExposureTimestamp", "", "pageInitTimestamp", "timeCostFromEnterUntilInit", "timeCostFromEnterUntilExposure", "(JJJJ)V", "getFeedExposureTimestamp", "()J", "getPageInitTimestamp", "getTimeCostFromEnterUntilExposure", "getTimeCostFromEnterUntilInit", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "qcircle-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final /* data */ class FeedExposureInfo {
        private final long feedExposureTimestamp;
        private final long pageInitTimestamp;
        private final long timeCostFromEnterUntilExposure;
        private final long timeCostFromEnterUntilInit;

        public FeedExposureInfo(long j3, long j16, long j17, long j18) {
            this.feedExposureTimestamp = j3;
            this.pageInitTimestamp = j16;
            this.timeCostFromEnterUntilInit = j17;
            this.timeCostFromEnterUntilExposure = j18;
        }

        public static /* synthetic */ FeedExposureInfo copy$default(FeedExposureInfo feedExposureInfo, long j3, long j16, long j17, long j18, int i3, Object obj) {
            long j19;
            long j26;
            long j27;
            long j28;
            if ((i3 & 1) != 0) {
                j19 = feedExposureInfo.feedExposureTimestamp;
            } else {
                j19 = j3;
            }
            if ((i3 & 2) != 0) {
                j26 = feedExposureInfo.pageInitTimestamp;
            } else {
                j26 = j16;
            }
            if ((i3 & 4) != 0) {
                j27 = feedExposureInfo.timeCostFromEnterUntilInit;
            } else {
                j27 = j17;
            }
            if ((i3 & 8) != 0) {
                j28 = feedExposureInfo.timeCostFromEnterUntilExposure;
            } else {
                j28 = j18;
            }
            return feedExposureInfo.copy(j19, j26, j27, j28);
        }

        /* renamed from: component1, reason: from getter */
        public final long getFeedExposureTimestamp() {
            return this.feedExposureTimestamp;
        }

        /* renamed from: component2, reason: from getter */
        public final long getPageInitTimestamp() {
            return this.pageInitTimestamp;
        }

        /* renamed from: component3, reason: from getter */
        public final long getTimeCostFromEnterUntilInit() {
            return this.timeCostFromEnterUntilInit;
        }

        /* renamed from: component4, reason: from getter */
        public final long getTimeCostFromEnterUntilExposure() {
            return this.timeCostFromEnterUntilExposure;
        }

        @NotNull
        public final FeedExposureInfo copy(long feedExposureTimestamp, long pageInitTimestamp, long timeCostFromEnterUntilInit, long timeCostFromEnterUntilExposure) {
            return new FeedExposureInfo(feedExposureTimestamp, pageInitTimestamp, timeCostFromEnterUntilInit, timeCostFromEnterUntilExposure);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FeedExposureInfo)) {
                return false;
            }
            FeedExposureInfo feedExposureInfo = (FeedExposureInfo) other;
            if (this.feedExposureTimestamp == feedExposureInfo.feedExposureTimestamp && this.pageInitTimestamp == feedExposureInfo.pageInitTimestamp && this.timeCostFromEnterUntilInit == feedExposureInfo.timeCostFromEnterUntilInit && this.timeCostFromEnterUntilExposure == feedExposureInfo.timeCostFromEnterUntilExposure) {
                return true;
            }
            return false;
        }

        public final long getFeedExposureTimestamp() {
            return this.feedExposureTimestamp;
        }

        public final long getPageInitTimestamp() {
            return this.pageInitTimestamp;
        }

        public final long getTimeCostFromEnterUntilExposure() {
            return this.timeCostFromEnterUntilExposure;
        }

        public final long getTimeCostFromEnterUntilInit() {
            return this.timeCostFromEnterUntilInit;
        }

        public int hashCode() {
            return (((((androidx.fragment.app.a.a(this.feedExposureTimestamp) * 31) + androidx.fragment.app.a.a(this.pageInitTimestamp)) * 31) + androidx.fragment.app.a.a(this.timeCostFromEnterUntilInit)) * 31) + androidx.fragment.app.a.a(this.timeCostFromEnterUntilExposure);
        }

        @NotNull
        public String toString() {
            return "FeedExposureInfo(feedExposureTimestamp=" + this.feedExposureTimestamp + ", pageInitTimestamp=" + this.pageInitTimestamp + ", timeCostFromEnterUntilInit=" + this.timeCostFromEnterUntilInit + ", timeCostFromEnterUntilExposure=" + this.timeCostFromEnterUntilExposure + ')';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\bH\u00c6\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u0006H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/qcircle/api/impl/QCirclePublicAccountTechReporterImpl$FirstFrameExposureInfo;", "", "firstFrameExposureTimestamp", "", "timeCostFromEnterUntilExposure", "firstFrameExposureFeedId", "", "hitDownloaded", "", "(JJLjava/lang/String;Z)V", "getFirstFrameExposureFeedId", "()Ljava/lang/String;", "getFirstFrameExposureTimestamp", "()J", "getHitDownloaded", "()Z", "getTimeCostFromEnterUntilExposure", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "qcircle-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final /* data */ class FirstFrameExposureInfo {

        @NotNull
        private final String firstFrameExposureFeedId;
        private final long firstFrameExposureTimestamp;
        private final boolean hitDownloaded;
        private final long timeCostFromEnterUntilExposure;

        public FirstFrameExposureInfo(long j3, long j16, @NotNull String firstFrameExposureFeedId, boolean z16) {
            Intrinsics.checkNotNullParameter(firstFrameExposureFeedId, "firstFrameExposureFeedId");
            this.firstFrameExposureTimestamp = j3;
            this.timeCostFromEnterUntilExposure = j16;
            this.firstFrameExposureFeedId = firstFrameExposureFeedId;
            this.hitDownloaded = z16;
        }

        public static /* synthetic */ FirstFrameExposureInfo copy$default(FirstFrameExposureInfo firstFrameExposureInfo, long j3, long j16, String str, boolean z16, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                j3 = firstFrameExposureInfo.firstFrameExposureTimestamp;
            }
            long j17 = j3;
            if ((i3 & 2) != 0) {
                j16 = firstFrameExposureInfo.timeCostFromEnterUntilExposure;
            }
            long j18 = j16;
            if ((i3 & 4) != 0) {
                str = firstFrameExposureInfo.firstFrameExposureFeedId;
            }
            String str2 = str;
            if ((i3 & 8) != 0) {
                z16 = firstFrameExposureInfo.hitDownloaded;
            }
            return firstFrameExposureInfo.copy(j17, j18, str2, z16);
        }

        /* renamed from: component1, reason: from getter */
        public final long getFirstFrameExposureTimestamp() {
            return this.firstFrameExposureTimestamp;
        }

        /* renamed from: component2, reason: from getter */
        public final long getTimeCostFromEnterUntilExposure() {
            return this.timeCostFromEnterUntilExposure;
        }

        @NotNull
        /* renamed from: component3, reason: from getter */
        public final String getFirstFrameExposureFeedId() {
            return this.firstFrameExposureFeedId;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getHitDownloaded() {
            return this.hitDownloaded;
        }

        @NotNull
        public final FirstFrameExposureInfo copy(long firstFrameExposureTimestamp, long timeCostFromEnterUntilExposure, @NotNull String firstFrameExposureFeedId, boolean hitDownloaded) {
            Intrinsics.checkNotNullParameter(firstFrameExposureFeedId, "firstFrameExposureFeedId");
            return new FirstFrameExposureInfo(firstFrameExposureTimestamp, timeCostFromEnterUntilExposure, firstFrameExposureFeedId, hitDownloaded);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FirstFrameExposureInfo)) {
                return false;
            }
            FirstFrameExposureInfo firstFrameExposureInfo = (FirstFrameExposureInfo) other;
            if (this.firstFrameExposureTimestamp == firstFrameExposureInfo.firstFrameExposureTimestamp && this.timeCostFromEnterUntilExposure == firstFrameExposureInfo.timeCostFromEnterUntilExposure && Intrinsics.areEqual(this.firstFrameExposureFeedId, firstFrameExposureInfo.firstFrameExposureFeedId) && this.hitDownloaded == firstFrameExposureInfo.hitDownloaded) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String getFirstFrameExposureFeedId() {
            return this.firstFrameExposureFeedId;
        }

        public final long getFirstFrameExposureTimestamp() {
            return this.firstFrameExposureTimestamp;
        }

        public final boolean getHitDownloaded() {
            return this.hitDownloaded;
        }

        public final long getTimeCostFromEnterUntilExposure() {
            return this.timeCostFromEnterUntilExposure;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int a16 = ((((androidx.fragment.app.a.a(this.firstFrameExposureTimestamp) * 31) + androidx.fragment.app.a.a(this.timeCostFromEnterUntilExposure)) * 31) + this.firstFrameExposureFeedId.hashCode()) * 31;
            boolean z16 = this.hitDownloaded;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return a16 + i3;
        }

        @NotNull
        public String toString() {
            return "FirstFrameExposureInfo(firstFrameExposureTimestamp=" + this.firstFrameExposureTimestamp + ", timeCostFromEnterUntilExposure=" + this.timeCostFromEnterUntilExposure + ", firstFrameExposureFeedId=" + this.firstFrameExposureFeedId + ", hitDownloaded=" + this.hitDownloaded + ')';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0006H\u00c6\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0006H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/qcircle/api/impl/QCirclePublicAccountTechReporterImpl$VideoPlayerOpenInfo;", "", "videoPlayerOpenTimestamp", "", "videoPlayerOpenCost", "videoPlayerOpenFeedId", "", "(JJLjava/lang/String;)V", "getVideoPlayerOpenCost", "()J", "getVideoPlayerOpenFeedId", "()Ljava/lang/String;", "getVideoPlayerOpenTimestamp", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "qcircle-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final /* data */ class VideoPlayerOpenInfo {
        private final long videoPlayerOpenCost;

        @NotNull
        private final String videoPlayerOpenFeedId;
        private final long videoPlayerOpenTimestamp;

        public VideoPlayerOpenInfo(long j3, long j16, @NotNull String videoPlayerOpenFeedId) {
            Intrinsics.checkNotNullParameter(videoPlayerOpenFeedId, "videoPlayerOpenFeedId");
            this.videoPlayerOpenTimestamp = j3;
            this.videoPlayerOpenCost = j16;
            this.videoPlayerOpenFeedId = videoPlayerOpenFeedId;
        }

        public static /* synthetic */ VideoPlayerOpenInfo copy$default(VideoPlayerOpenInfo videoPlayerOpenInfo, long j3, long j16, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                j3 = videoPlayerOpenInfo.videoPlayerOpenTimestamp;
            }
            long j17 = j3;
            if ((i3 & 2) != 0) {
                j16 = videoPlayerOpenInfo.videoPlayerOpenCost;
            }
            long j18 = j16;
            if ((i3 & 4) != 0) {
                str = videoPlayerOpenInfo.videoPlayerOpenFeedId;
            }
            return videoPlayerOpenInfo.copy(j17, j18, str);
        }

        /* renamed from: component1, reason: from getter */
        public final long getVideoPlayerOpenTimestamp() {
            return this.videoPlayerOpenTimestamp;
        }

        /* renamed from: component2, reason: from getter */
        public final long getVideoPlayerOpenCost() {
            return this.videoPlayerOpenCost;
        }

        @NotNull
        /* renamed from: component3, reason: from getter */
        public final String getVideoPlayerOpenFeedId() {
            return this.videoPlayerOpenFeedId;
        }

        @NotNull
        public final VideoPlayerOpenInfo copy(long videoPlayerOpenTimestamp, long videoPlayerOpenCost, @NotNull String videoPlayerOpenFeedId) {
            Intrinsics.checkNotNullParameter(videoPlayerOpenFeedId, "videoPlayerOpenFeedId");
            return new VideoPlayerOpenInfo(videoPlayerOpenTimestamp, videoPlayerOpenCost, videoPlayerOpenFeedId);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VideoPlayerOpenInfo)) {
                return false;
            }
            VideoPlayerOpenInfo videoPlayerOpenInfo = (VideoPlayerOpenInfo) other;
            if (this.videoPlayerOpenTimestamp == videoPlayerOpenInfo.videoPlayerOpenTimestamp && this.videoPlayerOpenCost == videoPlayerOpenInfo.videoPlayerOpenCost && Intrinsics.areEqual(this.videoPlayerOpenFeedId, videoPlayerOpenInfo.videoPlayerOpenFeedId)) {
                return true;
            }
            return false;
        }

        public final long getVideoPlayerOpenCost() {
            return this.videoPlayerOpenCost;
        }

        @NotNull
        public final String getVideoPlayerOpenFeedId() {
            return this.videoPlayerOpenFeedId;
        }

        public final long getVideoPlayerOpenTimestamp() {
            return this.videoPlayerOpenTimestamp;
        }

        public int hashCode() {
            return (((androidx.fragment.app.a.a(this.videoPlayerOpenTimestamp) * 31) + androidx.fragment.app.a.a(this.videoPlayerOpenCost)) * 31) + this.videoPlayerOpenFeedId.hashCode();
        }

        @NotNull
        public String toString() {
            return "VideoPlayerOpenInfo(videoPlayerOpenTimestamp=" + this.videoPlayerOpenTimestamp + ", videoPlayerOpenCost=" + this.videoPlayerOpenCost + ", videoPlayerOpenFeedId=" + this.videoPlayerOpenFeedId + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J+\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000H\u0014\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "Lkotlin/reflect/KProperty;", "property", "oldValue", "newValue", "", "afterChange", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a extends ObservableProperty<RedDotMsgInfo> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QCirclePublicAccountTechReporterImpl f261712b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Object obj, QCirclePublicAccountTechReporterImpl qCirclePublicAccountTechReporterImpl) {
            super(obj);
            this.f261712b = qCirclePublicAccountTechReporterImpl;
        }

        @Override // kotlin.properties.ObservableProperty
        protected void afterChange(@NotNull KProperty<?> property, RedDotMsgInfo oldValue, RedDotMsgInfo newValue) {
            Intrinsics.checkNotNullParameter(property, "property");
            RedDotMsgInfo redDotMsgInfo = newValue;
            if (redDotMsgInfo != null) {
                this.f261712b.saveRedDotMsgInfoToCached(redDotMsgInfo);
            }
        }
    }

    public QCirclePublicAccountTechReporterImpl() {
        Delegates delegates = Delegates.INSTANCE;
        this.redDotMsgInfo = new a(getRedDotMsgInfoFromCached(), this);
        this.redDotFeedClickedTimes = -1;
    }

    private final RedDotMsgInfo getRedDotMsgInfo() {
        return (RedDotMsgInfo) this.redDotMsgInfo.getValue(this, $$delegatedProperties[0]);
    }

    private final RedDotMsgInfo getRedDotMsgInfoFromCached() {
        boolean z16;
        String h16 = k.a().h(toMMKVKey(PUBLIC_ACCOUNT_RED_DOT_INFO), "");
        if (h16 != null && h16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.i(TAG, 1, "getRedDotMsgInfoFromCached jsonStr is null or empty");
            return null;
        }
        try {
            return (RedDotMsgInfo) new Gson().fromJson(h16, RedDotMsgInfo.class);
        } catch (JsonSyntaxException e16) {
            QLog.e(TAG, 1, "getRedDotMsgInfoFromCached JsonSyntaxException", e16);
            return null;
        }
    }

    private final void report(String eventId, Map<String, ? extends Object> reportParams) {
        new xq3.b().b(eventId, reportParams);
    }

    private final void reset() {
        this.enterInfo = null;
        this.feedExposureInfo = null;
        this.coverExposureInfo = null;
        this.firstFrameExposureInfo = null;
        this.videoPlayerOpenInfo = null;
        this.pageInitTimestamp = 0L;
        this.redDotFeedClickedTimes = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void saveRedDotMsgInfoToCached(RedDotMsgInfo info) {
        QLog.i(TAG, 1, "saveRedDotMsgInfoToCached: " + info);
        k.a().p(toMMKVKey(PUBLIC_ACCOUNT_RED_DOT_INFO), new Gson().toJson(info));
    }

    private final void setRedDotMsgInfo(RedDotMsgInfo redDotMsgInfo) {
        this.redDotMsgInfo.setValue(this, $$delegatedProperties[0], redDotMsgInfo);
    }

    private final String toEnterId(String str, long j3) {
        String str2;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append(util.base64_pad_url);
        AppInterface appInterface = QCircleServiceImpl.getAppInterface();
        if (appInterface != null) {
            str2 = appInterface.getCurrentUin();
        } else {
            str2 = null;
        }
        sb5.append(str2);
        sb5.append(util.base64_pad_url);
        sb5.append(j3);
        return sb5.toString();
    }

    private final String toMMKVKey(String str) {
        String str2;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append(util.base64_pad_url);
        AppInterface appInterface = QCircleServiceImpl.getAppInterface();
        if (appInterface != null) {
            str2 = appInterface.getCurrentUin();
        } else {
            str2 = null;
        }
        sb5.append(str2);
        return sb5.toString();
    }

    private final Map<String, Object> toMap(RedDotMsgInfo redDotMsgInfo, boolean z16) {
        HashMap hashMapOf;
        Pair[] pairArr = new Pair[7];
        pairArr[0] = TuplesKt.to("push_flag", Integer.valueOf(toInt(redDotMsgInfo.isOnlinePush())));
        pairArr[1] = TuplesKt.to("recev_msg_start_up_flag", Integer.valueOf(toInt(redDotMsgInfo.isOnFetchMsgStage())));
        pairArr[2] = TuplesKt.to("preload_config_flag", Integer.valueOf(toInt(redDotMsgInfo.isPreloadEnabled())));
        pairArr[3] = TuplesKt.to("offline_preload_config_flag", Integer.valueOf(toInt(redDotMsgInfo.isOfflinePreloadEnabled())));
        Long receiveTimestamp = redDotMsgInfo.getReceiveTimestamp();
        pairArr[4] = TuplesKt.to("recev_msg_timestamp", Long.valueOf(receiveTimestamp != null ? receiveTimestamp.longValue() : 0L));
        Long playUrlTimestamp = redDotMsgInfo.getPlayUrlTimestamp();
        pairArr[5] = TuplesKt.to("play_url_timestamp_sec", Long.valueOf(playUrlTimestamp != null ? playUrlTimestamp.longValue() : 0L));
        Boolean needExchangeUrlWhenReceiveMsg = redDotMsgInfo.getNeedExchangeUrlWhenReceiveMsg();
        pairArr[6] = TuplesKt.to("exchange_url_on_recev_msg_flag", Integer.valueOf(needExchangeUrlWhenReceiveMsg != null ? toInt(needExchangeUrlWhenReceiveMsg.booleanValue()) : 0));
        hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
        if (z16) {
            hashMapOf.put("feed_id", redDotMsgInfo.getFeedId());
        }
        return hashMapOf;
    }

    static /* synthetic */ Map toMap$default(QCirclePublicAccountTechReporterImpl qCirclePublicAccountTechReporterImpl, RedDotMsgInfo redDotMsgInfo, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        return qCirclePublicAccountTechReporterImpl.toMap(redDotMsgInfo, z16);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountTechReporter
    public void onCoverExposure() {
        Map emptyMap;
        Map<String, Object> emptyMap2;
        Map<String, Object> emptyMap3;
        EnterInfo enterInfo = this.enterInfo;
        if (enterInfo == null || this.coverExposureInfo != null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        CoverExposureInfo coverExposureInfo = new CoverExposureInfo(currentTimeMillis, currentTimeMillis - enterInfo.getEnterTimestamp());
        this.coverExposureInfo = coverExposureInfo;
        RedDotMsgInfo redDotMsgInfo = getRedDotMsgInfo();
        if (redDotMsgInfo == null || (emptyMap = toMap$default(this, redDotMsgInfo, false, 1, null)) == null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
        }
        FeedExposureInfo feedExposureInfo = this.feedExposureInfo;
        if (feedExposureInfo == null || (emptyMap2 = toMap(feedExposureInfo)) == null) {
            emptyMap2 = MapsKt__MapsKt.emptyMap();
        }
        VideoPlayerOpenInfo videoPlayerOpenInfo = this.videoPlayerOpenInfo;
        if (videoPlayerOpenInfo == null || (emptyMap3 = toMap(videoPlayerOpenInfo)) == null) {
            emptyMap3 = MapsKt__MapsKt.emptyMap();
        }
        HashMap hashMap = new HashMap();
        hashMap.putAll(emptyMap);
        hashMap.putAll(toMap(enterInfo, this.redDotFeedClickedTimes));
        hashMap.putAll(emptyMap2);
        hashMap.putAll(emptyMap3);
        hashMap.putAll(toMap(coverExposureInfo));
        Unit unit = Unit.INSTANCE;
        report(EV_XSJ_PUBLIC_ACCOUNT_COVER_EXPOSURE, hashMap);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountTechReporter
    public void onEnterPage(@NotNull String enterFeedId, boolean isOnFetchMsgStage, boolean hasRedDot, boolean needChangeUrl, int coverCacheStatusCode, boolean needForceRefresh, boolean isFromStagger) {
        String str;
        Map emptyMap;
        RedDotMsgInfo redDotMsgInfo;
        Intrinsics.checkNotNullParameter(enterFeedId, "enterFeedId");
        reset();
        long currentTimeMillis = System.currentTimeMillis();
        String enterId = toEnterId(enterFeedId, currentTimeMillis);
        RedDotMsgInfo redDotMsgInfo2 = getRedDotMsgInfo();
        if (redDotMsgInfo2 != null) {
            str = redDotMsgInfo2.getFeedId();
        } else {
            str = null;
        }
        int i3 = -1;
        if (Intrinsics.areEqual(enterFeedId, str)) {
            RedDotMsgInfo redDotMsgInfo3 = getRedDotMsgInfo();
            if (redDotMsgInfo3 != null) {
                i3 = redDotMsgInfo3.getClickTimes();
            }
            int i16 = i3 + 1;
            RedDotMsgInfo redDotMsgInfo4 = getRedDotMsgInfo();
            if (redDotMsgInfo4 != null) {
                redDotMsgInfo = RedDotMsgInfo.copy$default(redDotMsgInfo4, false, null, false, false, false, i16, null, null, null, NotificationUtil.Constants.NOTIFY_ID_MSF_PUSH_AVMSG, null);
            } else {
                redDotMsgInfo = null;
            }
            setRedDotMsgInfo(redDotMsgInfo);
            this.redDotFeedClickedTimes = i16;
        } else {
            this.redDotFeedClickedTimes = -1;
        }
        EnterInfo enterInfo = new EnterInfo(enterFeedId, enterId, isOnFetchMsgStage, hasRedDot, currentTimeMillis, needChangeUrl, coverCacheStatusCode, needForceRefresh, isFromStagger);
        this.enterInfo = enterInfo;
        RedDotMsgInfo redDotMsgInfo5 = getRedDotMsgInfo();
        if (redDotMsgInfo5 == null || (emptyMap = toMap$default(this, redDotMsgInfo5, false, 1, null)) == null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
        }
        HashMap hashMap = new HashMap();
        hashMap.putAll(emptyMap);
        hashMap.putAll(toMap(enterInfo, this.redDotFeedClickedTimes));
        Unit unit = Unit.INSTANCE;
        report(EV_XSJ_PUBLIC_ACCOUNT_START, hashMap);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountTechReporter
    public void onFeedExposure() {
        Map emptyMap;
        EnterInfo enterInfo = this.enterInfo;
        if (enterInfo == null || this.feedExposureInfo != null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        FeedExposureInfo feedExposureInfo = new FeedExposureInfo(currentTimeMillis, this.pageInitTimestamp, this.pageInitTimestamp - enterInfo.getEnterTimestamp(), currentTimeMillis - enterInfo.getEnterTimestamp());
        this.feedExposureInfo = feedExposureInfo;
        RedDotMsgInfo redDotMsgInfo = getRedDotMsgInfo();
        if (redDotMsgInfo == null || (emptyMap = toMap$default(this, redDotMsgInfo, false, 1, null)) == null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
        }
        HashMap hashMap = new HashMap();
        hashMap.putAll(emptyMap);
        hashMap.putAll(toMap(enterInfo, this.redDotFeedClickedTimes));
        hashMap.putAll(toMap(feedExposureInfo));
        Unit unit = Unit.INSTANCE;
        report(EV_XSJ_PUBLIC_ACCOUNT_FEED_EXPOSURE, hashMap);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountTechReporter
    public void onPageInit() {
        this.pageInitTimestamp = System.currentTimeMillis();
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountTechReporter
    public void onReceiveMsg(@NotNull String feedId, boolean isNowOnline, boolean isOnFetchMsgStage, boolean isPreloadEnabled, boolean isOfflinePreloadEnabled, long playUrlTimestamp, boolean needExchangeUrlWhenReceiveMsg) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        RedDotMsgInfo redDotMsgInfo = new RedDotMsgInfo(isNowOnline, feedId, isOnFetchMsgStage, isPreloadEnabled, isOfflinePreloadEnabled, -1, Long.valueOf(System.currentTimeMillis()), Long.valueOf(playUrlTimestamp), Boolean.valueOf(needExchangeUrlWhenReceiveMsg));
        setRedDotMsgInfo(redDotMsgInfo);
        report(EV_XSJ_PUBLIC_ACCOUNT_RECEIVE_MSG, toMap(redDotMsgInfo, true));
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountTechReporter
    public void onVideoPlayerOpen(@NotNull String feedId) {
        boolean startsWith$default;
        Map emptyMap;
        Map<String, Object> emptyMap2;
        String feedId2 = feedId;
        Intrinsics.checkNotNullParameter(feedId2, "feedId");
        EnterInfo enterInfo = this.enterInfo;
        if (enterInfo == null || this.videoPlayerOpenInfo != null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long enterTimestamp = currentTimeMillis - enterInfo.getEnterTimestamp();
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(feedId2, "share_fake_", false, 2, null);
        if (startsWith$default) {
            feedId2 = StringsKt__StringsJVMKt.replace$default(feedId, "share_fake_", "", false, 4, (Object) null);
        }
        VideoPlayerOpenInfo videoPlayerOpenInfo = new VideoPlayerOpenInfo(currentTimeMillis, enterTimestamp, feedId2);
        this.videoPlayerOpenInfo = videoPlayerOpenInfo;
        RedDotMsgInfo redDotMsgInfo = getRedDotMsgInfo();
        if (redDotMsgInfo == null || (emptyMap = toMap$default(this, redDotMsgInfo, false, 1, null)) == null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
        }
        FeedExposureInfo feedExposureInfo = this.feedExposureInfo;
        if (feedExposureInfo == null || (emptyMap2 = toMap(feedExposureInfo)) == null) {
            emptyMap2 = MapsKt__MapsKt.emptyMap();
        }
        HashMap hashMap = new HashMap();
        hashMap.putAll(emptyMap);
        hashMap.putAll(toMap(enterInfo, this.redDotFeedClickedTimes));
        hashMap.putAll(emptyMap2);
        hashMap.putAll(toMap(videoPlayerOpenInfo));
        Unit unit = Unit.INSTANCE;
        report(EV_XSJ_PUBLIC_ACCOUNT_VIDEO_PLAYER_OPEN, hashMap);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountTechReporter
    public void onVideoPlayerPrepared(@NotNull String feedId, boolean hitDownloaded) {
        boolean startsWith$default;
        Map emptyMap;
        Map<String, Object> emptyMap2;
        Map<String, Object> emptyMap3;
        Map<String, Object> emptyMap4;
        String feedId2 = feedId;
        Intrinsics.checkNotNullParameter(feedId2, "feedId");
        EnterInfo enterInfo = this.enterInfo;
        if (enterInfo == null || this.firstFrameExposureInfo != null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long enterTimestamp = currentTimeMillis - enterInfo.getEnterTimestamp();
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(feedId2, "share_fake_", false, 2, null);
        if (startsWith$default) {
            feedId2 = StringsKt__StringsJVMKt.replace$default(feedId, "share_fake_", "", false, 4, (Object) null);
        }
        FirstFrameExposureInfo firstFrameExposureInfo = new FirstFrameExposureInfo(currentTimeMillis, enterTimestamp, feedId2, hitDownloaded);
        this.firstFrameExposureInfo = firstFrameExposureInfo;
        RedDotMsgInfo redDotMsgInfo = getRedDotMsgInfo();
        if (redDotMsgInfo == null || (emptyMap = toMap$default(this, redDotMsgInfo, false, 1, null)) == null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
        }
        FeedExposureInfo feedExposureInfo = this.feedExposureInfo;
        if (feedExposureInfo == null || (emptyMap2 = toMap(feedExposureInfo)) == null) {
            emptyMap2 = MapsKt__MapsKt.emptyMap();
        }
        VideoPlayerOpenInfo videoPlayerOpenInfo = this.videoPlayerOpenInfo;
        if (videoPlayerOpenInfo == null || (emptyMap3 = toMap(videoPlayerOpenInfo)) == null) {
            emptyMap3 = MapsKt__MapsKt.emptyMap();
        }
        CoverExposureInfo coverExposureInfo = this.coverExposureInfo;
        if (coverExposureInfo == null || (emptyMap4 = toMap(coverExposureInfo)) == null) {
            emptyMap4 = MapsKt__MapsKt.emptyMap();
        }
        HashMap hashMap = new HashMap();
        hashMap.putAll(emptyMap);
        hashMap.putAll(toMap(enterInfo, this.redDotFeedClickedTimes));
        hashMap.putAll(emptyMap2);
        hashMap.putAll(emptyMap3);
        hashMap.putAll(emptyMap4);
        hashMap.putAll(toMap(firstFrameExposureInfo));
        Unit unit = Unit.INSTANCE;
        report(EV_XSJ_PUBLIC_ACCOUNT_FRAME_EXPOSURE, hashMap);
        reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u001f\b\u0082\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\nH\u00c6\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0019J\u0010\u0010#\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0019J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0016Jn\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010)\u001a\u00020\nH\u00d6\u0001J\t\u0010*\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0014R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\r\u001a\u0004\u0018\u00010\f\u00a2\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001b\u0010\u0019\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/qcircle/api/impl/QCirclePublicAccountTechReporterImpl$RedDotMsgInfo;", "", "isOnlinePush", "", "feedId", "", "isOnFetchMsgStage", "isPreloadEnabled", "isOfflinePreloadEnabled", "clickTimes", "", "receiveTimestamp", "", "playUrlTimestamp", "needExchangeUrlWhenReceiveMsg", "(ZLjava/lang/String;ZZZILjava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;)V", "getClickTimes", "()I", "getFeedId", "()Ljava/lang/String;", "()Z", "getNeedExchangeUrlWhenReceiveMsg", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPlayUrlTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getReceiveTimestamp", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ZLjava/lang/String;ZZZILjava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;)Lcom/tencent/mobileqq/qcircle/api/impl/QCirclePublicAccountTechReporterImpl$RedDotMsgInfo;", "equals", "other", "hashCode", "toString", "qcircle-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final /* data */ class RedDotMsgInfo {
        private final int clickTimes;

        @NotNull
        private final String feedId;
        private final boolean isOfflinePreloadEnabled;
        private final boolean isOnFetchMsgStage;
        private final boolean isOnlinePush;
        private final boolean isPreloadEnabled;

        @Nullable
        private final Boolean needExchangeUrlWhenReceiveMsg;

        @Nullable
        private final Long playUrlTimestamp;

        @Nullable
        private final Long receiveTimestamp;

        public RedDotMsgInfo(boolean z16, @NotNull String feedId, boolean z17, boolean z18, boolean z19, int i3, @Nullable Long l3, @Nullable Long l16, @Nullable Boolean bool) {
            Intrinsics.checkNotNullParameter(feedId, "feedId");
            this.isOnlinePush = z16;
            this.feedId = feedId;
            this.isOnFetchMsgStage = z17;
            this.isPreloadEnabled = z18;
            this.isOfflinePreloadEnabled = z19;
            this.clickTimes = i3;
            this.receiveTimestamp = l3;
            this.playUrlTimestamp = l16;
            this.needExchangeUrlWhenReceiveMsg = bool;
        }

        public static /* synthetic */ RedDotMsgInfo copy$default(RedDotMsgInfo redDotMsgInfo, boolean z16, String str, boolean z17, boolean z18, boolean z19, int i3, Long l3, Long l16, Boolean bool, int i16, Object obj) {
            return redDotMsgInfo.copy((i16 & 1) != 0 ? redDotMsgInfo.isOnlinePush : z16, (i16 & 2) != 0 ? redDotMsgInfo.feedId : str, (i16 & 4) != 0 ? redDotMsgInfo.isOnFetchMsgStage : z17, (i16 & 8) != 0 ? redDotMsgInfo.isPreloadEnabled : z18, (i16 & 16) != 0 ? redDotMsgInfo.isOfflinePreloadEnabled : z19, (i16 & 32) != 0 ? redDotMsgInfo.clickTimes : i3, (i16 & 64) != 0 ? redDotMsgInfo.receiveTimestamp : l3, (i16 & 128) != 0 ? redDotMsgInfo.playUrlTimestamp : l16, (i16 & 256) != 0 ? redDotMsgInfo.needExchangeUrlWhenReceiveMsg : bool);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsOnlinePush() {
            return this.isOnlinePush;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getFeedId() {
            return this.feedId;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsOnFetchMsgStage() {
            return this.isOnFetchMsgStage;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsPreloadEnabled() {
            return this.isPreloadEnabled;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getIsOfflinePreloadEnabled() {
            return this.isOfflinePreloadEnabled;
        }

        /* renamed from: component6, reason: from getter */
        public final int getClickTimes() {
            return this.clickTimes;
        }

        @Nullable
        /* renamed from: component7, reason: from getter */
        public final Long getReceiveTimestamp() {
            return this.receiveTimestamp;
        }

        @Nullable
        /* renamed from: component8, reason: from getter */
        public final Long getPlayUrlTimestamp() {
            return this.playUrlTimestamp;
        }

        @Nullable
        /* renamed from: component9, reason: from getter */
        public final Boolean getNeedExchangeUrlWhenReceiveMsg() {
            return this.needExchangeUrlWhenReceiveMsg;
        }

        @NotNull
        public final RedDotMsgInfo copy(boolean isOnlinePush, @NotNull String feedId, boolean isOnFetchMsgStage, boolean isPreloadEnabled, boolean isOfflinePreloadEnabled, int clickTimes, @Nullable Long receiveTimestamp, @Nullable Long playUrlTimestamp, @Nullable Boolean needExchangeUrlWhenReceiveMsg) {
            Intrinsics.checkNotNullParameter(feedId, "feedId");
            return new RedDotMsgInfo(isOnlinePush, feedId, isOnFetchMsgStage, isPreloadEnabled, isOfflinePreloadEnabled, clickTimes, receiveTimestamp, playUrlTimestamp, needExchangeUrlWhenReceiveMsg);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RedDotMsgInfo)) {
                return false;
            }
            RedDotMsgInfo redDotMsgInfo = (RedDotMsgInfo) other;
            if (this.isOnlinePush == redDotMsgInfo.isOnlinePush && Intrinsics.areEqual(this.feedId, redDotMsgInfo.feedId) && this.isOnFetchMsgStage == redDotMsgInfo.isOnFetchMsgStage && this.isPreloadEnabled == redDotMsgInfo.isPreloadEnabled && this.isOfflinePreloadEnabled == redDotMsgInfo.isOfflinePreloadEnabled && this.clickTimes == redDotMsgInfo.clickTimes && Intrinsics.areEqual(this.receiveTimestamp, redDotMsgInfo.receiveTimestamp) && Intrinsics.areEqual(this.playUrlTimestamp, redDotMsgInfo.playUrlTimestamp) && Intrinsics.areEqual(this.needExchangeUrlWhenReceiveMsg, redDotMsgInfo.needExchangeUrlWhenReceiveMsg)) {
                return true;
            }
            return false;
        }

        public final int getClickTimes() {
            return this.clickTimes;
        }

        @NotNull
        public final String getFeedId() {
            return this.feedId;
        }

        @Nullable
        public final Boolean getNeedExchangeUrlWhenReceiveMsg() {
            return this.needExchangeUrlWhenReceiveMsg;
        }

        @Nullable
        public final Long getPlayUrlTimestamp() {
            return this.playUrlTimestamp;
        }

        @Nullable
        public final Long getReceiveTimestamp() {
            return this.receiveTimestamp;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v18 */
        /* JADX WARN: Type inference failed for: r0v19 */
        /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
        public int hashCode() {
            int hashCode;
            int hashCode2;
            boolean z16 = this.isOnlinePush;
            int i3 = 1;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int hashCode3 = ((r06 * 31) + this.feedId.hashCode()) * 31;
            ?? r26 = this.isOnFetchMsgStage;
            int i16 = r26;
            if (r26 != 0) {
                i16 = 1;
            }
            int i17 = (hashCode3 + i16) * 31;
            ?? r27 = this.isPreloadEnabled;
            int i18 = r27;
            if (r27 != 0) {
                i18 = 1;
            }
            int i19 = (i17 + i18) * 31;
            boolean z17 = this.isOfflinePreloadEnabled;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            int i26 = (((i19 + i3) * 31) + this.clickTimes) * 31;
            Long l3 = this.receiveTimestamp;
            int i27 = 0;
            if (l3 == null) {
                hashCode = 0;
            } else {
                hashCode = l3.hashCode();
            }
            int i28 = (i26 + hashCode) * 31;
            Long l16 = this.playUrlTimestamp;
            if (l16 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = l16.hashCode();
            }
            int i29 = (i28 + hashCode2) * 31;
            Boolean bool = this.needExchangeUrlWhenReceiveMsg;
            if (bool != null) {
                i27 = bool.hashCode();
            }
            return i29 + i27;
        }

        public final boolean isOfflinePreloadEnabled() {
            return this.isOfflinePreloadEnabled;
        }

        public final boolean isOnFetchMsgStage() {
            return this.isOnFetchMsgStage;
        }

        public final boolean isOnlinePush() {
            return this.isOnlinePush;
        }

        public final boolean isPreloadEnabled() {
            return this.isPreloadEnabled;
        }

        @NotNull
        public String toString() {
            return "RedDotMsgInfo(isOnlinePush=" + this.isOnlinePush + ", feedId=" + this.feedId + ", isOnFetchMsgStage=" + this.isOnFetchMsgStage + ", isPreloadEnabled=" + this.isPreloadEnabled + ", isOfflinePreloadEnabled=" + this.isOfflinePreloadEnabled + ", clickTimes=" + this.clickTimes + ", receiveTimestamp=" + this.receiveTimestamp + ", playUrlTimestamp=" + this.playUrlTimestamp + ", needExchangeUrlWhenReceiveMsg=" + this.needExchangeUrlWhenReceiveMsg + ')';
        }

        public /* synthetic */ RedDotMsgInfo(boolean z16, String str, boolean z17, boolean z18, boolean z19, int i3, Long l3, Long l16, Boolean bool, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(z16, str, z17, z18, z19, i3, (i16 & 64) != 0 ? 0L : l3, (i16 & 128) != 0 ? 0L : l16, (i16 & 256) != 0 ? Boolean.FALSE : bool);
        }
    }

    private final Map<String, Object> toMap(EnterInfo enterInfo, int i3) {
        HashMap hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("feed_id", enterInfo.getEnterFeedId()), TuplesKt.to("enter_id", enterInfo.getEnterId()), TuplesKt.to("click_start_up_flag", Integer.valueOf(toInt(enterInfo.isOnFetchMsgStage()))), TuplesKt.to("red_dot_flag", Integer.valueOf(toInt(enterInfo.getHasRedDot()))), TuplesKt.to("click_timestamp", Long.valueOf(enterInfo.getEnterTimestamp())), TuplesKt.to("exchange_url_flag", Integer.valueOf(toInt(enterInfo.getNeedChangeUrl()))), TuplesKt.to("enter_frequency", Integer.valueOf(i3)), TuplesKt.to("cover_exist_flag", Integer.valueOf(enterInfo.getCoverCacheStatusCode())), TuplesKt.to("force_refresh_flag", Integer.valueOf(toInt(enterInfo.getNeedForceRefresh()))), TuplesKt.to("is_from_stagger", Integer.valueOf(toInt(enterInfo.isFromStagger()))));
        return hashMapOf;
    }

    private final Map<String, Object> toMap(FeedExposureInfo feedExposureInfo) {
        HashMap hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("page_init_timestamp", Long.valueOf(feedExposureInfo.getPageInitTimestamp())), TuplesKt.to("page_init_cost", Long.valueOf(feedExposureInfo.getTimeCostFromEnterUntilInit())), TuplesKt.to("feed_exposure_timestamp", Long.valueOf(feedExposureInfo.getFeedExposureTimestamp())), TuplesKt.to("feed_exposure_cost", Long.valueOf(feedExposureInfo.getTimeCostFromEnterUntilExposure())));
        return hashMapOf;
    }

    private final Map<String, Object> toMap(VideoPlayerOpenInfo videoPlayerOpenInfo) {
        HashMap hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("video_player_open_timestamp", Long.valueOf(videoPlayerOpenInfo.getVideoPlayerOpenTimestamp())), TuplesKt.to("video_player_open_cost", Long.valueOf(videoPlayerOpenInfo.getVideoPlayerOpenCost())), TuplesKt.to("video_player_open_feed_id", videoPlayerOpenInfo.getVideoPlayerOpenFeedId()));
        return hashMapOf;
    }

    private final int toInt(boolean z16) {
        return z16 ? 1 : 0;
    }

    private final Map<String, Object> toMap(CoverExposureInfo coverExposureInfo) {
        HashMap hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("cover_exposure_timestamp", Long.valueOf(coverExposureInfo.getCoverExposureTimestamp())), TuplesKt.to("cover_exposure_cost", Long.valueOf(coverExposureInfo.getTimeCostFromEnterUntilExposure())));
        return hashMapOf;
    }

    private final Map<String, Object> toMap(FirstFrameExposureInfo firstFrameExposureInfo) {
        HashMap hashMapOf;
        Pair[] pairArr = new Pair[4];
        pairArr[0] = TuplesKt.to("frame_exposure_timestamp", Long.valueOf(firstFrameExposureInfo.getFirstFrameExposureTimestamp()));
        pairArr[1] = TuplesKt.to("frame_exposure_cost", Long.valueOf(firstFrameExposureInfo.getTimeCostFromEnterUntilExposure()));
        pairArr[2] = TuplesKt.to("frame_exposure_feed_id", firstFrameExposureInfo.getFirstFrameExposureFeedId());
        pairArr[3] = TuplesKt.to("video_exist_flag", Integer.valueOf(firstFrameExposureInfo.getHitDownloaded() ? 2 : 1));
        hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
        return hashMapOf;
    }
}
