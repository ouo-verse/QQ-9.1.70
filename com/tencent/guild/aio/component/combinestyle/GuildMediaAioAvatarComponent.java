package com.tencent.guild.aio.component.combinestyle;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0091\u0001\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010 \u001a\u00020\u0015\u0012:\b\u0002\u0010+\u001a4\u0012\u0013\u0012\u00110\"\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u000e\u0018\u00010!\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0010\u0012,\b\u0002\u00107\u001a&\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u000101j\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u0001`2\u00a2\u0006\u0004\b8\u00109J8\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\t\u0010\u0011\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\fH\u00d6\u0001J\u0013\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u00d6\u0003R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010 \u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fRI\u0010+\u001a4\u0012\u0013\u0012\u00110\"\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u000e\u0018\u00010!8\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0019\u00100\u001a\u0004\u0018\u00010\u00108\u0006\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R;\u00107\u001a&\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u000101j\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u0001`28\u0006\u00a2\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106\u00a8\u0006:"}, d2 = {"Lcom/tencent/guild/aio/component/combinestyle/h;", "Lcom/tencent/guild/aio/component/combinestyle/ac;", "Landroid/widget/ImageView;", "imageView", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "Landroid/text/SpannableStringBuilder;", "spannedString", "Landroid/widget/TextView;", "textView", "Lcom/tencent/guild/aio/component/combinestyle/aa;", "combineStyleAioItem", "", WadlProxyConsts.FLAGS, "", "b", "", "toString", "hashCode", "", "other", "", "equals", "Lcom/tencent/guild/aio/component/combinestyle/ah;", "a", "Lcom/tencent/guild/aio/component/combinestyle/ah;", "getLoadImageStrategy", "()Lcom/tencent/guild/aio/component/combinestyle/ah;", "loadImageStrategy", "Z", "getEnableClick", "()Z", "enableClick", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "handleText", "c", "Lkotlin/jvm/functions/Function2;", "getClickCallback", "()Lkotlin/jvm/functions/Function2;", "clickCallback", "d", "Ljava/lang/String;", "getReportElementId", "()Ljava/lang/String;", "reportElementId", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "e", "Ljava/util/HashMap;", "getReportParamMap", "()Ljava/util/HashMap;", "reportParamMap", "<init>", "(Lcom/tencent/guild/aio/component/combinestyle/ah;ZLkotlin/jvm/functions/Function2;Ljava/lang/String;Ljava/util/HashMap;)V", "aio-guild-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.guild.aio.component.combinestyle.h, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class GuildMediaAioAvatarComponent implements ac {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final ah loadImageStrategy;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean enableClick;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Function2<View, aa, Unit> clickCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String reportElementId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final HashMap<String, Object> reportParamMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/component/combinestyle/h$a", "Lcom/tencent/guild/aio/component/combinestyle/ag;", "Landroid/graphics/drawable/Drawable;", "drawable", "", "onLoaded", "aio-guild-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.component.combinestyle.h$a */
    /* loaded from: classes6.dex */
    public static final class a implements ag {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ImageView f110227a;

        a(ImageView imageView) {
            this.f110227a = imageView;
        }

        @Override // com.tencent.guild.aio.component.combinestyle.ag
        public void onLoaded(@NotNull Drawable drawable) {
            Intrinsics.checkNotNullParameter(drawable, "drawable");
            this.f110227a.setVisibility(0);
            this.f110227a.setImageDrawable(drawable);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GuildMediaAioAvatarComponent(@Nullable ah ahVar, boolean z16, @Nullable Function2<? super View, ? super aa, Unit> function2, @Nullable String str, @Nullable HashMap<String, Object> hashMap) {
        this.loadImageStrategy = ahVar;
        this.enableClick = z16;
        this.clickCallback = function2;
        this.reportElementId = str;
        this.reportParamMap = hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(TextView textView, GuildMediaAioAvatarComponent this$0, aa combineStyleAioItem, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(textView, "$textView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(combineStyleAioItem, "$combineStyleAioItem");
        String str = this$0.reportElementId;
        HashMap<String, Object> hashMap = this$0.reportParamMap;
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        hashMap.put("dt_pgid", "pg_sgrp_avchannel_aio");
        Unit unit = Unit.INSTANCE;
        ae.h(textView, str, hashMap);
        Function2<View, aa, Unit> function2 = this$0.clickCallback;
        if (function2 != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            function2.invoke(it, combineStyleAioItem);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    @Override // com.tencent.guild.aio.component.combinestyle.ac
    public void b(@NotNull ImageView imageView, @NotNull GuildMsgItem msgItem, @NotNull SpannableStringBuilder spannedString, @NotNull final TextView textView, @NotNull final aa combineStyleAioItem, int flags) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(spannedString, "spannedString");
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(combineStyleAioItem, "combineStyleAioItem");
        ah ahVar = this.loadImageStrategy;
        if (ahVar instanceof ai) {
            GuildUserAvatarView guildUserAvatarView = (GuildUserAvatarView) imageView;
            guildUserAvatarView.setVisibility(0);
            guildUserAvatarView.setAvatarTinyId(((ai) this.loadImageStrategy).getGuild(), ((ai) this.loadImageStrategy).getTinyId());
        } else if (ahVar != null) {
            Context context = textView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "textView.context");
            ahVar.a(context, new a(imageView));
        }
        if (this.enableClick) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.component.combinestyle.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildMediaAioAvatarComponent.d(textView, this, combineStyleAioItem, view);
                }
            });
        }
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildMediaAioAvatarComponent)) {
            return false;
        }
        GuildMediaAioAvatarComponent guildMediaAioAvatarComponent = (GuildMediaAioAvatarComponent) other;
        if (Intrinsics.areEqual(this.loadImageStrategy, guildMediaAioAvatarComponent.loadImageStrategy) && this.enableClick == guildMediaAioAvatarComponent.enableClick && Intrinsics.areEqual(this.clickCallback, guildMediaAioAvatarComponent.clickCallback) && Intrinsics.areEqual(this.reportElementId, guildMediaAioAvatarComponent.reportElementId) && Intrinsics.areEqual(this.reportParamMap, guildMediaAioAvatarComponent.reportParamMap)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        ah ahVar = this.loadImageStrategy;
        int i3 = 0;
        if (ahVar == null) {
            hashCode = 0;
        } else {
            hashCode = ahVar.hashCode();
        }
        int i16 = hashCode * 31;
        boolean z16 = this.enableClick;
        int i17 = z16;
        if (z16 != 0) {
            i17 = 1;
        }
        int i18 = (i16 + i17) * 31;
        Function2<View, aa, Unit> function2 = this.clickCallback;
        if (function2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = function2.hashCode();
        }
        int i19 = (i18 + hashCode2) * 31;
        String str = this.reportElementId;
        if (str == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str.hashCode();
        }
        int i26 = (i19 + hashCode3) * 31;
        HashMap<String, Object> hashMap = this.reportParamMap;
        if (hashMap != null) {
            i3 = hashMap.hashCode();
        }
        return i26 + i3;
    }

    @NotNull
    public String toString() {
        return "GuildMediaAioAvatarComponent(loadImageStrategy=" + this.loadImageStrategy + ", enableClick=" + this.enableClick + ", clickCallback=" + this.clickCallback + ", reportElementId=" + this.reportElementId + ", reportParamMap=" + this.reportParamMap + ")";
    }

    public /* synthetic */ GuildMediaAioAvatarComponent(ah ahVar, boolean z16, Function2 function2, String str, HashMap hashMap, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(ahVar, (i3 & 2) != 0 ? false : z16, (i3 & 4) != 0 ? null : function2, (i3 & 8) != 0 ? null : str, (i3 & 16) != 0 ? null : hashMap);
    }
}
