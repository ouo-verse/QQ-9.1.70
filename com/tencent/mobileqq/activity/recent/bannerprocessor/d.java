package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.kandian.biz.video.feedback.api.IReadInJoyVideoInteract;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.plugin.IPluginManager;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes10.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a implements b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QQAppInterface> f185306a;

        /* renamed from: b, reason: collision with root package name */
        private String f185307b;

        /* renamed from: c, reason: collision with root package name */
        private c f185308c;

        public a(String str, QQAppInterface qQAppInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) qQAppInterface);
            } else {
                this.f185307b = str;
                this.f185306a = new WeakReference<>(qQAppInterface);
            }
        }

        public void a(@Nullable c cVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar);
            } else {
                this.f185308c = cVar;
            }
        }

        @Override // com.tencent.mobileqq.activity.recent.bannerprocessor.d.b
        public boolean isNeedAutoCloseWhenAccountChange() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
            }
            return true;
        }

        @Override // com.tencent.mobileqq.activity.recent.bannerprocessor.d.b
        public void onClose() {
            QQAppInterface qQAppInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                if (this.f185308c == null || (qQAppInterface = this.f185306a.get()) == null) {
                    return;
                }
                d.f(qQAppInterface, this.f185308c);
            }
        }

        @Override // com.tencent.mobileqq.activity.recent.bannerprocessor.d.b
        public void onEnter() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            QQAppInterface qQAppInterface = this.f185306a.get();
            if (qQAppInterface == null) {
                return;
            }
            if (QBaseActivity.sTopActivity != null) {
                Intent intent = new Intent();
                intent.putExtra("public_fragment_window_feature", 1);
                intent.addFlags(268435456);
                try {
                    PublicTransFragmentActivity.start(qQAppInterface.getApp(), intent, Class.forName(this.f185307b));
                } catch (ClassNotFoundException e16) {
                    e16.printStackTrace();
                }
            } else if (QLog.isColorLevel()) {
                QLog.d("Q.recent.banner", 2, "sTopActivity is null");
            }
            d.f(qQAppInterface, this.f185308c);
        }

        @Override // com.tencent.mobileqq.activity.recent.bannerprocessor.d.b
        public void onOverride() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface b {
        boolean isNeedAutoCloseWhenAccountChange();

        void onClose();

        void onEnter();

        void onOverride();
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static final class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final int f185309a;

        /* renamed from: b, reason: collision with root package name */
        @NonNull
        public final String f185310b;

        /* renamed from: c, reason: collision with root package name */
        public final int f185311c;

        /* renamed from: d, reason: collision with root package name */
        @NonNull
        public final String f185312d;

        /* renamed from: e, reason: collision with root package name */
        @NonNull
        public final b f185313e;

        public c(int i3, @NonNull String str, int i16, @NonNull String str2, @NonNull b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, Integer.valueOf(i16), str2, bVar);
                return;
            }
            this.f185309a = i3;
            this.f185310b = str;
            this.f185311c = i16;
            this.f185312d = str2;
            this.f185313e = bVar;
        }

        public boolean equals(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, obj)).booleanValue();
            }
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            if (this.f185309a != cVar.f185309a || this.f185311c != cVar.f185311c || !this.f185310b.equals(cVar.f185310b)) {
                return false;
            }
            return this.f185312d.equals(cVar.f185312d);
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return (((((this.f185309a * 31) + this.f185310b.hashCode()) * 31) + this.f185311c) * 31) + this.f185312d.hashCode();
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "MessageToShowBanner{bannerLev=" + this.f185309a + ", businessCategory='" + this.f185310b + "', iconIdx=" + this.f185311c + ", wording='" + this.f185312d + "', callback=" + this.f185313e + '}';
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.recent.bannerprocessor.d$d, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class ViewOnClickListenerC7199d implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private c f185314d;

        /* renamed from: e, reason: collision with root package name */
        private MqqHandler f185315e;

        public ViewOnClickListenerC7199d(c cVar, MqqHandler mqqHandler) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar, (Object) mqqHandler);
            } else {
                this.f185314d = cVar;
                this.f185315e = mqqHandler;
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.recent.banner", 2, this.f185314d.f185310b + " on close");
                }
                Message obtainMessage = this.f185315e.obtainMessage(1000);
                obtainMessage.obj = this.f185314d;
                this.f185315e.sendMessage(obtainMessage);
                this.f185314d.f185313e.onClose();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class e implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private c f185316d;

        /* renamed from: e, reason: collision with root package name */
        private MqqHandler f185317e;

        public e(c cVar, MqqHandler mqqHandler) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar, (Object) mqqHandler);
            } else {
                this.f185317e = mqqHandler;
                this.f185316d = cVar;
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.recent.banner", 2, this.f185316d.f185310b + " on enter");
                }
                this.f185316d.f185313e.onEnter();
                ReportController.r(null, "dc00898", "", "", BaseBannerProcessor.TVALUE_CLICK_READ, BaseBannerProcessor.TVALUE_CLICK_READ, 1, 0, "", "", "", "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class f implements b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        private final PendingIntent f185318a;

        /* renamed from: b, reason: collision with root package name */
        @NonNull
        private final WeakReference<QQAppInterface> f185319b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        private c f185320c;

        public f(@NonNull PendingIntent pendingIntent, @NonNull QQAppInterface qQAppInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) pendingIntent, (Object) qQAppInterface);
            } else {
                this.f185318a = pendingIntent;
                this.f185319b = new WeakReference<>(qQAppInterface);
            }
        }

        public void a(@Nullable c cVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar);
            } else {
                this.f185320c = cVar;
            }
        }

        @Override // com.tencent.mobileqq.activity.recent.bannerprocessor.d.b
        public boolean isNeedAutoCloseWhenAccountChange() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
            }
            return true;
        }

        @Override // com.tencent.mobileqq.activity.recent.bannerprocessor.d.b
        public void onClose() {
            QQAppInterface qQAppInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                if (this.f185320c == null || (qQAppInterface = this.f185319b.get()) == null) {
                    return;
                }
                d.f(qQAppInterface, this.f185320c);
            }
        }

        @Override // com.tencent.mobileqq.activity.recent.bannerprocessor.d.b
        public void onEnter() {
            QQAppInterface qQAppInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            if (this.f185320c == null || (qQAppInterface = this.f185319b.get()) == null) {
                return;
            }
            try {
                this.f185318a.send();
            } catch (PendingIntent.CanceledException e16) {
                QLog.e("Q.recent.banner", 1, "send pending intent fail with " + this.f185318a + "\r\n" + e16);
            }
            d.f(qQAppInterface, this.f185320c);
        }

        @Override // com.tencent.mobileqq.activity.recent.bannerprocessor.d.b
        public void onOverride() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class g implements b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        private final WeakReference<QQAppInterface> f185321a;

        /* renamed from: b, reason: collision with root package name */
        @NonNull
        private final String f185322b;

        /* renamed from: c, reason: collision with root package name */
        @NonNull
        private final String f185323c;

        /* renamed from: d, reason: collision with root package name */
        @NonNull
        private final String f185324d;

        /* renamed from: e, reason: collision with root package name */
        @Nullable
        private final String f185325e;

        /* renamed from: f, reason: collision with root package name */
        @Nullable
        private c f185326f;

        /* renamed from: g, reason: collision with root package name */
        @NonNull
        private final Intent f185327g;

        /* renamed from: h, reason: collision with root package name */
        @NonNull
        private final String f185328h;

        /* renamed from: i, reason: collision with root package name */
        private final int f185329i;

        public g(@NonNull QQAppInterface qQAppInterface, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull Intent intent, @NonNull String str5, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, qQAppInterface, str, str2, str3, str4, intent, str5, Integer.valueOf(i3));
                return;
            }
            this.f185321a = new WeakReference<>(qQAppInterface);
            this.f185322b = str;
            this.f185323c = str2;
            this.f185324d = str3;
            this.f185325e = str4;
            this.f185327g = intent;
            this.f185328h = str5;
            this.f185329i = i3;
        }

        public void a(@Nullable c cVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar);
            } else {
                this.f185326f = cVar;
            }
        }

        @Override // com.tencent.mobileqq.activity.recent.bannerprocessor.d.b
        public boolean isNeedAutoCloseWhenAccountChange() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
            }
            return true;
        }

        @Override // com.tencent.mobileqq.activity.recent.bannerprocessor.d.b
        public void onClose() {
            QQAppInterface qQAppInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                if (this.f185326f == null || (qQAppInterface = this.f185321a.get()) == null) {
                    return;
                }
                d.f(qQAppInterface, this.f185326f);
            }
        }

        @Override // com.tencent.mobileqq.activity.recent.bannerprocessor.d.b
        public void onEnter() {
            QQAppInterface qQAppInterface;
            QBaseActivity qBaseActivity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            if (this.f185326f != null && (qQAppInterface = this.f185321a.get()) != null && (qBaseActivity = QBaseActivity.sTopActivity) != null && !qBaseActivity.isFinishing()) {
                try {
                    Class asSubclass = Class.forName(this.f185323c).asSubclass(Activity.class);
                    this.f185327g.putExtra("banner_fromBanner", true);
                    IPluginManager.i iVar = new IPluginManager.i(this.f185329i);
                    iVar.f390201g = this.f185325e;
                    iVar.f390202h = this.f185322b;
                    iVar.f390203i = asSubclass;
                    iVar.f390198d = this.f185324d;
                    iVar.f390197c = this.f185328h;
                    iVar.f390204j = this.f185327g;
                    iVar.f390205k = -1;
                    IPluginManager.B5(qBaseActivity, iVar);
                    d.f(qQAppInterface, this.f185326f);
                } catch (ClassNotFoundException unused) {
                    QLog.e("Q.recent.banner", 1, "return to plugin error, can not find the ckass " + this.f185323c);
                }
            }
        }

        @Override // com.tencent.mobileqq.activity.recent.bannerprocessor.d.b
        public void onOverride() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class h implements b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        private final String f185330a;

        /* renamed from: b, reason: collision with root package name */
        @NonNull
        private final WeakReference<QQAppInterface> f185331b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        private final String f185332c;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        private c f185333d;

        /* renamed from: e, reason: collision with root package name */
        @Nullable
        private final Bundle f185334e;

        /* renamed from: f, reason: collision with root package name */
        private final int f185335f;

        /* renamed from: g, reason: collision with root package name */
        private final boolean f185336g;

        public h(@NonNull String str, @NonNull QQAppInterface qQAppInterface, @Nullable String str2, int i3, @Nullable Bundle bundle, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, qQAppInterface, str2, Integer.valueOf(i3), bundle, Boolean.valueOf(z16));
                return;
            }
            this.f185330a = str;
            this.f185331b = new WeakReference<>(qQAppInterface);
            this.f185332c = str2;
            this.f185335f = i3;
            this.f185334e = bundle;
            this.f185336g = z16;
        }

        public void a(@Nullable c cVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar);
            } else {
                this.f185333d = cVar;
            }
        }

        @Override // com.tencent.mobileqq.activity.recent.bannerprocessor.d.b
        public boolean isNeedAutoCloseWhenAccountChange() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
            }
            return true;
        }

        @Override // com.tencent.mobileqq.activity.recent.bannerprocessor.d.b
        public void onClose() {
            QQAppInterface qQAppInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                if (this.f185333d == null || (qQAppInterface = this.f185331b.get()) == null) {
                    return;
                }
                d.f(qQAppInterface, this.f185333d);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0071  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x007d  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00cd  */
        @Override // com.tencent.mobileqq.activity.recent.bannerprocessor.d.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onEnter() {
            QQAppInterface qQAppInterface;
            Class cls;
            Context context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.recent.banner", 2, "onEnter: " + this.f185333d + " / " + this.f185332c + " / " + this.f185335f + " / " + this.f185330a);
            }
            if (this.f185333d == null || (qQAppInterface = this.f185331b.get()) == null) {
                return;
            }
            if (!TextUtils.isEmpty(this.f185332c)) {
                try {
                    cls = Class.forName(this.f185332c);
                } catch (ClassNotFoundException unused) {
                }
                context = QBaseActivity.sTopActivity;
                if (context == null) {
                    context = BaseApplication.getContext();
                    QLog.d("Q.recent.banner", 1, "sTopActivity is null,set Application context");
                }
                if (context == null) {
                    Intent intent = new Intent(qQAppInterface.getApp(), (Class<?>) cls);
                    intent.setFlags(this.f185335f);
                    if (!(context instanceof Activity)) {
                        intent.addFlags(268435456);
                    }
                    intent.putExtra("banner_fromBanner", true);
                    intent.putExtra("url", this.f185330a);
                    intent.putExtra("banner_webview_extra", this.f185334e);
                    intent.putExtra("force_no_reload", this.f185336g);
                    try {
                        context.startActivity(intent);
                    } catch (Exception e16) {
                        QLog.d("Q.recent.banner", 1, "startActivity,error =" + e16);
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.d("Q.recent.banner", 2, "sTopActivity is null");
                }
                d.f(qQAppInterface, this.f185333d);
            }
            cls = QQBrowserActivity.class;
            context = QBaseActivity.sTopActivity;
            if (context == null) {
            }
            if (context == null) {
            }
            d.f(qQAppInterface, this.f185333d);
        }

        @Override // com.tencent.mobileqq.activity.recent.bannerprocessor.d.b
        public void onOverride() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.recent.banner", 2, "banner for " + this.f185330a + " is overrided");
            }
        }
    }

    private static void a(String str, Intent intent, QQAppInterface qQAppInterface, String str2, String str3) {
        int intExtra = intent.getIntExtra("banner_iconIdx", -1);
        a aVar = new a(str, qQAppInterface);
        aVar.a(g(qQAppInterface, intExtra, str2, str3, aVar));
    }

    public static void b(QQAppInterface qQAppInterface, Intent intent) {
        if (intent.hasExtra("banner_businessCategory") && intent.hasExtra("banner_wording")) {
            String stringExtra = intent.getStringExtra("banner_businessCategory");
            String stringExtra2 = intent.getStringExtra("banner_wording");
            String stringExtra3 = intent.getStringExtra("banner_webViewUrl");
            String stringExtra4 = intent.getStringExtra("banner_activityName");
            String stringExtra5 = intent.getStringExtra("banner_fragmentName");
            int intExtra = intent.getIntExtra("banner_iconIdx", -1);
            int intExtra2 = intent.getIntExtra("banner_activityFlag", 0);
            PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("banner_pendingIntent");
            Bundle bundleExtra = intent.getBundleExtra("banner_webview_extra");
            boolean booleanExtra = intent.getBooleanExtra("force_no_reload", false);
            boolean z16 = !TextUtils.isEmpty(stringExtra3);
            if (stringExtra5 != null) {
                a(stringExtra5, intent, qQAppInterface, stringExtra, stringExtra2);
                return;
            }
            if (z16) {
                e(qQAppInterface, stringExtra, stringExtra2, stringExtra3, stringExtra4, intExtra, intExtra2, bundleExtra, booleanExtra);
                return;
            }
            if (stringExtra.equals(IReadInJoyVideoInteract.BUSINESS_CATEGORY_READINJOY_VIDEO_FEEDS)) {
                ((IReadInJoyVideoInteract) QRoute.api(IReadInJoyVideoInteract.class)).handleReadinjoyVideoIntent(qQAppInterface, intent, pendingIntent, stringExtra, stringExtra2);
            } else if (pendingIntent == null) {
                d(qQAppInterface, intent, stringExtra, stringExtra2, stringExtra4);
            } else {
                c(qQAppInterface, intent, pendingIntent, stringExtra, stringExtra2);
            }
        }
    }

    private static void c(QQAppInterface qQAppInterface, Intent intent, PendingIntent pendingIntent, String str, String str2) {
        int intExtra = intent.getIntExtra("banner_iconIdx", -1);
        if (pendingIntent != null && intExtra >= 0 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            f fVar = new f(pendingIntent, qQAppInterface);
            fVar.a(g(qQAppInterface, intExtra, str, str2, fVar));
            return;
        }
        QLog.e("Q.recent.banner", 1, "invalid intent extra from pendingIntent, " + str + " / " + str2 + " / " + pendingIntent + " / " + intExtra);
    }

    private static void d(QQAppInterface qQAppInterface, Intent intent, String str, String str2, String str3) {
        int intExtra = intent.getIntExtra("banner_plguinType", -1);
        String stringExtra = intent.getStringExtra("banner_pluginId");
        String stringExtra2 = intent.getStringExtra("banner_pluginName");
        String stringExtra3 = intent.getStringExtra("banner_pluginProxyActivityName");
        Intent intent2 = (Intent) intent.getParcelableExtra("banner_pluginIntent");
        int intExtra2 = intent.getIntExtra("banner_iconIdx", -1);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && intExtra >= 0 && !TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2) && !TextUtils.isEmpty(stringExtra3) && intent2 != null && intExtra2 >= 0) {
            g gVar = new g(qQAppInterface, str3, stringExtra3, stringExtra, stringExtra2, intent2, qQAppInterface.getCurrentUin(), intExtra);
            gVar.a(g(qQAppInterface, intExtra2, str, str2, gVar));
            return;
        }
        QLog.e("Q.recent.banner", 1, "invalid intent extra from plugin, " + str + " / " + str2 + " / " + str3 + " / " + intExtra + " / " + stringExtra + " / " + stringExtra2 + " / " + stringExtra3 + " / " + intent2 + " / " + intExtra2);
    }

    private static void e(QQAppInterface qQAppInterface, String str, String str2, String str3, String str4, int i3, int i16, Bundle bundle, boolean z16) {
        String str5;
        int i17;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            try {
                str5 = new URL(str3).getHost();
            } catch (MalformedURLException e16) {
                e16.printStackTrace();
                str5 = "";
            }
            h hVar = new h(str3, qQAppInterface, str4, i16, bundle, z16);
            if (i3 < 0) {
                i17 = com.tencent.mobileqq.banner.b.c(str5);
            } else {
                i17 = i3;
            }
            hVar.a(g(qQAppInterface, i17, str, str2, hVar));
            return;
        }
        QLog.e("Q.recent.banner", 1, "invalid intent extra from webview, " + str + " / " + str2 + " / " + str3);
    }

    public static boolean f(QQAppInterface qQAppInterface, c cVar) {
        if (QLog.isColorLevel()) {
            QLog.d("Q.recent.banner", 2, "hideGeneralBannerInB with: " + cVar);
        }
        MqqHandler handler = qQAppInterface.getHandler(Conversation.class);
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage(Conversation.MSG_HIDE_GENERAL_BANNER);
            obtainMessage.obj = cVar;
            handler.sendMessage(obtainMessage);
            return true;
        }
        return false;
    }

    @Nullable
    public static c g(QQAppInterface qQAppInterface, int i3, String str, String str2, b bVar) {
        MqqHandler handler = qQAppInterface.getHandler(Conversation.class);
        if (handler != null) {
            c cVar = new c(1, str, i3, str2, bVar);
            Message obtainMessage = handler.obtainMessage(Conversation.MSG_SHOW_GENERAL_BANNER);
            obtainMessage.obj = cVar;
            handler.sendMessage(obtainMessage);
            return cVar;
        }
        return null;
    }
}
