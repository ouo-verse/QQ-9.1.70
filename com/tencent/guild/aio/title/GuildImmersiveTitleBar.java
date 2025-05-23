package com.tencent.guild.aio.title;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GuildImmersiveTitleBar extends View {

    /* renamed from: f, reason: collision with root package name */
    public static boolean f112332f = true;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f112333h = true;

    /* renamed from: d, reason: collision with root package name */
    private int f112334d;

    /* renamed from: e, reason: collision with root package name */
    public int f112335e;

    public GuildImmersiveTitleBar(Context context) {
        super(context);
        a(context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001a, code lost:
    
        if (com.tencent.widget.immersive.ImmersiveUtils.isSupporImmersive() == 1) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Context context) {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.d("status", 2, "ImmersiveTitleBar initUI");
        }
        if (f112332f) {
            z16 = true;
        }
        z16 = false;
        f112333h = z16;
        int statusBarHeight = ImmersiveUtils.getStatusBarHeight(context);
        this.f112334d = statusBarHeight;
        if (f112333h) {
            setCustomHeight(statusBarHeight);
        } else {
            setCustomHeight(0);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(this.f112335e, 1073741824));
        setMeasuredDimension(getMeasuredWidth(), this.f112335e);
    }

    public void setBackground(int i3) {
        setBackgroundResource(i3);
    }

    public void setCustomHeight(int i3) {
        this.f112335e = i3;
        requestLayout();
    }

    public GuildImmersiveTitleBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a(context);
    }

    public GuildImmersiveTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }
}
