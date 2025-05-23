package com.tencent.qqnt.aio.api.impl;

import android.content.Context;
import com.tencent.aio.data.AIOParam;
import com.tencent.mobileqq.aio.factory.C2CAIOFactory;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.api.IAIOFactoryClassApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/AIOFactoryClassApiImpl;", "Lcom/tencent/qqnt/aio/api/IAIOFactoryClassApi;", "Landroid/content/Context;", "context", "", "isScaleAIO", "isMiniAIO", "", "getMsgHeadPadding", "", "getFirstScreenHelperName", "getC2CAIOFactory", "getGroupAIOFactory", "Lcom/tencent/aio/data/AIOParam;", "aioParam", "Lts/b;", "createAIOAssistanceService", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOFactoryClassApiImpl implements IAIOFactoryClassApi {
    static IPatchRedirector $redirector_;

    public AIOFactoryClassApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.api.IAIOFactoryClassApi
    @NotNull
    public ts.b createAIOAssistanceService(@NotNull Context context, @NotNull AIOParam aioParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ts.b) iPatchRedirector.redirect((short) 6, (Object) this, (Object) context, (Object) aioParam);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(aioParam, "aioParam");
        return new com.tencent.mobileqq.aio.factory.param.n(context, aioParam);
    }

    @Override // com.tencent.qqnt.aio.api.IAIOFactoryClassApi
    @NotNull
    public String getC2CAIOFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        String name = C2CAIOFactory.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "C2CAIOFactory::class.java.name");
        return name;
    }

    @Override // com.tencent.qqnt.aio.api.IAIOFactoryClassApi
    @NotNull
    public String getFirstScreenHelperName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        String name = com.tencent.mobileqq.aio.factory.param.n.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "FirstScreenHelperImpl::class.java.name");
        return name;
    }

    @Override // com.tencent.qqnt.aio.api.IAIOFactoryClassApi
    @NotNull
    public String getGroupAIOFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        String name = com.tencent.mobileqq.aio.c.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "GroupAIOFactory::class.java.name");
        return name;
    }

    @Override // com.tencent.qqnt.aio.api.IAIOFactoryClassApi
    public int getMsgHeadPadding(@NotNull Context context, boolean isScaleAIO, boolean isMiniAIO) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, this, context, Boolean.valueOf(isScaleAIO), Boolean.valueOf(isMiniAIO))).intValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return AIOUtil.f194084a.m(context, isScaleAIO, isMiniAIO);
    }
}
