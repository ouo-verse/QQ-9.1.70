package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.qcircle.widget.QFSFollowView;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.AddBatchPhoneFriendResult;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.KplRoleInfo;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;
import com.tencent.mobileqq.friend.api.IFriendHandlerService;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.newfriend.api.INewFriendVerificationService;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleLpReportDc05504DataBuilder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.troop.utils.e;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.webview.api.IAddContactSecCheckWebApi;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqnt.kernel.nativeinterface.BuddySource;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import com.tencent.raft.codegenmeta.utils.Constants;
import com.tencent.widget.Switch;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.report.lp.LpReportInfo_dc04586;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import mqq.app.MainService;
import org.apache.commons.lang.CharEncoding;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Deprecated
/* loaded from: classes9.dex */
public class AddFriendVerifyActivity extends IphoneTitleBarActivity implements View.OnTouchListener, CompoundButton.OnCheckedChangeListener, View.OnClickListener, TextWatcher, e.a {
    static IPatchRedirector $redirector_;
    public static final boolean V0;
    private int A0;
    private TextView B0;
    ImageView C0;
    protected String D0;
    protected InputMethodManager E0;
    private String F0;
    private String G0;
    private int H0;
    private ArrayList<PhoneContact> I0;
    r J0;
    r K0;
    KplRoleInfo.WZRYUIinfo L0;
    String M0;
    private int N0;
    private Bundle O0;
    private int P0;
    private ProfileCardObserver Q0;
    private final com.tencent.mobileqq.friend.observer.a R0;
    private com.tencent.qidian.controller.a S0;
    private ViewTreeObserver.OnGlobalLayoutListener T0;
    protected QQCustomDialog U0;

    /* renamed from: a0, reason: collision with root package name */
    QQProgressDialog f174721a0;

    /* renamed from: b0, reason: collision with root package name */
    private ArrayList<EditText> f174722b0;

    /* renamed from: c0, reason: collision with root package name */
    EditText f174723c0;

    /* renamed from: d0, reason: collision with root package name */
    LinearLayout f174724d0;

    /* renamed from: e0, reason: collision with root package name */
    LinearLayout f174725e0;

    /* renamed from: f0, reason: collision with root package name */
    BounceScrollView f174726f0;

    /* renamed from: g0, reason: collision with root package name */
    private LinearLayout f174727g0;

    /* renamed from: h0, reason: collision with root package name */
    private FormItemRelativeLayout f174728h0;

    /* renamed from: i0, reason: collision with root package name */
    private FormItemRelativeLayout f174729i0;

    /* renamed from: j0, reason: collision with root package name */
    private TextView f174730j0;

    /* renamed from: k0, reason: collision with root package name */
    EditText f174731k0;

    /* renamed from: l0, reason: collision with root package name */
    TextView f174732l0;

    /* renamed from: m0, reason: collision with root package name */
    TextView f174733m0;

    /* renamed from: n0, reason: collision with root package name */
    TextView f174734n0;

    /* renamed from: o0, reason: collision with root package name */
    private View f174735o0;

    /* renamed from: p0, reason: collision with root package name */
    private Switch f174736p0;

    /* renamed from: q0, reason: collision with root package name */
    private View f174737q0;

    /* renamed from: r0, reason: collision with root package name */
    private Switch f174738r0;

    /* renamed from: s0, reason: collision with root package name */
    private boolean f174739s0;

    /* renamed from: t0, reason: collision with root package name */
    private int f174740t0;

    /* renamed from: u0, reason: collision with root package name */
    private String f174741u0;

    /* renamed from: v0, reason: collision with root package name */
    private int f174742v0;

    /* renamed from: w0, reason: collision with root package name */
    private int f174743w0;

    /* renamed from: x0, reason: collision with root package name */
    Dialog f174744x0;

    /* renamed from: y0, reason: collision with root package name */
    private FriendListHandler f174745y0;

