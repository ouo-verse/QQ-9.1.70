package com.tencent.mobileqq.guild.window.usecase;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.utils.au;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.guild.media.core.data.TRTCQuality;
import com.tencent.mobileqq.guild.media.core.data.p;
import com.tencent.mobileqq.guild.media.core.data.r;
import com.tencent.mobileqq.guild.media.widget.GuildMediaChannelRippleView;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010b\u001a\u00020a\u0012\u0006\u0010c\u001a\u00020+\u0012\u0006\u0010e\u001a\u00020d\u00a2\u0006\u0004\bf\u0010gJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u001a\u0010\n\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0012\u0010\u0010\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0002J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u000bH\u0002J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0018H\u0014J\b\u0010\u001c\u001a\u00020\u0007H\u0016J\b\u0010\u001d\u001a\u00020\u0011H\u0014J\b\u0010\u001e\u001a\u00020\u0007H\u0004J(\u0010$\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00112\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020!0 j\b\u0012\u0004\u0012\u00020!`\"H\u0016J\u0018\u0010'\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u000bH\u0016J0\u0010*\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010(\u001a\u0004\u0018\u00010\u00112\b\u0010)\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010-\u001a\u00020\u00072\b\u0010,\u001a\u0004\u0018\u00010+H\u0016J \u00100\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020\u000bH\u0004R\"\u00107\u001a\u00020\u00118\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010>\u001a\u0002088\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b'\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010A\u001a\u0002088\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b$\u00109\u001a\u0004\b?\u0010;\"\u0004\b@\u0010=R\"\u0010I\u001a\u00020B8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\"\u0010P\u001a\u00020J8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b*\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\"\u0010W\u001a\u00020\u00048\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR$\u0010Z\u001a\u0004\u0018\u00010\u00118\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b-\u00102\u001a\u0004\bX\u00104\"\u0004\bY\u00106R\u001a\u0010`\u001a\u00020[8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\u00a8\u0006h"}, d2 = {"Lcom/tencent/mobileqq/guild/window/usecase/e;", "Lcom/tencent/mobileqq/guild/window/usecase/g;", "Lcom/tencent/mobileqq/guild/media/core/data/f;", ITVKPlayerEventListener.KEY_USER_INFO, "", ReportConstant.COSTREPORT_PREFIX, "micState", "", "J", "canOpenMicOnMuting", "t", "", "strRes", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/guild/media/core/data/r;", "userInfoList", BdhLogUtil.LogTag.Tag_Conn, "", "guildId", "tinyId", "Landroid/graphics/drawable/Drawable;", "w", "resId", "O", "Landroid/view/ViewGroup;", "customView", "b", "L", "E", "v", "P", "channelID", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/media/core/data/TRTCQuality;", "Lkotlin/collections/ArrayList;", "qualityArr", tl.h.F, "canTalk", "scene", "g", "channelId", "localUserInfo", "j", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "l", "voiceValue", "voiceGender", "D", "f", "Ljava/lang/String;", "B", "()Ljava/lang/String;", "K", "(Ljava/lang/String;)V", "Tag", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "y", "()Landroid/widget/ImageView;", "G", "(Landroid/widget/ImageView;)V", "mMicView", HippyTKDListViewAdapter.X, UserInfo.SEX_FEMALE, "mAvatarIconView", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Landroid/widget/TextView;", "H", "(Landroid/widget/TextView;)V", "mNetTipsTv", "Lcom/tencent/mobileqq/guild/media/widget/GuildMediaChannelRippleView;", "Lcom/tencent/mobileqq/guild/media/widget/GuildMediaChannelRippleView;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lcom/tencent/mobileqq/guild/media/widget/GuildMediaChannelRippleView;", "I", "(Lcom/tencent/mobileqq/guild/media/widget/GuildMediaChannelRippleView;)V", "mRipple", "k", "Z", "getMLastMicState", "()Z", "setMLastMicState", "(Z)V", "mLastMicState", "getMShowAvatarUserId", "setMShowAvatarUserId", "mShowAvatarUserId", "Lcom/tencent/mobileqq/guild/window/usecase/h;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/window/usecase/h;", "getMMaxVolumeUserManager", "()Lcom/tencent/mobileqq/guild/window/usecase/h;", "mMaxVolumeUserManager", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "mGuildInfo", "mChannelInfo", "Lcom/tencent/mobileqq/guild/window/a;", "wrapper", "<init>", "(Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;Lcom/tencent/mobileqq/guild/window/a;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public class e extends g {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String Tag;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    protected ImageView mMicView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    protected ImageView mAvatarIconView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    protected TextView mNetTipsTv;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    protected GuildMediaChannelRippleView mRipple;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean mLastMicState;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mShowAvatarUserId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final h mMaxVolumeUserManager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull IGProGuildInfo mGuildInfo, @NotNull IGProChannelInfo mChannelInfo, @NotNull com.tencent.mobileqq.guild.window.a wrapper) {
        super(mGuildInfo, mChannelInfo, wrapper);
        Intrinsics.checkNotNullParameter(mGuildInfo, "mGuildInfo");
        Intrinsics.checkNotNullParameter(mChannelInfo, "mChannelInfo");
        Intrinsics.checkNotNullParameter(wrapper, "wrapper");
        this.Tag = "PlainAudioFloatWindowUseCase";
        this.mMaxVolumeUserManager = new h();
    }

    private final void C(r userInfoList) {
        p a16 = this.mMaxVolumeUserManager.a(userInfoList);
        if (a16 == null) {
            this.mShowAvatarUserId = "";
            E();
            return;
        }
        String userId = a16.f228093a;
        if (Intrinsics.areEqual(userId, this.mShowAvatarUserId)) {
            return;
        }
        String guildID = getMGuildInfo().getGuildID();
        Intrinsics.checkNotNullExpressionValue(guildID, "mGuildInfo.guildID");
        Intrinsics.checkNotNullExpressionValue(userId, "userId");
        x().setImageDrawable(w(guildID, userId));
        this.mShowAvatarUserId = userId;
    }

    private final void J(boolean micState) {
        if (this.mLastMicState == micState) {
            return;
        }
        this.mLastMicState = micState;
        if (z().getVisibility() == 0) {
            return;
        }
        if (micState) {
            O(R.drawable.guild_media_mic_on);
        } else {
            O(R.drawable.guild_media_mic_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(e this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger.f235387a.d().i("AudioFloatWindowUseCase", 1, "onClick avatar");
        if (!MediaChannelUtils.M()) {
            QLog.e("AudioFloatWindowUseCase", 1, "requestMediaChannelAVFocus failed.");
        } else {
            this$0.getWrapper().Q0();
            ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).launchMediaChannel(this$0.getMContext(), this$0.getMGuildInfo(), this$0.getMChannelInfo(), com.tencent.mobileqq.guild.media.core.j.a().c0());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(e this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger.f235387a.d().i("AudioFloatWindowUseCase", 1, "onClick close");
        com.tencent.mobileqq.guild.media.core.j.a().D("", "onFloatWindowCloseClick");
        this$0.getWrapper().Q0();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void O(int resId) {
        z().setVisibility(8);
        y().setBackgroundResource(resId);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(200L);
        y().startAnimation(alphaAnimation);
        GuildMediaChannelRippleView A = A();
        Boolean valueOf = Boolean.valueOf(this.mLastMicState);
        A.setVisibility(0);
        if (((View) au.a(valueOf, A)) == null) {
            A.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(e this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z16 = com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo().f228101i;
        this$0.mLastMicState = z16;
        if (z16) {
            this$0.O(R.drawable.guild_media_mic_on);
        } else {
            this$0.O(R.drawable.guild_media_mic_off);
        }
    }

    private final void R(int strRes) {
        z().setText(strRes);
        z().setVisibility(0);
    }

    private final boolean s(com.tencent.mobileqq.guild.media.core.data.f userInfo) {
        return !com.tencent.mobileqq.guild.setting.mute.c.l(getMGuildInfo().getGuildID());
    }

    private final void t(com.tencent.mobileqq.guild.media.core.data.f userInfo, boolean canOpenMicOnMuting) {
        if (userInfo != null && userInfo.f228101i && !canOpenMicOnMuting) {
            com.tencent.mobileqq.guild.media.core.j.a().J().g(false);
            QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
            if (qBaseActivity != null) {
                Intrinsics.checkNotNull(qBaseActivity, "null cannot be cast to non-null type android.app.Activity");
                if (!qBaseActivity.isFinishing()) {
                    QBaseActivity qBaseActivity2 = QBaseActivity.sTopActivity;
                    Intrinsics.checkNotNull(qBaseActivity2, "null cannot be cast to non-null type android.content.Context");
                    DialogUtil.createCustomDialog(qBaseActivity2, 230, (String) null, getMContext().getString(R.string.f142480jh), (String) null, getMContext().getString(R.string.f146610un), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.window.usecase.b
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            e.u(dialogInterface, i3);
                        }
                    }, (DialogInterface.OnClickListener) null).show();
                }
            }
        }
    }

    private final Drawable w(String guildId, String tinyId) {
        Drawable avatarDrawable = ((IQQGuildAvatarApi) ch.S0(IQQGuildAvatarApi.class, "")).getAvatarDrawable(ch.l(), guildId, tinyId);
        Intrinsics.checkNotNullExpressionValue(avatarDrawable, "runtimeService(\n        \u2026rface(), guildId, tinyId)");
        return avatarDrawable;
    }

    @NotNull
    protected final GuildMediaChannelRippleView A() {
        GuildMediaChannelRippleView guildMediaChannelRippleView = this.mRipple;
        if (guildMediaChannelRippleView != null) {
            return guildMediaChannelRippleView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mRipple");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: B, reason: from getter */
    public final String getTag() {
        return this.Tag;
    }

    protected final void D(@NotNull com.tencent.mobileqq.guild.media.core.data.f userInfo, int voiceValue, int voiceGender) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        boolean s16 = s(userInfo);
        boolean z18 = false;
        if (!userInfo.f228118z) {
            if (s16 && !com.tencent.mobileqq.guild.media.core.j.a().C().i0()) {
                s16 = true;
            } else {
                s16 = false;
            }
        }
        if (userInfo.R) {
            if (userInfo.f228101i && s16) {
                z17 = true;
            } else {
                z17 = false;
            }
            J(z17);
        }
        if (A().getIgnoreArealRadius() == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            A().setIgnoreArealRadius(x().getWidth() >> 1);
        }
        GuildMediaChannelRippleView A = A();
        if (voiceGender == 1) {
            z18 = true;
        }
        A.setMale(z18);
        A().setVolume(voiceValue);
        t(userInfo, s16);
    }

    public void E() {
        String v3 = v();
        Logger logger = Logger.f235387a;
        String str = this.Tag;
        logger.d().i(str, 1, "setDefaultAvatar | url: " + v3);
        Drawable avatarDrawable = ((IQQGuildAvatarApi) ch.R0(IQQGuildAvatarApi.class)).getAvatarDrawable(v3, ViewUtils.dip2px(64.0f), ViewUtils.dip2px(64.0f), "audio_float");
        Intrinsics.checkNotNullExpressionValue(avatarDrawable, "runtimeService(\n        \u2026udio_float\"\n            )");
        x().setImageDrawable(avatarDrawable);
    }

    protected final void F(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.mAvatarIconView = imageView;
    }

    protected final void G(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.mMicView = imageView;
    }

    protected final void H(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.mNetTipsTv = textView;
    }

    protected final void I(@NotNull GuildMediaChannelRippleView guildMediaChannelRippleView) {
        Intrinsics.checkNotNullParameter(guildMediaChannelRippleView, "<set-?>");
        this.mRipple = guildMediaChannelRippleView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void K(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.Tag = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void L(@NotNull ViewGroup customView) {
        Intrinsics.checkNotNullParameter(customView, "customView");
        View findViewById = customView.findViewById(R.id.z6b);
        Intrinsics.checkNotNullExpressionValue(findViewById, "customView.findViewById(R.id.mic_view)");
        G((ImageView) findViewById);
        View findViewById2 = customView.findViewById(R.id.t1g);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "customView.findViewById(R.id.avatar_icon)");
        F((ImageView) findViewById2);
        View findViewById3 = customView.findViewById(R.id.zpc);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "customView.findViewById(R.id.net_status)");
        H((TextView) findViewById3);
        View findViewById4 = customView.findViewById(R.id.f74913xj);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "customView.findViewById(R.id.ripple)");
        I((GuildMediaChannelRippleView) findViewById4);
        View findViewById5 = customView.findViewById(R.id.close);
        View findViewById6 = customView.getRootView().findViewById(R.id.m2t);
        findViewById6.setOnClickListener(null);
        findViewById6.setClickable(false);
        x().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.window.usecase.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.M(e.this, view);
            }
        });
        findViewById5.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.window.usecase.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.N(e.this, view);
            }
        });
    }

    protected final void P() {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.window.usecase.a
            @Override // java.lang.Runnable
            public final void run() {
                e.Q(e.this);
            }
        }, 1L);
    }

    @Override // com.tencent.mobileqq.guild.window.usecase.g
    public void b(@NotNull ViewGroup customView) {
        Intrinsics.checkNotNullParameter(customView, "customView");
        L(customView);
        E();
        P();
    }

    @Override // com.tencent.mobileqq.guild.window.usecase.g
    public void h(@NotNull String channelID, @NotNull ArrayList<TRTCQuality> qualityArr) {
        Intrinsics.checkNotNullParameter(channelID, "channelID");
        Intrinsics.checkNotNullParameter(qualityArr, "qualityArr");
        Iterator<TRTCQuality> it = qualityArr.iterator();
        while (it.hasNext()) {
            TRTCQuality next = it.next();
            if (Intrinsics.areEqual(next.getUserId(), com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo().f228093a)) {
                if (next.getCom.tencent.hippy.qq.adapter.image.CustomImageProps.QUALITY java.lang.String() >= 5) {
                    y().setBackgroundResource(R.drawable.guild_audio_net_worst_big);
                    R(R.string.f140550e_);
                    E();
                    return;
                } else if (next.getCom.tencent.hippy.qq.adapter.image.CustomImageProps.QUALITY java.lang.String() >= 3) {
                    y().setBackgroundResource(R.drawable.guild_audio_net_bad_big);
                    R(R.string.f139900ci);
                    E();
                    return;
                } else {
                    if (z().getVisibility() == 0) {
                        z().setVisibility(8);
                        P();
                        return;
                    }
                    return;
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.window.usecase.g
    public void j(@Nullable String guildId, @Nullable String channelId, @Nullable com.tencent.mobileqq.guild.media.core.data.f localUserInfo, @Nullable r userInfoList) {
        if (Intrinsics.areEqual(guildId, getMChannelInfo().getGuildId()) && Intrinsics.areEqual(channelId, getMChannelInfo().getChannelUin()) && localUserInfo != null && userInfoList != null) {
            Logger logger = Logger.f235387a;
            String str = this.Tag;
            if (QLog.isColorLevel()) {
                logger.d().d(str, 2, "onTRTCUserVoiceVolumeUpdate , " + localUserInfo);
            }
            Object obj = null;
            if (localUserInfo.R && userInfoList.f228125a.size() == 0) {
                C(null);
                return;
            }
            List<p> list = userInfoList.f228125a;
            Intrinsics.checkNotNullExpressionValue(list, "userInfoList.anchors");
            Iterator<T> it = list.iterator();
            if (it.hasNext()) {
                obj = it.next();
                if (it.hasNext()) {
                    int i3 = ((p) obj).f228109q;
                    do {
                        Object next = it.next();
                        int i16 = ((p) next).f228109q;
                        if (i3 < i16) {
                            obj = next;
                            i3 = i16;
                        }
                    } while (it.hasNext());
                }
            }
            p pVar = (p) obj;
            if (pVar != null) {
                D(localUserInfo, pVar.f228109q, pVar.f228117y);
            }
            if (z().getVisibility() == 8) {
                C(userInfoList);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.window.usecase.g
    public void l(@Nullable IGProChannelInfo channelInfo) {
        String str;
        Logger.f235387a.d().i("AudioFloatWindowUseCase", 1, "onUserWaitingToSpeak");
        MediaChannelUtils mediaChannelUtils = MediaChannelUtils.f228046a;
        if (channelInfo != null) {
            str = channelInfo.getChannelUin();
        } else {
            str = null;
        }
        if (mediaChannelUtils.u(str)) {
            QQGuildUIUtil.T(80L);
        }
    }

    @NotNull
    protected String v() {
        String avatarUrl = getMGuildInfo().getAvatarUrl(0);
        Intrinsics.checkNotNullExpressionValue(avatarUrl, "mGuildInfo.getAvatarUrl(\u2026atarUrlType.SIZE_DEFAULT)");
        return avatarUrl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final ImageView x() {
        ImageView imageView = this.mAvatarIconView;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mAvatarIconView");
        return null;
    }

    @NotNull
    protected final ImageView y() {
        ImageView imageView = this.mMicView;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mMicView");
        return null;
    }

    @NotNull
    protected final TextView z() {
        TextView textView = this.mNetTipsTv;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mNetTipsTv");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(DialogInterface dialogInterface, int i3) {
    }

    @Override // com.tencent.mobileqq.guild.window.usecase.g
    public void g(boolean canTalk, int scene) {
    }
}
