package com.tencent.biz.qqstory.takevideo.slideshow.core;

import android.media.MediaFormat;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.biz.qqstory.takevideo.slideshow.core.SlideShowProcessor;
import com.tencent.biz.qqstory.takevideo.slideshow.d;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.e;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    protected int f94382a;

    /* renamed from: b, reason: collision with root package name */
    protected e f94383b;

    /* renamed from: c, reason: collision with root package name */
    protected String f94384c;

    /* renamed from: d, reason: collision with root package name */
    protected String f94385d;

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(SlideShowProcessor.e eVar) {
        if (!eVar.f94353a && QLog.isColorLevel()) {
            QLog.d("ToVideoConverter", 2, "run exit:" + eVar.f94354b + " currContext.isRun:" + eVar.f94353a);
        }
        return !eVar.f94353a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i3, String str, String str2, MediaFormat mediaFormat, SlideItemInfo slideItemInfo, SlideShowProcessor.e eVar) {
        if (eVar != null) {
            d dVar = new d();
            dVar.f94391a = eVar.f94354b;
            dVar.f94392b = i3;
            dVar.f94394d = str2;
            dVar.f94393c = str;
            dVar.f94395e = mediaFormat;
            dVar.f94396f = this.f94385d;
            dVar.f94397g = false;
            dVar.f94398h = 1;
            if (slideItemInfo != null) {
                dVar.f94397g = slideItemInfo.H;
                dVar.f94398h = slideItemInfo.I;
            }
            SlideShowProcessor.d dVar2 = eVar.f94355c;
            if (dVar2 != null) {
                dVar2.c(dVar);
            }
        }
    }
}
