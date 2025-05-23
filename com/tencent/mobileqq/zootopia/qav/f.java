package com.tencent.mobileqq.zootopia.qav;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qav.QavDef$MultiUserInfo;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\r\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\n\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\r\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0016J\"\u0010\u0010\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u001a\u0010\u0013\u001a\u00020\u00022\u0010\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0004H\u0016J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0016J\u0010\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u000bH\u0016J\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u000bH\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/zootopia/qav/f;", "", "", "b", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "c", "Lcom/tencent/qav/QavDef$MultiUserInfo;", ITVKPlayerEventListener.KEY_USER_INFO, "g", tl.h.F, "", "available", "f", "isSpeaking", "audioEnergy", "i", "", "userInfoList", "j", "volumeValue", "d", "audioOutPut", "subtype", "a", "isCalling", "e", "k", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public abstract class f {
    public void b() {
    }

    public void c(int errorType) {
    }

    public void d(int volumeValue) {
    }

    public void e(boolean isCalling) {
    }

    public void g(QavDef$MultiUserInfo userInfo) {
    }

    public void h(QavDef$MultiUserInfo userInfo) {
    }

    public void j(List<? extends QavDef$MultiUserInfo> userInfoList) {
    }

    public void k(boolean isCalling) {
    }

    public void a(int audioOutPut, int subtype) {
    }

    public void f(QavDef$MultiUserInfo userInfo, boolean available) {
    }

    public void i(QavDef$MultiUserInfo userInfo, boolean isSpeaking, int audioEnergy) {
    }
}
