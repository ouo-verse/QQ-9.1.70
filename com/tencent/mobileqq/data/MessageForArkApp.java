package com.tencent.mobileqq.data;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.biz.common.util.k;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StartAppCheckHandler;
import com.tencent.mobileqq.app.message.RecordForTest;
import com.tencent.mobileqq.ark.api.IArkConfig;
import com.tencent.mobileqq.ark.api.IArkMsgReplyMgr;
import com.tencent.mobileqq.ark.d;
import com.tencent.mobileqq.ark.e;
import com.tencent.mobileqq.ark.f;
import com.tencent.mobileqq.ark.g;
import com.tencent.mobileqq.ark.i;
import com.tencent.mobileqq.ark.l;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vaswebviewplugin.ColorRingJsPlugin;
import com.tencent.open.agent.util.o;
import com.tencent.open.appcommon.AppClient;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneClickReport;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForArkApp extends ChatMessage implements com.tencent.mobileqq.ark.a, q91.a, IMultiMsgRecordOp {
    private static final String REPORT_KEY_APP_NAME = "AppName";
    private static final String REPORT_KEY_APP_VIEW = "AppView";
    private static final String REPORT_TAG_ARK_VIEW_FORWARD_ALLOW = "ArkViewForwardAllow";
    private static final String REPORT_TAG_ARK_VIEW_FORWARD_FORBIDDEN = "ArkViewForwardForbidden";
    public static final String SDK_SHARE_APPID = "appid";
    public static final String SDK_SHARE_MUSIC = "music";
    public static final String SDK_SHARE_NEWS = "news";
    public static final String SDK_SHARE_PKG = "com.tencent.structmsg";
    private static final String SDK_SHARE_TITLE = "title";
    private static final String TAG = "MessageForArkApp";
    private static final String T_REPORT_TAIL_DOWNLOAD_THIRD_APP = "0X800A86E";
    private static final String T_REPORT_TAIL_OPEN_THIRD_APP = "0X800A86D";
    public com.tencent.mobileqq.activity.aio.item.b arkContainer;

    @RecordForTest
    public ArkAppMessage ark_app_message;
    public String compatibleMsg;
    public boolean isMultiItemMsg;
    public LinkedList<MessageForArkApp> mExtendMsgArkAppList = new LinkedList<>();
    public String resIDForLongMsg;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class Size {
        public int height;
        public int width;

        public Size(int i3, int i16) {
            this.width = i3;
            this.height = i16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f203087d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f203088e;

        a(QQAppInterface qQAppInterface, Context context) {
            this.f203087d = qQAppInterface;
            this.f203088e = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!TextUtils.isEmpty(MessageForArkApp.this.ark_app_message.appId)) {
                MessageForArkApp.this.openThirdApp(this.f203087d, this.f203088e);
                QQAppInterface qQAppInterface = this.f203087d;
                ArkAppMessage arkAppMessage = MessageForArkApp.this.ark_app_message;
                g.b(qQAppInterface, arkAppMessage.appName, "AIOArkSdkTailClick", 1, 0, 0L, 0L, 0L, arkAppMessage.appView, "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private boolean click2YYB(Activity activity, long j3, String str, String str2, String str3) {
        String str4 = AbsShareMsg.parsePackageNameAndData(str2, str3)[0];
        if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, "SourceClickHandler click2YYB  appid = " + j3 + "; packageName=" + str4);
        }
        if (TextUtils.isEmpty(str4)) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString("packageName", str4);
        bundle.putString("appId", j3 + "");
        d.c(bundle);
        AppClient.l(activity, bundle);
        return true;
    }

    private boolean clickAppMsg(Context context, String str, String str2, String str3, QQAppInterface qQAppInterface) {
        Intent launchIntentForPackage;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "SourceClickHandler clickAppMsg url = " + str + ", actionData = " + str2 + ", actionDataA = " + str3);
        }
        String[] parsePackageNameAndData = AbsShareMsg.parsePackageNameAndData(str2, str3);
        PackageManager packageManager = context.getPackageManager();
        try {
            if (InstalledAppListMonitor.getPackageInfo(packageManager, parsePackageNameAndData[0], 1) == null || (launchIntentForPackage = InstalledAppListMonitor.getLaunchIntentForPackage(packageManager, parsePackageNameAndData[0])) == null) {
                return false;
            }
            launchIntentForPackage.addFlags(67108864);
            if (!TextUtils.isEmpty(parsePackageNameAndData[1])) {
                launchIntentForPackage.setData(Uri.parse(parsePackageNameAndData[1]));
            }
            try {
                StartAppCheckHandler startAppCheckHandler = (StartAppCheckHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.STARTAPPCHECK_HANDLER);
                launchIntentForPackage.putExtra("report_open_type", "arkmsg_source");
                launchIntentForPackage.putExtra("report_url", "");
                launchIntentForPackage.putExtra("report_from", "1");
                launchIntentForPackage.putExtra("report_click_origin", "AIOTail");
                launchIntentForPackage.putExtra("report_class_name", context.getClass().getName());
                d.a(launchIntentForPackage);
                startAppCheckHandler.J2(parsePackageNameAndData[0].trim(), context, launchIntentForPackage);
            } catch (Exception unused) {
                if (QLog.isColorLevel()) {
                    QLog.d("AppStartedHandler", 2, "<-- StartAppCheckHandler AbsShareMSG Failed!");
                }
                context.startActivity(launchIntentForPackage);
            }
            return true;
        } catch (PackageManager.NameNotFoundException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, e16.getMessage());
            }
            return false;
        }
    }

    private boolean clickWebMsg(Context context, String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, "SourceClickHandler clickWebMsg  url = " + str);
        }
        if (!TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"))) {
            Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("key_isReadModeEnabled", true);
            intent.putExtra("title", str2);
            intent.putExtra("url", str);
            d.a(intent);
            ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded(this.ark_app_message.containStructMsg, intent, str);
            context.startActivity(intent);
            ReportController.n(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, str, "", "", "");
            return true;
        }
        return false;
    }

    public static int dp2px(float f16, float f17) {
        if (f16 == 0.0f) {
            return 0;
        }
        return (int) ((f16 * f17) + 0.5f);
    }

    public static int getAIOMaxHeight() {
        return dp2px(((IArkConfig) QRoute.api(IArkConfig.class)).getArkPlatformConfig().c().a());
    }

    public static int getAIOMaxWidth() {
        return f.f199481a;
    }

    public static String getArkMetaValue(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return jSONObject.getJSONObject((String) jSONObject.keys().next()).optString(str2);
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    public static String getConfigFromXml(Document document) {
        if (document == null) {
            return "";
        }
        try {
            Node item = document.getElementsByTagName("Config").item(0);
            if (item == null || item.getChildNodes() == null || item.getChildNodes().getLength() <= 0) {
                return "";
            }
            NodeList childNodes = item.getChildNodes();
            JSONObject jSONObject = new JSONObject();
            for (int i3 = 0; i3 < childNodes.getLength(); i3++) {
                Node item2 = childNodes.item(i3);
                String nodeName = item2.getNodeName();
                Node firstChild = item2.getFirstChild();
                if (firstChild instanceof Text) {
                    String nodeValue = firstChild.getNodeValue();
                    if (isNumber(nodeValue) && ("forward".equals(nodeName) || "autosize".equals(nodeName) || "round".equals(nodeName) || "width".equals(nodeName) || "height".equals(nodeName))) {
                        try {
                            jSONObject.put(nodeName, Integer.valueOf(nodeValue));
                        } catch (NumberFormatException e16) {
                            QLog.i("ArkApp", 1, "getConfigFromXml param error:", e16);
                        }
                    } else {
                        jSONObject.put(nodeName, nodeValue);
                    }
                }
            }
            return jSONObject.toString();
        } catch (JSONException e17) {
            QLog.i("ArkApp", 1, "parse json error:", e17);
            return "";
        }
    }

    public static String getReplySummary(ChatMessage chatMessage) {
        try {
            StringBuilder sb5 = new StringBuilder(32);
            if (chatMessage instanceof MessageForArkApp) {
                MessageForArkApp messageForArkApp = (MessageForArkApp) chatMessage;
                IArkMsgReplyMgr iArkMsgReplyMgr = (IArkMsgReplyMgr) QRoute.api(IArkMsgReplyMgr.class);
                ArkAppMessage arkAppMessage = messageForArkApp.ark_app_message;
                if (iArkMsgReplyMgr.canReply(arkAppMessage.appName, arkAppMessage.appView, arkAppMessage.bizSrc)) {
                    Map<String, String> replyConfigFromMsg = ((IArkMsgReplyMgr) QRoute.api(IArkMsgReplyMgr.class)).getReplyConfigFromMsg(new JSONObject(messageForArkApp.ark_app_message.toAppXml()));
                    String str = replyConfigFromMsg.get(IArkMsgReplyMgr.kArkMsgReplyTag);
                    String str2 = replyConfigFromMsg.get(IArkMsgReplyMgr.kArkMsgReplyTitle);
                    sb5.append(str);
                    sb5.append(str2);
                }
            }
            if (sb5.length() == 0) {
                sb5.append(chatMessage.getSummaryMsg());
            }
            return sb5.toString();
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
            return "";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0078, code lost:
    
        if (r0.intValue() > 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00d7, code lost:
    
        if (r0.intValue() == 0) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isAllowedArkForward(boolean z16, MessageRecord messageRecord) {
        String str;
        boolean z17;
        boolean z18;
        String str2;
        if (!(messageRecord instanceof MessageForArkApp)) {
            return true;
        }
        MessageForArkApp messageForArkApp = (MessageForArkApp) messageRecord;
        int processState = messageForArkApp.getProcessState();
        boolean z19 = false;
        if (processState != 0 && processState != 1002) {
            QLog.i(TAG, 1, "ArkSafe.canForward AAShare.process not finished and forward is not allowed");
            return false;
        }
        ArkAppMessage arkAppMessage = messageForArkApp.ark_app_message;
        if (arkAppMessage == null) {
            QLog.i(TAG, 1, "ArkSafe.canForward ArkMsg is empty and forward is not allowed");
            return false;
        }
        String str3 = arkAppMessage.config;
        ArkAppMessage.Config config = new ArkAppMessage.Config();
        config.fromString(str3);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ArkSafe.canForward appname:");
        stringBuffer.append(arkAppMessage.appName);
        stringBuffer.append(",AIO is:");
        if (z16) {
            str = "PublicAccount";
        } else {
            str = QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO;
        }
        stringBuffer.append(str);
        if (TextUtils.isEmpty(str3)) {
            stringBuffer.append(",Config is empty.");
        }
        stringBuffer.append(",config.foward:");
        stringBuffer.append(config.forward);
        if (z16) {
            Integer num = config.forward;
            if (num != null) {
            }
            z18 = false;
        } else {
            com.tencent.mobileqq.activity.aio.item.b bVar = messageForArkApp.arkContainer;
            if (bVar == null) {
                return false;
            }
            if (bVar.getErrorInfo().retCode == -5) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                QLog.i(TAG, 1, String.format("ArkSafe.canForward forward is not allowed and appName=%s,retCode=%d", arkAppMessage.appName, Integer.valueOf(messageForArkApp.arkContainer.getErrorInfo().retCode)));
                return false;
            }
            Boolean bool = (Boolean) e.a(0, arkAppMessage.appName, messageForArkApp, Boolean.TRUE);
            if (bool != null && !bool.booleanValue()) {
                QLog.i(TAG, 1, "ArkSafe.canForward CheckResult is failed and is not allowed");
                return false;
            }
            if (!TextUtils.isEmpty(str3)) {
                Integer num2 = config.forward;
                if (num2 != null) {
                }
            }
            z18 = true;
        }
        stringBuffer.append(",-configAllowed:");
        stringBuffer.append(z18);
        boolean canForward = ArkAppConfigMgr.getInstance().canForward(arkAppMessage.appName, arkAppMessage.bizSrc, arkAppMessage.appView);
        stringBuffer.append(",-canViewForward:");
        stringBuffer.append(canForward);
        HashMap<String, String> hashMap = new HashMap<>(2);
        String str4 = "null";
        if (TextUtils.isEmpty(arkAppMessage.appName)) {
            str2 = "null";
        } else {
            str2 = arkAppMessage.appName;
        }
        hashMap.put(REPORT_KEY_APP_NAME, str2);
        if (!TextUtils.isEmpty(arkAppMessage.appView)) {
            str4 = arkAppMessage.appView;
        }
        hashMap.put(REPORT_KEY_APP_VIEW, str4);
        if (canForward) {
            if (Math.random() < 0.01d) {
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", REPORT_TAG_ARK_VIEW_FORWARD_ALLOW, true, 0L, 0L, hashMap, "");
            }
        } else {
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", REPORT_TAG_ARK_VIEW_FORWARD_FORBIDDEN, true, 0L, 0L, hashMap, "");
        }
        if (z18 && canForward) {
            z19 = true;
        }
        stringBuffer.append(",>>allow forward:");
        stringBuffer.append(z19);
        QLog.i(TAG, 1, stringBuffer.toString());
        return z19;
    }

    public static boolean isNumber(String str) {
        if (!Pattern.compile("[0-9]*").matcher(str).matches()) {
            return false;
        }
        return true;
    }

    public static boolean isRectangleBorder(ArkAppMessage.Config config) {
        boolean z16;
        Integer num;
        if (config != null && "normal".equals(config.type) && (num = config.round) != null && num.intValue() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "ArkApp isRectangleBorder = ", Boolean.valueOf(z16));
        }
        return z16;
    }

    public static boolean isSetHintSizeByConfig(ArkAppMessage.Config config) {
        Integer num;
        Integer num2;
        if (config == null || !"normal".equals(config.type) || (num = config.hintWidth) == null || num.intValue() == 0 || (num2 = config.hintHeight) == null || num2.intValue() == 0) {
            return false;
        }
        return true;
    }

    public static boolean isSetSizeByConfig(ArkAppMessage.Config config) {
        boolean z16;
        boolean z17;
        boolean z18;
        Integer num;
        Integer num2;
        if (config != null && ("normal".equals(config.type) || "multiple".equals(config.type))) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && (num2 = config.width) != null && num2.intValue() != 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 && (num = config.height) != null && num.intValue() != 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18 && z17) {
            return true;
        }
        return false;
    }

    public static boolean isShowMenu(MessageForArkApp messageForArkApp) {
        ArkAppMessage arkAppMessage;
        String str;
        if (messageForArkApp == null || (arkAppMessage = messageForArkApp.ark_app_message) == null || (str = arkAppMessage.config) == null) {
            return true;
        }
        ArkAppMessage.Config config = new ArkAppMessage.Config();
        config.fromString(str);
        Integer num = config.menuMode;
        if (num == null || num.intValue() != 0) {
            return true;
        }
        return false;
    }

    public static Size limitToSizeRange(float f16, int i3, int i16) {
        return limitToSizeRange(f16, i3, i16, getAIOMaxWidth(), getAIOMaxHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openThirdApp(QQAppInterface qQAppInterface, Context context) {
        String str;
        ArkAppMessage arkAppMessage = this.ark_app_message;
        String str2 = arkAppMessage.mSourceUrl;
        long c16 = o.c(arkAppMessage.appId);
        ArkAppMessage arkAppMessage2 = this.ark_app_message;
        String str3 = "";
        if (clickAppMsg(context, str2, arkAppMessage2.mSourceActionData, arkAppMessage2.mSource_A_ActionData, qQAppInterface)) {
            if (isFromSdkShare()) {
                if (c16 != 0) {
                    str3 = String.valueOf(c16);
                }
                ReportController.o(null, "dc00898", "", "", T_REPORT_TAIL_OPEN_THIRD_APP, T_REPORT_TAIL_OPEN_THIRD_APP, 0, 0, str3, "", "", "");
            }
            str = TencentLocation.RUN_MODE;
        } else {
            Activity activity = ((BaseActivity) context).getActivity();
            long parseLong = Long.parseLong(this.ark_app_message.appId);
            ArkAppMessage arkAppMessage3 = this.ark_app_message;
            if (click2YYB(activity, parseLong, arkAppMessage3.mSourceName, arkAppMessage3.mSourceActionData, arkAppMessage3.mSource_A_ActionData)) {
                if (isFromSdkShare()) {
                    if (c16 != 0) {
                        str3 = String.valueOf(c16);
                    }
                    ReportController.o(null, "dc00898", "", "", T_REPORT_TAIL_DOWNLOAD_THIRD_APP, T_REPORT_TAIL_DOWNLOAD_THIRD_APP, 0, 0, str3, "", "", "");
                }
            } else {
                clickWebMsg(context, str2, this.ark_app_message.mSourceName);
            }
            str = ColorRingJsPlugin.Method_SetUp;
        }
        k.i(qQAppInterface, qQAppInterface.getCurrentUin(), "sourceclick", Long.parseLong(this.ark_app_message.appId), 0L, str);
    }

    public static float px2dp(int i3, float f16) {
        if (i3 == 0) {
            return 0.0f;
        }
        return i3 / f16;
    }

    public void attachArkView(i iVar, i.a aVar, int i3) {
        QQTheme.isNowSimpleUI();
        throw null;
    }

    public void clickTail(i.a aVar, LinearLayout linearLayout, Context context) {
        if (this.ark_app_message != null) {
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.sApplication.getRuntime();
            if (linearLayout != null) {
                if (!TextUtils.isEmpty(this.ark_app_message.appId)) {
                    linearLayout.setBackgroundResource(R.drawable.f161457xw);
                } else {
                    linearLayout.setBackgroundResource(R.drawable.f161456dl2);
                }
                linearLayout.setOnClickListener(new a(qQAppInterface, context));
            }
        }
    }

    public void destroyContainerByRemove() {
        doOnEvent(2);
    }

    public void doOnEvent(int i3) {
        Iterator<MessageForArkApp> it = this.mExtendMsgArkAppList.iterator();
        while (it.hasNext()) {
            MessageForArkApp next = it.next();
            if (next != null) {
                next.doOnEvent(i3);
            }
        }
        com.tencent.mobileqq.activity.aio.item.b bVar = this.arkContainer;
        if (bVar != null) {
            bVar.doOnEvent(i3);
            if (i3 == 2) {
                this.arkContainer = null;
            }
        }
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        if (this.ark_app_message == null) {
            this.ark_app_message = new ArkAppMessage();
        }
        if (this.msgData != null) {
            ArkAppMessage arkAppMessage = new ArkAppMessage();
            arkAppMessage.fromBytes(this.msgData);
            String str = arkAppMessage.appName;
            if (str != null) {
                this.ark_app_message.appName = str;
            }
            String str2 = arkAppMessage.appView;
            if (str2 != null) {
                this.ark_app_message.appView = str2;
            }
            String str3 = arkAppMessage.bizSrc;
            if (str3 != null) {
                this.ark_app_message.bizSrc = str3;
            }
            String str4 = arkAppMessage.appDesc;
            if (str4 != null) {
                this.ark_app_message.appDesc = str4;
            }
            String str5 = arkAppMessage.promptText;
            if (str5 != null) {
                this.ark_app_message.promptText = str5;
            }
            String str6 = arkAppMessage.appMinVersion;
            if (str6 != null) {
                this.ark_app_message.appMinVersion = str6;
            }
            String str7 = arkAppMessage.metaList;
            if (str7 != null) {
                this.ark_app_message.metaList = str7;
            }
            String str8 = arkAppMessage.config;
            if (str8 != null) {
                this.ark_app_message.config = str8;
            }
            int i3 = arkAppMessage.from;
            if (i3 != 0) {
                this.ark_app_message.from = i3;
            }
            String str9 = arkAppMessage.appId;
            if (str9 != null) {
                this.ark_app_message.appId = str9;
            }
            String str10 = arkAppMessage.mSourceName;
            if (str10 != null) {
                this.ark_app_message.mSourceName = str10;
            }
            String str11 = arkAppMessage.mSourceActionData;
            if (str11 != null) {
                this.ark_app_message.mSourceActionData = str11;
            }
            String str12 = arkAppMessage.mSource_A_ActionData;
            if (str12 != null) {
                this.ark_app_message.mSource_A_ActionData = str12;
            }
            String str13 = arkAppMessage.mSourceUrl;
            if (str13 != null) {
                this.ark_app_message.mSourceUrl = str13;
            }
            List<ArkAppMessage> list = arkAppMessage.mAppList;
            if (list != null && !list.isEmpty()) {
                this.ark_app_message.mAppList = arkAppMessage.mAppList;
            }
            String str14 = arkAppMessage.mText;
            if (str14 != null) {
                this.ark_app_message.mText = str14;
            }
            String str15 = arkAppMessage.mSourceAd;
            if (str15 != null) {
                this.ark_app_message.mSourceAd = str15;
            }
            String str16 = arkAppMessage.mExtra;
            if (str16 != null) {
                this.ark_app_message.mExtra = str16;
            }
        }
        if (this.f203106msg == null) {
            this.f203106msg = this.ark_app_message.getSummery();
        }
        if (TextUtils.isEmpty(this.ark_app_message.appName)) {
            QLog.e(TAG, 1, "empty app name, raw-data=" + ArkAppMessage.msgDataToString(this.msgData));
        }
    }

    public com.tencent.mobileqq.ark.a extendArkCardByOpen(ArkAppContainer arkAppContainer, String str, String str2) {
        if (this.arkContainer != arkAppContainer || getMsgArkAppCount() >= l.f199504b) {
            return null;
        }
        MessageForArkApp messageForArkApp = new MessageForArkApp();
        messageForArkApp.compatibleMsg = this.compatibleMsg;
        ArkAppMessage arkAppMessage = new ArkAppMessage();
        messageForArkApp.ark_app_message = arkAppMessage;
        arkAppMessage.appName = arkAppContainer.getAppName();
        ArkAppMessage arkAppMessage2 = messageForArkApp.ark_app_message;
        arkAppMessage2.appView = str;
        arkAppMessage2.bizSrc = arkAppContainer.getBizSrc();
        messageForArkApp.ark_app_message.metaList = str2;
        messageForArkApp.issend = this.issend;
        messageForArkApp.isMultiItemMsg = this.isMultiItemMsg;
        this.mExtendMsgArkAppList.add(0, messageForArkApp);
        return messageForArkApp;
    }

    public String[] getArkAppNameAndPath() {
        String[] strArr = {this.ark_app_message.appName, null, null, null};
        if (((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime()) == null) {
            return strArr;
        }
        ArkAppMgr arkAppMgr = ArkAppMgr.getInstance();
        ArkAppMessage arkAppMessage = this.ark_app_message;
        strArr[1] = arkAppMgr.getAppPathFromLocal(arkAppMessage.appName, arkAppMessage.bizSrc);
        ArkAppMessage arkAppMessage2 = this.ark_app_message;
        strArr[2] = arkAppMessage2.appView;
        strArr[3] = arkAppMessage2.bizSrc;
        return strArr;
    }

    protected ArkAppMessage.Config getArkConfig() {
        ArkAppMessage arkAppMessage = this.ark_app_message;
        if (arkAppMessage != null && arkAppMessage.config != null) {
            ArkAppMessage.Config config = new ArkAppMessage.Config();
            config.fromString(this.ark_app_message.config);
            return config;
        }
        return null;
    }

    public byte[] getBytes() {
        prewrite();
        return this.msgData;
    }

    @Override // com.tencent.mobileqq.data.IMultiMsgRecordOp
    public String getFilename() {
        ArkAppMessage arkAppMessage = this.ark_app_message;
        if (arkAppMessage != null) {
            return arkAppMessage.optFilename();
        }
        return "";
    }

    public String getJumpUrl() {
        try {
            return new JSONObject(this.ark_app_message.metaList).optJSONObject("news").optString(WadlProxyConsts.KEY_JUMP_URL);
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
            return "";
        }
    }

    @Override // q91.a
    public String getMetaList() {
        ArkAppMessage arkAppMessage = this.ark_app_message;
        if (arkAppMessage != null) {
            return arkAppMessage.metaList;
        }
        return null;
    }

    public MessageForArkApp getMsgArkAppByPosition(int i3) {
        if (i3 == 0) {
            return this;
        }
        Iterator<MessageForArkApp> it = this.mExtendMsgArkAppList.iterator();
        int i16 = 0;
        while (it.hasNext()) {
            MessageForArkApp next = it.next();
            int msgArkAppCount = next.getMsgArkAppCount() + i16;
            if (i3 == msgArkAppCount) {
                return next;
            }
            if (i3 < msgArkAppCount) {
                return next.getMsgArkAppByPosition((i3 - i16) - 1);
            }
            i16 = msgArkAppCount;
        }
        return null;
    }

    public int getMsgArkAppCount() {
        Iterator<MessageForArkApp> it = this.mExtendMsgArkAppList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i3 += it.next().getMsgArkAppCount();
        }
        return i3 + 1;
    }

    public String getMusicAppid() {
        try {
            return new JSONObject(this.ark_app_message.metaList).optJSONObject("music").optString("appid");
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
            return "";
        }
    }

    public String getMusicTitle() {
        try {
            return new JSONObject(this.ark_app_message.metaList).optJSONObject("music").optString("title");
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
            return "";
        }
    }

    public String getNewsAppid() {
        try {
            return new JSONObject(this.ark_app_message.metaList).optJSONObject("news").optString("appid");
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
            return "";
        }
    }

    public String getPreview() {
        try {
            return new JSONObject(this.ark_app_message.metaList).optJSONObject("news").optString("preview");
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
            return "";
        }
    }

    public int getProcessState() {
        String extInfoFromExtStr = getExtInfoFromExtStr(com.tencent.mobileqq.service.message.i.f286279v);
        if (TextUtils.isEmpty(extInfoFromExtStr)) {
            return 0;
        }
        try {
            return Integer.parseInt(extInfoFromExtStr);
        } catch (NumberFormatException e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
            return 0;
        }
    }

    public String getSummery() {
        ArkAppMessage arkAppMessage = this.ark_app_message;
        if (arkAppMessage != null) {
            return arkAppMessage.getSummery();
        }
        return HardCodeUtil.qqStr(R.string.o1f);
    }

    @Override // com.tencent.mobileqq.data.IMultiMsgRecordOp
    public int getTSum() {
        ArkAppMessage arkAppMessage = this.ark_app_message;
        if (arkAppMessage != null) {
            return arkAppMessage.optTSum();
        }
        return 0;
    }

    public String getTitle() {
        try {
            return new JSONObject(this.ark_app_message.metaList).optJSONObject("news").optString("title");
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
            return "";
        }
    }

    public boolean isFromSdkShare() {
        ArkAppMessage arkAppMessage = this.ark_app_message;
        String str = arkAppMessage.appName;
        String str2 = arkAppMessage.appView;
        if ("com.tencent.structmsg".equals(str)) {
            if ("music".equals(str2)) {
                return !TextUtils.isEmpty(getMusicAppid());
            }
            if ("news".equals(str2)) {
                return !TextUtils.isEmpty(getNewsAppid());
            }
            return false;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public boolean isSupportReply() {
        return true;
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public boolean needShowTimeStamp() {
        Integer num;
        ArkAppMessage.Config arkConfig = getArkConfig();
        if (arkConfig != null && (num = arkConfig.showTime) != null && num.intValue() == 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        parse();
    }

    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        byte[] bArr;
        ArkAppMessage arkAppMessage = this.ark_app_message;
        if (arkAppMessage != null) {
            bArr = arkAppMessage.toBytes();
        } else {
            bArr = null;
        }
        this.f203106msg = getSummery();
        this.msgData = bArr;
    }

    public void saveMsgData(QQAppInterface qQAppInterface) {
        if (qQAppInterface == null) {
            QLog.e(TAG, 1, "AAShare.saveMsgData app is null");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "AAShare.saveMsgData uniseq=", Long.valueOf(this.uniseq));
        }
        prewrite();
        qQAppInterface.getMessageFacade().Y0(this.frienduin, this.istroop, this.uniseq, this.msgData);
    }

    public void saveMsgExtStrAndFlag(QQAppInterface qQAppInterface) {
        if (qQAppInterface == null) {
            QLog.e(TAG, 1, "AAShare.saveMsgExtStrAndFlag app is null");
            return;
        }
        qQAppInterface.getMessageFacade().a1(this.frienduin, this.istroop, this.uniseq, AppConstants.Key.COLUMN_EXT_STR, this.extStr);
        qQAppInterface.getMessageFacade().Z0(this.frienduin, this.istroop, this.uniseq, this.extraflag, 0);
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "AAShare.saveMsgExtStrAndFlag uniseq=", Long.valueOf(this.uniseq), ", extStr=", this.extStr, ", extraflag=", Integer.valueOf(this.extraflag), String.format(" ,msg=%h", this));
        }
    }

    public void setParsed() {
        synchronized (this) {
            this.mIsParsed = true;
        }
    }

    public void updateArkAppMetaData(JSONObject jSONObject) {
        if (jSONObject == null) {
            QLog.e(TAG, 1, "AAShare.updateArkAppMetaData dataJson is null");
        } else {
            updateArkAppMetaData(jSONObject.optString("forward_ark_app_meta"));
        }
    }

    @Override // com.tencent.mobileqq.data.IMultiMsgRecordOp
    public void updateFilename(String str) {
        if (this.ark_app_message != null && !TextUtils.isEmpty(str)) {
            this.ark_app_message.updateFilename(str);
        }
    }

    public void updateProcessStateAndExtraFlag(int i3) {
        saveExtInfoToExtStr(com.tencent.mobileqq.service.message.i.f286279v, String.valueOf(i3));
        if (i3 == 1001) {
            this.extraflag = 32772;
        } else if (i3 == 1003) {
            this.extraflag = 32768;
        } else if (i3 == 1002) {
            this.extraflag = 32772;
        }
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "AAShare.updateProcessStateAndExtraFlag uniseq=", Long.valueOf(this.uniseq), ", extStr=", this.extStr, ", extraFlag=", Integer.valueOf(this.extraflag), String.format(" ,msg=%h", this));
        }
    }

    public static int dp2px(float f16) {
        return dp2px(f16, f.c());
    }

    public static Size limitToSizeRange(float f16, int i3, int i16, int i17, int i18) {
        return limitToSizeRange(f16, i3, i16, 30, 30, (int) (i17 / f16), (int) (i18 / f16));
    }

    public static Size limitToSizeRange(float f16, int i3, int i16, int i17, int i18, int i19, int i26) {
        if (i17 > 0 && i3 < i17) {
            i3 = i17;
        }
        if (i18 > 0 && i16 < i18) {
            i16 = i18;
        }
        if (i19 <= 0 || i3 <= i19) {
            i19 = i3;
        }
        if (i26 <= 0 || i16 <= i26) {
            i26 = i16;
        }
        return new Size(dp2px(i19, f16), dp2px(i26, f16));
    }

    public void updateArkAppMetaData(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "AAShare.updateArkAppMetaData dataJson is empty");
            return;
        }
        this.ark_app_message.metaList = str;
        com.tencent.mobileqq.activity.aio.item.b bVar = this.arkContainer;
        if (bVar != null) {
            bVar.updateMetaData(str);
        }
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "AAShare.updateArkAppMetaData arkContainer=", this.arkContainer, ", meta=", str, String.format(" ,msg=%h", this));
        }
    }
}
