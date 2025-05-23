package com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.ConfigIconItem;
import com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.QQGuildNavigatorConfigAddConfigFragment;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildNavIconInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildNavIconTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import vp1.cg;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lvp1/cg;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/navigatorconfig/model/c;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", com.tencent.luggage.wxa.c8.c.G, "", "invoke", "(Lvp1/cg;Lcom/tencent/mobileqq/guild/setting/guildmanage/navigatorconfig/model/c;I)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class QQGuildNavigatorConfigFragment$createConfigAdapter$2 extends Lambda implements Function3<cg, com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c, Integer, Unit> {
    final /* synthetic */ QQGuildNavigatorConfigFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQGuildNavigatorConfigFragment$createConfigAdapter$2(QQGuildNavigatorConfigFragment qQGuildNavigatorConfigFragment) {
        super(3);
        this.this$0 = qQGuildNavigatorConfigFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean f(com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c item, QQGuildNavigatorConfigFragment this$0, cg this_$receiver, View view, MotionEvent motionEvent) {
        ItemTouchHelper Ei;
        RecyclerView yi5;
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_$receiver, "$this_$receiver");
        if (motionEvent.getActionMasked() == 0 && !(item instanceof com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.a)) {
            Ei = this$0.Ei();
            yi5 = this$0.yi();
            Ei.startDrag(yi5.getChildViewHolder(this_$receiver.f442701k));
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(QQGuildNavigatorConfigFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.xi();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c item, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(item, "$item");
        QQToast.makeText(BaseApplication.getContext(), 1, item.e(), 1).show();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(QQGuildNavigatorConfigFragment this$0, com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c item, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        this$0.Zi(item);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(QQGuildNavigatorConfigFragment this$0, com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c item, View view) {
        Object obj;
        ArrayList<IGProGuildNavIconInfo> arrayList;
        Object obj2;
        ArrayList<IGProGuildNavIconInfo> arrayList2;
        int collectionSizeOrDefault;
        List mutableList;
        List list;
        ArrayList arrayList3;
        IGProGuildInfo guildInfo;
        Long valueOf;
        String icon;
        String configName;
        String subDesc;
        int collectionSizeOrDefault2;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        Iterator<T> it = this$0.Ji().l2().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((IGProGuildNavIconTheme) obj).getIconSelectorColor(), this$0.Ji().getCurrentIconSelectorColor())) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        IGProGuildNavIconTheme iGProGuildNavIconTheme = (IGProGuildNavIconTheme) obj;
        if (iGProGuildNavIconTheme != null) {
            arrayList = iGProGuildNavIconTheme.getIcons();
        } else {
            arrayList = null;
        }
        Iterator<T> it5 = this$0.Ji().l2().iterator();
        while (true) {
            if (it5.hasNext()) {
                obj2 = it5.next();
                if (Intrinsics.areEqual(((IGProGuildNavIconTheme) obj2).getIconSelectorColor(), "black")) {
                    break;
                }
            } else {
                obj2 = null;
                break;
            }
        }
        IGProGuildNavIconTheme iGProGuildNavIconTheme2 = (IGProGuildNavIconTheme) obj2;
        if (iGProGuildNavIconTheme2 != null) {
            arrayList2 = iGProGuildNavIconTheme2.getIcons();
        } else {
            arrayList2 = null;
        }
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        this$0.Ji().q2(Integer.valueOf(this$0.Ji().W1().indexOf(item)));
        QQGuildNavigatorConfigAddConfigFragment.Companion companion = QQGuildNavigatorConfigAddConfigFragment.INSTANCE;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault);
        for (IGProGuildNavIconInfo it6 : arrayList) {
            ConfigIconItem.Companion companion2 = ConfigIconItem.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(it6, "it");
            arrayList4.add(companion2.a(it6));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList4);
        Intrinsics.checkNotNull(mutableList, "null cannot be cast to non-null type java.util.ArrayList<com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.ConfigIconItem>{ kotlin.collections.TypeAliasesKt.ArrayList<com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.ConfigIconItem> }");
        ArrayList arrayList5 = (ArrayList) mutableList;
        if (arrayList2 != null) {
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
            ArrayList arrayList6 = new ArrayList(collectionSizeOrDefault2);
            for (IGProGuildNavIconInfo it7 : arrayList2) {
                ConfigIconItem.Companion companion3 = ConfigIconItem.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(it7, "it");
                arrayList6.add(companion3.a(it7));
            }
            list = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList6);
        } else {
            list = null;
        }
        if (list instanceof ArrayList) {
            arrayList3 = (ArrayList) list;
        } else {
            arrayList3 = null;
        }
        guildInfo = this$0.getGuildInfo();
        Intrinsics.checkNotNull(guildInfo);
        String guildID = guildInfo.getGuildID();
        Intrinsics.checkNotNullExpressionValue(guildID, "guildInfo!!.guildID");
        boolean z16 = item instanceof com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.a;
        if (z16) {
            valueOf = null;
        } else {
            valueOf = Long.valueOf(item.getId());
        }
        if (z16) {
            icon = null;
        } else {
            icon = item.getIcon();
        }
        if (z16) {
            configName = null;
        } else {
            configName = item.getConfigName();
        }
        if (z16) {
            subDesc = null;
        } else {
            subDesc = item.getSubDesc();
        }
        companion.a(this$0, arrayList5, (r27 & 4) != 0 ? null : arrayList3, guildID, (r27 & 16) != 0 ? null : valueOf, (r27 & 32) != 0 ? null : icon, (r27 & 64) != 0 ? null : configName, (r27 & 128) != 0 ? null : subDesc, (r27 & 256) != 0 ? false : false, (r27 & 512) != 0 ? null : null, 101);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(cg cgVar, com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c cVar, Integer num) {
        invoke(cgVar, cVar, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x016f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void invoke(@NotNull final cg $receiver, @NotNull final com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c item, int i3) {
        Object lastOrNull;
        boolean z16;
        boolean z17;
        boolean z18;
        Map mapOf;
        boolean z19;
        String vi5;
        Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
        Intrinsics.checkNotNullParameter(item, "item");
        $receiver.f442694d.setReferencedIds(new int[]{R.id.f107006_9, R.id.f167042k73});
        $receiver.f442700j.setReferencedIds(new int[]{R.id.y0k, R.id.t4t});
        $receiver.f442700j.setBackground(this.this$0.getResources().getDrawable(R.drawable.guild_nav_click_bg));
        ViewUtils.setViewRadius($receiver.f442696f, 6.0f);
        View devLine = $receiver.f442693c;
        Intrinsics.checkNotNullExpressionValue(devLine, "devLine");
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) this.this$0.Ji().W1());
        com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c cVar = (com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c) lastOrNull;
        devLine.setVisibility((cVar != null && cVar.hashCode() == item.hashCode()) ^ true ? 0 : 8);
        $receiver.f442696f.setBackgroundColor(this.this$0.getResources().getColor(R.color.qui_common_fill_standard_primary));
        $receiver.f442704n.setBackgroundColor(this.this$0.getResources().getColor(R.color.qui_common_fill_light_secondary));
        boolean z26 = item instanceof com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.a;
        ImageView ivAvatarAdd = $receiver.f442696f;
        Intrinsics.checkNotNullExpressionValue(ivAvatarAdd, "ivAvatarAdd");
        ivAvatarAdd.setVisibility(z26 ^ true ? 4 : 0);
        ImageView ivAvatar = $receiver.f442695e;
        Intrinsics.checkNotNullExpressionValue(ivAvatar, "ivAvatar");
        ivAvatar.setVisibility(z26 ? 4 : 0);
        String icon = item.getIcon();
        if (icon != null) {
            QQGuildNavigatorConfigFragment qQGuildNavigatorConfigFragment = this.this$0;
            vi5 = qQGuildNavigatorConfigFragment.vi(item.getId());
            if (vi5 != null) {
                icon = vi5;
            }
            ImageView ivAvatar2 = $receiver.f442695e;
            Intrinsics.checkNotNullExpressionValue(ivAvatar2, "ivAvatar");
            qQGuildNavigatorConfigFragment.Vi(icon, ivAvatar2);
            $receiver.f442695e.setColorFilter(new PorterDuffColorFilter(qQGuildNavigatorConfigFragment.getResources().getColor(R.color.qui_common_icon_primary), PorterDuff.Mode.SRC_IN));
        }
        TextView tvDesc = $receiver.f442703m;
        Intrinsics.checkNotNullExpressionValue(tvDesc, "tvDesc");
        tvDesc.setVisibility(z26 ^ true ? 0 : 8);
        $receiver.f442702l.setText(item.getConfigName());
        $receiver.f442703m.setText(item.getSubDesc());
        ImageView ivInfoAttention = $receiver.f442697g;
        Intrinsics.checkNotNullExpressionValue(ivInfoAttention, "ivInfoAttention");
        z16 = this.this$0.isSortMode;
        ivInfoAttention.setVisibility(!z16 && item.getIsShowAttention() ? 0 : 8);
        ImageView ivSort = $receiver.f442699i;
        Intrinsics.checkNotNullExpressionValue(ivSort, "ivSort");
        z17 = this.this$0.isSortMode;
        ivSort.setVisibility(z17 && !z26 ? 0 : 8);
        ImageView ivMore = $receiver.f442698h;
        Intrinsics.checkNotNullExpressionValue(ivMore, "ivMore");
        if (!item.k()) {
            z19 = this.this$0.isSortMode;
            if (!z19) {
                z18 = true;
                ivMore.setVisibility(!z18 ? 0 : 8);
                ImageView imageView = $receiver.f442699i;
                final QQGuildNavigatorConfigFragment qQGuildNavigatorConfigFragment2 = this.this$0;
                imageView.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.w
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        boolean f16;
                        f16 = QQGuildNavigatorConfigFragment$createConfigAdapter$2.f(com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c.this, qQGuildNavigatorConfigFragment2, $receiver, view, motionEvent);
                        return f16;
                    }
                });
                TextView tvError = $receiver.f442704n;
                Intrinsics.checkNotNullExpressionValue(tvError, "tvError");
                tvError.setVisibility(item instanceof com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.b ? 0 : 8);
                TextView textView = $receiver.f442704n;
                final QQGuildNavigatorConfigFragment qQGuildNavigatorConfigFragment3 = this.this$0;
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.x
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        QQGuildNavigatorConfigFragment$createConfigAdapter$2.g(QQGuildNavigatorConfigFragment.this, view);
                    }
                });
                $receiver.f442697g.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.y
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        QQGuildNavigatorConfigFragment$createConfigAdapter$2.h(com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c.this, view);
                    }
                });
                ImageView imageView2 = $receiver.f442698h;
                final QQGuildNavigatorConfigFragment qQGuildNavigatorConfigFragment4 = this.this$0;
                imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.z
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        QQGuildNavigatorConfigFragment$createConfigAdapter$2.i(QQGuildNavigatorConfigFragment.this, item, view);
                    }
                });
                Layer layer = $receiver.f442700j;
                final QQGuildNavigatorConfigFragment qQGuildNavigatorConfigFragment5 = this.this$0;
                layer.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.aa
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        QQGuildNavigatorConfigFragment$createConfigAdapter$2.j(QQGuildNavigatorConfigFragment.this, item, view);
                    }
                });
                if (!(item instanceof com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.a)) {
                    com.tencent.mobileqq.guild.api.impl.e.a($receiver.f442700j, null, "em_sgrp_add_service", null, null, null, ClickPolicy.REPORT_ALL);
                    return;
                }
                if (item.k()) {
                    return;
                }
                Layer layer2 = $receiver.f442700j;
                Pair[] pairArr = new Pair[4];
                pairArr[0] = TuplesKt.to("sgrp_icon_id", Long.valueOf(item.getId()));
                pairArr[1] = TuplesKt.to("sgrp_navigation_name", item.getConfigName());
                pairArr[2] = TuplesKt.to("sgrp_navigation_url", item.getSubDesc());
                pairArr[3] = TuplesKt.to("sgrp_state_tags", Integer.valueOf(item.getIsShowAttention() ? 1 : 2));
                mapOf = MapsKt__MapsKt.mapOf(pairArr);
                com.tencent.mobileqq.guild.api.impl.e.a(layer2, null, "em_sgrp_navigation_bar_set", mapOf, null, null, ClickPolicy.REPORT_ALL);
                return;
            }
        }
        z18 = false;
        ivMore.setVisibility(!z18 ? 0 : 8);
        ImageView imageView3 = $receiver.f442699i;
        final QQGuildNavigatorConfigFragment qQGuildNavigatorConfigFragment22 = this.this$0;
        imageView3.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.w
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean f16;
                f16 = QQGuildNavigatorConfigFragment$createConfigAdapter$2.f(com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c.this, qQGuildNavigatorConfigFragment22, $receiver, view, motionEvent);
                return f16;
            }
        });
        TextView tvError2 = $receiver.f442704n;
        Intrinsics.checkNotNullExpressionValue(tvError2, "tvError");
        tvError2.setVisibility(item instanceof com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.b ? 0 : 8);
        TextView textView2 = $receiver.f442704n;
        final QQGuildNavigatorConfigFragment qQGuildNavigatorConfigFragment32 = this.this$0;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQGuildNavigatorConfigFragment$createConfigAdapter$2.g(QQGuildNavigatorConfigFragment.this, view);
            }
        });
        $receiver.f442697g.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQGuildNavigatorConfigFragment$createConfigAdapter$2.h(com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c.this, view);
            }
        });
        ImageView imageView22 = $receiver.f442698h;
        final QQGuildNavigatorConfigFragment qQGuildNavigatorConfigFragment42 = this.this$0;
        imageView22.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQGuildNavigatorConfigFragment$createConfigAdapter$2.i(QQGuildNavigatorConfigFragment.this, item, view);
            }
        });
        Layer layer3 = $receiver.f442700j;
        final QQGuildNavigatorConfigFragment qQGuildNavigatorConfigFragment52 = this.this$0;
        layer3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.aa
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQGuildNavigatorConfigFragment$createConfigAdapter$2.j(QQGuildNavigatorConfigFragment.this, item, view);
            }
        });
        if (!(item instanceof com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.a)) {
        }
    }
}
