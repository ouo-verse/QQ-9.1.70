package com.tencent.mobileqq.activity.recent.msgbox;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService;
import com.tencent.mobileqq.activity.recent.msgbox.data.RecentFilterMsgBoxDataItem;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.quibadge.QUIBadgeDragLayout;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/* compiled from: P */
/* loaded from: classes10.dex */
public class FilterMsgBoxFragment extends IphoneTitleBarFragment implements Observer, com.tencent.mobileqq.activity.recent.e, DragFrameLayout.b, View.OnTouchListener, GestureDetector.OnGestureListener {
    static IPatchRedirector $redirector_;
    FPSSwipListView C;
    RecentAdapter D;
    protected DragFrameLayout E;
    private Context F;
    private QQAppInterface G;
    private float H;
    GestureDetector I;
    private boolean J;
    protected boolean K;
    private h L;
    private TextView M;
    private int N;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a extends h {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FilterMsgBoxFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.activity.recent.msgbox.h, mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
            } else if (i3 == 1) {
                FilterMsgBoxFragment.this.Fh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FilterMsgBoxFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (!FilterMsgBoxFragment.this.getBaseActivity().isFinishing()) {
                ReportController.o(FilterMsgBoxFragment.this.G, "dc00898", "", "", "0X800B6B8", "0X800B6B8", 0, 0, "", "", "", "");
                FilterMsgBoxFragment.this.showActionSheet();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f185686d;

        c(ActionSheet actionSheet) {
            this.f185686d = actionSheet;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FilterMsgBoxFragment.this, (Object) actionSheet);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
            } else {
                FilterMsgBoxFragment.this.yh();
                this.f185686d.dismiss();
            }
        }
    }

    public FilterMsgBoxFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.J = true;
        }
    }

    private void Ch() {
        FPSSwipListView fPSSwipListView = (FPSSwipListView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.v5u);
        this.C = fPSSwipListView;
        fPSSwipListView.setVisibility(0);
        this.C.addHeaderView(View.inflate(this.F, R.layout.e7i, null));
        this.C.addFooterView(View.inflate(this.F, R.layout.f167783hc, null));
        RecentAdapter recentAdapter = new RecentAdapter(this.F, this.G, this.C, this, 14);
        this.D = recentAdapter;
        recentAdapter.x(22);
        this.C.setAdapter((ListAdapter) this.D);
        if (this.E == null) {
            DragFrameLayout e16 = DragFrameLayout.e(getBaseActivity());
            this.E = e16;
            e16.addOnDragModeChangeListener(this, false);
        }
        this.D.w(this.E);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fh() {
        getBaseActivity().runOnUiThread(new Runnable(getDataList()) { // from class: com.tencent.mobileqq.activity.recent.msgbox.FilterMsgBoxFragment.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ List f185680d;

            {
                this.f185680d = r5;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) FilterMsgBoxFragment.this, (Object) r5);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                RecentAdapter recentAdapter;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                DragFrameLayout dragFrameLayout = FilterMsgBoxFragment.this.E;
                if (dragFrameLayout != null && dragFrameLayout.getMode() == -1 && (recentAdapter = FilterMsgBoxFragment.this.D) != null) {
                    recentAdapter.v(this.f185680d);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hh(int i3, String str) {
        TextView textView;
        if (ThemeUtil.isDefaultOrDIYTheme(false)) {
            textView = this.mLeftBackText;
        } else {
            textView = this.M;
        }
        if (textView == null) {
            return;
        }
        if (i3 <= 0) {
            textView.setVisibility(4);
            return;
        }
        textView.setVisibility(0);
        textView.setText(str);
        textView.setContentDescription(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ih() {
        String valueOf;
        int H1 = this.G.getMessageFacade().H1() + com.tencent.mobileqq.qcall.f.w(this.G);
        if (H1 > 99) {
            valueOf = "99+";
        } else if (H1 <= 0) {
            valueOf = "";
        } else {
            valueOf = String.valueOf(H1);
        }
        getBaseActivity().runOnUiThread(new Runnable(H1, valueOf) { // from class: com.tencent.mobileqq.activity.recent.msgbox.FilterMsgBoxFragment.7
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f185681d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f185682e;

            {
                this.f185681d = H1;
                this.f185682e = valueOf;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, FilterMsgBoxFragment.this, Integer.valueOf(H1), valueOf);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    FilterMsgBoxFragment.this.Hh(this.f185681d, this.f185682e);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        });
    }

    private void Jh() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            Kh();
            return;
        }
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null) {
            return;
        }
        baseActivity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.recent.msgbox.FilterMsgBoxFragment.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) FilterMsgBoxFragment.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    FilterMsgBoxFragment.this.Kh();
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kh() {
        if (this.leftView != null && this.mLeftBackText != null && this.M != null && isAdded()) {
            if (ThemeUtil.isDefaultOrDIYTheme(false)) {
                this.M.setVisibility(8);
                this.leftView.setVisibility(8);
                this.mLeftBackIcon.setVisibility(0);
                this.mLeftBackIcon.setContentDescription(HardCodeUtil.qqStr(R.string.f171898lr0));
                BaseAIOUtils.h(this.mLeftBackText, 0, 0, 0, (int) ((this.mDensity * 30.0f) + 0.5f));
            } else {
                this.leftView.setVisibility(0);
                ColorStateList colorStateList = getResources().getColorStateList(R.color.skin_bar_text);
                this.M.setTextColor(colorStateList);
                GradientDrawable gradientDrawable = (GradientDrawable) this.M.getBackground();
                if (gradientDrawable != null) {
                    gradientDrawable.setColor(colorStateList);
                    gradientDrawable.setAlpha(46);
                }
                if (!ThemeUtil.isNowThemeIsSimple(this.G, false, null)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.M.getLayoutParams();
                    layoutParams.leftMargin = BaseAIOUtils.f(28.0f, getResources());
                    this.M.setLayoutParams(layoutParams);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.leftView.getLayoutParams();
                    layoutParams2.leftMargin = BaseAIOUtils.f(5.0f, getResources());
                    this.leftView.setLayoutParams(layoutParams2);
                }
                this.mLeftBackIcon.setVisibility(8);
                this.mLeftBackText.setVisibility(8);
            }
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.activity.recent.msgbox.FilterMsgBoxFragment.6
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) FilterMsgBoxFragment.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        FilterMsgBoxFragment.this.Ih();
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            }, 8, null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<RecentBaseData> getDataList() {
        ArrayList arrayList = new ArrayList();
        for (RecentUser recentUser : ((ITempMsgBoxService) QRoute.api(ITempMsgBoxService.class)).getFilterBoxRecentUsers(this.G)) {
            MessageRecord messageRecord = new MessageRecord();
            messageRecord.istroop = recentUser.getType();
            messageRecord.senderuin = recentUser.uin;
            arrayList.add(messageRecord);
        }
        if (QLog.isColorLevel()) {
            QLog.d("FilterMessageBoxFragment", 2, "fillData() called " + arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        RecentUserProxy m3 = this.G.getProxyManager().m();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            MessageRecord messageRecord2 = (MessageRecord) arrayList.get(i3);
            String str = messageRecord2.senderuin;
            int i16 = messageRecord2.istroop;
            RecentUser findRecentUser = m3.findRecentUser(str, i16);
            if (findRecentUser == null) {
                findRecentUser = new RecentUser(str, i16);
            }
            RecentFilterMsgBoxDataItem recentFilterMsgBoxDataItem = new RecentFilterMsgBoxDataItem(findRecentUser);
            recentFilterMsgBoxDataItem.update(this.G, this.F);
            arrayList2.add(recentFilterMsgBoxDataItem);
        }
        return arrayList2;
    }

    private void initTitleBar() {
        setTitle(this.F.getResources().getString(R.string.f13491001));
        this.rightViewText.setText(R.string.f220956_i);
        this.rightViewText.setVisibility(0);
        this.rightViewText.setOnClickListener(new b());
        Jh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showActionSheet() {
        ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this.F, null);
        actionSheet.setMainTitle(R.string.f220976_k);
        actionSheet.addButton(R.string.f220966_j, 3);
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.setOnButtonClickListener(new c(actionSheet));
        actionSheet.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zh(RecentBaseData recentBaseData) {
        RecentUser recentUser;
        int i3;
        if (recentBaseData != null) {
            if (recentBaseData instanceof RecentFilterMsgBoxDataItem) {
                RecentFilterMsgBoxDataItem recentFilterMsgBoxDataItem = (RecentFilterMsgBoxDataItem) recentBaseData;
                recentUser = recentFilterMsgBoxDataItem.d();
                i3 = recentFilterMsgBoxDataItem.mPosition;
            } else {
                recentUser = null;
                i3 = -1;
            }
            if (recentUser != null) {
                RecentUtil.q(this.G, recentUser, i3);
            }
        }
    }

    protected void Ah(RecentBaseData recentBaseData, String str, boolean z16) {
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z18 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, recentBaseData, str, Boolean.valueOf(z16));
            return;
        }
        RecentUserProxy m3 = this.G.getProxyManager().m();
        String recentUserUin = recentBaseData.getRecentUserUin();
        int recentUserType = recentBaseData.getRecentUserType();
        if (recentUserUin != null && recentUserUin.length() != 0 && m3 != null) {
            RecentUser findRecentUser = m3.findRecentUser(recentUserUin, recentUserType);
            if (findRecentUser == null) {
                findRecentUser = new RecentUser(recentUserUin, recentUserType);
            }
            if (z16) {
                findRecentUser.showUpTime = System.currentTimeMillis() / 1000;
            } else {
                findRecentUser.showUpTime = 0L;
            }
            m3.saveRecentUser(findRecentUser);
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onMenuItemClick error, %s ");
            if (recentUserUin == null) {
                z17 = true;
            } else {
                z17 = false;
            }
            sb5.append(z17);
            sb5.append(" ");
            if (m3 != null) {
                z18 = false;
            }
            sb5.append(z18);
            QLog.d("FilterMessageBoxFragment", 2, sb5.toString());
        }
    }

    public boolean Bh(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this, i3)).booleanValue();
        }
        if (!Dh() && (this.N & i3) == i3) {
            return true;
        }
        return false;
    }

    public boolean Dh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
        }
        if (this.N == -1) {
            return true;
        }
        return false;
    }

    public boolean Eh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this)).booleanValue();
        }
        if (this.N == 0) {
            return true;
        }
        return false;
    }

    public void Gh(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, i3);
        } else if (i3 != 0 && i3 != -1) {
            this.N = i3 | (this.N & (~i3));
        } else {
            this.N = i3;
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.e
    public void Hg(RecentBaseData recentBaseData, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) recentBaseData, (Object) str);
            return;
        }
        if (this.K) {
            zh(recentBaseData);
            return;
        }
        com.tencent.mobileqq.qcall.f fVar = (com.tencent.mobileqq.qcall.f) this.G.getManager(QQManagerFactory.RECENT_CALL_FACADE);
        if (fVar != null && recentBaseData != null) {
            try {
                fVar.j(recentBaseData.getRecentUserUin(), recentBaseData.getRecentUserType());
            } catch (Exception unused) {
                QLog.e("FilterMessageBoxFragment", 1, "delRecentCallByUin Error");
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.e
    public void Td(String str, RecentBaseData recentBaseData, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, str, recentBaseData, str2);
            return;
        }
        Resources resources = getResources();
        if (Utils.p(str, resources.getString(R.string.adi))) {
            Ah(recentBaseData, str2, false);
        } else if (Utils.p(str, resources.getString(R.string.adm))) {
            Ah(recentBaseData, str2, true);
        }
        Jh();
        Fh();
    }

    @Override // com.tencent.mobileqq.activity.recent.e
    public void U6(View view, RecentBaseData recentBaseData, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, view, recentBaseData, str, Boolean.valueOf(z16));
            return;
        }
        if (recentBaseData != null && (recentBaseData instanceof RecentFilterMsgBoxDataItem)) {
            RecentUser d16 = ((RecentFilterMsgBoxDataItem) recentBaseData).d();
            Bundle bundle = new Bundle();
            bundle.putString("KEY_OPEN_AIO_INTENT_CLASS_NAME", ChatActivity.class.getName());
            RecentUtil.y0(getBaseActivity(), this.G, d16, str, z16, 3, recentBaseData, bundle, null);
            ReportController.o(this.G, "dc00898", "", "", "0X800B5C8", "0X800B5C8", 0, 0, "", "", "", "");
        }
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, (Object) motionEvent)).booleanValue();
        }
        GestureDetector gestureDetector = this.I;
        if (gestureDetector != null && gestureDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
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
        this.H = ViewConfiguration.get(getBaseActivity()).getScaledDoubleTapSlop() * 2;
        this.K = true;
        this.I = new GestureDetector(this.F, this);
        View findViewById = ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.v5v);
        if (findViewById != null) {
            findViewById.setOnTouchListener(this);
            findViewById.setLongClickable(true);
        }
        this.M = (TextView) this.titleRoot.findViewById(R.id.dt6);
        Ch();
        initTitleBar();
        Fh();
        this.G.getMessageFacade().addObserver(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.e7h;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment
    public boolean needDispatchTouchEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.quibadge.QUIBadgeDragLayout.OnDragModeChangedListener
    public void onChange(boolean z16, int i3, QUIBadgeDragLayout qUIBadgeDragLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Boolean.valueOf(z16), Integer.valueOf(i3), qUIBadgeDragLayout);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        this.F = getBaseActivity();
        this.G = getBaseActivity().app;
        a aVar = new a();
        this.L = aVar;
        this.G.registObserver(aVar);
        if (QLog.isColorLevel()) {
            QLog.e("FilterMessageBoxFragment", 2, "doOnCreate ", this.F);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        super.onDestroy();
        RecentAdapter recentAdapter = this.D;
        if (recentAdapter != null) {
            recentAdapter.p();
        }
        FPSSwipListView fPSSwipListView = this.C;
        if (fPSSwipListView != null) {
            fPSSwipListView.setAdapter((ListAdapter) null);
        }
        DragFrameLayout dragFrameLayout = this.E;
        if (dragFrameLayout != null) {
            dragFrameLayout.removeOnDragModeChangeListener(this);
        }
        this.G.unRegistObserver(this.L);
        this.D = null;
        if (this.G.getMessageFacade() != null) {
            this.G.getMessageFacade().deleteObserver(this);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) motionEvent)).booleanValue();
        }
        Gh(0);
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, this, motionEvent, motionEvent2, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
        }
        if (!Eh() && !Dh() && motionEvent != null && motionEvent2 != null) {
            float x16 = motionEvent.getX() - motionEvent2.getX();
            float abs = Math.abs((motionEvent.getY() - motionEvent2.getY()) / x16);
            if (Bh(1)) {
                if (x16 < 0.0f && abs < 0.5f) {
                    Gh(-1);
                    if (this.J) {
                        getBaseActivity().finish();
                        return true;
                    }
                    this.J = true;
                    return false;
                }
            } else if (Bh(2) && x16 > 0.0f && abs < 0.5f) {
                Gh(-1);
                this.J = false;
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) motionEvent);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onResume();
        Jh();
        Fh();
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, this, motionEvent, motionEvent2, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
        }
        if (!Dh() && motionEvent != null && motionEvent2 != null) {
            float x16 = motionEvent.getX() - motionEvent2.getX();
            float abs = Math.abs((motionEvent.getY() - motionEvent2.getY()) / x16);
            if (Eh()) {
                if (Math.abs(x16) > this.H) {
                    if (f16 < 0.0f && abs < 0.5f) {
                        Gh(1);
                        return true;
                    }
                    if (f16 > 0.0f && abs < 0.5f) {
                        Gh(2);
                        return true;
                    }
                }
            } else if (Bh(1)) {
                if (f16 > 0.0f || abs >= 0.5f) {
                    Gh(-1);
                }
            } else if (Bh(2) && (f16 < 0.0f || abs >= 0.5f)) {
                Gh(-1);
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) motionEvent);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, (Object) motionEvent)).booleanValue();
        }
        Gh(-1);
        return false;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
        }
        GestureDetector gestureDetector = this.I;
        if (gestureDetector != null && gestureDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) observable, obj);
        } else {
            Jh();
            Fh();
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.e
    public void w4(View view, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view, obj);
        }
    }

    public void yh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.recent.msgbox.FilterMsgBoxFragment.8
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FilterMsgBoxFragment.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    Iterator it = FilterMsgBoxFragment.this.getDataList().iterator();
                    while (it.hasNext()) {
                        FilterMsgBoxFragment.this.zh((RecentBaseData) it.next());
                    }
                    FilterMsgBoxFragment.this.getBaseActivity().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.recent.msgbox.FilterMsgBoxFragment.8.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass8.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            RecentAdapter recentAdapter;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            DragFrameLayout dragFrameLayout = FilterMsgBoxFragment.this.E;
                            if (dragFrameLayout != null && dragFrameLayout.getMode() == -1 && (recentAdapter = FilterMsgBoxFragment.this.D) != null) {
                                recentAdapter.v(null);
                            }
                        }
                    });
                }
            }, 32, null, true);
        }
    }
}
