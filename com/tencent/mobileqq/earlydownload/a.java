package com.tencent.mobileqq.earlydownload;

import android.content.SharedPreferences;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.earlydownload.xmldata.saveInSP;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import mqq.app.MobileQQ;
import org.xml.sax.SAXException;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static Field a(Class<? extends XmlData> cls, String str) {
        Field field = null;
        if (cls != null && str != null && str.length() != 0) {
            while (cls != Entity.class) {
                try {
                    field = cls.getDeclaredField(str);
                } catch (NoSuchFieldException unused) {
                }
                if (field != null) {
                    break;
                }
                cls = cls.getSuperclass();
            }
        }
        return field;
    }

    public static void b(XmlData xmlData) {
        String sharedPreferencesName;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("freeSP() data=");
            if (xmlData == null) {
                sharedPreferencesName = "null";
            } else {
                sharedPreferencesName = xmlData.getSharedPreferencesName();
            }
            sb5.append(sharedPreferencesName);
            QLog.d("EarlyDown", 2, sb5.toString());
        }
        if (xmlData == null) {
            return;
        }
        SharedPreferences.Editor edit = MobileQQ.sMobileQQ.getApplicationContext().getSharedPreferences(xmlData.getSharedPreferencesName(), 0).edit();
        edit.clear();
        edit.commit();
    }

    public static Field[] c(Class<? extends XmlData> cls) {
        int i3;
        ArrayList arrayList = new ArrayList();
        while (true) {
            i3 = 0;
            if (cls == Entity.class) {
                break;
            }
            Field[] declaredFields = cls.getDeclaredFields();
            if (declaredFields != null) {
                int length = declaredFields.length;
                while (i3 < length) {
                    Field field = declaredFields[i3];
                    if (field != null && !Modifier.isStatic(field.getModifiers())) {
                        arrayList.add(field);
                    }
                    i3++;
                }
            }
            cls = cls.getSuperclass();
        }
        int size = arrayList.size();
        Field[] fieldArr = new Field[size];
        while (i3 < size) {
            fieldArr[i3] = (Field) arrayList.get(i3);
            i3++;
        }
        return fieldArr;
    }

    public static XmlData d(Class<? extends XmlData> cls, String str, String str2, String str3, long j3, String str4, String str5) {
        String canonicalName;
        XmlData xmlData = null;
        if (cls != null && str != null && str.length() != 0 && str2 != null && str2.length() != 0 && str3 != null && str3.length() != 0 && str4 != null && str4.length() != 0) {
            try {
                c cVar = new c(cls);
                SAXParserFactory.newInstance().newSAXParser().parse(new ByteArrayInputStream(str3.getBytes()), cVar);
                xmlData = cVar.a();
            } catch (IOException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("EarlyDown", 2, "parse() throw Exception:" + e16.getMessage());
                }
            } catch (ParserConfigurationException e17) {
                if (QLog.isColorLevel()) {
                    QLog.e("EarlyDown", 2, "parse() throw Exception:" + e17.getMessage());
                }
            } catch (SAXException e18) {
                if (QLog.isColorLevel()) {
                    QLog.e("EarlyDown", 2, "parse() throw Exception:" + e18.getMessage());
                }
            }
            if (xmlData != null) {
                xmlData.strResName = str;
                xmlData.strPkgName = str2;
                xmlData.strResURL_big = str4;
                xmlData.strResURL_small = str5;
                xmlData.Version = (int) j3;
            }
            return xmlData;
        }
        if (QLog.isColorLevel()) {
            StringBuffer stringBuffer = new StringBuffer();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("class=");
            if (cls == null) {
                canonicalName = "null";
            } else {
                canonicalName = cls.getCanonicalName();
            }
            sb5.append(canonicalName);
            stringBuffer.append(sb5.toString());
            stringBuffer.append(" resName=" + str);
            stringBuffer.append(" resConf=" + str3);
            stringBuffer.append(" uiNewVer=" + j3);
            stringBuffer.append(" urlBig=" + str4);
            stringBuffer.append(" urlSmall=" + str5);
            QLog.d("EarlyDown", 2, "parse() return." + stringBuffer.toString());
        }
        return null;
    }

    public static XmlData e(Class<? extends XmlData> cls) {
        XmlData xmlData = null;
        if (cls == null) {
            return null;
        }
        try {
            XmlData newInstance = cls.newInstance();
            try {
                SharedPreferences sharedPreferences = MobileQQ.sMobileQQ.getApplicationContext().getSharedPreferences(newInstance.getSharedPreferencesName(), 4);
                Field[] c16 = c(cls);
                if (c16 != null) {
                    for (Field field : c16) {
                        if (field.isAnnotationPresent(saveInSP.class)) {
                            if (!field.isAccessible()) {
                                field.setAccessible(true);
                            }
                            String name = field.getName();
                            Class<?> type = field.getType();
                            if (type == String.class) {
                                field.set(newInstance, sharedPreferences.getString(name, ""));
                            } else if (type == Long.TYPE) {
                                field.setLong(newInstance, sharedPreferences.getLong(name, 0L));
                            } else if (type == Integer.TYPE) {
                                field.setInt(newInstance, sharedPreferences.getInt(name, 0));
                            } else if (type == Float.TYPE) {
                                field.setFloat(newInstance, sharedPreferences.getFloat(name, 0.0f));
                            } else if (type == Boolean.TYPE) {
                                field.setBoolean(newInstance, sharedPreferences.getBoolean(name, false));
                            } else {
                                throw new RuntimeException("Member name:" + name + "->Type:" + type.toString() + " is NOT SUPPORT!");
                            }
                        }
                    }
                    return newInstance;
                }
                return newInstance;
            } catch (IllegalAccessException e16) {
                e = e16;
                xmlData = newInstance;
                e.printStackTrace();
                return xmlData;
            } catch (InstantiationException e17) {
                e = e17;
                xmlData = newInstance;
                e.printStackTrace();
                return xmlData;
            }
        } catch (IllegalAccessException e18) {
            e = e18;
        } catch (InstantiationException e19) {
            e = e19;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0045 A[Catch: all -> 0x0111, TryCatch #0 {, blocks: (B:8:0x0007, B:10:0x0020, B:13:0x0024, B:14:0x0028, B:16:0x002b, B:18:0x002f, B:23:0x0036, B:22:0x003c, B:28:0x0045, B:30:0x0048, B:32:0x004a, B:34:0x0052, B:36:0x0060, B:38:0x0066, B:39:0x006a, B:41:0x0076, B:44:0x007f, B:46:0x0083, B:48:0x008e, B:50:0x0092, B:52:0x009c, B:54:0x00a0, B:56:0x00aa, B:58:0x00ae, B:60:0x00b8, B:63:0x00da, B:64:0x00ec, B:67:0x00d2, B:43:0x0108, B:75:0x00ee, B:77:0x00f4, B:81:0x0100, B:72:0x0105, B:84:0x010c, B:87:0x003f), top: B:7:0x0007, inners: #1, #2, #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void f(XmlData xmlData, String... strArr) {
        Field[] c16;
        String simpleName;
        synchronized (a.class) {
            if (xmlData == null) {
                return;
            }
            SharedPreferences.Editor edit = MobileQQ.sMobileQQ.getApplicationContext().getSharedPreferences(xmlData.getSharedPreferencesName(), 0).edit();
            Class<?> cls = xmlData.getClass();
            if (strArr != null && strArr.length != 0) {
                c16 = new Field[strArr.length];
                for (int i3 = 0; i3 < strArr.length; i3++) {
                    String str = strArr[i3];
                    if (str != null && str.length() != 0) {
                        c16[i3] = a(cls, str);
                    }
                }
                if (c16 != null) {
                    for (Field field : c16) {
                        try {
                            try {
                                try {
                                    if (field.isAnnotationPresent(saveInSP.class) && ((saveInSP) field.getAnnotation(saveInSP.class)).save()) {
                                        if (!field.isAccessible()) {
                                            field.setAccessible(true);
                                        }
                                        String name = field.getName();
                                        Object obj = field.get(xmlData);
                                        if (obj instanceof String) {
                                            edit.putString(name, String.valueOf(obj));
                                        } else if (obj instanceof Long) {
                                            edit.putLong(name, ((Long) obj).longValue());
                                        } else if (obj instanceof Integer) {
                                            edit.putInt(name, ((Integer) obj).intValue());
                                        } else if (obj instanceof Float) {
                                            edit.putFloat(name, ((Float) obj).floatValue());
                                        } else if (obj instanceof Boolean) {
                                            edit.putBoolean(name, ((Boolean) obj).booleanValue());
                                        } else {
                                            StringBuilder sb5 = new StringBuilder();
                                            sb5.append("Member name:");
                                            sb5.append(name);
                                            sb5.append("->Type:");
                                            if (obj == null) {
                                                simpleName = "NULL";
                                            } else {
                                                simpleName = obj.getClass().getSimpleName();
                                            }
                                            sb5.append(simpleName);
                                            sb5.append(" is NOT SUPPORT!");
                                            throw new RuntimeException(sb5.toString());
                                            break;
                                        }
                                    }
                                } catch (IllegalAccessException e16) {
                                    e16.printStackTrace();
                                }
                            } catch (IncompatibleClassChangeError e17) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("earlyDown", 2, "EarlyDataFactory.saveToSP, IncompatibleClassChangeError", e17);
                                }
                            }
                        } catch (IllegalArgumentException e18) {
                            e18.printStackTrace();
                        }
                    }
                }
                edit.commit();
            }
            c16 = c(cls);
            if (c16 != null) {
            }
            edit.commit();
        }
    }
}
