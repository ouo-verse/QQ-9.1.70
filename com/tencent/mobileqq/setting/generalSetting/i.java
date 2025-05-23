package com.tencent.mobileqq.setting.generalSetting;

import androidx.lifecycle.ViewModel;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.colornote.ipc.IColorNoteProcessState;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.logic.TabDataHandler;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0002R\"\u0010\u000e\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0012\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\"\u0010\u0016\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/setting/generalSetting/i;", "Landroidx/lifecycle/ViewModel;", "", "P1", "onResume", "", "M1", "R1", "i", "Z", "Q1", "()Z", "setShowColorNoteRecentSwitch", "(Z)V", "isShowColorNoteRecentSwitch", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "O1", "setColorNoteSwitchValue", "colorNoteSwitchValue", BdhLogUtil.LogTag.Tag_Conn, "getAutoUpgradeSwitchValue", "setAutoUpgradeSwitchValue", "autoUpgradeSwitchValue", "<init>", "()V", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class i extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean autoUpgradeSwitchValue;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isShowColorNoteRecentSwitch;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean colorNoteSwitchValue;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N1(QQAppInterface app) {
        Intrinsics.checkNotNullParameter(app, "$app");
        BusinessHandler businessHandler = app.getBusinessHandler(TabDataHandler.class.getName());
        TabDataHandler tabDataHandler = businessHandler instanceof TabDataHandler ? (TabDataHandler) businessHandler : null;
        if (tabDataHandler != null) {
            tabDataHandler.D2(false);
        }
    }

    public final boolean M1() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        final QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface == null) {
            return false;
        }
        String currentUin = qQAppInterface.getCurrentUin();
        if (currentUin == null) {
            currentUin = "";
        }
        String tabSwitchList = TabDataHelper.getTabSwitchList(BaseApplication.getContext(), currentUin, TabDataHelper.SCENE_ASSISTANT_SETTING);
        if (!(tabSwitchList == null || tabSwitchList.length() == 0)) {
            return true;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.setting.generalSetting.h
            @Override // java.lang.Runnable
            public final void run() {
                i.N1(QQAppInterface.this);
            }
        }, 160, null, true);
        return false;
    }

    /* renamed from: O1, reason: from getter */
    public final boolean getColorNoteSwitchValue() {
        return this.colorNoteSwitchValue;
    }

    public final void P1() {
        R1();
    }

    /* renamed from: Q1, reason: from getter */
    public final boolean getIsShowColorNoteRecentSwitch() {
        return this.isShowColorNoteRecentSwitch;
    }

    public final void R1() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface == null) {
            return;
        }
        String currentUin = qQAppInterface.getCurrentUin();
        if (currentUin == null) {
            currentUin = "";
        }
        MobileQQ.sMobileQQ.getAppRuntime(currentUin);
        ea1.c cVar = (ea1.c) am.s().x(586);
        boolean z16 = cVar != null && cVar.a();
        boolean z17 = ((IColorNoteProcessState) QRoute.api(IColorNoteProcessState.class)).isRecentColorNoteTurnOn(qQAppInterface) && z16;
        this.isShowColorNoteRecentSwitch = z16;
        this.colorNoteSwitchValue = z17;
        this.autoUpgradeSwitchValue = ConfigHandler.g3(qQAppInterface, false);
    }

    public final void onResume() {
    }
}
