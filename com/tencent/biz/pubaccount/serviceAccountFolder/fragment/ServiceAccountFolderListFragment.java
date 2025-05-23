package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqcamerakit.common.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J&\u0010\f\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\u000e\u001a\u00020\rH\u0014J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/biz/pubaccount/serviceAccountFolder/fragment/ServiceAccountFolderListFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "", "useQUISecNavBar", "needImmersive", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "doOnCreateView", "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class ServiceAccountFolderListFragment extends QIphoneTitleBarFragment {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/biz/pubaccount/serviceAccountFolder/fragment/ServiceAccountFolderListFragment$a;", "", "Landroid/content/Context;", "context", "", "b", "", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.pubaccount.serviceAccountFolder.fragment.ServiceAccountFolderListFragment$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            boolean isHitPublicAccountFolderExp = ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).isHitPublicAccountFolderExp();
            e.a("ServiceAccountFolderListFragment", 1, "hit new publicFolderExp:" + isHitPublicAccountFolderExp);
            return isHitPublicAccountFolderExp;
        }

        public final void b(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra(QBaseActivity.KEY_SET_ACTIVITY_ANIMATION, true);
            intent.putExtra(QBaseActivity.KEY_ACTIVITY_OPEN_ENTER_ANIMATION, R.anim.f154445lb);
            intent.putExtra(QBaseActivity.KEY_ACTIVITY_OPEN_EXIT_ANIMATION, R.anim.f154449lf);
            intent.putExtra(QBaseActivity.KEY_ACTIVITY_CLOSE_ENTER_ANIMATION, R.anim.f154435l2);
            intent.putExtra(QBaseActivity.KEY_ACTIVITY_CLOSE_EXIT_ANIMATION, R.anim.f154436l4);
            QPublicFragmentActivity.start(context, intent, ServiceAccountFolderListFragment.class);
        }

        Companion() {
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new my.b());
        arrayList.add(new my.a());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setTitle("\u516c\u4f17\u53f7");
        super.doOnCreateView(inflater, container, savedInstanceState);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.e1e;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean useQUISecNavBar() {
        return true;
    }
}
