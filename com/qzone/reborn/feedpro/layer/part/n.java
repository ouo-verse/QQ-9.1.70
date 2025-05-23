package com.qzone.reborn.feedpro.layer.part;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.reborn.base.n;
import com.qzone.reborn.comment.bean.QZoneCommentPanelParams;
import com.qzone.reborn.comment.bean.QZoneCommentPanelResultBean;
import com.qzone.reborn.feedpro.layer.router.QzoneFeedProLayerExtraInfoBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.media_commwriter.media_commwriter.EditBatchMediaRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.media_commwriter.media_commwriter.EditPhoto;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.RFWLayerIOCUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.delegate.inner.IVideoPlayerProvider;
import com.tencent.richframework.gallery.delegate.outer.IVideoControlLayoutChangeListener;
import com.tencent.richframework.gallery.event.RFWLayerVideoPlayEvent;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.ArrayUtils;
import com.tencent.util.QQToastUtil;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 D2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0001EB\u0007\u00a2\u0006\u0004\bB\u0010CJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0002J\u0012\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0012\u0010\u001a\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001bH\u0014J\u0012\u0010 \u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010!\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0016J\"\u0010%\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J$\u0010)\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030'0&j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030'`(H\u0016J\u0018\u0010,\u001a\u00020\u00052\u0006\u0010+\u001a\u00020*2\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010>\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010;R\u0018\u0010A\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@\u00a8\u0006F"}, d2 = {"Lcom/qzone/reborn/feedpro/layer/part/n;", "Lcom/qzone/reborn/feedpro/layer/part/c;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/richframework/gallery/delegate/outer/IVideoControlLayoutChangeListener;", "", "L9", "", "isVisible", "K9", "R9", "T9", "P9", "V9", "Lcom/tencent/richframework/gallery/event/RFWLayerVideoPlayEvent;", "event", "M9", "N9", "Landroid/content/Intent;", "data", "Q9", "", "latestDesc", "W9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "onLayerStateUpdate", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "onReceiveEvent", "", "requestCode", QzoneIPCModule.RESULT_CODE, "onActivityResult", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "itemInfo", "onVisibleChange", "Lke/d;", "i", "Lke/d;", "operateViewModel", "Landroid/widget/LinearLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/LinearLayout;", "descEditContainer", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/ImageView;", "descEditIcon", "Lcom/qzone/proxy/feedcomponent/text/CellTextView;", "D", "Lcom/qzone/proxy/feedcomponent/text/CellTextView;", "descEditTv", "E", "descTextTv", UserInfo.SEX_FEMALE, "Landroid/view/View;", "descLayout", "<init>", "()V", "G", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class n extends c implements SimpleEventReceiver<SimpleBaseEvent>, IVideoControlLayoutChangeListener {

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView descEditIcon;

    /* renamed from: D, reason: from kotlin metadata */
    private CellTextView descEditTv;

    /* renamed from: E, reason: from kotlin metadata */
    private CellTextView descTextTv;

    /* renamed from: F, reason: from kotlin metadata */
    private View descLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ke.d operateViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private LinearLayout descEditContainer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"com/qzone/reborn/feedpro/layer/part/n$b", "Lcom/qzone/reborn/base/n$a;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/media_commwriter/media_commwriter/EditBatchMediaRsp;", "t", "", "retCode", "", "msg", "", "isFinish", "", "a", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements n.a<EditBatchMediaRsp> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f53956b;

        b(String str) {
            this.f53956b = str;
        }

        @Override // com.qzone.reborn.base.n.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(EditBatchMediaRsp t16, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(t16, "t");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            n.this.W9(this.f53956b);
            QQToastUtil.showQQToastInUiThread(5, "\u5df2\u8bbe\u7f6e");
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, String errorMsg) {
            QQToastUtil.showQQToastInUiThread(4, "\u8bbe\u7f6e\u5931\u8d25");
        }
    }

    private final void K9(boolean isVisible) {
        View view = this.descLayout;
        if (view != null) {
            view.setVisibility(isVisible ? 0 : 8);
        }
        if (!E9()) {
            R9();
        } else {
            T9();
        }
    }

    private final void L9() {
        fo.c.n(this.descEditTv, "em_qz_add_description");
    }

    private final void M9(RFWLayerVideoPlayEvent event) {
        String str = event.videoId;
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        if (TextUtils.equals(str, rFWLayerItemMediaInfo != null ? rFWLayerItemMediaInfo.getMediaId() : null)) {
            int i3 = event.isPlay ? 8 : 0;
            View view = this.descLayout;
            if (view == null) {
                return;
            }
            Intrinsics.checkNotNull(view);
            view.setVisibility(i3);
            N9();
            String str2 = event.videoId;
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo2 = this.mCurrentSelectedItem;
            String mediaId = rFWLayerItemMediaInfo2 != null ? rFWLayerItemMediaInfo2.getMediaId() : null;
            QLog.d("QzoneFeedProLayerDescPart", 1, "onReceiveEvent, RFWLayerVideoPlayEvent: videoId: " + str2 + ", itemId: " + mediaId + ", isPlay: " + event.isPlay);
        }
    }

    private final void N9() {
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.feedpro.layer.part.m
            @Override // java.lang.Runnable
            public final void run() {
                n.O9(n.this);
            }
        }, 50L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(n this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view = this$0.descLayout;
        if (view == null) {
            return;
        }
        Intrinsics.checkNotNull(view);
        IVideoPlayerProvider videoControlProvider = RFWLayerIOCUtil.getVideoControlProvider(view);
        if (videoControlProvider == null || videoControlProvider.isPlaying()) {
            return;
        }
        videoControlProvider.changeOperationLayoutVisible(IVideoPlayerProvider.ControlLayoutVisibleState.GONE);
    }

    private final void R9() {
        LinearLayout linearLayout = this.descEditContainer;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        CellTextView cellTextView = this.descTextTv;
        if (cellTextView != null) {
            cellTextView.setVisibility(8);
        }
        CellTextView cellTextView2 = this.descEditTv;
        if (cellTextView2 != null) {
            cellTextView2.setCellClickable(false);
        }
        CellTextView cellTextView3 = this.descEditTv;
        if (cellTextView3 != null) {
            cellTextView3.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.layer.part.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    n.S9(n.this, view);
                }
            });
        }
        QzoneFeedProLayerExtraInfoBean x95 = x9();
        if (TextUtils.isEmpty(x95 != null ? x95.getDesc() : null)) {
            CellTextView cellTextView4 = this.descEditTv;
            if (cellTextView4 != null) {
                cellTextView4.setRichText(com.qzone.util.l.a(R.string.s46));
                return;
            }
            return;
        }
        CellTextView cellTextView5 = this.descEditTv;
        if (cellTextView5 != null) {
            QzoneFeedProLayerExtraInfoBean x96 = x9();
            cellTextView5.setRichText(x96 != null ? x96.getDesc() : null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(n this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.V9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void T9() {
        LinearLayout linearLayout = this.descEditContainer;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        QzoneFeedProLayerExtraInfoBean x95 = x9();
        if (TextUtils.isEmpty(x95 != null ? x95.getDesc() : null)) {
            CellTextView cellTextView = this.descTextTv;
            if (cellTextView == null) {
                return;
            }
            cellTextView.setVisibility(8);
            return;
        }
        CellTextView cellTextView2 = this.descTextTv;
        if (cellTextView2 != null) {
            QzoneFeedProLayerExtraInfoBean x96 = x9();
            cellTextView2.setRichText(x96 != null ? x96.getDesc() : null);
        }
        CellTextView cellTextView3 = this.descTextTv;
        if (cellTextView3 != null) {
            cellTextView3.setVisibility(0);
        }
        CellTextView cellTextView4 = this.descTextTv;
        if (cellTextView4 != null) {
            cellTextView4.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.layer.part.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    n.U9(n.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(n this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.P9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void V9() {
        long uin = LoginData.getInstance().getUin();
        QzoneFeedProLayerExtraInfoBean x95 = x9();
        String albumId = x95 != null ? x95.getAlbumId() : null;
        QzoneFeedProLayerExtraInfoBean x96 = x9();
        String str = uin + "_" + albumId + "_" + (x96 != null ? x96.getLLoc() : null);
        QZoneCommentPanelParams.a y16 = new QZoneCommentPanelParams.a().y(7);
        QzoneFeedProLayerExtraInfoBean x97 = x9();
        ho.i.c().l(y16.d(x97 != null ? x97.getDesc() : null).g(str).i(false).t(200).getParams(), getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W9(String latestDesc) {
        RFWLayerState data;
        UIStateData<RFWLayerState> value = getMLayerViewModel().mRichMediaInfo.getValue();
        List<RFWLayerItemMediaInfo> richMediaDataList = (value == null || (data = value.getData()) == null) ? null : data.getRichMediaDataList();
        boolean z16 = false;
        if (ArrayUtils.isOutOfArrayIndex(0, richMediaDataList)) {
            return;
        }
        Intrinsics.checkNotNull(richMediaDataList);
        for (RFWLayerItemMediaInfo rFWLayerItemMediaInfo : richMediaDataList) {
            String mediaId = rFWLayerItemMediaInfo.getMediaId();
            QzoneFeedProLayerExtraInfoBean x95 = x9();
            if (TextUtils.equals(mediaId, x95 != null ? x95.getLLoc() : null) && (rFWLayerItemMediaInfo.getExtraData() instanceof QzoneFeedProLayerExtraInfoBean)) {
                Object extraData = rFWLayerItemMediaInfo.getExtraData();
                Intrinsics.checkNotNull(extraData, "null cannot be cast to non-null type com.qzone.reborn.feedpro.layer.router.QzoneFeedProLayerExtraInfoBean");
                QzoneFeedProLayerExtraInfoBean qzoneFeedProLayerExtraInfoBean = (QzoneFeedProLayerExtraInfoBean) extraData;
                qzoneFeedProLayerExtraInfoBean.u(latestDesc);
                rFWLayerItemMediaInfo.setExtraData(qzoneFeedProLayerExtraInfoBean);
                z16 = true;
            }
        }
        if (z16) {
            getMLayerViewModel().mRichMediaInfo.setValue(getMLayerViewModel().mRichMediaInfo.getValue());
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(RFWLayerVideoPlayEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 7 && resultCode == -1) {
            Q9(data);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        this.operateViewModel = (ke.d) getViewModel(ke.d.class);
        Intrinsics.checkNotNull(rootView);
        this.descEditContainer = (LinearLayout) rootView.findViewById(R.id.mwu);
        this.descEditIcon = (ImageView) rootView.findViewById(R.id.mwv);
        this.descLayout = rootView.findViewById(R.id.mww);
        this.descEditTv = (CellTextView) rootView.findViewById(R.id.mwt);
        this.descTextTv = (CellTextView) rootView.findViewById(R.id.mwx);
        SimpleEventBus.getInstance().registerReceiver(this);
        RFWLayerIOCUtil.registerControlVisibleChangeListener(rootView, this);
        AccessibilityUtil.p(this.descEditIcon, com.qzone.util.l.a(R.string.f133165d));
        L9();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.i
    public void onLayerStateUpdate(RFWLayerState layerState) {
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        super.onLayerStateUpdate(layerState);
        QzoneFeedProLayerExtraInfoBean x95 = x9();
        boolean z16 = false;
        if (x95 != null && !x95.getIsVideo()) {
            z16 = true;
        }
        K9(z16);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        RFWIocAbilityProvider.g().unregisterGlobalIoc(activity, IVideoControlLayoutChangeListener.class);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof RFWLayerVideoPlayEvent) {
            M9((RFWLayerVideoPlayEvent) event);
        }
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.IVideoControlLayoutChangeListener
    public void onVisibleChange(RFWLayerItemMediaInfo itemInfo, boolean isVisible) {
        Intrinsics.checkNotNullParameter(itemInfo, "itemInfo");
        QzoneFeedProLayerExtraInfoBean x95 = x9();
        boolean z16 = false;
        if (x95 != null && x95.getIsVideo()) {
            z16 = true;
        }
        if (z16) {
            K9(!isVisible);
        }
    }

    private final void Q9(Intent data) {
        String str;
        int collectionSizeOrDefault;
        if (data == null) {
            return;
        }
        Parcelable parcelableExtra = data.getParcelableExtra("comment_panel_result_bean");
        if (!(parcelableExtra instanceof QZoneCommentPanelResultBean)) {
            QLog.e("QzoneFeedProLayerDescPart", 1, "[onFinishEditPhotoDescNew] bean is not instanceof");
            return;
        }
        String inputContent = ((QZoneCommentPanelResultBean) parcelableExtra).getInputContent();
        QzoneFeedProLayerExtraInfoBean x95 = x9();
        if (x95 != null) {
            x95.u(inputContent);
        }
        K9(true);
        ArrayList arrayList = new ArrayList();
        arrayList.add(2);
        ge.c cVar = new ge.c();
        QzoneFeedProLayerExtraInfoBean x96 = x9();
        if (x96 == null || (str = x96.getAlbumId()) == null) {
            str = "";
        }
        cVar.d(str);
        cVar.f(arrayList);
        ArrayList arrayList2 = new ArrayList();
        EditPhoto editPhoto = new EditPhoto(null, null, null, null, null, null, 63, null);
        QzoneFeedProLayerExtraInfoBean x97 = x9();
        editPhoto.picId = x97 != null ? x97.getLLoc() : null;
        QzoneFeedProLayerExtraInfoBean x98 = x9();
        editPhoto.name = x98 != null ? x98.getAlbumName() : null;
        editPhoto.desc = inputContent;
        QzoneFeedProLayerExtraInfoBean x99 = x9();
        editPhoto.shootTime = x99 != null ? Long.valueOf(x99.getShootTime()) : null;
        if (x9() != null) {
            List<Long> list = editPhoto.opmask;
            QzoneFeedProLayerExtraInfoBean x910 = x9();
            Intrinsics.checkNotNull(x910);
            ArrayList<Integer> j3 = x910.j();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(j3, 10);
            ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = j3.iterator();
            while (it.hasNext()) {
                arrayList3.add(Long.valueOf(((Number) it.next()).intValue()));
            }
            list.addAll(arrayList3);
        }
        arrayList2.add(editPhoto);
        cVar.e(arrayList2);
        ke.d dVar = this.operateViewModel;
        if (dVar != null) {
            dVar.N1(cVar, new b(inputContent));
        }
    }

    private final void P9() {
    }
}
