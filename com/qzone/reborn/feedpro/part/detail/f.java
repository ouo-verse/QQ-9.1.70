package com.qzone.reborn.feedpro.part.detail;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.feedpro.event.QzoneFeedProDetailRefreshEvent;
import com.qzone.reborn.feedpro.event.QzoneFeedProRefreshEvent;
import com.qzone.reborn.feedx.util.QZoneFeedxViewUtils;
import com.qzone.reborn.feedx.widget.title.QZoneCommonTitle;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001c\u0010\u000e\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u000f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u0011\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00130\u0012H\u0016R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/qzone/reborn/feedpro/part/detail/f;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Lcom/qzone/reborn/feedx/widget/title/QZoneCommonTitle;", "d", "Lcom/qzone/reborn/feedx/widget/title/QZoneCommonTitle;", "mDetailTitle", "Lcom/qzone/reborn/feedpro/viewmodel/i;", "e", "Lcom/qzone/reborn/feedpro/viewmodel/i;", "mDetailViewModel", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class f extends Part implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QZoneCommonTitle mDetailTitle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.feedpro.viewmodel.i mDetailViewModel;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z9(f this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        re.b bVar = (re.b) this$0.getViewModel(re.b.class);
        if (bVar != null) {
            com.qzone.reborn.feedpro.viewmodel.i iVar = this$0.mDetailViewModel;
            if (iVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDetailViewModel");
                iVar = null;
            }
            UIStateData<CommonFeed> value = iVar.f2().getValue();
            bVar.W1(value != null ? value.getData() : null);
            bVar.X1(true);
            bVar.O1().setValue(Boolean.TRUE);
            QZoneCommonTitle qZoneCommonTitle = this$0.mDetailTitle;
            if (qZoneCommonTitle == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDetailTitle");
                qZoneCommonTitle = null;
            }
            fo.c.b("dt_clck", qZoneCommonTitle, "em_qz_more", null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneFeedProDetailTitlePart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.mz9);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026qzone_feedx_detail_title)");
        QZoneCommonTitle qZoneCommonTitle = (QZoneCommonTitle) findViewById;
        this.mDetailTitle = qZoneCommonTitle;
        QZoneCommonTitle qZoneCommonTitle2 = null;
        if (qZoneCommonTitle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDetailTitle");
            qZoneCommonTitle = null;
        }
        qZoneCommonTitle.getMCenterTitle().setText(com.qzone.util.l.a(R.string.mvm));
        QZoneCommonTitle qZoneCommonTitle3 = this.mDetailTitle;
        if (qZoneCommonTitle3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDetailTitle");
            qZoneCommonTitle3 = null;
        }
        qZoneCommonTitle3.setupTitleHeight(QZoneFeedxViewUtils.b(getActivity()));
        ViewModel viewModel = getViewModel(com.qzone.reborn.feedpro.viewmodel.i.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QzoneFeedPr\u2026ailViewModel::class.java)");
        this.mDetailViewModel = (com.qzone.reborn.feedpro.viewmodel.i) viewModel;
        QZoneCommonTitle qZoneCommonTitle4 = this.mDetailTitle;
        if (qZoneCommonTitle4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDetailTitle");
        } else {
            qZoneCommonTitle2 = qZoneCommonTitle4;
        }
        String a16 = com.qzone.util.l.a(R.string.akv);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.part.detail.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.z9(f.this, view);
            }
        };
        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.detail_button_top_right_more)");
        qZoneCommonTitle2.c(new uh.d(R.drawable.qui_more, null, onClickListener, null, a16, false, 42, null));
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
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
        com.qzone.reborn.feedpro.viewmodel.i iVar;
        if (!(event instanceof QzoneFeedProDetailRefreshEvent ? true : event instanceof QzoneFeedProRefreshEvent) || (iVar = this.mDetailViewModel) == null) {
            return;
        }
        if (iVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDetailViewModel");
            iVar = null;
        }
        iVar.y2();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QzoneFeedProRefreshEvent.class, QzoneFeedProDetailRefreshEvent.class);
        return arrayListOf;
    }
}
