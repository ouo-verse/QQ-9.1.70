package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.app.face.FaceConstant;

/* loaded from: classes20.dex */
public class MicroPhoneClipImageView extends ImageView {

    /* renamed from: h, reason: collision with root package name */
    public static final int[] f315849h = {3658, 4390, 5182, 6036, 6829, 7621, 8536, FaceConstant.HeadDownload.RESULT_CODE_QQHEAD_DOWNLOAD_PIC_HTTP_RESPONSE_FAIL};

    /* renamed from: d, reason: collision with root package name */
    private int[] f315850d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f315851e;

    /* renamed from: f, reason: collision with root package name */
    private ClipDrawable f315852f;

    public MicroPhoneClipImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f315850d = null;
        b();
    }

    private int a(int i3) {
        int[] iArr = f315849h;
        int length = iArr.length - 2;
        if (this.f315850d == null) {
            this.f315850d = new int[iArr.length];
            int i16 = 0;
            while (i16 < length) {
                int i17 = i16 + 1;
                this.f315850d[i17] = 8000 - ((7900 * (length - i16)) / length);
                i16 = i17;
            }
            int[] iArr2 = this.f315850d;
            iArr2[0] = 0;
            iArr2[iArr2.length - 1] = 8000;
        }
        int length2 = this.f315850d.length;
        while (true) {
            length2--;
            if (length2 >= 0) {
                if (i3 >= this.f315850d[length2]) {
                    break;
                }
            } else {
                length2 = -1;
                break;
            }
        }
        if (length2 == -1) {
            return 0;
        }
        return length2;
    }

    private void b() {
        this.f315852f = (ClipDrawable) getDrawable();
    }

    public void setRecordState(boolean z16) {
        this.f315851e = z16;
    }

    public void setSoundWave(int i3) {
        if (this.f315851e) {
            this.f315852f.setLevel(f315849h[a(i3)]);
        } else {
            this.f315852f.setLevel(0);
        }
    }

    public MicroPhoneClipImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f315850d = null;
        b();
    }

    public MicroPhoneClipImageView(Context context) {
        super(context);
        this.f315850d = null;
        b();
    }
}
