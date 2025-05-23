package com.tencent.mobileqq.nearby.now.utils.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.utils.ICommentsUtil;
import q92.a;

/* compiled from: P */
/* loaded from: classes33.dex */
public class CommentsUtilImpl implements ICommentsUtil {
    @Override // com.tencent.mobileqq.nearby.now.utils.ICommentsUtil
    public CharSequence clip(CharSequence charSequence, int i3, int i16) {
        return a.a(charSequence, i3, i16);
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.ICommentsUtil
    public String encode16(byte[] bArr) {
        return a.b(bArr);
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.ICommentsUtil
    public String formatNumber(long j3) {
        return a.c(j3);
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.ICommentsUtil
    public String formatSimpleDateTime(long j3) {
        return a.d(j3);
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.ICommentsUtil
    public String formatWatchNumber(long j3) {
        return a.e(j3);
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.ICommentsUtil
    public int getChinese(String str) {
        return a.f(str);
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.ICommentsUtil
    public int getLength(CharSequence charSequence) {
        return a.g(charSequence);
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.ICommentsUtil
    public boolean isSingleWord(char c16) {
        return a.i(c16);
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.ICommentsUtil
    public void reportClickEvent(AppInterface appInterface, String str) {
        a.j((QQAppInterface) appInterface, str);
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.ICommentsUtil
    public String simpleFormatTime(long j3) {
        return a.m(j3);
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.ICommentsUtil
    public void reportClickEvent(AppInterface appInterface, String str, String str2) {
        a.k((QQAppInterface) appInterface, str, str2);
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.ICommentsUtil
    public void reportClickEvent(AppInterface appInterface, String str, String str2, String str3, String str4, String str5, String str6) {
        a.l((QQAppInterface) appInterface, str, str2, str3, str4, str5, str6);
    }
}
