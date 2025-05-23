package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsDelMsgRsp;
import Wallet.AcsGetMsgListRsp;
import Wallet.AcsMsg;
import Wallet.AcsPullMsgRsp;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.extras.PullToRefreshRecyclerView;
import com.tencent.mobileqq.reminder.OnDeleteReminderFailListener;
import com.tencent.mobileqq.reminder.api.IQQReminderCalendarService;
import com.tencent.mobileqq.reminder.api.IQQReminderDataService;
import com.tencent.mobileqq.reminder.api.IQQReminderService;
import com.tencent.mobileqq.reminder.biz.entity.CalendarEntity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.observer.BusinessObserver;

/* compiled from: P */
/* loaded from: classes9.dex */
public class ReminderListFragment extends PublicBaseFragment implements PullToRefreshBase.d<RecyclerView> {
    static IPatchRedirector $redirector_;
    private static final String W;
    private RelativeLayout C;
    private ImageView D;
    private TextView E;
    private TextView F;
    private PullToRefreshRecyclerView G;
    private RecyclerView H;
    private e I;
    private boolean J;
    private boolean K;
    private PopupWindow L;
    private int M;
    private int N;
    long P;
    private IQQReminderDataService Q;
    private QQAppInterface R;
    private Handler S;
    private boolean T;
    private String U;
    private boolean V;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.activateFriend.ReminderListFragment$5, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass5 implements BusinessObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AcsMsg f177895d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f177896e;

