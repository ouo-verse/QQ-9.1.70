package com.tencent.mobileqq.guild.discoveryv2.content.part;

import com.tencent.mobileqq.guild.discoveryv2.content.base.MVPFeedsDataPart;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016R \u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/part/f;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/MVPFeedsDataPart;", "", "getLogTag", "", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/f;", "J9", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "vmList", "<init>", "(Lkotlin/Lazy;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class f extends MVPFeedsDataPart {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy<List<com.tencent.mobileqq.guild.discoveryv2.content.model.f>> vmList;

    /* JADX WARN: Multi-variable type inference failed */
    public f(@NotNull Lazy<? extends List<? extends com.tencent.mobileqq.guild.discoveryv2.content.model.f>> vmList) {
        Intrinsics.checkNotNullParameter(vmList, "vmList");
        this.vmList = vmList;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.MVPFeedsDataPart
    @NotNull
    public List<com.tencent.mobileqq.guild.discoveryv2.content.model.f> J9() {
        return this.vmList.getValue();
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    public String getLogTag() {
        return "SubTabDataPart";
    }
}
