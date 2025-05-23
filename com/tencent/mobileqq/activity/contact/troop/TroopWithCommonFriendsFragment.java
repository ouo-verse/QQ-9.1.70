package com.tencent.mobileqq.activity.contact.troop;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.friend.api.IFriendNameService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.aq;
import com.tencent.mobileqq.widget.OverScrollRecyclerView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.troop.ITroopMemberOperationRepoApi;
import com.tencent.qqnt.troop.i;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes10.dex */
public class TroopWithCommonFriendsFragment extends IphoneTitleBarFragment implements DecodeTaskCompletionListener {
    static IPatchRedirector $redirector_;
    protected static String U;
    static int V;
    private QQAppInterface C;
    private OverScrollRecyclerView D;
    private com.tencent.mobileqq.troop.adapter.a E;
    protected IFaceDecoder F;
    protected com.tencent.mobileqq.model.d G;
    protected int H;
    protected BaseActivity I;
    protected com.tencent.mobileqq.activity.contact.troop.c J;
    protected int K;
    public View L;
    private QQProgressDialog M;
    protected List<com.tencent.mobileqq.activity.contact.troop.a> N;
    View.OnClickListener P;
    View.OnClickListener Q;
    View.OnClickListener R;
    private com.tencent.mobileqq.friends.intimate.d S;
    MqqHandler T;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a extends RecyclerView.OnScrollListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopWithCommonFriendsFragment.this);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) recyclerView, i3);
                return;
            }
            super.onScrollStateChanged(recyclerView, i3);
            TroopWithCommonFriendsFragment.this.H = i3;
            if (i3 == 0) {
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager instanceof LinearLayoutManager) {
                    ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
                }
            }
            IFaceDecoder iFaceDecoder = TroopWithCommonFriendsFragment.this.F;
            if (iFaceDecoder != null) {
                if (i3 != 0) {
                    iFaceDecoder.cancelPendingRequests();
                    TroopWithCommonFriendsFragment.this.F.pause();
                } else if (iFaceDecoder.isPausing()) {
                    TroopWithCommonFriendsFragment.this.F.resume();
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, recyclerView, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                super.onScrolled(recyclerView, i3, i16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b extends com.tencent.mobileqq.troop.adapter.a<com.tencent.mobileqq.activity.contact.troop.a> {
        static IPatchRedirector $redirector_;

        b(Context context, int i3) {
            super(context, i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopWithCommonFriendsFragment.this, context, Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.mobileqq.troop.adapter.a
        protected com.tencent.mobileqq.troop.adapter.base.c Q(Context context, ViewGroup viewGroup, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.mobileqq.troop.adapter.base.c) iPatchRedirector.redirect((short) 2, this, context, viewGroup, Integer.valueOf(i3));
            }
            View inflate = LayoutInflater.from(context).inflate(i3, viewGroup, false);
            com.tencent.mobileqq.activity.contact.troop.b bVar = new com.tencent.mobileqq.activity.contact.troop.b(context, inflate);
            bVar.f181389m = (LinearLayout) inflate.findViewById(R.id.f166592ge0);
            bVar.C = (ImageView) inflate.findViewById(R.id.gdq);
            bVar.D = (TextView) inflate.findViewById(R.id.gdv);
            bVar.E = (TextView) inflate.findViewById(R.id.f166593ge1);
            bVar.F = (Button) inflate.findViewById(R.id.gdz);
            return bVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.troop.adapter.a
        /* renamed from: R, reason: merged with bridge method [inline-methods] */
        public void P(com.tencent.mobileqq.troop.adapter.base.c cVar, com.tencent.mobileqq.activity.contact.troop.a aVar, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                TroopWithCommonFriendsFragment.this.yh(cVar, aVar, i3);
            } else {
                iPatchRedirector.redirect((short) 3, this, cVar, aVar, Integer.valueOf(i3));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopWithCommonFriendsFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.tencent.mobileqq.activity.contact.troop.b bVar;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if ((view.getTag() instanceof com.tencent.mobileqq.activity.contact.troop.b) && (bVar = (com.tencent.mobileqq.activity.contact.troop.b) view.getTag()) != null) {
                Bundle b16 = aq.b(bVar.H, 4);
                b16.putInt("t_s_f", 1002);
                TroopUtils.I(TroopWithCommonFriendsFragment.this.getActivity(), b16, 2);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class d implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopWithCommonFriendsFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.tencent.mobileqq.activity.contact.troop.b bVar;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if ((view.getTag() instanceof com.tencent.mobileqq.activity.contact.troop.b) && (bVar = (com.tencent.mobileqq.activity.contact.troop.b) view.getTag()) != null) {
                Bundle b16 = aq.b(bVar.H, 4);
                b16.putInt("t_s_f", 1002);
                TroopUtils.I(TroopWithCommonFriendsFragment.this.getActivity(), b16, 2);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class e implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopWithCommonFriendsFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.tencent.mobileqq.activity.contact.troop.b bVar;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if ((view.getTag() instanceof com.tencent.mobileqq.activity.contact.troop.b) && (bVar = (com.tencent.mobileqq.activity.contact.troop.b) view.getTag()) != null && h.g(TroopWithCommonFriendsFragment.U, bVar.H)) {
                h.k(TroopWithCommonFriendsFragment.U, bVar.H, false);
                bVar.F.setText(TroopWithCommonFriendsFragment.this.getString(R.string.f2058756s));
                bVar.F.setClickable(false);
                bVar.F.setBackgroundDrawable(null);
                bVar.F.setTextAppearance(TroopWithCommonFriendsFragment.this.I, R.style.f174320vp);
                TroopWithCommonFriendsFragment.this.Eh(bVar.H, TroopWithCommonFriendsFragment.U);
                ReportController.o(null, "dc00898", "", "", "0X800AD26", "0X800AD26", 0, 0, "0", "0", "", "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class f extends com.tencent.mobileqq.friends.intimate.d {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopWithCommonFriendsFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.friends.intimate.d
        protected void onTroopWithCommonFriendsListUpdate(boolean z16, int i3, ArrayList<com.tencent.mobileqq.activity.contact.troop.c> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), arrayList);
                return;
            }
            if (TroopWithCommonFriendsFragment.this.M != null) {
                TroopWithCommonFriendsFragment.this.M.dismiss();
            }
            if (!z16) {
                TroopWithCommonFriendsFragment.this.T.sendEmptyMessage(1014);
                return;
            }
            h.m(TroopWithCommonFriendsFragment.U, arrayList);
            h.n(TroopWithCommonFriendsFragment.U, i3);
            TroopWithCommonFriendsFragment troopWithCommonFriendsFragment = TroopWithCommonFriendsFragment.this;
            troopWithCommonFriendsFragment.K = i3;
            troopWithCommonFriendsFragment.N = h.e(arrayList, troopWithCommonFriendsFragment.C);
            TroopWithCommonFriendsFragment.this.E.r();
            TroopWithCommonFriendsFragment.this.E.p(TroopWithCommonFriendsFragment.this.N);
            TroopWithCommonFriendsFragment.this.T.sendEmptyMessage(1012);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class g extends MqqHandler {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopWithCommonFriendsFragment.this);
            }
        }

        @Override // mqq.os.MqqHandler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            int i3 = message.what;
            if (i3 != 1012) {
                if (i3 != 1014) {
                    if (i3 != 1016) {
                        if (i3 == 1018) {
                            TroopWithCommonFriendsFragment troopWithCommonFriendsFragment = TroopWithCommonFriendsFragment.this;
                            QQToast.makeText(troopWithCommonFriendsFragment.I, troopWithCommonFriendsFragment.getString(R.string.he7), 0).show(TroopWithCommonFriendsFragment.this.getTitleBarHeight());
                            return;
                        }
                        return;
                    }
                    TroopWithCommonFriendsFragment troopWithCommonFriendsFragment2 = TroopWithCommonFriendsFragment.this;
                    QQToast.makeText(troopWithCommonFriendsFragment2.I, troopWithCommonFriendsFragment2.getString(R.string.hei), 0).show(TroopWithCommonFriendsFragment.this.getTitleBarHeight());
                    return;
                }
                QQToast.makeText(TroopWithCommonFriendsFragment.this.I, 1, TroopWithCommonFriendsFragment.this.I.getResources().getString(R.string.huv), 0).show(TroopWithCommonFriendsFragment.this.getTitleBarHeight());
                return;
            }
            if (TroopWithCommonFriendsFragment.this.E != null) {
                TroopWithCommonFriendsFragment.this.E.notifyDataSetChanged();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(67970);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            U = "";
        }
    }

    public TroopWithCommonFriendsFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.H = 0;
        this.J = new com.tencent.mobileqq.activity.contact.troop.c();
        this.K = 0;
        this.N = new ArrayList();
        this.P = new c();
        this.Q = new d();
        this.R = new e();
        this.S = new f();
        this.T = new g();
    }

    private void Ah(com.tencent.mobileqq.activity.contact.troop.b bVar) {
        String str;
        if (bVar != null && (str = bVar.H) != null) {
            bVar.C.setImageDrawable(com.tencent.mobileqq.troop.troopnotification.utils.h.b(this.F, str, 4));
        }
    }

    private void Ch() {
        b bVar = new b(getActivity(), R.layout.fv9);
        this.E = bVar;
        bVar.K(this.L);
        this.E.M(R.layout.b3a);
    }

    private void Dh(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.fv8, viewGroup, false);
        this.L = inflate;
        ImageView imageView = (ImageView) inflate.findViewById(R.id.avk);
        URLDrawable drawable = URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/aoi/sola/20191206115411_QbbYvjs7gs.png", (URLDrawable.URLDrawableOptions) null);
        if (drawable != null && 1 != drawable.getStatus()) {
            drawable.restartDownload();
        }
        imageView.setImageDrawable(drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eh(final String str, String str2) {
        ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str2, true, true, new IRelationNTUinAndUidApi.d() { // from class: com.tencent.mobileqq.activity.contact.troop.f
            @Override // com.tencent.relation.common.api.IRelationNTUinAndUidApi.d
            public final void a(String str3) {
                TroopWithCommonFriendsFragment.this.Gh(str, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Fh(boolean z16, int i3, String str) {
        QLog.i("TroopWithCommonFriendsFragment", 1, "[inviteToGroup] isSus:" + z16 + ",res:" + i3 + ",msg:" + str);
        if (z16) {
            this.T.sendEmptyMessage(1016);
        } else {
            this.T.sendEmptyMessage(1018);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Gh(String str, String str2) {
        QLog.i("TroopWithCommonFriendsFragment", 1, "[inviteToGroup] fetchUid uid is empty:" + TextUtils.isEmpty(str2));
        if (!TextUtils.isEmpty(str2)) {
            ((ITroopMemberOperationRepoApi) QRoute.api(ITroopMemberOperationRepoApi.class)).inviteToGroup(str, str2, this, "TroopWithCommonFriendsFragment", new i() { // from class: com.tencent.mobileqq.activity.contact.troop.g
                @Override // com.tencent.qqnt.troop.i
                public final void onResult(boolean z16, int i3, String str3) {
                    TroopWithCommonFriendsFragment.this.Fh(z16, i3, str3);
                }
            });
        }
    }

    private void Hh() {
        QQAppInterface qQAppInterface = this.C;
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(this.S);
        }
    }

    public static void Ih(String str) {
        U = str;
    }

    private void Jh(RecyclerView recyclerView, String str, Bitmap bitmap) {
        if (this.H == 0) {
            int childCount = recyclerView.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(i3);
                if (findViewHolderForAdapterPosition != null && (findViewHolderForAdapterPosition instanceof com.tencent.mobileqq.activity.contact.troop.b)) {
                    com.tencent.mobileqq.activity.contact.troop.b bVar = (com.tencent.mobileqq.activity.contact.troop.b) findViewHolderForAdapterPosition;
                    if (str.equals(bVar.H)) {
                        bVar.C.setImageBitmap(bitmap);
                        return;
                    }
                }
            }
        }
    }

    private void initUI(View view) {
        if (view == null) {
            return;
        }
        this.M = new QQProgressDialog(this.I, getTitleBarHeight());
        OverScrollRecyclerView overScrollRecyclerView = (OverScrollRecyclerView) view.findViewById(R.id.u2j);
        this.D = overScrollRecyclerView;
        overScrollRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
        this.D.addOnScrollListener(new a());
        IFaceDecoder iQQAvatarService = ((IQQAvatarService) this.C.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.C);
        this.F = iQQAvatarService;
        iQQAvatarService.setDecodeTaskCompletionListener(this);
    }

    private void xh() {
        QQAppInterface qQAppInterface = this.C;
        if (qQAppInterface != null) {
            qQAppInterface.addObserver(this.S);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yh(com.tencent.mobileqq.troop.adapter.base.c cVar, com.tencent.mobileqq.activity.contact.troop.a aVar, int i3) {
        TroopInfo troopInfo;
        com.tencent.mobileqq.activity.contact.troop.b bVar = (com.tencent.mobileqq.activity.contact.troop.b) cVar;
        if (aVar != null && !aVar.f181384a.isEmpty() && (troopInfo = aVar.f181386c) != null) {
            bVar.f181387h = i3;
            String str = troopInfo.troopname;
            bVar.f181388i = str;
            bVar.G = aVar.f181385b;
            bVar.H = aVar.f181384a;
            if (str.isEmpty()) {
                bVar.f181388i = bVar.H;
            }
            String valueOf = String.valueOf(bVar.G);
            String str2 = getString(R.string.f2058956u) + valueOf + getString(R.string.f2058856t);
            String string = getString(R.string.f2058656r);
            String string2 = getString(R.string.f2058756s);
            if (h.g(U, bVar.H)) {
                bVar.F.setText(string);
                bVar.F.setTextAppearance(this.I, R.style.f173658i9);
                bVar.F.setBackgroundResource(R.drawable.f160506il);
                bVar.F.setOnClickListener(this.R);
            } else {
                bVar.F.setBackgroundDrawable(null);
                bVar.F.setText(string2);
                bVar.F.setClickable(false);
                bVar.F.setTextAppearance(this.I, R.style.f174320vp);
            }
            bVar.D.setText(bVar.f181388i);
            bVar.E.setText(str2);
            bVar.F.setTag(cVar);
            bVar.D.setTag(cVar);
            bVar.f181389m.setTag(cVar);
            bVar.C.setTag(cVar);
            bVar.D.setOnClickListener(this.Q);
            bVar.C.setOnClickListener(this.P);
            Ah(bVar);
        }
    }

    public static void zh(Context context, int i3) {
        V = i3;
        if (i3 == 1) {
            ReportController.o(null, "dc00898", "", "", "0X800AD25", "0X800AD25", 1, 0, "0", "0", "", "");
        } else if (i3 == 2) {
            ReportController.o(null, "dc00898", "", "", "0X800AD25", "0X800AD25", 2, 0, "0", "0", "", "");
        }
        ReportController.o(null, "dc00898", "", "", "0X800AD25", "0X800AD25", 0, 0, "0", "0", "", "");
        PublicFragmentActivity.start(context, new Intent(), TroopWithCommonFriendsFragment.class);
    }

    public String Bh(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this, j3);
        }
        IFriendNameService iFriendNameService = (IFriendNameService) this.C.getRuntimeService(IFriendNameService.class);
        String friendName = iFriendNameService.getFriendName(String.valueOf(j3), false);
        if (TextUtils.isEmpty(friendName)) {
            friendName = iFriendNameService.getFriendAlias(String.valueOf(j3));
        }
        if (TextUtils.isEmpty(friendName)) {
            return friendName;
        }
        return String.valueOf(j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, layoutInflater, viewGroup, bundle);
            return;
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        this.C.setHandler(getClass(), this.T);
        this.G = (com.tencent.mobileqq.model.d) this.C.getManager(QQManagerFactory.TROOPINFO_MANAGER);
        this.I = getBaseActivity();
        this.N = h.e((ArrayList) h.c(U), this.C);
        initUI(((IphoneTitleBarFragment) this).mContentView);
        Dh(viewGroup);
        Ch();
        xh();
        this.D.setAdapter(this.E);
        this.E.p(this.N);
        if (V == 1) {
            this.M.show();
            h.f(Long.parseLong(U), 2, this.C);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return R.layout.h5p;
    }

    public int getTitleBarHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return getResources().getDimensionPixelSize(R.dimen.title_bar_height);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        BaseActivity baseActivity = getBaseActivity();
        this.I = baseActivity;
        this.C = (QQAppInterface) baseActivity.getAppInterface();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public View onCreateCenterView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        View onCreateCenterView = super.onCreateCenterView();
        String string = getString(R.string.f2059056v);
        if (!U.isEmpty()) {
            String Bh = Bh(Long.parseLong(U));
            string = getString(R.string.f2059256x) + Bh + getString(R.string.f2059156w);
        }
        setTitle(string);
        return onCreateCenterView;
    }

    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bitmap);
        } else if (bitmap != null && !TextUtils.isEmpty(str)) {
            Jh(this.D, str, bitmap);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        Hh();
        super.onDestroy();
        IFaceDecoder iFaceDecoder = this.F;
        if (iFaceDecoder != null) {
            iFaceDecoder.setDecodeTaskCompletionListener(null);
        }
        List<com.tencent.mobileqq.activity.contact.troop.a> list = this.N;
        if (list != null) {
            list.clear();
        }
        QQAppInterface qQAppInterface = this.C;
        if (qQAppInterface != null) {
            qQAppInterface.removeHandler(getClass());
        }
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            super.onFinish();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.onResume();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onStop();
        this.F.pause();
        this.F.cancelPendingRequests();
    }
}
