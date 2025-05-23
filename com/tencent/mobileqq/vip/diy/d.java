package com.tencent.mobileqq.vip.diy;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import e15.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Activity f312949a;

    /* renamed from: b, reason: collision with root package name */
    private ViewGroup f312950b;

    /* renamed from: c, reason: collision with root package name */
    private List<f> f312951c;

    d(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
        } else {
            this.f312949a = activity;
            this.f312951c = new ArrayList();
        }
    }

    public static d b(@NonNull Activity activity) {
        return new d(activity);
    }

    private f e(@NonNull JSONObject jSONObject) {
        if (this.f312949a == null) {
            return null;
        }
        String optString = jSONObject.optString("type");
        f15.a aVar = new f15.a();
        View b16 = aVar.b(this.f312949a, optString);
        if (b16 == null) {
            AssertUtils.fail("type=" + optString + " is illegal json=" + jSONObject, new Object[0]);
            return null;
        }
        f c16 = aVar.c(optString, b16);
        if (c16 == null) {
            AssertUtils.fail("type=" + optString + " create null view model json=" + jSONObject, new Object[0]);
            return null;
        }
        c16.r(jSONObject);
        return c16;
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        ViewGroup viewGroup = this.f312950b;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        Iterator<f> it = this.f312951c.iterator();
        while (it.hasNext()) {
            it.next().l();
        }
        this.f312951c.clear();
    }

    public d c(@NonNull JSONArray jSONArray) {
        f e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (d) iPatchRedirector.redirect((short) 3, (Object) this, (Object) jSONArray);
        }
        if (this.f312950b == null) {
            this.f312950b = new FrameLayout(this.f312949a);
        }
        a();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i3);
            if (optJSONObject != null && (e16 = e(optJSONObject)) != null) {
                this.f312950b.addView(e16.i(), new ViewGroup.LayoutParams(-1, -1));
                this.f312951c.add(e16);
            }
        }
        return this;
    }

    public d d(@NonNull JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (d) iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSONObject);
        }
        f e16 = e(jSONObject);
        if (this.f312950b == null) {
            this.f312950b = new FrameLayout(this.f312949a);
        }
        a();
        if (e16 == null) {
            return this;
        }
        this.f312950b.addView(e16.i(), new ViewGroup.LayoutParams(-1, -1));
        this.f312951c.add(e16);
        return this;
    }

    public d f(@NonNull ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (d) iPatchRedirector.redirect((short) 4, (Object) this, (Object) viewGroup);
        }
        this.f312950b = viewGroup;
        return this;
    }
}
