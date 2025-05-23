package com.tencent.mobileqq.qqexpand.fragment;

import QC.SuixintieCheckItem;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.etrump.mixlayout.ETTextView;
import com.tencent.av.utils.ba;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.profile.stickynote.vas.StickyNoteShopLayout;
import com.tencent.mobileqq.profile.view.SoftInputDetectView;
import com.tencent.mobileqq.qqexpand.bean.profile.ExtendFriendInfo;
import com.tencent.mobileqq.qqexpand.entrance.IExpandFragmentRouter;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.VasResEngine.VasRes;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.network.NetworkState;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.XEditTextEx;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.List;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ExpandOldEditFragment extends QPublicBaseFragment implements StickyNoteShopLayout.b, SoftInputDetectView.a, View.OnClickListener, View.OnTouchListener {
    public boolean D;
    public AudioInfo E;
    BounceScrollView F;
    TextView G;
    LinearLayout H;
    SoftInputDetectView I;
    ExtendFriendOldProfileEditFragment J;
    ExtendFriendInfo K;
    private FrameLayout L;
    private StickyNoteShopLayout M;
    private StickyNoteShopLayout N;
    private ImageView P;
    private ImageView Q;
    private VasRes V;
    private String W;
    private QBaseActivity Y;
    private QQAppInterface Z;

    /* renamed from: a0, reason: collision with root package name */
    private FragmentManager f263595a0;

    /* renamed from: b0, reason: collision with root package name */
    private QQProgressDialog f263596b0;

    /* renamed from: d0, reason: collision with root package name */
    private GestureDetector f263598d0;
    public int C = 0;
    private boolean R = true;
    private int S = 0;
    private final SuixintieCheckItem T = new SuixintieCheckItem();
    private final SuixintieCheckItem U = new SuixintieCheckItem();
    private boolean X = false;

    /* renamed from: c0, reason: collision with root package name */
    ExpandObserver f263597c0 = new c();

    /* renamed from: e0, reason: collision with root package name */
    private final GestureDetector.OnGestureListener f263599e0 = new d();

    /* renamed from: f0, reason: collision with root package name */
    private final TransProcessorHandler f263600f0 = new e();

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ExtendFriendInfo f263602d;

        b(ExtendFriendInfo extendFriendInfo) {
            this.f263602d = extendFriendInfo;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            ExpandOldEditFragment.this.Fh(this.f263602d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class e extends TransProcessorHandler {
        e() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            FileMsg fileMsg = (FileMsg) message.obj;
            int i3 = message.what;
            if (i3 != 1003) {
                if (i3 != 1005) {
                    return;
                }
                if (fileMsg.fileType == 23 && QLog.isColorLevel()) {
                    QLog.i("ExtendFriendProfileEdit", 2, "mFileUploadHandler.handleMessage(), upload fail.");
                }
                ExpandOldEditFragment.this.f263596b0.dismiss();
                QQToast.makeText(ExpandOldEditFragment.this.Y, HardCodeUtil.qqStr(R.string.mbw), 0).show();
                ExtendFriendReport.a().o(false, 0);
                return;
            }
            if (fileMsg.fileType == 23) {
                ExpandOldEditFragment.this.W = ((NearbyPeoplePhotoUploadProcessor) fileMsg.processor).mUrl;
                if (QLog.isColorLevel()) {
                    QLog.i("ExtendFriendProfileEdit", 2, "mFileUploadHandler.handleMessage(), upload success. url = " + ExpandOldEditFragment.this.W);
                }
                ExpandOldEditFragment expandOldEditFragment = ExpandOldEditFragment.this;
                ExtendFriendOldProfileEditFragment extendFriendOldProfileEditFragment = expandOldEditFragment.J;
                if (extendFriendOldProfileEditFragment != null) {
                    extendFriendOldProfileEditFragment.di(expandOldEditFragment.W);
                    ExpandOldEditFragment expandOldEditFragment2 = ExpandOldEditFragment.this;
                    expandOldEditFragment2.Ah(expandOldEditFragment2.J.Sh());
                }
            }
            ExtendFriendReport.a().o(true, 0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class f implements DialogInterface.OnClickListener {
        f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            ExpandOldEditFragment.this.Y.finish();
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class g implements DialogInterface.OnClickListener {
        g() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class h implements DialogInterface.OnClickListener {
        h() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            ExpandOldEditFragment.this.Y.finish();
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class i implements DialogInterface.OnClickListener {
        i() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class j implements DialogInterface.OnClickListener {
        j() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class k implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ExtendFriendInfo f263612d;

        k(ExtendFriendInfo extendFriendInfo) {
            this.f263612d = extendFriendInfo;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            ExpandOldEditFragment.this.Fh(this.f263612d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fh(ExtendFriendInfo extendFriendInfo) {
        ExtendFriendOldProfileEditFragment extendFriendOldProfileEditFragment = this.J;
        if (extendFriendOldProfileEditFragment != null) {
            extendFriendOldProfileEditFragment.ji();
        }
        this.f263596b0.show();
        AudioInfo audioInfo = this.E;
        if (audioInfo != null && !TextUtils.isEmpty(audioInfo.path)) {
            Ph(this.E.path);
        } else {
            Ah(extendFriendInfo);
        }
    }

    private void Kh() {
        if (this.F.getChildCount() > 0) {
            this.F.removeAllViews();
            QLog.e("ExtendFriendProfileEdit", 1, "showEditFragment mContainer childCount > 0");
        }
        ExtendFriendOldProfileEditFragment extendFriendOldProfileEditFragment = new ExtendFriendOldProfileEditFragment();
        this.J = extendFriendOldProfileEditFragment;
        extendFriendOldProfileEditFragment.fi(this);
        this.f263595a0.beginTransaction().add(R.id.b9w, this.J).commit();
        ExtendFriendInfo extendFriendInfo = (ExtendFriendInfo) this.Y.getIntent().getParcelableExtra(IExpandFragmentRouter.KEY_EXTEND_FRIEND_INFO);
        this.K = extendFriendInfo;
        if (extendFriendInfo == null) {
            ((com.tencent.mobileqq.qqexpand.network.e) this.Z.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).l1(this.Z.getCurrentAccountUin(), false);
            this.f263596b0.show();
            return;
        }
        ((com.tencent.mobileqq.qqexpand.network.e) this.Z.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).l1(this.Z.getCurrentAccountUin(), true);
        if (this.K.a()) {
            this.J.li(this.K);
        }
        if (!NetworkState.isNetworkConnected(this.Z.getApp())) {
            QQToast.makeText(this.Z.getApp(), 1, R.string.f171137ci2, 0).show();
        }
        this.X = TextUtils.isEmpty(this.K.f263491d) && TextUtils.isEmpty(this.K.f263494h);
    }

    private void Ph(String str) {
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mIsUp = true;
        transferRequest.mLocalPath = str;
        transferRequest.mUniseq = System.currentTimeMillis();
        transferRequest.mFileType = 23;
        ((ITransFileController) this.Z.getRuntimeService(ITransFileController.class)).transferAsync(transferRequest);
    }

    public boolean Bh() {
        String obj;
        String str;
        ExtendFriendOldProfileEditFragment extendFriendOldProfileEditFragment = this.J;
        if (extendFriendOldProfileEditFragment == null) {
            return false;
        }
        if (extendFriendOldProfileEditFragment.M) {
            return true;
        }
        XEditTextEx xEditTextEx = extendFriendOldProfileEditFragment.C;
        if (xEditTextEx == null) {
            return false;
        }
        String str2 = "";
        if (xEditTextEx.getText() == null) {
            obj = "";
        } else {
            obj = this.J.C.getText().toString();
        }
        ExtendFriendInfo extendFriendInfo = this.J.H;
        if (extendFriendInfo != null && (str = extendFriendInfo.f263491d) != null) {
            str2 = str;
        }
        return !obj.equals(str2);
    }

    public void Ch() {
        if (!Bh() && !Gh()) {
            Oh();
            return;
        }
        if (!Bh()) {
            ExtendFriendInfo extendFriendInfo = this.J.H;
            if (extendFriendInfo.f263496m == this.U.itemId && extendFriendInfo.C == this.T.itemId) {
                Oh();
                return;
            }
        }
        if (isAdded() || this.D) {
            this.G.setTextColor(-16777216);
            this.G.setOnClickListener(this);
            this.G.setClickable(true);
        }
    }

    public StickyNoteShopLayout Dh() {
        return this.M;
    }

    public StickyNoteShopLayout Eh() {
        return this.N;
    }

    public boolean Gh() {
        XEditTextEx xEditTextEx;
        ExtendFriendOldProfileEditFragment extendFriendOldProfileEditFragment = this.J;
        return (extendFriendOldProfileEditFragment == null || (xEditTextEx = extendFriendOldProfileEditFragment.C) == null || xEditTextEx.getText() == null || TextUtils.isEmpty(this.J.C.getText().toString())) ? false : true;
    }

    public void Hh(View view) {
        StickyNoteShopLayout stickyNoteShopLayout = this.M;
        if (stickyNoteShopLayout != view) {
            stickyNoteShopLayout.j();
        }
        StickyNoteShopLayout stickyNoteShopLayout2 = this.N;
        if (stickyNoteShopLayout2 != view) {
            stickyNoteShopLayout2.j();
        }
    }

    public void Jh() {
        this.Q.setImageResource(R.drawable.dhf);
        this.P.setImageResource(R.drawable.dhd);
    }

    public void Lh(boolean z16) {
        FrameLayout frameLayout = this.L;
        if (frameLayout != null) {
            frameLayout.setVisibility((!z16 || SimpleUIUtil.getSimpleUISwitch()) ? 8 : 0);
            if (this.L.getVisibility() == 0) {
                VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "icon_show", "", 0, "", "1");
                VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "icon_show", "", 0, "", "2");
            }
        }
    }

    public void Mh() {
        String obj;
        if (this.J.C.getText() == null) {
            obj = "";
        } else {
            obj = this.J.C.getText().toString();
        }
        this.J.D.setTextMsg(new QQText(QzoneEmotionUtils.emCodesToQQcodes(obj), 3, 24));
        this.J.C.setVisibility(8);
        this.J.D.setVisibility(0);
    }

    public void Nh(StickyNoteShopLayout stickyNoteShopLayout) {
        if (SimpleUIUtil.getSimpleUISwitch()) {
            return;
        }
        Hh(stickyNoteShopLayout);
        yh(stickyNoteShopLayout.g(this.S));
        this.H.setVisibility(0);
        stickyNoteShopLayout.o(0);
    }

    public void Oh() {
        this.G.setTextColor(-3355444);
        this.G.setOnClickListener(null);
        this.G.setClickable(false);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        StickyNoteShopLayout stickyNoteShopLayout = this.M;
        if (stickyNoteShopLayout != null) {
            stickyNoteShopLayout.n(i3, i16, intent);
        }
        StickyNoteShopLayout stickyNoteShopLayout2 = this.N;
        if (stickyNoteShopLayout2 != null) {
            stickyNoteShopLayout2.n(i3, i16, intent);
        }
        List<Fragment> fragments = this.f263595a0.getFragments();
        for (int i17 = 0; i17 < fragments.size(); i17++) {
            fragments.get(i17).onActivityResult(i3, i16, intent);
        }
        if (i16 != 0 && i3 == 1003) {
            AudioInfo audioInfo = (AudioInfo) intent.getSerializableExtra("audio_info");
            this.E = audioInfo;
            this.J.ci(audioInfo);
            if (QLog.isColorLevel()) {
                QLog.i("ExtendFriendProfileEdit", 2, "onActivityResult audio_back path: " + this.E.path);
            }
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        if (this.Y != null) {
            ExtendFriendOldProfileEditFragment extendFriendOldProfileEditFragment = this.J;
            if (extendFriendOldProfileEditFragment != null && extendFriendOldProfileEditFragment.Vh()) {
                QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this.Y, 0, (String) null, HardCodeUtil.qqStr(R.string.max), HardCodeUtil.qqStr(R.string.mbh), HardCodeUtil.qqStr(R.string.mbc), new f(), new g());
                this.J.ji();
                createCustomDialog.show();
                return true;
            }
            return super.onBackEvent();
        }
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AudioInfo audioInfo;
        switch (view.getId()) {
            case R.id.ivTitleBtnLeft /* 2131373843 */:
                if (this.Y != null) {
                    ReportController.o(this.Z, "dc00898", "", "", "0X80092E0", "0X80092E0", 0, 0, "", "", "", "");
                    ExtendFriendOldProfileEditFragment extendFriendOldProfileEditFragment = this.J;
                    if (extendFriendOldProfileEditFragment != null && extendFriendOldProfileEditFragment.Vh()) {
                        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this.Y, 0, (String) null, HardCodeUtil.qqStr(R.string.mbl), HardCodeUtil.qqStr(R.string.f171959mb2), HardCodeUtil.qqStr(R.string.mbz), new h(), new i());
                        this.J.ji();
                        createCustomDialog.show();
                        return;
                    }
                    this.Y.doOnBackPressed();
                    return;
                }
                return;
            case R.id.ivTitleBtnRightText /* 2131373882 */:
                ExtendFriendOldProfileEditFragment extendFriendOldProfileEditFragment2 = this.J;
                if (extendFriendOldProfileEditFragment2 == null) {
                    return;
                }
                ExtendFriendInfo Sh = extendFriendOldProfileEditFragment2.Sh();
                if (this.X && TextUtils.isEmpty(Sh.f263491d) && (audioInfo = this.E) != null && !TextUtils.isEmpty(audioInfo.path)) {
                    QQToast.makeText(this.Y, 0, "\u6269\u5217\u5ba3\u8a00\u8fd8\u6ca1\u6709\u586b\u5199\u54e6", 0).show();
                    return;
                }
                if (TextUtils.isEmpty(Sh.f263491d) && !TextUtils.isEmpty(this.J.L)) {
                    QQCustomDialog createCustomDialog2 = DialogUtil.createCustomDialog(this.Y, 0, (String) null, HardCodeUtil.qqStr(R.string.mb9), HardCodeUtil.qqStr(R.string.f171958mb0), HardCodeUtil.qqStr(R.string.j6l), new j(), new k(Sh));
                    this.J.ji();
                    createCustomDialog2.show();
                    return;
                } else {
                    if (this.J.D.getLineCount() > 30) {
                        QQToast.makeText(getQBaseActivity(), "\u8f93\u5165\u6587\u5b57\u4e0d\u8981\u8d85\u8fc730\u884c", 0).show();
                        return;
                    }
                    if (!TextUtils.isEmpty(Sh.f263491d) && !this.J.Yh(Sh.f263491d)) {
                        QQCustomDialog createCustomDialog3 = DialogUtil.createCustomDialog(this.Y, 0, (String) null, HardCodeUtil.qqStr(R.string.f170910zx3), HardCodeUtil.qqStr(R.string.f170909zx2), HardCodeUtil.qqStr(R.string.f170908zx1), new a(), new b(Sh));
                        this.J.ji();
                        createCustomDialog3.show();
                        return;
                    }
                    Fh(Sh);
                    return;
                }
            case R.id.g0l /* 2131374463 */:
                Jh();
                zh(2);
                VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "icon_click", "", 0, "", "1");
                ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#edit_data_page#skin", true, -1L, -1L, null, true, true);
                return;
            case R.id.g0m /* 2131374464 */:
                Jh();
                zh(3);
                VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "icon_click", "", 0, "", "2");
                ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#edit_data_page#font", true, -1L, -1L, null, true, true);
                return;
            default:
                return;
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        QBaseActivity qBaseActivity = getQBaseActivity();
        this.Y = qBaseActivity;
        this.Z = (QQAppInterface) qBaseActivity.getAppRuntime();
        this.f263595a0 = getChildFragmentManager();
        Window window = this.Y.getWindow();
        if (window != null) {
            window.setFormat(-3);
            window.setBackgroundDrawable(new ColorDrawable(-1));
            window.setSoftInputMode(16);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.Z.removeObserver(this.f263597c0);
        ((ITransFileController) this.Z.getRuntimeService(ITransFileController.class)).removeHandle(this.f263600f0);
        this.f263597c0 = null;
        VasRes vasRes = this.V;
        if (vasRes != null) {
            vasRes.recycle();
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        ExtendFriendOldProfileEditFragment extendFriendOldProfileEditFragment;
        if (view.getId() == R.id.byz && (extendFriendOldProfileEditFragment = this.J) != null && extendFriendOldProfileEditFragment.Nh()) {
            this.F.requestDisallowInterceptTouchEvent(true);
            if (motionEvent.getAction() == 1) {
                this.F.requestDisallowInterceptTouchEvent(false);
            }
            return false;
        }
        this.f263598d0.onTouchEvent(motionEvent);
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (ThemeUtil.isInNightMode(this.Z)) {
            if (view instanceof RelativeLayout) {
                View view2 = new View(getQBaseActivity());
                view2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                view2.setBackgroundColor(1056964608);
                ((RelativeLayout) view).addView(view2);
                return;
            }
            if (QLog.isDebugVersion()) {
                throw new RuntimeException("error root type");
            }
        }
    }

    @Override // com.tencent.mobileqq.profile.view.SoftInputDetectView.a
    public void s6(boolean z16, int i3) {
        ExtendFriendOldProfileEditFragment extendFriendOldProfileEditFragment = this.J;
        if (extendFriendOldProfileEditFragment == null || extendFriendOldProfileEditFragment.H == null || !extendFriendOldProfileEditFragment.isResumed()) {
            return;
        }
        if (z16) {
            this.R = true;
            this.S = i3;
            if (!SimpleUIUtil.getSimpleUISwitch()) {
                this.H.setVisibility(0);
            }
            Lh(false);
            yh(0);
            ExtendFriendInfo extendFriendInfo = this.J.H;
            if (extendFriendInfo.F) {
                extendFriendInfo.F = false;
                Jh();
                this.C = 3;
                zh(3);
                return;
            }
            if (extendFriendInfo.G) {
                extendFriendInfo.G = false;
                Jh();
                this.C = 2;
                zh(2);
                return;
            }
            return;
        }
        this.R = false;
        int i16 = this.C;
        if (i16 == 1) {
            Lh(true);
            return;
        }
        if (i16 == 0) {
            this.H.setVisibility(8);
            Lh(false);
        } else if (i16 == 2) {
            zh(2);
        } else if (i16 == 3) {
            zh(3);
        }
    }

    public void yh(int i3) {
        ((RelativeLayout.LayoutParams) this.H.getLayoutParams()).bottomMargin = i3;
    }

    public void zh(int i3) {
        this.C = i3;
        if (i3 == 0) {
            Lh(false);
            InputMethodUtil.show(this.J.C);
            Jh();
            return;
        }
        if (i3 == 2) {
            if (this.R) {
                InputMethodUtil.hide(this.J.C);
            } else {
                Lh(true);
                Nh(this.M);
                this.P.setImageResource(R.drawable.dhe);
                VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "item_show", "", 0, "", "1");
            }
            Mh();
            return;
        }
        if (i3 != 3) {
            return;
        }
        if (this.R) {
            InputMethodUtil.hide(this.J.C);
        } else {
            Lh(true);
            Nh(this.N);
            this.Q.setImageResource(R.drawable.dhg);
            VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "item_show", "", 0, "", "2");
        }
        Mh();
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class c extends ExpandObserver {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqexpand.network.ExpandObserver
        public void b(boolean z16) {
            super.b(z16);
            if (z16) {
                ExpandOldEditFragment.this.f263596b0.dismiss();
                if (ExpandOldEditFragment.this.Y != null) {
                    ExpandOldEditFragment.this.Y.setResult(8193);
                    ExpandOldEditFragment.this.Y.finish();
                    return;
                }
                return;
            }
            ExpandOldEditFragment.this.f263596b0.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqexpand.network.ExpandObserver
        public void d(boolean z16, Card card) {
            super.d(z16, card);
            boolean z17 = false;
            if (z16) {
                ExpandOldEditFragment.this.K = new ExtendFriendInfo(card);
                ExpandOldEditFragment expandOldEditFragment = ExpandOldEditFragment.this;
                if (TextUtils.isEmpty(expandOldEditFragment.K.f263491d) && TextUtils.isEmpty(ExpandOldEditFragment.this.K.f263494h)) {
                    z17 = true;
                }
                expandOldEditFragment.X = z17;
                ExpandOldEditFragment expandOldEditFragment2 = ExpandOldEditFragment.this;
                expandOldEditFragment2.J.li(expandOldEditFragment2.K);
            } else {
                QQToast.makeText(ExpandOldEditFragment.this.Y, "\u83b7\u53d6\u6269\u5217\u4fe1\u606f\u5931\u8d25", 0).show();
            }
            ExpandOldEditFragment.this.f263596b0.dismiss();
        }

        @Override // com.tencent.mobileqq.qqexpand.network.ExpandObserver
        protected void x(boolean z16, int i3) {
            if (QLog.isColorLevel()) {
                QLog.d("ExtendFriendProfileEdit", 2, String.format("ExtendFriendEditFragment onUpdateCampusCertificateStatus isSuccess=%s scene=%s", Boolean.valueOf(z16), Integer.valueOf(i3)));
            }
            if (z16 && i3 == 2) {
                if (ExpandOldEditFragment.this.J != null) {
                    ExpandOldEditFragment.this.K.J = ((com.tencent.mobileqq.qqexpand.manager.e) r5.Z.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).N();
                    ExpandOldEditFragment expandOldEditFragment = ExpandOldEditFragment.this;
                    expandOldEditFragment.J.ni(expandOldEditFragment.K);
                }
            }
        }

        @Override // com.tencent.mobileqq.qqexpand.network.ExpandObserver
        protected void z(boolean z16, Object obj) {
            ExtendFriendOldProfileEditFragment extendFriendOldProfileEditFragment;
            if (z16 && (obj instanceof Bundle)) {
                Bundle bundle = (Bundle) obj;
                String string = bundle.getString("name");
                String string2 = bundle.getString("schoolid");
                int i3 = bundle.getInt("category");
                int i16 = bundle.getInt("idx");
                ExpandOldEditFragment expandOldEditFragment = ExpandOldEditFragment.this;
                ExtendFriendInfo extendFriendInfo = expandOldEditFragment.K;
                if (extendFriendInfo == null || (extendFriendOldProfileEditFragment = expandOldEditFragment.J) == null) {
                    return;
                }
                extendFriendInfo.I = string;
                extendFriendInfo.H = string2;
                extendFriendInfo.L = i3;
                extendFriendInfo.J = -1L;
                extendFriendInfo.K = i16;
                extendFriendOldProfileEditFragment.ni(extendFriendInfo);
            }
        }
    }

    @Override // com.tencent.mobileqq.profile.stickynote.vas.StickyNoteShopLayout.b
    public void i6(int i3, int i16) {
        if (i3 != 0) {
            getQBaseActivity();
        }
    }

    private void Ih(View view) {
        TextView textView = (TextView) view.findViewById(R.id.ivTitleBtnLeft);
        textView.setOnClickListener(this);
        this.G = (TextView) view.findViewById(R.id.ivTitleBtnRightText);
        if (ThemeUtil.isInNightMode(this.Z)) {
            textView.setBackgroundDrawable(getResources().getDrawable(R.drawable.afp));
        }
        QQProgressDialog qQProgressDialog = new QQProgressDialog(getQBaseActivity(), getQBaseActivity().getTitleBarHeight());
        this.f263596b0 = qQProgressDialog;
        qQProgressDialog.setBackAndSearchFilter(true);
        this.F = (BounceScrollView) view.findViewById(R.id.b9w);
        this.f263598d0 = new GestureDetector(getQBaseActivity(), this.f263599e0);
        this.H = (LinearLayout) view.findViewById(R.id.ghe);
        SoftInputDetectView softInputDetectView = (SoftInputDetectView) view.findViewById(R.id.dmq);
        this.I = softInputDetectView;
        softInputDetectView.setExcludeStatusBar(false);
        this.I.setOnImStateChangedListener(this);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fcv);
        this.L = frameLayout;
        frameLayout.setVisibility(8);
        StickyNoteShopLayout stickyNoteShopLayout = (StickyNoteShopLayout) view.findViewById(R.id.aom);
        this.M = stickyNoteShopLayout;
        stickyNoteShopLayout.setShopCallback(this);
        this.M.setAppId(9);
        this.M.setUseId(2);
        StickyNoteShopLayout stickyNoteShopLayout2 = (StickyNoteShopLayout) view.findViewById(R.id.ffj);
        this.N = stickyNoteShopLayout2;
        stickyNoteShopLayout2.setShopCallback(this);
        this.N.setAppId(5);
        this.N.setUseId(2);
        ImageView imageView = (ImageView) view.findViewById(R.id.g0l);
        this.P = imageView;
        ba.a aVar = ba.f77070d;
        imageView.setOnTouchListener(aVar);
        this.P.setOnClickListener(this);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.g0m);
        this.Q = imageView2;
        imageView2.setOnTouchListener(aVar);
        this.Q.setOnClickListener(this);
        this.F.setOnTouchListener(this);
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class d implements GestureDetector.OnGestureListener {
        d() {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            ExtendFriendOldProfileEditFragment extendFriendOldProfileEditFragment;
            if (motionEvent != null && motionEvent2 != null) {
                if ((motionEvent2.getY() - motionEvent.getY() <= 50.0f ? motionEvent.getY() - motionEvent2.getY() > 50.0f : true) && (extendFriendOldProfileEditFragment = ExpandOldEditFragment.this.J) != null) {
                    extendFriendOldProfileEditFragment.hideSoftInput();
                    ExpandOldEditFragment.this.L.setVisibility(8);
                    ExpandOldEditFragment.this.H.setVisibility(8);
                }
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ah(ExtendFriendInfo extendFriendInfo) {
        com.tencent.mobileqq.qqexpand.network.e eVar = (com.tencent.mobileqq.qqexpand.network.e) this.Z.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
        ExtendFriendOldProfileEditFragment extendFriendOldProfileEditFragment = this.J;
        int i3 = extendFriendOldProfileEditFragment != null ? extendFriendOldProfileEditFragment.K : 20;
        int i16 = 1;
        if (!TextUtils.isEmpty(extendFriendInfo.f263491d) && extendFriendInfo.f263491d.length() < i3) {
            QQToast.makeText(getQBaseActivity(), String.format(HardCodeUtil.qqStr(R.string.mbk), Integer.valueOf(i3)), 0).show();
            this.f263596b0.dismiss();
            return;
        }
        if (TextUtils.isEmpty(extendFriendInfo.f263491d) && !TextUtils.isEmpty(extendFriendInfo.f263494h)) {
            i16 = 2;
        } else if (TextUtils.isEmpty(extendFriendInfo.f263491d) || !TextUtils.isEmpty(extendFriendInfo.f263494h)) {
            i16 = 3;
        }
        ReportController.o(this.Z, "dc00898", "", "", "0X80092DF", "0X80092DF", i16, 0, "", "", "", "");
        String currentAccountUin = this.Z.getCurrentAccountUin();
        String str = extendFriendInfo.f263491d;
        String str2 = extendFriendInfo.f263494h;
        int i17 = extendFriendInfo.f263495i;
        SuixintieCheckItem suixintieCheckItem = this.U;
        eVar.C0(currentAccountUin, str, str2, i17, suixintieCheckItem.itemId, suixintieCheckItem.fontType, this.T.itemId);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.gwy, (ViewGroup) null);
        this.Z.addObserver(this.f263597c0);
        Ih(inflate);
        Kh();
        this.f263600f0.addFilter(NearbyPeoplePhotoUploadProcessor.class);
        ((ITransFileController) this.Z.getRuntimeService(ITransFileController.class)).addHandle(this.f263600f0);
        return inflate;
    }

    @Override // com.tencent.mobileqq.profile.stickynote.vas.StickyNoteShopLayout.b
    public void oe(int i3, int i16) {
        if ((i3 == 0 && i16 == 0) || getQBaseActivity() == null) {
            return;
        }
        this.D = true;
        SuixintieCheckItem suixintieCheckItem = this.U;
        suixintieCheckItem.itemId = i3;
        suixintieCheckItem.fontType = i16;
        suixintieCheckItem.appid = 5;
        this.J.D.setVisibility(0);
        this.J.D.setText(new QQText(QzoneEmotionUtils.emCodesToQQcodes(this.J.C.getText().toString()), 3, 24));
        this.J.C.setVisibility(8);
        this.J.D.setFont(0, System.currentTimeMillis());
        this.J.D.f32609e0 = System.currentTimeMillis();
        VasRes vasRes = this.V;
        if (vasRes == null) {
            QQAppInterface qQAppInterface = this.Z;
            VasRes vasRes2 = new VasRes(qQAppInterface, i3);
            this.V = vasRes2;
            com.tencent.mobileqq.vas.adapter.a aVar = new com.tencent.mobileqq.vas.adapter.a(vasRes2, qQAppInterface, i16);
            ETTextView eTTextView = this.J.D;
            aVar.j(eTTextView, eTTextView.getTextSize(), true);
            this.V.setAdapter(aVar);
            aVar.i(-1);
        } else {
            com.tencent.mobileqq.vas.adapter.a aVar2 = (com.tencent.mobileqq.vas.adapter.a) vasRes.getVasResAdapter();
            ETTextView eTTextView2 = this.J.D;
            aVar2.j(eTTextView2, eTTextView2.getTextSize(), true);
            ((com.tencent.mobileqq.vas.adapter.a) this.V.getVasResAdapter()).k(i3, i16);
        }
        Ch();
    }
}
