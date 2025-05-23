package com.tencent.mobileqq.activity.aio.intimate.reborn.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneRouteApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001+B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b)\u0010\u0006J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\u001c\u0010\u000f\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0006R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/intimate/reborn/part/e;", "Lcom/tencent/mobileqq/activity/aio/intimate/reborn/part/c;", "", "friendUin", "", "B9", "(Ljava/lang/Long;)V", "C9", "A9", "z9", "x9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onPartDestroy", "d", "Ljava/lang/Long;", "getFriendUin", "()Ljava/lang/Long;", "setFriendUin", "Landroidx/fragment/app/FragmentManager;", "e", "Landroidx/fragment/app/FragmentManager;", "mFragmentManager", "Landroid/view/ViewGroup;", "f", "Landroid/view/ViewGroup;", "mFragmentContainer", "Landroidx/fragment/app/Fragment;", h.F, "Landroidx/fragment/app/Fragment;", "mFragment", "", "i", "Z", "mIsQZoneFeedViewInit", "<init>", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class e extends c {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Long friendUin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FragmentManager mFragmentManager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup mFragmentContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Fragment mFragment;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mIsQZoneFeedViewInit;

    public e(@Nullable Long l3) {
        this.friendUin = l3;
    }

    private final void B9(Long friendUin) {
        FragmentTransaction beginTransaction;
        FragmentTransaction beginTransaction2;
        if (this.mIsQZoneFeedViewInit) {
            QLog.d("IntimateQZonePart", 1, "QZoneFeedView has init, return");
            Fragment fragment = this.mFragment;
            if (fragment != null) {
                Intrinsics.checkNotNull(fragment);
                if (fragment.isAdded()) {
                    try {
                        FragmentManager fragmentManager = this.mFragmentManager;
                        if (fragmentManager != null && (beginTransaction2 = fragmentManager.beginTransaction()) != null) {
                            Fragment fragment2 = this.mFragment;
                            Intrinsics.checkNotNull(fragment2);
                            FragmentTransaction maxLifecycle = beginTransaction2.setMaxLifecycle(fragment2, Lifecycle.State.RESUMED);
                            if (maxLifecycle != null) {
                                maxLifecycle.commitNowAllowingStateLoss();
                                return;
                            }
                            return;
                        }
                        return;
                    } catch (Exception e16) {
                        QLog.e("IntimateQZonePart", 1, e16, new Object[0]);
                        return;
                    }
                }
                return;
            }
            return;
        }
        if (friendUin != null) {
            this.mIsQZoneFeedViewInit = true;
            Fragment qZoneAIOUserHomeFragment = ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).getQZoneAIOUserHomeFragment(friendUin.longValue());
            this.mFragment = qZoneAIOUserHomeFragment;
            if (qZoneAIOUserHomeFragment != null) {
                FragmentManager fragmentManager2 = this.mFragmentManager;
                if (fragmentManager2 != null && (beginTransaction = fragmentManager2.beginTransaction()) != null) {
                    Fragment fragment3 = this.mFragment;
                    Intrinsics.checkNotNull(fragment3);
                    FragmentTransaction replace = beginTransaction.replace(R.id.xpu, fragment3);
                    if (replace != null) {
                        replace.commitAllowingStateLoss();
                    }
                }
                QLog.d("IntimateQZonePart", 1, "QZoneFeedView init success");
                return;
            }
            QLog.d("IntimateQZonePart", 1, "QZoneFeedView init error, fragment is null");
            return;
        }
        QLog.d("IntimateQZonePart", 1, "QZoneFeedView init error, mFragmentManager: " + this.mFragmentManager + ", friendUin: " + friendUin);
    }

    private final void C9() {
        FragmentTransaction beginTransaction;
        try {
            Fragment fragment = this.mFragment;
            if (fragment != null) {
                Intrinsics.checkNotNull(fragment);
                if (fragment.isAdded()) {
                    FragmentManager fragmentManager = this.mFragmentManager;
                    if (fragmentManager != null && (beginTransaction = fragmentManager.beginTransaction()) != null) {
                        Fragment fragment2 = this.mFragment;
                        Intrinsics.checkNotNull(fragment2);
                        FragmentTransaction remove = beginTransaction.remove(fragment2);
                        if (remove != null) {
                            remove.commitNowAllowingStateLoss();
                        }
                    }
                    this.mFragment = null;
                    this.mIsQZoneFeedViewInit = false;
                }
            }
        } catch (Exception e16) {
            QLog.e("IntimateQZonePart", 1, e16, new Object[0]);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        ViewGroup viewGroup;
        if (rootView != null) {
            viewGroup = (ViewGroup) rootView.findViewById(R.id.xpu);
        } else {
            viewGroup = null;
        }
        this.mFragmentContainer = viewGroup;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        if (activity instanceof QBaseActivity) {
            this.mFragmentManager = ((QBaseActivity) activity).getSupportFragmentManager();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        C9();
        ViewGroup viewGroup = this.mFragmentContainer;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.reborn.part.c
    public void x9() {
        FragmentManager fragmentManager;
        FragmentTransaction beginTransaction;
        try {
            Fragment fragment = this.mFragment;
            if (fragment != null) {
                Intrinsics.checkNotNull(fragment);
                if (fragment.isAdded() && (fragmentManager = this.mFragmentManager) != null && (beginTransaction = fragmentManager.beginTransaction()) != null) {
                    Fragment fragment2 = this.mFragment;
                    Intrinsics.checkNotNull(fragment2);
                    FragmentTransaction maxLifecycle = beginTransaction.setMaxLifecycle(fragment2, Lifecycle.State.STARTED);
                    if (maxLifecycle != null) {
                        maxLifecycle.commitNowAllowingStateLoss();
                    }
                }
            }
        } catch (Exception e16) {
            QLog.e("IntimateQZonePart", 1, e16, new Object[0]);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.reborn.part.c
    public void z9() {
        B9(this.friendUin);
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.reborn.part.c
    public void A9() {
    }
}
