package hv2;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.QADNetStatus;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadutils.SpaEffectReportActionKey;
import pw2.x;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class c extends j {
    public abstract String a();

    public abstract String b();

    public abstract String c();

    @QADNetStatus
    public abstract String d();

    public abstract String e();

    public abstract String f();

    public abstract int g();

    public abstract int h();

    public String i(@SpaEffectReportActionKey String str) {
        return x.b(str);
    }

    public abstract String j();
}
