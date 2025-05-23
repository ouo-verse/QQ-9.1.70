package com.qq.e.comm.plugin.base.ad.model;

import com.qq.e.comm.plugin.k.y;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.tg.nativ.CarouselData;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class g implements CarouselData {

    /* renamed from: a, reason: collision with root package name */
    private String f39034a;

    /* renamed from: b, reason: collision with root package name */
    private String f39035b;

    /* renamed from: c, reason: collision with root package name */
    private String f39036c;

    /* renamed from: d, reason: collision with root package name */
    private String f39037d;

    /* renamed from: e, reason: collision with root package name */
    private String f39038e;

    /* renamed from: f, reason: collision with root package name */
    private String f39039f;

    /* renamed from: g, reason: collision with root package name */
    private String f39040g;

    /* renamed from: h, reason: collision with root package name */
    private String f39041h;

    public g(JSONObject jSONObject) {
        a(jSONObject);
    }

    public void a(JSONObject jSONObject) {
        if (y.a(jSONObject)) {
            this.f39034a = jSONObject.optString("title");
            this.f39035b = jSONObject.optString("image_url");
            this.f39036c = jSONObject.optString("template_image_url");
            this.f39037d = jSONObject.optString("price");
            this.f39038e = jSONObject.optString("original_price");
            this.f39039f = jSONObject.optString("click_url");
            this.f39040g = jSONObject.optString(QZoneAdTianshuFeedData.KEY_SCHEMA_URL);
            this.f39041h = jSONObject.optString("wx_mini_program_path");
        }
        GDTLogger.d("CarouselInfo " + this);
    }

    @Override // com.qq.e.tg.nativ.CarouselData
    public String getClickUrl() {
        GDTLogger.d("CarouselInfo mdpa\u70b9\u51fburl\u66ff\u6362\uff1a" + this.f39039f);
        return this.f39039f;
    }

    @Override // com.qq.e.tg.nativ.CarouselData
    public String getImageUrl() {
        return this.f39035b;
    }

    @Override // com.qq.e.tg.nativ.CarouselData
    public String getOriginalPrice() {
        return this.f39038e;
    }

    @Override // com.qq.e.tg.nativ.CarouselData
    public String getPrice() {
        return this.f39037d;
    }

    @Override // com.qq.e.tg.nativ.CarouselData
    public String getSchemaUrl() {
        GDTLogger.d("CarouselInfo mdpa\u76f4\u8fbeurl\u66ff\u6362\uff1a" + this.f39040g);
        return this.f39040g;
    }

    @Override // com.qq.e.tg.nativ.CarouselData
    public String getTemplateImageUrl() {
        return this.f39036c;
    }

    @Override // com.qq.e.tg.nativ.CarouselData
    public String getTitle() {
        return this.f39034a;
    }

    @Override // com.qq.e.tg.nativ.CarouselData
    public String getWechatAppPath() {
        GDTLogger.d("CarouselInfo mdpa\u5fae\u4fe1\u8df3\u8f6c\u66ff\u6362\uff1a" + this.f39041h);
        return this.f39041h;
    }

    public String toString() {
        return "CarouselInfo{title='" + this.f39034a + "', imageUrl='" + this.f39035b + "', templateImageUrl='" + this.f39036c + "', price='" + this.f39037d + "', originalPrice='" + this.f39038e + "', clickUrl='" + this.f39039f + "', schemaUrl='" + this.f39040g + "', wechatAppPath='" + this.f39041h + "'}";
    }
}
