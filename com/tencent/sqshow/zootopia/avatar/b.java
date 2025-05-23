package com.tencent.sqshow.zootopia.avatar;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.sqshow.zootopia.avatar.loading.ISceneLoadingView;
import kotlin.Metadata;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\u0002H&J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH&J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\b\u0010\u0010\u001a\u00020\u000fH&J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0006H&J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0006H&J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000fH&J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H&J\b\u0010\u0018\u001a\u00020\u0002H&J\b\u0010\u0019\u001a\u00020\u0002H&\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/sqshow/zootopia/avatar/b;", "", "", "load", "Landroid/view/View;", "getView", "", "getState", "state", "setState", "g", "Landroid/graphics/Bitmap;", "e", "Lcom/tencent/sqshow/zootopia/avatar/loading/ISceneLoadingView;", "f", "", "isLoadingShowing", "d", "i", "hasFocus", "a", "Lcom/tencent/sqshow/zootopia/avatar/c;", "l", "b", "c", h.F, "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public interface b {
    void a(boolean hasFocus);

    void b(c l3);

    void c();

    void d(int state);

    Bitmap e();

    ISceneLoadingView f();

    void g();

    int getState();

    View getView();

    void h();

    void i(int state);

    boolean isLoadingShowing();

    void load();

    void setState(int state);
}
