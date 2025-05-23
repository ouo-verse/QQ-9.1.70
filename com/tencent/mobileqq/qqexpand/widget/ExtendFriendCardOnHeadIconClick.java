package com.tencent.mobileqq.qqexpand.widget;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qqexpand.bean.chat.ExpandFriendData;
import com.tencent.mobileqq.qqexpand.bean.profile.ExpandUserInfo;
import com.tencent.mobileqq.qqexpand.chat.utils.LimitChatUtil;
import com.tencent.mobileqq.qqexpand.entrance.IExpandFragmentRouter;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qqexpand.utils.s;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RoundedCornerImageViewNoPadding;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReport_UserInfo_dc02148;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ExtendFriendCardOnHeadIconClick extends QPublicBaseFragment {
    public static LRUCache<String, String> W = new LRUCache<>(10);
    public static HashMap<String, Long> X = new HashMap<>();
    private String C;
    private String D;
    private int E;
    private String F;
    private List<String> G;
    private List<String> H;
    private String I;
    private int J;
    private String K;
    private String L;
    private boolean M = false;
    private JSONObject N;
    private String P;
    private String Q;
    private int R;
    private int S;
    private Semaphore T;
    private BaseQQAppInterface U;
    private View V;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ExtendFriendCardOnHeadIconClick extendFriendCardOnHeadIconClick = ExtendFriendCardOnHeadIconClick.this;
            extendFriendCardOnHeadIconClick.Sh("click", "data_cpage", "complaint", extendFriendCardOnHeadIconClick.S);
            ExtendFriendCardOnHeadIconClick.this.Kh();
            ExtendFriendCardOnHeadIconClick.this.Ih();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.putExtra("key_extend_friend_info_json", ExtendFriendCardOnHeadIconClick.this.P);
            ((IExpandFragmentRouter) QRoute.api(IExpandFragmentRouter.class)).launchNewEditFragmentForResult(ExtendFriendCardOnHeadIconClick.this.getQBaseActivity(), intent, 8000);
            ExtendFriendCardOnHeadIconClick.this.Vh();
            ExtendFriendCardOnHeadIconClick extendFriendCardOnHeadIconClick = ExtendFriendCardOnHeadIconClick.this;
            extendFriendCardOnHeadIconClick.Sh("click", "data_page", "edit_data_btn", extendFriendCardOnHeadIconClick.S);
            ExtendFriendCardOnHeadIconClick.this.Ih();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriendForResult(ExtendFriendCardOnHeadIconClick.this.getActivity(), ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(ExtendFriendCardOnHeadIconClick.this.getActivity(), 1, ExtendFriendCardOnHeadIconClick.this.Q, null, ExtendFriendCardOnHeadIconClick.this.Mh(), ExpandUserInfo.getReportSubId(ExtendFriendCardOnHeadIconClick.this.R), ExtendFriendCardOnHeadIconClick.this.D, null, null, null, null), 1);
            ExtendFriendCardOnHeadIconClick.this.Vh();
            ExtendFriendCardOnHeadIconClick extendFriendCardOnHeadIconClick = ExtendFriendCardOnHeadIconClick.this;
            extendFriendCardOnHeadIconClick.Sh("click", "data_cpage", "add_friends_all", extendFriendCardOnHeadIconClick.S);
            ExtendFriendCardOnHeadIconClick.this.Ih();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ExtendFriendCardOnHeadIconClick.this.Ih();
        }
    }

    private void Hh() throws JSONException {
        JSONArray optJSONArray;
        JSONObject optJSONObject = new JSONObject(this.P).optJSONObject("infos");
        this.C = optJSONObject.optString("avatar");
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("base_info");
        if (optJSONObject2 != null) {
            this.D = optJSONObject2.optString("nick");
            this.F = optJSONObject2.optString(LpReport_UserInfo_dc02148.CONSTELLATION);
            this.E = optJSONObject2.optInt("gender");
        }
        JSONObject optJSONObject3 = optJSONObject.optJSONObject("expand_info");
        if (optJSONObject3 != null) {
            this.I = optJSONObject3.optString("declarationa");
            this.K = optJSONObject3.optString("voice_url");
            this.J = optJSONObject3.optInt("voice_duration");
            this.L = optJSONObject3.optString("voice_color");
        }
        JSONArray optJSONArray2 = optJSONObject.optJSONArray("personal_labels");
        if (optJSONArray2 != null) {
            for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                this.G.add(optJSONArray2.optString(i3));
            }
        }
        JSONObject optJSONObject4 = optJSONObject.optJSONObject("pictures_wall_urls");
        if (optJSONObject4 != null && (optJSONArray = optJSONObject4.optJSONArray("pictures_wall_pic")) != null) {
            for (int i16 = 0; i16 < optJSONArray.length(); i16++) {
                this.H.add(optJSONArray.optString(i16));
            }
        }
        boolean has = optJSONObject.has("wangzhe_record");
        this.M = has;
        if (has) {
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("wangzhe_record");
            this.N = optJSONObject5;
            if (optJSONObject5.length() == 0) {
                this.M = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ih() {
        final TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        translateAnimation.setDuration(400L);
        this.V.post(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.widget.ExtendFriendCardOnHeadIconClick.6
            @Override // java.lang.Runnable
            public void run() {
                ((FrameLayout) ExtendFriendCardOnHeadIconClick.this.V.findViewById(R.id.ozb)).startAnimation(translateAnimation);
            }
        });
        this.V.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.widget.ExtendFriendCardOnHeadIconClick.7
            @Override // java.lang.Runnable
            public void run() {
                ExtendFriendCardOnHeadIconClick.this.V.setVisibility(8);
                if (ExtendFriendCardOnHeadIconClick.this.getActivity() != null) {
                    ExtendFriendCardOnHeadIconClick.this.getActivity().finish();
                }
            }
        }, 400L);
    }

    private void Jh() {
        final TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(400L);
        this.V.post(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.widget.ExtendFriendCardOnHeadIconClick.5
            @Override // java.lang.Runnable
            public void run() {
                ExtendFriendCardOnHeadIconClick.this.V.setVisibility(0);
                FrameLayout frameLayout = (FrameLayout) ExtendFriendCardOnHeadIconClick.this.V.findViewById(R.id.ozb);
                frameLayout.setVisibility(0);
                frameLayout.startAnimation(translateAnimation);
                if (ExtendFriendCardOnHeadIconClick.this.Ph()) {
                    ExtendFriendCardOnHeadIconClick extendFriendCardOnHeadIconClick = ExtendFriendCardOnHeadIconClick.this;
                    extendFriendCardOnHeadIconClick.Sh("expose", "data_page", "view", extendFriendCardOnHeadIconClick.S);
                } else {
                    ExtendFriendCardOnHeadIconClick extendFriendCardOnHeadIconClick2 = ExtendFriendCardOnHeadIconClick.this;
                    extendFriendCardOnHeadIconClick2.Sh("expose", "data_cpage", "view", extendFriendCardOnHeadIconClick2.S);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kh() {
        NewReportPlugin.V(getQBaseActivity(), 1044, this.Q, getQBaseActivity().getCurrentAccountUinFromRuntime(), null);
    }

    private void Lh() {
        if (this.H.size() == 1) {
            return;
        }
        int dpToPx = ViewUtils.dpToPx(2.0f);
        LinearLayout linearLayout = (LinearLayout) this.V.findViewById(R.id.p0q);
        linearLayout.removeAllViews();
        int dpToPx2 = ViewUtils.dpToPx(2.0f);
        int dpToPx3 = ViewUtils.dpToPx(10.0f);
        int size = this.H.size() - 1;
        while (size > 0) {
            RoundCornerImageView roundCornerImageView = new RoundCornerImageView(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewUtils.dpToPx(34.0f), ViewUtils.dpToPx(34.0f));
            layoutParams.rightMargin = size == 1 ? dpToPx3 : dpToPx2;
            roundCornerImageView.setLayoutParams(layoutParams);
            roundCornerImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            roundCornerImageView.setImageDrawable(URLDrawable.getDrawable(this.H.get(size), (URLDrawable.URLDrawableOptions) null));
            roundCornerImageView.setCorner(dpToPx, dpToPx, dpToPx, dpToPx);
            roundCornerImageView.setBorder(true);
            roundCornerImageView.setBorderWidth(ViewUtils.dpToPx(0.5f));
            roundCornerImageView.setColor(-1);
            roundCornerImageView.setVisibility(0);
            Oh(roundCornerImageView, size);
            linearLayout.addView(roundCornerImageView);
            size--;
        }
        linearLayout.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Mh() {
        return 3094;
    }

    private void Nh() {
        if (this.Q.equals(this.U.getCurrentUin())) {
            this.R = 0;
        } else {
            this.R = ExpandFriendData.getMatchSrc(this.U, this.Q);
        }
    }

    private void Oh(View view, int i3) {
        List<String> list = this.H;
        if (list == null || list.isEmpty()) {
            return;
        }
        Uh(view, i3, (ArrayList) this.H);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ph() {
        return this.Q.equals(getQBaseActivity().getCurrentAccountUinFromRuntime());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Qh() {
        try {
            if (this.T.tryAcquire(30000L, TimeUnit.MILLISECONDS)) {
                Hh();
                getQBaseActivity().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.widget.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        ExtendFriendCardOnHeadIconClick.this.lambda$onCreateView$0();
                    }
                });
                this.T.release();
            }
        } catch (InterruptedException e16) {
            QLog.e("ExtendFriendCardOnHeadIconClick", 1, "semaphore interrupted!", e16);
        } catch (JSONException e17) {
            QLog.e("ExtendFriendCardOnHeadIconClick", 1, "bindData error!", e17);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Rh(int i3, ArrayList arrayList, View view, View view2) {
        Vh();
        if (Ph()) {
            Sh("click", "data_page", "photos", this.S);
        } else {
            Sh("click", "data_cpage", "photos", this.S);
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("index", i3);
        bundle.putStringArrayList(TroopAvatarWallPreviewActivity.KEY_SEQ_NUM, arrayList);
        bundle.putBoolean("from_photo_wall", true);
        bundle.putBoolean("SHOW_MENU", true);
        bundle.putBoolean("IS_EDIT", false);
        bundle.putBoolean("is_use_path", true);
        bundle.putBoolean("is_show_action", true);
        bundle.putBoolean(TroopAvatarWallPreviewActivity.KEY_IS_NOT_SHOW_INDEX, true);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        arrayList2.add(Integer.valueOf(iArr[0]));
        arrayList2.add(Integer.valueOf(iArr[1]));
        arrayList2.add(Integer.valueOf(view.getWidth()));
        arrayList2.add(Integer.valueOf(view.getHeight()));
        bundle.putIntegerArrayList("mPreviewPhotoLocation", arrayList2);
        intent.putExtras(bundle);
        RouteUtils.startActivity(getQBaseActivity(), intent, RouterConstants.UI_ROUTE_OPEN_TROOP_AVATAR_WALL_PREVIEW_ACTIVITY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sh(String str, String str2, String str3, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("frompage", Integer.toString(i3));
        ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel(str.concat("#").concat(str2).concat("#").concat(str3), true, -1L, -1L, hashMap, true, true);
    }

    private void Th() {
        LimitChatUtil.Y(this.U, Long.valueOf(Long.parseLong(this.Q)), new e());
    }

    private void initUI() {
        if (!Ph()) {
            ImageView imageView = (ImageView) this.V.findViewById(R.id.p18);
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.gew));
            imageView.setVisibility(0);
            RelativeLayout relativeLayout = (RelativeLayout) this.V.findViewById(R.id.p17);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ViewUtils.dpToPx(207.0f));
            layoutParams.topMargin = ViewUtils.dpToPx(8.0f);
            layoutParams.leftMargin = 0;
            relativeLayout.setLayoutParams(layoutParams);
            imageView.setOnClickListener(new a());
        }
        RoundedCornerImageViewNoPadding roundedCornerImageViewNoPadding = (RoundedCornerImageViewNoPadding) this.V.findViewById(R.id.p08);
        roundedCornerImageViewNoPadding.setCorner(ViewUtils.dpToPx(4.0f));
        List<String> list = this.H;
        if (list != null && !list.isEmpty()) {
            roundedCornerImageViewNoPadding.setImageDrawable(URLDrawable.getDrawable(this.H.get(0), (URLDrawable.URLDrawableOptions) null));
            Lh();
        }
        Oh(roundedCornerImageViewNoPadding, 0);
        ImageView imageView2 = (ImageView) this.V.findViewById(R.id.ozs);
        String str = this.C;
        if (str != null && !TextUtils.isEmpty(str)) {
            URLDrawable drawable = URLDrawable.getDrawable(this.C, (URLDrawable.URLDrawableOptions) null);
            drawable.setDecodeHandler(s.f264111a);
            imageView2.setImageDrawable(drawable);
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(this.C);
            Uh(imageView2, 0, arrayList);
        }
        TextView textView = (TextView) this.V.findViewById(R.id.p0i);
        textView.setText(this.D);
        textView.setTextColor(-16777216);
        textView.setTextSize(20.0f);
        ImageView imageView3 = (ImageView) this.V.findViewById(R.id.ozk);
        TextView textView2 = (TextView) this.V.findViewById(R.id.p2f);
        LinearLayout linearLayout = (LinearLayout) this.V.findViewById(R.id.ozl);
        int i3 = this.E;
        if (i3 == 1) {
            imageView3.setImageDrawable(getResources().getDrawable(R.drawable.f159763gf1));
            linearLayout.setBackgroundResource(R.drawable.f159765gf3);
        } else if (i3 == 2) {
            imageView3.setImageDrawable(getResources().getDrawable(R.drawable.f159762gf0));
            linearLayout.setBackgroundColor(getResources().getColor(R.color.f7554k));
        } else {
            imageView3.setVisibility(8);
            textView2.setVisibility(8);
        }
        TextView textView3 = (TextView) this.V.findViewById(R.id.oyt);
        String str2 = this.F;
        if (str2 != null && !TextUtils.isEmpty(str2)) {
            textView3.setText(this.F);
            textView3.setTextSize(12.0f);
            textView2.setTextSize(12.0f);
            if (this.E == 2) {
                textView3.setTextColor(getResources().getColor(R.color.f7534i));
                textView2.setTextColor(getResources().getColor(R.color.f7574m));
            } else {
                textView3.setTextColor(getResources().getColor(R.color.f7524h));
                textView2.setTextColor(getResources().getColor(R.color.f7564l));
            }
        } else {
            textView3.setVisibility(8);
            textView2.setVisibility(8);
            ((LinearLayout.LayoutParams) imageView3.getLayoutParams()).rightMargin = ViewUtils.dpToPx(4.0f);
        }
        String str3 = this.I;
        if (str3 != null && !TextUtils.isEmpty(str3)) {
            TextView textView4 = (TextView) this.V.findViewById(R.id.oyw);
            textView4.setText(this.I);
            textView4.setMaxLines(4);
            textView4.setVisibility(0);
        }
        View findViewById = this.V.findViewById(R.id.ozx);
        if (!this.M) {
            findViewById.setVisibility(8);
        } else {
            ((ExtendFriendHonorOfKingRecordView) this.V.findViewById(R.id.ozh)).setData(this.N);
            findViewById.setVisibility(0);
        }
        LinearLayout linearLayout2 = (LinearLayout) this.V.findViewById(R.id.oza);
        linearLayout2.setBackgroundColor(Color.rgb(0, 0, 0));
        linearLayout2.getBackground().setAlpha(127);
        TextView textView5 = (TextView) this.V.findViewById(R.id.oya);
        if (Ph()) {
            textView5.setText(R.string.x6q);
            textView5.setOnClickListener(new b());
        } else {
            textView5.setText(R.string.x6n);
            textView5.setOnClickListener(new c());
        }
        textView5.setTextColor(-1);
        textView5.setTextSize(17.0f);
        textView5.setGravity(17);
        ((LinearLayout) this.V.findViewById(R.id.f163240p22)).setOnClickListener(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0() {
        initUI();
        Jh();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.G = new ArrayList();
        this.H = new ArrayList();
        this.T = new Semaphore(1);
        this.U = (BaseQQAppInterface) getQBaseActivity().getAppRuntime();
        Intent intent = getActivity().getIntent();
        this.Q = intent.getStringExtra(IProfileProtocolConst.PARAM_TARGET_UIN);
        this.S = intent.getIntExtra("fromPage", 0);
        if (LRUCache.shouldRefreshData(this.Q)) {
            LRUCache.removeOutDatedData(this.Q);
        }
        this.P = W.get(this.Q);
        Nh();
        String str = this.P;
        if ((str == null || TextUtils.isEmpty(str)) && this.T.tryAcquire()) {
            Th();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendCardOnHeadIconClick", 2, "[fragment]onFinish: invoked. this: " + this + " activity: " + getActivity());
        }
        super.onFinish();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.overridePendingTransition(0, R.anim.f154345g2);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean overrideFinish() {
        boolean overrideFinish = super.overrideFinish();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.overridePendingTransition(0, R.anim.f154345g2);
        }
        Vh();
        return overrideFinish;
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public static class LRUCache<K, V> extends LinkedHashMap<K, V> {
        private int size;

        static void removeOutDatedData(String str) {
            ExtendFriendCardOnHeadIconClick.X.remove(str);
            ExtendFriendCardOnHeadIconClick.W.remove(str);
        }

        static boolean shouldRefreshData(String str) {
            if (ExtendFriendCardOnHeadIconClick.X.containsKey(str)) {
                return System.currentTimeMillis() - ExtendFriendCardOnHeadIconClick.X.get(str).longValue() > TimeUnit.SECONDS.toMillis(30L);
            }
            return false;
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
            if (size() <= this.size) {
                return false;
            }
            ExtendFriendCardOnHeadIconClick.X.remove(entry.getKey());
            return true;
        }

        LRUCache(int i3) {
            super(i3, 0.75f, true);
            this.size = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class e extends ExpandObserver {
        e() {
        }

        @Override // com.tencent.mobileqq.qqexpand.network.ExpandObserver
        protected void q(boolean z16, Object obj, int i3) {
            if (i3 != 32 && i3 != 33) {
                QLog.e("ExtendFriendCardOnHeadIconClick", 1, "error! type must be either 32 or 33");
                return;
            }
            if (z16 && obj != null) {
                ExtendFriendCardOnHeadIconClick.this.P = (String) obj;
                ExtendFriendCardOnHeadIconClick.this.T.release();
                LimitChatUtil.E(ExtendFriendCardOnHeadIconClick.this.U, ExtendFriendCardOnHeadIconClick.this.Q, obj);
                return;
            }
            QLog.w("ExtendFriendCardOnHeadIconClick", 1, "onPreLoadDataForAvatarProfileCard network error, data is null");
        }
    }

    private void Uh(final View view, final int i3, final ArrayList<String> arrayList) {
        if (view == null || arrayList == null || arrayList.size() == 0) {
            return;
        }
        if (i3 < 0 || i3 >= arrayList.size()) {
            i3 = 0;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqexpand.widget.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ExtendFriendCardOnHeadIconClick.this.Rh(i3, arrayList, view, view2);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.V = layoutInflater.inflate(R.layout.czs, viewGroup, false);
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.widget.f
            @Override // java.lang.Runnable
            public final void run() {
                ExtendFriendCardOnHeadIconClick.this.Qh();
            }
        });
        return this.V;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        if (i3 != 8000) {
            return;
        }
        if (i16 == -1) {
            if (intent != null && intent.getStringExtra("key_extend_friend_info_json") != null) {
                this.P = intent.getStringExtra("key_extend_friend_info_json");
                this.H.clear();
                W.put(this.U.getCurrentUin(), this.P);
                try {
                    Hh();
                    initUI();
                    this.V.postInvalidate();
                    return;
                } catch (JSONException e16) {
                    e16.printStackTrace();
                    return;
                }
            }
            QLog.e("ExtendFriendCardOnHeadIconClick", 1, "intent data is empty!");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ExtendFriendCardOnHeadIconClick", 2, "didn't set data successfully!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vh() {
    }
}
