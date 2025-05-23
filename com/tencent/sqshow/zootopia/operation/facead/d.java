package com.tencent.sqshow.zootopia.operation.facead;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.recommend.characterV2.event.NewBodyUpdateAgreeEvent;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import mqq.util.WeakReference;
import uv4.bq;
import uv4.br;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/sqshow/zootopia/operation/facead/d;", "Lcom/tencent/sqshow/zootopia/operation/facead/h;", "Landroid/view/View;", "clickedView", "", "r", "<init>", "()V", "L", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class d extends h {

    /* renamed from: L, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static WeakReference<Dialog> M;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0014\u0010\b\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/sqshow/zootopia/operation/facead/d$a;", "", "", "b", "a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/br;", "callback", "c", "", "TAG", "Ljava/lang/String;", "Lmqq/util/WeakReference;", "Landroid/app/Dialog;", "updateDialog", "Lmqq/util/WeakReference;", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.operation.facead.d$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a() {
            Dialog dialog;
            WeakReference weakReference = d.M;
            if (weakReference == null || (dialog = (Dialog) weakReference.get()) == null) {
                return;
            }
            dialog.dismiss();
        }

        public final void b() {
            Activity topActivity = Foreground.getTopActivity();
            if (topActivity == null || topActivity.isDestroyed() || topActivity.isFinishing()) {
                return;
            }
            Dialog c16 = qc4.b.f428851a.c(topActivity, true);
            if (c16 != null) {
                c16.show();
            }
            d.M = new WeakReference(c16);
        }

        public final void c(com.tencent.mobileqq.zootopia.api.e<br> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            va4.c.b(va4.c.f441285a, new bq(), callback, 0, 4, null);
            b();
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/operation/facead/d$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/br;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.api.e<br> {
        b() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(br result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("ZplanFaceAdBodyUpdateHandler", 1, "onAction doUpdateNewBodyReq success");
            SimpleEventBus.getInstance().dispatchEvent(new NewBodyUpdateAgreeEvent());
            com.tencent.sqshow.dresskey.b.f369818a.t("new_body_update", true);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.i("ZplanFaceAdBodyUpdateHandler", 1, "onAction doUpdateNewBodyReq failed error = " + error + " message = " + message);
            CommonExKt.m("\u5347\u7ea7\u5931\u8d25");
            d.INSTANCE.a();
        }
    }

    @Override // com.tencent.sqshow.zootopia.operation.facead.h
    public void r(View clickedView) {
        Intrinsics.checkNotNullParameter(clickedView, "clickedView");
        QLog.i("ZplanFaceAdBodyUpdateHandler", 1, "onAction");
        INSTANCE.c(new b());
    }
}
