package gy;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.subscript.SubscriptRecommendController;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountConfigUtilImpl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.as;
import com.tencent.mobileqq.config.n;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import mqq.app.AppRuntime;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a implements n<String> {

    /* renamed from: a, reason: collision with root package name */
    private int f403818a = 0;

    /* renamed from: b, reason: collision with root package name */
    private String f403819b = "";

    /* renamed from: c, reason: collision with root package name */
    private int f403820c = 0;

    public static a a(int i3, String str, boolean z16) {
        a aVar = new a();
        aVar.f403818a = i3;
        aVar.f403820c = z16 ? 1 : 0;
        aVar.f403819b = str;
        return aVar;
    }

    public static a c(String str) {
        try {
            return (a) as.e(str, a.class);
        } catch (QStorageInstantiateException e16) {
            QLog.i("PublicAccountCenterUrlConfProcessor", 1, "loadConfig l :" + str, e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.config.n
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onParse(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("PaSubscribeRedDotProcessor", 2, "updateSubscribeConfig xml: " + str);
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(str.trim().getBytes("utf-8")));
                NodeList elementsByTagName = parse.getElementsByTagName("version");
                AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                if (runtime instanceof QQAppInterface) {
                    this.f403818a = Integer.parseInt(elementsByTagName.item(0).getFirstChild().getNodeValue());
                    NodeList elementsByTagName2 = parse.getElementsByTagName(PublicAccountConfigUtilImpl.CONFIG_PUBLIC_ACCOUNT_FOLDER_TAG);
                    if (elementsByTagName2.getLength() > 0) {
                        Element element = (Element) elementsByTagName2.item(0);
                        this.f403820c = Integer.parseInt(element.getElementsByTagName("show").item(0).getFirstChild().getNodeValue());
                        this.f403819b = element.getElementsByTagName("msg").item(0).getFirstChild().getNodeValue();
                        return;
                    }
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("PaSubscribeRedDotProcessor", 2, "updateSubscribeConfig xml is empty");
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("PaSubscribeRedDotProcessor", 2, "updateSubscribeConfig error", e16);
            }
            e16.printStackTrace();
        }
    }

    public void e() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            QQAppInterface qQAppInterface = (QQAppInterface) runtime;
            int g16 = SubscriptRecommendController.g(qQAppInterface);
            int i3 = this.f403818a;
            if (i3 == g16) {
                if (QLog.isColorLevel()) {
                    QLog.d("PaSubscribeRedDotProcessor", 2, "IGNORE THIS ACTION because of SAME VERSION");
                }
            } else {
                SubscriptRecommendController.I(qQAppInterface, i3);
                SubscriptRecommendController.u(qQAppInterface, this.f403820c, this.f403819b);
                IWebProcessManagerService iWebProcessManagerService = (IWebProcessManagerService) qQAppInterface.getRuntimeService(IWebProcessManagerService.class, "");
                if (iWebProcessManagerService != null) {
                    iWebProcessManagerService.startWebProcess(22, null);
                }
            }
        }
    }

    public static a d(ai[] aiVarArr) {
        a aVar = null;
        for (ai aiVar : aiVarArr) {
            aVar = c(aiVar.f202268b);
        }
        return aVar;
    }
}
