package com.tencent.richframework.common.part;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.google.gson.Gson;
import com.tencent.biz.richframework.config.RFWCommonConfig;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.IQCircleQUICProtocolEnvApi;
import com.tencent.mobileqq.qcircle.tempapi.api.IQQBaseService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.common.RFWCommonGlobalInfo;
import com.tencent.richframework.common.data.MsfEnv;
import com.tencent.richframework.common.data.MsfServerRsp;
import com.tencent.richframework.common.event.RFRestartAppEvent;
import com.tencent.richframework.common.request.RFWCommonGetRainbowKVConfRequest;
import java.util.ArrayList;
import java.util.Random;
import qqcircle.QQCircleConfig$GetRainbowKVConfRsp;

/* loaded from: classes25.dex */
public class RFWChangeMsfServerPart extends Part implements View.OnClickListener {
    private static final Random RANDOM = new Random();
    private MsfEnv mCurCheckedMsfEnv;
    private AlertDialog mDialog;
    private AlertDialog.Builder mDialogBuilder;
    private ImageView mIvBack;
    private MsfServerRsp mMsfServerRsp;
    private String mPreMsfId = RFWCommonGlobalInfo.getCurMsfServerId();

    @SuppressLint({"WrongConstant"})
    private SharedPreferences mPreferences = RFWCommonConfig.getShareSp();
    private RadioGroup mRadioGroup;
    private Button mRestartBtn;
    private TextView mTvTips;

    private void destroy() {
        if (!getPartManager().onBackEvent() && getActivity() != null) {
            getActivity().finish();
        }
    }

