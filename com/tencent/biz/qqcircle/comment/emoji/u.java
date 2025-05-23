package com.tencent.biz.qqcircle.comment.emoji;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.emosm.IAIOEmoticonUIHelper;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.popanim.PopOutAnimConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010>\u001a\u00020D\u00a2\u0006\u0004\bH\u0010IJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\fH\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0006\u0010\u001d\u001a\u00020\u001cJ\b\u0010\u001e\u001a\u00020\fH\u0016J\b\u0010\u001f\u001a\u00020\u0002H\u0016J\b\u0010 \u001a\u00020\fH\u0016J\u0014\u0010#\u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\u0014\u0010$\u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\b\u0010%\u001a\u00020\fH\u0016J\b\u0010&\u001a\u00020\u0006H\u0016J\u001a\u0010*\u001a\u00020\f2\b\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010)\u001a\u00020\fH\u0016J\b\u0010+\u001a\u00020\fH\u0016J\u001f\u0010.\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010,2\u0006\u0010-\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b.\u0010/J\b\u00100\u001a\u00020\u0018H\u0016J\b\u00101\u001a\u00020\fH\u0016J\u0012\u00104\u001a\u00020\u00022\b\u00103\u001a\u0004\u0018\u000102H\u0016J\b\u00105\u001a\u00020\fH\u0016J\b\u00107\u001a\u000206H\u0016J\b\u00108\u001a\u00020\fH\u0016J\b\u00109\u001a\u00020\u0002H\u0016J\b\u0010:\u001a\u00020\u0002H\u0016J\b\u0010<\u001a\u00020;H\u0016J\u001c\u0010@\u001a\u00020\u00062\b\u0010>\u001a\u0004\u0018\u00010=2\b\u0010?\u001a\u0004\u0018\u00010;H\u0016J\b\u0010A\u001a\u00020\u0002H\u0016J\b\u0010B\u001a\u00020\fH\u0016J\b\u0010C\u001a\u00020\fH\u0016R\u0017\u0010>\u001a\u00020D8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010E\u001a\u0004\bF\u0010G\u00a8\u0006J"}, d2 = {"Lcom/tencent/biz/qqcircle/comment/emoji/u;", "Lcom/tencent/mobileqq/AIODepend/IPanelInteractionListener;", "", "getPanelIconsBarHeight", "Lcom/tencent/qqnt/aio/shortcutbar/g;", "interceptListener", "", "setPaneliconsInterceptListener", "Landroid/widget/EditText;", "getAIOInput", "removeEmoticonGuideBubble", "panelType", "", "show", "setPaneliconsShowRed", "getCurType", "Lcom/tencent/mobileqq/emosm/IAIOEmoticonUIHelper;", "getAIOEmoticonUIHelper", "Landroid/view/ViewGroup;", "getAIORootView", "editMode", "stickerEditMode", "getPanelChatPieType", "stopAnimationConatiner", "", "getCurFriendUin", "Lcom/tencent/mobileqq/popanim/PopOutAnimConfig;", "getPopOutAnimConfig", "Lcom/tencent/mobileqq/emoticonview/IEmoticonMainPanel;", "a", "supportExtendPanel", "getPanelTargetHeight", "isCurGuildLiveChannel", "", "gestureDetector", "initGestureDetector", "gestureDetectorDestroy", "isHostSafe", "launchAECameraUnit", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "info", "showDescribeInPreview", "isShowEmoTitleInPreview", "isInAio", "T", "id", "getHelper", "(I)Ljava/lang/Object;", "getInputBarText", "isScaleChat", "Landroid/content/Context;", "context", "getStatusBarHeight", "needShowFavAndFunnyPicIcon", "", "getAIOScale", "isRobotAIO", "getAIOHeight", "getAIOWidth", "", "getAIOLocation", "Landroid/view/View;", "view", "location", "getLocationInAIO", "getTitleBarHeight", "isExperiment", "canShowGif", "Lcom/tencent/biz/qqcircle/comment/emoji/b;", "Lcom/tencent/biz/qqcircle/comment/emoji/b;", "getView", "()Lcom/tencent/biz/qqcircle/comment/emoji/b;", "<init>", "(Lcom/tencent/biz/qqcircle/comment/emoji/b;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class u implements IPanelInteractionListener {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b view;

    public u(@NotNull b view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
    }

    @NotNull
    public final IEmoticonMainPanel a() {
        return this.view.getIEmoticonMainPanel();
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public boolean canShowGif() {
        return ud2.a.f438849a.e();
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    @Nullable
    public Object gestureDetectorDestroy(@Nullable Object gestureDetector) {
        return null;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    @Nullable
    public IAIOEmoticonUIHelper getAIOEmoticonUIHelper() {
        return null;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public int getAIOHeight() {
        return 0;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    @NotNull
    public EditText getAIOInput() {
        return this.view.getAIOInput();
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    @NotNull
    public int[] getAIOLocation() {
        return new int[0];
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    @Nullable
    public ViewGroup getAIORootView() {
        return null;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public float getAIOScale() {
        return 0.0f;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public int getAIOWidth() {
        return 0;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    @NotNull
    public String getCurFriendUin() {
        return "";
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public int getCurType() {
        return 10026;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    @Nullable
    public <T> T getHelper(int id5) {
        return null;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    @NotNull
    public String getInputBarText() {
        return "";
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public int getPanelChatPieType() {
        return 0;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public int getPanelIconsBarHeight() {
        return 0;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public int getPanelTargetHeight() {
        return 0;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    @Nullable
    public PopOutAnimConfig getPopOutAnimConfig() {
        return null;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public int getStatusBarHeight(@Nullable Context context) {
        return 0;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public int getTitleBarHeight() {
        return 0;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    @Nullable
    public Object initGestureDetector(@Nullable Object gestureDetector) {
        return null;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public boolean isCurGuildLiveChannel() {
        return false;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public boolean isExperiment() {
        return false;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public boolean isHostSafe() {
        return true;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public boolean isInAio() {
        return false;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public boolean isRobotAIO() {
        return false;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public boolean isScaleChat() {
        return false;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public boolean isShowEmoTitleInPreview(@Nullable EmoticonInfo info, boolean showDescribeInPreview) {
        if (info == null || !showDescribeInPreview || info.type != 7) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public boolean needShowFavAndFunnyPicIcon() {
        return ud2.a.f438849a.c();
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public boolean supportExtendPanel() {
        return true;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public void launchAECameraUnit() {
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public void removeEmoticonGuideBubble() {
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public void stopAnimationConatiner() {
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public void setPaneliconsInterceptListener(@Nullable com.tencent.qqnt.aio.shortcutbar.g interceptListener) {
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public void stickerEditMode(boolean editMode) {
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public void getLocationInAIO(@Nullable View view, @Nullable int[] location) {
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public void setPaneliconsShowRed(int panelType, boolean show) {
    }
}
