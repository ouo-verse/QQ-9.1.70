package com.tencent.mobileqq.mini.mainpage;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.compat.f;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForMini;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.mainpage.PhoneNumberManageAdapter;
import com.tencent.mobileqq.mini.report.MiniGetPhoneNumberReporter;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeServlet;
import com.tencent.mobileqq.mini.util.ResourceUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class PhoneNumberManagementFragment extends PublicBaseFragment implements View.OnClickListener {
    public static final String TAG = "PhoneNumberManagementFragment";
    private PhoneNumberManageItem mAddPhoneNumberItem;
    private String mAppId;
    private ImageView mLeftBtnView;
    private TextView mPhoneNumberComplaint;
    private TextView mPhoneNumberControlTv;
    private PhoneNumberManageAdapter mPhoneNumberManageAdapter;
    private PhoneNumberResultListener mPhoneNumberResultListener;
    private RecyclerView mPhoneNumberRv;
    private JSONArray mPhoneNumberArray = new JSONArray();
    private List<PhoneNumberManageItem> mPhoneNumberItems = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes33.dex */
    public class PhoneNumberResultListener implements MiniAppController.ActivityResultListener {
        PhoneNumberResultListener() {
        }

        @Override // com.tencent.mobileqq.mini.sdk.MiniAppController.ActivityResultListener
        public boolean doOnActivityResult(int i3, int i16, Intent intent) {
            QLog.d("PhoneNumberManagementFragment", 2, "doOnActivityResult : " + i3);
            if (i3 != 1090) {
                return false;
            }
            if (i16 != -1) {
                QLog.e("PhoneNumberManagementFragment", 1, "REQUEST_CODE_ADD_PHONENUMBER " + i16);
            } else if (intent != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("phoneType", 1);
                    jSONObject.put("purePhoneNumber", intent.getStringExtra(MiniAppSendSmsCodeServlet.KEY_PHONE_NUMBER));
                    jSONObject.put("countryCode", "+86");
                    jSONObject.put("iv", intent.getStringExtra("iv"));
                    jSONObject.put(MiniConst.MiniAppCmdUtilConst.ENCRYPTED_DATA, intent.getStringExtra(MiniConst.MiniAppCmdUtilConst.ENCRYPTED_DATA));
                    jSONObject.put(MiniConst.MiniAppCmdUtilConst.PHONE_NUMBER_ID, intent.getStringExtra(MiniConst.MiniAppCmdUtilConst.PHONE_NUMBER_ID));
                    if (PhoneNumberManagementFragment.this.mPhoneNumberArray != null) {
                        QLog.d("PhoneNumberManagementFragment", 1, "mPhoneNumberArray put : " + jSONObject);
                        PhoneNumberManagementFragment.this.mPhoneNumberArray.mo162put(jSONObject);
                        PhoneNumberManagementFragment.this.addPhoneNumberData(jSONObject);
                        PhoneNumberManagementFragment.this.mPhoneNumberManageAdapter.updateData(PhoneNumberManagementFragment.this.mPhoneNumberItems);
                        QLog.d(PhoneNumberManageAdapter.TAG, 1, "setActivityResultListener notifyDataSetChanged size:" + PhoneNumberManagementFragment.this.mPhoneNumberItems.size());
                    }
                } catch (Throwable th5) {
                    QLog.e("PhoneNumberManagementFragment", 1, "REQUEST_CODE_ADD_PHONENUMBER error, ", th5);
                }
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPhoneNumberData(JSONObject jSONObject) {
        List<PhoneNumberManageItem> list = this.mPhoneNumberItems;
        if (list == null || list.isEmpty()) {
            return;
        }
        PhoneNumberManageItem phoneNumberManageItem = new PhoneNumberManageItem();
        phoneNumberManageItem.setPhoneType(jSONObject.optInt("phoneType"));
        phoneNumberManageItem.setPurePhoneNumber(jSONObject.optString("purePhoneNumber"));
        phoneNumberManageItem.setCountryCode(jSONObject.optString("countryCode"));
        phoneNumberManageItem.setEncryptedData(jSONObject.optString(MiniConst.MiniAppCmdUtilConst.ENCRYPTED_DATA));
        phoneNumberManageItem.setIv(jSONObject.optString("iv"));
        phoneNumberManageItem.setPhoneNumberID(jSONObject.optString(MiniConst.MiniAppCmdUtilConst.PHONE_NUMBER_ID));
        phoneNumberManageItem.setItemType(0);
        this.mPhoneNumberItems.add(r3.size() - 1, phoneNumberManageItem);
    }

    private void deletePhoneNumberData(String str) {
        int length = this.mPhoneNumberArray.length();
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            if (str.equals(this.mPhoneNumberArray.optJSONObject(i3).optString(MiniConst.MiniAppCmdUtilConst.PHONE_NUMBER_ID))) {
                this.mPhoneNumberArray.remove(i3);
                break;
            }
            i3++;
        }
        Iterator<PhoneNumberManageItem> it = this.mPhoneNumberItems.iterator();
        while (it.hasNext()) {
            if (it.next().getPhoneNumberID().equals(str)) {
                it.remove();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendDelRequest$2(String str) {
        deletePhoneNumberData(str);
        this.mPhoneNumberManageAdapter.updateData(this.mPhoneNumberItems);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendDelRequest$3(final String str, boolean z16, JSONObject jSONObject) {
        QLog.d("PhoneNumberManagementFragment", 1, "isSuc : " + z16 + "; ret : " + jSONObject + "; phoneNumberId : " + str);
        if (z16) {
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.mini.mainpage.e
                @Override // java.lang.Runnable
                public final void run() {
                    PhoneNumberManagementFragment.this.lambda$sendDelRequest$2(str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setPhoneNumberList$0(View view) {
        Intent intent = new Intent();
        intent.putExtra("appId", this.mAppId);
        PublicFragmentActivity.b.d(getBaseActivity(), intent, PublicFragmentActivityForMini.class, AddPhoneNumberFragment.class, 1090);
        MiniGetPhoneNumberReporter.getInstance().addPhoneNumberClickReport();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onComplainClick() {
        String str;
        MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
        try {
            str = URLEncoder.encode("https://support.qq.com/data/1368/2018/0927/5e6c84b68d1f3ad390e7beeb6c2f83b0.jpeg", "UTF-8");
        } catch (UnsupportedEncodingException e16) {
            QMLog.e("PhoneNumberManagementFragment", "startComplainAndCallback, url = ");
            e16.printStackTrace();
            str = "";
        }
        String str2 = "https://support.qq.com/embed/phone/56748/new-post?appid=" + this.mAppId + "&openid=" + LoginManager.getInstance().getAccount() + "&avatar=" + str + "&nickname=\u6e38\u5ba2";
        Intent intent = new Intent();
        intent.putExtra("url", str2);
        intent.putExtra("title", "\u6295\u8bc9");
        Bundle bundle = new Bundle();
        bundle.putBoolean("hide_more_button", true);
        intent.putExtras(bundle);
        miniAppProxy.startBrowserActivity(getActivity(), intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sendDelRequest, reason: merged with bridge method [inline-methods] */
    public void lambda$setPhoneNumberList$1(final String str) {
        if (getBaseActivity() == null || getBaseActivity().isFinishing()) {
            return;
        }
        QLog.d("PhoneNumberManagementFragment", 1, "sendDelRequest phoneNumberId:" + str);
        if (this.mPhoneNumberArray != null) {
            MiniAppCmdUtil.getInstance().delPhoneNumber(this.mAppId, str, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.mainpage.b
                @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                public final void onCmdListener(boolean z16, JSONObject jSONObject) {
                    PhoneNumberManagementFragment.this.lambda$sendDelRequest$3(str, z16, jSONObject);
                }
            });
        }
    }

    private void setActivityResultListener() {
        this.mPhoneNumberResultListener = new PhoneNumberResultListener();
        MiniAppController.getInstance().setActivityResultListener(this.mPhoneNumberResultListener);
    }

    private void setPhoneManagerClickEvent(View view) {
        TextView textView = (TextView) view;
        String charSequence = textView.getText().toString();
        if (charSequence.equals(getString(R.string.f167392ct))) {
            textView.setText(getString(R.string.f167382cs));
            setPhoneNumberState(true);
            MiniGetPhoneNumberReporter.getInstance().managePhoneNumberClickReport();
        } else if (charSequence.equals(getString(R.string.f167382cs))) {
            textView.setText(getString(R.string.f167392ct));
            setPhoneNumberState(false);
        }
        this.mPhoneNumberManageAdapter.updateData(this.mPhoneNumberItems);
    }

    private void setPhoneNumberArrayToList() {
        int length = this.mPhoneNumberArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject = this.mPhoneNumberArray.optJSONObject(i3);
            PhoneNumberManageItem phoneNumberManageItem = new PhoneNumberManageItem();
            phoneNumberManageItem.setPhoneType(optJSONObject.optInt("phoneType"));
            phoneNumberManageItem.setPurePhoneNumber(optJSONObject.optString("purePhoneNumber"));
            phoneNumberManageItem.setCountryCode(optJSONObject.optString("countryCode"));
            phoneNumberManageItem.setEncryptedData(optJSONObject.optString(MiniConst.MiniAppCmdUtilConst.ENCRYPTED_DATA));
            phoneNumberManageItem.setIv(optJSONObject.optString("iv"));
            phoneNumberManageItem.setPhoneNumberID(optJSONObject.optString(MiniConst.MiniAppCmdUtilConst.PHONE_NUMBER_ID));
            phoneNumberManageItem.setItemType(0);
            this.mPhoneNumberItems.add(phoneNumberManageItem);
        }
        PhoneNumberManageItem phoneNumberManageItem2 = new PhoneNumberManageItem();
        this.mAddPhoneNumberItem = phoneNumberManageItem2;
        phoneNumberManageItem2.setItemType(1);
        this.mPhoneNumberItems.add(this.mAddPhoneNumberItem);
    }

    private void setPhoneNumberList() {
        setPhoneNumberArrayToList();
        this.mPhoneNumberManageAdapter = new PhoneNumberManageAdapter();
        this.mPhoneNumberRv.setLayoutManager(new LinearLayoutManager(getBaseActivity(), 1, false));
        this.mPhoneNumberRv.setAdapter(this.mPhoneNumberManageAdapter);
        this.mPhoneNumberManageAdapter.addPhoneNumberClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.mainpage.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhoneNumberManagementFragment.this.lambda$setPhoneNumberList$0(view);
            }
        });
        this.mPhoneNumberManageAdapter.updateData(this.mPhoneNumberItems);
        this.mPhoneNumberManageAdapter.deletePhoneNumberCallBack(new PhoneNumberManageAdapter.DeletePhoneNumberCallBack() { // from class: com.tencent.mobileqq.mini.mainpage.d
            @Override // com.tencent.mobileqq.mini.mainpage.PhoneNumberManageAdapter.DeletePhoneNumberCallBack
            public final void deletePhoneNumber(String str) {
                PhoneNumberManagementFragment.this.lambda$setPhoneNumberList$1(str);
            }
        });
    }

    private void setPhoneNumberState(boolean z16) {
        int size = this.mPhoneNumberItems.size();
        for (int i3 = 1; i3 < size; i3++) {
            PhoneNumberManageItem phoneNumberManageItem = this.mPhoneNumberItems.get(i3);
            if (phoneNumberManageItem.getItemType() == 0) {
                phoneNumberManageItem.setEditState(z16);
            }
        }
        if (z16) {
            List<PhoneNumberManageItem> list = this.mPhoneNumberItems;
            list.remove(list.size() - 1);
        } else {
            this.mPhoneNumberItems.add(this.mAddPhoneNumberItem);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        if (getBaseActivity() != null && !getBaseActivity().isFinishing()) {
            Intent intent = new Intent();
            JSONArray jSONArray = this.mPhoneNumberArray;
            if (jSONArray != null) {
                intent.putExtra("phoneNumberArray", jSONArray.toString());
            }
            getBaseActivity().setResult(-1, intent);
            getBaseActivity().finish();
        }
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id5 = view.getId();
        if (id5 != R.id.z8t) {
            if (id5 != R.id.f109356fl) {
                return;
            }
            setPhoneManagerClickEvent(view);
        } else {
            if (getBaseActivity() == null || getBaseActivity().isFinishing()) {
                return;
            }
            Intent intent = new Intent();
            JSONArray jSONArray = this.mPhoneNumberArray;
            if (jSONArray != null) {
                intent.putExtra("phoneNumberArray", jSONArray.toString());
            }
            getBaseActivity().setResult(-1, intent);
            getBaseActivity().finish();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.mAppId = arguments.getString("appId", null);
                this.mPhoneNumberArray = new JSONArray(arguments.getString("phoneNumberList"));
            }
        } catch (Throwable th5) {
            QLog.e("PhoneNumberManagementFragment", 1, "parse getArguments error,", th5);
        }
        setActivityResultListener();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = LayoutInflater.from(getBaseActivity()).inflate(R.layout.fhs, (ViewGroup) null);
        getBaseActivity().getWindow().clearFlags(67108864);
        getBaseActivity().getWindow().addFlags(Integer.MIN_VALUE);
        getBaseActivity().getWindow().setStatusBarColor(-1);
        ImmersiveUtils.setStatusTextColor(true, getBaseActivity().getWindow());
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            inflate.setFitsSystemWindows(true);
            inflate.setPadding(0, ImmersiveUtils.getStatusBarHeight(getBaseActivity()), 0, 0);
        }
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.mPhoneNumberResultListener != null) {
            MiniAppController.getInstance().removeActivityResultListener(this.mPhoneNumberResultListener);
        }
        QLog.d("PhoneNumberManagementFragment", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        MiniGetPhoneNumberReporter.getInstance().phoneNumberManagePageExpoReport();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ImageView imageView = (ImageView) view.findViewById(R.id.z8t);
        this.mLeftBtnView = imageView;
        imageView.setOnClickListener(this);
        TextView textView = (TextView) view.findViewById(R.id.f109356fl);
        this.mPhoneNumberControlTv = textView;
        textView.setOnClickListener(this);
        this.mPhoneNumberRv = (RecyclerView) view.findViewById(R.id.f791248x);
        getPhoneNumberComplaintEvent(view);
        setPhoneNumberList();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }

    private void getPhoneNumberComplaintEvent(View view) {
        TextView textView = (TextView) view.findViewById(R.id.f166268z84);
        this.mPhoneNumberComplaint = textView;
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        String charSequence = this.mPhoneNumberComplaint.getText().toString();
        SpannableString spannableString = new SpannableString(charSequence);
        String qqStr = HardCodeUtil.qqStr(com.tencent.qqmini.sdk.R.string.mini_sdk_privacy_link_complain);
        int indexOf = charSequence.indexOf(qqStr);
        spannableString.setSpan(new ClickableSpan() { // from class: com.tencent.mobileqq.mini.mainpage.PhoneNumberManagementFragment.1
            @Override // android.text.style.ClickableSpan
            public void onClick(View view2) {
                PhoneNumberManagementFragment.this.onComplainClick();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(ResourceUtil.getColor(R.color.qui_common_text_link));
                textPaint.setUnderlineText(false);
            }
        }, indexOf, qqStr.length() + indexOf, 17);
        this.mPhoneNumberComplaint.setText(spannableString);
    }
}
