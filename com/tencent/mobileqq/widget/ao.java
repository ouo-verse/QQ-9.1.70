package com.tencent.mobileqq.widget;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.util.LoginUtil;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 82\u00020\u0001:\u00029:B5\u0012\u0006\u00103\u001a\u000202\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\u0006\u00104\u001a\u00020*\u0012\b\u00105\u001a\u0004\u0018\u00010*\u00a2\u0006\u0004\b6\u00107J.\u0010\t\u001a\u00020\u00072\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\b\u0010\u0010\u001a\u00020\fH\u0002J\u0012\u0010\u0013\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010!\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u001eR\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010'\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010\u001aR\u0018\u0010)\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010\u0016R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u0004\u0018\u00010*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0016\u00101\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010\u000e\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/widget/ao;", "Landroid/app/Dialog;", "", "", "", "params", "key", "", "default", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "floatingView", "", "Y", "Z", "W", BdhLogUtil.LogTag.Tag_Req, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/widget/LinearLayout;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/LinearLayout;", "mContainer", "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "mPhoneNumber", "Landroid/widget/Button;", "E", "Landroid/widget/Button;", "mSelfPhoneNumBtn", UserInfo.SEX_FEMALE, "mOtherPhoneNumBtn", "Landroid/widget/CheckBox;", "G", "Landroid/widget/CheckBox;", "mCheckBox", "H", "mAgreementText", "I", "mAgreementContainer", "Lcom/tencent/mobileqq/widget/ao$b;", "J", "Lcom/tencent/mobileqq/widget/ao$b;", "mSelfBtnClickCallBack", "K", "mOtherBtnClickCallBack", "L", "mOtherBtnClickIgnoreAgreement", "Landroid/content/Context;", "context", "selfBtnClickCallBack", "otherBtnClickCallBack", "<init>", "(Landroid/content/Context;Ljava/util/Map;Lcom/tencent/mobileqq/widget/ao$b;Lcom/tencent/mobileqq/widget/ao$b;)V", "M", "a", "b", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class ao extends ReportDialog {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private LinearLayout mContainer;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private TextView mPhoneNumber;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Button mSelfPhoneNumBtn;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private Button mOtherPhoneNumBtn;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private CheckBox mCheckBox;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private TextView mAgreementText;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private LinearLayout mAgreementContainer;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final b mSelfBtnClickCallBack;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private final b mOtherBtnClickCallBack;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean mOtherBtnClickIgnoreAgreement;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/widget/ao$b;", "", "", "isChecked", "", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public interface b {
        void a(boolean isChecked);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/widget/ao$c", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", NodeProps.MAX_HEIGHT, "showMode", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class c extends com.tencent.mobileqq.widget.qus.e {
        c() {
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        @Nullable
        /* renamed from: createContentView */
        public View getF52508d() {
            return ao.this.mContainer;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int maxHeight() {
            return BaseAIOUtils.f(321.0f, ao.this.getContext().getResources());
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ao(@NotNull Context context, @NotNull Map<String, ? extends Object> params, @NotNull b selfBtnClickCallBack, @Nullable b bVar) {
        super(context, R.style.MenuDialogStyle);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(selfBtnClickCallBack, "selfBtnClickCallBack");
        this.mSelfBtnClickCallBack = selfBtnClickCallBack;
        this.mOtherBtnClickCallBack = bVar;
        View inflate = View.inflate(context, R.layout.gzk, null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) inflate;
        this.mContainer = linearLayout;
        if (linearLayout != null) {
            TextView textView = (TextView) linearLayout.findViewById(R.id.f243608x);
            this.mPhoneNumber = textView;
            if (textView != null) {
                textView.setText((String) params.get("key_phone_num"));
            }
            Button button = (Button) linearLayout.findViewById(R.id.f82924i7);
            this.mSelfPhoneNumBtn = button;
            if (button != null) {
                button.setText((String) params.get("key_self_btn_text"));
            }
            Button button2 = (Button) linearLayout.findViewById(R.id.f217101r);
            this.mOtherPhoneNumBtn = button2;
            if (button2 != null) {
                button2.setText((String) params.get("key_other_btn_text"));
            }
            this.mCheckBox = (CheckBox) linearLayout.findViewById(R.id.yue);
            this.mAgreementText = (TextView) linearLayout.findViewById(R.id.yuh);
            LoginUtil.f306390a.m((String) params.get("key_user_agreement"), this.mAgreementText, this.mCheckBox);
            this.mAgreementContainer = (LinearLayout) linearLayout.findViewById(R.id.yug);
            this.mOtherBtnClickIgnoreAgreement = U(this, params, "key_other_click_ignore_agreement", false, 4, null);
        }
    }

    private final void R() {
        com.tencent.mobileqq.util.l.f(getContext(), this.mAgreementContainer);
    }

    private final boolean S(Map<String, ? extends Object> params, String key, boolean r36) {
        Object obj = params.get(key);
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return r36;
    }

    static /* synthetic */ boolean U(ao aoVar, Map map, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        return aoVar.S(map, str, z16);
    }

    private final boolean W() {
        CheckBox checkBox = this.mCheckBox;
        if (checkBox == null || !checkBox.isChecked()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(ao this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            this$0.dismiss();
        } catch (Exception e16) {
            QLog.e("QQOneClickFloatView", 1, "error:" + e16);
        }
    }

    private final void Y(QUSHalfScreenFloatingView floatingView) {
        if (com.tencent.mobileqq.loginregister.z.b(getContext())) {
            com.tencent.mobileqq.loginregister.z.w(floatingView);
        } else {
            com.tencent.mobileqq.loginregister.z.A(floatingView);
        }
    }

    private final void Z(final QUSHalfScreenFloatingView floatingView) {
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.tencent.mobileqq.widget.am
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ao.a0(ao.this, floatingView, view);
            }
        };
        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: com.tencent.mobileqq.widget.an
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ao.b0(ao.this, floatingView, view);
            }
        };
        Button button = this.mSelfPhoneNumBtn;
        if (button != null) {
            button.setOnClickListener(onClickListener);
        }
        Button button2 = this.mOtherPhoneNumBtn;
        if (button2 != null) {
            button2.setOnClickListener(onClickListener2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(ao this$0, QUSHalfScreenFloatingView floatingView, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(floatingView, "$floatingView");
        QLog.i("QQOneClickFloatView", 2, "selfBtn clicked");
        if (!this$0.W()) {
            this$0.R();
            this$0.mSelfBtnClickCallBack.a(false);
        } else {
            this$0.mSelfBtnClickCallBack.a(true);
            this$0.setOnDismissListener(null);
            floatingView.t();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(ao this$0, QUSHalfScreenFloatingView floatingView, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(floatingView, "$floatingView");
        QLog.i("QQOneClickFloatView", 2, "otherBtn clicked");
        if (!this$0.mOtherBtnClickIgnoreAgreement && !this$0.W()) {
            this$0.R();
            b bVar = this$0.mOtherBtnClickCallBack;
            if (bVar != null) {
                bVar.a(false);
            }
        } else {
            b bVar2 = this$0.mOtherBtnClickCallBack;
            if (bVar2 != null) {
                bVar2.a(true);
            }
            this$0.setOnDismissListener(null);
            floatingView.t();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.app.Dialog
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.e3i);
        View findViewById = findViewById(R.id.f66733bf);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(com.tencent\u2026qus_floating_half_screen)");
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = (QUSHalfScreenFloatingView) findViewById;
        qUSHalfScreenFloatingView.setContentDescription(getContext().getResources().getString(R.string.f200324rt));
        ImmersiveUtils.setStatusTextColor(false, getWindow());
        ImmersiveUtils.clearCoverForStatus(getWindow(), true);
        qUSHalfScreenFloatingView.setQUSDragFloatController(new c());
        qUSHalfScreenFloatingView.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.mobileqq.widget.al
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                ao.X(ao.this);
            }
        });
        Y(qUSHalfScreenFloatingView);
        Z(qUSHalfScreenFloatingView);
        Window window = getWindow();
        if (window != null) {
            window.setNavigationBarColor(getContext().getResources().getColor(R.color.qui_common_bg_top_light));
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setLayout(-1, -1);
        }
    }
}
