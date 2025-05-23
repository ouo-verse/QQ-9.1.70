package com.tencent.qqnt.aio.menu.ui;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes23.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static int f351562a;

    /* renamed from: b, reason: collision with root package name */
    public static final int f351563b;

    static {
        int i3;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48231);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f351562a = Integer.MAX_VALUE;
        if (ViewUtils.getDensity() > 1.5f && FontSettingManager.getFontLevel() <= 16.0f) {
            i3 = 5;
        } else {
            i3 = 4;
        }
        f351563b = i3;
    }

    private static void a(c cVar) {
        d b16 = cVar.b(0);
        if (b16 == null || b16.d() == null || b16.d().getMsgRecord().getMsgType() != 11 || cVar.f351557a.size() <= f351563b) {
            return;
        }
        ArrayList arrayList = new ArrayList(cVar.f351557a);
        BaseApplication context = BaseApplication.getContext();
        String string = context.getString(R.string.f208185c1);
        String string2 = context.getString(R.string.ypn);
        String string3 = context.getString(R.string.f207755av);
        String string4 = context.getString(R.string.f207525a9);
        Iterator it = arrayList.iterator();
        d dVar = null;
        d dVar2 = null;
        d dVar3 = null;
        d dVar4 = null;
        while (it.hasNext()) {
            d dVar5 = (d) it.next();
            if (dVar5 != null) {
                String f16 = dVar5.f();
                if (string.equals(f16)) {
                    dVar = dVar5;
                } else if (string2.equals(f16)) {
                    dVar2 = dVar5;
                } else if (string3.equals(f16)) {
                    dVar3 = dVar5;
                } else if (string4.equals(f16)) {
                    dVar4 = dVar5;
                }
            }
        }
        if (dVar != null && dVar2 != null) {
            if (dVar3 != null && dVar4 != null) {
                return;
            }
            arrayList.remove(dVar);
            arrayList.add(arrayList.indexOf(dVar2) + 1, dVar);
            cVar.f351557a.clear();
            cVar.f351557a.addAll(arrayList);
        }
    }

    public static void b(c cVar) {
        List<d> list;
        if (cVar != null && (list = cVar.f351557a) != null && !list.isEmpty()) {
            c(cVar);
            a(cVar);
        }
    }

    private static void c(c cVar) {
        ArrayList arrayList = new ArrayList(cVar.f351557a);
        BaseApplication context = BaseApplication.getContext();
        String string = context.getString(R.string.f207755av);
        String string2 = context.getString(R.string.f207525a9);
        String string3 = context.getString(R.string.f208705df);
        String string4 = context.getString(R.string.f208715dg);
        String string5 = context.getString(R.string.f207535a_);
        String string6 = context.getString(R.string.f207505a7);
        String string7 = context.getString(R.string.f223046f6);
        String string8 = context.getString(R.string.f207445a1);
        String string9 = context.getString(R.string.f169732j5);
        Iterator it = arrayList.iterator();
        d dVar = null;
        d dVar2 = null;
        d dVar3 = null;
        d dVar4 = null;
        d dVar5 = null;
        d dVar6 = null;
        d dVar7 = null;
        while (it.hasNext()) {
            d dVar8 = (d) it.next();
            if (dVar8 != null) {
                Iterator it5 = it;
                String f16 = dVar8.f();
                if (string.equals(f16)) {
                    dVar = dVar8;
                } else if (string2.equals(f16)) {
                    dVar2 = dVar8;
                } else if (!string3.equals(f16) && !string4.equals(f16)) {
                    if (!string5.equals(f16) && !string6.equals(f16)) {
                        if (string7.equals(f16)) {
                            dVar5 = dVar8;
                        } else if (string8.equals(f16)) {
                            dVar6 = dVar8;
                        } else if (string9.equals(f16)) {
                            dVar7 = dVar8;
                        }
                    } else {
                        dVar4 = dVar8;
                    }
                } else {
                    dVar3 = dVar8;
                }
                it = it5;
            }
        }
        if (dVar != null && dVar2 != null) {
            if (cVar.f351557a.size() > f351563b) {
                d[] dVarArr = {dVar, dVar3, dVar4, dVar5, dVar6, dVar7};
                for (int i3 = 0; i3 < 6; i3++) {
                    d dVar9 = dVarArr[i3];
                    if (dVar9 != null) {
                        arrayList.remove(dVar9);
                    }
                }
                for (int i16 = 0; i16 < 6; i16++) {
                    d dVar10 = dVarArr[i16];
                    if (dVar10 != null) {
                        arrayList.add(dVar10);
                    }
                }
            } else {
                arrayList.remove(dVar);
                arrayList.add(arrayList.indexOf(dVar2), dVar);
            }
        }
        cVar.f351557a.clear();
        cVar.f351557a.addAll(arrayList);
    }
}
