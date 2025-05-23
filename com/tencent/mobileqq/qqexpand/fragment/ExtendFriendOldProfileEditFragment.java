package com.tencent.mobileqq.qqexpand.fragment;

import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.etrump.mixlayout.ETTextView;
import com.tencent.avbiz.AVBizModuleFactory;
import com.tencent.avbiz.Constants;
import com.tencent.avbiz.IModule;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqexpand.bean.profile.ExtendFriendInfo;
import com.tencent.mobileqq.qqexpand.config.ExpandConfig;
import com.tencent.mobileqq.qqexpand.utils.CampusHelper;
import com.tencent.mobileqq.qqexpand.widget.voice.OldExpandVoiceView;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.troop.activity.AudioRecordFragment;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.al;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.base.MD5Utils;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.regex.Pattern;

/* loaded from: classes35.dex */
public class ExtendFriendOldProfileEditFragment extends QBaseFragment implements View.OnClickListener {

    /* renamed from: t0, reason: collision with root package name */
    public static final ColorDrawable f263714t0 = new ColorDrawable(-657931);
    public XEditTextEx C;
    public ETTextView D;
    public View E;
    public LinearLayout F;
    public ImageView G;
    public ExtendFriendInfo H;
    public String L;
    protected OldExpandVoiceView N;
    private View Q;
    private QQAppInterface R;
    private ExpandOldEditFragment S;
    private RelativeLayout T;
    private ImageView U;
    private TextView V;
    private TextView W;
    private com.tencent.mobileqq.troop.data.b X;
    private RelativeLayout Y;
    private ImageView Z;

    /* renamed from: a0, reason: collision with root package name */
    private View f263715a0;

    /* renamed from: b0, reason: collision with root package name */
    private View f263716b0;

    /* renamed from: c0, reason: collision with root package name */
    private TextView f263717c0;

    /* renamed from: d0, reason: collision with root package name */
    private Drawable f263718d0;

    /* renamed from: e0, reason: collision with root package name */
    private Drawable f263719e0;

    /* renamed from: f0, reason: collision with root package name */
    private ImageView f263720f0;

    /* renamed from: g0, reason: collision with root package name */
    private TextView f263721g0;

    /* renamed from: h0, reason: collision with root package name */
    private ImageView f263722h0;

    /* renamed from: i0, reason: collision with root package name */
    private ProgressBar f263723i0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f263724j0;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f263726l0;

    /* renamed from: o0, reason: collision with root package name */
    private int f263729o0;

    /* renamed from: q0, reason: collision with root package name */
    private String[] f263731q0;

    /* renamed from: r0, reason: collision with root package name */
    private QQToast f263732r0;
    public boolean I = false;
    public boolean J = false;
    public int K = 20;
    public boolean M = false;
    String P = "";

    /* renamed from: k0, reason: collision with root package name */
    private int f263725k0 = 0;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f263727m0 = false;

    /* renamed from: n0, reason: collision with root package name */
    private int f263728n0 = 0;

    /* renamed from: p0, reason: collision with root package name */
    private int f263730p0 = -1;

    /* renamed from: s0, reason: collision with root package name */
    TextWatcher f263733s0 = new a();

    /* loaded from: classes35.dex */
    class a implements TextWatcher {

        /* renamed from: d, reason: collision with root package name */
        int f263735d = 0;

