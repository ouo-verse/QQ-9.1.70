package cooperation.vip.ad;

import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.activity.recent.bannerprocessor.DressUpBannerProcessor;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.guild.nt.misc.api.IJumpApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.TextTipsBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.mobilereport.MobileReportManager;
import cooperation.vip.pb.TianShuAccess;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class n extends v {
    public n() {
        this.f391231a = SubAccountBindActivity.ERROR_ACCOUNT_LOCK;
    }

    public static void k(final BaseActivity baseActivity, View view, final com.tencent.mobileqq.redtouch.h hVar, boolean z16) {
        if (v.c(baseActivity, view, hVar) || !(view instanceof TipsBar)) {
            return;
        }
        String str = hVar.f280300c;
        if (!TextUtils.isEmpty(str)) {
            ((TextTipsBar) view).setTipsText(str);
        }
        if (!TextUtils.isEmpty(hVar.f280303f)) {
            ((TextTipsBar) view).setButtonText(hVar.f280303f);
        }
        ((TextTipsBar) view).z(true);
        view.setVisibility(0);
        v("1", hVar.f280298a, 101);
        w.e(hVar.f280298a, 101);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: cooperation.vip.ad.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                n.t(com.tencent.mobileqq.redtouch.h.this, baseActivity, view2);
            }
        };
        view.setEnabled(true);
        view.setOnClickListener(onClickListener);
        TextTipsBar textTipsBar = (TextTipsBar) view;
        textTipsBar.setOriginalOnClickListener(onClickListener);
        textTipsBar.setCloseListener(new View.OnClickListener() { // from class: cooperation.vip.ad.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                n.u(com.tencent.mobileqq.redtouch.h.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void t(com.tencent.mobileqq.redtouch.h hVar, BaseActivity baseActivity, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        String str = hVar.f280301d;
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase();
            if (!lowerCase.startsWith("http://") && !lowerCase.startsWith("https://")) {
                ((IJumpApi) QRoute.api(IJumpApi.class)).doJumpAction(baseActivity, hVar.f280301d);
                BannerManager.l().O(DressUpBannerProcessor.f185209h, 0, null);
            } else {
                Intent intent = new Intent(baseActivity, (Class<?>) QQBrowserActivity.class);
                intent.putExtra("url", hVar.f280301d);
                intent.putExtra("startOpenPageTime", System.currentTimeMillis());
                baseActivity.startActivity(intent);
                BannerManager.l().O(DressUpBannerProcessor.f185209h, 0, null);
            }
            w.e(hVar.f280298a, 102);
            v("1", hVar.f280298a, 102);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void u(com.tencent.mobileqq.redtouch.h hVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        v("2", hVar.f280298a, 102);
        w.e(hVar.f280298a, 122);
        BannerManager.l().O(DressUpBannerProcessor.f185209h, 0, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private static void v(String str, String str2, int i3) {
        try {
            MobileReportManager.getInstance().reportAction("DressVip", "3001188", "1", str, str2, "", "4", i3, 0, 0, "", "", str2);
        } catch (Exception e16) {
            QLog.e("TianshuDressUpBarManager", 1, "report error", e16);
        }
    }

    @Override // cooperation.vip.ad.v
    public void g(Map<Integer, TianShuAccess.RspEntry> map, int i3) {
        boolean z16;
        BannerManager l3 = BannerManager.l();
        int i16 = DressUpBannerProcessor.f185209h;
        if (l3.g(i16) == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && 2 == i3) {
            BannerManager.l().D(i16, 2001);
        } else {
            f(map.get(Integer.valueOf(this.f391231a)));
        }
    }

    @Override // cooperation.vip.ad.v
    public void j(TianShuAccess.AdItem adItem) {
        if (adItem != null && adItem.argList.size() >= 1) {
            HashMap hashMap = new HashMap();
            for (TianShuAccess.MapEntry mapEntry : adItem.argList.get()) {
                hashMap.put(mapEntry.key.get(), mapEntry.value.get());
            }
            com.tencent.mobileqq.redtouch.h hVar = new com.tencent.mobileqq.redtouch.h();
            hVar.f280298a = adItem.iAdId.get() + "";
            hVar.f280299b = adItem.traceinfo.get();
            hVar.f280300c = (String) hashMap.get("desc_text");
            hVar.f280303f = (String) hashMap.get(QZoneAdTianshuFeedData.KEY_BUTTON_TEXT);
            hVar.f280301d = (String) hashMap.get(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK);
            if (!TextUtils.isEmpty(hVar.f280300c) && !TextUtils.isEmpty(hVar.f280301d) && !TextUtils.isEmpty(hVar.f280303f)) {
                Message obtain = Message.obtain();
                obtain.what = 2000;
                obtain.obj = hVar;
                BannerManager.l().G(DressUpBannerProcessor.f185209h, obtain);
            }
        }
    }
}
