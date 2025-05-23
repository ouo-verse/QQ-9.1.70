package com.tencent.timi.game.api.live;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.tencent.timi.game.api.exception.QQLiveCalledFromWrongThreadException;
import nf4.g;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class BaseGameLiveAudienceView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    protected boolean f376290d;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface a {
    }

    public BaseGameLiveAudienceView(@NonNull Context context) {
        super(context);
        this.f376290d = false;
    }

    private void a() {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            b(new QQLiveCalledFromWrongThreadException("AudienceView Only the original thread that created a view hierarchy can touch its views."));
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View, android.view.ViewParent
    public void requestLayout() {
        a();
        super.requestLayout();
    }

    public void setClosePage(boolean z16) {
        this.f376290d = z16;
    }

    public abstract void setResumeIntent(Intent intent);

    public BaseGameLiveAudienceView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f376290d = false;
    }

    public BaseGameLiveAudienceView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f376290d = false;
    }

    protected void b(QQLiveCalledFromWrongThreadException qQLiveCalledFromWrongThreadException) {
        throw qQLiveCalledFromWrongThreadException;
    }

    public void setActivityContext(Context context) {
    }

    public void setLiveViewListener(a aVar) {
    }

    public void setParentFragment(Fragment fragment) {
    }

    public void setParentViewPager(Object obj) {
    }

    public void setRoomSwitcher(g gVar) {
    }
}
