package com.tencent.mobileqq.activity.recent.gamemsgbox;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.biz.richframework.part.Part;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.gamemsgbox.GameMsgBoxFragment;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxRuntimeService;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.gamecenter.api.IGameMsgCardApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.api.IGameReportApi;
import com.tencent.mobileqq.gamecenter.msginfo.GameSwitchConfig;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameMsgMgrSvr$GameDetail;
import com.tencent.mobileqq.gamecenter.trpcprotocol.SgamePartnerSvr$GetGameMsgPartnersRsp;
import com.tencent.mobileqq.icgame.api.impl.RoomServiceConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.AbsSlidingIndicator;
import com.tencent.mobileqq.widget.SimpleSlidingIndicator;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.utils.NTMsgUtil;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.IGetContactsCallback;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes10.dex */
public class GameMsgBoxFragment extends IphoneTitleBarFragment {
    static IPatchRedirector $redirector_;
    protected BaseActivity C;
    private QQAppInterface D;
    private af E;
    private DragFrameLayout F;
    private NTChatRecyclerViewWithHeaderFooter G;
    private SimpleSlidingIndicator H;
    private DragFrameLayout I;
    private TextView J;
    private View K;
    private String L;
    private boolean M;
    private GameMsgBoxOpenSyncView N;
    private GameSwitchConfig P;
    private GameMsgBoxBannerManager Q;
    private com.tencent.mobileqq.gamecenter.api.e R;
    private ie1.b S;
    private k71.a T;
    private IGameMsgManagerService.a U;
    private com.tencent.mobileqq.gamecenter.api.f V;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.recent.gamemsgbox.GameMsgBoxFragment$10 */
    /* loaded from: classes10.dex */
    public class AnonymousClass10 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d */
        final /* synthetic */ String[] f185414d;

        /* renamed from: e */
        final /* synthetic */ int[] f185415e;

        /* renamed from: f */
        final /* synthetic */ boolean[] f185416f;

        /* renamed from: h */
        final /* synthetic */ List f185417h;

        AnonymousClass10(String[] strArr, int[] iArr, boolean[] zArr, List list) {
            this.f185414d = strArr;
            this.f185415e = iArr;
            this.f185416f = zArr;
            this.f185417h = list;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, GameMsgBoxFragment.this, strArr, iArr, zArr, list);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            GameMsgBoxFragment.this.H.setTabData(this.f185414d, this.f185415e);
            int i3 = 0;
            while (true) {
                String[] strArr = this.f185414d;
                if (i3 >= strArr.length) {
                    break;
                }
                if (strArr[i3].equals(GameMsgBoxFragment.this.L)) {
                    if (i3 == 0) {
                        GameMsgBoxFragment.this.H.setCurrentPosition(0, true);
                        GameMsgBoxFragment.this.H.smoothScrollTo(0, GameMsgBoxFragment.this.H.getScrollY());
                        GameMsgBoxFragment.this.li(0);
                    } else {
                        GameMsgBoxFragment.this.H.setCurrentPosition(i3, GameMsgBoxFragment.this.M);
                        GameMsgBoxFragment.this.li(i3);
                    }
                } else {
                    if (i3 == this.f185414d.length - 1) {
                        GameMsgBoxFragment.this.H.setCurrentPosition(0, true);
                        GameMsgBoxFragment.this.li(0);
                    }
                    i3++;
                }
            }
            int i16 = 0;
            while (true) {
                boolean[] zArr = this.f185416f;
                if (i16 >= zArr.length) {
                    break;
                }
                if (zArr[i16]) {
                    GameMsgBoxFragment.this.H.u(i16 + 2);
                }
                i16++;
            }
            com.tencent.relation.common.config.toggle.c cVar = com.tencent.relation.common.config.toggle.c.f364690c;
            if ((cVar.g(false) && "1".equals(cVar.d("is_show_tab", ""))) || this.f185417h.size() > 1) {
                ((IphoneTitleBarFragment) GameMsgBoxFragment.this).mContentView.findViewById(R.id.vjl).setVisibility(0);
            } else {
                ((IphoneTitleBarFragment) GameMsgBoxFragment.this).mContentView.findViewById(R.id.vjl).setVisibility(8);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.recent.gamemsgbox.GameMsgBoxFragment$11 */
    /* loaded from: classes10.dex */
    public class AnonymousClass11 implements Runnable {
        static IPatchRedirector $redirector_;

        AnonymousClass11() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GameMsgBoxFragment.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else if (GameMsgBoxFragment.this.I != null && GameMsgBoxFragment.this.I.getMode() == -1) {
                GameMsgBoxFragment.this.ji();
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.recent.gamemsgbox.GameMsgBoxFragment$5 */
    /* loaded from: classes10.dex */
    public class AnonymousClass5 implements Runnable {
        static IPatchRedirector $redirector_;

        AnonymousClass5() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GameMsgBoxFragment.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                try {
                    GameMsgBoxFragment.this.di();
                    return;
                } catch (Exception e16) {
                    QLog.e("GameMsgBoxFragment", 1, "refresh msg list err! ", e16);
                    return;
                }
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements com.tencent.mobileqq.widget.navbar.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GameMsgBoxFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.navbar.a
        public void onItemSelect(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            if (i3 == 5) {
                ((IphoneTitleBarFragment) GameMsgBoxFragment.this).f211156vg.updateRedDot(5, false);
                com.tencent.mobileqq.utils.p.g(GameMsgBoxFragment.this.D.getApp(), GameMsgBoxFragment.this.D.getCurrentAccountUin(), true, AppConstants.Preferences.KEY_GAME_MSG_BOX_SETTING_RED_DOT, Boolean.FALSE);
                List<GameMsgMgrSvr$GameDetail> gameListOfMsgBox = ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).getGameListOfMsgBox();
                if (gameListOfMsgBox != null && gameListOfMsgBox.size() > 0) {
                    Intent intent = new Intent();
                    intent.putExtra("hashCode", GameMsgBoxFragment.this.hashCode());
                    QPublicFragmentActivity.b.b(GameMsgBoxFragment.this.getContext(), intent, QPublicFragmentActivity.class, GameMsgBoxSettingFragment.class);
                    return;
                }
                ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).openGameMsgSettingPage(GameMsgBoxFragment.this.getContext(), "GameMsgBoxFragment");
                return;
            }
            if (i3 == 4) {
                ((IQQGameHippyApi) QRoute.api(IQQGameHippyApi.class)).openQQGameCenterByHippy(GameMsgBoxFragment.this.C, "https://speed.gamecenter.qq.com/pushgame/v1/home/index?ADTAG=messagebox&_wv=18950115&_wwv=393?max_age=31536000", "messagebox");
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("ext4", "20");
                ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg("", "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92048", "915380", "", hashMap);
                return;
            }
            if (i3 == 1) {
                GameMsgBoxFragment.this.onBackEvent();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b implements com.tencent.mobileqq.gamecenter.api.f {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GameMsgBoxFragment.this);
            }
        }

        public /* synthetic */ void b(SgamePartnerSvr$GetGameMsgPartnersRsp sgamePartnerSvr$GetGameMsgPartnersRsp) {
            GameMsgBoxFragment.this.ii(sgamePartnerSvr$GetGameMsgPartnersRsp);
        }

        @Override // com.tencent.mobileqq.gamecenter.api.f
        public void onGameCardRemoved() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                GameMsgBoxFragment.this.E.E9(null);
            }
        }

