package com.tencent.mobileqq.guild.base.recyclerview.loadmore;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.guild.base.recyclerview.viewholder.BaseViewHolder;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0014\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH&J \u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/base/recyclerview/loadmore/a;", "", "Landroid/view/View;", "", NodeProps.VISIBLE, "", "g", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "f", "Lcom/tencent/mobileqq/guild/base/recyclerview/viewholder/BaseViewHolder;", "holder", "e", "b", "c", "d", "", "position", "Lcom/tencent/mobileqq/guild/base/recyclerview/loadmore/LoadMoreStatus;", "loadMoreStatus", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public abstract class a {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.guild.base.recyclerview.loadmore.a$a, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public /* synthetic */ class C7678a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f214782a;

        static {
            int[] iArr = new int[LoadMoreStatus.values().length];
            try {
                iArr[LoadMoreStatus.Complete.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoadMoreStatus.Loading.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LoadMoreStatus.Fail.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LoadMoreStatus.End.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f214782a = iArr;
        }
    }

    private final void g(View view, boolean z16) {
        int i3;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
    }

    public void a(@NotNull BaseViewHolder holder, int position, @NotNull LoadMoreStatus loadMoreStatus) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(loadMoreStatus, "loadMoreStatus");
        int i3 = C7678a.f214782a[loadMoreStatus.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        g(e(holder), false);
                        g(b(holder), false);
                        g(d(holder), false);
                        g(c(holder), true);
                        return;
                    }
                    return;
                }
                g(e(holder), false);
                g(b(holder), false);
                g(d(holder), true);
                g(c(holder), false);
                return;
            }
            g(e(holder), true);
            g(b(holder), false);
            g(d(holder), false);
            g(c(holder), false);
            return;
        }
        g(e(holder), false);
        g(b(holder), true);
        g(d(holder), false);
        g(c(holder), false);
    }

    @NotNull
    public abstract View b(@NotNull BaseViewHolder holder);

    @NotNull
    public abstract View c(@NotNull BaseViewHolder holder);

    @NotNull
    public abstract View d(@NotNull BaseViewHolder holder);

    @NotNull
    public abstract View e(@NotNull BaseViewHolder holder);

    @NotNull
    public abstract View f(@NotNull ViewGroup parent);
}
