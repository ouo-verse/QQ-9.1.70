package com.tencent.mobileqq.addfriend.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.biz.richframework.part.Part;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.abtest.api.IAddFriendTabApi;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.selectmember.api.IForwardApi;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.addfriend.api.IAddFriendServiceApi;
import com.tencent.mobileqq.addfriend.config.AddFriendOpenSdkConfigParser;
import com.tencent.mobileqq.addfriend.handler.AddFriendHandler;
import com.tencent.mobileqq.addfriend.part.OpenAddFriendPart;
import com.tencent.mobileqq.addfriend.strategy.IAddAcceptBlockStrategy;
import com.tencent.mobileqq.addfriend.widget.FlowLabelLayout;
import com.tencent.mobileqq.app.AddBatchPhoneFriendResult;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.KplRoleInfo;
import com.tencent.mobileqq.data.LabelTag;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.dt.api.IDTAPI;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.friend.api.IFriendHandlerService;
import com.tencent.mobileqq.guild.api.IGuildAddQQFriendApi;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendDataUtilApi;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.newfriend.api.INewFriendVerificationService;
import com.tencent.mobileqq.newnearby.INearbyAddFriendHelper;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.pad.SplitViewState;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolService;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.troop.utils.e;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.util.ab;
import com.tencent.mobileqq.util.ay;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.widget.FriendPermissionsSwitch;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqnt.kernel.nativeinterface.BuddySource;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqprotect.qsec.api.IO3ReportApi;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import com.tencent.raft.codegenmeta.utils.Constants;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.report.lp.LpReportInfo_dc04586;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.apache.commons.lang.CharEncoding;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class AddFriendVerifyFragment extends QIphoneTitleBarFragment implements View.OnTouchListener, View.OnClickListener, e.a, TextWatcher {
    static IPatchRedirector $redirector_;
    public static final boolean K0;
    private static boolean L0;
    private static final HashMap<Integer, Integer> M0;
    private com.tencent.mobileqq.addfriend.helper.a A0;
    private ArrayList<com.tencent.mobileqq.addfriend.processor.a> B0;
    private AppInterface C;
    private long C0;
    private String D;
    private OpenAddFriendPart D0;
    private int E;
    protected QQCustomDialog E0;
    private Intent F;
    private ViewTreeObserver.OnGlobalLayoutListener F0;
    private int G;
    private ProfileCardObserver G0;
    private String H;
    private final com.tencent.mobileqq.friend.observer.a H0;
    private String I;
    private com.tencent.qidian.controller.c I0;
    private int J;
    com.tencent.mobileqq.addfriend.observer.a J0;
    private int K;
    private byte[] L;
    private String M;
    private boolean N;
    private boolean P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private int T;
    String U;
    private Bundle V;
    private String W;
    private boolean X;
    private boolean Y;
    private ArrayList<EditText> Z;

    /* renamed from: a0, reason: collision with root package name */
    private ArrayList<TextView> f187379a0;

    /* renamed from: b0, reason: collision with root package name */
    private ArrayList<PhoneContact> f187380b0;

    /* renamed from: c0, reason: collision with root package name */
    x f187381c0;

    /* renamed from: d0, reason: collision with root package name */
    x f187382d0;

    /* renamed from: e0, reason: collision with root package name */
    KplRoleInfo.WZRYUIinfo f187383e0;

    /* renamed from: f0, reason: collision with root package name */
    protected InputMethodManager f187384f0;

    /* renamed from: g0, reason: collision with root package name */
    private TextView f187385g0;

    /* renamed from: h0, reason: collision with root package name */
    private TextView f187386h0;

    /* renamed from: i0, reason: collision with root package name */
    private TextView f187387i0;

    /* renamed from: j0, reason: collision with root package name */
    private TextView f187388j0;

    /* renamed from: k0, reason: collision with root package name */
    private TextView f187389k0;

    /* renamed from: l0, reason: collision with root package name */
    private TextView f187390l0;

    /* renamed from: m0, reason: collision with root package name */
    private EditText f187391m0;

    /* renamed from: n0, reason: collision with root package name */
    private ClearableEditText f187392n0;

    /* renamed from: o0, reason: collision with root package name */
    private Button f187393o0;

    /* renamed from: p0, reason: collision with root package name */
    private ImageView f187394p0;

    /* renamed from: q0, reason: collision with root package name */
    private FlowLabelLayout f187395q0;

    /* renamed from: r0, reason: collision with root package name */
    private Dialog f187396r0;

    /* renamed from: s0, reason: collision with root package name */
    private QQProgressDialog f187397s0;

    /* renamed from: t0, reason: collision with root package name */
    private BounceScrollView f187398t0;

    /* renamed from: u0, reason: collision with root package name */
    private LinearLayout f187399u0;

    /* renamed from: v0, reason: collision with root package name */
    private LinearLayout f187400v0;

    /* renamed from: w0, reason: collision with root package name */
    private LinearLayout f187401w0;

    /* renamed from: x0, reason: collision with root package name */
    private FriendPermissionsSwitch f187402x0;

    /* renamed from: y0, reason: collision with root package name */
    private FormItemRelativeLayout f187403y0;

    /* renamed from: z0, reason: collision with root package name */
    private FormItemRelativeLayout f187404z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendVerifyFragment.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            ((InputMethodManager) AddFriendVerifyFragment.this.getActivity().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(AddFriendVerifyFragment.this.leftView.getWindowToken(), 2);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendVerifyFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                VideoReport.reportEvent("clck", AddFriendVerifyFragment.this.f187390l0, null);
                com.tencent.mobileqq.dt.api.b bVar = new com.tencent.mobileqq.dt.api.b();
                bVar.i("100864");
                bVar.n(AddFriendVerifyFragment.this.D);
                bVar.o(2);
                bVar.j("0");
                bVar.s(1);
                ((IDTAPI) QRoute.api(IDTAPI.class)).jumpReport(AddFriendVerifyFragment.this.getQBaseActivity(), bVar);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendVerifyFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                AddFriendVerifyFragment.this.f187397s0 = null;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class d implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendVerifyFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                AddFriendVerifyFragment.this.f187397s0 = null;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class e implements URLDrawable.URLDrawableListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendVerifyFragment.this);
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
                AddFriendVerifyFragment.this.f187394p0.setImageDrawable(new BitmapDrawable(com.tencent.mobileqq.avatar.utils.c.e(BaseImageUtil.drawabletoBitmap(uRLDrawable), 50, 50)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class f implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f187420d;

        f(String str) {
            this.f187420d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendVerifyFragment.this, (Object) str);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            if (AddFriendVerifyFragment.this.f187396r0 != null && AddFriendVerifyFragment.this.f187396r0.isShowing() && AddFriendVerifyFragment.this.f187396r0.getWindow() != null) {
                try {
                    AddFriendVerifyFragment.this.f187396r0.dismiss();
                    AddFriendVerifyFragment.this.ri(-1, this.f187420d);
                } catch (Throwable unused) {
                }
                AddFriendVerifyFragment.this.f187396r0 = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class g implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendVerifyFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                dialogInterface.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class h implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f187423d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f187424e;

        h(String str, String str2) {
            this.f187423d = str;
            this.f187424e = str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, AddFriendVerifyFragment.this, str, str2);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            try {
                if (!TextUtils.isEmpty(this.f187423d)) {
                    ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(AddFriendVerifyFragment.this.getContext(), this.f187423d, 4018, null);
                } else if (!TextUtils.isEmpty(this.f187424e)) {
                    Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(this.f187424e));
                    intent.putExtra("url", this.f187424e);
                    RouteUtils.startActivity(AddFriendVerifyFragment.this.getContext(), intent, RouterConstants.UI_ROUTE_BROWSER);
                } else {
                    QLog.e("AddFriendVerifyFragment", 1, "showErrorTipsDialogWithHandleAbility, error: url is empty");
                }
            } catch (Exception e16) {
                QLog.e("AddFriendVerifyFragment", 1, "showErrorTipsDialogWithHandleAbility, jump H5/MiniApp error: " + e16.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class i implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendVerifyFragment.this);
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
                QLog.i("AddFriendVerifyFragment", 2, "jumpUrl: mqqapi://miniapp/open?_atype=0&_mappid=1109048181&_mvid=&_path=pages%2Fqq_risk%2Fgood_person%2Fadd_friend%3Ftype%3Dadd_firend&_vt=3&referer=2017&via=tencent_csd&_sig=3708401383" + String.format("&uin=%s", AddFriendVerifyFragment.this.D));
            }
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(AddFriendVerifyFragment.this.getActivity(), "mqqapi://miniapp/open?_atype=0&_mappid=1109048181&_mvid=&_path=pages%2Fqq_risk%2Fgood_person%2Fadd_friend%3Ftype%3Dadd_firend&_vt=3&referer=2017&via=tencent_csd&_sig=3708401383" + String.format("&uin=%s", AddFriendVerifyFragment.this.D), 2017, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class j implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendVerifyFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                ReportController.o(null, "dc00898", "", "", "0X800B992", "0X800B992", 0, 0, "", "", "", "");
                AddFriendVerifyFragment.this.f187396r0.dismiss();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class k implements ViewTreeObserver.OnGlobalLayoutListener {
        static IPatchRedirector $redirector_;

        k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendVerifyFragment.this);
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
            if (AddFriendVerifyFragment.this.Di()) {
                return;
            }
            Rect rect = new Rect();
            AddFriendVerifyFragment.this.getActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            DisplayMetrics displayMetrics = AddFriendVerifyFragment.this.getResources().getDisplayMetrics();
            int max = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
            if (max - (rect.bottom - rect.top) > max / 3) {
                z16 = true;
            } else {
                z16 = false;
            }
            View currentFocus = AddFriendVerifyFragment.this.getActivity().getCurrentFocus();
            if (!z16) {
                if (currentFocus instanceof EditText) {
                    ((EditText) currentFocus).setCursorVisible(false);
                }
                if (currentFocus instanceof ClearableEditText) {
                    ((ClearableEditText) currentFocus).setClearButtonVisible(false);
                    return;
                }
                return;
            }
            if (z16) {
                if (currentFocus instanceof ClearableEditText) {
                    ClearableEditText clearableEditText = (ClearableEditText) currentFocus;
                    if (!AddFriendVerifyFragment.L0 && clearableEditText.equals(AddFriendVerifyFragment.this.f187392n0)) {
                        AddFriendVerifyFragment.this.f187392n0.setTextColor(AddFriendVerifyFragment.this.getResources().getColor(R.color.skin_black));
                        boolean unused = AddFriendVerifyFragment.L0 = true;
                    }
                    if (clearableEditText.getText().toString() != null && clearableEditText.getText().toString().length() > 0) {
                        clearableEditText.setClearButtonVisible(true);
                    } else {
                        clearableEditText.setClearButtonVisible(false);
                    }
                }
                if (currentFocus instanceof EditText) {
                    ((EditText) currentFocus).setCursorVisible(true);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class l extends ProfileCardObserver {
        static IPatchRedirector $redirector_;

        l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendVerifyFragment.this);
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
            if (!AddFriendVerifyFragment.this.Di() && z16 && obj != null) {
                IProfileCardBusinessApi iProfileCardBusinessApi = (IProfileCardBusinessApi) QRoute.api(IProfileCardBusinessApi.class);
                if (obj instanceof Card) {
                    Card card = (Card) obj;
                    String str2 = card.uin;
                    if (str2 != null && str2.equals(AddFriendVerifyFragment.this.D)) {
                        iProfileCardBusinessApi.makeSexAgeArea(AddFriendVerifyFragment.this.getActivity(), card.shGender, card.age, card.strCountry, card.strProvince, card.strCity);
                        AddFriendVerifyFragment addFriendVerifyFragment = AddFriendVerifyFragment.this;
                        if (addFriendVerifyFragment.f187383e0 != null) {
                            iProfileCardBusinessApi.makeSexAgeArea(addFriendVerifyFragment.getActivity(), card.shGender, 0, "", "", "");
                            return;
                        }
                        return;
                    }
                    return;
                }
                if ((obj instanceof ContactCard) && (str = (contactCard = (ContactCard) obj).mobileNo) != null && str.equals(AddFriendVerifyFragment.this.D)) {
                    iProfileCardBusinessApi.makeSexAgeArea(AddFriendVerifyFragment.this.getActivity(), contactCard.bSex, contactCard.bAge, contactCard.strCountry, contactCard.strProvince, contactCard.strCity);
                    AddFriendVerifyFragment addFriendVerifyFragment2 = AddFriendVerifyFragment.this;
                    if (addFriendVerifyFragment2.f187383e0 != null) {
                        iProfileCardBusinessApi.makeSexAgeArea(addFriendVerifyFragment2.getActivity(), contactCard.bSex, 0, "", "", "");
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class m extends com.tencent.mobileqq.friend.observer.a {
        static IPatchRedirector $redirector_;

        m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendVerifyFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.friend.observer.a
        public void onAddBatchPhoneFriend(boolean z16, ArrayList<AddBatchPhoneFriendResult> arrayList) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), arrayList);
                return;
            }
            if (AddFriendVerifyFragment.this.Di()) {
                return;
            }
            if (QLog.isColorLevel()) {
                if (arrayList != null) {
                    i3 = arrayList.size();
                } else {
                    i3 = -1;
                }
                QLog.d("AddFriendVerifyFragment", 2, "onAddBatchPhoneFriend success=" + z16 + ", added count=" + i3);
            }
            if (z16) {
                if (AddFriendVerifyFragment.this.f187397s0 != null) {
                    AddFriendVerifyFragment.this.f187397s0.dismiss();
                }
                QQToast.makeText(AddFriendVerifyFragment.this.getActivity(), 2, R.string.hei, 0).show(AddFriendVerifyFragment.this.getQBaseActivity().getTitleBarHeight());
                Intent intent = new Intent();
                intent.putExtra("result", arrayList);
                AddFriendVerifyFragment.this.getActivity().setResult(-1, intent);
                AddFriendVerifyFragment.this.getActivity().finish();
                return;
            }
            if (AddFriendVerifyFragment.this.f187397s0 != null) {
                AddFriendVerifyFragment.this.f187397s0.dismiss();
            }
            AddFriendVerifyFragment.this.f187380b0.clear();
            QQToast.makeText(AddFriendVerifyFragment.this.getActivity(), 1, R.string.f173065h22, 0).show(AddFriendVerifyFragment.this.getQBaseActivity().getTitleBarHeight());
            AddFriendVerifyFragment.this.getActivity().setResult(0);
            AddFriendVerifyFragment.this.getActivity().finish();
        }

        @Override // com.tencent.mobileqq.friend.observer.a
        protected void onAddFriendSecCheck(boolean z16, Bundle bundle) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), bundle);
                return;
            }
            if (AddFriendVerifyFragment.this.Di()) {
                return;
            }
            String str2 = "";
            if (z16 && bundle != null) {
                AddFriendVerifyFragment.this.V = bundle;
                String string = bundle.getString("security_check_url", "");
                String string2 = bundle.getString("security_check_buffer", "");
                ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).openSecCheckWebForFragment(AddFriendVerifyFragment.this.C, AddFriendVerifyFragment.this.getActivity(), AddFriendVerifyFragment.this, 1004, string, string2);
                str = string2;
                str2 = string;
            } else {
                str = "";
            }
            if (QLog.isColorLevel()) {
                QLog.d("AddFriendVerifyFragment", 2, "onAddFriendSecCheck, isSuccess=" + z16 + "," + TextUtils.isEmpty(str2) + "," + TextUtils.isEmpty(str));
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x0087, code lost:
        
            if (r6.ii(r6.J) == false) goto L28;
         */
        @Override // com.tencent.mobileqq.friend.observer.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        protected void onGetAutoInfo(boolean z16, String str, String str2, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), str, str2, Integer.valueOf(i3));
                return;
            }
            if (TextUtils.equals(AddFriendVerifyFragment.this.D, str) && AddFriendVerifyFragment.this.getActivity() != null && !AddFriendVerifyFragment.this.getActivity().isFinishing()) {
                String b16 = ay.b(AddFriendVerifyFragment.this.D);
                if (!TextUtils.isEmpty(b16)) {
                    str2 = b16;
                }
                if (!z16) {
                    AddFriendVerifyFragment.this.G = 0;
                } else {
                    if (!((IAddFriendApi) QRoute.api(IAddFriendApi.class)).shouldUseLocalRemark(AddFriendVerifyFragment.this.J) && AddFriendVerifyFragment.this.f187383e0 == null) {
                        if (TextUtils.isEmpty(str2)) {
                            AddFriendVerifyFragment addFriendVerifyFragment = AddFriendVerifyFragment.this;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("AddFriendVerifyFragment", 2, "onGetAutoInfo remark = " + str2);
                        }
                        AddFriendVerifyFragment.this.f187392n0.setText(str2);
                        try {
                            AddFriendVerifyFragment.this.f187392n0.setSelection(AddFriendVerifyFragment.this.f187392n0.getText().length());
                        } catch (IndexOutOfBoundsException unused) {
                            if (QLog.isColorLevel()) {
                                QLog.d("AddFriendVerifyFragment", 2, "onGetAutoInfo | IndexOutOfBoundsException");
                            }
                        }
                        if (AddFriendVerifyFragment.K0) {
                            AddFriendVerifyFragment.this.f187403y0.setContentDescription(AddFriendVerifyFragment.this.getResources().getString(R.string.bws) + AddFriendVerifyFragment.this.f187392n0.getText().toString());
                        }
                    }
                    AddFriendVerifyFragment.this.G = i3;
                }
                AddFriendVerifyFragment.this.f187389k0.setText(((IAddFriendApi) QRoute.api(IAddFriendApi.class)).getGroupName(AddFriendVerifyFragment.this.C, AddFriendVerifyFragment.this.G));
            }
        }

        @Override // com.tencent.mobileqq.friend.observer.a
        protected void onGetInfoWithOpenId(boolean z16, String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), str, str2);
                return;
            }
            if (!AddFriendVerifyFragment.this.Di() && z16 && TextUtils.equals(str, AddFriendVerifyFragment.this.D) && !TextUtils.isEmpty(str2)) {
                AddFriendVerifyFragment.this.f187385g0.setText(str2);
                if (AddFriendVerifyFragment.K0) {
                    AddFriendVerifyFragment.this.f187385g0.setContentDescription(str2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.friend.observer.a
        public void onUpdateAddFriend(boolean z16, boolean z17, boolean z18, String str, Bundle bundle) {
            String string;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), str, bundle);
                return;
            }
            if (TextUtils.equals(str, AddFriendVerifyFragment.this.D) && AddFriendVerifyFragment.this.getActivity() != null && !AddFriendVerifyFragment.this.getActivity().isFinishing()) {
                if (z16) {
                    int i3 = bundle.getInt("friend_setting");
                    if (i3 == 3) {
                        if (z17) {
                            AddFriendVerifyFragment addFriendVerifyFragment = AddFriendVerifyFragment.this;
                            addFriendVerifyFragment.Si(addFriendVerifyFragment.f187391m0.getText().toString().trim(), bundle.getByteArray(PreloadTRTCPlayerParams.KEY_SIG), bundle.getString("security_ticket", ""));
                            AddFriendVerifyFragment.this.doCallback(0, "");
                        } else {
                            if (bundle.getString("ErrorString") != null && !bundle.getString("ErrorString").trim().equals("")) {
                                string = bundle.getString("ErrorString");
                            } else {
                                string = AddFriendVerifyFragment.this.getString(R.string.f170344mw);
                            }
                            QQToast.makeText(AddFriendVerifyFragment.this.getActivity(), 1, string, 1).show(AddFriendVerifyFragment.this.getQBaseActivity().getTitleBarHeight());
                        }
                        com.tencent.relation.common.report.a.c("relation_addfriend_send_request", System.currentTimeMillis() - AddFriendVerifyFragment.this.C0, true, AddFriendVerifyFragment.this.ui(0));
                        return;
                    }
                    if (bundle.getInt(QzoneIPCModule.RESULT_CODE) == 0) {
                        bundle.getInt("friend_setting");
                        bundle.getString(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME);
                        if (i3 != 0 && i3 != 100) {
                            if (AddFriendVerifyFragment.this.f187397s0 != null) {
                                AddFriendVerifyFragment.this.f187397s0.cancel();
                                AddFriendVerifyFragment.this.f187397s0 = null;
                            }
                            QQToast.makeText(AddFriendVerifyFragment.this.getActivity(), 2, R.string.h1z, 0).show(AddFriendVerifyFragment.this.getQBaseActivity().getTitleBarHeight());
                            AddFriendVerifyFragment.this.mi();
                        } else {
                            if (AddFriendVerifyFragment.this.f187397s0 != null) {
                                AddFriendVerifyFragment.this.f187397s0.cancel();
                                AddFriendVerifyFragment.this.f187397s0 = null;
                            }
                            QQToast.makeText(AddFriendVerifyFragment.this.getActivity(), 2, R.string.f170041dp, 0).show(AddFriendVerifyFragment.this.getQBaseActivity().getTitleBarHeight());
                            if (!Utils.G(str)) {
                                AddFriendVerifyFragment.this.mi();
                            } else {
                                String obj = AddFriendVerifyFragment.this.f187392n0.getText().toString();
                                String charSequence = AddFriendVerifyFragment.this.f187385g0.getText().toString();
                                if (TextUtils.isEmpty(obj)) {
                                    obj = charSequence;
                                }
                                Intent m3 = BaseAIOUtils.m(new Intent(), null);
                                m3.putExtra("uin", str);
                                m3.putExtra("uintype", 0);
                                m3.putExtra("uinname", obj);
                                ActivityURIRequest activityURIRequest = new ActivityURIRequest(AddFriendVerifyFragment.this.getActivity(), RouterConstants.UI_ROUTER_SPLASH);
                                activityURIRequest.extra().putAll(m3.getExtras());
                                activityURIRequest.setFlags(m3.getFlags());
                                QRoute.startUri(activityURIRequest);
                                ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).sendAddFriendNoticeForBaby(AddFriendVerifyFragment.this.C, AddFriendVerifyFragment.this.F);
                            }
                        }
                        com.tencent.relation.common.report.a.c("relation_addfriend_send_request", System.currentTimeMillis() - AddFriendVerifyFragment.this.C0, true, AddFriendVerifyFragment.this.ui(0));
                        AddFriendVerifyFragment.this.doCallback(0, "");
                        return;
                    }
                    if (AddFriendVerifyFragment.this.f187397s0 != null) {
                        AddFriendVerifyFragment.this.f187397s0.cancel();
                        AddFriendVerifyFragment.this.f187397s0 = null;
                    }
                    int i16 = bundle.getInt("error_code", 0);
                    String string2 = bundle.getString("ErrorString");
                    if (i16 == 168) {
                        AddFriendVerifyFragment.this.Qi(bundle.getString("error_tips_wording"), bundle.getString("error_tips_cancel_wording"), bundle.getString("error_tips_jump_btn_wording"), bundle.getString("error_tips_h5_url"), bundle.getString("error_tips_mini_app_url"));
                    } else if (i16 == 167) {
                        AddFriendVerifyFragment.this.Ri(string2);
                    } else if (i16 >= 176) {
                        QQToastUtil.showQQToastInUiThread(1, string2);
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.d("AddFriendVerifyFragment", 2, "add friend response error and ErroString = " + string2);
                        }
                        if (TextUtils.isEmpty(string2)) {
                            string2 = AddFriendVerifyFragment.this.getString(R.string.f173065h22);
                        }
                        AddFriendVerifyFragment.this.Pi(string2);
                    }
                    com.tencent.relation.common.report.a.c("relation_addfriend_send_request", System.currentTimeMillis() - AddFriendVerifyFragment.this.C0, false, AddFriendVerifyFragment.this.ui(i16));
                    return;
                }
                if (AddFriendVerifyFragment.this.f187397s0 != null) {
                    AddFriendVerifyFragment.this.f187397s0.cancel();
                    AddFriendVerifyFragment.this.f187397s0 = null;
                }
                AddFriendVerifyFragment addFriendVerifyFragment2 = AddFriendVerifyFragment.this;
                addFriendVerifyFragment2.Pi(addFriendVerifyFragment2.getString(R.string.f173065h22));
                if (QLog.isColorLevel()) {
                    QLog.d("AddFriendVerifyFragment", 2, "add friend response error and isSuccuss = NO");
                }
                com.tencent.relation.common.report.a.c("relation_addfriend_send_request", System.currentTimeMillis() - AddFriendVerifyFragment.this.C0, false, AddFriendVerifyFragment.this.ui(0));
                return;
            }
            com.tencent.relation.common.report.a.c("relation_addfriend_send_request", System.currentTimeMillis() - AddFriendVerifyFragment.this.C0, false, AddFriendVerifyFragment.this.ui(0));
        }

        @Override // com.tencent.mobileqq.friend.observer.a
        protected void onUpdateSetFriendPermission(boolean z16, HashMap<String, Integer> hashMap, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), hashMap, Integer.valueOf(i3));
                return;
            }
            if (!AddFriendVerifyFragment.this.Di() && hashMap != null && QLog.isColorLevel()) {
                QLog.d("AddFriendVerifyFragment", 2, "onUpdateSetFriendPermission | Qzone Permission is " + i3 + " set result:" + z16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class n extends com.tencent.qidian.controller.c {
        static IPatchRedirector $redirector_;

        n() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendVerifyFragment.this);
            }
        }

        @Override // com.tencent.qidian.controller.c
        protected void a(boolean z16, HashMap<String, Object> hashMap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), hashMap);
                return;
            }
            if (z16 && ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).hasQidianExternal(hashMap)) {
                HashMap<String, String> qidianExternal = ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).getQidianExternal(hashMap);
                if (qidianExternal != null && AddFriendVerifyFragment.this.D.equals(qidianExternal.get("qidian_uin"))) {
                    if (AddFriendVerifyFragment.this.f187385g0 != null) {
                        String charSequence = AddFriendVerifyFragment.this.f187385g0.getText().toString();
                        if (TextUtils.isEmpty(charSequence) || charSequence.equals(AddFriendVerifyFragment.this.D)) {
                            AddFriendVerifyFragment.this.f187385g0.setText(qidianExternal.get("qidian_nickname"));
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("AddFriendVerifyFragment", 2, "onGetQiDianMasterInfo not current uin");
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("AddFriendVerifyFragment", 2, "onGetQiDianMasterInfo fail");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class o extends com.tencent.mobileqq.addfriend.observer.a {
        static IPatchRedirector $redirector_;

        o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendVerifyFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.addfriend.observer.a
        public void a(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, obj);
                return;
            }
            AddFriendVerifyFragment.this.f187395q0.removeAllViews();
            List list = (List) obj;
            if (list.size() == 0) {
                AddFriendVerifyFragment.this.gi();
                return;
            }
            for (int i3 = 0; i3 < list.size(); i3++) {
                AddFriendVerifyFragment.this.f187395q0.addView(AddFriendVerifyFragment.this.zi((LabelTag) list.get(i3)));
            }
        }

        @Override // com.tencent.mobileqq.addfriend.observer.a
        public void b(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, obj);
            } else {
                if (!(obj instanceof String)) {
                    return;
                }
                String str = (String) obj;
                if (!TextUtils.isEmpty(str)) {
                    AddFriendVerifyFragment.this.f187385g0.setText(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class p implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        p() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendVerifyFragment.this);
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
                    inputMethodManager.hideSoftInputFromWindow(AddFriendVerifyFragment.this.getActivity().getWindow().getDecorView().getWindowToken(), 0);
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class q implements Function2<View, BaseAction, Unit> {
        static IPatchRedirector $redirector_;

        q() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendVerifyFragment.this);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(View view, BaseAction baseAction) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Unit) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) baseAction);
            }
            if (baseAction == BaseAction.ACTION_LEFT_TEXT) {
                AddFriendVerifyFragment.this.onBackEvent();
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class r extends w {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f187435e;

        /* compiled from: P */
        /* loaded from: classes10.dex */
        class a implements IAddAcceptBlockStrategy.a {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) r.this);
                }
            }

            @Override // com.tencent.mobileqq.addfriend.strategy.IAddAcceptBlockStrategy.a
            public void onSuccess() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (AddFriendVerifyFragment.this.isAdded() && AddFriendVerifyFragment.this.getActivity() != null) {
                    AddFriendVerifyFragment addFriendVerifyFragment = AddFriendVerifyFragment.this;
                    if (addFriendVerifyFragment.f187384f0 != null) {
                        addFriendVerifyFragment.getActivity().getWindow().setSoftInputMode(2);
                        AddFriendVerifyFragment addFriendVerifyFragment2 = AddFriendVerifyFragment.this;
                        addFriendVerifyFragment2.f187384f0.hideSoftInputFromWindow(addFriendVerifyFragment2.f187391m0.getWindowToken(), 0);
                        AddFriendVerifyFragment.this.f187391m0.clearFocus();
                    }
                    if (AddFriendVerifyFragment.this.f187391m0.getText().toString().length() > 30) {
                        ReportDialog reportDialog = new ReportDialog(AddFriendVerifyFragment.this.getActivity(), R.style.qZoneInputDialog);
                        reportDialog.setContentView(R.layout.bwu);
                        ((TextView) reportDialog.findViewById(R.id.dialogText)).setText(AddFriendVerifyFragment.this.getString(R.string.a_d));
                        ((ProgressBar) reportDialog.findViewById(R.id.cib)).setVisibility(8);
                        ((ImageView) reportDialog.findViewById(R.id.kja)).setImageResource(R.drawable.f160605la);
                        reportDialog.show();
                        return;
                    }
                    String trim = AddFriendVerifyFragment.this.f187391m0.getText().toString().trim();
                    AddFriendVerifyFragment.this.Li(trim, false);
                    if (AddFriendVerifyFragment.this.getString(R.string.axv).equals(trim) && !AddFriendVerifyFragment.this.yi()) {
                        AddFriendVerifyFragment.this.Hi();
                    }
                    AddFriendVerifyFragment addFriendVerifyFragment3 = AddFriendVerifyFragment.this;
                    addFriendVerifyFragment3.Ii(addFriendVerifyFragment3.f187391m0.getText().toString().trim());
                    r rVar = r.this;
                    if (rVar.f187435e == 0) {
                        ReportController.o(AddFriendVerifyFragment.this.C, "dc00898", "", "", "0X800796F", "0X800796F", 0, 0, "", "", "", "");
                    } else {
                        ReportController.o(AddFriendVerifyFragment.this.C, "dc00898", "", "", "0X8007976", "0X8007976", 0, 0, "", "", "", "");
                    }
                    if (!TextUtils.isEmpty(AddFriendVerifyFragment.this.U)) {
                        ReportController.o(AddFriendVerifyFragment.this.C, "dc00899", "Qidian", "", "0X8008802", "ClickAddFriendButton", 0, 0, "1", "", "", "");
                        return;
                    }
                    return;
                }
                QLog.e("AddFriendVerifyFragment", 1, "isAdded false or getActivity null");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        r(int i3) {
            super();
            this.f187435e = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendVerifyFragment.this, i3);
            }
        }

        @Override // com.tencent.mobileqq.addfriend.ui.AddFriendVerifyFragment.w, android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                AddFriendVerifyFragment.this.C0 = System.currentTimeMillis();
                ((IAddAcceptBlockStrategy) QRoute.api(IAddAcceptBlockStrategy.class)).checkAccountIdentity(AddFriendVerifyFragment.this.C, 10003, AddFriendVerifyFragment.this.getContext(), new a());
                super.onClick(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class s extends w {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f187438e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f187439f;

        /* compiled from: P */
        /* loaded from: classes10.dex */
        class a implements IAddAcceptBlockStrategy.a {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) s.this);
                }
            }

            @Override // com.tencent.mobileqq.addfriend.strategy.IAddAcceptBlockStrategy.a
            public void onSuccess() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (AddFriendVerifyFragment.this.isAdded() && AddFriendVerifyFragment.this.getActivity() != null) {
                    AddFriendVerifyFragment.this.Ki();
                    AddFriendVerifyFragment.this.Si("", null, "");
                    ReportController.o(AddFriendVerifyFragment.this.C, "dc00898", "", "", "0X80077B4", "0X80077B4", 0, 0, String.valueOf(s.this.f187438e), String.valueOf(s.this.f187439f), "", "");
                    if (QLog.isColorLevel()) {
                        QLog.d("AddFriendVerifyFragment", 2, "reportClickEvent action: 0X80077B4  sourceId = " + s.this.f187438e + " subSourceId = " + s.this.f187439f);
                    }
                    if (Utils.G(AddFriendVerifyFragment.this.D)) {
                        ReportController.o(AddFriendVerifyFragment.this.C, "dc00898", "", "", "0X8008275", "0X8008275", 0, 0, "", "", "", "");
                    }
                    if (!TextUtils.isEmpty(AddFriendVerifyFragment.this.U)) {
                        ReportController.o(AddFriendVerifyFragment.this.C, "dc00899", "Qidian", "", "0X8008802", "ClickAddFriendButton", 0, 0, "1", "", "", "");
                        return;
                    }
                    return;
                }
                QLog.e("AddFriendVerifyFragment", 1, "isAdded false or getActivity null");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        s(int i3, int i16) {
            super();
            this.f187438e = i3;
            this.f187439f = i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, AddFriendVerifyFragment.this, Integer.valueOf(i3), Integer.valueOf(i16));
            }
        }

        @Override // com.tencent.mobileqq.addfriend.ui.AddFriendVerifyFragment.w, android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                AddFriendVerifyFragment.this.C0 = System.currentTimeMillis();
                ((IAddAcceptBlockStrategy) QRoute.api(IAddAcceptBlockStrategy.class)).checkAccountIdentity(AddFriendVerifyFragment.this.C, 10005, AddFriendVerifyFragment.this.getContext(), new a());
                super.onClick(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class t extends w {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f187442e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f187443f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f187444h;

        /* compiled from: P */
        /* loaded from: classes10.dex */
        class a implements IAddAcceptBlockStrategy.a {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) t.this);
                }
            }

            @Override // com.tencent.mobileqq.addfriend.strategy.IAddAcceptBlockStrategy.a
            public void onSuccess() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (AddFriendVerifyFragment.this.isAdded() && AddFriendVerifyFragment.this.getActivity() != null) {
                    AddFriendVerifyFragment.this.Ki();
                    String xi5 = AddFriendVerifyFragment.this.xi(false);
                    String trim = AddFriendVerifyFragment.this.f187391m0.getText().toString().trim();
                    if (trim != null && xi5 != null && !trim.equals(xi5)) {
                        ReportController.o(AddFriendVerifyFragment.this.C, "dc00898", "", "", "0X80077B0", "0X80077B0", 0, 0, "", "", "", "");
                    }
                    AddFriendVerifyFragment.this.Li(trim, false);
                    if (AddFriendVerifyFragment.this.getString(R.string.axv).equals(trim) && !AddFriendVerifyFragment.this.yi()) {
                        AddFriendVerifyFragment.this.Hi();
                    }
                    AddFriendVerifyFragment addFriendVerifyFragment = AddFriendVerifyFragment.this;
                    if (addFriendVerifyFragment.f187383e0 != null) {
                        ReportController.o(addFriendVerifyFragment.C, "dc00898", "", "", "0X8008439", "0X8008439", 0, 0, "", "", "", "");
                        if (!TextUtils.isEmpty(AddFriendVerifyFragment.this.f187383e0.verifyMsg)) {
                            AddFriendVerifyFragment addFriendVerifyFragment2 = AddFriendVerifyFragment.this;
                            if (!addFriendVerifyFragment2.f187383e0.verifyMsg.equals(addFriendVerifyFragment2.f187391m0.getText().toString())) {
                                ReportController.o(AddFriendVerifyFragment.this.C, "dc00898", "", "", "0X800843A", "0X800843A", 0, 0, "", "", "", "");
                            }
                        }
                    }
                    AddFriendVerifyFragment addFriendVerifyFragment3 = AddFriendVerifyFragment.this;
                    addFriendVerifyFragment3.Si(addFriendVerifyFragment3.f187391m0.getText().toString().trim(), null, "");
                    ReportController.o(AddFriendVerifyFragment.this.C, "dc00898", "", "", "0X80077B4", "0X80077B4", 0, 0, String.valueOf(t.this.f187442e), String.valueOf(t.this.f187443f), "", "");
                    if (QLog.isColorLevel()) {
                        QLog.d("AddFriendVerifyFragment", 2, "reportClickEvent action: 0X80077B4  sourceId = " + t.this.f187442e + " subSourceId = " + t.this.f187443f);
                    }
                    if (!TextUtils.isEmpty(AddFriendVerifyFragment.this.U)) {
                        ReportController.o(AddFriendVerifyFragment.this.C, "dc00899", "Qidian", "", "0X8008802", "ClickAddFriendButton", 0, 0, "1", "", "", "");
                    }
                    t tVar = t.this;
                    AddFriendVerifyFragment.this.ni(tVar.f187442e, tVar.f187444h);
                    return;
                }
                QLog.e("AddFriendVerifyFragment", 1, "isAdded false or getActivity null");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        t(int i3, int i16, int i17) {
            super();
            this.f187442e = i3;
            this.f187443f = i16;
            this.f187444h = i17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, AddFriendVerifyFragment.this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }

        @Override // com.tencent.mobileqq.addfriend.ui.AddFriendVerifyFragment.w, android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                AddFriendVerifyFragment.this.C0 = System.currentTimeMillis();
                ((IAddAcceptBlockStrategy) QRoute.api(IAddAcceptBlockStrategy.class)).checkAccountIdentity(AddFriendVerifyFragment.this.C, 10005, AddFriendVerifyFragment.this.getContext(), new a());
                super.onClick(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class u extends w {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ClearableEditText f187447e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f187448f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f187449h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f187450i;

        /* compiled from: P */
        /* loaded from: classes10.dex */
        class a implements IAddAcceptBlockStrategy.a {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) u.this);
                }
            }

            @Override // com.tencent.mobileqq.addfriend.strategy.IAddAcceptBlockStrategy.a
            public void onSuccess() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (AddFriendVerifyFragment.this.isAdded() && AddFriendVerifyFragment.this.getActivity() != null) {
                    AddFriendVerifyFragment.this.Ki();
                    if ("".equals(u.this.f187447e.getText().toString().trim())) {
                        QQToast.makeText(AddFriendVerifyFragment.this.getActivity(), 0, AddFriendVerifyFragment.this.getString(R.string.f170345mx), 0).show(AddFriendVerifyFragment.this.getQBaseActivity().getTitleBarHeight());
                    } else if (NetworkUtil.isNetSupport(AddFriendVerifyFragment.this.getActivity())) {
                        String stringExtra = AddFriendVerifyFragment.this.F.getStringExtra("extra");
                        String trim = u.this.f187447e.getText().toString().trim();
                        int intExtra = AddFriendVerifyFragment.this.F.getIntExtra("sub_source_id", 0);
                        String stringExtra2 = AddFriendVerifyFragment.this.F.getStringExtra("src_name");
                        if (!AddFriendVerifyFragment.this.Y) {
                            int i3 = AddFriendVerifyFragment.this.f187402x0.i();
                            Intent intent = AddFriendVerifyFragment.this.F;
                            Bundle bundleExtra = intent.getBundleExtra("flc_extra_param");
                            if (bundleExtra == null) {
                                bundleExtra = new Bundle();
                            }
                            bundleExtra.putInt("friend_permission", i3);
                            intent.putExtra("flc_extra_param", bundleExtra);
                        }
                        IFriendHandlerService iFriendHandlerService = (IFriendHandlerService) AddFriendVerifyFragment.this.C.getRuntimeService(IFriendHandlerService.class, "");
                        String str = AddFriendVerifyFragment.this.D;
                        u uVar = u.this;
                        iFriendHandlerService.requestAddFriendWithMyCard(str, stringExtra, uVar.f187448f, (byte) 0, trim, uVar.f187449h, intExtra, null, false, null, false, null, stringExtra2, (byte) 0, "", AddFriendVerifyFragment.this.F.getBundleExtra("flc_extra_param"), true, AddFriendVerifyFragment.this.F.getByteArrayExtra("flc_add_frd_token"));
                    } else {
                        QQToast.makeText(AddFriendVerifyFragment.this.getActivity(), 1, AddFriendVerifyFragment.this.getString(R.string.f171139ci4), 0).show(AddFriendVerifyFragment.this.getQBaseActivity().getTitleBarHeight());
                    }
                    ReportController.o(AddFriendVerifyFragment.this.C, "dc00898", "", "", "0X80077B4", "0X80077B4", 0, 0, String.valueOf(u.this.f187449h), String.valueOf(u.this.f187450i), "", "");
                    if (QLog.isColorLevel()) {
                        QLog.d("AddFriendVerifyFragment", 2, "reportClickEvent action: 0X80077B4  sourceId = " + u.this.f187449h + " subSourceId = " + u.this.f187450i);
                    }
                    if (!TextUtils.isEmpty(AddFriendVerifyFragment.this.U)) {
                        ReportController.o(AddFriendVerifyFragment.this.C, "dc00899", "Qidian", "", "0X8008802", "ClickAddFriendButton", 0, 1, "", "", "", "");
                    }
                    u uVar2 = u.this;
                    AddFriendVerifyFragment.this.ni(uVar2.f187449h, uVar2.f187448f);
                    return;
                }
                QLog.e("AddFriendVerifyFragment", 1, "isAdded false or getActivity null");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        u(ClearableEditText clearableEditText, int i3, int i16, int i17) {
            super();
            this.f187447e = clearableEditText;
            this.f187448f = i3;
            this.f187449h = i16;
            this.f187450i = i17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, AddFriendVerifyFragment.this, clearableEditText, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }

        @Override // com.tencent.mobileqq.addfriend.ui.AddFriendVerifyFragment.w, android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                AddFriendVerifyFragment.this.C0 = System.currentTimeMillis();
                ((IAddAcceptBlockStrategy) QRoute.api(IAddAcceptBlockStrategy.class)).checkAccountIdentity(AddFriendVerifyFragment.this.C, 10005, AddFriendVerifyFragment.this.getContext(), new a());
                super.onClick(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class v extends w {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ StringBuffer f187453e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f187454f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f187455h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f187456i;

        /* compiled from: P */
        /* loaded from: classes10.dex */
        class a implements IAddAcceptBlockStrategy.a {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) v.this);
                }
            }

            @Override // com.tencent.mobileqq.addfriend.strategy.IAddAcceptBlockStrategy.a
            public void onSuccess() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                boolean z16 = true;
                if (AddFriendVerifyFragment.this.isAdded() && AddFriendVerifyFragment.this.getActivity() != null) {
                    AddFriendVerifyFragment.this.Ki();
                    String stringBuffer = v.this.f187453e.toString();
                    int i3 = 0;
                    while (true) {
                        if (i3 < AddFriendVerifyFragment.this.Z.size()) {
                            String trim = ((EditText) AddFriendVerifyFragment.this.Z.get(i3)).getText().toString().trim();
                            if ("".equals(trim)) {
                                break;
                            }
                            stringBuffer = stringBuffer.replaceFirst("\\$\\{answer\\}", Matcher.quoteReplacement(trim));
                            i3++;
                        } else {
                            z16 = false;
                            break;
                        }
                    }
                    if (z16) {
                        QQToast.makeText(AddFriendVerifyFragment.this.getActivity(), 0, AddFriendVerifyFragment.this.getString(R.string.f170345mx), 0).show(AddFriendVerifyFragment.this.getQBaseActivity().getTitleBarHeight());
                    } else {
                        AddFriendVerifyFragment.this.Si(stringBuffer, null, "");
                    }
                    ReportController.o(AddFriendVerifyFragment.this.C, "dc00898", "", "", "0X80077B4", "0X80077B4", 0, 0, String.valueOf(v.this.f187454f), String.valueOf(v.this.f187455h), "", "");
                    if (QLog.isColorLevel()) {
                        QLog.d("AddFriendVerifyFragment", 2, "reportClickEvent action: 0X80077B4  sourceId = " + v.this.f187454f + " subSourceId = " + v.this.f187455h);
                    }
                    if (!TextUtils.isEmpty(AddFriendVerifyFragment.this.U)) {
                        ReportController.o(AddFriendVerifyFragment.this.C, "dc00899", "Qidian", "", "0X8008802", "ClickAddFriendButton", 0, 0, "1", "", "", "");
                    }
                    v vVar = v.this;
                    AddFriendVerifyFragment.this.ni(vVar.f187454f, vVar.f187456i);
                    return;
                }
                QLog.e("AddFriendVerifyFragment", 1, "isAdded false or getActivity null");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        v(StringBuffer stringBuffer, int i3, int i16, int i17) {
            super();
            this.f187453e = stringBuffer;
            this.f187454f = i3;
            this.f187455h = i16;
            this.f187456i = i17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, AddFriendVerifyFragment.this, stringBuffer, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }

        @Override // com.tencent.mobileqq.addfriend.ui.AddFriendVerifyFragment.w, android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                AddFriendVerifyFragment.this.C0 = System.currentTimeMillis();
                ((IAddAcceptBlockStrategy) QRoute.api(IAddAcceptBlockStrategy.class)).checkAccountIdentity(AddFriendVerifyFragment.this.C, 10005, AddFriendVerifyFragment.this.getContext(), new a());
                super.onClick(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    abstract class w implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        w() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendVerifyFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                AddFriendVerifyFragment.this.pi();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class x implements TextWatcher {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        int f187460d;

        /* renamed from: e, reason: collision with root package name */
        EditText f187461e;

        /* renamed from: f, reason: collision with root package name */
        int f187462f;

        /* renamed from: h, reason: collision with root package name */
        int f187463h;

        public x(int i3, EditText editText) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) editText);
            } else {
                this.f187460d = i3;
                this.f187461e = editText;
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
            String obj = this.f187461e.getText().toString();
            if (obj.getBytes().length > this.f187460d) {
                try {
                    String substring = obj.substring(0, this.f187462f);
                    try {
                        str2 = obj.substring(this.f187462f + this.f187463h, obj.length());
                        try {
                            int i3 = this.f187462f;
                            str3 = obj.substring(i3, this.f187463h + i3);
                            if (substring.getBytes().length + str2.getBytes().length <= this.f187460d) {
                                while (obj.getBytes().length > this.f187460d && str3.length() > 0) {
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
                                this.f187461e.setText(obj);
                                this.f187461e.setSelection(obj.length());
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            str = str3;
                            str3 = substring;
                            if (QLog.isColorLevel()) {
                                QLog.d("AddFriendVerifyFragment", 2, "afterTextChanged, headStr:" + str3 + ", tailStr = " + str2 + ", insert = " + str, th);
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
                this.f187462f = i3;
                this.f187463h = i17;
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26396);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 22)) {
            redirector.redirect((short) 22);
            return;
        }
        K0 = AppSetting.f99565y;
        L0 = false;
        M0 = new HashMap<Integer, Integer>() { // from class: com.tencent.mobileqq.addfriend.ui.AddFriendVerifyFragment.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                    return;
                }
                put(1, 1);
                put(3, 2);
                put(4, 3);
            }
        };
    }

    public AddFriendVerifyFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.H = "";
        this.I = "";
        this.M = "";
        this.T = -1;
        this.U = "";
        this.Z = new ArrayList<>();
        this.f187379a0 = new ArrayList<>();
        this.f187380b0 = new ArrayList<>();
        this.f187384f0 = null;
        this.f187394p0 = null;
        this.f187403y0 = null;
        this.f187404z0 = null;
        this.C0 = 0L;
        this.E0 = null;
        this.F0 = new k();
        this.G0 = new l();
        this.H0 = new m();
        this.I0 = new n();
        this.J0 = new o();
    }

    private void Bi() {
        this.f187394p0.setVisibility(8);
        this.f187385g0.setVisibility(8);
        this.f187395q0.setVisibility(8);
    }

    private void Ci(Bundle bundle) {
        int i3;
        this.F = getActivity().getIntent();
        Bundle arguments = getArguments();
        if (arguments != null) {
            Parcelable parcelable = arguments.getParcelable("add_friend_intent");
            if (parcelable instanceof Intent) {
                this.F = (Intent) parcelable;
            }
        }
        this.D = this.F.getStringExtra("uin");
        this.E = this.F.getIntExtra("k_uin_type", 1);
        this.T = this.F.getIntExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, -1);
        this.W = this.F.getStringExtra("key_param_age_area");
        this.S = friendlist.a.a(this.F.getIntExtra("sort_id", 0));
        this.L = this.F.getByteArrayExtra("third_source_id");
        this.K = this.F.getIntExtra("sub_source_id", 0);
        this.J = this.F.getIntExtra("source_id", BuddySource.DEFAULT);
        this.M = this.F.getStringExtra("recom_trace");
        this.N = ((INearbyAddFriendHelper) QRoute.api(INearbyAddFriendHelper.class)).isFromNearby(this.J, this.K, this.L);
        this.P = ((IMatchFriendDataUtilApi) QRoute.api(IMatchFriendDataUtilApi.class)).isFromMatchFriend(this.J, this.K);
        this.R = ((IGuildAddQQFriendApi) QRoute.api(IGuildAddQQFriendApi.class)).isFromGuild(this.J, this.K);
        if (this.F.hasExtra(IProfileCardConst.KEY_WZRY_DATA)) {
            this.f187383e0 = (KplRoleInfo.WZRYUIinfo) this.F.getSerializableExtra(IProfileCardConst.KEY_WZRY_DATA);
        }
        if (com.tencent.mobileqq.addfriend.utils.a.p(this.J)) {
            this.H = this.F.getStringExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME);
        } else if (this.f187383e0 != null) {
            this.H = this.F.getStringExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME);
        } else if (this.J == 3004 && ((i3 = this.K) == 5 || i3 == 6 || i3 == 7 || i3 == 8)) {
            this.H = this.F.getStringExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME);
        }
        if (ii(this.J)) {
            this.Q = true;
            this.I = vi();
        }
        if (QLog.isColorLevel()) {
            QLog.i("AddFriendVerifyFragment", 2, "ABTestAddFriendVerifyActivity remark = " + this.H + ", source id=" + this.J + ", mTargetGroupId = " + this.G);
        }
        if (bundle == null && NetworkUtil.isNetSupport(getActivity()) && com.tencent.mobileqq.addfriend.utils.a.o(this.J, this.D)) {
            ((IFriendHandlerService) this.C.getRuntimeService(IFriendHandlerService.class, "")).requestAutoInfo(this.D, this.J, this.F.getIntExtra("sub_source_id", 0));
        }
        if (this.E == 1) {
            ((AddFriendHandler) this.C.getBusinessHandler(AddFriendHandler.class.getName())).D2(Long.parseLong(this.D));
        }
        this.X = ((IAddFriendTabApi) QRoute.api(IAddFriendTabApi.class)).isAddQZonePermissionSwitch(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Di() {
        if (getActivity() != null && !getActivity().isFinishing()) {
            return false;
        }
        return true;
    }

    private boolean Ei() {
        if (!this.N && !this.P && !this.Q) {
            return false;
        }
        return true;
    }

    private boolean Fi() {
        if (com.tencent.mobileqq.pad.e.a() != SplitViewState.STATE_FLAT && (getActivity() instanceof QPublicFragmentActivity)) {
            QLog.i("AddFriendVerifyFragment", 1, "isPadOnAddFriendFinished QFragmentContainerManager.currentSplitViewState() == SplitViewState.STATE_FLAT is false");
            return false;
        }
        QLog.i("AddFriendVerifyFragment", 1, "isPadOnAddFriendFinished QFragmentContainerManager.currentSplitViewState() == SplitViewState.STATE_FLAT is true");
        getActivity().onKeyDown(4, new KeyEvent(4, 4));
        return true;
    }

    private void Gi(View view, TextView textView) {
        if (QQTheme.isNowThemeIsNight()) {
            view.setBackgroundResource(R.drawable.j3_);
            textView.setTextColor(Color.parseColor("#8D8D93"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hi() {
        if (getActivity() == null) {
            return;
        }
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("last_verify_msg", 0);
        sharedPreferences.edit().putBoolean("add_friend_verify_msg_modify_flag" + this.C.getAccount(), true);
        sharedPreferences.edit().apply();
    }

    private void Ji() {
        Intent intent;
        INewFriendVerificationService iNewFriendVerificationService = (INewFriendVerificationService) this.C.getRuntimeService(INewFriendVerificationService.class, "");
        if (iNewFriendVerificationService != null && getActivity() != null && (intent = this.F) != null) {
            iNewFriendVerificationService.reportAddFriendBlocked(this.D, intent.getIntExtra("friend_setting", 0), this.F.getIntExtra("source_id", BuddySource.DEFAULT), this.F.getIntExtra("sub_source_id", 0), this.F.getExtras().getString("extra"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ki() {
        if (getActivity() == null) {
            return;
        }
        ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).reportExtendFriend(this.J, this.D, this.F);
    }

    private void Ni() {
        int i3;
        FriendPermissionsSwitch friendPermissionsSwitch = (FriendPermissionsSwitch) findViewById(R.id.f68983hi);
        this.f187402x0 = friendPermissionsSwitch;
        if (this.Y) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        friendPermissionsSwitch.setVisibility(i3);
        if (!this.X) {
            this.f187402x0.o();
        }
        if (ab.a() && K0) {
            this.f187394p0.setContentDescription(getString(R.string.b2q));
            this.f187404z0.setFocusable(true);
            this.f187404z0.setContentDescription(this.f187389k0.getText().toString());
            AccessibilityUtil.n(this.f187398t0, false);
            AccessibilityUtil.n(this.f187403y0, false);
            AccessibilityUtil.n(this.f187401w0, false);
            AccessibilityUtil.n(this.f187389k0, false);
            if (Build.VERSION.SDK_INT >= 28) {
                this.f187386h0.setAccessibilityHeading(true);
                this.f187387i0.setAccessibilityHeading(true);
                this.f187388j0.setAccessibilityHeading(true);
            } else {
                this.f187386h0.setContentDescription(getString(R.string.f170053e3));
                this.f187387i0.setContentDescription(getString(R.string.f220846_8));
                this.f187388j0.setContentDescription(getString(R.string.f1384509l));
            }
        }
    }

    private void Oi() {
        if (Di()) {
            return;
        }
        getActivity().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.addfriend.ui.AddFriendVerifyFragment.23
            static IPatchRedirector $redirector_;

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.addfriend.ui.AddFriendVerifyFragment$23$a */
            /* loaded from: classes10.dex */
            class a implements DialogInterface.OnClickListener {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass23.this);
                    }
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                    } else if (i3 == 1) {
                        AddFriendVerifyFragment.this.E0.cancel();
                        AddFriendVerifyFragment.this.getActivity().finish();
                    }
                }
            }

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendVerifyFragment.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                AddFriendVerifyFragment addFriendVerifyFragment = AddFriendVerifyFragment.this;
                QQCustomDialog qQCustomDialog = addFriendVerifyFragment.E0;
                if (qQCustomDialog != null) {
                    if (!qQCustomDialog.isShowing()) {
                        AddFriendVerifyFragment.this.E0.show();
                        return;
                    }
                    return;
                }
                addFriendVerifyFragment.E0 = DialogUtil.createCustomDialog(addFriendVerifyFragment.getActivity(), 230);
                AddFriendVerifyFragment.this.E0.setMessage(R.string.f170882m9);
                AddFriendVerifyFragment.this.E0.setPositiveButton(R.string.f171151ok, new a());
                if (!AddFriendVerifyFragment.this.E0.isShowing()) {
                    AddFriendVerifyFragment.this.E0.show();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pi(String str) {
        if (Di()) {
            return;
        }
        ji();
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getActivity(), 230, (String) null, str, (String) null, HardCodeUtil.qqStr(R.string.cdn), new f(str), (DialogInterface.OnClickListener) null);
        this.f187396r0 = createCustomDialog;
        try {
            createCustomDialog.show();
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("AddFriendVerifyFragment", 2, "showErrorTipsDlg, tips dialog show failed", th5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qi(String str, String str2, String str3, String str4, String str5) {
        h hVar;
        if (Di()) {
            return;
        }
        ji();
        FragmentActivity activity = getActivity();
        if (TextUtils.isEmpty(str3)) {
            hVar = null;
        } else {
            hVar = new h(str5, str4);
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 230, (String) null, str, str2, str3, hVar, new g());
        this.f187396r0 = createCustomDialog;
        try {
            createCustomDialog.show();
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("AddFriendVerifyFragment", 2, "showErrorTipsDialogWithHandleAbility, tips dialog show failed", th5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ri(String str) {
        ReportController.o(null, "dc00898", "", "", "0X800B991", "0X800B991", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
            QLog.d("AddFriendVerifyFragment", 2, "showSecurityTipsDialog errorStr = " + str);
        }
        ji();
        FragmentActivity activity = getActivity();
        String string = getString(R.string.f224826jz);
        if (TextUtils.isEmpty(str)) {
            str = getString(R.string.f224796jw);
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 230, string, str, R.string.f224806jx, R.string.f224816jy, new i(), new j());
        this.f187396r0 = createCustomDialog;
        try {
            createCustomDialog.show();
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("AddFriendVerifyFragment", 2, "showSecurityTipsDialog, tips dialog show failed", th5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doCallback(int i3, String str) {
        OpenAddFriendPart openAddFriendPart = this.D0;
        if (openAddFriendPart == null) {
            return;
        }
        openAddFriendPart.z9(i3, str);
    }

    private <T extends View> T findViewById(int i3) {
        return (T) ((QIphoneTitleBarFragment) this).mContentView.findViewById(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gi() {
        this.f187385g0.setPadding(0, 0, 0, 0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        this.f187385g0.setLayoutParams(layoutParams);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x05ac  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x06a7  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x06b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void hi() {
        String str;
        String str2;
        String str3;
        int i3;
        int i16;
        int i17;
        int i18;
        Intent intent;
        String str4;
        String str5;
        boolean z16;
        boolean z17;
        String str6;
        String str7;
        String str8;
        String string;
        LinearLayout.LayoutParams layoutParams;
        String str9 = "true";
        Bundle extras = this.F.getExtras();
        String str10 = "";
        if (extras == null) {
            str = "";
        } else {
            str = extras.getString(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME);
        }
        int i19 = BuddySource.DEFAULT;
        if (extras != null) {
            i19 = extras.getInt("source_id", BuddySource.DEFAULT);
        }
        int i26 = i19;
        int intExtra = this.F.getIntExtra("sub_source_id", 0);
        IProfileProtocolService iProfileProtocolService = (IProfileProtocolService) this.C.getRuntimeService(IProfileProtocolService.class, "");
        if (this.S) {
            iProfileProtocolService.requestProfileCard(this.C.getCurrentAccountUin(), "0", 16, 0L, (byte) 0, 0L, 0L, null, this.D, 0L, 10004, null, (byte) 0);
        } else {
            iProfileProtocolService.requestProfileCard(this.C.getCurrentAccountUin(), this.D, 12, 0L, (byte) 0, 0L, 0L, null, "", 0L, 10004, null, (byte) 0);
        }
        boolean z18 = true;
        if (this.E == 3) {
            ti(URLDrawable.getDrawable(FaceDrawable.getOpenIdUrl(this.D, this.F.getStringExtra("extra")), URLDrawable.URLDrawableOptions.obtain()));
            this.f187385g0.setText(str);
            if (K0) {
                this.f187385g0.setContentDescription(str);
            }
            ((IFriendHandlerService) this.C.getRuntimeService(IFriendHandlerService.class, "")).requestInfoWithOpenId(this.D, this.F.getStringExtra("extra"));
        } else {
            this.f187394p0.setImageDrawable(FaceDrawable.getFaceDrawable(this.C, 1, this.D));
            ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsDetailInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.D), "AddFriendVerifyFragment", new hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.c>(str) { // from class: com.tencent.mobileqq.addfriend.ui.AddFriendVerifyFragment.4
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ String f187411a;

                {
                    this.f187411a = str;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendVerifyFragment.this, (Object) str);
                    }
                }

                @Override // hx3.b
                public void onQueryResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> eVar) {
                    String str11;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                        return;
                    }
                    ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> b16 = eVar.b();
                    if (b16 == null || b16.size() <= 0 || !TextUtils.isEmpty(b16.get(0).c())) {
                        str11 = AddFriendVerifyFragment.this.D;
                    } else {
                        str11 = b16.get(0).c();
                    }
                    ThreadManager.getUIHandler().post(new Runnable(str11) { // from class: com.tencent.mobileqq.addfriend.ui.AddFriendVerifyFragment.4.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ String f187413d;

                        {
                            this.f187413d = str11;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this, (Object) str11);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            String str12;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            if (AddFriendVerifyFragment.this.f187385g0.isShown()) {
                                TextView textView = AddFriendVerifyFragment.this.f187385g0;
                                if (TextUtils.isEmpty(AnonymousClass4.this.f187411a)) {
                                    str12 = this.f187413d;
                                } else {
                                    str12 = AnonymousClass4.this.f187411a;
                                }
                                textView.setText(str12);
                                if (AddFriendVerifyFragment.K0) {
                                    AddFriendVerifyFragment.this.f187385g0.setContentDescription(AddFriendVerifyFragment.this.f187385g0.getText());
                                }
                            }
                        }
                    });
                }
            });
        }
        int intExtra2 = this.F.getIntExtra("friend_setting", 0);
        ArrayList<String> stringArrayList = this.F.getExtras().getStringArrayList("user_question");
        String str11 = " subSourceId = ";
        String str12 = "reportClickEvent action: 0X80077AF  sourceId = ";
        if (intExtra2 != 0) {
            if (intExtra2 == 1) {
                str2 = "true";
                str3 = "";
                i3 = 1;
                this.f187386h0.setVisibility(0);
                this.f187391m0.setVisibility(0);
                if (K0) {
                    EditText editText = this.f187391m0;
                    editText.setContentDescription(editText.getText().toString());
                }
                this.f187393o0.setOnClickListener(new t(i26, intExtra, intExtra2));
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f187401w0.getLayoutParams();
                layoutParams2.addRule(3, this.f187391m0.getId());
                this.f187401w0.setLayoutParams(layoutParams2);
                ReportController.o(this.C, "dc00898", "", "", "0X80077AF", "0X80077AF", 1, 0, String.valueOf(i26), String.valueOf(intExtra), "", "");
                if (QLog.isColorLevel()) {
                    QLog.d("AddFriendVerifyFragment", 2, "reportClickEvent action: 0X80077AF  sourceId = " + i26 + " subSourceId = " + intExtra);
                }
            } else if (intExtra2 != 2) {
                if (intExtra2 == 3) {
                    str2 = "true";
                    str3 = "";
                    this.f187399u0.setVisibility(0);
                    String str13 = stringArrayList.get(0);
                    TextView textView = (TextView) this.f187399u0.findViewById(R.id.textView1);
                    ClearableEditText clearableEditText = (ClearableEditText) this.f187399u0.findViewById(R.id.dmu);
                    x xVar = new x(50, clearableEditText);
                    this.f187382d0 = xVar;
                    clearableEditText.addTextChangedListener(xVar);
                    i3 = 1;
                    textView.setText(String.format("%s:%s", getString(R.string.g3d), str13));
                    clearableEditText.setSingleLine(true);
                    if (K0) {
                        textView.setContentDescription(getString(R.string.g3d) + ":" + str13);
                        clearableEditText.setContentDescription(getString(R.string.f170050e0));
                    }
                    this.f187379a0.add(textView);
                    this.Z.add(clearableEditText);
                    if (!this.S) {
                        qi();
                    }
                    this.f187393o0.setOnClickListener(new u(clearableEditText, intExtra2, i26, intExtra));
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f187401w0.getLayoutParams();
                    layoutParams3.addRule(3, this.f187399u0.getId());
                    this.f187401w0.setLayoutParams(layoutParams3);
                    ReportController.o(this.C, "dc00898", "", "", "0X80077AF", "0X80077AF", 3, 0, String.valueOf(i26), String.valueOf(intExtra), "", "");
                    if (QLog.isColorLevel()) {
                        QLog.d("AddFriendVerifyFragment", 2, "reportClickEvent action: 0X80077AF  sourceId = " + i26 + " subSourceId = " + intExtra);
                    }
                } else {
                    if (intExtra2 != 4) {
                        str2 = "true";
                        str3 = "";
                        i18 = 3;
                        i16 = 8;
                        i3 = 1;
                        if (this.E == i18) {
                            boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102224", false);
                            Intent intent2 = this.F;
                            if (intent2 != null) {
                                str4 = intent2.getStringExtra("is_from_game");
                                str3 = this.F.getStringExtra("extra");
                            } else {
                                str4 = str3;
                            }
                            try {
                                boolean enableCheckPermission = ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).enableCheckPermission();
                                str5 = str2;
                                try {
                                    if ((str5.equals(str4) || enableCheckPermission) && !TextUtils.isEmpty(str3)) {
                                        if (isSwitchOn) {
                                            com.tencent.mobileqq.addfriend.utils.a.b(this.C, getActivity().getApplicationContext(), str3, this, 1003, null);
                                        } else {
                                            com.tencent.mobileqq.addfriend.utils.a.a(this.C, getActivity().getApplicationContext(), str3, this, 1003, null);
                                        }
                                        if (QLog.isColorLevel()) {
                                            QLog.d("AddFriendVerifyFragment", 2, "AddFriend enableCheckPermission = " + enableCheckPermission);
                                        }
                                    }
                                } catch (Exception e16) {
                                    e = e16;
                                    if (str5.equals(str4) && !TextUtils.isEmpty(str3)) {
                                        if (isSwitchOn) {
                                            com.tencent.mobileqq.addfriend.utils.a.b(this.C, getActivity().getApplicationContext(), str3, this, 1003, null);
                                        } else {
                                            com.tencent.mobileqq.addfriend.utils.a.a(this.C, getActivity().getApplicationContext(), str3, this, 1003, null);
                                        }
                                    }
                                    QLog.d("AddFriendVerifyFragment", i3, "AddFriend loadConfig exception = " + e);
                                    if (intExtra != 101) {
                                        this.f187401w0.setVisibility(i16);
                                    }
                                    if (!this.N) {
                                    }
                                    Bi();
                                    intent = this.F;
                                    if (intent != null) {
                                    }
                                    oi();
                                }
                            } catch (Exception e17) {
                                e = e17;
                                str5 = str2;
                            }
                            if (intExtra != 101 && !this.N && !this.P && !this.R && !AddFriendOpenSdkConfigParser.c(i26)) {
                                this.f187401w0.setVisibility(i16);
                            }
                        }
                        if (!this.N || this.P || this.R) {
                            Bi();
                        }
                        intent = this.F;
                        if (intent != null) {
                            this.U = intent.getStringExtra("webImVisitId");
                        }
                        oi();
                    }
                    this.f187400v0.setVisibility(0);
                    StringBuffer stringBuffer = new StringBuffer();
                    if (stringArrayList == null) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16 && stringArrayList.size() == 1) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    int i27 = 0;
                    while (true) {
                        if (!z16) {
                            if (i27 < stringArrayList.size()) {
                                if (i27 != 0) {
                                    if (i27 != 1) {
                                        if (i27 != 2) {
                                            str8 = str12;
                                            string = getResources().getString(R.string.g3d);
                                        } else {
                                            str8 = str12;
                                            string = getResources().getString(R.string.g3h);
                                        }
                                    } else {
                                        str8 = str12;
                                        string = getResources().getString(R.string.g3g);
                                    }
                                } else {
                                    str8 = str12;
                                    if (z17) {
                                        string = getResources().getString(R.string.g3e);
                                    } else {
                                        string = getResources().getString(R.string.g3f);
                                    }
                                }
                                String str14 = str11;
                                String str15 = str10;
                                boolean z19 = z17;
                                View inflate = getActivity().getWindow().getLayoutInflater().inflate(R.layout.h7x, (ViewGroup) this.f187400v0, false);
                                String str16 = str9;
                                View inflate2 = getActivity().getWindow().getLayoutInflater().inflate(R.layout.h7w, (ViewGroup) this.f187400v0, false);
                                if (i27 > 0 && (layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams()) != null) {
                                    inflate.setLayoutParams(layoutParams);
                                }
                                this.f187400v0.addView(inflate);
                                this.f187400v0.addView(inflate2);
                                String str17 = stringArrayList.get(i27);
                                TextView textView2 = (TextView) inflate.findViewById(R.id.textView1);
                                textView2.setText(String.format("%s%s", string, str17));
                                EditText editText2 = (EditText) inflate2.findViewById(R.id.dmu);
                                editText2.addTextChangedListener(new x(50, editText2));
                                this.Z.add(editText2);
                                this.f187379a0.add(textView2);
                                if (K0) {
                                    textView2.setContentDescription(string + str17);
                                    this.Z.get(i27).setContentDescription(getString(R.string.f170050e0));
                                }
                                i27++;
                                stringBuffer.append(getString(R.string.g3d) + i27 + ":" + str17);
                                stringBuffer.append("\n");
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append(getString(R.string.f170342mu));
                                sb5.append(":${answer}");
                                stringBuffer.append(sb5.toString());
                                if (i27 != stringArrayList.size()) {
                                    stringBuffer.append("\n");
                                }
                                z18 = true;
                                str12 = str8;
                                str11 = str14;
                                str10 = str15;
                                z17 = z19;
                                str9 = str16;
                            } else {
                                str6 = str12;
                                str7 = str11;
                                str2 = str9;
                                str3 = str10;
                                break;
                            }
                        } else {
                            str6 = str12;
                            str7 = str11;
                            str2 = str9;
                            str3 = str10;
                            break;
                        }
                    }
                    if (!this.S) {
                        qi();
                    }
                    String str18 = str6;
                    String str19 = str7;
                    this.f187393o0.setOnClickListener(new v(stringBuffer, i26, intExtra, intExtra2));
                    findViewById(R.id.idg).setOnTouchListener(new a());
                    getActivity().getWindow().setSoftInputMode(4);
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f187401w0.getLayoutParams();
                    layoutParams4.addRule(3, this.f187400v0.getId());
                    this.f187401w0.setLayoutParams(layoutParams4);
                    ReportController.o(this.C, "dc00898", "", "", "0X80077AF", "0X80077AF", 4, 0, String.valueOf(i26), String.valueOf(intExtra), "", "");
                    if (QLog.isColorLevel()) {
                        QLog.d("AddFriendVerifyFragment", 2, str18 + i26 + str19 + intExtra);
                    }
                    i18 = 3;
                    i3 = 1;
                    i16 = 8;
                    if (this.E == i18) {
                    }
                    if (!this.N) {
                    }
                    Bi();
                    intent = this.F;
                    if (intent != null) {
                    }
                    oi();
                }
            }
            i18 = 3;
            i16 = 8;
            if (this.E == i18) {
            }
            if (!this.N) {
            }
            Bi();
            intent = this.F;
            if (intent != null) {
            }
            oi();
        }
        str2 = "true";
        str3 = "";
        i3 = 1;
        if (i26 != 3078 && i26 != 3079) {
            this.f187393o0.setOnClickListener(new s(i26, intExtra));
            ReportController.o(this.C, "dc00898", "", "", "0X80077AF", "0X80077AF", 2, 0, String.valueOf(i26), String.valueOf(intExtra), "", "");
            if (QLog.isColorLevel()) {
                QLog.d("AddFriendVerifyFragment", 2, "reportClickEvent action: 0X80077AF  sourceId = " + i26 + " subSourceId = " + intExtra);
            }
            ni(i26, intExtra2);
            i16 = 8;
        } else {
            this.f187391m0.setVisibility(0);
            this.f187386h0.setVisibility(0);
            this.f187386h0.setText(getString(R.string.f170040dn));
            if (K0) {
                EditText editText3 = this.f187391m0;
                editText3.setContentDescription(editText3.getText().toString());
            }
            i16 = 8;
            this.f187401w0.setVisibility(8);
            Intent intent3 = this.F;
            if (intent3 != null) {
                i17 = intent3.getIntExtra("contact_from_type", 1);
            } else {
                i17 = 1;
            }
            this.f187393o0.setOnClickListener(new r(i17));
        }
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.f187401w0.getLayoutParams();
        i18 = 3;
        layoutParams5.addRule(3, R.id.f26490do);
        this.f187401w0.setLayoutParams(layoutParams5);
        if (this.E == i18) {
        }
        if (!this.N) {
        }
        Bi();
        intent = this.F;
        if (intent != null) {
        }
        oi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ii(int i3) {
        if (i3 == 3004) {
            return true;
        }
        return false;
    }

    private void initUI() {
        int i3;
        setTitle(HardCodeUtil.qqStr(R.string.f197254ji));
        boolean z16 = false;
        if (AppSetting.t(getContext())) {
            RelativeLayout relativeLayout = this.titleRoot;
            if (relativeLayout != null) {
                relativeLayout.setFitsSystemWindows(false);
                this.titleRoot.setPadding(0, 0, 0, 0);
            }
            NavBarCommon navBarCommon = this.f211174vg;
            if (navBarCommon != null) {
                ViewGroup.LayoutParams layoutParams = navBarCommon.getLayoutParams();
                int statusBarHeight = ImmersiveUtils.getStatusBarHeight(getContext());
                layoutParams.height += statusBarHeight;
                this.f211174vg.setLayoutParams(layoutParams);
                this.f211174vg.setPadding(0, statusBarHeight, 0, 0);
            }
        }
        Mi(getResources().getString(R.string.j3m));
        QQProgressDialog qQProgressDialog = new QQProgressDialog(getActivity(), getQBaseActivity().getTitleBarHeight());
        this.f187397s0 = qQProgressDialog;
        qQProgressDialog.setMessage(R.string.f170716zu);
        BounceScrollView bounceScrollView = (BounceScrollView) findViewById(R.id.adt);
        this.f187398t0 = bounceScrollView;
        bounceScrollView.setOnTouchListener(new p());
        this.f187394p0 = (ImageView) findViewById(R.id.fxg);
        this.f187385g0 = (TextView) findViewById(R.id.nickname);
        this.f187395q0 = (FlowLabelLayout) findViewById(R.id.f165250vc2);
        this.f187391m0 = (EditText) findViewById(R.id.f166785i82);
        this.f187386h0 = (TextView) findViewById(R.id.f166786i83);
        x xVar = new x(100, this.f187391m0);
        this.f187381c0 = xVar;
        this.f187391m0.addTextChangedListener(xVar);
        this.f187391m0.setOnTouchListener(this);
        this.f187399u0 = (LinearLayout) findViewById(R.id.f6v);
        this.f187400v0 = (LinearLayout) findViewById(R.id.f164345si);
        this.f187387i0 = (TextView) findViewById(R.id.f98775o0);
        this.f187388j0 = (TextView) findViewById(R.id.f98485n8);
        this.f187401w0 = (LinearLayout) findViewById(R.id.cxh);
        FormItemRelativeLayout formItemRelativeLayout = (FormItemRelativeLayout) findViewById(R.id.idd);
        this.f187403y0 = formItemRelativeLayout;
        formItemRelativeLayout.setBackgroundDrawable(getResources().getDrawable(R.drawable.j38));
        this.f187392n0 = (ClearableEditText) findViewById(R.id.bz4);
        FormItemRelativeLayout formItemRelativeLayout2 = (FormItemRelativeLayout) findViewById(R.id.ici);
        this.f187404z0 = formItemRelativeLayout2;
        formItemRelativeLayout2.setBackgroundDrawable(getResources().getDrawable(R.drawable.j38));
        this.f187389k0 = (TextView) findViewById(R.id.k8i);
        this.f187392n0.addTextChangedListener(this);
        this.f187404z0.setOnClickListener(this);
        if (!TextUtils.isEmpty(this.I)) {
            this.f187392n0.setText(this.I);
            this.f187392n0.setSelection(this.I.length());
        } else {
            String b16 = ay.b(this.D);
            if (!TextUtils.isEmpty(b16)) {
                this.H = b16;
            }
            this.f187392n0.setText(this.H);
            if (!TextUtils.isEmpty(this.H)) {
                this.f187392n0.setSelection(this.H.length());
            }
        }
        this.f187389k0.setText(com.tencent.mobileqq.addfriend.utils.a.i(this.C, this.G));
        this.f187404z0.setContentDescription(com.tencent.mobileqq.addfriend.utils.a.i(this.C, this.G));
        if (Utils.G(this.D)) {
            this.f187403y0.setVisibility(8);
            this.f187387i0.setVisibility(8);
        } else {
            this.f187403y0.setVisibility(0);
            this.f187387i0.setText(getString(R.string.ykk));
        }
        this.f187388j0.setText(getString(R.string.ykj));
        if (friendlist.a.a(this.J) || (i3 = this.J) == 3016 || i3 == 3103) {
            z16 = true;
        }
        this.Y = z16;
        Ni();
        this.f187390l0 = (TextView) findViewById(R.id.sd8);
        this.f187393o0 = (Button) findViewById(R.id.tdp);
    }

    private void ji() {
        Dialog dialog = this.f187396r0;
        if (dialog != null && dialog.isShowing() && this.f187396r0.getWindow() != null) {
            try {
                this.f187396r0.dismiss();
            } catch (Throwable unused) {
            }
        }
    }

    private String ki(String str, String str2) {
        boolean z16;
        String str3;
        String stringExtra = this.F.getStringExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME);
        if (!TextUtils.isEmpty(stringExtra)) {
            String matchFriendAppName = ((IMatchFriendDataUtilApi) QRoute.api(IMatchFriendDataUtilApi.class)).matchFriendAppName(this.C);
            if (TextUtils.isEmpty(matchFriendAppName)) {
                str3 = str + stringExtra;
            } else {
                str3 = str + matchFriendAppName + "\u7684" + stringExtra;
            }
            str2 = str3;
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return str2 + com.tencent.mobileqq.addfriend.utils.a.g(this.C);
        }
        return str2;
    }

    private String li(String str, String str2) {
        boolean z16 = false;
        if (this.N) {
            String stringExtra = this.F.getStringExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME);
            if (stringExtra != null && !stringExtra.isEmpty()) {
                str2 = (str + getString(R.string.ykd)) + stringExtra;
            }
            z16 = true;
        } else if (this.P) {
            str2 = ki(str, str2);
        } else {
            if (this.Q) {
                str2 = si();
            }
            z16 = true;
        }
        if (z16) {
            return str2 + com.tencent.mobileqq.addfriend.utils.a.g(this.C);
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mi() {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.addfriend.ui.AddFriendVerifyFragment.22
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendVerifyFragment.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    AddFriendVerifyFragment.this.Ai();
                }
            }
        }, 900L);
    }

    private void oi() {
        Button button = this.f187393o0;
        TextView textView = this.f187390l0;
        if (button != null && textView != null) {
            VideoReport.addToDetectionWhitelist(getActivity());
            VideoReport.setPageId(this.titleRoot, "pg_add_user");
            HashMap hashMap = new HashMap();
            hashMap.put("add_user_to_uin", this.D);
            hashMap.put("add_user_sourceid", Integer.valueOf(this.J));
            hashMap.put("add_user_subsourceid", Integer.valueOf(this.K));
            int intExtra = this.F.getIntExtra("friend_setting", 0);
            HashMap<Integer, Integer> hashMap2 = M0;
            if (hashMap2.containsKey(Integer.valueOf(intExtra))) {
                hashMap.put("add_type", hashMap2.get(Integer.valueOf(intExtra)));
            }
            if (!TextUtils.isEmpty(this.M)) {
                hashMap.put("recom_trace", this.M);
            }
            if (this.E == 3) {
                hashMap.put("add_user_appid", this.F.getStringExtra("extra"));
                hashMap.put("add_user_to_openid", this.D);
            }
            VideoReport.setPageParams(this.titleRoot, new PageParams(hashMap));
            VideoReport.setElementId(button, "em_add_user_send_request");
            ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
            VideoReport.setElementExposePolicy(button, exposurePolicy);
            ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
            VideoReport.setElementClickPolicy(button, clickPolicy);
            VideoReport.setElementId(textView, "em_add_report_user");
            VideoReport.setElementExposePolicy(textView, exposurePolicy);
            VideoReport.setElementClickPolicy(textView, clickPolicy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pi() {
        Button button = this.f187393o0;
        HashMap hashMap = new HashMap();
        if (!this.Y) {
            hashMap.put("kl_new_add_request", Integer.valueOf(this.f187402x0.h()));
        }
        VideoReport.setElementParams(button, hashMap);
        VideoReport.reportEvent("clck", button, null);
        ((IO3ReportApi) QRoute.api(IO3ReportApi.class)).reportAddFriendClick(this.T);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ri(int i3, String str) {
        if (!Di() && this.J == 3090) {
            try {
                ((IForwardApi) QRoute.api(IForwardApi.class)).startGameSdkCallback(getActivity(), true, "action_game_make_friend", Long.parseLong(this.F.getStringExtra("extra")), i3, str);
            } catch (Exception e16) {
                QLog.e("AddFriendVerifyFragment", 1, "feedBackToGameSDK error = " + e16);
            }
        }
    }

    private String si() {
        String wi5 = wi();
        String l3 = com.tencent.mobileqq.addfriend.utils.a.l(this.C, wi5);
        if (wi5.equals(l3)) {
            QLog.i("AddFriendVerifyFragment", 1, "get TroopName Fail " + wi5);
            l3 = "";
        }
        AppInterface appInterface = this.C;
        String k3 = com.tencent.mobileqq.addfriend.utils.a.k(appInterface, wi5, appInterface.getAccount());
        if (TextUtils.isEmpty(k3) || k3.equals(this.C.getAccount())) {
            k3 = com.tencent.mobileqq.addfriend.utils.a.g(this.C);
        }
        if (TextUtils.isEmpty(l3)) {
            return getString(R.string.axv) + k3;
        }
        if (l3.length() > 20) {
            l3 = l3.substring(0, 17) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        }
        return getString(R.string.zvc, l3, k3);
    }

    private void ti(URLDrawable uRLDrawable) {
        if (uRLDrawable != null && this.C != null && this.f187394p0 != null) {
            Bitmap drawabletoBitmap = BaseImageUtil.drawabletoBitmap(uRLDrawable);
            if (uRLDrawable.getStatus() == 1) {
                this.f187394p0.setImageDrawable(new BitmapDrawable(com.tencent.mobileqq.avatar.utils.c.e(drawabletoBitmap, 50, 50)));
            } else {
                uRLDrawable.setURLDrawableListener(new e());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, String> ui(int i3) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("sourceid", String.valueOf(this.J));
        hashMap.put("subsourceid", String.valueOf(this.K));
        hashMap.put("errorCode", String.valueOf(i3));
        return hashMap;
    }

    private String vi() {
        String k3 = com.tencent.mobileqq.addfriend.utils.a.k(this.C, wi(), this.D);
        if (this.D.equals(k3)) {
            k3 = "";
        }
        if (TextUtils.isEmpty(k3) || this.D.equals(k3)) {
            k3 = com.tencent.mobileqq.addfriend.utils.a.h(this.C, this.D);
        }
        if (TextUtils.isEmpty(k3) || this.D.equals(k3)) {
            return this.F.getStringExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME);
        }
        return k3;
    }

    private String wi() {
        String stringExtra = this.F.getStringExtra("param_return_profilecard_group_uin");
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = this.F.getStringExtra("troop_uin");
        }
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = this.F.getStringExtra("extra");
        }
        if (stringExtra == null) {
            return "";
        }
        return stringExtra;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String xi(boolean z16) {
        if (getActivity() == null) {
            return null;
        }
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("last_verify_msg", 0);
        if (z16) {
            return sharedPreferences.getString("last_add_troop_verfity_" + this.C.getAccount(), null);
        }
        return sharedPreferences.getString("last_add_friend_verify_" + this.C.getAccount(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean yi() {
        if (getActivity() == null) {
            return false;
        }
        return getActivity().getSharedPreferences("last_verify_msg", 0).getBoolean("add_friend_verify_msg_modify_flag" + this.C.getAccount(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View zi(LabelTag labelTag) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dro, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.ycf);
        TextView textView = (TextView) inflate.findViewById(R.id.yck);
        if (!TextUtils.isEmpty(labelTag.getIcon())) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.color.ajr, null);
            obtain.mLoadingDrawable = drawable;
            obtain.mFailedDrawable = drawable;
            imageView.setImageDrawable(URLDrawable.getDrawable(labelTag.getIcon(), obtain));
        } else {
            imageView.setVisibility(8);
        }
        if (!TextUtils.isEmpty(labelTag.getText())) {
            textView.setText(labelTag.getText());
        } else {
            textView.setVisibility(8);
        }
        Gi(inflate, textView);
        return inflate;
    }

    void Ai() {
        if (Di()) {
            return;
        }
        if (this.F.getBooleanExtra("need_jumpto_splash", false)) {
            if (Fi()) {
                return;
            }
            ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).jumpToSplash(getActivity());
            getActivity().finish();
            return;
        }
        String stringExtra = this.F.getStringExtra("param_return_addr");
        if (QLog.isColorLevel()) {
            QLog.d("AddFriendVerifyFragment", 2, "goBack | retAddr = " + stringExtra);
        }
        if (stringExtra != null) {
            try {
                Intent composeReturnIntent = ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).composeReturnIntent(Class.forName(stringExtra), this.D, getActivity());
                if (AppSetting.t(getContext()) && (getContext() instanceof com.tencent.mobileqq.pad.l)) {
                    com.tencent.mobileqq.pad.i.e(getContext(), ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getProfileCardBundle(getContext(), (AllInOne) composeReturnIntent.getParcelableExtra(IProfileCardConst.KEY_ALL_IN_ONE), new Bundle()), ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getProfileCardFragmentClass(), new com.tencent.mobileqq.pad.b().e(false).g(true).h(LaunchMode.singleTop).a());
                } else {
                    startActivity(composeReturnIntent);
                }
                return;
            } catch (ClassNotFoundException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("AddFriendVerifyFragment", 2, "goBack | exception = ", e16);
                }
                e16.printStackTrace();
                if (Fi()) {
                    return;
                }
                getActivity().setResult(-1);
                getActivity().finish();
                return;
            }
        }
        if (Fi()) {
            return;
        }
        if (this.F.getBooleanExtra("from_newer_guide", false)) {
            Intent intent = new Intent();
            intent.putExtra("has_operation", true);
            intent.putExtra("uin", this.D);
            getActivity().setResult(-1, intent);
        } else {
            ri(0, "");
            getActivity().setResult(-1);
        }
        getActivity().finish();
    }

    void Ii(String str) {
        ArrayList arrayList;
        if (Di()) {
            return;
        }
        if (!NetworkUtil.isNetSupport(getActivity())) {
            QQToast.makeText(this.C.getApp(), 1, getString(R.string.f173065h22), 0).show(getQBaseActivity().getTitleBarHeight());
            return;
        }
        if (this.F.hasExtra("contacts") && (arrayList = (ArrayList) this.F.getSerializableExtra("contacts")) != null && arrayList.size() > 0) {
            if (this.f187397s0 == null) {
                QQProgressDialog qQProgressDialog = new QQProgressDialog(getActivity(), getQBaseActivity().getTitleBarHeight());
                this.f187397s0 = qQProgressDialog;
                qQProgressDialog.setOnDismissListener(new d());
            }
            this.f187397s0.setCancelable(true);
            this.f187397s0.setCanceledOnTouchOutside(false);
            this.f187397s0.setMessage(R.string.hex);
            this.f187397s0.show();
            this.f187380b0.clear();
            this.f187380b0.addAll(arrayList);
            ((IFriendHandlerService) this.C.getRuntimeService(IFriendHandlerService.class, "")).requestAddBatchPhoneFriend(this.f187380b0, str, 0, this.J, new ArrayList<>());
        }
    }

    void Li(String str, boolean z16) {
        int i3;
        if (getActivity() == null) {
            return;
        }
        if (this.f187383e0 == null && (i3 = this.J) != 3016 && i3 != 3103) {
            if (!this.N && !this.P && !this.R && !this.Q) {
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("last_verify_msg", 0);
                if (z16) {
                    sharedPreferences.edit().putString("last_add_troop_verfity_" + this.C.getAccount(), str).commit();
                    return;
                }
                sharedPreferences.edit().putString("last_add_friend_verify_" + this.C.getAccount(), str).commit();
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AddFriendVerifyFragment", 2, "saveVerifyMsg return from wzry");
        }
    }

    public void Mi(CharSequence charSequence) {
        QUISecNavBar qUISecNavBar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) charSequence);
        } else if (useQUISecNavBar() && (qUISecNavBar = this.quiSecNavBar) != null) {
            qUISecNavBar.setLeftType(1);
            this.quiSecNavBar.setLeftText(charSequence);
            this.quiSecNavBar.setOnBaseTitleBarClickListener(new q());
        }
    }

    void Si(String str, byte[] bArr, String str2) {
        if (Di()) {
            return;
        }
        if (!NetworkUtil.isNetSupport(getActivity())) {
            QQToast.makeText(this.C.getApp(), 1, getString(R.string.cjm), 0).show(getQBaseActivity().getTitleBarHeight());
            return;
        }
        if (this.f187397s0 == null) {
            QQProgressDialog qQProgressDialog = new QQProgressDialog(getActivity(), getQBaseActivity().getTitleBarHeight());
            this.f187397s0 = qQProgressDialog;
            qQProgressDialog.setOnDismissListener(new c());
        }
        this.f187397s0.setMessage(R.string.hex);
        this.f187397s0.setCancelable(true);
        this.f187397s0.setCanceledOnTouchOutside(false);
        try {
            this.f187397s0.show();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("AddFriendVerifyFragment", 2, e16.toString());
            }
        }
        Intent intent = this.F;
        int intExtra = intent.getIntExtra("sub_source_id", 0);
        int intExtra2 = intent.getIntExtra("friend_setting", 0);
        if (intExtra2 == 3) {
            intExtra2 = 100;
        }
        int i3 = intExtra2;
        boolean booleanExtra = intent.getBooleanExtra("contact_bothway", false);
        String stringExtra = intent.getStringExtra("src_name");
        if (!this.Y) {
            int i16 = this.f187402x0.i();
            Bundle bundleExtra = intent.getBundleExtra("flc_extra_param");
            if (bundleExtra == null) {
                bundleExtra = new Bundle();
            }
            bundleExtra.putInt("friend_permission", i16);
            this.F.putExtra("flc_extra_param", bundleExtra);
        }
        ((IFriendHandlerService) this.C.getRuntimeService(IFriendHandlerService.class, "")).requestAddFriendWithMyCard(this.D, intent.getStringExtra("extra"), i3, (byte) this.G, str, this.J, intExtra, this.L, true, bArr, booleanExtra, this.f187392n0.getText().toString(), stringExtra, intent.getByteExtra("show_my_card", (byte) 0), str2, intent.getBundleExtra("flc_extra_param"), true, intent.getByteArrayExtra("flc_add_frd_token"));
        if (!com.tencent.mobileqq.addfriend.utils.a.d(i3, this.J, booleanExtra)) {
            ((IAddFriendServiceApi) this.C.getRuntimeService(IAddFriendServiceApi.class, "")).setAddFriendReqStatus(this.D, true);
        }
        if (!this.f187392n0.getText().toString().equals(this.H) && !this.f187392n0.getText().toString().equals(this.I)) {
            ReportController.o(this.C, "dc00898", "", "", "0X80077B1", "0X80077B1", 0, 0, "", "", "", "");
        }
        if (intent.getIntExtra("sort_id", 0) == 3090) {
            ReportController.o(this.C, "CliOper", "", "", "0x80084AE", "0x80084AE", 0, 0, "", "", "", "");
        }
        Iterator<com.tencent.mobileqq.addfriend.processor.a> it = this.B0.iterator();
        while (it.hasNext()) {
            it.next().b(this.D, this.J, intExtra, this.T);
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) editable);
            return;
        }
        String obj = this.f187392n0.getText().toString();
        if (com.tencent.mobileqq.addfriend.utils.a.e(obj) > 32) {
            int selectionStart = this.f187392n0.getSelectionStart();
            String j3 = com.tencent.mobileqq.addfriend.utils.a.j(obj);
            this.f187392n0.setText(j3);
            if (selectionStart >= j3.length()) {
                this.f187392n0.setSelection(j3.length());
            }
        }
        if (K0) {
            this.f187403y0.setContentDescription(getResources().getString(R.string.bws) + this.f187392n0.getText().toString());
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        OpenAddFriendPart openAddFriendPart = new OpenAddFriendPart();
        this.D0 = openAddFriendPart;
        arrayList.add(openAddFriendPart);
        return arrayList;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, layoutInflater, viewGroup, bundle);
            return;
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        this.C = (AppInterface) getQBaseActivity().getAppRuntime();
        com.tencent.mobileqq.addfriend.helper.a aVar = new com.tencent.mobileqq.addfriend.helper.a();
        this.A0 = aVar;
        this.B0 = aVar.a(this.C);
        if (Di()) {
            return;
        }
        Ci(bundle);
        initUI();
        hi();
        Window window = getActivity().getWindow();
        if (window != null) {
            window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.F0);
            window.setSoftInputMode(32);
        }
        this.C.addObserver(this.G0);
        this.C.addObserver(this.H0);
        this.C.addObserver(this.I0);
        this.C.addObserver(this.J0);
        L0 = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return R.layout.h7y;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) activity);
        } else {
            activity.overridePendingTransition(R.anim.f154424l, R.anim.f154425m);
        }
    }

    void ni(int i3, int i16) {
        if (getActivity() == null) {
            return;
        }
        ThreadManagerV2.post(new Runnable(i3, this.F.getIntExtra("sub_source_id", 0), this.F.getBooleanExtra("select_multi_mode", false), this.F.getStringExtra("troop_uin"), i16) { // from class: com.tencent.mobileqq.addfriend.ui.AddFriendVerifyFragment.13
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f187405d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f187406e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ boolean f187407f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ String f187408h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ int f187409i;

            {
                this.f187405d = i3;
                this.f187406e = r7;
                this.f187407f = r8;
                this.f187408h = r9;
                this.f187409i = i16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, AddFriendVerifyFragment.this, Integer.valueOf(i3), Integer.valueOf(r7), Boolean.valueOf(r8), r9, Integer.valueOf(i16));
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
                if (this.f187405d == 3004) {
                    int i17 = this.f187406e;
                    if (i17 == 5 || i17 == 6 || i17 == 7 || i17 == 8) {
                        if (this.f187407f) {
                            str = "multiMode_send";
                        } else {
                            str = "singleMode_send";
                        }
                        String str2 = str;
                        AppInterface appInterface = AddFriendVerifyFragment.this.C;
                        String str3 = this.f187408h;
                        if (this.f187407f) {
                            valueOf = "1";
                        } else {
                            valueOf = String.valueOf(this.f187409i);
                        }
                        ReportController.o(appInterface, "dc00899", "Grp_addFrd", "", "frd_select", str2, 0, 0, str3, valueOf, "", "");
                    }
                }
            }
        }, 5, null, true);
        ((IO3ReportApi) QRoute.api(IO3ReportApi.class)).reportAddFriendClick(i3);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        boolean z18 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
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
            QLog.d("AddFriendVerifyFragment", 2, sb5.toString());
        }
        if (Di()) {
            return;
        }
        if (i3 == 0 && i16 == -1) {
            getActivity().setResult(i16, intent);
            getActivity().finish();
        }
        if (i3 != 1002) {
            if (i3 == 1004) {
                if (intent != null) {
                    String stringExtra = intent.getStringExtra("ticket");
                    Bundle bundle = this.V;
                    if (bundle != null) {
                        Si(bundle.getString("msg", ""), this.V.getByteArray(PreloadTRTCPlayerParams.KEY_SIG), stringExtra);
                    } else {
                        QQProgressDialog qQProgressDialog = this.f187397s0;
                        if (qQProgressDialog != null) {
                            qQProgressDialog.cancel();
                            this.f187397s0 = null;
                        }
                        Pi(getString(R.string.f173065h22));
                        Ji();
                        z17 = false;
                    }
                    z18 = z17;
                } else {
                    QQProgressDialog qQProgressDialog2 = this.f187397s0;
                    if (qQProgressDialog2 != null) {
                        qQProgressDialog2.cancel();
                        this.f187397s0 = null;
                    }
                    Pi(getString(R.string.f173065h22));
                    Ji();
                }
                if (QLog.isColorLevel()) {
                    QLog.d("AddFriendVerifyFragment", 2, "REQUEST_CODE_SECCHECK_H5_PAGE, isSuccess=" + z18);
                    return;
                }
                return;
            }
            return;
        }
        if (intent != null) {
            byte byteExtra = intent.getByteExtra("result", (byte) 0);
            this.G = byteExtra;
            this.f187389k0.setText(((IAddFriendApi) QRoute.api(IAddFriendApi.class)).getGroupName(this.C, byteExtra));
            this.f187404z0.setContentDescription(HardCodeUtil.qqStr(R.string.j4e) + ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).getGroupName(this.C, byteExtra));
        }
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            boolean z16 = false;
            if (Fi()) {
                doCallback(4, "");
                return false;
            }
            if (AppSetting.t(activity)) {
                doCallback(4, "");
                return super.onBackEvent();
            }
            doCallback(4, "");
            Ji();
            if (this.F.getBooleanExtra("need_jumpto_splash", false)) {
                ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).jumpToSplash(getActivity());
                return super.onBackEvent();
            }
            if (this.E != 4) {
                String obj = this.f187391m0.getText().toString();
                if (4 == this.E) {
                    z16 = true;
                }
                Li(obj, z16);
                if (getString(R.string.axv).equals(obj) && !yi()) {
                    Hi();
                }
            }
            if (!TextUtils.isEmpty(this.U)) {
                ReportController.o(this.C, "dc00899", "Qidian", this.D, "0X8008802", "ClickAddFriendButton", 0, 0, "2", "", "", "");
            }
            return super.onBackEvent();
        }
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) view);
        } else if (view.getId() == R.id.ici && !Di()) {
            ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).jumpToMoveGroup(getActivity(), this, this.D, this.G, 1002);
            EditText editText = this.f187391m0;
            if (editText != null) {
                Li(editText.getText().toString(), false);
            }
            ReportController.o(this.C, "dc00898", "", "", "0X80077B2", "0X80077B2", 0, 0, "", "", "", "");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.onDestroy();
        com.tencent.mobileqq.friend.observer.a aVar = this.H0;
        if (aVar != null) {
            this.C.removeObserver(aVar);
        }
        ProfileCardObserver profileCardObserver = this.G0;
        if (profileCardObserver != null) {
            this.C.removeObserver(profileCardObserver);
        }
        com.tencent.qidian.controller.c cVar = this.I0;
        if (cVar != null) {
            this.C.removeObserver(cVar);
        }
        com.tencent.mobileqq.addfriend.observer.a aVar2 = this.J0;
        if (aVar2 != null) {
            this.C.removeObserver(aVar2);
        }
        ji();
        if (getActivity() == null) {
            return;
        }
        getActivity().getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this.F0);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        super.onFinish();
        if (getActivity() == null) {
            return;
        }
        ((InputMethodManager) getActivity().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(this.titleRoot.getWindowToken(), 0);
        getActivity().getWindow().setSoftInputMode(2);
        if (this.E != 4) {
            getActivity().overridePendingTransition(0, R.anim.f154458a7);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c0  */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onResume() {
        String str;
        String str2;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onResume();
        if (Di()) {
            return;
        }
        if (this.E != 4) {
            int intExtra = this.F.getIntExtra("friend_setting", 0);
            if (intExtra != 0) {
                if (intExtra == 1) {
                    String string = getString(R.string.axv);
                    if (this.F.getBooleanExtra("_FROM_QLINK_", false)) {
                        str = string + getString(R.string.f4f) + " " + com.tencent.mobileqq.addfriend.utils.a.g(this.C);
                        this.f187391m0.setHint(str);
                    } else {
                        this.f187391m0.setHint("");
                        str = string;
                    }
                    this.f187391m0.setVisibility(0);
                    this.f187386h0.setVisibility(0);
                    if (K0) {
                        EditText editText = this.f187391m0;
                        editText.setContentDescription(editText.getText().toString());
                    }
                    if (this.E == 3) {
                        str2 = this.F.getStringExtra("msg");
                    } else {
                        KplRoleInfo.WZRYUIinfo wZRYUIinfo = this.f187383e0;
                        if (wZRYUIinfo != null) {
                            str2 = wZRYUIinfo.verifyMsg;
                            if (!TextUtils.isEmpty(str2)) {
                                z16 = false;
                                if (TextUtils.isEmpty(str2)) {
                                    str2 = xi(false);
                                }
                                if (!TextUtils.isEmpty(str2)) {
                                    str = str2;
                                }
                                if ((z16 && string.equals(str) && !yi()) || Ei()) {
                                    str = li(string, str);
                                }
                                this.f187391m0.setText(str);
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
                        str = li(string, str);
                        this.f187391m0.setText(str);
                    }
                    str = li(string, str);
                    this.f187391m0.setText(str);
                }
            } else {
                int i3 = this.J;
                if (i3 == 3078 || i3 == 3079 || i3 == 3912) {
                    String xi5 = xi(false);
                    String string2 = getString(R.string.axv);
                    if (TextUtils.isEmpty(xi5)) {
                        if (yi() && !Ei()) {
                            if (this.P) {
                                xi5 = ki(string2, string2);
                            } else {
                                xi5 = string2;
                            }
                        } else {
                            xi5 = li(string2, string2);
                        }
                    }
                    if (this.R) {
                        xi5 = this.F.getStringExtra("msg");
                    }
                    this.f187391m0.setHint("");
                    this.f187391m0.setText(xi5);
                }
            }
        }
        com.tencent.relation.common.report.a.c("relation_addfriend_page_showtime", System.currentTimeMillis() - this.F.getLongExtra("startAddFriendCheckFragment", 0L), true, ui(0));
        ((IO3ReportApi) QRoute.api(IO3ReportApi.class)).reportAddFriendExposure(this.T);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            super.onStart();
            getActivity();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            super.onStop();
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
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

    public void qi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.f187390l0.setVisibility(0);
            this.f187390l0.setOnClickListener(new b());
        }
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, jSONObject, Integer.valueOf(i3), bundle);
            return;
        }
        if (i3 == 1003 && jSONObject != null) {
            try {
                int intValue = ((Integer) jSONObject.get("retcode")).intValue();
                JSONObject jSONObject2 = (JSONObject) jSONObject.get("result");
                if (intValue == 0 && jSONObject2 != null) {
                    if (QLog.isColorLevel()) {
                        QLog.i("AddFriendVerifyFragment", 2, "checkApiState onResult. retCode = " + intValue + "\n");
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
                            String str6 = (String) jSONObject4.get(DTConstants.TAG.API);
                            String str7 = (String) jSONObject4.get(str3);
                            JSONArray jSONArray5 = jSONArray4;
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
                                QLog.i("AddFriendVerifyFragment", 2, sb5.toString());
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
                                Oi();
                            }
                            if (QLog.isColorLevel()) {
                                StringBuilder sb6 = new StringBuilder();
                                str = str4;
                                sb6.append("checkApiState onResult, friendlink name = ");
                                sb6.append(str9);
                                sb6.append(" state = ");
                                sb6.append(intValue3);
                                sb6.append(" api = ");
                                sb6.append(str10);
                                sb6.append(" msg= ");
                                sb6.append(str12);
                                sb6.append("\n");
                                QLog.i("AddFriendVerifyFragment", 2, sb6.toString());
                            } else {
                                str = str4;
                            }
                            i17++;
                            jSONArray3 = jSONArray6;
                            str4 = str;
                        }
                    }
                    String str13 = str4;
                    int intValue4 = ((Integer) jSONObject2.get("appid")).intValue();
                    if (QLog.isColorLevel()) {
                        QLog.i("AddFriendVerifyFragment", 2, "checkApiState onResult, appid =" + intValue4 + "\n");
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
                                StringBuilder sb7 = new StringBuilder();
                                jSONArray2 = jSONArray;
                                sb7.append("checkApiState onResult, qqpay name = ");
                                sb7.append(str14);
                                sb7.append(" state = ");
                                sb7.append(intValue5);
                                sb7.append(" api = ");
                                sb7.append(str16);
                                sb7.append(" msg= ");
                                sb7.append(str18);
                                sb7.append("\n");
                                QLog.i("AddFriendVerifyFragment", 2, sb7.toString());
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
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("AddFriendVerifyFragment", 2, "checkApiState onResult " + e16.toString());
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean useQUISecNavBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
        }
        return true;
    }
}
