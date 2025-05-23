package com.tencent.guild.aio.factory.business.holder.msglist;

import android.content.Context;
import android.view.View;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0017\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001aB\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0017\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./01\u00a8\u00062"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/a;", "Lat/b;", "<init>", "()V", "a", "b", "c", "d", "e", "f", "g", tl.h.F, "i", "j", "k", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "o", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", ReportConstant.COSTREPORT_PREFIX, "t", "u", "v", "w", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a$a;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a$b;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a$c;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a$d;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a$e;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a$f;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a$g;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a$h;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a$i;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a$j;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a$k;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a$l;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a$m;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a$n;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a$o;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a$p;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a$q;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a$r;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a$s;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a$t;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a$u;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a$v;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a$w;", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public abstract class a implements at.b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/a$a;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a;", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.factory.business.holder.msglist.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1186a extends a {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final C1186a f110458d = new C1186a();

        C1186a() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/a$b;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a;", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b extends a {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final b f110459d = new b();

        b() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/a$c;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a;", "Landroid/view/View;", "d", "Landroid/view/View;", "a", "()Landroid/view/View;", "bubbleView", "<init>", "(Landroid/view/View;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c extends a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final View bubbleView;

        public c() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final View getBubbleView() {
            return this.bubbleView;
        }

        public c(@Nullable View view) {
            super(null);
            this.bubbleView = view;
        }

        public /* synthetic */ c(View view, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : view);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/a$d;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a;", "Landroid/view/View;", "d", "Landroid/view/View;", "a", "()Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class d extends a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final View view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NotNull View view) {
            super(null);
            Intrinsics.checkNotNullParameter(view, "view");
            this.view = view;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final View getView() {
            return this.view;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u00a2\u0006\u0004\b\n\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/a$e;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a;", "", "d", "Z", "a", "()Z", "b", "(Z)V", "ret", "<init>", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class e extends a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean ret;

        public e() {
            this(false, 1, null);
        }

        /* renamed from: a, reason: from getter */
        public final boolean getRet() {
            return this.ret;
        }

        public final void b(boolean z16) {
            this.ret = z16;
        }

        public e(boolean z16) {
            super(null);
            this.ret = z16;
        }

        public /* synthetic */ e(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? false : z16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B \u0012\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u00a2\u0006\u0002\b\u0005\u00a2\u0006\u0004\b\u000b\u0010\fR(\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u00a2\u0006\u0002\b\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/a$f;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a;", "Lkotlin/Function1;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/scrollers/d;", "", "Lkotlin/ExtensionFunctionType;", "d", "Lkotlin/jvm/functions/Function1;", "a", "()Lkotlin/jvm/functions/Function1;", "job", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class f extends a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Function1<com.tencent.guild.aio.factory.business.holder.msglist.scrollers.d, Unit> job;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public f(@NotNull Function1<? super com.tencent.guild.aio.factory.business.holder.msglist.scrollers.d, Unit> job) {
            super(null);
            Intrinsics.checkNotNullParameter(job, "job");
            this.job = job;
        }

        @NotNull
        public final Function1<com.tencent.guild.aio.factory.business.holder.msglist.scrollers.d, Unit> a() {
            return this.job;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0005R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0005R$\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0018\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/a$g;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a;", "", "d", "I", "()I", HippyTKDListViewAdapter.SCROLL_STATE, "e", "a", "firstPosition", "f", "c", "lastPosition", "Lcom/tencent/aio/data/msglist/a;", tl.h.F, "Lcom/tencent/aio/data/msglist/a;", "b", "()Lcom/tencent/aio/data/msglist/a;", "setFirstVisibleMsg", "(Lcom/tencent/aio/data/msglist/a;)V", "firstVisibleMsg", "i", "getLastVisibleMsg", "setLastVisibleMsg", "lastVisibleMsg", "<init>", "(IIILcom/tencent/aio/data/msglist/a;Lcom/tencent/aio/data/msglist/a;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class g extends a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int scrollState;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int firstPosition;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final int lastPosition;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private com.tencent.aio.data.msglist.a firstVisibleMsg;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private com.tencent.aio.data.msglist.a lastVisibleMsg;

        public g(int i3, int i16, int i17, @Nullable com.tencent.aio.data.msglist.a aVar, @Nullable com.tencent.aio.data.msglist.a aVar2) {
            super(null);
            this.scrollState = i3;
            this.firstPosition = i16;
            this.lastPosition = i17;
            this.firstVisibleMsg = aVar;
            this.lastVisibleMsg = aVar2;
        }

        /* renamed from: a, reason: from getter */
        public final int getFirstPosition() {
            return this.firstPosition;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final com.tencent.aio.data.msglist.a getFirstVisibleMsg() {
            return this.firstVisibleMsg;
        }

        /* renamed from: c, reason: from getter */
        public final int getLastPosition() {
            return this.lastPosition;
        }

        /* renamed from: d, reason: from getter */
        public final int getScrollState() {
            return this.scrollState;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/a$h;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "d", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "a", "()Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "<init>", "(Lcom/tencent/guild/api/data/msglist/GuildMsgItem;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class h extends a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final GuildMsgItem msgItem;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(@NotNull GuildMsgItem msgItem) {
            super(null);
            Intrinsics.checkNotNullParameter(msgItem, "msgItem");
            this.msgItem = msgItem;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final GuildMsgItem getMsgItem() {
            return this.msgItem;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/a$i;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "d", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "a", "()Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "<init>", "(Lcom/tencent/guild/api/data/msglist/GuildMsgItem;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class i extends a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final GuildMsgItem msgItem;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(@NotNull GuildMsgItem msgItem) {
            super(null);
            Intrinsics.checkNotNullParameter(msgItem, "msgItem");
            this.msgItem = msgItem;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final GuildMsgItem getMsgItem() {
            return this.msgItem;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/a$j;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "b", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;", "c", "()Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;", "picElement", "Landroid/view/View;", "f", "Landroid/view/View;", "a", "()Landroid/view/View;", "clickedView", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;Landroid/view/View;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class j extends a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final MsgRecord msgRecord;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final PicElement picElement;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final View clickedView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(@NotNull MsgRecord msgRecord, @Nullable PicElement picElement, @NotNull View clickedView) {
            super(null);
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
            Intrinsics.checkNotNullParameter(clickedView, "clickedView");
            this.msgRecord = msgRecord;
            this.picElement = picElement;
            this.clickedView = clickedView;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final View getClickedView() {
            return this.clickedView;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final MsgRecord getMsgRecord() {
            return this.msgRecord;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final PicElement getPicElement() {
            return this.picElement;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/a$k;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a;", "", "d", "J", "b", "()J", "replayMsgRootSeq", "e", "c", "replayMsgSeq", "f", "a", "msgSeq", "<init>", "(JJJ)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class k extends a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final long replayMsgRootSeq;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final long replayMsgSeq;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final long msgSeq;

        public k(long j3, long j16, long j17) {
            super(null);
            this.replayMsgRootSeq = j3;
            this.replayMsgSeq = j16;
            this.msgSeq = j17;
        }

        /* renamed from: a, reason: from getter */
        public final long getMsgSeq() {
            return this.msgSeq;
        }

        /* renamed from: b, reason: from getter */
        public final long getReplayMsgRootSeq() {
            return this.replayMsgRootSeq;
        }

        /* renamed from: c, reason: from getter */
        public final long getReplayMsgSeq() {
            return this.replayMsgSeq;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/a$l;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a;", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class l extends a {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final l f110477d = new l();

        l() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0003\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/a$m;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a;", "Landroid/content/Context;", "d", "Landroid/content/Context;", "a", "()Landroid/content/Context;", "context", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "b", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Landroid/view/View;", "f", "Landroid/view/View;", "()Landroid/view/View;", "videoView", "", tl.h.F, "J", "c", "()J", "playPos", "<init>", "(Landroid/content/Context;Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;Landroid/view/View;J)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class m extends a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Context context;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final MsgRecord msgRecord;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final View videoView;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private final long playPos;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(@NotNull Context context, @NotNull MsgRecord msgRecord, @NotNull View videoView, long j3) {
            super(null);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
            Intrinsics.checkNotNullParameter(videoView, "videoView");
            this.context = context;
            this.msgRecord = msgRecord;
            this.videoView = videoView;
            this.playPos = j3;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final Context getContext() {
            return this.context;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final MsgRecord getMsgRecord() {
            return this.msgRecord;
        }

        /* renamed from: c, reason: from getter */
        public final long getPlayPos() {
            return this.playPos;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final View getVideoView() {
            return this.videoView;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/a$n;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "a", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class n extends a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final MsgRecord msgRecord;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(@NotNull MsgRecord msgRecord) {
            super(null);
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
            this.msgRecord = msgRecord;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final MsgRecord getMsgRecord() {
            return this.msgRecord;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/a$o;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "a", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class o extends a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final MsgRecord msgRecord;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(@NotNull MsgRecord msgRecord) {
            super(null);
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
            this.msgRecord = msgRecord;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final MsgRecord getMsgRecord() {
            return this.msgRecord;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/a$p;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "a", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class p extends a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final MsgRecord msgRecord;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(@NotNull MsgRecord msgRecord) {
            super(null);
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
            this.msgRecord = msgRecord;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final MsgRecord getMsgRecord() {
            return this.msgRecord;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/a$q;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a;", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class q extends a {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final q f110485d = new q();

        q() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/a$r;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a;", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class r extends a {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final r f110486d = new r();

        r() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/a$s;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a;", "", "d", "J", "a", "()J", "msgSeq", "<init>", "(J)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class s extends a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final long msgSeq;

        public s(long j3) {
            super(null);
            this.msgSeq = j3;
        }

        /* renamed from: a, reason: from getter */
        public final long getMsgSeq() {
            return this.msgSeq;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/a$t;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a;", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class t extends a {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final t f110488d = new t();

        t() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/a$u;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a;", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class u extends a {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final u f110489d = new u();

        u() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/a$v;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a;", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class v extends a {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final v f110490d = new v();

        v() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/a$w;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "d", "J", "a", "()J", "startTime", "<init>", "(J)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.factory.business.holder.msglist.a$w, reason: from toString */
    /* loaded from: classes6.dex */
    public static final /* data */ class SkeletonShow extends a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final long startTime;

        public SkeletonShow(long j3) {
            super(null);
            this.startTime = j3;
        }

        /* renamed from: a, reason: from getter */
        public final long getStartTime() {
            return this.startTime;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof SkeletonShow) && this.startTime == ((SkeletonShow) other).startTime) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return androidx.fragment.app.a.a(this.startTime);
        }

        @NotNull
        public String toString() {
            return "SkeletonShow(startTime=" + this.startTime + ")";
        }
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    a() {
    }
}
