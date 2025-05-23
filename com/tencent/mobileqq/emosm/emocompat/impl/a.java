package com.tencent.mobileqq.emosm.emocompat.impl;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.emosm.IAIOEmoticonUIHelper;
import com.tencent.mobileqq.emosm.emocompat.QQEmoticonPanelProvider;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.popanim.PopOutAnimConfig;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.shortcutbar.g;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a implements IPanelInteractionListener {

    /* renamed from: d, reason: collision with root package name */
    private static String f204283d = "AIO2PanelInteractionListener";

    /* renamed from: a, reason: collision with root package name */
    int f204284a = 0;

    /* renamed from: b, reason: collision with root package name */
    private g f204285b;

    /* renamed from: c, reason: collision with root package name */
    private QQEmoticonPanelProvider f204286c;

    public a(QQEmoticonPanelProvider qQEmoticonPanelProvider) {
        this.f204286c = qQEmoticonPanelProvider;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public boolean canShowGif() {
        return true;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    /* renamed from: getAIOEmoticonUIHelper */
    public IAIOEmoticonUIHelper getEmoticonUIHelper() {
        return this.f204286c;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public int getAIOHeight() {
        return 0;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    /* renamed from: getAIOInput */
    public EditText getEditText() {
        QQEmoticonPanelProvider qQEmoticonPanelProvider = this.f204286c;
        if (qQEmoticonPanelProvider != null) {
            return qQEmoticonPanelProvider.h();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public int[] getAIOLocation() {
        return new int[0];
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
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
    public String getCurFriendUin() {
        return this.f204286c.q();
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public int getCurType() {
        return 10014;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public <T> T getHelper(int i3) {
        QLog.i(f204283d, 4, "getHelper id=" + i3);
        if (i3 != 104) {
            if (i3 != 105) {
                return null;
            }
            return (T) this.f204286c;
        }
        return (T) this.f204286c.emoCallbackGuildAio;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public String getInputBarText() {
        QLog.i(f204283d, 4, "getInputBarText");
        if (getEditText() != null && !TextUtils.isEmpty(getEditText().getText())) {
            return getEditText().getText().toString();
        }
        return "";
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public int getPanelChatPieType() {
        return this.f204284a;
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
    public PopOutAnimConfig getPopOutAnimConfig() {
        return new C7496a();
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public int getStatusBarHeight(Context context) {
        return 0;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public int getTitleBarHeight() {
        return 0;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public boolean isCurGuildLiveChannel() {
        return this.f204286c.x();
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public boolean isExperiment() {
        return QQTheme.isNowSimpleUI();
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public boolean isHostSafe() {
        if (isInAio() && getEditText() != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public boolean isInAio() {
        if (this.f204286c.getPanelParam().a() != null) {
            return true;
        }
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
    public boolean isShowEmoTitleInPreview(EmoticonInfo emoticonInfo, boolean z16) {
        if (emoticonInfo == null || emoticonInfo.type != 7) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public boolean needShowFavAndFunnyPicIcon() {
        return true;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public void setPaneliconsInterceptListener(g gVar) {
        this.f204285b = gVar;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public boolean supportExtendPanel() {
        return false;
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.emosm.emocompat.impl.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    class C7496a extends PopOutAnimConfig {
        C7496a() {
        }

        @Override // com.tencent.mobileqq.popanim.PopOutAnimConfig
        public void startShakeAnimation() {
        }

        @Override // com.tencent.mobileqq.popanim.PopOutAnimConfig
        public void stopShakeAnimation() {
        }

        @Override // com.tencent.mobileqq.popanim.PopOutAnimConfig
        public void sendPopEmoMsg(SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo, int i3) {
        }
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
    public Object gestureDetectorDestroy(Object obj) {
        return obj;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public Object initGestureDetector(Object obj) {
        return obj;
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public void stickerEditMode(boolean z16) {
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public void getLocationInAIO(View view, int[] iArr) {
    }

    @Override // com.tencent.mobileqq.AIODepend.IPanelInteractionListener
    public void setPaneliconsShowRed(int i3, boolean z16) {
    }
}
