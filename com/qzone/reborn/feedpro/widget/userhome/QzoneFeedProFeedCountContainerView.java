package com.qzone.reborn.feedpro.widget.userhome;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.qzone.reborn.feedpro.utils.aa;
import com.qzone.reborn.feedpro.viewmodel.m;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001+B+\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0016J\u001a\u0010\f\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0014J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0014R\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006,"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/userhome/QzoneFeedProFeedCountContainerView;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "", "", "s0", "Lcom/qzone/reborn/feedpro/viewmodel/m;", "viewModel", "r0", "getLayoutId", "Landroid/content/Context;", "context", "viewType", "initView", "data", com.tencent.luggage.wxa.c8.c.G, "q0", "Lcom/qzone/reborn/feedx/viewmodel/c;", "e", "Lcom/qzone/reborn/feedx/viewmodel/c;", "getMViewModelProvider", "()Lcom/qzone/reborn/feedx/viewmodel/c;", "mViewModelProvider", "Landroidx/lifecycle/LifecycleOwner;", "f", "Landroidx/lifecycle/LifecycleOwner;", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/biz/richframework/part/PartManager;", h.F, "Lcom/tencent/biz/richframework/part/PartManager;", "partManager", "Landroid/view/View;", "i", "Landroid/view/View;", ParseCommon.CONTAINER, "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "mTvFeedCount", "<init>", "(Landroid/content/Context;Lcom/qzone/reborn/feedx/viewmodel/c;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/biz/richframework/part/PartManager;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFeedProFeedCountContainerView extends QZoneBaseWidgetView<Integer> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final com.qzone.reborn.feedx.viewmodel.c mViewModelProvider;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final PartManager partManager;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View container;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView mTvFeedCount;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProFeedCountContainerView(Context context, com.qzone.reborn.feedx.viewmodel.c mViewModelProvider, LifecycleOwner lifecycleOwner, PartManager partManager) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mViewModelProvider, "mViewModelProvider");
        this.mViewModelProvider = mViewModelProvider;
        this.lifecycleOwner = lifecycleOwner;
        this.partManager = partManager;
        s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r0(m viewModel) {
        UIStateData<List<CommonFeed>> value = viewModel.N1().getValue();
        Object obj = null;
        List<CommonFeed> data = value != null ? value.getData() : null;
        List<CommonFeed> list = data;
        if (list == null || list.isEmpty()) {
            View view = this.container;
            if (view == null) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        Iterator<T> it = data.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (!CommonFeedExtKt.isMemorySealFeed((CommonFeed) next)) {
                obj = next;
                break;
            }
        }
        if (((CommonFeed) obj) == null) {
            View view2 = this.container;
            if (view2 == null) {
                return;
            }
            view2.setVisibility(8);
            return;
        }
        View view3 = this.container;
        if (view3 == null) {
            return;
        }
        view3.setVisibility(0);
    }

    private final void s0() {
        MutableLiveData<UIStateData<List<CommonFeed>>> N1;
        MutableLiveData<Integer> i26;
        final m mVar = (m) this.mViewModelProvider.W(m.class);
        if (this.lifecycleOwner != null) {
            if (mVar != null && (i26 = mVar.i2()) != null) {
                LifecycleOwner lifecycleOwner = this.lifecycleOwner;
                final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.qzone.reborn.feedpro.widget.userhome.QzoneFeedProFeedCountContainerView$init$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                        invoke2(num);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Integer num) {
                        QzoneFeedProFeedCountContainerView qzoneFeedProFeedCountContainerView = QzoneFeedProFeedCountContainerView.this;
                        m viewModel = mVar;
                        Intrinsics.checkNotNullExpressionValue(viewModel, "viewModel");
                        qzoneFeedProFeedCountContainerView.r0(viewModel);
                    }
                };
                i26.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.feedpro.widget.userhome.b
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        QzoneFeedProFeedCountContainerView.u0(Function1.this, obj);
                    }
                });
            }
            if (mVar == null || (N1 = mVar.N1()) == null) {
                return;
            }
            LifecycleOwner lifecycleOwner2 = this.lifecycleOwner;
            final Function1<UIStateData<List<? extends CommonFeed>>, Unit> function12 = new Function1<UIStateData<List<? extends CommonFeed>>, Unit>() { // from class: com.qzone.reborn.feedpro.widget.userhome.QzoneFeedProFeedCountContainerView$init$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(UIStateData<List<? extends CommonFeed>> uIStateData) {
                    invoke2((UIStateData<List<CommonFeed>>) uIStateData);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(UIStateData<List<CommonFeed>> uIStateData) {
                    QzoneFeedProFeedCountContainerView qzoneFeedProFeedCountContainerView = QzoneFeedProFeedCountContainerView.this;
                    m viewModel = mVar;
                    Intrinsics.checkNotNullExpressionValue(viewModel, "viewModel");
                    qzoneFeedProFeedCountContainerView.r0(viewModel);
                }
            };
            N1.observe(lifecycleOwner2, new Observer() { // from class: com.qzone.reborn.feedpro.widget.userhome.c
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QzoneFeedProFeedCountContainerView.v0(Function1.this, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(QzoneFeedProFeedCountContainerView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RFWLog.d("QzoneFeedProFeedCountContainerView", RFWLog.USR, "onClick timeLineIcon");
        PartManager partManager = this$0.partManager;
        if (partManager != null) {
            partManager.broadcastMessage("SHOW_TIME_LINE", null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public /* bridge */ /* synthetic */ void bindData(Object obj, int i3) {
        q0(((Number) obj).intValue(), i3);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f1298779;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void initView(Context context, int viewType) {
        super.initView(context, viewType);
        this.container = getRootView().findViewById(R.id.f20889l);
        ImageView imageView = (ImageView) findViewById(R.id.n9o);
        if (imageView != null) {
            aa.c(aa.f54263a, imageView, 0.0f, 1, null);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.widget.userhome.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QzoneFeedProFeedCountContainerView.w0(QzoneFeedProFeedCountContainerView.this, view);
                }
            });
            com.tencent.mobileqq.qzone.picload.c.a().m(imageView, getContext().getResources().getColor(R.color.qui_common_icon_secondary));
            fo.c.q(imageView, "em_qz_time_shaft", null);
        }
        TextView textView = (TextView) findViewById(R.id.n9m);
        this.mTvFeedCount = textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        View view = this.container;
        if (view == null) {
            return;
        }
        view.setVisibility(8);
    }

    protected void q0(int data, int pos) {
    }
}
