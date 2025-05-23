package com.tencent.icgame.game.api.live;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import au0.c;
import com.tencent.icgame.game.api.live.BaseGameLiveAudienceView;
import com.tencent.timi.game.api.exception.QQLiveCalledFromWrongThreadException;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class BaseLiveAudienceView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    protected boolean f114878d;

    /* renamed from: e, reason: collision with root package name */
    protected c f114879e;

    public BaseLiveAudienceView(@NonNull Context context) {
        super(context);
        this.f114878d = false;
    }

    private void a() {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            b(new QQLiveCalledFromWrongThreadException("AudienceView Only the original thread that created a view hierarchy can touch its views."));
        }
    }

    public boolean i() {
        return false;
    }

    public abstract void k(boolean z16);

    public abstract void l(Context context, long j3, LiveRoomExtraInfo liveRoomExtraInfo);

    public abstract void m(long j3, boolean z16, boolean z17);

    public abstract void n(long j3, @Nullable String str, LiveRoomExtraInfo liveRoomExtraInfo);

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        a();
        super.requestLayout();
    }

    public void setClosePage(boolean z16) {
        this.f114878d = z16;
    }

    public abstract void setResumeIntent(Intent intent);

    public void setRoomSwitcher(c cVar) {
        this.f114879e = cVar;
    }

    public boolean v() {
        return true;
    }

    public BaseLiveAudienceView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f114878d = false;
    }

    public BaseLiveAudienceView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f114878d = false;
    }

    public void j() {
    }

    public void o() {
    }

    public void p() {
    }

    public void q() {
    }

    public void r() {
    }

    public void s() {
    }

    public void t() {
    }

    public void u() {
    }

    protected void b(QQLiveCalledFromWrongThreadException qQLiveCalledFromWrongThreadException) {
        throw qQLiveCalledFromWrongThreadException;
    }

    public void c(LifecycleOwner lifecycleOwner) {
    }

    public void d(LifecycleOwner lifecycleOwner) {
    }

    public void e(LifecycleOwner lifecycleOwner) {
    }

    public void f(LifecycleOwner lifecycleOwner) {
    }

    public void g(LifecycleOwner lifecycleOwner) {
    }

    public void h(LifecycleOwner lifecycleOwner) {
    }

    public void setActivityContext(Context context) {
    }

    public void setLiveViewListener(BaseGameLiveAudienceView.a aVar) {
    }

    public void setParentFragment(Fragment fragment) {
    }
}
