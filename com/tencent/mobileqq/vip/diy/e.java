package com.tencent.mobileqq.vip.diy;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vip.diy.common.DIYImageView;
import com.tencent.mobileqq.widget.ProfileNameView;
import e15.f;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class e extends f15.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, View> f312952a;

    /* renamed from: b, reason: collision with root package name */
    private HashMap<String, f> f312953b;

    /* renamed from: c, reason: collision with root package name */
    private ProfileNameView f312954c;

    /* renamed from: d, reason: collision with root package name */
    private View f312955d;

    /* renamed from: e, reason: collision with root package name */
    private TemplateLikeView f312956e;

    /* renamed from: f, reason: collision with root package name */
    private String f312957f;

    public e(HashMap<String, View> hashMap, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) hashMap, (Object) str);
            return;
        }
        this.f312957f = "";
        if (hashMap != null) {
            this.f312953b = new HashMap<>();
            this.f312952a = hashMap;
            this.f312957f = str;
            return;
        }
        throw new RuntimeException("create the QVipProfileJsonInflaterFactory with null profileHeaderViewsMap");
    }

    @Override // f15.a
    public View b(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) str);
        }
        if ("pf_name".equals(str)) {
            if (this.f312954c == null) {
                hd0.c.a("DIYProfileTemplate.QVipProfileJsonInflaterFactory", "\u521b\u5efa\u4e86\u6635\u79f0\u63a7\u4ef6");
                this.f312954c = new ProfileNameView(context);
                ProfileTemplateNickNameContainer profileTemplateNickNameContainer = new ProfileTemplateNickNameContainer(context, this.f312954c);
                this.f312952a.put("map_key_profile_nick_name", this.f312954c);
                return profileTemplateNickNameContainer;
            }
            throw new RuntimeException("It have duplicate " + str);
        }
        if ("pf_avatar".equals(str)) {
            if (this.f312955d == null) {
                hd0.c.a("DIYProfileTemplate.QVipProfileJsonInflaterFactory", "\u521b\u5efa\u4e86\u5934\u50cf\u63a7\u4ef6");
                View inflate = LayoutInflater.from(context).inflate(R.layout.beb, (ViewGroup) null);
                View findViewById = inflate.findViewById(R.id.h2w);
                this.f312955d = findViewById;
                this.f312952a.put("map_key_profile_diy_nick_container", findViewById);
                return inflate;
            }
            throw new RuntimeException("It have duplicate " + str);
        }
        if ("pf_like".equals(str)) {
            if (this.f312956e == null) {
                hd0.c.a("DIYProfileTemplate.QVipProfileJsonInflaterFactory", "\u521b\u5efa\u4e86\u70b9\u8d5e\u63a7\u4ef6");
                TemplateLikeView templateLikeView = new TemplateLikeView(context);
                this.f312956e = templateLikeView;
                templateLikeView.d(0);
                this.f312952a.put("map_key_like", this.f312956e);
                return this.f312956e;
            }
            throw new RuntimeException("It have duplicate " + str);
        }
        if ("image_view".equals(str)) {
            return new DIYImageView(context);
        }
        return super.b(context, str);
    }

    @Override // f15.a
    public f c(String str, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (f) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) view);
        }
        if ("pf_name".equals(str)) {
            return new c(str, view, this.f312957f);
        }
        if ("pf_avatar".equals(str)) {
            return new a(str, view, this.f312953b);
        }
        if ("pf_like".equals(str)) {
            return new b(str, view, this.f312957f);
        }
        if ("image_view".equals(str)) {
            return new com.tencent.mobileqq.vip.diy.common.a(str, view, this.f312957f);
        }
        return super.c(str, view);
    }

    @Override // f15.a
    public void d(f fVar, JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) fVar, (Object) jSONObject);
            return;
        }
        String optString = jSONObject.optString("id");
        if (!TextUtils.isEmpty(optString) && fVar != null) {
            this.f312953b.put(optString, fVar);
        }
        if ("pf_avatar".equals(jSONObject.optString("type"))) {
            f fVar2 = this.f312953b.get(jSONObject.optString("border", ""));
            if (fVar2 != null) {
                this.f312952a.put("map_key_profile_diy_avatar_sticker", fVar2.i());
            }
        }
        super.d(fVar, jSONObject);
    }
}
