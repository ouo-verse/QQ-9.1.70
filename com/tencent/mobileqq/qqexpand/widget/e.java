package com.tencent.mobileqq.qqexpand.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.ui.dialog.DialogFromBottom;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0017\u0010\u0018J2\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006J\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0006R$\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/widget/e;", "Lcom/tencent/mobileqq/mini/ui/dialog/DialogFromBottom;", "Landroid/content/Context;", "context", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "", "uin", "", "uinType", "from", "", ExifInterface.LATITUDE_SOUTH, "content", "Y", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "getMContentTv", "()Landroid/widget/TextView;", "setMContentTv", "(Landroid/widget/TextView;)V", "mContentTv", "<init>", "(Landroid/content/Context;Lcom/tencent/common/app/business/BaseQQAppInterface;Ljava/lang/String;ILjava/lang/String;)V", "D", "a", "qqexpand_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class e extends DialogFromBottom {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView mContentTv;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Context context, BaseQQAppInterface baseQQAppInterface, String str, int i3, String from) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(from, "from");
        S(context, baseQQAppInterface, str, i3, from);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(e this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isShowing()) {
            ReportController.o(null, "dc00898", "", "", "0X800B2CF", "0X800B2CF", 2, 0, "", "", "", "");
            this$0.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(Context context, e this$0, String str, String from, BaseQQAppInterface baseQQAppInterface, int i3, View view) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(from, "$from");
        if (!NetworkUtil.isNetSupport(context)) {
            if (this$0.isShowing()) {
                this$0.dismiss();
            }
            QQToast.makeText(context, 1, context.getResources().getString(R.string.b3j), 0).show();
        } else if (str != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("frompage", from);
            hashMap.put("to_uid", str);
            ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#doghouse_page#doghouse", true, -1L, -1L, hashMap, true, true);
            Object businessHandler = baseQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
            Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.qqexpand.network.IExpandHandler");
            ((com.tencent.mobileqq.qqexpand.network.e) businessHandler).X(str, i3);
            if (this$0.isShowing()) {
                this$0.dismiss();
            }
        }
        ReportController.o(null, "dc00898", "", "", "0X800B2CF", "0X800B2CF", 1, 0, "", "", "", "");
    }

    public final void S(final Context context, final BaseQQAppInterface app, final String uin, final int uinType, final String from) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(from, "from");
        if (app != null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.gwo, (ViewGroup) null);
            Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.LinearLayout");
            LinearLayout linearLayout = (LinearLayout) inflate;
            ((ImageView) linearLayout.findViewById(R.id.y_4)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqexpand.widget.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e.U(e.this, view);
                }
            });
            setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.mobileqq.qqexpand.widget.c
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    e.W(dialogInterface);
                }
            });
            this.mContentTv = (TextView) linearLayout.findViewById(R.id.k6s);
            ((Button) linearLayout.findViewById(R.id.tcy)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqexpand.widget.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e.X(context, this, uin, from, app, uinType, view);
                }
            });
            View findViewById = linearLayout.findViewById(R.id.u0d);
            Intrinsics.checkNotNullExpressionValue(findViewById, "contentView.findViewById(R.id.cold_palace)");
            ((URLImageView) findViewById).setImageURL("https://downv6.qq.com/qq_relation/cold_palace/aio_limit_chat_cold_palace.png");
            setContentView(linearLayout);
        }
    }

    public final void Y(String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        TextView textView = this.mContentTv;
        if (textView != null) {
            textView.setText(content);
        }
        show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(DialogInterface dialogInterface) {
        ReportController.o(null, "dc00898", "", "", "0X800B2CF", "0X800B2CF", 2, 0, "", "", "", "");
    }
}
