package com.tencent.mobileqq.guild.client.selectaccount;

import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qqguildsdk.data.db;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0016\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/client/selectaccount/GuildClientSelectAreaListDialogFragment;", "Lcom/tencent/mobileqq/guild/client/selectaccount/GuildClientSelectListDialogFragment;", "", "data", "Lcom/tencent/mobileqq/guild/client/selectaccount/p;", OcrConfig.CHINESE, "", "titleName", "clientId", "areaId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "P", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public class GuildClientSelectAreaListDialogFragment extends GuildClientSelectListDialogFragment {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildClientSelectAreaListDialogFragment(@NotNull String titleName, @NotNull String clientId, @NotNull String areaId) {
        super(titleName, clientId, areaId);
        Intrinsics.checkNotNullParameter(titleName, "titleName");
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(areaId, "areaId");
    }

    @Override // com.tencent.mobileqq.guild.client.selectaccount.GuildClientSelectListDialogFragment
    @NotNull
    public p zh(@NotNull Object data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (data instanceof db) {
            db dbVar = (db) data;
            String id5 = dbVar.getId();
            Intrinsics.checkNotNullExpressionValue(id5, "data.id");
            String desc = dbVar.getDesc();
            Intrinsics.checkNotNullExpressionValue(desc, "data.desc");
            return new p(id5, desc);
        }
        return new p("", "");
    }
}
