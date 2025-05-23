package com.tencent.mobileqq.filebrowser.richmedia.part;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filebrowser.richmedia.share.FileAbsShareAction;
import com.tencent.mobileqq.filebrowser.richmedia.share.FileShareActionManager;
import com.tencent.mobileqq.filebrowser.richmedia.share.FileShareContext;
import com.tencent.mobileqq.filemanager.api.IQQFileDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.flashtransfer.api.IFlashTransferApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.depend.a;
import com.tencent.mobileqq.richmedia.depend.c;
import com.tencent.mobileqq.richmedia.depend.f;
import com.tencent.mobileqq.richmedia.e;
import com.tencent.mobileqq.richmedia.part.g;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010-\u001a\u00020*\u00a2\u0006\u0004\b3\u00104J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J0\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0012\u0010\u0019\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\"\u0010!\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010\u0006H\u0016J\u0016\u0010%\u001a\u00020$2\u0006\u0010#\u001a\u00020\"2\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010&\u001a\u00020\u0004J\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020(\u0018\u00010'R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u001b\u00102\u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/filebrowser/richmedia/part/FileLayerMorePart;", "Lcom/tencent/mobileqq/richmedia/part/g;", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet$OnItemClickListener;", "Landroid/content/DialogInterface$OnDismissListener;", "", "mediaId", "Landroid/content/Intent;", ICustomDataEditor.STRING_PARAM_3, "Lcom/tencent/mobileqq/filebrowser/richmedia/share/m;", "shareContext", "", "action", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "Lkotlin/collections/ArrayList;", "list", "", "B9", "x9", "position", "onItemLongClick", "onItemLongClickCancel", "onItemLongClickUp", "Landroid/content/DialogInterface;", "dialog", "onDismiss", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "shareActionSheet", "onItemClick", "requestCode", QzoneIPCModule.RESULT_CODE, "data", "onActivityResult", "", "sessionId", "", "C9", ICustomDataEditor.STRING_ARRAY_PARAM_5, "", "", "getReportParams", "Lcom/tencent/mobileqq/filebrowser/richmedia/share/FileShareActionManager;", "f", "Lcom/tencent/mobileqq/filebrowser/richmedia/share/FileShareActionManager;", "shareManager", h.F, "Lkotlin/Lazy;", "D9", "()Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "shareActionSheetBuilder", "<init>", "(Lcom/tencent/mobileqq/filebrowser/richmedia/share/FileShareActionManager;)V", "qqfile-filebrowser-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FileLayerMorePart extends g implements ShareActionSheet.OnItemClickListener, DialogInterface.OnDismissListener {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FileShareActionManager shareManager;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy shareActionSheetBuilder;

    public FileLayerMorePart(@NotNull FileShareActionManager shareManager) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(shareManager, "shareManager");
        this.shareManager = shareManager;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ShareActionSheet>() { // from class: com.tencent.mobileqq.filebrowser.richmedia.part.FileLayerMorePart$shareActionSheetBuilder$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ShareActionSheet invoke() {
                ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
                param.context = FileLayerMorePart.this.getActivity();
                param.deReportParams = FileLayerMorePart.this.getReportParams();
                return ShareActionSheetFactory.create(param);
            }
        });
        this.shareActionSheetBuilder = lazy;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0019, code lost:
    
        r4 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void B9(FileShareContext shareContext, int action, ArrayList<ShareActionSheetBuilder.ActionSheetItem> list) {
        long j3;
        int i3;
        Long longOrNull;
        FileAbsShareAction b16 = this.shareManager.b(action);
        if (b16 != null && b16.e(shareContext)) {
            String mediaId = shareContext.getLayerItemInfo().getMediaId();
            if (mediaId != null && longOrNull != null) {
                j3 = longOrNull.longValue();
            } else {
                j3 = 0;
            }
            if (C9(j3, action)) {
                ShareActionSheetBuilder.ActionSheetItem build = ShareActionSheetBuilder.ActionSheetItem.build(action);
                if (b16.d()) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                build.visibility = i3;
                list.add(build);
            }
        }
    }

    private final ShareActionSheet D9() {
        Object value = this.shareActionSheetBuilder.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-shareActionSheetBuilder>(...)");
        return (ShareActionSheet) value;
    }

    private final Intent s3(String mediaId) {
        f fVar;
        if (TextUtils.isEmpty(mediaId)) {
            return null;
        }
        e eVar = e.f281568a;
        String name = f.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "IShareActionDepend::class.java.name");
        c d16 = eVar.d(name);
        if (d16 instanceof f) {
            fVar = (f) d16;
        } else {
            fVar = null;
        }
        if (fVar == null) {
            return null;
        }
        Intrinsics.checkNotNull(mediaId);
        return fVar.s3(mediaId);
    }

    public final boolean C9(long sessionId, int action) {
        BaseQQAppInterface baseQQAppInterface;
        IQQFileDataCenter iQQFileDataCenter;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        FileManagerEntity fileManagerEntity = null;
        if (peekAppRuntime instanceof BaseQQAppInterface) {
            baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
        } else {
            baseQQAppInterface = null;
        }
        if (baseQQAppInterface != null) {
            iQQFileDataCenter = (IQQFileDataCenter) baseQQAppInterface.getRuntimeService(IQQFileDataCenter.class, "");
        } else {
            iQQFileDataCenter = null;
        }
        if (iQQFileDataCenter != null) {
            fileManagerEntity = iQQFileDataCenter.queryFileEntity(0L, "", 0, sessionId);
        }
        if (fileManagerEntity != null && fileManagerEntity.nOpType == 58) {
            return ((IFlashTransferApi) QRoute.api(IFlashTransferApi.class)).canAddMenu(fileManagerEntity, action);
        }
        if (action == 11) {
            return false;
        }
        return true;
    }

    @NotNull
    public final String a5() {
        e eVar = e.f281568a;
        String name = com.tencent.mobileqq.richmedia.depend.e.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "IRichMediaShareDepend::class.java.name");
        c d16 = eVar.d(name);
        if (d16 instanceof com.tencent.mobileqq.richmedia.depend.e) {
            return ((com.tencent.mobileqq.richmedia.depend.e) d16).a5();
        }
        return "biz_src_jc_file";
    }

    @Nullable
    public final Map<String, Object> getReportParams() {
        e eVar = e.f281568a;
        String name = com.tencent.mobileqq.richmedia.depend.e.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "IRichMediaShareDepend::class.java.name");
        c d16 = eVar.d(name);
        if (d16 instanceof com.tencent.mobileqq.richmedia.depend.e) {
            return ((com.tencent.mobileqq.richmedia.depend.e) d16).getReportParams();
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == 21 || requestCode == 19005) && D9().isShowing()) {
            D9().dismiss();
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(@Nullable DialogInterface dialog) {
        broadcastMessage("LOCK_AUTO_PLAY", Boolean.FALSE);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
    public void onItemClick(@NotNull ShareActionSheetBuilder.ActionSheetItem item, @Nullable ShareActionSheet shareActionSheet) {
        Intrinsics.checkNotNullParameter(item, "item");
        int i3 = item.action;
        if (i3 != 72) {
            D9().dismiss();
        }
        FileAbsShareAction b16 = this.shareManager.b(i3);
        if (b16 != null) {
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            Object partHost = getPartHost();
            Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
            View rootView = getPartRootView();
            Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
            Intrinsics.checkNotNull(rFWLayerItemMediaInfo);
            b16.a(new FileShareContext(activity, (Fragment) partHost, rootView, rFWLayerItemMediaInfo), item);
        }
    }

    @Override // com.tencent.mobileqq.richmedia.part.g, com.tencent.richframework.gallery.widget.RFWGalleryViewPager.OnItemLongClickListener
    public void onItemLongClick(int position) {
        String mediaId;
        a aVar;
        x9();
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        if (rFWLayerItemMediaInfo != null && (mediaId = rFWLayerItemMediaInfo.getMediaId()) != null) {
            e eVar = e.f281568a;
            String name = a.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "ICommonLayerOperationReport::class.java.name");
            c d16 = eVar.d(name);
            if (d16 instanceof a) {
                aVar = (a) d16;
            } else {
                aVar = null;
            }
            if (aVar != null) {
                aVar.u2(mediaId);
            }
        }
    }

    @Override // com.tencent.mobileqq.richmedia.part.g
    public void x9() {
        if (!sm2.a.f433978a.d(this.mCurrentSelectedItem)) {
            return;
        }
        if (this.mCurrentSelectedItem == null) {
            QLog.i("FileLayerMorePart", 1, "showActionSheet mCurrentSelectedItem is null!");
            return;
        }
        super.x9();
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList = new ArrayList<>();
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList2 = new ArrayList<>();
        this.shareManager.e(D9());
        D9().setRowVisibility(0, 0, 0);
        if (getActivity().getIntent() != null) {
            getActivity().getIntent().putExtra("big_brother_source_key", a5());
        }
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        Object partHost = getPartHost();
        Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        View rootView = getPartRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        Intrinsics.checkNotNull(rFWLayerItemMediaInfo);
        FileShareContext fileShareContext = new FileShareContext(activity, (Fragment) partHost, rootView, rFWLayerItemMediaInfo);
        for (Map.Entry<Integer, FileAbsShareAction> entry : this.shareManager.c().entrySet()) {
            if (entry.getValue().b() == FileShareActionManager.ShareLine.FIRST) {
                B9(fileShareContext, entry.getKey().intValue(), arrayList);
            } else if (entry.getValue().b() == FileShareActionManager.ShareLine.SECOND) {
                B9(fileShareContext, entry.getKey().intValue(), arrayList2);
            }
        }
        Intent s36 = s3(fileShareContext.getLayerItemInfo().getMediaId());
        if (s36 != null) {
            D9().setIntentForStartForwardRecentActivity(s36);
        }
        this.shareManager.d(arrayList, arrayList2);
        D9().setItemClickListenerV2(this);
        D9().setOnDismissListener(this);
        z9();
        broadcastMessage("LOCK_AUTO_PLAY", Boolean.TRUE);
        this.shareManager.f(fileShareContext);
    }

    @Override // com.tencent.mobileqq.richmedia.part.g, com.tencent.richframework.gallery.widget.RFWGalleryViewPager.OnItemLongClickListener
    public void onItemLongClickCancel(int position) {
    }

    @Override // com.tencent.mobileqq.richmedia.part.g, com.tencent.richframework.gallery.widget.RFWGalleryViewPager.OnItemLongClickListener
    public void onItemLongClickUp(int position) {
    }
}
