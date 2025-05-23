package com.tenpay.sdk.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.qwallet.utils.QWalletUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletNickNameApi;
import com.tencent.mobileqq.qwallet.transaction.IToPayManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import com.tenpay.QwLog;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.activity.FriendPayActivity;
import com.tenpay.sdk.util.OnGetResult;
import com.tenpay.sdk.util.QQFaceFileUtil;
import com.tenpay.util.Utils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes27.dex */
public class FriendPayActivity extends NetBaseActivity implements View.OnClickListener {
    protected static final int BUYER_PAY_WAITER_VIEW = 1;
    protected static final int FRIENDPAY_OUT_TIME_VIEW = 3;
    protected static final int FRIENDPAY_SUCCESS_BY_BUYER_OTHER_VIEW = 5;
    protected static final int FRIENDPAY_SUCCESS_BY_BUYER_SELF_VIEW = 6;
    protected static final int FRIENDPAY_SUCCESS_BY_PAYER_VIEW = 4;
    private static final float MAX_PAYTYPE_ITEM = 3.5f;
    protected static final int WAITING_PAY_PAYER_VIEW = 2;
    protected static long mLeftTime;
    private TextView mAmountTv;
    private TextView mBackBtn;
    private ImageView mBuyerIcon;
    private TextView mBuyerListTitle;
    private TextView mBuyerOutTimeTips;
    private LinearLayout mBuyerPayLayout;
    private String mBuyerUinStr;
    private QQFaceFileUtil mFaceFileUtil;
    private TextView mFriendPayStateTips;
    private TextView mFriendPayStateTitle;
    private ListView mListView;
    private TextView mPayByBuyerTv;
    private PayerAdapter mPayerAdapter;
    private Button mPayerConfirmBtn;
    private JSONArray mPayerList;
    private TextView mPayerOutTimeTips;
    private LinearLayout mPayerPayLayout;
    private TextView mProductTv;
    private PaySuccessReceiver mReceiver;
    private RelativeLayout mRootLayout;
    protected Timer mTimer;
    private TextView mTitleTV;
    private int mViewIndex;
    private String pay_succ_uin;
    private String tokenIdForBroad;
    private ArrayList<String> uinList;
    private HashMap<String, String> mIconPath = new HashMap<>();
    private Myhandler mTimeHandler = new Myhandler(this);

    /* loaded from: classes27.dex */
    private class MyQQFaceFileListener implements OnGetResult {
        MyQQFaceFileListener() {
        }

