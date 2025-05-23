package com.google.android.filament.utils;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u000e\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0003\u00a8\u0006\b"}, d2 = {"Lcom/google/android/filament/utils/d;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "c", "Lcom/google/android/filament/utils/b;", ReportConstant.COSTREPORT_PREFIX, "a", "t", "b", "filament-utils-android_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class e {
    @NotNull
    public static final d a(@NotNull Float3 s16) {
        Intrinsics.checkNotNullParameter(s16, "s");
        return new d(new Float4(s16.getX(), 0.0f, 0.0f, 0.0f, 14, null), new Float4(0.0f, s16.getY(), 0.0f, 0.0f, 13, null), new Float4(0.0f, 0.0f, s16.getZ(), 0.0f, 11, null), null, 8, null);
    }

    @NotNull
    public static final d b(@NotNull Float3 t16) {
        Intrinsics.checkNotNullParameter(t16, "t");
        return new d(null, null, null, new Float4(t16, 1.0f), 7, null);
    }

    @NotNull
    public static final d c(@NotNull d m3) {
        Intrinsics.checkNotNullParameter(m3, "m");
        return new d(new Float4(m3.getCom.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter.X java.lang.String().getX(), m3.getY().getX(), m3.getCom.tencent.mobileqq.qcircle.api.constant.QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW java.lang.String().getX(), m3.getW().getX()), new Float4(m3.getCom.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter.X java.lang.String().getY(), m3.getY().getY(), m3.getCom.tencent.mobileqq.qcircle.api.constant.QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW java.lang.String().getY(), m3.getW().getY()), new Float4(m3.getCom.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter.X java.lang.String().getZ(), m3.getY().getZ(), m3.getCom.tencent.mobileqq.qcircle.api.constant.QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW java.lang.String().getZ(), m3.getW().getZ()), new Float4(m3.getCom.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter.X java.lang.String().getW(), m3.getY().getW(), m3.getCom.tencent.mobileqq.qcircle.api.constant.QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW java.lang.String().getW(), m3.getW().getW()));
    }
}
