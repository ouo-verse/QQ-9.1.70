package com.tencent.mobileqq.markdown.multipic;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.gallery.api.IRichMediaDepend;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.part.RFWLayerBasePart;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/markdown/multipic/f;", "Lcom/tencent/richframework/gallery/part/RFWLayerBasePart;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "z9", "B9", "onInitView", "<init>", "()V", "d", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class f extends RFWLayerBasePart {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void A9(f this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.B9();
    }

    private final void B9() {
        if (FastClickUtils.isFastDoubleClick("MultiPicSavePart")) {
            return;
        }
        String a16 = c.f243753a.a(this.mCurrentSelectedItem);
        if (a16.length() == 0) {
            QLog.e("MultiPicSavePart", 1, "onSaveBtnClick avatarFilePath isEmpty return.");
            return;
        }
        if (!new File(a16).exists()) {
            QLog.e("MultiPicSavePart", 1, "onSaveBtnClick not exists. error!");
            return;
        }
        IRichMediaDepend iRichMediaDepend = (IRichMediaDepend) QRoute.api(IRichMediaDepend.class);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        Intrinsics.checkNotNull(rFWLayerItemMediaInfo);
        iRichMediaDepend.saveToAlbum(context, rFWLayerItemMediaInfo);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        z9(rootView);
    }

    private final void z9(View rootView) {
        ImageButton imageButton;
        if (rootView == null || (imageButton = (ImageButton) rootView.findViewById(R.id.f162727th)) == null) {
            return;
        }
        imageButton.setClickable(true);
        imageButton.setFocusable(true);
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.markdown.multipic.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.A9(f.this, view);
            }
        });
    }
}
