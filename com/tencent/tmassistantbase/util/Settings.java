package com.tencent.tmassistantbase.util;

/* compiled from: P */
/* loaded from: classes26.dex */
public class Settings {
    private com.tencent.tmdownloader.internal.storage.table.e mSetting;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static Settings f380434a = new Settings();
    }

    public static Settings getInstance() {
        return b.f380434a;
    }

    public byte[] getBlob(String str) {
        if (!l.e()) {
            return com.tencent.tmdownloader.c.a().a(str);
        }
        return this.mSetting.b(str);
    }

    public boolean getBoolean(String str) {
        if (!l.e()) {
            return com.tencent.tmdownloader.c.a().b(str);
        }
        return this.mSetting.c(str);
    }

    public int getInt(String str) {
        if (!l.e()) {
            return com.tencent.tmdownloader.c.a().c(str);
        }
        return this.mSetting.d(str);
    }

    public long getLong(String str) {
        if (!l.e()) {
            return com.tencent.tmdownloader.c.a().d(str);
        }
        return this.mSetting.e(str);
    }

    public String getString(String str) {
        if (!l.e()) {
            return com.tencent.tmdownloader.c.a().e(str);
        }
        return this.mSetting.f(str);
    }

    public void setBlob(String str, byte[] bArr) {
        if (!l.e()) {
            com.tencent.tmdownloader.c.a().a(str, bArr);
        } else {
            this.mSetting.a(str, bArr);
        }
    }

    public void setBoolean(String str, boolean z16) {
        if (!l.e()) {
            com.tencent.tmdownloader.c.a().a(str, z16);
        } else {
            this.mSetting.a(str, z16);
        }
    }

    public void setInt(String str, int i3) {
        if (!l.e()) {
            com.tencent.tmdownloader.c.a().a(str, i3);
        } else {
            this.mSetting.a(str, i3);
        }
    }

    public void setLong(String str, long j3) {
        if (!l.e()) {
            com.tencent.tmdownloader.c.a().a(str, j3);
        } else {
            this.mSetting.a(str, j3);
        }
    }

    public void setString(String str, String str2) {
        if (!l.e()) {
            com.tencent.tmdownloader.c.a().a(str, str2);
        } else {
            this.mSetting.a(str, str2);
        }
    }

    Settings() {
        com.tencent.tmdownloader.internal.storage.table.e eVar = new com.tencent.tmdownloader.internal.storage.table.e();
        this.mSetting = eVar;
        eVar.a();
    }
}
