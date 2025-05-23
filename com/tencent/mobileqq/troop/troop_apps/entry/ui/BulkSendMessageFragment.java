package com.tencent.mobileqq.troop.troop_apps.entry.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.biz.o;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.troop.TroopMemberNickInfo;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.troop_apps.entry.ui.BulkSendMessageFragment;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAppService;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.utils.eu;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.MyGridView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import tencent.im.troop.homework$ReqSend1V1Msg;
import tencent.im.troop.homework$RspSend1V1Msg;

/* compiled from: P */
/* loaded from: classes19.dex */
public class BulkSendMessageFragment extends IphoneTitleBarFragment implements DecodeTaskCompletionListener, View.OnClickListener, TextWatcher, o.a {
    static IPatchRedirector $redirector_;
    protected f C;
    protected List<String> D;
    protected String E;
    protected QQAppInterface F;
    protected IFaceDecoder G;
    protected int H;
    protected MyGridView I;
    protected ClearableEditText J;
    protected Button K;
    protected View L;
    protected TextView M;
    protected TextView N;
    protected UIUtils.b P;
    public o Q;
    public View R;
    public Handler S;
    public Runnable T;
    private com.tencent.mobileqq.troop.homework.observer.a U;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a extends com.tencent.mobileqq.troop.homework.observer.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BulkSendMessageFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.homework.observer.a
        protected void b(boolean z16, homework$RspSend1V1Msg homework_rspsend1v1msg, homework$ReqSend1V1Msg homework_reqsend1v1msg) {
            String d16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), homework_rspsend1v1msg, homework_reqsend1v1msg);
                return;
            }
            if (QLog.isColorLevel()) {
                Object[] objArr = new Object[4];
                objArr[0] = "Receive response succ=";
                objArr[1] = Boolean.valueOf(z16);
                objArr[2] = "resp: ";
                if (homework_rspsend1v1msg == null) {
                    d16 = "null";
                } else {
                    d16 = com.tencent.biz.qqstory.utils.g.d(homework_rspsend1v1msg);
                }
                objArr[3] = d16;
                QLog.d(".troop.troop_app.BulkSendMessageFragment", 2, objArr);
            }
            UIUtils.b bVar = BulkSendMessageFragment.this.P;
            if (bVar != null) {
                bVar.a();
                BulkSendMessageFragment.this.P = null;
            }
            BaseActivity baseActivity = BulkSendMessageFragment.this.getBaseActivity();
            if (baseActivity == null) {
                QLog.e(".troop.troop_app.BulkSendMessageFragment", 2, "onBulkSendMessage() Error: getActivity == null");
                return;
            }
            if (homework_rspsend1v1msg == null) {
                QQToast.makeText(baseActivity, 1, HardCodeUtil.qqStr(R.string.k4f), 1).show();
                return;
            }
            if (homework_rspsend1v1msg.result.error_code.get() != 0) {
                QQToast.makeText(baseActivity, 1, homework_rspsend1v1msg.result.error_desc.get().toStringUtf8(), 1).show();
                return;
            }
            QQToast.makeText(baseActivity, 2, HardCodeUtil.qqStr(R.string.k4b), 1).show();
            baseActivity.finish();
            baseActivity.overridePendingTransition(0, R.anim.f154458a7);
            MqqHandler handler = BulkSendMessageFragment.this.F.getHandler(Conversation.class);
            if (handler != null) {
                handler.sendEmptyMessage(1009);
            }
            BulkSendMessageFragment bulkSendMessageFragment = BulkSendMessageFragment.this;
            eu.g("Grp_edu", "MassMessage", "CreateMessage_Send", 0, 0, BulkSendMessageFragment.this.E, eu.d(bulkSendMessageFragment.F, bulkSendMessageFragment.E), homework_reqsend1v1msg.text.get().toStringUtf8(), String.valueOf(homework_reqsend1v1msg.to_uins.size()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BulkSendMessageFragment.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            boolean canScrollVertically = BulkSendMessageFragment.this.J.canScrollVertically(-1);
            boolean canScrollVertically2 = BulkSendMessageFragment.this.J.canScrollVertically(1);
            if (view.isFocused() && (canScrollVertically || canScrollVertically2)) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                if ((motionEvent.getAction() & 255) == 1) {
                    view.getParent().requestDisallowInterceptTouchEvent(false);
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class c implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BulkSendMessageFragment.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class d implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BulkSendMessageFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                BulkSendMessageFragment.this.showActionSheet();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class e implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f299259d;

        e(ActionSheet actionSheet) {
            this.f299259d = actionSheet;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BulkSendMessageFragment.this, (Object) actionSheet);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            if (i3 < BulkSendMessageFragment.this.D.size()) {
                BulkSendMessageFragment.this.J.setText(BulkSendMessageFragment.this.D.get(i3));
            }
            this.f299259d.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class f extends BaseAdapter implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public boolean f299261d;

        /* renamed from: e, reason: collision with root package name */
        public ArrayList<String> f299262e;

        public f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BulkSendMessageFragment.this);
            } else {
                this.f299261d = true;
                this.f299262e = new ArrayList<>();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit b(String str, TextView textView, QQProAvatarView qQProAvatarView, g gVar, TroopMemberNickInfo troopMemberNickInfo) {
            String str2;
            if (troopMemberNickInfo != null) {
                str2 = troopMemberNickInfo.getShowName();
            } else {
                str2 = str;
            }
            if (TextUtils.isEmpty(str)) {
                if (str2 == null) {
                    str2 = "";
                }
                textView.setText(str2);
                qQProAvatarView.setImageDrawable(BaseImageUtil.getDefaultFaceDrawable());
            } else {
                if (TextUtils.isEmpty(str2)) {
                    if (((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), ".troop.troop_app.BulkSendMessageFragment")) {
                        str2 = ac.F(BulkSendMessageFragment.this.F, str);
                    }
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = HardCodeUtil.qqStr(R.string.k4g);
                }
                textView.setText(str2);
                gVar.f299264a.x(1, gVar.f299266c, null);
                qQProAvatarView.setTag(R.id.jay, str);
                qQProAvatarView.setTag(null);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.f299262e.size() + (this.f299261d ? 1 : 0);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
            return Integer.valueOf(this.f299262e.size());
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Long) iPatchRedirector.redirect((short) 5, (Object) this, i3)).longValue();
            }
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            g gVar;
            View view2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                view2 = (View) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), view, viewGroup);
            } else {
                if (view == null) {
                    View inflate = LayoutInflater.from(BulkSendMessageFragment.this.getBaseActivity()).inflate(R.layout.f167752g4, (ViewGroup) null);
                    gVar = new g(inflate);
                    gVar.f299264a = (QQProAvatarView) inflate.findViewById(R.id.icon);
                    gVar.f299265b = (TextView) inflate.findViewById(R.id.f5e);
                    inflate.setTag(gVar);
                    view2 = inflate;
                } else {
                    gVar = (g) view.getTag();
                    view2 = view;
                }
                final g gVar2 = gVar;
                view2.setVisibility(0);
                view2.setFocusable(false);
                final TextView textView = gVar2.f299265b;
                final QQProAvatarView qQProAvatarView = gVar2.f299264a;
                if (i3 < this.f299262e.size()) {
                    qQProAvatarView.setImageResource(R.drawable.abe);
                    textView.setTextColor(BulkSendMessageFragment.this.getResources().getColor(R.color.skin_gray_group_item));
                    final String str = this.f299262e.get(i3) + "";
                    gVar2.f299266c = str;
                    ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberName(BulkSendMessageFragment.this.E, str, ".troop.troop_app.BulkSendMessageFragment", new Function1() { // from class: com.tencent.mobileqq.troop.troop_apps.entry.ui.a
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit b16;
                            b16 = BulkSendMessageFragment.f.this.b(str, textView, qQProAvatarView, gVar2, (TroopMemberNickInfo) obj);
                            return b16;
                        }
                    });
                    gVar2.f299267d.setTag(R.id.jab, null);
                    gVar2.f299267d.setOnClickListener(null);
                } else {
                    textView.setText(BulkSendMessageFragment.this.getString(R.string.f170028dd));
                    textView.setTextColor(BulkSendMessageFragment.this.getResources().getColorStateList(R.color.a2o));
                    qQProAvatarView.setBackgroundDrawable(null);
                    qQProAvatarView.setImageResource(R.drawable.f160463hm);
                    qQProAvatarView.setEnabled(true);
                    qQProAvatarView.setTag(0);
                    gVar2.f299267d.setTag(R.id.jab, 0);
                    gVar2.f299267d.setOnClickListener(this);
                }
                if (AppSetting.f99565y) {
                    ViewCompat.setImportantForAccessibility(qQProAvatarView, 2);
                }
            }
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view2;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                super.notifyDataSetChanged();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
            } else {
                Integer num = (Integer) view.getTag(R.id.jab);
                if (num != null && num.intValue() == 0) {
                    Intent intent = new Intent();
                    intent.putExtra("troop_uin", BulkSendMessageFragment.this.E);
                    intent.putExtra(ISelectMemberActivityConstants.PARAM_FROM, 20);
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.add(BulkSendMessageFragment.this.F.getCurrentAccountUin());
                    intent.putStringArrayListExtra("param_pick_selected_list", BulkSendMessageFragment.this.C.f299262e);
                    intent.putStringArrayListExtra("param_hide_filter_member_list", arrayList);
                    intent.putExtra("param_pick_max_num", BulkSendMessageFragment.this.H);
                    intent.putExtra("param_pick_max_num_exceeds_wording", R.string.f171401er1);
                    intent.putExtra("param_pick_title_string", HardCodeUtil.qqStr(R.string.k4_));
                    RouteUtils.startActivityForResult(BulkSendMessageFragment.this.getActivity(), intent, "/troop/memberlist/TroopMemberList", 1);
                    BulkSendMessageFragment.this.getBaseActivity().overridePendingTransition(R.anim.f155030h6, R.anim.f154442w);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class g {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        QQProAvatarView f299264a;

        /* renamed from: b, reason: collision with root package name */
        TextView f299265b;

        /* renamed from: c, reason: collision with root package name */
        String f299266c;

        /* renamed from: d, reason: collision with root package name */
        public View f299267d;

        public g(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            } else {
                this.f299267d = view;
            }
        }
    }

    public BulkSendMessageFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.C = new f();
        this.D = new ArrayList();
        this.E = "";
        this.H = 10;
        this.T = new Runnable() { // from class: com.tencent.mobileqq.troop.troop_apps.entry.ui.BulkSendMessageFragment.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BulkSendMessageFragment.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    BulkSendMessageFragment.this.R.setVisibility(0);
                }
            }
        };
        this.U = new a();
    }

    private void initUI() {
        ClearableEditText clearableEditText = (ClearableEditText) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.btb);
        this.J = clearableEditText;
        clearableEditText.setClearButtonStyle(1);
        ViewGroup.LayoutParams layoutParams = this.J.getLayoutParams();
        this.J.setSingleLine(false);
        this.J.setFilters(new InputFilter[]{new InputFilter.LengthFilter(300)});
        int length = this.J.getText().length();
        this.J.setSelection(length, length);
        this.J.setGravity(48);
        this.J.addTextChangedListener(this);
        if (layoutParams != null) {
            layoutParams.height = (int) (this.mDensity * 150.0f);
            this.J.setLayoutParams(layoutParams);
        }
        this.J.setHint(HardCodeUtil.qqStr(R.string.k4e));
        this.J.setOnTouchListener(new b());
        ((IphoneTitleBarFragment) this).mContentView.setOnTouchListener(new c());
        View findViewById = ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.agz);
        this.L = findViewById;
        findViewById.setOnClickListener(this);
        this.M = (TextView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.kdp);
        MyGridView myGridView = (MyGridView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.kl5);
        this.I = myGridView;
        myGridView.setAdapter((ListAdapter) this.C);
        Button button = (Button) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.ajw);
        this.K = button;
        button.setText(HardCodeUtil.qqStr(R.string.k4m));
        this.K.setOnClickListener(this);
        this.K.setEnabled(false);
        this.R = ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.e5j);
        ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.ajz).setOnClickListener(this);
        this.N = (TextView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f167067ke3);
        if (this.D.size() == 0) {
            ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f166874it4).setVisibility(8);
        } else {
            ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f166874it4).setOnClickListener(new d());
        }
        setTitle(HardCodeUtil.qqStr(R.string.k49));
        sh();
        rh();
        eu.g("Grp_edu", "MassMessage", "CreateMessage_Show", 0, 0, this.E, eu.d(this.F, this.E));
    }

    private void rh() {
        ColorStateList colorStateList;
        int length = this.J.getText().length();
        if (length > 300) {
            colorStateList = getResources().getColorStateList(R.color.skin_red);
        } else {
            colorStateList = getResources().getColorStateList(R.color.skin_gray3);
        }
        String str = length + "/300";
        if (colorStateList != null) {
            this.N.setTextColor(colorStateList);
        }
        this.N.setText(str);
    }

    private void sh() {
        boolean z16;
        boolean z17;
        boolean z18;
        int i3;
        int length = this.J.length();
        int size = this.C.f299262e.size();
        boolean z19 = true;
        if (size > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (length >= 1 && length <= 300 && z16) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (size > 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        this.M.setText(String.format(Locale.getDefault(), "\uff08%d\u4e2a\uff09", Integer.valueOf(size)));
        TextView textView = this.M;
        int i16 = 8;
        if (z18) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        textView.setVisibility(i3);
        this.K.setEnabled(z17);
        this.K.setClickable(z17);
        View view = this.L;
        if (z16) {
            i16 = 0;
        }
        view.setVisibility(i16);
        f fVar = this.C;
        if (fVar.f299262e.size() >= this.H) {
            z19 = false;
        }
        fVar.f299261d = z19;
        this.C.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showActionSheet() {
        List<String> list = this.D;
        if (list != null && list.size() != 0) {
            ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(getBaseActivity(), null);
            Iterator<String> it = this.D.iterator();
            while (it.hasNext()) {
                actionSheet.addButton(it.next());
            }
            actionSheet.addCancelButton(R.string.cancel);
            actionSheet.setOnButtonClickListener(new e(actionSheet));
            actionSheet.show();
        }
    }

    public static void th(Activity activity, @Nullable Bundle bundle) {
        Intent intent = new Intent();
        if (bundle == null) {
            bundle = new Bundle();
        }
        intent.putExtras(bundle);
        PublicFragmentActivity.start(activity, intent, BulkSendMessageFragment.class);
        activity.overridePendingTransition(R.anim.f155030h6, R.anim.f154442w);
    }

    @Override // com.tencent.biz.o.a
    public void N1(boolean z16, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16));
        } else if (z16) {
            this.S.removeCallbacks(this.T);
            this.R.setVisibility(8);
        } else {
            this.S.postDelayed(this.T, 10L);
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) editable);
        } else {
            sh();
            rh();
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, layoutInflater, viewGroup, bundle);
            return;
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        this.E = getBaseActivity().getIntent().getStringExtra("extra.GROUP_UIN");
        QQAppInterface g16 = QQStoryContext.g();
        this.F = g16;
        IFaceDecoder iQQAvatarService = ((IQQAvatarService) g16.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.F);
        this.G = iQQAvatarService;
        iQQAvatarService.setDecodeTaskCompletionListener(this);
        this.S = new Handler();
        JSONObject appConfig = ((ITroopAppService) this.F.getRuntimeService(ITroopAppService.class, "all")).getAppConfig("BulkChatMessageConfig");
        if (QLog.isColorLevel()) {
            QLog.d(".troop.troop_app.BulkSendMessageFragment.VASH", 2, "ReadConfig: ", String.valueOf(appConfig));
        }
        if (appConfig != null) {
            this.H = appConfig.optInt("user_limit", this.H);
            appConfig.optJSONArray("hints");
        }
        initUI();
        this.F.addObserver(this.U);
        this.Q = new o(((IphoneTitleBarFragment) this).mContentView, this, ImmersiveUtils.getStatusBarHeight(getBaseActivity()) + 160);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return R.layout.ahf;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.onActivityResult(i3, i16, intent);
        if (i3 != 0) {
            if (i3 == 1 || i3 == 2) {
                if (i16 == -1 && intent != null) {
                    ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("extra_member_uin_list");
                    if (QLog.isColorLevel()) {
                        Iterator<String> it = stringArrayListExtra.iterator();
                        while (it.hasNext()) {
                            QLog.d(".troop.troop_app.BulkSendMessageFragment.VASH", 2, "select uin: ", it.next());
                        }
                    }
                    int size = this.C.f299262e.size() - stringArrayListExtra.size();
                    if (i3 == 2 && size != 0) {
                        eu.g("Grp_edu", "MassMessage", "MemberEdit_Complete", 0, 0, this.E, eu.d(this.F, this.E), String.valueOf(size));
                    }
                    this.C.f299262e = new ArrayList<>(stringArrayListExtra);
                    this.C.notifyDataSetChanged();
                    sh();
                    return;
                }
                if (i16 == 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d(".troop.troop_app.BulkSendMessageFragment", 1, "SelectMember canceled! requestCode: ", Integer.valueOf(i3), new NullPointerException());
                        return;
                    }
                    return;
                } else {
                    QLog.e(".troop.troop_app.BulkSendMessageFragment", 1, "Error! SelectMember return null! requestCode: " + i3, new NullPointerException());
                    return;
                }
            }
            return;
        }
        if (i16 == -1 && intent != null) {
            ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(ISelectMemberActivityConstants.PARAM_RESULT_SET);
            if (QLog.isColorLevel()) {
                Iterator it5 = parcelableArrayListExtra.iterator();
                while (it5.hasNext()) {
                    QLog.d(".troop.troop_app.BulkSendMessageFragment.VASH", 2, "select uin: ", ((ResultRecord) it5.next()).uin);
                }
                return;
            }
            return;
        }
        QLog.e(".troop.troop_app.BulkSendMessageFragment", 1, "Error! SelectMember return null!", new NullPointerException());
    }

    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        boolean onBackEvent = super.onBackEvent();
        getBaseActivity().overridePendingTransition(0, R.anim.f154458a7);
        return onBackEvent;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.agz) {
                Intent intent = new Intent();
                intent.putExtra("troop_uin", this.E);
                intent.putExtra(ISelectMemberActivityConstants.PARAM_FROM, 21);
                intent.putStringArrayListExtra("param_pick_selected_list", this.C.f299262e);
                intent.putStringArrayListExtra("param_delete_filter_member_list", this.C.f299262e);
                intent.putExtra("param_pick_max_num", this.H);
                intent.putExtra("param_pick_title_string", HardCodeUtil.qqStr(R.string.k4j));
                RouteUtils.startActivityForResult(getActivity(), intent, "/troop/memberlist/TroopMemberList", 2);
                getBaseActivity().overridePendingTransition(R.anim.f155030h6, R.anim.f154442w);
                eu.g("Grp_edu", "MassMessage", "Member_Edit", 0, 0, this.E);
            } else if (id5 == R.id.ajw) {
                String obj = this.J.getText().toString();
                if (obj.length() < 4) {
                    QQToast.makeText(getBaseActivity(), 1, String.format(Locale.getDefault(), HardCodeUtil.qqStr(R.string.k4d), 4), 1).show();
                } else if (!NetworkUtil.isNetworkAvailable(getBaseActivity())) {
                    QQToast.makeText(getBaseActivity(), 1, String.format(Locale.getDefault(), HardCodeUtil.qqStr(R.string.k4h), new Object[0]), 1).show();
                } else {
                    try {
                        homework$ReqSend1V1Msg homework_reqsend1v1msg = new homework$ReqSend1V1Msg();
                        int offset = TimeZone.getDefault().getOffset(System.currentTimeMillis()) / 1000;
                        Iterator<String> it = this.C.f299262e.iterator();
                        while (it.hasNext()) {
                            homework_reqsend1v1msg.to_uins.add(Long.valueOf(Long.parseLong(it.next())));
                        }
                        homework_reqsend1v1msg.text.set(ByteStringMicro.copyFromUtf8(obj));
                        homework_reqsend1v1msg.int32_time_zone.set(offset);
                        homework_reqsend1v1msg.group_id.set(Long.parseLong(this.E));
                        UIUtils.b bVar = this.P;
                        if (bVar != null) {
                            bVar.a();
                            this.P = null;
                        }
                        this.P = UIUtils.u(getBaseActivity(), HardCodeUtil.qqStr(R.string.k4l));
                        ((com.tencent.mobileqq.troop.homework.b) this.F.getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopHomeworkHandlerName())).L(homework_reqsend1v1msg);
                    } catch (NumberFormatException unused) {
                        QQToast.makeText(getBaseActivity(), 1, HardCodeUtil.qqStr(R.string.k4k), 1).show();
                    }
                }
            } else if (id5 == R.id.ajz) {
                if (this.J.length() == 0) {
                    QQToast.makeText(getBaseActivity(), 1, String.format(Locale.getDefault(), HardCodeUtil.qqStr(R.string.k4c), new Object[0]), 1).show();
                } else if (this.J.length() < 4) {
                    QQToast.makeText(getBaseActivity(), 1, String.format(Locale.getDefault(), HardCodeUtil.qqStr(R.string.k4a), 4), 1).show();
                } else if (this.C.f299262e.isEmpty()) {
                    QQToast.makeText(getBaseActivity(), 1, String.format(Locale.getDefault(), HardCodeUtil.qqStr(R.string.k4i), new Object[0]), 1).show();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bitmap);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onDestroyView();
        this.F.removeObserver(this.U);
        this.G.setDecodeTaskCompletionListener(null);
        this.J.removeTextChangedListener(this);
        this.Q.a();
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }
}
