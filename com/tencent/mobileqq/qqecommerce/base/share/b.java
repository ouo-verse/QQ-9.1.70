package com.tencent.mobileqq.qqecommerce.base.share;

import android.app.Activity;
import android.content.Intent;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.config.api.IECLocalConfig;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.u;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u000f\u0012\u0006\u0010\f\u001a\u00020\t\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\b\u001a\u00020\u0006H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/base/share/b;", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "", "show", "", BdhLogUtil.LogTag.Tag_Req, "dismiss", "Landroid/app/Activity;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/view/ViewGroup;", "D", "Landroid/view/ViewGroup;", "mCheckBoxLayout", "Landroid/widget/CheckBox;", "E", "Landroid/widget/CheckBox;", "mCheckBox", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "mCheckText", "Loe2/a;", "G", "Loe2/a;", "localConfig", "<init>", "(Landroid/app/Activity;)V", "H", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class b extends QQCustomDialog {

    /* renamed from: C, reason: from kotlin metadata */
    private final Activity activity;

    /* renamed from: D, reason: from kotlin metadata */
    private final ViewGroup mCheckBoxLayout;

    /* renamed from: E, reason: from kotlin metadata */
    private final CheckBox mCheckBox;

    /* renamed from: F, reason: from kotlin metadata */
    private final TextView mCheckText;

    /* renamed from: G, reason: from kotlin metadata */
    private final oe2.a localConfig;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qqecommerce/base/share/b$b", "Landroid/text/style/ClickableSpan;", "Landroid/text/TextPaint;", "ds", "", "updateDrawState", "Landroid/view/View;", "arg0", NodeProps.ON_CLICK, "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqecommerce.base.share.b$b, reason: collision with other inner class name */
    /* loaded from: classes35.dex */
    public static final class C8298b extends ClickableSpan {
        C8298b() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View arg0) {
            Intrinsics.checkNotNullParameter(arg0, "arg0");
            if (u.a().b()) {
                return;
            }
            Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) QQBrowserActivity.class);
            intent.setFlags(134217728);
            intent.putExtra("url", "https://support.qq.com/products/394271/faqs/136033");
            intent.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, false);
            intent.putExtra("show_right_close_button", false);
            intent.putExtra("startOpenPageTime", System.currentTimeMillis());
            b.this.activity.startActivity(intent);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds5) {
            Intrinsics.checkNotNullParameter(ds5, "ds");
            ds5.setColor(ContextCompat.getColor(b.this.activity, R.color.f7173j));
            ds5.setUnderlineText(true);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Activity activity) {
        super(activity, R.style.qZoneInputDialog);
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        this.localConfig = new oe2.a();
        setContentView(R.layout.f167845je);
        this.text.setMovementMethod(LinkMovementMethod.getInstance());
        this.text.setText(Q());
        View findViewById = findViewById(R.id.e2z);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(com.tencent\u2026q.qqui.R.id.layout_check)");
        this.mCheckBoxLayout = (ViewGroup) findViewById;
        View findViewById2 = findViewById(R.id.juo);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(com.tencent\u2026leqq.qqui.R.id.tos_check)");
        this.mCheckBox = (CheckBox) findViewById2;
        View findViewById3 = findViewById(R.id.kdc);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(com.tencent\u2026leqq.qqui.R.id.txt_check)");
        TextView textView = (TextView) findViewById3;
        this.mCheckText = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqecommerce.base.share.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.O(b.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(b this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mCheckBox.setChecked(!r1.isChecked());
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void R(boolean show) {
        this.mCheckBoxLayout.setVisibility(show ? 0 : 8);
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialog, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        boolean isChecked = this.mCheckBox.isChecked();
        QLog.i("ECAddShortCutPermissionDialog", 1, "save dialog hide config:" + isChecked);
        IECLocalConfig.a.h(this.localConfig, "shortcut_dialog_hide", isChecked, null, 4, null);
        super.dismiss();
    }

    private final CharSequence Q() {
        String qqStr = HardCodeUtil.qqStr(R.string.tfy);
        String qqStr2 = HardCodeUtil.qqStr(R.string.f172703tg2);
        SpannableString spannableString = new SpannableString(qqStr + qqStr2);
        spannableString.setSpan(new C8298b(), qqStr.length(), qqStr.length() + qqStr2.length(), 33);
        return spannableString;
    }
}
