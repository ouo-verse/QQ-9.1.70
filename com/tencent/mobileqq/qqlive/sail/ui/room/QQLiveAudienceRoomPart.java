package com.tencent.mobileqq.qqlive.sail.ui.room;

import android.app.Activity;
import android.os.Bundle;
import android.util.Size;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.publish.business.protocol.QZonePublishMoodRequest;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.sail.model.AudienceRoomInfo;
import com.tencent.mobileqq.qqlive.sail.model.ReportExtKt;
import com.tencent.mobileqq.qqlive.sail.ui.close.CloseViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.common.api.AegisLogger;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import mqq.app.Constants;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 E2\u00020\u00012\u00020\u0002:\u0002FGB\u000f\u0012\u0006\u0010 \u001a\u00020\u0019\u00a2\u0006\u0004\bC\u0010DJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u001a\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u001c\u0010\u0013\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0016\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0017\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\u0018\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0016J\u000e\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003R\u0014\u0010 \u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001b\u0010&\u001a\u00020!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001b\u0010*\u001a\u00020'8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010#\u001a\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u0004\u0018\u00010?8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b@\u0010A\u00a8\u0006H"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/room/QQLiveAudienceRoomPart;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "Lmi2/h;", "Lcom/tencent/mobileqq/qqlive/sail/ui/room/r;", "switchRoomInfo", "", "ta", "sa", "va", "", "errCode", "", "errMsg", "ua", "wa", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onPartDestroy", "T9", "", "w", tl.h.F, "onVideoSizeChanged", "xa", "e", "I", "position", "Lcom/tencent/mobileqq/qqlive/sail/ui/room/RoomViewModel;", "f", "Lkotlin/Lazy;", "ra", "()Lcom/tencent/mobileqq/qqlive/sail/ui/room/RoomViewModel;", "roomViewModel", "Lcom/tencent/mobileqq/qqlive/sail/ui/close/CloseViewModel;", "pa", "()Lcom/tencent/mobileqq/qqlive/sail/ui/close/CloseViewModel;", "closeViewModel", "Landroid/widget/FrameLayout;", "i", "Landroid/widget/FrameLayout;", "playerContainerView", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "reEnterRoomWhenNetChange", "Landroid/util/Size;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/util/Size;", QZonePublishMoodRequest.EXT_INFO_KEY_VIDEO_SIZE, "Lkotlinx/coroutines/Job;", "D", "Lkotlinx/coroutines/Job;", "enterRoomJob", "Lcom/tencent/mobileqq/qqlive/sail/ui/room/QQLiveAudienceRoomPart$b;", "E", "Lcom/tencent/mobileqq/qqlive/sail/ui/room/QQLiveAudienceRoomPart$b;", "netEventHandler", "Lcom/tencent/mobileqq/qqlive/sail/room/e;", "qa", "()Lcom/tencent/mobileqq/qqlive/sail/room/e;", "room", "<init>", "(I)V", UserInfo.SEX_FEMALE, "a", "b", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveAudienceRoomPart extends com.tencent.mobileqq.qqlive.sail.base.c implements mi2.h {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final long G;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private Size videoSize;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Job enterRoomJob;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private b netEventHandler;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int position;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy roomViewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy closeViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout playerContainerView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean reEnterRoomWhenNetChange;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/room/QQLiveAudienceRoomPart$a;", "", "", "START_ROOM_DELAY", "J", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.room.QQLiveAudienceRoomPart$a, reason: from kotlin metadata */
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

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/room/QQLiveAudienceRoomPart$b;", "Lcom/tencent/mobileqq/msf/sdk/handler/INetEventHandler;", "", "isNetEffective", "", "onNetChangeEvent", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/qqlive/sail/ui/room/QQLiveAudienceRoomPart;", "d", "Lmqq/util/WeakReference;", "partRef", "part", "<init>", "(Lcom/tencent/mobileqq/qqlive/sail/ui/room/QQLiveAudienceRoomPart;)V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements INetEventHandler {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<QQLiveAudienceRoomPart> partRef;

        public b(@NotNull QQLiveAudienceRoomPart part) {
            Intrinsics.checkNotNullParameter(part, "part");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) part);
            } else {
                this.partRef = new WeakReference<>(part);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetEventHandler
        public void onNetChangeEvent(boolean isNetEffective) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, isNetEffective);
                return;
            }
            QQLiveAudienceRoomPart qQLiveAudienceRoomPart = this.partRef.get();
            if (qQLiveAudienceRoomPart == null) {
                return;
            }
            com.tencent.mobileqq.qqlive.sail.model.g b26 = qQLiveAudienceRoomPart.ra().b2();
            if (b26 != null) {
                z16 = b26.a();
            } else {
                z16 = false;
            }
            AegisLogger.INSTANCE.i("Audience|QQLiveAudienceRoomPart", "onNetChangeEvent", "roomId=" + qQLiveAudienceRoomPart.H9() + ", selected=" + z16 + ", net=" + isNetEffective + ", reEnter=" + qQLiveAudienceRoomPart.reEnterRoomWhenNetChange);
            if (isNetEffective && z16 && !qQLiveAudienceRoomPart.R9() && qQLiveAudienceRoomPart.reEnterRoomWhenNetChange) {
                qQLiveAudienceRoomPart.sa();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53011);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
            G = ht3.a.c("qqlive_audience_enter_room_delay", 400L);
        }
    }

    public QQLiveAudienceRoomPart(int i3) {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
            return;
        }
        this.position = i3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RoomViewModel>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.room.QQLiveAudienceRoomPart$roomViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveAudienceRoomPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RoomViewModel invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (RoomViewModel) QQLiveAudienceRoomPart.this.getViewModel(RoomViewModel.class) : (RoomViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.roomViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<CloseViewModel>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.room.QQLiveAudienceRoomPart$closeViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveAudienceRoomPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CloseViewModel invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (CloseViewModel) QQLiveAudienceRoomPart.this.getViewModel(CloseViewModel.class) : (CloseViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.closeViewModel = lazy2;
        this.videoSize = new Size(0, 0);
    }

    private final CloseViewModel pa() {
        Object value = this.closeViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-closeViewModel>(...)");
        return (CloseViewModel) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.qqlive.sail.room.e qa() {
        com.tencent.mobileqq.qqlive.sail.room.f F9 = F9();
        if (F9 instanceof com.tencent.mobileqq.qqlive.sail.room.e) {
            return (com.tencent.mobileqq.qqlive.sail.room.e) F9;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RoomViewModel ra() {
        Object value = this.roomViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-roomViewModel>(...)");
        return (RoomViewModel) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sa() {
        Job launch$default;
        this.reEnterRoomWhenNetChange = false;
        Job job = this.enterRoomJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        launch$default = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), null, null, new QQLiveAudienceRoomPart$launchEnterRoomJob$1(this, null), 3, null);
        this.enterRoomJob = launch$default;
    }

    private final void ta(r switchRoomInfo) {
        if (qa() == null) {
            AegisLogger.INSTANCE.w("Audience|QQLiveAudienceRoomPart", "onRoomSelected", "no room");
            return;
        }
        AegisLogger.INSTANCE.i("Audience|QQLiveAudienceRoomPart", "onRoomSelected", "roomId=" + H9() + ", switchInfo=" + switchRoomInfo);
        com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
        cVar.m().L(H9());
        cVar.m().a(qa());
        ra().i2(new com.tencent.mobileqq.qqlive.sail.model.g(true, switchRoomInfo));
        com.tencent.mobileqq.qqlive.sail.room.e qa5 = qa();
        if (qa5 != null) {
            ReportExtKt.f(qa5);
        }
        broadcastMessage("onPageIn", null);
        sa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ua(long errCode, String errMsg) {
        String str;
        boolean isBlank;
        AegisLogger.INSTANCE.e("Audience|QQLiveAudienceRoomPart", "onRoomStartFailed", "roomId=" + H9() + ", errCode=" + errCode + ", errMsg=" + errMsg);
        if (errCode == -10000003) {
            return;
        }
        if (errCode == 1004) {
            String string = getContext().getString(R.string.f210955ji);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026live_room_admin_kick_out)");
            gt3.a.b(gt3.a.INSTANCE.a(), string, 0, null, 6, null);
            wa(null);
            com.tencent.mobileqq.qqlive.sail.room.e qa5 = qa();
            if (qa5 != null) {
                qa5.stopVideo();
            }
            FrameLayout frameLayout = this.playerContainerView;
            if (frameLayout != null) {
                frameLayout.removeAllViews();
                return;
            }
            return;
        }
        if (errCode == -12201) {
            String string2 = getContext().getString(R.string.zvp);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(com.te\u2026error_code_teenager_mode)");
            if (errMsg != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(errMsg);
                if (!(true ^ isBlank)) {
                    errMsg = string2;
                }
                str = errMsg;
            } else {
                str = string2;
            }
            gt3.a.b(gt3.a.INSTANCE.a(), str, 0, null, 6, null);
            pa().N1().postValue(Boolean.FALSE);
            return;
        }
        String string3 = getContext().getString(R.string.f210525ic);
        Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri\u2026e_enter_trtc_room_failed)");
        gt3.a.b(gt3.a.INSTANCE.a(), string3, 0, null, 6, null);
        this.reEnterRoomWhenNetChange = true;
        if (this.netEventHandler == null) {
            this.netEventHandler = new b(this);
        }
        AppNetConnInfo.registerNetChangeReceiver(BaseApplication.context, this.netEventHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void va() {
        boolean z16;
        AudienceRoomInfo b16;
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        if (companion.isDevelopLevel()) {
            companion.d("Audience|QQLiveAudienceRoomPart", "onRoomStartSuccess", "roomId=" + H9());
        }
        broadcastMessage("onEnterRoom", null);
        com.tencent.mobileqq.qqlive.sail.room.e qa5 = qa();
        if (qa5 != null && (b16 = qa5.b()) != null) {
            z16 = b16.z();
        } else {
            z16 = true;
        }
        if (z16) {
            companion.w("Audience|QQLiveAudienceRoomPart", "onRoomStartSuccess", "room video is closed");
            pa().N1().postValue(Boolean.TRUE);
        }
    }

    private final void wa(r switchRoomInfo) {
        long j3;
        com.tencent.mobileqq.qqlive.sail.room.e qa5;
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        if (companion.isDevelopLevel()) {
            companion.d("Audience|QQLiveAudienceRoomPart", "onRoomUnselected", "roomId=" + H9());
        }
        this.reEnterRoomWhenNetChange = false;
        Job job = this.enterRoomJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        com.tencent.mobileqq.qqlive.sail.room.e qa6 = qa();
        if (qa6 != null) {
            qa6.stop();
        }
        b bVar = this.netEventHandler;
        if (bVar != null) {
            AppNetConnInfo.unregisterNetEventHandler(bVar);
        }
        if (switchRoomInfo != null) {
            ra().i2(new com.tencent.mobileqq.qqlive.sail.model.g(false, switchRoomInfo));
        }
        if (switchRoomInfo != null) {
            j3 = switchRoomInfo.c();
        } else {
            j3 = 0;
        }
        broadcastMessage("onExitRoom", Long.valueOf(j3));
        if (R9() && (qa5 = qa()) != null) {
            ReportExtKt.b(qa5, "exit", null, null, null, 14, null);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void T9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.T9();
        com.tencent.mobileqq.qqlive.sail.room.e qa5 = qa();
        if (qa5 != null) {
            qa5.registerVideoSizeChangedListener(this);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        FrameLayout frameLayout;
        Size videoSize;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        com.tencent.mobileqq.qqlive.sail.room.e qa5 = qa();
        if (qa5 != null && (videoSize = qa5.getVideoSize()) != null) {
            onVideoSizeChanged(videoSize.getWidth(), videoSize.getHeight());
        }
        if (rootView != null) {
            frameLayout = (FrameLayout) rootView.findViewById(R.id.f61692yt);
        } else {
            frameLayout = null;
        }
        this.playerContainerView = frameLayout;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        com.tencent.mobileqq.qqlive.sail.room.e qa5 = qa();
        if (qa5 != null) {
            qa5.registerVideoSizeChangedListener(this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        Job job = this.enterRoomJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.enterRoomJob = null;
        com.tencent.mobileqq.qqlive.sail.room.e qa5 = qa();
        if (qa5 != null) {
            qa5.m(this);
        }
        b bVar = this.netEventHandler;
        if (bVar != null) {
            AppNetConnInfo.unregisterNetEventHandler(bVar);
            this.netEventHandler = null;
        }
    }

    @Override // mi2.h
    public void onVideoSizeChanged(int w3, int h16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(w3), Integer.valueOf(h16));
            return;
        }
        this.videoSize = new Size(w3, h16);
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        if (companion.isColorLevel()) {
            companion.d("Audience|QQLiveAudienceRoomPart", "onVideoSizeChanged", "size=" + this.videoSize);
        }
        ra().d2().postValue(this.videoSize);
    }

    public final void xa(@NotNull r switchRoomInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) switchRoomInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(switchRoomInfo, "switchRoomInfo");
        if (switchRoomInfo.c() == H9()) {
            ta(switchRoomInfo);
        } else {
            wa(switchRoomInfo);
        }
    }
}
