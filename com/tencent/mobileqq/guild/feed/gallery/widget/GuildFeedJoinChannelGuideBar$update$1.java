package com.tencent.mobileqq.guild.feed.gallery.widget;

import android.widget.TextView;
import com.tencent.mobileqq.guild.util.GuildMedalUtils;
import com.tencent.mobileqq.guild.util.az;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedalInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "guildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class GuildFeedJoinChannelGuideBar$update$1 extends Lambda implements Function1<IGProGuildInfo, Unit> {
    final /* synthetic */ boolean $forceShowBar;
    final /* synthetic */ GuildFeedJoinChannelGuideBar this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedJoinChannelGuideBar$update$1(GuildFeedJoinChannelGuideBar guildFeedJoinChannelGuideBar, boolean z16) {
        super(1);
        this.this$0 = guildFeedJoinChannelGuideBar;
        this.$forceShowBar = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(List validMediaList, String guildName, GuildFeedJoinChannelGuideBar this$0) {
        x12.c cVar;
        Object obj;
        List listOf;
        x12.c cVar2;
        Intrinsics.checkNotNullParameter(validMediaList, "$validMediaList");
        Intrinsics.checkNotNullParameter(guildName, "$guildName");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator it = validMediaList.iterator();
        while (true) {
            cVar = null;
            if (it.hasNext()) {
                obj = it.next();
                if (((IGProMedalInfo) obj).getOfficialMedalInfoExt().getIsOffical()) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        IGProMedalInfo iGProMedalInfo = (IGProMedalInfo) obj;
        if (iGProMedalInfo != null) {
            GuildMedalUtils guildMedalUtils = GuildMedalUtils.f235347a;
            listOf = CollectionsKt__CollectionsJVMKt.listOf(iGProMedalInfo);
            cVar2 = this$0.binding;
            if (cVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                cVar = cVar2;
            }
            TextView textView = cVar.f446893g;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.guildName");
            GuildMedalUtils.w(guildMedalUtils, guildName, listOf, textView, null, 0, null, 56, null);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(IGProGuildInfo iGProGuildInfo) {
        invoke2(iGProGuildInfo);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable IGProGuildInfo iGProGuildInfo) {
        boolean J;
        CharSequence trim;
        x12.c cVar;
        if (iGProGuildInfo != null) {
            J = this.this$0.J(iGProGuildInfo, this.$forceShowBar);
            if (J) {
                QLog.e("GuildFeedJoinChannelGuideBar", 1, "hide joinBar");
                return;
            }
            this.this$0.setVisibility(0);
            this.this$0.B(iGProGuildInfo.isMember());
            this.this$0.G(iGProGuildInfo.getAvatarUrl(100));
            GuildFeedJoinChannelGuideBar guildFeedJoinChannelGuideBar = this.this$0;
            String coverUrl = iGProGuildInfo.getCoverUrl(0, 0);
            Intrinsics.checkNotNullExpressionValue(coverUrl, "guildInfo.getCoverUrl(0, 0)");
            guildFeedJoinChannelGuideBar.s(coverUrl);
            String a16 = az.a(iGProGuildInfo.getGuildName());
            Intrinsics.checkNotNullExpressionValue(a16, "changeEnterToSpace(guildInfo.guildName)");
            trim = StringsKt__StringsKt.trim((CharSequence) a16);
            final String obj = trim.toString();
            this.this$0.H(obj);
            x12.c cVar2 = null;
            final List t16 = GuildMedalUtils.t(iGProGuildInfo.getMedalInfoList(), 0, 2, null);
            if (true ^ t16.isEmpty()) {
                cVar = this.this$0.binding;
                if (cVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    cVar2 = cVar;
                }
                TextView textView = cVar2.f446893g;
                final GuildFeedJoinChannelGuideBar guildFeedJoinChannelGuideBar2 = this.this$0;
                textView.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.gallery.widget.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        GuildFeedJoinChannelGuideBar$update$1.b(t16, obj, guildFeedJoinChannelGuideBar2);
                    }
                });
            }
        }
        this.this$0.D();
    }
}
