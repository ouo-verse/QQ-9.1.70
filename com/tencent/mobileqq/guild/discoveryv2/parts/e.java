package com.tencent.mobileqq.guild.discoveryv2.parts;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import androidx.constraintlayout.widget.Guideline;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.compat.RFWImmersiveUtils;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/parts/e;", "Lcom/tencent/biz/richframework/part/Part;", "", "C9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "Landroidx/constraintlayout/widget/Guideline;", "d", "Landroidx/constraintlayout/widget/Guideline;", "immersiveGuideLine", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class e extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Guideline immersiveGuideLine;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A9(e this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.C9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B9(e this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.C9();
    }

    private final void C9() {
        Window window;
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            RFWImmersiveUtils.setTransparentStatusBar(getActivity().getWindow());
            RFWImmersiveUtils.setImmersiveLayout(getActivity().getWindow(), false);
        }
        Activity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            SimpleUIUtil.adjustSimpleStatusBar((ImmersiveTitleBar2) null, window);
            GuildThemeManager.i(true ^ GuildThemeManager.f235286a.b(), window);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        if (rootView == null) {
            return;
        }
        View findViewById = rootView.findViewById(R.id.uiv);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026_v2_immersive_guide_line)");
        Guideline guideline = (Guideline) findViewById;
        this.immersiveGuideLine = guideline;
        if (guideline == null) {
            Intrinsics.throwUninitializedPropertyAccessException("immersiveGuideLine");
            guideline = null;
        }
        guideline.setGuidelineBegin(RFWImmersiveUtils.getStatusBarHeight(rootView.getContext()));
        rootView.post(new Runnable() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.c
            @Override // java.lang.Runnable
            public final void run() {
                e.A9(e.this);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
        getPartRootView().post(new Runnable() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.d
            @Override // java.lang.Runnable
            public final void run() {
                e.B9(e.this);
            }
        });
    }
}
