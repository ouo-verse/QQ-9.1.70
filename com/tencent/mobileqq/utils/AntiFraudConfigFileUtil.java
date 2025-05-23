package com.tencent.mobileqq.utils;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSvcHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mqp.app.sec.ScConfigManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tenpay.sdk.util.UinConfigManager;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/* compiled from: P */
/* loaded from: classes20.dex */
public class AntiFraudConfigFileUtil {

    /* renamed from: a, reason: collision with root package name */
    private Bundle f306841a;

    /* renamed from: b, reason: collision with root package name */
    private int f306842b = -1;

    /* renamed from: c, reason: collision with root package name */
    private Bundle f306843c = new Bundle();

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.mobileqq.app.cx f306844d = new com.tencent.mobileqq.app.cx() { // from class: com.tencent.mobileqq.utils.AntiFraudConfigFileUtil.3
        @Override // com.tencent.mobileqq.app.cx
        protected void b(int i3, Bundle bundle) {
            QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
            if (qQAppInterface != null) {
                qQAppInterface.removeObserver(AntiFraudConfigFileUtil.this.f306844d);
            }
            if (i3 != 1) {
                if (QLog.isColorLevel()) {
                    QLog.d("SecSvcObserver", 2, "invalid notification type for onGetUinSafetyWordingConfig:" + Integer.toString(i3));
                    return;
                }
                return;
            }
            if (bundle == null) {
                return;
            }
            String string = bundle.getString(UinConfigManager.KEY_CONFIG_NAME);
            if (!TextUtils.isEmpty(string) && TextUtils.equals("SenstiveMessageTipsCfg", string)) {
                string = "SensMsgTipsCfg";
            }
            final String str = string;
            final int i16 = bundle.getInt("effect_time", 0);
            final String string2 = bundle.getString("md5");
            final String string3 = bundle.getString("download_url");
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.utils.AntiFraudConfigFileUtil.3.1
                @Override // java.lang.Runnable
                public void run() {
                    AntiFraudConfigFileUtil.this.s(str, i16);
                    if (!string2.equalsIgnoreCase(SecUtil.getFileMd5(AntiFraudConfigFileUtil.this.l(str)))) {
                        AntiFraudConfigFileUtil.this.j(str, string2, string3);
                    } else {
                        AntiFraudConfigFileUtil.this.t(str, System.currentTimeMillis());
                    }
                }
            }, 5, null, false);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        static AntiFraudConfigFileUtil f306856a = new AntiFraudConfigFileUtil();
    }

    AntiFraudConfigFileUtil() {
        this.f306841a = null;
        this.f306841a = new Bundle();
    }

    private void g(Bundle bundle, Element element) {
        String nodeName = element.getNodeName();
        String str = "";
        for (Node firstChild = element.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
            if (firstChild instanceof Text) {
                str = str + firstChild.getNodeValue();
            }
        }
        if (!TextUtils.isEmpty(str)) {
            bundle.putString(nodeName, str);
        }
    }

    private void h(Bundle bundle, String str, Element element) {
        int i3;
        try {
            i3 = Integer.parseInt(str);
        } catch (Exception e16) {
            e16.printStackTrace();
            i3 = 0;
        }
        if (i3 != 1 && i3 != 2) {
            for (Node firstChild = element.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
                if (firstChild instanceof Element) {
                    Bundle bundle2 = new Bundle();
                    g(bundle2, (Element) firstChild);
                    bundle.putBundle(firstChild.getNodeName(), bundle2);
                }
            }
            return;
        }
        NodeList elementsByTagName = element.getElementsByTagName("TailWording");
        if (elementsByTagName.getLength() > 0) {
            Bundle bundle3 = new Bundle();
            for (int i16 = 0; i16 < elementsByTagName.getLength(); i16++) {
                Element element2 = (Element) elementsByTagName.item(i16);
                String attribute = element2.getAttribute("Status");
                if (TextUtils.isEmpty(attribute)) {
                    attribute = "0";
                }
                bundle3.putString(attribute, element2.getTextContent());
            }
            bundle.putBundle("TailWording", bundle3);
        }
        NodeList elementsByTagName2 = element.getElementsByTagName(Action.TAG);
        if (elementsByTagName2.getLength() > 0) {
            Bundle bundle4 = new Bundle();
            for (int i17 = 0; i17 < elementsByTagName2.getLength(); i17++) {
                Element element3 = (Element) elementsByTagName2.item(i17);
                String attribute2 = element3.getAttribute("PlaceHolder");
                if (!TextUtils.isEmpty(attribute2)) {
                    Bundle bundle5 = new Bundle();
                    String attribute3 = element3.getAttribute("Type");
                    bundle5.putString("Type", attribute3);
                    bundle5.putString("Name", element3.getAttribute("Name"));
                    if (attribute3.equalsIgnoreCase("openURL")) {
                        g(bundle5, element3);
                    } else {
                        NodeList elementsByTagName3 = element3.getElementsByTagName("AlertTitle");
                        if (elementsByTagName3.getLength() > 0) {
                            g(bundle5, (Element) elementsByTagName3.item(0));
                        }
                        NodeList elementsByTagName4 = element3.getElementsByTagName("AlertText");
                        if (elementsByTagName4.getLength() > 0) {
                            g(bundle5, (Element) elementsByTagName4.item(0));
                        }
                        NodeList elementsByTagName5 = element3.getElementsByTagName("AlertOtherBtnText");
                        if (elementsByTagName5.getLength() > 0) {
                            g(bundle5, (Element) elementsByTagName5.item(0));
                        }
                        NodeList elementsByTagName6 = element3.getElementsByTagName("AlertCancelBtnText");
                        if (elementsByTagName6.getLength() > 0) {
                            g(bundle5, (Element) elementsByTagName6.item(0));
                        }
                    }
                    bundle4.putBundle(attribute2, bundle5);
                }
            }
            bundle.putBundle(Action.TAG, bundle4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(9:2|3|4|(2:6|(7:8|9|10|11|12|13|(2:15|(2:17|18)(1:20))(2:21|(1:23)(7:24|(1:26)|27|(7:30|(2:33|31)|34|35|(2:37|38)(1:40)|39|28)|41|42|43))))|52|11|12|13|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x005a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x005c, code lost:
    
        r0.printStackTrace();
        r0 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0062 A[Catch: Exception -> 0x010f, TryCatch #0 {Exception -> 0x010f, blocks: (B:3:0x000f, B:6:0x003b, B:11:0x0051, B:15:0x0062, B:17:0x0068, B:21:0x007e, B:24:0x0089, B:26:0x0094, B:27:0x0098, B:28:0x00a5, B:30:0x00ab, B:31:0x00c5, B:33:0x00cb, B:35:0x00e7, B:37:0x00f1, B:39:0x0102, B:42:0x0109, B:47:0x005c, B:51:0x004d, B:9:0x0045, B:13:0x0055), top: B:2:0x000f, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007e A[Catch: Exception -> 0x010f, TryCatch #0 {Exception -> 0x010f, blocks: (B:3:0x000f, B:6:0x003b, B:11:0x0051, B:15:0x0062, B:17:0x0068, B:21:0x007e, B:24:0x0089, B:26:0x0094, B:27:0x0098, B:28:0x00a5, B:30:0x00ab, B:31:0x00c5, B:33:0x00cb, B:35:0x00e7, B:37:0x00f1, B:39:0x0102, B:42:0x0109, B:47:0x005c, B:51:0x004d, B:9:0x0045, B:13:0x0055), top: B:2:0x000f, inners: #1, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void i(String str) {
        int i3;
        int i16;
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        try {
            File file = new File(str);
            String name = file.getName();
            String substring = name.substring(0, name.lastIndexOf("."));
            Element documentElement = newInstance.newDocumentBuilder().parse(file).getDocumentElement();
            Bundle bundle = this.f306841a.getBundle(substring);
            if (bundle != null) {
                String string = bundle.getString("Version");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        i3 = Integer.parseInt(string);
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                    String attribute = documentElement.getAttribute("Version");
                    i16 = Integer.parseInt(attribute);
                    if (i16 >= i3) {
                        if (QLog.isColorLevel()) {
                            QLog.d("UinSafety.WordingConfigFileUtil", 2, substring + " file version below current used version.");
                            return;
                        }
                        return;
                    }
                    if (ScConfigManager.i().n(str)) {
                        return;
                    }
                    Bundle bundle2 = new Bundle();
                    if (TextUtils.isEmpty(attribute)) {
                        attribute = Integer.toString(0);
                    }
                    bundle2.putString("Version", attribute);
                    this.f306842b = i16;
                    NodeList elementsByTagName = documentElement.getElementsByTagName("SubConfig");
                    for (int i17 = 0; i17 < elementsByTagName.getLength(); i17++) {
                        Element element = (Element) elementsByTagName.item(i17);
                        String attribute2 = element.getAttribute("Type");
                        Bundle bundle3 = new Bundle();
                        NodeList elementsByTagName2 = element.getElementsByTagName("Element");
                        for (int i18 = 0; i18 < elementsByTagName2.getLength(); i18++) {
                            Element element2 = (Element) elementsByTagName2.item(i18);
                            Bundle bundle4 = new Bundle();
                            h(bundle4, attribute2, element2);
                            bundle3.putBundle(element2.getAttribute("Value"), bundle4);
                        }
                        NodeList elementsByTagName3 = element.getElementsByTagName("PublicElement");
                        if (elementsByTagName3.getLength() > 0) {
                            Element element3 = (Element) elementsByTagName3.item(0);
                            Bundle bundle5 = new Bundle();
                            h(bundle5, attribute2, element3);
                            bundle3.putBundle("PublicElement", bundle5);
                        }
                        bundle2.putBundle(attribute2, bundle3);
                    }
                    this.f306841a.putBundle(substring, bundle2);
                    return;
                }
            }
            i3 = 0;
            String attribute3 = documentElement.getAttribute("Version");
            i16 = Integer.parseInt(attribute3);
            if (i16 >= i3) {
            }
        } catch (Exception e17) {
            if (QLog.isColorLevel()) {
                QLog.d("UinSafety.WordingConfigFileUtil", 2, "exception occurred." + e17.getMessage());
            }
            e17.printStackTrace();
        }
    }

    public static AntiFraudConfigFileUtil n() {
        return a.f306856a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("UinSafety.WordingConfigFileUtil", 2, "parse config file:" + str);
        }
        String l3 = l(str);
        if (l3 != null) {
            i(l3);
        }
    }

    public void f(QQAppInterface qQAppInterface, String str) {
        if (qQAppInterface == null) {
            return;
        }
        qQAppInterface.addObserver(this.f306844d);
        if (System.currentTimeMillis() - o(str) >= m(str) * 1000) {
            SecSvcHandler secSvcHandler = (SecSvcHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER);
            if (TextUtils.equals(str, "SensMsgTipsCfg")) {
                str = "SenstiveMessageTipsCfg";
            }
            secSvcHandler.F2(str);
        }
    }

    public void j(final String str, final String str2, final String str3) {
        int i3 = this.f306843c.getInt(str2, 0);
        if (i3 != 1 && i3 != 3) {
            try {
                this.f306843c.putInt(str2, 1);
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.utils.AntiFraudConfigFileUtil.4
                @Override // java.lang.Runnable
                public void run() {
                    String l3 = AntiFraudConfigFileUtil.this.l(str);
                    File file = new File(l3);
                    File file2 = new File(file.getParent() + "/download" + str + ".xml");
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (HttpDownloadUtil.download((AppRuntime) null, MsfSdkUtils.insertMtype("QPSingle", str3), file2)) {
                        if (!str2.equalsIgnoreCase(SecUtil.getFileMd5(file2.getAbsolutePath()))) {
                            AntiFraudConfigFileUtil.this.f306843c.putInt(str2, 2);
                            return;
                        }
                        if (file2.renameTo(file)) {
                            AntiFraudConfigFileUtil.this.f306843c.putInt(str2, 3);
                            AntiFraudConfigFileUtil.this.t(str, System.currentTimeMillis());
                            AntiFraudConfigFileUtil.this.r(str, str2);
                            AntiFraudConfigFileUtil.this.i(l3);
                            return;
                        }
                        AntiFraudConfigFileUtil.this.f306843c.putInt(str2, 2);
                        file2.delete();
                    }
                }
            }, 5, null, false);
        }
    }

    public String k(final String str, String str2) {
        if (!TextUtils.isEmpty(str) && TextUtils.equals("SenstiveMessageTipsCfg", str)) {
            str = "SensMsgTipsCfg";
        }
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.utils.AntiFraudConfigFileUtil.1
            @Override // java.lang.Runnable
            public void run() {
                if (!AntiFraudConfigFileUtil.this.f306841a.containsKey(str)) {
                    AntiFraudConfigFileUtil.this.q(str);
                }
            }
        });
        Bundle bundle = this.f306841a.getBundle(str);
        if (bundle != null) {
            return bundle.getString(str2);
        }
        return null;
    }

    public String l(String str) {
        return BaseApplication.getContext().getFilesDir().getPath() + "/" + str + ".xml";
    }

    public long m(String str) {
        return PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getLong(str + "_EffectTime", 0L);
    }

    public long o(String str) {
        return PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getLong(str + "_LastModifiedTime", 0L);
    }

    public Object p(final String str, String str2, int i3, int i16) {
        Bundle bundle;
        Bundle bundle2;
        Bundle bundle3;
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.utils.AntiFraudConfigFileUtil.2
            @Override // java.lang.Runnable
            public void run() {
                if (!AntiFraudConfigFileUtil.this.f306841a.containsKey(str)) {
                    AntiFraudConfigFileUtil.this.q(str);
                }
            }
        });
        Bundle bundle4 = this.f306841a.getBundle(str);
        if (bundle4 != null && (bundle = bundle4.getBundle(Integer.toString(i3))) != null && (bundle2 = bundle.getBundle(Integer.toString(i16))) != null) {
            Bundle bundle5 = bundle2.getBundle(str2);
            if (bundle5 == null && (bundle3 = bundle.getBundle("PublicElement")) != null) {
                return bundle3.getBundle(str2);
            }
            return bundle5;
        }
        return null;
    }

    public void r(String str, String str2) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
        edit.putString(str + "_" + KeyPropertiesCompact.DIGEST_MD5, str2);
        edit.commit();
    }

    public void s(String str, long j3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
        edit.putLong(str + "_EffectTime", j3);
        edit.commit();
    }

    public void t(String str, long j3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
        edit.putLong(str + "_LastModifiedTime", j3);
        edit.commit();
    }
}
