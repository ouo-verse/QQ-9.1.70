package com.tencent.mobileqq.utils;

import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* compiled from: P */
/* loaded from: classes20.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public static String f307808a;

    /* renamed from: b, reason: collision with root package name */
    public static String f307809b;

    protected abstract Object a(XmlPullParser xmlPullParser) throws Exception;

    protected abstract int b();

    public void c(Context context) {
        if (FileUtils.fileExistsAndNotEmpty(f307809b)) {
            boolean d16 = d(f307809b);
            if (QLog.isColorLevel()) {
                QLog.d("BaseConfigFileParser", 2, "parseXmlFromOutside: success = " + d16);
            }
            if (!d16) {
                e(context);
                return;
            }
            return;
        }
        e(context);
    }

    boolean d(String str) {
        FileInputStream fileInputStream = null;
        try {
            try {
                File file = new File(str);
                if (file.exists() && file.isFile()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("BaseConfigFileParser", 2, "parseXmlFromOutside: Xml path:" + file.getAbsolutePath());
                    }
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                        newPullParser.setInput(fileInputStream2, "UTF-8");
                        Object a16 = a(newPullParser);
                        try {
                            fileInputStream2.close();
                        } catch (IOException unused) {
                        }
                        if (a16 == null) {
                            return false;
                        }
                        f(a16);
                        return true;
                    } catch (Exception e16) {
                        fileInputStream = fileInputStream2;
                        e = e16;
                        if (QLog.isColorLevel()) {
                            QLog.e("BaseConfigFileParser", 2, "parseXmlFromOutside : parse xml error ====>", e);
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        return false;
                    } catch (Throwable th5) {
                        fileInputStream = fileInputStream2;
                        th = th5;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th;
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.e("BaseConfigFileParser", 2, "parseXmlFromOutside: Xml file not exits, path:" + file.getAbsolutePath());
                }
                return false;
            } catch (Exception e17) {
                e = e17;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    void e(Context context) {
        Object obj;
        if (QLog.isColorLevel()) {
            QLog.d("BaseConfigFileParser", 2, "parseXmlFromRes");
        }
        try {
            obj = a(context.getResources().getXml(b()));
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("BaseConfigFileParser", 2, "parseXmlFromRes doParseRules exception:", e16);
            }
            obj = null;
        }
        if (obj != null) {
            f(obj);
        }
    }

    protected abstract void f(Object obj);
}
