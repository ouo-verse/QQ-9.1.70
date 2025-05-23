package com.tencent.icgame.game.liveroom.impl.room.definition;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.icgame.data.room.EnterRoomInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.api.cookie.QQLiveCookieConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static String f115217a;

    /* renamed from: b, reason: collision with root package name */
    private static final List<Long> f115218b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private static boolean f115219c = false;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f115220d = false;

    /* renamed from: e, reason: collision with root package name */
    private static String f115221e = QQLiveCookieConstants.QQ_LIVE_DOMAIN;

    /* renamed from: f, reason: collision with root package name */
    private static String f115222f = "";

    /* renamed from: g, reason: collision with root package name */
    private static String f115223g = "";

    /* renamed from: h, reason: collision with root package name */
    private static boolean f115224h = false;

    /* renamed from: i, reason: collision with root package name */
    private static d f115225i = null;

    d() {
        c();
    }

    public static d a() {
        if (f115225i == null) {
            synchronized (d.class) {
                if (f115225i == null) {
                    f115225i = new d();
                }
            }
        }
        return f115225i;
    }

    private static void e(JSONObject jSONObject) throws JSONException {
        if ("1".equals(jSONObject.getString("activeRoomSwitchOn"))) {
            f115219c = true;
        } else {
            f115219c = false;
        }
        if ("1".equals(jSONObject.getString("enableActiveRoomSeverlessSwitch"))) {
            f115224h = true;
        } else {
            f115224h = false;
        }
    }

    private static void f(JSONObject jSONObject) throws JSONException {
        f115218b.clear();
        JSONArray jSONArray = jSONObject.getJSONArray("wangzerongyao_room_id");
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            String string = jSONArray.getString(i3);
            if (!TextUtils.isEmpty(string)) {
                f115218b.add(Long.valueOf(Long.parseLong(string)));
            }
        }
    }

    private static void g(JSONObject jSONObject) throws JSONException {
        if ("1".equals(jSONObject.getString("shareURLOfhostNameReplaceOn"))) {
            f115220d = true;
        } else {
            f115220d = false;
        }
        f115221e = jSONObject.optString("hostName", QQLiveCookieConstants.QQ_LIVE_DOMAIN);
    }

    public EnterRoomInfo.VideoDefinition b(Context context, long j3) {
        EnterRoomInfo.VideoDefinition f16 = b.f();
        int i3 = f16.level;
        EnterRoomInfo.VideoDefinition videoDefinition = EnterRoomInfo.VideoDefinition.SHD;
        if (i3 >= videoDefinition.level) {
            if (NetworkUtil.isWifiConnected(context)) {
                return videoDefinition;
            }
            return EnterRoomInfo.VideoDefinition.HD;
        }
        return f16;
    }

    public void c() {
        if (TextUtils.equals("", f115217a)) {
            return;
        }
        QLog.i("ICGameSpecialRoomDefinitionSwitcher", 1, "initRoomList, config:");
        if (TextUtils.isEmpty("")) {
            f115218b.clear();
            f115219c = false;
            f115224h = false;
            f115220d = false;
            f115223g = "";
            f115222f = "";
        }
        try {
            JSONObject jSONObject = new JSONObject("");
            f(jSONObject);
            e(jSONObject);
            g(jSONObject);
            f115223g = jSONObject.getString("streamType");
            f115222f = jSONObject.getString("videoStreamURl");
        } catch (Exception e16) {
            QLog.i("ICGameSpecialRoomDefinitionSwitcher", 1, "init room list fail!", e16);
        }
        f115217a = "";
    }

    public boolean d(long j3) {
        return f115218b.contains(Long.valueOf(j3));
    }
}
