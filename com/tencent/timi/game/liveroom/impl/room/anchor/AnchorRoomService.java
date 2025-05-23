package com.tencent.timi.game.liveroom.impl.room.anchor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivityForTool;
import com.tencent.mobileqq.qqlive.api.room.ILiveTPPlayerRoom;
import com.tencent.mobileqq.qqlive.api.timi.ITimiAnchor;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.qqlive.login.LiveLoginInfo;
import com.tencent.mobileqq.qqlive.widget.chat.message.LiveLocalMsg;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.timi.game.databasecore.impl.YesDataBaseHelper;
import com.tencent.timi.game.jump.api.impl.qqlive.TgSchemeProxyFragment;
import com.tencent.timi.game.liveroom.impl.ipc.TGLiveClientQIPCModule;
import com.tencent.timi.game.liveroom.impl.room.audience.record.TGLiveRecordEntity;
import com.tencent.timi.game.liveroom.impl.room.audience.reddot.bean.TimiAudienceRedDotInfo;
import com.tencent.timi.game.liveroom.impl.test.TgLiveRoomOneKeyLiveTestFragment;
import com.tencent.timi.game.liveroom.impl.test.TgLiveRoomTestFragment;
import java.net.URLEncoder;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes26.dex */
public class AnchorRoomService implements ni4.a {

    /* renamed from: b, reason: collision with root package name */
    private static IAegisLogApi f377364b = (IAegisLogApi) QRoute.api(IAegisLogApi.class);

    /* renamed from: a, reason: collision with root package name */
    private final nf4.e f377365a = zj4.b.e();

    private static String N3(String str, String str2) {
        String str3;
        if (!TextUtils.isEmpty(str2) && !str.contains("gamelive_custom_params")) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("actionCmd", str2);
                str3 = URLEncoder.encode(jSONObject.toString(), "UTF-8");
            } catch (Exception e16) {
                f377364b.e("AnchorRoomService", "appendCustomParamsToScheme error" + e16);
                str3 = "";
            }
            if (!TextUtils.isEmpty(str3)) {
                return str + ContainerUtils.FIELD_DELIMITER + "gamelive_custom_params" + ContainerUtils.KEY_VALUE_DELIMITER + str3;
            }
            return str;
        }
        return str;
    }

    @Override // ni4.a
    public boolean D0(boolean z16) {
        if (((ILiveTPPlayerRoom) ((jg4.b) mm4.b.b(jg4.b.class)).N(0L)) != null) {
            com.tencent.timi.game.liveroom.impl.room.medal.f.f377988a.b("key_webview_mute", z16);
            return true;
        }
        return false;
    }

    @Override // ni4.a
    public nf4.h D1() {
        return qi4.a.f428963a;
    }

    @Override // ni4.a
    public void L() {
        QPublicFragmentActivityForTool.start(vf4.a.b(), new Intent(), TgLiveRoomTestFragment.class);
    }

    @Override // ni4.a
    public String M2(long j3, String str) {
        return N3("mqqapi://vaslive/watch?qq_live_product_type=1&from=1&source=portal&video_source=0&room_type=1&game_id=1&roomid=" + j3, str);
    }

    @Override // ni4.a
    public void V2() {
        QPublicFragmentActivity.start(vf4.a.b(), new Intent(), TgLiveRoomOneKeyLiveTestFragment.class);
    }

    @Override // ni4.a
    public void X2(@NonNull Context context, long j3, String str) {
        f377364b.i("AnchorRoomService", 1, "enterGameAudienceRoomByScheme - " + j3 + " - " + str);
        TgSchemeProxyFragment.ph(context, M2(j3, str));
    }

    @Override // ni4.a
    public nf4.e b0() {
        return this.f377365a;
    }

    @Override // ni4.a
    public void initRegisterDatabaseModelClass() {
        YesDataBaseHelper.l(new TGLiveRecordEntity(), null);
        YesDataBaseHelper.l(new TimiAudienceRedDotInfo(), null);
    }

    @Override // ni4.a
    public si4.a l2() {
        return si4.c.s();
    }

    @Override // ni4.a
    public boolean n0(@NotNull final String str) {
        final LiveLoginInfo u16 = com.tencent.mobileqq.qqlive.sail.c.f272176a.u();
        final BaseRoomInfo q16 = ((jg4.b) mm4.b.b(jg4.b.class)).q(0L);
        if (u16 != null && q16 != null) {
            com.tencent.timi.game.utils.w.c(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.anchor.AnchorRoomService.1
                @Override // java.lang.Runnable
                public void run() {
                    SimpleEventBus.getInstance().dispatchEvent(new LiveLocalMsg(q16.getRoomId(), str, u16));
                }
            });
            return true;
        }
        return false;
    }

    @Override // ni4.a
    public void o0() {
        TGLiveClientQIPCModule.INSTANCE.c().n();
    }

    @Override // mm4.a
    public void o2() {
        tk4.c.INSTANCE.a().c();
        ((lo4.a) mm4.b.b(lo4.a.class)).C2().b();
        sk4.a.INSTANCE.a().h();
        ui4.c.INSTANCE.c();
        com.tencent.timi.game.liveroom.impl.room.manager.d.INSTANCE.a().f();
    }

    @Override // ni4.a
    public void openAnchorRoomPage(@NonNull @NotNull Context context, int i3, String str) {
        int i16;
        Intent intent = new Intent();
        if (!(context instanceof Activity) && ((i16 = Build.VERSION.SDK_INT) <= 23 || i16 >= 28)) {
            intent.setFlags(268435456);
        }
        intent.putExtra("fromSource", i3);
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("actionCmd", str);
        }
        ((ITimiAnchor) QRoute.api(ITimiAnchor.class)).openTimiAnchorActivity(context, intent);
    }

    @Override // ni4.a
    public ConcurrentHashMap<String, String> s1(long j3) {
        return TGLiveClientQIPCModule.INSTANCE.c().l(j3);
    }

    @Override // ni4.a
    public void s2(long j3) {
        TGLiveClientQIPCModule.INSTANCE.c().t(j3);
    }

    @Override // mm4.a
    public void init(Context context) {
    }
}
