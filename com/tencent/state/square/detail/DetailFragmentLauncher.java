package com.tencent.state.square.detail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.state.SimpleGroupFragment;
import com.tencent.state.SquarePublicActivity;
import com.tencent.state.SquareRuntime;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.service.VasStatusSquareService;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.api.p015const.LauncherConst;
import com.tencent.state.square.data.SquareAvatarItem;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0006\u0010\u000b\u001a\u00020\nJ\u0010\u0010\f\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004J+\u0010\u0011\u001a\u00020\u00122\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0002\u0010\u0017J,\u0010\u0011\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ8\u0010\u0011\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0010\u001a\u00020\u00042\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\"\u0010 \u001a\u00020\u00122\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010!\u001a\u00020\u0004J\"\u0010\"\u001a\u00020\u00122\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010!\u001a\u00020\u0004J\u001a\u0010#\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J\u0010\u0010$\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/tencent/state/square/detail/DetailFragmentLauncher;", "", "()V", "TAG", "", "getTopFragment", "Landroidx/fragment/app/Fragment;", "context", "Landroid/content/Context;", "isSquareActivity", "", "isSquareRuntimeReady", "isValidActivity", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroidx/fragment/app/FragmentActivity;", "isValidUserInfo", "uin", "launch", "", "bundle", "Landroid/os/Bundle;", "requestCode", "", "(Landroid/content/Context;Landroid/os/Bundle;Ljava/lang/Integer;)V", "fragment", "Lcom/tencent/state/VasBaseFragment;", "source", "Lcom/tencent/state/square/detail/EntranceSource;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/state/square/data/SquareAvatarItem;", DownloadInfo.spKey_Config, "Lcom/tencent/state/square/detail/BaseDetailFragmentConfig;", "showErrorTips", "from", "trySyncCloseActivityIfNeeded", "unExpectExit", "withoutOtherFragments", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class DetailFragmentLauncher {
    public static final DetailFragmentLauncher INSTANCE = new DetailFragmentLauncher();
    public static final String TAG = "DetailFragmentLauncher";

    DetailFragmentLauncher() {
    }

    private final Fragment getTopFragment(Context context) {
        FragmentManager supportFragmentManager;
        List<Fragment> fragments;
        Object lastOrNull;
        if (!(context instanceof FragmentActivity)) {
            context = null;
        }
        FragmentActivity fragmentActivity = (FragmentActivity) context;
        if (fragmentActivity == null || (supportFragmentManager = fragmentActivity.getSupportFragmentManager()) == null || (fragments = supportFragmentManager.getFragments()) == null) {
            return null;
        }
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) fragments);
        return (Fragment) lastOrNull;
    }

    public static /* synthetic */ void launch$default(DetailFragmentLauncher detailFragmentLauncher, Context context, Bundle bundle, Integer num, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            num = null;
        }
        detailFragmentLauncher.launch(context, bundle, num);
    }

    private final boolean unExpectExit(FragmentActivity r16, String uin) {
        return (isValidActivity(r16) && isSquareRuntimeReady() && isValidUserInfo(uin)) ? false : true;
    }

    public final boolean isSquareActivity(Context context) {
        if (!(context instanceof SquarePublicActivity)) {
            context = null;
        }
        return ((SquarePublicActivity) context) != null;
    }

    public final boolean isSquareRuntimeReady() {
        return SquareRuntime.INSTANCE.hasMark();
    }

    public final void launch(Context context, Bundle bundle, Integer requestCode) {
        String str;
        SquareBaseKt.getSquareLog().d(TAG, "launch from outer");
        if (!isValidUserInfo(bundle != null ? bundle.getString(LauncherConst.KEY_OPEN_DETAIL_UIN) : null)) {
            showErrorTips(context, null, "outer_valid_uin");
            return;
        }
        if (!isSquareRuntimeReady()) {
            SquareBaseKt.getSquareLog().d(TAG, "launch from outer, start runtime");
            SquarePublicActivity.Launcher.start$default(context, 0, bundle, requestCode, 2, (Object) null);
            return;
        }
        Fragment topFragment = getTopFragment(context);
        if (topFragment instanceof VasBaseFragment) {
            SquareBaseKt.getSquareLog().d(TAG, "launch from outer, direct attach");
            VasBaseFragment vasBaseFragment = (VasBaseFragment) topFragment;
            EntranceSource covertFromScheme = EntranceSource.INSTANCE.covertFromScheme(bundle);
            if (bundle == null || (str = bundle.getString(LauncherConst.KEY_OPEN_DETAIL_UIN)) == null) {
                str = "";
            }
            String str2 = str;
            Intrinsics.checkNotNullExpressionValue(str2, "bundle?.getString(KEY_OPEN_DETAIL_UIN) ?: \"\"");
            launch$default(this, vasBaseFragment, covertFromScheme, str2, null, bundle, 8, null);
            return;
        }
        SquareBaseKt.getSquareLog().d(TAG, "launch from outer, new activity");
        SquarePublicActivity.Launcher.start(context, DetailBaseSelectFragment.class, bundle, requestCode);
    }

    public final void showErrorTips(Context context, VasBaseFragment fragment, String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.state.square.detail.DetailFragmentLauncher$showErrorTips$1
            @Override // java.lang.Runnable
            public final void run() {
                ICommonUtils.DefaultImpls.showToastSafely$default(SquareBaseKt.getSquareCommon(), Square.INSTANCE.getApplication(), "\u6253\u5f00\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", 0, 4, null);
            }
        });
        trySyncCloseActivityIfNeeded(context, fragment, from);
    }

    public final void trySyncCloseActivityIfNeeded(Context context, VasBaseFragment fragment, String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        if (isSquareActivity(context) && ((fragment instanceof SimpleGroupFragment) || withoutOtherFragments(context))) {
            if (!(context instanceof Activity)) {
                context = null;
            }
            Activity activity = (Activity) context;
            if (activity != null) {
                activity.finish();
            }
        }
        SquareBaseKt.getSquareLog().d(TAG, "trySyncCloseActivityIfNeeded, from:" + from);
    }

    public static /* synthetic */ void launch$default(DetailFragmentLauncher detailFragmentLauncher, VasBaseFragment vasBaseFragment, EntranceSource entranceSource, SquareAvatarItem squareAvatarItem, BaseDetailFragmentConfig baseDetailFragmentConfig, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            baseDetailFragmentConfig = null;
        }
        detailFragmentLauncher.launch(vasBaseFragment, entranceSource, squareAvatarItem, baseDetailFragmentConfig);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002c A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean withoutOtherFragments(Context context) {
        int i3;
        FragmentActivity fragmentActivity;
        FragmentManager supportFragmentManager;
        List<Fragment> fragments;
        try {
            if (!(context instanceof FragmentActivity)) {
                context = null;
            }
            fragmentActivity = (FragmentActivity) context;
        } catch (Throwable th5) {
            SquareBaseKt.getSquareLog().e(TAG, "withoutOtherFragments err.", th5);
        }
        if (fragmentActivity != null && (supportFragmentManager = fragmentActivity.getSupportFragmentManager()) != null && (fragments = supportFragmentManager.getFragments()) != null) {
            i3 = fragments.size();
            return i3 > 0;
        }
        i3 = 0;
        if (i3 > 0) {
        }
    }

    public static /* synthetic */ void launch$default(DetailFragmentLauncher detailFragmentLauncher, VasBaseFragment vasBaseFragment, EntranceSource entranceSource, String str, BaseDetailFragmentConfig baseDetailFragmentConfig, Bundle bundle, int i3, Object obj) {
        detailFragmentLauncher.launch(vasBaseFragment, entranceSource, str, (i3 & 8) != 0 ? null : baseDetailFragmentConfig, (i3 & 16) != 0 ? null : bundle);
    }

    public final boolean isValidActivity(FragmentActivity r26) {
        return (r26 == null || r26.isFinishing() || r26.isDestroyed()) ? false : true;
    }

    public final boolean isValidUserInfo(String uin) {
        boolean z16;
        boolean isBlank;
        if (uin != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(uin);
            if (!isBlank) {
                z16 = false;
                return !z16;
            }
        }
        z16 = true;
        return !z16;
    }

    public final void launch(VasBaseFragment fragment, EntranceSource source, SquareAvatarItem r65, BaseDetailFragmentConfig r75) {
        Set<String> schemeOnceKey;
        FragmentActivity activity;
        Intent intent;
        FragmentActivity activity2;
        Intent intent2;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(r65, "item");
        SquareBaseKt.getSquareLog().d(TAG, "launch from item");
        FragmentActivity activity3 = fragment != null ? fragment.getActivity() : null;
        if (unExpectExit(activity3, r65.getUin())) {
            showErrorTips(activity3, fragment, "item_check");
            return;
        }
        Bundle extras = (fragment == null || (activity2 = fragment.getActivity()) == null || (intent2 = activity2.getIntent()) == null) ? null : intent2.getExtras();
        if (r65.isMe()) {
            if (fragment != null) {
                fragment.pushFragment(DetailSelectMeFragment.INSTANCE.newInstance(r65, source, r75 != null ? r75.convertFromScheme(extras) : null));
            }
        } else if (fragment != null) {
            fragment.pushFragment(DetailSelectGuestFragment.INSTANCE.newInstance(r65, source, r75 != null ? r75.convertFromScheme(extras) : null));
        }
        if (r75 == null || (schemeOnceKey = r75.schemeOnceKey()) == null) {
            return;
        }
        for (String str : schemeOnceKey) {
            if (fragment != null && (activity = fragment.getActivity()) != null && (intent = activity.getIntent()) != null) {
                intent.removeExtra(str);
            }
        }
    }

    public final void launch(final VasBaseFragment fragment, final EntranceSource source, String uin, final BaseDetailFragmentConfig r19, final Bundle bundle) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(uin, "uin");
        SquareBaseKt.getSquareLog().d(TAG, "launch from uin:" + uin);
        final FragmentActivity activity = fragment != null ? fragment.getActivity() : null;
        if (unExpectExit(activity, uin)) {
            showErrorTips(activity, fragment, "uin_check");
            return;
        }
        Intrinsics.checkNotNull(activity);
        final LoadingDialogTask loadingDialogTask = new LoadingDialogTask(activity, fragment);
        loadingDialogTask.start();
        VasStatusSquareService.getUserInfo$default(VasStatusSquareService.INSTANCE, uin, source.getMain(), null, null, new ResultCallback<SquareAvatarItem>() { // from class: com.tencent.state.square.detail.DetailFragmentLauncher$launch$2
            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int i3, String str, String str2) {
                ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int error, String message) {
                SquareBaseKt.getSquareLog().d(DetailFragmentLauncher.TAG, "server failed, " + error + ", " + message);
                if (LoadingDialogTask.this.resultInTime()) {
                    DetailFragmentLauncher.INSTANCE.showErrorTips(activity, fragment, "uin_result_fail");
                }
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultSuccess(SquareAvatarItem result) {
                SquareLogger squareLog = SquareBaseKt.getSquareLog();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("server success, ");
                sb5.append(result == null);
                squareLog.d(DetailFragmentLauncher.TAG, sb5.toString());
                if (LoadingDialogTask.this.resultInTime()) {
                    if (result == null) {
                        DetailFragmentLauncher.INSTANCE.showErrorTips(activity, fragment, "uin_result_null");
                        return;
                    }
                    if (result.isMe()) {
                        DetailFragmentLauncher detailFragmentLauncher = DetailFragmentLauncher.INSTANCE;
                        VasBaseFragment vasBaseFragment = fragment;
                        EntranceSource entranceSource = source;
                        BaseDetailFragmentConfig baseDetailFragmentConfig = r19;
                        if (baseDetailFragmentConfig == null) {
                            baseDetailFragmentConfig = new DetailMeFragmentConfig();
                        }
                        detailFragmentLauncher.launch(vasBaseFragment, entranceSource, result, baseDetailFragmentConfig.convertFromScheme(bundle));
                        return;
                    }
                    DetailFragmentLauncher detailFragmentLauncher2 = DetailFragmentLauncher.INSTANCE;
                    VasBaseFragment vasBaseFragment2 = fragment;
                    EntranceSource entranceSource2 = source;
                    BaseDetailFragmentConfig baseDetailFragmentConfig2 = r19;
                    if (baseDetailFragmentConfig2 == null) {
                        baseDetailFragmentConfig2 = new DetailGuestFragmentConfig();
                    }
                    detailFragmentLauncher2.launch(vasBaseFragment2, entranceSource2, result, baseDetailFragmentConfig2.convertFromScheme(bundle));
                }
            }
        }, 12, null);
    }
}
