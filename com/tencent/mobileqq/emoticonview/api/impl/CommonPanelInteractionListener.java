package com.tencent.mobileqq.emoticonview.api.impl;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.emosm.IAIOEmoticonUIHelper;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.api.ICommonPanelInteractionView;
import com.tencent.mobileqq.popanim.PopOutAnimConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.shortcutbar.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010?\u001a\u00020D\u00a2\u0006\u0004\bH\u0010IJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\fH\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0006\u0010\u001d\u001a\u00020\u001cJ\b\u0010\u001e\u001a\u00020\fH\u0016J\b\u0010\u001f\u001a\u00020\u0002H\u0016J\b\u0010 \u001a\u00020\fH\u0016J\u0014\u0010#\u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\u0014\u0010$\u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\b\u0010%\u001a\u00020\fH\u0016J\b\u0010&\u001a\u00020\u0006H\u0016J\u001a\u0010*\u001a\u00020\f2\b\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010)\u001a\u00020\fH\u0016J\b\u0010+\u001a\u00020\fH\u0016J\u001f\u0010.\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010,2\u0006\u0010-\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b.\u0010/J\b\u00100\u001a\u00020\u0018H\u0016J\b\u00101\u001a\u00020\fH\u0016J\u0012\u00104\u001a\u00020\u00022\b\u00103\u001a\u0004\u0018\u000102H\u0016J\b\u00105\u001a\u00020\fH\u0016J\b\u00106\u001a\u00020\fH\u0016J\b\u00108\u001a\u000207H\u0016J\b\u00109\u001a\u00020\fH\u0016J\b\u0010:\u001a\u00020\u0002H\u0016J\b\u0010;\u001a\u00020\u0002H\u0016J\b\u0010=\u001a\u00020<H\u0016J\u001c\u0010A\u001a\u00020\u00062\b\u0010?\u001a\u0004\u0018\u00010>2\b\u0010@\u001a\u0004\u0018\u00010<H\u0016J\b\u0010B\u001a\u00020\u0002H\u0016J\b\u0010C\u001a\u00020\fH\u0016R\u0017\u0010?\u001a\u00020D8\u0006\u00a2\u0006\f\n\u0004\b?\u0010E\u001a\u0004\bF\u0010G\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/api/impl/CommonPanelInteractionListener;", "Lcom/tencent/mobileqq/AIODepend/IPanelInteractionListener;", "", "getPanelIconsBarHeight", "Lcom/tencent/qqnt/aio/shortcutbar/g;", "interceptListener", "", "setPaneliconsInterceptListener", "Landroid/widget/EditText;", "getAIOInput", "removeEmoticonGuideBubble", "panelType", "", "show", "setPaneliconsShowRed", "getCurType", "Lcom/tencent/mobileqq/emosm/IAIOEmoticonUIHelper;", "getAIOEmoticonUIHelper", "Landroid/view/ViewGroup;", "getAIORootView", "editMode", "stickerEditMode", "getPanelChatPieType", "stopAnimationConatiner", "", "getCurFriendUin", "Lcom/tencent/mobileqq/popanim/PopOutAnimConfig;", "getPopOutAnimConfig", "Lcom/tencent/mobileqq/emoticonview/IEmoticonMainPanel;", "getIEmoticonMainPanel", "supportExtendPanel", "getPanelTargetHeight", "isCurGuildLiveChannel", "", "gestureDetector", "initGestureDetector", "gestureDetectorDestroy", "isHostSafe", "launchAECameraUnit", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "info", "showDescribeInPreview", "isShowEmoTitleInPreview", "isInAio", "T", "id", "getHelper", "(I)Ljava/lang/Object;", "getInputBarText", "isScaleChat", "Landroid/content/Context;", "context", "getStatusBarHeight", "needShowFavAndFunnyPicIcon", "canShowGif", "", "getAIOScale", "isRobotAIO", "getAIOHeight", "getAIOWidth", "", "getAIOLocation", "Landroid/view/View;", "view", "location", "getLocationInAIO", "getTitleBarHeight", "isExperiment", "Lcom/tencent/mobileqq/emoticonview/api/ICommonPanelInteractionView;", "Lcom/tencent/mobileqq/emoticonview/api/ICommonPanelInteractionView;", "getView", "()Lcom/tencent/mobileqq/emoticonview/api/ICommonPanelInteractionView;", "<init>", "(Lcom/tencent/mobileqq/emoticonview/api/ICommonPanelInteractionView;)V", "qqemoticonpanel-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class CommonPanelInteractionListener implements IPanelInteractionListener {
    static IPatchRedirector $redirector_;

    @NotNull
    private final ICommonPanelInteractionView view;

    public CommonPanelInteractionListener(@NotNull ICommonPanelInteractionView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
        } else {
            this.view = view;
        }
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public boolean canShowGif() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    @Nullable
    public Object gestureDetectorDestroy(@Nullable Object gestureDetector) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return iPatchRedirector.redirect((short) 21, (Object) this, gestureDetector);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    @Nullable
    public IAIOEmoticonUIHelper getAIOEmoticonUIHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (IAIOEmoticonUIHelper) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public int getAIOHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Integer) iPatchRedirector.redirect((short) 34, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    @NotNull
    public EditText getAIOInput() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (EditText) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.view.getAIOInput();
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    @NotNull
    public int[] getAIOLocation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (int[]) iPatchRedirector.redirect((short) 36, (Object) this);
        }
        return new int[0];
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    @Nullable
    public ViewGroup getAIORootView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ViewGroup) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public float getAIOScale() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Float) iPatchRedirector.redirect((short) 32, (Object) this)).floatValue();
        }
        return 0.0f;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public int getAIOWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Integer) iPatchRedirector.redirect((short) 35, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    @NotNull
    public String getCurFriendUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return "";
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public int getCurType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    @Nullable
    public <T> T getHelper(int id5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (T) iPatchRedirector.redirect((short) 26, (Object) this, id5);
        }
        return null;
    }

    @NotNull
    public final IEmoticonMainPanel getIEmoticonMainPanel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (IEmoticonMainPanel) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.view.getIEmoticonMainPanel();
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    @NotNull
    public String getInputBarText() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (String) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        return "";
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public void getLocationInAIO(@Nullable View view, @Nullable int[] location) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) view, (Object) location);
        }
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public int getPanelChatPieType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public int getPanelIconsBarHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public int getPanelTargetHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    @Nullable
    public PopOutAnimConfig getPopOutAnimConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (PopOutAnimConfig) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public int getStatusBarHeight(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Integer) iPatchRedirector.redirect((short) 29, (Object) this, (Object) context)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public int getTitleBarHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Integer) iPatchRedirector.redirect((short) 38, (Object) this)).intValue();
        }
        return 0;
    }

    @NotNull
    public final ICommonPanelInteractionView getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ICommonPanelInteractionView) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.view;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    @Nullable
    public Object initGestureDetector(@Nullable Object gestureDetector) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return iPatchRedirector.redirect((short) 20, (Object) this, gestureDetector);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public boolean isCurGuildLiveChannel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public boolean isExperiment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Boolean) iPatchRedirector.redirect((short) 39, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public boolean isHostSafe() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public boolean isInAio() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public boolean isRobotAIO() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public boolean isScaleChat() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public boolean isShowEmoTitleInPreview(@Nullable EmoticonInfo info, boolean showDescribeInPreview) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, this, info, Boolean.valueOf(showDescribeInPreview))).booleanValue();
        }
        if (info != null && showDescribeInPreview && info.type == 7) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public void launchAECameraUnit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public boolean needShowFavAndFunnyPicIcon() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public void removeEmoticonGuideBubble() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public void setPaneliconsInterceptListener(@Nullable g interceptListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) interceptListener);
        }
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public void setPaneliconsShowRed(int panelType, boolean show) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(panelType), Boolean.valueOf(show));
        }
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public void stickerEditMode(boolean editMode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, editMode);
        }
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public void stopAnimationConatiner() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public boolean supportExtendPanel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        return true;
    }
}
