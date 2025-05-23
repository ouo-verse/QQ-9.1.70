package com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.facade.header.business.onlinemember;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.UiThread;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.setting.member.view.topcard.GuildMemberLoopView;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import vp1.co;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 ,2\u00020\u0001:\u0002\u000f-B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b*\u0010+J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0007J\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001eR\u0016\u0010\"\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010!R\u0016\u0010%\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010$R\u0016\u0010'\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010$R\u0016\u0010)\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010$\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/header/business/onlinemember/GuildOnlineMemberController;", "", "", "from", "", "g", h.F, "Landroid/view/ViewGroup;", "parentView", "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "facadeType", "d", "f", "e", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/header/business/onlinemember/GuildOnlineMemberController$PositionType;", "a", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/header/business/onlinemember/GuildOnlineMemberController$PositionType;", "posType", "b", "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "Landroid/view/ViewStub;", "c", "Landroid/view/ViewStub;", "stubOnlineMemberView", "Landroid/view/View;", "Landroid/view/View;", "memberInfoViewPlaceHolder", "Lvp1/co;", "Lvp1/co;", "binding", "Ljava/lang/String;", "guildId", "", UserInfo.SEX_FEMALE, "viewAlpha", "", "Z", "isVisible", "i", "isShowing", "j", "isResumed", "<init>", "(Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/header/business/onlinemember/GuildOnlineMemberController$PositionType;Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;)V", "k", "PositionType", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildOnlineMemberController {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PositionType posType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GuildFacadeType facadeType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private ViewStub stubOnlineMemberView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View memberInfoViewPlaceHolder;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private co binding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String guildId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private float viewAlpha;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isVisible;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isShowing;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean isResumed;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/header/business/onlinemember/GuildOnlineMemberController$PositionType;", "", "(Ljava/lang/String;I)V", "CHAT_TAB_HEADER", "GUILD_MF_COVER_ABOVE", "GUILD_MF_COVER_STICKY_HEADER", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public enum PositionType {
        CHAT_TAB_HEADER,
        GUILD_MF_COVER_ABOVE,
        GUILD_MF_COVER_STICKY_HEADER
    }

    public GuildOnlineMemberController(@NotNull PositionType posType, @NotNull GuildFacadeType facadeType) {
        String stackTraceToString;
        Intrinsics.checkNotNullParameter(posType, "posType");
        Intrinsics.checkNotNullParameter(facadeType, "facadeType");
        this.posType = posType;
        this.facadeType = facadeType;
        this.guildId = "";
        this.viewAlpha = 1.0f;
        this.isVisible = true;
        this.isShowing = true;
        Logger.a d16 = Logger.f235387a.d();
        stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(new Throwable());
        d16.d("Guild.MF.online.GuildOnlineMemberController", 1, "g_cost createOnlineMember " + stackTraceToString);
    }

    private final void g(String from) {
        if (this.isShowing && this.isResumed) {
            co coVar = this.binding;
            if (coVar == null) {
                Logger.f235387a.d().d("Guild.MF.online.GuildOnlineMemberController", 1, "startAnimationsIfNeed binding.isNotInitialized from:" + from);
                return;
            }
            if (coVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                coVar = null;
            }
            coVar.f442749a.setAnimateEnable(true);
            return;
        }
        Logger.f235387a.d().w("Guild.MF.online.GuildOnlineMemberController", 1, "startAnimationsIfNeed return for isShowing:" + this.isShowing + " isResumed:" + this.isResumed + " from:" + from);
    }

    private final void h(String from) {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.MF.online.GuildOnlineMemberController", 1, "stopAnimations thisId:" + System.identityHashCode(this) + " curGuildId:" + this.guildId + " isShowing:" + this.isShowing + " isResumed:" + this.isResumed + " from:" + from);
        }
        co coVar = this.binding;
        if (coVar == null) {
            logger.d().d("Guild.MF.online.GuildOnlineMemberController", 1, "stopAnimations binding.isNotInitialized from:" + from);
            return;
        }
        if (coVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            coVar = null;
        }
        coVar.f442749a.setAnimateEnable(false);
    }

    @UiThread
    public final void d(@NotNull ViewGroup parentView, @NotNull GuildFacadeType facadeType) {
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        Intrinsics.checkNotNullParameter(facadeType, "facadeType");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.MF.online.GuildOnlineMemberController", 1, "init facadeType:" + facadeType);
        }
        this.facadeType = facadeType;
        View findViewById = parentView.findViewById(R.id.zww);
        Intrinsics.checkNotNullExpressionValue(findViewById, "parentView.findViewById(R.id.onlineMemberViewStub)");
        this.stubOnlineMemberView = (ViewStub) findViewById;
        this.memberInfoViewPlaceHolder = parentView.findViewById(R.id.zwv);
        if (this.binding == null) {
            return;
        }
        co coVar = null;
        if (this.posType == PositionType.GUILD_MF_COVER_STICKY_HEADER && facadeType.isStandaloneStyle()) {
            co coVar2 = this.binding;
            if (coVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                coVar2 = null;
            }
            GuildMemberLoopView guildMemberLoopView = coVar2.f442749a;
            Intrinsics.checkNotNullExpressionValue(guildMemberLoopView, "binding.onlineAvatarList");
            guildMemberLoopView.setVisibility(8);
            co coVar3 = this.binding;
            if (coVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                coVar3 = null;
            }
            coVar3.f442750b.getLayoutParams().height = QQGuildUIUtil.f(12.0f);
            co coVar4 = this.binding;
            if (coVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                coVar = coVar4;
            }
            coVar.f442750b.getLayoutParams().width = QQGuildUIUtil.f(12.0f);
            return;
        }
        co coVar5 = this.binding;
        if (coVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            coVar = coVar5;
        }
        GuildMemberLoopView guildMemberLoopView2 = coVar.f442749a;
        Intrinsics.checkNotNullExpressionValue(guildMemberLoopView2, "binding.onlineAvatarList");
        guildMemberLoopView2.setVisibility(0);
    }

    public final void e() {
        this.isResumed = false;
        h(MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
    }

    public final void f() {
        this.isResumed = true;
        g("onResume");
    }
}
