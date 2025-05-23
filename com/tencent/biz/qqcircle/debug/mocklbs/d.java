package com.tencent.biz.qqcircle.debug.mocklbs;

import android.app.Activity;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d extends com.tencent.biz.qqcircle.bizparts.b implements SeekBar.OnSeekBarChangeListener, View.OnClickListener, TextWatcher {
    public static String E = "0.27,0.27,0.26,0.99";
    private static int F = 90;
    private static float G = 20.0f;
    private static float H = 3.0f;
    private static String I = "0.27,0.27,0.26,0.99";
    private EditText C;
    private ImageView D;

    /* renamed from: d, reason: collision with root package name */
    private SeekBar f84327d;

    /* renamed from: e, reason: collision with root package name */
    private EditText f84328e;

    /* renamed from: f, reason: collision with root package name */
    private SeekBar f84329f;

    /* renamed from: h, reason: collision with root package name */
    private EditText f84330h;

    /* renamed from: i, reason: collision with root package name */
    private SeekBar f84331i;

    /* renamed from: m, reason: collision with root package name */
    private EditText f84332m;

    private void D9() {
        this.f84328e.addTextChangedListener(new a());
        this.f84330h.addTextChangedListener(new b());
        this.f84332m.addTextChangedListener(new c());
        this.C.addTextChangedListener(new C0865d());
    }

    private int E9(int i3) {
        return (int) ((i3 / 200.0f) * 100.0f);
    }

    private int F9(float f16) {
        return (int) ((f16 / 10.0f) * 100.0f);
    }

    private int G9(float f16) {
        return (int) ((f16 / 120.0f) * 100.0f);
    }

    private float H9(int i3) {
        return (i3 / 100.0f) * 10.0f;
    }

    private int I9(int i3) {
        return (int) ((i3 / 100.0f) * 200.0f);
    }

    private float J9(int i3) {
        return (i3 / 100.0f) * 120.0f;
    }

    public static Float[] K9() {
        try {
            return Z9(O9("_cubic_bezier_key", I));
        } catch (Throwable unused) {
            return Z9(E);
        }
    }

    public static float L9(String str, float f16) {
        try {
            return Float.valueOf(LocalMultiProcConfig.getString(str, String.valueOf(f16))).floatValue();
        } catch (Throwable th5) {
            QLog.e("QCirclePageScrollSettingsPart", 1, "error: ", th5);
            return f16;
        }
    }

    public static int M9(String str, int i3) {
        return LocalMultiProcConfig.getInt(str, i3);
    }

    public static float N9() {
        return G;
    }

    public static String O9(String str, String str2) {
        try {
            return LocalMultiProcConfig.getString(str, String.valueOf(str2));
        } catch (Throwable th5) {
            QLog.e("QCirclePageScrollSettingsPart", 1, "error: ", th5);
            return str2;
        }
    }

    private void T9(SeekBar seekBar) {
        int progress = seekBar.getProgress();
        int I9 = I9(progress);
        ca("QCirclePageScrollSettingsPart_fling_duration_key", I9);
        ma(I9);
        F = I9;
        QLog.d("QCirclePageScrollSettingsPart", 1, "[handleFlingDurationStopTrackingTouch] flingDurationKey: QCirclePageScrollSettingsPart_fling_duration_key | progress: " + progress + " | duration: " + I9);
    }

    private void W9(SeekBar seekBar) {
        int progress = seekBar.getProgress();
        float ha5 = ha(H9(progress));
        ba("QCirclePageScrollSettingsPart_interpolator_factor_key", ha5);
        oa(ha5);
        H = ha5;
        QLog.d("QCirclePageScrollSettingsPart", 1, "[handleInterpolatorFactorStopTrackingTouch] perInchKey: QCirclePageScrollSettingsPart_interpolator_factor_key | progress: " + progress + " | perInch: " + ha5);
    }

    private void X9(SeekBar seekBar) {
        int progress = seekBar.getProgress();
        float ha5 = ha(J9(progress));
        ba("QCirclePageScrollSettingsPart_per_inch__key", ha5);
        qa(ha5);
        G = ha5;
        QLog.d("QCirclePageScrollSettingsPart", 1, "[handlePerInchStopTrackingTouch] perInchKey: QCirclePageScrollSettingsPart_per_inch__key | progress: " + progress + " | perInch: " + ha5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Y9(SeekBar seekBar, int i3) {
        if (seekBar == null) {
            return;
        }
        seekBar.setProgress(i3);
    }

    @Nullable
    private static Float[] Z9(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] split = str.split(",");
            if (split.length != 4) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (String str2 : split) {
                arrayList.add(Float.valueOf(Float.parseFloat(str2)));
            }
            return (Float[]) arrayList.toArray(new Float[4]);
        } catch (Throwable unused) {
            return null;
        }
    }

    private void aa(final SeekBar seekBar, final int i3) {
        if (seekBar == null || i3 < 0) {
            return;
        }
        seekBar.post(new Runnable() { // from class: com.tencent.biz.qqcircle.debug.mocklbs.c
            @Override // java.lang.Runnable
            public final void run() {
                d.Y9(seekBar, i3);
            }
        });
    }

    private void ba(String str, float f16) {
        LocalMultiProcConfig.putString(str, String.valueOf(f16));
    }

    private void ca(String str, int i3) {
        LocalMultiProcConfig.putInt(str, i3);
    }

    private void da(String str, String str2) {
        LocalMultiProcConfig.putString(str, str2);
    }

    public static void ea(String str) {
        I = str;
    }

    private void finishActivity() {
        BasePartFragment basePartFragment = (BasePartFragment) getHostFragment();
        if (basePartFragment == null) {
            QLog.e("QCirclePageScrollSettingsPart", 1, "[finishActivity] fragment should not be null.");
            return;
        }
        if (basePartFragment.onBackEvent()) {
            QLog.e("QCirclePageScrollSettingsPart", 1, "[finishActivity] current fragment back event success.");
            return;
        }
        Activity activity = getActivity();
        if (activity == null) {
            QLog.e("QCirclePageScrollSettingsPart", 1, "[finishActivity] activity should not be null.");
        } else {
            activity.finish();
        }
    }

    public static void ga(float f16) {
        G = f16;
    }

    private float ha(float f16) {
        return Math.round(f16 * 100.0f) / 100.0f;
    }

    private void ia(String str) {
        la(this.C, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ja(String str) {
        try {
            Float[] Z9 = Z9(str);
            if (Z9 != null && Z9.length == 4) {
                da("_cubic_bezier_key", str);
            }
        } catch (Throwable th5) {
            QLog.e("QCirclePageScrollSettingsPart", 1, "[updateInterpolatorFactorTextChange] error: ", th5);
        }
    }

    private void la(EditText editText, String str) {
        if (editText == null || TextUtils.isEmpty(str)) {
            return;
        }
        editText.setText(str);
    }

    private void ma(int i3) {
        la(this.f84330h, String.valueOf(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void na(CharSequence charSequence) {
        try {
            int E9 = E9(Integer.parseInt(charSequence.toString()));
            if (E9 > 100) {
                E9 = 100;
            } else if (E9 < 0) {
                E9 = 0;
            }
            this.f84329f.setProgress(E9);
            int I9 = I9(E9);
            F = I9;
            ca("QCirclePageScrollSettingsPart_fling_duration_key", I9);
        } catch (Throwable th5) {
            QLog.e("QCirclePageScrollSettingsPart", 1, "[updateFlingDurationTextChange] error: ", th5);
        }
    }

    private void oa(float f16) {
        la(this.f84332m, String.valueOf(f16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pa(CharSequence charSequence) {
        try {
            int F9 = F9(Float.parseFloat(charSequence.toString()));
            if (F9 > 100) {
                F9 = 100;
            } else if (F9 < 0) {
                F9 = 0;
            }
            this.f84331i.setProgress(F9);
            float H9 = H9(F9);
            H = H9;
            ba("QCirclePageScrollSettingsPart_interpolator_factor_key", H9);
        } catch (Throwable th5) {
            QLog.e("QCirclePageScrollSettingsPart", 1, "[updateInterpolatorFactorTextChange] error: ", th5);
        }
    }

    private void qa(float f16) {
        la(this.f84328e, String.valueOf(f16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ra(CharSequence charSequence) {
        try {
            int G9 = G9(Float.parseFloat(charSequence.toString()));
            if (G9 > 100) {
                G9 = 100;
            } else if (G9 < 0) {
                G9 = 0;
            }
            this.f84327d.setProgress(G9);
            float J9 = J9(G9);
            G = J9;
            ba("QCirclePageScrollSettingsPart_per_inch__key", J9);
        } catch (Throwable th5) {
            QLog.e("QCirclePageScrollSettingsPart", 1, "[updatePerInchTextChange] error: ", th5);
        }
    }

    private void sa() {
        int M9 = M9("QCirclePageScrollSettingsPart_fling_duration_key", 90);
        F = M9;
        ma(M9);
        int E9 = E9(M9);
        aa(this.f84329f, E9);
        float L9 = L9("QCirclePageScrollSettingsPart_per_inch__key", 20.0f);
        G = L9;
        qa(L9);
        int G9 = G9(L9);
        aa(this.f84327d, G9);
        float L92 = L9("QCirclePageScrollSettingsPart_interpolator_factor_key", 3.0f);
        H = L92;
        oa(L92);
        aa(this.f84331i, F9(L92));
        String O9 = O9("_cubic_bezier_key", E);
        ia(O9);
        QLog.d("QCirclePageScrollSettingsPart", 1, "[updateSeekBackValue]  durationProgress: " + E9 + " | duration: " + M9 + " | perInchProgress: " + G9 + " | cubicBezierValue: " + O9);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QCirclePageScrollSettingsPart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.y_2) {
            finishActivity();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        ImageView imageView = (ImageView) view.findViewById(R.id.y_2);
        this.D = imageView;
        imageView.setOnClickListener(this);
        this.f84327d = (SeekBar) view.findViewById(R.id.f32650ub);
        this.f84328e = (EditText) view.findViewById(R.id.f32640ua);
        this.f84329f = (SeekBar) view.findViewById(R.id.f32600u7);
        this.f84330h = (EditText) view.findViewById(R.id.f32610u8);
        this.f84331i = (SeekBar) view.findViewById(R.id.f32620u9);
        this.f84332m = (EditText) view.findViewById(R.id.f32630u_);
        this.C = (EditText) view.findViewById(R.id.f32580u5);
        if (Build.VERSION.SDK_INT >= 26) {
            this.f84327d.setMin(0);
            this.f84329f.setMin(0);
            this.f84331i.setMin(0);
        }
        this.f84327d.setMax(100);
        this.f84329f.setMax(100);
        this.f84331i.setMax(100);
        this.f84327d.setOnSeekBarChangeListener(this);
        this.f84329f.setOnSeekBarChangeListener(this);
        this.f84331i.setOnSeekBarChangeListener(this);
        D9();
        sa();
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i3, boolean z16) {
        int id5 = seekBar.getId();
        if (id5 == R.id.f32650ub) {
            P9(seekBar, i3, z16);
        } else if (id5 == R.id.f32600u7) {
            R9(seekBar, i3, z16);
        } else if (id5 == R.id.f32620u9) {
            U9(seekBar, i3, z16);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        int id5 = seekBar.getId();
        if (id5 == R.id.f32650ub) {
            Q9(seekBar);
        } else if (id5 == R.id.f32600u7) {
            S9(seekBar);
        } else if (id5 == R.id.f32620u9) {
            V9(seekBar);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        EventCollector.getInstance().onStopTrackingTouchBefore(seekBar);
        int id5 = seekBar.getId();
        if (id5 == R.id.f32650ub) {
            X9(seekBar);
        } else if (id5 == R.id.f32600u7) {
            T9(seekBar);
        } else if (id5 == R.id.f32620u9) {
            W9(seekBar);
        }
        EventCollector.getInstance().onStopTrackingTouch(seekBar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            d.this.ra(charSequence);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            d.this.na(charSequence);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            d.this.pa(charSequence);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.debug.mocklbs.d$d, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0865d implements TextWatcher {
        C0865d() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            String charSequence2;
            d dVar = d.this;
            if (charSequence == null) {
                charSequence2 = "";
            } else {
                charSequence2 = charSequence.toString();
            }
            dVar.ja(charSequence2);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }

    private void Q9(SeekBar seekBar) {
    }

    private void S9(SeekBar seekBar) {
    }

    private void V9(SeekBar seekBar) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    private void P9(SeekBar seekBar, int i3, boolean z16) {
    }

    private void R9(SeekBar seekBar, int i3, boolean z16) {
    }

    private void U9(SeekBar seekBar, int i3, boolean z16) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
    }
}
