package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.common.galleryactivity.GalleryManager;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.Utils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.avatar.api.IQQAvatarDataService;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.data.DynamicAvatar;
import com.tencent.mobileqq.picbrowser.PicBrowserActivity;
import com.tencent.mobileqq.picbrowser.PicBrowserImage;
import com.tencent.mobileqq.picbrowser.PicInfo;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.api.IProfileEditApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.wink.api.IQQWinkLaucher;
import com.tencent.mobileqq.wink.api.IQQWinkLauncher;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.util.CommonMMKVUtils;
import com.tencent.widget.ActionSheet;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes9.dex */
public class FriendProfilePicBrowserActivity extends PicBrowserActivity implements View.OnClickListener, DialogInterface.OnCancelListener, PicBrowserImage.b {
    static IPatchRedirector $redirector_;

    /* renamed from: g0, reason: collision with root package name */
    private Button f176066g0;

    /* renamed from: h0, reason: collision with root package name */
    private Button f176067h0;

    /* renamed from: i0, reason: collision with root package name */
    private ImageView f176068i0;

    /* renamed from: j0, reason: collision with root package name */
    Handler f176069j0;

    /* renamed from: k0, reason: collision with root package name */
    com.tencent.mobileqq.profile.c f176070k0;

    /* renamed from: l0, reason: collision with root package name */
    int f176071l0;

    /* renamed from: m0, reason: collision with root package name */
    boolean f176072m0;

    /* renamed from: n0, reason: collision with root package name */
    int f176073n0;

    /* renamed from: o0, reason: collision with root package name */
    ArrayList<String> f176074o0;

    /* renamed from: p0, reason: collision with root package name */
    private IQQAvatarDataService f176075p0;

    /* renamed from: q0, reason: collision with root package name */
    private String f176076q0;

    /* renamed from: r0, reason: collision with root package name */
    private CheckBox f176077r0;

    /* renamed from: s0, reason: collision with root package name */
    private View f176078s0;

    /* renamed from: t0, reason: collision with root package name */
    private String f176079t0;

