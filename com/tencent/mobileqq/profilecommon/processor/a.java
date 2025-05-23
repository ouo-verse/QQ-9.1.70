package com.tencent.mobileqq.profilecommon.processor;

import com.tencent.mobileqq.addfriend.processor.switchprocessor.AddFriendSettingProcessor;
import com.tencent.mobileqq.guild.profile.profilecard.GuildProfileRequestProcessor;
import com.tencent.mobileqq.loginprocessor.OnlineStatusNotifyProcessor;
import com.tencent.mobileqq.onlinestatus.protocol.OnlineStatusAvatarSwitchProcessor;
import com.tencent.mobileqq.processor.EmotionProcessor;
import com.tencent.mobileqq.pymk.request.PYMKProfileProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqexpand.config.profile.ExpandProfileProcessor;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.troop.identity.TroopIdentityProfileProcessor;
import com.tencent.mobileqq.zplan.push.ZPlanProfileProcessor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.handler.IntimateNotificationSwitchProcessor;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    @ConfigInject(configPath = "IMCore/src/main/resources/Inject_ProfileCommonProcessor.yml", version = 3)
    public static ArrayList<Class<? extends AbsProfileCommonProcessor>> f260942b;

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<AbsProfileCommonProcessor> f260943a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45052);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        ArrayList<Class<? extends AbsProfileCommonProcessor>> arrayList = new ArrayList<>();
        f260942b = arrayList;
        arrayList.add(AvatarHistoryNumProcessor.class);
        f260942b.add(CallPushProcessor.class);
        f260942b.add(FileAssistProcessor.class);
        f260942b.add(HonorRichProcessor.class);
        f260942b.add(KidModeProcessor.class);
        f260942b.add(PaiYiPaiProcessor.class);
        f260942b.add(TempSettingProcessor.class);
        f260942b.add(TroopHonorRichProcessor.class);
        f260942b.add(TroopLuckyCharacterProcessor.class);
        f260942b.add(TroopHonorSwitchProcessor.class);
        f260942b.add(VipProcessor.class);
        f260942b.add(ExpandProfileProcessor.class);
        f260942b.add(GuildProfileRequestProcessor.class);
        f260942b.add(AddFriendSettingProcessor.class);
        f260942b.add(EmotionProcessor.class);
        f260942b.add(ZPlanProfileProcessor.class);
        f260942b.add(OnlineStatusNotifyProcessor.class);
        f260942b.add(OnlineStatusAvatarSwitchProcessor.class);
        f260942b.add(ChatHistoryProfileCommonProcessor.class);
        f260942b.add(QZoneSwitchProcessor.class);
        f260942b.add(IntimateNotificationSwitchProcessor.class);
        f260942b.add(PYMKProfileProcessor.class);
        f260942b.add(TroopIdentityProfileProcessor.class);
    }

    public a(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
        } else {
            this.f260943a = new ArrayList<>();
            d(appRuntime);
        }
    }

    private void d(AppRuntime appRuntime) {
        AbsProfileCommonProcessor absProfileCommonProcessor;
        this.f260943a.clear();
        Iterator<Class<? extends AbsProfileCommonProcessor>> it = f260942b.iterator();
        while (it.hasNext()) {
            try {
                absProfileCommonProcessor = it.next().getConstructor(AppRuntime.class).newInstance(appRuntime);
            } catch (Exception e16) {
                QLog.d("ProfileCommonProcessorFactory", 1, "getProfileBusinessProcessors fail.", e16);
                absProfileCommonProcessor = null;
            }
            if (absProfileCommonProcessor != null) {
                this.f260943a.add(absProfileCommonProcessor);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor] */
    public <T extends AbsProfileCommonProcessor> T a(Class<? extends AbsProfileCommonProcessor> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (T) iPatchRedirector.redirect((short) 3, (Object) this, (Object) cls);
        }
        Iterator<AbsProfileCommonProcessor> it = this.f260943a.iterator();
        T t16 = null;
        while (it.hasNext()) {
            AbsProfileCommonProcessor next = it.next();
            if (next.getClass().equals(cls)) {
                t16 = next;
            }
        }
        return t16;
    }

    public AbsProfileCommonProcessor b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (AbsProfileCommonProcessor) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        Iterator<AbsProfileCommonProcessor> it = this.f260943a.iterator();
        AbsProfileCommonProcessor absProfileCommonProcessor = null;
        while (it.hasNext()) {
            AbsProfileCommonProcessor next = it.next();
            if (next.getProcessorKey().equals(str)) {
                absProfileCommonProcessor = next;
            }
        }
        return absProfileCommonProcessor;
    }

    public ArrayList<AbsProfileCommonProcessor> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ArrayList) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f260943a;
    }
}
