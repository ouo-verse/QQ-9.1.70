package com.tencent.mobileqq.guild.feed.feedsquare.section;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSysPromptDigest;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J*\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0014J*\u0010\u000b\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016J\b\u0010\r\u001a\u00020\fH\u0014J\u0012\u0010\u0010\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/o;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedBaseSection;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/h;", "data", "", "position", "", "", "payload", "", "L", "M", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "e", "Landroid/view/View;", "divider", "<init>", "()V", "f", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class o extends GuildFeedSquareFeedBaseSection {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View divider;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedBaseSection, com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: L */
    public void onBindData(@Nullable com.tencent.mobileqq.guild.feed.feedsquare.data.h data, int position, @Nullable List<Object> payload) {
        ij1.g blockData;
        super.onBindData(data, position, payload);
        if (data != null && (blockData = data.getBlockData()) != null) {
            Object d16 = blockData.d(blockData.m());
            if (blockData.q() && (d16 instanceof GProSysPromptDigest)) {
                View view = this.divider;
                if (view != null) {
                    view.setVisibility(8);
                }
                QLog.d("GuildFeedSquareDividerSection", 1, " isNextSystemPrompt set divider gone");
                return;
            }
            View view2 = this.divider;
            if (view2 != null) {
                view2.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.f165493wa3};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        View view;
        if (containerView != null) {
            view = containerView.findViewById(R.id.bmt);
        } else {
            view = null;
        }
        this.divider = view;
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedBaseSection
    public void M(@Nullable com.tencent.mobileqq.guild.feed.feedsquare.data.h data, int position, @Nullable List<Object> payload) {
    }
}
