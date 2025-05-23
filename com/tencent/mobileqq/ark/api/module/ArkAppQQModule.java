package com.tencent.mobileqq.ark.api.module;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.google.gson.Gson;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ad.tangram.downloader.AdDownloadConstants;
import com.tencent.aio.data.AIOContact;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.Constants;
import com.tencent.ark.aio.BaseArkAppContainer;
import com.tencent.ark.ark;
import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.ark.open.ArkAppInfo;
import com.tencent.ark.open.security.ArkAppUrlChecker;
import com.tencent.biz.pubaccount.api.IPublicAccountReport;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.subscribe.utils.j;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.albumlogicImp.AlbumListCustomizationArk;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationArk;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationArk;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.ark.api.IArkAPIService;
import com.tencent.mobileqq.ark.api.IArkConfig;
import com.tencent.mobileqq.ark.api.IArkEnvironment;
import com.tencent.mobileqq.ark.api.IArkModuleAPIAuthority;
import com.tencent.mobileqq.ark.api.IArkQQApi;
import com.tencent.mobileqq.ark.api.IArkSecureReport;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.ark.api.module.a;
import com.tencent.mobileqq.ark.api.module.method.MethodSendMessage;
import com.tencent.mobileqq.ark.api.silk.ArkSilkAudioPlayerWrapper;
import com.tencent.mobileqq.ark.component.ArkAppLocationManager;
import com.tencent.mobileqq.data.ArkMsgUtils;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.troop.announcement.api.ITroopAnnouncementHelperApi;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUIApi;
import com.tencent.mobileqq.utils.QQCustomArkDialog;
import com.tencent.mobileqq.utils.QQCustomArkDialogForAio;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.ak;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.util.o;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqmini.sdk.core.ReportConst;
import com.tencent.qqnt.aio.msg.api.IAIOMsgItemApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qzonehub.api.utils.IQZoneGroupAlbumArkUtil;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import j91.a;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@KeepClassConstructor
/* loaded from: classes11.dex */
public class ArkAppQQModule extends ArkAppQQModuleBase {

    /* renamed from: r, reason: collision with root package name */
    private static long f198964r;

    /* renamed from: s, reason: collision with root package name */
    private static long f198965s;

    /* renamed from: l, reason: collision with root package name */
    private HashMap<String, String> f198966l;

    /* renamed from: m, reason: collision with root package name */
    private HashMap<String, String> f198967m;

    /* renamed from: n, reason: collision with root package name */
    private HashMap<String, String> f198968n;

    /* renamed from: o, reason: collision with root package name */
    protected ArkAppLocationManager f198969o;

    /* renamed from: p, reason: collision with root package name */
    protected ArkSilkAudioPlayerWrapper f198970p;

    /* renamed from: q, reason: collision with root package name */
    private WeakReference<QQCustomDialog> f198971q;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    static class MethodGetViewProperty implements com.tencent.mobileqq.ark.module.e {
        MethodGetViewProperty() {
        }

        static JSONObject h(Point point) throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(HippyTKDListViewAdapter.X, point.x);
            jSONObject.put("y", point.y);
            return jSONObject;
        }

