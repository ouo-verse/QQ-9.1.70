package com.tencent.mobileqq.activity.aio.voicetextpanel.view;

import a61.b;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.utils.RecordParams;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes10.dex */
public abstract class BaseVoicetoTextView extends RelativeLayout {
    public BaseVoicetoTextView(Context context) {
        super(context);
    }

    public abstract void a(AppRuntime appRuntime, b bVar, p pVar, ViewGroup viewGroup, ViewGroup viewGroup2);

    public abstract void b();

    public abstract void c();

    public abstract void d(int i3, int i16, int i17, int i18, boolean z16);

    public abstract void e();

    public abstract boolean f();

    public abstract void setParam(String str, RecordParams.RecorderParam recorderParam, int i3, String str2);

    public BaseVoicetoTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BaseVoicetoTextView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
