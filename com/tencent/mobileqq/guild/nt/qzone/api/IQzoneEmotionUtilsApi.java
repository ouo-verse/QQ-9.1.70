package com.tencent.mobileqq.guild.nt.qzone.api;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.regex.Pattern;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IQzoneEmotionUtilsApi extends QRouteApi {
    int getEmoCount(@NonNull String str);

    Pattern getSmileyPattern();

    String replaceEmoCode(@NonNull String str, @NonNull String str2);

    String splash2Emo(@NonNull String str);
}
