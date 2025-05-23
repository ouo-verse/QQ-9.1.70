package com.tencent.guild.aio.factory.business.holder.msglist;

import android.graphics.Rect;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0007\u000b\f\r\u000e\u000f\u0010\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/i;", "Lcom/tencent/mvi/base/route/k;", "<init>", "()V", "a", "b", "c", "d", "e", "f", "g", "Lcom/tencent/guild/aio/factory/business/holder/msglist/i$a;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/i$b;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/i$c;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/i$d;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/i$e;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/i$f;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/i$g;", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public abstract class i implements com.tencent.mvi.base.route.k {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/i$a;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/i;", "Lcom/tencent/aio/data/msglist/a;", "a", "Lcom/tencent/aio/data/msglist/a;", "()Lcom/tencent/aio/data/msglist/a;", "result", "<init>", "(Lcom/tencent/aio/data/msglist/a;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a extends i {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final com.tencent.aio.data.msglist.a result;

        public a(@Nullable com.tencent.aio.data.msglist.a aVar) {
            super(null);
            this.result = aVar;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final com.tencent.aio.data.msglist.a getResult() {
            return this.result;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\b\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/i$b;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/i;", "Lcom/tencent/aio/data/msglist/a;", "a", "Lcom/tencent/aio/data/msglist/a;", "c", "()Lcom/tencent/aio/data/msglist/a;", "topMsg", "b", "bottomMsg", "latestAIOMsg", "<init>", "(Lcom/tencent/aio/data/msglist/a;Lcom/tencent/aio/data/msglist/a;Lcom/tencent/aio/data/msglist/a;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b extends i {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final com.tencent.aio.data.msglist.a topMsg;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final com.tencent.aio.data.msglist.a bottomMsg;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final com.tencent.aio.data.msglist.a latestAIOMsg;

        public b(@Nullable com.tencent.aio.data.msglist.a aVar, @Nullable com.tencent.aio.data.msglist.a aVar2, @Nullable com.tencent.aio.data.msglist.a aVar3) {
            super(null);
            this.topMsg = aVar;
            this.bottomMsg = aVar2;
            this.latestAIOMsg = aVar3;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final com.tencent.aio.data.msglist.a getBottomMsg() {
            return this.bottomMsg;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final com.tencent.aio.data.msglist.a getLatestAIOMsg() {
            return this.latestAIOMsg;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final com.tencent.aio.data.msglist.a getTopMsg() {
            return this.topMsg;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u001f\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/i$c;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/i;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "a", "Ljava/util/List;", "()Ljava/util/List;", "result", "<init>", "(Ljava/util/List;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c extends i {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final List<MsgRecord> result;

        public c(@Nullable List<MsgRecord> list) {
            super(null);
            this.result = list;
        }

        @Nullable
        public final List<MsgRecord> a() {
            return this.result;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/i$d;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/i;", "Lcom/tencent/aio/data/msglist/a;", "a", "Lcom/tencent/aio/data/msglist/a;", "()Lcom/tencent/aio/data/msglist/a;", "result", "<init>", "(Lcom/tencent/aio/data/msglist/a;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class d extends i {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final com.tencent.aio.data.msglist.a result;

        public d(@Nullable com.tencent.aio.data.msglist.a aVar) {
            super(null);
            this.result = aVar;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final com.tencent.aio.data.msglist.a getResult() {
            return this.result;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/i$e;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/i;", "", "a", "Z", "()Z", "result", "<init>", "(Z)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class e extends i {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final boolean result;

        public e(boolean z16) {
            super(null);
            this.result = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getResult() {
            return this.result;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/i$f;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/i;", "Landroid/graphics/Rect;", "a", "Landroid/graphics/Rect;", "getRect", "()Landroid/graphics/Rect;", CanvasView.ACTION_RECT, "<init>", "(Landroid/graphics/Rect;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class f extends i {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Rect rect;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(@NotNull Rect rect) {
            super(null);
            Intrinsics.checkNotNullParameter(rect, "rect");
            this.rect = rect;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/i$g;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/i;", "", "a", "Z", "b", "()Z", "isShowing", "isMsgListEmpty", "<init>", "(ZZ)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class g extends i {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final boolean isShowing;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final boolean isMsgListEmpty;

        public g(boolean z16, boolean z17) {
            super(null);
            this.isShowing = z16;
            this.isMsgListEmpty = z17;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getIsMsgListEmpty() {
            return this.isMsgListEmpty;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getIsShowing() {
            return this.isShowing;
        }
    }

    public /* synthetic */ i(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    i() {
    }
}
