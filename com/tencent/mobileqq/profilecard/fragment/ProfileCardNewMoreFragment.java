package com.tencent.mobileqq.profilecard.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.richframework.compat.f;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.profile.i;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolService;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.observer.ICardObserver;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.e;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequiresApi(api = 3)
/* loaded from: classes16.dex */
public class ProfileCardNewMoreFragment extends QIphoneTitleBarFragment implements View.OnClickListener, View.OnFocusChangeListener {
    static IPatchRedirector $redirector_ = null;
    private static final String ADDRESS_SEPARATOR = "-";
    private static final int BACK_ICON_COLOR_FILTER_BLACk;
    private static final int BACK_ICON_COLOR_FILTER_WHITE;
    private static final int DEFAULT_PROFESSION = -1;
    private static final int DIALOG_HEIGHT = 44;
    private static final String DTREORT_KEY_DISPLAY = "em_user_profile_editmore_set";
    private static final String DTREORT_KEY_FENZU = "em_user_profile_editmore_group";
    private static final String DTREORT_KEY_MODEL = "em_user_profile_editmore_medal";
    private static final String DTREPORT_PROFILE_CARD_MORE_FRAGMENT = "pg_user_profile_editmore";
    private static final long ERROR_DELAY_TIME = 20000;
    private static final int MAX_COMPANY_BYTES = 120;
    private static final int MAX_EMAIL_BYTES = 50;
    private static final int MAX_NICK_BYTES = 36;
    private static final String MODEL_WELL = "https://ti.qq.com/qqmedal2/index.html?_wv=1&_bid=2450&_nav_alpha=0&_nav_txtclr=ffffff&_nav_titleclr=ffffff&_nav_anim=true&_wwv=4";
    private static final int MSG_TOAST_ERROR = 1000;
    private static final String PARAM_ID = "param_id";
    private static final String PROFILE_JUMP_TO_EDIT = "profile_jump_to_edit";
    private static final int REQUEST_CODE_DEFAULT = 1000;
    private static final int REQUEST_CODE_GO_TO_SCHOOL_WEB = 1012;
    private static final int REQUEST_CODE_HOMETOWN = 1006;
    private static final int REQUEST_CODE_PERSONAL_NOTE = 1007;
    private static final int REQUEST_CODE_PROFESSION = 1004;
    private static final int REQUEST_FOR_MOVE_FRIEND_GROUP = 0;
    private static final String TAG = "ProfileCardNewMoreFragment";
    private static final int TYPE_FOR_HOMETOWN = 2;
    private static final int TYPE_FOR_LOCATION = 1;
    private static final int TYPE_FOR_NONE = 0;
    private static final int TYPE_GET_EDUCATION_LIST = 99;
    private static final int TYPE_REQ_CARD_LOCATION_DESC = 43;
    private static final String URL_SCHOOL_ADD = "https://ti.qq.com/hybrid-h5/school_relation/eduexperience?category=%d&_wv=67108994";
    private static final String URL_SCHOOL_CHOOSE = "https://ti.qq.com/hybrid-h5/school_relation/chooseschool?_wv=67108994";
    private static final String URL_SCHOOL_EDIT = "https://ti.qq.com/hybrid-h5/school_relation/eduexperience?category=%d&_wv=67108994&idx=%d";
    private static final Pattern VERIFY_EMAIL_PATTERN;
    private static final int[] dividerIds;
    private IProfileEditBusinessApi iProfileEditBusinessApi;
    private ActionSheet mActionSheet;
    private LinearLayout mAddedSchoolLayout;
    private AllInOne mAllInOne;
    private BaseQQAppInterface mApp;
    BounceScrollView mBounceScrollView;
    private final ICardObserver mCardObserver;
    private QQProgressDialog mCommitDialog;
    private boolean mCommitting;
    private EditText mCompanyEdit;
    private View mCompanyLayout;
    private MaxBytesTextWatcher mCompanyTextWatcher;
    private TextView mCompanyTitle;
    private LinearLayout mContentLayout;
    private Context mContext;
    private Object mCsmConfigListener;
    private boolean mDelayRemoveCardObserver;
    private TextView mDetailTitle;
    private int mDialogType;
    private View mDisplaySetLayout;
    private QQProgressDialog mDlgProgress;
    private FrameLayout mEduTitle;
    private View mEducationLayout;
    private EditText mEmailEdit;
    private View mEmailLayout;
    private MaxBytesTextWatcher mEmailTextWatcher;
    private TextView mEmailTitle;
    private TextView mFenzu;
    private View mFenzuLayout;
    private TextView mFenzuTitle;
    private String[] mHometownCodes;
    private boolean mHometownCodesModified;
    private View mHometownLayout;
    private TextView mHometownTitle;
    private TextView mHometownTxt;
    private boolean mIsDeleteOldSchool;
    private boolean mIsTroopMemberCard;
    private LinearLayout mLinearLayout1;
    private LinearLayout mLinearLayout2;
    private LinearLayout mLinearLayout3;
    private String[] mLocationCodes;
    private TextView mModel;
    private View mModelLayout;
    private int mModelNumber;
    private TextView mModelTitle;
    private final IProfileEditBusinessApi.OnCheckCSMListener mOnCheckCSMListener;
    private String mPersonalNote;
    private View mPersonalNoteLayout;
    private boolean mPersonalNoteModified;
    private TextView mPersonalNoteTxt;
    private TextView mPersonalTitle;
    private int mProfession;
    private TextView mProfessionIcon;
    private View mProfessionLayout;
    private boolean mProfessionModified;
    private TextView mProfessionTitle;
    private TextView mProfessionTxt;
    private Bundle mResultBundle;
    private ArrayList<i> mSchoolInfos;
    private String mStrGroup;
    private TextView mTitleText;
    private String preEmail;
    private final ProfileCardObserver profileCardObserver;

    /* loaded from: classes16.dex */
    public class MaxBytesTextWatcher implements TextWatcher {
        static IPatchRedirector $redirector_;
        private EditText mEditText;
        private int mInsertCount;
        private int mInsertPos;
        private int mMaxBytes;
        boolean mModifiedByUser;
        boolean mPendCallbackModification;

