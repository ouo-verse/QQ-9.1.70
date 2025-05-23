package oi1;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.group_pro_proto.msg_responses_svr.MsgResponsesSvr$EmojiReaction;

/* compiled from: P */
/* loaded from: classes13.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static String f422694b = "Guild.comm.EmojiReactionInfo";

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<C10913a> f422695a = new ArrayList<>();

    /* compiled from: P */
    /* renamed from: oi1.a$a, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static class C10913a {

        /* renamed from: a, reason: collision with root package name */
        public String f422696a;

        /* renamed from: b, reason: collision with root package name */
        public long f422697b;

        /* renamed from: c, reason: collision with root package name */
        public long f422698c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f422699d;

        /* renamed from: e, reason: collision with root package name */
        public long f422700e;

        /* renamed from: f, reason: collision with root package name */
        public long f422701f;

        /* renamed from: g, reason: collision with root package name */
        public int f422702g = 1;

        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof C10913a)) {
                return false;
            }
            C10913a c10913a = (C10913a) obj;
            if (!TextUtils.equals(c10913a.f422696a, this.f422696a) || c10913a.f422697b != this.f422697b || c10913a.f422698c != this.f422698c || c10913a.f422700e != this.f422700e || c10913a.f422701f != this.f422701f || c10913a.f422699d != this.f422699d) {
                return false;
            }
            return true;
        }
    }

    public void a(List<MsgResponsesSvr$EmojiReaction> list) {
        if (list != null && !list.isEmpty()) {
            for (MsgResponsesSvr$EmojiReaction msgResponsesSvr$EmojiReaction : list) {
                C10913a c10913a = new C10913a();
                c10913a.f422696a = msgResponsesSvr$EmojiReaction.emoji_id.get();
                c10913a.f422697b = msgResponsesSvr$EmojiReaction.emoji_type.get();
                c10913a.f422698c = msgResponsesSvr$EmojiReaction.cnt.get();
                c10913a.f422699d = msgResponsesSvr$EmojiReaction.is_clicked.get();
                this.f422695a.add(c10913a);
            }
            return;
        }
        QLog.e(f422694b, 1, "convertTo Failed. emojReaction is empty!");
    }

    public String b() {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            Iterator<C10913a> it = this.f422695a.iterator();
            while (it.hasNext()) {
                C10913a next = it.next();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("emojId", next.f422696a);
                jSONObject2.put("emojType", next.f422697b);
                jSONObject2.put("emojCnt", next.f422698c);
                jSONObject2.put("isClicked", next.f422699d);
                jSONArray.mo162put(jSONObject2);
            }
            jSONObject.put("items", jSONArray);
            return jSONObject.toString();
        } catch (Exception e16) {
            QLog.e(f422694b, 1, e16.getMessage());
            return "";
        }
    }
}
