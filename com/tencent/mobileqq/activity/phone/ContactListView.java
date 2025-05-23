package com.tencent.mobileqq.activity.phone;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardShareCardOption;
import com.tencent.mobileqq.forward.k;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileContactInfo;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.activity.ContactSearchComponentActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ListView;
import com.tencent.widget.XListView;
import common.config.service.QzoneConfig;
import cooperation.qqpim.QQPimGetTipsInfoIPC;
import cooperation.qqpim.QQPimTipsInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.TicketManagerImpl;
import mqq.os.MqqHandler;

/* compiled from: P */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes10.dex */
public class ContactListView extends BaseActivityView implements View.OnClickListener, DecodeTaskCompletionListener, IndexView.b, AbsListView.OnScrollListener, Handler.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: s0, reason: collision with root package name */
    private static final String f183793s0;

    /* renamed from: t0, reason: collision with root package name */
    private static final String[] f183794t0;
    private f N;
    List<List<PhoneContact>> P;
    ArrayList<PhoneContact> Q;
    int R;
    e S;
    private List<String> T;
    List<PhoneContact> U;
    com.tencent.mobileqq.adapter.h V;
    h W;

    /* renamed from: a0, reason: collision with root package name */
    private Handler f183795a0;

    /* renamed from: b0, reason: collision with root package name */
    private XListView f183796b0;

    /* renamed from: c0, reason: collision with root package name */
    private View f183797c0;

    /* renamed from: d0, reason: collision with root package name */
    private View f183798d0;

    /* renamed from: e0, reason: collision with root package name */
    private View f183799e0;

    /* renamed from: f0, reason: collision with root package name */
    private EditText f183800f0;

    /* renamed from: g0, reason: collision with root package name */
    ActionSheet f183801g0;

    /* renamed from: h0, reason: collision with root package name */
    private IFaceDecoder f183802h0;

    /* renamed from: i0, reason: collision with root package name */
    private Bitmap f183803i0;

    /* renamed from: j0, reason: collision with root package name */
    private HashMap<String, Integer> f183804j0;

    /* renamed from: k0, reason: collision with root package name */
    private IndexView f183805k0;

    /* renamed from: l0, reason: collision with root package name */
    private TextView f183806l0;

    /* renamed from: m0, reason: collision with root package name */
    private ImageView f183807m0;

    /* renamed from: n0, reason: collision with root package name */
    public ForwardBaseOption f183808n0;

    /* renamed from: o0, reason: collision with root package name */
    private int f183809o0;

    /* renamed from: p0, reason: collision with root package name */
    private boolean f183810p0;

    /* renamed from: q0, reason: collision with root package name */
    private com.tencent.mobileqq.friend.observer.a f183811q0;

    /* renamed from: r0, reason: collision with root package name */
    private QQPimGetTipsInfoIPC.c f183812r0;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a extends com.tencent.mobileqq.friend.observer.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ContactListView.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.friend.observer.a
        public void onUpdateAddFriend(boolean z16, boolean z17, boolean z18, String str, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), str, bundle);
            } else if (z16 && z17 && !z18) {
                ContactListView.this.M();
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
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ContactListView.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ContactListView.this.f183796b0.removeHeaderView(ContactListView.this.f183799e0);
                ContactListView.this.f183799e0 = null;
                cooperation.qqpim.e.a(ContactListView.this.getContext(), QQPimGetTipsInfoIPC.l().f390778e);
                QQPimGetTipsInfoIPC.l().n();
            }
            EventCollector.getInstance().onViewClicked(view);
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
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ContactListView.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ReportController.o(ContactListView.this.f183714d, "CliOper", "", "", "0X8006710", "0X8006710", 0, 0, "", "", "", "");
                ContactListView.this.f183796b0.removeHeaderView(ContactListView.this.f183799e0);
                ContactListView.this.f183799e0 = null;
                cooperation.qqpim.e.a(ContactListView.this.getContext(), QQPimGetTipsInfoIPC.l().f390778e);
                QQPimGetTipsInfoIPC.l().n();
                String account = ContactListView.this.J().getAccount();
                Bundle bundle = new Bundle();
                bundle.putString(cooperation.qqpim.a.f390811o, cooperation.qqpim.a.f390806j);
                bundle.putInt(cooperation.qqpim.a.f390812p, QQPimGetTipsInfoIPC.l().f390778e.f390796h);
                bundle.putString(cooperation.qqpim.a.f390808l, account);
                new cooperation.qqpim.b().d(ContactListView.this.J(), ContactListView.this.f183718i, bundle);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class d implements QQPimGetTipsInfoIPC.c {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ContactListView.this);
            }
        }

        @Override // cooperation.qqpim.QQPimGetTipsInfoIPC.c
        public void a(QQPimTipsInfo qQPimTipsInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQPimTipsInfo);
                return;
            }
            if (qQPimTipsInfo == null) {
                return;
            }
            QLog.i("ContactListView", 2, "getQQPimTips() callback ");
            cooperation.qqpim.e.b(ContactListView.this.getContext(), qQPimTipsInfo);
            Message message = new Message();
            message.what = 6;
            message.obj = qQPimTipsInfo;
            ContactListView.this.W.sendMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class e extends PinnedDividerListView.a {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ContactListView.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
        public void configDividerView(View view, int i3) {
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, (Object) view, i3);
                return;
            }
            ArrayList<PhoneContact> arrayList = ContactListView.this.Q;
            if (arrayList != null && !arrayList.isEmpty() && i3 >= 0 && i3 < ContactListView.this.Q.size()) {
                PhoneContact phoneContact = ContactListView.this.Q.get(i3);
                if (phoneContact == null && (i16 = i3 + 1) < ContactListView.this.Q.size()) {
                    phoneContact = ContactListView.this.Q.get(i16);
                }
                if (phoneContact == null) {
                    return;
                }
                ((TextView) view).setText(phoneContact.pinyinFirst);
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            ArrayList<PhoneContact> arrayList = ContactListView.this.Q;
            if (arrayList != null) {
                return arrayList.size();
            }
            return 0;
        }

        @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
        public int getDividerLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            return R.layout.f168366u3;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return iPatchRedirector.redirect((short) 5, (Object) this, i3);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Long) iPatchRedirector.redirect((short) 6, (Object) this, i3)).longValue();
            }
            return 0L;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, i3)).intValue();
            }
            ArrayList<PhoneContact> arrayList = ContactListView.this.Q;
            if (arrayList == null || arrayList.isEmpty() || ContactListView.this.Q.get(i3) == null) {
                return 1;
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                view2 = view;
                view = (View) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), view, viewGroup);
            } else {
                if (getItemViewType(i3) == 1) {
                    if (view == null) {
                        view = LayoutInflater.from(ContactListView.this.getContext()).inflate(getDividerLayout(), viewGroup, false);
                    }
                    configDividerView(view, i3);
                } else {
                    if (view == null) {
                        view = ContactListView.this.N();
                        view.setOnClickListener(ContactListView.this);
                    }
                    ContactListView.this.G(view, ContactListView.this.Q.get(i3), false);
                }
                view2 = view;
            }
            EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
            return view;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return 2;
        }

        @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
        public boolean isDividerView(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, i3)).booleanValue();
            }
            if (getItemViewType(i3) == 1) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    private class f extends com.tencent.mobileqq.phonecontact.observer.b {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ContactListView.this);
            }
        }

        @Override // com.tencent.mobileqq.phonecontact.observer.b
        protected void onHideContact(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, z16);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ContactListView", 2, "onHideContact isSuccess=" + z16);
            }
            if (z16) {
                ContactListView contactListView = ContactListView.this;
                if (contactListView.f183719m == 5) {
                    contactListView.M();
                }
            }
        }

        @Override // com.tencent.mobileqq.phonecontact.observer.b
        protected void onQueryBindState(boolean z16, boolean z17, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Long.valueOf(j3));
                return;
            }
            int selfBindState = ContactListView.this.E.getSelfBindState();
            if (!z16) {
                ContactListView.this.w();
                ContactListView.this.a();
                if (selfBindState == 0 || selfBindState == 7) {
                    ContactListView contactListView = ContactListView.this;
                    if ((contactListView.f183719m != 2 || !(contactListView.f183808n0 instanceof ForwardShareCardOption)) && contactListView.R == 0) {
                        contactListView.p(R.string.h1y, 3000L);
                        return;
                    }
                    return;
                }
                return;
            }
            ContactListView.this.H.setEnabled(true);
            if (ContactListView.this.E.isAutoUploadContacts()) {
                ContactListView.this.q(R.string.hex, 0L, false);
            }
        }

        @Override // com.tencent.mobileqq.phonecontact.observer.b
        protected void onQueryContactList(boolean z16, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Integer.valueOf(i3));
                return;
            }
            if (z16) {
                ContactListView.this.w();
                ContactListView.this.f183810p0 = true;
                if ((i3 & 1) == 0) {
                    ContactListView.this.a();
                }
            } else {
                ContactListView.this.a();
            }
            ContactListView contactListView = ContactListView.this;
            if (contactListView.f183719m == 6) {
                contactListView.d();
            }
        }

        @Override // com.tencent.mobileqq.phonecontact.observer.b
        protected void onUploadContact(boolean z16, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            } else if (!z16 || !NetworkUtil.isNetSupport(ContactListView.this.getContext())) {
                ContactListView.this.w();
                ContactListView.this.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class g {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f183819a;

        /* renamed from: b, reason: collision with root package name */
        public ImageView f183820b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f183821c;

        /* renamed from: d, reason: collision with root package name */
        public TextView f183822d;

        /* renamed from: e, reason: collision with root package name */
        public ImageView f183823e;

        /* renamed from: f, reason: collision with root package name */
        public Button f183824f;

        /* renamed from: g, reason: collision with root package name */
        public Button f183825g;

        /* renamed from: h, reason: collision with root package name */
        public int f183826h;

        /* renamed from: i, reason: collision with root package name */
        public PhoneContact f183827i;

        /* renamed from: j, reason: collision with root package name */
        public Button f183828j;

        /* renamed from: k, reason: collision with root package name */
        public TextView f183829k;

        /* renamed from: l, reason: collision with root package name */
        public View f183830l;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class h extends MqqHandler {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<ContactListView> f183831d;

        public h(ContactListView contactListView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) contactListView);
            } else {
                this.f183831d = new WeakReference<>(contactListView);
            }
        }

        @Override // mqq.os.MqqHandler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            ContactListView contactListView = this.f183831d.get();
            if (contactListView == null) {
                if (QLog.isColorLevel()) {
                    QLog.i("ContactListView", 2, "UiHandler() handleMessage a == null");
                    return;
                }
                return;
            }
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            if (i3 == 6) {
                                contactListView.R((QQPimTipsInfo) message.obj);
                                return;
                            }
                            if (i3 == 8) {
                                contactListView.w();
                                contactListView.O();
                                return;
                            } else {
                                throw new RuntimeException("Unknown message: " + message.what);
                            }
                        }
                        String account = contactListView.J().getAccount();
                        TicketManagerImpl ticketManagerImpl = (TicketManagerImpl) contactListView.J().getManager(2);
                        if (ticketManagerImpl == null) {
                            return;
                        }
                        String a26 = ticketManagerImpl.getA2(account);
                        if (QLog.isColorLevel()) {
                            QLog.i("ContactListView", 2, "a2 = " + a26);
                        }
                        QQPimGetTipsInfoIPC.l().k(contactListView.J(), contactListView.f183812r0, account, a26);
                        return;
                    }
                    List<PhoneContact> list = (List) message.obj;
                    contactListView.U = list;
                    contactListView.V.k(list);
                    contactListView.V.notifyDataSetChanged();
                    return;
                }
                contactListView.M();
                if (!NetworkUtil.isNetSupport(contactListView.getContext())) {
                    contactListView.w();
                    contactListView.s(HardCodeUtil.qqStr(R.string.l1w));
                    return;
                }
                return;
            }
            if (contactListView.f183810p0 && !contactListView.E.isAutoUploadContacts()) {
                contactListView.a();
                contactListView.f183810p0 = false;
            }
            contactListView.M();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68749);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            f183793s0 = HardCodeUtil.qqStr(R.string.l1m);
            f183794t0 = new String[]{ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", BdhLogUtil.LogTag.Tag_Conn, "D", "E", UserInfo.SEX_FEMALE, "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, BdhLogUtil.LogTag.Tag_Req, ExifInterface.LATITUDE_SOUTH, "T", "U", "V", "W", "X", "Y", "Z", "#"};
        }
    }

    public ContactListView(Context context, int i3) {
        super(context, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, i3);
            return;
        }
        this.f183809o0 = 0;
        this.f183810p0 = false;
        this.f183811q0 = new a();
        this.f183812r0 = new d();
        l(R.layout.f168363u0);
        if (QLog.isColorLevel()) {
            QLog.i("ContactListView", 2, "ContactListView()");
        }
        this.W = new h(this);
        this.f183795a0 = new Handler(ThreadManagerV2.getSubThreadLooper(), this);
        XListView xListView = (XListView) findViewById(R.id.b87);
        this.f183796b0 = xListView;
        xListView.setOnScrollListener(this);
        this.f183805k0 = (IndexView) findViewById(R.id.djg);
    }

    private void F(View view) {
        Object tag;
        int intValue;
        String str;
        ReportController.o(this.f183714d, "CliOper", "", "", "0X800474C", "0X800474C", 0, 0, "", "", "", "");
        PhoneContact phoneContact = ((g) view.getTag()).f183827i;
        ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(this.f183718i, ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(getContext(), 2, phoneContact.nationCode + phoneContact.mobileCode, null, 3006, 3, phoneContact.name, null, null, HardCodeUtil.qqStr(R.string.f171801l25), null));
        if (this.f183719m == 3 && (tag = view.getTag(R.id.gqc)) != null && (intValue = ((Integer) tag).intValue()) < 5) {
            if (intValue != 0) {
                if (intValue != 1) {
                    if (intValue != 2) {
                        if (intValue != 3) {
                            if (intValue != 4) {
                                str = null;
                            } else {
                                str = "0X80068BB";
                            }
                        } else {
                            str = "0X80068BA";
                        }
                    } else {
                        str = "0X80068B9";
                    }
                } else {
                    str = "0X80068B8";
                }
            } else {
                str = "0X80068B7";
            }
            String str2 = str;
            if (str2 != null) {
                ReportController.o(this.f183714d, "dc00898", "", "", str2, str2, 0, 0, "", "", "", "");
            }
        }
    }

    private void H(g gVar, String str, int i3) {
        Bitmap bitmapFromCache = this.f183802h0.getBitmapFromCache(i3, str);
        if (bitmapFromCache == null) {
            if (!this.f183802h0.isPausing()) {
                this.f183802h0.requestDecodeFace(str, i3, false);
            }
            if (this.f183803i0 == null) {
                this.f183803i0 = BaseImageUtil.getDefaultFaceBitmap();
            }
            bitmapFromCache = this.f183803i0;
        }
        gVar.f183820b.setImageBitmap(bitmapFromCache);
        gVar.f183819a = str;
    }

    private View I(String str) {
        if (QLog.isColorLevel()) {
            QLog.i("ContactListView", 2, "generateMergeContactsView()");
        }
        ReportController.o(this.f183714d, "CliOper", "", "", "0X800670F", "0X800670F", 0, 0, "", "", "", "");
        if (this.f183799e0 == null) {
            this.f183799e0 = LayoutInflater.from(getContext()).inflate(R.layout.f169104c05, (ViewGroup) this.f183796b0, false);
        }
        this.f183799e0.findViewById(R.id.jm_).setOnClickListener(new b());
        this.f183799e0.findViewById(R.id.jmj).setOnClickListener(new c());
        if (!TextUtils.isEmpty(str)) {
            ((TextView) this.f183799e0.findViewById(R.id.jmm)).setText(str);
        }
        return this.f183799e0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public QQAppInterface J() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime != null && (runtime instanceof QQAppInterface)) {
            return (QQAppInterface) runtime;
        }
        return null;
    }

    private void L(boolean z16, String str) {
        View view;
        if (QLog.isColorLevel()) {
            QLog.i("ContactListView", 2, "initBlueTipsBar()");
        }
        if (z16) {
            view = I(str);
        } else {
            view = null;
        }
        if (view != null) {
            this.f183796b0.addHeaderView(view);
            View view2 = this.f183798d0;
            if (view2 != null) {
                this.f183796b0.removeHeaderView(view2);
                this.f183796b0.addHeaderView(this.f183798d0);
            }
        }
    }

    private void P() {
        int i3;
        int i16;
        if (this.f183719m == 3) {
            ReportController.o(this.f183714d, "CliOper", "", "", "0X800474D", "0X800474D", 0, 0, "", "", "", "");
        }
        this.f183714d.getApplication();
        int i17 = this.f183719m;
        if (i17 != 0 && i17 != 5) {
            i3 = 256;
            if (i17 == 2) {
                if (this.f183808n0 instanceof ForwardShareCardOption) {
                    i3 = 32768;
                }
                i16 = 21006;
            } else if (i17 == 3) {
                i16 = 21005;
            } else {
                i3 = 0;
                i16 = 21001;
            }
        } else {
            i3 = 768;
            i16 = 21004;
        }
        ContactSearchComponentActivity.V2(this.f183718i, null, 3, i3, i16);
    }

    private void Q(View view) {
        PhoneContact phoneContact;
        String str;
        int intValue;
        String str2;
        String str3;
        g gVar = (g) view.getTag();
        if (gVar != null && (phoneContact = gVar.f183827i) != null) {
            if (TextUtils.isEmpty(phoneContact.nickName)) {
                str = phoneContact.mobileNo;
            } else {
                str = phoneContact.nickName;
            }
            int i3 = gVar.f183826h;
            int i16 = this.f183719m;
            if (i16 == 2) {
                boolean z16 = this.f183808n0 instanceof ForwardShareCardOption;
                if (i3 == 2 && !z16) {
                    Bundle bundle = new Bundle();
                    bundle.putString("uin", phoneContact.uin);
                    bundle.putInt("uintype", 0);
                    bundle.putString("uinname", str);
                    this.f183718i.getIntent().putExtras(bundle);
                    this.f183808n0.buildForwardDialog(com.tencent.mobileqq.forward.e.O3.intValue(), bundle);
                } else if (i3 == 3) {
                    z16 = true;
                }
                if (z16) {
                    Bundle bundle2 = new Bundle();
                    String str4 = phoneContact.mobileCode;
                    if (TextUtils.isEmpty(str4)) {
                        str4 = phoneContact.mobileNo;
                    } else {
                        int indexOf = str4.indexOf("|");
                        if (indexOf > -1) {
                            str4 = str4.substring(0, indexOf);
                        }
                    }
                    bundle2.putBoolean(AppConstants.Key.BIND_CONTACT, !TextUtils.isEmpty(phoneContact.uin));
                    bundle2.putString("uin", str4);
                    bundle2.putInt("uintype", 1006);
                    bundle2.putString("uinname", str);
                    this.f183718i.getIntent().putExtras(bundle2);
                    this.f183808n0.buildForwardDialog(com.tencent.mobileqq.forward.e.U3.intValue(), bundle2);
                    return;
                }
                return;
            }
            if (i16 == 0) {
                QQAppInterface qQAppInterface = this.f183714d;
                if (i3 == 2) {
                    str3 = "0";
                } else {
                    str3 = "1";
                }
                ReportController.o(qQAppInterface, "CliOper", "", "", "Mobile_contacts", "Clk_addlist_prof", 0, 0, str3, "", "", "");
            } else if (i16 == 3) {
                ReportController.o(this.f183714d, "CliOper", "", "", "0X800474B", "0X800474B", 0, 0, "", "", "", "");
                Object tag = view.getTag(R.id.gqc);
                if (tag != null && (intValue = ((Integer) tag).intValue()) < 5) {
                    if (intValue != 0) {
                        if (intValue != 1) {
                            if (intValue != 2) {
                                if (intValue != 3) {
                                    if (intValue != 4) {
                                        str2 = null;
                                    } else {
                                        str2 = "0X80068B6";
                                    }
                                } else {
                                    str2 = "0X80068B5";
                                }
                            } else {
                                str2 = "0X80068B4";
                            }
                        } else {
                            str2 = "0X80068B3";
                        }
                    } else {
                        str2 = "0X80068B2";
                    }
                    String str5 = str2;
                    if (str5 != null) {
                        ReportController.o(this.f183714d, "dc00898", "", "", str5, str5, 0, 0, "", "", "", "");
                    }
                }
            }
            Context context = getContext();
            Intent intent = new Intent(context, (Class<?>) QCallDetailActivity.class);
            intent.putExtra(AppConstants.Key.CONTACT_ID, phoneContact.contactID);
            if (i3 != 2) {
                if (i3 != 3) {
                    intent.putExtra("uin", phoneContact.mobileNo);
                    intent.putExtra("uintype", AppConstants.VALUE.UIN_TYPE_UNBIND_PHONE_CONTACT);
                    intent.putExtra("uinname", phoneContact.name);
                } else {
                    intent.putExtra("uin", phoneContact.nationCode + phoneContact.mobileCode);
                    intent.putExtra("uintype", 1006);
                    intent.putExtra("uinname", phoneContact.name);
                }
            } else {
                intent.putExtra("uin", phoneContact.uin);
                intent.putExtra("uintype", 0);
                intent.putExtra("uinname", phoneContact.nickName);
            }
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(QQPimTipsInfo qQPimTipsInfo) {
        if (QLog.isColorLevel()) {
            QLog.i("ContactListView", 2, "refreshBlueBarTipsUi() tipsType " + qQPimTipsInfo.f390793d);
            QLog.i("ContactListView", 2, "refreshBlueBarTipsUi() tipsString " + qQPimTipsInfo.f390794e);
            QLog.i("ContactListView", 2, "refreshBlueBarTipsUi() repeatContactNum " + qQPimTipsInfo.f390796h);
            QLog.i("ContactListView", 2, "refreshBlueBarTipsUi() mTextViewQQPimTips " + this.f183806l0.getClass().hashCode());
        }
        int i3 = qQPimTipsInfo.f390793d;
        if (i3 == 0) {
            this.f183807m0.setVisibility(4);
            this.f183806l0.setText("");
        } else if (i3 == 1 || i3 == 2 || i3 == 4) {
            if (TextUtils.isEmpty(qQPimTipsInfo.f390794e)) {
                this.f183806l0.setText("");
            } else {
                this.f183806l0.setText(qQPimTipsInfo.f390794e);
            }
            if (qQPimTipsInfo.f390795f > 0) {
                this.f183807m0.setVisibility(0);
            } else {
                this.f183807m0.setVisibility(4);
            }
        }
        if (qQPimTipsInfo.f390793d == 3) {
            L(true, qQPimTipsInfo.f390794e);
        } else {
            L(false, null);
        }
    }

    private void S(View view) {
        String str;
        Friends v3;
        g gVar = (g) view.getTag();
        PhoneContact phoneContact = gVar.f183827i;
        int i3 = gVar.f183826h;
        QQAppInterface qQAppInterface = this.f183714d;
        if (i3 == 2) {
            str = "0";
        } else {
            str = "1";
        }
        ReportController.o(qQAppInterface, "CliOper", "", "", "Mobile_contacts", "Clk_addlist_msg", 0, 0, str, "", "", "");
        if (i3 == 2) {
            Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(getContext()), null);
            m3.putExtra("uin", phoneContact.uin);
            FriendsManager friendsManager = (FriendsManager) this.f183714d.getManager(QQManagerFactory.FRIENDS_MANAGER);
            if (friendsManager != null && (v3 = friendsManager.v(String.valueOf(phoneContact.uin))) != null) {
                m3.putExtra(AppConstants.Key.CSPECIAL_FLAG, v3.cSpecialFlag);
                m3.putExtra("uinname", v3.getFriendNickWithAlias());
                if (CrmUtils.s(v3.cSpecialFlag) || QidianManager.O(v3.cSpecialFlag)) {
                    m3.putExtra("chat_subType", 1);
                }
            }
            m3.putExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, 3);
            m3.putExtra("uintype", 0);
            t(m3);
            return;
        }
        if (i3 == 3) {
            RespondQueryQQBindingStat selfBindInfo = ((IPhoneContactService) this.f183714d.getRuntimeService(IPhoneContactService.class, "")).getSelfBindInfo();
            String str2 = selfBindInfo.nationCode + selfBindInfo.mobileNo;
            Intent m16 = BaseAIOUtils.m(SplashActivity.getAliasIntent(getContext()), null);
            m16.putExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, 3);
            m16.putExtra("uin", phoneContact.nationCode + phoneContact.mobileCode);
            m16.putExtra(AppConstants.Key.PHONENUM, str2);
            m16.putExtra("uintype", 1006);
            m16.putExtra("uinname", phoneContact.name);
            AllInOne allInOne = new AllInOne(phoneContact.nationCode + phoneContact.mobileCode, 31);
            ArrayList<ProfileContactInfo> arrayList = new ArrayList<>();
            allInOne.contactArray = arrayList;
            allInOne.nickname = phoneContact.nickName;
            allInOne.contactName = phoneContact.name;
            arrayList.add(new ProfileContactInfo(phoneContact.name, phoneContact.mobileCode, phoneContact.nationCode));
            allInOne.chatAbility = phoneContact.ability;
            allInOne.lastActivity = 3;
            allInOne.profileEntryType = 59;
            m16.putExtra(AppConstants.Key.AIO_INFO, allInOne);
            t(m16);
        }
    }

    private void T(ListView listView, String str, Bitmap bitmap) {
        if (this.f183809o0 == 0) {
            int childCount = listView.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                g gVar = (g) listView.getChildAt(i3).getTag();
                if (gVar != null && str.equals(gVar.f183819a)) {
                    gVar.f183820b.setImageBitmap(bitmap);
                    return;
                }
            }
        }
    }

    private void U(View view) {
        String str;
        g gVar = (g) view.getTag();
        QQAppInterface qQAppInterface = this.f183714d;
        if (gVar.f183826h == 2) {
            str = "0";
        } else {
            str = "1";
        }
        ReportController.o(qQAppInterface, "CliOper", "", "", "Mobile_contacts", "Clk_addlist_call", 0, 0, str, "", "", "");
        PhoneContact phoneContact = gVar.f183827i;
        int i3 = gVar.f183826h;
        int i16 = 0;
        if (i3 != 2 && i3 == 3) {
            i16 = 1006;
        }
        ChatActivityUtils.h0(this.f183714d, getContext(), i16, phoneContact.uin, phoneContact.name, phoneContact.nationCode + phoneContact.mobileCode, true, null, true, true, null, "from_internal");
        ReportController.o(this.f183714d, "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, "9", "", "", "");
    }

    void G(View view, PhoneContact phoneContact, boolean z16) {
        g gVar = (g) view.getTag();
        if (z16) {
            gVar.f183822d.setText(String.format("%s(%s)", phoneContact.name, phoneContact.mobileNo));
        } else {
            gVar.f183822d.setText(phoneContact.name);
        }
        gVar.f183819a = null;
        gVar.f183827i = phoneContact;
        if (TextUtils.isEmpty(phoneContact.uin)) {
            gVar.f183820b.setVisibility(0);
            gVar.f183821c.setVisibility(0);
            gVar.f183824f.setVisibility(8);
            gVar.f183825g.setVisibility(8);
            gVar.f183826h = 1;
            gVar.f183820b.setImageResource(R.drawable.day);
            String L = ac.L(phoneContact.name);
            gVar.f183821c.setText(L);
            if (ac.o0(L)) {
                gVar.f183821c.setTextSize(0, view.getResources().getDimensionPixelSize(R.dimen.ayq));
            } else {
                gVar.f183821c.setTextSize(0, view.getResources().getDimensionPixelSize(R.dimen.ayr));
            }
            gVar.f183823e.setVisibility(8);
            return;
        }
        gVar.f183820b.setVisibility(0);
        gVar.f183821c.setVisibility(8);
        int i3 = this.f183719m;
        if (i3 == 0 || i3 == 5) {
            gVar.f183824f.setVisibility(8);
            gVar.f183825g.setVisibility(0);
        }
        gVar.f183824f.setTag(gVar);
        gVar.f183825g.setTag(gVar);
        gVar.f183824f.setContentDescription(HardCodeUtil.qqStr(R.string.l1l) + phoneContact.name + HardCodeUtil.qqStr(R.string.l1u));
        gVar.f183825g.setContentDescription(HardCodeUtil.qqStr(R.string.l1q) + phoneContact.name + HardCodeUtil.qqStr(R.string.l1s));
        if (!phoneContact.uin.equals("0")) {
            gVar.f183826h = 2;
            H(gVar, phoneContact.uin, 1);
            gVar.f183823e.setVisibility(8);
        } else {
            gVar.f183826h = 3;
            H(gVar, phoneContact.nationCode + phoneContact.mobileCode, 11);
            if (this.f183719m == 5) {
                if (phoneContact.isHiden) {
                    gVar.f183823e.setVisibility(0);
                    if (AppSetting.f99565y) {
                        view.setContentDescription(phoneContact.name + HardCodeUtil.qqStr(R.string.l27));
                    }
                } else {
                    gVar.f183823e.setVisibility(8);
                    if (AppSetting.f99565y) {
                        view.setContentDescription(phoneContact.name + HardCodeUtil.qqStr(R.string.l1t));
                    }
                }
            } else {
                gVar.f183823e.setVisibility(8);
            }
        }
        if (gVar.f183826h != 2) {
            gVar.f183825g.setVisibility(8);
        }
    }

    void K() {
        boolean z16;
        int i3 = this.f183719m;
        if (i3 == 2 && (this.f183808n0 instanceof ForwardShareCardOption)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (i3 != 5 && !z16) {
            this.P = this.E.getContactListForDisplay();
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.E.getContactListForContactListView(z16));
            arrayList.add(new ArrayList());
            this.P = arrayList;
        }
        O();
    }

    void M() {
        int i3 = this.f183719m;
        if (i3 != 0 && i3 != 2 && i3 != 5) {
            if (i3 == 3) {
                int loadContactFriendList = this.E.loadContactFriendList(this.T);
                if (QLog.isColorLevel()) {
                    QLog.d("ContactListView", 2, "load contact friend result: " + loadContactFriendList);
                    return;
                }
                return;
            }
            return;
        }
        int selfBindState = this.E.getSelfBindState();
        if (QLog.isColorLevel()) {
            QLog.d("ContactListView", 2, "the load contact mode is retype=" + this.f183719m + ", state=" + selfBindState);
        }
        if (selfBindState != 1 && selfBindState != 2 && selfBindState != 6 && selfBindState != 7 && selfBindState != 3) {
            K();
        } else {
            this.f183795a0.sendEmptyMessage(7);
        }
    }

    View N() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.f168364u1, (ViewGroup) null);
        g gVar = new g();
        gVar.f183820b = (ImageView) inflate.findViewById(R.id.fxi);
        gVar.f183821c = (TextView) inflate.findViewById(R.id.fxj);
        gVar.f183823e = (ImageView) inflate.findViewById(R.id.fxh);
        gVar.f183822d = (TextView) inflate.findViewById(R.id.f5o);
        Button button = (Button) inflate.findViewById(R.id.jw9);
        gVar.f183824f = button;
        button.setOnClickListener(this);
        Button button2 = (Button) inflate.findViewById(R.id.jw8);
        gVar.f183825g = button2;
        button2.setOnClickListener(this);
        Button button3 = (Button) inflate.findViewById(R.id.f164010gx);
        gVar.f183828j = button3;
        button3.setOnClickListener(this);
        gVar.f183829k = (TextView) inflate.findViewById(R.id.f164003go);
        gVar.f183830l = inflate.findViewById(R.id.i_h);
        if (this.f183719m == 3) {
            gVar.f183824f.setVisibility(8);
            gVar.f183825g.setVisibility(8);
            gVar.f183830l.setVisibility(8);
        } else {
            gVar.f183828j.setVisibility(8);
            gVar.f183829k.setVisibility(8);
        }
        inflate.setTag(gVar);
        return inflate;
    }

    void O() {
        int i3;
        if (this.S == null) {
            e eVar = new e();
            this.S = eVar;
            this.f183796b0.setAdapter((ListAdapter) eVar);
        }
        if (this.P == null) {
            this.W.sendEmptyMessageDelayed(1, 1000L);
            return;
        }
        this.f183804j0 = new LinkedHashMap();
        for (String str : f183794t0) {
            this.f183804j0.put(str, 0);
        }
        ArrayList<PhoneContact> arrayList = new ArrayList<>();
        String str2 = "*";
        for (PhoneContact phoneContact : this.P.get(0)) {
            String str3 = phoneContact.pinyinFirst;
            if (this.f183804j0.get(str3) == null) {
                str3 = "#";
                phoneContact.pinyinFirst = "#";
            }
            if (!str2.equals(str3)) {
                arrayList.add(null);
                str2 = str3;
            }
            arrayList.add(phoneContact);
            HashMap<String, Integer> hashMap = this.f183804j0;
            hashMap.put(str3, Integer.valueOf(hashMap.get(str3).intValue() + 1));
        }
        int i16 = 0;
        for (String str4 : this.f183804j0.keySet()) {
            int intValue = this.f183804j0.get(str4).intValue();
            if (intValue != 0) {
                i3 = intValue + i16 + 1;
            } else {
                i3 = i16;
            }
            this.f183804j0.put(str4, Integer.valueOf(i16));
            i16 = i3;
        }
        if (this.f183719m == 0) {
            List<PhoneContact> list = this.P.get(1);
            if (list.size() > 0) {
                this.f183804j0.put(f183793s0, Integer.valueOf(arrayList.size()));
                arrayList.add(null);
                for (PhoneContact phoneContact2 : list) {
                    phoneContact2.pinyinFirst = f183793s0;
                    arrayList.add(phoneContact2);
                }
            }
        }
        this.Q = arrayList;
        int size = arrayList.size();
        this.R = size;
        if (size > 10) {
            this.f183805k0.setVisibility(0);
        } else {
            this.f183805k0.setVisibility(8);
        }
        this.S.notifyDataSetChanged();
    }

    @Override // com.tencent.mobileqq.activity.phone.BaseActivityView
    public void g(int i3, int i16, Intent intent) {
        AllInOne allInOne;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.g(i3, i16, intent);
        if (QLog.isColorLevel()) {
            QLog.i("ContactListView", 2, "onActivityResult() ");
        }
        if (i3 == 1) {
            if (i16 == 2) {
                Intent intent2 = new Intent(getContext(), (Class<?>) BindNumberActivity.class);
                intent2.putExtra("kNeedUnbind", true);
                t(intent2);
            } else if (i16 == 0) {
                int selfBindState = this.E.getSelfBindState();
                if (selfBindState == 1 || selfBindState == 5) {
                    t(new Intent(getContext(), (Class<?>) PhoneLaunchActivity.class));
                }
            } else if (i16 == 4002) {
                d();
            } else {
                t(new Intent(getContext(), (Class<?>) PhoneLaunchActivity.class));
            }
        }
        if (i16 == -1) {
            if (i3 != 21005) {
                if (i3 == 21006) {
                    SearchUtil.h(intent, this.f183808n0);
                    return;
                }
                return;
            }
            if (intent != null) {
                String stringExtra = intent.getStringExtra("contactSearchResultUin");
                int intExtra = intent.getIntExtra("contactSearchResultUinType", 0);
                String stringExtra2 = intent.getStringExtra("contactSearchResultName");
                long longExtra = intent.getLongExtra("contactSearchResultPhoneContactOriginBinder", -1L);
                String stringExtra3 = intent.getStringExtra("contactSearchResultPhoneContactMobileCode");
                String stringExtra4 = intent.getStringExtra("contactSearchResultPhoneContactNationCode");
                int intExtra2 = intent.getIntExtra("contactSearchResultPhoneContactAbility", -1);
                if (intExtra == 1006) {
                    if (longExtra == 3) {
                        i17 = 32;
                    } else {
                        i17 = 31;
                    }
                    allInOne = new AllInOne(stringExtra, i17);
                    ArrayList<ProfileContactInfo> arrayList = new ArrayList<>();
                    allInOne.contactArray = arrayList;
                    allInOne.contactName = stringExtra2;
                    arrayList.add(new ProfileContactInfo(stringExtra2, stringExtra3, stringExtra4));
                    allInOne.chatAbility = intExtra2;
                    allInOne.lastActivity = 3;
                } else if (intExtra == 0) {
                    allInOne = new AllInOne(stringExtra, 1);
                } else {
                    allInOne = null;
                }
                ProfileUtils.openProfileCard(this.f183718i, allInOne);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.phone.BaseActivityView
    public void h(Intent intent, PhoneInnerFrame phoneInnerFrame) {
        boolean z16;
        String[] stringArrayExtra;
        BaseActivity baseActivity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) phoneInnerFrame);
            return;
        }
        super.h(intent, phoneInnerFrame);
        if (QLog.isColorLevel()) {
            QLog.i("ContactListView", 2, "onCreate()");
        }
        int selfBindState = this.E.getSelfBindState();
        if (this.f183719m == 2 && (selfBindState == 1 || selfBindState == 2 || selfBindState == 6 || selfBindState == 7 || selfBindState == 3)) {
            z16 = false;
        } else {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.search_box, (ViewGroup) this.f183796b0, false);
            this.f183797c0 = inflate;
            if (inflate != null) {
                inflate.findViewById(R.id.btn_cancel_search).setVisibility(8);
                EditText editText = (EditText) this.f183797c0.findViewById(R.id.et_search_keyword);
                this.f183800f0 = editText;
                editText.setFocusableInTouchMode(false);
                this.f183800f0.setCursorVisible(false);
                this.f183800f0.setOnClickListener(this);
                this.f183796b0.addHeaderView(this.f183797c0);
            }
            z16 = true;
        }
        if (this.f183719m == 2 && (baseActivity = this.f183718i) != null) {
            this.f183808n0 = k.d(baseActivity.getIntent(), this.f183714d, this.f183718i);
        }
        int i3 = this.f183719m;
        if (i3 != 0 && i3 != 2 && i3 != 5) {
            com.tencent.mobileqq.adapter.h hVar = new com.tencent.mobileqq.adapter.h(getContext(), this.f183714d, this.f183796b0, this.U);
            this.V = hVar;
            this.f183796b0.setAdapter((ListAdapter) hVar);
            this.f183805k0.setVisibility(8);
        } else {
            View view = this.f183797c0;
            if (view != null) {
                view.setPadding(0, 0, 40, 0);
            }
        }
        BaseActivity baseActivity2 = this.f183718i;
        if (baseActivity2 != null && (stringArrayExtra = baseActivity2.getIntent().getStringArrayExtra("key_reserved_mobile")) != null && stringArrayExtra.length > 0) {
            this.T = Arrays.asList(stringArrayExtra);
        }
        IFaceDecoder iQQAvatarService = ((IQQAvatarService) this.f183714d.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.f183714d);
        this.f183802h0 = iQQAvatarService;
        iQQAvatarService.setDecodeTaskCompletionListener(this);
        this.f183805k0.setIndex(f183794t0, z16, false, false);
        this.f183805k0.setOnIndexChangedListener(this);
        this.E.checkUpdateBindStateAndListIgnoreBindState(true, false, 19);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) message)).booleanValue();
        }
        if (message.what == 7) {
            this.f183795a0.removeMessages(7);
            ArrayList arrayList = new ArrayList();
            IPhoneContactService iPhoneContactService = this.E;
            arrayList.add(iPhoneContactService.getContactListForContactListView(iPhoneContactService.loadContactFromPhoneWithoutCaches(), true));
            arrayList.add(new ArrayList());
            this.P = arrayList;
            this.W.sendEmptyMessage(8);
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.phone.BaseActivityView
    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ContactListView", 2, "onResume()");
        }
        super.j();
        ((InputMethodManager) getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(getWindowToken(), 0);
        if (this.E.getSelfBindState() != 9) {
            if (NetworkUtil.isNetSupport(getContext())) {
                if (this.E.isAutoUploadContacts()) {
                    q(R.string.hex, 0L, false);
                    return;
                } else {
                    this.E.checkUpdateBindStateAndListIgnoreBindState(true, true, 20);
                    v();
                    return;
                }
            }
            p(R.string.cjm, 3000L);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view);
        } else {
            ((InputMethodManager) getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(getWindowToken(), 0);
            int id5 = view.getId();
            if (id5 == R.id.et_search_keyword) {
                P();
            } else if (id5 == R.id.ivTitleBtnRightText) {
                if (this.f183719m == 2) {
                    d();
                } else {
                    Intent intent = this.f183718i.getIntent();
                    Intent intent2 = new Intent(getContext(), (Class<?>) SettingActivity2.class);
                    if (intent.hasExtra("kSrouce")) {
                        intent2.putExtra("kSrouce", intent.getIntExtra("kSrouce", 6));
                    }
                    u(intent2, 1);
                    ReportController.o(this.f183714d, "CliOper", "", "", "Moblie_contacts", "Moblie_contacts_setting", 0, 0, "", "", "", "");
                }
            } else if (id5 == R.id.jw9) {
                S(view);
            } else if (id5 == R.id.jw8) {
                U(view);
            } else if (id5 == R.id.f164010gx) {
                F(view);
            } else {
                Q(view);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bitmap);
        } else if (bitmap != null && !TextUtils.isEmpty(str)) {
            T(this.f183796b0, str, bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.phone.BaseActivityView
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        QQPimGetTipsInfoIPC.l().i();
        ForwardBaseOption forwardBaseOption = this.f183808n0;
        if (forwardBaseOption != null) {
            forwardBaseOption.onDestroy();
        }
        Handler handler = this.f183795a0;
        if (handler != null) {
            handler.removeMessages(7);
        }
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.widget.IndexView.b
    public void onIndexChanged(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        } else if ("$".equals(str)) {
            this.f183796b0.setSelection(0);
        } else {
            XListView xListView = this.f183796b0;
            xListView.setSelection(xListView.getHeaderViewsCount() + this.f183804j0.get(str).intValue());
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) absListView, i3);
            return;
        }
        this.f183809o0 = i3;
        if (i3 != 0) {
            this.f183802h0.cancelPendingRequests();
            this.f183802h0.pause();
            return;
        }
        if (this.f183802h0.isPausing()) {
            this.f183802h0.resume();
        }
        int childCount = this.f183796b0.getChildCount();
        for (int i17 = 0; i17 < childCount; i17++) {
            g gVar = (g) this.f183796b0.getChildAt(i17).getTag();
            if (gVar != null && !TextUtils.isEmpty(gVar.f183819a)) {
                if (gVar.f183826h == 3) {
                    i16 = 11;
                } else {
                    i16 = 1;
                }
                Bitmap bitmapFromCache = this.f183802h0.getBitmapFromCache(i16, gVar.f183819a);
                if (bitmapFromCache == null) {
                    this.f183802h0.requestDecodeFace(gVar.f183819a, i16, false);
                } else {
                    gVar.f183820b.setImageBitmap(bitmapFromCache);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.phone.BaseActivityView
    public void onStart() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onStart();
        if (QLog.isColorLevel()) {
            QLog.i("ContactListView", 2, "onStart()");
        }
        this.f183714d.setHandler(ContactListView.class, this.W);
        int i3 = this.f183719m;
        if (i3 == 2) {
            this.I.setText(HardCodeUtil.qqStr(R.string.f171798l22));
        } else if (i3 != 0 && i3 != 5) {
            if (i3 == 3) {
                this.I.setText(HardCodeUtil.qqStr(R.string.l1o));
            }
        } else {
            this.I.setText(HardCodeUtil.qqStr(R.string.f171800l24));
        }
        if (this.N == null) {
            f fVar = new f();
            this.N = fVar;
            this.f183714d.registObserver(fVar);
        }
        this.f183714d.addObserver(this.f183811q0);
        M();
        int selfBindState = this.E.getSelfBindState();
        if (this.f183719m == 2 && (this.f183808n0 instanceof ForwardShareCardOption)) {
            this.H.setVisibility(8);
        } else {
            this.H.setOnClickListener(this);
            TextView textView = this.H;
            if (selfBindState != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            textView.setEnabled(z16);
        }
        this.f183802h0.resume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.phone.BaseActivityView
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ContactListView", 2, "onStop()");
        }
        this.f183802h0.pause();
        this.f183802h0.destory();
        this.f183714d.removeHandler(ContactListView.class);
        w();
        a();
        ActionSheet actionSheet = this.f183801g0;
        if (actionSheet != null) {
            actionSheet.cancel();
            this.f183801g0 = null;
        }
        f fVar = this.N;
        if (fVar != null) {
            this.f183714d.unRegistObserver(fVar);
            this.N = null;
        }
        this.f183714d.removeObserver(this.f183811q0);
        super.onStop();
    }
}
