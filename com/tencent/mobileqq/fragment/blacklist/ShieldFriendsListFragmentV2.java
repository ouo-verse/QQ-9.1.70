package com.tencent.mobileqq.fragment.blacklist;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.fragment.blacklist.e;
import com.tencent.mobileqq.fragment.blacklist.userdb.ShieldUserDisplayManager;
import com.tencent.mobileqq.fragment.blacklist.userdb.data.ShieldUserDisplayData;
import com.tencent.mobileqq.profilecard.api.IRelationBlacklistApi;
import com.tencent.mobileqq.profilecard.base.report.ProfileCardBlacklistReportConst;
import com.tencent.mobileqq.profilecard.listener.RelationBlacklistListener;
import com.tencent.mobileqq.profilecard.service.IProfileCardBlacklistService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.utils.al;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.utils.i;
import com.tencent.widget.Switch;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ShieldFriendsListFragmentV2 extends QIphoneTitleBarFragment implements DecodeTaskCompletionListener {
    static IPatchRedirector $redirector_;
    private TextView C;
    private XListView D;
    private IFaceDecoder E;
    private ShieldFriendsAdapter F;
    private BlackListViewModel G;
    private AppInterface H;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class ShieldFriendsAdapter extends BaseAdapter implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private List<e.a> f211286d;

        /* renamed from: e, reason: collision with root package name */
        private QBaseActivity f211287e;

        /* renamed from: f, reason: collision with root package name */
        private IFaceDecoder f211288f;

        /* renamed from: h, reason: collision with root package name */
        private QQAppInterface f211289h;

        public ShieldFriendsAdapter(QBaseActivity qBaseActivity, IFaceDecoder iFaceDecoder, QQAppInterface qQAppInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, qBaseActivity, iFaceDecoder, qQAppInterface);
                return;
            }
            this.f211287e = qBaseActivity;
            this.f211286d = new ArrayList(0);
            this.f211288f = iFaceDecoder;
            this.f211289h = qQAppInterface;
        }

        public void a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
                return;
            }
            List<e.a> list = this.f211286d;
            if (list != null && !list.isEmpty()) {
                for (e.a aVar : this.f211286d) {
                    if (aVar.f211317a.equals(str)) {
                        this.f211286d.remove(aVar);
                        notifyDataSetChanged();
                        return;
                    }
                }
                notifyDataSetChanged();
            }
        }

        public void b(List<e.a> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) list);
            } else if (list != null && !list.isEmpty()) {
                this.f211286d = list;
                notifyDataSetChanged();
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            List<e.a> list = this.f211286d;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return iPatchRedirector.redirect((short) 7, (Object) this, i3);
            }
            List<e.a> list = this.f211286d;
            if (list == null) {
                return null;
            }
            return list.get(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Long) iPatchRedirector.redirect((short) 8, (Object) this, i3)).longValue();
            }
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            c cVar;
            View view2;
            View view3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                view2 = (View) iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), view, viewGroup);
            } else if (this.f211289h == null) {
                view2 = null;
            } else {
                if (view == null) {
                    view = LayoutInflater.from(this.f211287e).inflate(R.layout.b2o, viewGroup, false);
                    cVar = new c();
                    cVar.f211292a = (URLImageView) view.findViewById(R.id.is5);
                    cVar.f211293b = (TextView) view.findViewById(R.id.is6);
                    Switch r56 = (Switch) view.findViewById(R.id.is7);
                    cVar.f211294c = r56;
                    r56.setTag(cVar);
                    view.setTag(cVar);
                } else {
                    cVar = (c) view.getTag();
                }
                if (i3 == 0) {
                    if (i3 == getCount() - 1) {
                        view.setBackgroundResource(R.drawable.kty);
                    } else {
                        view.setBackgroundResource(R.drawable.ktz);
                    }
                } else if (i3 == getCount() - 1) {
                    view.setBackgroundResource(R.drawable.ktx);
                } else {
                    view.setBackgroundResource(R.drawable.qui_common_fill_light_secondary_bg);
                }
                e.a aVar = (e.a) getItem(i3);
                if (aVar == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ShieldFriendsListFragmentV2", 2, "friend == null,\u8fd9\u79cd\u60c5\u51b5\u4e0d\u5e94\u8be5\u51fa\u73b0\u7684");
                    }
                } else {
                    cVar.f211295d = aVar.f211317a;
                    cVar.f211294c.setOnCheckedChangeListener(null);
                    cVar.f211294c.setChecked(true);
                    cVar.f211294c.setOnCheckedChangeListener(this);
                    cVar.f211296e = this;
                    if (ShieldFriendsListFragmentV2.uh(cVar.f211295d)) {
                        cVar.f211293b.setText(ac.Q(this.f211289h, aVar.f211317a, 0));
                    } else if (!TextUtils.isEmpty(aVar.f211318b)) {
                        cVar.f211293b.setText(aVar.f211318b);
                    } else {
                        cVar.f211293b.setText(aVar.f211317a);
                    }
                    if (FaceDrawable.getFaceDrawable(this.f211289h, 1, cVar.f211295d) != null) {
                        cVar.f211292a.setBackgroundDrawable(FaceDrawable.getFaceDrawable(this.f211289h, 1, cVar.f211295d));
                    } else {
                        cVar.f211292a.setBackgroundDrawable((BitmapDrawable) BaseImageUtil.getDefaultFaceDrawable140_140());
                    }
                }
                view2 = view;
                view3 = view2;
                EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
                return view2;
            }
            view3 = view;
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            int i3 = 2;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, this, compoundButton, Boolean.valueOf(z16));
            } else {
                int netWorkType = HttpUtil.getNetWorkType();
                if (netWorkType != -1) {
                    i3 = netWorkType;
                }
                c cVar = (c) compoundButton.getTag();
                if (i3 == 0) {
                    QQToast.makeText(this.f211287e, 1, R.string.dqp, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                    compoundButton.setOnCheckedChangeListener(null);
                    compoundButton.setChecked(!z16);
                    compoundButton.setOnCheckedChangeListener(cVar.f211296e);
                } else {
                    QQAppInterface qQAppInterface = this.f211289h;
                    if (qQAppInterface != null) {
                        ((IProfileCardBlacklistService) qQAppInterface.getRuntimeService(IProfileCardBlacklistService.class, "all")).reportItemEvent("clck", "pg_block_user_manage", ProfileCardBlacklistReportConst.ELEM_ID_EM_BLOCK_USER_SWITCH, null, new HashMap<String, String>(cVar) { // from class: com.tencent.mobileqq.fragment.blacklist.ShieldFriendsListFragmentV2.ShieldFriendsAdapter.1
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ c val$holder;

                            {
                                this.val$holder = cVar;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ShieldFriendsAdapter.this, (Object) cVar);
                                } else {
                                    put("to_uin", cVar.f211295d);
                                }
                            }
                        });
                        if (ShieldFriendsListFragmentV2.uh(cVar.f211295d)) {
                            ((FriendListHandler) this.f211289h.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).changeFriendShieldFlag(Long.valueOf(cVar.f211295d).longValue(), z16);
                        } else {
                            ChatActivityUtils.W(this.f211289h, null, 1000, cVar.f211295d, "", true);
                        }
                        if (!z16) {
                            a(cVar.f211295d);
                        }
                    }
                }
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements Observer<ShieldUserDisplayManager.a> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ShieldFriendsListFragmentV2.this);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(ShieldUserDisplayManager.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
                return;
            }
            if (ShieldFriendsListFragmentV2.this.G == null) {
                return;
            }
            if (aVar != null && aVar.f211343b != null) {
                ArrayList arrayList = new ArrayList();
                for (ShieldUserDisplayData shieldUserDisplayData : aVar.f211343b) {
                    if (ShieldFriendsListFragmentV2.uh(shieldUserDisplayData.uin)) {
                        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                        if (peekAppRuntime != null && (peekAppRuntime instanceof AppInterface)) {
                            shieldUserDisplayData.nickName = ac.Q((AppInterface) peekAppRuntime, shieldUserDisplayData.uin, 0);
                        } else {
                            QLog.e("ShieldFriendsListFragmentV2", 1, "AppInterface get faild, stop update");
                            shieldUserDisplayData.nickName = shieldUserDisplayData.uin;
                        }
                    } else if (TextUtils.isEmpty(shieldUserDisplayData.nickName)) {
                        shieldUserDisplayData.nickName = shieldUserDisplayData.uin;
                    }
                    arrayList.add(new e.a(shieldUserDisplayData.uin, shieldUserDisplayData.nickName, shieldUserDisplayData.avatar));
                }
                try {
                    ShieldFriendsListFragmentV2.this.G.c2(arrayList);
                } catch (IllegalArgumentException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e(ShieldFriendsListFragmentV2.this.getTAG(), 2, "A Z sort error " + e16.toString());
                    }
                    ShieldFriendsListFragmentV2.this.G.W1().postValue(null);
                }
                ShieldFriendsListFragmentV2.this.G.W1().postValue(arrayList);
                return;
            }
            ShieldFriendsListFragmentV2.this.G.W1().postValue(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements Observer<List<e.a>> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ShieldFriendsListFragmentV2.this);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(List<e.a> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
            } else {
                if (list == null) {
                    return;
                }
                ShieldFriendsListFragmentV2.this.F.b(list);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public URLImageView f211292a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f211293b;

        /* renamed from: c, reason: collision with root package name */
        public Switch f211294c;

        /* renamed from: d, reason: collision with root package name */
        public String f211295d;

        /* renamed from: e, reason: collision with root package name */
        public CompoundButton.OnCheckedChangeListener f211296e;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public ShieldFriendsListFragmentV2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.G = null;
        }
    }

    private void initViewModel() {
        BlackListViewModel blackListViewModel = (BlackListViewModel) getViewModel(BlackListViewModel.class);
        this.G = blackListViewModel;
        blackListViewModel.Z1().observe(getQBaseActivity(), new a());
        this.G.a2();
        this.G.W1().observe(getQBaseActivity(), new b());
    }

    private void th() {
        TextView textView = (TextView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.z6r);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) HardCodeUtil.qqStr(R.string.f201134u0));
        spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.tencent.mobileqq.fragment.blacklist.ShieldFriendsListFragmentV2.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ShieldFriendsListFragmentV2.this);
                }
            }

            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                    return;
                }
                if (ShieldFriendsListFragmentV2.this.H != null) {
                    ((IProfileCardBlacklistService) ShieldFriendsListFragmentV2.this.H.getRuntimeService(IProfileCardBlacklistService.class, "all")).reportItemEvent("clck", "pg_block_user_manage", "em_remove_to_blacklist_button", null, null);
                }
                DialogUtil.createCustomDialog(ShieldFriendsListFragmentV2.this.getContext(), 230, HardCodeUtil.qqStr(R.string.f201124tz), HardCodeUtil.qqStr(R.string.f201104tx), HardCodeUtil.qqStr(R.string.f201084tv), HardCodeUtil.qqStr(R.string.f201094tw), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.fragment.blacklist.ShieldFriendsListFragmentV2.1.1
                    static IPatchRedirector $redirector_;

                    /* compiled from: P */
                    /* renamed from: com.tencent.mobileqq.fragment.blacklist.ShieldFriendsListFragmentV2$1$1$a */
                    /* loaded from: classes12.dex */
                    class a implements RelationBlacklistListener {
                        static IPatchRedirector $redirector_;

                        a() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DialogInterfaceOnClickListenerC76251.this);
                            }
                        }

                        @Override // com.tencent.mobileqq.profilecard.listener.RelationBlacklistListener
                        public void onResult(boolean z16, Object obj) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj);
                            }
                        }
                    }

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                        }
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                            return;
                        }
                        if (ShieldFriendsListFragmentV2.this.H != null) {
                            ((IProfileCardBlacklistService) ShieldFriendsListFragmentV2.this.H.getRuntimeService(IProfileCardBlacklistService.class, "all")).reportItemEvent("clck", "pg_block_user_manage", "em_remove_to_blacklist_pop", null, new HashMap<String, String>() { // from class: com.tencent.mobileqq.fragment.blacklist.ShieldFriendsListFragmentV2.1.1.1
                                static IPatchRedirector $redirector_;

                                {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) DialogInterfaceOnClickListenerC76251.this);
                                    } else {
                                        put("pop_option_click", "1");
                                    }
                                }
                            });
                        }
                        dialogInterface.dismiss();
                        if (!NetworkUtil.isNetworkAvailable()) {
                            QQToast.makeText(ShieldFriendsListFragmentV2.this.getContext(), R.string.f1511016s, 1).show();
                            return;
                        }
                        QQToast.makeText(ShieldFriendsListFragmentV2.this.getContext(), 5, R.string.f201114ty, 0).show();
                        i.c().i(true);
                        ((IRelationBlacklistApi) QRoute.api(IRelationBlacklistApi.class)).sendShieldListTransferRequest(new a());
                        ShieldFriendsListFragmentV2.this.getQBaseActivity().finish();
                    }
                }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.fragment.blacklist.ShieldFriendsListFragmentV2.1.2
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                        }
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                            return;
                        }
                        if (ShieldFriendsListFragmentV2.this.H != null) {
                            ((IProfileCardBlacklistService) ShieldFriendsListFragmentV2.this.H.getRuntimeService(IProfileCardBlacklistService.class, "all")).reportItemEvent("clck", "pg_block_user_manage", "em_remove_to_blacklist_pop", null, new HashMap<String, String>() { // from class: com.tencent.mobileqq.fragment.blacklist.ShieldFriendsListFragmentV2.1.2.1
                                static IPatchRedirector $redirector_;

                                {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                                    } else {
                                        put("pop_option_click", "2");
                                    }
                                }
                            });
                        }
                        dialogInterface.dismiss();
                    }
                }).show();
                if (ShieldFriendsListFragmentV2.this.H != null) {
                    ((IProfileCardBlacklistService) ShieldFriendsListFragmentV2.this.H.getRuntimeService(IProfileCardBlacklistService.class, "all")).reportItemEvent("imp", "pg_block_user_manage", "em_remove_to_blacklist_pop", null, null);
                }
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) textPaint);
                } else {
                    textPaint.setUnderlineText(false);
                }
            }
        }, spannableStringBuilder.length() - 5, spannableStringBuilder.length(), 33);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColorStateList(R.color.qui_common_text_link).getDefaultColor()), spannableStringBuilder.length() - 5, spannableStringBuilder.length(), 33);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableStringBuilder);
    }

    public static boolean uh(String str) {
        if (TextUtils.isEmpty(str) || MobileQQ.sMobileQQ.peekAppRuntime() == null) {
            return false;
        }
        return ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "ShieldFriendsListFragmentV2");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, layoutInflater, viewGroup, bundle);
            return;
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        super.setTitle(HardCodeUtil.qqStr(R.string.f2047153n));
        ((QIphoneTitleBarFragment) this).mContentView.setBackgroundResource(R.drawable.qui_common_bg_bottom_standard_bg);
        this.H = (AppInterface) getQBaseActivity().getAppRuntime();
        this.D = (XListView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.ebs);
        TextView textView = (TextView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.cbn);
        this.C = textView;
        textView.setText(R.string.f171524ft0);
        this.C.setBackgroundDrawable(null);
        this.C.setTextSize(2, 17.0f);
        this.C.setTextColor(getResources().getColorStateList(R.color.qui_common_text_secondary).getDefaultColor());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.C.setLayoutParams(layoutParams);
        IFaceDecoder iQQAvatarService = ((IQQAvatarService) getQBaseActivity().getAppRuntime().getRuntimeService(IQQAvatarService.class, "")).getInstance((AppInterface) getQBaseActivity().getAppRuntime());
        this.E = iQQAvatarService;
        iQQAvatarService.setDecodeTaskCompletionListener(this);
        ShieldFriendsAdapter shieldFriendsAdapter = new ShieldFriendsAdapter(getQBaseActivity(), this.E, (QQAppInterface) getQBaseActivity().getAppRuntime());
        this.F = shieldFriendsAdapter;
        this.D.setAdapter((ListAdapter) shieldFriendsAdapter);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.D.getLayoutParams();
        layoutParams2.topMargin = (int) al.a(getQBaseActivity(), 12.0f);
        this.D.setLayoutParams(layoutParams2);
        if (AppSetting.f99565y) {
            this.leftView.setContentDescription(HardCodeUtil.qqStr(R.string.f171898lr0));
        }
        th();
        initViewModel();
        this.G.S1();
        this.G.Q1();
        AppInterface appInterface = this.H;
        if (appInterface != null) {
            ((IProfileCardBlacklistService) appInterface.getRuntimeService(IProfileCardBlacklistService.class, "all")).reportPageEvent("dt_pgin", "pg_block_user_manage", "", null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.h4w;
    }

    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
        c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bitmap);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ShieldFriendsListFragmentV2", 2, "uin=" + str + ", type=" + i16 + ",avatar= " + bitmap);
        }
        if (bitmap == null) {
            return;
        }
        int childCount = this.D.getChildCount();
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = this.D.getChildAt(i17);
            if (childAt != null && (cVar = (c) childAt.getTag()) != null && !TextUtils.isEmpty(str) && str.equals(cVar.f211295d)) {
                cVar.f211292a.setBackgroundDrawable(new BitmapDrawable(bitmap));
                return;
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onDestroy();
        IFaceDecoder iFaceDecoder = this.E;
        if (iFaceDecoder != null) {
            iFaceDecoder.destory();
        }
    }
}
