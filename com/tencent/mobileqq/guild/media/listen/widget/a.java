package com.tencent.mobileqq.guild.media.listen.widget;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\b\u00a2\u0006\u0004\b\u0010\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/media/listen/widget/a;", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "", "a", UserInfo.SEX_FEMALE, "getRadius", "()F", "setRadius", "(F)V", "radius", "<init>", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
final class a extends ViewOutlineProvider {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private float radius;

    public a(float f16) {
        this.radius = f16;
    }

    @Override // android.view.ViewOutlineProvider
    public void getOutline(@NotNull View view, @NotNull Outline outline) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(outline, "outline");
        outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), QQGuildUIUtil.f(this.radius));
    }
}