        public MaxBytesTextWatcher(int i3, EditText editText) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ProfileCardNewMoreFragment.this, Integer.valueOf(i3), editText);
                return;
            }
            this.mPendCallbackModification = false;
            this.mModifiedByUser = false;
            this.mMaxBytes = i3;
            this.mEditText = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) editable);
                return;
            }
            String obj = this.mEditText.getText().toString();
            if (obj.getBytes().length > this.mMaxBytes) {
                try {
                    String substring = obj.substring(0, this.mInsertPos);
                    String substring2 = obj.substring(this.mInsertPos + this.mInsertCount, obj.length());
                    int i3 = this.mInsertPos;
                    String substring3 = obj.substring(i3, this.mInsertCount + i3);
                    if (substring.getBytes().length + substring2.getBytes().length <= this.mMaxBytes) {
                        while (obj.getBytes().length > this.mMaxBytes && substring3.length() > 0) {
                            substring3 = substring3.substring(0, substring3.length() - 1);
                            obj = substring + substring3 + substring2;
                        }
                        this.mEditText.setText(obj);
                        this.mEditText.setSelection(substring.length() + substring3.length());
                    }
                } catch (Exception unused) {
                }
            }
            if (this.mPendCallbackModification) {
                this.mPendCallbackModification = false;
            } else {
                this.mModifiedByUser = true;
            }
            if (this.mEditText == ProfileCardNewMoreFragment.this.mCompanyEdit) {
                ProfileCardNewMoreFragment profileCardNewMoreFragment = ProfileCardNewMoreFragment.this;
                profileCardNewMoreFragment.updateItemContentDescription(profileCardNewMoreFragment.mCompanyLayout, ProfileCardNewMoreFragment.this.mCompanyEdit, ProfileCardNewMoreFragment.this.mContext.getString(R.string.f175442yk), obj);
            } else if (this.mEditText == ProfileCardNewMoreFragment.this.mEmailEdit) {
                ProfileCardNewMoreFragment profileCardNewMoreFragment2 = ProfileCardNewMoreFragment.this;
                profileCardNewMoreFragment2.updateItemContentDescription(profileCardNewMoreFragment2.mEmailLayout, ProfileCardNewMoreFragment.this.mEmailEdit, ProfileCardNewMoreFragment.this.mContext.getString(R.string.f175482yo), obj);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            } else {
                this.mInsertPos = i3;
                this.mInsertCount = i17;
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35384);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 27)) {
            redirector.redirect((short) 27);
            return;
        }
        VERIFY_EMAIL_PATTERN = Pattern.compile("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,3})$", 2);
        BACK_ICON_COLOR_FILTER_WHITE = Color.parseColor("#FFFFFF");
        BACK_ICON_COLOR_FILTER_BLACk = Color.parseColor("#000000");
        dividerIds = new int[]{R.id.f165049uq1, R.id.f165050uq2, R.id.f165051uq3, R.id.f165052uq4};
    }

    public ProfileCardNewMoreFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mDlgProgress = null;
        this.mDialogType = 0;
        this.mCommitDialog = null;
        this.mCommitting = false;
        this.mDelayRemoveCardObserver = false;
        this.mProfessionModified = false;
        this.mHometownCodesModified = false;
        this.mPersonalNoteModified = false;
        this.mIsTroopMemberCard = false;
        this.mIsDeleteOldSchool = false;
        this.mOnCheckCSMListener = new IProfileEditBusinessApi.OnCheckCSMListener() { // from class: com.tencent.mobileqq.profilecard.fragment.ProfileCardNewMoreFragment.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileCardNewMoreFragment.this);
                }
            }

            @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi.OnCheckCSMListener
            public void onCheckDone(boolean z16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    ProfileCardNewMoreFragment.this.dismissWaitingDialog();
                    if (z16) {
                        ProfileCardNewMoreFragment.this.iProfileEditBusinessApi.startLocationSelectActivity(ProfileCardNewMoreFragment.this.mApp, ProfileCardNewMoreFragment.this.mContext, ProfileCardNewMoreFragment.this.mLocationCodes, ProfileCardNewMoreFragment.this.mHometownCodes);
                        return;
                    } else {
                        QQToast.makeText(ProfileCardNewMoreFragment.this.getQBaseActivity(), R.string.zna, 0).show();
                        return;
                    }
                }
                iPatchRedirector2.redirect((short) 2, (Object) this, z16);
            }

            @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi.OnCheckCSMListener
            public void onUpdateResult(int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, i3);
                    return;
                }
                QBaseActivity qBaseActivity = ProfileCardNewMoreFragment.this.getQBaseActivity();
                if (i3 == -2) {
                    ProfileCardNewMoreFragment.this.showWaitingDialog(2, qBaseActivity.getString(R.string.znd));
                    ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable(qBaseActivity) { // from class: com.tencent.mobileqq.profilecard.fragment.ProfileCardNewMoreFragment.1.1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ Context val$context;

                        {
                            this.val$context = qBaseActivity;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) qBaseActivity);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                ProfileCardNewMoreFragment.this.dismissWaitingDialog();
                                QQToast.makeText(this.val$context, R.string.zna, 0).show(((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).getTitleBarHeight(this.val$context));
                            } else {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            }
                        }
                    }, ProfileCardNewMoreFragment.ERROR_DELAY_TIME);
                } else {
                    if (i3 != -1) {
                        if (i3 == 0) {
                            ProfileCardNewMoreFragment.this.showWaitingDialog(2, qBaseActivity.getString(R.string.znd));
                            return;
                        }
                        return;
                    }
                    QQToast.makeText(qBaseActivity, R.string.f171139ci4, 0).show(((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).getTitleBarHeight(qBaseActivity));
                }
            }
        };
        this.mCardObserver = new ICardObserver() { // from class: com.tencent.mobileqq.profilecard.fragment.ProfileCardNewMoreFragment.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileCardNewMoreFragment.this);
                }
            }

            private void onGetEducationList(boolean z16, Object obj, Object obj2) {
                if (z16 && (obj instanceof Long) && (obj2 instanceof ArrayList) && Utils.p(ProfileCardNewMoreFragment.this.mApp.getCurrentAccountUin(), String.valueOf(obj))) {
                    ProfileCardNewMoreFragment.this.mApp.runOnUiThread(new Runnable(obj2) { // from class: com.tencent.mobileqq.profilecard.fragment.ProfileCardNewMoreFragment.3.1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ Object val$schoolInfos;

                        {
                            this.val$schoolInfos = obj2;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this, obj2);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            ProfileCardNewMoreFragment.this.mSchoolInfos = (ArrayList) this.val$schoolInfos;
                            ProfileCardNewMoreFragment.this.updateEducation();
                        }
                    });
                }
            }

            private void onGetLocationDescription(boolean z16, String str, Card card) {
                if (z16 && card != null && Utils.p(ProfileCardNewMoreFragment.this.mApp.getCurrentAccountUin(), card.uin)) {
                    ProfileCardNewMoreFragment.this.refreshDetailInfo(card, true);
                }
            }

            @Override // com.tencent.mobileqq.app.BusinessObserver
            public void onUpdate(int i3, boolean z16, Object obj) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
                    return;
                }
                if (i3 == 99 && (obj instanceof Object[])) {
                    Object[] objArr = (Object[]) obj;
                    if (objArr.length >= 2) {
                        onGetEducationList(z16, objArr[0], objArr[1]);
                    }
                }
                if (i3 == 43 && (obj instanceof Card)) {
                    Card card = (Card) obj;
                    onGetLocationDescription(z16, card.uin, card);
                }
            }
        };
        this.profileCardObserver = new ProfileCardObserver() { // from class: com.tencent.mobileqq.profilecard.fragment.ProfileCardNewMoreFragment.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileCardNewMoreFragment.this);
                }
            }

            @Override // com.tencent.mobileqq.profilecard.observer.ProfileCardObserver
            protected void onGetProfileCard(boolean z16, Object obj) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), obj);
                    return;
                }
                if (z16 && (obj instanceof Card)) {
                    Card card = (Card) obj;
                    if (Utils.p(ProfileCardNewMoreFragment.this.mApp.getCurrentAccountUin(), card.uin)) {
                        ProfileCardNewMoreFragment.this.refreshDetailInfo(card, true);
                        ProfileCardNewMoreFragment.this.updateEducation();
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.profilecard.observer.ProfileCardObserver
            public void onGetProfileDetail(boolean z16, String str, Card card) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, this, Boolean.valueOf(z16), str, card);
                } else if (z16 && card != null && Utils.p(ProfileCardNewMoreFragment.this.mApp.getCurrentAccountUin(), card.uin)) {
                    ProfileCardNewMoreFragment.this.refreshDetailInfo(card, true);
                }
            }

            @Override // com.tencent.mobileqq.profilecard.observer.ProfileCardObserver
            protected void onSetProfileDetail(boolean z16, int i3, Card card) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, this, Boolean.valueOf(z16), Integer.valueOf(i3), card);
                    return;
                }
                if (ProfileCardNewMoreFragment.this.mIsDeleteOldSchool) {
                    ProfileCardNewMoreFragment.this.onDeleteOldSchoolResult(z16, card);
                    return;
                }
                if (ProfileCardNewMoreFragment.this.mCommitting && ProfileCardNewMoreFragment.this.mCommitDialog != null) {
                    ProfileCardNewMoreFragment.this.mCommitting = false;
                    ProfileCardNewMoreFragment.this.mCommitDialog.dismiss();
                    ProfileCardNewMoreFragment.this.finish();
                    return;
                }
                ProfileCardNewMoreFragment.this.refreshDetailInfo(card, true);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkEduFirstGuide(Card card) {
        if (card != null && !this.mIsTroopMemberCard && ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).isNeedGuideForNewSchoolData(card, this.mApp)) {
            DialogUtil.createCustomDialog(this.mContext, HardCodeUtil.qqStr(R.string.f212655o4), HardCodeUtil.qqStr(R.string.f212675o6), (String) null, R.string.f175362yc, R.string.f175372yd, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.fragment.ProfileCardNewMoreFragment.5
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileCardNewMoreFragment.this);
                    }
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                        return;
                    }
                    if (NetworkUtil.isNetSupport(ProfileCardNewMoreFragment.this.mContext)) {
                        ProfileCardNewMoreFragment.this.clearOldSchoolData();
                    }
                    ProfileCardNewMoreFragment.this.gotoSchoolWeb(ProfileCardNewMoreFragment.URL_SCHOOL_CHOOSE);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.fragment.ProfileCardNewMoreFragment.6
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileCardNewMoreFragment.this);
                    }
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        ProfileCardNewMoreFragment.this.clearOldSchoolData();
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                    }
                }
            }).show();
            ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).setFirstShowGuideForNewSchoolData(card, this.mApp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOldSchoolData() {
        Bundle bundle = new Bundle();
        bundle.putString(IProfileProtocolConst.KEY_COLLEGE, "");
        if (setDetailUserInfo(bundle, R.string.f170712ls, 0)) {
            this.mIsDeleteOldSchool = true;
        }
    }

    private void clickEduLayout(View view) {
        if (view.getTag() instanceof i) {
            i iVar = (i) view.getTag();
            gotoSchoolWeb(String.format(URL_SCHOOL_EDIT, Integer.valueOf(iVar.f260183b), Integer.valueOf(iVar.f260182a)));
        } else if (view.getTag() instanceof Card) {
            gotoSchoolWeb(URL_SCHOOL_CHOOSE);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x001c, code lost:
    
        if (r2 == r6.length) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean compareStringArray(String[] strArr, String[] strArr2) {
        boolean z16 = true;
        if (strArr != strArr2) {
            try {
                if (strArr.length == strArr2.length) {
                    int i3 = 0;
                    while (i3 < strArr.length && strArr[i3].equals(strArr2[i3])) {
                        i3++;
                    }
                }
                z16 = false;
            } catch (Exception unused) {
                return false;
            }
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissWaitingDialog() {
        QQProgressDialog qQProgressDialog = this.mDlgProgress;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.mDlgProgress.dismiss();
        }
    }

    private void dtReportElement(Object obj, String str) {
        if (obj == null) {
            return;
        }
        VideoReport.setElementId(obj, str);
        VideoReport.setElementClickPolicy(obj, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(obj, ExposurePolicy.REPORT_NONE);
        VideoReport.reportEvent("imp", obj, null);
    }

    private <T extends View> T findViewById(@IdRes int i3) {
        return (T) ((QIphoneTitleBarFragment) this).mContentView.findViewById(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<i> getEducationListFromCache() {
        return ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).getEducationList(this.mApp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoSchoolAddWeb(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    reportSchoolClick(3);
                    gotoSchoolWeb(String.format(URL_SCHOOL_ADD, 1));
                    return;
                }
                return;
            }
            reportSchoolClick(2);
            gotoSchoolWeb(String.format(URL_SCHOOL_ADD, 2));
            return;
        }
        reportSchoolClick(1);
        gotoSchoolWeb(String.format(URL_SCHOOL_ADD, 3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoSchoolWeb(String str) {
        Intent intent = new Intent(this.mContext, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", str);
        intent.putExtra("hide_more_button", true);
        gotoSchoolWebActivity(intent);
    }

    private void handleHomeTownClick() {
        Object initSearchManager = this.iProfileEditBusinessApi.initSearchManager(this.mApp, this.mContext, this.mOnCheckCSMListener);
        if (initSearchManager != null) {
            this.mCsmConfigListener = initSearchManager;
        }
    }

    private void handleInterestLayoutClick() {
        ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).handleInterestLayoutClick(this.mContext);
    }

    private void initData() {
        this.iProfileEditBusinessApi = (IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class);
        this.mApp.addObserver(this.mCardObserver);
        this.mApp.addObserver(this.profileCardObserver);
        Intent intent = getActivity().getIntent();
        this.mAllInOne = new AllInOne(this.mApp.getCurrentUin(), 0);
        AllInOne allInOne = (AllInOne) intent.getParcelableExtra(IProfileCardConst.KEY_ALL_IN_ONE);
        this.mAllInOne = allInOne;
        if (allInOne == null) {
            this.mAllInOne = new AllInOne(this.mApp.getCurrentUin(), 0);
        }
        new IntentFilter().addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.fragment.ProfileCardNewMoreFragment.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileCardNewMoreFragment.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    ProfileCardNewMoreFragment.this.mApp.runOnUiThread(new Runnable(ProfileCardNewMoreFragment.this.getEducationListFromCache(), ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).getCard(ProfileCardNewMoreFragment.this.mApp)) { // from class: com.tencent.mobileqq.profilecard.fragment.ProfileCardNewMoreFragment.2.1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ Card val$card;
                        final /* synthetic */ ArrayList val$schoolInfos;

                        {
                            this.val$schoolInfos = r8;
                            this.val$card = r9;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, AnonymousClass2.this, r8, r9);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            ArrayList arrayList = this.val$schoolInfos;
                            if (arrayList != null) {
                                ProfileCardNewMoreFragment.this.mSchoolInfos = arrayList;
                                ProfileCardNewMoreFragment.this.updateEducation();
                            }
                            ProfileCardNewMoreFragment.this.refreshDetailInfo(this.val$card, false);
                            ProfileCardNewMoreFragment.this.checkEduFirstGuide(this.val$card);
                        }
                    });
                    ((IProfileProtocolService) ProfileCardNewMoreFragment.this.mApp.getRuntimeService(IProfileProtocolService.class, "all")).getProfileDetailForEdit();
                    ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).requestEducationList(ProfileCardNewMoreFragment.this.mApp);
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }, 5, null, true);
    }

    private void initDtReport() {
        if (this.titleRoot == null) {
            return;
        }
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(this.titleRoot, DTREPORT_PROFILE_CARD_MORE_FRAGMENT);
        VideoReport.setPageContentId(this.titleRoot, ProfileCardNewMoreFragment.class.getName());
        dtReportElement(this.mFenzuLayout, DTREORT_KEY_FENZU);
        dtReportElement(this.mDisplaySetLayout, DTREORT_KEY_DISPLAY);
        dtReportElement(this.mModelLayout, DTREORT_KEY_MODEL);
    }

    private void notifyUser(int i3, int i16) {
        new QQToastNotifier(this.mContext).notifyUser(i3, 44, 0, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDeleteOldSchoolResult(boolean z16, Card card) {
        this.mIsDeleteOldSchool = false;
        if (z16) {
            updateEducation();
        }
    }

    private void showSchoolAddActionSheet() {
        ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this.mContext, null);
        this.mActionSheet = actionSheet;
        actionSheet.addButton("\u6dfb\u52a0\u5927\u5b66", 0);
        this.mActionSheet.addButton("\u6dfb\u52a0\u4e2d\u5b66", 0);
        this.mActionSheet.addButton("\u6dfb\u52a0\u5c0f\u5b66", 0);
        this.mActionSheet.addCancelButton(R.string.cancel);
        this.mActionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.profilecard.fragment.ProfileCardNewMoreFragment.7
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileCardNewMoreFragment.this);
                }
            }

            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public void onClick(View view, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                    return;
                }
                if (ProfileCardNewMoreFragment.this.mActionSheet != null) {
                    ProfileCardNewMoreFragment.this.mActionSheet.dismiss();
                }
                ProfileCardNewMoreFragment.this.gotoSchoolAddWeb(i3);
            }
        });
        this.mActionSheet.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showWaitingDialog(int i3, String str) {
        this.mDialogType = i3;
        if (this.mDlgProgress == null) {
            this.mDlgProgress = new QQProgressDialog(this.mContext, 44);
        }
        this.mDlgProgress.setMessage(str);
        this.mDlgProgress.show();
    }

    private void updateCompany(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.mCompanyEdit.setText(str);
        updateItemContentDescription(this.mCompanyLayout, this.mCompanyEdit, this.mContext.getString(R.string.f175442yk), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateEducation() {
        LinearLayout linearLayout;
        if (this.mEducationLayout.getVisibility() == 0 && (linearLayout = this.mAddedSchoolLayout) != null) {
            linearLayout.removeAllViews();
            updateEducationListLayout();
            updateSchoolLayout();
        }
    }

    private void updateEmail(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.mEmailEdit.setText(str);
        updateItemContentDescription(this.mEmailLayout, this.mEmailEdit, this.mContext.getString(R.string.f175482yo), str);
    }

    private void updateHometown(String str) {
        boolean z16;
        QLog.d(TAG, 2, "startLocationSelectActivity | homeTownDesc = " + str);
        if (!TextUtils.isEmpty(str) && !str.equals(((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).getNoLimitText())) {
            z16 = false;
        } else {
            str = this.mContext.getString(R.string.f175512yr);
            z16 = true;
        }
        updateTextView(this.mHometownTxt, str, z16);
        View view = this.mHometownLayout;
        TextView textView = this.mHometownTxt;
        String string = this.mContext.getString(R.string.f175522ys);
        if (z16) {
            str = "";
        }
        updateItemContentDescription(view, textView, string, str);
    }

    private void updateModel(String str) {
        this.mModelNumber = ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).updateModel(this.mApp);
        this.mModel.setText(this.mModelNumber + "\u679a");
        updateItemContentDescription(this.mModelLayout, this.mModel, this.mContext.getString(R.string.f175722zb), this.mModelNumber + "\u679a");
    }

    private void updatePersonalNote(String str) {
        boolean z16;
        String str2;
        this.mPersonalNote = str;
        if (TextUtils.isEmpty(str)) {
            str2 = this.mContext.getString(R.string.f175752ze);
            z16 = true;
        } else {
            z16 = false;
            str2 = str;
        }
        updateTextView(this.mPersonalNoteTxt, str2, TextUtils.isEmpty(str));
        View view = this.mPersonalNoteLayout;
        TextView textView = this.mPersonalNoteTxt;
        String string = this.mContext.getString(R.string.f175762zf);
        if (z16) {
            str2 = "";
        }
        updateItemContentDescription(view, textView, string, str2);
    }

    private void updateProfession(int i3) {
        if (((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).isJobIdInValid(i3)) {
            this.mProfession = i3;
        } else {
            this.mProfession = -1;
        }
        String job = ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).getJob(i3);
        if (TextUtils.isEmpty(job)) {
            this.mProfession = -1;
            job = this.mContext.getString(R.string.f1761630i);
        }
        boolean z16 = true;
        if (i3 < ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).getNearbyProfileUtilTagLength() - 1 && i3 > 0) {
            Drawable nightModeFilterForDrawable = this.iProfileEditBusinessApi.setNightModeFilterForDrawable(this.mApp, i3);
            this.mProfessionIcon.setVisibility(0);
            this.mProfessionIcon.setBackgroundDrawable(nightModeFilterForDrawable);
            this.mProfessionIcon.setText(((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).getSelectTag(i3));
        } else {
            this.mProfessionIcon.setVisibility(8);
        }
        TextView textView = this.mProfessionTxt;
        if (this.mProfession != -1) {
            z16 = false;
        }
        updateTextView(textView, job, z16);
        View view = this.mProfessionLayout;
        View view2 = this.mProfessionTxt;
        String string = this.mContext.getString(R.string.f1761730j);
        if (i3 == -1) {
            job = "";
        }
        updateItemContentDescription(view, view2, string, job);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, layoutInflater, viewGroup, bundle);
            return;
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        initViews();
        initDtReport();
    }

    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        getQBaseActivity().setResult(-1, new Intent());
        if (!getQBaseActivity().isFinishing()) {
            getQBaseActivity().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return R.layout.f168842h11;
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    public void gotoSchoolWebActivity(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) intent);
        } else {
            startActivityForResult(intent, 1012);
        }
    }

    public void handleBackClick() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        if (isUserInfoChanged()) {
            if (this.mCommitDialog == null) {
                QQProgressDialog qQProgressDialog = new QQProgressDialog(this.mContext, 44);
                this.mCommitDialog = qQProgressDialog;
                qQProgressDialog.setMessage(HardCodeUtil.qqStr(R.string.f212645o3));
            }
            if (this.mCommitting) {
                this.mCommitDialog.dismiss();
                this.mDelayRemoveCardObserver = true;
                finish();
                return;
            } else if (sendUserInfoChange()) {
                this.mCommitting = true;
                this.mCommitDialog.show();
                return;
            } else {
                finish();
                return;
            }
        }
        finish();
    }

    public void handleModelClick() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        Intent intent = new Intent(this.mContext, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", "https://ti.qq.com/qqmedal2/index.html?_wv=1&_bid=2450&_nav_alpha=0&_nav_txtclr=ffffff&_nav_titleclr=ffffff&_nav_anim=true&_wwv=4");
        this.mContext.startActivity(intent);
    }

    public void initViews() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        setTitle(this.mContext.getString(R.string.f168092ep));
        this.leftView.setVisibility(8);
        this.mLeftBackIcon.setVisibility(0);
        this.mBounceScrollView = (BounceScrollView) findViewById(R.id.m78);
        this.mContentLayout = (LinearLayout) findViewById(R.id.b9w);
        this.mEduTitle = (FrameLayout) findViewById(R.id.ur7);
        this.mLinearLayout1 = (LinearLayout) findViewById(R.id.xnn);
        this.mLinearLayout2 = (LinearLayout) findViewById(R.id.xno);
        this.mLinearLayout3 = (LinearLayout) findViewById(R.id.xnp);
        View findViewById = findViewById(R.id.fzu);
        this.mProfessionLayout = findViewById;
        findViewById.setOnClickListener(this);
        this.mProfessionIcon = (TextView) findViewById(R.id.fzt);
        this.mProfessionTxt = (TextView) findViewById(R.id.fzv);
        updateProfession(-1);
        View findViewById2 = findViewById(R.id.b6j);
        this.mCompanyLayout = findViewById2;
        findViewById2.setClickable(false);
        EditText editText = (EditText) findViewById(R.id.b6i);
        this.mCompanyEdit = editText;
        editText.setOnFocusChangeListener(this);
        MaxBytesTextWatcher maxBytesTextWatcher = new MaxBytesTextWatcher(120, this.mCompanyEdit);
        this.mCompanyTextWatcher = maxBytesTextWatcher;
        this.mCompanyEdit.addTextChangedListener(maxBytesTextWatcher);
        this.mCompanyTextWatcher.mPendCallbackModification = true;
        updateCompany(null);
        View findViewById3 = findViewById(R.id.d6w);
        this.mHometownLayout = findViewById3;
        findViewById3.setOnClickListener(this);
        this.mHometownTxt = (TextView) findViewById(R.id.d6x);
        updateHometown(null);
        View findViewById4 = findViewById(R.id.buf);
        this.mEmailLayout = findViewById4;
        findViewById4.setClickable(false);
        EditText editText2 = (EditText) findViewById(R.id.bue);
        this.mEmailEdit = editText2;
        editText2.setOnFocusChangeListener(this);
        MaxBytesTextWatcher maxBytesTextWatcher2 = new MaxBytesTextWatcher(50, this.mEmailEdit);
        this.mEmailTextWatcher = maxBytesTextWatcher2;
        this.mEmailEdit.addTextChangedListener(maxBytesTextWatcher2);
        this.mEmailTextWatcher.mPendCallbackModification = true;
        updateEmail(null);
        View findViewById5 = findViewById(R.id.f164997uj4);
        this.mDisplaySetLayout = findViewById5;
        findViewById5.setContentDescription(this.mContext.getString(R.string.f175462ym));
        this.mDisplaySetLayout.setOnClickListener(this);
        View findViewById6 = findViewById(R.id.zlp);
        this.mModelLayout = findViewById6;
        findViewById6.setOnClickListener(this);
        this.mModel = (TextView) findViewById(R.id.f166304zd4);
        updateModel(null);
        View findViewById7 = findViewById(R.id.zlo);
        this.mFenzuLayout = findViewById7;
        findViewById7.setOnClickListener(this);
        this.mFenzu = (TextView) findViewById(R.id.v4s);
        updateFenzu();
        View findViewById8 = findViewById(R.id.flw);
        this.mPersonalNoteLayout = findViewById8;
        findViewById8.setOnClickListener(this);
        this.mPersonalNoteTxt = (TextView) findViewById(R.id.flx);
        updatePersonalNote(null);
        this.mDetailTitle = (TextView) findViewById(R.id.bhl);
        this.mPersonalTitle = (TextView) findViewById(R.id.f242408l);
        this.mProfessionTitle = (TextView) findViewById(R.id.f27870he);
        this.mCompanyTitle = (TextView) findViewById(R.id.u2n);
        this.mEmailTitle = (TextView) findViewById(R.id.us5);
        this.mHometownTitle = (TextView) findViewById(R.id.xap);
        this.mModelTitle = (TextView) findViewById(R.id.f166303zd3);
        this.mFenzuTitle = (TextView) findViewById(R.id.v4r);
        this.mEducationLayout = findViewById(R.id.f165061bu2);
        this.mAddedSchoolLayout = (LinearLayout) findViewById(R.id.f164039i6);
        ((FrameLayout) findViewById(R.id.ihf)).setOnClickListener(this);
        ((FrameLayout) findViewById(R.id.ihj)).setOnClickListener(this);
        ((FrameLayout) findViewById(R.id.ihh)).setOnClickListener(this);
        ((FrameLayout) findViewById(R.id.ihd)).setOnClickListener(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
        } else {
            activity.getWindow().getDecorView().setBackgroundResource(R.drawable.skin_header_bar_bg);
        }
    }

    public boolean isUserInfoChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        if (!this.mCompanyTextWatcher.mModifiedByUser && !this.mEmailTextWatcher.mModifiedByUser && !this.mProfessionModified && !this.mHometownCodesModified && !this.mPersonalNoteModified) {
            return false;
        }
        return true;
    }

    public void moveToNewGroup() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        } else {
            ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).moveToNewGroup(this.mContext, this.mApp, this.mAllInOne);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        String stringExtra;
        String str;
        int intExtra;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (i3 == 1004) {
            if (intent != null && (intExtra = intent.getIntExtra("param_id", -1)) != this.mProfession) {
                this.mProfessionModified = true;
                updateProfession(intExtra);
                return;
            }
            return;
        }
        if (i3 == 1006) {
            if (intent != null) {
                String[] stringArrayExtra = intent.getStringArrayExtra(IProfileCardConst.PARAM_LOCATION_CODE);
                if (!compareStringArray(this.mHometownCodes, stringArrayExtra)) {
                    this.mHometownCodesModified = true;
                    this.mHometownCodes = stringArrayExtra;
                    try {
                        str = this.iProfileEditBusinessApi.parseCodeArrayToSimpleAdress(this.mApp, stringArrayExtra);
                    } catch (Exception unused) {
                        str = null;
                    }
                    if (TextUtils.isEmpty(str) || str.equals(IProfileCardConst.NAME_NO_LIMIT)) {
                        str = "";
                    }
                    updateHometown(str);
                    this.iProfileEditBusinessApi.destroyLocationSearchManager(this.mApp, getContext(), this.mCsmConfigListener);
                    return;
                }
                return;
            }
            return;
        }
        if (i3 == 1007) {
            if (intent != null) {
                String stringExtra2 = intent.getStringExtra("result");
                if (!stringExtra2.equals(this.mPersonalNote)) {
                    this.mPersonalNoteModified = true;
                    updatePersonalNote(stringExtra2);
                    return;
                }
                return;
            }
            return;
        }
        if (i3 == 0) {
            if (intent != null && (stringExtra = intent.getStringExtra("group_name")) != null) {
                String str2 = this.mStrGroup;
                if (str2 == null || !str2.equals(stringExtra)) {
                    this.mStrGroup = stringExtra;
                    this.mFenzu.setText(stringExtra);
                    updateItemContentDescription(this.mFenzuLayout, this.mFenzu, this.mContext.getString(R.string.f175742zd), this.mStrGroup);
                    return;
                }
                return;
            }
            return;
        }
        if (i3 == 1012) {
            ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).requestEducationList(this.mApp);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        handleBackClick();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.f165972dz1) {
                handleBackClick();
            } else if (id5 == R.id.fzu) {
                ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).startJobSelectActivity(this.mContext, this.mProfession);
            } else if (id5 == R.id.d6w) {
                handleHomeTownClick();
            } else if (id5 == R.id.flw) {
                ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).startEditPersonalNote(this.mContext, this.mPersonalNote);
            } else if (id5 != R.id.ihe && id5 != R.id.ihf) {
                if (id5 != R.id.ihi && id5 != R.id.ihj) {
                    if (id5 != R.id.ihg && id5 != R.id.ihh) {
                        if (id5 != R.id.ihc && id5 != R.id.ihd) {
                            if (id5 == R.id.f165060bu1) {
                                clickEduLayout(view);
                            } else if (id5 == R.id.f164997uj4) {
                                VideoReport.reportEvent("dt_clck", this.mDisplaySetLayout, null);
                                handleInterestLayoutClick();
                            } else if (id5 == R.id.zlp) {
                                VideoReport.reportEvent("dt_clck", this.mModelLayout, null);
                                handleModelClick();
                            } else if (id5 == R.id.zlo) {
                                VideoReport.reportEvent("dt_clck", this.mFenzuLayout, null);
                                moveToNewGroup();
                            }
                        } else {
                            showSchoolAddActionSheet();
                        }
                    } else {
                        reportSchoolClick(3);
                        gotoSchoolWeb(String.format(URL_SCHOOL_ADD, 1));
                    }
                } else {
                    reportSchoolClick(2);
                    gotoSchoolWeb(String.format(URL_SCHOOL_ADD, 2));
                }
            } else {
                reportSchoolClick(1);
                gotoSchoolWeb(String.format(URL_SCHOOL_ADD, 3));
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        this.mApp = (BaseQQAppInterface) getQBaseActivity().getAppRuntime();
        this.mContext = getQBaseActivity();
        initData();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onDestroy();
        this.iProfileEditBusinessApi.destroyLocationSearchManager(this.mApp, getContext(), this.mCsmConfigListener);
        if (!this.mDelayRemoveCardObserver) {
            this.mApp.removeObserver(this.mCardObserver);
            this.mApp.removeObserver(this.profileCardObserver);
        }
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z16) {
        EditText editText;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, view, Boolean.valueOf(z16));
            return;
        }
        if (!z16 && view == (editText = this.mEmailEdit) && this.mEmailTextWatcher.mModifiedByUser) {
            String obj = editText.getText().toString();
            Matcher matcher = VERIFY_EMAIL_PATTERN.matcher(obj);
            if (!TextUtils.isEmpty(obj) && !matcher.matches()) {
                QQToast.makeText(getActivity(), HardCodeUtil.qqStr(R.string.f212685o7), 0).show();
                this.mEmailEdit.setText(this.preEmail);
            }
        }
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    void professionToggleControl(int i3) {
        if (!((IProfileCardApi) QRoute.api(IProfileCardApi.class)).checkProfessionShow(i3)) {
            this.mProfessionLayout.setVisibility(8);
        }
    }

    public void refreshDetailInfo(Card card, boolean z16) {
        String str;
        String[] strArr;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, card, Boolean.valueOf(z16));
            return;
        }
        if (card == null) {
            return;
        }
        if (!card.medalSwitchDisable) {
            this.mModelLayout.setVisibility(0);
            findViewById(R.id.f165052uq4).setVisibility(0);
        }
        String str3 = ProfileCardTemplate.QVIP_PROFILE_TEMPLATE_JSON;
        if (!this.mProfessionModified) {
            updateProfession(card.iProfession);
        }
        professionToggleControl(card.iProfession);
        String obj = this.mCompanyEdit.getText().toString();
        if (!this.mCompanyTextWatcher.mModifiedByUser && (str2 = card.strCompany) != null && !str2.equals(obj)) {
            this.mCompanyTextWatcher.mPendCallbackModification = true;
            updateCompany(card.strCompany);
        }
        if (!this.mHometownCodesModified) {
            if (!TextUtils.isEmpty(card.strHometownCodes)) {
                strArr = card.strHometownCodes.split("-");
            } else {
                strArr = null;
            }
            this.mHometownCodes = strArr;
            updateHometown(card.strHometownDesc);
        }
        String obj2 = this.mEmailEdit.getText().toString();
        if (!this.mEmailTextWatcher.mModifiedByUser && (str = card.strEmail) != null && !str.equals(obj2)) {
            this.mEmailTextWatcher.mPendCallbackModification = true;
            String str4 = card.strEmail;
            this.preEmail = str4;
            updateEmail(str4);
        }
        if (!this.mPersonalNoteModified) {
            updatePersonalNote(card.strPersonalNote);
        }
    }

    public boolean sendUserInfoChange() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        Bundle bundle = new Bundle();
        if (this.mProfessionModified) {
            bundle.putInt(IProfileProtocolConst.KEY_PROFESSION, this.mProfession);
        }
        if (this.mCompanyTextWatcher.mModifiedByUser) {
            bundle.putString(IProfileProtocolConst.KEY_COMPANY, this.mCompanyEdit.getText().toString());
        }
        if (this.mHometownCodesModified) {
            String charSequence = this.mHometownTxt.getText().toString();
            bundle.putStringArray(IProfileProtocolConst.KEY_HOMETOWN, this.mHometownCodes);
            bundle.putString(IProfileProtocolConst.KEY_HOMETOWN_DESC, charSequence);
        }
        if (this.mEmailTextWatcher.mModifiedByUser) {
            String obj = this.mEmailEdit.getText().toString();
            Matcher matcher = VERIFY_EMAIL_PATTERN.matcher(obj);
            if (TextUtils.isEmpty(obj) || matcher.matches()) {
                bundle.putString("email", obj);
            }
        }
        if (this.mPersonalNoteModified) {
            bundle.putString(IProfileProtocolConst.KEY_PERSONAL_NOTE, this.mPersonalNote);
        }
        return setDetailUserInfo(bundle, R.string.f170712ls, 0);
    }

    public boolean setDetailUserInfo(Bundle bundle, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, this, bundle, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }
        getQBaseActivity();
        if (!NetworkUtil.isNetSupport(this.mContext)) {
            notifyUser(i3, i16);
        } else if (bundle != null && !bundle.isEmpty()) {
            ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).setDetailUserInfo(this.mApp, bundle);
            return true;
        }
        return false;
    }

    public void updateEducationListLayout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        ArrayList<i> arrayList = this.mSchoolInfos;
        if (arrayList == null) {
            return;
        }
        Iterator<i> it = arrayList.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (!TextUtils.isEmpty(next.f260185d)) {
                View inflate = View.inflate(getContext(), R.layout.h0q, null);
                TextView textView = (TextView) inflate.findViewById(R.id.ihm);
                if (next.f260193l) {
                    textView.setText(next.f260185d);
                    Drawable drawable = getContext().getResources().getDrawable(R.drawable.ne6);
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                    textView.setCompoundDrawables(null, null, drawable, null);
                    textView.setCompoundDrawablePadding(ViewUtils.dpToPx(4.5f));
                } else {
                    textView.setText(next.f260185d);
                }
                TextView textView2 = (TextView) inflate.findViewById(R.id.f165059bu0);
                String b16 = next.b();
                if (TextUtils.isEmpty(b16)) {
                    textView2.setVisibility(8);
                } else {
                    textView2.setText(b16);
                }
                TextView textView3 = (TextView) inflate.findViewById(R.id.ur6);
                if (next.f260192k) {
                    textView3.setVisibility(0);
                } else {
                    textView3.setVisibility(8);
                }
                inflate.setOnClickListener(this);
                inflate.setTag(next);
                this.mAddedSchoolLayout.addView(inflate);
            }
        }
    }

    public void updateFenzu() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        AllInOne allInOne = this.mAllInOne;
        if (allInOne != null && ProfilePAUtils.isPaTypeFriend(allInOne)) {
            this.iProfileEditBusinessApi.getGroupInfoNT(this.mAllInOne, new hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b>() { // from class: com.tencent.mobileqq.profilecard.fragment.ProfileCardNewMoreFragment.8
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileCardNewMoreFragment.this);
                    }
                }

                @Override // hx3.b
                public void onQueryResult(e<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> eVar) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) eVar);
                    } else {
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable(eVar) { // from class: com.tencent.mobileqq.profilecard.fragment.ProfileCardNewMoreFragment.8.1
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ e val$responseData;

                            {
                                this.val$responseData = eVar;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass8.this, (Object) eVar);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                String str;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                    return;
                                }
                                if (ProfileCardNewMoreFragment.this.mFenzu != null && ProfileCardNewMoreFragment.this.mFenzuLayout != null) {
                                    e eVar2 = this.val$responseData;
                                    String str2 = "";
                                    if (eVar2 == null || eVar2.a() != 0 || this.val$responseData.b() == null || this.val$responseData.b().isEmpty()) {
                                        ProfileCardNewMoreFragment.this.mStrGroup = "";
                                    } else {
                                        com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar = (com.tencent.qqnt.ntrelation.friendsinfo.bean.b) this.val$responseData.b().get(0);
                                        ProfileCardNewMoreFragment.this.mStrGroup = bVar.f();
                                    }
                                    if (ProfileCardNewMoreFragment.this.mFenzu != null) {
                                        TextView textView = ProfileCardNewMoreFragment.this.mFenzu;
                                        if (!TextUtils.isEmpty(ProfileCardNewMoreFragment.this.mStrGroup)) {
                                            str = ProfileCardNewMoreFragment.this.mStrGroup;
                                        } else {
                                            str = "";
                                        }
                                        textView.setText(str);
                                    }
                                    ProfileCardNewMoreFragment profileCardNewMoreFragment = ProfileCardNewMoreFragment.this;
                                    View view = profileCardNewMoreFragment.mFenzuLayout;
                                    TextView textView2 = ProfileCardNewMoreFragment.this.mFenzu;
                                    String string = ProfileCardNewMoreFragment.this.mContext.getString(R.string.f175742zd);
                                    if (!TextUtils.isEmpty(ProfileCardNewMoreFragment.this.mStrGroup)) {
                                        str2 = ProfileCardNewMoreFragment.this.mStrGroup;
                                    }
                                    profileCardNewMoreFragment.updateItemContentDescription(view, textView2, string, str2);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    public void updateItemContentDescription(View view, View view2, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, view, view2, str, str2);
            return;
        }
        String str3 = str + "," + str2 + ",";
        view.setContentDescription(str3);
        if (view2 instanceof EditText) {
            str3 = str + HardCodeUtil.qqStr(R.string.f212695o8) + str2 + ",";
        }
        view2.setContentDescription(str3);
    }

    public void updateSchoolLayout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (this.mAddedSchoolLayout.getChildCount() < 2) {
            this.mEducationLayout.findViewById(R.id.ihf).setVisibility(0);
            this.mEducationLayout.findViewById(R.id.ihj).setVisibility(0);
            this.mEducationLayout.findViewById(R.id.ihh).setVisibility(0);
            this.mEducationLayout.findViewById(R.id.ihd).setVisibility(8);
            return;
        }
        this.mEducationLayout.findViewById(R.id.ihf).setVisibility(8);
        this.mEducationLayout.findViewById(R.id.ihj).setVisibility(8);
        this.mEducationLayout.findViewById(R.id.ihh).setVisibility(8);
        this.mEducationLayout.findViewById(R.id.ihd).setVisibility(0);
    }

    public void updateTextView(TextView textView, CharSequence charSequence, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 26)) {
            updateTextView(textView, charSequence, z16 ? R.color.qui_common_text_tertiary : R.color.qui_common_text_secondary);
        } else {
            iPatchRedirector.redirect((short) 26, this, textView, charSequence, Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    private void updateTextView(TextView textView, CharSequence charSequence, int i3) {
        textView.setTextColor(this.mContext.getResources().getColor(i3));
        textView.setText(charSequence);
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }

    private void reportSchoolClick(int i3) {
    }
}
