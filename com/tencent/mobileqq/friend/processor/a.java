package com.tencent.mobileqq.friend.processor;

import com.tencent.mobileqq.addfriend.NTAddFriendProcessor;
import com.tencent.mobileqq.app.friendlist.processor.AddFriendProcessor;
import com.tencent.mobileqq.app.friendlist.processor.DiscussionProcessor;
import com.tencent.mobileqq.app.friendlist.processor.FriendStatusProcessor;
import com.tencent.mobileqq.app.friendlist.processor.IntimateInfoProcessor;
import com.tencent.mobileqq.app.friendlist.processor.ListenTogetherProcessor;
import com.tencent.mobileqq.app.friendlist.processor.MainProcessor;
import com.tencent.mobileqq.app.friendlist.processor.MutualMarkProcessor;
import com.tencent.mobileqq.app.friendlist.processor.OnlineStatusProcessor;
import com.tencent.mobileqq.app.friendlist.processor.QIMFriendProcessor;
import com.tencent.mobileqq.app.friendlist.processor.QidianProcessor;
import com.tencent.mobileqq.app.friendlist.processor.RelationFriendNTProcessor;
import com.tencent.mobileqq.app.friendlist.processor.RichStatusProcessor;
import com.tencent.mobileqq.app.friendlist.processor.ShieldFriendProcessor;
import com.tencent.mobileqq.app.friendlist.processor.SpecialCareProcessor;
import com.tencent.mobileqq.app.friendlist.processor.VASProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.vas.pay.page.QVipRenewalFriendProcessor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    @ConfigInject(configPath = "IMCore/src/main/resources/Inject_FriendBusinessProcessor.yml", version = 2)
    private static ArrayList<Class<? extends BaseFriendProcessor>> f211714b;

    /* renamed from: c, reason: collision with root package name */
    private static ArrayList<BaseFriendProcessor> f211715c;

    /* renamed from: a, reason: collision with root package name */
    private volatile boolean f211716a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41696);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        ArrayList<Class<? extends BaseFriendProcessor>> arrayList = new ArrayList<>();
        f211714b = arrayList;
        arrayList.add(DiscussionProcessor.class);
        f211714b.add(FriendStatusProcessor.class);
        f211714b.add(IntimateInfoProcessor.class);
        f211714b.add(ListenTogetherProcessor.class);
        f211714b.add(MainProcessor.class);
        f211714b.add(MutualMarkProcessor.class);
        f211714b.add(OnlineStatusProcessor.class);
        f211714b.add(QidianProcessor.class);
        f211714b.add(QIMFriendProcessor.class);
        f211714b.add(RichStatusProcessor.class);
        f211714b.add(ShieldFriendProcessor.class);
        f211714b.add(SpecialCareProcessor.class);
        f211714b.add(VASProcessor.class);
        f211714b.add(AddFriendProcessor.class);
        f211714b.add(RelationFriendNTProcessor.class);
        f211714b.add(QVipRenewalFriendProcessor.class);
        f211714b.add(NTAddFriendProcessor.class);
        f211715c = new ArrayList<>();
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f211716a = false;
        }
    }

    private void b(AppRuntime appRuntime) {
        BaseFriendProcessor baseFriendProcessor;
        f211715c.clear();
        Iterator<Class<? extends BaseFriendProcessor>> it = f211714b.iterator();
        while (it.hasNext()) {
            Class<? extends BaseFriendProcessor> next = it.next();
            if (QLog.isColorLevel()) {
                QLog.d("IMCore.friend.FriendBusinessProcessor", 2, "initBusinessProcessors| " + next.getName());
            }
            try {
                baseFriendProcessor = next.getConstructor(AppRuntime.class).newInstance(appRuntime);
            } catch (Exception e16) {
                QLog.d("IMCore.friend.FriendBusinessProcessor", 1, "initBusinessProcessors fail.", e16);
                baseFriendProcessor = null;
            }
            if (baseFriendProcessor != null) {
                f211715c.add(baseFriendProcessor);
            }
        }
    }

    public ArrayList<BaseFriendProcessor> a(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        }
        if (!this.f211716a) {
            b(appRuntime);
            this.f211716a = true;
        }
        return f211715c;
    }
}
