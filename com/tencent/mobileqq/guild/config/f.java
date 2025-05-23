package com.tencent.mobileqq.guild.config;

import android.text.TextUtils;
import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes13.dex */
public class f implements IConfigData {

    /* renamed from: d, reason: collision with root package name */
    private int f216130d = 2;

    /* renamed from: e, reason: collision with root package name */
    private String f216131e = "#EAEDF3";

    /* renamed from: f, reason: collision with root package name */
    private int f216132f = 16;

    /* renamed from: h, reason: collision with root package name */
    private JSONArray f216133h = d();

    private JSONArray d() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.mo162put("com.tencent.gamecenter.skinArk");
        jSONArray.mo162put("com.tencent.gamecenter.gameshare_cfm");
        jSONArray.mo162put("com.tencent.gamecenter.gameshare_sgame");
        jSONArray.mo162put("com.tencent.gamecenter.actshare");
        jSONArray.mo162put("com.tencent.gamecenter.gameshare_wechatdash");
        jSONArray.mo162put("com.tencent.gamecenter.qjnn");
        jSONArray.mo162put("com.tencent.gamecenter.gameshare.a20190418xwwysd");
        jSONArray.mo162put("com.tencent.gamecenter.swy");
        jSONArray.mo162put("com.tencent.gamecenter.aceforce");
        jSONArray.mo162put("com.tencent.gamecenter.yrzx");
        jSONArray.mo162put("com.tencent.gamecenter.zgjjc");
        jSONArray.mo162put("com.tencent.gamecenter.lzhx");
        jSONArray.mo162put("com.tencent.gamecenter.gameshare");
        jSONArray.mo162put(QZoneHelper.PACKAGENAME_QQMUSIC);
        return jSONArray;
    }

    public static f f(String str) {
        f fVar = new f();
        if (QLog.isColorLevel()) {
            QLog.d("Guild.config.GuildArkStrokeConfig", 2, "content : " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return fVar;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            fVar.f216130d = jSONObject.optInt("width");
            fVar.f216132f = jSONObject.optInt("round");
            fVar.f216131e = jSONObject.optString("color");
            fVar.f216133h = jSONObject.optJSONArray("arknames");
        } catch (JSONException e16) {
            QLog.e("Guild.config.GuildArkStrokeConfig", 1, e16, new Object[0]);
        }
        return fVar;
    }

    public String a() {
        return this.f216131e;
    }

    public int b() {
        return this.f216132f;
    }

    public int c() {
        return this.f216130d;
    }

    public boolean e(String str) {
        int length = this.f216133h.length();
        for (int i3 = 0; i3 < length; i3++) {
            try {
            } catch (JSONException e16) {
                QLog.e("Guild.config.GuildArkStrokeConfig", 1, e16, new Object[0]);
            }
            if (TextUtils.equals(str, this.f216133h.getString(i3))) {
                return true;
            }
        }
        return false;
    }
}
