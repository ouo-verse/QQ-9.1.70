package com.tencent.aelight.camera.aioeditor.docenhance;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.gyailib.library.GYAIDocEnhance;
import com.tencent.aelight.camera.ae.report.b;
import com.tencent.aelight.camera.aebase.fragment.AEFullScreenPublicFragment;
import com.tencent.aelight.camera.aioeditor.docenhance.widget.EdgeAdjustView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivityForMultiProcess;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes32.dex */
public class DocEnhanceAdjustFragment extends AEFullScreenPublicFragment implements View.OnClickListener {
    private TextView C;
    private TextView D;
    private EdgeAdjustView E;
    private Bitmap F;
    private float[] G;
    private GYAIDocEnhance H = new GYAIDocEnhance();
    float[] I = new float[8];

    public static void sh(Activity activity, int i3, String str, float[] fArr) {
        Intent intent = new Intent();
        intent.putExtra("ARG_RAW_PIC_PATH", str);
        intent.putExtra("ARG_ADJUST_POINTS_ARRAY", fArr);
        QPublicFragmentActivityForMultiProcess.startForResult(activity, intent, (Class<? extends QPublicBaseFragment>) DocEnhanceAdjustFragment.class, i3);
    }

    private void th() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Intent intent = new Intent();
            intent.putExtra("RESULT_ADJUST_POINTS_ARRAY", this.E.d());
            activity.setResult(-1, intent);
            activity.finish();
        }
    }

    @Override // com.tencent.aelight.camera.aebase.fragment.AEFullScreenPublicFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        super.initWindowStyleAndAnimation(activity);
        activity.overridePendingTransition(R.anim.f154454a3, R.anim.f154442w);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.s39) {
            onBackEvent();
            b.b().m0("\u53d6\u6d88");
        } else if (id5 == R.id.s3n) {
            th();
            b.b().m0("\u5b8c\u6210");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("ARG_RAW_PIC_PATH");
            if (!TextUtils.isEmpty(string)) {
                this.F = BitmapFactory.decodeFile(string);
            }
            float[] floatArray = arguments.getFloatArray("ARG_ADJUST_POINTS_ARRAY");
            if (floatArray != null && floatArray.length == 8) {
                this.G = Arrays.copyOf(floatArray, 8);
            } else {
                this.G = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Bitmap bitmap = this.F;
        if (bitmap != null) {
            bitmap.recycle();
            this.F = null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements EdgeAdjustView.a {
        a() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.docenhance.widget.EdgeAdjustView.a
        public boolean b(float[] fArr) {
            if (DocEnhanceAdjustFragment.this.F == null || fArr == null || fArr.length != 8) {
                return false;
            }
            for (int i3 = 0; i3 < 4; i3++) {
                int i16 = i3 * 2;
                DocEnhanceAdjustFragment.this.I[i16] = r2.F.getWidth() * fArr[i16];
                int i17 = i16 + 1;
                DocEnhanceAdjustFragment.this.I[i17] = r2.F.getHeight() * fArr[i17];
            }
            return DocEnhanceAdjustFragment.this.H.documentCornerValid(DocEnhanceAdjustFragment.this.I) == 0;
        }

        @Override // com.tencent.aelight.camera.aioeditor.docenhance.widget.EdgeAdjustView.a
        public void c(boolean z16) {
            DocEnhanceAdjustFragment.this.D.setEnabled(z16);
        }

        @Override // com.tencent.aelight.camera.aioeditor.docenhance.widget.EdgeAdjustView.a
        public void a(boolean z16) {
            if (z16) {
                return;
            }
            QQToast.makeText(DocEnhanceAdjustFragment.this.getContext(), R.string.y2w, 0).show();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.C = (TextView) view.findViewById(R.id.s39);
        this.D = (TextView) view.findViewById(R.id.s3n);
        this.E = (EdgeAdjustView) view.findViewById(R.id.rs5);
        this.C.setOnClickListener(this);
        this.D.setOnClickListener(this);
        this.E.setBitmap(this.F);
        this.E.setAdjustPoints(this.G);
        this.E.setInteractionListener(new a());
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.dnk, viewGroup, false);
    }
}
