package com.tencent.mobileqq.filemanager.api.impl;

import android.content.Context;
import android.net.Uri;
import android.widget.TextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.api.IQFileUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.QQFileUtilsImpl;
import com.tencent.mobileqq.filemanager.util.ah;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QFileUtilsImpl implements IQFileUtils {
    @Override // com.tencent.mobileqq.filemanager.api.IQFileUtils
    public boolean checkComplexMessage(MessageRecord messageRecord) {
        return QQFileUtilsImpl.b(messageRecord);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileUtils
    public boolean copyFileToMediaStore(Context context, String str, Uri uri) {
        return QQFileUtilsImpl.c(context, str, uri);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileUtils
    public void correctFileEntityInfo(BaseQQAppInterface baseQQAppInterface, FileManagerEntity fileManagerEntity, MessageRecord messageRecord) {
        QQFileUtilsImpl.d(baseQQAppInterface, fileManagerEntity, messageRecord);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileUtils
    public String getAIOFileBubbleShowName(Context context, int i3, int i16, TextView textView, TextView textView2, String str, String str2) {
        return QQFileUtilsImpl.e(context, i3, i16, textView, textView2, str, str2);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileUtils
    public int getAIOFileBubbleShowType(int i3, int i16) {
        return QQFileUtilsImpl.f(i3, i16);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileUtils
    public int getIPStackType() {
        return QQFileUtilsImpl.i();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileUtils
    public int getIpAddrType(String str) {
        return QQFileUtilsImpl.j(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileUtils
    public int getIpAddrTypeOfUrl(String str) {
        return QQFileUtilsImpl.k(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileUtils
    public int getReportIPStackType() {
        return QQFileUtilsImpl.l();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileUtils
    public int getReportLoginIPStackType() {
        return QQFileUtilsImpl.m();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileUtils
    public boolean isShowSendtoWxFaild(Context context, String str) {
        return QQFileUtilsImpl.o(context, str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileUtils
    public void setFileDescription(Context context, TextView textView, String str, String str2, String str3, String str4, String str5, boolean z16, ah.f fVar) {
        QQFileUtilsImpl.p(context, textView, str, str2, str3, str4, str5, z16, fVar);
    }
}
