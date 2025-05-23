package com.tencent.mobileqq.activity.history;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.data.search.FileSearchActivity;
import com.tencent.mobileqq.filemanager.widget.QFileListPullMoreLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.IGroupTeamWorkHandler;
import com.tencent.mobileqq.troop.data.n;
import com.tencent.mobileqq.troop.filemanager.data.TroopFileSearchManager;
import com.tencent.mobileqq.troop.filemanager.data.c;
import com.tencent.mobileqq.troop.filemanager.data.h;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ChatHistoryTroopFileFragment extends ChatHistoryBaseFragment implements com.tencent.mobileqq.troop.filemanager.data.b, c.e, ef0.a {
    static IPatchRedirector $redirector_;
    private long M;
    private View N;
    private XListView P;
    private QUISearchBar Q;
    private QFileListPullMoreLayout R;
    private View S;
    private ViewGroup T;
    private View U;
    protected com.tencent.mobileqq.troop.filemanager.data.f V;
    private PullRefreshHeader W;
    private OverScrollViewListener X;
    private TroopFileError.d Y;
    private h Z;

    /* renamed from: a0, reason: collision with root package name */
    private TroopFileManager f182517a0;

    /* renamed from: b0, reason: collision with root package name */
    protected com.tencent.mobileqq.filemanager.multioperate.d f182518b0;

    /* renamed from: c0, reason: collision with root package name */
    public long f182519c0;

    /* renamed from: d0, reason: collision with root package name */
    private int f182520d0;

    /* renamed from: e0, reason: collision with root package name */
    private long f182521e0;

    /* renamed from: f0, reason: collision with root package name */
    private long f182522f0;

    /* renamed from: g0, reason: collision with root package name */
    private LinearLayout f182523g0;

    /* renamed from: h0, reason: collision with root package name */
    private TextView f182524h0;

    /* renamed from: i0, reason: collision with root package name */
    private View f182525i0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f182526j0;

    /* renamed from: k0, reason: collision with root package name */
    private com.tencent.mobileqq.filemanager.widget.b f182527k0;

    /* renamed from: l0, reason: collision with root package name */
    private View.OnClickListener f182528l0;

    /* renamed from: m0, reason: collision with root package name */
    protected d f182529m0;

    /* renamed from: n0, reason: collision with root package name */
    protected e f182530n0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements OverScrollViewListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistoryTroopFileFragment.this);
            }
        }

        @Override // com.tencent.widget.OverScrollViewListener
        public void onNotCompleteVisable(int i3, View view, ListView listView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), view, listView);
                return;
            }
            PullRefreshHeader pullRefreshHeader = (PullRefreshHeader) view;
            long j3 = ChatHistoryTroopFileFragment.this.f182519c0;
            if (j3 == 0) {
                j3 = System.currentTimeMillis();
            }
            pullRefreshHeader.i(j3);
        }

        @Override // com.tencent.widget.OverScrollViewListener
        public void onViewCompleteVisable(int i3, View view, ListView listView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), view, listView);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ChatHistoryTroopFileFragment<QFile>", 2, "onViewCompleteVisable");
            }
            PullRefreshHeader pullRefreshHeader = (PullRefreshHeader) view;
            long j3 = ChatHistoryTroopFileFragment.this.f182519c0;
            if (j3 == 0) {
                j3 = System.currentTimeMillis();
            }
            pullRefreshHeader.d(j3);
        }

        @Override // com.tencent.widget.OverScrollViewListener
        public boolean onViewCompleteVisableAndReleased(int i3, View view, ListView listView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), view, listView)).booleanValue();
            }
            if (QLog.isColorLevel()) {
                QLog.d("ChatHistoryTroopFileFragment<QFile>", 2, "onViewCompleteVisableAndReleased");
            }
            PullRefreshHeader pullRefreshHeader = (PullRefreshHeader) view;
            long j3 = ChatHistoryTroopFileFragment.this.f182519c0;
            if (j3 == 0) {
                j3 = System.currentTimeMillis();
            }
            pullRefreshHeader.h(j3);
            if (!NetworkUtil.isNetworkAvailable(ChatHistoryTroopFileFragment.this.getBaseActivity())) {
                ChatHistoryTroopFileFragment.this.Dh(1);
                ChatHistoryTroopFileFragment chatHistoryTroopFileFragment = ChatHistoryTroopFileFragment.this;
                TroopFileUtils.F(chatHistoryTroopFileFragment.C, chatHistoryTroopFileFragment.M);
            } else {
                ChatHistoryTroopFileFragment.this.V.g(0, 0);
            }
            return true;
        }

        @Override // com.tencent.widget.OverScrollViewListener
        public void onViewNotCompleteVisableAndReleased(int i3, View view, ListView listView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, listView);
            } else if (QLog.isColorLevel()) {
                QLog.d("ChatHistoryTroopFileFragment<QFile>", 2, "onViewNotCompleteVisableAndReleased");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b extends com.tencent.mobileqq.filemanager.widget.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistoryTroopFileFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.widget.b
        public void b(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                return;
            }
            com.tencent.imcore.message.report.a.f(ChatHistoryTroopFileFragment.this.C, 5, 2);
            ReportController.o(ChatHistoryTroopFileFragment.this.C, "dc00898", "", "", "0X800A0BF", "0X800A0BF", 2, 0, "", "", "", "");
            Bundle arguments = ChatHistoryTroopFileFragment.this.getArguments();
            int i3 = 0;
            if (arguments != null) {
                i3 = arguments.getInt("key_source", 0);
            }
            if (i3 == 1) {
                QLog.d("ChatHistoryTroopFileFragment<QFile>", 1, "NTScanSpaceManager ChatHistoryTroopFileFragment.mOnClickListener, source: " + i3);
                Bundle bundle = new Bundle();
                bundle.putInt("key_source", i3);
                FileSearchActivity.Y2(ChatHistoryTroopFileFragment.this.getBaseActivity(), null, null, false, 13, String.valueOf(ChatHistoryTroopFileFragment.this.M), bundle);
                return;
            }
            FileSearchActivity.V2(ChatHistoryTroopFileFragment.this.getBaseActivity(), 13, String.valueOf(ChatHistoryTroopFileFragment.this.M));
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistoryTroopFileFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                int id5 = view.getId();
                if ((id5 == R.id.jwa || id5 == R.id.jwc) && ChatHistoryTroopFileFragment.this.f182525i0 != null) {
                    ChatHistoryTroopFileFragment.this.f182525i0.setVisibility(8);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class d extends ef0.e {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        WeakReference<ef0.a> f182537d;

        d(ef0.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistoryTroopFileFragment.this, (Object) aVar);
            } else {
                this.f182537d = new WeakReference<>(aVar);
            }
        }

        @Override // ef0.e
        public void c(boolean z16, boolean z17, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            ef0.a aVar = this.f182537d.get();
            if (aVar != null) {
                aVar.b5(z16, z17, i3, i16, i17);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class e extends ef0.h {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        WeakReference<ef0.a> f182539d;

        e(ef0.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistoryTroopFileFragment.this, (Object) aVar);
            } else {
                this.f182539d = new WeakReference<>(aVar);
            }
        }

        @Override // ef0.h
        public void c(boolean z16, long j3, long j16, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3));
                return;
            }
            ef0.a aVar = this.f182539d.get();
            if (aVar != null) {
                aVar.R1(z16, j3, j16, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class f implements TroopFileError.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private long f182541a;

        public f(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ChatHistoryTroopFileFragment.this, Long.valueOf(j3));
            } else {
                this.f182541a = j3;
            }
        }

        @Override // com.tencent.mobileqq.troop.utils.TroopFileError.c
        public long a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
            }
            return this.f182541a;
        }
    }

    public ChatHistoryTroopFileFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f182519c0 = 0L;
        this.f182520d0 = -1;
        this.f182521e0 = -1L;
        this.f182522f0 = -1L;
        this.f182526j0 = false;
        this.f182527k0 = new b();
        this.f182528l0 = new c();
        this.f182529m0 = new d(this);
        this.f182530n0 = new e(this);
    }

    private void Ch(int i3) {
        if (this.P.getFirstVisiblePosition() == 0) {
            this.R.setVisibility(8);
            return;
        }
        if (i3 != 5 && i3 != 6 && i3 != 7) {
            if (i3 == 8) {
                this.R.setVisibility(8);
            }
        } else {
            this.R.setVisibility(0);
            this.R.setText(R.string.hqg);
            this.R.setTextLeftDrawable(R.drawable.f160545jt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dh(int i3) {
        if (this.W != null) {
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.history.ChatHistoryTroopFileFragment.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistoryTroopFileFragment.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        ChatHistoryTroopFileFragment.this.P.springBackOverScrollHeaderView();
                    }
                }
            }, 800L);
            if (i3 == 4) {
                this.f182519c0 = System.currentTimeMillis();
                this.W.l(0);
            }
            if (i3 == 3) {
                this.W.l(1);
            }
        }
    }

    private void Eh() {
        long j3 = this.M;
        if (j3 != 0) {
            this.f182517a0 = TroopFileManager.F(this.C, j3);
            if (!NetworkUtil.isNetworkAvailable(getBaseActivity())) {
                TroopFileUtils.F(this.C, this.M);
            }
            this.V.g(0, 0);
            int C = this.f182517a0.C();
            if (this.f182518b0 == null) {
                this.f182518b0 = new com.tencent.mobileqq.filemanager.multioperate.d(this.C, this.G, this.M);
            }
            QLog.d("ChatHistoryTroopFileFragment<QFile>", 4, "initFileListData : uin[" + this.M + "] fileSum[" + C + "]");
            return;
        }
        QLog.e("ChatHistoryTroopFileFragment<QFile>", 2, "troop uin is not legal.");
    }

    private void Fh() {
        this.W = (PullRefreshHeader) LayoutInflater.from(getBaseActivity()).inflate(R.layout.f168433w5, (ViewGroup) this.P, false);
        this.X = new a();
        this.P.setOverScrollHeader(this.W);
        this.P.setOverscrollHeader(getResources().getDrawable(R.drawable.common_list_overscoll_top_bg));
        this.P.setOverScrollListener(this.X);
    }

    private void Gh(int i3) {
        switch (i3) {
            case 0:
            case 5:
                this.P.setVisibility(8);
                this.Q.setVisibility(8);
                this.T.setVisibility(0);
                this.f182526j0 = false;
                break;
            case 1:
            case 2:
                this.P.setVisibility(0);
                this.T.setVisibility(0);
                this.f182526j0 = false;
                break;
            case 3:
            case 6:
                this.P.setVisibility(8);
                this.T.setVisibility(0);
                this.f182526j0 = false;
                break;
            case 4:
                this.P.setVisibility(0);
                this.Q.setVisibility(0);
                this.T.setVisibility(8);
                this.f182526j0 = true;
                break;
        }
        Ih(Boolean.valueOf(this.f182526j0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hh() {
        if (isAdded() && getContext() != null) {
            if (this.f182520d0 != -1 && this.f182521e0 != -1 && this.f182522f0 != -1) {
                if (this.f182523g0 == null) {
                    this.f182523g0 = (LinearLayout) this.N.findViewById(R.id.j88);
                    this.f182524h0 = (TextView) this.N.findViewById(R.id.j8e);
                }
                this.f182523g0.setVisibility(0);
                long j3 = this.f182522f0;
                long j16 = this.f182521e0;
                if (j3 >= j16) {
                    String format = String.format(getString(R.string.f171455w41), Integer.valueOf(this.f182520d0), FileUtils.getFileSize(j16));
                    int indexOf = format.indexOf(getString(R.string.f171456w42));
                    SpannableString spannableString = new SpannableString(format);
                    spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FF596A")), indexOf, indexOf + 4, 33);
                    this.f182524h0.setText(spannableString);
                    return;
                }
                this.f182524h0.setText(String.format(getString(R.string.f171457w43), Integer.valueOf(this.f182520d0), FileUtils.getFileSize(j3), FileUtils.getFileSize(this.f182521e0)));
                return;
            }
            LinearLayout linearLayout = this.f182523g0;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.filemanager.data.c.e
    public void B0(boolean z16, n nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Boolean.valueOf(z16), nVar);
            return;
        }
        Iterator<n> it = this.V.c().iterator();
        while (it.hasNext() && it.next().f294918d <= GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Bh(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
        } else {
            this.V.j(z16);
        }
    }

    @Override // com.tencent.mobileqq.troop.filemanager.data.b
    public void Da(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            Gh(i3);
            Jh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ih(Boolean bool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) bool);
        }
    }

    public void Jh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.history.ChatHistoryTroopFileFragment.6
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryTroopFileFragment.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    ChatHistoryTroopFileFragment chatHistoryTroopFileFragment = ChatHistoryTroopFileFragment.this;
                    com.tencent.biz.troop.file.a.e(chatHistoryTroopFileFragment.C, chatHistoryTroopFileFragment.M, ChatHistoryTroopFileFragment.this.f182529m0);
                    ChatHistoryTroopFileFragment chatHistoryTroopFileFragment2 = ChatHistoryTroopFileFragment.this;
                    com.tencent.biz.troop.file.a.i(chatHistoryTroopFileFragment2.C, chatHistoryTroopFileFragment2.M, ChatHistoryTroopFileFragment.this.f182530n0);
                }
            });
        }
    }

    @Override // ef0.a
    public void R1(boolean z16, long j3, long j16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3));
        } else if (getBaseActivity() != null && !getBaseActivity().isFinishing() && z16) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable(j3, j16) { // from class: com.tencent.mobileqq.activity.history.ChatHistoryTroopFileFragment.7
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ long f182531d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ long f182532e;

                {
                    this.f182531d = j3;
                    this.f182532e = j16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, ChatHistoryTroopFileFragment.this, Long.valueOf(j3), Long.valueOf(j16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (ChatHistoryTroopFileFragment.this.getBaseActivity() != null && !ChatHistoryTroopFileFragment.this.getBaseActivity().isFinishing()) {
                        ChatHistoryTroopFileFragment.this.f182521e0 = this.f182531d;
                        ChatHistoryTroopFileFragment.this.f182522f0 = this.f182532e;
                        ChatHistoryTroopFileFragment.this.Hh();
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.troop.filemanager.data.b
    public int Y2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        XListView xListView = this.P;
        if (xListView != null) {
            return xListView.getLastVisiblePosition();
        }
        return 0;
    }

    @Override // ef0.a
    public void b5(boolean z16, boolean z17, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        if (getBaseActivity() != null && !getBaseActivity().isFinishing() && z16) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable(i3) { // from class: com.tencent.mobileqq.activity.history.ChatHistoryTroopFileFragment.8
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f182533d;

                {
                    this.f182533d = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryTroopFileFragment.this, i3);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    ChatHistoryTroopFileFragment.this.f182520d0 = this.f182533d;
                    ChatHistoryTroopFileFragment.this.Hh();
                }
            });
            if (z17) {
                ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.history.ChatHistoryTroopFileFragment.9
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryTroopFileFragment.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else if (ChatHistoryTroopFileFragment.this.getBaseActivity() != null && !ChatHistoryTroopFileFragment.this.getBaseActivity().isFinishing()) {
                            ChatHistoryTroopFileFragment.this.f182525i0.setVisibility(0);
                        }
                    }
                }, 1000L);
            } else {
                ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.history.ChatHistoryTroopFileFragment.10
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryTroopFileFragment.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else if (ChatHistoryTroopFileFragment.this.getBaseActivity() != null && !ChatHistoryTroopFileFragment.this.getBaseActivity().isFinishing()) {
                            ChatHistoryTroopFileFragment.this.f182525i0.setVisibility(8);
                        }
                    }
                }, 1000L);
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.history.ChatHistoryBaseFragment
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.doOnDestroy();
        QLog.i("ChatHistoryTroopFileFragment<QFile>", 1, "doOnDestroy");
        TroopFileError.d dVar = this.Y;
        if (dVar != null) {
            TroopFileError.f(this.C, dVar);
            this.Y = null;
        }
        this.Z.f();
        this.V.f();
        TroopFileSearchManager.e().h();
    }

    @Override // com.tencent.mobileqq.activity.history.ChatHistoryBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
        } else {
            super.onCreate(bundle);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            view = (View) iPatchRedirector.redirect((short) 3, this, layoutInflater, viewGroup, bundle);
        } else {
            if (TextUtils.isEmpty(getUin())) {
                QLog.i("ChatHistoryTroopFileFragment<QFile>", 1, "get uin is empty.");
                this.M = 0L;
            } else {
                this.M = Long.valueOf(getUin()).longValue();
            }
            if (this.M == 0) {
                this.M = Long.parseLong(requireArguments().getString(IGroupTeamWorkHandler.KEY_GROUP_CODE));
                QLog.i("ChatHistoryTroopFileFragment<QFile>", 1, "get from qqnt" + this.M);
            }
            this.C = getBaseActivity().app;
            this.G = getBaseActivity();
            if (this.N == null) {
                View inflate = layoutInflater.inflate(R.layout.als, viewGroup, false);
                this.N = inflate;
                this.P = (XListView) inflate.findViewById(R.id.f166069ec1);
                QFileListPullMoreLayout qFileListPullMoreLayout = new QFileListPullMoreLayout(layoutInflater.getContext());
                this.R = qFileListPullMoreLayout;
                qFileListPullMoreLayout.setBackgroundResource(R.drawable.bg_texture);
                this.R.setTextColor(getResources().getColor(R.color.skin_black));
                this.P.addFooterView(this.R);
                this.R.setVisibility(8);
                View inflate2 = View.inflate(this.G, R.layout.amc, null);
                this.S = inflate2;
                this.P.addFooterView(inflate2);
                this.S.setVisibility(8);
                this.T = (ViewGroup) this.N.findViewById(R.id.v7b);
                QUIEmptyState.Builder builder = new QUIEmptyState.Builder(getContext());
                builder.setImageType(2);
                builder.setTitle(HardCodeUtil.qqStr(R.string.f170954b82));
                builder.setBackgroundColorType(0);
                QUIEmptyState build = builder.build();
                this.U = build;
                this.T.addView(build);
                Bundle arguments = getArguments();
                if (arguments != null) {
                    i3 = arguments.getInt("key_source", 0);
                } else {
                    i3 = 0;
                }
                com.tencent.mobileqq.troop.filemanager.data.f fVar = new com.tencent.mobileqq.troop.filemanager.data.f(this.C, this.G, this.M, "/", 13, i3);
                this.V = fVar;
                this.P.setAdapter((ListAdapter) fVar);
                this.V.k(this);
                this.V.i(this);
                this.P.setOnScrollListener(this.V);
                this.V.U = true;
                QUISearchBar qUISearchBar = (QUISearchBar) this.N.findViewById(R.id.c_y).findViewById(R.id.gku);
                this.Q = qUISearchBar;
                qUISearchBar.setOnClickListener(this.f182527k0);
                this.Q.getInputWidget().setHint(R.string.f170725a14);
                this.f182525i0 = this.N.findViewById(R.id.jwb);
                this.N.findViewById(R.id.jwa).setOnClickListener(this.f182528l0);
                this.N.findViewById(R.id.jwc).setOnClickListener(this.f182528l0);
                Fh();
            }
            ViewGroup viewGroup2 = (ViewGroup) this.N.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(this.N);
            }
            Gh(5);
            if (this.Z == null) {
                h hVar = new h(this.C, this.G, String.valueOf(this.M));
                this.Z = hVar;
                hVar.b();
            }
            this.Z.e(false, this);
            Eh();
            view = this.N;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.activity.history.ChatHistoryBaseFragment
    public void ph() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        TroopFileError.d dVar = this.Y;
        if (dVar != null) {
            TroopFileError.f(this.C, dVar);
            this.Y = null;
        }
        Bh(false);
    }

    @Override // com.tencent.mobileqq.activity.history.ChatHistoryBaseFragment
    public void qh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.Y == null) {
            this.Y = new TroopFileError.d(this.G, new f(this.M), this.C);
        }
        TroopFileError.a(this.C, this.Y);
        ReportController.o(this.C, "dc00898", "", "", "0X800A0B9", "0X800A0B9", 4, 0, "", "", "", "");
        com.tencent.imcore.message.report.a.i(this.C, 5, 2);
        Jh();
    }

    @Override // com.tencent.mobileqq.troop.filemanager.data.b
    public void se(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            Dh(i3);
            Ch(i3);
        }
    }

    @Override // com.tencent.mobileqq.activity.history.ChatHistoryBaseFragment
    protected void sh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.filemanager.data.b
    public int za() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        XListView xListView = this.P;
        if (xListView != null) {
            return xListView.getFirstVisiblePosition();
        }
        return 0;
    }
}
