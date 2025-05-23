package com.tencent.mobileqq.hermes.layer.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.hermes.layer.HermesPreviewLayerFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.QQGalleryActivity;
import com.tencent.richframework.gallery.RFWLayerIOCUtil;
import com.tencent.richframework.gallery.RFWLayerLaunchUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.delegate.outer.IDelegateAndSectionProvider;
import com.tencent.richframework.gallery.item.delegate.RFWLayerCardItemDelegate;
import com.tencent.richframework.gallery.item.section.ClickPicEvent;
import com.tencent.richframework.gallery.part.RFWLayerBasePart;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u001a\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0012\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J$\u0010\u0016\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00140\u0013j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0014`\u0015H\u0016R&\u0010\u001c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00170\u00180\u00178VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR(\u0010\u001f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00190\u001d0\u00140\u00178VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001bR(\u0010!\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00190\u001d0\u00140\u00178VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010\u001b\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/hermes/layer/part/a;", "Lcom/tencent/richframework/gallery/part/RFWLayerBasePart;", "Lcom/tencent/richframework/gallery/delegate/outer/IDelegateAndSectionProvider;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/richframework/gallery/item/section/ClickPicEvent;", "event", "", "x9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onReceiveEvent", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "", "Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegate;", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "getExtDelegates", "()Ljava/util/List;", "extDelegates", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "getExtPicSections", "extPicSections", "getExtVideoSections", "extVideoSections", "<init>", "()V", "hermes-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class a extends RFWLayerBasePart implements IDelegateAndSectionProvider, SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void x9(ClickPicEvent event) {
        List<RFWLayerItemMediaInfo> list;
        RFWLayerState data;
        UIStateData<RFWLayerState> value = getMLayerViewModel().mRichMediaInfo.getValue();
        if (value != null && (data = value.getData()) != null) {
            list = data.getRichMediaDataList();
        } else {
            list = null;
        }
        List<RFWLayerItemMediaInfo> list2 = list;
        if (list2 != null) {
            RFWLayerLaunchUtil.jumpToGallery$default(event.getImageView(), list2, list2.indexOf(event.getData()), QQGalleryActivity.class, HermesPreviewLayerFragment.class, new Bundle(), 0, 64, null);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(ClickPicEvent.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 9, (Object) this);
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.IDelegateAndSectionProvider
    @NotNull
    public List<AdapterDelegate<List<RFWLayerItemMediaInfo>>> getExtDelegates() {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new RFWLayerCardItemDelegate(getExtPicSections()));
            return arrayListOf;
        }
        return (List) iPatchRedirector.redirect((short) 3, (Object) this);
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.IDelegateAndSectionProvider
    @NotNull
    public List<Class<? extends Section<RFWLayerItemMediaInfo>>> getExtPicSections() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new ArrayList();
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.IDelegateAndSectionProvider
    @NotNull
    public List<Class<? extends Section<RFWLayerItemMediaInfo>>> getExtVideoSections() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new ArrayList();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        RFWLayerIOCUtil.registerPicLoader(rootView, QQPicLoader.f201806a.d());
        RFWLayerIOCUtil.registerSectionProvider(rootView, this);
        rootView.setBackground(ResourcesCompat.getDrawable(rootView.getResources(), R.drawable.qui_common_bg_bottom_brand_bg, null));
    }

    @Override // com.tencent.richframework.gallery.part.RFWLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity);
        } else {
            super.onPartDestroy(activity);
            SimpleEventBus.getInstance().unRegisterReceiver(this);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@NotNull SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) event);
            return;
        }
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof ClickPicEvent) {
            x9((ClickPicEvent) event);
        }
    }
}
