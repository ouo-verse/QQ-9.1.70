package com.tencent.mobileqq.qqlive.sail.ui.floatwindow;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Size;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.publish.business.protocol.QZonePublishMoodRequest;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qqlive.api.IQQLivePortalServer;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.context.QQLiveContext;
import com.tencent.mobileqq.qqlive.sail.model.audience.WindowMode;
import com.tencent.mobileqq.qqlive.sail.report.QQLiveDaTongParams;
import com.tencent.mobileqq.qqlive.sail.room.e;
import com.tencent.mobileqq.qqlive.sail.room.f;
import com.tencent.mobileqq.qqlive.sail.ui.room.RoomViewModel;
import com.tencent.mobileqq.qqlive.sail.util.RoomHeartBeatReporter;
import com.tencent.mobileqq.qqlive.widget.floatwindow.QQLiveFloatWindowView2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.liveroom.impl.room.view.config.BusConfigHelper;
import com.tencent.timi.game.utils.g;
import com.tencent.timi.game.utils.o;
import com.tenpay.ErrorCode;
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
import tl.h;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 P2\u00020\u00012\u00020\u0002:\u0001QB\u0017\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010-\u001a\u00020*\u00a2\u0006\u0004\bN\u0010OJ\b\u0010\u0004\u001a\u00020\u0003H\u0002JR\u0010\f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007j\u0004\u0018\u0001`\b2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007j\u0004\u0018\u0001`\b2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007j\u0004\u0018\u0001`\bH\u0002J4\u0010\r\u001a\u00020\u00032\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007j\u0004\u0018\u0001`\b2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007j\u0004\u0018\u0001`\bH\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0002J\b\u0010\u0013\u001a\u00020\u0003H\u0002J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\u0012\u0010\u0017\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u001a\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001b\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001c\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001d\u001a\u00020\u0005H\u0016J\u0012\u0010\u001f\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\"\u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010$\u001a\u00020#H\u0016R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010(R\u0016\u0010:\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u001b\u0010D\u001a\u00020?8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR$\u0010G\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007j\u0004\u0018\u0001`\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010I\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u00109R\u0016\u0010M\u001a\u0004\u0018\u00010J8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bK\u0010L\u00a8\u0006R"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/floatwindow/QQLiveFloatWindowPart;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "Landroid/view/View$OnClickListener;", "", "qa", "", "needRequestPermission", "Lkotlin/Function0;", "Lcom/tencent/mobileqq/qqlive/sail/ui/floatwindow/Block;", "pendingBlock", "blockWhenCancel", "blockWhenShow", "pa", "wa", "Aa", "Landroid/content/Intent;", "oa", "ta", "ua", "na", "isPartEnable", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartPause", "onPartStop", "onBackEvent", "v", NodeProps.ON_CLICK, "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "Lcom/tencent/mobileqq/qqlive/sail/ui/busconfig/a;", "updater", "S9", "", "e", "I", "position", "Lqr4/b;", "f", "Lqr4/b;", "feed", "Landroid/widget/ImageView;", h.F, "Landroid/widget/ImageView;", "floatWindowBtn", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "moreLiveTextView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "closeBy", BdhLogUtil.LogTag.Tag_Conn, "Z", MiniChatConstants.MINI_APP_LANDSCAPE, "Landroid/util/Size;", "D", "Landroid/util/Size;", QZonePublishMoodRequest.EXT_INFO_KEY_VIDEO_SIZE, "Lcom/tencent/mobileqq/qqlive/sail/ui/room/RoomViewModel;", "E", "Lkotlin/Lazy;", "sa", "()Lcom/tencent/mobileqq/qqlive/sail/ui/room/RoomViewModel;", "roomViewModel", UserInfo.SEX_FEMALE, "Lkotlin/jvm/functions/Function0;", "pendingRequestPermissionBlock", "G", "showMoreLive", "Lcom/tencent/mobileqq/qqlive/sail/room/e;", "ra", "()Lcom/tencent/mobileqq/qqlive/sail/room/e;", "room", "<init>", "(ILqr4/b;)V", "H", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveFloatWindowPart extends com.tencent.mobileqq.qqlive.sail.base.c implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isLandscape;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private Size videoSize;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy roomViewModel;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private Function0<Unit> pendingRequestPermissionBlock;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean showMoreLive;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int position;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final qr4.b feed;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView floatWindowBtn;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView moreLiveTextView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int closeBy;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/floatwindow/QQLiveFloatWindowPart$a;", "", "", "CLOSE_BY_BACK_EVENT", "I", "CLOSE_BY_CLICK_FLOAT_BTN", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.floatwindow.QQLiveFloatWindowPart$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51851);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveFloatWindowPart(int i3, @NotNull qr4.b feed) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(feed, "feed");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) feed);
            return;
        }
        this.position = i3;
        this.feed = feed;
        this.closeBy = -1;
        this.videoSize = new Size(0, 0);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RoomViewModel>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.floatwindow.QQLiveFloatWindowPart$roomViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveFloatWindowPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RoomViewModel invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (RoomViewModel) QQLiveFloatWindowPart.this.getViewModel(RoomViewModel.class) : (RoomViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.roomViewModel = lazy;
        this.showMoreLive = true;
    }

    private final void Aa() {
        e eVar;
        String str;
        f F9 = F9();
        Unit unit = null;
        if (F9 instanceof e) {
            eVar = (e) F9;
        } else {
            eVar = null;
        }
        if (eVar != null) {
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            companion.i("Audience|QQLiveFloatWindowPart", "showFloatWindow", "roomId=" + H9() + ", videoSize=" + this.videoSize + ", roomId=" + H9());
            com.tencent.mobileqq.qqlive.sail.model.audience.a T1 = sa().T1();
            if (T1 != null) {
                str = T1.e();
            } else {
                str = null;
            }
            if (new QQLiveFloatWindowView2(null, 1, null).t(new com.tencent.mobileqq.qqlive.widget.floatwindow.b(eVar, this.videoSize, oa(), ta(), new RoomHeartBeatReporter(), str, sa().S1()))) {
                companion.i("Audience|QQLiveFloatWindowPart", "showFloatWindow", "success");
                e ra5 = ra();
                if (ra5 != null) {
                    ra5.d(WindowMode.FLOAT);
                }
                sa().g2(false);
            } else {
                gt3.a.b(gt3.a.INSTANCE.a(), "\u6d6e\u7a97\u663e\u793a\u5931\u8d25", 0, null, 6, null);
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            AegisLogger.INSTANCE.e("Audience|QQLiveFloatWindowPart", "showFloatWindow", "no room exists");
        }
    }

    private final void na() {
        String str;
        QQLiveDaTongParams qQLiveDaTongParams = new QQLiveDaTongParams();
        if (this.isLandscape) {
            str = "1";
        } else {
            str = "0";
        }
        qQLiveDaTongParams.B(str);
        ImageView imageView = this.floatWindowBtn;
        if (imageView != null) {
            com.tencent.mobileqq.qqlive.sail.report.a.d(com.tencent.mobileqq.qqlive.sail.report.a.f272382a, imageView, false, null, "em_qqlive_room_window", qQLiveDaTongParams.a(), 6, null);
        }
        TextView textView = this.moreLiveTextView;
        if (textView != null) {
            com.tencent.mobileqq.qqlive.sail.report.a.d(com.tencent.mobileqq.qqlive.sail.report.a.f272382a, textView, false, null, "em_qqlive_morelives", qQLiveDaTongParams.a(), 6, null);
        }
    }

    private final Intent oa() {
        Activity hostActivity;
        Intent intent;
        IPartHost partHost = getPartHost();
        if (partHost != null && (hostActivity = partHost.getHostActivity()) != null && (intent = hostActivity.getIntent()) != null) {
            Intent intent2 = new Intent(intent);
            intent2.putExtra("key_launch_feed_bytes", com.tencent.mobileqq.qqlive.sail.model.c.d(this.feed));
            return intent2;
        }
        AegisLogger.INSTANCE.e("Audience|QQLiveFloatWindowPart", "buildIntent", "no activity intent");
        return new Intent();
    }

    private final void pa(boolean needRequestPermission, Function0<Unit> pendingBlock, Function0<Unit> blockWhenCancel, Function0<Unit> blockWhenShow) {
        if (o.c("Audience|QQLiveFloatWindowPart-doFloatWindow")) {
            QLog.i("Audience|QQLiveFloatWindowPart", 1, "float window btn double click");
            return;
        }
        if (g.c(getContext())) {
            if (blockWhenShow != null) {
                blockWhenShow.invoke();
            }
        } else if (needRequestPermission) {
            AegisLogger.INSTANCE.w("Audience|QQLiveFloatWindowPart", "doFloatWindow", "no permission");
            wa(pendingBlock, blockWhenCancel);
        }
    }

    private final void qa() {
        if (o.c("Audience|QQLiveFloatWindowPart-doMoreLive")) {
            QLog.i("Audience|QQLiveFloatWindowPart", 1, "float window btn double click");
        } else {
            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.floatwindow.QQLiveFloatWindowPart$doMoreLive$block$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveFloatWindowPart.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        ((IQQLivePortalServer) QRoute.api(IQQLivePortalServer.class)).goToPortal(QQLiveFloatWindowPart.this.getActivity(), 22, 0);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            };
            pa(true, function0, function0, function0);
        }
    }

    private final e ra() {
        f F9 = F9();
        if (F9 instanceof e) {
            return (e) F9;
        }
        return null;
    }

    private final RoomViewModel sa() {
        Object value = this.roomViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-roomViewModel>(...)");
        return (RoomViewModel) value;
    }

    private final boolean ta() {
        String str;
        QQLiveContext c16 = QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.QQLIVE_APP_ID);
        if (c16 != null) {
            str = c16.j();
        } else {
            str = null;
        }
        AegisLogger.INSTANCE.i("Audience|QQLiveFloatWindowPart", "isFloatMute", "from=" + str);
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != 1598) {
                if (hashCode != 1700) {
                    switch (hashCode) {
                        case 1573:
                            if (str.equals("16")) {
                                return true;
                            }
                            return false;
                        case 1574:
                            if (str.equals("17")) {
                                return true;
                            }
                            return false;
                        case 1575:
                            if (str.equals("18")) {
                                return true;
                            }
                            return false;
                        default:
                            return false;
                    }
                }
                if (str.equals(ErrorCode.ERR_NET)) {
                    return true;
                }
                return false;
            }
            if (str.equals("20")) {
                return true;
            }
            return false;
        }
        return false;
    }

    private final boolean ua() {
        String str;
        if (this.closeBy == 2) {
            AegisLogger.INSTANCE.i("Audience|QQLiveFloatWindowPart", "needShowFloatWindowOnBack", "true, close by click float btn");
            return true;
        }
        QQLiveContext c16 = QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.QQLIVE_APP_ID);
        if (c16 != null) {
            str = c16.j();
        } else {
            str = null;
        }
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        companion.i("Audience|QQLiveFloatWindowPart", "needShowFloatWindowOnBack", "from=" + str);
        if (this.closeBy == 1 && ((Intrinsics.areEqual(str, "17") || Intrinsics.areEqual(str, ErrorCode.ERR_NET)) && this.position == 0)) {
            companion.i("Audience|QQLiveFloatWindowPart", "needShowFloatWindowOnBack", "false");
            return false;
        }
        if (ta() && !g.c(getContext())) {
            companion.i("Audience|QQLiveFloatWindowPart", "needShowFloatWindowOnBack", "false, no permission");
            return false;
        }
        if (!Intrinsics.areEqual(broadcastGetMessage("MSG_QUERY_HAS_CLICK_CLOSE", null), Boolean.TRUE)) {
            return true;
        }
        companion.i("Audience|QQLiveFloatWindowPart", "needShowFloatWindowOnBack", "false, is query has click close");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void va(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void wa(final Function0<Unit> pendingBlock, final Function0<Unit> blockWhenCancel) {
        g.h(getContext(), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.sail.ui.floatwindow.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                QQLiveFloatWindowPart.xa(QQLiveFloatWindowPart.this, pendingBlock, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.sail.ui.floatwindow.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                QQLiveFloatWindowPart.za(Function0.this, this, dialogInterface, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xa(QQLiveFloatWindowPart this$0, Function0 function0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).requestPermission(this$0.getContext());
        this$0.pendingRequestPermissionBlock = function0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void za(Function0 function0, QQLiveFloatWindowPart this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialogInterface.dismiss();
        if (function0 != null) {
            function0.invoke();
        }
        this$0.pendingRequestPermissionBlock = null;
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void S9(@NotNull com.tencent.mobileqq.qqlive.sail.ui.busconfig.a updater) {
        TextView textView;
        Resources resources;
        Configuration configuration;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) updater);
            return;
        }
        Intrinsics.checkNotNullParameter(updater, "updater");
        boolean z16 = true;
        boolean z17 = !BusConfigHelper.f378723a.f(17, H9());
        this.showMoreLive = z17;
        if (!z17) {
            TextView textView2 = this.moreLiveTextView;
            if (textView2 != null) {
                textView2.setVisibility(8);
                return;
            }
            return;
        }
        Context context = getContext();
        if (context == null || (resources = context.getResources()) == null || (configuration = resources.getConfiguration()) == null || configuration.orientation != 1) {
            z16 = false;
        }
        if (z16 && (textView = this.moreLiveTextView) != null) {
            textView.setVisibility(0);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return ht3.a.e("float_window_feature_enable", true);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        this.closeBy = 1;
        if (ua() && !g.c(getContext())) {
            wa(new Function0<Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.floatwindow.QQLiveFloatWindowPart$onBackEvent$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveFloatWindowPart.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    Activity activity = QQLiveFloatWindowPart.this.getActivity();
                    if (activity != null) {
                        activity.finish();
                    }
                }
            }, new Function0<Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.floatwindow.QQLiveFloatWindowPart$onBackEvent$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveFloatWindowPart.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    Activity activity = QQLiveFloatWindowPart.this.getActivity();
                    if (activity != null) {
                        activity.finish();
                    }
                }
            });
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) v3);
        } else {
            boolean z17 = true;
            if (v3 != null && v3.getId() == R.id.f60652w0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                this.closeBy = 2;
                pa(true, new Function0<Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.floatwindow.QQLiveFloatWindowPart$onClick$1
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveFloatWindowPart.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        Activity activity = QQLiveFloatWindowPart.this.getActivity();
                        if (activity != null) {
                            activity.finish();
                        }
                    }
                }, QQLiveFloatWindowPart$onClick$2.INSTANCE, new Function0<Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.floatwindow.QQLiveFloatWindowPart$onClick$3
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveFloatWindowPart.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        Activity activity = QQLiveFloatWindowPart.this.getActivity();
                        if (activity != null) {
                            activity.finish();
                        }
                    }
                });
            } else {
                if (v3 == null || v3.getId() != R.id.f61092x7) {
                    z17 = false;
                }
                if (z17) {
                    qa();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        TextView textView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) configuration);
            return;
        }
        if (configuration != null) {
            int i3 = configuration.orientation;
            if (i3 == 2) {
                this.isLandscape = true;
                ImageView imageView = this.floatWindowBtn;
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
                TextView textView2 = this.moreLiveTextView;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    return;
                }
                return;
            }
            if (i3 == 1) {
                this.isLandscape = false;
                ImageView imageView2 = this.floatWindowBtn;
                if (imageView2 != null) {
                    imageView2.setVisibility(0);
                }
                if (this.showMoreLive && (textView = this.moreLiveTextView) != null) {
                    textView.setVisibility(0);
                }
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        ImageView imageView;
        TextView textView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        if (rootView != null) {
            imageView = (ImageView) rootView.findViewById(R.id.f60652w0);
        } else {
            imageView = null;
        }
        this.floatWindowBtn = imageView;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        ImageView imageView2 = this.floatWindowBtn;
        if (imageView2 != null) {
            imageView2.setImageResource(R.drawable.nst);
        }
        ImageView imageView3 = this.floatWindowBtn;
        if (imageView3 != null) {
            imageView3.setOnClickListener(this);
        }
        if (rootView != null) {
            textView = (TextView) rootView.findViewById(R.id.f61092x7);
        } else {
            textView = null;
        }
        this.moreLiveTextView = textView;
        if (textView != null) {
            textView.setVisibility(0);
        }
        TextView textView2 = this.moreLiveTextView;
        if (textView2 != null) {
            textView2.setOnClickListener(this);
        }
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.oq7);
        if (drawable != null) {
            drawable.setBounds(0, 0, ViewUtils.dpToPx(12.0f), ViewUtils.dpToPx(12.0f));
        }
        TextView textView3 = this.moreLiveTextView;
        if (textView3 != null) {
            textView3.setCompoundDrawables(null, null, drawable, null);
        }
        MutableLiveData<Size> d26 = ((RoomViewModel) getViewModel(RoomViewModel.class)).d2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Size, Unit> function1 = new Function1<Size, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.floatwindow.QQLiveFloatWindowPart$onInitView$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveFloatWindowPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Size size) {
                invoke2(size);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Size it) {
                Size size;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                QQLiveFloatWindowPart qQLiveFloatWindowPart = QQLiveFloatWindowPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qQLiveFloatWindowPart.videoSize = it;
                AegisLogger.Companion companion = AegisLogger.INSTANCE;
                size = QQLiveFloatWindowPart.this.videoSize;
                companion.i("Audience|QQLiveFloatWindowPart", "onInitView", "videoSize=" + size + ", roomId=" + QQLiveFloatWindowPart.this.H9());
            }
        };
        d26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.floatwindow.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveFloatWindowPart.va(Function1.this, obj);
            }
        });
        na();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        e ra5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
            return;
        }
        super.onPartPause(activity);
        if (R9() && sa().S1()) {
            boolean z16 = false;
            if (activity != null && activity.isFinishing()) {
                z16 = true;
            }
            if (z16 && (ra5 = ra()) != null) {
                ra5.stopVideo();
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        e ra5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
            return;
        }
        super.onPartResume(activity);
        if (!R9()) {
            AegisLogger.INSTANCE.i("Audience|QQLiveFloatWindowPart", "onPartResume", "roomId=" + H9() + ", no enter room");
            return;
        }
        if (this.pendingRequestPermissionBlock != null && g.c(getContext())) {
            Function0<Unit> function0 = this.pendingRequestPermissionBlock;
            if (function0 != null) {
                function0.invoke();
            }
        } else {
            e D9 = D9();
            if (D9 != null && D9.b().getRoomId() != H9()) {
                AegisLogger.INSTANCE.i("Audience|QQLiveFloatWindowPart", "onPartResume", "destroy float window room");
                D9.destroy();
            }
        }
        e ra6 = ra();
        if (ra6 != null) {
            ra6.d(WindowMode.NORMAL);
        }
        this.pendingRequestPermissionBlock = null;
        O9();
        e ra7 = ra();
        boolean z16 = false;
        if (ra7 != null && !ra7.isPlaying()) {
            z16 = true;
        }
        if (z16 && (ra5 = ra()) != null) {
            ra5.resume();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
            return;
        }
        super.onPartStop(activity);
        if (R9() && ua() && g.c(getContext())) {
            AegisLogger.INSTANCE.i("Audience|QQLiveFloatWindowPart", "onPartStop", "showFloatWindow");
            Aa();
        }
    }
}
