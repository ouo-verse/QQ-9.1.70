package com.tencent.robot.share.layer;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.gallery.api.IRichMediaDepend;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.part.RFWLayerBasePart;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/robot/share/layer/e;", "Lcom/tencent/richframework/gallery/part/RFWLayerBasePart;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "z9", "B9", "onInitView", "Landroid/widget/ImageButton;", "d", "Landroid/widget/ImageButton;", "mSaveBtn", "<init>", "()V", "e", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class e extends RFWLayerBasePart {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageButton mSaveBtn;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A9(e this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.B9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void B9() {
        boolean z16;
        if (FastClickUtils.isFastDoubleClick("RobotLayerSavePart")) {
            return;
        }
        String a16 = g.f368413a.a(this.mCurrentSelectedItem);
        if (a16.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.e("RobotLayerSavePart", 1, "onSaveBtnClick avatarFilePath isEmpty return.");
            return;
        }
        if (!new File(a16).exists()) {
            QLog.e("RobotLayerSavePart", 1, "onSaveBtnClick not exists. error!");
            return;
        }
        IRichMediaDepend iRichMediaDepend = (IRichMediaDepend) QRoute.api(IRichMediaDepend.class);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        Intrinsics.checkNotNull(rFWLayerItemMediaInfo);
        iRichMediaDepend.saveToAlbum(context, rFWLayerItemMediaInfo);
    }

    private final void z9(View rootView) {
        ImageButton imageButton;
        if (rootView != null && (imageButton = (ImageButton) rootView.findViewById(R.id.ifu)) != null) {
            imageButton.setClickable(true);
            imageButton.setFocusable(true);
            imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.share.layer.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e.A9(e.this, view);
                }
            });
        } else {
            imageButton = null;
        }
        this.mSaveBtn = imageButton;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        z9(rootView);
    }
}
