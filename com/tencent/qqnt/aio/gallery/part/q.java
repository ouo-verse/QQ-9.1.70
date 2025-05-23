package com.tencent.qqnt.aio.gallery.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ao;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.delegate.INTLayerOperationListener;
import com.tencent.richframework.gallery.part.NTAIOLayerBasePart;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\bH\u0016R$\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/part/q;", "Lcom/tencent/richframework/gallery/part/NTAIOLayerBasePart;", "Landroid/view/View$OnClickListener;", "", "visibility", "", "x9", "loadOriginImageInner", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "onLayerStateUpdate", "v", NodeProps.ON_CLICK, "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "getMShowOriginTv", "()Landroid/widget/TextView;", "setMShowOriginTv", "(Landroid/widget/TextView;)V", "mShowOriginTv", "Lcom/tencent/qqnt/msg/i;", "e", "Lcom/tencent/qqnt/msg/i;", "mKernelMsgListener", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public class q extends NTAIOLayerBasePart implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView mShowOriginTv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.qqnt.msg.i mKernelMsgListener = new a();

    private final void loadOriginImageInner() {
        RFWLayerPicInfo layerPicInfo;
        RFWLayerPicInfo.RFWPicInfo originPicInfo;
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        if (rFWLayerItemMediaInfo == null || (layerPicInfo = rFWLayerItemMediaInfo.getLayerPicInfo()) == null || (originPicInfo = layerPicInfo.getOriginPicInfo()) == null) {
            return;
        }
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo2 = this.mCurrentSelectedItem;
        RFWLayerPicInfo layerPicInfo2 = rFWLayerItemMediaInfo2 != null ? rFWLayerItemMediaInfo2.getLayerPicInfo() : null;
        if (layerPicInfo2 != null) {
            layerPicInfo2.setCurrentPicInfo(originPicInfo);
        }
        UIStateData.ModifyListRecord obtainNotifyItemRangeChange = UIStateData.ModifyListRecord.obtainNotifyItemRangeChange(this.mSelectedPosition, 1);
        Intrinsics.checkNotNullExpressionValue(obtainNotifyItemRangeChange, "obtainNotifyItemRangeChange(mSelectedPosition, 1)");
        updateRichMediaList(obtainNotifyItemRangeChange);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        Intrinsics.checkNotNullParameter(v3, "v");
        if (this.mCurrentSelectedItem != null && v3.getId() == R.id.zve) {
            loadOriginImageInner();
            RFWLog.d(getTAG(), RFWLog.USR, "origin_btn click");
            INTLayerOperationListener mLayerOperateListener = getMLayerOperateListener();
            if (mLayerOperateListener != null) {
                mLayerOperateListener.clickShowOriginPicBtn();
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        TextView textView = (TextView) rootView.findViewById(R.id.zve);
        this.mShowOriginTv = textView;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        TextView textView2 = this.mShowOriginTv;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        VideoReport.setElementId(this.mShowOriginTv, "em_bas_view_the_original_picture");
        TextView textView3 = this.mShowOriginTv;
        if (textView3 != null) {
            bindDtElement(textView3);
        }
    }

    @Override // com.tencent.richframework.gallery.part.NTAIOLayerBasePart
    public void onLayerStateUpdate(RFWLayerState layerState) {
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        if (rFWLayerItemMediaInfo != null) {
            if (!rFWLayerItemMediaInfo.getInvalid() && !rFWLayerItemMediaInfo.isVideo() && !rFWLayerItemMediaInfo.isShowOriginPic()) {
                RFWLayerPicInfo layerPicInfo = rFWLayerItemMediaInfo.getLayerPicInfo();
                if ((layerPicInfo != null ? layerPicInfo.getOriginPicInfo() : null) != null) {
                    RFWLayerPicInfo layerPicInfo2 = rFWLayerItemMediaInfo.getLayerPicInfo();
                    RFWLayerPicInfo.RFWPicInfo originPicInfo = layerPicInfo2 != null ? layerPicInfo2.getOriginPicInfo() : null;
                    Intrinsics.checkNotNull(originPicInfo);
                    if (originPicInfo.getSize() > 0) {
                        TextView textView = this.mShowOriginTv;
                        if (textView != null) {
                            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                            Locale locale = Locale.CHINA;
                            String string = getContext().getString(R.string.d0d);
                            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026view_raw_photo_with_size)");
                            Object[] objArr = new Object[1];
                            RFWLayerPicInfo layerPicInfo3 = rFWLayerItemMediaInfo.getLayerPicInfo();
                            RFWLayerPicInfo.RFWPicInfo originPicInfo2 = layerPicInfo3 != null ? layerPicInfo3.getOriginPicInfo() : null;
                            Intrinsics.checkNotNull(originPicInfo2);
                            objArr[0] = ao.a(originPicInfo2.getSize());
                            String format = String.format(locale, string, Arrays.copyOf(objArr, 1));
                            Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
                            textView.setText(format);
                        }
                    } else {
                        TextView textView2 = this.mShowOriginTv;
                        if (textView2 != null) {
                            textView2.setText(getContext().getString(R.string.d0a));
                        }
                    }
                    x9(0);
                    return;
                }
            }
            x9(8);
        }
    }

    @Override // com.tencent.richframework.gallery.part.NTAIOLayerBasePart, com.tencent.richframework.gallery.part.RFWLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        IKernelService iKernelService;
        com.tencent.qqnt.kernel.api.w msgService;
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")) == null || (msgService = iKernelService.getMsgService()) == null) {
            return;
        }
        msgService.addMsgListener(this.mKernelMsgListener);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        IKernelService iKernelService;
        com.tencent.qqnt.kernel.api.w msgService;
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")) == null || (msgService = iKernelService.getMsgService()) == null) {
            return;
        }
        msgService.removeMsgListener(this.mKernelMsgListener);
    }

    private final void x9(int visibility) {
        INTLayerOperationListener mLayerOperateListener;
        INTLayerOperationListener mLayerOperateListener2;
        if (visibility == 0) {
            TextView textView = this.mShowOriginTv;
            if ((textView != null && textView.getVisibility() == 8) && (mLayerOperateListener = getMLayerOperateListener()) != null) {
                mLayerOperateListener.onOriginBtnShow();
            }
        } else if (visibility == 8) {
            TextView textView2 = this.mShowOriginTv;
            if ((textView2 != null && textView2.getVisibility() == 0) && (mLayerOperateListener2 = getMLayerOperateListener()) != null) {
                mLayerOperateListener2.onOriginBtnHide();
            }
        }
        TextView textView3 = this.mShowOriginTv;
        if (textView3 == null) {
            return;
        }
        textView3.setVisibility(visibility);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/aio/gallery/part/q$a", "Lcom/tencent/qqnt/msg/i;", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "notifyInfo", "", "onRichMediaDownloadComplete", "onRichMediaProgerssUpdate", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a extends com.tencent.qqnt.msg.i {
        a() {
        }

        @Override // com.tencent.qqnt.msg.i, com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onRichMediaDownloadComplete(FileTransNotifyInfo notifyInfo) {
        }

        @Override // com.tencent.qqnt.msg.i, com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onRichMediaProgerssUpdate(FileTransNotifyInfo notifyInfo) {
        }
    }
}
