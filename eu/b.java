package eu;

import android.text.TextUtils;
import camera.SHADOW_BACKEND_INTERFACE.GetCatMatTreeRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.google.gson.Gson;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.handler.EffectMaterialHandler;
import com.tencent.av.business.processor.c;
import com.tencent.av.zplan.avatar.resmgr.AVAvatarLightSDKSettingsResJsonConfig;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b extends a<EffectMaterialHandler> {
    public b(AppInterface appInterface, EffectMaterialHandler effectMaterialHandler) {
        super(appInterface, effectMaterialHandler);
    }

    @Override // eu.a
    public String b() {
        return "ShadowBackendSvc.GetCatMatTree";
    }

    @Override // eu.a
    public void c(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (QLog.isColorLevel()) {
            QLog.i("EffectMaterialReceiver", 2, "EffectMaterialReceiver receive called");
        }
        String string = toServiceMsg.extraData.getString("ServiceId");
        if (QLog.isColorLevel()) {
            QLog.i("EffectMaterialReceiver", 2, "EffectMaterialReceiver serviceId: " + string);
        }
        e(fromServiceMsg, obj, string);
    }

    void d(String str, String str2) {
        ((com.tencent.av.business.processor.a) ((hu.a) ((VideoAppInterface) this.f397130a).B(15)).n(2)).j(str, "QQAVDoublePendantV2", str2);
    }

    void e(FromServiceMsg fromServiceMsg, Object obj, String str) {
        ArrayList<MetaCategory> arrayList;
        if (QLog.isColorLevel()) {
            QLog.i("EffectMaterialReceiver", 2, "[handleMaterial] serviceId = " + str);
        }
        GetCatMatTreeRsp getCatMatTreeRsp = (GetCatMatTreeRsp) obj;
        h(getCatMatTreeRsp);
        if (getCatMatTreeRsp != null && getCatMatTreeRsp.Code == 0 && (arrayList = getCatMatTreeRsp.Categories) != null && !arrayList.isEmpty()) {
            String json = new Gson().toJson(getCatMatTreeRsp);
            if (QLog.isColorLevel()) {
                QLog.i("EffectMaterialReceiver", 2, "[handleMaterial] dataStr = " + json);
            }
            if (TextUtils.equals(str, "QQAVSinglePendantV2")) {
                f(json, getCatMatTreeRsp.ETag);
                return;
            } else if (TextUtils.equals(str, "QQAVDoublePendantV2")) {
                d(json, getCatMatTreeRsp.ETag);
                return;
            } else {
                if (TextUtils.equals(str, "QQAVZPlanAvatar")) {
                    g(json, getCatMatTreeRsp.ETag);
                    return;
                }
                return;
            }
        }
        QLog.i("EffectMaterialReceiver", 2, "[handleMaterial] no data return");
        if (AVAvatarLightSDKSettingsResJsonConfig.a() && TextUtils.equals(str, "QQAVSinglePendantV2")) {
            AVAvatarLightSDKSettingsResJsonConfig.c(1);
        }
    }

    void f(String str, String str2) {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof VideoAppInterface) {
            ((com.tencent.av.business.processor.b) ((hu.a) ((VideoAppInterface) this.f397130a).B(15)).n(1)).j(str, "QQAVSinglePendantV2", str2);
        } else {
            new com.tencent.av.business.processor.b((AppInterface) runtime).j(str, "QQAVSinglePendantV2", str2);
        }
    }

    void g(String str, String str2) {
        ((c) ((hu.a) ((VideoAppInterface) this.f397130a).B(15)).n(4)).j(str, "QQAVZPlanAvatar", str2);
    }

    void h(GetCatMatTreeRsp getCatMatTreeRsp) {
        if (QLog.isColorLevel()) {
            if (getCatMatTreeRsp == null) {
                QLog.i("EffectMaterialReceiver", 2, "[handleMaterial] response data is null");
                return;
            }
            QLog.i("EffectMaterialReceiver", 2, "[handleMaterial] response.code = " + getCatMatTreeRsp.Code);
            ArrayList<MetaCategory> arrayList = getCatMatTreeRsp.Categories;
            if (arrayList != null && !arrayList.isEmpty()) {
                QLog.i("EffectMaterialReceiver", 2, "[handleMaterial] response.Categories.size = " + getCatMatTreeRsp.Categories.size());
                Iterator<MetaCategory> it = getCatMatTreeRsp.Categories.iterator();
                while (it.hasNext()) {
                    MetaCategory next = it.next();
                    QLog.i("EffectMaterialReceiver", 2, "[handleMaterial] categories.name = " + next.name);
                    QLog.i("EffectMaterialReceiver", 2, "[handleMaterial] categories.subCategories = " + next.subCategories.size());
                    QLog.i("EffectMaterialReceiver", 2, "[handleMaterial] categories.materials = " + next.materials.size());
                }
                QLog.i("EffectMaterialReceiver", 2, "[handleMaterial] etag = " + getCatMatTreeRsp.ETag);
            }
        }
    }
}
