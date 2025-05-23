package com.tencent.mobileqq.guild.api;

import android.widget.ImageView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGuildChannelIconTypeApi extends QRouteApi {
    @MainThread
    void setChannelIcon(@NonNull ImageView imageView, int i3, int i16);

    @MainThread
    void setChannelIcon(@NonNull ImageView imageView, @NonNull String str);

    @MainThread
    void setSameChannelIcon(@NonNull ImageView imageView, int i3, int i16);
}
