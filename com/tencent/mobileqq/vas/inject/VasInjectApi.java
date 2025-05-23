package com.tencent.mobileqq.vas.inject;

import androidx.annotation.Keep;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import java.util.ArrayList;

/* compiled from: P */
@Keep
/* loaded from: classes20.dex */
public class VasInjectApi {

    @QAutoInject(configPath = "AutoInjectYml/Business/Vas/Inject_IVasInject.yml", version = 2)
    private static IVasInject instance;
    private static ArrayList instance_AutoGenClazzList_QAutoInjectTransform;

    static {
        ArrayList arrayList = new ArrayList();
        instance_AutoGenClazzList_QAutoInjectTransform = arrayList;
        arrayList.add(VasInjectImpl.class);
        initInjectVariable();
    }

    public static IVasInject getInstance() {
        return instance;
    }

    @QAutoInitMethod
    public static void initInjectVariable() {
        instance = (IVasInject) com.tencent.mobileqq.qroute.utils.b.a(instance_AutoGenClazzList_QAutoInjectTransform);
    }
}
