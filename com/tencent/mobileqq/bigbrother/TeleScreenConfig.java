package com.tencent.mobileqq.bigbrother;

import android.support.v4.util.ArraySet;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.theme.ThemeSwitcher;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class TeleScreenConfig extends BaseConfigParser<a> {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class a implements IConfigData {
        static IPatchRedirector $redirector_;
        private ArraySet<String> C;

        /* renamed from: d, reason: collision with root package name */
        public int f200362d;

        /* renamed from: e, reason: collision with root package name */
        public int f200363e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f200364f;

        /* renamed from: h, reason: collision with root package name */
        public ArraySet<String> f200365h;

        /* renamed from: i, reason: collision with root package name */
        private ArraySet<String> f200366i;

        /* renamed from: m, reason: collision with root package name */
        private ArraySet<String> f200367m;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f200362d = 10000;
            this.f200363e = 5000;
            this.f200364f = false;
            this.f200365h = new ArraySet<>();
            this.f200366i = new ArraySet<>();
            this.f200367m = new ArraySet<>();
            this.C = new ArraySet<>();
        }

        private void b(JSONObject jSONObject) throws JSONException {
            JSONArray optJSONArray = jSONObject.optJSONArray("pkg");
            this.C.clear();
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int length = optJSONArray.length() - 1; length >= 0; length--) {
                    if (!TextUtils.isEmpty(optJSONArray.getString(length))) {
                        this.C.add(optJSONArray.getString(length));
                    }
                }
            }
        }

        private void c(JSONObject jSONObject) throws JSONException {
            JSONArray optJSONArray = jSONObject.optJSONArray("scheme_white_list");
            this.f200366i.clear();
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int length = optJSONArray.length() - 1; length >= 0; length--) {
                    if (!TextUtils.isEmpty(optJSONArray.getString(length))) {
                        this.f200366i.add(optJSONArray.getString(length));
                    }
                }
            }
        }

        private void d(JSONObject jSONObject) throws JSONException {
            JSONArray optJSONArray = jSONObject.optJSONArray("md5");
            this.f200367m.clear();
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int length = optJSONArray.length() - 1; length >= 0; length--) {
                    if (!TextUtils.isEmpty(optJSONArray.getString(length))) {
                        this.f200367m.add(new String(Base64.decode(optJSONArray.getString(length), 0)));
                    }
                }
            }
        }

        private void e(JSONObject jSONObject) throws JSONException {
            JSONArray optJSONArray = jSONObject.optJSONArray("check_white_list");
            this.f200365h.clear();
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int length = optJSONArray.length() - 1; length >= 0; length--) {
                    if (!TextUtils.isEmpty(optJSONArray.getString(length))) {
                        this.f200365h.add(optJSONArray.getString(length));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(String str) {
            boolean z16;
            if (QLog.isColorLevel()) {
                QLog.i("TeleScreenConfig", 2, "telescreen config: " + str);
            }
            if (TextUtils.isEmpty(str)) {
                this.f200362d = 0;
                this.f200363e = 0;
                this.f200364f = false;
                this.f200365h.clear();
                this.f200366i.clear();
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optDouble = (int) (jSONObject.optDouble(ThemeSwitcher.DOWNLOAD_TIMEOUT) * 1000.0d);
                this.f200362d = optDouble;
                if (optDouble <= 0) {
                    optDouble = 10000;
                }
                this.f200362d = optDouble;
                int optDouble2 = (int) (jSONObject.optDouble("jump_timeout") * 1000.0d);
                this.f200363e = optDouble2;
                if (optDouble2 <= 0) {
                    optDouble2 = 5000;
                }
                this.f200363e = optDouble2;
                if (jSONObject.optInt("use_block_mode", 1) == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                this.f200364f = z16;
                e(jSONObject);
                b(jSONObject);
                c(jSONObject);
                d(jSONObject);
            } catch (JSONException e16) {
                QLog.e("TeleScreenConfig", 1, e16, new Object[0]);
            }
        }

        public boolean f(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).booleanValue();
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Iterator<String> it = this.f200367m.iterator();
            while (it.hasNext()) {
                if (str.startsWith(it.next())) {
                    return true;
                }
            }
            return false;
        }

        public boolean h(String str, String str2, String str3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, str, str2, str3)).booleanValue();
            }
            if (this.f200365h.contains(str) || this.C.contains(str3)) {
                return true;
            }
            if (str2 == null) {
                return false;
            }
            Iterator<String> it = this.f200366i.iterator();
            while (it.hasNext()) {
                if (str2.startsWith(it.next())) {
                    return true;
                }
            }
            return false;
        }
    }

    public TeleScreenConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a defaultConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new a();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a parse(@NonNull byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr);
        }
        a aVar = new a();
        aVar.g(new String(bArr, StandardCharsets.UTF_8));
        return aVar;
    }
}
