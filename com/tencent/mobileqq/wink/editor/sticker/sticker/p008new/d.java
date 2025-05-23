package com.tencent.mobileqq.wink.editor.sticker.sticker.p008new;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\b\u0004\u0005\u0006\u0007\b\t\n\u000bB\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/d;", "", "<init>", "()V", "a", "b", "c", "d", "e", "f", "g", h.F, "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/d$a;", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/d$b;", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/d$c;", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/d$d;", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/d$e;", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/d$f;", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/d$g;", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/d$h;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public abstract class d {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/d$a;", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/d;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a extends d {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f321865a = new a();

        a() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\n\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/d$b;", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/d;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "b", "()I", "topTabIndex", "itemPosition", "<init>", "(II)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.sticker.sticker.new.d$b, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class ScrollContent extends d {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int topTabIndex;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int itemPosition;

        public ScrollContent(int i3, int i16) {
            super(null);
            this.topTabIndex = i3;
            this.itemPosition = i16;
        }

        /* renamed from: a, reason: from getter */
        public final int getItemPosition() {
            return this.itemPosition;
        }

        /* renamed from: b, reason: from getter */
        public final int getTopTabIndex() {
            return this.topTabIndex;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ScrollContent)) {
                return false;
            }
            ScrollContent scrollContent = (ScrollContent) other;
            if (this.topTabIndex == scrollContent.topTabIndex && this.itemPosition == scrollContent.itemPosition) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.topTabIndex * 31) + this.itemPosition;
        }

        @NotNull
        public String toString() {
            return "ScrollContent(topTabIndex=" + this.topTabIndex + ", itemPosition=" + this.itemPosition + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\n\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/d$c;", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/d;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "b", "()I", "topTabIndex", "index", "<init>", "(II)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.sticker.sticker.new.d$c, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class ScrollSelectBottomTab extends d {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int topTabIndex;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int index;

        public ScrollSelectBottomTab(int i3, int i16) {
            super(null);
            this.topTabIndex = i3;
            this.index = i16;
        }

        /* renamed from: a, reason: from getter */
        public final int getIndex() {
            return this.index;
        }

        /* renamed from: b, reason: from getter */
        public final int getTopTabIndex() {
            return this.topTabIndex;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ScrollSelectBottomTab)) {
                return false;
            }
            ScrollSelectBottomTab scrollSelectBottomTab = (ScrollSelectBottomTab) other;
            if (this.topTabIndex == scrollSelectBottomTab.topTabIndex && this.index == scrollSelectBottomTab.index) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.topTabIndex * 31) + this.index;
        }

        @NotNull
        public String toString() {
            return "ScrollSelectBottomTab(topTabIndex=" + this.topTabIndex + ", index=" + this.index + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/d$d;", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/d;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.sticker.sticker.new.d$d, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public static final class C9037d extends d {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final C9037d f321870a = new C9037d();

        C9037d() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/d$e;", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/d;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class e extends d {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final e f321871a = new e();

        e() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/d$f;", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/d;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class f extends d {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final f f321872a = new f();

        f() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\n\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/d$g;", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/d;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Z", "b", "()Z", "open", "anim", "<init>", "(ZZ)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.sticker.sticker.new.d$g, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class SearchToggle extends d {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean open;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean anim;

        public SearchToggle(boolean z16, boolean z17) {
            super(null);
            this.open = z16;
            this.anim = z17;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getAnim() {
            return this.anim;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getOpen() {
            return this.open;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SearchToggle)) {
                return false;
            }
            SearchToggle searchToggle = (SearchToggle) other;
            if (this.open == searchToggle.open && this.anim == searchToggle.anim) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z16 = this.open;
            int i3 = 1;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i16 = r06 * 31;
            boolean z17 = this.anim;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            return "SearchToggle(open=" + this.open + ", anim=" + this.anim + ")";
        }

        public /* synthetic */ SearchToggle(boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(z16, (i3 & 2) != 0 ? true : z17);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\n\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/d$h;", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/d;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "a", "Ljava/util/List;", "()Ljava/util/List;", "selectStatus", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "b", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "selectedCate", "<init>", "(Ljava/util/List;Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.sticker.sticker.new.d$h, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class TopTabSelect extends d {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final List<Boolean> selectStatus;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final MetaCategory selectedCate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TopTabSelect(@NotNull List<Boolean> selectStatus, @Nullable MetaCategory metaCategory) {
            super(null);
            Intrinsics.checkNotNullParameter(selectStatus, "selectStatus");
            this.selectStatus = selectStatus;
            this.selectedCate = metaCategory;
        }

        @NotNull
        public final List<Boolean> a() {
            return this.selectStatus;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final MetaCategory getSelectedCate() {
            return this.selectedCate;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TopTabSelect)) {
                return false;
            }
            TopTabSelect topTabSelect = (TopTabSelect) other;
            if (Intrinsics.areEqual(this.selectStatus, topTabSelect.selectStatus) && Intrinsics.areEqual(this.selectedCate, topTabSelect.selectedCate)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = this.selectStatus.hashCode() * 31;
            MetaCategory metaCategory = this.selectedCate;
            if (metaCategory == null) {
                hashCode = 0;
            } else {
                hashCode = metaCategory.hashCode();
            }
            return hashCode2 + hashCode;
        }

        @NotNull
        public String toString() {
            return "TopTabSelect(selectStatus=" + this.selectStatus + ", selectedCate=" + this.selectedCate + ")";
        }
    }

    public /* synthetic */ d(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    d() {
    }
}
