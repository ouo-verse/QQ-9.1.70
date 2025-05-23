package com.tencent.mobileqq.guild.home.parts;

import android.view.View;
import android.view.ViewStub;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.home.views.ban.GuildHomeBanLayout;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "guildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class GuildHomeBanPart$initData$2 extends Lambda implements Function1<IGProGuildInfo, Unit> {
    final /* synthetic */ Ref.ObjectRef<Runnable> $cancelBanned;
    final /* synthetic */ Ref.BooleanRef $isBanned;
    final /* synthetic */ GuildHomeBanPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildHomeBanPart$initData$2(Ref.BooleanRef booleanRef, GuildHomeBanPart guildHomeBanPart, Ref.ObjectRef<Runnable> objectRef) {
        super(1);
        this.$isBanned = booleanRef;
        this.this$0 = guildHomeBanPart;
        this.$cancelBanned = objectRef;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(GuildHomeBanPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.x9() != null && !this$0.x9().isFinishing()) {
            this$0.x9().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(GuildHomeBanPart this$0, List visibilityList) {
        List N9;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(visibilityList, "$visibilityList");
        N9 = this$0.N9();
        int i3 = 0;
        for (Object obj : N9) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            ((View) obj).setVisibility(((Number) visibilityList.get(i3)).intValue());
            i3 = i16;
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(IGProGuildInfo iGProGuildInfo) {
        invoke2(iGProGuildInfo);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [com.tencent.mobileqq.guild.home.parts.j, T] */
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable IGProGuildInfo iGProGuildInfo) {
        ViewStub viewStub;
        GuildHomeBanLayout guildHomeBanLayout;
        GuildHomeBanLayout guildHomeBanLayout2;
        GuildHomeBanLayout guildHomeBanLayout3;
        GuildHomeBanLayout guildHomeBanLayout4;
        GuildHomeBanLayout guildHomeBanLayout5;
        GuildHomeBanLayout guildHomeBanLayout6;
        GuildHomeBanLayout guildHomeBanLayout7;
        List N9;
        int collectionSizeOrDefault;
        List N92;
        ViewStub viewStub2;
        ViewStub viewStub3;
        IPerformanceReportTask iPerformanceReportTask;
        GuildHomeBanLayout guildHomeBanLayout8;
        if (iGProGuildInfo == null) {
            return;
        }
        this.$isBanned.element = iGProGuildInfo.getIsBanned();
        ViewStub viewStub4 = null;
        if (!this.$isBanned.element) {
            viewStub = this.this$0.guildHomeBanViewStub;
            if (viewStub == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildHomeBanViewStub");
            } else {
                viewStub4 = viewStub;
            }
            viewStub4.setVisibility(8);
            Runnable runnable = this.$cancelBanned.element;
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        if (!this.this$0.getIsInflated()) {
            viewStub2 = this.this$0.guildHomeBanViewStub;
            if (viewStub2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildHomeBanViewStub");
                viewStub2 = null;
            }
            if (viewStub2.getParent() != null) {
                viewStub3 = this.this$0.guildHomeBanViewStub;
                if (viewStub3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guildHomeBanViewStub");
                    viewStub3 = null;
                }
                View inflate = viewStub3.inflate();
                GuildHomeBanPart guildHomeBanPart = this.this$0;
                View findViewById = inflate.findViewById(R.id.wi6);
                Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.guild_home_full_ban)");
                guildHomeBanPart.guildHomeBanLayout = (GuildHomeBanLayout) findViewById;
                iPerformanceReportTask = this.this$0.guildBanReportTask;
                if (iPerformanceReportTask == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guildBanReportTask");
                    iPerformanceReportTask = null;
                }
                guildHomeBanLayout8 = this.this$0.guildHomeBanLayout;
                if (guildHomeBanLayout8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guildHomeBanLayout");
                    guildHomeBanLayout8 = null;
                }
                final GuildHomeBanPart guildHomeBanPart2 = this.this$0;
                qw1.b.j(iPerformanceReportTask, guildHomeBanLayout8, new Function1<IPerformanceReportTask, Unit>() { // from class: com.tencent.mobileqq.guild.home.parts.GuildHomeBanPart$initData$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(IPerformanceReportTask iPerformanceReportTask2) {
                        invoke2(iPerformanceReportTask2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull IPerformanceReportTask reportOnFirstFrame) {
                        IPerformanceReportTask iPerformanceReportTask2;
                        Intrinsics.checkNotNullParameter(reportOnFirstFrame, "$this$reportOnFirstFrame");
                        cp1.d dVar = cp1.d.f391542a;
                        iPerformanceReportTask2 = GuildHomeBanPart.this.guildBanReportTask;
                        if (iPerformanceReportTask2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("guildBanReportTask");
                            iPerformanceReportTask2 = null;
                        }
                        dVar.b(iPerformanceReportTask2);
                    }
                });
            }
        }
        guildHomeBanLayout = this.this$0.guildHomeBanLayout;
        if (guildHomeBanLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildHomeBanLayout");
            guildHomeBanLayout = null;
        }
        guildHomeBanLayout.setVisibility(0);
        guildHomeBanLayout2 = this.this$0.guildHomeBanLayout;
        if (guildHomeBanLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildHomeBanLayout");
            guildHomeBanLayout2 = null;
        }
        GuildFacadeType B9 = this.this$0.B9();
        final GuildHomeBanPart guildHomeBanPart3 = this.this$0;
        guildHomeBanLayout2.setGuildMainViewContext(B9, new GuildHomeBanLayout.b() { // from class: com.tencent.mobileqq.guild.home.parts.i
            @Override // com.tencent.mobileqq.guild.home.views.ban.GuildHomeBanLayout.b
            public final void onFinish() {
                GuildHomeBanPart$initData$2.c(GuildHomeBanPart.this);
            }
        });
        guildHomeBanLayout3 = this.this$0.guildHomeBanLayout;
        if (guildHomeBanLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildHomeBanLayout");
            guildHomeBanLayout3 = null;
        }
        guildHomeBanLayout3.setClickable(true);
        guildHomeBanLayout4 = this.this$0.guildHomeBanLayout;
        if (guildHomeBanLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildHomeBanLayout");
            guildHomeBanLayout4 = null;
        }
        guildHomeBanLayout4.setVisibility(0);
        guildHomeBanLayout5 = this.this$0.guildHomeBanLayout;
        if (guildHomeBanLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildHomeBanLayout");
            guildHomeBanLayout5 = null;
        }
        guildHomeBanLayout5.setZ(Float.MAX_VALUE);
        guildHomeBanLayout6 = this.this$0.guildHomeBanLayout;
        if (guildHomeBanLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildHomeBanLayout");
            guildHomeBanLayout7 = null;
        } else {
            guildHomeBanLayout7 = guildHomeBanLayout6;
        }
        GuildHomeBanLayout.o(guildHomeBanLayout7, this.this$0.x9(), iGProGuildInfo, true, 0, 8, null);
        N9 = this.this$0.N9();
        List list = N9;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        final ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((View) it.next()).getVisibility()));
        }
        Ref.ObjectRef<Runnable> objectRef = this.$cancelBanned;
        final GuildHomeBanPart guildHomeBanPart4 = this.this$0;
        objectRef.element = new Runnable() { // from class: com.tencent.mobileqq.guild.home.parts.j
            @Override // java.lang.Runnable
            public final void run() {
                GuildHomeBanPart$initData$2.d(GuildHomeBanPart.this, arrayList);
            }
        };
        N92 = this.this$0.N9();
        Iterator it5 = N92.iterator();
        while (it5.hasNext()) {
            ((View) it5.next()).setVisibility(8);
        }
    }
}
