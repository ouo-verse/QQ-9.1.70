package com.tencent.mobileqq.guild.robot.components.setting;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.robot.components.setting.DirectMsgLimitDialogFragment;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.bv;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.InputMethodUtil;
import ox1.i;

/* compiled from: P */
/* loaded from: classes14.dex */
public class DirectMsgLimitDialogFragment extends BottomSheetDialogFragment implements View.OnClickListener, TextWatcher, ViewTreeObserver.OnGlobalLayoutListener {
    private int C = 0;
    private boolean D = false;
    private final cx1.a E;
    private final int F;
    private i G;
    private final String H;
    private final String I;
    private final String J;
    private View K;
    private LinearLayout L;
    private TextView M;
    private TextView N;
    private EditText P;
    private ImageView Q;
    private ImageView R;
    private TextView S;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a extends com.google.android.material.bottomsheet.a {
        a(Context context, int i3) {
            super(context, i3);
        }

        @Override // androidx.appcompat.app.AppCompatDialog, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
        public void dismiss() {
            if (!DirectMsgLimitDialogFragment.this.D) {
                DirectMsgLimitDialogFragment.this.D = true;
                DirectMsgLimitDialogFragment.this.Ch();
                if (DirectMsgLimitDialogFragment.this.F == 1 && DirectMsgLimitDialogFragment.this.E != null) {
                    DirectMsgLimitDialogFragment.this.E.q(DirectMsgLimitDialogFragment.this.G);
                } else if (DirectMsgLimitDialogFragment.this.F == 2) {
                    RobotActiveMsgControlDialogFragment.Gh(DirectMsgLimitDialogFragment.this.getActivity(), DirectMsgLimitDialogFragment.this.G, DirectMsgLimitDialogFragment.this.H, DirectMsgLimitDialogFragment.this.I, DirectMsgLimitDialogFragment.this.J);
                }
            }
            DirectMsgLimitDialogFragment.this.getActivity().getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(DirectMsgLimitDialogFragment.this);
            super.dismiss();
        }
    }

    public DirectMsgLimitDialogFragment(cx1.a aVar, i iVar, String str, String str2, String str3, int i3) {
        this.G = iVar;
        this.H = str;
        this.I = str2;
        this.J = str3;
        this.E = aVar;
        this.F = i3;
    }

    private void Ah(boolean z16) {
        if (z16) {
            this.M.setEnabled(true);
            this.M.setAlpha(1.0f);
        } else {
            this.M.setEnabled(false);
            this.M.setAlpha(0.5f);
        }
    }

    private int Bh() {
        Context context;
        if (getContext() != null) {
            context = getContext();
        } else {
            context = BaseApplication.getContext();
        }
        int a16 = bv.a(context);
        if (a16 <= 0) {
            return QQGuildUIUtil.f(516.0f);
        }
        return (int) (a16 * 0.6f);
    }

