package com.tencent.mobileqq.onlinestatus.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.ar;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J,\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/utils/d;", "", "Lmqq/app/AppRuntime$Status;", "status", "", "extStatus", "", "a", "Landroid/content/Context;", "context", "Landroid/content/DialogInterface$OnClickListener;", "onClickListener", "Landroid/app/Dialog;", "b", "<init>", "()V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
final class d {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/onlinestatus/utils/d$b", "Landroid/view/View$AccessibilityDelegate;", "Landroid/view/View;", "host", "", "eventType", "", "sendAccessibilityEvent", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b extends View.AccessibilityDelegate {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ClickableSpan f256356a;

        b(ClickableSpan clickableSpan) {
            this.f256356a = clickableSpan;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(@Nullable View host, int eventType) {
            super.sendAccessibilityEvent(host, eventType);
            if (eventType == 1 && host != null) {
                this.f256356a.onClick(host);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/onlinestatus/utils/d$c", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "Landroid/text/TextPaint;", "ds", "updateDrawState", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class c extends ClickableSpan {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppRuntime.Status f256357d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f256358e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<QQCustomDialog> f256359f;

        c(AppRuntime.Status status, long j3, Ref.ObjectRef<QQCustomDialog> objectRef) {
            this.f256357d = status;
            this.f256358e = j3;
            this.f256359f = objectRef;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            Activity activity;
            QQCustomDialog qQCustomDialog;
            Intrinsics.checkNotNullParameter(widget, "widget");
            Intent intent = new Intent();
            intent.putExtra("KEY_ONLINE_STATUS", this.f256357d);
            intent.putExtra("KEY_ONLINE_EXT_STATUS", this.f256358e);
            Context context = widget.getContext();
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                activity = null;
            }
            if (activity == null) {
                activity = Foreground.getTopActivity();
            }
            if (activity == null) {
                return;
            }
            QPublicFragmentActivity.startForResult(activity, intent, (Class<? extends QPublicBaseFragment>) AccountOnlineStateActivity.class, 234);
            QQCustomDialog qQCustomDialog2 = this.f256359f.element;
            if (qQCustomDialog2 != null) {
                QQCustomDialog qQCustomDialog3 = qQCustomDialog2;
                boolean z16 = false;
                if (qQCustomDialog3 != null && qQCustomDialog3.isShowing()) {
                    z16 = true;
                }
                if (z16 && (qQCustomDialog = this.f256359f.element) != null) {
                    qQCustomDialog.dismiss();
                }
            }
            ReportController.o(null, "dc00898", "", "", "0X8009DE2", "0X8009DE2", 0, 0, "", "", "", "");
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint ds5) {
            Intrinsics.checkNotNullParameter(ds5, "ds");
            super.updateDrawState(ds5);
            ds5.setUnderlineText(false);
            ds5.setColor(Color.parseColor("#40A0FF"));
        }
    }

    public boolean a(@NotNull AppRuntime.Status status, long extStatus) {
        Intrinsics.checkNotNullParameter(status, "status");
        return ar.a(status);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, com.tencent.mobileqq.utils.QQCustomDialog] */
    @Nullable
    public Dialog b(@NotNull Context context, @NotNull AppRuntime.Status status, long extStatus, @Nullable DialogInterface.OnClickListener onClickListener) {
        IOnlineStatusManagerService iOnlineStatusManagerService;
        com.tencent.mobileqq.onlinestatus.manager.b bVar;
        String str;
        int i3;
        TextView textView;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(status, "status");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String string = context.getResources().getString(R.string.f68, com.tencent.mobileqq.onlinestatus.af.C().P(extStatus, status));
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026status_title, statusName)");
        if (peekAppRuntime != null) {
            iOnlineStatusManagerService = (IOnlineStatusManagerService) peekAppRuntime.getRuntimeService(IOnlineStatusManagerService.class, "");
        } else {
            iOnlineStatusManagerService = null;
        }
        if (iOnlineStatusManagerService != null) {
            bVar = (com.tencent.mobileqq.onlinestatus.manager.b) iOnlineStatusManagerService.getManager(com.tencent.mobileqq.onlinestatus.manager.b.class);
        } else {
            bVar = null;
        }
        AutoReplyText autoReplyText = new AutoReplyText();
        if (bVar != null) {
            autoReplyText = bVar.a();
            Intrinsics.checkNotNullExpressionValue(autoReplyText, "autoReplyManager.currentAutoReplyText");
        }
        String str2 = autoReplyText.mRawText;
        Paint paint = new Paint();
        paint.setTextSize(ViewUtils.spToPx(14.0f));
        if (status == AppRuntime.Status.dnd) {
            str = "\u5207\u6362\u540e\uff0c\u65b0\u6d88\u606f\u5c06\u4e0d\u518d\u63d0\u9192\u3002\u5f53\u524d\u81ea\u52a8\u56de\u590d\u5185\u5bb9\u4e3a\uff1a\u201c";
            i3 = 4;
        } else {
            str = "\u5f53\u524d\u81ea\u52a8\u56de\u590d\u5185\u5bb9\u4e3a\uff1a\u201c";
            i3 = 3;
        }
        String subQQTextString = TextUtils.subQQTextString(str2, paint, 3, 16, (int) (ViewUtils.dpToPx(i3 * 242) - paint.measureText(str + "%s\u201d \u70b9\u51fb\u53ef\u4fee\u6539>>")), true);
        String str3 = str + subQQTextString + "\u201d \u70b9\u51fb\u53ef\u4fee\u6539>>";
        String trimContent = AutoReplyText.trimRawString(str3, true);
        QLog.d("AutoReplyDialogProvider", 1, "content: " + str3 + " \n replyTips: " + subQQTextString + " \n trimContent: " + trimContent);
        Intrinsics.checkNotNullExpressionValue(trimContent, "trimContent");
        SpannableString spannableString = new SpannableString(trimContent);
        c cVar = new c(status, extStatus, objectRef);
        spannableString.setSpan(cVar, trimContent.length() + (-7), trimContent.length(), 33);
        ?? messageWithoutAutoLink = DialogUtil.createCustomDialog(context, 230).setTitle(string).setMessageWithoutAutoLink(new QQText(spannableString, 3, 16));
        objectRef.element = messageWithoutAutoLink;
        if (AppSetting.f99565y) {
            if (messageWithoutAutoLink != 0) {
                textView = messageWithoutAutoLink.getMessageTextView();
            } else {
                textView = null;
            }
            if (textView != null) {
                textView.setAccessibilityDelegate(new b(cVar));
            }
        }
        QQCustomDialog qQCustomDialog = (QQCustomDialog) objectRef.element;
        if (qQCustomDialog != null) {
            qQCustomDialog.setPositiveButton(R.string.f66, onClickListener);
        }
        QQCustomDialog qQCustomDialog2 = (QQCustomDialog) objectRef.element;
        if (qQCustomDialog2 != null) {
            qQCustomDialog2.setNegativeButton(R.string.f171475f62, onClickListener);
        }
        return (Dialog) objectRef.element;
    }
}
