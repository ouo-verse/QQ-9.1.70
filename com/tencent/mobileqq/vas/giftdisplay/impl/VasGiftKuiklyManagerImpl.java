package com.tencent.mobileqq.vas.giftdisplay.impl;

import android.R;
import android.app.Activity;
import android.util.ArrayMap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasKuiklyApi;
import com.tencent.mobileqq.vas.api.IVasKuiklyNestPageFrame;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.giftdisplay.IVasGiftKuiklyManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/vas/giftdisplay/impl/VasGiftKuiklyManagerImpl;", "Lcom/tencent/mobileqq/vas/giftdisplay/IVasGiftKuiklyManager;", "Landroid/app/Activity;", "getActivity", "", "args", "", "initContentView", "Landroid/view/ViewGroup;", AIInput.KEY_FRAME, "bindKuiklyViewToContainer", "", "ifUseKuikly", "startPlay", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/vas/api/IVasKuiklyNestPageFrame$b;", "mBindLogic", "Lcom/tencent/mobileqq/vas/api/IVasKuiklyNestPageFrame$b;", "Ljava/lang/ref/WeakReference;", "Landroid/widget/FrameLayout;", "mWeakParentLayout", "Ljava/lang/ref/WeakReference;", "mCotentLayout", "Landroid/widget/FrameLayout;", "<init>", "()V", "Companion", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasGiftKuiklyManagerImpl implements IVasGiftKuiklyManager {

    @NotNull
    public static final String TAG = "QzoneGiftKuiklyManager";

    @Nullable
    private IVasKuiklyNestPageFrame.b mBindLogic;

    @Nullable
    private FrameLayout mCotentLayout;

    @Nullable
    private WeakReference<FrameLayout> mWeakParentLayout;

    private final void bindKuiklyViewToContainer(final ViewGroup frame, String args) {
        if (this.mBindLogic == null) {
            QLog.i(TAG, 1, "BIND_KUIKLY_VIEW");
            ((IVasKuiklyApi) QRoute.api(IVasKuiklyApi.class)).setMqqToKuiklyData("vas_gift_display", args);
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put(KuiklyLaunchParams.PARAM_MODAL_MODE, "1");
            final String buildVasKuiklySchema = ((IVasKuiklyApi) QRoute.api(IVasKuiklyApi.class)).buildVasKuiklySchema("vas_gift_display", "vas_gift_display", arrayMap);
            IVasKuiklyNestPageFrame.b newFrame = ((IVasKuiklyNestPageFrame) QRoute.api(IVasKuiklyNestPageFrame.class)).newFrame("vas_gift_display", new Function0<String>() { // from class: com.tencent.mobileqq.vas.giftdisplay.impl.VasGiftKuiklyManagerImpl$bindKuiklyViewToContainer$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    return buildVasKuiklySchema;
                }
            });
            this.mBindLogic = newFrame;
            if (newFrame != null) {
                newFrame.a("vas_gift_display_close", new IVasKuiklyNestPageFrame.a() { // from class: com.tencent.mobileqq.vas.giftdisplay.impl.b
                    @Override // com.tencent.mobileqq.vas.api.IVasKuiklyNestPageFrame.a
                    public final void handle(String str, JSONObject jSONObject) {
                        VasGiftKuiklyManagerImpl.bindKuiklyViewToContainer$lambda$1(VasGiftKuiklyManagerImpl.this, str, jSONObject);
                    }
                });
            }
            if (frame != null) {
                frame.post(new Runnable() { // from class: com.tencent.mobileqq.vas.giftdisplay.impl.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        VasGiftKuiklyManagerImpl.bindKuiklyViewToContainer$lambda$2(VasGiftKuiklyManagerImpl.this, frame);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindKuiklyViewToContainer$lambda$1(VasGiftKuiklyManagerImpl this$0, String eventName, JSONObject data) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(data, "data");
        QLog.i(TAG, 1, "eventName:" + eventName + " data:" + data);
        this$0.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindKuiklyViewToContainer$lambda$2(VasGiftKuiklyManagerImpl this$0, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IVasKuiklyNestPageFrame.b bVar = this$0.mBindLogic;
        if (bVar != null) {
            bVar.h0(viewGroup);
        }
    }

    private final Activity getActivity() {
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity == null) {
            return null;
        }
        return qBaseActivity;
    }

    private final void initContentView(String args) {
        QLog.i(TAG, 1, "MSG_INIT_CONTENT_VIEW");
        onDestroy();
        Activity activity = getActivity();
        if (activity != null) {
            View findViewById = activity.findViewById(R.id.content);
            Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.FrameLayout");
            WeakReference<FrameLayout> weakReference = new WeakReference<>((FrameLayout) findViewById);
            this.mWeakParentLayout = weakReference;
            final FrameLayout frameLayout = weakReference.get();
            if (frameLayout == null) {
                QLog.e(TAG, 1, "mParentLayout = null");
                return;
            }
            this.mCotentLayout = new FrameLayout(BaseApplication.getContext());
            final FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            frameLayout.post(new Runnable() { // from class: com.tencent.mobileqq.vas.giftdisplay.impl.a
                @Override // java.lang.Runnable
                public final void run() {
                    VasGiftKuiklyManagerImpl.initContentView$lambda$0(VasGiftKuiklyManagerImpl.this, frameLayout, layoutParams);
                }
            });
            bindKuiklyViewToContainer(this.mCotentLayout, args);
            return;
        }
        QLog.e(TAG, 1, "activity = null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initContentView$lambda$0(VasGiftKuiklyManagerImpl this$0, FrameLayout frameLayout, FrameLayout.LayoutParams fillLp) {
        ViewParent viewParent;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(fillLp, "$fillLp");
        FrameLayout frameLayout2 = this$0.mCotentLayout;
        ViewGroup viewGroup = null;
        if (frameLayout2 != null) {
            viewParent = frameLayout2.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent instanceof ViewGroup) {
            viewGroup = (ViewGroup) viewParent;
        }
        if (viewGroup != null) {
            viewGroup.removeView(this$0.mCotentLayout);
        }
        frameLayout.addView(this$0.mCotentLayout, fillLp);
    }

    @Override // com.tencent.mobileqq.vas.giftdisplay.IVasGiftKuiklyManager
    public boolean ifUseKuikly() {
        return ar.INSTANCE.b("ketchwang", "2024-11-21", "vas_gift_display_config").isEnable(false);
    }

    @Override // com.tencent.mobileqq.vas.giftdisplay.IVasGiftKuiklyManager
    public void onDestroy() {
        FrameLayout frameLayout;
        IVasKuiklyNestPageFrame.b bVar = this.mBindLogic;
        if (bVar != null) {
            bVar.detachView();
        }
        FrameLayout frameLayout2 = null;
        if (this.mBindLogic != null) {
            this.mBindLogic = null;
        }
        WeakReference<FrameLayout> weakReference = this.mWeakParentLayout;
        if (weakReference == null) {
            return;
        }
        if (weakReference != null) {
            frameLayout2 = weakReference.get();
        }
        if (frameLayout2 != null && (frameLayout = this.mCotentLayout) != null) {
            frameLayout2.removeView(frameLayout);
        }
    }

    @Override // com.tencent.mobileqq.vas.giftdisplay.IVasGiftKuiklyManager
    public void startPlay(@NotNull String args) {
        Intrinsics.checkNotNullParameter(args, "args");
        initContentView(args);
    }
}
