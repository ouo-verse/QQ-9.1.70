package com.tencent.mobileqq.tianshu.api.impl;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.quibadge.QUIBadge;
import com.tencent.mobileqq.quibadge.QUIRichBadge;
import com.tencent.mobileqq.quibadge.c;
import com.tencent.mobileqq.tianshu.api.IRedPointUIManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tH\u0002J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\tH\u0002J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/tianshu/api/impl/RedPointUIManagerImpl;", "Lcom/tencent/mobileqq/tianshu/api/IRedPointUIManager;", "", "updateSwitchStateIfNeed", "isSwitchOn", "needDebugSwitchOn", "debugSwitchOn", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "appInfo", "Lcom/tencent/mobileqq/tianshu/api/impl/c;", "transformAppInfo2UIInfo", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo;", "redTypeInfo", "redPointUIInfo", "", "parseRedTypeInfo2UIInfo", "Landroid/content/Context;", "context", "Landroid/view/View;", "transformUIInfo2UI", "transformRedTypeInfo2UIInfo", "getRichRedPointView", "<init>", "()V", "Companion", "a", "tianshu-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class RedPointUIManagerImpl implements IRedPointUIManager {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "RedPointUIManager";

    @NotNull
    private static SwitchState debugSwitch;

    @NotNull
    private static SwitchState switchState;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/tianshu/api/impl/RedPointUIManagerImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "tianshu-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.tianshu.api.impl.RedPointUIManagerImpl$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return;
            }
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22273);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        INSTANCE = new Companion(null);
        SwitchState switchState2 = SwitchState.NONE;
        switchState = switchState2;
        debugSwitch = switchState2;
    }

    public RedPointUIManagerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean debugSwitchOn() {
        SwitchState switchState2;
        boolean decodeBool = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_TIAN_SHU).decodeBool("tianshu_redtouch_switchon", true);
        SwitchState switchState3 = debugSwitch;
        if (decodeBool) {
            switchState2 = SwitchState.ON;
        } else {
            switchState2 = SwitchState.OFF;
        }
        debugSwitch = switchState2;
        if (switchState2 != switchState3) {
            QLog.d(TAG, 2, "[105737] debug isSwitchOn = ", Boolean.valueOf(decodeBool));
        }
        return decodeBool;
    }

    private final boolean needDebugSwitchOn(boolean isSwitchOn) {
        return false;
    }

    private final void parseRedTypeInfo2UIInfo(BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo, c redPointUIInfo) {
        int i3 = redTypeInfo.red_type.get();
        String str = redTypeInfo.red_content.get();
        if (str == null) {
            str = "";
        }
        QLog.i(TAG, 1, "[parseRedTypeInfo2UIInfo] type:" + i3 + ", red_content:" + str);
        if (i3 != 3) {
            if (i3 != 4) {
                if (i3 != 15) {
                    if (i3 == 40) {
                        redPointUIInfo.b().add(str);
                        return;
                    }
                    return;
                }
            } else {
                redPointUIInfo.m(str);
                return;
            }
        }
        redPointUIInfo.i(str);
    }

    private final c transformAppInfo2UIInfo(BusinessInfoCheckUpdate.AppInfo appInfo) {
        boolean z16;
        List<BusinessInfoCheckUpdate.RedTypeInfo> list = appInfo.red_display_info.get().red_type_info.get();
        Intrinsics.checkNotNullExpressionValue(list, "appInfo.red_display_info.get().red_type_info.get()");
        c cVar = new c();
        String str = appInfo.path.get();
        if (str == null) {
            str = "";
        }
        cVar.k(str);
        cVar.l(appInfo.type.get());
        if (appInfo.carousel.get() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        cVar.h(z16);
        cVar.j(appInfo.num.get());
        Iterator<BusinessInfoCheckUpdate.RedTypeInfo> it = list.iterator();
        while (it.hasNext()) {
            parseRedTypeInfo2UIInfo(it.next(), cVar);
        }
        QLog.i(TAG, 1, "[transformAppInfo2UIInfo] path:" + cVar.e() + " type:" + cVar.f() + " carousel:" + cVar.a() + " end");
        return cVar;
    }

    private final c transformRedTypeInfo2UIInfo(BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo) {
        c cVar = new c();
        cVar.l(redTypeInfo.red_type.get());
        parseRedTypeInfo2UIInfo(redTypeInfo, cVar);
        QLog.i(TAG, 1, "[transformRedTypeInfo2UIInfo] type:" + cVar.f() + " end");
        return cVar;
    }

    private final View transformUIInfo2UI(Context context, c redPointUIInfo) {
        QUIRichBadge qUIRichBadge = new QUIRichBadge(context);
        int f16 = redPointUIInfo.f();
        if (f16 != 8) {
            if (f16 != 15) {
                if (f16 != 40) {
                    qUIRichBadge.s(new c.b(redPointUIInfo.c(), redPointUIInfo.g()));
                } else {
                    qUIRichBadge.q(new c.a(redPointUIInfo.b(), redPointUIInfo.g(), redPointUIInfo.a()));
                }
            } else {
                qUIRichBadge.v(redPointUIInfo.c());
            }
            return qUIRichBadge;
        }
        QUIBadge qUIBadge = new QUIBadge(context);
        qUIBadge.setRedNum(redPointUIInfo.d());
        return qUIBadge;
    }

    private final boolean updateSwitchStateIfNeed() {
        SwitchState switchState2;
        if (switchState != SwitchState.NONE) {
            if (switchState != SwitchState.ON) {
                return false;
            }
            return true;
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105737", true);
        if (isSwitchOn) {
            switchState2 = SwitchState.ON;
        } else {
            switchState2 = SwitchState.OFF;
        }
        switchState = switchState2;
        QLog.e(TAG, 2, "[105737] init isSwitchOn= " + isSwitchOn);
        if (switchState != SwitchState.ON) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedPointUIManager
    @NotNull
    public View getRichRedPointView(@NotNull Context context, @NotNull BusinessInfoCheckUpdate.AppInfo appInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) appInfo);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appInfo, "appInfo");
        return transformUIInfo2UI(context, transformAppInfo2UIInfo(appInfo));
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedPointUIManager
    public boolean isSwitchOn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        boolean updateSwitchStateIfNeed = updateSwitchStateIfNeed();
        if (needDebugSwitchOn(updateSwitchStateIfNeed)) {
            return debugSwitchOn();
        }
        return updateSwitchStateIfNeed;
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedPointUIManager
    @NotNull
    public View getRichRedPointView(@NotNull Context context, @NotNull BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) redTypeInfo);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(redTypeInfo, "redTypeInfo");
        return transformUIInfo2UI(context, transformRedTypeInfo2UIInfo(redTypeInfo));
    }
}
