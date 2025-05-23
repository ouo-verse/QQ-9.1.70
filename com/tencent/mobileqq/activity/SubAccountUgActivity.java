package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.proavatar.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountControlService;
import com.tencent.mobileqq.subaccount.api.ISubAccountProtocService;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.subaccount.api.impl.SubAccountControlServiceImpl;
import com.tencent.mobileqq.subaccount.api.impl.SubAccountProtocServiceImpl;
import com.tencent.mobileqq.subaccount.api.impl.SubAccountServiceImpl;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.api.IContactUtils;
import com.tencent.mobileqq.vas.pendant.api.ISpecialShapeAvatarMaskLayer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.ThemeImageWrapper;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

/* compiled from: P */
@RoutePage(desc = "\u5c0f\u53f7\u52a9\u624b\u7ed1\u5b9aActivity", path = RouterConstants.UI_ROUTER_SUBACCOUNT_UG)
/* loaded from: classes9.dex */
public class SubAccountUgActivity extends SubAccountBaseActivity implements View.OnClickListener, Observer {
    static IPatchRedirector $redirector_ = null;
    public static final int SUBACCOUNTUGACTIVITY_FINISH = 1980;
    boolean mBindClick;
    com.tencent.mobileqq.app.dc mBindObserver;
    MqqHandler mHandler;
    boolean mHasBindAccount;
    boolean mIsFromAssociatedActivity;
    BusinessObserver mMsgObserver;
    String subUin;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a extends com.tencent.mobileqq.app.dc {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.activity.SubAccountUgActivity$a$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        class DialogInterfaceOnClickListenerC7114a implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ SubAccountControlServiceImpl f177167d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Pair f177168e;

            DialogInterfaceOnClickListenerC7114a(SubAccountControlServiceImpl subAccountControlServiceImpl, Pair pair) {
                this.f177167d = subAccountControlServiceImpl;
                this.f177168e = pair;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, a.this, subAccountControlServiceImpl, pair);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                    return;
                }
                SubAccountControlServiceImpl subAccountControlServiceImpl = this.f177167d;
                Pair pair = this.f177168e;
                subAccountControlServiceImpl.cancelHintDialog((String) pair.first, ((Integer) pair.second).intValue(), true);
                AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
                if (!com.tencent.mobileqq.subaccount.h.A(appInterface)) {
                    SubAccountUgActivity.this.setTitle("");
                    com.tencent.mobileqq.subaccount.f.i(appInterface, SubAccountUgActivity.this, null);
                }
                SubAccountUgActivity.this.finish();
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SubAccountUgActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.dc
        protected void b(boolean z16, com.tencent.mobileqq.subaccount.logic.a aVar) {
            String str;
            ArrayList<String> f16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), aVar);
                return;
            }
            if (!z16 || aVar == null || (str = SubAccountUgActivity.this.subUin) == null || str.length() < 5 || (f16 = aVar.f()) == null || f16.contains(SubAccountUgActivity.this.subUin)) {
                return;
            }
            SubAccountControlServiceImpl subAccountControlServiceImpl = (SubAccountControlServiceImpl) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(SubAccountControlServiceImpl.class, null);
            SubAccountUgActivity subAccountUgActivity = SubAccountUgActivity.this;
            subAccountUgActivity.showUnbindDialog(subAccountControlServiceImpl, subAccountUgActivity.subUin);
        }

        @Override // com.tencent.mobileqq.app.dc
        protected void c(boolean z16, com.tencent.mobileqq.subaccount.logic.a aVar) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), aVar);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SUB_ACCOUNT", 2, "SubAccountUgActivity.onUnBindSubAccount() isSucc=" + z16 + " currentActivity subUin=" + SubAccountUgActivity.this.subUin);
                if (aVar != null) {
                    QLog.d("SUB_ACCOUNT", 2, "SubAccountUgActivity.onUnBindSubAccount() mainAccount=" + aVar.f291123c + " subAccount=" + aVar.f291124d + " errType=" + aVar.f291121a + " errMsg=" + aVar.f291122b);
                }
            }
            if (aVar != null && (str = SubAccountUgActivity.this.subUin) != null) {
                if (str == null || str.equals(aVar.f291124d)) {
                    SubAccountUgActivity.this.hideJuhua();
                    SubAccountUgActivity subAccountUgActivity = SubAccountUgActivity.this;
                    if (subAccountUgActivity.mBindClick) {
                        subAccountUgActivity.mBindClick = false;
                        if (z16) {
                            subAccountUgActivity.bindSwitchUnbind();
                            SubAccountUgActivity subAccountUgActivity2 = SubAccountUgActivity.this;
                            subAccountUgActivity2.showQQToastSuccess(subAccountUgActivity2.getString(R.string.hts));
                            return;
                        }
                        subAccountUgActivity.showQQToast(subAccountUgActivity.getString(R.string.hto));
                        return;
                    }
                    if (z16) {
                        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                        SubAccountControlServiceImpl subAccountControlServiceImpl = (SubAccountControlServiceImpl) peekAppRuntime.getRuntimeService(SubAccountControlServiceImpl.class, null);
                        Pair<String, Integer> addHintPair = subAccountControlServiceImpl.addHintPair(SubAccountUgActivity.this.subUin, 1);
                        subAccountControlServiceImpl.showHintDialog((AppInterface) peekAppRuntime, SubAccountUgActivity.this, addHintPair, new DialogInterfaceOnClickListenerC7114a(subAccountControlServiceImpl, addHintPair));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ISubAccountControlService f177170d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Pair f177171e;

        b(ISubAccountControlService iSubAccountControlService, Pair pair) {
            this.f177170d = iSubAccountControlService;
            this.f177171e = pair;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, SubAccountUgActivity.this, iSubAccountControlService, pair);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            ISubAccountControlService iSubAccountControlService = this.f177170d;
            Pair pair = this.f177171e;
            iSubAccountControlService.cancelHintDialog((String) pair.first, ((Integer) pair.second).intValue(), true);
            AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
            if (!com.tencent.mobileqq.subaccount.h.A(appInterface)) {
                SubAccountUgActivity.this.setTitle("");
                com.tencent.mobileqq.subaccount.f.i(appInterface, SubAccountUgActivity.this, null);
            }
            SubAccountUgActivity.this.finish();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class c extends MqqHandler {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SubAccountUgActivity.this);
            }
        }

        @Override // mqq.os.MqqHandler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
            } else if (message.what == 1980) {
                SubAccountUgActivity.this.finish();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class d implements ISubAccountApi.c {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SubAccountUgActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.subaccount.api.ISubAccountApi.c
        public void a(boolean z16, String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, str2);
            }
        }

        @Override // com.tencent.mobileqq.subaccount.api.ISubAccountApi.c
        public void b(boolean z16, String str, com.tencent.mobileqq.subaccount.logic.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), str, aVar);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("IphoneTitleBarActivity", 2, "onPushSubAccountMsg() isSuccess=" + z16 + "  subAccount=" + str);
                if (aVar != null) {
                    QLog.i("IphoneTitleBarActivity", 2, "onPushSubAccountMsg() data.errorType=" + aVar.f291121a + "  errorMsg=" + aVar.f291122b + " mainAccount=" + aVar.f291123c + "  subAccount=" + aVar.f291124d + " isNeedStartGetMsg=" + aVar.f291131k);
                }
            }
            if (aVar == null || str == null || str.length() < 5 || SubAccountUgActivity.this.isFinishing()) {
                return;
            }
            SubAccountControlServiceImpl subAccountControlServiceImpl = (SubAccountControlServiceImpl) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(SubAccountControlServiceImpl.class, null);
            if (aVar.f291121a == 1) {
                String str2 = SubAccountUgActivity.this.subUin;
                if (str2 != null && str2.equals(str)) {
                    SubAccountUgActivity.this.showUnbindDialog(subAccountControlServiceImpl, str);
                    return;
                }
                return;
            }
            String str3 = SubAccountUgActivity.this.subUin;
            if (str3 != null && str3.equals(str)) {
                subAccountControlServiceImpl.cancelHintDialog(SubAccountUgActivity.this.subUin, 1, true);
            }
        }

        @Override // com.tencent.mobileqq.subaccount.api.ISubAccountApi.c
        public void c(boolean z16, String str, com.tencent.mobileqq.subaccount.logic.b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), str, bVar);
            }
        }

        @Override // com.tencent.mobileqq.subaccount.api.ISubAccountApi.c
        public void d(boolean z16, String str, com.tencent.mobileqq.subaccount.logic.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, aVar);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class e implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f177175d;

        e(ActionSheet actionSheet) {
            this.f177175d = actionSheet;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SubAccountUgActivity.this, (Object) actionSheet);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            if (i3 == 0) {
                if (!SubAccountUgActivity.this.isNetConnToast()) {
                    return;
                }
                SubAccountUgActivity.this.showJuhua(R.string.htt);
                SubAccountUgActivity.this.mBindClick = true;
                SubAccountProtocServiceImpl subAccountProtocServiceImpl = (SubAccountProtocServiceImpl) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ISubAccountProtocService.class, "");
                if (subAccountProtocServiceImpl != null) {
                    subAccountProtocServiceImpl.unBindAccount(SubAccountUgActivity.this.subUin);
                }
            }
            this.f177175d.cancel();
        }
    }

    public SubAccountUgActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.subUin = "";
        this.mIsFromAssociatedActivity = false;
        this.mBindObserver = new a();
        this.mHandler = new c();
        this.mMsgObserver = ((ISubAccountApi) QRoute.api(ISubAccountApi.class)).getMessageObserver(new d());
    }

    private void loadAvatar(QQProAvatarView qQProAvatarView, String str) {
        qQProAvatarView.x(1, str, new e.a().e(!((ISpecialShapeAvatarMaskLayer) QRoute.api(ISpecialShapeAvatarMaskLayer.class)).isSpecialShapeAvatar(str)).g(200).a());
    }

    private void updateLayoutForMultiWindow(boolean z16) {
        View findViewById = findViewById(R.id.j6f);
        if (findViewById != null) {
            if (z16) {
                findViewById.setPadding(findViewById.getPaddingLeft(), ViewUtils.dip2px(260.0f), findViewById.getPaddingRight(), findViewById.getPaddingBottom());
            } else {
                findViewById.setPadding(findViewById.getPaddingLeft(), 0, findViewById.getPaddingRight(), findViewById.getPaddingBottom());
            }
        }
    }

    public void bindSwitchUnbind() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.mHasBindAccount = false;
        View findViewById = findViewById(R.id.j6f);
        TextView textView = (TextView) findViewById(R.id.j6j);
        TextView textView2 = (TextView) findViewById(R.id.j6k);
        QQProAvatarView qQProAvatarView = (QQProAvatarView) findViewById(R.id.j6i);
        ((Button) findViewById(R.id.j6g)).setText(R.string.hta);
        findViewById.setVisibility(8);
        textView.setText(R.string.htm);
        textView2.setVisibility(8);
        qQProAvatarView.setImageResource(R.drawable.f162498h35);
    }

    @Override // com.tencent.mobileqq.activity.SubAccountBaseActivity, com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0127, code lost:
    
        if (r1 != 1233) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0171  */
    @Override // com.tencent.mobileqq.activity.SubAccountBaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean doOnCreate(Bundle bundle) {
        boolean z16;
        boolean z17;
        int i3;
        String buddyNickName;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        if (AppSetting.o(this)) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
        this.subUin = getIntent().getStringExtra("subAccount");
        this.mIsFromAssociatedActivity = getIntent().getBooleanExtra("from_associated_activity", false);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        SubAccountServiceImpl subAccountServiceImpl = (SubAccountServiceImpl) peekAppRuntime.getRuntimeService(ISubAccountService.class, null);
        this.mHasBindAccount = subAccountServiceImpl.isSubAccountUin(this.subUin);
        AppInterface appInterface = (AppInterface) peekAppRuntime;
        Pair<Boolean, Boolean> d16 = com.tencent.mobileqq.subaccount.h.d(appInterface, this.subUin);
        if (d16 != null) {
            z17 = d16.first.booleanValue();
            z16 = d16.second.booleanValue();
        } else {
            z16 = false;
            z17 = false;
        }
        if (z16) {
            com.tencent.mobileqq.subaccount.f.i(appInterface, this, this.subUin);
            finish();
            return false;
        }
        super.setContentView(R.layout.f169101c02);
        setTitle(R.string.hrx);
        findViewById(R.id.root).setOnClickListener(this);
        QQProAvatarView qQProAvatarView = (QQProAvatarView) findViewById(R.id.j6h);
        QQProAvatarView qQProAvatarView2 = (QQProAvatarView) findViewById(R.id.j6i);
        ((ThemeImageView) findViewById(R.id.j6e)).setMaskShape(ThemeImageWrapper.MODE_OTHER);
        TextView textView = (TextView) findViewById(R.id.j6j);
        TextView textView2 = (TextView) findViewById(R.id.j6k);
        Button button = (Button) findViewById(R.id.j6g);
        View findViewById = findViewById(R.id.j6f);
        loadAvatar(qQProAvatarView, peekAppRuntime.getAccount());
        textView.setTextColor(getResources().getColor(R.color.skin_black));
        textView2.setVisibility(8);
        if (this.mHasBindAccount) {
            if (z17) {
                Pair<Integer, String> serverError = subAccountServiceImpl.getServerError(this.subUin);
                if (serverError != null) {
                    i16 = serverError.first.intValue();
                } else {
                    i16 = 0;
                }
                if (i16 != 0) {
                    i3 = R.string.htf;
                    if (i16 != 1200) {
                        if (i16 != 1214) {
                            if (i16 != 1215) {
                                if (i16 != 1232) {
                                }
                            } else {
                                i3 = R.string.htd;
                            }
                        } else {
                            i3 = R.string.htg;
                        }
                    }
                } else {
                    i3 = R.string.htk;
                }
                if (i3 == 0) {
                    i3 = R.string.htk;
                }
                textView.setTextColor(getResources().getColor(R.color.skin_black));
                loadAvatar(qQProAvatarView2, this.subUin);
                buddyNickName = ((IContactUtils) QRoute.api(IContactUtils.class)).getBuddyNickName(peekAppRuntime, this.subUin, true);
                if (buddyNickName != null || buddyNickName.length() == 0) {
                    buddyNickName = this.subUin;
                }
                textView.setText(getString(i3, buddyNickName));
                if (i3 != R.string.htk) {
                    textView2.setVisibility(0);
                } else {
                    textView2.setVisibility(8);
                }
                button.setText(R.string.ht_);
                findViewById.setVisibility(0);
                ((Button) findViewById.findViewById(R.id.j6_)).setOnClickListener(this);
                ((Button) findViewById.findViewById(R.id.j69)).setOnClickListener(this);
            }
            i3 = 0;
            if (i3 == 0) {
            }
            textView.setTextColor(getResources().getColor(R.color.skin_black));
            loadAvatar(qQProAvatarView2, this.subUin);
            buddyNickName = ((IContactUtils) QRoute.api(IContactUtils.class)).getBuddyNickName(peekAppRuntime, this.subUin, true);
            if (buddyNickName != null) {
            }
            buddyNickName = this.subUin;
            textView.setText(getString(i3, buddyNickName));
            if (i3 != R.string.htk) {
            }
            button.setText(R.string.ht_);
            findViewById.setVisibility(0);
            ((Button) findViewById.findViewById(R.id.j6_)).setOnClickListener(this);
            ((Button) findViewById.findViewById(R.id.j69)).setOnClickListener(this);
        } else {
            qQProAvatarView2.setImageResource(R.drawable.f162498h35);
        }
        button.setOnClickListener(this);
        addObserver(this.mBindObserver);
        addObserver(this.mMsgObserver);
        updateUnreadNumOnTitleBar();
        ((IMessageFacade) peekAppRuntime.getRuntimeService(IMessageFacade.class, "")).addObserver(this);
        appInterface.setHandler(getClass(), this.mHandler);
        if (isInMultiWindow()) {
            updateLayoutForMultiWindow(true);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.SubAccountBaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.doOnDestroy();
        removeObserver(this.mBindObserver);
        removeObserver(this.mMsgObserver);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        ((AppInterface) peekAppRuntime).removeHandler(getClass());
        ((IMessageFacade) peekAppRuntime.getRuntimeService(IMessageFacade.class, "")).deleteObserver(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.doOnPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.doOnResume();
        }
    }

    public String getSubUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.subUin;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.j6g) {
                Intent intent = new Intent();
                if (this.mHasBindAccount) {
                    intent.putExtra("is_sub_account_login", true);
                    intent.putExtra("loginFragmentType", 5);
                    intent.putExtra("key_login_page_entrance", 2);
                    intent.putExtra("key_login_page_title", getString(R.string.hsr));
                    intent.putExtra("uin", this.subUin);
                    intent.putExtra("sub_login_bind", false);
                    intent.putExtra("sub_login_from_where", this.fromWhere);
                    RouteUtils.startActivity(this, intent, RouterConstants.UI_ROUTER_LOGIN);
                } else {
                    intent.setClass(view.getContext(), SubAccountBindActivity.class);
                    intent.putExtra("fromWhere", this.fromWhere);
                    intent.putExtra("fromWhereExactly", 3);
                    startActivity(intent);
                }
            } else if (id5 == R.id.j6_) {
                ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(getActivity(), null);
                actionSheet.setMainTitle(R.string.htb);
                actionSheet.addButton(getResources().getString(R.string.i_o), 3);
                actionSheet.addCancelButton(R.string.cancel);
                actionSheet.setOnButtonClickListener(new e(actionSheet));
                actionSheet.show();
            } else if (id5 == R.id.j69) {
                String str = this.subUin;
                boolean isEmpty = TextUtils.isEmpty(str);
                String str2 = AppConstants.FORGET_PWD_URL;
                if (!isEmpty) {
                    str2 = String.format(Locale.getDefault(), "%s&account=%s", AppConstants.FORGET_PWD_URL, str);
                }
                Intent intent2 = new Intent();
                intent2.putExtra("uin", this.subUin);
                intent2.putExtra("reqType", 3);
                intent2.putExtra("url", str2);
                RouteUtils.startActivity(this, intent2, RouterConstants.UI_ROUTE_BROWSER);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.activity.SubAccountBaseActivity, com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onMultiWindowModeChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else {
            super.onMultiWindowModeChanged(z16);
            updateLayoutForMultiWindow(z16);
        }
    }

    public void showUnbindDialog(ISubAccountControlService iSubAccountControlService, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iSubAccountControlService, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "showUnbindDialog() subUin=" + str);
        }
        if (iSubAccountControlService != null && str != null && str.length() > 4) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (isResume()) {
                AppInterface appInterface = (AppInterface) peekAppRuntime;
                if (com.tencent.mobileqq.subaccount.h.H(appInterface, str)) {
                    hideJuhua();
                    ArrayList<Pair<String, Integer>> popWaittingHintPair = iSubAccountControlService.popWaittingHintPair(str);
                    int size = popWaittingHintPair.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        Pair<String, Integer> pair = popWaittingHintPair.get(i3);
                        iSubAccountControlService.showHintDialog(appInterface, this, pair, new b(iSubAccountControlService, pair));
                    }
                }
            }
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) observable, obj);
        } else if ((obj instanceof MessageRecord) && !((MessageRecord) obj).isSendFromLocal()) {
            runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.SubAccountUgActivity.6
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SubAccountUgActivity.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        SubAccountUgActivity.this.updateUnreadNumOnTitleBar();
                    }
                }
            });
        }
    }

    void updateUnreadNumOnTitleBar() {
        if (this.leftView != null && !this.mIsFromAssociatedActivity) {
            IMessageFacade iMessageFacade = (IMessageFacade) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IMessageFacade.class, "");
            StringBuilder sb5 = new StringBuilder(HardCodeUtil.qqStr(R.string.f171898lr0));
            sb5.append(getString(R.string.hvn));
            if (iMessageFacade != null) {
                int unreadMsgsNum = iMessageFacade.getUnreadMsgsNum();
                if (unreadMsgsNum > 0) {
                    String num = Integer.toString(unreadMsgsNum);
                    if (unreadMsgsNum > 99) {
                        num = "99+";
                    }
                    this.leftView.setText("");
                    this.mLeftBackIcon.setVisibility(4);
                    this.mLeftBackText.setVisibility(0);
                    this.mLeftBackText.setText(num);
                    this.leftView.setContentDescription("");
                    this.leftView.bringToFront();
                    sb5.append(unreadMsgsNum);
                    sb5.append("\u6761\u672a\u8bfb");
                } else {
                    this.leftView.setText("");
                    this.mLeftBackText.setVisibility(8);
                }
            } else {
                this.leftView.setText("");
                this.mLeftBackText.setVisibility(8);
            }
            this.leftView.setContentDescription(sb5.toString());
        }
    }
}
