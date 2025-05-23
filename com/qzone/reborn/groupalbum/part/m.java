package com.qzone.reborn.groupalbum.part;

import aa.f;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumNoticeInitBean;
import com.qzone.reborn.groupalbum.event.GroupAlbumFeedTabRefreshEvent;
import com.qzone.reborn.groupalbum.viewmodel.aj;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.quibadge.QUIBadge;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.IReddotReaderServiceGetRedPointsCallback;
import com.tencent.qqnt.kernel.nativeinterface.RedPoint;
import com.tencent.qqnt.kernel.nativeinterface.SceneType;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 02\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u00011B\u0007\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0014\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\tH\u0016J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0012\u0010\u001d\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001e\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010 \u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010!\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010%\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030#0\"j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030#`$H\u0016R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00062"}, d2 = {"Lcom/qzone/reborn/groupalbum/part/m;", "Lcom/qzone/reborn/base/k;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Landroid/view/View$OnClickListener;", "", "G9", "H9", "", "", "", "I9", "P9", "", WidgetCacheConstellationData.NUM, "L9", "F9", "K9", "", "J9", "Lcom/qzone/reborn/groupalbum/event/GroupAlbumFeedTabRefreshEvent;", "event", "M9", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartDestroy", "v", NodeProps.ON_CLICK, "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/mobileqq/quibadge/QUIBadge;", "d", "Lcom/tencent/mobileqq/quibadge/QUIBadge;", "redPointText", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "redImageView", "<init>", "()V", "f", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class m extends com.qzone.reborn.base.k implements SimpleEventReceiver<SimpleBaseEvent>, View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QUIBadge redPointText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView redImageView;

    private final void F9(long num) {
        int a16;
        QUIBadge qUIBadge = this.redPointText;
        QUIBadge qUIBadge2 = null;
        if (qUIBadge == null) {
            Intrinsics.throwUninitializedPropertyAccessException("redPointText");
            qUIBadge = null;
        }
        ViewGroup.LayoutParams layoutParams = qUIBadge.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (num <= 9) {
            a16 = com.tencent.biz.qui.quicommon.e.a(6.0f);
        } else if (num <= 99) {
            a16 = com.tencent.biz.qui.quicommon.e.a(12.0f);
        } else {
            a16 = com.tencent.biz.qui.quicommon.e.a(15.0f);
        }
        layoutParams2.setMargins(0, (-com.tencent.biz.qui.quicommon.e.a(18.0f)) / 2, (-a16) / 2, 0);
        QUIBadge qUIBadge3 = this.redPointText;
        if (qUIBadge3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("redPointText");
            qUIBadge3 = null;
        }
        qUIBadge3.setLayoutParams(layoutParams2);
        QUIBadge qUIBadge4 = this.redPointText;
        if (qUIBadge4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("redPointText");
        } else {
            qUIBadge2 = qUIBadge4;
        }
        qUIBadge2.setVisibility(0);
    }

    private final void G9() {
        ImageView imageView = this.redImageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("redImageView");
            imageView = null;
        }
        fo.c.e("em_qz_message_entry", "pg_qz_group_dynamic_tab", imageView, I9());
    }

    private final void H9() {
        ImageView imageView = this.redImageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("redImageView");
            imageView = null;
        }
        fo.c.g("em_qz_message_entry", "pg_qz_group_dynamic_tab", imageView, I9());
    }

    private final Map<String, Object> I9() {
        Map<String, Object> mutableMapOf;
        aj ajVar = (aj) getViewModel(aj.class);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("group_uin", ajVar.P1().getGroupId()));
        if (ajVar.getMTabIndex() == 0) {
            mutableMapOf.put("source", 0);
        } else {
            mutableMapOf.put("source", 1);
        }
        return mutableMapOf;
    }

    private final void K9() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        GroupAlbumNoticeInitBean groupAlbumNoticeInitBean = new GroupAlbumNoticeInitBean(fj.e.d(context));
        oi.c m3 = ho.i.m();
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        m3.k(context2, groupAlbumNoticeInitBean);
    }

    private final void M9(GroupAlbumFeedTabRefreshEvent event) {
        QLog.d("GroupAlbumMainPageTitlePart", 1, "handleTabRefreshEvent event:=" + event.getFromSource());
        P9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(m this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(m this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QUIBadge qUIBadge = this$0.redPointText;
        if (qUIBadge == null) {
            Intrinsics.throwUninitializedPropertyAccessException("redPointText");
            qUIBadge = null;
        }
        qUIBadge.setVisibility(8);
        this$0.K9();
        this$0.G9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void P9() {
        ((aj) getViewModel(aj.class)).T1(SceneType.KSCENETYPEMAINPAGE, new b());
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "GroupAlbumMainPageTitlePart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.kua) {
            getActivity().onBackPressed();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        rootView.findViewById(R.id.ldf).setOnClickListener(this);
        ViewGroup viewGroup = (ViewGroup) rootView.findViewById(R.id.k68);
        ImageView imageView = null;
        ViewGroup.LayoutParams layoutParams = viewGroup != null ? viewGroup.getLayoutParams() : null;
        if (layoutParams != null) {
            layoutParams.height = ImmersiveUtils.getStatusBarHeight(getContext()) + J9();
        }
        if (viewGroup != null) {
            viewGroup.setPadding(0, ImmersiveUtils.getStatusBarHeight(getContext()), 0, 0);
        }
        View findViewById = rootView.findViewById(R.id.kua);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.groupalbum.part.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    m.N9(m.this, view);
                }
            });
        }
        f.Companion companion = aa.f.INSTANCE;
        companion.a(findViewById);
        View findViewById2 = rootView.findViewById(R.id.llu);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.iv_msg_redpoint)");
        this.redPointText = (QUIBadge) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.ldf);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.iv_message_icon)");
        ImageView imageView2 = (ImageView) findViewById3;
        this.redImageView = imageView2;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("redImageView");
            imageView2 = null;
        }
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.groupalbum.part.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                m.O9(m.this, view);
            }
        });
        ImageView imageView3 = this.redImageView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("redImageView");
            imageView3 = null;
        }
        rn.h.a(imageView3, "qui_remind", R.color.qui_common_icon_nav_secondary);
        QUIBadge qUIBadge = this.redPointText;
        if (qUIBadge == null) {
            Intrinsics.throwUninitializedPropertyAccessException("redPointText");
            qUIBadge = null;
        }
        companion.a(qUIBadge);
        ImageView imageView4 = this.redImageView;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("redImageView");
        } else {
            imageView = imageView4;
        }
        companion.a(imageView);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        P9();
        SimpleEventBus.getInstance().registerReceiver(this);
        H9();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof GroupAlbumFeedTabRefreshEvent) {
            M9((GroupAlbumFeedTabRefreshEvent) event);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GroupAlbumFeedTabRefreshEvent.class);
        return arrayListOf;
    }

    private final int J9() {
        return ef.d.b(50);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J>\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tH\u0016\u00a8\u0006\r"}, d2 = {"com/qzone/reborn/groupalbum/part/m$b", "Lcom/tencent/qqnt/kernel/nativeinterface/IReddotReaderServiceGetRedPointsCallback;", "", "seq", "result", "", "errMs", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/RedPoint;", "Lkotlin/collections/ArrayList;", "redPoints", "", "onGetRedPoints", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements IReddotReaderServiceGetRedPointsCallback {
        b() {
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IReddotReaderServiceGetRedPointsCallback
        public void onGetRedPoints(int seq, int result, String errMs, ArrayList<RedPoint> redPoints) {
            long j3 = 0;
            if (result == 0 && redPoints != null && !redPoints.isEmpty()) {
                j3 = redPoints.get(0).num;
            }
            QLog.d("GroupAlbumMainPageTitlePart", 1, "result:=" + result + ",err:=" + errMs + ",size:= " + (redPoints != null ? Integer.valueOf(redPoints.size()) : null) + ",num:=" + j3);
            m.this.L9(j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L9(long num) {
        QUIBadge qUIBadge = null;
        if (num <= 0) {
            QUIBadge qUIBadge2 = this.redPointText;
            if (qUIBadge2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("redPointText");
            } else {
                qUIBadge = qUIBadge2;
            }
            qUIBadge.setVisibility(8);
            return;
        }
        QUIBadge qUIBadge3 = this.redPointText;
        if (qUIBadge3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("redPointText");
        } else {
            qUIBadge = qUIBadge3;
        }
        qUIBadge.setRedNum((int) num);
        F9(num);
    }
}
