package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.troop.api.impl.TroopShareWxMiniProgramApiImpl;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class PicShareToWXConfigProcessor extends com.tencent.mobileqq.config.l<a> {

    /* loaded from: classes10.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f202458a = false;

        /* renamed from: b, reason: collision with root package name */
        public long f202459b = 10485760;

        /* renamed from: c, reason: collision with root package name */
        public String f202460c = TroopShareWxMiniProgramApiImpl.QQ_MINI_PROGRAM_ID;

        /* renamed from: d, reason: collision with root package name */
        public String f202461d = "/pages/gallery/gallery?";

        /* renamed from: e, reason: collision with root package name */
        public boolean f202462e = false;

        /* renamed from: f, reason: collision with root package name */
        public int f202463f = 0;

        /* renamed from: g, reason: collision with root package name */
        public String f202464g = "\u5206\u4eab\u7ed9\u4f601\u5f20\u56fe\u7247";

        /* renamed from: h, reason: collision with root package name */
        public String f202465h = "";

        public static a a(String str) {
            boolean z16;
            if (str == null) {
                return null;
            }
            a aVar = new a();
            try {
                JSONObject jSONObject = new JSONObject(str);
                boolean z17 = false;
                if (jSONObject.has("picShareToWeChatEnable")) {
                    if (jSONObject.getInt("picShareToWeChatEnable") == 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    aVar.f202458a = z16;
                }
                if (jSONObject.has("picShareToWeChatSize")) {
                    aVar.f202459b = jSONObject.getLong("picShareToWeChatSize");
                }
                if (jSONObject.has("PicShareToWeChatUserName")) {
                    aVar.f202460c = jSONObject.getString("PicShareToWeChatUserName");
                }
                if (jSONObject.has("PicShareToWeChatPath")) {
                    aVar.f202461d = jSONObject.getString("PicShareToWeChatPath");
                }
                if (jSONObject.has("PicShareToWeChatShareTicket")) {
                    if (jSONObject.getInt("PicShareToWeChatShareTicket") == 1) {
                        z17 = true;
                    }
                    aVar.f202462e = z17;
                }
                if (jSONObject.has("PicShareToWeChatMiniType")) {
                    aVar.f202463f = jSONObject.getInt("PicShareToWeChatMiniType");
                }
                if (jSONObject.has("PicShareToWeChatTitle")) {
                    aVar.f202464g = jSONObject.getString("PicShareToWeChatTitle");
                }
                if (jSONObject.has("PicShareToWeChatDescription")) {
                    aVar.f202465h = jSONObject.getString("PicShareToWeChatDescription");
                }
            } catch (JSONException e16) {
                QLog.e("PicShareToWXConfigProcessor", 1, "parse error.", e16);
            }
            return aVar;
        }
    }

    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a migrateOldOrDefaultContent(int i3) {
        return new a();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a onParsed(com.tencent.mobileqq.config.ai[] aiVarArr) {
        if (QLog.isColorLevel()) {
            QLog.d("PicShareToWXConfigProcessor", 2, "onParsed");
        }
        if (aiVarArr != null && aiVarArr.length > 0) {
            String str = aiVarArr[0].f202268b;
            if (QLog.isColorLevel()) {
                QLog.d("PicShareToWXConfigProcessor", 2, "onParsed, content:" + str);
            }
            return a.a(str);
        }
        return new a();
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(a aVar) {
        if (QLog.isColorLevel()) {
            QLog.d("PicShareToWXConfigProcessor", 2, "onUpdate");
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<a> clazz() {
        return a.class;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedCompressed() {
        return true;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedStoreLargeFile() {
        return false;
    }

    @Override // com.tencent.mobileqq.config.l
    public int migrateOldVersion() {
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("PicShareToWXConfigProcessor", 2, "onReqFailed");
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 530;
    }
}
