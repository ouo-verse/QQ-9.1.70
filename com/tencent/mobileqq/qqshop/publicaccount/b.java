package com.tencent.mobileqq.qqshop.publicaccount;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.ecshop.api.QQShopModule;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyFactory;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyRouter;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.f;
import com.tencent.mobileqq.qqshop.page.QQShopEmptyPageFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypeParser;
import cooperation.qzone.QzoneIPCModule;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001'B3\u0012\u0006\u0010#\u001a\u00020\t\u0012\"\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u0017j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b`\u0018\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0006\u0010\f\u001a\u00020\u000bJ\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\"\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016R0\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u0017j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b`\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001f\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/qqshop/publicaccount/b;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "Lcom/tencent/mobileqq/ecshop/api/QQShopModule$a;", "Landroid/os/Bundle;", "i0", "j0", "", "getItemCount", "position", "Landroidx/fragment/app/Fragment;", "createFragment", "", "k0", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "onAttachedToRecyclerView", "onDetachedFromRecyclerView", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/HashMap;", "qqShopKuiklyParams", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/f;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/ref/WeakReference;", "kuiklyFragmentWeak", "D", "coinsFragmentWeak", "fragment", "<init>", "(Landroidx/fragment/app/Fragment;Ljava/util/HashMap;)V", "E", "a", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class b extends FragmentStateAdapter implements QQShopModule.a {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private WeakReference<f> kuiklyFragmentWeak;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private WeakReference<Fragment> coinsFragmentWeak;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, String> qqShopKuiklyParams;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0007\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\nR\u0014\u0010\u0010\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\n\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qqshop/publicaccount/b$a;", "", "", "a", "()I", "COINS_TAB_INDEX", "b", "PA_TAB_INDEX", "", "COINS_KUIKLY_BUNDLE_NAME", "Ljava/lang/String;", "COINS_KUIKLY_PAGE_NAME", "DAILY_TAB_INDEX", "I", "LAUNCH_KUIKLY_PARAMS", "SHOP_KUIKLY_BUNDLE_NAME", "SHOP_KUIKLY_PAGE_NAME", "<init>", "()V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqshop.publicaccount.b$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            if (d.f274576a.d()) {
                return 1;
            }
            return -1;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            if (d.f274576a.d()) {
                return 2;
            }
            return 1;
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30140);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull Fragment fragment, @NotNull HashMap<String, String> qqShopKuiklyParams) {
        super(fragment);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(qqShopKuiklyParams, "qqShopKuiklyParams");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) fragment, (Object) qqShopKuiklyParams);
        } else {
            this.qqShopKuiklyParams = qqShopKuiklyParams;
        }
    }

    private final Bundle i0() {
        Bundle bundle = new Bundle();
        bundle.putString("page_name", "qwallet_qqshop_home");
        bundle.putString("bundle_name", "qwallet_qqshop");
        bundle.putSerializable(MimeTypeParser.ATTR_EXTENSION, this.qqShopKuiklyParams);
        ((IQQKuiklyRouter) QRoute.api(IQQKuiklyRouter.class)).updateLaunchArgs(bundle);
        Bundle bundle2 = new Bundle();
        bundle2.putBundle("launchKuiklyParams", bundle);
        bundle2.putString("big_brother_source_key", ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getSourceId(IPublicAccountUtil.UIN_FOR_SHOP));
        return bundle2;
    }

    private final Bundle j0() {
        Bundle bundle = new Bundle();
        bundle.putString("page_name", "benefits_center");
        bundle.putString("bundle_name", "benefits_center");
        bundle.putString("from", "qqlife");
        bundle.putString("safe-area-inset-bottom", "60");
        ((IQQKuiklyRouter) QRoute.api(IQQKuiklyRouter.class)).updateLaunchArgs(bundle);
        Bundle bundle2 = new Bundle();
        bundle2.putBundle("launchKuiklyParams", bundle);
        bundle2.putString("big_brother_source_key", ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getSourceId(IPublicAccountUtil.UIN_FOR_SHOP));
        return bundle2;
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    @NotNull
    public Fragment createFragment(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Fragment) iPatchRedirector.redirect((short) 3, (Object) this, position);
        }
        if (position == 0) {
            QPublicBaseFragment createQQKuiklyFragment = ((IQQKuiklyFactory) QRoute.api(IQQKuiklyFactory.class)).createQQKuiklyFragment();
            createQQKuiklyFragment.setArguments(i0());
            if (createQQKuiklyFragment instanceof f) {
                this.kuiklyFragmentWeak = new WeakReference<>(createQQKuiklyFragment);
            }
            return createQQKuiklyFragment;
        }
        if (position == INSTANCE.a()) {
            QPublicBaseFragment createQQKuiklyFragment2 = ((IQQKuiklyFactory) QRoute.api(IQQKuiklyFactory.class)).createQQKuiklyFragment();
            createQQKuiklyFragment2.setArguments(j0());
            this.coinsFragmentWeak = new WeakReference<>(createQQKuiklyFragment2);
            if (createQQKuiklyFragment2 instanceof f) {
                this.kuiklyFragmentWeak = new WeakReference<>(createQQKuiklyFragment2);
            }
            return createQQKuiklyFragment2;
        }
        return new QQShopEmptyPageFragment();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        if (!d.f274576a.d()) {
            return 2;
        }
        return 3;
    }

    @NotNull
    public final String k0() {
        f fVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        WeakReference<f> weakReference = this.kuiklyFragmentWeak;
        if (weakReference != null) {
            fVar = weakReference.get();
        } else {
            fVar = null;
        }
        if (fVar != null) {
            return fVar.c2();
        }
        return "{}";
    }

    @Override // com.tencent.mobileqq.ecshop.api.QQShopModule.a
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Fragment fragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        WeakReference<Fragment> weakReference = this.coinsFragmentWeak;
        if (weakReference != null && (fragment = weakReference.get()) != null && fragment.isVisible()) {
            fragment.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) recyclerView);
            return;
        }
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        QQShopModule.f203940a.i(new WeakReference<>(this));
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NotNull RecyclerView recyclerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) recyclerView);
            return;
        }
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        QQShopModule.f203940a.i(null);
    }
}
