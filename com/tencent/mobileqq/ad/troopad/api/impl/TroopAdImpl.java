package com.tencent.mobileqq.ad.troopad.api.impl;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.uf.n;
import com.tencent.mobileqq.ad.troopad.api.ITroopAd;
import com.tencent.mobileqq.ad.troopad.proto.IqunAdSvrPB$GetAdReq;
import com.tencent.mobileqq.ad.troopad.proto.IqunAdSvrPB$GetAdRsp;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopTrpcHandlerService;
import com.tencent.mobileqq.troop.api.TroopTrpcRemoteResponse;
import com.tencent.mobileqq.troop.api.f;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes10.dex */
public class TroopAdImpl implements ITroopAd {
    static IPatchRedirector $redirector_ = null;
    private static final String METHOD = "/trpc.iqun.iqun_ad_svr.IqunAdSvr/GetAd";
    private static final String SERVICE = "trpc.iqun.iqun_ad_svr.IqunAdSvr";
    private static final String TAG = "TroopAdImpl";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WeakReference f186949a;

        a(WeakReference weakReference) {
            this.f186949a = weakReference;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAdImpl.this, (Object) weakReference);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.f
        public void a(@NonNull TroopTrpcRemoteResponse troopTrpcRemoteResponse) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopTrpcRemoteResponse);
                return;
            }
            t71.a aVar = (t71.a) this.f186949a.get();
            if (aVar == null) {
                QLog.e(TroopAdImpl.TAG, 1, "requestTroopBannerAd onError, error: callback is null");
                return;
            }
            aVar.a(false, null);
            QLog.i(TroopAdImpl.TAG, 1, "requestTroopBannerAd onError, errorResponse is " + troopTrpcRemoteResponse);
        }

        @Override // com.tencent.mobileqq.troop.api.f
        public void b(@NonNull TroopTrpcRemoteResponse troopTrpcRemoteResponse) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopTrpcRemoteResponse);
                return;
            }
            QLog.i(TroopAdImpl.TAG, 1, "requestTroopBannerAd onSuccess");
            t71.a aVar = (t71.a) this.f186949a.get();
            if (aVar == null) {
                QLog.e(TroopAdImpl.TAG, 1, "requestTroopBannerAd onSuccess, error: callback is null");
                return;
            }
            try {
                if (troopTrpcRemoteResponse.data != null) {
                    aVar.a(true, new MessageMicro<IqunAdSvrPB$GetAdRsp>() { // from class: com.tencent.mobileqq.ad.troopad.proto.IqunAdSvrPB$GetAdRsp
                        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, n.CTRL_INDEX}, new String[]{"ad", "is_shared_plan", "time_ctl", "ext"}, new Object[]{null, Boolean.FALSE, null, ByteStringMicro.EMPTY}, IqunAdSvrPB$GetAdRsp.class);

                        /* renamed from: ad, reason: collision with root package name */
                        public IqunAdSvrPB$AdInfo f186951ad = new MessageMicro<IqunAdSvrPB$AdInfo>() { // from class: com.tencent.mobileqq.ad.troopad.proto.IqunAdSvrPB$AdInfo
                            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"ad_type", "ams_ad_info"}, new Object[]{0, null}, IqunAdSvrPB$AdInfo.class);
                            public final PBEnumField ad_type = PBField.initEnum(0);
                            public qq_ad_get.QQAdGetRsp ams_ad_info = new qq_ad_get.QQAdGetRsp();
                        };
                        public final PBBoolField is_shared_plan = PBField.initBool(false);
                        public IqunAdSvrPB$AdTimeCtl time_ctl = new MessageMicro<IqunAdSvrPB$AdTimeCtl>() { // from class: com.tencent.mobileqq.ad.troopad.proto.IqunAdSvrPB$AdTimeCtl
                            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"banner_countdown", "icon_countdown", "next_ad_request_time"}, new Object[]{0L, 0L, 0L}, IqunAdSvrPB$AdTimeCtl.class);
                            public final PBInt64Field banner_countdown = PBField.initInt64(0);
                            public final PBInt64Field icon_countdown = PBField.initInt64(0);
                            public final PBInt64Field next_ad_request_time = PBField.initInt64(0);
                        };
                        public final PBBytesField ext = PBField.initBytes(ByteStringMicro.EMPTY);
                    }.mergeFrom(troopTrpcRemoteResponse.data));
                } else {
                    aVar.a(false, null);
                    QLog.i(TroopAdImpl.TAG, 1, "requestTroopBannerAd onSuccess, data is null");
                }
            } catch (Exception e16) {
                aVar.a(false, null);
                QLog.e(TroopAdImpl.TAG, 1, "requestTroopBannerAd onSuccess, error:" + e16);
            }
        }
    }

    public TroopAdImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public IqunAdSvrPB$GetAdReq createTroopBannerAdRequest(Long l3, boolean z16, String str, qq_ad_get.QQAdGet qQAdGet, ByteStringMicro byteStringMicro) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (IqunAdSvrPB$GetAdReq) iPatchRedirector.redirect((short) 3, this, l3, Boolean.valueOf(z16), str, qQAdGet, byteStringMicro);
        }
        IqunAdSvrPB$GetAdReq iqunAdSvrPB$GetAdReq = new IqunAdSvrPB$GetAdReq();
        iqunAdSvrPB$GetAdReq.group_code.set(l3.longValue());
        iqunAdSvrPB$GetAdReq.is_group_channel.set(z16);
        iqunAdSvrPB$GetAdReq.client_mod.set(str);
        iqunAdSvrPB$GetAdReq.ams_get_ad_req.set(qQAdGet);
        iqunAdSvrPB$GetAdReq.ext.set(byteStringMicro);
        return iqunAdSvrPB$GetAdReq;
    }

    @Override // com.tencent.mobileqq.ad.troopad.api.ITroopAd
    public void requestTroopBannerAd(Long l3, boolean z16, String str, qq_ad_get.QQAdGet qQAdGet, ByteStringMicro byteStringMicro, WeakReference<t71.a> weakReference) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            ThreadManagerV2.excute(new Runnable(l3, z16, str, qQAdGet, byteStringMicro, weakReference) { // from class: com.tencent.mobileqq.ad.troopad.api.impl.TroopAdImpl.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Long f186943d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ boolean f186944e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ String f186945f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ qq_ad_get.QQAdGet f186946h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ ByteStringMicro f186947i;

                /* renamed from: m, reason: collision with root package name */
                final /* synthetic */ WeakReference f186948m;

                {
                    this.f186943d = l3;
                    this.f186944e = z16;
                    this.f186945f = str;
                    this.f186946h = qQAdGet;
                    this.f186947i = byteStringMicro;
                    this.f186948m = weakReference;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TroopAdImpl.this, l3, Boolean.valueOf(z16), str, qQAdGet, byteStringMicro, weakReference);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        TroopAdImpl.this.requestTroopBannerAd(TroopAdImpl.this.createTroopBannerAdRequest(this.f186943d, this.f186944e, this.f186945f, this.f186946h, this.f186947i), this.f186948m);
                    }
                }
            }, 128, null, false);
        } else {
            iPatchRedirector.redirect((short) 2, this, l3, Boolean.valueOf(z16), str, qQAdGet, byteStringMicro, weakReference);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestTroopBannerAd(IqunAdSvrPB$GetAdReq iqunAdSvrPB$GetAdReq, WeakReference<t71.a> weakReference) {
        QLog.d(TAG, 1, "requestTroopBannerAd invoke:", Long.valueOf(iqunAdSvrPB$GetAdReq.group_code.get()));
        if (weakReference != null && weakReference.get() != null) {
            try {
                ((ITroopTrpcHandlerService) QRoute.api(ITroopTrpcHandlerService.class)).sendRequest(SERVICE, METHOD, iqunAdSvrPB$GetAdReq.toByteArray(), 1, null, new a(weakReference));
                return;
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "requestTroopBannerAd error:" + th5);
                return;
            }
        }
        QLog.e(TAG, 1, "requestTroopBannerAd error: troopBannerAdCallback is null");
    }
}
