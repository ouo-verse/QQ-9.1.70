package com.tencent.mobileqq.profilecard.processor;

import com.tencent.mobileqq.profilecard.bussiness.anonymous.processor.AnonymousBusinessProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

/* loaded from: classes16.dex */
public class ProfileBusinessProcessorFactory {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ProfileBusinessProcessorFactory";

    @ConfigInject(configPath = "IMCore/src/main/resources/Inject_ProfileBusinessProcessor.yml", version = 1)
    public static ArrayList<Class<? extends AbsProfileBusinessProcessor>> sInjectProcessorClasses;
    private final AtomicBoolean injectInit;
    private final List<AbsProfileBusinessProcessor> injectProcessors;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44186);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        ArrayList<Class<? extends AbsProfileBusinessProcessor>> arrayList = new ArrayList<>();
        sInjectProcessorClasses = arrayList;
        arrayList.add(DefaultProfileBusinessProcessor.class);
        sInjectProcessorClasses.add(TempProfileBusinessProcessor.class);
        sInjectProcessorClasses.add(TempGetProfileDetailProcessor.class);
        sInjectProcessorClasses.add(AnonymousBusinessProcessor.class);
        sInjectProcessorClasses.add(ProfileSecureProcessor.class);
        sInjectProcessorClasses.add(ProfileQCubProcessor.class);
        sInjectProcessorClasses.add(ProfileMusicDataProcessor.class);
        sInjectProcessorClasses.add(ProfileMetaFarmProcessor.class);
    }

    public ProfileBusinessProcessorFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.injectInit = new AtomicBoolean(false);
            this.injectProcessors = new CopyOnWriteArrayList();
        }
    }

    private void initBusinessProcessors(AppRuntime appRuntime) {
        AbsProfileBusinessProcessor absProfileBusinessProcessor;
        this.injectProcessors.clear();
        Iterator<Class<? extends AbsProfileBusinessProcessor>> it = sInjectProcessorClasses.iterator();
        while (it.hasNext()) {
            try {
                absProfileBusinessProcessor = it.next().getConstructor(AppRuntime.class).newInstance(appRuntime);
            } catch (Exception e16) {
                QLog.d(TAG, 1, "getProfileBusinessProcessors fail.", e16);
                absProfileBusinessProcessor = null;
            }
            if (absProfileBusinessProcessor != null) {
                this.injectProcessors.add(absProfileBusinessProcessor);
            }
        }
    }

    public List<AbsProfileBusinessProcessor> getBusinessProcessors(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        }
        if (!this.injectInit.get()) {
            this.injectInit.set(true);
            initBusinessProcessors(appRuntime);
        }
        return this.injectProcessors;
    }
}
