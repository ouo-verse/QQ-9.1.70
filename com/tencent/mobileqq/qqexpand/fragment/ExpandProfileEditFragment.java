package com.tencent.mobileqq.qqexpand.fragment;

import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.etrump.mixlayout.ETTextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqexpand.bean.profile.ExtendFriendInfo;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.HashSet;
import java.util.Random;
import java.util.regex.Pattern;

/* loaded from: classes35.dex */
public class ExpandProfileEditFragment extends QBaseFragment implements View.OnClickListener {

    /* renamed from: a0, reason: collision with root package name */
    public static final ColorDrawable f263614a0 = new ColorDrawable(-657931);
    public XEditTextEx C;
    public ETTextView D;
    public View E;
    public ExtendFriendInfo F;
    public String J;
    private View L;
    private QQAppInterface M;
    private ExpandEditFragment N;
    private ImageView P;
    private TextView Q;
    private ImageView R;
    private ProgressBar S;
    private boolean T;
    private int V;
    private String[] X;
    private QQToast Y;
    public boolean G = false;
    public boolean H = false;
    public int I = 20;
    public boolean K = false;
    private int U = 0;
    private int W = -1;
    TextWatcher Z = new a();

    /* loaded from: classes35.dex */
    class a implements TextWatcher {

        /* renamed from: d, reason: collision with root package name */
        int f263615d = 0;

