package kl4;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qqlive.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.SSODebugUtil;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.api.ITimiGameApi;
import com.tencent.timi.game.liveroom.impl.room.pendant.util.a;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003\u00a8\u0006\u0004"}, d2 = {"Lkl4/s;", "", "a", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class s {

    /* renamed from: h, reason: collision with root package name */
    private static boolean f412643h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    private static ck4.a f412644i;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final String f412637b = ht3.a.d("qqlive_tricks_url", "https://qlive.qq.com/cos/live/h5/blessing-bag/menu.html?_bid=5177&loading=dark");

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final String f412638c = ht3.a.d("qqlive_tricks_history_url", "https://qlive.qq.com/cos/live/h5/blessing-bag/user.html?_bid=5177&historyEntrance=1&loading=dark");

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final String f412639d = ht3.a.d("qqlive_live_manage_url", "https://qlive.qq.com/page/h5/room-manage/manage-entrance?_bid=5397&loading=dark&bgColor=ff06011c");

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final String f412640e = ht3.a.d("qqlive_live_bubble_decoration_url", "https://qlive.qq.com/cos/live/h5/dressing-center/index.html?_bid=5409&loading=dark&bgColor=ffffffff&height=0.7");

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final String f412641f = ht3.a.d("qqlive_live_avatar_decorate_url", "https://qlive.qq.com/cos/live/h5/dressing-center/index.html?_bid=5409&loading=dark&bgColor=ffffffff&height=0.7&tab_focus=2");

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final String f412642g = ht3.a.d("qqlive_live_skin_decoration_url", "https://qlive.qq.com/cos/live/h5/dressing-center/index.html?_bid=5409&loading=dark&bgColor=ffffffff&height=0.7&tab_focus=3");

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private static final a f412645j = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005*\u00010\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b8\u00109J;\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J)\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0002H\u0007J\u001c\u0010\u0019\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\b\u0010\u001a\u001a\u00020\u000bH\u0007J\u0006\u0010\u001b\u001a\u00020\u000bR\u0014\u0010\u001c\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0014\u0010 \u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u001dR\u0014\u0010!\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b!\u0010\u001dR\u0014\u0010\"\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001dR\u0014\u0010#\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010\u001dR\u0014\u0010$\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b$\u0010\u001dR\u0014\u0010%\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b%\u0010\u001dR\u0014\u0010&\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010\u001dR\u0014\u0010'\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b'\u0010\u001dR\u0014\u0010(\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b(\u0010\u001dR\u0014\u0010)\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010\u001dR\u0014\u0010+\u001a\u00020*8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020*8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b-\u0010,R\u0014\u0010.\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b.\u0010\u001dR\u0014\u0010/\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010\u001dR\u0014\u00101\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00103\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00106\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006:"}, d2 = {"Lkl4/s$b;", "", "", "url", "", "dpHeight", "", "isRoom", "", "roomId", "anchorUid", "", "c", "(Ljava/lang/String;FZLjava/lang/Long;Ljava/lang/Long;)V", "elementId", tl.h.F, "d", "(ZLjava/lang/Long;Ljava/lang/Long;)V", "e", "(Ljava/lang/Long;)V", "f", "reportEventId", "b", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "i", "a", "g", "AVATAR_DECORATION_TEST_URL", "Ljava/lang/String;", "AVATAR_DECORATION_URL", "BUBBLE_DECORATION_TEST_URL", "BUBBLE_DECORATION_URL", "DRESS_CENTER_ELEMENT_ID", "LIVE_MANAGE_TEST_URL", "LIVE_MANAGE_URL", "QUICK_DRESS_ELEMENT_ID", "SKIN_DECORATION_TEST_URL", "SKIN_DECORATION_URL", "TAG", "TRICKS_HISTORY_TEST_URL", "TRICKS_HISTORY_URL", "", "TRICKS_OFFLINE_BID", "I", "TRICKS_POPUP_OFFLINE_BID", "TRICKS_TEST_URL", "TRICKS_URL", "kl4/s$a", "callback", "Lkl4/s$a;", "isPreloadBid", "Z", "Lck4/a;", "showDialogHelper", "Lck4/a;", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: kl4.s$b, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x00df  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00d1  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void c(String url, float dpHeight, boolean isRoom, Long roomId, Long anchorUid) {
            int i3;
            String str;
            int i16;
            float f16;
            com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
            int q16 = cVar.q();
            long G = cVar.G();
            int i17 = 0;
            if (anchorUid != null && G == anchorUid.longValue()) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            String str2 = (url + "&room_id=" + roomId + "&room_type=" + q16 + "&appid=" + QQLiveSDKConfigHelper.getSceneIdByRoomType(q16) + "&anchor_id=" + anchorUid) + "&isAnchor=" + i3;
            if (!isRoom) {
                str = "&front=1";
            } else {
                str = "&fromSetting=1";
            }
            String str3 = str2 + str;
            ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#ff06011c"));
            QBaseActivity b16 = vf4.a.b();
            a.C9947a a16 = com.tencent.timi.game.liveroom.impl.room.pendant.util.a.a(str3);
            Map<String, String> map = a16.f378190b;
            if (map != null) {
                if (map.get("height") != null) {
                    try {
                        i16 = x.h(b16, x.f(b16).f185861b);
                    } catch (Exception unused) {
                        i16 = 0;
                    }
                    try {
                        i17 = x.h(b16, x.f(b16).f185860a);
                        String str4 = a16.f378190b.get("height");
                        Intrinsics.checkNotNull(str4);
                        f16 = Float.parseFloat(str4);
                    } catch (Exception unused2) {
                        QLog.e("unknown|TricksViewClick", 1, "parseFloat error");
                        f16 = 1.0f;
                        if (i16 <= i17) {
                        }
                        dpHeight = i16 * f16;
                        if (a16.f378190b.get("bgColor") != null) {
                        }
                        com.tencent.timi.game.liveroom.impl.room.livewebdialog.e.k(b16, x.c(b16, dpHeight), colorDrawable, str3);
                    }
                    if (i16 <= i17) {
                        i16 = i17;
                    }
                    dpHeight = i16 * f16;
                }
                if (a16.f378190b.get("bgColor") != null) {
                    String str5 = a16.f378190b.get("bgColor");
                    if (!TextUtils.isEmpty(str5)) {
                        try {
                            colorDrawable = new ColorDrawable(Color.parseColor("#" + str5));
                        } catch (Exception unused3) {
                            QLog.e("unknown|TricksViewClick", 1, "onClickInner, parse bgColor error");
                        }
                    }
                }
            }
            com.tencent.timi.game.liveroom.impl.room.livewebdialog.e.k(b16, x.c(b16, dpHeight), colorDrawable, str3);
        }

        private final void h(String elementId) {
            HashMap hashMap = new HashMap();
            hashMap.put("dt_eid", elementId);
            com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
            if (cVar.J(cVar.p(), 1)) {
                hashMap.putAll(tk4.d.f436481a.d());
                hashMap.put("dt_pgid", IMultiAvChatReporter.PageId.ANCHOR_PAGE_ID);
            } else {
                hashMap.putAll(tk4.d.f436481a.f());
                hashMap.put("dt_pgid", IMultiAvChatReporter.PageId.AUDIENCE_PAGE_ID);
            }
            ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().reportEvent("dt_clck", hashMap);
        }

        @JvmStatic
        public final void a() {
            ck4.a aVar = s.f412644i;
            if (aVar != null) {
                aVar.a();
            }
            s.f412644i = null;
        }

        @JvmStatic
        public final void b(@NotNull String reportEventId) {
            String str;
            Intrinsics.checkNotNullParameter(reportEventId, "reportEventId");
            if (!SSODebugUtil.isTestEnv()) {
                str = s.f412640e;
            } else {
                str = "https://tde.qlive.qq.com/cos/live/h5/dressing-center/index.html?_tde_id=6881&loading=dark&bgColor=ffffffff&height=0.7";
            }
            com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
            c(str, 0.0f, true, Long.valueOf(cVar.p()), Long.valueOf(com.tencent.mobileqq.qqlive.sail.c.l(cVar, cVar.p(), 0, 2, null)));
            h(reportEventId);
        }

        public final void d(boolean isRoom, @Nullable Long roomId, @Nullable Long anchorUid) {
            if (SSODebugUtil.isTestEnv()) {
                c("https://tde.qlive.qq.com/cos/live/h5/blessing-bag/menu.html?_tde_id=6881&loading=dark", 390.0f, isRoom, roomId, anchorUid);
            } else {
                c(s.f412637b, 390.0f, isRoom, roomId, anchorUid);
            }
        }

        public final void e(@Nullable Long roomId) {
            long j3;
            if (roomId != null) {
                roomId.longValue();
                j3 = com.tencent.mobileqq.qqlive.sail.c.l(com.tencent.mobileqq.qqlive.sail.c.f272176a, roomId.longValue(), 0, 2, null);
            } else {
                j3 = 0;
            }
            if (SSODebugUtil.isTestEnv()) {
                c("https://tde.qlive.qq.com/cos/live/h5/blessing-bag/user.html?_tde_id=6881&historyEntrance=1&loading=dark", 532.0f, true, roomId, Long.valueOf(j3));
            } else {
                c(s.f412638c, 532.0f, true, roomId, Long.valueOf(j3));
            }
        }

        @JvmStatic
        public final void f(long roomId) {
            if (SSODebugUtil.isTestEnv()) {
                c("https://tde.qlive.qq.com/page/h5/room-manage/manage-entrance?_bid=5397&loading=dark&bgColor=ff06011c", 250.0f, true, Long.valueOf(roomId), Long.valueOf(com.tencent.mobileqq.qqlive.sail.c.l(com.tencent.mobileqq.qqlive.sail.c.f272176a, roomId, 0, 2, null)));
            } else {
                c(s.f412639d, 250.0f, true, Long.valueOf(roomId), Long.valueOf(com.tencent.mobileqq.qqlive.sail.c.l(com.tencent.mobileqq.qqlive.sail.c.f272176a, roomId, 0, 2, null)));
            }
        }

        public final void g() {
            AppInterface a16;
            if (!s.f412643h && (a16 = com.tencent.mobileqq.qqlive.utils.g.a()) != null) {
                s.f412643h = true;
                AegisLogger.INSTANCE.i("unknown|TricksViewClick", "preloadOfflineBid", "checkUpByBusinessIdWithRightUnzip, bid1=5177, bid2=5303");
                HtmlOffline.k("5177", a16, s.f412645j, true, 0, true);
                HtmlOffline.k("5303", a16, s.f412645j, true, 0, true);
            }
        }

        @JvmStatic
        public final void i(@Nullable Activity activity, @Nullable String url) {
            AegisLogger.INSTANCE.i("unknown|TricksViewClick", "showH5PopupDialog", "activity=" + activity + ", url=" + url);
            if (activity == null || TextUtils.isEmpty(url)) {
                return;
            }
            if (s.f412644i == null) {
                s.f412644i = new ck4.a();
            }
            ck4.a aVar = s.f412644i;
            Intrinsics.checkNotNull(aVar);
            aVar.e(activity, url);
        }

        Companion() {
        }
    }

    @JvmStatic
    public static final void j() {
        INSTANCE.a();
    }

    @JvmStatic
    public static final void k(long j3) {
        INSTANCE.f(j3);
    }

    @JvmStatic
    public static final void l(@Nullable Activity activity, @Nullable String str) {
        INSTANCE.i(activity, str);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"kl4/s$a", "Lcom/tencent/biz/common/offline/a;", "", "param1", "", "code", "", "loaded", "progress", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements com.tencent.biz.common.offline.a {
        a() {
        }

        @Override // com.tencent.biz.common.offline.a
        public void loaded(@Nullable String param1, int code) {
            AegisLogger.INSTANCE.i("unknown|TricksViewClick", "AsyncBack", "offline url loaded bid=" + param1 + " code = " + code);
        }

        @Override // com.tencent.biz.common.offline.a
        public void progress(int progress) {
        }
    }
}
