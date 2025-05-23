package com.tencent.robot.discoveryv2.common.search;

import android.content.Context;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/robot/discoveryv2/common/search/c;", "Lcom/tencent/robot/discoveryv2/common/core/viewmodel/a;", "<init>", "()V", "a", "Lcom/tencent/robot/discoveryv2/common/search/c$a;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class c implements com.tencent.robot.discoveryv2.common.core.viewmodel.a {

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/robot/discoveryv2/common/search/c$a;", "Lcom/tencent/robot/discoveryv2/common/search/c;", "", "toString", "", "hashCode", "", "other", "", "equals", "Landroid/content/Context;", "a", "Landroid/content/Context;", "()Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "b", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "()Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "fragment", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.discoveryv2.common.search.c$a, reason: from toString */
    /* loaded from: classes25.dex */
    public static final /* data */ class OnSearchBarClick extends c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Context context;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final QIphoneTitleBarFragment fragment;

        public OnSearchBarClick(@Nullable Context context, @Nullable QIphoneTitleBarFragment qIphoneTitleBarFragment) {
            super(null);
            this.context = context;
            this.fragment = qIphoneTitleBarFragment;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final Context getContext() {
            return this.context;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final QIphoneTitleBarFragment getFragment() {
            return this.fragment;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnSearchBarClick)) {
                return false;
            }
            OnSearchBarClick onSearchBarClick = (OnSearchBarClick) other;
            if (Intrinsics.areEqual(this.context, onSearchBarClick.context) && Intrinsics.areEqual(this.fragment, onSearchBarClick.fragment)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            Context context = this.context;
            int i3 = 0;
            if (context == null) {
                hashCode = 0;
            } else {
                hashCode = context.hashCode();
            }
            int i16 = hashCode * 31;
            QIphoneTitleBarFragment qIphoneTitleBarFragment = this.fragment;
            if (qIphoneTitleBarFragment != null) {
                i3 = qIphoneTitleBarFragment.hashCode();
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            return "OnSearchBarClick(context=" + this.context + ", fragment=" + this.fragment + ")";
        }
    }

    public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    c() {
    }
}
