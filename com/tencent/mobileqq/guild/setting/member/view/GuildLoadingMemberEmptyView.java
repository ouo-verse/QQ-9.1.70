package com.tencent.mobileqq.guild.setting.member.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.animator.ScanningLightView;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildLoadingMemberEmptyView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private final Context f234695d;

    /* renamed from: e, reason: collision with root package name */
    private ScanningLightView f234696e;

    public GuildLoadingMemberEmptyView(@NonNull Context context) {
        super(context);
        this.f234695d = context;
        b();
    }

    private void b() {
        this.f234696e = (ScanningLightView) LayoutInflater.from(this.f234695d).inflate(R.layout.emg, this).findViewById(R.id.vsw);
    }

    public void a() {
        setVisibility(4);
    }

    public void c() {
        setVisibility(0);
        this.f234696e.setSkeletonColorRes(R.color.qui_common_fill_standard_primary);
        this.f234696e.setLightColorRes(R.color.qui_common_fill_light_secondary);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (OutOfMemoryError e16) {
            System.gc();
            System.runFinalization();
            QLog.e("Guild.userl.GuildLoadingMemberEmptyView", 2, "onDraw OutOfMemoryError but not Crash: " + e16);
        }
    }

    public GuildLoadingMemberEmptyView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f234695d = context;
        b();
    }

    public GuildLoadingMemberEmptyView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f234695d = context;
        b();
    }
}
