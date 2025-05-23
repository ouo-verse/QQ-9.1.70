package com.tencent.ecommerce.biz.register.refactoring.dialog;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ecommerce.base.ui.ECBaseDialogFragment;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002!\"B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0018\u00a8\u0006#"}, d2 = {"Lcom/tencent/ecommerce/biz/register/refactoring/dialog/ECPhoneNumInconsistentDialog;", "Lcom/tencent/ecommerce/base/ui/ECBaseDialogFragment;", "Lcom/tencent/ecommerce/biz/register/refactoring/dialog/ECPhoneNumInconsistentDialog$PhoneNumInconsistentDialogResult;", "Landroid/view/View;", "view", "", "initUI", "initListener", "", "getContentLayoutId", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "G", "Ljava/lang/String;", "originPhoneNumber", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", "errorDesTv", "Landroid/widget/Button;", "I", "Landroid/widget/Button;", "sendVerifyMsgBt", "J", "feedBackBt", "K", "cancelBt", "<init>", "()V", "L", "a", "PhoneNumInconsistentDialogResult", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECPhoneNumInconsistentDialog extends ECBaseDialogFragment<PhoneNumInconsistentDialogResult> {

    /* renamed from: G, reason: from kotlin metadata */
    private String originPhoneNumber = "";

    /* renamed from: H, reason: from kotlin metadata */
    private TextView errorDesTv;

    /* renamed from: I, reason: from kotlin metadata */
    private Button sendVerifyMsgBt;

    /* renamed from: J, reason: from kotlin metadata */
    private Button feedBackBt;

    /* renamed from: K, reason: from kotlin metadata */
    private Button cancelBt;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/ecommerce/biz/register/refactoring/dialog/ECPhoneNumInconsistentDialog$PhoneNumInconsistentDialogResult;", "Landroid/os/Parcelable;", "()V", "SendVerifyMsg", "Lcom/tencent/ecommerce/biz/register/refactoring/dialog/ECPhoneNumInconsistentDialog$PhoneNumInconsistentDialogResult$SendVerifyMsg;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static abstract class PhoneNumInconsistentDialogResult implements Parcelable {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u00d6\u0001\u00a8\u0006\n"}, d2 = {"Lcom/tencent/ecommerce/biz/register/refactoring/dialog/ECPhoneNumInconsistentDialog$PhoneNumInconsistentDialogResult$SendVerifyMsg;", "Lcom/tencent/ecommerce/biz/register/refactoring/dialog/ECPhoneNumInconsistentDialog$PhoneNumInconsistentDialogResult;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", WadlProxyConsts.FLAGS, "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class SendVerifyMsg extends PhoneNumInconsistentDialogResult {

            /* renamed from: d, reason: collision with root package name */
            public static final SendVerifyMsg f104001d = new SendVerifyMsg();
            public static final Parcelable.Creator<SendVerifyMsg> CREATOR = new a();

            @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
            /* loaded from: classes31.dex */
            public static class a implements Parcelable.Creator<SendVerifyMsg> {
                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final SendVerifyMsg createFromParcel(Parcel parcel) {
                    if (parcel.readInt() != 0) {
                        return SendVerifyMsg.f104001d;
                    }
                    return null;
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final SendVerifyMsg[] newArray(int i3) {
                    return new SendVerifyMsg[i3];
                }
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            SendVerifyMsg() {
                super(null);
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int flags) {
                parcel.writeInt(1);
            }
        }

        PhoneNumInconsistentDialogResult() {
        }

        public /* synthetic */ PhoneNumInconsistentDialogResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECBaseDialogFragment.th(ECPhoneNumInconsistentDialog.this, PhoneNumInconsistentDialogResult.SendVerifyMsg.f104001d, 0, 2, null);
            ECPhoneNumInconsistentDialog.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECScheme.g("https://support.qq.com/products/394271", null, 2, null);
            ECPhoneNumInconsistentDialog.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECPhoneNumInconsistentDialog.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private final void initListener() {
        Button button = this.sendVerifyMsgBt;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sendVerifyMsgBt");
        }
        button.setOnClickListener(new b());
        Button button2 = this.feedBackBt;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedBackBt");
        }
        button2.setOnClickListener(new c());
        Button button3 = this.cancelBt;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cancelBt");
        }
        button3.setOnClickListener(new d());
    }

    @Override // com.tencent.ecommerce.base.ui.ECBaseDialogFragment
    public int getContentLayoutId() {
        return R.layout.cqp;
    }

    @Override // com.tencent.ecommerce.base.ui.ECBaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        String str;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("origin_phone_number")) == null) {
            str = "";
        }
        this.originPhoneNumber = str;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
        initListener();
    }

    private final void initUI(View view) {
        this.errorDesTv = (TextView) view.findViewById(R.id.f163029nx4);
        this.sendVerifyMsgBt = (Button) view.findViewById(R.id.nvz);
        this.feedBackBt = (Button) view.findViewById(R.id.nvy);
        this.cancelBt = (Button) view.findViewById(R.id.nvx);
        TextView textView = this.errorDesTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorDesTv");
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(getResources().getString(R.string.weo), Arrays.copyOf(new Object[]{this.originPhoneNumber}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        textView.setText(format);
    }
}
