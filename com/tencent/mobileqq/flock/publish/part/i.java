package com.tencent.mobileqq.flock.publish.part;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import cooperation.qzone.QzoneIPCModule;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u001a\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0016\u0010\u0010\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\"\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/flock/publish/part/i;", "Lcom/tencent/mobileqq/flock/base/e;", "Lcom/tencent/richframework/data/base/UIStateData;", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "uiStateData", "", "D9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "B9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onInitView", "onChanged", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "d", "Landroid/view/View;", "editButton", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class i extends com.tencent.mobileqq.flock.base.e {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View editButton;

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void B9(View rootView) {
        Typeface create;
        TextView textView = new TextView(getContext());
        textView.setVisibility(4);
        textView.setText("\u7f16\u8f91");
        textView.setTextSize(1, 16.0f);
        textView.setTextColor(ContextCompat.getColor(textView.getContext(), R.color.qui_common_text_allwhite_primary));
        if (Build.VERSION.SDK_INT >= 28) {
            create = Typeface.create(null, 600, false);
            textView.setTypeface(create);
        }
        textView.setBackgroundResource(R.drawable.jn5);
        textView.setGravity(17);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.flock.publish.part.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.C9(i.this, view);
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.tencent.mobileqq.flock.ktx.i.b(164), com.tencent.mobileqq.flock.ktx.i.b(40));
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = com.tencent.mobileqq.flock.ktx.i.b(30);
        Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) rootView).addView(textView, layoutParams);
        this.editButton = textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C9(i this$0, View view) {
        Object obj;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this$0.mCurrentSelectedItem;
        LocalMediaInfo localMediaInfo = null;
        if (rFWLayerItemMediaInfo != null) {
            obj = rFWLayerItemMediaInfo.getExtraData();
        } else {
            obj = null;
        }
        if (obj instanceof LocalMediaInfo) {
            localMediaInfo = (LocalMediaInfo) obj;
        }
        if (localMediaInfo != null) {
            qc1.a aVar = qc1.a.f428842a;
            Activity activity = this$0.getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            aVar.c(activity, localMediaInfo);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void D9(UIStateData<RFWLayerState> uiStateData) {
        boolean z16;
        String str;
        Object obj;
        RFWLayerPicInfo layerPicInfo;
        RFWLayerPicInfo.RFWPicInfo bigPicInfo;
        View view = this.editButton;
        if (view != null && view.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        LocalMediaInfo localMediaInfo = null;
        if (rFWLayerItemMediaInfo != null && (layerPicInfo = rFWLayerItemMediaInfo.getLayerPicInfo()) != null && (bigPicInfo = layerPicInfo.getBigPicInfo()) != null) {
            str = bigPicInfo.getUrl();
        } else {
            str = null;
        }
        if (com.tencent.mobileqq.flock.ktx.g.a(str) && uiStateData.getState() == 2) {
            String picLocalPath = com.tencent.mobileqq.flock.picloader.a.a().b().getPicLocalPath(Option.obtain().setUrl(str));
            if (new File(picLocalPath).exists()) {
                RFWLayerItemMediaInfo rFWLayerItemMediaInfo2 = this.mCurrentSelectedItem;
                if (rFWLayerItemMediaInfo2 != null) {
                    obj = rFWLayerItemMediaInfo2.getExtraData();
                } else {
                    obj = null;
                }
                if (obj instanceof LocalMediaInfo) {
                    localMediaInfo = (LocalMediaInfo) obj;
                }
                if (localMediaInfo != null) {
                    localMediaInfo.path = picLocalPath;
                }
                View view2 = this.editButton;
                if (view2 != null) {
                    view2.setVisibility(0);
                    return;
                }
                return;
            }
            return;
        }
        View view3 = this.editButton;
        if (view3 != null) {
            view3.setVisibility(0);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1) {
            Activity activity = getActivity();
            Bundle extras = activity.getIntent().getExtras();
            if (extras != null && data != null) {
                data.putExtras(extras);
            }
            activity.setResult(100, data);
            activity.finish();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
        } else {
            super.onInitView(rootView);
            B9(rootView);
        }
    }

    @Override // com.tencent.richframework.gallery.part.RFWLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Serializable serializable;
        UIStateData<RFWLayerState> value;
        RFWLayerState data;
        List<RFWLayerItemMediaInfo> richMediaDataList;
        Object orNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        Bundle extras = activity.getIntent().getExtras();
        ArrayList arrayList = null;
        if (extras != null) {
            serializable = extras.getSerializable("flock_gallery_media");
        } else {
            serializable = null;
        }
        if (serializable instanceof ArrayList) {
            arrayList = (ArrayList) serializable;
        }
        if (arrayList != null && (value = getMLayerViewModel().mRichMediaInfo.getValue()) != null && (data = value.getData()) != null && (richMediaDataList = data.getRichMediaDataList()) != null) {
            int i3 = 0;
            for (Object obj : richMediaDataList) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                orNull = CollectionsKt___CollectionsKt.getOrNull(arrayList, i3);
                ((RFWLayerItemMediaInfo) obj).setExtraData(orNull);
                i3 = i16;
            }
        }
    }

    @Override // com.tencent.richframework.gallery.part.RFWLayerBasePart, androidx.lifecycle.Observer
    public void onChanged(@NotNull UIStateData<RFWLayerState> uiStateData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) uiStateData);
            return;
        }
        Intrinsics.checkNotNullParameter(uiStateData, "uiStateData");
        super.onChanged(uiStateData);
        D9(uiStateData);
    }
}
