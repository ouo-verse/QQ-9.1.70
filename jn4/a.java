package jn4;

import android.text.TextUtils;
import com.tencent.timi.game.tgpa.TGPAUtil;
import com.tencent.timi.game.tgpa.data.CyminiTGPAData;
import com.tencent.timi.game.utils.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    private static volatile a f410678d;

    /* renamed from: a, reason: collision with root package name */
    private List<TGPAUtil.a> f410679a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private HashMap<String, a3.a> f410680b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private TGPAUtil.a f410681c = new C10601a();

    /* compiled from: P */
    /* renamed from: jn4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    class C10601a implements TGPAUtil.a {
        C10601a() {
        }

        @Override // com.tencent.timi.game.tgpa.TGPAUtil.a
        public void a(int i3, float f16) {
            l.i("CyminiTGPAHelper", "tgpaService###callback#onResourceUpdateProgress - " + i3 + " - " + f16);
            if (a.this.f410679a != null && a.this.f410679a.size() > 0) {
                Iterator it = a.this.f410679a.iterator();
                while (it.hasNext()) {
                    ((TGPAUtil.a) it.next()).a(i3, f16);
                }
            }
        }

        @Override // com.tencent.timi.game.tgpa.TGPAUtil.a
        public void b(String str) {
            l.i("CyminiTGPAHelper", "tgpaService###callback#onReceiveResourceVersion - " + str);
            if (a.this.f410679a != null && a.this.f410679a.size() > 0) {
                Iterator it = a.this.f410679a.iterator();
                while (it.hasNext()) {
                    ((TGPAUtil.a) it.next()).b(str);
                }
            }
        }

        @Override // com.tencent.timi.game.tgpa.TGPAUtil.a
        public void c(int i3) {
            l.i("CyminiTGPAHelper", "tgpaService###callback#onGameSceneChanged - " + i3);
            if (a.this.f410679a != null && a.this.f410679a.size() > 0) {
                Iterator it = a.this.f410679a.iterator();
                while (it.hasNext()) {
                    ((TGPAUtil.a) it.next()).c(i3);
                }
            }
        }

        @Override // com.tencent.timi.game.tgpa.TGPAUtil.a
        public void d(String str) {
            l.i("CyminiTGPAHelper", "tgpaService###callback#onReceiveGameVersion - " + str);
            if (a.this.f410679a != null && a.this.f410679a.size() > 0) {
                Iterator it = a.this.f410679a.iterator();
                while (it.hasNext()) {
                    ((TGPAUtil.a) it.next()).d(str);
                }
            }
        }

        @Override // com.tencent.timi.game.tgpa.TGPAUtil.a
        public void e(boolean z16) {
            l.i("CyminiTGPAHelper", "tgpaService###callback#onGameVoiceSwitch - " + z16);
            if (a.this.f410679a != null && a.this.f410679a.size() > 0) {
                Iterator it = a.this.f410679a.iterator();
                while (it.hasNext()) {
                    ((TGPAUtil.a) it.next()).e(z16);
                }
            }
        }

        @Override // com.tencent.timi.game.tgpa.TGPAUtil.a
        public void f(String str, Object obj) {
            l.i("CyminiTGPAHelper", "tgpaService###callback#onReceiveCustomData - " + obj);
            if (a.this.f410679a != null && a.this.f410679a.size() > 0) {
                Iterator it = a.this.f410679a.iterator();
                while (it.hasNext()) {
                    ((TGPAUtil.a) it.next()).f(str, obj);
                }
            }
        }
    }

    a() {
        l.i("CyminiTGPAHelper", "CyminiTGPAHelper");
    }

    public static a c() {
        if (f410678d == null) {
            synchronized (a.class) {
                if (f410678d == null) {
                    f410678d = new a();
                }
            }
        }
        return f410678d;
    }

    private a3.a d(String str) {
        return this.f410680b.get(str);
    }

    public void b() {
        l.i("CyminiTGPAHelper", "tgpaService###clearGameDataCallback " + this.f410679a.size());
        this.f410679a.clear();
    }

    public void g(String str, String str2) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        l.i("CyminiTGPAHelper", "tgpaService###receiveDataFromGame " + str + " " + str2);
        if (!TextUtils.isEmpty(str2)) {
            try {
                jSONObject = new JSONObject(str2);
            } catch (Exception e16) {
                l.f("CyminiTGPAHelper", "parse Json error", e16);
            }
            if (jSONObject == null && jSONObject.keys().hasNext()) {
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str3 = (String) keys.next();
                    int a16 = CyminiTGPAData.a(str3);
                    if (a16 >= 0) {
                        boolean z16 = true;
                        if (a16 != 1) {
                            if (a16 != 2) {
                                if (a16 != 4) {
                                    switch (a16) {
                                        case 75:
                                            try {
                                                this.f410681c.a(2, (int) Float.parseFloat(jSONObject.optString(str3)));
                                                break;
                                            } catch (Exception unused) {
                                                l.e("CyminiTGPAHelper", "parse data error, " + a16 + " - " + jSONObject);
                                                break;
                                            }
                                        case 76:
                                            int optInt = jSONObject.optInt(str3);
                                            TGPAUtil.a aVar = this.f410681c;
                                            if (optInt != 1) {
                                                z16 = false;
                                            }
                                            aVar.e(z16);
                                            break;
                                        case 77:
                                            JSONObject optJSONObject = jSONObject.optJSONObject(str3);
                                            if (optJSONObject != null) {
                                                break;
                                            } else {
                                                l.e("CyminiTGPAHelper", "parse data error, " + a16 + " - " + optJSONObject);
                                                break;
                                            }
                                        case 78:
                                            JSONObject optJSONObject2 = jSONObject.optJSONObject(str3);
                                            if (optJSONObject2 != null) {
                                                break;
                                            } else {
                                                l.e("CyminiTGPAHelper", "parse data error, " + a16 + " - " + optJSONObject2);
                                                break;
                                            }
                                        case 79:
                                            String optString = jSONObject.optString(str3);
                                            try {
                                                jSONObject2 = new JSONObject(optString);
                                            } catch (Exception e17) {
                                                l.f("CyminiTGPAHelper", a16 + " JSONObject error - " + optString, e17);
                                                jSONObject2 = null;
                                            }
                                            if (jSONObject2 == null) {
                                                l.e("CyminiTGPAHelper", "parse data error, " + a16 + " - " + jSONObject);
                                                break;
                                            } else {
                                                int b16 = CyminiTGPAData.b(jSONObject2.optString("type"));
                                                if (b16 < 0) {
                                                    l.e("CyminiTGPAHelper", "TGPAResourceProgressType null, progressJson = " + jSONObject2);
                                                    break;
                                                } else {
                                                    this.f410681c.a(b16, (int) Float.parseFloat(jSONObject2.optString("progress")));
                                                    break;
                                                }
                                            }
                                    }
                                } else {
                                    int optInt2 = jSONObject.optInt(str3);
                                    int c16 = CyminiTGPAData.c(String.valueOf(optInt2));
                                    if (c16 < 0) {
                                        l.e("CyminiTGPAHelper", "KEY_GAME_SCENE_CHANGE null, " + a16 + " gameScene = " + optInt2);
                                    } else {
                                        this.f410681c.c(c16);
                                    }
                                }
                            } else {
                                String optString2 = jSONObject.optString(str3);
                                if (TextUtils.isEmpty(optString2)) {
                                    l.e("CyminiTGPAHelper", "parse data error, " + a16 + " - " + jSONObject);
                                } else if ("1".equals(optString2)) {
                                    l.e("CyminiTGPAHelper", "invalid param!!! " + a16 + " - " + jSONObject);
                                } else {
                                    this.f410681c.b(optString2);
                                }
                            }
                        } else {
                            String optString3 = jSONObject.optString(str3);
                            if (TextUtils.isEmpty(optString3)) {
                                l.e("CyminiTGPAHelper", "parse data error, " + a16 + " - " + jSONObject);
                            } else if ("1".equals(optString3)) {
                                l.e("CyminiTGPAHelper", "invalid param!!! " + a16 + " - " + jSONObject);
                            } else {
                                this.f410681c.d(optString3);
                            }
                        }
                    } else {
                        l.e("CyminiTGPAHelper", "parse TGPADataKey error, key is - " + str3);
                        this.f410681c.f(str3, jSONObject.opt(str3));
                    }
                }
                return;
            }
            l.e("CyminiTGPAHelper", "jsonObject is null!!!");
        }
        jSONObject = null;
        if (jSONObject == null) {
        }
        l.e("CyminiTGPAHelper", "jsonObject is null!!!");
    }

    public void h(TGPAUtil.a aVar) {
        l.i("CyminiTGPAHelper", "tgpaService###registerGameDataCallback " + aVar);
        if (aVar != null && !this.f410679a.contains(aVar)) {
            this.f410679a.add(aVar);
        }
    }

    public void i(String str, JSONObject jSONObject) {
        l.i("CyminiTGPAHelper", "tgpaService###sendDataToGame " + str + " - " + jSONObject);
        if (jSONObject == null) {
            l.i("CyminiTGPAHelper", "jsonObject is null!!!");
            return;
        }
        a3.a d16 = d(str);
        if (d16 != null) {
            try {
                d16.S(jSONObject.toString());
                return;
            } catch (Exception e16) {
                l.f("CyminiTGPAHelper", "sendDataToGame error", e16);
                return;
            }
        }
        l.e("CyminiTGPAHelper", "ICallBack is null!!!");
    }

    public void j(String str, a3.a aVar) {
        l.i("CyminiTGPAHelper", "tgpaService###setTGPACallback " + str + " - " + aVar);
        this.f410680b.put(str, aVar);
        if (eh4.a.e()) {
            i(str, CyminiTGPAData.d());
        }
    }

    public void k(TGPAUtil.a aVar) {
        l.i("CyminiTGPAHelper", "tgpaService###unRegisterGameDataCallback " + aVar);
        if (aVar != null && this.f410679a.contains(aVar)) {
            this.f410679a.remove(aVar);
        }
    }

    public void e() {
    }

    public void f() {
    }
}
