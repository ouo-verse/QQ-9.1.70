package com.tencent.mobileqq.guild.media.widget;

import android.content.DialogInterface;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/MediaChannelDialogFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", RemoteMessageConst.MessageBody.MSG_CONTENT, "btnContent", "", "sh", "onResume", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MediaChannelDialogFragment extends QPublicBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/MediaChannelDialogFragment$a;", "", "", RemoteMessageConst.MessageBody.MSG_CONTENT, "btnContent", "", "a", "CONFIRM_BTN_CONTENT", "Ljava/lang/String;", "MSG_CONTENT", "SECURITY_PARAMS", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.media.widget.MediaChannelDialogFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull String msgContent, @NotNull String btnContent) {
            Intrinsics.checkNotNullParameter(msgContent, "msgContent");
            Intrinsics.checkNotNullParameter(btnContent, "btnContent");
            Intent intent = new Intent();
            intent.putExtra("MSG_CONTENT", msgContent);
            intent.putExtra("CONFIRM_BTN_CONTENT", btnContent);
            intent.addFlags(268435456);
            QPublicTransFragmentActivity.start(BaseApplication.getContext(), intent, MediaChannelDialogFragment.class);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/guild/media/widget/MediaChannelDialogFragment$b", "Lcom/tencent/mobileqq/guild/util/security/i;", "", NodeProps.ON_CLICK, "onDismiss", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements com.tencent.mobileqq.guild.util.security.i {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.util.security.i
        public void onClick() {
            FragmentActivity activity = MediaChannelDialogFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }

        @Override // com.tencent.mobileqq.guild.util.security.i
        public void onDismiss() {
            FragmentActivity activity = MediaChannelDialogFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0016, code lost:
    
        if (r2 != false) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void sh(String msgContent, String btnContent) {
        boolean z16;
        FragmentActivity activity;
        boolean isBlank;
        boolean isBlank2;
        boolean z17 = false;
        if (msgContent != null) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(msgContent);
            if (!isBlank2) {
                z16 = false;
                if (!z16) {
                    if (btnContent != null) {
                        isBlank = StringsKt__StringsJVMKt.isBlank(btnContent);
                    }
                    z17 = true;
                    if (!z17) {
                        QQCustomDialog positiveButton = DialogUtil.createCustomDialog(getContext(), 230).setMessage(msgContent).setPositiveButton(btnContent, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.widget.ax
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i3) {
                                MediaChannelDialogFragment.th(dialogInterface, i3);
                            }
                        });
                        positiveButton.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.mobileqq.guild.media.widget.ay
                            @Override // android.content.DialogInterface.OnCancelListener
                            public final void onCancel(DialogInterface dialogInterface) {
                                MediaChannelDialogFragment.uh(MediaChannelDialogFragment.this, dialogInterface);
                            }
                        });
                        positiveButton.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.guild.media.widget.az
                            @Override // android.content.DialogInterface.OnDismissListener
                            public final void onDismiss(DialogInterface dialogInterface) {
                                MediaChannelDialogFragment.vh(MediaChannelDialogFragment.this, dialogInterface);
                            }
                        });
                        positiveButton.show();
                        return;
                    }
                }
                activity = getActivity();
                if (activity == null) {
                    activity.finish();
                    return;
                }
                return;
            }
        }
        z16 = true;
        if (!z16) {
        }
        activity = getActivity();
        if (activity == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void th(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uh(MediaChannelDialogFragment this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vh(MediaChannelDialogFragment this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @JvmStatic
    public static final void wh(@NotNull String str, @NotNull String str2) {
        INSTANCE.a(str, str2);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        String str;
        super.onResume();
        IGProSecurityResult iGProSecurityResult = (IGProSecurityResult) requireArguments().get("SECURITY");
        if (iGProSecurityResult != null) {
            SecurityTipHelperKt.F(getContext(), 0, iGProSecurityResult.getStrPrompt(), iGProSecurityResult, null, new b(), 16, null);
            return;
        }
        Object obj = requireArguments().get("MSG_CONTENT");
        String str2 = null;
        if (obj instanceof String) {
            str = (String) obj;
        } else {
            str = null;
        }
        Object obj2 = requireArguments().get("CONFIRM_BTN_CONTENT");
        if (obj2 instanceof String) {
            str2 = (String) obj2;
        }
        sh(str, str2);
    }
}
