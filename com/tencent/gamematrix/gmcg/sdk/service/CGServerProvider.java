package com.tencent.gamematrix.gmcg.sdk.service;

import com.tencent.gamematrix.gmcg.base.helper.CGPersistHelper;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.base.utils.CGStringUtil;
import com.tencent.gamematrix.gmcg.sdk.config.CGGlbConfig;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class CGServerProvider {
    private static final String DEFAULT_CG_SERVER_HOST = "gamematrix.qq.com";
    private static final String KEY_PERSIST_CG_SERVER_HOST = ".key.persist.cg.server.host";
    private static boolean sConfigUseHttps = true;
    private static String sServerAddress = "gamematrix.qq.com";
    private static Map<Integer, String> sServerHostMap = new HashMap<Integer, String>() { // from class: com.tencent.gamematrix.gmcg.sdk.service.CGServerProvider.1
        {
            put(0, CGServerProvider.DEFAULT_CG_SERVER_HOST);
            put(1, "test.gamematrix.qq.com");
            put(2, "tiyan.gamematrix.qq.com");
            put(3, "new.gamematrix.qq.com");
            put(4, "");
        }
    };
    private static Map<Integer, String> sServerNameMap = new HashMap<Integer, String>() { // from class: com.tencent.gamematrix.gmcg.sdk.service.CGServerProvider.2
        {
            put(0, "prod");
            put(1, "test");
            put(2, "tiyan");
            put(3, "new_prod");
            put(4, "custom");
        }
    };
    private static int sServerType;
    private static volatile UrlAddressDefine sUrlAddressDefineProxy;

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes6.dex */
    public @interface DefPath {
        String value() default "";
    }

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes6.dex */
    public @interface DefUrl {
        String value() default "";
    }

    /* loaded from: classes6.dex */
    public interface UrlAddressDefine {
        @DefPath("/sdk/v2/cloud_game_login?tk=%s")
        String urlOfCloudGameLogin(String str);

        @DefPath("/sdk/v2/collect_log?tk=%s")
        String urlOfCollectLog(String str);

        @DefPath("/sdk/v2/delete_archive?tk=%s")
        String urlOfDeleteUserArchive(String str);

        @DefPath("/sdk/v2/speed_test?tk=%s")
        String urlOfDetectionNet(String str);

        @DefPath("/sdk/v2/debugplatform/fetch_logcat?tk=%s")
        String urlOfFetchLog(String str);

        @DefPath("/sdk/v2/free_device_for_sub_identity?tk=%s")
        String urlOfFreeDeviceForSubAccount(String str);

        @DefPath("/sdk/v1/free_device?tk=%s")
        String urlOfFreeMyDevice(String str);

        @DefPath("/sdk/v2/generate_device_share_code?tk=%s")
        String urlOfGenerateDeviceShareCode(String str);

        @DefPath("/sdk/v2/game_config?tk=%s")
        String urlOfGetGameConfig(String str);

        @DefPath("/sdk/v2/get_tv_mobile_config")
        String urlOfGetLiteInfo();

        @DefPath("/sdk/v2/get_my_device?tk=%s&bussid=%s&identity=%s&deviceid=%s")
        String urlOfGetMyDeviceById(String str, String str2, String str3, String str4);

        @DefPath("/sdk/v2/get_my_device?tk=%s&bussid=%s&identity=%s")
        String urlOfGetMyDevices(String str, String str2, String str3);

        @DefPath("/sdk/v2/get_my_wait_queue?tk=%s&identity=%s")
        String urlOfGetMyWaitQueue(String str, String str2);

        @DefPath("/sdk/v2/get_recommend_tag?tk=%s")
        String urlOfGetRecommendGame(String str);

        @DefPath("/sdk/v2/get_tvgame_info?config_version=V3&&szGameId=%s&tk=%s")
        String urlOfGetTVGameConfig(String str, String str2);

        @DefPath("/sdk/v2/load_archive?tk=%s")
        String urlOfLoadArchive(String str);

        @DefPath("/sdk/v2/pc/cancel_wait_queue?tk=%s")
        String urlOfPcCancelWaitQueue(String str);

        @DefPath("/sdk/v2/pc/create_session?tk=%s")
        String urlOfPcCreateSession(String str);

        @DefPath("/sdk/v2/pc/refresh_session?tk=%s")
        String urlOfPcKeepAliveSession(String str);

        @DefPath("/sdk/v2/pc/query_wait_queue?tk=%s&waitId=%s")
        String urlOfPcQueryWaitQueue(String str, String str2);

        @DefPath("/sdk/v2/pc/stop_game?tk=%s")
        String urlOfPcReleaseSession(String str);

        @DefPath("/sdk/v2/pc/try_lock_worker?tk=%s")
        String urlOfPcTryLockWorker(String str);

        @DefPath("/sdk/v2/query_keepalive_state?tk=%s&bussid=%s&deviceid=%s&identity=%s")
        String urlOfQueryDeviceState(String str, String str2, String str3, String str4);

        @DefPath("/sdk/v2/livestreaming/query?tk=%s")
        String urlOfQueryLiveStreaming(String str);

        @DefPath("/sdk/v2/query_mobile_config?tk=%s")
        String urlOfQueryMobileConfig(String str);

        @DefPath("/sdk/v2/query_network_quality?config_version=V2&tk=%s&client_type=%s&rtt=%s&lostRate=%s&bandwidth=%s&netType=%s")
        String urlOfQueryNetworkQuality(String str, String str2, String str3, String str4, String str5, String str6);

        @DefPath("/sdk/v2/query_saturation?tk=%s")
        String urlOfQuerySaturation(String str);

        @DefPath("/sdk/v2/device_proxy/generate_code?tk=%s")
        String urlOfQueryVirtualGamepadToken(String str);

        @DefPath("/sdk/v2/remove_sub_identity?tk=%s")
        String urlOfRemoveDeviceForSubAccount(String str);

        @DefPath("/sdk/v1/alloc_device?tk=%s")
        String urlOfSdkAllocateDevice(String str);

        @DefPath("/sdk/v2/alloc_device_by_share_code?tk=%s")
        String urlOfSdkAllocateDeviceByShareCode(String str);

        @DefPath("/sdk/endgame/alloc_device?tk=%s")
        String urlOfSdkAllocateDeviceEndGame(String str);

        @DefPath("/cgapi/v4/gamer/alloc_device?tk=%s")
        String urlOfSdkAllocateDeviceForDebug(String str);

        @DefPath("/sdk/v2/alloc_device?tk=%s")
        String urlOfSdkAllocateDeviceV2(String str);

        @DefPath("/sdk/v1/auto_login?tk=%s")
        String urlOfSdkAutoLogin(String str);

        @DefPath("/sdk/v1/cancel_waiting_queue?tk=%s&waitid=%s")
        String urlOfSdkCancelWaitingQueue(String str, String str2);

        @DefPath("/sdk/v1/auth?tk=%s")
        String urlOfSdkCheckAuthValid(String str);

        @DefPath("/sdk/v1/get_gateway?tk=%s")
        String urlOfSdkGatewayAddress(String str);

        @DefPath("/sdk/v2/get_gateway?tk=%s")
        String urlOfSdkGatewayAddressV2(String str);

        @DefPath("/sdk/v1/init")
        String urlOfSdkInitAndAuth();

        @DefPath("/sdk/v2/query_cold_start_device?tk=%s")
        String urlOfSdkQueryColdStartDeviceV2(String str);

        @DefPath("/sdk/v1/query_waiting_queue?tk=%s&waitid=%s")
        String urlOfSdkQueryWaitingQueue(String str, String str2);

        @DefPath("/sdk/v2/datachannel?tk=%s")
        String urlOfSendDataChannel(String str);

        @DefPath("/sdk/v2/mpay?tk=%s")
        String urlOfSendMidasPayResult(String str);

        @DefPath("/sdk/v2/set_bot_device_mode?tk=%s")
        String urlOfSetBotDeviceMode(String str);

        @DefPath("/sdk/v2/set_resolution?tk=%s")
        String urlOfSetCloudGameResolution(String str);

        @DefPath("/sdk/v2/set_midas_prop?tk=%s")
        String urlOfSetMidasProp(String str);

        @DefPath("/sdk/v2/set_user_device_info?tk=%s")
        String urlOfSetUserDeviceInfo(String str);

        @DefPath("/sdk/v2/set_device/merge?tk=%s")
        String urlOfStartLaunchCloudGameInMerge(String str);

        @DefPath("/sdk/v2/livestreaming/start?tk=%s")
        String urlOfStartLiveStreaming(String str);

        @DefPath("/sdk/v2/livestreaming/start_stream_pod?tk=%s")
        String urlOfStartLiveStreamingPod(String str);

        @DefPath("/sdk/v2/livestreaming/stop?tk=%s")
        String urlOfStopLiveStreaming(String str);

        @DefUrl("%s?device_id=%s")
        String urlOfWebRtcSignalingServer(String str, String str2);

        @DefPath("/sdk/v2/yyb/login?tk=%s")
        String urlOfYybCloudGameLogin(String str);
    }

    static /* synthetic */ String access$000() {
        return getScheme();
    }

    private static UrlAddressDefine createAddressDefineProxy() {
        return (UrlAddressDefine) Proxy.newProxyInstance(UrlAddressDefine.class.getClassLoader(), new Class[]{UrlAddressDefine.class}, new InvocationHandler() { // from class: com.tencent.gamematrix.gmcg.sdk.service.CGServerProvider.3
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object... objArr) throws Throwable {
                if (method.getDeclaringClass() == Object.class) {
                    return method.invoke(this, objArr);
                }
                StringBuilder sb5 = new StringBuilder("");
                for (Annotation annotation : method.getAnnotations()) {
                    if (annotation instanceof DefUrl) {
                        sb5.append(CGServerProvider.access$000());
                        sb5.append(String.format(((DefUrl) annotation).value(), objArr));
                    } else if (annotation instanceof DefPath) {
                        sb5.append(CGServerProvider.access$000());
                        sb5.append(CGServerProvider.getServerHost());
                        sb5.append(String.format(((DefPath) annotation).value(), objArr));
                    }
                }
                return sb5.toString();
            }
        });
    }

    public static UrlAddressDefine get() {
        if (sUrlAddressDefineProxy == null) {
            synchronized (CGServerProvider.class) {
                if (sUrlAddressDefineProxy == null) {
                    sUrlAddressDefineProxy = createAddressDefineProxy();
                }
            }
        }
        return sUrlAddressDefineProxy;
    }

    private static String getScheme() {
        if (sConfigUseHttps) {
            return "https://";
        }
        return "http://";
    }

    public static String getServerHost() {
        if (CGStringUtil.isEmpty(sServerAddress)) {
            sServerAddress = CGPersistHelper.getKVasString(KEY_PERSIST_CG_SERVER_HOST, DEFAULT_CG_SERVER_HOST);
        }
        return sServerAddress;
    }

    public static String getServerName() {
        return sServerNameMap.get(Integer.valueOf(sServerType));
    }

    public static String getServerScheme() {
        return getScheme();
    }

    public static int getServerType() {
        return sServerType;
    }

    public static void init(int i3, boolean z16) {
        CGLog.i("CGServerProvider init: " + i3 + "|" + z16);
        sServerType = i3;
        sConfigUseHttps = z16;
        String str = sServerHostMap.get(Integer.valueOf(i3));
        if (CGGlbConfig.hasServerMapping() && CGGlbConfig.getServerMapping().containsKey(str)) {
            setServerHost(CGGlbConfig.getServerMapping().get(str));
        } else {
            setServerHost(str);
        }
    }

    public static void initWithCustomServer(String str, boolean z16) {
        CGLog.i("CGServerProvider initWithCustomServer: " + str + "|" + z16);
        sServerType = 4;
        sConfigUseHttps = z16;
        setServerHost(str);
    }

    private static void setServerHost(String str) {
        CGLog.i("CGServerProvider setServerHost: " + str);
        sServerAddress = str;
        CGPersistHelper.putKVasString(KEY_PERSIST_CG_SERVER_HOST, str);
    }
}
