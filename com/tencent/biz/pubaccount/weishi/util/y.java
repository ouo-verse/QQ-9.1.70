package com.tencent.biz.pubaccount.weishi.util;

import com.tencent.common.config.AppSetting;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.ROMUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0002H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/util/y;", "", "", "c", "b", "a", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public static final y f81805a = new y();

    y() {
    }

    @JvmStatic
    public static final String a() {
        String j3 = AppSetting.j(BaseApplication.getContext());
        Intrinsics.checkNotNullExpressionValue(j3, "getPublishVersionString(\u2026icationImpl.getContext())");
        return j3;
    }

    @JvmStatic
    public static final String b() {
        return ROMUtil.getRomName() + ROMUtil.getRomVersion();
    }

    @JvmStatic
    public static final String c() {
        String resolution = MobileInfoUtil.getResolution();
        Intrinsics.checkNotNullExpressionValue(resolution, "getResolution()");
        return resolution;
    }
}
