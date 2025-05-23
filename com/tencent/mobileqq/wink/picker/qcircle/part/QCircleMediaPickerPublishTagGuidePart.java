package com.tencent.mobileqq.wink.picker.qcircle.part;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.wink.event.UpdateMediaPickerBannerTagEvent;
import com.tencent.mobileqq.wink.model.QQWinkPublishTagGuide;
import com.tencent.mobileqq.wink.model.QQWinkPublishTagGuideManager;
import com.tencent.mobileqq.wink.model.TagType;
import com.tencent.mobileqq.wink.picker.core.ktx.ViewExKt;
import com.tencent.mobileqq.wink.picker.qcircle.QCircleMediaPickerFragment;
import com.tencent.mobileqq.wink.tag.TagRetriever;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u0000 ,2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001-B\u0007\u00a2\u0006\u0004\b*\u0010+J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\bH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0004H\u0016J\u0012\u0010\u0017\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0019\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010\u001d\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001b0\u001aj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001b`\u001cH\u0016R\u001b\u0010#\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/part/QCircleMediaPickerPublishTagGuidePart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Landroid/view/View;", ParseCommon.CONTAINER, "Lcom/tencent/mobileqq/wink/model/QQWinkPublishTagGuide;", "guide", "", "I9", "F9", "N9", "M9", "E9", "", "L9", "view", "publishTagGuide", "C9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "", "d", "Lkotlin/Lazy;", "D9", "()I", "dayInMs", "e", "Z", "needClearFeedback", "f", "Landroid/view/View;", "tagGuidePartLayout", "<init>", "()V", tl.h.F, "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class QCircleMediaPickerPublishTagGuidePart extends Part implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy dayInMs;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean needClearFeedback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View tagGuidePartLayout;

    public QCircleMediaPickerPublishTagGuidePart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.QCircleMediaPickerPublishTagGuidePart$dayInMs$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return 86400000;
            }
        });
        this.dayInMs = lazy;
    }

    private final void C9(View view, QQWinkPublishTagGuide publishTagGuide) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("xsj_topic_name", publishTagGuide.getTagName());
        com.tencent.mobileqq.wink.picker.report.a.b(view, WinkDaTongReportConstant.ElementId.EM_XSJ_TOPIC_GUID, linkedHashMap, null, false, 24, null);
    }

    private final int D9() {
        return ((Number) this.dayInMs.getValue()).intValue();
    }

    private final void E9() {
        QQWinkPublishTagGuideManager qQWinkPublishTagGuideManager = QQWinkPublishTagGuideManager.f323986a;
        Pair<String, Integer> g16 = qQWinkPublishTagGuideManager.g();
        String str = qQWinkPublishTagGuideManager.c().format(new Date()) + "-" + (g16.getSecond().intValue() + 1);
        w53.b.f("QQWinkPublishTagGuideManager", "newRecord=" + str);
        uq3.k.a().p("mmkv_key_publish_tag_guide_neg_feedback", str);
    }

    private final void F9(final View container, final QQWinkPublishTagGuide guide) {
        View findViewById = container.findViewById(R.id.f31560rd);
        findViewById.setVisibility(0);
        ((TextView) findViewById.findViewById(R.id.f920756w)).setText("#" + guide.getTagName());
        ((TextView) findViewById.findViewById(R.id.f920256r)).setText(guide.getTagDesc());
        RoundCornerImageView roundCornerImageView = (RoundCornerImageView) findViewById.findViewById(R.id.f920456t);
        roundCornerImageView.setCorner(ViewExKt.d(4));
        QQPicLoader qQPicLoader = QQPicLoader.f201806a;
        Option obtain = Option.obtain();
        obtain.setTargetView(roundCornerImageView);
        obtain.setUrl(guide.getIcon());
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain().apply {\n       \u2026 guide.icon\n            }");
        qQPicLoader.e(obtain, null);
        QUIButton qUIButton = (QUIButton) findViewById.findViewById(R.id.f114726u4);
        qUIButton.setText(guide.getButtonText());
        qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QCircleMediaPickerPublishTagGuidePart.H9(QCircleMediaPickerPublishTagGuidePart.this, container, guide, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(qUIButton, "this");
        C9(qUIButton, guide);
        findViewById.findViewById(R.id.f164822az1).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QCircleMediaPickerPublishTagGuidePart.G9(QCircleMediaPickerPublishTagGuidePart.this, container, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(QCircleMediaPickerPublishTagGuidePart this$0, View container, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(container, "$container");
        this$0.M9(container);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(QCircleMediaPickerPublishTagGuidePart this$0, View container, QQWinkPublishTagGuide guide, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(container, "$container");
        Intrinsics.checkNotNullParameter(guide, "$guide");
        this$0.N9(container, guide);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void I9(final View container, final QQWinkPublishTagGuide guide) {
        View findViewById = container.findViewById(R.id.f31570re);
        findViewById.setVisibility(0);
        ((TextView) findViewById.findViewById(R.id.f920956y)).setText(guide.getGuideTitle());
        ((TextView) findViewById.findViewById(R.id.f920756w)).setText("#" + guide.getTagName());
        QUIButton qUIButton = (QUIButton) findViewById.findViewById(R.id.f114726u4);
        qUIButton.setText(guide.getButtonText());
        qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QCircleMediaPickerPublishTagGuidePart.J9(QCircleMediaPickerPublishTagGuidePart.this, container, guide, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(qUIButton, "this");
        C9(qUIButton, guide);
        findViewById.findViewById(R.id.f164822az1).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QCircleMediaPickerPublishTagGuidePart.K9(QCircleMediaPickerPublishTagGuidePart.this, container, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(QCircleMediaPickerPublishTagGuidePart this$0, View container, QQWinkPublishTagGuide guide, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(container, "$container");
        Intrinsics.checkNotNullParameter(guide, "$guide");
        this$0.N9(container, guide);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(QCircleMediaPickerPublishTagGuidePart this$0, View container, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(container, "$container");
        this$0.M9(container);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean L9() {
        Object m476constructorimpl;
        long j3;
        QQWinkPublishTagGuideManager qQWinkPublishTagGuideManager = QQWinkPublishTagGuideManager.f323986a;
        Pair<String, Integer> g16 = qQWinkPublishTagGuideManager.g();
        int intValue = g16.getSecond().intValue();
        if (intValue >= qQWinkPublishTagGuideManager.e()) {
            return false;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            Date parse = qQWinkPublishTagGuideManager.c().parse(g16.getFirst());
            if (parse != null) {
                j3 = parse.getTime();
            } else {
                j3 = 0;
            }
            m476constructorimpl = Result.m476constructorimpl(Long.valueOf(j3));
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (Result.m479exceptionOrNullimpl(m476constructorimpl) != null) {
            m476constructorimpl = 0L;
        }
        long longValue = ((Number) m476constructorimpl).longValue();
        long time = new Date().getTime();
        long D9 = (time - longValue) / D9();
        w53.b.f("QQWinkPublishTagGuideManager", "recordTimeMs=" + longValue + ", todayMs=" + time + ", daysBetween=" + D9);
        if (intValue >= QQWinkPublishTagGuideManager.f323986a.d()) {
            if (D9 < 7) {
                return false;
            }
            return true;
        }
        if (intValue >= 1 && D9 < 1) {
            return false;
        }
        return true;
    }

    private final void M9(View container) {
        this.needClearFeedback = false;
        container.setVisibility(8);
        E9();
    }

    private final void N9(View container, QQWinkPublishTagGuide guide) {
        container.setVisibility(8);
        QCircleMediaPickerFragment a16 = f93.a.a(this);
        if (a16 != null) {
            Intent intent = getActivity().getIntent();
            if (guide.getTagType() == TagType.TypeChallenge) {
                com.tencent.mobileqq.wink.tag.a aVar = com.tencent.mobileqq.wink.tag.a.f326414a;
                Intrinsics.checkNotNullExpressionValue(intent, "intent");
                aVar.a(intent, guide.getTagName(), WinkDaTongReportConstant.ElementParamValue.XSJ_TOPIC_FROM_TOPIC_REC);
            } else {
                com.tencent.mobileqq.wink.tag.a aVar2 = com.tencent.mobileqq.wink.tag.a.f326414a;
                Intrinsics.checkNotNullExpressionValue(intent, "intent");
                aVar2.b(intent, guide.getTagName(), WinkDaTongReportConstant.ElementParamValue.XSJ_TOPIC_FROM_TOPIC_REC);
            }
            com.tencent.mobileqq.wink.picker.qcircle.viewmodel.c.i2(com.tencent.mobileqq.wink.picker.qcircle.c.f324971a.b(a16), intent, null, 2, null);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(UpdateMediaPickerBannerTagEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intent intent;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        Activity activity = getActivity();
        if (activity != null) {
            intent = activity.getIntent();
        } else {
            intent = null;
        }
        if (intent == null) {
            return;
        }
        TagRetriever tagRetriever = TagRetriever.f326413a;
        boolean z16 = true;
        if (!tagRetriever.e(intent).isEmpty()) {
            w53.b.f("QQWinkPublishTagGuideManager", "already has tag: " + tagRetriever.f(intent));
            return;
        }
        QQWinkPublishTagGuide qQWinkPublishTagGuide = (QQWinkPublishTagGuide) intent.getParcelableExtra("wink_data_key_publish_tag_guide");
        if (qQWinkPublishTagGuide == null) {
            return;
        }
        if (!L9()) {
            w53.b.f("QQWinkPublishTagGuideManager", "disable");
            return;
        }
        this.needClearFeedback = true;
        View inflate = ((ViewStub) rootView.findViewById(R.id.f920356s)).inflate();
        if (qQWinkPublishTagGuide.getTagDesc().length() != 0) {
            z16 = false;
        }
        if (z16) {
            Intrinsics.checkNotNullExpressionValue(inflate, "this");
            I9(inflate, qQWinkPublishTagGuide);
        } else {
            Intrinsics.checkNotNullExpressionValue(inflate, "this");
            F9(inflate, qQWinkPublishTagGuide);
        }
        this.tagGuidePartLayout = inflate;
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        if (this.needClearFeedback) {
            QQWinkPublishTagGuideManager.f323986a.b();
        }
        if (this.tagGuidePartLayout != null) {
            SimpleEventBus.getInstance().unRegisterReceiver(this);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        boolean z16;
        if (event instanceof UpdateMediaPickerBannerTagEvent) {
            UpdateMediaPickerBannerTagEvent updateMediaPickerBannerTagEvent = (UpdateMediaPickerBannerTagEvent) event;
            if (updateMediaPickerBannerTagEvent.getTopic().length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                w53.b.f("QQWinkPublishTagGuideManager", "UpdateMediaPickerBannerTagEvent, hide myself, tagName=" + updateMediaPickerBannerTagEvent.getTopic());
                View view = this.tagGuidePartLayout;
                if (view != null) {
                    view.setVisibility(8);
                }
            }
        }
    }
}
