package com.tencent.mobileqq.search.guildsearch.activation.delegate;

import com.tencent.biz.richframework.adapter.section.SectionIOCKt;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.search.guildsearch.parts.GuildSearchActivationPart;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J/\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0014\u00a2\u0006\u0004\b\n\u0010\u000bR$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/search/guildsearch/activation/delegate/b;", "T", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "data", "", "position", "", "", "payload", "", "onBindData", "(Ljava/lang/Object;ILjava/util/List;)V", "Lcom/tencent/mobileqq/search/guildsearch/parts/GuildSearchActivationPart$e;", "d", "Lcom/tencent/mobileqq/search/guildsearch/parts/GuildSearchActivationPart$e;", "p", "()Lcom/tencent/mobileqq/search/guildsearch/parts/GuildSearchActivationPart$e;", "setListControllerIoc", "(Lcom/tencent/mobileqq/search/guildsearch/parts/GuildSearchActivationPart$e;)V", "listControllerIoc", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public abstract class b<T> extends Section<T> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildSearchActivationPart.e listControllerIoc;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onBindData(T data, int position, @Nullable List<Object> payload) {
        if (this.listControllerIoc == null) {
            this.listControllerIoc = (GuildSearchActivationPart.e) SectionIOCKt.getIocInterface(this, GuildSearchActivationPart.e.class);
        }
    }

    @Nullable
    /* renamed from: p, reason: from getter */
    public final GuildSearchActivationPart.e getListControllerIoc() {
        return this.listControllerIoc;
    }
}
