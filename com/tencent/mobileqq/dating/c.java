package com.tencent.mobileqq.dating;

import android.text.TextUtils;
import appoint.define.appoint_define$DateComment;
import appoint.define.appoint_define$Elem;
import appoint.define.appoint_define$Face;
import appoint.define.appoint_define$ReplyInfo;
import appoint.define.appoint_define$RichText;
import com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f203404a;

    /* renamed from: b, reason: collision with root package name */
    public String f203405b;

    /* renamed from: c, reason: collision with root package name */
    public String f203406c;

    /* renamed from: d, reason: collision with root package name */
    public long f203407d;

    /* renamed from: e, reason: collision with root package name */
    public String f203408e;

    /* renamed from: f, reason: collision with root package name */
    public e f203409f;

    /* renamed from: g, reason: collision with root package name */
    public e f203410g;

    /* renamed from: h, reason: collision with root package name */
    public String f203411h;

    /* renamed from: i, reason: collision with root package name */
    public int f203412i;

    /* renamed from: j, reason: collision with root package name */
    @notColumn
    public String f203413j;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static c a(appoint_define$DateComment appoint_define_datecomment) {
        appoint_define$RichText appoint_define_richtext;
        int i3;
        appoint_define$ReplyInfo appoint_define_replyinfo = null;
        if (appoint_define_datecomment == null || TextUtils.isEmpty(appoint_define_datecomment.str_comment_id.get())) {
            return null;
        }
        c cVar = new c();
        cVar.f203404a = appoint_define_datecomment.str_comment_id.get();
        cVar.f203405b = f.b(appoint_define_datecomment.msg_appoint_id.get());
        cVar.f203407d = appoint_define_datecomment.uint32_time.get();
        if (appoint_define_datecomment.msg_content.has()) {
            appoint_define_richtext = appoint_define_datecomment.msg_content.get();
        } else {
            appoint_define_richtext = null;
        }
        cVar.f203406c = b(appoint_define_richtext);
        cVar.f203409f = e.a(appoint_define_datecomment.msg_publisher_info.get());
        if (appoint_define_datecomment.uint32_flag.has()) {
            i3 = appoint_define_datecomment.uint32_flag.get();
        } else {
            i3 = 0;
        }
        cVar.f203412i = i3;
        if (appoint_define_datecomment.msg_reply_info.has()) {
            appoint_define_replyinfo = appoint_define_datecomment.msg_reply_info.get();
        }
        if (appoint_define_replyinfo != null) {
            cVar.f203408e = appoint_define_replyinfo.str_comment_id.get();
            cVar.f203410g = e.a(appoint_define_replyinfo.msg_stranger_info.get());
        }
        cVar.f203413j = f.h(cVar.f203407d, true);
        cVar.f203411h = f.h(cVar.f203407d, false);
        return cVar;
    }

    public static String b(appoint_define$RichText appoint_define_richtext) {
        List<appoint_define$Elem> list;
        String str;
        appoint_define$Face appoint_define_face;
        int i3;
        if (appoint_define_richtext == null) {
            return "";
        }
        if (appoint_define_richtext.rpt_msg_elems.has()) {
            list = appoint_define_richtext.rpt_msg_elems.get();
        } else {
            list = null;
        }
        if (list == null || list.isEmpty()) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        for (appoint_define$Elem appoint_define_elem : list) {
            if (appoint_define_elem != null) {
                if (!appoint_define_elem.str_content.has()) {
                    str = "";
                } else {
                    str = appoint_define_elem.str_content.get();
                }
                sb5.append(str);
                if (appoint_define_elem.msg_face_info.has()) {
                    appoint_define_face = appoint_define_elem.msg_face_info.get();
                } else {
                    appoint_define_face = null;
                }
                if (appoint_define_face != null) {
                    if (appoint_define_face.uint32_index.has()) {
                        i3 = appoint_define_face.uint32_index.get();
                    } else {
                        i3 = -1;
                    }
                    if (i3 >= 0) {
                        sb5.append((char) 20);
                        sb5.append((char) QQSysFaceUtil.convertToLocal(i3));
                    }
                }
            }
        }
        return sb5.toString();
    }

    public static String c(List<c> list) {
        if (list != null && !list.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            Iterator<c> it = list.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                JSONObject d16 = d(it.next());
                if (d16 != null) {
                    jSONArray.mo162put(d16);
                    i3++;
                }
                if (i3 >= 20) {
                    break;
                }
            }
            return jSONArray.toString();
        }
        return "";
    }

    public static JSONObject d(c cVar) {
        if (cVar == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(WSAutoShowCommentParams.KEY_COMMENT_ID, cVar.f203404a);
            jSONObject.put("datingId", cVar.f203405b);
            jSONObject.put("content", cVar.f203406c);
            jSONObject.put("time", cVar.f203407d);
            jSONObject.put(WSAutoShowCommentParams.KEY_REPLY_ID, cVar.f203408e);
            jSONObject.put("puber", e.c(cVar.f203409f));
            jSONObject.put("replyer", e.c(cVar.f203410g));
            jSONObject.put("flag", cVar.f203412i);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return jSONObject;
    }

    public static void e(List<c> list, String str) {
        if (list != null && !TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    c f16 = f(jSONArray.getJSONObject(i3));
                    if (f16 != null) {
                        list.add(f16);
                    }
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
    }

    public static c f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        c cVar = new c();
        try {
            cVar.f203404a = jSONObject.getString(WSAutoShowCommentParams.KEY_COMMENT_ID);
            cVar.f203405b = jSONObject.getString("datingId");
            cVar.f203406c = jSONObject.getString("content");
            cVar.f203407d = jSONObject.getLong("time");
            cVar.f203409f = e.e(jSONObject.getJSONObject("puber"));
            cVar.f203412i = jSONObject.getInt("flag");
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        try {
            cVar.f203408e = jSONObject.getString(WSAutoShowCommentParams.KEY_REPLY_ID);
        } catch (JSONException e17) {
            e17.printStackTrace();
        }
        try {
            cVar.f203410g = e.e(jSONObject.getJSONObject("replyer"));
        } catch (JSONException e18) {
            e18.printStackTrace();
        }
        return cVar;
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj)).booleanValue();
        }
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        c cVar = (c) obj;
        String str = this.f203404a;
        if ((str != null || cVar.f203404a != null) && (str == null || !str.equals(cVar.f203404a))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        if (TextUtils.isEmpty(this.f203404a)) {
            return 0;
        }
        return this.f203404a.hashCode();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "[" + this.f203404a + "," + this.f203405b + "," + this.f203406c + "," + this.f203407d + "," + this.f203408e + "," + this.f203409f + "," + this.f203410g + "," + this.f203412i + ",]";
    }
}
