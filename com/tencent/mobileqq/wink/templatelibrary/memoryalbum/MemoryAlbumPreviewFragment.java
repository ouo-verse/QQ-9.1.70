package com.tencent.mobileqq.wink.templatelibrary.memoryalbum;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.wink.QQWinkActivity;
import com.tencent.mobileqq.wink.api.IWinkProfileThemeHelp;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.templatelibrary.memoryalbum.data.WinkAlbumItemWrapper;
import com.tencent.mobileqq.wink.templatelibrary.memoryalbum.part.MemoryAlbumPreviewPart;
import com.tencent.mobileqq.wink.templatelibrary.memoryalbum.part.MemoryAlbumUnAuthorizePart;
import com.tencent.mobileqq.wink.templatelibrary.memoryalbum.viewmodel.WinkAlbumDataViewModel;
import com.tencent.mobileqq.wink.utils.ar;
import com.tencent.mobileqq.wink.view.QCircleCommonLoadingDialog;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 @2\u00020\u0001:\u0001AB\u0007\u00a2\u0006\u0004\b>\u0010?J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\tH\u0014J\b\u0010\u000b\u001a\u00020\u0002H\u0014J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J&\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0006\u0010\u0019\u001a\u00020\u0004J\b\u0010\u001a\u001a\u00020\u0002H\u0014J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016J\b\u0010\u001d\u001a\u00020\tH\u0016J/\u0010$\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00022\u000e\u0010!\u001a\n\u0012\u0006\b\u0001\u0012\u00020 0\u001f2\u0006\u0010#\u001a\u00020\"H\u0016\u00a2\u0006\u0004\b$\u0010%R\u001b\u0010+\u001a\u00020&8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001b\u00100\u001a\u00020,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010(\u001a\u0004\b.\u0010/R\u001b\u00105\u001a\u0002018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u0010(\u001a\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/MemoryAlbumPreviewFragment;", "Lcom/tencent/biz/richframework/part/ImmersivePartFragment;", "", "res", "", "Hh", "dismissLoading", "yh", "Fh", "", "isUseDarkTextStatusBar", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "initViewModel", "getStatusBarColor", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onBackEvent", "requestCode", "", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/viewmodel/a;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "Ah", "()Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/viewmodel/a;", "memoryAlbumPreviewViewModel", "Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/viewmodel/WinkAlbumDataViewModel;", "D", OcrConfig.CHINESE, "()Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/viewmodel/WinkAlbumDataViewModel;", "albumDataViewModel", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "E", "Bh", "()Lcom/tencent/mobileqq/qqpermission/QQPermission;", "qqPermission", "Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", "loadingDialog", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "debugInfoView", "<init>", "()V", "I", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class MemoryAlbumPreviewFragment extends ImmersivePartFragment {

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy memoryAlbumPreviewViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy albumDataViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy qqPermission;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private QCircleCommonLoadingDialog loadingDialog;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private TextView debugInfoView;

    @NotNull
    public Map<Integer, View> H = new LinkedHashMap();

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/MemoryAlbumPreviewFragment$a;", "", "Landroid/content/Intent;", "intent", "", "c", "Landroid/content/Context;", "context", "b", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.MemoryAlbumPreviewFragment$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void c(Intent intent) {
            Object obj;
            if (intent == null) {
                return;
            }
            Bundle extras = intent.getExtras();
            HashMap hashMap = null;
            if (extras != null) {
                obj = extras.get("key_attrs");
            } else {
                obj = null;
            }
            if (obj instanceof HashMap) {
                hashMap = (HashMap) obj;
            }
            if (hashMap == null) {
                return;
            }
            if (hashMap.containsKey(QCircleScheme.AttrQQPublish.MEMORY_ALBUM_ID)) {
                hashMap.remove(QCircleScheme.AttrQQPublish.MEMORY_ALBUM_ID);
            }
            if (hashMap.containsKey(QCircleScheme.AttrQQPublish.MEMORY_ALBUM_TITLE)) {
                hashMap.remove(QCircleScheme.AttrQQPublish.MEMORY_ALBUM_TITLE);
            }
        }

        public final void a(@NotNull Activity activity) {
            Bundle extras;
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intent intent = new Intent();
            Intent intent2 = activity.getIntent();
            if (intent2 != null && (extras = intent2.getExtras()) != null) {
                intent.putExtras(extras);
            }
            intent.setClass(activity, QQWinkActivity.class);
            intent.putExtra("public_fragment_class", MemoryAlbumPreviewFragment.class.getName());
            ((IWinkProfileThemeHelp) QRoute.api(IWinkProfileThemeHelp.class)).addUseProfileThemeFlag(intent);
            activity.startActivity(intent);
            c(activity.getIntent());
        }

        public final void b(@NotNull Context context, @NotNull Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            intent.setClass(context, QQWinkActivity.class);
            intent.putExtra(QQWinkConstants.WINK_AUTO_RELEASE_MEMORY_ALBUM_GENERATOR, true);
            intent.putExtra("public_fragment_class", MemoryAlbumPreviewFragment.class.getName());
            context.startActivity(intent);
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/wink/templatelibrary/memoryalbum/MemoryAlbumPreviewFragment$b", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends QQPermission.BasePermissionsListener {
        b() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            MemoryAlbumPreviewFragment.this.Ah().R1();
        }
    }

    public MemoryAlbumPreviewFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.wink.templatelibrary.memoryalbum.viewmodel.a>() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.MemoryAlbumPreviewFragment$memoryAlbumPreviewViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.wink.templatelibrary.memoryalbum.viewmodel.a invoke() {
                return (com.tencent.mobileqq.wink.templatelibrary.memoryalbum.viewmodel.a) MemoryAlbumPreviewFragment.this.getViewModel(com.tencent.mobileqq.wink.templatelibrary.memoryalbum.viewmodel.a.class);
            }
        });
        this.memoryAlbumPreviewViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<WinkAlbumDataViewModel>() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.MemoryAlbumPreviewFragment$albumDataViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WinkAlbumDataViewModel invoke() {
                return (WinkAlbumDataViewModel) MemoryAlbumPreviewFragment.this.getViewModel(WinkAlbumDataViewModel.class);
            }
        });
        this.albumDataViewModel = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<QQPermission>() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.MemoryAlbumPreviewFragment$qqPermission$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QQPermission invoke() {
                return QQPermissionFactory.getQQPermission(MemoryAlbumPreviewFragment.this.getActivity(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_CIRCLE_PUBLISH, QQPermissionConstants.Business.SCENE.CIRCLE_PUBLISH_TEMPLATE));
            }
        });
        this.qqPermission = lazy3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.wink.templatelibrary.memoryalbum.viewmodel.a Ah() {
        Object value = this.memoryAlbumPreviewViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-memoryAlbumPreviewViewModel>(...)");
        return (com.tencent.mobileqq.wink.templatelibrary.memoryalbum.viewmodel.a) value;
    }

    private final QQPermission Bh() {
        Object value = this.qqPermission.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-qqPermission>(...)");
        return (QQPermission) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ch(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Dh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Fh() {
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(getFragmentContentView(), WinkDaTongReportConstant.PageId.PG_XSJ_MEMORIES_COLLECTION_PAGE);
        String c16 = WinkContext.INSTANCE.d().getDtParams().c();
        VideoReport.setEventDynamicParams(getFragmentContentView(), new IDynamicParams() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.g
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map Gh;
                Gh = MemoryAlbumPreviewFragment.Gh(MemoryAlbumPreviewFragment.this, str);
                return Gh;
            }
        });
        VideoReport.setPageParams(getFragmentContentView(), new WinkDTParamBuilder().buildPageParams(null, c16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map Gh(MemoryAlbumPreviewFragment this$0, String str) {
        String str2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ar arVar = ar.f326685a;
        int i3 = 0;
        if (arVar.c(arVar.k("ae_key_editor_memory_album_enable"), false)) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        linkedHashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_AUTHORIZE_MEMORIES_COLLECTION, str2);
        List<WinkAlbumItemWrapper> value = this$0.zh().S1().getValue();
        if (value != null) {
            i3 = value.size();
        }
        linkedHashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MEMORIES_COLLECTION_PAGE_HAVE_COUNT, Integer.valueOf(i3));
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Hh(int res) {
        String str;
        dismissLoading();
        Context context = getContext();
        if (context != null) {
            str = context.getString(res);
        } else {
            str = null;
        }
        pa3.c cVar = pa3.c.f425850a;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        QCircleCommonLoadingDialog b16 = cVar.b(requireContext, str, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.MemoryAlbumPreviewFragment$startLoading$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                com.tencent.mobileqq.wink.templatelibrary.memoryalbum.viewmodel.a.Q1(MemoryAlbumPreviewFragment.this.Ah(), false, 0, 2, null);
            }
        });
        this.loadingDialog = b16;
        if (b16 != null) {
            b16.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismissLoading() {
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog;
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog2 = this.loadingDialog;
        boolean z16 = false;
        if (qCircleCommonLoadingDialog2 != null && qCircleCommonLoadingDialog2.isShowing()) {
            z16 = true;
        }
        if (z16 && (qCircleCommonLoadingDialog = this.loadingDialog) != null) {
            qCircleCommonLoadingDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void yh() {
        if (Bh().hasPermission(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE) == 0 && Bh().hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
            Ah().R1();
        } else {
            Bh().requestPermissions(new String[]{QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new b());
        }
    }

    private final WinkAlbumDataViewModel zh() {
        Object value = this.albumDataViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-albumDataViewModel>(...)");
        return (WinkAlbumDataViewModel) value;
    }

    public void _$_clearFindViewByIdCache() {
        this.H.clear();
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        if (!v83.e.f441245a.f()) {
            arrayList.add(new MemoryAlbumUnAuthorizePart());
        }
        arrayList.add(new MemoryAlbumPreviewPart());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.i6o;
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    public final void initViewModel() {
        MutableLiveData<Pair<Boolean, Integer>> N1 = Ah().N1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Pair<? extends Boolean, ? extends Integer>, Unit> function1 = new Function1<Pair<? extends Boolean, ? extends Integer>, Unit>() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.MemoryAlbumPreviewFragment$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends Boolean, ? extends Integer> pair) {
                invoke2((Pair<Boolean, Integer>) pair);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<Boolean, Integer> pair) {
                if (pair.getFirst().booleanValue()) {
                    MemoryAlbumPreviewFragment.this.Hh(pair.getSecond().intValue());
                } else {
                    MemoryAlbumPreviewFragment.this.dismissLoading();
                }
            }
        };
        N1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MemoryAlbumPreviewFragment.Ch(Function1.this, obj);
            }
        });
        LiveData<Boolean> O1 = Ah().O1();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.MemoryAlbumPreviewFragment$initViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (it.booleanValue()) {
                    MemoryAlbumPreviewFragment.this.yh();
                }
            }
        };
        O1.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MemoryAlbumPreviewFragment.Dh(Function1.this, obj);
            }
        });
        MutableLiveData<String> R1 = zh().R1();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        final Function1<String, Unit> function13 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.MemoryAlbumPreviewFragment$initViewModel$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                TextView textView;
                TextView textView2;
                TextView textView3;
                if (!TextUtils.isEmpty(str)) {
                    textView2 = MemoryAlbumPreviewFragment.this.debugInfoView;
                    if (textView2 != null) {
                        textView2.setText(str);
                    }
                    textView3 = MemoryAlbumPreviewFragment.this.debugInfoView;
                    if (textView3 == null) {
                        return;
                    }
                    textView3.setVisibility(0);
                    return;
                }
                textView = MemoryAlbumPreviewFragment.this.debugInfoView;
                if (textView == null) {
                    return;
                }
                textView.setVisibility(8);
            }
        };
        R1.observe(viewLifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MemoryAlbumPreviewFragment.Eh(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean isUseDarkTextStatusBar() {
        if (!uq3.c.P6()) {
            return true;
        }
        return !QQTheme.isNowThemeIsNight();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        Object firstOrNull;
        Intrinsics.checkNotNullExpressionValue(getParentFragmentManager().getFragments(), "parentFragmentManager.fragments");
        if (!r0.isEmpty()) {
            List<Fragment> fragments = getParentFragmentManager().getFragments();
            Intrinsics.checkNotNullExpressionValue(fragments, "parentFragmentManager.fragments");
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) fragments);
            Fragment fragment = (Fragment) firstOrNull;
            if (fragment != null) {
                if (fragment instanceof MemoryAlbumSettingFragment) {
                    getParentFragmentManager().popBackStackImmediate();
                    return true;
                }
                return super.onBackEvent();
            }
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View onCreateView = super.onCreateView(inflater, container, savedInstanceState);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ApngImage.pauseAll();
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int requestCode, @NotNull String[] permissions, @NotNull int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        Bh().onRequestPermissionResult(requestCode, permissions, grantResults);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Fh();
        ApngImage.resumeAll();
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initViewModel();
        ((ConstraintLayout) view.findViewById(R.id.z2w)).setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
        ((ConstraintLayout) view.findViewById(R.id.f124287iy)).setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
        this.debugInfoView = (TextView) view.findViewById(R.id.z2x);
    }
}