    private boolean Dh(String str) {
        if (str == null) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Eh(Long l3) {
        this.P.setText(String.valueOf(l3));
        this.P.setSelection(String.valueOf(l3).length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Fh(cf1.b bVar) {
        SecurityTipHelperKt.D(getContext(), bVar);
    }

    private void Gh() {
        this.P.setText("");
    }

    private void Hh() {
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToast.makeText(getContext(), 1, R.string.f1511016s, 1).show();
            return;
        }
        String trim = this.P.getText().toString().trim();
        if (!Dh(trim)) {
            return;
        }
        long parseLong = Long.parseLong(trim);
        if (parseLong > 0 && parseLong <= 50) {
            this.G.T1().setValue(Long.valueOf(parseLong));
            this.G.e2();
            dismissAllowingStateLoss();
        }
    }

    private void Ih(EditText editText, String str) {
        editText.removeTextChangedListener(this);
        editText.setText(str);
        editText.setSelection(str.length());
        editText.addTextChangedListener(this);
    }

    public static void Jh(FragmentActivity fragmentActivity, cx1.a aVar, i iVar, String str, String str2, String str3, int i3) {
        new DirectMsgLimitDialogFragment(aVar, iVar, str, str2, str3, i3).show(fragmentActivity.getSupportFragmentManager(), "DirectMsgLimitDialogFragment");
    }

    private void Kh(int i3, boolean z16) {
        int i16;
        Resources resources = getResources();
        if (z16) {
            i16 = R.color.f157162bt3;
        } else {
            i16 = R.color.guild_skin_color_a7acb6;
        }
        int color = resources.getColor(i16);
        this.S.setText(i3);
        this.S.setTextColor(color);
        Drawable drawable = getResources().getDrawable(R.drawable.guild_app_info_detail_icon);
        drawable.setColorFilter(color, PorterDuff.Mode.SRC_IN);
        this.R.setImageDrawable(drawable);
    }

    private void initView() {
        LinearLayout linearLayout = (LinearLayout) this.K.findViewById(R.id.bjy);
        this.L = linearLayout;
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        layoutParams.height = Bh();
        this.L.setLayoutParams(layoutParams);
        TextView textView = (TextView) this.K.findViewById(R.id.x2w);
        this.N = textView;
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) this.K.findViewById(R.id.f165642x34);
        this.M = textView2;
        textView2.setOnClickListener(this);
        ((GuildUserAvatarView) this.K.findViewById(R.id.f763141b)).setAvatarTinyId(this.H, this.G.X1());
        ((TextView) this.K.findViewById(R.id.f771043g)).setText(this.J);
        this.R = (ImageView) this.K.findViewById(R.id.fbg);
        this.S = (TextView) this.K.findViewById(R.id.f166441zv4);
        EditText editText = (EditText) this.K.findViewById(R.id.f7660424);
        this.P = editText;
        editText.addTextChangedListener(this);
        ImageView imageView = (ImageView) this.K.findViewById(R.id.wk9);
        this.Q = imageView;
        imageView.setOnClickListener(this);
    }

    private void initViewModel() {
        this.G.T1().observe(getViewLifecycleOwner(), new Observer() { // from class: ox1.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DirectMsgLimitDialogFragment.this.Eh((Long) obj);
            }
        });
        this.G.W1().observe(getViewLifecycleOwner(), new Observer() { // from class: ox1.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DirectMsgLimitDialogFragment.this.Fh((cf1.b) obj);
            }
        });
    }

    private void onBack() {
        dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showKeyboard() {
        this.P.requestFocus();
        InputMethodUtil.show(this.P);
    }

    public void Ch() {
        InputMethodUtil.hide(this.P);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!o.a(view)) {
            int id5 = view.getId();
            if (id5 == R.id.x2w) {
                onBack();
            } else if (id5 == R.id.f165642x34) {
                Hh();
            } else if (id5 == R.id.wk9) {
                Gh();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        a aVar = new a(getContext(), getTheme());
        BottomSheetBehavior<FrameLayout> behavior = aVar.getBehavior();
        behavior.setState(3);
        behavior.addBottomSheetCallback(new b());
        aVar.getWindow().getAttributes().windowAnimations = R.style.a0o;
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.K = layoutInflater.inflate(R.layout.f5_, viewGroup, false);
        initView();
        initViewModel();
        getActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this);
        View view = this.K;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        Rect rect = new Rect();
        this.K.getWindowVisibleDisplayFrame(rect);
        int i3 = rect.bottom - rect.top;
        if (i3 != this.C) {
            int height = this.K.getRootView().getHeight();
            int i16 = height - i3;
            if (i16 > height / 4) {
                ViewGroup.LayoutParams layoutParams = this.L.getLayoutParams();
                layoutParams.height = ViewUtils.dpToPx(200.0f) + i16;
                this.L.setLayoutParams(layoutParams);
            }
            this.C = i3;
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.K.postDelayed(new Runnable() { // from class: ox1.a
            @Override // java.lang.Runnable
            public final void run() {
                DirectMsgLimitDialogFragment.this.showKeyboard();
            }
        }, 100L);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        ((View) this.K.getParent()).setBackgroundColor(0);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        String trim = charSequence.toString().trim();
        if (TextUtils.isEmpty(trim)) {
            Kh(R.string.f153601cj, false);
            Ah(false);
            return;
        }
        if (!Dh(trim)) {
            Kh(R.string.f153771d0, true);
            Ah(false);
            return;
        }
        int parseInt = Integer.parseInt(trim);
        if (parseInt == 0) {
            Kh(R.string.f153771d0, true);
            Ah(false);
        } else if (parseInt > 50) {
            Kh(R.string.f153601cj, true);
            Ah(false);
        } else {
            Kh(R.string.f153601cj, false);
            Ah(true);
            this.P.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2)});
        }
        Ih(this.P, String.valueOf(parseInt));
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class b extends BottomSheetBehavior.e {
        b() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onSlide(@NonNull View view, float f16) {
            DirectMsgLimitDialogFragment.this.Ch();
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onStateChanged(@NonNull View view, int i3) {
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
    }
}
