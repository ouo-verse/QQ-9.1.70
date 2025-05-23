package com.tenpay.sdk.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.text.method.DialerKeyListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.gson.GsonBuilder;
import com.heytap.databaseengine.type.DeviceType;
import com.tencent.gamematrix.gmcg.sdk.nonage.report.CGNonAgeReport;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.base.FragmentAnimation;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.mobileqq.qwallet.pb.QWalletCreditReg$GetFaceTokenReq;
import com.tencent.mobileqq.qwallet.pb.QWalletCreditReg$GetFaceTokenRsp;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.ActionSheet;
import com.tenpay.ErrorCode;
import com.tenpay.QwLog;
import com.tenpay.api.MyKeyboardWindow;
import com.tenpay.api.QWalletUtils;
import com.tenpay.bank.BindBankModule;
import com.tenpay.face.FaceVerifyBean;
import com.tenpay.face.FaceVerifyErr;
import com.tenpay.face.QWalletFaceProxyFragment;
import com.tenpay.idverify.EnumIdVerifyType;
import com.tenpay.idverify.hint.IdVerifyFinishProcessor;
import com.tenpay.idverify.hint.IdVerifyHintModule;
import com.tenpay.idverify.model.IdVerifyStateBean;
import com.tenpay.idverify.utils.IdVerifyUtils;
import com.tenpay.lcation.LocationInputFragment;
import com.tenpay.marketservice.MarketServiceUtils;
import com.tenpay.proxy.QUIProxy;
import com.tenpay.proxy.dlg.age.AgeSelDlg;
import com.tenpay.realname.RealNameSource;
import com.tenpay.realname.RealNameSourceReporter;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.IResult;
import com.tenpay.sdk.activity.IdVerifyActivity;
import com.tenpay.sdk.helper.RealNameAgePopHelper;
import com.tenpay.sdk.net.gateway.QWalletGatewayServlet;
import com.tenpay.sdk.util.AESUtils;
import com.tenpay.sdk.util.TenUtils;
import com.tenpay.sdk.util.UIUtils;
import com.tenpay.sdk.util.WalletGateData;
import com.tenpay.sdk.view.ClearableEditText;
import com.tenpay.sdk.view.CoverDialog;
import com.tenpay.sdk.view.SexPickerView;
import com.tenpay.util.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.json.JSONObject;
import qk2.PrivacyTipConfig;

/* compiled from: P */
/* loaded from: classes27.dex */
public class IdVerifyActivity extends NetBaseActivity {
    public static final int REQUEST_CODE_FORWARD_RESULT = 105;
    private static final int REQUEST_CODE_PROFESSION = 102;
    public static final int REQUEST_CODE_REAL_NAME_FORWARD = 104;
    public static final int REQUEST_CODE_TO_BIND_BANK = 107;
    public static final int REQUEST_CODE_TO_FACE_VERIFY = 108;
    public static final int REQUEST_CODE_TO_SUCCEED_RESULT = 106;
    private static final int RESET_PASS_REQ_CODE = 100;
    private FaceVerifyBean faceVerifyBean;
    private ActionSheet mActionSheet;
    private LinearLayout mAddressLayout;
    private TextView mBackBtn;
    private CoverDialog mCoverDialog;
    private TextView mForgetPassBtn;
    private boolean mFromHb;
    private ClearableEditText mInputIdNumber;
    private ClearableEditText mInputUserName;
    private String mJobName;
    long mLastClickedTime;
    private TextView mMoreVerifyTypeBtn;
    private MyKeyboardWindow mMyKeyBoard;
    private Button mNextBtn;
    private String mPhoneNum;
    private String mPhoneNumToken;
    private LinearLayout mProfessionLayout;
    private ProgressBar mProgressBar;
    private TextView mTitle;
    private TextView mTvVerifySex;
    private LinearLayout mUserSexLayout;
    private TextView mVerifyAddress;
    private TextView mVerifyJob;
    private TextView mVerifyValidBeginDate;
    private TextView mVerifyValidDate;
    private final List<View> forgetPwdGoneArray = new ArrayList();
    private boolean mIsResetPassState = false;
    private boolean mIsFromH5FindPsw = false;
    private boolean mIsFromResetPassBridge = false;
    private int mCurSexType = 0;

    @NonNull
    private String mProvince = "";

    @NonNull
    private String mCity = "";

    @NonNull
    private String mDistrict = "";

