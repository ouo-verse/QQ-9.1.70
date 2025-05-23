package com.tencent.av.ui.part.mav;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.n;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import nw.b;

/* loaded from: classes32.dex */
public class AVUserNamePart extends Part {

    /* renamed from: i, reason: collision with root package name */
    String f76567i;

    /* renamed from: d, reason: collision with root package name */
    int f76563d = 0;

    /* renamed from: e, reason: collision with root package name */
    private TextView f76564e = null;

    /* renamed from: f, reason: collision with root package name */
    private TextView f76565f = null;

    /* renamed from: h, reason: collision with root package name */
    String f76566h = null;

    /* renamed from: m, reason: collision with root package name */
    Runnable f76568m = null;

    /* loaded from: classes32.dex */
    class RefreshDisplayNameRunnable implements Runnable {
        RefreshDisplayNameRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(AVUserNamePart.this.f76566h)) {
                AVUserNamePart.this.E9();
            } else {
                AVUserNamePart.this.C9(true);
            }
            AVUserNamePart.this.f76564e.setText(AVUserNamePart.this.f76567i);
            AVUserNamePart.this.f76564e.setText((CharSequence) null);
            AVUserNamePart aVUserNamePart = AVUserNamePart.this;
            int i3 = aVUserNamePart.f76563d + 1;
            aVUserNamePart.f76563d = i3;
            if (aVUserNamePart.f76568m != null) {
                if (i3 < 3) {
                    aVUserNamePart.getMainHandler().postDelayed(AVUserNamePart.this.f76568m, 1000L);
                } else {
                    aVUserNamePart.getMainHandler().removeCallbacks(AVUserNamePart.this.f76568m);
                }
            }
        }
    }

    private String D9(String str, int i3, String str2, long j3) {
        if (getContext() != null) {
            str = getContext().getString(R.string.d97);
        }
        if (i3 == 2 && b.b() != null) {
            str2 = A9(str2, b.b().K(i3, String.valueOf(j3)), this.f76565f);
        } else if (i3 != 1) {
            str2 = str;
        }
        this.f76565f.setText(str2);
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E9() {
        SessionInfo f16 = n.e().f();
        String D9 = D9(this.f76567i, f16.S0, this.f76566h, f16.P0);
        this.f76567i = D9;
        this.f76565f.setText(D9);
    }

    public void B9() {
        if (this.f76568m == null || getMainHandler() == null) {
            return;
        }
        getMainHandler().post(this.f76568m);
    }

    public void C9(final boolean z16) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.ui.part.mav.AVUserNamePart.1
            @Override // java.lang.Runnable
            public void run() {
                VideoAppInterface b16 = b.b();
                if (b16 != null) {
                    SessionInfo f16 = n.e().f();
                    AVUserNamePart.this.f76566h = b16.G(f16.f73067q, String.valueOf(f16.P0), null);
                    if (z16) {
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.av.ui.part.mav.AVUserNamePart.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AVUserNamePart.this.E9();
                            }
                        });
                    }
                }
            }
        }, 16, null, true);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f76564e = (TextView) view.findViewById(R.id.g87);
        this.f76565f = (TextView) view.findViewById(R.id.g86);
        if (this.f76568m == null) {
            this.f76568m = new RefreshDisplayNameRunnable();
        }
        getMainHandler().post(this.f76568m);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        getMainHandler().removeCallbacks(this.f76568m);
        this.f76568m = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00af, code lost:
    
        if (r7.length() <= 0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00c0, code lost:
    
        return r7 + "\u2026";
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:?, code lost:
    
        return r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String A9(String str, int i3, TextView textView) {
        if (str == null) {
            if (QLog.isColorLevel()) {
                QLog.d("AVUserNamePart", 2, "genDiscussTitle, name == null");
                return "";
            }
            return "";
        }
        Resources resources = getContext().getResources();
        int f16 = BaseAIOUtils.f(160.0f, resources);
        TextPaint paint = textView.getPaint();
        float measureText = (f16 - paint.measureText(String.format("(%d)", Integer.valueOf(i3)))) - (resources.getDisplayMetrics().density * 4.0f);
        if (measureText <= 0.0f) {
            return str;
        }
        float measureText2 = paint.measureText(str);
        if (measureText2 <= measureText) {
            return str;
        }
        float measureText3 = measureText - paint.measureText("\u2026");
        String str2 = str;
        while (measureText3 > 0.0f && measureText2 > measureText3 && str2.length() > 0) {
            str2 = str2.substring(0, str2.length() - 1);
            measureText2 = paint.measureText(str2);
            if (measureText2 == 0.0f && str2.length() > 0) {
                measureText2 = 1.0f + measureText3;
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("AVUserNamePart", 2, "genDiscussTitle, name widht[" + measureText2 + "]");
            }
        }
        return str;
    }
}
