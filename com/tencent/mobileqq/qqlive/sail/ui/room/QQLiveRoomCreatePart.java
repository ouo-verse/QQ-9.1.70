package com.tencent.mobileqq.qqlive.sail.ui.room;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.context.QQLiveContext;
import com.tencent.mobileqq.qqlive.huya.QQLiveHuYaUrlManager;
import com.tencent.mobileqq.qqlive.sail.model.audience.StreamDefinition;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u001d\u0012\b\b\u0002\u0010\u000f\u001a\u00020\f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/room/QQLiveRoomCreatePart;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "Lqr4/b;", "feed", "", "ha", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartResume", "Lcom/tencent/mobileqq/qqlive/sail/ui/room/QQLiveRoomCreatePart$Companion$CreateType;", "e", "Lcom/tencent/mobileqq/qqlive/sail/ui/room/QQLiveRoomCreatePart$Companion$CreateType;", "createType", "f", "Lqr4/b;", "<init>", "(Lcom/tencent/mobileqq/qqlive/sail/ui/room/QQLiveRoomCreatePart$Companion$CreateType;Lqr4/b;)V", tl.h.F, "Companion", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveRoomCreatePart extends com.tencent.mobileqq.qqlive.sail.base.c {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Companion.CreateType createType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final qr4.b feed;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/room/QQLiveRoomCreatePart$Companion;", "", "()V", "TAG", "", "CreateType", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/room/QQLiveRoomCreatePart$Companion$CreateType;", "", "(Ljava/lang/String;I)V", "ANCHOR_TRTC", "ANCHOR_OBS", "AUDIENCE", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes17.dex */
        public static final class CreateType {
            private static final /* synthetic */ CreateType[] $VALUES;
            static IPatchRedirector $redirector_;
            public static final CreateType ANCHOR_OBS;
            public static final CreateType ANCHOR_TRTC;
            public static final CreateType AUDIENCE;

            private static final /* synthetic */ CreateType[] $values() {
                return new CreateType[]{ANCHOR_TRTC, ANCHOR_OBS, AUDIENCE};
            }

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53024);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 2)) {
                    redirector.redirect((short) 2);
                    return;
                }
                ANCHOR_TRTC = new CreateType("ANCHOR_TRTC", 0);
                ANCHOR_OBS = new CreateType("ANCHOR_OBS", 1);
                AUDIENCE = new CreateType("AUDIENCE", 2);
                $VALUES = $values();
            }

            CreateType(String str, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
                }
            }

            public static CreateType valueOf(String str) {
                return (CreateType) Enum.valueOf(CreateType.class, str);
            }

            public static CreateType[] values() {
                return (CreateType[]) $VALUES.clone();
            }
        }

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

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f273121a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53028);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[Companion.CreateType.values().length];
            try {
                iArr[Companion.CreateType.ANCHOR_TRTC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Companion.CreateType.AUDIENCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Companion.CreateType.ANCHOR_OBS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f273121a = iArr;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53030);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public /* synthetic */ QQLiveRoomCreatePart(Companion.CreateType createType, qr4.b bVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? Companion.CreateType.ANCHOR_TRTC : createType, (i3 & 2) != 0 ? null : bVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, createType, bVar, Integer.valueOf(i3), defaultConstructorMarker);
    }

    private final void ha(qr4.b feed) {
        boolean z16;
        String str;
        long j3;
        boolean isBlank;
        qr4.g gVar = feed.f429377b;
        boolean z17 = true;
        if (gVar != null && gVar.f429413c) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return;
        }
        String str2 = null;
        if (gVar != null) {
            str = gVar.f429420j;
        } else {
            str = null;
        }
        StreamDefinition S1 = ((com.tencent.mobileqq.qqlive.sail.ui.definition.a) getViewModel(com.tencent.mobileqq.qqlive.sail.ui.definition.a.class)).S1();
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z17 = false;
            }
        }
        if (z17) {
            QQLiveHuYaUrlManager qQLiveHuYaUrlManager = QQLiveHuYaUrlManager.f271340a;
            qr4.f fVar = feed.f429376a;
            if (fVar != null) {
                j3 = fVar.f429397a;
            } else {
                j3 = 0;
            }
            QQLiveHuYaUrlManager.HuYaUrlInfo b16 = qQLiveHuYaUrlManager.b(j3, S1.getValue());
            if (b16 == null) {
                return;
            }
            ((RoomViewModel) getViewModel(RoomViewModel.class)).j2(S1, b16.getOriginUrl(), b16.getUrlWithToken());
            return;
        }
        if (Intrinsics.areEqual(feed.f429378c, "huya")) {
            qr4.g gVar2 = feed.f429377b;
            if (gVar2 != null) {
                str2 = gVar2.f429412b;
            }
            if (str2 == null) {
                str2 = "";
            }
            ((RoomViewModel) getViewModel(RoomViewModel.class)).j2(S1, str, str2);
            return;
        }
        ((RoomViewModel) getViewModel(RoomViewModel.class)).j2(S1, str, str);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        super.onPartCreate(activity, savedInstanceState);
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        companion.i("Open_Live|QQLiveRoomCreatePart", "onPartCreate", "createType=" + this.createType);
        QQLiveContext c16 = QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.QQLIVE_APP_ID);
        if (c16 == null) {
            companion.i("Open_Live|QQLiveRoomCreatePart", "onCreate", "liveContext is null");
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        int i3 = a.f273121a[this.createType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    companion.w("Open_Live|QQLiveRoomCreatePart", "onPartCreate", "obs room not supported yet");
                    if (activity != null) {
                        activity.finish();
                        return;
                    }
                    return;
                }
                return;
            }
            qr4.b bVar = this.feed;
            if (bVar != null) {
                ((RoomViewModel) getViewModel(RoomViewModel.class)).P1(c16, bVar, D9());
                ha(bVar);
            } else {
                companion.e("Open_Live|QQLiveRoomCreatePart", "onPartCreate", "invalid feed");
                if (activity != null) {
                    activity.finish();
                }
            }
            O9();
            return;
        }
        ((RoomViewModel) getViewModel(RoomViewModel.class)).Q1(c16);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
            return;
        }
        super.onPartResume(activity);
        com.tencent.mobileqq.qqlive.sail.room.f F9 = F9();
        boolean z16 = false;
        if (F9 != null && F9.isDestroyed()) {
            z16 = true;
        }
        if (z16) {
            AegisLogger.INSTANCE.w("Open_Live|QQLiveRoomCreatePart", "onPartResume", "roomId=" + H9() + " destroyed");
            if (activity != null) {
                activity.finish();
            }
        }
    }

    public QQLiveRoomCreatePart(@NotNull Companion.CreateType createType, @Nullable qr4.b bVar) {
        Intrinsics.checkNotNullParameter(createType, "createType");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) createType, (Object) bVar);
        } else {
            this.createType = createType;
            this.feed = bVar;
        }
    }
}
