package com.qzone.homepage.ui.component.newpanel;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.qzone.widget.u;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* loaded from: classes39.dex */
public class HomePanelItem implements Serializable, Parcelable {
    public static final Parcelable.Creator<HomePanelItem> CREATOR = new a();
    public byte[] businessAppInfoBytes;
    public boolean canEdit;
    public Map<String, String> extInfo;
    public int flag;
    public int iconDrawableId;
    public String iconUrl;
    public boolean isCustom;
    public String jumpUrl;
    public boolean needClearRed;
    public int redCount;
    public int redIdMainpage;
    public int redIdUndelcount;
    public ArrayList<RedInfo> redInfos;
    public String rightText;
    public boolean showRed;
    public int tabId;
    public String text;

    /* loaded from: classes39.dex */
    class a implements Parcelable.Creator<HomePanelItem> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public HomePanelItem createFromParcel(Parcel parcel) {
            return new HomePanelItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public HomePanelItem[] newArray(int i3) {
            return new HomePanelItem[i3];
        }
    }

    public HomePanelItem() {
        this.tabId = 0;
        this.iconUrl = "";
        this.jumpUrl = "";
        this.text = "";
        this.isCustom = false;
        this.redIdMainpage = 0;
        this.redIdUndelcount = 0;
        this.canEdit = true;
        this.needClearRed = false;
        this.rightText = "";
        this.iconDrawableId = 0;
        this.redCount = 0;
        this.flag = 0;
        this.showRed = true;
    }

