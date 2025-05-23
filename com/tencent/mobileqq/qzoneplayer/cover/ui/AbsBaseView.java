package com.tencent.mobileqq.qzoneplayer.cover.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.qzoneplayer.cover.data.VideoData;
import com.tencent.mobileqq.qzoneplayer.video.Recycleable;

/* compiled from: P */
/* loaded from: classes35.dex */
public abstract class AbsBaseView extends View implements Recycleable {

    /* renamed from: d, reason: collision with root package name */
    protected VideoData f279331d;

    public AbsBaseView(Context context) {
        this(context, null);
    }

    protected abstract void a();

    public final void b() {
        a();
    }

    public AbsBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void setData(VideoData videoData) {
        if (videoData != null) {
            this.f279331d = videoData;
            b();
        }
    }
}
