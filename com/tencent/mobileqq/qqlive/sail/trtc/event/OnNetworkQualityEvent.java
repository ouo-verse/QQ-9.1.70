package com.tencent.mobileqq.qqlive.sail.trtc.event;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.trtc.TRTCCloudDef;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B5\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\b\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R+\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/trtc/event/OnNetworkQualityEvent;", "Lcom/tencent/mobileqq/qqlive/sail/trtc/event/TrtcBaseEvent;", "Lcom/tencent/trtc/TRTCCloudDef$TRTCQuality;", "localQuality", "Lcom/tencent/trtc/TRTCCloudDef$TRTCQuality;", "getLocalQuality", "()Lcom/tencent/trtc/TRTCCloudDef$TRTCQuality;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "remoteQualities", "Ljava/util/ArrayList;", "getRemoteQualities", "()Ljava/util/ArrayList;", "", "appId", "<init>", "(Ljava/lang/String;Lcom/tencent/trtc/TRTCCloudDef$TRTCQuality;Ljava/util/ArrayList;)V", "Companion", "a", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class OnNetworkQualityEvent extends TrtcBaseEvent {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final int TRTC_QUALITY_BAD = 4;
    public static final int TRTC_QUALITY_DOWN = 6;
    public static final int TRTC_QUALITY_EXCELLENT = 1;
    public static final int TRTC_QUALITY_GOOD = 2;
    public static final int TRTC_QUALITY_POOR = 3;
    public static final int TRTC_QUALITY_UNKNOWN = 0;
    public static final int TRTC_QUALITY_VBAD = 5;

    @Nullable
    private final TRTCCloudDef.TRTCQuality localQuality;

    @Nullable
    private final ArrayList<TRTCCloudDef.TRTCQuality> remoteQualities;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/trtc/event/OnNetworkQualityEvent$a;", "", "", "TRTC_QUALITY_BAD", "I", "TRTC_QUALITY_DOWN", "TRTC_QUALITY_EXCELLENT", "TRTC_QUALITY_GOOD", "TRTC_QUALITY_POOR", "TRTC_QUALITY_UNKNOWN", "TRTC_QUALITY_VBAD", "<init>", "()V", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.trtc.event.OnNetworkQualityEvent$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32167);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnNetworkQualityEvent(@NotNull String appId, @Nullable TRTCCloudDef.TRTCQuality tRTCQuality, @Nullable ArrayList<TRTCCloudDef.TRTCQuality> arrayList) {
        super(appId);
        Intrinsics.checkNotNullParameter(appId, "appId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appId, tRTCQuality, arrayList);
        } else {
            this.localQuality = tRTCQuality;
            this.remoteQualities = arrayList;
        }
    }

    @Nullable
    public final TRTCCloudDef.TRTCQuality getLocalQuality() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TRTCCloudDef.TRTCQuality) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.localQuality;
    }

    @Nullable
    public final ArrayList<TRTCCloudDef.TRTCQuality> getRemoteQualities() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.remoteQualities;
    }
}
