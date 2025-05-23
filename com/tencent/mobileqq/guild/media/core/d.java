package com.tencent.mobileqq.guild.media.core;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\u0006\u0010\u0007\u001a\u00020\u0006R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/d;", "Lcom/tencent/mobileqq/guild/media/core/g;", "Lcom/tencent/mobileqq/guild/media/core/logic/h;", "", BdhLogUtil.LogTag.Tag_Req, ExifInterface.LATITUDE_SOUTH, "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/guild/media/core/MediaBusinessState;", "e", "Lcom/tencent/mobileqq/guild/media/core/MediaBusinessState;", "P", "()Lcom/tencent/mobileqq/guild/media/core/MediaBusinessState;", "T", "(Lcom/tencent/mobileqq/guild/media/core/MediaBusinessState;)V", "state", "Lcom/tencent/mobileqq/guild/media/core/MediaBusinessType;", "O", "()Lcom/tencent/mobileqq/guild/media/core/MediaBusinessType;", "businessType", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public abstract class d extends com.tencent.mobileqq.guild.media.core.logic.h {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MediaBusinessState state = MediaBusinessState.INIT;

    @NotNull
    public abstract MediaBusinessType O();

    @NotNull
    /* renamed from: P, reason: from getter */
    public final MediaBusinessState getState() {
        return this.state;
    }

    public final boolean Q() {
        if (this.state == MediaBusinessState.ACTIVE) {
            return true;
        }
        return false;
    }

    public abstract void R();

    public abstract void S();

    public final void T(@NotNull MediaBusinessState mediaBusinessState) {
        Intrinsics.checkNotNullParameter(mediaBusinessState, "<set-?>");
        this.state = mediaBusinessState;
    }
}
