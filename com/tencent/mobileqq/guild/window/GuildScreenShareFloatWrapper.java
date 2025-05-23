package com.tencent.mobileqq.guild.window;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi;
import com.tencent.mobileqq.guild.media.core.notify.y;
import com.tencent.mobileqq.guild.media.widget.MediaChannelDialogFragment;
import com.tencent.mobileqq.guild.media.widget.bd;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\t*\u0001-\u0018\u0000 32\u00020\u0001:\u00014B\u000f\u0012\u0006\u0010$\u001a\u00020\u001f\u00a2\u0006\u0004\b1\u00102J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001c\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\u001c\u0010\u000e\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u0011H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0014J\b\u0010\u001a\u001a\u00020\u0004H\u0014J\b\u0010\u001b\u001a\u00020\u0004H\u0014J\b\u0010\u001c\u001a\u00020\u0004H\u0014J\b\u0010\u001d\u001a\u00020\u0004H\u0016J\b\u0010\u001e\u001a\u00020\u0004H\u0014R\u0017\u0010$\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/guild/window/GuildScreenShareFloatWrapper;", "Lcom/tencent/mobileqq/guild/window/GuildLiveChannelFloatWrapper;", "", "reason", "", "t1", "Lcom/tencent/mobileqq/guild/media/core/data/f;", "localUserInfo", "Lcom/tencent/mobileqq/guild/media/core/data/r;", "userInfoList", ICustomDataEditor.STRING_PARAM_1, "r1", "", "report", "o1", "p1", "q1", "Landroid/view/View;", "view", NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/qqfloatingwindow/FloatingScreenParams;", "floatParams", "customView", "", "j", "A0", "y0", "Z0", "j1", "initStatusReceiver", "g1", "Landroid/content/Context;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/ImageView;", "micView", "Lcom/tencent/mobileqq/guild/media/widget/bd;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/guild/media/widget/bd;", "mMicOnDrawable", "com/tencent/mobileqq/guild/window/GuildScreenShareFloatWrapper$c", "T", "Lcom/tencent/mobileqq/guild/window/GuildScreenShareFloatWrapper$c;", "mAudioRoomObserver", "<init>", "(Landroid/content/Context;)V", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class GuildScreenShareFloatWrapper extends GuildLiveChannelFloatWrapper {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String TAG = "GuildScreenShareFloatWrapper";

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private ImageView micView;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private bd mMicOnDrawable;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final c mAudioRoomObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/window/GuildScreenShareFloatWrapper$a;", "", "", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.window.GuildScreenShareFloatWrapper$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a() {
            GuildFloatWindowManager guildFloatWindowManager = GuildFloatWindowManager.f236656d;
            String name = GuildScreenShareFloatWrapper.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "GuildScreenShareFloatWrapper::class.java.name");
            guildFloatWindowManager.g(name);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/window/GuildScreenShareFloatWrapper$b", "Lgh2/f;", "", "c", "a", "", "canPlay", "d", "b", "e", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class b implements gh2.f {
        b() {
        }

        @Override // gh2.f
        public void a() {
            QLog.i(GuildScreenShareFloatWrapper.TAG, 1, "onWindowHide:");
            GuildScreenShareFloatWrapper.this.U(false);
        }

        @Override // gh2.f
        public void b() {
            QLog.i(GuildScreenShareFloatWrapper.TAG, 1, "onWindowDismiss:");
        }

        @Override // gh2.f
        public void c() {
            QLog.i(GuildScreenShareFloatWrapper.TAG, 1, "onWindowPause:");
        }

        @Override // gh2.f
        public void d(boolean canPlay) {
            QLog.i(GuildScreenShareFloatWrapper.TAG, 1, "onWindowShow: canPlay[" + canPlay + "]");
            if (!GuildScreenShareFloatWrapper.this.t() && GuildScreenShareFloatWrapper.this.u() != 0) {
                GuildScreenShareFloatWrapper.this.U(true);
            }
        }

        @Override // gh2.f
        public void e() {
            QLog.i(GuildScreenShareFloatWrapper.TAG, 1, "onWindowResume:");
            if (!GuildScreenShareFloatWrapper.this.t() && GuildScreenShareFloatWrapper.this.u() != 0) {
                GuildScreenShareFloatWrapper.this.U(true);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J0\u0010\u000e\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\"\u0010\u0012\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J&\u0010\u0015\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0016"}, d2 = {"com/tencent/mobileqq/guild/window/GuildScreenShareFloatWrapper$c", "Lcom/tencent/mobileqq/guild/media/core/notify/y;", "", "userId", "", "available", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "guildId", "channelId", "Lcom/tencent/mobileqq/guild/media/core/data/f;", "localUserInfo", "Lcom/tencent/mobileqq/guild/media/core/data/r;", "userInfoList", "w", "", "width", "height", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "roomId", "reason", "t", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class c extends y {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.y
        public void A(@Nullable String userId, int width, int height) {
            boolean z16;
            com.tencent.mobileqq.guild.safety.j.d(GuildScreenShareFloatWrapper.TAG, "onUserVideoSizeChange | width: " + width + " | height: " + height);
            GuildScreenShareFloatWrapper guildScreenShareFloatWrapper = GuildScreenShareFloatWrapper.this;
            if (width > height) {
                z16 = true;
            } else {
                z16 = false;
            }
            guildScreenShareFloatWrapper.W0(z16);
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.y
        public void t(@Nullable String guildId, @Nullable String roomId, @Nullable String reason) {
            QLog.i(GuildScreenShareFloatWrapper.TAG, 1, "onExit guildId=" + guildId + ", roomId=" + roomId + "\uff0c reason=" + reason);
            if (Intrinsics.areEqual(guildId, GuildScreenShareFloatWrapper.this.t0().getGuildID()) && Intrinsics.areEqual(roomId, GuildScreenShareFloatWrapper.this.r0().getChannelUin())) {
                GuildScreenShareFloatWrapper.this.t1(reason);
                GuildScreenShareFloatWrapper.INSTANCE.a();
            }
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.y
        public void w(@Nullable String guildId, @Nullable String channelId, @Nullable com.tencent.mobileqq.guild.media.core.data.f localUserInfo, @Nullable com.tencent.mobileqq.guild.media.core.data.r userInfoList) {
            GuildScreenShareFloatWrapper.this.s1(localUserInfo, userInfoList);
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.y
        public void z(@Nullable String userId, boolean available) {
            com.tencent.mobileqq.guild.safety.j.d(GuildScreenShareFloatWrapper.TAG, "onUserVideoAvailable | userId: " + userId + " | available: " + available);
            if (!available) {
                GuildScreenShareFloatWrapper.this.p1();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScreenShareFloatWrapper(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.mAudioRoomObserver = new c();
        J0(TAG);
    }

    private final void o1(String reason, boolean report) {
        String str;
        if (reason == null) {
            str = "handleClose " + report;
        } else {
            str = reason;
        }
        com.tencent.mobileqq.guild.safety.j.d(TAG, str);
        c1(true);
        com.tencent.mobileqq.guild.media.core.j.a().D("", reason);
        GuildFloatWindowManager guildFloatWindowManager = GuildFloatWindowManager.f236656d;
        String name = GuildScreenShareFloatWrapper.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "GuildScreenShareFloatWrapper::class.java.name");
        guildFloatWindowManager.g(name);
        if (report) {
            com.tencent.mobileqq.qqfloatingwindow.b.d();
        }
        c1(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p1() {
        GuildFloatWindowManager guildFloatWindowManager = GuildFloatWindowManager.f236656d;
        String name = GuildScreenShareFloatWrapper.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "GuildScreenShareFloatWrapper::class.java.name");
        guildFloatWindowManager.g(name);
        GuildFloatWindowUtils.t(t0(), r0(), QBaseActivity.mAppForground);
    }

    private final void q1() {
        s1(com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo(), com.tencent.mobileqq.guild.media.core.j.c().getUserInfoList());
    }

    private final void r1() {
        com.tencent.mobileqq.guild.safety.j.d(TAG, "openScreenShare");
        c1(true);
        ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).launchMediaChannel(BaseApplication.context, t0(), r0(), com.tencent.mobileqq.guild.media.core.j.a().c0());
        GuildFloatWindowManager guildFloatWindowManager = GuildFloatWindowManager.f236656d;
        String name = GuildScreenShareFloatWrapper.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "GuildScreenShareFloatWrapper::class.java.name");
        guildFloatWindowManager.g(name);
        c1(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s1(com.tencent.mobileqq.guild.media.core.data.f localUserInfo, com.tencent.mobileqq.guild.media.core.data.r userInfoList) {
        boolean z16;
        List<com.tencent.mobileqq.guild.media.core.data.p> list;
        int collectionSizeOrDefault;
        Comparable maxOrNull;
        if (localUserInfo != null && this.micView != null) {
            boolean z17 = true;
            int i3 = 0;
            if (!com.tencent.mobileqq.guild.setting.mute.c.l(t0().getGuildID()) && !com.tencent.mobileqq.guild.media.core.j.a().C().i0()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (localUserInfo.R) {
                if (!localUserInfo.f228101i || !z16) {
                    z17 = false;
                }
                if (z17) {
                    bd bdVar = this.mMicOnDrawable;
                    if (bdVar != null) {
                        if (userInfoList != null && (list = userInfoList.f228125a) != null) {
                            List<com.tencent.mobileqq.guild.media.core.data.p> list2 = list;
                            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                            Iterator<T> it = list2.iterator();
                            while (it.hasNext()) {
                                arrayList.add(Integer.valueOf(((com.tencent.mobileqq.guild.media.core.data.p) it.next()).f228109q));
                            }
                            maxOrNull = CollectionsKt___CollectionsKt.maxOrNull((Iterable<? extends Comparable>) arrayList);
                            Integer num = (Integer) maxOrNull;
                            if (num != null) {
                                i3 = num.intValue();
                            }
                        }
                        bdVar.k(i3);
                    }
                    ImageView imageView = this.micView;
                    if (imageView != null) {
                        imageView.setBackground(this.mMicOnDrawable);
                        return;
                    }
                    return;
                }
                ImageView imageView2 = this.micView;
                if (imageView2 != null) {
                    imageView2.setBackgroundResource(R.drawable.guild_media_mic_off_press);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t1(String reason) {
        if (StringUtil.isEmpty(reason)) {
            return;
        }
        String h16 = cw.h(R.string.f146610un);
        MediaChannelDialogFragment.Companion companion = MediaChannelDialogFragment.INSTANCE;
        if (reason == null) {
            reason = "";
        }
        companion.a(reason, h16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.window.GuildLiveChannelFloatWrapper, com.tencent.mobileqq.guild.window.c
    public void A0() {
        super.A0();
        this.micView = null;
        this.mMicOnDrawable = null;
    }

    @Override // com.tencent.mobileqq.guild.window.GuildLiveChannelFloatWrapper
    protected void Z0() {
        com.tencent.mobileqq.guild.media.core.j.a().l0().b(this.mAudioRoomObserver);
    }

    @Override // com.tencent.mobileqq.guild.window.c, com.tencent.mobileqq.qqfloatingwindow.a, fh2.a
    public void initStatusReceiver() {
        g(-1, new b());
    }

    @Override // com.tencent.mobileqq.guild.window.GuildLiveChannelFloatWrapper, com.tencent.mobileqq.guild.window.c, com.tencent.mobileqq.qqfloatingwindow.a
    public int j(@Nullable FloatingScreenParams floatParams, @NotNull View customView) {
        Intrinsics.checkNotNullParameter(customView, "customView");
        int j3 = super.j(floatParams, customView);
        this.micView = (ImageView) customView.findViewById(R.id.wzf);
        this.mMicOnDrawable = new bd(this.context, ViewUtils.dpToPx(23.0f), ViewUtils.dpToPx(23.0f));
        if (com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo().f228103k) {
            i0(false, this.H);
        }
        q1();
        return j3;
    }

    @Override // com.tencent.mobileqq.guild.window.GuildLiveChannelFloatWrapper
    protected void j1() {
        com.tencent.mobileqq.guild.media.core.j.a().l0().B(this.mAudioRoomObserver);
    }

    @Override // com.tencent.mobileqq.guild.window.GuildLiveChannelFloatWrapper, com.tencent.mobileqq.qqfloatingwindow.a, android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.M) {
            QLog.i(TAG, 1, "onClick: action processing.");
        } else {
            Intrinsics.checkNotNull(view);
            int id5 = view.getId();
            if (id5 == tp1.a.e()) {
                r1();
            } else if (id5 == tp1.a.d()) {
                o1("onFloatWindowCloseClick", true);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.guild.window.GuildLiveChannelFloatWrapper, com.tencent.mobileqq.guild.window.c
    protected void y0() {
        o1("onForceClose: force close screen share", false);
    }

    @Override // com.tencent.mobileqq.guild.window.GuildLiveChannelFloatWrapper
    protected void g1() {
    }
}
