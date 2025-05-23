package com.qzone.reborn.albumx.common.layer.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.intimate.event.QZoneLayerPostDataEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.adapter.RFWLayerGalleryAdapter;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.viewmodel.RFWLayerViewModel;
import com.tencent.richframework.gallery.widget.RFWGalleryViewPager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000 A*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0001fB\u0007\u00a2\u0006\u0004\bd\u0010eJ\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J\u0012\u0010\u0010\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0011\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0006H$J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u0017H$J\u0016\u0010\u001c\u001a\u00020\u001b2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00010\u0019H$J\b\u0010\u001d\u001a\u00020\u0012H\u0014J,\u0010\"\u001a\u00020\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\b2\u0006\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u0012H\u0014J\u001c\u0010#\u001a\u00020\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\bH\u0014J\u0012\u0010&\u001a\u00020\f2\b\u0010%\u001a\u0004\u0018\u00010$H\u0014J\u0010\u0010'\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH\u0014J\"\u0010)\u001a\u00020\f2\b\b\u0001\u0010(\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0014J\u0018\u0010,\u001a\u00020\f2\u0006\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u0012H\u0014J&\u0010.\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\b2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\b0\u00192\u0006\u0010!\u001a\u00020\u0012H\u0004J\u0018\u00100\u001a\u00020\f2\u0006\u0010/\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u0012H\u0014J\u001a\u00104\u001a\u00020\f2\u0006\u00102\u001a\u0002012\b\u00103\u001a\u0004\u0018\u00010$H\u0016J\u0012\u00105\u001a\u00020\f2\b\u00102\u001a\u0004\u0018\u000101H\u0016J\u0012\u00107\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u000106H\u0016J\u0014\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050908H\u0016R\u0016\u0010=\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010?\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010<R\"\u0010F\u001a\u00020\u00068\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\"\u0010H\u001a\u00020\u00128\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010<\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\"\u0010M\u001a\u00020\u00128\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bL\u0010<\u001a\u0004\bM\u0010I\"\u0004\bN\u0010KR\"\u0010P\u001a\u00020\u00128\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bO\u0010<\u001a\u0004\bP\u0010I\"\u0004\bQ\u0010KR\u0016\u0010S\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010<R$\u0010[\u001a\u0004\u0018\u00010T8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR$\u0010c\u001a\u0004\u0018\u00010\\8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010b\u00a8\u0006g"}, d2 = {"Lcom/qzone/reborn/albumx/common/layer/part/CommonLayerControlPart;", "T", "U", "Lcom/qzone/reborn/albumx/common/layer/part/i;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/qzone/reborn/intimate/event/QZoneLayerPostDataEvent;", "", "M9", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "O9", "event", "", "Q9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "T9", "", "fetchLeft", "fetchRight", "X9", "N9", "Lq9/a;", "L9", "Lcom/tencent/richframework/data/base/UIStateData;", "uiStateData", "Lo9/e;", "R9", "U9", "preLayerState", "newLayerState", "canFindPrePic", "isRefreshByDeleteEvent", "G9", "H9", "Landroid/os/Bundle;", "data", "initIntentData", "onLayerStateUpdate", "layerInfo", "I9", "isFetchLeft", "isFetchRight", "F9", "rfwLayerInfoUIStateData", "ba", "layerStateBean", "V9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", tl.h.F, "Z", "isFetchingLeft", "i", "isFetchingRight", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "K9", "()I", "setInitialIndex", "(I)V", "initialIndex", BdhLogUtil.LogTag.Tag_Conn, "isLeftFinish", "()Z", "Y9", "(Z)V", "D", "isRightFinish", "aa", "E", "isRefreshFinish", "Z9", UserInfo.SEX_FEMALE, "hasStartRefresh", "Lcom/tencent/richframework/gallery/adapter/RFWLayerGalleryAdapter;", "G", "Lcom/tencent/richframework/gallery/adapter/RFWLayerGalleryAdapter;", "J9", "()Lcom/tencent/richframework/gallery/adapter/RFWLayerGalleryAdapter;", "setGalleryAdapter", "(Lcom/tencent/richframework/gallery/adapter/RFWLayerGalleryAdapter;)V", "galleryAdapter", "Landroidx/viewpager2/widget/ViewPager2;", "H", "Landroidx/viewpager2/widget/ViewPager2;", "P9", "()Landroidx/viewpager2/widget/ViewPager2;", "setViewPager", "(Landroidx/viewpager2/widget/ViewPager2;)V", "viewPager", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class CommonLayerControlPart<T, U> extends i<T> implements SimpleEventReceiver<QZoneLayerPostDataEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isLeftFinish;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isRightFinish;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isRefreshFinish;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean hasStartRefresh;

    /* renamed from: G, reason: from kotlin metadata */
    private RFWLayerGalleryAdapter galleryAdapter;

    /* renamed from: H, reason: from kotlin metadata */
    private ViewPager2 viewPager;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isFetchingLeft;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isFetchingRight;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int initialIndex;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/albumx/common/layer/part/CommonLayerControlPart$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b extends RecyclerView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CommonLayerControlPart<T, U> f52395d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ RFWLayerState f52396e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ UIStateData<RFWLayerState> f52397f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f52398h;

        b(CommonLayerControlPart<T, U> commonLayerControlPart, RFWLayerState rFWLayerState, UIStateData<RFWLayerState> uIStateData, boolean z16) {
            this.f52395d = commonLayerControlPart;
            this.f52396e = rFWLayerState;
            this.f52397f = uIStateData;
            this.f52398h = z16;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 0) {
                RFWLayerGalleryAdapter galleryAdapter = this.f52395d.getGalleryAdapter();
                Intrinsics.checkNotNull(galleryAdapter);
                RecyclerView recyclerView2 = galleryAdapter.getRecyclerView();
                if (recyclerView2 != null) {
                    recyclerView2.removeOnScrollListener(this);
                }
                RFWLog.i(this.f52395d.getTAG(), RFWLog.USR, "scroll is idle start setData");
                this.f52395d.ba(this.f52396e, this.f52397f, this.f52398h);
            }
        }
    }

    private final int M9() {
        return this.mSelectedPosition;
    }

    private final int O9(RFWLayerState layerState) {
        List<RFWLayerItemMediaInfo> richMediaDataList = layerState.getRichMediaDataList();
        return (richMediaDataList != null ? richMediaDataList.size() - this.mSelectedPosition : 1) - 1;
    }

    private final void Q9(QZoneLayerPostDataEvent event) {
        V9(event.getBean(), event.getIsLayerDeleteEventTrigger());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(CommonLayerControlPart this$0, o9.e layerStateBean, boolean z16) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(layerStateBean, "$layerStateBean");
        if (this$0.galleryAdapter == null) {
            return;
        }
        RFWLayerState newLayerState = layerStateBean.getNewLayerState();
        UIStateData<RFWLayerState> b16 = layerStateBean.b();
        RFWLayerGalleryAdapter rFWLayerGalleryAdapter = this$0.galleryAdapter;
        boolean z17 = false;
        if (rFWLayerGalleryAdapter != null && (recyclerView2 = rFWLayerGalleryAdapter.getRecyclerView()) != null && recyclerView2.getScrollState() == 0) {
            z17 = true;
        }
        if (z17) {
            this$0.ba(newLayerState, b16, z16);
            return;
        }
        RFWLog.i(this$0.getTAG(), RFWLog.USR, "isScrolling add listener");
        RFWLayerGalleryAdapter rFWLayerGalleryAdapter2 = this$0.galleryAdapter;
        if (rFWLayerGalleryAdapter2 == null || (recyclerView = rFWLayerGalleryAdapter2.getRecyclerView()) == null) {
            return;
        }
        recyclerView.addOnScrollListener(new b(this$0, newLayerState, b16, z16));
    }

    protected void I9(RFWLayerState layerInfo, boolean fetchLeft, boolean fetchRight) {
        Intrinsics.checkNotNullParameter(layerInfo, "layerInfo");
        List<RFWLayerItemMediaInfo> richMediaDataList = layerInfo.getRichMediaDataList();
        if ((richMediaDataList != null ? richMediaDataList.size() : 0) <= layerInfo.getSelectedPosition()) {
            RFWLog.e("QZoneBaseLayerControlPart", RFWLog.USR, "no need to fetch layer data");
            return;
        }
        if (fetchLeft && this.isFetchingLeft) {
            return;
        }
        if (fetchRight && this.isFetchingRight) {
            return;
        }
        if (fetchLeft) {
            this.isFetchingLeft = true;
        }
        if (fetchRight) {
            this.isFetchingRight = true;
        }
        RFWLog.d("QZoneBaseLayerControlPart", RFWLog.USR, "fetch left is " + fetchLeft + " fetch right is " + fetchRight);
        this.initialIndex = layerInfo.getSelectedPosition();
        X9(fetchLeft, fetchRight);
    }

    /* renamed from: J9, reason: from getter */
    public final RFWLayerGalleryAdapter getGalleryAdapter() {
        return this.galleryAdapter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: K9, reason: from getter */
    public final int getInitialIndex() {
        return this.initialIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract q9.a<U> L9();

    protected abstract int N9();

    /* renamed from: P9, reason: from getter */
    public final ViewPager2 getViewPager() {
        return this.viewPager;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract o9.e R9(UIStateData<U> uiStateData);

    protected boolean U9() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void V9(final o9.e layerStateBean, final boolean isRefreshByDeleteEvent) {
        Intrinsics.checkNotNullParameter(layerStateBean, "layerStateBean");
        if (layerStateBean.getNewLayerState().getMediaSum() <= 0) {
            return;
        }
        getMainHandler().post(new Runnable() { // from class: com.qzone.reborn.albumx.common.layer.part.a
            @Override // java.lang.Runnable
            public final void run() {
                CommonLayerControlPart.W9(CommonLayerControlPart.this, layerStateBean, isRefreshByDeleteEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Y9(boolean z16) {
        this.isLeftFinish = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Z9(boolean z16) {
        this.isRefreshFinish = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void aa(boolean z16) {
        this.isRightFinish = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void ba(RFWLayerState newLayerState, UIStateData<RFWLayerState> rfwLayerInfoUIStateData, boolean isRefreshByDeleteEvent) {
        RFWLayerItemMediaInfo selectedItemMedia;
        boolean z16;
        Intrinsics.checkNotNullParameter(newLayerState, "newLayerState");
        Intrinsics.checkNotNullParameter(rfwLayerInfoUIStateData, "rfwLayerInfoUIStateData");
        UIStateData<RFWLayerState> value = getMLayerViewModel().mRichMediaInfo.getValue();
        RFWLayerState data = value != null ? value.getData() : null;
        if (isRefreshByDeleteEvent) {
            selectedItemMedia = newLayerState.getSelectedItemMedia();
        } else {
            selectedItemMedia = data != null ? data.getSelectedItemMedia() : null;
        }
        int currentIndex = RFWLayerItemMediaInfo.INSTANCE.getCurrentIndex(selectedItemMedia, newLayerState.getRichMediaDataList());
        RFWLayerViewModel mLayerViewModel = getMLayerViewModel();
        if (currentIndex >= 0) {
            newLayerState.setSelectedPosition(currentIndex);
            RFWLog.i(getTAG(), RFWLog.USR, "preSelectedPosition:" + (data != null ? Integer.valueOf(data.getSelectedPosition()) : null) + " find new mSelectedPosition:" + currentIndex);
            z16 = true;
        } else {
            H9(data, newLayerState);
            z16 = false;
        }
        G9(data, newLayerState, z16, isRefreshByDeleteEvent);
        rfwLayerInfoUIStateData.setLatestModifyRecord(UIStateData.ModifyListRecord.obtainNotifyDataSetChanged());
        F9(true, true);
        mLayerViewModel.mRichMediaInfo.setValue(rfwLayerInfoUIStateData.setDataList(newLayerState));
        broadcastMessage("LAYER_ASSEMBLE_ORIGIN_PIC_INFO", newLayerState);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<QZoneLayerPostDataEvent>> getEventClass() {
        ArrayList<Class<QZoneLayerPostDataEvent>> arrayList = new ArrayList<>();
        arrayList.add(QZoneLayerPostDataEvent.class);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.i
    public void initIntentData(Bundle data) {
        super.initIntentData(data);
        MutableLiveData<UIStateData<U>> M1 = L9().M1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<UIStateData<U>, Unit> function1 = new Function1<UIStateData<U>, Unit>(this) { // from class: com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart$initIntentData$1
            final /* synthetic */ CommonLayerControlPart<T, U> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke((UIStateData) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(UIStateData<U> uiStateData) {
                this.this$0.broadcastMessage("COMMON_ALBUM_LAYER_READY_REPORT", null);
                CommonLayerControlPart<T, U> commonLayerControlPart = this.this$0;
                Intrinsics.checkNotNullExpressionValue(uiStateData, "uiStateData");
                commonLayerControlPart.V9(commonLayerControlPart.R9(uiStateData), false);
            }
        };
        M1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.common.layer.part.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CommonLayerControlPart.S9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        T9(rootView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.i
    public void onLayerStateUpdate(RFWLayerState layerState) {
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        super.onLayerStateUpdate(layerState);
        if (U9() && !this.isRefreshFinish) {
            if (this.hasStartRefresh) {
                return;
            }
            I9(layerState, true, true);
            this.hasStartRefresh = true;
            return;
        }
        if (!this.isRightFinish && O9(layerState) <= N9()) {
            I9(layerState, false, true);
        }
        if (this.isLeftFinish || M9() > N9()) {
            return;
        }
        I9(layerState, true, false);
    }

    @Override // com.qzone.reborn.albumx.common.layer.part.i, com.tencent.richframework.gallery.part.RFWLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof QZoneLayerPostDataEvent) {
            Q9((QZoneLayerPostDataEvent) event);
        }
    }

    protected void F9(boolean isFetchLeft, boolean isFetchRight) {
        if (isFetchLeft) {
            this.isFetchingLeft = false;
        }
        if (isFetchRight) {
            this.isFetchingRight = false;
        }
    }

    protected void T9(View rootView) {
        RFWGalleryViewPager rFWGalleryViewPager = rootView != null ? (RFWGalleryViewPager) rootView.findViewById(R.id.f73943ux) : null;
        ViewPager2 viewPager2 = rFWGalleryViewPager != null ? rFWGalleryViewPager.getViewPager2() : null;
        this.viewPager = viewPager2;
        RecyclerView.Adapter adapter = viewPager2 != null ? viewPager2.getAdapter() : null;
        Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter");
        RecyclerView.Adapter<? extends RecyclerView.ViewHolder> adapter2 = ((RFWConcatAdapter) adapter).getAdapters().get(0);
        Intrinsics.checkNotNull(adapter2, "null cannot be cast to non-null type com.tencent.richframework.gallery.adapter.RFWLayerGalleryAdapter");
        this.galleryAdapter = (RFWLayerGalleryAdapter) adapter2;
    }

    protected void H9(RFWLayerState preLayerState, RFWLayerState newLayerState) {
    }

    public void X9(boolean fetchLeft, boolean fetchRight) {
    }

    protected void G9(RFWLayerState preLayerState, RFWLayerState newLayerState, boolean canFindPrePic, boolean isRefreshByDeleteEvent) {
    }
}
