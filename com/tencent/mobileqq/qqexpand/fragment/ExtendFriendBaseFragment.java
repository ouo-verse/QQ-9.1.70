package com.tencent.mobileqq.qqexpand.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qqexpand.bean.profile.ExtendFriendInfo;
import com.tencent.mobileqq.qqexpand.chat.ExtendFriendSendMsgHelper;
import com.tencent.mobileqq.qqexpand.entrance.IExpandFragmentRouter;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.qqexpand.utils.IExpandQuestionUtils;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qqexpand.utils.q;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.extras.PullToRefreshRecyclerView;
import com.tencent.mobileqq.qqexpand.widget.voice.ExpandVoicePlayer;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.adv.extfriend.api.IVasAdExtendFriendApi;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.NearbyZanAnimLayout;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.httpcore.message.TokenParser;
import yg2.g;
import yg2.j;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ExtendFriendBaseFragment extends ExpandTabFragment implements DecodeTaskCompletionListener, yg2.d, f, g.c, ExpandVoicePlayer.b, Handler.Callback {

    /* renamed from: v0, reason: collision with root package name */
    protected static final Object f263622v0 = new Object();

    /* renamed from: w0, reason: collision with root package name */
    protected static final Object f263623w0 = new Object();

    /* renamed from: x0, reason: collision with root package name */
    private static boolean f263624x0 = false;
    protected Map<ImageView, String> D;
    protected IFaceDecoder F;
    protected QBaseActivity G;
    protected QQAppInterface H;
    protected CardHandler I;
    protected com.tencent.mobileqq.qqexpand.network.e J;
    protected com.tencent.mobileqq.qqexpand.manager.e K;
    protected com.tencent.mobileqq.qqexpand.fragment.d L;
    protected PullToRefreshRecyclerView M;
    protected LinearLayoutManager N;
    protected RecyclerView P;
    protected RecyclerView.AdapterDataObserver Q;
    protected e R;
    protected WeakReferenceHandler S;
    protected ExpandVoicePlayer T;
    protected long X;
    protected boolean Y;
    protected boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    protected boolean f263625a0;

    /* renamed from: b0, reason: collision with root package name */
    protected QQToast f263626b0;

    /* renamed from: c0, reason: collision with root package name */
    protected String f263627c0;

    /* renamed from: d0, reason: collision with root package name */
    protected int f263628d0;

    /* renamed from: e0, reason: collision with root package name */
    protected int f263629e0;

    /* renamed from: f0, reason: collision with root package name */
    protected NearbyZanAnimLayout f263630f0;

    /* renamed from: g0, reason: collision with root package name */
    protected com.tencent.mobileqq.hotchat.ui.c f263631g0;

    /* renamed from: h0, reason: collision with root package name */
    protected int f263632h0;

    /* renamed from: i0, reason: collision with root package name */
    protected int f263633i0;

    /* renamed from: j0, reason: collision with root package name */
    protected Dialog f263634j0;

    /* renamed from: k0, reason: collision with root package name */
    protected ActionSheet f263635k0;

    /* renamed from: m0, reason: collision with root package name */
    protected long f263637m0;

    /* renamed from: r0, reason: collision with root package name */
    private int f263642r0;
    protected Map<String, Integer> E = new HashMap();
    protected int U = -1;
    protected int V = -1;
    protected int W = -1;

    /* renamed from: l0, reason: collision with root package name */
    protected String f263636l0 = "\u63a8\u8350";

    /* renamed from: n0, reason: collision with root package name */
    protected long f263638n0 = 2;

    /* renamed from: o0, reason: collision with root package name */
    protected boolean f263639o0 = false;

    /* renamed from: p0, reason: collision with root package name */
    protected String f263640p0 = null;

    /* renamed from: q0, reason: collision with root package name */
    protected long f263641q0 = -1;

    /* renamed from: s0, reason: collision with root package name */
    private final ConcurrentHashMap<String, d> f263643s0 = new ConcurrentHashMap<>();

    /* renamed from: t0, reason: collision with root package name */
    private final Runnable f263644t0 = new Runnable() { // from class: com.tencent.mobileqq.qqexpand.fragment.ExtendFriendBaseFragment.1
        @Override // java.lang.Runnable
        public void run() {
            ExtendFriendBaseFragment extendFriendBaseFragment;
            QBaseActivity qBaseActivity;
            com.tencent.mobileqq.qqexpand.fragment.d dVar = ExtendFriendBaseFragment.this.L;
            if (dVar == null || dVar.v() <= 0 || (qBaseActivity = (extendFriendBaseFragment = ExtendFriendBaseFragment.this).G) == null || extendFriendBaseFragment.N == null || extendFriendBaseFragment.H == null || qBaseActivity.isFinishing()) {
                return;
            }
            ArrayList yh5 = ExtendFriendBaseFragment.this.yh();
            ArrayList arrayList = new ArrayList();
            Iterator it = yh5.iterator();
            while (it.hasNext()) {
                arrayList.add(((d) it.next()).f263656d.mUin);
            }
            for (String str : ExtendFriendBaseFragment.this.f263643s0.keySet()) {
                if (!arrayList.contains(str)) {
                    ExtendFriendBaseFragment.this.f263643s0.remove(str);
                }
            }
            Iterator it5 = yh5.iterator();
            while (it5.hasNext()) {
                d dVar2 = (d) it5.next();
                String str2 = dVar2.f263656d.mUin;
                if (!ExtendFriendBaseFragment.this.f263643s0.containsKey(str2)) {
                    dVar2.f263653a = System.currentTimeMillis();
                    ExtendFriendBaseFragment.this.f263643s0.put(str2, dVar2);
                }
            }
            QLog.d("ExtendFriendBaseFragment", 2, new Object[0]);
        }
    };

    /* renamed from: u0, reason: collision with root package name */
    private final ExpandObserver f263645u0 = new a();

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a extends ExpandObserver {
        a() {
        }

        @Override // com.tencent.mobileqq.qqexpand.network.ExpandObserver
        protected void i(boolean z16, com.tencent.mobileqq.qqexpand.bean.feed.b bVar, int i3) {
            Card r16;
            if (i3 == ExtendFriendBaseFragment.this.f263642r0 && z16 && bVar != null && (r16 = ((FriendsManager) ExtendFriendBaseFragment.this.H.getManager(QQManagerFactory.FRIENDS_MANAGER)).r(ExtendFriendBaseFragment.this.H.getCurrentUin())) != null) {
                ExtendFriendBaseFragment.this.Y = !TextUtils.isEmpty(bVar.mDeclaration);
                ExtendFriendBaseFragment.this.Z = r16.isShowCard;
                if (QLog.isColorLevel()) {
                    QLog.d("ExtendFriendBaseFragment", 2, String.format("addMyFeed mProfileComplete=%s mShowCard=%s", Boolean.valueOf(ExtendFriendBaseFragment.this.Y), Boolean.valueOf(ExtendFriendBaseFragment.this.Z)));
                }
                com.tencent.mobileqq.qqexpand.fragment.d dVar = ExtendFriendBaseFragment.this.L;
                if (dVar != null) {
                    com.tencent.mobileqq.qqexpand.bean.feed.b u16 = dVar.u(0);
                    bVar.mIsMyFeed = true;
                    if (u16 != null && TextUtils.equals(u16.mUin, bVar.mUin)) {
                        ExtendFriendBaseFragment.this.L.remove(0);
                    }
                    ExtendFriendBaseFragment.this.L.p(0, bVar);
                    if (!TextUtils.isEmpty(bVar.mDeclaration)) {
                        bVar.mDeclaration = bVar.mDeclaration.replace('\n', TokenParser.SP).trim();
                    }
                    ExtendFriendBaseFragment extendFriendBaseFragment = ExtendFriendBaseFragment.this;
                    if (!extendFriendBaseFragment.Z || !extendFriendBaseFragment.Y) {
                        extendFriendBaseFragment.L.remove(0);
                    }
                    ExtendFriendBaseFragment.this.L.notifyDataSetChanged();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class b implements com.tencent.mobileqq.qqexpand.chat.e {
        b() {
        }

        @Override // com.tencent.mobileqq.qqexpand.chat.e
        public void enterAio(String str, String str2) {
            ExtendFriendSendMsgHelper.d(ExtendFriendBaseFragment.this.G, str, str2);
        }

        @Override // com.tencent.mobileqq.qqexpand.chat.e
        public void showMatchCountDialog() {
            ExtendFriendSendMsgHelper.k(ExtendFriendBaseFragment.this.G);
        }

        @Override // com.tencent.mobileqq.qqexpand.chat.e
        public void showToast(int i3) {
            QBaseActivity qBaseActivity = ExtendFriendBaseFragment.this.G;
            if (qBaseActivity == null) {
                QLog.d("ExtendFriendBaseFragment", 1, "sendMsgDirectly()-> showToast() mActivity is null just return");
            } else {
                ExtendFriendSendMsgHelper.l(qBaseActivity, qBaseActivity.getString(i3));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public long f263653a;

        /* renamed from: b, reason: collision with root package name */
        public String f263654b;

        /* renamed from: c, reason: collision with root package name */
        public int f263655c;

        /* renamed from: d, reason: collision with root package name */
        public com.tencent.mobileqq.qqexpand.bean.feed.b f263656d;

        d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<d> yh() {
        com.tencent.mobileqq.qqexpand.bean.feed.b u16;
        ArrayList<d> arrayList = new ArrayList<>();
        try {
            int findFirstCompletelyVisibleItemPosition = this.N.findFirstCompletelyVisibleItemPosition();
            int findLastCompletelyVisibleItemPosition = this.N.findLastCompletelyVisibleItemPosition();
            if (findFirstCompletelyVisibleItemPosition >= 0 && findFirstCompletelyVisibleItemPosition < this.N.getItemCount() && findLastCompletelyVisibleItemPosition >= 0 && findLastCompletelyVisibleItemPosition < this.N.getItemCount() && findFirstCompletelyVisibleItemPosition <= findLastCompletelyVisibleItemPosition) {
                while (findFirstCompletelyVisibleItemPosition <= findLastCompletelyVisibleItemPosition) {
                    if (this.L.getItemViewType(findFirstCompletelyVisibleItemPosition) == 0 && (u16 = this.L.u(findFirstCompletelyVisibleItemPosition)) != null) {
                        d dVar = new d();
                        dVar.f263654b = this.f263636l0;
                        dVar.f263655c = findFirstCompletelyVisibleItemPosition;
                        dVar.f263656d = u16;
                        arrayList.add(dVar);
                    }
                    findFirstCompletelyVisibleItemPosition++;
                }
            }
        } catch (Throwable th5) {
            QLog.i("ExtendFriendBaseFragment", 1, "findCurrentVisibleItems fail.", th5);
        }
        return arrayList;
    }

    protected int Ah() {
        return 0;
    }

    protected int Bh() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ch(String str, int i3) {
        if (this.G != null) {
            if (this.f263626b0 == null) {
                this.f263626b0 = new QQToast(this.G);
            }
            if (this.f263626b0.isShowing() && TextUtils.equals(this.f263627c0, str) && this.f263628d0 == i3) {
                return;
            }
            this.f263626b0.setToastIcon(QQToast.getIconRes(i3));
            this.f263626b0.setType(i3);
            this.f263626b0.setToastMsg(str);
            this.f263626b0.setDuration(0);
            this.f263626b0.show(this.G.getTitleBarHeight());
            this.f263627c0 = str;
            this.f263628d0 = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Dh() {
        synchronized (f263623w0) {
            if (this.I != null) {
                long longValue = Long.valueOf(this.H.getCurrentAccountUin()).longValue();
                for (String str : this.E.keySet()) {
                    int intValue = this.E.get(str).intValue();
                    if (intValue > 0) {
                        this.I.Q4(longValue, Long.valueOf(str).longValue(), null, 53, intValue, 0);
                    }
                }
            }
            this.E.clear();
        }
    }

    public boolean Fh() {
        if (!((IExpandQuestionUtils) QRoute.api(IExpandQuestionUtils.class)).needAnswerQuestion(this.H.getCurrentAccountUin())) {
            return false;
        }
        QBaseActivity qBaseActivity = this.G;
        if (qBaseActivity == null) {
            return true;
        }
        if (this.f263634j0 == null) {
            this.f263634j0 = q.b(qBaseActivity);
        }
        if (this.f263634j0.isShowing() || this.G.isFinishing()) {
            return true;
        }
        this.f263634j0.show();
        return true;
    }

    public void Gh(boolean z16, boolean z17, RecyclerView.ViewHolder viewHolder) {
        int i3;
        int i16;
        ExtendFriendInfo extendFriendInfo = new ExtendFriendInfo(((FriendsManager) this.H.getManager(QQManagerFactory.FRIENDS_MANAGER)).q(this.H.getCurrentAccountUin()));
        if (viewHolder == null || !(viewHolder instanceof j)) {
            i3 = 0;
            i16 = 0;
        } else {
            j jVar = (j) viewHolder;
            i3 = jVar.d();
            i16 = jVar.c();
        }
        if (z16) {
            extendFriendInfo.D = i3;
            extendFriendInfo.F = true;
        }
        if (z17) {
            extendFriendInfo.E = i16;
            extendFriendInfo.G = true;
        }
        Intent intent = new Intent();
        intent.putExtra(IExpandFragmentRouter.KEY_EXTEND_FRIEND_INFO, extendFriendInfo);
        ((IExpandFragmentRouter) QRoute.api(IExpandFragmentRouter.class)).launchExpandEditFragmentForResult(this.G, intent, 4097);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Hh(boolean z16) {
        com.tencent.mobileqq.qqexpand.fragment.d dVar = this.L;
        if (dVar == null || dVar.v() <= 0 || this.G == null || this.N == null || this.H == null) {
            return;
        }
        this.S.removeCallbacks(this.f263644t0);
        if (z16) {
            this.S.postDelayed(this.f263644t0, 500L);
        } else {
            this.f263644t0.run();
        }
    }

    public void Ih() {
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendBaseFragment", 2, String.format("stopLastVoice mLastPlayVoicePos=%s", Integer.valueOf(this.U)));
        }
        if (this.U >= 0) {
            ExpandVoicePlayer expandVoicePlayer = this.T;
            if (expandVoicePlayer != null) {
                expandVoicePlayer.k();
            }
            RecyclerView.ViewHolder findViewHolderForPosition = this.P.findViewHolderForPosition(this.U);
            if (findViewHolderForPosition != null && (findViewHolderForPosition instanceof j)) {
                j jVar = (j) findViewHolderForPosition;
                if (jVar.G.i()) {
                    jVar.G.o();
                }
            }
            this.U = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Jh() {
        com.tencent.mobileqq.qqexpand.bean.feed.b u16;
        Card r16;
        short s16;
        int i3 = this.W;
        if (i3 < 0 || (u16 = this.L.u(i3)) == null || (r16 = ((FriendsManager) this.H.getManager(QQManagerFactory.FRIENDS_MANAGER)).r(u16.mUin)) == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendBaseFragment", 2, String.format("syncLikeStatus bVoted=%s bAvailVoteCnt=%s mAvailLikeCount=%s", Byte.valueOf(r16.bVoted), Short.valueOf(r16.bAvailVoteCnt), Integer.valueOf(u16.mAvailLikeCount)));
        }
        if (r16.bVoted <= 0 || (s16 = r16.bAvailVoteCnt) >= u16.mAvailLikeCount) {
            return;
        }
        u16.mLiked = true;
        u16.mAvailLikeCount = s16;
        this.L.notifyItemChanged(this.W);
    }

    @Override // yg2.d
    public Drawable K7(String str, String str2, ImageView imageView) {
        Bitmap bitmapFromCache;
        IFaceDecoder iFaceDecoder;
        synchronized (f263622v0) {
            IFaceDecoder iFaceDecoder2 = this.F;
            bitmapFromCache = iFaceDecoder2 != null ? iFaceDecoder2.getBitmapFromCache(1, str) : null;
            if (bitmapFromCache == null) {
                if (!this.f263625a0) {
                    if (imageView != null) {
                        imageView.setTag(R.id.f166942ja3, str);
                    }
                    if (this.D != null && (iFaceDecoder = this.F) != null) {
                        iFaceDecoder.requestDecodeFace(str, 1, true);
                        if (QLog.isColorLevel()) {
                            QLog.d("ExtendFriendBaseFragment", 2, String.format("requestDecodeFace uin=%s nick=%s", str, str2));
                        }
                    }
                    Map<ImageView, String> map = this.D;
                    if (map != null && imageView != null) {
                        map.put(imageView, str);
                    }
                }
            } else {
                Map<ImageView, String> map2 = this.D;
                if (map2 != null && imageView != null) {
                    map2.remove(imageView);
                }
            }
        }
        if (bitmapFromCache == null) {
            bitmapFromCache = BaseImageUtil.getDefaultFaceBitmap();
        }
        return new BitmapDrawable(bitmapFromCache);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Kh(boolean z16, boolean z17) {
        Card r16;
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendBaseFragment", 2, String.format("syncSwitchStatus syncProfileComplete=%s syncShowCard=%s", Boolean.valueOf(z16), Boolean.valueOf(z17)));
        }
        if ((z16 || z17) && (r16 = ((FriendsManager) this.H.getManager(QQManagerFactory.FRIENDS_MANAGER)).r(this.H.getCurrentUin())) != null) {
            if (z16) {
                this.Y = !TextUtils.isEmpty(r16.declaration);
            }
            if (z17) {
                this.Z = r16.isShowCard;
            }
        }
    }

    protected void Lh(int i3) {
        com.tencent.mobileqq.qqexpand.bean.feed.b u16;
        ExpandVoicePlayer expandVoicePlayer;
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendBaseFragment", 2, String.format("toggleVoice position=%s", Integer.valueOf(i3)));
        }
        RecyclerView.ViewHolder findViewHolderForPosition = this.P.findViewHolderForPosition(i3);
        if (findViewHolderForPosition == null || !(findViewHolderForPosition instanceof j)) {
            return;
        }
        j jVar = (j) findViewHolderForPosition;
        if (jVar.G.i()) {
            jVar.G.o();
            ExpandVoicePlayer expandVoicePlayer2 = this.T;
            if (expandVoicePlayer2 != null) {
                expandVoicePlayer2.k();
            }
            this.U = -1;
            return;
        }
        jVar.G.n();
        com.tencent.mobileqq.qqexpand.fragment.d dVar = this.L;
        if (dVar != null && (u16 = dVar.u(i3)) != null && !TextUtils.isEmpty(u16.mVoiceUrl) && (expandVoicePlayer = this.T) != null) {
            expandVoicePlayer.i(u16.mVoiceUrl);
        }
        this.U = i3;
    }

    @Override // com.tencent.mobileqq.qqexpand.fragment.f
    public int M4() {
        return this.U;
    }

    @Override // com.tencent.mobileqq.qqexpand.fragment.f
    public void M5() {
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendBaseFragment", 2, String.format("onFooterItemClick", new Object[0]));
        }
        Eh(true);
        this.L.B(0, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Mh() {
        LinearLayoutManager linearLayoutManager = this.N;
        if (linearLayoutManager == null || this.L == null) {
            return;
        }
        int findLastVisibleItemPosition = this.N.findLastVisibleItemPosition();
        for (int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition(); findFirstVisibleItemPosition <= findLastVisibleItemPosition; findFirstVisibleItemPosition++) {
            com.tencent.mobileqq.qqexpand.bean.feed.b u16 = this.L.u(findFirstVisibleItemPosition);
            RecyclerView.ViewHolder findViewHolderForPosition = this.P.findViewHolderForPosition(findFirstVisibleItemPosition);
            if (u16 != null && findViewHolderForPosition != null && (findViewHolderForPosition instanceof j)) {
                j jVar = (j) findViewHolderForPosition;
                jVar.f450299f.setImageDrawable(K7(u16.mUin, u16.mNickName, jVar.f450299f));
            }
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.fragment.f
    public long Oc() {
        return this.X;
    }

    @Override // com.tencent.mobileqq.qqexpand.fragment.f
    public void P9(long j3) {
        this.X = j3;
    }

    @Override // com.tencent.mobileqq.qqexpand.fragment.f
    public void X6(int i3) {
        com.tencent.mobileqq.qqexpand.fragment.d dVar = this.L;
        if (dVar != null) {
            dVar.remove(i3);
            this.L.notifyDataSetChanged();
            QLog.i("ExtendFriendBaseFragment", 1, "@gdtadv onClickFeedBackHideAdv");
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.voice.ExpandVoicePlayer.b
    public void a1(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendBaseFragment", 2, String.format("onFocusChanged focused=%s", Boolean.valueOf(z16)));
        }
        if (z16) {
            return;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.fragment.ExtendFriendBaseFragment.7
            @Override // java.lang.Runnable
            public void run() {
                ExtendFriendBaseFragment.this.Ih();
            }
        });
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 10) {
            return true;
        }
        Dh();
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        QBaseActivity qBaseActivity = getQBaseActivity();
        this.G = qBaseActivity;
        QQAppInterface qQAppInterface = (QQAppInterface) qBaseActivity.getAppRuntime();
        this.H = qQAppInterface;
        this.J = (com.tencent.mobileqq.qqexpand.network.e) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
        this.I = (CardHandler) this.H.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
        this.K = (com.tencent.mobileqq.qqexpand.manager.e) this.H.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
        IFaceDecoder iQQAvatarService = ((IQQAvatarService) this.H.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.H);
        this.F = iQQAvatarService;
        iQQAvatarService.setDecodeTaskCompletionListener(this);
        this.D = new HashMap();
        this.f263631g0 = new com.tencent.mobileqq.hotchat.ui.c(this.G);
        this.f263632h0 = BaseAIOUtils.f(17.5f, getResources());
        this.f263633i0 = BaseAIOUtils.f(7.0f, getResources());
        this.T = new ExpandVoicePlayer(this, this.G);
        this.S = new WeakReferenceHandler(ThreadManagerV2.getSubThreadLooper(), this);
        if (this.K.e() != null) {
            this.f263638n0 = r3.exposureTimeLimit;
        }
        this.H.addObserver(this.f263645u0);
        ((IVasAdExtendFriendApi) QRoute.api(IVasAdExtendFriendApi.class)).initDeviceInfo();
    }

    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendBaseFragment", 2, String.format("onDecodeTaskCompleted uin=%s avatar=%s", str, bitmap));
        }
        synchronized (f263622v0) {
            Iterator<Map.Entry<ImageView, String>> it = this.D.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<ImageView, String> next = it.next();
                ImageView key = next.getKey();
                String value = next.getValue();
                if (value != null && value.equals(str)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ExtendFriendBaseFragment", 2, String.format("responseDecodeFace hit cache uin=%s avatar=%s", str, bitmap));
                    }
                    Object tag = key.getTag(R.id.f166942ja3);
                    if (TextUtils.equals(str, (tag == null || !(tag instanceof String)) ? null : (String) tag)) {
                        key.setImageDrawable(new BitmapDrawable(bitmap));
                    }
                    it.remove();
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        uh();
        IFaceDecoder iFaceDecoder = this.F;
        if (iFaceDecoder != null) {
            iFaceDecoder.setDecodeTaskCompletionListener(null);
            this.F.destory();
            this.F = null;
        }
        Map<ImageView, String> map = this.D;
        if (map != null) {
            map.clear();
            this.D = null;
        }
        this.S.removeCallbacksAndMessages(null);
        QQAppInterface qQAppInterface = this.H;
        if (qQAppInterface != null) {
            ExtendFriendSendMsgHelper e16 = ExtendFriendSendMsgHelper.e(qQAppInterface);
            if (e16 != null) {
                e16.c();
            }
            this.H.removeObserver(this.f263645u0);
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.voice.ExpandVoicePlayer.b
    public void onDownloadFailed(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendBaseFragment", 2, String.format("onDownloadFailed errCode=%s", Integer.valueOf(i3)));
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.fragment.ExtendFriendBaseFragment.6
            @Override // java.lang.Runnable
            public void run() {
                ExtendFriendBaseFragment.this.Ih();
            }
        });
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.voice.ExpandVoicePlayer.b
    public void onDownloadFinish(File file) {
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendBaseFragment", 2, String.format("onDownloadFinish path=%s", file.getAbsoluteFile()));
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        Ih();
        xh();
        vh();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ExtendFriendReport.r(this.H, "");
        ExtendFriendReport.p();
        uh();
        Hh(true);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.S.hasMessages(10)) {
            this.S.removeMessages(10);
            Dh();
        }
    }

    public void th() {
        this.f263642r0 = ((com.tencent.mobileqq.qqexpand.network.e) this.H.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).l1(this.H.getCurrentUin(), true);
    }

    @Override // com.tencent.mobileqq.utils.VoicePlayer.a
    public void u4(int i3, String str, int i16) {
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendBaseFragment", 2, String.format("playerCompletion path=%s", str));
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.fragment.ExtendFriendBaseFragment.5
            @Override // java.lang.Runnable
            public void run() {
                ExtendFriendBaseFragment.this.Ih();
                ExpandVoicePlayer expandVoicePlayer = ExtendFriendBaseFragment.this.T;
                if (expandVoicePlayer != null) {
                    expandVoicePlayer.a();
                }
            }
        });
    }

    protected void uh() {
        if (!this.f263639o0 || TextUtils.isEmpty(this.f263640p0) || this.f263641q0 <= 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f263641q0;
        if (currentTimeMillis > 0 && currentTimeMillis < 3600000) {
            ReportController.o(this.H, "dc00898", "", this.f263640p0, "0X8009C71", "0X8009C71", 0, 0, String.valueOf(currentTimeMillis), "", "", this.f263636l0);
        }
        this.f263639o0 = false;
        this.f263640p0 = null;
        this.f263641q0 = -1L;
    }

    protected void vh() {
        this.f263643s0.clear();
    }

    public void wh(int i3) {
        j jVar = (j) this.P.findViewHolderForPosition(i3);
        if (jVar == null) {
            return;
        }
        jVar.D.getLocationInWindow(new int[2]);
        NearbyZanAnimLayout nearbyZanAnimLayout = this.f263630f0;
        nearbyZanAnimLayout.d(this.f263631g0.a(3, nearbyZanAnimLayout.f236900h).c(), r0[0] + jVar.D.getPaddingLeft() + this.f263632h0, (r0[1] - this.f263629e0) + jVar.D.getPaddingTop() + this.f263633i0);
    }

    @Override // com.tencent.mobileqq.qqexpand.fragment.f
    public void xd(int i3) {
        boolean z16;
        boolean z17;
        com.tencent.mobileqq.qqexpand.bean.feed.b u16 = this.L.u(i3);
        if (this.G == null || u16 == null) {
            return;
        }
        if (!f263624x0) {
            Card r16 = ((FriendsManager) this.H.getManager(QQManagerFactory.FRIENDS_MANAGER)).r(this.H.getCurrentAccountUin());
            if (r16 != null && r16.declaration == null) {
                ((com.tencent.mobileqq.qqexpand.network.e) this.H.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).l1(this.H.getCurrentAccountUin(), false);
            }
            f263624x0 = false;
        }
        RecyclerView.ViewHolder findViewHolderForPosition = this.P.findViewHolderForPosition(i3);
        if (findViewHolderForPosition == null || !(findViewHolderForPosition instanceof j)) {
            z16 = false;
            z17 = false;
        } else {
            j jVar = (j) findViewHolderForPosition;
            boolean e16 = jVar.e();
            z17 = jVar.f();
            z16 = e16;
        }
        ActionSheet create = ActionSheet.create(this.G);
        this.f263635k0 = create;
        create.addButton(R.string.f169995c2, 3);
        if (!SimpleUIUtil.getSimpleUISwitch()) {
            if (z16) {
                this.f263635k0.addButton(R.string.f225326lb);
            }
            if (z17) {
                this.f263635k0.addButton(R.string.f225336lc);
            }
            if (!z17 && !z16) {
                this.f263635k0.addButton(R.string.f225346ld);
            }
        }
        this.f263635k0.addCancelButton(R.string.cancel);
        this.f263635k0.setOnButtonClickListener(new c(u16, z16, z17, findViewHolderForPosition));
        if (!this.G.isFinishing()) {
            this.f263635k0.show();
        }
        VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "plaza_click", "", 0, "", "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void xh() {
        QBaseActivity qBaseActivity;
        ConcurrentHashMap<String, d> concurrentHashMap = this.f263643s0;
        if (concurrentHashMap == null || concurrentHashMap.isEmpty() || (qBaseActivity = this.G) == null || this.N == null || this.H == null || qBaseActivity.isFinishing()) {
            return;
        }
        for (Map.Entry<String, d> entry : this.f263643s0.entrySet()) {
            String key = entry.getKey();
            d value = entry.getValue();
            if (System.currentTimeMillis() - value.f263653a >= this.f263638n0) {
                this.f263643s0.remove(key);
                ReportController.o(this.H, "dc00898", "", key, "0X8009C6E", "0X8009C6E", 1, 0, "", String.valueOf(value.f263655c + 1), ExtendFriendReport.h(value.f263656d.mStrRecomTrace), String.format("%s_%s", value.f263654b, ExtendFriendReport.f(value.f263656d)));
            }
        }
    }

    public void zh() {
        RecyclerView recyclerView = this.P;
        if (recyclerView != null) {
            recyclerView.smoothScrollToPosition(0);
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.fragment.f
    public void S5(int i3) {
        com.tencent.mobileqq.qqexpand.bean.feed.b u16;
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendBaseFragment", 2, String.format("onFeedVoiceClick position=%s", Integer.valueOf(i3)));
        }
        com.tencent.mobileqq.qqexpand.fragment.d dVar = this.L;
        if (dVar != null && (u16 = dVar.u(i3)) != null) {
            int i16 = i3 + 1;
            ReportController.r(this.H, "dc00898", "", u16.mUin, "0X80092CF", "0X80092CF", (u16.mVoiceDuration / 10) + 1, 0, "", String.valueOf(i16), ExtendFriendReport.h(u16.mStrRecomTrace), this.f263636l0);
            ReportController.r(this.H, "dc00898", "", u16.mUin, "0X8009C70", "0X8009C70", 0, 0, "", String.valueOf(i16), ExtendFriendReport.h(u16.mStrRecomTrace), this.f263636l0);
            ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#feeds_page#kl_voice", true, -1L, -1L, null, true, true);
        }
        if (i3 != this.U) {
            Ih();
        }
        Lh(i3);
    }

    @Override // com.tencent.mobileqq.qqexpand.fragment.f
    public void Vg(int i3, int i16) {
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendBaseFragment", 2, String.format("onFeedItemClick position=%s", Integer.valueOf(i3)));
        }
        com.tencent.mobileqq.qqexpand.bean.feed.b u16 = this.L.u(i3);
        if (u16 != null) {
            ExtendFriendReport.r(this.H, u16.mStrRecomTrace);
            int i17 = i3 + 1;
            ReportController.r(this.H, "dc00898", "", u16.mUin, "0X80092D0", "0X80092D0", 0, 0, "", String.valueOf(i17), ExtendFriendReport.h(u16.mStrRecomTrace), this.f263636l0);
            ReportController.r(this.H, "dc00898", "", u16.mUin, "0X8009C6F", "0X8009C6F", i16, 0, "", String.valueOf(i17), ExtendFriendReport.h(u16.mStrRecomTrace), this.f263636l0);
            ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#voice_tab#profile_photo", true, -1L, -1L, null, true, true);
            AllInOne allInOne = new AllInOne(u16.mUin, 96);
            allInOne.nickname = u16.mNickName;
            allInOne.extendFriendVoiceCode = u16.voiceCode;
            allInOne.subSourceId = 1;
            ProfileActivity.G2(getQBaseActivity(), allInOne, Bh());
            this.W = i3;
            this.f263639o0 = true;
            this.f263640p0 = u16.mUin;
            this.f263641q0 = System.currentTimeMillis();
            ExtendFriendReport.q(2, i3, u16.mStrRecomTrace, this.f263636l0, u16);
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.fragment.f
    public void Zd(int i3) {
        if (this.G == null) {
            if (QLog.isColorLevel()) {
                QLog.d("ExtendFriendBaseFragment", 2, "onFeedSendMsgClick() mActivity is null just return");
            }
        } else {
            com.tencent.mobileqq.qqexpand.bean.feed.b u16 = this.L.u(i3);
            if (u16 != null) {
                ExtendFriendSendMsgHelper.e(this.H).i(this.H, u16.mUin, u16.mNickName, u16.voiceCode, 2, new b());
                ExtendFriendReport.a().n(3, u16.mUin, "", String.valueOf(i3 + 1), ExtendFriendReport.h(u16.mStrRecomTrace), this.f263636l0);
                ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#voice_tab#message_btn", true, -1L, -1L, null, true, true);
            }
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.fragment.f
    public void tc(int i3) {
        String qqStr;
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendBaseFragment", 2, String.format("onFeedLikeClick position=%s", Integer.valueOf(i3)));
        }
        com.tencent.mobileqq.qqexpand.bean.feed.b u16 = this.L.u(i3);
        if (u16 != null) {
            if (u16.mAvailLikeCount > 0) {
                if (NetworkUtil.isNetSupport(this.G)) {
                    u16.mLiked = true;
                    u16.mAvailLikeCount--;
                    ReportController.r(this.H, "dc00898", "", u16.mUin, "0X80092CD", "0X80092CD", 0, 0, "", String.valueOf(i3 + 1), ExtendFriendReport.h(u16.mStrRecomTrace), this.f263636l0);
                    ReportController.n(this.H, "CliOper", "", "", "P_prof", "Prof_good", 9, 1, 0, Integer.toString(53), "1", this.H.getCurrentAccountUin(), u16.mUin);
                    ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#voice_tab#like_btn", true, -1L, -1L, null, true, true);
                    synchronized (f263623w0) {
                        Integer num = this.E.get(u16.mUin);
                        if (num == null) {
                            num = 0;
                        }
                        this.E.put(u16.mUin, Integer.valueOf(num.intValue() + 1));
                        if (!this.S.hasMessages(10)) {
                            Message obtain = Message.obtain();
                            obtain.what = 10;
                            this.S.sendMessageDelayed(obtain, 1000L);
                        }
                    }
                    this.L.notifyItemChanged(i3);
                    wh(i3);
                    return;
                }
                Ch(getString(R.string.ihg), 1);
                return;
            }
            String qqStr2 = HardCodeUtil.qqStr(R.string.mbi);
            Object[] objArr = new Object[2];
            int i16 = u16.mGender;
            if (i16 != 1 && i16 != 2) {
                qqStr = HardCodeUtil.qqStr(R.string.mbm);
            } else if (i16 == 2) {
                qqStr = HardCodeUtil.qqStr(R.string.mbf);
            } else {
                qqStr = HardCodeUtil.qqStr(R.string.may);
            }
            objArr[0] = qqStr;
            objArr[1] = Integer.valueOf(Ah());
            Ch(String.format(qqStr2, objArr), 0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class c implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqexpand.bean.feed.b f263648d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f263649e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f263650f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ RecyclerView.ViewHolder f263651h;

        c(com.tencent.mobileqq.qqexpand.bean.feed.b bVar, boolean z16, boolean z17, RecyclerView.ViewHolder viewHolder) {
            this.f263648d = bVar;
            this.f263649e = z16;
            this.f263650f = z17;
            this.f263651h = viewHolder;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            if (i3 == 0) {
                QBaseActivity qBaseActivity = ExtendFriendBaseFragment.this.G;
                String str = this.f263648d.mUin;
                NewReportPlugin.S(qBaseActivity, str, NewReportPlugin.j(str, NewReportPlugin.p(2)), null, null, ExtendFriendBaseFragment.this.H.getCurrentAccountUin(), 20005, null, null);
                ReportController.o(ExtendFriendBaseFragment.this.H, "dc00898", "", "", "0X8009C8F", "0X8009C8F", 0, 0, "", "", "", "");
                HashMap hashMap = new HashMap();
                hashMap.put("frompage", "3");
                hashMap.put("to_uid", this.f263648d.mUin);
                ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#complaint_page#complaint", true, -1L, -1L, hashMap, true, true);
                com.tencent.mobileqq.qqexpand.network.e eVar = ExtendFriendBaseFragment.this.J;
                if (eVar != null) {
                    eVar.y2(this.f263648d.mUin);
                }
                ActionSheet actionSheet = ExtendFriendBaseFragment.this.f263635k0;
                if (actionSheet != null) {
                    actionSheet.dismiss();
                    ExtendFriendBaseFragment.this.f263635k0 = null;
                    return;
                }
                return;
            }
            boolean z16 = this.f263649e;
            if (!z16 || this.f263650f) {
                if (z16 || !this.f263650f) {
                    boolean z17 = this.f263650f;
                    if (z17 && z16) {
                        if (i3 == 1) {
                            ExtendFriendBaseFragment.this.Gh(false, true, this.f263651h);
                            VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "plaza_actionsheet", "", 0, "", "1");
                        } else if (i3 == 2) {
                            ExtendFriendBaseFragment.this.Gh(true, false, this.f263651h);
                            VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "plaza_actionsheet", "", 0, "", "2");
                        }
                    } else if (!z16 && !z17 && i3 == 1) {
                        ExtendFriendBaseFragment.this.Gh(false, false, this.f263651h);
                        VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "plaza_actionsheet", "", 0, "", "3");
                    }
                } else if (i3 == 1) {
                    ExtendFriendBaseFragment.this.Gh(true, false, this.f263651h);
                    VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "plaza_actionsheet", "", 0, "", "2");
                }
            } else if (i3 == 1) {
                ExtendFriendBaseFragment.this.Gh(false, true, this.f263651h);
                VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "plaza_actionsheet", "", 0, "", "1");
            }
            ExtendFriendBaseFragment.this.f263635k0.cancel();
            VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "plaza_actionsheet", "", 0, "", "4");
        }
    }

    public void Eh(boolean z16) {
    }

    @Override // yg2.g.c
    public void Kg() {
    }

    @Override // com.tencent.mobileqq.qqexpand.fragment.f
    public void n6() {
    }

    @Override // com.tencent.mobileqq.utils.VoicePlayer.a
    public void c5(String str, int i3, int i16) {
    }

    @Override // com.tencent.mobileqq.utils.VoicePlayer.a
    public void ic(String str, int i3, int i16) {
    }
}
