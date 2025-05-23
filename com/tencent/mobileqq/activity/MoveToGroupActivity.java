package com.tencent.mobileqq.activity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialogWtihInput;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.ntrelation.api.IFriendsTABService;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.widget.XListView;
import cooperation.qzone.QZoneClickReport;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* compiled from: P */
/* loaded from: classes9.dex */
public class MoveToGroupActivity extends IphoneTitleBarActivity implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    private QQProgressDialog f176451a0;

    /* renamed from: b0, reason: collision with root package name */
    private XListView f176452b0;

    /* renamed from: c0, reason: collision with root package name */
    private h f176453c0;

    /* renamed from: d0, reason: collision with root package name */
    private String f176454d0;

    /* renamed from: e0, reason: collision with root package name */
    private byte f176455e0;

    /* renamed from: f0, reason: collision with root package name */
    private byte f176456f0;

    /* renamed from: g0, reason: collision with root package name */
    private QQCustomDialogWtihInput f176457g0;

    /* renamed from: h0, reason: collision with root package name */
    private Dialog f176458h0;

    /* renamed from: i0, reason: collision with root package name */
    private View f176459i0;

    /* renamed from: j0, reason: collision with root package name */
    private View f176460j0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f176461k0;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f176462l0;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f176463m0;

    /* renamed from: n0, reason: collision with root package name */
    private int f176464n0;

    /* renamed from: o0, reason: collision with root package name */
    private volatile List<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> f176465o0;

    /* renamed from: p0, reason: collision with root package name */
    private boolean f176466p0;

    /* renamed from: q0, reason: collision with root package name */
    int f176467q0;

    /* renamed from: r0, reason: collision with root package name */
    private hx3.c f176468r0;

    /* renamed from: s0, reason: collision with root package name */
    private hx3.b f176469s0;

    /* renamed from: t0, reason: collision with root package name */
    private hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.a> f176470t0;

    /* renamed from: u0, reason: collision with root package name */
    private DialogInterface.OnClickListener f176471u0;

    /* renamed from: v0, reason: collision with root package name */
    private DialogInterface.OnClickListener f176472v0;

    /* renamed from: w0, reason: collision with root package name */
    @SuppressLint({"HandlerLeak"})
    private Handler f176473w0;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a implements hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.a> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MoveToGroupActivity.this);
            }
        }

        @Override // hx3.c
        public void onUpdateResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.a> eVar) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                return;
            }
            boolean z17 = false;
            if (eVar.a() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (QLog.isColorLevel()) {
                QLog.d("MoveToGroupActivity", 2, "addCategoryCallback isSuccess = " + z16);
            }
            MoveToGroupActivity.this.h3(false);
            MoveToGroupActivity.this.f176461k0 = true;
            if (!z16) {
                return;
            }
            ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.a> b16 = eVar.b();
            if (b16 != null && b16.size() != 0) {
                com.tencent.qqnt.ntrelation.friendsinfo.bean.a aVar = b16.get(b16.size() - 1);
                MoveToGroupActivity.this.f176456f0 = (byte) aVar.b();
                String d16 = aVar.d();
                IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
                String uidFromUin = iFriendsInfoService.getUidFromUin(MoveToGroupActivity.this.f176454d0);
                if (!TextUtils.isEmpty(uidFromUin)) {
                    z17 = iFriendsInfoService.isFriend(uidFromUin, "MoveToGroupActivity");
                }
                if (z17) {
                    ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).moveFriendToNewGroup(uidFromUin, MoveToGroupActivity.this.f176456f0, "MoveToGroupActivity", MoveToGroupActivity.this.f176468r0);
                    return;
                } else {
                    MoveToGroupActivity moveToGroupActivity = MoveToGroupActivity.this;
                    moveToGroupActivity.i3(moveToGroupActivity.f176456f0, d16);
                    return;
                }
            }
            QLog.d("MoveToGroupActivity", 2, "groupIdList == null || groupIdList.size() == 0 ");
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MoveToGroupActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                MoveToGroupActivity.this.l3();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.utils.ar f176484d;

        c(com.tencent.mobileqq.utils.ar arVar) {
            this.f176484d = arVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MoveToGroupActivity.this, (Object) arVar);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int size;
            boolean z16;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                boolean z17 = false;
                if (MoveToGroupActivity.this.f176465o0 == null) {
                    size = 0;
                } else {
                    size = MoveToGroupActivity.this.f176465o0.size();
                }
                int privilegeFlags = VasUtil.getSignedService(MoveToGroupActivity.this.app).getVipStatus().getPrivilegeFlags(null);
                if ((privilegeFlags & 2) != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if ((privilegeFlags & 4) != 0) {
                    z17 = true;
                }
                if (!z16 && !z17) {
                    if (16 == size) {
                        QQToast qQToast = new QQToast(MoveToGroupActivity.this);
                        qQToast.setDuration(2000);
                        qQToast.setToastMsg(R.string.f173214i34);
                        qQToast.show();
                    }
                    MoveToGroupActivity moveToGroupActivity = MoveToGroupActivity.this;
                    moveToGroupActivity.f176457g0 = com.tencent.mobileqq.utils.ak.h(moveToGroupActivity, R.string.bob, R.string.boh, null, this.f176484d, moveToGroupActivity.f176471u0, MoveToGroupActivity.this.f176472v0);
                } else {
                    if (30 == size) {
                        QQToast qQToast2 = new QQToast(MoveToGroupActivity.this);
                        qQToast2.setDuration(2000);
                        qQToast2.setToastMsg(R.string.f173215i35);
                        qQToast2.show();
                    }
                    MoveToGroupActivity moveToGroupActivity2 = MoveToGroupActivity.this;
                    moveToGroupActivity2.f176457g0 = com.tencent.mobileqq.utils.ak.h(moveToGroupActivity2, R.string.bob, R.string.boh, null, this.f176484d, moveToGroupActivity2.f176471u0, MoveToGroupActivity.this.f176472v0);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class d implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MoveToGroupActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            String trim = MoveToGroupActivity.this.f176457g0.getInputValue().trim();
            if (trim.equals("")) {
                trim = HardCodeUtil.qqStr(R.string.f1383309_);
            }
            byte b16 = 1;
            if (MoveToGroupActivity.this.f176465o0.size() > 0) {
                b16 = (byte) (((com.tencent.qqnt.ntrelation.friendsinfo.bean.b) MoveToGroupActivity.this.f176465o0.get(MoveToGroupActivity.this.f176465o0.size() - 1)).h() + 1);
            }
            MoveToGroupActivity moveToGroupActivity = MoveToGroupActivity.this;
            moveToGroupActivity.f176462l0 = moveToGroupActivity.g3(b16, trim);
            if (QLog.isColorLevel()) {
                QLog.d("MoveToGroupActivity", 2, "AddFriendGroup needShowDialog = " + MoveToGroupActivity.this.f176462l0);
            }
            if (MoveToGroupActivity.this.f176462l0) {
                MoveToGroupActivity.this.p3(R.string.boi);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class e implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MoveToGroupActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class f extends Handler {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MoveToGroupActivity.this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("MoveToGroupActivity", 2, "mWaitingDialogControlHandler operationFinished = " + MoveToGroupActivity.this.f176461k0);
            }
            MoveToGroupActivity.this.f176463m0 = true;
            if (MoveToGroupActivity.this.f176461k0) {
                MoveToGroupActivity.this.h3(true);
                return;
            }
            MoveToGroupActivity.this.f176473w0.sendMessageDelayed(MoveToGroupActivity.this.f176473w0.obtainMessage(0), 60000L);
            MoveToGroupActivity.this.f176461k0 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class g implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MoveToGroupActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                MoveToGroupActivity.this.f176458h0 = null;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class h extends BaseAdapter {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        class a extends AccessibilityDelegateCompat {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ byte f176491a;

            a(byte b16) {
                this.f176491a = b16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, h.this, Byte.valueOf(b16));
                }
            }

            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                boolean z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) accessibilityNodeInfoCompat);
                    return;
                }
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                if (this.f176491a == MoveToGroupActivity.this.f176456f0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                accessibilityNodeInfoCompat.setSelected(z16);
            }
        }

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MoveToGroupActivity.this);
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            if (MoveToGroupActivity.this.f176465o0 != null) {
                return MoveToGroupActivity.this.f176465o0.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, i3)).longValue();
            }
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                view2 = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
            } else {
                if (view == null) {
                    view2 = MoveToGroupActivity.this.getLayoutInflater().inflate(R.layout.f168310sk, (ViewGroup) null);
                } else {
                    view2 = view;
                }
                byte d16 = (byte) ((com.tencent.qqnt.ntrelation.friendsinfo.bean.b) MoveToGroupActivity.this.f176465o0.get(i3)).d();
                ImageView imageView = (ImageView) view2.findViewById(R.id.axi);
                if (d16 == MoveToGroupActivity.this.f176456f0) {
                    imageView.setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                }
                ViewCompat.setAccessibilityDelegate(view2, new a(d16));
                TextView textView = (TextView) view2.findViewById(R.id.cyq);
                textView.setText(((com.tencent.qqnt.ntrelation.friendsinfo.bean.b) MoveToGroupActivity.this.f176465o0.get(i3)).f());
                view2.setContentDescription(textView.getText().toString());
                view2.setTag(Integer.valueOf(i3));
                view2.setOnClickListener(MoveToGroupActivity.this);
            }
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view2;
        }
    }

    public MoveToGroupActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f176453c0 = null;
        this.f176465o0 = new ArrayList();
        this.f176466p0 = false;
        this.f176467q0 = ((IFriendsTABService) QRoute.api(IFriendsTABService.class)).getSpecialCareCategoryId();
        this.f176468r0 = new hx3.c<Boolean>() { // from class: com.tencent.mobileqq.activity.MoveToGroupActivity.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MoveToGroupActivity.this);
                }
            }

            @Override // hx3.c
            public void onUpdateResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<Boolean> eVar) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) eVar);
                } else {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable(eVar) { // from class: com.tencent.mobileqq.activity.MoveToGroupActivity.1.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ com.tencent.qqnt.ntrelation.friendsinfo.bean.e f176475d;

                        {
                            this.f176475d = eVar;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) eVar);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            if (!MoveToGroupActivity.this.isFinishing()) {
                                MoveToGroupActivity.this.hideProgressDialog();
                                com.tencent.qqnt.ntrelation.friendsinfo.bean.e eVar2 = this.f176475d;
                                if (eVar2 != null && eVar2.a() != -1) {
                                    MoveToGroupActivity moveToGroupActivity = MoveToGroupActivity.this;
                                    QQToast.makeText(moveToGroupActivity, 2, moveToGroupActivity.getString(R.string.f171117cb0), 0).show(MoveToGroupActivity.this.getTitleBarHeight());
                                } else {
                                    MoveToGroupActivity moveToGroupActivity2 = MoveToGroupActivity.this;
                                    QQToast.makeText(moveToGroupActivity2, moveToGroupActivity2.getString(R.string.cay), 0).show(MoveToGroupActivity.this.getTitleBarHeight());
                                }
                                MoveToGroupActivity.this.l3();
                            }
                        }
                    });
                }
            }
        };
        this.f176469s0 = new hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b>() { // from class: com.tencent.mobileqq.activity.MoveToGroupActivity.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MoveToGroupActivity.this);
                }
            }

            @Override // hx3.b
            public void onQueryResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> eVar) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) eVar);
                    return;
                }
                if (MoveToGroupActivity.this.f176465o0 == null) {
                    MoveToGroupActivity.this.f176465o0 = new ArrayList();
                } else {
                    MoveToGroupActivity.this.f176465o0.clear();
                }
                if (eVar != null && eVar.a() == 0 && eVar.b() != null) {
                    MoveToGroupActivity.this.f176465o0.addAll(eVar.b());
                }
                ListIterator listIterator = MoveToGroupActivity.this.f176465o0.listIterator();
                while (listIterator.hasNext()) {
                    if (((com.tencent.qqnt.ntrelation.friendsinfo.bean.b) listIterator.next()).d() == MoveToGroupActivity.this.f176467q0) {
                        listIterator.remove();
                    }
                }
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.MoveToGroupActivity.2.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                            return;
                        }
                        if (MoveToGroupActivity.this.f176453c0 == null) {
                            MoveToGroupActivity.this.f176453c0 = new h();
                            MoveToGroupActivity.this.f176452b0.setAdapter((ListAdapter) MoveToGroupActivity.this.f176453c0);
                        } else {
                            MoveToGroupActivity.this.f176453c0.notifyDataSetChanged();
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("MoveToGroupActivity", 2, "End Refresh size = " + MoveToGroupActivity.this.f176465o0.size());
                        }
                    }
                });
            }
        };
        this.f176470t0 = new a();
        this.f176471u0 = new d();
        this.f176472v0 = new e();
        this.f176473w0 = new f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideProgressDialog() {
        QQProgressDialog qQProgressDialog = this.f176451a0;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.f176451a0.dismiss();
            this.f176451a0 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i3(int i3, String str) {
        Intent intent = getIntent();
        intent.putExtra("result", (byte) i3);
        intent.putExtra("group_name", str);
        setResult(-1, intent);
        if (QLog.isColorLevel()) {
            QLog.d("MoveToGroupActivity", 2, "AIO_edit_category_move");
        }
        ReportController.o(this.app, "CliOper", "", "", QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO, "AIO_edit_category_move", 0, 0, "", "", "", "");
        finish();
    }

    private void j3(int i3) {
        if (this.f176465o0 == null) {
            QLog.d("MoveToGroupActivity", 2, "finishWithGroupPosition groups == null");
            return;
        }
        if (i3 >= this.f176465o0.size()) {
            QLog.d("MoveToGroupActivity", 2, "position >= groups.size() position:" + i3);
            return;
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar = this.f176465o0.get(i3);
        if (bVar == null) {
            QLog.d("MoveToGroupActivity", 2, "ntCategoryInfo == null");
            return;
        }
        this.f176456f0 = (byte) bVar.d();
        h hVar = this.f176453c0;
        if (hVar != null) {
            hVar.notifyDataSetChanged();
        }
        if (getIntent().getBooleanExtra("PARAM_EXECUTE_IMMEDIATELY", true)) {
            byte b16 = this.f176456f0;
            if (b16 >= 0 && b16 != this.f176455e0) {
                if (NetworkUtil.isNetSupport(this)) {
                    ((FriendListHandler) this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).moveFriendToGroup(this.f176454d0, this.f176456f0, this.f176455e0);
                    ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).moveFriendToNewGroup(((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getUidFromUin(this.f176454d0), this.f176456f0, "MoveToGroupActivity", this.f176468r0);
                    showProgressDialog();
                    return;
                }
                QQToast.makeText(this.app.getApp(), getString(R.string.cjl), 1).show(getTitleBarHeight());
                finish();
                return;
            }
            if (b16 == this.f176455e0) {
                QQToast.makeText(this, getString(R.string.caz), 0).show(getTitleBarHeight());
            }
        }
        i3(this.f176456f0, bVar.f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l3() {
        ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getCategoryInfoWithCategoryId(this.f176456f0, "MoveToGroupActivity", new hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b>() { // from class: com.tencent.mobileqq.activity.MoveToGroupActivity.10
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) MoveToGroupActivity.this);
                }
            }

            @Override // hx3.b
            public void onQueryResult(com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> eVar) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                } else {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable(eVar) { // from class: com.tencent.mobileqq.activity.MoveToGroupActivity.10.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ com.tencent.qqnt.ntrelation.friendsinfo.bean.e f176478d;

                        {
                            this.f176478d = eVar;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass10.this, (Object) eVar);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            com.tencent.qqnt.ntrelation.friendsinfo.bean.e eVar2 = this.f176478d;
                            if (eVar2 != null && eVar2.a() == 0 && this.f176478d.b() != null && !this.f176478d.b().isEmpty()) {
                                com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar = (com.tencent.qqnt.ntrelation.friendsinfo.bean.b) this.f176478d.b().get(0);
                                MoveToGroupActivity moveToGroupActivity = MoveToGroupActivity.this;
                                moveToGroupActivity.i3(moveToGroupActivity.f176456f0, bVar.f());
                            } else {
                                MoveToGroupActivity moveToGroupActivity2 = MoveToGroupActivity.this;
                                moveToGroupActivity2.i3(moveToGroupActivity2.f176456f0, "");
                            }
                        }
                    });
                }
            }
        });
    }

    private void n3() {
        this.f176460j0.setOnClickListener(new c(new com.tencent.mobileqq.utils.ar()));
    }

    private void showProgressDialog() {
        QQProgressDialog qQProgressDialog = new QQProgressDialog(this);
        this.f176451a0 = qQProgressDialog;
        qQProgressDialog.setOffsetY(getTitleBarHeight());
        qQProgressDialog.show();
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        String uidFromUin;
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        super.setContentView(R.layout.f168309sj);
        setTitle(getString(R.string.f171118cb1));
        TextView textView = (TextView) findViewById(R.id.ivTitleBtnLeft);
        textView.setContentDescription(HardCodeUtil.qqStr(R.string.o_1));
        this.f176454d0 = getIntent().getExtras().getString("friendUin");
        byte byteValue = getIntent().getExtras().getByte("mgid", (byte) 0).byteValue();
        this.f176455e0 = byteValue;
        if (byteValue == 0 && (friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid((uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.f176454d0)), "MoveToGroupActivity")) != null && ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, "MoveToGroupActivity")) {
            this.f176455e0 = (byte) friendsSimpleInfoWithUid.f();
        }
        this.f176456f0 = this.f176455e0;
        ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).friendsCategoryInfo(true, "MoveToGroupActivity", true, this.f176469s0);
        this.f176452b0 = (XListView) findViewById(R.id.f0w);
        this.f176464n0 = getResources().getDimensionPixelSize(R.dimen.title_bar_height);
        this.f176452b0.setVerticalScrollBarEnabled(false);
        View inflate = getLayoutInflater().inflate(R.layout.f168013oz, (ViewGroup) null);
        this.f176459i0 = inflate;
        this.f176452b0.addHeaderView(inflate);
        this.f176460j0 = this.f176459i0.findViewById(R.id.f165402cy2);
        n3();
        h hVar = new h();
        this.f176453c0 = hVar;
        this.f176452b0.setAdapter((ListAdapter) hVar);
        textView.setOnClickListener(new b());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.doOnDestroy();
        this.f176473w0.removeMessages(0);
        ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).unregisterFriendCategoryInfoCallback("MoveToGroupActivity", this.f176469s0);
        hideProgressDialog();
    }

    public boolean g3(byte b16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, Byte.valueOf(b16), str)).booleanValue();
        }
        if (!NetworkUtil.isNetSupport(getApplication())) {
            QQToast.makeText(BaseApplicationImpl.sApplication, R.string.f171137ci2, 0).show();
            return false;
        }
        ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).addCategory(str, "MoveToGroupActivity", this.f176470t0);
        return true;
    }

    void h3(boolean z16) {
        Dialog dialog;
        if (QLog.isColorLevel()) {
            QLog.d("MoveToGroupActivity", 2, "dismissWaitingDialog delayPassed = " + this.f176463m0);
        }
        if (this.f176463m0 && (dialog = this.f176458h0) != null) {
            if (dialog.isShowing()) {
                this.f176458h0.dismiss();
            }
            this.f176458h0 = null;
            if (z16) {
                refresh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        l3();
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
        } else {
            j3(((Integer) view.getTag()).intValue());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    void p3(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("MoveToGroupActivity", 2, "showWaitingDialog");
        }
        h3(false);
        Dialog dialog = this.f176458h0;
        if (dialog != null && dialog.isShowing()) {
            if (QLog.isColorLevel()) {
                QLog.d("MoveToGroupActivity", 2, "WatingDialog is showing already!");
                return;
            }
            return;
        }
        QQProgressDialog qQProgressDialog = new QQProgressDialog(this, this.f176464n0);
        qQProgressDialog.setMessage(i3);
        this.f176458h0 = qQProgressDialog;
        qQProgressDialog.setOnDismissListener(new g());
        this.f176458h0.show();
        this.f176461k0 = false;
        this.f176463m0 = false;
        this.f176473w0.sendMessageDelayed(this.f176473w0.obtainMessage(0), 500L);
    }

    void refresh() {
        if (QLog.isColorLevel()) {
            QLog.d("MoveToGroupActivity", 2, "Start Refresh:");
        }
        ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).friendsCategoryInfo(false, "MoveToGroupActivity", false, this.f176469s0);
    }
}
