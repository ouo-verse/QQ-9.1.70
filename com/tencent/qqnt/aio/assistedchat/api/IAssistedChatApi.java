package com.tencent.qqnt.aio.assistedchat.api;

import android.app.Activity;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.input.base.mvicompat.c;
import com.tencent.input.base.mvicompat.e;
import com.tencent.mobileqq.aio.input.adorn.b;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u00020\u00040\u0002H&Jh\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062<\b\u0002\u0010\u0012\u001a6\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\fH&J\b\u0010\u0015\u001a\u00020\u0014H&J\b\u0010\u0017\u001a\u00020\u0016H&J\b\u0010\u0018\u001a\u00020\u0016H&J\b\u0010\u001a\u001a\u00020\u0019H&J\b\u0010\u001b\u001a\u00020\u0019H&J0\u0010!\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0016\b\u0002\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u001fH&J0\u0010\"\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0016\b\u0002\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u001fH&J2\u0010*\u001a$\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020(0%j\b\u0012\u0004\u0012\u00020(`)2\u0006\u0010$\u001a\u00020#H&J,\u0010/\u001a\u001e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020+0,j\u0002`.2\u0006\u0010$\u001a\u00020+H&J\u0018\u00100\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J \u00102\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u00101\u001a\u00020\u0006H&J.\u00109\u001a\u00020\u00112\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u00020\b2\u0006\u00106\u001a\u00020-2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u001107H&J\u0018\u0010>\u001a\u00020\u00112\u0006\u0010;\u001a\u00020:2\u0006\u0010=\u001a\u00020<H&J\b\u0010?\u001a\u00020\u0011H&J\u0010\u0010@\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u0006H&JF\u0010J\u001a\b\u0012\u0002\b\u0003\u0018\u00010H2\u0006\u0010;\u001a\u00020A2\u0006\u0010C\u001a\u00020B2\u0006\u0010E\u001a\u00020D2\u0006\u0010F\u001a\u00020\b2\u0016\u0010I\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030H\u0012\u0004\u0012\u00020\u00110GH&\u00a8\u0006K"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/api/IAssistedChatApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/aio/base/mvvm/a;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "getAssistedChatPanelVB", "", "chatType", "", "peerUid", "scene", "reportEvent", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "code", "msg", "", "callback", "asyncReportToService", "Lcom/tencent/aio/main/businesshelper/h;", "getAssistedChatHelper", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/processor/BottomSectionBarBaseProcessor;", "getBringTopicProcessor", "getWriteWhilePolishingProcessor", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/adapter/b;", "getBringTopicAdapter", "getWriteWhilePolishingAdapter", "elementId", "Landroid/view/View;", "view", "", "params", "reportImpEvent", "reportClickEvent", "Lcom/tencent/mobileqq/aio/input/adorn/b;", "host", "Lcom/tencent/input/base/mvicompat/c;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/mobileqq/aio/input/inputbar/viewbinding/a;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVBDelegate;", "getAssistedChatInputVBDelegate", "Lcom/tencent/mobileqq/aio/input/adorn/c;", "Lcom/tencent/input/base/mvicompat/e;", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVMDelegate;", "getAssistedChatInputVMDelegate", "getPrologueSayHiEmojiId", "emojiId", "setPrologueSayHiEmojiId", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "tag", "aioContext", "Lkotlin/Function0;", "onAllowListener", "showPermissionFragmentDialog", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lkotlinx/coroutines/CoroutineScope;", "scope", "tryToShowAIServiceDialog", "tryToDismissAIServiceDialog", "activateAIServiceExp", "Landroid/app/Activity;", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "", "showIcon", "dtPageId", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/widget/listitem/a;", "notifyChangedListener", "getAIServiceSettingConfig", "aio_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IAssistedChatApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class a {
        public static /* synthetic */ void a(IAssistedChatApi iAssistedChatApi, int i3, String str, int i16, int i17, Function2 function2, int i18, Object obj) {
            if (obj == null) {
                if ((i18 & 8) != 0) {
                    i17 = 1;
                }
                int i19 = i17;
                if ((i18 & 16) != 0) {
                    function2 = null;
                }
                iAssistedChatApi.asyncReportToService(i3, str, i16, i19, function2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: asyncReportToService");
        }
    }

    void activateAIServiceExp(int chatType);

    void asyncReportToService(int chatType, @NotNull String peerUid, int scene, int reportEvent, @Nullable Function2<? super Integer, ? super String, Unit> callback);

    @Nullable
    com.tencent.mobileqq.widget.listitem.a<?> getAIServiceSettingConfig(@NotNull Activity activity, @NotNull LifecycleOwner lifecycleOwner, boolean showIcon, @NotNull String dtPageId, @NotNull Function1<? super com.tencent.mobileqq.widget.listitem.a<?>, Unit> notifyChangedListener);

    @NotNull
    h getAssistedChatHelper();

    @NotNull
    c<at.a, InputUIState, b, com.tencent.mobileqq.aio.input.inputbar.viewbinding.a> getAssistedChatInputVBDelegate(@NotNull b host);

    @NotNull
    e<at.a, InputUIState, com.tencent.aio.api.runtime.a, com.tencent.mobileqq.aio.input.adorn.c> getAssistedChatInputVMDelegate(@NotNull com.tencent.mobileqq.aio.input.adorn.c host);

    @NotNull
    com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> getAssistedChatPanelVB();

    @NotNull
    com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b getBringTopicAdapter();

    @NotNull
    BottomSectionBarBaseProcessor getBringTopicProcessor();

    int getPrologueSayHiEmojiId(int chatType, @NotNull String peerUid);

    @NotNull
    com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b getWriteWhilePolishingAdapter();

    @NotNull
    BottomSectionBarBaseProcessor getWriteWhilePolishingProcessor();

    void reportClickEvent(@NotNull String elementId, @NotNull View view, @Nullable Map<String, String> params);

    void reportImpEvent(@NotNull String elementId, @NotNull View view, @Nullable Map<String, String> params);

    void setPrologueSayHiEmojiId(int chatType, @NotNull String peerUid, int emojiId);

    void showPermissionFragmentDialog(@NotNull FragmentManager fragmentManager, @NotNull String tag, @NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull Function0<Unit> onAllowListener);

    void tryToDismissAIServiceDialog();

    void tryToShowAIServiceDialog(@NotNull FragmentActivity activity, @NotNull CoroutineScope scope);
}
