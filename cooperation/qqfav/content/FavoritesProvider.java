package cooperation.qqfav.content;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavHelper;
import cooperation.qqfav.content.a;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppContentProvider;
import mqq.app.AppRuntime;

/* loaded from: classes28.dex */
public class FavoritesProvider extends AppContentProvider implements a {

    /* renamed from: d, reason: collision with root package name */
    private UriMatcher f390605d;

    /* renamed from: e, reason: collision with root package name */
    private Map<Integer, a.InterfaceC10111a> f390606e;

    /* renamed from: f, reason: collision with root package name */
    private String f390607f;

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0079, code lost:
    
        if (r8 != null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x007d, code lost:
    
        r13 = r13.getLastPathSegment();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x008e, code lost:
    
        if (r12.f390607f.equals(r13) == false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0090, code lost:
    
        r1 = r12.f390606e.get(java.lang.Integer.valueOf(r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x009c, code lost:
    
        if (r1 == null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x009e, code lost:
    
        if (r0 == 100) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a0, code lost:
    
        if (r0 == 101) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00b2, code lost:
    
        if (r1.getClass().getSimpleName().equals("com.qqfav.data.BizRelatedData$GlobalSearchProxy") == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00b4, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0112, code lost:
    
        if (r0 == 100) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0114, code lost:
    
        if (r0 == 101) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0116, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0117, code lost:
    
        r13 = (cooperation.qqfav.content.a.InterfaceC10111a) cooperation.qqfav.QfavHelper.e("com.qqfav.data.BizRelatedData$GlobalSearchProxy", null, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x012a, code lost:
    
        if (r13 == null) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x012c, code lost:
    
        r12.f390606e.put(java.lang.Integer.valueOf(r0), r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0135, code lost:
    
        return r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x013a, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x013c, code lost:
    
        com.tencent.qphone.base.util.QLog.e("qqfav|FavoritesProvider", 2, "getProxy|never should goto here");
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0121, code lost:
    
        r13 = (cooperation.qqfav.content.a.InterfaceC10111a) cooperation.qqfav.QfavHelper.e("com.qqfav.data.BizRelatedData$Proxy", null, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c4, code lost:
    
        if (r1.getClass().getSimpleName().equals("com.qqfav.data.BizRelatedData$Proxy") == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c6, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00cb, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00cd, code lost:
    
        com.tencent.qphone.base.util.QLog.e("qqfav|FavoritesProvider", 2, "getProxy|match cacheuin but provider null, match=" + r0 + ",uin=" + r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e9, code lost:
    
        r12.f390606e.clear();
        r12.f390607f = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00f4, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isDevelopLevel() == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00f6, code lost:
    
        com.tencent.qphone.base.util.QLog.e("qqfav|FavoritesProvider", 4, "getProxy|cache uin unmatch, match=" + r0 + ",uin=" + r13);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private a.InterfaceC10111a a(Uri uri) {
        boolean z16;
        int match = this.f390605d.match(uri);
        if (match == -1) {
            if (QLog.isColorLevel()) {
                QLog.e("qqfav|FavoritesProvider", 2, "getProxy| mismatch! uri=" + uri.toString());
            }
            return null;
        }
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        boolean z17 = true;
        if (Thread.currentThread().getId() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        AppRuntime appRuntime = null;
        int i3 = 0;
        while (true) {
            if ((application != null && appRuntime != null) || z16 || i3 >= 10) {
                break;
            }
            application = BaseApplicationImpl.getApplication();
            if (application != null) {
                if (z17) {
                    QfavHelper.r(false);
                    z17 = false;
                }
                if (QfavHelper.s() && (appRuntime = application.getRuntime()) != null) {
                    break;
                }
            }
            try {
                LockMethodProxy.sleep(30L);
            } catch (InterruptedException e16) {
                e16.printStackTrace();
            }
            i3++;
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        a.InterfaceC10111a a16 = a(uri);
        if (a16 != null) {
            return a16.delete(uri, str, strArr);
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        a.InterfaceC10111a a16 = a(uri);
        if (a16 != null) {
            return a16.insert(uri, contentValues);
        }
        return null;
    }

    @Override // mqq.app.AppContentProvider, android.content.ContentProvider
    public boolean onCreate() {
        super.onCreate();
        UriMatcher uriMatcher = new UriMatcher(-1);
        this.f390605d = uriMatcher;
        uriMatcher.addURI("qq.favorites", "biz_related/#", 100);
        this.f390605d.addURI("qq.favorites", "global_search/#", 101);
        this.f390606e = new HashMap();
        this.f390607f = "";
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        a.InterfaceC10111a a16 = a(uri);
        if (QLog.isDevelopLevel()) {
            QLog.d("qqfav|FavoritesProvider", 4, "query|" + a16 + ",uri=" + uri + ",selection=" + str);
        }
        if (a16 == null) {
            return null;
        }
        try {
            return a16.query(uri, strArr, str, strArr2, str2);
        } catch (Throwable th5) {
            QLog.e("qqfav|FavoritesProvider", 1, "query", th5);
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        a.InterfaceC10111a a16 = a(uri);
        if (a16 != null) {
            return a16.update(uri, contentValues, str, strArr);
        }
        return 0;
    }
}
