package com.tencent.mobileqq.wink.picker.qzone.part;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.google.android.material.appbar.AppBarLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.picker.core.ktx.ViewExKt;
import com.tencent.mobileqq.wink.picker.qzone.QZoneMediaPickerFragment;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qzone/part/a;", "Lcom/tencent/biz/richframework/part/Part;", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "<init>", "()V", "d", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a extends Part {
    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneMediaPickerTopBannerPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        QZoneMediaPickerFragment qZoneMediaPickerFragment;
        Fragment hostFragment = getHostFragment();
        if (hostFragment instanceof QZoneMediaPickerFragment) {
            qZoneMediaPickerFragment = (QZoneMediaPickerFragment) hostFragment;
        } else {
            qZoneMediaPickerFragment = null;
        }
        if (qZoneMediaPickerFragment != null) {
            View inflate = LayoutInflater.from(qZoneMediaPickerFragment.getContext()).inflate(R.layout.hl7, (ViewGroup) null);
            AppBarLayout.LayoutParams layoutParams = new AppBarLayout.LayoutParams(-1, ViewExKt.d(52));
            layoutParams.g(1);
            inflate.setLayoutParams(layoutParams);
            AppBarLayout Xh = qZoneMediaPickerFragment.Xh();
            if (Xh != null) {
                Xh.addView(inflate);
            }
            ((TextView) inflate.findViewById(R.id.t4a)).setText(qZoneMediaPickerFragment.Ph().getTopBannerTextContent());
        }
    }
}
