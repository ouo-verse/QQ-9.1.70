package com.tencent.mobileqq.config.aio;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.doutu.api.IDoutuSPUtil;
import com.tencent.qqnt.doutu.api.IDoutuService;
import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import ma1.a;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0007\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\bH\u0016J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/config/aio/DoutuConfParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lma1/a;", "", "content", "", "g", "d", "", "f", DownloadInfo.spKey_Config, "e", "<init>", "()V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class DoutuConfParser extends BaseConfigParser<a> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final String f202270e = "100933";

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final String f202271f = "DoutuConfParser";

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/config/aio/DoutuConfParser$a;", "", "", "CONFIG_ID", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "TAG", "b", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.config.aio.DoutuConfParser$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String a() {
            return DoutuConfParser.f202270e;
        }

        @NotNull
        public final String b() {
            return DoutuConfParser.f202271f;
        }

        Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0220 A[Catch: Exception -> 0x0367, TryCatch #0 {Exception -> 0x0367, blocks: (B:13:0x00c5, B:15:0x00eb, B:19:0x00f3, B:22:0x00fd, B:24:0x0107, B:25:0x0120, B:27:0x0128, B:29:0x0132, B:30:0x0150, B:32:0x0156, B:34:0x0163, B:35:0x017f, B:37:0x0185, B:39:0x0190, B:40:0x01a9, B:42:0x01af, B:44:0x01ba, B:45:0x01cc, B:47:0x01d2, B:49:0x01dd, B:50:0x01ef, B:52:0x01f5, B:54:0x0200, B:55:0x021a, B:57:0x0220, B:59:0x022d, B:60:0x0247, B:62:0x024f, B:64:0x025a, B:65:0x0273, B:67:0x0279, B:69:0x0284, B:70:0x029e, B:73:0x02ac, B:76:0x02d3, B:79:0x02e4, B:81:0x02e9, B:83:0x02f6, B:84:0x0301, B:86:0x033b, B:93:0x0354), top: B:12:0x00c5 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0279 A[Catch: Exception -> 0x0367, TryCatch #0 {Exception -> 0x0367, blocks: (B:13:0x00c5, B:15:0x00eb, B:19:0x00f3, B:22:0x00fd, B:24:0x0107, B:25:0x0120, B:27:0x0128, B:29:0x0132, B:30:0x0150, B:32:0x0156, B:34:0x0163, B:35:0x017f, B:37:0x0185, B:39:0x0190, B:40:0x01a9, B:42:0x01af, B:44:0x01ba, B:45:0x01cc, B:47:0x01d2, B:49:0x01dd, B:50:0x01ef, B:52:0x01f5, B:54:0x0200, B:55:0x021a, B:57:0x0220, B:59:0x022d, B:60:0x0247, B:62:0x024f, B:64:0x025a, B:65:0x0273, B:67:0x0279, B:69:0x0284, B:70:0x029e, B:73:0x02ac, B:76:0x02d3, B:79:0x02e4, B:81:0x02e9, B:83:0x02f6, B:84:0x0301, B:86:0x033b, B:93:0x0354), top: B:12:0x00c5 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x02e9 A[Catch: Exception -> 0x0367, TryCatch #0 {Exception -> 0x0367, blocks: (B:13:0x00c5, B:15:0x00eb, B:19:0x00f3, B:22:0x00fd, B:24:0x0107, B:25:0x0120, B:27:0x0128, B:29:0x0132, B:30:0x0150, B:32:0x0156, B:34:0x0163, B:35:0x017f, B:37:0x0185, B:39:0x0190, B:40:0x01a9, B:42:0x01af, B:44:0x01ba, B:45:0x01cc, B:47:0x01d2, B:49:0x01dd, B:50:0x01ef, B:52:0x01f5, B:54:0x0200, B:55:0x021a, B:57:0x0220, B:59:0x022d, B:60:0x0247, B:62:0x024f, B:64:0x025a, B:65:0x0273, B:67:0x0279, B:69:0x0284, B:70:0x029e, B:73:0x02ac, B:76:0x02d3, B:79:0x02e4, B:81:0x02e9, B:83:0x02f6, B:84:0x0301, B:86:0x033b, B:93:0x0354), top: B:12:0x00c5 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02f6 A[Catch: Exception -> 0x0367, TryCatch #0 {Exception -> 0x0367, blocks: (B:13:0x00c5, B:15:0x00eb, B:19:0x00f3, B:22:0x00fd, B:24:0x0107, B:25:0x0120, B:27:0x0128, B:29:0x0132, B:30:0x0150, B:32:0x0156, B:34:0x0163, B:35:0x017f, B:37:0x0185, B:39:0x0190, B:40:0x01a9, B:42:0x01af, B:44:0x01ba, B:45:0x01cc, B:47:0x01d2, B:49:0x01dd, B:50:0x01ef, B:52:0x01f5, B:54:0x0200, B:55:0x021a, B:57:0x0220, B:59:0x022d, B:60:0x0247, B:62:0x024f, B:64:0x025a, B:65:0x0273, B:67:0x0279, B:69:0x0284, B:70:0x029e, B:73:0x02ac, B:76:0x02d3, B:79:0x02e4, B:81:0x02e9, B:83:0x02f6, B:84:0x0301, B:86:0x033b, B:93:0x0354), top: B:12:0x00c5 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x033b A[Catch: Exception -> 0x0367, TryCatch #0 {Exception -> 0x0367, blocks: (B:13:0x00c5, B:15:0x00eb, B:19:0x00f3, B:22:0x00fd, B:24:0x0107, B:25:0x0120, B:27:0x0128, B:29:0x0132, B:30:0x0150, B:32:0x0156, B:34:0x0163, B:35:0x017f, B:37:0x0185, B:39:0x0190, B:40:0x01a9, B:42:0x01af, B:44:0x01ba, B:45:0x01cc, B:47:0x01d2, B:49:0x01dd, B:50:0x01ef, B:52:0x01f5, B:54:0x0200, B:55:0x021a, B:57:0x0220, B:59:0x022d, B:60:0x0247, B:62:0x024f, B:64:0x025a, B:65:0x0273, B:67:0x0279, B:69:0x0284, B:70:0x029e, B:73:0x02ac, B:76:0x02d3, B:79:0x02e4, B:81:0x02e9, B:83:0x02f6, B:84:0x0301, B:86:0x033b, B:93:0x0354), top: B:12:0x00c5 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void g(String content) {
        int i3;
        AppRuntime appRuntime;
        long j3;
        AppRuntime appRuntime2;
        int i16;
        int i17;
        String str;
        String str2;
        long j16;
        long j17;
        int i18;
        int i19;
        int i26;
        boolean z16;
        boolean z17;
        boolean z18;
        AppRuntime appRuntime3;
        boolean z19;
        boolean z26;
        boolean z27;
        Context context = BaseApplication.context;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String currentUin = peekAppRuntime.getCurrentUin();
        if (TextUtils.isEmpty(content)) {
            if (QLog.isColorLevel()) {
                QLog.d(f202271f, 1, "handleDoutuConfig content is null");
            }
            ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).removeDoutuSwitch(context, currentUin);
            ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).removeDoutuDuration(context, currentUin);
            ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).removeDoutuComboSwitch(context, currentUin);
            ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).removeDoutuSmartSwitchNew(context, currentUin);
            ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).removeDoutuResUrl(context, currentUin);
            ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).removeDoutuResMd5(context, currentUin);
            ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).removeComboDuration(context, currentUin);
            ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).removeComboKeep(context, currentUin);
            ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).removeSmartPicCount(context, currentUin);
            ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).removeDoutuSmartSwitchNew(context, currentUin);
            ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).removeDuiTimes(context, currentUin);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f202271f, 1, "handleDoutuConfig content" + content);
        }
        try {
            DocumentBuilder newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            byte[] bytes = content.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            Document parse = newDocumentBuilder.parse(new ByteArrayInputStream(bytes));
            NodeList elementsByTagName = parse.getElementsByTagName("doutu_config");
            if (elementsByTagName != null && elementsByTagName.getLength() > 0) {
                if (parse.getElementsByTagName("entry") != null && parse.getElementsByTagName("entry").item(0) != null) {
                    String nodeValue = parse.getElementsByTagName("entry").item(0).getFirstChild().getNodeValue();
                    Intrinsics.checkNotNullExpressionValue(nodeValue, "document.getElementsByTa\u2026m(0).firstChild.nodeValue");
                    i3 = Integer.parseInt(nodeValue);
                } else {
                    i3 = 0;
                }
                long j18 = 0;
                if (parse.getElementsByTagName("timeGap") != null && parse.getElementsByTagName("timeGap").item(0) != null) {
                    String nodeValue2 = parse.getElementsByTagName("timeGap").item(0).getFirstChild().getNodeValue();
                    Intrinsics.checkNotNullExpressionValue(nodeValue2, "document.getElementsByTa\u2026m(0).firstChild.nodeValue");
                    long parseLong = Long.parseLong(nodeValue2);
                    appRuntime = peekAppRuntime;
                    j3 = parseLong;
                } else {
                    appRuntime = peekAppRuntime;
                    j3 = 0;
                }
                if (parse.getElementsByTagName("duiTimes") != null) {
                    appRuntime2 = appRuntime;
                    if (parse.getElementsByTagName("duiTimes").item(0) != null) {
                        String nodeValue3 = parse.getElementsByTagName("duiTimes").item(0).getFirstChild().getNodeValue();
                        Intrinsics.checkNotNullExpressionValue(nodeValue3, "document.getElementsByTa\u2026m(0).firstChild.nodeValue");
                        i16 = Integer.parseInt(nodeValue3);
                        if (parse.getElementsByTagName("entryCombo") == null && parse.getElementsByTagName("entryCombo").item(0) != null) {
                            String nodeValue4 = parse.getElementsByTagName("entryCombo").item(0).getFirstChild().getNodeValue();
                            Intrinsics.checkNotNullExpressionValue(nodeValue4, "document.getElementsByTa\u2026m(0).firstChild.nodeValue");
                            i17 = Integer.parseInt(nodeValue4);
                        } else {
                            i17 = 0;
                        }
                        if (parse.getElementsByTagName(WadlProxyConsts.RES_URL) == null && parse.getElementsByTagName(WadlProxyConsts.RES_URL).item(0) != null) {
                            str = parse.getElementsByTagName(WadlProxyConsts.RES_URL).item(0).getFirstChild().getNodeValue();
                        } else {
                            str = null;
                        }
                        if (parse.getElementsByTagName(WadlProxyConsts.RES_MD5) == null && parse.getElementsByTagName(WadlProxyConsts.RES_MD5).item(0) != null) {
                            str2 = parse.getElementsByTagName(WadlProxyConsts.RES_MD5).item(0).getFirstChild().getNodeValue();
                        } else {
                            str2 = null;
                        }
                        if (parse.getElementsByTagName("comboDuration") == null && parse.getElementsByTagName("comboDuration").item(0) != null) {
                            String nodeValue5 = parse.getElementsByTagName("comboDuration").item(0).getFirstChild().getNodeValue();
                            Intrinsics.checkNotNullExpressionValue(nodeValue5, "document.getElementsByTa\u2026m(0).firstChild.nodeValue");
                            j16 = Long.parseLong(nodeValue5);
                        } else {
                            j16 = 0;
                        }
                        if (parse.getElementsByTagName("comboKeep") == null) {
                            j17 = j16;
                            if (parse.getElementsByTagName("comboKeep").item(0) != null) {
                                String nodeValue6 = parse.getElementsByTagName("comboKeep").item(0).getFirstChild().getNodeValue();
                                Intrinsics.checkNotNullExpressionValue(nodeValue6, "document.getElementsByTa\u2026m(0).firstChild.nodeValue");
                                j18 = Long.parseLong(nodeValue6);
                            }
                        } else {
                            j17 = j16;
                        }
                        long j19 = j18;
                        if (parse.getElementsByTagName("recommendSwitch") == null && parse.getElementsByTagName("recommendSwitch").item(0) != null) {
                            String nodeValue7 = parse.getElementsByTagName("recommendSwitch").item(0).getFirstChild().getNodeValue();
                            Intrinsics.checkNotNullExpressionValue(nodeValue7, "document.getElementsByTa\u2026m(0).firstChild.nodeValue");
                            i18 = Integer.parseInt(nodeValue7);
                        } else {
                            i18 = 0;
                        }
                        if (parse.getElementsByTagName("smartHeadPicCount") == null) {
                            i19 = 0;
                            if (parse.getElementsByTagName("smartHeadPicCount").item(0) != null) {
                                String nodeValue8 = parse.getElementsByTagName("smartHeadPicCount").item(0).getFirstChild().getNodeValue();
                                Intrinsics.checkNotNullExpressionValue(nodeValue8, "document.getElementsByTa\u2026m(0).firstChild.nodeValue");
                                i26 = Integer.parseInt(nodeValue8);
                                IDoutuSPUtil iDoutuSPUtil = (IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class);
                                String str3 = ConfigServlet.f202907b;
                                if (i3 == 1) {
                                    z16 = 1;
                                } else {
                                    z16 = i19;
                                }
                                iDoutuSPUtil.updateDoutuSwitch(context, str3, z16);
                                ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).updateDoutuDuration(context, ConfigServlet.f202907b, j3);
                                ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).updateDuiTimes(context, ConfigServlet.f202907b, i16);
                                IDoutuSPUtil iDoutuSPUtil2 = (IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class);
                                String str4 = ConfigServlet.f202907b;
                                if (i17 == 1) {
                                    z17 = 1;
                                } else {
                                    z17 = i19;
                                }
                                iDoutuSPUtil2.updateDoutuComboSwitch(context, str4, z17);
                                IDoutuSPUtil iDoutuSPUtil3 = (IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class);
                                String str5 = ConfigServlet.f202907b;
                                if (i18 == 1) {
                                    z18 = 1;
                                } else {
                                    z18 = i19;
                                }
                                iDoutuSPUtil3.updateDoutuSmartSwitchNew(context, str5, z18);
                                if (str != null) {
                                    ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).updateDoutuResUrl(context, ConfigServlet.f202907b, str);
                                }
                                if (str2 != null) {
                                    ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).updateDoutuResMd5(context, ConfigServlet.f202907b, str2);
                                }
                                long j26 = j17;
                                ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).updateComboDuration(context, ConfigServlet.f202907b, j26);
                                ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).updateComboKeep(context, ConfigServlet.f202907b, j19);
                                ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).updateSmartPicCount(context, ConfigServlet.f202907b, i26);
                                appRuntime3 = appRuntime2;
                                IRuntimeService runtimeService = appRuntime3.getRuntimeService(IDoutuService.class, "");
                                Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(ID\u2026va, ProcessConstant.MAIN)");
                                IDoutuService iDoutuService = (IDoutuService) runtimeService;
                                if (appRuntime3 instanceof BaseQQAppInterface) {
                                    iDoutuService.setApp(appRuntime3);
                                    if (i3 == 1) {
                                        z19 = 1;
                                    } else {
                                        z19 = i19;
                                    }
                                    if (i17 == 1) {
                                        z26 = 1;
                                    } else {
                                        z26 = i19;
                                    }
                                    if (i18 == 1) {
                                        z27 = 1;
                                    } else {
                                        z27 = i19;
                                    }
                                    iDoutuService.updataDoutuConfig(z19, z26, j3, j26, j19, z27, i26);
                                    iDoutuService.doOnLogin(true);
                                    return;
                                }
                                return;
                            }
                        } else {
                            i19 = 0;
                        }
                        i26 = i19;
                        IDoutuSPUtil iDoutuSPUtil4 = (IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class);
                        String str32 = ConfigServlet.f202907b;
                        if (i3 == 1) {
                        }
                        iDoutuSPUtil4.updateDoutuSwitch(context, str32, z16);
                        ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).updateDoutuDuration(context, ConfigServlet.f202907b, j3);
                        ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).updateDuiTimes(context, ConfigServlet.f202907b, i16);
                        IDoutuSPUtil iDoutuSPUtil22 = (IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class);
                        String str42 = ConfigServlet.f202907b;
                        if (i17 == 1) {
                        }
                        iDoutuSPUtil22.updateDoutuComboSwitch(context, str42, z17);
                        IDoutuSPUtil iDoutuSPUtil32 = (IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class);
                        String str52 = ConfigServlet.f202907b;
                        if (i18 == 1) {
                        }
                        iDoutuSPUtil32.updateDoutuSmartSwitchNew(context, str52, z18);
                        if (str != null) {
                        }
                        if (str2 != null) {
                        }
                        long j262 = j17;
                        ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).updateComboDuration(context, ConfigServlet.f202907b, j262);
                        ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).updateComboKeep(context, ConfigServlet.f202907b, j19);
                        ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).updateSmartPicCount(context, ConfigServlet.f202907b, i26);
                        appRuntime3 = appRuntime2;
                        IRuntimeService runtimeService2 = appRuntime3.getRuntimeService(IDoutuService.class, "");
                        Intrinsics.checkNotNullExpressionValue(runtimeService2, "app.getRuntimeService(ID\u2026va, ProcessConstant.MAIN)");
                        IDoutuService iDoutuService2 = (IDoutuService) runtimeService2;
                        if (appRuntime3 instanceof BaseQQAppInterface) {
                        }
                    }
                } else {
                    appRuntime2 = appRuntime;
                }
                i16 = 0;
                if (parse.getElementsByTagName("entryCombo") == null) {
                }
                i17 = 0;
                if (parse.getElementsByTagName(WadlProxyConsts.RES_URL) == null) {
                }
                str = null;
                if (parse.getElementsByTagName(WadlProxyConsts.RES_MD5) == null) {
                }
                str2 = null;
                if (parse.getElementsByTagName("comboDuration") == null) {
                }
                j16 = 0;
                if (parse.getElementsByTagName("comboKeep") == null) {
                }
                long j192 = j18;
                if (parse.getElementsByTagName("recommendSwitch") == null) {
                }
                i18 = 0;
                if (parse.getElementsByTagName("smartHeadPicCount") == null) {
                }
                i26 = i19;
                IDoutuSPUtil iDoutuSPUtil42 = (IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class);
                String str322 = ConfigServlet.f202907b;
                if (i3 == 1) {
                }
                iDoutuSPUtil42.updateDoutuSwitch(context, str322, z16);
                ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).updateDoutuDuration(context, ConfigServlet.f202907b, j3);
                ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).updateDuiTimes(context, ConfigServlet.f202907b, i16);
                IDoutuSPUtil iDoutuSPUtil222 = (IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class);
                String str422 = ConfigServlet.f202907b;
                if (i17 == 1) {
                }
                iDoutuSPUtil222.updateDoutuComboSwitch(context, str422, z17);
                IDoutuSPUtil iDoutuSPUtil322 = (IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class);
                String str522 = ConfigServlet.f202907b;
                if (i18 == 1) {
                }
                iDoutuSPUtil322.updateDoutuSmartSwitchNew(context, str522, z18);
                if (str != null) {
                }
                if (str2 != null) {
                }
                long j2622 = j17;
                ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).updateComboDuration(context, ConfigServlet.f202907b, j2622);
                ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).updateComboKeep(context, ConfigServlet.f202907b, j192);
                ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).updateSmartPicCount(context, ConfigServlet.f202907b, i26);
                appRuntime3 = appRuntime2;
                IRuntimeService runtimeService22 = appRuntime3.getRuntimeService(IDoutuService.class, "");
                Intrinsics.checkNotNullExpressionValue(runtimeService22, "app.getRuntimeService(ID\u2026va, ProcessConstant.MAIN)");
                IDoutuService iDoutuService22 = (IDoutuService) runtimeService22;
                if (appRuntime3 instanceof BaseQQAppInterface) {
                }
            }
        } catch (Exception e16) {
            QLog.e(f202271f, 1, "handleDoutuConfig failed" + e16);
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public a defaultConfig() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(@Nullable a config) {
        QLog.d(f202271f, 1, "config update");
        super.doOnConfigUpdate(config);
        if (config != null) {
            g(config.getConfigString());
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public a parse(@NotNull byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        String str = new String(content, UTF_8);
        a aVar = new a();
        aVar.b(str);
        g(str);
        return aVar;
    }
}
