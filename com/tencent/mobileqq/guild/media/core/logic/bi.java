package com.tencent.mobileqq.guild.media.core.logic;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.media.widget.MediaChannelDialogFragment;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserAVRspInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 !2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\"B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001f\u0010 J$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J,\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0006\u0010\u0013\u001a\u00020\nJ.\u0010\u0017\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\fJ\b\u0010\u0018\u001a\u00020\nH\u0016J\b\u0010\u0019\u001a\u00020\nH\u0016J4\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/bi;", "Lcom/tencent/mobileqq/guild/media/core/g;", "Lcom/tencent/mobileqq/guild/media/core/logic/h;", "Lcom/tencent/mobileqq/guild/media/core/logic/t;", "", "result", "", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProUserAVRspInfo;", "rspInfo", "", BdhLogUtil.LogTag.Tag_Req, "", "needCheckRsp", ExifInterface.LATITUDE_SOUTH, "Luh2/b;", "P", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/n;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "T", "micState", "screenState", "cameraState", "U", "E0", "u", "k", "Lcom/tencent/mobileqq/guild/media/core/f;", "e", "Lcom/tencent/mobileqq/guild/media/core/f;", "mediaChannelCore", "<init>", "(Lcom/tencent/mobileqq/guild/media/core/f;)V", "f", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class bi extends h implements t {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.media.core.f mediaChannelCore;

    public bi(@NotNull com.tencent.mobileqq.guild.media.core.f mediaChannelCore) {
        Intrinsics.checkNotNullParameter(mediaChannelCore, "mediaChannelCore");
        this.mediaChannelCore = mediaChannelCore;
    }

    private final uh2.b P() {
        IRuntimeService runtimeService = this.mediaChannelCore.getQQAppInterface().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "runtimeService");
        return (uh2.b) runtimeService;
    }

    private final com.tencent.mobileqq.qqguildsdk.data.genc.n Q() {
        ArrayList<com.tencent.mobileqq.qqguildsdk.data.genc.an> arrayListOf;
        com.tencent.mobileqq.qqguildsdk.data.genc.n nVar = new com.tencent.mobileqq.qqguildsdk.data.genc.n();
        nVar.a().e(MiscKt.l(this.mediaChannelCore.getGuildID()));
        nVar.a().d(MiscKt.l(this.mediaChannelCore.E()));
        nVar.f(this.mediaChannelCore.L());
        com.tencent.mobileqq.qqguildsdk.data.genc.an anVar = new com.tencent.mobileqq.qqguildsdk.data.genc.an();
        anVar.c("sgrp_stream_pgin_source_name");
        anVar.d(com.tencent.mobileqq.guild.report.b.c());
        Unit unit = Unit.INSTANCE;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(anVar);
        nVar.e(arrayListOf);
        return nVar;
    }

    private final void R(int result, String errMsg, IGProUserAVRspInfo rspInfo) {
        Logger.f235387a.d().i("QGMC.Core.MediaChannelStateReportHelper", 1, "handleOnReportAVState: result[" + result + "] errMsg[" + errMsg + "]");
    }

    private final void S(int result, String errMsg, IGProUserAVRspInfo rspInfo, boolean needCheckRsp) {
        Logger logger = Logger.f235387a;
        logger.d().i("QGMC.Core.MediaChannelStateReportHelper", 1, "handleOnReportAVState: result[" + result + "] errMsg[" + errMsg + "]");
        if (needCheckRsp && result != 0) {
            if (this.mediaChannelCore.getSelfUserInfo().f228103k) {
                logger.d().w("QGMC.Core.MediaChannelStateReportHelper", 1, "[handleOnReportAVState] closeScreenShare after failure AVReport");
                this.mediaChannelCore.W().d(true);
            }
            if (!TextUtils.isEmpty(errMsg)) {
                String btnContent = QQGuildUIUtil.r(R.string.f146610un);
                MediaChannelDialogFragment.Companion companion = MediaChannelDialogFragment.INSTANCE;
                if (errMsg == null) {
                    errMsg = "";
                }
                Intrinsics.checkNotNullExpressionValue(btnContent, "btnContent");
                companion.a(errMsg, btnContent);
            }
        }
    }

    public static /* synthetic */ void W(bi biVar, int i3, int i16, int i17, boolean z16, int i18, Object obj) {
        if ((i18 & 1) != 0) {
            i3 = 0;
        }
        if ((i18 & 2) != 0) {
            i16 = 0;
        }
        if ((i18 & 4) != 0) {
            i17 = 0;
        }
        if ((i18 & 8) != 0) {
            z16 = false;
        }
        biVar.U(i3, i16, i17, z16);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void E0() {
        super.E0();
        T();
        com.tencent.mobileqq.guild.main.d.d(com.tencent.mobileqq.guild.util.ch.m(), this.mediaChannelCore.getGuildID(), "enter Media Channel");
    }

    public final void T() {
        Logger.f235387a.d().i("QGMC.Core.MediaChannelStateReportHelper", 1, "reportClientInitState:");
        W(this, 1, 1, 1, false, 8, null);
    }

    public final void U(int micState, int screenState, int cameraState, boolean needCheckRsp) {
        String h16 = this.mediaChannelCore.v0().h();
        String E = this.mediaChannelCore.E();
        Logger.f235387a.d().i("QGMC.Core.MediaChannelStateReportHelper", 1, "reportUserMediaState: guildId[" + this.mediaChannelCore.getGuildID() + "] channelId[" + E + "] mic[" + micState + "] screen[" + screenState + "] camera[" + cameraState + "]], enablePublishRoomId[" + h16 + "]");
        com.tencent.mobileqq.qqguildsdk.data.genc.n Q = Q();
        Q.d().h(h16);
        Q.d().i(micState);
        Q.d().k(screenState);
        Q.d().g(cameraState);
        Q.d().j(0);
        Q.d().l(0);
        P().reportAVState(Q, new ch(new WeakReference(this), screenState, needCheckRsp));
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.t
    public void k(int result, @Nullable String errMsg, @Nullable IGProUserAVRspInfo rspInfo, int screenState, boolean needCheckRsp) {
        if (screenState == 2) {
            S(result, errMsg, rspInfo, needCheckRsp);
        } else {
            R(result, errMsg, rspInfo);
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void u() {
        super.u();
    }
}
