package com.tencent.mobileqq.guild.media.core.logic;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0002 !B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u000e\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\u0003J\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/ScreenShareStatusHelper;", "", "Lcom/tencent/mobileqq/guild/media/core/logic/h;", "", "E0", "u", "", "P", "isReceived", BdhLogUtil.LogTag.Tag_Req, "O", "Lcom/tencent/mobileqq/guild/media/core/data/p;", ITVKPlayerEventListener.KEY_USER_INFO, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/guild/media/core/f;", "e", "Lcom/tencent/mobileqq/guild/media/core/f;", "core", "Lcom/tencent/mobileqq/guild/media/core/logic/ScreenShareStatusHelper$ScreenSharePageType;", "f", "Lcom/tencent/mobileqq/guild/media/core/logic/ScreenShareStatusHelper$ScreenSharePageType;", "mDefaultPageType", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", tl.h.F, "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "mTimeoutAlertDialog", "i", "Z", "mIsForbiddenPushReceived", "<init>", "(Lcom/tencent/mobileqq/guild/media/core/f;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "ScreenSharePageType", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ScreenShareStatusHelper extends h {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.media.core.f core;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ScreenSharePageType mDefaultPageType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QQCustomDialog mTimeoutAlertDialog;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mIsForbiddenPushReceived;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/ScreenShareStatusHelper$ScreenSharePageType;", "", "(Ljava/lang/String;I)V", "DEFAULT", "FULLSCREEN", "HALF_SCREEN", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public enum ScreenSharePageType {
        DEFAULT,
        FULLSCREEN,
        HALF_SCREEN
    }

    public ScreenShareStatusHelper(@NotNull com.tencent.mobileqq.guild.media.core.f core) {
        Intrinsics.checkNotNullParameter(core, "core");
        this.core = core;
        this.mDefaultPageType = ScreenSharePageType.DEFAULT;
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void E0() {
        super.E0();
        R(false);
    }

    public final void O() {
        QQCustomDialog qQCustomDialog;
        boolean z16 = true;
        QLog.i("QGMC.ScreenShareStatusHelper", 1, "[clear] ");
        this.mDefaultPageType = ScreenSharePageType.DEFAULT;
        QQCustomDialog qQCustomDialog2 = this.mTimeoutAlertDialog;
        if (qQCustomDialog2 != null) {
            if (qQCustomDialog2 == null || !qQCustomDialog2.isShowing()) {
                z16 = false;
            }
            if (z16 && (qQCustomDialog = this.mTimeoutAlertDialog) != null) {
                qQCustomDialog.dismiss();
            }
        }
        this.mTimeoutAlertDialog = null;
    }

    /* renamed from: P, reason: from getter */
    public boolean getMIsForbiddenPushReceived() {
        return this.mIsForbiddenPushReceived;
    }

    public final boolean Q(@NotNull com.tencent.mobileqq.guild.media.core.data.p userInfo) {
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        if (userInfo.f228101i && !userInfo.f228113u) {
            return true;
        }
        return false;
    }

    public final void R(boolean isReceived) {
        this.mIsForbiddenPushReceived = isReceived;
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void u() {
        super.u();
        R(false);
    }
}
