package com.qzone.homepage.ui.component.newpanel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes39.dex */
public class HomePanelList implements Serializable {
    public ArrayList<HomePanelItem> lst_hide;
    public ArrayList<HomePanelItem> lst_show;
    public long ownerUin;

    public HomePanelList(long j3, ArrayList<HomePanelItem> arrayList, ArrayList<HomePanelItem> arrayList2) {
        this.ownerUin = j3;
        this.lst_show = arrayList;
        this.lst_hide = arrayList2;
    }

    public JSONObject toJSONObject() {
        if (this.lst_show == null || this.lst_hide == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        ArrayList<HomePanelItem> arrayList = this.lst_show;
        if (arrayList != null) {
            Iterator<HomePanelItem> it = arrayList.iterator();
            while (it.hasNext()) {
                JSONObject jSONObject = it.next().toJSONObject();
                if (jSONObject == null) {
                    return null;
                }
                jSONArray.mo162put(jSONObject);
            }
        }
        JSONArray jSONArray2 = new JSONArray();
        ArrayList<HomePanelItem> arrayList2 = this.lst_hide;
        if (arrayList2 != null) {
            Iterator<HomePanelItem> it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                jSONArray2.mo162put(it5.next().toJSONObject());
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("ownerUin", this.ownerUin);
            jSONObject2.put("lst_show", jSONArray);
            jSONObject2.put("lst_hide", jSONArray2);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return jSONObject2;
    }

    public String toString() {
        JSONObject jSONObject = toJSONObject();
        if (jSONObject != null) {
            return jSONObject.toString();
        }
        return null;
    }

    public static HomePanelList fromJSONObject(String str) {
        ArrayList<HomePanelItem> arrayList;
        long j3 = 0;
        ArrayList<HomePanelItem> arrayList2 = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            j3 = jSONObject.getLong("ownerUin");
            JSONArray jSONArray = jSONObject.getJSONArray("lst_show");
            arrayList = jSONArray != null ? HomePanelItem.getHomePanelListFromJSONString(jSONArray.toString()) : null;
            try {
                JSONArray jSONArray2 = jSONObject.getJSONArray("lst_hide");
                if (jSONArray2 != null) {
                    arrayList2 = HomePanelItem.getHomePanelListFromJSONString(jSONArray2.toString());
                }
            } catch (JSONException unused) {
            }
        } catch (JSONException unused2) {
            arrayList = null;
        }
        return new HomePanelList(j3, arrayList, arrayList2);
    }
}
