package com.tencent.mobileqq.guild.discoveryv2.content.recommend.section;

import com.tencent.biz.richframework.adapter.section.SectionIOCKt;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\t\u001a\u00020\u00038DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/ar;", "T", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lcom/tencent/mobileqq/guild/discoveryv2/fragment/e;", "d", "Lcom/tencent/mobileqq/guild/discoveryv2/fragment/e;", "_depends", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/mobileqq/guild/discoveryv2/fragment/e;", "depends", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/d;", "p", "()Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/d;", "clickProcessor", "Lcom/tencent/mobileqq/guild/discoveryv2/fragment/d;", "r", "()Lcom/tencent/mobileqq/guild/discoveryv2/fragment/d;", "sourceDepends", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class ar<T> extends Section<T> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.discoveryv2.fragment.e _depends;

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final com.tencent.mobileqq.guild.discoveryv2.content.recommend.d p() {
        return q().e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final com.tencent.mobileqq.guild.discoveryv2.fragment.e q() {
        com.tencent.mobileqq.guild.discoveryv2.fragment.e eVar = this._depends;
        if (eVar == null) {
            Object iocInterface = SectionIOCKt.getIocInterface(this, com.tencent.mobileqq.guild.discoveryv2.fragment.e.class);
            Intrinsics.checkNotNull(iocInterface);
            com.tencent.mobileqq.guild.discoveryv2.fragment.e eVar2 = (com.tencent.mobileqq.guild.discoveryv2.fragment.e) iocInterface;
            this._depends = eVar2;
            return eVar2;
        }
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final com.tencent.mobileqq.guild.discoveryv2.fragment.d r() {
        return q().c();
    }
}
