package com.tencent.mobileqq.wink.picker.core.part;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\u000bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/part/u;", "Lcom/tencent/biz/richframework/part/Part;", "", "getLogTag", "", "getInitRelyViewStubId", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "B9", "", "z9", "d", "Landroid/view/View;", TtmlNode.TAG_LAYOUT, "<init>", "()V", "e", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class u extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View layout;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A9(View this_run, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        if (this_run.getContext() != null) {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", this_run.getContext().getPackageName(), null));
            this_run.getContext().startActivity(intent);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void B9() {
        View view = this.layout;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.Part
    public int getInitRelyViewStubId() {
        return R.id.f73593tz;
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    public String getLogTag() {
        return "WinkMediaPermissionPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.f2372077);
        this.layout = findViewById;
        if (findViewById != null) {
            findViewById.setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
        }
        final View findViewById2 = rootView.findViewById(R.id.f73453tl);
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.core.part.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    u.A9(findViewById2, view);
                }
            });
            com.tencent.mobileqq.wink.picker.report.a.b(findViewById2, WinkDaTongReportConstant.ElementId.EM_XSJ_NO_PIC_ACCESS_GOTO_SETTING_BUTTON, null, null, false, 28, null);
        }
    }

    public final boolean z9() {
        View view = this.layout;
        if (view == null || view.getVisibility() != 0) {
            return false;
        }
        return true;
    }
}
