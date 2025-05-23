package com.tencent.mobileqq.matchfriend.reborn.media.gallery.part;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.matchfriend.reborn.media.gallery.event.QQStrangerGalleryEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.utils.l;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.part.RFWLayerBasePart;
import cooperation.qzone.QzoneIPCModule;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/media/gallery/part/c;", "Lcom/tencent/richframework/gallery/part/RFWLayerBasePart;", "Landroid/view/View;", "z9", "Landroid/graphics/drawable/Drawable;", "B9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "<init>", "()V", "d", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class c extends RFWLayerBasePart {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void A9(c this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        q82.a aVar = q82.a.f428711a;
        Activity activity = this$0.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        aVar.g(activity, 200);
    }

    private final Drawable B9() {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, Color.parseColor("#B2000000")});
        gradientDrawable.setShape(0);
        gradientDrawable.setGradientType(0);
        return gradientDrawable;
    }

    private final View z9() {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.b(216));
        layoutParams.gravity = 80;
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.setBackground(B9());
        QUIButton qUIButton = new QUIButton(relativeLayout.getContext());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        qUIButton.setLayoutParams(layoutParams2);
        qUIButton.setType(2);
        qUIButton.setSizeType(1);
        qUIButton.setText("\u66f4\u6362\u56fe\u7247");
        qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.media.gallery.part.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.A9(c.this, view);
            }
        });
        relativeLayout.addView(qUIButton);
        return relativeLayout;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Object first;
        Object first2;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 200 && resultCode == -1) {
            Serializable serializableExtra = data != null ? data.getSerializableExtra("OUTPUT_MEDIA") : null;
            ArrayList arrayList = serializableExtra instanceof ArrayList ? (ArrayList) serializableExtra : null;
            List list = arrayList != null ? CollectionsKt___CollectionsKt.toList(arrayList) : null;
            List list2 = list;
            if (!(list2 == null || list2.isEmpty())) {
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
                String str = ((LocalMediaInfo) first).path;
                if (!(str == null || str.length() == 0)) {
                    first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
                    String path = ((LocalMediaInfo) first2).path;
                    if (path == null || path.length() == 0) {
                        QLog.i("QQStrangerLayerReplacePart", 1, "[onSelectPicResult]path is empty.");
                        return;
                    }
                    RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
                    RFWLayerPicInfo layerPicInfo = rFWLayerItemMediaInfo != null ? rFWLayerItemMediaInfo.getLayerPicInfo() : null;
                    if (layerPicInfo != null) {
                        RFWLayerPicInfo.RFWPicInfo rFWPicInfo = new RFWLayerPicInfo.RFWPicInfo();
                        rFWPicInfo.setLocalPath(path);
                        layerPicInfo.setCurrentPicInfo(rFWPicInfo);
                    }
                    UIStateData<RFWLayerState> value = getMLayerViewModel().mRichMediaInfo.getValue();
                    if (value != null) {
                        value.setLatestModifyRecord(UIStateData.ModifyListRecord.obtainNotifyDataSetChanged());
                        getMLayerViewModel().mRichMediaInfo.postValue(value);
                    }
                    SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                    Intrinsics.checkNotNullExpressionValue(path, "path");
                    simpleEventBus.dispatchEvent(new QQStrangerGalleryEvent.OnPhotoChangeEvent(path));
                    QLog.i("QQStrangerLayerReplacePart", 1, "path=" + path);
                    return;
                }
            }
            QLog.i("QQStrangerLayerReplacePart", 1, "[onSelectPicResult] outputMedia is null");
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        ViewGroup viewGroup = rootView instanceof ViewGroup ? (ViewGroup) rootView : null;
        if (viewGroup != null) {
            viewGroup.addView(z9());
        }
    }
}
