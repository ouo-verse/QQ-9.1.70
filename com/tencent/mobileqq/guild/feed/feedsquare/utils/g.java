package com.tencent.mobileqq.guild.feed.feedsquare.utils;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewHelper;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0000H\u0002\"\u001a\u0010\t\u001a\u00020\u00058\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b\u00a8\u0006\n"}, d2 = {"Landroid/view/View;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/AbsGuildFeedMediaSizeUtils;", "b", "", "c", "", "a", "I", "()I", "MEDIA_SIZE_UTIL_TAG", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private static final int f219334a = -682200256;

    public static final int a() {
        return f219334a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [com.tencent.mobileqq.guild.feed.feedsquare.utils.AbsGuildFeedMediaSizeUtils] */
    @NotNull
    public static final AbsGuildFeedMediaSizeUtils b(@NotNull View view) {
        int i3;
        GuildFeedMediaSizeUtils guildFeedMediaSizeUtils;
        Object obj;
        View view2;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Object tag = view.getTag(f219334a);
        if (tag instanceof AbsGuildFeedMediaSizeUtils) {
            return (AbsGuildFeedMediaSizeUtils) tag;
        }
        int i16 = 0;
        View view3 = view;
        while (true) {
            i3 = i16 + 1;
            guildFeedMediaSizeUtils = null;
            if (i16 >= 5 || !c(view3) || view3.getParent() == null) {
                break;
            }
            Object parent = view3.getParent();
            if (parent instanceof View) {
                view2 = (View) parent;
            } else {
                view2 = null;
            }
            if (view2 == null) {
                break;
            }
            view3 = view2;
            i16 = i3;
        }
        if (view3.getLayoutParams() instanceof RecyclerView.LayoutParams) {
            RecyclerView ownerRecyclerView = RecyclerViewHelper.INSTANCE.getOwnerRecyclerView(view3);
            if (ownerRecyclerView != null) {
                obj = ownerRecyclerView.getTag(f219334a);
            } else {
                obj = null;
            }
            if (obj instanceof AbsGuildFeedMediaSizeUtils) {
                guildFeedMediaSizeUtils = (AbsGuildFeedMediaSizeUtils) obj;
            }
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildFeedMediaSizeUtils", 1, "find rv item view: " + b12.b.b(view3) + " from " + b12.b.b(view) + ", result = " + guildFeedMediaSizeUtils + ", i = " + i3);
            }
        }
        if (guildFeedMediaSizeUtils == null) {
            guildFeedMediaSizeUtils = GuildFeedMediaSizeUtils.f219296d;
        }
        view3.setTag(f219334a, guildFeedMediaSizeUtils);
        return guildFeedMediaSizeUtils;
    }

    private static final boolean c(View view) {
        if (view.getLayoutParams() != null && !(view.getLayoutParams() instanceof RecyclerView.LayoutParams)) {
            return true;
        }
        return false;
    }
}
