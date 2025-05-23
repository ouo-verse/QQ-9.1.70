package com.tencent.biz.qqcircle.immersive.feed.live;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.events.QFSUnShowFreeFlowViewEvent;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.feed.live.ecommerce.ECLiveGoodsInstructionBubbleViewModel;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudCommon$BytesEntry;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 52\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00016B\u0007\u00a2\u0006\u0004\b3\u00104J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\tH\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\tH\u0016J\u001a\u0010\u0014\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\u0012\u0010\u0017\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016R\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010\"R\u0016\u0010*\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010\"R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u00067"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/live/QFSFeedChildLiveBottomInfoPresenter;", "Lcom/tencent/biz/qqcircle/immersive/feed/QFSBaseFeedChildPresenter;", "Lfeedcloud/FeedCloudMeta$StFeed;", "Landroid/view/View$OnClickListener;", "data", "", "m1", "l1", "j1", "Landroid/view/View;", "v", "h1", "view", "g1", "", com.tencent.luggage.wxa.c8.c.G, "k1", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "N0", "position", "i1", "Lcom/tencent/biz/richframework/video/rfw/drive/RFWFeedSelectInfo;", "selectInfo", "onFeedSelected", NodeProps.ON_CLICK, "Q0", "", "w0", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "I", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "aegisLog", "Landroid/widget/TextView;", "J", "Landroid/widget/TextView;", "authorNameView", "K", "Landroid/view/View;", "goodsLayout", "L", "goodsSubTextView", "M", "goodsNameTextView", "Lcom/tencent/biz/qqcircle/immersive/feed/live/c;", "N", "Lcom/tencent/biz/qqcircle/immersive/feed/live/c;", "liveTitleController", "Lcom/tencent/biz/qqcircle/immersive/feed/live/ecommerce/ECLiveGoodsInstructionBubbleViewModel;", "P", "Lcom/tencent/biz/qqcircle/immersive/feed/live/ecommerce/ECLiveGoodsInstructionBubbleViewModel;", "liveGoodsInstructionBubbleViewModel", "<init>", "()V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSFeedChildLiveBottomInfoPresenter extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements View.OnClickListener {

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final IAegisLogApi aegisLog;

    /* renamed from: J, reason: from kotlin metadata */
    private TextView authorNameView;

    /* renamed from: K, reason: from kotlin metadata */
    private View goodsLayout;

    /* renamed from: L, reason: from kotlin metadata */
    private TextView goodsSubTextView;

    /* renamed from: M, reason: from kotlin metadata */
    private TextView goodsNameTextView;

    /* renamed from: N, reason: from kotlin metadata */
    private c liveTitleController;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final ECLiveGoodsInstructionBubbleViewModel liveGoodsInstructionBubbleViewModel;

    public QFSFeedChildLiveBottomInfoPresenter() {
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.aegisLog = (IAegisLogApi) api;
        this.liveGoodsInstructionBubbleViewModel = new ECLiveGoodsInstructionBubbleViewModel();
    }

    private final void g1(View view) {
        e30.b bVar = this.E;
        if (bVar != null && bVar.g() != null) {
            VideoReport.setElementId(view, "em_xsj_author_name");
            VideoReport.setElementReuseIdentifier(view, "em_xsj_author_name" + this.E.g().f398449id.get());
            HashMap hashMap = new HashMap();
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(this.f85018i + 1));
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_MUSIC_TYPE, Integer.valueOf(this.E.g().musicInfo.scene.get()));
            VideoReport.setElementParams(view, hashMap);
            VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void h1(View v3) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = (FeedCloudMeta$StFeed) this.f85017h;
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        qCircleInitBean.setFeed(feedCloudMeta$StFeed);
        qCircleInitBean.setUser(feedCloudMeta$StFeed.poster.get());
        qCircleInitBean.setFromReportBean(getReportBean().m466clone());
        com.tencent.biz.qqcircle.launcher.c.d0(v3.getContext(), qCircleInitBean);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void j1() {
        String str;
        Object obj;
        boolean z16;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        String str2;
        PBUInt32Field pBUInt32Field;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2;
        QCircleExtraTypeInfo qCircleExtraTypeInfo = this.D;
        if (qCircleExtraTypeInfo != null && (feedCloudMeta$StFeed2 = qCircleExtraTypeInfo.mFeed) != null) {
            str = feedCloudMeta$StFeed2.poster.f398463id.get();
        } else {
            str = "";
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed3 = (FeedCloudMeta$StFeed) this.f85017h;
        if (feedCloudMeta$StFeed3 != null && (pBUInt32Field = feedCloudMeta$StFeed3.type) != null) {
            obj = Integer.valueOf(pBUInt32Field.get());
        } else {
            obj = Boolean.FALSE;
        }
        if ((obj instanceof Integer) && 2 == ((Number) obj).intValue()) {
            z16 = true;
        } else {
            z16 = false;
        }
        QCircleExtraTypeInfo qCircleExtraTypeInfo2 = this.D;
        if (qCircleExtraTypeInfo2 != null) {
            feedCloudMeta$StFeed = qCircleExtraTypeInfo2.mFeed;
        } else {
            feedCloudMeta$StFeed = null;
        }
        QCircleLpReportDc05507.DataBuilder dataBuilder = new QCircleLpReportDc05507.DataBuilder(ua0.c.c(feedCloudMeta$StFeed));
        QCircleLpReportDc05507.DataBuilder toUin = dataBuilder.setActionType(81).setSubActionType(1).setToUin(str);
        if (z16) {
            str2 = "1";
        } else {
            str2 = "2";
        }
        toUin.setExt1(str2).setPageId(y0()).setfpageid(getReportBean().getFromPageId());
        QCircleLpReportDc05507.report(dataBuilder);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void k1(int pos) {
        QCircleLpReportDc05507.DataBuilder dataBuilder = new QCircleLpReportDc05507.DataBuilder(ua0.c.c((FeedCloudMeta$StFeed) this.f85017h));
        dataBuilder.setActionType(5);
        dataBuilder.setSubActionType(2);
        dataBuilder.setPageId(dataBuilder.getPageId());
        dataBuilder.setPosition(pos);
        QCircleLpReportDc05507.report(dataBuilder);
    }

    private final void l1(FeedCloudMeta$StFeed data) {
        String str;
        if (this.authorNameView == null) {
            QLog.d("LiveBottomInfoPresenter", 1, "[updateAuthorNameView] author name view should not be null.");
            return;
        }
        String str2 = data.poster.nick.get();
        TextView textView = this.authorNameView;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authorNameView");
            textView = null;
        }
        if (TextUtils.isEmpty(str2)) {
            str = "";
        } else {
            str = "@" + str2;
        }
        textView.setText(str);
        TextView textView3 = this.authorNameView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authorNameView");
        } else {
            textView2 = textView3;
        }
        g1(textView2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00bf, code lost:
    
        if (r14 != false) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void m1(FeedCloudMeta$StFeed data) {
        boolean z16;
        View view;
        boolean z17;
        boolean z18;
        boolean z19 = false;
        if (com.tencent.biz.qqcircle.immersive.adapter.n.g(data) == 1) {
            List<FeedCloudCommon$BytesEntry> list = data.live.liveBytesExtInfo.get();
            Intrinsics.checkNotNullExpressionValue(list, "data.live.liveBytesExtInfo.get()");
            if (!list.isEmpty()) {
                int size = list.size();
                boolean z26 = false;
                z16 = false;
                for (int i3 = 0; i3 < size; i3++) {
                    FeedCloudCommon$BytesEntry feedCloudCommon$BytesEntry = list.get(i3);
                    String str = feedCloudCommon$BytesEntry.key.get();
                    QLog.d("LiveBottomInfoPresenter", 1, "updateGoodsLiveData key:" + str + ",value:" + feedCloudCommon$BytesEntry.value.get() + ",parent hashCode:" + hashCode());
                    if ("qqlive_ecom_ext".equals(str)) {
                        try {
                            JSONObject jSONObject = new JSONObject(feedCloudCommon$BytesEntry.value.get().toStringUtf8());
                            if (jSONObject.optInt("buf_type") == 1) {
                                String goodsTitle = jSONObject.optString("title");
                                String goodsDesc = jSONObject.optString("desc");
                                Intrinsics.checkNotNullExpressionValue(goodsTitle, "goodsTitle");
                                if (goodsTitle.length() > 0) {
                                    z17 = true;
                                } else {
                                    z17 = false;
                                }
                                if (!z17) {
                                    Intrinsics.checkNotNullExpressionValue(goodsDesc, "goodsDesc");
                                    if (goodsDesc.length() > 0) {
                                        z18 = true;
                                    } else {
                                        z18 = false;
                                    }
                                }
                                View view2 = this.goodsLayout;
                                if (view2 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("goodsLayout");
                                    view2 = null;
                                }
                                view2.setVisibility(0);
                                TextView textView = this.goodsSubTextView;
                                if (textView == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("goodsSubTextView");
                                    textView = null;
                                }
                                textView.setText(goodsTitle);
                                TextView textView2 = this.goodsNameTextView;
                                if (textView2 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("goodsNameTextView");
                                    textView2 = null;
                                }
                                textView2.setText(goodsDesc);
                                z26 = true;
                                z16 = this.liveGoodsInstructionBubbleViewModel.o(data, jSONObject, new Function0<Unit>() { // from class: com.tencent.biz.qqcircle.immersive.feed.live.QFSFeedChildLiveBottomInfoPresenter$updateGoodsLiveData$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        QFSFeedChildLiveBottomInfoPresenter.this.T0(new com.tencent.biz.qqcircle.immersive.feed.event.o());
                                    }
                                });
                            }
                        } catch (Exception e16) {
                            QLog.e("LiveBottomInfoPresenter", 1, "updateGoodsLiveData error :" + e16.getMessage());
                        }
                    }
                }
                z19 = z26;
                if (!z19) {
                    View view3 = this.goodsLayout;
                    if (view3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("goodsLayout");
                        view = null;
                    } else {
                        view = view3;
                    }
                    view.setVisibility(8);
                }
                if (z16) {
                    this.liveGoodsInstructionBubbleViewModel.k();
                    return;
                }
                return;
            }
        }
        z16 = false;
        if (!z19) {
        }
        if (z16) {
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.N0(rootView);
        View findViewById = rootView.findViewById(R.id.vab);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026ow_live_feed_author_name)");
        TextView textView = (TextView) findViewById;
        this.authorNameView = textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authorNameView");
            textView = null;
        }
        textView.setOnClickListener(this);
        View findViewById2 = rootView.findViewById(R.id.v_x);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026ash_show_feed_live_title)");
        this.liveTitleController = new c((TextView) findViewById2, this.aegisLog);
        View findViewById3 = rootView.findViewById(R.id.yml);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.living_goods_layout)");
        this.goodsLayout = findViewById3;
        View findViewById4 = rootView.findViewById(R.id.ymn);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.living_goods_sub_text)");
        this.goodsSubTextView = (TextView) findViewById4;
        View findViewById5 = rootView.findViewById(R.id.ymm);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.living_goods_name_text)");
        this.goodsNameTextView = (TextView) findViewById5;
        this.liveGoodsInstructionBubbleViewModel.j(rootView);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void Q0() {
        super.Q0();
        j1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: i1, reason: merged with bridge method [inline-methods] */
    public void L0(@Nullable FeedCloudMeta$StFeed data, int position) {
        super.L0(data, position);
        this.f85017h = data;
        if (data == 0) {
            QLog.d("LiveBottomInfoPresenter", 1, "[onBindData] data should not be null.");
        } else {
            m1(data);
            l1(data);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (v3.getId() == R.id.vab) {
            k1(this.f85018i);
            h1(v3);
            SimpleEventBus.getInstance().dispatchEvent(new QFSUnShowFreeFlowViewEvent());
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(@Nullable RFWFeedSelectInfo selectInfo) {
        super.onFeedSelected(selectInfo);
        c cVar = this.liveTitleController;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveTitleController");
            cVar = null;
        }
        T mData = this.f85017h;
        Intrinsics.checkNotNullExpressionValue(mData, "mData");
        cVar.b((FeedCloudMeta$StFeed) mData);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    @NotNull
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildLiveBottomInfoPresenter";
    }
}
