package com.tencent.mobileqq.activity.home.framejumpentry;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.contacts.base.Contacts;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.managers.PushNoticeManager;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.k;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import mqq.app.api.ProcessConstant;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f183020a;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.home.framejumpentry.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public abstract class AbstractC7173a {
        static IPatchRedirector $redirector_;

        public AbstractC7173a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        public abstract void a(FrameFragment frameFragment, Intent intent);
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public abstract class b {
        static IPatchRedirector $redirector_;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        public abstract void a(FrameFragment frameFragment, Bundle bundle, int i3, String str);
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c extends b {
        static IPatchRedirector $redirector_;

        public c() {
            super();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.mobileqq.activity.home.framejumpentry.a.b
        public void a(FrameFragment frameFragment, Bundle bundle, int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, frameFragment, bundle, Integer.valueOf(i3), str);
                return;
            }
            Contacts contacts = (Contacts) frameFragment.getFrame(Contacts.class);
            if (contacts != null) {
                contacts.scrollToDevice(true);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class d extends b {
        static IPatchRedirector $redirector_;

        public d() {
            super();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.mobileqq.activity.home.framejumpentry.a.b
        public void a(FrameFragment frameFragment, Bundle bundle, int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, frameFragment, bundle, Integer.valueOf(i3), str);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("CampusNoticeManager", 2, String.format(Locale.getDefault(), "back from campus_notice %d", Integer.valueOf(DrawerFrame.f185113z0)));
            }
            if (DrawerFrame.f185113z0 == 0) {
                DrawerFrame.f185113z0 = 3;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class e extends AbstractC7173a {
        static IPatchRedirector $redirector_;

        public e() {
            super();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.mobileqq.activity.home.framejumpentry.a.AbstractC7173a
        public void a(FrameFragment frameFragment, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) frameFragment, (Object) intent);
                return;
            }
            Parcelable parcelableExtra = intent.getParcelableExtra(IProfileCardConst.KEY_ALL_IN_ONE);
            if (parcelableExtra instanceof AllInOne) {
                AllInOne allInOne = (AllInOne) parcelableExtra;
                allInOne.lastActivity = 100;
                allInOne.profileEntryType = 6;
                ProfileUtils.openProfileCard(frameFragment.getActivity(), allInOne);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class f extends AbstractC7173a {
        static IPatchRedirector $redirector_;

        public f() {
            super();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.mobileqq.activity.home.framejumpentry.a.AbstractC7173a
        public void a(FrameFragment frameFragment, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) frameFragment, (Object) intent);
                return;
            }
            int intExtra = intent.getIntExtra("uintype", -1);
            String stringExtra = intent.getStringExtra("url");
            Intent intent2 = new Intent(frameFragment.getBaseActivity(), (Class<?>) QQBrowserActivity.class);
            if (intExtra != -1) {
                intent2.putExtra("uintype", intExtra);
                if (intExtra == 1030) {
                    QQAppInterface qQAppInterface = (QQAppInterface) frameFragment.app;
                    int i3 = QQManagerFactory.CAMPUS_NOTICE_MANAGER;
                    if (qQAppInterface.isCreateManager(i3)) {
                        k.a aVar = new k.a();
                        aVar.f290023e = "0X8009241";
                        aVar.f290022d = "\u70b9\u51fb\u4e1a\u52a1Push";
                        k.b(stringExtra, aVar);
                        k.d((QQAppInterface) frameFragment.app, aVar);
                        ((com.tencent.mobileqq.campuscircle.d) frameFragment.app.getManager(i3)).f(null);
                        if (QLog.isColorLevel()) {
                            QLog.d("CampusNoticeManager", 2, "remove campus notice");
                        }
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("CampusNoticeManager", 1, "doOnNewIntent : url" + stringExtra);
            }
            intent2.putExtra("url", stringExtra);
            frameFragment.startActivity(intent2);
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean c(FrameFragment frameFragment, int i3) {
        if (i3 == com.tencent.mobileqq.activity.home.impl.a.f183039b && !((QQAppInterface) frameFragment.app).isCallTabShow) {
            Conversation conversation = (Conversation) frameFragment.getFrame(Conversation.class);
            if (conversation != null) {
                conversation.mSelectCallTab = true;
            }
            frameFragment.mTabIndicator.setCurrentTab(com.tencent.mobileqq.activity.home.impl.a.f183038a);
            return true;
        }
        return false;
    }

    private void d(FrameFragment frameFragment, Bundle bundle, int i3) {
        int i16;
        Conversation conversation = (Conversation) frameFragment.getFrame(Conversation.class);
        String string = bundle.getString("from");
        if (conversation != null) {
            conversation.isFromHongBaoShare = "10003".equals(string);
        }
        if (ProcessConstant.SMARTDEVICE.equals(string) && i3 == com.tencent.mobileqq.activity.home.impl.a.f183040c) {
            i16 = 0;
        } else {
            i16 = -1;
        }
        if (i3 == com.tencent.mobileqq.activity.home.impl.a.f183041d && "campus_notice".equals(string)) {
            i16 = 2;
        }
        b b16 = b(i16);
        if (b16 != null) {
            b16.a(frameFragment, bundle, i3, string);
        }
    }

    private boolean e(FrameFragment frameFragment, Bundle bundle, int i3) {
        boolean z16;
        if (i3 != com.tencent.mobileqq.activity.home.impl.a.f183038a) {
            return false;
        }
        if (1 == bundle.getInt(Conversation.TAB_INDEX, -1) && !((QQAppInterface) frameFragment.app).isCallTabShow) {
            Conversation conversation = (Conversation) frameFragment.getFrame(Conversation.class);
            if (conversation != null) {
                conversation.mSelectCallTab = true;
            }
            frameFragment.mTabIndicator.setCurrentTab(i3);
            return true;
        }
        if (i3 != frameFragment.getCurrentTab()) {
            return false;
        }
        Conversation conversation2 = (Conversation) frameFragment.getFrame(Conversation.class);
        String string = bundle.getString("from");
        if (QLog.isColorLevel()) {
            QLog.d("TabJumpHelper", 2, "doOnNewIntent, same tab,from=" + string);
        }
        if (conversation2 != null) {
            if (!"10003".equals(string) && !"10004".equals(string)) {
                z16 = false;
            } else {
                z16 = true;
            }
            conversation2.isFromHongBaoShare = z16;
            conversation2.isFromThemeDIY = bundle.getBoolean(AppConstants.Key.THEME_BACK_TO_CONVERSATION, false);
        }
        return true;
    }

    private boolean f(FrameFragment.d dVar, int i3) {
        int i16 = com.tencent.mobileqq.activity.home.impl.a.f183046i;
        if (i3 == i16) {
            dVar.setCurrentTab(i16);
            return true;
        }
        return false;
    }

    public static a h() {
        if (f183020a == null) {
            synchronized (a.class) {
                if (f183020a == null) {
                    f183020a = new a();
                }
            }
        }
        return f183020a;
    }

    private void i(FrameFragment frameFragment, Intent intent, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("TabJumpHelper", 2, "MainActivity:onNewIntent mTabHost is null");
        }
    }

    private void j(Context context) {
        Intent intent = new Intent(context, (Class<?>) LiteActivity.class);
        intent.addFlags(67108864);
        context.startActivity(intent);
    }

    private void k(FrameFragment frameFragment, Intent intent) {
        try {
            int intExtra = intent.getIntExtra("forward", -1);
            int intExtra2 = intent.getIntExtra("uintype", -1);
            String stringExtra = intent.getStringExtra("uin");
            if (intExtra > 0 && (intExtra2 == 1035 || intExtra2 == 1041 || intExtra2 == 1042)) {
                QQAppInterface qQAppInterface = (QQAppInterface) frameFragment.app;
                int i3 = QQManagerFactory.PUSH_NOTICE_MANAGER;
                if (qQAppInterface.isCreateManager(i3)) {
                    ((PushNoticeManager) frameFragment.app.getManager(i3)).a(frameFragment.getBaseActivity(), intent);
                    return;
                }
            }
            if (AppConstants.DATALINE_PC_UIN.equals(stringExtra)) {
                j(frameFragment.getActivity());
                return;
            }
            AbstractC7173a a16 = a(intExtra);
            if (a16 != null) {
                a16.a(frameFragment, intent);
            }
            intent.removeExtra("forward");
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("TabJumpHelper", 2, "", e16);
            }
        }
    }

    public AbstractC7173a a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AbstractC7173a) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        QLog.d("TabJumpHelper", 1, "createPlugin pluginKey: " + i3);
        if (i3 != 2) {
            if (i3 != 3) {
                return null;
            }
            return new f();
        }
        return new e();
    }

    public b b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        QLog.d("TabJumpHelper", 1, "createPlugin pluginKey: " + i3);
        if (i3 != 0) {
            if (i3 != 2) {
                return null;
            }
            return new d();
        }
        return new c();
    }

    public void g(FrameFragment frameFragment, Intent intent, Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, frameFragment, intent, bundle, Integer.valueOf(i3));
            return;
        }
        if (frameFragment.mTabIndicator != null && i3 >= 0) {
            if (e(frameFragment, bundle, i3) || c(frameFragment, i3) || f(frameFragment.mTabIndicator, i3)) {
                return;
            }
            if (i3 < frameFragment.mTabWidget.getChildCount()) {
                d(frameFragment, bundle, i3);
                frameFragment.mTabIndicator.setCurrentTab(i3);
            } else if (i3 == com.tencent.mobileqq.activity.home.impl.a.f183045h) {
                frameFragment.mTabIndicator.setCurrentTab(com.tencent.mobileqq.activity.home.impl.a.f183041d);
            }
        } else {
            i(frameFragment, intent, i3);
        }
        k(frameFragment, intent);
    }
}
