package com.tencent.mobileqq.guild.quiprofile;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.richframework.layoutinflater.LayoutInflateDelegate;
import com.tencent.mobileqq.guild.util.s;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/quiprofile/f;", "Lcom/tencent/biz/richframework/layoutinflater/LayoutInflateDelegate;", "Lorg/xmlpull/v1/XmlPullParser;", "parser", "Landroid/view/ViewGroup;", "root", "", "attachToRoot", "Landroid/view/View;", "view", "", "afterInflate", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class f implements LayoutInflateDelegate {
    @Override // com.tencent.biz.richframework.layoutinflater.LayoutInflateDelegate
    public void afterInflate(@NotNull XmlPullParser parser, @Nullable ViewGroup root, boolean attachToRoot, @NotNull View view) {
        Intrinsics.checkNotNullParameter(parser, "parser");
        Intrinsics.checkNotNullParameter(view, "view");
        if (!(view.getResources() instanceof c)) {
            if (!(view.getContext() instanceof GuildActivityWrapper)) {
                s.e("Guild.GuildActivityWrapper", "View\u5173\u8054\u7684context\u5fc5\u987b\u662fGuildActivityWrapper", new RuntimeException());
            }
            s.e("Guild.GuildActivityWrapper", "View\u5173\u8054\u7684Resources\u5fc5\u987b\u662fGuildQUIProfileResources", new RuntimeException());
        }
        mw1.a.e(mw1.a.f417705a, view, false, 2, null);
    }
}
