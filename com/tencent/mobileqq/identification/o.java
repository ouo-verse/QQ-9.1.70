package com.tencent.mobileqq.identification;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.dt.api.IQSecChannel;
import com.tencent.mobileqq.identification.AppConf;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import face.qqlogin.Appconf$AppConfRequest;
import face.qqlogin.Appconf$AppConfResponse;
import face.qqlogin.Appconf$ServiceProtocol;
import face.qqlogin.Appconf$Wording;
import face.qqlogin.FaceCommon$UserInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes15.dex */
public class o {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements com.tencent.mobileqq.dt.api.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BusinessObserver f237989a;

        a(BusinessObserver businessObserver) {
            this.f237989a = businessObserver;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) businessObserver);
            }
        }

        @Override // com.tencent.mobileqq.dt.api.a
        public void onResult(int i3, byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) bArr);
                return;
            }
            if (i3 != 0) {
                this.f237989a.onReceive(17, false, null);
                QLog.d("IdentificationFaceServlet", 1, "handleFaceDetectResponse not ok errorCode:" + i3);
                return;
            }
            try {
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.mergeFrom(bArr);
                int i16 = oidb_sso_oidbssopkg.uint32_result.get();
                if (i16 != 15) {
                    AppConf b16 = o.b(bArr);
                    if (b16 == null) {
                        QLog.e("IdentificationFaceServlet", 1, "handleFaceDetectResponse, appconf is null");
                        return;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("FaceQueryAppConf", b16);
                    this.f237989a.onReceive(17, true, bundle);
                    if (QLog.isColorLevel()) {
                        QLog.d("IdentificationFaceServlet", 2, "handleFaceDetectResponse succsss=", b16);
                        return;
                    }
                    return;
                }
                QLog.e("IdentificationFaceServlet", 1, "sso result error, ret : " + i16 + "  error : " + oidb_sso_oidbssopkg.str_error_msg.get());
                this.f237989a.onReceive(15, false, null);
            } catch (InvalidProtocolBufferMicroException e16) {
                this.f237989a.onReceive(17, false, null);
                if (QLog.isColorLevel()) {
                    QLog.d("IdentificationFaceServlet", 2, "handleFaceDetectResponse error=", e16);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AppConf b(byte[] bArr) {
        int i3;
        String str;
        String str2;
        String str3;
        if (bArr == null) {
            QLog.e("IdentificationFaceServlet", 1, "getAppConfFromBytes, but data is null");
            return null;
        }
        try {
            Appconf$AppConfResponse appconf$AppConfResponse = new Appconf$AppConfResponse();
            appconf$AppConfResponse.mergeFrom(bArr);
            String str4 = appconf$AppConfResponse.AppName.get();
            int i16 = appconf$AppConfResponse.Mode.get();
            String stringUtf8 = appconf$AppConfResponse.ColorSeq.get().toStringUtf8();
            String str5 = appconf$AppConfResponse.Session.get();
            int i17 = appconf$AppConfResponse.Ret.get();
            String str6 = appconf$AppConfResponse.select_data.get();
            String str7 = appconf$AppConfResponse.ErrMsg.get();
            String stringUtf82 = appconf$AppConfResponse.ActionSeq.get().toStringUtf8();
            String stringUtf83 = appconf$AppConfResponse.huiyan_sdk_token.get().toStringUtf8();
            if (QLog.isDevelopLevel()) {
                str = appconf$AppConfResponse.Debug.get();
            } else {
                str = null;
            }
            List<Appconf$Wording> list = appconf$AppConfResponse.Wordings.get();
            ArrayList arrayList = new ArrayList(3);
            if (list != null && !list.isEmpty()) {
                for (Iterator<Appconf$Wording> it = list.iterator(); it.hasNext(); it = it) {
                    Appconf$Wording next = it.next();
                    arrayList.add(new AppConf.AppWordings(next.serviceType.get(), next.Text.get()));
                }
            } else if (QLog.isColorLevel()) {
                try {
                    QLog.d("IdentificationFaceServlet", 2, "handleFaceDetectResponse list is null appName =" + str4);
                } catch (InvalidProtocolBufferMicroException e16) {
                    e = e16;
                    i3 = 2;
                    Object[] objArr = new Object[i3];
                    objArr[0] = "appConf merge from data error : ";
                    objArr[1] = e.getMessage();
                    QLog.e("IdentificationFaceServlet", 1, objArr);
                    return null;
                }
            }
            ArrayList arrayList2 = new ArrayList(3);
            List<Appconf$ServiceProtocol> list2 = appconf$AppConfResponse.protocols.get();
            if (list2 != null && !list2.isEmpty()) {
                Iterator<Appconf$ServiceProtocol> it5 = list2.iterator();
                while (it5.hasNext()) {
                    Appconf$ServiceProtocol next2 = it5.next();
                    String str8 = next2.name.get();
                    Iterator<Appconf$ServiceProtocol> it6 = it5;
                    String str9 = next2.url.get();
                    String str10 = next2.wording.get();
                    String str11 = stringUtf83;
                    String str12 = str6;
                    QLog.d("IdentificationFaceServlet", 1, "handleFaceDetectResponse ServiceProtocol name=", str8, ", url=", str9, "wording=", str10);
                    if (!TextUtils.isEmpty(str8) && !TextUtils.isEmpty(str9)) {
                        arrayList2.add(new AppConf.ServiceProtocolSerializable(str8, str9, str10));
                    }
                    str6 = str12;
                    it5 = it6;
                    stringUtf83 = str11;
                }
                str2 = str6;
                str3 = stringUtf83;
            } else {
                str2 = str6;
                str3 = stringUtf83;
                QLog.d("IdentificationFaceServlet", 1, "handleFaceDetectResponse rspBody.protocols isEmpty");
            }
            AppConf appConf = new AppConf(str4, arrayList, i16);
            appConf.colorSequence = stringUtf8;
            appConf.session = str5;
            appConf.ret = i17;
            appConf.errMsg = str7;
            appConf.actionReq = f(stringUtf82);
            appConf.debug = str;
            appConf.serviceProtocols.addAll(arrayList2);
            appConf.selectData = str2;
            appConf.huiyanSdkToken = str3;
            return appConf;
        } catch (InvalidProtocolBufferMicroException e17) {
            e = e17;
            i3 = 2;
        }
    }

    private static ByteStringMicro c(FaceConf faceConf) {
        String method = faceConf.getMethod();
        QLog.d("IdentificationFaceServlet", 1, "getEncIdentity method" + method);
        EncryptContext encryptContext = faceConf.getEncryptContext();
        if (method != null && !l.f237972d.contains(method)) {
            return ByteStringMicro.EMPTY;
        }
        if (encryptContext == null) {
            QLog.e("IdentificationFaceServlet", 1, "getEncIdentity encryptContext is null");
            return ByteStringMicro.EMPTY;
        }
        FaceCommon$UserInfo faceCommon$UserInfo = new FaceCommon$UserInfo();
        faceCommon$UserInfo.IDCardNumber.set(e(faceConf.getIdNum()));
        faceCommon$UserInfo.Name.set(e(faceConf.getName()));
        byte[] byteArray = faceCommon$UserInfo.toByteArray();
        if (encryptContext.method == 3) {
            byteArray = com.tencent.mobileqq.util.y.a(byteArray, encryptContext.encryptKey, encryptContext.f237889iv);
        }
        if (byteArray == null) {
            QLog.d("IdentificationFaceServlet", 1, "getEncIdentity userInfoByte is null, encryptContext.method=" + encryptContext.method);
            return ByteStringMicro.EMPTY;
        }
        return ByteStringMicro.copyFrom(byteArray);
    }

    private static ByteStringMicro d() {
        byte[] c16 = com.tencent.mobileqq.guid.c.f213821a.c();
        if (c16 != null) {
            return ByteStringMicro.copyFrom(c16);
        }
        return ByteStringMicro.EMPTY;
    }

    private static String e(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    private static int[] f(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return new int[0];
            }
            String[] split = str.split(" ");
            int[] iArr = new int[split.length];
            for (int i3 = 0; i3 < split.length; i3++) {
                iArr[i3] = Integer.parseInt(split[i3]);
            }
            return iArr;
        } catch (Exception e16) {
            QLog.e("IdentificationFaceServlet", 1, "parseAction error : " + e16.getMessage());
            return null;
        }
    }

    public static void g(AppRuntime appRuntime, FaceConf faceConf, String str, BusinessObserver businessObserver) {
        Appconf$AppConfRequest appconf$AppConfRequest = new Appconf$AppConfRequest();
        appconf$AppConfRequest.AppID.set(faceConf.getPlatformAppId());
        appconf$AppConfRequest.Platform.set("a");
        appconf$AppConfRequest.QQVersion.set(e(str));
        appconf$AppConfRequest.TmpKey.set(e(faceConf.getKey()));
        appconf$AppConfRequest.GUID.set(d());
        appconf$AppConfRequest.imei.set(ByteStringMicro.copyFromUtf8(e(faceConf.getIMei())));
        appconf$AppConfRequest.qimei36.set(ByteStringMicro.copyFromUtf8(e(faceConf.getQimei36())));
        appconf$AppConfRequest.use_huiyan_sdk.set(true);
        appconf$AppConfRequest.enc_identity.set(c(faceConf));
        try {
            ((IQSecChannel) QRoute.api(IQSecChannel.class)).sendRequest((AppInterface) appRuntime, "FaceQueryAppConf", appconf$AppConfRequest.toByteArray(), new a(businessObserver));
        } catch (Exception e16) {
            businessObserver.onReceive(17, false, null);
            QLog.e("IdentificationFaceServlet", 1, "requestAppConfigFromO3 error :" + e16);
        }
    }
}
