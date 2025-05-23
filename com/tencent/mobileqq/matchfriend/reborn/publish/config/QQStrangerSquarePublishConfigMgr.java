package com.tencent.mobileqq.matchfriend.reborn.publish.config;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J-\u0010\t\u001a\u00020\u00072#\u0010\b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002H\u0002J+\u0010\f\u001a\u00020\u00072#\u0010\b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00070\u0002J\u0006\u0010\u000e\u001a\u00020\rR\u0016\u0010\u0006\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/publish/config/QQStrangerSquarePublishConfigMgr;", "", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/matchfriend/reborn/publish/config/a;", "Lkotlin/ParameterName;", "name", DownloadInfo.spKey_Config, "", "cb", "d", "Lcom/tencent/mobileqq/matchfriend/reborn/publish/config/b;", "tipsBean", "f", "", "e", "b", "Lcom/tencent/mobileqq/matchfriend/reborn/publish/config/a;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "c", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasInit", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerSquarePublishConfigMgr {

    /* renamed from: a, reason: collision with root package name */
    public static final QQStrangerSquarePublishConfigMgr f245289a = new QQStrangerSquarePublishConfigMgr();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static com.tencent.mobileqq.matchfriend.reborn.publish.config.a config = new com.tencent.mobileqq.matchfriend.reborn.publish.config.a();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final AtomicBoolean hasInit = new AtomicBoolean(false);

    QQStrangerSquarePublishConfigMgr() {
    }

    private final void d(Function1<? super com.tencent.mobileqq.matchfriend.reborn.publish.config.a, Unit> cb5) {
        if (hasInit.get()) {
            cb5.invoke(config);
        }
        ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadLargeConfigAsync("qqstranger_square_publish_recommend", new a(cb5));
    }

    public final String e() {
        String format = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT, Locale.getDefault()).format(new Date());
        Intrinsics.checkNotNullExpressionValue(format, "dateFormat.format(Date())");
        return format;
    }

    public final void f(final Function1<? super TipsBean, Unit> cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        d(new Function1<com.tencent.mobileqq.matchfriend.reborn.publish.config.a, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.publish.config.QQStrangerSquarePublishConfigMgr$getTodayTipsConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(a aVar) {
                if (aVar == null) {
                    cb5.invoke(null);
                    return;
                }
                Function1<TipsBean, Unit> function1 = cb5;
                TipsBean tipsBean = aVar.b().get(QQStrangerSquarePublishConfigMgr.f245289a.e());
                if (tipsBean == null) {
                    tipsBean = aVar.getDefault();
                }
                function1.invoke(tipsBean);
            }
        });
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/publish/config/QQStrangerSquarePublishConfigMgr$a", "Lpy2/a;", "Lcom/tencent/mobileqq/matchfriend/reborn/publish/config/a;", DownloadInfo.spKey_Config, "", "b", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class a implements py2.a<com.tencent.mobileqq.matchfriend.reborn.publish.config.a> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<com.tencent.mobileqq.matchfriend.reborn.publish.config.a, Unit> f245292a;

        /* JADX WARN: Multi-variable type inference failed */
        a(Function1<? super com.tencent.mobileqq.matchfriend.reborn.publish.config.a, Unit> function1) {
            this.f245292a = function1;
        }

        @Override // py2.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(com.tencent.mobileqq.matchfriend.reborn.publish.config.a config) {
            boolean z16 = false;
            if (config != null && config.c()) {
                z16 = true;
            }
            if (z16) {
                QQStrangerSquarePublishConfigMgr.hasInit.set(true);
                QQStrangerSquarePublishConfigMgr.config = config;
                this.f245292a.invoke(QQStrangerSquarePublishConfigMgr.config);
            } else {
                QLog.e("QQStrangerSquarePublishConfigMgr", 1, "loadLargeConfigAsync config=" + config);
                this.f245292a.invoke(null);
            }
        }
    }
}
