package com.tencent.ams.mosaic;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqmini.v8rt.engine.EnginePathProvider;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final String f71452a;

    /* renamed from: b, reason: collision with root package name */
    private String f71453b;

    /* renamed from: c, reason: collision with root package name */
    private final List<j> f71454c;

    /* renamed from: d, reason: collision with root package name */
    private final List<j> f71455d;

    public k(@Nullable String str, String str2, List<j> list, @Nullable List<j> list2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, list, list2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        this.f71455d = arrayList;
        this.f71452a = str;
        this.f71453b = str2;
        this.f71454c = list;
        if (list2 != null && list2.size() > 0) {
            arrayList.addAll(list2);
        }
        a();
    }

    private void a() {
        if (TextUtils.isEmpty(this.f71452a)) {
            return;
        }
        try {
            String optString = new JSONObject(this.f71452a).optString(EnginePathProvider.ENGINE_JS_DIR);
            if (!TextUtils.isEmpty(optString)) {
                this.f71455d.add(new j(optString, "template.js"));
            }
        } catch (JSONException unused) {
            com.tencent.ams.mosaic.utils.f.h("MosaicTemplate", "read js from template failed");
        }
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f71453b;
    }

    public List<j> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f71454c;
    }

    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f71452a;
    }

    @NonNull
    public List<j> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f71455d;
    }
}
