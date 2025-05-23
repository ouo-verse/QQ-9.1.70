package com.tencent.mobileqq.guild.nt.avatar.api;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IQQAvatarUtilApi extends QRouteApi {
    Drawable getDefaultFaceDrawable(boolean z16);

    Drawable getFaceDrawableByUser(AppInterface appInterface, @NonNull String str);

    Drawable getUserFaceDrawable(AppInterface appInterface, @NonNull String str, byte b16);
}
