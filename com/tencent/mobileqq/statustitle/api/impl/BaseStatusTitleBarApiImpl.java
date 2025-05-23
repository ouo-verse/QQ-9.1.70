package com.tencent.mobileqq.statustitle.api.impl;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statustitle.a;
import com.tencent.mobileqq.statustitle.api.IBaseStatusTitleBarApi;
import com.tencent.mobileqq.statustitle.b;
import com.tencent.mobileqq.statustitle.c;
import com.tencent.mobileqq.statustitle.d;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J&\u0010\u0011\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0012\u001a\u00020\nH\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/statustitle/api/impl/BaseStatusTitleBarApiImpl;", "Lcom/tencent/mobileqq/statustitle/api/IBaseStatusTitleBarApi;", "Lcom/tencent/mobileqq/statustitle/d;", "iBaseStatusTitleBarCb", "Lcom/tencent/biz/richframework/part/Part;", "createBaseStatusTitlePart", "", "msgWhat", "", "extra", "", "notifyNetWorkState", "", "statusInfo", "Landroid/graphics/drawable/Drawable;", "statusIcon", "drawableRight", "notifyStatusInfo", "solveStatusBeforePanelShow", "Lmqq/app/AppRuntime;", "app", "getIconAlphaByTheme", "Landroid/content/res/Resources;", DKConfiguration.Directory.RESOURCES, "getIconColorFilterByTheme", "<init>", "()V", "Companion", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class BaseStatusTitleBarApiImpl implements IBaseStatusTitleBarApi {
    public static final String TAG = "BaseStatusTitleBarApiImpl";

    @Override // com.tencent.mobileqq.statustitle.api.IBaseStatusTitleBarApi
    public Part createBaseStatusTitlePart(d iBaseStatusTitleBarCb) {
        Intrinsics.checkNotNullParameter(iBaseStatusTitleBarCb, "iBaseStatusTitleBarCb");
        return new b(iBaseStatusTitleBarCb);
    }

    @Override // com.tencent.mobileqq.statustitle.api.IBaseStatusTitleBarApi
    public int getIconAlphaByTheme(AppRuntime app) {
        Intrinsics.checkNotNullParameter(app, "app");
        return c.f290185a.a(app);
    }

    @Override // com.tencent.mobileqq.statustitle.api.IBaseStatusTitleBarApi
    public int getIconColorFilterByTheme(Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        return c.f290185a.b(resources);
    }

    @Override // com.tencent.mobileqq.statustitle.api.IBaseStatusTitleBarApi
    public void notifyNetWorkState(int msgWhat, Object extra) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Unit unit = null;
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface != null) {
            MqqHandler handler = qQAppInterface.getHandler(b.class);
            if (handler != null) {
                Intrinsics.checkNotNullExpressionValue(handler, "getHandler(BaseStatusTitlePart::class.java)");
                QLog.i(TAG, 1, "[notifyNetWorkState] handler:" + handler);
                handler.obtainMessage(msgWhat, extra).sendToTarget();
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                QLog.i(TAG, 1, "[notifyNetWorkState] getHandler is null, return");
                return;
            }
            return;
        }
        QLog.i(TAG, 1, "[notifyNetWorkState] appRuntime is not QQAppInterface, return");
    }

    @Override // com.tencent.mobileqq.statustitle.api.IBaseStatusTitleBarApi
    public void notifyStatusInfo(String statusInfo, Drawable statusIcon, Drawable drawableRight) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Unit unit = null;
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface != null) {
            MqqHandler handler = qQAppInterface.getHandler(b.class);
            if (handler != null) {
                Intrinsics.checkNotNullExpressionValue(handler, "getHandler(BaseStatusTitlePart::class.java)");
                handler.obtainMessage(1, new a(statusInfo, statusIcon, drawableRight)).sendToTarget();
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                QLog.i(TAG, 1, "[notifyStatusInfo] getHandler is null, return");
                return;
            }
            return;
        }
        QLog.i(TAG, 1, "[notifyStatusInfo] appRuntime is not QQAppInterface, return");
    }

    @Override // com.tencent.mobileqq.statustitle.api.IBaseStatusTitleBarApi
    public void solveStatusBeforePanelShow() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Unit unit = null;
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface != null) {
            MqqHandler handler = qQAppInterface.getHandler(b.class);
            if (handler != null) {
                Intrinsics.checkNotNullExpressionValue(handler, "getHandler(BaseStatusTitlePart::class.java)");
                QLog.i(TAG, 1, "[solveStatusBeforePanelShow] handler:" + handler);
                handler.obtainMessage(2).sendToTarget();
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                QLog.i(TAG, 1, "[solveStatusBeforePanelShow] getHandler is null, return");
                return;
            }
            return;
        }
        QLog.i(TAG, 1, "[solveStatusBeforePanelShow] appRuntime is not QQAppInterface, return");
    }
}
