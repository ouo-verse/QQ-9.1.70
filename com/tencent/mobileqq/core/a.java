package com.tencent.mobileqq.core;

import com.tencent.mobileqq.emoticon.IEmotionPanelBuilder;
import com.tencent.mobileqq.emoticonview.BaseEmotionAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public long f203030a;

    /* renamed from: b, reason: collision with root package name */
    public long f203031b;

    /* renamed from: c, reason: collision with root package name */
    public long f203032c;

    /* renamed from: d, reason: collision with root package name */
    public long f203033d;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f203030a = 0L;
        this.f203031b = 0L;
        this.f203032c = 0L;
        this.f203033d = 0L;
    }

    public BaseEmotionAdapter a(IEmotionPanelBuilder iEmotionPanelBuilder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (BaseEmotionAdapter) iPatchRedirector.redirect((short) 2, (Object) this, (Object) iEmotionPanelBuilder);
        }
        if (iEmotionPanelBuilder != null) {
            long currentTimeMillis = System.currentTimeMillis();
            iEmotionPanelBuilder.buildParams();
            long currentTimeMillis2 = System.currentTimeMillis();
            this.f203030a = currentTimeMillis2 - currentTimeMillis;
            iEmotionPanelBuilder.buildView();
            long currentTimeMillis3 = System.currentTimeMillis();
            this.f203031b = currentTimeMillis3 - currentTimeMillis2;
            iEmotionPanelBuilder.buildData();
            long currentTimeMillis4 = System.currentTimeMillis();
            this.f203032c = currentTimeMillis4 - currentTimeMillis3;
            BaseEmotionAdapter buildComplete = iEmotionPanelBuilder.buildComplete();
            this.f203033d = System.currentTimeMillis() - currentTimeMillis4;
            if (QLog.isColorLevel()) {
                QLog.d("EmotionPanelBuilderDirector", 2, "buildParamsTime = " + this.f203030a + ", buildViewTime = " + this.f203031b + ", buildDataTime = " + this.f203032c + ", buildCompleteTime = " + this.f203033d);
            }
            return buildComplete;
        }
        return null;
    }
}
