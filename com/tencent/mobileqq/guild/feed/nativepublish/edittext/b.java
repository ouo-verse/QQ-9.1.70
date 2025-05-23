package com.tencent.mobileqq.guild.feed.nativepublish.edittext;

import android.text.Editable;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/b;", "Lol3/b;", "<init>", "()V", "a", "b", "c", "d", "e", "f", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class b implements ol3.b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/b$a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/b;", "", "d", "Z", "a", "()Z", "blockTextDetectFlag", "<init>", "(Z)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a extends b {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean blockTextDetectFlag;

        public a(boolean z16) {
            this.blockTextDetectFlag = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getBlockTextDetectFlag() {
            return this.blockTextDetectFlag;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/b$b;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/b;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.nativepublish.edittext.b$b, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static final class C7765b extends b {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final C7765b f221901d = new C7765b();

        C7765b() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/b$c;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/b;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c extends b {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/b$d;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/b;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d extends b {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/b$e;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/b;", "", "d", "I", "a", "()I", "direction", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class e extends b {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int direction;

        /* renamed from: a, reason: from getter */
        public final int getDirection() {
            return this.direction;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\n\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/b$f;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "Landroid/text/Editable;", "d", "Landroid/text/Editable;", "a", "()Landroid/text/Editable;", "b", "(Landroid/text/Editable;)V", ReportConstant.COSTREPORT_PREFIX, "e", "I", "getSelection", "()I", "c", "(I)V", "selection", "<init>", "(Landroid/text/Editable;I)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.nativepublish.edittext.b$f, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class TextChangedIntent extends b {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private Editable s;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private int selection;

        public TextChangedIntent(@NotNull Editable s16, int i3) {
            Intrinsics.checkNotNullParameter(s16, "s");
            this.s = s16;
            this.selection = i3;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final Editable getS() {
            return this.s;
        }

        public final void b(@NotNull Editable editable) {
            Intrinsics.checkNotNullParameter(editable, "<set-?>");
            this.s = editable;
        }

        public final void c(int i3) {
            this.selection = i3;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TextChangedIntent)) {
                return false;
            }
            TextChangedIntent textChangedIntent = (TextChangedIntent) other;
            if (Intrinsics.areEqual(this.s, textChangedIntent.s) && this.selection == textChangedIntent.selection) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.s.hashCode() * 31) + this.selection;
        }

        @NotNull
        public String toString() {
            Editable editable = this.s;
            return "TextChangedIntent(s=" + ((Object) editable) + ", selection=" + this.selection + ")";
        }
    }
}
