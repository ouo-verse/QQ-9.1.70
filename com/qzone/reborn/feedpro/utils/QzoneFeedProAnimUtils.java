package com.qzone.reborn.feedpro.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import com.qzone.reborn.feedpro.itemview.QzoneBaseFeedProItemView;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWConfig;
import com.tencent.mobileqq.guild.feed.api.AnimationParams;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\n\u001a\u00020\tJ\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\u0012"}, d2 = {"Lcom/qzone/reborn/feedpro/utils/QzoneFeedProAnimUtils;", "", "Landroid/view/View;", "animView", "Lcom/tencent/mobileqq/guild/feed/api/AnimationParams;", "c", "clickView", "Lcom/qzone/reborn/feedpro/itemview/QzoneBaseFeedProItemView;", "b", "", "d", "Landroid/content/Context;", "context", "animParam", "", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFeedProAnimUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final QzoneFeedProAnimUtils f54254a = new QzoneFeedProAnimUtils();

    QzoneFeedProAnimUtils() {
    }

    public final String a(Context context, AnimationParams animParam) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (d() && (context instanceof Activity) && animParam != null) {
            return "/qzone/holder_page_transparent";
        }
        return "/qzone/holder_page";
    }

    public final AnimationParams c(View animView) {
        Intrinsics.checkNotNullParameter(animView, "animView");
        animView.getLocationInWindow(new int[2]);
        return new AnimationParams(r0[0], r0[1], animView.getWidth(), animView.getHeight(), animView.getHeight());
    }

    public final boolean d() {
        if (RFWApplication.isPublicVersion()) {
            RFWConfig.getConfigValue("QZONE_DETAIL_PAGE_ANIM", false);
        }
        return false;
    }

    public final QzoneBaseFeedProItemView b(View clickView) {
        Sequence generateSequence;
        Sequence filter;
        Object firstOrNull;
        if (clickView == null) {
            return null;
        }
        if (!(clickView instanceof QzoneBaseFeedProItemView)) {
            generateSequence = SequencesKt__SequencesKt.generateSequence(clickView.getParent(), (Function1<? super ViewParent, ? extends ViewParent>) ((Function1<? super Object, ? extends Object>) new Function1<ViewParent, ViewParent>() { // from class: com.qzone.reborn.feedpro.utils.QzoneFeedProAnimUtils$findParentFeedItemView$feedItemView$1
                @Override // kotlin.jvm.functions.Function1
                public final ViewParent invoke(ViewParent it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it.getParent();
                }
            }));
            filter = SequencesKt___SequencesKt.filter(generateSequence, new Function1<Object, Boolean>() { // from class: com.qzone.reborn.feedpro.utils.QzoneFeedProAnimUtils$findParentFeedItemView$$inlined$filterIsInstance$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(Object obj) {
                    return Boolean.valueOf(obj instanceof QzoneBaseFeedProItemView);
                }
            });
            Intrinsics.checkNotNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
            firstOrNull = SequencesKt___SequencesKt.firstOrNull(filter);
            return (QzoneBaseFeedProItemView) firstOrNull;
        }
        return (QzoneBaseFeedProItemView) clickView;
    }
}
