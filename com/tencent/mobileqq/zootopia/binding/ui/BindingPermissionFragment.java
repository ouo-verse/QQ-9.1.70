package com.tencent.mobileqq.zootopia.binding.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.mobileqq.zootopia.binding.ui.BindingPermissionFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.usercenter.friend.ui.ZPlanUserCenterEmptyView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import uu4.c;
import wb3.a;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0014J&\u0010\u000f\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u0010\u001a\u00020\u0002H\u0016R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/zootopia/binding/ui/BindingPermissionFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "", "initView", "initData", "th", "uh", "", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "onResume", "Landroid/view/View;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "bindingContainer", "Lcom/tencent/sqshow/zootopia/usercenter/friend/ui/ZPlanUserCenterEmptyView;", "D", "Lcom/tencent/sqshow/zootopia/usercenter/friend/ui/ZPlanUserCenterEmptyView;", "emptyView", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "iconView", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class BindingPermissionFragment extends QIphoneTitleBarFragment {

    /* renamed from: F, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private View bindingContainer;

    /* renamed from: D, reason: from kotlin metadata */
    private ZPlanUserCenterEmptyView emptyView;

    /* renamed from: E, reason: from kotlin metadata */
    private ImageView iconView;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/zootopia/binding/ui/BindingPermissionFragment$a;", "", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "bundle", "", "a", "", "CDN_URL", "Ljava/lang/String;", "TAG", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.binding.ui.BindingPermissionFragment$a, reason: from kotlin metadata */
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
            QPublicFragmentActivity.start(context, intent, BindingPermissionFragment.class);
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zootopia/binding/ui/BindingPermissionFragment$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luu4/c;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements e<c> {
        b() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(c result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("BindingPermissionFragment_", 1, "doQQMusicCheckLoginReq success :: result == " + result.f440060a);
            if (result.f440060a) {
                BindingPermissionFragment.this.th();
            } else {
                BindingPermissionFragment.this.uh();
            }
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.i("BindingPermissionFragment_", 1, "doQQMusicCheckLoginReq failed :: error == " + error + " , message ==" + message);
            BindingPermissionFragment.this.uh();
        }
    }

    private final void initData() {
        a.b(a.f445368a, new uu4.b(), new b(), 0, 4, null);
    }

    private final void initView() {
        View findViewById = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.pdr);
        this.bindingContainer = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: xb3.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BindingPermissionFragment.sh(BindingPermissionFragment.this, view);
                }
            });
        }
        ZPlanUserCenterEmptyView zPlanUserCenterEmptyView = (ZPlanUserCenterEmptyView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.pds);
        this.emptyView = zPlanUserCenterEmptyView;
        if (zPlanUserCenterEmptyView != null) {
            zPlanUserCenterEmptyView.setText(R.string.f169790xm2);
        }
        ZPlanUserCenterEmptyView zPlanUserCenterEmptyView2 = this.emptyView;
        if (zPlanUserCenterEmptyView2 != null) {
            ZPlanUserCenterEmptyView.setMode$default(zPlanUserCenterEmptyView2, ZPlanUserCenterEmptyView.MODE.MODE_EMPTY_CONTENT, false, null, 4, null);
        }
        this.iconView = (ImageView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.r3e);
        URLDrawable drawable = URLDrawable.getDrawable("https://image.superqqshow.qq.com/icon/qqmusic.png", URLDrawable.URLDrawableOptions.obtain());
        ImageView imageView = this.iconView;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sh(BindingPermissionFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        if (context != null) {
            BindingDetailFragment.INSTANCE.a(context, new Bundle());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void th() {
        View view = this.bindingContainer;
        if (view != null) {
            view.setVisibility(0);
        }
        ZPlanUserCenterEmptyView zPlanUserCenterEmptyView = this.emptyView;
        if (zPlanUserCenterEmptyView == null) {
            return;
        }
        zPlanUserCenterEmptyView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void uh() {
        View view = this.bindingContainer;
        if (view != null) {
            view.setVisibility(8);
        }
        ZPlanUserCenterEmptyView zPlanUserCenterEmptyView = this.emptyView;
        if (zPlanUserCenterEmptyView == null) {
            return;
        }
        zPlanUserCenterEmptyView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.doOnCreateView(inflater, container, savedInstanceState);
        setTitle(getString(R.string.xhx));
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.d75;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        initData();
    }
}
