package com.tencent.mobileqq.qqexpand.fragment;

import android.app.Activity;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.utils.ba;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.qqexpand.widget.ExtendFriendMultiLinesTagsView;
import com.tencent.mobileqq.search.util.aw;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes35.dex */
public abstract class ExtendFriendSearchBaseFragment extends PublicBaseFragment implements Handler.Callback, View.OnClickListener, TextWatcher, TextView.OnEditorActionListener, aw.a, BounceScrollView.d {
    protected BaseActivity C;
    protected QQAppInterface D;
    private SystemBarCompact E;
    private QuickPinyinEditText F;
    private ImageView G;
    private TextView H;
    private FrameLayout I;
    private BounceScrollView J;
    private ViewGroup K;
    private ExtendFriendMultiLinesTagsView L;
    private TextView M;
    private ViewGroup N;
    private ExtendFriendMultiLinesTagsView P;
    private View Q;
    private int R = -1;
    private boolean S = true;
    private WeakReferenceHandler T;
    private aw U;

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a implements ExtendFriendMultiLinesTagsView.a {
        a() {
        }

        @Override // com.tencent.mobileqq.qqexpand.widget.ExtendFriendMultiLinesTagsView.a
        public void a(String str, int i3) {
            ExtendFriendSearchBaseFragment.this.F.setText(str);
            ExtendFriendSearchBaseFragment.this.F.setSelection(ExtendFriendSearchBaseFragment.this.F.length());
            ExtendFriendSearchBaseFragment.this.sh(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class b implements ExtendFriendMultiLinesTagsView.a {
        b() {
        }

        @Override // com.tencent.mobileqq.qqexpand.widget.ExtendFriendMultiLinesTagsView.a
        public void a(String str, int i3) {
            ExtendFriendSearchBaseFragment.this.F.setText(str);
            ExtendFriendSearchBaseFragment.this.F.setSelection(ExtendFriendSearchBaseFragment.this.F.length());
            ExtendFriendSearchBaseFragment.this.sh(str);
        }
    }

    private void Ah(int i3) {
        if (ImmersiveUtils.isSupporImmersive() == 1 && this.E == null) {
            SystemBarCompact systemBarCompact = new SystemBarCompact((Activity) getBaseActivity(), false, getResources().getColor(i3));
            this.E = systemBarCompact;
            systemBarCompact.init();
            this.C.getWindow().addFlags(67108864);
            Bh();
        }
    }

    private void Bh() {
        try {
            if (this.E == null || !ThemeUtil.isInNightMode(this.C.app)) {
                return;
            }
            this.E.setStatusBarMask(new PorterDuffColorFilter(getResources().getColor(R.color.a_p), PorterDuff.Mode.SRC_ATOP));
        } catch (Exception e16) {
            QLog.e("ExtendFriendSearchBaseFragment", 1, "showStatusBarMask fail.", e16);
        }
    }

    private void Ch(int i3) {
        if (QLog.isColorLevel()) {
            QLog.i("ExtendFriendSearchBaseFragment", 2, String.format("switchToMode oldMode=%s newMode=%s", Integer.valueOf(this.R), Integer.valueOf(i3)));
        }
        if (this.R != i3) {
            this.R = i3;
            if (i3 == 1) {
                this.J.setVisibility(8);
                this.I.setVisibility(0);
                Dh(false, 50L);
            } else {
                this.F.requestFocus();
                this.F.setText("");
                this.J.setVisibility(0);
                this.I.setVisibility(8);
                Dh(true, 50L);
            }
        }
    }

    private void Dh(boolean z16, long j3) {
        if (QLog.isColorLevel()) {
            QLog.i("ExtendFriendSearchBaseFragment", 2, String.format("toggleInputMethod open=%s delay=%s", Boolean.valueOf(z16), Long.valueOf(j3)));
        }
        this.T.removeMessages(12);
        this.T.removeMessages(11);
        if (z16) {
            if (this.T.hasMessages(11)) {
                return;
            }
            this.T.sendEmptyMessageDelayed(11, j3);
        } else {
            if (this.T.hasMessages(12)) {
                return;
            }
            this.T.sendEmptyMessageDelayed(12, j3);
        }
    }

    private void hideInputMethod() {
        if (QLog.isColorLevel()) {
            QLog.i("ExtendFriendSearchBaseFragment", 2, "hideInputMethod");
        }
        this.F.clearFocus();
        ((InputMethodManager) this.C.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(this.F.getWindowToken(), 0);
    }

    private void showInputMethod() {
        if (QLog.isColorLevel()) {
            QLog.i("ExtendFriendSearchBaseFragment", 2, "showInputMethod");
        }
        this.F.clearFocus();
        ((InputMethodManager) this.C.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).showSoftInput(this.F, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void th(boolean z16) {
        this.F.setFocusable(z16);
        this.F.setFocusableInTouchMode(z16);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String obj = this.F.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            this.G.setVisibility(8);
        } else {
            this.G.setVisibility(0);
        }
        if (this.R == 1 && TextUtils.isEmpty(obj)) {
            Ch(0);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3 = message.what;
        if (i3 == 11) {
            showInputMethod();
            return false;
        }
        if (i3 != 12) {
            return false;
        }
        hideInputMethod();
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        if (this.R == 1) {
            Ch(0);
            return true;
        }
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ozu /* 1912930361 */:
                vh();
                return;
            case R.id.p1h /* 1912930422 */:
                if (this.R == 1) {
                    Ch(0);
                    return;
                }
                BaseActivity baseActivity = this.C;
                if (baseActivity != null) {
                    baseActivity.finish();
                    return;
                }
                return;
            case R.id.p1i /* 1912930423 */:
                if (this.R == 1) {
                    Ch(0);
                }
                this.F.setText("");
                return;
            default:
                return;
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        BaseActivity baseActivity = getBaseActivity();
        this.C = baseActivity;
        this.D = baseActivity.app;
        Window window = baseActivity.getWindow();
        if (window != null) {
            window.setFormat(-3);
            window.setBackgroundDrawable(new ColorDrawable(-1));
        }
        this.T = new WeakReferenceHandler(Looper.getMainLooper(), this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.T.removeCallbacksAndMessages(null);
        this.F.removeTextChangedListener(this);
        this.F.setOnEditorActionListener(null);
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        super.onFinish();
        BaseActivity baseActivity = this.C;
        if (baseActivity != null) {
            baseActivity.overridePendingTransition(0, R.anim.f155053hw);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (!this.S && this.R == 1) {
            th(false);
            this.T.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.fragment.ExtendFriendSearchBaseFragment.3
                @Override // java.lang.Runnable
                public void run() {
                    ExtendFriendSearchBaseFragment.this.th(true);
                }
            }, 50L);
        }
        this.S = false;
    }

    @Override // com.tencent.mobileqq.search.util.aw.a
    public void onSoftKeyboardClosed() {
        this.F.setCursorVisible(false);
    }

    @Override // com.tencent.mobileqq.search.util.aw.a
    public void onSoftKeyboardOpened(int i3) {
        this.F.setCursorVisible(true);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        hideInputMethod();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle bundle) {
        QuickPinyinEditText quickPinyinEditText = this.F;
        if (quickPinyinEditText != null) {
            quickPinyinEditText.removeTextChangedListener(this);
        }
        super.onViewStateRestored(bundle);
        QuickPinyinEditText quickPinyinEditText2 = this.F;
        if (quickPinyinEditText2 != null) {
            quickPinyinEditText2.addTextChangedListener(this);
        }
    }

    abstract void uh(ViewGroup viewGroup);

    abstract void vh();

    abstract void wh(String str);

    public void yh(String str) {
        QuickPinyinEditText quickPinyinEditText = this.F;
        if (quickPinyinEditText != null) {
            float width = (quickPinyinEditText.getWidth() - this.F.getPaddingLeft()) - this.F.getPaddingRight();
            float textSize = this.F.getTextSize();
            float max = Math.max((textSize <= 1.0f || width <= 1.0f) ? 18.0f : width / textSize, 12.0f);
            if (com.tencent.mobileqq.confess.e.a(str) > max) {
                int max2 = Math.max(0, (int) (max - 4.0f));
                int i3 = max2;
                while (max2 < str.length()) {
                    if (!TextUtils.equals(String.valueOf(str.charAt(max2 - 1)), "\u3001")) {
                        if (com.tencent.mobileqq.confess.e.a(str.substring(0, max2) + "\u2026") > max) {
                            break;
                        } else {
                            i3 = max2;
                        }
                    }
                    max2++;
                }
                str = str.substring(0, i3) + "\u2026";
            }
            this.F.setHint(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sh(String str) {
        Ch(1);
        wh(str);
    }

    @Override // com.tencent.mobileqq.widget.BounceScrollView.d
    public void onScrollChanged(int i3, int i16, int i17, int i18) {
        Dh(false, 50L);
    }

    public void xh(ArrayList<String> arrayList) {
        boolean z16 = arrayList == null || arrayList.isEmpty();
        this.P.setSearchTags(arrayList);
        this.N.setVisibility(z16 ? 8 : 0);
    }

    public void zh(ArrayList<String> arrayList) {
        boolean z16 = arrayList == null || arrayList.isEmpty();
        this.L.setSearchTags(arrayList);
        this.K.setVisibility(z16 ? 8 : 0);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.f167376d01, (ViewGroup) null);
        View findViewById = viewGroup2.findViewById(R.id.p1v);
        if (findViewById != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.topMargin = ImmersiveUtils.getStatusBarHeight(this.C);
            findViewById.setLayoutParams(layoutParams);
            Ah(R.color.skin_color_title_immersive_bar);
        }
        QuickPinyinEditText quickPinyinEditText = (QuickPinyinEditText) viewGroup2.findViewById(R.id.p1l);
        this.F = quickPinyinEditText;
        quickPinyinEditText.setImeOptions(3);
        this.F.setOnEditorActionListener(this);
        this.F.addTextChangedListener(this);
        this.F.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
        this.F.setInputType(524289);
        ImageView imageView = (ImageView) viewGroup2.findViewById(R.id.p1i);
        this.G = imageView;
        ba.a aVar = ba.f77070d;
        imageView.setOnTouchListener(aVar);
        this.G.setOnClickListener(this);
        TextView textView = (TextView) viewGroup2.findViewById(R.id.p1h);
        this.H = textView;
        textView.setOnTouchListener(aVar);
        this.H.setOnClickListener(this);
        FrameLayout frameLayout = (FrameLayout) viewGroup2.findViewById(R.id.p1j);
        this.I = frameLayout;
        uh(frameLayout);
        BounceScrollView bounceScrollView = (BounceScrollView) viewGroup2.findViewById(R.id.p1n);
        this.J = bounceScrollView;
        bounceScrollView.setOnScrollChangedListener(this);
        this.K = (ViewGroup) viewGroup2.findViewById(R.id.ozv);
        ExtendFriendMultiLinesTagsView extendFriendMultiLinesTagsView = (ExtendFriendMultiLinesTagsView) viewGroup2.findViewById(R.id.ozw);
        this.L = extendFriendMultiLinesTagsView;
        extendFriendMultiLinesTagsView.setViewMargin(BaseAIOUtils.f(10.0f, getResources()), BaseAIOUtils.f(10.0f, getResources()));
        this.L.setOnItemClickListener(new a());
        TextView textView2 = (TextView) viewGroup2.findViewById(R.id.ozu);
        this.M = textView2;
        textView2.setOnClickListener(this);
        this.N = (ViewGroup) viewGroup2.findViewById(R.id.f163236p14);
        ExtendFriendMultiLinesTagsView extendFriendMultiLinesTagsView2 = (ExtendFriendMultiLinesTagsView) viewGroup2.findViewById(R.id.f163237p15);
        this.P = extendFriendMultiLinesTagsView2;
        extendFriendMultiLinesTagsView2.setViewMargin(BaseAIOUtils.f(10.0f, getResources()), BaseAIOUtils.f(10.0f, getResources()));
        this.P.setOnItemClickListener(new b());
        View findViewById2 = viewGroup2.findViewById(R.id.p0l);
        this.Q = findViewById2;
        if (findViewById2 != null) {
            this.Q.setVisibility(ThemeUtil.isInNightMode(this.C.app) ? 0 : 8);
        }
        aw awVar = new aw(viewGroup2);
        this.U = awVar;
        awVar.a(this);
        Ch(0);
        return viewGroup2;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
        if (i3 != 3 && (keyEvent == null || keyEvent.getKeyCode() != 66)) {
            return false;
        }
        String trim = this.F.getText().toString().trim();
        if (!TextUtils.isEmpty(trim)) {
            sh(trim);
        }
        Dh(false, 50L);
        return true;
    }

    @Override // com.tencent.mobileqq.widget.BounceScrollView.d
    public void ae(float f16, float f17) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
    }
}
