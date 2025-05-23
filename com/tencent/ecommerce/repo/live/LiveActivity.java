package com.tencent.ecommerce.repo.live;

import android.content.Context;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.biz.live.ui.viewholder.ItemPayload;
import com.tencent.ecommerce.biz.live.ui.viewholder.PayloadType;
import com.tencent.ecommerce.biz.util.ECDateUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u0000 \u00052\u00020\u0001:\u0001\fBi\u0012\u0006\u0010\u0017\u001a\u00020\u000b\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u0010&\u001a\u00020\u001f\u0012\u0006\u0010-\u001a\u00020'\u0012\b\u00104\u001a\u0004\u0018\u00010.\u0012\b\u0010<\u001a\u0004\u0018\u000105\u0012\b\b\u0002\u0010B\u001a\u00020=\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010K\u001a\u00020E\u0012\n\b\u0002\u0010R\u001a\u0004\u0018\u00010L\u00a2\u0006\u0004\bS\u0010TJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0000J\u0010\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\tJ\u0013\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\t\u0010\u0011\u001a\u00020\u000bH\u00d6\u0001R\"\u0010\u0017\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001e\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010&\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010-\u001a\u00020'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u00104\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b/\u00101\"\u0004\b2\u00103R$\u0010<\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010B\u001a\u00020=8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010>\u001a\u0004\b6\u0010?\"\u0004\b@\u0010AR$\u0010D\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010\u0012\u001a\u0004\b \u0010\u0014\"\u0004\bC\u0010\u0016R\"\u0010K\u001a\u00020E8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bF\u0010H\"\u0004\bI\u0010JR$\u0010R\u001a\u0004\u0018\u00010L8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bM\u0010O\"\u0004\bP\u0010Q\u00a8\u0006U"}, d2 = {"Lcom/tencent/ecommerce/repo/live/l;", "", "Lcom/tencent/ecommerce/repo/live/UIStatus;", DomainData.DOMAIN_NAME, "", "k", "remoteActivity", "Lcom/tencent/ecommerce/biz/live/ui/viewholder/h;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "context", "", "a", "other", "equals", "", "hashCode", "toString", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setActivityId", "(Ljava/lang/String;)V", "activityId", "Lcom/tencent/ecommerce/repo/live/a;", "Lcom/tencent/ecommerce/repo/live/a;", "d", "()Lcom/tencent/ecommerce/repo/live/a;", "setActivityPrice", "(Lcom/tencent/ecommerce/repo/live/a;)V", "activityPrice", "Lcom/tencent/ecommerce/repo/live/c;", "c", "Lcom/tencent/ecommerce/repo/live/c;", "g", "()Lcom/tencent/ecommerce/repo/live/c;", "setActivityStock", "(Lcom/tencent/ecommerce/repo/live/c;)V", "activityStock", "Lcom/tencent/ecommerce/repo/live/d;", "Lcom/tencent/ecommerce/repo/live/d;", tl.h.F, "()Lcom/tencent/ecommerce/repo/live/d;", "setActivityTimeRange", "(Lcom/tencent/ecommerce/repo/live/d;)V", "activityTimeRange", "Lcom/tencent/ecommerce/repo/live/b;", "e", "Lcom/tencent/ecommerce/repo/live/b;", "()Lcom/tencent/ecommerce/repo/live/b;", "setActivitySellingPoint", "(Lcom/tencent/ecommerce/repo/live/b;)V", "activitySellingPoint", "", "f", "Ljava/lang/Long;", "getServerTimeStampMs", "()Ljava/lang/Long;", "setServerTimeStampMs", "(Ljava/lang/Long;)V", "serverTimeStampMs", "Lcom/tencent/ecommerce/repo/live/ActivityStatus;", "Lcom/tencent/ecommerce/repo/live/ActivityStatus;", "()Lcom/tencent/ecommerce/repo/live/ActivityStatus;", "l", "(Lcom/tencent/ecommerce/repo/live/ActivityStatus;)V", "activityStatus", "setActivityInfo", "activityInfo", "Lcom/tencent/ecommerce/repo/live/ActivityType;", "i", "Lcom/tencent/ecommerce/repo/live/ActivityType;", "()Lcom/tencent/ecommerce/repo/live/ActivityType;", "setActivityType", "(Lcom/tencent/ecommerce/repo/live/ActivityType;)V", "activityType", "Lcom/tencent/ecommerce/repo/live/j;", "j", "Lcom/tencent/ecommerce/repo/live/j;", "()Lcom/tencent/ecommerce/repo/live/j;", "setFeedSellPoints", "(Lcom/tencent/ecommerce/repo/live/j;)V", "feedSellPoints", "<init>", "(Ljava/lang/String;Lcom/tencent/ecommerce/repo/live/a;Lcom/tencent/ecommerce/repo/live/c;Lcom/tencent/ecommerce/repo/live/d;Lcom/tencent/ecommerce/repo/live/b;Ljava/lang/Long;Lcom/tencent/ecommerce/repo/live/ActivityStatus;Ljava/lang/String;Lcom/tencent/ecommerce/repo/live/ActivityType;Lcom/tencent/ecommerce/repo/live/j;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.repo.live.l, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class LiveActivity {

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private String activityId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private ActivityPrice activityPrice;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private ActivityStock activityStock;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private ActivityTimeRange activityTimeRange;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private ActivitySellingPoint activitySellingPoint;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private Long serverTimeStampMs;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private ActivityStatus activityStatus;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private String activityInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private ActivityType activityType;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private FeedSellingPoints feedSellPoints;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/ecommerce/repo/live/l$a;", "", "Lorg/json/JSONObject;", "activityJson", "Lcom/tencent/ecommerce/repo/live/l;", "a", "b", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.repo.live.l$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LiveActivity a(JSONObject activityJson) {
            String optString = activityJson.optString("activity_id");
            JSONObject optJSONObject = activityJson.optJSONObject("price");
            JSONObject optJSONObject2 = activityJson.optJSONObject("stock");
            JSONObject optJSONObject3 = activityJson.optJSONObject("time_range");
            JSONObject optJSONObject4 = activityJson.optJSONObject(WSPublicAccReport.SOP_NAME_FOCUS);
            long optLong = activityJson.optLong("ts");
            int optInt = activityJson.optInt("status", -1);
            return new LiveActivity(optString, new ActivityPrice(optJSONObject), new ActivityStock(optJSONObject2), new ActivityTimeRange(optJSONObject3), new ActivitySellingPoint(optJSONObject4), Long.valueOf(optLong), ActivityStatus.INSTANCE.a(optInt), activityJson.optString("info"), ActivityType.INSTANCE.a(activityJson.optInt("activity_type", 0)), FeedSellingPoints.INSTANCE.a(activityJson.optJSONObject("feed_selling")));
        }

        public final LiveActivity b(JSONObject activityJson) {
            return new LiveActivity(activityJson.optString("active_id"), null, new ActivityStock(activityJson.optJSONObject("live_stock")), new ActivityTimeRange(activityJson.optJSONObject("live_time_range")), null, null, ActivityStatus.INSTANCE.a(activityJson.optInt("status", -1)), null, null, null, 896, null);
        }
    }

    public LiveActivity(String str, ActivityPrice activityPrice, ActivityStock activityStock, ActivityTimeRange activityTimeRange, ActivitySellingPoint activitySellingPoint, Long l3, ActivityStatus activityStatus, String str2, ActivityType activityType, FeedSellingPoints feedSellingPoints) {
        this.activityId = str;
        this.activityPrice = activityPrice;
        this.activityStock = activityStock;
        this.activityTimeRange = activityTimeRange;
        this.activitySellingPoint = activitySellingPoint;
        this.serverTimeStampMs = l3;
        this.activityStatus = activityStatus;
        this.activityInfo = str2;
        this.activityType = activityType;
        this.feedSellPoints = feedSellingPoints;
    }

    public final String a(Context context) {
        long j3 = 1000;
        long serverTimeMillis = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getTicket().getServerTimeMillis() / j3;
        if (!this.activityTimeRange.d()) {
            return null;
        }
        ActivityTimeRange activityTimeRange = this.activityTimeRange;
        if (serverTimeMillis < activityTimeRange.beginSec || serverTimeMillis > activityTimeRange.getEndSec()) {
            return null;
        }
        return ECDateUtil.f104850a.f(context, (this.activityTimeRange.getEndSec() - serverTimeMillis) * j3);
    }

    /* renamed from: b, reason: from getter */
    public final String getActivityId() {
        return this.activityId;
    }

    /* renamed from: c, reason: from getter */
    public final String getActivityInfo() {
        return this.activityInfo;
    }

    /* renamed from: d, reason: from getter */
    public final ActivityPrice getActivityPrice() {
        return this.activityPrice;
    }

    /* renamed from: e, reason: from getter */
    public final ActivitySellingPoint getActivitySellingPoint() {
        return this.activitySellingPoint;
    }

    /* renamed from: f, reason: from getter */
    public final ActivityStatus getActivityStatus() {
        return this.activityStatus;
    }

    /* renamed from: g, reason: from getter */
    public final ActivityStock getActivityStock() {
        return this.activityStock;
    }

    /* renamed from: h, reason: from getter */
    public final ActivityTimeRange getActivityTimeRange() {
        return this.activityTimeRange;
    }

    public int hashCode() {
        return this.activityId.hashCode();
    }

    /* renamed from: i, reason: from getter */
    public final ActivityType getActivityType() {
        return this.activityType;
    }

    /* renamed from: j, reason: from getter */
    public final FeedSellingPoints getFeedSellPoints() {
        return this.feedSellPoints;
    }

    public final boolean k() {
        if (this.activityType != ActivityType.ACTIVITY_TYPE_LIVE) {
            return false;
        }
        int i3 = m.f105173b[n().ordinal()];
        return i3 == 1 || i3 == 2;
    }

    public final void l(ActivityStatus activityStatus) {
        this.activityStatus = activityStatus;
    }

    public final ItemPayload m(LiveActivity remoteActivity) {
        if (Intrinsics.areEqual(this.activityStock, remoteActivity.activityStock) && this.activityStatus == remoteActivity.activityStatus && Intrinsics.areEqual(this.activityTimeRange, remoteActivity.activityTimeRange)) {
            return new ItemPayload(PayloadType.NoChange, null, 2, null);
        }
        ItemPayload itemPayload = new ItemPayload(PayloadType.UpdateWholeItem, null, 2, null);
        if (n() == UIStatus.UI_STATUS_RUNNING && remoteActivity.activityStatus == ActivityStatus.ACTIVITY_STATUS_RUNNING && (!Intrinsics.areEqual(this.activityStock, remoteActivity.activityStock)) && !remoteActivity.activityStock.d() && !this.activityStock.d()) {
            itemPayload = new ItemPayload(PayloadType.OnlyUpdateStock, null);
        }
        this.activityStock = ActivityStock.b(remoteActivity.activityStock, 0L, 0L, 0L, 7, null);
        if (this.activityStatus != ActivityStatus.ACTIVITY_STATUS_END) {
            this.activityTimeRange = ActivityTimeRange.b(remoteActivity.activityTimeRange, 0L, 0L, 3, null);
            this.activityStatus = remoteActivity.activityStatus;
        }
        return itemPayload;
    }

    public final UIStatus n() {
        if (this.activityType != ActivityType.ACTIVITY_TYPE_LIVE) {
            return UIStatus.UI_STATUS_NONE;
        }
        int i3 = m.f105172a[this.activityStatus.ordinal()];
        if (i3 != 1 && i3 != 2) {
            if (!this.activityTimeRange.d()) {
                return UIStatus.UI_STATUS_NONE;
            }
            long serverTimeMillis = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getTicket().getServerTimeMillis() / 1000;
            ActivityTimeRange activityTimeRange = this.activityTimeRange;
            if (serverTimeMillis < activityTimeRange.beginSec) {
                if (this.activityStatus == ActivityStatus.ACTIVITY_STATUS_UNINITIALIZED) {
                    this.activityStatus = ActivityStatus.ACTIVITY_STATUS_PENDING;
                }
                return UIStatus.UI_STATUS_PENDING;
            }
            if (serverTimeMillis > activityTimeRange.getEndSec()) {
                return UIStatus.UI_STATUS_NONE;
            }
            if (this.activityStatus == ActivityStatus.ACTIVITY_STATUS_UNINITIALIZED) {
                this.activityStatus = ActivityStatus.ACTIVITY_STATUS_RUNNING;
            }
            return UIStatus.UI_STATUS_RUNNING;
        }
        return UIStatus.UI_STATUS_NONE;
    }

    public String toString() {
        return "LiveActivity(activityId=" + this.activityId + ", activityPrice=" + this.activityPrice + ", activityStock=" + this.activityStock + ", activityTimeRange=" + this.activityTimeRange + ", activitySellingPoint=" + this.activitySellingPoint + ", serverTimeStampMs=" + this.serverTimeStampMs + ", activityStatus=" + this.activityStatus + ", activityInfo=" + this.activityInfo + ", activityType=" + this.activityType + ", feedSellPoints=" + this.feedSellPoints + ")";
    }

    public /* synthetic */ LiveActivity(String str, ActivityPrice activityPrice, ActivityStock activityStock, ActivityTimeRange activityTimeRange, ActivitySellingPoint activitySellingPoint, Long l3, ActivityStatus activityStatus, String str2, ActivityType activityType, FeedSellingPoints feedSellingPoints, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, activityPrice, activityStock, activityTimeRange, activitySellingPoint, l3, (i3 & 64) != 0 ? ActivityStatus.ACTIVITY_STATUS_UNINITIALIZED : activityStatus, (i3 & 128) != 0 ? null : str2, (i3 & 256) != 0 ? ActivityType.ACTIVITY_TYPE_LIVE : activityType, (i3 & 512) != 0 ? null : feedSellingPoints);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof LiveActivity) && !(Intrinsics.areEqual(this.activityId, ((LiveActivity) other).activityId) ^ true);
    }
}
