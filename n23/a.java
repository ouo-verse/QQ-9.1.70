package n23;

import MQQ.QQValueInfoItem;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VipMMKV;
import com.tencent.mobileqq.vas.updatesystem.business.QQValueViewBusiness;
import com.tencent.mobileqq.vas.util.QQVasUpdateBusinessUtil;
import com.tencent.pb.profilecard.VaProfileGate$QQValueExtInfo;
import com.tencent.pb.profilecard.VaProfileGate$QQValueInfoItem;
import com.tencent.pb.qqvalue.qqvalue$UserQQValueInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public int f418034a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f418035b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f418036c = 0;

    /* renamed from: d, reason: collision with root package name */
    public String f418037d = "";

    /* renamed from: e, reason: collision with root package name */
    public String f418038e = "";

    /* renamed from: f, reason: collision with root package name */
    public int f418039f = 1;

    /* renamed from: g, reason: collision with root package name */
    public boolean f418040g = false;

    /* renamed from: h, reason: collision with root package name */
    public String f418041h = "";

    public static a b(@NonNull String str) {
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        a aVar = null;
        if (application == null) {
            return null;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        if (qQAppInterface != null && qQAppInterface.getCurrentUin() != null && qQAppInterface.getCurrentUin().equals(str)) {
            aVar = new a();
            SharedPreferences qQValue = VipMMKV.getQQValue(application);
            boolean z16 = false;
            aVar.f418034a = qQValue.getInt("key_info_score" + str, 0);
            aVar.f418035b = qQValue.getInt("key_info_level" + str, 0);
            aVar.f418036c = qQValue.getInt("key_info_trend" + str, 0);
            aVar.f418037d = qQValue.getString("key_info_material_id" + str, "");
            aVar.f418038e = qQValue.getString("key_info_url" + str, "");
            aVar.f418039f = qQValue.getInt("key_info_on_off" + str, 1);
            if (qQValue.getInt("key_info_static_show" + str, 0) == 1) {
                z16 = true;
            }
            aVar.f418040g = z16;
            QQValueViewBusiness qQValueViewBusiness = (QQValueViewBusiness) QQVasUpdateBusinessUtil.getBusinessInstance(QQValueViewBusiness.class);
            if (qQValueViewBusiness != null) {
                aVar.f418041h = qQValueViewBusiness.getSavePath(aVar.f418037d) + "/qqvalue/level_" + aVar.f418035b + "/";
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQValueInfoItem", 1, "get sp score:" + aVar.f418034a + " level = " + aVar.f418035b + " trend = " + aVar.f418036c + "materialId = " + aVar.f418037d + "url" + aVar.f418038e + "on_off" + aVar.f418039f);
            }
        }
        return aVar;
    }

    private static void c(QQValueInfoItem qQValueInfoItem, a aVar) {
        aVar.f418035b = qQValueInfoItem.level;
        aVar.f418034a = qQValueInfoItem.score;
        aVar.f418036c = qQValueInfoItem.trend;
        aVar.f418037d = qQValueInfoItem.material_id;
        aVar.f418038e = qQValueInfoItem.url;
        aVar.f418039f = qQValueInfoItem.on_off;
        Map<String, String> map = qQValueInfoItem.qqvalue_ext_info;
        if (map != null && "1".equals(map.get("use_static"))) {
            aVar.f418040g = true;
        }
    }

    private static void d(VaProfileGate$QQValueInfoItem vaProfileGate$QQValueInfoItem, a aVar) {
        List<VaProfileGate$QQValueExtInfo> list;
        aVar.f418035b = vaProfileGate$QQValueInfoItem.level.get();
        aVar.f418034a = vaProfileGate$QQValueInfoItem.score.get();
        aVar.f418036c = vaProfileGate$QQValueInfoItem.trend.get();
        aVar.f418037d = vaProfileGate$QQValueInfoItem.material_id.get();
        aVar.f418038e = vaProfileGate$QQValueInfoItem.url.get();
        aVar.f418039f = vaProfileGate$QQValueInfoItem.on_off.get();
        if (!vaProfileGate$QQValueInfoItem.qqvalue_ext_info.has() || (list = vaProfileGate$QQValueInfoItem.qqvalue_ext_info.get()) == null) {
            return;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (list.get(i3).key.get().equals("use_static")) {
                aVar.f418040g = list.get(i3).value.get().equals("1");
                return;
            }
        }
    }

    private static void e(qqvalue$UserQQValueInfo qqvalue_userqqvalueinfo, a aVar) {
        List<qqvalue$UserQQValueInfo.ExtInfo> list;
        aVar.f418035b = qqvalue_userqqvalueinfo.level.get();
        aVar.f418034a = qqvalue_userqqvalueinfo.score.get();
        aVar.f418036c = qqvalue_userqqvalueinfo.trend.get();
        aVar.f418037d = qqvalue_userqqvalueinfo.material_id.get();
        aVar.f418038e = qqvalue_userqqvalueinfo.url.get();
        aVar.f418039f = qqvalue_userqqvalueinfo.on_off.get();
        if (!qqvalue_userqqvalueinfo.ext_info.has() || (list = qqvalue_userqqvalueinfo.ext_info.get()) == null) {
            return;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (list.get(i3).key.get().equals("use_static")) {
                aVar.f418040g = list.get(i3).value.get().equals("1");
                return;
            }
        }
    }

    public static a f(Object obj) {
        a aVar = new a();
        aVar.f418040g = false;
        if (obj instanceof qqvalue$UserQQValueInfo) {
            e((qqvalue$UserQQValueInfo) obj, aVar);
        } else if (obj instanceof VaProfileGate$QQValueInfoItem) {
            d((VaProfileGate$QQValueInfoItem) obj, aVar);
        } else if (obj instanceof QQValueInfoItem) {
            c((QQValueInfoItem) obj, aVar);
        }
        QQValueViewBusiness qQValueViewBusiness = (QQValueViewBusiness) QQVasUpdateBusinessUtil.getBusinessInstance(QQValueViewBusiness.class);
        if (qQValueViewBusiness != null) {
            aVar.f418041h = qQValueViewBusiness.getSavePath(aVar.f418037d) + "/qqvalue/level_" + aVar.f418035b + "/";
        }
        return aVar;
    }

    public boolean a(a aVar) {
        if (aVar == null) {
            return false;
        }
        if (this == aVar) {
            return true;
        }
        if (!this.f418037d.equals(aVar.f418037d) || this.f418039f != aVar.f418039f || this.f418034a != aVar.f418034a || this.f418036c != aVar.f418036c || !this.f418038e.equals(aVar.f418038e) || this.f418035b != aVar.f418035b || this.f418040g != aVar.f418040g) {
            return false;
        }
        return true;
    }

    public void g(@NonNull String str) {
        QQAppInterface qQAppInterface;
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        if (application != null && (qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()) != null && qQAppInterface.getCurrentUin() != null && qQAppInterface.getCurrentUin().equals(str)) {
            SharedPreferences qQValue = VipMMKV.getQQValue(application);
            qQValue.edit().putInt("key_info_score" + str, this.f418034a);
            qQValue.edit().putInt("key_info_level" + str, this.f418035b);
            qQValue.edit().putInt("key_info_trend" + str, this.f418036c);
            qQValue.edit().putString("key_info_material_id" + str, this.f418037d);
            qQValue.edit().putString("key_info_url" + str, this.f418038e);
            qQValue.edit().putInt("key_info_on_off" + str, this.f418039f);
            qQValue.edit().putInt("key_info_static_show" + str, this.f418040g ? 1 : 0);
            qQValue.edit().commit();
            if (QLog.isColorLevel()) {
                QLog.d("QQValueInfoItem", 1, "save sp score:" + this.f418034a + " level = " + this.f418035b + " trend = " + this.f418036c + "materialId = " + this.f418037d + "url" + this.f418038e + "on_off" + this.f418039f);
            }
        }
    }
}
