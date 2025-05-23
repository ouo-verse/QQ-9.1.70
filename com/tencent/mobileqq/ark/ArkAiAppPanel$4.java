package com.tencent.mobileqq.ark;

import android.text.TextUtils;
import android.view.View;
import com.tencent.ark.Constants;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

/* loaded from: classes11.dex */
class ArkAiAppPanel$4 implements View.OnClickListener {
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (c.d(null) != null && c.d(null).size() > 0 && c.b(null) < c.d(null).size() && c.d(null).get(c.b(null)) != null) {
            final String appName = ((com.tencent.mobileqq.activity.aio.item.b) c.d(null).get(c.b(null))).getAppName();
            ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToAppThread(appName, new Runnable() { // from class: com.tencent.mobileqq.ark.ArkAiAppPanel$4.1
                @Override // java.lang.Runnable
                public void run() {
                    Node item;
                    try {
                        ArkAiAppPanel$4.this.getClass();
                        if (c.d(null) != null) {
                            ArkAiAppPanel$4.this.getClass();
                            if (c.d(null).size() > 0) {
                                ArkAiAppPanel$4.this.getClass();
                                int b16 = c.b(null);
                                ArkAiAppPanel$4.this.getClass();
                                if (b16 < c.d(null).size()) {
                                    ArkAiAppPanel$4.this.getClass();
                                    ArrayList d16 = c.d(null);
                                    ArkAiAppPanel$4.this.getClass();
                                    if (d16.get(c.b(null)) != null) {
                                        ArkAiAppPanel$4.this.getClass();
                                        ArrayList d17 = c.d(null);
                                        ArkAiAppPanel$4.this.getClass();
                                        String viewShare = ((com.tencent.mobileqq.activity.aio.item.b) d17.get(c.b(null))).getViewShare();
                                        if (TextUtils.isEmpty(viewShare)) {
                                            return;
                                        }
                                        Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(viewShare.getBytes()));
                                        Node item2 = parse.getElementsByTagName("View").item(0);
                                        if (item2 != null && item2.getChildNodes().getLength() > 0 && (item2.getFirstChild() instanceof Text)) {
                                            String nodeValue = item2.getFirstChild().getNodeValue();
                                            if (!TextUtils.isEmpty(nodeValue) && (item = parse.getElementsByTagName("Metadata").item(0)) != null && item.getChildNodes().getLength() > 0) {
                                                JSONObject jSONObject = new JSONObject();
                                                if (!l.a(item.getFirstChild(), jSONObject)) {
                                                    return;
                                                }
                                                ArkAppMessage arkAppMessage = new ArkAppMessage();
                                                arkAppMessage.appMinVersion = Constants.DEFAULT_MIN_APP_VERSION;
                                                ArkAiAppPanel$4.this.getClass();
                                                ArrayList d18 = c.d(null);
                                                ArkAiAppPanel$4.this.getClass();
                                                String appName2 = ((com.tencent.mobileqq.activity.aio.item.b) d18.get(c.b(null))).getAppName();
                                                arkAppMessage.appName = appName2;
                                                if (TextUtils.isEmpty(appName2)) {
                                                    return;
                                                }
                                                arkAppMessage.appView = nodeValue;
                                                if (TextUtils.isEmpty(nodeValue)) {
                                                    return;
                                                }
                                                Map<String, String> applicationFromManifest = ArkAppCacheMgr.getApplicationFromManifest(arkAppMessage.appName, arkAppMessage.bizSrc, arkAppMessage.appMinVersion);
                                                if (applicationFromManifest != null) {
                                                    arkAppMessage.appDesc = applicationFromManifest.get("desc");
                                                    arkAppMessage.appMinVersion = applicationFromManifest.get("version");
                                                }
                                                if (TextUtils.isEmpty(arkAppMessage.appDesc)) {
                                                    arkAppMessage.appDesc = arkAppMessage.appName;
                                                }
                                                arkAppMessage.promptText = String.format(HardCodeUtil.qqStr(R.string.joi), arkAppMessage.appDesc);
                                                String configFromXml = MessageForArkApp.getConfigFromXml(parse);
                                                if (!TextUtils.isEmpty(configFromXml)) {
                                                    arkAppMessage.config = configFromXml;
                                                    if (QLog.isColorLevel()) {
                                                        QLog.i("ArkApp", 2, "ArkAIAppPanel send get shareView config:" + arkAppMessage.config);
                                                    }
                                                } else {
                                                    if (QLog.isColorLevel()) {
                                                        QLog.i("ArkApp", 2, "ArkAIAppPanel send get shareView no config");
                                                    }
                                                    arkAppMessage.metaList = jSONObject.toString();
                                                    JSONObject jSONObject2 = new JSONObject();
                                                    jSONObject2.put("forward", 1);
                                                    jSONObject2.put("autosize", 1);
                                                    jSONObject2.put("type", IndividuationUrlHelper.UrlId.CARD_HOME);
                                                    arkAppMessage.config = jSONObject2.toString();
                                                }
                                                ArkAiAppPanel$4.this.getClass();
                                                if (c.a(null) != null) {
                                                    ArkAiAppPanel$4.this.getClass();
                                                    SessionInfo sessionInfo = (SessionInfo) c.a(null).d();
                                                    if (sessionInfo != null) {
                                                        ChatActivityFacade.w0((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime(), sessionInfo, arkAppMessage);
                                                    }
                                                }
                                                g.b(null, appName, "AIOInputSendMessage", 0, 0, 0L, 0L, 0L, arkAppMessage.appName, "");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.i("ArkApp", 1, "ArkAIAppPanel send message parameter error: " + e16.getMessage());
                        }
                    }
                }
            });
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
