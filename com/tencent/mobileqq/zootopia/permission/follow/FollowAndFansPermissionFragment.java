package com.tencent.mobileqq.zootopia.permission.follow;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zootopia.permission.follow.data.RequestState;
import com.tencent.mobileqq.zootopia.view.ZootopiaFormMutilItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import hu4.g;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 <2\u00020\u0001:\u0001=B\u0007\u00a2\u0006\u0004\b:\u0010;J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\fH\u0014J&\u0010\u0014\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0014R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001e\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010#\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\"R\u001b\u0010&\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010\u001b\u001a\u0004\b%\u0010\"R\u001b\u0010+\u001a\u00020'8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b(\u0010\u001b\u001a\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u001b\u00104\u001a\u0002008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u0010\u001b\u001a\u0004\b2\u00103R\u001b\u00109\u001a\u0002058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b6\u0010\u001b\u001a\u0004\b7\u00108\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/zootopia/permission/follow/FollowAndFansPermissionFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "", "Dh", "Bh", "Gh", "Ih", "Kh", "Jh", "Mh", "Lh", "Ah", "", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "Lcom/tencent/mobileqq/zootopia/permission/follow/data/c;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/zootopia/permission/follow/data/c;", "permissionViewModel", "Landroid/widget/LinearLayout;", "D", "Lkotlin/Lazy;", "xh", "()Landroid/widget/LinearLayout;", "itemContainer", "Lcom/tencent/mobileqq/zootopia/view/ZootopiaFormMutilItem;", "E", "vh", "()Lcom/tencent/mobileqq/zootopia/view/ZootopiaFormMutilItem;", "formAllItem", UserInfo.SEX_FEMALE, "wh", "formSelfItem", "Landroid/widget/FrameLayout;", "G", "uh", "()Landroid/widget/FrameLayout;", "errorView", "Lhu4/g;", "H", "Lhu4/g;", "currentPrivacyInfo", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "I", OcrConfig.CHINESE, "()Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "viewReportHelper", "Lid3/d;", "J", "yh", "()Lid3/d;", "pageReportHelper", "<init>", "()V", "K", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class FollowAndFansPermissionFragment extends QIphoneTitleBarFragment {

    /* renamed from: K, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private final com.tencent.mobileqq.zootopia.permission.follow.data.c permissionViewModel = new com.tencent.mobileqq.zootopia.permission.follow.data.c(new com.tencent.mobileqq.zootopia.permission.follow.data.b());

    /* renamed from: D, reason: from kotlin metadata */
    private final Lazy itemContainer;

    /* renamed from: E, reason: from kotlin metadata */
    private final Lazy formAllItem;

    /* renamed from: F, reason: from kotlin metadata */
    private final Lazy formSelfItem;

    /* renamed from: G, reason: from kotlin metadata */
    private final Lazy errorView;

    /* renamed from: H, reason: from kotlin metadata */
    private g currentPrivacyInfo;

    /* renamed from: I, reason: from kotlin metadata */
    private final Lazy viewReportHelper;

    /* renamed from: J, reason: from kotlin metadata */
    private final Lazy pageReportHelper;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zootopia/permission/follow/FollowAndFansPermissionFragment$a;", "", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "bundle", "", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.permission.follow.FollowAndFansPermissionFragment$a, reason: from kotlin metadata */
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
            QPublicFragmentActivity.start(context, intent, FollowAndFansPermissionFragment.class);
        }

        Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f328650a;

        static {
            int[] iArr = new int[RequestState.values().length];
            try {
                iArr[RequestState.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RequestState.LOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RequestState.GET_FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[RequestState.SET_FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f328650a = iArr;
        }
    }

    public FollowAndFansPermissionFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.mobileqq.zootopia.permission.follow.FollowAndFansPermissionFragment$itemContainer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                View view;
                view = ((QIphoneTitleBarFragment) ((QIphoneTitleBarFragment) FollowAndFansPermissionFragment.this)).mContentView;
                return (LinearLayout) view.findViewById(R.id.r0s);
            }
        });
        this.itemContainer = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ZootopiaFormMutilItem>() { // from class: com.tencent.mobileqq.zootopia.permission.follow.FollowAndFansPermissionFragment$formAllItem$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZootopiaFormMutilItem invoke() {
                View view;
                view = ((QIphoneTitleBarFragment) ((QIphoneTitleBarFragment) FollowAndFansPermissionFragment.this)).mContentView;
                return (ZootopiaFormMutilItem) view.findViewById(R.id.pvq);
            }
        });
        this.formAllItem = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<ZootopiaFormMutilItem>() { // from class: com.tencent.mobileqq.zootopia.permission.follow.FollowAndFansPermissionFragment$formSelfItem$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZootopiaFormMutilItem invoke() {
                View view;
                view = ((QIphoneTitleBarFragment) ((QIphoneTitleBarFragment) FollowAndFansPermissionFragment.this)).mContentView;
                return (ZootopiaFormMutilItem) view.findViewById(R.id.pvu);
            }
        });
        this.formSelfItem = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.mobileqq.zootopia.permission.follow.FollowAndFansPermissionFragment$errorView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FrameLayout invoke() {
                View view;
                view = ((QIphoneTitleBarFragment) ((QIphoneTitleBarFragment) FollowAndFansPermissionFragment.this)).mContentView;
                return (FrameLayout) view.findViewById(R.id.r0r);
            }
        });
        this.errorView = lazy4;
        this.currentPrivacyInfo = new g();
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<ZplanViewReportHelper>() { // from class: com.tencent.mobileqq.zootopia.permission.follow.FollowAndFansPermissionFragment$viewReportHelper$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZplanViewReportHelper invoke() {
                return new ZplanViewReportHelper();
            }
        });
        this.viewReportHelper = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<id3.d>() { // from class: com.tencent.mobileqq.zootopia.permission.follow.FollowAndFansPermissionFragment$pageReportHelper$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final id3.d invoke() {
                return new id3.d(null, 1, null);
            }
        });
        this.pageReportHelper = lazy6;
    }

    private final void Ah() {
        uh().setVisibility(8);
        xh().setVisibility(8);
    }

    private final void Bh() {
        ImageView imageView = (ImageView) uh().findViewById(R.id.r0p);
        if (imageView != null) {
            imageView.setImageResource(R.drawable.dqb);
        }
        TextView textView = (TextView) uh().findViewById(R.id.r0q);
        if (textView != null) {
            textView.setText(R.string.pyp);
        }
        uh().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.permission.follow.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FollowAndFansPermissionFragment.Ch(FollowAndFansPermissionFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ch(FollowAndFansPermissionFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.permissionViewModel.M1();
    }

    private final void Dh() {
        vh().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.permission.follow.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FollowAndFansPermissionFragment.Eh(FollowAndFansPermissionFragment.this, view);
            }
        });
        zh().g(vh(), "em_zplan_everyone_btn", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        wh().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.permission.follow.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FollowAndFansPermissionFragment.Fh(FollowAndFansPermissionFragment.this, view);
            }
        });
        zh().g(wh(), "em_zplan_private_btn", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        Ih();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eh(FollowAndFansPermissionFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("Privacy_FollowAndFansPermissionFragment", 4, "on all click");
        if (this$0.currentPrivacyInfo.f406376b != 0) {
            this$0.Jh();
            g gVar = new g();
            gVar.f406375a = 0;
            gVar.f406376b = 0;
            this$0.permissionViewModel.N1(gVar, this$0.currentPrivacyInfo);
            QLog.d("Privacy_FollowAndFansPermissionFragment", 4, "on all click set all");
        }
        ZplanViewReportHelper.f(this$0.zh(), this$0.vh(), "em_zplan_everyone_btn", null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fh(FollowAndFansPermissionFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("Privacy_FollowAndFansPermissionFragment", 4, "on all click");
        if (this$0.currentPrivacyInfo.f406376b != 1) {
            this$0.Kh();
            g gVar = new g();
            gVar.f406375a = 0;
            gVar.f406376b = 1;
            this$0.permissionViewModel.N1(gVar, this$0.currentPrivacyInfo);
            QLog.d("Privacy_FollowAndFansPermissionFragment", 4, "on all click set self");
        }
        ZplanViewReportHelper.f(this$0.zh(), this$0.vh(), "em_zplan_private_btn", null, 4, null);
    }

    private final void Gh() {
        this.permissionViewModel.L1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.zootopia.permission.follow.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FollowAndFansPermissionFragment.Hh(FollowAndFansPermissionFragment.this, (com.tencent.mobileqq.zootopia.permission.follow.data.a) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hh(FollowAndFansPermissionFragment this$0, com.tencent.mobileqq.zootopia.permission.follow.data.a aVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.currentPrivacyInfo = aVar.getPrivacyInfo();
        int i3 = b.f328650a[aVar.getRequestState().ordinal()];
        if (i3 == 1) {
            this$0.Ah();
            return;
        }
        if (i3 != 2) {
            if (i3 == 3) {
                this$0.Lh();
            } else if (i3 != 4) {
                this$0.Ih();
            } else {
                QQToast.makeText(this$0.getContext(), 1, "\u8bbe\u7f6e\u5931\u8d25", 0).show();
                this$0.Ih();
            }
        }
    }

    private final ZootopiaFormMutilItem vh() {
        Object value = this.formAllItem.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-formAllItem>(...)");
        return (ZootopiaFormMutilItem) value;
    }

    private final ZootopiaFormMutilItem wh() {
        Object value = this.formSelfItem.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-formSelfItem>(...)");
        return (ZootopiaFormMutilItem) value;
    }

    private final LinearLayout xh() {
        Object value = this.itemContainer.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-itemContainer>(...)");
        return (LinearLayout) value;
    }

    private final id3.d yh() {
        return (id3.d) this.pageReportHelper.getValue();
    }

    private final ZplanViewReportHelper zh() {
        return (ZplanViewReportHelper) this.viewReportHelper.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.doOnCreateView(inflater, container, savedInstanceState);
        Dh();
        Bh();
        Gh();
        this.permissionViewModel.M1();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            HashMap hashMap = new HashMap();
            id3.d yh5 = yh();
            View mContentView = ((QIphoneTitleBarFragment) this).mContentView;
            Intrinsics.checkNotNullExpressionValue(mContentView, "mContentView");
            yh5.j(activity, mContentView, "pg_zplan_fans_setting", hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.d7y;
    }

    public final FrameLayout uh() {
        Object value = this.errorView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-errorView>(...)");
        return (FrameLayout) value;
    }

    private final void Ih() {
        QLog.d("Privacy_FollowAndFansPermissionFragment", 4, "refreshItems");
        Mh();
        if (this.currentPrivacyInfo.f406376b == 0) {
            Jh();
        } else {
            Kh();
        }
    }

    private final void Jh() {
        QLog.d("Privacy_FollowAndFansPermissionFragment", 4, "selectAll");
        vh().setIsSelected(true);
        wh().setIsSelected(false);
    }

    private final void Kh() {
        QLog.d("Privacy_FollowAndFansPermissionFragment", 4, "selectSelf");
        vh().setIsSelected(false);
        wh().setIsSelected(true);
    }

    private final void Lh() {
        QLog.d("Privacy_FollowAndFansPermissionFragment", 4, "showError");
        setTitle(getString(R.string.xtq));
        uh().setVisibility(0);
        xh().setVisibility(8);
    }

    private final void Mh() {
        QLog.d("Privacy_FollowAndFansPermissionFragment", 4, "showItems");
        setTitle(getString(R.string.xtp));
        uh().setVisibility(8);
        xh().setVisibility(0);
    }
}
