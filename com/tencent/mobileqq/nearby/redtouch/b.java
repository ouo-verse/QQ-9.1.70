package com.tencent.mobileqq.nearby.redtouch;

import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.vaswebviewplugin.MessageRoamJsPlugin;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x791.oidb_0x791$RedDotInfo;

/* compiled from: P */
/* loaded from: classes33.dex */
public class b {

    /* renamed from: f, reason: collision with root package name */
    public String f253062f;

    /* renamed from: i, reason: collision with root package name */
    public String f253065i;

    /* renamed from: j, reason: collision with root package name */
    public long f253066j;

    /* renamed from: a, reason: collision with root package name */
    public int f253057a = 0;

    /* renamed from: b, reason: collision with root package name */
    public boolean f253058b = false;

    /* renamed from: c, reason: collision with root package name */
    public boolean f253059c = false;

    /* renamed from: d, reason: collision with root package name */
    public int f253060d = 1;

    /* renamed from: e, reason: collision with root package name */
    public int f253061e = 0;

    /* renamed from: g, reason: collision with root package name */
    public String f253063g = "";

    /* renamed from: h, reason: collision with root package name */
    public String f253064h = "";

    public void a(BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo) {
        if (redTypeInfo != null && redTypeInfo.red_desc.has()) {
            try {
                JSONObject jSONObject = new JSONObject(redTypeInfo.red_desc.get());
                this.f253059c = jSONObject.optBoolean("isOfficialNotify");
                this.f253060d = jSONObject.optInt("redContentType");
                this.f253062f = jSONObject.optString("redContentMsg");
                this.f253063g = jSONObject.optString("topicId");
                this.f253061e = jSONObject.optInt(MessageRoamJsPlugin.USERTYPE);
                this.f253064h = jSONObject.optString("msgId");
                this.f253057a = Integer.valueOf(redTypeInfo.red_content.get()).intValue();
                this.f253065i = jSONObject.optString("faceUrl");
                this.f253066j = jSONObject.optLong("uin");
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    public void b(oidb_0x791$RedDotInfo oidb_0x791_reddotinfo) {
        if (oidb_0x791_reddotinfo == null || !oidb_0x791_reddotinfo.str_custom_buffer.has() || oidb_0x791_reddotinfo.str_custom_buffer.get().isEmpty()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(oidb_0x791_reddotinfo.str_custom_buffer.get().toStringUtf8());
            this.f253059c = jSONObject.optInt("official_topic") == 1;
            this.f253060d = jSONObject.optInt("red_content_type");
            this.f253062f = jSONObject.optString("red_content_msg");
            this.f253063g = jSONObject.optString("red_topic_tag");
            this.f253061e = jSONObject.optInt("red_user_type");
            this.f253058b = jSONObject.optInt("red_type") == 0;
            this.f253064h = jSONObject.optString("red_msg_id");
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
