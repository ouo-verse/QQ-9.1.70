package com.tencent.mobileqq.qqexpand.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.j;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.ui.dialog.DialogFromBottom;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \r2\u00020\u0001:\u0002\u001c\u001dB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0016\u0010\u0014\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/widget/m;", "Lcom/tencent/mobileqq/mini/ui/dialog/DialogFromBottom;", "Landroid/content/Context;", "context", "", "initBirthday", "", "Y", "Lcom/tencent/mobileqq/activity/j;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/activity/j;", "birthdayPickHelper", "D", "I", "newBirthdayYear", "E", "newBirthdayMonth", UserInfo.SEX_FEMALE, "newBirthdayDay", "G", "newBirthdayUnion", "Lcom/tencent/mobileqq/qqexpand/widget/m$b;", "H", "Lcom/tencent/mobileqq/qqexpand/widget/m$b;", "confirmListener", "listener", "<init>", "(Landroid/content/Context;ILcom/tencent/mobileqq/qqexpand/widget/m$b;)V", "a", "b", "qqexpand_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class m extends DialogFromBottom {

    /* renamed from: C, reason: from kotlin metadata */
    private com.tencent.mobileqq.activity.j birthdayPickHelper;

    /* renamed from: D, reason: from kotlin metadata */
    private int newBirthdayYear;

    /* renamed from: E, reason: from kotlin metadata */
    private int newBirthdayMonth;

    /* renamed from: F, reason: from kotlin metadata */
    private int newBirthdayDay;

    /* renamed from: G, reason: from kotlin metadata */
    private int newBirthdayUnion;

    /* renamed from: H, reason: from kotlin metadata */
    private b confirmListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/widget/m$b;", "", "", "newBirthday", "", "onConfirm", "onCancel", "qqexpand_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public interface b {
        void onCancel();

        void onConfirm(int newBirthday);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(Context context, int i3, b bVar) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.confirmListener = bVar;
        this.newBirthdayUnion = i3;
        Y(context, i3);
    }

    private final void Y(Context context, int initBirthday) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.czr, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) inflate;
        com.tencent.mobileqq.activity.j jVar = new com.tencent.mobileqq.activity.j(context, initBirthday, true);
        this.birthdayPickHelper = jVar;
        Intrinsics.checkNotNull(jVar);
        jVar.r(new c());
        com.tencent.mobileqq.activity.j jVar2 = this.birthdayPickHelper;
        Intrinsics.checkNotNull(jVar2);
        View n3 = jVar2.n();
        n3.setBackgroundColor(context.getResources().getColor(R.color.f7584n));
        linearLayout.addView(n3, 2);
        ViewGroup.LayoutParams layoutParams = n3.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        layoutParams2.topMargin = ViewUtils.dpToPx(-2.0f);
        n3.setLayoutParams(layoutParams2);
        setContentView(linearLayout);
        ((ImageView) linearLayout.findViewById(R.id.oye)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqexpand.widget.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                m.Z(m.this, view);
            }
        });
        setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.mobileqq.qqexpand.widget.k
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                m.a0(m.this, dialogInterface);
            }
        });
        ((Button) linearLayout.findViewById(R.id.oys)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqexpand.widget.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                m.b0(m.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(m this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isShowing()) {
            this$0.dismiss();
            b bVar = this$0.confirmListener;
            if (bVar != null) {
                Intrinsics.checkNotNull(bVar);
                bVar.onCancel();
            }
            ReportController.o(null, "dc00898", "", "", "0X800B08B", "0X800B08B", 2, 0, "", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(m this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        b bVar = this$0.confirmListener;
        if (bVar != null) {
            Intrinsics.checkNotNull(bVar);
            bVar.onCancel();
        }
        ReportController.o(null, "dc00898", "", "", "0X800B08B", "0X800B08B", 2, 0, "", "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(m this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ReportController.o(null, "dc00898", "", "", "0X800B08B", "0X800B08B", 1, 0, "", "", "", "");
        this$0.dismiss();
        b bVar = this$0.confirmListener;
        if (bVar != null) {
            Intrinsics.checkNotNull(bVar);
            bVar.onConfirm(this$0.newBirthdayUnion);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qqexpand/widget/m$c", "Lcom/tencent/mobileqq/activity/j$a;", "", "newYear", "newMonth", "newDay", "", "a", "onConfirmBtClicked", "qqexpand_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements j.a {
        c() {
        }

        @Override // com.tencent.mobileqq.activity.j.a
        public void a(int newYear, int newMonth, int newDay) {
            m.this.newBirthdayYear = newYear;
            m.this.newBirthdayMonth = newMonth;
            m.this.newBirthdayDay = newDay;
            m.this.newBirthdayUnion = (newYear << 16) | (newMonth << 8) | newDay;
            if (QLog.isColorLevel()) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("onBirthdayChange newYear:%d,newMonth:%d,newDay:%d", Arrays.copyOf(new Object[]{Integer.valueOf(newYear), Integer.valueOf(newMonth), Integer.valueOf(newDay)}, 3));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                QLog.d("FillBirthdayDialog", 2, format);
            }
        }

        @Override // com.tencent.mobileqq.activity.j.a
        public void onConfirmBtClicked() {
        }
    }
}
