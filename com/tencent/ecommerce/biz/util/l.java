package com.tencent.ecommerce.biz.util;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.pts.utils.PTSConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00132\u00020\u0001:\u0001\u0016B\u0013\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\b\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004J3\u0010\u000e\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nJ\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\u0017\u001a\u00020\u0004R\u0016\u0010\u001a\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/ecommerce/biz/util/l;", "", "", "d", "", "backgroundColor", "textColor", "text", "c", "title", "", "fontSize", "fontColor", "lineCount", "e", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)Lcom/tencent/ecommerce/biz/util/l;", "imageURL", "width", "height", "b", "Lorg/json/JSONArray;", "g", "a", "f", "Lorg/json/JSONObject;", "Lorg/json/JSONObject;", "baseJson", "richTextJsonObj", "<init>", "(Lorg/json/JSONObject;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public class l {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private JSONObject baseJson;

    public l(JSONObject jSONObject) {
        this.baseJson = new JSONObject();
        if (jSONObject == null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("style", "  text-overflow:ellipsis;overflow:hidden;-webkit-box-orient:vertical;");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("name", "div");
            jSONObject3.put(Node.ATTRS_ATTR, jSONObject2);
            jSONObject3.put(Node.CHILDREN_ATTR, new JSONArray());
            JSONArray jSONArray = new JSONArray();
            jSONArray.mo162put(jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("nodes", jSONArray);
            Unit unit = Unit.INSTANCE;
            this.baseJson = jSONObject4;
            return;
        }
        this.baseJson = jSONObject;
    }

    private final void d() {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", TtmlNode.TAG_SPAN);
        jSONObject.put(Node.ATTRS_ATTR, new JSONObject().put("style", "color:#FFFFFF;padding-left:4rpx;padding-right:4rpx;"));
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("type", "text");
        jSONObject2.put("text", " ");
        Unit unit = Unit.INSTANCE;
        jSONObject.put(Node.CHILDREN_ATTR, jSONArray.mo162put(jSONObject2));
        JSONArray optJSONArray2 = this.baseJson.optJSONArray("nodes");
        if (optJSONArray2 == null || (optJSONObject = optJSONArray2.optJSONObject(0)) == null || (optJSONArray = optJSONObject.optJSONArray(Node.CHILDREN_ATTR)) == null) {
            return;
        }
        optJSONArray.mo162put(jSONObject);
    }

    public final l a(String title) {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", TtmlNode.TAG_SPAN);
        jSONObject.put(Node.ATTRS_ATTR, new JSONObject().put("style", "text-overflow:ellipsis;overflow:hidden;-webkit-box-orient:vertical;-webkit-line-clamp:2;color:#262626;font-size:30rpx;font-weight:bold;"));
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("type", "text");
        jSONObject2.put("text", title);
        Unit unit = Unit.INSTANCE;
        jSONObject.put(Node.CHILDREN_ATTR, jSONArray.mo162put(jSONObject2));
        JSONArray optJSONArray2 = this.baseJson.optJSONArray("nodes");
        if (optJSONArray2 != null && (optJSONObject = optJSONArray2.optJSONObject(0)) != null && (optJSONArray = optJSONObject.optJSONArray(Node.CHILDREN_ATTR)) != null) {
            optJSONArray.mo162put(jSONObject);
        }
        return this;
    }

    public final void b(String imageURL, int width, int height) {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        boolean g16 = ECDeviceUtils.f104857e.g(PTSConfig.getApplicationContext());
        if (!(imageURL.length() == 0) && !g16) {
            if (width == 0) {
                width = 46;
            }
            int i3 = 16;
            int i16 = height == 0 ? 16 : height;
            if (i16 != 16) {
                width = (width * 16) / height;
            } else {
                i3 = i16;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", "img");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("style", "width: " + width + "px; height: " + i3 + "px");
            jSONObject2.put("src", imageURL);
            Unit unit = Unit.INSTANCE;
            jSONObject.put(Node.ATTRS_ATTR, jSONObject2);
            jSONObject.put(Node.CHILDREN_ATTR, new JSONArray());
            JSONArray optJSONArray2 = this.baseJson.optJSONArray("nodes");
            if (optJSONArray2 != null && (optJSONObject = optJSONArray2.optJSONObject(0)) != null && (optJSONArray = optJSONObject.optJSONArray(Node.CHILDREN_ATTR)) != null) {
                optJSONArray.mo162put(jSONObject);
            }
            d();
            return;
        }
        cg0.a.b("ECRichTextParamsBuilder", "addImageLabel isPad = " + g16);
    }

    public final l c(String backgroundColor, String textColor, String text) {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", TtmlNode.TAG_SPAN);
        jSONObject.put(Node.ATTRS_ATTR, new JSONObject().put("style", "color:" + textColor + ";background-color:" + backgroundColor + ";font-size:12px;border-radius:8rpx;padding-left:2px;padding-right:2px;"));
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("type", "text");
        jSONObject2.put("text", text);
        Unit unit = Unit.INSTANCE;
        jSONObject.put(Node.CHILDREN_ATTR, jSONArray.mo162put(jSONObject2));
        JSONArray optJSONArray2 = this.baseJson.optJSONArray("nodes");
        if (optJSONArray2 != null && (optJSONObject = optJSONArray2.optJSONObject(0)) != null && (optJSONArray = optJSONObject.optJSONArray(Node.CHILDREN_ATTR)) != null) {
            optJSONArray.mo162put(jSONObject);
        }
        d();
        return this;
    }

    public final l e(String title, Integer fontSize, String fontColor, Integer lineCount) {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        m mVar = new m();
        mVar.e(fontSize);
        mVar.c(fontColor);
        mVar.f(lineCount);
        mVar.d("text-overflow:ellipsis;overflow:hidden;font-weight:bold;");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", TtmlNode.TAG_SPAN);
        jSONObject.put(Node.ATTRS_ATTR, new JSONObject().put("style", mVar.b()));
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("type", "text");
        jSONObject2.put("text", title);
        Unit unit = Unit.INSTANCE;
        jSONObject.put(Node.CHILDREN_ATTR, jSONArray.mo162put(jSONObject2));
        JSONArray optJSONArray2 = this.baseJson.optJSONArray("nodes");
        if (optJSONArray2 != null && (optJSONObject = optJSONArray2.optJSONObject(0)) != null && (optJSONArray = optJSONObject.optJSONArray(Node.CHILDREN_ATTR)) != null) {
            optJSONArray.mo162put(jSONObject);
        }
        return this;
    }

    public final String f() {
        return this.baseJson.toString();
    }

    public final JSONArray g() {
        JSONArray optJSONArray = this.baseJson.optJSONArray("nodes");
        return optJSONArray != null ? optJSONArray : new JSONArray();
    }

    public /* synthetic */ l(JSONObject jSONObject, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : jSONObject);
    }
}
