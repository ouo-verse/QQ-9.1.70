package com.tencent.mobileqq.filemanager.api;

import android.content.Context;
import android.net.Uri;
import android.widget.TextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IQFileUtils extends QRouteApi {
    boolean checkComplexMessage(MessageRecord messageRecord);

    boolean copyFileToMediaStore(Context context, String str, Uri uri);

    void correctFileEntityInfo(BaseQQAppInterface baseQQAppInterface, FileManagerEntity fileManagerEntity, MessageRecord messageRecord);

    String getAIOFileBubbleShowName(Context context, int i3, int i16, TextView textView, TextView textView2, String str, String str2);

    int getAIOFileBubbleShowType(int i3, int i16);

    int getIPStackType();

    int getIpAddrType(String str);

    int getIpAddrTypeOfUrl(String str);

    int getReportIPStackType();

    int getReportLoginIPStackType();

    boolean isShowSendtoWxFaild(Context context, String str);

    void setFileDescription(Context context, TextView textView, String str, String str2, String str3, String str4, String str5, boolean z16, ah.f fVar);
}
