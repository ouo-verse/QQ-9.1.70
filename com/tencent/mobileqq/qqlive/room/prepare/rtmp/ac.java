package com.tencent.mobileqq.qqlive.room.prepare.rtmp;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqecommerce.biz.live.api.QQECLiveEntryGoodsData;
import com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareWrapper;
import com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.context.QQLiveContext;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPrepare;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomAttr;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataSet;
import com.tencent.mobileqq.qqlive.room.anchorcenter.QQLiveAnchorCenterFragment;
import com.tencent.mobileqq.qqlive.room.prepare.QQLivePrepareFragment;
import com.tencent.mobileqq.qqlive.room.prepare.event.DelMessageCenterRedPointEvent;
import com.tencent.mobileqq.qqlive.sail.ui.QQLiveCameraAnchorFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.api.ITimiGameApi;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 >2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0002?@B\u000f\u0012\u0006\u0010,\u001a\u00020)\u00a2\u0006\u0004\b<\u0010=J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0002J\u0019\u0010\u0015\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0012\u0010\u001a\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010\u001d\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010 \u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010\"\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010$\u001a\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010\u0004H\u0016J$\u0010(\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040&0%j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040&`'H\u0016R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010/\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00101\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010.R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010;\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010.\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/prepare/rtmp/ac;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "E9", "N9", "M9", "J9", "K9", "Landroid/app/Activity;", "it", "Landroid/content/Intent;", "D9", "I9", "", "H9", "G9", "", "redPointTaskId", "C9", "(Ljava/lang/Long;)V", "", "getLogTag", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "v", NodeProps.ON_CLICK, "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/mobileqq/qqlive/room/prepare/rtmp/ac$b;", "d", "Lcom/tencent/mobileqq/qqlive/room/prepare/rtmp/ac$b;", "prepareWrapperProvider", "e", "Landroid/view/View;", "gameLayout", "f", "videoLayout", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "anchorCenterIcon", "Lcom/tencent/mobileqq/qqlive/room/prepare/k;", "i", "Lcom/tencent/mobileqq/qqlive/room/prepare/k;", "viewModel", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "redPointView", "<init>", "(Lcom/tencent/mobileqq/qqlive/room/prepare/rtmp/ac$b;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "b", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class ac extends Part implements View.OnClickListener, SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b prepareWrapperProvider;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View gameLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View videoLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView anchorCenterIcon;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqlive.room.prepare.k viewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View redPointView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/prepare/rtmp/ac$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.room.prepare.rtmp.ac$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/prepare/rtmp/ac$b;", "", "Lcom/tencent/mobileqq/qqlive/api/anchor/prepare/IQQLiveAnchorPrepareWrapper;", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public interface b {
        @Nullable
        IQQLiveAnchorPrepareWrapper a();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqlive/room/prepare/rtmp/ac$c", "Lcom/tencent/mobileqq/qqlive/callback/anchor/QQLiveAnchorRoomThirdPushBaseCallback;", "Lcom/tencent/mobileqq/qqlive/data/anchor/sso/QQLiveAnchorDataSet;", "setResult", "", "onSet", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c extends QQLiveAnchorRoomThirdPushBaseCallback {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ac.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomSet
        public void onSet(@NotNull QQLiveAnchorDataSet setResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) setResult);
                return;
            }
            Intrinsics.checkNotNullParameter(setResult, "setResult");
            super.onSet(setResult);
            ac.this.K9();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqlive/room/prepare/rtmp/ac$d", "Lcom/tencent/mobileqq/qqlive/callback/anchor/QQLiveAnchorRoomThirdPushBaseCallback;", "Lcom/tencent/mobileqq/qqlive/data/anchor/sso/QQLiveAnchorDataSet;", "setResult", "", "onSet", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class d extends QQLiveAnchorRoomThirdPushBaseCallback {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ac.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomSet
        public void onSet(@NotNull QQLiveAnchorDataSet setResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) setResult);
                return;
            }
            Intrinsics.checkNotNullParameter(setResult, "setResult");
            super.onSet(setResult);
            ac.this.J9();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50274);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ac(@NotNull b prepareWrapperProvider) {
        Intrinsics.checkNotNullParameter(prepareWrapperProvider, "prepareWrapperProvider");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) prepareWrapperProvider);
        } else {
            this.prepareWrapperProvider = prepareWrapperProvider;
        }
    }

    private final void C9(Long redPointTaskId) {
        ImageView imageView = this.anchorCenterIcon;
        if (imageView != null) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            if (redPointTaskId != null) {
                long longValue = redPointTaskId.longValue();
                if (longValue != 0) {
                    concurrentHashMap.put("qqlive_taskid", String.valueOf(longValue));
                }
            }
            ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().a(imageView, false, null, "em_qqlive_anchorcenter", new ConcurrentHashMap());
            ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().reportEvent("imp", imageView, new ConcurrentHashMap());
        }
    }

    private final Intent D9(Activity it) {
        int i3;
        QQECLiveEntryGoodsData qQECLiveEntryGoodsData;
        String stringExtra;
        Intent intent = new Intent();
        com.tencent.mobileqq.qqlive.room.prepare.k kVar = this.viewModel;
        if (kVar != null) {
            i3 = kVar.b2();
        } else {
            i3 = 0;
        }
        intent.putExtra("source", i3);
        Intent intent2 = it.getIntent();
        if (intent2 != null && (stringExtra = intent2.getStringExtra("clear_top")) != null) {
            intent.putExtra("clear_top", stringExtra);
        }
        com.tencent.mobileqq.qqlive.room.prepare.k kVar2 = this.viewModel;
        if (kVar2 != null && (qQECLiveEntryGoodsData = kVar2.S) != null) {
            intent.putExtra("KEY_LIVE_ENTRY_GOODS_DATA", qQECLiveEntryGoodsData);
        }
        return intent;
    }

    private final void E9() {
        MutableLiveData<Boolean> mutableLiveData;
        AegisLogger.INSTANCE.d("Open_Live|QQLiveRtmpPrepareFragment", "getRedPoint", "getRedPoint...");
        com.tencent.mobileqq.qqlive.room.prepare.k kVar = this.viewModel;
        if (kVar != null && (mutableLiveData = kVar.L) != null) {
            mutableLiveData.observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.qqlive.room.prepare.rtmp.ab
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ac.F9(ac.this, (Boolean) obj);
                }
            });
        }
        com.tencent.mobileqq.qqlive.room.prepare.k kVar2 = this.viewModel;
        if (kVar2 != null) {
            kVar2.Z1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(ac this$0, Boolean bool) {
        Long l3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        com.tencent.mobileqq.qqlive.room.prepare.k kVar = this$0.viewModel;
        Long l16 = null;
        if (kVar != null) {
            l3 = Long.valueOf(kVar.M);
        } else {
            l3 = null;
        }
        companion.i("Open_Live|QQLiveRtmpPrepareFragment", "getRedPoint", "show:" + bool + " taskId:" + l3);
        if (bool != null && bool.booleanValue()) {
            View view = this$0.redPointView;
            if (view != null) {
                view.setVisibility(0);
            }
        } else {
            View view2 = this$0.redPointView;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
        com.tencent.mobileqq.qqlive.room.prepare.k kVar2 = this$0.viewModel;
        if (kVar2 != null) {
            l16 = Long.valueOf(kVar2.M);
        }
        this$0.C9(l16);
    }

    private final void G9() {
        View view;
        if (!H9() && (view = this.videoLayout) != null) {
            view.setVisibility(8);
        }
    }

    private final boolean H9() {
        if (Build.VERSION.SDK_INT >= 28) {
            return true;
        }
        return false;
    }

    private final void I9() {
        Long l3;
        Boolean bool;
        long j3;
        MutableLiveData<Boolean> mutableLiveData;
        QQLiveAnchorRoomInfo roomInfo;
        QQLiveAnchorDataRoomAttr qQLiveAnchorDataRoomAttr;
        Activity activity = getActivity();
        if (activity != null) {
            IQQLiveAnchorPrepareWrapper a16 = this.prepareWrapperProvider.a();
            String str = null;
            if (a16 != null && (roomInfo = a16.getRoomInfo()) != null && (qQLiveAnchorDataRoomAttr = roomInfo.roomAttr) != null) {
                l3 = Long.valueOf(qQLiveAnchorDataRoomAttr.roomId);
            } else {
                l3 = null;
            }
            String valueOf = String.valueOf(l3);
            Intent intent = new Intent();
            com.tencent.mobileqq.qqlive.room.prepare.k kVar = this.viewModel;
            if (kVar == null || (mutableLiveData = kVar.L) == null || (bool = mutableLiveData.getValue()) == null) {
                bool = Boolean.FALSE;
            }
            Intrinsics.checkNotNullExpressionValue(bool, "viewModel?.redPointData?.value ?: false");
            intent.putExtra("param_message_red_point", bool.booleanValue());
            com.tencent.mobileqq.qqlive.room.prepare.k kVar2 = this.viewModel;
            if (kVar2 != null) {
                j3 = kVar2.M;
            } else {
                j3 = 0;
            }
            intent.putExtra("param_red_point_taskid", j3);
            QQLiveAnchorCenterFragment.Companion companion = QQLiveAnchorCenterFragment.INSTANCE;
            com.tencent.mobileqq.qqlive.room.prepare.k kVar3 = this.viewModel;
            if (kVar3 != null) {
                str = kVar3.c2();
            }
            companion.a(activity, intent, str, valueOf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J9() {
        String str;
        Activity activity = getActivity();
        if (activity != null) {
            View view = this.videoLayout;
            if (view != null) {
                view.setClickable(false);
            }
            activity.overridePendingTransition(0, 0);
            activity.finish();
            Intent D9 = D9(activity);
            QQLiveCameraAnchorFragment.Companion companion = QQLiveCameraAnchorFragment.INSTANCE;
            QQLiveContext c16 = QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.QQLIVE_APP_ID);
            if (c16 == null || (str = c16.n()) == null) {
                str = "";
            }
            companion.a(activity, D9, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K9() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.room.prepare.rtmp.aa
            @Override // java.lang.Runnable
            public final void run() {
                ac.L9(ac.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(ac this$0) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.getActivity();
        if (activity != null) {
            View view = this$0.gameLayout;
            if (view != null) {
                view.setClickable(false);
            }
            activity.overridePendingTransition(0, 0);
            activity.finish();
            Intent D9 = this$0.D9(activity);
            QQLiveContext c16 = QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.QQLIVE_APP_ID);
            if (c16 == null || (str = c16.n()) == null) {
                str = "";
            }
            QQLivePrepareFragment.Pj(activity, D9, str);
        }
    }

    private final void M9() {
        byte[] bArr;
        com.tencent.mobileqq.qqlive.room.prepare.k kVar = this.viewModel;
        if (kVar != null) {
            QQLiveAnchorDataPrepare X1 = kVar.X1(2, kVar.Q.getValue());
            Intrinsics.checkNotNullExpressionValue(X1, "it.getPrepareLiveDataFor\u2026astSelectLabelData.value)");
            IQQLiveAnchorPrepareWrapper a16 = this.prepareWrapperProvider.a();
            if (a16 != null) {
                QQLiveAnchorDataRoomAttr qQLiveAnchorDataRoomAttr = X1.roomAttr;
                IQQLiveAnchorPrepareWrapper a17 = this.prepareWrapperProvider.a();
                if (a17 != null) {
                    bArr = a17.getAuthExt(IQQLiveAnchorPrepareWrapper.QQLIVE_BIZID);
                } else {
                    bArr = null;
                }
                a16.set(qQLiveAnchorDataRoomAttr, bArr, new c());
            }
        }
    }

    private final void N9() {
        byte[] bArr;
        com.tencent.mobileqq.qqlive.room.prepare.k kVar = this.viewModel;
        if (kVar != null) {
            QQLiveAnchorDataPrepare X1 = kVar.X1(2, kVar.Q.getValue());
            Intrinsics.checkNotNullExpressionValue(X1, "it.getPrepareLiveDataFor\u2026astSelectLabelData.value)");
            IQQLiveAnchorPrepareWrapper a16 = this.prepareWrapperProvider.a();
            if (a16 != null) {
                QQLiveAnchorDataRoomAttr qQLiveAnchorDataRoomAttr = X1.roomAttr;
                IQQLiveAnchorPrepareWrapper a17 = this.prepareWrapperProvider.a();
                if (a17 != null) {
                    bArr = a17.getAuthExt(IQQLiveAnchorPrepareWrapper.QQLIVE_BIZID);
                } else {
                    bArr = null;
                }
                a16.set(qQLiveAnchorDataRoomAttr, bArr, new d());
            }
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(DelMessageCenterRedPointEvent.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 8, (Object) this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "Open_Live|QCircleMediaPickerTipsPart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) v3);
        } else {
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.f61402y1) {
                N9();
            } else if (num != null && num.intValue() == R.id.f61382xz) {
                M9();
            } else if (num != null && num.intValue() == R.id.f61322xt) {
                I9();
            } else if (num != null && num.intValue() == R.id.f61342xv) {
                getActivity().finish();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        View view;
        View view2;
        ImageView imageView;
        ImageView imageView2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        View view3 = null;
        if (rootView != null) {
            view = rootView.findViewById(R.id.f61382xz);
        } else {
            view = null;
        }
        this.gameLayout = view;
        if (rootView != null) {
            view2 = rootView.findViewById(R.id.f61402y1);
        } else {
            view2 = null;
        }
        this.videoLayout = view2;
        if (rootView != null) {
            imageView = (ImageView) rootView.findViewById(R.id.f61322xt);
        } else {
            imageView = null;
        }
        this.anchorCenterIcon = imageView;
        if (rootView != null && (imageView2 = (ImageView) rootView.findViewById(R.id.f61342xv)) != null) {
            imageView2.setOnClickListener(this);
        }
        if (rootView != null) {
            view3 = rootView.findViewById(R.id.f61332xu);
        }
        this.redPointView = view3;
        View view4 = this.gameLayout;
        if (view4 != null) {
            view4.setOnClickListener(this);
        }
        View view5 = this.videoLayout;
        if (view5 != null) {
            view5.setOnClickListener(this);
        }
        ImageView imageView3 = this.anchorCenterIcon;
        if (imageView3 != null) {
            imageView3.setOnClickListener(this);
        }
        this.viewModel = (com.tencent.mobileqq.qqlive.room.prepare.k) new ViewModelProvider(getHostFragment(), com.tencent.mobileqq.qqlive.room.prepare.k.U).get(com.tencent.mobileqq.qqlive.room.prepare.k.class);
        G9();
        E9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity, (Object) savedInstanceState);
        } else {
            super.onPartCreate(activity, savedInstanceState);
            SimpleEventBus.getInstance().registerReceiver(this);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
        } else {
            super.onPartDestroy(activity);
            SimpleEventBus.getInstance().unRegisterReceiver(this);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        MutableLiveData<Boolean> mutableLiveData;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) event);
            return;
        }
        if (event instanceof DelMessageCenterRedPointEvent) {
            AegisLogger.INSTANCE.i("Open_Live|QCircleMediaPickerTipsPart", "onReceiveEvent", "DelMessageCenterRedPointEvent");
            com.tencent.mobileqq.qqlive.room.prepare.k kVar = this.viewModel;
            if (kVar != null && (mutableLiveData = kVar.L) != null) {
                mutableLiveData.postValue(Boolean.FALSE);
            }
        }
    }
}