        @Override // com.tencent.mobileqq.gamecenter.api.f
        public void onGetGameCardInfo(final SgamePartnerSvr$GetGameMsgPartnersRsp sgamePartnerSvr$GetGameMsgPartnersRsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) sgamePartnerSvr$GetGameMsgPartnersRsp);
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.recent.gamemsgbox.ad
                    @Override // java.lang.Runnable
                    public final void run() {
                        GameMsgBoxFragment.b.this.b(sgamePartnerSvr$GetGameMsgPartnersRsp);
                    }
                });
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class c extends ie1.b {
        static IPatchRedirector $redirector_;

        c(int i3) {
            super(i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GameMsgBoxFragment.this, i3);
            }
        }

        @Override // ie1.b
        public void d(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, obj);
                return;
            }
            super.d(obj);
            QLog.i("GameCenterMsg.GameCenterUnissoObserver", 1, " game usr info change notify.");
            GameMsgBoxFragment.this.ci();
        }

        @Override // ie1.b
        public void t() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("GameCenterMsg.GameCenterUnissoObserver", 2, " onSetSwitchCallback ");
            }
            GameMsgBoxFragment.this.ci();
            GameMsgBoxFragment.this.ji();
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class d implements k71.a {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GameMsgBoxFragment.this);
            }
        }

        @Override // k71.a
        public void onLoadFailed() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // k71.a
        public void onLoadSuccess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else if (GameMsgBoxFragment.this.isAdded()) {
                GameMsgBoxFragment.this.ci();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class e implements IGetContactsCallback {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GameMsgBoxFragment.this);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGetContactsCallback
        public void onResult(int i3, String str, ArrayList<RecentContactInfo> arrayList, ArrayList<Contact> arrayList2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, arrayList, arrayList2);
                return;
            }
            QLog.i("GameMsgBoxFragment", 1, "size:" + arrayList.size());
            Iterator<RecentContactInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                NTMsgUtil.f352264a.i(116, it.next().peerUid);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class f implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d */
        final /* synthetic */ TipsBar f185423d;

        f(TipsBar tipsBar) {
            this.f185423d = tipsBar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GameMsgBoxFragment.this, (Object) tipsBar);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ((ViewGroup) ((IphoneTitleBarFragment) GameMsgBoxFragment.this).mContentView).removeView(this.f185423d);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class g implements AbsSlidingIndicator.f {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GameMsgBoxFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.AbsSlidingIndicator.f
        public int I0(int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                GameMsgBoxFragment.this.bi(i3, z16);
                return 0;
            }
            return ((Integer) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16))).intValue();
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class h implements com.tencent.mobileqq.activity.contacts.base.tabs.e {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GameMsgBoxFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.activity.contacts.base.tabs.e
        public void d(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("GameMsgBoxFragment", 2, "onInterceptEvent, toIntercept=" + z16 + ", ScrollX=" + GameMsgBoxFragment.this.H.getScrollX());
            }
            GameMsgBoxFragment.this.Oh();
            int i3 = 0;
            if (GameMsgBoxFragment.this.H.getScrollX() <= 0 && GameMsgBoxFragment.this.H.getChildAt(0).getVisibility() != 4) {
                i3 = 8;
            }
            GameMsgBoxFragment.this.K.setVisibility(i3);
            GameMsgBoxFragment.this.J.setVisibility(i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class i implements AbsSlidingIndicator.d {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GameMsgBoxFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.AbsSlidingIndicator.d
        public void a(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            if (i3 >= 2) {
                VideoReport.setPageId(GameMsgBoxFragment.this.H, "pg_gb_message");
                VideoReport.setElementId(view, "em_gb_label");
                try {
                    VideoReport.setElementParam(view, RoomServiceConstants.PARAMS_GAME_ID, ((IGameMsgBoxManager) GameMsgBoxFragment.this.D.getRuntimeService(IGameMsgBoxManager.class, "")).getTitles().get(i3 - 2).f185507d.f401939c);
                } catch (Exception e16) {
                    QLog.e("GameMsgBoxFragment", 1, "[onAddTab] error", e16);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class j implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GameMsgBoxFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("GameMsgBoxFragment", 2, "mAllIndicatorTv onClick");
                }
                QLog.e("Mydicator", 1, "setCurrentPositionFromUserClick");
                GameMsgBoxFragment.this.H.setCurrentPositionFromUserClick(0, true);
                GameMsgBoxFragment.this.H.smoothScrollTo(0, GameMsgBoxFragment.this.H.getScrollY());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public GameMsgBoxFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.M = true;
        this.S = new c(hashCode());
        this.T = new d();
        this.U = new IGameMsgManagerService.a() { // from class: com.tencent.mobileqq.activity.recent.gamemsgbox.y
            @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService.a
            public final void a(List list) {
                GameMsgBoxFragment.this.Yh(list);
            }
        };
        this.V = new b();
    }

    public void Oh() {
        int i3;
        String str;
        int i16 = 0;
        if (this.H.j() == 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (ThemeUtil.isNowThemeIsNight(this.D, false, null)) {
            this.J.setTextColor(-1);
            TextView textView = this.J;
            if (i3 != 0) {
                i16 = R.drawable.kqr;
            }
            textView.setBackgroundResource(i16);
        } else {
            TextView textView2 = this.J;
            if (i3 != 0) {
                i16 = R.drawable.kqs;
            }
            textView2.setBackgroundResource(i16);
            if (i3 != 0) {
                str = "#00CAFC";
            } else {
                str = "#878B99";
            }
            this.J.setTextColor(Color.parseColor(str));
        }
        this.J.setTypeface(Typeface.defaultFromStyle(i3));
    }

    private String Ph(com.tencent.mobileqq.activity.recent.gamemsgbox.data.b bVar) {
        gd1.a aVar;
        String str;
        if (bVar == null || (aVar = bVar.f185507d) == null || (str = aVar.f401939c) == null) {
            return "";
        }
        return str;
    }

    private int Qh() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return 0;
        }
        int i3 = arguments.getInt("tab_index", 0);
        if (i3 != 0 && i3 != 1) {
            return 0;
        }
        return i3;
    }

    private void Rh() {
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(((IphoneTitleBarFragment) this).mContentView, "pg_gb_message");
    }

    private void Sh() {
        SimpleSlidingIndicator simpleSlidingIndicator = (SimpleSlidingIndicator) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.vjk);
        this.H = simpleSlidingIndicator;
        simpleSlidingIndicator.setItemContentPaddingLR(Utils.n(14.0f, this.C.getResources()));
        ei();
        this.K = ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.vji);
        this.J = (TextView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.vjg);
        if (ThemeUtil.isNowThemeIsNight(this.D, false, null)) {
            this.K.setBackgroundResource(R.drawable.nee);
            this.J.setTextColor(getResources().getColor(R.color.qui_common_text_secondary));
        } else {
            this.K.setBackgroundResource(R.drawable.ned);
            this.J.setTextColor(getResources().getColor(R.color.cdn));
        }
        this.H.setOnTabListener(new g());
        this.H.setInterceptListener(new h());
        this.H.setOnAddTabListener(new i());
        this.J.setOnClickListener(new j());
    }

    private void Th() {
        if (QLog.isColorLevel()) {
            QLog.e("GameMsgBoxFragment", 2, "initListView");
        }
        DragFrameLayout dragFrameLayout = (DragFrameLayout) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.evx);
        this.F = dragFrameLayout;
        dragFrameLayout.setVisibility(0);
        this.G = (NTChatRecyclerViewWithHeaderFooter) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.tug);
        View f16 = this.Q.f();
        if (f16 != null) {
            this.G.D(f16);
        }
        this.G.D(this.R.getRootView());
        this.G.C(View.inflate(this.C, R.layout.f167783hc, null));
        VideoReport.setElementId(this.F, "em_gb_message_list");
        if (this.I == null) {
            this.I = DragFrameLayout.e(this.C);
        }
    }

    private void Uh(final String str) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.recent.gamemsgbox.ab
            @Override // java.lang.Runnable
            public final void run() {
                GameMsgBoxFragment.this.Xh(str);
            }
        }, 16, null, true);
    }

    private void Vh() {
        IGameMsgBoxManager iGameMsgBoxManager = (IGameMsgBoxManager) this.D.getRuntimeService(IGameMsgBoxManager.class);
        if (iGameMsgBoxManager.isShowGameBoxTips()) {
            TipsBar tipsBar = new TipsBar(this.C);
            tipsBar.setTipsIcon(this.C.getResources().getDrawable(R.drawable.common_banner_tips_notice));
            tipsBar.setTipsText(HardCodeUtil.qqStr(R.string.f199324p4));
            tipsBar.setBarType(1);
            tipsBar.z(true);
            tipsBar.setCloseListener(new f(tipsBar));
            tipsBar.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            ((ViewGroup) ((IphoneTitleBarFragment) this).mContentView).addView(tipsBar, 0);
            iGameMsgBoxManager.updateShowGameBoxTips(false);
        }
    }

    public /* synthetic */ void Wh(String str, gd1.a aVar) {
        ViewStub viewStub = (ViewStub) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f116526yz);
        this.F.setVisibility(8);
        if (this.N == null) {
            this.N = (GameMsgBoxOpenSyncView) viewStub.inflate();
        }
        this.N.setVisibility(0);
        this.N.setGameOpenSyncMsg(str, hashCode(), aVar, 0, ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).getRecentGameMsgDrawable(this.D, aVar.f401938b));
    }

    public /* synthetic */ void Xh(final String str) {
        List<RecentContactInfo> M;
        String str2;
        QQAppInterface qQAppInterface = this.D;
        if (qQAppInterface == null) {
            return;
        }
        GameSwitchConfig findGameSwitchConfig = ((IGameMsgManagerService) qQAppInterface.getRuntimeService(IGameMsgManagerService.class, "")).findGameSwitchConfig(str);
        this.P = findGameSwitchConfig;
        if (findGameSwitchConfig == null) {
            QLog.e("GameMsgBoxFragment", 2, "initOpenSyncView switchConfig is null.");
            return;
        }
        if (findGameSwitchConfig.mSyncSwitch == 1 && findGameSwitchConfig.mBlockSwitch == 0) {
            ThreadManagerV2.getUIHandlerV2().post(new aa(this));
            return;
        }
        com.tencent.qqnt.kernel.api.aa recentContactService = ((IKernelService) this.D.getRuntimeService(IKernelService.class, "all")).getRecentContactService();
        if (recentContactService == null || (M = recentContactService.M(4)) == null) {
            return;
        }
        Iterator<RecentContactInfo> it = M.iterator();
        final gd1.a aVar = null;
        while (it.hasNext()) {
            aVar = ((IGameMsgBoxManager) this.D.getRuntimeService(IGameMsgBoxManager.class, "")).findGameDetailInfoByConvertUin(n.a(it.next().getPeerUid()));
            if (aVar != null && (str2 = aVar.f401939c) != null && str2.equals(str)) {
                break;
            }
        }
        if (aVar == null) {
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.recent.gamemsgbox.ac
            @Override // java.lang.Runnable
            public final void run() {
                GameMsgBoxFragment.this.Wh(str, aVar);
            }
        });
    }

    public /* synthetic */ void Yh(List list) {
        if (!isDetached() && this.H.j() == 1) {
            ci();
        }
    }

    public /* synthetic */ void Zh() {
        try {
            if (!ki()) {
                this.C.runOnUiThread(new aa(this));
            }
        } catch (Throwable th5) {
            QLog.e("GameMsgBoxFragment", 1, "[showContentInTabAll], th:", th5);
        }
    }

    private void ai() {
        this.L = this.C.getString(R.string.f199404pb);
        com.tencent.mobileqq.activity.recent.gamemsgbox.e.f185509a.b("partner");
        this.R.a("partner");
        this.E.B9();
    }

    public void bi(int i3, boolean z16) {
        if (z16) {
            li(i3);
            ((IGameReportApi) QRoute.api(IGameReportApi.class)).clearLastReportGamePartnerData();
            if (i3 == 1) {
                ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg("", "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92053", "989344", "", "", "7", "");
            }
        }
        Oh();
        if (this.H.j() == 0) {
            this.K.setVisibility(8);
            this.J.setVisibility(8);
        }
    }

    public void ci() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.recent.gamemsgbox.GameMsgBoxFragment.5
            static IPatchRedirector $redirector_;

            AnonymousClass5() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) GameMsgBoxFragment.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    try {
                        GameMsgBoxFragment.this.di();
                        return;
                    } catch (Exception e16) {
                        QLog.e("GameMsgBoxFragment", 1, "refresh msg list err! ", e16);
                        return;
                    }
                }
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }, 16, null, false);
    }

    public void di() {
        IGameMsgBoxManager iGameMsgBoxManager = (IGameMsgBoxManager) this.D.getRuntimeService(IGameMsgBoxManager.class);
        List<com.tencent.mobileqq.activity.recent.gamemsgbox.data.b> titles = iGameMsgBoxManager.getTitles();
        int size = titles.size() + 2;
        String[] strArr = new String[size];
        strArr[0] = this.C.getString(R.string.f199284p0);
        strArr[1] = this.C.getString(R.string.f199404pb);
        boolean[] zArr = new boolean[titles.size()];
        for (int i3 = 0; i3 < titles.size(); i3++) {
            com.tencent.mobileqq.activity.recent.gamemsgbox.data.b bVar = titles.get(i3);
            gd1.a aVar = bVar.f185507d;
            GameSwitchConfig gameSwitchConfig = bVar.f185508e;
            strArr[i3 + 2] = aVar.f401947k;
            zArr[i3] = iGameMsgBoxManager.shouldShowRedPoint(gameSwitchConfig);
        }
        this.C.runOnUiThread(new Runnable(strArr, new int[size], zArr, titles) { // from class: com.tencent.mobileqq.activity.recent.gamemsgbox.GameMsgBoxFragment.10
            static IPatchRedirector $redirector_;

            /* renamed from: d */
            final /* synthetic */ String[] f185414d;

            /* renamed from: e */
            final /* synthetic */ int[] f185415e;

            /* renamed from: f */
            final /* synthetic */ boolean[] f185416f;

            /* renamed from: h */
            final /* synthetic */ List f185417h;

            AnonymousClass10(String[] strArr2, int[] iArr, boolean[] zArr2, List titles2) {
                this.f185414d = strArr2;
                this.f185415e = iArr;
                this.f185416f = zArr2;
                this.f185417h = titles2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, GameMsgBoxFragment.this, strArr2, iArr, zArr2, titles2);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                GameMsgBoxFragment.this.H.setTabData(this.f185414d, this.f185415e);
                int i36 = 0;
                while (true) {
                    String[] strArr2 = this.f185414d;
                    if (i36 >= strArr2.length) {
                        break;
                    }
                    if (strArr2[i36].equals(GameMsgBoxFragment.this.L)) {
                        if (i36 == 0) {
                            GameMsgBoxFragment.this.H.setCurrentPosition(0, true);
                            GameMsgBoxFragment.this.H.smoothScrollTo(0, GameMsgBoxFragment.this.H.getScrollY());
                            GameMsgBoxFragment.this.li(0);
                        } else {
                            GameMsgBoxFragment.this.H.setCurrentPosition(i36, GameMsgBoxFragment.this.M);
                            GameMsgBoxFragment.this.li(i36);
                        }
                    } else {
                        if (i36 == this.f185414d.length - 1) {
                            GameMsgBoxFragment.this.H.setCurrentPosition(0, true);
                            GameMsgBoxFragment.this.li(0);
                        }
                        i36++;
                    }
                }
                int i16 = 0;
                while (true) {
                    boolean[] zArr2 = this.f185416f;
                    if (i16 >= zArr2.length) {
                        break;
                    }
                    if (zArr2[i16]) {
                        GameMsgBoxFragment.this.H.u(i16 + 2);
                    }
                    i16++;
                }
                com.tencent.relation.common.config.toggle.c cVar = com.tencent.relation.common.config.toggle.c.f364690c;
                if ((cVar.g(false) && "1".equals(cVar.d("is_show_tab", ""))) || this.f185417h.size() > 1) {
                    ((IphoneTitleBarFragment) GameMsgBoxFragment.this).mContentView.findViewById(R.id.vjl).setVisibility(0);
                } else {
                    ((IphoneTitleBarFragment) GameMsgBoxFragment.this).mContentView.findViewById(R.id.vjl).setVisibility(8);
                }
            }
        });
    }

    private void ei() {
        int i3;
        int i16;
        int i17;
        boolean isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(this.D, false, null);
        boolean isNowSimpleUI = QQTheme.isNowSimpleUI();
        int i18 = R.color.skin_gray2_theme_version2;
        if (isNowSimpleUI) {
            if (isNowThemeIsNight) {
                i16 = R.color.a2m;
            } else {
                i16 = R.color.a2l;
            }
            i17 = R.color.skin_black_theme_version2;
            i3 = 255;
        } else if (isNowThemeIsNight) {
            i18 = R.color.f158017al3;
            i16 = R.color.bjw;
            i3 = 76;
            i17 = R.color.f158017al3;
        } else {
            i3 = 25;
            if (!ThemeUtil.isNowThemeIsDefaultCache(this.D, true)) {
                i16 = R.color.skin_blue;
            } else {
                i16 = R.color.f157007hd;
            }
            i17 = i16;
        }
        this.H.o(i3);
        this.H.p(i17, i18, i16);
    }

    private void fi(List<com.tencent.mobileqq.activity.recent.gamemsgbox.data.b> list) {
        if (list != null && list.size() != 0) {
            this.L = this.C.getString(R.string.f199284p0);
            ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg("", "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92045", "209203", "", "", "8", "");
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.recent.gamemsgbox.z
                @Override // java.lang.Runnable
                public final void run() {
                    GameMsgBoxFragment.this.Zh();
                }
            }, 16, null, false);
        }
    }

    @NotNull
    private com.tencent.mobileqq.activity.recent.gamemsgbox.data.b gi(int i3, IGameMsgBoxManager iGameMsgBoxManager, List<com.tencent.mobileqq.activity.recent.gamemsgbox.data.b> list) {
        com.tencent.mobileqq.activity.recent.gamemsgbox.data.b bVar = list.get(i3 - 2);
        GameSwitchConfig findGameSwitchConfig = ((IGameMsgManagerService) this.D.getRuntimeService(IGameMsgManagerService.class, "")).findGameSwitchConfig(bVar.f185507d.f401939c);
        if (findGameSwitchConfig != null && findGameSwitchConfig.mSyncSwitch == 1) {
            this.C.runOnUiThread(new aa(this));
        } else {
            iGameMsgBoxManager.updateRedPointShowState(false, bVar.f185507d.f401939c);
            this.H.e(i3);
            Uh(bVar.f185507d.f401939c);
        }
        return bVar;
    }

    private boolean hi(List<com.tencent.mobileqq.activity.recent.gamemsgbox.data.b> list) {
        if (list != null && !list.isEmpty()) {
            return false;
        }
        String string = this.C.getResources().getString(R.string.f1373606n);
        IGameMsgManagerService iGameMsgManagerService = (IGameMsgManagerService) this.D.getRuntimeService(IGameMsgManagerService.class, "");
        if (iGameMsgManagerService.findGameSwitchConfig(string) != null && iGameMsgManagerService.isGameMsgSync(string) && !iGameMsgManagerService.isGameMsgBlocked(string)) {
            this.C.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.recent.gamemsgbox.GameMsgBoxFragment.11
                static IPatchRedirector $redirector_;

                AnonymousClass11() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) GameMsgBoxFragment.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else if (GameMsgBoxFragment.this.I != null && GameMsgBoxFragment.this.I.getMode() == -1) {
                        GameMsgBoxFragment.this.ji();
                    }
                }
            });
            return true;
        }
        Uh(this.C.getResources().getString(R.string.f1373606n));
        return true;
    }

    public void ii(SgamePartnerSvr$GetGameMsgPartnersRsp sgamePartnerSvr$GetGameMsgPartnersRsp) {
        if (sgamePartnerSvr$GetGameMsgPartnersRsp instanceof SgamePartnerSvr$GetGameMsgPartnersRsp) {
            this.E.E9(((IGameMsgCardApi) QRoute.api(IGameMsgCardApi.class)).createGameCardView(getContext(), sgamePartnerSvr$GetGameMsgPartnersRsp));
        }
    }

    private void initTabIndex() {
        if (Qh() != 1) {
            this.L = this.C.getString(R.string.f199284p0);
            this.M = true;
        } else {
            this.L = this.C.getString(R.string.f199404pb);
            this.M = false;
            ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg("", "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92053", "989344", "", "", "7", "");
        }
    }

    private void initTitleBar() {
        setTitle(this.C.getString(R.string.f199374p9));
        if (QQTheme.isNowSimpleUI()) {
            this.f211156vg.setRightImage(ResourcesCompat.getDrawable(getResources(), R.drawable.qui_chat_settings, null));
            this.f211156vg.setRightImage2(ResourcesCompat.getDrawable(getResources(), R.drawable.qui_game, null));
        } else {
            this.f211156vg.setRightImage(ResourcesCompat.getDrawable(getResources(), R.drawable.qui_chat_settings_icon_navigation_01, null));
            this.f211156vg.setRightImage2(ResourcesCompat.getDrawable(getResources(), R.drawable.qui_game_icon_nav_secondary, null));
        }
        this.f211156vg.setOnItemSelectListener(new a());
        boolean booleanValue = ((Boolean) com.tencent.mobileqq.utils.p.b(this.D.getApp(), this.D.getCurrentAccountUin(), AppConstants.Preferences.KEY_GAME_MSG_BOX_SETTING_RED_DOT, Boolean.TRUE)).booleanValue();
        this.f211156vg.updateRedDot(5, booleanValue);
        QLog.d("GameMsgBoxFragment", 1, "initTitleBar showRedDot = " + booleanValue);
    }

    public void ji() {
        GameMsgBoxOpenSyncView gameMsgBoxOpenSyncView = this.N;
        if (gameMsgBoxOpenSyncView != null) {
            gameMsgBoxOpenSyncView.setVisibility(8);
        }
        DragFrameLayout dragFrameLayout = this.F;
        if (dragFrameLayout != null) {
            dragFrameLayout.setVisibility(0);
        }
    }

    private boolean ki() {
        com.tencent.qqnt.kernel.api.aa recentContactService;
        List<RecentContactInfo> M;
        GameSwitchConfig findGameSwitchConfig;
        QQAppInterface qQAppInterface = this.D;
        if (qQAppInterface == null || (recentContactService = ((IKernelService) qQAppInterface.getRuntimeService(IKernelService.class, "all")).getRecentContactService()) == null || (M = recentContactService.M(4)) == null) {
            return false;
        }
        IGameMsgManagerService iGameMsgManagerService = (IGameMsgManagerService) this.D.getRuntimeService(IGameMsgManagerService.class, "");
        Iterator<RecentContactInfo> it = M.iterator();
        while (it.hasNext()) {
            gd1.a findGameDetailInfoByConvertUin = ((IGameMsgBoxManager) this.D.getRuntimeService(IGameMsgBoxManager.class, "")).findGameDetailInfoByConvertUin(n.a(it.next().getPeerUid()));
            if (findGameDetailInfoByConvertUin != null && (findGameSwitchConfig = iGameMsgManagerService.findGameSwitchConfig(findGameDetailInfoByConvertUin.f401939c)) != null && findGameSwitchConfig.mSyncSwitch == 1) {
                return false;
            }
        }
        if (!iGameMsgManagerService.isGameMsgSync(this.C.getString(R.string.f1373606n))) {
            Uh(this.C.getString(R.string.f1373606n));
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        af afVar = new af(getQBaseActivity(), ((IphoneTitleBarFragment) this).mContentView, 1);
        this.E = afVar;
        arrayList.add(afVar);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, layoutInflater, viewGroup, bundle);
            return;
        }
        if (((IGameMsgBoxRuntimeService) this.D.getRuntimeService(IGameMsgBoxRuntimeService.class, "")).shouldFilterUnintendedMultiClicks()) {
            getQBaseActivity().finish();
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        Rh();
        ((IGameReportApi) QRoute.api(IGameReportApi.class)).clearLastReportApplyPartnerBoxData();
        Th();
        Sh();
        initTitleBar();
        Vh();
        this.D.addObserver(this.S);
        ((IGameMsgManagerService) this.D.getRuntimeService(IGameMsgManagerService.class)).addUserInfoChangedObserver(this.S);
        IGameMsgBoxManager iGameMsgBoxManager = (IGameMsgBoxManager) this.D.getRuntimeService(IGameMsgBoxManager.class);
        iGameMsgBoxManager.tryUpdateGameMsgInfoFromRecentUser();
        iGameMsgBoxManager.resetNTLoadRemoteUserList();
        iGameMsgBoxManager.fetchRecentGameContacts(false, this.T, 2);
        this.Q.w(((IphoneTitleBarFragment) this).mContentView);
        this.Q.t();
        com.tencent.qqnt.kernel.api.aa recentContactService = ((IKernelService) this.D.getRuntimeService(IKernelService.class, "all")).getRecentContactService();
        if (recentContactService != null) {
            recentContactService.F0(new Contact(116, "", ""), new e());
        }
        IGameMsgManagerService iGameMsgManagerService = (IGameMsgManagerService) this.D.getRuntimeService(IGameMsgManagerService.class, "");
        if (iGameMsgManagerService != null) {
            iGameMsgManagerService.addRecentPartnerListener(this.U);
            iGameMsgManagerService.getRecentPartnerList();
        }
        ((IGameMsgCardApi) QRoute.api(IGameMsgCardApi.class)).onGameBoxCreate(this.V);
        ((IGameMsgCardApi) QRoute.api(IGameMsgCardApi.class)).reqGameCardInfo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return R.layout.eao;
    }

    protected void li(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
            return;
        }
        try {
            IGameMsgBoxManager iGameMsgBoxManager = (IGameMsgBoxManager) this.D.getRuntimeService(IGameMsgBoxManager.class);
            List<com.tencent.mobileqq.activity.recent.gamemsgbox.data.b> titles = iGameMsgBoxManager.getTitles();
            if (hi(titles)) {
                return;
            }
            if (i3 == 0) {
                fi(titles);
                com.tencent.mobileqq.activity.recent.gamemsgbox.e.f185509a.b("all");
                this.E.B9();
                this.R.a("all");
                return;
            }
            if (i3 == 1) {
                ai();
                return;
            }
            com.tencent.mobileqq.activity.recent.gamemsgbox.data.b gi5 = gi(i3, iGameMsgBoxManager, titles);
            com.tencent.mobileqq.activity.recent.gamemsgbox.e.f185509a.b(Ph(gi5));
            this.E.B9();
            if (gi5 != null && gi5.f185507d != null) {
                ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(gi5.f185507d.f401939c, "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92045", "209203", "", "", "8", "");
                gd1.a aVar = gi5.f185507d;
                this.L = aVar.f401947k;
                this.R.a(aVar.f401939c);
            }
        } catch (Exception e16) {
            QLog.e("GameMsgBoxFragment", 1, "updateTabChange err! ", e16);
        }
    }

    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null) {
            return false;
        }
        if (!AppSetting.t(baseActivity) || !com.tencent.mobileqq.pad.m.b(baseActivity)) {
            super.onBackEvent();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@androidx.annotation.Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        this.C = getBaseActivity();
        this.D = getBaseActivity().app;
        this.Q = new GameMsgBoxBannerManager(this.D, this.C);
        this.R = ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).createGameMsgBoxHeaderManager(this.C);
        initTabIndex();
        ((IGameMsgBoxManager) this.D.getRuntimeService(IGameMsgBoxManager.class)).registerNTGameTabListener(new IGameMsgBoxManager.a() { // from class: com.tencent.mobileqq.activity.recent.gamemsgbox.x
            @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager.a
            public final void a() {
                GameMsgBoxFragment.this.di();
            }
        });
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).requestGameListOfMsgBox();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.onDestroy();
        QQAppInterface qQAppInterface = this.D;
        if (qQAppInterface == null) {
            return;
        }
        IGameMsgManagerService iGameMsgManagerService = (IGameMsgManagerService) qQAppInterface.getRuntimeService(IGameMsgManagerService.class, "");
        if (iGameMsgManagerService != null) {
            iGameMsgManagerService.removeRecentPartnerListener(this.U);
        }
        ((IGameMsgManagerService) this.D.getRuntimeService(IGameMsgManagerService.class)).removeUserInfoChangedObserver(this.S);
        this.D.removeObserver(this.S);
        IGameMsgBoxManager iGameMsgBoxManager = (IGameMsgBoxManager) this.D.getRuntimeService(IGameMsgBoxManager.class);
        if (iGameMsgBoxManager != null) {
            iGameMsgBoxManager.unregisterNTGameTabListener();
            iGameMsgBoxManager.clearTitles();
        }
        if (this.T != null) {
            this.T = null;
            if (iGameMsgBoxManager == null) {
                return;
            } else {
                iGameMsgBoxManager.resetFetchListener();
            }
        }
        GameMsgBoxBannerManager gameMsgBoxBannerManager = this.Q;
        if (gameMsgBoxBannerManager != null) {
            gameMsgBoxBannerManager.p();
        }
        ((IGameMsgCardApi) QRoute.api(IGameMsgCardApi.class)).onGameBoxDestroy();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.onPause();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            super.onResume();
            ci();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view, (Object) bundle);
            return;
        }
        super.onViewCreated(view, bundle);
        if (AppSetting.t(getContext())) {
            View findViewById = view.findViewById(R.id.rlCommenTitle);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            int statusBarHeight = ImmersiveUtils.getStatusBarHeight(getContext());
            layoutParams.height += statusBarHeight;
            findViewById.setLayoutParams(layoutParams);
            findViewById.setPadding(0, statusBarHeight, 0, 0);
        }
    }
}