    @NonNull
    private String mDetailAddress = "";
    private final View.OnClickListener mOnClickListener = new AnonymousClass2();
    private final SexPickerView.SexPickerViewAdapter mAdapter = new SexPickerView.SexPickerViewAdapter() { // from class: com.tenpay.sdk.activity.IdVerifyActivity.4
        @Override // com.tenpay.sdk.view.SexPickerView.SexPickerViewAdapter
        public int getRowCount() {
            return 2;
        }

        @Override // com.tenpay.sdk.view.SexPickerView.SexPickerViewAdapter
        public String getText(int i3) {
            IdVerifyActivity idVerifyActivity;
            int i16;
            if (i3 == 0) {
                idVerifyActivity = IdVerifyActivity.this;
                i16 = R.string.c7_;
            } else {
                idVerifyActivity = IdVerifyActivity.this;
                i16 = R.string.b5e;
            }
            return idVerifyActivity.getString(i16);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tenpay.sdk.activity.IdVerifyActivity$2, reason: invalid class name */
    /* loaded from: classes27.dex */
    public class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onClick$0(View view) {
            IdVerifyActivity.this.mMyKeyBoard.setVisibility(0);
            IdVerifyActivity.this.mMyKeyBoard.setXMode(1);
            IdVerifyActivity.this.mMyKeyBoard.setInputEditText((EditText) view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onClick$1(int i3, Intent intent) {
            if (i3 == -1 && intent != null) {
                String stringExtra = intent.getStringExtra(LocationInputFragment.KEY_ADDRESS_PROVINCE);
                String stringExtra2 = intent.getStringExtra(LocationInputFragment.KEY_ADDRESS_CITY);
                String stringExtra3 = intent.getStringExtra(LocationInputFragment.KEY_ADDRESS_DISTRICT);
                String stringExtra4 = intent.getStringExtra(LocationInputFragment.KEY_DETAIL_ADDRESS);
                IdVerifyActivity idVerifyActivity = IdVerifyActivity.this;
                if (stringExtra == null) {
                    stringExtra = "";
                }
                idVerifyActivity.mProvince = stringExtra;
                IdVerifyActivity idVerifyActivity2 = IdVerifyActivity.this;
                if (stringExtra2 == null) {
                    stringExtra2 = "";
                }
                idVerifyActivity2.mCity = stringExtra2;
                IdVerifyActivity idVerifyActivity3 = IdVerifyActivity.this;
                if (stringExtra3 == null) {
                    stringExtra3 = "";
                }
                idVerifyActivity3.mDistrict = stringExtra3;
                IdVerifyActivity idVerifyActivity4 = IdVerifyActivity.this;
                if (stringExtra4 == null) {
                    stringExtra4 = "";
                }
                idVerifyActivity4.mDetailAddress = stringExtra4;
                IdVerifyActivity.this.mVerifyAddress.setText(IdVerifyActivity.this.mProvince + " " + IdVerifyActivity.this.mCity + " " + IdVerifyActivity.this.mDistrict + " " + IdVerifyActivity.this.mDetailAddress);
                IdVerifyActivity.this.mNextBtn.setEnabled(IdVerifyActivity.this.validatePage());
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(final View view) {
            RealNameSource realNameSource;
            String str;
            EventCollector.getInstance().onViewClickedBefore(view);
            int id5 = view.getId();
            if (id5 == R.id.ivTitleBtnLeft) {
                IdVerifyActivity.this.onBack();
                com.tencent.mobileqq.qwallet.c.c("identify.info.back", Integer.valueOf(IdVerifyActivity.this.getProcessType()));
            } else if (id5 == R.id.db9) {
                if (IdVerifyActivity.this.mMyKeyBoard.getVisibility() == 8) {
                    view.postDelayed(new Runnable() { // from class: com.tenpay.sdk.activity.bz
                        @Override // java.lang.Runnable
                        public final void run() {
                            IdVerifyActivity.AnonymousClass2.this.lambda$onClick$0(view);
                        }
                    }, 200L);
                }
            } else if (id5 == R.id.db6) {
                long currentTimeMillis = System.currentTimeMillis();
                if (Math.abs(currentTimeMillis - IdVerifyActivity.this.mLastClickedTime) >= 1000 && IdVerifyActivity.this.validateIdNumber()) {
                    IdVerifyActivity idVerifyActivity = IdVerifyActivity.this;
                    idVerifyActivity.mLastClickedTime = currentTimeMillis;
                    com.tencent.mobileqq.qwallet.c.c("identify.info.go", Integer.valueOf(idVerifyActivity.getProcessType()));
                    if (IdVerifyActivity.this.mCurSexType != 1) {
                        str = "1";
                    } else {
                        str = "0";
                    }
                    com.tencent.mobileqq.qwallet.c.e("realname.gender.sumbit", "", str, "", "");
                    if (!IdVerifyActivity.this.mIsResetPassState) {
                        IdVerifyActivity.this.tryPopRealNameNew(IdVerifyActivity.this.mInputIdNumber.getText().toString().trim());
                    } else {
                        HashMap hashMap = new HashMap();
                        hashMap.put("true_name", IdVerifyActivity.this.mInputUserName.getText().toString());
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("creditcard_id", IdVerifyActivity.this.mInputIdNumber.getText().toString().trim());
                        AESUtils.encryptInfoIfRsa2048(IdVerifyActivity.this.getContext(), hashMap, hashMap2);
                        hashMap.put("uin", IdVerifyActivity.this.mUin);
                        hashMap.put("flag", "1");
                        IdVerifyActivity.this.httpRequest(Cgi.URI_QWallet_AUTH_RESET_PASSWD, hashMap);
                    }
                }
            } else if (id5 == R.id.f166027yg1) {
                if (IdVerifyActivity.this.mMyKeyBoard.getVisibility() == 0) {
                    IdVerifyActivity.this.mMyKeyBoard.setVisibility(8);
                }
                AgeSelDlg ageSelDlg = new AgeSelDlg(IdVerifyActivity.this.getContext(), true);
                ageSelDlg.setOnDateSelectListener(new AgeSelDlg.OnDateSelectListener() { // from class: com.tenpay.sdk.activity.IdVerifyActivity.2.1
                    @Override // com.tenpay.proxy.dlg.age.AgeSelDlg.OnDateSelectListener
                    public void dateSelectListener(int i3, int i16, int i17) {
                        String formatDate;
                        TextView textView = IdVerifyActivity.this.mVerifyValidBeginDate;
                        if (i3 == 9999) {
                            formatDate = AgeSelDlg.LONG_YEAR_TXT;
                        } else {
                            formatDate = Utils.formatDate(i3, i16, i17);
                        }
                        textView.setText(formatDate);
                        IdVerifyActivity.this.mNextBtn.setEnabled(IdVerifyActivity.this.validatePage());
                    }

                    @Override // com.tenpay.proxy.dlg.age.AgeSelDlg.OnDateSelectListener
                    public void dateSelectNotValid() {
                        IdVerifyActivity.this.mVerifyValidBeginDate.setText("");
                        IdVerifyActivity.this.mNextBtn.setEnabled(IdVerifyActivity.this.validatePage());
                    }
                });
                ageSelDlg.popupPickerView(R.id.f163936cz, IdVerifyActivity.this.mVerifyValidBeginDate.getText().toString());
            } else if (id5 == R.id.f166028yg2) {
                if (IdVerifyActivity.this.mMyKeyBoard.getVisibility() == 0) {
                    IdVerifyActivity.this.mMyKeyBoard.setVisibility(8);
                }
                AgeSelDlg ageSelDlg2 = new AgeSelDlg(IdVerifyActivity.this.getContext(), false);
                ageSelDlg2.setOnDateSelectListener(new AgeSelDlg.OnDateSelectListener() { // from class: com.tenpay.sdk.activity.IdVerifyActivity.2.2
                    @Override // com.tenpay.proxy.dlg.age.AgeSelDlg.OnDateSelectListener
                    public void dateSelectListener(int i3, int i16, int i17) {
                        String formatDate;
                        TextView textView = IdVerifyActivity.this.mVerifyValidDate;
                        if (i3 == 9999) {
                            formatDate = AgeSelDlg.LONG_YEAR_TXT;
                        } else {
                            formatDate = Utils.formatDate(i3, i16, i17);
                        }
                        textView.setText(formatDate);
                        IdVerifyActivity.this.mNextBtn.setEnabled(IdVerifyActivity.this.validatePage());
                    }

                    @Override // com.tenpay.proxy.dlg.age.AgeSelDlg.OnDateSelectListener
                    public void dateSelectNotValid() {
                        IdVerifyActivity.this.mVerifyValidDate.setText("");
                        IdVerifyActivity.this.mNextBtn.setEnabled(IdVerifyActivity.this.validatePage());
                    }
                });
                ageSelDlg2.popupPickerView(R.id.f163936cz, IdVerifyActivity.this.mVerifyValidDate.getText().toString());
            } else if (id5 == R.id.e2j) {
                Intent intent = new Intent();
                intent.putExtra(LocationInputFragment.KEY_ADDRESS_PROVINCE, IdVerifyActivity.this.mProvince);
                intent.putExtra(LocationInputFragment.KEY_ADDRESS_CITY, IdVerifyActivity.this.mCity);
                intent.putExtra(LocationInputFragment.KEY_ADDRESS_DISTRICT, IdVerifyActivity.this.mDistrict);
                intent.putExtra(LocationInputFragment.KEY_DETAIL_ADDRESS, IdVerifyActivity.this.mDetailAddress);
                IdVerifyActivity.this.startActivityForResult(intent, LocationInputFragment.class, new IResult() { // from class: com.tenpay.sdk.activity.ca
                    @Override // com.tenpay.sdk.IResult
                    public final void back(int i3, Intent intent2) {
                        IdVerifyActivity.AnonymousClass2.this.lambda$onClick$1(i3, intent2);
                    }
                });
            } else if (id5 == R.id.e4x) {
                Intent intent2 = new Intent();
                intent2.putExtra(JobSelectionActivity.PARAM_SELECTED_JOB, IdVerifyActivity.this.mJobName);
                IdVerifyActivity.this.launchFragmentForResult(intent2, JobSelectionActivity.class, 102);
            } else if (id5 == R.id.cja) {
                IdVerifyActivity.this.gotoH5(Cgi.PWD_FIND_ENTRY);
                com.tencent.mobileqq.qwallet.c.c("password.cantfind.go", Integer.valueOf(IdVerifyActivity.this.getProcessType()));
            } else if (id5 == R.id.xgu) {
                IdVerifyActivity.this.onSexSelectClick();
            } else if (id5 == R.id.zf8) {
                Intent intent3 = new Intent();
                Intent intent4 = IdVerifyActivity.this.getIntent();
                if (intent4 != null && (realNameSource = (RealNameSource) intent4.getParcelableExtra(RealNameSource.EXTRA_KEY_SOURCE)) != null) {
                    intent3.putExtra(RealNameSource.EXTRA_KEY_SOURCE, realNameSource);
                }
                intent3.putExtra(BindBankActivity.KEY_IGNORED_DIRECTION_PAGE, true);
                intent3.putExtra("IsShiMing", true);
                BindBankModule.INSTANCE.startVerifyForResult(IdVerifyActivity.this, intent3, 107);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tenpay.sdk.activity.IdVerifyActivity$6, reason: invalid class name */
    /* loaded from: classes27.dex */
    public static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$com$tenpay$sdk$helper$RealNameAgePopHelper$EnumPopAgeType;

        static {
            int[] iArr = new int[RealNameAgePopHelper.EnumPopAgeType.values().length];
            $SwitchMap$com$tenpay$sdk$helper$RealNameAgePopHelper$EnumPopAgeType = iArr;
            try {
                iArr[RealNameAgePopHelper.EnumPopAgeType.REJECT_0_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tenpay$sdk$helper$RealNameAgePopHelper$EnumPopAgeType[RealNameAgePopHelper.EnumPopAgeType.PARENT_COMMIT_8_16.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tenpay$sdk$helper$RealNameAgePopHelper$EnumPopAgeType[RealNameAgePopHelper.EnumPopAgeType.PARENT_CONFIRM_16_18.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$tenpay$sdk$helper$RealNameAgePopHelper$EnumPopAgeType[RealNameAgePopHelper.EnumPopAgeType.ADULT_PASS_18.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private void bindViewId(View view) {
        this.mProfessionLayout = (LinearLayout) view.findViewById(R.id.e4x);
        this.mAddressLayout = (LinearLayout) view.findViewById(R.id.e2j);
        this.mTitle = (TextView) view.findViewById(R.id.dbd);
        this.mBackBtn = (TextView) view.findViewById(R.id.ivTitleBtnLeft);
        this.mVerifyValidDate = (TextView) view.findViewById(R.id.dbb);
        this.mVerifyValidBeginDate = (TextView) view.findViewById(R.id.xgt);
        this.mVerifyAddress = (TextView) view.findViewById(R.id.da_);
        this.mVerifyJob = (TextView) view.findViewById(R.id.db_);
        this.mProgressBar = (ProgressBar) view.findViewById(R.id.je7);
        this.mForgetPassBtn = (TextView) view.findViewById(R.id.cja);
        this.mMoreVerifyTypeBtn = (TextView) view.findViewById(R.id.zf8);
        this.mInputUserName = (ClearableEditText) view.findViewById(R.id.dba);
        this.mInputIdNumber = (ClearableEditText) view.findViewById(R.id.db9);
        this.mNextBtn = (Button) view.findViewById(R.id.db6);
        this.mMyKeyBoard = (MyKeyboardWindow) view.findViewById(R.id.f4i);
        this.mTvVerifySex = (TextView) view.findViewById(R.id.f112436nx);
        this.mUserSexLayout = (LinearLayout) view.findViewById(R.id.xgu);
    }

    private void checkFormAndConfirm() {
        showLoading();
        IdVerifyUtils.INSTANCE.checkForm(this, this.mInputUserName.getText().toString(), this.mInputIdNumber.getText().toString().trim(), this.mVerifyValidBeginDate.getText().toString().trim(), this.mVerifyValidDate.getText().toString().trim(), 1, this.mVerifyJob.getText().toString().trim(), this.mCurSexType, this.mProvince, this.mCity, this.mDistrict, this.mDetailAddress, new Function2() { // from class: com.tenpay.sdk.activity.bo
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit lambda$checkFormAndConfirm$9;
                lambda$checkFormAndConfirm$9 = IdVerifyActivity.this.lambda$checkFormAndConfirm$9((Boolean) obj, (Integer) obj2);
                return lambda$checkFormAndConfirm$9;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissCoverDialog() {
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tenpay.sdk.activity.bw
            @Override // java.lang.Runnable
            public final void run() {
                IdVerifyActivity.this.lambda$dismissCoverDialog$11();
            }
        }, 200L);
    }

    private void fillInSexTextView(String str) {
        String str2;
        this.mCurSexType = TenUtils.getSexTypeByID(str);
        QwLog.i("mCurSexType = " + this.mCurSexType);
        int i3 = this.mCurSexType;
        if (i3 == 0) {
            this.mTvVerifySex.setText("");
        } else {
            TextView textView = this.mTvVerifySex;
            if (i3 == 1) {
                str2 = "\u7537";
            } else {
                str2 = "\u5973";
            }
            textView.setText(str2);
        }
        this.mUserSexLayout.setVisibility(8);
    }

    private HashMap<String, String> getParamsMap(String str, String str2) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("uin", this.mUin);
        hashMap.put("come_from", this.mComeFrom + "");
        hashMap.put(com.tencent.mobileqq.msf.core.c0.j.T0, this.mAppInfo);
        hashMap.put("true_name", str);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("creditcard_id", str2);
        AESUtils.encryptInfoIfRsa2048(getContext(), hashMap, hashMap2);
        hashMap.put("cre_type", "1");
        hashMap.put("user_info_extend", getUserInfoExtend().toString());
        FaceVerifyBean faceVerifyBean = this.faceVerifyBean;
        if (faceVerifyBean != null) {
            hashMap.put("token_id", faceVerifyBean.getTokenId());
            hashMap.put(CGNonAgeReport.EVENT_CHANNEL, this.faceVerifyBean.getChannelInfo());
        }
        QwLog.e("obj is " + hashMap);
        return hashMap;
    }

    private ActionSheet getSexActionSheet() {
        ActionSheet actionSheet = this.mActionSheet;
        if (actionSheet != null) {
            return actionSheet;
        }
        SexPickerView sexPickerView = (SexPickerView) getLayoutInflater().inflate(R.layout.fyo, (ViewGroup) null);
        sexPickerView.initialize(this.mAdapter);
        final ActionSheet createMenuSheet = ActionSheet.createMenuSheet(getContext());
        createMenuSheet.setCloseAutoRead(true);
        createMenuSheet.setActionContentView(sexPickerView, null);
        createMenuSheet.registerWatchDisMissActionListener(new ActionSheet.WatchDismissActions() { // from class: com.tenpay.sdk.activity.bx
            @Override // com.tencent.widget.ActionSheet.WatchDismissActions
            public final void onDismissOperations() {
                IdVerifyActivity.this.dismissCoverDialog();
            }
        });
        DispatchActionMoveScrollView dispatchActionMoveScrollView = (DispatchActionMoveScrollView) createMenuSheet.findViewById(R.id.f163936cz);
        dispatchActionMoveScrollView.dispatchActionMove = true;
        dispatchActionMoveScrollView.setBackgroundResource(17170445);
        Window window = createMenuSheet.getWindow();
        if (window != null) {
            window.setFlags(16777216, 16777216);
        }
        sexPickerView.setPickListener(new SexPickerView.SexPickListener() { // from class: com.tenpay.sdk.activity.IdVerifyActivity.5
            @Override // com.tenpay.sdk.view.SexPickerView.SexPickListener
            public void onCancelBtClicked() {
                if (createMenuSheet.isShowing()) {
                    createMenuSheet.dismiss();
                }
            }

            @Override // com.tenpay.sdk.view.SexPickerView.SexPickListener
            public void onConfirmBtClicked() {
                if (createMenuSheet.isShowing()) {
                    createMenuSheet.dismiss();
                }
            }

            @Override // com.tenpay.sdk.view.SexPickerView.SexPickListener
            public void onItemSelected(int i3) {
                int i16;
                String str;
                IdVerifyActivity idVerifyActivity = IdVerifyActivity.this;
                if (i3 == 0) {
                    i16 = 1;
                } else {
                    i16 = 2;
                }
                idVerifyActivity.mCurSexType = i16;
                TextView textView = IdVerifyActivity.this.mTvVerifySex;
                if (IdVerifyActivity.this.mCurSexType == 1) {
                    str = "\u7537";
                } else {
                    str = "\u5973";
                }
                textView.setText(str);
            }
        });
        this.mActionSheet = createMenuSheet;
        return createMenuSheet;
    }

    private JSONObject getUserInfoExtend() {
        HashMap hashMap = new HashMap();
        if (!this.mIsResetPassState) {
            hashMap.put("job", this.mVerifyJob.getText().toString().trim());
            hashMap.put("creditcard_begin_date", this.mVerifyValidBeginDate.getText().toString().trim());
            String trim = this.mVerifyValidDate.getText().toString().trim();
            if (trim.equals(AgeSelDlg.LONG_YEAR_TXT)) {
                hashMap.put("creditcard_exp_date", Utils.formatDate(9999, 12, 31));
            } else {
                hashMap.put("creditcard_exp_date", trim);
            }
            hashMap.put("province", this.mProvince);
            hashMap.put("city", this.mCity);
            hashMap.put(TtmlNode.TAG_REGION, this.mDistrict);
            hashMap.put("address", this.mDetailAddress);
        }
        hashMap.put("sex", this.mCurSexType + "");
        if (!TextUtils.isEmpty(this.mPhoneNum)) {
            hashMap.put(DeviceType.DeviceCategory.MOBILE, this.mPhoneNum);
        }
        return new JSONObject(hashMap);
    }

    private void goToResetPassword(String str) {
        Intent intent = new Intent();
        HashMap hashMap = new HashMap();
        hashMap.put("true_name", this.mInputUserName.getText().toString());
        hashMap.put("creditcard_id", this.mInputIdNumber.getText().toString());
        hashMap.put("flag", "2");
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("token", str);
        }
        intent.putExtra("data", hashMap);
        intent.putExtra("from_id_verify", true);
        launchFragmentForResult(intent, ResetPassActivity.class, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goVerifyNext() {
        if (this.mUserAttr == 1) {
            sendAuthRequest(this.mInputUserName.getText().toString(), this.mInputIdNumber.getText().toString().trim());
        } else {
            sendAuthNotify(this.mInputUserName.getText().toString(), this.mInputIdNumber.getText().toString().trim());
            gotoActivateTenpayAccount();
        }
        TenUtils.broadCastIdVerified();
    }

    private void gotoActivateTenpayAccount() {
        Parcelable parcelable;
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("need_yz", "0");
        HashMap hashMap = new HashMap();
        hashMap.put("uin", this.mUin);
        hashMap.put("true_name", this.mInputUserName.getText().toString());
        HashMap hashMap2 = new HashMap();
        hashMap2.put("creditcard_id", this.mInputIdNumber.getText().toString().trim());
        AESUtils.encryptInfoIfRsa2048(getContext(), hashMap, hashMap2);
        hashMap.put("user_info_extend", getUserInfoExtend().toString());
        bundle.putSerializable(ActivateTenpayAccount.PARAM_ACTIVATE_MAP, hashMap);
        intent.putExtra(ActivateTenpayAccount.PARAM_ACTIVATE_ACCOUNT_BUNDLE, bundle);
        intent.putExtra(ActivateTenpayAccount.PARAM_ACTIVATE_FACE_VERIFY_BEAN, this.faceVerifyBean);
        intent.putExtra("from", 2);
        Intent intent2 = getIntent();
        if (intent2 != null && (parcelable = (RealNameSource) intent2.getParcelableExtra(RealNameSource.EXTRA_KEY_SOURCE)) != null) {
            intent.putExtra(RealNameSource.EXTRA_KEY_SOURCE, parcelable);
        }
        startActivityForResult(intent, ActivateTenpayAccount.class, new IResult() { // from class: com.tenpay.sdk.activity.bv
            @Override // com.tenpay.sdk.IResult
            public final void back(int i3, Intent intent3) {
                IdVerifyActivity.this.lambda$gotoActivateTenpayAccount$10(i3, intent3);
            }
        });
    }

    private void initGateData(JSONObject jSONObject) {
        if (jSONObject == null) {
            QwLog.i("initGateData fail, data is null");
            return;
        }
        this.mUserAttr = jSONObject.optInt("user_attr");
        this.mTimestamp = Long.parseLong(jSONObject.optString("time_stamp")) - (System.currentTimeMillis() / 1000);
        this.authen_channel_state = jSONObject.optInt("authen_channel_state");
        this.mCacheVer = jSONObject.optString("interf_cache_ver");
    }

    private void initView(View view) {
        this.forgetPwdGoneArray.add(view.findViewById(R.id.e4m));
        this.forgetPwdGoneArray.add(this.mMoreVerifyTypeBtn);
        setKeyboardTouchOutsizeCancel(this.mMyKeyBoard);
        this.mBackBtn.setOnClickListener(this.mOnClickListener);
        this.mInputIdNumber.setKeyListener(new DialerKeyListener() { // from class: com.tenpay.sdk.activity.IdVerifyActivity.1
            @Override // android.text.method.DialerKeyListener, android.text.method.NumberKeyListener
            @NonNull
            protected char[] getAcceptedChars() {
                return new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'x', 'X'};
            }

            @Override // android.text.method.DialerKeyListener, android.text.method.KeyListener
            public int getInputType() {
                return 1;
            }
        });
        this.mInputIdNumber.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tenpay.sdk.activity.bs
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view2, boolean z16) {
                IdVerifyActivity.this.lambda$initView$0(view2, z16);
            }
        });
        this.mInputUserName.setOnTextChangedListener(new ClearableEditText.OnTextChangedListener() { // from class: com.tenpay.sdk.activity.bt
            @Override // com.tenpay.sdk.view.ClearableEditText.OnTextChangedListener
            public final void onTextChanged() {
                IdVerifyActivity.this.lambda$initView$1();
            }
        });
        this.mInputIdNumber.setOnTextChangedListener(new ClearableEditText.OnTextChangedListener() { // from class: com.tenpay.sdk.activity.bu
            @Override // com.tenpay.sdk.view.ClearableEditText.OnTextChangedListener
            public final void onTextChanged() {
                IdVerifyActivity.this.lambda$initView$2();
            }
        });
        this.mInputIdNumber.setOnClickListener(this.mOnClickListener);
        QWalletUtils.hideSysKeyBorad(this.mInputIdNumber);
        this.mNextBtn.setOnClickListener(this.mOnClickListener);
        this.mNextBtn.setEnabled(false);
        this.mAddressLayout.setOnClickListener(this.mOnClickListener);
        view.findViewById(R.id.f166027yg1).setOnClickListener(this.mOnClickListener);
        view.findViewById(R.id.f166028yg2).setOnClickListener(this.mOnClickListener);
        this.mUserSexLayout.setOnClickListener(this.mOnClickListener);
        this.mProfessionLayout.setOnClickListener(this.mOnClickListener);
        this.mMoreVerifyTypeBtn.setOnClickListener(this.mOnClickListener);
        if (this.mIsResetPassState) {
            this.mTitle.setText(R.string.eal);
            this.mForgetPassBtn.setVisibility(0);
            this.mForgetPassBtn.setOnClickListener(this.mOnClickListener);
            Iterator<View> it = this.forgetPwdGoneArray.iterator();
            while (it.hasNext()) {
                it.next().setVisibility(8);
            }
        } else {
            updateMoreVerifyTypeBtn();
            JSONObject data = WalletGateData.getInstance().getData();
            if (data == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("uin", this.mUin);
                httpRequest(Cgi.URL_WALLET_GATE, hashMap);
            } else {
                initGateData(data);
            }
        }
        com.tencent.mobileqq.qwallet.c.c("identify.info.show", Integer.valueOf(getProcessType()));
    }

    private Boolean intercept8_16PopRealName(String str) {
        final RealNameAgePopHelper.EnumPopAgeType cidAgeType = RealNameAgePopHelper.getCidAgeType(str);
        if (cidAgeType != RealNameAgePopHelper.EnumPopAgeType.PARENT_COMMIT_8_16) {
            return Boolean.FALSE;
        }
        startActivityForResult(new Intent(), PhoneInputActivity.class, new IResult() { // from class: com.tenpay.sdk.activity.bn
            @Override // com.tenpay.sdk.IResult
            public final void back(int i3, Intent intent) {
                IdVerifyActivity.this.lambda$intercept8_16PopRealName$7(cidAgeType, i3, intent);
            }
        });
        return Boolean.TRUE;
    }

    private boolean isSexChangeable() {
        if (this.mUserSexLayout.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkFormAndConfirm$8(int i3, Intent intent) {
        if (i3 == -1) {
            if (intent != null) {
                this.mPhoneNum = intent.getStringExtra("phone");
            }
            onPhoneInputSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$checkFormAndConfirm$9(Boolean bool, Integer num) {
        dismissLoading();
        if (!bool.booleanValue()) {
            onCheckFormFail(num.intValue());
            return Unit.INSTANCE;
        }
        startActivityForResult(new Intent(), PhoneInputActivity.class, new IResult() { // from class: com.tenpay.sdk.activity.bm
            @Override // com.tenpay.sdk.IResult
            public final void back(int i3, Intent intent) {
                IdVerifyActivity.this.lambda$checkFormAndConfirm$8(i3, intent);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$dismissCoverDialog$11() {
        CoverDialog coverDialog = this.mCoverDialog;
        if (coverDialog != null) {
            coverDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$gotoActivateTenpayAccount$10(int i3, Intent intent) {
        int i16 = -1;
        if (this.mFromHb) {
            if (i3 == -1) {
                setResult(-1);
            } else {
                setResult(0);
            }
            finish();
            return;
        }
        if (i3 == -1) {
            String stringExtra = intent.getStringExtra(IdVerifyFinishProcessor.KEY_AUTH_COMMENT);
            String stringExtra2 = intent.getStringExtra(IdVerifyFinishProcessor.KEY_AUTH_TIP);
            String stringExtra3 = intent.getStringExtra(IdVerifyFinishProcessor.KEY_AUTH_BUTTON);
            QwLog.i("onSuccess,auth_comment\uff1a" + stringExtra);
            IdVerifyHintModule.startCommonSuccessHint(this, stringExtra, stringExtra2, stringExtra3);
            return;
        }
        if (intent != null && !TextUtils.isEmpty(intent.getStringExtra("returl"))) {
            String stringExtra4 = intent.getStringExtra("retcode");
            if (stringExtra4 != null) {
                try {
                    i16 = Integer.parseInt(stringExtra4);
                } catch (Exception e16) {
                    QwLog.i("ActivateTenpayAccount callback fail: " + e16.toString());
                }
            }
            setRetCodeMsgAndGetBundle(i16, intent.getStringExtra("retmsg"));
            TenUtils.notifyToExit(getContext(), this.mProssesID);
            WalletGateData.getInstance().clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0(View view, boolean z16) {
        UIUtils.handleFocusChange(this.mMyKeyBoard, view, z16, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$1() {
        this.mNextBtn.setEnabled(validatePage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$2() {
        String obj = this.mInputIdNumber.getText().toString();
        if (!this.mIsResetPassState) {
            fillInSexTextView(obj);
        }
        this.mNextBtn.setEnabled(validatePage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$intercept8_16PopRealName$6(RealNameAgePopHelper.EnumPopAgeType enumPopAgeType, RealNameAgePopHelper.EnumPopResult enumPopResult) {
        if (enumPopResult == RealNameAgePopHelper.EnumPopResult.REJECT) {
            return;
        }
        IdVerifyUtils.forwardMsgToFriend(getOutActivity(), 104, 1063, getResources().getString(R.string.f21857643), getResources().getString(R.string.f21858644));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$intercept8_16PopRealName$7(RealNameAgePopHelper.EnumPopAgeType enumPopAgeType, int i3, Intent intent) {
        if (i3 == -1 && intent != null) {
            this.mPhoneNum = intent.getStringExtra("phone");
            this.mPhoneNumToken = intent.getStringExtra("token");
            RealNameAgePopHelper.popAgeDialog(requireActivity(), enumPopAgeType, new RealNameAgePopHelper.IRealNamePopCallback() { // from class: com.tenpay.sdk.activity.bl
                @Override // com.tenpay.sdk.helper.RealNameAgePopHelper.IRealNamePopCallback
                public final void onPopCallback(RealNameAgePopHelper.EnumPopAgeType enumPopAgeType2, RealNameAgePopHelper.EnumPopResult enumPopResult) {
                    IdVerifyActivity.this.lambda$intercept8_16PopRealName$6(enumPopAgeType2, enumPopResult);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBack$3(DialogInterface dialogInterface, int i3) {
        com.tencent.mobileqq.qwallet.c.c("abandon.identify.cancel", Integer.valueOf(getProcessType()));
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBack$4(DialogInterface dialogInterface, int i3) {
        com.tencent.mobileqq.qwallet.c.c("abandon.identify.go", Integer.valueOf(getProcessType()));
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBlError$12(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$tryPopRealNameNew$5(RealNameAgePopHelper.EnumPopAgeType enumPopAgeType, RealNameAgePopHelper.EnumPopResult enumPopResult) {
        QwLog.i("IdVerify pop result: " + enumPopResult + ",popType:" + enumPopAgeType);
        if ((enumPopAgeType == RealNameAgePopHelper.EnumPopAgeType.ADULT_PASS_18 && enumPopResult == RealNameAgePopHelper.EnumPopResult.AGREE) || enumPopAgeType == RealNameAgePopHelper.EnumPopAgeType.PARENT_CONFIRM_16_18) {
            com.tencent.mobileqq.qwallet.c.e("realname.agree.click", "", "", "", "");
        }
        if (enumPopResult == RealNameAgePopHelper.EnumPopResult.REJECT) {
            return;
        }
        int i3 = AnonymousClass6.$SwitchMap$com$tenpay$sdk$helper$RealNameAgePopHelper$EnumPopAgeType[enumPopAgeType.ordinal()];
        if (i3 == 3 || i3 == 4) {
            checkFormAndConfirm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBack() {
        String string;
        if (TextUtils.isEmpty(this.mInputUserName.getText()) && TextUtils.isEmpty(this.mInputIdNumber.getText()) && TextUtils.isEmpty(this.mVerifyAddress.getText()) && TextUtils.isEmpty(this.mVerifyValidBeginDate.getText()) && TextUtils.isEmpty(this.mVerifyValidDate.getText()) && TextUtils.isEmpty(this.mVerifyJob.getText())) {
            finish();
            return;
        }
        if (this.mIsResetPassState) {
            string = getString(R.string.e9g);
        } else {
            string = getString(R.string.e96);
        }
        com.tencent.mobileqq.qwallet.c.c("abandon.identify.show", Integer.valueOf(getProcessType()));
        QUIProxy.createCustomDialog(getContext(), 230, null, string, getString(R.string.eds), getString(R.string.edu), new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.bp
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                IdVerifyActivity.this.lambda$onBack$3(dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.bq
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                IdVerifyActivity.this.lambda$onBack$4(dialogInterface, i3);
            }
        });
    }

    private void onCheckFormFail(int i3) {
        if (i3 == 130213) {
            this.mUserSexLayout.setVisibility(0);
        }
    }

    private void onFaceVerifyFinish(Intent intent) {
        if (intent == null) {
            return;
        }
        int intExtra = intent.getIntExtra(QWalletFaceProxyFragment.KEY_OUT_PARAM_RET_CODE, FaceVerifyErr.ERROR_CANCEL.getRetCode());
        String stringExtra = intent.getStringExtra(QWalletFaceProxyFragment.KEY_OUT_PARAM_RET_MSG);
        QLog.i(((NetBaseActivity) this).TAG, 1, "onFaceVerifyFinish: code=" + intExtra + ", msg=" + stringExtra);
        if (intExtra == FaceVerifyErr.OK.getRetCode()) {
            goVerifyNext();
        } else if (!TextUtils.isEmpty(stringExtra)) {
            QQToastUtil.showQQToast(1, stringExtra);
        }
    }

    private void onPhoneInputSuccess() {
        showLoading();
        pl2.h<QWalletCreditReg$GetFaceTokenRsp> hVar = new pl2.h<QWalletCreditReg$GetFaceTokenRsp>(this) { // from class: com.tenpay.sdk.activity.IdVerifyActivity.3
            @Override // pl2.k
            public void onFail(int i3, @NonNull String str) {
                IdVerifyActivity.this.dismissLoading();
            }

            @Override // pl2.k
            public void onSuccess(@NonNull QWalletCreditReg$GetFaceTokenRsp qWalletCreditReg$GetFaceTokenRsp) {
                IdVerifyActivity.this.dismissLoading();
                String str = qWalletCreditReg$GetFaceTokenRsp.token_id.get();
                String str2 = qWalletCreditReg$GetFaceTokenRsp.channel_info.get();
                if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                    IdVerifyActivity.this.goVerifyNext();
                    return;
                }
                IdVerifyActivity.this.faceVerifyBean = new FaceVerifyBean(qWalletCreditReg$GetFaceTokenRsp.token_id.get(), qWalletCreditReg$GetFaceTokenRsp.channel_info.get(), null, IdVerifyActivity.this.mInputUserName.getText().toString(), IdVerifyActivity.this.mInputIdNumber.getText().toString().trim(), 1);
                QLog.i(((NetBaseActivity) IdVerifyActivity.this).TAG, 1, "start face: " + IdVerifyActivity.this.faceVerifyBean);
                QWalletFaceProxyFragment.start(IdVerifyActivity.this.requireContext(), IdVerifyActivity.this.faceVerifyBean, 108);
            }
        };
        QWalletCreditReg$GetFaceTokenReq qWalletCreditReg$GetFaceTokenReq = new QWalletCreditReg$GetFaceTokenReq();
        qWalletCreditReg$GetFaceTokenReq.reserved.set("reserved");
        QWalletGatewayServlet.INSTANCE.sendRequest("trpc.qwallet.regbind.Creditreg", "GetFaceToken", qWalletCreditReg$GetFaceTokenReq, new QWalletCreditReg$GetFaceTokenRsp(), true, false, false, null, hVar);
    }

    private void onSelectedFriendCallback(Intent intent) {
        if (intent != null && intent.getExtras() != null) {
            String string = intent.getExtras().getString("uin");
            QLog.w(((NetBaseActivity) this).TAG, 1, "onSelectedFriendCallback:" + string);
            if (TextUtils.equals(string, this.mUin)) {
                QQToastUtil.showQQToast(1, R.string.f2188164q);
                QwLog.i("onSelectedFriendCallback abort, same uin " + string);
                return;
            }
            HashMap<String, String> paramsMap = getParamsMap(this.mInputUserName.getText().toString().trim(), this.mInputIdNumber.getText().toString().trim());
            paramsMap.put("uin", this.mUin);
            paramsMap.put("guard_uin", string);
            paramsMap.put("reg_type", String.valueOf(EnumIdVerifyType.IdCard.getValue()));
            paramsMap.put("token", this.mPhoneNumToken);
            httpRequest(Cgi.URI_MINORREG_APPLY, paramsMap);
            return;
        }
        QwLog.i("onSelectedFriendCallback abort, data is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSexSelectClick() {
        if (!isSexChangeable()) {
            return;
        }
        try {
            if (!isFinishing()) {
                showCoverDialog();
                getSexActionSheet().show();
            }
        } catch (Exception e16) {
            QLog.e(((NetBaseActivity) this).TAG, 1, "action sheet show error", e16);
        }
    }

    private void sendAuthNotify(String str, String str2) {
        QwLog.e("sendAuthNotify");
        httpRequest(Cgi.URI_QWallet_NAME_AUTH_NOTIFY, getParamsMap(str, str2), false);
    }

    private void sendAuthRequest(String str, String str2) {
        QwLog.e("sendAuthRequest");
        HashMap<String, String> paramsMap = getParamsMap(str, str2);
        this.mProgressBar.setVisibility(0);
        PrivacyTipConfig.e(paramsMap);
        httpRequest(Cgi.URI_QWallet_AUTH, paramsMap);
    }

    private void showCoverDialog() {
        if (this.mCoverDialog == null) {
            if (getContext() == null) {
                return;
            } else {
                this.mCoverDialog = new CoverDialog(getContext());
            }
        }
        this.mCoverDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryPopRealNameNew(String str) {
        if (intercept8_16PopRealName(str).booleanValue()) {
            return;
        }
        RealNameAgePopHelper.tryPopByCID(requireActivity(), str, new RealNameAgePopHelper.IRealNamePopCallback() { // from class: com.tenpay.sdk.activity.bk
            @Override // com.tenpay.sdk.helper.RealNameAgePopHelper.IRealNamePopCallback
            public final void onPopCallback(RealNameAgePopHelper.EnumPopAgeType enumPopAgeType, RealNameAgePopHelper.EnumPopResult enumPopResult) {
                IdVerifyActivity.this.lambda$tryPopRealNameNew$5(enumPopAgeType, enumPopResult);
            }
        });
    }

    private void updateMoreVerifyTypeBtn() {
        RealNameSource realNameSource;
        PrivacyTipConfig.SourceContent sourceContent;
        Intent intent = getIntent();
        if (intent != null && (realNameSource = (RealNameSource) intent.getParcelableExtra(RealNameSource.EXTRA_KEY_SOURCE)) != null && (sourceContent = ((PrivacyTipConfig) ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).getConfig(IQWalletUnitedConfigApi.QWALLET_PRIVACY_TIP_CONFIG, new PrivacyTipConfig())).d().get(realNameSource.getSourceId())) != null && sourceContent.getHideSupportCertificate()) {
            this.mMoreVerifyTypeBtn.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean validateIdNumber() {
        String obj = this.mInputIdNumber.getText().toString();
        if (obj.length() < 18 && obj.length() != 15) {
            Context context = getContext();
            if (context != null) {
                QQToast.makeText(context, R.string.f171346e91, 0).show();
            }
            this.mInputIdNumber.onError();
            this.mInputIdNumber.requestFocus();
            return false;
        }
        if (obj.length() == 18 && obj.indexOf(42) < 0 && !Utils.invalidateID(obj.toUpperCase())) {
            Context context2 = getContext();
            if (context2 != null) {
                QQToast.makeText(context2, R.string.f171346e91, 0).show();
            }
            this.mInputIdNumber.onError();
            this.mInputIdNumber.requestFocus();
            return false;
        }
        if (!this.mIsResetPassState && TextUtils.isEmpty(this.mTvVerifySex.getText())) {
            Context context3 = getContext();
            if (context3 != null) {
                QQToast.makeText(context3, R.string.f17930390, 0).show();
            }
            this.mUserSexLayout.setVisibility(0);
            this.mTvVerifySex.requestFocus();
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean validatePage() {
        if (TextUtils.isEmpty(this.mInputUserName.getText()) || TextUtils.isEmpty(this.mInputIdNumber.getText().toString())) {
            return false;
        }
        if (this.mIsResetPassState) {
            return true;
        }
        if (TextUtils.isEmpty(this.mVerifyValidBeginDate.getText()) || TextUtils.isEmpty(this.mVerifyValidDate.getText()) || TextUtils.isEmpty(this.mVerifyAddress.getText())) {
            return false;
        }
        return !TextUtils.isEmpty(this.mVerifyJob.getText());
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            onBack();
            com.tencent.mobileqq.qwallet.c.c("identify.info.keyback", Integer.valueOf(getProcessType()));
            return true;
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment
    @NonNull
    public FragmentAnimation getFragmentAnimation() {
        return FragmentAnimation.PULL_UP;
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity
    protected int getProcessType() {
        if (this.mIsResetPassState) {
            if (!this.mIsFromH5FindPsw && this.mIsFromResetPassBridge) {
                return 159;
            }
            return 158;
        }
        return 154;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        QwLog.i("onActivityResult...requestCode:" + i3 + ",resultCode:" + i16 + ",data:" + intent);
        switch (i3) {
            case 100:
                if (i16 == -1) {
                    com.tencent.mobileqq.qwallet.c.c("extra.resetpwd.ok", Integer.valueOf(getProcessType()));
                    setResult(-1);
                    WalletGateData.getInstance().clear();
                    finish();
                    return;
                }
                return;
            case 101:
            case 103:
            default:
                return;
            case 102:
                if (i16 == -1) {
                    updateProfession(intent.getStringExtra(JobSelectionActivity.PARAM_SELECTED_JOB));
                    return;
                }
                return;
            case 104:
                if (i16 == -1) {
                    onSelectedFriendCallback(intent);
                    return;
                }
                return;
            case 105:
                setResult(-1);
                finish();
                return;
            case 106:
                setRetCodeMsgAndGetBundle(-11005, "\u4f60\u5df2\u6210\u529f\u5b8c\u6210\u8eab\u4efd\u9a8c\u8bc1\uff0c\u65e0\u9700\u91cd\u590d\u9a8c\u8bc1\u3002");
                exitCurrentProcess();
                WalletGateData.getInstance().clear();
                return;
            case 107:
                if (i16 == -1) {
                    setResult(-1, intent);
                    finish();
                    return;
                }
                return;
            case 108:
                if (i16 == -1) {
                    onFaceVerifyFinish(intent);
                    return;
                }
                return;
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onBlError(String str, JSONObject jSONObject) {
        if (str.equals(Cgi.URI_QWallet_NAME_AUTH_NOTIFY)) {
            return;
        }
        super.onBlError(str, jSONObject);
        ProgressBar progressBar = this.mProgressBar;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        String optString = jSONObject.optString("retcode");
        QwLog.e("onBlError,err_code:" + optString);
        if (!"-1".equals(optString) && ErrorCode.ERR_NET.equals(optString)) {
            QUIProxy.createCustomDialog(getContext(), 230, null, "\u7f51\u7edc\u8fde\u63a5\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc\u8bbe\u7f6e\u3002", getString(R.string.e5j), null, null, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.br
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    IdVerifyActivity.this.lambda$onBlError$12(dialogInterface, i3);
                }
            });
        }
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.mIsResetPassState = intent.getBooleanExtra("forget_pass", false);
            this.mIsFromH5FindPsw = intent.getBooleanExtra("h5_find_pwd", false);
            this.mIsFromResetPassBridge = intent.getBooleanExtra("from_resetpass_bridge", false);
            this.mFromHb = getIntent().getBooleanExtra("from_hb", false);
            QwLog.i("mIsResetPassState = " + this.mIsResetPassState + ",mIsFromH5FindPsw = " + this.mIsFromH5FindPsw + ",mIsFromResetPassBridge = " + this.mIsFromResetPassBridge + ",authen_channel_state = " + this.authen_channel_state);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.f168582af2, viewGroup, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity
    public void onNetDlgokClick(String str, JSONObject jSONObject) {
        super.onNetDlgokClick(str, jSONObject);
        com.tencent.mobileqq.qwallet.c.c("identify.info.identify-fail", Integer.valueOf(getProcessType()));
        int parseInt = Integer.parseInt(jSONObject.optString("retcode"));
        String optString = jSONObject.optString("retmsg");
        boolean equals = TextUtils.equals(Uri.parse(jSONObject.optString("returl")).getQueryParameter("exitProcess"), "0");
        if (str.equals(Cgi.URI_QWallet_AUTH) && !equals) {
            QwLog.e("retcode is " + parseInt + ", retmsg is " + optString);
            setRetCodeMsgAndGetBundle(parseInt, optString);
            WalletGateData.getInstance().clear();
            finish();
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(String str, JSONObject jSONObject) {
        IdVerifyStateBean idVerifyStateBean;
        super.onSuccess(str, jSONObject);
        ProgressBar progressBar = this.mProgressBar;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        if (str.equals(Cgi.URI_QWallet_AUTH)) {
            String optString = jSONObject.optString(IdVerifyFinishProcessor.KEY_AUTH_COMMENT);
            String optString2 = jSONObject.optString(IdVerifyFinishProcessor.KEY_AUTH_TIP);
            QwLog.i("onSuccess,auth_comment\uff1a" + optString);
            RealNameSourceReporter.INSTANCE.reportIdVerifyGet(false);
            IdVerifyHintModule.startCommonSuccessHint(this, optString, optString2);
            MarketServiceUtils.sendMarketServiceSwitch();
            com.tencent.mobileqq.qwallet.c.c("identify.info.beingcheck", Integer.valueOf(getProcessType()));
            return;
        }
        if (str.equals(Cgi.URI_QWallet_AUTH_RESET_PASSWD)) {
            String optString3 = jSONObject.optString("token");
            QwLog.i("onSuccess,token\uff1a" + optString3);
            goToResetPassword(optString3);
            return;
        }
        if (Cgi.URL_WALLET_GATE.equals(str)) {
            WalletGateData.getInstance().setData(this.mUin, jSONObject, System.currentTimeMillis());
            initGateData(jSONObject);
            QwLog.i("authen_channel_state = " + this.authen_channel_state);
            return;
        }
        if (Cgi.URI_MINORREG_APPLY.equals(str)) {
            try {
                idVerifyStateBean = (IdVerifyStateBean) new GsonBuilder().create().fromJson(jSONObject.toString(), IdVerifyStateBean.class);
            } catch (Exception e16) {
                QLog.w(((NetBaseActivity) this).TAG, 1, "parse IdVerifyStateBean fail: ", e16);
                idVerifyStateBean = null;
            }
            IdVerifyHintModule.startStateBeanHint(this, idVerifyStateBean, null, jSONObject.optString("list_id"), null, 105);
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        bindViewId(view);
        view.setAlpha(1.0f);
        initView(view);
    }

    public void updateProfession(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mJobName = str;
            this.mVerifyJob.setText(str);
            this.mNextBtn.setEnabled(validatePage());
        }
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
