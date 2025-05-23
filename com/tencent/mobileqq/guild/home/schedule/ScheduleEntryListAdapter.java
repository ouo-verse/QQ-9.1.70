package com.tencent.mobileqq.guild.home.schedule;

import android.annotation.SuppressLint;
import androidx.recyclerview.widget.DiffUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.home.schedule.delegates.DayGroupDelegate;
import com.tencent.mobileqq.guild.home.schedule.delegates.EmptyPageDelegate;
import com.tencent.mobileqq.guild.home.schedule.delegates.LoadDelegate;
import com.tencent.mobileqq.guild.home.schedule.delegates.ScheduleEmptyEntryDelegate;
import com.tencent.mobileqq.guild.home.schedule.delegates.ScheduleEntryDelegate;
import com.tencent.mobileqq.guild.home.schedule.delegates.ScheduleErrorDelegate;
import com.tencent.mobileqq.guild.home.schedule.delegates.SpaceDelegate;
import com.tencent.mobileqq.guild.home.schedule.models.ScheduleInfoItem;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.widget.adapterdelegates.d;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 32\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00014Bu\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0014\u0010\u0017\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d\u0012\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\b0\u001d\u00a2\u0006\u0004\b1\u00102J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003R.\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR.\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR0\u0010\u0017\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR.\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u001a\u0010\f\"\u0004\b\u001b\u0010\u000eR(\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020\b0\u001d8\u0006\u00a2\u0006\f\n\u0004\b&\u0010 \u001a\u0004\b'\u0010\"R\"\u00100\u001a\u00020)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/ScheduleEntryListAdapter;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/d;", "Lcom/tencent/mobileqq/guild/home/schedule/models/d;", "", "position", "", "n0", "Lkotlin/Function1;", "", "I", "Lkotlin/jvm/functions/Function1;", "m0", "()Lkotlin/jvm/functions/Function1;", "setOnLoadPrevious", "(Lkotlin/jvm/functions/Function1;)V", "onLoadPrevious", "J", "l0", "setOnLoadNext", "onLoadNext", "K", "getOnCreateSchedule", "setOnCreateSchedule", "onCreateSchedule", "Lcom/tencent/mobileqq/guild/home/schedule/models/ScheduleInfoItem;", "L", "getOnClickScheduleItem", "setOnClickScheduleItem", "onClickScheduleItem", "Lkotlin/Function0;", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "M", "Lkotlin/jvm/functions/Function0;", "getProvideJumpGuildParam", "()Lkotlin/jvm/functions/Function0;", "setProvideJumpGuildParam", "(Lkotlin/jvm/functions/Function0;)V", "provideJumpGuildParam", "N", "getOnReload", "onReload", "", "P", "Ljava/lang/String;", "k0", "()Ljava/lang/String;", "o0", "(Ljava/lang/String;)V", "channelId", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class ScheduleEntryListAdapter extends d<com.tencent.mobileqq.guild.home.schedule.models.d> {

    @NotNull
    private static final a R = new a();

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private Function1<? super com.tencent.mobileqq.guild.home.schedule.models.d, Unit> onLoadPrevious;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private Function1<? super com.tencent.mobileqq.guild.home.schedule.models.d, Unit> onLoadNext;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private Function1<? super com.tencent.mobileqq.guild.home.schedule.models.d, Unit> onCreateSchedule;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private Function1<? super ScheduleInfoItem, Unit> onClickScheduleItem;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private Function0<? extends JumpGuildParam> provideJumpGuildParam;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final Function0<Unit> onReload;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private String channelId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0017\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/home/schedule/ScheduleEntryListAdapter$a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/mobileqq/guild/home/schedule/models/d;", "p0", "p1", "", "b", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a extends DiffUtil.ItemCallback<com.tencent.mobileqq.guild.home.schedule.models.d> {
        a() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        @SuppressLint({"DiffUtilEquals"})
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NotNull com.tencent.mobileqq.guild.home.schedule.models.d p06, @NotNull com.tencent.mobileqq.guild.home.schedule.models.d p16) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            Intrinsics.checkNotNullParameter(p16, "p1");
            return Intrinsics.areEqual(p06, p16);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NotNull com.tencent.mobileqq.guild.home.schedule.models.d p06, @NotNull com.tencent.mobileqq.guild.home.schedule.models.d p16) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            Intrinsics.checkNotNullParameter(p16, "p1");
            if (p06 == p16) {
                return true;
            }
            return false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScheduleEntryListAdapter(@NotNull Function1<? super com.tencent.mobileqq.guild.home.schedule.models.d, Unit> onLoadPrevious, @NotNull Function1<? super com.tencent.mobileqq.guild.home.schedule.models.d, Unit> onLoadNext, @NotNull Function1<? super com.tencent.mobileqq.guild.home.schedule.models.d, Unit> onCreateSchedule, @NotNull Function1<? super ScheduleInfoItem, Unit> onClickScheduleItem, @NotNull Function0<? extends JumpGuildParam> provideJumpGuildParam, @NotNull Function0<Unit> onReload) {
        super(R);
        Intrinsics.checkNotNullParameter(onLoadPrevious, "onLoadPrevious");
        Intrinsics.checkNotNullParameter(onLoadNext, "onLoadNext");
        Intrinsics.checkNotNullParameter(onCreateSchedule, "onCreateSchedule");
        Intrinsics.checkNotNullParameter(onClickScheduleItem, "onClickScheduleItem");
        Intrinsics.checkNotNullParameter(provideJumpGuildParam, "provideJumpGuildParam");
        Intrinsics.checkNotNullParameter(onReload, "onReload");
        this.onLoadPrevious = onLoadPrevious;
        this.onLoadNext = onLoadNext;
        this.onCreateSchedule = onCreateSchedule;
        this.onClickScheduleItem = onClickScheduleItem;
        this.provideJumpGuildParam = provideJumpGuildParam;
        this.onReload = onReload;
        this.channelId = "";
        this.f236209m.c(new LoadDelegate(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.home.schedule.ScheduleEntryListAdapter.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Object obj;
                List<com.tencent.mobileqq.guild.home.schedule.models.d> items = ScheduleEntryListAdapter.this.getItems();
                Intrinsics.checkNotNullExpressionValue(items, "items");
                Iterator<T> it = items.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    boolean z16 = true;
                    if (((com.tencent.mobileqq.guild.home.schedule.models.d) obj).getType() != 1) {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                }
                com.tencent.mobileqq.guild.home.schedule.models.d dVar = (com.tencent.mobileqq.guild.home.schedule.models.d) obj;
                if (dVar != null) {
                    ScheduleEntryListAdapter.this.m0().invoke(dVar);
                }
            }
        }, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.home.schedule.ScheduleEntryListAdapter.2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                com.tencent.mobileqq.guild.home.schedule.models.d dVar;
                List<com.tencent.mobileqq.guild.home.schedule.models.d> items = ScheduleEntryListAdapter.this.getItems();
                Intrinsics.checkNotNullExpressionValue(items, "items");
                ListIterator<com.tencent.mobileqq.guild.home.schedule.models.d> listIterator = items.listIterator(items.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        dVar = null;
                        break;
                    }
                    dVar = listIterator.previous();
                    boolean z16 = true;
                    if (dVar.getType() != 1) {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                }
                com.tencent.mobileqq.guild.home.schedule.models.d dVar2 = dVar;
                if (dVar2 != null) {
                    ScheduleEntryListAdapter.this.l0().invoke(dVar2);
                }
            }
        }));
        this.f236209m.c(new DayGroupDelegate());
        this.f236209m.c(new ScheduleEntryDelegate(this.onClickScheduleItem, this.provideJumpGuildParam));
        this.f236209m.c(new EmptyPageDelegate(this.onCreateSchedule));
        this.f236209m.c(new ScheduleEmptyEntryDelegate(this.onCreateSchedule));
        this.f236209m.c(new ScheduleErrorDelegate(onReload));
        this.f236209m.c(new SpaceDelegate());
        this.D = false;
    }

    @NotNull
    /* renamed from: k0, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    @NotNull
    public final Function1<com.tencent.mobileqq.guild.home.schedule.models.d, Unit> l0() {
        return this.onLoadNext;
    }

    @NotNull
    public final Function1<com.tencent.mobileqq.guild.home.schedule.models.d, Unit> m0() {
        return this.onLoadPrevious;
    }

    public final boolean n0(int position) {
        if (position >= getItems().size()) {
            Logger logger = Logger.f235387a;
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
            Logger.b bVar = new Logger.b();
            String str = "isItemHeader(" + position + "), size = " + getItems().size();
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("ScheduleEntryListAdapter", 1, (String) it.next(), indexOutOfBoundsException);
            }
            return false;
        }
        if (getItems().get(position).getType() == 0) {
            return true;
        }
        return false;
    }

    public final void o0(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.channelId = str;
    }
}
