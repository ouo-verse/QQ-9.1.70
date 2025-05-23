package com.qzone.reborn.albumx.qzonex.part.albumlist;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.qzone.app.QZoneFeedAlertService;
import com.qzone.common.account.LoginData;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.reborn.albumx.qzonex.part.albumlist.o;
import com.qzone.reborn.feedx.activity.QZoneFriendFeedXActivity;
import com.qzone.reborn.widget.QZoneAlbumAvatarLoopView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.UndealCount.QZoneCountInfo;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import cooperation.vip.pb.TianShuAccess;
import h4.a;
import java.util.HashMap;
import nc.bn;

/* compiled from: P */
/* loaded from: classes37.dex */
public class o extends com.qzone.reborn.base.k implements IObserver.main {

    /* renamed from: d, reason: collision with root package name */
    private bn f52973d;

    /* renamed from: e, reason: collision with root package name */
    View f52974e;

    /* renamed from: f, reason: collision with root package name */
    private View f52975f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f52976h;

    /* renamed from: m, reason: collision with root package name */
    private int f52978m;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f52977i = false;
    private TianShuGetAdvCallback C = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            LpReportInfo_pf00064.allReport(82, 6, 2);
            Intent intent = new Intent();
            intent.setClass(o.this.getActivity(), QZoneFriendFeedXActivity.class);
            intent.putExtra("qzone_uin", LoginData.getInstance().getUin());
            dh.a aVar = dh.a.f393805d;
            if (aVar.c()) {
                aVar.k(false);
                aVar.b();
                intent.putExtra("force_refresh", true);
            }
            QZoneHelper.forwardToQZoneFriendFeedActivity(o.this.getActivity(), intent, false);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ a.C10411a f52981d;

        c(a.C10411a c10411a) {
            this.f52981d = c10411a;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if ("1".equals(this.f52981d.f404274a)) {
                yo.d.d(this.f52981d.f404275b, view.getContext(), null);
                h4.a.c().g(102, this.f52981d);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private void F9() {
        h4.a.c().f(this.C);
    }

    private void G9() {
        this.f52975f = this.f52974e.findViewById(R.id.f162741kj1);
        this.f52976h = (TextView) this.f52974e.findViewById(R.id.nkv);
        this.f52975f.setBackgroundResource(R.drawable.g5i);
        this.f52977i = true;
        if (QZoneFeedAlertService.getInstance().getSingleUnReadItem(2) != null) {
            K9();
        } else {
            QZoneFeedAlertService.getInstance().ensureLoadUnread();
        }
    }

    private void H9() {
        View view = this.f52974e;
        if (view == null) {
            return;
        }
        VideoReport.setPageId(view, "pg_qz_space_album_list");
        HashMap hashMap = new HashMap();
        hashMap.put(IFileBrowserService.FILE_BROWSER_PAGE_FROM, 1);
        VideoReport.setPageParams(this.f52974e, new fo.a().d("QZAlbumxFeedsEntrancePart", hashMap));
    }

    private void I9() {
        HashMap hashMap = new HashMap();
        hashMap.put("entry_style", Integer.valueOf(this.f52978m));
        fo.c.o(this.f52974e, "em_qz_space_entry_column", new fo.b().l(hashMap));
    }

    private void K9() {
        String str;
        if (this.f52975f == null || this.f52976h == null) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.f52974e.findViewById(R.id.mqj);
        QZoneCountInfo singleUnReadItem = QZoneFeedAlertService.getInstance().getSingleUnReadItem(2);
        QLog.i("QZAlbumxFeedsEntrancePart", 1, "showQZoneEntranceView countInfo=" + singleUnReadItem);
        if (singleUnReadItem != null && singleUnReadItem.uCount > 0) {
            this.f52978m = 2;
            frameLayout.setVisibility(0);
            this.f52975f.setVisibility(8);
            QZoneAlbumAvatarLoopView qZoneAlbumAvatarLoopView = new QZoneAlbumAvatarLoopView(getActivity());
            frameLayout.removeAllViews();
            frameLayout.addView(qZoneAlbumAvatarLoopView);
            qZoneAlbumAvatarLoopView.setData(singleUnReadItem);
            if (singleUnReadItem.uCount > 99) {
                str = "99+";
            } else {
                str = singleUnReadItem.uCount + "";
            }
            this.f52976h.setText(String.format(com.qzone.reborn.configx.g.f53821a.b().A0(), str));
        } else {
            this.f52978m = 1;
            frameLayout.setVisibility(8);
            this.f52975f.setVisibility(0);
            this.f52976h.setText(com.qzone.reborn.configx.g.f53821a.b().B0());
        }
        I9();
    }

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        if ("UnRead".equals(event.source) && event.what == 1) {
            QLog.d("QZAlbumxFeedsEntrancePart", 1, "receive unread change event:" + this.f52973d.getIsNeedShowEntrance());
            if (this.f52977i) {
                K9();
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f52973d = (bn) getViewModel(bn.class);
        this.f52974e = getPartRootView().findViewById(R.id.mog);
        EventCenter.getInstance().addUIObserver(this, "UnRead", 1);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        EventCenter.getInstance().removeObserver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        F9();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements TianShuGetAdvCallback {
        a() {
        }

        @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
        public void onGetAdvs(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
            if (QZLog.isColorLevel()) {
                QZLog.i("QZAlbumxFeedsEntrancePart", "onGetAdvs isSucc:" + z16);
            }
            if (z16) {
                final a.C10411a b16 = h4.a.c().b(z16, getAdsRsp);
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.albumx.qzonex.part.albumlist.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        o.a.this.b(b16);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(a.C10411a c10411a) {
            if (c10411a != null) {
                o.this.J9(c10411a);
            } else if (o.this.f52973d.getIsNeedShowEntrance()) {
                o.this.L9();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J9(a.C10411a c10411a) {
        QZLog.d("QZAlbumxFeedsEntrancePart", 1, "initDragMgr... showAnnouncement:", "");
        View findViewById = this.f52974e.findViewById(R.id.f162741kj1);
        TextView textView = (TextView) this.f52974e.findViewById(R.id.nkv);
        findViewById.setBackgroundDrawable(URLDrawable.getDrawable(c10411a.f404276c));
        textView.setText(c10411a.f404277d);
        this.f52974e.setVisibility(0);
        this.f52974e.setOnClickListener(new c(c10411a));
        h4.a.c().g(101, c10411a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L9() {
        QZLog.d("QZAlbumxFeedsEntrancePart", 1, "initDragMgr... showQzoneEntrace:", Boolean.valueOf(this.f52973d.getIsNeedShowEntrance()));
        if (this.f52973d.getIsNeedShowEntrance()) {
            H9();
            G9();
            this.f52974e.setVisibility(0);
            this.f52974e.setOnClickListener(new b());
            return;
        }
        this.f52974e.setVisibility(8);
    }
}
