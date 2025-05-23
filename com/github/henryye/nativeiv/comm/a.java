package com.github.henryye.nativeiv.comm;

import android.graphics.Bitmap;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.tencent.luggage.wxa.f.b;
import com.tencent.luggage.wxa.f.c;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a implements b {

    /* renamed from: a, reason: collision with root package name */
    public NativeImageJni f32886a;

    /* renamed from: b, reason: collision with root package name */
    public HashMap f32887b = new HashMap();

    public a() {
        NativeImageJni nativeImageJni = new NativeImageJni();
        this.f32886a = nativeImageJni;
        nativeImageJni.b();
    }

    public void a(NativeImage nativeImage) {
        if (nativeImage == null) {
            return;
        }
        synchronized (this) {
            this.f32887b.put(Integer.valueOf(nativeImage.hashCode()), nativeImage);
        }
    }

    public void b(NativeImage nativeImage) {
        if (nativeImage == null) {
            return;
        }
        synchronized (this) {
            this.f32887b.remove(Integer.valueOf(nativeImage.hashCode()));
        }
    }

    @Override // com.tencent.luggage.wxa.f.b
    public void destroy() {
        this.f32886a.a();
        LinkedList linkedList = new LinkedList();
        synchronized (this) {
            Iterator it = this.f32887b.values().iterator();
            while (it.hasNext()) {
                linkedList.push((NativeImage) it.next());
            }
            this.f32887b.clear();
        }
        Iterator it5 = linkedList.iterator();
        while (it5.hasNext()) {
            ((NativeImage) it5.next()).recycle();
        }
        linkedList.clear();
    }

    @Override // com.tencent.luggage.wxa.f.b
    public IBitmap a() {
        return new NativeImage(this.f32886a, this);
    }

    @Override // com.tencent.luggage.wxa.f.b
    public boolean a(InputStream inputStream, Bitmap.Config config, c cVar) {
        return cVar == c.PNG || cVar == c.JPG;
    }
}
