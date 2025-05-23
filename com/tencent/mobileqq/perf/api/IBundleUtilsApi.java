package com.tencent.mobileqq.perf.api;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IBundleUtilsApi extends QRouteApi {
    String dumpAllFragmentBundleInfo(FragmentActivity fragmentActivity);

    String dumpOfAll(Bundle bundle);

    String dumpOfSelf(Bundle bundle);

    String dumpSize(Bundle bundle);

    long sizeOfParcel(Parcelable parcelable);
}
