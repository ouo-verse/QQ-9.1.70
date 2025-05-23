package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes20.dex */
public class PAVideoView extends BubbleVideoView {
    public static int P0;
    public static int Q0;
    public static int R0;
    public static com.tencent.mobileqq.drawable.b S0 = new com.tencent.mobileqq.drawable.b(-2236446, 100, 100);
    public boolean A0;
    private Shader B0;
    public int C0;
    public int D0;
    public String E0;
    public String F0;
    public long G0;
    public String H0;
    public int I0;
    public int J0;
    public String K0;
    public String L0;
    public String M0;
    public StructMsgItemVideo.e N0;
    public StructMsgItemVideo O0;

    /* renamed from: v0, reason: collision with root package name */
    private boolean f315944v0;

    /* renamed from: w0, reason: collision with root package name */
    public int f315945w0;

    /* renamed from: x0, reason: collision with root package name */
    public int f315946x0;

    /* renamed from: y0, reason: collision with root package name */
    private float[] f315947y0;

    /* renamed from: z0, reason: collision with root package name */
    public boolean f315948z0;

    static {
        int i3 = 0 + 1;
        Q0 = i3;
        R0 = i3 + 1;
    }

    public PAVideoView(Context context) {
        super(context);
        this.f315945w0 = (int) (Math.random() * 1000.0d);
        int i3 = P0;
        this.f315946x0 = i3;
        int i16 = R0;
        float[] fArr = new float[i16 + 1];
        this.f315947y0 = fArr;
        this.f315948z0 = false;
        this.A0 = false;
        this.K0 = "";
        fArr[i3] = 1.777f;
        fArr[Q0] = 0.83f;
        fArr[i16] = 1.0f;
    }

    @Override // com.tencent.mobileqq.widget.BubbleImageView
    public Shader i() {
        return this.B0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.BubbleImageView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.aio.item.ChatThumbView, android.widget.ImageView, android.view.View
    public void onMeasure(int i3, int i16) {
        int c16;
        int i17;
        if (this.A0) {
            int size = (View.MeasureSpec.getSize(i3) - getPaddingLeft()) - getPaddingRight();
            float[] fArr = this.f315947y0;
            int i18 = this.f315946x0;
            float f16 = fArr[i18];
            if (this.f315948z0) {
                if (i18 == P0) {
                    i17 = BaseChatItemLayout.M - BaseChatItemLayout.c();
                    c16 = (int) ((i17 / f16) + 0.5f);
                } else {
                    c16 = BaseChatItemLayout.M - BaseChatItemLayout.c();
                    i17 = (int) ((c16 * f16) + 0.5f);
                }
                i3 = View.MeasureSpec.makeMeasureSpec(i17, 1073741824);
                i16 = View.MeasureSpec.makeMeasureSpec(c16, 1073741824);
            } else {
                i16 = View.MeasureSpec.makeMeasureSpec((int) ((size / f16) + 0.5f), 1073741824);
            }
        }
        super.onMeasure(i3, i16);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        if (this.B0 == null) {
            int f16 = BaseAIOUtils.f(55.0f, getResources());
            if (this.f315948z0) {
                int i19 = this.f315946x0;
                if (i19 == P0) {
                    f16 = BaseAIOUtils.f(55.0f, getResources());
                } else if (i19 == Q0) {
                    f16 = BaseAIOUtils.f(75.0f, getResources());
                }
            } else {
                f16 = (int) (i16 * 0.6f);
            }
            this.B0 = new LinearGradient(0.0f, i16 - f16, 0.0f, i16, new int[]{0, -1728053248}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        }
    }

    public void p(StructMsgItemVideo structMsgItemVideo, StructMsgItemVideo.e eVar) {
        long j3;
        this.C0 = structMsgItemVideo.f290487b1;
        this.D0 = structMsgItemVideo.f290488c1;
        this.E0 = structMsgItemVideo.R0;
        this.F0 = structMsgItemVideo.W0;
        AbsStructMsg absStructMsg = structMsgItemVideo.P0;
        MessageRecord messageRecord = absStructMsg.message;
        if (messageRecord == null) {
            j3 = 0;
        } else {
            j3 = messageRecord.uniseq;
        }
        this.G0 = j3;
        this.I0 = absStructMsg.uinType;
        this.H0 = absStructMsg.uin;
        this.J0 = structMsgItemVideo.f290495j1;
        this.L0 = structMsgItemVideo.f290492g1;
        if (absStructMsg instanceof AbsShareMsg) {
            this.M0 = ((AbsShareMsg) absStructMsg).mSourceName;
        }
        this.O0 = structMsgItemVideo;
        this.K0 = structMsgItemVideo.S0;
        this.N0 = eVar;
    }

    public Drawable q(String str) {
        com.tencent.mobileqq.drawable.b bVar = S0;
        if (!TextUtils.isEmpty(str)) {
            try {
                com.tencent.mobileqq.drawable.b bVar2 = S0;
                return URLDrawable.getDrawable(str, bVar2, bVar2);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("PAVideoView" + this.f315945w0, 2, "getCoverDrawable():  getDrawable Exception, mCoverUrl=" + this.E0, e16);
                }
                return S0;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.e("PAVideoView" + this.f315945w0, 2, "getCoverDrawable():  mCoverUrl=" + this.E0);
            return bVar;
        }
        return bVar;
    }

    public void r() {
        this.N0.f290524d.setVisibility(0);
        setImageDrawable(q(this.E0));
        if (QLog.isColorLevel()) {
            QLog.d("PAVideoView" + this.f315945w0, 2, "showCover():  mVid=" + this.F0);
        }
    }

    @Override // android.view.View
    public void requestLayout() {
        if (!this.f315944v0) {
            super.requestLayout();
        }
    }

    @Override // com.tencent.image.URLImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        this.f315944v0 = true;
        super.setImageDrawable(null);
        super.setImageDrawable(drawable);
        this.f315944v0 = false;
    }

    public void setRatioByMode(int i3, float f16) {
        if (i3 == R0 || i3 == P0 || i3 == Q0) {
            this.f315947y0[i3] = f16;
        }
    }
}
