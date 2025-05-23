package com.tencent.state.square.feeds;

import android.app.Application;
import android.content.Context;
import com.tencent.state.service.VasSquareQZoneService;
import com.tencent.state.square.EntranceLink;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.guide.GuideContext;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012JM\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\f2\b\b\u0002\u0010\u001a\u001a\u00020\f\u00a2\u0006\u0002\u0010\u001bJ\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\u001e\u001a\u00020\u00102\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00100 J\u0016\u0010!\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0004J$\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\f2\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0010\u0018\u00010 R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/tencent/state/square/feeds/SquareQZoneFeedsManager;", "", "()V", "DEFAULT_QZONE_HOME_PAGE_URL", "", "FROM_AVATAR_DETAIL", "", "FROM_SQUARE_BUBBLE", "TAG", "URL_SLOT_FROM_UIN", "URL_SLOT_UIN", "canOthersSeeMyQZoneFeeds", "", "hadJumpedToQZone", "Ljava/util/concurrent/atomic/AtomicBoolean;", "checkAndShowQZonePrivacyDialog", "", "context", "Landroid/content/Context;", "doJumpToQZone", "uin", "", "url", "from", "feedsId", "needRecord", "needReport", "(Landroid/content/Context;Ljava/lang/Long;Ljava/lang/String;ILjava/lang/String;ZZ)Z", "getQZoneHomePageUrl", "fromUin", "queryQZonePrivacy", "callback", "Lkotlin/Function1;", "reportFeedsBubbleExpose", "updateQZonePrivacy", "enable", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareQZoneFeedsManager {
    public static final String DEFAULT_QZONE_HOME_PAGE_URL = "mqzone://arouse/homepage?uin={uin}&from_uin={from_uin}";
    public static final int FROM_AVATAR_DETAIL = 2;
    public static final int FROM_SQUARE_BUBBLE = 1;
    private static final String TAG = "SquareQZoneFeedsManager";
    private static final String URL_SLOT_FROM_UIN = "{from_uin}";
    private static final String URL_SLOT_UIN = "{uin}";
    private static boolean canOthersSeeMyQZoneFeeds;
    public static final SquareQZoneFeedsManager INSTANCE = new SquareQZoneFeedsManager();
    private static final AtomicBoolean hadJumpedToQZone = new AtomicBoolean(false);

    SquareQZoneFeedsManager() {
    }

    public final void checkAndShowQZonePrivacyDialog(Context context) {
        if (!GuideContext.INSTANCE.hasCheckedCreateRoleGuide()) {
            SquareBaseKt.getSquareLog().i(TAG, "checkAndShowQZonePrivacyDialog cancel by guide");
        } else {
            if (context == null || !hadJumpedToQZone.compareAndSet(true, false)) {
                return;
            }
            SquareBaseKt.getSquareThread().postOnFileThread(new SquareQZoneFeedsManager$checkAndShowQZonePrivacyDialog$1(context));
        }
    }

    public final void queryQZonePrivacy(Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        VasSquareQZoneService.INSTANCE.queryQZonePrivacyStatus(new SquareQZoneFeedsManager$queryQZonePrivacy$1(callback));
    }

    public final void reportFeedsBubbleExpose(long uin, String feedsId) {
        Intrinsics.checkNotNullParameter(feedsId, "feedsId");
        VasSquareQZoneService.reportQZoneBubbleExposure$default(VasSquareQZoneService.INSTANCE, feedsId, uin, null, 4, null);
    }

    public final void updateQZonePrivacy(boolean enable, Function1<? super Boolean, Unit> callback) {
        SquareBaseKt.getSquareLog().d(TAG, "updateQZonePrivacy enable:" + enable + ", old:" + canOthersSeeMyQZoneFeeds);
        VasSquareQZoneService.INSTANCE.setQZonePrivacyStatus(enable, new SquareQZoneFeedsManager$updateQZonePrivacy$1(enable, callback));
    }

    public final String getQZoneHomePageUrl(String uin, String fromUin) {
        String replace$default;
        String replace$default2;
        boolean isBlank;
        if (!(uin == null || uin.length() == 0)) {
            if (!(fromUin == null || fromUin.length() == 0)) {
                String qZoneHomePageUrl = Square.INSTANCE.getConfig().getCommonUtils().getQZoneHomePageUrl();
                String str = DEFAULT_QZONE_HOME_PAGE_URL;
                if (qZoneHomePageUrl != null) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(qZoneHomePageUrl);
                    if (isBlank) {
                        qZoneHomePageUrl = DEFAULT_QZONE_HOME_PAGE_URL;
                    }
                    str = qZoneHomePageUrl;
                }
                replace$default = StringsKt__StringsJVMKt.replace$default(str, URL_SLOT_UIN, uin, false, 4, (Object) null);
                replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, URL_SLOT_FROM_UIN, fromUin, false, 4, (Object) null);
                SquareBaseKt.getSquareLog().d(TAG, "getQZoneHomePageUrl url:" + replace$default2);
                return replace$default2;
            }
        }
        Square square = Square.INSTANCE;
        Application application = square.getApplication();
        if (application != null) {
            square.getConfig().getCommonUtils().showToast(application, "\u8df3\u8f6c\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", 1);
        }
        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "getQZoneHomePageUrl error! uin:" + uin + " fromUin:" + fromUin, null, 4, null);
        return null;
    }

    public final boolean doJumpToQZone(Context context, Long uin, String url, int from, String feedsId, boolean needRecord, boolean needReport) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(feedsId, "feedsId");
        SquareBaseKt.getSquareLog().d(TAG, "doJumpToQZone from:" + from + ", feedsId:" + feedsId + ", uin:" + uin + ", url:" + url);
        if (uin != null) {
            if (!(url == null || url.length() == 0)) {
                Square.INSTANCE.getConfig().getRouter().routeLink(context, new EntranceLink(url, 2));
                if (needReport) {
                    VasSquareQZoneService.reportQZoneBubbleClick$default(VasSquareQZoneService.INSTANCE, feedsId, uin.longValue(), from, null, 8, null);
                }
                return true;
            }
        }
        Square.INSTANCE.getConfig().getCommonUtils().showToast(context, "\u8df3\u8f6c\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", 1);
        return false;
    }
}
