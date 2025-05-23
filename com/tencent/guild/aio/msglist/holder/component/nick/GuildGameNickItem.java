package com.tencent.guild.aio.msglist.holder.component.nick;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.client.IGuildClientCommonApi;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.guild.util.ac;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProIdentityInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 52\u00020\u0001:\u0001\u001aB\u000f\u0012\u0006\u0010\"\u001a\u00020\u001d\u00a2\u0006\u0004\b3\u00104J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\rH\u0002J\u0012\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0002J\u001a\u0010\u0016\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u001e\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J\u0018\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u000fH\u0016R\u0017\u0010\"\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001b\u0010(\u001a\u00020#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u001b\u0010/\u001a\u00020,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010%\u001a\u0004\b-\u0010.R\u0018\u00102\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u00066"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/component/nick/GuildGameNickItem;", "Lcom/tencent/guild/aio/msglist/holder/component/nick/r;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "", "isRefresh", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProClientIdentityInfo;", "p", "", "w", "clientIdentity", "v", "u", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "height", DomainData.DOMAIN_NAME, "Landroid/widget/ImageView;", "targetView", "", "url", "t", "", "", "payloads", "a", "type", "f", "Landroid/content/Context;", "c", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Landroid/content/Context;", "context", "Landroid/widget/TextView;", "d", "Lkotlin/Lazy;", ReportConstant.COSTREPORT_PREFIX, "()Landroid/widget/TextView;", "mGameView", "e", "Landroid/widget/ImageView;", "mGameImageView", "Landroid/widget/LinearLayout;", "r", "()Landroid/widget/LinearLayout;", "mGameItemLayout", "g", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "curMsgItem", "<init>", "(Landroid/content/Context;)V", tl.h.F, "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildGameNickItem extends r {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mGameView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ImageView mGameImageView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mGameItemLayout;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildMsgItem curMsgItem;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/guild/aio/msglist/holder/component/nick/GuildGameNickItem$b", "Lcom/tencent/mobileqq/guild/picload/listener/GuildPicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "c", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b extends GuildPicStateListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f111573e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str) {
            super(true);
            this.f111573e = str;
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(@NotNull LoadState state, @NotNull Option option) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(option, "option");
            QLog.d("GuildGameNickItem", 2, "loadStatus:" + state + " :" + this.f111573e);
        }
    }

    public GuildGameNickItem(@NotNull Context context) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.guild.aio.msglist.holder.component.nick.GuildGameNickItem$mGameView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                TextView textView = new TextView(GuildGameNickItem.this.getContext());
                textView.setLayoutParams(new LinearLayout.LayoutParams(-2, ViewUtils.dpToPx(13.0f)));
                textView.setTextSize(1, 9.0f);
                textView.setGravity(17);
                textView.setBackgroundResource(R.drawable.guild_aio_game_identity_bg);
                textView.setTextColor(textView.getContext().getResources().getColor(R.color.blc));
                textView.setPadding(ViewUtils.dpToPx(4.0f), 0, ViewUtils.dpToPx(4.0f), 0);
                return textView;
            }
        });
        this.mGameView = lazy;
        this.mGameImageView = new ImageView(context);
        lazy2 = LazyKt__LazyJVMKt.lazy(new GuildGameNickItem$mGameItemLayout$2(this));
        this.mGameItemLayout = lazy2;
    }

    private final void m(View v3) {
        if (v3.getParent() == null) {
            r().addView(v3);
        }
    }

    private final void n(int height) {
        ViewGroup.LayoutParams layoutParams = this.mGameImageView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = ViewUtils.dpToPx(height);
            this.mGameImageView.setLayoutParams(layoutParams);
            this.mGameImageView.setAdjustViewBounds(true);
        }
    }

    static /* synthetic */ void o(GuildGameNickItem guildGameNickItem, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = 13;
        }
        guildGameNickItem.n(i3);
    }

    private final IGProClientIdentityInfo p(GuildMsgItem msgItem, boolean isRefresh) {
        Object obj;
        if (isRefresh) {
            IGProClientIdentityInfo b16 = com.tencent.guild.aio.util.h.f112401a.b(msgItem);
            com.tencent.guild.api.data.msglist.c preParseInfo = msgItem.getPreParseInfo();
            if (b16 == null) {
                obj = "EMPTY_OBJ";
            } else {
                obj = b16;
            }
            preParseInfo.j(obj);
            return b16;
        }
        Object clientIdentity = msgItem.getPreParseInfo().getClientIdentity();
        if (clientIdentity != null) {
            if (clientIdentity instanceof IGProClientIdentityInfo) {
                return (IGProClientIdentityInfo) clientIdentity;
            }
            return null;
        }
        IGProClientIdentityInfo b17 = com.tencent.guild.aio.util.h.f112401a.b(msgItem);
        msgItem.getPreParseInfo().j(b17);
        return b17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LinearLayout r() {
        return (LinearLayout) this.mGameItemLayout.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView s() {
        return (TextView) this.mGameView.getValue();
    }

    private final void t(ImageView targetView, String url) {
        if (targetView != null && !TextUtils.isEmpty(url)) {
            Option loadingDrawable = new Option().setUrl(url).setTargetView(targetView).setLoadingDrawable(new ColorDrawable(0));
            Intrinsics.checkNotNullExpressionValue(loadingDrawable, "Option()\n            .se\u2026rawable(ColorDrawable(0))");
            com.tencent.mobileqq.guild.picload.e.a().f(loadingDrawable, new b(url));
            return;
        }
        QLog.d("GuildGameNickItem", 2, "loadAvatarPicByUrl url is empty");
    }

    private final boolean u(IGProClientIdentityInfo clientIdentity) {
        String value = clientIdentity.getIdentityBytes().getIdentityList().get(0).getValue();
        Intrinsics.checkNotNullExpressionValue(value, "clientIdentity.identityBytes.identityList[0].value");
        if (TextUtils.isEmpty(value)) {
            h(new Function0<Unit>() { // from class: com.tencent.guild.aio.msglist.holder.component.nick.GuildGameNickItem$showIdentityImage$1
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    LinearLayout r16;
                    r16 = GuildGameNickItem.this.r();
                    r16.setVisibility(8);
                }
            });
            QLog.w("GuildGameNickItem", 1, "iconId is null!");
            return false;
        }
        t(this.mGameImageView, ((IGuildClientCommonApi) QRoute.api(IGuildClientCommonApi.class)).getClientIdentityIconPrefix() + value + "-m.png");
        this.mGameImageView.setVisibility(0);
        m(this.mGameImageView);
        o(this, 0, 1, null);
        return true;
    }

    private final boolean v(IGProClientIdentityInfo clientIdentity) {
        String value = clientIdentity.getIdentityBytes().getIdentityList().get(0).getValue();
        Intrinsics.checkNotNullExpressionValue(value, "clientIdentity.identityBytes.identityList[0].value");
        if (TextUtils.isEmpty(value)) {
            h(new Function0<Unit>() { // from class: com.tencent.guild.aio.msglist.holder.component.nick.GuildGameNickItem$showIdentityWord$1
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    LinearLayout r16;
                    r16 = GuildGameNickItem.this.r();
                    r16.setVisibility(8);
                }
            });
            QLog.w("GuildGameNickItem", 1, "desc is null!");
            return false;
        }
        s().setText(value);
        s().setVisibility(0);
        m(s());
        return true;
    }

    private final void w(GuildMsgItem msgItem, boolean isRefresh) {
        h(new Function0<Unit>() { // from class: com.tencent.guild.aio.msglist.holder.component.nick.GuildGameNickItem$update$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                LinearLayout r16;
                r16 = GuildGameNickItem.this.r();
                r16.setVisibility(8);
            }
        });
        IGProClientIdentityInfo p16 = p(msgItem, isRefresh);
        if (p16 == null) {
            QLog.w("GuildGameNickItem", 1, "clientIdentity is null! guildId=" + msgItem.getMsgRecord().guildId + "\uff0c msgSeq: " + msgItem.getMsgSeq() + ", tid: " + msgItem.getMsgRecord().senderUid + ".");
            return;
        }
        IGProIdentityInfo b16 = ac.b(p16.getIdentityBytes());
        if (b16 != null && b16.getIdentityType() == 2) {
            return;
        }
        int a16 = ac.a(p16.getIdentityBytes());
        if (a16 != 0) {
            if (a16 != 1) {
                if (!ac.c(p16)) {
                    return;
                }
                this.mGameImageView.setVisibility(8);
                s().setText(p16.getDesc());
                s().setVisibility(0);
                m(s());
            } else {
                h(new Function0<Unit>() { // from class: com.tencent.guild.aio.msglist.holder.component.nick.GuildGameNickItem$update$2
                    /* JADX INFO: Access modifiers changed from: package-private */
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
                        TextView s16;
                        s16 = GuildGameNickItem.this.s();
                        s16.setVisibility(8);
                    }
                });
                if (!u(p16)) {
                    return;
                }
            }
        } else {
            h(new Function0<Unit>() { // from class: com.tencent.guild.aio.msglist.holder.component.nick.GuildGameNickItem$update$3
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    ImageView imageView;
                    imageView = GuildGameNickItem.this.mGameImageView;
                    imageView.setVisibility(8);
                }
            });
            if (!v(p16)) {
                return;
            }
        }
        r().setVisibility(0);
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.nick.a
    public void a(@NotNull GuildMsgItem msgItem, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        this.curMsgItem = msgItem;
        w(msgItem, false);
        s().setPadding(ViewUtils.dpToPx(6.0f), 0, ViewUtils.dpToPx(6.0f), 0);
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.nick.r
    public void f(@NotNull GuildMsgItem msgItem, int type) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (type == 3) {
            w(msgItem, true);
        }
    }

    @NotNull
    /* renamed from: q, reason: from getter */
    public final Context getContext() {
        return this.context;
    }
}
