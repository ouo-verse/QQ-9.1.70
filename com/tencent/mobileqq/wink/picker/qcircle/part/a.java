package com.tencent.mobileqq.wink.picker.qcircle.part;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.picker.qcircle.QCircleMediaPickerFragment;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/part/a;", "Lcom/tencent/biz/richframework/part/Part;", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "msg", "", "duration", "x9", "<init>", "()V", "d", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a extends Part {
    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QCircleMediaPickerMusicCheckPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        Serializable serializable;
        String tips;
        boolean z16;
        Intent intent;
        super.onInitView(rootView);
        QCircleMediaPickerFragment a16 = f93.a.a(this);
        if (a16 != null) {
            FragmentActivity activity = a16.getActivity();
            HashMap hashMap = null;
            if (activity != null && (intent = activity.getIntent()) != null) {
                serializable = intent.getSerializableExtra("key_attrs");
            } else {
                serializable = null;
            }
            if (serializable instanceof HashMap) {
                hashMap = (HashMap) serializable;
            }
            if (hashMap != null && (tips = (String) hashMap.get(QCircleScheme.AttrQQPublish.NO_LICENSE_TIPS)) != null) {
                Intrinsics.checkNotNullExpressionValue(tips, "tips");
                if (tips.length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    x9(tips, 0);
                }
            }
        }
    }

    public final void x9(@NotNull String msg2, int duration) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#80000000"));
        gradientDrawable.setCornerRadius(ViewUtils.dpToPx(8.0f));
        gradientDrawable.setShape(0);
        int dip2px = ViewUtils.dip2px(12.0f);
        TextView textView = new TextView(MobileQQ.sMobileQQ);
        textView.setBackground(gradientDrawable);
        textView.setTextSize(2, 14.0f);
        textView.setPadding(dip2px, dip2px, dip2px, dip2px);
        textView.setLines(1);
        textView.setTextColor(-1);
        textView.setText(msg2);
        Toast toast = new Toast(MobileQQ.sMobileQQ);
        toast.setView(textView);
        toast.setDuration(duration);
        toast.setGravity(17, 0, 0);
        toast.show();
    }
}
