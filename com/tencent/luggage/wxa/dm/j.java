package com.tencent.luggage.wxa.dm;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.ic.l;

/* compiled from: P */
/* loaded from: classes8.dex */
public class j extends e {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements com.tencent.luggage.wxa.jq.g {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.jq.g, com.tencent.luggage.wxa.jq.f
        public String getKey() {
            return "TempFileIconLoader";
        }

        @Override // java.lang.Runnable
        public void run() {
            v absoluteFile = j.this.f124384b.getFileSystem().getAbsoluteFile(j.this.f124383a);
            if (absoluteFile == null) {
                j jVar = j.this;
                jVar.f124385c.a("Failed to load icon via temp file", jVar);
                return;
            }
            Bitmap decodeFile = BitmapFactory.decodeFile(absoluteFile.m());
            if (decodeFile != null) {
                j.this.a(decodeFile);
            } else {
                j jVar2 = j.this;
                jVar2.f124385c.a("Failed to load icon via temp file", jVar2);
            }
        }
    }

    public j(String str, d dVar, l lVar) {
        super(str, dVar, lVar);
    }

    @Override // com.tencent.luggage.wxa.dm.e
    public void e() {
        if (this.f124384b.getFileSystem() != null && this.f124383a != null) {
            com.tencent.luggage.wxa.zp.h.f146825d.execute(new a());
        } else {
            this.f124385c.a("Failed to load icon via temp file", this);
        }
    }
}
