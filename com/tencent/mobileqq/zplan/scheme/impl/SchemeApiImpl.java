package com.tencent.mobileqq.zplan.scheme.impl;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import cl3.b;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ad.tangram.statistics.metric.AdMetricID;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.parser.JumpParserResult;
import com.tencent.mobileqq.app.parser.ax;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.vas.api.IVasZplanGroupApi;
import com.tencent.mobileqq.vas.transit.ExtInfo;
import com.tencent.mobileqq.vas.transit.MasterInfo;
import com.tencent.mobileqq.vas.transit.TransitPageConfig;
import com.tencent.mobileqq.vas.transit.TransitPageInfo;
import com.tencent.mobileqq.vas.transit.VisitorInfo;
import com.tencent.mobileqq.webview.util.s;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.IZootopiaReportApi;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.mobileqq.zootopia.entry.IEntryApi;
import com.tencent.mobileqq.zootopia.m;
import com.tencent.mobileqq.zootopia.portal.detail.ZootopiaDetailFragment;
import com.tencent.mobileqq.zootopia.utils.DataConvertUtil;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.minixwconnected.ZPlanMiniHomeConnectedFragment;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.mobileqq.zplan.widget.api.tab.DressSquareTabType;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishApiImpl;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import com.tencent.sqshow.zootopia.recommend.characterV2.event.FaceAdDataEvent;
import com.tencent.sqshow.zootopia.recommend.main.tab.ZPlanTabContentUrl;
import com.tencent.sqshow.zootopia.utils.ag;
import com.tencent.sqshow.zootopia.utils.w;
import com.tencent.state.report.SquareReportConst;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import k74.i;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import nw4.h;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 [2\u00020\u0001:\u0001\\B\u0007\u00a2\u0006\u0004\bY\u0010ZJ*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0002J*\u0010\f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0002J \u0010\u000e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0006H\u0002J \u0010\u000f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0006H\u0002J<\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\"\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011`\u00122\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J<\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\"\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011`\u00122\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J,\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002J,\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00162\b\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002J$\u0010 \u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00112\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001f0\u001eH\u0002J\u0010\u0010#\u001a\u00020\t2\u0006\u0010\"\u001a\u00020!H\u0002J\u0010\u0010&\u001a\u00020\t2\u0006\u0010%\u001a\u00020$H\u0016J\u0010\u0010'\u001a\u00020\t2\u0006\u0010%\u001a\u00020$H\u0016J\u0018\u0010)\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u0011H\u0016J<\u0010+\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u00112\"\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011`\u0012H\u0016J<\u0010,\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u00112\"\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011`\u0012H\u0016J4\u0010-\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\"\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011`\u0012H\u0016J\"\u0010/\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00162\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u00100\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0016J\"\u00102\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u00162\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0016J\"\u00103\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00162\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u00105\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u0016H\u0016J\u0018\u00105\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00106\u001a\u00020!H\u0016J\u0018\u00107\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0018H\u0016J\u0010\u00108\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u00109\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010:\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010<\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\u0016H\u0016J(\u0010@\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u00112\u0006\u0010>\u001a\u00020\u00112\u0006\u0010?\u001a\u00020\u0011H\u0016J(\u0010D\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u00112\u0006\u0010B\u001a\u00020\u00112\u0006\u0010C\u001a\u00020\u0011H\u0016J\u001a\u0010E\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010F\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u0011H\u0016J\u0010\u0010G\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u0011H\u0016J\u0018\u0010H\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010I\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u00112\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010L\u001a\u00020\u00112\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010K\u001a\u00020J2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006H\u0016J4\u0010M\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\"\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011`\u0012H\u0016J4\u0010N\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\"\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011`\u0012H\u0016J\u0018\u0010P\u001a\u00020O2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u0011H\u0016J4\u0010Q\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\"\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011`\u0012H\u0016J\u0018\u0010T\u001a\n S*\u0004\u0018\u00010R0R2\u0006\u0010(\u001a\u00020\u0011H\u0016R$\u0010W\u001a\u0012\u0012\u0004\u0012\u00020$0Uj\b\u0012\u0004\u0012\u00020$`V8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010X\u00a8\u0006]"}, d2 = {"Lcom/tencent/mobileqq/zplan/scheme/impl/SchemeApiImpl;", "Lcom/tencent/mobileqq/zplan/scheme/ISchemeApi;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "Landroid/os/Bundle;", "pageBundle", "ueBundle", "", "openSmallHomeWithTransitPage", "bundle", "handleEnterPortal", ISchemeApi.KEY_PAGE_DATA, "handleEnterTaskPanel", "handleEnterDressDetail", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "params", "handleEnterSameStyleList", "doEnterSameStyleList", "", "sceneType", "Lorg/json/JSONObject;", "ueData", "buildAvatarSchemeUrl", "pageId", "buildPageSchemeUrl", "schemePrefix", "", "", "buildSchemeUrl", "", "faceId", "getAndShowBodyUpdateAd", "Lmk3/a;", "l", "registerSchemeHandleListener", "removeSchemeHandleListener", "schemeUrl", "launchScheme", "url", "handleEnterAvatarScheme", "handleOpenPageScheme", "handleToastScheme", "viewType", "buildAvatarScheme", "buildCommunityScheme", "mapId", "buildMapScheme", "buildPageScheme", "brandId", "buildMallScheme", "clothesId", "buildTryOnSameStyleScheme", "buildMailScheme", "buildInventoryScheme", "buildActiveListScheme", "pandoraActivityId", "buildActiveDetailScheme", "templateId", "productId", "eventId", "buildClothDesignScheme", "id", "uin", "from", "buildDressDetailScheme", "buildMakeUpPageScheme", "convertSchemeToJsonForReport", "appendRootSourceToScheme", "appendSourceToScheme", "appendPageDataToScheme", "Lcom/tencent/mobileqq/vas/transit/TransitPageInfo;", "info", "buildTransitPageScheme", "handleThirdAuthCallback", "handleZplanThirdScheme", "", "shouldInterceptWebToNative", "handleFaceAdScheme", "Lcom/tencent/mobileqq/app/parser/JumpParserResult;", "kotlin.jvm.PlatformType", "parseUrl", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "mListenerPool", "Ljava/util/HashSet;", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class SchemeApiImpl implements ISchemeApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "ZootopiaSchemeHelper";
    private final HashSet<mk3.a> mListenerPool = new HashSet<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/zplan/scheme/impl/SchemeApiImpl$a;", "", "Landroid/content/Context;", "context", "", "url", "", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.scheme.impl.SchemeApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x002c A[Catch: all -> 0x0043, TryCatch #0 {all -> 0x0043, blocks: (B:3:0x000e, B:5:0x0016, B:7:0x0020, B:12:0x002c, B:14:0x0037), top: B:2:0x000e }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean a(Context context, String url) {
            boolean z16;
            boolean startsWith$default;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(url, "url");
            try {
                if (ZPlanQQMC.INSTANCE.enableInterceptOpenHomeConnected()) {
                    String queryParameter = Uri.parse(url).getQueryParameter("url");
                    if (queryParameter != null && queryParameter.length() != 0) {
                        z16 = false;
                        if (!z16) {
                            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(queryParameter, ISchemeApi.SCHEME_OPEN_HOME_CONNECTED, false, 2, null);
                            if (startsWith$default) {
                                ((ISchemeApi) QRoute.api(ISchemeApi.class)).launchScheme(context, queryParameter);
                                return true;
                            }
                        }
                    }
                    z16 = true;
                    if (!z16) {
                    }
                }
            } catch (Throwable unused) {
                QLog.e(SchemeApiImpl.TAG, 1, "shouldInterceptUrl failed " + url);
            }
            return false;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/scheme/impl/SchemeApiImpl$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lnw4/b;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements e<nw4.b> {
        b() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(nw4.b result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i(SchemeApiImpl.TAG, 1, "getAndShowBodyUpdateAd onResultSuccess");
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            h hVar = result.f421463a;
            Intrinsics.checkNotNullExpressionValue(hVar, "result.info");
            simpleEventBus.dispatchEvent(new FaceAdDataEvent(hVar));
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.i(SchemeApiImpl.TAG, 1, "getAndShowBodyUpdateAd onResultFailure error = " + error + " message = " + message);
        }
    }

    private final String buildSchemeUrl(String schemePrefix, Map<String, Object> params) {
        String joinToString$default;
        if (!params.containsKey(ISchemeApi.KEY_IOS_SRC_TYPE)) {
            params.put(ISchemeApi.KEY_IOS_SRC_TYPE, "app");
        }
        if (!params.containsKey("version")) {
            params.put("version", "1.0");
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(params.entrySet(), ContainerUtils.FIELD_DELIMITER, schemePrefix, null, 0, null, new Function1<Map.Entry<String, Object>, CharSequence>() { // from class: com.tencent.mobileqq.zplan.scheme.impl.SchemeApiImpl$buildSchemeUrl$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(Map.Entry<String, Object> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                String key = it.getKey();
                return ((Object) key) + ContainerUtils.KEY_VALUE_DELIMITER + it.getValue();
            }
        }, 28, null);
        return joinToString$default;
    }

    private final void doEnterSameStyleList(Context context, HashMap<String, String> params, ZootopiaSource source) {
        HashMap<String, Object> p16 = xb4.b.f447772a.p(params.get("extData"));
        IEntryApi iEntryApi = (IEntryApi) QRoute.api(IEntryApi.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("share_extra_params", p16);
        bundle.putSerializable(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, source);
        Unit unit = Unit.INSTANCE;
        iEntryApi.startSameStyleFragment(context, source, bundle);
    }

    private final void handleEnterDressDetail(Context context, ZootopiaSource source, Bundle pageData) {
        ((IEntryApi) QRoute.api(IEntryApi.class)).startDressDetailFragment(context, source, pageData);
    }

    private final void handleEnterPortal(ZootopiaSource source, Context context, Bundle bundle, Bundle ueBundle) {
        int i3 = bundle.getInt("subSceneType", -1);
        boolean z16 = false;
        if (ueBundle != null && ueBundle.containsKey("SubScene")) {
            z16 = true;
        }
        if (i3 > 0) {
            ((IEntryApi) QRoute.api(IEntryApi.class)).startSimpleAvatarFragment(context, source, bundle);
        } else if (z16) {
            ((IEntryApi) QRoute.api(IEntryApi.class)).startAvatarSubSceneFragment(context, source, bundle);
        } else {
            ((IEntryApi) QRoute.api(IEntryApi.class)).startPortalActivity(context, source, bundle);
        }
        com.tencent.sqshow.dresskey.b.f369818a.t(ZPlanPublishSource.FROM_SCHEME, true);
    }

    private final void handleEnterSameStyleList(Context context, HashMap<String, String> params, ZootopiaSource source) {
        xb4.b.f447772a.b(source, 7, AdMetricID.Click.SUCCESS);
        doEnterSameStyleList(context, params, source);
    }

    private final void handleEnterTaskPanel(Context context, ZootopiaSource source, Bundle pageData) {
        ((IEntryApi) QRoute.api(IEntryApi.class)).startTaskSystemFragment(context, source, pageData);
    }

    private final void openSmallHomeWithTransitPage(Context context, ZootopiaSource source, Bundle pageBundle, Bundle ueBundle) {
        String currentUin;
        QLog.i(TAG, 1, "openSmallHomeWithTransitPage");
        IVasZplanGroupApi iVasZplanGroupApi = (IVasZplanGroupApi) QRoute.api(IVasZplanGroupApi.class);
        MasterInfo masterInfo = new MasterInfo();
        Object obj = pageBundle.get("uin");
        if (obj == null || (currentUin = obj.toString()) == null) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            currentUin = peekAppRuntime != null ? peekAppRuntime.getCurrentUin() : null;
        }
        masterInfo.setUin(currentUin);
        Object obj2 = pageBundle.get("groupId");
        masterInfo.setGroupId(obj2 != null ? obj2.toString() : null);
        masterInfo.setGuildIdType(pageBundle.getInt(ISchemeApi.KEY_GUILD_ID_TYPE, 1));
        masterInfo.setGuildId(pageBundle.getString("guildId", null));
        DataConvertUtil dataConvertUtil = DataConvertUtil.f329546a;
        masterInfo.setTinyNick(dataConvertUtil.b(pageBundle.getString(ISchemeApi.KEY_TINY_NICK, null)));
        masterInfo.setTinyAvatar(dataConvertUtil.b(pageBundle.getString(ISchemeApi.KEY_TINY_AVATAR, null)));
        Unit unit = Unit.INSTANCE;
        VisitorInfo visitorInfo = new VisitorInfo();
        TransitPageConfig transitPageConfig = new TransitPageConfig();
        transitPageConfig.setTransitType(pageBundle.getInt(ISchemeApi.KEY_TRANSIT_TYPE, 0));
        transitPageConfig.setNeedTransitPageWhenReady(pageBundle.getInt(ISchemeApi.KEY_NEED_TRANSIT_WHEN_READY, 0));
        transitPageConfig.setUiStyle(pageBundle.getInt("uiStyle", 0));
        transitPageConfig.setSinglePageMode(true);
        ExtInfo extInfo = new ExtInfo();
        extInfo.setUeExtras(k33.a.f411513a.b(ueBundle));
        iVasZplanGroupApi.openSmallHomeTransitPage(context, new TransitPageInfo(masterInfo, visitorInfo, transitPageConfig, extInfo), source);
        IZootopiaReportApi iZootopiaReportApi = (IZootopiaReportApi) QRoute.api(IZootopiaReportApi.class);
        HashMap hashMap = new HashMap();
        hashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, source.getSubSource());
        hashMap.put("zplan_action_type", "click");
        iZootopiaReportApi.reportEvent("ev_zplan_external_entrance_action", hashMap);
    }

    @Override // com.tencent.mobileqq.zplan.scheme.ISchemeApi
    public String appendPageDataToScheme(String schemeUrl, Bundle bundle) {
        Intrinsics.checkNotNullParameter(schemeUrl, "schemeUrl");
        return xb4.b.f447772a.d(schemeUrl, bundle);
    }

    @Override // com.tencent.mobileqq.zplan.scheme.ISchemeApi
    public String appendRootSourceToScheme(String schemeUrl) {
        Intrinsics.checkNotNullParameter(schemeUrl, "schemeUrl");
        return xb4.b.f447772a.e(schemeUrl);
    }

    @Override // com.tencent.mobileqq.zplan.scheme.ISchemeApi
    public String appendSourceToScheme(String schemeUrl, ZootopiaSource source) {
        Intrinsics.checkNotNullParameter(schemeUrl, "schemeUrl");
        Intrinsics.checkNotNullParameter(source, "source");
        return xb4.b.f447772a.f(schemeUrl, source);
    }

    @Override // com.tencent.mobileqq.zplan.scheme.ISchemeApi
    public String buildActiveDetailScheme(ZootopiaSource source, int pandoraActivityId) {
        Intrinsics.checkNotNullParameter(source, "source");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("PandoraActivityId", pandoraActivityId);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("SceneType", 3);
        jSONObject3.put("SceneParams", jSONObject2);
        jSONObject.put("SubScene", jSONObject3);
        return buildAvatarSchemeUrl(source, 1, new Bundle(), jSONObject);
    }

    @Override // com.tencent.mobileqq.zplan.scheme.ISchemeApi
    public String buildActiveListScheme(ZootopiaSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("SceneType", 3);
        jSONObject.put("SubScene", jSONObject2);
        jSONObject.put("ViewType", 1);
        return buildAvatarSchemeUrl(source, 1, new Bundle(), jSONObject);
    }

    @Override // com.tencent.mobileqq.zplan.scheme.ISchemeApi
    public String buildAvatarScheme(ZootopiaSource source, int viewType, Bundle bundle) {
        Intrinsics.checkNotNullParameter(source, "source");
        return buildAvatarSchemeUrl(source, viewType, bundle, xb4.b.f447772a.j(bundle));
    }

    @Override // com.tencent.mobileqq.zplan.scheme.ISchemeApi
    public String buildClothDesignScheme(ZootopiaSource source, String templateId, String productId, String eventId) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(templateId, "templateId");
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(WadlProxyConsts.SCENE_ID, 10001);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("ViewportType", 0);
        jSONObject2.put("UseH5", true);
        jSONObject2.put("EventId", eventId);
        jSONObject2.put("TemplateId", templateId);
        jSONObject2.put("ProductId", productId);
        jSONObject.put("sceneParam", jSONObject2);
        return buildAvatarSchemeUrl(source, 25, new Bundle(), jSONObject);
    }

    @Override // com.tencent.mobileqq.zplan.scheme.ISchemeApi
    public String buildCommunityScheme(ZootopiaSource source, Bundle bundle) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("targetTab", new ZPlanTabContentUrl(3, 0, null, null, 14, null).a(true));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("targetPage", DressSquareTabType.COMMUNITY.getTabKey());
        bundle.putString("targetTabData", jSONObject.toString());
        return buildAvatarSchemeUrl(source, 1, bundle, null);
    }

    @Override // com.tencent.mobileqq.zplan.scheme.ISchemeApi
    public String buildDressDetailScheme(ZootopiaSource source, String id5, String uin, String from) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(from, "from");
        Bundle bundle = new Bundle();
        bundle.putString("from", from);
        bundle.putString("id", id5);
        bundle.putString("uin", uin);
        return buildPageScheme(source, 11, bundle);
    }

    @Override // com.tencent.mobileqq.zplan.scheme.ISchemeApi
    public String buildInventoryScheme(ZootopiaSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("SceneType", 7);
        jSONObject.put("SubScene", jSONObject2);
        jSONObject.put("ViewType", 1);
        return buildAvatarSchemeUrl(source, 1, new Bundle(), jSONObject);
    }

    @Override // com.tencent.mobileqq.zplan.scheme.ISchemeApi
    public String buildMailScheme(ZootopiaSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("SceneType", 2);
        jSONObject.put("SubScene", jSONObject2);
        jSONObject.put("ViewType", 1);
        return buildAvatarSchemeUrl(source, 1, new Bundle(), jSONObject);
    }

    @Override // com.tencent.mobileqq.zplan.scheme.ISchemeApi
    public String buildMakeUpPageScheme(ZootopiaSource source, Bundle bundle) {
        Intrinsics.checkNotNullParameter(source, "source");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("SceneType", 1);
        jSONObject.put("SubScene", jSONObject2);
        jSONObject.put("ViewType", 1);
        if (bundle == null) {
            bundle = new Bundle();
        }
        return buildAvatarSchemeUrl(source, 1, bundle, jSONObject);
    }

    @Override // com.tencent.mobileqq.zplan.scheme.ISchemeApi
    public String buildMallScheme(ZootopiaSource source, int brandId) {
        Intrinsics.checkNotNullParameter(source, "source");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (brandId > 0) {
            jSONObject2.put("BrandId", brandId);
        }
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("SceneType", 1);
        jSONObject3.put("SceneParams", jSONObject2);
        jSONObject.put("SubScene", jSONObject3);
        jSONObject.put("ViewType", 1);
        return buildAvatarSchemeUrl(source, 1, new Bundle(), jSONObject);
    }

    @Override // com.tencent.mobileqq.zplan.scheme.ISchemeApi
    public String buildMapScheme(ZootopiaSource source, int mapId, Bundle bundle) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("mapId", mapId);
        return buildAvatarSchemeUrl(source, 7, bundle, xb4.b.f447772a.j(bundle));
    }

    @Override // com.tencent.mobileqq.zplan.scheme.ISchemeApi
    public String buildPageScheme(ZootopiaSource source, int pageId, Bundle bundle) {
        Intrinsics.checkNotNullParameter(source, "source");
        return buildPageSchemeUrl(source, pageId, bundle, xb4.b.f447772a.j(bundle));
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003d, code lost:
    
        r1 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0021, code lost:
    
        r1 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r1);
     */
    @Override // com.tencent.mobileqq.zplan.scheme.ISchemeApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String buildTransitPageScheme(ZootopiaSource source, TransitPageInfo info, Bundle ueData) {
        Long longOrNull;
        Long longOrNull2;
        Intrinsics.checkNotNullParameter(info, "info");
        if (source == null) {
            source = ZootopiaSource.INSTANCE.a(Source.H5);
        }
        Bundle bundle = new Bundle();
        String uin = info.getMasterInfo().getUin();
        long j3 = 0;
        long longValue = (uin == null || longOrNull2 == null) ? 0L : longOrNull2.longValue();
        bundle.putLong("uin", longValue);
        String groupId = info.getMasterInfo().getGroupId();
        if (groupId != null && longOrNull != null) {
            j3 = longOrNull.longValue();
        }
        bundle.putLong("groupId", j3);
        bundle.putInt(ISchemeApi.KEY_TRANSIT_TYPE, info.getConfig().getTransitType());
        bundle.putInt(ISchemeApi.KEY_NEED_TRANSIT_WHEN_READY, info.getConfig().getNeedTransitPageWhenReady());
        bundle.putInt("uiStyle", info.getConfig().getUiStyle());
        return buildAvatarSchemeUrl(source, 11, bundle, xb4.b.f447772a.g(ueData));
    }

    @Override // com.tencent.mobileqq.zplan.scheme.ISchemeApi
    public String buildTryOnSameStyleScheme(ZootopiaSource source, JSONObject params) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(params, "params");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("SceneType", 1);
        jSONObject2.put("SceneParams", params.get("SceneParams"));
        jSONObject.put("SubScene", jSONObject2);
        jSONObject.put("ViewType", 1);
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_need_gesture_back", false);
        return buildAvatarSchemeUrl(source, 1, bundle, jSONObject);
    }

    @Override // com.tencent.mobileqq.zplan.scheme.ISchemeApi
    public String convertSchemeToJsonForReport(String schemeUrl) {
        Intrinsics.checkNotNullParameter(schemeUrl, "schemeUrl");
        return xb4.b.f447772a.i(schemeUrl);
    }

    @Override // com.tencent.mobileqq.zplan.scheme.ISchemeApi
    public void handleFaceAdScheme(Context context, HashMap<String, String> params) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        String str = params.get("ad_id");
        if (str != null) {
            getAndShowBodyUpdateAd(Long.parseLong(str));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0025, code lost:
    
        r5 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r5);
     */
    @Override // com.tencent.mobileqq.zplan.scheme.ISchemeApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleOpenPageScheme(Context context, String url, HashMap<String, String> params) {
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(params, "params");
        String str = params.get(ISchemeApi.KEY_REFERER);
        int value = (str == null || intOrNull == null) ? Source.UnSet.getValue() : intOrNull.intValue();
        String str2 = params.get("subReferer");
        if (str2 == null) {
            str2 = "0";
        }
        String str3 = params.get(ISchemeApi.KEY_PAGE_ID);
        if (str3 == null) {
            str3 = params.get("pageId");
        }
        Integer intOrNull2 = str3 != null ? StringsKt__StringNumberConversionsKt.toIntOrNull(str3) : null;
        Source b16 = m.b(value);
        ZootopiaSource c16 = ZootopiaSource.INSTANCE.c(b16, str2, b16 == Source.UnSet ? ag.f373258a.b() : null);
        xb4.b bVar = xb4.b.f447772a;
        Bundle n3 = bVar.n(params.get(ISchemeApi.KEY_PAGE_DATA));
        if (n3 == null) {
            n3 = new Bundle();
        }
        Bundle n16 = bVar.n(params.get(ISchemeApi.KEY_SCENE_DATA));
        if (n16 == null) {
            n16 = new Bundle();
        }
        if (intOrNull2 != null && intOrNull2.intValue() == 1) {
            n3.putSerializable("detail_config", new ZootopiaDetailFragment.Config(0, false, false, n3.getBoolean(FavEmoConstant.ROAMING_TYPE_PANEL, false), null, null, false, DataConvertUtil.f329546a.c(n16), 119, null));
            ((IEntryApi) QRoute.api(IEntryApi.class)).startDetailFragment(context, c16, n3);
            return;
        }
        if (intOrNull2 != null && intOrNull2.intValue() == 2) {
            handleEnterSameStyleList(context, params, c16);
            return;
        }
        if (intOrNull2 != null && intOrNull2.intValue() == 3) {
            c.f335324a.h(n3, params, c16);
            return;
        }
        if (intOrNull2 != null && intOrNull2.intValue() == 4) {
            ((IEntryApi) QRoute.api(IEntryApi.class)).startMapListFragment(context, c16, n3);
            return;
        }
        if (intOrNull2 != null && intOrNull2.intValue() == 5) {
            ((IEntryApi) QRoute.api(IEntryApi.class)).startBrandListFragment(context, c16, n3);
            return;
        }
        if (intOrNull2 != null && intOrNull2.intValue() == 9) {
            handleEnterTaskPanel(context, c16, n3);
            return;
        }
        if (intOrNull2 != null && intOrNull2.intValue() == 11) {
            handleEnterDressDetail(context, c16, n3);
            return;
        }
        if (intOrNull2 != null && intOrNull2.intValue() == 6) {
            b.a.a((cl3.b) vb3.a.f441346a.a(cl3.b.class), context, null, n3, 2, null);
            return;
        }
        if (intOrNull2 != null && intOrNull2.intValue() == 7) {
            ((IEntryApi) QRoute.api(IEntryApi.class)).startCommonCardFeedsFragment(context, c16, n3);
            return;
        }
        if (intOrNull2 != null && intOrNull2.intValue() == 8) {
            hc4.a.f404730a.e(context, c16, n3);
            return;
        }
        if (intOrNull2 != null && intOrNull2.intValue() == 10) {
            ZPlanPublishApiImpl.f372397a.a(context, c16, ZPlanPublishSource.FROM_SCHEME, n3);
            return;
        }
        if (intOrNull2 != null && intOrNull2.intValue() == 12) {
            ((IEntryApi) QRoute.api(IEntryApi.class)).startCreateRoleFragment(context, c16, n3);
            return;
        }
        if (intOrNull2 != null && intOrNull2.intValue() == 13) {
            String backupUrl = n3.getString("backupUrl", "");
            if (backupUrl == null || backupUrl.length() == 0) {
                QLog.e(TAG, 1, "invalid bakupUrl page id: " + intOrNull2 + ", url=" + url);
                return;
            }
            String str4 = params.get(ISchemeApi.KEY_REFERER);
            if (str4 == null) {
                str4 = "";
            }
            String str5 = params.get(ISchemeApi.KEY_ENABLE_NEW_TASK);
            String str6 = str5 != null ? str5 : "";
            IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
            Intrinsics.checkNotNullExpressionValue(backupUrl, "backupUrl");
            iZPlanApi.openZPlanAvatarPicEditPageWithWhiteListCheck(context, str4, backupUrl, str6);
            return;
        }
        if (intOrNull2 != null && intOrNull2.intValue() == 14) {
            int i3 = n3.getInt("tabType");
            String string = n3.getString("uin");
            if (string == null) {
                string = w.f373306a.b();
            }
            String str7 = string;
            Intrinsics.checkNotNullExpressionValue(str7, "pageData.getString(\"uin\") ?: UinUtils.getSelfUin()");
            QRouteApi api = QRoute.api(IEntryApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IEntryApi::class.java)");
            IEntryApi.a.a((IEntryApi) api, context, c16, str7, i3, null, 16, null);
            return;
        }
        if (intOrNull2 != null && intOrNull2.intValue() == 15) {
            String str8 = params.get("sceneType");
            Integer intOrNull3 = str8 != null ? StringsKt__StringNumberConversionsKt.toIntOrNull(str8) : null;
            if (intOrNull3 != null) {
                n16.putInt("sceneType", intOrNull3.intValue());
            }
            n3.putBundle("ueParams", n16);
            ((IEntryApi) QRoute.api(IEntryApi.class)).startUEWithHippyFragment(context, c16, n3);
            return;
        }
        if (intOrNull2 != null && intOrNull2.intValue() == 16) {
            String str9 = params.get("friend_uin");
            if (str9 != null) {
                n3.putLong("friend_uin", Long.parseLong(str9));
            }
            ((IEntryApi) QRoute.api(IEntryApi.class)).startFriendsDressUpFragment(context, c16, n3);
            return;
        }
        if (intOrNull2 != null && intOrNull2.intValue() == 17) {
            ((IEntryApi) QRoute.api(IEntryApi.class)).startDownloadManagerFragment(context, c16, n3);
            return;
        }
        if (intOrNull2 != null && intOrNull2.intValue() == 18) {
            ((IEntryApi) QRoute.api(IEntryApi.class)).startAIGCCreationPage(context, c16, n3);
            return;
        }
        if (intOrNull2 != null && intOrNull2.intValue() == 19) {
            ((IEntryApi) QRoute.api(IEntryApi.class)).startAigcPreviewActivity(context, c16, null, params.get("localUgcPaths"));
            return;
        }
        if (intOrNull2 != null && intOrNull2.intValue() == 20) {
            ((IEntryApi) QRoute.api(IEntryApi.class)).startAvatarOutfitFragment(context, c16, n3);
            return;
        }
        if (intOrNull2 != null && intOrNull2.intValue() == 21) {
            ((IEntryApi) QRoute.api(IEntryApi.class)).startSuitCustomColorFragment(context, c16, n3);
            return;
        }
        QLog.e(TAG, 1, "unknown page id: " + intOrNull2 + ", url=" + url);
    }

    @Override // com.tencent.mobileqq.zplan.scheme.ISchemeApi
    public void handleThirdAuthCallback(Context context, HashMap<String, String> params) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        String str = params.get("thirdType");
        String str2 = params.get("p");
        QLog.i(TAG, 1, "handleThirdAuthCallback :: thirdType == " + str + " , p == " + str2);
        if (!(str == null || str.length() == 0)) {
            if (!(str2 == null || str2.length() == 0)) {
                pe3.a.f426058a.d(str, str2);
                return;
            }
        }
        QLog.e(TAG, 1, "handleThirdAuthCallback :: thirdType or p is null");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0041, code lost:
    
        r6 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0052, code lost:
    
        if (r6 != 2) goto L24;
     */
    @Override // com.tencent.mobileqq.zplan.scheme.ISchemeApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleToastScheme(Context context, HashMap<String, String> params) {
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        String str = params.get("msg");
        int i3 = 1;
        if (str == null || str.length() == 0) {
            QLog.e(TAG, 1, "msg is empty");
            return;
        }
        String decode = URLDecoder.decode(str, "UTF-8");
        String str2 = params.get("mode");
        int intValue = (str2 == null || intOrNull == null) ? 0 : intOrNull.intValue();
        if (intValue != 0) {
            if (intValue == 1) {
                i3 = 2;
            }
            QQToast.makeText(context, i3, decode, 0).show();
        }
        i3 = 0;
        QQToast.makeText(context, i3, decode, 0).show();
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0021, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r0);
     */
    @Override // com.tencent.mobileqq.zplan.scheme.ISchemeApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleZplanThirdScheme(Context context, HashMap<String, String> params) {
        int value;
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        QLog.i(TAG, 1, "handleZplanThirdScheme");
        String str = params.get(ISchemeApi.KEY_REFERER);
        if (str != null && intOrNull != null) {
            value = intOrNull.intValue();
        } else {
            value = Source.UnSet.getValue();
        }
        String str2 = params.get("subReferer");
        if (str2 == null) {
            str2 = "0";
        }
        ZootopiaSource d16 = ZootopiaSource.Companion.d(ZootopiaSource.INSTANCE, m.b(value), str2, null, 4, null);
        Bundle n3 = xb4.b.f447772a.n(params.get(ISchemeApi.KEY_PAGE_DATA));
        if (n3 == null) {
            n3 = new Bundle();
        }
        String str3 = params.get("thirdId");
        if (str3 != null) {
            n3.putString("thirdId", str3);
        }
        String str4 = params.get("thirdJump");
        if (str4 != null) {
            n3.putString("thirdJump", str4);
        }
        ((IEntryApi) QRoute.api(IEntryApi.class)).startThirdPage(context, d16, n3);
    }

    @Override // com.tencent.mobileqq.zplan.scheme.ISchemeApi
    public void launchScheme(Context context, String schemeUrl) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(schemeUrl, "schemeUrl");
        Iterator<T> it = this.mListenerPool.iterator();
        while (it.hasNext()) {
            ((mk3.a) it.next()).b(schemeUrl);
        }
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).launchSchemeWithContext(context, schemeUrl);
        QLog.i(TAG, 1, "launchScheme :: scheme == " + schemeUrl);
        Iterator<T> it5 = this.mListenerPool.iterator();
        while (it5.hasNext()) {
            ((mk3.a) it5.next()).a(schemeUrl);
        }
    }

    @Override // com.tencent.mobileqq.zplan.scheme.ISchemeApi
    public JumpParserResult parseUrl(String schemeUrl) {
        Intrinsics.checkNotNullParameter(schemeUrl, "schemeUrl");
        return ax.e(schemeUrl);
    }

    @Override // com.tencent.mobileqq.zplan.scheme.ISchemeApi
    public synchronized void registerSchemeHandleListener(mk3.a l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        this.mListenerPool.add(l3);
    }

    @Override // com.tencent.mobileqq.zplan.scheme.ISchemeApi
    public synchronized void removeSchemeHandleListener(mk3.a l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        this.mListenerPool.remove(l3);
    }

    @Override // com.tencent.mobileqq.zplan.scheme.ISchemeApi
    public boolean shouldInterceptWebToNative(Context context, String url) {
        JSONObject o16;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        QLog.i(TAG, 1, "interceptWeb to native " + (QLog.isColorLevel() ? url : s.d(url, new String[0])));
        try {
            Uri parse = Uri.parse(url);
            if (INSTANCE.a(context, url)) {
                return true;
            }
            String queryParameter = parse.getQueryParameter("intercept2native");
            if (queryParameter == null || (o16 = ZPlanFeatureSwitch.f369852a.o1()) == null) {
                return false;
            }
            QLog.d(TAG, 1, "config => " + o16);
            String redirectScheme = o16.optString(queryParameter);
            Intrinsics.checkNotNullExpressionValue(redirectScheme, "redirectScheme");
            if (redirectScheme.length() == 0) {
                return false;
            }
            String queryParameter2 = parse.getQueryParameter("replaceSchemeHolder");
            if (queryParameter2 != null) {
                if (queryParameter2.length() > 0) {
                    redirectScheme = redirectScheme + queryParameter2;
                }
            }
            Intrinsics.checkNotNullExpressionValue(redirectScheme, "redirectScheme");
            launchScheme(context, redirectScheme);
            return true;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "interceptWebToNative error ", e16);
            return false;
        }
    }

    private final String buildAvatarSchemeUrl(ZootopiaSource source, int sceneType, Bundle pageData, JSONObject ueData) {
        Map<String, Object> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(ISchemeApi.KEY_REFERER, Integer.valueOf(source.getMainSource().getValue())), TuplesKt.to("subReferer", source.getSubSource()), TuplesKt.to("sceneType", Integer.valueOf(sceneType)));
        if (pageData != null) {
            mutableMapOf.put(ISchemeApi.KEY_PAGE_DATA, xb4.b.f447772a.h(pageData));
        }
        if (ueData != null) {
            mutableMapOf.put(ISchemeApi.KEY_SCENE_DATA, xb4.b.f447772a.o(ueData));
        }
        return buildSchemeUrl(ISchemeApi.SCHEME_ENTER_AVATAR, mutableMapOf);
    }

    private final String buildPageSchemeUrl(ZootopiaSource source, int pageId, Bundle pageData, JSONObject ueData) {
        Map<String, Object> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(ISchemeApi.KEY_REFERER, Integer.valueOf(source.getMainSource().getValue())), TuplesKt.to("subReferer", source.getSubSource()), TuplesKt.to(ISchemeApi.KEY_PAGE_ID, Integer.valueOf(pageId)));
        if (pageData != null) {
            mutableMapOf.put(ISchemeApi.KEY_PAGE_DATA, xb4.b.f447772a.h(pageData));
        }
        if (ueData != null) {
            mutableMapOf.put(ISchemeApi.KEY_SCENE_DATA, xb4.b.f447772a.o(ueData));
        }
        return buildSchemeUrl(ISchemeApi.SCHEME_OPEN_PAGE, mutableMapOf);
    }

    private final void getAndShowBodyUpdateAd(long faceId) {
        QLog.i(TAG, 1, "getAndShowBodyUpdateAd");
        nw4.a aVar = new nw4.a();
        aVar.f421462a = faceId;
        ij3.a.b(ij3.a.f407869a, aVar, new b(), 0, 4, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0024, code lost:
    
        r2 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r2);
     */
    @Override // com.tencent.mobileqq.zplan.scheme.ISchemeApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleEnterAvatarScheme(Context context, String url, HashMap<String, String> params) {
        int value;
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(params, "params");
        String str = params.get(ISchemeApi.KEY_REFERER);
        if (str != null && intOrNull != null) {
            value = intOrNull.intValue();
        } else {
            value = Source.UnSet.getValue();
        }
        String str2 = params.get("subReferer");
        if (str2 == null) {
            str2 = "0";
        }
        String str3 = str2;
        String str4 = params.get("sceneType");
        Integer intOrNull2 = str4 != null ? StringsKt__StringNumberConversionsKt.toIntOrNull(str4) : null;
        ZootopiaSource d16 = ZootopiaSource.Companion.d(ZootopiaSource.INSTANCE, m.b(value), str3, null, 4, null);
        xb4.b bVar = xb4.b.f447772a;
        Bundle n3 = bVar.n(params.get(ISchemeApi.KEY_PAGE_DATA));
        if (n3 == null) {
            n3 = new Bundle();
        }
        Bundle n16 = bVar.n(params.get(ISchemeApi.KEY_SCENE_DATA));
        if (n16 != null) {
            if (intOrNull2 != null) {
                n16.putInt("sceneType", intOrNull2.intValue());
            }
            n3.putBundle("ueParams", n16);
        }
        if (n16 == null) {
            n16 = new Bundle();
            n16.putBoolean("skipRedirect", n3.getBoolean("skipRedirect", false));
        }
        bVar.b(d16, intOrNull2, n3.getInt("mapId"));
        bVar.c(d16, intOrNull2);
        if (intOrNull2 != null && intOrNull2.intValue() == 1) {
            handleEnterPortal(d16, context, n3, n16);
        } else if ((intOrNull2 != null && intOrNull2.intValue() == 7) || (intOrNull2 != null && intOrNull2.intValue() == 6)) {
            boolean z16 = n3.getBoolean("isCloudMod", false);
            int i3 = n3.getInt("mapId");
            if (z16) {
                ((IEntryApi) QRoute.api(IEntryApi.class)).startCloudModFragment(context, d16, i3, n3, n16);
            } else {
                ((com.tencent.mobileqq.zplan.authorize.impl.helper.e) i.INSTANCE.a(com.tencent.mobileqq.zplan.authorize.impl.helper.e.class)).saveScheme(i3, url);
                ((IEntryApi) QRoute.api(IEntryApi.class)).startMapWithDetail(context, i3, d16, n3, n16);
            }
        } else if (intOrNull2 != null && intOrNull2.intValue() == 10) {
            ((IEntryApi) QRoute.api(IEntryApi.class)).startProfileCustomerFragment(context, d16, n3);
        } else if (intOrNull2 != null && intOrNull2.intValue() == 11) {
            openSmallHomeWithTransitPage(context, d16, n3, n16);
        } else if (intOrNull2 != null && intOrNull2.intValue() == 25) {
            ((IEntryApi) QRoute.api(IEntryApi.class)).startSeparateSceneFragment(context, d16, n3);
        } else if (intOrNull2 != null && intOrNull2.intValue() == 100) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                n3.putString(entry.getKey(), entry.getValue());
            }
            ZPlanMiniHomeConnectedFragment.INSTANCE.c(context, d16, n3);
        } else {
            QLog.i(TAG, 1, "unknown scene type: " + intOrNull2 + ", url=" + url);
        }
        xb4.b.f447772a.l(context, params.get(ISchemeApi.KEY_SUB_SCHEME));
    }

    @Override // com.tencent.mobileqq.zplan.scheme.ISchemeApi
    public String buildMallScheme(ZootopiaSource source, long clothesId) {
        Intrinsics.checkNotNullParameter(source, "source");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (clothesId > 0) {
            jSONObject2.put("ClothesId", clothesId);
        }
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("SceneType", 1);
        jSONObject3.put("SceneParams", jSONObject2);
        jSONObject.put("SubScene", jSONObject3);
        jSONObject.put("ViewType", 1);
        return buildAvatarSchemeUrl(source, 1, new Bundle(), jSONObject);
    }
}
