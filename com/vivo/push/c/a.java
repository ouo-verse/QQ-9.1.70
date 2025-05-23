package com.vivo.push.c;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.app.MessageHandlerConstants;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.vivo.push.util.u;
import com.vivo.push.x;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private Context f387615a;

    /* renamed from: b, reason: collision with root package name */
    private HashMap<String, String> f387616b = new HashMap<>();

    public a(Context context) {
        this.f387615a = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:85:0x00ca A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int e() {
        ContentProviderClient contentProviderClient;
        if (this.f387615a == null) {
            return 8002;
        }
        if (this.f387616b.size() > 0) {
            return 0;
        }
        Cursor cursor = null;
        try {
            try {
                int i3 = Build.VERSION.SDK_INT;
                if (i3 >= 24) {
                    ContentResolver contentResolver = this.f387615a.getContentResolver();
                    Uri uri = x.f387937a;
                    contentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
                    if (contentProviderClient != null) {
                        try {
                            cursor = contentProviderClient.query(uri, null, null, null, null);
                        } catch (Exception e16) {
                            e = e16;
                            u.a("CoreConfigManager", "provider exception", e);
                            if (0 != 0) {
                                try {
                                    cursor.close();
                                } catch (Exception e17) {
                                    u.a("CoreConfigManager", "close err ", e17);
                                    return 8005;
                                }
                            }
                            if (contentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                                contentProviderClient.close();
                                return 8005;
                            }
                            return 8005;
                        }
                    }
                } else {
                    contentProviderClient = null;
                }
                if (cursor == null) {
                    cursor = ContactsMonitor.query(this.f387615a.getContentResolver(), x.f387937a, null, null, null, null);
                }
                if (cursor == null) {
                    u.a("CoreConfigManager", "cursor is null");
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e18) {
                            u.a("CoreConfigManager", "close err ", e18);
                            return MessageHandlerConstants.NOTIFY_TYPE_PC_QQ_SEARCH_MSG_SEND_ERROR_RSP;
                        }
                    }
                    if (contentProviderClient != null && i3 >= 24) {
                        contentProviderClient.close();
                        return MessageHandlerConstants.NOTIFY_TYPE_PC_QQ_SEARCH_MSG_SEND_ERROR_RSP;
                    }
                    return MessageHandlerConstants.NOTIFY_TYPE_PC_QQ_SEARCH_MSG_SEND_ERROR_RSP;
                }
                while (cursor.moveToNext()) {
                    String string = cursor.getString(cursor.getColumnIndex("name"));
                    String string2 = cursor.getString(cursor.getColumnIndex("value"));
                    if (!TextUtils.isEmpty(string)) {
                        this.f387616b.put(string, string2);
                    }
                }
                try {
                    cursor.close();
                    if (contentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                        contentProviderClient.close();
                    }
                } catch (Exception e19) {
                    u.a("CoreConfigManager", "close err ", e19);
                }
                return 0;
            } catch (Exception e26) {
                e = e26;
                contentProviderClient = null;
            } catch (Throwable th5) {
                th = th5;
                if (0 != 0) {
                }
                if (0 != 0) {
                    ((ContentProviderClient) null).close();
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            if (0 != 0) {
                try {
                    cursor.close();
                } catch (Exception e27) {
                    u.a("CoreConfigManager", "close err ", e27);
                    throw th;
                }
            }
            if (0 != 0 && Build.VERSION.SDK_INT >= 24) {
                ((ContentProviderClient) null).close();
            }
            throw th;
        }
    }

    public final int a() {
        int a16 = a(1);
        u.d("CoreConfigManager", "isSupportNewControlStrategies : ".concat(String.valueOf(a16)));
        return a16;
    }

    public final int b() {
        int a16 = a(4);
        u.d("CoreConfigManager", "isSupportSyncProfileInfo : ".concat(String.valueOf(a16)));
        return a16;
    }

    public final boolean c() {
        int a16 = a(8);
        u.d("CoreConfigManager", "isSupportdeleteRegid : ".concat(String.valueOf(a16)));
        if (a16 == 0) {
            return true;
        }
        return false;
    }

    public final boolean d() {
        int a16 = a(16);
        u.d("CoreConfigManager", "isSupportQueryCurrentAppState : ".concat(String.valueOf(a16)));
        if (a16 == 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Not initialized variable reg: 8, insn: 0x00b9: MOVE (r4 I:??[OBJECT, ARRAY]) = (r8 I:??[OBJECT, ARRAY]), block:B:69:0x00b8 */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00aa A[Catch: Exception -> 0x0096, TRY_ENTER, TryCatch #7 {Exception -> 0x0096, blocks: (B:29:0x008b, B:32:0x0092, B:40:0x00aa, B:42:0x00af, B:44:0x00b3), top: B:2:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context, String str) {
        Throwable th5;
        ContentProviderClient contentProviderClient;
        Cursor cursor;
        Cursor cursor2;
        Cursor cursor3 = null;
        cursor3 = null;
        r4 = null;
        r4 = null;
        r4 = null;
        String str2 = null;
        try {
            try {
                try {
                } catch (Exception e16) {
                    e = e16;
                    contentProviderClient = null;
                    cursor = null;
                } catch (Throwable th6) {
                    th5 = th6;
                    contentProviderClient = null;
                }
            } catch (Exception e17) {
                u.a("CoreConfigManager", "queryFromCoreSdk close error", e17);
            }
            if (context == null) {
                u.a("CoreConfigManager", "queryFromCoreSdk context is null");
                return null;
            }
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 24) {
                ContentResolver contentResolver = context.getContentResolver();
                Uri uri = x.f387942f;
                contentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
                if (contentProviderClient != null) {
                    try {
                        u.a("CoreConfigManager", "queryFromCoreSdk client is null");
                        cursor = contentProviderClient.query(uri, null, "queryParameter = ?  ", new String[]{str}, null);
                    } catch (Exception e18) {
                        e = e18;
                        cursor = null;
                        u.a("CoreConfigManager", "queryFromCoreSdk error ", e);
                        if (cursor != null) {
                        }
                        if (contentProviderClient != null) {
                            contentProviderClient.close();
                        }
                        return str2;
                    } catch (Throwable th7) {
                        th5 = th7;
                        if (cursor3 != null) {
                            try {
                                cursor3.close();
                            } catch (Exception e19) {
                                u.a("CoreConfigManager", "queryFromCoreSdk close error", e19);
                                throw th5;
                            }
                        }
                        if (contentProviderClient != null) {
                            if (Build.VERSION.SDK_INT >= 24) {
                                contentProviderClient.close();
                                throw th5;
                            }
                            throw th5;
                        }
                        throw th5;
                    }
                } else {
                    cursor = null;
                }
            } else {
                contentProviderClient = null;
                cursor = null;
            }
            if (cursor == null) {
                try {
                    cursor = ContactsMonitor.query(context.getContentResolver(), x.f387942f, null, "queryParameter = ?  ", new String[]{str}, null);
                } catch (Exception e26) {
                    e = e26;
                    u.a("CoreConfigManager", "queryFromCoreSdk error ", e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (contentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                        contentProviderClient.close();
                    }
                    return str2;
                }
            }
            if (cursor == null) {
                u.a("CoreConfigManager", "queryFromCoreSdk cursor is null");
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e27) {
                        u.a("CoreConfigManager", "queryFromCoreSdk close error", e27);
                    }
                }
                if (contentProviderClient != null && i3 >= 24) {
                    contentProviderClient.close();
                }
                return null;
            }
            str2 = cursor.moveToFirst() ? cursor.getString(cursor.getColumnIndex("queryAppState")) : null;
            cursor.close();
            if (contentProviderClient != null && i3 >= 24) {
                contentProviderClient.close();
            }
            return str2;
        } catch (Throwable th8) {
            th5 = th8;
            cursor3 = cursor2;
        }
    }

    private int a(int i3) {
        int e16 = e();
        if (e16 != 0) {
            return e16;
        }
        HashMap<String, String> hashMap = this.f387616b;
        if (hashMap == null || hashMap.size() == 0) {
            return MessageHandlerConstants.NOTIFY_TYPE_SAME_STATE_MSG_SEND_ERROR_RSP;
        }
        String str = this.f387616b.get("pushSupport");
        if (TextUtils.isEmpty(str)) {
            return 2;
        }
        try {
            return (i3 & Integer.parseInt(str)) > 0 ? 0 : 1;
        } catch (Exception unused) {
            return 8007;
        }
    }
}
