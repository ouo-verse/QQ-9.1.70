package b7;

import android.content.Context;
import android.view.View;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;
import cooperation.vip.manager.MonitorManager;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private View f28021a;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f28022a;

        /* renamed from: b, reason: collision with root package name */
        public String f28023b;

        /* renamed from: c, reason: collision with root package name */
        public String f28024c;

        public static a a(String str) {
            try {
                a aVar = new a();
                JSONObject jSONObject = new JSONObject(str);
                aVar.f28022a = jSONObject.optString("navigation_background");
                aVar.f28023b = jSONObject.optString("navigation_text_color_main");
                aVar.f28024c = jSONObject.optString("navigation_text_color_second");
                aVar.f28022a = com.qzone.homepage.diy.util.a.c(aVar.f28022a, TipsElementData.DEFAULT_COLOR);
                aVar.f28023b = com.qzone.homepage.diy.util.a.c(aVar.f28023b, "#333333");
                aVar.f28024c = com.qzone.homepage.diy.util.a.c(aVar.f28024c, TipsElementData.DEFAULT_COLOR);
                return aVar;
            } catch (JSONException e16) {
                MonitorManager.f().h(24, 4, "parse navigation json error = " + str, false);
                e16.printStackTrace();
                return null;
            }
        }
    }

    public c(Context context) {
        this.f28021a = new View(context);
    }

    public View a() {
        return this.f28021a;
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class b extends g<a> {
        private a E;

        public b(String str, View view) {
            super(str, view);
        }

        public a B() {
            return this.E;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // b7.g
        /* renamed from: C, reason: merged with bridge method [inline-methods] */
        public a w(String str) {
            return a.a(str);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // b7.g
        /* renamed from: D, reason: merged with bridge method [inline-methods] */
        public void A(a aVar) {
            this.E = aVar;
        }

        @Override // b7.g
        String u() {
            return "content";
        }

        @Override // b7.g
        void v() {
        }
    }
}
