package com.tencent.mobileqq.qqlive.sail.ui.close;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.sail.model.ReportExtKt;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.trpcprotocol.qlive.livechatcheck.RoomAdminPush$PushMsg_KickOutSomebody;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ;2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001<B\u0007\u00a2\u0006\u0004\b9\u0010:J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0018\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016J\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010!\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001b\u0010/\u001a\u00020*8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001b\u00104\u001a\u0002008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u0010,\u001a\u0004\b2\u00103R\u0016\u00108\u001a\u0004\u0018\u0001058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b6\u00107\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/close/QQLiveAudienceClosePart;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/qqlive/sail/room/g;", "", "Da", "Lfp4/c;", "msgInfo", "za", "ua", "wa", "", "showEndPage", "qa", "pa", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onPartResume", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "U9", "V9", "", "action", "", "args", "getMessage", "v", NodeProps.ON_CLICK, "onPush", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "closeView", "f", "Z", "isClickClose", "Lcom/tencent/mobileqq/qqlive/sail/ui/close/CloseViewModel;", tl.h.F, "Lkotlin/Lazy;", "sa", "()Lcom/tencent/mobileqq/qqlive/sail/ui/close/CloseViewModel;", "closeViewModel", "Lcom/tencent/mobileqq/qqlive/sail/ui/clearscreen/a;", "i", "ra", "()Lcom/tencent/mobileqq/qqlive/sail/ui/clearscreen/a;", "clearScreenViewModel", "Lcom/tencent/mobileqq/qqlive/sail/room/e;", "ta", "()Lcom/tencent/mobileqq/qqlive/sail/room/e;", "room", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveAudienceClosePart extends com.tencent.mobileqq.qqlive.sail.base.c implements View.OnClickListener, com.tencent.mobileqq.qqlive.sail.room.g {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView closeView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isClickClose;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy closeViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy clearScreenViewModel;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/close/QQLiveAudienceClosePart$a;", "", "", "MSG_QUERY_HAS_CLICK_CLOSE", "Ljava/lang/String;", "TAG", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.close.QQLiveAudienceClosePart$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51620);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveAudienceClosePart() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<CloseViewModel>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.close.QQLiveAudienceClosePart$closeViewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveAudienceClosePart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final CloseViewModel invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (CloseViewModel) QQLiveAudienceClosePart.this.getViewModel(CloseViewModel.class) : (CloseViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.closeViewModel = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.qqlive.sail.ui.clearscreen.a>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.close.QQLiveAudienceClosePart$clearScreenViewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveAudienceClosePart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final com.tencent.mobileqq.qqlive.sail.ui.clearscreen.a invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (com.tencent.mobileqq.qqlive.sail.ui.clearscreen.a) QQLiveAudienceClosePart.this.getViewModel(com.tencent.mobileqq.qqlive.sail.ui.clearscreen.a.class) : (com.tencent.mobileqq.qqlive.sail.ui.clearscreen.a) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.clearScreenViewModel = lazy2;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Aa(QQLiveAudienceClosePart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.qa(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ba(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ca(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Da() {
        sa().M1(H9(), C9(), E9());
    }

    private final void pa() {
        com.tencent.mobileqq.qqlive.sail.room.f F9 = F9();
        if (F9 != null) {
            F9.e(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void qa(boolean showEndPage) {
        this.isClickClose = true;
        broadcastMessage("onExitRoom", null);
        com.tencent.mobileqq.qqlive.sail.room.e ta5 = ta();
        if (ta5 != null) {
            ReportExtKt.b(ta5, "exit", null, null, null, 14, null);
        }
        if (showEndPage) {
            Da();
            return;
        }
        Activity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final com.tencent.mobileqq.qqlive.sail.ui.clearscreen.a ra() {
        Object value = this.clearScreenViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-clearScreenViewModel>(...)");
        return (com.tencent.mobileqq.qqlive.sail.ui.clearscreen.a) value;
    }

    private final CloseViewModel sa() {
        Object value = this.closeViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-closeViewModel>(...)");
        return (CloseViewModel) value;
    }

    private final com.tencent.mobileqq.qqlive.sail.room.e ta() {
        com.tencent.mobileqq.qqlive.sail.room.f F9 = F9();
        if (F9 instanceof com.tencent.mobileqq.qqlive.sail.room.e) {
            return (com.tencent.mobileqq.qqlive.sail.room.e) F9;
        }
        return null;
    }

    private final void ua(fp4.c msgInfo) {
        if (2 == msgInfo.f400287e && C9() == msgInfo.f400288f) {
            runOnActivityUiThread(new Runnable() { // from class: com.tencent.mobileqq.qqlive.sail.ui.close.k
                @Override // java.lang.Runnable
                public final void run() {
                    QQLiveAudienceClosePart.va(QQLiveAudienceClosePart.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void va(QQLiveAudienceClosePart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.qa(true);
    }

    private final void wa(fp4.c msgInfo) {
        try {
            String stringUtf8 = new RoomAdminPush$PushMsg_KickOutSomebody().mergeFrom(msgInfo.f400285c).f381591msg.get().toStringUtf8();
            AegisLogger.INSTANCE.i("Audience|QQLiveAudienceClosePart", "handleKickOut", "msg=" + stringUtf8);
            com.tencent.mobileqq.qqlive.sail.room.e ta5 = ta();
            if (ta5 != null) {
                ta5.stop();
            }
            DialogUtil.createCustomDialog(getContext(), 230, (String) null, stringUtf8, getContext().getString(R.string.zgi), (String) null, (DialogInterface.OnClickListener) null, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.sail.ui.close.j
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    QQLiveAudienceClosePart.xa(QQLiveAudienceClosePart.this, dialogInterface, i3);
                }
            }).show();
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e("Audience|QQLiveAudienceClosePart", "handleKickOut", "error, ", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xa(QQLiveAudienceClosePart this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.qa(false);
    }

    private final void za(fp4.c msgInfo) {
        Unit unit;
        qt3.a v3 = com.tencent.mobileqq.qqlive.sail.push.a.v(msgInfo);
        if (v3 != null) {
            if (v3.f429496d == 0 && C9() == v3.f429493a) {
                runOnActivityUiThread(new Runnable() { // from class: com.tencent.mobileqq.qqlive.sail.ui.close.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        QQLiveAudienceClosePart.Aa(QQLiveAudienceClosePart.this);
                    }
                });
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            ua(msgInfo);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void U9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        com.tencent.mobileqq.qqlive.sail.room.f F9 = F9();
        if (F9 != null) {
            F9.p(75, this);
            F9.p(254, this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void V9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            pa();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    @Nullable
    public Object getMessage(@Nullable String action, @Nullable Object args) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return iPatchRedirector.redirect((short) 8, (Object) this, (Object) action, args);
        }
        if (Intrinsics.areEqual(action, "MSG_QUERY_HAS_CLICK_CLOSE")) {
            return Boolean.valueOf(this.isClickClose);
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) v3);
        } else {
            qa(false);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) configuration);
            return;
        }
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                ImageView imageView = this.closeView;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    return;
                }
                return;
            }
            ImageView imageView2 = this.closeView;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        ImageView imageView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        if (rootView != null) {
            imageView = (ImageView) rootView.findViewById(R.id.f60022ua);
        } else {
            imageView = null;
        }
        this.closeView = imageView;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.l8w);
        }
        ImageView imageView2 = this.closeView;
        if (imageView2 != null) {
            imageView2.setOnClickListener(this);
        }
        MutableLiveData<Boolean> N1 = sa().N1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.close.QQLiveAudienceClosePart$onInitView$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveAudienceClosePart.this);
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
                QQLiveAudienceClosePart qQLiveAudienceClosePart = QQLiveAudienceClosePart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qQLiveAudienceClosePart.qa(it.booleanValue());
            }
        };
        N1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.close.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveAudienceClosePart.Ba(Function1.this, obj);
            }
        });
        LiveData<Boolean> L1 = ra().L1();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.close.QQLiveAudienceClosePart$onInitView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveAudienceClosePart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                ImageView imageView3;
                ImageView imageView4;
                ImageView imageView5;
                ImageView imageView6;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (it.booleanValue()) {
                    imageView5 = QQLiveAudienceClosePart.this.closeView;
                    if (imageView5 != null) {
                        imageView5.setImageResource(R.drawable.o6d);
                    }
                    imageView6 = QQLiveAudienceClosePart.this.closeView;
                    if (imageView6 != null) {
                        imageView6.setBackgroundResource(R.drawable.lq8);
                        return;
                    }
                    return;
                }
                imageView3 = QQLiveAudienceClosePart.this.closeView;
                if (imageView3 != null) {
                    imageView3.setBackground(null);
                }
                imageView4 = QQLiveAudienceClosePart.this.closeView;
                if (imageView4 != null) {
                    imageView4.setImageResource(R.drawable.l8w);
                }
            }
        };
        L1.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.close.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveAudienceClosePart.Ca(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
        } else {
            super.onPartDestroy(activity);
            pa();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
        } else {
            super.onPartResume(activity);
            this.isClickClose = false;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.g
    public void onPush(@NotNull fp4.c msgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) msgInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
        int i3 = msgInfo.f400284b;
        if (i3 != 75) {
            if (i3 == 254) {
                wa(msgInfo);
                return;
            }
            return;
        }
        za(msgInfo);
    }
}
