package com.tencent.mobileqq.qqlive.anchor.live.dialog;

import android.app.Activity;
import android.graphics.Point;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.AccompanyLibraryLoader;
import com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.PropPanelPopupWindow;
import com.tencent.mobileqq.qqlive.api.av.LiveMediaConfigManager;
import com.tencent.mobileqq.qqlive.api.av.ResolutionLevelType;
import com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter;
import com.tencent.mobileqq.qqlive.widget.resolution.ResolutionSettingDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.now.app.music.view.MusicAccompanyEntranceLayout;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.liveroom.impl.room.audienceoperationbar.event.AnchorInputClickEvent;
import com.tencent.timi.game.liveroom.impl.room.audienceoperationbar.event.DebugClickBusEvent;
import com.tencent.timi.game.liveroom.impl.room.more.AnchorRoomSettingFragment;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.HashMap;
import kl4.s;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* loaded from: classes17.dex */
public class AnchorLiveMorePopWindow implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private SimpleEventReceiver C;

    /* renamed from: d, reason: collision with root package name */
    private final com.tencent.mobileqq.qqlive.anchor.live.b f270632d;

    /* renamed from: e, reason: collision with root package name */
    private View f270633e;

    /* renamed from: f, reason: collision with root package name */
    private PopupWindow f270634f;

    /* renamed from: h, reason: collision with root package name */
    private final long f270635h;

    /* renamed from: i, reason: collision with root package name */
    private Activity f270636i;

    /* renamed from: m, reason: collision with root package name */
    private ResolutionSettingDialog f270637m;

    public AnchorLiveMorePopWindow(com.tencent.mobileqq.qqlive.anchor.live.b bVar, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, bVar, Long.valueOf(j3));
            return;
        }
        this.f270633e = null;
        this.f270634f = null;
        this.C = new SimpleEventReceiver<AccompanyLibraryLoader.AccompanyLibraryReadyEvent>() { // from class: com.tencent.mobileqq.qqlive.anchor.live.dialog.AnchorLiveMorePopWindow.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnchorLiveMorePopWindow.this);
                }
            }

            @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
            public ArrayList<Class<AccompanyLibraryLoader.AccompanyLibraryReadyEvent>> getEventClass() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    return (ArrayList) iPatchRedirector2.redirect((short) 3, (Object) this);
                }
                ArrayList<Class<AccompanyLibraryLoader.AccompanyLibraryReadyEvent>> arrayList = new ArrayList<>();
                arrayList.add(AccompanyLibraryLoader.AccompanyLibraryReadyEvent.class);
                return arrayList;
            }

            @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
            public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) simpleBaseEvent);
                } else if ((simpleBaseEvent instanceof AccompanyLibraryLoader.AccompanyLibraryReadyEvent) && AnchorLiveMorePopWindow.this.f270633e != null) {
                    AnchorLiveMorePopWindow.this.f270633e.post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.live.dialog.AnchorLiveMorePopWindow.1.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else {
                                AnchorLiveMorePopWindow.this.f270633e.findViewById(R.id.f59522sy).setVisibility(0);
                            }
                        }
                    });
                }
            }
        };
        this.f270632d = bVar;
        this.f270635h = j3;
    }

    private View f(Activity activity) {
        View inflate = View.inflate(activity, R.layout.h9b, null);
        inflate.findViewById(R.id.f59562t2).setOnClickListener(this);
        inflate.findViewById(R.id.f59542t0).setOnClickListener(this);
        inflate.findViewById(R.id.f59722th).setOnClickListener(this);
        inflate.findViewById(R.id.f59672tc).setOnClickListener(this);
        inflate.findViewById(R.id.f59522sy).setOnClickListener(this);
        inflate.findViewById(R.id.f59742tj).setOnClickListener(this);
        inflate.findViewById(R.id.f59622t8).setOnClickListener(this);
        inflate.findViewById(R.id.f59592t5).setOnClickListener(this);
        inflate.findViewById(R.id.f59582t4).setOnClickListener(this);
        inflate.findViewById(R.id.f59692te).setOnClickListener(this);
        inflate.findViewById(R.id.f59642t_).setOnClickListener(this);
        k(inflate);
        h(inflate);
        j(inflate);
        i(inflate);
        return inflate;
    }

    private void g(View view) {
        com.tencent.mobileqq.qqlive.anchor.live.b bVar = this.f270632d;
        if (bVar == null) {
            return;
        }
        boolean d16 = bVar.d();
        if (!d16) {
            this.f270632d.startAudioRecord();
            QQToast.makeText(view.getContext(), "\u9ea6\u514b\u98ce\u5df2\u5f00\u542f", 0).show();
        } else {
            this.f270632d.stopAudioRecord();
            QQToast.makeText(view.getContext(), "\u9ea6\u514b\u98ce\u5df2\u5173\u95ed", 0).show();
        }
        View findViewById = view.findViewById(R.id.f59682td);
        if (findViewById != null) {
            findViewById.setSelected(!d16);
        }
    }

    private void h(View view) {
        if (com.tencent.mobileqq.qqlive.a.b()) {
            view.findViewById(R.id.f59522sy).setVisibility(0);
        } else {
            view.findViewById(R.id.f59522sy).setVisibility(8);
            if (com.tencent.mobileqq.qqlive.a.a() && !AccompanyLibraryLoader.b()) {
                SimpleEventBus.getInstance().registerReceiver(this.C);
            }
        }
        ((MusicAccompanyEntranceLayout) view.findViewById(R.id.f59512sx)).b();
    }

    private void i(View view) {
        view.findViewById(R.id.f59592t5).setVisibility(8);
    }

    private void j(View view) {
        int i3;
        View findViewById = view.findViewById(R.id.f59622t8);
        if (com.tencent.mobileqq.qqlive.anchor.live.utils.c.f270735a.c()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        findViewById.setVisibility(i3);
        HashMap hashMap = new HashMap();
        hashMap.put("em_qqlive_guide_livestatus", "1");
        ((ug4.a) mm4.b.b(ug4.a.class)).a(findViewById, true, null, "em_qqlive_feedback", hashMap);
    }

    private void k(View view) {
        View findViewById = view.findViewById(R.id.f61502ya);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.anchor.live.dialog.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AnchorLiveMorePopWindow.this.m(view2);
            }
        });
        ((ug4.a) mm4.b.b(ug4.a.class)).a(findViewById, true, null, "em_qqlive_clarity", new HashMap());
        VideoReport.reportEvent("imp", findViewById, new HashMap());
    }

    private void l(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.f61712yv);
        boolean z16 = true;
        if (ht3.a.b("qqlive_enable_virtual_human", 1) != 1) {
            z16 = false;
        }
        if (!z16) {
            relativeLayout.setVisibility(8);
            return;
        }
        relativeLayout.setOnClickListener(this);
        ((ug4.a) mm4.b.b(ug4.a.class)).a(relativeLayout, true, null, "em_qqlive_avatar", new HashMap());
        VideoReport.reportEvent("imp", relativeLayout, new HashMap());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        s();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n() {
        SimpleEventBus.getInstance().unRegisterReceiver(this.C);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit o(ResolutionLevelType resolutionLevelType) {
        this.f270632d.e(resolutionLevelType);
        LiveMediaConfigManager liveMediaConfigManager = LiveMediaConfigManager.INSTANCE;
        liveMediaConfigManager.setResolutionLevelTypeCache(resolutionLevelType);
        QQToastUtil.showQQToast(0, String.format("\u5df2\u4e3a\u4f60\u5207\u6362\u81f3%s\u753b\u8d28", resolutionLevelType.getTerm()));
        tk4.a.a(liveMediaConfigManager.getLiveMediaConfig(0, resolutionLevelType).toTRTCVideoQualityParams(), QQLiveReportConstants.Event.E_ANCHOR_CHANGE_PUSH_ENCODE_PARAMS);
        HashMap hashMap = new HashMap();
        hashMap.put("qqlive_clarity_success", String.valueOf(resolutionLevelType.getCode()));
        ((ug4.a) mm4.b.b(ug4.a.class)).reportEvent("ev_qqlive_clarity_live", hashMap);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit p() {
        ResolutionSettingDialog resolutionSettingDialog = this.f270637m;
        if (resolutionSettingDialog != null) {
            resolutionSettingDialog.e();
            this.f270637m = null;
        }
        return null;
    }

    private void r(Activity activity, View view) {
        View decorView = activity.getWindow().getDecorView();
        activity.getWindowManager().getDefaultDisplay().getSize(new Point());
        if (this.f270634f == null) {
            PopupWindow popupWindow = new PopupWindow(view, -1, -2);
            this.f270634f = popupWindow;
            popupWindow.setFocusable(false);
            this.f270634f.setOutsideTouchable(true);
            this.f270634f.setSoftInputMode(16);
        }
        if (!this.f270634f.isShowing()) {
            this.f270634f.showAtLocation(decorView, 80, 0, 0);
        }
        t();
        this.f270634f.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.tencent.mobileqq.qqlive.anchor.live.dialog.a
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                AnchorLiveMorePopWindow.this.n();
            }
        });
    }

    private void s() {
        if (this.f270632d != null) {
            ResolutionSettingDialog resolutionSettingDialog = new ResolutionSettingDialog(this.f270632d.a(), new Function1() { // from class: com.tencent.mobileqq.qqlive.anchor.live.dialog.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit o16;
                    o16 = AnchorLiveMorePopWindow.this.o((ResolutionLevelType) obj);
                    return o16;
                }
            }, new Function0() { // from class: com.tencent.mobileqq.qqlive.anchor.live.dialog.d
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit p16;
                    p16 = AnchorLiveMorePopWindow.this.p();
                    return p16;
                }
            });
            this.f270637m = resolutionSettingDialog;
            resolutionSettingDialog.f();
        }
    }

    private void t() {
        boolean z16;
        VideoReport.addToDetectionWhitelist(this.f270636i);
        View contentView = this.f270634f.getContentView();
        ((ug4.a) mm4.b.b(ug4.a.class)).b(contentView, IMultiAvChatReporter.PageId.ANCHOR_PAGE_ID, com.tencent.timi.game.liveroom.impl.room.more.d.a(this.f270635h));
        View findViewById = contentView.findViewById(R.id.f59582t4);
        ((ug4.a) mm4.b.b(ug4.a.class)).a(findViewById, true, null, "em_qqlive_comment", new HashMap());
        ((ug4.a) mm4.b.b(ug4.a.class)).reportEvent("imp", findViewById, new HashMap());
        com.tencent.mobileqq.qqlive.anchor.live.b bVar = this.f270632d;
        if (bVar != null && bVar.d()) {
            z16 = true;
        } else {
            z16 = false;
        }
        View findViewById2 = contentView.findViewById(R.id.f59682td);
        findViewById2.setSelected(z16);
        ((ug4.a) mm4.b.b(ug4.a.class)).a(findViewById2, true, null, "em_qqlive_microphone_switch", new HashMap());
        ((ug4.a) mm4.b.b(ug4.a.class)).reportEvent("imp", findViewById2, new HashMap());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        } else {
            if (view.getId() == R.id.f59562t2) {
                this.f270632d.switchCamera();
            } else if (view.getId() == R.id.f59542t0) {
                this.f270632d.b();
            } else if (view.getId() == R.id.f59672tc) {
                s.k(this.f270635h);
            } else if (view.getId() == R.id.f59722th) {
                AnchorRoomSettingFragment.rh(view.getContext(), this.f270635h);
            } else if (view.getId() == R.id.f59522sy) {
                ((MusicAccompanyEntranceLayout) view.findViewById(R.id.f59512sx)).a(view);
            } else if (view.getId() == R.id.f59742tj) {
                s.INSTANCE.d(true, Long.valueOf(this.f270635h), Long.valueOf(com.tencent.mobileqq.qqlive.sail.c.f272176a.G()));
            } else if (view.getId() == R.id.f59622t8) {
                com.tencent.mobileqq.qqlive.anchor.live.utils.c.f270735a.e(view.getContext());
            } else if (view.getId() == R.id.f59592t5) {
                SimpleEventBus.getInstance().dispatchEvent(new DebugClickBusEvent());
            } else if (view.getId() == R.id.f59582t4) {
                SimpleEventBus.getInstance().dispatchEvent(new AnchorInputClickEvent());
                ((ug4.a) mm4.b.b(ug4.a.class)).reportEvent("clck", view, new HashMap());
            } else if (view.getId() == R.id.f59692te) {
                g(view);
                ((ug4.a) mm4.b.b(ug4.a.class)).reportEvent("clck", view, new HashMap());
            } else if (view.getId() == R.id.f61712yv) {
                com.tencent.mobileqq.qqlive.anchor.live.b bVar = this.f270632d;
                if (bVar != null) {
                    bVar.c(PropPanelPopupWindow.t());
                }
            } else if (view.getId() == R.id.f59642t_) {
                mj4.a.INSTANCE.a(view.getContext());
            }
            this.f270634f.dismiss();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void q(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
            return;
        }
        this.f270636i = activity;
        View view = this.f270633e;
        if (view == null) {
            this.f270633e = f(activity);
        } else {
            h(view);
        }
        l(this.f270633e);
        r(activity, this.f270633e);
    }
}
