package com.tencent.mobileqq.guild.share;

import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBusiData;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCreateShareRsp;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u0003B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0003\u001a\u00020\u0002R\u001f\u0010\b\u001a\n \u0004*\u0004\u0018\u00010\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001f\u0010\n\u001a\n \u0004*\u0004\u0018\u00010\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\u001f\u0010\u0010\u001a\n \u0004*\u0004\u0018\u00010\u000b0\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0005\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/share/b;", "", "", "a", "kotlin.jvm.PlatformType", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "templateData", "getPlatData", "platData", "", "c", "[B", "getBusiData", "()[B", MessageForQCircleFeed.MSG_QCIRCLE_FEED_LEY_BUSI_DATA, "d", "attaId", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProCreateShareRsp;", "rsp", "<init>", "(Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProCreateShareRsp;)V", "e", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String templateData;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String platData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final byte[] busiData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String attaId;

    public b(@NotNull GProCreateShareRsp rsp) {
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        this.templateData = rsp.getTemplateData();
        this.platData = rsp.platData;
        this.busiData = rsp.info.busiData;
    }

    @NotNull
    public final String a() {
        boolean z16;
        String str = this.attaId;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            String str2 = this.attaId;
            if (str2 == null) {
                return "";
            }
            return str2;
        }
        com.tencent.qqnt.kernel.api.o feedService = ((IGProSession) ch.R0(IGProSession.class)).getFeedService();
        if (feedService == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("[getAttaId] feedService is null, so return");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("FetchedArkInfo", 1, (String) it.next(), null);
            }
            return "";
        }
        try {
            byte[] busiData = this.busiData;
            Intrinsics.checkNotNullExpressionValue(busiData, "busiData");
            GProBusiData decodeBusiData = feedService.decodeBusiData(busiData);
            if (decodeBusiData != null) {
                this.attaId = decodeBusiData.getShareAttaData().attaContentId;
            }
        } catch (Throwable th5) {
            Logger logger2 = Logger.f235387a;
            Logger.b bVar2 = new Logger.b();
            bVar2.a().add("[getAttaId] decodeBusiData error!");
            Iterator<T> it5 = bVar2.a().iterator();
            while (it5.hasNext()) {
                Logger.f235387a.d().e("FetchedArkInfo", 1, (String) it5.next(), th5);
            }
        }
        String str3 = this.attaId;
        if (str3 == null) {
            return "";
        }
        return str3;
    }

    /* renamed from: b, reason: from getter */
    public final String getTemplateData() {
        return this.templateData;
    }
}