    public static ArrayList<HomePanelItem> getHomePanelListFromJSONString(String str) {
        ArrayList<HomePanelItem> arrayList = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONArray jSONArray = (JSONArray) new JSONTokener(str).nextValue();
            ArrayList<HomePanelItem> arrayList2 = new ArrayList<>(jSONArray.length());
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                try {
                    arrayList2.add(fromJSONObject(jSONArray.getJSONObject(i3)));
                } catch (JSONException unused) {
                    arrayList = arrayList2;
                    return arrayList;
                }
            }
            return arrayList2;
        } catch (JSONException unused2) {
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean hasNormalRedInfo() {
        ArrayList<RedInfo> arrayList;
        return (this.redIdMainpage > -1 || this.redIdUndelcount > -1) && (this.redCount == 0 || (arrayList = this.redInfos) == null || arrayList.isEmpty());
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(u.COLUMN_TAB_ID, this.tabId);
            jSONObject.put("icon_url", this.iconUrl);
            jSONObject.put("jump_url", this.jumpUrl);
            jSONObject.put("text", this.text);
            jSONObject.put("is_custom", this.isCustom);
            jSONObject.put("red_id_mainpage", this.redIdMainpage);
            jSONObject.put("red_id_undelcount", this.redIdUndelcount);
            jSONObject.put("iconDrawableId", this.iconDrawableId);
            jSONObject.put("need_clear_red", this.needClearRed);
            jSONObject.put("right_text", this.rightText);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("HomePanelItem {\n");
        sb5.append("tab_id: ");
        sb5.append(this.tabId);
        sb5.append("\n");
        if (!TextUtils.isEmpty(this.iconUrl)) {
            sb5.append("icon_url: ");
            sb5.append(this.iconUrl);
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.jumpUrl)) {
            sb5.append("jump_url: ");
            sb5.append(this.jumpUrl);
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.rightText)) {
            sb5.append("right_text: ");
            sb5.append(this.rightText);
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.text)) {
            sb5.append("text: ");
            sb5.append(this.text);
            sb5.append("}");
        }
        sb5.append("is_custom: ");
        sb5.append(this.isCustom);
        sb5.append("\n");
        sb5.append("red_id_mainpage: ");
        sb5.append(this.redIdMainpage);
        sb5.append("\n");
        sb5.append("red_id_undelcount: ");
        sb5.append(this.redIdUndelcount);
        sb5.append("\n");
        sb5.append("can_edit: ");
        sb5.append(this.canEdit);
        sb5.append("\n");
        sb5.append("iconDrawableId: ");
        sb5.append(this.iconDrawableId);
        sb5.append("\n");
        sb5.append("redCount: ");
        sb5.append(this.redCount);
        sb5.append("\n");
        sb5.append("need_clear_red");
        sb5.append(this.needClearRed);
        sb5.append("\n");
        sb5.append("flag: ");
        sb5.append(this.flag);
        sb5.append("}");
        return sb5.toString();
    }

    public static HomePanelItem fromJSONObject(JSONObject jSONObject) {
        HomePanelItem homePanelItem;
        HomePanelItem homePanelItem2 = null;
        try {
            homePanelItem = new HomePanelItem();
        } catch (JSONException unused) {
        }
        try {
            homePanelItem.tabId = jSONObject.getInt(u.COLUMN_TAB_ID);
            homePanelItem.iconUrl = jSONObject.getString("icon_url");
            homePanelItem.jumpUrl = jSONObject.getString("jump_url");
            homePanelItem.text = jSONObject.getString("text");
            homePanelItem.isCustom = jSONObject.getBoolean("is_custom");
            homePanelItem.redIdMainpage = jSONObject.getInt("red_id_mainpage");
            homePanelItem.redIdUndelcount = jSONObject.getInt("red_id_undelcount");
            homePanelItem.iconDrawableId = jSONObject.getInt("iconDrawableId");
            homePanelItem.needClearRed = jSONObject.getBoolean("need_clear_red");
            homePanelItem.rightText = jSONObject.getString("right_text");
            return homePanelItem;
        } catch (JSONException unused2) {
            homePanelItem2 = homePanelItem;
            return homePanelItem2;
        }
    }

    public void clearNormalRedInfo() {
        this.redIdMainpage = -1;
        this.redIdUndelcount = -1;
        this.redCount = 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        if (parcel != null) {
            parcel.writeInt(this.tabId);
            parcel.writeString(this.iconUrl);
            parcel.writeString(this.jumpUrl);
            parcel.writeString(this.text);
            parcel.writeInt(this.isCustom ? 1 : 0);
            parcel.writeInt(this.redIdMainpage);
            parcel.writeInt(this.redIdUndelcount);
            parcel.writeInt(this.canEdit ? 1 : 0);
            parcel.writeInt(this.iconDrawableId);
            parcel.writeInt(this.flag);
            parcel.writeInt(this.needClearRed ? 1 : 0);
            parcel.writeString(this.rightText);
        }
    }

    public HomePanelItem(int i3, String str, String str2, String str3, boolean z16, int i16, int i17, boolean z17, boolean z18, String str4) {
        this(i3, str, str2, str3, z16, i16, i17, z17, z18, str4, null);
    }

    public HomePanelItem(int i3, String str, String str2, String str3, boolean z16, int i16, int i17, boolean z17, boolean z18, String str4, Map<String, String> map) {
        this.iconDrawableId = 0;
        this.redCount = 0;
        this.flag = 0;
        this.showRed = true;
        this.tabId = i3;
        this.iconUrl = str;
        this.jumpUrl = str2;
        this.text = str3;
        this.isCustom = z16;
        this.redIdMainpage = i16;
        this.redIdUndelcount = i17;
        this.canEdit = z17;
        this.needClearRed = z18;
        this.rightText = str4;
        this.extInfo = map;
    }

    public HomePanelItem(Parcel parcel) {
        this.tabId = 0;
        this.iconUrl = "";
        this.jumpUrl = "";
        this.text = "";
        this.isCustom = false;
        this.redIdMainpage = 0;
        this.redIdUndelcount = 0;
        this.canEdit = true;
        this.needClearRed = false;
        this.rightText = "";
        this.iconDrawableId = 0;
        this.redCount = 0;
        this.flag = 0;
        this.showRed = true;
        if (parcel != null) {
            this.tabId = parcel.readInt();
            this.iconUrl = parcel.readString();
            this.jumpUrl = parcel.readString();
            this.text = parcel.readString();
            this.isCustom = parcel.readInt() == 1;
            this.redIdMainpage = parcel.readInt();
            this.redIdUndelcount = parcel.readInt();
            this.canEdit = parcel.readInt() == 1;
            this.iconDrawableId = parcel.readInt();
            this.flag = parcel.readInt();
            this.needClearRed = parcel.readInt() == 1;
            this.rightText = parcel.readString();
        }
    }
}
