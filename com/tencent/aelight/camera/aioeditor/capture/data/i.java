package com.tencent.aelight.camera.aioeditor.capture.data;

import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class i implements Cloneable {

    /* renamed from: d, reason: collision with root package name */
    public int f66740d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f66741e;

    /* renamed from: f, reason: collision with root package name */
    public String f66742f;

    /* renamed from: h, reason: collision with root package name */
    public List<MusicItemInfo> f66743h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f66744i;

    public i() {
        this.f66744i = true;
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public i clone() {
        try {
            return (i) super.clone();
        } catch (CloneNotSupportedException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public MusicItemInfo b(int i3) {
        List<MusicItemInfo> list = this.f66743h;
        if (list == null) {
            return null;
        }
        for (MusicItemInfo musicItemInfo : list) {
            if (musicItemInfo.mItemId == i3) {
                return musicItemInfo;
            }
        }
        return null;
    }

    public i(JSONObject jSONObject) throws JSONException {
        this.f66744i = true;
        if (jSONObject.has("categoryName")) {
            this.f66742f = jSONObject.getString("categoryName");
        }
        if (jSONObject.has("tagid")) {
            this.f66740d = jSONObject.getInt("tagid");
        }
        if (jSONObject.has(NodeProps.ENABLED)) {
            this.f66744i = jSONObject.getBoolean(NodeProps.ENABLED);
        }
        this.f66741e = "1".equals(jSONObject.optString("random_position"));
        if (jSONObject.has("content")) {
            JSONArray jSONArray = jSONObject.getJSONArray("content");
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                MusicItemInfo musicItemInfo = new MusicItemInfo(jSONArray.optString(i3));
                musicItemInfo.mTagName = this.f66742f;
                musicItemInfo.isWsBanner();
                arrayList.add(musicItemInfo);
            }
            this.f66743h = arrayList;
        }
    }
}
