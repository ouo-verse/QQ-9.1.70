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
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qqexpand.bean.profile.ExtendFriendInfo;
import com.tencent.mobileqq.qqexpand.entrance.IExpandFragmentRouter;
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
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.widget.QzoneEmotionUtils;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ExpandEditFragment extends QPublicBaseFragment implements View.OnClickListener, View.OnTouchListener {
    public AudioInfo D;
    BounceScrollView E;
    TextView F;
    LinearLayout G;
    ExpandProfileEditFragment H;
    ExtendFriendInfo I;
    private FrameLayout J;
    private String P;
    private QBaseActivity R;
    private QQAppInterface S;
    private FragmentManager T;
    private QQProgressDialog U;
    private GestureDetector V;
    public int C = 0;
    private boolean K = true;
    private int L = 0;
    private final SuixintieCheckItem M = new SuixintieCheckItem();
    private final SuixintieCheckItem N = new SuixintieCheckItem();
    private boolean Q = false;
    private final GestureDetector.OnGestureListener W = new a();
    private final TransProcessorHandler X = new b();

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class b extends TransProcessorHandler {
        b() {
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
                ExpandEditFragment.this.U.dismiss();
                QQToast.makeText(ExpandEditFragment.this.R, HardCodeUtil.qqStr(R.string.mbw), 0).show();
                ExtendFriendReport.a().o(false, 0);
                return;
            }
            if (fileMsg.fileType == 23) {
                ExpandEditFragment.this.P = ((NearbyPeoplePhotoUploadProcessor) fileMsg.processor).mUrl;
                if (QLog.isColorLevel()) {
                    QLog.i("ExtendFriendProfileEdit", 2, "mFileUploadHandler.handleMessage(), upload success. url = " + ExpandEditFragment.this.P);
                }
                ExpandEditFragment expandEditFragment = ExpandEditFragment.this;
                ExpandProfileEditFragment expandProfileEditFragment = expandEditFragment.H;
                if (expandProfileEditFragment != null) {
                    expandProfileEditFragment.Lh(expandEditFragment.P);
                    ExpandEditFragment expandEditFragment2 = ExpandEditFragment.this;
                    expandEditFragment2.wh(expandEditFragment2.H.Dh());
                }
            }
            ExtendFriendReport.a().o(true, 0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            ExpandEditFragment.this.R.finish();
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class e implements DialogInterface.OnClickListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            ExpandEditFragment.this.R.finish();
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

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ExtendFriendInfo f263590d;

        h(ExtendFriendInfo extendFriendInfo) {
            this.f263590d = extendFriendInfo;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            ExpandEditFragment.this.xh(this.f263590d);
        }
    }

    private void Bh(String str) {
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mIsUp = true;
        transferRequest.mLocalPath = str;
        transferRequest.mUniseq = System.currentTimeMillis();
        transferRequest.mFileType = 23;
        ((ITransFileController) this.S.getRuntimeService(ITransFileController.class)).transferAsync(transferRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wh(ExtendFriendInfo extendFriendInfo) {
        Intent intent = this.R.getIntent();
        intent.putExtra(IExpandFragmentRouter.KEY_EXTEND_FRIEND_INFO, extendFriendInfo);
        this.R.setResult(5003, intent);
        this.R.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xh(ExtendFriendInfo extendFriendInfo) {
        ExpandProfileEditFragment expandProfileEditFragment = this.H;
        if (expandProfileEditFragment != null) {
            expandProfileEditFragment.Qh();
        }
        AudioInfo audioInfo = this.D;
        if (audioInfo != null && !TextUtils.isEmpty(audioInfo.path)) {
            this.U.show();
            Bh(this.D.path);
        } else {
            wh(extendFriendInfo);
        }
    }

    private void zh() {
        ExpandProfileEditFragment expandProfileEditFragment = new ExpandProfileEditFragment();
        this.H = expandProfileEditFragment;
        expandProfileEditFragment.Nh(this);
        this.T.beginTransaction().add(R.id.b9w, this.H).commit();
        ExtendFriendInfo extendFriendInfo = (ExtendFriendInfo) this.R.getIntent().getParcelableExtra(IExpandFragmentRouter.KEY_EXTEND_FRIEND_INFO);
        this.I = extendFriendInfo;
        if (extendFriendInfo != null) {
            this.H.Rh(extendFriendInfo);
        }
    }

    public void Ah() {
        String obj;
        if (this.H.C.getText() == null) {
            obj = "";
        } else {
            obj = this.H.C.getText().toString();
        }
        this.H.D.setTextMsg(new QQText(QzoneEmotionUtils.emCodesToQQcodes(obj), 3, 24));
        this.H.C.setVisibility(8);
        this.H.D.setVisibility(0);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        if (this.R != null) {
            ExpandProfileEditFragment expandProfileEditFragment = this.H;
            if (expandProfileEditFragment != null && expandProfileEditFragment.Fh()) {
                QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this.R, 0, (String) null, HardCodeUtil.qqStr(R.string.max), HardCodeUtil.qqStr(R.string.mbh), HardCodeUtil.qqStr(R.string.mbc), new c(), new d());
                this.H.Qh();
                createCustomDialog.show();
                return true;
            }
            return super.onBackEvent();
        }
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ExpandProfileEditFragment expandProfileEditFragment;
        int id5 = view.getId();
        if (id5 == R.id.ivTitleBtnLeft) {
            if (this.R != null) {
                ReportController.o(this.S, "dc00898", "", "", "0X80092E0", "0X80092E0", 0, 0, "", "", "", "");
                ExpandProfileEditFragment expandProfileEditFragment2 = this.H;
                if (expandProfileEditFragment2 != null && expandProfileEditFragment2.Fh()) {
                    QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this.R, 0, (String) null, HardCodeUtil.qqStr(R.string.mbl), HardCodeUtil.qqStr(R.string.f171959mb2), HardCodeUtil.qqStr(R.string.mbz), new e(), new f());
                    this.H.Qh();
                    createCustomDialog.show();
                    return;
                }
                this.R.doOnBackPressed();
                return;
            }
            return;
        }
        if (id5 == R.id.ivTitleBtnRightText && (expandProfileEditFragment = this.H) != null) {
            ExtendFriendInfo Dh = expandProfileEditFragment.Dh();
            if (!TextUtils.isEmpty(Dh.f263491d) && Dh.f263491d.length() < 10) {
                QQToast.makeText(getQBaseActivity(), "\u8bf7\u5c0f\u4e3b\u81f3\u5c11\u586b\u6ee110\u4e2a\u5b57", 0).show();
                this.H.C.requestFocus();
            } else {
                if (!TextUtils.isEmpty(Dh.f263491d) && !this.H.Gh(Dh.f263491d)) {
                    QQCustomDialog createCustomDialog2 = DialogUtil.createCustomDialog(this.R, 0, (String) null, HardCodeUtil.qqStr(R.string.f170910zx3), HardCodeUtil.qqStr(R.string.f170909zx2), HardCodeUtil.qqStr(R.string.f170908zx1), new g(), new h(Dh));
                    this.H.Qh();
                    createCustomDialog2.show();
                    return;
                }
                xh(Dh);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        QBaseActivity qBaseActivity = getQBaseActivity();
        this.R = qBaseActivity;
        this.S = (QQAppInterface) qBaseActivity.getAppRuntime();
        this.T = getChildFragmentManager();
        Window window = this.R.getWindow();
        if (window != null) {
            window.setFormat(-3);
            window.setBackgroundDrawable(new ColorDrawable(-1));
            window.setSoftInputMode(16);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ((ITransFileController) this.S.getRuntimeService(ITransFileController.class)).removeHandle(this.X);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        super.onFinish();
        InputMethodManager inputMethodManager = (InputMethodManager) this.R.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        BounceScrollView bounceScrollView = this.E;
        if (bounceScrollView == null || inputMethodManager == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(bounceScrollView.getWindowToken(), 0);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        ExpandProfileEditFragment expandProfileEditFragment;
        if (view.getId() == R.id.byz && (expandProfileEditFragment = this.H) != null && expandProfileEditFragment.Ah()) {
            this.E.requestDisallowInterceptTouchEvent(true);
            if (motionEvent.getAction() == 1) {
                this.E.requestDisallowInterceptTouchEvent(false);
            }
            return false;
        }
        this.V.onTouchEvent(motionEvent);
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    private void yh(View view) {
        ((TextView) view.findViewById(R.id.ivTitleBtnLeft)).setOnClickListener(this);
        TextView textView = (TextView) view.findViewById(R.id.ivTitleBtnRightText);
        this.F = textView;
        textView.setOnClickListener(this);
        if (ThemeUtil.isInNightMode(this.S)) {
            this.F.setTextColor(-16777216);
        }
        QQProgressDialog qQProgressDialog = new QQProgressDialog(getQBaseActivity(), getQBaseActivity().getTitleBarHeight());
        this.U = qQProgressDialog;
        qQProgressDialog.setBackAndSearchFilter(true);
        this.E = (BounceScrollView) view.findViewById(R.id.b9w);
        this.V = new GestureDetector(getQBaseActivity(), this.W);
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a implements GestureDetector.OnGestureListener {
        a() {
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
            ExpandProfileEditFragment expandProfileEditFragment;
            if (motionEvent != null && motionEvent2 != null) {
                if ((motionEvent2.getY() - motionEvent.getY() <= 50.0f ? motionEvent.getY() - motionEvent2.getY() > 50.0f : true) && (expandProfileEditFragment = ExpandEditFragment.this.H) != null) {
                    expandProfileEditFragment.hideSoftInput();
                    ExpandEditFragment.this.J.setVisibility(8);
                    ExpandEditFragment.this.G.setVisibility(8);
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

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.au5, (ViewGroup) null);
        yh(inflate);
        zh();
        this.X.addFilter(NearbyPeoplePhotoUploadProcessor.class);
        ((ITransFileController) this.S.getRuntimeService(ITransFileController.class)).addHandle(this.X);
        return inflate;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        if (i16 != 0 && i3 == 1003) {
            AudioInfo audioInfo = (AudioInfo) intent.getSerializableExtra("audio_info");
            this.D = audioInfo;
            this.H.Kh(audioInfo);
            if (QLog.isColorLevel()) {
                QLog.i("ExtendFriendProfileEdit", 2, "onActivityResult audio_back path: " + this.D.path);
            }
        }
    }
}
