package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.ad.QFSPublicAccountStaggeredAdItemView;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleFeedBase$StReportInfoForClient;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 -2\u00020\u0001:\u000278B\u0007\u00a2\u0006\u0004\b5\u00106J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J*\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u000e\u0010\u000e\u001a\u00020\r*\u0004\u0018\u00010\fH\u0002J\u000e\u0010\u000f\u001a\u00020\r*\u0004\u0018\u00010\fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0016\u001a\u00020\u0015*\u00060\u0013j\u0002`\u0014H\u0002J\u0010\u0010\u0017\u001a\u00020\u0015*\u00060\u0013j\u0002`\u0014H\u0002J\u0010\u0010\u0018\u001a\u00020\u0002*\u00060\u0013j\u0002`\u0014H\u0002J\b\u0010\u0019\u001a\u00020\u0002H\u0002J.\u0010\u001e\u001a\u0004\u0018\u00010\u001b*\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001c\u001a\u00020\u00042\n\u0010\u001d\u001a\u00060\u0013j\u0002`\u0014H\u0002J\u0010\u0010\u001f\u001a\u00020\u0004*\u00060\u0013j\u0002`\u0014H\u0002J\u0010\u0010 \u001a\u00020\u001b*\u00060\u0013j\u0002`\u0014H\u0002J\f\u0010!\u001a\u00020\u0002*\u00020\u001bH\u0002J\f\u0010\"\u001a\u00020\u0002*\u00020\u001bH\u0002JL\u0010*\u001a\u00020\u00022\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010%\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0015H\u0016J\u0010\u0010,\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\fH\u0016J\b\u0010-\u001a\u00020\u0002H\u0016J\b\u0010.\u001a\u00020\u0002H\u0016J\u0010\u0010/\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\fH\u0016J\b\u00100\u001a\u00020\u0002H\u0016J\b\u00101\u001a\u00020\u0002H\u0016R \u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001b028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00103\u00a8\u00069"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/report/c;", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/report/q;", "", DomainData.DOMAIN_NAME, "", "firstVisiblePos", "lastVisiblePos", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "layoutManager", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "eventType", "t", "Landroid/view/View;", "", ReportConstant.COSTREPORT_PREFIX, "r", "", "msg", "o", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/ad/QFSPublicAccountStaggeredAdItemView;", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/report/AdCard;", "", BdhLogUtil.LogTag.Tag_Conn, "B", "w", "p", "", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/report/c$a;", com.tencent.luggage.wxa.c8.c.G, IndividuationUrlHelper.UrlId.CARD_HOME, HippyTKDListViewAdapter.X, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "newState", "manager", "firstCompletelyVisible", "lastCompletelyVisible", "isScrollUp", "g", "view", "i", "f", "d", "j", "c", "e", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "startBaseExposurePosToInfoMap", "<init>", "()V", "a", "b", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class c extends q {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<Integer, CardExposureInfo> startBaseExposurePosToInfoMap = new ConcurrentHashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001e\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u008b\u0001\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u0002H\u00c6\u0001J\t\u0010\u0016\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0004\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0005\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u001e\u0010\u001cR\u0017\u0010\u0007\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010\t\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010\n\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b'\u0010 \u001a\u0004\b(\u0010\"R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010 \u001a\u0004\b)\u0010\"R\u0017\u0010\f\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b(\u0010 \u001a\u0004\b*\u0010\"R\u0017\u0010\u000e\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b#\u0010-R\u0017\u0010\u000f\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b)\u0010,\u001a\u0004\b'\u0010-R\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b%\u0010\u001a\u001a\u0004\b+\u0010\u001cR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b*\u0010\u001a\u001a\u0004\b.\u0010\u001cR\u0017\u0010\u0013\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b\u001f\u00101R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b2\u0010\u001a\u001a\u0004\b3\u0010\u001c\u00a8\u00066"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/report/c$a;", "", "", "toString", "feedId", "posterId", "", MessageForQCircleFeed.MSG_QCIRCLE_FEED_KEY_LIKE_COUNT, "", "startTimeMs", com.tencent.luggage.wxa.c8.c.G, "spanIndex", "videoType", "", "cardHeight", "exposureMaxHeight", "recommendReason", "sealTransfer", "", "busiReport", "dtTransfer", "a", "hashCode", "other", "", "equals", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "b", "getPosterId", "c", "I", "getLikeCount", "()I", "d", "J", "j", "()J", "e", "g", "i", "k", tl.h.F, UserInfo.SEX_FEMALE, "()F", "getSealTransfer", "l", "[B", "()[B", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getDtTransfer", "<init>", "(Ljava/lang/String;Ljava/lang/String;IJIIIFFLjava/lang/String;Ljava/lang/String;[BLjava/lang/String;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.c$a, reason: from toString */
    /* loaded from: classes4.dex */
    public static final /* data */ class CardExposureInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String feedId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String posterId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final int likeCount;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final long startTimeMs;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final int pos;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final int spanIndex;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private final int videoType;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        private final float cardHeight;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        private final float exposureMaxHeight;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String recommendReason;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String sealTransfer;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final byte[] busiReport;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String dtTransfer;

        public CardExposureInfo(@NotNull String feedId, @NotNull String posterId, int i3, long j3, int i16, int i17, int i18, float f16, float f17, @NotNull String recommendReason, @NotNull String sealTransfer, @NotNull byte[] busiReport, @NotNull String dtTransfer) {
            Intrinsics.checkNotNullParameter(feedId, "feedId");
            Intrinsics.checkNotNullParameter(posterId, "posterId");
            Intrinsics.checkNotNullParameter(recommendReason, "recommendReason");
            Intrinsics.checkNotNullParameter(sealTransfer, "sealTransfer");
            Intrinsics.checkNotNullParameter(busiReport, "busiReport");
            Intrinsics.checkNotNullParameter(dtTransfer, "dtTransfer");
            this.feedId = feedId;
            this.posterId = posterId;
            this.likeCount = i3;
            this.startTimeMs = j3;
            this.pos = i16;
            this.spanIndex = i17;
            this.videoType = i18;
            this.cardHeight = f16;
            this.exposureMaxHeight = f17;
            this.recommendReason = recommendReason;
            this.sealTransfer = sealTransfer;
            this.busiReport = busiReport;
            this.dtTransfer = dtTransfer;
        }

        public static /* synthetic */ CardExposureInfo b(CardExposureInfo cardExposureInfo, String str, String str2, int i3, long j3, int i16, int i17, int i18, float f16, float f17, String str3, String str4, byte[] bArr, String str5, int i19, Object obj) {
            return cardExposureInfo.a((i19 & 1) != 0 ? cardExposureInfo.feedId : str, (i19 & 2) != 0 ? cardExposureInfo.posterId : str2, (i19 & 4) != 0 ? cardExposureInfo.likeCount : i3, (i19 & 8) != 0 ? cardExposureInfo.startTimeMs : j3, (i19 & 16) != 0 ? cardExposureInfo.pos : i16, (i19 & 32) != 0 ? cardExposureInfo.spanIndex : i17, (i19 & 64) != 0 ? cardExposureInfo.videoType : i18, (i19 & 128) != 0 ? cardExposureInfo.cardHeight : f16, (i19 & 256) != 0 ? cardExposureInfo.exposureMaxHeight : f17, (i19 & 512) != 0 ? cardExposureInfo.recommendReason : str3, (i19 & 1024) != 0 ? cardExposureInfo.sealTransfer : str4, (i19 & 2048) != 0 ? cardExposureInfo.busiReport : bArr, (i19 & 4096) != 0 ? cardExposureInfo.dtTransfer : str5);
        }

        @NotNull
        public final CardExposureInfo a(@NotNull String feedId, @NotNull String posterId, int likeCount, long startTimeMs, int pos, int spanIndex, int videoType, float cardHeight, float exposureMaxHeight, @NotNull String recommendReason, @NotNull String sealTransfer, @NotNull byte[] busiReport, @NotNull String dtTransfer) {
            Intrinsics.checkNotNullParameter(feedId, "feedId");
            Intrinsics.checkNotNullParameter(posterId, "posterId");
            Intrinsics.checkNotNullParameter(recommendReason, "recommendReason");
            Intrinsics.checkNotNullParameter(sealTransfer, "sealTransfer");
            Intrinsics.checkNotNullParameter(busiReport, "busiReport");
            Intrinsics.checkNotNullParameter(dtTransfer, "dtTransfer");
            return new CardExposureInfo(feedId, posterId, likeCount, startTimeMs, pos, spanIndex, videoType, cardHeight, exposureMaxHeight, recommendReason, sealTransfer, busiReport, dtTransfer);
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final byte[] getBusiReport() {
            return this.busiReport;
        }

        /* renamed from: d, reason: from getter */
        public final float getCardHeight() {
            return this.cardHeight;
        }

        /* renamed from: e, reason: from getter */
        public final float getExposureMaxHeight() {
            return this.exposureMaxHeight;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CardExposureInfo)) {
                return false;
            }
            CardExposureInfo cardExposureInfo = (CardExposureInfo) other;
            if (Intrinsics.areEqual(this.feedId, cardExposureInfo.feedId) && Intrinsics.areEqual(this.posterId, cardExposureInfo.posterId) && this.likeCount == cardExposureInfo.likeCount && this.startTimeMs == cardExposureInfo.startTimeMs && this.pos == cardExposureInfo.pos && this.spanIndex == cardExposureInfo.spanIndex && this.videoType == cardExposureInfo.videoType && Float.compare(this.cardHeight, cardExposureInfo.cardHeight) == 0 && Float.compare(this.exposureMaxHeight, cardExposureInfo.exposureMaxHeight) == 0 && Intrinsics.areEqual(this.recommendReason, cardExposureInfo.recommendReason) && Intrinsics.areEqual(this.sealTransfer, cardExposureInfo.sealTransfer) && Intrinsics.areEqual(this.busiReport, cardExposureInfo.busiReport) && Intrinsics.areEqual(this.dtTransfer, cardExposureInfo.dtTransfer)) {
                return true;
            }
            return false;
        }

        @NotNull
        /* renamed from: f, reason: from getter */
        public final String getFeedId() {
            return this.feedId;
        }

        /* renamed from: g, reason: from getter */
        public final int getPos() {
            return this.pos;
        }

        @NotNull
        /* renamed from: h, reason: from getter */
        public final String getRecommendReason() {
            return this.recommendReason;
        }

        public int hashCode() {
            return (((((((((((((((((((((((this.feedId.hashCode() * 31) + this.posterId.hashCode()) * 31) + this.likeCount) * 31) + androidx.fragment.app.a.a(this.startTimeMs)) * 31) + this.pos) * 31) + this.spanIndex) * 31) + this.videoType) * 31) + Float.floatToIntBits(this.cardHeight)) * 31) + Float.floatToIntBits(this.exposureMaxHeight)) * 31) + this.recommendReason.hashCode()) * 31) + this.sealTransfer.hashCode()) * 31) + Arrays.hashCode(this.busiReport)) * 31) + this.dtTransfer.hashCode();
        }

        /* renamed from: i, reason: from getter */
        public final int getSpanIndex() {
            return this.spanIndex;
        }

        /* renamed from: j, reason: from getter */
        public final long getStartTimeMs() {
            return this.startTimeMs;
        }

        /* renamed from: k, reason: from getter */
        public final int getVideoType() {
            return this.videoType;
        }

        @NotNull
        public String toString() {
            return "CardExposureInfo(feedId=" + this.feedId + ",startTimeMs=" + this.startTimeMs + ", pos=" + this.pos + ", spanIndex=" + this.spanIndex + ", cardHeight=" + this.cardHeight + ", exposureMaxHeight=" + this.exposureMaxHeight + ", recommendReason=" + this.recommendReason + ", )";
        }
    }

    private final CardExposureInfo A(QFSPublicAccountStaggeredAdItemView qFSPublicAccountStaggeredAdItemView) {
        Object obj;
        QQCircleFeedBase$StReportInfoForClient qQCircleFeedBase$StReportInfoForClient;
        String str;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        PBStringField pBStringField;
        e30.b data = qFSPublicAccountStaggeredAdItemView.getData();
        Integer num = null;
        if (data != null) {
            obj = data.b("DITTO_REPORT_INFO_FOR_CLIENT");
        } else {
            obj = null;
        }
        if (obj instanceof QQCircleFeedBase$StReportInfoForClient) {
            qQCircleFeedBase$StReportInfoForClient = (QQCircleFeedBase$StReportInfoForClient) obj;
        } else {
            qQCircleFeedBase$StReportInfoForClient = null;
        }
        if (qQCircleFeedBase$StReportInfoForClient != null && (pBStringField = qQCircleFeedBase$StReportInfoForClient.datongJsonData) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        String str2 = str;
        e30.b data2 = qFSPublicAccountStaggeredAdItemView.getData();
        if (data2 != null) {
            feedCloudMeta$StFeed = data2.g();
        } else {
            feedCloudMeta$StFeed = null;
        }
        if (feedCloudMeta$StFeed == null) {
            feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
        }
        String str3 = feedCloudMeta$StFeed.f398449id.get();
        String str4 = feedCloudMeta$StFeed.poster.f398463id.get();
        int i3 = feedCloudMeta$StFeed.likeInfo.count.get();
        long currentTimeMillis = System.currentTimeMillis();
        int dataPosInList = qFSPublicAccountStaggeredAdItemView.getDataPosInList() + 1;
        int q16 = q(qFSPublicAccountStaggeredAdItemView) + 1;
        float height = qFSPublicAccountStaggeredAdItemView.getHeight();
        com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.ad.h hVar = com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.ad.h.f86763a;
        GdtAd z06 = qFSPublicAccountStaggeredAdItemView.z0();
        if (z06 != null) {
            num = Integer.valueOf(z06.getInnerShowType());
        }
        int b16 = hVar.b(num);
        float r16 = r(qFSPublicAccountStaggeredAdItemView);
        String str5 = feedCloudMeta$StFeed.recomInfo.recomReasonV2.recomReason.get();
        String str6 = feedCloudMeta$StFeed.recomInfo.recomTrace.get();
        byte[] byteArray = feedCloudMeta$StFeed.busiReport.get().toByteArray();
        Intrinsics.checkNotNullExpressionValue(str3, "get()");
        Intrinsics.checkNotNullExpressionValue(str4, "get()");
        Intrinsics.checkNotNullExpressionValue(str5, "get()");
        Intrinsics.checkNotNullExpressionValue(str6, "get()");
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray()");
        return new CardExposureInfo(str3, str4, i3, currentTimeMillis, dataPosInList, q16, b16, height, r16, str5, str6, byteArray, str2);
    }

    private final boolean B(QFSPublicAccountStaggeredAdItemView qFSPublicAccountStaggeredAdItemView) {
        CardExposureInfo remove = this.startBaseExposurePosToInfoMap.remove(Integer.valueOf(qFSPublicAccountStaggeredAdItemView.getDataPosInList()));
        if (remove != null) {
            y(remove);
            return true;
        }
        return false;
    }

    private final boolean C(QFSPublicAccountStaggeredAdItemView qFSPublicAccountStaggeredAdItemView) {
        CardExposureInfo x16 = x(this.startBaseExposurePosToInfoMap, qFSPublicAccountStaggeredAdItemView.getDataPosInList(), qFSPublicAccountStaggeredAdItemView);
        if (x16 != null) {
            z(x16);
        }
        if (x16 != null) {
            return true;
        }
        return false;
    }

    private final void m(int firstVisiblePos, int lastVisiblePos, RecyclerView.LayoutManager layoutManager) {
        View view;
        if (firstVisiblePos > lastVisiblePos) {
            QLog.e("QFSPublicAccountStaggeredAdExposureReporter", 1, "firstVisiblePos=" + firstVisiblePos + " larger than lastVisiblePos=$" + lastVisiblePos);
            return;
        }
        if (firstVisiblePos > lastVisiblePos) {
            return;
        }
        while (true) {
            QFSPublicAccountStaggeredAdItemView qFSPublicAccountStaggeredAdItemView = null;
            if (layoutManager != null) {
                view = layoutManager.findViewByPosition(firstVisiblePos);
            } else {
                view = null;
            }
            if (view instanceof QFSPublicAccountStaggeredAdItemView) {
                qFSPublicAccountStaggeredAdItemView = (QFSPublicAccountStaggeredAdItemView) view;
            }
            if (qFSPublicAccountStaggeredAdItemView != null) {
                float s16 = s(qFSPublicAccountStaggeredAdItemView);
                o("card percent on scroll end, pos=" + firstVisiblePos + ", " + s16);
                qFSPublicAccountStaggeredAdItemView.onResume();
                if (s16 > 0.0f && com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.ad.h.f86763a.e(qFSPublicAccountStaggeredAdItemView)) {
                    qFSPublicAccountStaggeredAdItemView.X0();
                    C(qFSPublicAccountStaggeredAdItemView);
                }
            }
            if (firstVisiblePos != lastVisiblePos) {
                firstVisiblePos++;
            } else {
                return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
    
        r2 = kotlin.collections.ArraysKt___ArraysKt.minOrNull(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0031, code lost:
    
        r1 = kotlin.collections.ArraysKt___ArraysKt.maxOrNull(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void n() {
        RecyclerView.LayoutManager layoutManager;
        StaggeredGridLayoutManager staggeredGridLayoutManager;
        int i3;
        Integer maxOrNull;
        Integer minOrNull;
        RecyclerView recyclerView = getRecyclerView();
        if (recyclerView != null) {
            layoutManager = recyclerView.getLayoutManager();
        } else {
            layoutManager = null;
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
        } else {
            staggeredGridLayoutManager = null;
        }
        if (staggeredGridLayoutManager == null) {
            return;
        }
        int[] findFirstVisibleItemPositions = staggeredGridLayoutManager.findFirstVisibleItemPositions(null);
        int i16 = 0;
        if (findFirstVisibleItemPositions != null && minOrNull != null) {
            i3 = minOrNull.intValue();
        } else {
            i3 = 0;
        }
        int[] findLastVisibleItemPositions = staggeredGridLayoutManager.findLastVisibleItemPositions(null);
        if (findLastVisibleItemPositions != null && maxOrNull != null) {
            i16 = maxOrNull.intValue();
        }
        m(i3, i16, staggeredGridLayoutManager);
    }

    private final void o(String msg2) {
        if (QLog.isColorLevel()) {
            QLog.d("QFSPublicAccountStaggeredAdExposureReporter", 2, msg2);
        }
    }

    private final void p() {
        Collection<CardExposureInfo> values = this.startBaseExposurePosToInfoMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "startBaseExposurePosToInfoMap.values");
        for (CardExposureInfo it : values) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            y(it);
        }
        this.startBaseExposurePosToInfoMap.clear();
    }

    private final int q(QFSPublicAccountStaggeredAdItemView qFSPublicAccountStaggeredAdItemView) {
        StaggeredGridLayoutManager.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2 = qFSPublicAccountStaggeredAdItemView.getLayoutParams();
        if (layoutParams2 instanceof StaggeredGridLayoutManager.LayoutParams) {
            layoutParams = (StaggeredGridLayoutManager.LayoutParams) layoutParams2;
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            return layoutParams.getSpanIndex();
        }
        return -1;
    }

    private final float r(View view) {
        if (view == null) {
            return 0.0f;
        }
        view.getGlobalVisibleRect(new Rect());
        return r0.bottom - r0.top;
    }

    private final float s(View view) {
        boolean z16;
        if (view == null) {
            return 0.0f;
        }
        float r16 = r(view);
        if (r16 == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 || view.getHeight() == 0) {
            return 0.0f;
        }
        return r16 / view.getHeight();
    }

    private final void t(int firstVisiblePos, int lastVisiblePos, RecyclerView.LayoutManager layoutManager, int eventType) {
        View view;
        if (firstVisiblePos > lastVisiblePos) {
            QLog.e("QFSPublicAccountStaggeredAdExposureReporter", 1, "firstVisiblePos=" + firstVisiblePos + " larger than lastVisiblePos=$" + lastVisiblePos);
            return;
        }
        if (firstVisiblePos > lastVisiblePos) {
            return;
        }
        while (true) {
            QFSPublicAccountStaggeredAdItemView qFSPublicAccountStaggeredAdItemView = null;
            if (layoutManager != null) {
                view = layoutManager.findViewByPosition(firstVisiblePos);
            } else {
                view = null;
            }
            if (view instanceof QFSPublicAccountStaggeredAdItemView) {
                qFSPublicAccountStaggeredAdItemView = (QFSPublicAccountStaggeredAdItemView) view;
            }
            if (qFSPublicAccountStaggeredAdItemView != null) {
                o("card percent on scroll end, pos=" + firstVisiblePos + ", " + s(qFSPublicAccountStaggeredAdItemView));
                if (eventType == 0) {
                    qFSPublicAccountStaggeredAdItemView.onPause();
                } else if (eventType == 1) {
                    qFSPublicAccountStaggeredAdItemView.onDestroy();
                }
            }
            if (firstVisiblePos != lastVisiblePos) {
                firstVisiblePos++;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(c this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.n();
        this$0.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(c this$0, QFSPublicAccountStaggeredAdItemView card) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(card, "$card");
        float s16 = this$0.s(card);
        this$0.o("card percent on attach, pos=" + card.getDataPosInList() + ", " + s16 + " ");
        if (s16 > 0.0f && com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.ad.h.f86763a.e(card)) {
            card.X0();
            this$0.w(card);
            this$0.C(card);
        }
    }

    private final void w(QFSPublicAccountStaggeredAdItemView qFSPublicAccountStaggeredAdItemView) {
        GdtAd z06 = qFSPublicAccountStaggeredAdItemView.z0();
        if (z06 != null) {
            com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.ad.g.f86760a.n(z06.getAId(), A(qFSPublicAccountStaggeredAdItemView));
        }
    }

    private final CardExposureInfo x(Map<Integer, CardExposureInfo> map, int i3, QFSPublicAccountStaggeredAdItemView qFSPublicAccountStaggeredAdItemView) {
        CardExposureInfo cardExposureInfo = map.get(Integer.valueOf(i3));
        if (cardExposureInfo != null) {
            map.put(Integer.valueOf(i3), CardExposureInfo.b(cardExposureInfo, null, null, 0, 0L, 0, 0, 0, 0.0f, Math.max(cardExposureInfo.getExposureMaxHeight(), r(qFSPublicAccountStaggeredAdItemView)), null, null, null, null, 7935, null));
            return null;
        }
        CardExposureInfo A = A(qFSPublicAccountStaggeredAdItemView);
        map.put(Integer.valueOf(i3), A);
        return A;
    }

    private final void y(CardExposureInfo cardExposureInfo) {
        long currentTimeMillis = System.currentTimeMillis() - cardExposureInfo.getStartTimeMs();
        o("reportEndBaseExposure info=" + cardExposureInfo + ", exposureTime=" + currentTimeMillis);
        com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.ad.g.f86760a.h(cardExposureInfo, currentTimeMillis);
    }

    private final void z(CardExposureInfo cardExposureInfo) {
        o("reportStartBaseExposure info=" + cardExposureInfo);
        com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.ad.g.f86760a.l(cardExposureInfo);
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.q
    public void c() {
        RecyclerView.LayoutManager layoutManager;
        StaggeredGridLayoutManager staggeredGridLayoutManager;
        int i3;
        super.c();
        RecyclerView recyclerView = getRecyclerView();
        if (recyclerView != null) {
            layoutManager = recyclerView.getLayoutManager();
        } else {
            layoutManager = null;
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
        } else {
            staggeredGridLayoutManager = null;
        }
        if (staggeredGridLayoutManager == null) {
            return;
        }
        int[] findFirstVisibleItemPositions = staggeredGridLayoutManager.findFirstVisibleItemPositions(null);
        int i16 = 0;
        if (findFirstVisibleItemPositions != null) {
            i3 = ArraysKt___ArraysKt.first(findFirstVisibleItemPositions);
        } else {
            i3 = 0;
        }
        int[] findLastVisibleItemPositions = staggeredGridLayoutManager.findLastVisibleItemPositions(null);
        if (findLastVisibleItemPositions != null) {
            i16 = ArraysKt___ArraysKt.first(findLastVisibleItemPositions);
        }
        t(i3, i16, staggeredGridLayoutManager, 1);
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.q
    public void d() {
        RecyclerView.LayoutManager layoutManager;
        StaggeredGridLayoutManager staggeredGridLayoutManager;
        int i3;
        int i16;
        super.d();
        p();
        RecyclerView recyclerView = getRecyclerView();
        if (recyclerView != null) {
            layoutManager = recyclerView.getLayoutManager();
        } else {
            layoutManager = null;
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
        } else {
            staggeredGridLayoutManager = null;
        }
        if (staggeredGridLayoutManager == null) {
            return;
        }
        int[] findFirstVisibleItemPositions = staggeredGridLayoutManager.findFirstVisibleItemPositions(null);
        if (findFirstVisibleItemPositions != null) {
            i3 = ArraysKt___ArraysKt.first(findFirstVisibleItemPositions);
        } else {
            i3 = 0;
        }
        int[] findLastVisibleItemPositions = staggeredGridLayoutManager.findLastVisibleItemPositions(null);
        if (findLastVisibleItemPositions != null) {
            i16 = ArraysKt___ArraysKt.first(findLastVisibleItemPositions);
        } else {
            i16 = 0;
        }
        t(i3, i16, staggeredGridLayoutManager, 0);
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.q
    public void e() {
        super.e();
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.b
            @Override // java.lang.Runnable
            public final void run() {
                c.u(c.this);
            }
        }, 100L);
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.q
    public void f() {
        super.f();
        n();
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.q
    public void g(@Nullable RecyclerView recyclerView, int newState, @Nullable RecyclerView.LayoutManager manager, int firstVisiblePos, int lastVisiblePos, int firstCompletelyVisible, int lastCompletelyVisible, boolean isScrollUp) {
        if (newState != 0) {
            return;
        }
        m(firstVisiblePos, lastVisiblePos, manager);
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.q
    public void i(@NotNull View view) {
        final QFSPublicAccountStaggeredAdItemView qFSPublicAccountStaggeredAdItemView;
        Intrinsics.checkNotNullParameter(view, "view");
        if (view instanceof QFSPublicAccountStaggeredAdItemView) {
            qFSPublicAccountStaggeredAdItemView = (QFSPublicAccountStaggeredAdItemView) view;
        } else {
            qFSPublicAccountStaggeredAdItemView = null;
        }
        if (qFSPublicAccountStaggeredAdItemView == null) {
            return;
        }
        qFSPublicAccountStaggeredAdItemView.post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.a
            @Override // java.lang.Runnable
            public final void run() {
                c.v(c.this, qFSPublicAccountStaggeredAdItemView);
            }
        });
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.q
    public void j(@NotNull View view) {
        QFSPublicAccountStaggeredAdItemView qFSPublicAccountStaggeredAdItemView;
        Intrinsics.checkNotNullParameter(view, "view");
        super.j(view);
        if (view instanceof QFSPublicAccountStaggeredAdItemView) {
            qFSPublicAccountStaggeredAdItemView = (QFSPublicAccountStaggeredAdItemView) view;
        } else {
            qFSPublicAccountStaggeredAdItemView = null;
        }
        if (qFSPublicAccountStaggeredAdItemView == null) {
            return;
        }
        B(qFSPublicAccountStaggeredAdItemView);
    }
}
