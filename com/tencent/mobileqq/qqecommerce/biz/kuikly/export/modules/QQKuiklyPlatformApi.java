package com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import androidx.collection.ArrayMap;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.hippy.qq.utils.DeviceInfoUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.kuikly.core.render.android.css.ktx.KRCSSViewExtensionKt;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.gamecenter.api.IGameCenterKuiklyApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.jump.api.IJumpApi;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.minispecial.kuikly.IMiniKuiklyApi;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.container.QQKuiklyFragment;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.utils.QQKuiklyCommUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.utils.fh;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\b\u0018\u0000 E2\u00020\u0001:\u0001FB\u0007\u00a2\u0006\u0004\bC\u0010DJI\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000bH\u0016JI\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00062+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000bH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\u0012\u0010\u000f\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0010\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0012\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00132\b\u0010\u0004\u001a\u0004\u0018\u00010\u0006H\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J?\u0010\u0016\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00062+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000bH\u0002J4\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u001d*\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0012\u0010 \u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\"\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010#\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010'\u001a\u00020\n2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u0002H\u0002J\u0018\u0010(\u001a\u00020\n2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u0002H\u0002J\u0012\u0010*\u001a\u00020\u001b2\b\u0010)\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010-\u001a\u00020\u001b2\b\u0010,\u001a\u0004\u0018\u00010+H\u0002J?\u0010.\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000bH\u0002J?\u0010/\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000bH\u0002J?\u00100\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000bH\u0002J\b\u00101\u001a\u00020\u0002H\u0002J\b\u00102\u001a\u00020\u0002H\u0002J\u0012\u00103\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J5\u00104\u001a\u00020\n2+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000bH\u0002R!\u0010;\u001a\b\u0012\u0004\u0012\u000206058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020\u001e0?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010A\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/QQKuiklyPlatformApi;", "Li01/e;", "", "method", "params", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "J", "w", HippyTKDListViewAdapter.X, "p", "", "u", "(Ljava/lang/Object;)[Ljava/lang/Object;", "H", "Lcom/tencent/biz/richframework/network/request/VSBaseRequest;", "", "retCode", "errMsg", "", "ssoSuccess", "Lkotlin/Pair;", "", "M", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "L", "G", "E", "Landroid/content/Context;", "ctx", "url", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "D", "processName", "l", "Lcom/tencent/kuikly/core/render/android/a;", "renderContext", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "v", "j", "y", "t", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "K", "B", "", "Lcooperation/qzone/util/NetworkState$NetworkStateListener;", "d", "Lkotlin/Lazy;", "r", "()Ljava/util/List;", "networkStateListenerList", "e", "Z", "hadDestroy", "", "f", "Ljava/util/List;", "SYS_EMOTICON_SYMBOL_EX", "<init>", "()V", tl.h.F, "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class QQKuiklyPlatformApi extends i01.e {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy networkStateListenerList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean hadDestroy;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final List<Integer> SYS_EMOTICON_SYMBOL_EX;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0006R\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0006R\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0006R\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0006R\u0014\u0010\u0012\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0006R\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0006R\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0006R\u0014\u0010\u0016\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0006R\u0014\u0010\u0017\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0006R\u0014\u0010\u0018\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0006\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/QQKuiklyPlatformApi$a;", "", "", "a", "", "CAN_SHARE_TO_GPRO", "Ljava/lang/String;", "CLOSE_PAGE", "CONVERT_QQ_EMOJI_DES_TO_STRING", "GET_DEVICE_INFO", "GET_NET_TYPE", "GET_NICK_NAMES_BY_UINS", "GET_PS_KEY", "GET_QQ_EMOJI_NAME_BY_Lid", "GET_UID", "GET_UIN", "HIPPY_MQQ_SCHEMA_PREFIX", "KEY_ENABLE", "MODULE_NAME", "NET_CHANGED", "OPEN_PAGE", "QQ_TOAST", "SEND_PB_REQUEST", "SET_ANDROID_NAVIGATION_BAR_COLOR", "SET_POP_WIDTH", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.QQKuiklyPlatformApi$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            BaseApplicationImpl application = BaseApplicationImpl.getApplication();
            AppRuntime runtime = application != null ? application.getRuntime() : null;
            if (runtime != null) {
                return runtime.getLongAccountUin();
            }
            return 0L;
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/QQKuiklyPlatformApi$b", "Lsd2/a;", "", "", "domainToKeyMap", "", "onSuccess", "errMsg", "onFail", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements sd2.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f262922a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f262923b;

        b(Function1<Object, Unit> function1, String str) {
            this.f262922a = function1;
            this.f262923b = str;
        }

        @Override // sd2.a
        public void onFail(String errMsg) {
            Map emptyMap;
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            Function1<Object, Unit> function1 = this.f262922a;
            if (function1 != null) {
                emptyMap = MapsKt__MapsKt.emptyMap();
                function1.invoke(emptyMap);
            }
            QLog.e("QQKuiklyPlatformApi", 1, "get pskey error: " + errMsg);
        }

        @Override // sd2.a
        public void onSuccess(Map<String, String> domainToKeyMap) {
            Map mapOf;
            Intrinsics.checkNotNullParameter(domainToKeyMap, "domainToKeyMap");
            Function1<Object, Unit> function1 = this.f262922a;
            if (function1 != null) {
                String str = domainToKeyMap.get(this.f262923b);
                if (str == null) {
                    str = "";
                }
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("p_skey", str));
                function1.invoke(mapOf);
            }
        }
    }

    public QQKuiklyPlatformApi() {
        Lazy lazy;
        List<Integer> listOf;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<List<NetworkState.NetworkStateListener>>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.QQKuiklyPlatformApi$networkStateListenerList$2
            @Override // kotlin.jvm.functions.Function0
            public final List<NetworkState.NetworkStateListener> invoke() {
                return new ArrayList();
            }
        });
        this.networkStateListenerList = lazy;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{324, 271, 250});
        this.SYS_EMOTICON_SYMBOL_EX = listOf;
    }

    private final void A(Context ctx, String url) {
        boolean startsWith$default;
        boolean startsWith$default2;
        boolean startsWith$default3;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "http", false, 2, null);
        if (!startsWith$default) {
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(url, "https", false, 2, null);
            if (!startsWith$default2) {
                if (z(get_kuiklyRenderContext())) {
                    startsWith$default3 = StringsKt__StringsJVMKt.startsWith$default(url, "mqqapi://hippy/open?", false, 2, null);
                    if (startsWith$default3) {
                        D(ctx, url);
                        return;
                    }
                }
                ((IJumpApi) QRoute.api(IJumpApi.class)).doJumpAction(ctx, url);
                return;
            }
        }
        ((IReadInJoyUtils) QRoute.api(IReadInJoyUtils.class)).jumpTo(ctx, url, null);
    }

    private final void B(final Function1<Object, Unit> callback) {
        NetworkState.NetworkStateListener networkStateListener = new NetworkState.NetworkStateListener() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.n
            @Override // cooperation.qzone.util.NetworkState.NetworkStateListener
            public final void onNetworkConnect(boolean z16) {
                QQKuiklyPlatformApi.C(Function1.this, z16);
            }
        };
        r().add(networkStateListener);
        NetworkState.addListener(networkStateListener);
    }

    private final void D(Context ctx, String url) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        BaseQQAppInterface baseQQAppInterface = peekAppRuntime instanceof BaseQQAppInterface ? (BaseQQAppInterface) peekAppRuntime : null;
        if (baseQQAppInterface == null) {
            QLog.e("openHippyOnSplitMode", 1, "appInterface is null");
            return;
        }
        ax c16 = bi.c(baseQQAppInterface, ctx, url);
        if (c16 == null) {
            QLog.e("openHippyOnSplitMode", 1, "action is null");
            return;
        }
        if (l(c16.f307441f.get("processName"))) {
            if (!c16.f307441f.containsKey("is_support_split_mode")) {
                HashMap<String, String> hashMap = c16.f307441f;
                Intrinsics.checkNotNullExpressionValue(hashMap, "action.attrs");
                hashMap.put("is_support_split_mode", "true");
            }
            if (!c16.f307441f.containsKey("is_cover_split_page")) {
                HashMap<String, String> hashMap2 = c16.f307441f;
                Intrinsics.checkNotNullExpressionValue(hashMap2, "action.attrs");
                hashMap2.put("is_cover_split_page", "true");
            }
            if (!c16.f307441f.containsKey("is_need_clear_other_fragment")) {
                HashMap<String, String> hashMap3 = c16.f307441f;
                Intrinsics.checkNotNullExpressionValue(hashMap3, "action.attrs");
                hashMap3.put("is_need_clear_other_fragment", "false");
            }
        }
        c16.b();
    }

    private final void E(String params) {
        final Context activity = getActivity();
        if ((activity == null && (activity = getContext()) == null) || params == null) {
            return;
        }
        if (((IMiniKuiklyApi) QRoute.api(IMiniKuiklyApi.class)).isLaunchByMiniApp(getActivity())) {
            ((IMiniKuiklyApi) QRoute.api(IMiniKuiklyApi.class)).openUrl(getActivity(), params);
            return;
        }
        JSONObject jSONObject = new JSONObject(params);
        final String url = jSONObject.optString("url");
        if (((IGameCenterKuiklyApi) QRoute.api(IGameCenterKuiklyApi.class)).checkIfOpenFloatInCurProcess(url)) {
            return;
        }
        if (jSONObject.optInt("closeCurPage") == 1) {
            m(null);
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.l
                @Override // java.lang.Runnable
                public final void run() {
                    QQKuiklyPlatformApi.F(QQKuiklyPlatformApi.this, activity, url);
                }
            }, 16L);
        } else {
            Intrinsics.checkNotNullExpressionValue(url, "url");
            A(activity, url);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(QQKuiklyPlatformApi this$0, Context ctx, String url) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(ctx, "$ctx");
        Intrinsics.checkNotNullExpressionValue(url, "url");
        this$0.A(ctx, url);
    }

    private final void G(String params) {
        int i3;
        JSONObject k06 = KRCSSViewExtensionKt.k0(params);
        String optString = k06.optString("content");
        if (optString == null) {
            return;
        }
        int optInt = k06.optInt("mode");
        Context context = getContext();
        if (optInt != 0) {
            i3 = 2;
            if (optInt != 1) {
                if (optInt == 2) {
                    i3 = 1;
                }
            }
            QQToast.makeText(context, i3, optString, 0).show();
        }
        i3 = 0;
        QQToast.makeText(context, i3, optString, 0).show();
    }

    private final void H(final Object params, final Function1<Object, Unit> callback) {
        if (this.hadDestroy) {
            QLog.i("QQKuiklyPlatformApi", 1, "sendPbRequest had destroy, just return");
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.m
                @Override // java.lang.Runnable
                public final void run() {
                    QQKuiklyPlatformApi.I(params, callback, this);
                }
            }, 128, null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(Object obj, Function1 function1, QQKuiklyPlatformApi this$0) {
        Object orNull;
        Object orNull2;
        Object orNull3;
        Object orNull4;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!(obj instanceof Object[])) {
            if (function1 != null) {
                function1.invoke(new Object[0]);
                return;
            }
            return;
        }
        Object[] objArr = (Object[]) obj;
        orNull = ArraysKt___ArraysKt.getOrNull(objArr, 0);
        final String str = orNull instanceof String ? (String) orNull : null;
        if (str == null) {
            str = "";
        }
        orNull2 = ArraysKt___ArraysKt.getOrNull(objArr, 1);
        final byte[] bArr = orNull2 instanceof byte[] ? (byte[]) orNull2 : null;
        orNull3 = ArraysKt___ArraysKt.getOrNull(objArr, 2);
        final String str2 = orNull3 instanceof String ? (String) orNull3 : null;
        orNull4 = ArraysKt___ArraysKt.getOrNull(objArr, 3);
        Integer num = orNull4 instanceof Integer ? (Integer) orNull4 : null;
        final int intValue = num != null ? num.intValue() : 0;
        if (bArr == null) {
            if (function1 != null) {
                function1.invoke(new Object[0]);
            }
        } else {
            QLog.i("QQKuiklyPlatformApi", 1, "sendPbRequest: " + str);
            VSNetworkHelper.getInstance().sendRequest(this$0.getContext(), new VSBaseRequest(str2, bArr, str, intValue) { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.QQKuiklyPlatformApi$sendPbRequest$1$1
                final /* synthetic */ String $cmd;
                final /* synthetic */ byte[] $pbReqBytes;
                final /* synthetic */ int $withoutLogin;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.$pbReqBytes = bArr;
                    this.$cmd = str;
                    this.$withoutLogin = intValue;
                    if (str2 == null || str2.length() == 0) {
                        return;
                    }
                    overrideTraceId(str2);
                    setRequestUin(((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount());
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.tencent.biz.richframework.network.request.BaseRequest
                public <T> T decode(byte[] convertInputStreamtoByteArray) {
                    if (convertInputStreamtoByteArray instanceof Object) {
                        return convertInputStreamtoByteArray;
                    }
                    return null;
                }

                @Override // com.tencent.biz.richframework.network.request.BaseRequest
                /* renamed from: getCmdName, reason: from getter */
                public String get$cmd() {
                    return this.$cmd;
                }

                @Override // com.tencent.biz.richframework.network.request.BaseRequest
                /* renamed from: getRequestByteData, reason: from getter */
                protected byte[] get$pbReqBytes() {
                    return this.$pbReqBytes;
                }

                @Override // com.tencent.biz.richframework.network.request.VSBaseRequest
                public Boolean isWithouLogin() {
                    return Boolean.valueOf(this.$withoutLogin > 0);
                }

                @Override // com.tencent.biz.richframework.network.request.VSBaseRequest, com.tencent.biz.richframework.network.request.BaseRequest
                public Object[] parseResponseHeadInfo(byte[] bytes) {
                    return new Object[]{0L, getSsoFailMsg(), fh.a(bytes)};
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.tencent.biz.richframework.network.request.VSBaseRequest
                public byte[] getRequestWrapper(ByteStringMicro requestBizData) {
                    if (requestBizData == null) {
                        return new byte[0];
                    }
                    byte[] byteArray = requestBizData.toByteArray();
                    Intrinsics.checkNotNullExpressionValue(byteArray, "requestBizData.toByteArray()");
                    return byteArray;
                }
            }, new c(function1, this$0, str));
        }
    }

    private final void J(String params) {
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        String optString = KRCSSViewExtensionKt.k0(params).optString("color");
        Intrinsics.checkNotNullExpressionValue(optString, "params.toJSONObjectSafely().optString(\"color\")");
        int w3 = com.tencent.kuikly.core.render.android.css.ktx.b.w(optString);
        Window window = activity.getWindow();
        if (window == null) {
            return;
        }
        window.setNavigationBarColor(w3);
    }

    private final void K(String params) {
        double optDouble = KRCSSViewExtensionKt.k0(params).optDouble("width");
        QQKuiklyFragment a16 = com.tencent.mobileqq.qqecommerce.biz.kuikly.export.g.a(this);
        if (a16 != null) {
            a16.vh(com.tencent.kuikly.core.render.android.css.ktx.b.I(get_kuiklyRenderContext(), (float) optDouble));
        }
    }

    private final boolean L(String params) {
        if (new JSONObject(params).optInt("handleAsTaskRoot") == 1) {
            Activity activity = getActivity();
            if ((activity != null && activity.isTaskRoot()) && getContext() != null) {
                QLog.d("QQKuiklyPlatformApi", 1, "shouldHandleAsTaskRoot nearby pro isTaskRoot = true");
                Context context = getContext();
                if (context != null) {
                    Intent aliasIntent = SplashActivity.getAliasIntent(context);
                    aliasIntent.addFlags(67108864);
                    aliasIntent.addFlags(536870912);
                    Activity activity2 = getActivity();
                    if (activity2 != null) {
                        activity2.startActivity(aliasIntent);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private final void j(String params, Function1<Object, Unit> callback) {
        Map mapOf;
        Map mapOf2;
        if (((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).isShowGuildTabCached()) {
            if (callback != null) {
                mapOf2 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("enable", "1"));
                callback.invoke(mapOf2);
                return;
            }
            return;
        }
        if (callback != null) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("enable", "0"));
            callback.invoke(mapOf);
        }
    }

    private final void m(String params) {
        if ((getActivity() instanceof SplashActivity) && z(get_kuiklyRenderContext())) {
            Activity activity = getActivity();
            if (activity != null) {
                activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        QQKuiklyPlatformApi.o(QQKuiklyPlatformApi.this);
                    }
                });
                return;
            }
            return;
        }
        if (params != null) {
            L(params);
        }
        Activity activity2 = getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(QQKuiklyPlatformApi this$0) {
        com.tencent.mobileqq.pad.k kVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.getActivity();
        SplashActivity splashActivity = activity instanceof SplashActivity ? (SplashActivity) activity : null;
        if (splashActivity == null || (kVar = splashActivity.getqFragmentStackManager()) == null) {
            return;
        }
        kVar.o();
    }

    private final String p(String params) {
        boolean contains$default;
        boolean contains$default2;
        boolean contains$default3;
        boolean contains$default4;
        boolean contains$default5;
        boolean contains$default6;
        String content = KRCSSViewExtensionKt.k0(params).optString("content");
        if (TextUtils.isEmpty(content)) {
            return "";
        }
        Intrinsics.checkNotNullExpressionValue(content, "content");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) content, (CharSequence) "/", false, 2, (Object) null);
        if (!contains$default) {
            Intrinsics.checkNotNullExpressionValue(content, "content");
            return content;
        }
        try {
            Map<Integer, QQSysAndEmojiResInfo.QQEmoConfigItem> sysConfig = QQSysFaceUtil.sysConfigItemMap();
            try {
                Iterator<Integer> it = this.SYS_EMOTICON_SYMBOL_EX.iterator();
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    if (sysConfig.containsKey(Integer.valueOf(intValue))) {
                        QQSysAndEmojiResInfo.QQEmoConfigItem qQEmoConfigItem = sysConfig.get(Integer.valueOf(intValue));
                        Intrinsics.checkNotNull(qQEmoConfigItem);
                        String str = "\u0014" + qQEmoConfigItem.QDes;
                        Intrinsics.checkNotNullExpressionValue(content, "content");
                        contains$default6 = StringsKt__StringsKt.contains$default((CharSequence) content, (CharSequence) str, false, 2, (Object) null);
                        if (contains$default6) {
                            Intrinsics.checkNotNullExpressionValue(content, "content");
                            String sysEmotcationString = com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(intValue);
                            Intrinsics.checkNotNullExpressionValue(sysEmotcationString, "getSysEmotcationString(spanIndex)");
                            content = StringsKt__StringsJVMKt.replace$default(content, str, sysEmotcationString, false, 4, (Object) null);
                        }
                    }
                }
                Intrinsics.checkNotNullExpressionValue(sysConfig, "sysConfig");
                for (Map.Entry<Integer, QQSysAndEmojiResInfo.QQEmoConfigItem> entry : sysConfig.entrySet()) {
                    Integer index = entry.getKey();
                    String str2 = "\u0014" + entry.getValue().QDes;
                    Intrinsics.checkNotNullExpressionValue(content, "content");
                    contains$default5 = StringsKt__StringsKt.contains$default((CharSequence) content, (CharSequence) str2, false, 2, (Object) null);
                    if (contains$default5) {
                        Intrinsics.checkNotNullExpressionValue(content, "content");
                        Intrinsics.checkNotNullExpressionValue(index, "index");
                        String sysEmotcationString2 = com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(index.intValue());
                        Intrinsics.checkNotNullExpressionValue(sysEmotcationString2, "getSysEmotcationString(index)");
                        content = StringsKt__StringsJVMKt.replace$default(content, str2, sysEmotcationString2, false, 4, (Object) null);
                    }
                }
                for (Map.Entry<Integer, QQSysAndEmojiResInfo.QQEmoConfigItem> entry2 : sysConfig.entrySet()) {
                    Integer index2 = entry2.getKey();
                    String symbol = entry2.getValue().QDes;
                    Intrinsics.checkNotNullExpressionValue(content, "content");
                    Intrinsics.checkNotNullExpressionValue(symbol, "symbol");
                    contains$default4 = StringsKt__StringsKt.contains$default((CharSequence) content, (CharSequence) symbol, false, 2, (Object) null);
                    if (contains$default4) {
                        Intrinsics.checkNotNullExpressionValue(content, "content");
                        Intrinsics.checkNotNullExpressionValue(index2, "index");
                        String sysEmotcationString3 = com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(index2.intValue());
                        Intrinsics.checkNotNullExpressionValue(sysEmotcationString3, "getSysEmotcationString(index)");
                        content = StringsKt__StringsJVMKt.replace$default(content, symbol, sysEmotcationString3, false, 4, (Object) null);
                    }
                }
                int length = EmotcationConstants.SYS_EMOTICON_SYMBOL.length;
                for (int i3 = 0; i3 < length; i3++) {
                    String str3 = "\u0014" + EmotcationConstants.SYS_EMOTICON_SYMBOL[i3];
                    Intrinsics.checkNotNullExpressionValue(content, "content");
                    contains$default3 = StringsKt__StringsKt.contains$default((CharSequence) content, (CharSequence) str3, false, 2, (Object) null);
                    if (contains$default3) {
                        Intrinsics.checkNotNullExpressionValue(content, "content");
                        String sysEmotcationString4 = com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(i3);
                        Intrinsics.checkNotNullExpressionValue(sysEmotcationString4, "getSysEmotcationString(localId)");
                        content = StringsKt__StringsJVMKt.replace$default(content, str3, sysEmotcationString4, false, 4, (Object) null);
                    }
                }
                int length2 = EmotcationConstants.SYS_EMOTICON_SYMBOL.length;
                for (int i16 = 0; i16 < length2; i16++) {
                    String symbol2 = EmotcationConstants.SYS_EMOTICON_SYMBOL[i16];
                    Intrinsics.checkNotNullExpressionValue(content, "content");
                    Intrinsics.checkNotNullExpressionValue(symbol2, "symbol");
                    contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) content, (CharSequence) symbol2, false, 2, (Object) null);
                    if (contains$default2) {
                        Intrinsics.checkNotNullExpressionValue(content, "content");
                        String sysEmotcationString5 = com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(i16);
                        Intrinsics.checkNotNullExpressionValue(sysEmotcationString5, "getSysEmotcationString(localId)");
                        content = StringsKt__StringsJVMKt.replace$default(content, symbol2, sysEmotcationString5, false, 4, (Object) null);
                    }
                }
            } catch (Exception e16) {
                e = e16;
                if (QLog.isColorLevel()) {
                    QLog.i("QQKuiklyPlatformApi", 2, "convertMsg exception", e);
                }
                Intrinsics.checkNotNullExpressionValue(content, "content");
                return content;
            }
        } catch (Exception e17) {
            e = e17;
        }
        Intrinsics.checkNotNullExpressionValue(content, "content");
        return content;
    }

    private final String q() {
        String deviceInfo = DeviceInfoUtils.getDeviceInfo();
        Intrinsics.checkNotNullExpressionValue(deviceInfo, "getDeviceInfo()");
        return deviceInfo;
    }

    private final List<NetworkState.NetworkStateListener> r() {
        return (List) this.networkStateListenerList.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final String t() {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put(2, "2");
        arrayMap.put(3, "3");
        arrayMap.put(4, "4");
        arrayMap.put(5, "5");
        arrayMap.put(1, "1");
        arrayMap.put(0, "0");
        String str = (String) arrayMap.get(Integer.valueOf(NetworkState.getNetworkType()));
        return str == null ? "0" : str;
    }

    private final Object[] u(Object params) {
        Intrinsics.checkNotNull(params, "null cannot be cast to non-null type kotlin.Array<kotlin.Any>");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new byte[0]);
        for (Object obj : (Object[]) params) {
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            String str = obj instanceof String ? (String) obj : null;
            String str2 = "";
            if (str == null) {
                str = "";
            }
            String F = com.tencent.mobileqq.utils.ac.F(runtime, str);
            if (F != null) {
                str2 = F;
            }
            arrayList.add(str2);
        }
        Object[] array = arrayList.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return array;
    }

    private final void v(String params, Function1<Object, Unit> callback) {
        Map emptyMap;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || params == null) {
            if (callback != null) {
                emptyMap = MapsKt__MapsKt.emptyMap();
                callback.invoke(emptyMap);
                return;
            }
            return;
        }
        IPskeyManager iPskeyManager = (IPskeyManager) peekAppRuntime.getRuntimeService(IPskeyManager.class, "all");
        JSONObject jSONObject = new JSONObject(params);
        String domain = jSONObject.optString("domain");
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105786", false);
        QLog.d("QQKuiklyPlatformApi", 1, "getPSkey use cache switch: " + isSwitchOn);
        boolean z16 = !isSwitchOn && jSONObject.optInt("ignoreCache") == 1;
        b bVar = new b(callback, domain);
        if (z16) {
            Intrinsics.checkNotNullExpressionValue(domain, "domain");
            iPskeyManager.replacePskey(new String[]{domain}, bVar);
        } else {
            Intrinsics.checkNotNullExpressionValue(domain, "domain");
            iPskeyManager.getPskey(new String[]{domain}, bVar);
        }
    }

    private final String w(String params) {
        int optInt = KRCSSViewExtensionKt.k0(params).optInt("lid");
        if (optInt == 250) {
            optInt = 10;
        }
        String faceDescription = QQSysFaceUtil.getFaceDescription(optInt);
        return faceDescription == null ? "" : faceDescription;
    }

    private final String x(String params) {
        String uidFromUin;
        return (params == null || (uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(params)) == null) ? "" : uidFromUin;
    }

    private final String y(String params, Function1<Object, Unit> callback) {
        return String.valueOf(INSTANCE.a());
    }

    private final boolean z(com.tencent.kuikly.core.render.android.a renderContext) {
        Bundle arguments;
        Bundle bundle;
        QQKuiklyFragment b16 = QQKuiklyCommUtil.INSTANCE.b(renderContext);
        return (b16 == null || (arguments = b16.getArguments()) == null || (bundle = arguments.getBundle("launchKuiklyParams")) == null || true != bundle.getBoolean("is_load_on_split_mode", false)) ? false : true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000a. Please report as an issue. */
    @Override // i01.e, i01.a
    public Object call(String method, String params, Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        switch (method.hashCode()) {
            case -1249348326:
                if (method.equals("getUid")) {
                    return x(params);
                }
                return super.call(method, params, callback);
            case -1249348316:
                if (method.equals("getUin")) {
                    return y(params, callback);
                }
                return super.call(method, params, callback);
            case -1132484524:
                if (method.equals("setEdgePopWidth")) {
                    K(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -504772615:
                if (method.equals(IndividuationPlugin.Method_OpenPage)) {
                    E(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -482608985:
                if (method.equals("closePage")) {
                    m(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 74968789:
                if (method.equals("getQQEmojiNameByLid")) {
                    return w(params);
                }
                return super.call(method, params, callback);
            case 336931153:
                if (method.equals("listenNetworkTypeChange")) {
                    B(callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 483103770:
                if (method.equals("getDeviceInfo")) {
                    return q();
                }
                return super.call(method, params, callback);
            case 524774375:
                if (method.equals("qqToast")) {
                    G(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1480699307:
                if (method.equals("convertQQEmojiDesToString")) {
                    return p(params);
                }
                return super.call(method, params, callback);
            case 1714085202:
                if (method.equals("getNetworkType")) {
                    return t();
                }
                return super.call(method, params, callback);
            case 1868142768:
                if (method.equals("canShareToGPro")) {
                    j(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1961838566:
                if (method.equals("getPSkey")) {
                    v(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 2108177361:
                if (method.equals("setAndroidNavigationBarColor")) {
                    J(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            default:
                return super.call(method, params, callback);
        }
    }

    @Override // i01.e, i01.a
    public void onDestroy() {
        super.onDestroy();
        Iterator<T> it = r().iterator();
        while (it.hasNext()) {
            NetworkState.removeListener((NetworkState.NetworkStateListener) it.next());
        }
        VSNetworkHelper.getInstance().cancelRequest(getContext());
        this.hadDestroy = true;
    }

    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J6\u0010\r\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/QQKuiklyPlatformApi$c", "Lcom/tencent/biz/richframework/network/observer/VSDispatchObserver$OnVSRspCallBack;", "", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", Const.BUNDLE_KEY_REQUEST, "", "isSuccess", "", "retCode", "", "errMsg", "t", "", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements VSDispatchObserver.OnVSRspCallBack<byte[]> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f262924a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QQKuiklyPlatformApi f262925b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f262926c;

        c(Function1<Object, Unit> function1, QQKuiklyPlatformApi qQKuiklyPlatformApi, String str) {
            this.f262924a = function1;
            this.f262925b = qQKuiklyPlatformApi;
            this.f262926c = str;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest request, boolean isSuccess, long retCode, String errMsg, byte[] t16) {
            if (!(request instanceof VSBaseRequest)) {
                Function1<Object, Unit> function1 = this.f262924a;
                if (function1 != null) {
                    function1.invoke(new Object[0]);
                }
                QLog.e("QQKuiklyPlatformApi", 1, "cmd: " + (request != null ? request.get$cmd() : null) + ", reuqest type error");
                return;
            }
            VSBaseRequest vSBaseRequest = (VSBaseRequest) request;
            Pair M = this.f262925b.M(vSBaseRequest, retCode, errMsg, isSuccess);
            Function1<Object, Unit> function12 = this.f262924a;
            if (function12 != null) {
                Object[] objArr = new Object[3];
                objArr[0] = M.getFirst();
                String str = (String) M.getSecond();
                if (str == null) {
                    str = "";
                }
                objArr[1] = str;
                objArr[2] = t16 == null ? new byte[0] : t16;
                function12.invoke(objArr);
            }
            QLog.i("QQKuiklyPlatformApi", 1, "cmd: " + this.f262926c + ", retCode: " + retCode + ", errorMsg: " + errMsg + ", ssoRetCode: " + vSBaseRequest.getSsoResultCode() + ", ssoFailMsg: " + vSBaseRequest.getSsoFailMsg() + ", trpcRetCode: " + vSBaseRequest.getTrpcRspRetCode() + ", trpcFailMsg: " + vSBaseRequest.getTrpcFailMsg() + ", trpcRspFuncRetCode: " + vSBaseRequest.getTrpcRspFuncRetCode());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(Function1 function1, boolean z16) {
        Map emptyMap;
        if (function1 != null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            function1.invoke(emptyMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<Integer, String> M(VSBaseRequest vSBaseRequest, long j3, String str, boolean z16) {
        Pair<Integer, String> pair;
        int i3 = (int) j3;
        if (i3 != 0) {
            return new Pair<>(Integer.valueOf(i3), str);
        }
        if (!z16) {
            pair = new Pair<>(Integer.valueOf(vSBaseRequest.getSsoResultCode()), vSBaseRequest.getSsoFailMsg());
        } else if (vSBaseRequest.getTrpcRspRetCode() != 0) {
            pair = new Pair<>(Integer.valueOf(vSBaseRequest.getTrpcRspRetCode()), vSBaseRequest.getTrpcFailMsg());
        } else if (vSBaseRequest.getTrpcRspFuncRetCode() != 0) {
            pair = new Pair<>(Integer.valueOf(vSBaseRequest.getTrpcRspFuncRetCode()), vSBaseRequest.getTrpcFailMsg());
        } else {
            return new Pair<>(0, "");
        }
        return pair;
    }

    private final boolean l(String processName) {
        return (processName == null || processName.length() == 0) || Intrinsics.areEqual(processName, "main") || Intrinsics.areEqual(processName, "local");
    }

    @Override // i01.e, i01.a
    public Object call(String method, Object params, Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (!Intrinsics.areEqual(method, "sendPbRequest")) {
            return Intrinsics.areEqual(method, "getNickNamesByUins") ? u(params) : super.call(method, params, callback);
        }
        H(params, callback);
        return Unit.INSTANCE;
    }
}
