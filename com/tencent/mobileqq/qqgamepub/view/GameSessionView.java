package com.tencent.mobileqq.qqgamepub.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.tencent.ams.fusion.widget.downloadcard.DownloadCardView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.api.ITempApi;
import com.tencent.mobileqq.gamecenter.data.j;
import com.tencent.mobileqq.gamecenter.msginfo.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.msginfo.GameDelSessionRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi;
import com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi;
import com.tencent.mobileqq.qqgamepub.config.e;
import com.tencent.mobileqq.qqgamepub.ipc.QQGameIPCHandler;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qqgamepub.utils.g;
import com.tencent.mobileqq.qqgamepub.web.view.GameContentView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.vas.comm.api.IGameCenterUnitedConfigApi;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes16.dex */
public class GameSessionView extends RelativeLayout implements Handler.Callback, QQGameIPCHandler.b, HippyViewBase {
    static IPatchRedirector $redirector_;
    public static final String G;
    private static final ColorFilter H;
    private static final ColorFilter I;
    private static boolean J;
    private boolean C;
    private boolean D;
    private boolean E;
    private c F;

    /* renamed from: d, reason: collision with root package name */
    private List<GameCenterSessionInfo> f264745d;

    /* renamed from: e, reason: collision with root package name */
    private Handler f264746e;

    /* renamed from: f, reason: collision with root package name */
    private AppRuntime f264747f;

    /* renamed from: h, reason: collision with root package name */
    private GameContentView.a f264748h;

    /* renamed from: i, reason: collision with root package name */
    private a f264749i;

