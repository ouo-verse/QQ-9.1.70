package com.tencent.qqnt.qbasealbum.base.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.compat.RFWThemeUtil;
import com.tencent.biz.richframework.delegate.impl.RFWConfig;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqnt.qbasealbum.inject.g;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import com.tencent.richframework.gallery.RFWLayerFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u001c\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0014J\b\u0010\u0013\u001a\u00020\rH\u0016J\b\u0010\u0014\u001a\u00020\rH\u0016J\b\u0010\u0015\u001a\u00020\rH\u0016J\b\u0010\u0017\u001a\u00020\u0016H&J\b\u0010\u0018\u001a\u00020\rH\u0016J\u0006\u0010\u0019\u001a\u00020\u0006R\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/base/view/QAlbumBaseFragment;", "Lcom/tencent/richframework/gallery/RFWLayerFragment;", "Landroid/view/View;", "view", "Landroidx/core/view/WindowInsetsCompat;", "inset", "", "qh", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "setImmersive", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "isOpenNavigationBarImmersive", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "", "getLogTag", "isUseDarkTextStatusBar", "enableSetStatusBarColor", "needAdjustImmersive", "", "getStatusBarColor", "enableRootViewSetFitsSystemWindows", "setStatusBarTextColor", BdhLogUtil.LogTag.Tag_Conn, "Z", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class QAlbumBaseFragment extends RFWLayerFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isOpenNavigationBarImmersive;

    public QAlbumBaseFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.isOpenNavigationBarImmersive = RFWConfig.getConfigValue("qq_album_immersive_navigation_bar", true);
        }
    }

    private final void qh(View view, WindowInsetsCompat inset) {
        int paddingBottom;
        View findViewById = view.findViewById(R.id.root);
        if (findViewById != null) {
            int paddingLeft = findViewById.getPaddingLeft();
            g gVar = g.f361234b;
            Context context = findViewById.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            int statusBarHeight = gVar.getStatusBarHeight(context);
            int paddingRight = findViewById.getPaddingRight();
            if (RFWNavigationBarImmersiveHelper.INSTANCE.hadSetNavigationBarImmersive(getActivity())) {
                paddingBottom = 0;
            } else if (inset != null) {
                paddingBottom = inset.getSystemWindowInsetBottom();
            } else {
                paddingBottom = findViewById.getPaddingBottom();
            }
            findViewById.setPadding(paddingLeft, statusBarHeight, paddingRight, paddingBottom);
        }
    }

    static /* synthetic */ void rh(QAlbumBaseFragment qAlbumBaseFragment, View view, WindowInsetsCompat windowInsetsCompat, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                windowInsetsCompat = null;
            }
            qAlbumBaseFragment.qh(view, windowInsetsCompat);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: adjustInset");
    }

    private final void setImmersive(View rootView) {
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            if (enableSetStatusBarColor()) {
                RFWThemeUtil.setStatusBarColor(getActivity(), getStatusBarColor());
            }
            if (enableRootViewSetFitsSystemWindows() && rootView != null) {
                rootView.setFitsSystemWindows(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat sh(QAlbumBaseFragment this$0, View v3, WindowInsetsCompat windowInsetsCompat) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(v3, "v");
        this$0.qh(v3, windowInsetsCompat);
        return windowInsetsCompat;
    }

    public boolean enableRootViewSetFitsSystemWindows() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return false;
    }

    public boolean enableSetStatusBarColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    public String getLogTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        String name = getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "javaClass.name");
        return name;
    }

    public abstract int getStatusBarColor();

    @Override // com.tencent.richframework.gallery.RFWLayerFragment
    public boolean isOpenNavigationBarImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.isOpenNavigationBarImmersive;
    }

    public boolean isUseDarkTextStatusBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return !g.f361234b.isNowThemeIsNight();
    }

    public boolean needAdjustImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.onPause();
            com.tencent.qqnt.qbasealbum.a.f360732a.b().e().onPauseReport();
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.onResume();
            com.tencent.qqnt.qbasealbum.a.f360732a.b().e().onResumeReport();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Window window;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        if (this.isOpenNavigationBarImmersive) {
            RFWNavigationBarImmersiveHelper rFWNavigationBarImmersiveHelper = RFWNavigationBarImmersiveHelper.INSTANCE;
            FragmentActivity activity = getActivity();
            if (activity != null) {
                window = activity.getWindow();
            } else {
                window = null;
            }
            rFWNavigationBarImmersiveHelper.setNavigationBarImmersive(window);
        }
        super.onViewCreated(view, savedInstanceState);
        if (needAdjustImmersive()) {
            setImmersive(view);
            setStatusBarTextColor();
        }
        if (!RFWNavigationBarImmersiveHelper.INSTANCE.hadSetNavigationBarImmersive(getActivity())) {
            ViewCompat.setOnApplyWindowInsetsListener(view, new OnApplyWindowInsetsListener() { // from class: com.tencent.qqnt.qbasealbum.base.view.a
                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public final WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                    WindowInsetsCompat sh5;
                    sh5 = QAlbumBaseFragment.sh(QAlbumBaseFragment.this, view2, windowInsetsCompat);
                    return sh5;
                }
            });
        }
        if (g.f361234b.o() && needAdjustImmersive()) {
            rh(this, view, null, 2, null);
        }
    }

    public final void setStatusBarTextColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else if (ImmersiveUtils.isSupporImmersive() == 1 && getActivity() != null) {
            ImmersiveUtils.setStatusTextColor(isUseDarkTextStatusBar(), requireActivity().getWindow());
        }
    }
}
