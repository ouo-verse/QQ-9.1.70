package com.tencent.mobileqq.guild.window;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.media.core.data.TRTCQuality;
import com.tencent.mobileqq.guild.media.core.notify.SwitchThemeEvent;
import com.tencent.mobileqq.guild.media.core.notify.y;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b*\u0001%\b&\u0018\u0000 /2\u00020\u0001:\u00010B\u000f\u0012\u0006\u0010-\u001a\u00020\u0016\u00a2\u0006\u0004\b.\u0010\u001cJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014J\b\u0010\u000b\u001a\u00020\nH&J\u0013\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\f\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0005H\u0014J\u0014\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010H\u0014J\b\u0010\u0013\u001a\u00020\u0005H\u0014J\b\u0010\u0014\u001a\u00020\u0005H\u0014J\b\u0010\u0015\u001a\u00020\u0005H&R\"\u0010\u001d\u001a\u00020\u00168\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010$\u001a\u00020\n8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/guild/window/a;", "Lcom/tencent/mobileqq/guild/window/c;", "", "oldThemeType", "newThemeType", "", "P0", "Landroid/view/ViewGroup;", "customView", "p0", "Lcom/tencent/mobileqq/guild/window/usecase/g;", "O0", "T", "N0", "()Ljava/lang/Object;", "L0", "Lkotlin/Pair;", "", "u0", "A0", "y0", "Q0", "Landroid/content/Context;", UserInfo.SEX_FEMALE, "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mContext", "G", "Lcom/tencent/mobileqq/guild/window/usecase/g;", "M0", "()Lcom/tencent/mobileqq/guild/window/usecase/g;", "R0", "(Lcom/tencent/mobileqq/guild/window/usecase/g;)V", "mUseCase", "com/tencent/mobileqq/guild/window/a$c", "H", "Lcom/tencent/mobileqq/guild/window/a$c;", "switchThemeObserver", "Lcom/tencent/mobileqq/guild/media/core/notify/y;", "I", "Lcom/tencent/mobileqq/guild/media/core/notify/y;", "mAudioRoomObserver", "context", "<init>", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public abstract class a extends com.tencent.mobileqq.guild.window.c {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final float DIP_FLOAT_WINDOW_SIZE = 94.0f;
    public static final float IMG_SIZE = 64.0f;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private Context mContext;

    /* renamed from: G, reason: from kotlin metadata */
    protected com.tencent.mobileqq.guild.window.usecase.g mUseCase;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final c switchThemeObserver;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final y mAudioRoomObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/window/a$a;", "", "Landroid/view/View;", "a", "", "DIP_FLOAT_WINDOW_SIZE", UserInfo.SEX_FEMALE, "IMG_SIZE", "", "QQ_GUILD_AUDIO_SMALL_SCREEN_CENTER_X", "Ljava/lang/String;", "QQ_GUILD_AUDIO_SMALL_SCREEN_CENTER_Y", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.window.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final View a() {
            View inflate = View.inflate(BaseApplication.getContext(), R.layout.egc, null);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n               \u2026       null\n            )");
            return inflate;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000K\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J(\u0010\u0012\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00022\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010H\u0016J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\bH\u0016J0\u0010\u001b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001e\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016\u00a8\u0006\u001f"}, d2 = {"com/tencent/mobileqq/guild/window/a$b", "Lcom/tencent/mobileqq/guild/media/core/notify/y;", "", "guildId", "roomId", "reason", "", "t", "", "canTalk", "", "scene", "o", "channelID", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/media/core/data/TRTCQuality;", "Lkotlin/collections/ArrayList;", "qualityArr", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "userId", "available", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "channelId", "Lcom/tencent/mobileqq/guild/media/core/data/f;", "localUserInfo", "Lcom/tencent/mobileqq/guild/media/core/data/r;", "userInfoList", "w", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class b extends y {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.q
        public void m(@Nullable IGProChannelInfo channelInfo) {
            a.this.M0().l(channelInfo);
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.y
        public void o(boolean canTalk, int scene) {
            a.this.M0().g(canTalk, scene);
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.y
        public void q(@NotNull String channelID, @NotNull ArrayList<TRTCQuality> qualityArr) {
            Intrinsics.checkNotNullParameter(channelID, "channelID");
            Intrinsics.checkNotNullParameter(qualityArr, "qualityArr");
            a.this.M0().h(channelID, qualityArr);
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.y
        public void t(@NotNull String guildId, @NotNull String roomId, @NotNull String reason) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(roomId, "roomId");
            Intrinsics.checkNotNullParameter(reason, "reason");
            a.this.M0().i(guildId, roomId, reason);
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.y
        public void w(@Nullable String guildId, @Nullable String channelId, @Nullable com.tencent.mobileqq.guild.media.core.data.f localUserInfo, @Nullable com.tencent.mobileqq.guild.media.core.data.r userInfoList) {
            a.this.M0().j(guildId, channelId, localUserInfo, userInfoList);
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.y
        public void z(@NotNull String userId, boolean available) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            a.this.M0().k(userId, available);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/window/a$c", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/ar;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class c implements com.tencent.mobileqq.guild.media.core.notify.o<SwitchThemeEvent> {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull SwitchThemeEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            a.this.P0(event.getOldThemeType(), event.getNewThemeType());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        BaseApplication context2 = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.mContext = context2;
        this.switchThemeObserver = new c();
        this.mAudioRoomObserver = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P0(int oldThemeType, int newThemeType) {
        Logger logger = Logger.f235387a;
        String tag = getTag();
        logger.d().i(tag, 1, "onSwitchTheme oldThemeType: " + oldThemeType + ", newThemeType: " + newThemeType);
        GuildFloatWindowManager guildFloatWindowManager = GuildFloatWindowManager.f236656d;
        String name = getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "javaClass.name");
        guildFloatWindowManager.g(name);
        GuildFloatWindowUtils.E(t0(), r0(), newThemeType, x0(), oldThemeType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.window.c
    public void A0() {
        Logger logger = Logger.f235387a;
        logger.d().i(getTag(), 1, "onQuit");
        com.tencent.mobileqq.guild.media.core.j.a().l0().B(this.mAudioRoomObserver);
        com.tencent.mobileqq.guild.media.core.j.d().j(SwitchThemeEvent.class, this.switchThemeObserver);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void L0() {
        com.tencent.mobileqq.guild.media.core.j.a().l0().b(this.mAudioRoomObserver);
        com.tencent.mobileqq.guild.media.core.j.d().V(SwitchThemeEvent.class, this.switchThemeObserver);
    }

    @NotNull
    protected final com.tencent.mobileqq.guild.window.usecase.g M0() {
        com.tencent.mobileqq.guild.window.usecase.g gVar = this.mUseCase;
        if (gVar != null) {
            return gVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mUseCase");
        return null;
    }

    public final <T> T N0() {
        return (T) M0();
    }

    @NotNull
    public abstract com.tencent.mobileqq.guild.window.usecase.g O0();

    public abstract void Q0();

    protected final void R0(@NotNull com.tencent.mobileqq.guild.window.usecase.g gVar) {
        Intrinsics.checkNotNullParameter(gVar, "<set-?>");
        this.mUseCase = gVar;
    }

    @Override // com.tencent.mobileqq.guild.window.c
    protected void p0(@NotNull ViewGroup customView) {
        Intrinsics.checkNotNullParameter(customView, "customView");
        R0(O0());
        M0().b(customView);
        s0().setVisibility(8);
        L0();
    }

    @Override // com.tencent.mobileqq.guild.window.c
    @NotNull
    protected Pair<String, String> u0() {
        return new Pair<>("qq_guild_audio_small_screen_center_x", "qq_guild_audio_small_screen_center_y");
    }

    @Override // com.tencent.mobileqq.guild.window.c
    protected void y0() {
        Q0();
    }
}
