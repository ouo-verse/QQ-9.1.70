package com.tencent.mobileqq.zootopia.binding.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.mobileqq.zootopia.binding.ui.BindingDetailFragment;
import com.tencent.mobileqq.zootopia.ipc.i;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import uu4.d;
import wb3.a;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0014J&\u0010\r\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/zootopia/binding/ui/BindingDetailFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "", "initView", "vh", "", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "clearAuthButton", "<init>", "()V", "D", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class BindingDetailFragment extends QIphoneTitleBarFragment {

    /* renamed from: D, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private TextView clearAuthButton;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zootopia/binding/ui/BindingDetailFragment$a;", "", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "bundle", "", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.binding.ui.BindingDetailFragment$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, Bundle bundle) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intent intent = new Intent();
            intent.putExtras(bundle);
            QPublicFragmentActivity.start(context, intent, BindingDetailFragment.class);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zootopia/binding/ui/BindingDetailFragment$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luu4/e;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements e<uu4.e> {
        b() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(uu4.e result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("BindingPermissionFragment_", 1, "doQQMusicLogoutReq success ");
            FragmentActivity activity = BindingDetailFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
            ((i) k74.i.INSTANCE.a(i.class)).clearCookie();
            QQToast.makeText(BindingDetailFragment.this.getContext(), 5, BindingDetailFragment.this.getString(R.string.xmg), 0).show();
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("BindingPermissionFragment_", 1, "doQQMusicLogoutReq onResultFailure :: error == " + error + " , message == " + message);
            QQToast.makeText(BindingDetailFragment.this.getContext(), 5, BindingDetailFragment.this.getString(R.string.xmf), 0).show();
        }
    }

    private final void initView() {
        TextView textView = (TextView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.r3d);
        this.clearAuthButton = textView;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: xb3.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BindingDetailFragment.sh(BindingDetailFragment.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sh(final BindingDetailFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogUtil.createCustomDialog(this$0.getContext(), 230, this$0.getString(R.string.xmd), this$0.getString(R.string.xme), this$0.getString(R.string.f169768xi0), this$0.getString(R.string.xkd), new DialogInterface.OnClickListener() { // from class: xb3.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                BindingDetailFragment.th(BindingDetailFragment.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: xb3.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                BindingDetailFragment.uh(dialogInterface, i3);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void th(BindingDetailFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.vh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uh(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    private final void vh() {
        a.d(a.f445368a, new d(), new b(), 0, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.doOnCreateView(inflater, container, savedInstanceState);
        setTitle(getString(R.string.xm5));
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f167420d74;
    }
}
