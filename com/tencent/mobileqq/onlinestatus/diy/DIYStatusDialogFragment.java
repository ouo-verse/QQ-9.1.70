package com.tencent.mobileqq.onlinestatus.diy;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.widget.NestedScrollView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tencent.common.config.AppSetting;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.DiyStatusEmoInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.onlinestatus.af;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.au;
import com.tencent.mobileqq.onlinestatus.bs;
import com.tencent.mobileqq.onlinestatus.diy.DIYStatusDialogFragment;
import com.tencent.mobileqq.onlinestatus.utils.z;
import com.tencent.mobileqq.onlinestatus.view.v;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* compiled from: P */
@RequiresApi(api = 16)
@SuppressLint({"UseCompatLoadingForDrawables"})
/* loaded from: classes16.dex */
public class DIYStatusDialogFragment extends BottomSheetDialogFragment implements DialogInterface.OnKeyListener {
    private static final Map<Integer, WeakReference<c>> U = new HashMap();
    protected AppRuntime C;
    protected BottomSheetBehavior D;
    protected af E;
    protected d F;
    protected v.a G;
    protected int H;
    private boolean I;
    protected LinearLayout J;
    protected View K;
    protected NestedScrollView L;
    protected ImageView M;
    protected EditText N;
    protected ImageView P;
    protected LinearLayout Q;
    protected ArrayList<DiyStatusEmoInfo> R;
    protected Button S;
    protected TextWatcher T;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements TextWatcher {

        /* renamed from: d, reason: collision with root package name */
        String f255856d;

        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            DIYStatusDialogFragment.this.S.setEnabled(!TextUtils.isEmpty(editable));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            this.f255856d = DIYStatusDialogFragment.this.N.getText().toString();
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            if (DIYStatusDialogFragment.this.getContext() == null) {
                return;
            }
            DIYStatusDialogFragment.this.P.setVisibility(4);
            DIYStatusDialogFragment dIYStatusDialogFragment = DIYStatusDialogFragment.this;
            dIYStatusDialogFragment.N.removeTextChangedListener(dIYStatusDialogFragment.T);
            if (DIYStatusDialogFragment.this.E.g(charSequence.toString()) > 8) {
                QQToast.makeText(DIYStatusDialogFragment.this.getContext(), DIYStatusDialogFragment.this.getContext().getResources().getString(R.string.zsj), 0).show();
                DIYStatusDialogFragment.this.N.setText(this.f255856d);
                EditText editText = DIYStatusDialogFragment.this.N;
                editText.setSelection(editText.getText().length());
            }
            DIYStatusDialogFragment dIYStatusDialogFragment2 = DIYStatusDialogFragment.this;
            dIYStatusDialogFragment2.N.addTextChangedListener(dIYStatusDialogFragment2.T);
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class b extends BottomSheetBehavior.e {
        b() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onSlide(@NonNull View view, float f16) {
            if (QLog.isColorLevel()) {
                QLog.i("DIYStatusDialogFragment", 2, "onSlide\uff1aslideOffset = " + f16);
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onStateChanged(@NonNull View view, int i3) {
            if (QLog.isColorLevel()) {
                QLog.i("DIYStatusDialogFragment", 2, "onStateChanged\uff1anewState = " + i3);
            }
            if (i3 == 4) {
                v.a aVar = DIYStatusDialogFragment.this.G;
                if (aVar != null) {
                    aVar.L0(AppRuntime.Status.online, 2000);
                }
                DIYStatusDialogFragment.this.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<d> f255859a;

        /* renamed from: b, reason: collision with root package name */
        public final WeakReference<v.a> f255860b;

        /* renamed from: c, reason: collision with root package name */
        public final int f255861c;

        public c(d dVar, v.a aVar, int i3) {
            this.f255859a = new WeakReference<>(dVar);
            this.f255860b = new WeakReference<>(aVar);
            this.f255861c = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface d {
        void a(DiyStatusEmoInfo diyStatusEmoInfo);
    }

    public DIYStatusDialogFragment() {
        this.E = af.C();
        this.R = new ArrayList<>();
        this.T = new a();
        this.I = false;
        this.C = MobileQQ.sMobileQQ.peekAppRuntime();
    }

    private int Ah(Resources resources) {
        if (resources != null) {
            return resources.getDisplayMetrics().heightPixels;
        }
        return ViewUtils.getScreenHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ih(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Qh();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Jh(View view, boolean z16) {
        Uh(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Kh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Th();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Lh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Ph();
        dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Mh(DialogInterface dialogInterface) {
        if (getContext() != null) {
            ((InputMethodManager) getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(this.K.getWindowToken(), 0);
        }
        v.a aVar = this.G;
        if (aVar != null) {
            aVar.L0(AppRuntime.Status.online, 2000);
        }
    }

    private void Nh(int i3) {
        Map<Integer, WeakReference<c>> map = U;
        WeakReference<c> weakReference = map.get(Integer.valueOf(i3));
        if (weakReference == null) {
            return;
        }
        map.remove(Integer.valueOf(i3));
        c cVar = weakReference.get();
        if (cVar == null) {
            return;
        }
        this.F = cVar.f255859a.get();
        this.G = cVar.f255860b.get();
        this.H = cVar.f255861c;
        this.I = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Ph();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$2() {
        int height = this.K.getHeight();
        int Ah = Ah(this.K.getResources()) - ViewUtils.getStatusBarHeight(this.K.getContext());
        if (height <= Ah) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.K.getLayoutParams();
        layoutParams.height = Ah;
        this.K.setLayoutParams(layoutParams);
        NestedScrollView nestedScrollView = this.L;
        if (nestedScrollView != null) {
            ViewGroup.LayoutParams layoutParams2 = nestedScrollView.getLayoutParams();
            if (layoutParams2 instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams2;
                layoutParams3.height = 0;
                layoutParams3.weight = 1.0f;
                this.L.setLayoutParams(layoutParams3);
            }
        }
    }

    void Bh() {
        ImageView imageView = (ImageView) this.K.findViewById(R.id.f626231b);
        this.P = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: mc2.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DIYStatusDialogFragment.this.Ih(view);
            }
        });
    }

    void Ch(String str, int i3) {
        String xh5;
        if (getContext() == null) {
            return;
        }
        EditText editText = (EditText) this.K.findViewById(R.id.f626131a);
        this.N = editText;
        if (xh(this.R, i3).equals("")) {
            xh5 = getContext().getResources().getString(R.string.zsg);
        } else {
            xh5 = xh(this.R, i3);
        }
        editText.setHint(xh5);
        if (!TextUtils.isEmpty(str)) {
            this.N.setText(str);
        }
        this.N.addTextChangedListener(this.T);
        this.N.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: mc2.g
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z16) {
                DIYStatusDialogFragment.this.Jh(view, z16);
            }
        });
        this.N.setHintTextColor(getContext().getResources().getColor(R.color.qui_common_text_secondary));
        this.N.setTextColor(getContext().getResources().getColor(R.color.qui_common_text_primary));
    }

    void Dh() {
        this.R = this.E.p();
    }

    void Eh() {
        this.L = (NestedScrollView) this.K.findViewById(R.id.f626531e);
    }

    void Fh(int i3) {
        int i16;
        this.Q = (LinearLayout) this.K.findViewById(R.id.f626431d);
        int size = this.R.size() / 6;
        if (this.R.size() % 6 != 0) {
            i16 = 1;
        } else {
            i16 = 0;
        }
        int i17 = size + i16;
        int i18 = i3 / 6;
        int i19 = i3 % 6;
        for (int i26 = 0; i26 < i17; i26++) {
            View zh5 = zh(i26, i19, i18);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
            marginLayoutParams.setMargins(0, 0, 0, ViewUtils.dpToPx(16.0f));
            zh5.setLayoutParams(marginLayoutParams);
            this.Q.addView(zh5);
        }
    }

    void Gh(int i3) {
        ImageView imageView = (ImageView) this.K.findViewById(R.id.f626331c);
        this.M = imageView;
        imageView.setImageDrawable(yh(this.R, i3));
    }

    void Hh(int i3) {
        if (getContext() == null) {
            return;
        }
        this.S = (Button) this.K.findViewById(R.id.f626631f);
        if (!xh(this.R, i3).equals("")) {
            this.N.setHint(xh(this.R, i3));
            this.S.setEnabled(true);
        }
        this.S.setOnClickListener(new View.OnClickListener() { // from class: mc2.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DIYStatusDialogFragment.this.Kh(view);
            }
        });
    }

    public void Oh(AppRuntime appRuntime) {
        this.C = appRuntime;
    }

    void Ph() {
        if (getContext() != null) {
            ((InputMethodManager) getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(this.N.getWindowToken(), 0);
            this.N.clearFocus();
        }
    }

    void Qh() {
        this.N.setText("");
        this.N.setCursorVisible(true);
        this.N.setHint("");
        this.N.requestFocus();
        this.P.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Rh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (getContext() != null) {
            int intValue = ((Integer) view.getTag()).intValue();
            this.M.setImageDrawable(yh(this.R, intValue));
            this.J.setBackgroundColor(0);
            if (AppSetting.f99565y) {
                AccessibilityUtil.C(this.J, false);
            }
            this.N.setText("");
            this.N.clearFocus();
            this.P.setVisibility(0);
            if (!xh(this.R, intValue).equals("")) {
                this.N.setHint(xh(this.R, intValue));
                this.S.setEnabled(true);
            }
            view.setBackgroundResource(R.drawable.k5s);
            LinearLayout linearLayout = (LinearLayout) view;
            this.J = linearLayout;
            if (AppSetting.f99565y) {
                AccessibilityUtil.C(linearLayout, true);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void Sh(d dVar) {
        this.F = dVar;
    }

    void Th() {
        String desc;
        DiyStatusEmoInfo diyStatusEmoInfo = this.R.get(((Integer) this.J.getTag()).intValue());
        if (!TextUtils.isEmpty(this.N.getText().toString())) {
            desc = this.N.getText().toString().trim();
        } else if (!TextUtils.isEmpty(this.N.getHint().toString()) && !TextUtils.isEmpty(diyStatusEmoInfo.getDesc())) {
            desc = diyStatusEmoInfo.getDesc();
        } else {
            QQToast.makeText(getContext(), "\u5185\u5bb9\u4e0d\u80fd\u4e3a\u7a7a\uff01", 0).show(100).show();
            return;
        }
        DiyStatusEmoInfo diyStatusEmoInfo2 = new DiyStatusEmoInfo(diyStatusEmoInfo.getType(), diyStatusEmoInfo.getId(), desc.trim());
        if (this.I) {
            z.h(this.H);
        }
        z.g(diyStatusEmoInfo.getType(), (int) diyStatusEmoInfo.getId(), desc.trim());
        d dVar = this.F;
        if (dVar != null) {
            dVar.a(diyStatusEmoInfo2);
        }
        dismiss();
    }

    void Uh(boolean z16) {
        int i3;
        if (getContext() == null) {
            return;
        }
        ImageView imageView = this.P;
        if (z16) {
            i3 = 4;
        } else {
            i3 = 0;
        }
        imageView.setVisibility(i3);
        if (z16) {
            this.N.setHint("");
            ((InputMethodManager) getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).showSoftInput(this.N, 0);
            return;
        }
        if (this.N.getText().toString().isEmpty()) {
            String xh5 = xh(this.R, ((Integer) this.J.getTag()).intValue());
            if (TextUtils.isEmpty(xh5)) {
                xh5 = getContext().getResources().getString(R.string.zsg);
            }
            this.N.setHint(xh5);
        } else {
            this.P.setVisibility(4);
        }
        this.S.setEnabled(!this.N.getText().toString().isEmpty());
        Ph();
    }

    void initView() {
        String str = "";
        AppRuntime.Status onlineStatus = ((IOnlineStatusService) this.C.getRuntimeService(IOnlineStatusService.class, "")).getOnlineStatus();
        long M = af.C().M(this.C);
        int i3 = 0;
        if (onlineStatus == AppRuntime.Status.online && M == 2000) {
            au I = af.C().I(onlineStatus, M);
            com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c H = bs.H("DIYStatusDialogFragment");
            if (H != null) {
                str = af.C().y(H, I.f255490c);
                int i16 = 0;
                while (true) {
                    if (i16 >= this.R.size()) {
                        break;
                    }
                    DiyStatusEmoInfo diyStatusEmoInfo = this.R.get(i16);
                    if (diyStatusEmoInfo.getId() == H.w() && diyStatusEmoInfo.getType() == H.x()) {
                        i3 = i16;
                        break;
                    }
                    i16++;
                }
            }
        }
        Gh(i3);
        Ch(str, i3);
        Bh();
        Eh();
        Fh(i3);
        Hh(i3);
        this.K.findViewById(R.id.f626731g).setOnClickListener(new View.OnClickListener() { // from class: mc2.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DIYStatusDialogFragment.this.lambda$initView$0(view);
            }
        });
        if (AppSetting.f99565y) {
            ImageView imageView = (ImageView) this.K.findViewById(R.id.f626831h);
            AccessibilityUtil.p(imageView, HardCodeUtil.qqStr(R.string.f172422qe));
            imageView.setOnClickListener(new View.OnClickListener() { // from class: mc2.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DIYStatusDialogFragment.this.Lh(view);
                }
            });
        }
        this.K.post(new Runnable() { // from class: mc2.d
            @Override // java.lang.Runnable
            public final void run() {
                DIYStatusDialogFragment.this.lambda$initView$2();
            }
        });
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            Nh(bundle.getInt("cache_state", -1));
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) super.onCreateDialog(bundle);
        aVar.getBehavior().setState(3);
        aVar.getBehavior().setSkipCollapsed(true);
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = null;
        if (getContext() != null) {
            View inflate = layoutInflater.inflate(R.layout.f168880h50, viewGroup);
            this.K = inflate;
            inflate.setBackground(getContext().getResources().getDrawable(R.drawable.b4k));
            Dh();
            if (this.R == null) {
                QQToast.makeText(getContext(), "\u7f51\u7edc\u8fde\u63a5\u5931\u8d25", 0).show(100).show();
                v.a aVar = this.G;
                if (aVar != null) {
                    aVar.L0(AppRuntime.Status.online, 2000);
                }
                dismiss();
            } else {
                initView();
                if (this.I) {
                    z.f(this.H);
                }
                view = this.K;
            }
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
        return false;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ((ViewGroup) this.K.getParent()).setBackgroundColor(0);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        int hashCode = hashCode();
        U.put(Integer.valueOf(hashCode), new WeakReference<>(new c(this.F, this.G, this.H)));
        bundle.putInt("cache_state", hashCode);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) getDialog();
        if (aVar == null) {
            return;
        }
        aVar.setOnKeyListener(this);
        aVar.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: mc2.a
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                DIYStatusDialogFragment.this.Mh(dialogInterface);
            }
        });
        BottomSheetBehavior<FrameLayout> behavior = aVar.getBehavior();
        this.D = behavior;
        behavior.setState(3);
        this.D.setPeekHeight(0);
        this.D.addBottomSheetCallback(new b());
    }

    LinearLayout wh(int i3) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewUtils.dpToPx(43.0f), ViewUtils.dpToPx(43.0f));
        int dpToPx = ((getContext().getResources().getDisplayMetrics().widthPixels - ViewUtils.dpToPx(32.0f)) - (ViewUtils.dpToPx(43.0f) * 6)) / 5;
        if (i3 == 5) {
            dpToPx = 0;
        }
        layoutParams.setMargins(0, 0, dpToPx, 0);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(0);
        return linearLayout;
    }

    String xh(ArrayList<DiyStatusEmoInfo> arrayList, int i3) {
        if (arrayList != null && !arrayList.isEmpty() && arrayList.size() > i3) {
            return arrayList.get(i3).getDesc();
        }
        return "";
    }

    Drawable yh(ArrayList<DiyStatusEmoInfo> arrayList, int i3) {
        if (arrayList.isEmpty() || i3 >= arrayList.size()) {
            return null;
        }
        DiyStatusEmoInfo diyStatusEmoInfo = arrayList.get(i3);
        int type = diyStatusEmoInfo.getType();
        QQSysAndEmojiResInfo resImpl = QQSysAndEmojiResMgr.getInstance().getResImpl(type);
        int localId = resImpl.getLocalId((int) diyStatusEmoInfo.getId());
        if (localId < 0 && type == 1) {
            return null;
        }
        return resImpl.getDrawable(localId);
    }

    LinearLayout zh(int i3, int i16, int i17) {
        int i18;
        boolean z16;
        LinearLayout linearLayout = new LinearLayout(getContext());
        if (getContext() == null) {
            return linearLayout;
        }
        for (int i19 = 0; i19 < 6 && (i18 = (i3 * 6) + i19) < this.R.size(); i19++) {
            LinearLayout wh5 = wh(i19);
            ImageView imageView = new ImageView(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewUtils.dpToPx(35.0f), ViewUtils.dpToPx(35.0f));
            layoutParams.setMargins(ViewUtils.dpToPx(4.0f), ViewUtils.dpToPx(4.0f), ViewUtils.dpToPx(4.0f), ViewUtils.dpToPx(4.0f));
            imageView.setLayoutParams(layoutParams);
            imageView.setImageDrawable(yh(this.R, i18));
            wh5.addView(imageView);
            wh5.setTag(Integer.valueOf(i18));
            wh5.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.onlinestatus.diy.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DIYStatusDialogFragment.this.Rh(view);
                }
            });
            if (i19 == i16 && i3 == i17) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                wh5.setBackgroundResource(R.drawable.k5s);
                this.J = wh5;
            }
            if (AppSetting.f99565y) {
                CharSequence xh5 = xh(this.R, i18);
                wh5.setContentDescription(xh5);
                AccessibilityUtil.x(wh5, xh5, z16, Button.class.getName());
            }
            linearLayout.addView(wh5);
        }
        return linearLayout;
    }

    public DIYStatusDialogFragment(v.a aVar, int i3) {
        this.E = af.C();
        this.R = new ArrayList<>();
        this.T = new a();
        this.G = aVar;
        this.H = i3;
        this.C = MobileQQ.sMobileQQ.waitAppRuntime(null);
        this.I = true;
        z.e(i3);
    }
}