        /* renamed from: e, reason: collision with root package name */
        String f263736e;

        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            int lineCount = ExtendFriendOldProfileEditFragment.this.C.getLineCount();
            if (lineCount > 30) {
                String str = this.f263736e;
                if (str != null) {
                    ExtendFriendOldProfileEditFragment.this.C.setText(str);
                    ExtendFriendOldProfileEditFragment.this.C.setSelection(this.f263735d);
                } else {
                    ExtendFriendOldProfileEditFragment.this.C.setText("");
                    ExtendFriendOldProfileEditFragment.this.C.setSelection(0);
                }
                if (ExtendFriendOldProfileEditFragment.this.f263732r0 == null) {
                    ExtendFriendOldProfileEditFragment extendFriendOldProfileEditFragment = ExtendFriendOldProfileEditFragment.this;
                    extendFriendOldProfileEditFragment.f263732r0 = QQToast.makeText(extendFriendOldProfileEditFragment.getActivity(), "\u8f93\u5165\u6587\u5b57\u4e0d\u8981\u8d85\u8fc730\u884c", 0);
                }
                if (!ExtendFriendOldProfileEditFragment.this.f263732r0.isShowing()) {
                    ExtendFriendOldProfileEditFragment.this.f263732r0.show();
                }
            }
            if (lineCount != ExtendFriendOldProfileEditFragment.this.f263728n0) {
                ExtendFriendOldProfileEditFragment.this.f263728n0 = lineCount;
                ExtendFriendOldProfileEditFragment.this.I = true;
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            if (ExtendFriendOldProfileEditFragment.this.C.getLineCount() <= 30) {
                this.f263736e = ExtendFriendOldProfileEditFragment.this.C.getText().toString();
                this.f263735d = ExtendFriendOldProfileEditFragment.this.C.getSelectionStart();
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            ExtendFriendOldProfileEditFragment extendFriendOldProfileEditFragment = ExtendFriendOldProfileEditFragment.this;
            if (extendFriendOldProfileEditFragment.L == null) {
                extendFriendOldProfileEditFragment.L = "";
            }
            if (!extendFriendOldProfileEditFragment.L.equals(charSequence.toString()) || ExtendFriendOldProfileEditFragment.this.f263727m0) {
                ExtendFriendOldProfileEditFragment.this.Ph();
            } else {
                ExtendFriendOldProfileEditFragment.this.ki();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class b implements View.OnTouchListener {
        b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                ExtendFriendOldProfileEditFragment.this.f263715a0.setVisibility(0);
            } else if (action == 1 || action == 3) {
                ExtendFriendOldProfileEditFragment.this.f263715a0.setVisibility(8);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class c implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: d, reason: collision with root package name */
        private boolean f263739d;

        /* renamed from: e, reason: collision with root package name */
        private int f263740e;

        /* renamed from: f, reason: collision with root package name */
        private final Rect f263741f = new Rect();

        c() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ExtendFriendOldProfileEditFragment.this.Q.getWindowVisibleDisplayFrame(this.f263741f);
            Rect rect = this.f263741f;
            int i3 = rect.bottom - rect.top;
            if (i3 != this.f263740e) {
                int height = ExtendFriendOldProfileEditFragment.this.Q.getRootView().getHeight();
                int i16 = height - i3;
                if (i16 > height / 4) {
                    ExtendFriendOldProfileEditFragment.this.f263729o0 = i16;
                    this.f263739d = true;
                    ExtendFriendOldProfileEditFragment.this.bi();
                } else if (this.f263739d) {
                    ExtendFriendOldProfileEditFragment.this.ai();
                }
                this.f263740e = i3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class d implements OldExpandVoiceView.a {
        d() {
        }

        @Override // com.tencent.mobileqq.qqexpand.widget.voice.OldExpandVoiceView.a
        public void a() {
            if (ExtendFriendOldProfileEditFragment.this.N.j()) {
                ExtendFriendOldProfileEditFragment.this.N.p();
            }
            ExtendFriendOldProfileEditFragment extendFriendOldProfileEditFragment = ExtendFriendOldProfileEditFragment.this;
            extendFriendOldProfileEditFragment.P = "";
            extendFriendOldProfileEditFragment.f263725k0 = 0;
            Fragment parentFragment = ExtendFriendOldProfileEditFragment.this.getParentFragment();
            if (parentFragment != null && (parentFragment instanceof ExpandOldEditFragment)) {
                ((ExpandOldEditFragment) parentFragment).E = null;
            }
            ExtendFriendOldProfileEditFragment.this.X = null;
            ExtendFriendOldProfileEditFragment.this.Wh();
            if (ExtendFriendOldProfileEditFragment.this.f263726l0) {
                ExtendFriendOldProfileEditFragment.this.f263727m0 = true;
                ExtendFriendOldProfileEditFragment.this.Ph();
            } else {
                ExtendFriendOldProfileEditFragment.this.f263727m0 = false;
                ExtendFriendOldProfileEditFragment extendFriendOldProfileEditFragment2 = ExtendFriendOldProfileEditFragment.this;
                String str = extendFriendOldProfileEditFragment2.L;
                if (str != null && str.equals(extendFriendOldProfileEditFragment2.C.getText().toString())) {
                    ExtendFriendOldProfileEditFragment.this.ki();
                }
            }
            ExtendFriendOldProfileEditFragment extendFriendOldProfileEditFragment3 = ExtendFriendOldProfileEditFragment.this;
            extendFriendOldProfileEditFragment3.M = true;
            extendFriendOldProfileEditFragment3.Ph();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            if (ExtendFriendOldProfileEditFragment.this.getQBaseActivity() != null) {
                if (ExtendFriendOldProfileEditFragment.this.R != null) {
                    str = ((com.tencent.mobileqq.qqexpand.manager.e) ExtendFriendOldProfileEditFragment.this.R.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).G();
                } else {
                    str = "";
                }
                CampusHelper.f(ExtendFriendOldProfileEditFragment.this.getQBaseActivity(), str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class f implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ExtendFriendInfo f263745d;

        f(ExtendFriendInfo extendFriendInfo) {
            this.f263745d = extendFriendInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ExtendFriendOldProfileEditFragment.this.getQBaseActivity() != null) {
                QBaseActivity qBaseActivity = ExtendFriendOldProfileEditFragment.this.getQBaseActivity();
                ExtendFriendInfo extendFriendInfo = this.f263745d;
                CampusHelper.d(qBaseActivity, extendFriendInfo.K, extendFriendInfo.L, extendFriendInfo.I, extendFriendInfo.H);
            }
        }
    }

    private void Mh() {
        ExpandConfig e16 = ((com.tencent.mobileqq.qqexpand.manager.e) this.R.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).e();
        if (e16 != null) {
            this.C.setHint(e16.defaultDecleration);
            this.D.setHint(e16.defaultDecleration);
            this.K = e16.declerationMinLen;
        }
        mi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ph() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment == null || !(parentFragment instanceof ExpandOldEditFragment)) {
            return;
        }
        ((ExpandOldEditFragment) parentFragment).Ch();
    }

    private void Qh() {
        this.C.setMaxHeight(Integer.MAX_VALUE);
    }

    private void Rh() {
        this.C.setMaxHeight((((getResources().getDisplayMetrics().heightPixels - this.f263729o0) - ImmersiveUtils.getStatusBarHeight(getQBaseActivity())) - this.f263717c0.getHeight()) - BaseAIOUtils.f(96.0f, getResources()));
    }

    private String Uh(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int length = str.length();
        for (int i3 = length - 1; i3 >= 0; i3--) {
            char charAt = str.charAt(i3);
            if (charAt != ' ' && charAt != '\n') {
                break;
            }
            length--;
        }
        return str.substring(0, length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wh() {
        if (this.f263724j0) {
            this.N.setVisibility(8);
            this.f263716b0.setVisibility(0);
        }
    }

    private void Xh() {
        OldExpandVoiceView oldExpandVoiceView = (OldExpandVoiceView) this.Q.findViewById(R.id.f165786di4);
        this.N = oldExpandVoiceView;
        oldExpandVoiceView.setMode(1);
        this.N.setOnClickListener(this);
        this.N.setActivity(getQBaseActivity());
        this.N.setDeleteIconEnable(true, new d());
    }

    private boolean Zh(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    private void ei() {
        if (this.f263731q0 == null) {
            return;
        }
        hi();
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.fragment.ExtendFriendOldProfileEditFragment.4
            @Override // java.lang.Runnable
            public void run() {
                ExtendFriendOldProfileEditFragment.this.mi();
                ExtendFriendOldProfileEditFragment.this.ii();
            }
        }, 1000L);
    }

    private void gi() {
        if (this.f263724j0) {
            this.N.setVisibility(0);
            this.f263716b0.setVisibility(8);
        }
    }

    private void hi() {
        this.f263722h0.setVisibility(8);
        this.f263723i0.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ii() {
        this.f263722h0.setVisibility(0);
        this.f263723i0.setVisibility(8);
    }

    private void initViews() {
        XEditTextEx xEditTextEx = (XEditTextEx) this.Q.findViewById(R.id.byz);
        this.C = xEditTextEx;
        xEditTextEx.setVisibility(8);
        this.Y = (RelativeLayout) this.Q.findViewById(R.id.id7);
        this.Z = (ImageView) this.Q.findViewById(R.id.ahx);
        this.f263717c0 = (TextView) this.Q.findViewById(R.id.jqd);
        this.f263716b0 = this.Q.findViewById(R.id.ccl);
        this.f263715a0 = this.Q.findViewById(R.id.eni);
        this.f263718d0 = new BitmapDrawable(com.tencent.mobileqq.qqexpand.utils.a.b(BaseAIOUtils.f(27.0f, getResources()), -15550475, 1.0f));
        this.f263719e0 = new BitmapDrawable(com.tencent.mobileqq.qqexpand.utils.a.b(BaseAIOUtils.f(27.0f, getResources()), -16777216, 0.08f));
        this.Z.setBackgroundDrawable(this.f263718d0);
        ETTextView eTTextView = (ETTextView) this.Q.findViewById(R.id.uxo);
        this.D = eTTextView;
        eTTextView.setOnClickListener(this);
        this.D.setVisibility(0);
        this.D.setTextColor(-16777216);
        this.E = this.Q.findViewById(R.id.f116136xx);
        this.C.setOnClickListener(this);
        this.C.addTextChangedListener(this.f263733s0);
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null && (parentFragment instanceof ExpandOldEditFragment)) {
            this.C.setOnTouchListener((ExpandOldEditFragment) parentFragment);
        }
        Xh();
        this.C.setBackgroundDrawable(new ColorDrawable(-526345));
        RelativeLayout relativeLayout = this.Y;
        ColorDrawable colorDrawable = f263714t0;
        relativeLayout.setBackgroundDrawable(colorDrawable);
        this.D.setBackgroundDrawable(new ColorDrawable(-526345));
        this.f263715a0.setBackgroundDrawable(this.f263719e0);
        this.Z.setOnTouchListener(new b());
        this.Z.setOnClickListener(this);
        this.F = (LinearLayout) this.Q.findViewById(R.id.f166086yn2);
        this.T = (RelativeLayout) this.Q.findViewById(R.id.f759640d);
        this.G = (ImageView) this.Q.findViewById(R.id.xzr);
        this.U = (ImageView) this.Q.findViewById(R.id.y0g);
        this.V = (TextView) this.Q.findViewById(R.id.f110886jq);
        this.W = (TextView) this.Q.findViewById(R.id.f1061667z);
        this.F.setBackgroundDrawable(colorDrawable);
        this.T.setBackgroundDrawable(colorDrawable);
        this.f263720f0 = (ImageView) this.Q.findViewById(R.id.xj6);
        this.f263721g0 = (TextView) this.Q.findViewById(R.id.f107246_w);
        this.f263722h0 = (ImageView) this.Q.findViewById(R.id.tgb);
        this.f263723i0 = (ProgressBar) this.Q.findViewById(R.id.f235006l);
        this.f263722h0.setOnClickListener(this);
        this.Q.getViewTreeObserver().addOnGlobalLayoutListener(new c());
        this.f263724j0 = true;
        ExtendFriendInfo extendFriendInfo = this.H;
        if (extendFriendInfo != null) {
            li(extendFriendInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ki() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment == null || !(parentFragment instanceof ExpandOldEditFragment)) {
            return;
        }
        ((ExpandOldEditFragment) parentFragment).Oh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mi() {
        if (this.f263731q0 == null) {
            this.f263731q0 = getResources().getStringArray(R.array.f155191bl);
        }
        if (this.f263730p0 == -1) {
            this.f263730p0 = new Random().nextInt(this.f263731q0.length);
        }
        int i3 = this.f263730p0 + 1;
        this.f263730p0 = i3;
        String[] strArr = this.f263731q0;
        int length = i3 % strArr.length;
        this.f263730p0 = length;
        this.f263721g0.setText(strArr[length]);
        String format = String.format("https://downv6.qq.com/innovate/qqexpand/avatarList/expand_avatar_%d.jpg", Integer.valueOf(new Random().nextInt(299) + 1));
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mFailedDrawable = BaseImageUtil.getDefaultFaceDrawable();
        obtain.mLoadingDrawable = BaseImageUtil.getDefaultFaceDrawable();
        URLDrawable drawable = URLDrawable.getDrawable(format, obtain);
        drawable.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306322b);
        this.f263720f0.setImageDrawable(drawable);
    }

    public boolean Nh() {
        XEditTextEx xEditTextEx = this.C;
        if (xEditTextEx == null) {
            return false;
        }
        int scrollY = xEditTextEx.getScrollY();
        int height = this.C.getLayout().getHeight() - ((this.C.getHeight() - this.C.getCompoundPaddingTop()) - this.C.getCompoundPaddingBottom());
        if (height == 0) {
            return false;
        }
        return scrollY > 0 || scrollY < height - 1;
    }

    public void Oh(boolean z16) {
        TextView textView = this.W;
        if (textView == null) {
            return;
        }
        if (z16) {
            textView.setTextColor(-11692801);
            this.W.setOnClickListener(this);
            this.W.setClickable(true);
        } else {
            textView.setTextColor(-3355444);
            this.W.setOnClickListener(null);
            this.W.setClickable(false);
        }
    }

    public ExtendFriendInfo Sh() {
        ExtendFriendInfo extendFriendInfo = new ExtendFriendInfo();
        extendFriendInfo.f263494h = this.P;
        extendFriendInfo.f263491d = Uh(this.C.getText().toString());
        com.tencent.mobileqq.troop.data.b bVar = this.X;
        if (bVar != null && (bVar instanceof AudioInfo)) {
            extendFriendInfo.f263495i = ((AudioInfo) bVar).duration / 1000;
        } else {
            extendFriendInfo.f263495i = this.f263725k0;
        }
        return extendFriendInfo;
    }

    public void Th() {
        String str;
        IModule moduleByName = AVBizModuleFactory.getModuleByName(Constants.Business.DEFAULT);
        if (!"true".equals(moduleByName.checkAVFocus())) {
            Iterator<Long> it = moduleByName.getFocusBusiness().keySet().iterator();
            if (it.hasNext()) {
                str = moduleByName.getFocusBusiness().get(it.next());
            } else {
                str = "\u97f3\u9891\u6b63\u5fd9";
            }
            QQToast.makeText(getContext(), String.format(getResources().getString(R.string.z_k), str), 1).show();
            return;
        }
        ExpandConfig e16 = ((com.tencent.mobileqq.qqexpand.manager.e) this.R.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).e();
        int i3 = e16 == null ? 11000 : e16.voiceMaxLength * 1000;
        Intent intent = new Intent();
        intent.putExtra("audio_max_length", i3);
        intent.putExtra("auto_start", true);
        intent.putExtra("public_fragment_window_feature", 1);
        intent.putExtra("click_space_cancel", false);
        PublicFragmentActivity.b.d(getQBaseActivity(), intent, PublicTransFragmentActivity.class, AudioRecordFragment.class, 1003);
        this.M = true;
        Ph();
    }

    public boolean Vh() {
        String obj = this.C.getText().toString();
        if (obj == null) {
            obj = "";
        }
        String str = this.L;
        return !(str == null || str.equals(obj)) || this.f263727m0;
    }

    public boolean Yh(String str) {
        if (!TextUtils.isEmpty(str) && !Zh(str)) {
            HashSet hashSet = new HashSet();
            for (int i3 = 0; i3 < str.length(); i3++) {
                char charAt = str.charAt(i3);
                if (!hashSet.contains(Character.valueOf(charAt))) {
                    if (hashSet.size() >= 3) {
                        return true;
                    }
                    hashSet.add(Character.valueOf(charAt));
                }
            }
        }
        return false;
    }

    public void ci(AudioInfo audioInfo) {
        this.X = audioInfo;
        if (TextUtils.isEmpty(audioInfo.path)) {
            return;
        }
        this.P = audioInfo.path;
        this.f263725k0 = audioInfo.duration;
        gi();
        this.N.setVoiceDuration(this.f263725k0 / 1000);
        this.N.setVoiceUrl(this.P);
        if (this.P.indexOf("file_md5=") <= 0) {
            this.N.setVoiceFileMD5(MD5Utils.encodeFileHexStr(this.P));
        }
        this.f263727m0 = true;
        Ph();
    }

    public void di(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.P = str;
    }

    public void fi(ExpandOldEditFragment expandOldEditFragment) {
        this.S = expandOldEditFragment;
    }

    public void hideSoftInput() {
        XEditTextEx xEditTextEx;
        if (!this.I || (xEditTextEx = this.C) == null) {
            return;
        }
        InputMethodUtil.hide(xEditTextEx);
    }

    public void ji() {
        OldExpandVoiceView oldExpandVoiceView = this.N;
        if (oldExpandVoiceView == null || !oldExpandVoiceView.j()) {
            return;
        }
        this.N.p();
    }

    public void li(ExtendFriendInfo extendFriendInfo) {
        if (this.f263724j0) {
            if (!TextUtils.isEmpty(extendFriendInfo.f263491d)) {
                this.L = extendFriendInfo.f263491d;
            } else {
                this.L = "";
                extendFriendInfo.f263491d = "";
            }
            this.C.setText(extendFriendInfo.f263491d);
            this.D.setText(extendFriendInfo.f263491d);
            this.C.setSelection(extendFriendInfo.f263491d.length());
            hideSoftInput();
            if (!TextUtils.isEmpty(extendFriendInfo.f263494h)) {
                gi();
                this.P = extendFriendInfo.f263494h;
                int i3 = extendFriendInfo.f263495i;
                this.f263725k0 = i3;
                this.N.setVoiceDuration(i3);
                this.N.setVoiceUrl(this.P);
                if (this.P.indexOf("file_md5=") <= 0) {
                    this.N.setVoiceFileMD5(MD5Utils.encodeFileHexStr(this.P));
                }
                this.f263726l0 = true;
            } else {
                Wh();
                this.f263726l0 = false;
            }
            ni(extendFriendInfo);
            if (!SimpleUIUtil.getSimpleUISwitch()) {
                ExpandOldEditFragment expandOldEditFragment = this.S;
                if (expandOldEditFragment != null && expandOldEditFragment.Eh() != null && this.S.Eh().i() != null) {
                    int i16 = extendFriendInfo.f263496m;
                    int i17 = extendFriendInfo.D;
                    if (i17 != 0) {
                        i16 = i17;
                    }
                    this.S.Eh().setUsingItem(i16);
                    this.S.Eh().i().J(i16);
                    this.S.C = 3;
                }
                ExpandOldEditFragment expandOldEditFragment2 = this.S;
                if (expandOldEditFragment2 != null && expandOldEditFragment2.Dh() != null && this.S.Dh().i() != null) {
                    int i18 = extendFriendInfo.C;
                    int i19 = extendFriendInfo.E;
                    if (i19 != 0) {
                        i18 = i19;
                    }
                    this.S.Dh().setUsingItem(i18);
                    this.S.Dh().i().J(i18);
                    this.S.C = 2;
                }
            }
            this.H = extendFriendInfo;
            if (extendFriendInfo.G || extendFriendInfo.F) {
                this.D.performClick();
                return;
            }
            return;
        }
        this.H = extendFriendInfo;
    }

    public void ni(final ExtendFriendInfo extendFriendInfo) {
        if (getQBaseActivity() == null || extendFriendInfo == null) {
            return;
        }
        if (!TextUtils.isEmpty(extendFriendInfo.H) && !TextUtils.isEmpty(extendFriendInfo.I)) {
            this.T.setVisibility(0);
            this.F.setVisibility(8);
            this.V.setText(ProfileCardUtil.c0(extendFriendInfo.I, false, extendFriendInfo.J == 2 ? R.drawable.ne6 : R.drawable.ne7, R.dimen.f159473d84, R.dimen.f159472d83, getQBaseActivity(), this.R, null));
            long j3 = extendFriendInfo.J;
            if (j3 == 2) {
                this.W.setVisibility(8);
            } else if (j3 == 0) {
                this.W.setVisibility(0);
                this.W.setText(R.string.f198374mj);
                Oh(true);
            } else if (j3 == 1) {
                this.W.setVisibility(0);
                this.W.setText(R.string.f198384mk);
                Oh(false);
            } else {
                this.W.setVisibility(0);
                this.W.setText(R.string.f198374mj);
                Oh(true);
            }
            this.T.post(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.fragment.ExtendFriendOldProfileEditFragment.7
                @Override // java.lang.Runnable
                public void run() {
                    if (al.c(ExtendFriendOldProfileEditFragment.this.V, ExtendFriendOldProfileEditFragment.this.T.getWidth()) > 4) {
                        ExtendFriendOldProfileEditFragment.this.V.setText(extendFriendInfo.I);
                        ExtendFriendOldProfileEditFragment.this.U.setImageResource(extendFriendInfo.J == 2 ? R.drawable.ne6 : R.drawable.ne7);
                        ExtendFriendOldProfileEditFragment.this.U.setVisibility(0);
                        return;
                    }
                    ExtendFriendOldProfileEditFragment.this.U.setVisibility(8);
                }
            });
            this.T.setOnClickListener(new f(extendFriendInfo));
        } else {
            this.W.setVisibility(8);
            this.T.setVisibility(8);
            this.F.setVisibility(0);
            this.G.setImageResource(R.drawable.ndz);
            this.G.setOnClickListener(new e());
        }
        this.H = extendFriendInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ExtendFriendInfo extendFriendInfo;
        switch (view.getId()) {
            case R.id.ahx /* 2131364592 */:
                Th();
                return;
            case R.id.tgb /* 2131364688 */:
                ei();
                return;
            case R.id.byz /* 2131368027 */:
                break;
            case R.id.uxo /* 2131368050 */:
                this.D.setVisibility(8);
                this.C.setVisibility(0);
                break;
            case R.id.f1061667z /* 2131390832 */:
                if (getQBaseActivity() == null || this.H == null) {
                    return;
                }
                QBaseActivity qBaseActivity = getQBaseActivity();
                ExtendFriendInfo extendFriendInfo2 = this.H;
                CampusHelper.e(qBaseActivity, extendFriendInfo2.K, extendFriendInfo2.I, extendFriendInfo2.H);
                return;
            case R.id.f167117l01 /* 2131392901 */:
                if (this.N.j()) {
                    this.N.p();
                    return;
                } else {
                    this.N.l();
                    return;
                }
            default:
                return;
        }
        this.J = true;
        this.C.setFocusableInTouchMode(true);
        this.C.setFocusable(true);
        this.C.requestFocus();
        InputMethodUtil.show(this.C);
        ExpandOldEditFragment expandOldEditFragment = this.S;
        if (expandOldEditFragment == null || (extendFriendInfo = this.H) == null || extendFriendInfo.F || extendFriendInfo.G) {
            return;
        }
        expandOldEditFragment.zh(0);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        OldExpandVoiceView oldExpandVoiceView = this.N;
        if (oldExpandVoiceView == null || !oldExpandVoiceView.j()) {
            return;
        }
        this.N.p();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f263728n0 = this.D.getLineCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ai() {
        this.I = false;
        Qh();
        if (!TextUtils.isEmpty(this.P)) {
            this.N.setVisibility(0);
        } else {
            this.f263716b0.setVisibility(0);
        }
        ExpandOldEditFragment expandOldEditFragment = this.S;
        if (expandOldEditFragment == null || expandOldEditFragment.C != 0) {
            return;
        }
        expandOldEditFragment.Mh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bi() {
        this.I = true;
        XEditTextEx xEditTextEx = this.C;
        xEditTextEx.setSelection(xEditTextEx.getText().length());
        Rh();
        this.N.setVisibility(8);
        this.f263716b0.setVisibility(8);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.Q = layoutInflater.inflate(R.layout.gwz, viewGroup, false);
        this.R = (QQAppInterface) getQBaseActivity().getAppRuntime();
        initViews();
        Mh();
        if (getActivity() != null && CampusHelper.h(this.R)) {
            CampusHelper.k(this.R, false);
            getActivity().setResult(8193);
        }
        return this.Q;
    }
}
