package com.tencent.robot.write.vb.delegate;

import android.view.View;
import e74.RequireData;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\n"}, d2 = {"Lcom/tencent/robot/write/vb/delegate/a;", "Lol3/b;", "<init>", "()V", "a", "b", "c", "d", "e", "f", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public class a implements ol3.b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/robot/write/vb/delegate/a$a;", "Lcom/tencent/robot/write/vb/delegate/a;", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.write.vb.delegate.a$a, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static final class C9788a extends a {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final C9788a f368749d = new C9788a();

        C9788a() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u0012\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/robot/write/vb/delegate/a$b;", "Lcom/tencent/robot/write/vb/delegate/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Landroid/view/View;", "d", "Landroid/view/View;", "a", "()Landroid/view/View;", "b", "(Landroid/view/View;)V", "anchorView", "<init>", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.write.vb.delegate.a$b, reason: from toString */
    /* loaded from: classes25.dex */
    public static final /* data */ class GetAnchorViewIntent extends a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private View anchorView;

        public GetAnchorViewIntent() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final View getAnchorView() {
            return this.anchorView;
        }

        public final void b(@Nullable View view) {
            this.anchorView = view;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof GetAnchorViewIntent) && Intrinsics.areEqual(this.anchorView, ((GetAnchorViewIntent) other).anchorView)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            View view = this.anchorView;
            if (view == null) {
                return 0;
            }
            return view.hashCode();
        }

        @NotNull
        public String toString() {
            return "GetAnchorViewIntent(anchorView=" + this.anchorView + ")";
        }

        public GetAnchorViewIntent(@Nullable View view) {
            this.anchorView = view;
        }

        public /* synthetic */ GetAnchorViewIntent(View view, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : view);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/robot/write/vb/delegate/a$c;", "Lcom/tencent/robot/write/vb/delegate/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Le74/c;", "d", "Le74/c;", "b", "()Le74/c;", "requireData", "e", "I", "a", "()I", "position", "<init>", "(Le74/c;I)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.write.vb.delegate.a$c, reason: from toString */
    /* loaded from: classes25.dex */
    public static final /* data */ class OnRequireListItemSelected extends a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final RequireData requireData;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final int position;

        public OnRequireListItemSelected(@NotNull RequireData requireData, int i3) {
            Intrinsics.checkNotNullParameter(requireData, "requireData");
            this.requireData = requireData;
            this.position = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getPosition() {
            return this.position;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final RequireData getRequireData() {
            return this.requireData;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnRequireListItemSelected)) {
                return false;
            }
            OnRequireListItemSelected onRequireListItemSelected = (OnRequireListItemSelected) other;
            if (Intrinsics.areEqual(this.requireData, onRequireListItemSelected.requireData) && this.position == onRequireListItemSelected.position) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.requireData.hashCode() * 31) + this.position;
        }

        @NotNull
        public String toString() {
            return "OnRequireListItemSelected(requireData=" + this.requireData + ", position=" + this.position + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/robot/write/vb/delegate/a$d;", "Lcom/tencent/robot/write/vb/delegate/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "a", "()I", "position", "<init>", "(I)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.write.vb.delegate.a$d, reason: from toString */
    /* loaded from: classes25.dex */
    public static final /* data */ class OnRequireListItemUnSelected extends a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int position;

        public OnRequireListItemUnSelected(int i3) {
            this.position = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getPosition() {
            return this.position;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof OnRequireListItemUnSelected) && this.position == ((OnRequireListItemUnSelected) other).position) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.position;
        }

        @NotNull
        public String toString() {
            return "OnRequireListItemUnSelected(position=" + this.position + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0018\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\u000b0\n\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R)\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/robot/write/vb/delegate/a$e;", "Lcom/tencent/robot/write/vb/delegate/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "Lkotlin/Pair;", "Le74/c;", "d", "Ljava/util/List;", "a", "()Ljava/util/List;", "selectedList", "<init>", "(Ljava/util/List;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.write.vb.delegate.a$e, reason: from toString */
    /* loaded from: classes25.dex */
    public static final /* data */ class OnRequireListItemsSelected extends a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final List<Pair<Integer, RequireData>> selectedList;

        public OnRequireListItemsSelected(@NotNull List<Pair<Integer, RequireData>> selectedList) {
            Intrinsics.checkNotNullParameter(selectedList, "selectedList");
            this.selectedList = selectedList;
        }

        @NotNull
        public final List<Pair<Integer, RequireData>> a() {
            return this.selectedList;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof OnRequireListItemsSelected) && Intrinsics.areEqual(this.selectedList, ((OnRequireListItemsSelected) other).selectedList)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.selectedList.hashCode();
        }

        @NotNull
        public String toString() {
            return "OnRequireListItemsSelected(selectedList=" + this.selectedList + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012&\u0010\u0018\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0012j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0013\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR7\u0010\u0018\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0012j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/robot/write/vb/delegate/a$f;", "Lcom/tencent/robot/write/vb/delegate/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "template", "e", "b", "placeholder", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "f", "Ljava/util/HashMap;", "a", "()Ljava/util/HashMap;", "data", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.write.vb.delegate.a$f, reason: from toString */
    /* loaded from: classes25.dex */
    public static final /* data */ class OnTypeListItemClick extends a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String template;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String placeholder;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final HashMap<String, String> data;

        public OnTypeListItemClick(@Nullable String str, @Nullable String str2, @Nullable HashMap<String, String> hashMap) {
            this.template = str;
            this.placeholder = str2;
            this.data = hashMap;
        }

        @Nullable
        public final HashMap<String, String> a() {
            return this.data;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final String getPlaceholder() {
            return this.placeholder;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final String getTemplate() {
            return this.template;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnTypeListItemClick)) {
                return false;
            }
            OnTypeListItemClick onTypeListItemClick = (OnTypeListItemClick) other;
            if (Intrinsics.areEqual(this.template, onTypeListItemClick.template) && Intrinsics.areEqual(this.placeholder, onTypeListItemClick.placeholder) && Intrinsics.areEqual(this.data, onTypeListItemClick.data)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            String str = this.template;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode * 31;
            String str2 = this.placeholder;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            HashMap<String, String> hashMap = this.data;
            if (hashMap != null) {
                i3 = hashMap.hashCode();
            }
            return i17 + i3;
        }

        @NotNull
        public String toString() {
            return "OnTypeListItemClick(template=" + this.template + ", placeholder=" + this.placeholder + ", data=" + this.data + ")";
        }
    }
}
