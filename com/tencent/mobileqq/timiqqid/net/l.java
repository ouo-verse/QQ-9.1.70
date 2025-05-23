package com.tencent.mobileqq.timiqqid.net;

import android.os.Bundle;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.timiqqid.helper.YoloLog;
import com.tencent.mobileqq.timiqqid.net.l;
import com.tencent.trpcprotocol.miniapp.shenzhen_smart_city_support.shenzhen_smart_city_support.shenzhenSmartCitySupport$CheckAlphaUserReq;
import com.tencent.trpcprotocol.miniapp.shenzhen_smart_city_support.shenzhen_smart_city_support.shenzhenSmartCitySupport$CheckAlphaUserRsp;
import com.tencent.trpcprotocol.miniapp.shenzhen_smart_city_support.shenzhen_smart_city_support.shenzhenSmartCitySupport$SetAlphaUserReq;
import com.tencent.trpcprotocol.miniapp.shenzhen_smart_city_support.shenzhen_smart_city_support.shenzhenSmartCitySupport$SetAlphaUserRsp;
import kotlin.jvm.functions.Function0;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes18.dex */
public class l {

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ pr2.a f293220d;

        a(pr2.a aVar) {
            this.f293220d = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ String c() {
            return "receive OidbSvcTrpcTcp.0x116a_1 response";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ String d() {
            return "parse rsp failed";
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            YoloLog.d("QQIDSsoRequester", new Function0() { // from class: com.tencent.mobileqq.timiqqid.net.j
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    String c16;
                    c16 = l.a.c();
                    return c16;
                }
            });
            int i16 = bundle.getInt("result_code");
            byte[] byteArray = bundle.getByteArray("rsp_data");
            if (z16) {
                try {
                    new MessageMicro<shenzhenSmartCitySupport$SetAlphaUserRsp>() { // from class: com.tencent.trpcprotocol.miniapp.shenzhen_smart_city_support.shenzhen_smart_city_support.shenzhenSmartCitySupport$SetAlphaUserRsp
                        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], shenzhenSmartCitySupport$SetAlphaUserRsp.class);
                    }.mergeFrom(byteArray);
                    this.f293220d.onCallback(0, "success");
                    return;
                } catch (Exception e16) {
                    e16.printStackTrace();
                    YoloLog.d("QQIDSsoRequester", new Function0() { // from class: com.tencent.mobileqq.timiqqid.net.k
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            String d16;
                            d16 = l.a.d();
                            return d16;
                        }
                    });
                    this.f293220d.onCallback(-1, "client parse response error");
                    return;
                }
            }
            this.f293220d.onCallback(i16, "server returns error");
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ pr2.b f293221d;

        b(pr2.b bVar) {
            this.f293221d = bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ String c() {
            return "receive OidbSvcTrpcTcp.0x116b_1 response";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ String d() {
            return "parse rsp failed";
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            YoloLog.d("QQIDSsoRequester", new Function0() { // from class: com.tencent.mobileqq.timiqqid.net.m
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    String c16;
                    c16 = l.b.c();
                    return c16;
                }
            });
            int i16 = bundle.getInt("result_code");
            byte[] byteArray = bundle.getByteArray("rsp_data");
            if (z16) {
                shenzhenSmartCitySupport$CheckAlphaUserRsp shenzhensmartcitysupport_checkalphauserrsp = new shenzhenSmartCitySupport$CheckAlphaUserRsp();
                try {
                    shenzhensmartcitysupport_checkalphauserrsp.mergeFrom(byteArray);
                    this.f293221d.a(Boolean.valueOf(shenzhensmartcitysupport_checkalphauserrsp.is_alpha_user.get()), 0, "success");
                    return;
                } catch (Exception e16) {
                    e16.printStackTrace();
                    YoloLog.d("QQIDSsoRequester", new Function0() { // from class: com.tencent.mobileqq.timiqqid.net.n
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            String d16;
                            d16 = l.b.d();
                            return d16;
                        }
                    });
                    this.f293221d.a(Boolean.FALSE, -1, "client parse response error");
                    return;
                }
            }
            this.f293221d.a(Boolean.FALSE, i16, "server returns error");
        }
    }

    public static void c(String str, pr2.b<Boolean> bVar) {
        YoloLog.d("QQIDSsoRequester", new Function0() { // from class: com.tencent.mobileqq.timiqqid.net.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String d16;
                d16 = l.d();
                return d16;
            }
        });
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        peekAppRuntime.getCurrentAccountUin();
        shenzhenSmartCitySupport$CheckAlphaUserReq shenzhensmartcitysupport_checkalphauserreq = new shenzhenSmartCitySupport$CheckAlphaUserReq();
        shenzhensmartcitysupport_checkalphauserreq.appid.set(str);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(4459);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(shenzhensmartcitysupport_checkalphauserreq.toByteArray()));
        oidb_sso_oidbssopkg.str_client_version.set(AppSetting.n());
        oidb_sso_oidbssopkg.uint32_service_type.set(1);
        NewIntent newIntent = new NewIntent(peekAppRuntime.getApplicationContext(), g.class);
        newIntent.putExtra("sso_cmd", "OidbSvcTrpcTcp.0x116b_1");
        newIntent.putExtra("req_data", oidb_sso_oidbssopkg.toByteArray());
        newIntent.setObserver(new b(bVar));
        peekAppRuntime.startServlet(newIntent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String d() {
        return "start send OidbSvcTrpcTcp.0x116b_1";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String e() {
        return "start send OidbSvcTrpcTcp.0x116a_1";
    }

    public static void f(String str, pr2.a aVar) {
        YoloLog.d("QQIDSsoRequester", new Function0() { // from class: com.tencent.mobileqq.timiqqid.net.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String e16;
                e16 = l.e();
                return e16;
            }
        });
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        peekAppRuntime.getCurrentAccountUin();
        shenzhenSmartCitySupport$SetAlphaUserReq shenzhensmartcitysupport_setalphauserreq = new shenzhenSmartCitySupport$SetAlphaUserReq();
        shenzhensmartcitysupport_setalphauserreq.appid.set(str);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(4458);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(shenzhensmartcitysupport_setalphauserreq.toByteArray()));
        oidb_sso_oidbssopkg.str_client_version.set(AppSetting.n());
        oidb_sso_oidbssopkg.uint32_service_type.set(1);
        NewIntent newIntent = new NewIntent(peekAppRuntime.getApplicationContext(), g.class);
        newIntent.putExtra("sso_cmd", "OidbSvcTrpcTcp.0x116a_1");
        newIntent.putExtra("req_data", oidb_sso_oidbssopkg.toByteArray());
        newIntent.setObserver(new a(aVar));
        peekAppRuntime.startServlet(newIntent);
    }
}
