package com.tencent.mobileqq.zplan.persistent;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zootopia.utils.DataConvertUtil;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.couple.config.ZPlanCoupleAvatarProfileInfo;
import com.tencent.mobileqq.zplan.model.AccessibleDetail;
import com.tencent.mobileqq.zplan.model.ZPlanUserInfo;
import com.tencent.mobileqq.zplan.servlet.ZPlanRequest;
import com.tencent.mobileqq.zplan.servlet.ZPlanUserInfoRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.state.data.SquareJSConst;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import ji3.g;
import ji3.i;
import ji3.j;
import ji3.k;
import ji3.m;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import nk3.p;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ac\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b[\u0010\\J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0016\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bJ \u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u000fJ\u0016\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0011J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000bJ \u0010\u0019\u001a\u00020\u00042\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0018J\u0018\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u000bJ(\u0010#\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 2\b\b\u0002\u0010\"\u001a\u00020\u000bJ\"\u0010$\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u001e2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 J\u000e\u0010%\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0016J&\u0010)\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u001eJ\u0016\u0010*\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u0016J\u0016\u0010+\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u0006J\u0016\u0010,\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\u001eJ\u0018\u0010/\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00162\b\u0010.\u001a\u0004\u0018\u00010-J\u0010\u00100\u001a\u0004\u0018\u00010-2\u0006\u0010\u001a\u001a\u00020\u0016J\u001e\u00102\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u000201J\u001e\u00104\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u000203J\u0010\u00105\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001a\u001a\u00020\u0016J\u000e\u00108\u001a\u00020\u00042\u0006\u00107\u001a\u000206J\u0010\u0010:\u001a\u0004\u0018\u0001062\u0006\u00109\u001a\u00020\u0006J\u0018\u0010;\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J*\u0010<\u001a\u00020\u00042\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u001f\u001a\u00020\u001e2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0018H\u0002J \u0010=\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u000201H\u0002J\u0018\u0010?\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010>\u001a\u00020\u001cH\u0002J\u001c\u0010B\u001a\u00020\u00042\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001c0@H\u0002J\u0016\u0010E\u001a\u00020\u00042\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u001c0CH\u0002J\u0010\u0010F\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020\u001cH\u0002J\u0012\u0010G\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001a\u001a\u00020\u0016H\u0002R \u0010K\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001c0H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010O\u001a\u0004\u0018\u00010L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u001e\u0010S\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR(\u0010U\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0P0H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010JR\u001e\u0010V\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010RR\u0018\u0010Y\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010XR\u001e\u0010Z\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010R\u00a8\u0006]"}, d2 = {"Lcom/tencent/mobileqq/zplan/persistent/ZplanDataRepository;", "", "Lcom/tencent/common/app/AppInterface;", "app", "", "u", "", "scene", "Lji3/m;", "listener", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "isSwitchOn", "p", "appInterface", "Lji3/k;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lji3/j;", BdhLogUtil.LogTag.Tag_Conn, "qzoneSwitch", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "", SquareJSConst.Params.PARAMS_UIN_LIST, "Lcom/tencent/mobileqq/zplan/servlet/d;", "w", "uin", "forceFromDb", "Lcom/tencent/mobileqq/zplan/model/ZPlanUserInfo;", "j", "", "serviceType", "Lji3/g;", "callback", "needNetReq", "k", "o", "r", "appearanceKey", PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "gender", "G", UserInfo.SEX_FEMALE, "H", "I", "Lcom/tencent/mobileqq/zplan/model/g;", "bgInfo", "y", "i", "Lji3/f;", h.F, "Lji3/a;", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/zplan/couple/config/ZPlanCoupleAvatarProfileInfo;", "zplanCoupleProfileInfo", "D", "friendUin", "g", ReportConstant.COSTREPORT_PREFIX, "v", "t", "zPlanUserInfo", "J", "", "data", "B", "", "entities", "L", "K", DomainData.DOMAIN_NAME, "Ljava/util/concurrent/ConcurrentHashMap;", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "mUserInfoCache", "Lcom/tencent/mobileqq/zplan/persistent/b;", "c", "Lcom/tencent/mobileqq/zplan/persistent/b;", "mEntityManagerFacade", "Ljava/lang/ref/SoftReference;", "d", "Ljava/lang/ref/SoftReference;", "mSettingChangeListener", "e", "mSettingChangeListenerMap", "mAppInterface", "Lji3/i;", "Lji3/i;", "mZPlanAccessibleObserver", "mZPlanShowStateChangeListener", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZplanDataRepository {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static SoftReference<k> mSettingChangeListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static SoftReference<AppInterface> mAppInterface;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static i mZPlanAccessibleObserver;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static SoftReference<j> mZPlanShowStateChangeListener;

    /* renamed from: a, reason: collision with root package name */
    public static final ZplanDataRepository f334898a = new ZplanDataRepository();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, ZPlanUserInfo> mUserInfoCache = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final com.tencent.mobileqq.zplan.persistent.b mEntityManagerFacade = com.tencent.mobileqq.zplan.persistent.b.INSTANCE.a();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static ConcurrentHashMap<Long, SoftReference<m>> mSettingChangeListenerMap = new ConcurrentHashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/persistent/ZplanDataRepository$a", "Lji3/f;", "", "success", "Lorg/json/JSONObject;", "result", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements ji3.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ji3.a f334906a;

        a(ji3.a aVar) {
            this.f334906a = aVar;
        }

        @Override // ji3.f
        public void a(boolean success, JSONObject result) {
            if (success && result != null) {
                int optInt = result.optInt("character_change_ts", -1);
                QLog.i("[zplan][ZPlanDataRepository]", 1, "checkAppearanceChanged chgCount: " + optInt);
                this.f334906a.a(true, optInt > 0);
                return;
            }
            QLog.e("[zplan][ZPlanDataRepository]", 1, "checkAppearanceEverChanged failed, success: " + success + ", result: " + (result != null ? result.toString() : null));
            this.f334906a.a(false, false);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/persistent/ZplanDataRepository$b", "Lcom/tencent/mobileqq/zplan/servlet/d;", "", "success", "", "result", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mobileqq.zplan.servlet.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f334907a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f334908b;

        b(g gVar, String str) {
            this.f334907a = gVar;
            this.f334908b = str;
        }

        @Override // com.tencent.mobileqq.zplan.servlet.d
        public void a(boolean success, Object result) {
            QLog.i("[zplan][ZPlanDataRepository]", 1, "requestUserInfo onResp, success: " + success);
            if (!success) {
                g gVar = this.f334907a;
                if (gVar != null) {
                    gVar.a(false, null);
                    return;
                }
                return;
            }
            if (result != null) {
                Map map = (Map) result;
                g gVar2 = this.f334907a;
                if (gVar2 != null) {
                    gVar2.a(true, (ZPlanUserInfo) map.get(this.f334908b));
                    return;
                }
                return;
            }
            g gVar3 = this.f334907a;
            if (gVar3 != null) {
                gVar3.a(true, null);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/persistent/ZplanDataRepository$e", "Lcom/tencent/mobileqq/zplan/servlet/d;", "", "success", "", "result", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e implements com.tencent.mobileqq.zplan.servlet.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zplan.servlet.d f334910a;

        e(com.tencent.mobileqq.zplan.servlet.d dVar) {
            this.f334910a = dVar;
        }

        @Override // com.tencent.mobileqq.zplan.servlet.d
        public void a(boolean success, Object result) {
            QLog.i("[zplan][ZPlanDataRepository]", 1, "requestUserInfo onResp, success: " + success);
            if (success && result != null) {
                Map map = (Map) result;
                ZplanDataRepository zplanDataRepository = ZplanDataRepository.f334898a;
                zplanDataRepository.L(map.values());
                zplanDataRepository.B(map);
            }
            com.tencent.mobileqq.zplan.servlet.d dVar = this.f334910a;
            if (dVar != null) {
                dVar.a(success, result);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/persistent/ZplanDataRepository$f", "Lcom/tencent/mobileqq/zplan/servlet/d;", "", "success", "", "result", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class f implements com.tencent.mobileqq.zplan.servlet.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zplan.servlet.d f334911a;

        f(com.tencent.mobileqq.zplan.servlet.d dVar) {
            this.f334911a = dVar;
        }

        @Override // com.tencent.mobileqq.zplan.servlet.d
        public void a(boolean success, Object result) {
            QLog.i("[zplan][ZPlanDataRepository]", 1, "requestUserInfo onResp, success: " + success);
            if (success && result != null) {
                Map map = (Map) result;
                ZplanDataRepository zplanDataRepository = ZplanDataRepository.f334898a;
                zplanDataRepository.L(map.values());
                zplanDataRepository.B(map);
            }
            com.tencent.mobileqq.zplan.servlet.d dVar = this.f334911a;
            if (dVar != null) {
                dVar.a(success, result);
            }
        }
    }

    ZplanDataRepository() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(Map<String, ZPlanUserInfo> data) {
        mUserInfoCache.putAll(data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(ZPlanCoupleAvatarProfileInfo zplanCoupleProfileInfo) {
        Intrinsics.checkNotNullParameter(zplanCoupleProfileInfo, "$zplanCoupleProfileInfo");
        com.tencent.mobileqq.zplan.persistent.b bVar = mEntityManagerFacade;
        if (bVar != null) {
            bVar.e(zplanCoupleProfileInfo);
        }
    }

    private final void J(String uin, ZPlanUserInfo zPlanUserInfo) {
        mUserInfoCache.put(uin, zPlanUserInfo);
    }

    private final synchronized boolean K(ZPlanUserInfo zPlanUserInfo) {
        com.tencent.mobileqq.zplan.persistent.b bVar;
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).saveAppearanceKeyToMMKV(zPlanUserInfo.uin, zPlanUserInfo.appearanceKey);
        bVar = mEntityManagerFacade;
        return bVar != null ? bVar.e(zPlanUserInfo) : false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void L(Collection<ZPlanUserInfo> entities) {
        for (ZPlanUserInfo zPlanUserInfo : entities) {
            ((IZPlanApi) QRoute.api(IZPlanApi.class)).saveAppearanceKeyToMMKV(zPlanUserInfo.uin, zPlanUserInfo.appearanceKey);
        }
        com.tencent.mobileqq.zplan.persistent.b bVar = mEntityManagerFacade;
        if (bVar != null) {
            bVar.d(entities);
        }
    }

    private final synchronized ZPlanUserInfo n(String uin) {
        com.tencent.mobileqq.zplan.persistent.b bVar;
        bVar = mEntityManagerFacade;
        return (ZPlanUserInfo) (bVar != null ? bVar.b(ZPlanUserInfo.class, "uin = ?", new String[]{uin}) : null);
    }

    private final void s(AppInterface appInterface, long scene) {
        QLog.i("[zplan][ZPlanDataRepository]", 1, "registerZplanAccessibleListener, scene=" + scene);
        if (mZPlanAccessibleObserver != null) {
            return;
        }
        mAppInterface = new SoftReference<>(appInterface);
        mZPlanAccessibleObserver = new c();
        uk3.g.f439121a.d(scene, mZPlanAccessibleObserver);
    }

    private final void t(long uin, int serviceType, ji3.f callback) {
        List<com.tencent.mobileqq.zplan.model.c> mutableListOf;
        QLog.i("[zplan][ZPlanDataRepository]", 1, "start requestAppearanceChangeInfo, serviceType: " + serviceType);
        ZPlanUserInfoRequest zPlanUserInfoRequest = ZPlanUserInfoRequest.f335380a;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new com.tencent.mobileqq.zplan.model.c(19, 1));
        zPlanUserInfoRequest.q(mutableListOf, uin, serviceType, new d(callback));
    }

    private final void v(List<String> uinList, int serviceType, com.tencent.mobileqq.zplan.servlet.d listener) {
        if (uinList.isEmpty()) {
            QLog.e("[zplan][ZPlanDataRepository]", 1, "requestUserInfo uinList is empty");
        } else {
            ZPlanRequest.f335367a.j(uinList, serviceType, new f(listener));
        }
    }

    public final void A(long scene, m listener) {
        QLog.i("[zplan][ZPlanDataRepository]", 1, "setOnZPlanSettingChangeListener: " + scene + ", " + listener);
        if (listener == null) {
            return;
        }
        mSettingChangeListenerMap.put(Long.valueOf(scene), new SoftReference<>(listener));
    }

    public final void C(long scene, j listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        QLog.i("[zplan][ZPlanDataRepository]", 2, "setZPlanShowStateChangeListener, scene = " + scene);
        mZPlanShowStateChangeListener = new SoftReference<>(listener);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        s((AppInterface) peekAppRuntime, scene);
    }

    public final synchronized void D(final ZPlanCoupleAvatarProfileInfo zplanCoupleProfileInfo) {
        Intrinsics.checkNotNullParameter(zplanCoupleProfileInfo, "zplanCoupleProfileInfo");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.persistent.d
            @Override // java.lang.Runnable
            public final void run() {
                ZplanDataRepository.E(ZPlanCoupleAvatarProfileInfo.this);
            }
        }, 32, null, true);
    }

    public final void F(String uin, String appearanceKey) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(appearanceKey, "appearanceKey");
        l(this, uin, false, 2, null).appearanceKey = appearanceKey;
    }

    public final void G(String uin, String appearanceKey, long timeStamp, int gender) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(appearanceKey, "appearanceKey");
        ZPlanUserInfo zPlanUserInfo = new ZPlanUserInfo(uin, appearanceKey, timeStamp, gender);
        J(uin, zPlanUserInfo);
        K(zPlanUserInfo);
    }

    public final void H(String uin, long timeStamp) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        l(this, uin, false, 2, null).appearanceTimeStamp = timeStamp;
    }

    public final void I(String uin, int gender) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        l(this, uin, false, 2, null).gender = gender;
    }

    public final void f(long uin, int serviceType, ji3.a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        t(uin, serviceType, new a(callback));
    }

    public final synchronized ZPlanCoupleAvatarProfileInfo g(long friendUin) {
        com.tencent.mobileqq.zplan.persistent.b bVar;
        bVar = mEntityManagerFacade;
        return (ZPlanCoupleAvatarProfileInfo) (bVar != null ? bVar.b(ZPlanCoupleAvatarProfileInfo.class, "uin = ?", new String[]{String.valueOf(friendUin)}) : null);
    }

    public final void h(long uin, int serviceType, ji3.f callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        t(uin, serviceType, callback);
    }

    public final com.tencent.mobileqq.zplan.model.g i(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        try {
            String string = ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getString(uin + "_zplan_background_info", "");
            com.tencent.mobileqq.zplan.model.g gVar = (com.tencent.mobileqq.zplan.model.g) DataConvertUtil.f329546a.a().fromJson(string, com.tencent.mobileqq.zplan.model.g.class);
            QLog.i("[zplan][ZPlanDataRepository]", 1, "getUserBackgroundInfo, json=" + string);
            return gVar;
        } catch (JsonSyntaxException e16) {
            QLog.e("[zplan][ZPlanDataRepository]", 1, "getUserBackgroundInfo, error", e16);
            return null;
        } catch (Exception e17) {
            QLog.e("[zplan][ZPlanDataRepository]", 1, "getUserBackgroundInfo, error", e17);
            return null;
        }
    }

    public final ZPlanUserInfo j(String uin, boolean forceFromDb) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        ZPlanUserInfo m3 = forceFromDb ? null : m(uin);
        if (m3 != null) {
            return m3;
        }
        ZPlanUserInfo n3 = n(uin);
        if (n3 != null) {
            J(uin, n3);
            return n3;
        }
        ZPlanUserInfo zPlanUserInfo = new ZPlanUserInfo(uin, null, 0L, 0, 14, null);
        J(uin, zPlanUserInfo);
        return zPlanUserInfo;
    }

    public final void k(String uin, int serviceType, g callback, boolean needNetReq) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ZPlanUserInfo m3 = m(uin);
        if (m3 != null) {
            callback.a(true, m3);
            return;
        }
        ZPlanUserInfo n3 = n(uin);
        if (n3 != null) {
            J(uin, n3);
            callback.a(true, n3);
        } else if (needNetReq) {
            o(uin, serviceType, callback);
        } else {
            callback.a(false, null);
        }
    }

    public final ZPlanUserInfo m(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return mUserInfoCache.get(uin);
    }

    public final void o(String uin, int serviceType, g callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        ArrayList arrayList = new ArrayList();
        arrayList.add(uin);
        v(arrayList, serviceType, new b(callback, uin));
    }

    public final void p(long scene, boolean isSwitchOn) {
        QLog.i("[zplan][ZPlanDataRepository]", 1, "notifySwitchChange, scene=" + scene + ", isSwitchOn:" + isSwitchOn);
        SoftReference<m> softReference = mSettingChangeListenerMap.get(Long.valueOf(scene));
        m mVar = softReference != null ? softReference.get() : null;
        if (mVar != null) {
            mVar.onChange(isSwitchOn);
        }
    }

    public final void q(boolean qzoneSwitch) {
        QLog.i("[zplan][ZPlanDataRepository]", 1, "notifyViewChange, qzoneSwitch=" + qzoneSwitch);
        SoftReference<k> softReference = mSettingChangeListener;
        k kVar = softReference != null ? softReference.get() : null;
        if (kVar != null) {
            kVar.onChange(qzoneSwitch);
        }
    }

    public final boolean r(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        ZPlanUserInfo m3 = m(uin);
        if (m3 == null || mEntityManagerFacade == null) {
            return false;
        }
        return K(m3);
    }

    public final void u(AppInterface app) {
        Intrinsics.checkNotNullParameter(app, "app");
        com.tencent.mobileqq.zplan.setting.e.f335451a.b(app, new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.persistent.ZplanDataRepository$requestSettingConfig$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ConcurrentHashMap concurrentHashMap;
                QLog.i("[zplan][ZPlanDataRepository]", 1, "requestSettingConfig callback");
                concurrentHashMap = ZplanDataRepository.mSettingChangeListenerMap;
                Iterator it = concurrentHashMap.values().iterator();
                while (it.hasNext()) {
                    m mVar = (m) ((SoftReference) it.next()).get();
                    if (mVar != null) {
                        mVar.a();
                    }
                }
            }
        });
    }

    public final void w(List<String> uinList, com.tencent.mobileqq.zplan.servlet.d listener) {
        Intrinsics.checkNotNullParameter(uinList, "uinList");
        if (uinList.isEmpty()) {
            return;
        }
        ZPlanRequest.f335367a.k(uinList, new e(listener));
    }

    public final void y(String uin, com.tencent.mobileqq.zplan.model.g bgInfo) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Gson gson = new Gson();
        Object obj = bgInfo;
        if (bgInfo == null) {
            obj = "";
        }
        String json = gson.toJson(obj);
        Intrinsics.checkNotNullExpressionValue(json, "json");
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setString(uin + "_zplan_background_info", json);
        QLog.i("[zplan][ZPlanDataRepository]", 1, "saveUserBackgroundInfo, json=" + json);
    }

    public final void z(AppInterface appInterface, long scene, k listener) {
        Intrinsics.checkNotNullParameter(appInterface, "appInterface");
        QLog.i("[zplan][ZPlanDataRepository]", 1, "setOnSettingPageExitListener: " + listener);
        mSettingChangeListener = listener == null ? null : new SoftReference<>(listener);
        s(appInterface, scene);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/persistent/ZplanDataRepository$c", "Lji3/i;", "Lcom/tencent/mobileqq/zplan/model/AccessibleDetail;", "detail", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements i {
        c() {
        }

        @Override // ji3.i
        public void a(AccessibleDetail detail) {
            boolean z16;
            j jVar;
            if (detail != null) {
                z16 = detail.isAccessible();
                SoftReference softReference = ZplanDataRepository.mZPlanShowStateChangeListener;
                if (softReference != null && (jVar = (j) softReference.get()) != null) {
                    jVar.a(detail);
                }
            } else {
                z16 = false;
            }
            ZplanDataRepository.f334898a.q(z16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/persistent/ZplanDataRepository$d", "Lnk3/p;", "", "", "", "infoList", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements p {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ji3.f f334909a;

        d(ji3.f fVar) {
            this.f334909a = fVar;
        }

        @Override // nk3.p
        public void a(Map<Integer, String> infoList) {
            JSONObject jSONObject = null;
            if (infoList == null || infoList.isEmpty()) {
                QLog.e("[zplan][ZPlanDataRepository]", 1, "requestAppearanceChangeInfo failed, infoList null or empty.");
                this.f334909a.a(false, null);
                return;
            }
            String str = infoList.get(19);
            if (str != null) {
                try {
                    jSONObject = new JSONObject(str);
                } catch (Throwable th5) {
                    QLog.e("[zplan][ZPlanDataRepository]", 1, "requestAppearanceChangeInfo failed.", th5);
                }
            }
            QLog.i("[zplan][ZPlanDataRepository]", 1, "requestAppearanceChangeInfo success, info: " + str);
            this.f334909a.a(true, jSONObject);
        }
    }

    public static /* synthetic */ ZPlanUserInfo l(ZplanDataRepository zplanDataRepository, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return zplanDataRepository.j(str, z16);
    }

    public static /* synthetic */ void x(ZplanDataRepository zplanDataRepository, List list, com.tencent.mobileqq.zplan.servlet.d dVar, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            dVar = null;
        }
        zplanDataRepository.w(list, dVar);
    }
}
