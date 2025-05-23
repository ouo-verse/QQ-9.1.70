package com.tenpay.sdk.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tenpay.api.BankImageUtil;
import com.tenpay.sdk.net.NetParams;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes27.dex */
public class TenpayPluginSelectBankActivity extends TenpayUtilActivity {
    private CustomAdapter mAdapter;
    Map<String, BankData> mBankInfo = new LinkedHashMap();
    private boolean mForgetPassFlag;
    private ListView mList;
    protected int mProgressType;

    /* loaded from: classes27.dex */
    public static class BankData {
        public JSONObject credit;
        public JSONObject debit;
        public String name;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes27.dex */
    public class CustomAdapter extends BaseAdapter {
        private LayoutInflater mInflater;

        /* loaded from: classes27.dex */
        class ViewHolder {
            ImageView bankImage;
            TextView bankName;

            ViewHolder() {
            }
        }

        public CustomAdapter(Activity activity) {
            this.mInflater = LayoutInflater.from(activity);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            Map<String, BankData> map = TenpayPluginSelectBankActivity.this.mBankInfo;
            if (map != null) {
                return map.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            return Integer.valueOf(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2;
            ViewHolder viewHolder;
            if (view == null) {
                viewHolder = new ViewHolder();
                View inflate = this.mInflater.inflate(R.layout.f168576ad3, viewGroup, false);
                viewHolder.bankName = (TextView) inflate.findViewById(R.id.a56);
                viewHolder.bankImage = (ImageView) inflate.findViewById(R.id.f164571a54);
                inflate.setTag(viewHolder);
                view2 = inflate;
            } else {
                view2 = view;
                viewHolder = (ViewHolder) view.getTag();
            }
            Map<String, BankData> map = TenpayPluginSelectBankActivity.this.mBankInfo;
            BankData bankData = map.get(map.keySet().toArray()[i3]);
            viewHolder.bankName.setText(bankData.name);
            if (bankData.credit != null) {
                BankImageUtil.getInstance(TenpayPluginSelectBankActivity.this.getContext()).setBankImage(bankData.credit.optString("image_id"), viewHolder.bankImage);
            } else if (bankData.debit != null) {
                BankImageUtil.getInstance(TenpayPluginSelectBankActivity.this.getContext()).setBankImage(bankData.debit.optString("image_id"), viewHolder.bankImage);
            }
            EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
            return view2;
        }
    }

    protected void addTraceData(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.mIsMidas) {
            stringBuffer.append("tenpay.choose.bank.");
        } else {
            stringBuffer.append("bind.bank.");
        }
        stringBuffer.append(str);
        com.tencent.mobileqq.qwallet.c.c(stringBuffer.toString(), Integer.valueOf(this.mProgressType));
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            setResult(0, new Intent());
        }
        addTraceData("keyback");
        return super.doOnKeyDown(i3, keyEvent);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    protected void initBanks(JSONObject jSONObject) {
        BankData bankData;
        JSONArray optJSONArray = jSONObject.optJSONArray("banklist");
        int length = optJSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
            String optString = optJSONObject.optString("type");
            if (!"DEBIT".equals(optString) && !"CREDIT".equals(optString)) {
                String optString2 = optJSONObject.optString("sname");
                if (this.mBankInfo.containsKey(optString2)) {
                    bankData = this.mBankInfo.get(optString2);
                } else {
                    BankData bankData2 = new BankData();
                    String optString3 = optJSONObject.optString("name");
                    int indexOf = optString3.indexOf(45);
                    if (indexOf > 0) {
                        bankData2.name = optString3.substring(0, indexOf);
                    } else {
                        bankData2.name = optString3;
                    }
                    this.mBankInfo.put(optString2, bankData2);
                    bankData = bankData2;
                }
                if (!NetParams.DEBIT_UNBIND.equals(optString) && !NetParams.DEBIT_FAST.equals(optString)) {
                    bankData.credit = optJSONObject;
                } else {
                    bankData.debit = optJSONObject;
                }
            }
        }
        CustomAdapter customAdapter = new CustomAdapter(getActivity());
        this.mAdapter = customAdapter;
        this.mList.setAdapter((ListAdapter) customAdapter);
        this.mList.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.tenpay.sdk.activity.TenpayPluginSelectBankActivity.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i16, long j3) {
                EventCollector.getInstance().onItemClickBefore(adapterView, view, i16, j3);
                BankData bankData3 = TenpayPluginSelectBankActivity.this.mBankInfo.get(TenpayPluginSelectBankActivity.this.mBankInfo.keySet().toArray()[i16]);
                TenpayPluginSelectBankActivity tenpayPluginSelectBankActivity = TenpayPluginSelectBankActivity.this;
                if (tenpayPluginSelectBankActivity.mIsMidas) {
                    tenpayPluginSelectBankActivity.addTraceData(bankData3.name);
                } else {
                    tenpayPluginSelectBankActivity.addTraceData("get");
                }
                Intent intent = new Intent();
                intent.putExtra("process_flag", TenpayPluginSelectBankActivity.this.mProgressType);
                intent.putExtra("forget_pass", TenpayPluginSelectBankActivity.this.mForgetPassFlag);
                JSONObject jSONObject2 = bankData3.credit;
                if (jSONObject2 != null) {
                    intent.putExtra("credit", jSONObject2.toString());
                }
                JSONObject jSONObject3 = bankData3.debit;
                if (jSONObject3 != null) {
                    intent.putExtra("debit", jSONObject3.toString());
                }
                TenpayPluginSelectBankActivity.this.launchFragmentForResult(intent, TenpayPluginSelectBankTypeActivity.class, 0);
                EventCollector.getInstance().onItemClick(adapterView, view, i16, j3);
            }
        });
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (i16 > 0) {
            setResult(i16, intent);
            finish();
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.ad5, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.ivTitleName)).setText(R.string.e_2);
        ((TextView) inflate.findViewById(R.id.ivTitleBtnLeft)).setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.TenpayPluginSelectBankActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                TenpayPluginSelectBankActivity.this.addTraceData("back");
                TenpayPluginSelectBankActivity.this.finish();
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        this.mList = (ListView) inflate.findViewById(R.id.im6);
        Intent intent = getIntent();
        try {
            this.mProgressType = intent.getIntExtra("process_flag", -1);
            this.mForgetPassFlag = intent.getBooleanExtra("forget_pass", false);
            initBanks(new JSONObject(intent.getStringExtra("bank_data")));
        } catch (Exception unused) {
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        addTraceData("show");
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
