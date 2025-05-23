package com.tencent.mobileqq.zplan.aio;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.helper.u;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.mobileqq.zplan.easteregg.w;
import com.tencent.mobileqq.zplan.model.ZPlanHeadEffectFlag;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import le3.ApiPanelEventHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QRouteFactory(singleton = false)
@Metadata(d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&J\b\u0010\u000b\u001a\u00020\u0005H&J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\fH&J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH&J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H&J\u0018\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0013H&J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H&J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H&J\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH&\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010 \u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001cH&J>\u0010(\u001a\u00020\u001c2\b\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&H&J&\u0010-\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010*\u001a\u0004\u0018\u00010)2\b\u0010,\u001a\u0004\u0018\u00010+H&JP\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020:092\u0006\u0010/\u001a\u00020.2\u0006\u00101\u001a\u0002002\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u000e022\u0006\u00104\u001a\u00020\u000e2\u0006\u00106\u001a\u0002052\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u001c07H&J\u001a\u0010?\u001a\u00020\u00052\u0006\u0010=\u001a\u00020<2\b\b\u0002\u0010>\u001a\u00020\u001aH&\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/IZPlanAIOHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/mobileqq/activity/aio/helper/u;", "", "baseChatPie", "", "init", "", "oldPanel", "newPanel", "onPanelChanged", "onAioDoubleTap", "", "bubbleId", "Landroid/view/View;", "getHeadEffectFullView", "onHeadEffectEnd", "Lcom/tencent/mobileqq/data/MessageRecord;", "message", "Lcom/tencent/mobileqq/zplan/model/ZPlanHeadEffectFlag;", "getFlag", "flag", "setFlag", "setUnread", "Lcom/tencent/mobileqq/zplan/easteregg/w;", "getEasterEggPagManager", "", "uin", "", "hasRequestZPlanInfo", "(Ljava/lang/String;)Ljava/lang/Boolean;", "hasRequest", "setRequestZPlanInfoFlag", "Landroidx/fragment/app/Fragment;", "fragment", "entranceType", "uinType", "scaleChatType", "Landroid/os/Bundle;", "bundle", "openMiniMsgAIO", "Lcom/tencent/mobileqq/activity/aio/p;", "sessionInfo", "Lcom/tencent/common/app/AppInterface;", "app", "showEmoticonGrayTipsIfNeed", "Landroid/content/Context;", "context", "Lkotlinx/coroutines/CoroutineScope;", "scope", "", "behindViews", "popupParent", "Lle3/a;", "handler", "Lkotlinx/coroutines/channels/ReceiveChannel;", "drawerIsOpened", "Lkotlin/Pair;", "Lug3/a;", "generatePanelViewAndAdapter", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "tabName", "openPanel", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {""})
/* loaded from: classes21.dex */
public interface IZPlanAIOHelper extends QRouteApi, u {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class a {
        public static /* synthetic */ boolean a(IZPlanAIOHelper iZPlanAIOHelper, Fragment fragment, String str, int i3, int i16, int i17, Bundle bundle, int i18, Object obj) {
            if (obj == null) {
                if ((i18 & 32) != 0) {
                    bundle = null;
                }
                return iZPlanAIOHelper.openMiniMsgAIO(fragment, str, i3, i16, i17, bundle);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openMiniMsgAIO");
        }

        public static /* synthetic */ void b(IZPlanAIOHelper iZPlanAIOHelper, com.tencent.aio.api.runtime.a aVar, String str, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    str = "";
                }
                iZPlanAIOHelper.openPanel(aVar, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openPanel");
        }
    }

    @NotNull
    Pair<View, ug3.a> generatePanelViewAndAdapter(@NotNull Context context, @NotNull CoroutineScope scope, @NotNull List<? extends View> behindViews, @NotNull View popupParent, @NotNull ApiPanelEventHandler handler, @NotNull ReceiveChannel<Boolean> drawerIsOpened);

    @Nullable
    w getEasterEggPagManager();

    @NotNull
    ZPlanHeadEffectFlag getFlag(@NotNull MessageRecord message);

    @Nullable
    View getHeadEffectFullView(long bubbleId);

    @NonNull
    /* synthetic */ String getTag();

    @Nullable
    Boolean hasRequestZPlanInfo(@NotNull String uin);

    void init(@NotNull Object baseChatPie);

    /* synthetic */ int[] interestedIn();

    void onAioDoubleTap();

    void onHeadEffectEnd(long bubbleId);

    @Override // com.tencent.mobileqq.activity.aio.z
    /* synthetic */ void onMoveToState(int i3);

    void onPanelChanged(int oldPanel, int newPanel);

    boolean openMiniMsgAIO(@Nullable Fragment fragment, @NotNull String uin, int entranceType, int uinType, int scaleChatType, @Nullable Bundle bundle);

    void openPanel(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull String tabName);

    void setFlag(@NotNull MessageRecord message, @NotNull ZPlanHeadEffectFlag flag);

    void setRequestZPlanInfoFlag(@NotNull String uin, boolean hasRequest);

    @NotNull
    ZPlanHeadEffectFlag setUnread(@NotNull MessageRecord message);

    void showEmoticonGrayTipsIfNeed(@Nullable MessageRecord message, @Nullable p sessionInfo, @Nullable AppInterface app);
}
