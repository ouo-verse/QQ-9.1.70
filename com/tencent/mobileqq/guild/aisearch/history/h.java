package com.tencent.mobileqq.guild.aisearch.history;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.guild.aisearch.history.itemholder.AIChatHistorySessionHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0001\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\tH&J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u000e\u001a\u00020\tH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/history/h;", "", "Lcom/tencent/mobileqq/guild/aisearch/history/itemholder/AIChatHistorySessionHolder;", "holder", "", "e", "Lcom/tencent/mobileqq/guild/aisearch/history/f;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "f", "", "d", "isChecked", "c", "b", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public interface h {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/history/h$a;", "", "<init>", "()V", "a", "Lcom/tencent/mobileqq/guild/aisearch/history/h$a$a;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static abstract class a {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/history/h$a$a;", "Lcom/tencent/mobileqq/guild/aisearch/history/h$a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Z", "()Z", "isSelectMode", "<init>", "(Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.aisearch.history.h$a$a, reason: collision with other inner class name and from toString */
        /* loaded from: classes12.dex */
        public static final /* data */ class UpdateSelectMode extends a {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
            private final boolean isSelectMode;

            public UpdateSelectMode(boolean z16) {
                super(null);
                this.isSelectMode = z16;
            }

            /* renamed from: a, reason: from getter */
            public final boolean getIsSelectMode() {
                return this.isSelectMode;
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if ((other instanceof UpdateSelectMode) && this.isSelectMode == ((UpdateSelectMode) other).isSelectMode) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                boolean z16 = this.isSelectMode;
                if (z16) {
                    return 1;
                }
                return z16 ? 1 : 0;
            }

            @NotNull
            public String toString() {
                return "UpdateSelectMode(isSelectMode=" + this.isSelectMode + ")";
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    boolean a();

    boolean b(@NotNull AIChatHistorySessionHolder holder);

    void c(@NotNull AIChatHistorySessionHolder holder, boolean isChecked);

    boolean d(@NotNull AIChatHistorySessionHolder holder);

    void e(@NotNull AIChatHistorySessionHolder holder);

    void f(@NotNull AIChatHistorySessionItem item);
}
