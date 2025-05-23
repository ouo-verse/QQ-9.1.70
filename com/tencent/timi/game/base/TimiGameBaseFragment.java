package com.tencent.timi.game.base;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup;
import androidx.annotation.StringRes;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.timi.game.base.TimiGameBaseFragment;
import com.tencent.timi.game.base.ui.TimiGamePageLoadingView;
import hi4.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b!\u0010\"J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\bH\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\u0012\u0010\u0014\u001a\u00020\u000f2\b\b\u0001\u0010\u0013\u001a\u00020\bH\u0004R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/timi/game/base/TimiGameBaseFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroid/view/ViewGroup;", "getRootView", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "", "exitSource", "", "qh", "showLoadingView", "loadingTextResId", "sh", "", "loadingText", "th", "hideLoadingView", "resId", "rh", "Lcom/tencent/timi/game/base/ui/TimiGamePageLoadingView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/timi/game/base/ui/TimiGamePageLoadingView;", "mLoadingView", "", "D", "J", "mLoadingDelay", "Ljava/lang/Runnable;", "E", "Ljava/lang/Runnable;", "mShowTask", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public abstract class TimiGameBaseFragment extends QPublicBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private TimiGamePageLoadingView mLoadingView;

    /* renamed from: D, reason: from kotlin metadata */
    private final long mLoadingDelay = 500;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Runnable mShowTask;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uh(TimiGameBaseFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TimiGamePageLoadingView timiGamePageLoadingView = this$0.mLoadingView;
        if (timiGamePageLoadingView != null) {
            timiGamePageLoadingView.d();
        }
    }

    @Nullable
    public abstract ViewGroup getRootView();

    public void hideLoadingView() {
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        Runnable runnable = this.mShowTask;
        Intrinsics.checkNotNull(runnable);
        uIHandlerV2.removeCallbacks(runnable);
        TimiGamePageLoadingView timiGamePageLoadingView = this.mLoadingView;
        if (timiGamePageLoadingView != null) {
            timiGamePageLoadingView.c();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((b) mm4.b.b(b.class)).d3(null);
    }

    public boolean qh(int exitSource) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
            return true;
        }
        return true;
    }

    @NotNull
    protected final String rh(@StringRes int resId) {
        String str;
        Resources resources;
        BaseApplication context = BaseApplication.getContext();
        if (context != null && (resources = context.getResources()) != null) {
            str = resources.getString(resId);
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public void sh(int loadingTextResId) {
        th(rh(loadingTextResId));
    }

    public void showLoadingView() {
        sh(R.string.f23156727);
    }

    public void th(@NotNull String loadingText) {
        boolean z16;
        Context context;
        Intrinsics.checkNotNullParameter(loadingText, "loadingText");
        if (loadingText.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            loadingText = rh(R.string.f23156727);
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            context = activity.getBaseContext();
        } else {
            context = null;
        }
        Context context2 = context;
        if (this.mLoadingView == null && context2 != null) {
            this.mLoadingView = new TimiGamePageLoadingView(context2, null, 0, 6, null);
        }
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        ViewGroup rootView = getRootView();
        if (rootView != null) {
            rootView.removeView(this.mLoadingView);
        }
        ViewGroup rootView2 = getRootView();
        if (rootView2 != null) {
            rootView2.addView(this.mLoadingView, layoutParams);
        }
        TimiGamePageLoadingView timiGamePageLoadingView = this.mLoadingView;
        if (timiGamePageLoadingView != null) {
            timiGamePageLoadingView.setHintText(loadingText);
        }
        Runnable runnable = this.mShowTask;
        if (runnable != null) {
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: vf4.b
            @Override // java.lang.Runnable
            public final void run() {
                TimiGameBaseFragment.uh(TimiGameBaseFragment.this);
            }
        };
        this.mShowTask = runnable2;
        ThreadManagerV2.getUIHandlerV2().postDelayed(runnable2, this.mLoadingDelay);
    }
}
