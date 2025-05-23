package com.tencent.gdt.tangram.ad.qzone.embedded.action;

import android.content.Context;
import android.graphics.Rect;
import android.net.http.Headers;
import android.text.TextUtils;
import android.view.View;
import com.qzone.commoncode.module.gdt.GdtFeedUtilForQZone;
import com.qzone.module.feedcomponent.ui.FeedAutoVideo;
import com.qzone.module.feedcomponent.ui.FeedView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.tencent.gdt.tangram.ad.qzone.AdClickData;
import com.tencent.mobileqq.mini.share.MiniProgramOpenSdkUtil;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideo;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes31.dex */
public class AdActionTangram extends zl0.a {

    /* renamed from: e, reason: collision with root package name */
    private BaseVideo f108425e;

    public AdActionTangram(AdClickData adClickData, yl0.a aVar) {
        super(adClickData, aVar);
    }

    @Override // zl0.a
    public void f(yl0.a aVar, AdClickData adClickData) {
        Rect rect;
        final String c16;
        boolean z16 = !this.f452727c;
        BaseVideo baseVideo = this.f108425e;
        if (z16 & (baseVideo != null)) {
            baseVideo.doPlayVideo();
            return;
        }
        BusinessFeedData m3 = adClickData.m();
        Context e16 = com.tencent.gdt.tangram.ad.qzone.c.e(adClickData.k());
        int id5 = aVar.a().getId();
        String str = m3.getRecommAction().f50232rl;
        if (this.f452728d) {
            if (com.tencent.gdt.tangram.ad.qzone.embedded.b.a(str, aVar)) {
                String g16 = new com.tencent.gdt.tangram.ad.qzone.b(m3).g();
                if (TextUtils.isEmpty(g16)) {
                    c16 = com.tencent.gdt.tangram.ad.qzone.c.b(str, aVar);
                } else {
                    c16 = com.tencent.gdt.tangram.ad.qzone.c.c(com.tencent.gdt.tangram.ad.qzone.c.b(str, aVar), g16);
                }
                GdtFeedUtilForQZone.z(new Runnable() { // from class: com.tencent.gdt.tangram.ad.qzone.embedded.action.AdActionTangram.1
                    @Override // java.lang.Runnable
                    public void run() {
                        HttpURLConnection httpURLConnection = null;
                        try {
                            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(c16).openConnection();
                            try {
                                httpURLConnection2.setRequestProperty(Headers.CONN_DIRECTIVE, "Keep-Alive");
                                httpURLConnection2.connect();
                                if (httpURLConnection2.getResponseCode() == 200) {
                                    com.tencent.gdt.tangram.ad.qzone.d.b("AdActionTangram", "success");
                                }
                                httpURLConnection2.disconnect();
                            } catch (Throwable unused) {
                                httpURLConnection = httpURLConnection2;
                                try {
                                    com.tencent.gdt.tangram.ad.qzone.d.b("AdActionTangram", String.format("run %s", c16));
                                } finally {
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                }
                            }
                        } catch (Throwable unused2) {
                        }
                    }
                });
            }
        } else {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(aVar.j())) {
                hashMap.put(ReportConstant.COSTREPORT_PREFIX, aVar.j());
            }
            com.tencent.gdt.tangram.ad.qzone.c.a(m3.getRecommAction().f50232rl, hashMap);
        }
        View p16 = adClickData.p();
        if (p16 != null) {
            int[] iArr = new int[2];
            p16.getLocationInWindow(iArr);
            int i3 = iArr[0];
            int i16 = iArr[1];
            rect = new Rect(i3, i16, p16.getWidth() + i3, p16.getHeight() + i16);
        } else {
            rect = null;
        }
        if (aVar.a().getScene().getId() == 0) {
            if ((adClickData.l() == FeedElement.HOT_STAR || adClickData.l() == FeedElement.FEEDBACK_LEFT_TITLE) && id5 == 0) {
                return;
            }
            if ((m3.isImaxVideoAdv() && adClickData.l() == FeedElement.AUTO_VIDEO) || adClickData.l() == FeedElement.ADV_CONTAINER) {
                return;
            }
            if (m3.isGdt585AdVideo() && adClickData.l() == FeedElement.AUTO_VIDEO) {
                return;
            }
            if (!m3.isImaxVideoAdv() && m3.isGdt185AdVideo() && (adClickData.l() == FeedElement.AUTO_VIDEO_CLICK || adClickData.l() == FeedElement.FEEDBACK_BAR)) {
                return;
            }
            if (adClickData.l().toString() == "GESTURE_AD_VIEW") {
                id5 = 35;
            }
            if (adClickData.l().toString() == "GESTURE_AD_CLICK_VIEW") {
                id5 = 6;
            }
            if ((h(adClickData) && (adClickData.l() == FeedElement.DROPDOWN_BUTTON || adClickData.l() == FeedElement.FEEDBACK_BAR)) || adClickData.l() == FeedElement.DROPDOWN_BUTTON) {
                return;
            }
            com.tencent.gdt.tangram.ad.qzone.b bVar = new com.tencent.gdt.tangram.ad.qzone.b(adClickData.m());
            if (adClickData.m() != null && adClickData.m().isGdt185AdVideo() && bVar.a(id5, null) == 3 && !h(adClickData) && !g(adClickData)) {
                return;
            }
        }
        GdtFeedUtilForQZone.u(e16, m3, !this.f452728d, aVar.a().getScene().getId(), id5, rect);
    }

    @Override // zl0.a
    protected void e(AdClickData adClickData, yl0.a aVar) {
        FeedView feedView;
        try {
            if (aVar.a().getId() == 6 && (feedView = (FeedView) c6.a.b(adClickData.p())) != null) {
                FeedAutoVideo autoVideoView = feedView.getAutoVideoView();
                this.f108425e = autoVideoView;
                if (autoVideoView != null && autoVideoView.getState() != 3) {
                    this.f452727c = false;
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        this.f452725a = 7;
        int id5 = aVar.a().getId();
        Object j3 = adClickData.j();
        com.tencent.gdt.tangram.ad.qzone.b bVar = new com.tencent.gdt.tangram.ad.qzone.b(adClickData.m());
        if (new com.tencent.gdt.tangram.ad.qzone.b(adClickData.m()).a(id5, j3) == 2 && (bVar.i() != 4 || (!com.tencent.gdt.tangram.ad.qzone.embedded.b.c(adClickData.m()) && !com.tencent.gdt.tangram.ad.qzone.embedded.b.j(bVar.b())))) {
            this.f452726b = true;
        }
        this.f452728d = false;
        if (adClickData.m() == null || !adClickData.m().isGdt185AdVideo() || bVar.a(id5, null) != 3 || h(adClickData) || adClickData.l() == FeedElement.AUTO_VIDEO) {
            return;
        }
        this.f452728d = true;
    }

    private boolean g(AdClickData adClickData) {
        if (adClickData == null || adClickData.m() == null || adClickData.m().getRecommAction() == null || TextUtils.isEmpty(adClickData.m().getRecommAction().currency_pass_field)) {
            return false;
        }
        try {
            return new JSONObject(adClickData.m().getRecommAction().currency_pass_field).optInt(MiniProgramOpenSdkUtil.ATTR_SHARE_TO_QQ_MINI_PROGRAM_TYPE) == 11;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return false;
        }
    }

    private boolean h(AdClickData adClickData) {
        if (adClickData == null || adClickData.m() == null || adClickData.m().getRecommAction() == null || TextUtils.isEmpty(adClickData.m().getRecommAction().currency_pass_field)) {
            return false;
        }
        try {
            return new JSONObject(adClickData.m().getRecommAction().currency_pass_field).optInt(MiniProgramOpenSdkUtil.ATTR_SHARE_TO_QQ_MINI_PROGRAM_TYPE) == 3;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return false;
        }
    }
}
