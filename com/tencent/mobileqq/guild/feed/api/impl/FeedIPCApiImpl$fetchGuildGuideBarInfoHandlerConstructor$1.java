package com.tencent.mobileqq.guild.feed.api.impl;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.base.GuideBarGuildInfo;
import com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProBatchGetGuildLabelInfoRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLabel;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLabelInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import okio.internal._Utf8Kt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0010\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/ipc/methods/AbsIpcMethod$a;", "ipcContext", "", "", "args", "", "invoke", "(Lcom/tencent/mobileqq/guild/ipc/methods/AbsIpcMethod$a;[Ljava/lang/Object;)Ljava/lang/Void;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedIPCApiImpl$fetchGuildGuideBarInfoHandlerConstructor$1 extends Lambda implements Function2 {
    public static final FeedIPCApiImpl$fetchGuildGuideBarInfoHandlerConstructor$1 INSTANCE = new FeedIPCApiImpl$fetchGuildGuideBarInfoHandlerConstructor$1();

    FeedIPCApiImpl$fetchGuildGuideBarInfoHandlerConstructor$1() {
        super(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x006f, code lost:
    
        if (r11 == null) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void b(AbsIpcMethod.a ipcContext, String guildId, int i3, String str, IGProBatchGetGuildLabelInfoRsp iGProBatchGetGuildLabelInfoRsp) {
        Object firstOrNull;
        Object firstOrNull2;
        String str2;
        byte[] labelName;
        Intrinsics.checkNotNullParameter(ipcContext, "$ipcContext");
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        if (i3 == 0 && iGProBatchGetGuildLabelInfoRsp != null) {
            ArrayList<IGProGuildLabelInfo> list = iGProBatchGetGuildLabelInfoRsp.getList();
            Intrinsics.checkNotNullExpressionValue(list, "rsp.list");
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
            IGProGuildLabelInfo iGProGuildLabelInfo = (IGProGuildLabelInfo) firstOrNull;
            if (iGProGuildLabelInfo == null) {
                QLog.e("FeedIPCApiImpl", 1, "batchGetGuildLabelInfo|has responded but there is nothing info");
                ipcContext.a(-102, Bundle.EMPTY);
                return;
            }
            Pair[] pairArr = new Pair[1];
            String guildName = iGProGuildLabelInfo.getGuildName();
            String guildIcon = iGProGuildLabelInfo.getGuildIcon();
            Boolean valueOf = Boolean.valueOf(!ch.j0(guildId));
            ArrayList<IGProGuildLabel> labels = iGProGuildLabelInfo.getLabels();
            Intrinsics.checkNotNullExpressionValue(labels, "it.labels");
            firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) labels);
            IGProGuildLabel iGProGuildLabel = (IGProGuildLabel) firstOrNull2;
            if (iGProGuildLabel != null && (labelName = iGProGuildLabel.getLabelName()) != null) {
                Intrinsics.checkNotNullExpressionValue(labelName, "labelName");
                str2 = _Utf8Kt.commonToUtf8String$default(labelName, 0, 0, 3, null);
            }
            str2 = "";
            pairArr[0] = TuplesKt.to("guild_guide_bar_info", new GuideBarGuildInfo(guildId, guildName, guildIcon, valueOf, str2));
            ipcContext.b(BundleKt.bundleOf(pairArr));
            return;
        }
        QLog.e("FeedIPCApiImpl", 1, "batchGetGuildLabelInfo|result=" + i3 + ", errMsg=" + str);
        ipcContext.a(-102, Bundle.EMPTY);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Void invoke(@NotNull final AbsIpcMethod.a ipcContext, @NotNull Object[] args) {
        Object firstOrNull;
        Object m476constructorimpl;
        ArrayList<Long> arrayListOf;
        String stackTraceToString;
        Intrinsics.checkNotNullParameter(ipcContext, "ipcContext");
        Intrinsics.checkNotNullParameter(args, "args");
        firstOrNull = ArraysKt___ArraysKt.firstOrNull(args);
        final String str = firstOrNull instanceof String ? (String) firstOrNull : null;
        if (str == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
            m476constructorimpl = Result.m476constructorimpl((IGPSService) (appInterface != null ? appInterface.getRuntimeService(IGPSService.class, "") : null));
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(m479exceptionOrNullimpl);
            QLog.e("FeedIPCApiImpl", 1, "fetchServiceApi failed: " + stackTraceToString);
        }
        if (Result.m482isFailureimpl(m476constructorimpl)) {
            m476constructorimpl = null;
        }
        IGPSService iGPSService = (IGPSService) m476constructorimpl;
        if (iGPSService != null) {
            com.tencent.mobileqq.qqguildsdk.data.genc.r rVar = new com.tencent.mobileqq.qqguildsdk.data.genc.r();
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Long.valueOf(MiscKt.l(str)));
            rVar.c(arrayListOf);
            rVar.d(2);
            iGPSService.batchGetGuildLabelInfo(rVar, new wh2.e() { // from class: com.tencent.mobileqq.guild.feed.api.impl.b
                @Override // wh2.e
                public final void a(int i3, String str2, IGProBatchGetGuildLabelInfoRsp iGProBatchGetGuildLabelInfoRsp) {
                    FeedIPCApiImpl$fetchGuildGuideBarInfoHandlerConstructor$1.b(AbsIpcMethod.a.this, str, i3, str2, iGProBatchGetGuildLabelInfoRsp);
                }
            });
        }
        return null;
    }
}
