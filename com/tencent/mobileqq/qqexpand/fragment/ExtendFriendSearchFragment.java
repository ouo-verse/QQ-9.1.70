package com.tencent.mobileqq.qqexpand.fragment;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.utils.ba;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qqexpand.manager.ExtendFriendSearchHistoryManager;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.qqexpand.widget.ExtendFriendMultiLinesTagsView;
import com.tencent.mobileqq.qqexpand.widget.o;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.LoadingLayoutBase;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.extras.PullToRefreshRecyclerView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.util.aw;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.en;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.NearbyZanAnimLayout;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ExtendFriendSearchFragment extends ExtendFriendBaseFragment implements TextView.OnEditorActionListener, TextWatcher, View.OnClickListener, PullToRefreshBase.d<RecyclerView>, ExtendFriendSearchHistoryManager.a, PullToRefreshBase.c, aw.a, BounceScrollView.d {
    CancelReceiver A0;
    ImageView B0;
    ExtendFriendMultiLinesTagsView C0;
    ExtendFriendMultiLinesTagsView D0;
    ViewGroup E0;
    SystemBarCompact F0;
    private WeakReferenceHandler G0;
    private boolean I0;
    private boolean J0;
    private boolean K0;
    private byte[] M0;
    private int N0;
    private long O0;
    private com.tencent.mobileqq.qqexpand.fragment.c Q0;
    private BounceScrollView R0;
    private aw S0;
    private View T0;
    private Intent U0;
    private List<String> V0;

    /* renamed from: z0, reason: collision with root package name */
    QuickPinyinEditText f263750z0;

    /* renamed from: y0, reason: collision with root package name */
    int f263749y0 = 0;
    private final com.tencent.mobileqq.friend.observer.a H0 = new com.tencent.mobileqq.friend.observer.a() { // from class: com.tencent.mobileqq.qqexpand.fragment.ExtendFriendSearchFragment.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.friend.observer.a
        public void onUpdateAddFriend(boolean z16, boolean z17, boolean z18, String str, Bundle bundle) {
            if (QLog.isColorLevel()) {
                QLog.d("ExtendFriendSearchFragment", 2, String.format("onUpdateAddFriend isSuccess=%s addSuccess=%s reqestUin=%s", Boolean.valueOf(z16), Boolean.valueOf(z17), str));
            }
            ExtendFriendSearchFragment extendFriendSearchFragment = ExtendFriendSearchFragment.this;
            com.tencent.mobileqq.qqexpand.bean.feed.b u16 = extendFriendSearchFragment.L.u(extendFriendSearchFragment.W);
            if (u16 == null || u16.mAddFriendVerified) {
                return;
            }
            u16.mAddFriendVerified = true;
            ExtendFriendSearchFragment.this.G0.post(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.fragment.ExtendFriendSearchFragment.1.1
                @Override // java.lang.Runnable
                public void run() {
                    ExtendFriendSearchFragment extendFriendSearchFragment2 = ExtendFriendSearchFragment.this;
                    extendFriendSearchFragment2.L.notifyItemChanged(extendFriendSearchFragment2.W);
                }
            });
        }
    };
    private int L0 = 1;
    private boolean P0 = true;
    private final ExpandObserver W0 = new a();

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class CancelReceiver extends BroadcastReceiver {
        public CancelReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            QBaseActivity qBaseActivity;
            if ("com.tencent.mobileqq.search.cancel".equals(intent.getAction())) {
                QBaseActivity qBaseActivity2 = ExtendFriendSearchFragment.this.G;
                if (qBaseActivity2 != null) {
                    qBaseActivity2.finish();
                    return;
                }
                return;
            }
            if (!"com.tencent.mobileqq.search.finish".equals(intent.getAction()) || (qBaseActivity = ExtendFriendSearchFragment.this.G) == null) {
                return;
            }
            qBaseActivity.finish();
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a extends ExpandObserver {
        a() {
        }

        @Override // com.tencent.mobileqq.qqexpand.network.ExpandObserver
        protected void h(boolean z16, long j3, String str, boolean z17, byte[] bArr, boolean z18, boolean z19, int i3, List<com.tencent.mobileqq.qqexpand.bean.feed.b> list, vg2.c cVar) {
            ExtendFriendSearchFragment extendFriendSearchFragment = ExtendFriendSearchFragment.this;
            if (extendFriendSearchFragment.f263637m0 != j3) {
                return;
            }
            try {
                extendFriendSearchFragment.L0 = 1;
                ExtendFriendSearchFragment.this.Wh(z16, str, z17, bArr, z18, z19, i3, list, cVar);
            } catch (Exception e16) {
                QLog.e("ExtendFriendSearchFragment", 1, "onGetSquareStrangerList exception", e16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class b implements ExtendFriendMultiLinesTagsView.a {
        b() {
        }

        @Override // com.tencent.mobileqq.qqexpand.widget.ExtendFriendMultiLinesTagsView.a
        public void a(String str, int i3) {
            ExtendFriendSearchFragment.this.f263750z0.setText(str);
            QuickPinyinEditText quickPinyinEditText = ExtendFriendSearchFragment.this.f263750z0;
            quickPinyinEditText.setSelection(quickPinyinEditText.length());
            ExtendFriendSearchFragment.this.search(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class c implements ExtendFriendMultiLinesTagsView.a {
        c() {
        }

        @Override // com.tencent.mobileqq.qqexpand.widget.ExtendFriendMultiLinesTagsView.a
        public void a(String str, int i3) {
            ExtendFriendSearchFragment.this.f263750z0.setText(str);
            QuickPinyinEditText quickPinyinEditText = ExtendFriendSearchFragment.this.f263750z0;
            quickPinyinEditText.setSelection(quickPinyinEditText.length());
            ExtendFriendSearchFragment.this.search(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class d extends RecyclerView.AdapterDataObserver {
        d() {
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            if (ExtendFriendSearchFragment.this.L.v() == 0) {
                ExtendFriendSearchFragment extendFriendSearchFragment = ExtendFriendSearchFragment.this;
                extendFriendSearchFragment.P.removeItemDecoration(extendFriendSearchFragment.R);
            } else {
                ExtendFriendSearchFragment extendFriendSearchFragment2 = ExtendFriendSearchFragment.this;
                extendFriendSearchFragment2.P.removeItemDecoration(extendFriendSearchFragment2.R);
                ExtendFriendSearchFragment extendFriendSearchFragment3 = ExtendFriendSearchFragment.this;
                extendFriendSearchFragment3.P.addItemDecoration(extendFriendSearchFragment3.R);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class e implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f263761d;

        e(View view) {
            this.f263761d = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int[] iArr = new int[2];
            this.f263761d.getLocationInWindow(iArr);
            this.f263761d.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            ExtendFriendSearchFragment extendFriendSearchFragment = ExtendFriendSearchFragment.this;
            int i3 = iArr[1];
            extendFriendSearchFragment.f263629e0 = i3;
            extendFriendSearchFragment.f263629e0 = i3 + this.f263761d.getHeight();
        }
    }

    private void Uh() {
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendSearchFragment", 2, "autoRefresh");
        }
        if (!isAdded() || this.L == null) {
            return;
        }
        if (NetworkUtil.isNetworkAvailable(this.G)) {
            PullToRefreshRecyclerView pullToRefreshRecyclerView = this.M;
            if (pullToRefreshRecyclerView != null) {
                LoadingLayoutBase k3 = pullToRefreshRecyclerView.k();
                int height = k3 != null ? k3.getHeight() : 0;
                if (!this.M.A() && height != 0) {
                    this.M.setRefreshing();
                    this.L.B(0, true);
                    return;
                } else {
                    Eh(false);
                    return;
                }
            }
            return;
        }
        this.L0 = 0;
        Xh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vh(boolean z16) {
        this.f263750z0.setFocusable(z16);
        this.f263750z0.setFocusableInTouchMode(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wh(boolean z16, String str, boolean z17, byte[] bArr, boolean z18, boolean z19, int i3, List<com.tencent.mobileqq.qqexpand.bean.feed.b> list, vg2.c cVar) {
        com.tencent.mobileqq.qqexpand.fragment.d dVar;
        com.tencent.mobileqq.qqexpand.widget.pulltorefresh.a o16;
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendSearchFragment", 2, String.format("handleGetSquareStrangerList success=%s searchKey=%s", Boolean.valueOf(z16), str));
        }
        if (!isAdded() || (dVar = this.L) == null) {
            return;
        }
        dVar.z(!z16 ? 1 : 0);
        int i16 = R.string.fjc;
        if (z16 && list != null) {
            this.K0 = z17;
            this.M0 = bArr;
            this.Y = z18;
            this.Z = z19;
            this.N0 = i3;
            if (QLog.isColorLevel()) {
                QLog.d("ExtendFriendSearchFragment", 2, String.format("handleGetSquareStrangerList mLoadOver=%s mRequestCookies=%s mProfileComplete=%s mShowCard=%s mMaxLikeCount=%s matchCount=%d limitDuration=%d", Boolean.valueOf(this.K0), this.M0, Boolean.valueOf(this.Y), Boolean.valueOf(this.Z), Integer.valueOf(this.N0), Integer.valueOf(cVar.f441601d), Integer.valueOf(cVar.f441602e)));
            }
            if (!this.J0) {
                this.L.r();
            }
            if (this.K0) {
                this.L.B(2, false);
            }
            this.L.q(list);
            if (!this.J0) {
                this.P.scrollToPosition(0);
            }
            PullToRefreshRecyclerView pullToRefreshRecyclerView = this.M;
            if (pullToRefreshRecyclerView != null && (o16 = pullToRefreshRecyclerView.o(true, false)) != null) {
                this.O0 = System.currentTimeMillis();
                o16.setLastUpdatedLabel(String.format("%s%s", getResources().getString(R.string.hqf), en.p(this.O0, true, TuxDateStringUtils.TUX_COMMON_DATE_FORMAT)));
            }
            if (this.U0 == null) {
                this.U0 = new Intent();
            }
            this.U0.putExtra("remain_match_count", cVar.f441601d);
            this.U0.putExtra("limit_chat_duration", cVar.f441602e);
            getQBaseActivity().setResult(-1, this.U0);
        } else {
            if (this.J0) {
                this.L.B(1, true);
            }
            this.L.r();
            Ch(getString(this.L0 == 0 ? R.string.cqv : R.string.fjc), 1);
        }
        if (this.L.getItemCount() == 0) {
            this.L.s(true);
        }
        this.L.notifyDataSetChanged();
        if (!this.J0 && this.M != null) {
            if (z16) {
                i16 = R.string.fjd;
            }
            this.M.o(true, false).setRefreshResultLabel(getResources().getString(i16));
            this.M.F();
        }
        this.I0 = false;
        xh();
        Hh(true);
    }

    private boolean Yh(String str) {
        return this.K.q(2).contains(str);
    }

    private void ai(String str) {
        float width = (this.f263750z0.getWidth() - this.f263750z0.getPaddingLeft()) - this.f263750z0.getPaddingRight();
        float textSize = this.f263750z0.getTextSize();
        float max = Math.max((textSize <= 1.0f || width <= 1.0f) ? 18.0f : width / textSize, 12.0f);
        if (com.tencent.mobileqq.confess.e.a(str) > max) {
            int max2 = Math.max(0, (int) (max - 4.0f));
            int i3 = max2;
            while (max2 < str.length()) {
                if (!TextUtils.equals(String.valueOf(str.charAt(max2 - 1)), "\u3001")) {
                    if (com.tencent.mobileqq.confess.e.a(str.substring(0, max2) + "\u2026") > max) {
                        break;
                    } else {
                        i3 = max2;
                    }
                }
                max2++;
            }
            str = str.substring(0, i3) + "\u2026";
        }
        this.f263750z0.setHint(str);
    }

    private void ci() {
        try {
            if (this.F0 == null || !ThemeUtil.isInNightMode(this.H)) {
                return;
            }
            this.F0.setStatusBarMask(new PorterDuffColorFilter(getResources().getColor(R.color.a_p), PorterDuff.Mode.SRC_ATOP));
        } catch (Exception e16) {
            QZLog.e("ExtendFriendSearchFragment", "catch an exception when set the NightMode for StatusBar.", e16);
        }
    }

    private void di(int i3) {
        String str;
        this.f263749y0 = i3;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("switchToMode ");
            if (this.f263749y0 == 1) {
                str = "result";
            } else {
                str = "search";
            }
            sb5.append(str);
            QLog.i("ExtendFriendSearchFragment", 2, sb5.toString());
        }
        if (i3 == 1) {
            if (this.M.getVisibility() != 0) {
                this.M.setVisibility(0);
            }
            if (this.R0.getVisibility() != 8) {
                this.R0.setVisibility(8);
            }
            Zh(false, 50L);
            return;
        }
        this.f263750z0.requestFocus();
        this.f263750z0.setText("");
        if (this.R0.getVisibility() != 0) {
            this.R0.setVisibility(0);
        }
        if (this.M.getVisibility() != 8) {
            this.M.setVisibility(8);
        }
        Zh(true, 50L);
    }

    @Override // com.tencent.mobileqq.qqexpand.fragment.ExtendFriendBaseFragment
    protected int Ah() {
        return this.N0;
    }

    @Override // com.tencent.mobileqq.qqexpand.fragment.ExtendFriendBaseFragment
    protected int Bh() {
        return 1033;
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.ExtendFriendSearchHistoryManager.a
    public void Db() {
        this.G0.post(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.fragment.ExtendFriendSearchFragment.3
            @Override // java.lang.Runnable
            public void run() {
                QBaseActivity qBaseActivity = ExtendFriendSearchFragment.this.G;
                if (qBaseActivity == null || qBaseActivity.isFinishing() || !ExtendFriendSearchFragment.this.isAdded()) {
                    return;
                }
                ExtendFriendSearchFragment extendFriendSearchFragment = ExtendFriendSearchFragment.this;
                if (extendFriendSearchFragment.C0 != null) {
                    List<String> d16 = extendFriendSearchFragment.K.d().d();
                    ExtendFriendSearchFragment.this.C0.setSearchTags((ArrayList) d16);
                    ExtendFriendSearchFragment.this.ei(d16.size() > 0);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.qqexpand.fragment.ExtendFriendBaseFragment
    public void Eh(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendSearchFragment", 2, String.format("requestSquareStrangerList loadMore=%s keyword=%s", Boolean.valueOf(z16), this.f263636l0));
        }
        this.J0 = z16;
        if (!z16) {
            this.K0 = false;
            this.M0 = null;
        }
        if (this.J != null) {
            if (this.H != null) {
                this.f263637m0 = System.currentTimeMillis();
                com.tencent.mobileqq.qqexpand.network.e eVar = this.J;
                String currentUin = this.H.getCurrentUin();
                byte[] bArr = this.M0;
                String str = this.f263636l0;
                eVar.G0(currentUin, bArr, 20, str, this.f263637m0, "", Yh(str));
                this.I0 = true;
                return;
            }
            QLog.e("ExtendFriendSearchFragment", 2, "requestSquareStrangerList mApp is null");
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase.d
    public void F4(PullToRefreshBase<RecyclerView> pullToRefreshBase) {
        if (this.S.hasMessages(10)) {
            this.S.removeMessages(10);
            Dh();
        }
        ReportController.o(this.H, "dc00898", "", "", "0X80092D4", "0X80092D4", 0, 0, "", "", "", "");
        if (NetworkUtil.isNetworkAvailable(this.G)) {
            Eh(false);
            Ih();
            this.L.B(0, true);
        } else {
            this.L0 = 0;
            Xh();
        }
    }

    protected void Zh(boolean z16, long j3) {
        if (QLog.isColorLevel()) {
            QLog.i("ExtendFriendSearchFragment", 2, "requestToggleInputMethod " + z16);
        }
        WeakReferenceHandler weakReferenceHandler = this.G0;
        if (weakReferenceHandler == null) {
            return;
        }
        if (z16) {
            weakReferenceHandler.removeMessages(12);
            if (!this.G0.hasMessages(11)) {
                this.G0.sendEmptyMessageDelayed(11, j3);
                return;
            } else {
                if (j3 == 0) {
                    this.G0.removeMessages(11);
                    this.G0.sendEmptyMessage(11);
                    return;
                }
                return;
            }
        }
        weakReferenceHandler.removeMessages(11);
        if (!this.G0.hasMessages(12)) {
            this.G0.sendEmptyMessageDelayed(12, j3);
        } else if (j3 == 0) {
            this.G0.removeMessages(12);
            this.G0.sendEmptyMessage(11);
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String obj = this.f263750z0.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            this.B0.setVisibility(8);
        } else {
            this.B0.setVisibility(0);
        }
        if (this.f263749y0 == 1 && TextUtils.isEmpty(obj)) {
            di(0);
        }
    }

    public void bi(int i3) {
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            getQBaseActivity().getWindow().addFlags(67108864);
            if (this.F0 != null) {
                return;
            }
            SystemBarCompact systemBarCompact = new SystemBarCompact((Activity) getQBaseActivity(), false, getResources().getColor(i3));
            this.F0 = systemBarCompact;
            systemBarCompact.init();
        }
        getQBaseActivity().getWindow().addFlags(67108864);
        ci();
    }

    @Override // com.tencent.mobileqq.qqexpand.fragment.ExtendFriendBaseFragment, android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 11:
                showInputMethod();
                return false;
            case 12:
                hideInputMethod();
                return false;
            case 13:
                Uh();
                return false;
            default:
                return false;
        }
    }

    protected void hideInputMethod() {
        if (QLog.isColorLevel()) {
            QLog.i("ExtendFriendSearchFragment", 2, "hideInputMethod");
        }
        this.f263750z0.clearFocus();
        ((InputMethodManager) BaseApplication.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(this.f263750z0.getWindowToken(), 0);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendSearchFragment", 2, String.format("onActivityResult requestCode=%s resultCode=%s", Integer.valueOf(i3), Integer.valueOf(i16)));
        }
        if (i3 == 1033) {
            Jh();
            Kh(true, true);
            if (i16 == 8193) {
                th();
            }
            this.W = -1;
            if (this.U0 == null) {
                this.U0 = new Intent();
            }
            this.U0.putExtra("has_entered_profile", true);
            getQBaseActivity().setResult(-1, this.U0);
            return;
        }
        if (i3 != 1 || i16 != -1) {
            if (i3 == 2 && i16 == -1) {
                if (this.U0 == null) {
                    this.U0 = new Intent();
                }
                this.U0.putExtra("has_entered_profile", true);
                getQBaseActivity().setResult(-1, this.U0);
                Kh(false, true);
                return;
            }
            return;
        }
        com.tencent.mobileqq.qqexpand.bean.feed.b u16 = this.L.u(this.V);
        if (u16 == null || u16.mAddFriendVerified) {
            return;
        }
        u16.mAddFriendVerified = true;
        this.L.notifyItemChanged(this.V);
        if (this.V0 == null) {
            this.V0 = new ArrayList();
        }
        this.V0.add(u16.mUin);
        if (this.U0 == null) {
            this.U0 = new Intent();
        }
        if (this.U0.hasExtra("add_frd_list")) {
            this.U0.removeExtra("add_frd_list");
        }
        this.U0.putStringArrayListExtra("add_frd_list", (ArrayList) this.V0);
        getQBaseActivity().setResult(-1, this.U0);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        if (this.f263749y0 == 1) {
            di(0);
            return true;
        }
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i3 = this.f263749y0 == 0 ? 1 : 2;
        switch (view.getId()) {
            case R.id.ozu /* 1912930361 */:
                this.K.d().c();
                ReportController.o(this.H, "dc00898", "", "", "0X8009418", "0X8009418", 0, 0, "", "", "", "");
                return;
            case R.id.p1h /* 1912930422 */:
                if (this.f263749y0 == 1) {
                    di(0);
                } else {
                    QBaseActivity qBaseActivity = this.G;
                    if (qBaseActivity != null) {
                        qBaseActivity.finish();
                    }
                }
                ReportController.o(this.H, "dc00898", "", "", "0X800941A", "0X800941A", i3, 0, "", "", "", "");
                return;
            case R.id.p1i /* 1912930423 */:
                if (this.f263749y0 == 1) {
                    di(0);
                }
                this.f263750z0.setText("");
                ReportController.o(this.H, "dc00898", "", "", "0X8009419", "0X8009419", i3, 0, "", "", "", "");
                return;
            default:
                return;
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.fragment.ExtendFriendBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = this.G.getWindow();
        if (window != null) {
            window.setFormat(-3);
            window.setBackgroundDrawable(new ColorDrawable(-1));
        }
        this.A0 = new CancelReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mobileqq.search.cancel");
        intentFilter.addAction("com.tencent.mobileqq.search.finish");
        this.G.registerReceiver(this.A0, intentFilter);
        this.K.d().g(this);
        this.H.addObserver(this.W0);
        this.H.addObserver(this.H0);
        this.G0 = new WeakReferenceHandler(Looper.getMainLooper(), this);
        this.Q0 = new com.tencent.mobileqq.qqexpand.fragment.c(this.H);
    }

    @Override // com.tencent.mobileqq.qqexpand.fragment.ExtendFriendBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        try {
            CancelReceiver cancelReceiver = this.A0;
            if (cancelReceiver != null) {
                this.G.unregisterReceiver(cancelReceiver);
                this.A0 = null;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        this.G0.removeCallbacksAndMessages(null);
        try {
            this.f263750z0.setFocusable(false);
            this.f263750z0.setFocusableInTouchMode(false);
            this.f263750z0.setVisibility(8);
            if (this.f263750z0.getParent() != null) {
                ((ViewGroup) this.f263750z0.getParent()).removeView(this.f263750z0);
            }
            this.f263750z0.removeTextChangedListener(this);
            this.f263750z0.setOnEditorActionListener(null);
        } catch (Error e17) {
            e17.printStackTrace();
        } catch (Exception e18) {
            e18.printStackTrace();
        }
        com.tencent.mobileqq.qqexpand.fragment.c cVar = this.Q0;
        if (cVar != null) {
            cVar.c();
            this.Q0 = null;
        }
        QQAppInterface qQAppInterface = this.H;
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(this.W0);
            this.H.removeObserver(this.H0);
            this.H = null;
        }
        RecyclerView.AdapterDataObserver adapterDataObserver = this.Q;
        if (adapterDataObserver != null) {
            this.L.unregisterAdapterDataObserver(adapterDataObserver);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        super.onFinish();
        if (getQBaseActivity() != null) {
            getQBaseActivity().overridePendingTransition(0, R.anim.f155053hw);
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.fragment.ExtendFriendBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com.tencent.mobileqq.qqexpand.manager.e eVar;
        super.onResume();
        bi(R.color.skin_color_title_immersive_bar);
        if (!this.P0 && this.f263749y0 == 1) {
            Vh(false);
            this.G0.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.fragment.ExtendFriendSearchFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    ExtendFriendSearchFragment.this.Vh(true);
                }
            }, 50L);
        }
        this.P0 = false;
        if (this.f263750z0 == null || (eVar = this.K) == null) {
            return;
        }
        ai(eVar.l());
    }

    @Override // com.tencent.mobileqq.search.util.aw.a
    public void onSoftKeyboardClosed() {
        this.f263750z0.setCursorVisible(false);
    }

    @Override // com.tencent.mobileqq.search.util.aw.a
    public void onSoftKeyboardOpened(int i3) {
        this.f263750z0.setCursorVisible(true);
    }

    @Override // com.tencent.mobileqq.qqexpand.fragment.ExtendFriendBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        hideInputMethod();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle bundle) {
        QuickPinyinEditText quickPinyinEditText = this.f263750z0;
        if (quickPinyinEditText != null) {
            quickPinyinEditText.removeTextChangedListener(this);
        }
        super.onViewStateRestored(bundle);
        QuickPinyinEditText quickPinyinEditText2 = this.f263750z0;
        if (quickPinyinEditText2 != null) {
            quickPinyinEditText2.addTextChangedListener(this);
        }
    }

    protected void search(final String str) {
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendSearchFragment", 2, String.format("search keyword=%s", str));
        }
        boolean isEmpty = TextUtils.isEmpty(this.f263636l0);
        this.f263636l0 = str;
        di(1);
        WeakReferenceHandler weakReferenceHandler = this.G0;
        if (weakReferenceHandler != null) {
            weakReferenceHandler.removeMessages(13);
            this.G0.sendEmptyMessageDelayed(13, isEmpty ? 200L : 50L);
        }
        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.fragment.ExtendFriendSearchFragment.10
            @Override // java.lang.Runnable
            public void run() {
                ExtendFriendSearchFragment.this.K.d().b(str);
            }
        }, null, true);
    }

    public void showInputMethod() {
        QuickPinyinEditText quickPinyinEditText;
        if (QLog.isColorLevel()) {
            QLog.i("ExtendFriendSearchFragment", 2, "showInputMethod");
        }
        if (this.G == null || (quickPinyinEditText = this.f263750z0) == null) {
            return;
        }
        quickPinyinEditText.clearFocus();
        ((InputMethodManager) this.G.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).showSoftInput(this.f263750z0, 0);
    }

    private void Xh() {
        Wh(false, this.f263636l0, false, null, false, false, 0, null, null);
    }

    @Override // com.tencent.mobileqq.qqexpand.fragment.ExtendFriendBaseFragment, com.tencent.mobileqq.qqexpand.fragment.f
    public void n6() {
        Zh(false, 50L);
    }

    @Override // com.tencent.mobileqq.widget.BounceScrollView.d
    public void onScrollChanged(int i3, int i16, int i17, int i18) {
        Zh(false, 50L);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.f167375d00, (ViewGroup) null);
        View findViewById = viewGroup2.findViewById(R.id.p1v);
        QuickPinyinEditText quickPinyinEditText = (QuickPinyinEditText) viewGroup2.findViewById(R.id.p1l);
        this.f263750z0 = quickPinyinEditText;
        quickPinyinEditText.setImeOptions(3);
        this.f263750z0.setOnEditorActionListener(this);
        this.f263750z0.addTextChangedListener(this);
        if ("1".equals(((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.search_input_type.name(), "0"))) {
            this.f263750z0.setInputType(524321);
        } else {
            this.f263750z0.setInputType(524289);
        }
        this.f263750z0.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
        this.f263750z0.setHint(this.K.l());
        aw awVar = new aw(viewGroup2);
        this.S0 = awVar;
        awVar.a(this);
        ImageView imageView = (ImageView) viewGroup2.findViewById(R.id.p1i);
        this.B0 = imageView;
        imageView.setOnTouchListener(new ba.a());
        this.B0.setOnClickListener(this);
        View findViewById2 = viewGroup2.findViewById(R.id.p1h);
        findViewById2.setOnTouchListener(new ba.a());
        findViewById2.setOnClickListener(this);
        viewGroup2.findViewById(R.id.ozu).setOnClickListener(this);
        if (findViewById != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.topMargin = ImmersiveUtils.getStatusBarHeight(this.G);
            findViewById.setLayoutParams(layoutParams);
        }
        this.E0 = (ViewGroup) viewGroup2.findViewById(R.id.ozv);
        BounceScrollView bounceScrollView = (BounceScrollView) viewGroup2.findViewById(R.id.p1s);
        this.R0 = bounceScrollView;
        bounceScrollView.setOnScrollChangedListener(this);
        this.C0 = (ExtendFriendMultiLinesTagsView) viewGroup2.findViewById(R.id.ozw);
        this.D0 = (ExtendFriendMultiLinesTagsView) viewGroup2.findViewById(R.id.f163237p15);
        this.C0.setViewMargin(BaseAIOUtils.f(10.0f, getResources()), BaseAIOUtils.f(10.0f, getResources()));
        this.D0.setViewMargin(BaseAIOUtils.f(10.0f, getResources()), BaseAIOUtils.f(10.0f, getResources()));
        this.D0.setSearchTags((ArrayList) this.K.q(2));
        List<String> d16 = this.K.d().d();
        this.C0.setSearchTags((ArrayList) d16);
        ei(d16.size() > 0);
        this.C0.setOnItemClickListener(new b());
        this.D0.setOnItemClickListener(new c());
        PullToRefreshRecyclerView pullToRefreshRecyclerView = (PullToRefreshRecyclerView) viewGroup2.findViewById(R.id.p0y);
        this.M = pullToRefreshRecyclerView;
        pullToRefreshRecyclerView.setOnRefreshListener(this);
        this.M.o(true, false).setRefreshingLabel(getResources().getString(R.string.fje));
        this.N = new o(this.G);
        RecyclerView s16 = this.M.s();
        this.P = s16;
        s16.setId(R.id.p16);
        this.P.setLayoutManager(this.N);
        ((SimpleItemAnimator) this.P.getItemAnimator()).setSupportsChangeAnimations(false);
        this.M.setOnPullEventListener(this);
        this.M.setMode(PullToRefreshBase.Mode.MANUAL_REFRESH_ONLY);
        this.P.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.tencent.mobileqq.qqexpand.fragment.ExtendFriendSearchFragment.6
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
                if (QLog.isColorLevel()) {
                    QLog.d("ExtendFriendSearchFragment", 2, String.format("onScrollStateChanged state=%s", Integer.valueOf(i3)));
                }
                ExtendFriendSearchFragment extendFriendSearchFragment = ExtendFriendSearchFragment.this;
                IFaceDecoder iFaceDecoder = extendFriendSearchFragment.F;
                if (iFaceDecoder != null) {
                    if (i3 == 0) {
                        extendFriendSearchFragment.f263625a0 = false;
                        iFaceDecoder.resume();
                        ExtendFriendSearchFragment.this.Mh();
                    } else {
                        extendFriendSearchFragment.f263625a0 = true;
                        iFaceDecoder.pause();
                        ExtendFriendSearchFragment.this.F.cancelPendingRequests();
                        synchronized (ExtendFriendBaseFragment.f263622v0) {
                            Map<ImageView, String> map = ExtendFriendSearchFragment.this.D;
                            if (map != null) {
                                map.clear();
                            }
                        }
                    }
                }
                if (i3 == 0) {
                    ExtendFriendSearchFragment.this.xh();
                    ExtendFriendSearchFragment.this.Hh(false);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
                ExtendFriendSearchFragment extendFriendSearchFragment;
                LinearLayoutManager linearLayoutManager;
                com.tencent.mobileqq.qqexpand.fragment.d dVar;
                if (!ExtendFriendSearchFragment.this.K0 && !ExtendFriendSearchFragment.this.I0 && (linearLayoutManager = (extendFriendSearchFragment = ExtendFriendSearchFragment.this).N) != null && (dVar = extendFriendSearchFragment.L) != null && linearLayoutManager.findViewByPosition(dVar.getItemCount() - 2) != null) {
                    ExtendFriendSearchFragment.this.Eh(true);
                    ExtendFriendSearchFragment.this.G0.post(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.fragment.ExtendFriendSearchFragment.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                ExtendFriendSearchFragment.this.L.B(0, true);
                            } catch (Exception e16) {
                                QLog.e("ExtendFriendSearchFragment", 1, "onScrolled fail.", e16);
                            }
                        }
                    });
                    ReportController.o(ExtendFriendSearchFragment.this.H, "dc00898", "", "", "0X80092D5", "0X80092D5", 0, 0, "", "", "", "");
                }
                ExtendFriendSearchFragment.this.Zh(false, 0L);
            }
        });
        this.R = new com.tencent.mobileqq.qqexpand.fragment.e(this);
        this.Q = new d();
        com.tencent.mobileqq.qqexpand.fragment.d dVar = new com.tencent.mobileqq.qqexpand.fragment.d(this, this, null, null, this.P, this.G, 1);
        this.L = dVar;
        dVar.registerAdapterDataObserver(this.Q);
        this.L.y(this.Q0);
        this.P.setAdapter(this.L);
        this.f263630f0 = (NearbyZanAnimLayout) viewGroup2.findViewById(R.id.ozt);
        if (findViewById != null) {
            findViewById.getViewTreeObserver().addOnGlobalLayoutListener(new e(findViewById));
        }
        View findViewById3 = viewGroup2.findViewById(R.id.p0l);
        this.T0 = findViewById3;
        if (findViewById3 != null) {
            this.T0.setVisibility(ThemeUtil.isInNightMode(this.H) ? 0 : 8);
        }
        di(0);
        return viewGroup2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ei(boolean z16) {
        int i3 = z16 ? 0 : 8;
        if (this.E0.getVisibility() != i3) {
            this.E0.setVisibility(i3);
        }
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
        if (i3 != 3 && (keyEvent == null || keyEvent.getKeyCode() != 66)) {
            return false;
        }
        String trim = this.f263750z0.getText().toString().trim();
        if (!TextUtils.isEmpty(trim)) {
            search(trim);
        }
        Zh(false, 50L);
        ReportController.o(this.H, "dc00898", "", "", "0X800941B", "0X800941B", this.f263749y0 == 0 ? 1 : 2, 0, "", "", "", "");
        return true;
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase.d
    public void s5(PullToRefreshBase<RecyclerView> pullToRefreshBase) {
    }

    @Override // com.tencent.mobileqq.widget.BounceScrollView.d
    public void ae(float f16, float f17) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase.c
    public void N9(PullToRefreshBase pullToRefreshBase, PullToRefreshBase.State state, PullToRefreshBase.Mode mode) {
    }
}
