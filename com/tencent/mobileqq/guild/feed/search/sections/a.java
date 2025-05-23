package com.tencent.mobileqq.guild.feed.search.sections;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J*\u0010\u000f\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/search/sections/a;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lpn1/a;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", "p", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "d", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "avatarImageView", "e", "Landroid/view/View;", "avatarFrame", "<init>", "()V", "f", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a extends Section<pn1.a> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private GuildUserAvatarView avatarImageView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View avatarFrame;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.w9v};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.t1j);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.avatar_image_view)");
        this.avatarImageView = (GuildUserAvatarView) findViewById;
        View findViewById2 = containerView.findViewById(R.id.t1e);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewById(R.id.avatar_frame)");
        this.avatarFrame = findViewById2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable pn1.a data, int position, @Nullable List<Object> payload) {
        qj1.h d16;
        String u16;
        View view = null;
        if (data != null && (d16 = data.d()) != null && (u16 = d16.u()) != null) {
            GuildUserAvatarView guildUserAvatarView = this.avatarImageView;
            if (guildUserAvatarView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarImageView");
                guildUserAvatarView = null;
            }
            guildUserAvatarView.setUrl(u16);
        }
        View view2 = this.avatarFrame;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarFrame");
            view2 = null;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        int a16 = bi.a(0.5f);
        View view3 = this.avatarFrame;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarFrame");
        } else {
            view = view3;
        }
        gradientDrawable.setStroke(a16, view.getResources().getColorStateList(R.color.qui_common_border_standard));
        view2.setBackground(gradientDrawable);
    }
}
