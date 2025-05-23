package com.tencent.mobileqq.guild.feed.morepanel.handler;

import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedRichMediaData;
import com.tencent.mobileqq.guild.feed.morepanel.PanelContext;
import com.tencent.mobileqq.guild.feed.morepanel.handler.x;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.feed.util.bm;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.QBarResult;
import com.tencent.mobileqq.qrscan.ScannerResult;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0010B\u0013\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b\u0014\u0010\u0015J \u0010\b\u001a\u00020\u00072\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005H\u0002J0\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016J(\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005H\u0016R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/handler/u;", "Lcom/tencent/mobileqq/guild/feed/morepanel/handler/x;", "Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;", "Landroid/app/Activity;", "Lvk1/b;", "Lcom/tencent/mobileqq/guild/feed/morepanel/impl/MorePanelContext;", "panelContext", "", "d", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "shareActionSheet", "c", "", "id", "a", "Lcom/tencent/mobileqq/qrscan/ScannerResult;", "Lcom/tencent/mobileqq/qrscan/ScannerResult;", "qrCodeScannerResult", "<init>", "(Lcom/tencent/mobileqq/qrscan/ScannerResult;)V", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class u implements x {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final ScannerResult qrCodeScannerResult;

    public u(@Nullable ScannerResult scannerResult) {
        this.qrCodeScannerResult = scannerResult;
    }

    private final boolean d(PanelContext<Activity, vk1.b> panelContext) {
        ArrayList<QBarResult> arrayList;
        Object firstOrNull;
        vk1.b j3 = panelContext.j();
        Logger.f235387a.d().i("guild.share.GuildFeedDetailScanQRCodeHandler", 1, "handle " + j3.n());
        Object n3 = j3.n();
        String str = null;
        if (!(n3 instanceof GuildFeedRichMediaData)) {
            n3 = null;
        }
        GuildFeedRichMediaData guildFeedRichMediaData = (GuildFeedRichMediaData) n3;
        if (guildFeedRichMediaData == null) {
            QQToastUtil.showQQToast(1, "\u5206\u4eab\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5~");
            return false;
        }
        Option option = new Option();
        option.setUrl(bm.d(guildFeedRichMediaData));
        Intent intent = new Intent();
        intent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", com.tencent.mobileqq.guild.picload.e.a().c(option));
        intent.putExtra("detectType", 1);
        intent.putExtra("fromPicQRDecode", true);
        ScannerResult scannerResult = this.qrCodeScannerResult;
        if (scannerResult != null) {
            intent.putExtra("preScanResult", scannerResult);
        }
        String str2 = guildFeedRichMediaData.getImage().picUrl;
        Intrinsics.checkNotNullExpressionValue(str2, "mediaData.image.picUrl");
        intent.putExtra("report_params", ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).buildQRScanReportParams(null, str2, null, null, null, 5));
        Pair pair = TuplesKt.to(j3.r(), Long.valueOf(j3.getGuildId()));
        String str3 = (String) pair.component1();
        long longValue = ((Number) pair.component2()).longValue();
        ScannerResult scannerResult2 = this.qrCodeScannerResult;
        if (scannerResult2 != null && (arrayList = scannerResult2.f276520d) != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
            QBarResult qBarResult = (QBarResult) firstOrNull;
            if (qBarResult != null) {
                str = qBarResult.f276508f;
            }
        }
        ax.j(intent, str2, str, str3, String.valueOf(longValue));
        RouteUtils.startActivity(panelContext.h(), intent, "/qrscan/scanner");
        return true;
    }

    @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.y
    public boolean a(@NotNull String id5, @NotNull PanelContext<Activity, vk1.b> panelContext) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(panelContext, "panelContext");
        return d(panelContext);
    }

    @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.y
    public boolean b(@NotNull String str, @NotNull PanelContext<Activity, vk1.b> panelContext) {
        return x.a.c(this, str, panelContext);
    }

    @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.x
    public boolean c(@NotNull ShareActionSheetBuilder.ActionSheetItem item, @NotNull PanelContext<Activity, vk1.b> panelContext, @NotNull ShareActionSheet shareActionSheet) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(panelContext, "panelContext");
        Intrinsics.checkNotNullParameter(shareActionSheet, "shareActionSheet");
        shareActionSheet.dismiss();
        return d(panelContext);
    }
}