    private RadioButton generateRadioButton(String str, boolean z16) {
        RadioButton radioButton = new RadioButton(getContext());
        radioButton.setText(str);
        radioButton.setChecked(z16);
        radioButton.setTextColor(R.color.coa);
        radioButton.setPadding(30, 0, 0, 0);
        return radioButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MsfEnv getMsfEnvByResId(int i3) {
        ArrayList<MsfEnv> arrayList;
        MsfServerRsp msfServerRsp = this.mMsfServerRsp;
        if (msfServerRsp == null || (arrayList = msfServerRsp.env_list) == null || arrayList.size() <= 0) {
            return null;
        }
        for (int i16 = 0; i16 < this.mMsfServerRsp.env_list.size(); i16++) {
            if (i3 == this.mMsfServerRsp.env_list.get(i16).resId) {
                return this.mMsfServerRsp.env_list.get(i16);
            }
        }
        return null;
    }

    private void initAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        this.mDialogBuilder = builder;
        builder.setTitle("SSO\u73af\u5883\u5df2\u6539\u53d8").setMessage("\u662f\u5426\u91cd\u542f\u4ee5\u751f\u6548\uff1f").setCancelable(false).setNegativeButton("\u53d6\u6d88", new DialogInterface.OnClickListener() { // from class: com.tencent.richframework.common.part.RFWChangeMsfServerPart.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                if (RFWChangeMsfServerPart.this.mDialog == null) {
                    return;
                }
                RFWChangeMsfServerPart.this.mDialog.dismiss();
            }
        }).setPositiveButton("\u786e\u5b9a", new DialogInterface.OnClickListener() { // from class: com.tencent.richframework.common.part.RFWChangeMsfServerPart.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                RFWChangeMsfServerPart.this.restartApp();
            }
        });
        this.mDialog = this.mDialogBuilder.create();
    }

    private void initData() {
        setTvTipsVisiable("\u914d\u7f6e\u52a0\u8f7d\u4e2d\u2026\u2026");
        final String msfServerConfData = RFWCommonGlobalInfo.getMsfServerConfData();
        VSNetworkHelper.getInstance().sendRequest(new RFWCommonGetRainbowKVConfRequest("4aa831c0-51c9-4dc9-9ab2-1e99ec9031f0", "trpc.feedcloud.commgateway.CommGateway.TEST", "colorV2.json"), new VSDispatchObserver.OnVSRspCallBack<QQCircleConfig$GetRainbowKVConfRsp>() { // from class: com.tencent.richframework.common.part.RFWChangeMsfServerPart.4
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleConfig$GetRainbowKVConfRsp qQCircleConfig$GetRainbowKVConfRsp) {
                String str2;
                PBStringField pBStringField;
                QLog.i("RFWChangeMsfServerPart", 1, "GetRainbowKVConfRsp isSuccess\uff1a" + z16 + " errormsg:" + str + " retCode:" + j3);
                if (z16 && qQCircleConfig$GetRainbowKVConfRsp != null && (pBStringField = qQCircleConfig$GetRainbowKVConfRsp.data) != null && !TextUtils.isEmpty(pBStringField.get())) {
                    str2 = qQCircleConfig$GetRainbowKVConfRsp.data.get();
                    RFWCommonGlobalInfo.saveMsfServerConfData(str2);
                } else {
                    str2 = msfServerConfData;
                }
                RFWChangeMsfServerPart.this.onConfReceive(str2);
            }
        });
    }

    private void initRadioGroup() {
        this.mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.tencent.richframework.common.part.RFWChangeMsfServerPart.3
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i3) {
                EventCollector.getInstance().onRadioGroupCheckedBefore(radioGroup, i3);
                RFWChangeMsfServerPart rFWChangeMsfServerPart = RFWChangeMsfServerPart.this;
                rFWChangeMsfServerPart.mCurCheckedMsfEnv = rFWChangeMsfServerPart.getMsfEnvByResId(i3);
                RFWChangeMsfServerPart.this.showConfirmDialog();
                EventCollector.getInstance().onRadioGroupChecked(radioGroup, i3);
            }
        });
    }

    private void initRadios(ArrayList<MsfEnv> arrayList) {
        this.mRadioGroup.removeAllViews();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            MsfEnv msfEnv = arrayList.get(i3);
            boolean equals = this.mPreMsfId.equals(msfEnv.f365101id);
            msfEnv.resId = RANDOM.nextInt();
            RadioButton generateRadioButton = generateRadioButton(msfEnv.name, equals);
            generateRadioButton.setId(msfEnv.resId);
            generateRadioButton.setTag(msfEnv);
            this.mRadioGroup.addView(generateRadioButton, new RadioGroup.LayoutParams(-1, -2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onConfReceive(String str) {
        ArrayList<MsfEnv> arrayList;
        if (TextUtils.isEmpty(str)) {
            setTvTipsVisiable("\u540e\u53f0\u8fd4\u56de\u914d\u7f6e\u4e3a\u7a7a");
            return;
        }
        try {
            MsfServerRsp msfServerRsp = (MsfServerRsp) new Gson().fromJson(str, MsfServerRsp.class);
            this.mMsfServerRsp = msfServerRsp;
            if (msfServerRsp != null && (arrayList = msfServerRsp.env_list) != null && arrayList.size() > 0) {
                initRadios(this.mMsfServerRsp.env_list);
            }
            setTvTipsVisiable("");
        } catch (Exception unused) {
            setTvTipsVisiable("\u540e\u53f0\u914d\u7f6e\u89e3\u6790\u9519\u8bef");
            RFWCommonGlobalInfo.saveMsfServerConfData("");
            QLog.i("RFWChangeMsfServerPart", 1, "GetRainbowKVConfRsp json exception!\uff1a json is:" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void restartApp() {
        String str;
        MsfEnv msfEnv = this.mCurCheckedMsfEnv;
        if (msfEnv == null) {
            return;
        }
        setMsfServerIdInSp(msfEnv);
        RFWCommonGlobalInfo.setCurMsfServerId(this.mCurCheckedMsfEnv.f365101id);
        if (this.mCurCheckedMsfEnv.use_test_sso) {
            str = "socket://test.sso.qq.com:60000";
        } else {
            str = "";
        }
        IQCircleQUICProtocolEnvApi iQCircleQUICProtocolEnvApi = (IQCircleQUICProtocolEnvApi) QRoute.api(IQCircleQUICProtocolEnvApi.class);
        MsfEnv msfEnv2 = this.mCurCheckedMsfEnv;
        iQCircleQUICProtocolEnvApi.updateEnv(msfEnv2.f365101id, msfEnv2.name, msfEnv2.use_test_sso);
        SimpleEventBus.getInstance().dispatchEvent(new RFRestartAppEvent());
        ((IQQBaseService) QRoute.api(IQQBaseService.class)).setNewSsoAndRestartApp(str);
    }

    private void setMsfServerIdInSp(MsfEnv msfEnv) {
        if (msfEnv == null) {
            return;
        }
        SharedPreferences.Editor edit = this.mPreferences.edit();
        edit.putString("rfw_common_msf_server_id", msfEnv.f365101id);
        edit.putString("rfw_common_msf_server_name", msfEnv.name);
        edit.apply();
    }

    private void setTvTipsVisiable(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mTvTips.setVisibility(8);
        } else {
            this.mTvTips.setText(str);
            this.mTvTips.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showConfirmDialog() {
        MsfEnv msfEnv = this.mCurCheckedMsfEnv;
        if (msfEnv != null && !this.mPreMsfId.equals(msfEnv.f365101id)) {
            this.mDialog.show();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "RFWChangeMsfServerPart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.y_2) {
            destroy();
        } else if (id5 == R.id.f73643u4) {
            restartApp();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        ImageView imageView = (ImageView) view.findViewById(R.id.y_2);
        this.mIvBack = imageView;
        imageView.setOnClickListener(this);
        this.mTvTips = (TextView) view.findViewById(R.id.kbr);
        Button button = (Button) view.findViewById(R.id.f73643u4);
        this.mRestartBtn = button;
        button.setOnClickListener(this);
        this.mRadioGroup = (RadioGroup) view.findViewById(R.id.f74173vj);
        initAlertDialog();
        initRadioGroup();
        initData();
    }
}
