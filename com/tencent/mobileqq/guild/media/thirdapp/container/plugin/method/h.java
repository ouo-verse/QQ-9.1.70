package com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.google.gson.Gson;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.media.thirdapp.container.plugin.c;
import com.tencent.mobileqq.guild.robot.api.model.GuildChannel;
import com.tencent.mobileqq.guild.robot.components.auth.RobotAuthorizeAddFragment;
import com.tencent.mobileqq.guild.robot.components.console.RobotInfo;
import com.tencent.mobileqq.guild.robot.components.guilds.RobotCommonGuildFragment;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.bv;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotData;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotInfoReq;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotInfoRsp;
import com.tencent.qqnt.kernel.nativeinterface.IGProFetchGuildRobotInfoCallback;
import com.tencent.util.UiThreadUtil;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u001c\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\"\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0016\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/method/h;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/method/o;", "", "robotAppIdStr", "Lcom/tencent/mobileqq/guild/robot/components/console/RobotInfo;", "p", "Lcom/tencent/qqnt/kernel/nativeinterface/GProGuildRobotInfoRsp;", "infoReply", "robotInfo", "Lvw1/d;", "authorizeCallback", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "t", HippyTKDListViewAdapter.X, "", "code", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "b", "url", "Lorg/json/JSONObject;", "args", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/c;", "callback", "c", "<init>", "()V", "d", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class h extends o {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final Map<Integer, Integer> f229335e;

    static {
        Map<Integer, Integer> mapOf;
        Integer valueOf = Integer.valueOf(AppConstants.VALUE.UIN_TYPE_OFFICE_OPEN);
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(0, 0), TuplesKt.to(valueOf, valueOf), TuplesKt.to(-2, 9990), TuplesKt.to(32004, 9999));
        f229335e = mapOf;
    }

    private final void A(int code) {
        boolean z16;
        int i3;
        if (code == -2) {
            return;
        }
        Context i16 = ch.i();
        int i17 = 1;
        if (code == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            i17 = 2;
        }
        if (code != 0) {
            if (code != 9998) {
                if (code != 10032) {
                    i3 = R.string.f154591f8;
                } else {
                    i3 = R.string.f153371bx;
                }
            } else {
                i3 = R.string.f15122174;
            }
        } else {
            i3 = R.string.f154601f9;
        }
        QQToast.makeText(i16, i17, i3, 0).show();
    }

    private final RobotInfo p(String robotAppIdStr) {
        long b16 = bv.b(e().getStartParams().getGuildId(), 0L);
        long b17 = bv.b(e().getStartParams().getChannelId(), 0L);
        long b18 = bv.b(robotAppIdStr, 0L);
        RobotInfo robotInfo = new RobotInfo();
        robotInfo.p(b16);
        robotInfo.n(b17);
        robotInfo.m(b18);
        robotInfo.o(2);
        return robotInfo;
    }

    private final void q(GProGuildRobotInfoRsp infoReply, final RobotInfo robotInfo, final vw1.d authorizeCallback) {
        Context context;
        WeakReference<Activity> a16 = e().a();
        FragmentActivity fragmentActivity = null;
        if (a16 != null) {
            context = (Activity) a16.get();
        } else {
            context = null;
        }
        if (context instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) context;
        }
        final FragmentActivity fragmentActivity2 = fragmentActivity;
        if (fragmentActivity2 == null) {
            return;
        }
        final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        GProGuildRobotData gProGuildRobotData = infoReply.robotData;
        robotInfo.s(gProGuildRobotData.robotName);
        int i3 = gProGuildRobotData.status;
        int i16 = gProGuildRobotData.robotRole;
        Logger.f235387a.d().d("AddRobotMethod", 1, "robot appId " + gProGuildRobotData.appid + " name " + robotInfo.j() + " robotStatus " + i3 + ", robotRole " + i16);
        robotInfo.u(gProGuildRobotData.robotUin);
        if (robotInfo.k() == 0) {
            robotInfo.t(gProGuildRobotData.robotTid);
        }
        robotInfo.q(gProGuildRobotData.robotAvatar);
        robotInfo.r(gProGuildRobotData.robotDesc);
        Gson gson = new Gson();
        Bundle bundle = new Bundle();
        bundle.putString("ROBOT_INFO_KEY", gson.toJson(robotInfo));
        final GuildChannel guildChannel = new GuildChannel();
        guildChannel.e(robotInfo.e());
        guildChannel.c(robotInfo.b());
        new RobotCommonGuildFragment().setArguments(bundle);
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.f
            @Override // java.lang.Runnable
            public final void run() {
                h.r(FragmentActivity.this, peekAppRuntime, guildChannel, robotInfo, authorizeCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(FragmentActivity fragmentActivity, AppRuntime appRuntime, GuildChannel guildChannel, RobotInfo robotInfo, final vw1.d dVar) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "$fragmentActivity");
        Intrinsics.checkNotNullParameter(guildChannel, "$guildChannel");
        Intrinsics.checkNotNullParameter(robotInfo, "$robotInfo");
        RobotAuthorizeAddFragment.Jh(fragmentActivity, appRuntime, guildChannel, robotInfo, null, new vw1.d() { // from class: com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.g
            @Override // vw1.d
            public final void a(int i3, String str) {
                h.s(vw1.d.this, i3, str);
            }
        }, "mediaOpen");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(vw1.d dVar, int i3, String str) {
        Logger.f235387a.d().d("AddRobotMethod", 1, "RobotAuthorizeAddFragment.show code " + i3 + ", message " + str);
        if (dVar != null) {
            dVar.a(i3, str);
        }
    }

    private final boolean t(Activity activity) {
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(final h this$0, final com.tencent.mobileqq.guild.media.thirdapp.container.plugin.c callback, final int i3, final String str) {
        int i16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Integer num = f229335e.get(Integer.valueOf(i3));
        if (num != null) {
            i16 = num.intValue();
        } else {
            i16 = -1;
        }
        final int i17 = i16;
        Logger.f235387a.d().d("AddRobotMethod", 1, "onAuthorized, code " + i3 + ", ret " + i17 + ", message " + str);
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.c
            @Override // java.lang.Runnable
            public final void run() {
                h.v(h.this, i3, callback, i17, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(h this$0, int i3, com.tencent.mobileqq.guild.media.thirdapp.container.plugin.c callback, int i16, String str) {
        Activity activity;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        WeakReference<Activity> a16 = this$0.e().a();
        if (a16 != null) {
            activity = a16.get();
        } else {
            activity = null;
        }
        if (this$0.t(activity)) {
            return;
        }
        this$0.A(i3);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ret", i16);
        jSONObject.put("msg", "code(" + i3 + ") " + str);
        c.a.a(callback, jSONObject, false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(h this$0, String robotAppId, vw1.d authorizeCallback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(robotAppId, "$robotAppId");
        Intrinsics.checkNotNullParameter(authorizeCallback, "$authorizeCallback");
        this$0.x(this$0.p(robotAppId), authorizeCallback);
    }

    private final void x(final RobotInfo robotInfo, final vw1.d authorizeCallback) {
        Context context;
        boolean m06 = ch.m0(String.valueOf(robotInfo.e()));
        Logger.f235387a.d().d("AddRobotMethod", 1, "requestRobotInfo robotAppId " + robotInfo.a() + " isAdmin: " + m06);
        if (!m06) {
            if (authorizeCallback != null) {
                authorizeCallback.a(AppConstants.VALUE.UIN_TYPE_OFFICE_OPEN, "not admin");
                return;
            }
            return;
        }
        WeakReference<Activity> a16 = e().a();
        FragmentActivity fragmentActivity = null;
        if (a16 != null) {
            context = (Activity) a16.get();
        } else {
            context = null;
        }
        if (context instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) context;
        }
        if (fragmentActivity == null) {
            if (authorizeCallback != null) {
                authorizeCallback.a(-1, "");
            }
        } else {
            if (robotInfo.a() > 0) {
                GProGuildRobotInfoReq gProGuildRobotInfoReq = new GProGuildRobotInfoReq(robotInfo.e(), robotInfo.l(), robotInfo.k(), robotInfo.b(), sx1.f.d(), 0, robotInfo.c(), robotInfo.a());
                ac g16 = sx1.f.g();
                if (g16 != null) {
                    g16.fetchGuildRobotInfo(gProGuildRobotInfoReq, new IGProFetchGuildRobotInfoCallback() { // from class: com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.d
                        @Override // com.tencent.qqnt.kernel.nativeinterface.IGProFetchGuildRobotInfoCallback
                        public final void onFetchGuildRobotInfo(int i3, String str, GProGuildRobotInfoRsp gProGuildRobotInfoRsp) {
                            h.y(h.this, robotInfo, authorizeCallback, i3, str, gProGuildRobotInfoRsp);
                        }
                    });
                    return;
                }
                return;
            }
            if (authorizeCallback != null) {
                authorizeCallback.a(-1, "robotAppId invalid!");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(h this$0, RobotInfo robotInfo, final vw1.d dVar, final int i3, final String str, GProGuildRobotInfoRsp gProGuildRobotInfoRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(robotInfo, "$robotInfo");
        if (i3 == 0 && gProGuildRobotInfoRsp != null) {
            this$0.q(gProGuildRobotInfoRsp, robotInfo, dVar);
            return;
        }
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str2 = "getRobotInfo errCode:" + i3 + " msg:" + str;
        if (str2 instanceof String) {
            bVar.a().add(str2);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("AddRobotMethod", 1, (String) it.next(), null);
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.e
            @Override // java.lang.Runnable
            public final void run() {
                h.z(vw1.d.this, i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(vw1.d dVar, int i3, String str) {
        if (dVar != null) {
            dVar.a(i3, str);
        }
    }

    @Override // com.tencent.mobileqq.guild.media.thirdapp.container.plugin.b
    @NotNull
    public String b() {
        return "addRobot";
    }

    @Override // com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.o, com.tencent.mobileqq.guild.media.thirdapp.container.plugin.b
    public boolean c(@NotNull String url, @Nullable JSONObject args, @NotNull final com.tencent.mobileqq.guild.media.thirdapp.container.plugin.c callback) {
        final String str;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Logger.f235387a.d().d("AddRobotMethod", 1, "onInvoke args " + args);
        final vw1.d dVar = new vw1.d() { // from class: com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.a
            @Override // vw1.d
            public final void a(int i3, String str2) {
                h.u(h.this, callback, i3, str2);
            }
        };
        if (args != null) {
            str = args.optString("bot_app_id");
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        isBlank = StringsKt__StringsJVMKt.isBlank(str);
        if (isBlank) {
            dVar.a(-1, "robotAppId invalid!");
            return true;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.b
            @Override // java.lang.Runnable
            public final void run() {
                h.w(h.this, str, dVar);
            }
        }, 16, null, false);
        return super.c(url, args, callback);
    }
}
