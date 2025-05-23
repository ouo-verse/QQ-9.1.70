package com.tencent.mobileqq.setting.main.account;

import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.setting.utils.o;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.utils.u;
import com.tencent.mobileqq.vas.qid.VipQidHelper;
import com.tencent.mobileqq.widget.listitem.g;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\f\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/setting/main/account/QIDProcessor;", "Lcom/tencent/mobileqq/setting/processor/c;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/widget/listitem/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "onResume", "o", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "g", "a", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class QIDProcessor extends com.tencent.mobileqq.setting.processor.c {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QIDProcessor(Context context) {
        super(context, 2);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void A() {
        String str;
        com.tencent.mobileqq.widget.listitem.a<?> g16 = g();
        com.tencent.mobileqq.setting.config.b bVar = g16 instanceof com.tencent.mobileqq.setting.config.b ? (com.tencent.mobileqq.setting.config.b) g16 : null;
        if (bVar != null) {
            if (VipQidHelper.isQidOpen(f())) {
                str = "\u5df2\u5f00\u542f";
            } else {
                str = "\u672a\u5f00\u542f";
            }
            bVar.N(str);
            l();
        }
        VipQidHelper.reportQIdEvent("0X800B5C6", x());
    }

    private final int x() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface == null) {
            return 0;
        }
        if (VipQidHelper.isQidOpen(qQAppInterface)) {
            return VipInfoHandler.J2(qQAppInterface, qQAppInterface.getCurrentUin(), false) == 2 ? 4 : 3;
        }
        IRuntimeService runtimeService = qQAppInterface.getRuntimeService(IRedTouchManager.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026nstant.MAIN\n            )");
        return ((IRedTouchManager) runtimeService).getAppInfoByPath("100190.100193.100192") != null ? 1 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        o.f286768a.l(view, "em_bas_qid", null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z() {
        if (u.a().b() || e() == null) {
            return;
        }
        VipQidHelper.jumpQidSetInfoPage(e(), null);
        VipQidHelper.reportQIdEvent("0X800B5C7", x());
    }

    @Override // com.tencent.mobileqq.setting.processor.c
    public void o() {
        super.o();
        A();
    }

    @Override // com.tencent.mobileqq.setting.processor.c, com.tencent.mobileqq.setting.processor.d
    public void onResume() {
        super.onResume();
        A();
    }

    @Override // com.tencent.mobileqq.setting.processor.c
    public com.tencent.mobileqq.widget.listitem.a<?> q() {
        String str;
        String string = BaseApplication.context.getString(R.string.f196604hr);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.qid_item_title)");
        com.tencent.mobileqq.setting.config.b bVar = new com.tencent.mobileqq.setting.config.b(string, R.drawable.qui_qid, "100190.100193.100192", new Function1<View, Unit>() { // from class: com.tencent.mobileqq.setting.main.account.QIDProcessor$onCreateItemConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                QIDProcessor.this.z();
                o.f286768a.f(it, "em_bas_qid", null);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }
        });
        if (VipQidHelper.isQidOpen(f())) {
            str = "\u5df2\u5f00\u542f";
        } else {
            str = "\u672a\u5f00\u542f";
        }
        bVar.N(str);
        bVar.w(new g() { // from class: com.tencent.mobileqq.setting.main.account.d
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                QIDProcessor.y(view);
            }
        });
        return bVar;
    }
}
