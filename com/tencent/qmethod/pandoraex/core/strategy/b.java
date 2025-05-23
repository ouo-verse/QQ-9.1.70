package com.tencent.qmethod.pandoraex.core.strategy;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.tencent.mobileqq.mini.cache.Entry;
import com.tencent.qmethod.pandoraex.api.g;
import com.tencent.qmethod.pandoraex.core.o;
import com.tencent.qmethod.pandoraex.core.strategy.CacheStrategyFactory;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qmethod.pandoraex.provider.PandoraExProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b implements g {

    /* renamed from: a, reason: collision with root package name */
    private static volatile b f344161a;

    private static String p(Context context) {
        return "content://" + context.getPackageName() + ".pandoraprovider/SharedPreferences";
    }

    public static b q(Context context) {
        if (f344161a == null) {
            synchronized (b.class) {
                if (f344161a == null) {
                    f344161a = new b();
                    f344161a.r(context);
                }
            }
        }
        return f344161a;
    }

    @Override // com.tencent.qmethod.pandoraex.api.g
    public String a(Context context, String str) {
        try {
            return c.k(ContactsMonitor.query(context.getContentResolver(), Uri.parse(p(context)), PandoraExProvider.f344170e, null, new String[]{str, Entry.DATA_TYPE_STRING}, null));
        } catch (Exception e16) {
            o.d("ProviderStrategy", "ContentProvider get data error: ", e16);
            return "";
        }
    }

    @Override // com.tencent.qmethod.pandoraex.api.g
    public Integer b(Context context, String str) {
        try {
            return c.g(ContactsMonitor.query(context.getContentResolver(), Uri.parse(p(context)), PandoraExProvider.f344170e, null, new String[]{str, "Integer"}, null));
        } catch (Exception e16) {
            o.d("ProviderStrategy", "ContentProvider get data error: ", e16);
            return 0;
        }
    }

    @Override // com.tencent.qmethod.pandoraex.api.g
    public boolean c(Context context, String str, Long l3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, l3);
        try {
            context.getContentResolver().insert(Uri.parse(p(context)), contentValues);
            return true;
        } catch (Exception e16) {
            o.d("ProviderStrategy", "ContentProvider save data error: ", e16);
            return false;
        }
    }

    @Override // com.tencent.qmethod.pandoraex.api.g
    public boolean d(Context context, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, str2);
        try {
            context.getContentResolver().insert(Uri.parse(p(context)), contentValues);
            return true;
        } catch (Exception e16) {
            o.d("ProviderStrategy", "ContentProvider save data error: ", e16);
            return false;
        }
    }

    @Override // com.tencent.qmethod.pandoraex.api.g
    public boolean e(Context context, String str, Integer num) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, num);
        try {
            context.getContentResolver().insert(Uri.parse(p(context)), contentValues);
            return true;
        } catch (Exception e16) {
            o.d("ProviderStrategy", "ContentProvider save data error: ", e16);
            return false;
        }
    }

    @Override // com.tencent.qmethod.pandoraex.api.g
    public Long f(Context context, String str) {
        try {
            return c.j(ContactsMonitor.query(context.getContentResolver(), Uri.parse(p(context)), PandoraExProvider.f344170e, null, new String[]{str, "Long"}, null));
        } catch (Exception e16) {
            o.d("ProviderStrategy", "ContentProvider get data error: ", e16);
            return 0L;
        }
    }

    @Override // com.tencent.qmethod.pandoraex.api.g
    public Boolean g(Context context, String str) {
        try {
            return c.d(ContactsMonitor.query(context.getContentResolver(), Uri.parse(p(context)), PandoraExProvider.f344170e, null, new String[]{str, "Boolean"}, null));
        } catch (Exception e16) {
            o.d("ProviderStrategy", "ContentProvider get data error: ", e16);
            return Boolean.FALSE;
        }
    }

    @Override // com.tencent.qmethod.pandoraex.api.g
    public <T extends Parcelable> T h(Context context, String str, Class<T> cls) {
        String a16 = a(context, str);
        if (TextUtils.isEmpty(a16) || "data is null".equals(a16)) {
            return null;
        }
        try {
            return (T) new GsonBuilder().registerTypeAdapter(CharSequence.class, new CacheStrategyFactory.CharSequenceAdapter()).create().fromJson(new JsonParser().parse(a16).getAsString(), (Class) cls);
        } catch (Exception e16) {
            o.d("ProviderStrategy", "fromJson error: ", e16);
            return null;
        }
    }

    @Override // com.tencent.qmethod.pandoraex.api.g
    public boolean i(Context context, String str, Parcelable parcelable) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(str, parcelable.toString());
            context.getContentResolver().insert(Uri.parse(p(context)), contentValues);
            return true;
        } catch (Exception e16) {
            o.d("ProviderStrategy", "ContentProvider save data error: ", e16);
            return false;
        }
    }

    @Override // com.tencent.qmethod.pandoraex.api.g
    public void j(Context context, String str) {
        try {
            py3.b.e(context.getContentResolver(), Uri.parse(p(context)), str, null);
        } catch (Exception e16) {
            o.d("ProviderStrategy", "ContentProvider save data error: ", e16);
        }
    }

    @Override // com.tencent.qmethod.pandoraex.api.g
    public void k(Context context) {
        try {
            py3.b.e(context.getContentResolver(), Uri.parse(p(context)), null, null);
        } catch (Exception e16) {
            o.d("ProviderStrategy", "ContentProvider save data error: ", e16);
        }
    }

    @Override // com.tencent.qmethod.pandoraex.api.g
    public <T> List<T> l(Context context, String str, Class<T> cls) {
        String a16 = a(context, str);
        if (!TextUtils.isEmpty(a16) && !"data is null".equals(a16)) {
            ArrayList arrayList = new ArrayList();
            try {
                Gson create = new GsonBuilder().registerTypeAdapter(CharSequence.class, new CacheStrategyFactory.CharSequenceAdapter()).create();
                Iterator<JsonElement> it = new JsonParser().parse(a16).getAsJsonArray().iterator();
                while (it.hasNext()) {
                    arrayList.add(create.fromJson(it.next(), (Class) cls));
                }
                return arrayList;
            } catch (Exception e16) {
                o.d("ProviderStrategy", "fromJson error: ", e16);
                return new ArrayList();
            }
        }
        return new ArrayList();
    }

    @Override // com.tencent.qmethod.pandoraex.api.g
    public Boolean m(Context context, String str) {
        if (context == null) {
            return Boolean.FALSE;
        }
        try {
            return Boolean.valueOf(c.b(ContactsMonitor.query(context.getContentResolver(), Uri.parse(p(context)), PandoraExProvider.f344170e, null, new String[]{str, "CT"}, null)));
        } catch (Exception e16) {
            o.d("ProviderStrategy", "ContentProvider get data error: ", e16);
            return Boolean.FALSE;
        }
    }

    @Override // com.tencent.qmethod.pandoraex.api.g
    public boolean n(Context context, String str, Boolean bool) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, bool);
        try {
            context.getContentResolver().insert(Uri.parse(p(context)), contentValues);
            return true;
        } catch (Exception e16) {
            o.d("ProviderStrategy", "ContentProvider save data error: ", e16);
            return false;
        }
    }

    @Override // com.tencent.qmethod.pandoraex.api.g
    public <T> boolean o(Context context, String str, List<T> list) {
        return d(context, str, new Gson().toJson(list));
    }

    public void r(Context context) {
        if (context == null) {
            return;
        }
        if (!m(context, "version").booleanValue()) {
            k(context);
            d(context, "version", "2");
            o.a("ProviderStrategy", "OnUpdate: first no version");
            return;
        }
        String a16 = a(context, "version");
        if (!"2".equals(a16)) {
            k(context);
            d(context, "version", "2");
            o.a("ProviderStrategy", "OnUpdate: old version is " + a16 + " new version is 2");
        }
    }
}
