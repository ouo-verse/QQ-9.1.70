package com.tencent.mobileqq.timiqqid.api.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.model.JoinTimeType;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.module.a;
import com.tencent.mobileqq.qroute.module.d;
import com.tencent.mobileqq.timiqqid.api.ITimiQQIDApi;
import com.tencent.mobileqq.timiqqid.api.impl.TimiQQIDApiImpl;
import com.tencent.mobileqq.timiqqid.browser.RealNameBrowserFragment;
import com.tencent.mobileqq.timiqqid.constants.QQIDConstants;
import com.tencent.mobileqq.timiqqid.helper.QQIDSpUtils;
import com.tencent.mobileqq.timiqqid.helper.YoloLog;
import com.tencent.mobileqq.timiqqid.net.QQIDHttpApi;
import com.tencent.mobileqq.timiqqid.net.l;
import com.tencent.mobileqq.tritonaudio.webaudio.AudioContext;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import kotlin.jvm.functions.Function0;
import org.json.JSONArray;
import org.json.JSONObject;
import pr2.c;
import pr2.d;
import rr2.j;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TimiQQIDApiImpl implements ITimiQQIDApi {
    private static final String TAG = "TimiQQIDApiImpl";

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements a.InterfaceC8440a {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ String c(boolean z16) {
            return "onOpenResult:" + z16;
        }

        @Override // com.tencent.mobileqq.qroute.module.a.InterfaceC8440a
        public void a(final boolean z16) {
            YoloLog.d(TimiQQIDApiImpl.TAG, new Function0() { // from class: com.tencent.mobileqq.timiqqid.api.impl.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    String c16;
                    c16 = TimiQQIDApiImpl.a.c(z16);
                    return c16;
                }
            });
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b implements pr2.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ pr2.a f293190a;

        b(pr2.a aVar) {
            this.f293190a = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ String b(int i3, String str) {
            return "setQQIDAlphaUser callback,code:" + i3 + ",msg:" + str;
        }

        @Override // pr2.a
        public void onCallback(final int i3, final String str) {
            YoloLog.d(TimiQQIDApiImpl.TAG, new Function0() { // from class: com.tencent.mobileqq.timiqqid.api.impl.b
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    String b16;
                    b16 = TimiQQIDApiImpl.b.b(i3, str);
                    return b16;
                }
            });
            if (i3 == 0) {
                QQIDSpUtils.save(QQIDSpUtils.IS_ALPHA_USER, true);
            }
            pr2.a aVar = this.f293190a;
            if (aVar != null) {
                aVar.onCallback(i3, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$checkIsQQIDAlphaUser$5() {
        return "checkIsQQIDAlphaUser called";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$checkIsQQIDAlphaUser$6() {
        return "checkIsQQIDAlphaUser,userCache && cache is ture,just callback";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$checkIsQQIDAlphaUser$7(Boolean bool, int i3, String str) {
        return "checkIsQQIDAlphaUser callback,isAlphaUser:" + bool + ",code:" + i3 + ",msg:" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$checkIsQQIDAlphaUser$8(pr2.b bVar, final Boolean bool, final int i3, final String str) {
        YoloLog.d(TAG, new Function0() { // from class: or2.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String lambda$checkIsQQIDAlphaUser$7;
                lambda$checkIsQQIDAlphaUser$7 = TimiQQIDApiImpl.lambda$checkIsQQIDAlphaUser$7(bool, i3, str);
                return lambda$checkIsQQIDAlphaUser$7;
            }
        });
        if (bVar != null) {
            bVar.a(bool, i3, str);
        }
        if (i3 == 0) {
            QQIDSpUtils.save(QQIDSpUtils.IS_ALPHA_USER, bool.booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$fetchYuekangmaData$0(Exception exc) {
        return "parse selfInfoJson failed," + exc.getMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$fetchYuekangmaData$1(Exception exc) {
        return "parse familyListJsonArray failed," + exc.getMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$fetchYuekangmaData$2(d dVar, EIPCResult eIPCResult) {
        int i3;
        int i16;
        int i17;
        String str;
        JSONObject jSONObject;
        JSONArray jSONArray;
        Bundle bundle;
        String str2 = "";
        if (eIPCResult != null && (bundle = eIPCResult.data) != null) {
            int i18 = bundle.getInt("error_domain", 0);
            int i19 = eIPCResult.data.getInt("error_code", 0);
            int i26 = eIPCResult.data.getInt("family_list_success", 0);
            String string = eIPCResult.data.getString("selfInfo", "");
            i17 = i26;
            str = eIPCResult.data.getString("family_list_info", "");
            i3 = i18;
            i16 = i19;
            str2 = string;
        } else {
            i3 = 0;
            i16 = 0;
            i17 = 0;
            str = "";
        }
        try {
            jSONObject = new JSONObject(str2);
        } catch (Exception e16) {
            e16.printStackTrace();
            YoloLog.e(TAG, new Function0() { // from class: or2.h
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    String lambda$fetchYuekangmaData$0;
                    lambda$fetchYuekangmaData$0 = TimiQQIDApiImpl.lambda$fetchYuekangmaData$0(e16);
                    return lambda$fetchYuekangmaData$0;
                }
            });
            jSONObject = null;
        }
        try {
            jSONArray = new JSONArray(str);
        } catch (Exception e17) {
            e17.printStackTrace();
            YoloLog.e(TAG, new Function0() { // from class: or2.i
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    String lambda$fetchYuekangmaData$1;
                    lambda$fetchYuekangmaData$1 = TimiQQIDApiImpl.lambda$fetchYuekangmaData$1(e17);
                    return lambda$fetchYuekangmaData$1;
                }
            });
            jSONArray = null;
        }
        dVar.a(i3, i16, i17, jSONObject, jSONArray);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$requestWxCode$3(pr2.b bVar, EIPCResult eIPCResult) {
        Bundle bundle;
        String str = "";
        if (eIPCResult != null && (bundle = eIPCResult.data) != null) {
            str = bundle.getString("wx_code", "");
        }
        bVar.a(str, 0, "success");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$setQQIDAlphaUser$4() {
        return "setQQIDAlphaUser called";
    }

    @Override // com.tencent.mobileqq.timiqqid.api.ITimiQQIDApi
    public void checkIsQQIDAlphaUser(boolean z16, String str, final pr2.b<Boolean> bVar) {
        YoloLog.d(TAG, new Function0() { // from class: or2.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String lambda$checkIsQQIDAlphaUser$5;
                lambda$checkIsQQIDAlphaUser$5 = TimiQQIDApiImpl.lambda$checkIsQQIDAlphaUser$5();
                return lambda$checkIsQQIDAlphaUser$5;
            }
        });
        boolean z17 = QQIDSpUtils.getBoolean(QQIDSpUtils.IS_ALPHA_USER, false);
        if (z16 && z17) {
            YoloLog.d(TAG, new Function0() { // from class: or2.e
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    String lambda$checkIsQQIDAlphaUser$6;
                    lambda$checkIsQQIDAlphaUser$6 = TimiQQIDApiImpl.lambda$checkIsQQIDAlphaUser$6();
                    return lambda$checkIsQQIDAlphaUser$6;
                }
            });
            bVar.a(Boolean.TRUE, 0, "return from cache");
        } else {
            l.c(str, new pr2.b() { // from class: or2.f
                @Override // pr2.b
                public final void a(Object obj, int i3, String str2) {
                    TimiQQIDApiImpl.lambda$checkIsQQIDAlphaUser$8(pr2.b.this, (Boolean) obj, i3, str2);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.timiqqid.api.ITimiQQIDApi
    public void fetchWxAppCode(String str, c cVar) {
        new j(str, "", cVar).r();
    }

    @Override // com.tencent.mobileqq.timiqqid.api.ITimiQQIDApi
    public void fetchYuekangmaData(int i3, String str, final d dVar) {
        Bundle bundle = new Bundle();
        bundle.putInt("type", i3);
        bundle.putString(QCircleScheme.AttrQQPublish.BUSINESS_RETURN_SCHEME, str);
        QIPCClientHelper.getInstance().callServer(ITimiQQIDApi.QQID_QIPC_SERVER_NAME, "fetch_yuekangma", bundle, new EIPCResultCallback() { // from class: or2.c
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                TimiQQIDApiImpl.lambda$fetchYuekangmaData$2(pr2.d.this, eIPCResult);
            }
        });
    }

    @Override // com.tencent.mobileqq.timiqqid.api.ITimiQQIDApi
    public void getNeedShowQQIDEntrance(pr2.b<Boolean> bVar) {
        bVar.a(Boolean.TRUE, 0, "hardcode open");
    }

    @Override // com.tencent.mobileqq.timiqqid.api.ITimiQQIDApi
    public QIPCModule getQQIDServerIPCModule() {
        return new qr2.d();
    }

    @Override // com.tencent.mobileqq.timiqqid.api.ITimiQQIDApi
    public int getSceneRecognitionEnable() {
        return QQIDSpUtils.getInt(QQIDSpUtils.SCENE_RECOGNITION_ENABLE_STATUS, 0);
    }

    @Override // com.tencent.mobileqq.timiqqid.api.ITimiQQIDApi
    public void openQQIDActivity(Context context, boolean z16) {
        Intent intent = new Intent();
        intent.setClassName(context, "com.tencent.mobileqq.timiqqid.activity.QQIDDemoActivity");
        QRoute.plugin("timi_qqid_df.apk").f(new d.b(context).d(intent).e(new a()).a());
    }

    @Override // com.tencent.mobileqq.timiqqid.api.ITimiQQIDApi
    public void openRealNameWebview(Context context, String str) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, "com.tencent.gamecenter.activities.SingleTaskQQBrowser"));
        intent.putExtra("url", str);
        intent.putExtra("force_no_reload", true);
        intent.addFlags(268435456);
        intent.putExtra("fragment_class", RealNameBrowserFragment.class.getName());
        context.startActivity(intent);
    }

    @Override // com.tencent.mobileqq.timiqqid.api.ITimiQQIDApi
    public void requestSceneRecognitionMaxAge(int i3, pr2.b<Long> bVar) {
        bVar.a(Long.valueOf(JoinTimeType.SEVEN_DAY), 0, "local success");
    }

    @Override // com.tencent.mobileqq.timiqqid.api.ITimiQQIDApi
    public void requestWxCode(String str, String str2, final pr2.b<String> bVar) {
        Bundle bundle = new Bundle();
        bundle.putString("wx_app_id", str);
        bundle.putString(QCircleScheme.AttrQQPublish.BUSINESS_RETURN_SCHEME, str2);
        QIPCClientHelper.getInstance().callServer(ITimiQQIDApi.QQID_QIPC_SERVER_NAME, "wx_login", bundle, new EIPCResultCallback() { // from class: or2.g
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                TimiQQIDApiImpl.lambda$requestWxCode$3(pr2.b.this, eIPCResult);
            }
        });
    }

    @Override // com.tencent.mobileqq.timiqqid.api.ITimiQQIDApi
    public void setQQIDAlphaUser(String str, @Nullable pr2.a aVar) {
        YoloLog.d(TAG, new Function0() { // from class: or2.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String lambda$setQQIDAlphaUser$4;
                lambda$setQQIDAlphaUser$4 = TimiQQIDApiImpl.lambda$setQQIDAlphaUser$4();
                return lambda$setQQIDAlphaUser$4;
            }
        });
        if (TextUtils.isEmpty(str)) {
            str = QQIDConstants.QQID_MINI_APP_ID;
        }
        l.f(str, new b(aVar));
    }

    @Override // com.tencent.mobileqq.timiqqid.api.ITimiQQIDApi
    public void setSceneRecognitionEnable(int i3, String str, pr2.a aVar) {
        QQIDSpUtils.save(QQIDSpUtils.SCENE_RECOGNITION_ENABLE_STATUS, i3);
        if (i3 == 1) {
            QQIDSpUtils.save(QQIDSpUtils.SCENE_RECOGNITION_OPEN_ID, str);
            aVar.onCallback(0, "opened");
        } else if (aVar != null) {
            aVar.onCallback(0, AudioContext.State.CLOSED);
        }
    }

    @Override // com.tencent.mobileqq.timiqqid.api.ITimiQQIDApi
    public void startFetchPassResult(@NonNull String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        QQIDHttpApi.i(str, str2);
    }

    @Override // com.tencent.mobileqq.timiqqid.api.ITimiQQIDApi
    public void stopFetchPassResult() {
        QQIDHttpApi.f();
    }

    @Override // com.tencent.mobileqq.timiqqid.api.ITimiQQIDApi
    public void init() {
    }
}
