package com.tencent.mobileqq.richmedia.part;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.richmedia.event.FileVideoDownloadFinishEvent;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.gallery.RFWLayerIOCUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.delegate.inner.IVideoPlayerProvider;
import com.tencent.richframework.gallery.part.RFWLayerBasePart;
import com.tencent.richframework.gallery.widget.RFWGalleryViewPager;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004B\u0007\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0014J\u001a\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0013\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0016J\u0014\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00170\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\bH\u0016J\b\u0010\u001b\u001a\u00020\u0006H\u0016J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010 \u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0006\u0010!\u001a\u00020\u0006R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u0004\u0018\u00010*8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b+\u0010,\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/richmedia/part/g;", "Lcom/tencent/richframework/gallery/part/RFWLayerBasePart;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/richframework/gallery/widget/RFWGalleryViewPager$OnItemLongClickListener;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "A9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "updateLayerState", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "v", NodeProps.ON_CLICK, "x9", "", "position", "onItemLongClick", "onItemLongClickCancel", "onItemLongClickUp", "z9", "Landroid/widget/ImageButton;", "d", "Landroid/widget/ImageButton;", "mMoreBtn", "Lcom/tencent/richframework/gallery/widget/RFWGalleryViewPager;", "e", "Lcom/tencent/richframework/gallery/widget/RFWGalleryViewPager;", "mViewPagerRoot", "Lcom/tencent/richframework/gallery/delegate/inner/IVideoPlayerProvider;", "getMLayerVideoControlProvider", "()Lcom/tencent/richframework/gallery/delegate/inner/IVideoPlayerProvider;", "mLayerVideoControlProvider", "<init>", "()V", "RichMediaBrowser_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public class g extends RFWLayerBasePart implements View.OnClickListener, RFWGalleryViewPager.OnItemLongClickListener, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageButton mMoreBtn;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RFWGalleryViewPager mViewPagerRoot;

    private final void A9() {
        com.tencent.mobileqq.richmedia.e eVar = com.tencent.mobileqq.richmedia.e.f281568a;
        String name = com.tencent.mobileqq.richmedia.depend.e.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "IRichMediaShareDepend::class.java.name");
        com.tencent.mobileqq.richmedia.depend.c d16 = eVar.d(name);
        if (d16 instanceof com.tencent.mobileqq.richmedia.depend.e) {
            if (((com.tencent.mobileqq.richmedia.depend.e) d16).C6(this.mCurrentSelectedItem)) {
                ImageButton imageButton = this.mMoreBtn;
                if (imageButton != null) {
                    imageButton.setVisibility(0);
                    return;
                }
                return;
            }
            ImageButton imageButton2 = this.mMoreBtn;
            if (imageButton2 != null) {
                imageButton2.setVisibility(8);
            }
        }
    }

    private final IVideoPlayerProvider getMLayerVideoControlProvider() {
        View rootView = getPartRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        return RFWLayerIOCUtil.getVideoControlProvider(rootView);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(FileVideoDownloadFinishEvent.class);
        return arrayList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        String mediaId;
        com.tencent.mobileqq.richmedia.depend.a aVar;
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (v3.getId() == R.id.zvd) {
            x9();
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
                    aVar.B8(mediaId);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        ImageButton imageButton = (ImageButton) rootView.findViewById(R.id.zvd);
        this.mMoreBtn = imageButton;
        if (imageButton != null) {
            imageButton.setOnClickListener(this);
        }
        ImageButton imageButton2 = this.mMoreBtn;
        if (imageButton2 != null) {
            imageButton2.setVisibility(0);
        }
        RFWGalleryViewPager rFWGalleryViewPager = (RFWGalleryViewPager) rootView.findViewById(R.id.f73943ux);
        this.mViewPagerRoot = rFWGalleryViewPager;
        if (rFWGalleryViewPager != null) {
            rFWGalleryViewPager.setOnItemLongClickListener(this);
        }
    }

    public void onItemLongClick(int position) {
        x9();
    }

    @Override // com.tencent.richframework.gallery.part.RFWLayerBasePart, com.tencent.biz.richframework.part.Part
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
        String str;
        if (event instanceof FileVideoDownloadFinishEvent) {
            FileVideoDownloadFinishEvent fileVideoDownloadFinishEvent = (FileVideoDownloadFinishEvent) event;
            if (!TextUtils.isEmpty(fileVideoDownloadFinishEvent.getMediaId())) {
                String mediaId = fileVideoDownloadFinishEvent.getMediaId();
                RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
                if (rFWLayerItemMediaInfo != null) {
                    str = rFWLayerItemMediaInfo.getMediaId();
                } else {
                    str = null;
                }
                if (TextUtils.equals(mediaId, str)) {
                    A9();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.richframework.gallery.part.RFWLayerBasePart
    public void updateLayerState(@NotNull RFWLayerState layerState) {
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        A9();
    }

    public final void z9() {
        IVideoPlayerProvider mLayerVideoControlProvider;
        IVideoPlayerProvider mLayerVideoControlProvider2 = getMLayerVideoControlProvider();
        boolean z16 = false;
        if (mLayerVideoControlProvider2 != null && mLayerVideoControlProvider2.isPlaying()) {
            z16 = true;
        }
        if (z16) {
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
            Intrinsics.checkNotNull(rFWLayerItemMediaInfo);
            if (rFWLayerItemMediaInfo.isVideo() && (mLayerVideoControlProvider = getMLayerVideoControlProvider()) != null) {
                mLayerVideoControlProvider.stop();
            }
        }
    }

    public void x9() {
    }

    public void onItemLongClickCancel(int position) {
    }

    public void onItemLongClickUp(int position) {
    }
}
