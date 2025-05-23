package com.tencent.mobileqq.zootopia.openid;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.z1.base.openId.ZootopiaOpenIdResult;
import com.tencent.mobileqq.zootopia.FragmentSource;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;
import com.tencent.mobileqq.zootopia.ipc.ab;
import com.tencent.mobileqq.zootopia.ipc.ac;
import com.tencent.open.inner.auth.QQAuth;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.fragment.ZootopiaBaseFragment;
import cooperation.qzone.QzoneIPCModule;
import k74.i;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000  2\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J&\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\"\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016R\u0016\u0010\u001a\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/zootopia/openid/ZootopiaOpenIdFragment;", "Lcom/tencent/sqshow/fragment/ZootopiaBaseFragment;", "", "Mh", "Lh", "", "getSubSource", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "", "onBackPressedEvent", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "N", "I", "requestFlag", "P", "Z", "justShowReAuthDialog", "<init>", "()V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaOpenIdFragment extends ZootopiaBaseFragment {

    /* renamed from: Q, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: N, reason: from kotlin metadata */
    private int requestFlag;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean justShowReAuthDialog;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007R\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zootopia/openid/ZootopiaOpenIdFragment$a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "from", "Landroid/os/Bundle;", "bundle", "", "a", "", "INTENT_KEY_REQUEST_FLAG", "Ljava/lang/String;", "INTENT_KEY_RE_AUTH_DIALOG_BOOLEAN", "TAG", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.openid.ZootopiaOpenIdFragment$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(Context context, ZootopiaSource from, Bundle bundle) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(from, "from");
            Intent intent = new Intent();
            intent.putExtra(ZootopiaSource.KEY_FRAGMENT_SOURCE, new FragmentSource(Source.ZootopiaActivity, from));
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            intent.addFlags(268435456);
            QPublicFragmentActivity.b.b(context, intent, QPublicTransFragmentActivity.class, ZootopiaOpenIdFragment.class);
            QLog.i("ZootopiaOpenIdFragment_", 1, "start");
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/zootopia/openid/ZootopiaOpenIdFragment$b", "Lwp3/b;", "", "response", "", "onComplete", "Lwp3/a;", "e", "onError", "onCancel", "", "code", "onWarning", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends wp3.b {
        b() {
        }

        @Override // wp3.b
        public void onError(wp3.a e16) {
            FragmentActivity activity = ZootopiaOpenIdFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
            f.f328608a.h(ZootopiaOpenIdFragment.this.getContext(), ZootopiaOpenIdFragment.this.requestFlag, -1, -1, null);
        }

        @Override // wp3.b
        public void onWarning(int code) {
            QLog.i("ZootopiaOpenIdFragment_", 1, "onWarning code:" + code);
        }

        @Override // wp3.b
        public void onCancel() {
            QLog.i("ZootopiaOpenIdFragment_", 1, "onCancel");
        }

        @Override // wp3.b
        public void onComplete(Object response) {
            QLog.i("ZootopiaOpenIdFragment_", 1, "onComplete");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/openid/ZootopiaOpenIdFragment$c", "Lcom/tencent/mobileqq/zootopia/ipc/ab;", "Lcom/tencent/mobileqq/z1/base/openId/ZootopiaOpenIdResult;", "result", "", "a", "", "errCode", "", "errMsg", "b", "c", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements ab {
        c() {
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.ab
        public void a(ZootopiaOpenIdResult result) {
            QLog.i("ZootopiaOpenIdFragment_", 1, "showReAuthDialog, onResult");
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.ab
        public void b(int errCode, String errMsg) {
            QLog.i("ZootopiaOpenIdFragment_", 1, "showReAuthDialog, onError");
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.ab
        public void c() {
        }
    }

    private final void Lh() {
        Bundle arguments = getArguments();
        int i3 = arguments != null ? arguments.getInt("intent_request_flag", -1) : -1;
        this.requestFlag = i3;
        QLog.i("ZootopiaOpenIdFragment_", 1, "onCreate:" + i3);
        QQAuth qQAuth = QQAuth.getInstance();
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putBoolean("forbid_change_account", true);
        Unit unit = Unit.INSTANCE;
        qQAuth.proxyAuth(this, bVar, new QQAuth.AuthParams(null, ZootopiaEnterParams.ZPLAN_APP_ID, null, "all", bundle));
    }

    private final void Mh() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        QQCustomDialog createNoTitleDialog = DialogUtil.createNoTitleDialog(activity, "\u6388\u6743\u4fe1\u606f\u5df2\u8fc7\u671f\uff0c\u65e0\u6cd5\u8fdb\u5165\u4e50\u56ed\uff0c\u8bf7\u91cd\u65b0\u6388\u6743\u540e\u518d\u8bd5", R.string.f169781xk3, R.string.f169782xk4, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.openid.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ZootopiaOpenIdFragment.Nh(dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.openid.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ZootopiaOpenIdFragment.Oh(dialogInterface, i3);
            }
        });
        createNoTitleDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.zootopia.openid.d
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                ZootopiaOpenIdFragment.Ph(ZootopiaOpenIdFragment.this, dialogInterface);
            }
        });
        createNoTitleDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nh(DialogInterface dialogInterface, int i3) {
        ((ac) i.INSTANCE.a(ac.class)).getOpenIdInfo(ZootopiaSource.INSTANCE.g(), "map_id_default", new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ph(ZootopiaOpenIdFragment this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment
    public String getSubSource() {
        return "OPENID:" + this.justShowReAuthDialog;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        QLog.i("ZootopiaOpenIdFragment_", 1, "onActivityResult:" + this.requestFlag);
        super.onActivityResult(requestCode, resultCode, data);
        if (this.justShowReAuthDialog) {
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
        f.f328608a.h(getContext(), this.requestFlag, requestCode, resultCode, data);
    }

    @Override // com.tencent.mobileqq.zootopia.api.b
    public boolean onBackPressedEvent() {
        return false;
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        boolean z16 = arguments != null ? arguments.getBoolean("intent_re_auth_dialog", false) : false;
        this.justShowReAuthDialog = z16;
        QLog.i("ZootopiaOpenIdFragment_", 1, "onCreate justShowReAuthDialog:" + z16);
        super.onCreate(savedInstanceState);
        if (this.justShowReAuthDialog) {
            Mh();
        } else {
            Lh();
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        QLog.i("ZootopiaOpenIdFragment_", 1, "onCreateView:" + this.requestFlag);
        FrameLayout frameLayout = new FrameLayout(inflater.getContext());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setBackgroundColor(0);
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(DialogInterface dialogInterface, int i3) {
        QLog.i("ZootopiaOpenIdFragment_", 1, "reAuthDialog, cancel");
    }
}
