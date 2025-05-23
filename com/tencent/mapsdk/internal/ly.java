package com.tencent.mapsdk.internal;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes9.dex */
public class ly extends mc {

    /* renamed from: b, reason: collision with root package name */
    protected String f149291b;

    private String c() {
        return this.f149291b;
    }

    @Override // com.tencent.mapsdk.internal.mc, com.tencent.mapsdk.internal.lu
    public final InputStream e(String str) {
        try {
            String file = new URL(str).getFile();
            if (!hs.a(file)) {
                this.f149291b = file.substring(file.lastIndexOf("/") + 1).replace("%20", " ");
            }
        } catch (MalformedURLException e16) {
            e16.printStackTrace();
        }
        return super.e(str);
    }
}
