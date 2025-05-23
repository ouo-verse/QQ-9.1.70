package com.tencent.mobileqq.leba.more;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.leba.ILebaUIStyleSettingApi;
import com.tencent.mobileqq.leba.core.BasePluginDataManager;
import com.tencent.mobileqq.leba.entity.n;
import com.tencent.mobileqq.leba.logic.LebaPluginLogic;
import com.tencent.mobileqq.leba.more.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Pair;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes15.dex */
public class LebaMoreFragment extends QIphoneTitleBarFragment implements a.e, BasePluginDataManager.d {
    static IPatchRedirector $redirector_;
    protected RecyclerView C;
    protected com.tencent.mobileqq.leba.more.a D;
    protected boolean E;
    protected LebaMoreDataLogic F;
    protected int G;
    protected boolean H;
    com.tencent.mobileqq.leba.business.f I;
    com.tencent.mobileqq.leba.business.g J;
    protected Dialog K;
    protected boolean L;
    private com.tencent.mobileqq.leba.observer.a M;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a extends View.AccessibilityDelegate {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LebaMoreFragment.this);
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) accessibilityNodeInfo);
                return;
            }
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            if (accessibilityNodeInfo != null) {
                accessibilityNodeInfo.setClassName(Button.class.getName());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b extends View.AccessibilityDelegate {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LebaMoreFragment.this);
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) accessibilityNodeInfo);
                return;
            }
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            if (accessibilityNodeInfo != null) {
                accessibilityNodeInfo.setClassName(Button.class.getName());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class c extends View.AccessibilityDelegate {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LebaMoreFragment.this);
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) accessibilityNodeInfo);
                return;
            }
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            if (accessibilityNodeInfo != null) {
                accessibilityNodeInfo.setClassName(Button.class.getName());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class d implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LebaMoreFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            QLog.i("LebaMoreFragment", 1, "showTipDialog onClick confirm");
            LebaMoreFragment lebaMoreFragment = LebaMoreFragment.this;
            lebaMoreFragment.L = true;
            lebaMoreFragment.Eh();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class e implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LebaMoreFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            QLog.i("LebaMoreFragment", 1, "showTipDialog onClick onCancel");
            if (LebaMoreFragment.this.getActivity() != null) {
                LebaMoreFragment.this.getActivity().finish();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class f extends RecyclerView.ItemDecoration {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        com.tencent.mobileqq.leba.more.a f240690d;

        /* renamed from: e, reason: collision with root package name */
        int f240691e;

        public f(Context context, com.tencent.mobileqq.leba.more.a aVar, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, context, aVar, Boolean.valueOf(z16));
            } else {
                this.f240691e = ViewUtils.dip2px(1.0f);
                this.f240690d = aVar;
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
            if (this.f240690d == null) {
                QLog.i("LebaMoreFragment", 1, "MyItemDecoration getItemOffsets mAdapter == null");
            } else {
                if (recyclerView.getChildAdapterPosition(view) < 0) {
                    return;
                }
                int i3 = this.f240691e;
                rect.bottom = i3;
                rect.right = i3;
            }
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, canvas, recyclerView, state);
            } else {
                super.onDraw(canvas, recyclerView, state);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class g extends GridLayoutManager.SpanSizeLookup {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        com.tencent.mobileqq.leba.more.a f240692a;

        public g(com.tencent.mobileqq.leba.more.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            } else {
                this.f240692a = aVar;
            }
        }

        @Override // android.support.v7.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, i3)).intValue();
            }
            com.tencent.mobileqq.leba.more.a aVar = this.f240692a;
            if (aVar == null) {
                QLog.i("LebaMoreFragment", 1, "MyLoopUp getSpanSize mAdapter == null");
                return 1;
            }
            if (aVar.getItemViewType(i3) != 1) {
                return 1;
            }
            return 4;
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class h implements y62.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        LebaMoreFragment f240693a;

        public h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // y62.a
        public void notifyDataSetChanged() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            }
        }

        @Override // y62.a
        public void scrollToTop() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                iPatchRedirector.redirect((short) 14, (Object) this);
            }
        }
    }

    public LebaMoreFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.H = false;
        this.I = new com.tencent.mobileqq.leba.business.f();
        this.J = new com.tencent.mobileqq.leba.business.g();
        this.M = new com.tencent.mobileqq.leba.observer.a() { // from class: com.tencent.mobileqq.leba.more.LebaMoreFragment.7
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LebaMoreFragment.this);
                }
            }

            @Override // com.tencent.mobileqq.leba.observer.a
            public void b(boolean z16, boolean z17) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
                    return;
                }
                if (LebaMoreFragment.this.getActivity() != null && !LebaMoreFragment.this.getActivity().isFinishing()) {
                    QLog.i("LebaMoreFragment", 1, "onLebaSettingChanged isSuccess=" + z16 + ",setting=" + z17);
                    LebaMoreFragment.this.hideLoading();
                    if (z16) {
                        LebaMoreFragment lebaMoreFragment = LebaMoreFragment.this;
                        lebaMoreFragment.F.w(lebaMoreFragment.th());
                        LebaMoreFragment lebaMoreFragment2 = LebaMoreFragment.this;
                        if (lebaMoreFragment2.L) {
                            lebaMoreFragment2.getActivity().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.leba.more.LebaMoreFragment.7.1
                                static IPatchRedirector $redirector_;

                                {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass7.this);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                    } else if (LebaMoreFragment.this.getActivity() != null) {
                                        LebaMoreFragment.this.getActivity().finish();
                                    }
                                }
                            });
                        } else {
                            lebaMoreFragment2.getActivity().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.leba.more.LebaMoreFragment.7.2
                                static IPatchRedirector $redirector_;

                                {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass7.this);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                    } else {
                                        LebaMoreFragment.this.Ih();
                                    }
                                }
                            });
                        }
                        QQToast.makeText(LebaMoreFragment.this.getContext(), 2, HardCodeUtil.qqStr(R.string.f162131zl), 0).show();
                    } else {
                        LebaMoreFragment.this.getActivity().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.leba.more.LebaMoreFragment.7.3
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass7.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                } else {
                                    QQToast.makeText(BaseApplication.getContext(), 1, LebaMoreFragment.this.getString(R.string.f162171zp), 0).show();
                                }
                            }
                        });
                    }
                    LebaMoreFragment.this.L = false;
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ah(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        onBackEvent();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Bh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Eh();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ch(BasePluginDataManager basePluginDataManager, int i3, boolean z16) {
        if (this.F != null) {
            Pair<List<n>, List<n>> e16 = basePluginDataManager.e();
            this.F.k(e16.getFirst(), e16.getSecond(), this.G, this.D, i3, z16);
            Jh();
            return;
        }
        QLog.i("LebaMoreFragment", 1, "mDataLogic == null");
    }

    private void Fh() {
        Intent intent;
        FragmentActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null) {
            return;
        }
        QLog.i("LebaMoreFragment", 1, "printIntentData activity flag: " + Integer.toHexString(intent.getFlags()) + ", data:" + intent.getExtras());
    }

    private void uh() {
        if (getQBaseActivity() == null) {
            return;
        }
        if (getQBaseActivity().getIntent().getBooleanExtra("key_open_edit_mode", false) && !this.H) {
            Ih();
        }
        yh();
    }

    private void yh() {
        RelativeLayout relativeLayout = this.titleRoot;
        if (relativeLayout == null) {
            return;
        }
        View findViewById = relativeLayout.findViewById(R.id.ivTitleBtnRightText);
        if (findViewById != null) {
            findViewById.setAccessibilityDelegate(new a());
        }
        View findViewById2 = this.titleRoot.findViewById(R.id.ivTitleBtnLeftButton);
        if (findViewById2 != null) {
            findViewById2.setAccessibilityDelegate(new b());
        }
        View findViewById3 = this.titleRoot.findViewById(R.id.ivTitleBtnLeft);
        if (findViewById3 != null) {
            findViewById3.setContentDescription(getString(R.string.f170549u3));
            findViewById3.setAccessibilityDelegate(new c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean zh() {
        int intExtra = getActivity().getIntent().getIntExtra("key_leba_style", -1);
        if (intExtra != 1 && intExtra != 2) {
            if (!com.tencent.mobileqq.leba.feed.d.a() || !((ILebaUIStyleSettingApi) QRoute.api(ILebaUIStyleSettingApi.class)).checkModeSupportQzoneFrame()) {
                return false;
            }
        } else if (intExtra != 2) {
            return false;
        }
        return true;
    }

    public void Dh() {
        final int o16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        int i3 = 1;
        QLog.i("LebaMoreFragment", 1, "loadDate");
        AppRuntime th5 = th();
        if (th5 == null) {
            QLog.i("LebaMoreFragment", 1, "updateDate appRuntime == null");
            return;
        }
        final boolean zh5 = zh();
        if (zh5) {
            o16 = LebaPluginLogic.p();
        } else {
            o16 = LebaPluginLogic.o(th5, this.G);
        }
        if (zh5) {
            i3 = 2;
        }
        final BasePluginDataManager b16 = com.tencent.mobileqq.leba.core.b.b(i3);
        com.tencent.mobileqq.leba.util.a.b(new Runnable() { // from class: com.tencent.mobileqq.leba.more.b
            @Override // java.lang.Runnable
            public final void run() {
                LebaMoreFragment.this.Ch(b16, o16, zh5);
            }
        });
    }

    @Override // com.tencent.mobileqq.leba.core.BasePluginDataManager.d
    public void Ef(@Nullable List<? extends n> list, @Nullable List<? extends n> list2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) list, (Object) list2);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable(list, list2) { // from class: com.tencent.mobileqq.leba.more.LebaMoreFragment.9
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ List f240683d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ List f240684e;

                {
                    this.f240683d = list;
                    this.f240684e = list2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, LebaMoreFragment.this, list, list2);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    int o16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (LebaMoreFragment.this.zh()) {
                        o16 = LebaPluginLogic.p();
                    } else {
                        o16 = LebaPluginLogic.o(LebaMoreFragment.this.th(), LebaMoreFragment.this.G);
                    }
                    int i3 = o16;
                    LebaMoreFragment lebaMoreFragment = LebaMoreFragment.this;
                    lebaMoreFragment.F.k(this.f240683d, this.f240684e, lebaMoreFragment.G, lebaMoreFragment.D, i3, lebaMoreFragment.zh());
                }
            });
        }
    }

    public void Eh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (this.H) {
            VideoReport.setElementId(this.rightViewText, "em_discover_finish_button");
            this.F.v(th());
            showLoading();
        } else {
            VideoReport.setElementId(this.rightViewText, "em_discover_manage_button");
            Ih();
        }
    }

    public void Gh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            QLog.i("LebaMoreFragment", 1, "refreshData");
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.leba.more.LebaMoreFragment.6
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LebaMoreFragment.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        com.tencent.mobileqq.leba.core.e.a().h(LebaMoreFragment.this.th());
                        LebaMoreFragment.this.Dh();
                    }
                }
            }, 160, null, true);
        }
    }

    public void Hh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            DialogUtil.createCustomDialog(getContext(), 0, (String) null, HardCodeUtil.qqStr(R.string.f162151zn), HardCodeUtil.qqStr(R.string.f162141zm), HardCodeUtil.qqStr(R.string.f162161zo), new d(), new e()).show();
        }
    }

    public void Ih() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        this.F.t(false);
        boolean z16 = !this.H;
        this.H = z16;
        if (z16) {
            i3 = R.string.f162081zg;
        } else {
            i3 = R.string.f162121zk;
        }
        this.quiSecNavBar.setRightText(HardCodeUtil.qqStr(i3));
        if (this.H) {
            this.quiSecNavBar.setBaseViewVisible(BaseAction.ACTION_LEFT_TEXT, true);
            this.quiSecNavBar.setBaseViewVisible(BaseAction.ACTION_LEFT_BUTTON, false);
        } else {
            this.quiSecNavBar.setBaseViewVisible(BaseAction.ACTION_LEFT_TEXT, false);
            this.quiSecNavBar.setBaseViewVisible(BaseAction.ACTION_LEFT_BUTTON, true);
        }
        com.tencent.mobileqq.leba.more.a aVar = this.D;
        if (aVar != null) {
            aVar.x(this.H);
        }
    }

    public void Jh() {
        LebaMoreDataLogic lebaMoreDataLogic;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        TextView textView = this.rightViewText;
        if (textView != null && (lebaMoreDataLogic = this.F) != null) {
            if (lebaMoreDataLogic.m()) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            textView.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @android.support.annotation.Nullable ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, layoutInflater, viewGroup, bundle);
            return;
        }
        Context context = getContext();
        if (context == null) {
            QLog.i("LebaMoreFragment", 1, "doOnCreateView context == null");
            return;
        }
        LebaPluginLogic.a(this.M);
        this.E = ThemeUtil.isNowThemeIsNight(null, false, null);
        this.G = LebaPluginLogic.e();
        QLog.i("LebaMoreFragment", 1, "doOnCreateView mIsNowThemeIsNight=" + this.E + ",mModel=" + this.G);
        Fh();
        vh();
        xh();
        wh(context);
        uh();
        com.tencent.mobileqq.leba.report.d.q(getActivity(), this.titleRoot, "pg_discover_list_secondary_page");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.gxj;
    }

    protected void hideLoading() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        if (getActivity() != null && !getActivity().isFinishing()) {
            Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.leba.more.LebaMoreFragment.8
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LebaMoreFragment.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    Dialog dialog = LebaMoreFragment.this.K;
                    if (dialog != null && dialog.isShowing()) {
                        LebaMoreFragment.this.K.dismiss();
                    }
                }
            };
            if (Looper.myLooper() != Looper.getMainLooper()) {
                if (getActivity() != null) {
                    getActivity().runOnUiThread(runnable);
                    return;
                }
                return;
            }
            runnable.run();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.leba.more.a.e
    public void o2(View view, n nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) view, (Object) nVar);
            return;
        }
        if (nVar != null && view != null) {
            com.tencent.mobileqq.leba.entity.f fVar = new com.tencent.mobileqq.leba.entity.f();
            fVar.f240480d = zh();
            fVar.f240481e = true;
            this.F.r(view, nVar, fVar);
            return;
        }
        QLog.i("LebaMoreFragment", 1, "onItemClick pluginInfo == null || item.pluginInfo == null");
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment
    public void onAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            super.onAccountChanged();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        if (this.H) {
            if (this.F.o()) {
                Hh();
                return true;
            }
            Ih();
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        hideLoading();
        this.I.e();
        LebaPluginLogic.x(this.M);
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else {
            this.I.g();
            super.onPause();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            super.onPostThemeChanged();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        this.I.i(false);
        this.I.f();
        super.onResume();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        } else {
            super.onStop();
        }
    }

    protected void showLoading() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        if (getActivity() != null && !getActivity().isFinishing()) {
            if (this.K == null) {
                this.K = DialogUtil.createWaitingDialog(getActivity(), R.string.f162071zf);
            }
            if (!this.K.isShowing()) {
                this.K.show();
            }
        }
    }

    public AppRuntime th() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (AppRuntime) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        if (getQBaseActivity() == null) {
            return null;
        }
        return getQBaseActivity().getAppRuntime();
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean useQUISecNavBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return true;
    }

    public void vh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        h hVar = new h();
        hVar.f240693a = this;
        this.I.d(hVar);
        this.J.a();
        this.J.c(getActivity());
    }

    public void wh(Context context) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) context);
            return;
        }
        LebaMoreDataLogic lebaMoreDataLogic = new LebaMoreDataLogic();
        this.F = lebaMoreDataLogic;
        lebaMoreDataLogic.j(th());
        this.F.u(this.J);
        if (zh()) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        com.tencent.mobileqq.leba.more.a aVar = new com.tencent.mobileqq.leba.more.a(context, this.F, this.E, i3, this);
        this.D = aVar;
        aVar.A(this.J);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 4);
        gridLayoutManager.setSpanSizeLookup(new g(this.D));
        this.D.y(gridLayoutManager);
        this.D.z(this.G);
        RecyclerView recyclerView = (RecyclerView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.i4m);
        this.C = recyclerView;
        recyclerView.setLayoutManager(gridLayoutManager);
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.C.setItemAnimator(defaultItemAnimator);
        this.C.addItemDecoration(new f(getActivity(), this.D, this.E));
        this.C.setAdapter(this.D);
        Dh();
        Gh();
    }

    public void xh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        setTitle(getString(R.string.f162101zi));
        this.quiSecNavBar.setLeftText(HardCodeUtil.qqStr(R.string.cancel));
        this.quiSecNavBar.setLeftType(1);
        QUISecNavBar qUISecNavBar = this.quiSecNavBar;
        BaseAction baseAction = BaseAction.ACTION_LEFT_TEXT;
        qUISecNavBar.setBaseClickListener(baseAction, new View.OnClickListener() { // from class: com.tencent.mobileqq.leba.more.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LebaMoreFragment.this.Ah(view);
            }
        });
        this.quiSecNavBar.setBaseViewVisible(baseAction, false);
        QUISecNavBar qUISecNavBar2 = this.quiSecNavBar;
        BaseAction baseAction2 = BaseAction.ACTION_LEFT_BUTTON;
        qUISecNavBar2.setBaseViewVisible(baseAction2, true);
        this.quiSecNavBar.setBaseViewDescription(baseAction2, HardCodeUtil.qqStr(R.string.f170549u3));
        this.quiSecNavBar.setRightType(1);
        this.quiSecNavBar.setBaseClickListener(BaseAction.ACTION_RIGHT_TEXT, new View.OnClickListener() { // from class: com.tencent.mobileqq.leba.more.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LebaMoreFragment.this.Bh(view);
            }
        });
        this.quiSecNavBar.setRightText(HardCodeUtil.qqStr(R.string.f162121zk));
    }
}