    /* renamed from: z0, reason: collision with root package name */
    private String f174746z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendVerifyActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            } else {
                AddFriendVerifyActivity.this.f174721a0 = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendVerifyActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            } else {
                AddFriendVerifyActivity.this.f174721a0 = null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class c extends ProfileCardObserver {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendVerifyActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.profilecard.observer.ProfileCardObserver
        protected void onGetProfileCard(boolean z16, Object obj) {
            ContactCard contactCard;
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj);
                return;
            }
            if (z16 && obj != null) {
                if (obj instanceof Card) {
                    Card card = (Card) obj;
                    String str2 = card.uin;
                    if (str2 != null && str2.equals(AddFriendVerifyActivity.this.f174746z0)) {
                        String Z = ProfileCardUtil.Z(AddFriendVerifyActivity.this, card.shGender, card.age, card.strCountry, card.strProvince, card.strCity);
                        AddFriendVerifyActivity addFriendVerifyActivity = AddFriendVerifyActivity.this;
                        if (addFriendVerifyActivity.L0 != null) {
                            Z = ProfileCardUtil.Z(addFriendVerifyActivity, card.shGender, 0, "", "", "");
                        }
                        if (!TextUtils.isEmpty(Z)) {
                            AddFriendVerifyActivity.this.f174734n0.setVisibility(0);
                            AddFriendVerifyActivity.this.f174734n0.setText(Z);
                        }
                    }
                } else if ((obj instanceof ContactCard) && (str = (contactCard = (ContactCard) obj).mobileNo) != null && str.equals(AddFriendVerifyActivity.this.f174746z0)) {
                    String Z2 = ProfileCardUtil.Z(AddFriendVerifyActivity.this, contactCard.bSex, contactCard.bAge, contactCard.strCountry, contactCard.strProvince, contactCard.strCity);
                    AddFriendVerifyActivity addFriendVerifyActivity2 = AddFriendVerifyActivity.this;
                    if (addFriendVerifyActivity2.L0 != null) {
                        Z2 = ProfileCardUtil.Z(addFriendVerifyActivity2, contactCard.bSex, 0, "", "", "");
                    }
                    if (!TextUtils.isEmpty(Z2)) {
                        AddFriendVerifyActivity.this.f174734n0.setVisibility(0);
                        AddFriendVerifyActivity.this.f174734n0.setText(Z2);
                    }
                }
                AddFriendVerifyActivity addFriendVerifyActivity3 = AddFriendVerifyActivity.this;
                if (QidianManager.P(addFriendVerifyActivity3.app, addFriendVerifyActivity3.f174746z0)) {
                    AddFriendVerifyActivity.this.f174734n0.setVisibility(8);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class d extends com.tencent.mobileqq.friend.observer.a {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendVerifyActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.friend.observer.a
        public void onAddBatchPhoneFriend(boolean z16, ArrayList<AddBatchPhoneFriendResult> arrayList) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), arrayList);
                return;
            }
            if (QLog.isColorLevel()) {
                if (arrayList != null) {
                    i3 = arrayList.size();
                } else {
                    i3 = -1;
                }
                QLog.d("AddFriendVerifyActivity", 2, "onAddBatchPhoneFriend success=" + z16 + ", added count=" + i3);
            }
            if (z16) {
                QQProgressDialog qQProgressDialog = AddFriendVerifyActivity.this.f174721a0;
                if (qQProgressDialog != null) {
                    qQProgressDialog.dismiss();
                }
                QQToast.makeText(AddFriendVerifyActivity.this, 2, R.string.hei, 0).show(AddFriendVerifyActivity.this.getTitleBarHeight());
                Intent intent = new Intent();
                intent.putExtra("result", arrayList);
                AddFriendVerifyActivity.this.setResult(-1, intent);
                AddFriendVerifyActivity.this.finish();
                return;
            }
            QQProgressDialog qQProgressDialog2 = AddFriendVerifyActivity.this.f174721a0;
            if (qQProgressDialog2 != null) {
                qQProgressDialog2.dismiss();
            }
            AddFriendVerifyActivity.this.I0.clear();
            QQToast.makeText(AddFriendVerifyActivity.this, 1, R.string.f173065h22, 0).show(AddFriendVerifyActivity.this.getTitleBarHeight());
            AddFriendVerifyActivity.this.setResult(0);
            AddFriendVerifyActivity.this.finish();
        }

        @Override // com.tencent.mobileqq.friend.observer.a
        protected void onAddFriendSecCheck(boolean z16, Bundle bundle) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), bundle);
                return;
            }
            String str2 = "";
            if (z16 && bundle != null) {
                AddFriendVerifyActivity.this.O0 = bundle;
                String string = bundle.getString("security_check_url", "");
                String string2 = bundle.getString("security_check_buffer", "");
                IAddContactSecCheckWebApi iAddContactSecCheckWebApi = (IAddContactSecCheckWebApi) QRoute.api(IAddContactSecCheckWebApi.class);
                AddFriendVerifyActivity addFriendVerifyActivity = AddFriendVerifyActivity.this;
                iAddContactSecCheckWebApi.openSecCheckWeb(addFriendVerifyActivity.app, addFriendVerifyActivity, 1004, string);
                str = string2;
                str2 = string;
            } else {
                str = "";
            }
            if (QLog.isColorLevel()) {
                QLog.d("AddFriendVerifyActivity", 2, "onAddFriendSecCheck, isSuccess=" + z16 + "," + TextUtils.isEmpty(str2) + "," + TextUtils.isEmpty(str));
            }
        }

        @Override // com.tencent.mobileqq.friend.observer.a
        protected void onGetAutoInfo(boolean z16, String str, String str2, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), str, str2, Integer.valueOf(i3));
                return;
            }
            if (!TextUtils.equals(AddFriendVerifyActivity.this.f174746z0, str)) {
                return;
            }
            if (!z16) {
                AddFriendVerifyActivity.this.f174740t0 = 0;
                TextView textView = AddFriendVerifyActivity.this.f174732l0;
                IAddFriendApi iAddFriendApi = (IAddFriendApi) QRoute.api(IAddFriendApi.class);
                AddFriendVerifyActivity addFriendVerifyActivity = AddFriendVerifyActivity.this;
                textView.setText(iAddFriendApi.getGroupName(addFriendVerifyActivity.app, addFriendVerifyActivity.f174740t0));
                return;
            }
            if (!((IAddFriendApi) QRoute.api(IAddFriendApi.class)).shouldUseLocalRemark(AddFriendVerifyActivity.this.f174742v0) && AddFriendVerifyActivity.this.L0 == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("AddFriendVerifyActivity", 2, "onGetAutoInfo remark = " + str2);
                }
                AddFriendVerifyActivity.this.f174731k0.setText(str2);
                try {
                    EditText editText = AddFriendVerifyActivity.this.f174731k0;
                    editText.setSelection(editText.getText().length());
                } catch (IndexOutOfBoundsException unused) {
                    if (QLog.isColorLevel()) {
                        QLog.d("AddFriendVerifyActivity", 2, "onGetAutoInfo | IndexOutOfBoundsException");
                    }
                }
                if (AppSetting.f99565y) {
                    AddFriendVerifyActivity.this.f174728h0.setContentDescription(AddFriendVerifyActivity.this.getResources().getString(R.string.bws) + AddFriendVerifyActivity.this.f174731k0.getText().toString());
                }
            }
            AddFriendVerifyActivity.this.f174740t0 = i3;
            TextView textView2 = AddFriendVerifyActivity.this.f174732l0;
            IAddFriendApi iAddFriendApi2 = (IAddFriendApi) QRoute.api(IAddFriendApi.class);
            AddFriendVerifyActivity addFriendVerifyActivity2 = AddFriendVerifyActivity.this;
            textView2.setText(iAddFriendApi2.getGroupName(addFriendVerifyActivity2.app, addFriendVerifyActivity2.f174740t0));
        }

        @Override // com.tencent.mobileqq.friend.observer.a
        protected void onGetInfoWithOpenId(boolean z16, String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), str, str2);
                return;
            }
            if (z16 && TextUtils.equals(str, AddFriendVerifyActivity.this.f174746z0) && !TextUtils.isEmpty(str2)) {
                AddFriendVerifyActivity.this.B0.setText(str2);
                if (AppSetting.f99565y) {
                    AddFriendVerifyActivity.this.B0.setContentDescription(str2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.friend.observer.a
        public void onUpdateAddFriend(boolean z16, boolean z17, boolean z18, String str, Bundle bundle) {
            String string;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), str, bundle);
                return;
            }
            if (!TextUtils.equals(str, AddFriendVerifyActivity.this.f174746z0)) {
                return;
            }
            if (z16) {
                if (bundle.getInt("friend_setting") == 3) {
                    if (z17) {
                        AddFriendVerifyActivity addFriendVerifyActivity = AddFriendVerifyActivity.this;
                        addFriendVerifyActivity.t3(addFriendVerifyActivity.f174723c0.getText().toString().trim(), bundle.getByteArray(PreloadTRTCPlayerParams.KEY_SIG), bundle.getString("security_ticket", ""));
                        return;
                    }
                    if (bundle.getString("ErrorString") != null && !bundle.getString("ErrorString").trim().equals("")) {
                        string = bundle.getString("ErrorString");
                    } else {
                        string = AddFriendVerifyActivity.this.getString(R.string.f170344mw);
                    }
                    QQToast.makeText(AddFriendVerifyActivity.this, 1, string, 1).show(AddFriendVerifyActivity.this.getTitleBarHeight());
                    return;
                }
                if (bundle.getInt(QzoneIPCModule.RESULT_CODE) == 0) {
                    int i3 = bundle.getInt("friend_setting");
                    bundle.getString(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME);
                    if (i3 != 0) {
                        if (i3 != 1 && i3 != 4) {
                            if (i3 != 100) {
                                QQProgressDialog qQProgressDialog = AddFriendVerifyActivity.this.f174721a0;
                                if (qQProgressDialog != null) {
                                    qQProgressDialog.cancel();
                                    AddFriendVerifyActivity.this.f174721a0 = null;
                                }
                                QQToast.makeText(AddFriendVerifyActivity.this, 2, R.string.h1z, 0).show(AddFriendVerifyActivity.this.getTitleBarHeight());
                                AddFriendVerifyActivity.this.e3();
                                return;
                            }
                        } else {
                            QQProgressDialog qQProgressDialog2 = AddFriendVerifyActivity.this.f174721a0;
                            if (qQProgressDialog2 != null) {
                                qQProgressDialog2.cancel();
                                AddFriendVerifyActivity.this.f174721a0 = null;
                            }
                            QQToast.makeText(AddFriendVerifyActivity.this, 2, R.string.h1z, 0).show(AddFriendVerifyActivity.this.getTitleBarHeight());
                            AddFriendVerifyActivity.this.e3();
                            return;
                        }
                    }
                    QQProgressDialog qQProgressDialog3 = AddFriendVerifyActivity.this.f174721a0;
                    if (qQProgressDialog3 != null) {
                        qQProgressDialog3.cancel();
                        AddFriendVerifyActivity.this.f174721a0 = null;
                    }
                    QQToast.makeText(AddFriendVerifyActivity.this, 2, R.string.f170041dp, 0).show(AddFriendVerifyActivity.this.getTitleBarHeight());
                    if (Utils.G(str)) {
                        String obj = AddFriendVerifyActivity.this.f174731k0.getText().toString();
                        String charSequence = AddFriendVerifyActivity.this.B0.getText().toString();
                        if (TextUtils.isEmpty(obj)) {
                            obj = charSequence;
                        }
                        Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(AddFriendVerifyActivity.this), null);
                        m3.putExtra("uin", str);
                        m3.putExtra("uintype", 0);
                        m3.putExtra("uinname", obj);
                        AddFriendVerifyActivity.this.startActivity(m3);
                        return;
                    }
                    AddFriendVerifyActivity.this.e3();
                    return;
                }
                QQProgressDialog qQProgressDialog4 = AddFriendVerifyActivity.this.f174721a0;
                if (qQProgressDialog4 != null) {
                    qQProgressDialog4.cancel();
                    AddFriendVerifyActivity.this.f174721a0 = null;
                }
                int i16 = bundle.getInt("error_code", 0);
                String string2 = bundle.getString("ErrorString");
                if (i16 == 167) {
                    AddFriendVerifyActivity.this.s3(string2);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("AddFriendVerifyActivity", 2, "add friend response error and ErroString = " + string2);
                }
                if (TextUtils.isEmpty(string2)) {
                    string2 = AddFriendVerifyActivity.this.getString(R.string.f173065h22);
                }
                AddFriendVerifyActivity.this.r3(string2);
                return;
            }
            QQProgressDialog qQProgressDialog5 = AddFriendVerifyActivity.this.f174721a0;
            if (qQProgressDialog5 != null) {
                qQProgressDialog5.cancel();
                AddFriendVerifyActivity.this.f174721a0 = null;
            }
            AddFriendVerifyActivity addFriendVerifyActivity2 = AddFriendVerifyActivity.this;
            addFriendVerifyActivity2.r3(addFriendVerifyActivity2.getString(R.string.f173065h22));
            if (QLog.isColorLevel()) {
                QLog.d("AddFriendVerifyActivity", 2, "add friend response error and isSuccuss = NO");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class e extends com.tencent.qidian.controller.a {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendVerifyActivity.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.qidian.controller.a
        public void h(boolean z16, HashMap<String, Object> hashMap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), hashMap);
                return;
            }
            if (z16 && hashMap != null && hashMap.containsKey("external") && hashMap.get("external") != null) {
                QidianExternalInfo qidianExternalInfo = (QidianExternalInfo) hashMap.get("external");
                if (AddFriendVerifyActivity.this.f174746z0.equals(qidianExternalInfo.uin)) {
                    if (AddFriendVerifyActivity.this.B0 != null) {
                        String charSequence = AddFriendVerifyActivity.this.B0.getText().toString();
                        if (TextUtils.isEmpty(charSequence) || charSequence.equals(AddFriendVerifyActivity.this.f174746z0)) {
                            AddFriendVerifyActivity.this.B0.setText(qidianExternalInfo.nickname);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("AddFriendVerifyActivity", 2, "onGetQidianMasterInfo not current uin");
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("AddFriendVerifyActivity", 2, "onGetQidianMasterInfo fail");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class f implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f174761d;

        f(String str) {
            this.f174761d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendVerifyActivity.this, (Object) str);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                Dialog dialog = AddFriendVerifyActivity.this.f174744x0;
                if (dialog != null && dialog.isShowing() && AddFriendVerifyActivity.this.f174744x0.getWindow() != null) {
                    try {
                        AddFriendVerifyActivity.this.f174744x0.dismiss();
                        AddFriendVerifyActivity.this.Z2(-1, this.f174761d);
                    } catch (Throwable unused) {
                    }
                    AddFriendVerifyActivity.this.f174744x0 = null;
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class g implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendVerifyActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            ReportController.o(null, "dc00898", "", "", "0X800B993", "0X800B993", 0, 0, "", "", "", "");
            if (QLog.isColorLevel()) {
                QLog.i("AddFriendVerifyActivity", 2, "jumpUrl: mqqapi://miniapp/open?_atype=0&_mappid=1109048181&_mvid=&_path=pages%2Fqq_risk%2Fgood_person%2Fadd_friend%3Ftype%3Dadd_firend&_vt=3&referer=2017&via=tencent_csd&_sig=3708401383" + String.format("&uin=%s", AddFriendVerifyActivity.this.f174746z0));
            }
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(AddFriendVerifyActivity.this, "mqqapi://miniapp/open?_atype=0&_mappid=1109048181&_mvid=&_path=pages%2Fqq_risk%2Fgood_person%2Fadd_friend%3Ftype%3Dadd_firend&_vt=3&referer=2017&via=tencent_csd&_sig=3708401383" + String.format("&uin=%s", AddFriendVerifyActivity.this.f174746z0), 2017, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class h implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendVerifyActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                ReportController.o(null, "dc00898", "", "", "0X800B992", "0X800B992", 0, 0, "", "", "", "");
                AddFriendVerifyActivity.this.f174744x0.dismiss();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class i implements ViewTreeObserver.OnGlobalLayoutListener {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendVerifyActivity.this);
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            Rect rect = new Rect();
            AddFriendVerifyActivity.this.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            DisplayMetrics displayMetrics = AddFriendVerifyActivity.this.getResources().getDisplayMetrics();
            int max = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
            if (max - (rect.bottom - rect.top) > max / 3) {
                z16 = true;
            } else {
                z16 = false;
            }
            View currentFocus = AddFriendVerifyActivity.this.getCurrentFocus();
            if (!z16) {
                if (currentFocus != null && (currentFocus instanceof EditText)) {
                    ((EditText) currentFocus).setCursorVisible(false);
                    return;
                }
                return;
            }
            if (currentFocus != null && (currentFocus instanceof EditText)) {
                ((EditText) currentFocus).setCursorVisible(true);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class j implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendVerifyActivity.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            if ((motionEvent.getAction() & 255) == 2) {
                InputMethodManager inputMethodManager = (InputMethodManager) BaseApplication.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
                if (inputMethodManager.isActive()) {
                    inputMethodManager.hideSoftInputFromWindow(AddFriendVerifyActivity.this.getWindow().getDecorView().getWindowToken(), 0);
                }
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class k implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f174767d;

        k(int i3) {
            this.f174767d = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendVerifyActivity.this, i3);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                AddFriendVerifyActivity addFriendVerifyActivity = AddFriendVerifyActivity.this;
                if (addFriendVerifyActivity.E0 != null) {
                    addFriendVerifyActivity.getWindow().setSoftInputMode(2);
                    AddFriendVerifyActivity addFriendVerifyActivity2 = AddFriendVerifyActivity.this;
                    addFriendVerifyActivity2.E0.hideSoftInputFromWindow(addFriendVerifyActivity2.f174723c0.getWindowToken(), 0);
                    AddFriendVerifyActivity.this.f174723c0.clearFocus();
                }
                if (AddFriendVerifyActivity.this.f174723c0.getText().toString().length() > 30) {
                    ReportDialog reportDialog = new ReportDialog(AddFriendVerifyActivity.this, R.style.qZoneInputDialog);
                    reportDialog.setContentView(R.layout.bwu);
                    ((TextView) reportDialog.findViewById(R.id.dialogText)).setText(AddFriendVerifyActivity.this.getString(R.string.a_d));
                    ((ProgressBar) reportDialog.findViewById(R.id.cib)).setVisibility(8);
                    ((ImageView) reportDialog.findViewById(R.id.kja)).setImageResource(R.drawable.f160605la);
                    reportDialog.show();
                } else {
                    String trim = AddFriendVerifyActivity.this.f174723c0.getText().toString().trim();
                    AddFriendVerifyActivity.this.n3(trim, false);
                    if (AddFriendVerifyActivity.this.getString(R.string.axv).equals(trim) && !AddFriendVerifyActivity.this.d3()) {
                        AddFriendVerifyActivity.this.h3();
                    }
                    AddFriendVerifyActivity addFriendVerifyActivity3 = AddFriendVerifyActivity.this;
                    addFriendVerifyActivity3.i3(addFriendVerifyActivity3.f174723c0.getText().toString().trim());
                    if (this.f174767d == 0) {
                        ReportController.o(AddFriendVerifyActivity.this.app, "dc00898", "", "", "0X800796F", "0X800796F", 0, 0, "", "", "", "");
                    } else {
                        ReportController.o(AddFriendVerifyActivity.this.app, "dc00898", "", "", "0X8007976", "0X8007976", 0, 0, "", "", "", "");
                    }
                    if (!TextUtils.isEmpty(AddFriendVerifyActivity.this.M0)) {
                        ReportController.o(AddFriendVerifyActivity.this.app, "dc00899", "Qidian", "", "0X8008802", "ClickAddFriendButton", 0, 0, "1", "", "", "");
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class l implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f174769d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f174770e;

        l(int i3, int i16) {
            this.f174769d = i3;
            this.f174770e = i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, AddFriendVerifyActivity.this, Integer.valueOf(i3), Integer.valueOf(i16));
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                AddFriendVerifyActivity.this.l3();
                AddFriendVerifyActivity.this.t3("", null, "");
                ReportController.o(AddFriendVerifyActivity.this.app, "dc00898", "", "", "0X80077B4", "0X80077B4", 0, 0, String.valueOf(this.f174769d), String.valueOf(this.f174770e), "", "");
                if (QLog.isColorLevel()) {
                    QLog.d("AddFriendVerifyActivity", 2, "reportClickEvent action: 0X80077B4  sourceId = " + this.f174769d + " subSourceId = " + this.f174770e);
                }
                if (Utils.G(AddFriendVerifyActivity.this.f174746z0)) {
                    ReportController.o(AddFriendVerifyActivity.this.app, "dc00898", "", "", "0X8008275", "0X8008275", 0, 0, "", "", "", "");
                }
                if (!TextUtils.isEmpty(AddFriendVerifyActivity.this.M0)) {
                    ReportController.o(AddFriendVerifyActivity.this.app, "dc00899", "Qidian", "", "0X8008802", "ClickAddFriendButton", 0, 0, "1", "", "", "");
                }
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class m implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f174772d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f174773e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f174774f;

        m(int i3, int i16, int i17) {
            this.f174772d = i3;
            this.f174773e = i16;
            this.f174774f = i17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, AddFriendVerifyActivity.this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                AddFriendVerifyActivity.this.l3();
                String c36 = AddFriendVerifyActivity.this.c3(false);
                String trim = AddFriendVerifyActivity.this.f174723c0.getText().toString().trim();
                if (trim != null && c36 != null && !trim.equals(c36)) {
                    ReportController.o(AddFriendVerifyActivity.this.app, "dc00898", "", "", "0X80077B0", "0X80077B0", 0, 0, "", "", "", "");
                }
                AddFriendVerifyActivity.this.n3(trim, false);
                if (AddFriendVerifyActivity.this.getString(R.string.axv).equals(trim) && !AddFriendVerifyActivity.this.d3()) {
                    AddFriendVerifyActivity.this.h3();
                }
                AddFriendVerifyActivity addFriendVerifyActivity = AddFriendVerifyActivity.this;
                if (addFriendVerifyActivity.L0 != null) {
                    ReportController.o(addFriendVerifyActivity.app, "dc00898", "", "", "0X8008439", "0X8008439", 0, 0, "", "", "", "");
                    if (!TextUtils.isEmpty(AddFriendVerifyActivity.this.L0.verifyMsg)) {
                        AddFriendVerifyActivity addFriendVerifyActivity2 = AddFriendVerifyActivity.this;
                        if (!addFriendVerifyActivity2.L0.verifyMsg.equals(addFriendVerifyActivity2.f174723c0.getText().toString())) {
                            ReportController.o(AddFriendVerifyActivity.this.app, "dc00898", "", "", "0X800843A", "0X800843A", 0, 0, "", "", "", "");
                        }
                    }
                }
                AddFriendVerifyActivity addFriendVerifyActivity3 = AddFriendVerifyActivity.this;
                addFriendVerifyActivity3.t3(addFriendVerifyActivity3.f174723c0.getText().toString().trim(), null, "");
                ReportController.o(AddFriendVerifyActivity.this.app, "dc00898", "", "", "0X80077B4", "0X80077B4", 0, 0, String.valueOf(this.f174772d), String.valueOf(this.f174773e), "", "");
                if (QLog.isColorLevel()) {
                    QLog.d("AddFriendVerifyActivity", 2, "reportClickEvent action: 0X80077B4  sourceId = " + this.f174772d + " subSourceId = " + this.f174773e);
                }
                if (!TextUtils.isEmpty(AddFriendVerifyActivity.this.M0)) {
                    ReportController.o(AddFriendVerifyActivity.this.app, "dc00899", "Qidian", "", "0X8008802", "ClickAddFriendButton", 0, 0, "1", "", "", "");
                }
                AddFriendVerifyActivity.this.Y2(this.f174772d, this.f174774f);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class n implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ EditText f174776d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f174777e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f174778f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f174779h;

        n(EditText editText, int i3, int i16, int i17) {
            this.f174776d = editText;
            this.f174777e = i3;
            this.f174778f = i16;
            this.f174779h = i17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, AddFriendVerifyActivity.this, editText, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                AddFriendVerifyActivity.this.l3();
                if ("".equals(this.f174776d.getText().toString().trim())) {
                    AddFriendVerifyActivity addFriendVerifyActivity = AddFriendVerifyActivity.this;
                    QQToast.makeText(addFriendVerifyActivity, 0, addFriendVerifyActivity.getString(R.string.f170345mx), 0).show(AddFriendVerifyActivity.this.getTitleBarHeight());
                } else if (NetworkUtil.isNetSupport(AddFriendVerifyActivity.this)) {
                    ((IFriendHandlerService) AddFriendVerifyActivity.this.app.getRuntimeService(IFriendHandlerService.class)).requestAddFriend(AddFriendVerifyActivity.this.f174746z0, AddFriendVerifyActivity.this.getIntent().getStringExtra("extra"), this.f174777e, (byte) 0, this.f174776d.getText().toString().trim(), this.f174778f, AddFriendVerifyActivity.this.getIntent().getIntExtra("sub_source_id", 0), false, null, false, null, AddFriendVerifyActivity.this.getIntent().getStringExtra("src_name"), AddFriendVerifyActivity.this.getIntent().getBundleExtra("flc_extra_param"), true);
                } else {
                    AddFriendVerifyActivity addFriendVerifyActivity2 = AddFriendVerifyActivity.this;
                    QQToast.makeText(addFriendVerifyActivity2, 1, addFriendVerifyActivity2.getString(R.string.f171139ci4), 0).show(AddFriendVerifyActivity.this.getTitleBarHeight());
                }
                ReportController.o(AddFriendVerifyActivity.this.app, "dc00898", "", "", "0X80077B4", "0X80077B4", 0, 0, String.valueOf(this.f174778f), String.valueOf(this.f174779h), "", "");
                if (QLog.isColorLevel()) {
                    QLog.d("AddFriendVerifyActivity", 2, "reportClickEvent action: 0X80077B4  sourceId = " + this.f174778f + " subSourceId = " + this.f174779h);
                }
                if (!TextUtils.isEmpty(AddFriendVerifyActivity.this.M0)) {
                    ReportController.o(AddFriendVerifyActivity.this.app, "dc00899", "Qidian", "", "0X8008802", "ClickAddFriendButton", 0, 1, "", "", "", "");
                }
                AddFriendVerifyActivity.this.Y2(this.f174778f, this.f174777e);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class o implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ StringBuffer f174781d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f174782e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f174783f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f174784h;

        o(StringBuffer stringBuffer, int i3, int i16, int i17) {
            this.f174781d = stringBuffer;
            this.f174782e = i3;
            this.f174783f = i16;
            this.f174784h = i17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, AddFriendVerifyActivity.this, stringBuffer, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z16;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                AddFriendVerifyActivity.this.l3();
                String stringBuffer = this.f174781d.toString();
                int i3 = 0;
                while (true) {
                    if (i3 < AddFriendVerifyActivity.this.f174722b0.size()) {
                        String trim = ((EditText) AddFriendVerifyActivity.this.f174722b0.get(i3)).getText().toString().trim();
                        if ("".equals(trim)) {
                            z16 = true;
                            break;
                        } else {
                            stringBuffer = stringBuffer.replaceFirst("\\$\\{answer\\}", Matcher.quoteReplacement(trim));
                            i3++;
                        }
                    } else {
                        z16 = false;
                        break;
                    }
                }
                if (z16) {
                    AddFriendVerifyActivity addFriendVerifyActivity = AddFriendVerifyActivity.this;
                    QQToast.makeText(addFriendVerifyActivity, 0, addFriendVerifyActivity.getString(R.string.f170345mx), 0).show(AddFriendVerifyActivity.this.getTitleBarHeight());
                } else {
                    AddFriendVerifyActivity.this.t3(stringBuffer, null, "");
                }
                ReportController.o(AddFriendVerifyActivity.this.app, "dc00898", "", "", "0X80077B4", "0X80077B4", 0, 0, String.valueOf(this.f174782e), String.valueOf(this.f174783f), "", "");
                if (QLog.isColorLevel()) {
                    QLog.d("AddFriendVerifyActivity", 2, "reportClickEvent action: 0X80077B4  sourceId = " + this.f174782e + " subSourceId = " + this.f174783f);
                }
                if (!TextUtils.isEmpty(AddFriendVerifyActivity.this.M0)) {
                    ReportController.o(AddFriendVerifyActivity.this.app, "dc00899", "Qidian", "", "0X8008802", "ClickAddFriendButton", 0, 0, "1", "", "", "");
                }
                AddFriendVerifyActivity.this.Y2(this.f174782e, this.f174784h);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class p implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        p() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendVerifyActivity.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            ((InputMethodManager) AddFriendVerifyActivity.this.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(AddFriendVerifyActivity.this.leftView.getWindowToken(), 2);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class q implements URLDrawable.URLDrawableListener {
        static IPatchRedirector $redirector_;

        q() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendVerifyActivity.this);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) uRLDrawable);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) uRLDrawable, (Object) th5);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) uRLDrawable, i3);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) uRLDrawable);
            } else if (uRLDrawable != null) {
                Bitmap drawabletoBitmap = BaseImageUtil.drawabletoBitmap(uRLDrawable);
                QQAppInterface qQAppInterface = AddFriendVerifyActivity.this.app;
                AddFriendVerifyActivity.this.C0.setImageDrawable(new BitmapDrawable(QQAppInterface.getCircleFaceBitmap(drawabletoBitmap, 50, 50)));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class r implements TextWatcher {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        int f174788d;

        /* renamed from: e, reason: collision with root package name */
        EditText f174789e;

        /* renamed from: f, reason: collision with root package name */
        int f174790f;

        /* renamed from: h, reason: collision with root package name */
        int f174791h;

        public r(int i3, EditText editText) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) editText);
            } else {
                this.f174788d = i3;
                this.f174789e = editText;
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String str;
            String str2;
            String str3 = "";
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) editable);
                return;
            }
            String obj = this.f174789e.getText().toString();
            if (obj.getBytes().length > this.f174788d) {
                try {
                    String substring = obj.substring(0, this.f174790f);
                    try {
                        str2 = obj.substring(this.f174790f + this.f174791h, obj.length());
                        try {
                            int i3 = this.f174790f;
                            str3 = obj.substring(i3, this.f174791h + i3);
                            if (substring.getBytes().length + str2.getBytes().length <= this.f174788d) {
                                while (obj.getBytes().length > this.f174788d && str3.length() > 0) {
                                    str3 = str3.substring(0, str3.length() - 1);
                                    obj = substring + str3 + str2;
                                }
                                byte[] bytes = String.valueOf(obj.charAt(obj.length() - 1)).getBytes(CharEncoding.UTF_16BE);
                                if (bytes.length == 2 && obj.length() > 1) {
                                    char c16 = (char) (((char) (bytes[1] & 255)) | (((char) (bytes[0] & 255)) << '\b'));
                                    if (c16 >= '\ud800' && c16 <= '\ud83f') {
                                        obj = obj.substring(0, obj.length() - 1);
                                    }
                                }
                                this.f174789e.setText(obj);
                                this.f174789e.setSelection(obj.length());
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            str = str3;
                            str3 = substring;
                            if (QLog.isColorLevel()) {
                                QLog.d("AddFriendVerifyActivity", 2, "afterTextChanged, headStr:" + str3 + ", tailStr = " + str2 + ", insert = " + str, th);
                            }
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        str2 = "";
                        str3 = substring;
                        str = str2;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    str = "";
                    str2 = str;
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            } else {
                this.f174790f = i3;
                this.f174791h = i17;
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(66584);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            V0 = AppSetting.f99565y;
        }
    }

    public AddFriendVerifyActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f174722b0 = new ArrayList<>();
        this.f174728h0 = null;
        this.f174729i0 = null;
        this.f174731k0 = null;
        this.f174732l0 = null;
        this.f174739s0 = true;
        this.f174741u0 = "";
        this.C0 = null;
        this.E0 = null;
        this.H0 = 2000;
        this.I0 = new ArrayList<>();
        this.M0 = "";
        this.N0 = -1;
        this.P0 = 1000;
        this.Q0 = new c();
        this.R0 = new d();
        this.S0 = new e();
        this.T0 = new i();
        this.U0 = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z2(int i3, String str) {
        if (this.f174742v0 == 3090) {
            try {
                ForwardSdkBaseOption.E(this, true, "action_game_make_friend", Long.valueOf(getIntent().getStringExtra("extra")).longValue(), i3, str);
            } catch (Exception e16) {
                QLog.e("AddFriendVerifyActivity", 1, "feedBackToGameSDK error = " + e16);
            }
        }
    }

    private void b3(URLDrawable uRLDrawable) {
        if (uRLDrawable != null && this.app != null && this.C0 != null) {
            Bitmap drawabletoBitmap = BaseImageUtil.drawabletoBitmap(uRLDrawable);
            if (uRLDrawable.getStatus() == 1) {
                this.C0.setImageDrawable(new BitmapDrawable(QQAppInterface.getCircleFaceBitmap(drawabletoBitmap, 50, 50)));
            } else {
                uRLDrawable.setURLDrawableListener(new q());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c3(boolean z16) {
        SharedPreferences sharedPreferences = getSharedPreferences("last_verify_msg", 0);
        if (z16) {
            return sharedPreferences.getString("last_add_troop_verfity_" + this.app.getAccount(), null);
        }
        return sharedPreferences.getString("last_add_friend_verify_" + this.app.getAccount(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d3() {
        return getSharedPreferences("last_verify_msg", 0).getBoolean("add_friend_verify_msg_modify_flag" + this.app.getAccount(), false);
    }

    private boolean f3() {
        int i3 = getIntent().getExtras().getInt("source_id", BuddySource.DEFAULT);
        if (i3 != 3003 && i3 != 3006 && i3 != 3007 && i3 != 3009 && i3 != 3013) {
            return false;
        }
        return true;
    }

    private void g3() {
        Intent intent = getIntent();
        int i3 = 0;
        if (intent != null) {
            i3 = intent.getIntExtra(ProfileContants.CMD_PARAM_STAT_OPTION, 0);
        }
        if (TextUtils.isEmpty(this.G0)) {
            QLog.w("AddFriendVerifyActivity", 4, "authSig | missing 'authSig' when join group");
        } else {
            QLog.i("AddFriendVerifyActivity", 4, "authSig | authSig is not null");
        }
        QLog.i("AddFriendVerifyActivity", 4, "authSig | statOption = " + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h3() {
        getSharedPreferences("last_verify_msg", 0).edit().putBoolean("add_friend_verify_msg_modify_flag" + this.app.getAccount(), true);
    }

    private void j3() {
        INewFriendVerificationService iNewFriendVerificationService = (INewFriendVerificationService) this.app.getRuntimeService(INewFriendVerificationService.class);
        if (iNewFriendVerificationService != null) {
            int intExtra = getIntent().getIntExtra("friend_setting", 0);
            int intExtra2 = getIntent().getIntExtra("source_id", BuddySource.DEFAULT);
            String string = getIntent().getExtras().getString("extra");
            iNewFriendVerificationService.reportAddFriendBlocked(this.f174746z0, intExtra, intExtra2, getIntent().getIntExtra("sub_source_id", 0), string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l3() {
        if (this.f174742v0 == 3094) {
            String valueOf = String.valueOf(getIntent().getIntExtra("sub_source_id", 8));
            HashMap hashMap = new HashMap();
            hashMap.put("frompage", valueOf);
            hashMap.put("to_uid", this.f174746z0);
            ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#data_page#send_request_all", true, -1L, -1L, hashMap, true, true);
        }
    }

    private void p3(String str) {
        runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.AddFriendVerifyActivity.19
            static IPatchRedirector $redirector_;

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.activity.AddFriendVerifyActivity$19$a */
            /* loaded from: classes9.dex */
            class a implements DialogInterface.OnClickListener {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass19.this);
                    }
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                    } else if (i3 == 1) {
                        AddFriendVerifyActivity.this.U0.cancel();
                        AddFriendVerifyActivity.this.finish();
                    }
                }
            }

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendVerifyActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                AddFriendVerifyActivity addFriendVerifyActivity = AddFriendVerifyActivity.this;
                QQCustomDialog qQCustomDialog = addFriendVerifyActivity.U0;
                if (qQCustomDialog != null) {
                    if (!qQCustomDialog.isShowing()) {
                        AddFriendVerifyActivity.this.U0.show();
                        return;
                    }
                    return;
                }
                addFriendVerifyActivity.U0 = DialogUtil.createCustomDialog(addFriendVerifyActivity, 230);
                AddFriendVerifyActivity.this.U0.setMessage(R.string.f170882m9);
                AddFriendVerifyActivity.this.U0.setPositiveButton(R.string.a8j, new a());
                if (!AddFriendVerifyActivity.this.U0.isShowing()) {
                    AddFriendVerifyActivity.this.U0.show();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r3(String str) {
        Dialog dialog = this.f174744x0;
        if (dialog != null && dialog.isShowing() && this.f174744x0.getWindow() != null) {
            try {
                this.f174744x0.dismiss();
            } catch (Throwable unused) {
            }
        }
        Dialog createContentOnlyDialog = DialogUtil.createContentOnlyDialog(this, str, 0, R.string.cdn, null, new f(str));
        this.f174744x0 = createContentOnlyDialog;
        try {
            createContentOnlyDialog.show();
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("AddFriendVerifyActivity", 2, "showErrorTipsDlg, tips dialog show failed", th5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s3(String str) {
        ReportController.o(null, "dc00898", "", "", "0X800B991", "0X800B991", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
            QLog.d("AddFriendVerifyActivity", 2, "showSecurityTipsDialog errorStr = " + str);
        }
        Dialog dialog = this.f174744x0;
        if (dialog != null && dialog.isShowing() && this.f174744x0.getWindow() != null) {
            try {
                this.f174744x0.dismiss();
            } catch (Throwable unused) {
            }
        }
        String string = getString(R.string.f224826jz);
        if (TextUtils.isEmpty(str)) {
            str = getString(R.string.f224796jw);
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this, 230, string, str, R.string.f224806jx, R.string.f224816jy, new g(), new h());
        this.f174744x0 = createCustomDialog;
        try {
            createCustomDialog.show();
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("AddFriendVerifyActivity", 2, "showSecurityTipsDialog, tips dialog show failed", th5);
            }
        }
    }

    void Y2(int i3, int i16) {
        ThreadManagerV2.post(new Runnable(i3, getIntent().getIntExtra("sub_source_id", 0), getIntent().getBooleanExtra("select_multi_mode", false), getIntent().getStringExtra("troop_uin"), i16) { // from class: com.tencent.mobileqq.activity.AddFriendVerifyActivity.20
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f174751d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f174752e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ boolean f174753f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ String f174754h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ int f174755i;

            {
                this.f174751d = i3;
                this.f174752e = r7;
                this.f174753f = r8;
                this.f174754h = r9;
                this.f174755i = i16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, AddFriendVerifyActivity.this, Integer.valueOf(i3), Integer.valueOf(r7), Boolean.valueOf(r8), r9, Integer.valueOf(i16));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                String str;
                String valueOf;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (this.f174751d == 3004) {
                    int i17 = this.f174752e;
                    if (i17 == 5 || i17 == 6 || i17 == 7 || i17 == 8) {
                        boolean z16 = this.f174753f;
                        if (z16) {
                            str = "multiMode_send";
                        } else {
                            str = "singleMode_send";
                        }
                        String str2 = str;
                        QQAppInterface qQAppInterface = AddFriendVerifyActivity.this.app;
                        String str3 = this.f174754h;
                        if (z16) {
                            valueOf = "1";
                        } else {
                            valueOf = String.valueOf(this.f174755i);
                        }
                        ReportController.o(qQAppInterface, "dc00899", "Grp_addFrd", "", "frd_select", str2, 0, 0, str3, valueOf, "", "");
                    }
                }
            }
        }, 5, null, true);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) editable);
            return;
        }
        String obj = this.f174731k0.getText().toString();
        if (((IAddFriendApi) QRoute.api(IAddFriendApi.class)).countByByte(obj) > 32) {
            int selectionStart = this.f174731k0.getSelectionStart();
            String remark = ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).getRemark(obj);
            this.f174731k0.setText(remark);
            if (selectionStart >= remark.length()) {
                this.f174731k0.setSelection(remark.length());
            }
        }
        if (AppSetting.f99565y) {
            this.f174728h0.setContentDescription(getResources().getString(R.string.bws) + this.f174731k0.getText().toString());
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        boolean z18 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("doOnActivityResult, requestCode=");
            sb5.append(i3);
            sb5.append(",resultCode=");
            sb5.append(i16);
            sb5.append(",data=");
            if (intent == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.d("AddFriendVerifyActivity", 2, sb5.toString());
        }
        if (i3 == 0 && i16 == -1) {
            setResult(i16, intent);
            finish();
        }
        if (i3 != 1002) {
            if (i3 == 1004) {
                if (intent != null) {
                    String stringExtra = intent.getStringExtra("ticket");
                    Bundle bundle = this.O0;
                    if (bundle != null) {
                        t3(bundle.getString("msg", ""), this.O0.getByteArray(PreloadTRTCPlayerParams.KEY_SIG), stringExtra);
                    } else {
                        QQProgressDialog qQProgressDialog = this.f174721a0;
                        if (qQProgressDialog != null) {
                            qQProgressDialog.cancel();
                            this.f174721a0 = null;
                        }
                        r3(getString(R.string.f173065h22));
                        j3();
                        z17 = false;
                    }
                    z18 = z17;
                } else {
                    QQProgressDialog qQProgressDialog2 = this.f174721a0;
                    if (qQProgressDialog2 != null) {
                        qQProgressDialog2.cancel();
                        this.f174721a0 = null;
                    }
                    r3(getString(R.string.f173065h22));
                    j3();
                }
                if (QLog.isColorLevel()) {
                    QLog.d("AddFriendVerifyActivity", 2, "REQUEST_CODE_SECCHECK_H5_PAGE, isSuccuss=" + z18);
                    return;
                }
                return;
            }
            return;
        }
        if (intent != null) {
            byte byteExtra = intent.getByteExtra("result", (byte) 0);
            this.f174740t0 = byteExtra;
            this.f174732l0.setText(((IAddFriendApi) QRoute.api(IAddFriendApi.class)).getGroupName(this.app, byteExtra));
            this.f174729i0.setContentDescription(HardCodeUtil.qqStr(R.string.j4k) + ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).getGroupName(this.app, byteExtra));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0b5f  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0ab7  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0b72  */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean doOnCreate(Bundle bundle) {
        String str;
        int i3;
        String string;
        LinearLayout.LayoutParams layoutParams;
        boolean z16;
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        Intent intent = getIntent();
        this.f174746z0 = intent.getStringExtra("uin");
        int i18 = 1;
        int intExtra = intent.getIntExtra("k_uin_type", 1);
        this.A0 = intExtra;
        if (intExtra != 4) {
            setTheme(R.style.f173428d2);
        }
        this.N0 = intent.getIntExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, -1);
        super.doOnCreate(bundle);
        this.E0 = (InputMethodManager) getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (this.A0 != 4) {
            setContentViewB(R.layout.f167566ax);
            this.f174745y0 = (FriendListHandler) this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
            this.f174743w0 = getIntent().getIntExtra("sub_source_id", 0);
            this.f174742v0 = intent.getIntExtra("source_id", BuddySource.DEFAULT);
            if (intent.hasExtra(IProfileCardConst.KEY_WZRY_DATA)) {
                this.L0 = (KplRoleInfo.WZRYUIinfo) intent.getSerializableExtra(IProfileCardConst.KEY_WZRY_DATA);
            }
            if (((IAddFriendApi) QRoute.api(IAddFriendApi.class)).shouldUseLocalRemark(this.f174742v0)) {
                this.f174741u0 = intent.getStringExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME);
            } else if (this.L0 != null) {
                this.f174741u0 = intent.getStringExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME);
            } else if (this.f174742v0 == 3004 && ((i17 = this.f174743w0) == 5 || i17 == 6 || i17 == 7 || i17 == 8)) {
                this.f174741u0 = intent.getStringExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME);
            }
            if (QLog.isColorLevel()) {
                QLog.i("AddFriendVerifyActivity", 2, "AddFriendVerifyActivity remark = " + this.f174741u0 + ", source id=" + this.f174742v0 + ", mTargetGroupId = " + this.f174740t0);
            }
            if (bundle == null && NetworkUtil.isNetSupport(this) && ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).shouldReqAutoInfo(this.f174742v0, this.f174746z0)) {
                ((IFriendHandlerService) this.app.getRuntimeService(IFriendHandlerService.class)).requestAutoInfo(this.f174746z0, this.f174742v0, intent.getIntExtra("sub_source_id", 0));
            }
            getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.T0);
            BounceScrollView bounceScrollView = (BounceScrollView) findViewById(R.id.adt);
            this.f174726f0 = bounceScrollView;
            bounceScrollView.setOnTouchListener(new j());
            this.f174723c0 = (EditText) findViewById(R.id.f166785i82);
            this.f174733m0 = (TextView) findViewById(R.id.f166786i83);
            r rVar = new r(100, this.f174723c0);
            this.J0 = rVar;
            this.f174723c0.addTextChangedListener(rVar);
            TextView textView = (TextView) findViewById(R.id.it);
            this.f174734n0 = textView;
            textView.setVisibility(0);
            String stringExtra = getIntent().getStringExtra("key_param_age_area");
            if (!TextUtils.isEmpty(stringExtra)) {
                this.f174734n0.setText(stringExtra);
                if (AppSetting.f99565y) {
                    this.f174734n0.setContentDescription(stringExtra);
                }
            }
            this.f174723c0.setOnTouchListener(this);
            this.f174724d0 = (LinearLayout) findViewById(R.id.f6v);
            this.f174725e0 = (LinearLayout) findViewById(R.id.f164345si);
            this.C0 = (ImageView) findViewById(R.id.fxg);
            this.B0 = (TextView) findViewById(R.id.nickname);
            this.f174730j0 = (TextView) findViewById(R.id.jpk);
            this.f174727g0 = (LinearLayout) findViewById(R.id.cxh);
            FormItemRelativeLayout formItemRelativeLayout = (FormItemRelativeLayout) findViewById(R.id.idd);
            this.f174728h0 = formItemRelativeLayout;
            formItemRelativeLayout.setBGType(1);
            FormItemRelativeLayout formItemRelativeLayout2 = (FormItemRelativeLayout) findViewById(R.id.ici);
            this.f174729i0 = formItemRelativeLayout2;
            formItemRelativeLayout2.setBGType(3);
            this.f174731k0 = (EditText) findViewById(R.id.bz4);
            this.f174732l0 = (TextView) findViewById(R.id.k8i);
            this.f174731k0.addTextChangedListener(this);
            this.f174729i0.setOnClickListener(this);
            this.f174731k0.setText(this.f174741u0);
            if (!TextUtils.isEmpty(this.f174741u0)) {
                this.f174731k0.setSelection(this.f174741u0.length());
            }
            this.f174732l0.setText(((IAddFriendApi) QRoute.api(IAddFriendApi.class)).getGroupName(this.app, this.f174740t0));
            this.f174729i0.setContentDescription(HardCodeUtil.qqStr(R.string.j4e) + ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).getGroupName(this.app, this.f174740t0));
            if (Utils.G(this.f174746z0)) {
                this.f174728h0.setVisibility(8);
                this.f174730j0.setText(getString(R.string.f170052e2));
            } else {
                this.f174728h0.setVisibility(0);
                this.f174730j0.setText(getString(R.string.f170051e1));
            }
            boolean z17 = friendlist.a.a(this.f174742v0) || this.f174742v0 == 3016;
            if (!z17) {
                View findViewById = findViewById(R.id.hlz);
                this.f174735o0 = findViewById;
                findViewById.setVisibility(0);
                Switch r16 = (Switch) findViewById(R.id.f166719hm0);
                this.f174736p0 = r16;
                r16.setOnCheckedChangeListener(this);
            }
            if (this.f174742v0 == 3050 && this.f174743w0 == 3) {
                HashMap<String, String> hashMap = new HashMap<>();
                if (!intent.getBooleanExtra("qcircle_isfollow", false)) {
                    View findViewById2 = findViewById(R.id.f31210qf);
                    this.f174737q0 = findViewById2;
                    findViewById2.setVisibility(0);
                    Switch r36 = (Switch) findViewById(R.id.f31220qg);
                    this.f174738r0 = r36;
                    r36.setOnCheckedChangeListener(this);
                    hashMap.put("ext3", "1");
                } else {
                    hashMap.put("ext3", "2");
                }
                ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setToUin(this.f174746z0).setActionType(79).setSubActionType(1).setThrActionType(0).setExtras(hashMap));
                if (intent.getBooleanExtra("key_qcircle_stick", false)) {
                    ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setToUin(this.f174746z0).setActionType(93).setSubActionType(1).setThrActionType(1));
                }
            }
            if (AppSetting.f99565y) {
                this.C0.setContentDescription(getString(R.string.b2q));
                if (!Utils.G(this.f174746z0)) {
                    this.f174730j0.setContentDescription(getString(R.string.h0q));
                } else {
                    this.f174730j0.setContentDescription(getString(R.string.h0p));
                }
                this.f174728h0.setFocusable(true);
                this.f174728h0.setContentDescription(getResources().getString(R.string.bws) + this.f174731k0.getText().toString());
                this.f174731k0.setContentDescription(null);
                if (!z17) {
                    this.f174735o0.setFocusable(true);
                    this.f174735o0.setContentDescription(getResources().getString(R.string.giz));
                }
            }
        }
        QQProgressDialog qQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
        this.f174721a0 = qQProgressDialog;
        qQProgressDialog.setMessage(R.string.f170716zu);
        this.F0 = intent.getStringExtra("authKey");
        this.G0 = intent.getStringExtra("authSig");
        g3();
        String string2 = getIntent().getExtras().getString(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME);
        String str2 = "extra";
        if (this.A0 != 4) {
            setTitle(R.string.f170048dx);
            setLeftButton(HardCodeUtil.qqStr(R.string.j3m), (View.OnClickListener) null);
            CardHandler cardHandler = (CardHandler) this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
            int i19 = getIntent().getExtras().getInt("source_id", BuddySource.DEFAULT);
            int intExtra2 = getIntent().getIntExtra("sub_source_id", 0);
            if (friendlist.a.a(getIntent().getIntExtra("sort_id", 0))) {
                cardHandler.m3(this.app.getCurrentAccountUin(), "0", 16, 0L, (byte) 0, 0L, 0L, null, this.f174746z0, 0L, 10004, null, (byte) 0);
            } else {
                cardHandler.m3(this.app.getCurrentAccountUin(), this.f174746z0, 12, 0L, (byte) 0, 0L, 0L, null, "", 0L, 10004, null, (byte) 0);
            }
            addObserver(this.Q0);
            addObserver(this.R0);
            addObserver(this.S0);
            int i26 = this.A0;
            if (i26 == 2) {
                this.C0.setImageDrawable(FaceDrawable.getFaceDrawable(this.app, 11, this.f174746z0));
                this.B0.setText(TextUtils.isEmpty(string2) ? this.f174746z0 : string2);
                if (AppSetting.f99565y) {
                    TextView textView2 = this.B0;
                    if (TextUtils.isEmpty(string2)) {
                        string2 = this.f174746z0;
                    }
                    textView2.setContentDescription(string2);
                }
            } else if (i26 == 3) {
                URLDrawable drawable = URLDrawable.getDrawable(FaceDrawable.getOpenIdUrl(this.f174746z0, intent.getStringExtra("extra")), URLDrawable.URLDrawableOptions.obtain());
                if (QQTheme.isNowSimpleUI()) {
                    this.C0.setImageDrawable(drawable);
                } else {
                    b3(drawable);
                }
                this.B0.setText(string2);
                if (AppSetting.f99565y) {
                    this.B0.setContentDescription(string2);
                }
                ((IFriendHandlerService) this.app.getRuntimeService(IFriendHandlerService.class)).requestInfoWithOpenId(this.f174746z0, getIntent().getStringExtra("extra"));
            } else {
                if (i19 != 3007 && i19 != 2007 && i19 != 4007 && i19 != 3019 && i19 != 2019) {
                    this.C0.setImageDrawable(FaceDrawable.getFaceDrawable(this.app, 1, this.f174746z0));
                } else {
                    this.C0.setImageDrawable(FaceDrawable.getStrangerFaceDrawable((AppInterface) this.app, 200, this.f174746z0, true));
                }
                if (!f3()) {
                    ThreadManager.getSubThreadHandler().post(new Runnable(string2) { // from class: com.tencent.mobileqq.activity.AddFriendVerifyActivity.2
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ String f174748d;

                        {
                            this.f174748d = string2;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AddFriendVerifyActivity.this, (Object) string2);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else {
                                ThreadManager.getUIHandler().post(new Runnable(((FriendsManager) AddFriendVerifyActivity.this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).F(AddFriendVerifyActivity.this.f174746z0)) { // from class: com.tencent.mobileqq.activity.AddFriendVerifyActivity.2.1
                                    static IPatchRedirector $redirector_;

                                    /* renamed from: d, reason: collision with root package name */
                                    final /* synthetic */ String f174749d;

                                    {
                                        this.f174749d = r5;
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this, (Object) r5);
                                        }
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        String str3;
                                        String str4;
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                            iPatchRedirector3.redirect((short) 2, (Object) this);
                                            return;
                                        }
                                        if (AddFriendVerifyActivity.this.B0.isShown()) {
                                            TextView textView3 = AddFriendVerifyActivity.this.B0;
                                            if (TextUtils.isEmpty(AnonymousClass2.this.f174748d)) {
                                                str3 = this.f174749d;
                                            } else {
                                                str3 = AnonymousClass2.this.f174748d;
                                            }
                                            textView3.setText(str3);
                                            if (AppSetting.f99565y) {
                                                TextView textView4 = AddFriendVerifyActivity.this.B0;
                                                if (TextUtils.isEmpty(AnonymousClass2.this.f174748d)) {
                                                    str4 = this.f174749d;
                                                } else {
                                                    str4 = AnonymousClass2.this.f174748d;
                                                }
                                                textView4.setContentDescription(str4);
                                            }
                                        }
                                    }
                                });
                            }
                        }
                    });
                } else if (string2 != null) {
                    this.B0.setText(string2);
                    if (AppSetting.f99565y) {
                        this.B0.setContentDescription(string2);
                    }
                }
            }
            int intExtra3 = intent.getIntExtra("friend_setting", 0);
            ArrayList<String> stringArrayList = getIntent().getExtras().getStringArrayList("user_question");
            String str3 = " subSourceId = ";
            String str4 = "reportClickEvent action: 0X80077AF  sourceId = ";
            if (intExtra3 != 0) {
                if (intExtra3 == 1) {
                    str = "extra";
                    this.f174723c0.setVisibility(0);
                    this.f174733m0.setVisibility(0);
                    if (AppSetting.f99565y) {
                        EditText editText = this.f174723c0;
                        editText.setContentDescription(editText.getText().toString());
                        this.f174733m0.setContentDescription(getString(R.string.f170053e3));
                    }
                    setRightHighlightButton(R.string.a1p, new m(i19, intExtra2, intExtra3));
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f174727g0.getLayoutParams();
                    layoutParams2.addRule(3, this.f174723c0.getId());
                    layoutParams2.topMargin = BaseAIOUtils.f(20.0f, getResources());
                    this.f174727g0.setLayoutParams(layoutParams2);
                    ReportController.o(this.app, "dc00898", "", "", "0X80077AF", "0X80077AF", 1, 0, String.valueOf(i19), String.valueOf(intExtra2), "", "");
                    if (QLog.isColorLevel()) {
                        QLog.d("AddFriendVerifyActivity", 2, "reportClickEvent action: 0X80077AF  sourceId = " + i19 + " subSourceId = " + intExtra2);
                    }
                } else if (intExtra3 != 2) {
                    if (intExtra3 == 3) {
                        str = "extra";
                        this.f174724d0.setVisibility(0);
                        String str5 = stringArrayList.get(0);
                        TextView textView3 = (TextView) this.f174724d0.findViewById(R.id.textView1);
                        EditText editText2 = (EditText) this.f174724d0.findViewById(R.id.dmu);
                        r rVar2 = new r(50, editText2);
                        this.K0 = rVar2;
                        editText2.addTextChangedListener(rVar2);
                        textView3.setText(getString(R.string.g3d) + ":" + str5);
                        editText2.setSingleLine(true);
                        if (V0) {
                            textView3.setContentDescription(getString(R.string.g3d) + ":" + str5);
                            editText2.setContentDescription(getString(R.string.f170050e0));
                        }
                        setRightHighlightButton(R.string.a1p, new n(editText2, intExtra3, i19, intExtra2));
                        getWindow().setSoftInputMode(5);
                        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f174727g0.getLayoutParams();
                        layoutParams3.addRule(3, this.f174724d0.getId());
                        layoutParams3.topMargin = BaseAIOUtils.f(20.0f, getResources());
                        this.f174727g0.setLayoutParams(layoutParams3);
                        ReportController.o(this.app, "dc00898", "", "", "0X80077AF", "0X80077AF", 3, 0, String.valueOf(i19), String.valueOf(intExtra2), "", "");
                        if (QLog.isColorLevel()) {
                            QLog.d("AddFriendVerifyActivity", 2, "reportClickEvent action: 0X80077AF  sourceId = " + i19 + " subSourceId = " + intExtra2);
                        }
                    } else if (intExtra3 == 4) {
                        this.f174725e0.setVisibility(0);
                        StringBuffer stringBuffer = new StringBuffer();
                        boolean z18 = stringArrayList != null && stringArrayList.size() == 1;
                        int i27 = 0;
                        while (true) {
                            if (i27 >= (stringArrayList != null ? stringArrayList.size() : 0)) {
                                break;
                            }
                            if (i27 != 0) {
                                if (i27 == i18) {
                                    string = getResources().getString(R.string.g3g);
                                } else if (i27 == 2) {
                                    string = getResources().getString(R.string.g3h);
                                } else if (i27 == 3) {
                                    string = getResources().getString(R.string.g3i);
                                } else if (i27 != 4) {
                                    string = getResources().getString(R.string.g3d);
                                } else {
                                    string = getResources().getString(R.string.g3j);
                                }
                            } else if (z18) {
                                string = getResources().getString(R.string.g3e);
                            } else {
                                string = getResources().getString(R.string.g3f);
                            }
                            boolean z19 = z18;
                            String str6 = str4;
                            String str7 = str3;
                            View inflate = getLayoutInflater().inflate(R.layout.aq_, (ViewGroup) this.f174725e0, false);
                            String str8 = str2;
                            View inflate2 = getLayoutInflater().inflate(R.layout.aq9, (ViewGroup) this.f174725e0, false);
                            if (i27 > 0 && (layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams()) != null) {
                                layoutParams.topMargin = (int) com.tencent.mobileqq.utils.al.a(getApplication(), 19.0f);
                                inflate.setLayoutParams(layoutParams);
                            }
                            this.f174725e0.addView(inflate);
                            this.f174725e0.addView(inflate2);
                            String str9 = stringArrayList.get(i27);
                            TextView textView4 = (TextView) inflate.findViewById(R.id.textView1);
                            textView4.setText(string + str9);
                            EditText editText3 = (EditText) inflate2.findViewById(R.id.dmu);
                            editText3.addTextChangedListener(new r(50, editText3));
                            this.f174722b0.add(editText3);
                            if (V0) {
                                textView4.setContentDescription(string + str9);
                                this.f174722b0.get(i27).setContentDescription(getString(R.string.f170050e0));
                            }
                            i27++;
                            stringBuffer.append(getString(R.string.g3d) + i27 + ":" + str9);
                            stringBuffer.append("\n");
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append(getString(R.string.f170342mu));
                            sb5.append(":${answer}");
                            stringBuffer.append(sb5.toString());
                            if (i27 != stringArrayList.size()) {
                                stringBuffer.append("\n");
                            }
                            z18 = z19;
                            str4 = str6;
                            str3 = str7;
                            str2 = str8;
                            i18 = 1;
                        }
                        String str10 = str4;
                        String str11 = str3;
                        str = str2;
                        setRightHighlightButton(R.string.a1p, new o(stringBuffer, i19, intExtra2, intExtra3));
                        findViewById(R.id.idg).setOnTouchListener(new p());
                        getWindow().setSoftInputMode(4);
                        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f174727g0.getLayoutParams();
                        layoutParams4.addRule(3, this.f174725e0.getId());
                        layoutParams4.topMargin = BaseAIOUtils.f(20.0f, getResources());
                        this.f174727g0.setLayoutParams(layoutParams4);
                        ReportController.o(this.app, "dc00898", "", "", "0X80077AF", "0X80077AF", 4, 0, String.valueOf(i19), String.valueOf(intExtra2), "", "");
                        if (QLog.isColorLevel()) {
                            QLog.d("AddFriendVerifyActivity", 2, str10 + i19 + str11 + intExtra2);
                        }
                    }
                }
                i3 = 3;
                if (this.A0 != i3) {
                    String stringExtra2 = intent.getStringExtra("is_from_game");
                    String stringExtra3 = intent.getStringExtra(str);
                    try {
                        com.tencent.mobileqq.config.business.aw d16 = com.tencent.mobileqq.config.al.d(BaseApplicationImpl.getApplication());
                        if (("true".equals(stringExtra2) || d16.a()) && !TextUtils.isEmpty(stringExtra3)) {
                            ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).checkApiState(this.app, getApplicationContext(), stringExtra3, this, 1003, null);
                            if (QLog.isColorLevel()) {
                                QLog.d("AddFriendVerifyActivity", 2, "AddFriend enableCheckPermission = " + d16.a());
                            }
                        }
                        z16 = true;
                    } catch (Exception e16) {
                        if ("true".equals(stringExtra2) && !TextUtils.isEmpty(stringExtra3)) {
                            ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).checkApiState(this.app, getApplicationContext(), stringExtra3, this, 1003, null);
                        }
                        z16 = true;
                        QLog.d("AddFriendVerifyActivity", 1, "AddFriend loadConfig exception = " + e16);
                    }
                    i16 = 8;
                    this.f174727g0.setVisibility(8);
                } else {
                    z16 = true;
                    i16 = 8;
                }
                enableRightHighlight(z16);
                updateRightTvTextColor();
                if (QidianManager.P(this.app, this.f174746z0)) {
                    this.f174734n0.setVisibility(i16);
                }
                this.M0 = getIntent().getStringExtra("webImVisitId");
                return true;
            }
            str = "extra";
            if (i19 != 3078 && i19 != 3079) {
                setRightHighlightButton(R.string.a1p, new l(i19, intExtra2));
                RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.f174727g0.getLayoutParams();
                layoutParams5.addRule(3, this.C0.getId());
                layoutParams5.topMargin = BaseAIOUtils.f(20.0f, getResources());
                this.f174727g0.setLayoutParams(layoutParams5);
                ReportController.o(this.app, "dc00898", "", "", "0X80077AF", "0X80077AF", 2, 0, String.valueOf(i19), String.valueOf(intExtra2), "", "");
                if (QLog.isColorLevel()) {
                    QLog.d("AddFriendVerifyActivity", 2, "reportClickEvent action: 0X80077AF  sourceId = " + i19 + " subSourceId = " + intExtra2);
                }
                Y2(i19, intExtra3);
                i3 = 3;
                if (this.A0 != i3) {
                }
                enableRightHighlight(z16);
                updateRightTvTextColor();
                if (QidianManager.P(this.app, this.f174746z0)) {
                }
                this.M0 = getIntent().getStringExtra("webImVisitId");
                return true;
            }
            this.f174723c0.setVisibility(0);
            this.f174733m0.setVisibility(0);
            this.f174733m0.setText(getString(R.string.f170040dn));
            this.C0.setVisibility(8);
            this.B0.setVisibility(8);
            this.f174734n0.setVisibility(8);
            if (AppSetting.f99565y) {
                EditText editText4 = this.f174723c0;
                editText4.setContentDescription(editText4.getText().toString());
                this.f174733m0.setContentDescription(getString(R.string.f170053e3));
            }
            this.f174727g0.setVisibility(8);
            setRightHighlightButton(R.string.a1p, new k(getIntent() != null ? getIntent().getIntExtra("contact_from_type", 1) : 1));
            RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.f174727g0.getLayoutParams();
            i3 = 3;
            layoutParams6.addRule(3, this.f174723c0.getId());
            layoutParams6.topMargin = BaseAIOUtils.f(20.0f, getResources());
            this.f174727g0.setLayoutParams(layoutParams6);
            if (this.A0 != i3) {
            }
            enableRightHighlight(z16);
            updateRightTvTextColor();
            if (QidianManager.P(this.app, this.f174746z0)) {
            }
            this.M0 = getIntent().getStringExtra("webImVisitId");
            return true;
        }
        str = "extra";
        i3 = 3;
        if (this.A0 != i3) {
        }
        enableRightHighlight(z16);
        updateRightTvTextColor();
        if (QidianManager.P(this.app, this.f174746z0)) {
        }
        this.M0 = getIntent().getStringExtra("webImVisitId");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        Dialog dialog = this.f174744x0;
        if (dialog != null && dialog.isShowing() && this.f174744x0.getWindow() != null) {
            try {
                this.f174744x0.dismiss();
            } catch (Throwable unused) {
            }
        }
        getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this.T0);
        super.doOnDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't wrap try/catch for region: R(18:13|(1:15)(1:51)|16|(1:18)|19|(1:21)(2:45|(2:47|(12:49|23|(1:25)|26|(1:28)|(1:34)|35|36|(1:38)(1:43)|39|40|41))(1:50))|22|23|(0)|26|(0)|(3:30|32|34)|35|36|(0)(0)|39|40|41) */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ff A[Catch: all -> 0x0116, TRY_ENTER, TryCatch #1 {all -> 0x0116, blocks: (B:38:0x00ff, B:43:0x010d), top: B:36:0x00fd }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x010d A[Catch: all -> 0x0116, TRY_LEAVE, TryCatch #1 {all -> 0x0116, blocks: (B:38:0x00ff, B:43:0x010d), top: B:36:0x00fd }] */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doOnResume() {
        String str;
        String str2;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.doOnResume();
        if (this.A0 != 4) {
            boolean z17 = false;
            int intExtra = getIntent().getIntExtra("friend_setting", 0);
            if (intExtra != 0) {
                if (intExtra == 1) {
                    String string = getString(R.string.axv);
                    if (getIntent().getBooleanExtra("_FROM_QLINK_", false)) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(string);
                        sb5.append(getString(R.string.f4f));
                        sb5.append(" ");
                        QQAppInterface qQAppInterface = this.app;
                        sb5.append(com.tencent.mobileqq.utils.ac.F(qQAppInterface, qQAppInterface.getAccount()));
                        str = sb5.toString();
                        this.f174723c0.setHint(str);
                    } else {
                        this.f174723c0.setHint("");
                        str = string;
                    }
                    this.f174723c0.setVisibility(0);
                    this.f174733m0.setVisibility(0);
                    if (AppSetting.f99565y) {
                        EditText editText = this.f174723c0;
                        editText.setContentDescription(editText.getText().toString());
                        this.f174733m0.setContentDescription(getString(R.string.f170053e3));
                    }
                    if (this.A0 == 3) {
                        str2 = getIntent().getStringExtra("msg");
                    } else {
                        KplRoleInfo.WZRYUIinfo wZRYUIinfo = this.L0;
                        if (wZRYUIinfo != null) {
                            str2 = wZRYUIinfo.verifyMsg;
                            if (!TextUtils.isEmpty(str2)) {
                                z16 = false;
                                if (TextUtils.isEmpty(str2)) {
                                    str2 = c3(false);
                                }
                                if (!TextUtils.isEmpty(str2)) {
                                    str = str2;
                                }
                                if (z16 && string.equals(str) && !d3()) {
                                    StringBuilder sb6 = new StringBuilder();
                                    sb6.append(str);
                                    QQAppInterface qQAppInterface2 = this.app;
                                    sb6.append(com.tencent.mobileqq.utils.ac.F(qQAppInterface2, qQAppInterface2.getAccount()));
                                    str = sb6.toString();
                                    z17 = true;
                                }
                                this.f174723c0.setText(str);
                                if (!z17) {
                                    this.f174723c0.setSelection(string.length(), str.length());
                                } else {
                                    this.f174723c0.setSelection(str.length());
                                }
                                getWindow().setSoftInputMode(5);
                                return;
                            }
                        } else {
                            str2 = null;
                        }
                    }
                    z16 = true;
                    if (TextUtils.isEmpty(str2)) {
                    }
                    if (!TextUtils.isEmpty(str2)) {
                    }
                    if (z16) {
                        StringBuilder sb62 = new StringBuilder();
                        sb62.append(str);
                        QQAppInterface qQAppInterface22 = this.app;
                        sb62.append(com.tencent.mobileqq.utils.ac.F(qQAppInterface22, qQAppInterface22.getAccount()));
                        str = sb62.toString();
                        z17 = true;
                    }
                    this.f174723c0.setText(str);
                    if (!z17) {
                    }
                    getWindow().setSoftInputMode(5);
                    return;
                }
                return;
            }
            int i3 = this.f174742v0;
            if (i3 == 3078 || i3 == 3079) {
                String c36 = c3(false);
                String string2 = getString(R.string.axv);
                if (TextUtils.isEmpty(c36)) {
                    if (!d3()) {
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append(string2);
                        QQAppInterface qQAppInterface3 = this.app;
                        sb7.append(com.tencent.mobileqq.utils.ac.F(qQAppInterface3, qQAppInterface3.getAccount()));
                        c36 = sb7.toString();
                        z17 = true;
                    } else {
                        c36 = string2;
                    }
                }
                this.f174723c0.setHint("");
                this.f174723c0.setText(c36);
                try {
                    if (z17) {
                        this.f174723c0.setSelection(string2.length(), c36.length());
                    } else if (!TextUtils.isEmpty(c36)) {
                        this.f174723c0.setSelection(c36.length());
                    }
                } catch (Throwable unused) {
                }
                getWindow().setSoftInputMode(5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.doOnStart();
        com.tencent.mobileqq.friend.observer.a aVar = this.R0;
        if (aVar != null) {
            addObserver(aVar);
        }
        ProfileCardObserver profileCardObserver = this.Q0;
        if (profileCardObserver != null) {
            addObserver(profileCardObserver);
        }
        com.tencent.qidian.controller.a aVar2 = this.S0;
        if (aVar2 != null) {
            addObserver(aVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.doOnStop();
        com.tencent.mobileqq.friend.observer.a aVar = this.R0;
        if (aVar != null) {
            removeObserver(aVar);
        }
        ProfileCardObserver profileCardObserver = this.Q0;
        if (profileCardObserver != null) {
            removeObserver(profileCardObserver);
        }
        com.tencent.qidian.controller.a aVar2 = this.S0;
        if (aVar2 != null) {
            removeObserver(aVar2);
        }
    }

    void e3() {
        if (getIntent().getBooleanExtra("need_jumpto_splash", false)) {
            Intent aliasIntent = SplashActivity.getAliasIntent(this);
            aliasIntent.putExtra(SplashActivity.FRAGMENT_ID, 1);
            aliasIntent.putExtra("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183038a);
            aliasIntent.setFlags(67108864);
            startActivity(aliasIntent);
            finish();
            return;
        }
        String stringExtra = getIntent().getStringExtra("param_return_addr");
        if (QLog.isColorLevel()) {
            QLog.d("AddFriendVerifyActivity", 2, "goBack | retAddr = " + stringExtra);
        }
        if (stringExtra != null) {
            try {
                Class<?> profileCardActivityClass = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getProfileCardActivityClass();
                Class<?> cls = Class.forName(stringExtra);
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(MainService.QQPROCESSNAME, cls.getName()));
                if (cls.equals(profileCardActivityClass) || cls.equals(QidianProfileCardActivity.class)) {
                    ProfileActivity.F2(this, this.f174746z0, intent);
                }
                intent.setFlags(67108864);
                intent.putExtra("key_back_from_add_friend", true);
                startActivity(intent);
                return;
            } catch (ClassNotFoundException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("AddFriendVerifyActivity", 2, "goBack | exception = ", e16);
                }
                e16.printStackTrace();
                setResult(-1);
                finish();
                return;
            }
        }
        if (getIntent().getBooleanExtra("from_newer_guide", false)) {
            Intent intent2 = new Intent();
            intent2.putExtra("has_operation", true);
            intent2.putExtra("uin", this.f174746z0);
            setResult(-1, intent2);
        } else {
            Z2(0, "");
            setResult(-1);
        }
        finish();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        Intent intent = new Intent("com.tencent.mobileqq.JoinTroopUtil.RET_ACTION");
        intent.setPackage(getPackageName());
        intent.putExtra("ret_action", this.P0);
        sendBroadcast(intent);
        ((InputMethodManager) getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(this.leftView.getWindowToken(), 0);
        getWindow().setSoftInputMode(2);
        super.finish();
        if (this.A0 != 4) {
            overridePendingTransition(0, R.anim.f154458a7);
        }
    }

    void i3(String str) {
        ArrayList arrayList;
        if (!NetworkUtil.isNetSupport(this)) {
            QQToast.makeText(this.app.getApp(), 1, getString(R.string.f173065h22), 0).show(getTitleBarHeight());
            return;
        }
        if (getIntent().hasExtra("contacts") && (arrayList = (ArrayList) getIntent().getSerializableExtra("contacts")) != null && arrayList.size() > 0) {
            if (this.f174721a0 == null) {
                QQProgressDialog qQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
                this.f174721a0 = qQProgressDialog;
                qQProgressDialog.setOnDismissListener(new b());
            }
            this.f174721a0.setCancelable(true);
            this.f174721a0.setCanceledOnTouchOutside(false);
            this.f174721a0.setMessage(R.string.hex);
            this.f174721a0.show();
            this.I0.clear();
            this.I0.addAll(arrayList);
            ((IFriendHandlerService) this.f174745y0.app.getRuntimeService(IFriendHandlerService.class, "")).requestAddBatchPhoneFriend(this.I0, str, 0, this.f174742v0, new ArrayList<>());
        }
    }

    void n3(String str, boolean z16) {
        if (this.L0 != null) {
            if (QLog.isColorLevel()) {
                QLog.d("AddFriendVerifyActivity", 2, "saveVerifyMsg return from wzry");
                return;
            }
            return;
        }
        SharedPreferences sharedPreferences = getSharedPreferences("last_verify_msg", 0);
        if (z16) {
            sharedPreferences.edit().putString("last_add_troop_verfity_" + this.app.getAccount(), str).commit();
            return;
        }
        sharedPreferences.edit().putString("last_add_friend_verify_" + this.app.getAccount(), str).commit();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        j3();
        boolean z16 = false;
        if (getIntent().getBooleanExtra("need_jumpto_splash", false)) {
            Intent aliasIntent = SplashActivity.getAliasIntent(this);
            aliasIntent.putExtra(SplashActivity.FRAGMENT_ID, 1);
            aliasIntent.putExtra("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183038a);
            aliasIntent.setFlags(67108864);
            startActivity(aliasIntent);
            return super.onBackEvent();
        }
        if (this.A0 != 4) {
            String obj = this.f174723c0.getText().toString();
            if (4 == this.A0) {
                z16 = true;
            }
            n3(obj, z16);
            if (getString(R.string.axv).equals(obj) && !d3()) {
                h3();
            }
        }
        if (!TextUtils.isEmpty(this.M0)) {
            ReportController.o(this.app, "dc00899", "Qidian", this.f174746z0, "0X8008802", "ClickAddFriendButton", 0, 0, "2", "", "", "");
        }
        return super.onBackEvent();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, compoundButton, Boolean.valueOf(z16));
        } else if (!NetworkUtil.isNetSupport(this)) {
            QQToast.makeText(this, 1, R.string.f171139ci4, 0).show(getTitleBarHeight());
            Switch r36 = this.f174736p0;
            if (r36 != null) {
                r36.setChecked(!z16);
                this.f174736p0.setOnClickListener(null);
            }
            Switch r37 = this.f174738r0;
            if (r37 != null) {
                r37.setChecked(!z16);
                this.f174738r0.setOnClickListener(null);
            }
        } else {
            Switch r38 = this.f174736p0;
            if (r38 != null) {
                r38.setOnClickListener(this);
            }
            Switch r39 = this.f174738r0;
            if (r39 != null) {
                r39.setOnClickListener(this);
            }
            if (compoundButton == this.f174736p0) {
                if (AppSetting.f99565y) {
                    this.f174735o0.setContentDescription(getResources().getString(R.string.giz));
                }
                Intent intent = new Intent("com.tencent.qzone.action.OperateQZonePermission");
                intent.setPackage(BaseApplication.getContext().getPackageName());
                intent.setClassName(BaseApplication.getContext().getPackageName(), QZoneHelper.BROADCAST_RECEIVER_PERMISSION);
                intent.putExtra("qzone_permission_uin", this.f174746z0);
                intent.putExtra("qzone_permission_operateType", 1);
                intent.putExtra("qzone_permission_value", z16);
                this.app.getApp().sendBroadcast(intent);
                ReportController.o(this.app, "dc00898", "", "", "0X80077B3", "0X80077B3", 0, 0, "", "", "", "");
            } else if (compoundButton == this.f174738r0) {
                this.f174739s0 = z16;
            }
            if ((compoundButton.getTag() instanceof Integer) && ((TroopManager) this.app.getManager(QQManagerFactory.TROOP_MANAGER)) != null) {
                String str = this.D0;
            }
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) view);
        } else if (view.getId() == R.id.ici) {
            Intent putExtra = new Intent(this, (Class<?>) MoveToGroupActivity.class).putExtra("friendUin", this.f174746z0).putExtra("mgid", (byte) this.f174740t0);
            putExtra.putExtra("PARAM_EXECUTE_IMMEDIATELY", false);
            startActivityForResult(putExtra, 1002);
            EditText editText = this.f174723c0;
            if (editText != null) {
                n3(editText.getText().toString(), false);
            }
            ReportController.o(this.app, "dc00898", "", "", "0X80077B2", "0X80077B2", 0, 0, "", "", "", "");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
        }
        if (view.getId() == R.id.dmu) {
            int action = motionEvent.getAction() & 255;
            if (action != 0) {
                if (action == 1 || action == 3) {
                    view.getParent().requestDisallowInterceptTouchEvent(false);
                }
            } else {
                view.getParent().requestDisallowInterceptTouchEvent(true);
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.troop.utils.e.a
    public void rg(JSONObject jSONObject, int i3, Bundle bundle) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONArray jSONArray3;
        String str;
        JSONArray jSONArray4;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, jSONObject, Integer.valueOf(i3), bundle);
            return;
        }
        if (i3 == 1003 && jSONObject != null) {
            try {
                int intValue = ((Integer) jSONObject.get("retcode")).intValue();
                JSONObject jSONObject2 = (JSONObject) jSONObject.get("result");
                if (intValue == 0 && jSONObject2 != null) {
                    if (QLog.isColorLevel()) {
                        QLog.i("AddFriendVerifyActivity", 2, "checkApiState onResult. retCode = " + intValue + "\n");
                    }
                    JSONObject jSONObject3 = (JSONObject) jSONObject2.get(Constants.Configs.BASICS);
                    String str3 = "msg";
                    String str4 = DTConstants.TAG.API;
                    if (jSONObject3 != null && (jSONArray4 = (JSONArray) jSONObject3.get("datas")) != null) {
                        int i16 = 0;
                        while (i16 < jSONArray4.length()) {
                            JSONObject jSONObject4 = (JSONObject) jSONArray4.get(i16);
                            String str5 = (String) jSONObject4.get("name");
                            int intValue2 = ((Integer) jSONObject4.get("state")).intValue();
                            JSONArray jSONArray5 = jSONArray4;
                            String str6 = (String) jSONObject4.get(DTConstants.TAG.API);
                            String str7 = (String) jSONObject4.get(str3);
                            if (QLog.isColorLevel()) {
                                StringBuilder sb5 = new StringBuilder();
                                str2 = str3;
                                sb5.append("checkApiState onResult, basics name = ");
                                sb5.append(str5);
                                sb5.append(" state = ");
                                sb5.append(intValue2);
                                sb5.append(" api = ");
                                sb5.append(str6);
                                sb5.append(" msg = ");
                                sb5.append(str7);
                                sb5.append("\n");
                                QLog.i("AddFriendVerifyActivity", 2, sb5.toString());
                            } else {
                                str2 = str3;
                            }
                            i16++;
                            jSONArray4 = jSONArray5;
                            str3 = str2;
                        }
                    }
                    String str8 = str3;
                    JSONObject jSONObject5 = (JSONObject) jSONObject2.get("friendlink");
                    if (jSONObject5 != null && (jSONArray3 = (JSONArray) jSONObject5.get("datas")) != null) {
                        int i17 = 0;
                        while (i17 < jSONArray3.length()) {
                            JSONObject jSONObject6 = (JSONObject) jSONArray3.get(i17);
                            String str9 = (String) jSONObject6.get("name");
                            int intValue3 = ((Integer) jSONObject6.get("state")).intValue();
                            String str10 = (String) jSONObject6.get(str4);
                            JSONArray jSONArray6 = jSONArray3;
                            String str11 = str8;
                            String str12 = (String) jSONObject6.get(str11);
                            str8 = str11;
                            if (LpReportInfo_dc04586.ITEM_ID_BTN_ADD_FRIEND.equals(str10) && intValue3 != 1) {
                                try {
                                    str = str4;
                                    p3(getActivity().getResources().getString(R.string.f173230i72));
                                } catch (Exception e16) {
                                    e = e16;
                                    if (QLog.isColorLevel()) {
                                        QLog.d("AddFriendVerifyActivity", 2, "checkApiState onResult " + e.toString());
                                        return;
                                    }
                                    return;
                                }
                            } else {
                                str = str4;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.i("AddFriendVerifyActivity", 2, "checkApiState onResult, friendlink name = " + str9 + " state = " + intValue3 + " api = " + str10 + " msg= " + str12 + "\n");
                            }
                            i17++;
                            jSONArray3 = jSONArray6;
                            str4 = str;
                        }
                    }
                    String str13 = str4;
                    int intValue4 = ((Integer) jSONObject2.get("appid")).intValue();
                    if (QLog.isColorLevel()) {
                        QLog.i("AddFriendVerifyActivity", 2, "checkApiState onResult, appid =" + intValue4 + "\n");
                    }
                    JSONObject jSONObject7 = (JSONObject) jSONObject2.get(PreDownloadConstants.DEPARTMENT_QQPAY);
                    if (jSONObject7 != null && (jSONArray = (JSONArray) jSONObject7.get("datas")) != null) {
                        int i18 = 0;
                        while (i18 < jSONArray.length()) {
                            JSONObject jSONObject8 = (JSONObject) jSONArray.get(i18);
                            String str14 = (String) jSONObject8.get("name");
                            int intValue5 = ((Integer) jSONObject8.get("state")).intValue();
                            String str15 = str13;
                            String str16 = (String) jSONObject8.get(str15);
                            String str17 = str8;
                            String str18 = (String) jSONObject8.get(str17);
                            if (QLog.isColorLevel()) {
                                StringBuilder sb6 = new StringBuilder();
                                jSONArray2 = jSONArray;
                                sb6.append("checkApiState onResult, qqpay name = ");
                                sb6.append(str14);
                                sb6.append(" state = ");
                                sb6.append(intValue5);
                                sb6.append(" api = ");
                                sb6.append(str16);
                                sb6.append(" msg= ");
                                sb6.append(str18);
                                sb6.append("\n");
                                QLog.i("AddFriendVerifyActivity", 2, sb6.toString());
                            } else {
                                jSONArray2 = jSONArray;
                            }
                            i18++;
                            jSONArray = jSONArray2;
                            str13 = str15;
                            str8 = str17;
                        }
                    }
                }
            } catch (Exception e17) {
                e = e17;
            }
        }
    }

    void t3(String str, byte[] bArr, String str2) {
        boolean z16;
        if (!NetworkUtil.isNetSupport(this)) {
            QQToast.makeText(this.app.getApp(), 1, getString(R.string.cjm), 0).show(getTitleBarHeight());
            return;
        }
        if (isFinishing()) {
            return;
        }
        if (this.f174721a0 == null) {
            QQProgressDialog qQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
            this.f174721a0 = qQProgressDialog;
            qQProgressDialog.setOnDismissListener(new a());
        }
        this.f174721a0.setMessage(R.string.hex);
        this.f174721a0.setCancelable(true);
        this.f174721a0.setCanceledOnTouchOutside(false);
        try {
            this.f174721a0.show();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("AddFriendVerifyActivity", 2, e16.toString());
            }
        }
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("sub_source_id", 0);
        int intExtra2 = intent.getIntExtra("friend_setting", 0);
        if (intExtra2 == 3) {
            intExtra2 = 100;
        }
        int i3 = intExtra2;
        boolean booleanExtra = intent.getBooleanExtra("contact_bothway", false);
        ((IFriendHandlerService) this.app.getRuntimeService(IFriendHandlerService.class)).requestAddFriendWithMyCard(this.f174746z0, intent.getStringExtra("extra"), i3, (byte) this.f174740t0, str, this.f174742v0, intExtra, true, bArr, booleanExtra, this.f174731k0.getText().toString(), intent.getStringExtra("src_name"), intent.getByteExtra("show_my_card", (byte) 0), str2, intent.getBundleExtra("flc_extra_param"), false);
        if (!((IAddFriendApi) QRoute.api(IAddFriendApi.class)).couldAddFriendSuccessDirectly(i3, this.f174742v0, booleanExtra)) {
            ((FriendsManager) this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).y0(this.f174746z0, true);
        }
        if (!this.f174731k0.getText().toString().equals(this.f174741u0)) {
            ReportController.o(this.app, "dc00898", "", "", "0X80077B1", "0X80077B1", 0, 0, "", "", "", "");
        }
        if (intent.getIntExtra("sort_id", 0) == 3090) {
            ReportController.o(this.app, "CliOper", "", "", "0x80084AE", "0x80084AE", 0, 0, "", "", "", "");
        }
        if (this.f174742v0 == 3050 && this.f174743w0 == 3) {
            HashMap<String, String> hashMap = new HashMap<>();
            if (this.f174738r0 != null && (z16 = this.f174739s0)) {
                QFSFollowView.d(this.f174746z0, z16);
                hashMap.put("ext3", "1");
            } else {
                hashMap.put("ext3", "2");
            }
            ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setToUin(this.f174746z0).setActionType(79).setSubActionType(2).setThrActionType(0).setExtras(hashMap));
            if (intent.getBooleanExtra("key_qcircle_stick", false) && TextUtils.isEmpty(str2)) {
                ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setToUin(this.f174746z0).setActionType(93).setSubActionType(2).setThrActionType(2));
            }
        }
        if (this.f174742v0 == 3094) {
            if (intExtra == 1) {
                ReportController.r(this.app, "dc00898", "", this.f174746z0, "0X80092E3", "0X80092E3", 0, 0, "", ExtendFriendReport.c(), ExtendFriendReport.g(this.app), ExtendFriendReport.d());
                return;
            }
            if (intExtra == 2) {
                QQAppInterface qQAppInterface = this.app;
                ReportController.r(qQAppInterface, "dc00898", "", this.f174746z0, "0X80092CC", "0X80092CC", 0, 0, "", "", ExtendFriendReport.g(qQAppInterface), "");
            } else if (intExtra == 8) {
                ReportController.r(this.app, "dc00898", "", this.f174746z0, "0X800A69D", "0X800A69D", this.N0, 0, "", "", "", "");
            } else if (intExtra == 9) {
                ReportController.r(this.app, "dc00898", "", this.f174746z0, "0X800A69D", "0X800A69D", this.N0, 0, "", "", "", "");
            }
        }
    }
}
