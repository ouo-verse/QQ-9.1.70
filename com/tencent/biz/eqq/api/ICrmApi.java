package com.tencent.biz.eqq.api;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.io.InputStream;
import mqq.app.api.IRuntimeService;
import mqq.observer.BusinessObserver;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes2.dex */
public interface ICrmApi extends IRuntimeService {
    InputStream bitmap2InputStream(Bitmap bitmap);

    int convertSubVersionToInt(String str);

    void deleteQdCustomerTransferSp(Context context, String str);

    void enterLightTalk(Context context, String str, String str2);

    String getCrmNameFromCache(String str);

    void getCustomerTransferInfo(Context context, String str, String str2);

    String getNickName(String str);

    int getQidianUinType(String str);

    Intent gotoCrmMainProfile(Context context, Intent intent, String str, boolean z16, int i3, boolean z17, int i16);

    boolean hasIvrAbility(String str, int i3);

    int isCertified(String str);

    boolean isCrmMainUinAndGetSimpleInfoIfNeed(String str);

    boolean isCrmMaster(int i3);

    boolean isCrmQQ(String str);

    boolean isQiye(String str, int i3);

    void ivrAudio(Context context, String str, String str2, String str3);

    void showCrmIvrVideoActionSheet(Context context, String str, String str2);

    void updateDetailBackground(Context context, String str, int i3, BusinessObserver businessObserver);
}
