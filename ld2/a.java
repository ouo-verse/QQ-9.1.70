package ld2;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.entitymanager.Interceptor;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes16.dex */
public abstract class a implements Interceptor<Void> {
    public AppRuntime a() {
        return BaseApplicationImpl.getApplication().getRuntime();
    }
}
