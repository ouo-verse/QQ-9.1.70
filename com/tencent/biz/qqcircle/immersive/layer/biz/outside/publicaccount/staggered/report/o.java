package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report;

import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.feed.ad.u;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.QFSPublicAccountFollowUsersItemView;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.QFSPublicAccountStaggeredNormalItemView;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.model.QFSPublicAccountStaggeredItemCommentHelper;
import com.tencent.biz.qqcircle.utils.bh;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleFeedBase$StReportInfoForClient;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 82\u00020\u0001:\u00029:B\u000f\u0012\u0006\u00101\u001a\u00020/\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0016\u0010\u000e\u001a\u00020\r*\f\u0012\u0004\u0012\u00020\u000b0\nj\u0002`\fH\u0002J\u0016\u0010\u000f\u001a\u00020\r*\f\u0012\u0004\u0012\u00020\u000b0\nj\u0002`\fH\u0002J\u0016\u0010\u0010\u001a\u00020\r*\f\u0012\u0004\u0012\u00020\u000b0\nj\u0002`\fH\u0002J\u0016\u0010\u0011\u001a\u00020\r*\f\u0012\u0004\u0012\u00020\u000b0\nj\u0002`\fH\u0002J\u0016\u0010\u0012\u001a\u00020\u0004*\f\u0012\u0004\u0012\u00020\u000b0\nj\u0002`\fH\u0002J\u0016\u0010\u0014\u001a\u00020\u0013*\f\u0012\u0004\u0012\u00020\u000b0\nj\u0002`\fH\u0002J4\u0010\u0018\u001a\u0004\u0018\u00010\u0013*\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00130\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0010\u0010\u0017\u001a\f\u0012\u0004\u0012\u00020\u000b0\nj\u0002`\fH\u0002J\b\u0010\u0019\u001a\u00020\u0002H\u0002J\f\u0010\u001a\u001a\u00020\u0002*\u00020\u0013H\u0002J\f\u0010\u001b\u001a\u00020\u0002*\u00020\u0013H\u0002J\f\u0010\u001c\u001a\u00020\u0002*\u00020\u0013H\u0002JL\u0010$\u001a\u00020\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\rH\u0016J\u0010\u0010'\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%H\u0016J\u0010\u0010(\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%H\u0016J\b\u0010)\u001a\u00020\u0002H\u0016J\b\u0010*\u001a\u00020\u0002H\u0016J\b\u0010+\u001a\u00020\u0002H\u0016J\f\u0010.\u001a\u0004\u0018\u00010-*\u00020,R\u0014\u00101\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u00100R \u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0013028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u00103R \u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0013028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u00103\u00a8\u0006;"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/report/o;", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/report/q;", "", DomainData.DOMAIN_NAME, "", "firstVisiblePos", "lastVisiblePos", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "layoutManager", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/biz/qqcircle/widgets/QCircleBaseWidgetView;", "Le30/b;", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/report/Card;", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "y", "B", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "p", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/report/o$a;", HippyTKDListViewAdapter.X, "", com.tencent.luggage.wxa.c8.c.G, IndividuationUrlHelper.UrlId.CARD_HOME, "t", "o", "v", "u", "w", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "newState", "manager", "firstCompletelyVisible", "lastCompletelyVisible", "isScrollUp", "g", "Landroid/view/View;", "view", "i", "j", "f", "d", "e", "Lfeedcloud/FeedCloudMeta$StFeed;", "Lqqcircle/QQCircleFeedBase$StReportInfoForClient;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "initBean", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "startBaseExposurePosToInfoMap", "startValidExposurePosToInfoMap", "<init>", "(Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;)V", tl.h.F, "a", "b", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class o extends q {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QCircleInitBean initBean;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<Integer, CardExposureInfo> startBaseExposurePosToInfoMap;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<Integer, CardExposureInfo> startValidExposurePosToInfoMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b1\b\u0086\b\u0018\u00002\u00020\u0001B\u00cb\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u000b\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\u0006\u0010\u001e\u001a\u00020\u0005\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\b\u0010\"\u001a\u0004\u0018\u00010!\u00a2\u0006\u0004\bP\u0010QJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u00fd\u0001\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u001f2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!H\u00c6\u0001J\t\u0010$\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010&\u001a\u00020\u001f2\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0004\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b#\u0010'\u001a\u0004\b(\u0010)R\u0017\u0010\u0006\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0017\u0010\u0007\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b.\u0010+\u001a\u0004\b/\u0010-R\u0017\u0010\b\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b0\u0010+\u001a\u0004\b1\u0010-R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b1\u0010'\u001a\u0004\b2\u0010)R\u0017\u0010\n\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b3\u0010+\u001a\u0004\b4\u0010-R\u0017\u0010\f\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u0017\u0010\r\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b(\u0010+\u001a\u0004\b9\u0010-R\u0017\u0010\u000e\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b/\u0010+\u001a\u0004\b:\u0010-R\u0017\u0010\u0010\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b0\u0010=R\u0017\u0010\u0011\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b>\u0010<\u001a\u0004\b5\u0010=R\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b4\u0010'\u001a\u0004\b?\u0010)R\u0017\u0010\u0013\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b9\u0010+\u001a\u0004\b@\u0010-R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b2\u0010'\u001a\u0004\bA\u0010)R\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\bB\u0010'\u001a\u0004\bC\u0010)R\u0017\u0010\u0016\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b?\u00106\u001a\u0004\bD\u00108R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\bE\u0010'\u001a\u0004\bB\u0010)R\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\bD\u0010'\u001a\u0004\bF\u0010)R\u0017\u0010\u001a\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b:\u0010G\u001a\u0004\b.\u0010HR\u0017\u0010\u001b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b7\u0010'\u001a\u0004\b3\u0010)R\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006\u00a2\u0006\f\n\u0004\bA\u0010I\u001a\u0004\bE\u0010JR\u0017\u0010\u001e\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\bC\u0010+\u001a\u0004\b>\u0010-R\u0017\u0010 \u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b@\u0010K\u001a\u0004\bL\u0010MR\u0019\u0010\"\u001a\u0004\u0018\u00010!8\u0006\u00a2\u0006\f\n\u0004\b,\u0010N\u001a\u0004\b;\u0010O\u00a8\u0006R"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/report/o$a;", "", "", "toString", "feedId", "", "type", "feedType", "dittoFeedId", "posterId", MessageForQCircleFeed.MSG_QCIRCLE_FEED_KEY_LIKE_COUNT, "", "startTimeMs", com.tencent.luggage.wxa.c8.c.G, "spanIndex", "", "cardHeight", "exposureMaxHeight", "recommendReason", "tagType", "tagId", "tagText", "roomId", "programId", "sealTransfer", "", "busiReport", "dtTransfer", "Lqqcircle/QQCircleFeedBase$StReportInfoForClient;", CacheTable.TABLE_NAME, "hasComment", "", "isNormalItem", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "a", "hashCode", "other", "equals", "Ljava/lang/String;", tl.h.F, "()Ljava/lang/String;", "b", "I", HippyTKDListViewAdapter.X, "()I", "c", "i", "d", "e", DomainData.DOMAIN_NAME, "f", "l", "g", "J", "t", "()J", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, ReportConstant.COSTREPORT_PREFIX, "j", UserInfo.SEX_FEMALE, "()F", "k", "p", "w", "u", "o", "v", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "getSealTransfer", "[B", "()[B", "Lqqcircle/QQCircleFeedBase$StReportInfoForClient;", "()Lqqcircle/QQCircleFeedBase$StReportInfoForClient;", "Z", "y", "()Z", "Lcom/tencent/gdtad/aditem/GdtAd;", "()Lcom/tencent/gdtad/aditem/GdtAd;", "<init>", "(Ljava/lang/String;IIILjava/lang/String;IJIIFFLjava/lang/String;ILjava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;[BLjava/lang/String;Lqqcircle/QQCircleFeedBase$StReportInfoForClient;IZLcom/tencent/gdtad/aditem/GdtAd;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.o$a, reason: from toString */
    /* loaded from: classes4.dex */
    public static final /* data */ class CardExposureInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String feedId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int type;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final int feedType;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int dittoFeedId;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String posterId;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final int likeCount;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private final long startTimeMs;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        private final int pos;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        private final int spanIndex;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
        private final float cardHeight;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
        private final float exposureMaxHeight;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String recommendReason;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private final int tagType;

        /* renamed from: n, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String tagId;

        /* renamed from: o, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String tagText;

        /* renamed from: p, reason: collision with root package name and from kotlin metadata */
        private final long roomId;

        /* renamed from: q, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String programId;

        /* renamed from: r, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String sealTransfer;

        /* renamed from: s, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final byte[] busiReport;

        /* renamed from: t, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String dtTransfer;

        /* renamed from: u, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final QQCircleFeedBase$StReportInfoForClient reportInfo;

        /* renamed from: v, reason: collision with root package name and from kotlin metadata */
        private final int hasComment;

        /* renamed from: w, reason: collision with root package name and from kotlin metadata */
        private final boolean isNormalItem;

        /* renamed from: x, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final GdtAd gdtAd;

        public CardExposureInfo(@NotNull String feedId, int i3, int i16, int i17, @NotNull String posterId, int i18, long j3, int i19, int i26, float f16, float f17, @NotNull String recommendReason, int i27, @NotNull String tagId, @NotNull String tagText, long j16, @NotNull String programId, @NotNull String sealTransfer, @NotNull byte[] busiReport, @NotNull String dtTransfer, @Nullable QQCircleFeedBase$StReportInfoForClient qQCircleFeedBase$StReportInfoForClient, int i28, boolean z16, @Nullable GdtAd gdtAd) {
            Intrinsics.checkNotNullParameter(feedId, "feedId");
            Intrinsics.checkNotNullParameter(posterId, "posterId");
            Intrinsics.checkNotNullParameter(recommendReason, "recommendReason");
            Intrinsics.checkNotNullParameter(tagId, "tagId");
            Intrinsics.checkNotNullParameter(tagText, "tagText");
            Intrinsics.checkNotNullParameter(programId, "programId");
            Intrinsics.checkNotNullParameter(sealTransfer, "sealTransfer");
            Intrinsics.checkNotNullParameter(busiReport, "busiReport");
            Intrinsics.checkNotNullParameter(dtTransfer, "dtTransfer");
            this.feedId = feedId;
            this.type = i3;
            this.feedType = i16;
            this.dittoFeedId = i17;
            this.posterId = posterId;
            this.likeCount = i18;
            this.startTimeMs = j3;
            this.pos = i19;
            this.spanIndex = i26;
            this.cardHeight = f16;
            this.exposureMaxHeight = f17;
            this.recommendReason = recommendReason;
            this.tagType = i27;
            this.tagId = tagId;
            this.tagText = tagText;
            this.roomId = j16;
            this.programId = programId;
            this.sealTransfer = sealTransfer;
            this.busiReport = busiReport;
            this.dtTransfer = dtTransfer;
            this.reportInfo = qQCircleFeedBase$StReportInfoForClient;
            this.hasComment = i28;
            this.isNormalItem = z16;
            this.gdtAd = gdtAd;
        }

        public static /* synthetic */ CardExposureInfo b(CardExposureInfo cardExposureInfo, String str, int i3, int i16, int i17, String str2, int i18, long j3, int i19, int i26, float f16, float f17, String str3, int i27, String str4, String str5, long j16, String str6, String str7, byte[] bArr, String str8, QQCircleFeedBase$StReportInfoForClient qQCircleFeedBase$StReportInfoForClient, int i28, boolean z16, GdtAd gdtAd, int i29, Object obj) {
            return cardExposureInfo.a((i29 & 1) != 0 ? cardExposureInfo.feedId : str, (i29 & 2) != 0 ? cardExposureInfo.type : i3, (i29 & 4) != 0 ? cardExposureInfo.feedType : i16, (i29 & 8) != 0 ? cardExposureInfo.dittoFeedId : i17, (i29 & 16) != 0 ? cardExposureInfo.posterId : str2, (i29 & 32) != 0 ? cardExposureInfo.likeCount : i18, (i29 & 64) != 0 ? cardExposureInfo.startTimeMs : j3, (i29 & 128) != 0 ? cardExposureInfo.pos : i19, (i29 & 256) != 0 ? cardExposureInfo.spanIndex : i26, (i29 & 512) != 0 ? cardExposureInfo.cardHeight : f16, (i29 & 1024) != 0 ? cardExposureInfo.exposureMaxHeight : f17, (i29 & 2048) != 0 ? cardExposureInfo.recommendReason : str3, (i29 & 4096) != 0 ? cardExposureInfo.tagType : i27, (i29 & 8192) != 0 ? cardExposureInfo.tagId : str4, (i29 & 16384) != 0 ? cardExposureInfo.tagText : str5, (i29 & 32768) != 0 ? cardExposureInfo.roomId : j16, (i29 & 65536) != 0 ? cardExposureInfo.programId : str6, (131072 & i29) != 0 ? cardExposureInfo.sealTransfer : str7, (i29 & 262144) != 0 ? cardExposureInfo.busiReport : bArr, (i29 & 524288) != 0 ? cardExposureInfo.dtTransfer : str8, (i29 & 1048576) != 0 ? cardExposureInfo.reportInfo : qQCircleFeedBase$StReportInfoForClient, (i29 & 2097152) != 0 ? cardExposureInfo.hasComment : i28, (i29 & 4194304) != 0 ? cardExposureInfo.isNormalItem : z16, (i29 & 8388608) != 0 ? cardExposureInfo.gdtAd : gdtAd);
        }

        @NotNull
        public final CardExposureInfo a(@NotNull String feedId, int type, int feedType, int dittoFeedId, @NotNull String posterId, int likeCount, long startTimeMs, int pos, int spanIndex, float cardHeight, float exposureMaxHeight, @NotNull String recommendReason, int tagType, @NotNull String tagId, @NotNull String tagText, long roomId, @NotNull String programId, @NotNull String sealTransfer, @NotNull byte[] busiReport, @NotNull String dtTransfer, @Nullable QQCircleFeedBase$StReportInfoForClient reportInfo, int hasComment, boolean isNormalItem, @Nullable GdtAd gdtAd) {
            Intrinsics.checkNotNullParameter(feedId, "feedId");
            Intrinsics.checkNotNullParameter(posterId, "posterId");
            Intrinsics.checkNotNullParameter(recommendReason, "recommendReason");
            Intrinsics.checkNotNullParameter(tagId, "tagId");
            Intrinsics.checkNotNullParameter(tagText, "tagText");
            Intrinsics.checkNotNullParameter(programId, "programId");
            Intrinsics.checkNotNullParameter(sealTransfer, "sealTransfer");
            Intrinsics.checkNotNullParameter(busiReport, "busiReport");
            Intrinsics.checkNotNullParameter(dtTransfer, "dtTransfer");
            return new CardExposureInfo(feedId, type, feedType, dittoFeedId, posterId, likeCount, startTimeMs, pos, spanIndex, cardHeight, exposureMaxHeight, recommendReason, tagType, tagId, tagText, roomId, programId, sealTransfer, busiReport, dtTransfer, reportInfo, hasComment, isNormalItem, gdtAd);
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
        public final int getDittoFeedId() {
            return this.dittoFeedId;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CardExposureInfo)) {
                return false;
            }
            CardExposureInfo cardExposureInfo = (CardExposureInfo) other;
            if (Intrinsics.areEqual(this.feedId, cardExposureInfo.feedId) && this.type == cardExposureInfo.type && this.feedType == cardExposureInfo.feedType && this.dittoFeedId == cardExposureInfo.dittoFeedId && Intrinsics.areEqual(this.posterId, cardExposureInfo.posterId) && this.likeCount == cardExposureInfo.likeCount && this.startTimeMs == cardExposureInfo.startTimeMs && this.pos == cardExposureInfo.pos && this.spanIndex == cardExposureInfo.spanIndex && Float.compare(this.cardHeight, cardExposureInfo.cardHeight) == 0 && Float.compare(this.exposureMaxHeight, cardExposureInfo.exposureMaxHeight) == 0 && Intrinsics.areEqual(this.recommendReason, cardExposureInfo.recommendReason) && this.tagType == cardExposureInfo.tagType && Intrinsics.areEqual(this.tagId, cardExposureInfo.tagId) && Intrinsics.areEqual(this.tagText, cardExposureInfo.tagText) && this.roomId == cardExposureInfo.roomId && Intrinsics.areEqual(this.programId, cardExposureInfo.programId) && Intrinsics.areEqual(this.sealTransfer, cardExposureInfo.sealTransfer) && Intrinsics.areEqual(this.busiReport, cardExposureInfo.busiReport) && Intrinsics.areEqual(this.dtTransfer, cardExposureInfo.dtTransfer) && Intrinsics.areEqual(this.reportInfo, cardExposureInfo.reportInfo) && this.hasComment == cardExposureInfo.hasComment && this.isNormalItem == cardExposureInfo.isNormalItem && Intrinsics.areEqual(this.gdtAd, cardExposureInfo.gdtAd)) {
                return true;
            }
            return false;
        }

        @NotNull
        /* renamed from: f, reason: from getter */
        public final String getDtTransfer() {
            return this.dtTransfer;
        }

        /* renamed from: g, reason: from getter */
        public final float getExposureMaxHeight() {
            return this.exposureMaxHeight;
        }

        @NotNull
        /* renamed from: h, reason: from getter */
        public final String getFeedId() {
            return this.feedId;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            int hashCode2 = ((((((((((((((((((((((((((((((((((((((this.feedId.hashCode() * 31) + this.type) * 31) + this.feedType) * 31) + this.dittoFeedId) * 31) + this.posterId.hashCode()) * 31) + this.likeCount) * 31) + androidx.fragment.app.a.a(this.startTimeMs)) * 31) + this.pos) * 31) + this.spanIndex) * 31) + Float.floatToIntBits(this.cardHeight)) * 31) + Float.floatToIntBits(this.exposureMaxHeight)) * 31) + this.recommendReason.hashCode()) * 31) + this.tagType) * 31) + this.tagId.hashCode()) * 31) + this.tagText.hashCode()) * 31) + androidx.fragment.app.a.a(this.roomId)) * 31) + this.programId.hashCode()) * 31) + this.sealTransfer.hashCode()) * 31) + Arrays.hashCode(this.busiReport)) * 31) + this.dtTransfer.hashCode()) * 31;
            QQCircleFeedBase$StReportInfoForClient qQCircleFeedBase$StReportInfoForClient = this.reportInfo;
            int i3 = 0;
            if (qQCircleFeedBase$StReportInfoForClient == null) {
                hashCode = 0;
            } else {
                hashCode = qQCircleFeedBase$StReportInfoForClient.hashCode();
            }
            int i16 = (((hashCode2 + hashCode) * 31) + this.hasComment) * 31;
            boolean z16 = this.isNormalItem;
            int i17 = z16;
            if (z16 != 0) {
                i17 = 1;
            }
            int i18 = (i16 + i17) * 31;
            GdtAd gdtAd = this.gdtAd;
            if (gdtAd != null) {
                i3 = gdtAd.hashCode();
            }
            return i18 + i3;
        }

        /* renamed from: i, reason: from getter */
        public final int getFeedType() {
            return this.feedType;
        }

        @Nullable
        /* renamed from: j, reason: from getter */
        public final GdtAd getGdtAd() {
            return this.gdtAd;
        }

        /* renamed from: k, reason: from getter */
        public final int getHasComment() {
            return this.hasComment;
        }

        /* renamed from: l, reason: from getter */
        public final int getLikeCount() {
            return this.likeCount;
        }

        /* renamed from: m, reason: from getter */
        public final int getPos() {
            return this.pos;
        }

        @NotNull
        /* renamed from: n, reason: from getter */
        public final String getPosterId() {
            return this.posterId;
        }

        @NotNull
        /* renamed from: o, reason: from getter */
        public final String getProgramId() {
            return this.programId;
        }

        @NotNull
        /* renamed from: p, reason: from getter */
        public final String getRecommendReason() {
            return this.recommendReason;
        }

        @Nullable
        /* renamed from: q, reason: from getter */
        public final QQCircleFeedBase$StReportInfoForClient getReportInfo() {
            return this.reportInfo;
        }

        /* renamed from: r, reason: from getter */
        public final long getRoomId() {
            return this.roomId;
        }

        /* renamed from: s, reason: from getter */
        public final int getSpanIndex() {
            return this.spanIndex;
        }

        /* renamed from: t, reason: from getter */
        public final long getStartTimeMs() {
            return this.startTimeMs;
        }

        @NotNull
        public String toString() {
            return "CardExposureInfo(feedId=" + this.feedId + ",startTimeMs=" + this.startTimeMs + ", pos=" + this.pos + ", spanIndex=" + this.spanIndex + ", cardHeight=" + this.cardHeight + ", exposureMaxHeight=" + this.exposureMaxHeight + ", recommendReason=" + this.recommendReason + ", )";
        }

        @NotNull
        /* renamed from: u, reason: from getter */
        public final String getTagId() {
            return this.tagId;
        }

        @NotNull
        /* renamed from: v, reason: from getter */
        public final String getTagText() {
            return this.tagText;
        }

        /* renamed from: w, reason: from getter */
        public final int getTagType() {
            return this.tagType;
        }

        /* renamed from: x, reason: from getter */
        public final int getType() {
            return this.type;
        }

        /* renamed from: y, reason: from getter */
        public final boolean getIsNormalItem() {
            return this.isNormalItem;
        }
    }

    public o(@NotNull QCircleInitBean initBean) {
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        this.initBean = initBean;
        this.startBaseExposurePosToInfoMap = new ConcurrentHashMap<>();
        this.startValidExposurePosToInfoMap = new ConcurrentHashMap<>();
    }

    private final boolean A(QCircleBaseWidgetView<e30.b> qCircleBaseWidgetView) {
        CardExposureInfo t16 = t(this.startBaseExposurePosToInfoMap, qCircleBaseWidgetView.getDataPosInList(), qCircleBaseWidgetView);
        if (t16 != null) {
            v(t16);
        }
        if (t16 != null) {
            return true;
        }
        return false;
    }

    private final boolean B(QCircleBaseWidgetView<e30.b> qCircleBaseWidgetView) {
        if (t(this.startValidExposurePosToInfoMap, qCircleBaseWidgetView.getDataPosInList(), qCircleBaseWidgetView) != null) {
            return true;
        }
        return false;
    }

    private final void m(int firstVisiblePos, int lastVisiblePos, RecyclerView.LayoutManager layoutManager) {
        View view;
        View view2;
        if (firstVisiblePos > lastVisiblePos) {
            QLog.e("QFSPublicAccountStaggeredScrollReportHelper", 1, "firstVisiblePos=" + firstVisiblePos + " larger than lastVisiblePos=$" + lastVisiblePos);
            return;
        }
        if (firstVisiblePos > lastVisiblePos) {
            return;
        }
        while (true) {
            QCircleBaseWidgetView<e30.b> qCircleBaseWidgetView = null;
            if (layoutManager != null) {
                view = layoutManager.findViewByPosition(firstVisiblePos);
            } else {
                view = null;
            }
            if (!(view instanceof QFSPublicAccountFollowUsersItemView)) {
                if (layoutManager != null) {
                    view2 = layoutManager.findViewByPosition(firstVisiblePos);
                } else {
                    view2 = null;
                }
                if (view2 instanceof QCircleBaseWidgetView) {
                    qCircleBaseWidgetView = (QCircleBaseWidgetView) view2;
                }
                if (qCircleBaseWidgetView != null) {
                    float c16 = com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.e.c(qCircleBaseWidgetView);
                    if (c16 > 0.0f) {
                        A(qCircleBaseWidgetView);
                    }
                    if (c16 >= 0.7f) {
                        B(qCircleBaseWidgetView);
                    } else {
                        z(qCircleBaseWidgetView);
                    }
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

    private final void o() {
        Collection<CardExposureInfo> values = this.startBaseExposurePosToInfoMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "startBaseExposurePosToInfoMap.values");
        for (CardExposureInfo it : values) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            u(it);
        }
        Collection<CardExposureInfo> values2 = this.startValidExposurePosToInfoMap.values();
        Intrinsics.checkNotNullExpressionValue(values2, "startValidExposurePosToInfoMap.values");
        for (CardExposureInfo it5 : values2) {
            Intrinsics.checkNotNullExpressionValue(it5, "it");
            w(it5);
        }
        this.startBaseExposurePosToInfoMap.clear();
        this.startValidExposurePosToInfoMap.clear();
    }

    private final int p(QCircleBaseWidgetView<e30.b> qCircleBaseWidgetView) {
        StaggeredGridLayoutManager.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2 = qCircleBaseWidgetView.getLayoutParams();
        if (layoutParams2 instanceof StaggeredGridLayoutManager.LayoutParams) {
            layoutParams = (StaggeredGridLayoutManager.LayoutParams) layoutParams2;
        } else {
            layoutParams = null;
        }
        boolean z16 = false;
        if (layoutParams != null && layoutParams.isFullSpan()) {
            z16 = true;
        }
        if (z16) {
            return 2;
        }
        if (layoutParams != null) {
            return layoutParams.getSpanIndex();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(o this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o();
        this$0.n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(QCircleBaseWidgetView card, o this$0) {
        Intrinsics.checkNotNullParameter(card, "$card");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        float c16 = com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.e.c(card);
        if (c16 > 0.0f) {
            this$0.A(card);
        }
        if (c16 >= 0.7f) {
            this$0.B(card);
        }
    }

    private final CardExposureInfo t(Map<Integer, CardExposureInfo> map, int i3, QCircleBaseWidgetView<e30.b> qCircleBaseWidgetView) {
        CardExposureInfo cardExposureInfo = map.get(Integer.valueOf(i3));
        if (cardExposureInfo != null) {
            map.put(Integer.valueOf(i3), CardExposureInfo.b(cardExposureInfo, null, 0, 0, 0, null, 0, 0L, 0, 0, 0.0f, Math.max(cardExposureInfo.getExposureMaxHeight(), com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.e.b(qCircleBaseWidgetView)), null, 0, null, null, 0L, null, null, null, null, null, 0, false, null, 16776191, null));
            return null;
        }
        CardExposureInfo x16 = x(qCircleBaseWidgetView);
        map.put(Integer.valueOf(i3), x16);
        return x16;
    }

    private final void u(CardExposureInfo cardExposureInfo) {
        long currentTimeMillis = System.currentTimeMillis() - cardExposureInfo.getStartTimeMs();
        g.f87070a.h(cardExposureInfo, currentTimeMillis, this.initBean);
        l.f87082a.l(cardExposureInfo, currentTimeMillis, this.initBean);
    }

    private final void v(CardExposureInfo cardExposureInfo) {
        g.f87070a.j(cardExposureInfo, this.initBean);
        l.f87082a.j(cardExposureInfo, this.initBean);
    }

    private final void w(CardExposureInfo cardExposureInfo) {
        g.f87070a.l(cardExposureInfo, System.currentTimeMillis() - cardExposureInfo.getStartTimeMs(), this.initBean);
    }

    private final CardExposureInfo x(QCircleBaseWidgetView<e30.b> qCircleBaseWidgetView) {
        Object obj;
        QQCircleFeedBase$StReportInfoForClient qQCircleFeedBase$StReportInfoForClient;
        String str;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        boolean z16;
        Integer num;
        GdtAd gdtAd;
        PBStringField pBStringField;
        e30.b data = qCircleBaseWidgetView.getData();
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
        e30.b data2 = qCircleBaseWidgetView.getData();
        if (data2 != null) {
            feedCloudMeta$StFeed = data2.g();
        } else {
            feedCloudMeta$StFeed = null;
        }
        if (feedCloudMeta$StFeed == null) {
            feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
        }
        QQCircleFeedBase$StReportInfoForClient s16 = s(feedCloudMeta$StFeed);
        String str3 = feedCloudMeta$StFeed.f398449id.get();
        Intrinsics.checkNotNullExpressionValue(str3, "feed.id.get()");
        int i3 = feedCloudMeta$StFeed.type.get();
        int i16 = feedCloudMeta$StFeed.feedType.get();
        int i17 = feedCloudMeta$StFeed.dittoFeed.dittoId.get();
        String str4 = feedCloudMeta$StFeed.poster.f398463id.get();
        Intrinsics.checkNotNullExpressionValue(str4, "feed.poster.id.get()");
        int i18 = feedCloudMeta$StFeed.likeInfo.count.get();
        long currentTimeMillis = System.currentTimeMillis();
        int dataPosInList = qCircleBaseWidgetView.getDataPosInList() + 1;
        int p16 = p(qCircleBaseWidgetView) + 1;
        float height = qCircleBaseWidgetView.getHeight();
        float b16 = com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.e.b(qCircleBaseWidgetView);
        String str5 = feedCloudMeta$StFeed.recomInfo.recomReasonV2.recomReason.get();
        Intrinsics.checkNotNullExpressionValue(str5, "feed.recomInfo.recomReasonV2.recomReason.get()");
        int i19 = feedCloudMeta$StFeed.liteBanner.business_type.get();
        String d16 = bh.d(feedCloudMeta$StFeed.liteBanner.extInfo.get(), "group_guild_id");
        Intrinsics.checkNotNullExpressionValue(d16, "getValueFromExtInfo(feed\u2026.get(), \"group_guild_id\")");
        String d17 = bh.d(feedCloudMeta$StFeed.liteBanner.extInfo.get(), "group_guild_title");
        Intrinsics.checkNotNullExpressionValue(d17, "getValueFromExtInfo(feed\u2026t(), \"group_guild_title\")");
        long j3 = feedCloudMeta$StFeed.live.room.roomId.get();
        String d18 = bh.d(feedCloudMeta$StFeed.live.get().liveExtInfo.get(), QCircleDaTongConstant.ElementParamKey.TAG_QQLIVE_PROGRAM_ID);
        Intrinsics.checkNotNullExpressionValue(d18, "getValueFromExtInfo(\n   \u2026ey.TAG_QQLIVE_PROGRAM_ID)");
        String str6 = feedCloudMeta$StFeed.recomInfo.recomTrace.get();
        Intrinsics.checkNotNullExpressionValue(str6, "feed.recomInfo.recomTrace.get()");
        byte[] byteArray = feedCloudMeta$StFeed.busiReport.get().toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "feed.busiReport.get().toByteArray()");
        int e16 = QFSPublicAccountStaggeredItemCommentHelper.f86870a.e(feedCloudMeta$StFeed);
        boolean z17 = qCircleBaseWidgetView instanceof QFSPublicAccountStaggeredNormalItemView;
        Integer valueOf = Integer.valueOf(feedCloudMeta$StFeed.feedType.get());
        if (valueOf.intValue() == 4) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            num = valueOf;
        } else {
            num = null;
        }
        if (num != null) {
            num.intValue();
            try {
                gdtAd = new GdtAd(u.e(qCircleBaseWidgetView.getData()));
            } catch (Exception unused) {
            }
            return new CardExposureInfo(str3, i3, i16, i17, str4, i18, currentTimeMillis, dataPosInList, p16, height, b16, str5, i19, d16, d17, j3, d18, str6, byteArray, str2, s16, e16, z17, gdtAd);
        }
        gdtAd = null;
        return new CardExposureInfo(str3, i3, i16, i17, str4, i18, currentTimeMillis, dataPosInList, p16, height, b16, str5, i19, d16, d17, j3, d18, str6, byteArray, str2, s16, e16, z17, gdtAd);
    }

    private final boolean y(QCircleBaseWidgetView<e30.b> qCircleBaseWidgetView) {
        CardExposureInfo remove = this.startBaseExposurePosToInfoMap.remove(Integer.valueOf(qCircleBaseWidgetView.getDataPosInList()));
        if (remove != null) {
            u(remove);
            return true;
        }
        return false;
    }

    private final boolean z(QCircleBaseWidgetView<e30.b> qCircleBaseWidgetView) {
        CardExposureInfo remove = this.startValidExposurePosToInfoMap.remove(Integer.valueOf(qCircleBaseWidgetView.getDataPosInList()));
        if (remove != null) {
            w(remove);
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.q
    public void d() {
        super.d();
        o();
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.q
    public void e() {
        super.e();
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.n
            @Override // java.lang.Runnable
            public final void run() {
                o.q(o.this);
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
        final QCircleBaseWidgetView qCircleBaseWidgetView;
        Intrinsics.checkNotNullParameter(view, "view");
        if (view instanceof QCircleBaseWidgetView) {
            qCircleBaseWidgetView = (QCircleBaseWidgetView) view;
        } else {
            qCircleBaseWidgetView = null;
        }
        if (qCircleBaseWidgetView == null) {
            return;
        }
        qCircleBaseWidgetView.post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.m
            @Override // java.lang.Runnable
            public final void run() {
                o.r(QCircleBaseWidgetView.this, this);
            }
        });
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.q
    public void j(@NotNull View view) {
        QCircleBaseWidgetView<e30.b> qCircleBaseWidgetView;
        Intrinsics.checkNotNullParameter(view, "view");
        super.j(view);
        if (view instanceof QCircleBaseWidgetView) {
            qCircleBaseWidgetView = (QCircleBaseWidgetView) view;
        } else {
            qCircleBaseWidgetView = null;
        }
        if (qCircleBaseWidgetView == null) {
            return;
        }
        y(qCircleBaseWidgetView);
        z(qCircleBaseWidgetView);
    }

    @Nullable
    public final QQCircleFeedBase$StReportInfoForClient s(@NotNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        Intrinsics.checkNotNullParameter(feedCloudMeta$StFeed, "<this>");
        try {
            QQCircleFeedBase$StReportInfoForClient qQCircleFeedBase$StReportInfoForClient = new QQCircleFeedBase$StReportInfoForClient();
            qQCircleFeedBase$StReportInfoForClient.mergeFrom(feedCloudMeta$StFeed.reportInfoForClient.get().toByteArray());
            return qQCircleFeedBase$StReportInfoForClient;
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QFSPublicAccountStaggeredScrollReportHelper", 1, e16, new Object[0]);
            return null;
        }
    }
}
