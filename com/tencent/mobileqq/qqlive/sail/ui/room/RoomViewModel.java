package com.tencent.mobileqq.qqlive.sail.ui.room;

import android.util.Size;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.avbiz.Constants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.av.LiveMediaConfig;
import com.tencent.mobileqq.qqlive.api.av.LiveMediaConfigManager;
import com.tencent.mobileqq.qqlive.api.av.ResolutionLevelType;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.context.QQLiveContext;
import com.tencent.mobileqq.qqlive.sail.SailAudienceRoomManager;
import com.tencent.mobileqq.qqlive.sail.model.AudienceRoomInfo;
import com.tencent.mobileqq.qqlive.sail.model.audience.StreamDefinition;
import com.tencent.mobileqq.qqlive.sail.model.audience.StreamFormat;
import com.tencent.mobileqq.qqlive.sail.model.audience.WindowMode;
import com.tencent.mobileqq.qqlive.sail.model.player.PlayerConfig;
import com.tencent.mobileqq.qqlive.sso.request.QQLiveGetAudienceInfoViewableReq;
import com.tencent.mobileqq.qqlive.widget.player.QQLiveRemotePlayer;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 b2\u00020\u0001:\u0001cB\u0007\u00a2\u0006\u0004\b`\u0010aJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J \u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rJ\u0006\u0010\u0012\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\u0010J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J\u000e\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0015J\u0006\u0010\u0019\u001a\u00020\u0010J\u0006\u0010\u001a\u001a\u00020\u0010R$\u0010\"\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010*\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u00102\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001d\u00109\u001a\b\u0012\u0004\u0012\u000204038\u0006\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\"\u0010A\u001a\u00020:8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R(\u0010F\u001a\b\u0012\u0004\u0012\u00020:038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u00106\u001a\u0004\bC\u00108\"\u0004\bD\u0010ER\"\u0010I\u001a\u0010\u0012\f\u0012\n G*\u0004\u0018\u00010:0:038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u00106R\u001d\u0010O\u001a\b\u0012\u0004\u0012\u00020:0J8\u0006\u00a2\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010NR\"\u0010Q\u001a\u0010\u0012\f\u0012\n G*\u0004\u0018\u00010:0:038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u00106R\u001d\u0010T\u001a\b\u0012\u0004\u0012\u00020:0J8\u0006\u00a2\u0006\f\n\u0004\bR\u0010L\u001a\u0004\bS\u0010NR%\u0010W\u001a\u0010\u0012\f\u0012\n G*\u0004\u0018\u00010:0:038\u0006\u00a2\u0006\f\n\u0004\bU\u00106\u001a\u0004\bV\u00108R)\u0010\\\u001a\u0010\u0012\f\u0012\n G*\u0004\u0018\u00010X0X038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b[\u00108R!\u0010_\u001a\b\u0012\u0004\u0012\u00020X0J8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b]\u0010Z\u001a\u0004\b^\u0010N\u00a8\u0006d"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/room/RoomViewModel;", "Lcom/tencent/mobileqq/qqlive/sail/base/d;", "Lcom/tencent/mobileqq/qqlive/context/QQLiveContext;", "context", "Lcom/tencent/mobileqq/qqlive/sail/room/d;", "Q1", "Lqr4/b;", "feed", "Lcom/tencent/mobileqq/qqlive/sail/room/e;", "floatRoom", "P1", "Lcom/tencent/mobileqq/qqlive/sail/model/audience/StreamDefinition;", "streamDefinition", "", "originUrl", "urlWithToken", "", "j2", "k2", "l2", "", "Lcom/tencent/mobileqq/qqlive/api/av/ResolutionLevelType;", "c2", "resolutionLevelType", "m2", "clean", "R1", "Lcom/tencent/mobileqq/qqlive/sail/room/f;", "i", "Lcom/tencent/mobileqq/qqlive/sail/room/f;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "()Lcom/tencent/mobileqq/qqlive/sail/room/f;", "setRoom", "(Lcom/tencent/mobileqq/qqlive/sail/room/f;)V", "room", "Lcom/tencent/mobileqq/qqlive/sail/model/g;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qqlive/sail/model/g;", "b2", "()Lcom/tencent/mobileqq/qqlive/sail/model/g;", "i2", "(Lcom/tencent/mobileqq/qqlive/sail/model/g;)V", "roomSelectInfo", "Lcom/tencent/mobileqq/qqlive/sail/model/audience/a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qqlive/sail/model/audience/a;", "T1", "()Lcom/tencent/mobileqq/qqlive/sail/model/audience/a;", SemanticAttributes.DbSystemValues.H2, "(Lcom/tencent/mobileqq/qqlive/sail/model/audience/a;)V", "currentPlayStream", "Landroidx/lifecycle/MutableLiveData;", "Landroid/util/Size;", "D", "Landroidx/lifecycle/MutableLiveData;", "d2", "()Landroidx/lifecycle/MutableLiveData;", "videoSizeLiveData", "", "E", "Z", "S1", "()Z", "g2", "(Z)V", "audienceUseRemotePlayer", UserInfo.SEX_FEMALE, "e2", "setVideoViewClickLiveData", "(Landroidx/lifecycle/MutableLiveData;)V", "videoViewClickLiveData", "kotlin.jvm.PlatformType", "G", "_isFrontCamera", "Landroidx/lifecycle/LiveData;", "H", "Landroidx/lifecycle/LiveData;", "Z1", "()Landroidx/lifecycle/LiveData;", "onCameraSwitched", "I", "_onCameraMirrorSwitched", "J", "X1", "onCameraMirrorSwitched", "K", "W1", "micSwitch", "Lcom/tencent/mobileqq/qqlive/api/av/LiveMediaConfig;", "L", "Lkotlin/Lazy;", "f2", "_liveMediaConfig", "M", "U1", "liveMediaConfig", "<init>", "()V", "N", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class RoomViewModel extends com.tencent.mobileqq.qqlive.sail.base.d {
    static IPatchRedirector $redirector_;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static boolean P;
    private static boolean Q;
    private static boolean R;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqlive.sail.model.audience.a currentPlayStream;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Size> videoSizeLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean audienceUseRemotePlayer;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Boolean> videoViewClickLiveData;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _isFrontCamera;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> onCameraSwitched;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _onCameraMirrorSwitched;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> onCameraMirrorSwitched;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> micSwitch;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Lazy _liveMediaConfig;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Lazy liveMediaConfig;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqlive.sail.room.f room;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqlive.sail.model.g roomSelectInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u0014\u0010\u0010\u001a\u00020\u000f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/room/RoomViewModel$a;", "", "", "isFontCamera", "Z", "b", "()Z", "setFontCamera", "(Z)V", "isFrontCameraMirror", "c", "setFrontCameraMirror", "isBackgroundCameraMirror", "a", "setBackgroundCameraMirror", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.room.RoomViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                return;
            }
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) defaultConstructorMarker);
        }

        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return RoomViewModel.R;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }

        public final boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return RoomViewModel.P;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }

        public final boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return RoomViewModel.Q;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
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
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/room/RoomViewModel$b", "Lcom/tencent/mobileqq/qqlive/api/ILiveNetRequest$Callback;", "Lir4/b;", "Lcom/tencent/mobileqq/qqlive/api/sso/QQLiveResponse;", "response", "", "onResponse", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements ILiveNetRequest.Callback<ir4.b> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Long f273137a;

        b(Long l3) {
            this.f273137a = l3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) l3);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.api.ILiveNetRequest.Callback
        public void onResponse(@NotNull QQLiveResponse<ir4.b> response) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) response);
                return;
            }
            Intrinsics.checkNotNullParameter(response, "response");
            if (response.isFailed()) {
                AegisLogger.INSTANCE.e("Audience|RoomViewModel", "fetchAudienceInfoViewable", "onFailed, errCode=" + response.getRetCode() + ", errMsg=" + response.getErrMsg());
                return;
            }
            ir4.b rsp = response.getRsp();
            boolean z16 = false;
            if (rsp != null && rsp.f408444a == 2) {
                z16 = true;
            }
            AegisLogger.INSTANCE.i("Audience|RoomViewModel", "fetchAudienceInfoViewable", "onSuccess, isHiddenUserInfo=" + z16);
            com.tencent.timi.game.liveroom.impl.room.manager.e.INSTANCE.a().f(this.f273137a.longValue(), z16);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53097);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 26)) {
            redirector.redirect((short) 26);
            return;
        }
        INSTANCE = new Companion(null);
        P = true;
        Q = true;
    }

    public RoomViewModel() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.videoSizeLiveData = new MutableLiveData<>();
        this.videoViewClickLiveData = new MutableLiveData<>();
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>(Boolean.valueOf(P));
        this._isFrontCamera = mutableLiveData;
        this.onCameraSwitched = mutableLiveData;
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>(Boolean.valueOf(Q));
        this._onCameraMirrorSwitched = mutableLiveData2;
        this.onCameraMirrorSwitched = mutableLiveData2;
        this.micSwitch = new MutableLiveData<>(Boolean.TRUE);
        lazy = LazyKt__LazyJVMKt.lazy(RoomViewModel$_liveMediaConfig$2.INSTANCE);
        this._liveMediaConfig = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<MutableLiveData<LiveMediaConfig>>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.room.RoomViewModel$liveMediaConfig$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RoomViewModel.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MutableLiveData<LiveMediaConfig> invoke() {
                MutableLiveData<LiveMediaConfig> f26;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (MutableLiveData) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                f26 = RoomViewModel.this.f2();
                return f26;
            }
        });
        this.liveMediaConfig = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MutableLiveData<LiveMediaConfig> f2() {
        return (MutableLiveData) this._liveMediaConfig.getValue();
    }

    @NotNull
    public final com.tencent.mobileqq.qqlive.sail.room.e P1(@NotNull QQLiveContext context, @NotNull qr4.b feed, @Nullable com.tencent.mobileqq.qqlive.sail.room.e floatRoom) {
        Long l3;
        Long l16;
        long j3;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (com.tencent.mobileqq.qqlive.sail.room.e) iPatchRedirector.redirect((short) 18, this, context, feed, floatRoom);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(feed, "feed");
        com.tencent.mobileqq.qqlive.sail.room.e eVar = null;
        if (this.room == null) {
            qr4.f fVar = feed.f429376a;
            if (fVar != null) {
                l3 = Long.valueOf(fVar.f429397a);
            } else {
                l3 = null;
            }
            if (floatRoom != null) {
                l16 = Long.valueOf(floatRoom.getRoomId());
            } else {
                l16 = null;
            }
            if (Intrinsics.areEqual(l3, l16)) {
                this.room = floatRoom;
            } else if (floatRoom != null) {
                floatRoom.destroy();
            }
            if (this.room == null) {
                com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
                qr4.f fVar2 = feed.f429376a;
                if (fVar2 != null) {
                    j3 = fVar2.f429397a;
                } else {
                    j3 = 0;
                }
                QQLiveRemotePlayer x16 = cVar.x(j3);
                if (x16 != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                this.audienceUseRemotePlayer = z16;
                AudienceRoomInfo c16 = com.tencent.mobileqq.qqlive.sail.model.c.c(feed, QQLiveBusinessConfig.QQLIVE_APP_ID);
                PlayerConfig a16 = com.tencent.mobileqq.qqlive.sail.util.a.f273183a.a();
                if (c16.x()) {
                    a16.t(false);
                }
                this.room = com.tencent.mobileqq.qqlive.context.b.a(context, c16, a16, x16);
            }
            com.tencent.mobileqq.qqlive.sail.c.f272176a.b();
        }
        com.tencent.mobileqq.qqlive.sail.room.f fVar3 = this.room;
        if (fVar3 instanceof com.tencent.mobileqq.qqlive.sail.room.e) {
            eVar = (com.tencent.mobileqq.qqlive.sail.room.e) fVar3;
        }
        if (eVar != null) {
            eVar.d(WindowMode.NORMAL);
        }
        com.tencent.mobileqq.qqlive.sail.room.f fVar4 = this.room;
        Intrinsics.checkNotNull(fVar4, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.sail.room.ILiveAudienceRoom");
        return (com.tencent.mobileqq.qqlive.sail.room.e) fVar4;
    }

    @NotNull
    public final com.tencent.mobileqq.qqlive.sail.room.d Q1(@NotNull QQLiveContext context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (com.tencent.mobileqq.qqlive.sail.room.d) iPatchRedirector.redirect((short) 17, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.room == null) {
            this.room = com.tencent.mobileqq.qqlive.context.b.b(context);
        }
        com.tencent.mobileqq.qqlive.sail.room.f fVar = this.room;
        Intrinsics.checkNotNull(fVar, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.sail.room.ILiveAnchorTrtcRoom");
        return (com.tencent.mobileqq.qqlive.sail.room.d) fVar;
    }

    public final void R1() {
        Long l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        com.tencent.mobileqq.qqlive.sail.room.f fVar = this.room;
        if (fVar != null) {
            l3 = Long.valueOf(fVar.getRoomId());
        } else {
            l3 = null;
        }
        if (l3 != null && l3.longValue() != 0) {
            ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new QQLiveGetAudienceInfoViewableReq(l3.longValue()), new b(l3));
        } else {
            AegisLogger.INSTANCE.e("Audience|RoomViewModel", "fetchAudienceInfoViewable", "invalid roomId");
        }
    }

    public final boolean S1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.audienceUseRemotePlayer;
    }

    @Nullable
    public final com.tencent.mobileqq.qqlive.sail.model.audience.a T1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.mobileqq.qqlive.sail.model.audience.a) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.currentPlayStream;
    }

    @NotNull
    public final LiveData<LiveMediaConfig> U1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (LiveData) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return (LiveData) this.liveMediaConfig.getValue();
    }

    @NotNull
    public final MutableLiveData<Boolean> W1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.micSwitch;
    }

    @NotNull
    public final LiveData<Boolean> X1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (LiveData) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.onCameraMirrorSwitched;
    }

    @NotNull
    public final LiveData<Boolean> Z1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (LiveData) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.onCameraSwitched;
    }

    @Nullable
    public final com.tencent.mobileqq.qqlive.sail.room.f a2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.qqlive.sail.room.f) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.room;
    }

    @Nullable
    public final com.tencent.mobileqq.qqlive.sail.model.g b2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.qqlive.sail.model.g) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.roomSelectInfo;
    }

    @NotNull
    public final List<ResolutionLevelType> c2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (List) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        if (Intrinsics.areEqual(this._isFrontCamera.getValue(), Boolean.TRUE)) {
            return ResolutionLevelType.INSTANCE.getSupportResLevels(LiveMediaConfigManager.INSTANCE.isFrontCameraSupportBluRay());
        }
        return ResolutionLevelType.INSTANCE.getSupportResLevels(LiveMediaConfigManager.INSTANCE.isBackgroundCameraSupportBluRay());
    }

    public final void clean() {
        long j3;
        com.tencent.mobileqq.qqlive.sail.room.e eVar;
        WindowMode windowMode;
        Long l3;
        AudienceRoomInfo b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
        SailAudienceRoomManager m3 = cVar.m();
        com.tencent.mobileqq.qqlive.sail.room.f fVar = this.room;
        if (fVar != null) {
            j3 = fVar.getRoomId();
        } else {
            j3 = 0;
        }
        m3.I(j3);
        com.tencent.mobileqq.qqlive.sail.room.f fVar2 = this.room;
        if (fVar2 instanceof com.tencent.mobileqq.qqlive.sail.room.e) {
            eVar = (com.tencent.mobileqq.qqlive.sail.room.e) fVar2;
        } else {
            eVar = null;
        }
        if (eVar != null && (b16 = eVar.b()) != null) {
            windowMode = b16.v();
        } else {
            windowMode = null;
        }
        if (windowMode == WindowMode.FLOAT) {
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            com.tencent.mobileqq.qqlive.sail.room.f fVar3 = this.room;
            if (fVar3 != null) {
                l3 = Long.valueOf(fVar3.getRoomId());
            } else {
                l3 = null;
            }
            companion.i("Audience|RoomViewModel", "clean", "room " + l3 + " is in float window mode, no need to destroy");
        } else {
            com.tencent.mobileqq.qqlive.sail.room.f fVar4 = this.room;
            if (fVar4 != null) {
                fVar4.destroy();
            }
        }
        this.room = null;
        cVar.d().w(null);
    }

    @NotNull
    public final MutableLiveData<Size> d2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.videoSizeLiveData;
    }

    @NotNull
    public final MutableLiveData<Boolean> e2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.videoViewClickLiveData;
    }

    public final void g2(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else {
            this.audienceUseRemotePlayer = z16;
        }
    }

    public final void h2(@Nullable com.tencent.mobileqq.qqlive.sail.model.audience.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) aVar);
        } else {
            this.currentPlayStream = aVar;
        }
    }

    public final void i2(@Nullable com.tencent.mobileqq.qqlive.sail.model.g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) gVar);
        } else {
            this.roomSelectInfo = gVar;
        }
    }

    public final void j2(@NotNull StreamDefinition streamDefinition, @NotNull String originUrl, @NotNull String urlWithToken) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, streamDefinition, originUrl, urlWithToken);
            return;
        }
        Intrinsics.checkNotNullParameter(streamDefinition, "streamDefinition");
        Intrinsics.checkNotNullParameter(originUrl, "originUrl");
        Intrinsics.checkNotNullParameter(urlWithToken, "urlWithToken");
        if (this.currentPlayStream != null) {
            return;
        }
        this.currentPlayStream = new com.tencent.mobileqq.qqlive.sail.model.audience.a(Constants.Business.DEFAULT, streamDefinition, 0, originUrl, StreamFormat.FLV, urlWithToken);
    }

    public final void k2() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        boolean z17 = !P;
        P = z17;
        this._isFrontCamera.setValue(Boolean.valueOf(z17));
        MutableLiveData<Boolean> mutableLiveData = this._onCameraMirrorSwitched;
        if (Intrinsics.areEqual(this._isFrontCamera.getValue(), Boolean.TRUE)) {
            z16 = Q;
        } else {
            z16 = R;
        }
        mutableLiveData.postValue(Boolean.valueOf(z16));
    }

    public final void l2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        Boolean value = this._isFrontCamera.getValue();
        if (value != null) {
            if (value.booleanValue()) {
                boolean z16 = !Q;
                Q = z16;
                this._onCameraMirrorSwitched.setValue(Boolean.valueOf(z16));
            } else {
                boolean z17 = !R;
                R = z17;
                this._onCameraMirrorSwitched.setValue(Boolean.valueOf(z17));
            }
        }
    }

    public final void m2(@NotNull ResolutionLevelType resolutionLevelType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) resolutionLevelType);
            return;
        }
        Intrinsics.checkNotNullParameter(resolutionLevelType, "resolutionLevelType");
        LiveMediaConfigManager liveMediaConfigManager = LiveMediaConfigManager.INSTANCE;
        liveMediaConfigManager.setResolutionLevelTypeCache(resolutionLevelType);
        f2().setValue(liveMediaConfigManager.getLiveMediaConfig(0, resolutionLevelType));
    }
}
