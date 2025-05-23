package com.tencent.qqnt.aio.adapter.emoticon;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.aio.data.AIOParam;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.input.base.panelcontainer.h;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.aio.event.ShortCutBarEvent;
import com.tencent.mobileqq.aio.event.ShortcutEventIntent;
import com.tencent.mobileqq.emosm.IAIOEmoticonUIHelper;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.event.EmotionPanelMsgIntent;
import com.tencent.mobileqq.popanim.PopOutAnimConfig;
import com.tencent.mobileqq.popanim.api.INTPopOutAnimConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qqnt.robot.api.IRobotServiceApi;
import com.tencent.widget.immersive.ImmersiveUtils;
import dov.com.qq.im.ae.current.SessionWrap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B3\u0012\u0006\u00102\u001a\u000201\u0012\u0006\u0010F\u001a\u00020\b\u0012\u0006\u0010J\u001a\u00020G\u0012\u0006\u0010M\u001a\u00020\u0010\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010 \u00a2\u0006\u0004\bW\u0010XJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\fH\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001c\u001a\u00020\fH\u0016J\b\u0010\u001d\u001a\u00020\fH\u0016J\b\u0010\u001e\u001a\u00020\u0002H\u0016J\b\u0010\u001f\u001a\u00020\fH\u0016J\u0014\u0010\"\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\u0014\u0010#\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\b\u0010$\u001a\u00020\fH\u0016J\b\u0010%\u001a\u00020\fH\u0016J\b\u0010&\u001a\u00020\u0006H\u0016J\u001a\u0010*\u001a\u00020\f2\b\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010)\u001a\u00020\fH\u0016J\b\u0010+\u001a\u00020\fH\u0016J\u001f\u0010.\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010,2\u0006\u0010-\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b.\u0010/J\b\u00100\u001a\u00020\u0018H\u0016J\u0012\u00103\u001a\u00020\u00022\b\u00102\u001a\u0004\u0018\u000101H\u0016J\b\u00104\u001a\u00020\fH\u0016J\b\u00105\u001a\u00020\fH\u0016J\b\u00107\u001a\u000206H\u0016J\b\u00108\u001a\u00020\u0002H\u0016J\b\u00109\u001a\u00020\u0002H\u0016J\b\u0010;\u001a\u00020:H\u0016J\u001a\u0010?\u001a\u00020\u00062\b\u0010=\u001a\u0004\u0018\u00010<2\u0006\u0010>\u001a\u00020:H\u0016J\b\u0010@\u001a\u00020\u0002H\u0016J\b\u0010A\u001a\u00020\fH\u0016R\u0014\u00102\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010F\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010J\u001a\u00020G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0014\u0010M\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010P\u001a\u0004\u0018\u00010 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010S\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010V\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010U\u00a8\u0006Y"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/emoticon/k;", "Lcom/tencent/mobileqq/AIODepend/IPanelInteractionListener;", "", "getPanelIconsBarHeight", "Lcom/tencent/qqnt/aio/shortcutbar/g;", "interceptListener", "", "setPaneliconsInterceptListener", "Landroid/widget/EditText;", "getAIOInput", "removeEmoticonGuideBubble", "panelType", "", "show", "setPaneliconsShowRed", "getCurType", "Lcom/tencent/mobileqq/emosm/IAIOEmoticonUIHelper;", "getAIOEmoticonUIHelper", "Landroid/view/ViewGroup;", "getAIORootView", "editMode", "stickerEditMode", "getPanelChatPieType", "stopAnimationConatiner", "", "getCurFriendUin", "Lcom/tencent/mobileqq/popanim/PopOutAnimConfig;", "getPopOutAnimConfig", "supportExtendPanel", "isExperiment", "getPanelTargetHeight", "isCurGuildLiveChannel", "", "gestureDetector", "initGestureDetector", "gestureDetectorDestroy", "isHostSafe", "canShowGif", "launchAECameraUnit", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "info", "showDescribeInPreview", "isShowEmoTitleInPreview", "isInAio", "T", "id", "getHelper", "(I)Ljava/lang/Object;", "getInputBarText", "Landroid/content/Context;", "context", "getStatusBarHeight", "isScaleChat", "isRobotAIO", "", "getAIOScale", "getAIOHeight", "getAIOWidth", "", "getAIOLocation", "Landroid/view/View;", "view", "location", "getLocationInAIO", "getTitleBarHeight", "needShowFavAndFunnyPicIcon", "a", "Landroid/content/Context;", "b", "Landroid/widget/EditText;", "editText", "Lcom/tencent/aio/api/runtime/a;", "c", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "d", "Lcom/tencent/mobileqq/emosm/IAIOEmoticonUIHelper;", "emoticonUIHelper", "e", "Ljava/lang/Object;", "panelProvider", "f", "Lcom/tencent/qqnt/aio/shortcutbar/g;", "mInterceptListener", "g", "Lcom/tencent/mobileqq/popanim/PopOutAnimConfig;", "mPopOutAnimConfig", "<init>", "(Landroid/content/Context;Landroid/widget/EditText;Lcom/tencent/aio/api/runtime/a;Lcom/tencent/mobileqq/emosm/IAIOEmoticonUIHelper;Ljava/lang/Object;)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class k implements IPanelInteractionListener {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final EditText editText;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final IAIOEmoticonUIHelper emoticonUIHelper;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Object panelProvider;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.qqnt.aio.shortcutbar.g mInterceptListener;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private PopOutAnimConfig mPopOutAnimConfig;

    public k(Context context, EditText editText, com.tencent.aio.api.runtime.a aioContext, IAIOEmoticonUIHelper emoticonUIHelper, Object obj) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(editText, "editText");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(emoticonUIHelper, "emoticonUIHelper");
        this.context = context;
        this.editText = editText;
        this.aioContext = aioContext;
        this.emoticonUIHelper = emoticonUIHelper;
        this.panelProvider = obj;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public boolean canShowGif() {
        return false;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    /* renamed from: getAIOEmoticonUIHelper, reason: from getter */
    public IAIOEmoticonUIHelper getEmoticonUIHelper() {
        return this.emoticonUIHelper;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public int getAIOHeight() {
        return getAIORootView().getHeight();
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    /* renamed from: getAIOInput, reason: from getter */
    public EditText getEditText() {
        return this.editText;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public ViewGroup getAIORootView() {
        View requireView = this.aioContext.c().requireView();
        Intrinsics.checkNotNull(requireView, "null cannot be cast to non-null type android.view.ViewGroup");
        return (ViewGroup) requireView;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public float getAIOScale() {
        return 1.0f;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public int getAIOWidth() {
        return getAIORootView().getWidth();
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public String getCurFriendUin() {
        return this.aioContext.g().r().c().j();
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public int getCurType() {
        AIOParam g16 = this.aioContext.g();
        Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
        return su3.b.c(g16);
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public String getInputBarText() {
        return getEditText().getText().toString();
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public void getLocationInAIO(View view, int[] location) {
        Intrinsics.checkNotNullParameter(location, "location");
        if (view == null) {
            return;
        }
        view.getLocationInWindow(location);
        if (isScaleChat()) {
            int[] aIOLocation = getAIOLocation();
            location[0] = location[0] - aIOLocation[0];
            location[1] = location[1] - aIOLocation[1];
            float aIOScale = getAIOScale();
            if (aIOScale > 0.0f) {
                int i3 = (int) aIOScale;
                location[0] = location[0] / i3;
                location[1] = location[1] / i3;
            }
        }
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public int getPanelChatPieType() {
        return this.aioContext.g().r().c().e();
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public int getPanelIconsBarHeight() {
        com.tencent.mvi.base.route.k k3 = this.aioContext.e().k(new ShortcutEventIntent.OnGetIconBarHeightIntent());
        com.tencent.mobileqq.aio.event.h hVar = k3 instanceof com.tencent.mobileqq.aio.event.h ? (com.tencent.mobileqq.aio.event.h) k3 : null;
        Integer valueOf = hVar != null ? Integer.valueOf(hVar.a()) : null;
        if (valueOf != null) {
            return valueOf.intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public int getPanelTargetHeight() {
        h.b bVar = (h.b) this.aioContext.e().k(PanelContainerMsgIntent.GetPanelHeightParamMsgIntent.f116806d);
        if (bVar != null) {
            return bVar.a();
        }
        return 750;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public PopOutAnimConfig getPopOutAnimConfig() {
        if (this.mPopOutAnimConfig == null) {
            this.mPopOutAnimConfig = ((INTPopOutAnimConfig) QRoute.api(INTPopOutAnimConfig.class)).getNTPopOutAnimConfig(this.aioContext);
        }
        PopOutAnimConfig popOutAnimConfig = this.mPopOutAnimConfig;
        Intrinsics.checkNotNull(popOutAnimConfig);
        return popOutAnimConfig;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public int getTitleBarHeight() {
        return this.context.getResources().getDimensionPixelSize(R.dimen.f158287c11);
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public boolean isCurGuildLiveChannel() {
        return false;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public boolean isExperiment() {
        if (this.panelProvider == null) {
            return false;
        }
        return QQTheme.isNowSimpleUI();
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public boolean isHostSafe() {
        return true;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public boolean isInAio() {
        return true;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public boolean isRobotAIO() {
        AIOParam g16 = this.aioContext.g();
        Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
        return ((IRobotServiceApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRobotServiceApi.class)).isRobotAIO(String.valueOf(su3.c.a(g16)), Integer.valueOf(this.aioContext.g().r().c().e()));
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public boolean isScaleChat() {
        return this.aioContext.g().l().getBoolean("key_is_scale_chat", false);
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public void launchAECameraUnit() {
        AIOParam g16 = this.aioContext.g();
        Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
        SessionInfo a16 = su3.b.a(g16);
        Bundle bundle = new Bundle();
        bundle.putInt(AECameraConstants.AECAMERA_MODE, 202);
        bundle.putInt(AECameraConstants.VIDEO_STORY_FROM_TYPE, js.a.f410912l.b());
        bundle.putParcelable(AECameraConstants.ARG_SESSION_INFO, new SessionWrap(a16.f179557e, a16.f179563i, a16.f179555d, a16.f179559f));
        IAECameraLauncher iAECameraLauncher = (IAECameraLauncher) QRoute.api(IAECameraLauncher.class);
        Context context = getAIORootView().getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        iAECameraLauncher.launchAECameraUnit((Activity) context, 120, bundle);
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public boolean needShowFavAndFunnyPicIcon() {
        return true;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public void removeEmoticonGuideBubble() {
        this.aioContext.e().h(EmotionPanelMsgIntent.RemoveGuideBubble.f205388d);
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public void setPaneliconsInterceptListener(com.tencent.qqnt.aio.shortcutbar.g interceptListener) {
        this.mInterceptListener = interceptListener;
        this.aioContext.e().h(new ShortCutBarEvent.SetShortcutInterceptListener(interceptListener));
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public boolean supportExtendPanel() {
        return !QQTheme.isNowSimpleUI();
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public int[] getAIOLocation() {
        int[] iArr = new int[2];
        getAIORootView().getLocationInWindow(iArr);
        return iArr;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public int getStatusBarHeight(Context context) {
        if (context != null) {
            return ImmersiveUtils.getStatusBarHeight(context);
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public boolean isShowEmoTitleInPreview(EmoticonInfo info, boolean showDescribeInPreview) {
        return info != null && info.type == 7;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public <T> T getHelper(int id5) {
        if (id5 == 104) {
            return (T) this.panelProvider;
        }
        if (id5 != 105) {
            return null;
        }
        return (T) this.panelProvider;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public void stopAnimationConatiner() {
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public Object gestureDetectorDestroy(Object gestureDetector) {
        return gestureDetector;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public Object initGestureDetector(Object gestureDetector) {
        return gestureDetector;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public void stickerEditMode(boolean editMode) {
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public void setPaneliconsShowRed(int panelType, boolean show) {
    }
}
