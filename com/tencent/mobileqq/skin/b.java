package com.tencent.mobileqq.skin;

import android.graphics.ColorFilter;
import com.tencent.mobileqq.guild.quiprofile.GuildTokenEngine;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.mobileqq.vas.theme.TokenEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.BaseConstantState;
import com.tencent.theme.SkinnableColorStateList;
import com.tencent.theme.i;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b implements i {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static b f288519b;

    /* renamed from: c, reason: collision with root package name */
    private static ArrayList f288520c;

    /* renamed from: a, reason: collision with root package name */
    @QAutoInject(configPath = "AutoInjectYml/Foundation/QQUI/Inject_SubEngine.yml", version = 1)
    private ArrayList<a> f288521a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51275);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        ArrayList arrayList = new ArrayList();
        f288520c = arrayList;
        arrayList.add(TokenEngine.class);
        f288520c.add(GuildTokenEngine.class);
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f288521a = new ArrayList<>();
            a();
        }
    }

    @QAutoInitMethod
    private void a() {
        com.tencent.mobileqq.qroute.utils.b.c(f288520c, this.f288521a);
        if (this.f288521a.size() <= 0) {
            QLog.d("SubEngine", 1, "initInjectData failed");
        } else if (QLog.isColorLevel()) {
            Iterator<a> it = this.f288521a.iterator();
            while (it.hasNext()) {
                QLog.d("SubEngine", 1, "engine : ", it.next().getClass().getName());
            }
        }
    }

    public static b b() {
        if (f288519b == null) {
            synchronized (b.class) {
                if (f288519b == null) {
                    f288519b = new b();
                }
            }
        }
        return f288519b;
    }

    @Override // com.tencent.theme.i
    public boolean addResources(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, i3, (Object) str)).booleanValue();
        }
        Iterator<a> it = this.f288521a.iterator();
        while (it.hasNext()) {
            if (it.next().addResources(i3, str)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.theme.i
    public boolean needBlockSetAlpha(BaseConstantState baseConstantState, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) baseConstantState, i3)).booleanValue();
        }
        Iterator<a> it = this.f288521a.iterator();
        while (it.hasNext()) {
            if (it.next().needBlockSetAlpha(baseConstantState, i3)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.theme.i
    public boolean needBlockSetColorFilter(BaseConstantState baseConstantState, ColorFilter colorFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) baseConstantState, (Object) colorFilter)).booleanValue();
        }
        Iterator<a> it = this.f288521a.iterator();
        while (it.hasNext()) {
            if (it.next().needBlockSetColorFilter(baseConstantState, colorFilter)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.theme.i
    public void onColorLoaded(SkinnableColorStateList skinnableColorStateList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) skinnableColorStateList);
            return;
        }
        Iterator<a> it = this.f288521a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.isFocusedColor(skinnableColorStateList)) {
                next.onColorLoaded(skinnableColorStateList);
            }
        }
    }

    @Override // com.tencent.theme.i
    public void onColorReloaded(SkinnableColorStateList skinnableColorStateList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) skinnableColorStateList);
            return;
        }
        Iterator<a> it = this.f288521a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.isFocusedColor(skinnableColorStateList)) {
                next.onColorReloaded(skinnableColorStateList);
            }
        }
    }

    @Override // com.tencent.theme.i
    public void onDrawableLoaded(BaseConstantState baseConstantState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) baseConstantState);
            return;
        }
        Iterator<a> it = this.f288521a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.isFocusedDrawable(baseConstantState)) {
                next.onDrawableLoaded(baseConstantState);
            }
        }
    }

    @Override // com.tencent.theme.i
    public void onDrawableReloaded(BaseConstantState baseConstantState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) baseConstantState);
            return;
        }
        Iterator<a> it = this.f288521a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.isFocusedDrawable(baseConstantState)) {
                next.onDrawableReloaded(baseConstantState);
            }
        }
    }
}
