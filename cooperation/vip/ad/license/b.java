package cooperation.vip.ad.license;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.splashad.SplashADUtil;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.tianshu.TianShuMMKVConstant;
import cooperation.vip.tianshu.TianShuMMKVUtil;
import cooperation.vip.tianshu.bean.TSSplashUserAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import tianshu.TianShuQuantityLimit$AdStatus;
import tianshu.TianShuQuantityLimit$UserAction;

/* compiled from: P */
/* loaded from: classes28.dex */
public class b {
    private void a(List<TianShuQuantityLimit$AdStatus> list) {
        TianShuQuantityLimit$AdStatus tianShuQuantityLimit$AdStatus;
        if (bl.b(list)) {
            QLog.w("QSplash@-TSL-TSSplashUserActionOperate", 1, "addOperatedUserActionList  adStatusList is empty");
            return;
        }
        Set<String> stringSet = TianShuMMKVUtil.g(((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount()).getStringSet(TianShuMMKVConstant.SplashKey.TS_SPLASH_USER_ACTION_INFO, null);
        if (bl.b(stringSet)) {
            QLog.w("QSplash@-TSL-TSSplashUserActionOperate", 1, "addOperatedUserActionList  userActionList is empty");
            return;
        }
        QLog.d("QSplash@-TSL-TSSplashUserActionOperate", 1, "addOperatedUserActionList  userActionList = " + Arrays.toString(stringSet.toArray()));
        for (String str : stringSet) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String optString = jSONObject.optString("adId");
                    int optInt = jSONObject.optInt("actionId");
                    long optLong = jSONObject.optLong(TianShuMMKVConstant.UserActionKey.ACTION_TIME);
                    TSSplashUserAction tSSplashUserAction = new TSSplashUserAction(optString, optInt);
                    tSSplashUserAction.setActionTime(optLong);
                    Iterator<TianShuQuantityLimit$AdStatus> it = list.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            tianShuQuantityLimit$AdStatus = it.next();
                            if (TextUtils.equals(String.valueOf(tianShuQuantityLimit$AdStatus.iAdId.get()), tSSplashUserAction.getAdId())) {
                                break;
                            }
                        } else {
                            tianShuQuantityLimit$AdStatus = null;
                            break;
                        }
                    }
                    if (tianShuQuantityLimit$AdStatus != null) {
                        TianShuQuantityLimit$UserAction tianShuQuantityLimit$UserAction = new TianShuQuantityLimit$UserAction();
                        tianShuQuantityLimit$UserAction.action_id.set(tSSplashUserAction.getActionId());
                        tianShuQuantityLimit$UserAction.action_time.set(tSSplashUserAction.getActionTime());
                        tianShuQuantityLimit$AdStatus.actionList.add(tianShuQuantityLimit$UserAction);
                    }
                } catch (JSONException e16) {
                    QLog.e("QSplash@-TSL-TSSplashUserActionOperate", 1, "addOperatedUserActionList  e = " + e16);
                }
            }
        }
    }

    private List<TianShuQuantityLimit$AdStatus> d() {
        Set<String> j3 = com.tencent.mobileqq.vassplash.common.c.j(BaseApplication.getContext(), ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount());
        if (bl.b(j3)) {
            QLog.w("QSplash@-TSL-TSSplashUserActionOperate", 1, "getLocalAdStatusList  localIds is empty");
            return null;
        }
        QLog.d("QSplash@-TSL-TSSplashUserActionOperate", 1, "getLocalAdStatusList  localIds = " + Arrays.toString(j3.toArray()));
        ArrayList arrayList = new ArrayList();
        for (String str : j3) {
            TianShuQuantityLimit$AdStatus tianShuQuantityLimit$AdStatus = new TianShuQuantityLimit$AdStatus();
            try {
                tianShuQuantityLimit$AdStatus.iAdId.set(Integer.parseInt(str));
                arrayList.add(tianShuQuantityLimit$AdStatus);
            } catch (NumberFormatException e16) {
                QLog.e("QSplash@-TSL-TSSplashUserActionOperate", 1, "addNoOperationAdStatusList  e = " + e16);
            }
        }
        return arrayList;
    }

    private void e(List<TianShuQuantityLimit$AdStatus> list) {
        if (bl.b(list)) {
            QLog.w("QSplash@-TSL-TSSplashUserActionOperate", 1, "printLog  adStatusList is empty");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (TianShuQuantityLimit$AdStatus tianShuQuantityLimit$AdStatus : list) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("adId:");
            sb5.append(tianShuQuantityLimit$AdStatus.iAdId.get());
            ArrayList arrayList2 = new ArrayList();
            for (TianShuQuantityLimit$UserAction tianShuQuantityLimit$UserAction : tianShuQuantityLimit$AdStatus.actionList.get()) {
                arrayList2.add("{actionId:" + tianShuQuantityLimit$UserAction.action_id.get() + ",actionTime:" + tianShuQuantityLimit$UserAction.action_time.get() + "}");
            }
            if (!bl.b(arrayList2)) {
                sb5.append(",actionList:");
                sb5.append(Arrays.toString(arrayList2.toArray()));
            }
            arrayList.add(sb5.toString());
        }
        QLog.i("QSplash@-TSL-TSSplashUserActionOperate", 1, "printLog  adStatusList = " + Arrays.toString(arrayList.toArray()));
    }

    public void b(TSSplashUserAction tSSplashUserAction) {
        if (tSSplashUserAction == null) {
            QLog.e("QSplash@-TSL-TSSplashUserActionOperate", 1, "addSplashUserAction  userAction == null");
            return;
        }
        if (TextUtils.isEmpty(tSSplashUserAction.getAdId())) {
            QLog.e("QSplash@-TSL-TSSplashUserActionOperate", 1, "addSplashUserAction  userAction.getAdId is empty");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adId", tSSplashUserAction.getAdId());
            jSONObject.put("actionId", tSSplashUserAction.getActionId());
            jSONObject.put(TianShuMMKVConstant.UserActionKey.ACTION_TIME, tSSplashUserAction.getActionTime());
            String jSONObject2 = jSONObject.toString();
            long i3 = SplashADUtil.i(BaseApplicationImpl.getApplication());
            Set<String> stringSet = TianShuMMKVUtil.g(i3 + "").getStringSet(TianShuMMKVConstant.SplashKey.TS_SPLASH_USER_ACTION_INFO, null);
            if (stringSet == null) {
                stringSet = new HashSet<>();
            }
            stringSet.add(jSONObject2);
            TianShuMMKVUtil.g(i3 + "").putStringSet(TianShuMMKVConstant.SplashKey.TS_SPLASH_USER_ACTION_INFO, stringSet);
            QLog.d("QSplash@-TSL-TSSplashUserActionOperate", 1, "addSplashUserAction  | adId = " + tSSplashUserAction.getAdId() + " | currentUserAction = " + jSONObject2 + " | userActionList = " + Arrays.toString(stringSet.toArray()));
        } catch (JSONException e16) {
            QLog.e("QSplash@-TSL-TSSplashUserActionOperate", 1, "addSplashUserAction  e = " + e16);
        }
    }

    public List<TianShuQuantityLimit$AdStatus> c() {
        List<TianShuQuantityLimit$AdStatus> d16 = d();
        a(d16);
        e(d16);
        return d16;
    }
}
