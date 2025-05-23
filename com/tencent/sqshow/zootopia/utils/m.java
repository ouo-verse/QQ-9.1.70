package com.tencent.sqshow.zootopia.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.recommend.characterV2.event.NewBodyUpdateAgreeEvent;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import qv4.bj;
import uv4.br;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b&\u0010'J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J*\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0012\u0010\u0011\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\u0012\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\u0013\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006H\u0002J \u0010\u0014\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J^\u0010!\u001a\u00020 2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001c2\b\u0010\u000b\u001a\u0004\u0018\u00010\u001fR\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/sqshow/zootopia/utils/m;", "", "Landroid/content/Context;", "context", "Lqv4/bj;", "notification", "Landroid/view/View;", "logicParent", "", "i", "Lcom/tencent/image/URLDrawable;", "drawable", "f", "", "url", "e", "view", "k", "l", "j", tl.h.F, "", "type", "titleText", "", "contentText", "strlbtnText", "strrBtnText", "Landroid/content/DialogInterface$OnClickListener;", "onConfirm", "onCancel", "Landroid/graphics/drawable/Drawable;", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "d", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "b", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "dtViewReporter", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final m f373287a = new m();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final ZplanViewReportHelper dtViewReporter = new ZplanViewReportHelper();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/utils/m$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/br;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements com.tencent.mobileqq.zootopia.api.e<br> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<View> f373289d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ DialogInterface f373290e;

        a(Ref.ObjectRef<View> objectRef, DialogInterface dialogInterface) {
            this.f373289d = objectRef;
            this.f373290e = dialogInterface;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(br result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("PortalSystemNotificationHandler", 1, "doUpdateNewBodyReq success");
            SimpleEventBus.getInstance().dispatchEvent(new NewBodyUpdateAgreeEvent());
            m.f373287a.l(this.f373289d.element);
            this.f373290e.dismiss();
            com.tencent.sqshow.dresskey.b.f369818a.t("new_body_update", true);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("PortalSystemNotificationHandler", 1, "doUpdateNewBodyReq failed error = " + error + " message = " + message);
            CommonExKt.m("\u5347\u7ea7\u5931\u8d25");
            com.tencent.sqshow.zootopia.operation.facead.d.INSTANCE.a();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\t\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\r\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/sqshow/zootopia/utils/m$b", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "d", "", "onLoadSuccessed", "drawable", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "onLoadFialed", "onLoadCanceled", "", "progress", "onLoadProgressed", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f373291d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ bj f373292e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f373293f;

        b(Context context, bj bjVar, View view) {
            this.f373291d = context;
            this.f373292e = bjVar;
            this.f373293f = view;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable drawable) {
            QLog.e("PortalSystemNotificationHandler", 1, "handleUpdateBodyNotification onLoadCanceled");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable drawable, Throwable cause) {
            QLog.e("PortalSystemNotificationHandler", 1, "handleUpdateBodyNotification onLoadFialed");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable d16) {
            if (d16 != null) {
                m.f373287a.f(this.f373291d, this.f373292e, this.f373293f, d16);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable drawable, int progress) {
        }
    }

    m() {
    }

    private final URLDrawable e(String url) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = new ColorDrawable(0);
        obtain.mFailedDrawable = new ColorDrawable(0);
        obtain.mRequestHeight = ViewUtils.dpToPx(155.0f);
        obtain.mRequestWidth = ViewUtils.dpToPx(296.0f);
        URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
        Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(url, options)");
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void g(Ref.ObjectRef reportView, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(reportView, "$reportView");
        f373287a.j((View) reportView.element);
        com.tencent.sqshow.zootopia.operation.facead.d.INSTANCE.c(new a(reportView, dialogInterface));
    }

    private final void i(Context context, bj notification, View logicParent) {
        pu4.g gVar = notification.f430073e;
        String str = gVar != null ? gVar.f427434a : null;
        if (str == null) {
            return;
        }
        URLDrawable e16 = e(str);
        if (e16.getStatus() == 1) {
            f(context, notification, logicParent, e16);
        } else {
            e16.setURLDrawableListener(new b(context, notification, logicParent));
            e16.startDownload();
        }
    }

    public final QQCustomDialog d(Context context, int type, String titleText, CharSequence contentText, String strlbtnText, String strrBtnText, DialogInterface.OnClickListener onConfirm, DialogInterface.OnClickListener onCancel, Drawable drawable) {
        QQCustomDialog qQCustomDialog = new QQCustomDialog(context, R.style.qZoneInputDialog);
        qQCustomDialog.setContentView(R.layout.e58);
        qQCustomDialog.setBackground(0);
        qQCustomDialog.setTitle(titleText);
        qQCustomDialog.setMessage(contentText);
        View findViewById = qQCustomDialog.findViewById(R.id.fe7);
        Intrinsics.checkNotNullExpressionValue(findViewById, "alertDialog.findViewById(R.id.operateImage)");
        ImageView imageView = (ImageView) findViewById;
        imageView.setImageDrawable(drawable);
        imageView.setVisibility(0);
        qQCustomDialog.setNegativeButton(strlbtnText, onCancel);
        qQCustomDialog.setPositiveButton(strrBtnText, onConfirm);
        qQCustomDialog.setCanceledOnTouchOutside(false);
        qQCustomDialog.setCancelable(false);
        return qQCustomDialog;
    }

    public final void h(Context context, bj notification, View logicParent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(notification, "notification");
        int i3 = notification.f430074f;
        if (i3 == 1) {
            i(context, notification, logicParent);
            return;
        }
        QLog.w("PortalSystemNotificationHandler", 1, "handleNotification unknown type:" + i3);
    }

    private final void j(View view) {
        if (view != null) {
            dtViewReporter.e(view, "em_zplan_avatar_update", new LinkedHashMap());
        }
    }

    private final void k(View view) {
        if (view != null) {
            dtViewReporter.g(view, "em_zplan_avatar_update", (r16 & 4) != 0 ? null : new LinkedHashMap(), (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(View view) {
        if (view != null) {
            ZplanViewReportHelper.j(dtViewReporter, view, "em_zplan_avatar_update", new LinkedHashMap(), false, null, 16, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [T, android.view.ViewGroup] */
    public final void f(Context context, bj notification, View logicParent, URLDrawable drawable) {
        QLog.i("PortalSystemNotificationHandler", 1, "handleLoadSucceed");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        QQCustomDialog d16 = d(context, 230, notification.f430069a, notification.f430070b, null, notification.f430071c, new DialogInterface.OnClickListener() { // from class: com.tencent.sqshow.zootopia.utils.l
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                m.g(Ref.ObjectRef.this, dialogInterface, i3);
            }
        }, null, drawable);
        com.tencent.mobileqq.simpleui.c.i(d16, 1001);
        Window window = d16.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.8f;
            attributes.height = -1;
            attributes.width = -1;
            window.setAttributes(attributes);
        }
        try {
            d16.show();
            if (logicParent != null) {
                objectRef.element = d16.getRootView();
                VideoReport.setLogicParent(d16.getRootView(), logicParent);
                f373287a.k((View) objectRef.element);
            }
        } catch (Throwable th5) {
            QLog.e("PortalSystemNotificationHandler", 1, "dialog show error", th5);
        }
    }
}
