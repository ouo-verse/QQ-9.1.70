package gp3;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.open.base.j;
import com.tencent.open.component.cache.database.a;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c extends com.tencent.open.component.cache.database.a {

    /* renamed from: e, reason: collision with root package name */
    public static final a.InterfaceC9275a<c> f403027e = new a();

    /* renamed from: c, reason: collision with root package name */
    public List<Friend> f403030c;

    /* renamed from: a, reason: collision with root package name */
    public int f403028a = -1;

    /* renamed from: b, reason: collision with root package name */
    public String f403029b = "";

    /* renamed from: d, reason: collision with root package name */
    public int f403031d = -1;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements a.InterfaceC9275a<c> {
        a() {
        }

        @Override // com.tencent.open.component.cache.database.a.InterfaceC9275a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c createFromCursor(Cursor cursor) {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("data"));
            if (blob == null) {
                return null;
            }
            Parcel obtain = Parcel.obtain();
            obtain.unmarshall(blob, 0, blob.length);
            obtain.setDataPosition(0);
            c cVar = new c();
            cVar.e(obtain);
            OaidMonitor.parcelRecycle(obtain);
            return cVar;
        }

        @Override // com.tencent.open.component.cache.database.a.InterfaceC9275a
        public String sortOrder() {
            return null;
        }

        @Override // com.tencent.open.component.cache.database.a.InterfaceC9275a
        public a.b[] structure() {
            return new a.b[]{new a.b("groupId", "INTEGER UNIQUE"), new a.b("data", "BLOB")};
        }

        @Override // com.tencent.open.component.cache.database.a.InterfaceC9275a
        public int version() {
            return 0;
        }
    }

    public static final List<c> b(JSONObject jSONObject) throws JSONException {
        String str;
        JSONArray jSONArray = jSONObject.getJSONArray("qqlist");
        int optInt = jSONObject.optInt("app_tid", -1);
        int optInt2 = jSONObject.optInt("app_rid", -1);
        int length = jSONArray.length();
        ArrayList arrayList = new ArrayList(length);
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
            JSONArray jSONArray2 = jSONObject2.getJSONArray("data");
            int length2 = jSONArray2.length();
            ArrayList arrayList2 = new ArrayList(length2);
            for (int i16 = 0; i16 < length2; i16++) {
                JSONObject jSONObject3 = jSONArray2.getJSONObject(i16);
                String string = jSONObject3.getString("data");
                String str2 = null;
                if (jSONObject3.has("nick")) {
                    str = jSONObject3.getString("nick");
                } else {
                    str = null;
                }
                if (jSONObject3.has("label")) {
                    str2 = jSONObject3.getString("label");
                }
                Friend friend = new Friend();
                friend.f340346d = string;
                friend.f340347e = j.a(str);
                friend.f340348f = j.a(str2);
                friend.C = optInt2;
                friend.D = optInt;
                arrayList2.add(friend);
            }
            c cVar = new c();
            cVar.f403028a = i3;
            cVar.f403029b = j.a(jSONObject2.getString("label"));
            cVar.f403030c = arrayList2;
            arrayList.add(cVar);
        }
        return arrayList;
    }

    public static final List<c> c(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray;
        String str;
        JSONArray jSONArray2 = jSONObject.getJSONArray("data");
        int length = jSONArray2.length();
        int optInt = jSONObject.optInt("app_tid", -1);
        int optInt2 = jSONObject.optInt("app_rid", -1);
        ArrayList arrayList = new ArrayList(length + 3);
        ArrayList arrayList2 = new ArrayList();
        c cVar = new c();
        int i3 = 0;
        cVar.f403028a = 0;
        cVar.f403029b = HardCodeUtil.qqStr(R.string.f172019ms2);
        cVar.f403030c = arrayList2;
        arrayList.add(cVar);
        int i16 = 0;
        int i17 = 1;
        while (i16 < length) {
            JSONObject jSONObject2 = jSONArray2.getJSONObject(i16);
            JSONArray jSONArray3 = jSONObject2.getJSONArray("friends");
            int length2 = jSONArray3.length();
            ArrayList arrayList3 = new ArrayList(length2);
            while (i3 < length2) {
                JSONObject jSONObject3 = jSONArray3.getJSONObject(i3);
                JSONArray jSONArray4 = jSONArray2;
                int i18 = length;
                if (jSONObject3.getInt("unabled") == 1) {
                    jSONArray = jSONArray3;
                } else {
                    String string = jSONObject3.getString("openid");
                    String str2 = null;
                    if (jSONObject3.has("nickname")) {
                        str = jSONObject3.getString("nickname");
                        jSONArray = jSONArray3;
                    } else {
                        jSONArray = jSONArray3;
                        str = null;
                    }
                    if (jSONObject3.has("remark")) {
                        str2 = jSONObject3.getString("remark");
                    }
                    Friend friend = new Friend();
                    friend.f340346d = string;
                    friend.f340347e = j.a(str);
                    friend.f340348f = j.a(str2);
                    if (jSONObject3.getInt("specified") == 1) {
                        friend.C = optInt2;
                        friend.D = optInt;
                        arrayList2.add(friend);
                    }
                    arrayList3.add(friend);
                }
                i3++;
                jSONArray2 = jSONArray4;
                length = i18;
                jSONArray3 = jSONArray;
            }
            JSONArray jSONArray5 = jSONArray2;
            c cVar2 = new c();
            cVar2.f403028a = i17;
            cVar2.f403029b = j.a(jSONObject2.getString(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_NAME));
            cVar2.f403030c = arrayList3;
            arrayList.add(cVar2);
            i16++;
            i17++;
            jSONArray2 = jSONArray5;
            length = length;
            i3 = 0;
        }
        if (jSONObject.getInt("only") == 1) {
            ArrayList arrayList4 = new ArrayList(1);
            arrayList4.add(cVar);
            return arrayList4;
        }
        if (arrayList2.size() == 0) {
            arrayList.remove(0);
            for (int i19 = 0; i19 < arrayList.size(); i19++) {
                ((c) arrayList.get(i19)).f403028a--;
            }
        }
        return arrayList;
    }

    public static final List<c> d(JSONObject jSONObject) throws JSONException {
        List<Friend> list;
        String str;
        c cVar;
        String str2;
        JSONArray jSONArray = jSONObject.getJSONArray("qqlist");
        int length = jSONArray.length();
        int optInt = jSONObject.optInt("app_tid", -1);
        int optInt2 = jSONObject.optInt("app_rid", -1);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        c cVar2 = new c();
        cVar2.f403028a = 0;
        cVar2.f403029b = HardCodeUtil.qqStr(R.string.f172018ms1);
        cVar2.f403030c = arrayList2;
        arrayList.add(cVar2);
        int i3 = 0;
        c cVar3 = null;
        int i16 = 1;
        while (i3 < length) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
            String str3 = "data";
            JSONArray jSONArray2 = jSONObject2.getJSONArray("data");
            int length2 = jSONArray2.length();
            ArrayList arrayList3 = new ArrayList();
            JSONArray jSONArray3 = jSONArray;
            int i17 = length;
            int i18 = 0;
            while (i18 < length2) {
                int i19 = length2;
                JSONObject jSONObject3 = jSONArray2.getJSONObject(i18);
                JSONArray jSONArray4 = jSONArray2;
                String string = jSONObject3.getString(str3);
                String str4 = str3;
                if (jSONObject3.has("nick")) {
                    str = jSONObject3.getString("nick");
                } else {
                    str = null;
                }
                if (jSONObject3.has("label")) {
                    str2 = jSONObject3.getString("label");
                    cVar = cVar3;
                } else {
                    cVar = cVar3;
                    str2 = null;
                }
                Friend friend = new Friend();
                friend.f340346d = string;
                friend.f340347e = str;
                friend.f340348f = str2;
                if (jSONObject3.getInt("specified") == 1 && !arrayList2.contains(friend)) {
                    friend.C = optInt2;
                    friend.D = optInt;
                    arrayList2.add(friend);
                }
                arrayList3.add(friend);
                i18++;
                length2 = i19;
                jSONArray2 = jSONArray4;
                str3 = str4;
                cVar3 = cVar;
            }
            c cVar4 = cVar3;
            if (HardCodeUtil.qqStr(R.string.f172017ms0).equals(jSONObject2.getString("label"))) {
                cVar3 = new c();
                cVar3.f403028a = 0;
                cVar3.f403029b = j.a(jSONObject2.getString("label"));
                cVar3.f403030c = arrayList3;
            } else {
                c cVar5 = new c();
                cVar5.f403028a = i16;
                cVar5.f403029b = j.a(jSONObject2.getString("label"));
                cVar5.f403030c = arrayList3;
                arrayList.add(cVar5);
                i16++;
                cVar3 = cVar4;
            }
            i3++;
            jSONArray = jSONArray3;
            length = i17;
        }
        c cVar6 = cVar3;
        if (jSONObject.getInt("only") == 1) {
            ArrayList arrayList4 = new ArrayList();
            arrayList4.add(cVar2);
            return arrayList4;
        }
        if (arrayList2.size() == 0) {
            if (cVar6 != null && (list = cVar6.f403030c) != null && list.size() > 0) {
                arrayList.remove(0);
                arrayList.add(0, cVar6);
            } else {
                arrayList.remove(0);
                for (int i26 = 0; i26 < arrayList.size(); i26++) {
                    ((c) arrayList.get(i26)).f403028a--;
                }
            }
        }
        return arrayList;
    }

    @Override // com.tencent.open.component.cache.database.a
    public void a(ContentValues contentValues) {
        Parcel obtain = Parcel.obtain();
        f(obtain);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        contentValues.put("data", marshall);
        contentValues.put("groupId", Integer.valueOf(this.f403028a));
    }

    public void e(Parcel parcel) {
        this.f403028a = parcel.readInt();
        this.f403029b = parcel.readString();
        ArrayList arrayList = new ArrayList();
        this.f403030c = arrayList;
        parcel.readTypedList(arrayList, Friend.CREATOR);
    }

    public void f(Parcel parcel) {
        parcel.writeInt(this.f403028a);
        parcel.writeString(this.f403029b);
        parcel.writeTypedList(this.f403030c);
    }
}
