package com.tencent.qqnt.aio.gallery.part;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.luggage.wxa.gh.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.QAdCardExtraData;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqnt.aio.gallery.section.NTAIOLayerProgressSection;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.richframework.gallery.RFWLayerIOCUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.delegate.INTLayerOperationListener;
import com.tencent.richframework.gallery.delegate.outer.IDelegateAndSectionProvider;
import com.tencent.richframework.gallery.delegate.outer.ILayerOperationListener;
import com.tencent.richframework.gallery.part.NTAIOLayerBasePart;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0007\u00a2\u0006\u0004\b6\u00107J\u001a\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016J\b\u0010\u0017\u001a\u00020\tH\u0016J\b\u0010\u0018\u001a\u00020\tH\u0016J\b\u0010\u0019\u001a\u00020\tH\u0016J\b\u0010\u001a\u001a\u00020\tH\u0016J\b\u0010\u001b\u001a\u00020\tH\u0016J\b\u0010\u001c\u001a\u00020\tH\u0016J\b\u0010\u001d\u001a\u00020\tH\u0016J\b\u0010\u001e\u001a\u00020\tH\u0016R0\u0010%\u001a\u001e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001fj\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!`\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R&\u0010/\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0*0+0*8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b-\u0010.R(\u00103\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020,01000*8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b2\u0010.R(\u00105\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020,01000*8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b4\u0010.\u00a8\u00068"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/part/r;", "Lcom/tencent/richframework/gallery/part/NTAIOLayerBasePart;", "Lcom/tencent/richframework/gallery/delegate/outer/IDelegateAndSectionProvider;", "Lcom/tencent/richframework/gallery/delegate/outer/ILayerOperationListener;", "Lcom/tencent/richframework/gallery/delegate/INTLayerOperationListener;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "onLayerStateUpdate", e.a.NAME, "onDragClose", "", "isClickToExit", "onSingleClick", "onDoubleClick", "onZoomScaleChangeEnd", "clickSaveBtn", "clickShowHistoryBtn", "clickShowMoreBtn", "clickCloseVideoBtn", "clickShowOriginPicBtn", "onOriginBtnShow", "onOriginBtnHide", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "d", "Ljava/util/HashMap;", QAdCardExtraData.AdExtraInnerKey.AD_EXTRA_KEY_PAGE_PARAMS, "", "e", "J", "originPicShowTime", "", "Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegate;", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "getExtDelegates", "()Ljava/util/List;", "extDelegates", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "getExtPicSections", "extPicSections", "getExtVideoSections", "extVideoSections", "<init>", "()V", "base_proj_nt_ext_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public class r extends NTAIOLayerBasePart implements IDelegateAndSectionProvider, ILayerOperationListener, INTLayerOperationListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, Object> pageParams;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long originPicShowTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/aio/gallery/part/r$a", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "", "onPreDraw", "base_proj_nt_ext_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class a implements ViewTreeObserver.OnPreDrawListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f350112d;

        a(View view) {
            this.f350112d = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            }
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            this.f350112d.getViewTreeObserver().removeOnPreDrawListener(this);
            com.tencent.qqnt.trace.r.f362387a.findStream("GALLERY_PAGE").tagNode("SHOW_LIST");
            return true;
        }
    }

    public r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.pageParams = new HashMap<>();
        }
    }

    @Override // com.tencent.richframework.gallery.delegate.INTLayerOperationListener
    public void clickCloseVideoBtn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            com.tencent.qqnt.aio.gallery.f.f349999a.a(this.pageParams, "em_bas_shut_down");
        }
    }

    @Override // com.tencent.richframework.gallery.delegate.INTLayerOperationListener
    public void clickSaveBtn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else if (isCurrentSelectVideo()) {
            com.tencent.qqnt.aio.gallery.f.f349999a.a(this.pageParams, "em_bas_download_video");
        } else {
            com.tencent.qqnt.aio.gallery.f.f349999a.a(this.pageParams, "em_bas_download_picture");
        }
    }

    @Override // com.tencent.richframework.gallery.delegate.INTLayerOperationListener
    public void clickShowHistoryBtn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            com.tencent.qqnt.aio.gallery.f.f349999a.a(this.pageParams, "em_bas_precipitation");
        }
    }

    @Override // com.tencent.richframework.gallery.delegate.INTLayerOperationListener
    public void clickShowMoreBtn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            com.tencent.qqnt.aio.gallery.f.f349999a.a(this.pageParams, WinkDaTongReportConstant.ElementId.EM_BAS_SHARE);
        }
    }

    @Override // com.tencent.richframework.gallery.delegate.INTLayerOperationListener
    public void clickShowOriginPicBtn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            com.tencent.qqnt.aio.gallery.f.f349999a.a(this.pageParams, "em_bas_view_the_original_picture");
        }
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.IDelegateAndSectionProvider
    @NotNull
    public List<AdapterDelegate<List<RFWLayerItemMediaInfo>>> getExtDelegates() {
        List<AdapterDelegate<List<RFWLayerItemMediaInfo>>> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return (List) iPatchRedirector.redirect((short) 4, (Object) this);
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.IDelegateAndSectionProvider
    @NotNull
    public List<Class<? extends Section<RFWLayerItemMediaInfo>>> getExtPicSections() {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(com.tencent.qqnt.aio.gallery.section.b.class, NTAIOLayerProgressSection.class);
            return arrayListOf;
        }
        return (List) iPatchRedirector.redirect((short) 5, (Object) this);
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.IDelegateAndSectionProvider
    @NotNull
    public List<Class<? extends Section<RFWLayerItemMediaInfo>>> getExtVideoSections() {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(com.tencent.qqnt.aio.gallery.section.e.class, NTAIOLayerProgressSection.class);
            return arrayListOf;
        }
        return (List) iPatchRedirector.redirect((short) 6, (Object) this);
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.ILayerOperationListener
    public void onDoubleClick() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            if (isCurrentSelectVideo()) {
                return;
            }
            com.tencent.qqnt.aio.gallery.f.f349999a.d(this.pageParams, 1);
        }
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.ILayerOperationListener
    public void onDragClose() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            if (isCurrentSelectVideo()) {
                return;
            }
            com.tencent.qqnt.aio.gallery.f.f349999a.d(this.pageParams, 5);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        rootView.getViewTreeObserver().addOnPreDrawListener(new a(rootView));
        Context context = rootView.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        VideoReport.addToDetectionWhitelist((Activity) context);
        VideoReport.setPageReportPolicy(rootView, PageReportPolicy.REPORT_NONE);
        RFWLayerIOCUtil.registerSectionProvider(rootView, this);
        RFWLayerIOCUtil.registerLayerOperationListener(rootView, this);
        RFWIocAbilityProvider.g().registerIoc(rootView, this, INTLayerOperationListener.class);
    }

    @Override // com.tencent.richframework.gallery.part.NTAIOLayerBasePart
    public void onLayerStateUpdate(@NotNull RFWLayerState layerState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) layerState);
            return;
        }
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        super.onLayerStateUpdate(layerState);
        if (this.mCurrentSelectedItem != null && getMCurrentSelectedMessage() != null) {
            VideoReport.setPageId(getPartRootView(), getPageId());
            com.tencent.qqnt.aio.gallery.b bVar = com.tencent.qqnt.aio.gallery.b.f349994a;
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
            Intrinsics.checkNotNull(rFWLayerItemMediaInfo);
            Pair<Long, Integer> a16 = bVar.a(rFWLayerItemMediaInfo);
            if (a16 == null) {
                return;
            }
            this.pageParams.clear();
            HashMap<String, Object> hashMap = this.pageParams;
            MsgRecord mCurrentSelectedMessage = getMCurrentSelectedMessage();
            Intrinsics.checkNotNull(mCurrentSelectedMessage);
            hashMap.put("transmission_mode", Integer.valueOf(com.tencent.qqnt.aio.gallery.e.a(mCurrentSelectedMessage, a16.getSecond().intValue())));
            HashMap<String, Object> hashMap2 = this.pageParams;
            MsgRecord mCurrentSelectedMessage2 = getMCurrentSelectedMessage();
            Intrinsics.checkNotNull(mCurrentSelectedMessage2);
            hashMap2.put("aio_type", Integer.valueOf(mCurrentSelectedMessage2.chatType));
            this.pageParams.put("qq_pgid", getPageId());
            VideoReport.setPageParams(getPartRootView(), new PageParams(this.pageParams));
        }
    }

    @Override // com.tencent.richframework.gallery.delegate.INTLayerOperationListener
    public void onLongPress() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            com.tencent.qqnt.aio.gallery.f.f349999a.d(this.pageParams, 2);
        }
    }

    @Override // com.tencent.richframework.gallery.delegate.INTLayerOperationListener
    public void onOriginBtnHide() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            com.tencent.qqnt.aio.gallery.f.f349999a.c(this.pageParams, System.currentTimeMillis() - this.originPicShowTime, "em_bas_view_the_original_picture");
        }
    }

    @Override // com.tencent.richframework.gallery.delegate.INTLayerOperationListener
    public void onOriginBtnShow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            this.originPicShowTime = System.currentTimeMillis();
            com.tencent.qqnt.aio.gallery.f.f349999a.b(this.pageParams, "em_bas_view_the_original_picture");
        }
    }

    @Override // com.tencent.richframework.gallery.part.NTAIOLayerBasePart, com.tencent.richframework.gallery.part.RFWLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        com.tencent.qqnt.trace.r.f362387a.findStream("GALLERY_PAGE").tagNode("PAGE_INIT");
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.ILayerOperationListener
    public void onSingleClick(boolean isClickToExit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, isClickToExit);
        }
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.ILayerOperationListener
    public void onZoomScaleChangeEnd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            if (isCurrentSelectVideo()) {
                return;
            }
            com.tencent.qqnt.aio.gallery.f.f349999a.d(this.pageParams, 4);
        }
    }
}
