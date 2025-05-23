package com.qzone.reborn.albumx.qzonex.part.albumdetail;

import android.app.Activity;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.albumx.common.bean.CommonGridItemData;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonPageEndMsg;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.albumx.common.convert.bean.CommonStTimeLineEvent;
import com.qzone.reborn.albumx.common.part.CommonAlbumDetailBodyPart;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxMainPageInitBean;
import com.qzone.reborn.albumx.qzonex.event.QZAlbumxUpdateAlbumEvent;
import com.qzone.reborn.albumx.qzonex.event.QZAlbumxUploadAlbumEvent;
import com.qzone.reborn.feedx.block.aa;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.component.animator.ScanningLightView;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.tuxmeterqui.config.TuxUIConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000\u00dc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004B\u0007\u00a2\u0006\u0004\b`\u0010aJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J(\u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rH\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0002J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0007H\u0002J\b\u0010\u0015\u001a\u00020\u0007H\u0002J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0019H\u0002J*\u0010!\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0002J\b\u0010\"\u001a\u00020\u0007H\u0002J\b\u0010#\u001a\u00020\u001bH\u0016J\u001c\u0010(\u001a\u00020\u00072\b\u0010%\u001a\u0004\u0018\u00010$2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016J\"\u0010.\u001a\b\u0012\u0004\u0012\u00020-0*2\u0012\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0*0)H\u0016J\u0010\u0010/\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u00101\u001a\u000200H\u0016J\u0012\u00102\u001a\u00020\u00072\b\u0010%\u001a\u0004\u0018\u00010$H\u0016J$\u00104\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0003030\u000bj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000303`\rH\u0016J\u0012\u00105\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u00106\u001a\u00020\u0007H\u0016J\b\u00108\u001a\u000207H\u0016J\u001c\u00109\u001a\u00020\u00072\u0012\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0*0)H\u0016J\b\u0010:\u001a\u00020\u0007H\u0016J\u001c\u0010;\u001a\u00020\u00072\u0012\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0*0)H\u0016J\u001c\u0010<\u001a\u00020\u00072\u0012\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0*0)H\u0016J\b\u0010=\u001a\u00020\u0007H\u0016J\u001c\u0010A\u001a\u00020\u00072\b\u0010>\u001a\u0004\u0018\u00010\u001b2\b\u0010@\u001a\u0004\u0018\u00010?H\u0016J\u0010\u0010D\u001a\u00020\u00072\u0006\u0010C\u001a\u00020BH\u0016J0\u0010L\u001a\u00020\u00072\u0006\u0010E\u001a\u00020+2\u0006\u0010F\u001a\u00020\t2\u0006\u0010H\u001a\u00020G2\u0006\u0010I\u001a\u00020\t2\u0006\u0010K\u001a\u00020JH\u0016R\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010V\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010NR\u0018\u0010Z\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR \u0010_\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\\0[8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b]\u0010^\u00a8\u0006b"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/albumdetail/QZAlbumxAlbumDetailBodyPart;", "Lcom/qzone/reborn/albumx/common/part/CommonAlbumDetailBodyPart;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lua/a;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "Oa", "", "pageType", "Ljava/util/ArrayList;", "Lxa/a;", "Lkotlin/collections/ArrayList;", "data", "Xa", "initData", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "it", "Wa", "Ra", "Ta", "Lcom/qzone/reborn/albumx/qzonex/event/QZAlbumxUploadAlbumEvent;", "event", "Ga", "Lcom/qzone/reborn/albumx/qzonex/event/QZAlbumxUpdateAlbumEvent;", "Ja", "", "errorTitle", "errorSubTips", TuxUIConstants.POP_BTN_TEXT, "Landroid/view/View$OnClickListener;", "clickListener", "Ka", "Qa", "getLogTag", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lcom/qzone/reborn/albumx/common/bean/a;", "uiStateData", "Lcom/qzone/reborn/albumx/common/bean/CommonGridItemData;", "ra", "onInitView", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "Y9", "onPartDestroy", "Ljava/lang/Class;", "getEventClass", "onReceiveEvent", "ba", "Lcom/qzone/reborn/feedx/block/aa;", "H9", "sa", HippyScrollViewEventHelper.EVENT_TYPE_REFRESH, "V9", "pa", "U6", "action", "", "args", "handleBroadcastMessage", "", "hasPreview", "h6", "batchBean", "batchPos", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", QAdVrReportParams.ParamKey.MEDIA, "mediaPos", "Landroid/widget/ImageView;", "view", "A8", "Lnc/y;", "I", "Lnc/y;", "viewModel", "Lcom/google/android/material/appbar/AppBarLayout;", "J", "Lcom/google/android/material/appbar/AppBarLayout;", "appBarLayout", "K", "curVerticalOffset", "Landroid/widget/FrameLayout;", "L", "Landroid/widget/FrameLayout;", "loadingViewContainer", "", "Lta/b;", "M", "Ljava/util/Map;", "headAdapters", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class QZAlbumxAlbumDetailBodyPart extends CommonAlbumDetailBodyPart implements SimpleEventReceiver<SimpleBaseEvent>, ua.a {

    /* renamed from: I, reason: from kotlin metadata */
    private nc.y viewModel;

    /* renamed from: J, reason: from kotlin metadata */
    private AppBarLayout appBarLayout;

    /* renamed from: K, reason: from kotlin metadata */
    private int curVerticalOffset = -1;

    /* renamed from: L, reason: from kotlin metadata */
    private FrameLayout loadingViewContainer;

    /* renamed from: M, reason: from kotlin metadata */
    private final Map<Integer, ta.b> headAdapters;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/qzone/reborn/albumx/qzonex/part/albumdetail/QZAlbumxAlbumDetailBodyPart$a", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx5, int dy5) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx5, dy5);
            int f16 = QZAlbumxAlbumDetailBodyPart.this.P9().f();
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            nc.y yVar = null;
            LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
            if (linearLayoutManager == null) {
                return;
            }
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int findFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
            if (findFirstVisibleItemPosition == -1) {
                return;
            }
            if (!QZAlbumxAlbumDetailBodyPart.this.P9().j(findFirstVisibleItemPosition)) {
                nc.y yVar2 = QZAlbumxAlbumDetailBodyPart.this.viewModel;
                if (yVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    yVar2 = null;
                }
                xa.b value = yVar2.y2().getValue();
                if (value != null) {
                    value.c(QZAlbumxAlbumDetailBodyPart.this.P9().e(findFirstVisibleItemPosition));
                    value.d(findFirstVisibleItemPosition > f16 || findFirstCompletelyVisibleItemPosition > f16);
                    nc.y yVar3 = QZAlbumxAlbumDetailBodyPart.this.viewModel;
                    if (yVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    } else {
                        yVar = yVar3;
                    }
                    yVar.y2().postValue(value);
                    return;
                }
                return;
            }
            xa.b bVar = new xa.b();
            bVar.c(QZAlbumxAlbumDetailBodyPart.this.P9().e(findFirstVisibleItemPosition));
            bVar.d(findFirstVisibleItemPosition > f16 || findFirstCompletelyVisibleItemPosition > f16);
            nc.y yVar4 = QZAlbumxAlbumDetailBodyPart.this.viewModel;
            if (yVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                yVar = yVar4;
            }
            yVar.y2().postValue(bVar);
        }
    }

    public QZAlbumxAlbumDetailBodyPart() {
        Map<Integer, ta.b> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(new Pair(2, new ta.a()), new Pair(3, new ta.e()), new Pair(5, new ta.d()), new Pair(4, new ta.c()));
        this.headAdapters = mapOf;
    }

    private final void Ga(QZAlbumxUploadAlbumEvent event) {
        QLog.d(getTAG(), 1, "[handleAlbumUploadSuccessEvent] albumId = " + event.getAlbumId() + " succeedCount = " + event.getSucceedCount());
        K9().b2(false);
        com.qzone.reborn.albumx.qzonex.utils.c cVar = com.qzone.reborn.albumx.qzonex.utils.c.f53402a;
        nc.y yVar = this.viewModel;
        if (yVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            yVar = null;
        }
        CommonAlbumInfo value = yVar.M1().getValue();
        int c16 = cVar.c(value != null ? Integer.valueOf(value.getQzAlbumType()) : null);
        if (c16 == 2 || c16 == 3 || c16 == 4) {
            com.qzone.reborn.util.o.f59556a.d(HardCodeUtil.qqStr(R.string.fwp), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ha(QZAlbumxAlbumDetailBodyPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.S9().scrollToPosition(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ia(QZAlbumxAlbumDetailBodyPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.qzone.reborn.albumx.qzonex.utils.k kVar = com.qzone.reborn.albumx.qzonex.utils.k.f53414a;
        if (kVar.c(this$0.S9()) && kVar.b(this$0.S9())) {
            nc.y yVar = this$0.viewModel;
            AppBarLayout appBarLayout = null;
            if (yVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                yVar = null;
            }
            yVar.d3(false);
            this$0.K9().b2(false);
            AppBarLayout appBarLayout2 = this$0.appBarLayout;
            if (appBarLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("appBarLayout");
                appBarLayout2 = null;
            }
            appBarLayout2.setExpanded(false);
            AppBarLayout appBarLayout3 = this$0.appBarLayout;
            if (appBarLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("appBarLayout");
            } else {
                appBarLayout = appBarLayout3;
            }
            appBarLayout.setExpanded(true);
            this$0.S9().stopScroll();
            this$0.S9().scrollToPosition(0);
        }
    }

    private final void Ja(QZAlbumxUpdateAlbumEvent event) {
        QLog.d(getTAG(), 1, "[handleUpdateAlbumEvent] albumId = " + event.getAlbumId());
        K9().b2(false);
    }

    private final void Ka(String errorTitle, String errorSubTips, String btnText, View.OnClickListener clickListener) {
        N9().setData(com.qzone.reborn.feedx.util.k.m(getContext(), errorTitle, errorSubTips, btnText, clickListener));
        QLog.d(getTAG(), 1, "[initBlankViewData] errorTitle = " + errorTitle + " errorSubTips = " + errorSubTips);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void La(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ma(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Na(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [T, android.view.View] */
    private final void Oa(View rootView) {
        if (this.loadingViewContainer == null) {
            this.loadingViewContainer = (FrameLayout) rootView.findViewById(R.id.nfg);
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? findViewById = rootView.findViewById(R.id.nff);
        objectRef.element = findViewById;
        ScanningLightView scanningLightView = (ScanningLightView) findViewById;
        if (scanningLightView != null) {
            scanningLightView.post(new Runnable() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.f
                @Override // java.lang.Runnable
                public final void run() {
                    QZAlbumxAlbumDetailBodyPart.Pa(Ref.ObjectRef.this, this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void Pa(Ref.ObjectRef loadingView, QZAlbumxAlbumDetailBodyPart this$0) {
        ViewGroup.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(loadingView, "$loadingView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Drawable drawable = ((ScanningLightView) loadingView.element).getDrawable();
        if (drawable == null) {
            return;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        int width = ((ScanningLightView) loadingView.element).getWidth();
        QLog.i(this$0.getTAG(), 1, "ScreenWidth : " + pl.a.f426446a.o(((ScanningLightView) loadingView.element).getContext()) + ", ViewWidth:" + width + ", imageWidth:" + intrinsicWidth);
        if (intrinsicWidth == 0 || width == 0) {
            return;
        }
        float f16 = width / intrinsicWidth;
        Matrix matrix = new Matrix();
        matrix.postScale(f16, f16);
        ((ScanningLightView) loadingView.element).setImageMatrix(matrix);
        FrameLayout frameLayout = this$0.loadingViewContainer;
        if (frameLayout != null) {
            frameLayout.bringToFront();
        }
        ((ScanningLightView) loadingView.element).setVisibility(0);
        FrameLayout frameLayout2 = this$0.loadingViewContainer;
        if (frameLayout2 != null && (layoutParams = frameLayout2.getLayoutParams()) != null) {
            layoutParams.height = (int) (f16 * intrinsicHeight);
            FrameLayout frameLayout3 = this$0.loadingViewContainer;
            if (frameLayout3 != null) {
                frameLayout3.setLayoutParams(layoutParams);
            }
        }
        FrameLayout frameLayout4 = this$0.loadingViewContainer;
        if (frameLayout4 == null) {
            return;
        }
        frameLayout4.setVisibility(0);
    }

    private final void Qa() {
        String uinString = LoginData.getInstance().getUinString();
        Intrinsics.checkNotNullExpressionValue(uinString, "getInstance().uinString");
        QZAlbumxMainPageInitBean qZAlbumxMainPageInitBean = new QZAlbumxMainPageInitBean(uinString);
        vb.b x16 = ho.i.x();
        Intrinsics.checkNotNullExpressionValue(x16, "qzAlbumx()");
        vb.b.j(x16, getContext(), qZAlbumxMainPageInitBean, null, 4, null);
        getActivity().finish();
    }

    private final void Ra() {
        AppBarLayout appBarLayout = this.appBarLayout;
        if (appBarLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appBarLayout");
            appBarLayout = null;
        }
        appBarLayout.e(new AppBarLayout.g() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.g
            @Override // com.google.android.material.appbar.AppBarLayout.c
            public final void onOffsetChanged(AppBarLayout appBarLayout2, int i3) {
                QZAlbumxAlbumDetailBodyPart.Sa(QZAlbumxAlbumDetailBodyPart.this, appBarLayout2, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sa(QZAlbumxAlbumDetailBodyPart this$0, AppBarLayout appBarLayout, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.curVerticalOffset == i3) {
            return;
        }
        this$0.curVerticalOffset = i3;
        if (i3 >= 0) {
            nc.y yVar = this$0.viewModel;
            nc.y yVar2 = null;
            if (yVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                yVar = null;
            }
            if (yVar.getIsTimeLine()) {
                nc.y yVar3 = this$0.viewModel;
                if (yVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    yVar3 = null;
                }
                yVar3.d3(false);
                nc.y yVar4 = this$0.viewModel;
                if (yVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    yVar2 = yVar4;
                }
                yVar2.b2(false);
                this$0.S9().stopScroll();
                this$0.S9().scrollToPosition(0);
            }
        }
    }

    private final void Ta() {
        S9().addOnScrollListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ua(QZAlbumxAlbumDetailBodyPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Qa();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Va(QZAlbumxAlbumDetailBodyPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.N9().s0();
        this$0.ea();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Wa(CommonAlbumInfo it) {
        ArrayList<xa.a> arrayListOf;
        int c16 = com.qzone.reborn.albumx.qzonex.utils.c.f53402a.c(Integer.valueOf(it.getQzAlbumType()));
        nc.y yVar = this.viewModel;
        nc.y yVar2 = null;
        if (yVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            yVar = null;
        }
        if (yVar.getIsTimeLine()) {
            Xa(c16, new ArrayList<>());
            return;
        }
        xa.a[] aVarArr = new xa.a[1];
        nc.y yVar3 = this.viewModel;
        if (yVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            yVar3 = null;
        }
        nc.y yVar4 = this.viewModel;
        if (yVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            yVar2 = yVar4;
        }
        aVarArr[0] = yVar3.r2(it, yVar2.T1().getValue());
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(aVarArr);
        Xa(c16, arrayListOf);
        if (this.headAdapters.get(Integer.valueOf(c16)) != null && S9().getVisibility() != 0) {
            S9().setVisibility(0);
        }
        broadcastMessage("update_page_pref_report_scene", String.valueOf(it.getQzAlbumType()));
    }

    private final void Xa(int pageType, ArrayList<xa.a> data) {
        ta.b bVar;
        ta.b bVar2;
        Iterator<T> it = this.headAdapters.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            int intValue = ((Number) it.next()).intValue();
            ta.b bVar3 = this.headAdapters.get(Integer.valueOf(intValue));
            List<xa.a> items = bVar3 != null ? bVar3.getItems() : null;
            if ((items != null && (items.isEmpty() ^ true)) && (bVar2 = this.headAdapters.get(Integer.valueOf(intValue))) != null) {
                bVar2.setItems(new ArrayList());
            }
        }
        if (!(!data.isEmpty()) || (bVar = this.headAdapters.get(Integer.valueOf(pageType))) == null) {
            return;
        }
        bVar.setItems(data);
    }

    private final void initData() {
        com.qzone.reborn.albumx.common.viewmodel.b K9 = K9();
        Intrinsics.checkNotNull(K9, "null cannot be cast to non-null type com.qzone.reborn.albumx.qzonex.viewmodel.QZAlbumxAlbumDetailViewModel");
        nc.y yVar = (nc.y) K9;
        this.viewModel = yVar;
        nc.y yVar2 = null;
        if (yVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            yVar = null;
        }
        MutableLiveData<CommonAlbumInfo> M1 = yVar.M1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<CommonAlbumInfo, Unit> function1 = new Function1<CommonAlbumInfo, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.QZAlbumxAlbumDetailBodyPart$initData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CommonAlbumInfo commonAlbumInfo) {
                invoke2(commonAlbumInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CommonAlbumInfo it) {
                QZAlbumxAlbumDetailBodyPart qZAlbumxAlbumDetailBodyPart = QZAlbumxAlbumDetailBodyPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qZAlbumxAlbumDetailBodyPart.Wa(it);
            }
        };
        M1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumxAlbumDetailBodyPart.La(Function1.this, obj);
            }
        });
        nc.y yVar3 = this.viewModel;
        if (yVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            yVar3 = null;
        }
        MutableLiveData<Boolean> S2 = yVar3.S2();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.QZAlbumxAlbumDetailBodyPart$initData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (it.booleanValue()) {
                    return;
                }
                nc.y yVar4 = QZAlbumxAlbumDetailBodyPart.this.viewModel;
                if (yVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    yVar4 = null;
                }
                CommonAlbumInfo value = yVar4.M1().getValue();
                if (value == null) {
                    return;
                }
                QZAlbumxAlbumDetailBodyPart.this.Wa(value);
            }
        };
        S2.observe(lifecycleOwner2, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumxAlbumDetailBodyPart.Ma(Function1.this, obj);
            }
        });
        nc.y yVar4 = this.viewModel;
        if (yVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            yVar2 = yVar4;
        }
        MutableLiveData<UIStateData<List<com.qzone.reborn.albumx.common.bean.a>>> O1 = yVar2.O1();
        LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
        final QZAlbumxAlbumDetailBodyPart$initData$3 qZAlbumxAlbumDetailBodyPart$initData$3 = new QZAlbumxAlbumDetailBodyPart$initData$3(this);
        O1.observe(lifecycleOwner3, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumxAlbumDetailBodyPart.Na(Function1.this, obj);
            }
        });
    }

    @Override // com.qzone.reborn.albumx.common.part.CommonAlbumDetailBodyPart, l9.a
    public void A8(com.qzone.reborn.albumx.common.bean.a batchBean, int batchPos, CommonStMedia media, int mediaPos, ImageView view) {
        ArrayList<CommonStMedia> arrayList;
        MutableLiveData<Boolean> d26;
        Intrinsics.checkNotNullParameter(batchBean, "batchBean");
        Intrinsics.checkNotNullParameter(media, "media");
        Intrinsics.checkNotNullParameter(view, "view");
        com.qzone.reborn.albumx.common.viewmodel.e operateViewModel = getOperateViewModel();
        if ((operateViewModel == null || (d26 = operateViewModel.d2()) == null) ? false : Intrinsics.areEqual(d26.getValue(), Boolean.TRUE)) {
            com.qzone.reborn.albumx.common.viewmodel.e operateViewModel2 = getOperateViewModel();
            if (operateViewModel2 == null || (arrayList = operateViewModel2.W1()) == null) {
                arrayList = new ArrayList<>();
            }
            ArrayList<CommonStMedia> arrayList2 = arrayList;
            com.qzone.reborn.albumx.common.viewmodel.b K9 = K9();
            nc.y yVar = K9 instanceof nc.y ? (nc.y) K9 : null;
            if (yVar != null) {
                yVar.V2(batchBean, batchPos, media, mediaPos, view, getTransCreatorKey(), arrayList2);
                return;
            }
            return;
        }
        K9().a2(batchBean, batchPos, media, mediaPos, view, getTransCreatorKey());
    }

    @Override // com.qzone.reborn.albumx.common.part.CommonAlbumDetailBodyPart
    public com.qzone.reborn.feedx.block.aa H9() {
        sa.g gVar = new sa.g();
        gVar.x0(this);
        return gVar;
    }

    @Override // ua.a
    public void U6() {
        QLog.d(getTAG(), 1, "onLoadPreviewStart ");
        nc.y yVar = this.viewModel;
        nc.y yVar2 = null;
        if (yVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            yVar = null;
        }
        if (yVar.getIsTimeLine()) {
            nc.y yVar3 = this.viewModel;
            if (yVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                yVar3 = null;
            }
            if (yVar3.getDataRepo().D()) {
                return;
            }
            nc.y yVar4 = this.viewModel;
            if (yVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                yVar4 = null;
            }
            if (yVar4.getCurTimeline() != null) {
                nc.y yVar5 = this.viewModel;
                if (yVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    yVar5 = null;
                }
                nc.y yVar6 = this.viewModel;
                if (yVar6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    yVar2 = yVar6;
                }
                CommonStTimeLineEvent curTimeline = yVar2.getCurTimeline();
                Intrinsics.checkNotNull(curTimeline);
                yVar5.Y2(3, curTimeline);
            }
        }
    }

    @Override // com.qzone.reborn.albumx.common.part.CommonAlbumDetailBodyPart
    public void V9(UIStateData<List<com.qzone.reborn.albumx.common.bean.a>> uiStateData) {
        Intrinsics.checkNotNullParameter(uiStateData, "uiStateData");
        if (bl.b(uiStateData.getData())) {
            pa(uiStateData);
            return;
        }
        S9().setVisibility(0);
        N9().o0();
        List<CommonGridItemData> ra5 = ra(uiStateData);
        com.qzone.reborn.feedx.scroller.g.f().d(uiStateData.getIsLoadMore() ? M9().getNUM_BACKGOURND_ICON() : 0, new ArrayList(ra5), uiStateData.getIsUpTurning());
        M9().setItems(ra5);
        if (!uiStateData.getIsLoadMore()) {
            RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.k
                @Override // java.lang.Runnable
                public final void run() {
                    QZAlbumxAlbumDetailBodyPart.Ha(QZAlbumxAlbumDetailBodyPart.this);
                }
            }, 100L);
        } else {
            nc.y yVar = this.viewModel;
            if (yVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                yVar = null;
            }
            if (yVar.getIsTimeLine() && uiStateData.getIsFinish() && !uiStateData.getIsUpTurning()) {
                RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        QZAlbumxAlbumDetailBodyPart.Ia(QZAlbumxAlbumDetailBodyPart.this);
                    }
                }, 100L);
            }
        }
        P9().u();
    }

    @Override // com.qzone.reborn.albumx.common.part.CommonAlbumDetailBodyPart
    public RFWConcatAdapter Y9() {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = this.headAdapters.keySet().iterator();
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            ta.b bVar = this.headAdapters.get(Integer.valueOf(intValue));
            if (bVar != null) {
                bVar.setHasStableIds(true);
            }
            ta.b bVar2 = this.headAdapters.get(Integer.valueOf(intValue));
            if (bVar2 != null) {
                arrayList.add(bVar2);
            }
        }
        arrayList.add(M9());
        arrayList.add(Q9());
        return new RFWConcatAdapter(new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build(), arrayList);
    }

    @Override // com.qzone.reborn.albumx.common.part.CommonAlbumDetailBodyPart
    public void ba() {
        la(new com.qzone.reborn.albumx.qzonex.utils.f());
    }

    @Override // com.qzone.reborn.albumx.common.part.CommonAlbumDetailBodyPart, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumxAlbumDetailBodyPart";
    }

    @Override // ua.a
    public void h6(boolean hasPreview) {
        QLog.d(getTAG(), 1, "onLoadPreviewEnd  hasPreview = " + hasPreview);
        S9().setNestedScrollingEnabled(hasPreview ^ true);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String action, Object args) {
        super.handleBroadcastMessage(action, args);
        if (Intrinsics.areEqual(action, "click_time_line_point_refresh") && (Q9() instanceof sa.g)) {
            com.qzone.reborn.feedx.block.aa Q9 = Q9();
            Intrinsics.checkNotNull(Q9, "null cannot be cast to non-null type com.qzone.reborn.albumx.qzonex.adapter.QZAlbumxListLoadMoreAndPreviewAdapter");
            ((sa.g) Q9).y0();
        }
    }

    @Override // com.qzone.reborn.albumx.common.part.CommonAlbumDetailBodyPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.n5k);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026ate_space_app_bar_layout)");
        this.appBarLayout = (AppBarLayout) findViewById;
        P9().q(ef.d.b(13));
        T9().setEnableOverScrollDrag(false);
        Oa(rootView);
        initData();
        Ra();
        Ta();
    }

    @Override // com.qzone.reborn.albumx.common.part.CommonAlbumDetailBodyPart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.qzone.reborn.albumx.common.part.CommonAlbumDetailBodyPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        Q9().unRegisterLoadMoreListener(this);
        if (Q9() instanceof sa.g) {
            com.qzone.reborn.feedx.block.aa Q9 = Q9();
            Intrinsics.checkNotNull(Q9, "null cannot be cast to non-null type com.qzone.reborn.albumx.qzonex.adapter.QZAlbumxListLoadMoreAndPreviewAdapter");
            ((sa.g) Q9).E0(this);
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof QZAlbumxUploadAlbumEvent) {
            Ga((QZAlbumxUploadAlbumEvent) event);
        } else if (event instanceof QZAlbumxUpdateAlbumEvent) {
            Ja((QZAlbumxUpdateAlbumEvent) event);
        }
    }

    @Override // com.qzone.reborn.albumx.common.part.CommonAlbumDetailBodyPart
    public void onRefresh() {
        com.qzone.reborn.albumx.common.viewmodel.b K9 = K9();
        Intrinsics.checkNotNull(K9, "null cannot be cast to non-null type com.qzone.reborn.albumx.qzonex.viewmodel.QZAlbumxAlbumDetailViewModel");
        ((nc.y) K9).b2(false);
    }

    @Override // com.qzone.reborn.albumx.common.part.CommonAlbumDetailBodyPart
    public void pa(UIStateData<List<com.qzone.reborn.albumx.common.bean.a>> uiStateData) {
        String qqStr;
        String qqStr2;
        View.OnClickListener onClickListener;
        String str;
        String str2;
        CommonAlbumInfo value;
        Intrinsics.checkNotNullParameter(uiStateData, "uiStateData");
        com.qzone.reborn.albumx.common.viewmodel.b K9 = K9();
        Intrinsics.checkNotNull(K9, "null cannot be cast to non-null type com.qzone.reborn.albumx.qzonex.viewmodel.QZAlbumxAlbumDetailViewModel");
        nc.y yVar = (nc.y) K9;
        String str3 = "";
        Integer num = null;
        if (((int) uiStateData.getRetCode()) == 10071) {
            String qqStr3 = HardCodeUtil.qqStr(R.string.v1d);
            Intrinsics.checkNotNullExpressionValue(qqStr3, "qqStr(R.string.qzone_intimate_album_is_deleted)");
            qqStr2 = "";
            onClickListener = null;
            str3 = qqStr3;
            qqStr = qqStr2;
        } else if (((int) uiStateData.getRetCode()) != 10023 && ((int) uiStateData.getRetCode()) != 10095 && ((int) uiStateData.getRetCode()) != 10096 && ((int) uiStateData.getRetCode()) != 10097) {
            if (yVar.getPageEndMsg() != null) {
                CommonPageEndMsg pageEndMsg = yVar.getPageEndMsg();
                if (!(pageEndMsg != null && pageEndMsg.getCode() == 0)) {
                    CommonPageEndMsg pageEndMsg2 = yVar.getPageEndMsg();
                    if (pageEndMsg2 == null || (str = pageEndMsg2.getContent()) == null) {
                        str = "";
                    }
                    CommonPageEndMsg pageEndMsg3 = yVar.getPageEndMsg();
                    if (pageEndMsg3 == null || (str2 = pageEndMsg3.getDesc()) == null) {
                        str2 = "";
                    }
                    onClickListener = null;
                    str3 = str;
                    qqStr = str2;
                    qqStr2 = "";
                }
            }
            qqStr = "";
            qqStr2 = qqStr;
            onClickListener = null;
        } else {
            str3 = HardCodeUtil.qqStr(R.string.f134829v);
            Intrinsics.checkNotNullExpressionValue(str3, "qqStr(R.string.qzone_alb\u2026m_permission_error_title)");
            qqStr = HardCodeUtil.qqStr(R.string.f134819u);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.qzone_alb\u2026permission_error_content)");
            qqStr2 = HardCodeUtil.qqStr(R.string.f134809t);
            Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.qzone_alb\u2026bum_permission_error_btn)");
            onClickListener = new View.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QZAlbumxAlbumDetailBodyPart.Ua(QZAlbumxAlbumDetailBodyPart.this, view);
                }
            };
        }
        if (str3.length() == 0) {
            if (qqStr.length() == 0) {
                str3 = HardCodeUtil.qqStr(R.string.f134859y);
                Intrinsics.checkNotNullExpressionValue(str3, "qqStr(R.string.qzone_alb\u2026tail_empty_default_title)");
            }
        }
        Ka(str3, qqStr, qqStr2, onClickListener);
        if (((int) uiStateData.getRetCode()) == 0) {
            com.qzone.reborn.albumx.qzonex.utils.c cVar = com.qzone.reborn.albumx.qzonex.utils.c.f53402a;
            MutableLiveData<CommonAlbumInfo> M1 = yVar.M1();
            if (M1 != null && (value = M1.getValue()) != null) {
                num = Integer.valueOf(value.getQzAlbumType());
            }
            if (cVar.c(num) != 1) {
                Intrinsics.checkNotNullExpressionValue(M9().getItems(), "batchListAdapter.items");
                if (!r11.isEmpty()) {
                    M9().setItems(new ArrayList());
                }
                S9().setVisibility(0);
                N9().post(new Runnable() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        QZAlbumxAlbumDetailBodyPart.Va(QZAlbumxAlbumDetailBodyPart.this);
                    }
                });
            }
        }
        S9().setVisibility(4);
        N9().post(new Runnable() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.n
            @Override // java.lang.Runnable
            public final void run() {
                QZAlbumxAlbumDetailBodyPart.Va(QZAlbumxAlbumDetailBodyPart.this);
            }
        });
    }

    @Override // com.qzone.reborn.albumx.common.part.CommonAlbumDetailBodyPart
    public List<CommonGridItemData> ra(UIStateData<List<com.qzone.reborn.albumx.common.bean.a>> uiStateData) {
        Intrinsics.checkNotNullParameter(uiStateData, "uiStateData");
        aa.d dVar = aa.d.f25752a;
        List<com.qzone.reborn.albumx.common.bean.a> data = uiStateData.getData();
        Intrinsics.checkNotNullExpressionValue(data, "uiStateData.data");
        return dVar.c(data);
    }

    @Override // com.qzone.reborn.albumx.common.part.CommonAlbumDetailBodyPart
    public void sa(UIStateData<List<com.qzone.reborn.albumx.common.bean.a>> uiStateData) {
        Intrinsics.checkNotNullParameter(uiStateData, "uiStateData");
        com.qzone.reborn.albumx.common.viewmodel.b K9 = K9();
        Intrinsics.checkNotNull(K9, "null cannot be cast to non-null type com.qzone.reborn.albumx.qzonex.viewmodel.QZAlbumxAlbumDetailViewModel");
        nc.y yVar = (nc.y) K9;
        boolean isFinish = uiStateData.getIsFinish();
        if (isFinish) {
            CommonPageEndMsg pageEndMsg = yVar.getPageEndMsg();
            boolean z16 = true;
            if (pageEndMsg != null && pageEndMsg.getCode() == 10087) {
                CommonPageEndMsg pageEndMsg2 = yVar.getPageEndMsg();
                String desc = pageEndMsg2 != null ? pageEndMsg2.getDesc() : null;
                if (desc != null && desc.length() != 0) {
                    z16 = false;
                }
                if (!z16) {
                    com.qzone.reborn.feedx.block.aa Q9 = Q9();
                    aa.a e16 = new aa.a().e(HardCodeUtil.qqStr(R.string.w_3));
                    CommonPageEndMsg pageEndMsg3 = yVar.getPageEndMsg();
                    Q9.p0(e16.f(pageEndMsg3 != null ? pageEndMsg3.getDesc() : null).d(""));
                    return;
                }
            }
        }
        if (isFinish) {
            Q9().p0(new aa.a().e(HardCodeUtil.qqStr(R.string.w_3)).f("").d(""));
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QZAlbumxUploadAlbumEvent.class, QZAlbumxUpdateAlbumEvent.class);
        return arrayListOf;
    }
}
