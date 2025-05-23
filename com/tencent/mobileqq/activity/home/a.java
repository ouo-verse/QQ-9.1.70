package com.tencent.mobileqq.activity.home;

import android.app.Activity;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.ui.ConversationContainer;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.ad.AmsAdTabBannerModule;
import cooperation.ad.AmsAdTabGuideModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b,\u0010-R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\n\u0010\u0012R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u00148F\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0015R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u00178F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001b8F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010!\u001a\u00020\u001f8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010 R\u0017\u0010%\u001a\b\u0018\u00010\"R\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b#\u0010$R\u0011\u0010)\u001a\u00020&8F\u00a2\u0006\u0006\u001a\u0004\b'\u0010(R\u0011\u0010+\u001a\u00020&8F\u00a2\u0006\u0006\u001a\u0004\b*\u0010(\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/activity/home/a;", "", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/activity/home/Conversation;", "a", "Lmqq/util/WeakReference;", tl.h.F, "()Lmqq/util/WeakReference;", "weakConversation", "Lcooperation/ad/AmsAdTabBannerModule;", "b", "Lcooperation/ad/AmsAdTabBannerModule;", "e", "()Lcooperation/ad/AmsAdTabBannerModule;", "tabBannerModule", "Lcooperation/ad/AmsAdTabGuideModule;", "c", "Lcooperation/ad/AmsAdTabGuideModule;", "()Lcooperation/ad/AmsAdTabGuideModule;", "guideModule", "Landroid/app/Activity;", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/ui/ConversationContainer;", "d", "()Lcom/tencent/mobileqq/ui/ConversationContainer;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/view/View;", "f", "()Landroid/view/View;", "title", "Lcooperation/ad/h;", "()Lcooperation/ad/h;", "manager", "Lcom/tencent/mobileqq/activity/home/Conversation$u;", "g", "()Lcom/tencent/mobileqq/activity/home/Conversation$u;", "uiCallback", "", "j", "()Z", "isStudyOrElderMode", "i", "isAllowLandscape", "<init>", "(Lmqq/util/WeakReference;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<Conversation> weakConversation;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AmsAdTabBannerModule tabBannerModule;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AmsAdTabGuideModule guideModule;

    public a(@NotNull WeakReference<Conversation> weakConversation) {
        Intrinsics.checkNotNullParameter(weakConversation, "weakConversation");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) weakConversation);
            return;
        }
        this.weakConversation = weakConversation;
        this.tabBannerModule = new AmsAdTabBannerModule(this);
        this.guideModule = new AmsAdTabGuideModule(this);
    }

    @Nullable
    public final Activity a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Activity) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        Conversation conversation = this.weakConversation.get();
        if (conversation != null) {
            return conversation.getActivity();
        }
        return null;
    }

    @NotNull
    public final AmsAdTabGuideModule b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (AmsAdTabGuideModule) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.guideModule;
    }

    @NotNull
    public final cooperation.ad.h c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (cooperation.ad.h) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return new cooperation.ad.h(this, this.weakConversation);
    }

    @Nullable
    public final ConversationContainer d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ConversationContainer) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        Conversation conversation = this.weakConversation.get();
        if (conversation != null) {
            return conversation.mRootView;
        }
        return null;
    }

    @NotNull
    public final AmsAdTabBannerModule e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (AmsAdTabBannerModule) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.tabBannerModule;
    }

    @Nullable
    public final View f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        Conversation conversation = this.weakConversation.get();
        if (conversation != null) {
            return conversation.getAnimTitle();
        }
        return null;
    }

    @Nullable
    public final Conversation.u g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Conversation.u) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        Conversation conversation = this.weakConversation.get();
        if (conversation != null) {
            return conversation.mUICallBack;
        }
        return null;
    }

    @NotNull
    public final WeakReference<Conversation> h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (WeakReference) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.weakConversation;
    }

    public final boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return AppSetting.o(null);
    }

    public final boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        if (!StudyModeManager.t() && !SimpleUIUtil.isNowElderMode()) {
            return false;
        }
        return true;
    }
}
