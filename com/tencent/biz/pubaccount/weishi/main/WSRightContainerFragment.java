package com.tencent.biz.pubaccount.weishi.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.weishi.profile.WSProfileFragment;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.j;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 #2\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0016J&\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0016\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0010J\u0006\u0010\u0019\u001a\u00020\u0003R\u0016\u0010\u001c\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/main/WSRightContainerFragment;", "Lcom/tencent/mobileqq/app/QBaseFragment;", "fragment", "", "uh", "Landroid/os/Bundle;", "ph", "Landroid/view/View;", "view", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "onCreateView", "", "isVisibleToUser", "setUserVisibleHint", "isNotAdType", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/data/j;", "data", "th", "isSelectedByClickAvatar", "rh", "sh", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "mRootView", "Lcom/tencent/biz/pubaccount/weishi/profile/WSProfileFragment;", "D", "Lcom/tencent/biz/pubaccount/weishi/profile/WSProfileFragment;", "mProfileFragment", "<init>", "()V", "E", "a", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class WSRightContainerFragment extends QBaseFragment {

    /* renamed from: E, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private View mRootView;

    /* renamed from: D, reason: from kotlin metadata */
    private WSProfileFragment mProfileFragment;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/main/WSRightContainerFragment$a;", "", "Lcom/tencent/biz/pubaccount/weishi/main/WSRightContainerFragment;", "a", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.pubaccount.weishi.main.WSRightContainerFragment$a, reason: from kotlin metadata */
    /* loaded from: classes32.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final WSRightContainerFragment a() {
            return new WSRightContainerFragment();
        }

        Companion() {
        }
    }

    private final Bundle ph() {
        Bundle bundle = new Bundle();
        bundle.putInt(MiniAppPlugin.ATTR_PAGE_TYPE, 3);
        bundle.putString("from", "main");
        return bundle;
    }

    @JvmStatic
    public static final WSRightContainerFragment qh() {
        return INSTANCE.a();
    }

    private final void uh(QBaseFragment fragment) {
        getChildFragmentManager().beginTransaction().replace(R.id.f163252p42, fragment).commitNowAllowingStateLoss();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.f167381d10, container, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026agment, container, false)");
        this.mRootView = inflate;
        if (inflate != null) {
            return inflate;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        WSProfileFragment Th = WSProfileFragment.Th(ph());
        Intrinsics.checkNotNullExpressionValue(Th, "create(getProfileBundle())");
        this.mProfileFragment = Th;
        uh(Th);
    }

    public final void rh(boolean isSelectedByClickAvatar) {
        WSProfileFragment wSProfileFragment = this.mProfileFragment;
        if (wSProfileFragment != null) {
            wSProfileFragment.ki(isSelectedByClickAvatar);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        WSProfileFragment wSProfileFragment = this.mProfileFragment;
        if (wSProfileFragment == null) {
            return;
        }
        wSProfileFragment.setUserVisibleHint(isVisibleToUser);
    }

    public final void sh() {
        WSProfileFragment wSProfileFragment = this.mProfileFragment;
        if (wSProfileFragment != null) {
            wSProfileFragment.li();
        }
    }

    public final void th(boolean isNotAdType, j data) {
        Intrinsics.checkNotNullParameter(data, "data");
        WSProfileFragment wSProfileFragment = this.mProfileFragment;
        if (wSProfileFragment == null) {
            return;
        }
        uh(wSProfileFragment);
        wSProfileFragment.ti(data.e().poster, data.e().f25129id);
    }
}
