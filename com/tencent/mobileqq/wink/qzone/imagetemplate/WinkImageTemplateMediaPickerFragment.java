package com.tencent.mobileqq.wink.qzone.imagetemplate;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.activity.CompatPublicActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.QQWinkActivity;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.f;
import com.tencent.mobileqq.wink.picker.Config;
import com.tencent.mobileqq.wink.picker.TabType;
import com.tencent.mobileqq.wink.picker.core.SingleMediaPickerFragment;
import com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment;
import com.tencent.mobileqq.wink.picker.qcircle.c;
import com.tencent.mobileqq.wink.picker.report.AlbumSelectionData;
import cooperation.peak.PeakConstants;
import e93.i;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w53.b;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/wink/qzone/imagetemplate/WinkImageTemplateMediaPickerFragment;", "Lcom/tencent/mobileqq/wink/picker/core/SingleMediaPickerFragment;", "", "Di", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "localMediaInfo", "", "Ei", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "mediaInfo", "Ze", "", "requestCode", "P5", "onBackEvent", "gi", "<init>", "()V", "b0", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkImageTemplateMediaPickerFragment extends SingleMediaPickerFragment {

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a0, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f326140a0 = new LinkedHashMap();

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/wink/qzone/imagetemplate/WinkImageTemplateMediaPickerFragment$a;", "", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "bundle", "Landroid/content/Intent;", "a", "", "CAMERA_FRAGMENT_REQUEST_CODE", "I", "", "CAMERA_FRAGMENT_TAG", "Ljava/lang/String;", "TAG", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.qzone.imagetemplate.WinkImageTemplateMediaPickerFragment$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Intent a(@NotNull Context context, @NotNull Bundle bundle) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intent intent = new Intent();
            if (context instanceof Activity) {
                Bundle extras = ((Activity) context).getIntent().getExtras();
                if (extras != null) {
                    intent.putExtras(extras);
                }
            } else {
                intent.addFlags(268435456);
            }
            intent.putExtras(bundle);
            intent.setClass(context, QQWinkActivity.class);
            intent.putExtra("public_fragment_class", WinkImageTemplateMediaPickerFragment.class.getName());
            intent.putExtra(CompatPublicActivity.KEY_THEME_ID, R.style.atm);
            intent.putExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID, WinkContext.INSTANCE.d().getTraceId());
            UniversalMediaPickerFragment.Companion companion = UniversalMediaPickerFragment.INSTANCE;
            Config.Companion companion2 = Config.INSTANCE;
            Config.a aVar = new Config.a();
            aVar.i(TabType.ONLY_IMAGE);
            aVar.o(c.f324971a.c());
            Unit unit = Unit.INSTANCE;
            intent.putExtras(UniversalMediaPickerFragment.Companion.b(companion, aVar.a(), null, 2, null));
            return intent;
        }

        Companion() {
        }
    }

    private final boolean Di() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            int backStackEntryCount = activity.getSupportFragmentManager().getBackStackEntryCount();
            if (activity.getSupportFragmentManager().getBackStackEntryCount() > 0 && Intrinsics.areEqual(activity.getSupportFragmentManager().getBackStackEntryAt(backStackEntryCount - 1).getName(), "CAMERA_FRAGMENT_TAG")) {
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ei(LocalMediaInfo localMediaInfo) {
        List listOf;
        Bundle bundle = new Bundle();
        Intent intent = getHostActivity().getIntent();
        if (intent != null) {
            Intrinsics.checkNotNullExpressionValue(intent, "intent");
            bundle.putAll(intent.getExtras());
        }
        listOf = CollectionsKt__CollectionsJVMKt.listOf(localMediaInfo);
        bundle.putSerializable(QQWinkConstants.INPUT_MEDIA, new ArrayList(listOf));
        f.v(getHostActivity(), bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fi(WinkImageTemplateMediaPickerFragment this$0, String str, Bundle result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(result, "result");
        Object obj = result.get(AECameraConstants.FRAGMENT_CAMERA_RESULT_PATH);
        if (obj instanceof LocalMediaInfo) {
            this$0.Ei((LocalMediaInfo) obj);
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.core.SingleMediaPickerFragment
    public boolean P5(int requestCode) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(QQWinkConstants.WINK_CAPTURE_FRAGMENT_IGNORE_BOTTOM_HEIGHT, true);
        bundle.putInt("ability_flag", 2);
        bundle.putString(QQWinkConstants.ENTRY_BUSINESS_NAME, "QCIRCLE");
        bundle.putString("app_key", "00000QG6YX3X0LZH");
        bundle.putBoolean("camera_direct_return_result", true);
        bundle.putString("camera_fragment_tag", "CAMERA_FRAGMENT_TAG");
        bundle.putInt("fragment_request_business_code", 20240411);
        Context context = getContext();
        if (context instanceof FragmentActivity) {
            ((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).winkLaunchAECameraFragment((FragmentActivity) context, bundle);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.SingleMediaPickerFragment
    public void Ze(@Nullable final LocalMediaInfo mediaInfo) {
        if (mediaInfo == null) {
            b.c("WinkImageTemplateMediaPickerFragment", "select media is null");
            return;
        }
        Context context = getContext();
        if (context != null) {
            d93.c.INSTANCE.b(context, i.x(mediaInfo), new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.qzone.imagetemplate.WinkImageTemplateMediaPickerFragment$onMediaSelect$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    WinkImageTemplateMediaPickerFragment.this.Ei(mediaInfo);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.core.SingleMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment
    public void _$_clearFindViewByIdCache() {
        this.f326140a0.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment
    public void gi() {
        b.f(getTAG(), "onPickerExit invoke");
        AlbumSelectionData.a();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
            activity.overridePendingTransition(0, R.anim.f155066i1);
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        FragmentManager supportFragmentManager;
        if (Di()) {
            FragmentActivity activity = getActivity();
            if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
                supportFragmentManager.popBackStack();
                return true;
            }
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.wink.picker.core.SingleMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        FragmentManager supportFragmentManager;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
            supportFragmentManager.setFragmentResultListener("20240411", this, new FragmentResultListener() { // from class: com.tencent.mobileqq.wink.qzone.imagetemplate.a
                @Override // androidx.fragment.app.FragmentResultListener
                public final void onFragmentResult(String str, Bundle bundle) {
                    WinkImageTemplateMediaPickerFragment.Fi(WinkImageTemplateMediaPickerFragment.this, str, bundle);
                }
            });
        }
    }
}
