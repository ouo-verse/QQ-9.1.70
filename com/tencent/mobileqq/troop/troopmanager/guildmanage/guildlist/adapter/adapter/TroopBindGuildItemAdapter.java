package com.tencent.mobileqq.troop.troopmanager.guildmanage.guildlist.adapter.adapter;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.kernel.nativeinterface.AIOBindGuildInfo;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 )2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001*B\u0017\u0012\u0006\u0010 \u001a\u00020\u001b\u0012\u0006\u0010&\u001a\u00020!\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J&\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0014J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0014J.\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u000fH\u0014R\u0017\u0010 \u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010&\u001a\u00020!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/troop/troopmanager/guildmanage/guildlist/adapter/adapter/TroopBindGuildItemAdapter;", "Lcom/tencent/biz/richframework/part/adapter/delegate/AbsListItemAdapterDelegate;", "Lkt2/d;", "Lkt2/a;", "Lit2/e;", "Lcom/tencent/qqnt/kernel/nativeinterface/AIOBindGuildInfo;", "guildInfo", "", "r", "o", "", "", "", "j", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "l", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, DomainData.DOMAIN_NAME, "holder", "payloads", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/app/Activity;", "d", "Landroid/app/Activity;", "i", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Llt2/c;", "e", "Llt2/c;", "k", "()Llt2/c;", "viewModel", "<init>", "(Landroid/app/Activity;Llt2/c;)V", "f", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopBindGuildItemAdapter extends AbsListItemAdapterDelegate<kt2.d, kt2.a, it2.e> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Activity activity;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final lt2.c viewModel;

    public TroopBindGuildItemAdapter(@NotNull Activity activity, @NotNull lt2.c viewModel) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.activity = activity;
        this.viewModel = viewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> j(AIOBindGuildInfo guildInfo) {
        Map<String, Object> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("sgrp_channel_id", Long.valueOf(guildInfo.guildId)));
        return mutableMapOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(final AIOBindGuildInfo guildInfo) {
        Activity activity = this.activity;
        DialogUtil.createCustomDialog(activity, activity.getString(R.string.f23378787), this.activity.getString(R.string.f23377786), this.activity.getString(R.string.f2059456z), this.activity.getString(R.string.f2336277r), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopmanager.guildmanage.guildlist.adapter.adapter.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                TroopBindGuildItemAdapter.p(TroopBindGuildItemAdapter.this, guildInfo, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopmanager.guildmanage.guildlist.adapter.adapter.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                TroopBindGuildItemAdapter.q(dialogInterface, i3);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(TroopBindGuildItemAdapter this$0, AIOBindGuildInfo guildInfo, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(guildInfo, "$guildInfo");
        this$0.viewModel.f2(guildInfo);
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(DialogInterface dialogInterface, int i3) {
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(final AIOBindGuildInfo guildInfo) {
        String str;
        Activity activity = this.activity;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = activity.getString(R.string.f23375784);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str\u2026ace_guild_dialog_content)");
        Object[] objArr = new Object[2];
        AIOBindGuildInfo curDisplayedGuild = this.viewModel.getCurDisplayedGuild();
        if (curDisplayedGuild != null) {
            str = curDisplayedGuild.guildName;
        } else {
            str = null;
        }
        objArr[0] = str;
        objArr[1] = guildInfo.guildName;
        String format = String.format(string, Arrays.copyOf(objArr, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        DialogUtil.createCustomDialog(activity, null, format, this.activity.getString(R.string.f2059456z), this.activity.getString(R.string.f2336377s), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopmanager.guildmanage.guildlist.adapter.adapter.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                TroopBindGuildItemAdapter.s(TroopBindGuildItemAdapter.this, guildInfo, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopmanager.guildmanage.guildlist.adapter.adapter.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                TroopBindGuildItemAdapter.t(dialogInterface, i3);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(TroopBindGuildItemAdapter this$0, AIOBindGuildInfo guildInfo, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(guildInfo, "$guildInfo");
        this$0.viewModel.f2(guildInfo);
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(DialogInterface dialogInterface, int i3) {
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final Activity getActivity() {
        return this.activity;
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public final lt2.c getViewModel() {
        return this.viewModel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public boolean isForViewType(@NotNull kt2.a item, @NotNull List<kt2.a> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof kt2.d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder2(@NotNull kt2.d item, @NotNull it2.e holder, int position, @NotNull List<Object> payloads) {
        int b16;
        final String str;
        QUIListItemBackgroundType qUIListItemBackgroundType;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (item.getIsSelected()) {
            b16 = it2.a.f408711a.a();
            str = "em_group_channel_show_cancel";
        } else if (this.viewModel.getCurDisplayedGuild() != null) {
            b16 = it2.a.f408711a.c();
            str = "em_group_channel_replace";
        } else {
            b16 = it2.a.f408711a.b();
            str = "em_group_channel_show";
        }
        int i3 = b16;
        if (item.getIsSelected()) {
            qUIListItemBackgroundType = QUIListItemBackgroundType.AllRound;
        } else if (item.getIsLastItem()) {
            qUIListItemBackgroundType = QUIListItemBackgroundType.BottomRound;
        } else {
            qUIListItemBackgroundType = QUIListItemBackgroundType.NoneRound;
        }
        holder.n(item.getAioBindGuildInfo(), qUIListItemBackgroundType, i3, new Function1<AIOBindGuildInfo, Unit>() { // from class: com.tencent.mobileqq.troop.troopmanager.guildmanage.guildlist.adapter.adapter.TroopBindGuildItemAdapter$onBindViewHolder$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AIOBindGuildInfo aIOBindGuildInfo) {
                invoke2(aIOBindGuildInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull AIOBindGuildInfo guildInfo) {
                Map<String, ? extends Object> j3;
                Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
                com.tencent.mobileqq.guild.report.b.g("qq_group_pindao_management", "troop_bind_guild");
                ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).jumpGuildByBusinessType(TroopBindGuildItemAdapter.this.getActivity(), String.valueOf(guildInfo.guildId), "qq_group", "pindao_management", 16, new Bundle());
                lt2.c viewModel = TroopBindGuildItemAdapter.this.getViewModel();
                j3 = TroopBindGuildItemAdapter.this.j(guildInfo);
                viewModel.Z1("em_group_channel_link", "dt_clck", j3);
            }
        }, new Function1<AIOBindGuildInfo, Unit>() { // from class: com.tencent.mobileqq.troop.troopmanager.guildmanage.guildlist.adapter.adapter.TroopBindGuildItemAdapter$onBindViewHolder$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AIOBindGuildInfo aIOBindGuildInfo) {
                invoke2(aIOBindGuildInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull AIOBindGuildInfo guildInfo) {
                Map<String, ? extends Object> j3;
                Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
                AIOBindGuildInfo curDisplayedGuild = TroopBindGuildItemAdapter.this.getViewModel().getCurDisplayedGuild();
                Long valueOf = curDisplayedGuild != null ? Long.valueOf(curDisplayedGuild.guildId) : null;
                if (guildInfo.status != 0) {
                    long j16 = guildInfo.guildId;
                    if (valueOf == null || j16 != valueOf.longValue()) {
                        QQToast.makeText(TroopBindGuildItemAdapter.this.getActivity(), 1, TroopBindGuildItemAdapter.this.getActivity().getString(R.string.f2338478c), 0).show();
                        lt2.c viewModel = TroopBindGuildItemAdapter.this.getViewModel();
                        String str2 = str;
                        j3 = TroopBindGuildItemAdapter.this.j(guildInfo);
                        viewModel.Z1(str2, "dt_clck", j3);
                    }
                }
                if (TroopBindGuildItemAdapter.this.getViewModel().getIsTroopGuild()) {
                    TroopBindGuildItemAdapter.this.o(guildInfo);
                } else {
                    if (valueOf != null) {
                        if (valueOf.longValue() != guildInfo.guildId) {
                            TroopBindGuildItemAdapter.this.r(guildInfo);
                        }
                    }
                    TroopBindGuildItemAdapter.this.getViewModel().f2(guildInfo);
                }
                lt2.c viewModel2 = TroopBindGuildItemAdapter.this.getViewModel();
                String str22 = str;
                j3 = TroopBindGuildItemAdapter.this.j(guildInfo);
                viewModel2.Z1(str22, "dt_clck", j3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate
    @NotNull
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public it2.e onCreateViewHolder(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(this.activity).inflate(R.layout.fzr, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(activity).inflate(R\u2026uild_item, parent, false)");
        return new it2.e(inflate);
    }
}
