package com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend;

import com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.b;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.BaseApplication;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class HongBaoScenesRecommendItem extends b {

    /* renamed from: b, reason: collision with root package name */
    int f179979b;

    public HongBaoScenesRecommendItem(b.a aVar) {
        super(aVar);
        this.f179979b = 100;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.b
    public void e(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has("moneylimit")) {
            try {
                this.f179979b = jSONObject.getInt("moneylimit");
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.HongBaoScenesRecommendItem.1
            @Override // java.lang.Runnable
            public void run() {
                BaseApplication.getContext().getSharedPreferences("MOBILEQQ HONGBAO_SCENESRECOMMEND_INFO", 4).edit().putInt("HONGBAO_SCENES_MONEY_LIMIT", HongBaoScenesRecommendItem.this.f179979b).apply();
            }
        }, 16, null, false);
    }
}
