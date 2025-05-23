package com.tencent.mobileqq.qqlive.sail.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.component.appx.utils.AppUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqecommerce.biz.live.api.QQECLiveEntryGoodsData;
import com.tencent.mobileqq.qqlive.api.IQQLiveUtil;
import com.tencent.mobileqq.qqlive.api.av.LiveMediaConfigManager;
import com.tencent.mobileqq.qqlive.base.QQLiveBaseFragment2;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.context.QQLiveContext;
import com.tencent.mobileqq.qqlive.room.frame.activity.QQLiveAnchorActivity;
import com.tencent.mobileqq.qqlive.room.prepare.QQLivePrepareFragment;
import com.tencent.mobileqq.qqlive.room.prepare.rtmp.QQLiveRtmpPrepareFragment;
import com.tencent.mobileqq.qqlive.sail.ui.close.QQLiveAnchorClosePart;
import com.tencent.mobileqq.qqlive.sail.ui.danmu.QQLiveBarrageLayoutPart;
import com.tencent.mobileqq.qqlive.sail.ui.danmu.QQLiveChatMessagePart;
import com.tencent.mobileqq.qqlive.sail.ui.danmu.o;
import com.tencent.mobileqq.qqlive.sail.ui.ecommerce.QQLiveAnchorECPart;
import com.tencent.mobileqq.qqlive.sail.ui.ecommerce.QQLiveAnchorECViewModel;
import com.tencent.mobileqq.qqlive.sail.ui.linkscreen.QQLiveAnchorLinkScreenPart;
import com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveCameraBottomOperatePart;
import com.tencent.mobileqq.qqlive.sail.ui.normalflatingmsg.QQLiveNormalFloatingMsgPart;
import com.tencent.mobileqq.qqlive.sail.ui.paylevel.QQLivePayLevelPart;
import com.tencent.mobileqq.qqlive.sail.ui.pendant.QQLivePendantPart;
import com.tencent.mobileqq.qqlive.sail.ui.prepare.QQLiveCameraPrepareMenuPart;
import com.tencent.mobileqq.qqlive.sail.ui.prepare.QQLivePrepareLabelPart;
import com.tencent.mobileqq.qqlive.sail.ui.prepare.QQLivePrepareSummaryPart;
import com.tencent.mobileqq.qqlive.sail.ui.prepare.QQLivePrepareViewModel;
import com.tencent.mobileqq.qqlive.sail.ui.preview.QQLiveCameraPreviewPart;
import com.tencent.mobileqq.qqlive.sail.ui.rank.QQLiveRankPart;
import com.tencent.mobileqq.qqlive.sail.ui.report.QQLiveRoomReportPart;
import com.tencent.mobileqq.qqlive.sail.ui.room.QQLiveRoomCleanPart;
import com.tencent.mobileqq.qqlive.sail.ui.room.QQLiveRoomCreatePart;
import com.tencent.mobileqq.qqlive.sail.ui.room.QQLiveTrtcRoomPart;
import com.tencent.mobileqq.qqlive.sail.ui.tophead.QQLiveTopHeadPart;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.List;
import kl4.s;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 $2\u00020\u0001:\u0001%B\u0007\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\u0012\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016R#\u0010\u001d\u001a\n \u0018*\u0004\u0018\u00010\u00170\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u0004\u0018\u00010\u001e8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/QQLiveCameraAnchorFragment;", "Lcom/tencent/mobileqq/qqlive/base/QQLiveBaseFragment2;", "Landroid/content/Intent;", "xh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "", "isWrapContent", "onBackEvent", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "intent", "onNewIntent", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/qqlive/sail/ui/prepare/QQLivePrepareViewModel;", "kotlin.jvm.PlatformType", "E", "Lkotlin/Lazy;", OcrConfig.CHINESE, "()Lcom/tencent/mobileqq/qqlive/sail/ui/prepare/QQLivePrepareViewModel;", "prepareViewModel", "Lcom/tencent/mobileqq/qqlive/context/QQLiveContext;", "yh", "()Lcom/tencent/mobileqq/qqlive/context/QQLiveContext;", "liveContext", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveCameraAnchorFragment extends QQLiveBaseFragment2 {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy prepareViewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\n\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/QQLiveCameraAnchorFragment$a;", "", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "traceId", "", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.QQLiveCameraAnchorFragment$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x006a, code lost:
        
            if (r0 != false) goto L22;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void a(@NotNull Context context, @Nullable Intent intent, @NotNull String traceId) {
            Intent intent2;
            boolean isBlank;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, context, intent, traceId);
                return;
            }
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(traceId, "traceId");
            if (!((IQQLiveUtil) QRoute.api(IQQLiveUtil.class)).checkAvEnable(context)) {
                AegisLogger.INSTANCE.d("Open_Live|QQLiveCameraAnchorFragment", "startFragment", "av not enable");
                return;
            }
            boolean z16 = false;
            com.tencent.mobileqq.qqlive.anchor.live.utils.b.b().e(0);
            if (intent == null) {
                intent2 = new Intent();
            } else {
                intent2 = new Intent(intent);
            }
            if (ht3.a.e("QQLIVE_JUMP_ANCHOR_LIVE_ACTIVITY_FOR_CLEAR_TOP", true)) {
                String stringExtra = intent2.getStringExtra("clear_top");
                if (stringExtra != null) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(stringExtra);
                }
                z16 = true;
                if (z16) {
                    intent2.addFlags(67108864);
                }
            } else {
                intent2.addFlags(536870912);
            }
            intent2.putExtra("moduleId", "qq_live");
            intent2.putExtra(QQLiveReportConstants.INTENT_TRACE_ID, traceId);
            intent2.putExtra("key_intent_app_id", QQLiveBusinessConfig.QQLIVE_APP_ID);
            intent2.putExtra(QQWinkConstants.ENTRY_BUSINESS_NAME, "QQLIVE_SKIN");
            QPublicFragmentActivity.b.b(context, intent2, QQLiveAnchorActivity.class, QQLiveCameraAnchorFragment.class);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51388);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveCameraAnchorFragment() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<QQLivePrepareViewModel>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.QQLiveCameraAnchorFragment$prepareViewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveCameraAnchorFragment.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final QQLivePrepareViewModel invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (QQLivePrepareViewModel) QQLiveCameraAnchorFragment.this.getViewModel(QQLivePrepareViewModel.class) : (QQLivePrepareViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.prepareViewModel = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ah(QQLiveCameraAnchorFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bh(QQLiveCameraAnchorFragment this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.zh().W1().setValue(Boolean.valueOf(z16));
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ch(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Dh(QQLiveCameraAnchorFragment this$0, View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        view.setClickable(false);
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.overridePendingTransition(0, 0);
        }
        FragmentActivity activity2 = this$0.getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
        Intent xh5 = this$0.xh();
        FragmentActivity activity3 = this$0.getActivity();
        QQLiveContext yh5 = this$0.yh();
        if (yh5 == null || (str = yh5.n()) == null) {
            str = "";
        }
        QQLivePrepareFragment.Pj(activity3, xh5, str);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eh(QQLiveCameraAnchorFragment this$0, View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        view.setClickable(false);
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.overridePendingTransition(0, 0);
        }
        FragmentActivity activity2 = this$0.getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
        Intent xh5 = this$0.xh();
        QQLiveRtmpPrepareFragment.Companion companion = QQLiveRtmpPrepareFragment.INSTANCE;
        FragmentActivity activity3 = this$0.getActivity();
        QQLiveContext yh5 = this$0.yh();
        if (yh5 == null || (str = yh5.n()) == null) {
            str = "";
        }
        companion.a(activity3, xh5, str);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final Intent xh() {
        QQECLiveEntryGoodsData entryGoodsData;
        String string;
        String string2;
        String string3;
        Intent intent = new Intent();
        intent.putExtra("moduleId", "qq_live");
        intent.putExtra("key_intent_app_id", QQLiveBusinessConfig.QQLIVE_APP_ID);
        Bundle arguments = getArguments();
        if (arguments != null && (string3 = arguments.getString(QQLiveReportConstants.INTENT_TRACE_ID)) != null) {
            intent.putExtra(QQLiveReportConstants.INTENT_TRACE_ID, string3);
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null && (string2 = arguments2.getString("source")) != null) {
            intent.putExtra("source", string2);
        }
        Bundle arguments3 = getArguments();
        if (arguments3 != null) {
            intent.putExtra("source", arguments3.getInt("source"));
        }
        Bundle arguments4 = getArguments();
        if (arguments4 != null && (string = arguments4.getString("clear_top")) != null) {
            intent.putExtra("clear_top", string);
        }
        QQLiveAnchorECViewModel qQLiveAnchorECViewModel = (QQLiveAnchorECViewModel) getViewModel(QQLiveAnchorECViewModel.class);
        if (qQLiveAnchorECViewModel != null && (entryGoodsData = qQLiveAnchorECViewModel.getEntryGoodsData()) != null) {
            intent.putExtra("KEY_LIVE_ENTRY_GOODS_DATA", entryGoodsData);
        }
        return intent;
    }

    private final QQLiveContext yh() {
        return QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.QQLIVE_APP_ID);
    }

    private final QQLivePrepareViewModel zh() {
        return (QQLivePrepareViewModel) this.prepareViewModel.getValue();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new QQLiveRoomReportPart(), new QQLiveAnchorECPart(), new QQLiveRoomCreatePart(null, null, 3, null), new QQLiveTrtcRoomPart(), new QQLiveCameraPreviewPart(), new QQLiveCameraPrepareMenuPart(), new QQLivePrepareSummaryPart(), new QQLivePrepareLabelPart(), new QQLiveTopHeadPart(), new QQLiveRankPart(), new com.tencent.mobileqq.qqlive.sail.ui.netstatus.g(), new QQLiveAnchorClosePart(), new com.tencent.mobileqq.qqlive.sail.ui.music.a(), new com.tencent.mobileqq.qqlive.sail.ui.preview.b(), new QQLiveCameraBottomOperatePart(), new QQLivePendantPart(), new QQLiveChatMessagePart(), new o(), new QQLiveBarrageLayoutPart(), new com.tencent.mobileqq.qqlive.sail.ui.input.c(), new com.tencent.mobileqq.qqlive.sail.ui.gift.g(), new com.tencent.mobileqq.qqlive.sail.ui.alert.b(), new com.tencent.mobileqq.qqlive.sail.ui.busconfig.b(), new QQLivePayLevelPart(), new com.tencent.mobileqq.qqlive.sail.ui.luckybag.b(), new QQLiveAnchorLinkScreenPart(), new com.tencent.mobileqq.qqlive.sail.ui.debug.b(), new QQLiveNormalFloatingMsgPart(), new QQLiveRoomCleanPart());
            return mutableListOf;
        }
        return (List) iPatchRedirector.redirect((short) 6, (Object) this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return getPartManager().onBackEvent();
    }

    @Override // com.tencent.mobileqq.qqlive.base.QQLiveBaseFragment2, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        if (com.tencent.mobileqq.qqlive.sail.c.f272176a.m().c()) {
            QQToast.makeText(getContext(), 1, R.string.f210135ha, 0).show();
            AegisLogger.INSTANCE.i("Open_Live|QQLiveCameraAnchorFragment", "onCreate", "has audience room, please exit first");
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        xl3.a.b(getContext());
        AppUtils.zInitGlobal(getContext());
        LiveMediaConfigManager liveMediaConfigManager = LiveMediaConfigManager.INSTANCE;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        liveMediaConfigManager.initCameraMediaConfig(requireContext);
        mm4.b.d();
        com.tencent.mobileqq.qqlive.sail.b.f272169b.init(getContext());
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            inflate = (View) iPatchRedirector.redirect((short) 3, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            setStatusBarImmersive();
            rh(true);
            inflate = inflater.inflate(R.layout.h9z, container, false);
            inflate.findViewById(R.id.f60732w8).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.sail.ui.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QQLiveCameraAnchorFragment.Ah(QQLiveCameraAnchorFragment.this, view);
                }
            });
            final CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.f60852wj);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.qqlive.sail.ui.d
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                    QQLiveCameraAnchorFragment.Bh(QQLiveCameraAnchorFragment.this, compoundButton, z16);
                }
            });
            MutableLiveData<Boolean> W1 = zh().W1();
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>(checkBox) { // from class: com.tencent.mobileqq.qqlive.sail.ui.QQLiveCameraAnchorFragment$onCreateView$2$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ CheckBox $this_apply;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$this_apply = checkBox;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) checkBox);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean it) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    CheckBox checkBox2 = this.$this_apply;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    checkBox2.setChecked(it.booleanValue());
                }
            };
            W1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.e
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QQLiveCameraAnchorFragment.Ch(Function1.this, obj);
                }
            });
            View findViewById = inflate.findViewById(R.id.f60952wt);
            if (findViewById != null) {
                findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.sail.ui.f
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        QQLiveCameraAnchorFragment.Dh(QQLiveCameraAnchorFragment.this, view);
                    }
                });
            }
            View findViewById2 = inflate.findViewById(R.id.f61392y0);
            if (findViewById2 != null) {
                findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.sail.ui.g
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        QQLiveCameraAnchorFragment.Eh(QQLiveCameraAnchorFragment.this, view);
                    }
                });
            }
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        AegisLogger.INSTANCE.i("Open_Live|QQLiveCameraAnchorFragment", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "invoke success");
        super.onDestroy();
        s.INSTANCE.a();
        com.tencent.mobileqq.qqlive.sail.b bVar = com.tencent.mobileqq.qqlive.sail.b.f272169b;
        bVar.o2();
        bVar.N3();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(@Nullable Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) intent);
            return;
        }
        PartManager partManager = this.mPartManager;
        if (partManager != null) {
            partManager.onNewIntent(intent);
        }
    }
}
