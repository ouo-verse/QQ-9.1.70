package com.tencent.mobileqq.troop.data;

import android.os.Build;
import com.tencent.biz.lebasearch.Utils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class m {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class a extends c {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x0076, code lost:
        
            r0.picPath = r3.getString("pic_url") + "200";
         */
        @Override // com.tencent.mobileqq.troop.data.m.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public TroopFeedItem a(JSONObject jSONObject) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (TroopFeedItem) iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSONObject);
            }
            TroopFeedItem a16 = super.a(jSONObject);
            if (a16 == null) {
                return null;
            }
            a16.type = 18;
            try {
                a16.title = jSONObject.getString("album_name") + HardCodeUtil.qqStr(R.string.ue6) + jSONObject.getString("photo_num") + HardCodeUtil.qqStr(R.string.ue8);
                a16.linkUrl = jSONObject.getString("open_url");
                JSONArray jSONArray = jSONObject.getJSONArray("content");
                int i3 = 0;
                while (true) {
                    if (i3 >= jSONArray.length()) {
                        break;
                    }
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                    if (jSONObject2.getInt("type") == 3) {
                        break;
                    }
                    i3++;
                }
                return a16;
            } catch (JSONException e16) {
                e16.printStackTrace();
                return null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class b extends c {
        static IPatchRedirector $redirector_;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.troop.data.m.c
        public TroopFeedItem a(JSONObject jSONObject) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (TroopFeedItem) iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSONObject);
            }
            TroopFeedItem a16 = super.a(jSONObject);
            if (a16 == null) {
                return null;
            }
            a16.type = 99;
            try {
                a16.linkUrl = jSONObject.optString("open_url");
                if (jSONObject.has("app_id")) {
                    a16.ex_1 = "" + jSONObject.getLong("app_id");
                    if (!com.tencent.biz.qqstory.base.b.c() && a16.isStoryType()) {
                        if (QLog.isColorLevel()) {
                            QLog.d("TroopFeedParserHelperQ.qqstory.tag_api_limit", 2, "\u5f53\u524d\u7cfb\u7edfapi\uff1a" + Build.VERSION.SDK_INT + ",\u4f4e\u4e8e14");
                        }
                        return null;
                    }
                }
                JSONObject jSONObject2 = jSONObject.getJSONObject("content");
                a16.content = jSONObject2.getString("body");
                a16.title = jSONObject2.getString("title");
                a16.picPath = jSONObject2.getString("pic_url");
                return a16;
            } catch (JSONException e16) {
                e16.printStackTrace();
                return null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static abstract class c {
        static IPatchRedirector $redirector_;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public TroopFeedItem a(JSONObject jSONObject) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (TroopFeedItem) iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSONObject);
            }
            TroopFeedItem troopFeedItem = new TroopFeedItem();
            try {
                troopFeedItem.f203122id = jSONObject.getString("feed_id");
                troopFeedItem.feedTime = jSONObject.getString("mod_time");
                troopFeedItem.tag = jSONObject.getString("tag");
                if (jSONObject.has("pub_uin")) {
                    troopFeedItem.publishUin = jSONObject.getString("pub_uin");
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            return troopFeedItem;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class d extends c {
        static IPatchRedirector $redirector_;

        public d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.troop.data.m.c
        public TroopFeedItem a(JSONObject jSONObject) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (TroopFeedItem) iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSONObject);
            }
            TroopFeedItem a16 = super.a(jSONObject);
            if (a16 == null) {
                return null;
            }
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("content");
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                    int i16 = jSONObject2.getInt("type");
                    if (i16 == 5) {
                        if (jSONObject2.has("file_path")) {
                            a16.linkUrl = jSONObject2.getString("file_path");
                        }
                        a16.type = 0;
                        if (jSONObject2.has("sharesize")) {
                            a16.ex_1 = "" + jSONObject2.getLong("sharesize");
                        }
                        if (jSONObject2.has("bus_id")) {
                            try {
                                a16.content = "" + jSONObject2.getLong("bus_id");
                            } catch (JSONException unused) {
                                a16.content = "" + jSONObject2.getString("bus_id");
                            }
                        }
                        if (jSONObject2.has("sharefile")) {
                            a16.title = jSONObject2.getString("sharefile");
                        }
                    } else if (i16 == 3 && jSONObject2.has("pic_id")) {
                        a16.picPath = "https://gdynamic.qpic.cn/gdynamic/" + jSONObject2.getString("pic_id") + "/109";
                    }
                }
                if (StringUtil.isEmpty(a16.linkUrl) || StringUtil.isEmpty(a16.content)) {
                    return null;
                }
                return a16;
            } catch (JSONException e16) {
                e16.printStackTrace();
                return null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class e extends c {
        static IPatchRedirector $redirector_;

        public e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.troop.data.m.c
        public TroopFeedItem a(JSONObject jSONObject) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (TroopFeedItem) iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSONObject);
            }
            TroopFeedItem a16 = super.a(jSONObject);
            if (a16 == null) {
                return null;
            }
            try {
                a16.type = jSONObject.getInt(QCircleFolderFunnelCollect.EXTRA_FEED_TYPE);
                JSONArray jSONArray = jSONObject.getJSONArray("content");
                a16.linkUrl = jSONObject.getString("open_url");
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                    int i16 = jSONObject2.getInt("type");
                    if (i16 == 0) {
                        a16.content = jSONObject2.getString("value");
                    } else if (i16 == 3) {
                        if (jSONObject2.has("pic_url")) {
                            a16.picPath = jSONObject2.getString("pic_url") + "/109";
                        }
                    } else if (i16 == 10) {
                        a16.title = jSONObject2.getString("value");
                    } else if (i16 == 6 && StringUtil.isEmpty(a16.picPath) && jSONObject2.has("pic_url")) {
                        a16.picPath = jSONObject2.getString("pic_url");
                    }
                }
                return a16;
            } catch (JSONException e16) {
                e16.printStackTrace();
                return null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class f extends c {
        static IPatchRedirector $redirector_;

        public f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.troop.data.m.c
        public TroopFeedItem a(JSONObject jSONObject) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (TroopFeedItem) iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSONObject);
            }
            TroopFeedItem a16 = super.a(jSONObject);
            if (a16 == null) {
                return null;
            }
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("content");
                if (jSONArray.length() > 0) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(0);
                    int i3 = jSONObject2.getInt("type");
                    if (i3 == 5) {
                        if (jSONObject2.has("file_path")) {
                            a16.linkUrl = jSONObject2.getString("file_path");
                        }
                        a16.type = 131;
                        if (jSONObject2.has("sharesize")) {
                            a16.ex_1 = "" + jSONObject2.getLong("sharesize");
                        }
                        if (jSONObject2.has("bus_id")) {
                            try {
                                a16.content = "" + jSONObject2.getLong("bus_id");
                            } catch (JSONException unused) {
                                a16.content = "" + jSONObject2.getString("bus_id");
                            }
                        }
                        if (jSONObject2.has("sharefile")) {
                            a16.title = jSONObject2.getString("sharefile");
                        }
                        if (jSONObject2.has("shareexpire")) {
                            a16.shareExpire = jSONObject2.getLong("shareexpire");
                        }
                        if (jSONObject2.has("sharefromuin")) {
                            a16.shareFromUin = jSONObject2.getString("sharefromuin");
                        }
                    } else if (i3 == 4) {
                        a16.type = 132;
                        a16.linkUrl = jSONObject.getString("open_url");
                        a16.title = jSONObject2.getString("musicname");
                        a16.ex_1 = jSONObject2.getString("musicid");
                        a16.picPath = jSONObject2.getString("pic_url");
                    }
                }
                return a16;
            } catch (JSONException e16) {
                e16.printStackTrace();
                return null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class g extends c {
        static IPatchRedirector $redirector_;

        public g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.troop.data.m.c
        public TroopFeedItem a(JSONObject jSONObject) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (TroopFeedItem) iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSONObject);
            }
            TroopFeedItem a16 = super.a(jSONObject);
            if (a16 == null) {
                return null;
            }
            a16.type = 10;
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("content");
                if (jSONArray.length() > 0) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(0);
                    a16.linkUrl = jSONObject2.getString("videourl");
                    a16.title = jSONObject2.getString("videointro");
                    a16.picPath = jSONObject2.getString("videoid");
                }
                return a16;
            } catch (JSONException e16) {
                e16.printStackTrace();
                return null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class h extends c {
        static IPatchRedirector $redirector_;

        public h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.troop.data.m.c
        public TroopFeedItem a(JSONObject jSONObject) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (TroopFeedItem) iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSONObject);
            }
            TroopFeedItem a16 = super.a(jSONObject);
            if (a16 == null) {
                return null;
            }
            a16.type = 12;
            try {
                a16.linkUrl = jSONObject.getString("open_url");
                JSONObject jSONObject2 = jSONObject.getJSONObject("vote");
                if (jSONObject2 != null) {
                    JSONArray jSONArray = jSONObject2.getJSONArray("opts");
                    int i3 = 0;
                    for (int i16 = 0; i16 < jSONArray.length() && i3 <= 1; i16++) {
                        JSONArray jSONArray2 = jSONArray.getJSONArray(i16);
                        if (jSONArray2.length() > 0) {
                            JSONObject jSONObject3 = jSONArray2.getJSONObject(0);
                            if (i3 == 0) {
                                a16.content = jSONObject3.getString("value");
                            } else {
                                a16.ex_1 = jSONObject3.getString("value");
                            }
                            i3++;
                        }
                    }
                    JSONArray jSONArray3 = jSONObject2.getJSONArray("title");
                    if (jSONArray3.length() > 0) {
                        a16.title = jSONArray3.getJSONObject(0).getString("value");
                    }
                }
                return a16;
            } catch (JSONException e16) {
                e16.printStackTrace();
                return null;
            }
        }
    }

    public static String a(long j3) {
        Calendar calendar = Calendar.getInstance();
        Date date = new Date(j3 * 1000);
        calendar.setTime(date);
        return new SimpleDateFormat("MM\u6708dd\u65e5").format(date);
    }

    public static c b(int i3) {
        if (i3 != 0) {
            if (i3 != 10) {
                if (i3 != 12) {
                    if (i3 != 99) {
                        if (i3 != 4) {
                            if (i3 != 5) {
                                if (i3 != 18) {
                                    if (i3 != 19) {
                                        return null;
                                    }
                                } else {
                                    return new a();
                                }
                            }
                            return new e();
                        }
                        return new f();
                    }
                    return new b();
                }
                return new h();
            }
            return new g();
        }
        return new d();
    }

    public static Object[] c(JSONObject jSONObject, String str, String str2) {
        TroopFeedItem a16;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (jSONObject != null) {
            try {
                if (jSONObject.has("fids")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("fids");
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        arrayList.add(jSONArray.getJSONObject(i3).getString(Utils.KEY_BUSINESS_ID));
                    }
                }
                if (jSONObject.has("feeds")) {
                    JSONArray jSONArray2 = jSONObject.getJSONArray("feeds");
                    for (int i16 = 0; i16 < jSONArray2.length(); i16++) {
                        JSONObject jSONObject2 = jSONArray2.getJSONObject(i16);
                        int i17 = jSONObject2.getInt(QCircleFolderFunnelCollect.EXTRA_FEED_TYPE);
                        c b16 = b(i17);
                        if (b16 != null && (a16 = b16.a(jSONObject2)) != null && a16.isVaild()) {
                            a16.orginType = i17;
                            a16.currentUin = str2;
                            a16.troopUin = str;
                            arrayList2.add(a16);
                        }
                    }
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        return new Object[]{arrayList, arrayList2};
    }
}
