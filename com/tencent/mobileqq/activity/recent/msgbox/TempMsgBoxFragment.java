package com.tencent.mobileqq.activity.recent.msgbox;

import android.annotation.SuppressLint;
import android.content.Intent;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.o;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.j;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService;
import com.tencent.mobileqq.activity.recent.msgbox.data.RecentTempMsgBoxItem;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.quibadge.QUIBadgeDragLayout;
import com.tencent.mobileqq.settings.business.api.ISettingSearchHightApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/* compiled from: P */
/* loaded from: classes10.dex */
public class TempMsgBoxFragment extends IphoneTitleBarFragment implements Observer, com.tencent.mobileqq.activity.recent.e, DragFrameLayout.b, View.OnTouchListener, GestureDetector.OnGestureListener {
    static IPatchRedirector $redirector_;
    protected BaseActivity C;
    protected QQAppInterface D;
    private float E;
    GestureDetector F;
    protected boolean G;
    private XListView H;
    private RecentAdapter I;
    private DragFrameLayout J;
    private boolean K;
    private h L;
    private o M;
    protected TextView N;
    private int P;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a extends h {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TempMsgBoxFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.activity.recent.msgbox.h, mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
            } else if (i3 == 1) {
                TempMsgBoxFragment.this.Ch();
                TempMsgBoxFragment.this.Gh();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b extends o {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TempMsgBoxFragment.this);
            }
        }

        @Override // com.tencent.imcore.message.o, mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
            } else if (i3 == 0) {
                TempMsgBoxFragment.this.Gh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TempMsgBoxFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ((ISettingSearchHightApi) QRoute.api(ISettingSearchHightApi.class)).startQUITempMsgSettingPage(TempMsgBoxFragment.this.C, new Intent());
                ReportController.o(TempMsgBoxFragment.this.D, "dc00898", "", "", "0X800B1C1", "0X800B1C1", 0, 0, "", "", "", "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public TempMsgBoxFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.K = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eh(int i3, String str) {
        TextView textView;
        if (ThemeUtil.isDefaultOrDIYTheme(false)) {
            textView = this.mLeftBackText;
        } else {
            textView = this.N;
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
    public void Fh(QQMessageFacade qQMessageFacade) {
        String valueOf;
        int H1 = (qQMessageFacade.H1() + com.tencent.mobileqq.qcall.f.w(this.D)) - ((ITempMsgBoxService) QRoute.api(ITempMsgBoxService.class)).getTempMsgBoxUnread(this.D);
        if (H1 > 99) {
            valueOf = "99+";
        } else if (H1 <= 0) {
            valueOf = "";
        } else {
            valueOf = String.valueOf(H1);
        }
        this.C.runOnUiThread(new Runnable(H1, valueOf) { // from class: com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxFragment.7
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f185690d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f185691e;

            {
                this.f185690d = H1;
                this.f185691e = valueOf;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, TempMsgBoxFragment.this, Integer.valueOf(H1), valueOf);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    TempMsgBoxFragment.this.Eh(this.f185690d, this.f185691e);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gh() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            Hh();
            return;
        }
        BaseActivity baseActivity = this.C;
        if (baseActivity == null) {
            return;
        }
        baseActivity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxFragment.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TempMsgBoxFragment.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    TempMsgBoxFragment.this.Hh();
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hh() {
        if (this.leftView != null && this.mLeftBackText != null && this.N != null && isAdded()) {
            if (ThemeUtil.isDefaultOrDIYTheme(false)) {
                this.N.setVisibility(8);
                this.leftView.setVisibility(8);
                this.mLeftBackIcon.setVisibility(0);
                this.mLeftBackIcon.setContentDescription(HardCodeUtil.qqStr(R.string.f171898lr0));
                BaseAIOUtils.h(this.mLeftBackText, 0, 0, 0, (int) ((this.mDensity * 30.0f) + 0.5f));
            } else {
                this.leftView.setVisibility(0);
                ColorStateList colorStateList = getResources().getColorStateList(R.color.skin_bar_text);
                this.N.setTextColor(colorStateList);
                GradientDrawable gradientDrawable = (GradientDrawable) this.N.getBackground();
                if (gradientDrawable != null) {
                    gradientDrawable.setColor(colorStateList);
                    gradientDrawable.setAlpha(46);
                }
                if (!ThemeUtil.isNowThemeIsSimple(this.D, false, null)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.N.getLayoutParams();
                    layoutParams.leftMargin = BaseAIOUtils.f(28.0f, getResources());
                    this.N.setLayoutParams(layoutParams);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.leftView.getLayoutParams();
                    layoutParams2.leftMargin = BaseAIOUtils.f(5.0f, getResources());
                    this.leftView.setLayoutParams(layoutParams2);
                }
                this.mLeftBackIcon.setVisibility(8);
                this.mLeftBackText.setVisibility(8);
            }
            QQMessageFacade messageFacade = this.D.getMessageFacade();
            if (messageFacade == null) {
                return;
            }
            ThreadManagerV2.post(new Runnable(messageFacade) { // from class: com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxFragment.6
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ QQMessageFacade f185689d;

                {
                    this.f185689d = messageFacade;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) TempMsgBoxFragment.this, (Object) messageFacade);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        TempMsgBoxFragment.this.Fh(this.f185689d);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            }, 8, null, true);
        }
    }

    private void initData() {
        if (QLog.isColorLevel()) {
            QLog.d("TempMsgBoxFragment", 2, "initData() called");
        }
        Ch();
        this.D.getMessageFacade().addObserver(this);
    }

    private void initTitleBar() {
        if (QLog.isColorLevel()) {
            QLog.e("TempMsgBoxFragment", 2, "initTitleBar");
        }
        setTitle(this.C.getString(R.string.f2053855g));
        ImageView imageView = this.rightViewImg;
        imageView.setImageResource(R.drawable.b4m);
        imageView.setContentDescription(getString(R.string.f2053655e));
        imageView.setOnClickListener(new c());
        imageView.setVisibility(0);
        Gh();
        this.titleRoot.setBackgroundResource(R.drawable.skin_header_bar_bg);
    }

    private void wh(RecentBaseData recentBaseData) {
        RecentUser recentUser;
        int i3;
        if (recentBaseData instanceof RecentTempMsgBoxItem) {
            RecentTempMsgBoxItem recentTempMsgBoxItem = (RecentTempMsgBoxItem) recentBaseData;
            recentUser = recentTempMsgBoxItem.d();
            i3 = recentTempMsgBoxItem.mPosition;
        } else {
            recentUser = null;
            i3 = -1;
        }
        if (recentUser != null) {
            RecentUtil.q(this.D, recentUser, i3);
        }
    }

    private void xh(RecentBaseData recentBaseData, String str, boolean z16) {
        RecentUser findRecentUserByUin = this.D.getRecentUserProxy().findRecentUserByUin(recentBaseData.getRecentUserUin(), recentBaseData.getRecentUserType());
        Bundle bundle = new Bundle();
        bundle.putBoolean(AppConstants.Key.KEY_ENTER_FROM_TEMP_MSG_BOX, true);
        bundle.putBoolean(AppConstants.Key.KEY_NEED_TO_SHOW_UNREAD_NUM, true);
        bundle.putString("KEY_OPEN_AIO_INTENT_CLASS_NAME", ChatActivity.class.getName());
        RecentUtil.y0(this.C, this.D, findRecentUserByUin, str, z16, 3, recentBaseData, bundle, null);
    }

    private void zh() {
        if (QLog.isColorLevel()) {
            QLog.e("TempMsgBoxFragment", 2, "initContentView");
        }
        XListView xListView = (XListView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f93865aq);
        this.H = xListView;
        xListView.setVisibility(0);
        this.H.addFooterView(View.inflate(this.C, R.layout.f167783hc, null));
        RecentAdapter recentAdapter = new RecentAdapter(this.C, this.D, this.H, this, 15);
        this.I = recentAdapter;
        recentAdapter.x(23);
        this.H.setAdapter((ListAdapter) this.I);
        if (this.J == null) {
            DragFrameLayout e16 = DragFrameLayout.e(this.C);
            this.J = e16;
            e16.addOnDragModeChangeListener(this, false);
        }
        this.I.w(this.J);
    }

    public boolean Ah() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
        }
        if (this.P == -1) {
            return true;
        }
        return false;
    }

    public boolean Bh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this)).booleanValue();
        }
        if (this.P == 0) {
            return true;
        }
        return false;
    }

    public void Ch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        List<RecentUser> msgBoxRecentUsers = ((ITempMsgBoxManager) this.D.getRuntimeService(ITempMsgBoxManager.class, "")).getMsgBoxRecentUsers();
        if (QLog.isColorLevel()) {
            QLog.d("TempMsgBoxFragment", 2, "refreshTempMsgBoxList() called " + msgBoxRecentUsers);
        }
        ArrayList arrayList = new ArrayList(msgBoxRecentUsers.size());
        for (int i3 = 0; i3 < msgBoxRecentUsers.size(); i3++) {
            RecentUser recentUser = msgBoxRecentUsers.get(i3);
            if (recentUser != null) {
                RecentTempMsgBoxItem recentTempMsgBoxItem = new RecentTempMsgBoxItem(recentUser);
                recentTempMsgBoxItem.update(this.D, this.C);
                arrayList.add(recentTempMsgBoxItem);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("TempMsgBoxFragment", 2, "refreshTempMsgBoxList() after sort " + arrayList);
        }
        this.C.runOnUiThread(new Runnable(arrayList) { // from class: com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxFragment.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ List f185688d;

            {
                this.f185688d = arrayList;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TempMsgBoxFragment.this, (Object) arrayList);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else if (TempMsgBoxFragment.this.J != null && TempMsgBoxFragment.this.J.getMode() == -1 && TempMsgBoxFragment.this.I != null) {
                    TempMsgBoxFragment.this.I.x(23);
                    TempMsgBoxFragment.this.I.v(this.f185688d);
                }
            }
        });
    }

    public void Dh(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, i3);
        } else if (i3 != 0 && i3 != -1) {
            this.P = i3 | (this.P & (~i3));
        } else {
            this.P = i3;
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.e
    public void Hg(RecentBaseData recentBaseData, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) recentBaseData, (Object) str);
            return;
        }
        if (recentBaseData == null) {
            return;
        }
        wh(recentBaseData);
        List<RecentUser> msgBoxRecentUsers = ((ITempMsgBoxManager) this.D.getRuntimeService(ITempMsgBoxManager.class, "")).getMsgBoxRecentUsers();
        if (QLog.isColorLevel()) {
            QLog.d("TempMsgBoxFragment", 2, "onRecentBaseDataDelete() called with: data = [" + recentBaseData + "], msgBoxRecentUsers = [" + msgBoxRecentUsers + "]");
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.e
    public void Td(String str, RecentBaseData recentBaseData, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, recentBaseData, str2);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TempMsgBoxFragment", 2, "menuItem clicked ", str, " data " + recentBaseData, " uin ", recentBaseData.getRecentUserUin(), " type ", Integer.valueOf(recentBaseData.getRecentUserType()));
        }
        Resources resources = getResources();
        int[] iArr = j.f185633c;
        if (Utils.p(str, resources.getString(iArr[3]))) {
            ((ITempMsgBoxManager) this.D.getRuntimeService(ITempMsgBoxManager.class, "")).updateIsTop(recentBaseData.getRecentUserUin(), recentBaseData.getRecentUserType(), true);
        } else if (Utils.p(str, getResources().getString(iArr[2]))) {
            ((ITempMsgBoxManager) this.D.getRuntimeService(ITempMsgBoxManager.class, "")).updateIsTop(recentBaseData.getRecentUserUin(), recentBaseData.getRecentUserType(), false);
        }
        Ch();
        Gh();
    }

    @Override // com.tencent.mobileqq.activity.recent.e
    public void U6(View view, RecentBaseData recentBaseData, String str, boolean z16) {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, view, recentBaseData, str, Boolean.valueOf(z16));
            return;
        }
        if (recentBaseData == null) {
            QLog.d("TempMsgBoxFragment", 2, "click tempMsgBox item: ", str, ", recentDataUin: ", "null data");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TempMsgBoxFragment", 2, "click tempMsgBox item: ", str, ", recentDataUin: ", recentBaseData.getRecentUserUin(), ", recentDataType: ", Integer.valueOf(recentBaseData.getRecentUserType()));
        }
        if (recentBaseData.getRecentUserType() == 10012) {
            PublicFragmentActivity.start(getBaseActivity(), new Intent(), FilterMsgBoxFragment.class);
            num = 10000;
        } else {
            if (recentBaseData.getUnreadNum() > 0) {
                this.G = true;
            }
            Integer num2 = ((ITempMsgBoxService) QRoute.api(ITempMsgBoxService.class)).getServiceIdMap().get(Integer.valueOf(recentBaseData.getRecentUserType()));
            xh(recentBaseData, str, z16);
            num = num2;
        }
        if (num != null && num.intValue() >= 0) {
            ReportController.o(this.D, "dc00898", "", "", "0X800B1C0", "0X800B1C0", num.intValue(), 0, "", "", "", "");
        }
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, (Object) motionEvent)).booleanValue();
        }
        GestureDetector gestureDetector = this.F;
        if (gestureDetector != null && gestureDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    @SuppressLint({"ClickableViewAccessibility"})
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, layoutInflater, viewGroup, bundle);
            return;
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        this.F = new GestureDetector(this);
        this.E = ViewConfiguration.get(getBaseActivity()).getScaledDoubleTapSlop() * 2;
        LinearLayout linearLayout = (LinearLayout) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f93875ar);
        if (linearLayout != null) {
            linearLayout.setOnTouchListener(this);
            linearLayout.setLongClickable(true);
        }
        this.N = (TextView) this.titleRoot.findViewById(R.id.dt6);
        zh();
        initTitleBar();
        initData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return R.layout.hru;
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(z16), Integer.valueOf(i3), qUIBadgeDragLayout);
        }
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
        this.C = baseActivity;
        this.D = (QQAppInterface) baseActivity.getAppInterface();
        this.L = new a();
        this.M = new b();
        this.D.registObserver(this.L);
        this.D.registObserver(this.M);
        if (QLog.isColorLevel()) {
            QLog.e("TempMsgBoxFragment", 2, "doOnCreate ", this.C);
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
        RecentAdapter recentAdapter = this.I;
        if (recentAdapter != null) {
            recentAdapter.p();
        }
        XListView xListView = this.H;
        if (xListView != null) {
            xListView.setAdapter((ListAdapter) null);
        }
        DragFrameLayout dragFrameLayout = this.J;
        if (dragFrameLayout != null) {
            dragFrameLayout.removeOnDragModeChangeListener(this);
        }
        this.D.unRegistObserver(this.L);
        this.D.unRegistObserver(this.M);
        this.I = null;
        QQMessageFacade messageFacade = this.D.getMessageFacade();
        if (messageFacade != null) {
            messageFacade.deleteObserver(this);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) motionEvent)).booleanValue();
        }
        Dh(0);
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, this, motionEvent, motionEvent2, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
        }
        if (!Bh() && !Ah() && motionEvent != null && motionEvent2 != null) {
            float x16 = motionEvent.getX() - motionEvent2.getX();
            float abs = Math.abs((motionEvent.getY() - motionEvent2.getY()) / x16);
            if (yh(1)) {
                if (x16 < 0.0f && abs < 0.5f) {
                    Dh(-1);
                    if (this.K) {
                        this.C.finish();
                        return true;
                    }
                    this.K = true;
                    return false;
                }
            } else if (yh(2) && x16 > 0.0f && abs < 0.5f) {
                Dh(-1);
                this.K = false;
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
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        super.onPause();
        ((ITempMsgBoxManager) this.D.getRuntimeService(ITempMsgBoxManager.class, "")).setMsgBoxRead(true);
        this.D.getConversationFacade().s0(AppConstants.TEMP_MSG_BOX_UIN, 10011, 0);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        super.onResume();
        Ch();
        Gh();
        ((ITempMsgBoxManager) this.D.getRuntimeService(ITempMsgBoxManager.class, "")).setMsgBoxRead(true);
        this.D.getConversationFacade().s0(AppConstants.TEMP_MSG_BOX_UIN, 10011, 0);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, this, motionEvent, motionEvent2, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
        }
        if (!Ah() && motionEvent != null && motionEvent2 != null) {
            float x16 = motionEvent.getX() - motionEvent2.getX();
            float abs = Math.abs((motionEvent.getY() - motionEvent2.getY()) / x16);
            if (Bh()) {
                if (Math.abs(x16) > this.E) {
                    if (f16 < 0.0f && abs < 0.5f) {
                        Dh(1);
                        return true;
                    }
                    if (f16 > 0.0f && abs < 0.5f) {
                        Dh(2);
                        return true;
                    }
                }
            } else if (yh(1)) {
                if (f16 > 0.0f || abs >= 0.5f) {
                    Dh(-1);
                }
            } else if (yh(2) && (f16 < 0.0f || abs >= 0.5f)) {
                Dh(-1);
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
        Dh(-1);
        return false;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
        }
        GestureDetector gestureDetector = this.F;
        if (gestureDetector != null && gestureDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) observable, obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TempMsgBoxFragment", 2, "updateMsg called ", obj);
        }
        Ch();
        Gh();
    }

    @Override // com.tencent.mobileqq.activity.recent.e
    public void w4(View view, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view, obj);
        }
    }

    public boolean yh(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this, i3)).booleanValue();
        }
        if (!Ah() && (this.P & i3) == i3) {
            return true;
        }
        return false;
    }
}
