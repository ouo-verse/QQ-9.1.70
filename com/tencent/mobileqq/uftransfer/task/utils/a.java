package com.tencent.mobileqq.uftransfer.task.utils;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.uftransfer.data.UploadInfoEntity;
import com.tencent.mobileqq.uftransfer.proto.j;
import com.tencent.mobileqq.uftransfer.task.taskinfo.d;
import com.tencent.mobileqq.uftransfer.task.taskinfo.f;
import com.tencent.mobileqq.uftransfer.task.taskinfo.h;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.proxy.dlg.location.QbAddrData;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static boolean f305664a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42742);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f305664a = false;
        }
    }

    public static void a(com.tencent.mobileqq.uftransfer.task.taskinfo.b bVar, @NonNull UploadInfoEntity uploadInfoEntity) {
        bVar.A(c(uploadInfoEntity));
        bVar.j(uploadInfoEntity.fileId);
    }

    public static void b(d dVar, @NonNull UploadInfoEntity uploadInfoEntity) {
        dVar.B(e(uploadInfoEntity));
        dVar.j(uploadInfoEntity.fileId);
    }

    private static f c(@NonNull UploadInfoEntity uploadInfoEntity) {
        try {
            com.tencent.mobileqq.uftransfer.proto.d dVar = (com.tencent.mobileqq.uftransfer.proto.d) com.tencent.mobileqq.jsonconverter.a.e(uploadInfoEntity.extRspJsonData, com.tencent.mobileqq.uftransfer.proto.d.class);
            if (dVar != null) {
                dVar.f305277i = com.tencent.mobileqq.uftransfer.depend.a.y(dVar.f305276h);
                dVar.f305279k = com.tencent.mobileqq.uftransfer.depend.a.y(dVar.f305278j);
                dVar.f305283o = com.tencent.mobileqq.uftransfer.depend.a.y(dVar.f305282n);
                dVar.f305286r = com.tencent.mobileqq.uftransfer.depend.a.y(dVar.f305285q);
                dVar.f305288t = com.tencent.mobileqq.uftransfer.depend.a.y(dVar.f305287s);
                dVar.A = com.tencent.mobileqq.uftransfer.depend.a.y(dVar.f305294z);
                dVar.D = com.tencent.mobileqq.uftransfer.depend.a.y(dVar.C);
            }
            f fVar = new f(dVar);
            fVar.k(uploadInfoEntity.useHttps);
            fVar.h(uploadInfoEntity.httpsDomain);
            fVar.g(k(uploadInfoEntity.hostListStr));
            fVar.i(uploadInfoEntity.urlParams);
            fVar.l(uploadInfoEntity.useIpV6);
            fVar.A(uploadInfoEntity.strCheckSum);
            fVar.B(uploadInfoEntity.strSha);
            if (QLog.isColorLevel()) {
                QLog.d("[UFTTransfer] UFTBuilderUtil", 2, "buildC2CBusPropFrom: uploadEntity = " + uploadInfoEntity);
                QLog.d("[UFTTransfer] UFTBuilderUtil", 2, "buildC2CBusPropFrom: prop = " + fVar);
            }
            return fVar;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("[UFTTransfer] UFTBuilderUtil", 2, "buildC2CBusPropFrom : ", e16);
                return null;
            }
            return null;
        }
    }

    public static String d(com.tencent.mobileqq.uftransfer.api.impl.a aVar, com.tencent.mobileqq.uftransfer.task.taskinfo.a aVar2) {
        StringBuilder sb5 = new StringBuilder();
        if (aVar.a() != null) {
            sb5.append(aVar.a().toString());
        }
        sb5.append(aVar2.h());
        return sb5.toString();
    }

    private static h e(@NonNull UploadInfoEntity uploadInfoEntity) {
        try {
            j jVar = (j) com.tencent.mobileqq.jsonconverter.a.e(uploadInfoEntity.extRspJsonData, j.class);
            if (jVar != null) {
                jVar.f305337h = com.tencent.mobileqq.uftransfer.depend.a.y(jVar.f305336g);
            }
            h hVar = new h(jVar);
            hVar.k(uploadInfoEntity.useHttps);
            hVar.h(uploadInfoEntity.httpsDomain);
            hVar.g(k(uploadInfoEntity.hostListStr));
            hVar.i(uploadInfoEntity.urlParams);
            hVar.l(uploadInfoEntity.useIpV6);
            hVar.y(uploadInfoEntity.strCheckSum);
            hVar.z(uploadInfoEntity.strSha);
            if (QLog.isColorLevel()) {
                QLog.d("[UFTTransfer] UFTBuilderUtil", 2, "buildTroopBusPropFrom: uploadEntity = " + uploadInfoEntity);
                QLog.d("[UFTTransfer] UFTBuilderUtil", 2, "buildTroopBusPropFrom: prop = " + hVar);
            }
            return hVar;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("[UFTTransfer] UFTBuilderUtil", 2, "buildTroopBusPropFrom : ", e16);
                return null;
            }
            return null;
        }
    }

    public static UploadInfoEntity f(com.tencent.mobileqq.uftransfer.api.impl.a aVar, com.tencent.mobileqq.uftransfer.task.taskinfo.a aVar2) {
        if (aVar2 instanceof com.tencent.mobileqq.uftransfer.task.taskinfo.b) {
            return g(aVar, (com.tencent.mobileqq.uftransfer.task.taskinfo.b) aVar2);
        }
        if (aVar2 instanceof d) {
            return h(aVar, (d) aVar2);
        }
        return null;
    }

    private static UploadInfoEntity g(com.tencent.mobileqq.uftransfer.api.impl.a aVar, com.tencent.mobileqq.uftransfer.task.taskinfo.b bVar) {
        if (bVar != null && bVar.r() != null) {
            try {
                UploadInfoEntity uploadInfoEntity = new UploadInfoEntity();
                uploadInfoEntity.sessionKey = d(aVar, bVar);
                uploadInfoEntity.extRspType = 2;
                f r16 = bVar.r();
                com.tencent.mobileqq.uftransfer.proto.d w3 = r16.w();
                w3.f305276h = com.tencent.mobileqq.uftransfer.depend.a.a(w3.f305277i);
                w3.f305278j = com.tencent.mobileqq.uftransfer.depend.a.a(w3.f305279k);
                w3.f305282n = com.tencent.mobileqq.uftransfer.depend.a.a(w3.f305283o);
                w3.f305285q = com.tencent.mobileqq.uftransfer.depend.a.a(w3.f305286r);
                w3.f305287s = com.tencent.mobileqq.uftransfer.depend.a.a(w3.f305288t);
                w3.f305294z = com.tencent.mobileqq.uftransfer.depend.a.a(w3.A);
                w3.C = com.tencent.mobileqq.uftransfer.depend.a.a(w3.D);
                uploadInfoEntity.extRspJsonData = com.tencent.mobileqq.jsonconverter.a.b(w3).toString();
                uploadInfoEntity.fileId = bVar.c();
                uploadInfoEntity.useHttps = r16.e();
                uploadInfoEntity.httpsDomain = r16.b();
                uploadInfoEntity.hostListStr = j(r16.a());
                uploadInfoEntity.urlParams = r16.c();
                uploadInfoEntity.strCheckSum = r16.s();
                uploadInfoEntity.strSha = r16.u();
                if (QLog.isColorLevel()) {
                    QLog.d("[UFTTransfer] UFTBuilderUtil", 2, "buildUploadInfoEntityFromC2C: uploadEntity = " + uploadInfoEntity);
                    QLog.d("[UFTTransfer] UFTBuilderUtil", 2, "buildUploadInfoEntityFromC2C: prop = " + r16);
                }
                return uploadInfoEntity;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("[UFTTransfer] UFTBuilderUtil", 2, "buildUploadInfoEntityFrom : ", e16);
                }
            }
        }
        return null;
    }

    private static UploadInfoEntity h(com.tencent.mobileqq.uftransfer.api.impl.a aVar, d dVar) {
        if (dVar != null && dVar.w() != null) {
            try {
                UploadInfoEntity uploadInfoEntity = new UploadInfoEntity();
                uploadInfoEntity.sessionKey = d(aVar, dVar);
                uploadInfoEntity.extRspType = 1;
                h w3 = dVar.w();
                j x16 = w3.x();
                x16.f305336g = com.tencent.mobileqq.uftransfer.depend.a.a(x16.f305337h);
                uploadInfoEntity.extRspJsonData = com.tencent.mobileqq.jsonconverter.a.b(x16).toString();
                uploadInfoEntity.fileId = dVar.c();
                uploadInfoEntity.useHttps = w3.e();
                uploadInfoEntity.httpsDomain = w3.b();
                uploadInfoEntity.hostListStr = j(w3.a());
                uploadInfoEntity.urlParams = w3.c();
                uploadInfoEntity.strCheckSum = w3.u();
                uploadInfoEntity.strSha = w3.v();
                if (QLog.isColorLevel()) {
                    QLog.d("[UFTTransfer] UFTBuilderUtil", 2, "buildUploadInfoEntityFromTroop: uploadEntity = " + uploadInfoEntity);
                    QLog.d("[UFTTransfer] UFTBuilderUtil", 2, "buildUploadInfoEntityFromTroop: prop = " + w3);
                }
                return uploadInfoEntity;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("[UFTTransfer] UFTBuilderUtil", 2, "buildUploadInfoEntityFrom : ", e16);
                }
            }
        }
        return null;
    }

    public static boolean i(AppRuntime appRuntime) {
        if (f305664a) {
            return true;
        }
        return ((IFeatureRuntimeService) appRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("is_file_transfer_enable", true);
    }

    private static String j(List<String> list) {
        if (list != null && !list.isEmpty()) {
            StringBuilder sb5 = new StringBuilder();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sb5.append(it.next());
                sb5.append(QbAddrData.DATA_SPLITER);
            }
            sb5.deleteCharAt(sb5.length() - 1);
            return sb5.toString();
        }
        return "";
    }

    private static List<String> k(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Arrays.asList(str.split("\\|"));
    }
}
