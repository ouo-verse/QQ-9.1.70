package com.tencent.sqshow.zootopia.avatar.loading;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.sqshow.zootopia.scene.component.c;
import com.tencent.sqshow.zootopia.scene.component.d;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0018\u0019J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH&J\n\u0010\r\u001a\u0004\u0018\u00010\fH&J\b\u0010\u000e\u001a\u00020\fH&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH&J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0016H&\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/sqshow/zootopia/avatar/loading/ISceneLoadingView;", "Lcom/tencent/sqshow/zootopia/scene/component/d;", "Lc84/a;", "", "pauseAnim", "resumeAnim", "destroy", "Landroid/view/ViewGroup;", "getView", "Lcom/tencent/sqshow/zootopia/avatar/loading/ISceneLoadingView$b;", "listener", "setCloseListener", "Landroid/view/View;", "getCloseIcon", HippyTKDListViewAdapter.X, "", "targetState", "setSwitchState", "Landroid/animation/ObjectAnimator;", "p", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "o", "b", "StyleMode", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public interface ISceneLoadingView extends d, c84.a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/sqshow/zootopia/avatar/loading/ISceneLoadingView$StyleMode;", "", "Companion", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes34.dex */
    public @interface StyleMode {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.f370020a;
        public static final int FULL_STYLE_WITHOUT_TITLE = 3;
        public static final int FULL_STYLE_WITH_HIPPY_PANEL = 6;
        public static final int FULL_STYLE_WITH_PANEL = 5;
        public static final int FULL_STYLE_WITH_TAB = 4;
        public static final int FULL_STYLE_WITH_TITLE = 2;
        public static final int SMALL_STYLE = 1;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/sqshow/zootopia/avatar/loading/ISceneLoadingView$StyleMode$a;", "", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.sqshow.zootopia.avatar.loading.ISceneLoadingView$StyleMode$a, reason: from kotlin metadata */
        /* loaded from: classes34.dex */
        public static final class Companion {

            /* renamed from: a, reason: collision with root package name */
            static final /* synthetic */ Companion f370020a = new Companion();

            Companion() {
            }
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public static final class a {
        public static boolean a(ISceneLoadingView iSceneLoadingView, c originHandler) {
            Intrinsics.checkNotNullParameter(originHandler, "originHandler");
            return d.a.a(iSceneLoadingView, originHandler);
        }

        public static void b(ISceneLoadingView iSceneLoadingView) {
            d.a.b(iSceneLoadingView);
        }

        public static boolean c(ISceneLoadingView iSceneLoadingView) {
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/sqshow/zootopia/avatar/loading/ISceneLoadingView$b;", "", "Landroid/view/View;", "view", "", "onCloseClick", "", "time", "K2", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public interface b {
        void K2(View view, long time);

        void onCloseClick(View view);
    }

    void destroy();

    View getCloseIcon();

    ViewGroup getView();

    long o();

    ObjectAnimator p();

    void pauseAnim();

    void resumeAnim();

    void setCloseListener(b listener);

    void setSwitchState(int targetState);

    View x();

    boolean z();
}
