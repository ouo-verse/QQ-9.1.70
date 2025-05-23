package kf4;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    public static a f412309c = new a("", "");

    /* renamed from: a, reason: collision with root package name */
    public String f412310a;

    /* renamed from: b, reason: collision with root package name */
    public String f412311b;

    public a(String str, String str2) {
        this.f412310a = str;
        this.f412311b = str2;
    }

    public String a() {
        if (TextUtils.isEmpty(this.f412310a) && TextUtils.isEmpty(this.f412311b)) {
            return toString() + hashCode();
        }
        return this.f412310a + "_" + this.f412311b;
    }

    public boolean b() {
        if (!TextUtils.isEmpty(this.f412310a) && !TextUtils.isEmpty(this.f412311b)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "GuildIdInfo{guildId='" + this.f412310a + "', channelId='" + this.f412311b + "'}";
    }
}
