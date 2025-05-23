package com.tencent.qzonehub.api;

import android.os.Parcelable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQzoneEventApi extends QRouteApi {

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface ExoticEventInterface extends Parcelable {
        Object getParam();

        String getSourceName();

        int getWhat();
    }

    ClassLoader getLoader();

    ExoticEventInterface obtain(int i3, String str, Object obj);

    boolean onEventReceived(ExoticEventInterface exoticEventInterface);

    ExoticEventInterface pollEvent();
}
