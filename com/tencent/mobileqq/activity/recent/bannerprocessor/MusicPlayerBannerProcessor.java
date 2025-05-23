package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.Intent;
import android.os.Message;
import android.text.Html;
import android.view.View;
import com.tencent.biz.qui.noticebar.QUINoticeBarManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.musicgene.MusicGeneQQBrowserActivity;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

@KeepClassConstructor
/* loaded from: classes10.dex */
public class MusicPlayerBannerProcessor extends BaseBannerProcessor {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static final int f185234d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69214);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f185234d = com.tencent.mobileqq.banner.d.Q;
        }
    }

    public MusicPlayerBannerProcessor(QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(QBaseActivity qBaseActivity, View view) {
        int i3;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intent i06 = QQPlayerService.i0();
        if (i06 != null) {
            qBaseActivity.startActivity(i06);
            String className = i06.getComponent().getClassName();
            if (className.equals(MusicPlayerActivity.class.getName())) {
                i3 = 0;
            } else if (className.equals(MusicGeneQQBrowserActivity.class.getName())) {
                i3 = 1;
            } else {
                i3 = -1;
            }
            ReportController.r(qBaseActivity.getAppRuntime(), "dc00898", "", "", BaseBannerProcessor.TVALUE_CLICK_MUSIC, BaseBannerProcessor.TVALUE_CLICK_MUSIC, 1, 0, "", "", "", "");
            ReportController.o(qBaseActivity.getAppRuntime(), "CliOper", "", "", "Msg_tab", "Mt_music_tips", 0, 0, "" + i3, "", "", "");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public int defaultTipsBarType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 1;
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return f185234d;
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public View initBanner(com.tencent.mobileqq.banner.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        }
        final QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null) {
            return null;
        }
        return QUINoticeBarManager.l().h(baseActivity).setIcon(R.drawable.d1r).c(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.recent.bannerprocessor.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MusicPlayerBannerProcessor.f(QBaseActivity.this, view);
            }
        }).getView();
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void updateBanner(com.tencent.mobileqq.banner.a aVar, Message message) {
        com.tencent.biz.qui.noticebar.d d16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar, (Object) message);
            return;
        }
        QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null || (d16 = QUINoticeBarManager.l().d(aVar.f200243c)) == null) {
            return;
        }
        if (QQPlayerService.s0()) {
            aVar.f200243c.setVisibility(0);
            SongInfo b06 = QQPlayerService.b0();
            if (b06 != null) {
                d16.setMsg(Html.fromHtml(baseActivity.getString(R.string.cwy) + " " + b06.f251871i).toString());
            }
            ReportController.r(baseActivity.getAppRuntime(), "dc00898", "", "", BaseBannerProcessor.TVALUE_SHOW_MUSIC, BaseBannerProcessor.TVALUE_SHOW_MUSIC, 1, 0, "", "", "", "");
            return;
        }
        aVar.f200243c.setVisibility(8);
        BannerManager.l().O(f185234d, 0, null);
    }
}
