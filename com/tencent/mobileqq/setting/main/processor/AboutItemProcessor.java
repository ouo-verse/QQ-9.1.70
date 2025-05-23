package com.tencent.mobileqq.setting.main.processor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.about.AboutFragment;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.widget.listitem.x;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import mqq.manager.Manager;

@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u001e\u0018\u0000 &2\u00020\u0001:\u0001'B\u000f\u0012\u0006\u0010#\u001a\u00020\"\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\f\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016R\u001b\u0010\u0012\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R'\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/setting/main/processor/AboutItemProcessor;", "Lcom/tencent/mobileqq/setting/processor/c;", "", UserInfo.SEX_FEMALE, "", "D", "E", "Lcom/tencent/mobileqq/widget/listitem/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "onCreate", "onResume", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "o", "", "g", "Lkotlin/Lazy;", "B", "()Ljava/lang/String;", "leftText", "Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;", tl.h.F, "Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;", "upgradeDetailWrapper", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$b;", "Lcom/tencent/mobileqq/widget/listitem/x$c$d;", "i", BdhLogUtil.LogTag.Tag_Conn, "()Lcom/tencent/mobileqq/widget/listitem/x;", "singleLineConfig", "com/tencent/mobileqq/setting/main/processor/AboutItemProcessor$b", "j", "Lcom/tencent/mobileqq/setting/main/processor/AboutItemProcessor$b;", "configObserver", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "k", "a", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class AboutItemProcessor extends com.tencent.mobileqq.setting.processor.c {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Lazy leftText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private UpgradeDetailWrapper upgradeDetailWrapper;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Lazy singleLineConfig;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final b configObserver;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/setting/main/processor/AboutItemProcessor$b", "Lcom/tencent/mobileqq/app/h;", "", "isSuccess", "Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;", "wrapper", "", "p", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends com.tencent.mobileqq.app.h {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.h
        public void p(boolean isSuccess, UpgradeDetailWrapper wrapper) {
            super.p(isSuccess, wrapper);
            AboutItemProcessor.this.upgradeDetailWrapper = wrapper;
            AboutItemProcessor.this.F();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AboutItemProcessor(final Context context) {
        super(context, 15);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.setting.main.processor.AboutItemProcessor$leftText$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return context.getString(R.string.fre);
            }
        });
        this.leftText = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new AboutItemProcessor$singleLineConfig$2(this));
        this.singleLineConfig = lazy2;
        this.configObserver = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String B() {
        return (String) this.leftText.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final x<x.b.C8996b, x.c.d> C() {
        return (x) this.singleLineConfig.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean D() {
        boolean j3 = com.tencent.mobileqq.upgrade.n.j();
        if (j3) {
            return j3;
        }
        AppInterface f16 = f();
        Manager manager = f16 != null ? f16.getManager(QQManagerFactory.TIM_UPGRADE_HONGDIAN_MANAGER) : null;
        com.tencent.mobileqq.managers.l lVar = manager instanceof com.tencent.mobileqq.managers.l ? (com.tencent.mobileqq.managers.l) manager : null;
        return lVar != null && lVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E() {
        Activity e16 = e();
        if (e16 != null) {
            QPublicFragmentActivity.start(e16, new Intent(), AboutFragment.class);
        }
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new AboutItemProcessor$onItemClick$2(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F() {
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new AboutItemProcessor$updateNewOrRedDotUi$1(this, null), 2, null);
    }

    @Override // com.tencent.mobileqq.setting.processor.c
    public void o() {
        super.o();
        AppInterface f16 = f();
        if (f16 != null) {
            f16.addObserver(this.configObserver);
        }
    }

    @Override // com.tencent.mobileqq.setting.processor.c, com.tencent.mobileqq.setting.processor.d
    public void onCreate() {
        super.onCreate();
        this.upgradeDetailWrapper = com.tencent.mobileqq.upgrade.k.i().j();
        AppInterface f16 = f();
        if (f16 != null) {
            f16.addObserver(this.configObserver);
        }
    }

    @Override // com.tencent.mobileqq.setting.processor.c, com.tencent.mobileqq.setting.processor.d
    public void onDestroy() {
        super.onDestroy();
        AppInterface f16 = f();
        if (f16 != null) {
            f16.removeObserver(this.configObserver);
        }
    }

    @Override // com.tencent.mobileqq.setting.processor.c, com.tencent.mobileqq.setting.processor.d
    public void onResume() {
        super.onResume();
        F();
    }

    @Override // com.tencent.mobileqq.setting.processor.c
    public com.tencent.mobileqq.widget.listitem.a<?> q() {
        return C();
    }
}
