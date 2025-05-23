package com.tencent.mobileqq.wink.editor.aielimination;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import b93.OutputData;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.editor.aielimination.model.AIEliminationScene;
import com.tencent.mobileqq.wink.event.WinkZoneWriteTaskEvent;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qzonehub.api.IQZoneApiProxy;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 @2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001AB\u0007\u00a2\u0006\u0004\b>\u0010?J\b\u0010\u0006\u001a\u00020\u0005H\u0002J2\u0010\u000e\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u001c\u0010\u0016\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0017\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0019\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u001b\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001d0\u001cH\u0016R$\u0010&\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010.\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u00102\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010)\u001a\u0004\b0\u0010+\"\u0004\b1\u0010-R$\u00106\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010)\u001a\u0004\b4\u0010+\"\u0004\b5\u0010-R#\u0010=\u001a\n 8*\u0004\u0018\u000107078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/aielimination/WinkEliminationUploadPart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "C9", "Landroid/view/View;", "view", "", "elementId", "", "", QQBrowserActivity.APP_PARAM, "x9", "Landroid/os/Bundle;", "B9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "v", NodeProps.ON_CLICK, "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Landroidx/constraintlayout/widget/ConstraintLayout;", "d", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getUploadLayout", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setUploadLayout", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "uploadLayout", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "e", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "getUploadButton", "()Lcom/tencent/biz/qui/quibutton/QUIButton;", "setUploadButton", "(Lcom/tencent/biz/qui/quibutton/QUIButton;)V", "uploadButton", "f", "getPublishButton", "setPublishButton", "publishButton", tl.h.F, "getNextButton", "setNextButton", "nextButton", "Lcom/tencent/mobileqq/wink/editor/aielimination/WinkAiEliminationViewModel;", "kotlin.jvm.PlatformType", "i", "Lkotlin/Lazy;", "A9", "()Lcom/tencent/mobileqq/wink/editor/aielimination/WinkAiEliminationViewModel;", "aiEliminationViewModel", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEliminationUploadPart extends Part implements View.OnClickListener, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ConstraintLayout uploadLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUIButton uploadButton;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUIButton publishButton;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUIButton nextButton;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy aiEliminationViewModel;

    public WinkEliminationUploadPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<WinkAiEliminationViewModel>() { // from class: com.tencent.mobileqq.wink.editor.aielimination.WinkEliminationUploadPart$aiEliminationViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WinkAiEliminationViewModel invoke() {
                return (WinkAiEliminationViewModel) WinkEliminationUploadPart.this.getViewModel(WinkAiEliminationViewModel.class);
            }
        });
        this.aiEliminationViewModel = lazy;
    }

    private final WinkAiEliminationViewModel A9() {
        return (WinkAiEliminationViewModel) this.aiEliminationViewModel.getValue();
    }

    private final Bundle B9() {
        ArrayList<String> arrayListOf;
        int i3;
        Bundle bundle = new Bundle();
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(A9().p2());
        bundle.putStringArrayList("images", arrayListOf);
        bundle.putString(QZoneShareManager.QZONE_SHARE_THIRD_PARTY_APPID, QQWinkConstants.QZONE_SHARE_VALUE_ELIMINATE_EVENT);
        bundle.putString(QZoneShareManager.QZONE_SHARE_THIRD_PARTY_URL, QQWinkConstants.QZONE_SHARE_VALUE_ELIMINATE_SCHEMA);
        bundle.putInt(QZoneHelper.Constants.KEY_PUBLISH_COME_FROM, 4);
        Integer prePageSource = A9().getPrePageSource();
        if (prePageSource != null) {
            i3 = prePageSource.intValue();
        } else {
            i3 = -1;
        }
        bundle.putInt(QZoneHelper.Constants.KEY_PUBLISH_SUB_COME_FROM, i3);
        return bundle;
    }

    private final void C9() {
        w53.b.a("WinkEliminationUploadPart", "initNextStepButton: " + getActivity().getIntent().getExtras());
        if (Intrinsics.areEqual("1", getActivity().getIntent().getStringExtra("isOpenedPublisher"))) {
            QUIButton qUIButton = this.uploadButton;
            if (qUIButton != null) {
                qUIButton.setVisibility(8);
            }
            QUIButton qUIButton2 = this.publishButton;
            if (qUIButton2 != null) {
                qUIButton2.setVisibility(8);
            }
            QUIButton qUIButton3 = (QUIButton) getPartRootView().findViewById(R.id.zqt);
            this.nextButton = qUIButton3;
            if (qUIButton3 != null) {
                qUIButton3.setVisibility(0);
            }
            QUIButton qUIButton4 = this.nextButton;
            if (qUIButton4 != null) {
                qUIButton4.setOnClickListener(this);
            }
            z9(this, this.nextButton, WinkDaTongReportConstant.ElementId.EM_XSJ_NEXT_BUTTON, null, 4, null);
        }
    }

    private final void x9(View view, String elementId, Map<String, ? extends Object> extraParams) {
        if (view == null) {
            return;
        }
        VideoReport.setElementId(view, elementId);
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        if (extraParams != null) {
            buildElementParams.putAll(extraParams);
        }
        VideoReport.setElementParams(view, buildElementParams);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void z9(WinkEliminationUploadPart winkEliminationUploadPart, View view, String str, Map map, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = null;
        }
        winkEliminationUploadPart.x9(view, str, map);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(WinkZoneWriteTaskEvent.class);
        return arrayListOf;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        int i3;
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            num = Integer.valueOf(v3.getId());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == R.id.f114646tw) {
            ArrayList<LocalMediaInfo> arrayList = new ArrayList<>();
            arrayList.add(A9().w2());
            IQZoneApiProxy iQZoneApiProxy = (IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class);
            Activity activity = getActivity();
            Bundle bundle = new Bundle();
            Integer prePageSource = A9().getPrePageSource();
            if (prePageSource != null) {
                i3 = prePageSource.intValue();
            } else {
                i3 = -1;
            }
            bundle.putInt(QZoneHelper.Constants.KEY_PUBLISH_SUB_COME_FROM, i3);
            Unit unit = Unit.INSTANCE;
            iQZoneApiProxy.launchQZoneUploadPhotoPage(activity, arrayList, "", 4, bundle, 0);
        } else if (num != null && num.intValue() == R.id.f85244of) {
            QZoneShareManager.publishToQzone(com.tencent.mobileqq.wink.b.e(), getActivity(), B9(), null);
        } else if (num != null && num.intValue() == R.id.zqt) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(A9().w2());
            Bundle B9 = B9();
            Bundle extras = getActivity().getIntent().getExtras();
            if (extras != null) {
                B9.putAll(extras);
            }
            B9.putString(WinkDaTongReportConstant.ElementParamKey.XSJ_ELIMINATE_CHANGED, "1");
            Intent intent = new Intent();
            intent.putExtras(B9);
            w53.b.a("WinkEliminationUploadPart", "dataIntent: " + intent.getExtras());
            WinkContext.INSTANCE.d().m().k(getActivity(), OutputData.INSTANCE.a(1L, arrayList2, intent));
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.uploadLayout = (ConstraintLayout) rootView.findViewById(R.id.ury);
        if (A9().getMScene() != AIEliminationScene.QZONE_HOME_PAGE) {
            ConstraintLayout constraintLayout = this.uploadLayout;
            if (constraintLayout != null) {
                constraintLayout.setVisibility(8);
                return;
            }
            return;
        }
        this.uploadButton = (QUIButton) rootView.findViewById(R.id.f114646tw);
        this.publishButton = (QUIButton) rootView.findViewById(R.id.f85244of);
        QUIButton qUIButton = this.uploadButton;
        if (qUIButton != null) {
            qUIButton.setOnClickListener(this);
        }
        QUIButton qUIButton2 = this.publishButton;
        if (qUIButton2 != null) {
            qUIButton2.setOnClickListener(this);
        }
        z9(this, this.uploadButton, WinkDaTongReportConstant.ElementId.EM_XSJ_UPLOAD, null, 4, null);
        z9(this, this.publishButton, WinkDaTongReportConstant.ElementId.EM_XSJ_PUBLISH, null, 4, null);
        C9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        w53.b.a("WinkEliminationUploadPart", "onPartCreate");
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        w53.b.a("WinkEliminationUploadPart", "onPartDestroy");
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof WinkZoneWriteTaskEvent) {
            WinkZoneWriteTaskEvent winkZoneWriteTaskEvent = (WinkZoneWriteTaskEvent) event;
            w53.b.a("WinkEliminationUploadPart", "onReceiveEvent: " + winkZoneWriteTaskEvent.getTaskID());
            int taskID = winkZoneWriteTaskEvent.getTaskID();
            if (taskID != 2) {
                if (taskID == 11) {
                    QQToast.makeText(getContext(), 2, R.string.f240797q5, 0).show();
                    return;
                }
                return;
            }
            QQToast.makeText(getContext(), 2, R.string.f240667ps, 0).show();
        }
    }
}
