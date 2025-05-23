package com.tencent.securitysdk.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static int a(Context context, String str) {
        Context context2;
        int i3;
        XmlResourceParser xmlResourceParser = null;
        try {
            context2 = context.createPackageContext(str, 0);
        } catch (PackageManager.NameNotFoundException e16) {
            e16.printStackTrace();
            context2 = null;
        }
        if (context2 == null) {
            return 0;
        }
        AssetManager assets = context2.getAssets();
        Resources resources = new Resources(assets, context.getResources().getDisplayMetrics(), null);
        try {
            xmlResourceParser = c(context2, assets);
        } catch (IOException e17) {
            e17.printStackTrace();
        }
        if (xmlResourceParser == null) {
            return 0;
        }
        try {
            i3 = xmlResourceParser.getEventType();
        } catch (XmlPullParserException e18) {
            e18.printStackTrace();
            i3 = 0;
        }
        while (i3 != 1) {
            if (i3 == 2) {
                String name = xmlResourceParser.getName();
                if (!TextUtils.isEmpty(name) && name.equals("manifest")) {
                    String b16 = b(xmlResourceParser, resources, "versionCode");
                    if (TextUtils.isEmpty(b16)) {
                        return 0;
                    }
                    return Integer.parseInt(b16);
                }
            }
            try {
                i3 = xmlResourceParser.nextToken();
            } catch (IOException e19) {
                e19.printStackTrace();
            } catch (XmlPullParserException e26) {
                e26.printStackTrace();
            }
        }
        xmlResourceParser.close();
        return 0;
    }

    protected static String b(XmlResourceParser xmlResourceParser, Resources resources, String str) {
        return d(xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", str), resources);
    }

    protected static XmlResourceParser c(Context context, AssetManager assetManager) throws IOException {
        try {
            String str = (String) Context.class.getMethod("getPackageResourcePath", new Class[0]).invoke(context, new Object[0]);
            Method method = AssetManager.class.getMethod("getCookieName", Integer.TYPE);
            if (str == null && context.getPackageName().equals("android")) {
                str = "/system/framework/framework-res.apk";
            }
            for (int i3 = 1; i3 < 20; i3++) {
                if (str != null && str.equals(method.invoke(assetManager, Integer.valueOf(i3)))) {
                    return assetManager.openXmlResourceParser(i3, "AndroidManifest.xml");
                }
            }
        } catch (Exception unused) {
        }
        return assetManager.openXmlResourceParser("AndroidManifest.xml");
    }

    protected static String d(String str, Resources resources) {
        if (str != null && str.startsWith("@") && resources != null) {
            try {
                return resources.getString(Integer.parseInt(str.substring(1)));
            } catch (Resources.NotFoundException | NumberFormatException unused) {
                return str;
            }
        }
        return str;
    }
}
