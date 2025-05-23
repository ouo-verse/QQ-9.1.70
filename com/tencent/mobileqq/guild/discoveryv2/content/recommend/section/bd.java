package com.tencent.mobileqq.guild.discoveryv2.content.recommend.section;

import android.view.View;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J,\u0010\u000e\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0010\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\fH\u0014J\b\u0010\u000f\u001a\u00020\u0007H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/bd;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/av;", "", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "payload", "onBindData", "onThemeChanged", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class bd extends av<Object> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    @Override // com.tencent.mobileqq.guild.theme.d
    public void onThemeChanged() {
        if (getRootView() != null && !getRootView().isAttachedToWindow()) {
            com.tencent.mobileqq.guild.theme.c.a(getRootView());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onBindData(@Nullable Object data, int position, @Nullable List<? extends Object> payload) {
    }
}