        @Override // com.tenpay.sdk.util.OnGetResult
        public void getResult(Object obj) {
            if (obj != null && (obj instanceof HashMap)) {
                FriendPayActivity.this.mIconPath = (HashMap) obj;
                if (FriendPayActivity.this.mPayerAdapter != null) {
                    FriendPayActivity.this.mPayerAdapter.notifyDataSetChanged();
                }
                String str = (String) FriendPayActivity.this.mIconPath.get(FriendPayActivity.this.mBuyerUinStr);
                if (!TextUtils.isEmpty(str)) {
                    FriendPayActivity.this.mBuyerIcon.setImageBitmap(QQFaceFileUtil.getImageByPath(str, Utils.dp2Px(FriendPayActivity.this.getContext(), 34.0f)));
                }
                QwLog.i("payer path =" + FriendPayActivity.this.mIconPath.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes27.dex */
    public static class Myhandler extends Handler {
        WeakReference<FriendPayActivity> mWeakReference;

        public Myhandler(FriendPayActivity friendPayActivity) {
            this.mWeakReference = new WeakReference<>(friendPayActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            FriendPayActivity friendPayActivity = this.mWeakReference.get();
            if (friendPayActivity != null) {
                friendPayActivity.updateOutTime();
            }
        }
    }

    /* loaded from: classes27.dex */
    private class PaySuccessReceiver extends BroadcastReceiver {
        PaySuccessReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String stringExtra = intent.getStringExtra("tokenId");
                if (FriendPayActivity.this.tokenIdForBroad != null && FriendPayActivity.this.tokenIdForBroad.equals(stringExtra)) {
                    FriendPayActivity.this.sendOrderQueryRequest();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes27.dex */
    public class PayerAdapter extends BaseAdapter {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes27.dex */
        public class ViewHolder {
            ImageView mIcon;
            TextView mName;
            TextView mPayed;

            ViewHolder() {
            }
        }

        PayerAdapter() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Unit lambda$getView$0(ViewHolder viewHolder, String str, String str2) {
            if (!TextUtils.isEmpty(str2)) {
                viewHolder.mName.setText(str2 + "  (" + str + ")");
                StringBuilder sb5 = new StringBuilder();
                sb5.append("nick =");
                sb5.append(str2);
                QwLog.i(sb5.toString());
                return null;
            }
            return null;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (FriendPayActivity.this.mPayerList != null) {
                return FriendPayActivity.this.mPayerList.length();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2;
            final ViewHolder viewHolder;
            QwLog.i("getView");
            JSONObject item = getItem(i3);
            if (view == null) {
                viewHolder = new ViewHolder();
                View inflate = LayoutInflater.from(FriendPayActivity.this.getContext()).inflate(R.layout.adz, viewGroup, false);
                viewHolder.mIcon = (ImageView) inflate.findViewById(R.id.icon);
                viewHolder.mName = (TextView) inflate.findViewById(R.id.f5e);
                viewHolder.mPayed = (TextView) inflate.findViewById(R.id.fjx);
                inflate.setTag(viewHolder);
                view2 = inflate;
            } else {
                view2 = view;
                viewHolder = (ViewHolder) view.getTag();
            }
            if (item != null && FriendPayActivity.this.mFaceFileUtil != null) {
                final String optString = item.optString("payer_uin");
                ((IQWalletNickNameApi) QRoute.api(IQWalletNickNameApi.class)).getNickName(null, optString, new Function1() { // from class: com.tenpay.sdk.activity.at
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit lambda$getView$0;
                        lambda$getView$0 = FriendPayActivity.PayerAdapter.lambda$getView$0(FriendPayActivity.PayerAdapter.ViewHolder.this, optString, (String) obj);
                        return lambda$getView$0;
                    }
                });
                String str = (String) FriendPayActivity.this.mIconPath.get(optString);
                if (!TextUtils.isEmpty(str)) {
                    viewHolder.mIcon.setImageBitmap(QQFaceFileUtil.getImageByPath(str, Utils.dp2Px(FriendPayActivity.this.getContext(), 34.0f)));
                }
                if (!TextUtils.isEmpty(FriendPayActivity.this.pay_succ_uin) && FriendPayActivity.this.pay_succ_uin.equals(optString)) {
                    viewHolder.mPayed.setVisibility(0);
                } else {
                    viewHolder.mPayed.setVisibility(8);
                }
            }
            EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
            return view2;
        }

        @Override // android.widget.Adapter
        public JSONObject getItem(int i3) {
            if (FriendPayActivity.this.mPayerList != null) {
                return (JSONObject) FriendPayActivity.this.mPayerList.opt(i3);
            }
            return null;
        }
    }

    private void initView(View view) {
        TextView textView = (TextView) view.findViewById(R.id.ivTitleBtnLeft);
        this.mBackBtn = textView;
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) view.findViewById(R.id.ivTitleName);
        this.mTitleTV = textView2;
        textView2.setText(R.string.f171341e72);
        this.mProductTv = (TextView) view.findViewById(R.id.fzs);
        this.mAmountTv = (TextView) view.findViewById(R.id.fj7);
        this.mListView = (ListView) view.findViewById(R.id.anr);
        Button button = (Button) view.findViewById(R.id.cov);
        this.mPayerConfirmBtn = button;
        button.setOnClickListener(this);
        this.mPayerOutTimeTips = (TextView) view.findViewById(R.id.cow);
        this.mBuyerOutTimeTips = (TextView) view.findViewById(R.id.anu);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.root_layout);
        this.mRootLayout = relativeLayout;
        relativeLayout.setVisibility(8);
        this.mPayerPayLayout = (LinearLayout) view.findViewById(R.id.fjz);
        this.mBuyerPayLayout = (LinearLayout) view.findViewById(R.id.ant);
        this.mFriendPayStateTitle = (TextView) view.findViewById(R.id.coy);
        this.mFriendPayStateTips = (TextView) view.findViewById(R.id.cox);
        this.mBuyerIcon = (ImageView) view.findViewById(R.id.anp);
        TextView textView3 = (TextView) view.findViewById(R.id.ans);
        this.mPayByBuyerTv = textView3;
        textView3.setOnClickListener(this);
        this.mBuyerListTitle = (TextView) view.findViewById(R.id.anq);
    }

    private void loadPayerListData() {
        float count;
        if (this.mPayerAdapter == null) {
            this.mPayerAdapter = new PayerAdapter();
        }
        if (this.mPayerAdapter.getCount() > 3) {
            count = MAX_PAYTYPE_ITEM;
        } else {
            count = this.mPayerAdapter.getCount();
        }
        ViewGroup.LayoutParams layoutParams = this.mListView.getLayoutParams();
        layoutParams.height = Utils.dp2Px(getContext(), count * 46.5f);
        this.mListView.setLayoutParams(layoutParams);
        this.mListView.setAdapter((ListAdapter) this.mPayerAdapter);
        this.mBuyerListTitle.setText(String.format(getString(R.string.f171339e70), this.mPayerAdapter.getCount() + ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendOrderQueryRequest() {
        Intent intent = getIntent();
        if (intent != null) {
            HashMap hashMap = new HashMap();
            String stringExtra = intent.getStringExtra("extra_data");
            if (stringExtra != null) {
                try {
                    JSONObject jSONObject = new JSONObject(stringExtra);
                    hashMap.put("pfa_req", jSONObject.optString("pfa_req"));
                    this.tokenIdForBroad = jSONObject.optString("token_id");
                    hashMap.put("uin", this.mUin);
                    httpRequest(Cgi.URL_FRIENDPAY_ORDER_QUERY, hashMap);
                    return;
                } catch (JSONException e16) {
                    QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
                    return;
                }
            }
            setRetCodeAndErrorMsg(-101, "friendPay extra_data is empty!");
            finish();
        }
    }

    private void showViewByIndex(int i3, String str) {
        this.mViewIndex = i3;
        this.mRootLayout.setVisibility(0);
        this.mFriendPayStateTitle.setText(str);
        switch (i3) {
            case 1:
                loadPayerListData();
                this.mPayerOutTimeTips.setVisibility(8);
                this.mBuyerPayLayout.setVisibility(0);
                return;
            case 2:
                this.mBuyerListTitle.setVisibility(8);
                this.mPayerPayLayout.setVisibility(0);
                this.mBuyerPayLayout.setVisibility(8);
                return;
            case 3:
                if (this.mUin.equals(this.mBuyerUinStr)) {
                    uploadFriendPayData("friendpay.invaliepage.buyershow");
                } else {
                    uploadFriendPayData("friendpay.invaliepage.payershow");
                }
                this.mPayerPayLayout.setVisibility(8);
                this.mBuyerPayLayout.setVisibility(8);
                this.mListView.setVisibility(8);
                this.mBuyerListTitle.setVisibility(8);
                return;
            case 4:
                this.mFriendPayStateTitle.setTextColor(getResources().getColor(R.color.f157599ua));
                this.mBuyerListTitle.setVisibility(8);
                this.mPayerPayLayout.setVisibility(8);
                this.mBuyerPayLayout.setVisibility(8);
                return;
            case 5:
                loadPayerListData();
                this.mFriendPayStateTitle.setTextColor(getResources().getColor(R.color.f157599ua));
                this.mBuyerListTitle.setVisibility(0);
                this.mPayerPayLayout.setVisibility(8);
                this.mBuyerPayLayout.setVisibility(8);
                return;
            case 6:
                this.mFriendPayStateTitle.setTextColor(getResources().getColor(R.color.f157599ua));
                this.mFriendPayStateTips.setVisibility(0);
                this.mBuyerListTitle.setVisibility(8);
                this.mPayerPayLayout.setVisibility(8);
                this.mBuyerPayLayout.setVisibility(8);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateOutTime() {
        String str;
        long j3 = mLeftTime - 1;
        mLeftTime = j3;
        if (j3 > 0) {
            int i3 = ((int) j3) / 3600;
            long j16 = i3 * 3600;
            int i16 = ((int) (j3 - j16)) / 60;
            int i17 = ((int) (j3 - j16)) % 60;
            if (i3 != 0) {
                str = i3 + "\u65f6" + i16 + "\u5206" + i17 + "\u79d2";
            } else if (i16 != 0) {
                str = i16 + "\u5206" + i17 + "\u79d2";
            } else if (i17 != 0) {
                str = i17 + "\u79d2";
            } else {
                str = "";
            }
            SpannableString spannableString = new SpannableString(String.format(getString(R.string.e6u), str));
            spannableString.setSpan(new ClickableSpan() { // from class: com.tenpay.sdk.activity.FriendPayActivity.2
                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setUnderlineText(false);
                }

                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                }
            }, 6, str.length() + 6, 33);
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.f157652vr)), 6, str.length() + 6, 33);
            int i18 = this.mViewIndex;
            if (i18 == 1) {
                this.mBuyerOutTimeTips.setText(spannableString);
                return;
            } else {
                if (i18 == 2) {
                    this.mPayerOutTimeTips.setText(spannableString);
                    return;
                }
                return;
            }
        }
        closeTime();
        showViewByIndex(3, getString(R.string.e6v));
    }

    private void uploadFriendPayData(String str) {
        com.tencent.mobileqq.qwallet.c.c(str, Integer.valueOf(getProcessType()));
    }

    protected void closeTime() {
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
        }
        mLeftTime = 0L;
        this.mTimeHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            this.mBackBtn.performClick();
            return true;
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    protected void initTimer() {
        TimerTask timerTask = new TimerTask() { // from class: com.tenpay.sdk.activity.FriendPayActivity.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                FriendPayActivity.this.mTimeHandler.sendMessage(new Message());
            }
        };
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
            this.mTimer = null;
        }
        BaseTimer baseTimer = new BaseTimer();
        this.mTimer = baseTimer;
        baseTimer.schedule(timerTask, 0L, 1000L);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        QwLog.i("requestCode : " + i3 + "|" + i16);
        if (i3 == 1001 && i16 == -1) {
            sendOrderQueryRequest();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.ivTitleBtnLeft) {
            finish();
            getActivity().overridePendingTransition(0, R.anim.f154878es);
        } else if (view.getId() == R.id.ans || view.getId() == R.id.cov) {
            Intent intent = new Intent();
            intent.putExtra("token_id", this.mPayTokenId);
            intent.putExtra("isFriendPay", true);
            launchFragmentForResult(intent, PayActivity.class, 1001);
            if (view.getId() == R.id.ans) {
                uploadFriendPayData("friendpay.waitpaypage.ownpay");
            } else if (view.getId() == R.id.cov) {
                uploadFriendPayData("friendpay.waitpaypage.otherpay");
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            QWalletUtils.r(intent.getExtras());
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        PaySuccessReceiver paySuccessReceiver = new PaySuccessReceiver();
        this.mReceiver = paySuccessReceiver;
        registerReceiver(paySuccessReceiver, new IntentFilter(IToPayManager.BROADCAST_PAYER_NOTIFY));
        View inflate = layoutInflater.inflate(R.layout.ady, viewGroup, false);
        initView(inflate);
        this.mFaceFileUtil = new QQFaceFileUtil(new MyQQFaceFileListener());
        sendOrderQueryRequest();
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        closeTime();
        super.onDestroy();
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        unregisterReceiver(this.mReceiver);
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
        if (!isFinishing() && str.equals(Cgi.URL_FRIENDPAY_ORDER_QUERY)) {
            this.mPayTokenId = jSONObject.optString("token_id");
            this.mPayerList = jSONObject.optJSONArray("payer_list");
            this.mPayerAdapter = new PayerAdapter();
            this.mBuyerUinStr = jSONObject.optString("buyer_uin");
            JSONObject optJSONObject = jSONObject.optJSONObject("order");
            this.mProductTv.setText(optJSONObject.optString("desc", ""));
            this.mAmountTv.setText(Utils.fen2Yuan(optJSONObject.optString("total_fee", "0")));
            String optString = optJSONObject.optString("trade_state", "");
            mLeftTime = optJSONObject.optLong("pfa_expire_interval");
            if (this.uinList == null) {
                this.uinList = new ArrayList<>();
            }
            this.uinList.add(this.mBuyerUinStr);
            if (this.mPayerList != null) {
                for (int i3 = 0; i3 < this.mPayerList.length(); i3++) {
                    this.uinList.add(this.mPayerList.optJSONObject(i3).optString("payer_uin"));
                }
            }
            QwLog.i("icon data Source " + this.uinList.toString());
            this.mFaceFileUtil.getQQFaceImageList(this.uinList, getActivity());
            if ("PAYING".equals(optString)) {
                if (this.mUin.equals(this.mBuyerUinStr)) {
                    showViewByIndex(1, getString(R.string.e6p));
                } else {
                    showViewByIndex(2, getString(R.string.f171342e73));
                }
                if (mLeftTime > 0) {
                    initTimer();
                    return;
                } else {
                    showViewByIndex(3, getString(R.string.e6v));
                    return;
                }
            }
            if ("SUCCESS".equals(optString)) {
                String optString2 = optJSONObject.optString("pay_succ_uin");
                this.pay_succ_uin = optString2;
                if (!TextUtils.isEmpty(optString2)) {
                    if (this.mUin.equals(this.mBuyerUinStr)) {
                        if (this.mUin.equals(this.pay_succ_uin)) {
                            showViewByIndex(6, getString(R.string.e7e));
                            return;
                        } else {
                            showViewByIndex(5, getString(R.string.e7e));
                            return;
                        }
                    }
                    if (this.mUin.equals(this.pay_succ_uin)) {
                        showViewByIndex(4, getString(R.string.e7e));
                        return;
                    } else {
                        showViewByIndex(3, getString(R.string.e6w));
                        return;
                    }
                }
                return;
            }
            if ("UNAVAIL".equals(optString)) {
                String optString3 = jSONObject.optString("unavail_desc");
                if (TextUtils.isEmpty(optString3)) {
                    optString3 = getString(R.string.e6v);
                }
                showViewByIndex(3, optString3);
            }
        }
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
