package com.tenpay.sdk.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.DialerKeyListener;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.heytap.databaseengine.type.DeviceType;
import com.huawei.hms.adapter.internal.CommonCode;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.base.FragmentAnimation;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.TextNode;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.widget.ActionSheet;
import com.tenpay.ErrorCode;
import com.tenpay.QwLog;
import com.tenpay.api.MyKeyboardWindow;
import com.tenpay.api.QWalletUtils;
import com.tenpay.bank.BankConstants;
import com.tenpay.face.FaceVerifyErr;
import com.tenpay.face.QWalletFaceProxyFragment;
import com.tenpay.fingerpay.FingerPaySettingSoterFragment;
import com.tenpay.idverify.IdVerifyDirectionFragment;
import com.tenpay.idverify.IdVerifyModule;
import com.tenpay.idverify.hint.IdVerifyHintModule;
import com.tenpay.idverify.model.ChildrenRealNameConfig;
import com.tenpay.idverify.utils.IdVerifyUtils;
import com.tenpay.lcation.LocationInputFragment;
import com.tenpay.marketservice.MarketServiceUtils;
import com.tenpay.ndk.CertUtil;
import com.tenpay.pay.ChoosePayTypeFragment;
import com.tenpay.proxy.ASProxy;
import com.tenpay.proxy.DataProxy;
import com.tenpay.proxy.QUIProxy;
import com.tenpay.proxy.dlg.age.AgeSelDlg;
import com.tenpay.proxy.dlg.location.QbAddrData;
import com.tenpay.realname.RealNameSource;
import com.tenpay.realname.RealNameSourceReporter;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.IResult;
import com.tenpay.sdk.QWalletFakeUrl;
import com.tenpay.sdk.activity.ActivateTenpayAccount;
import com.tenpay.sdk.helper.RealNameAgePopHelper;
import com.tenpay.sdk.helper.RealNamePopHelper;
import com.tenpay.sdk.model.BindBankFaceBean;
import com.tenpay.sdk.net.NetParams;
import com.tenpay.sdk.util.AESUtils;
import com.tenpay.sdk.util.JSONConstant;
import com.tenpay.sdk.util.TenUtils;
import com.tenpay.sdk.util.TenpayUtil;
import com.tenpay.sdk.util.UIUtils;
import com.tenpay.sdk.util.WalletGateData;
import com.tenpay.sdk.view.ClearableEditText;
import com.tenpay.sdk.view.OnPasswdInputListener;
import com.tenpay.sdk.view.SixPasswdDialogEditText;
import com.tenpay.sdk.view.TenpayEditText;
import com.tenpay.sdk.view.TenpayNumberEditText;
import com.tenpay.sdk.view.ValidDateEdit;
import com.tenpay.util.Utils;
import cooperation.qqcircle.report.QCircleLpReportDc05502;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.apache.httpcore.message.TokenParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import qk2.BindCardTipConfig;
import x05.c;