    /* renamed from: m, reason: collision with root package name */
    private int f264750m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class SessionStyleB extends ViewSwitcherSession<TextView> {
        static IPatchRedirector $redirector_;
        private LinearLayout C;
        private TextView D;
        private TextView E;
        private TextView F;
        private ViewSwitcher G;
        private LinearLayout H;
        private View I;
        private int J;
        int K;

        /* renamed from: m, reason: collision with root package name */
        private CornerImageViewWithCircle[] f264756m;

        SessionStyleB() {
            super();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GameSessionView.this);
            } else {
                this.f264756m = new CornerImageViewWithCircle[2];
                this.K = -1;
            }
        }

        @Override // com.tencent.mobileqq.qqgamepub.view.GameSessionView.c
        public void W4() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this);
                return;
            }
            int i3 = 0;
            boolean isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(null, false, null);
            Drawable background = this.C.getBackground();
            Drawable background2 = this.G.getBackground();
            int childCount = this.G.getChildCount();
            QLog.i(GameSessionView.G, 1, "[onPostThemeChange] isNightTheme:" + isNowThemeIsNight + ",uiStyle:" + this.K);
            int i16 = this.K;
            if (i16 != 1 && (!isNowThemeIsNight || i16 == 0)) {
                this.D.setTextColor(DownloadCardView.COLOR_BUTTON_BACKGROUND_DARK);
                this.F.setTextColor(DownloadCardView.COLOR_APP_VERSION);
                if (background != null) {
                    background.setColorFilter(GameSessionView.H);
                }
                if (background2 != null) {
                    background2.setColorFilter(GameSessionView.H);
                }
                LinearLayout linearLayout = this.H;
                if (linearLayout != null && this.I != null) {
                    linearLayout.setBackgroundColor(-1);
                    this.I.setBackgroundColor(-920584);
                }
                while (i3 < childCount) {
                    TextView textView = (TextView) this.G.getChildAt(i3);
                    if (textView != null) {
                        textView.setTextColor(-5329234);
                    }
                    i3++;
                }
                return;
            }
            this.D.setTextColor(-1);
            this.F.setTextColor(-1);
            if (background != null) {
                background.setColorFilter(GameSessionView.I);
            }
            if (background2 != null) {
                background2.setColorFilter(GameSessionView.I);
            }
            LinearLayout linearLayout2 = this.H;
            if (linearLayout2 != null && this.I != null) {
                linearLayout2.setBackgroundColor(MiniChatConstants.COLOR_SELECTED_NIGHT);
                this.I.setBackgroundColor(MiniChatConstants.COLOR_NIGHT);
            }
            while (i3 < childCount) {
                TextView textView2 = (TextView) this.G.getChildAt(i3);
                if (textView2 != null) {
                    textView2.setTextColor(DownloadCardView.COLOR_APP_VERSION);
                }
                i3++;
            }
        }

        @Override // com.tencent.mobileqq.qqgamepub.view.GameSessionView.c
        public void h0(ViewGroup viewGroup) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) viewGroup);
                return;
            }
            View m3 = m(viewGroup);
            ViewSwitcher viewSwitcher = (ViewSwitcher) m3.findViewById(R.id.fgm);
            this.G = viewSwitcher;
            g(viewSwitcher);
            this.E = (TextView) m3.findViewById(R.id.f112216nb);
            this.f264756m[0] = (CornerImageViewWithCircle) m3.findViewById(R.id.f164802ld1);
            this.f264756m[1] = (CornerImageViewWithCircle) m3.findViewById(R.id.f164803ld2);
            this.f264756m[0].setRadius(g.a(l(), GameSessionView.this.getResources()));
            this.f264756m[1].setRadius(g.a(l(), GameSessionView.this.getResources()));
            this.f264756m[0].setCircle(g.a(l(), GameSessionView.this.getResources()), g.a(l(), GameSessionView.this.getResources()), g.a(l() - 0.5f, GameSessionView.this.getResources()), -920584);
            this.f264756m[1].setCircle(g.a(l(), GameSessionView.this.getResources()), g.a(l(), GameSessionView.this.getResources()), g.a(l(), GameSessionView.this.getResources()), -920584);
            this.f264756m[0].invalidate();
            this.f264756m[1].invalidate();
            this.C = (LinearLayout) m3.findViewById(R.id.f1062768_);
            this.D = (TextView) m3.findViewById(R.id.f109276fd);
            this.H = (LinearLayout) m3.findViewById(R.id.yih);
            this.I = m3.findViewById(R.id.yii);
            this.F = (TextView) m3.findViewById(R.id.f110486in);
            m3.setOnClickListener(this);
            viewGroup.addView(m3);
        }

        public void i(int i3) {
            String str;
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3);
                return;
            }
            GameCenterSessionInfo e16 = e();
            if (e16 != null) {
                String m3 = e16.m();
                str2 = String.valueOf(e16.x());
                str = m3;
            } else {
                str = "";
                str2 = str;
            }
            ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(str, "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", IQQGameHippyApi.OPEN_MESSAGE_PAGE_FROM_GAME_MSG_VIEW, "207620", "0", str2, "", "", "", "", String.valueOf(i3));
        }

        public void j(int i3) {
            String str;
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
                return;
            }
            GameCenterSessionInfo e16 = e();
            if (e16 != null) {
                String m3 = e16.m();
                str2 = String.valueOf(e16.x());
                str = m3;
            } else {
                str = "";
                str2 = str;
            }
            ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(str, "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", IQQGameHippyApi.OPEN_MESSAGE_PAGE_FROM_GAME_MSG_VIEW, "207619", "0", str2, "", "", "", "", String.valueOf(i3));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqgamepub.view.GameSessionView.ViewSwitcherSession
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void b(TextView textView, d dVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) textView, (Object) dVar);
                return;
            }
            super.b(textView, dVar);
            textView.setText(new QQText(String.format(this.f264761i, new b(dVar.a()).b(), dVar.f264765b.f212222e), 3, 16));
        }

        public int l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return 15;
        }

        public View m(ViewGroup viewGroup) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup);
            }
            return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ebh, viewGroup, false);
        }

        @Override // android.widget.ViewSwitcher.ViewFactory
        public View makeView() {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (View) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            TextView textView = (TextView) LayoutInflater.from(GameSessionView.this.getContext()).inflate(R.layout.ebg, (ViewGroup) f(), false);
            if (ThemeUtil.isNowThemeIsNight(null, false, null)) {
                i3 = DownloadCardView.COLOR_APP_VERSION;
            } else {
                i3 = -5329234;
            }
            textView.setTextColor(i3);
            return textView;
        }

        @Override // com.tencent.mobileqq.qqgamepub.view.GameSessionView.ViewSwitcherSession, android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, (Object) view);
            } else {
                super.onClick(view);
                i(this.J);
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        @Override // com.tencent.mobileqq.qqgamepub.view.GameSessionView.ViewSwitcherSession, com.tencent.mobileqq.qqgamepub.view.GameSessionView.c
        public void q3(List<GameCenterSessionInfo> list, int i3) {
            d dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) list, i3);
                return;
            }
            super.q3(list, i3);
            this.J = i3;
            int i16 = 0;
            int i17 = 0;
            for (int i18 = 0; i18 < list.size(); i18++) {
                GameCenterSessionInfo gameCenterSessionInfo = list.get(i18);
                if (gameCenterSessionInfo.z() > 0) {
                    if (i17 < this.f264756m.length) {
                        GameSessionView.this.w(this.f264756m[i17], new b(gameCenterSessionInfo).a());
                        this.f264756m[i17].setVisibility(0);
                    }
                    i17++;
                }
            }
            if (i17 > 0) {
                this.F.setVisibility(0);
                this.D.setText(String.format(GameSessionView.this.getResources().getString(R.string.f17635311), Integer.valueOf(i17)));
            } else {
                this.D.setText(R.string.f1763330z);
                this.F.setVisibility(8);
                for (int i19 = 0; i19 < list.size() && i17 < this.f264756m.length; i19++) {
                    GameSessionView.this.w(this.f264756m[i17], new b(list.get(i19)).a());
                    this.f264756m[i17].setVisibility(0);
                    i17++;
                }
            }
            if (this.f264760h.size() > 0 && (dVar = this.f264760h.get(0)) != null && dVar.f264765b != null) {
                this.F.setText(new QQText(String.format(this.f264761i, new b(dVar.a()).b(), dVar.f264765b.f212222e), 3, 16));
            }
            this.E.setText(((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).getUnreadStr(i3));
            TextView textView = this.E;
            if (i3 <= 0) {
                i16 = 4;
            }
            textView.setVisibility(i16);
            j(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class SessionStyleB4Hippy extends SessionStyleB {
        static IPatchRedirector $redirector_;

        SessionStyleB4Hippy() {
            super();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GameSessionView.this);
            }
        }

        @Override // com.tencent.mobileqq.qqgamepub.view.GameSessionView.SessionStyleB
        public void i(int i3) {
            String str;
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3);
                return;
            }
            GameCenterSessionInfo e16 = e();
            if (e16 != null) {
                String m3 = e16.m();
                str2 = String.valueOf(e16.x());
                str = m3;
            } else {
                str = "";
                str2 = str;
            }
            ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(str, "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", IQQGameHippyApi.OPEN_MESSAGE_PAGE_FROM_GAME_MSG_VIEW, "207620", "0", str2, "", "", "", "", String.valueOf(i3), "3");
        }

        @Override // com.tencent.mobileqq.qqgamepub.view.GameSessionView.SessionStyleB
        public void j(int i3) {
            String str;
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
                return;
            }
            GameCenterSessionInfo e16 = e();
            if (e16 != null) {
                String m3 = e16.m();
                str2 = String.valueOf(e16.x());
                str = m3;
            } else {
                str = "";
                str2 = str;
            }
            ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(str, "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", IQQGameHippyApi.OPEN_MESSAGE_PAGE_FROM_GAME_MSG_VIEW, "207619", "0", str2, "", "", "", "", String.valueOf(i3), "3");
        }

        @Override // com.tencent.mobileqq.qqgamepub.view.GameSessionView.SessionStyleB
        public int l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return 10;
        }

        @Override // com.tencent.mobileqq.qqgamepub.view.GameSessionView.SessionStyleB
        public View m(ViewGroup viewGroup) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup);
            }
            return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ebi, viewGroup, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public abstract class ViewSwitcherSession<T extends View> implements c, ViewSwitcher.ViewFactory, Runnable, Comparator<d> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private ViewSwitcher f264757d;

        /* renamed from: e, reason: collision with root package name */
        private int f264758e;

        /* renamed from: f, reason: collision with root package name */
        private final long f264759f;

        /* renamed from: h, reason: collision with root package name */
        protected List<d> f264760h;

        /* renamed from: i, reason: collision with root package name */
        protected String f264761i;

        ViewSwitcherSession() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GameSessionView.this);
                return;
            }
            this.f264758e = -1;
            this.f264759f = 1500L;
            this.f264760h = new ArrayList();
            this.f264761i = GameSessionView.this.getResources().getString(R.string.f17639315);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void h(boolean z16) {
            List<d> list = this.f264760h;
            if (list != null && list.size() != 0) {
                int i3 = this.f264758e + 1;
                this.f264758e = i3;
                boolean z17 = false;
                if (i3 >= this.f264760h.size()) {
                    this.f264758e = 0;
                }
                b(this.f264757d.getNextView(), this.f264760h.get(this.f264758e));
                this.f264757d.showNext();
                if (GamePubAccountHelper.C()) {
                    int i16 = 0;
                    while (true) {
                        if (i16 < this.f264757d.getChildCount()) {
                            if (this.f264757d.getChildAt(i16) != null && this.f264757d.getChildAt(i16).getHeight() == 0 && this.f264757d.getChildAt(i16).getWidth() == 0) {
                                z17 = true;
                                break;
                            }
                            i16++;
                        } else {
                            break;
                        }
                    }
                    if (z17) {
                        QLog.d(GameSessionView.G, 1, "viewSwitcher need posDraw");
                        ViewSwitcher viewSwitcher = this.f264757d;
                        viewSwitcher.measure(View.MeasureSpec.makeMeasureSpec(viewSwitcher.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.f264757d.getHeight(), 1073741824));
                        ViewSwitcher viewSwitcher2 = this.f264757d;
                        viewSwitcher2.layout(viewSwitcher2.getLeft(), this.f264757d.getTop(), this.f264757d.getRight(), this.f264757d.getBottom());
                    }
                }
                if (z16) {
                    GameSessionView.this.postDelayed(this, 1500L);
                }
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(d dVar, d dVar2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, (Object) dVar, (Object) dVar2)).intValue();
            }
            long j3 = dVar.f264765b.f212221d;
            long j16 = dVar2.f264765b.f212221d;
            if (j3 > j16) {
                return -1;
            }
            if (j3 < j16) {
                return 1;
            }
            return 0;
        }

        protected void b(T t16, d dVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) t16, (Object) dVar);
            } else {
                t16.setTag(dVar.a());
            }
        }

        @Override // com.tencent.mobileqq.qqgamepub.view.GameSessionView.c
        public void destroy() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this);
            } else {
                GameSessionView.this.removeCallbacks(this);
            }
        }

        protected GameCenterSessionInfo e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (GameCenterSessionInfo) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return (GameCenterSessionInfo) this.f264757d.getCurrentView().getTag();
        }

        protected ViewSwitcher f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (ViewSwitcher) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.f264757d;
        }

        protected void g(ViewSwitcher viewSwitcher) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewSwitcher);
            } else {
                this.f264757d = viewSwitcher;
                viewSwitcher.setAnimateFirstView(false);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            HippyQQEngine engineInstance;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
            } else {
                if ((GameSessionView.this.getContext() instanceof HippyInstanceContext) && ((HippyInstanceContext) GameSessionView.this.getContext()).getEngineContext() != null && (engineInstance = HippyQQEngine.getEngineInstance(((HippyInstanceContext) GameSessionView.this.getContext()).getEngineContext().getEngineId())) != null && engineInstance.getActivity() != null) {
                    ((ITempApi) QRoute.api(ITempApi.class)).openGameMsgBox(engineInstance.getActivity());
                }
                ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).setLastGameSessionClicked(GameSessionView.this.f264747f.getAccount(), System.currentTimeMillis());
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        @Override // com.tencent.mobileqq.qqgamepub.view.GameSessionView.c
        public void q3(List<GameCenterSessionInfo> list, int i3) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) list, i3);
                return;
            }
            this.f264760h.clear();
            for (int i16 = 0; i16 < list.size(); i16++) {
                GameCenterSessionInfo gameCenterSessionInfo = list.get(i16);
                List<GameCenterSessionInfo.SimpleMessage> A = list.get(i16).A();
                if (A != null) {
                    for (int i17 = 0; i17 < A.size(); i17++) {
                        this.f264760h.add(new d(gameCenterSessionInfo, A.get(i17)));
                    }
                }
            }
            if (this.f264760h.size() == 0) {
                for (int i18 = 0; i18 < list.size(); i18++) {
                    GameCenterSessionInfo gameCenterSessionInfo2 = list.get(i18);
                    j sessionDelDataHelper = ((IGameMsgManagerService) GameSessionView.this.f264747f.getRuntimeService(IGameMsgManagerService.class, "")).getSessionDelDataHelper();
                    GameDelSessionRecord gameDelSessionRecord = new GameDelSessionRecord();
                    gameDelSessionRecord.mUin = gameCenterSessionInfo2.w();
                    if (sessionDelDataHelper != null && sessionDelDataHelper.b(gameDelSessionRecord)) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        this.f264760h.add(new d(gameCenterSessionInfo2, new GameCenterSessionInfo.SimpleMessage(gameCenterSessionInfo2.q(), gameCenterSessionInfo2.p())));
                    }
                }
            }
            Collections.sort(this.f264760h, this);
            GameSessionView.this.removeCallbacks(this);
            this.f264757d.removeAllViews();
            this.f264757d.setFactory(this);
            this.f264758e = -1;
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                h(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GameSessionView.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int intExtra;
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            String action = intent.getAction();
            Bundle extras = intent.getExtras();
            if (QLog.isColorLevel()) {
                String str2 = GameSessionView.G;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[onRecevier] action:");
                sb5.append(action);
                sb5.append(",data:");
                if (extras != null) {
                    str = extras.toString();
                } else {
                    str = null;
                }
                sb5.append(str);
                QLog.d(str2, 2, sb5.toString());
            }
            if (action == null) {
                return;
            }
            if ("action_qgame_messgae_change".equals(action)) {
                if (extras != null) {
                    GameCenterSessionInfo gameCenterSessionInfo = (GameCenterSessionInfo) extras.getParcelable("key_game_msg");
                    int i3 = extras.getInt("key_msg_change_type");
                    if (QLog.isColorLevel()) {
                        QLog.d(GameSessionView.G, 2, "[onReceive] type:" + i3 + ",info:" + gameCenterSessionInfo);
                    }
                    GameSessionView.this.o();
                    return;
                }
                return;
            }
            if ("action_qgame_unread_change".equals(action)) {
                if (extras != null) {
                    int i16 = extras.getInt("key_msg_unread_cnt");
                    if (QLog.isColorLevel()) {
                        QLog.d(GameSessionView.G, 2, "[onReceive] cnt:" + i16);
                        return;
                    }
                    return;
                }
                return;
            }
            if ("action_qgame_theme_change".equals(action) && GameSessionView.this.F != null) {
                if ((GameSessionView.this.F instanceof SessionStyleB) && (intExtra = intent.getIntExtra("key_msg_helper_style", -1)) != -1) {
                    ((SessionStyleB) GameSessionView.this.F).K = intExtra;
                }
                GameSessionView.this.F.W4();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final GameCenterSessionInfo f264763a;

        b(GameCenterSessionInfo gameCenterSessionInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) gameCenterSessionInfo);
            } else {
                this.f264763a = gameCenterSessionInfo;
            }
        }

        public String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            if (this.f264763a.x() == 0) {
                return this.f264763a.l();
            }
            return this.f264763a.j();
        }

        public String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            if (this.f264763a.x() == 0) {
                return this.f264763a.n();
            }
            return this.f264763a.s();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface c extends View.OnClickListener {
        void W4();

        void destroy();

        void h0(ViewGroup viewGroup);

        void q3(List<GameCenterSessionInfo> list, int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final GameCenterSessionInfo f264764a;

        /* renamed from: b, reason: collision with root package name */
        public final GameCenterSessionInfo.SimpleMessage f264765b;

        d(GameCenterSessionInfo gameCenterSessionInfo, GameCenterSessionInfo.SimpleMessage simpleMessage) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) gameCenterSessionInfo, (Object) simpleMessage);
            } else {
                this.f264764a = gameCenterSessionInfo;
                this.f264765b = simpleMessage;
            }
        }

        GameCenterSessionInfo a() {
            return this.f264764a;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28963);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
            return;
        }
        G = "QQGamePub_" + GameSessionView.class.getSimpleName();
        H = new LightingColorFilter(Color.argb(255, 0, 0, 0), 16777215);
        I = new LightingColorFilter(Color.argb(255, 0, 0, 0), 1710618);
        J = false;
    }

    public GameSessionView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
            return;
        }
        this.f264745d = new ArrayList();
        this.f264746e = new Handler(Looper.getMainLooper(), this);
        this.f264750m = 1;
        this.C = false;
        this.D = false;
        this.E = false;
        v(context);
    }

    private c n(int i3) {
        boolean isGamePubHippySwitch = ((IQQGameConfigUtil) QRoute.api(IQQGameConfigUtil.class)).isGamePubHippySwitch();
        QLog.i(G, 1, "[createSessionStyle], isHippySwitch:" + isGamePubHippySwitch);
        if (isGamePubHippySwitch) {
            return new SessionStyleB4Hippy();
        }
        return new SessionStyleB();
    }

    private void p() {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qqgamepub.view.GameSessionView.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) GameSessionView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (GameSessionView.this.f264747f == null) {
                    return;
                }
                IGameMsgManagerService iGameMsgManagerService = (IGameMsgManagerService) GameSessionView.this.f264747f.getRuntimeService(IGameMsgManagerService.class, "");
                if (!iGameMsgManagerService.isGrayOpen()) {
                    if (QLog.isColorLevel()) {
                        QLog.d(GameSessionView.G, 2, "[setData] gray is not open. return.");
                        return;
                    }
                    return;
                }
                List<GameCenterSessionInfo> sessionInfoList = iGameMsgManagerService.getSessionInfoList();
                if (sessionInfoList != null) {
                    try {
                        for (GameCenterSessionInfo gameCenterSessionInfo : sessionInfoList) {
                            if (gameCenterSessionInfo != null) {
                                gameCenterSessionInfo.n0((BaseQQAppInterface) GameSessionView.this.f264747f);
                            }
                        }
                    } catch (Exception e16) {
                        QLog.e(GameSessionView.G, 1, e16, new Object[0]);
                    }
                }
                if (!GameSessionView.this.D) {
                    GameSessionView.this.f264750m = 1;
                    GameSessionView.this.C = iGameMsgManagerService.getNeedPopMsgView();
                    GameSessionView.this.D = true;
                }
                GameSessionView.this.f264746e.post(new Runnable(sessionInfoList) { // from class: com.tencent.mobileqq.qqgamepub.view.GameSessionView.2.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ List f264754d;

                    {
                        this.f264754d = sessionInfoList;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this, (Object) sessionInfoList);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            GameSessionView.this.setData(this.f264754d);
                        }
                    }
                });
            }
        });
    }

    private boolean r(List<GameCenterSessionInfo> list) {
        if (list != null && list.size() != 0) {
            new ArrayList();
            j sessionDelDataHelper = ((IGameMsgManagerService) this.f264747f.getRuntimeService(IGameMsgManagerService.class, "")).getSessionDelDataHelper();
            if (sessionDelDataHelper == null) {
                return false;
            }
            for (GameCenterSessionInfo gameCenterSessionInfo : list) {
                if (gameCenterSessionInfo != null) {
                    GameDelSessionRecord gameDelSessionRecord = new GameDelSessionRecord();
                    gameDelSessionRecord.mUin = gameCenterSessionInfo.w();
                    if (!sessionDelDataHelper.b(gameDelSessionRecord)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private void t(int i3, boolean z16) {
        boolean z17;
        long currentTimeMillis = System.currentTimeMillis();
        long a16 = ((e) ((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).getConfig(IGameCenterUnitedConfigApi.GAMEPLAT_PUB_SESSION_CONFIG, new e())).a() * 3600 * 1000;
        long lastGameSessionClicked = ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).getLastGameSessionClicked(this.f264747f.getAccount());
        if (lastGameSessionClicked == 0) {
            ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).setLastGameSessionClicked(this.f264747f.getAccount(), currentTimeMillis);
            QLog.i(G, 1, "[setData] init LastGameSessionClicked:" + currentTimeMillis);
        }
        if (lastGameSessionClicked != 0 && currentTimeMillis - lastGameSessionClicked >= a16) {
            z17 = true;
        } else {
            z17 = false;
        }
        String str = G;
        QLog.i(str, 1, "[setData] unread:" + i3 + ", expired:" + z17 + ", duration:" + a16 + ", lastGameSessionClicked:" + lastGameSessionClicked + ", gameSessionShown:" + z16);
        if (z17) {
            if (z16) {
                GameContentView.a aVar = this.f264748h;
                if (aVar != null) {
                    aVar.O5(1000L);
                }
                ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).setGameSessionShown(this.f264747f.getAccount(), false);
                ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg("", "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", IQQGameHippyApi.OPEN_MESSAGE_PAGE_FROM_GAME_MSG_VIEW, "207621", "", "", "", "");
                QLog.i(str, 1, "[setData] setGameSessionShown false");
                return;
            }
            setVisibility(8);
            GameContentView.a aVar2 = this.f264748h;
            if (aVar2 != null) {
                aVar2.O5(1000L);
                return;
            }
            return;
        }
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).setLastGameSessionClicked(this.f264747f.getAccount(), currentTimeMillis);
    }

    private void v(Context context) {
        this.f264749i = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_qgame_messgae_change");
        intentFilter.addAction("action_qgame_unread_change");
        intentFilter.addAction("action_qgame_theme_change");
        context.registerReceiver(this.f264749i, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(CornerImageView cornerImageView, String str) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = getResources().getDrawable(R.drawable.csy);
        obtain.mFailedDrawable = getResources().getDrawable(R.drawable.csy);
        try {
            cornerImageView.setImageDrawable(URLDrawable.getDrawable(str, obtain));
        } catch (Exception e16) {
            QLog.e(G, 1, "[setAvatar] " + e16);
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.ipc.QQGameIPCHandler.b
    public void a(String str, EIPCResult eIPCResult) {
        Bundle bundle;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) eIPCResult);
            return;
        }
        if (eIPCResult.code == 0 && (bundle = eIPCResult.data) != null) {
            List<GameCenterSessionInfo> list = (List) bundle.getSerializable("key_get_game_msg");
            if (!this.D) {
                if (!bundle.getBoolean("key_get_game_gray_user", false)) {
                    if (QLog.isColorLevel()) {
                        QLog.d(G, 2, "[setData] gray is not open. return.");
                        return;
                    }
                    return;
                } else {
                    this.C = bundle.getBoolean("key_get_game_show_on_list", false);
                    J = bundle.getBoolean("key_get_game_show_req_msg_unread", false);
                    this.D = true;
                }
            }
            QLog.e(G, 1, "[onCallback] list:" + list.size() + ",type:" + this.f264750m);
            setData(list);
        }
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewBase
    public NativeGestureDispatcher getGestureDispatcher() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (NativeGestureDispatcher) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return null;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) message)).booleanValue();
        }
        if (message.what == 1) {
            this.C = false;
            setVisibility(8);
            requestLayout();
            GameContentView.a aVar = this.f264748h;
            if (aVar != null) {
                aVar.M3();
            }
        }
        return false;
    }

    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        AppRuntime appRuntime = this.f264747f;
        if (appRuntime == null) {
            return;
        }
        if (appRuntime instanceof BaseQQAppInterface) {
            p();
            return;
        }
        if (((IQQGameTempRelyApi) QRoute.api(IQQGameTempRelyApi.class)).isToolAppRuntime(this.f264747f)) {
            QQGameIPCHandler.e().f("task_get_qgame_session_msg", true);
            QIPCClientHelper.getInstance().callServer("QQGameIPCModule", "getGameMsg", null, new EIPCResultCallback() { // from class: com.tencent.mobileqq.qqgamepub.view.GameSessionView.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GameSessionView.this);
                    }
                }

                @Override // eipc.EIPCResultCallback
                public void onCallback(EIPCResult eIPCResult) {
                    Bundle bundle;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) eIPCResult);
                        return;
                    }
                    if (eIPCResult.code == 0 && (bundle = eIPCResult.data) != null) {
                        List list = (List) bundle.getSerializable("key_get_game_msg");
                        if (!GameSessionView.this.D) {
                            if (bundle.getBoolean("key_get_game_gray_user", false)) {
                                GameSessionView.this.C = bundle.getBoolean("key_get_game_show_on_list", false);
                                GameSessionView.J = bundle.getBoolean("key_get_game_show_req_msg_unread", false);
                                GameSessionView.this.D = true;
                            } else {
                                if (QLog.isColorLevel()) {
                                    QLog.d(GameSessionView.G, 2, "[setData] gray is not open. return.");
                                    return;
                                }
                                return;
                            }
                        }
                        QLog.e(GameSessionView.G, 1, "[onCallback] list:" + list.size() + ",type:" + GameSessionView.this.f264750m);
                        GameSessionView.this.f264746e.post(new Runnable(list) { // from class: com.tencent.mobileqq.qqgamepub.view.GameSessionView.1.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ List f264752d;

                            {
                                this.f264752d = list;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) list);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                } else {
                                    GameSessionView.this.setData(this.f264752d);
                                }
                            }
                        });
                    }
                }
            });
            return;
        }
        QLog.i(G, 1, "[initData] unknown interface:" + this.f264747f.getClass().getSimpleName());
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        String str;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i18 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        List<GameCenterSessionInfo> list = this.f264745d;
        if (list != null && list.size() != 0 && (this.f264750m != 2 || this.C)) {
            super.onMeasure(i3, i16);
            if (!this.E) {
                if (this.f264745d.get(0) == null) {
                    str = "";
                    i17 = 0;
                } else {
                    GameCenterSessionInfo gameCenterSessionInfo = this.f264745d.get(0);
                    String m3 = gameCenterSessionInfo.m();
                    if (gameCenterSessionInfo.x() == 0) {
                        if (J) {
                            i17 = 0;
                        } else {
                            i17 = 0;
                            str = m3;
                        }
                    } else {
                        i17 = gameCenterSessionInfo.z();
                        if (i17 <= 0) {
                            i18 = 1;
                        }
                    }
                    str = m3;
                    ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(str, "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", IQQGameHippyApi.OPEN_MESSAGE_PAGE_FROM_GAME_MSG_VIEW, "206341", i18 + "", "0", this.f264750m + "", "8", "", "", i17 + "");
                    this.E = true;
                    return;
                }
                i18 = 1;
                ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(str, "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", IQQGameHippyApi.OPEN_MESSAGE_PAGE_FROM_GAME_MSG_VIEW, "206341", i18 + "", "0", this.f264750m + "", "8", "", "", i17 + "");
                this.E = true;
                return;
            }
            return;
        }
        setMeasuredDimension(0, 0);
    }

    public void q(AppRuntime appRuntime, GameContentView.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) appRuntime, (Object) aVar);
            return;
        }
        if (appRuntime == null) {
            return;
        }
        this.f264747f = appRuntime;
        this.f264748h = aVar;
        this.D = false;
        QQGameIPCHandler.e().c("task_get_qgame_session_msg", this);
        AppRuntime appRuntime2 = this.f264747f;
        if (appRuntime2 == null) {
            return;
        }
        if (appRuntime2 instanceof BaseQQAppInterface) {
            p();
            return;
        }
        if (((IQQGameTempRelyApi) QRoute.api(IQQGameTempRelyApi.class)).isToolAppRuntime(this.f264747f)) {
            QQGameIPCHandler.e().f("task_get_qgame_session_msg", true);
            return;
        }
        QLog.i(G, 1, "[initData] unknown interface:" + this.f264747f.getClass().getSimpleName());
    }

    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        if (getContext() != null) {
            getContext().unregisterReceiver(this.f264749i);
        }
        this.f264746e.removeCallbacksAndMessages(null);
        QQGameIPCHandler.e().i("task_get_qgame_session_msg");
    }

    public void setData(List<GameCenterSessionInfo> list) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) list);
            return;
        }
        if (r(list)) {
            this.f264745d = new ArrayList();
            setVisibility(8);
            GameContentView.a aVar = this.f264748h;
            if (aVar != null) {
                aVar.M3();
                return;
            }
            return;
        }
        this.f264745d = list;
        if (QLog.isColorLevel()) {
            QLog.d(G, 2, "[setData] dataList size:" + list.size());
        }
        if (this.f264745d.size() > 0) {
            i3 = 0;
            for (GameCenterSessionInfo gameCenterSessionInfo : this.f264745d) {
                if (gameCenterSessionInfo.x() == 0) {
                    i3++;
                    if (QLog.isColorLevel()) {
                        QLog.d(G, 2, "[folder], cnt:" + i3);
                    }
                } else {
                    i3 += gameCenterSessionInfo.z();
                    if (QLog.isColorLevel()) {
                        QLog.d(G, 2, "[normal], cnt:" + i3);
                    }
                }
            }
        } else {
            i3 = 0;
        }
        c cVar = this.F;
        if (cVar != null) {
            cVar.destroy();
            removeAllViews();
        }
        c n3 = n(i3);
        this.F = n3;
        n3.h0(this);
        this.F.q3(this.f264745d, i3);
        this.F.W4();
        boolean z16 = this.F instanceof SessionStyleB4Hippy;
        setVisibility(0);
        boolean gameSessionShown = ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).getGameSessionShown(this.f264747f.getAccount());
        if (i3 > 0) {
            QLog.i(G, 1, "[setData] unread:" + i3 + ", gameSessionShown:" + gameSessionShown);
            if (!gameSessionShown) {
                ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).setGameSessionShown(this.f264747f.getAccount(), true);
                ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg("", "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", IQQGameHippyApi.OPEN_MESSAGE_PAGE_FROM_GAME_MSG_VIEW, "207622", "", "", "", "");
            }
            ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).setLastGameSessionClicked(this.f264747f.getAccount(), System.currentTimeMillis());
        } else {
            t(i3, gameSessionShown);
        }
        GameContentView.a aVar2 = this.f264748h;
        if (aVar2 != null) {
            aVar2.M3();
        }
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewBase
    public void setGestureDispatcher(NativeGestureDispatcher nativeGestureDispatcher) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) nativeGestureDispatcher);
        }
    }

    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        GameContentView.a aVar = this.f264748h;
        if (aVar != null) {
            aVar.M3();
        }
    }

    public GameSessionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f264745d = new ArrayList();
        this.f264746e = new Handler(Looper.getMainLooper(), this);
        this.f264750m = 1;
        this.C = false;
        this.D = false;
        this.E = false;
        v(context);
    }

    public GameSessionView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f264745d = new ArrayList();
        this.f264746e = new Handler(Looper.getMainLooper(), this);
        this.f264750m = 1;
        this.C = false;
        this.D = false;
        this.E = false;
        v(context);
    }
}
