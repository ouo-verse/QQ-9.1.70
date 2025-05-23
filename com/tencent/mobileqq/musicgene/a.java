package com.tencent.mobileqq.musicgene;

import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a implements DownloadParams.DecodeHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static final HashMap<String, ArrayList<Integer>> f251947d;

    /* renamed from: a, reason: collision with root package name */
    WeakReference<InterfaceC8126a> f251948a;

    /* renamed from: b, reason: collision with root package name */
    Object f251949b;

    /* renamed from: c, reason: collision with root package name */
    String f251950c;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.musicgene.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public interface InterfaceC8126a {
        void a(String str, int i3, int i16, Object obj);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73224);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f251947d = new HashMap<>();
        }
    }

    public a(String str, InterfaceC8126a interfaceC8126a, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, interfaceC8126a, obj);
            return;
        }
        if (interfaceC8126a != null) {
            this.f251948a = new WeakReference<>(interfaceC8126a);
        }
        this.f251950c = str;
        this.f251949b = obj;
    }

    public static List<Integer> a(String str) {
        return f251947d.get(str);
    }

    @Override // com.tencent.image.DownloadParams.DecodeHandler
    public Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
        InterfaceC8126a interfaceC8126a;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloadParams, (Object) bitmap);
        }
        WeakReference<InterfaceC8126a> weakReference = this.f251948a;
        if (weakReference == null) {
            interfaceC8126a = null;
        } else {
            interfaceC8126a = weakReference.get();
        }
        if (interfaceC8126a != null) {
            int[] e16 = c.e(Bitmap.createBitmap(bitmap, 0, bitmap.getHeight() / 2, bitmap.getWidth(), bitmap.getHeight() / 2));
            if (e16 != null && e16.length >= 2) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(Integer.valueOf(e16[0]));
                arrayList.add(Integer.valueOf(e16[1]));
                HashMap<String, ArrayList<Integer>> hashMap = f251947d;
                if (!hashMap.containsKey(this.f251950c)) {
                    hashMap.put(this.f251950c, arrayList);
                }
            }
            interfaceC8126a.a(this.f251950c, e16[0], e16[1], this.f251949b);
        }
        return bitmap;
    }
}