/* compiled from: P */
/* loaded from: classes27.dex */
public class BindBankActivity extends NetBaseActivity implements View.OnClickListener {
    protected static final int DEPOSIT_GO_SETACCOUNT = 2000;
    private static final String ID_CARD_TYPE_DEFAULT_SFZ = "1";
    public static final String KEY_IGNORED_DIRECTION_PAGE = "KEY_IGNORED_DIRECTION_PAGE";
    protected static final int LAYOUT_ID_VERIFY_INDEX = 0;
    protected static final int LAYOUT_INPUT_BANKCARD_NUM_INDEX = 1;
    protected static final int LAYOUT_INPUT_VERIFY_CODE_INDEX = 3;
    protected static final int LAYOUT_INPUT_VERIFY_PASSWORD_INDEX = 4;
    protected static final int LAYOUT_PERSON_INFO_INDEX = 2;
    protected static final int REQUEST_CODE_DIRECTION = 1004;
    private static final int REQUEST_CODE_HAND_CHOICE = 10;
    protected static final int REQUEST_CODE_IDVERIFY_ENTRY = 1003;
    protected static final int REQUEST_CODE_PROFESSION = 1002;
    public static final int REQUEST_CODE_VERIFY_PASSWORD = 1000;
    private static List<Sex> sSexList = new ArrayList<Sex>() { // from class: com.tenpay.sdk.activity.BindBankActivity.29
        {
            add(new Sex("\u7537", 1));
            add(new Sex("\u5973", 2));
        }
    };
    private LinearLayout cardEndDateLayout;
    private TextView cardEndDateTxt;
    private LinearLayout cardStartDateLayout;
    private TextView cardStartDateTxt;
    private Dialog dialog;
    private boolean hasTipSexChange;
    private RealNamePopHelper helper;
    private boolean isQuickMode;
    private TextView mAddressTxt;
    protected TextView mBackBtn;
    private JSONObject mBankData;
    private ArrayList<JSONObject> mBankList;
    private JSONObject mBankSupportJson;
    private int mBankSupportVer;
    protected JSONObject mBinBank;
    private TenpayEditText mBinInputBankCvv;
    private LinearLayout mBinInputBankCvvLayout;
    private LinearLayout mBinInputCredit;
    private ValidDateEdit mBinInputCreditThru;
    private View mBinInputCreditThruLayout;
    private View mBinInputCreditThruLine;
    private TextView mBinInputHint;
    private ClearableEditText mBinInputPhone;
    private ScrollView mBinInputScroll;
    private TextView mBinInputSelBankName;
    private TextView mBinInputSubHint;
    protected JSONArray mBinJson;
    private int mBinLen;
    private Button mBinNextBnt;
    private TenpayNumberEditText mBinNo;
    private LinearLayout mBinPhoneLayout;
    private TextView mBinTextUser;
    private LinearLayout mBinUserLayout;
    protected int mBinVerSer;
    private BindBankFaceBean mBindBankFaceBean;
    protected JSONObject mBindCardPreObj;
    protected TextView mCancelBtn;
    private ClearableEditText mCardIdEdit;
    private ClearableEditText mCardOtherId;
    private Dialog mCardTypeDialog;
    private LinearLayout mCardTypeLayout;
    private Dialog mCardTypeListDialog;
    private TextView mCardTypeTxt;
    private int mCurSexType;
    protected String mDepositCount;
    private String mDetailAddress;
    protected List<JSONObject> mFastCreditBankList;
    protected List<JSONObject> mFastDebitBankList;
    protected boolean mForgetPassCache;
    protected boolean mForgetPassFlag;
    private boolean mFromHBShiMing;
    private Map<String, String> mGetYzmData;
    private TextView mGrapHBTips;
    private String mHBShiMingTips;
    private Button mIdVerifyBtn;
    private ClearableEditText mIdVerifyCardIdEdit;
    private LinearLayout mIdVerifyCardTypeLayout;
    private TextView mIdVerifyCardTypeTxt;
    private Button mIdVerifyConfirm;
    private LinearLayout mIdVerifyLayout;
    private ClearableEditText mIdVerifyOtherCardIdEdit;
    private ClearableEditText mIdVerifyUserNameEdit;
    protected boolean mIsDepositCredit;
    private boolean mIsShiMing;
    protected boolean mIsWithdrawCredit;
    private TextView mJobTxt;
    private MyKeyboardWindow mKeyBoard;
    long mLastClickedTime;
    protected ClearableEditText mLongPwdEdit;
    private ClearableEditText mNameEdit;
    private LinearLayout mNameLayout;
    protected int mPassFlag;
    protected String mPasswd;
    private Button mPersonInfoConfirm;
    protected LinearLayout mPersonalInfoLayout;
    private String mPhoneNum;
    protected HashMap<String, String> mRegisterExcuteYzmObj;
    protected HashMap<String, String> mRegisterRequestYzmParamsObj;
    private View mRootView;
    private LinearLayout mSelectBankLayout;
    private LinearLayout mSexLayout;
    private TextView mSexTxt;
    private Dialog mSexTypeDialog;
    protected SixPasswdDialogEditText mSixPasswdEdit;
    protected CountDownTimer mTimer;
    private String mTraceNameTemp;
    protected LinearLayout mVerifyPasswordLayout;
    protected String mWithdrawCount;
    protected Button mYzNextBtn;
    protected ClearableEditText mYzmEdit;
    protected Button mYzmGetSMSBtn;
    protected LinearLayout mYzmLayout;
    protected ClearableEditText mYzmPhoneNum;
    protected TextView mYzmSubTitle;
    protected String prefillUserInfo;
    private RealNameSource realNameSource;
    private Button verifyPasswordBtn;
    protected int sendSmsNum = 0;
    protected boolean mIsFromWithdraw = false;
    protected boolean mIsFromDeposit = false;
    protected boolean mIsFromCheckPsw = false;
    protected boolean mIsFromH5FindPsw = false;
    protected boolean mIsFromChoosePayTypeSmall = false;
    protected boolean mIsFromFingerPaySetting = false;
    protected boolean mIsFromFingerPay = false;
    protected int mFingerPayProcessType = 137;
    protected boolean mIsFromFingerDeposit = false;
    protected int mFingerDepositProcessType = 139;
    protected JSONObject mCFTUserDepositObj = new JSONObject();
    protected JSONObject mNewUserDepositObj = new JSONObject();
    private String mTrustPayOpen = "";
    private ArrayList<JSONObject> mCardTypeList = new ArrayList<>();
    private ArrayList<JSONObject> mCardTypeFullList = new ArrayList<>();
    private JSONObject mCardTypeSFZ = null;
    private int mBindGuide = 0;
    private boolean isShowPersonInfo = false;
    protected int mPageIndex = 1;
    protected HashMap<String, String> mRegisterPreObj = new HashMap<>();
    protected boolean mIsNeedVerifyPasswd = false;
    protected int mFrom = 0;
    protected String traceName = "bind.info.";
    private LinkedHashMap<String, Boolean> buttonMaps = new LinkedHashMap<>();
    private boolean mIsFromPayShiMing = false;
    private boolean mIsFromQrCodepay = false;
    private boolean mIsIdVerifyValid = false;
    private int mAuthenChanelState = 0;
    private String mJobName = "";
    private String mProvince = "";
    private String mCity = "";
    private String mDistrict = "";
    boolean needShowSmallPrivacy = true;
    public View.OnFocusChangeListener keyOnFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.tenpay.sdk.activity.BindBankActivity.19
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z16) {
            if (z16) {
                if (view instanceof ClearableEditText) {
                    ((ClearableEditText) view).manageClearButton();
                }
                InputMethodManager inputMethodManager = (InputMethodManager) BindBankActivity.this.getActivity().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
                if (BindBankActivity.this.mBinInputBankCvv.hasFocus()) {
                    Drawable drawable = BindBankActivity.this.getResources().getDrawable(R.drawable.dw5);
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                    BindBankActivity.this.mBinInputBankCvv.setCompoundDrawables(BindBankActivity.this.mBinInputBankCvv.getCompoundDrawables()[0], BindBankActivity.this.mBinInputBankCvv.getCompoundDrawables()[1], drawable, BindBankActivity.this.mBinInputBankCvv.getCompoundDrawables()[3]);
                    BindBankActivity.this.mBinInputBankCvv.setCompoundDrawablePadding(3);
                } else {
                    BindBankActivity.this.mBinInputBankCvv.setCompoundDrawables(BindBankActivity.this.mBinInputBankCvv.getCompoundDrawables()[0], BindBankActivity.this.mBinInputBankCvv.getCompoundDrawables()[1], null, BindBankActivity.this.mBinInputBankCvv.getCompoundDrawables()[3]);
                }
                if (BindBankActivity.this.mBinInputCreditThru.hasFocus()) {
                    Drawable drawable2 = BindBankActivity.this.getResources().getDrawable(R.drawable.e0p);
                    drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
                    BindBankActivity.this.mBinInputCreditThru.setCompoundDrawables(BindBankActivity.this.mBinInputCreditThru.getCompoundDrawables()[0], BindBankActivity.this.mBinInputCreditThru.getCompoundDrawables()[1], drawable2, BindBankActivity.this.mBinInputCreditThru.getCompoundDrawables()[3]);
                    BindBankActivity.this.mBinInputCreditThru.setCompoundDrawablePadding(3);
                } else {
                    BindBankActivity.this.mBinInputCreditThru.setCompoundDrawables(BindBankActivity.this.mBinInputCreditThru.getCompoundDrawables()[0], BindBankActivity.this.mBinInputCreditThru.getCompoundDrawables()[1], null, BindBankActivity.this.mBinInputCreditThru.getCompoundDrawables()[3]);
                }
                if (view != BindBankActivity.this.mNameEdit) {
                    if (view == BindBankActivity.this.mCardIdEdit) {
                        BindBankActivity.this.mKeyBoard.setXMode(1);
                    } else {
                        if (view != BindBankActivity.this.mBinInputPhone) {
                            BindBankActivity bindBankActivity = BindBankActivity.this;
                            if (view != bindBankActivity.mYzmEdit) {
                                bindBankActivity.mKeyBoard.setXMode(2);
                            }
                        }
                        BindBankActivity.this.mKeyBoard.setXMode(3);
                    }
                    BindBankActivity.this.mKeyBoard.setVisibility(0);
                    BindBankActivity.this.mKeyBoard.setInputEditText((EditText) view);
                }
                if (view == BindBankActivity.this.mCardIdEdit) {
                    BindBankActivity.this.addTraceData("idcard");
                }
                if (view == BindBankActivity.this.mBinInputPhone) {
                    BindBankActivity.this.addTraceData("phonenumber");
                    int[] iArr = new int[2];
                    if (BindBankActivity.this.mBinNextBnt != null) {
                        BindBankActivity.this.mBinNextBnt.getLocationInWindow(iArr);
                        int[] iArr2 = new int[2];
                        BindBankActivity.this.mBinInputScroll.getLocationInWindow(iArr2);
                        BindBankActivity.this.mBinInputScroll.smoothScrollBy(0, ((iArr[1] - iArr2[1]) - BindBankActivity.this.mBinInputScroll.getHeight()) + BindBankActivity.this.mBinNextBnt.getHeight() + 5);
                    }
                }
                if (BindBankActivity.this.mNameEdit.hasFocus()) {
                    BindBankActivity.this.mKeyBoard.setVisibility(8);
                    return;
                }
                return;
            }
            if (view instanceof ClearableEditText) {
                ((ClearableEditText) view).removeClearButton();
            }
            if (!BindBankActivity.this.mBinNo.isFocused() && !BindBankActivity.this.mBinInputCreditThru.isFocused() && !BindBankActivity.this.mBinInputBankCvv.isFocused() && !BindBankActivity.this.mBinInputPhone.isFocused()) {
                BindBankActivity.this.mKeyBoard.setVisibility(8);
            }
        }
    };
    public View.OnClickListener keyOnClickListener = new View.OnClickListener() { // from class: com.tenpay.sdk.activity.BindBankActivity.20
        @Override // android.view.View.OnClickListener
        public void onClick(final View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (BindBankActivity.this.mKeyBoard.getVisibility() == 8) {
                view.postDelayed(new Runnable() { // from class: com.tenpay.sdk.activity.BindBankActivity.20.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BindBankActivity.this.mKeyBoard.setVisibility(0);
                        if (view != BindBankActivity.this.mCardIdEdit && view != BindBankActivity.this.mIdVerifyCardIdEdit) {
                            BindBankActivity.this.mKeyBoard.setXMode(3);
                        } else {
                            BindBankActivity.this.mKeyBoard.setXMode(1);
                        }
                        BindBankActivity.this.mKeyBoard.setInputEditText((EditText) view);
                    }
                }, 200L);
                if (view == BindBankActivity.this.mBinInputPhone) {
                    BindBankActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.tenpay.sdk.activity.BindBankActivity.20.2
                        @Override // java.lang.Runnable
                        public void run() {
                            int[] iArr = new int[2];
                            if (BindBankActivity.this.mBinNextBnt != null) {
                                BindBankActivity.this.mBinNextBnt.getLocationInWindow(iArr);
                                int[] iArr2 = new int[2];
                                BindBankActivity.this.mBinInputScroll.getLocationInWindow(iArr2);
                                BindBankActivity.this.mBinInputScroll.smoothScrollBy(0, ((iArr[1] - iArr2[1]) - BindBankActivity.this.mBinInputScroll.getHeight()) + BindBankActivity.this.mBinNextBnt.getHeight() + 5);
                            }
                        }
                    }, 300L);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    };
    private LinkedHashMap<String, Boolean> sexMaps = new LinkedHashMap<>();
    private Runnable mSetSexRunnable = new Runnable() { // from class: com.tenpay.sdk.activity.BindBankActivity.30
        @Override // java.lang.Runnable
        public void run() {
            BindBankActivity.this.mSexTxt.setText(TenUtils.getSexStrByType(BindBankActivity.this.getContext(), BindBankActivity.this.mCurSexType));
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class Sex {
        public String des;
        public int type;

        Sex(String str, int i3) {
            this.des = str;
            this.type = i3;
        }
    }

    private void bindViewId(View view) {
        view.findViewById(R.id.ivTitleName).setVisibility(8);
        TextView textView = (TextView) view.findViewById(R.id.ivTitleBtnLeft);
        this.mBackBtn = textView;
        textView.setOnClickListener(this);
        this.mBackBtn.setVisibility(0);
        TextView textView2 = (TextView) view.findViewById(R.id.ivTitleBtnRightText);
        this.mCancelBtn = textView2;
        textView2.setText(R.string.e2i);
        this.mCancelBtn.setVisibility(8);
        this.mCancelBtn.setOnClickListener(this);
        MyKeyboardWindow myKeyboardWindow = (MyKeyboardWindow) view.findViewById(R.id.a_1);
        this.mKeyBoard = myKeyboardWindow;
        setKeyboardTouchOutsizeCancel(myKeyboardWindow);
        initIdVerifyPage(view);
        initBankInfoPage(view);
        initPersonalInfoPage(view);
        initYzmPage(view);
        initVerifyPasswordPage(view);
        QWalletUtils.hideSysKeyBorad(this.mIdVerifyCardIdEdit);
        QWalletUtils.hideSysKeyBorad(this.mBinInputPhone);
        QWalletUtils.hideSysKeyBorad(this.mBinNo);
        QWalletUtils.hideSysKeyBorad(this.mBinInputCreditThru);
        QWalletUtils.hideSysKeyBorad(this.mBinInputBankCvv);
        QWalletUtils.hideSysKeyBorad(this.mCardIdEdit);
        QWalletUtils.hideSysKeyBorad(this.mYzmPhoneNum);
        QWalletUtils.hideSysKeyBorad(this.mYzmEdit);
    }

    private void cardIdTimeClick(final TextView textView) {
        AgeSelDlg ageSelDlg = new AgeSelDlg(getContext(), textView.equals(this.cardStartDateTxt));
        ageSelDlg.setOnDateSelectListener(new AgeSelDlg.OnDateSelectListener() { // from class: com.tenpay.sdk.activity.BindBankActivity.28
            @Override // com.tenpay.proxy.dlg.age.AgeSelDlg.OnDateSelectListener
            public void dateSelectListener(int i3, int i16, int i17) {
                String formatDate;
                TextView textView2 = textView;
                if (i3 == 9999) {
                    formatDate = AgeSelDlg.LONG_YEAR_TXT;
                } else {
                    formatDate = Utils.formatDate(i3, i16, i17);
                }
                textView2.setText(formatDate);
                BindBankActivity.this.mPersonInfoConfirm.setEnabled(BindBankActivity.this.validatePersonalInfo());
            }

            @Override // com.tenpay.proxy.dlg.age.AgeSelDlg.OnDateSelectListener
            public void dateSelectNotValid() {
                textView.setText("");
                BindBankActivity.this.mPersonInfoConfirm.setEnabled(BindBankActivity.this.validatePersonalInfo());
            }
        });
        ageSelDlg.popupPickerView(R.id.f163936cz, textView.getText().toString());
    }

    private void checkBankSupportConfig() {
        String str = this.mCacheVer;
        QwLog.e("mCacheVer is " + str);
        try {
            this.mBankSupportVer = 1;
            try {
                String substring = str.substring(str.indexOf("BANK"));
                int indexOf = substring.indexOf(124);
                if (indexOf > 0) {
                    substring = substring.substring(0, indexOf);
                }
                this.mBankSupportVer = Integer.parseInt(substring.substring(substring.indexOf(47) + 1));
            } catch (Exception unused) {
                this.mBankSupportVer = 1;
            }
            QwLog.e("mBankSupportVer is " + this.mBankSupportVer);
            int i3 = getSharedPreferences("qb_tenpay_prefer", 0).getInt("bank_support_ver", 0);
            QwLog.e("ver_bank_support_loc is " + i3);
            if (i3 == this.mBankSupportVer) {
                FileInputStream fileInputStream = null;
                try {
                    fileInputStream = getApplicationContext().openFileInput("qb_tenpay_bank_support");
                    byte[] bArr = new byte[1024];
                    StringBuilder sb5 = new StringBuilder();
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        } else {
                            sb5.append(new String(bArr, 0, read));
                        }
                    }
                    this.mBankSupportJson = new JSONObject(sb5.toString());
                } catch (Exception unused2) {
                } catch (Throwable th5) {
                    Utils.closeObject(fileInputStream);
                    throw th5;
                }
                Utils.closeObject(fileInputStream);
            } else {
                sendQueryBankSupportList();
            }
            QwLog.e("mBankSupportJson is " + this.mBankSupportJson.toString());
        } catch (Exception e16) {
            QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
        }
    }

    private void checkFormAndConfirm() {
        int i3;
        ClearableEditText clearableEditText;
        try {
            i3 = Integer.parseInt(this.mCardType);
        } catch (NumberFormatException e16) {
            QLog.e(((NetBaseActivity) this).TAG, 1, "checkFormAndConfirm:", e16);
            i3 = 0;
        }
        int i16 = i3;
        if (i16 == 0) {
            personInfoConfirm();
            return;
        }
        showLoading();
        IdVerifyUtils idVerifyUtils = IdVerifyUtils.INSTANCE;
        String obj = this.mNameEdit.getText().toString();
        if (this.mCardType.equals("1")) {
            clearableEditText = this.mCardIdEdit;
        } else {
            clearableEditText = this.mCardOtherId;
        }
        idVerifyUtils.checkForm(this, obj, clearableEditText.getText().toString().trim(), this.cardStartDateTxt.getText().toString().trim(), this.cardEndDateTxt.getText().toString().trim(), i16, this.mJobTxt.getText().toString().trim(), this.mCurSexType, this.mProvince, this.mCity, this.mDistrict, this.mDetailAddress, new Function2() { // from class: com.tenpay.sdk.activity.n
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj2, Object obj3) {
                Unit lambda$checkFormAndConfirm$13;
                lambda$checkFormAndConfirm$13 = BindBankActivity.this.lambda$checkFormAndConfirm$13((Boolean) obj2, (Integer) obj3);
                return lambda$checkFormAndConfirm$13;
            }
        });
    }

    private void confirmYzmDeposit(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("flag", str);
        int i3 = this.mUserAttr;
        if (i3 != 0 && i3 != 3) {
            hashMap.put(TPDownloadProxyEnum.USER_SSID, this.mCFTUserDepositObj.optString(TPDownloadProxyEnum.USER_SSID));
        } else {
            hashMap.put(TPDownloadProxyEnum.USER_SSID, this.mNewUserDepositObj.optString(TPDownloadProxyEnum.USER_SSID));
        }
        hashMap.put("uin", this.mUin);
        hashMap.put("bank_type", this.mBinBank.optString("code"));
        hashMap.put("verify_code", this.mYzmEdit.getText().toString().trim());
        int i16 = this.mUserAttr;
        if (i16 != 0 && i16 != 3 && this.mCFTUserDepositObj.optString("pwd_verify").equals("1") && this.mPasswd != null && str.equals("2")) {
            hashMap.put("pay_passwd", this.mPasswd);
        }
        hashMap.put("timestamp", this.mTimestamp + "");
        httpRequest(Cgi.URI_QWallet_VERIFY_DEPOSIT, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void emulateTouchEvent(View view) {
        MotionEvent obtain = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, 0.0f, 0.0f, 0);
        view.dispatchTouchEvent(obtain);
        MotionEvent obtain2 = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, 0.0f, 0.0f, 0);
        view.dispatchTouchEvent(obtain2);
        obtain.recycle();
        obtain2.recycle();
    }

    private int getMidasProcessType() {
        if (this.mIsFromFingerPaySetting) {
            if (this.mUserAttr == 0) {
                return 134;
            }
            return 133;
        }
        if (this.mIsFromFingerPay) {
            return this.mFingerPayProcessType;
        }
        int i3 = this.mUserAttr;
        if (i3 != 0 && i3 != 3) {
            if (this.mForgetPassFlag) {
                return 10;
            }
            if (this.mIsNeedVerifyPasswd) {
                return 3;
            }
            return 2;
        }
        return 4;
    }

    private String getPassword() {
        String inputText;
        if (this.mLongPwdEdit.getVisibility() == 0) {
            inputText = this.mLongPwdEdit.getText().toString();
        } else {
            inputText = this.mSixPasswdEdit.getInputText();
        }
        return inputText.trim();
    }

    private void getSmsYzm() {
        if (this.mIsFromDeposit && !this.mForgetPassFlag) {
            int i3 = this.mUserAttr;
            if (i3 != 0 && i3 != 3) {
                registerGetYzmDeposit("2");
                return;
            } else {
                registerGetYzmDeposit("1");
                return;
            }
        }
        if (this.mForgetPassFlag) {
            registerGetYzm();
            return;
        }
        int i16 = this.mUserAttr;
        if (i16 != 0 && i16 != 3) {
            if (i16 == 1 || i16 == 2) {
                bindCardGetYzm();
                return;
            }
            return;
        }
        registerGetYzm();
    }

    private JSONObject getUserInfoExtend() {
        HashMap hashMap = new HashMap();
        if (this.isShowPersonInfo) {
            hashMap.put("sex", this.mCurSexType + "");
            String trim = this.cardStartDateTxt.getText().toString().trim();
            if (!TextUtils.isEmpty(trim)) {
                hashMap.put("creditcard_begin_date", trim);
            }
            String trim2 = this.cardEndDateTxt.getText().toString().trim();
            if (!TextUtils.isEmpty(trim2)) {
                if (trim2.equals(AgeSelDlg.LONG_YEAR_TXT)) {
                    hashMap.put("creditcard_exp_date", Utils.formatDate(9999, 12, 31));
                } else {
                    hashMap.put("creditcard_exp_date", trim2);
                }
            }
            hashMap.put("job", this.mJobTxt.getText().toString().trim());
            hashMap.put("province", this.mProvince);
            hashMap.put("city", this.mCity);
            hashMap.put(TtmlNode.TAG_REGION, this.mDistrict);
            hashMap.put("address", this.mDetailAddress);
        }
        if (!TextUtils.isEmpty(this.mPhoneNum)) {
            hashMap.put(DeviceType.DeviceCategory.MOBILE, this.mPhoneNum);
        }
        if (!useNewBindBankProgram() && this.helper.getParentParams().size() > 0) {
            hashMap.putAll(this.helper.getParentParams());
        }
        return new JSONObject(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void giveUpBindbank() {
        setResult(0);
        finish();
    }

    private void gotoFaceVerify() {
        if (isFinishing()) {
            QwLog.e("gotoFaceVerify fail, activity isFinishing");
            return;
        }
        Context context = getContext();
        if (context == null) {
            QwLog.e("gotoFaceVerify fail, context is null");
            return;
        }
        BindBankFaceBean bindBankFaceBean = this.mBindBankFaceBean;
        if (bindBankFaceBean == null) {
            QwLog.e("gotoFaceVerify fail, mBindBankFaceBean is null");
        } else {
            QWalletFaceProxyFragment.start(context, bindBankFaceBean.toVerifyBean(), 101);
        }
    }

    private void guideToIdVerify() {
        QQCustomDialog createCustomDialogUrlWithoutAutoLink = DialogUtil.createCustomDialogUrlWithoutAutoLink(getQBaseActivity(), 230, R.layout.f167856jn, (String) null, getResources().getString(R.string.f2176761n), R.string.cancel, R.string.f21854640, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                BindBankActivity.this.lambda$guideToIdVerify$10(dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.l
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                dialogInterface.dismiss();
            }
        });
        createCustomDialogUrlWithoutAutoLink.setCancelable(false);
        createCustomDialogUrlWithoutAutoLink.setCanceledOnTouchOutside(false);
        createCustomDialogUrlWithoutAutoLink.show();
    }

    private void handleBindUserNextStepNew(boolean z16) {
        RealNameAgePopHelper.EnumPopAgeType enumPopAgeType;
        String str;
        if (z16) {
            enumPopAgeType = RealNameAgePopHelper.EnumPopAgeType.intValueOf(this.mBindGuide);
        } else {
            enumPopAgeType = null;
        }
        if (enumPopAgeType == null) {
            if (this.mCardIdEdit.getVisibility() == 0) {
                str = this.mCardIdEdit.getText().toString().trim();
            } else {
                str = "";
            }
            enumPopAgeType = RealNameAgePopHelper.getCidAgeType(str);
        }
        if (enumPopAgeType == RealNameAgePopHelper.EnumPopAgeType.PARENT_COMMIT_8_16) {
            if (z16) {
                handleFirstBindUserNextStepOld();
                return;
            } else {
                guideToIdVerify();
                return;
            }
        }
        if (z16) {
            handleFirstBindUserNextStepOld();
        } else {
            handleUnnamedUserNextStepOld();
        }
    }

    private void handleFirstBindUserNextStep() {
        handleBindUserNextStepNew(true);
    }

    private void handleFirstBindUserNextStepOld() {
        this.helper.tryPop(this.mBindGuide, new RealNamePopHelper.RealNamePopListener() { // from class: com.tenpay.sdk.activity.BindBankActivity.26
            @Override // com.tenpay.sdk.helper.RealNamePopHelper.RealNamePopListener
            public void onPoped(int i3, int i16) {
                QwLog.i("bindBank handleFirstBindUserNextStep pop result: " + i16 + ",popType:" + i3);
                if (i16 != 2 && i16 != 3) {
                    if (i16 == 4) {
                        BindBankActivity.this.helper.pros8to14ChildParentInfoLogic(BindBankActivity.this.mCardIdEdit.getText().toString().trim());
                        return;
                    }
                    return;
                }
                BindBankActivity.this.showView(3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleNamedUserNextStep() {
        if (this.isShowPersonInfo) {
            showView(2);
        } else {
            showView(3);
        }
    }

    private void handleUnnamedUserNextStep() {
        handleBindUserNextStepNew(false);
    }

    private void handleUnnamedUserNextStepOld() {
        final String str;
        if (this.mCardIdEdit.getVisibility() == 0) {
            str = this.mCardIdEdit.getText().toString().trim();
        } else {
            str = "";
        }
        this.helper.tryPopByCreditIdFromIdVerify(str, new RealNamePopHelper.RealNamePopListener() { // from class: com.tenpay.sdk.activity.BindBankActivity.25
            @Override // com.tenpay.sdk.helper.RealNamePopHelper.RealNamePopListener
            public void onPoped(int i3, int i16) {
                QwLog.i("bindBank handleUnnamedUserNextStep pop result: " + i16 + ",popType:" + i3);
                if ((i3 == 3 && i16 == 2) || i3 == 2) {
                    com.tencent.mobileqq.qwallet.c.e("realname.agree.click", "", "", "", "");
                }
                if (i16 != 2 && i16 != 3) {
                    if (i16 == 4) {
                        BindBankActivity.this.helper.pros8to14ChildParentInfoLogic(str);
                        return;
                    }
                    return;
                }
                BindBankActivity.this.showView(3);
            }
        });
    }

    private void initBankInfoPage(View view) {
        this.mBinInputHint = (TextView) view.findViewById(R.id.a9_);
        this.mBinInputSubHint = (TextView) view.findViewById(R.id.t6w);
        if (this.mIsFromWithdraw && !this.mForgetPassFlag) {
            this.mBinInputHint.setText(R.string.e_n);
        } else if (this.mIsFromDeposit && !this.mForgetPassFlag) {
            this.mBinInputHint.setText(R.string.e_m);
        } else if (this.mIsShiMing) {
            this.mBinInputHint.setText(R.string.eeg);
        } else if (this.mForgetPassFlag) {
            this.mBinInputHint.setText(R.string.e1n);
            this.mBinInputSubHint.setText(R.string.f1792638w);
        } else {
            this.mBinInputHint.setText(R.string.e2g);
        }
        this.mGrapHBTips = (TextView) view.findViewById(R.id.cw_);
        if (!TextUtils.isEmpty(this.mHBShiMingTips)) {
            this.mGrapHBTips.setText(this.mHBShiMingTips);
            this.mGrapHBTips.setVisibility(0);
        }
        this.mBinInputScroll = (ScrollView) view.findViewById(R.id.a9v);
        this.mBinUserLayout = (LinearLayout) view.findViewById(R.id.a9y);
        this.mBinTextUser = (TextView) view.findViewById(R.id.a_4);
        TenpayNumberEditText tenpayNumberEditText = (TenpayNumberEditText) view.findViewById(R.id.a99);
        this.mBinNo = tenpayNumberEditText;
        tenpayNumberEditText.setOnFocusChangeListener(this.keyOnFocusChangeListener);
        this.mBinNo.setOnClickListener(this.keyOnClickListener);
        if (this.mForgetPassFlag) {
            this.mBinNo.setHint(R.string.e3n);
        }
        if (getResources().getConfiguration().orientation == 2) {
            this.mBinNo.setKeyListener(new DialerKeyListener() { // from class: com.tenpay.sdk.activity.BindBankActivity.5
                @Override // android.text.method.DialerKeyListener, android.text.method.NumberKeyListener
                protected char[] getAcceptedChars() {
                    return new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', TokenParser.SP};
                }

                @Override // android.text.method.DialerKeyListener, android.text.method.KeyListener
                public int getInputType() {
                    return 3;
                }
            });
        }
        this.mBinNo.addTextChangedListener(new TextWatcher() { // from class: com.tenpay.sdk.activity.BindBankActivity.6
            /* JADX WARN: Code restructure failed: missing block: B:180:0x013a, code lost:
            
                if (r4.endsWith(com.tenpay.proxy.dlg.location.QbAddrData.DATA_SPLITER + r3) != false) goto L18;
             */
            /* JADX WARN: Removed duplicated region for block: B:152:0x03b2  */
            /* JADX WARN: Removed duplicated region for block: B:20:0x0154 A[LOOP:1: B:14:0x00d6->B:20:0x0154, LOOP_END] */
            /* JADX WARN: Removed duplicated region for block: B:21:0x013f A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:61:0x027a  */
            /* JADX WARN: Removed duplicated region for block: B:75:0x02a9 A[EDGE_INSN: B:75:0x02a9->B:76:0x02a9 BREAK  A[LOOP:3: B:59:0x026e->B:69:0x02a6], SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:78:0x02af  */
            /* JADX WARN: Removed duplicated region for block: B:81:0x02d9  */
            @Override // android.text.TextWatcher
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void afterTextChanged(Editable editable) {
                String str;
                JSONObject jSONObject;
                int i3;
                boolean z16;
                JSONObject jSONObject2;
                JSONObject jSONObject3;
                BindBankActivity bindBankActivity;
                int i16;
                int indexOf;
                boolean z17;
                String data = BindBankActivity.this.mBinNo.getData();
                int length = data.length();
                int i17 = 0;
                if (length < 10) {
                    BindBankActivity.this.mBinNo.setFilters(new InputFilter[]{new InputFilter.LengthFilter(31)});
                    BindBankActivity bindBankActivity2 = BindBankActivity.this;
                    bindBankActivity2.mBinBank = null;
                    bindBankActivity2.mBinInputCredit.setVisibility(8);
                    BindBankActivity.this.mBinInputBankCvv.setText("");
                    BindBankActivity.this.mBinInputCreditThru.setText("");
                    BindBankActivity.this.mBinPhoneLayout.setVisibility(8);
                    BindBankActivity.this.mBinInputPhone.setText("");
                    BindBankActivity.this.mSelectBankLayout.setVisibility(8);
                    return;
                }
                if (BindBankActivity.this.mBinNo.changeStart < 12) {
                    BindBankActivity.this.mBinNo.setFilters(new InputFilter[]{new InputFilter.LengthFilter(31)});
                    BindBankActivity bindBankActivity3 = BindBankActivity.this;
                    bindBankActivity3.mBinBank = null;
                    bindBankActivity3.mBinInputCredit.setVisibility(8);
                    BindBankActivity.this.mBinInputBankCvv.setText("");
                    BindBankActivity.this.mBinInputCreditThru.setText("");
                    BindBankActivity.this.mBinPhoneLayout.setVisibility(8);
                    BindBankActivity.this.mBinInputPhone.setText("");
                    int i18 = 2;
                    if (BindBankActivity.this.mBinJson != null) {
                        String substring = data.substring(0, 10);
                        jSONObject2 = null;
                        z16 = false;
                        while (true) {
                            if (substring.length() > i18) {
                                int i19 = i17;
                                while (true) {
                                    if (i19 >= BindBankActivity.this.mBinJson.length()) {
                                        break;
                                    }
                                    String optString = BindBankActivity.this.mBinJson.optJSONObject(i19).optString("bin");
                                    if (!optString.equals(substring)) {
                                        indexOf = optString.indexOf(QbAddrData.DATA_SPLITER + substring + QbAddrData.DATA_SPLITER);
                                        if (indexOf < 0) {
                                            if (!optString.startsWith(substring + QbAddrData.DATA_SPLITER)) {
                                            }
                                        }
                                        if (indexOf < 0) {
                                            JSONObject optJSONObject = BindBankActivity.this.mBinJson.optJSONObject(i19);
                                            if (optJSONObject.optInt("type") == 2) {
                                                z17 = true;
                                            } else {
                                                z17 = false;
                                            }
                                            jSONObject2 = optJSONObject;
                                            z16 = z17;
                                        } else {
                                            i19++;
                                        }
                                    }
                                    indexOf = 1;
                                    if (indexOf < 0) {
                                    }
                                }
                                if (jSONObject2 != null) {
                                    i3 = 0;
                                    break;
                                } else {
                                    substring = substring.substring(0, substring.length() - 1);
                                    i17 = 0;
                                    i18 = 2;
                                }
                            } else {
                                i3 = i17;
                                break;
                            }
                        }
                    } else {
                        i3 = 0;
                        z16 = false;
                        jSONObject2 = null;
                    }
                    BindBankActivity.this.mSelectBankLayout.setVisibility(i3);
                    if (jSONObject2 != null) {
                        BindBankActivity.this.mBinLen = jSONObject2.optInt(com.tencent.luggage.wxa.c8.c.E, -1);
                        str = data;
                        BindBankActivity.this.mBinNo.setFilters(new InputFilter[]{new InputFilter.LengthFilter(BindBankActivity.this.mBinLen + ((BindBankActivity.this.mBinLen - 1) / 4))});
                        String upperCase = jSONObject2.optString("sname").toUpperCase();
                        if (z16) {
                            BindBankActivity bindBankActivity4 = BindBankActivity.this;
                            if (bindBankActivity4.mIsFromWithdraw && !bindBankActivity4.mForgetPassFlag) {
                                bindBankActivity4.mIsWithdrawCredit = true;
                                QQToast.makeText(bindBankActivity4.getContext(), 1, BindBankActivity.this.getString(R.string.e9n), 0).show();
                                return;
                            }
                            if (bindBankActivity4.mIsFromDeposit && !bindBankActivity4.mForgetPassFlag) {
                                bindBankActivity4.mIsDepositCredit = true;
                                QQToast.makeText(bindBankActivity4.getContext(), 1, BindBankActivity.this.getString(R.string.e9m), 0).show();
                                return;
                            }
                            if (bindBankActivity4.mFastCreditBankList != null) {
                                for (int i26 = 0; i26 < BindBankActivity.this.mFastCreditBankList.size(); i26++) {
                                    jSONObject3 = BindBankActivity.this.mFastCreditBankList.get(i26);
                                    if (jSONObject3.optString("sname").equals(upperCase)) {
                                        break;
                                    }
                                }
                            }
                            jSONObject3 = null;
                            if (jSONObject3 == null && BindBankActivity.this.mBankList != null) {
                                i16 = 0;
                                while (true) {
                                    if (i16 < BindBankActivity.this.mBankList.size()) {
                                        break;
                                    }
                                    JSONObject jSONObject4 = (JSONObject) BindBankActivity.this.mBankList.get(i16);
                                    String optString2 = jSONObject4.optString("type");
                                    if (((NetParams.DEBIT_FAST.equals(optString2) && !z16) || (NetParams.CREDIT_FAST.equals(optString2) && z16)) && jSONObject4.optString("sname").equals(upperCase)) {
                                        jSONObject3 = jSONObject4;
                                        break;
                                    }
                                    i16++;
                                }
                            }
                            bindBankActivity = BindBankActivity.this;
                            if (bindBankActivity.mBinBank != jSONObject3) {
                                bindBankActivity.mBinInputCredit.setVisibility(8);
                                BindBankActivity.this.mBinPhoneLayout.setVisibility(8);
                                BindBankActivity.this.mBinInputBankCvv.setText("");
                                BindBankActivity.this.mBinInputCreditThru.setText("");
                            }
                            BindBankActivity bindBankActivity5 = BindBankActivity.this;
                            bindBankActivity5.mBinBank = jSONObject3;
                            if (jSONObject3 == null) {
                                if (bindBankActivity5.mIsMidas) {
                                    bindBankActivity5.addTraceData("define." + jSONObject3.optString("code"));
                                } else {
                                    bindBankActivity5.addTraceData("cardbinok");
                                }
                                String optString3 = jSONObject3.optString("name");
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append(optString3);
                                int optInt = jSONObject3.optInt("disabled");
                                String optString4 = jSONObject3.optString("disable_comment");
                                if (optInt > 0) {
                                    if (!TextUtils.isEmpty(optString4)) {
                                        QQToast.makeText(BindBankActivity.this.getContext(), 0, optString4, 0).show();
                                    } else {
                                        String str2 = "\u8be5\u573a\u666f\u4e0b\u6b64\u94f6\u884c\u5361\u4e0d\u53ef\u7528";
                                        if (optInt != 1) {
                                            if (optInt == 2) {
                                                str2 = "\u5e73\u53f0\u6682\u4e0d\u652f\u6301\u8be5\u94f6\u884c";
                                            } else if (optInt == 3) {
                                                str2 = "\u5546\u6237\u6682\u4e0d\u652f\u6301\u8be5\u94f6\u884c";
                                            } else if (optInt == 5) {
                                                str2 = "\u94f6\u884c\u7cfb\u7edf\u7ef4\u62a4\u4e2d";
                                            }
                                        }
                                        QQToast.makeText(BindBankActivity.this.getContext(), 0, str2, 0).show();
                                    }
                                    sb5.append("(\u4e0d\u652f\u6301\u8be5\u64cd\u4f5c)");
                                }
                                BindBankActivity.this.mBinInputSelBankName.setText(sb5.toString());
                                AnimationSet animationSet = new AnimationSet(true);
                                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                                alphaAnimation.setDuration(500L);
                                TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
                                translateAnimation.setDuration(500L);
                                animationSet.addAnimation(translateAnimation);
                                animationSet.addAnimation(alphaAnimation);
                                BindBankActivity.this.mBinInputCredit.setLayoutAnimation(new LayoutAnimationController(animationSet, 0.5f));
                            } else {
                                if (bindBankActivity5.mIsMidas) {
                                    bindBankActivity5.addTraceData("undefine");
                                } else {
                                    bindBankActivity5.addTraceData("cardbinno");
                                }
                                BindBankActivity.this.mBinInputCredit.setLayoutAnimation(null);
                                BindBankActivity.this.mBinInputSelBankName.setText(R.string.f171358ec3);
                                BindBankActivity.this.mBinNextBnt.setEnabled(false);
                            }
                        } else {
                            BindBankActivity bindBankActivity6 = BindBankActivity.this;
                            bindBankActivity6.mIsWithdrawCredit = false;
                            if (bindBankActivity6.mFastDebitBankList != null) {
                                for (int i27 = 0; i27 < BindBankActivity.this.mFastDebitBankList.size(); i27++) {
                                    jSONObject3 = BindBankActivity.this.mFastDebitBankList.get(i27);
                                    if (jSONObject3.optString("sname").equals(upperCase)) {
                                        break;
                                    }
                                }
                            }
                            jSONObject3 = null;
                            if (jSONObject3 == null) {
                                i16 = 0;
                                while (true) {
                                    if (i16 < BindBankActivity.this.mBankList.size()) {
                                    }
                                    i16++;
                                }
                            }
                            bindBankActivity = BindBankActivity.this;
                            if (bindBankActivity.mBinBank != jSONObject3) {
                            }
                            BindBankActivity bindBankActivity52 = BindBankActivity.this;
                            bindBankActivity52.mBinBank = jSONObject3;
                            if (jSONObject3 == null) {
                            }
                        }
                    } else {
                        str = data;
                        BindBankActivity bindBankActivity7 = BindBankActivity.this;
                        if (bindBankActivity7.mIsMidas) {
                            bindBankActivity7.addTraceData("undefine");
                        } else {
                            bindBankActivity7.addTraceData("cardbinno");
                        }
                        BindBankActivity bindBankActivity8 = BindBankActivity.this;
                        bindBankActivity8.mIsWithdrawCredit = false;
                        bindBankActivity8.mBinBank = null;
                        bindBankActivity8.mBinLen = -1;
                        BindBankActivity.this.mBinInputCredit.setLayoutAnimation(null);
                        BindBankActivity.this.mBinInputSelBankName.setText(R.string.f171358ec3);
                        BindBankActivity.this.mBinNextBnt.setEnabled(false);
                    }
                } else {
                    str = data;
                }
                if (BindBankActivity.this.mBinLen > 0 && length > BindBankActivity.this.mBinLen - 1) {
                    JSONObject jSONObject5 = BindBankActivity.this.mBinBank;
                    if (jSONObject5 != null && jSONObject5.optInt("disabled") > 0) {
                        return;
                    }
                    BindBankActivity bindBankActivity9 = BindBankActivity.this;
                    int i28 = bindBankActivity9.mFrom;
                    if ((i28 == 0 || i28 == 1) && !bindBankActivity9.mForgetPassFlag && !bindBankActivity9.mIsFromDeposit && (jSONObject = bindBankActivity9.mBinBank) != null) {
                        String optString5 = jSONObject.optString("type");
                        if ((NetParams.DEBIT_FAST.equals(optString5) || NetParams.CREDIT_FAST.equals(optString5)) && BindBankActivity.this.mBinBank.optString("card_tail").equals(str.substring(length - 5, length - 1))) {
                            StringBuffer stringBuffer = new StringBuffer();
                            stringBuffer.append(BindBankActivity.this.getString(R.string.e1c));
                            QUIProxy.createCustomDialog(BindBankActivity.this.getContext(), 230, null, stringBuffer.toString(), BindBankActivity.this.getString(R.string.e5j), null, null, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.BindBankActivity.6.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i29) {
                                    BindBankActivity.this.mBinNo.setText("");
                                }
                            });
                            return;
                        }
                    }
                    BindBankActivity bindBankActivity10 = BindBankActivity.this;
                    bindBankActivity10.initInputBankInfo(bindBankActivity10.mBinBank);
                    BindBankActivity bindBankActivity11 = BindBankActivity.this;
                    if (bindBankActivity11.mBinBank != null) {
                        if (bindBankActivity11.mBinInputCredit.getVisibility() == 0) {
                            if (BindBankActivity.this.mBinInputCreditThru.getVisibility() == 0 && BindBankActivity.this.mBinInputCreditThru.getText().toString().length() == 0) {
                                BindBankActivity.this.mBinInputCreditThru.requestFocus();
                            } else if (BindBankActivity.this.mBinInputBankCvv.getText().toString().length() == 0) {
                                BindBankActivity.this.mBinInputBankCvv.requestFocus();
                            }
                        } else if (BindBankActivity.this.mBinInputPhone.getText().toString().length() == 0) {
                            BindBankActivity.this.mBinInputPhone.requestFocus();
                        }
                    }
                }
                if (length >= Math.max(13, BindBankActivity.this.mBinLen)) {
                    BindBankActivity.this.mBinNextBnt.setEnabled(BindBankActivity.this.validatePageOne());
                } else {
                    BindBankActivity.this.mBinNextBnt.setEnabled(false);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            }
        });
        Button button = (Button) view.findViewById(R.id.a9b);
        this.mBinNextBnt = button;
        if (button != null) {
            button.setOnClickListener(this);
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.a9j);
        this.mSelectBankLayout = linearLayout;
        linearLayout.setClickable(true);
        this.mSelectBankLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.BindBankActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EventCollector.getInstance().onViewClickedBefore(view2);
                BindBankActivity bindBankActivity = BindBankActivity.this;
                if (bindBankActivity.mIsMidas) {
                    bindBankActivity.addTraceData("choose");
                }
                BindBankActivity.this.showSelectBankDialog();
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
        this.mBinInputSelBankName = (TextView) view.findViewById(R.id.a9x);
        this.mBinPhoneLayout = (LinearLayout) view.findViewById(R.id.ggw);
        ClearableEditText clearableEditText = (ClearableEditText) view.findViewById(R.id.a9u);
        this.mBinInputPhone = clearableEditText;
        clearableEditText.setOnFocusChangeListener(this.keyOnFocusChangeListener);
        this.mBinInputPhone.setOnClickListener(this.keyOnClickListener);
        this.mBinInputPhone.addTextChangedListener(new x05.b() { // from class: com.tenpay.sdk.activity.BindBankActivity.8
            @Override // x05.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (BindBankActivity.this.isMobileNumber(editable.toString())) {
                    BindBankActivity.this.mBinNextBnt.setEnabled(BindBankActivity.this.validatePageOne());
                } else {
                    BindBankActivity.this.mBinNextBnt.setEnabled(false);
                }
            }
        });
        this.mBinInputPhone.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.tenpay.sdk.activity.BindBankActivity.9
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
                if (keyEvent != null && keyEvent.getKeyCode() == 66) {
                    BindBankActivity.this.mBinNextBnt.setEnabled(BindBankActivity.this.validatePageOne());
                }
                EventCollector.getInstance().onEditorAction(textView, i3, keyEvent);
                return false;
            }
        });
        ((Button) view.findViewById(R.id.a_2)).setOnClickListener(this);
        this.mBinInputCredit = (LinearLayout) view.findViewById(R.id.a9q);
        this.mBinInputCreditThruLayout = view.findViewById(R.id.a9s);
        this.mBinInputCreditThruLine = view.findViewById(R.id.a9t);
        ValidDateEdit validDateEdit = (ValidDateEdit) view.findViewById(R.id.a9r);
        this.mBinInputCreditThru = validDateEdit;
        validDateEdit.setOnFocusChangeListener(this.keyOnFocusChangeListener);
        this.mBinInputCreditThru.setOnClickListener(this.keyOnClickListener);
        this.mBinInputCreditThru.addTextChangedListener(new TextWatcher() { // from class: com.tenpay.sdk.activity.BindBankActivity.10
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() == 5) {
                    BindBankActivity.this.mBinInputCreditThru.clearError();
                    if (BindBankActivity.this.mBinInputBankCvv.getVisibility() == 0 && BindBankActivity.this.mBinInputBankCvv.getText().toString().length() == 0) {
                        BindBankActivity.this.mBinInputBankCvv.requestFocus();
                        return;
                    }
                    if (BindBankActivity.this.mBinPhoneLayout.getVisibility() != 0) {
                        BindBankActivity.this.mBinPhoneLayout.setVisibility(0);
                        BindBankActivity bindBankActivity = BindBankActivity.this;
                        if (bindBankActivity.mIsMidas) {
                            bindBankActivity.addTraceData("name");
                        } else {
                            bindBankActivity.addTraceData("holderinfo");
                        }
                    }
                    if (BindBankActivity.this.mBinInputPhone.getText().toString().length() == 0) {
                        BindBankActivity.this.mBinInputPhone.requestFocus();
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            }
        });
        this.mBinInputBankCvvLayout = (LinearLayout) view.findViewById(R.id.a9g);
        TenpayEditText tenpayEditText = (TenpayEditText) view.findViewById(R.id.a9e);
        this.mBinInputBankCvv = tenpayEditText;
        tenpayEditText.setOnFocusChangeListener(this.keyOnFocusChangeListener);
        this.mBinInputBankCvv.setOnClickListener(this.keyOnClickListener);
        this.mBinInputBankCvv.addTextChangedListener(new TextWatcher() { // from class: com.tenpay.sdk.activity.BindBankActivity.11
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() == 3 && BindBankActivity.this.mBinPhoneLayout.getVisibility() != 0) {
                    BindBankActivity.this.mBinPhoneLayout.setVisibility(0);
                    BindBankActivity.this.mBinInputPhone.requestFocus();
                    BindBankActivity bindBankActivity = BindBankActivity.this;
                    if (bindBankActivity.mIsMidas) {
                        bindBankActivity.addTraceData("name");
                    } else {
                        bindBankActivity.addTraceData("holderinfo");
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            }
        });
        Button button2 = (Button) view.findViewById(R.id.db5);
        this.mIdVerifyBtn = button2;
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.BindBankActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                boolean z16;
                EventCollector.getInstance().onViewClickedBefore(view2);
                com.tencent.mobileqq.qwallet.c.c("bind.info.identitycard", Integer.valueOf(BindBankActivity.this.getProcessType()));
                BindBankActivity bindBankActivity = BindBankActivity.this;
                if (bindBankActivity.mAuthenChanelState != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                IdVerifyModule.startFromBindBank(bindBankActivity, z16, BindBankActivity.this.realNameSource);
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
        initIdVerifyGuideTips(view);
    }

    private void initIdVerifyGuideTips(@Nullable View view) {
        if (view == null) {
            return;
        }
        View findViewById = view.findViewById(R.id.t6x);
        TextView textView = (TextView) view.findViewById(R.id.t6y);
        SpannableString spannableString = new SpannableString(getString(R.string.f2176861o));
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.bcm)), spannableString.length() - 2, spannableString.length(), 17);
        textView.setText(spannableString);
        int i3 = this.mUserAttr;
        if (i3 != 0 && i3 != 1 && i3 != 3) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BindBankActivity.this.lambda$initIdVerifyGuideTips$2(view2);
                }
            });
        }
    }

    private void initIdVerifyPage(View view) {
        this.mIdVerifyLayout = (LinearLayout) view.findViewById(R.id.f30540om);
        ClearableEditText clearableEditText = (ClearableEditText) view.findViewById(R.id.xgw);
        this.mIdVerifyUserNameEdit = clearableEditText;
        clearableEditText.setOnTextChangedListener(new ClearableEditText.OnTextChangedListener() { // from class: com.tenpay.sdk.activity.o
            @Override // com.tenpay.sdk.view.ClearableEditText.OnTextChangedListener
            public final void onTextChanged() {
                BindBankActivity.this.lambda$initIdVerifyPage$0();
            }
        });
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.xfu);
        this.mIdVerifyCardTypeLayout = linearLayout;
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.BindBankActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EventCollector.getInstance().onViewClickedBefore(view2);
                if (BindBankActivity.this.mKeyBoard != null && BindBankActivity.this.mKeyBoard.getVisibility() == 0) {
                    BindBankActivity.this.mKeyBoard.setVisibility(8);
                }
                BindBankActivity.this.selectIdCardType();
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
        this.mIdVerifyCardTypeTxt = (TextView) view.findViewById(R.id.xfv);
        ClearableEditText clearableEditText2 = (ClearableEditText) view.findViewById(R.id.xfs);
        this.mIdVerifyCardIdEdit = clearableEditText2;
        clearableEditText2.setOnTextChangedListener(new ClearableEditText.OnTextChangedListener() { // from class: com.tenpay.sdk.activity.BindBankActivity.3
            @Override // com.tenpay.sdk.view.ClearableEditText.OnTextChangedListener
            public void onTextChanged() {
                String obj = BindBankActivity.this.mIdVerifyCardIdEdit.getText().toString();
                if (obj.length() == 18 && obj.indexOf(42) < 0) {
                    if (BindBankActivity.invalidateID(obj.toUpperCase())) {
                        BindBankActivity.this.mIdVerifyCardIdEdit.clearError();
                    } else {
                        BindBankActivity.this.mIdVerifyCardIdEdit.onError();
                    }
                }
                BindBankActivity.this.helper.resetParentParams();
                BindBankActivity.this.mIdVerifyConfirm.setEnabled(BindBankActivity.this.validateIdVerify());
            }
        });
        this.mIdVerifyCardIdEdit.setKeyListener(new DialerKeyListener() { // from class: com.tenpay.sdk.activity.BindBankActivity.4
            @Override // android.text.method.DialerKeyListener, android.text.method.NumberKeyListener
            protected char[] getAcceptedChars() {
                return new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'x', 'X'};
            }

            @Override // android.text.method.DialerKeyListener, android.text.method.KeyListener
            public int getInputType() {
                return 1;
            }
        });
        this.mIdVerifyCardIdEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tenpay.sdk.activity.p
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view2, boolean z16) {
                BindBankActivity.this.lambda$initIdVerifyPage$1(view2, z16);
            }
        });
        this.mIdVerifyCardIdEdit.setOnClickListener(this.keyOnClickListener);
        this.mIdVerifyOtherCardIdEdit = (ClearableEditText) view.findViewById(R.id.xft);
        Button button = (Button) view.findViewById(R.id.xfw);
        this.mIdVerifyConfirm = button;
        button.setOnClickListener(this);
    }

    private void initPersonalInfoPage(View view) {
        this.mPersonalInfoLayout = (LinearLayout) view.findViewById(R.id.ggv);
        ClearableEditText clearableEditText = (ClearableEditText) view.findViewById(R.id.f115606wh);
        this.mNameEdit = clearableEditText;
        clearableEditText.setOnTextChangedListener(new ClearableEditText.OnTextChangedListener() { // from class: com.tenpay.sdk.activity.t
            @Override // com.tenpay.sdk.view.ClearableEditText.OnTextChangedListener
            public final void onTextChanged() {
                BindBankActivity.this.lambda$initPersonalInfoPage$3();
            }
        });
        this.mNameLayout = (LinearLayout) view.findViewById(R.id.f115486w6);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.tom);
        this.mCardTypeLayout = linearLayout;
        linearLayout.setClickable(true);
        this.mCardTypeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.BindBankActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EventCollector.getInstance().onViewClickedBefore(view2);
                if (BindBankActivity.this.mKeyBoard != null && BindBankActivity.this.mKeyBoard.getVisibility() == 0) {
                    BindBankActivity.this.mKeyBoard.setVisibility(8);
                }
                BindBankActivity.this.selectIdCardType();
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
        this.mCardTypeTxt = (TextView) view.findViewById(R.id.too);
        this.mCardOtherId = (ClearableEditText) view.findViewById(R.id.toa);
        ClearableEditText clearableEditText2 = (ClearableEditText) view.findViewById(R.id.tnw);
        this.mCardIdEdit = clearableEditText2;
        clearableEditText2.setOnTextChangedListener(new ClearableEditText.OnTextChangedListener() { // from class: com.tenpay.sdk.activity.BindBankActivity.14
            @Override // com.tenpay.sdk.view.ClearableEditText.OnTextChangedListener
            public void onTextChanged() {
                String obj = BindBankActivity.this.mCardIdEdit.getText().toString();
                if (obj.length() == 18 && obj.indexOf(42) < 0) {
                    if (BindBankActivity.invalidateID(obj.toUpperCase())) {
                        BindBankActivity.this.mCardIdEdit.clearError();
                    } else {
                        BindBankActivity.this.mCardIdEdit.onError();
                    }
                }
                try {
                } catch (Throwable th5) {
                    QLog.e(((NetBaseActivity) BindBankActivity.this).TAG, 1, "", th5);
                }
                if (!"1".equals(BindBankActivity.this.mCardType)) {
                    return;
                }
                BindBankActivity.this.mCurSexType = TenUtils.getSexTypeByID(obj);
                if (BindBankActivity.this.mCurSexType != 0) {
                    if (obj.length() == 15) {
                        BindBankActivity bindBankActivity = BindBankActivity.this;
                        bindBankActivity.mHandler.postDelayed(bindBankActivity.mSetSexRunnable, 800L);
                    } else {
                        BindBankActivity.this.mSexTxt.setText(TenUtils.getSexStrByType(BindBankActivity.this.getContext(), BindBankActivity.this.mCurSexType));
                    }
                } else {
                    BindBankActivity bindBankActivity2 = BindBankActivity.this;
                    bindBankActivity2.mHandler.removeCallbacks(bindBankActivity2.mSetSexRunnable);
                    BindBankActivity.this.mSexTxt.setText("");
                }
                BindBankActivity.this.helper.resetParentParams();
                BindBankActivity.this.mPersonInfoConfirm.setEnabled(BindBankActivity.this.validatePersonalInfo());
            }
        });
        this.mCardIdEdit.setKeyListener(new DialerKeyListener() { // from class: com.tenpay.sdk.activity.BindBankActivity.15
            @Override // android.text.method.DialerKeyListener, android.text.method.NumberKeyListener
            protected char[] getAcceptedChars() {
                return new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'x', 'X'};
            }

            @Override // android.text.method.DialerKeyListener, android.text.method.KeyListener
            public int getInputType() {
                return 1;
            }
        });
        this.mCardIdEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tenpay.sdk.activity.g
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view2, boolean z16) {
                BindBankActivity.this.lambda$initPersonalInfoPage$4(view2, z16);
            }
        });
        this.mCardIdEdit.setOnClickListener(this.keyOnClickListener);
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.tog);
        this.cardStartDateLayout = linearLayout2;
        linearLayout2.setOnClickListener(this);
        LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.tnk);
        this.cardEndDateLayout = linearLayout3;
        linearLayout3.setOnClickListener(this);
        this.cardStartDateTxt = (TextView) view.findViewById(R.id.toh);
        this.cardEndDateTxt = (TextView) view.findViewById(R.id.tnl);
        TextView textView = (TextView) view.findViewById(R.id.sdy);
        this.mAddressTxt = textView;
        textView.setOnClickListener(this);
        this.mJobTxt = (TextView) view.findViewById(R.id.y_v);
        ((LinearLayout) view.findViewById(R.id.y_u)).setOnClickListener(this);
        ((LinearLayout) view.findViewById(R.id.sdw)).setOnClickListener(this);
        Button button = (Button) view.findViewById(R.id.flj);
        this.mPersonInfoConfirm = button;
        button.setOnClickListener(this);
        this.mSexLayout = (LinearLayout) view.findViewById(R.id.iqg);
        this.mSexTxt = (TextView) view.findViewById(R.id.f109936h6);
        this.mSexLayout.setOnClickListener(this);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:(5:(1:14)|15|(1:17)|18|(2:20|(4:22|(1:24)(1:28)|25|26)(2:29|(1:35)(2:33|34)))(6:37|(2:65|(1:67)(1:68))(1:41)|42|(1:48)|49|(2:51|52)(4:53|(1:55)(1:64)|56|(1:62)(2:60|61))))|70|71|(2:72|(1:74)(1:75))|76|77|15|(0)|18|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0085, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0086, code lost:
    
        com.tencent.qphone.base.util.QLog.e(((com.tenpay.sdk.activity.NetBaseActivity) r8).TAG, 1, "", r4);
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0090 A[Catch: Exception -> 0x009e, TryCatch #0 {Exception -> 0x009e, blocks: (B:3:0x0005, B:9:0x0034, B:14:0x004c, B:15:0x008c, B:17:0x0090, B:77:0x007f, B:80:0x009a, B:81:0x009d, B:85:0x0032, B:71:0x0051, B:72:0x0065, B:74:0x006b, B:76:0x0074, B:83:0x0086, B:5:0x0007, B:7:0x001c, B:8:0x0020), top: B:2:0x0005, inners: #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0123  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void initView() {
        int i3;
        int i16;
        FileInputStream fileInputStream;
        try {
            this.mBinVerSer = 1;
            try {
                String str = this.mCacheVer;
                String substring = str.substring(str.indexOf("CARDBIN"));
                int indexOf = substring.indexOf(124);
                if (indexOf > 0) {
                    substring = substring.substring(0, indexOf);
                }
                this.mBinVerSer = Integer.parseInt(substring.substring(substring.indexOf(47) + 1));
            } catch (Exception unused) {
                this.mBinVerSer = 1;
            }
            i3 = getSharedPreferences("qb_tenpay_prefer", 0).getInt("bin_ver", 3);
            i16 = this.mBinVerSer;
        } catch (Exception e16) {
            QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
        }
        try {
            if (i16 > i3 && i16 > 3) {
                if (i16 > i3) {
                    sendQueryBinRequest();
                }
                if (this.mBinJson == null) {
                    this.mBinJson = new JSONConstant().mBinData;
                }
                if (!this.mForgetPassFlag) {
                    if (this.mUserAttr == 2) {
                        this.mBinUserLayout.setVisibility(0);
                        setTextAndUnEnable(this.mBinTextUser, this.mTrueName);
                        setTextAndUnEnable(this.mIdVerifyUserNameEdit, this.mTrueName);
                        setTextAndUnEnable(this.mNameEdit, this.mTrueName);
                        setCreIdTypeLayoutDisabled();
                        if (this.mCardType.equals("1")) {
                            this.mIdVerifyCardIdEdit.setVisibility(0);
                            this.mIdVerifyOtherCardIdEdit.setVisibility(8);
                        } else {
                            this.mIdVerifyCardIdEdit.setVisibility(8);
                            this.mIdVerifyOtherCardIdEdit.setVisibility(0);
                        }
                        setCreIdTypeText();
                        return;
                    }
                    this.mBinUserLayout.setVisibility(8);
                    this.mIdVerifyUserNameEdit.setFocusable(true);
                    this.mIdVerifyUserNameEdit.setEnabled(true);
                    this.mBinTextUser.setEnabled(true);
                    this.mBinTextUser.setFocusable(true);
                    this.mNameEdit.setFocusable(true);
                    this.mNameEdit.setEnabled(true);
                    ArrayList<JSONObject> arrayList = this.mBankList;
                    if (arrayList != null && arrayList.size() > 0) {
                        setCreIdTypeLayoutDisabled();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(this.prefillUserInfo) && this.prefillUserInfo.equals("0")) {
                    this.mNameEdit.setText("");
                    this.mCardIdEdit.setText("");
                    this.mCardOtherId.setText("");
                } else {
                    this.mNameEdit.setText(this.mTrueName);
                    setCreIdTypeText();
                    if (this.mCardType.equals("1")) {
                        this.mCardOtherId.setVisibility(8);
                        this.mCardIdEdit.setVisibility(0);
                        setTextAndUnEnable(this.mCardIdEdit, this.mCardID);
                    } else {
                        this.mCardIdEdit.setVisibility(8);
                        this.mCardOtherId.setVisibility(0);
                        setTextAndUnEnable(this.mCardOtherId, this.mCardID);
                    }
                }
                if (!TextUtils.isEmpty(this.prefillUserInfo) && this.prefillUserInfo.equals("0") && this.mUserAttr == 2) {
                    this.mUserAttr = 1;
                    setCreIdTypeLayoutDisabled();
                }
                if (this.mUserAttr == 2) {
                    this.mBinUserLayout.setVisibility(0);
                    setTextAndUnEnable(this.mBinTextUser, this.mTrueName);
                    setTextAndUnEnable(this.mNameEdit, this.mTrueName);
                    this.mCardTypeLayout.setFocusable(false);
                    this.mCardTypeLayout.setClickable(false);
                    this.mCardTypeLayout.setEnabled(false);
                    return;
                }
                this.mNameEdit.setFocusable(true);
                this.mNameEdit.setEnabled(true);
                if (this.mCardType.equals("1")) {
                    this.mCardIdEdit.setFocusable(true);
                    this.mCardIdEdit.setEnabled(true);
                } else {
                    this.mCardOtherId.setFocusable(true);
                    this.mCardOtherId.setEnabled(true);
                }
                ArrayList<JSONObject> arrayList2 = this.mBankList;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    setCreIdTypeLayoutDisabled();
                    return;
                }
                return;
            }
            fileInputStream = getContext().openFileInput("qb_tenpay_card_bin");
            byte[] bArr = new byte[1024];
            StringBuilder sb5 = new StringBuilder();
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    break;
                } else {
                    sb5.append(new String(bArr, 0, read));
                }
            }
            this.mBinJson = new JSONArray(sb5.toString());
            if (this.mBinJson == null) {
            }
            if (!this.mForgetPassFlag) {
            }
        } finally {
            Utils.closeObject(fileInputStream);
        }
        fileInputStream = null;
    }

    private void initYzmPage(View view) {
        this.mYzmLayout = (LinearLayout) view.findViewById(R.id.f166962jf3);
        this.mYzmSubTitle = (TextView) view.findViewById(R.id.xor);
        ClearableEditText clearableEditText = (ClearableEditText) view.findViewById(R.id.a7r);
        this.mYzmPhoneNum = clearableEditText;
        clearableEditText.setOnClickListener(this.keyOnClickListener);
        this.mYzmPhoneNum.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tenpay.sdk.activity.h
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view2, boolean z16) {
                BindBankActivity.this.lambda$initYzmPage$5(view2, z16);
            }
        });
        this.mYzmPhoneNum.addTextChangedListener(new x05.b() { // from class: com.tenpay.sdk.activity.BindBankActivity.16
            @Override // x05.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (BindBankActivity.this.isMobileNumber(editable.toString())) {
                    BindBankActivity bindBankActivity = BindBankActivity.this;
                    if (bindBankActivity.mTimer == null) {
                        bindBankActivity.mYzmGetSMSBtn.setEnabled(true);
                        return;
                    }
                    return;
                }
                if (BindBankActivity.this.mYzmGetSMSBtn.isEnabled()) {
                    BindBankActivity.this.mYzmGetSMSBtn.setEnabled(false);
                }
            }
        });
        ClearableEditText clearableEditText2 = (ClearableEditText) view.findViewById(R.id.f166959jf0);
        this.mYzmEdit = clearableEditText2;
        clearableEditText2.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tenpay.sdk.activity.i
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view2, boolean z16) {
                BindBankActivity.this.lambda$initYzmPage$6(view2, z16);
            }
        });
        this.mYzmEdit.setOnClickListener(this.keyOnClickListener);
        Button button = (Button) view.findViewById(R.id.f166961jf2);
        this.mYzmGetSMSBtn = button;
        button.setOnClickListener(this);
        Button button2 = (Button) view.findViewById(R.id.jez);
        this.mYzNextBtn = button2;
        button2.setOnClickListener(this);
        this.mYzNextBtn.setEnabled(false);
        this.mYzNextBtn.setClickable(false);
        this.mYzmEdit.addTextChangedListener(new TextWatcher() { // from class: com.tenpay.sdk.activity.BindBankActivity.17
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (BindBankActivity.this.mYzmLayout.getVisibility() == 0) {
                    if (BindBankActivity.this.mYzmEdit.getText().toString().trim().length() > 5) {
                        if (!BindBankActivity.this.mYzNextBtn.isEnabled()) {
                            BindBankActivity.this.addTraceData("enable");
                        }
                        BindBankActivity.this.mYzNextBtn.setClickable(true);
                        BindBankActivity.this.mYzNextBtn.setEnabled(true);
                        return;
                    }
                    if (BindBankActivity.this.mYzNextBtn.isEnabled()) {
                        BindBankActivity.this.addTraceData("disable");
                    }
                    BindBankActivity.this.mYzNextBtn.setClickable(false);
                    BindBankActivity.this.mYzNextBtn.setEnabled(false);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            }
        });
    }

    public static boolean invalidateID(String str) {
        int[] iArr = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        char[] cArr = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
        int i3 = 0;
        int i16 = 0;
        while (i3 < str.length() - 1) {
            try {
                int i17 = i3 + 1;
                i16 += Integer.parseInt(str.substring(i3, i17)) * iArr[i3];
                i3 = i17;
            } catch (Exception unused) {
                return false;
            }
        }
        if (str.charAt(17) != cArr[i16 % 11]) {
            return false;
        }
        return true;
    }

    private boolean isSexChangeable() {
        if (this.mSexLayout.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$checkFormAndConfirm$13(Boolean bool, Integer num) {
        dismissLoading();
        if (!bool.booleanValue()) {
            onCheckFormFail(num.intValue());
            return Unit.INSTANCE;
        }
        personInfoConfirm();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$guideToIdVerify$10(DialogInterface dialogInterface, int i3) {
        boolean z16;
        if (this.mAuthenChanelState != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        IdVerifyModule.startFromBindBank(this, z16, this.realNameSource);
        exitCurrentProcess();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initIdVerifyGuideTips$2(View view) {
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.mAuthenChanelState != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        IdVerifyModule.startFromBindBank(this, z16, this.realNameSource);
        exitCurrentProcess();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initIdVerifyPage$0() {
        this.mIdVerifyConfirm.setEnabled(validateIdVerify());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initIdVerifyPage$1(View view, boolean z16) {
        UIUtils.handleFocusChange(this.mKeyBoard, view, z16, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initPersonalInfoPage$3() {
        this.mPersonInfoConfirm.setEnabled(validatePersonalInfo());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initPersonalInfoPage$4(View view, boolean z16) {
        UIUtils.handleFocusChange(this.mKeyBoard, view, z16, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initVerifyPasswordPage$7() {
        this.verifyPasswordBtn.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initVerifyPasswordPage$8() {
        if (this.mSixPasswdEdit.getInputText().length() > 5) {
            this.verifyPasswordBtn.setEnabled(true);
        } else {
            this.verifyPasswordBtn.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initVerifyPasswordPage$9(View view, boolean z16) {
        if (this.mSixPasswdEdit.isFocused()) {
            this.mKeyBoard.setVisibility(0);
            this.mKeyBoard.setInputEditText(this.mSixPasswdEdit);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initYzmPage$5(View view, boolean z16) {
        UIUtils.handleFocusChange(this.mKeyBoard, view, z16, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initYzmPage$6(View view, boolean z16) {
        UIUtils.handleFocusChange(this.mKeyBoard, view, z16, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$12(int i3, Intent intent) {
        if (i3 == -1 && intent != null) {
            String stringExtra = intent.getStringExtra(LocationInputFragment.KEY_ADDRESS_PROVINCE);
            String stringExtra2 = intent.getStringExtra(LocationInputFragment.KEY_ADDRESS_CITY);
            String stringExtra3 = intent.getStringExtra(LocationInputFragment.KEY_ADDRESS_DISTRICT);
            String stringExtra4 = intent.getStringExtra(LocationInputFragment.KEY_DETAIL_ADDRESS);
            if (stringExtra == null) {
                stringExtra = "";
            }
            this.mProvince = stringExtra;
            if (stringExtra2 == null) {
                stringExtra2 = "";
            }
            this.mCity = stringExtra2;
            if (stringExtra3 == null) {
                stringExtra3 = "";
            }
            this.mDistrict = stringExtra3;
            if (stringExtra4 == null) {
                stringExtra4 = "";
            }
            this.mDetailAddress = stringExtra4;
            this.mAddressTxt.setText(this.mProvince + " " + this.mCity + " " + this.mDistrict + " " + this.mDetailAddress);
            this.mPersonInfoConfirm.setEnabled(validatePersonalInfo());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onSuccess$14(JSONArray jSONArray, JSONArray jSONArray2, JSONObject jSONObject) {
        if (jSONArray != null || jSONArray2 != null) {
            TenUtils.saveJsonToSP("user_info_extend" + this.mUin, this.mUin, "user_info_extend", jSONObject.toString(), Cgi.userInfoExtendEnc);
        }
    }

    private boolean needShowIdVerify(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        JSONObject serverConfig = TenUtils.getServerConfig(DataProxy.getTenpayInternalPath() + str + "/hbThemeConfig.cfg");
        if (serverConfig == null) {
            return false;
        }
        try {
            JSONObject optJSONObject = serverConfig.optJSONObject(QWalletFakeUrl.FAKEURL_BINDCARDVERIFY);
            if (optJSONObject == null) {
                return false;
            }
            String optString = optJSONObject.optString("allowIDCardVerify");
            String optString2 = optJSONObject.optString(QCircleLpReportDc05502.KEY_BEGIN_TIME);
            String optString3 = optJSONObject.optString("end_time");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString2)) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                long time = simpleDateFormat.parse(optString2).getTime();
                long time2 = simpleDateFormat.parse(optString3).getTime();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis >= time && currentTimeMillis <= time2) {
                    if ("1".equals(optString)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e16) {
            QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCardTypeChange(String str) {
        QwLog.i("onCardTypeChange,before:" + this.mCardType + ",after:" + str);
        this.mCardType = str;
        this.mSexTxt.setText("");
        this.mCurSexType = 0;
        if ("1".equals(this.mCardType)) {
            this.mSexLayout.setVisibility(8);
        } else {
            this.mSexLayout.setVisibility(0);
        }
    }

    private void onCheckFormFail(int i3) {
        if (i3 == 130213) {
            this.mSexLayout.setVisibility(0);
        }
    }

    private void onFaceVerifyFinish(int i3, Intent intent) {
        if (i3 != -1) {
            QwLog.e("onFaceVerifyFinish fail, resultCode=" + i3);
            return;
        }
        if (intent == null) {
            QwLog.e("onFaceVerifyFinish fail, data is null");
            return;
        }
        int intExtra = intent.getIntExtra(QWalletFaceProxyFragment.KEY_OUT_PARAM_RET_CODE, FaceVerifyErr.ERROR_CANCEL.getRetCode());
        String stringExtra = intent.getStringExtra(QWalletFaceProxyFragment.KEY_OUT_PARAM_RET_MSG);
        if (intExtra == FaceVerifyErr.OK.getRetCode()) {
            QwLog.i("onFaceVerifyFinish success");
            gotoActivateTenpayAccount();
            return;
        }
        QwLog.e("onFaceVerifyFinish fail: retCode=" + intExtra + ", retMsg=" + stringExtra);
    }

    private void onSexSelectClick() {
        boolean z16;
        if (!isSexChangeable()) {
            return;
        }
        QwLog.d("onSexSelectClick...mCardType:" + this.mCardType + ",mCurSex:" + this.mCurSexType);
        this.sexMaps.clear();
        for (Sex sex : sSexList) {
            LinkedHashMap<String, Boolean> linkedHashMap = this.sexMaps;
            String str = sex.des;
            if (sex.type == this.mCurSexType) {
                z16 = true;
            } else {
                z16 = false;
            }
            linkedHashMap.put(str, Boolean.valueOf(z16));
        }
        Dialog createActionSheetWithCheck = ASProxy.createActionSheetWithCheck(getContext(), getString(R.string.e5h), getResources().getString(R.string.f1794439d), this.sexMaps, new ActionSheet.OnButtonClickListener() { // from class: com.tenpay.sdk.activity.BindBankActivity.31
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public void onClick(View view, int i3) {
                BindBankActivity.this.mSexTypeDialog.dismiss();
                if (i3 >= BindBankActivity.sSexList.size()) {
                    QQToast.makeText(BindBankActivity.this.getContext(), BindBankActivity.this.getResources().getString(R.string.f1794239b), 0).show();
                    return;
                }
                Sex sex2 = (Sex) BindBankActivity.sSexList.get(i3);
                BindBankActivity.this.mCurSexType = sex2.type;
                BindBankActivity.this.mSexTxt.setText(sex2.des);
                QwLog.d("onSexSelectClick...OnClick\uff0cmCurSex\uff1a" + BindBankActivity.this.mCurSexType);
            }
        }, null);
        this.mSexTypeDialog = createActionSheetWithCheck;
        createActionSheetWithCheck.show();
    }

    private void personInfoConfirm() {
        int i3 = this.mUserAttr;
        if (i3 != 0 && i3 != 1 && i3 != 3) {
            if (RealNameAgePopHelper.isNeedPop(this.mBindGuide)) {
                handleFirstBindUserNextStep();
                return;
            } else {
                showView(3);
                return;
            }
        }
        handleUnnamedUserNextStep();
    }

    private void personInfoEnc(Map<String, String> map) {
        ClearableEditText clearableEditText;
        ClearableEditText clearableEditText2;
        HashMap hashMap = new HashMap();
        if (!this.mForgetPassFlag) {
            if (this.mCardType.equals("1")) {
                clearableEditText2 = this.mCardIdEdit;
            } else {
                clearableEditText2 = this.mCardOtherId;
            }
            hashMap.put("creditcard_id", clearableEditText2.getText().toString());
        } else {
            if (this.mCardType.equals("1")) {
                clearableEditText = this.mIdVerifyCardIdEdit;
            } else {
                clearableEditText = this.mIdVerifyOtherCardIdEdit;
            }
            hashMap.put("creditcard_id", clearableEditText.getText().toString());
        }
        hashMap.put("bank_card_id", this.mBinNo.getData());
        AESUtils.encryptInfoIfRsa2048(getContext(), map, hashMap);
    }

    private void registerGetYzmDeposit(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("flag", str);
        hashMap.put("uin", this.mUin);
        hashMap.put("amount", this.mDepositCount);
        hashMap.put("bank_type", this.mBinBank.optString("code"));
        hashMap.put("true_name", this.mNameEdit.getText().toString());
        if (!TextUtils.isEmpty(this.mPhoneNum)) {
            hashMap.put(DeviceType.DeviceCategory.MOBILE, this.mPhoneNum);
        }
        hashMap.put("cre_type", "1");
        hashMap.put("cre_type", this.mCardType);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("bank_card_id", this.mBinNo.getData());
        int i3 = this.mUserAttr;
        if (i3 != 0 && i3 != 3) {
            if (this.mCardType.equals("1")) {
                ClearableEditText clearableEditText = this.mCardIdEdit;
                if (clearableEditText != null && !this.mCardID.equals(clearableEditText.getText().toString())) {
                    hashMap2.put("creditcard_id", this.mCardIdEdit.getText().toString());
                } else {
                    hashMap2.put("creditcard_id", this.mCardID);
                }
            } else {
                ClearableEditText clearableEditText2 = this.mCardOtherId;
                if (clearableEditText2 != null && !this.mCardID.equals(clearableEditText2.getText().toString())) {
                    hashMap2.put("creditcard_id", this.mCardOtherId.getText().toString());
                } else {
                    hashMap2.put("creditcard_id", this.mCardID);
                }
            }
        } else if (this.mCardType.equals("1")) {
            hashMap2.put("creditcard_id", this.mCardIdEdit.getText().toString());
        } else {
            hashMap2.put("creditcard_id", this.mCardOtherId.getText().toString());
        }
        AESUtils.encryptInfoIfRsa2048(getContext(), hashMap, hashMap2);
        hashMap.put("timestamp", this.mTimestamp + "");
        if (this.sendSmsNum > 1) {
            this.sendSmsNum = 0;
            hashMap.put("is_reentry", "1");
        } else {
            hashMap.put("is_reentry", "0");
        }
        hashMap.put("user_info_extend", getUserInfoExtend().toString());
        httpRequest(Cgi.URI_QWallet_REQUEST_DEPOSIT, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selectIdCardType() {
        this.buttonMaps.clear();
        for (int i3 = 0; i3 < this.mCardTypeList.size(); i3++) {
            JSONObject jSONObject = this.mCardTypeList.get(i3);
            if (jSONObject != null) {
                if (jSONObject.optString("cre_type").equals(this.mCardType)) {
                    this.buttonMaps.put(this.mCardTypeList.get(i3).optString("cre_desc"), Boolean.TRUE);
                } else {
                    this.buttonMaps.put(this.mCardTypeList.get(i3).optString("cre_desc"), Boolean.FALSE);
                }
            }
        }
        Dialog createActionSheetWithCheck = ASProxy.createActionSheetWithCheck(getContext(), getString(R.string.e5h), "\u9009\u62e9\u8bc1\u4ef6\u7c7b\u578b", this.buttonMaps, new ActionSheet.OnButtonClickListener() { // from class: com.tenpay.sdk.activity.BindBankActivity.18
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public void onClick(View view, int i16) {
                BindBankActivity.this.mCardTypeDialog.dismiss();
                if (i16 >= BindBankActivity.this.mCardTypeList.size()) {
                    QQToast.makeText(BindBankActivity.this.getContext(), "\u4f60\u7684\u9009\u62e9\u4e0d\u652f\u6301\uff0c\u8bf7\u91cd\u65b0\u9009\u62e9", 0).show();
                    return;
                }
                JSONObject jSONObject2 = (JSONObject) BindBankActivity.this.mCardTypeList.get(i16);
                BindBankActivity.this.mCardTypeTxt.setText(jSONObject2.optString("cre_desc"));
                String optString = jSONObject2.optString("cre_type");
                if (!optString.equals(BindBankActivity.this.mCardType)) {
                    BindBankActivity.this.onCardTypeChange(optString);
                    BindBankActivity.this.mCardIdEdit.setText("");
                    BindBankActivity.this.mCardOtherId.setText("");
                    if (BindBankActivity.this.mCardType.equals("1")) {
                        BindBankActivity.this.mIdVerifyCardIdEdit.setVisibility(0);
                        BindBankActivity.this.mIdVerifyOtherCardIdEdit.setVisibility(8);
                        BindBankActivity.this.mCardOtherId.setVisibility(8);
                        BindBankActivity.this.mCardIdEdit.setVisibility(0);
                        BindBankActivity.this.mCardIdEdit.requestFocus();
                        return;
                    }
                    BindBankActivity.this.mIdVerifyCardIdEdit.setVisibility(8);
                    BindBankActivity.this.mIdVerifyOtherCardIdEdit.setVisibility(0);
                    BindBankActivity.this.mCardIdEdit.setVisibility(8);
                    BindBankActivity.this.mCardOtherId.setVisibility(0);
                    BindBankActivity.this.mCardOtherId.requestFocus();
                    BindBankActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.tenpay.sdk.activity.BindBankActivity.18.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BindBankActivity bindBankActivity = BindBankActivity.this;
                            bindBankActivity.emulateTouchEvent(bindBankActivity.mCardOtherId);
                            BindBankActivity.this.mKeyBoard.setVisibility(8);
                        }
                    }, 200L);
                }
            }
        }, null);
        this.mCardTypeDialog = createActionSheetWithCheck;
        createActionSheetWithCheck.show();
    }

    private void sendQueryBankSupportList() {
        httpRequestNoEncript(Cgi.URI_QUERY_BANK_CACHE_CONF, new HashMap());
    }

    private void sendQueryBinRequest() {
        httpRequestNoEncript(Cgi.QUERY_CARD_BIN_CONF_URI, new HashMap());
    }

    private void sendWalBankQueryRequest() {
        String str;
        int i3;
        HashMap hashMap = new HashMap();
        QwLog.i("mUserType = " + this.mUserAttr);
        if (!TextUtils.isEmpty(this.mPromotionFlag) && this.mPromotionFlag.equals("1")) {
            hashMap.put("promotion_id", this.mPromotionId);
        }
        hashMap.put("bargainor_id", this.mBargainorId);
        int i16 = 3;
        if (this.mFrom == 1 && (i3 = this.mUserAttr) != 0 && i3 != 3) {
            hashMap.put("user_info", "1");
        } else {
            hashMap.put("user_info", "0");
        }
        Intent intent = getIntent();
        if (intent == null) {
            str = "";
        } else {
            str = intent.getStringExtra("query_type");
        }
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("query_type", str);
        } else {
            hashMap.put("query_type", "PAY");
        }
        if (this.mIsFromWithdraw && !this.mForgetPassFlag) {
            hashMap.put("query_type", "QUICKPAY_DRAW");
        }
        if (this.mIsFromDeposit && !this.mForgetPassFlag) {
            hashMap.put("query_type", "CHARGE");
        }
        if (intent != null) {
            i16 = intent.getIntExtra(BankConstants.EXTRA_KEY_BIND_SCENE_TYPE, 3);
        }
        hashMap.put("scene", "" + i16);
        hashMap.put("unbind_flag", "1");
        httpRequestNoEncript(Cgi.URI_YDTBANK_QUERY, hashMap);
    }

    private void sendWallGateRequest() {
        HashMap hashMap = new HashMap();
        hashMap.put("uin", this.mUin);
        httpRequest(Cgi.URL_WALLET_GATE, hashMap);
    }

    private void setCodePayRefresh() {
        com.tencent.mobileqq.qwallet.utils.g.l("qwallet_bindcard_refresh", true);
    }

    private void setCreIdTypeLayoutDisabled() {
        this.mCardTypeLayout.setEnabled(false);
        this.mCardTypeLayout.setClickable(false);
        this.mCardTypeTxt.setTextColor(getResources().getColor(R.color.f157691ww));
        this.mIdVerifyCardTypeLayout.setEnabled(false);
        this.mIdVerifyCardTypeLayout.setClickable(false);
        this.mIdVerifyCardTypeTxt.setTextColor(getResources().getColor(R.color.f157691ww));
    }

    private void setCreIdTypeText() {
        this.mCardTypeTxt.setText("\u5c45\u6c11\u8eab\u4efd\u8bc1");
        this.mIdVerifyCardTypeTxt.setText("\u5c45\u6c11\u8eab\u4efd\u8bc1");
        for (int i3 = 0; i3 < this.mCardTypeList.size(); i3++) {
            JSONObject jSONObject = this.mCardTypeList.get(i3);
            if (this.mCardType.equals(jSONObject.optString("cre_type"))) {
                this.mCardTypeTxt.setText(jSONObject.optString("cre_desc"));
                this.mIdVerifyCardTypeTxt.setText(jSONObject.optString("cre_desc"));
                return;
            }
        }
    }

    private void setTextAndUnEnable(@NonNull TextView textView, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        textView.setText(str);
        textView.setEnabled(false);
        textView.setFocusable(false);
        textView.setClickable(false);
        textView.setTextColor(getResources().getColor(R.color.f157691ww));
    }

    private void showBindBankNumIndex() {
        this.mRootView.setAlpha(1.0f);
        initView();
        showView(1);
    }

    private void showPasswordEdit() {
        if (this.mPassFlag == 2) {
            QLog.i(((NetBaseActivity) this).TAG, 1, "six pwd user...");
            this.mLongPwdEdit.setVisibility(8);
            this.mSixPasswdEdit.setVisibility(0);
            this.mSixPasswdEdit.requestFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.mSixPasswdEdit.getWindowToken(), 0);
            }
            this.mKeyBoard.setVisibility(0);
            this.mKeyBoard.setInputEditText(this.mSixPasswdEdit);
            this.mKeyBoard.setXMode(0);
            return;
        }
        QLog.i(((NetBaseActivity) this).TAG, 1, "not six pwd user...");
        this.mSixPasswdEdit.setVisibility(8);
        this.mKeyBoard.setVisibility(8);
        this.mLongPwdEdit.setVisibility(0);
        this.mLongPwdEdit.requestFocus();
        Utils.touchEditText(this.mHandler, this.mLongPwdEdit);
    }

    private void showPhoneTipsDialog() {
        addTraceData("phone");
        if (this.mBinBank != null) {
            QUIProxy.createCustomDialog(getContext(), 230, null, String.format(getString(R.string.f171355ec0), this.mBinBank.optString("tel_number")), getString(R.string.e3_), null, null, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.BindBankActivity.37
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                }
            });
        }
    }

    private void showPrivacyDialog() {
        BindCardTipConfig.Alert alert = ((BindCardTipConfig) ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).getConfig(IQWalletUnitedConfigApi.QWALLET_BIND_BANK_TIP_CONFIG, new BindCardTipConfig())).getAlert();
        QQCustomDialog createCustomDialogUrlWithoutAutoLink = DialogUtil.createCustomDialogUrlWithoutAutoLink(getQBaseActivity(), 230, R.layout.fy6, alert.i(), x05.c.d(alert.h(), new c.InterfaceC11524c() { // from class: com.tenpay.sdk.activity.BindBankActivity.38
            @Override // x05.c.InterfaceC11524c
            public void onClickUrl(String str) {
                BindBankActivity.this.gotoH5(str);
            }
        }), alert.f(), alert.g(), new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.BindBankActivity.39
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                BindBankActivity.this.handleNamedUserNextStep();
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.BindBankActivity.40
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                dialogInterface.dismiss();
            }
        });
        createCustomDialogUrlWithoutAutoLink.getBtnight().setTextColor(-1);
        createCustomDialogUrlWithoutAutoLink.setCancelable(false);
        createCustomDialogUrlWithoutAutoLink.setCanceledOnTouchOutside(false);
        Window window = createCustomDialogUrlWithoutAutoLink.getWindow();
        window.setGravity(80);
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        window.setAttributes(attributes);
        createCustomDialogUrlWithoutAutoLink.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean useNewBindBankProgram() {
        if (ChildrenRealNameConfig.INSTANCE.get().getApplyNewStrategy() == 1) {
            return true;
        }
        return false;
    }

    private boolean validateCardIdEdit(ClearableEditText clearableEditText) {
        if (clearableEditText.getVisibility() == 0 && clearableEditText.isEnabled()) {
            String obj = clearableEditText.getText().toString();
            String str = this.mCardID;
            if (str == null || !str.equals(obj) || "".equals(obj)) {
                if (obj.length() < 18 && obj.length() != 15) {
                    QQToast.makeText(getContext(), R.string.f171346e91, 0).show();
                    clearableEditText.onError();
                    clearableEditText.requestFocus();
                    return false;
                }
                if (obj.length() == 18 && obj.indexOf(42) < 0 && !invalidateID(obj.toUpperCase())) {
                    QQToast.makeText(getContext(), R.string.f171346e91, 0).show();
                    clearableEditText.onError();
                    clearableEditText.requestFocus();
                    return false;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    private boolean validateCardOtherId(final ClearableEditText clearableEditText) {
        if (clearableEditText.getVisibility() != 0 || !clearableEditText.isEnabled() || clearableEditText.getText().toString().length() >= 1) {
            return true;
        }
        QQToast.makeText(getContext(), R.string.ea9, 0).show();
        clearableEditText.requestFocus();
        this.mHandler.postDelayed(new Runnable() { // from class: com.tenpay.sdk.activity.BindBankActivity.24
            @Override // java.lang.Runnable
            public void run() {
                BindBankActivity.this.emulateTouchEvent(clearableEditText);
            }
        }, 100L);
        return false;
    }

    private boolean validateIdNumber() {
        if (!validateCardIdEdit(this.mCardIdEdit) || !validateCardOtherId(this.mCardOtherId)) {
            return false;
        }
        if (!this.mForgetPassFlag && TextUtils.isEmpty(this.mSexTxt.getText())) {
            Context context = getContext();
            if (context != null) {
                QQToast.makeText(context, R.string.f17930390, 0).show();
            }
            this.mSexLayout.setVisibility(0);
            this.mSexTxt.requestFocus();
            return false;
        }
        return true;
    }

    private boolean validateVerifyIdNumber() {
        if (validateCardIdEdit(this.mIdVerifyCardIdEdit) && validateCardOtherId(this.mIdVerifyOtherCardIdEdit)) {
            return true;
        }
        return false;
    }

    protected void addTraceData(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.traceName);
        stringBuffer.append(str);
        if (this.mIsMidas) {
            TenpayUtil.addMidasUploadData(getProcessType(), stringBuffer.toString());
        } else {
            com.tencent.mobileqq.qwallet.c.c(stringBuffer.toString(), Integer.valueOf(getProcessType()));
        }
    }

    protected void back() {
        String string;
        int i3 = this.mPageIndex;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            showView(3);
                            return;
                        }
                        return;
                    } else if (this.isShowPersonInfo) {
                        showView(2);
                        return;
                    } else {
                        showView(1);
                        return;
                    }
                }
                showView(1);
                return;
            }
            if (this.mForgetPassFlag) {
                showView(0);
                return;
            }
            if (!TextUtils.isEmpty(this.mBinNo.getText().toString())) {
                if (this.mIsShiMing) {
                    string = getString(R.string.edv);
                } else if (this.mForgetPassFlag) {
                    string = getString(R.string.e5z);
                } else if (!this.mIsFromWithdraw && !this.mIsFromDeposit) {
                    string = getString(R.string.e1i);
                } else {
                    string = getString(R.string.f171323e34);
                }
                Dialog createCustomDialog = QUIProxy.createCustomDialog(getContext(), 230, null, string, getString(R.string.eds), getString(R.string.edt), new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.BindBankActivity.21
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i16) {
                        BindBankActivity.this.addTraceData("cancel");
                        BindBankActivity.this.dialog.dismiss();
                    }
                }, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.BindBankActivity.22
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i16) {
                        BindBankActivity.this.addTraceData(ResourceAttributes.TelemetrySdkLanguageValues.GO);
                        BindBankActivity.this.giveUpBindbank();
                    }
                });
                this.dialog = createCustomDialog;
                if (createCustomDialog != null) {
                    createCustomDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tenpay.sdk.activity.BindBankActivity.23
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            BindBankActivity bindBankActivity = BindBankActivity.this;
                            bindBankActivity.traceName = bindBankActivity.mTraceNameTemp;
                        }
                    });
                    this.mTraceNameTemp = this.traceName;
                    this.traceName = "abandon.addcard.";
                    addTraceData("show");
                    return;
                }
                return;
            }
            giveUpBindbank();
            return;
        }
        finish();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x009f A[Catch: Exception -> 0x00f4, TryCatch #0 {Exception -> 0x00f4, blocks: (B:3:0x0014, B:6:0x002c, B:9:0x003c, B:10:0x0065, B:12:0x009f, B:13:0x00a9, B:16:0x00b0, B:17:0x00de, B:21:0x00e6, B:25:0x00ee, B:26:0x00d9, B:27:0x0060), top: B:2:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00b0 A[Catch: Exception -> 0x00f4, TRY_ENTER, TryCatch #0 {Exception -> 0x00f4, blocks: (B:3:0x0014, B:6:0x002c, B:9:0x003c, B:10:0x0065, B:12:0x009f, B:13:0x00a9, B:16:0x00b0, B:17:0x00de, B:21:0x00e6, B:25:0x00ee, B:26:0x00d9, B:27:0x0060), top: B:2:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ee A[Catch: Exception -> 0x00f4, TRY_LEAVE, TryCatch #0 {Exception -> 0x00f4, blocks: (B:3:0x0014, B:6:0x002c, B:9:0x003c, B:10:0x0065, B:12:0x009f, B:13:0x00a9, B:16:0x00b0, B:17:0x00de, B:21:0x00e6, B:25:0x00ee, B:26:0x00d9, B:27:0x0060), top: B:2:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d9 A[Catch: Exception -> 0x00f4, TryCatch #0 {Exception -> 0x00f4, blocks: (B:3:0x0014, B:6:0x002c, B:9:0x003c, B:10:0x0065, B:12:0x009f, B:13:0x00a9, B:16:0x00b0, B:17:0x00de, B:21:0x00e6, B:25:0x00ee, B:26:0x00d9, B:27:0x0060), top: B:2:0x0014 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void bindCardGetYzm() {
        QwLog.i("\u8001\u7528\u6237\u7ed1\u5361-\u8bf7\u6c42\u9a8c\u8bc1\u7801");
        this.mGetYzmData = new HashMap();
        try {
        } catch (Exception e16) {
            QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
        }
        if (!NetParams.DEBIT_UNBIND.equals(this.mBinBank.optString("type")) && !NetParams.DEBIT_FAST.equals(this.mBinBank.optString("type"))) {
            this.mGetYzmData.put("is_credit_card", "1");
            this.mGetYzmData.put("valid_thru", getValidTime());
            this.mGetYzmData.put("cvc", this.mBinInputBankCvv.getText().toString());
            this.mGetYzmData.put("bank_type", this.mBinBank.optString("code"));
            this.mGetYzmData.put("true_name", this.mNameEdit.getText().toString());
            this.mGetYzmData.put("creditcard_type", this.mCardType);
            personInfoEnc(this.mGetYzmData);
            if (!TextUtils.isEmpty(this.mPhoneNum)) {
                this.mGetYzmData.put(DeviceType.DeviceCategory.MOBILE, this.mPhoneNum);
            }
            if (!this.mForgetPassFlag) {
                this.mGetYzmData.put("reset_pwd_flag", "1");
                this.mGetYzmData.put("qq_guid", com.tencent.mobileqq.base.b.d());
                this.mGetYzmData.put("qq_appid", com.tencent.mobileqq.base.b.b());
                this.mGetYzmData.put("qq_appname", "com.tencent.mobileqq");
            } else {
                this.mGetYzmData.put("reset_pwd_flag", "0");
            }
            if (this.sendSmsNum <= 1) {
                this.sendSmsNum = 0;
                this.mGetYzmData.put("is_reentry", "1");
            } else {
                this.mGetYzmData.put("is_reentry", "0");
            }
            this.mGetYzmData.put("come_from", this.mComeFrom + "");
            this.mGetYzmData.put(com.tencent.mobileqq.msf.core.c0.j.T0, this.mAppInfo);
            this.mGetYzmData.put("user_info_extend", getUserInfoExtend().toString());
            httpRequest(Cgi.URI_CFT_USER_AUTHEN, this.mGetYzmData);
        }
        this.mGetYzmData.put("is_credit_card", "0");
        this.mGetYzmData.put("bank_type", this.mBinBank.optString("code"));
        this.mGetYzmData.put("true_name", this.mNameEdit.getText().toString());
        this.mGetYzmData.put("creditcard_type", this.mCardType);
        personInfoEnc(this.mGetYzmData);
        if (!TextUtils.isEmpty(this.mPhoneNum)) {
        }
        if (!this.mForgetPassFlag) {
        }
        if (this.sendSmsNum <= 1) {
        }
        this.mGetYzmData.put("come_from", this.mComeFrom + "");
        this.mGetYzmData.put(com.tencent.mobileqq.msf.core.c0.j.T0, this.mAppInfo);
        this.mGetYzmData.put("user_info_extend", getUserInfoExtend().toString());
        httpRequest(Cgi.URI_CFT_USER_AUTHEN, this.mGetYzmData);
    }

    protected void closeTime() {
        CountDownTimer countDownTimer = this.mTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.mTimer = null;
        }
        this.mYzmGetSMSBtn.setText(getString(R.string.f17937397));
        this.mYzmGetSMSBtn.setEnabled(isMobileNumber(this.mPhoneNum));
        this.mYzmGetSMSBtn.setClickable(true);
    }

    protected void confirmYzm() {
        HashMap hashMap = new HashMap();
        hashMap.put("is_ydt", "0");
        hashMap.put("bank_type", this.mBinBank.optString("code"));
        hashMap.put("verify_code", this.mYzmEdit.getText().toString());
        hashMap.put("purchaser_id", this.mUin);
        if (!TextUtils.isEmpty(this.mPhoneNum)) {
            hashMap.put(DeviceType.DeviceCategory.MOBILE, this.mPhoneNum);
        }
        JSONObject jSONObject = this.mBindCardPreObj;
        if (jSONObject != null) {
            hashMap.put("token", jSONObject.optString("token"));
            hashMap.put(CommonCode.MapKey.TRANSACTION_ID, this.mBindCardPreObj.optString(CommonCode.MapKey.TRANSACTION_ID));
            hashMap.put("business_type", this.mBindCardPreObj.optString("business_type"));
            hashMap.put("auth_params", this.mBindCardPreObj.optString("auth_params"));
        } else {
            HashMap<String, String> hashMap2 = this.mRegisterPreObj;
            if (hashMap2 != null) {
                hashMap.put("token", hashMap2.get("token"));
                hashMap.put(CommonCode.MapKey.TRANSACTION_ID, this.mRegisterPreObj.get(CommonCode.MapKey.TRANSACTION_ID));
                hashMap.put("business_type", this.mRegisterPreObj.get("business_type"));
                hashMap.put("purchaser_id", this.mRegisterPreObj.get("purchaser_id"));
                hashMap.put("auth_params", this.mRegisterPreObj.get("auth_params"));
            }
        }
        hashMap.put("timestamp", this.mTimestamp + "");
        String str = this.mPasswd;
        if (str != null) {
            hashMap.put("p", str);
        }
        if (this.mForgetPassFlag) {
            hashMap.put("reset_pwd_flag", "1");
        } else {
            hashMap.put("reset_pwd_flag", "0");
        }
        hashMap.put("qpay_cert_cn", CertUtil.getCid(getContext(), this.mUin));
        hashMap.put("come_from", this.mComeFrom + "");
        hashMap.put(com.tencent.mobileqq.msf.core.c0.j.T0, this.mAppInfo);
        BindCardTipConfig.b(hashMap);
        httpRequest(Cgi.URI_CFT_USER_BIND, hashMap);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            MyKeyboardWindow myKeyboardWindow = this.mKeyBoard;
            if (myKeyboardWindow != null && myKeyboardWindow.getVisibility() == 0) {
                this.mKeyBoard.setVisibility(8);
                return true;
            }
            addTraceData("keyback");
            back();
            return true;
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tencent.mobileqq.base.QWalletBaseFragment
    public void finish() {
        super.finish();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.overridePendingTransition(0, R.anim.f154878es);
        }
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment
    @NonNull
    public FragmentAnimation getFragmentAnimation() {
        return FragmentAnimation.PULL_UP;
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity
    public int getProcessType() {
        if (this.mIsMidas) {
            return getMidasProcessType();
        }
        if (this.mIsFromWithdraw) {
            if (this.mUserAttr == 3) {
                return 127;
            }
            if (this.mForgetPassFlag) {
                JSONObject jSONObject = this.mBinBank;
                if (jSONObject != null) {
                    String optString = jSONObject.optString("type");
                    if (NetParams.DEBIT_FAST.equals(optString) || NetParams.CREDIT_FAST.equals(optString)) {
                        return 126;
                    }
                    return 125;
                }
                return 125;
            }
            if (this.mIsNeedVerifyPasswd) {
                return 114;
            }
            return 113;
        }
        if (this.mIsFromDeposit) {
            if (this.mIsFromFingerDeposit) {
                return this.mFingerDepositProcessType;
            }
            if (this.mForgetPassFlag) {
                JSONObject jSONObject2 = this.mBinBank;
                if (jSONObject2 != null) {
                    String optString2 = jSONObject2.optString("type");
                    if (NetParams.DEBIT_FAST.equals(optString2) || NetParams.CREDIT_FAST.equals(optString2)) {
                        return 124;
                    }
                    return 123;
                }
                return 123;
            }
            int i3 = this.mUserAttr;
            if (i3 != 0 && i3 != 3) {
                if (this.mIsNeedVerifyPasswd) {
                    return 122;
                }
                return 121;
            }
            return 120;
        }
        if (this.mIsFromCheckPsw) {
            JSONObject jSONObject3 = this.mBinBank;
            if (jSONObject3 != null) {
                String optString3 = jSONObject3.optString("type");
                if (NetParams.DEBIT_FAST.equals(optString3) || NetParams.CREDIT_FAST.equals(optString3)) {
                    return 117;
                }
                return 116;
            }
            return 116;
        }
        if (this.mIsFromFingerPaySetting) {
            if (this.mUserAttr == 0) {
                return 134;
            }
            return 133;
        }
        if (this.mIsFromFingerPay) {
            return this.mFingerPayProcessType;
        }
        int i16 = this.mUserAttr;
        if (i16 == 3) {
            if (this.mIsShiMing) {
                if (!this.mFromHBShiMing) {
                    return 19;
                }
                return 130;
            }
            return 20;
        }
        if (this.mIsFromPayShiMing) {
            return 19;
        }
        if (this.mFrom == 0) {
            if (i16 == 0) {
                return 4;
            }
            if (this.mForgetPassFlag) {
                JSONObject jSONObject4 = this.mBinBank;
                if (jSONObject4 != null) {
                    String optString4 = jSONObject4.optString("type");
                    if (NetParams.DEBIT_FAST.equals(optString4) || NetParams.CREDIT_FAST.equals(optString4)) {
                        return 14;
                    }
                    return 13;
                }
                return 13;
            }
            if (this.mIsNeedVerifyPasswd) {
                return 6;
            }
            return 5;
        }
        if (i16 == 0) {
            return 102;
        }
        if (this.mForgetPassFlag) {
            return 14;
        }
        if (this.mIsNeedVerifyPasswd) {
            return 101;
        }
        return 100;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity
    protected List<String> getSpecialErrorCode() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ErrorCode.ERR_PAY_IVR);
        arrayList.add(ErrorCode.ERR_REGISTER_TIME_OUT);
        arrayList.add(ErrorCode.ERR_PAY_NOT_ENOUGH);
        arrayList.add(ErrorCode.ERR_PASSWORD_BALANCE_PAY);
        return arrayList;
    }

    protected String getValidTime() {
        return this.mBinInputCreditThru.getData();
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    protected void gotoActivateTenpayAccount() {
        if (this.mBinBank == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        if (!NetParams.DEBIT_UNBIND.equals(this.mBinBank.optString("type")) && !NetParams.DEBIT_FAST.equals(this.mBinBank.optString("type"))) {
            hashMap.put("is_credit_card", "1");
            hashMap.put("valid_thru", getValidTime());
            hashMap.put("cvc", this.mBinInputBankCvv.getText().toString());
        } else {
            hashMap.put("is_credit_card", "0");
        }
        hashMap.put("bank_type", this.mBinBank.optString("code"));
        hashMap.put("true_name", this.mNameEdit.getText().toString());
        hashMap.put("creditcard_type", this.mCardType);
        personInfoEnc(hashMap);
        if (!TextUtils.isEmpty(this.mPhoneNum)) {
            hashMap.put(DeviceType.DeviceCategory.MOBILE, this.mPhoneNum);
        }
        hashMap.put("auth_params", this.mRegisterPreObj.get("auth_params"));
        hashMap.put("wap_token", this.mRegisterPreObj.get("wap_token"));
        hashMap.put("purchaser_id", this.mUin);
        hashMap.put("verify_code", this.mYzmEdit.getText().toString());
        hashMap.put("qpay_cert_cn", CertUtil.getCid(getContext(), this.mUin));
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable(ActivateTenpayAccount.PARAM_ACTIVATE_MAP, hashMap);
        Serializable serializable = this.mRegisterRequestYzmParamsObj;
        if (serializable != null) {
            bundle.putSerializable("getyzm", serializable);
        }
        Serializable serializable2 = this.mRegisterExcuteYzmObj;
        if (serializable2 != null) {
            bundle.putSerializable("excute_yzm", serializable2);
        }
        bundle.putString("need_yz", this.mRegisterPreObj.get("check_vcode_flag"));
        intent.putExtra(ActivateTenpayAccount.PARAM_ACTIVATE_ACCOUNT_BUNDLE, bundle);
        intent.putExtra("from", this.mFrom);
        intent.putExtra("IsShiMing", this.mIsShiMing);
        intent.putExtra(WithdrawActivity.FROM_WITHDRAW, this.mIsFromWithdraw);
        intent.putExtra("trustpay_open_flag", this.mTrustPayOpen);
        String stringExtra = getIntent().getStringExtra("point_list");
        if (!TextUtils.isEmpty(stringExtra)) {
            intent.putExtra("point_list", stringExtra);
        }
        String stringExtra2 = getIntent().getStringExtra("promotion_list");
        if (!TextUtils.isEmpty(stringExtra2)) {
            intent.putExtra("promotion_list", stringExtra2);
        }
        if (!useNewBindBankProgram() && this.helper.getParentParams().size() > 0) {
            intent.putExtra("params", this.helper.getParentParams());
        }
        startActivityForResult(intent, ActivateTenpayAccount.class, new IResult() { // from class: com.tenpay.sdk.activity.BindBankActivity.33
            @Override // com.tenpay.sdk.IResult
            public void back(int i3, Intent intent2) {
                String str;
                String str2;
                if (i3 == -1) {
                    if (intent2 != null && intent2.getIntExtra("phone_not_same", 0) == 1) {
                        BindBankActivity bindBankActivity = BindBankActivity.this;
                        if (!bindBankActivity.mForgetPassFlag) {
                            bindBankActivity.setRetCodeAndGetBundle(-4);
                        }
                        BindBankActivity.this.finish();
                        return;
                    }
                    BindBankActivity bindBankActivity2 = BindBankActivity.this;
                    if (bindBankActivity2.mForgetPassCache) {
                        bindBankActivity2.setResult(-1);
                        WalletGateData.getInstance().clear();
                        BindBankActivity.this.finish();
                        return;
                    }
                    if (bindBankActivity2.mIsShiMing) {
                        com.tencent.mobileqq.qwallet.c.c("extra.identify.ok", 19);
                        BindBankActivity.this.setResult(-1);
                        WalletGateData.getInstance().clear();
                        BindBankActivity.this.mKeyBoard.setVisibility(8);
                        if (intent2 == null) {
                            return;
                        }
                        final String stringExtra3 = intent2.getStringExtra(NotificationActivity.PASSWORD);
                        BindBankActivity bindBankActivity3 = BindBankActivity.this;
                        bindBankActivity3.showOkTips(bindBankActivity3.getString(R.string.eef), new DialogInterface.OnDismissListener() { // from class: com.tenpay.sdk.activity.BindBankActivity.33.1
                            @Override // android.content.DialogInterface.OnDismissListener
                            public void onDismiss(DialogInterface dialogInterface) {
                                if (BindBankActivity.this.mIsFromQrCodepay) {
                                    Intent intent3 = new Intent();
                                    intent3.putExtra(NotificationActivity.PASSWORD, stringExtra3);
                                    BindBankActivity.this.setResult(-1, intent3);
                                } else {
                                    BindBankActivity.this.setResult(-1);
                                }
                                BindBankActivity.this.finish();
                            }
                        });
                        return;
                    }
                    QwLog.i("mIsFromWithdraw = " + BindBankActivity.this.mIsFromWithdraw);
                    BindBankActivity bindBankActivity4 = BindBankActivity.this;
                    if (bindBankActivity4.mIsFromWithdraw) {
                        com.tencent.mobileqq.qwallet.c.c("extra.cashbind.ok", 127);
                        Intent intent3 = new Intent();
                        intent3.putExtra(WithdrawActivity.WITHDRAW_COUNT, BindBankActivity.this.mWithdrawCount);
                        intent3.putExtra("pass_flag", 2);
                        intent3.putExtra("bing_withdraw_flag", true);
                        BindBankActivity.this.launchFragment(intent3, WithdrawActivity.class);
                        BindBankActivity.this.setResult(-1, intent3);
                        BindBankActivity.this.finish();
                        return;
                    }
                    Bundle retCodeAndGetBundle = bindBankActivity4.setRetCodeAndGetBundle(0);
                    String charSequence = BindBankActivity.this.mBinInputSelBankName.getText().toString();
                    if (charSequence.length() > 3) {
                        str = charSequence.substring(0, charSequence.length() - 3);
                        str2 = charSequence.substring(charSequence.length() - 3, charSequence.length());
                    } else {
                        str = "";
                        str2 = "";
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("name", str);
                        jSONObject.put("type", str2);
                        String data = BindBankActivity.this.mBinNo.getData();
                        jSONObject.put(TextNode.MODE_TAIL, data.substring(data.length() - 4, data.length()));
                    } catch (JSONException unused) {
                    }
                    com.tencent.mobileqq.qwallet.c.c("extra.registerbind.ok", 102);
                    if (intent2 == null) {
                        return;
                    }
                    final String stringExtra4 = intent2.getStringExtra("result");
                    if (stringExtra4 != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("bind_serial", new JSONObject(stringExtra4).optString("bind_serial"));
                        } catch (Exception unused2) {
                        }
                        retCodeAndGetBundle.putString("retdata", jSONObject2.toString());
                    }
                    retCodeAndGetBundle.putString("retmsg", jSONObject.toString());
                    BindBankActivity.this.mKeyBoard.setVisibility(8);
                    BindBankActivity bindBankActivity5 = BindBankActivity.this;
                    bindBankActivity5.showOkTipsWithSubTitle(bindBankActivity5.getContext(), BindBankActivity.this.getString(R.string.e2a), BindBankActivity.this.getString(R.string.e2_), new DialogInterface.OnDismissListener() { // from class: com.tenpay.sdk.activity.BindBankActivity.33.2
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            BindBankActivity bindBankActivity6 = BindBankActivity.this;
                            if (bindBankActivity6.mIsFromFingerPaySetting) {
                                if (134 == bindBankActivity6.getProcessType()) {
                                    com.tencent.mobileqq.qwallet.c.c("extra.registerbind.ok", 134);
                                } else if (133 == BindBankActivity.this.getProcessType()) {
                                    if (BindBankActivity.this.mIsNeedVerifyPasswd) {
                                        com.tencent.mobileqq.qwallet.c.c("extra.pwdbind.ok", 133);
                                    } else {
                                        com.tencent.mobileqq.qwallet.c.c("extra.nopwdbind.ok", 133);
                                    }
                                }
                            }
                            Intent intent4 = new Intent();
                            intent4.putExtra("bind_serial", stringExtra4);
                            BindBankActivity.this.setResult(-1, intent4);
                            BindBankActivity.this.finish();
                        }
                    });
                    TenUtils.broadCastIdVerified();
                    WalletGateData.getInstance().clear();
                    return;
                }
                if (intent2 != null && !BindBankActivity.this.useNewBindBankProgram() && "fail".equalsIgnoreCase(intent2.getStringExtra("guardian_check"))) {
                    BindBankActivity.this.helper.pros8to14ChildParentInfoLogic(BindBankActivity.this.mCardIdEdit.getText().toString().trim());
                }
            }
        });
    }

    protected void gotoActivateTenpayAccountDeposit() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(TPDownloadProxyEnum.USER_SSID, this.mNewUserDepositObj.optString(TPDownloadProxyEnum.USER_SSID));
            jSONObject.put("uin", this.mUin);
            jSONObject.put("bank_type", this.mBinBank.optString("code"));
            jSONObject.put("verify_code", this.mYzmEdit.getText().toString().trim());
            jSONObject.put("process_flag", getProcessType());
            jSONObject.put("timestamp", this.mTimestamp);
            jSONObject.put("true_name", this.mNameEdit.getText().toString());
            jSONObject.put("deposit_count", this.mDepositCount);
            jSONObject.put("bank_info", this.mPayType);
        } catch (Exception unused) {
        }
        Intent intent = new Intent();
        intent.putExtra(ActivateTenpayAccount.PARAM_ACTIVATE_ACCOUNT_JSON, jSONObject.toString());
        intent.putExtra(DepositStartActivity.FROM_DESPOSIT, true);
        if (!useNewBindBankProgram() && this.helper.getParentParams().size() > 0) {
            intent.putExtra("params", this.helper.getParentParams());
        }
        launchFragmentForResult(intent, ActivateTenpayAccount.class, 2000);
    }

    protected void gotoDepositSuccess(JSONObject jSONObject) {
        Intent intent = new Intent();
        intent.putExtra(CommonCode.MapKey.TRANSACTION_ID, jSONObject.optString(CommonCode.MapKey.TRANSACTION_ID));
        intent.putExtra("pay_time", jSONObject.optString("pay_time"));
        intent.putExtra("bank_info", this.mPayType);
        intent.putExtra("true_name", this.mTrueName);
        intent.putExtra("deposit_count", this.mDepositCount);
        intent.putExtra("process_flag", getProcessType());
        launchFragment(intent, DepositSuccessActivity.class);
        finish();
    }

    protected void initBanks(JSONObject jSONObject) {
        this.mBankData = jSONObject;
        if (this.mFastDebitBankList == null && this.mFastCreditBankList == null && this.mBankList == null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("banklist");
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                String optString = optJSONObject.optString("type");
                if (!this.isQuickMode || optJSONObject.optInt("quickmode") == 1) {
                    if (!NetParams.DEBIT_FAST.equals(optString) && !NetParams.CREDIT_FAST.equals(optString) && !"DEBIT".equals(optString) && !"CREDIT".equals(optString)) {
                        if (NetParams.DEBIT_UNBIND.equals(optJSONObject.optString("type"))) {
                            if (this.mFastDebitBankList == null) {
                                this.mFastDebitBankList = new ArrayList();
                            }
                            this.mFastDebitBankList.add(optJSONObject);
                        } else {
                            if (this.mFastCreditBankList == null) {
                                this.mFastCreditBankList = new ArrayList();
                            }
                            this.mFastCreditBankList.add(optJSONObject);
                        }
                    } else {
                        if (this.mBankList == null) {
                            this.mBankList = new ArrayList<>();
                        }
                        this.mBankList.add(optJSONObject);
                    }
                }
            }
        }
    }

    protected boolean initInputBankInfo(JSONObject jSONObject) {
        if (jSONObject == null) {
            this.mBinPhoneLayout.setVisibility(8);
            this.mBinInputCredit.setVisibility(8);
            return false;
        }
        this.mCardTypeList.clear();
        String optString = jSONObject.optString("code");
        JSONObject jSONObject2 = this.mBankSupportJson;
        if (jSONObject2 != null && jSONObject2.has(optString)) {
            HashSet hashSet = new HashSet(Arrays.asList(this.mBankSupportJson.optString(optString).split("\\|")));
            for (int i3 = 0; i3 < this.mCardTypeFullList.size(); i3++) {
                JSONObject jSONObject3 = this.mCardTypeFullList.get(i3);
                if (hashSet.contains(jSONObject3.optString("cre_type"))) {
                    this.mCardTypeList.add(jSONObject3);
                }
            }
        } else {
            JSONObject jSONObject4 = this.mCardTypeSFZ;
            if (jSONObject4 != null) {
                this.mCardTypeList.add(jSONObject4);
            }
        }
        this.mBinInputSelBankName.setText(jSONObject.optString("name"));
        if (!NetParams.DEBIT_UNBIND.equals(jSONObject.optString("type")) && !NetParams.DEBIT_FAST.equals(jSONObject.optString("type"))) {
            int optInt = jSONObject.optInt("needcvv");
            if (jSONObject.optInt("needthru") == 0) {
                if (optInt == 0) {
                    if (this.mBinInputPhone.getVisibility() != 0) {
                        if (this.mIsMidas) {
                            addTraceData("name");
                        } else {
                            addTraceData("holderinfo");
                        }
                    }
                    this.mBinPhoneLayout.setVisibility(0);
                    this.mBinInputCredit.setVisibility(8);
                } else {
                    this.mBinPhoneLayout.setVisibility(8);
                    if (this.mIsMidas) {
                        addTraceData("cvv");
                    } else {
                        addTraceData("creditinfo");
                    }
                    this.mBinInputBankCvv.setVisibility(0);
                    this.mBinInputBankCvvLayout.setVisibility(0);
                    this.mBinInputCreditThru.setVisibility(8);
                    this.mBinInputCreditThruLayout.setVisibility(8);
                    this.mBinInputCreditThruLine.setVisibility(8);
                    this.mBinInputCredit.setVisibility(0);
                }
            } else if (optInt == 0) {
                this.mBinPhoneLayout.setVisibility(8);
                if (this.mIsMidas) {
                    addTraceData("cvv");
                } else {
                    addTraceData("creditinfo");
                }
                this.mBinInputCredit.setVisibility(0);
                this.mBinInputCreditThru.setVisibility(0);
                this.mBinInputCreditThruLayout.setVisibility(0);
                this.mBinInputCreditThruLine.setVisibility(8);
                this.mBinInputBankCvv.setVisibility(8);
                this.mBinInputBankCvvLayout.setVisibility(8);
            } else {
                this.mBinPhoneLayout.setVisibility(8);
                if (this.mIsMidas) {
                    addTraceData("cvv");
                } else {
                    addTraceData("creditinfo");
                }
                this.mBinInputCredit.setVisibility(0);
                this.mBinInputCreditThru.setVisibility(0);
                this.mBinInputCreditThruLayout.setVisibility(0);
                this.mBinInputCreditThruLine.setVisibility(0);
                this.mBinInputBankCvv.setVisibility(0);
                this.mBinInputBankCvvLayout.setVisibility(0);
            }
        } else {
            if (this.mBinPhoneLayout.getVisibility() != 0) {
                if (this.mIsMidas) {
                    addTraceData("name");
                } else {
                    addTraceData("holderinfo");
                }
            }
            this.mBinPhoneLayout.setVisibility(0);
            this.mBinInputCredit.setVisibility(8);
        }
        if (!this.mForgetPassFlag && this.isShowPersonInfo) {
            this.mBinPhoneLayout.setVisibility(8);
        }
        return false;
    }

    protected void initTimer() {
        CountDownTimer countDownTimer = this.mTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.mTimer = null;
        }
        CountDownTimer countDownTimer2 = new CountDownTimer(60000L, 1000L) { // from class: com.tenpay.sdk.activity.BindBankActivity.32
            @Override // android.os.CountDownTimer
            public void onFinish() {
                QwLog.i("time finished...");
                BindBankActivity bindBankActivity = BindBankActivity.this;
                if (bindBankActivity.isMobileNumber(bindBankActivity.mYzmPhoneNum.getText().toString())) {
                    BindBankActivity.this.mYzmGetSMSBtn.setEnabled(true);
                    BindBankActivity.this.mYzmGetSMSBtn.setText(R.string.ede);
                } else {
                    BindBankActivity.this.mYzmGetSMSBtn.setEnabled(false);
                    BindBankActivity.this.mYzmGetSMSBtn.setText(R.string.f17937397);
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j3) {
                QwLog.i("time: " + j3);
                BindBankActivity.this.mYzmGetSMSBtn.setEnabled(false);
                BindBankActivity.this.mYzmGetSMSBtn.setText("\u5df2\u53d1\u9001 (" + (j3 / 1000) + ")");
            }
        };
        this.mTimer = countDownTimer2;
        countDownTimer2.start();
    }

    protected void initVerifyPasswordPage(View view) {
        this.mVerifyPasswordLayout = (LinearLayout) view.findViewById(R.id.f94405c7);
        ClearableEditText clearableEditText = (ClearableEditText) view.findViewById(R.id.yuu);
        this.mLongPwdEdit = clearableEditText;
        clearableEditText.setOnTextChangedListener(new ClearableEditText.OnTextChangedListener() { // from class: com.tenpay.sdk.activity.q
            @Override // com.tenpay.sdk.view.ClearableEditText.OnTextChangedListener
            public final void onTextChanged() {
                BindBankActivity.this.lambda$initVerifyPasswordPage$7();
            }
        });
        SixPasswdDialogEditText sixPasswdDialogEditText = (SixPasswdDialogEditText) view.findViewById(R.id.iwz);
        this.mSixPasswdEdit = sixPasswdDialogEditText;
        sixPasswdDialogEditText.setLongClickable(false);
        this.mSixPasswdEdit.setOnPasswdInputListener(new OnPasswdInputListener() { // from class: com.tenpay.sdk.activity.r
            @Override // com.tenpay.sdk.view.OnPasswdInputListener
            public final void onTextChange() {
                BindBankActivity.this.lambda$initVerifyPasswordPage$8();
            }
        });
        this.mSixPasswdEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tenpay.sdk.activity.s
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view2, boolean z16) {
                BindBankActivity.this.lambda$initVerifyPasswordPage$9(view2, z16);
            }
        });
        this.mSixPasswdEdit.setOnClickListener(this);
        Button button = (Button) view.findViewById(R.id.f116586z5);
        this.verifyPasswordBtn = button;
        button.setOnClickListener(this);
    }

    public boolean isMobileNumber(String str) {
        if (!TextUtils.isEmpty(str) && str.length() == 11) {
            return str.startsWith("1");
        }
        return false;
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        String stringExtra;
        QwLog.i("bind result requestCode = " + i3 + " resultCode = " + i16);
        super.onActivityResult(i3, i16, intent);
        boolean z16 = true;
        if (i3 == 10) {
            if (intent != null && (stringExtra = intent.getStringExtra("bank")) != null) {
                try {
                    this.mBinBank = new JSONObject(stringExtra);
                    String data = this.mBinNo.getData();
                    int length = data.length();
                    JSONObject jSONObject = this.mBinBank;
                    if (jSONObject != null) {
                        String optString = jSONObject.optString("type");
                        if ((NetParams.DEBIT_FAST.equals(optString) || NetParams.CREDIT_FAST.equals(optString)) && this.mBinBank.optString("card_tail").equals(data.substring(length - 5, length - 1))) {
                            StringBuffer stringBuffer = new StringBuffer();
                            stringBuffer.append(getString(R.string.e1c));
                            QUIProxy.createCustomDialog(getContext(), 230, null, stringBuffer.toString(), getString(R.string.e5j), null, null, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.BindBankActivity.36
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i17) {
                                    BindBankActivity.this.mBinNo.setText("");
                                }
                            });
                            return;
                        }
                    }
                    initInputBankInfo(this.mBinBank);
                    this.mBinPhoneLayout.setVisibility(0);
                    if (this.mBinInputCredit.getVisibility() == 0) {
                        if (this.mBinInputCreditThru.getVisibility() == 0 && this.mBinInputCreditThru.getText().toString().length() == 0) {
                            this.mBinInputCreditThru.requestFocus();
                            return;
                        } else {
                            if (this.mBinInputBankCvv.getText().toString().length() == 0) {
                                this.mBinInputBankCvv.requestFocus();
                                return;
                            }
                            return;
                        }
                    }
                    if (this.mBinInputPhone.getText().toString().length() == 0) {
                        this.mBinInputPhone.requestFocus();
                        return;
                    }
                    return;
                } catch (Exception e16) {
                    QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
                    return;
                }
            }
            return;
        }
        if (i3 == 100 && i16 == -1) {
            com.tencent.mobileqq.qwallet.c.c("extra.resetpwd.ok", 107);
            if (this.mIsFromH5FindPsw && this.mForgetPassFlag) {
                setRetCodeAndGetBundle(0).putString(Cgi.RETURN_MSG_KEY, "");
            } else if (this.mIsFromDeposit && this.mForgetPassFlag) {
                JSONObject jSONObject2 = this.mBinBank;
                if (jSONObject2 != null) {
                    String optString2 = jSONObject2.optString("type");
                    if (NetParams.DEBIT_FAST.equals(optString2) || NetParams.CREDIT_FAST.equals(optString2)) {
                        z16 = false;
                    }
                }
                if (this.mIsFromH5FindPsw) {
                    setRetCodeAndGetBundle(0).putBoolean("forget_bind", z16);
                } else {
                    Intent intent2 = new Intent();
                    intent2.putExtra("forget_bind", z16);
                    setResult(-1, intent2);
                }
            } else {
                setResult(-1);
            }
            WalletGateData.getInstance().clear();
            finish();
            return;
        }
        if (i3 == 1002 && i16 == -1) {
            if (intent != null) {
                updateProfession(intent.getStringExtra(JobSelectionActivity.PARAM_SELECTED_JOB));
                return;
            }
            return;
        }
        if (i3 == 2000 && i16 == -1) {
            this.mYzmEdit.setText("");
            showView(3);
            closeTime();
        } else if (i3 != 1000 && i3 != 1004 && i3 != 1003) {
            if (i3 == 101) {
                onFaceVerifyFinish(i16, intent);
            }
        } else if (i16 == -1) {
            showBindBankNumIndex();
        } else {
            finish();
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onBlError(String str, JSONObject jSONObject) {
        super.onBlError(str, jSONObject);
        if (isFinishing()) {
            return;
        }
        String optString = jSONObject.optString("retcode");
        if (!ErrorCode.ERR_REGISTER_TIME_OUT.equals(optString) && !ErrorCode.ERR_PAY_NOT_ENOUGH.equals(optString) && !ErrorCode.ERR_PASSWORD_BALANCE_PAY.equals(optString)) {
            if (ErrorCode.ERR_PAYPASS_TIMEOUT.equals(optString)) {
                httpRequestNoEncript(Cgi.URI_GET_PASS_TIME, new HashMap());
                return;
            } else {
                if (ErrorCode.ERR_WRONG_VIRIFY_CODE.equals(optString)) {
                    showView(3);
                    return;
                }
                return;
            }
        }
        QUIProxy.showConfirm(getContext(), jSONObject.optString("retmsg"), null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(final View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 != R.id.ivTitleBtnLeft && id5 != R.id.ivTitleBtnRightText) {
            if (id5 == R.id.a9b) {
                long currentTimeMillis = System.currentTimeMillis();
                if (Math.abs(currentTimeMillis - this.mLastClickedTime) >= 1000) {
                    this.mLastClickedTime = currentTimeMillis;
                    if (this.mIsMidas) {
                        addTraceData("sure");
                    } else {
                        addTraceData("next");
                    }
                    if (this.needShowSmallPrivacy) {
                        showPrivacyDialog();
                    } else {
                        handleNamedUserNextStep();
                    }
                }
            } else {
                String str = "1";
                if (id5 == R.id.jez) {
                    if (this.mIsMidas) {
                        addTraceData("sure");
                    } else {
                        addTraceData(ResourceAttributes.TelemetrySdkLanguageValues.GO);
                    }
                    if (validateYzm()) {
                        if (this.mIsNeedVerifyPasswd) {
                            showView(4);
                        } else {
                            getWindow().setSoftInputMode(3);
                            if (this.mIsFromDeposit && !this.mForgetPassFlag) {
                                int i3 = this.mUserAttr;
                                if (i3 != 0 && i3 != 3) {
                                    confirmYzmDeposit("2");
                                } else {
                                    confirmYzmDeposit("1");
                                }
                            } else {
                                int i16 = this.mUserAttr;
                                if (i16 != 0 && i16 != 3) {
                                    if (this.mForgetPassFlag) {
                                        HashMap<String, String> hashMap = this.mRegisterPreObj;
                                        if (hashMap != null) {
                                            if (!hashMap.isEmpty() && !"1".equals(this.mRegisterPreObj.get("check_vcode_flag"))) {
                                                Intent intent = new Intent();
                                                intent.putExtra("data", this.mRegisterPreObj);
                                                intent.putExtra("bink_data", this.mRegisterRequestYzmParamsObj);
                                                intent.putExtra("yzm", this.mYzmEdit.getText().toString());
                                                launchFragmentForResult(intent, ResetPassActivity.class, 100);
                                            } else {
                                                registerBindYzMsg();
                                            }
                                        }
                                    } else if (i16 == 1 || i16 == 2) {
                                        confirmYzm();
                                    }
                                } else {
                                    HashMap<String, String> hashMap2 = this.mRegisterPreObj;
                                    if (hashMap2 != null) {
                                        if ("1".equals(hashMap2.get("check_vcode_flag"))) {
                                            registerBindYzMsg();
                                        } else {
                                            gotoActivateTenpayAccount();
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else if (id5 == R.id.f116586z5) {
                    getWindow().setSoftInputMode(3);
                    this.mPasswd = getPassword();
                    if (this.mIsFromDeposit && !this.mForgetPassFlag) {
                        int i17 = this.mUserAttr;
                        if (i17 != 0 && i17 != 3) {
                            confirmYzmDeposit("2");
                        } else {
                            confirmYzmDeposit("1");
                        }
                    } else {
                        int i18 = this.mUserAttr;
                        if (i18 != 0 && i18 != 3) {
                            if (this.mForgetPassFlag) {
                                if ("1".equals(this.mRegisterPreObj.get("check_vcode_flag"))) {
                                    registerBindYzMsg();
                                } else {
                                    Intent intent2 = new Intent();
                                    intent2.putExtra("data", this.mRegisterPreObj);
                                    intent2.putExtra("bink_data", this.mRegisterRequestYzmParamsObj);
                                    intent2.putExtra("yzm", this.mYzmEdit.getText().toString());
                                    launchFragmentForResult(intent2, ResetPassActivity.class, 100);
                                }
                            } else if (i18 == 1 || i18 == 2) {
                                confirmYzm();
                            }
                        } else {
                            registerBindYzMsg();
                        }
                    }
                } else if (id5 == R.id.f166961jf2) {
                    if (this.mIsMidas) {
                        addTraceData("refresh");
                    } else {
                        addTraceData("reacquire");
                    }
                    this.mPhoneNum = this.mYzmPhoneNum.getText().toString();
                    getSmsYzm();
                    initTimer();
                    this.sendSmsNum++;
                    this.mYzmEdit.requestFocus();
                    this.mYzmEdit.setText("");
                } else if (id5 == R.id.cja) {
                    gotoH5(Cgi.PWD_FIND_ENTRY);
                    int processType = getProcessType();
                    if (processType == 107) {
                        com.tencent.mobileqq.qwallet.c.c("bind.info.question", Integer.valueOf(processType));
                    }
                } else if (id5 == R.id.a_2) {
                    showPhoneTipsDialog();
                } else if (id5 == R.id.tog) {
                    cardIdTimeClick(this.cardStartDateTxt);
                } else if (id5 == R.id.tnk) {
                    cardIdTimeClick(this.cardEndDateTxt);
                } else if (id5 == R.id.iqg) {
                    onSexSelectClick();
                } else if (id5 == R.id.y_u) {
                    Intent intent3 = new Intent();
                    intent3.putExtra(JobSelectionActivity.PARAM_SELECTED_JOB, this.mJobName);
                    launchFragmentForResult(intent3, JobSelectionActivity.class, 1002);
                } else if (id5 == R.id.flj) {
                    if (this.mCurSexType == 1) {
                        str = "0";
                    }
                    com.tencent.mobileqq.qwallet.c.e("realname.gender.sumbit", "", str, "", "");
                    if (validateIdNumber() && validatePersonalInfo()) {
                        checkFormAndConfirm();
                    }
                } else if (id5 == R.id.sdy) {
                    Intent intent4 = new Intent();
                    intent4.putExtra(LocationInputFragment.KEY_ADDRESS_PROVINCE, this.mProvince);
                    intent4.putExtra(LocationInputFragment.KEY_ADDRESS_CITY, this.mCity);
                    intent4.putExtra(LocationInputFragment.KEY_ADDRESS_DISTRICT, this.mDistrict);
                    intent4.putExtra(LocationInputFragment.KEY_DETAIL_ADDRESS, this.mDetailAddress);
                    startActivityForResult(intent4, LocationInputFragment.class, new IResult() { // from class: com.tenpay.sdk.activity.j
                        @Override // com.tenpay.sdk.IResult
                        public final void back(int i19, Intent intent5) {
                            BindBankActivity.this.lambda$onClick$12(i19, intent5);
                        }
                    });
                } else if (id5 == R.id.xfw) {
                    if (validateVerifyIdNumber()) {
                        showView(1);
                    }
                } else if (id5 == R.id.iwz && this.mKeyBoard.getVisibility() == 8) {
                    view.postDelayed(new Runnable() { // from class: com.tenpay.sdk.activity.BindBankActivity.27
                        @Override // java.lang.Runnable
                        public void run() {
                            BindBankActivity.this.mKeyBoard.setVisibility(0);
                            BindBankActivity.this.mKeyBoard.setXMode(3);
                            BindBankActivity.this.mKeyBoard.setInputEditText((EditText) view);
                        }
                    }, 200L);
                }
            }
        } else {
            if (id5 == R.id.ivTitleBtnLeft) {
                addTraceData("back");
            } else {
                addTraceData("cancel");
            }
            back();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        int i3;
        super.onCreate(bundle);
        getWindow().addFlags(8192);
        this.helper = new RealNamePopHelper(this);
        Intent intent = getIntent();
        if (intent != null) {
            boolean booleanExtra = intent.getBooleanExtra(WithdrawActivity.FROM_WITHDRAW, false);
            this.mIsFromWithdraw = booleanExtra;
            if (booleanExtra) {
                this.mWithdrawCount = intent.getStringExtra(WithdrawActivity.WITHDRAW_COUNT);
            }
            boolean booleanExtra2 = intent.getBooleanExtra(DepositStartActivity.FROM_DESPOSIT, false);
            this.mIsFromDeposit = booleanExtra2;
            if (booleanExtra2) {
                this.mDepositCount = intent.getStringExtra(DepositStartActivity.DESPOSIT_COUNT);
                boolean booleanExtra3 = intent.getBooleanExtra("from_finger_deposit", false);
                this.mIsFromFingerDeposit = booleanExtra3;
                if (booleanExtra3) {
                    this.mFingerDepositProcessType = intent.getIntExtra(ChoosePayTypeFragment.KEY_PROCESS_TYPE, 139);
                }
            }
            this.mIsFromCheckPsw = intent.getBooleanExtra(PassVerifyActivity.FROM_CHECKPSW, false);
            this.mIsFromH5FindPsw = intent.getBooleanExtra("h5_find_pwd", false);
            this.mIsFromChoosePayTypeSmall = intent.getBooleanExtra("from_choose_pay_type_small", false);
            this.mIsFromFingerPaySetting = intent.getBooleanExtra(FingerPaySettingSoterFragment.FROM_FINGER_PAY_SETTING, false);
            boolean booleanExtra4 = intent.getBooleanExtra(PayActivity.FROM_FINGER_PAY, false);
            this.mIsFromFingerPay = booleanExtra4;
            if (booleanExtra4) {
                this.mFingerPayProcessType = intent.getIntExtra(ChoosePayTypeFragment.KEY_PROCESS_TYPE, 137);
            }
            this.prefillUserInfo = intent.getStringExtra("prefillUserInfo");
            if (this.mBargainorId == null) {
                this.mBargainorId = "";
            }
            if (this.mAppInfo == null) {
                this.mAppInfo = "";
            }
            boolean booleanExtra5 = intent.getBooleanExtra("forget_pass", false);
            this.mForgetPassFlag = booleanExtra5;
            this.mForgetPassCache = booleanExtra5;
            int intExtra = intent.getIntExtra("pass_flag", -1);
            this.mPassFlag = intExtra;
            if (intExtra == -1) {
                String str = super.mPassFlag;
                if (!TextUtils.isEmpty(str)) {
                    try {
                        this.mPassFlag = Integer.parseInt(str);
                    } catch (NumberFormatException unused) {
                        QwLog.e("pass_flag parseInt error:" + str);
                    }
                }
            }
            this.mFrom = intent.getIntExtra("wallet_bind", 0);
            boolean booleanExtra6 = intent.getBooleanExtra("IsShiMing", false);
            this.mIsShiMing = booleanExtra6;
            if (booleanExtra6) {
                this.mIsIdVerifyValid = intent.getBooleanExtra("IsIdVerifyValid", false);
                this.mIsFromPayShiMing = intent.getBooleanExtra("IsFromPay", false);
            }
            this.mFromHBShiMing = intent.getBooleanExtra("FromHBShiMing", false);
            this.mIsFromQrCodepay = intent.getBooleanExtra("from_qrcodepay", false);
            if (this.mIsShiMing) {
                this.mFrom = 1;
            }
            this.mTrustPayOpen = intent.getStringExtra("trustpay_open_flag");
            this.mHBShiMingTips = intent.getStringExtra("hb_shiming_tips");
            this.realNameSource = (RealNameSource) intent.getParcelableExtra(RealNameSource.EXTRA_KEY_SOURCE);
        }
        if (this.mFrom == 1 && ((this.mIsFromH5FindPsw || !this.mForgetPassFlag) && !this.mIsFromWithdraw && !this.mIsFromDeposit && !this.mIsFromFingerPaySetting && !this.mIsFromFingerPay && !this.mIsShiMing)) {
            JSONObject data = WalletGateData.getInstance().getData();
            if (data != null) {
                this.mTimestamp = WalletGateData.getInstance().getSysTimeStamp();
                this.mBargainorName = data.optString("bargainor_true_name");
                this.mGoodsName = data.optString("desc");
                String optString = data.optString("creditcard_type");
                if (!TextUtils.isEmpty(optString)) {
                    this.mCardType = optString;
                }
                this.mCardID = data.optString("creditcard_id");
                this.mTrueName = data.optString("purchaser_true_name");
                this.mUserAttr = data.optInt("user_attr");
                this.mCacheVer = data.optString("interf_cache_ver");
                this.mUserCertType = data.optInt("cert_user");
                String optString2 = data.optString("domain_name");
                if (!TextUtils.isEmpty(optString2)) {
                    setServerAddr(optString2);
                }
                if (this.mForgetPassFlag && ((i3 = this.mUserAttr) == 0 || i3 == 3)) {
                    QUIProxy.createCustomDialog(getContext(), 230, null, "\u672a\u6ce8\u518c\u8d22\u4ed8\u901a", getString(R.string.e5j), null, null, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.BindBankActivity.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i16) {
                            BindBankActivity.this.finish();
                        }
                    });
                    return;
                } else {
                    sendWalBankQueryRequest();
                    checkBankSupportConfig();
                    return;
                }
            }
            sendWallGateRequest();
            return;
        }
        sendWallGateRequest();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.adg, viewGroup, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        closeTime();
        try {
            Dialog dialog = this.mSexTypeDialog;
            if (dialog != null) {
                dialog.dismiss();
            }
        } catch (Throwable unused) {
        }
        super.onDestroy();
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        CountDownTimer countDownTimer = this.mTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity
    public void onNetDlgokClick(String str, JSONObject jSONObject) {
        super.onNetDlgokClick(str, jSONObject);
        if (ErrorCode.ERR_PAY_PASSWORD.equals(jSONObject.optString("retcode"))) {
            setRetCodeAndGetBundle(-6);
            finish();
            return;
        }
        String optString = jSONObject.optString("returl");
        boolean equals = TextUtils.equals(Uri.parse(optString).getQueryParameter("exitProcess"), "0");
        if (!TextUtils.isEmpty(optString) && !equals) {
            if (this.mEnterType == 1 && !this.mForgetPassFlag) {
                setRetCodeAndGetBundle(-1).putInt("time_out", 1);
            }
            finish();
        }
        if (Cgi.URI_YDTBANK_QUERY.equals(str) && !QWalletFakeUrl.hasQWalletFakeProtocal(jSONObject)) {
            finish();
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        addTraceData("show");
        Dialog dialog = this.mCardTypeListDialog;
        if (dialog != null && dialog.isShowing()) {
            this.mCardTypeListDialog.dismiss();
            this.mCardTypeListDialog = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0357  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x036d  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x027f  */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r3v30 */
    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSuccess(String str, JSONObject jSONObject) {
        String str2;
        String str3;
        ?? r36;
        FileOutputStream fileOutputStream;
        String str4;
        JSONArray optJSONArray;
        int optInt;
        int i3;
        boolean z16;
        boolean z17;
        int i16;
        String optString;
        String optString2;
        String optString3;
        int i17;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        super.onSuccess(str, jSONObject);
        if (jSONObject == null || isFinishing()) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        if (str.equals(Cgi.URI_YDTBANK_QUERY)) {
            final JSONObject optJSONObject = jSONObject.optJSONObject("user_info_extend");
            if (optJSONObject != null) {
                if (optJSONObject.optInt("need_fill") == 0) {
                    this.isShowPersonInfo = false;
                } else {
                    this.isShowPersonInfo = !this.mForgetPassFlag;
                    try {
                        final JSONArray optJSONArray2 = optJSONObject.optJSONArray("address_suggest");
                        if (optJSONArray2 == null || optJSONArray2.length() <= 0 || (jSONObject3 = (JSONObject) optJSONArray2.get(0)) == null) {
                            str4 = "authen_channel_state";
                        } else {
                            this.mProvince = jSONObject3.optString("province");
                            this.mCity = jSONObject3.optString("city", "");
                            this.mDistrict = jSONObject3.optString(TtmlNode.TAG_REGION, "");
                            this.mDetailAddress = jSONObject3.optString("address", "");
                            TextView textView = this.mAddressTxt;
                            StringBuilder sb5 = new StringBuilder();
                            str4 = "authen_channel_state";
                            try {
                                sb5.append(this.mProvince);
                                sb5.append(" ");
                                sb5.append(this.mCity);
                                sb5.append(" ");
                                sb5.append(this.mDistrict);
                                sb5.append(" ");
                                sb5.append(this.mDetailAddress);
                                textView.setText(sb5.toString());
                            } catch (Exception e16) {
                                e = e16;
                                QLog.e(((NetBaseActivity) this).TAG, 1, "", e);
                                optJSONArray = jSONObject.optJSONArray("creditcards_desc");
                                if (optJSONArray != null) {
                                }
                                if (this.mFrom == 1) {
                                }
                                optInt = jSONObject.optInt(str4);
                                this.mAuthenChanelState = optInt;
                                if ((optInt & 1) != 0) {
                                }
                                this.mIdVerifyBtn.setVisibility(8);
                                i3 = this.mUserAttr;
                                if (i3 != 0) {
                                }
                                this.mForgetPassFlag = false;
                                initBanks(jSONObject);
                                this.mBindGuide = jSONObject.optInt("bind_guide");
                                if (!this.mForgetPassFlag) {
                                }
                            }
                        }
                        final JSONArray optJSONArray3 = optJSONObject.optJSONArray("job_suggest");
                        if (optJSONArray3 != null && optJSONArray3.length() > 0 && (jSONObject2 = (JSONObject) optJSONArray3.get(0)) != null) {
                            this.mJobTxt.setText(jSONObject2.optString("title"));
                        }
                        ThreadManagerV2.excute(new Runnable() { // from class: com.tenpay.sdk.activity.m
                            @Override // java.lang.Runnable
                            public final void run() {
                                BindBankActivity.this.lambda$onSuccess$14(optJSONArray2, optJSONArray3, optJSONObject);
                            }
                        }, 64, null, false);
                    } catch (Exception e17) {
                        e = e17;
                        str4 = "authen_channel_state";
                    }
                    optJSONArray = jSONObject.optJSONArray("creditcards_desc");
                    if (optJSONArray != null) {
                        this.mCardTypeFullList.clear();
                        for (int i18 = 0; i18 < optJSONArray.length(); i18++) {
                            try {
                                this.mCardTypeFullList.add(optJSONArray.getJSONObject(i18));
                                JSONObject jSONObject4 = optJSONArray.getJSONObject(i18);
                                if ("1".equals(jSONObject4.optString("cre_type"))) {
                                    this.mCardTypeSFZ = jSONObject4;
                                }
                                QwLog.e("cre_type is " + optJSONArray.getJSONObject(i18).optString("cre_type"));
                                QwLog.e("cre_desc is " + optJSONArray.getJSONObject(i18).optString("cre_desc"));
                                QwLog.e("cre_len is " + optJSONArray.getJSONObject(i18).optString("cre_len"));
                            } catch (Exception e18) {
                                QLog.e(((NetBaseActivity) this).TAG, 1, "", e18);
                            }
                        }
                    }
                    if (this.mFrom == 1 && (i16 = this.mUserAttr) != 0 && i16 != 3) {
                        this.mUserAttr = jSONObject.optInt("user_attr");
                        if (!TextUtils.isEmpty(this.prefillUserInfo) && this.prefillUserInfo.equals("0") && this.mUserAttr == 2) {
                            this.mUserAttr = 1;
                            setCreIdTypeLayoutDisabled();
                        }
                        optString = jSONObject.optString("creditcard_type");
                        if (!TextUtils.isEmpty(optString)) {
                            this.mCardType = optString;
                        }
                        optString2 = jSONObject.optString("creditcard_id");
                        if (optString2 != null && !"".equals(optString2)) {
                            this.mCardID = optString2;
                        }
                        optString3 = jSONObject.optString("purchaser_true_name");
                        if (optString3 != null && !"".equals(optString3)) {
                            this.mTrueName = optString3;
                        }
                        this.mPassFlag = jSONObject.optInt("pass_flag");
                        if (!this.mForgetPassFlag) {
                            if (this.mUserAttr == 2) {
                                this.mBinUserLayout.setVisibility(0);
                                setTextAndUnEnable(this.mIdVerifyUserNameEdit, this.mTrueName);
                                setTextAndUnEnable(this.mBinTextUser, this.mTrueName);
                                setTextAndUnEnable(this.mNameEdit, this.mTrueName);
                                setCreIdTypeLayoutDisabled();
                                if (this.mCardType.equals("1")) {
                                    this.mIdVerifyCardIdEdit.setVisibility(0);
                                    this.mIdVerifyOtherCardIdEdit.setVisibility(8);
                                } else {
                                    this.mIdVerifyCardIdEdit.setVisibility(8);
                                    this.mIdVerifyOtherCardIdEdit.setVisibility(0);
                                }
                                setCreIdTypeText();
                            } else {
                                this.mBinUserLayout.setVisibility(8);
                                this.mIdVerifyUserNameEdit.setFocusable(true);
                                this.mIdVerifyUserNameEdit.setEnabled(true);
                                this.mBinTextUser.setEnabled(true);
                                this.mBinTextUser.setFocusable(true);
                                this.mNameEdit.setFocusable(true);
                                this.mNameEdit.setEnabled(true);
                                ArrayList<JSONObject> arrayList = this.mBankList;
                                if (arrayList != null && arrayList.size() > 0) {
                                    setCreIdTypeLayoutDisabled();
                                }
                            }
                        } else {
                            if (!TextUtils.isEmpty(this.prefillUserInfo) && this.prefillUserInfo.equals("0")) {
                                this.mNameEdit.setText("");
                                this.mCardIdEdit.setText("");
                                this.mCardOtherId.setText("");
                                i17 = 0;
                            } else {
                                setTextAndUnEnable(this.mNameEdit, this.mTrueName);
                                setCreIdTypeText();
                                if (this.mCardType.equals("1")) {
                                    setTextAndUnEnable(this.mCardIdEdit, this.mCardID);
                                    i17 = 0;
                                    this.mCardIdEdit.setVisibility(0);
                                    this.mCardOtherId.setVisibility(8);
                                } else {
                                    i17 = 0;
                                    setTextAndUnEnable(this.mCardOtherId, this.mCardID);
                                    this.mCardOtherId.setVisibility(0);
                                    this.mCardIdEdit.setVisibility(8);
                                }
                            }
                            if (this.mUserAttr == 2) {
                                this.mBinUserLayout.setVisibility(i17);
                                setTextAndUnEnable(this.mBinTextUser, this.mTrueName);
                                setTextAndUnEnable(this.mNameEdit, this.mTrueName);
                            } else {
                                this.mNameEdit.setFocusable(true);
                                this.mNameEdit.setEnabled(true);
                                if (this.mCardType.equals("1")) {
                                    this.mCardIdEdit.setFocusable(true);
                                    this.mCardIdEdit.setEnabled(true);
                                } else {
                                    this.mCardOtherId.setFocusable(true);
                                    this.mCardOtherId.setEnabled(true);
                                }
                                ArrayList<JSONObject> arrayList2 = this.mBankList;
                                if (arrayList2 != null && arrayList2.size() > 0) {
                                    setCreIdTypeLayoutDisabled();
                                }
                            }
                        }
                    }
                    optInt = jSONObject.optInt(str4);
                    this.mAuthenChanelState = optInt;
                    if ((optInt & 1) != 0 && this.mIsShiMing && this.mIsIdVerifyValid && needShowIdVerify(this.mUin)) {
                        this.mIdVerifyBtn.setVisibility(0);
                    } else {
                        this.mIdVerifyBtn.setVisibility(8);
                    }
                    i3 = this.mUserAttr;
                    if (i3 != 0 || i3 == 3) {
                        this.mForgetPassFlag = false;
                    }
                    initBanks(jSONObject);
                    this.mBindGuide = jSONObject.optInt("bind_guide");
                    if (!this.mForgetPassFlag) {
                        Intent intent = new Intent();
                        if (this.mUserAttr == 2) {
                            intent.putExtra("pass_flag", this.mPassFlag);
                            launchFragmentForResult(intent, VerifyPasswordActivity.class, 1000);
                            return;
                        }
                        Intent intent2 = getIntent();
                        if (intent2 != null) {
                            z16 = false;
                            z17 = intent2.getBooleanExtra(KEY_IGNORED_DIRECTION_PAGE, false);
                        } else {
                            z16 = false;
                            z17 = false;
                        }
                        this.needShowSmallPrivacy = z16;
                        if (z17) {
                            showBindBankNumIndex();
                            return;
                        }
                        intent.putExtra(IdVerifyDirectionFragment.KEY_SHOW_DIRECTION_LAYOUT, z16);
                        launchFragmentForResult(intent, IdVerifyDirectionFragment.class, 1004);
                        RealNameSourceReporter.INSTANCE.reportBindBankShow(this.realNameSource);
                        return;
                    }
                    this.mRootView.setAlpha(1.0f);
                    initView();
                    showView(0);
                    return;
                }
            }
            str4 = "authen_channel_state";
            optJSONArray = jSONObject.optJSONArray("creditcards_desc");
            if (optJSONArray != null) {
            }
            if (this.mFrom == 1) {
                this.mUserAttr = jSONObject.optInt("user_attr");
                if (!TextUtils.isEmpty(this.prefillUserInfo)) {
                    this.mUserAttr = 1;
                    setCreIdTypeLayoutDisabled();
                }
                optString = jSONObject.optString("creditcard_type");
                if (!TextUtils.isEmpty(optString)) {
                }
                optString2 = jSONObject.optString("creditcard_id");
                if (optString2 != null) {
                    this.mCardID = optString2;
                }
                optString3 = jSONObject.optString("purchaser_true_name");
                if (optString3 != null) {
                    this.mTrueName = optString3;
                }
                this.mPassFlag = jSONObject.optInt("pass_flag");
                if (!this.mForgetPassFlag) {
                }
            }
            optInt = jSONObject.optInt(str4);
            this.mAuthenChanelState = optInt;
            if ((optInt & 1) != 0) {
            }
            this.mIdVerifyBtn.setVisibility(8);
            i3 = this.mUserAttr;
            if (i3 != 0) {
            }
            this.mForgetPassFlag = false;
            initBanks(jSONObject);
            this.mBindGuide = jSONObject.optInt("bind_guide");
            if (!this.mForgetPassFlag) {
            }
        } else {
            if (str.equals(Cgi.URI_GET_PASS_TIME)) {
                String optString4 = jSONObject.optString(TVKLiveRequestBuilder.RequestParamKey.CKEY_TIMESTAMP);
                if (optString4.length() == 20) {
                    StringBuffer stringBuffer = new StringBuffer();
                    for (int i19 = 0; i19 < optString4.length(); i19++) {
                        if (i19 % 2 == 1) {
                            stringBuffer.append(optString4.charAt(i19));
                        }
                    }
                    this.mTimestamp = Long.parseLong(stringBuffer.toString()) - (System.currentTimeMillis() / 1000);
                    return;
                }
                this.mTimestamp = Long.parseLong(optString4) - (System.currentTimeMillis() / 1000);
                return;
            }
            if (str.equals(Cgi.QUERY_CARD_BIN_CONF_URI)) {
                JSONArray optJSONArray4 = jSONObject.optJSONArray("detail");
                this.mBinJson = optJSONArray4;
                if (optJSONArray4 != null) {
                    try {
                        try {
                            SharedPreferences.Editor edit = getSharedPreferences("qb_tenpay_prefer", 0).edit();
                            edit.putInt("bin_ver", this.mBinVerSer);
                            edit.commit();
                            fileOutputStream2 = getContext().openFileOutput("qb_tenpay_card_bin", 0);
                        } catch (Exception e19) {
                            e = e19;
                            fileOutputStream2 = null;
                        } catch (Throwable th5) {
                            th = th5;
                            fileOutputStream2 = null;
                            Utils.closeObject(fileOutputStream2);
                            throw th;
                        }
                        try {
                            fileOutputStream2.write(this.mBinJson.toString().getBytes());
                            fileOutputStream2.flush();
                        } catch (Exception e26) {
                            e = e26;
                            QLog.e(((NetBaseActivity) this).TAG, 1, "", e);
                            Utils.closeObject(fileOutputStream2);
                            return;
                        }
                        Utils.closeObject(fileOutputStream2);
                        return;
                    } catch (Throwable th6) {
                        th = th6;
                        Utils.closeObject(fileOutputStream2);
                        throw th;
                    }
                }
                return;
            }
            if (str.equals(Cgi.URI_QUERY_BANK_CACHE_CONF)) {
                this.mBankSupportJson = jSONObject.optJSONObject("bank_support_list");
                if (jSONObject.optInt("version") != 0) {
                    this.mBankSupportVer = jSONObject.optInt("version");
                }
                QwLog.e("version in onBLCallBack is " + this.mBankSupportVer);
                if (this.mBankSupportJson != null) {
                    try {
                        SharedPreferences.Editor edit2 = getSharedPreferences("qb_tenpay_prefer", 0).edit();
                        edit2.putInt("bank_support_ver", this.mBankSupportVer);
                        edit2.commit();
                        try {
                            fileOutputStream = getContext().openFileOutput("qb_tenpay_bank_support", 0);
                        } catch (Throwable th7) {
                            th = th7;
                            fileOutputStream = null;
                        }
                        try {
                            fileOutputStream.write(this.mBankSupportJson.toString().getBytes());
                            fileOutputStream.close();
                            return;
                        } catch (Throwable th8) {
                            th = th8;
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            throw th;
                        }
                    } catch (Exception e27) {
                        QLog.e(((NetBaseActivity) this).TAG, 1, "", e27);
                        return;
                    }
                }
                return;
            }
            if (str.equals(Cgi.URL_WALLET_GATE)) {
                WalletGateData.getInstance().setData(this.mUin, jSONObject, System.currentTimeMillis());
                this.mTimestamp = Long.parseLong(jSONObject.optString("time_stamp")) - (System.currentTimeMillis() / 1000);
                this.mBargainorName = jSONObject.optString("bargainor_true_name");
                this.mGoodsName = jSONObject.optString("desc");
                this.authen_channel_state = jSONObject.optInt("authen_channel_state");
                String optString5 = jSONObject.optString("creditcard_type");
                if (optString5 != null && !"".equals(optString5)) {
                    onCardTypeChange(optString5);
                }
                this.mCardID = jSONObject.optString("creditcard_id");
                this.mTrueName = jSONObject.optString("purchaser_true_name");
                this.mUserAttr = jSONObject.optInt("user_attr");
                if (!TextUtils.isEmpty(this.prefillUserInfo) && this.prefillUserInfo.equals("0") && this.mUserAttr == 2) {
                    this.mUserAttr = 1;
                    setCreIdTypeLayoutDisabled();
                }
                if (this.mForgetPassFlag) {
                    int i26 = this.mUserAttr;
                    if (i26 == 0 || i26 == 3) {
                        QUIProxy.createCustomDialog(getContext(), 230, null, "\u672a\u6ce8\u518c\u8d22\u4ed8\u901a", getString(R.string.e5j), null, null, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.BindBankActivity.34
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i27) {
                                BindBankActivity.this.finish();
                            }
                        });
                        return;
                    }
                    if (i26 == 2) {
                        this.mBinUserLayout.setVisibility(0);
                        this.mBinTextUser.setText(this.mTrueName);
                        this.mBinTextUser.setFocusable(false);
                        this.mBinTextUser.setEnabled(false);
                    } else {
                        this.mBinUserLayout.setVisibility(8);
                        this.mBinTextUser.setFocusable(true);
                        this.mBinTextUser.setEnabled(true);
                    }
                } else {
                    if (!TextUtils.isEmpty(this.prefillUserInfo) && this.prefillUserInfo.equals("0")) {
                        this.mNameEdit.setText("");
                        this.mCardIdEdit.setText("");
                        this.mCardOtherId.setText("");
                        r36 = 0;
                    } else {
                        this.mBinTextUser.setText(this.mTrueName);
                        setCreIdTypeText();
                        if (this.mCardType.equals("1")) {
                            setTextAndUnEnable(this.mCardIdEdit, this.mCardID);
                            r36 = 0;
                            this.mCardIdEdit.setVisibility(0);
                            this.mCardOtherId.setVisibility(8);
                        } else {
                            r36 = 0;
                            setTextAndUnEnable(this.mCardOtherId, this.mCardID);
                            this.mCardOtherId.setVisibility(0);
                            this.mCardIdEdit.setVisibility(8);
                        }
                    }
                    if (this.mUserAttr == 2) {
                        this.mBinUserLayout.setVisibility(r36);
                        this.mBinTextUser.setText(this.mTrueName);
                        this.mBinTextUser.setFocusable((boolean) r36);
                        this.mBinTextUser.setEnabled(r36);
                        this.mCardTypeTxt.setFocusable((boolean) r36);
                        this.mCardTypeTxt.setEnabled(r36);
                    } else {
                        this.mBinTextUser.setFocusable(true);
                        this.mBinTextUser.setEnabled(true);
                        this.mCardTypeTxt.setFocusable(true);
                        this.mCardTypeTxt.setEnabled(true);
                        ArrayList<JSONObject> arrayList3 = this.mBankList;
                        if (arrayList3 != null && arrayList3.size() > 0) {
                            setCreIdTypeLayoutDisabled();
                        }
                    }
                }
                this.mCacheVer = jSONObject.optString("interf_cache_ver");
                this.mUserCertType = jSONObject.optInt("cert_user");
                String optString6 = jSONObject.optString("domain_name");
                if (!TextUtils.isEmpty(optString6)) {
                    setServerAddr(optString6);
                }
                checkBankSupportConfig();
                sendWalBankQueryRequest();
                initIdVerifyGuideTips(this.mRootView);
                return;
            }
            if (str.equals(Cgi.URI_NONE_CFT_USER_AUTHEN)) {
                this.mYzmSubTitle.setVisibility(0);
                this.mRegisterPreObj = Utils.jsonToMap(jSONObject.toString());
                this.mBindBankFaceBean = BindBankFaceBean.parseFromUserAuthenRsp(jSONObject);
                return;
            }
            if (str.equals(Cgi.URI_NONE_CFT_USER_SMSCODE_VALIDATE)) {
                if (this.mForgetPassFlag) {
                    Intent intent3 = new Intent();
                    intent3.putExtra("data", this.mRegisterPreObj);
                    intent3.putExtra("bink_data", this.mRegisterRequestYzmParamsObj);
                    intent3.putExtra("yzm", this.mYzmEdit.getText().toString());
                    launchFragmentForResult(intent3, ResetPassActivity.class, 100);
                    return;
                }
                BindBankFaceBean bindBankFaceBean = this.mBindBankFaceBean;
                if (bindBankFaceBean != null && bindBankFaceBean.getNeedFace() == 1) {
                    QwLog.i("need verify face");
                    gotoFaceVerify();
                    return;
                } else {
                    QwLog.i("not need verify face");
                    gotoActivateTenpayAccount();
                    return;
                }
            }
            if (str.equals(Cgi.URI_CFT_USER_AUTHEN)) {
                this.mBindCardPreObj = jSONObject;
                this.mYzmSubTitle.setVisibility(0);
                this.mIsNeedVerifyPasswd = "1".equals(jSONObject.optString("pwd_verify"));
                return;
            }
            if (str.equals(Cgi.URI_CFT_USER_BIND)) {
                QwLog.i("qwallet_itg_verify finish, data=" + jSONObject);
                TenUtils.broadCastIdVerified();
                setCodePayRefresh();
                if (this.mIsFromWithdraw) {
                    if (this.mIsNeedVerifyPasswd) {
                        com.tencent.mobileqq.qwallet.c.c("extra.cashbind.ok", 114);
                    } else {
                        com.tencent.mobileqq.qwallet.c.c("extra.cashbind.ok", 113);
                    }
                    Intent intent4 = new Intent();
                    intent4.putExtra(WithdrawActivity.WITHDRAW_COUNT, this.mWithdrawCount);
                    intent4.putExtra("pass_flag", this.mPassFlag);
                    intent4.putExtra("bing_withdraw_flag", true);
                    intent4.putExtra("bind_new_card", true);
                    setResult(-1, intent4);
                    launchFragment(intent4, WithdrawActivity.class);
                    finish();
                    return;
                }
                if (this.mIsShiMing) {
                    com.tencent.mobileqq.qwallet.c.c("extra.registerbind.ok", 19);
                    setResult(-1);
                    WalletGateData.getInstance().clear();
                    this.mKeyBoard.setVisibility(8);
                    showOkTips(getString(R.string.eef), new DialogInterface.OnDismissListener() { // from class: com.tenpay.sdk.activity.BindBankActivity.35
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            BindBankActivity.this.finish();
                        }
                    });
                }
                Bundle retCodeAndGetBundle = setRetCodeAndGetBundle(0);
                String charSequence = this.mBinInputSelBankName.getText().toString();
                if (charSequence.length() > 3) {
                    str2 = charSequence.substring(0, charSequence.length() - 3);
                    str3 = charSequence.substring(charSequence.length() - 3);
                } else {
                    str2 = "";
                    str3 = str2;
                }
                JSONObject jSONObject5 = new JSONObject();
                try {
                    jSONObject5.put("name", str2);
                    jSONObject5.put("type", str3);
                    String data = this.mBinNo.getData();
                    jSONObject5.put(TextNode.MODE_TAIL, data.substring(data.length() - 4, data.length()));
                } catch (JSONException unused) {
                }
                if (this.mIsNeedVerifyPasswd) {
                    com.tencent.mobileqq.qwallet.c.c("extra.pwdbind.ok", 101);
                } else {
                    com.tencent.mobileqq.qwallet.c.c("extra.nopwdbind.ok", 100);
                }
                String optString7 = jSONObject.optString("bind_serial");
                if (optString7 != null && !"".equals(optString7)) {
                    JSONObject jSONObject6 = new JSONObject();
                    try {
                        jSONObject6.put("bind_serial", jSONObject.optString("bind_serial"));
                    } catch (Exception unused2) {
                    }
                    retCodeAndGetBundle.putString("retdata", jSONObject6.toString());
                }
                retCodeAndGetBundle.putString("retmsg", jSONObject5.toString());
                if (this.mForgetPassFlag) {
                    finish();
                } else {
                    this.mKeyBoard.setVisibility(8);
                    IdVerifyHintModule.startCommonSuccessHint(this, "\u6dfb\u52a0\u6210\u529f", null, "\u5b8c\u6210", Boolean.FALSE);
                    Intent intent5 = new Intent();
                    intent5.putExtra("bind_serial", optString7);
                    setResult(-1, intent5);
                    finish();
                    if (this.mIsFromFingerPaySetting) {
                        if (134 == getProcessType()) {
                            com.tencent.mobileqq.qwallet.c.c("extra.registerbind.ok", 134);
                        } else if (133 == getProcessType()) {
                            if (this.mIsNeedVerifyPasswd) {
                                com.tencent.mobileqq.qwallet.c.c("extra.pwdbind.ok", 133);
                            } else {
                                com.tencent.mobileqq.qwallet.c.c("extra.nopwdbind.ok", 133);
                            }
                        }
                    }
                }
                WalletGateData.getInstance().clear();
                MarketServiceUtils.sendMarketServiceSwitch();
                return;
            }
            if (str.equals(Cgi.URI_QWallet_REQUEST_DEPOSIT)) {
                this.mYzmSubTitle.setVisibility(0);
                int i27 = this.mUserAttr;
                if (i27 != 0 && i27 != 3) {
                    this.mCFTUserDepositObj = jSONObject;
                } else {
                    this.mNewUserDepositObj = jSONObject;
                }
                if (jSONObject.optString("send_flag").endsWith("0") && jSONObject.optString("end_flag").endsWith("1")) {
                    gotoDepositSuccess(jSONObject);
                    return;
                } else {
                    this.mIsNeedVerifyPasswd = "1".equals(jSONObject.optString("pwd_verify"));
                    return;
                }
            }
            if (str.equals(Cgi.URI_QWallet_VERIFY_DEPOSIT)) {
                this.mNewUserDepositObj = jSONObject;
                setCodePayRefresh();
                if ("1".equals(jSONObject.optString("end_flag"))) {
                    setSuccessPayType();
                    gotoDepositSuccess(jSONObject);
                    return;
                } else {
                    setSuccessPayType();
                    gotoActivateTenpayAccountDeposit();
                    return;
                }
            }
            if (str.equals(Cgi.URI_VALIDATE_PAY_PASS)) {
                showView(1);
            }
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (TextUtils.isEmpty(this.mCardType)) {
            this.mCardType = "1";
        }
        bindViewId(view);
        this.mRootView = view;
        view.setAlpha(0.0f);
    }

    protected void registerBindYzMsg() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("bank_type", this.mBinBank.optString("code"));
        hashMap.put("verify_code", this.mYzmEdit.getText().toString());
        if (!TextUtils.isEmpty(this.mPhoneNum)) {
            hashMap.put(DeviceType.DeviceCategory.MOBILE, this.mPhoneNum);
        }
        hashMap.put("auth_params", this.mRegisterPreObj.get("auth_params"));
        hashMap.put("come_from", this.mComeFrom + "");
        hashMap.put(com.tencent.mobileqq.msf.core.c0.j.T0, this.mAppInfo);
        if (this.mForgetPassFlag) {
            hashMap.put("reset_pwd_flag", "1");
        } else {
            hashMap.put("reset_pwd_flag", "0");
        }
        this.mRegisterExcuteYzmObj = hashMap;
        if (this.mFrom == ActivateTenpayAccount.EnumFrom.BIND_BANK.ordinal() || this.mFrom == ActivateTenpayAccount.EnumFrom.BIND_BANK_IN_PAY.ordinal() || this.mForgetPassFlag) {
            httpRequest(Cgi.URI_NONE_CFT_USER_SMSCODE_VALIDATE, hashMap);
        }
    }

    protected void registerGetYzm() {
        QwLog.i("---\u65b0\u7528\u6237\u7eaf\u7ed1\u5361\uff0c\u8bf7\u6c42\u9a8c\u8bc1\u7801---");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("bank_type", this.mBinBank.optString("code"));
        hashMap.put("true_name", this.mNameEdit.getText().toString());
        hashMap.put("creditcard_type", this.mCardType);
        personInfoEnc(hashMap);
        if (!TextUtils.isEmpty(this.mPhoneNum)) {
            hashMap.put(DeviceType.DeviceCategory.MOBILE, this.mPhoneNum);
        }
        hashMap.put("valid_thru", getValidTime());
        hashMap.put("cvc", this.mBinInputBankCvv.getText().toString());
        hashMap.put("come_from", this.mComeFrom + "");
        hashMap.put(com.tencent.mobileqq.msf.core.c0.j.T0, this.mAppInfo);
        if (this.mForgetPassFlag) {
            hashMap.put("reset_pwd_flag", "1");
            hashMap.put("qq_guid", com.tencent.mobileqq.base.b.d());
            hashMap.put("qq_appid", com.tencent.mobileqq.base.b.b());
            hashMap.put("qq_appname", "com.tencent.mobileqq");
        } else {
            hashMap.put("reset_pwd_flag", "0");
        }
        if (this.sendSmsNum > 1) {
            this.sendSmsNum = 0;
            hashMap.put("is_reentry", "1");
        } else {
            hashMap.put("is_reentry", "0");
        }
        hashMap.put("user_info_extend", getUserInfoExtend().toString());
        this.mRegisterRequestYzmParamsObj = hashMap;
        httpRequest(Cgi.URI_NONE_CFT_USER_AUTHEN, hashMap);
    }

    protected void setSuccessPayType() {
        String charSequence = this.mBinInputSelBankName.getText().toString();
        String data = this.mBinNo.getData();
        this.mPayType = charSequence + "(" + data.subSequence(data.length() - 4, data.length()).toString() + ")";
    }

    public void showSelectBankDialog() {
        if (this.mBankData == null) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("bank_data", this.mBankData.toString());
        intent.putExtra("process_flag", getProcessType());
        intent.putExtra("forget_pass", this.mForgetPassFlag);
        JSONObject jSONObject = this.mBinBank;
        if (jSONObject != null) {
            intent.putExtra("bank_name", jSONObject.optString("sname"));
            intent.putExtra("index", !NetParams.DEBIT_UNBIND.equals(this.mBinBank.optString("type")) ? 1 : 0);
        }
        launchFragmentForResult(intent, TenpayPluginSelectBankActivity.class, 10);
    }

    protected void showView(int i3) {
        this.mPageIndex = i3;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            this.mCancelBtn.setVisibility(8);
                            this.mBackBtn.setVisibility(0);
                            this.mIdVerifyLayout.setVisibility(8);
                            this.mBinInputScroll.setVisibility(8);
                            this.mPersonalInfoLayout.setVisibility(8);
                            this.mYzmLayout.setVisibility(8);
                            this.mVerifyPasswordLayout.setVisibility(0);
                            showPasswordEdit();
                        }
                    } else {
                        if (this.mIsMidas) {
                            this.traceName = "tenpay.choosemsg.";
                        } else {
                            this.traceName = "bigpay.sms.";
                        }
                        closeTime();
                        this.mCancelBtn.setVisibility(8);
                        this.mBackBtn.setVisibility(0);
                        this.mIdVerifyLayout.setVisibility(8);
                        this.mBinInputScroll.setVisibility(8);
                        this.mPersonalInfoLayout.setVisibility(8);
                        this.mYzmLayout.setVisibility(0);
                        this.mVerifyPasswordLayout.setVisibility(8);
                        this.mKeyBoard.setVisibility(0);
                        String obj = this.mBinInputPhone.getText().toString();
                        if (isMobileNumber(obj)) {
                            this.mYzmPhoneNum.setText(obj);
                            this.mYzmPhoneNum.setFocusable(false);
                            this.mYzmPhoneNum.setEnabled(false);
                            this.mYzmPhoneNum.setFocusableInTouchMode(false);
                            this.mYzmPhoneNum.setTextColor(getResources().getColor(R.color.f157691ww));
                            this.mYzmEdit.requestFocus();
                            this.mKeyBoard.setInputEditText(this.mYzmEdit);
                        } else {
                            this.mYzmPhoneNum.requestFocus();
                            this.mKeyBoard.setInputEditText(this.mYzmPhoneNum);
                        }
                        this.mYzmGetSMSBtn.setEnabled(isMobileNumber(this.mYzmPhoneNum.getText().toString()));
                    }
                } else {
                    this.mCancelBtn.setVisibility(8);
                    this.mBackBtn.setVisibility(0);
                    this.mIdVerifyLayout.setVisibility(8);
                    this.mBinInputScroll.setVisibility(8);
                    this.mPersonalInfoLayout.setVisibility(0);
                    this.mYzmLayout.setVisibility(8);
                    this.mVerifyPasswordLayout.setVisibility(8);
                }
            } else {
                if (this.mIsMidas) {
                    this.traceName = "tenpay.info.";
                } else {
                    this.traceName = "bind.info.";
                }
                this.mBackBtn.setVisibility(0);
                this.mIdVerifyLayout.setVisibility(8);
                this.mBinInputScroll.setVisibility(0);
                this.mYzmLayout.setVisibility(8);
                this.mPersonalInfoLayout.setVisibility(8);
                this.mVerifyPasswordLayout.setVisibility(8);
                this.mBinNo.requestFocus();
                this.mKeyBoard.setVisibility(0);
                this.mKeyBoard.setInputEditText(this.mBinNo);
            }
        } else {
            this.mIdVerifyLayout.setVisibility(0);
            this.mBinInputScroll.setVisibility(8);
            this.mYzmLayout.setVisibility(8);
            this.mPersonalInfoLayout.setVisibility(8);
            this.mVerifyPasswordLayout.setVisibility(8);
            if (TextUtils.isEmpty(this.mIdVerifyUserNameEdit.getText())) {
                this.mIdVerifyUserNameEdit.requestFocus();
            } else {
                this.mIdVerifyCardIdEdit.requestFocus();
            }
        }
        addTraceData("show");
    }

    public void updateProfession(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mJobName = str;
            this.mJobTxt.setText(str);
            this.mPersonInfoConfirm.setEnabled(validatePersonalInfo());
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    protected boolean validateIdVerify() {
        if (TextUtils.isEmpty(this.mIdVerifyUserNameEdit.getText().toString())) {
            return false;
        }
        if (TextUtils.isEmpty(this.mIdVerifyCardIdEdit.getText().toString()) && TextUtils.isEmpty(this.mIdVerifyOtherCardIdEdit.getText().toString())) {
            return false;
        }
        return true;
    }

    protected boolean validatePageOne() {
        String data = this.mBinNo.getData();
        if (data.length() < 13) {
            QQToast.makeText(getContext(), 1, getString(R.string.e1e), 0).show();
            this.mBinNo.onError();
            this.mBinNo.requestFocus();
            return false;
        }
        if (this.mIsWithdrawCredit) {
            QQToast.makeText(getContext(), R.string.e9n, 0).show();
            return false;
        }
        if (this.mBinLen > 0 && data.length() < this.mBinLen) {
            QQToast.makeText(getContext(), 1, getString(R.string.e1e), 0).show();
            this.mBinNo.onError();
            this.mBinNo.requestFocus();
            return false;
        }
        if (this.mBinBank == null) {
            if (this.mIsFromDeposit && !this.mForgetPassFlag) {
                QQToast.makeText(getContext(), R.string.e9m, 0).show();
            } else {
                QQToast.makeText(getContext(), R.string.e1f, 0).show();
            }
            return false;
        }
        if (this.mBinInputCredit.getVisibility() == 0) {
            if (this.mBinInputCreditThru.getVisibility() == 0) {
                if ("".equals(this.mBinInputCreditThru.getText().toString())) {
                    QQToast.makeText(getContext(), R.string.efk, 0).show();
                    this.mBinInputCreditThru.onError();
                    this.mBinInputCreditThru.requestFocus();
                    return false;
                }
                int isValid = this.mBinInputCreditThru.isValid(System.currentTimeMillis() + (this.mTimestamp * 1000));
                if (isValid == 3) {
                    QQToast.makeText(getContext(), 1, getString(R.string.efl), 0).show();
                    this.mBinInputCreditThru.onError();
                    this.mBinInputCreditThru.requestFocus();
                    return false;
                }
                if (isValid != 0) {
                    QQToast.makeText(getContext(), R.string.efk, 0).show();
                    this.mBinInputCreditThru.onError();
                    this.mBinInputCreditThru.requestFocus();
                    return false;
                }
            }
            if (this.mBinInputBankCvv.getVisibility() == 0 && this.mBinInputBankCvv.getText().toString().length() < 3) {
                QQToast.makeText(getContext(), R.string.f171331e50, 0).show();
                this.mBinInputBankCvv.onError();
                this.mBinInputBankCvv.requestFocus();
                return false;
            }
        }
        if (this.mBinPhoneLayout.getVisibility() == 0 && this.mBinInputPhone.getText().toString().length() < 11) {
            return false;
        }
        JSONObject jSONObject = this.mBinBank;
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("disabled");
            String optString = this.mBinBank.optString("disable_comment");
            if (optInt > 0) {
                if (!TextUtils.isEmpty(optString)) {
                    QQToast.makeText(getContext(), 0, optString, 0).show();
                } else {
                    String str = "\u8be5\u573a\u666f\u4e0b\u6b64\u94f6\u884c\u5361\u4e0d\u53ef\u7528";
                    if (optInt != 1) {
                        if (optInt == 2) {
                            str = "\u5e73\u53f0\u6682\u4e0d\u652f\u6301\u8be5\u94f6\u884c";
                        } else if (optInt == 3) {
                            str = "\u5546\u6237\u6682\u4e0d\u652f\u6301\u8be5\u94f6\u884c";
                        } else if (optInt == 5) {
                            str = "\u94f6\u884c\u7cfb\u7edf\u7ef4\u62a4\u4e2d";
                        }
                    }
                    QQToast.makeText(getContext(), 0, str, 0).show();
                }
                return false;
            }
        }
        QwLog.i("card type is " + this.mCardType);
        return true;
    }

    protected boolean validatePersonalInfo() {
        if (TextUtils.isEmpty(this.mNameEdit.getText().toString())) {
            return false;
        }
        if ((TextUtils.isEmpty(this.mCardIdEdit.getText().toString()) && TextUtils.isEmpty(this.mCardOtherId.getText().toString())) || TextUtils.isEmpty(this.cardStartDateTxt.getText()) || TextUtils.isEmpty(this.cardEndDateTxt.getText()) || TextUtils.isEmpty(this.mAddressTxt.getText()) || TextUtils.isEmpty(this.mJobTxt.getText().toString())) {
            return false;
        }
        return true;
    }

    protected boolean validateYzm() {
        if (TextUtils.isEmpty(this.mYzmEdit.getText().toString())) {
            QQToast.makeText(getContext(), R.string.efz, 0).show();
            return false;
        }
        return true;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
