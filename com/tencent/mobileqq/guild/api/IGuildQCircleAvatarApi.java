package com.tencent.mobileqq.guild.api;

import android.widget.ImageView;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes12.dex */
public interface IGuildQCircleAvatarApi extends QRouteApi {
    void loadAvatarByTinyId(String str, String str2, int i3, ImageView imageView);

    void loadAvatarByTinyIdAndAvatarMeta(String str, String str2, String str3, int i3, ImageView imageView);

    void loadAvatarByUrl(String str, ImageView imageView);

    void loadAvatarByUrl(String str, ImageView imageView, int i3, int i16);

    void loadPendantByAvatarPendant(String str, ImageView imageView);

    void loadPendantByTinyId(String str, ImageView imageView);

    void loadPendantByUrl(String str, ImageView imageView);
}
