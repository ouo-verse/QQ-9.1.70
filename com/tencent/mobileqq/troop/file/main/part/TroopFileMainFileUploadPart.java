package com.tencent.mobileqq.troop.file.main.part;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.filemanager.api.IQQFileSelector;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.file.main.vm.TroopFileMainVM;
import com.tencent.mobileqq.util.bc;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.qbasealbum.model.AlbumResult;
import com.tencent.qqnt.qbasealbum.model.Config;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.model.PickerInitBean;
import com.tencent.qqnt.qbasealbum.model.TabType;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000  2\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0002J\u001c\u0010\u0013\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\"\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0016R\u0017\u0010\u001d\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/troop/file/main/part/TroopFileMainFileUploadPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lkotlin/Function0;", "", "granted", "A9", "D9", "Landroid/content/Intent;", "intent", "B9", "", "showVideo", "F9", "data", "E9", "", "action", "", "args", "handleBroadcastMessage", "", "requestCode", QzoneIPCModule.RESULT_CODE, "onActivityResult", "Lcom/tencent/mobileqq/troop/file/main/vm/TroopFileMainVM;", "d", "Lcom/tencent/mobileqq/troop/file/main/vm/TroopFileMainVM;", "C9", "()Lcom/tencent/mobileqq/troop/file/main/vm/TroopFileMainVM;", "viewModel", "<init>", "(Lcom/tencent/mobileqq/troop/file/main/vm/TroopFileMainVM;)V", "e", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class TroopFileMainFileUploadPart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final TroopFileMainVM viewModel;

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\t\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/troop/file/main/part/TroopFileMainFileUploadPart$b", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f295547a;

        b(Function0<Unit> function0) {
            this.f295547a = function0;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            this.f295547a.invoke();
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> permissions, List<Integer> results) {
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            Intrinsics.checkNotNullParameter(results, "results");
        }
    }

    public TroopFileMainFileUploadPart(TroopFileMainVM viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.viewModel = viewModel;
    }

    private final void A9(Function0<Unit> granted) {
        Object partHost = getPartHost();
        Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        QQPermission qQPermission = QQPermissionFactory.getQQPermission((Fragment) partHost);
        if (qQPermission == null) {
            QLog.e("TroopFile.Main.TroopFileMainFileUploadPart", 1, "checkFilePermissions, getQQPermission null.");
        } else if (qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) != 0) {
            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new b(granted));
        } else {
            granted.invoke();
        }
    }

    private final void B9(Intent intent) {
        intent.putExtra(PeakConstants.SEND_BUSINESS_TYPE, 1052);
        intent.putExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, 0);
        intent.putExtra(PeakConstants.IS_SHOW_QZONE_ALBUM, false);
        intent.putExtra(PeakConstants.IS_TROOP_SEND_MIXED_MSG, false);
        intent.putExtra(PeakConstants.DISABLE_UPLOAD_TO_TROOP_ALBUM, true);
        intent.putExtra(PeakConstants.UPLOAD_CHECKBOX_IS_CHECKED, true);
        intent.putExtra(PeakConstants.AIO_TO_PHOTO_LIST_NEED_SHOW_UPLOAD_BAR, false);
        intent.putExtra(PeakConstants.QZONE_ALBUM_FROM_AIO, true);
        intent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D9() {
        ((IQQFileSelector) QRoute.api(IQQFileSelector.class)).openFileSelectorForTroopFileBrowser(getActivity(), this.viewModel.T1().troopUinStr, !Intrinsics.areEqual("/", this.viewModel.T1().folderId), this.viewModel.a2());
        getActivity().overridePendingTransition(R.anim.f154424l, R.anim.f154425m);
    }

    private final void E9(Intent data) {
        AlbumResult albumResult;
        if (data != null && (albumResult = (AlbumResult) data.getParcelableExtra("ALBUM_RESULT")) != null) {
            ArrayList arrayList = new ArrayList();
            List<LocalMediaInfo> e16 = albumResult.e();
            if (e16 != null) {
                for (LocalMediaInfo localMediaInfo : e16) {
                    String path = localMediaInfo.getPath();
                    if (!(path == null || path.length() == 0)) {
                        String path2 = localMediaInfo.getPath();
                        Intrinsics.checkNotNull(path2);
                        arrayList.add(path2);
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                BuildersKt__Builders_commonKt.launch$default(bc.d(this), null, null, new TroopFileMainFileUploadPart$handleSelectedMedia$3(this, arrayList, null), 3, null);
                return;
            } else {
                QLog.e("TroopFile.Main.TroopFileMainFileUploadPart", 1, "handleSelectedMedia, filePathList is empty.");
                return;
            }
        }
        QLog.e("TroopFile.Main.TroopFileMainFileUploadPart", 1, "handleSelectedMedia, albumResult is null.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F9(boolean showVideo) {
        TabType tabType;
        com.tencent.qqnt.qbasealbum.a aVar = com.tencent.qqnt.qbasealbum.a.f360732a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Config.Companion companion = Config.INSTANCE;
        Config.a aVar2 = new Config.a();
        aVar2.g(9);
        if (showVideo) {
            tabType = TabType.TAB_VIDEO;
        } else {
            tabType = TabType.TAB_IMAGE;
        }
        aVar2.f(tabType);
        aVar2.e(2);
        aVar2.b(new ArrayList());
        aVar2.d(false);
        aVar2.l(false);
        aVar2.o(new HashMap<>());
        Unit unit = Unit.INSTANCE;
        Config a16 = aVar2.a();
        PickerInitBean.Companion companion2 = PickerInitBean.INSTANCE;
        PickerInitBean.a aVar3 = new PickerInitBean.a();
        aVar3.b(bc.f(this, R.string.a8j));
        Intent e16 = com.tencent.qqnt.qbasealbum.a.e(aVar, context, a16, aVar3.a(), null, null, 24, null);
        B9(e16);
        getActivity().startActivityForResult(e16, 2);
    }

    /* renamed from: C9, reason: from getter */
    public final TroopFileMainVM getViewModel() {
        return this.viewModel;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != -1) {
            return;
        }
        if (requestCode == 2) {
            E9(data);
        } else {
            if (requestCode != 3) {
                return;
            }
            BuildersKt__Builders_commonKt.launch$default(bc.d(this), null, null, new TroopFileMainFileUploadPart$onActivityResult$1(this, data, null), 3, null);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String action, Object args) {
        if (action != null) {
            int hashCode = action.hashCode();
            if (hashCode == -2111820959) {
                if (action.equals("select_file_upload")) {
                    A9(new Function0<Unit>() { // from class: com.tencent.mobileqq.troop.file.main.part.TroopFileMainFileUploadPart$handleBroadcastMessage$1
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
                            TroopFileMainFileUploadPart.this.D9();
                        }
                    });
                }
            } else {
                if (hashCode != -1782762328) {
                    if (hashCode == -1037343800 && action.equals("select_image_upload")) {
                        A9(new Function0<Unit>() { // from class: com.tencent.mobileqq.troop.file.main.part.TroopFileMainFileUploadPart$handleBroadcastMessage$2
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
                                TroopFileMainFileUploadPart.this.F9(false);
                            }
                        });
                        return;
                    }
                    return;
                }
                if (action.equals("select_video_upload")) {
                    A9(new Function0<Unit>() { // from class: com.tencent.mobileqq.troop.file.main.part.TroopFileMainFileUploadPart$handleBroadcastMessage$3
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
                            TroopFileMainFileUploadPart.this.F9(true);
                        }
                    });
                }
            }
        }
    }
}
