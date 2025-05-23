package com.tencent.open.agent.quickauth;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.Pair;
import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.QuickAuthorityConfBean;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.loginregister.servlet.ILoginServletService;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.thirdsig.api.IThirdSigService;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.agent.util.AuthUIUtil;
import com.tencent.open.api.IOpenBrowserAppInfo;
import com.tencent.open.appcommon.OpensdkServlet;
import com.tencent.open.ticket.OpenTicketHelper;
import com.tencent.protofile.getappinfo.GetAppInfoProto$GetAppinfoRequest;
import com.tencent.protofile.getappinfo.GetAppInfoProto$GetAppinfoResponse;
import com.tencent.protofile.getappinfo.GetAppInfoProto$MsgIconsurl;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.smtt.sdk.TbsConfig;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.TicketManagerImpl;
import mqq.app.api.IRuntimeService;
import mqq.manager.Manager;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 ;2\u00020\u0001:\u0001\u0010B\u001f\u0012\u0006\u00104\u001a\u000203\u0012\u0006\u00106\u001a\u000205\u0012\u0006\u00108\u001a\u000207\u00a2\u0006\u0004\b9\u0010:J\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u001a\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u0019\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0018\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0002H\u0004R\u0016\u0010\u001d\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\rR$\u0010%\u001a\u0004\u0018\u00010\u001e8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001b\u0010+\u001a\u00020&8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00102\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u00101\u00a8\u0006<"}, d2 = {"Lcom/tencent/open/agent/quickauth/WebQuickAuthHandler;", "Lcom/tencent/open/agent/quickauth/j;", "", "ssoAccount", "wxstweb", "", BdhLogUtil.LogTag.Tag_Req, "", "ret", "errMsgStr", "O", "G", "H", "J", ExifInterface.LATITUDE_SOUTH, "l", "a", "Landroid/content/Intent;", "intent", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "b", "Lcom/tencent/open/agent/quickauth/z;", "e", "", "i", "B", "appid", "comfrom", "K", "mThirdAppId", "", "f", "[B", "N", "()[B", "U", "([B)V", "qrCodeBytes", "", "g", "Lkotlin/Lazy;", "M", "()Z", "oidbGetStWebSwitch", "Lcom/tencent/mobileqq/loginregister/servlet/f;", tl.h.F, "Lcom/tencent/mobileqq/loginregister/servlet/f;", "ssoLoginObserver", "Lcom/tencent/mobileqq/thirdsig/api/d;", "Lcom/tencent/mobileqq/thirdsig/api/d;", "thirdSigCallback", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/open/agent/quickauth/i;", "view", "Landroid/os/Bundle;", "mParams", "<init>", "(Landroid/app/Activity;Lcom/tencent/open/agent/quickauth/i;Landroid/os/Bundle;)V", "j", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public class WebQuickAuthHandler extends j {

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private static final String[] f340379k = {"http://ptlogin2.qq.com", "http://ptlogin2.soso.com", "http://ptlogin2.paipai.com", "http://ptlogin2.tenpay.com", "http://ptlogin2.taotao.com", "http://ptlogin2.tencent.com", "http://ptlogin2.oa.com", "http://ptlogin2.webdev.com", "http://ptlogin2.3366.com", "http://ptlogin2.imqq.com", "http://ptlogin2.pengyou.com", "http://ptlogin2.qplus.com", "http://ptlogin2.qzone.com", "http://ptlogin2.id.qq.com", "http://ptlogin2.myapp.com", "http://ptlogin2.kuyoo.cn", "http://ptlogin2.function.qq.com", "http://ptlogin2.crm2.qq.com", "http://ptlogin2.weiyun.com", "http://ptlogin2.wechatapp.com", "http://ptlogin2.51buy.com", "http://ptlogin2.qcloud.com", "http://ptlogin2.wechat.com", "http://ptlogin2.qmail.com", "http://ptlogin2.ejinshang.com", "http://ptlogin2.lvren.com", "http://ptlogin2.weishi.com", "https://ssl.ptlogin2.qq.com", "https://ssl.ptlogin2.tenpay.com", "https://ssl.ptlogin2.paipai.com", "https://ssl.ptlogin2.soso.com", "https://ssl.ptlogin2.3366.com", "https://ssl.ptlogin2.pengyou.com", "https://ssl.ptlogin2.imqq.com", "https://ssl.ptlogin2.qzone.com", "https://ssl.ptlogin2.qcloud.com", "https://ssl.ptlogin2.51buy.com", "https://ssl.ptlogin2.weiyun.com", "https://ssl.ptlogin2.myapp.com", "https://ssl.ptlogin2.yixun.com", "https://ssl.ptlogin2.wanggou.com", "https://ssl.ptlogin2.ejinshang.com"};

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long mThirdAppId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private byte[] qrCodeBytes;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy oidbGetStWebSwitch;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.loginregister.servlet.f ssoLoginObserver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.thirdsig.api.d thirdSigCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/open/agent/quickauth/WebQuickAuthHandler$a;", "", "", "baseUrl", "ssoAccount", "wxstweb", "a", "", "urlFilter", "[Ljava/lang/String;", "b", "()[Ljava/lang/String;", "", "MAX_PT_APPNAME_LENGTH", "I", "MAX_PT_PACKAGE_LENGTH", "QRCODE_CONTENT_CHAR_SIZE", "QRCODE_CONTENT_HEAD_CHAR_SIZE", "TAG", "Ljava/lang/String;", "<init>", "()V", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.open.agent.quickauth.WebQuickAuthHandler$a, reason: from kotlin metadata */
    /* loaded from: classes22.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String a(@NotNull String baseUrl, @NotNull String ssoAccount, @NotNull String wxstweb) {
            boolean endsWith$default;
            String replace$default;
            String replace$default2;
            Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
            Intrinsics.checkNotNullParameter(ssoAccount, "ssoAccount");
            Intrinsics.checkNotNullParameter(wxstweb, "wxstweb");
            LinkedList linkedList = new LinkedList();
            linkedList.add(new Pair("keyindex", "19"));
            linkedList.add(new Pair("clientuin", ssoAccount));
            linkedList.add(new Pair(v4.b.CLIENTKEY, wxstweb));
            String b16 = com.tencent.open.agent.util.s.b(baseUrl, linkedList);
            if (b16 == null) {
                endsWith$default = StringsKt__StringsJVMKt.endsWith$default(baseUrl, ContainerUtils.FIELD_DELIMITER, false, 2, null);
                if (!endsWith$default) {
                    baseUrl = baseUrl + ContainerUtils.FIELD_DELIMITER;
                }
                replace$default = StringsKt__StringsJVMKt.replace$default("keyindex=19&clientuin=$CLIENTUIN$&clientkey=$CLIENTKEY$", "$CLIENTUIN$", ssoAccount, false, 4, (Object) null);
                replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "$CLIENTKEY$", wxstweb, false, 4, (Object) null);
                return baseUrl + replace$default2;
            }
            return b16;
        }

        @NotNull
        public final String[] b() {
            return WebQuickAuthHandler.f340379k;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J.\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J$\u0010\r\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J*\u0010\u000f\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/open/agent/quickauth/WebQuickAuthHandler$b", "Lcom/tencent/mobileqq/loginregister/servlet/f;", "", "ssoAccount", "", "wtTicket", "", "targetTicket", "Landroid/os/Bundle;", "data", "", "c", "action", "d", "ret", "a", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b extends com.tencent.mobileqq.loginregister.servlet.f {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ i f340386e;

        b(i iVar) {
            this.f340386e = iVar;
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.f
        public void a(@Nullable String ssoAccount, int action, int ret, @NotNull Bundle data) {
            String str;
            Intrinsics.checkNotNullParameter(data, "data");
            com.tencent.open.agent.util.t.e("WebQuickAuthHandler", "-->onFailed--action = " + action + ", ret = " + ret + ", ssoAccount = *" + com.tencent.open.agent.util.g.C(ssoAccount));
            ErrMsg errMsg = (ErrMsg) data.getParcelable("errMsg");
            if (errMsg != null) {
                str = errMsg.getMessage();
            } else {
                str = null;
            }
            WebQuickAuthHandler.this.O(ret, str);
            ab.f340393a.b(false, ret, false);
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.f
        public void c(@Nullable String ssoAccount, @Nullable byte[] wtTicket, int targetTicket, @Nullable Bundle data) {
            String buf_to_string;
            com.tencent.open.agent.util.t.f("WebQuickAuthHandler", "-->onGetTicketNoPasswd--ssoAccount = *" + com.tencent.open.agent.util.g.C(ssoAccount));
            String str = "";
            if (targetTicket == 32 && (buf_to_string = util.buf_to_string(wtTicket)) != null) {
                str = buf_to_string;
            }
            WebQuickAuthHandler.this.R(ssoAccount, str);
            ab.f340393a.b(false, 0, true);
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.f
        public void d(@Nullable String ssoAccount, int action, @Nullable Bundle data) {
            com.tencent.open.agent.util.t.f("WebQuickAuthHandler", "-->onUserCancel--action = " + action + ", ssoAccount = *" + com.tencent.open.agent.util.g.C(ssoAccount));
            this.f340386e.L();
            ab.f340393a.b(false, -10000, false);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/open/agent/quickauth/WebQuickAuthHandler$c", "Lcom/tencent/mobileqq/thirdsig/api/d;", "Lcom/tencent/mobileqq/thirdsig/api/g;", "thirdSigInfo", "", "a", "", "result", "", "errMsg", "onFail", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class c implements com.tencent.mobileqq.thirdsig.api.d {
        c() {
        }

        @Override // com.tencent.mobileqq.thirdsig.api.d
        public void a(@NotNull com.tencent.mobileqq.thirdsig.api.g thirdSigInfo) {
            boolean z16;
            Intrinsics.checkNotNullParameter(thirdSigInfo, "thirdSigInfo");
            com.tencent.open.agent.util.t.f("WebQuickAuthHandler", "oidb onSuccess");
            String wxstweb = HexUtil.bytes2HexStr(thirdSigInfo.a());
            if (wxstweb != null && wxstweb.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                com.tencent.open.agent.util.t.f("WebQuickAuthHandler", "oidb onSuccess but wxstweb is null or empty");
                onFail(-10000, "onSuccess, but wxstweb is empty");
                return;
            }
            WebQuickAuthHandler webQuickAuthHandler = WebQuickAuthHandler.this;
            String currentAccount = webQuickAuthHandler.getCurrentAccount();
            Intrinsics.checkNotNullExpressionValue(wxstweb, "wxstweb");
            webQuickAuthHandler.R(currentAccount, wxstweb);
            ab.f340393a.b(true, 0, true);
        }

        @Override // com.tencent.mobileqq.thirdsig.api.d
        public void onFail(int result, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            com.tencent.open.agent.util.t.e("WebQuickAuthHandler", "oidb onFail code: " + result + ", errMsg: " + errMsg);
            ab.f340393a.b(true, result, false);
            if (!MobileQQ.sMobileQQ.isLoginByNT()) {
                WebQuickAuthHandler.this.J();
            } else {
                WebQuickAuthHandler.this.O(result, errMsg);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebQuickAuthHandler(@NotNull Activity activity, @NotNull i view, @NotNull Bundle mParams) {
        super(activity, view, mParams);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(mParams, "mParams");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.open.agent.quickauth.WebQuickAuthHandler$oidbGetStWebSwitch$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qopen_stweb_oidb_switch", false);
                com.tencent.open.agent.util.t.f("WebQuickAuthHandler", "oidbGetStWebSwitch = " + isSwitchOn);
                return Boolean.valueOf(isSwitchOn);
            }
        });
        this.oidbGetStWebSwitch = lazy;
        this.ssoLoginObserver = new b(view);
        this.thirdSigCallback = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(final WebQuickAuthHandler this$0, final boolean z16, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String().runOnUiThread(new Runnable() { // from class: com.tencent.open.agent.quickauth.ai
            @Override // java.lang.Runnable
            public final void run() {
                WebQuickAuthHandler.D(z16, this$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(boolean z16, WebQuickAuthHandler this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!z16) {
            this$0.G();
        } else {
            this$0.getView().u0();
            QQToast.makeText(MobileQQ.sMobileQQ, R.string.cp9, 0).show(this$0.h().getDimensionPixelSize(R.dimen.title_bar_height));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(final WebQuickAuthHandler this$0, final boolean z16, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String().runOnUiThread(new Runnable() { // from class: com.tencent.open.agent.quickauth.ak
            @Override // java.lang.Runnable
            public final void run() {
                WebQuickAuthHandler.F(z16, this$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(boolean z16, WebQuickAuthHandler this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!z16) {
            com.tencent.open.agent.util.t.b("WebQuickAuthHandler", "login have");
            this$0.getView().q0();
        } else {
            this$0.getView().u0();
            QQToast.makeText(MobileQQ.sMobileQQ, R.string.cp9, 0).show(this$0.h().getDimensionPixelSize(R.dimen.title_bar_height));
        }
    }

    private final void G() {
        getView().showProgress(getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String().getString(R.string.f171153cp1));
        ab.f340393a.a(M());
        com.tencent.open.agent.util.t.b("WebQuickAuthHandler", "-->doAuthorize");
        if (M()) {
            H();
        } else {
            J();
        }
    }

    private final void H() {
        kotlin.Pair pair;
        if (MobileQQ.sMobileQQ.isLoginByNT()) {
            OpenTicketHelper.c(getCurrentAccount(), true, new com.tencent.open.agent.util.u() { // from class: com.tencent.open.agent.quickauth.am
                @Override // com.tencent.open.agent.util.u
                public final void onResult(boolean z16, String str) {
                    WebQuickAuthHandler.I(WebQuickAuthHandler.this, z16, str);
                }
            });
            return;
        }
        Manager manager = MobileQQ.sMobileQQ.peekAppRuntime().getManager(2);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type mqq.manager.TicketManager");
        if (((TicketManager) manager).getA2(getCurrentAccount()) != null) {
            pair = new kotlin.Pair(0, 16);
        } else {
            pair = new kotlin.Pair(6, Integer.valueOf(TicketManagerImpl.BUFLAG_OPEN_CONNECT));
        }
        int intValue = ((Number) pair.component1()).intValue();
        int intValue2 = ((Number) pair.component2()).intValue();
        com.tencent.open.agent.util.t.f("WebQuickAuthHandler", "doAuthorizeByOidb wt uinType=" + intValue + ", appId=" + intValue2);
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IThirdSigService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026onstant.ALL\n            )");
        ((IThirdSigService) runtimeService).getStWeb(Long.parseLong(getCurrentAccount()), intValue, intValue2, this.thirdSigCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(WebQuickAuthHandler this$0, boolean z16, String str) {
        kotlin.Pair pair;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.open.agent.util.t.b("WebQuickAuthHandler", "doAuthorizeByOidb mainTicketReady? " + z16);
        if (z16) {
            pair = new kotlin.Pair(0, 16);
        } else {
            pair = new kotlin.Pair(6, Integer.valueOf(TicketManagerImpl.BUFLAG_OPEN_CONNECT));
        }
        int intValue = ((Number) pair.component1()).intValue();
        int intValue2 = ((Number) pair.component2()).intValue();
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IThirdSigService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026ant.ALL\n                )");
        ((IThirdSigService) runtimeService).getStWeb(Long.parseLong(this$0.getCurrentAccount()), intValue, intValue2, this$0.thirdSigCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J() {
        Bundle bundle = new Bundle();
        Manager manager = d().getManager(2);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type mqq.manager.TicketManager");
        if (TextUtils.isEmpty(((TicketManager) manager).getStweb(getCurrentAccount()))) {
            bundle.putByteArray(AppConstants.Key.KEY_CONNECT_DATA, com.tencent.open.agent.util.g.u(String.valueOf(this.mThirdAppId)));
            bundle.putLong("dwSrcAppid", BaseConstants.OPEN_SDK_BUFLAG_B1);
            bundle.putLong("dwDstAppid", BaseConstants.OPEN_SDK_BUFLAG_B1);
        }
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ILoginServletService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026essConstant.ALL\n        )");
        ((ILoginServletService) runtimeService).ssoGetTicketNoPasswd(getCurrentAccount(), 32, this.ssoLoginObserver, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(WebQuickAuthHandler this$0, int i3, boolean z16, Bundle bundle) {
        int i16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.open.agent.util.t.f("WebQuickAuthHandler", "getAppInfo onReceive isSuccess=" + z16 + ", bundle=" + bundle);
        if (this$0.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String().isFinishing()) {
            com.tencent.open.agent.util.t.f("WebQuickAuthHandler", "getAppInfo onReceive return for finish");
            return;
        }
        if (!Intrinsics.areEqual(this$0.getCurrentAccount(), bundle.getString("ssoAccount"))) {
            com.tencent.open.agent.util.t.f("WebQuickAuthHandler", "getAppInfo onReceive return for account not equals");
            return;
        }
        if (z16) {
            GetAppInfoProto$GetAppinfoResponse getAppInfoProto$GetAppinfoResponse = new GetAppInfoProto$GetAppinfoResponse();
            try {
                byte[] byteArray = bundle.getByteArray("data");
                if (byteArray != null) {
                    getAppInfoProto$GetAppinfoResponse.mergeFrom(byteArray);
                    if (getAppInfoProto$GetAppinfoResponse.has() && getAppInfoProto$GetAppinfoResponse.ret.get() == 0) {
                        PBStringField pBStringField = getAppInfoProto$GetAppinfoResponse.appName;
                        if (pBStringField != null && !TextUtils.isEmpty(pBStringField.get())) {
                            String appName = getAppInfoProto$GetAppinfoResponse.appName.get();
                            com.tencent.open.agent.util.t.f("WebQuickAuthHandler", "getAppInfo onReceive return appName:" + appName);
                            i view = this$0.getView();
                            Intrinsics.checkNotNullExpressionValue(appName, "appName");
                            view.p0(appName, null);
                        }
                        PBRepeatMessageField<GetAppInfoProto$MsgIconsurl> pBRepeatMessageField = getAppInfoProto$GetAppinfoResponse.iconsURL;
                        if (pBRepeatMessageField != null && pBRepeatMessageField.has()) {
                            int size = getAppInfoProto$GetAppinfoResponse.iconsURL.get().size();
                            int i17 = 0;
                            int i18 = 0;
                            int i19 = 0;
                            while (true) {
                                if (i17 < size) {
                                    try {
                                        String str = getAppInfoProto$GetAppinfoResponse.iconsURL.get(i17).size.get();
                                        Intrinsics.checkNotNullExpressionValue(str, "imgUrl.size.get()");
                                        i16 = Integer.parseInt(str);
                                    } catch (NumberFormatException unused) {
                                        i16 = 0;
                                    }
                                    if (i16 >= 100) {
                                        break;
                                    }
                                    if (i16 > i19) {
                                        i18 = i17;
                                        i19 = i16;
                                    }
                                    i17++;
                                } else {
                                    i17 = i18;
                                    break;
                                }
                            }
                            GetAppInfoProto$MsgIconsurl getAppInfoProto$MsgIconsurl = getAppInfoProto$GetAppinfoResponse.iconsURL.get(i17);
                            if (getAppInfoProto$MsgIconsurl != null) {
                                String iconimgUrl = getAppInfoProto$MsgIconsurl.url.get();
                                com.tencent.open.agent.util.t.f("WebQuickAuthHandler", "getAppInfo onReceive return iconimgUrl:" + iconimgUrl);
                                if (!TextUtils.isEmpty(iconimgUrl)) {
                                    i view2 = this$0.getView();
                                    Intrinsics.checkNotNullExpressionValue(iconimgUrl, "iconimgUrl");
                                    view2.s0(iconimgUrl);
                                }
                            }
                        }
                    }
                }
            } catch (Exception e16) {
                com.tencent.open.agent.util.t.d("WebQuickAuthHandler", "onReceive ", e16);
            }
        }
    }

    private final boolean M() {
        return ((Boolean) this.oidbGetStWebSwitch.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(int ret, String errMsgStr) {
        final String string;
        getView().L();
        if (ret == -1000) {
            AuthUIUtil.h(getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), h().getString(R.string.f171155cp4));
            return;
        }
        if (!TextUtils.isEmpty(errMsgStr)) {
            string = errMsgStr + "(" + ret + ")";
        } else {
            string = h().getString(R.string.f171152cp0);
            Intrinsics.checkNotNullExpressionValue(string, "{\n                getRes\u2026ail_notice)\n            }");
        }
        final String string2 = h().getString(R.string.h5k);
        Intrinsics.checkNotNullExpressionValue(string2, "getResources().getString\u2026R.string.sc_login_failed)");
        com.tencent.open.agent.util.t.e("WebQuickAuthHandler", "ssoAccount failed, error: ", errMsgStr);
        getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String().runOnUiThread(new Runnable() { // from class: com.tencent.open.agent.quickauth.ah
            @Override // java.lang.Runnable
            public final void run() {
                WebQuickAuthHandler.P(WebQuickAuthHandler.this, string2, string);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(final WebQuickAuthHandler this$0, String errTitle, String finalErrMsgStr) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(errTitle, "$errTitle");
        Intrinsics.checkNotNullParameter(finalErrMsgStr, "$finalErrMsgStr");
        AuthUIUtil.g(this$0.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), errTitle, finalErrMsgStr, new DialogInterface.OnClickListener() { // from class: com.tencent.open.agent.quickauth.al
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                WebQuickAuthHandler.Q(WebQuickAuthHandler.this, dialogInterface, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(WebQuickAuthHandler this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getView().F0(this$0.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(26:1|(1:3)|4|(1:6)(1:106)|7|(1:9)|10|(2:12|(14:14|15|(4:17|(1:19)|20|(1:22))|70|24|(1:69)(1:28)|(5:50|51|52|(4:(1:55)(2:62|(1:64))|56|(0)|61)(0)|60)(1:30)|(1:32)|33|(3:44|45|46)(1:36)|37|(1:39)(1:43)|40|41)(2:71|(1:73)(2:75|(1:77)(2:78|(1:80)(2:81|(1:83)(2:84|(1:86)(2:87|(1:89)(2:90|(1:92)(2:93|(1:95)(2:96|(1:98)(2:99|(1:101)(2:102|(1:104)))))))))))))(1:105)|74|15|(0)|70|24|(1:26)|69|(0)(0)|(0)|33|(0)|44|45|46|37|(0)(0)|40|41) */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x013a, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual("LieBaoFast", r0) != false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x01e3, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x01e4, code lost:
    
        com.tencent.open.agent.util.t.e("WebQuickAuthHandler", "startActivity :" + r0.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x01a6, code lost:
    
        if (r9 != null) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01ab, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01a9, code lost:
    
        if (r9 != null) goto L88;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x015f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void R(String ssoAccount, String wxstweb) {
        String str;
        String str2;
        String str3;
        boolean z16;
        QuickAuthorityConfBean quickAuthorityConfBean;
        boolean z17;
        boolean z18;
        boolean z19;
        String str4;
        boolean startsWith$default;
        boolean startsWith$default2;
        boolean startsWith$default3;
        boolean startsWith$default4;
        boolean startsWith$default5;
        boolean startsWith$default6;
        boolean startsWith$default7;
        boolean startsWith$default8;
        boolean startsWith$default9;
        boolean startsWith$default10;
        boolean startsWith$default11;
        String string = getMParams().getString("p");
        String str5 = "";
        if (string == null) {
            string = "";
        }
        Companion companion = INSTANCE;
        if (ssoAccount == null) {
            str2 = wxstweb;
            str = "";
        } else {
            str = ssoAccount;
            str2 = wxstweb;
        }
        String a16 = companion.a(string, str, str2);
        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(a16));
        String string2 = getMParams().getString("schemacallback");
        if (string2 == null) {
            string2 = "";
        }
        String str6 = "com.ijinshan.browser_fast";
        PackageInfo packageInfo = null;
        if (!TextUtils.isEmpty(string2)) {
            str3 = ((IOpenBrowserAppInfo) QRoute.api(IOpenBrowserAppInfo.class)).getBrowserAppPackage(d(), string2);
            if (TextUtils.isEmpty(str3)) {
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(string2, "mttbrowser://", false, 2, null);
                if (!startsWith$default) {
                    startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(string2, "ucweb://", false, 2, null);
                    if (!startsWith$default2) {
                        startsWith$default3 = StringsKt__StringsJVMKt.startsWith$default(string2, "bdbrowser://", false, 2, null);
                        if (!startsWith$default3) {
                            startsWith$default4 = StringsKt__StringsJVMKt.startsWith$default(string2, "bdapp://", false, 2, null);
                            if (!startsWith$default4) {
                                startsWith$default5 = StringsKt__StringsJVMKt.startsWith$default(string2, "googlechrome://", false, 2, null);
                                if (!startsWith$default5) {
                                    startsWith$default6 = StringsKt__StringsJVMKt.startsWith$default(string2, "mzbrowser://", false, 2, null);
                                    if (!startsWith$default6) {
                                        startsWith$default7 = StringsKt__StringsJVMKt.startsWith$default(string2, "lb://", false, 2, null);
                                        if (!startsWith$default7) {
                                            startsWith$default8 = StringsKt__StringsJVMKt.startsWith$default(string2, "qihoobrowser://", false, 2, null);
                                            if (!startsWith$default8) {
                                                startsWith$default9 = StringsKt__StringsJVMKt.startsWith$default(string2, "browser2345://", false, 2, null);
                                                if (!startsWith$default9) {
                                                    startsWith$default10 = StringsKt__StringsJVMKt.startsWith$default(string2, "SogouMSE://", false, 2, null);
                                                    if (!startsWith$default10) {
                                                        startsWith$default11 = StringsKt__StringsJVMKt.startsWith$default(string2, "sogoullqmse://", false, 2, null);
                                                        if (startsWith$default11) {
                                                            str3 = "sogou.mobile.llq.online";
                                                        }
                                                    } else {
                                                        str3 = "sogou.mobile.explorer";
                                                    }
                                                } else {
                                                    str3 = "com.browser2345";
                                                }
                                            } else {
                                                str3 = "com.qihoo.browser";
                                            }
                                        } else {
                                            str3 = "com.ijinshan.browser_fast";
                                        }
                                    } else {
                                        str3 = "com.android.browser";
                                    }
                                } else {
                                    str3 = "com.android.chrome";
                                }
                            } else {
                                str3 = "com.baidu.searchbox";
                            }
                        } else {
                            str3 = "com.baidu.browser.apps";
                        }
                    } else {
                        str3 = "com.UCMobile";
                    }
                } else {
                    str3 = TbsConfig.APP_QB;
                }
            } else {
                z16 = true;
                if (TextUtils.isEmpty(str3)) {
                    Uri parse = Uri.parse(string);
                    Intrinsics.checkNotNullExpressionValue(parse, "parse(baseUrl)");
                    String queryParameter = parse.getQueryParameter("pt_browser");
                    if (queryParameter == null) {
                        queryParameter = "";
                    }
                    com.tencent.open.agent.util.t.f("WebQuickAuthHandler", "-->onGetTicketNoPasswd--schemacallback=" + string2 + ",pt_browser=" + queryParameter);
                    if (!TextUtils.isEmpty(queryParameter)) {
                    }
                }
                str6 = str3;
                Object x16 = com.tencent.mobileqq.config.am.s().x(546);
                Intrinsics.checkNotNullExpressionValue(x16, "getSingleton().loadConOb\u2026yConfProcessor.CONFIG_ID)");
                quickAuthorityConfBean = (QuickAuthorityConfBean) x16;
                if (str6 == null && str6.length() != 0) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (z17) {
                    try {
                        packageInfo = InstalledAppListMonitor.getPackageInfo(getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String().getPackageManager(), str6, 0);
                    } catch (PackageManager.NameNotFoundException e16) {
                        com.tencent.open.agent.util.t.d("WebQuickAuthHandler", "-->onGetTicketNoPasswd exception:", e16);
                    }
                    if (quickAuthorityConfBean.f202467a == 1) {
                        if (z16) {
                            str5 = ((IOpenBrowserAppInfo) QRoute.api(IOpenBrowserAppInfo.class)).getBrowserAppSign(d(), string2);
                            Intrinsics.checkNotNullExpressionValue(str5, "{ // App\u7b7e\u540d\u4ece\u7279\u6027\u5f00\u5173\u6570\u636e\u96c6\u4e2d\u83b7\u53d6\n  \u2026llback)\n                }");
                        } else {
                            String str7 = quickAuthorityConfBean.f202472f.get(str6);
                            if (str7 != null) {
                                str5 = str7;
                            }
                        }
                        if (ad.f340395a.a(getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), str6, str5)) {
                        }
                        z18 = false;
                    }
                    z19 = z18;
                } else {
                    z19 = false;
                }
                if (z19) {
                    intent.setPackage(str6);
                    intent.setData(Uri.parse(a16));
                }
                if (quickAuthorityConfBean.f202468b != 1 && !z19) {
                    getView().L();
                    QQToast.makeText(MobileQQ.sMobileQQ, HardCodeUtil.qqStr(R.string.f172502rf0), 1).show();
                } else {
                    getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String().startActivity(intent);
                    S();
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("callback", string2);
                if (!z19) {
                    str4 = "1";
                } else {
                    str4 = "0";
                }
                hashMap.put("checkRes", str4);
                StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance("", "kQuickLoginForBrowser", true, 0L, 0L, hashMap, "");
            }
        } else {
            str3 = null;
        }
        z16 = false;
        if (TextUtils.isEmpty(str3)) {
        }
        str6 = str3;
        Object x162 = com.tencent.mobileqq.config.am.s().x(546);
        Intrinsics.checkNotNullExpressionValue(x162, "getSingleton().loadConOb\u2026yConfProcessor.CONFIG_ID)");
        quickAuthorityConfBean = (QuickAuthorityConfBean) x162;
        if (str6 == null) {
        }
        z17 = true;
        if (z17) {
        }
        if (z19) {
        }
        if (quickAuthorityConfBean.f202468b != 1) {
        }
        getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String().startActivity(intent);
        S();
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("callback", string2);
        if (!z19) {
        }
        hashMap2.put("checkRes", str4);
        StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance("", "kQuickLoginForBrowser", true, 0L, 0L, hashMap2, "");
    }

    private final void S() {
        getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String().setResult(-1, new Intent());
        getView().L();
        getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String().finish();
        if (com.tencent.open.agent.util.c.n(getMParams())) {
            try {
                ReportCenter.f().q(getCurrentAccount(), "", "", "1", "9", "0", true, true);
            } catch (Exception e16) {
                com.tencent.open.agent.util.t.d("WebQuickAuthHandler", "setPtloginSdkResult report exception:", e16);
            }
        }
        try {
            if (!TextUtils.isEmpty(d().getAccount()) && !Intrinsics.areEqual(getCurrentAccount(), d().getAccount())) {
                ReportCenter.f().q(getCurrentAccount(), "", "", "1", "10", "0", true, true);
            }
        } catch (Exception e17) {
            com.tencent.open.agent.util.t.d("WebQuickAuthHandler", "setPtloginSdkResult report exception2:", e17);
        }
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.open.agent.quickauth.ag
            @Override // java.lang.Runnable
            public final void run() {
                WebQuickAuthHandler.T();
            }
        }, 16, null, false, 1000L);
        com.tencent.open.agent.util.t.f("WebQuickAuthHandler", "setPtloginSdkResult end");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T() {
        com.tencent.open.agent.util.t.f("WebQuickAuthHandler", "setPtLoginSdkResult kill process");
        SystemMethodProxy.killProcess(Process.myPid());
    }

    @NotNull
    public final Intent B(@Nullable Intent intent) {
        if (intent == null) {
            intent = new Intent();
        }
        intent.putExtra("moveTaskToBack", true);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void K(long appid, @NotNull String comfrom) {
        Intrinsics.checkNotNullParameter(comfrom, "comfrom");
        this.mThirdAppId = appid;
        com.tencent.open.agent.util.t.f("WebQuickAuthHandler", "getAppInfo appid =" + appid + ",comfrom =" + comfrom);
        GetAppInfoProto$GetAppinfoRequest getAppInfoProto$GetAppinfoRequest = new GetAppInfoProto$GetAppinfoRequest();
        getAppInfoProto$GetAppinfoRequest.client_id.set(appid);
        getAppInfoProto$GetAppinfoRequest.sdkp.set(comfrom);
        String str = Build.VERSION.RELEASE;
        if (str == null) {
            str = "";
        }
        getAppInfoProto$GetAppinfoRequest.f342196os.set(str);
        getAppInfoProto$GetAppinfoRequest.qqv.set(com.tencent.open.adapter.a.f().n());
        getAppInfoProto$GetAppinfoRequest.setHasFlag(true);
        String g16 = com.tencent.open.agent.util.c.g(getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String());
        if (!TextUtils.isEmpty(g16)) {
            getAppInfoProto$GetAppinfoRequest.appUniqueIdentifier.set(g16);
        }
        getAppInfoProto$GetAppinfoRequest.referer.set(1);
        NewIntent newIntent = new NewIntent(MobileQQ.sMobileQQ, OpensdkServlet.class);
        newIntent.setWithouLogin(true);
        newIntent.putExtra("uin", getCurrentAccount());
        newIntent.putExtra("data", getAppInfoProto$GetAppinfoRequest.toByteArray());
        newIntent.putExtra("cmd", "ConnAuthSvr.get_app_info");
        newIntent.setObserver(new com.tencent.open.appcommon.d() { // from class: com.tencent.open.agent.quickauth.aj
            @Override // mqq.observer.BusinessObserver
            public final void onReceive(int i3, boolean z16, Bundle bundle) {
                WebQuickAuthHandler.L(WebQuickAuthHandler.this, i3, z16, bundle);
            }
        });
        d().startServlet(newIntent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: N, reason: from getter */
    public final byte[] getQrCodeBytes() {
        return this.qrCodeBytes;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void U(@Nullable byte[] bArr) {
        this.qrCodeBytes = bArr;
    }

    @Override // com.tencent.open.agent.quickauth.j
    public void a() {
        com.tencent.open.agent.util.g.f(getCurrentAccount(), new com.tencent.open.agent.util.u() { // from class: com.tencent.open.agent.quickauth.af
            @Override // com.tencent.open.agent.util.u
            public final void onResult(boolean z16, String str) {
                WebQuickAuthHandler.C(WebQuickAuthHandler.this, z16, str);
            }
        });
    }

    @Override // com.tencent.open.agent.quickauth.j
    public void b() {
        com.tencent.open.agent.util.g.f(getCurrentAccount(), new com.tencent.open.agent.util.u() { // from class: com.tencent.open.agent.quickauth.ae
            @Override // com.tencent.open.agent.util.u
            public final void onResult(boolean z16, String str) {
                WebQuickAuthHandler.E(WebQuickAuthHandler.this, z16, str);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0178  */
    @Override // com.tencent.open.agent.quickauth.j
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public QuickAuthApp e() {
        boolean z16;
        String str;
        String str2;
        String string = h().getString(R.string.ivd);
        Intrinsics.checkNotNullExpressionValue(string, "getResources().getString\u2026ng.open_app_type_website)");
        getMParams().getString("packagename");
        String string2 = getMParams().getString("p");
        String str3 = "";
        if (string2 == null) {
            string2 = "";
        }
        ad adVar = ad.f340395a;
        Bundle d16 = adVar.d(string2);
        String string3 = getMParams().getString("appname");
        if (TextUtils.isEmpty(string3)) {
            string3 = d16.getString("pt_appname");
        }
        if (string3 != null && string3.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            if (string3.length() > 20) {
                string3 = string3.substring(0, 20);
                Intrinsics.checkNotNullExpressionValue(string3, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            }
            getView().p0(string3, null);
        }
        String string4 = getMParams().getString("package");
        if (TextUtils.isEmpty(string4)) {
            string4 = d16.getString("pt_package");
        }
        if (string4 != null && string4.length() > 100) {
            string4 = string4.substring(0, 100);
            Intrinsics.checkNotNullExpressionValue(string4, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        }
        if (TextUtils.isEmpty(string4) && d16.getString("daid") != null) {
            str3 = d16.getString("daid", "");
            Intrinsics.checkNotNullExpressionValue(str3, "bundle.getString(\"daid\", \"\")");
            if (Intrinsics.areEqual(str3, "5")) {
                string4 = "com.qzone";
                string3 = "QQ\u7a7a\u95f4";
            } else {
                Intrinsics.areEqual(str3, "383");
            }
        }
        String str4 = string4;
        if (TextUtils.isEmpty(str4)) {
            long j3 = -1;
            if (Intrinsics.areEqual(str3, "383")) {
                try {
                    String urlDecode = URLDecoder.decode(getMParams().getString("p"));
                    Intrinsics.checkNotNullExpressionValue(urlDecode, "urlDecode");
                    String appId = adVar.d(urlDecode).getString(CommonConstant.ReqAccessTokenParam.CLIENT_ID, "-1");
                    Intrinsics.checkNotNullExpressionValue(appId, "appId");
                    j3 = Long.parseLong(appId);
                    com.tencent.open.agent.util.t.b("WebQuickAuthHandler", "login have urlDecode =" + urlDecode + ",clientId =" + j3);
                    try {
                        K(j3, "web");
                    } catch (Exception e16) {
                        e = e16;
                        com.tencent.open.agent.util.t.e("WebQuickAuthHandler", "zhihu deal error  =" + e.getMessage());
                        long j16 = j3;
                        com.tencent.open.agent.util.t.b("WebQuickAuthHandler", "showLocalInfo() => return for package is empty mIsPtloginAction=true, daid=" + str3);
                        if (string3 != null) {
                        }
                        return new QuickAuthApp(str2, j16, str4, str3);
                    }
                } catch (Exception e17) {
                    e = e17;
                }
            }
            long j162 = j3;
            com.tencent.open.agent.util.t.b("WebQuickAuthHandler", "showLocalInfo() => return for package is empty mIsPtloginAction=true, daid=" + str3);
            if (string3 != null) {
                str2 = string;
            } else {
                str2 = string3;
            }
            return new QuickAuthApp(str2, j162, str4, str3);
        }
        if (string3 == null) {
            str = string;
        } else {
            str = string3;
        }
        return new QuickAuthApp(str, 0L, str4, str3);
    }

    @Override // com.tencent.open.agent.quickauth.j
    /* renamed from: i, reason: from getter */
    public long getMThirdAppId() {
        return this.mThirdAppId;
    }

    @Override // com.tencent.open.agent.quickauth.j
    public void l() {
        com.tencent.open.b.d();
    }

    @Override // com.tencent.open.agent.quickauth.j
    public void m(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        intent.putExtra("key_req_src", 3);
        intent.putExtra("appid", String.valueOf(this.mThirdAppId));
    }
}
