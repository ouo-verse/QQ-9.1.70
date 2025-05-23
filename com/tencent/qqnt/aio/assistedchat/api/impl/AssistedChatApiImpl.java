package com.tencent.qqnt.aio.assistedchat.api.impl;

import android.app.Activity;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.input.base.mvicompat.c;
import com.tencent.input.base.mvicompat.e;
import com.tencent.mobileqq.aio.input.adorn.b;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qqnt.aio.assistedchat.aiservice.AIServiceUtil;
import com.tencent.qqnt.aio.assistedchat.api.IAssistedChatApi;
import com.tencent.qqnt.aio.assistedchat.helper.AssistedChatAIOHelper;
import com.tencent.qqnt.aio.assistedchat.input.AssistedChatInputVBDelegate;
import com.tencent.qqnt.aio.assistedchat.input.d;
import com.tencent.qqnt.aio.assistedchat.panel.AssistedChatPanelContainerVB;
import com.tencent.qqnt.aio.assistedchat.panel.AssistedChatPanelDtReporter;
import com.tencent.qqnt.aio.assistedchat.permission.AssistedChatPermissionDialog;
import com.tencent.qqnt.aio.assistedchat.polish.bottomsectionbar.processor.WriteWhilePolishingProcessor;
import com.tencent.qqnt.aio.assistedchat.topic.bottomsectionbar.RecommendTopicProcessor;
import com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bK\u0010LJ\u0018\u0010\u0005\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u00020\u00040\u0002H\u0016Jd\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062:\u0010\u0012\u001a6\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\fH\u0016J.\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0017H\u0016J.\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0017H\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010\u001f\u001a\u00020\u001dH\u0016J\b\u0010!\u001a\u00020 H\u0016J\b\u0010\"\u001a\u00020 H\u0016J2\u0010*\u001a$\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020(0%j\b\u0012\u0004\u0012\u00020(`)2\u0006\u0010$\u001a\u00020#H\u0016J,\u0010/\u001a\u001e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020+0,j\u0002`.2\u0006\u0010$\u001a\u00020+H\u0016J\u0018\u00100\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J \u00102\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u00101\u001a\u00020\u0006H\u0016J.\u00109\u001a\u00020\u00112\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u00020\b2\u0006\u00106\u001a\u00020-2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u001107H\u0016J\u0018\u0010>\u001a\u00020\u00112\u0006\u0010;\u001a\u00020:2\u0006\u0010=\u001a\u00020<H\u0016J\b\u0010?\u001a\u00020\u0011H\u0016J\u0010\u0010@\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u0006H\u0016JF\u0010J\u001a\b\u0012\u0002\b\u0003\u0018\u00010H2\u0006\u0010;\u001a\u00020A2\u0006\u0010C\u001a\u00020B2\u0006\u0010E\u001a\u00020D2\u0006\u0010F\u001a\u00020\b2\u0016\u0010I\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030H\u0012\u0004\u0012\u00020\u00110GH\u0016\u00a8\u0006M"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/api/impl/AssistedChatApiImpl;", "Lcom/tencent/qqnt/aio/assistedchat/api/IAssistedChatApi;", "Lcom/tencent/aio/base/mvvm/a;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "getAssistedChatPanelVB", "", "chatType", "", "peerUid", "scene", "reportEvent", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "code", "msg", "", "callback", "asyncReportToService", "elementId", "Landroid/view/View;", "view", "", "params", "reportImpEvent", "reportClickEvent", "Lcom/tencent/aio/main/businesshelper/h;", "getAssistedChatHelper", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/processor/BottomSectionBarBaseProcessor;", "getBringTopicProcessor", "getWriteWhilePolishingProcessor", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/adapter/b;", "getBringTopicAdapter", "getWriteWhilePolishingAdapter", "Lcom/tencent/mobileqq/aio/input/adorn/b;", "host", "Lcom/tencent/input/base/mvicompat/c;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/mobileqq/aio/input/inputbar/viewbinding/a;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVBDelegate;", "getAssistedChatInputVBDelegate", "Lcom/tencent/mobileqq/aio/input/adorn/c;", "Lcom/tencent/input/base/mvicompat/e;", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVMDelegate;", "getAssistedChatInputVMDelegate", "getPrologueSayHiEmojiId", "emojiId", "setPrologueSayHiEmojiId", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "tag", "aioContext", "Lkotlin/Function0;", "onAllowListener", "showPermissionFragmentDialog", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lkotlinx/coroutines/CoroutineScope;", "scope", "tryToShowAIServiceDialog", "tryToDismissAIServiceDialog", "activateAIServiceExp", "Landroid/app/Activity;", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "", "showIcon", "dtPageId", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/widget/listitem/a;", "notifyChangedListener", "getAIServiceSettingConfig", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AssistedChatApiImpl implements IAssistedChatApi {
    static IPatchRedirector $redirector_;

    public AssistedChatApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void asyncReportToService$lambda$0(int i3, String peerUid, int i16, int i17, Function2 function2) {
        Intrinsics.checkNotNullParameter(peerUid, "$peerUid");
        com.tencent.qqnt.aio.assistedchat.request.a.f349425a.d(i3, peerUid, i16, i17, function2);
    }

    @Override // com.tencent.qqnt.aio.assistedchat.api.IAssistedChatApi
    public void activateAIServiceExp(int chatType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, chatType);
        } else {
            AIServiceUtil.f349008a.r(chatType);
        }
    }

    @Override // com.tencent.qqnt.aio.assistedchat.api.IAssistedChatApi
    public void asyncReportToService(final int chatType, @NotNull final String peerUid, final int scene, final int reportEvent, @Nullable final Function2<? super Integer, ? super String, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(chatType), peerUid, Integer.valueOf(scene), Integer.valueOf(reportEvent), callback);
        } else {
            Intrinsics.checkNotNullParameter(peerUid, "peerUid");
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.assistedchat.api.impl.a
                @Override // java.lang.Runnable
                public final void run() {
                    AssistedChatApiImpl.asyncReportToService$lambda$0(chatType, peerUid, scene, reportEvent, callback);
                }
            }, 16, null, true);
        }
    }

    @Override // com.tencent.qqnt.aio.assistedchat.api.IAssistedChatApi
    @Nullable
    public com.tencent.mobileqq.widget.listitem.a<?> getAIServiceSettingConfig(@NotNull Activity activity, @NotNull LifecycleOwner lifecycleOwner, boolean showIcon, @NotNull String dtPageId, @NotNull Function1<? super com.tencent.mobileqq.widget.listitem.a<?>, Unit> notifyChangedListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (com.tencent.mobileqq.widget.listitem.a) iPatchRedirector.redirect((short) 19, this, activity, lifecycleOwner, Boolean.valueOf(showIcon), dtPageId, notifyChangedListener);
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(dtPageId, "dtPageId");
        Intrinsics.checkNotNullParameter(notifyChangedListener, "notifyChangedListener");
        return AIServiceUtil.f349008a.t(activity, lifecycleOwner, showIcon, dtPageId, notifyChangedListener);
    }

    @Override // com.tencent.qqnt.aio.assistedchat.api.IAssistedChatApi
    @NotNull
    public h getAssistedChatHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (h) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new AssistedChatAIOHelper();
    }

    @Override // com.tencent.qqnt.aio.assistedchat.api.IAssistedChatApi
    @NotNull
    public c<at.a, InputUIState, b, com.tencent.mobileqq.aio.input.inputbar.viewbinding.a> getAssistedChatInputVBDelegate(@NotNull b host) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (c) iPatchRedirector.redirect((short) 11, (Object) this, (Object) host);
        }
        Intrinsics.checkNotNullParameter(host, "host");
        return new AssistedChatInputVBDelegate(host);
    }

    @Override // com.tencent.qqnt.aio.assistedchat.api.IAssistedChatApi
    @NotNull
    public e<at.a, InputUIState, com.tencent.aio.api.runtime.a, com.tencent.mobileqq.aio.input.adorn.c> getAssistedChatInputVMDelegate(@NotNull com.tencent.mobileqq.aio.input.adorn.c host) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (e) iPatchRedirector.redirect((short) 12, (Object) this, (Object) host);
        }
        Intrinsics.checkNotNullParameter(host, "host");
        return new d(host);
    }

    @Override // com.tencent.qqnt.aio.assistedchat.api.IAssistedChatApi
    @NotNull
    public com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> getAssistedChatPanelVB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new AssistedChatPanelContainerVB();
    }

    @Override // com.tencent.qqnt.aio.assistedchat.api.IAssistedChatApi
    @NotNull
    public com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b getBringTopicAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return new com.tencent.qqnt.aio.assistedchat.topic.bottomsectionbar.c();
    }

    @Override // com.tencent.qqnt.aio.assistedchat.api.IAssistedChatApi
    @NotNull
    public BottomSectionBarBaseProcessor getBringTopicProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (BottomSectionBarBaseProcessor) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return new RecommendTopicProcessor();
    }

    @Override // com.tencent.qqnt.aio.assistedchat.api.IAssistedChatApi
    public int getPrologueSayHiEmojiId(int chatType, @NotNull String peerUid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this, chatType, (Object) peerUid)).intValue();
        }
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        return com.tencent.qqnt.aio.assistedchat.progolue.c.f349416a.b(chatType, peerUid);
    }

    @Override // com.tencent.qqnt.aio.assistedchat.api.IAssistedChatApi
    @NotNull
    public com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b getWriteWhilePolishingAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return new com.tencent.qqnt.aio.assistedchat.polish.bottomsectionbar.h();
    }

    @Override // com.tencent.qqnt.aio.assistedchat.api.IAssistedChatApi
    @NotNull
    public BottomSectionBarBaseProcessor getWriteWhilePolishingProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (BottomSectionBarBaseProcessor) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return new WriteWhilePolishingProcessor();
    }

    @Override // com.tencent.qqnt.aio.assistedchat.api.IAssistedChatApi
    public void reportClickEvent(@NotNull String elementId, @NotNull View view, @Nullable Map<String, String> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, elementId, view, params);
            return;
        }
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Intrinsics.checkNotNullParameter(view, "view");
        AssistedChatPanelDtReporter.f349138a.a(elementId, view, params);
    }

    @Override // com.tencent.qqnt.aio.assistedchat.api.IAssistedChatApi
    public void reportImpEvent(@NotNull String elementId, @NotNull View view, @Nullable Map<String, String> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, elementId, view, params);
            return;
        }
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Intrinsics.checkNotNullParameter(view, "view");
        AssistedChatPanelDtReporter.f349138a.c(elementId, view, params);
    }

    @Override // com.tencent.qqnt.aio.assistedchat.api.IAssistedChatApi
    public void setPrologueSayHiEmojiId(int chatType, @NotNull String peerUid, int emojiId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(chatType), peerUid, Integer.valueOf(emojiId));
        } else {
            Intrinsics.checkNotNullParameter(peerUid, "peerUid");
            com.tencent.qqnt.aio.assistedchat.progolue.c.f349416a.e(chatType, peerUid, emojiId);
        }
    }

    @Override // com.tencent.qqnt.aio.assistedchat.api.IAssistedChatApi
    public void showPermissionFragmentDialog(@NotNull FragmentManager fragmentManager, @NotNull String tag, @NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull Function0<Unit> onAllowListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, fragmentManager, tag, aioContext, onAllowListener);
            return;
        }
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(onAllowListener, "onAllowListener");
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag(tag);
        if (findFragmentByTag != null) {
            fragmentManager.beginTransaction().remove(findFragmentByTag).commitAllowingStateLoss();
        }
        new AssistedChatPermissionDialog(aioContext, onAllowListener).show(fragmentManager, tag);
    }

    @Override // com.tencent.qqnt.aio.assistedchat.api.IAssistedChatApi
    public void tryToDismissAIServiceDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            AIServiceUtil.f349008a.K();
        }
    }

    @Override // com.tencent.qqnt.aio.assistedchat.api.IAssistedChatApi
    public void tryToShowAIServiceDialog(@NotNull FragmentActivity activity, @NotNull CoroutineScope scope) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) activity, (Object) scope);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(scope, "scope");
        AIServiceUtil.f349008a.L(activity, scope);
    }
}