    /* renamed from: u0, reason: collision with root package name */
    private int f176080u0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendProfilePicBrowserActivity.this);
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            } else {
                CommonMMKVUtils.putBoolean("sp_key_history_avatar_sync_qcircle", z16, true);
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class b implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f176082d;

        b(ActionSheet actionSheet) {
            this.f176082d = actionSheet;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendProfilePicBrowserActivity.this, (Object) actionSheet);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            this.f176082d.dismiss();
            if (i3 == 0) {
                FriendProfilePicBrowserActivity.this.S2();
                ReportController.o(FriendProfilePicBrowserActivity.this.app, "dc00898", "", "", "0X800A8CA", "0X800A8CA", 0, 0, "1", "", "", "");
                return;
            }
            if (i3 == 1) {
                FriendProfilePicBrowserActivity.this.T2();
                ReportController.o(FriendProfilePicBrowserActivity.this.app, "dc00898", "", "", "0X800A8CB", "0X800A8CB", 0, 0, "1", "", "", "");
                return;
            }
            if (i3 == 2) {
                FriendProfilePicBrowserActivity.this.j3();
                FriendProfilePicBrowserActivity friendProfilePicBrowserActivity = FriendProfilePicBrowserActivity.this;
                ReportController.o(friendProfilePicBrowserActivity.app, "dc00898", "", "", "0X8007C14", "0X8007C14", friendProfilePicBrowserActivity.f176071l0, 0, "", "", "", "");
                ReportController.o(FriendProfilePicBrowserActivity.this.app, "dc00898", "", "", "0X800A8CC", "0X800A8CC", 0, 0, "1", "", "", "");
                return;
            }
            if (i3 == 3) {
                FriendProfilePicBrowserActivity.this.forwardFavorite();
                ReportController.o(FriendProfilePicBrowserActivity.this.app, "dc00898", "", "", "0X800A8CD", "0X800A8CD", 0, 0, "1", "", "", "");
            } else if (i3 == 4) {
                FriendProfilePicBrowserActivity.this.R2();
                ReportController.o(FriendProfilePicBrowserActivity.this.app, "dc00898", "", "", "0X8007C15", "0X8007C15", 0, 0, "", "", "", "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class c implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQCustomDialog f176084d;

        c(QQCustomDialog qQCustomDialog) {
            this.f176084d = qQCustomDialog;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendProfilePicBrowserActivity.this, (Object) qQCustomDialog);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                this.f176084d.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class d implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQCustomDialog f176086d;

        d(QQCustomDialog qQCustomDialog) {
            this.f176086d = qQCustomDialog;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendProfilePicBrowserActivity.this, (Object) qQCustomDialog);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            this.f176086d.dismiss();
            Intent intent = FriendProfilePicBrowserActivity.this.getIntent();
            intent.putExtra("delHead_fileid", FriendProfilePicBrowserActivity.this.V2());
            FriendProfilePicBrowserActivity.this.setResult(-1, intent);
            FriendProfilePicBrowserActivity.this.finish();
        }
    }

    /* loaded from: classes9.dex */
    class e extends GalleryManager {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendProfilePicBrowserActivity.this);
            }
        }

        @Override // com.tencent.common.galleryactivity.GalleryManager
        public com.tencent.common.galleryactivity.a d(Activity activity, com.tencent.common.galleryactivity.e eVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (com.tencent.common.galleryactivity.a) iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity, (Object) eVar);
            }
            return super.d(activity, eVar);
        }

        @Override // com.tencent.common.galleryactivity.GalleryManager
        public com.tencent.common.galleryactivity.c g(Activity activity, com.tencent.common.galleryactivity.e eVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.common.galleryactivity.c) iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) eVar);
            }
            FriendProfilePicBrowserActivity.this.f176070k0 = new com.tencent.mobileqq.profile.c((FriendProfilePicBrowserActivity) activity, eVar);
            return FriendProfilePicBrowserActivity.this.f176070k0;
        }

        @Override // com.tencent.common.galleryactivity.GalleryManager
        public com.tencent.common.galleryactivity.e h(Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (com.tencent.common.galleryactivity.e) iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
            }
            FriendProfilePicBrowserActivity friendProfilePicBrowserActivity = FriendProfilePicBrowserActivity.this;
            com.tencent.mobileqq.picbrowser.c cVar = new com.tencent.mobileqq.picbrowser.c(friendProfilePicBrowserActivity, ((PicBrowserActivity) friendProfilePicBrowserActivity).f258892c0);
            cVar.a(((PicBrowserActivity) FriendProfilePicBrowserActivity.this).f258890a0);
            return cVar;
        }

        @Override // com.tencent.common.galleryactivity.GalleryManager
        public com.tencent.common.galleryactivity.f i(Activity activity, com.tencent.common.galleryactivity.e eVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (com.tencent.common.galleryactivity.f) iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) eVar);
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class f implements IDynamicParams {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<FriendProfilePicBrowserActivity> f176089a;

        public f(FriendProfilePicBrowserActivity friendProfilePicBrowserActivity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) friendProfilePicBrowserActivity);
            } else {
                this.f176089a = new WeakReference<>(friendProfilePicBrowserActivity);
            }
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Map) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            HashMap hashMap = new HashMap();
            FriendProfilePicBrowserActivity friendProfilePicBrowserActivity = this.f176089a.get();
            if (friendProfilePicBrowserActivity == null) {
                return hashMap;
            }
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.IS_SYNC_XSJ, Integer.valueOf(friendProfilePicBrowserActivity.Y2()));
            return hashMap;
        }
    }

    public FriendProfilePicBrowserActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f176069j0 = new Handler();
        this.f176072m0 = false;
        this.f176073n0 = 0;
        this.f176075p0 = null;
        this.f176076q0 = "";
        this.f176079t0 = "QCIRCLE_" + UUID.randomUUID();
        this.f176080u0 = 0;
    }

    private boolean Q2() {
        int size;
        Bundle extras = getIntent().getExtras();
        int i3 = 0;
        int i16 = extras.getInt(IProfileCardConst.KEY_FROM_TYPE, 0);
        int i17 = extras.getInt("index", 0);
        ArrayList parcelableArrayList = extras.getParcelableArrayList("picInfos");
        ArrayList<String> stringArrayList = extras.getStringArrayList("fileIdList");
        boolean z16 = true;
        if (i16 != 1 ? i16 != 2 || parcelableArrayList == null || parcelableArrayList.size() <= 0 || stringArrayList == null || stringArrayList.size() <= 0 || parcelableArrayList.size() != stringArrayList.size() : parcelableArrayList == null || parcelableArrayList.size() != 1) {
            z16 = false;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("checkData: ");
        sb5.append(z16);
        sb5.append(",");
        sb5.append(i16);
        sb5.append(",");
        sb5.append(i17);
        sb5.append(",");
        if (parcelableArrayList == null) {
            size = 0;
        } else {
            size = parcelableArrayList.size();
        }
        sb5.append(size);
        sb5.append(",");
        if (stringArrayList != null) {
            i3 = stringArrayList.size();
        }
        sb5.append(i3);
        QLog.d("FriendProfilePicBrowserActivity", 2, sb5.toString());
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R2() {
        if (QLog.isColorLevel()) {
            QLog.d("FriendProfilePicBrowserActivity", 2, "deletePic");
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this, 0);
        createCustomDialog.setMessage(getString(R.string.ajn)).setCancelable(true);
        createCustomDialog.setNegativeButton(R.string.cancel, new c(createCustomDialog));
        createCustomDialog.setPositiveButton(R.string.f170648xe, new d(createCustomDialog));
        if (!isFinishing()) {
            createCustomDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S2() {
        File U2 = U2();
        if (U2 == null) {
            return;
        }
        ProfileCardUtil.k(U2.getAbsolutePath(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T2() {
        File U2 = U2();
        if (U2 == null) {
            return;
        }
        ProfileCardUtil.m(U2.getAbsolutePath(), this.app, this);
    }

    private File U2() {
        PicInfo S = this.f176070k0.S();
        if (QLog.isColorLevel()) {
            QLog.d("FriendProfilePicBrowserActivity", 2, "getCurPicPathUrl, curPicInfo=" + S);
        }
        if (S == null) {
            return null;
        }
        if (!TextUtils.isEmpty(S.f258919h)) {
            return new File(S.f258919h);
        }
        return AbsDownloader.getFile(S.f258917e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String V2() {
        int i3;
        com.tencent.mobileqq.profile.c cVar = this.f176070k0;
        if (cVar != null) {
            i3 = cVar.R();
        } else {
            i3 = -1;
        }
        ArrayList<String> arrayList = this.f176074o0;
        String str = "";
        if (arrayList == null) {
            return "";
        }
        if (i3 >= 0 && i3 < arrayList.size()) {
            str = this.f176074o0.get(i3);
        }
        if (QLog.isColorLevel()) {
            QLog.d("FriendProfilePicBrowserActivity", 2, "getCurrFileId, index=" + i3 + ",fileId=" + str);
        }
        return str;
    }

    private int W2() {
        if (!(this.f258895f0.k() instanceof com.tencent.mobileqq.profile.c)) {
            QLog.e("FriendProfilePicBrowserActivity", 1, "CurrentScene error.");
            return 0;
        }
        ArrayList<PicInfo> arrayList = this.f258892c0;
        if (arrayList != null && !arrayList.isEmpty()) {
            return ((com.tencent.mobileqq.profile.c) this.f258895f0.k()).R();
        }
        QLog.e("FriendProfilePicBrowserActivity", 1, "PicInfo empty.");
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Y2() {
        CheckBox checkBox = this.f176077r0;
        if (checkBox == null) {
            return 0;
        }
        return checkBox.isChecked() ? 1 : 0;
    }

    private String Z2() {
        int W2 = W2();
        if (this.f176080u0 != W2) {
            this.f176079t0 = "QCIRCLE_" + UUID.randomUUID();
            this.f176080u0 = W2;
        }
        return this.f176079t0;
    }

    private String b3() {
        if (U2() == null) {
            return "";
        }
        return U2().getAbsolutePath();
    }

    private void d3() {
        ViewStub viewStub;
        if (!e3() || this.f176071l0 == 1 || (viewStub = (ViewStub) findViewById(R.id.f9141554)) == null) {
            return;
        }
        View inflate = viewStub.inflate();
        this.f176078s0 = inflate;
        QUIButton qUIButton = (QUIButton) inflate.findViewById(R.id.uc8);
        TextView textView = (TextView) this.f176078s0.findViewById(R.id.f164932uc0);
        TextView textView2 = (TextView) this.f176078s0.findViewById(R.id.f164934uc2);
        CheckBox checkBox = (CheckBox) this.f176078s0.findViewById(R.id.ubz);
        this.f176077r0 = checkBox;
        checkBox.setOnClickListener(this);
        qUIButton.setOnClickListener(this);
        textView.setOnClickListener(this);
        textView2.setOnClickListener(this);
        textView.setText(com.dataline.util.j.d(getResources().getString(R.string.f199554pq)));
        this.f176077r0.setChecked(CommonMMKVUtils.getBoolean("sp_key_history_avatar_sync_qcircle", false, true));
        this.f176077r0.setOnCheckedChangeListener(new a());
        Button button = this.f176066g0;
        if (button != null) {
            button.setVisibility(8);
        }
        Button button2 = this.f176067h0;
        if (button2 != null) {
            button2.setVisibility(8);
        }
        VideoReport.setElementId(textView2, WinkDaTongReportConstant.ElementId.EM_BAS_PREVIEW);
        ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
        VideoReport.setElementClickPolicy(textView2, clickPolicy);
        VideoReport.setElementId(qUIButton, "em_avatar_set_button");
        VideoReport.setEventDynamicParams(qUIButton, new f(this));
        VideoReport.setElementClickPolicy(qUIButton, clickPolicy);
    }

    private boolean e3() {
        if (this.f176072m0 && sa0.b.e()) {
            return true;
        }
        return false;
    }

    private void f3(boolean z16) {
        String str = this.f176076q0;
        String b36 = b3();
        String Z2 = Z2();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(b36)) {
            ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).jumpToWinkEditorAfterProcessContent(getBaseContext(), "QCIRCLE", Z2, str, b36, null, "qq_avatar_history", QQWinkConstants.WinkLowLevelTemplateShareConstant.QQ_AVATAR_HISTORY, z16);
        } else {
            QLog.d("FriendProfilePicBrowserActivity", 1, "[jumpToWinkEditorAfterProcessContent] avatar path is null.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void forwardFavorite() {
        File U2 = U2();
        if (U2 == null) {
            return;
        }
        ProfileCardUtil.l(U2.getAbsolutePath(), this.app, this);
    }

    private void g3() {
        Bundle extras = getIntent().getExtras();
        this.f176071l0 = extras.getInt(IProfileCardConst.KEY_FROM_TYPE, 0);
        this.f176072m0 = extras.getBoolean("AVATAR_TO_CIRCLE_PUBLISH_HISTORY", false);
        this.f176073n0 = extras.getInt("AVATAR_TO_EXPERIENCE_FROM_TYPE", 0);
        int i3 = extras.getInt("index", 0);
        this.f258890a0 = i3;
        if (i3 < 0) {
            this.f258890a0 = 0;
        }
        this.f258892c0 = null;
        ArrayList<PicInfo> parcelableArrayList = extras.getParcelableArrayList("picInfos");
        this.f258892c0 = parcelableArrayList;
        this.f258893d0 = parcelableArrayList.get(this.f258890a0).f258917e;
        int i16 = this.f176071l0;
        if (i16 == 1) {
            DynamicAvatar q16 = ((DynamicAvatarManager) this.app.getManager(QQManagerFactory.DYNAMIC_AVATAR_MANAGER)).q(this.app.getCurrentAccountUin());
            PicInfo picInfo = new PicInfo();
            if (q16 != null) {
                if (!TextUtils.isEmpty(q16.basicBigUrl)) {
                    picInfo.f258920i = q16.basicBigUrl;
                } else if (!TextUtils.isEmpty(q16.basicSmallUrl)) {
                    picInfo.f258920i = q16.basicSmallUrl;
                }
            }
            if (!TextUtils.isEmpty(picInfo.f258920i)) {
                ArrayList<PicInfo> arrayList = new ArrayList<>();
                this.f258892c0 = arrayList;
                arrayList.add(picInfo);
                return;
            }
            return;
        }
        if (i16 == 2) {
            this.f176074o0 = extras.getStringArrayList("fileIdList");
        }
    }

    private void h3() {
        if (!e3() || FastClickUtils.isFastDoubleClick("FriendProfilePicBrowserActivity previewQCircleVideo", 500L)) {
            return;
        }
        f3(false);
    }

    private void i3() {
        Intent intent = getIntent();
        intent.putExtra("setHead_fileid", V2());
        setResult(-1, intent);
        finish();
        if (!e3() || !this.f176077r0.isChecked() || FastClickUtils.isFastDoubleClick("FriendProfilePicBrowserActivity publishQCircleVideo", 500L)) {
            return;
        }
        f3(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j3() {
        File U2 = U2();
        if (U2 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("FriendProfilePicBrowserActivity", 2, "savePic, file is null");
                return;
            }
            return;
        }
        com.tencent.mobileqq.activity.aio.photo.c.n(this, U2, Utils.Crc64String(U2.getAbsolutePath()));
    }

    private void startChatAndSendMsg(Bundle bundle) {
        Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(this), null);
        m3.putExtras(new Bundle(bundle));
        startActivity(m3);
        finish();
    }

    @Override // com.tencent.mobileqq.picbrowser.PicBrowserImage.b
    public void D0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
    }

    @Override // com.tencent.mobileqq.picbrowser.PicBrowserImage.b
    public void I0(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        com.tencent.mobileqq.profile.c cVar = this.f176070k0;
        if (cVar != null && cVar.R() == i3) {
            this.f176066g0.setEnabled(false);
            this.f176067h0.setEnabled(false);
        }
    }

    public void c3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        Button button = this.f176066g0;
        if (button != null) {
            button.setVisibility(8);
        }
        Button button2 = this.f176067h0;
        if (button2 != null) {
            button2.setVisibility(8);
        }
        ImageView imageView = this.f176068i0;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        View view = this.f176078s0;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.picbrowser.PicBrowserActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.doOnActivityResult(i3, i16, intent);
        if (i16 == -1 && i3 == 21 && intent != null && intent.getExtras() != null && !intent.getExtras().isEmpty() && intent.getExtras().getInt("uintype", 0) != 10027) {
            startChatAndSendMsg(intent.getExtras());
        }
    }

    @Override // com.tencent.mobileqq.picbrowser.PicBrowserActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            c3();
            super.doOnBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.picbrowser.PicBrowserActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        boolean z16;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) bundle)).booleanValue();
        }
        if (!Q2()) {
            finish();
            return false;
        }
        getWindow().setFlags(1024, 1024);
        this.f258895f0 = new e();
        super.doOnCreate(bundle);
        View findViewById = findViewById(R.id.root);
        if (findViewById != null) {
            VideoReport.addToDetectionWhitelist(this);
            VideoReport.setPageId(findViewById, "pg_profile_avatar_view");
        }
        Button button = (Button) findViewById(R.id.ipt);
        this.f176066g0 = button;
        button.setOnClickListener(this);
        this.f176066g0.setEnabled(false);
        VideoReport.setElementId(this.f176066g0, "em_avatar_set_button");
        VideoReport.setElementClickPolicy(this.f176066g0, ClickPolicy.REPORT_ALL);
        Button button2 = (Button) findViewById(R.id.f83684k8);
        this.f176067h0 = button2;
        button2.setOnClickListener(this);
        this.f176067h0.setEnabled(false);
        ImageView imageView = (ImageView) findViewById(R.id.cqp);
        this.f176068i0 = imageView;
        imageView.setContentDescription(HardCodeUtil.qqStr(R.string.mtl));
        this.f176068i0.setOnClickListener(this);
        this.mNeedStatusTrans = true;
        this.mActNeedImmersive = false;
        this.f176070k0.O(false);
        int i3 = this.f176071l0;
        if (i3 == 1) {
            this.f176066g0.setVisibility(4);
            this.f176067h0.setVisibility(4);
            ArrayList<PicInfo> arrayList = this.f258892c0;
            if (arrayList != null && arrayList.size() > 0 && !TextUtils.isEmpty(this.f258892c0.get(0).f258920i)) {
                this.f176068i0.setVisibility(4);
                this.f176070k0.O(true);
                z16 = true;
            } else {
                z16 = false;
            }
            QQAppInterface qQAppInterface = this.app;
            if (z16) {
                str = "1";
            } else {
                str = "0";
            }
            ReportController.o(qQAppInterface, "dc00898", "", "", "0X8007103", "0X8007103", 0, 0, str, "", "", "");
        } else if (i3 == 2) {
            if (((IProfileEditApi) QRoute.api(IProfileEditApi.class)).shouldOpenNewProfileEdit()) {
                this.f176066g0.setVisibility(8);
                this.f176067h0.setVisibility(0);
            }
            ReportController.o(this.app, "dc00898", "", "", "0X8007C11", "0X8007C11", 0, 0, "", "", "", "");
        }
        if ((sa0.b.c() && this.f176072m0) || e3()) {
            String avatarCacheOldPath = FaceUtil.getAvatarCacheOldPath(this.app.getCurrentUin());
            if (!TextUtils.isEmpty(avatarCacheOldPath)) {
                FileUtils.deleteFile(avatarCacheOldPath);
            }
            this.f176075p0 = (IQQAvatarDataService) this.app.getRuntimeService(IQQAvatarDataService.class, "");
            FileUtils.copyFile(FaceUtil.getAvatarCacheNewPath(this.app.getCurrentUin()), FaceUtil.getAvatarCacheOldPath(this.app.getCurrentUin()));
            String str2 = this.f176075p0.getHistoryAvatarPath() + "";
            this.f176076q0 = str2;
            if (TextUtils.isEmpty(str2) || !FileUtils.fileExists(this.f176076q0)) {
                FileUtils.copyFile(this.f176075p0.getCustomFaceFilePath(false, this.app.getCurrentUin()), FaceUtil.getAvatarCacheOldPath(this.app.getCurrentUin()));
                this.f176076q0 = FaceUtil.getAvatarCacheOldPath(this.app.getCurrentUin());
            }
        }
        d3();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.picbrowser.PicBrowserActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        super.doOnDestroy();
        com.tencent.mobileqq.profile.c cVar = this.f176070k0;
        if (cVar != null) {
            cVar.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) intent);
        } else {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.picbrowser.PicBrowserActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            AbstractGifImage.pauseAll();
            super.doOnPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.picbrowser.PicBrowserActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            AbstractGifImage.resumeAll();
            super.doOnResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.picbrowser.PicBrowserActivity
    public void initData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.initData();
            g3();
        }
    }

    @Override // com.tencent.mobileqq.picbrowser.PicBrowserImage.b
    public void k2(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        com.tencent.mobileqq.profile.c cVar = this.f176070k0;
        if (cVar != null && cVar.R() == i3) {
            this.f176066g0.setEnabled(true);
            this.f176067h0.setEnabled(true);
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) dialogInterface);
        } else {
            finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            boolean z16 = true;
            if (id5 != R.id.ipt && id5 != R.id.f83684k8) {
                if (id5 == R.id.cqp) {
                    showActionSheet();
                } else if (id5 == R.id.f164932uc0) {
                    CheckBox checkBox = this.f176077r0;
                    if (checkBox != null) {
                        checkBox.setChecked(!checkBox.isChecked());
                    }
                } else if (id5 == R.id.f164934uc2) {
                    h3();
                } else if (id5 == R.id.uc8) {
                    i3();
                }
            } else {
                VideoReport.reportEvent("dt_clck", view, null);
                Intent intent = getIntent();
                intent.putExtra("setHead_fileid", V2());
                if (!sa0.b.c() || !this.f176072m0) {
                    z16 = false;
                }
                if (view.getId() == R.id.f83684k8) {
                    intent.putExtra("needFinish", !z16);
                }
                setResult(-1, intent);
                intent.putExtra("gotoAvatarShare", z16);
                if (z16) {
                    Bundle bundle = new Bundle();
                    bundle.putString(QQWinkConstants.ENTRY_BUSINESS_NAME, "QCIRCLE");
                    bundle.putString("app_key", "00000QG6YX3X0LZH");
                    bundle.putString(QQWinkConstants.AVATAR_ORIGIN_HD_PATH, this.f176076q0);
                    bundle.putString(QQWinkConstants.AVATAR_NEW_HD_PATH, this.f258893d0);
                    bundle.putString(QQWinkConstants.WinkLowLevelTemplateShareConstant.WINK_TEMPLATE_FROM_TYPE, "history_avatar");
                    bundle.putString(QQWinkConstants.WINK_PUBLISH_TASK_ID, "qq_avatar_history");
                    bundle.putInt("AVATAR_TO_EXPERIENCE_FROM_TYPE", this.f176073n0);
                    bundle.putSerializable(QQWinkConstants.SPECIFIC_WINK_HOME_CLASS_TYPE, IQQWinkLaucher.WinkHomePageType.TYPE_COLLECTION_PICKER);
                    intent.putExtra("gotoAvatarShareBundle", bundle);
                }
                finish();
                ReportController.o(this.app, "dc00898", "", "", "0X8007C12", "0X8007C12", 0, 0, "", "", "", "");
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.picbrowser.PicBrowserActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.picbrowser.PicBrowserImage.b
    public void q(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    public void showActionSheet() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        boolean N = this.f176070k0.N();
        if (QLog.isColorLevel()) {
            QLog.d("FriendProfilePicBrowserActivity", 2, "showActionSheet, ,forbid=" + N);
        }
        if (N) {
            return;
        }
        ActionSheet createFullScreenDialog = ActionSheet.createFullScreenDialog(this, false);
        createFullScreenDialog.addButton(R.string.bsj);
        createFullScreenDialog.addButton(R.string.bg5);
        createFullScreenDialog.addButton(HardCodeUtil.qqStr(R.string.mtg));
        createFullScreenDialog.addButton(R.string.f170982bg2);
        if (this.f176071l0 == 2) {
            createFullScreenDialog.addButton(HardCodeUtil.qqStr(R.string.msc), 3);
        }
        createFullScreenDialog.addCancelButton(HardCodeUtil.qqStr(R.string.j6l));
        createFullScreenDialog.setOnButtonClickListener(new b(createFullScreenDialog));
        createFullScreenDialog.show();
        ReportController.o(this.app, "dc00898", "", "", "0X8007C13", "0X8007C13", 0, 0, "", "", "", "");
        ReportController.o(this.app, "dc00898", "", "", "0X800A8C9", "0X800A8C9", 0, 0, "1", "", "", "");
    }
}
