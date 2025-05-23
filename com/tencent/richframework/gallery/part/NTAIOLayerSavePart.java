package com.tencent.richframework.gallery.part;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.api.IRichMediaDepend;
import com.tencent.richframework.gallery.bean.RFWLayerFileDownloadState;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.datacenter.RFWLayerDataCenter;
import com.tencent.richframework.gallery.delegate.INTLayerOperationListener;
import com.tencent.richframework.gallery.event.HideSaveView;
import com.tencent.richframework.gallery.event.RFWLayerFileStateChangeEvent;
import com.tencent.richframework.gallery.event.SaveToAlbumEvent;
import com.tencent.richframework.gallery.part.NTAIOLayerSavePart;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001)B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u001a\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0012H\u0002J\u0014\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001a0\u0019H\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0002J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u001eH\u0016J\u001a\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0012\u0010&\u001a\u00020\u00102\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010'\u001a\u00020\u00102\b\u0010(\u001a\u0004\u0018\u00010\u0004H\u0016R!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lcom/tencent/richframework/gallery/part/NTAIOLayerSavePart;", "Lcom/tencent/richframework/gallery/part/NTAIOLayerBasePart;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "()V", "mFileDownloadLoadStateObserver", "Landroidx/lifecycle/Observer;", "Lcom/tencent/richframework/gallery/bean/RFWLayerFileDownloadState;", "getMFileDownloadLoadStateObserver", "()Landroidx/lifecycle/Observer;", "mFileDownloadLoadStateObserver$delegate", "Lkotlin/Lazy;", "mSaveBtn", "Landroid/widget/ImageButton;", "doSaveToAlbum", "", "mediaId", "", "hashCode", "", "findMediaInfoWithMediaId", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "targetMediaId", "getEventClass", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "loadOriginImageInner", NodeProps.ON_CLICK, "v", "Landroid/view/View;", "onInitView", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onPartCreate", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onPartDestroy", "onReceiveEvent", "event", "FileDownloadStateObserver", "qq-layer-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class NTAIOLayerSavePart extends NTAIOLayerBasePart implements View.OnClickListener, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: mFileDownloadLoadStateObserver$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mFileDownloadLoadStateObserver;

    @Nullable
    private ImageButton mSaveBtn;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/richframework/gallery/part/NTAIOLayerSavePart$FileDownloadStateObserver;", "Landroidx/lifecycle/Observer;", "Lcom/tencent/richframework/gallery/bean/RFWLayerFileDownloadState;", "(Lcom/tencent/richframework/gallery/part/NTAIOLayerSavePart;)V", "onChanged", "", "downloadState", "qq-layer-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public final class FileDownloadStateObserver implements Observer<RFWLayerFileDownloadState> {
        public FileDownloadStateObserver() {
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(@Nullable RFWLayerFileDownloadState downloadState) {
            if ((downloadState != null ? downloadState.getFileState() : null) != RFWLayerFileDownloadState.FileState.DOWNLOAD_SUCCESS) {
                if ((downloadState != null ? downloadState.getFileState() : null) != RFWLayerFileDownloadState.FileState.DOWNLOAD_FAILED) {
                    return;
                }
            }
            RFWLayerItemMediaInfo findMediaInfoWithMediaId = NTAIOLayerSavePart.this.findMediaInfoWithMediaId(downloadState != null ? downloadState.getMediaId() : null);
            if (findMediaInfoWithMediaId != null) {
                NTAIOLayerSavePart nTAIOLayerSavePart = NTAIOLayerSavePart.this;
                if (findMediaInfoWithMediaId.isVideo()) {
                    return;
                }
                RFWLayerDataCenter rFWLayerDataCenter = RFWLayerDataCenter.INSTANCE;
                String mediaId = findMediaInfoWithMediaId.getMediaId();
                Intrinsics.checkNotNull(mediaId);
                rFWLayerDataCenter.removeObserverGlobalState(new RFWLayerFileDownloadState(mediaId), nTAIOLayerSavePart.getMFileDownloadLoadStateObserver());
                IRichMediaDepend iRichMediaDepend = (IRichMediaDepend) QRoute.api(IRichMediaDepend.class);
                Context context = nTAIOLayerSavePart.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                iRichMediaDepend.saveToAlbum(context, findMediaInfoWithMediaId);
            }
        }
    }

    public NTAIOLayerSavePart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<FileDownloadStateObserver>() { // from class: com.tencent.richframework.gallery.part.NTAIOLayerSavePart$mFileDownloadLoadStateObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final NTAIOLayerSavePart.FileDownloadStateObserver invoke() {
                return new NTAIOLayerSavePart.FileDownloadStateObserver();
            }
        });
        this.mFileDownloadLoadStateObserver = lazy;
    }

    private final void doSaveToAlbum() {
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        Intrinsics.checkNotNull(rFWLayerItemMediaInfo);
        if (!rFWLayerItemMediaInfo.getInvalid()) {
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo2 = this.mCurrentSelectedItem;
            Intrinsics.checkNotNull(rFWLayerItemMediaInfo2);
            if (!rFWLayerItemMediaInfo2.isVideo()) {
                RFWLayerItemMediaInfo rFWLayerItemMediaInfo3 = this.mCurrentSelectedItem;
                Intrinsics.checkNotNull(rFWLayerItemMediaInfo3);
                if (rFWLayerItemMediaInfo3.getLayerPicInfo() != null) {
                    RFWLayerItemMediaInfo rFWLayerItemMediaInfo4 = this.mCurrentSelectedItem;
                    Intrinsics.checkNotNull(rFWLayerItemMediaInfo4);
                    RFWLayerPicInfo layerPicInfo = rFWLayerItemMediaInfo4.getLayerPicInfo();
                    Intrinsics.checkNotNull(layerPicInfo);
                    if (layerPicInfo.getOriginPicInfo() != null) {
                        RFWLayerItemMediaInfo rFWLayerItemMediaInfo5 = this.mCurrentSelectedItem;
                        Intrinsics.checkNotNull(rFWLayerItemMediaInfo5);
                        if (!rFWLayerItemMediaInfo5.isShowOriginPic()) {
                            RFWLayerItemMediaInfo rFWLayerItemMediaInfo6 = this.mCurrentSelectedItem;
                            if (rFWLayerItemMediaInfo6 != null) {
                                RFWLayerDataCenter.INSTANCE.observerGlobalState(RFWLayerFileDownloadState.class, rFWLayerItemMediaInfo6.getMediaId(), getMFileDownloadLoadStateObserver());
                            }
                            loadOriginImageInner();
                            return;
                        }
                    }
                }
            }
        }
        IRichMediaDepend iRichMediaDepend = (IRichMediaDepend) QRoute.api(IRichMediaDepend.class);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo7 = this.mCurrentSelectedItem;
        Intrinsics.checkNotNull(rFWLayerItemMediaInfo7);
        iRichMediaDepend.saveToAlbum(context, rFWLayerItemMediaInfo7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RFWLayerItemMediaInfo findMediaInfoWithMediaId(String targetMediaId) {
        RFWLayerState data;
        List<RFWLayerItemMediaInfo> richMediaDataList;
        UIStateData<RFWLayerState> value = getMLayerViewModel().mRichMediaInfo.getValue();
        Object obj = null;
        if (value == null || (data = value.getData()) == null || (richMediaDataList = data.getRichMediaDataList()) == null) {
            return null;
        }
        Iterator<T> it = richMediaDataList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (Intrinsics.areEqual(((RFWLayerItemMediaInfo) next).getMediaId(), targetMediaId)) {
                obj = next;
                break;
            }
        }
        return (RFWLayerItemMediaInfo) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Observer<RFWLayerFileDownloadState> getMFileDownloadLoadStateObserver() {
        return (Observer) this.mFileDownloadLoadStateObserver.getValue();
    }

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
            UIStateData.ModifyListRecord obtainNotifyItemRangeChange = UIStateData.ModifyListRecord.obtainNotifyItemRangeChange(this.mSelectedPosition, 1);
            Intrinsics.checkNotNullExpressionValue(obtainNotifyItemRangeChange, "obtainNotifyItemRangeChange(mSelectedPosition, 1)");
            updateRichMediaList(obtainNotifyItemRangeChange);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(RFWLayerFileStateChangeEvent.class);
        arrayList.add(HideSaveView.class);
        arrayList.add(SaveToAlbumEvent.class);
        return arrayList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (this.mCurrentSelectedItem != null) {
            INTLayerOperationListener mLayerOperateListener = getMLayerOperateListener();
            if (mLayerOperateListener != null) {
                mLayerOperateListener.clickSaveBtn();
            }
            doSaveToAlbum();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        ImageButton imageButton = (ImageButton) rootView.findViewById(R.id.zvg);
        this.mSaveBtn = imageButton;
        if (imageButton != null) {
            imageButton.setVisibility(0);
        }
        ImageButton imageButton2 = this.mSaveBtn;
        if (imageButton2 != null) {
            imageButton2.setOnClickListener(this);
        }
        ImageButton imageButton3 = this.mSaveBtn;
        if (imageButton3 != null) {
            bindDtElement(imageButton3);
        }
    }

    @Override // com.tencent.richframework.gallery.part.NTAIOLayerBasePart, com.tencent.richframework.gallery.part.RFWLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        RFWLayerFileDownloadState.FileState fileState;
        ImageButton imageButton;
        int i3 = 0;
        String str = null;
        if (event instanceof RFWLayerFileStateChangeEvent) {
            RFWLayerFileStateChangeEvent rFWLayerFileStateChangeEvent = (RFWLayerFileStateChangeEvent) event;
            RFWLayerFileDownloadState rFWLayerFileDownloadState = rFWLayerFileStateChangeEvent.mState;
            if (rFWLayerFileDownloadState != null) {
                fileState = rFWLayerFileDownloadState.getFileState();
            } else {
                fileState = null;
            }
            if (fileState == RFWLayerFileDownloadState.FileState.DOWNLOAD_SUCCESS) {
                String mediaId = rFWLayerFileStateChangeEvent.mState.getMediaId();
                RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
                if (rFWLayerItemMediaInfo != null) {
                    str = rFWLayerItemMediaInfo.getMediaId();
                }
                if (TextUtils.equals(mediaId, str) && (imageButton = this.mSaveBtn) != null) {
                    imageButton.setVisibility(0);
                    return;
                }
                return;
            }
            return;
        }
        if (event instanceof HideSaveView) {
            HideSaveView hideSaveView = (HideSaveView) event;
            if (!TextUtils.isEmpty(hideSaveView.getMediaId())) {
                String mediaId2 = hideSaveView.getMediaId();
                RFWLayerItemMediaInfo rFWLayerItemMediaInfo2 = this.mCurrentSelectedItem;
                if (rFWLayerItemMediaInfo2 != null) {
                    str = rFWLayerItemMediaInfo2.getMediaId();
                }
                if (Intrinsics.areEqual(mediaId2, str)) {
                    ImageButton imageButton2 = this.mSaveBtn;
                    if (imageButton2 != null) {
                        if (hideSaveView.isHide()) {
                            i3 = 4;
                        }
                        imageButton2.setVisibility(i3);
                        return;
                    }
                    return;
                }
            }
            ImageButton imageButton3 = this.mSaveBtn;
            if (imageButton3 != null) {
                imageButton3.setVisibility(0);
                return;
            }
            return;
        }
        if (event instanceof SaveToAlbumEvent) {
            SaveToAlbumEvent saveToAlbumEvent = (SaveToAlbumEvent) event;
            doSaveToAlbum(saveToAlbumEvent.getMediaId(), saveToAlbumEvent.getHashCode());
        }
    }

    private final void doSaveToAlbum(String mediaId, int hashCode) {
        boolean equals$default;
        if (TextUtils.isEmpty(mediaId)) {
            return;
        }
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        equals$default = StringsKt__StringsJVMKt.equals$default(mediaId, rFWLayerItemMediaInfo != null ? rFWLayerItemMediaInfo.getMediaId() : null, false, 2, null);
        if (equals$default && hashCode == getActivity().hashCode()) {
            doSaveToAlbum();
        }
    }
}
