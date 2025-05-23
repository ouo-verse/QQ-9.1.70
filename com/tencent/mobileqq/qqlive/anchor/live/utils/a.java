package com.tencent.mobileqq.qqlive.anchor.live.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.qqlive.business.QQLiveConfigConst;
import com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.timi.game.liveroom.impl.room.audience.event.RoomCloseEvent;
import com.tencent.timi.game.liveroom.impl.room.share.timishare.TgLiveShareParam;
import com.tencent.timi.game.liveroom.impl.room.share.timishare.TgShareParam;
import com.tencent.timi.game.liveroom.impl.room.share.timishare.TimiGameShareUtil;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final String f270721a;

    /* renamed from: b, reason: collision with root package name */
    private static IAegisLogApi f270722b;

    /* renamed from: c, reason: collision with root package name */
    private static WeakReference<ShareActionSheet> f270723c;

    /* renamed from: d, reason: collision with root package name */
    private static final SimpleEventReceiver f270724d;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqlive.anchor.live.utils.a$a, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    class C8350a implements SimpleEventReceiver {
        static IPatchRedirector $redirector_;

        C8350a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public ArrayList<Class> getEventClass() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            ArrayList<Class> arrayList = new ArrayList<>();
            arrayList.add(RoomCloseEvent.class);
            return arrayList;
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                a.e();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) simpleBaseEvent);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class b implements ShareActionSheet.OnItemClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f270725d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ConcurrentHashMap f270726e;

        b(View view, ConcurrentHashMap concurrentHashMap) {
            this.f270725d = view;
            this.f270726e = concurrentHashMap;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view, (Object) concurrentHashMap);
            }
        }

        @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
        public void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) actionSheetItem, (Object) shareActionSheet);
                return;
            }
            int i3 = actionSheetItem.action;
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 9) {
                        if (i3 != 10) {
                            if (i3 != 26 && i3 != 72 && i3 != 73) {
                                str = "";
                            }
                        } else {
                            str = "3";
                        }
                    } else {
                        str = "2";
                    }
                } else {
                    str = "1";
                }
                ((ug4.a) mm4.b.b(ug4.a.class)).reportEvent("imp_end", this.f270725d, this.f270726e);
                this.f270726e.put("qqlive_share_channel", str);
                ((ug4.a) mm4.b.b(ug4.a.class)).c(this.f270725d, false, null, "em_qqlive_share_panel", this.f270726e);
                ((ug4.a) mm4.b.b(ug4.a.class)).reportEvent("clck", this.f270725d, this.f270726e);
            }
            str = "0";
            ((ug4.a) mm4.b.b(ug4.a.class)).reportEvent("imp_end", this.f270725d, this.f270726e);
            this.f270726e.put("qqlive_share_channel", str);
            ((ug4.a) mm4.b.b(ug4.a.class)).c(this.f270725d, false, null, "em_qqlive_share_panel", this.f270726e);
            ((ug4.a) mm4.b.b(ug4.a.class)).reportEvent("clck", this.f270725d, this.f270726e);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class c implements DialogInterface.OnShowListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f270727d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ConcurrentHashMap f270728e;

        c(View view, ConcurrentHashMap concurrentHashMap) {
            this.f270727d = view;
            this.f270728e = concurrentHashMap;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view, (Object) concurrentHashMap);
            }
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            } else {
                ((ug4.a) mm4.b.b(ug4.a.class)).reportEvent("imp", this.f270727d, this.f270728e);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class d implements DialogInterface.OnCancelListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f270729d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ConcurrentHashMap f270730e;

        d(View view, ConcurrentHashMap concurrentHashMap) {
            this.f270729d = view;
            this.f270730e = concurrentHashMap;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view, (Object) concurrentHashMap);
            }
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                a.f270723c = null;
                a.i();
                ((ug4.a) mm4.b.b(ug4.a.class)).reportEvent("imp_end", this.f270729d, this.f270730e);
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class e implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f270731d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ConcurrentHashMap f270732e;

        e(View view, ConcurrentHashMap concurrentHashMap) {
            this.f270731d = view;
            this.f270732e = concurrentHashMap;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view, (Object) concurrentHashMap);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                a.f270723c = null;
                a.i();
                ((ug4.a) mm4.b.b(ug4.a.class)).reportEvent("imp_end", this.f270731d, this.f270732e);
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55264);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f270721a = QQLiveConfigConst.APP_ID;
        f270722b = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        f270724d = new C8350a();
    }

    public static TgShareParam d(long j3) {
        TgLiveShareParam tgLiveShareParam = new TgLiveShareParam();
        tgLiveShareParam.roomId = j3;
        String f16 = f();
        tgLiveShareParam.liveProductType = f16;
        tgLiveShareParam.roomType = "0";
        tgLiveShareParam.videoSource = QQLiveSDKConfigHelper.getQQLiveAppId();
        tgLiveShareParam.gameId = "0";
        tgLiveShareParam.gameTagId = "0";
        f270722b.i("AnchorLiveShareUtil", 1, "share live_p_type=" + tgLiveShareParam.liveProductType + ",support_p_type=" + f16);
        if (j3 > 0) {
            com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
            tgLiveShareParam.selfNick = cVar.g(j3, 1);
            tgLiveShareParam.anchorUid = cVar.k(j3, 1);
            tgLiveShareParam.anchorAvatarUrl = cVar.e(j3, 1);
            tgLiveShareParam.anchorNick = cVar.g(j3, 1);
            tgLiveShareParam.roomCoverUrl = cVar.n(j3, 1);
            tgLiveShareParam.roomTitle = cVar.B(j3, 1);
        }
        String str = tgLiveShareParam.anchorNick;
        String str2 = tgLiveShareParam.roomTitle;
        TgShareParam tgShareParam = new TgShareParam();
        tgShareParam.tgLiveShareParam = tgLiveShareParam;
        tgShareParam.showReport = false;
        tgShareParam.shareAppName = "QQ\u76f4\u64ad";
        tgShareParam.simpleTitle = str;
        tgShareParam.mainName = str2;
        tgShareParam.originSummary = tgLiveShareParam.getShareSummary();
        tgShareParam.singleSummaryOnly = tgLiveShareParam.getShareSingleOnlySummary();
        tgShareParam.coverImgUrl = tgLiveShareParam.roomCoverUrl;
        return tgShareParam;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e() {
        ShareActionSheet shareActionSheet;
        WeakReference<ShareActionSheet> weakReference = f270723c;
        if (weakReference != null && (shareActionSheet = weakReference.get()) != null) {
            shareActionSheet.dismiss();
        }
        i();
    }

    private static String f() {
        if (TextUtils.equals(f270721a, QQLiveSDKConfigHelper.getQQLiveAppId())) {
            return "1";
        }
        return "0";
    }

    public static void g(Context context, long j3) {
        String str;
        e();
        ConcurrentHashMap b16 = com.tencent.timi.game.liveroom.impl.room.more.d.b(j3, null);
        FrameLayout frameLayout = new FrameLayout(context);
        boolean J = com.tencent.mobileqq.qqlive.sail.c.f272176a.J(j3, 0);
        ug4.a aVar = (ug4.a) mm4.b.b(ug4.a.class);
        if (J) {
            str = IMultiAvChatReporter.PageId.ANCHOR_PAGE_ID;
        } else {
            str = IMultiAvChatReporter.PageId.AUDIENCE_PAGE_ID;
        }
        aVar.b(frameLayout, str, b16);
        View view = new View(context);
        frameLayout.addView(view);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("zengzhi_moduleid", "em_qqlive_share");
        ((ug4.a) mm4.b.b(ug4.a.class)).c(view, false, null, "em_qqlive_share_panel", concurrentHashMap);
        f270723c = new WeakReference<>(TimiGameShareUtil.j(context, d(j3), new b(view, concurrentHashMap), new c(view, concurrentHashMap), new d(view, concurrentHashMap), new e(view, concurrentHashMap)));
        h();
    }

    private static void h() {
        SimpleEventBus.getInstance().registerReceiver(f270724d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i() {
        SimpleEventBus.getInstance().unRegisterReceiver(f270724d);
    }
}
