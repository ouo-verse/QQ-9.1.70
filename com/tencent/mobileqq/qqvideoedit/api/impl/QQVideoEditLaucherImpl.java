package com.tencent.mobileqq.qqvideoedit.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qqvideoedit.api.IQQVideoEditLaucher;
import com.tencent.mobileqq.qqvideoedit.b;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQVideoEditLaucherImpl implements IQQVideoEditLaucher {
    @Override // com.tencent.mobileqq.qqvideoedit.api.IQQVideoEditLaucher
    public void jumpToPreviewFragment(Context context, Intent intent, String str, int i3, String str2) {
        b.a(context, intent, str, i3, str2);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.api.IQQVideoEditLaucher
    public void jumpToVideoCamera(Context context, Intent intent, String str) {
        b.b(context, intent, str);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.api.IQQVideoEditLaucher
    public void jumpToVideoCoverEditor(Context context, Intent intent, String str, int i3, String str2) {
        b.c(context, intent, str, i3, str2);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.api.IQQVideoEditLaucher
    public void jumpToVideoEditor(Context context, Intent intent, String str) {
        b.d(context, intent, str);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.api.IQQVideoEditLaucher
    public void jumpToVideoPublish(Context context, Intent intent, String str) {
        b.e(context, intent, str);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.api.IQQVideoEditLaucher
    public void preloadVideoEdit(Context context) {
        b.f(context);
    }
}
