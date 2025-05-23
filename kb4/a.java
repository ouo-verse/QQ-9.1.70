package kb4;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.entry.IEntryApi;
import com.tencent.mobileqq.zplan.ipc.api.IZPlanIPCHelper;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.recommend.main.dress.ui.ZplanDeleteWorkItemEvent;
import com.tencent.sqshow.zootopia.recommend.main.dress.util.ZPlanDressFeedsActionEvent;
import com.tencent.sqshow.zootopia.report.ExtItem;
import com.tencent.sqshow.zootopia.report.MsgBodyContent;
import com.tencent.sqshow.zootopia.report.ReportMsgBean;
import com.tencent.sqshow.zootopia.report.ReportMsgInfo;
import com.tencent.sqshow.zootopia.utils.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b*\u0010+J3\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0016\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0005J5\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0005J\u0006\u0010\u0016\u001a\u00020\u0015J(\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001a\u001a\u00020\u0002J9\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u001e\u0010\"\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 R\u0014\u0010%\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010$Rh\u0010)\u001aV\u0012\u0004\u0012\u00020\u0002\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100&j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0010`'0&j*\u0012\u0004\u0012\u00020\u0002\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100&j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0010`'`'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010(\u00a8\u0006,"}, d2 = {"Lkb4/a;", "", "", "zplanFeedId", "feedId", "", "templateId", QQBrowserActivity.KEY_MSG_TYPE, "Lcom/tencent/sqshow/zootopia/report/ReportMsgBean;", "a", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;I)Lcom/tencent/sqshow/zootopia/report/ReportMsgBean;", "errCode", "", "c", "feedsActionType", "localFakePraiseNum", "", "localFakeHasPraised", "f", "(Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/Boolean;)V", "d", "", "b", "Landroid/content/Context;", "context", "id", "tryOnScheme", "i", "logPrefix", h.F, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ILjava/lang/String;)V", "uin", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "e", "Ljava/util/concurrent/atomic/AtomicLong;", "Ljava/util/concurrent/atomic/AtomicLong;", "msgIdAtomic", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "feedsActionHistoryCache", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a */
    public static final a f411993a = new a();

    /* renamed from: b, reason: from kotlin metadata */
    private static final AtomicLong msgIdAtomic = new AtomicLong(1087650001);

    /* renamed from: c, reason: from kotlin metadata */
    private static final HashMap<String, HashMap<Integer, Boolean>> feedsActionHistoryCache = new HashMap<>();

    a() {
    }

    private final ReportMsgBean a(String zplanFeedId, String feedId, Integer templateId, int r75) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ExtItem("id", zplanFeedId));
        if (templateId != null) {
            arrayList.add(new ExtItem("template_id", String.valueOf(templateId.intValue())));
        }
        if (feedId != null) {
            arrayList.add(new ExtItem("feed_id", feedId));
        }
        ReportMsgInfo reportMsgInfo = new ReportMsgInfo(b(), r75, new MsgBodyContent(w.f373306a.b(), System.currentTimeMillis(), arrayList));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(reportMsgInfo);
        return new ReportMsgBean(arrayList2);
    }

    public final long b() {
        return msgIdAtomic.getAndIncrement();
    }

    public final void c(String feedId, int errCode) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        if (errCode == -22314 || errCode == -22312 || errCode == 3340001 || errCode == 3340010) {
            SimpleEventBus.getInstance().dispatchEvent(new ZplanDeleteWorkItemEvent(feedId));
        }
    }

    public final boolean d(String zplanFeedId, int feedsActionType) {
        HashMap<Integer, Boolean> hashMap;
        Boolean bool;
        Intrinsics.checkNotNullParameter(zplanFeedId, "zplanFeedId");
        HashMap<String, HashMap<Integer, Boolean>> hashMap2 = feedsActionHistoryCache;
        if (hashMap2.containsKey(zplanFeedId)) {
            hashMap = hashMap2.get(zplanFeedId);
        } else {
            HashMap<Integer, Boolean> hashMap3 = new HashMap<>();
            hashMap2.put(zplanFeedId, hashMap3);
            hashMap = hashMap3;
        }
        if (hashMap == null || (bool = hashMap.get(Integer.valueOf(feedsActionType))) == null) {
            bool = Boolean.FALSE;
        }
        if (bool.booleanValue()) {
            return false;
        }
        if (hashMap != null) {
            hashMap.put(Integer.valueOf(feedsActionType), Boolean.TRUE);
        }
        return true;
    }

    public final void e(Context context, String uin, ZootopiaSource sourceCurrent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        Bundle bundle = new Bundle();
        bundle.putString("uid", uin);
        ((IEntryApi) QRoute.api(IEntryApi.class)).startUserCenterFragment(context, sourceCurrent, bundle);
    }

    public final void f(String zplanFeedId, int feedsActionType, Integer localFakePraiseNum, Boolean localFakeHasPraised) {
        Intrinsics.checkNotNullParameter(zplanFeedId, "zplanFeedId");
        QLog.i("ZPLanDressCommonHelper", 1, "notifyActionEvent - " + zplanFeedId + " -" + feedsActionType);
        if (TextUtils.isEmpty(zplanFeedId)) {
            return;
        }
        if (d(zplanFeedId, feedsActionType) || feedsActionType == 5) {
            SimpleEventBus.getInstance().dispatchEvent(new ZPlanDressFeedsActionEvent(zplanFeedId, feedsActionType, localFakePraiseNum, localFakeHasPraised));
        }
    }

    public final void h(String zplanFeedId, String str, Integer num, int i3, String logPrefix) {
        Intrinsics.checkNotNullParameter(zplanFeedId, "zplanFeedId");
        Intrinsics.checkNotNullParameter(logPrefix, "logPrefix");
        ((IZPlanIPCHelper) QRoute.api(IZPlanIPCHelper.class)).eventAndMsgReportApiReportMsg(a(zplanFeedId, str, num, i3));
    }

    public final void i(Context context, String id5, String feedId, String tryOnScheme) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(tryOnScheme, "tryOnScheme");
        QLog.i("ZPLanDressCommonHelper", 1, "tryOnClothes - " + id5 + " - " + tryOnScheme);
        if (TextUtils.isEmpty(tryOnScheme)) {
            QQToast.makeText(context, R.string.xm9, 0).show();
            return;
        }
        ((ISchemeApi) QRoute.api(ISchemeApi.class)).launchScheme(context, tryOnScheme);
        h(id5, feedId, null, 8003, "tryOnClothes");
        g(this, id5, 3, null, null, 12, null);
    }

    public static /* synthetic */ void g(a aVar, String str, int i3, Integer num, Boolean bool, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            num = null;
        }
        if ((i16 & 8) != 0) {
            bool = null;
        }
        aVar.f(str, i3, num, bool);
    }
}
