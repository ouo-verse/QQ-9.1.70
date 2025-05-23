package com.tencent.tbs.one.impl.c;

import android.content.Context;
import com.tencent.tbs.one.TBSOneComponent;
import java.io.File;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class a implements TBSOneComponent {

    /* renamed from: a, reason: collision with root package name */
    Context f374632a;

    /* renamed from: b, reason: collision with root package name */
    ClassLoader f374633b;

    /* renamed from: c, reason: collision with root package name */
    Object f374634c;

    /* renamed from: d, reason: collision with root package name */
    private String f374635d;

    /* renamed from: e, reason: collision with root package name */
    private String f374636e;

    /* renamed from: f, reason: collision with root package name */
    private int f374637f;

    /* renamed from: g, reason: collision with root package name */
    private File f374638g;

    public a(String str, String str2, int i3, File file) {
        this.f374635d = str;
        this.f374636e = str2;
        this.f374637f = i3;
        this.f374638g = file;
    }

    @Override // com.tencent.tbs.one.TBSOneComponent
    public final ClassLoader getEntryClassLoader() {
        return this.f374633b;
    }

    @Override // com.tencent.tbs.one.TBSOneComponent
    public final Object getEntryObject() {
        return this.f374634c;
    }

    @Override // com.tencent.tbs.one.TBSOneComponent
    public final File getInstallationDirectory() {
        return this.f374638g;
    }

    @Override // com.tencent.tbs.one.TBSOneComponent
    public final String getName() {
        return this.f374635d;
    }

    @Override // com.tencent.tbs.one.TBSOneComponent
    public final Context getResourcesContext() {
        return this.f374632a;
    }

    @Override // com.tencent.tbs.one.TBSOneComponent
    public final int getVersionCode() {
        return this.f374637f;
    }

    @Override // com.tencent.tbs.one.TBSOneComponent
    public final String getVersionName() {
        return this.f374636e;
    }

    public final String toString() {
        String name;
        Object[] objArr = new Object[7];
        objArr[0] = this.f374635d;
        objArr[1] = this.f374636e;
        objArr[2] = Integer.valueOf(this.f374637f);
        objArr[3] = this.f374638g;
        objArr[4] = this.f374632a;
        objArr[5] = this.f374633b;
        Object obj = this.f374634c;
        if (obj == null) {
            name = null;
        } else {
            name = obj.getClass().getName();
        }
        objArr[6] = name;
        return String.format("{name: '%s', versionName: '%s', versionCode: %d, installationDirectory: '%s', apkContext: '%s', entryClassLoader: '%s', entryObject: '%s'}", objArr);
    }
}
