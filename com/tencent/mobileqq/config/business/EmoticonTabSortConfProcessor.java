package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.Constant;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import mqq.app.MobileQQ;

/* loaded from: classes10.dex */
public class EmoticonTabSortConfProcessor extends BaseConfigParser<m> {
    private static void b(m mVar) {
        if (mVar.f202674f.contains("ai_emoticon")) {
            return;
        }
        ArrayList arrayList = new ArrayList(mVar.f202674f);
        int i3 = 0;
        while (true) {
            if (i3 < arrayList.size()) {
                if ("hotpic".equals(arrayList.get(i3))) {
                    break;
                } else {
                    i3++;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 != -1) {
            arrayList.add(i3 + 1, "ai_emoticon");
        } else {
            arrayList.add("ai_emoticon");
        }
        mVar.f202674f = arrayList;
    }

    private static void c(m mVar) {
        if (mVar.f202674f.contains("ani_sticker")) {
            return;
        }
        ArrayList arrayList = new ArrayList(mVar.f202674f);
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            if ("sysface".equals((String) arrayList.get(i3))) {
                arrayList.add(i3 + 1, "ani_sticker");
                mVar.f202674f = arrayList;
                return;
            }
        }
    }

    private static void d(m mVar) {
        boolean isZPlanAccessible = ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).isZPlanAccessible(Constant.FROM_ID_START_ACTIVITY, MobileQQ.sMobileQQ.peekAppRuntime().getLongAccountUin());
        QLog.i("EmoticonTabSortConfProcessor", 1, "[addZPlanEntry] zPlanWhiteList = " + isZPlanAccessible);
        ArrayList arrayList = new ArrayList(mVar.f202674f);
        if (!isZPlanAccessible) {
            arrayList.remove("zplan");
        } else {
            if (arrayList.contains("zplan")) {
                return;
            }
            int i3 = 0;
            while (true) {
                if (i3 < arrayList.size()) {
                    if ("cmshow".equals(arrayList.get(i3))) {
                        break;
                    } else {
                        i3++;
                    }
                } else {
                    i3 = -1;
                    break;
                }
            }
            if (i3 != -1) {
                arrayList.add(i3, "zplan");
            } else {
                arrayList.add("zplan");
            }
        }
        mVar.f202674f = arrayList;
    }

    public static m g() {
        m mVar = (m) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("101224");
        if (mVar != null && mVar.f202674f != null) {
            c(mVar);
            d(mVar);
            b(mVar);
            QLog.i("EmoticonTabSortConfProcessor", 1, "[loadConObj] entryOrder=" + mVar.f202674f);
        } else {
            QLog.i("EmoticonTabSortConfProcessor", 1, "[loadConObj] sortConfBean is null or mEntryOrder is null");
        }
        return mVar;
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public m defaultConfig() {
        return new m();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(@Nullable m mVar) {
        super.doOnConfigUpdate(mVar);
        if (QLog.isColorLevel()) {
            QLog.d("EmoticonTabSortConfProcessor", 2, "EmoticonTabSortConfProcessor onUpdate");
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public m parse(@NonNull byte[] bArr) {
        String str = new String(bArr, StandardCharsets.UTF_8);
        if (TextUtils.isEmpty(str)) {
            QLog.d("EmoticonTabSortConfProcessor", 1, "EmoticonTabSortConfBean parse null");
            return new m();
        }
        QLog.d("EmoticonTabSortConfProcessor", 1, "EmoticonTabSortConfBean parse " + str);
        return m.b(str);
    }
}
