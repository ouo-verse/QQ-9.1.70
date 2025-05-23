package com.tencent.mobileqq.matchchat;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.imcore.message.ao;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.quibadge.QUIBadgeDragLayout;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.utils.ad;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.AdvancedTipsBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.widget.AbsListView;
import com.tencent.widget.SwipListView;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MatchChatMsgListFragment extends IphoneTitleBarFragment implements DragFrameLayout.b, SwipListView.RightIconMenuListener, AbsListView.OnScrollListener, com.tencent.mobileqq.dating.g, Handler.Callback, Observer, View.OnClickListener {
    static IPatchRedirector $redirector_;
    QQAppInterface C;
    BaseActivity D;
    int E;
    String F;
    LinearLayout G;
    View H;
    FPSSwipListView I;
    DragFrameLayout J;
    TopGestureLayout K;
    boolean L;
    boolean M;
    long N;
    int P;
    MqqHandler Q;
    MqqHandler R;
    List<MessageRecord> S;
    boolean T;
    int U;
    boolean V;
    volatile boolean W;
    long X;
    private View Y;
    private View Z;

    /* renamed from: a0, reason: collision with root package name */
    private Object f243757a0;

    /* renamed from: b0, reason: collision with root package name */
    private AdvancedTipsBar f243758b0;

    /* renamed from: c0, reason: collision with root package name */
    private List<Long> f243759c0;

    /* renamed from: d0, reason: collision with root package name */
    private long f243760d0;

    /* renamed from: e0, reason: collision with root package name */
    private com.tencent.mobileqq.qqexpand.manager.e f243761e0;

    /* renamed from: f0, reason: collision with root package name */
    private ExpandObserver f243762f0;

    /* renamed from: g0, reason: collision with root package name */
    final com.tencent.mobileqq.avatar.observer.a f243763g0;

    /* renamed from: h0, reason: collision with root package name */
    final ar f243764h0;

    /* renamed from: i0, reason: collision with root package name */
    final Handler.Callback f243765i0;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.matchchat.MatchChatMsgListFragment$9, reason: invalid class name */
    /* loaded from: classes15.dex */
    class AnonymousClass9 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f243766d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f243767e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f243768f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f243769h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f243770i;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            Rect rect = new Rect();
            this.f243766d.setEnabled(true);
            this.f243766d.getHitRect(rect);
            rect.top -= this.f243767e;
            rect.bottom += this.f243768f;
            rect.left -= this.f243769h;
            rect.right += this.f243770i;
            if (QLog.isColorLevel()) {
                QLog.d("TouchDelegate", 2, " bounds.top=" + rect.top + "bounds.bottom=" + rect.bottom);
            }
            TouchDelegate touchDelegate = new TouchDelegate(rect, this.f243766d);
            if (this.f243766d.getParent() instanceof View) {
                ((View) this.f243766d.getParent()).setTouchDelegate(touchDelegate);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a extends ExpandObserver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MatchChatMsgListFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.qqexpand.network.ExpandObserver
        protected void C(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("MatchChatMsgListFragment", 2, "onUpdateSignalBombPush " + z16 + " " + str);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqexpand.network.ExpandObserver
        public void d(boolean z16, Card card) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), card);
                return;
            }
            if (z16) {
                if (MatchChatMsgListFragment.this.f243758b0 != null && MatchChatMsgUtil.f(MatchChatMsgListFragment.this.C)) {
                    if (TextUtils.isEmpty(card.declaration) && TextUtils.isEmpty(card.voiceUrl)) {
                        MatchChatMsgListFragment.this.f243758b0.setVisibility(0);
                        ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("expose#message_page#data_guide_banner", true, -1L, -1L, null, true, true);
                        return;
                    } else {
                        MatchChatMsgListFragment.this.f243758b0.setVisibility(8);
                        return;
                    }
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.e("MatchChatMsgListFragment", 2, "get expand info error");
            }
        }

        @Override // com.tencent.mobileqq.qqexpand.network.ExpandObserver
        protected void f(boolean z16, List<Long> list, int i3, List<Long> list2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), list, Integer.valueOf(i3), list2);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("MatchChatMsgListFragment", 2, String.format("onGetExtendFriendOnlineState success=%s", Boolean.valueOf(z16)));
            }
            MatchChatMsgListFragment.this.Ch((ArrayList) list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MatchChatMsgListFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ReportController.o(MatchChatMsgListFragment.this.C, "dc00898", "", "", "0X800A698", "0X800A698", 0, 0, "", "", "", "");
                PublicFragmentActivity.start(MatchChatMsgListFragment.this.getBaseActivity(), new Intent(), MatchChatSettingFragment.class);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class c implements DecodeTaskCompletionListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f243773d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ImageView f243774e;

        c(String str, ImageView imageView) {
            this.f243773d = str;
            this.f243774e = imageView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MatchChatMsgListFragment.this, str, imageView);
            }
        }

        @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
        public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bitmap);
            } else if (TextUtils.equals(this.f243773d, str)) {
                this.f243774e.setImageDrawable(new BitmapDrawable(MatchChatMsgListFragment.this.getResources(), bitmap));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class d implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MatchChatMsgListFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#message_page#hidden", true, -1L, -1L, null, true, true);
                MatchChatMsgUtil.g(MatchChatMsgListFragment.this.C);
                MatchChatMsgListFragment.this.f243758b0.setVisibility(8);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class e implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MatchChatMsgListFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#message_page#go_setting", true, -1L, -1L, null, true, true);
                ProfileActivity.G2(MatchChatMsgListFragment.this.getActivity(), new AllInOne(MatchChatMsgListFragment.this.C.getCurrentAccountUin(), 0), 1031);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class f extends com.tencent.mobileqq.avatar.observer.a {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MatchChatMsgListFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.avatar.observer.a
        protected void onUpdateApolloHead(boolean z16, String str, int i3) {
            MqqHandler mqqHandler;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, Integer.valueOf(i3));
                return;
            }
            if (z16 && !TextUtils.isEmpty(str) && str.equalsIgnoreCase(MatchChatMsgListFragment.this.C.getCurrentAccountUin()) && MatchChatMsgListFragment.this.isAdded() && (mqqHandler = MatchChatMsgListFragment.this.R) != null) {
                mqqHandler.removeMessages(1);
                MatchChatMsgListFragment.this.R.sendEmptyMessage(1);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.avatar.observer.a
        public void onUpdateCustomHead(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
            } else if (z16 && !TextUtils.isEmpty(str) && MatchChatMsgListFragment.this.uh(str)) {
                MatchChatMsgListFragment.this.Kh();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class g extends ar {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MatchChatMsgListFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateFriendInfo(String str, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16));
                return;
            }
            if (z16) {
                if (QLog.isColorLevel()) {
                    QLog.d("MatchChatMsgListFragment", 2, "onUpdateFriendInfo uin =" + str);
                }
                if (MatchChatMsgListFragment.this.uh(str)) {
                    MatchChatMsgListFragment.this.Kh();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class h implements Handler.Callback {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MatchChatMsgListFragment.this);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
            }
            int i3 = message.what;
            if (i3 != 0) {
                if (i3 == 1) {
                    MatchChatMsgListFragment matchChatMsgListFragment = MatchChatMsgListFragment.this;
                    matchChatMsgListFragment.Eh(matchChatMsgListFragment.Y);
                }
            } else if (!MatchChatMsgListFragment.this.Gh() && MatchChatMsgListFragment.this.J.getMode() == -1) {
                MatchChatMsgListFragment matchChatMsgListFragment2 = MatchChatMsgListFragment.this;
                if (!matchChatMsgListFragment2.L) {
                    matchChatMsgListFragment2.L = true;
                    if (QLog.isColorLevel()) {
                        QLog.d("MatchChatMsgListFragment", 2, String.format(Locale.getDefault(), "init ui cost time : %s", Long.valueOf(System.currentTimeMillis() - MatchChatMsgListFragment.this.N)));
                    }
                }
            } else {
                MatchChatMsgListFragment.this.M = true;
            }
            return false;
        }
    }

    public MatchChatMsgListFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.E = -1;
        this.F = "";
        this.L = false;
        this.M = false;
        this.P = 0;
        this.T = false;
        this.V = true;
        this.W = false;
        this.f243757a0 = new Object();
        this.f243759c0 = new ArrayList();
        this.f243760d0 = 0L;
        this.f243762f0 = new a();
        this.f243763g0 = new f();
        this.f243764h0 = new g();
        this.f243765i0 = new h();
    }

    private Set<Long> Ah(List<MessageRecord> list) {
        HashSet hashSet = new HashSet();
        if (list != null && !list.isEmpty()) {
            Iterator<MessageRecord> it = list.iterator();
            while (it.hasNext()) {
                try {
                    hashSet.add(Long.valueOf(it.next().senderuin));
                } catch (Exception unused) {
                }
            }
        }
        return hashSet;
    }

    private void Bh(String str, int i3, int i16) {
        Intent intent = new Intent(this.D, (Class<?>) ChatActivity.class);
        intent.putExtra("uin", str);
        intent.putExtra("uintype", i3);
        String j3 = ac.j(this.C, str);
        if (TextUtils.isEmpty(j3)) {
            j3 = ac.g(this.C, str, false);
        }
        intent.putExtra("uinname", j3);
        intent.putExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, i16);
        intent.putExtra(ILimitChatUtils.EXT_KEY_LIMIT_CHAT_ENTER_TYPE, 6);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ch(ArrayList<Long> arrayList) {
        this.f243759c0.clear();
        if (arrayList != null) {
            this.f243759c0.addAll(arrayList);
        }
        MqqHandler mqqHandler = this.Q;
        if (mqqHandler != null) {
            mqqHandler.removeMessages(2);
            this.Q.sendEmptyMessage(2);
        }
    }

    private void Dh(LayoutInflater layoutInflater) {
        if (layoutInflater == null) {
            return;
        }
        Resources resources = this.D.getResources();
        View inflate = layoutInflater.inflate(R.layout.f168800cb2, (ViewGroup) this.G, false);
        this.Y = inflate;
        if (((LinearLayout.LayoutParams) inflate.getLayoutParams()) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, resources.getDimensionPixelSize(R.dimen.f159540au0));
            layoutParams.bottomMargin = resources.getDimensionPixelSize(R.dimen.b7u);
            this.G.addView(this.Y, layoutParams);
        } else {
            this.G.addView(this.Y);
        }
        this.Y.setOnClickListener(this);
        View inflate2 = layoutInflater.inflate(R.layout.cb5, (ViewGroup) this.G, false);
        this.Z = inflate2;
        if (((LinearLayout.LayoutParams) inflate2.getLayoutParams()) == null) {
            this.G.addView(this.Z, new LinearLayout.LayoutParams(-1, resources.getDimensionPixelSize(R.dimen.b7v)));
        } else {
            this.G.addView(this.Z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eh(View view) {
        Drawable bitmapDrawable;
        if (view == null) {
            return;
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.icon);
        if (imageView != null) {
            String currentAccountUin = this.C.getCurrentAccountUin();
            IFaceDecoder iQQAvatarService = ((IQQAvatarService) this.C.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.C);
            iQQAvatarService.setDecodeTaskCompletionListener(new c(currentAccountUin, imageView));
            Bitmap bitmapFromCacheFrom = iQQAvatarService.getBitmapFromCacheFrom(1, currentAccountUin, 6);
            if (bitmapFromCacheFrom == null) {
                if (!iQQAvatarService.isPausing()) {
                    iQQAvatarService.requestDecodeFace(currentAccountUin, 1, true);
                }
                bitmapDrawable = null;
            } else {
                bitmapDrawable = new BitmapDrawable(getResources(), bitmapFromCacheFrom);
            }
            if (bitmapDrawable == null) {
                bitmapDrawable = BaseImageUtil.getDefaultFaceDrawable();
            }
            imageView.setImageDrawable(bitmapDrawable);
        }
        TextView textView = (TextView) view.findViewById(android.R.id.text1);
        if (textView != null) {
            textView.setText(this.C.getCurrentNickname());
        }
    }

    private void Fh() {
        if (this.f243758b0 == null) {
            AdvancedTipsBar advancedTipsBar = new AdvancedTipsBar(this.D);
            this.f243758b0 = advancedTipsBar;
            advancedTipsBar.setTipsText(this.D.getString(R.string.f201004tn));
            this.f243758b0.setTipsIcon(this.D.getResources().getDrawable(R.drawable.common_black_tips_icon_info));
            this.f243758b0.setButtonText(this.D.getString(R.string.f201014to));
            this.f243758b0.m().setBackgroundColor(0);
            this.f243758b0.m().setTextColor(this.D.getResources().getColor(R.color.skin_blue));
            this.f243758b0.z(true);
            this.f243758b0.D();
            this.f243758b0.setCloseListener(new d());
            this.f243758b0.setOnClickListener(new e());
            this.f243758b0.setVisibility(8);
            this.G.addView(this.f243758b0);
        }
    }

    private void Hh(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        boolean z16 = bundle.getBoolean("key_matchchat_from_notification", false);
        String string = bundle.getString("key_matchchat_from_notification_uin", "");
        int i3 = bundle.getInt("key_matchchat_from_notification_type", 1044);
        if (z16 && !TextUtils.isEmpty(string)) {
            Bh(string, i3, 21);
        }
    }

    private void Jh() {
        com.tencent.mobileqq.qqexpand.network.e eVar = (com.tencent.mobileqq.qqexpand.network.e) this.C.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
        if (eVar != null) {
            eVar.l1(this.C.getCurrentAccountUin(), false);
        }
    }

    private void Lh() {
        if (this.f243760d0 > 0) {
            int elapsedRealtime = (int) ((SystemClock.elapsedRealtime() - this.f243760d0) / 1000);
            HashMap hashMap = new HashMap();
            hashMap.put("duration", elapsedRealtime + "");
            ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("exit#message_page#view", true, -1L, -1L, hashMap, true, true);
            this.f243760d0 = 0L;
        }
    }

    private void initTitleBar() {
        setTitle(this.D.getString(R.string.iy_));
        setRightButton(R.string.iyd, new b());
    }

    public static void vh(Context context, int i3) {
        context.startActivity(MatchChatMsgUtil.b(context));
    }

    private void wh(View view) {
        VideoReport.addToDetectionWhitelist(getBaseActivity());
        VideoReport.setPageId(view, "message_page");
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, IExpandReportUtils.EXPAND_APP_KEY);
        VideoReport.setPageParams(view, new PageParams(hashMap));
        QLog.i("MatchChatMsgListFragment", 1, "reportDaTongRegister");
    }

    private void xh(List<MessageRecord> list) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.W || elapsedRealtime - this.X > 180000) {
            ArrayList arrayList = new ArrayList();
            if (list != null && !list.isEmpty()) {
                Iterator<MessageRecord> it = list.iterator();
                while (it.hasNext()) {
                    try {
                        arrayList.add(Long.valueOf(it.next().senderuin));
                    } catch (Exception unused) {
                    }
                }
            }
            if (!arrayList.isEmpty() && ((com.tencent.mobileqq.qqexpand.network.e) this.C.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).U1(arrayList)) {
                this.X = elapsedRealtime;
                this.W = false;
            }
        }
    }

    private TopGestureLayout yh() {
        ViewGroup viewGroup = (ViewGroup) this.D.getWindow().getDecorView();
        View childAt = viewGroup.getChildAt(0);
        if (childAt != null && (childAt instanceof DragFrameLayout)) {
            viewGroup = (ViewGroup) childAt;
        }
        View childAt2 = viewGroup.getChildAt(0);
        if (childAt2 instanceof TopGestureLayout) {
            return (TopGestureLayout) childAt2;
        }
        return null;
    }

    private List<MessageRecord> zh(List<MessageRecord> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(list);
        HashSet hashSet = new HashSet();
        for (int size = arrayList2.size() - 1; size >= 0; size--) {
            if (hashSet.contains(ao.d((MessageRecord) arrayList2.get(size)))) {
                arrayList.add((MessageRecord) arrayList2.get(size));
            } else {
                hashSet.add(ao.d((MessageRecord) arrayList2.get(size)));
            }
        }
        arrayList2.removeAll(arrayList);
        Collections.reverse(arrayList2);
        return arrayList2;
    }

    protected boolean Gh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this)).booleanValue();
        }
        int i3 = this.P;
        if (i3 != 0 && i3 != 1) {
            return true;
        }
        return false;
    }

    protected void Ih(List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) list);
        } else {
            this.S = zh(list);
        }
    }

    protected void Kh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        MqqHandler mqqHandler = this.Q;
        if (mqqHandler != null) {
            mqqHandler.removeMessages(0);
            this.Q.sendEmptyMessage(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, layoutInflater, viewGroup, bundle);
            return;
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        this.V = ThemeUtil.isDefaultOrDIYTheme(false);
        FPSSwipListView fPSSwipListView = (FPSSwipListView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.ebs);
        this.I = fPSSwipListView;
        try {
            fPSSwipListView.setBackgroundResource(R.drawable.bg_texture_theme_version2);
        } catch (Throwable th5) {
            QLog.e("MatchChatMsgListFragment", 1, th5, new Object[0]);
        }
        DragFrameLayout e16 = DragFrameLayout.e(this.D);
        this.J = e16;
        e16.addOnDragModeChangeListener(this, false);
        LinearLayout linearLayout = new LinearLayout(this.D);
        this.G = linearLayout;
        linearLayout.setOrientation(1);
        this.G.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        this.I.addHeaderView(this.G, 0);
        View inflate = layoutInflater.inflate(R.layout.f167783hc, (ViewGroup) null);
        this.H = inflate;
        inflate.setVisibility(8);
        this.I.addFooterView(this.H);
        this.I.setRightIconMenuListener(this);
        this.I.setOnScrollListener(this);
        this.Q = new ad(ThreadManagerV2.getSubThreadLooper(), this);
        this.R = new ad(this.D.getMainLooper(), this.f243765i0);
        this.C.addObserver(this.f243764h0, true);
        this.C.addObserver(this.f243763g0, true);
        this.C.getMessageFacade().addObserver(this);
        if (QLog.isColorLevel()) {
            this.N = System.currentTimeMillis();
        }
        initTitleBar();
        Fh();
        Dh(layoutInflater);
        Eh(this.Y);
        com.tencent.mobileqq.qqexpand.network.e eVar = (com.tencent.mobileqq.qqexpand.network.e) this.C.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
        if (eVar != null) {
            eVar.q1(false);
        }
        wh(((IphoneTitleBarFragment) this).mContentView);
    }

    @Override // com.tencent.mobileqq.dating.g
    public void enableFlingRight(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
            return;
        }
        TopGestureLayout topGestureLayout = this.K;
        if (topGestureLayout != null) {
            topGestureLayout.setInterceptTouchFlag(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return R.layout.f168801cb3;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int size;
        int i3;
        boolean z16;
        List<MessageRecord> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) message)).booleanValue();
        }
        int i16 = message.what;
        int i17 = 50;
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 == 2) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MatchChatMsgListFragment", 2, "handleMessage MSG_RELOAD_CURRENT_LIST");
                    }
                    List<MessageRecord> list2 = this.S;
                    if (list2 != null) {
                        list2.subList(0, this.U);
                    }
                }
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                int i18 = this.U;
                if (i18 > 0 && (list = this.S) != null) {
                    int i19 = i18 - 1;
                    int size2 = list.size();
                    int i26 = size2 - this.U;
                    if (i26 > 0) {
                        if (i26 > 50) {
                            this.T = true;
                        } else {
                            this.T = false;
                            i17 = i26;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("MatchChatMsgListFragment", 2, String.format(Locale.getDefault(), "MSG_LOAD_NEXT_PAGE totalCount: %s, loadCount: %s", Integer.valueOf(size2), Integer.valueOf(i17)));
                        }
                        this.S.subList(0, i19 + 1 + i17);
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("MatchChatMsgListFragment", 2, String.format(Locale.getDefault(), "MSG_LOAD_NEXT_PAGE cost: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
                }
            }
        } else {
            long currentTimeMillis2 = System.currentTimeMillis();
            List<MessageRecord> D = this.C.getMessageFacade().D(this.F, this.E, null);
            this.S = D;
            if (D == null) {
                this.S = new ArrayList();
            }
            Ih(this.S);
            if (QLog.isDevelopLevel()) {
                QLog.d("MatchChatMsgListFragment", 4, String.format(Locale.getDefault(), "MSG_REFRESH_LIST_GLOBAL cloneMsgBoxList cost: %s ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)));
            }
            xh(this.S);
            List<MessageRecord> list3 = this.S;
            if (list3 == null) {
                size = 0;
            } else {
                size = list3.size();
            }
            if (size <= 50) {
                i3 = size;
            } else {
                i3 = 50;
            }
            int i27 = this.U;
            if (i27 > i3 && i27 <= size) {
                i3 = i27;
            }
            if (i3 > 50) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.T = z16;
            if (QLog.isColorLevel()) {
                QLog.d("MatchChatMsgListFragment", 2, String.format(Locale.getDefault(), "MSG_REFRESH_LIST_GLOBAL totalCount: %s, loadCount: %s, curItemCount: %s", Integer.valueOf(size), Integer.valueOf(i3), Integer.valueOf(this.U)));
            }
            new LinkedList();
            List<MessageRecord> list4 = this.S;
            if (list4 != null && size > 0) {
                list4.subList(0, i3);
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.quibadge.QUIBadgeDragLayout.OnDragModeChangedListener
    public void onChange(boolean z16, int i3, QUIBadgeDragLayout qUIBadgeDragLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Boolean.valueOf(z16), Integer.valueOf(i3), qUIBadgeDragLayout);
        } else if (this.J.getMode() == -1) {
            Kh();
            ((com.tencent.mobileqq.qqexpand.network.e) this.C.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).updateRedPoint();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) view);
        } else if (view.getId() == R.id.m2f) {
            ProfileActivity.G2(getActivity(), new AllInOne(this.C.getCurrentAccountUin(), 0), 1031);
            ReportController.o(this.C, "dc00898", "", "", "0X800A697", "0X800A697", 0, 0, "", "", "", "");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        this.f243760d0 = SystemClock.elapsedRealtime();
        BaseActivity baseActivity = getBaseActivity();
        this.D = baseActivity;
        QQAppInterface qQAppInterface = (QQAppInterface) baseActivity.getAppInterface();
        this.C = qQAppInterface;
        qQAppInterface.addObserver(this.f243762f0);
        this.f243761e0 = (com.tencent.mobileqq.qqexpand.manager.e) this.C.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.E = arguments.getInt("uintype", -1);
            this.F = arguments.getString("uin", "");
        }
        if (!ao.z(this.F, this.E)) {
            this.E = 1044;
            this.F = AppConstants.MATCH_CHAT_UIN;
        }
        Hh(arguments);
        if (QLog.isDevelopLevel()) {
            QLog.i("MatchChatMsgListFragment", 4, String.format(Locale.getDefault(), "onCreate [type: %s, uin: %s]", Integer.valueOf(this.E), this.F));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.onDestroyView();
        this.Q.removeCallbacksAndMessages(null);
        this.R.removeCallbacksAndMessages(null);
        QQAppInterface qQAppInterface = this.C;
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(this.f243764h0);
            this.C.removeObserver(this.f243763g0);
            this.C.removeObserver(this.f243762f0);
            if (this.C.getMessageFacade() != null) {
                this.C.getMessageFacade().deleteObserver(this);
            }
        }
        Lh();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onPause();
        DragFrameLayout dragFrameLayout = this.J;
        if (dragFrameLayout != null) {
            dragFrameLayout.onPause();
        }
        Lh();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onResume();
        Kh();
        Jh();
        this.P = 0;
        this.f243760d0 = SystemClock.elapsedRealtime();
        ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("expose#message_page#view", true, -1L, -1L, null, true, true);
    }

    @Override // com.tencent.widget.SwipListView.RightIconMenuListener
    public void onRightIconMenuHide(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) view);
            return;
        }
        TopGestureLayout topGestureLayout = this.K;
        if (topGestureLayout != null) {
            topGestureLayout.setInterceptTouchFlag(true);
        }
    }

    @Override // com.tencent.widget.SwipListView.RightIconMenuListener
    public void onRightIconMenuShow(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) view);
            return;
        }
        TopGestureLayout topGestureLayout = this.K;
        if (topGestureLayout != null) {
            topGestureLayout.setInterceptTouchFlag(false);
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        boolean z16;
        MqqHandler mqqHandler;
        MqqHandler mqqHandler2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) absListView, i3);
            return;
        }
        if (absListView == null) {
            return;
        }
        if (absListView.getCount() - 1 == absListView.getLastVisiblePosition()) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.P = i3;
        if (i3 == 0 && this.M && (mqqHandler2 = this.Q) != null) {
            mqqHandler2.removeMessages(0);
            this.Q.sendEmptyMessage(0);
        }
        if (z16 && (mqqHandler = this.Q) != null) {
            mqqHandler.sendEmptyMessage(1);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onStart();
        TopGestureLayout yh5 = yh();
        this.K = yh5;
        if (yh5 != null) {
            yh5.setInterceptScrollRLFlag(false);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            super.onStop();
            ((com.tencent.mobileqq.qqexpand.network.e) this.C.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).updateRedPoint();
        }
    }

    protected boolean uh(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this, (Object) str)).booleanValue();
        }
        return false;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) observable, obj);
            return;
        }
        if (obj instanceof MessageRecord) {
            MessageRecord messageRecord = (MessageRecord) obj;
            if (!((ILimitChatUtils) QRoute.api(ILimitChatUtils.class)).isExtendMatchChatMsg(messageRecord)) {
                return;
            }
            if (!this.W && !TextUtils.isEmpty(messageRecord.senderuin) && !messageRecord.senderuin.equals(this.C.getCurrentAccountUin())) {
                long longValue = Long.valueOf(messageRecord.senderuin).longValue();
                this.W = (!Ah(this.S).contains(Long.valueOf(longValue))) | this.W;
            }
            Kh();
        }
    }
}
