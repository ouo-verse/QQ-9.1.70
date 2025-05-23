package com.tencent.mobileqq.gamecenter.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.gamecenter.api.IGameCenterFriendApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.protocols.a;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameFriendSelectorSvr$Friend;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameFriendSelectorSvr$GetFriendsReq;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameFriendSelectorSvr$GetFriendsRsp;
import com.tencent.mobileqq.gamecenter.ui.i;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchGameFriendApi;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.SelectedAndSearchBar;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.UiThreadUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ForwardGameFriendFragment extends QPublicBaseFragment {
    private i C;
    private GameFriendSelectorSvr$GetFriendsRsp E;
    private SelectedAndSearchBar G;
    private FrameLayout H;
    private Fragment I;
    private final com.tencent.mobileqq.gamecenter.protocols.a D = new com.tencent.mobileqq.gamecenter.protocols.a();
    private String F = null;
    private SelectedAndSearchBar.i J = new a();
    private com.tencent.mobileqq.search.model.u K = new b();

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b implements com.tencent.mobileqq.search.model.u {
        b() {
        }

        @Override // com.tencent.mobileqq.search.model.u
        public void a(GameFriendSelectorSvr$Friend gameFriendSelectorSvr$Friend) {
            QLog.i("gameFriInfo.ForwardGameFriendFragment", 2, "[onGameFriendSelected]");
            ForwardGameFriendFragment.this.Nh(((IGameCenterFriendApi) QRoute.api(IGameCenterFriendApi.class)).getSenderID(), gameFriendSelectorSvr$Friend);
        }
    }

    private String Bh() {
        GameFriendSelectorSvr$GetFriendsRsp gameFriendSelectorSvr$GetFriendsRsp = this.E;
        if (gameFriendSelectorSvr$GetFriendsRsp != null) {
            return gameFriendSelectorSvr$GetFriendsRsp.f213220id.get();
        }
        return ((IGameCenterFriendApi) QRoute.api(IGameCenterFriendApi.class)).getSenderID();
    }

    private void Ch(final long j3) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.ui.f
            @Override // java.lang.Runnable
            public final void run() {
                ForwardGameFriendFragment.this.Gh(j3);
            }
        });
    }

    private void Dh(GameFriendSelectorSvr$GetFriendsRsp gameFriendSelectorSvr$GetFriendsRsp) {
        this.E = gameFriendSelectorSvr$GetFriendsRsp;
        final List<GameFriendSelectorSvr$Friend> list = gameFriendSelectorSvr$GetFriendsRsp.friends.get();
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.ui.g
            @Override // java.lang.Runnable
            public final void run() {
                ForwardGameFriendFragment.this.Hh(list);
            }
        });
    }

    private void Eh(View view) {
        if (getContext() != null) {
            this.C = new i(getContext(), new i.b() { // from class: com.tencent.mobileqq.gamecenter.ui.c
                @Override // com.tencent.mobileqq.gamecenter.ui.i.b
                public final void a(GameFriendSelectorSvr$Friend gameFriendSelectorSvr$Friend) {
                    ForwardGameFriendFragment.this.Mh(gameFriendSelectorSvr$Friend);
                }
            });
        }
        ((RecyclerView) view.findViewById(R.id.f789748i)).setAdapter(this.C);
    }

    private void Fh(View view) {
        int i3;
        View findViewById = view.findViewById(R.id.f223103d);
        if (QQTheme.isNowThemeIsNight()) {
            i3 = -16777216;
        } else {
            i3 = -1;
        }
        findViewById.setBackgroundColor(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Gh(long j3) {
        if (getContext() != null) {
            QQToast.makeText(getContext(), 1, getContext().getString(R.string.f1373406l, Long.valueOf(j3)), 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Hh(List list) {
        if (!list.isEmpty()) {
            this.C.setData(list);
        } else if (getContext() != null) {
            QQToast.makeText(getContext(), 1, getContext().getString(R.string.f1373306k), 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ih(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        onBackEvent();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Jh(int i3, String str, int i16, String str2) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("ext4", "20");
        hashMap.put("ext2", String.valueOf(i3));
        hashMap.put("ext5", str);
        hashMap.put("ext6", String.valueOf(i16));
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(str2, "1", "1041", "9249", "924902", "912971", "", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Kh(String str, String str2) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("ext4", "8");
        hashMap.put("ext5", str);
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(str2, "1", "1041", "9249", "924902", "912970", "", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Lh(long j3, String str, byte[] bArr) {
        QLog.i("gameFriInfo.ForwardGameFriendFragment", 1, "requestData: ret=" + j3 + ", msg=" + str);
        if (j3 == 0 && bArr != null) {
            GameFriendSelectorSvr$GetFriendsRsp gameFriendSelectorSvr$GetFriendsRsp = new GameFriendSelectorSvr$GetFriendsRsp();
            try {
                gameFriendSelectorSvr$GetFriendsRsp.mergeFrom(bArr);
                Dh(gameFriendSelectorSvr$GetFriendsRsp);
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("gameFriInfo.ForwardGameFriendFragment", 1, "requestData: parse failed", e16);
            }
        }
        Ch(j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mh(GameFriendSelectorSvr$Friend gameFriendSelectorSvr$Friend) {
        if (gameFriendSelectorSvr$Friend == null) {
            return;
        }
        Nh(Bh(), gameFriendSelectorSvr$Friend);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nh(String str, GameFriendSelectorSvr$Friend gameFriendSelectorSvr$Friend) {
        String str2;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Intent intent = new Intent();
            intent.putExtras(activity.getIntent());
            intent.putExtra("uin", gameFriendSelectorSvr$Friend.f213219id.get());
            intent.putExtra("uintype", 10018);
            intent.putExtra("uinname", gameFriendSelectorSvr$Friend.role_name.get());
            intent.putExtra(AppConstants.Key.KEY_GC_SENDER_ID, str);
            activity.setResult(-1, intent);
            activity.finish();
            if (getActivity().getIntent() != null) {
                str2 = getActivity().getIntent().getStringExtra(AppConstants.Key.KEY_GC_GET_FRIEND_INFO_SRC);
                Oh(this.F, gameFriendSelectorSvr$Friend.intimacy_type.get(), gameFriendSelectorSvr$Friend.intimacy_value.get(), str2);
            }
        }
        str2 = "";
        Oh(this.F, gameFriendSelectorSvr$Friend.intimacy_type.get(), gameFriendSelectorSvr$Friend.intimacy_value.get(), str2);
    }

    private static void Oh(final String str, final int i3, final int i16, final String str2) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.ui.e
            @Override // java.lang.Runnable
            public final void run() {
                ForwardGameFriendFragment.Jh(i3, str2, i16, str);
            }
        }, 16, null, false);
    }

    private static void Ph(final String str, final String str2) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.ui.a
            @Override // java.lang.Runnable
            public final void run() {
                ForwardGameFriendFragment.Kh(str2, str);
            }
        }, 16, null, false);
    }

    private void Qh(String str) {
        List<GameFriendSelectorSvr$Friend> gameFriendsInfo = ((IGameCenterFriendApi) QRoute.api(IGameCenterFriendApi.class)).getGameFriendsInfo();
        if (gameFriendsInfo != null && gameFriendsInfo.size() > 0) {
            QLog.i("gameFriInfo.ForwardGameFriendFragment", 1, "friend list has already been requested successfully.");
            this.C.setData(gameFriendsInfo);
        } else {
            GameFriendSelectorSvr$GetFriendsReq gameFriendSelectorSvr$GetFriendsReq = new GameFriendSelectorSvr$GetFriendsReq();
            gameFriendSelectorSvr$GetFriendsReq.appid.set(str);
            this.D.d("/v1/817", gameFriendSelectorSvr$GetFriendsReq, new a.b() { // from class: com.tencent.mobileqq.gamecenter.ui.b
                @Override // com.tencent.mobileqq.gamecenter.protocols.a.b
                public final void a(long j3, String str2, byte[] bArr) {
                    ForwardGameFriendFragment.this.Lh(j3, str2, bArr);
                }
            });
        }
    }

    private void initData() {
        String str;
        Bundle arguments = getArguments();
        if (arguments != null) {
            str = arguments.getString(AppConstants.Key.KEY_GC_GAME_APPID);
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.F = str;
        Qh(str);
    }

    private void initSearchBar(View view) {
        this.H = (FrameLayout) view.findViewById(R.id.result_layout);
        this.G = (SelectedAndSearchBar) view.findViewById(R.id.imi);
        this.G.s(null, ((IQQAvatarService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQAvatarService.class, "")).getInstance((AppInterface) getQBaseActivity().getAppRuntime()), this.J);
    }

    private void initTitleBar(View view) {
        FragmentActivity activity = getActivity();
        if (ImmersiveUtils.isSupporImmersive() == 1 && activity != null) {
            view.setFitsSystemWindows(true);
            view.setPadding(0, ImmersiveUtils.getStatusBarHeight(activity), 0, 0);
        }
        ((TextView) view.findViewById(R.id.ivTitleName)).setText(R.string.f170746zm4);
        TextView textView = (TextView) view.findViewById(R.id.ivTitleBtnLeft);
        textView.setVisibility(0);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.gamecenter.ui.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ForwardGameFriendFragment.this.Ih(view2);
            }
        });
        textView.setText("");
    }

    private void initView(View view) {
        initSearchBar(view);
        initTitleBar(view);
        Fh(view);
        Eh(view);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        View inflate = layoutInflater.inflate(R.layout.eah, viewGroup, false);
        initView(inflate);
        initData();
        if (getActivity() != null && getActivity().getIntent() != null) {
            str = getActivity().getIntent().getStringExtra(AppConstants.Key.KEY_GC_GET_FRIEND_INFO_SRC);
        } else {
            str = "";
        }
        Ph(this.F, str);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.I = null;
        this.K = null;
        ((ISearchGameFriendApi) QRoute.api(ISearchGameFriendApi.class)).onDestroy();
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements SelectedAndSearchBar.i {
        a() {
        }

        @Override // com.tencent.mobileqq.selectmember.SelectedAndSearchBar.i
        public void afterTextChanged(Editable editable) {
            String obj = editable.toString();
            if (TextUtils.isEmpty(obj)) {
                ForwardGameFriendFragment.this.H.setVisibility(8);
            } else {
                ForwardGameFriendFragment.this.H.setVisibility(0);
            }
            ((ISearchGameFriendApi) QRoute.api(ISearchGameFriendApi.class)).startSearch(obj);
        }

        @Override // com.tencent.mobileqq.selectmember.SelectedAndSearchBar.i
        public void b(boolean z16) {
            if (z16 && ForwardGameFriendFragment.this.I == null) {
                ForwardGameFriendFragment.this.I = ((ISearchGameFriendApi) QRoute.api(ISearchGameFriendApi.class)).getSearchFragment(ForwardGameFriendFragment.this.K);
                FragmentTransaction beginTransaction = ForwardGameFriendFragment.this.getChildFragmentManager().beginTransaction();
                beginTransaction.add(R.id.result_layout, ForwardGameFriendFragment.this.I);
                beginTransaction.commitAllowingStateLoss();
            }
        }

        @Override // com.tencent.mobileqq.selectmember.SelectedAndSearchBar.i
        public void a(ResultRecord resultRecord) {
        }
    }
}