        static JSONObject i(Rect rect) throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("left", rect.left);
            jSONObject.put("top", rect.top);
            jSONObject.put("right", rect.right);
            jSONObject.put("bottom", rect.bottom);
            return jSONObject;
        }

        static JSONObject j(int i3, int i16) throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", i3);
            jSONObject.put("height", i16);
            return jSONObject;
        }

        @Override // com.tencent.mobileqq.ark.module.e
        public boolean a() {
            return true;
        }

        @Override // com.tencent.mobileqq.ark.module.e
        public boolean b() {
            return true;
        }

        @Override // com.tencent.mobileqq.ark.module.e
        public void c(com.tencent.mobileqq.ark.module.b bVar, ark.VariantWrapper[] variantWrapperArr, ark.VariantWrapper variantWrapper) {
            if (variantWrapperArr != null && variantWrapperArr.length >= 1 && variantWrapperArr[0].IsView()) {
                final long GetView = variantWrapperArr[0].GetView();
                final JSONObject jSONObject = new JSONObject();
                ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).sendToMainThread(new Runnable() { // from class: com.tencent.mobileqq.ark.api.module.ArkAppQQModule.MethodGetViewProperty.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MethodGetViewProperty.this.e(jSONObject, GetView);
                    }
                });
                String jSONObject2 = jSONObject.toString();
                variantWrapper.SetTableAsJsonString(jSONObject2);
                QLog.i("ArkApp.ArkAppQQModule", 2, "view info: " + jSONObject2);
                return;
            }
            QLog.w("ArkApp.ArkAppQQModule", 1, "invalid arguments when invoke GetViewProperty");
        }

        Point d(View view) {
            Rect rect = new Rect();
            Point point = new Point();
            view.getGlobalVisibleRect(rect, point);
            return point;
        }

        void e(JSONObject jSONObject, long j3) {
            ArkViewImplement viewImpl;
            View arkView;
            BaseArkAppContainer h06 = ArkAppQQModule.h0(j3);
            if (h06 == null || (viewImpl = h06.getViewImpl()) == null || (arkView = viewImpl.getArkView()) == null) {
                return;
            }
            try {
                jSONObject.put("size", j(arkView.getWidth(), arkView.getHeight()));
                jSONObject.put("visibleRect", i(a91.c.b(arkView)));
                jSONObject.put("windowLocation", h(g(arkView)));
                jSONObject.put("globalOffset", h(d(arkView)));
                jSONObject.put("screenLocation", h(f(arkView)));
            } catch (JSONException e16) {
                QLog.i("ArkApp.ArkAppQQModule", 1, "getViewInfo, " + e16.toString());
            }
        }

        Point f(View view) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            return new Point(iArr[0], iArr[1]);
        }

        Point g(View view) {
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            return new Point(iArr[0], iArr[1]);
        }

        @Override // com.tencent.mobileqq.ark.module.e
        public String getMethodName() {
            return "GetViewProperty";
        }

        @Override // com.tencent.mobileqq.ark.module.e
        public String getPermission() {
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements ArkAppLocationManager.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f199021a;

        a(long j3) {
            this.f199021a = j3;
        }

        @Override // com.tencent.mobileqq.ark.component.ArkAppLocationManager.b
        public void a(boolean z16, double d16, double d17) {
            ArkAppQQModule.this.c0(this.f199021a, z16, d16, d17);
        }

        @Override // com.tencent.mobileqq.ark.component.ArkAppLocationManager.b
        public void b() {
            ark.VariantWrapper l3 = ArkAppQQModule.this.l(this.f199021a);
            if (l3 != null) {
                l3.Reset();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class b implements j.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f199023a;

        b(long j3) {
            this.f199023a = j3;
        }

        @Override // com.tencent.biz.subscribe.utils.j.f
        public void a(boolean z16, String str, boolean z17) {
            ArkAppQQModule.this.e0(this.f199023a, z16, str, z16 ? 1 : 0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class c implements j.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f199025a;

        c(long j3) {
            this.f199025a = j3;
        }

        @Override // com.tencent.biz.subscribe.utils.j.f
        public void a(boolean z16, String str, boolean z17) {
            ArkAppQQModule.this.e0(this.f199025a, z16, str, !z16 ? 1 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class d implements a.u.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f199027a;

        d(long j3) {
            this.f199027a = j3;
        }

        @Override // com.tencent.mobileqq.ark.api.module.a.u.c
        public void a(String str, long j3, String str2, String str3) {
            if (j3 > 0 && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                String str4 = ((com.tencent.mobileqq.ark.module.b) ArkAppQQModule.this).f199566b + "_" + j3 + "_" + str;
                ArkAppQQModule.this.f198967m.put(str4, str2);
                ArkAppQQModule.this.f198968n.put(str4, str3);
                ArkAppQQModule.this.f198966l.put(((com.tencent.mobileqq.ark.module.b) ArkAppQQModule.this).f199566b, String.valueOf(j3));
            }
            ArkAppQQModule.this.o0(str2, str3, this.f199027a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class e implements ArkAppLocationManager.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f199029a;

        e(long j3) {
            this.f199029a = j3;
        }

        @Override // com.tencent.mobileqq.ark.component.ArkAppLocationManager.b
        public void a(boolean z16, double d16, double d17) {
            ArkAppQQModule.this.c0(this.f199029a, z16, d16, d17);
        }

        @Override // com.tencent.mobileqq.ark.component.ArkAppLocationManager.b
        public void b() {
            ark.VariantWrapper l3 = ArkAppQQModule.this.l(this.f199029a);
            if (l3 != null) {
                l3.Reset();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class f implements ArkAppLocationManager.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f199031a;

        f(long j3) {
            this.f199031a = j3;
        }

        @Override // com.tencent.mobileqq.ark.component.ArkAppLocationManager.a
        public void a(boolean z16, SosoLbsInfo sosoLbsInfo) {
            ArkAppQQModule.this.d0(this.f199031a, z16, sosoLbsInfo);
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private static class g extends n {
        g() {
        }

        @Override // com.tencent.mobileqq.ark.module.e
        public boolean a() {
            return true;
        }

        @Override // com.tencent.mobileqq.ark.api.module.ArkAppQQModule.n, com.tencent.mobileqq.ark.module.e
        public boolean b() {
            return false;
        }

        @Override // com.tencent.mobileqq.ark.module.e
        public void c(com.tencent.mobileqq.ark.module.b bVar, ark.VariantWrapper[] variantWrapperArr, ark.VariantWrapper variantWrapper) {
            if (variantWrapperArr != null && variantWrapperArr.length == 1) {
                variantWrapper.SetString(com.tencent.mobileqq.ark.api.module.a.e(variantWrapperArr[0].GetString()));
            }
        }

        @Override // com.tencent.mobileqq.ark.module.e
        public String getMethodName() {
            return "GetPskey";
        }

        @Override // com.tencent.mobileqq.ark.api.module.ArkAppQQModule.n, com.tencent.mobileqq.ark.module.e
        public String getPermission() {
            return null;
        }
    }

    /* compiled from: P */
    @Deprecated
    /* loaded from: classes11.dex */
    private static class h extends n {
        h() {
        }

        @Override // com.tencent.mobileqq.ark.module.e
        public boolean a() {
            return true;
        }

        @Override // com.tencent.mobileqq.ark.api.module.ArkAppQQModule.n, com.tencent.mobileqq.ark.module.e
        public boolean b() {
            return false;
        }

        @Override // com.tencent.mobileqq.ark.module.e
        public void c(com.tencent.mobileqq.ark.module.b bVar, ark.VariantWrapper[] variantWrapperArr, ark.VariantWrapper variantWrapper) {
            variantWrapper.SetString(com.tencent.mobileqq.ark.api.module.a.g());
        }

        @Override // com.tencent.mobileqq.ark.module.e
        public String getMethodName() {
            return "GetSkey";
        }

        @Override // com.tencent.mobileqq.ark.api.module.ArkAppQQModule.n, com.tencent.mobileqq.ark.module.e
        public String getPermission() {
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private static class i extends n {
        i() {
        }

        @Override // com.tencent.mobileqq.ark.module.e
        public boolean a() {
            return true;
        }

        @Override // com.tencent.mobileqq.ark.module.e
        public void c(com.tencent.mobileqq.ark.module.b bVar, ark.VariantWrapper[] variantWrapperArr, ark.VariantWrapper variantWrapper) {
            variantWrapper.SetString(com.tencent.mobileqq.ark.api.module.a.h());
        }

        @Override // com.tencent.mobileqq.ark.module.e
        public String getMethodName() {
            return "GetTinyId";
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private static class j extends n {
        j() {
        }

        @Override // com.tencent.mobileqq.ark.module.e
        public boolean a() {
            return true;
        }

        @Override // com.tencent.mobileqq.ark.module.e
        public void c(com.tencent.mobileqq.ark.module.b bVar, ark.VariantWrapper[] variantWrapperArr, ark.VariantWrapper variantWrapper) {
            variantWrapper.SetString(com.tencent.mobileqq.ark.api.module.a.i());
        }

        @Override // com.tencent.mobileqq.ark.module.e
        public String getMethodName() {
            return "GetUIN";
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private class k extends n {
        k() {
        }

        @Override // com.tencent.mobileqq.ark.module.e
        public boolean a() {
            return true;
        }

        @Override // com.tencent.mobileqq.ark.api.module.ArkAppQQModule.n, com.tencent.mobileqq.ark.module.e
        public boolean b() {
            return false;
        }

        @Override // com.tencent.mobileqq.ark.module.e
        public void c(com.tencent.mobileqq.ark.module.b bVar, ark.VariantWrapper[] variantWrapperArr, ark.VariantWrapper variantWrapper) {
            if (variantWrapperArr != null && variantWrapperArr.length >= 2 && variantWrapperArr[0].IsString() && variantWrapperArr[1].IsFunction()) {
                ArkAppQQModule arkAppQQModule = ArkAppQQModule.this;
                if (arkAppQQModule.f198970p == null) {
                    arkAppQQModule.f198970p = new ArkSilkAudioPlayerWrapper(((com.tencent.mobileqq.ark.module.b) ArkAppQQModule.this).f199566b);
                    com.tencent.mobileqq.ark.api.silk.a.a(ArkAppQQModule.this.f198970p);
                }
                try {
                    String GetString = variantWrapperArr[0].GetString();
                    ark.VariantWrapper Copy = variantWrapperArr[1].Copy();
                    if (Copy == null) {
                        ArkAppQQModule.this.f198970p.e(6);
                        QLog.w("ArkApp.ArkAppQQModule", 1, "invoke method MethodPlaySilkAudio callBack is invalid");
                        return;
                    } else {
                        if (TextUtils.isEmpty(GetString)) {
                            ArkAppQQModule.this.f198970p.e(6);
                            QLog.w("ArkApp.ArkAppQQModule", 1, "invoke method MethodPlaySilkAudio url is invalid");
                            return;
                        }
                        QQAppInterface a16 = a91.a.a();
                        if (a16 != null) {
                            ((MediaPlayerManager) a16.getManager(QQManagerFactory.MGR_MEDIA_PLAYER)).D(false);
                        }
                        ArkAppQQModule.this.f198970p.c(Copy);
                        ArkAppQQModule.this.f198970p.b(GetString);
                        return;
                    }
                } catch (Exception e16) {
                    ArkAppQQModule.this.f198970p.f(6);
                    QLog.w("ArkApp.ArkAppQQModule", 1, "invoke method MethodPlaySilkAudio exception" + e16);
                    return;
                }
            }
            QLog.w("ArkApp.ArkAppQQModule", 1, "invoke method MethodPlaySilkAudio args is invalid");
        }

        @Override // com.tencent.mobileqq.ark.module.e
        public String getMethodName() {
            return "PlaySilkAudio";
        }

        @Override // com.tencent.mobileqq.ark.api.module.ArkAppQQModule.n, com.tencent.mobileqq.ark.module.e
        public String getPermission() {
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private static class l extends n {
        l() {
        }

        @Override // com.tencent.mobileqq.ark.module.e
        public boolean a() {
            return false;
        }

        @Override // com.tencent.mobileqq.ark.api.module.ArkAppQQModule.n, com.tencent.mobileqq.ark.module.e
        public boolean b() {
            return false;
        }

        @Override // com.tencent.mobileqq.ark.module.e
        public void c(com.tencent.mobileqq.ark.module.b bVar, ark.VariantWrapper[] variantWrapperArr, ark.VariantWrapper variantWrapper) {
            if (variantWrapperArr != null && variantWrapperArr.length >= 1 && variantWrapperArr[0].IsView() && ArkAppQQModule.l0(variantWrapperArr[0].GetView()) == null && QLog.isColorLevel()) {
                QLog.i("ArkApp.ArkAppQQModule", 2, "invoke method [ReplyMessage] arkMsg is null");
            }
        }

        @Override // com.tencent.mobileqq.ark.module.e
        public String getMethodName() {
            return "ReplyMessage";
        }

        @Override // com.tencent.mobileqq.ark.api.module.ArkAppQQModule.n, com.tencent.mobileqq.ark.module.e
        public String getPermission() {
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private class m extends n {
        m() {
        }

        @Override // com.tencent.mobileqq.ark.module.e
        public boolean a() {
            return true;
        }

        @Override // com.tencent.mobileqq.ark.api.module.ArkAppQQModule.n, com.tencent.mobileqq.ark.module.e
        public boolean b() {
            return false;
        }

        @Override // com.tencent.mobileqq.ark.module.e
        public void c(com.tencent.mobileqq.ark.module.b bVar, ark.VariantWrapper[] variantWrapperArr, ark.VariantWrapper variantWrapper) {
            if (variantWrapperArr != null && variantWrapperArr.length >= 1 && variantWrapperArr[0].IsString()) {
                try {
                    ArkSilkAudioPlayerWrapper arkSilkAudioPlayerWrapper = ArkAppQQModule.this.f198970p;
                    if (arkSilkAudioPlayerWrapper != null) {
                        arkSilkAudioPlayerWrapper.d();
                    }
                } catch (Exception e16) {
                    QLog.w("ArkApp.ArkAppQQModule", 1, "invoke method MethodStopSilkAudio exception" + e16);
                }
            }
        }

        @Override // com.tencent.mobileqq.ark.module.e
        public String getMethodName() {
            return "StopSilkAudio";
        }

        @Override // com.tencent.mobileqq.ark.api.module.ArkAppQQModule.n, com.tencent.mobileqq.ark.module.e
        public String getPermission() {
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private static abstract class n implements com.tencent.mobileqq.ark.module.e {
        n() {
        }

        @Override // com.tencent.mobileqq.ark.module.e
        public boolean b() {
            return false;
        }

        @Override // com.tencent.mobileqq.ark.module.e
        public String getPermission() {
            return null;
        }
    }

    public ArkAppQQModule(ark.Application application, int i3) {
        super(application, i3);
        this.f198966l = new HashMap<>();
        this.f198967m = new HashMap<>();
        this.f198968n = new HashMap<>();
        this.f198971q = null;
        this.f198969o = new ArkAppLocationManager(this.f199566b, 30000L);
        ((IArkQQApi) QRoute.api(IArkQQApi.class)).registerArkQQCallBack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(long j3, String str, int i3) {
        ark.VariantWrapper l3 = l(j3);
        if (l3 == null) {
            QLog.e("ArkApp.ArkAppQQModule", 1, "GetUserInformation.arkGetUserInformation call back is null");
            return;
        }
        ark.VariantWrapper Create = l3.Create();
        ark.VariantWrapper[] variantWrapperArr = {Create};
        Create.SetNull();
        if (1 == i3) {
            String j16 = com.tencent.mobileqq.ark.api.module.a.j(null);
            if (!TextUtils.isEmpty(j16)) {
                Create.SetTableAsJsonString(j16);
            }
        }
        ark.VariantWrapper Create2 = l3.Create();
        l3.InvokeDefault(variantWrapperArr, Create2);
        Create2.Reset();
        Create.Reset();
        l3.Reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0(long j3, String str, long j16, long j17, int i3) {
        if (1 != i3) {
            QLog.i("ArkApp.ArkAppQQModule", 1, "arkLoginGetOpenKey, no auth");
            o0(null, null, j3);
            return;
        }
        String str2 = this.f199566b + "_" + j17 + "_" + str;
        if (this.f198967m.containsKey(str2) && !TextUtils.isEmpty(this.f198967m.get(str2)) && this.f198968n.containsKey(str2) && !TextUtils.isEmpty(this.f198968n.get(str2))) {
            String valueOf = String.valueOf(j17);
            if (!this.f198966l.containsKey(this.f199566b) || !this.f198966l.containsValue(valueOf)) {
                this.f198966l.put(this.f199566b, valueOf);
            }
            o0(this.f198967m.get(str2), this.f198968n.get(str2), j3);
            return;
        }
        com.tencent.mobileqq.ark.api.module.a.l(j16, j17, new d(j3));
    }

    public static int b0(int i3) {
        if (i3 == 1) {
            return 2;
        }
        if (i3 == 2) {
            return 3;
        }
        if (i3 == 3) {
            return 4;
        }
        if (i3 != 4) {
            if (i3 != 100) {
                if (i3 != 113) {
                    if (i3 == 103) {
                        return 1;
                    }
                    if (i3 != 104) {
                        return -1;
                    }
                    return 8;
                }
                return 9;
            }
            return 5;
        }
        return 7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0(long j3, String str) {
        ark.VariantWrapper l3 = l(j3);
        if (l3 == null) {
            QLog.e("ArkApp.ArkAppQQModule", 1, "Callback is null");
            return;
        }
        ark.VariantWrapper Create = l3.Create();
        if (!TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("ArkApp.ArkAppQQModule", 2, "doCallbackForGetPskeyAsync : SetString");
            }
            Create.SetString(str);
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("ArkApp.ArkAppQQModule", 2, "doCallbackForGetPskeyAsync : SetNull");
            }
            Create.SetNull();
        }
        ark.VariantWrapper Create2 = l3.Create();
        l3.InvokeDefault(new ark.VariantWrapper[]{Create}, Create2);
        Create2.Reset();
        Create.Reset();
        l3.Reset();
    }

    public static View g0(View view, Object obj) {
        Object parent = view.getParent();
        while (parent instanceof View) {
            View view2 = (View) parent;
            if (view2.getTag() != null && view2.getTag().equals(obj)) {
                return view2;
            }
            parent = view2.getParent();
        }
        QLog.i("ArkApp.ArkAppQQModule", 1, "not find tag view " + obj);
        return null;
    }

    public static BaseArkAppContainer h0(long j3) {
        ark.Container arkGetContainer;
        WeakReference<BaseArkAppContainer> containerWrapperByHandle;
        if (j3 == 0 || (arkGetContainer = ark.arkGetContainer(j3)) == null || (containerWrapperByHandle = BaseArkAppContainer.getContainerWrapperByHandle(arkGetContainer)) == null) {
            return null;
        }
        return containerWrapperByHandle.get();
    }

    private static String j0(ark.VariantWrapper[] variantWrapperArr) {
        if (variantWrapperArr.length < 3) {
            return "";
        }
        if (!variantWrapperArr[2].IsArray() && !variantWrapperArr[2].IsTable()) {
            return "";
        }
        return variantWrapperArr[2].GetTableAsJsonString();
    }

    private static int k0(ark.VariantWrapper[] variantWrapperArr, long j3) {
        boolean z16;
        int i3 = 4;
        if (j3 < 2) {
            return 4;
        }
        ark.VariantWrapper variantWrapper = variantWrapperArr[1];
        if (variantWrapper != null && variantWrapper.GetType() == 5 && variantWrapper.GetString() != null) {
            String lowerCase = variantWrapper.GetString().toLowerCase();
            String[] strArr = {"d", "debug", "i", "info", "e", "error", "w", "warning"};
            boolean z17 = false;
            int i16 = 2;
            if (!strArr[0].equals(lowerCase) && !strArr[1].equals(lowerCase)) {
                while (true) {
                    if (i16 < 8) {
                        if (strArr[i16].equals(lowerCase)) {
                            z16 = true;
                            i3 = 1;
                            break;
                        }
                        i16++;
                    } else {
                        z16 = false;
                        break;
                    }
                }
            } else {
                if (QLog.isColorLevel()) {
                    z16 = false;
                    i3 = 2;
                } else {
                    z16 = false;
                }
                z17 = true;
            }
            if (z17 || z16) {
                return i3;
            }
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MsgRecord l0(long j3) {
        BaseArkAppContainer h06;
        if (j3 == 0 || (h06 = h0(j3)) == null) {
            return null;
        }
        Object contactData = h06.getContactData();
        if (!(contactData instanceof MsgRecord)) {
            return null;
        }
        return (MsgRecord) contactData;
    }

    private boolean n0(String str, String str2) {
        boolean z16;
        boolean z17;
        int i3;
        ArkAppUrlChecker urlChecker = ArkAppConfigMgr.getInstance().getUrlChecker(this.f199566b, this.f199568d);
        int i16 = 1;
        if (urlChecker == null) {
            return true;
        }
        int checkUrlIsValidByAppNavigationList = urlChecker.checkUrlIsValidByAppNavigationList(str);
        if (checkUrlIsValidByAppNavigationList == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean isUrlCheckEnable = ArkAppConfigMgr.getInstance().isUrlCheckEnable(this.f199566b);
        boolean e16 = com.tencent.mobileqq.ark.f.e();
        if (isUrlCheckEnable && !e16 && !((IArkEnvironment) QRoute.api(IArkEnvironment.class)).isDebugMode()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.e("ArkApp.ArkAppQQModule", 2, "ArkSafe.UrlCheck.OpenUrl.http.appname=", this.f199566b, ", enableCheck=", Boolean.valueOf(z17), ", appEnableCheck=", Boolean.valueOf(isUrlCheckEnable), ", isPublicAccount=", Boolean.valueOf(e16));
        }
        if (!z16) {
            if (!z17) {
                QLog.i("ArkApp.ArkAppQQModule", 1, "ArkSafe.UrlCheck.setDisable.OpenUrl.http appName=" + this.f199566b + JefsClass.INDEX_URL + com.tencent.biz.common.util.k.f(str, new String[0]) + ", isValid set=true");
                z16 = true;
                i16 = 2;
            }
            q0();
            i3 = i16;
        } else {
            i3 = 0;
        }
        boolean z18 = z16;
        ((IArkSecureReport) QRoute.api(IArkSecureReport.class)).reportOpenURLAccess(this.f199566b, str, checkUrlIsValidByAppNavigationList, i3, str2);
        return z18;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0(final String str, final String str2, final long j3) {
        ArkDispatchTask.getInstance().post(this.f199566b, new Runnable() { // from class: com.tencent.mobileqq.ark.api.module.ArkAppQQModule.25
            /* JADX WARN: Removed duplicated region for block: B:12:0x004e  */
            /* JADX WARN: Removed duplicated region for block: B:15:0x0052  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                String jSONObject;
                ark.VariantWrapper l3 = ArkAppQQModule.this.l(j3);
                if (l3 == null) {
                    return;
                }
                if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("openid", str);
                        jSONObject2.put("token", str2);
                        jSONObject = jSONObject2.toString();
                    } catch (Exception unused) {
                        QLog.i("ArkApp.ArkAppQQModule", 1, "loginDoCallback, convert to json fail");
                    }
                    ark.VariantWrapper Create = l3.Create();
                    ark.VariantWrapper Create2 = l3.Create();
                    if (!TextUtils.isEmpty(jSONObject)) {
                        Create.SetNull();
                    } else {
                        Create.SetTableAsJsonString(jSONObject);
                    }
                    l3.InvokeDefault(new ark.VariantWrapper[]{Create}, Create2);
                    Create2.Reset();
                    Create.Reset();
                    l3.Reset();
                }
                jSONObject = null;
                ark.VariantWrapper Create3 = l3.Create();
                ark.VariantWrapper Create22 = l3.Create();
                if (!TextUtils.isEmpty(jSONObject)) {
                }
                l3.InvokeDefault(new ark.VariantWrapper[]{Create3}, Create22);
                Create22.Reset();
                Create3.Reset();
                l3.Reset();
            }
        });
    }

    private void q0() {
        if (!((IArkEnvironment) QRoute.api(IArkEnvironment.class)).isDebugMode()) {
            return;
        }
        ArkDispatchTask.getInstance().postToMainThread(new Runnable() { // from class: com.tencent.mobileqq.ark.api.module.ArkAppQQModule.23
            @Override // java.lang.Runnable
            public void run() {
                BaseApplication context = BaseApplication.getContext();
                if (context == null) {
                    return;
                }
                QQToast.makeText(context, context.getString(R.string.z6d), 2000).show();
            }
        });
    }

    @Override // com.tencent.mobileqq.ark.module.b, com.tencent.ark.ark.ModuleCallbackWrapper
    public void Destruct() {
        ArkAppLocationManager arkAppLocationManager = this.f198969o;
        if (arkAppLocationManager != null) {
            arkAppLocationManager.f();
        }
        ArkSilkAudioPlayerWrapper arkSilkAudioPlayerWrapper = this.f198970p;
        if (arkSilkAudioPlayerWrapper != null) {
            arkSilkAudioPlayerWrapper.d();
            this.f198970p = null;
            com.tencent.mobileqq.ark.api.silk.a.b();
        }
        ((IArkQQApi) QRoute.api(IArkQQApi.class)).unregisterArkQQCallBack();
        super.Destruct();
    }

    @Override // com.tencent.mobileqq.ark.module.b, com.tencent.ark.ark.ModuleCallbackWrapper
    public String GetTypeName() {
        return "QQ";
    }

    @Override // com.tencent.mobileqq.ark.module.b, com.tencent.ark.ark.ModuleCallbackWrapper
    public boolean HasMethod(String str) {
        if (super.HasMethod(str) || str.equals(QZoneJsConstants.METHOD_OPEN_URL) || str.equals("NavigateTo") || str.equals("OpenVideo") || str.equals("GetVersion") || str.equals("GetBizsrc") || str.equals("GetPerformance") || str.equals(AegisLogger.LOGIN) || str.equals("GetUserInformation") || str.equals("OpenView") || str.equals("CloseView") || str.equals("ShareView") || str.equals("ShowStatusBar") || str.equals("HideStatusBar") || str.equals("ShowToast") || str.equals("SetNavigationBarTitle") || str.equals("ShowShareMenu") || str.equals("HideShareMenu") || str.equals("PreviewImage") || str.equals("SetTalkBackText") || str.equals("ChooseImage") || str.equals("GetAppInfo")) {
            return true;
        }
        if (this.f199565a == 0) {
            if (str.equals("GetPskeyAsync") || str.equals("Report") || str.equals("ReportEx") || str.equals("Log") || str.equals("GetContainerInfo") || str.equals("DataRequest") || str.equals("GetCurrentPosition") || str.equals("WatchPosition") || str.equals("ClearWatch") || str.equals("GetCurrentAddress")) {
                return true;
            }
            if (str.equals("TestGetJson")) {
                return false;
            }
            if (str.equals("Notify") || str.equals("GetAppID") || str.equals("GetAudioOutputMode") || str.equals("IsMute") || str.equals("GetNickNameByView") || str.equals("SubscribePublicAccount")) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(21:34|(2:36|(19:38|39|40|(15:42|43|(1:45)|46|(2:48|(2:50|(2:192|(1:196))(10:54|55|(1:57)(1:191)|58|(1:62)|(1:68)|69|70|(2:72|(4:80|(1:82)|83|(1:87)))(4:88|(2:93|(1:(2:99|(3:101|(8:103|(1:105)(1:123)|106|(1:122)(1:109)|110|(1:112)|(1:(1:115)(1:120))(1:121)|116)(1:124)|(1:118)(1:119)))(1:98)))|125|(2:127|128)(2:129|(2:131|132)(5:133|(6:161|162|(6:165|(1:167)(2:177|(1:179)(1:180))|168|(1:176)(4:170|(1:172)|173|174)|175|163)|181|182|(2:184|(1:186)(1:187)))|(1:160)(1:138)|139|(6:141|(1:143)(1:155)|144|(1:146)(1:154)|147|(3:149|(1:151)(1:153)|152))(2:156|(1:158)(1:159)))))|78)))(1:198)|197|55|(0)(0)|58|(2:60|62)|(2:64|68)|69|70|(0)(0)|78)|200|43|(0)|46|(0)(0)|197|55|(0)(0)|58|(0)|(0)|69|70|(0)(0)|78)(1:202))(1:204)|203|39|40|(0)|200|43|(0)|46|(0)(0)|197|55|(0)(0)|58|(0)|(0)|69|70|(0)(0)|78) */
    /* JADX WARN: Removed duplicated region for block: B:191:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d5 A[Catch: JSONException -> 0x00e1, TRY_LEAVE, TryCatch #1 {JSONException -> 0x00e1, blocks: (B:40:0x00d2, B:42:0x00d5), top: B:39:0x00d2 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01f1 A[Catch: Exception -> 0x055f, TryCatch #3 {Exception -> 0x055f, blocks: (B:70:0x01d1, B:72:0x01f1, B:74:0x021f, B:76:0x0225, B:78:0x0558, B:80:0x0230, B:83:0x023b, B:85:0x0241, B:87:0x024a, B:88:0x026e, B:90:0x0277, B:93:0x0282, B:96:0x0288, B:99:0x02a2, B:101:0x02ac, B:103:0x02ba, B:106:0x02c3, B:110:0x02d8, B:112:0x02de, B:115:0x031c, B:116:0x034c, B:118:0x0363, B:119:0x0368, B:125:0x038a, B:127:0x039a, B:129:0x03a3, B:131:0x03a9, B:133:0x03cb, B:162:0x03d1, B:163:0x03e0, B:165:0x03e6, B:167:0x03f4, B:168:0x040d, B:172:0x0415, B:173:0x0427, B:177:0x03f9, B:179:0x0401, B:182:0x0441, B:184:0x0447, B:186:0x0452, B:187:0x0462, B:136:0x0479, B:141:0x04a2, B:143:0x04a8, B:144:0x04ae, B:146:0x04c6, B:147:0x04eb, B:152:0x0514, B:153:0x0510, B:154:0x04d0, B:156:0x0523, B:158:0x0533, B:159:0x053d, B:160:0x0482), top: B:69:0x01d1 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x026e A[Catch: Exception -> 0x055f, TryCatch #3 {Exception -> 0x055f, blocks: (B:70:0x01d1, B:72:0x01f1, B:74:0x021f, B:76:0x0225, B:78:0x0558, B:80:0x0230, B:83:0x023b, B:85:0x0241, B:87:0x024a, B:88:0x026e, B:90:0x0277, B:93:0x0282, B:96:0x0288, B:99:0x02a2, B:101:0x02ac, B:103:0x02ba, B:106:0x02c3, B:110:0x02d8, B:112:0x02de, B:115:0x031c, B:116:0x034c, B:118:0x0363, B:119:0x0368, B:125:0x038a, B:127:0x039a, B:129:0x03a3, B:131:0x03a9, B:133:0x03cb, B:162:0x03d1, B:163:0x03e0, B:165:0x03e6, B:167:0x03f4, B:168:0x040d, B:172:0x0415, B:173:0x0427, B:177:0x03f9, B:179:0x0401, B:182:0x0441, B:184:0x0447, B:186:0x0452, B:187:0x0462, B:136:0x0479, B:141:0x04a2, B:143:0x04a8, B:144:0x04ae, B:146:0x04c6, B:147:0x04eb, B:152:0x0514, B:153:0x0510, B:154:0x04d0, B:156:0x0523, B:158:0x0533, B:159:0x053d, B:160:0x0482), top: B:69:0x01d1 }] */
    /* JADX WARN: Type inference failed for: r4v35 */
    /* JADX WARN: Type inference failed for: r4v36, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v37 */
    @Override // com.tencent.mobileqq.ark.module.b, com.tencent.ark.ark.ModuleCallbackWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean Invoke(String str, ark.VariantWrapper[] variantWrapperArr, ark.VariantWrapper variantWrapper) {
        final String str2;
        char c16;
        String str3;
        ?? r46;
        long j3;
        long j16;
        char c17;
        int i3;
        int i16;
        boolean z16;
        String currentAccountUin;
        char c18;
        int i17;
        ark.VariantWrapper variantWrapper2;
        ark.VariantWrapper variantWrapper3;
        ark.VariantWrapper variantWrapper4;
        boolean z17;
        com.tencent.mobileqq.activity.aio.item.b bVar;
        String str4;
        boolean z18;
        MsgRecord msgRecord;
        String str5;
        long j17;
        JSONObject jSONObject;
        AIOContact aIOContact;
        String str6;
        BaseArkAppContainer h06;
        MsgRecord l06;
        String obj;
        boolean z19;
        int i18;
        if (super.Invoke(str, variantWrapperArr, variantWrapper)) {
            return true;
        }
        if (!c(str)) {
            return false;
        }
        s23.a.i(ArkAppQQModuleBase.f(), str);
        if (str.equals("NavigateTo")) {
            Activity f16 = ArkAppQQModuleBase.f();
            if (f16 != null && variantWrapperArr != null && variantWrapperArr.length >= 1) {
                a91.a.e(f16, variantWrapperArr[0].GetString(), true, 0L, null, null, 3, this.f199566b, null, this.f199568d);
            }
            return true;
        }
        str2 = "";
        if (str.equals(QZoneJsConstants.METHOD_OPEN_URL)) {
            variantWrapper.SetBool(false);
            Activity f17 = ArkAppQQModuleBase.f();
            if (f17 == null) {
                f17 = BaseApplicationImpl.getApplication().getResumeActivity();
                if (f17 == null) {
                    QLog.i("ArkApp.ArkAppQQModule", 1, "open url, no activity found");
                    return true;
                }
                QLog.i("ArkApp.ArkAppQQModule", 1, "use ResumeActivity");
            }
            if (variantWrapperArr != null && variantWrapperArr.length >= 1) {
                String GetString = variantWrapperArr[0].GetString();
                if (QLog.isColorLevel()) {
                    QLog.i("ArkApp.ArkAppQQModule", 2, "ark click openUrl url = " + com.tencent.biz.common.util.k.f(GetString, new String[0]));
                }
                if (!TextUtils.isEmpty(GetString)) {
                    try {
                        if (variantWrapperArr.length <= 1) {
                            str5 = null;
                        } else if (variantWrapperArr[1].IsView()) {
                            j17 = variantWrapperArr[1].GetView();
                            str5 = null;
                            if (variantWrapperArr.length > 2) {
                                jSONObject = new JSONObject(variantWrapperArr[2].GetTableAsJsonString());
                                String optString = jSONObject != null ? jSONObject.optString("businessId", "biz_src_jc_ark") : "biz_src_jc_ark";
                                if (f17 instanceof BaseActivity) {
                                    aIOContact = com.tencent.qqnt.aio.utils.a.f352276a.a((BaseActivity) f17);
                                    if (aIOContact != null) {
                                        if (aIOContact.e() == 103 && AdDownloadConstants.DOWNLOAD_SOURCE_AD.equals(optString)) {
                                            str6 = ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getSourceId(aIOContact.j());
                                            QLog.d("ArkApp.ArkAppQQModule", 1, "ArkSafe.OpenUrl set hsSourceID for " + aIOContact.j() + ", input " + optString + ", output " + str6);
                                            h06 = h0(j17);
                                            String senderUin = h06 == null ? h06.getSenderUin() : "";
                                            l06 = l0(j17);
                                            String str7 = str6;
                                            String str8 = optString;
                                            ((IArkSecureReport) QRoute.api(IArkSecureReport.class)).reportArkOpenUrl(this.f199566b, GetString, senderUin);
                                            if (h06 != null && ((IAIOMsgItemApi) QRoute.api(IAIOMsgItemApi.class)).isNtArkAppContainer(h06)) {
                                                HashMap hashMap = new HashMap();
                                                hashMap.put("aio_information_type", 11);
                                                com.tencent.mobileqq.aio.utils.b.l("em_bas_message_bubble", hashMap);
                                            }
                                            if (aIOContact != null && (aIOContact.e() == 103 || aIOContact.e() == 118)) {
                                                ((IPublicAccountReport) QRoute.api(IPublicAccountReport.class)).publicAccountAIOMsgReport(118, Integer.valueOf(aIOContact.e()), l06);
                                            }
                                            if (!((IArkAPIService) QRoute.api(IArkAPIService.class)).dispatchOpenURL(GetString, str5, jSONObject, this.f199565a, this.f199566b, this.f199568d)) {
                                                com.tencent.mobileqq.ark.g.b(null, this.f199566b, "FullScreenOrH5ShowForAI", 0, 0, 0L, 0L, 0L, "", "");
                                                variantWrapper.SetBool(true);
                                                if ((((IMiniAppService) QRoute.api(IMiniAppService.class)).isMiniAppUrl(GetString) || (!TextUtils.isEmpty(GetString) && GetString.startsWith("miniapp"))) && l06 != null) {
                                                    String appIdFromMeta = ArkMsgUtils.getAppIdFromMeta(ArkMsgUtils.getMetaFromArkMsgRecord(l06));
                                                    if (appIdFromMeta == null) {
                                                        appIdFromMeta = "";
                                                    }
                                                    if (appIdFromMeta.equals("") || appIdFromMeta.matches("\\d+")) {
                                                        ReportController.o(null, "dc00898", "", "", "0X800A86C", "0X800A86C", 0, 0, appIdFromMeta, "", "", "");
                                                    }
                                                }
                                            } else {
                                                if (!GetString.startsWith("http://") && !GetString.startsWith("https://")) {
                                                    if (this.f199565a == 0) {
                                                        if (aIOContact != null && ((IHWTroopUIApi) QRoute.api(IHWTroopUIApi.class)).handleHttpUrl(f17, GetString, Integer.valueOf(aIOContact.e()), this.f199568d)) {
                                                            return true;
                                                        }
                                                        ax c19 = bi.c(ArkAppQQModuleBase.p(), f17, GetString);
                                                        if (c19 != null) {
                                                            ArkAppUrlChecker urlChecker = ArkAppConfigMgr.getInstance().getUrlChecker(this.f199566b, this.f199568d);
                                                            if (urlChecker != null) {
                                                                int checkUrlIsValidByAppNavigationList = urlChecker.checkUrlIsValidByAppNavigationList(GetString);
                                                                z19 = checkUrlIsValidByAppNavigationList == 0;
                                                                boolean isUrlCheckEnable = ArkAppConfigMgr.getInstance().isUrlCheckEnable(this.f199566b);
                                                                boolean e16 = com.tencent.mobileqq.ark.f.e();
                                                                boolean z26 = isUrlCheckEnable && !e16;
                                                                if (QLog.isColorLevel()) {
                                                                    QLog.e("ArkApp.ArkAppQQModule", 2, "ArkSafe.UrlCheck.OpenUrl.http.JumpAction=", this.f199566b, ", enableCheck=", Boolean.valueOf(z26), ", appEnableCheck=", Boolean.valueOf(isUrlCheckEnable), ", isPublicAccount=", Boolean.valueOf(e16));
                                                                }
                                                                if (z19) {
                                                                    i18 = 0;
                                                                } else if (z26) {
                                                                    i18 = 1;
                                                                } else {
                                                                    QLog.e("ArkApp.ArkAppQQModule", 1, "ArkSafe.UrlCheck.setDisable.OpenUrl.jump appName=", this.f199566b, JefsClass.INDEX_URL, com.tencent.biz.common.util.k.f(GetString, new String[0]), ", isValid set=true");
                                                                    z19 = true;
                                                                    i18 = 2;
                                                                }
                                                                ((IArkSecureReport) QRoute.api(IArkSecureReport.class)).reportOpenURLAccess(this.f199566b, GetString, checkUrlIsValidByAppNavigationList, i18, senderUin);
                                                            } else {
                                                                z19 = true;
                                                            }
                                                            if (z19) {
                                                                c19.b();
                                                            } else {
                                                                QLog.e("ArkApp.ArkAppQQModule", 1, "ArkSafe.OpenUrl check url invalid, url=", com.tencent.biz.common.util.k.f(GetString, new String[0]), ", app=", this.f199566b);
                                                            }
                                                        }
                                                    }
                                                }
                                                if (!com.tencent.mobileqq.ark.module.a.a(this.f199566b, this.f199565a, this.f199570f, "permission.BROWSER")) {
                                                    QLog.d("ArkApp.ArkAppQQModule", 1, "ArkSafe.OpenUrl ModuleCheckPermission invalid!");
                                                    return false;
                                                }
                                                if (!n0(GetString, senderUin)) {
                                                    QLog.d("ArkApp.ArkAppQQModule", 1, "ArkSafe.OpenUrl check url invalid!, url=", com.tencent.biz.common.util.k.f(GetString, new String[0]), ", app=", this.f199566b);
                                                    return false;
                                                }
                                                if (!TextUtils.isEmpty(str5)) {
                                                    try {
                                                        JSONObject jSONObject2 = new JSONObject(str5);
                                                        Iterator keys = jSONObject2.keys();
                                                        String str9 = new String();
                                                        boolean z27 = false;
                                                        while (keys.hasNext()) {
                                                            String str10 = (String) keys.next();
                                                            if (jSONObject2.get(str10) instanceof String) {
                                                                obj = jSONObject2.getString(str10);
                                                            } else {
                                                                obj = jSONObject2.get(str10) instanceof Number ? ((Number) jSONObject2.get(str10)).toString() : null;
                                                            }
                                                            if (!TextUtils.isEmpty(obj)) {
                                                                if (z27) {
                                                                    str9 = str9 + ContainerUtils.FIELD_DELIMITER;
                                                                }
                                                                str9 = str9 + str10 + ContainerUtils.KEY_VALUE_DELIMITER + obj;
                                                                z27 = true;
                                                            }
                                                        }
                                                        if (!TextUtils.isEmpty(str9)) {
                                                            GetString = GetString.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, 0) == -1 ? GetString + str9 : GetString + ContainerUtils.FIELD_DELIMITER + str9;
                                                        }
                                                    } catch (JSONException unused) {
                                                    }
                                                }
                                                if (aIOContact == null || aIOContact.e() != 103) {
                                                    com.tencent.mobileqq.ark.g.b(null, this.f199566b, "FullScreenOrH5ShowForAI", 0, 0, 0L, 0L, 0L, "", "");
                                                }
                                                if (l06 != null) {
                                                    com.tencent.qqnt.msg.data.a parseArkMsgModelFromMsgRecord = ArkMsgUtils.parseArkMsgModelFromMsgRecord(l06);
                                                    long c26 = o.c(ArkMsgUtils.getAppIdFromMeta(parseArkMsgModelFromMsgRecord != null ? parseArkMsgModelFromMsgRecord.m() : ""));
                                                    if (((IQZoneGroupAlbumArkUtil) QRoute.api(IQZoneGroupAlbumArkUtil.class)).isFromGroupAlbumArk(this.f199566b, this.f199568d, GetString)) {
                                                        ((IQZoneGroupAlbumArkUtil) QRoute.api(IQZoneGroupAlbumArkUtil.class)).handleGroupArkUrl(f17, GetString);
                                                    } else {
                                                        a91.a.e(f17, GetString, true, c26, l06, str8, 0, this.f199566b, str7, this.f199568d);
                                                    }
                                                    jq3.a.b(parseArkMsgModelFromMsgRecord, l06);
                                                    if (ArkMsgUtils.isFromSdkShare(parseArkMsgModelFromMsgRecord)) {
                                                        if (c26 != 0) {
                                                            str2 = String.valueOf(c26);
                                                        }
                                                        ReportController.o(null, "dc00898", "", "", "0X800A869", "0X800A869", 0, 0, str2, "", "", "");
                                                    }
                                                } else if (((IQZoneGroupAlbumArkUtil) QRoute.api(IQZoneGroupAlbumArkUtil.class)).isFromGroupAlbumArk(this.f199566b, this.f199568d, GetString)) {
                                                    ((IQZoneGroupAlbumArkUtil) QRoute.api(IQZoneGroupAlbumArkUtil.class)).handleGroupArkUrl(f17, GetString);
                                                } else {
                                                    a91.a.e(f17, GetString, true, 0L, null, str8, 0, this.f199566b, str7, this.f199568d);
                                                }
                                            }
                                            Log.d("ark.OpenUrl ", GetString);
                                        } else if (aIOContact.e() == 2 && com.tencent.mobileqq.troop.utils.k.k(this.f199566b, GetString)) {
                                            GetString = com.tencent.mobileqq.troop.utils.k.h(aIOContact.j(), GetString);
                                        }
                                    }
                                } else {
                                    aIOContact = null;
                                }
                                str6 = null;
                                h06 = h0(j17);
                                if (h06 == null) {
                                }
                                l06 = l0(j17);
                                String str72 = str6;
                                String str82 = optString;
                                ((IArkSecureReport) QRoute.api(IArkSecureReport.class)).reportArkOpenUrl(this.f199566b, GetString, senderUin);
                                if (h06 != null) {
                                    HashMap hashMap2 = new HashMap();
                                    hashMap2.put("aio_information_type", 11);
                                    com.tencent.mobileqq.aio.utils.b.l("em_bas_message_bubble", hashMap2);
                                }
                                if (aIOContact != null) {
                                    ((IPublicAccountReport) QRoute.api(IPublicAccountReport.class)).publicAccountAIOMsgReport(118, Integer.valueOf(aIOContact.e()), l06);
                                }
                                if (!((IArkAPIService) QRoute.api(IArkAPIService.class)).dispatchOpenURL(GetString, str5, jSONObject, this.f199565a, this.f199566b, this.f199568d)) {
                                }
                                Log.d("ark.OpenUrl ", GetString);
                            }
                            jSONObject = null;
                            if (jSONObject != null) {
                            }
                            if (f17 instanceof BaseActivity) {
                            }
                            str6 = null;
                            h06 = h0(j17);
                            if (h06 == null) {
                            }
                            l06 = l0(j17);
                            String str722 = str6;
                            String str822 = optString;
                            ((IArkSecureReport) QRoute.api(IArkSecureReport.class)).reportArkOpenUrl(this.f199566b, GetString, senderUin);
                            if (h06 != null) {
                            }
                            if (aIOContact != null) {
                            }
                            if (!((IArkAPIService) QRoute.api(IArkAPIService.class)).dispatchOpenURL(GetString, str5, jSONObject, this.f199565a, this.f199566b, this.f199568d)) {
                            }
                            Log.d("ark.OpenUrl ", GetString);
                        } else {
                            str5 = variantWrapperArr[1].GetTableAsJsonString();
                        }
                        if (!((IArkAPIService) QRoute.api(IArkAPIService.class)).dispatchOpenURL(GetString, str5, jSONObject, this.f199565a, this.f199566b, this.f199568d)) {
                        }
                        Log.d("ark.OpenUrl ", GetString);
                    } catch (Exception e17) {
                        QLog.e("ArkApp.ArkAppQQModule", 1, "QQ_MODULE_API_OPENURL error = " + e17.getMessage());
                    }
                    j17 = 0;
                    if (variantWrapperArr.length > 2) {
                    }
                    jSONObject = null;
                    if (jSONObject != null) {
                    }
                    if (f17 instanceof BaseActivity) {
                    }
                    str6 = null;
                    h06 = h0(j17);
                    if (h06 == null) {
                    }
                    l06 = l0(j17);
                    String str7222 = str6;
                    String str8222 = optString;
                    ((IArkSecureReport) QRoute.api(IArkSecureReport.class)).reportArkOpenUrl(this.f199566b, GetString, senderUin);
                    if (h06 != null) {
                    }
                    if (aIOContact != null) {
                    }
                }
            }
            com.tencent.mobileqq.ark.g.b(null, this.f199566b, "FullScreenOrH5Show", 0, 0, 0L, 0L, 0L, "", "");
            return true;
        }
        if (str.equals("OpenVideo")) {
            long currentTimeMillis = System.currentTimeMillis();
            long j18 = f198964r;
            if (currentTimeMillis - j18 < 1000 && currentTimeMillis > j18) {
                if (!QLog.isColorLevel()) {
                    return true;
                }
                QLog.e("ArkApp.ArkAppQQModule", 2, "click too offen,please try again later ");
                return true;
            }
            f198964r = currentTimeMillis;
            variantWrapper.SetBool(false);
            Activity f18 = ArkAppQQModuleBase.f();
            if (!(f18 instanceof BaseActivity) || variantWrapperArr == null || variantWrapperArr.length < 1) {
                return true;
            }
            String GetString2 = variantWrapperArr[0].GetString();
            if (!TextUtils.isEmpty(GetString2)) {
                try {
                    String protocol2 = new URL(GetString2).getProtocol();
                    if (!TextUtils.isEmpty(protocol2) && (protocol2.equalsIgnoreCase("http") || protocol2.equalsIgnoreCase("https"))) {
                        ark.Application application = this.f199570f;
                        if (application != null && !application.CheckUrlLegality(GetString2)) {
                            return false;
                        }
                        variantWrapper.SetBool(true);
                        a91.a.f(f18, GetString2);
                        com.tencent.mobileqq.ark.g.b(ArkAppQQModuleBase.p(), this.f199566b, "AIOArkOpenVideo", 1, 0, 0L, 0L, 0L, GetString2, "");
                    }
                } catch (MalformedURLException e18) {
                    QLog.i("ArkApp.ArkAppQQModule", 1, "url parse error and msg= " + e18.getMessage());
                    return false;
                }
            }
            return true;
        }
        if (str.equals("Report")) {
            QQAppInterface p16 = ArkAppQQModuleBase.p();
            if (variantWrapperArr == null || variantWrapperArr.length != 3) {
                return true;
            }
            String GetString3 = variantWrapperArr[0].GetString();
            int round = (int) Math.round(variantWrapperArr[1].GetDouble());
            String GetString4 = variantWrapperArr[2].GetString();
            if (!TextUtils.isEmpty(GetString4)) {
                long serverTime = NetConnInfoCenter.getServerTime();
                if (!TextUtils.isEmpty(GetString3)) {
                    try {
                        Long.parseLong(GetString3);
                        ReportController.o(p16, "CliOper", "", "", "0X8005FFE", "0X8005FFE", round, 0, Long.toString(serverTime), GetString3, GetString4, "");
                    } catch (Exception unused2) {
                        ReportController.o(p16, "CliOper", "", "", "0X8005FFE", "0X8005FFE", round, 0, Long.toString(serverTime), "0", GetString4, "");
                    }
                } else {
                    ReportController.o(p16, "CliOper", "", "", "0X8005FFE", "0X8005FFE", round, 0, Long.toString(serverTime), "0", GetString4, "");
                }
                com.tencent.mobileqq.ark.g.a(p16, this.f199566b, GetString4, round);
            }
            return true;
        }
        if (str.equals("ReportEx")) {
            return p0(variantWrapperArr);
        }
        if (str.equals("GetVersion")) {
            return m0(variantWrapper);
        }
        if (str.equals("GetBizsrc")) {
            return i0(variantWrapper);
        }
        if (str.equals("Log")) {
            long length = variantWrapperArr != null ? variantWrapperArr.length : 0L;
            if (length <= 0) {
                return true;
            }
            ark.VariantWrapper variantWrapper5 = variantWrapperArr[0];
            int GetType = variantWrapper5.GetType();
            int k06 = k0(variantWrapperArr, length);
            if (GetType == 0) {
                QLog.i("ArkApp.QQLog", k06, "none");
                return true;
            }
            if (GetType == 1) {
                QLog.i("ArkApp.QQLog", k06, "null");
            } else if (GetType == 2) {
                QLog.i("ArkApp.QQLog", k06, variantWrapper5.GetBool() ? "true" : "false");
            } else if (GetType == 3) {
                QLog.i("ArkApp.QQLog", k06, Integer.toString(variantWrapper5.GetInt()));
            } else if (GetType == 4) {
                QLog.i("ArkApp.QQLog", k06, Double.toString(variantWrapper5.GetDouble()));
            } else if (GetType == 5) {
                QLog.i("ArkApp.QQLog", k06, variantWrapper5.GetString());
            } else if (variantWrapper5.IsFunction()) {
                QLog.i("ArkApp.QQLog", k06, "Function Object");
            } else if (variantWrapper5.IsUserObject()) {
                QLog.i("ArkApp.QQLog", k06, "User Object");
            } else if (!variantWrapper5.IsArray() && !variantWrapper5.IsTable()) {
                QLog.i("ArkApp.QQLog", k06, "Unknown Object");
            } else {
                QLog.i("ArkApp.QQLog", k06, variantWrapper5.GetTableAsJsonString());
            }
            return true;
        }
        if (str.equals("GetContainerInfo")) {
            long GetView = (variantWrapperArr == null || variantWrapperArr.length < 1 || !variantWrapperArr[0].IsView()) ? 0L : variantWrapperArr[0].GetView();
            HashMap hashMap3 = new HashMap();
            BaseArkAppContainer h07 = h0(GetView);
            if (h07 != null && (msgRecord = (MsgRecord) h07.getContactData()) != null) {
                hashMap3.put("MsgId", msgRecord.getMsgId() + "");
                hashMap3.put("SendUin", msgRecord.getSenderUin() + "");
            }
            if (h07 != null && ((IAIOMsgItemApi) QRoute.api(IAIOMsgItemApi.class)).isNtArkAppContainer(h07)) {
                hashMap3.put("ChatUIN", h07.getPeerUin());
                hashMap3.put("ChatType", String.valueOf(b0(h07.getChatType())));
                if (h07.getChatType() == 2 && !TextUtils.isEmpty(h07.getPeerUin())) {
                    hashMap3.put("AnonymousStatus", com.tencent.biz.anonymous.a.h().d(h07.getPeerUin()) ? "1" : "0");
                }
            } else if (h07 instanceof tp0.a) {
                hashMap3.put("ChatUIN", h07.getPeerUin());
                hashMap3.put("ChatType", String.valueOf(h07.getChatType()));
                hashMap3.put("GuildId", h07.getTroopUin());
            }
            if (QLog.isColorLevel()) {
                z18 = true;
                QLog.i("ArkApp.ArkAppQQModule", 1, "GetContainerInfo info= " + hashMap3.toString());
            } else {
                z18 = true;
            }
            variantWrapper.SetMap(hashMap3);
            return z18;
        }
        if (str.equals("DataRequest")) {
            variantWrapper.CreateObject("DataRequest", new com.tencent.mobileqq.activity.aio.item.e(ArkAppQQModuleBase.p(), this.f199566b));
            return true;
        }
        if (str.equals("GetPerformance")) {
            if (variantWrapperArr == null || variantWrapperArr.length < 1) {
                z17 = true;
            } else {
                String GetString5 = variantWrapperArr[0].GetString();
                if (TextUtils.isEmpty(GetString5)) {
                    z17 = true;
                } else {
                    MessageForArkApp l3 = com.tencent.mobileqq.activity.aio.item.b.l(GetString5);
                    if (l3 == null || (bVar = l3.arkContainer) == null) {
                        z17 = true;
                        QLog.i("ArkApp.ArkAppQQModule", 1, "QQ.GetPerformance, arkAppMsg is null, viewID=" + GetString5);
                    } else {
                        ArkAppInfo.TimeRecord timeRecord = bVar.f179266c;
                        if (timeRecord == null) {
                            QLog.i("ArkApp.ArkAppQQModule", 1, "QQ.GetPerformance, timeRecord is null, viewID=" + GetString5);
                            z17 = true;
                        } else {
                            try {
                                JSONObject jSONObject3 = new JSONObject();
                                JSONObject jSONObject4 = new JSONObject();
                                jSONObject3.put("Timing", jSONObject4);
                                jSONObject4.put("GetApplicationStart", timeRecord.beginOfGetApp + 0.01d);
                                jSONObject4.put("GetApplicationEnd", timeRecord.endOfGetApp + 0.01d);
                                jSONObject4.put("FetchApplicationStart", timeRecord.beginOfGetApp + 0.01d);
                                jSONObject4.put("FetchApplicationEnd", timeRecord.endOfGetApp + 0.01d);
                                jSONObject4.put("CreateViewStart", timeRecord.mRecord.beginOfCreateView + 0.01d);
                                jSONObject4.put("CreateViewEnd", timeRecord.mRecord.endOfCreateView + 0.01d);
                                jSONObject4.put("DisplayViewStart", timeRecord.mRecord.beginOfDisplyView + 0.01d);
                                jSONObject4.put("DisplayViewEnd", timeRecord.mRecord.endOfDisplyView + 0.01d);
                                JSONObject jSONObject5 = new JSONObject();
                                jSONObject3.put("Navigation", jSONObject5);
                                jSONObject5.put("FetchApplicationFromCache", timeRecord.getAppFromLocal ? 1 : 0);
                                str4 = jSONObject3.toString();
                                z17 = true;
                            } catch (Exception e19) {
                                z17 = true;
                                QLog.i("ArkApp.ArkAppQQModule", 1, "QQ.GetPerformance, json exception, msg=" + e19.getMessage());
                                str4 = null;
                            }
                            if (!TextUtils.isEmpty(str4)) {
                                variantWrapper.SetTableAsJsonString(str4);
                                return z17;
                            }
                        }
                    }
                }
            }
            variantWrapper.SetNull();
            return z17;
        }
        if (str.equals("GetCurrentPosition")) {
            if (this.f198969o == null || variantWrapperArr == null || variantWrapperArr.length < 1 || (variantWrapper4 = variantWrapperArr[0]) == null || !variantWrapper4.IsFunction()) {
                return false;
            }
            if (QLog.isColorLevel()) {
                QLog.i("ArkApp.ArkAppQQModule", 2, "GetCurrentPosition.app." + this.f199566b);
            }
            this.f198969o.h(new a(g(variantWrapperArr[0].Copy())));
            return true;
        }
        if (str.equals("WatchPosition")) {
            if (this.f198969o == null || variantWrapperArr == null || variantWrapperArr.length < 1 || (variantWrapper3 = variantWrapperArr[0]) == null || !variantWrapper3.IsFunction()) {
                return false;
            }
            if (QLog.isColorLevel()) {
                QLog.i("ArkApp.ArkAppQQModule", 2, "WatchPosition.app." + this.f199566b);
            }
            this.f198969o.i(new e(g(variantWrapperArr[0].Copy())));
            return true;
        }
        if (str.equals("ClearWatch")) {
            ArkAppLocationManager arkAppLocationManager = this.f198969o;
            if (arkAppLocationManager == null) {
                return false;
            }
            arkAppLocationManager.j();
            return true;
        }
        if (str.equals("GetCurrentAddress")) {
            if (this.f198969o == null || variantWrapperArr == null || variantWrapperArr.length < 1 || (variantWrapper2 = variantWrapperArr[0]) == null || !variantWrapper2.IsFunction()) {
                return false;
            }
            this.f198969o.g(new f(g(variantWrapperArr[0].Copy())), true);
            return true;
        }
        if (str.equals("GetPskeyAsync")) {
            if (variantWrapperArr == null || variantWrapperArr.length < 2 || !variantWrapperArr[0].IsString()) {
                i17 = 1;
            } else {
                i17 = 1;
                if (variantWrapperArr[1].IsFunction()) {
                    String GetString6 = variantWrapperArr[0].GetString();
                    final long g16 = g(variantWrapperArr[1].Copy());
                    com.tencent.mobileqq.ark.api.module.a.f(GetString6, new a.n.c() { // from class: com.tencent.mobileqq.ark.api.module.ArkAppQQModule.4
                        @Override // com.tencent.mobileqq.ark.api.module.a.n.c
                        public void a(final String str11) {
                            ArkDispatchTask.getInstance().post(((com.tencent.mobileqq.ark.module.b) ArkAppQQModule.this).f199566b, new Runnable() { // from class: com.tencent.mobileqq.ark.api.module.ArkAppQQModule.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                    ArkAppQQModule.this.f0(g16, str11);
                                }
                            });
                        }
                    });
                    return true;
                }
            }
            QLog.e("ArkApp.ArkAppQQModule", i17, "GetPskeyAsync.param error");
            return false;
        }
        if (str.equals(AegisLogger.LOGIN)) {
            if (!com.tencent.mobileqq.ark.module.a.a(this.f199566b, this.f199565a, this.f199570f, "permission.LOGIN")) {
                QLog.e("ArkApp.ArkAppQQModule", 1, "Login.permission not allow");
                return false;
            }
            if (variantWrapperArr == null || variantWrapperArr.length < 2 || !variantWrapperArr[0].IsString()) {
                i16 = 1;
                z16 = false;
            } else {
                if (variantWrapperArr[1].IsFunction()) {
                    try {
                        final long parseLong = Long.parseLong(variantWrapperArr[0].GetString());
                        QQAppInterface p17 = ArkAppQQModuleBase.p();
                        if (p17 == null) {
                            c18 = 1;
                            currentAccountUin = null;
                        } else {
                            currentAccountUin = p17.getCurrentAccountUin();
                            c18 = 1;
                        }
                        final long g17 = g(variantWrapperArr[c18].Copy());
                        final String str11 = currentAccountUin;
                        ((IArkModuleAPIAuthority) QRoute.api(IArkModuleAPIAuthority.class)).showAuthDialog(currentAccountUin, this.f199566b, this.f199568d, IArkModuleAPIAuthority.ARK_AUTHORITY_API_LOGIN, BaseApplication.getContext().getString(R.string.f170436qu), new com.tencent.mobileqq.ark.module.f() { // from class: com.tencent.mobileqq.ark.api.module.ArkAppQQModule.5
                            @Override // com.tencent.mobileqq.ark.module.f
                            public void onFail() {
                                ArkDispatchTask.getInstance().post(((com.tencent.mobileqq.ark.module.b) ArkAppQQModule.this).f199566b, new Runnable() { // from class: com.tencent.mobileqq.ark.api.module.ArkAppQQModule.5.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                                        ArkAppQQModule.this.a0(g17, str11, 16L, parseLong, 2);
                                    }
                                });
                            }

                            @Override // com.tencent.mobileqq.ark.module.f
                            public void onSuccess() {
                                ArkDispatchTask.getInstance().post(((com.tencent.mobileqq.ark.module.b) ArkAppQQModule.this).f199566b, new Runnable() { // from class: com.tencent.mobileqq.ark.api.module.ArkAppQQModule.5.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                                        ArkAppQQModule.this.a0(g17, str11, 16L, parseLong, 1);
                                    }
                                });
                            }
                        });
                        return true;
                    } catch (NumberFormatException e26) {
                        QLog.e("ArkApp.ArkAppQQModule", 1, "Login.Exception:" + e26.getMessage());
                        return false;
                    }
                }
                z16 = false;
                i16 = 1;
            }
            QLog.e("ArkApp.ArkAppQQModule", i16, "Login.param error");
            return z16;
        }
        if (str.equals("GetUserInformation")) {
            if (!com.tencent.mobileqq.ark.module.a.a(this.f199566b, this.f199565a, this.f199570f, "permission.USER_INFORMATION")) {
                QLog.e("ArkApp.ArkAppQQModule", 1, "GetUserInformation.permission not allow");
                return false;
            }
            if (variantWrapperArr == null || variantWrapperArr.length < 1) {
                i3 = 1;
            } else {
                if (variantWrapperArr[0].IsFunction()) {
                    if (TextUtils.isEmpty(this.f199566b)) {
                        QLog.e("ArkApp.ArkAppQQModule", 1, "GetUserInformation.error app is null, app=" + this.f199566b);
                        return false;
                    }
                    final long g18 = g(variantWrapperArr[0].Copy());
                    QQAppInterface p18 = ArkAppQQModuleBase.p();
                    final String currentUin = p18 != null ? p18.getCurrentUin() : null;
                    ((IArkModuleAPIAuthority) QRoute.api(IArkModuleAPIAuthority.class)).showAuthDialog(currentUin, this.f199566b, this.f199568d, IArkModuleAPIAuthority.ARK_AUTHORITY_API_USER_INFO, BaseApplication.getContext().getString(R.string.f170437qz), new com.tencent.mobileqq.ark.module.f() { // from class: com.tencent.mobileqq.ark.api.module.ArkAppQQModule.6
                        @Override // com.tencent.mobileqq.ark.module.f
                        public void onFail() {
                            ArkDispatchTask.getInstance().post(((com.tencent.mobileqq.ark.module.b) ArkAppQQModule.this).f199566b, new Runnable() { // from class: com.tencent.mobileqq.ark.api.module.ArkAppQQModule.6.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                                    ArkAppQQModule.this.Z(g18, currentUin, 2);
                                }
                            });
                        }

                        @Override // com.tencent.mobileqq.ark.module.f
                        public void onSuccess() {
                            ArkDispatchTask.getInstance().post(((com.tencent.mobileqq.ark.module.b) ArkAppQQModule.this).f199566b, new Runnable() { // from class: com.tencent.mobileqq.ark.api.module.ArkAppQQModule.6.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                                    ArkAppQQModule.this.Z(g18, currentUin, 1);
                                }
                            });
                        }
                    });
                    return true;
                }
                i3 = 1;
            }
            QLog.e("ArkApp.ArkAppQQModule", i3, "GetUserInformation.param error");
            return false;
        }
        if (str.equals("TestGetJson")) {
            return variantWrapper.SetTableAsJsonString("{ \"ret\":0, \"msg\":\"ok\", \"data\":{ \"param_array\": [ 3.1400000000000001, true, \"hello\", { \"param10\": 10, \"param11\": 10.1, \"param12\": true, \"param13\": \"hello 10\" }, { }, 1 ], \"param_bool_false\": false, \"param_bool_true\": true, \"param_double\": 3.1400000000000001, \"param_int\": 0, \"param_int2\": -1, \"param_int3\": 1001, \"param_str_empty\": \"\", \"param_str_hello\": \"hello\", \"param_table\": { \"param1\": 0, \"param2\": 3.1400000000000001, \"param3\": true, \"param4\": \"hello\", \"param5\": { }, \"param6\": { \"param10\": 10, \"param11\": 10.1, \"param12\": true, \"param13\": \"hello 10\" }, \"param7\": \"\" } }}");
        }
        if (str.equals("OpenView")) {
            if (!com.tencent.mobileqq.ark.module.a.a(this.f199566b, this.f199565a, this.f199570f, "permission.OPENVIEW")) {
                return false;
            }
            if (variantWrapperArr == null || variantWrapperArr.length < 4 || !variantWrapperArr[0].IsView() || !variantWrapperArr[1].IsString() || !variantWrapperArr[2].IsString() || (!variantWrapperArr[3].IsArray() && !variantWrapperArr[3].IsTable())) {
                return true;
            }
            long GetView2 = variantWrapperArr[0].GetView();
            final String GetString7 = variantWrapperArr[1].GetString();
            final String GetString8 = variantWrapperArr[2].GetString();
            final String GetTableAsJsonString = variantWrapperArr[3].GetTableAsJsonString();
            QLog.d("ArkOpenView", 1, "OpenView holder=" + GetView2 + ", type=" + GetString7 + ", view=" + GetString8 + ", meta=" + GetTableAsJsonString);
            ArkDispatchTask.getInstance().postToMainThread(new Runnable() { // from class: com.tencent.mobileqq.ark.api.module.ArkAppQQModule.7
                @Override // java.lang.Runnable
                public void run() {
                    QQCustomDialog qQCustomDialog;
                    if (GetString7.equals(ReportConst.ACTION.FULLSCREEN)) {
                        com.tencent.mobileqq.ark.g.b(null, ((com.tencent.mobileqq.ark.module.b) ArkAppQQModule.this).f199566b, "FullScreenOrH5Show", 0, 0, 0L, 0L, 0L, "", "");
                        Activity f19 = ArkAppQQModuleBase.f();
                        if (f19 instanceof BaseActivity) {
                            com.tencent.mobileqq.ark.g.b(null, ((com.tencent.mobileqq.ark.module.b) ArkAppQQModule.this).f199566b, "FullScreenOrH5ShowForAI", 0, 0, 0L, 0L, 0L, "", "");
                            ArkFullScreenAppActivity.W2((BaseActivity) f19, ((com.tencent.mobileqq.ark.module.b) ArkAppQQModule.this).f199567c, GetString8, ((com.tencent.mobileqq.ark.module.b) ArkAppQQModule.this).f199568d, Constants.DEFAULT_MIN_APP_VERSION, GetTableAsJsonString, com.tencent.mobileqq.ark.f.c(), null, 0);
                            return;
                        }
                        return;
                    }
                    if (GetString7.equals("popup")) {
                        Activity f26 = ArkAppQQModuleBase.f();
                        if (f26 instanceof BaseActivity) {
                            Bundle a16 = QQCustomArkDialog.b.a(((com.tencent.mobileqq.ark.module.b) ArkAppQQModule.this).f199567c, GetString8, ((com.tencent.mobileqq.ark.module.b) ArkAppQQModule.this).f199568d, Constants.DEFAULT_MIN_APP_VERSION, GetTableAsJsonString, com.tencent.mobileqq.ark.f.c(), null, null);
                            if (ArkAppQQModule.this.f198971q != null && (qQCustomDialog = (QQCustomDialog) ArkAppQQModule.this.f198971q.get()) != null && qQCustomDialog.isShowing()) {
                                qQCustomDialog.dismiss();
                            }
                            QQCustomArkDialogForAio a17 = ak.a(f26, null, a16);
                            a17.setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null);
                            a17.setPositiveButton(R.string.f171151ok, (DialogInterface.OnClickListener) null);
                            ArkAppQQModule.this.f198971q = new WeakReference(a17);
                            a17.show();
                            com.tencent.mobileqq.ark.g.c(null, "ShowView", ((com.tencent.mobileqq.ark.module.b) ArkAppQQModule.this).f199566b, null, com.tencent.mobileqq.ark.g.f199496g, 0, 0);
                            return;
                        }
                        return;
                    }
                    if (GetString7.equals("bottom_card")) {
                        Activity f27 = ArkAppQQModuleBase.f();
                        if (f27 instanceof BaseActivity) {
                            ArkFullScreenAppActivity.V2((BaseActivity) f27, "com.tencent.cmgame.intent", "GameCard", ((com.tencent.mobileqq.ark.module.b) ArkAppQQModule.this).f199568d, GetTableAsJsonString);
                        }
                    }
                }
            });
            return true;
        }
        if (str.equals("CloseView")) {
            if (!com.tencent.mobileqq.ark.module.a.a(this.f199566b, this.f199565a, this.f199570f, "permission.OPENVIEW")) {
                return false;
            }
            if (variantWrapperArr != null && variantWrapperArr.length >= 1 && variantWrapperArr[0].IsView()) {
                final long GetView3 = variantWrapperArr[0].GetView();
                ArkDispatchTask.getInstance().postToMainThread(new Runnable() { // from class: com.tencent.mobileqq.ark.api.module.ArkAppQQModule.8
                    @Override // java.lang.Runnable
                    public void run() {
                        BaseArkAppContainer baseArkAppContainer;
                        WeakReference<BaseArkAppContainer> containerWrapperByHandle = BaseArkAppContainer.getContainerWrapperByHandle(ark.arkGetContainer(GetView3));
                        if (containerWrapperByHandle != null && (baseArkAppContainer = containerWrapperByHandle.get()) != null) {
                            baseArkAppContainer.doCloseViewEvent();
                        }
                    }
                });
            }
            return true;
        }
        if (str.equals("ShareView")) {
            if (!com.tencent.mobileqq.ark.module.a.a(this.f199566b, this.f199565a, this.f199570f, "permission.SHARE")) {
                return false;
            }
            if (variantWrapperArr == null || variantWrapperArr.length < 2 || !variantWrapperArr[0].IsString()) {
                return true;
            }
            if (!variantWrapperArr[1].IsArray() && !variantWrapperArr[1].IsTable()) {
                return true;
            }
            final String GetString9 = variantWrapperArr[0].GetString();
            final String GetTableAsJsonString2 = variantWrapperArr[1].GetTableAsJsonString();
            final String j06 = j0(variantWrapperArr);
            ArkDispatchTask.getInstance().postToMainThread(new Runnable() { // from class: com.tencent.mobileqq.ark.api.module.ArkAppQQModule.9
                @Override // java.lang.Runnable
                public void run() {
                    Intent L2;
                    Activity f19 = ArkAppQQModuleBase.f();
                    if (f19 != null && (L2 = ArkFullScreenAppActivity.L2(f19, GetString9, ((com.tencent.mobileqq.ark.module.b) ArkAppQQModule.this).f199566b, ((com.tencent.mobileqq.ark.module.b) ArkAppQQModule.this).f199568d, GetTableAsJsonString2, j06, com.tencent.mobileqq.ark.f.c())) != null) {
                        ForwardBaseOption.startForwardActivity(f19, L2);
                    }
                }
            });
            return true;
        }
        if (str.equals("ShowStatusBar")) {
            if (!com.tencent.mobileqq.ark.module.a.a(this.f199566b, this.f199565a, this.f199570f, "permission.STATUSBAR")) {
                return false;
            }
            if (variantWrapperArr == null || variantWrapperArr.length < 2 || !variantWrapperArr[0].IsView() || !variantWrapperArr[1].IsString()) {
                return true;
            }
            final long GetView4 = variantWrapperArr[0].GetView();
            final String GetString10 = variantWrapperArr[1].GetString();
            ArkDispatchTask.getInstance().postToMainThread(new Runnable() { // from class: com.tencent.mobileqq.ark.api.module.ArkAppQQModule.10
                @Override // java.lang.Runnable
                public void run() {
                    BaseArkAppContainer h08 = ArkAppQQModule.h0(GetView4);
                    if (h08 == null) {
                        QLog.w("ArkApp.ArkAppQQModule", 1, "ShowStatusBar: ark aio wrapper is null");
                        return;
                    }
                    Object contactData = h08.getContactData();
                    if (!(contactData instanceof MsgRecord)) {
                        QLog.w("ArkApp.ArkAppQQModule", 1, "ShowStatusBar: contactData is wrong");
                    } else {
                        com.tencent.mobileqq.ark.n.c().j(h08, (MsgRecord) contactData, GetString10, ArkAppQQModuleBase.p());
                    }
                }
            });
            return true;
        }
        if (str.equals("HideStatusBar")) {
            if (!com.tencent.mobileqq.ark.module.a.a(this.f199566b, this.f199565a, this.f199570f, "permission.STATUSBAR")) {
                return false;
            }
            if (variantWrapperArr != null && variantWrapperArr.length >= 1 && variantWrapperArr[0].IsView()) {
                final long GetView5 = variantWrapperArr[0].GetView();
                ArkDispatchTask.getInstance().postToMainThread(new Runnable() { // from class: com.tencent.mobileqq.ark.api.module.ArkAppQQModule.11
                    @Override // java.lang.Runnable
                    public void run() {
                        BaseArkAppContainer h08 = ArkAppQQModule.h0(GetView5);
                        if (h08 != null) {
                            Object myContext = h08.getMyContext();
                            if (myContext instanceof com.tencent.aio.api.runtime.a) {
                                com.tencent.mobileqq.ark.n.c().d((com.tencent.aio.api.runtime.a) myContext);
                            }
                        }
                    }
                });
            }
            return true;
        }
        boolean z28 = true;
        if (str.equals("ShowToast")) {
            if (variantWrapperArr != null && variantWrapperArr.length >= 1) {
                final String GetString11 = variantWrapperArr[0].GetString();
                final int GetInt = variantWrapperArr[1].GetInt();
                if (GetInt <= 0) {
                    GetInt = 2000;
                }
                if (QLog.isColorLevel()) {
                    z28 = true;
                    QLog.d("ArkApp.ArkAppQQModule", 1, "ShowToast: " + GetString11 + " duration" + GetInt);
                } else {
                    z28 = true;
                }
                ArkDispatchTask.getInstance().postToMainThread(new Runnable() { // from class: com.tencent.mobileqq.ark.api.module.ArkAppQQModule.12
                    @Override // java.lang.Runnable
                    public void run() {
                        BaseApplication context = BaseApplication.getContext();
                        if (context == null) {
                            return;
                        }
                        QQToast.makeText(context, GetString11, GetInt).show();
                    }
                });
            }
            return z28;
        }
        if (str.equals("SetNavigationBarTitle")) {
            if (variantWrapperArr != null && variantWrapperArr.length >= 2 && variantWrapperArr[0].IsView() && variantWrapperArr[1].IsString()) {
                final long GetView6 = variantWrapperArr[0].GetView();
                final String GetString12 = variantWrapperArr[1].GetString();
                ArkDispatchTask.getInstance().postToMainThread(new Runnable() { // from class: com.tencent.mobileqq.ark.api.module.ArkAppQQModule.13
                    @Override // java.lang.Runnable
                    public void run() {
                        BaseArkAppContainer baseArkAppContainer;
                        ark.Container arkGetContainer = ark.arkGetContainer(GetView6);
                        if (arkGetContainer == null) {
                            return;
                        }
                        Activity f19 = ArkAppQQModuleBase.f();
                        if (f19 instanceof ArkFullScreenAppActivity) {
                            ArkFullScreenAppActivity arkFullScreenAppActivity = (ArkFullScreenAppActivity) f19;
                            WeakReference<BaseArkAppContainer> containerWrapperByHandle = BaseArkAppContainer.getContainerWrapperByHandle(arkGetContainer);
                            if (containerWrapperByHandle != null && (baseArkAppContainer = containerWrapperByHandle.get()) != null) {
                                arkFullScreenAppActivity.Y2(baseArkAppContainer, GetString12);
                            }
                        }
                    }
                });
            }
            return true;
        }
        if (str.equals("ShowShareMenu")) {
            if (variantWrapperArr != null && variantWrapperArr.length >= 1 && variantWrapperArr[0].IsView()) {
                final long GetView7 = variantWrapperArr[0].GetView();
                ArkDispatchTask.getInstance().postToMainThread(new Runnable() { // from class: com.tencent.mobileqq.ark.api.module.ArkAppQQModule.14
                    @Override // java.lang.Runnable
                    public void run() {
                        BaseArkAppContainer baseArkAppContainer;
                        ark.Container arkGetContainer = ark.arkGetContainer(GetView7);
                        if (arkGetContainer == null) {
                            return;
                        }
                        Activity f19 = ArkAppQQModuleBase.f();
                        if (f19 instanceof ArkFullScreenAppActivity) {
                            ArkFullScreenAppActivity arkFullScreenAppActivity = (ArkFullScreenAppActivity) f19;
                            WeakReference<BaseArkAppContainer> containerWrapperByHandle = BaseArkAppContainer.getContainerWrapperByHandle(arkGetContainer);
                            if (containerWrapperByHandle != null && (baseArkAppContainer = containerWrapperByHandle.get()) != null) {
                                arkFullScreenAppActivity.U2(baseArkAppContainer, true);
                            }
                        }
                    }
                });
            }
            return true;
        }
        if (str.equals("HideShareMenu")) {
            if (variantWrapperArr == null || variantWrapperArr.length < 1) {
                return true;
            }
            if (variantWrapperArr[0].IsView()) {
                final long GetView8 = variantWrapperArr[0].GetView();
                ArkDispatchTask.getInstance().postToMainThread(new Runnable() { // from class: com.tencent.mobileqq.ark.api.module.ArkAppQQModule.15
                    @Override // java.lang.Runnable
                    public void run() {
                        BaseArkAppContainer baseArkAppContainer;
                        ark.Container arkGetContainer = ark.arkGetContainer(GetView8);
                        if (arkGetContainer == null) {
                            return;
                        }
                        Activity f19 = ArkAppQQModuleBase.f();
                        if (f19 instanceof ArkFullScreenAppActivity) {
                            ArkFullScreenAppActivity arkFullScreenAppActivity = (ArkFullScreenAppActivity) f19;
                            WeakReference<BaseArkAppContainer> containerWrapperByHandle = BaseArkAppContainer.getContainerWrapperByHandle(arkGetContainer);
                            if (containerWrapperByHandle != null && (baseArkAppContainer = containerWrapperByHandle.get()) != null) {
                                arkFullScreenAppActivity.U2(baseArkAppContainer, false);
                            }
                        }
                    }
                });
            }
            return true;
        }
        if (str.equals("PreviewImage")) {
            if (variantWrapperArr == null || variantWrapperArr.length < 2) {
                return true;
            }
            if ((!variantWrapperArr[0].IsArray() && !variantWrapperArr[0].IsTable()) || variantWrapperArr[1].GetType() != 4) {
                return true;
            }
            String GetTableAsJsonString3 = variantWrapperArr[0].GetTableAsJsonString();
            final ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(GetTableAsJsonString3);
                for (int i19 = 0; i19 < jSONArray.length(); i19++) {
                    String optString2 = jSONArray.optString(i19);
                    if (!TextUtils.isEmpty(optString2)) {
                        if (!optString2.startsWith("http://") && !optString2.startsWith("https://")) {
                            optString2 = this.f199570f.GetSystemPathFromLocal(optString2);
                            if (TextUtils.isEmpty(optString2)) {
                            }
                        }
                        arrayList.add(optString2);
                    }
                }
                final int round2 = (int) Math.round(variantWrapperArr[1].GetDouble());
                ArkDispatchTask.getInstance().postToMainThread(new Runnable() { // from class: com.tencent.mobileqq.ark.api.module.ArkAppQQModule.16
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            Activity f19 = ArkAppQQModuleBase.f();
                            if (f19 != null) {
                                Intent intent = new Intent(f19, (Class<?>) TroopAvatarWallPreviewActivity.class);
                                Bundle bundle = new Bundle();
                                bundle.putInt("index", round2);
                                bundle.putStringArrayList(TroopAvatarWallPreviewActivity.KEY_SEQ_NUM, arrayList);
                                bundle.putBoolean("needBottomBar", false);
                                bundle.putBoolean("IS_EDIT", false);
                                bundle.putBoolean("is_use_path", true);
                                bundle.putBoolean("is_show_action", true);
                                bundle.putBoolean(TroopAvatarWallPreviewActivity.KEY_IS_NOT_SHOW_INDEX, false);
                                bundle.putBoolean("is_index_show_bottom", true);
                                intent.putExtras(bundle);
                                f19.startActivity(intent);
                            } else {
                                QLog.i("ArkApp", 1, "QQ.PreviewImage top activity is null");
                            }
                        } catch (Exception e27) {
                            QLog.e("ArkApp", 1, "QQ_MODULE_API_PREVIEW_IMAGE error = " + e27.getMessage());
                        }
                    }
                });
                return true;
            } catch (JSONException e27) {
                if (!QLog.isColorLevel()) {
                    return true;
                }
                QLog.i("ArkApp", 1, "QQ.PreviewImage parameter error: " + e27.getMessage());
                return true;
            }
        }
        if (str.equals("Notify")) {
            if (variantWrapperArr != null && variantWrapperArr.length >= 3) {
                variantWrapper.SetBool(((IArkAPIService) QRoute.api(IArkAPIService.class)).dispatchAppNotification(variantWrapperArr[0].GetString(), variantWrapperArr[1].GetString(), variantWrapperArr[2].GetTableAsJsonString()));
            }
            return true;
        }
        if (str.equals("SetTalkBackText")) {
            QLog.i("ArkApp.ArkAppQQModule", 1, "set talkback text");
            if (variantWrapperArr != null && variantWrapperArr.length >= 2 && variantWrapperArr[0].IsString() && variantWrapperArr[1].IsView()) {
                final String GetString13 = variantWrapperArr[0].GetString();
                final long GetView9 = variantWrapperArr[1].GetView();
                ArkDispatchTask.getInstance().postToMainThread(new Runnable() { // from class: com.tencent.mobileqq.ark.api.module.ArkAppQQModule.17
                    @Override // java.lang.Runnable
                    public void run() {
                        ark.Container arkGetContainer;
                        WeakReference<BaseArkAppContainer> containerWrapperByHandle;
                        View arkView;
                        MsgRecord msgRecord2;
                        String n3;
                        long j19 = GetView9;
                        if (j19 != 0 && (arkGetContainer = ark.arkGetContainer(j19)) != null && (containerWrapperByHandle = BaseArkAppContainer.getContainerWrapperByHandle(arkGetContainer)) != null) {
                            try {
                                BaseArkAppContainer baseArkAppContainer = containerWrapperByHandle.get();
                                if (baseArkAppContainer == null) {
                                    return;
                                }
                                baseArkAppContainer.setTalkBackText(GetString13);
                                ArkViewImplement viewImpl = baseArkAppContainer.getViewImpl();
                                if (viewImpl == null || (arkView = viewImpl.getArkView()) == null || (msgRecord2 = (MsgRecord) baseArkAppContainer.getContactData()) == null || (n3 = ArkMsgUtils.parseArkMsgModelFromMsgRecord(msgRecord2).n()) == null) {
                                    return;
                                }
                                StringBuilder sb5 = new StringBuilder();
                                if (msgRecord2.getSendType() == 1) {
                                    sb5.append("\u53d1\u51fa");
                                } else {
                                    sb5.append("\u53d1\u6765");
                                }
                                sb5.append(n3);
                                String talkBackText = baseArkAppContainer.getTalkBackText();
                                if (!TextUtils.isEmpty(talkBackText)) {
                                    sb5.append(talkBackText);
                                }
                                View g06 = ArkAppQQModule.g0(arkView, "ArkContentView");
                                if (g06 != null) {
                                    g06.setContentDescription(sb5);
                                }
                            } catch (Exception e28) {
                                QLog.i("ArkApp.ArkAppQQModule", 1, "set talkback error\uff1a" + e28);
                            }
                        }
                    }
                });
            }
            return true;
        }
        if (str.equals("ChooseImage")) {
            if (variantWrapperArr == null || variantWrapperArr.length < 3) {
                return true;
            }
            final long g19 = g(variantWrapperArr[2].Copy());
            String GetTableAsJsonString4 = variantWrapperArr[1].GetTableAsJsonString();
            QLog.i("ArkApp", 1, "QQ.ChooseImage :num=" + variantWrapperArr[0].GetDouble() + " extraInfo=" + GetTableAsJsonString4);
            ark.Application application2 = this.f199570f;
            str2 = application2 != null ? application2.GetEngineResPath() : "";
            final int GetDouble = (int) variantWrapperArr[0].GetDouble();
            if (GetDouble <= 1) {
                GetDouble = 1;
            }
            if (GetDouble > 9) {
                GetDouble = 9;
            }
            try {
                final boolean optBoolean = !TextUtils.isEmpty(GetTableAsJsonString4) ? new JSONObject(GetTableAsJsonString4).optBoolean(ITroopAnnouncementHelperApi.CONTROL_INFO_COMPRESS) : false;
                j91.a.g().i(new a.InterfaceC10577a() { // from class: com.tencent.mobileqq.ark.api.module.ArkAppQQModule.18
                    @Override // j91.a.InterfaceC10577a
                    public void a(final String str12) {
                        ArkDispatchTask.getInstance().post(((com.tencent.mobileqq.ark.module.b) ArkAppQQModule.this).f199566b, new Runnable() { // from class: com.tencent.mobileqq.ark.api.module.ArkAppQQModule.18.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass18 anonymousClass18 = AnonymousClass18.this;
                                ark.VariantWrapper l16 = ArkAppQQModule.this.l(g19);
                                if (l16 == null) {
                                    j91.a.g().i(null);
                                    return;
                                }
                                ark.VariantWrapper Create = l16.Create();
                                Create.SetNull();
                                ark.VariantWrapper Create2 = l16.Create();
                                Create.SetTableAsJsonString(str12);
                                l16.InvokeDefault(new ark.VariantWrapper[]{Create}, Create2);
                                Create2.Reset();
                                Create.Reset();
                                l16.Reset();
                                QLog.i("ArkApp", 1, "QQ.ChooseImage callback : " + str12);
                                j91.a.g().i(null);
                            }
                        });
                    }
                });
                ArkDispatchTask.getInstance().postToMainThread(new Runnable() { // from class: com.tencent.mobileqq.ark.api.module.ArkAppQQModule.19
                    @Override // java.lang.Runnable
                    public void run() {
                        String appResPath = ArkEnvironmentManager.getInstance().getAppResPath(((com.tencent.mobileqq.ark.module.b) ArkAppQQModule.this).f199566b);
                        Activity f19 = ArkAppQQModuleBase.f();
                        if (f19 != null) {
                            Intent intent = new Intent(f19, (Class<?>) NewPhotoListActivity.class);
                            intent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", GetDouble);
                            intent.putExtra(IPhotoLogicFactory.ENTER_FROM, 3);
                            intent.putExtra(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, PhotoListCustomizationArk.I);
                            intent.putExtra(IPhotoLogicFactory.KEY_ALBUM_LIST_CLASS_NAME, AlbumListCustomizationArk.f184371j);
                            intent.putExtra(IPhotoLogicFactory.KEY_PHOTO_PREVIEW_CLASS_NAME, PhotoPreviewCustomizationArk.J);
                            intent.putExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", true);
                            intent.putExtra("key_ark_app_res_path", appResPath);
                            intent.putExtra("key_should_compress", optBoolean);
                            intent.putExtra("key_ark_app_engine_res_dir", str2);
                            intent.putExtra("FROM_ARK_CHOOSE_IMAGE", true);
                            intent.putExtra("FROM_WHERE", PhotoCommonBaseData.FROM_PHOTO_LIST);
                            f19.startActivity(intent);
                            return;
                        }
                        QLog.i("ArkApp", 1, "QQ.ChooseImage top activity is null");
                    }
                });
                return true;
            } catch (JSONException e28) {
                QLog.e("ArkApp.ArkAppQQModule", 1, "Error:", e28);
                return false;
            }
        }
        if (str.equals("GetAppID")) {
            variantWrapper.SetString(String.valueOf(AppSetting.f()));
            return true;
        }
        if (str.equals("GetAudioOutputMode")) {
            int c27 = com.tencent.mobileqq.ark.api.module.a.c();
            QLog.i("ArkApp.ArkAppQQModule", 1, "current audio status:" + c27);
            variantWrapper.SetInt(c27);
            return true;
        }
        if (str.equals("IsMute")) {
            boolean GetBool = (variantWrapperArr == null || variantWrapperArr.length != 1) ? false : variantWrapperArr[0].GetBool();
            AudioManager audioManager = (AudioManager) BaseApplicationImpl.sApplication.getSystemService("audio");
            if (audioManager == null) {
                return false;
            }
            try {
                boolean z29 = SystemMethodProxy.getStreamVolume(audioManager, 3) <= 0;
                if (z29 && GetBool) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (Math.abs(currentTimeMillis2 - f198965s) < 120000 && currentTimeMillis2 > f198965s) {
                        if (QLog.isColorLevel()) {
                            QLog.e("ArkApp.ArkAppQQModule", 2, "IsMute() do not show toast so frequently in 2 min");
                        }
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.e("ArkApp.ArkAppQQModule", 2, "IsMute() show toast");
                        }
                        f198965s = currentTimeMillis2;
                        d91.g arkPlatformConfig = ((IArkConfig) QRoute.api(IArkConfig.class)).getArkPlatformConfig();
                        if (arkPlatformConfig != null && arkPlatformConfig.c() != null) {
                            str2 = arkPlatformConfig.c().f395981k;
                        }
                        final Activity f19 = ArkAppQQModuleBase.f();
                        if (TextUtils.isEmpty(str2) && f19 != null) {
                            str2 = f19.getString(R.string.f170469s4);
                        }
                        ArkDispatchTask.getInstance().postToMainThread(new Runnable() { // from class: com.tencent.mobileqq.ark.api.module.ArkAppQQModule.20
                            @Override // java.lang.Runnable
                            public void run() {
                                Activity activity = f19;
                                if (activity != null) {
                                    QQToast.makeText(activity, str2, 0).show();
                                } else if (QLog.isColorLevel()) {
                                    QLog.e("ArkApp.ArkAppQQModule", 2, "IsMute() activity is null");
                                }
                            }
                        });
                    }
                }
                variantWrapper.SetBool(z29);
                return true;
            } catch (Exception e29) {
                QLog.e("ArkApp.ArkAppQQModule", 1, "IsMute() error:", e29);
                return false;
            }
        }
        if (!str.equals("GetNickNameByView")) {
            if (str.equals("GetAppInfo")) {
                JSONObject jSONObject6 = new JSONObject();
                try {
                    jSONObject6.put("package", BaseApplicationImpl.getApplication().getPackageName());
                    jSONObject6.put("name", BaseApplicationImpl.getApplication().getString(R.string.f170384pb));
                    String P = ah.P();
                    if (TextUtils.isEmpty(P)) {
                        P = AppSetting.f99551k;
                    }
                    jSONObject6.put("version", P);
                    r46 = 1;
                } catch (Exception e36) {
                    r46 = 1;
                    QLog.e("ArkApp.ArkAppQQModule", 1, "ark.GetAppInfo: ", e36);
                }
                if (QLog.isColorLevel()) {
                    Object[] objArr = new Object[2];
                    objArr[0] = "ark.GetAppInfo: ";
                    objArr[r46] = jSONObject6.toString();
                    QLog.d("ArkApp.ArkAppQQModule", 2, objArr);
                }
                variantWrapper.SetTableAsJsonString(jSONObject6.toString());
                return r46;
            }
            if (!str.equals("SubscribePublicAccount") || variantWrapperArr == null || variantWrapperArr.length < 3) {
                return false;
            }
            if (!variantWrapperArr[0].IsString() || !variantWrapperArr[2].IsFunction()) {
                return false;
            }
            long g26 = g(variantWrapperArr[2].Copy());
            try {
                if (variantWrapperArr[0].IsString()) {
                    str3 = variantWrapperArr[0].GetString();
                    c16 = 1;
                } else {
                    c16 = 1;
                    str3 = null;
                }
                if (((int) variantWrapperArr[c16].GetDouble()) == 0) {
                    com.tencent.biz.subscribe.utils.j.c(BaseApplication.getContext(), str3, new b(g26));
                    return true;
                }
                com.tencent.biz.subscribe.utils.j.g(BaseApplication.getContext(), str3, new c(g26));
                return true;
            } catch (Exception e37) {
                e37.printStackTrace();
                return true;
            }
        }
        if (variantWrapperArr != null) {
            j16 = variantWrapperArr.length;
            j3 = 0;
        } else {
            j3 = 0;
            j16 = 0;
        }
        if (j16 <= j3) {
            QLog.d("ArkApp.ArkAppQQModule", 1, "ark.GetNickNameByView invalid param args == 0 ");
            return false;
        }
        if (j16 >= 1 && variantWrapperArr[0].IsView()) {
            j3 = variantWrapperArr[0].GetView();
        }
        String GetString14 = (j16 < 2 || !variantWrapperArr[1].IsString()) ? null : variantWrapperArr[1].GetString();
        QQAppInterface p19 = ArkAppQQModuleBase.p();
        if (p19 == null) {
            QLog.d("ArkApp.ArkAppQQModule", 1, "ark.GetNickNameByView invalid param appInterface == null ");
            variantWrapper.SetString(com.tencent.mobileqq.ark.api.module.a.d(GetString14, j3));
            return true;
        }
        if (TextUtils.isEmpty(GetString14)) {
            GetString14 = p19.getCurrentAccountUin();
        }
        if (TextUtils.isEmpty(GetString14)) {
            return false;
        }
        BaseArkAppContainer h08 = h0(j3);
        String S = h08 != null ? ac.S(p19, h08.getChatType(), h08.getPeerUin(), h08.getPeerNick(), TextUtils.equals(GetString14, p19.getCurrentUin()), GetString14) : null;
        if (TextUtils.isEmpty(S) || TextUtils.equals(S, GetString14)) {
            S = ac.j(p19, GetString14);
            if (TextUtils.isEmpty(S)) {
                c17 = 0;
                S = ac.Q(p19, GetString14, 0);
                variantWrapper.SetString(S);
                if (S != null || !QLog.isColorLevel()) {
                    return true;
                }
                Object[] objArr2 = new Object[2];
                objArr2[c17] = "ark.GetNickNameByView ";
                objArr2[1] = S;
                QLog.d("ArkApp.ArkAppQQModule", 2, objArr2);
                return true;
            }
        }
        c17 = 0;
        variantWrapper.SetString(S);
        if (S != null) {
        }
        return true;
    }

    protected void c0(long j3, boolean z16, double d16, double d17) {
        ark.VariantWrapper d18 = d(j3);
        if (d18 == null) {
            return;
        }
        ark.VariantWrapper Create = d18.Create();
        Create.SetDouble(d16);
        ark.VariantWrapper Create2 = d18.Create();
        Create2.SetDouble(d17);
        ark.VariantWrapper Create3 = d18.Create();
        Create3.SetBool(z16);
        ark.VariantWrapper Create4 = d18.Create();
        d18.InvokeDefault(new ark.VariantWrapper[]{Create, Create2, Create3}, Create4);
        Create4.Reset();
        Create3.Reset();
        Create.Reset();
        Create2.Reset();
    }

    protected void d0(long j3, boolean z16, SosoLbsInfo sosoLbsInfo) {
        String str;
        ark.VariantWrapper l3 = l(j3);
        if (l3 == null) {
            return;
        }
        ark.VariantWrapper Create = l3.Create();
        if (sosoLbsInfo != null) {
            String a16 = r91.b.a();
            if (!TextUtils.isEmpty(a16)) {
                sosoLbsInfo.mLocation.city = a16;
            }
            double[] b16 = r91.b.b();
            if (b16 != null && b16.length == 2) {
                SosoLocation sosoLocation = sosoLbsInfo.mLocation;
                sosoLocation.mLat84 = b16[0];
                sosoLocation.mLon84 = b16[1];
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("prov", sosoLbsInfo.mLocation.province);
                jSONObject.put("city", sosoLbsInfo.mLocation.city);
                jSONObject.put("dist", sosoLbsInfo.mLocation.district);
                jSONObject.put("road", sosoLbsInfo.mLocation.street);
                jSONObject.put("town", sosoLbsInfo.mLocation.town);
                jSONObject.put(QCircleSchemeAttr.Polymerize.LAT, sosoLbsInfo.mLocation.mLat84);
                jSONObject.put("lng", sosoLbsInfo.mLocation.mLon84);
                str = jSONObject.toString();
            } catch (JSONException e16) {
                QLog.i("ArkApp.ArkAppQQModule", 1, e16.getMessage());
                str = "{}";
            }
            Create.SetTableAsJsonString(str);
        }
        ark.VariantWrapper Create2 = l3.Create();
        Create2.SetBool(z16);
        ark.VariantWrapper Create3 = l3.Create();
        l3.InvokeDefault(new ark.VariantWrapper[]{Create, Create2}, Create3);
        Create3.Reset();
        Create2.Reset();
        Create.Reset();
        l3.Reset();
    }

    @Override // com.tencent.mobileqq.ark.module.b
    protected com.tencent.mobileqq.ark.module.e[] e() {
        return new com.tencent.mobileqq.ark.module.e[]{new j(), new i(), new h(), new g(), new l(), new k(), new m(), new MethodSendMessage(), new MethodGetViewProperty()};
    }

    protected void e0(long j3, boolean z16, String str, int i3) {
        ark.VariantWrapper l3 = l(j3);
        if (l3 == null) {
            return;
        }
        ark.VariantWrapper Create = l3.Create();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uin", str);
            jSONObject.put("followState", i3);
            Create.SetTableAsJsonString(jSONObject.toString());
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        ark.VariantWrapper Create2 = l3.Create();
        Create2.SetBool(z16);
        ark.VariantWrapper Create3 = l3.Create();
        l3.InvokeDefault(new ark.VariantWrapper[]{Create, Create2}, Create3);
        Create3.Reset();
        Create2.Reset();
        Create.Reset();
        l3.Reset();
    }

    boolean i0(ark.VariantWrapper variantWrapper) {
        if (QLog.isColorLevel()) {
            QLog.i("ArkApp.ArkAppQQModule", 1, "QQ.getBizSrc" + this.f199568d);
        }
        if (!TextUtils.isEmpty(this.f199568d)) {
            variantWrapper.SetString(this.f199568d);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.ark.module.b
    public void m(List<c91.a> list) {
        super.m(list);
        a(QZoneJsConstants.METHOD_OPEN_URL, 1L, 500L);
        a("SendMessage", 1L, 500L);
    }

    boolean m0(ark.VariantWrapper variantWrapper) {
        String P = ah.P();
        if (TextUtils.isEmpty(P)) {
            P = AppSetting.f99551k;
        }
        variantWrapper.SetString(P);
        return true;
    }

    @Override // com.tencent.mobileqq.ark.module.b
    public boolean n() {
        return true;
    }

    @Override // com.tencent.mobileqq.ark.module.b
    public boolean o() {
        return true;
    }

    boolean p0(ark.VariantWrapper[] variantWrapperArr) {
        String str;
        String str2 = null;
        if (variantWrapperArr.length > 0) {
            str = variantWrapperArr[0].GetString();
        } else {
            str = null;
        }
        if (variantWrapperArr.length > 1) {
            str2 = variantWrapperArr[1].GetTableAsJsonString();
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (str.equals("898")) {
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    String string = jSONObject.getString("type");
                    String string2 = jSONObject.getString("name");
                    ReportController.n(null, "dc00898", "", jSONObject.optString(IProfileProtocolConst.PARAM_TARGET_UIN, ""), string, string2, jSONObject.optInt("entry", 0), jSONObject.optInt("count", 1), jSONObject.optInt("result", 0), Integer.toString(jSONObject.optInt("r1", 0)), Integer.toString(jSONObject.optInt("r2", 0)), jSONObject.optString("r3", ""), jSONObject.optString("r4", ""));
                    return true;
                } catch (JSONException unused) {
                    QLog.i("ArkApp.ArkAppQQModule", 1, "QQ.ReportEx, invalid report data, data=" + str2);
                    return false;
                }
            }
            if (str.equals("1160")) {
                try {
                    JSONObject jSONObject2 = new JSONObject(str2);
                    String string3 = jSONObject2.getString("name");
                    ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, jSONObject2.optString(IProfileProtocolConst.PARAM_TARGET_UIN, ""), string3, string3, 0, 0, String.valueOf(jSONObject2.optInt("r2", 0)), jSONObject2.optString("r3", ""), jSONObject2.optString("r4", ""), jSONObject2.optString("r5", ""), false);
                    return true;
                } catch (JSONException unused2) {
                    QLog.i("ArkApp.ArkAppQQModule", 1, "QQ.ReportEx, invalid report data, data=" + str2);
                    return false;
                }
            }
            if (str.equals("Beacon")) {
                try {
                    JSONObject jSONObject3 = new JSONObject(str2);
                    com.tencent.mobileqq.statistics.m.a(jSONObject3.getString(com.heytap.mcssdk.a.a.f36102l), jSONObject3.getString("event"), jSONObject3.getBoolean("isSuccess"), jSONObject3.getLong("elapse"), jSONObject3.getLong("size"), (HashMap) new Gson().fromJson(jSONObject3.getJSONObject("params").toString(), HashMap.class), jSONObject3.getBoolean("reportImmediately"), true);
                } catch (JSONException unused3) {
                    QLog.i("ArkApp.ArkAppQQModule", 1, "QQ.ReportEx.Beacon, invalid report data, data=" + str2);
                }
            }
            return false;
        }
        QLog.i("ArkApp.ArkAppQQModule", 1, "QQ.ReportEx, invalid arguments");
        return false;
    }
}
