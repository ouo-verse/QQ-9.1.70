package com.qzone.reborn.message.part;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import bl.CommonNoticeBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0016\u0010\f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/qzone/reborn/message/part/QZonePassiveMessageWechatGuildPart;", "Lcom/qzone/reborn/base/k;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "G9", "", "shouldShow", "J9", "onInitView", "d", "Z", "mIsTopTipsClosed", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "mTopTipsLayout", "<init>", "()V", "f", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZonePassiveMessageWechatGuildPart extends com.qzone.reborn.base.k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean mIsTopTipsClosed;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mTopTipsLayout;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(QZonePassiveMessageWechatGuildPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewGroup viewGroup = this$0.mTopTipsLayout;
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ViewGroup viewGroup2 = this$0.mTopTipsLayout;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(8);
        }
        this$0.mIsTopTipsClosed = true;
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J9(boolean shouldShow) {
        ViewGroup viewGroup = this.mTopTipsLayout;
        if (viewGroup == null || viewGroup == null) {
            return;
        }
        viewGroup.setVisibility(shouldShow ? 0 : 8);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        G9(rootView);
        LiveData<UIStateData<List<CommonNoticeBean>>> v3 = ((hl.d) getViewModel(hl.d.class)).v();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<UIStateData<List<? extends CommonNoticeBean>>, Unit> function1 = new Function1<UIStateData<List<? extends CommonNoticeBean>>, Unit>() { // from class: com.qzone.reborn.message.part.QZonePassiveMessageWechatGuildPart$onInitView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<List<? extends CommonNoticeBean>> uIStateData) {
                invoke2((UIStateData<List<CommonNoticeBean>>) uIStateData);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:6:0x0022, code lost:
            
                if (r3 == false) goto L10;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(UIStateData<List<CommonNoticeBean>> uIStateData) {
                boolean z16;
                boolean z17;
                QZonePassiveMessageWechatGuildPart qZonePassiveMessageWechatGuildPart = QZonePassiveMessageWechatGuildPart.this;
                if (uIStateData.getData() != null) {
                    Intrinsics.checkNotNullExpressionValue(uIStateData.getData(), "it.data");
                    z16 = true;
                    if (!r3.isEmpty()) {
                        z17 = QZonePassiveMessageWechatGuildPart.this.mIsTopTipsClosed;
                    }
                }
                z16 = false;
                qZonePassiveMessageWechatGuildPart.J9(z16);
            }
        };
        v3.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.message.part.x
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZonePassiveMessageWechatGuildPart.I9(Function1.this, obj);
            }
        });
    }

    private final void G9(View rootView) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2 = rootView != null ? (ViewGroup) rootView.findViewById(R.id.n7x) : null;
        this.mTopTipsLayout = viewGroup2;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(8);
        }
        if (getActivity() != null) {
            IWeChatGuildApi iWeChatGuildApi = (IWeChatGuildApi) QRoute.api(IWeChatGuildApi.class);
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            View qZoneWechatGuildNoticeBar = iWeChatGuildApi.getQZoneWechatGuildNoticeBar(activity, new View.OnClickListener() { // from class: com.qzone.reborn.message.part.y
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QZonePassiveMessageWechatGuildPart.H9(QZonePassiveMessageWechatGuildPart.this, view);
                }
            });
            RFWLog.d("QZonePassiveMessageWechatGuildPart", RFWLog.USR, "initTopTips: " + qZoneWechatGuildNoticeBar);
            if (qZoneWechatGuildNoticeBar == null || (viewGroup = this.mTopTipsLayout) == null) {
                return;
            }
            viewGroup.addView(qZoneWechatGuildNoticeBar);
        }
    }
}
