package com.qzone.common.business.service;

import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.protocol.request.QZoneJoinActivityRequest;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.publish.business.protocol.QZonePublishMoodRequest;
import com.qzone.reborn.event.QZoneHolidayRefreshFeedEvent;
import com.qzone.reborn.event.QZoneOpenHalfWebViewEvent;
import com.qzone.reborn.runtime.QZoneRuntime;
import com.qzone.reborn.util.i;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.MobileQQ;
import qzone.QzoneActivityPB$JoinActivityRsp;
import qzone.QzoneActivityPB$KVInfo;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0016\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002J \u0010\u0012\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J,\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0007\u00a8\u0006\u001a"}, d2 = {"Lcom/qzone/common/business/service/d;", "", "", "feedKey", "", "d", "f", h.F, "Lcom/qzone/common/business/task/QZoneTask;", "task", "scene", "", "i", "clientKey", "", "type", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "g", "", "Lqzone/QzoneActivityPB$KVInfo;", "kvInfo", "k", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class d {

    /* renamed from: b, reason: collision with root package name */
    private static d f45807b;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    private static CopyOnWriteArraySet<String> f45808c = new CopyOnWriteArraySet<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0007R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\bR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\bR\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\bR\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\bR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/qzone/common/business/service/d$a;", "", "", "clientKey", "b", "Lcom/qzone/common/business/service/d;", "a", "ALBUM", "Ljava/lang/String;", "COMMENT", "HOLIDAY_SHUOSHUO", "HONGBAO_KEY", "LIKE", "MMKV_KEY_PRIX", "SHUOSHUO", "TAG", "USER_ACTIVITY_KEY", "Ljava/util/concurrent/CopyOnWriteArraySet;", "currentRequestFeeds", "Ljava/util/concurrent/CopyOnWriteArraySet;", "sInstance", "Lcom/qzone/common/business/service/d;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.common.business.service.d$a, reason: from kotlin metadata */
    /* loaded from: classes39.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final d a() {
            if (d.f45807b == null) {
                synchronized (Reflection.getOrCreateKotlinClass(d.class)) {
                    if (d.f45807b == null) {
                        d.f45807b = new d();
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            d dVar = d.f45807b;
            Intrinsics.checkNotNull(dVar);
            return dVar;
        }

        public final String b(String clientKey) {
            return clientKey + "_holiday_shuoshuo_" + LoginData.getInstance().getUin();
        }

        Companion() {
        }
    }

    private final boolean d(String feedKey) {
        return !i.b().d(f(feedKey), false);
    }

    @JvmStatic
    public static final d e() {
        return INSTANCE.a();
    }

    private final String f(String feedKey) {
        return "qzone_holiday_feed_triggered_" + feedKey + "_" + LoginData.getInstance().getUin();
    }

    private final boolean h() {
        return com.tencent.mobileqq.service.qzone.e.f286406a.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(String str, d this$0, BaseRequest baseRequest, boolean z16, long j3, String str2, QzoneActivityPB$JoinActivityRsp qzoneActivityPB$JoinActivityRsp) {
        float f16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        f45808c.remove(str);
        if ((!QZoneRuntime.j().m() && MobileQQ.sProcessId != 2) || (lc.b.d() && !QZoneRuntime.j().m())) {
            com.tencent.xaction.log.b.a("QZoneHolidayService", 1, "current is not in QZone");
            return;
        }
        if (z16) {
            com.tencent.xaction.log.b.a("QZoneHolidayService", 1, "show_mode:" + qzoneActivityPB$JoinActivityRsp.show_mode.get());
            if (!(TextUtils.equals("hongbao", qzoneActivityPB$JoinActivityRsp.show_mode.get()) && this$0.d(str)) && TextUtils.equals("useractivity", qzoneActivityPB$JoinActivityRsp.show_mode.get())) {
                float f17 = qzoneActivityPB$JoinActivityRsp.float_height.get();
                if (f17 <= 0.0f || f17 > 1.0f) {
                    f16 = LoginData.getInstance().isQzoneVip() ? 0.77f : 0.59f;
                } else {
                    f16 = f17;
                }
                com.tencent.xaction.log.b.a("QZoneHolidayService", 1, "show mode is user activity, rsp height ratio is " + f17 + ", height ratio is " + f16 + ", is_refresh_feed is " + qzoneActivityPB$JoinActivityRsp.is_refresh_feed.get());
                SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                String str3 = qzoneActivityPB$JoinActivityRsp.jump_url.get();
                Intrinsics.checkNotNullExpressionValue(str3, "rsp.jump_url.get()");
                simpleEventBus.dispatchEvent(new QZoneOpenHalfWebViewEvent(str3, false, f16));
                if (qzoneActivityPB$JoinActivityRsp.is_refresh_feed.get()) {
                    SimpleEventBus.getInstance().dispatchEvent(new QZoneHolidayRefreshFeedEvent());
                    return;
                }
                return;
            }
            return;
        }
        com.tencent.xaction.log.b.a("QZoneHolidayService", 1, "QZoneJoinActivityRequest is fail, retCode:" + j3 + ", errMsg:" + str2);
    }

    public final void g(String clientKey, int type, BusinessFeedData feedData) {
        String str;
        Intrinsics.checkNotNullParameter(clientKey, "clientKey");
        String j3 = i.b().j(INSTANCE.b(clientKey), "");
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(j3)) {
            QzoneActivityPB$KVInfo qzoneActivityPB$KVInfo = new QzoneActivityPB$KVInfo();
            qzoneActivityPB$KVInfo.key.set(QZonePublishMoodRequest.KEY_INFO_HOLIDAY_PUBLISH, true);
            qzoneActivityPB$KVInfo.val.set(j3, true);
            arrayList.add(qzoneActivityPB$KVInfo);
        }
        if (type == 1) {
            str = LpReportInfoConfig.RESERVE_DELETE_FEED_TYPE_SHUOSHUO;
        } else {
            str = "album";
        }
        k(str, ef.b.a(feedData), arrayList);
    }

    public final void i(QZoneTask task, String scene) {
        String str;
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(scene, "scene");
        if (h() && task.mResultCode == 0) {
            Object parameter = task.getParameter("feeddata");
            if (parameter instanceof BusinessFeedData) {
                str = ef.b.a((BusinessFeedData) parameter);
            } else {
                str = (String) task.getParameter("uniKey");
            }
            String str2 = str;
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            if (!Intrinsics.areEqual(scene, "like") || Intrinsics.areEqual(task.getParameter("isLike"), Boolean.TRUE)) {
                l(this, scene, str2, null, 4, null);
            }
        }
    }

    public final void j(String scene, String str) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        l(this, scene, str, null, 4, null);
    }

    public final void k(String scene, final String feedKey, List<QzoneActivityPB$KVInfo> kvInfo) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        if (h() && !TextUtils.isEmpty(scene) && d(feedKey) && !TextUtils.isEmpty(feedKey) && !f45808c.contains(feedKey)) {
            com.tencent.xaction.log.b.a("QZoneHolidayService", 1, "success scene:" + scene + ", request:" + feedKey);
            if (feedKey != null) {
                f45808c.add(feedKey);
            }
            VSNetworkHelper.getInstance().sendRequest(new QZoneJoinActivityRequest(scene, feedKey, "", kvInfo), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.qzone.common.business.service.c
                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                    d.m(feedKey, this, baseRequest, z16, j3, str, (QzoneActivityPB$JoinActivityRsp) obj);
                }
            });
            return;
        }
        com.tencent.xaction.log.b.a("QZoneHolidayService", 1, "can not trigger lottery");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void l(d dVar, String str, String str2, List list, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            list = null;
        }
        dVar.k(str, str2, list);
    }
}