        /* renamed from: e, reason: collision with root package name */
        String f263616e;

        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            int lineCount = ExpandProfileEditFragment.this.C.getLineCount();
            if (lineCount > 30) {
                String str = this.f263616e;
                if (str != null) {
                    ExpandProfileEditFragment.this.C.setText(str);
                    ExpandProfileEditFragment.this.C.setSelection(this.f263615d);
                } else {
                    ExpandProfileEditFragment.this.C.setText("");
                    ExpandProfileEditFragment.this.C.setSelection(0);
                }
                if (ExpandProfileEditFragment.this.Y == null) {
                    ExpandProfileEditFragment expandProfileEditFragment = ExpandProfileEditFragment.this;
                    expandProfileEditFragment.Y = QQToast.makeText(expandProfileEditFragment.getActivity(), "\u8f93\u5165\u6587\u5b57\u4e0d\u8981\u8d85\u8fc730\u884c", 0);
                }
                if (!ExpandProfileEditFragment.this.Y.isShowing()) {
                    ExpandProfileEditFragment.this.Y.show();
                }
            }
            if (lineCount != ExpandProfileEditFragment.this.U) {
                ExpandProfileEditFragment.this.U = lineCount;
                ExpandProfileEditFragment.this.G = true;
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            if (ExpandProfileEditFragment.this.C.getLineCount() <= 30) {
                this.f263616e = ExpandProfileEditFragment.this.C.getText().toString();
                this.f263615d = ExpandProfileEditFragment.this.C.getSelectionStart();
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            ExpandProfileEditFragment expandProfileEditFragment = ExpandProfileEditFragment.this;
            if (expandProfileEditFragment.J == null) {
                expandProfileEditFragment.J = "";
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: d, reason: collision with root package name */
        private boolean f263618d;

        /* renamed from: e, reason: collision with root package name */
        private int f263619e;

        /* renamed from: f, reason: collision with root package name */
        private final Rect f263620f = new Rect();

        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ExpandProfileEditFragment.this.L.getWindowVisibleDisplayFrame(this.f263620f);
            Rect rect = this.f263620f;
            int i3 = rect.bottom - rect.top;
            if (i3 != this.f263619e) {
                int height = ExpandProfileEditFragment.this.L.getRootView().getHeight();
                int i16 = height - i3;
                if (i16 > height / 4) {
                    ExpandProfileEditFragment.this.V = i16;
                    this.f263618d = true;
                    ExpandProfileEditFragment.this.Jh();
                } else if (this.f263618d) {
                    ExpandProfileEditFragment.this.Ih();
                }
                this.f263619e = i3;
            }
        }
    }

    private void Bh() {
        this.C.setMaxHeight(Integer.MAX_VALUE);
    }

    private void Ch() {
        this.C.setMaxHeight(((getResources().getDisplayMetrics().heightPixels - this.V) - ImmersiveUtils.getStatusBarHeight(getQBaseActivity())) - BaseAIOUtils.f(96.0f, getResources()));
    }

    private String Eh(String str) {
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

    private boolean Hh(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    private void Mh() {
        if (this.X == null) {
            return;
        }
        Oh();
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.fragment.ExpandProfileEditFragment.3
            @Override // java.lang.Runnable
            public void run() {
                ExpandProfileEditFragment.this.Sh();
                ExpandProfileEditFragment.this.Ph();
            }
        }, 1000L);
    }

    private void Oh() {
        this.R.setVisibility(8);
        this.S.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ph() {
        this.R.setVisibility(0);
        this.S.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sh() {
        if (this.X == null) {
            this.X = getResources().getStringArray(R.array.f155191bl);
        }
        if (this.W == -1) {
            this.W = new Random().nextInt(this.X.length);
        }
        int i3 = this.W + 1;
        this.W = i3;
        String[] strArr = this.X;
        int length = i3 % strArr.length;
        this.W = length;
        this.Q.setText(strArr[length]);
        String format = String.format("https://downv6.qq.com/innovate/qqexpand/avatarList/expand_avatar_%d.jpg", Integer.valueOf(new Random().nextInt(299) + 1));
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mFailedDrawable = BaseImageUtil.getDefaultFaceDrawable();
        obtain.mLoadingDrawable = BaseImageUtil.getDefaultFaceDrawable();
        URLDrawable drawable = URLDrawable.getDrawable(format, obtain);
        drawable.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306322b);
        this.P.setImageDrawable(drawable);
    }

    private void initViews() {
        XEditTextEx xEditTextEx = (XEditTextEx) this.L.findViewById(R.id.byz);
        this.C = xEditTextEx;
        xEditTextEx.setVisibility(8);
        ETTextView eTTextView = (ETTextView) this.L.findViewById(R.id.uxo);
        this.D = eTTextView;
        eTTextView.setOnClickListener(this);
        this.D.setVisibility(0);
        this.D.setTextColor(-16777216);
        this.E = this.L.findViewById(R.id.f116136xx);
        this.C.setOnClickListener(this);
        this.C.addTextChangedListener(this.Z);
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null && (parentFragment instanceof ExpandEditFragment)) {
            this.C.setOnTouchListener((ExpandEditFragment) parentFragment);
        }
        this.C.setBackgroundDrawable(new ColorDrawable(-526345));
        this.D.setBackgroundDrawable(new ColorDrawable(-526345));
        this.P = (ImageView) this.L.findViewById(R.id.xj6);
        this.Q = (TextView) this.L.findViewById(R.id.f107246_w);
        this.R = (ImageView) this.L.findViewById(R.id.tgb);
        this.S = (ProgressBar) this.L.findViewById(R.id.f235006l);
        this.R.setOnClickListener(this);
        this.L.getViewTreeObserver().addOnGlobalLayoutListener(new b());
        this.T = true;
        ExtendFriendInfo extendFriendInfo = this.F;
        if (extendFriendInfo != null) {
            Rh(extendFriendInfo);
        }
    }

    private void zh() {
        Sh();
    }

    public boolean Ah() {
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

    public ExtendFriendInfo Dh() {
        ExtendFriendInfo extendFriendInfo = new ExtendFriendInfo();
        extendFriendInfo.f263491d = Eh(this.C.getText().toString());
        return extendFriendInfo;
    }

    public boolean Fh() {
        String obj = this.C.getText().toString();
        if (obj == null) {
            obj = "";
        }
        String str = this.J;
        return (str == null || str.equals(obj)) ? false : true;
    }

    public boolean Gh(String str) {
        if (!TextUtils.isEmpty(str) && !Hh(str)) {
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

    public void Nh(ExpandEditFragment expandEditFragment) {
        this.N = expandEditFragment;
    }

    public void Rh(ExtendFriendInfo extendFriendInfo) {
        if (this.T) {
            if (!TextUtils.isEmpty(extendFriendInfo.f263491d)) {
                this.J = extendFriendInfo.f263491d;
            } else {
                this.J = "";
                extendFriendInfo.f263491d = "";
            }
            this.C.setText(extendFriendInfo.f263491d);
            this.D.setText(new QQText(QzoneEmotionUtils.emCodesToQQcodes(extendFriendInfo.f263491d), 3, 24));
            this.C.setSelection(extendFriendInfo.f263491d.length());
            hideSoftInput();
            this.F = extendFriendInfo;
            return;
        }
        this.F = extendFriendInfo;
    }

    public void hideSoftInput() {
        XEditTextEx xEditTextEx;
        if (!this.G || (xEditTextEx = this.C) == null) {
            return;
        }
        InputMethodUtil.hide(xEditTextEx);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id5 = view.getId();
        if (id5 != R.id.tgb) {
            if (id5 != R.id.byz) {
                if (id5 != R.id.uxo) {
                    return;
                }
                this.D.setVisibility(8);
                this.C.setVisibility(0);
            }
            this.H = true;
            this.C.setFocusableInTouchMode(true);
            this.C.setFocusable(true);
            this.C.requestFocus();
            InputMethodUtil.show(this.C);
            return;
        }
        Mh();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.U = this.D.getLineCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ih() {
        this.G = false;
        Bh();
        ExpandEditFragment expandEditFragment = this.N;
        if (expandEditFragment == null || expandEditFragment.C != 0) {
            return;
        }
        expandEditFragment.Ah();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jh() {
        this.G = true;
        XEditTextEx xEditTextEx = this.C;
        xEditTextEx.setSelection(xEditTextEx.getText().length());
        Ch();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.L = layoutInflater.inflate(R.layout.au6, viewGroup, false);
        this.M = (QQAppInterface) getQBaseActivity().getAppRuntime();
        initViews();
        zh();
        return this.L;
    }

    public void Kh(AudioInfo audioInfo) {
    }

    public void Lh(String str) {
    }

    public void Qh() {
    }
}
