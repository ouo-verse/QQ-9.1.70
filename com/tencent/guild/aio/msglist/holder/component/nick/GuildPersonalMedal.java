package com.tencent.guild.aio.msglist.holder.component.nick;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.guild.aio.msglist.holder.component.nick.GuildPersonalMedal;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedal;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001a2\u00020\u0001:\u0001\bB\u000f\u0012\u0006\u0010\u0011\u001a\u00020\f\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016R\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0017\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/component/nick/GuildPersonalMedal;", "Lcom/tencent/guild/aio/msglist/holder/component/nick/r;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "", "", "payloads", "", "a", "", "type", "f", "Landroid/content/Context;", "c", "Landroid/content/Context;", "l", "()Landroid/content/Context;", "context", "Landroid/widget/ImageView;", "d", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/ImageView;", "medalIv", "<init>", "(Landroid/content/Context;)V", "e", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildPersonalMedal extends r {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    private static final int f111589f;

    /* renamed from: g, reason: collision with root package name */
    private static final int f111590g;

    /* renamed from: h, reason: collision with root package name */
    private static final int f111591h;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy medalIv;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/component/nick/GuildPersonalMedal$a;", "", "", "MEDAL_HEIGHT_PX", "I", "a", "()I", "MEDAL_WIDTH_PX", "c", "MEDAL_LEFT_MARGIN_PX", "b", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.msglist.holder.component.nick.GuildPersonalMedal$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return GuildPersonalMedal.f111589f;
        }

        public final int b() {
            return GuildPersonalMedal.f111591h;
        }

        public final int c() {
            return GuildPersonalMedal.f111590g;
        }

        Companion() {
        }
    }

    static {
        wn0.a aVar = wn0.a.f445842a;
        f111589f = aVar.b(18);
        f111590g = aVar.b(18);
        f111591h = aVar.b(6);
    }

    public GuildPersonalMedal(@NotNull Context context) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.guild.aio.msglist.holder.component.nick.GuildPersonalMedal$medalIv$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ImageView invoke() {
                ImageView imageView = new ImageView(GuildPersonalMedal.this.getContext());
                GuildPersonalMedal guildPersonalMedal = GuildPersonalMedal.this;
                GuildPersonalMedal.Companion companion = GuildPersonalMedal.INSTANCE;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(companion.c(), companion.a());
                layoutParams.leftMargin = companion.b();
                layoutParams.gravity = 16;
                imageView.setLayoutParams(layoutParams);
                guildPersonalMedal.b(imageView);
                return imageView;
            }
        });
        this.medalIv = lazy;
    }

    private final ImageView m() {
        return (ImageView) this.medalIv.getValue();
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.nick.a
    public void a(@NotNull GuildMsgItem msgItem, @NotNull List<Object> payloads) {
        IGProMedal iGProMedal;
        String str;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        IGPSService c16 = com.tencent.guild.aio.util.h.f112401a.c();
        if (c16 != null) {
            iGProMedal = c16.getGuildUserMedal(msgItem.getMsgRecord().senderUid);
        } else {
            iGProMedal = null;
        }
        if (iGProMedal != null && !StringUtil.isEmpty(iGProMedal.getUrl())) {
            str = iGProMedal.getUrl();
            Intrinsics.checkNotNullExpressionValue(str, "personalMedal.url");
        } else {
            str = "";
        }
        if (StringUtil.isEmpty(str)) {
            m().setVisibility(8);
        } else {
            ((IQQGuildAvatarApi) ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).runtimeService(IQQGuildAvatarApi.class)).loadCommonPic(str, m());
            m().setVisibility(0);
        }
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.nick.r
    public void f(@NotNull GuildMsgItem msgItem, int type) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (type == 5) {
            a(msgItem, new ArrayList());
        }
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final Context getContext() {
        return this.context;
    }
}
