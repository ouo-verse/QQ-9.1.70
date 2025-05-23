package com.tencent.av.video.effect.core.qqavimage;

/* loaded from: classes3.dex */
public class QQAVImageTwoPassFilter extends QQAVImageFilterGroup {
    public QQAVImageTwoPassFilter(String str, String str2, String str3, String str4) {
        super(null);
        addFilter(new QQAVImageFilter(str, str2));
        addFilter(new QQAVImageFilter(str3, str4));
    }
}
