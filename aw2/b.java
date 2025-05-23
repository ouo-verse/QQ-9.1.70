package aw2;

import android.app.Dialog;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import bw2.h;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx.OpenSdkManager;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx.d;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx.e;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.VideoReportInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.thread.QAdThreadManager;
import com.tencent.qqlive.ona.protocol.jce.AdActionItem;
import com.tencent.qqlive.ona.protocol.jce.AdOpenMiniProgramItem;
import pw2.n;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b extends h {
    public b(Context context, wv2.a aVar) {
        super(context, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(d dVar, VideoReportInfo videoReportInfo) {
        OpenSdkManager.INSTANCE.launchMiniProgram(dVar, z(videoReportInfo));
    }

    @Override // bw2.h
    protected void C(AdOpenMiniProgramItem adOpenMiniProgramItem, final VideoReportInfo videoReportInfo) {
        final d a16 = com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx.a.a(adOpenMiniProgramItem, "MiniGame");
        QAdThreadManager.INSTANCE.execTask(new Runnable() { // from class: aw2.a
            @Override // java.lang.Runnable
            public final void run() {
                b.this.Y(a16, videoReportInfo);
            }
        });
    }

    @Override // bw2.h
    protected int F() {
        return 23;
    }

    @Override // bw2.h
    protected int G() {
        return 26;
    }

    @Override // bw2.h
    protected int H() {
        return 22;
    }

    @Override // bw2.h
    @Nullable
    protected AdOpenMiniProgramItem I() {
        AdActionItem adActionItem;
        AdOpenMiniProgramItem adOpenMiniProgramItem;
        wv2.a aVar = this.f303963a;
        if (aVar != null && (adActionItem = aVar.f446565a) != null && (adOpenMiniProgramItem = adActionItem.adOpenMiniGame) != null) {
            return adOpenMiniProgramItem;
        }
        n.h(this.f29329g, "getOpenMiniItem: is null");
        return null;
    }

    @Override // bw2.h
    protected int J() {
        return 24;
    }

    @Override // bw2.h
    protected int K() {
        return 25;
    }

    @Override // bw2.h
    @NonNull
    protected String L() {
        return "QADMiniGameActionHandler";
    }

    @Override // bw2.h
    protected Dialog x(d dVar, e eVar) {
        dVar.c("MiniGame");
        return h.W(this.f303964b, dVar, eVar);
    }
}
