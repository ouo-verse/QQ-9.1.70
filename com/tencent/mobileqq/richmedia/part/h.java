package com.tencent.mobileqq.richmedia.part;

import android.view.View;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ao;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.part.RFWLayerBasePart;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0014J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0005H\u0016R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/richmedia/part/h;", "Lcom/tencent/richframework/gallery/part/RFWLayerBasePart;", "Landroid/view/View$OnClickListener;", "", "loadOriginImageInner", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "updateLayerState", "v", NodeProps.ON_CLICK, "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "originPictureText", "<init>", "()V", "RichMediaBrowser_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class h extends RFWLayerBasePart implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView originPictureText;

    private final void loadOriginImageInner() {
        RFWLayerPicInfo layerPicInfo;
        RFWLayerPicInfo.RFWPicInfo originPicInfo;
        RFWLayerPicInfo rFWLayerPicInfo;
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        if (rFWLayerItemMediaInfo != null && (layerPicInfo = rFWLayerItemMediaInfo.getLayerPicInfo()) != null && (originPicInfo = layerPicInfo.getOriginPicInfo()) != null) {
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo2 = this.mCurrentSelectedItem;
            if (rFWLayerItemMediaInfo2 != null) {
                rFWLayerPicInfo = rFWLayerItemMediaInfo2.getLayerPicInfo();
            } else {
                rFWLayerPicInfo = null;
            }
            if (rFWLayerPicInfo != null) {
                rFWLayerPicInfo.setCurrentPicInfo(originPicInfo);
            }
            UIStateData<RFWLayerState> value = getMLayerViewModel().mRichMediaInfo.getValue();
            if (value != null) {
                value.setLatestModifyRecord(UIStateData.ModifyListRecord.obtainNotifyItemRangeChange(this.mSelectedPosition, 1));
            }
            getMLayerViewModel().mRichMediaInfo.setValue(getMLayerViewModel().mRichMediaInfo.getValue());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        String mediaId;
        com.tencent.mobileqq.richmedia.depend.a aVar;
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (v3.getId() == R.id.zve) {
            loadOriginImageInner();
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
            if (rFWLayerItemMediaInfo != null && (mediaId = rFWLayerItemMediaInfo.getMediaId()) != null) {
                com.tencent.mobileqq.richmedia.e eVar = com.tencent.mobileqq.richmedia.e.f281568a;
                String name = com.tencent.mobileqq.richmedia.depend.a.class.getName();
                Intrinsics.checkNotNullExpressionValue(name, "ICommonLayerOperationReport::class.java.name");
                com.tencent.mobileqq.richmedia.depend.c d16 = eVar.d(name);
                if (d16 instanceof com.tencent.mobileqq.richmedia.depend.a) {
                    aVar = (com.tencent.mobileqq.richmedia.depend.a) d16;
                } else {
                    aVar = null;
                }
                if (aVar != null) {
                    aVar.V4(mediaId);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        TextView textView = (TextView) rootView.findViewById(R.id.zve);
        this.originPictureText = textView;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        TextView textView2 = this.originPictureText;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.richframework.gallery.part.RFWLayerBasePart
    public void updateLayerState(@NotNull RFWLayerState layerState) {
        String str;
        String str2;
        RFWLayerPicInfo.RFWPicInfo rFWPicInfo;
        RFWLayerPicInfo.RFWPicInfo rFWPicInfo2;
        RFWLayerPicInfo.RFWPicInfo originPicInfo;
        RFWLayerPicInfo.RFWPicInfo currentPicInfo;
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        super.updateLayerState(layerState);
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        if (rFWLayerItemMediaInfo != null) {
            if (!rFWLayerItemMediaInfo.getInvalid() && !rFWLayerItemMediaInfo.isVideo()) {
                RFWLayerPicInfo layerPicInfo = rFWLayerItemMediaInfo.getLayerPicInfo();
                RFWLayerPicInfo.RFWPicInfo rFWPicInfo3 = null;
                if (layerPicInfo != null && (currentPicInfo = layerPicInfo.getCurrentPicInfo()) != null) {
                    str = currentPicInfo.getLocalPath();
                } else {
                    str = null;
                }
                RFWLayerPicInfo layerPicInfo2 = rFWLayerItemMediaInfo.getLayerPicInfo();
                if (layerPicInfo2 != null && (originPicInfo = layerPicInfo2.getOriginPicInfo()) != null) {
                    str2 = originPicInfo.getLocalPath();
                } else {
                    str2 = null;
                }
                if (!Intrinsics.areEqual(str, str2)) {
                    RFWLayerPicInfo layerPicInfo3 = rFWLayerItemMediaInfo.getLayerPicInfo();
                    if (layerPicInfo3 != null) {
                        rFWPicInfo = layerPicInfo3.getOriginPicInfo();
                    } else {
                        rFWPicInfo = null;
                    }
                    if (rFWPicInfo != null) {
                        RFWLayerPicInfo layerPicInfo4 = rFWLayerItemMediaInfo.getLayerPicInfo();
                        if (layerPicInfo4 != null) {
                            rFWPicInfo2 = layerPicInfo4.getOriginPicInfo();
                        } else {
                            rFWPicInfo2 = null;
                        }
                        Intrinsics.checkNotNull(rFWPicInfo2);
                        if (rFWPicInfo2.getSize() > 0) {
                            TextView textView = this.originPictureText;
                            if (textView != null) {
                                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                                Locale locale = Locale.CHINA;
                                String string = getContext().getString(R.string.d0d);
                                Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026view_raw_photo_with_size)");
                                Object[] objArr = new Object[1];
                                RFWLayerPicInfo layerPicInfo5 = rFWLayerItemMediaInfo.getLayerPicInfo();
                                if (layerPicInfo5 != null) {
                                    rFWPicInfo3 = layerPicInfo5.getOriginPicInfo();
                                }
                                Intrinsics.checkNotNull(rFWPicInfo3);
                                objArr[0] = ao.a(rFWPicInfo3.getSize());
                                String format = String.format(locale, string, Arrays.copyOf(objArr, 1));
                                Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
                                textView.setText(format);
                            }
                        } else {
                            TextView textView2 = this.originPictureText;
                            if (textView2 != null) {
                                textView2.setText(getContext().getString(R.string.d0a));
                            }
                        }
                        TextView textView3 = this.originPictureText;
                        if (textView3 != null) {
                            textView3.setVisibility(0);
                            return;
                        }
                        return;
                    }
                }
            }
            TextView textView4 = this.originPictureText;
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
        }
    }
}
