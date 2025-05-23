package com.tencent.mobileqq.utils.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.utils.api.IContactUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ContactUtilsImpl implements IContactUtils {
    private static final String TAG = "ContactUtilsImpl";

    @Override // com.tencent.mobileqq.utils.api.IContactUtils
    public String getAccountNickName(AppInterface appInterface, String str) {
        if (appInterface instanceof QQAppInterface) {
            try {
                return ac.f((QQAppInterface) appInterface, str);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "getAccountNickName error:", e16);
                return str;
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.utils.api.IContactUtils
    public String getBuddyNickName(AppRuntime appRuntime, String str, boolean z16) {
        return ac.h(appRuntime, str, z16);
    }

    @Override // com.tencent.mobileqq.utils.api.IContactUtils
    public String getFriendNickName(AppInterface appInterface, String str) {
        if (appInterface instanceof QQAppInterface) {
            try {
                return ac.G((QQAppInterface) appInterface, str);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "getFriendNickName error:", e16);
            }
        }
        return str;
    }
}
