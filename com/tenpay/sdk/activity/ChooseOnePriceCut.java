package com.tenpay.sdk.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tenpay.util.Utils;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes27.dex */
public class ChooseOnePriceCut extends NetBaseActivity {
    MainUi mMainUi;
    JSONObject mPayGateObj;
    JSONArray promotionArr;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes27.dex */
    public class MainUi implements View.OnClickListener, AdapterView.OnItemClickListener {
        TextView mCancleBtn;
        private PriceCutAdapter mListAdapter;
        ListView mListView;

        MainUi(View view) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams.setMargins(0, Utils.getScreenHeight(ChooseOnePriceCut.this.getContext()) - ChooseOnePriceCut.this.getIntent().getIntExtra("height", 0), 0, 0);
            view.setLayoutParams(layoutParams);
            TextView textView = (TextView) view.findViewById(R.id.f164724ap4);
            this.mCancleBtn = textView;
            textView.setOnClickListener(this);
            this.mListView = (ListView) view.findViewById(R.id.f166541fz2);
            PriceCutAdapter priceCutAdapter = new PriceCutAdapter();
            this.mListAdapter = priceCutAdapter;
            this.mListView.setAdapter((ListAdapter) priceCutAdapter);
            this.mListView.setOnItemClickListener(this);
            if (Integer.parseInt(Build.VERSION.SDK) >= 9) {
                this.mListView.setOverScrollMode(2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void adjustListLayout() {
            this.mListView.post(new Runnable() { // from class: com.tenpay.sdk.activity.ChooseOnePriceCut.MainUi.1
                @Override // java.lang.Runnable
                public void run() {
                    int intExtra;
                    int dp2Px;
                    if (ChoosePayTypeActivity.class.getSimpleName().equals(ChooseOnePriceCut.this.getIntent().getStringExtra("where"))) {
                        intExtra = ChooseOnePriceCut.this.getIntent().getIntExtra("height", 0);
                        dp2Px = Utils.dp2Px(ChooseOnePriceCut.this.getContext(), 70.0f);
                    } else {
                        intExtra = ChooseOnePriceCut.this.getIntent().getIntExtra("height", 0);
                        dp2Px = Utils.dp2Px(ChooseOnePriceCut.this.getContext(), 90.0f);
                    }
                    int i3 = intExtra - dp2Px;
                    if (MainUi.this.mListView.getHeight() > i3) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) MainUi.this.mListView.getLayoutParams();
                        layoutParams.height = i3;
                        MainUi.this.mListView.setLayoutParams(layoutParams);
                    }
                }
            });
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (view.getId() == R.id.f164724ap4) {
                ChooseOnePriceCut.this.finish();
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
            JSONObject jSONObject = (JSONObject) ((PriceCutAdapter) adapterView.getAdapter()).getItem(i3);
            TextView textView = (TextView) view.findViewById(R.id.k_b);
            Intent intent = new Intent();
            intent.putExtra("promo_txt", textView.getText().toString());
            intent.putExtra("promo_obj", jSONObject.toString());
            ChooseOnePriceCut.this.setResult(-1, intent);
            ChooseOnePriceCut.this.finish();
            EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
        }

        public void setListData(JSONArray jSONArray) {
            this.mListAdapter.setListData(jSONArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes27.dex */
    public class PriceCutAdapter extends BaseAdapter {
        private LayoutInflater mInflater;
        JSONArray promoArr;

        /* loaded from: classes27.dex */
        class ViewHold {
            ImageView btnArrow;
            TextView tvWord;

            ViewHold() {
            }
        }

        public PriceCutAdapter() {
            this.mInflater = LayoutInflater.from(ChooseOnePriceCut.this.getContext());
        }

        @Override // android.widget.Adapter
        public int getCount() {
            JSONArray jSONArray = this.promoArr;
            if (jSONArray == null) {
                return 0;
            }
            return jSONArray.length();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            return this.promoArr.optJSONObject(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            ViewHold viewHold;
            if (view != null && view.getTag() != null) {
                viewHold = (ViewHold) view.getTag();
            } else {
                viewHold = new ViewHold();
                view = this.mInflater.inflate(R.layout.afp, viewGroup, false);
                viewHold.tvWord = (TextView) view.findViewById(R.id.k_b);
                viewHold.btnArrow = (ImageView) view.findViewById(R.id.afl);
                view.setTag(viewHold);
            }
            JSONObject optJSONObject = this.promoArr.optJSONObject(i3);
            viewHold.tvWord.setText(ChooseOnePriceCut.this.getPromotionText(optJSONObject));
            String optString = optJSONObject.optString("promotion_id");
            if (optString != null && optString.equals(ChooseOnePriceCut.this.mPromotionId)) {
                viewHold.btnArrow.setVisibility(0);
            } else {
                viewHold.btnArrow.setVisibility(8);
            }
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view;
        }

        public void setListData(JSONArray jSONArray) {
            this.promoArr = jSONArray;
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getPromotionText(JSONObject jSONObject) {
        boolean z16;
        String string;
        if (jSONObject == null) {
            return "";
        }
        String optString = jSONObject.optString("promotion_fee");
        String optString2 = jSONObject.optString("discount_type");
        String optString3 = jSONObject.optString("promotion_type");
        String optString4 = jSONObject.optString("promotion_show");
        if (!TextUtils.isEmpty(this.mPromotionFlag) && this.mPromotionFlag.equals("1") && !TextUtils.isEmpty(optString3) && optString3.equals("1") && !TextUtils.isEmpty(optString2) && optString2.equals("2")) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (TextUtils.isEmpty(optString4)) {
                optString4 = getString(R.string.edc);
            }
        } else {
            if (TextUtils.isEmpty(this.mPromotionFlag) || !this.mPromotionFlag.equals("1") || TextUtils.isEmpty(optString) || Double.parseDouble(optString) <= 0.0d) {
                return "";
            }
            if (TextUtils.isEmpty(optString4)) {
                if (!TextUtils.isEmpty(optString3) && optString3.equals("1")) {
                    string = getString(R.string.ecb);
                } else {
                    string = getString(R.string.eca);
                }
                optString4 = String.format(string, Utils.fen2Yuan(optString));
            }
        }
        return optString4;
    }

    private void initData() {
        try {
            this.promotionArr = new JSONArray(getIntent().getStringExtra("promotion_list"));
            String stringExtra = getIntent().getStringExtra("pay_gate");
            if (!Utils.isEmpty(stringExtra)) {
                this.mPayGateObj = new JSONObject(stringExtra);
            }
            this.mMainUi.setListData(this.promotionArr);
        } catch (Exception e16) {
            QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.ade, viewGroup, false);
        this.mMainUi = new MainUi(inflate.findViewById(R.id.f166813if0));
        initData();
        this.mMainUi.adjustListLayout();
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
