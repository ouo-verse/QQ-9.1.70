package com.tencent.qqnt.richui.view;

import android.content.Context;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.RoundRectImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0014R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\r\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/richui/view/RichImageView;", "Lcom/tencent/widget/RoundRectImageView;", "", "ratio", "lpWidth", "lpHeight", "", "setRatio", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "d", UserInfo.SEX_FEMALE, "e", "f", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", h.F, "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class RichImageView extends RoundRectImageView {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float ratio;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float lpWidth;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float lpHeight;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RichImageView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        if ((r0 == -1.0f) != false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003d, code lost:
    
        if ((r4 == -1.0f) != false) goto L23;
     */
    @Override // android.widget.ImageView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (!(this.ratio == 0.0f)) {
            float f16 = this.lpWidth;
            if (f16 <= 0.0f) {
            }
            if (this.lpHeight <= 0.0f) {
                int size = View.MeasureSpec.getSize(widthMeasureSpec);
                setMeasuredDimension(size, (int) (size / this.ratio));
                return;
            }
            float f17 = this.lpHeight;
            if (f17 <= 0.0f) {
            }
            if (f16 <= 0.0f) {
                int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
                setMeasuredDimension((int) (this.ratio * size2), size2);
                return;
            }
            QLog.e("RichImageView", 1, "[onMeasure]: wrong param, lpWidth=" + f16 + ", lpHeight=" + f17);
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public final void setRatio(float ratio, float lpWidth, float lpHeight) {
        this.ratio = ratio;
        this.lpWidth = lpWidth;
        this.lpHeight = lpHeight;
    }
}
