package com.tencent.mobileqq.qqexpand.widget.pulltorefresh;

import android.graphics.drawable.Drawable;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b implements a {

    /* renamed from: d, reason: collision with root package name */
    private final HashSet<LoadingLayoutBase> f264245d = new HashSet<>();

    public void a(LoadingLayoutBase loadingLayoutBase) {
        if (loadingLayoutBase != null) {
            this.f264245d.add(loadingLayoutBase);
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.a
    public void setLastUpdatedLabel(CharSequence charSequence) {
        Iterator<LoadingLayoutBase> it = this.f264245d.iterator();
        while (it.hasNext()) {
            it.next().setLastUpdatedLabel(charSequence);
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.a
    public void setLoadingDrawable(Drawable drawable) {
        Iterator<LoadingLayoutBase> it = this.f264245d.iterator();
        while (it.hasNext()) {
            it.next().setLoadingDrawable(drawable);
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.a
    public void setPullLabel(CharSequence charSequence) {
        Iterator<LoadingLayoutBase> it = this.f264245d.iterator();
        while (it.hasNext()) {
            it.next().setPullLabel(charSequence);
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.a
    public void setRefreshResultLabel(CharSequence charSequence) {
        Iterator<LoadingLayoutBase> it = this.f264245d.iterator();
        while (it.hasNext()) {
            it.next().setRefreshResultLabel(charSequence);
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.a
    public void setRefreshingLabel(CharSequence charSequence) {
        Iterator<LoadingLayoutBase> it = this.f264245d.iterator();
        while (it.hasNext()) {
            it.next().setRefreshingLabel(charSequence);
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.a
    public void setReleaseLabel(CharSequence charSequence) {
        Iterator<LoadingLayoutBase> it = this.f264245d.iterator();
        while (it.hasNext()) {
            it.next().setReleaseLabel(charSequence);
        }
    }
}
