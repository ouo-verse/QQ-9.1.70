package com.tencent.biz.subscribe.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes5.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f96290a = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements DialogInterface.OnDismissListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            j.f96290a = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ f f96291d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f96292e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ActionSheet f96293f;

        b(f fVar, String str, ActionSheet actionSheet) {
            this.f96291d = fVar;
            this.f96292e = str;
            this.f96293f = actionSheet;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            this.f96291d.a(false, this.f96292e, true);
            this.f96293f.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class c implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f96294d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f96295e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ f f96296f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ ActionSheet f96297h;

        c(Context context, String str, f fVar, ActionSheet actionSheet) {
            this.f96294d = context;
            this.f96295e = str;
            this.f96296f = fVar;
            this.f96297h = actionSheet;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            if (!j.f96290a) {
                j.f96290a = true;
                if (i3 == 0) {
                    j.g(this.f96294d, this.f96295e, this.f96296f);
                }
                this.f96297h.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class d extends IPublicAccountObserver.c {

        /* renamed from: a, reason: collision with root package name */
        WeakReference<f> f96298a;

        public d(f fVar) {
            this.f96298a = new WeakReference<>(fVar);
        }

        @Override // com.tencent.biz.pubaccount.api.IPublicAccountObserver.c
        public void onFollowPublicAccount(boolean z16, String str) {
            super.onFollowPublicAccount(z16, str);
            f fVar = this.f96298a.get();
            if (fVar != null) {
                fVar.a(z16, str, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class e extends IPublicAccountObserver.c {

        /* renamed from: a, reason: collision with root package name */
        WeakReference<f> f96299a;

        public e(f fVar) {
            this.f96299a = new WeakReference<>(fVar);
        }

        @Override // com.tencent.biz.pubaccount.api.IPublicAccountObserver.c
        public void onUnfollowPublicAccount(boolean z16, String str) {
            super.onFollowPublicAccount(z16, str);
            f fVar = this.f96299a.get();
            if (fVar != null) {
                fVar.a(z16, str, false);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface f {
        void a(boolean z16, String str, boolean z17);
    }

    public static void c(Context context, String str, f fVar) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("SubscribeFollowUserUtil", 2, "follow user failed! user is null");
            return;
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            IPublicAccountObserver iPublicAccountObserver = (IPublicAccountObserver) QRoute.api(IPublicAccountObserver.class);
            iPublicAccountObserver.setOnCallback(new d(fVar));
            ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).followUin((QQAppInterface) runtime, context, str, iPublicAccountObserver, false, 0, true);
            return;
        }
        if (fVar != null) {
            fVar.a(false, str, false);
        }
    }

    public static void d(Context context, String str, f fVar) {
        f(context, str, false, "", R.string.d7k, fVar);
    }

    public static void e(Context context, String str, String str2, f fVar) {
        f(context, str, true, str2, R.string.dz7, fVar);
    }

    public static void f(Context context, String str, boolean z16, String str2, int i3, f fVar) {
        if (context == null) {
            return;
        }
        ActionSheet create = ActionSheet.create(context);
        if (z16) {
            create.setMainTitle(String.format(context.getResources().getString(R.string.d7m), str2));
        }
        create.addButton(i3, 3);
        create.addCancelButton(R.string.cancel);
        create.setOnDismissListener(new a());
        create.setOnBottomCancelListener(new b(fVar, str, create));
        create.setOnButtonClickListener(new c(context, str, fVar, create));
        if (!create.isShowing()) {
            f96290a = false;
            create.show();
        }
    }

    public static void g(Context context, String str, f fVar) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("SubscribeFollowUserUtil", 2, "unfollow user failed! user is null");
            return;
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            IPublicAccountObserver iPublicAccountObserver = (IPublicAccountObserver) QRoute.api(IPublicAccountObserver.class);
            iPublicAccountObserver.setOnCallback(new e(fVar));
            ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).unfollowUin((QQAppInterface) runtime, context, str, false, iPublicAccountObserver, true);
            return;
        }
        if (fVar != null) {
            fVar.a(false, str, false);
        }
    }
}
