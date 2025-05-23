package com.tencent.qqnt.notification;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.NotificationCommonInfo;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0013\u0010\u0005\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0096\u0002\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/notification/NotificationFacade$showMessageNotification$showFunc$1", "Lkotlin/Function1;", "Lcom/tencent/qqnt/ntrelation/otherinfo/bean/a;", "", "friendOtherInfo", "a", "notification_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class NotificationFacade$showMessageNotification$showFunc$1 implements Function1<com.tencent.qqnt.ntrelation.otherinfo.bean.a, Unit> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ NotificationFacade f359792d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ AppRuntime f359793e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ RecentContactInfo f359794f;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ NotificationCommonInfo f359795h;

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ boolean f359796i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NotificationFacade$showMessageNotification$showFunc$1(NotificationFacade notificationFacade, AppRuntime appRuntime, RecentContactInfo recentContactInfo, NotificationCommonInfo notificationCommonInfo, boolean z16) {
        this.f359792d = notificationFacade;
        this.f359793e = appRuntime;
        this.f359794f = recentContactInfo;
        this.f359795h = notificationCommonInfo;
        this.f359796i = z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, notificationFacade, appRuntime, recentContactInfo, notificationCommonInfo, Boolean.valueOf(z16));
        }
    }

    public void a(@Nullable com.tencent.qqnt.ntrelation.otherinfo.bean.a friendOtherInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.f359792d.C()), null, null, new NotificationFacade$showMessageNotification$showFunc$1$invoke$1(this.f359792d, this.f359793e, this.f359794f, friendOtherInfo, this.f359795h, this.f359796i, null), 3, null);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) friendOtherInfo);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.ntrelation.otherinfo.bean.a aVar) {
        a(aVar);
        return Unit.INSTANCE;
    }
}
