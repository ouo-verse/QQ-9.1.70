package com.tencent.hippykotlin.demo.pages.base.model;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class KTVAlertInfo {
    public final String message;
    public final int messageAlignment;
    public final float messageFontSize;
    public final String title;

    public /* synthetic */ KTVAlertInfo(String str, String str2) {
        this(str, str2, 14.0f, 1);
    }

    public KTVAlertInfo(String str, String str2, float f16, int i3) {
        this.title = str;
        this.message = str2;
        this.messageFontSize = f16;
        this.messageAlignment = i3;
    }
}
