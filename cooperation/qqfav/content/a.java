package cooperation.qqfav.content;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface a {
    public static final Uri A4 = Uri.parse("content://qq.favorites/biz_related");
    public static final Uri B4 = Uri.parse("content://qq.favorites/global_search");

    /* compiled from: P */
    /* renamed from: cooperation.qqfav.content.a$a, reason: collision with other inner class name */
    /* loaded from: classes28.dex */
    public interface InterfaceC10111a {
        int delete(Uri uri, String str, String[] strArr);

        Uri insert(Uri uri, ContentValues contentValues);

        Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2);

        int update(Uri uri, ContentValues contentValues, String str, String[] strArr);
    }
}
