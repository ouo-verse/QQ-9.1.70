package com.tencent.mobileqq.qwallet.hb.detail;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.common.QWalletNickNameServer;
import com.tencent.mobileqq.qwallet.data.NickNameInfo;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.qwallet.hb.detail.HbDetailFragment;
import com.tencent.mobileqq.qwallet.hb.skin.api.IHbSkinApi;
import com.tencent.mobileqq.qwallet.report.IReportApi;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.state.data.SquareJSConst;
import com.tencent.util.UiThreadUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tenpay.QwLog;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.activity.HbListActivity;
import com.tenpay.sdk.activity.NetBaseActivity;
import com.tenpay.sdk.hbdetail.HbDetailRsp;
import com.tenpay.sdk.hbdetail.HbDetailViewModel;
import com.tenpay.sdk.hbdetail.HbReceiverRvAdapter;
import com.tenpay.sdk.util.HBUtil;
import com.tenpay.sdk.util.OnGetResultOnMainThread;
import com.tenpay.sdk.util.QQFaceFileUtil;
import cooperation.qwallet.plugin.IQWalletHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class HbDetailFragment extends NetBaseActivity implements g {
    private int D;
    private boolean F;
    private int G;
    private String H;
    private int I;
    private HbDetailViewModel J;
    private HbSkinAppBarLayout K;
    private RecyclerView L;
    private TextView M;
    private ViewGroup N;
    private HbReceiverRvAdapter P;
    private int Q;
    private long R;
    private v S;
    private String T;
    private String U;
    private int V;
    private String W;
    private String X;
    private String Y;
    private String Z;

    /* renamed from: a0, reason: collision with root package name */
    private e f277288a0;
    private int C = -1;
    private final AtomicBoolean E = new AtomicBoolean();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a extends RecyclerView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LinearLayoutManager f277289d;

        a(LinearLayoutManager linearLayoutManager) {
            this.f277289d = linearLayoutManager;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e() {
            HbDetailFragment.this.getNextPageData();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i3, int i16) {
            super.onScrolled(recyclerView, i3, i16);
            int findLastCompletelyVisibleItemPosition = this.f277289d.findLastCompletelyVisibleItemPosition();
            if (findLastCompletelyVisibleItemPosition == -1) {
                return;
            }
            View childAt = this.f277289d.getChildAt(r4.getChildCount() - 1);
            if (childAt != null) {
                HbDetailFragment.this.S.c(childAt);
            }
            if (findLastCompletelyVisibleItemPosition == this.f277289d.getItemCount() - 1) {
                recyclerView.post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.detail.t
                    @Override // java.lang.Runnable
                    public final void run() {
                        HbDetailFragment.a.this.e();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class b implements Observer<HbDetailRsp.HbOperationBubble> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(HbDetailRsp.HbOperationBubble hbOperationBubble) {
            HbDetailFragment.this.P.updateOperationBubble(hbOperationBubble);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class c extends OnGetResultOnMainThread {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayList f277292d;

        c(ArrayList arrayList) {
            this.f277292d = arrayList;
        }

        @Override // com.tenpay.sdk.util.OnGetResultOnMainThread
        public void getResultOnMainThread(Object obj) {
            try {
                Map<String, String> map = (Map) obj;
                QwLog.i("retUinList = " + this.f277292d.toString());
                if (map != null && !map.isEmpty()) {
                    HbDetailFragment.this.J.updateAvatars(map);
                }
            } catch (Exception e16) {
                QLog.e("HbDetailFragment", 1, e16, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class d extends OnGetResultOnMainThread {
        d() {
        }

        @Override // com.tenpay.sdk.util.OnGetResultOnMainThread
        public void getResultOnMainThread(Object obj) {
            try {
                Map<String, String> map = (Map) obj;
                if (map != null && !map.isEmpty()) {
                    HbDetailFragment.this.J.updateNames(map);
                }
            } catch (Exception e16) {
                QLog.e("HbDetailFragment", 1, e16, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class e extends BroadcastReceiver {
        e() {
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
                    if (TextUtils.equals(stringExtra, HbDetailFragment.this.Y) && map != null) {
                        QLog.i("HbDetailFragment", 1, "get nick name from receiver nickNames= " + map);
                        HbDetailFragment.this.J.updateNames(map);
                        return;
                    }
                    return;
                case 1:
                    QwLog.i("\u63a5\u6536\u5230\u5934\u50cf\u62c9\u53d6\u6210\u529f\u7684\u5e7f\u64ad");
                    ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra(SquareJSConst.Params.PARAMS_UIN_LIST);
                    ArrayList<String> stringArrayListExtra2 = intent.getStringArrayListExtra("headPathList");
                    if (stringArrayListExtra != null && stringArrayListExtra2 != null && stringArrayListExtra.size() == stringArrayListExtra2.size()) {
                        HbDetailFragment.this.sendAvatarsToViewModel(stringArrayListExtra, stringArrayListExtra2);
                        return;
                    }
                    return;
                case 2:
                    String stringExtra2 = intent.getStringExtra("guildId");
                    String stringExtra3 = intent.getStringExtra("tinyId");
                    String stringExtra4 = intent.getStringExtra("guildAvatarUrl");
                    if (TextUtils.equals(stringExtra2, HbDetailFragment.this.Y) && !TextUtils.isEmpty(stringExtra3) && !TextUtils.isEmpty(stringExtra4)) {
                        HashMap hashMap = new HashMap();
                        hashMap.put(stringExtra3, stringExtra4);
                        QLog.i("HbDetailFragment", 1, "get avatar url from receiver avatarUrlList = " + hashMap);
                        HbDetailFragment.this.J.updateAvatars(hashMap);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void Ih(View view) {
        QLog.d("HbDetailFragment", 2, "initAppBar: ");
        this.K = (HbSkinAppBarLayout) view.findViewById(R.id.f165660x62);
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.x7g);
        this.N = viewGroup;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewGroup.getLayoutParams();
        marginLayoutParams.topMargin += ImmersiveUtils.getStatusBarHeight(getContext());
        this.N.setLayoutParams(marginLayoutParams);
        ((TextView) view.findViewById(R.id.svu)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qwallet.hb.detail.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                HbDetailFragment.this.Mh(view2);
            }
        });
        final TextView textView = (TextView) view.findViewById(R.id.x6y);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qwallet.hb.detail.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                HbDetailFragment.this.Nh(view2);
            }
        });
        final boolean z16 = false;
        if ((getIntent() != null && getIntent().getBooleanExtra(Cgi.HBList_IsFromKey, false)) || isInGuildAIO()) {
            z16 = true;
        }
        if (z16) {
            textView.setVisibility(8);
        }
        this.K.getViewModel().W1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.qwallet.hb.detail.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HbDetailFragment.this.Oh(textView, (Triple) obj);
            }
        });
        this.K.getViewModel().Z1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.qwallet.hb.detail.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HbDetailFragment.Ph(z16, textView, (HbSkinState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit Jh(ArrayList arrayList, final List list) {
        if (list != null && list.size() == arrayList.size()) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.detail.j
                @Override // java.lang.Runnable
                public final void run() {
                    HbDetailFragment.this.Lh(list);
                }
            });
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Kh(final ArrayList arrayList) {
        if (isFinishing()) {
            return;
        }
        QWalletNickNameServer.c(this.mGroupid, arrayList, new Function1() { // from class: com.tencent.mobileqq.qwallet.hb.detail.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit Jh;
                Jh = HbDetailFragment.this.Jh(arrayList, (List) obj);
                return Jh;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Mh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        clickBackBtn();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Nh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        go2HbList();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Oh(TextView textView, Triple triple) {
        float floatValue = 1.3f - ((((Float) triple.getFirst()).floatValue() - ((Float) triple.getSecond()).floatValue()) / (((Float) triple.getThird()).floatValue() - ((Float) triple.getSecond()).floatValue()));
        float f16 = 1.0f;
        if (floatValue > 1.0f) {
            floatValue = 1.0f;
        } else if (floatValue < 0.0f) {
            floatValue = 0.0f;
        }
        RecyclerView recyclerView = this.L;
        if (recyclerView != null) {
            recyclerView.setAlpha(floatValue);
            this.S.d(this.L);
        }
        float floatValue2 = 1.0f - ((((Float) triple.getFirst()).floatValue() - ((Float) triple.getSecond()).floatValue()) / ((((Float) triple.getThird()).floatValue() * 0.8f) - ((Float) triple.getSecond()).floatValue()));
        if (floatValue2 <= 1.0f) {
            if (floatValue2 < 0.0f) {
                f16 = 0.0f;
            } else {
                f16 = floatValue2;
            }
        }
        textView.setAlpha(f16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Ph(boolean z16, TextView textView, HbSkinState hbSkinState) {
        int i3;
        if (hbSkinState == HbSkinState.EXPANDED) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        if (!z16) {
            textView.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Qh(HbDetailViewModel hbDetailViewModel, Boolean bool) {
        if (bool.booleanValue()) {
            this.P.updateHeader(hbDetailViewModel.getSender(), hbDetailViewModel.getSelf());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Rh(List list) {
        if (list == null) {
            return;
        }
        this.P.submitList(new ArrayList(list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Sh(HbDetailViewModel hbDetailViewModel, ArrayList arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            if (!isInGuildAIO() && !hbDetailViewModel.getHasTinyId()) {
                getInfoFromQQ(arrayList);
            } else {
                getInfoFromTinyId(arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Th(Boolean bool) {
        if (!bool.booleanValue()) {
            return;
        }
        Wh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Uh(TranslateAnimation translateAnimation) {
        this.K.startAnimation(translateAnimation);
        this.L.startAnimation(translateAnimation);
    }

    private void Vh() {
        this.f277288a0 = new e();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.qqhead.getheadresp");
        intentFilter.addAction("com.tencent.mobileqq.qwallet.guild.nicknames");
        intentFilter.addAction("com.tencent.mobileqq.qwallet.guild.avatarurl");
        try {
            getActivity().registerReceiver(this.f277288a0, intentFilter, QQFaceFileUtil.QQFaceImageGetter.ReceiverQQFacePermission, null);
        } catch (Exception e16) {
            QLog.e("HbDetailFragment", 1, "", e16);
        }
    }

    private void Wh() {
        if (this.K == null || this.L == null || com.tencent.mobileqq.qwallet.utils.g.b("hb_skin_pull_guide_showed")) {
            return;
        }
        com.tencent.mobileqq.qwallet.utils.g.l("hb_skin_pull_guide_showed", true);
        final TranslateAnimation translateAnimation = new TranslateAnimation(0, 0.0f, 0, 0.0f, 0, 0.0f, 0, 200.0f);
        translateAnimation.setDuration(500L);
        translateAnimation.setRepeatCount(3);
        translateAnimation.setRepeatMode(2);
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.detail.r
            @Override // java.lang.Runnable
            public final void run() {
                HbDetailFragment.this.Uh(translateAnimation);
            }
        }, 500L);
    }

    private void Xh() {
        try {
            unregisterReceiver(this.f277288a0);
        } catch (Exception e16) {
            QLog.e("HbDetailFragment", 1, "", e16);
        }
    }

    private void getDataParams() {
        Intent intent = getIntent();
        this.T = intent.getStringExtra("listid");
        String stringExtra = intent.getStringExtra(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID);
        this.U = stringExtra;
        if (stringExtra == null) {
            this.U = "";
        }
        Object obj = intent.getExtras().get("grouptype");
        if (obj instanceof Integer) {
            this.V = ((Integer) obj).intValue();
        } else if (obj instanceof String) {
            this.V = Integer.parseInt((String) obj);
        } else {
            this.V = -1;
        }
        String stringExtra2 = intent.getStringExtra("authkey");
        this.W = stringExtra2;
        if (stringExtra2 == null) {
            this.W = "";
        }
        this.X = intent.getStringExtra("tinyId");
        this.Y = intent.getStringExtra("guildId");
        this.Z = intent.getStringExtra("subGuildId");
        this.C = intent.getIntExtra(Cgi.GrabHB_StateKey, -1);
        this.F = intent.getBooleanExtra("from_out", false);
        this.G = intent.getIntExtra("skin_id", -1);
        this.H = intent.getStringExtra("outer_skin_id");
        this.I = intent.getIntExtra("skin_from", 0);
    }

    private void getQQAvatar(ArrayList<String> arrayList) {
        Intent intent = new Intent("com.tencent.qqhead.getheadreq");
        intent.putExtra("faceType", 1);
        intent.putExtra(SquareJSConst.Params.PARAMS_UIN_LIST, arrayList);
        sendBroadcast(intent);
    }

    private void getQQName(final ArrayList<String> arrayList) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.detail.s
            @Override // java.lang.Runnable
            public final void run() {
                HbDetailFragment.this.Kh(arrayList);
            }
        }, 16, null, true);
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
                QLog.e("HbDetailFragment", 1, "", e16);
            }
        }
        return null;
    }

    private void handleData(int i3, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String jSONObject2 = jSONObject.toString();
        if (i3 == 21) {
            this.J.initHbDetail(jSONObject2);
        } else if (i3 == 31) {
            this.J.updateReceivers(jSONObject2);
            this.P.updateFooter(false);
        }
    }

    private void handleRequestResult(String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.getInt("retcode") == 0) {
                    handleData(this.D, jSONObject);
                    QwLog.i("\u670d\u52a1\u5668\u8fd4\u56de\u6570\u636e:" + jSONObject);
                }
            } catch (Exception e16) {
                QLog.e("HbDetailFragment", 1, "error when handleRequestResult", e16);
            }
        }
        this.E.set(false);
    }

    private void initReceiverRecyclerView(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.x6v);
        this.L = recyclerView;
        if (Build.VERSION.SDK_INT >= 28) {
            recyclerView.setOutlineAmbientShadowColor(0);
            this.L.setOutlineSpotShadowColor(0);
        }
        HbReceiverRvAdapter hbReceiverRvAdapter = new HbReceiverRvAdapter(this);
        this.P = hbReceiverRvAdapter;
        this.L.setAdapter(hbReceiverRvAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.L.setLayoutManager(linearLayoutManager);
        this.L.setItemAnimator(null);
        this.L.addOnScrollListener(new a(linearLayoutManager));
    }

    private void initView(View view) {
        Ih(view);
        initReceiverRecyclerView(view);
        this.M = (TextView) view.findViewById(R.id.f165995yc4);
        this.S = new v(this.M, this.K.getViewModel().c2());
    }

    private void initViewModel() {
        final HbDetailViewModel hbDetailViewModel = (HbDetailViewModel) new ViewModelProvider(this).get(HbDetailViewModel.class);
        getLifecycle().addObserver(hbDetailViewModel);
        hbDetailViewModel.getSenderAndSelfChanged().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.qwallet.hb.detail.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HbDetailFragment.this.Qh(hbDetailViewModel, (Boolean) obj);
            }
        });
        hbDetailViewModel.getReceivers().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.qwallet.hb.detail.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HbDetailFragment.this.Rh((List) obj);
            }
        });
        hbDetailViewModel.getNewUserIds().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.qwallet.hb.detail.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HbDetailFragment.this.Sh(hbDetailViewModel, (ArrayList) obj);
            }
        });
        hbDetailViewModel.getHbOperationBubble().observe(getViewLifecycleOwner(), new b());
        this.J = hbDetailViewModel;
    }

    private void loadData() {
        String stringExtra = getIntent().getStringExtra("hb_data");
        if (stringExtra != null) {
            this.J.initHbDetail(stringExtra);
        }
        loadDataFromServer();
    }

    private void loadDataFromServer() {
        sendRequest(21);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendAvatarsToViewModel(List<String> list, List<String> list2) {
        HashMap hashMap = new HashMap();
        for (int i3 = 0; i3 < list.size(); i3++) {
            hashMap.put(list.get(i3), list2.get(i3));
        }
        this.J.updateAvatars(hashMap);
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
    /* renamed from: sendNamesToViewModel, reason: merged with bridge method [inline-methods] */
    public void Lh(List<NickNameInfo> list) {
        HashMap hashMap = new HashMap();
        for (int i3 = 0; i3 < list.size(); i3++) {
            hashMap.put(list.get(i3).getUin(), list.get(i3).getNickName());
        }
        this.J.updateNames(hashMap);
    }

    private void sendRequest(int i3) {
        int i16;
        if (this.E.getAndSet(true)) {
            return;
        }
        this.D = i3;
        if (i3 == 31) {
            i16 = this.J.getOffset();
            this.P.updateFooter(true);
        } else {
            i16 = 0;
        }
        HashMap<String, String> requestParams = getRequestParams(new String[]{"offset", "authkey", "grouptype", FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, "tinyid", "guild_id", "sub_guild_id"}, new String[]{String.valueOf(i16), this.W, this.V + "", this.U, this.X, this.Y, this.Z}, this.T, this.mUin);
        if (requestParams != null) {
            httpRequestNoLoading(Cgi.URI_HB_Detail_Server, requestParams);
        }
    }

    public void clickBackBtn() {
        finishMySelf(this.F);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            finishMySelf(this.F);
            return true;
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    public void finishMySelf(boolean z16) {
        if (z16) {
            Bundle retCodeAndGetBundle = setRetCodeAndGetBundle(0);
            retCodeAndGetBundle.putString(Cgi.RETURN_MSG_KEY, "");
            if ((101 == this.V && -1 != this.C) || HBUtil.isHbForAR(this.J.getChannel())) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("state", Integer.valueOf(this.C));
                } catch (JSONException e16) {
                    QLog.e("HbDetailFragment", 1, "", e16);
                }
                retCodeAndGetBundle.putString("retdata", jSONObject.toString());
            }
            sendHBStateBroadcast();
        }
        finish();
    }

    public void getGuildAvatarUrls(ArrayList<String> arrayList) {
        HBUtil.getGuildUsersAvatarUrls(this.Q, arrayList, this.Y, new c(arrayList));
    }

    public void getGuildMemberNames(ArrayList<String> arrayList) {
        HBUtil.getGuildMemberNames(this.Q, arrayList, this.Y, new d());
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

    public void getNextPageData() {
        if (!this.J.getHasMore()) {
            com.tencent.mobileqq.qwallet.utils.f.a("HbDetailFragment", "no more hb receivers to request");
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

    @Override // com.tencent.mobileqq.qwallet.hb.detail.g
    public void go2DetailCard(@Nullable String str) {
        boolean z16;
        if (isInGuildAIO() || this.J.getHasTinyId() || HBUtil.isHbForFaceToFace(this.J.getChannel())) {
            return;
        }
        try {
            if (((IHbSkinApi) QRoute.api(IHbSkinApi.class)).isQCircleRedPocketSkin(this.H, this.I)) {
                ((IQWalletHbApi) QRoute.api(IQWalletHbApi.class)).doJumpAction(getContext(), "mqqapi://qcircle/openmainpage?uin=" + str);
            } else {
                if (!TextUtils.isEmpty(this.mGroupid)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                openFriendCard(str, HBUtil.isHbForAnonymity(this.J.getChannel()), z16);
            }
        } catch (Exception e16) {
            QLog.e("HbDetailFragment", 1, "go2DetailCard error", e16);
        }
    }

    void go2HbList() {
        Intent intent = new Intent();
        intent.putExtra("listid", this.T);
        intent.putExtra(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, this.U);
        launchFragment(intent, HbListActivity.class);
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
        if (this.V == 11) {
            return true;
        }
        return false;
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment
    protected boolean isStatusBarImmersive() {
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onBlError(String str, JSONObject jSONObject) {
        super.onBlError(str, jSONObject);
        handleRequestResult(str, jSONObject);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getActivity().setTheme(R.style.a6m);
        getDataParams();
        HbDetailModule.l("redpacket.show", String.valueOf(this.G), "", String.format("%s;%s;%s", Integer.valueOf(this.G), this.H, Integer.valueOf(this.I)));
        int hashCode = hashCode();
        this.Q = hashCode;
        HBUtil.initGuildObserver(this.Y, hashCode);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @androidx.annotation.Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @androidx.annotation.Nullable ViewGroup viewGroup, @androidx.annotation.Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.hir, viewGroup, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        int i3;
        String str;
        HbDetailRsp.HbSender sender = this.J.getSender();
        int channel = this.J.getChannel();
        if (sender != null) {
            i3 = sender.getBusiType();
        } else {
            i3 = -1;
        }
        String hbTypeText = HBUtil.getHbTypeText(channel, i3);
        String valueOf = String.valueOf(NetConnInfoCenter.getServerTimeMillis() - this.R);
        if (TextUtils.equals(String.valueOf(this.V), "11")) {
            str = this.Y;
        } else {
            str = this.U;
        }
        ((IReportApi) QRoute.api(IReportApi.class)).reportHongbaoTo644("redpack.get.showtime", String.valueOf(this.V), hbTypeText, valueOf, str);
        HBUtil.removeAllGuildCallBack(this.Q);
        super.onDestroy();
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Xh();
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

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ((HbSkinViewModel) new ViewModelProvider(requireActivity()).get(HbSkinViewModel.class)).b2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.qwallet.hb.detail.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HbDetailFragment.this.Th((Boolean) obj);
            }
        });
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(String str, JSONObject jSONObject) {
        super.onSuccess(str, jSONObject);
        handleRequestResult(str, jSONObject);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @androidx.annotation.Nullable Bundle bundle) {
        int i3;
        String str;
        super.onViewCreated(view, bundle);
        initView(view);
        Vh();
        initViewModel();
        loadData();
        this.R = NetConnInfoCenter.getServerTimeMillis();
        HbDetailRsp.HbSender sender = this.J.getSender();
        int channel = this.J.getChannel();
        if (sender != null) {
            i3 = sender.getBusiType();
        } else {
            i3 = -1;
        }
        String hbTypeText = HBUtil.getHbTypeText(channel, i3);
        if (TextUtils.equals(String.valueOf(this.V), "11")) {
            str = this.Y;
        } else {
            str = this.U;
        }
        ((IReportApi) QRoute.api(IReportApi.class)).reportHongbaoTo644("redpack.get.show", String.valueOf(this.V), hbTypeText, "", str);
    }
}
