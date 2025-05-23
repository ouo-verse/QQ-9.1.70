package com.tencent.mobileqq.qqlive.api.player;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.sail.model.audience.StreamFormat;
import com.tencent.mobileqq.qqlive.sail.model.player.PlayerConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0004j\b\u0012\u0004\u0012\u00020\u0001`\u00062\u0006\u0010\u0007\u001a\u00020\bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/player/TPOptionalParamBuilder;", "", "()V", "optionalParams", "Ljava/util/ArrayList;", "buildOptionalParams", "Lkotlin/collections/ArrayList;", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/qqlive/sail/model/player/PlayerConfig;", "Companion", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class TPOptionalParamBuilder {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final long DEFAULT_RETRY_TIME = 10;

    @NotNull
    private static final String QQ_LIVE_ENABLE_REDUCE_LIVE_LATENCY_ACTION = "qq_live_enable_reduce_live_latency_action";

    @NotNull
    private static final int[] SPECIAL_SEI_ARRAY;

    @NotNull
    private final ArrayList<Object> optionalParams;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/player/TPOptionalParamBuilder$Companion;", "", "()V", "DEFAULT_RETRY_TIME", "", "QQ_LIVE_ENABLE_REDUCE_LIVE_LATENCY_ACTION", "", "SPECIAL_SEI_ARRAY", "", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42898);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
            SPECIAL_SEI_ARRAY = new int[]{243};
        }
    }

    public TPOptionalParamBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.optionalParams = new ArrayList<>();
        }
    }

    @NotNull
    public final ArrayList<Object> buildOptionalParams(@NotNull PlayerConfig config) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this, (Object) config);
        }
        Intrinsics.checkNotNullParameter(config, "config");
        this.optionalParams.clear();
        this.optionalParams.add(TPOptionalParam.buildLong(TPOptionalID.OPTIONAL_ID_BEFORE_LONG_BUFFER_PACKET_TOTAL_DURATION_MS, config.i()));
        if (config.a() > 0) {
            this.optionalParams.add(TPOptionalParam.buildLong(TPOptionalID.OPTIONAL_ID_BEFORE_LONG_BUFFERING_FOR_PLAYBACK_MS, config.a()));
        }
        this.optionalParams.add(TPOptionalParam.buildQueueInt(TPOptionalID.OPTIONAL_ID_BEFORE_QUEUE_INT_SPECIAL_SEI_TYPES_CALLBACK, SPECIAL_SEI_ARRAY));
        if (config.f() == StreamFormat.FLV) {
            this.optionalParams.add(TPOptionalParam.buildQueueInt(TPOptionalID.OPTIONAL_ID_BEFORE_QUEUE_INT_DEMUXER_TYPE, new int[]{1}));
            this.optionalParams.add(TPOptionalParam.buildInt(TPOptionalID.OPTIONAL_ID_BEFORE_INT_BUFFER_STRATEGY, 2));
        }
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(QQ_LIVE_ENABLE_REDUCE_LIVE_LATENCY_ACTION, false)) {
            int value = config.h().getValue();
            this.optionalParams.add(TPOptionalParam.buildInt(TPOptionalID.OPTIONAL_ID_BEFORE_INT_REDUCE_LIVE_LATENCY_ACTION, value));
            if (value == 1) {
                this.optionalParams.add(TPOptionalParam.buildFloat(TPOptionalID.OPTIONAL_ID_BEFORE_FLOAT_REDUCE_LATENCY_SPEED_UP_RATE, config.n()));
            }
        }
        return this.optionalParams;
    }
}
