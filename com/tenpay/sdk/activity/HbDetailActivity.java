package com.tenpay.sdk.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.qwallet.utils.QWalletUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.common.QWalletNickNameServer;
import com.tencent.mobileqq.qwallet.data.NickNameInfo;
import com.tencent.mobileqq.qwallet.hb.skin.api.IHbSkinApi;
import com.tencent.mobileqq.qwallet.report.IReportApi;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.state.data.SquareJSConst;
import com.tencent.util.UiThreadUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tenpay.QwLog;
import com.tenpay.proxy.SkinProxy;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.activity.HbDetailActivity;
import com.tenpay.sdk.hbdetail.HbDetailRsp;
import com.tenpay.sdk.hbdetail.HbDetailViewModel;
import com.tenpay.sdk.hbdetail.HbReceiverRvAdapter;
import com.tenpay.sdk.util.HBUtil;
import com.tenpay.sdk.util.OnGetResultOnMainThread;
import com.tenpay.sdk.util.QQFaceFileUtil;
import cooperation.qwallet.plugin.IQWalletHelper;
import cooperation.qwallet.plugin.QWalletPicHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class HbDetailActivity extends NetBaseActivity implements com.tencent.mobileqq.qwallet.hb.detail.g {
    public static final int ID_HB_DETAIL = 21;
    public static final int ID_HB_DETAIL_NextPage = 31;
    private static final String TAG = "HbDetailActivity";
    private AppBarLayout appBarLayout;
    private String authKey;
    private TextView backArrow;
    private TextView collapseCoverView;
    private HbDetailViewModel detailViewModel;
    private String groupID;
    private int groupType;
    private HbReceiverRvAdapter hbReceiverRvAdapter;
    private TextView hbRecord;
    boolean isFromOut;
    private TextView jumpToPopAdView;
    private TextView knowSkinText;
    private com.tencent.mobileqq.qwallet.hb.detail.v knowSkinVC;
    private int mBusiType;
    private long mEnterPageTime;
    private String mGuildId;
    private String mHBBgJumpUrl;
    private int mSkinId;
    private String mSkinTips;
    private String mSubGuildId;
    private String mTinyId;
    private RecyclerView receiverView;
    private String redEnvelopeListID;
    private int requestCode;
    private int requestId;
    private CollapsingToolbarLayout toolbarLayout;
    private TextView toolbarTitle;
    private UserInfoReceiver userInfoReceiver;
    private int mGrapHbState = -1;
    private final AtomicBoolean isRequesting = new AtomicBoolean();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tenpay.sdk.activity.HbDetailActivity$12, reason: invalid class name */
    /* loaded from: classes27.dex */
    public class AnonymousClass12 implements Runnable {
        final /* synthetic */ ArrayList val$uinList;

        AnonymousClass12(ArrayList arrayList) {
            this.val$uinList = arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0(List list) {
            HbDetailActivity.this.sendNamesToViewModel(list);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit lambda$run$1(ArrayList arrayList, final List list) {
            if (list != null && list.size() == arrayList.size()) {
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tenpay.sdk.activity.bg
                    @Override // java.lang.Runnable
                    public final void run() {
                        HbDetailActivity.AnonymousClass12.this.lambda$run$0(list);
                    }
                });
            }
            return null;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (HbDetailActivity.this.isFinishing()) {
                return;
            }
            String groupID = HbDetailActivity.this.getGroupID();
            final ArrayList arrayList = this.val$uinList;
            QWalletNickNameServer.c(groupID, arrayList, new Function1() { // from class: com.tenpay.sdk.activity.bf
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit lambda$run$1;
                    lambda$run$1 = HbDetailActivity.AnonymousClass12.this.lambda$run$1(arrayList, (List) obj);
                    return lambda$run$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class UserInfoReceiver extends BroadcastReceiver {
        UserInfoReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            action.hashCode();
            char c16 = '\uffff';
            switch (action.hashCode()) {
                case -559064336:
                    if (action.equals("com.tencent.mobileqq.qwallet.guild.nicknames")) {
                        c16 = 0;
                        break;
                    }
                    break;
                case 766424046:
                    if (action.equals("com.tencent.qqhead.getheadresp")) {
                        c16 = 1;
                        break;
                    }
                    break;
                case 1115868833:
                    if (action.equals("com.tencent.mobileqq.qwallet.guild.avatarurl")) {
                        c16 = 2;
                        break;
                    }
                    break;
            }
            switch (c16) {
                case 0:
                    String stringExtra = intent.getStringExtra("guildId");
                    Map<String, String> map = (Map) intent.getSerializableExtra("guildNickNames");
                    if (!TextUtils.equals(stringExtra, HbDetailActivity.this.mGuildId) || map != null) {
                        QLog.i(HbDetailActivity.TAG, 1, "get nick name from receiver nickNames= " + map);
                        HbDetailActivity.this.detailViewModel.updateNames(map);
                        return;
                    }
                    return;
                case 1:
                    QwLog.i("\u63a5\u6536\u5230\u5934\u50cf\u62c9\u53d6\u6210\u529f\u7684\u5e7f\u64ad");
                    ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra(SquareJSConst.Params.PARAMS_UIN_LIST);
                    ArrayList<String> stringArrayListExtra2 = intent.getStringArrayListExtra("headPathList");
                    if (stringArrayListExtra != null && stringArrayListExtra2 != null && stringArrayListExtra.size() == stringArrayListExtra2.size()) {
                        HbDetailActivity.this.sendAvatarsToViewModel(stringArrayListExtra, stringArrayListExtra2);
                        return;
                    }
                    return;
                case 2:
                    String stringExtra2 = intent.getStringExtra("guildId");
                    String stringExtra3 = intent.getStringExtra("tinyId");
                    String stringExtra4 = intent.getStringExtra("guildAvatarUrl");
                    if (TextUtils.equals(stringExtra2, HbDetailActivity.this.mGuildId) && !TextUtils.isEmpty(stringExtra3) && !TextUtils.isEmpty(stringExtra4)) {
                        HashMap hashMap = new HashMap();
                        hashMap.put(stringExtra3, stringExtra4);
                        QLog.i(HbDetailActivity.TAG, 1, "get avatar url from receiver avatarUrlList = " + hashMap);
                        HbDetailActivity.this.detailViewModel.updateAvatars(hashMap);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeToolBarStyle(boolean z16) {
        int i3;
        if (QQTheme.isNowThemeIsNight()) {
            z16 = false;
        }
        if (z16) {
            i3 = -16777216;
        } else {
            i3 = -1;
        }
        this.hbRecord.setTextColor(i3);
        this.backArrow.setTextColor(i3);
        for (Drawable drawable : this.backArrow.getCompoundDrawables()) {
            if (drawable != null) {
                drawable.setColorFilter(i3, PorterDuff.Mode.SRC_ATOP);
            }
        }
        this.toolbarTitle.setTextColor(i3);
        ImmersiveUtils.setStatusTextColor(z16, getWindow());
    }

    private void getDataParams() {
        Intent intent = getIntent();
        this.redEnvelopeListID = intent.getStringExtra("listid");
        String stringExtra = intent.getStringExtra(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID);
        this.groupID = stringExtra;
        if (stringExtra == null) {
            this.groupID = "";
        }
        Object obj = intent.getExtras().get("grouptype");
        if (obj instanceof Integer) {
            this.groupType = ((Integer) obj).intValue();
        } else if (obj instanceof String) {
            this.groupType = Integer.parseInt((String) obj);
        } else {
            QwLog.i("\u4f5c\u4e3a\u53c2\u6570grouptype\u4f20\u5165\u51fa\u9519\uff01");
            this.groupType = -1;
        }
        String stringExtra2 = intent.getStringExtra("authkey");
        this.authKey = stringExtra2;
        if (stringExtra2 == null) {
            this.authKey = "";
        }
        this.mTinyId = intent.getStringExtra("tinyId");
        this.mGuildId = intent.getStringExtra("guildId");
        this.mSubGuildId = intent.getStringExtra("subGuildId");
        this.mGrapHbState = intent.getIntExtra(Cgi.GrabHB_StateKey, -1);
        this.isFromOut = intent.getBooleanExtra("from_out", false);
        this.mSkinId = intent.getIntExtra("skin_id", -1);
        try {
            Integer.parseInt(intent.getStringExtra(WadlProxyConsts.CHANNEL));
        } catch (Exception e16) {
            QLog.e(TAG, 1, "fail to get channel", e16);
        }
        if (isValidRedPocketSkin()) {
            loadHBSkinTask(this.mSkinId);
        }
        QwLog.i("come_from" + intent.getIntExtra("come_from", -1));
    }

    private void getQQAvatar(ArrayList<String> arrayList) {
        Intent intent = new Intent("com.tencent.qqhead.getheadreq");
        intent.putExtra("faceType", 1);
        intent.putExtra(SquareJSConst.Params.PARAMS_UIN_LIST, arrayList);
        sendBroadcast(intent);
    }

    private void getQQName(ArrayList<String> arrayList) {
        ThreadManagerV2.executeOnSubThread(new AnonymousClass12(arrayList));
    }

    private HashMap<String, String> getRequestParams(String[] strArr, String[] strArr2) {
        return getRequestParams(strArr, strArr2, this.redEnvelopeListID, this.mUin);
    }

    private void handleData(int i3, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String jSONObject2 = jSONObject.toString();
        if (i3 == 21) {
            this.detailViewModel.initHbDetail(jSONObject2);
        } else if (i3 == 31) {
            this.detailViewModel.updateReceivers(jSONObject2);
            this.hbReceiverRvAdapter.updateFooter(false);
        }
    }

    private void handleRequestResult(String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.getInt("retcode") == 0) {
                    handleData(this.requestId, jSONObject);
                    QwLog.i("\u670d\u52a1\u5668\u8fd4\u56de\u6570\u636e:" + jSONObject.toString());
                }
            } catch (Exception e16) {
                QLog.e(TAG, 1, "error when handleRequestResult", e16);
            }
        }
        this.isRequesting.set(false);
    }

    private void initReceiverRecyclerView(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.x6v);
        this.receiverView = recyclerView;
        if (Build.VERSION.SDK_INT >= 28) {
            recyclerView.setOutlineAmbientShadowColor(0);
            this.receiverView.setOutlineSpotShadowColor(0);
        }
        HbReceiverRvAdapter hbReceiverRvAdapter = new HbReceiverRvAdapter(this);
        this.hbReceiverRvAdapter = hbReceiverRvAdapter;
        this.receiverView.setAdapter(hbReceiverRvAdapter);
        this.receiverView.setItemAnimator(null);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.receiverView.setLayoutManager(linearLayoutManager);
        this.receiverView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.tenpay.sdk.activity.HbDetailActivity.6
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView2, int i3, int i16) {
                super.onScrolled(recyclerView2, i3, i16);
                int findLastCompletelyVisibleItemPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
                if (findLastCompletelyVisibleItemPosition == -1) {
                    return;
                }
                View childAt = linearLayoutManager.getChildAt(r2.getChildCount() - 1);
                if (childAt != null) {
                    HbDetailActivity.this.knowSkinVC.c(childAt);
                }
                if (findLastCompletelyVisibleItemPosition == linearLayoutManager.getItemCount() - 1) {
                    UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tenpay.sdk.activity.HbDetailActivity.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            HbDetailActivity.this.getNextPageData();
                        }
                    });
                }
            }
        });
    }

    private void initToolBar(View view) {
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.x7h);
        QLog.d(TAG, 1, "toolbar layout params, " + toolbar.getLayoutParams().getClass().getCanonicalName());
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) toolbar.getLayoutParams();
        marginLayoutParams.topMargin = marginLayoutParams.topMargin + ImmersiveUtils.getStatusBarHeight(getContext());
        toolbar.setLayoutParams(marginLayoutParams);
        toolbar.bringToFront();
        this.toolbarTitle = (TextView) view.findViewById(R.id.x6h);
        TextView textView = (TextView) view.findViewById(R.id.svu);
        this.backArrow = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.HbDetailActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EventCollector.getInstance().onViewClickedBefore(view2);
                HbDetailActivity.this.clickBackBtn();
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
        TextView textView2 = (TextView) view.findViewById(R.id.x6y);
        this.hbRecord = textView2;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.HbDetailActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EventCollector.getInstance().onViewClickedBefore(view2);
                HbDetailActivity.this.go2HbList();
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
        if ((getIntent() != null && getIntent().getBooleanExtra(Cgi.HBList_IsFromKey, false)) || isInGuildAIO()) {
            this.hbRecord.setVisibility(8);
        }
        AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R.id.f165660x62);
        this.appBarLayout = appBarLayout;
        appBarLayout.setOutlineProvider(null);
        if (Build.VERSION.SDK_INT >= 28) {
            this.appBarLayout.setOutlineAmbientShadowColor(0);
            this.appBarLayout.setOutlineSpotShadowColor(0);
        }
        this.toolbarLayout = (CollapsingToolbarLayout) view.findViewById(R.id.f165662x64);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initTopCover(@NonNull String str) {
        this.appBarLayout.e(new AppBarLayout.g() { // from class: com.tenpay.sdk.activity.HbDetailActivity.3
            @Override // com.google.android.material.appbar.AppBarLayout.c
            public void onOffsetChanged(AppBarLayout appBarLayout, int i3) {
                boolean z16;
                int i16;
                int i17 = 0;
                if (appBarLayout.getHeight() + i3 < HbDetailActivity.this.toolbarLayout.i()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                HbDetailActivity.this.changeToolBarStyle(z16);
                TextView textView = HbDetailActivity.this.jumpToPopAdView;
                if (!TextUtils.isEmpty(HbDetailActivity.this.mHBBgJumpUrl) && !z16) {
                    i16 = 0;
                } else {
                    i16 = 4;
                }
                textView.setVisibility(i16);
                TextView textView2 = HbDetailActivity.this.collapseCoverView;
                if (z16) {
                    i17 = 8;
                }
                textView2.setVisibility(i17);
                if (HbDetailActivity.this.receiverView != null) {
                    HbDetailActivity.this.knowSkinVC.d(HbDetailActivity.this.receiverView);
                }
            }
        });
        AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams) this.toolbarLayout.getLayoutParams();
        layoutParams.g(3);
        this.toolbarLayout.setLayoutParams(layoutParams);
        ImageView imageView = (ImageView) this.toolbarLayout.findViewById(R.id.x65);
        View inflate = ((ViewStub) this.toolbarLayout.findViewById(R.id.x6a)).inflate();
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.x6_);
        URLDrawable netDrawableForQWallet = QWalletPicHelper.getNetDrawableForQWallet(str);
        if (netDrawableForQWallet != null) {
            imageView.setVisibility(8);
            imageView2.setImageDrawable(netDrawableForQWallet);
        }
        this.jumpToPopAdView = (TextView) inflate.findViewById(R.id.f165984yb4);
        if (!TextUtils.isEmpty(this.mHBBgJumpUrl)) {
            this.jumpToPopAdView.setVisibility(0);
        }
        if (!TextUtils.isEmpty(this.mSkinTips)) {
            this.jumpToPopAdView.setText(this.mSkinTips);
        }
        this.jumpToPopAdView.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.HbDetailActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                if (!TextUtils.isEmpty(HbDetailActivity.this.mHBBgJumpUrl)) {
                    QWalletUtils.k(HbDetailActivity.this.getActivity(), HbDetailActivity.this.mHBBgJumpUrl);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        TextView textView = (TextView) inflate.findViewById(R.id.x7l);
        this.collapseCoverView = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.HbDetailActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                HbDetailActivity.this.appBarLayout.setExpanded(false);
                EventCollector.getInstance().onViewClicked(view);
            }
        });
    }

    private void initView(View view) {
        initToolBar(view);
        initReceiverRecyclerView(view);
        this.knowSkinText = (TextView) view.findViewById(R.id.f165995yc4);
        this.knowSkinVC = new com.tencent.mobileqq.qwallet.hb.detail.v(this.knowSkinText, isValidRedPocketSkin());
    }

    private void initViewModel() {
        final HbDetailViewModel hbDetailViewModel = (HbDetailViewModel) new ViewModelProvider(this).get(HbDetailViewModel.class);
        if (hbDetailViewModel.getSender() != null) {
            this.mBusiType = hbDetailViewModel.getSender().getBusiType();
        }
        getLifecycle().addObserver(hbDetailViewModel);
        hbDetailViewModel.getSenderAndSelfChanged().observe(getViewLifecycleOwner(), new Observer<Boolean>() { // from class: com.tenpay.sdk.activity.HbDetailActivity.7
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                if (bool.booleanValue()) {
                    HbDetailActivity.this.hbReceiverRvAdapter.updateHeader(hbDetailViewModel.getSender(), hbDetailViewModel.getSelf());
                }
            }
        });
        hbDetailViewModel.getReceivers().observe(getViewLifecycleOwner(), new Observer<List<HbDetailRsp.HbReceiver>>() { // from class: com.tenpay.sdk.activity.HbDetailActivity.8
            @Override // androidx.lifecycle.Observer
            public void onChanged(List<HbDetailRsp.HbReceiver> list) {
                if (list == null) {
                    return;
                }
                HbDetailActivity.this.hbReceiverRvAdapter.submitList(new ArrayList(list));
            }
        });
        hbDetailViewModel.getNewUserIds().observe(getViewLifecycleOwner(), new Observer<ArrayList<String>>() { // from class: com.tenpay.sdk.activity.HbDetailActivity.9
            @Override // androidx.lifecycle.Observer
            public void onChanged(ArrayList<String> arrayList) {
                if (arrayList == null || arrayList.isEmpty()) {
                    return;
                }
                if (!HbDetailActivity.this.isInGuildAIO() && !hbDetailViewModel.getHasTinyId()) {
                    HbDetailActivity.this.getInfoFromQQ(arrayList);
                } else {
                    HbDetailActivity.this.getInfoFromTinyId(arrayList);
                }
            }
        });
        this.detailViewModel = hbDetailViewModel;
        hbDetailViewModel.getHbOperationBubble().observe(getViewLifecycleOwner(), new Observer<HbDetailRsp.HbOperationBubble>() { // from class: com.tenpay.sdk.activity.HbDetailActivity.10
            @Override // androidx.lifecycle.Observer
            public void onChanged(HbDetailRsp.HbOperationBubble hbOperationBubble) {
                HbDetailActivity.this.hbReceiverRvAdapter.updateOperationBubble(hbOperationBubble);
            }
        });
    }

    private boolean isValidRedPocketSkin() {
        return ((IHbSkinApi) QRoute.api(IHbSkinApi.class)).isValidRedPocketSkin(this.mSkinId, null, 0);
    }

    private void loadData() {
        String stringExtra = getIntent().getStringExtra("hb_data");
        if (stringExtra != null) {
            this.detailViewModel.initHbDetail(stringExtra);
        }
        loadDataFromServer();
    }

    private void loadDataFromServer() {
        QwLog.i("\u4ece\u670d\u52a1\u5668\u52a0\u8f7d\u6570\u636e");
        sendRequest(21);
    }

    private void loadHBSkinTask(int i3) {
        SkinProxy.getSkinPopResUrlAsync(i3, "", 0, new ResultReceiver(new Handler(Looper.getMainLooper())) { // from class: com.tenpay.sdk.activity.HbDetailActivity.11
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i16, Bundle bundle) {
                if (bundle != null) {
                    String string = bundle.getString("skin_pop_res_url");
                    HbDetailActivity.this.mSkinTips = bundle.getString("skin_activity_name");
                    HbDetailActivity.this.mHBBgJumpUrl = bundle.getString("skin_activity_url");
                    if (!TextUtils.isEmpty(string)) {
                        HbDetailActivity.this.initTopCover(string);
                    }
                }
            }
        });
    }

    private void registerReceiver() {
        QwLog.i("\u6ce8\u518c\u5e7f\u64ad\u63a5\u6536");
        this.userInfoReceiver = new UserInfoReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.qqhead.getheadresp");
        intentFilter.addAction("com.tencent.mobileqq.qwallet.guild.nicknames");
        intentFilter.addAction("com.tencent.mobileqq.qwallet.guild.avatarurl");
        try {
            getActivity().registerReceiver(this.userInfoReceiver, intentFilter, QQFaceFileUtil.QQFaceImageGetter.ReceiverQQFacePermission, null);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendAvatarsToViewModel(List<String> list, List<String> list2) {
        HashMap hashMap = new HashMap();
        for (int i3 = 0; i3 < list.size(); i3++) {
            hashMap.put(list.get(i3), list2.get(i3));
        }
        this.detailViewModel.updateAvatars(hashMap);
    }

    private void sendHBStateBroadcast() {
        Intent intent = getIntent();
        if (intent.getBooleanExtra("isFromHBList", false)) {
            Intent intent2 = new Intent(IQWalletHelper.TROOP_HBLIST_BROADCAST_ACTION);
            intent2.putExtra("grap_hb_state", 1);
            intent2.putExtra("listid", intent.getStringExtra("listid"));
            intent2.putExtra("result_code", IQWalletHelper.TROOP_HBLIST_CLOSE_RESULT_CODE);
            sendBroadcast(intent2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendNamesToViewModel(List<NickNameInfo> list) {
        HashMap hashMap = new HashMap();
        for (int i3 = 0; i3 < list.size(); i3++) {
            hashMap.put(list.get(i3).getUin(), list.get(i3).getNickName());
        }
        this.detailViewModel.updateNames(hashMap);
    }

    private void sendRequest(int i3) {
        int i16;
        if (this.isRequesting.getAndSet(true)) {
            return;
        }
        this.requestId = i3;
        if (i3 == 31) {
            i16 = this.detailViewModel.getOffset();
            this.hbReceiverRvAdapter.updateFooter(true);
        } else {
            i16 = 0;
        }
        HashMap<String, String> requestParams = getRequestParams(new String[]{"offset", "authkey", "grouptype", FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, "tinyid", "guild_id", "sub_guild_id"}, new String[]{String.valueOf(i16), this.authKey, this.groupType + "", this.groupID, this.mTinyId, this.mGuildId, this.mSubGuildId});
        if (requestParams != null) {
            httpRequestNoLoading(Cgi.URI_HB_Detail_Server, requestParams);
        }
    }

    private void unRegisterReceiver() {
        QwLog.i("\u53bb\u6ce8\u518c\u5e7f\u64ad\u63a5\u6536");
        try {
            getActivity().unregisterReceiver(this.userInfoReceiver);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
        }
    }

    public void clickBackBtn() {
        com.tencent.mobileqq.qwallet.c.c("hongbao.detail.back", Integer.valueOf(getProcessType()));
        finishMySelf(this.isFromOut);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            com.tencent.mobileqq.qwallet.c.c("hongbao.detail.keyback", Integer.valueOf(getProcessType()));
            finishMySelf(this.isFromOut);
            return true;
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    public void finishMySelf(boolean z16) {
        if (z16) {
            Bundle retCodeAndGetBundle = setRetCodeAndGetBundle(0);
            retCodeAndGetBundle.putString(Cgi.RETURN_MSG_KEY, "");
            if ((101 == this.groupType && -1 != this.mGrapHbState) || HBUtil.isHbForAR(this.detailViewModel.getChannel())) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("state", Integer.valueOf(this.mGrapHbState));
                } catch (JSONException e16) {
                    QLog.e(TAG, 1, "", e16);
                }
                retCodeAndGetBundle.putString("retdata", jSONObject.toString());
            }
            sendHBStateBroadcast();
        }
        finish();
    }

    public Bitmap getBitmap(int i3) {
        return BitmapFactory.decodeResource(getContext().getResources(), i3);
    }

    public String getGroupID() {
        return this.groupID;
    }

    public int getGroupType() {
        return this.groupType;
    }

    public void getGuildAvatarUrls(final ArrayList<String> arrayList) {
        HBUtil.getGuildUsersAvatarUrls(this.requestCode, arrayList, this.mGuildId, new OnGetResultOnMainThread() { // from class: com.tenpay.sdk.activity.HbDetailActivity.13
            @Override // com.tenpay.sdk.util.OnGetResultOnMainThread
            public void getResultOnMainThread(Object obj) {
                try {
                    Map<String, String> map = (Map) obj;
                    QwLog.i("retUinList = " + arrayList.toString());
                    if (map != null && !map.isEmpty()) {
                        HbDetailActivity.this.detailViewModel.updateAvatars(map);
                    }
                } catch (Exception e16) {
                    QLog.e(HbDetailActivity.TAG, 1, e16, new Object[0]);
                }
            }
        });
    }

    public void getGuildMemberNames(ArrayList<String> arrayList) {
        HBUtil.getGuildMemberNames(this.requestCode, arrayList, this.mGuildId, new OnGetResultOnMainThread() { // from class: com.tenpay.sdk.activity.HbDetailActivity.14
            @Override // com.tenpay.sdk.util.OnGetResultOnMainThread
            public void getResultOnMainThread(Object obj) {
                try {
                    Map<String, String> map = (Map) obj;
                    if (map != null && !map.isEmpty()) {
                        HbDetailActivity.this.detailViewModel.updateNames(map);
                    }
                } catch (Exception e16) {
                    QLog.e(HbDetailActivity.TAG, 1, e16, new Object[0]);
                }
            }
        });
    }

    public void getInfoFromQQ(ArrayList<String> arrayList) {
        getQQName(arrayList);
        getQQAvatar(arrayList);
    }

    public void getInfoFromTinyId(ArrayList<String> arrayList) {
        QwLog.i("uinList = " + arrayList.toString());
        getGuildAvatarUrls(arrayList);
        getGuildMemberNames(arrayList);
    }

    public String getMyQQUin() {
        return this.mUin;
    }

    public void getNextPageData() {
        if (!this.detailViewModel.getHasMore()) {
            com.tencent.mobileqq.qwallet.utils.f.a(TAG, "no more hb receivers to request");
        } else {
            sendRequest(31);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tenpay.sdk.activity.TenpayUtilActivity
    public int getProcessType() {
        Intent intent = getIntent();
        if (intent.hasExtra(Cgi.GrabHB_StateKey)) {
            return 129;
        }
        if (!intent.getBooleanExtra(Cgi.HBList_IsFromKey, false)) {
            int intExtra = intent.getIntExtra("come_from", -1);
            if (intExtra == 1) {
                return 131;
            }
            if (intExtra == 2) {
                return 132;
            }
        }
        return -1;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.qwallet.hb.detail.g
    public void go2DetailCard(String str) {
        boolean z16;
        if (isInGuildAIO() || this.detailViewModel.getHasTinyId() || HBUtil.isHbForFaceToFace(this.detailViewModel.getChannel())) {
            return;
        }
        try {
            if (!TextUtils.isEmpty(this.mGroupid)) {
                z16 = true;
            } else {
                z16 = false;
            }
            openFriendCard(str, HBUtil.isHbForAnonymity(this.detailViewModel.getChannel()), z16);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "go2DetailCard error", e16);
        }
    }

    void go2HbList() {
        Intent intent = new Intent();
        intent.putExtra("listid", this.redEnvelopeListID);
        intent.putExtra(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, this.groupID);
        launchFragment(intent, HbListActivity.class);
        com.tencent.mobileqq.qwallet.c.c("hongbao.detail.record", Integer.valueOf(getProcessType()));
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment
    public boolean isAllowLandscape() {
        return true;
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment
    protected boolean isFitNavigateBar() {
        return true;
    }

    public boolean isInGuildAIO() {
        if (this.groupType == 11) {
            return true;
        }
        return false;
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment
    protected boolean isStatusBarImmersive() {
        return false;
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getActivity().setTheme(R.style.a6m);
        getDataParams();
        int hashCode = hashCode();
        this.requestCode = hashCode;
        HBUtil.initGuildObserver(this.mGuildId, hashCode);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.aea, viewGroup, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        String str;
        String hbTypeText = HBUtil.getHbTypeText(this.detailViewModel.getChannel(), this.mBusiType);
        String valueOf = String.valueOf(NetConnInfoCenter.getServerTimeMillis() - this.mEnterPageTime);
        if (TextUtils.equals(String.valueOf(this.groupType), "11")) {
            str = this.mGuildId;
        } else {
            str = this.groupID;
        }
        ((IReportApi) QRoute.api(IReportApi.class)).reportHongbaoTo644("redpack.get.showtime", String.valueOf(this.groupType), hbTypeText, valueOf, str);
        HBUtil.removeAllGuildCallBack(this.requestCode);
        super.onDestroy();
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        unRegisterReceiver();
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onError(String str, JSONObject jSONObject) {
        super.onError(str, jSONObject);
        handleRequestResult(str, jSONObject);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity
    public void onNetDlgokClick(String str, JSONObject jSONObject) {
        super.onNetDlgokClick(str, jSONObject);
        commonBlErrorPros(jSONObject, true);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(String str, JSONObject jSONObject) {
        super.onSuccess(str, jSONObject);
        saveConfig(str, jSONObject);
        handleRequestResult(str, jSONObject);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        String str;
        super.onViewCreated(view, bundle);
        initView(view);
        registerReceiver();
        initViewModel();
        loadData();
        com.tencent.mobileqq.qwallet.c.c("hongbao.detail.show", Integer.valueOf(getProcessType()));
        this.mEnterPageTime = NetConnInfoCenter.getServerTimeMillis();
        String hbTypeText = HBUtil.getHbTypeText(this.detailViewModel.getChannel(), this.mBusiType);
        if (TextUtils.equals(String.valueOf(this.groupType), "11")) {
            str = this.mGuildId;
        } else {
            str = this.groupID;
        }
        ((IReportApi) QRoute.api(IReportApi.class)).reportHongbaoTo644("redpack.get.show", String.valueOf(this.groupType), hbTypeText, "", str);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    public static HashMap<String, String> getRequestParams(String[] strArr, String[] strArr2, String str, String str2) {
        if (str != null && str2 != null) {
            try {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("listid", str);
                hashMap.put("uin", str2);
                if (strArr != null) {
                    for (int i3 = 0; i3 < strArr.length; i3++) {
                        hashMap.put(strArr[i3], strArr2[i3]);
                    }
                }
                return hashMap;
            } catch (Exception e16) {
                QLog.e(TAG, 1, "", e16);
            }
        }
        return null;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
