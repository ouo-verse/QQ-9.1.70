package gy;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountConfigUtilImpl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.as;
import com.tencent.mobileqq.config.n;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c implements n<String> {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<IPublicAccountConfigUtil.a> f403826a = new ArrayList<>(0);

    /* renamed from: b, reason: collision with root package name */
    private boolean f403827b = false;

    /* renamed from: c, reason: collision with root package name */
    private String f403828c = "";

    public static c c(String str) {
        try {
            return (c) as.e(str, c.class);
        } catch (QStorageInstantiateException e16) {
            QLog.i("PublicAccountCenterUrlConfProcessor", 1, "loadConfig l :" + str, e16);
            return null;
        }
    }

    public void a() {
        if (this.f403827b) {
            PublicAccountConfigUtilImpl.addFolders(this.f403826a);
        }
    }

    public void e() {
        if (this.f403827b) {
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (runtime instanceof QQAppInterface) {
                ea.z4(((QQAppInterface) runtime).getApplication(), this.f403828c);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("PublicAccountConfProcessor", 2, "updateEqqConfig fail");
        }
    }

    public static c d(ai[] aiVarArr) {
        c cVar = null;
        for (ai aiVar : aiVarArr) {
            cVar = c(aiVar.f202268b);
        }
        return cVar;
    }

    @Override // com.tencent.mobileqq.config.n
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onParse(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfProcessor", 2, "parseConfigXml xml: " + str);
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                this.f403828c = str;
                NodeList elementsByTagName = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(str.trim().getBytes("utf-8"))).getElementsByTagName(PublicAccountConfigUtilImpl.CONFIG_PUBLIC_ACCOUNT_FOLDER_TAG);
                int length = elementsByTagName.getLength();
                AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                if (runtime instanceof QQAppInterface) {
                    QQAppInterface qQAppInterface = (QQAppInterface) runtime;
                    MobileQQ application = runtime.getApplication();
                    this.f403826a = new ArrayList<>(length);
                    int i3 = 0;
                    int i16 = 0;
                    while (i16 < length) {
                        Element element = (Element) elementsByTagName.item(i16);
                        int parseInt = Integer.parseInt(element.getElementsByTagName("id").item(i3).getFirstChild().getNodeValue());
                        String nodeValue = element.getElementsByTagName("name").item(i3).getFirstChild().getNodeValue();
                        String nodeValue2 = element.getElementsByTagName("icon").item(i3).getFirstChild().getNodeValue();
                        IPublicAccountConfigUtil.a aVar = new IPublicAccountConfigUtil.a();
                        ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).initPublicAccountConfigFolder(aVar, qQAppInterface, application, parseInt, nodeValue, nodeValue2);
                        this.f403826a.add(aVar);
                        i16++;
                        i3 = 0;
                    }
                    this.f403827b = true;
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("PublicAccountConfProcessor", 2, "parsePublicAccountConfigXml xml is empty");
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("PublicAccountConfProcessor", 2, "parsePublicAccountConfigXml error", e16);
            }
            e16.printStackTrace();
        }
    }
}
