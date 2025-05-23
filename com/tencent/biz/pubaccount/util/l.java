package com.tencent.biz.pubaccount.util;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.FileObserver;
import android.provider.MediaStore;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes4.dex */
public class l extends ContentObserver {

    /* renamed from: g, reason: collision with root package name */
    private static final String f80353g = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString();

    /* renamed from: h, reason: collision with root package name */
    private static final String[] f80354h = {"_data", "date_added"};

    /* renamed from: i, reason: collision with root package name */
    private static final String f80355i = HardCodeUtil.qqStr(R.string.t5e);

    /* renamed from: a, reason: collision with root package name */
    private ContentResolver f80356a;

    /* renamed from: b, reason: collision with root package name */
    private FileObserver f80357b;

    /* renamed from: c, reason: collision with root package name */
    private String f80358c;

    /* renamed from: d, reason: collision with root package name */
    private int f80359d;

    /* renamed from: e, reason: collision with root package name */
    private int f80360e;

    /* renamed from: f, reason: collision with root package name */
    private a f80361f;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface a {
        void c(Uri uri, String str, int i3);
    }

    public l(Context context, int i3, int i16) {
        super(null);
        this.f80359d = i3;
        this.f80360e = i16;
        this.f80356a = context.getContentResolver();
        d();
    }

    private boolean a(long j3) {
        if (System.currentTimeMillis() - (j3 * 1000) < 1500) {
            return true;
        }
        return false;
    }

    private boolean b(String str) {
        String lowerCase = str.toLowerCase();
        if (!lowerCase.contains("screenshot") && !lowerCase.contains(f80355i)) {
            return false;
        }
        return true;
    }

    private void d() {
        this.f80356a.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this);
    }

    private void f() {
        this.f80356a.unregisterContentObserver(this);
    }

    public void c() {
        f();
        this.f80357b = null;
        this.f80356a = null;
        this.f80361f = null;
    }

    public void e(a aVar) {
        this.f80361f = aVar;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z16) {
        super.onChange(z16);
        onChange(z16, null);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:129:0x00d3 -> B:12:0x0192). Please report as a decompilation issue!!! */
    @Override // android.database.ContentObserver
    public void onChange(boolean z16, Uri uri) {
        String string;
        if (QLog.isDevelopLevel()) {
            QLog.d("ScreenshotContentObserver", 2, "onChange->time:" + System.currentTimeMillis());
        }
        Cursor cursor = null;
        try {
            try {
                try {
                    try {
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                    if (uri == null) {
                        try {
                            Cursor query = ContactsMonitor.query(this.f80356a, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, f80354h, null, null, "date_added DESC");
                            if (query != null) {
                                try {
                                    if (query.getCount() > 0) {
                                        query.moveToFirst();
                                        int columnIndex = query.getColumnIndex("_data");
                                        string = columnIndex >= 0 ? query.getString(columnIndex) : "";
                                        int columnIndex2 = query.getColumnIndex("date_added");
                                        if (a(columnIndex2 >= 0 ? query.getLong(columnIndex2) : 0L) && b(string)) {
                                            if (QLog.isColorLevel()) {
                                                QLog.d("ScreenshotContentObserver", 2, "onChange->path:" + string + ", uri:null");
                                            }
                                            if (string != null) {
                                                if (string.equalsIgnoreCase(this.f80358c)) {
                                                    try {
                                                        query.close();
                                                        return;
                                                    } catch (Exception e17) {
                                                        e17.printStackTrace();
                                                        return;
                                                    }
                                                }
                                                this.f80358c = string;
                                            }
                                            a aVar = this.f80361f;
                                            if (aVar != null) {
                                                aVar.c(uri, string, 1);
                                            }
                                        }
                                    }
                                } catch (Exception e18) {
                                    e = e18;
                                    cursor = query;
                                    e.printStackTrace();
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    return;
                                } catch (Throwable th5) {
                                    th = th5;
                                    cursor = query;
                                    Throwable th6 = th;
                                    if (cursor != null) {
                                        try {
                                            cursor.close();
                                            throw th6;
                                        } catch (Exception e19) {
                                            e19.printStackTrace();
                                            throw th6;
                                        }
                                    }
                                    throw th6;
                                }
                            }
                            if (query != null) {
                                query.close();
                            }
                        } catch (Exception e26) {
                            e = e26;
                        }
                        return;
                    }
                    try {
                        if (uri.toString().startsWith(f80353g)) {
                            Cursor query2 = ContactsMonitor.query(this.f80356a, uri, f80354h, null, null, "date_added DESC");
                            if (query2 != null) {
                                try {
                                    if (query2.getCount() > 0) {
                                        query2.moveToFirst();
                                        int columnIndex3 = query2.getColumnIndex("_data");
                                        string = columnIndex3 >= 0 ? query2.getString(columnIndex3) : "";
                                        int columnIndex4 = query2.getColumnIndex("date_added");
                                        if (a(columnIndex4 >= 0 ? query2.getLong(columnIndex4) : 0L) && b(string)) {
                                            if (QLog.isColorLevel()) {
                                                QLog.d("ScreenshotContentObserver", 2, "onChange->path:" + string + ", uri:" + uri);
                                            }
                                            if (string != null) {
                                                if (string.equalsIgnoreCase(this.f80358c)) {
                                                    try {
                                                        query2.close();
                                                        return;
                                                    } catch (Exception e27) {
                                                        e27.printStackTrace();
                                                        return;
                                                    }
                                                }
                                                this.f80358c = string;
                                            }
                                            a aVar2 = this.f80361f;
                                            if (aVar2 != null) {
                                                aVar2.c(uri, string, 1);
                                            }
                                        }
                                    }
                                } catch (Exception e28) {
                                    e = e28;
                                    cursor = query2;
                                    e.printStackTrace();
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    return;
                                } catch (Throwable th7) {
                                    th = th7;
                                    cursor = query2;
                                    Throwable th8 = th;
                                    if (cursor != null) {
                                        try {
                                            cursor.close();
                                            throw th8;
                                        } catch (Exception e29) {
                                            e29.printStackTrace();
                                            throw th8;
                                        }
                                    }
                                    throw th8;
                                }
                            }
                            cursor = query2;
                        }
                    } catch (Exception e36) {
                        e = e36;
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th9) {
                    th = th9;
                }
            } catch (Exception e37) {
                e37.printStackTrace();
            }
        } catch (Throwable th10) {
            th = th10;
        }
    }
}
