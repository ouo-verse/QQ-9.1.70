package com.tencent.mobileqq.matchfriend.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.parser.ax;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.matchfriend.api.GuideBizId;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendDataUtilApi;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi;
import com.tencent.mobileqq.matchfriend.api.IQQStrangerGuideFloatingApi;
import com.tencent.mobileqq.matchfriend.api.IQQStrangerUserInfoMgr;
import com.tencent.mobileqq.matchfriend.api.b;
import com.tencent.mobileqq.matchfriend.bean.QQStrangerUserInfo;
import com.tencent.mobileqq.matchfriend.reborn.api.IQQStrangerEntryApi;
import com.tencent.mobileqq.matchfriend.reborn.content.main.matching.QQStrangerMatchingPart;
import com.tencent.mobileqq.matchfriend.reborn.utils.k;
import com.tencent.mobileqq.matchfriend.reborn.utils.l;
import com.tencent.mobileqq.matchfriend.report.api.IMatchFriendJubaoApi;
import com.tencent.mobileqq.matchfriend.request.MatchFriendRequest;
import com.tencent.mobileqq.matchfriend.voicechat.RoomInfo;
import com.tencent.mobileqq.mini.api.IMiniContainer;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$GetMiniUserInfoReq;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$GetMiniUserInfoRsp;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MatchFriendTestingFragment extends QIphoneTitleBarFragment implements View.OnClickListener {
    private QQStrangerUserInfo C;
    private QQStrangerUserInfo D;
    private String E;
    private QQAppInterface G;
    private String[] F = {"\u7ed3\u4f34\u4e13\u5c5e\u6807\u8bc6\u201c\u4eb2\u5bc6\u7f50\u201d\u4e0a\u7ebf\u5566\u4e0e\u597d\u53cb\u804a\u5929\u5373\u53ef\u89e3\u9501\u548c\u5347\u7ea7"};
    private final com.tencent.relation.common.servlet.c H = new d();

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements Function1<QQStrangerUserInfo, Unit> {
        a() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(QQStrangerUserInfo qQStrangerUserInfo) {
            MatchFriendTestingFragment.this.D = qQStrangerUserInfo;
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class e implements DialogInterface.OnClickListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class f implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ EditText f244079d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f244080e;

        f(EditText editText, int i3) {
            this.f244079d = editText;
            this.f244080e = i3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            String obj = this.f244079d.getText().toString();
            if (TextUtils.isEmpty(obj)) {
                QQToast.makeText(MatchFriendTestingFragment.this.getQBaseActivity(), "\u8f93\u5165\u4e3a\u7a7a", 1).show();
            } else {
                MatchFriendTestingFragment matchFriendTestingFragment = MatchFriendTestingFragment.this;
                matchFriendTestingFragment.vh(matchFriendTestingFragment.G, obj, this.f244080e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class g implements com.tencent.relation.common.servlet.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f244082d;

        g(int i3) {
            this.f244082d = i3;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            if (z16 && obj != null) {
                try {
                    userInfo$GetMiniUserInfoRsp userinfo_getminiuserinforsp = new userInfo$GetMiniUserInfoRsp();
                    userinfo_getminiuserinforsp.mergeFrom((byte[]) obj);
                    if (userinfo_getminiuserinforsp.code.get() == 0) {
                        long j3 = userinfo_getminiuserinforsp.infos.tiny_id.get();
                        String str = userinfo_getminiuserinforsp.infos.open_id.get();
                        String str2 = userinfo_getminiuserinforsp.infos.nick.get();
                        String str3 = userinfo_getminiuserinforsp.infos.avatar.get();
                        QQStrangerUserInfo qQStrangerUserInfo = new QQStrangerUserInfo();
                        qQStrangerUserInfo.tinyId = j3;
                        qQStrangerUserInfo.openId = str;
                        qQStrangerUserInfo.nick = str2;
                        qQStrangerUserInfo.avatar = str3;
                        MatchFriendTestingFragment.this.uh(qQStrangerUserInfo, this.f244082d);
                        return;
                    }
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("MatchFriendTestingFragment", 1, "[getUserBaseInfoTest] error", e16);
                    return;
                }
            }
            QLog.e("MatchFriendTestingFragment", 1, "[getUserBaseInfoTest] isSuccess:" + z16 + ", data:" + obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class h implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MMKVOptionEntityV2 f244084d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f244085e;

        h(MMKVOptionEntityV2 mMKVOptionEntityV2, String str) {
            this.f244084d = mMKVOptionEntityV2;
            this.f244085e = str;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            this.f244084d.putBoolean(this.f244085e, z16);
        }
    }

    private void initViews() {
        ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.omp).setOnClickListener(this);
        ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.oms).setOnClickListener(this);
        ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.omq).setOnClickListener(this);
        ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.omr).setOnClickListener(this);
        ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.oj_).setOnClickListener(this);
        ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.om5).setOnClickListener(this);
        ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.om6).setOnClickListener(this);
        ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f163157om1).setOnClickListener(this);
        ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f163159om3).setOnClickListener(this);
        ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.oma).setOnClickListener(this);
        ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.om_).setOnClickListener(this);
        ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.olw).setOnClickListener(this);
        ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.omb).setOnClickListener(this);
        ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f163145oj4).setOnClickListener(this);
        ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f163144oj3).setOnClickListener(this);
        ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.olx).setOnClickListener(this);
        ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.olu).setOnClickListener(this);
        ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.omf).setOnClickListener(this);
        ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.omc).setOnClickListener(this);
        ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.om9).setOnClickListener(this);
        ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.olv).setOnClickListener(this);
        ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.oly).setOnClickListener(this);
        ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.ojk).setOnClickListener(this);
        ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.omd).setOnClickListener(this);
        ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.ome).setOnClickListener(this);
        ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f163158om2).setOnClickListener(this);
        ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f163160om4).setOnClickListener(this);
        wh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uh(QQStrangerUserInfo qQStrangerUserInfo, int i3) {
        if (i3 == 1) {
            ((IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class)).enterMatchFriendAIO(getQBaseActivity(), qQStrangerUserInfo.tinyId, qQStrangerUserInfo.nick, 3);
            return;
        }
        if (i3 != 2) {
            if (i3 == 3) {
                com.tencent.mobileqq.matchfriend.reborn.utils.h.n(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin(), 104, qQStrangerUserInfo.tinyId, 10395L, 0L);
            }
        } else {
            RoomInfo roomInfo = new RoomInfo(112233, this.C.tinyId, qQStrangerUserInfo.tinyId, new byte[1]);
            roomInfo.f245602m = qQStrangerUserInfo.avatar;
            roomInfo.f245601i = qQStrangerUserInfo.nick;
            roomInfo.D = 30000L;
            ((IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class)).enterVoiceChat(getContext(), roomInfo);
        }
    }

    private void wh() {
        FormSwitchItem formSwitchItem = (FormSwitchItem) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f163138oi2);
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(BaseApplication.getContext(), "common_mmkv_configurations");
        formSwitchItem.setChecked(fromV2.getBoolean("qq_stranger_debug_admin_switch", false));
        formSwitchItem.setOnCheckedChangeListener(new h(fromV2, "qq_stranger_debug_admin_switch"));
    }

    private void xh(int i3) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getQBaseActivity());
        LinearLayout linearLayout = new LinearLayout(getQBaseActivity());
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(300, 300));
        EditText editText = new EditText(getQBaseActivity());
        editText.setLayoutParams(new ViewGroup.LayoutParams(400, 80));
        editText.setText("");
        linearLayout.addView(editText);
        builder.setView(linearLayout);
        builder.setTitle("\u8bf7\u8f93\u5165\u9700\u8981\u5339\u914d\u5bf9\u8c61\u7684QQ\u53f7");
        builder.setPositiveButton("\u786e\u8ba4", new f(editText, i3)).setNegativeButton("\u53d6\u6d88", new e());
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        setTitle("\u7ed3\u4f34\u8c03\u8bd5\u9875");
        initViews();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.cwd;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (i3 == 1000) {
            if (i16 == -1) {
                QQToast.makeText(getContext(), 2, "\u6ce8\u518c\u6210\u529f", 0).show();
            } else {
                QQToast.makeText(getContext(), 0, "\u6ce8\u518c\u53d6\u6d88/\u5931\u8d25", 0).show();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id5 = view.getId();
        if (id5 == R.id.oj_) {
            xh(3);
            return;
        }
        if (id5 == R.id.ojk) {
            QPublicFragmentActivity.start(getContext(), QQStrangerCoupleDebugFragment.class);
            return;
        }
        if (id5 != R.id.olu) {
            switch (id5) {
                case R.id.f163144oj3 /* 1829044265 */:
                    ((IQQStrangerGuideFloatingApi) QRoute.api(IQQStrangerGuideFloatingApi.class)).showHalfFloatingView(getContext(), new b.C8005b(GuideBizId.ID_INTERACTIVE_MARK, this.F, new String[]{"https://static-res.qq.com/static-res/devinsu/matchFriend/match_friend.pag", "https://static-res.qq.com/static-res/devinsu/matchFriend/match_friend.pag", "https://static-res.qq.com/static-res/devinsu/matchFriend/match_friend.pag"}, "\u53bb\u804a\u5929", new c()));
                    return;
                case R.id.f163145oj4 /* 1829044266 */:
                    ((IQQStrangerGuideFloatingApi) QRoute.api(IQQStrangerGuideFloatingApi.class)).showHalfFloatingView(getContext(), new b.a(GuideBizId.ID_INTERACTIVE_MARK, this.F, new String[]{"https://downv6.qq.com/innovate/guild/demo/banner1.png", "https://downv6.qq.com/innovate/guild/demo/banner2.png", "https://downv6.qq.com/innovate/guild/demo/banner3.png"}, "\u53bb\u804a\u5929", new b()));
                    return;
                default:
                    switch (id5) {
                        case R.id.olw /* 1829044369 */:
                            if (this.D == null) {
                                QQToast.makeText(getContext(), 1, "\u4e2a\u4eba\u4fe1\u606f\u83b7\u53d6\u5931\u8d25", 0).show();
                                return;
                            }
                            IMatchFriendEntryApi iMatchFriendEntryApi = (IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class);
                            Context context = getContext();
                            QQStrangerUserInfo qQStrangerUserInfo = this.D;
                            iMatchFriendEntryApi.enterMatchFriendAIO(context, qQStrangerUserInfo.tinyId, qQStrangerUserInfo.nick, 3);
                            return;
                        case R.id.olx /* 1829044370 */:
                            String matchFriendAppName = ((IMatchFriendDataUtilApi) QRoute.api(IMatchFriendDataUtilApi.class)).matchFriendAppName(this.G);
                            QQToast.makeText(getContext(), 2, matchFriendAppName, 0).show();
                            QLog.d("MatchFriendTestingFragment", 1, "matchfriend name is " + matchFriendAppName);
                            return;
                        case R.id.oly /* 1829044371 */:
                            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
                            k kVar = k.f245485a;
                            from.encodeInt(kVar.d("qqstranger_nearby_entry_show_times"), 0);
                            QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeLong(kVar.d("qqstranger_nearby_entry_last_show_time"), 0L);
                            kVar.l(false);
                            return;
                        default:
                            switch (id5) {
                                case R.id.f163157om1 /* 1829044374 */:
                                    if (this.D == null) {
                                        QQToast.makeText(getContext(), 1, "\u4e2a\u4eba\u4fe1\u606f\u83b7\u53d6\u5931\u8d25", 0).show();
                                        return;
                                    } else {
                                        ((IMatchFriendJubaoApi) QRoute.api(IMatchFriendJubaoApi.class)).startMatchFriendJubaoByScene(this.G, getQBaseActivity(), IMatchFriendJubaoApi.From.PROFILE_CARD, String.valueOf(this.D.tinyId), null, null);
                                        return;
                                    }
                                case R.id.f163158om2 /* 1829044375 */:
                                    ((IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class)).enterLittleAssistantAIO(getContext());
                                    return;
                                case R.id.f163159om3 /* 1829044376 */:
                                    ((IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class)).enterMatchPage(getQBaseActivity(), this.G, com.tencent.mobileqq.matchfriend.data.a.a().e(0));
                                    return;
                                case R.id.f163160om4 /* 1829044377 */:
                                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                                    if (peekAppRuntime instanceof BaseQQAppInterface) {
                                        QQStrangerMatchingPart.INSTANCE.f(true);
                                        ax.d((BaseQQAppInterface) peekAppRuntime, getContext(), "mqqapi://qqstranger/immediate_match").b();
                                        return;
                                    }
                                    return;
                                case R.id.om5 /* 1829044378 */:
                                    ((IMiniContainer) QRoute.api(IMiniContainer.class)).launchPage(getContext(), "pages-matchfriend/chat-list/chat-list.html");
                                    return;
                                case R.id.om6 /* 1829044379 */:
                                    ((IMiniContainer) QRoute.api(IMiniContainer.class)).launchPage(getContext(), "pages-matchfriend/chat-setting/chat-setting.html");
                                    return;
                                default:
                                    switch (id5) {
                                        case R.id.om9 /* 1829044382 */:
                                            ((IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class)).enterOfficialAccount(getQBaseActivity());
                                            return;
                                        case R.id.om_ /* 1829044383 */:
                                            if (this.C == null) {
                                                QQToast.makeText(getContext(), 1, "\u4e2a\u4eba\u4fe1\u606f\u83b7\u53d6\u5931\u8d25", 0).show();
                                                return;
                                            } else {
                                                ((IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class)).enterProfileCard(getContext(), this.C.openId, 3);
                                                return;
                                            }
                                        case R.id.oma /* 1829044384 */:
                                            if (this.D == null) {
                                                QQToast.makeText(getContext(), 1, "\u4e2a\u4eba\u4fe1\u606f\u83b7\u53d6\u5931\u8d25", 0).show();
                                                return;
                                            } else {
                                                ((IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class)).enterProfileCard(getContext(), this.D.openId, 3);
                                                return;
                                            }
                                        case R.id.omb /* 1829044385 */:
                                            xh(1);
                                            return;
                                        case R.id.omc /* 1829044386 */:
                                            xh(2);
                                            return;
                                        case R.id.omd /* 1829044387 */:
                                            ((IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class)).enterSignalSquare(getContext());
                                            return;
                                        case R.id.ome /* 1829044388 */:
                                            ((IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class)).openSignalPublisher(getContext(), false);
                                            return;
                                        case R.id.omf /* 1829044389 */:
                                            if (this.C != null && this.D != null) {
                                                RoomInfo roomInfo = new RoomInfo(112233, this.C.tinyId, this.D.tinyId, new byte[1]);
                                                QQStrangerUserInfo qQStrangerUserInfo2 = this.D;
                                                roomInfo.f245602m = qQStrangerUserInfo2.avatar;
                                                roomInfo.f245601i = qQStrangerUserInfo2.nick;
                                                roomInfo.D = 30000L;
                                                ((IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class)).enterVoiceChat(getContext(), roomInfo);
                                                return;
                                            }
                                            QQToast.makeText(getContext(), 1, "\u4e2a\u4eba\u4fe1\u606f\u83b7\u53d6\u5931\u8d25", 0).show();
                                            return;
                                        default:
                                            switch (id5) {
                                                case R.id.omp /* 1829044399 */:
                                                    ((IQQStrangerEntryApi) QRoute.api(IQQStrangerEntryApi.class)).enterHomePage(getQBaseActivity(), 0, 0);
                                                    return;
                                                case R.id.omq /* 1829044400 */:
                                                    l.d(getQBaseActivity(), 0, 0);
                                                    return;
                                                case R.id.omr /* 1829044401 */:
                                                    l.f(getQBaseActivity(), com.tencent.mobileqq.matchfriend.utils.b.d().j(), new Intent());
                                                    return;
                                                case R.id.oms /* 1829044402 */:
                                                    Intent intent = new Intent();
                                                    intent.putExtra("key_open_id", com.tencent.mobileqq.matchfriend.utils.b.d().j());
                                                    intent.putExtra("key_is_new_user", false);
                                                    com.tencent.mobileqq.matchfriend.reborn.config.c.g();
                                                    ((IQQStrangerEntryApi) QRoute.api(IQQStrangerEntryApi.class)).startRegisterForResult(getQBaseActivity(), intent);
                                                    return;
                                                default:
                                                    return;
                                            }
                                    }
                            }
                    }
            }
        }
        if (this.C != null && this.D != null) {
            ((IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class)).launchAddFriend(getContext(), String.valueOf(this.D.tinyId), this.D.nick, 3);
        } else {
            QQToast.makeText(getContext(), 1, "\u4e2a\u4eba\u4fe1\u606f\u83b7\u53d6\u5931\u8d25", 0).show();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        QQAppInterface qQAppInterface = (QQAppInterface) getQBaseActivity().getAppRuntime();
        this.G = qQAppInterface;
        MatchFriendRequest.L(qQAppInterface, this.H);
        this.E = "F47601B9B778606271951FA041CCBB49";
        ((IQQStrangerUserInfoMgr) this.G.getRuntimeService(IQQStrangerUserInfoMgr.class, "all")).reqUserInfo(new com.tencent.mobileqq.matchfriend.bean.c(104, 0L, this.E), new a());
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class d implements com.tencent.relation.common.servlet.c {

        /* compiled from: P */
        /* loaded from: classes33.dex */
        class a implements Function1<QQStrangerUserInfo, Unit> {
            a() {
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unit invoke(QQStrangerUserInfo qQStrangerUserInfo) {
                MatchFriendTestingFragment.this.C = qQStrangerUserInfo;
                return null;
            }
        }

        d() {
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            if (z16) {
                String string = bundle.getString("key_open_id");
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                ((IQQStrangerUserInfoMgr) MatchFriendTestingFragment.this.G.getRuntimeService(IQQStrangerUserInfoMgr.class)).reqUserInfo(new com.tencent.mobileqq.matchfriend.bean.c(104, 0L, string), new a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vh(AppInterface appInterface, String str, int i3) {
        if (appInterface == null) {
            QLog.e("MatchFriendTestingFragment", 1, "[getUserBaseInfoTest] app is null");
            return;
        }
        userInfo$GetMiniUserInfoReq userinfo_getminiuserinforeq = new userInfo$GetMiniUserInfoReq();
        userinfo_getminiuserinforeq.account_id.set(str);
        userinfo_getminiuserinforeq.account_type.set(1);
        userinfo_getminiuserinforeq.mini_info_ids.add(2);
        userinfo_getminiuserinforeq.mini_info_ids.add(1);
        userinfo_getminiuserinforeq.mini_info_ids.add(24);
        ((com.tencent.relation.common.servlet.a) appInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4)).Z0("QQStranger.UserInfo.SsoGetMiniUserInfo", userinfo_getminiuserinforeq.toByteArray(), new g(i3));
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class b implements com.tencent.mobileqq.matchfriend.api.c {
        b() {
        }

        @Override // com.tencent.mobileqq.matchfriend.api.c
        public void a() {
            QQToast.makeText(MatchFriendTestingFragment.this.getContext(), "\u70b9\u51fb\u4e86\u201c\u53bb\u804a\u5929\u201d", 0).show();
        }

        @Override // com.tencent.mobileqq.matchfriend.api.c
        public void onDismiss() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class c implements com.tencent.mobileqq.matchfriend.api.c {
        c() {
        }

        @Override // com.tencent.mobileqq.matchfriend.api.c
        public void a() {
            QQToast.makeText(MatchFriendTestingFragment.this.getContext(), "\u70b9\u51fb\u4e86\u201c\u53bb\u804a\u5929\u201d", 0).show();
        }

        @Override // com.tencent.mobileqq.matchfriend.api.c
        public void onDismiss() {
        }
    }
}
