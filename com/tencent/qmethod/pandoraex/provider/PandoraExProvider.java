package com.tencent.qmethod.pandoraex.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qmethod.pandoraex.core.o;
import com.tencent.qmethod.pandoraex.core.strategy.c;
import java.util.Map;

/* loaded from: classes22.dex */
public class PandoraExProvider extends ContentProvider {

    /* renamed from: e, reason: collision with root package name */
    public static final String[] f344170e = {"KEY", "VALUE"};

    /* renamed from: d, reason: collision with root package name */
    private UriMatcher f344171d;

    private static String a(Context context) {
        return context.getPackageName() + ".pandoraprovider";
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        if (str == null) {
            c.a(getContext());
            return 0;
        }
        c.n(getContext(), str);
        return 0;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        Map.Entry<String, Object> next = contentValues.valueSet().iterator().next();
        if (next == null) {
            o.a("PreferencesProvider", "empty entity found when inserting.");
            return null;
        }
        c.o(getContext(), next.getKey(), next.getValue());
        return uri;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        UriMatcher uriMatcher = new UriMatcher(-1);
        this.f344171d = uriMatcher;
        uriMatcher.addURI(a(getContext()), "SharedPreferences", 1);
        return true;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        String str3;
        String str4;
        if (strArr2 != null && strArr2.length > 1) {
            str3 = strArr2[0];
            str4 = strArr2[1];
        } else {
            str3 = null;
            str4 = null;
        }
        return c.m(getContext(), str3, str4);
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }
}
