package com.tencent.trackrecordlib.c;

import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.trackrecordlib.enums.EventTopic;
import com.tencent.trackrecordlib.g.h;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected JSONObject f380959a;

    /* renamed from: b, reason: collision with root package name */
    private String f380960b;

    /* renamed from: c, reason: collision with root package name */
    private String f380961c;

    /* renamed from: d, reason: collision with root package name */
    private EventTopic f380962d;

    /* renamed from: e, reason: collision with root package name */
    private String f380963e;

    /* renamed from: f, reason: collision with root package name */
    private Map<String, Integer> f380964f;

    /* renamed from: g, reason: collision with root package name */
    private Map<String, String> f380965g;

    public b(EventTopic eventTopic) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) eventTopic);
            return;
        }
        this.f380960b = UUID.randomUUID().toString();
        this.f380961c = h.a();
        this.f380962d = eventTopic;
        a();
    }

    protected void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            this.f380959a = jSONObject;
            jSONObject.put("id", this.f380960b);
            this.f380959a.put("time", this.f380961c);
            this.f380959a.put("topic", this.f380962d.getSeq());
            this.f380959a.put("extra", this.f380963e);
            this.f380959a.put("values", c(this.f380964f));
            this.f380959a.put(ComicCancelRedPointPopItemData.JSON_KEY_TAGS, c(this.f380965g));
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public void b(Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) map);
            return;
        }
        Map<String, String> map2 = this.f380965g;
        if (map2 != null) {
            map2.putAll(map);
        } else {
            this.f380965g = map;
        }
        JSONObject jSONObject = this.f380959a;
        if (jSONObject != null) {
            try {
                jSONObject.put(ComicCancelRedPointPopItemData.JSON_KEY_TAGS, c(this.f380965g));
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }

    public Map<String, String> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) ? this.f380965g : (Map) iPatchRedirector.redirect((short) 8, (Object) this);
    }

    public EventTopic d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (EventTopic) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f380962d;
    }

    public abstract JSONObject e();

    private JSONObject c(Map map) {
        if (map == null) {
            return new JSONObject();
        }
        map.remove(null);
        return new JSONObject(map);
    }

    public Map<String, Integer> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? this.f380964f : (Map) iPatchRedirector.redirect((short) 7, (Object) this);
    }

    public void a(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, j3);
            return;
        }
        String a16 = h.a(new Date(j3));
        this.f380961c = a16;
        JSONObject jSONObject = this.f380959a;
        if (jSONObject != null) {
            try {
                jSONObject.put("time", a16);
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }

    public void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        this.f380963e = str;
        JSONObject jSONObject = this.f380959a;
        if (jSONObject != null) {
            try {
                jSONObject.put("extra", str);
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }

    public void a(Map<String, Integer> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) map);
            return;
        }
        Map<String, Integer> map2 = this.f380964f;
        if (map2 != null) {
            map2.putAll(map);
        } else {
            this.f380964f = map;
        }
        JSONObject jSONObject = this.f380959a;
        if (jSONObject != null) {
            try {
                jSONObject.put("values", c(this.f380964f));
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }
}
