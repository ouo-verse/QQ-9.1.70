package com.tencent.comic.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class ComicCancelRedPointPopItemData implements Serializable, Parcelable {
    static IPatchRedirector $redirector_ = null;
    public static final int BEHAVIOR_COLLECT = 2;
    public static final int BEHAVIOR_NONE = 0;
    public static final int BEHAVIOR_PRISE = 3;
    public static final int BEHAVIOR_READ = 1;
    public static final Parcelable.Creator<ComicCancelRedPointPopItemData> CREATOR;
    public static final String JSON_KEY_BEHAVIOR = "behavior";
    public static final String JSON_KEY_COMIC_ID = "comicId";
    public static final String JSON_KEY_COVER_IMG = "coverImg";
    public static final String JSON_KEY_FRIEND_NUM = "friendNum";
    public static final String JSON_KEY_TAGS = "tags";
    public static final String JSON_KEY_TEXT = "text";
    public static final String JSON_KEY_TITLE = "title";
    public int behavior;
    public String comicId;
    public String coverImg;
    public long friendNum;
    public List<String> tags;
    public String text;
    public String title;

    /* loaded from: classes5.dex */
    class a implements Parcelable.Creator<ComicCancelRedPointPopItemData> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ComicCancelRedPointPopItemData createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ComicCancelRedPointPopItemData) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new ComicCancelRedPointPopItemData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ComicCancelRedPointPopItemData[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (ComicCancelRedPointPopItemData[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new ComicCancelRedPointPopItemData[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33801);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            CREATOR = new a();
        }
    }

    public ComicCancelRedPointPopItemData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.coverImg = null;
        this.title = null;
        this.comicId = null;
        this.text = null;
        this.friendNum = 0L;
        this.behavior = 0;
        this.tags = new ArrayList();
    }

    public static ArrayList<ComicCancelRedPointPopItemData> getOrderedList(List<ComicCancelRedPointPopItemData> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList<ComicCancelRedPointPopItemData> arrayList = new ArrayList<>();
            for (ComicCancelRedPointPopItemData comicCancelRedPointPopItemData : list) {
                int i3 = 0;
                while (i3 < arrayList.size() && comicCancelRedPointPopItemData.friendNum < arrayList.get(i3).friendNum) {
                    i3++;
                }
                arrayList.add(i3, comicCancelRedPointPopItemData);
            }
            return arrayList;
        }
        return new ArrayList<>();
    }

    public static List<ComicCancelRedPointPopItemData> parseFromJsonArray(JSONArray jSONArray, boolean z16) {
        try {
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                ComicCancelRedPointPopItemData comicCancelRedPointPopItemData = new ComicCancelRedPointPopItemData();
                comicCancelRedPointPopItemData.coverImg = optJSONObject.optString(JSON_KEY_COVER_IMG);
                comicCancelRedPointPopItemData.title = optJSONObject.optString("title");
                comicCancelRedPointPopItemData.comicId = optJSONObject.optString(JSON_KEY_COMIC_ID);
                comicCancelRedPointPopItemData.text = optJSONObject.optString("text");
                comicCancelRedPointPopItemData.friendNum = optJSONObject.optInt(JSON_KEY_FRIEND_NUM);
                comicCancelRedPointPopItemData.behavior = optJSONObject.optInt(JSON_KEY_BEHAVIOR);
                JSONArray optJSONArray = optJSONObject.optJSONArray(JSON_KEY_TAGS);
                if (optJSONArray != null) {
                    int length2 = optJSONArray.length();
                    for (int i16 = 0; i16 < length2; i16++) {
                        comicCancelRedPointPopItemData.tags.add(optJSONArray.optString(i16));
                    }
                }
                arrayList.add(comicCancelRedPointPopItemData);
            }
            if (z16) {
                return getOrderedList(arrayList);
            }
            return arrayList;
        } catch (Throwable unused) {
            return new ArrayList();
        }
    }

    public static JSONArray transformToJsonArray(List<ComicCancelRedPointPopItemData> list) {
        try {
            JSONArray jSONArray = new JSONArray();
            for (ComicCancelRedPointPopItemData comicCancelRedPointPopItemData : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(JSON_KEY_COVER_IMG, comicCancelRedPointPopItemData.coverImg);
                jSONObject.put("title", comicCancelRedPointPopItemData.title);
                jSONObject.put(JSON_KEY_COMIC_ID, comicCancelRedPointPopItemData.comicId);
                jSONObject.put("text", comicCancelRedPointPopItemData.text);
                jSONObject.put(JSON_KEY_FRIEND_NUM, comicCancelRedPointPopItemData.friendNum);
                jSONObject.put(JSON_KEY_BEHAVIOR, comicCancelRedPointPopItemData.behavior);
                if (comicCancelRedPointPopItemData.tags != null) {
                    JSONArray jSONArray2 = new JSONArray();
                    Iterator<String> it = comicCancelRedPointPopItemData.tags.iterator();
                    while (it.hasNext()) {
                        jSONArray2.mo162put(it.next());
                    }
                    jSONObject.put(JSON_KEY_TAGS, jSONArray2);
                }
                jSONArray.mo162put(jSONObject);
            }
            return jSONArray;
        } catch (Throwable unused) {
            return new JSONArray();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 0;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("CancelRedPointPopItemData:");
        sb5.append("\n");
        sb5.append("coverImg:");
        sb5.append(this.coverImg);
        sb5.append("\n");
        sb5.append("title:");
        sb5.append(this.title);
        sb5.append("\n");
        sb5.append("friendNum:");
        sb5.append(this.friendNum);
        sb5.append("\n");
        sb5.append("behavior:");
        sb5.append(this.behavior);
        sb5.append("\n");
        sb5.append("text:");
        sb5.append(this.text);
        sb5.append("\n");
        sb5.append("comicId:");
        sb5.append(this.comicId);
        sb5.append("\n");
        List<String> list = this.tags;
        if (list != null) {
            for (String str : list) {
                sb5.append("tag:");
                sb5.append(str);
                sb5.append("\n");
            }
        }
        return sb5.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeString(this.coverImg);
        parcel.writeString(this.title);
        parcel.writeString(this.comicId);
        parcel.writeString(this.text);
        parcel.writeLong(this.friendNum);
        parcel.writeInt(this.behavior);
        parcel.writeStringList(this.tags);
    }

    protected ComicCancelRedPointPopItemData(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.coverImg = null;
        this.title = null;
        this.comicId = null;
        this.text = null;
        this.friendNum = 0L;
        this.behavior = 0;
        this.tags = new ArrayList();
        this.coverImg = parcel.readString();
        this.title = parcel.readString();
        this.comicId = parcel.readString();
        this.text = parcel.readString();
        this.friendNum = parcel.readLong();
        this.behavior = parcel.readInt();
        this.tags = parcel.createStringArrayList();
    }
}
