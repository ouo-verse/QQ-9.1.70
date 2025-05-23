package com.tencent.mobileqq.activity.home.chats.biz;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi;
import cooperation.vip.ad.GrowHalfLayerHelper;
import cooperation.vip.pb.TianShuAccess;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.Constants;

/* compiled from: P */
/* loaded from: classes10.dex */
public class aa extends d {
    static IPatchRedirector $redirector_;
    private long C;
    private long D;
    private int E;
    private final IWeChatGuildApi.b F;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements IWeChatGuildApi.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aa.this);
            }
        }

        @Override // com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi.b
        public void a(int i3, @NonNull Map<IWeChatGuildApi.BIZ_TYPE_WX, TianShuAccess.AdPlacementInfo> map) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) map);
            } else if (i3 == 0) {
                aa.this.na();
            }
        }
    }

    public aa(com.tencent.mobileqq.activity.home.chats.callbcak.a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            return;
        }
        this.C = 0L;
        this.D = 60000L;
        this.E = 0;
        this.F = new a();
        ((IWeChatGuildApi) QRoute.api(IWeChatGuildApi.class)).requestTianshuConfigIfNeeds();
        ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).registerStudyModeSetting();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void na() {
        IWeChatGuildApi.BIZ_TYPE_WX biz_type_wx;
        TianShuAccess.AdPlacementInfo config;
        PBRepeatMessageField<TianShuAccess.AdItem> pBRepeatMessageField;
        if (System.currentTimeMillis() - this.C >= this.D && (config = ((IWeChatGuildApi) QRoute.api(IWeChatGuildApi.class)).getConfig((biz_type_wx = IWeChatGuildApi.BIZ_TYPE_WX.RECENT))) != null && (pBRepeatMessageField = config.lst) != null && pBRepeatMessageField.size() > 0) {
            GrowHalfLayerHelper.g(config.lst.get(0), getActivity(), "", biz_type_wx.getValue());
            this.C = System.currentTimeMillis();
        }
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a
    public void B9(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            ((IWeChatGuildApi) QRoute.api(IWeChatGuildApi.class)).requestTianshuConfigIfNeeds();
        }
    }

    @Override // com.tencent.mobileqq.activity.home.chats.biz.d
    public String ea() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return "WeChatAgentPart";
    }

    public void oa(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (z17 && !z16) {
            na();
        }
        ((IWeChatGuildApi) QRoute.api(IWeChatGuildApi.class)).requestTianshuConfigIfNeeds();
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a, mqq.app.IAccountCallback
    public void onAccountChanged(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime);
            return;
        }
        this.C = 0L;
        ((IWeChatGuildApi) QRoute.api(IWeChatGuildApi.class)).clear();
        ((IWeChatGuildApi) QRoute.api(IWeChatGuildApi.class)).requestTianshuConfigIfNeeds();
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a, mqq.app.IAccountCallback
    public void onLogout(@Nullable Constants.LogoutReason logoutReason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) logoutReason);
        } else {
            this.C = 0L;
            ((IWeChatGuildApi) QRoute.api(IWeChatGuildApi.class)).clear();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity, (Object) bundle);
        } else {
            super.onPartCreate(activity, bundle);
            this.E = ((IWeChatGuildApi) QRoute.api(IWeChatGuildApi.class)).addListener(this.F);
        }
    }

    @Override // com.tencent.mobileqq.activity.home.chats.biz.d, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NonNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        if (this.E != 0) {
            ((IWeChatGuildApi) QRoute.api(IWeChatGuildApi.class)).removeListener(this.E);
        }
        this.C = 0L;
        ((IWeChatGuildApi) QRoute.api(IWeChatGuildApi.class)).clear();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartSaveInstanceState(Activity activity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) activity, (Object) bundle);
        } else {
            super.onPartSaveInstanceState(activity, bundle);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStart(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) activity);
        } else {
            super.onPartStart(activity);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) activity);
        } else {
            super.onPartStop(activity);
        }
    }

    public void pa(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Boolean.valueOf(z16));
        } else if (z16) {
            ((IWeChatGuildApi) QRoute.api(IWeChatGuildApi.class)).requestTianshuConfigIfNeeds();
        }
    }
}
