package com.tencent.mobileqq.api.impl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.QQSettingMeView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.am;
import com.tencent.mobileqq.api.IDrawerApi;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.at;
import com.tencent.mobileqq.preload.DrawerPreLoadCache;
import com.tencent.mobileqq.processor.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqsettingme.BaseQQSettingMeView;
import com.tencent.mobileqq.utils.DrawerUtils;
import com.tencent.mobileqq.utils.QQSettingMeABTestHelper;
import com.tencent.mobileqq.utils.dl;
import com.tencent.mobileqq.utils.dm;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\u000eH\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0016J\b\u0010\u001a\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\u000eH\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/api/impl/DrawerApiImpl;", "Lcom/tencent/mobileqq/api/IDrawerApi;", "", "isV9", "Lcom/tencent/mobileqq/app/QBaseActivity;", PM.BASE, "Lcom/tencent/mobileqq/qqsettingme/BaseQQSettingMeView;", "getQQSettingMeView", "", "getStaticFrameSavePath", "", "getQQSettingMeInitDelayTime", "", VipFunCallConstants.KEY_GROUP, "", "preloadDrawable", "preloadProcessors", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/processor/b;", "Lkotlin/collections/ArrayList;", "getProcessors", "clearAllCache", "currentIsV3", "needUsedV3", "preloadConfig", "clearConfig", "needReloadUI", "resetReloadUI", "<init>", "()V", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class DrawerApiImpl implements IDrawerApi {
    static IPatchRedirector $redirector_;

    public DrawerApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.api.IDrawerApi
    public void clearAllCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            DrawerPreLoadCache.f259468a.h();
        }
    }

    @Override // com.tencent.mobileqq.api.IDrawerApi
    public void clearConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            dl.f307676a.a();
        }
    }

    @Override // com.tencent.mobileqq.api.IDrawerApi
    public boolean currentIsV3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return dm.f307679a.a();
    }

    @Override // com.tencent.mobileqq.api.IDrawerApi
    @NotNull
    public ArrayList<b> getProcessors() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ArrayList) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return DrawerPreLoadCache.f259468a.n();
    }

    @Override // com.tencent.mobileqq.api.IDrawerApi
    public long getQQSettingMeInitDelayTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return DrawerUtils.f306948a.h();
    }

    @Override // com.tencent.mobileqq.api.IDrawerApi
    @NotNull
    public BaseQQSettingMeView getQQSettingMeView(boolean isV9, @NotNull QBaseActivity base) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (BaseQQSettingMeView) iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isV9), base);
        }
        Intrinsics.checkNotNullParameter(base, "base");
        if (isV9) {
            dm dmVar = dm.f307679a;
            if (dmVar.b()) {
                QLog.i("DrawerApiImpl", 1, "1 getQQSettingMeView :  is usedV3");
                View inflate = LayoutInflater.from(base).inflate(R.layout.h47, (ViewGroup) null);
                Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
                dmVar.c(true);
                return new am(base, (ViewGroup) inflate);
            }
            QLog.i("DrawerApiImpl", 1, "1 getQQSettingMeView :  is V9");
            View inflate2 = LayoutInflater.from(base).inflate(R.layout.qq_setting_me_v9, (ViewGroup) null);
            Intrinsics.checkNotNull(inflate2, "null cannot be cast to non-null type android.view.ViewGroup");
            dmVar.c(false);
            return new at(base, (ViewGroup) inflate2);
        }
        QLog.i("DrawerApiImpl", 1, "1 getQQSettingMeView : is not V9");
        View inflate3 = LayoutInflater.from(base).inflate(R.layout.qq_setting_me, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate3, "null cannot be cast to non-null type android.view.ViewGroup");
        dm.f307679a.c(false);
        return new QQSettingMeView(base, (ViewGroup) inflate3);
    }

    @Override // com.tencent.mobileqq.api.IDrawerApi
    @NotNull
    public String getStaticFrameSavePath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return DrawerUtils.f306948a.g();
    }

    @Override // com.tencent.mobileqq.api.IDrawerApi
    public boolean needReloadUI() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return dl.f307676a.c();
    }

    @Override // com.tencent.mobileqq.api.IDrawerApi
    public boolean needUsedV3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        if (QQSettingMeABTestHelper.c() && dm.f307679a.b()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.api.IDrawerApi
    public void preloadConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            dl.f307676a.d();
            clearAllCache();
        }
    }

    @Override // com.tencent.mobileqq.api.IDrawerApi
    public void preloadDrawable(int group) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, group);
        } else {
            DrawerPreLoadCache.f259468a.p(group);
        }
    }

    @Override // com.tencent.mobileqq.api.IDrawerApi
    public void preloadProcessors() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            DrawerPreLoadCache.f259468a.r();
        }
    }

    @Override // com.tencent.mobileqq.api.IDrawerApi
    public void resetReloadUI() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            dl.f307676a.e();
        }
    }
}
