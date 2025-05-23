package com.tencent.mobileqq.activity.home;

import android.app.Activity;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppPullInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.ui.ConversationContainer;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b#\u0010$R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000e\u001a\u00020\f8F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\rR\u0011\u0010\u0012\u001a\u00020\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0016\u001a\u00020\u00138F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u001a\u001a\u00020\u00178F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001b8F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0015\u0010\"\u001a\u00060\u001fR\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/activity/home/ak;", "", "Lcom/tencent/mobileqq/activity/home/Conversation;", "a", "Lcom/tencent/mobileqq/activity/home/Conversation;", "c", "()Lcom/tencent/mobileqq/activity/home/Conversation;", "conversation", "Lcom/tencent/mobileqq/app/QQAppInterface;", "b", "()Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Landroid/app/Activity;", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/ui/ConversationContainer;", "e", "()Lcom/tencent/mobileqq/ui/ConversationContainer;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/view/View;", "f", "()Landroid/view/View;", "title", "", "g", "()I", "titleHeight", "Lcom/tencent/mobileqq/mini/entry/MiniAppPullInterface;", "d", "()Lcom/tencent/mobileqq/mini/entry/MiniAppPullInterface;", "miniAppEntry", "Lcom/tencent/mobileqq/activity/home/Conversation$u;", tl.h.F, "()Lcom/tencent/mobileqq/activity/home/Conversation$u;", "uiCallback", "<init>", "(Lcom/tencent/mobileqq/activity/home/Conversation;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class ak {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Conversation conversation;

    public ak(@NotNull Conversation conversation) {
        Intrinsics.checkNotNullParameter(conversation, "conversation");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) conversation);
        } else {
            this.conversation = conversation;
        }
    }

    @NotNull
    public final Activity a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Activity) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        QBaseActivity activity = this.conversation.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "conversation.activity");
        return activity;
    }

    @NotNull
    public final QQAppInterface b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (QQAppInterface) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        QQAppInterface app = this.conversation.getApp();
        Intrinsics.checkNotNullExpressionValue(app, "conversation.getApp()");
        return app;
    }

    @NotNull
    public final Conversation c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Conversation) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.conversation;
    }

    @Nullable
    public final MiniAppPullInterface d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (MiniAppPullInterface) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.conversation.getMiniAppPullInterface();
    }

    @NotNull
    public final ConversationContainer e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ConversationContainer) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        ConversationContainer conversationContainer = this.conversation.mRootView;
        Intrinsics.checkNotNullExpressionValue(conversationContainer, "conversation.mRootView");
        return conversationContainer;
    }

    @NotNull
    public final View f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        View animTitle = this.conversation.getAnimTitle();
        Intrinsics.checkNotNullExpressionValue(animTitle, "conversation.animTitle");
        return animTitle;
    }

    public final int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.conversation.getAnimTitle().getHeight();
    }

    @NotNull
    public final Conversation.u h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Conversation.u) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        Conversation.u uVar = this.conversation.mUICallBack;
        Intrinsics.checkNotNullExpressionValue(uVar, "conversation.mUICallBack");
        return uVar;
    }
}
