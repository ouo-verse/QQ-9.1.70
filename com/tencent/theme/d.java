package com.tencent.theme;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.util.LongSparseArray;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@TargetApi(16)
/* loaded from: classes26.dex */
public class d extends c {
    static IPatchRedirector $redirector_;

    public d(SkinEngine skinEngine, Resources resources, LongSparseArray longSparseArray, int i3, int i16, int i17) {
        super(skinEngine, resources, longSparseArray, i3, i16, i17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, this, skinEngine, resources, longSparseArray, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
    }

    @Override // com.tencent.theme.c, android.util.LongSparseArray
    public Object get(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, j3);
        }
        Integer num = this.f376047d.get(j3);
        if (num == null) {
            return this.f376048e.get(j3);
        }
        SkinnableColorStateList loadColorStateList = this.f376049f.loadColorStateList(num.intValue());
        if (loadColorStateList != null) {
            return loadColorStateList.mmFactory;
        }
        return null;
    }

    public d(SkinEngine skinEngine, Resources resources, int[] iArr, LongSparseArray longSparseArray) {
        super(skinEngine, resources, iArr, longSparseArray);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, skinEngine, resources, iArr, longSparseArray);
    }
}