        AnonymousClass5(AcsMsg acsMsg, String str) {
            this.f177895d = acsMsg;
            this.f177896e = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ReminderListFragment.this, acsMsg, str);
            }
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
            } else {
                ReminderListFragment.this.S.post(new Runnable(i3, z16, bundle) { // from class: com.tencent.mobileqq.activity.activateFriend.ReminderListFragment.5.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ int f177898d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ boolean f177899e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ Bundle f177900f;

                    /* compiled from: P */
                    /* renamed from: com.tencent.mobileqq.activity.activateFriend.ReminderListFragment$5$1$a */
                    /* loaded from: classes9.dex */
                    class a implements OnDeleteReminderFailListener {
                        static IPatchRedirector $redirector_;

                        a() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // com.tencent.mobileqq.reminder.OnDeleteReminderFailListener
                        public void onReminderDeleteFail() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                                ReminderListFragment.this.showToast(HardCodeUtil.qqStr(R.string.f172643t04));
                            } else {
                                iPatchRedirector.redirect((short) 2, (Object) this);
                            }
                        }
                    }

                    {
                        this.f177898d = i3;
                        this.f177899e = z16;
                        this.f177900f = bundle;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, AnonymousClass5.this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        if (this.f177898d == 2001) {
                            if (!this.f177899e) {
                                ReminderListFragment.this.showToast(HardCodeUtil.qqStr(R.string.szu));
                                return;
                            }
                            AcsDelMsgRsp acsDelMsgRsp = (AcsDelMsgRsp) this.f177900f.getSerializable("rsp");
                            if (acsDelMsgRsp == null || acsDelMsgRsp.ret_code != 0) {
                                ReminderListFragment.this.showToast(HardCodeUtil.qqStr(R.string.szx));
                                return;
                            }
                            QQAppInterface qQAppInterface = ReminderListFragment.this.R;
                            AcsMsg acsMsg = AnonymousClass5.this.f177895d;
                            ReportController.o(qQAppInterface, "P_CliOper", "QQnotice", "", "", "QQnotice.set.delete", 0, 0, "", "", acsMsg.busi_id, acsMsg.msg_id);
                            ReminderListFragment.this.I.q(AnonymousClass5.this.f177896e);
                            ReminderListFragment.this.Q.deleteReminderByMsgId(y.e(AnonymousClass5.this.f177895d), new a());
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ReminderListFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ReminderListFragment.this.Rh();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ReminderListFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (ReminderListFragment.this.L != null) {
                ReminderListFragment.this.L.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ReminderListFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ReminderListFragment.this.Kh((AcsMsg) view.getTag());
                if (ReminderListFragment.this.L != null) {
                    ReminderListFragment.this.L.dismiss();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d implements bm2.b {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ReminderListFragment.this);
            }
        }

        @Override // bm2.b
        public void a(boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), bundle);
                return;
            }
            if (!z16) {
                ReminderListFragment.this.showToast(HardCodeUtil.qqStr(R.string.f172639t00));
                return;
            }
            AcsPullMsgRsp acsPullMsgRsp = (AcsPullMsgRsp) bundle.getSerializable("rsp");
            if (acsPullMsgRsp == null) {
                ReminderListFragment.this.Uh();
                return;
            }
            ArrayList<AcsMsg> arrayList = acsPullMsgRsp.msgs;
            if (arrayList == null || arrayList.isEmpty()) {
                ReminderListFragment.this.Uh();
            } else {
                ReminderListFragment.this.Qh(arrayList, new ArrayList(arrayList.size()), true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class e extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private ArrayList<com.tencent.mobileqq.activity.activateFriend.biz.d> f177912d;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ReminderListFragment.this);
            } else {
                this.f177912d = new ArrayList<>();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            ArrayList<com.tencent.mobileqq.activity.activateFriend.biz.d> arrayList = this.f177912d;
            if (arrayList != null && !arrayList.isEmpty()) {
                return this.f177912d.size();
            }
            return 0;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) viewHolder, i3);
            } else if (viewHolder instanceof g) {
                g gVar = (g) viewHolder;
                ArrayList<com.tencent.mobileqq.activity.activateFriend.biz.d> arrayList = this.f177912d;
                if (arrayList != null && !arrayList.isEmpty()) {
                    gVar.c(this.f177912d.get(i3));
                }
            }
            EventCollector.getInstance().onRecyclerBindViewHolder(viewHolder, i3, getItemId(i3));
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) viewGroup, i3);
            }
            return new g((ViewGroup) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.aql, (ViewGroup) null, false));
        }

        public void p(ArrayList<com.tencent.mobileqq.activity.activateFriend.biz.d> arrayList, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, arrayList, Boolean.valueOf(z16));
                return;
            }
            if (z16) {
                this.f177912d.clear();
            }
            this.f177912d.addAll(arrayList);
            notifyDataSetChanged();
        }

        public void q(String str) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            ArrayList<com.tencent.mobileqq.activity.activateFriend.biz.d> arrayList = this.f177912d;
            if (arrayList != null && !arrayList.isEmpty()) {
                int i16 = 0;
                int i17 = 0;
                while (true) {
                    if (i17 >= this.f177912d.size()) {
                        break;
                    }
                    com.tencent.mobileqq.activity.activateFriend.biz.d dVar = this.f177912d.get(i17);
                    if (str.equals(dVar.f177966a.msg_id)) {
                        if (!StringUtil.isEmpty(dVar.f177967b) && (i3 = i17 + 1) < this.f177912d.size()) {
                            if (dVar.f177968c == 1 && this.f177912d.get(i3).f177968c == 1) {
                                this.f177912d.get(i3).f177967b = HardCodeUtil.qqStr(R.string.t07);
                            } else if (dVar.f177968c == 0 && this.f177912d.get(i3).f177968c == 0) {
                                this.f177912d.get(i3).f177967b = HardCodeUtil.qqStr(R.string.szw);
                            }
                        }
                        i16 = i17;
                    } else {
                        i17++;
                    }
                }
                if (i16 == this.f177912d.size()) {
                    i16--;
                }
                this.f177912d.remove(i16);
                notifyItemRemoved(i16);
                notifyItemRangeChanged(i16, this.f177912d.size());
                if (getItemCount() == 0) {
                    ReminderListFragment.this.Uh();
                }
                ReminderListFragment.this.U = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class f extends RecyclerView.ItemDecoration {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ReminderListFragment.this);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, rect, view, recyclerView, state);
                return;
            }
            super.getItemOffsets(rect, view, recyclerView, state);
            rect.left = BaseAIOUtils.f(16.0f, ReminderListFragment.this.getResources());
            rect.right = BaseAIOUtils.f(16.0f, ReminderListFragment.this.getResources());
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            int itemCount = ReminderListFragment.this.I.getItemCount();
            if (QLog.isColorLevel()) {
                QLog.i(ReminderListFragment.W, 2, "position: " + childAdapterPosition + ", totalCnt: " + itemCount);
            }
            rect.top = BaseAIOUtils.f(12.0f, ReminderListFragment.this.getResources());
            if (childAdapterPosition == itemCount - 1) {
                rect.bottom = BaseAIOUtils.f(12.0f, ReminderListFragment.this.getResources());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    private class g extends RecyclerView.ViewHolder implements View.OnClickListener {
        static IPatchRedirector $redirector_;
        ImageView C;
        FrameLayout D;

        /* renamed from: d, reason: collision with root package name */
        RelativeLayout f177915d;

        /* renamed from: e, reason: collision with root package name */
        RelativeLayout f177916e;

        /* renamed from: f, reason: collision with root package name */
        TextView f177917f;

        /* renamed from: h, reason: collision with root package name */
        TextView f177918h;

        /* renamed from: i, reason: collision with root package name */
        TextView f177919i;

        /* renamed from: m, reason: collision with root package name */
        ImageView f177920m;

        public g(View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ReminderListFragment.this, (Object) view);
                return;
            }
            this.f177915d = (RelativeLayout) view.findViewById(R.id.i6z);
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.i6y);
            this.f177916e = relativeLayout;
            relativeLayout.setOnClickListener(this);
            this.f177919i = (TextView) view.findViewById(R.id.f166782i73);
            this.C = (ImageView) view.findViewById(R.id.f166779i70);
            this.f177917f = (TextView) view.findViewById(R.id.ebe);
            this.f177918h = (TextView) view.findViewById(R.id.ebd);
            this.f177920m = (ImageView) view.findViewById(R.id.f166780i71);
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.f166781i72);
            this.D = frameLayout;
            frameLayout.setOnClickListener(this);
        }

        private void b(View view, AcsMsg acsMsg) {
            if (view instanceof FrameLayout) {
                View childAt = ((FrameLayout) view).getChildAt(0);
                if (childAt instanceof Button) {
                    Button button = (Button) childAt;
                    button.setTag(acsMsg);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) button.getLayoutParams();
                    Rect rect = new Rect();
                    this.f177920m.getLocalVisibleRect(rect);
                    layoutParams.rightMargin = rect.right;
                    this.f177920m.getGlobalVisibleRect(rect);
                    layoutParams.topMargin = rect.top - layoutParams.width;
                }
            }
        }

        public void c(com.tencent.mobileqq.activity.activateFriend.biz.d dVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) dVar);
                return;
            }
            this.D.setTag(dVar.f177966a);
            this.f177917f.setText(dVar.f177966a.title);
            this.f177916e.setTag(dVar.f177966a.jump_url);
            String str = dVar.f177966a.busi_icon;
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mRequestHeight = this.C.getHeight();
            obtain.mRequestWidth = this.C.getWidth();
            URLDrawable drawable = URLDrawable.getDrawable(str, obtain);
            if (drawable != null) {
                this.C.setImageDrawable(drawable);
            }
            String a16 = p.a(dVar.f177966a.notice_time * 1000, "yyyy.MM.dd");
            String a17 = p.a(dVar.f177966a.notice_time * 1000, DateUtil.DATE_FORMAT_HOUR);
            if (dVar.f177968c == 0) {
                a17 = a17 + "\u3000\u3000\u3000\u5f00\u542f\u65f6\u63d0\u9192";
            }
            this.f177918h.setText(a16 + "\u3000\u3000\u3000" + a17);
            TextView textView = this.f177919i;
            if (!StringUtil.isEmpty(dVar.f177967b)) {
                textView.setText(dVar.f177967b);
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
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
                if (id5 == R.id.i6y) {
                    if (!StringUtil.isEmpty((String) view.getTag())) {
                        Intent intent = new Intent(ReminderListFragment.this.getBaseActivity(), (Class<?>) QQBrowserActivity.class);
                        intent.putExtra("url", (String) view.getTag());
                        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
                        ReminderListFragment.this.startActivity(intent);
                    }
                } else if (id5 == R.id.f166781i72 && ReminderListFragment.this.L != null) {
                    b(ReminderListFragment.this.L.getContentView(), (AcsMsg) this.D.getTag());
                    ReminderListFragment.this.L.showAtLocation(ReminderListFragment.this.G, 17, 0, 0);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(67712);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            W = ReminderListFragment.class.getSimpleName();
        }
    }

    public ReminderListFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.J = false;
        this.K = false;
        this.M = 0;
        this.S = new Handler(Looper.getMainLooper());
        this.V = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kh(AcsMsg acsMsg) {
        if (acsMsg == null) {
            if (QLog.isColorLevel()) {
                QLog.d(W, 2, "---deleMsg--- acsMsg is null");
            }
            showToast(HardCodeUtil.qqStr(R.string.szv));
            return;
        }
        String str = acsMsg.msg_id;
        IQQReminderService iQQReminderService = (IQQReminderService) this.R.getRuntimeService(IQQReminderService.class, "");
        if (iQQReminderService == null) {
            return;
        }
        iQQReminderService.sendDelReminderListById(str, 0L, 2, new AnonymousClass5(acsMsg, str));
        IQQReminderCalendarService iQQReminderCalendarService = (IQQReminderCalendarService) this.R.getRuntimeService(IQQReminderCalendarService.class, "");
        CalendarEntity calendarEntity = new CalendarEntity();
        calendarEntity.msg_id = acsMsg.msg_id;
        iQQReminderCalendarService.deleteCalendarAlarm(getQBaseActivity(), calendarEntity);
    }

    private QQAppInterface Lh() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            return (QQAppInterface) runtime;
        }
        return null;
    }

    private View Mh(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setOnClickListener(new b());
        frameLayout.setBackgroundColor(Color.parseColor("#1A000000"));
        Button button = new Button(context);
        button.setText(HardCodeUtil.qqStr(R.string.f172641t02));
        button.setTextColor(Color.parseColor("#000000"));
        button.setTextSize(1, 16.0f);
        button.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.f161688aa2));
        button.setOnClickListener(new c());
        frameLayout.addView(button);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) button.getLayoutParams();
        layoutParams.width = BaseAIOUtils.f(80.0f, getResources());
        layoutParams.height = -2;
        layoutParams.gravity = 53;
        return frameLayout;
    }

    private void Nh() {
        if (!NetworkUtil.isNetworkAvailable(getBaseActivity())) {
            showToast(HardCodeUtil.qqStr(R.string.szy));
            if (this.N == 0) {
                Uh();
                return;
            }
            return;
        }
        if (Th()) {
            try {
                Ph(p.a(Long.parseLong(getBaseActivity().getIntent().getStringExtra("notice_time")) * 1000, DateUtil.DATE_FORMAT_8));
                return;
            } catch (Exception unused) {
                this.N = 0;
                this.M = 0;
                this.V = true;
                Oh(0);
                return;
            }
        }
        this.N = 0;
        this.M = 0;
        this.V = true;
        Oh(0);
    }

    private void Oh(int i3) {
        if (i3 == 0) {
            this.J = false;
            this.K = false;
            this.M = 0;
        }
        if (!this.V) {
            showToast(HardCodeUtil.qqStr(R.string.f172642t03));
            this.S.post(new Runnable() { // from class: com.tencent.mobileqq.activity.activateFriend.ReminderListFragment.8
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ReminderListFragment.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        ReminderListFragment.this.G.E();
                    }
                }
            });
        } else {
            IQQReminderService iQQReminderService = (IQQReminderService) this.R.getRuntimeService(IQQReminderService.class, "");
            if (iQQReminderService == null) {
                return;
            }
            iQQReminderService.sendReminderList(i3, 10, new BusinessObserver(i3) { // from class: com.tencent.mobileqq.activity.activateFriend.ReminderListFragment.9
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f177905d;

                {
                    this.f177905d = i3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ReminderListFragment.this, i3);
                    }
                }

                @Override // mqq.observer.BusinessObserver
                public void onReceive(int i16, boolean z16, Bundle bundle) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    boolean z17 = false;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i16), Boolean.valueOf(z16), bundle);
                        return;
                    }
                    if (i16 == 2000) {
                        if (!z16) {
                            ReminderListFragment.this.showToast(HardCodeUtil.qqStr(R.string.t08));
                        } else {
                            AcsGetMsgListRsp acsGetMsgListRsp = (AcsGetMsgListRsp) bundle.getSerializable("rsp");
                            if (acsGetMsgListRsp == null) {
                                ReminderListFragment.this.Uh();
                            } else {
                                ArrayList<AcsMsg> arrayList = acsGetMsgListRsp.data_list;
                                ArrayList arrayList2 = new ArrayList();
                                if (arrayList == null || arrayList.isEmpty()) {
                                    ReminderListFragment.this.Uh();
                                } else {
                                    ReminderListFragment.this.M += arrayList.size();
                                    if (ReminderListFragment.this.M >= acsGetMsgListRsp.total) {
                                        ReminderListFragment.this.V = false;
                                    } else {
                                        ReminderListFragment.this.V = true;
                                        ReminderListFragment.this.N++;
                                    }
                                    ReminderListFragment reminderListFragment = ReminderListFragment.this;
                                    if (this.f177905d == 0) {
                                        z17 = true;
                                    }
                                    reminderListFragment.Qh(arrayList, arrayList2, z17);
                                }
                            }
                            if (QLog.isColorLevel()) {
                                QLog.i(ReminderListFragment.W, 2, "acsGetMsgListRsp: " + acsGetMsgListRsp + " ");
                            }
                        }
                        ReminderListFragment.this.S.post(new Runnable() { // from class: com.tencent.mobileqq.activity.activateFriend.ReminderListFragment.9.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass9.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                PullToRefreshBase.Mode mode;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                    PullToRefreshRecyclerView pullToRefreshRecyclerView = ReminderListFragment.this.G;
                                    if (ReminderListFragment.this.V) {
                                        mode = PullToRefreshBase.Mode.BOTH;
                                    } else {
                                        mode = PullToRefreshBase.Mode.PULL_FROM_START;
                                    }
                                    pullToRefreshRecyclerView.setMode(mode);
                                    return;
                                }
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            }
                        });
                    }
                }
            });
        }
    }

    private void Ph(String str) {
        this.Q.getReminderListByday(str, new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qh(ArrayList<AcsMsg> arrayList, ArrayList<com.tencent.mobileqq.activity.activateFriend.biz.d> arrayList2, boolean z16) {
        Iterator<AcsMsg> it = arrayList.iterator();
        while (it.hasNext()) {
            AcsMsg next = it.next();
            com.tencent.mobileqq.activity.activateFriend.biz.d dVar = new com.tencent.mobileqq.activity.activateFriend.biz.d();
            dVar.f177966a = next;
            if (next.notice_time * 1000 >= this.P) {
                dVar.f177968c = 0;
                if (!this.J) {
                    dVar.f177967b = HardCodeUtil.qqStr(R.string.f172640t01);
                    this.J = true;
                }
            } else {
                dVar.f177968c = 1;
                if (!this.K) {
                    dVar.f177967b = HardCodeUtil.qqStr(R.string.t06);
                    this.K = true;
                }
            }
            arrayList2.add(dVar);
        }
        this.S.post(new Runnable(arrayList2, z16) { // from class: com.tencent.mobileqq.activity.activateFriend.ReminderListFragment.7
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ ArrayList f177903d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ boolean f177904e;

            {
                this.f177903d = arrayList2;
                this.f177904e = z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, ReminderListFragment.this, arrayList2, Boolean.valueOf(z16));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    ReminderListFragment.this.I.p(this.f177903d, this.f177904e);
                    ReminderListFragment.this.G.F();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rh() {
        if (getBaseActivity() != null) {
            Intent intent = new Intent();
            intent.putExtra("msg_id", this.U);
            getBaseActivity().setResult(-1, intent);
            getBaseActivity().finish();
        }
    }

    private View Sh(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.aqk, viewGroup, false);
        this.C = (RelativeLayout) inflate.findViewById(R.id.aqh);
        this.D = (ImageView) inflate.findViewById(R.id.bwx);
        TextView textView = (TextView) inflate.findViewById(R.id.ivTitleName);
        this.E = textView;
        textView.setText(getResources().getString(R.string.f170010ct));
        TextView textView2 = (TextView) inflate.findViewById(R.id.ivTitleBtnLeft);
        this.F = textView2;
        textView2.setOnClickListener(new a());
        PullToRefreshRecyclerView pullToRefreshRecyclerView = (PullToRefreshRecyclerView) inflate.findViewById(R.id.g5m);
        this.G = pullToRefreshRecyclerView;
        pullToRefreshRecyclerView.setOnRefreshListener(this);
        RecyclerView s16 = this.G.s();
        this.H = s16;
        s16.setId(R.id.i4m);
        this.H.setLayoutManager(new LinearLayoutManager(getBaseActivity(), 1, false));
        this.H.addItemDecoration(new f());
        e eVar = new e();
        this.I = eVar;
        this.H.setAdapter(eVar);
        this.I.notifyDataSetChanged();
        if (this.L == null) {
            this.L = new PopupWindow(Mh(getBaseActivity()), -1, -1);
        }
        this.L.setBackgroundDrawable(new ColorDrawable());
        this.L.setOutsideTouchable(true);
        this.L.setFocusable(true);
        return inflate;
    }

    private boolean Th() {
        Intent intent = getBaseActivity().getIntent();
        if (intent != null) {
            boolean z16 = !StringUtil.isEmpty(intent.getStringExtra("notice_time"));
            this.T = z16;
            if (z16) {
                this.G.setMode(PullToRefreshBase.Mode.DISABLED);
            }
            return this.T;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uh() {
        this.S.post(new Runnable() { // from class: com.tencent.mobileqq.activity.activateFriend.ReminderListFragment.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ReminderListFragment.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                ReminderListFragment.this.C.setVisibility(0);
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mRequestHeight = ReminderListFragment.this.D.getHeight();
                obtain.mRequestWidth = ReminderListFragment.this.D.getWidth();
                URLDrawable drawable = URLDrawable.getDrawable("https://i.gtimg.cn/channel/imglib/201905/upload_d06258d2e506e8f9f37614f2826e8234.png", obtain);
                if (drawable != null) {
                    ReminderListFragment.this.D.setImageDrawable(drawable);
                }
                ReminderListFragment.this.G.setVisibility(8);
            }
        });
    }

    private void initData() {
        QQAppInterface Lh = Lh();
        this.R = Lh;
        if (Lh != null) {
            this.Q = (IQQReminderDataService) Lh.getRuntimeService(IQQReminderDataService.class, "");
            Nh();
        }
    }

    public static void launch(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) ReminderListFragment.class);
        intent.putExtra("notice_time", str);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        PublicFragmentActivity.b.a(context, intent, PublicFragmentActivity.class, ReminderListFragment.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToast(String str) {
        this.S.post(new Runnable(str) { // from class: com.tencent.mobileqq.activity.activateFriend.ReminderListFragment.10
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f177894d;

            {
                this.f177894d = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ReminderListFragment.this, (Object) str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (ReminderListFragment.this.getBaseActivity() != null) {
                    QQToast.makeText(ReminderListFragment.this.getBaseActivity(), this.f177894d, 0).show();
                }
                ReminderListFragment.this.G.E();
            }
        });
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase.d
    public void F4(PullToRefreshBase<RecyclerView> pullToRefreshBase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) pullToRefreshBase);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(W, 2, "----onPullDownToRefresh----");
        }
        Nh();
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        if (i3 == 4) {
            Rh();
            return true;
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View Sh;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            Sh = (View) iPatchRedirector.redirect((short) 2, this, layoutInflater, viewGroup, bundle);
        } else {
            Sh = Sh(layoutInflater, viewGroup);
            initData();
            this.P = NetConnInfoCenter.getServerTimeMillis();
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, Sh);
        return Sh;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onDestroyView();
        Handler handler = this.S;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase.d
    public void s5(PullToRefreshBase<RecyclerView> pullToRefreshBase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) pullToRefreshBase);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(W, 2, "----onPullUpToRefresh----");
        }
        if (!this.T) {
            Oh(this.N);
        }
    }
}
