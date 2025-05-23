package com.tencent.mobileqq.wechatguildreport.api.src;

import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import com.tencent.biz.qui.noticebar.QUINoticeBarManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gdtad.util.SsoReporter;
import com.tencent.hippy.qq.view.tkd.listview.ResourceUtil;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi;
import com.tencent.mobileqq.wxapi.IWXAuthApi;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelSettingListener;
import com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.PrivacySetting;
import com.tencent.qqnt.kernel.nativeinterface.SettingKeyForStr;
import com.tencent.qqnt.kernel.nativeinterface.bp;
import com.tencent.util.QQToastUtil;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.vip.pb.TianShuAccess;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.GlobalScope;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010%\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 Z2\u00020\u0001:\u0001[B\u0007\u00a2\u0006\u0004\bX\u0010YJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0014\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\rH\u0002J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J\u001e\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u00122\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u000bH\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J \u0010!\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u000bH\u0002J\u0006\u0010\"\u001a\u00020\u0004J\b\u0010#\u001a\u00020\u0019H\u0016J\b\u0010$\u001a\u00020\u0004H\u0016J\u0012\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010)\u001a\u00020\u000bH\u0016J\b\u0010*\u001a\u00020\u000bH\u0016J\u0010\u0010+\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010,\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010-\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010+\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010/\u001a\u00020.H\u0016J\u0010\u00100\u001a\u00020.2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u00101\u001a\u00020\u0004H\u0016J\b\u00102\u001a\u00020\u0004H\u0016J\u0018\u00103\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u001c\u00107\u001a\u0004\u0018\u0001062\u0006\u0010\u001d\u001a\u00020\u001c2\b\u00105\u001a\u0004\u0018\u000104H\u0016J\b\u00108\u001a\u00020\u000bH\u0016J \u0010:\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u00109\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u000bH\u0016J \u0010;\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u00109\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u000bH\u0016J\u0010\u0010>\u001a\u00020\u00192\u0006\u0010=\u001a\u00020<H\u0016J\u0010\u0010@\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\u0019H\u0016R\u001a\u0010A\u001a\u00020\t8\u0006X\u0086D\u00a2\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u0016\u0010E\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010G\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\"\u0010J\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020%0I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\"\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020%0I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010KR\"\u0010M\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020.0I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010KR\"\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020.0I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010KR\u0016\u0010O\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010HR\u0016\u0010P\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010BR\u0016\u0010Q\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010BR\"\u0010R\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020<0I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010KR\u0016\u0010?\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010FR\u0016\u0010S\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0014\u0010V\u001a\u00020U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bV\u0010W\u00a8\u0006\\"}, d2 = {"Lcom/tencent/mobileqq/wechatguildreport/api/src/WechatGuildManager;", "Lcom/tencent/mobileqq/wechatguildreport/api/IWeChatGuildApi;", "Lcom/tencent/mobileqq/app/QQAppInterface;", "appRuntime", "", "loadLocalTime", "saveLocalTime", "Lcom/tencent/mobileqq/wechatguildreport/api/IWeChatGuildApi$BIZ_TYPE_WX;", "type", "", "keyOfBizType", "", "isAdsNeedRequest", "Ljava/util/HashMap;", WadlProxyConsts.EXTRA_DATA, "", "Lcom/tencent/mobileqq/tianshu/data/TianShuAdPosItemData;", "getTianShuRequestList", "", "getConfigLstData", "isClick", "reportBase", "clearCaches", "registerKernelSettingService", "destroyKernelSettingServiceRegister", "", "result", "onRespCompletion", "Landroid/content/Context;", "context", "isWeChatInstalled", "msg", "tipsShowAtTopActivity", "showMsg", "initData", "getWeChatAgentReportFlag", "requestTianshuConfig", "Lcooperation/vip/pb/TianShuAccess$AdPlacementInfo;", "getConfig", "Lcom/tencent/mobileqq/wechatguildreport/api/IWeChatGuildApi$a;", "getConfigData", "isWeChatMsgAgentFlagSuc", "isWeChatMsgAgentOpen", "report", "reportClik", "reportClose", "", "time", "getLastTime", "requestTianshuConfigIfNeeds", QCircleLpReportDc05507.KEY_CLEAR, "openWeChatMiniApp", "Landroid/view/View$OnClickListener;", "closeClickListener", "Landroid/view/View;", "getQZoneWechatGuildNoticeBar", "isShowWechatGuildSettingItemRedDot", WadlProxyConsts.KEY_JUMP_URL, "handleUrl", "openWechat", "Lcom/tencent/mobileqq/wechatguildreport/api/IWeChatGuildApi$b;", "listener", "addListener", "listenerId", "removeListener", "TAG", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "weChatAgentOpen", "I", "weChatMsgAgentFlagSuc", "Z", "", "adsMap", "Ljava/util/Map;", "adsReportMap", "adsNextRequstTimeMap", "adsOperateTimeMap", "requestFlag", "WeChatGuildTimeLocalKey", "C2CAIOTypeKey", "listenerMap", "kernelSettingListenerId", "J", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelSettingListener;", "kernelSettingListener", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelSettingListener;", "<init>", "()V", "Companion", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class WechatGuildManager implements IWeChatGuildApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final WechatGuildManager instance;
    private int listenerId;
    private boolean requestFlag;
    private boolean weChatMsgAgentFlagSuc;
    private final String TAG = "WechatGuildManager";
    private int weChatAgentOpen = -1;
    private Map<IWeChatGuildApi.BIZ_TYPE_WX, TianShuAccess.AdPlacementInfo> adsMap = new LinkedHashMap();
    private Map<IWeChatGuildApi.BIZ_TYPE_WX, TianShuAccess.AdPlacementInfo> adsReportMap = new LinkedHashMap();
    private Map<IWeChatGuildApi.BIZ_TYPE_WX, Long> adsNextRequstTimeMap = new LinkedHashMap();
    private Map<IWeChatGuildApi.BIZ_TYPE_WX, Long> adsOperateTimeMap = new LinkedHashMap();
    private String WeChatGuildTimeLocalKey = "WeChatGuildTimeLocalKey";
    private String C2CAIOTypeKey = "type";
    private Map<Integer, IWeChatGuildApi.b> listenerMap = new LinkedHashMap();
    private long kernelSettingListenerId = -1;
    private final IKernelSettingListener kernelSettingListener = new IKernelSettingListener() { // from class: com.tencent.mobileqq.wechatguildreport.api.src.WechatGuildManager$kernelSettingListener$1
        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingListener
        public /* synthetic */ void onBufferSettingChanged(HashMap hashMap) {
            bp.a(this, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingListener
        public /* synthetic */ void onCleanCacheProgressChanged(int i3, int i16) {
            bp.b(this, i3, i16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingListener
        public /* synthetic */ void onNumSettingChanged(HashMap hashMap) {
            bp.c(this, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingListener
        public /* synthetic */ void onPrivacySettingChanged(PrivacySetting privacySetting) {
            bp.d(this, privacySetting);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingListener
        public void onStrSettingChanged(HashMap<SettingKeyForStr, String> setting) {
            Intrinsics.checkNotNullParameter(setting, "setting");
            SettingKeyForStr settingKeyForStr = SettingKeyForStr.KWXMSGNOTIFYINFO;
            if (setting.containsKey(settingKeyForStr)) {
                QLog.d(WechatGuildManager.this.getTAG(), 1, "kernelSettingService container wxInfo");
                String str = setting.get(settingKeyForStr);
                if (str != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        final int i3 = jSONObject.has("status") ? jSONObject.getInt("status") : 0;
                        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                        final WechatGuildManager wechatGuildManager = WechatGuildManager.this;
                        uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.wechatguildreport.api.src.WechatGuildManager$kernelSettingListener$1$onStrSettingChanged$$inlined$Runnable$1
                            @Override // java.lang.Runnable
                            public final void run() {
                                int i16;
                                int i17;
                                int i18;
                                boolean z16;
                                i16 = WechatGuildManager.this.weChatAgentOpen;
                                int i19 = i3;
                                if (i16 != i19 && i19 != 1) {
                                    WechatGuildManager.this.requestFlag = false;
                                }
                                WechatGuildManager.this.weChatAgentOpen = i3;
                                WechatGuildManager.this.weChatMsgAgentFlagSuc = true;
                                i17 = WechatGuildManager.this.weChatAgentOpen;
                                if (i17 != 1) {
                                    z16 = WechatGuildManager.this.requestFlag;
                                    if (!z16) {
                                        WechatGuildManager.this.requestFlag = true;
                                        WechatGuildManager.this.requestTianshuConfig();
                                        return;
                                    }
                                }
                                i18 = WechatGuildManager.this.weChatAgentOpen;
                                if (i18 == 1) {
                                    WechatGuildManager.this.clearCaches();
                                }
                            }
                        });
                    } catch (Exception e16) {
                        QLog.d(WechatGuildManager.this.getTAG(), 1, "WeChatMsgAgent kernelSettingService onStrSettingChanged, json fail " + e16);
                    }
                }
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingListener
        public /* synthetic */ void onVerifyInfoChange(int i3) {
            bp.f(this, i3);
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/wechatguildreport/api/src/WechatGuildManager$a;", "", "Lcom/tencent/mobileqq/wechatguildreport/api/src/WechatGuildManager;", "a", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Lcom/tencent/mobileqq/wechatguildreport/api/src/WechatGuildManager;", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wechatguildreport.api.src.WechatGuildManager$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WechatGuildManager a() {
            return WechatGuildManager.instance;
        }

        Companion() {
        }
    }

    static {
        WechatGuildManager wechatGuildManager = new WechatGuildManager();
        wechatGuildManager.initData();
        instance = wechatGuildManager;
    }

    private final QQAppInterface appRuntime() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        return (QQAppInterface) peekAppRuntime;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearCaches() {
        saveLocalTime();
        this.adsMap.clear();
        this.adsReportMap.clear();
        this.adsOperateTimeMap.clear();
        this.weChatMsgAgentFlagSuc = false;
        this.weChatAgentOpen = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void destroyKernelSettingServiceRegister() {
        IKernelService iKernelService;
        QQAppInterface appRuntime = appRuntime();
        IKernelSettingService settingService = (appRuntime == null || (iKernelService = (IKernelService) appRuntime.getRuntimeService(IKernelService.class, "")) == null) ? null : iKernelService.getSettingService();
        if (settingService == null) {
            QLog.d(this.TAG, 1, "kernelSettingService unregister, settingService is null");
            return;
        }
        settingService.removeKernelSettingListener(this.kernelSettingListenerId);
        this.kernelSettingListenerId = 0L;
        QLog.d(this.TAG, 1, "kernelSettingService unregister sucess");
    }

    private final HashMap<String, String> extraData() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("msg_helper_status", String.valueOf(getWeChatAgentReportFlag()));
        return hashMap;
    }

    private final Map<String, String> getConfigLstData(IWeChatGuildApi.BIZ_TYPE_WX type) {
        List<TianShuAccess.AdItem> list;
        Object firstOrNull;
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        TianShuAccess.AdPlacementInfo config = getConfig(type);
        if (config == null || (list = config.lst.get()) == null) {
            return null;
        }
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
        TianShuAccess.AdItem adItem = (TianShuAccess.AdItem) firstOrNull;
        if (adItem == null) {
            return null;
        }
        List<TianShuAccess.MapEntry> list2 = adItem.argList.get();
        Intrinsics.checkNotNullExpressionValue(list2, "adItem.argList.get()");
        List<TianShuAccess.MapEntry> list3 = list2;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (TianShuAccess.MapEntry mapEntry : list3) {
            Pair pair = TuplesKt.to(mapEntry.key.get(), mapEntry.value.get());
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getQZoneWechatGuildNoticeBar$lambda$18(WechatGuildManager this$0, Context context, String jumpUrl, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(jumpUrl, "$jumpUrl");
        this$0.reportClik(IWeChatGuildApi.BIZ_TYPE_WX.QZONE);
        this$0.handleUrl(context, jumpUrl, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getQZoneWechatGuildNoticeBar$lambda$19(WechatGuildManager this$0, View.OnClickListener onClickListener, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.reportClose(IWeChatGuildApi.BIZ_TYPE_WX.QZONE);
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getQZoneWechatGuildNoticeBar$lambda$20(WechatGuildManager this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.report(IWeChatGuildApi.BIZ_TYPE_WX.QZONE);
    }

    private final List<TianShuAdPosItemData> getTianShuRequestList() {
        ArrayList arrayList = new ArrayList();
        QLog.d(this.TAG, 1, "WeChatMsgAgent saveTian request time: code: " + this.adsNextRequstTimeMap);
        IWeChatGuildApi.BIZ_TYPE_WX biz_type_wx = IWeChatGuildApi.BIZ_TYPE_WX.RECENT;
        if (isAdsNeedRequest(biz_type_wx)) {
            TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
            tianShuAdPosItemData.mNeedCnt = 1;
            tianShuAdPosItemData.mPosId = biz_type_wx.getValue();
            tianShuAdPosItemData.mExtraData = extraData();
            arrayList.add(tianShuAdPosItemData);
        }
        IWeChatGuildApi.BIZ_TYPE_WX biz_type_wx2 = IWeChatGuildApi.BIZ_TYPE_WX.C2CAIO;
        if (isAdsNeedRequest(biz_type_wx2)) {
            TianShuAdPosItemData tianShuAdPosItemData2 = new TianShuAdPosItemData();
            tianShuAdPosItemData2.mNeedCnt = 2;
            tianShuAdPosItemData2.mPosId = biz_type_wx2.getValue();
            tianShuAdPosItemData2.mExtraData = extraData();
            arrayList.add(tianShuAdPosItemData2);
        }
        IWeChatGuildApi.BIZ_TYPE_WX biz_type_wx3 = IWeChatGuildApi.BIZ_TYPE_WX.GROUPAIO;
        if (isAdsNeedRequest(biz_type_wx3)) {
            TianShuAdPosItemData tianShuAdPosItemData3 = new TianShuAdPosItemData();
            tianShuAdPosItemData3.mNeedCnt = 1;
            tianShuAdPosItemData3.mPosId = biz_type_wx3.getValue();
            tianShuAdPosItemData3.mExtraData = extraData();
            arrayList.add(tianShuAdPosItemData3);
        }
        IWeChatGuildApi.BIZ_TYPE_WX biz_type_wx4 = IWeChatGuildApi.BIZ_TYPE_WX.QZONE;
        if (isAdsNeedRequest(biz_type_wx4)) {
            TianShuAdPosItemData tianShuAdPosItemData4 = new TianShuAdPosItemData();
            tianShuAdPosItemData4.mNeedCnt = 1;
            tianShuAdPosItemData4.mPosId = biz_type_wx4.getValue();
            tianShuAdPosItemData4.mExtraData = extraData();
            arrayList.add(tianShuAdPosItemData4);
        }
        IWeChatGuildApi.BIZ_TYPE_WX biz_type_wx5 = IWeChatGuildApi.BIZ_TYPE_WX.SETTING;
        if (isAdsNeedRequest(biz_type_wx5)) {
            TianShuAdPosItemData tianShuAdPosItemData5 = new TianShuAdPosItemData();
            tianShuAdPosItemData5.mNeedCnt = 1;
            tianShuAdPosItemData5.mPosId = biz_type_wx5.getValue();
            tianShuAdPosItemData5.mExtraData = extraData();
            arrayList.add(tianShuAdPosItemData5);
        }
        return arrayList;
    }

    private final boolean isAdsNeedRequest(IWeChatGuildApi.BIZ_TYPE_WX type) {
        Long l3 = this.adsNextRequstTimeMap.get(type);
        if (l3 == null) {
            return true;
        }
        if (((int) l3.longValue()) == 0) {
            return true;
        }
        return l3.longValue() <= System.currentTimeMillis();
    }

    private final boolean isWeChatInstalled(Context context) {
        try {
            InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), "com.tencent.mm", 1);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    private final String keyOfBizType(IWeChatGuildApi.BIZ_TYPE_WX type) {
        return "IWeChatGuildApi" + type.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadLocalTime() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        if (from.isAccessible()) {
            Long valueOf = Long.valueOf(from.decodeLong(this.WeChatGuildTimeLocalKey, 0L));
            Map<IWeChatGuildApi.BIZ_TYPE_WX, Long> map = this.adsOperateTimeMap;
            IWeChatGuildApi.BIZ_TYPE_WX biz_type_wx = IWeChatGuildApi.BIZ_TYPE_WX.C2CAIO;
            map.put(biz_type_wx, valueOf);
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(biz_type_wx.getValue()));
            arrayList.add(Integer.valueOf(IWeChatGuildApi.BIZ_TYPE_WX.GROUPAIO.getValue()));
            arrayList.add(Integer.valueOf(IWeChatGuildApi.BIZ_TYPE_WX.SETTING.getValue()));
            arrayList.add(Integer.valueOf(IWeChatGuildApi.BIZ_TYPE_WX.QZONE.getValue()));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = ((Number) it.next()).intValue();
                IWeChatGuildApi.BIZ_TYPE_WX.Companion companion = IWeChatGuildApi.BIZ_TYPE_WX.INSTANCE;
                this.adsNextRequstTimeMap.put(companion.a(intValue), Long.valueOf(from.decodeLong(keyOfBizType(companion.a(intValue)), 0L)));
            }
            QLog.d(this.TAG, 1, "WeChatMsgAgent loadTian request time: code: " + this.adsNextRequstTimeMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onRespCompletion(int result) {
        for (Map.Entry<Integer, IWeChatGuildApi.b> entry : this.listenerMap.entrySet()) {
            if (entry.getValue() != null) {
                entry.getValue().a(result, this.adsMap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerKernelSettingService() {
        IKernelService iKernelService;
        QQAppInterface appRuntime = appRuntime();
        IKernelSettingService settingService = (appRuntime == null || (iKernelService = (IKernelService) appRuntime.getRuntimeService(IKernelService.class, "")) == null) ? null : iKernelService.getSettingService();
        if (settingService == null) {
            QLog.d(this.TAG, 1, "kernelSettingService register, settingService is null");
            return;
        }
        long addKernelSettingListener = settingService.addKernelSettingListener(this.kernelSettingListener);
        this.kernelSettingListenerId = addKernelSettingListener;
        QLog.d(this.TAG, 1, "kernelSettingService register suc id" + addKernelSettingListener);
        ArrayList<SettingKeyForStr> arrayList = new ArrayList<>();
        arrayList.add(SettingKeyForStr.KWXMSGNOTIFYINFO);
        settingService.getSettingForStr(arrayList, new IOperateCallback() { // from class: com.tencent.mobileqq.wechatguildreport.api.src.h
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                WechatGuildManager.registerKernelSettingService$lambda$17(WechatGuildManager.this, i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerKernelSettingService$lambda$17(WechatGuildManager this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d(this$0.TAG, 1, "kernelSettingService, result: ", Integer.valueOf(i3), " errMsg: ", str);
    }

    private final void reportBase(IWeChatGuildApi.BIZ_TYPE_WX type, boolean isClick) {
        TianShuAccess.AdPlacementInfo adPlacementInfo = this.adsMap.get(type);
        if (adPlacementInfo == null) {
            adPlacementInfo = this.adsReportMap.get(type);
        }
        if ((adPlacementInfo != null ? adPlacementInfo.lst : null) == null || adPlacementInfo.lst.size() <= 0) {
            return;
        }
        TianShuAccess.AdItem adItem = adPlacementInfo.lst.get(0);
        Intrinsics.checkNotNullExpressionValue(adItem, "infos.lst.get(0)");
        TianShuAccess.AdItem adItem2 = adItem;
        int i3 = adItem2.iAdId.get();
        String str = adItem2.traceinfo.get();
        int value = type.getValue();
        if (value == IWeChatGuildApi.BIZ_TYPE_WX.C2CAIOREC.getValue() || value == IWeChatGuildApi.BIZ_TYPE_WX.C2CAIOSEND.getValue()) {
            value = IWeChatGuildApi.BIZ_TYPE_WX.C2CAIO.getValue();
        }
        TianShuReportData tianShuReportData = new TianShuReportData();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String account = peekAppRuntime != null ? peekAppRuntime.getAccount() : null;
        if (account == null) {
            return;
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() / 1000;
        tianShuReportData.mAppId = "tianshu.324";
        tianShuReportData.mPageId = "tianshu.324";
        tianShuReportData.mTraceId = account + "_" + serverTimeMillis;
        tianShuReportData.mTraceNum = 1;
        tianShuReportData.mItemId = String.valueOf(i3);
        tianShuReportData.mSubItemId = "";
        tianShuReportData.mOperTime = serverTimeMillis;
        if (isClick) {
            tianShuReportData.mActionId = 102;
        } else {
            tianShuReportData.mActionId = 101;
        }
        tianShuReportData.mPositionId = String.valueOf(value);
        tianShuReportData.mActionValue = 1;
        tianShuReportData.mActionAttr = 1;
        tianShuReportData.mTriggerInfo = str;
        ((ITianshuManager) QRoute.api(ITianshuManager.class)).report(tianShuReportData);
        QLog.d(this.TAG, 1, "WeChatMsgAgent report info " + tianShuReportData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestTianshuConfig$lambda$13(final WechatGuildManager this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((ITianshuManager) QRoute.api(ITianshuManager.class)).requestAdv(this$0.getTianShuRequestList(), new TianShuGetAdvCallback() { // from class: com.tencent.mobileqq.wechatguildreport.api.src.g
            @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
            public final void onGetAdvs(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
                WechatGuildManager.requestTianshuConfig$lambda$13$lambda$12(WechatGuildManager.this, z16, getAdsRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestTianshuConfig$lambda$13$lambda$12(final WechatGuildManager this$0, boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d(this$0.TAG, 1, "WeChatMsgAgent loadTianShuConfig: code: " + getAdsRsp.code.get() + ", size: " + getAdsRsp.mapAds.size());
        if (getAdsRsp.code.get() != 0 || getAdsRsp.mapAds.isEmpty()) {
            return;
        }
        List<TianShuAccess.RspEntry> ads = getAdsRsp.mapAds.get();
        Intrinsics.checkNotNullExpressionValue(ads, "ads");
        for (final TianShuAccess.RspEntry rspEntry : ads) {
            final TianShuAccess.AdPlacementInfo adPlacementInfo = rspEntry.value.get();
            PBRepeatMessageField<TianShuAccess.AdItem> pBRepeatMessageField = adPlacementInfo.lst;
            if (pBRepeatMessageField != null && pBRepeatMessageField.size() > 0) {
                TianShuAccess.AdItem adItem = adPlacementInfo.lst.get(0);
                Intrinsics.checkNotNullExpressionValue(adItem, "infos.lst.get(0)");
                TianShuAccess.AdItem adItem2 = adItem;
                final JSONObject jSONObject = new JSONObject();
                jSONObject.put(SsoReporter.POS_ID_KEY, rspEntry.key.get());
                jSONObject.put("ad_id", adItem2.iAdId.get());
                jSONObject.put("trace_info", adItem2.traceinfo.get());
                jSONObject.put("next_query_ts", adPlacementInfo.next_query_ts.get());
                List<TianShuAccess.MapEntry> list = adItem2.argList.get();
                Intrinsics.checkNotNullExpressionValue(list, "adItem.argList.get()");
                for (TianShuAccess.MapEntry mapEntry : list) {
                    jSONObject.put(mapEntry.key.get(), mapEntry.value.get());
                }
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wechatguildreport.api.src.WechatGuildManager$requestTianshuConfig$lambda$13$lambda$12$lambda$10$$inlined$Runnable$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        Map map;
                        Map map2;
                        Map map3;
                        String str;
                        String str2;
                        String str3;
                        IWeChatGuildApi.BIZ_TYPE_WX a16 = IWeChatGuildApi.BIZ_TYPE_WX.INSTANCE.a(TianShuAccess.RspEntry.this.key.get());
                        map = this$0.adsNextRequstTimeMap;
                        map.put(a16, Long.valueOf(adPlacementInfo.next_query_ts.get()));
                        if (TianShuAccess.RspEntry.this.key.get() == IWeChatGuildApi.BIZ_TYPE_WX.C2CAIO.getValue()) {
                            JSONObject jSONObject2 = jSONObject;
                            str = this$0.C2CAIOTypeKey;
                            if (jSONObject2.has(str)) {
                                JSONObject jSONObject3 = jSONObject;
                                str2 = this$0.C2CAIOTypeKey;
                                if (jSONObject3.getInt(str2) == 1) {
                                    a16 = IWeChatGuildApi.BIZ_TYPE_WX.C2CAIOREC;
                                } else {
                                    JSONObject jSONObject4 = jSONObject;
                                    str3 = this$0.C2CAIOTypeKey;
                                    if (jSONObject4.getInt(str3) == 2) {
                                        a16 = IWeChatGuildApi.BIZ_TYPE_WX.C2CAIOSEND;
                                    }
                                }
                            }
                        }
                        map2 = this$0.adsMap;
                        TianShuAccess.AdPlacementInfo infos = adPlacementInfo;
                        Intrinsics.checkNotNullExpressionValue(infos, "infos");
                        map2.put(a16, adPlacementInfo);
                        map3 = this$0.adsReportMap;
                        TianShuAccess.AdPlacementInfo infos2 = adPlacementInfo;
                        Intrinsics.checkNotNullExpressionValue(infos2, "infos");
                        map3.put(a16, adPlacementInfo);
                    }
                });
                QLog.d(this$0.TAG, 1, "WeChatMsgAgent adsResult " + jSONObject);
            }
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wechatguildreport.api.src.WechatGuildManager$requestTianshuConfig$lambda$13$lambda$12$$inlined$Runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                WechatGuildManager.this.onRespCompletion(0);
            }
        });
    }

    private final void saveLocalTime() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        if (from.isAccessible()) {
            Long l3 = this.adsOperateTimeMap.get(IWeChatGuildApi.BIZ_TYPE_WX.C2CAIO);
            from.encodeLong(this.WeChatGuildTimeLocalKey, l3 != null ? l3.longValue() : 0L);
            for (Map.Entry<IWeChatGuildApi.BIZ_TYPE_WX, Long> entry : this.adsNextRequstTimeMap.entrySet()) {
                from.encodeLong(keyOfBizType(entry.getKey()), entry.getValue().longValue());
            }
            QLog.d(this.TAG, 1, "WeChatMsgAgent saveTian request time: code: " + this.adsNextRequstTimeMap);
        }
    }

    private final void showMsg(final Context context, final String msg2, final boolean tipsShowAtTopActivity) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wechatguildreport.api.src.b
            @Override // java.lang.Runnable
            public final void run() {
                WechatGuildManager.showMsg$lambda$23(tipsShowAtTopActivity, context, msg2, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showMsg$lambda$23(boolean z16, Context context, final String msg2, final WechatGuildManager this$0) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            context = BaseActivity.sTopActivity;
        }
        DialogUtil.createCustomDialog(context, 230, "", msg2, (String) null, ResourceUtil.getString(R.string.f185793pj), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wechatguildreport.api.src.i
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                WechatGuildManager.showMsg$lambda$23$lambda$22(WechatGuildManager.this, msg2, dialogInterface, i3);
            }
        }, (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showMsg$lambda$23$lambda$22(WechatGuildManager this$0, String msg2, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        QLog.e(this$0.TAG, 2, "[showToast]: " + msg2 + " \u7528\u6237\u70b9\u51fb\u786e\u5b9a");
    }

    @Override // com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi
    public int addListener(IWeChatGuildApi.b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        int i3 = this.listenerId + 1;
        this.listenerId = i3;
        this.listenerMap.put(Integer.valueOf(i3), listener);
        return this.listenerId;
    }

    @Override // com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi
    public TianShuAccess.AdPlacementInfo getConfig(IWeChatGuildApi.BIZ_TYPE_WX type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return this.adsMap.get(type);
    }

    @Override // com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi
    public long getLastTime(IWeChatGuildApi.BIZ_TYPE_WX type) {
        Intrinsics.checkNotNullParameter(type, "type");
        Long l3 = this.adsOperateTimeMap.get(type);
        if (l3 != null) {
            return l3.longValue();
        }
        return 0L;
    }

    @Override // com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi
    public View getQZoneWechatGuildNoticeBar(final Context context, final View.OnClickListener closeClickListener) {
        Map<String, String> configLstData;
        Intrinsics.checkNotNullParameter(context, "context");
        if (isWeChatMsgAgentOpen() || (configLstData = getConfigLstData(IWeChatGuildApi.BIZ_TYPE_WX.QZONE)) == null || configLstData.isEmpty()) {
            return null;
        }
        String str = configLstData.get("icon_url");
        if (str == null) {
            str = "";
        }
        String str2 = configLstData.get("text");
        if (str2 == null) {
            str2 = "";
        }
        String str3 = configLstData.get(QZoneAdTianshuFeedData.KEY_BUTTON_TEXT);
        if (str3 == null) {
            str3 = "";
        }
        String str4 = configLstData.get("jump_url");
        final String str5 = str4 != null ? str4 : "";
        com.tencent.biz.qui.noticebar.d h16 = QUINoticeBarManager.INSTANCE.a().h(context);
        if (str.length() > 0) {
            URLDrawable drawable = URLDrawable.getDrawable(str, URLDrawable.URLDrawableOptions.obtain());
            Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(iconUrl, URLDrawableOptions.obtain())");
            h16.setIcon(drawable);
        }
        if (str2.length() > 0) {
            h16.setMsg(str2);
        }
        h16.b(str3, new View.OnClickListener() { // from class: com.tencent.mobileqq.wechatguildreport.api.src.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WechatGuildManager.getQZoneWechatGuildNoticeBar$lambda$18(WechatGuildManager.this, context, str5, view);
            }
        });
        h16.k(new View.OnClickListener() { // from class: com.tencent.mobileqq.wechatguildreport.api.src.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WechatGuildManager.getQZoneWechatGuildNoticeBar$lambda$19(WechatGuildManager.this, closeClickListener, view);
            }
        });
        View view = h16.getView();
        view.post(new Runnable() { // from class: com.tencent.mobileqq.wechatguildreport.api.src.e
            @Override // java.lang.Runnable
            public final void run() {
                WechatGuildManager.getQZoneWechatGuildNoticeBar$lambda$20(WechatGuildManager.this);
            }
        });
        return view;
    }

    public final String getTAG() {
        return this.TAG;
    }

    @Override // com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi
    public int getWeChatAgentReportFlag() {
        if (!getWeChatMsgAgentFlagSuc()) {
            return 0;
        }
        int i3 = this.weChatAgentOpen;
        return (i3 == 0 || i3 == 2) ? 1 : 0;
    }

    @Override // com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi
    public void handleUrl(Context context, String jumpUrl, boolean tipsShowAtTopActivity) {
        boolean startsWith$default;
        boolean startsWith$default2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        if (TextUtils.isEmpty(jumpUrl)) {
            if (QLog.isColorLevel()) {
                QLog.e(this.TAG, 2, "url empty");
                return;
            }
            return;
        }
        QLog.e(this.TAG, 2, "[handleUrl]: " + jumpUrl);
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        Intrinsics.checkNotNull(runtime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        QQAppInterface qQAppInterface = (QQAppInterface) runtime;
        QRouteApi api = QRoute.api(IMiniAppService.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IMiniAppService::class.java)");
        IMiniAppService iMiniAppService = (IMiniAppService) api;
        if (!iMiniAppService.isMiniAppUrl(jumpUrl)) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(jumpUrl, "mqqapi://", false, 2, null);
            if (!startsWith$default) {
                startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(jumpUrl, "weixin://", false, 2, null);
                if (startsWith$default2) {
                    openWechat(context, jumpUrl, tipsShowAtTopActivity);
                    return;
                }
                Intent intent = new Intent(context, (Class<?>) QQBrowserDelegationActivity.class);
                intent.putExtra("url", jumpUrl);
                if (context instanceof Application) {
                    intent.setFlags(268435456);
                }
                intent.putExtra("startOpenPageTime", System.currentTimeMillis());
                context.startActivity(intent);
                return;
            }
            ax c16 = bi.c(qQAppInterface, context, jumpUrl);
            if (c16 != null) {
                c16.b();
                return;
            }
            return;
        }
        iMiniAppService.startMiniApp(context, jumpUrl, 1124, null);
    }

    public final void initData() {
        loadLocalTime();
        registerKernelSettingService();
    }

    @Override // com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi
    public boolean isShowWechatGuildSettingItemRedDot() {
        Map<String, String> configLstData;
        if (isWeChatMsgAgentOpen() || (configLstData = getConfigLstData(IWeChatGuildApi.BIZ_TYPE_WX.SETTING)) == null) {
            return false;
        }
        String str = configLstData.get("red_type");
        if (str == null) {
            str = "";
        }
        return Intrinsics.areEqual(str, "1");
    }

    @Override // com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi
    /* renamed from: isWeChatMsgAgentFlagSuc, reason: from getter */
    public boolean getWeChatMsgAgentFlagSuc() {
        return this.weChatMsgAgentFlagSuc;
    }

    @Override // com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi
    public boolean isWeChatMsgAgentOpen() {
        return this.weChatAgentOpen == 1;
    }

    @Override // com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi
    public void openWeChatMiniApp(IWeChatGuildApi.BIZ_TYPE_WX type, Context context) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullExpressionValue(((IWXAuthApi) QRoute.api(IWXAuthApi.class)).getWXAppId(), "api<IWXAuthApi>(IWXAuthA\u2026:class.java).getWXAppId()");
        if (!((IWXAuthApi) QRoute.api(IWXAuthApi.class)).isWXAppInstalled()) {
            QQToastUtil.showQQToast(1, R.string.f200514sb);
            return;
        }
        IWeChatGuildApi.a configData = getConfigData(type);
        if (configData != null) {
            Uri parse = Uri.parse(configData.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_JUMP_URL java.lang.String());
            Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
            intent.setData(parse);
            context.startActivity(intent);
        }
    }

    @Override // com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi
    public void openWechat(Context context, String jumpUrl, boolean tipsShowAtTopActivity) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        if (isWeChatInstalled(context)) {
            Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(jumpUrl));
            intent.addFlags(335544320);
            context.startActivity(intent);
            return;
        }
        showMsg(context, "\u4f60\u7684\u8bbe\u5907\u4e0a\u6ca1\u6709\u5b89\u88c5\u5fae\u4fe1\uff0c\u8bf7\u5b89\u88c5\u540e\u91cd\u8bd5", tipsShowAtTopActivity);
    }

    @Override // com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi
    public void removeListener(int listenerId) {
        this.listenerMap.remove(Integer.valueOf(listenerId));
    }

    @Override // com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi
    public void report(IWeChatGuildApi.BIZ_TYPE_WX type) {
        Intrinsics.checkNotNullParameter(type, "type");
        reportBase(type, false);
        if (type != IWeChatGuildApi.BIZ_TYPE_WX.SETTING) {
            this.adsMap.remove(type);
        }
    }

    @Override // com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi
    public void reportClik(IWeChatGuildApi.BIZ_TYPE_WX type) {
        Intrinsics.checkNotNullParameter(type, "type");
        reportBase(type, true);
        this.adsMap.remove(type);
        this.adsReportMap.remove(type);
    }

    @Override // com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi
    public void reportClose(IWeChatGuildApi.BIZ_TYPE_WX type) {
        Intrinsics.checkNotNullParameter(type, "type");
        TianShuAccess.AdPlacementInfo adPlacementInfo = this.adsMap.get(type);
        if (adPlacementInfo == null) {
            adPlacementInfo = this.adsReportMap.get(type);
        }
        if ((adPlacementInfo != null ? adPlacementInfo.lst : null) == null || adPlacementInfo.lst.size() <= 0) {
            return;
        }
        TianShuAccess.AdItem adItem = adPlacementInfo.lst.get(0);
        Intrinsics.checkNotNullExpressionValue(adItem, "infos.lst.get(0)");
        TianShuAccess.AdItem adItem2 = adItem;
        int i3 = adItem2.iAdId.get();
        String str = adItem2.traceinfo.get();
        int value = type.getValue();
        if (value == IWeChatGuildApi.BIZ_TYPE_WX.C2CAIOREC.getValue() || value == IWeChatGuildApi.BIZ_TYPE_WX.C2CAIOSEND.getValue()) {
            value = IWeChatGuildApi.BIZ_TYPE_WX.C2CAIO.getValue();
        }
        TianShuReportData tianShuReportData = new TianShuReportData();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String account = peekAppRuntime != null ? peekAppRuntime.getAccount() : null;
        if (account == null) {
            return;
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() / 1000;
        tianShuReportData.mAppId = "tianshu.324";
        tianShuReportData.mPageId = "3001170";
        tianShuReportData.mTraceId = account + "_" + serverTimeMillis;
        tianShuReportData.mTraceNum = 1;
        tianShuReportData.mItemId = String.valueOf(i3);
        tianShuReportData.mSubItemId = "";
        tianShuReportData.mOperTime = serverTimeMillis;
        tianShuReportData.mActionId = 122;
        tianShuReportData.mPositionId = String.valueOf(value);
        tianShuReportData.mActionValue = 1;
        tianShuReportData.mActionAttr = 1;
        tianShuReportData.mTriggerInfo = str;
        ((ITianshuManager) QRoute.api(ITianshuManager.class)).report(tianShuReportData);
    }

    @Override // com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi
    public void requestTianshuConfig() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wechatguildreport.api.src.f
            @Override // java.lang.Runnable
            public final void run() {
                WechatGuildManager.requestTianshuConfig$lambda$13(WechatGuildManager.this);
            }
        }, 128, null, true);
    }

    @Override // com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi
    public void requestTianshuConfigIfNeeds() {
        if (this.requestFlag) {
            QLog.d(this.TAG, 1, "WeChatMsgAgent request suc content" + this.adsMap);
            QLog.d(this.TAG, 1, "WeChatMsgAgent request suc time" + this.adsNextRequstTimeMap);
            return;
        }
        clearCaches();
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new WechatGuildManager$requestTianshuConfigIfNeeds$1(this, null), 3, null);
    }

    @Override // com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi
    public void clear() {
        this.requestFlag = false;
        this.listenerMap.clear();
        clearCaches();
        destroyKernelSettingServiceRegister();
    }

    @Override // com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi
    public void report(IWeChatGuildApi.BIZ_TYPE_WX type, long time) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.adsOperateTimeMap.put(type, Long.valueOf(time));
    }

    @Override // com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi
    public IWeChatGuildApi.a getConfigData(IWeChatGuildApi.BIZ_TYPE_WX type) {
        Intrinsics.checkNotNullParameter(type, "type");
        TianShuAccess.AdPlacementInfo adPlacementInfo = this.adsMap.get(type);
        a aVar = null;
        if ((adPlacementInfo != null ? adPlacementInfo.lst : null) != null && adPlacementInfo.lst.size() > 0) {
            TianShuAccess.AdItem adItem = adPlacementInfo.lst.get(0);
            Intrinsics.checkNotNullExpressionValue(adItem, "infos.lst.get(0)");
            TianShuAccess.AdItem adItem2 = adItem;
            aVar = new a(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
            aVar.i(type);
            aVar.e(Integer.valueOf(adItem2.iAdId.get()));
            aVar.j(adItem2.title.get());
            aVar.d(adItem2.desc.get());
            aVar.f(adItem2.iconurl.get());
            aVar.h(adItem2.jumpurl.get());
            aVar.k(adItem2.traceinfo.get());
            JSONObject jSONObject = new JSONObject();
            List<TianShuAccess.MapEntry> list = adItem2.argList.get();
            Intrinsics.checkNotNullExpressionValue(list, "adItem.argList.get()");
            for (TianShuAccess.MapEntry mapEntry : list) {
                jSONObject.put(mapEntry.key.get(), mapEntry.value.get());
            }
            if (jSONObject.has(this.C2CAIOTypeKey)) {
                aVar.l(Integer.valueOf(jSONObject.getInt(this.C2CAIOTypeKey)));
            }
            if (jSONObject.has(QZoneAdTianshuFeedData.KEY_BUTTON_TEXT)) {
                aVar.c(jSONObject.getString(QZoneAdTianshuFeedData.KEY_BUTTON_TEXT));
            }
            aVar.g(jSONObject);
        }
        return aVar;
    }
}
