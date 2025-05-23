package com.tencent.qqnt.aio.gallery.part;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.MsgRecordParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.MsgRevokeEvent;
import com.tencent.qqnt.aio.adapter.api.impl.RichMediaBrowserApiImpl;
import com.tencent.qqnt.aio.gallery.event.MsgFetchEvent;
import com.tencent.qqnt.kernel.nativeinterface.ChatInfo;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.kernel.nativeinterface.QueryMsgsParams;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.RFWLayerIOCUtil;
import com.tencent.richframework.gallery.adapter.RFWLayerGalleryAdapter;
import com.tencent.richframework.gallery.bean.RFWLayerFileDownloadState;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.datacenter.RFWLayerDataCenter;
import com.tencent.richframework.gallery.delegate.inner.IGalleryPageProvider;
import com.tencent.richframework.gallery.event.RFWLayerFileStateChangeEvent;
import com.tencent.richframework.gallery.part.NTAIOLayerBasePart;
import com.tencent.richframework.gallery.widget.RFWGalleryViewPager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsJvmKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000\u00a8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0016\u0018\u0000 q2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0002rsB\u000f\u0012\u0006\u0010:\u001a\u00020\b\u00a2\u0006\u0004\bp\u0010lJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002J$\u0010\u001b\u001a\u00020\b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002J \u0010\u001f\u001a\u00020\b2\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u001cj\b\u0012\u0004\u0012\u00020\f`\u001dH\u0002J\b\u0010 \u001a\u00020\bH\u0016J\u001a\u0010%\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010&\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020!H\u0016J\u0010\u0010'\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010*\u001a\u00020\u00062\u0006\u0010)\u001a\u00020(H\u0016J\u0012\u0010,\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030-0\u001cH\u0016J(\u00102\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u000f2\b\u00101\u001a\u0004\u0018\u0001002\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u001cJ\u001e\u00106\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u00042\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u000404H\u0014J\u001e\u00107\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u00042\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u000404H\u0014R\u0017\u0010:\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R2\u0010C\u001a\u0012\u0012\u0004\u0012\u00020<0\u001cj\b\u0012\u0004\u0012\u00020<`\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR>\u0010L\u001a\u001e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u0002000Dj\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u000200`E8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR>\u0010P\u001a\u001e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u0002000Dj\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u000200`E8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bM\u0010G\u001a\u0004\bN\u0010I\"\u0004\bO\u0010KR'\u0010W\u001a\u0012\u0012\u0004\u0012\u0002000Qj\b\u0012\u0004\u0012\u000200`R8\u0006\u00a2\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010VR\u001d\u0010]\u001a\u0004\u0018\u00010X8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\R$\u0010d\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR$\u0010h\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\be\u0010_\u001a\u0004\bf\u0010a\"\u0004\bg\u0010cR\"\u0010j\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bi\u00109\u001a\u0004\bj\u0010;\"\u0004\bk\u0010lR\"\u0010n\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bm\u00109\u001a\u0004\bn\u0010;\"\u0004\bo\u0010l\u00a8\u0006t"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/part/NTAIOLayerFetchPart;", "Lcom/tencent/richframework/gallery/part/NTAIOLayerBasePart;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "", "K9", "", "isReverseMsg", "J9", "M9", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "L9", "", "size", "D9", "E9", "Lcom/tencent/mobileqq/app/QQAppInterface;", "A9", "", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "data", "z9", "preDataList", "appendList", "C9", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "msgRecordList", "F9", "isPartEnable", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "onLayerStateUpdate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "event", "onReceiveEvent", "Ljava/lang/Class;", "getEventClass", "result", "", "errMsg", "G9", "newLayerState", "Lcom/tencent/richframework/data/base/UIStateData;", "rfwLayerInfoUIStateData", "H9", "N9", "d", "Z", "isReverse", "()Z", "", "e", "Ljava/util/ArrayList;", "getSaveList", "()Ljava/util/ArrayList;", "setSaveList", "(Ljava/util/ArrayList;)V", "saveList", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "f", "Ljava/util/HashMap;", "getElementIdToMediaId", "()Ljava/util/HashMap;", "setElementIdToMediaId", "(Ljava/util/HashMap;)V", "elementIdToMediaId", tl.h.F, "getMediaToContextId", "setMediaToContextId", "mediaToContextId", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "i", "Ljava/util/HashSet;", "getDownloadSuccessVideoElementIds", "()Ljava/util/HashSet;", "downloadSuccessVideoElementIds", "Landroidx/recyclerview/widget/RecyclerView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "B9", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "getLeftMostMsgRecord", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "setLeftMostMsgRecord", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "leftMostMsgRecord", "D", "getRightMostMsgRecord", "setRightMostMsgRecord", "rightMostMsgRecord", "E", "isQuerying", "setQuerying", "(Z)V", UserInfo.SEX_FEMALE, "isRightPull", "setRightPull", "<init>", "G", "a", "b", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public class NTAIOLayerFetchPart extends NTAIOLayerBasePart implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    private volatile MsgRecord leftMostMsgRecord;

    /* renamed from: D, reason: from kotlin metadata */
    private volatile MsgRecord rightMostMsgRecord;

    /* renamed from: E, reason: from kotlin metadata */
    private volatile boolean isQuerying;

    /* renamed from: F, reason: from kotlin metadata */
    private volatile boolean isRightPull;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean isReverse;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ArrayList<Long> saveList = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private HashMap<Long, String> elementIdToMediaId = new HashMap<>();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private HashMap<String, String> mediaToContextId = new HashMap<>();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final HashSet<String> downloadSuccessVideoElementIds = new HashSet<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Lazy recyclerView;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\f\u00a2\u0006\u0004\b\u0011\u0010\u0012J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/part/NTAIOLayerFetchPart$b;", "Lcom/tencent/qqnt/kernel/nativeinterface/IMsgOperateCallback;", "", "result", "", "errMsg", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", TabPreloadItem.TAB_NAME_MESSAGE, "", "onResult", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/qqnt/aio/gallery/part/NTAIOLayerFetchPart;", "a", "Ljava/lang/ref/WeakReference;", "mWrfPart", "part", "<init>", "(Lcom/tencent/qqnt/aio/gallery/part/NTAIOLayerFetchPart;)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements IMsgOperateCallback {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<NTAIOLayerFetchPart> mWrfPart;

        public b(NTAIOLayerFetchPart part) {
            Intrinsics.checkNotNullParameter(part, "part");
            this.mWrfPart = new WeakReference<>(part);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
        public void onResult(int result, String errMsg, ArrayList<MsgRecord> msgList) {
            NTAIOLayerFetchPart nTAIOLayerFetchPart = this.mWrfPart.get();
            if (nTAIOLayerFetchPart != null) {
                nTAIOLayerFetchPart.G9(result, errMsg, msgList);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/aio/gallery/part/NTAIOLayerFetchPart$c", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c extends RecyclerView.OnScrollListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ RFWLayerState f350043e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ UIStateData<RFWLayerState> f350044f;

        c(RFWLayerState rFWLayerState, UIStateData<RFWLayerState> uIStateData) {
            this.f350043e = rFWLayerState;
            this.f350044f = uIStateData;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 0) {
                recyclerView.removeOnScrollListener(this);
                RFWLog.i(NTAIOLayerFetchPart.this.getTAG(), RFWLog.USR, "scroll is idle start setData");
                NTAIOLayerFetchPart.this.N9(this.f350043e, this.f350044f);
            }
        }
    }

    public NTAIOLayerFetchPart(boolean z16) {
        Lazy lazy;
        this.isReverse = z16;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RecyclerView>() { // from class: com.tencent.qqnt.aio.gallery.part.NTAIOLayerFetchPart$recyclerView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RecyclerView invoke() {
                List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> adapters;
                RFWGalleryViewPager galleryViewPager;
                ViewPager2 viewPager2;
                View rootView = NTAIOLayerFetchPart.this.getPartRootView();
                Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
                IGalleryPageProvider galleryPageProvider = RFWLayerIOCUtil.getGalleryPageProvider(rootView);
                RecyclerView.Adapter adapter = (galleryPageProvider == null || (galleryViewPager = galleryPageProvider.getGalleryViewPager()) == null || (viewPager2 = galleryViewPager.getViewPager2()) == null) ? null : viewPager2.getAdapter();
                RFWConcatAdapter rFWConcatAdapter = adapter instanceof RFWConcatAdapter ? (RFWConcatAdapter) adapter : null;
                RecyclerView.Adapter<? extends RecyclerView.ViewHolder> adapter2 = (rFWConcatAdapter == null || (adapters = rFWConcatAdapter.getAdapters()) == null) ? null : adapters.get(0);
                RFWLayerGalleryAdapter rFWLayerGalleryAdapter = adapter2 instanceof RFWLayerGalleryAdapter ? (RFWLayerGalleryAdapter) adapter2 : null;
                if (rFWLayerGalleryAdapter != null) {
                    return rFWLayerGalleryAdapter.getRecyclerView();
                }
                return null;
            }
        });
        this.recyclerView = lazy;
    }

    private final QQAppInterface A9() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            return (QQAppInterface) peekAppRuntime;
        }
        return null;
    }

    private final boolean C9(List<? extends RFWLayerItemMediaInfo> preDataList, List<? extends RFWLayerItemMediaInfo> appendList) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        boolean z16;
        List<? extends RFWLayerItemMediaInfo> list = preDataList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((RFWLayerItemMediaInfo) it.next()).getMediaId());
        }
        List<? extends RFWLayerItemMediaInfo> list2 = appendList;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        Iterator<T> it5 = list2.iterator();
        while (it5.hasNext()) {
            arrayList2.add(((RFWLayerItemMediaInfo) it5.next()).getMediaId());
        }
        if (!arrayList2.isEmpty()) {
            Iterator it6 = arrayList2.iterator();
            while (it6.hasNext()) {
                if (!arrayList.contains((String) it6.next())) {
                    z16 = false;
                    break;
                }
            }
        }
        z16 = true;
        QLog.d("NTAIOLayerFetchPart", 1, "containsAllIds: " + z16);
        return z16;
    }

    private final boolean D9(int size) {
        boolean z16 = this.isReverse;
        if (z16 || size > 1) {
            return (z16 && this.mSelectedPosition == 0) || (!z16 && this.mSelectedPosition == size - 1);
        }
        return false;
    }

    private final int E9(int size) {
        int i3 = this.mSelectedPosition;
        if (i3 == 0) {
            return 0;
        }
        return i3 == size - 1 ? 1 : -1;
    }

    private final boolean F9(ArrayList<MsgRecord> msgRecordList) {
        Object first;
        Object last;
        if (msgRecordList.size() == 1) {
            return false;
        }
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) msgRecordList);
        long j3 = ((MsgRecord) first).msgSeq;
        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) msgRecordList);
        long j16 = ((MsgRecord) last).msgSeq;
        boolean z16 = this.isReverse;
        return (!z16 && j3 > j16) || (z16 && j3 < j16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(NTAIOLayerFetchPart this$0, RFWLayerState newLayerState, UIStateData rfwLayerInfoUIStateData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(newLayerState, "$newLayerState");
        Intrinsics.checkNotNullParameter(rfwLayerInfoUIStateData, "$rfwLayerInfoUIStateData");
        RecyclerView B9 = this$0.B9();
        boolean z16 = false;
        if (B9 != null && B9.getScrollState() == 0) {
            z16 = true;
        }
        if (z16) {
            this$0.N9(newLayerState, rfwLayerInfoUIStateData);
            return;
        }
        RFWLog.i(this$0.getTAG(), RFWLog.USR, "isScrolling add listener");
        RecyclerView B92 = this$0.B9();
        if (B92 != null) {
            B92.addOnScrollListener(new c(newLayerState, rfwLayerInfoUIStateData));
        }
    }

    private final void J9(RFWLayerState layerState, boolean isReverseMsg) {
        Object first;
        List<RFWLayerItemMediaInfo> richMediaDataList = layerState.getRichMediaDataList();
        if (richMediaDataList != null) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) richMediaDataList);
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo = (RFWLayerItemMediaInfo) first;
            if (rFWLayerItemMediaInfo == null) {
                return;
            }
            Object extraData = rFWLayerItemMediaInfo.getExtraData();
            AIOMsgItem aIOMsgItem = extraData instanceof AIOMsgItem ? (AIOMsgItem) extraData : null;
            if (aIOMsgItem == null) {
                return;
            }
            MsgRecordParams s06 = aIOMsgItem.s0();
            MsgRecordParams k06 = aIOMsgItem.k0();
            if (this.leftMostMsgRecord == null) {
                this.leftMostMsgRecord = aIOMsgItem.getMsgRecord();
            }
            if (s06 == null && k06 == null) {
                MsgRecord msgRecord = this.leftMostMsgRecord;
                if (msgRecord != null) {
                    L9(msgRecord, isReverseMsg);
                    QLog.i("NTAIOLayerFetchPart", 1, "queryLeft id: " + msgRecord.msgId + ", isReverseMsg: " + isReverseMsg);
                }
                this.isQuerying = true;
            }
        }
    }

    private final void K9(RFWLayerState layerState) {
        List<RFWLayerItemMediaInfo> richMediaDataList = layerState.getRichMediaDataList();
        if (richMediaDataList != null) {
            int size = richMediaDataList.size();
            boolean D9 = D9(size);
            int E9 = E9(size);
            if (E9 == 0) {
                J9(layerState, D9);
            } else {
                if (E9 != 1) {
                    return;
                }
                M9(layerState, D9);
            }
        }
    }

    private final void M9(RFWLayerState layerState, boolean isReverseMsg) {
        Object last;
        List<RFWLayerItemMediaInfo> richMediaDataList = layerState.getRichMediaDataList();
        if (richMediaDataList != null) {
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) richMediaDataList);
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo = (RFWLayerItemMediaInfo) last;
            if (rFWLayerItemMediaInfo == null) {
                return;
            }
            Object extraData = rFWLayerItemMediaInfo.getExtraData();
            AIOMsgItem aIOMsgItem = extraData instanceof AIOMsgItem ? (AIOMsgItem) extraData : null;
            if (aIOMsgItem == null) {
                return;
            }
            MsgRecordParams s06 = aIOMsgItem.s0();
            MsgRecordParams k06 = aIOMsgItem.k0();
            this.isRightPull = true;
            if (this.rightMostMsgRecord == null) {
                this.rightMostMsgRecord = aIOMsgItem.getMsgRecord();
            }
            if (s06 == null && k06 == null) {
                MsgRecord msgRecord = this.rightMostMsgRecord;
                if (msgRecord != null) {
                    QLog.i("NTAIOLayerFetchPart", 1, "queryRight id: " + msgRecord.msgId + ", isReverseMsg: " + isReverseMsg);
                    L9(msgRecord, isReverseMsg);
                }
                this.isQuerying = true;
            }
        }
    }

    private final List<RFWLayerItemMediaInfo> z9(List<? extends RFWLayerItemMediaInfo> data) {
        boolean contains;
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (RFWLayerItemMediaInfo rFWLayerItemMediaInfo : data) {
            if (!TextUtils.isEmpty(rFWLayerItemMediaInfo.getMediaId())) {
                contains = CollectionsKt___CollectionsKt.contains(hashSet, rFWLayerItemMediaInfo.getMediaId());
                if (!contains) {
                    arrayList.add(rFWLayerItemMediaInfo);
                    String mediaId = rFWLayerItemMediaInfo.getMediaId();
                    Intrinsics.checkNotNull(mediaId);
                    hashSet.add(mediaId);
                }
            }
        }
        return arrayList;
    }

    public final RecyclerView B9() {
        return (RecyclerView) this.recyclerView.getValue();
    }

    protected void H9(final RFWLayerState newLayerState, final UIStateData<RFWLayerState> rfwLayerInfoUIStateData) {
        Intrinsics.checkNotNullParameter(newLayerState, "newLayerState");
        Intrinsics.checkNotNullParameter(rfwLayerInfoUIStateData, "rfwLayerInfoUIStateData");
        getMainHandler().post(new Runnable() { // from class: com.tencent.qqnt.aio.gallery.part.j
            @Override // java.lang.Runnable
            public final void run() {
                NTAIOLayerFetchPart.I9(NTAIOLayerFetchPart.this, newLayerState, rfwLayerInfoUIStateData);
            }
        });
    }

    protected void N9(RFWLayerState newLayerState, UIStateData<RFWLayerState> rfwLayerInfoUIStateData) {
        Intrinsics.checkNotNullParameter(newLayerState, "newLayerState");
        Intrinsics.checkNotNullParameter(rfwLayerInfoUIStateData, "rfwLayerInfoUIStateData");
        UIStateData<RFWLayerState> value = getMLayerViewModel().mRichMediaInfo.getValue();
        Intrinsics.checkNotNull(value);
        RFWLayerState data = value.getData();
        int currentIndex = RFWLayerItemMediaInfo.INSTANCE.getCurrentIndex(data.getSelectedItemMedia(), newLayerState.getRichMediaDataList());
        if (currentIndex >= 0) {
            newLayerState.setSelectedPosition(currentIndex);
            RFWLog.i(getTAG(), RFWLog.USR, "preSelectedPosition:" + data.getSelectedPosition() + " find new mSelectedPosition:" + currentIndex);
        }
        rfwLayerInfoUIStateData.setLatestModifyRecord(UIStateData.ModifyListRecord.obtainNotifyDataSetChanged());
        getMLayerViewModel().mRichMediaInfo.setValue(rfwLayerInfoUIStateData.setDataList(newLayerState));
        this.isQuerying = false;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(RFWLayerFileStateChangeEvent.class);
        arrayList.add(MsgRevokeEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("AIO_LAYER_OPEN_FETCH_LEFT", true);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
    }

    @Override // com.tencent.richframework.gallery.part.NTAIOLayerBasePart
    public void onLayerStateUpdate(RFWLayerState layerState) {
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        super.onLayerStateUpdate(layerState);
        if (this.isQuerying) {
            QLog.i("NTAIOLayerFetchPart", 1, "isQuerying: " + this.isQuerying);
            return;
        }
        this.isRightPull = false;
        K9(layerState);
    }

    @Override // com.tencent.richframework.gallery.part.NTAIOLayerBasePart, com.tencent.richframework.gallery.part.RFWLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        RFWLayerDataCenter.INSTANCE.addDataConverter(new com.tencent.qqnt.aio.gallery.k());
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof RFWLayerFileStateChangeEvent) {
            RFWLayerFileStateChangeEvent rFWLayerFileStateChangeEvent = (RFWLayerFileStateChangeEvent) event;
            RFWLayerFileDownloadState rFWLayerFileDownloadState = rFWLayerFileStateChangeEvent.mState;
            if ((rFWLayerFileDownloadState != null ? rFWLayerFileDownloadState.getFileState() : null) == RFWLayerFileDownloadState.FileState.DOWNLOAD_SUCCESS) {
                RFWLog.i("NTAIOLayerFetchPart", RFWLog.USR, "downloadSuccess");
                String str = this.mediaToContextId.get(rFWLayerFileStateChangeEvent.mState.getMediaId());
                if (str == null || TextUtils.isEmpty(str)) {
                    return;
                }
                com.tencent.mobileqq.filemanager.core.g.g(str);
            }
        }
    }

    private final void L9(MsgRecord msgRecord, boolean isReverseMsg) {
        com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            e16.queryPicOrVideoMsgs(msgRecord.msgId, msgRecord.msgTime, msgRecord.msgSeq, new QueryMsgsParams(new ChatInfo(msgRecord.chatType, msgRecord.peerUid), new ArrayList(), new ArrayList(), 0L, 0L, 20, isReverseMsg, false), new b(this));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0097 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void G9(int result, String errMsg, ArrayList<MsgRecord> msgRecordList) {
        RFWLayerState data;
        List<? extends RFWLayerItemMediaInfo> richMediaDataList;
        Object first;
        Object last;
        boolean z16;
        QLog.i("NTAIOLayerFetchPart", 1, "result:" + result + " errMsg:" + errMsg + " size:" + (msgRecordList != null ? Integer.valueOf(msgRecordList.size()) : null));
        if (result == 0 && msgRecordList != null && !msgRecordList.isEmpty()) {
            if (F9(msgRecordList)) {
                CollectionsKt___CollectionsJvmKt.reverse(msgRecordList);
            }
            ArrayList<MsgRecord> arrayList = new ArrayList();
            for (Object obj : msgRecordList) {
                MsgRecord msgRecord = (MsgRecord) obj;
                Intrinsics.checkNotNullExpressionValue(msgRecord.elements, "it.elements");
                if (!r8.isEmpty()) {
                    PicElement picElement = msgRecord.elements.get(0).picElement;
                    if (!(picElement != null ? Intrinsics.areEqual(picElement.isFlashPic, Boolean.TRUE) : false)) {
                        z16 = true;
                        if (!z16) {
                            arrayList.add(obj);
                        }
                    }
                }
                z16 = false;
                if (!z16) {
                }
            }
            QQAppInterface A9 = A9();
            if (A9 == null) {
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (MsgRecord msgRecord2 : arrayList) {
                List<? extends AIORichMediaData> c16 = ru3.c.c(ru3.c.f432503a, A9, msgRecord2, null, null, 12, null);
                if (c16 != null) {
                    arrayList3.addAll(c16);
                    List<RFWLayerItemMediaInfo> e16 = RichMediaBrowserApiImpl.INSTANCE.e(c16);
                    Iterator<RFWLayerItemMediaInfo> it = e16.iterator();
                    while (it.hasNext()) {
                        it.next().setExtraData(new AIOMsgItem(msgRecord2));
                    }
                    arrayList2.addAll(e16);
                }
            }
            if (arrayList2.isEmpty()) {
                this.isQuerying = false;
                QLog.i("NTAIOLayerFetchPart", 1, " appendList is empty");
                return;
            }
            UIStateData<RFWLayerState> value = getMLayerViewModel().mRichMediaInfo.getValue();
            if (value == null || (data = value.getData()) == null || (richMediaDataList = data.getRichMediaDataList()) == null || C9(richMediaDataList, arrayList2)) {
                return;
            }
            ArrayList arrayList4 = new ArrayList();
            if (this.isRightPull) {
                arrayList4.addAll(richMediaDataList);
                arrayList4.addAll(arrayList2);
            } else {
                arrayList4.addAll(arrayList2);
                arrayList4.addAll(richMediaDataList);
            }
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList4);
            Object extraData = ((RFWLayerItemMediaInfo) first).getExtraData();
            Intrinsics.checkNotNull(extraData, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.AIOMsgItem");
            this.leftMostMsgRecord = ((AIOMsgItem) extraData).getMsgRecord();
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) arrayList4);
            Object extraData2 = ((RFWLayerItemMediaInfo) last).getExtraData();
            Intrinsics.checkNotNull(extraData2, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.AIOMsgItem");
            this.rightMostMsgRecord = ((AIOMsgItem) extraData2).getMsgRecord();
            RFWLayerDataCenter.INSTANCE.fillDuplicateData(RFWLayerItemMediaInfo.class, arrayList4);
            List<RFWLayerItemMediaInfo> z95 = z9(arrayList4);
            RFWLayerState rFWLayerState = new RFWLayerState();
            rFWLayerState.setRichMediaDataList(z95);
            com.tencent.qqnt.aio.gallery.j.f350008a.f(arrayList3);
            SimpleEventBus.getInstance().dispatchEvent(new MsgFetchEvent(z9(arrayList2), arrayList));
            UIStateData<RFWLayerState> value2 = getMLayerViewModel().mRichMediaInfo.getValue();
            Intrinsics.checkNotNull(value2);
            H9(rFWLayerState, value2);
            return;
        }
        this.isQuerying = false;
    }
}
