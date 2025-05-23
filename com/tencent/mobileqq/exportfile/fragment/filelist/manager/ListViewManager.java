package com.tencent.mobileqq.exportfile.fragment.filelist.manager;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.exportfile.fragment.filelist.FileListViewModel;
import com.tencent.mobileqq.exportfile.fragment.filelist.r;
import com.tencent.mobileqq.exportfile.fragment.filelist.s;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.richmedialist.model.BaseItemInfo;
import com.tencent.mobileqq.richmedialist.model.FileItemInfo;
import com.tencent.mobileqq.richmedialist.model.ItemType;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.FileBridgeDownloadState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 82\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b6\u00107J:\u0010\b\u001a6\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00030\u0002j\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003`\u0007JB\u0010\u000b\u001a\u00020\n2:\u0010\t\u001a6\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00030\u0002j\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003`\u0007J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u0011J\u0016\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u000fJ\u0016\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0016J\u0016\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0011J\u0016\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0011J\u0016\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001dJ\u0016\u0010!\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u0011J\u0016\u0010$\u001a\u00020\n2\u0006\u0010#\u001a\u00020\"2\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010&\u001a\u00020\n2\u0006\u0010%\u001a\u00020\"J\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0006\u0010(\u001a\u00020\nJ\u000e\u0010)\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011J\u0014\u0010+\u001a\u00020\n2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005R\u0018\u0010.\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\"\u00105\u001a\u00020/8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0010\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/exportfile/fragment/filelist/manager/ListViewManager;", "Lbn2/a;", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "Lcom/tencent/mobileqq/richmedialist/model/ItemType;", "", "Lcom/tencent/mobileqq/richmedialist/model/BaseItemInfo;", "Lkotlin/collections/ArrayList;", "p", "dataList", "", "t", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "a", "itemInfo", "", "d", "", "fileId", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "progress", HippyTKDListViewAdapter.X, "", "speed", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "localFilePath", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "thumbnailPath", "w", "Lcom/tencent/qqnt/kernel/nativeinterface/FileBridgeDownloadState;", "state", "u", "path", "v", "", "isSelected", "y", "selectable", DomainData.DOMAIN_NAME, "o", "j", "k", "recordList", "l", "c", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "contactAdapter", "Lcom/tencent/mobileqq/exportfile/fragment/filelist/FileListViewModel;", "Lcom/tencent/mobileqq/exportfile/fragment/filelist/FileListViewModel;", "r", "()Lcom/tencent/mobileqq/exportfile/fragment/filelist/FileListViewModel;", ReportConstant.COSTREPORT_PREFIX, "(Lcom/tencent/mobileqq/exportfile/fragment/filelist/FileListViewModel;)V", "viewModel", "<init>", "()V", "e", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class ListViewManager extends bn2.a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RFWConcatAdapter contactAdapter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public FileListViewModel viewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/exportfile/fragment/filelist/manager/ListViewManager$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.exportfile.fragment.filelist.manager.ListViewManager$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23967);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 22)) {
            redirector.redirect((short) 22);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ListViewManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // bn2.a
    @NotNull
    public RFWConcatAdapter a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (RFWConcatAdapter) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (this.contactAdapter == null) {
            r rVar = new r();
            rVar.setHasStableIds(true);
            s sVar = new s();
            sVar.setHasStableIds(true);
            c().put(ItemType.DIRECTORY, rVar);
            c().put(ItemType.FILE, sVar);
            this.contactAdapter = new RFWConcatAdapter(new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build(), (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{rVar, sVar});
        }
        RFWConcatAdapter rFWConcatAdapter = this.contactAdapter;
        Intrinsics.checkNotNull(rFWConcatAdapter);
        return rFWConcatAdapter;
    }

    @Override // bn2.a
    public int d(@NotNull BaseItemInfo itemInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, (Object) itemInfo)).intValue();
        }
        Intrinsics.checkNotNullParameter(itemInfo, "itemInfo");
        return r().b2(itemInfo.getFileId());
    }

    public final void j() {
        List<BaseItemInfo> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        Iterator<T> it = r().X1().iterator();
        while (it.hasNext()) {
            ((FileItemInfo) it.next()).setChecked(false);
        }
        AsyncListDifferDelegationAdapter<BaseItemInfo> f16 = f(ItemType.FILE);
        if (f16 != null) {
            list = CollectionsKt___CollectionsKt.toList(r().X1());
            f16.setItems(list);
        }
    }

    public final void k(@NotNull String fileId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) fileId);
            return;
        }
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        CoroutineScope f16 = com.tencent.mobileqq.exportfile.fragment.filelist.b.f(0, 1, null);
        BuildersKt__Builders_commonKt.launch$default(f16, null, null, new ListViewManager$doDownloadFile$1(fileId, f16, this, null), 3, null);
        u(fileId, FileBridgeDownloadState.KWAITING);
    }

    public final void l(@NotNull List<? extends BaseItemInfo> recordList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) recordList);
            return;
        }
        Intrinsics.checkNotNullParameter(recordList, "recordList");
        CoroutineScope f16 = com.tencent.mobileqq.exportfile.fragment.filelist.b.f(0, 1, null);
        BuildersKt__Builders_commonKt.launch$default(f16, null, null, new ListViewManager$downloadFileList$1(recordList, f16, this, null), 3, null);
    }

    public final void m(@NotNull String fileId, @NotNull String localFilePath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) fileId, (Object) localFilePath);
            return;
        }
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        Intrinsics.checkNotNullParameter(localFilePath, "localFilePath");
        QLog.d("ListViewManager", 1, "downloadFinish fileId: " + fileId + ", localFilePath: " + localFilePath);
        BaseItemInfo q16 = q(fileId);
        if (q16 instanceof FileItemInfo) {
            FileItemInfo fileItemInfo = (FileItemInfo) q16;
            fileItemInfo.setDownloadState(r().P1(FileBridgeDownloadState.KCOMPLETE));
            fileItemInfo.setFileTime(FileItemInfoExtKt.a(fileItemInfo));
            fileItemInfo.setLocalSavePath(localFilePath);
            i(q16);
        }
    }

    public final void n(boolean selectable) {
        List<BaseItemInfo> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, selectable);
            return;
        }
        r().T1(selectable);
        AsyncListDifferDelegationAdapter<BaseItemInfo> f16 = f(ItemType.FILE);
        if (f16 != null) {
            list = CollectionsKt___CollectionsKt.toList(r().X1());
            f16.setItems(list);
        }
    }

    @NotNull
    public final List<BaseItemInfo> o() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (List) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        ArrayList<FileItemInfo> X1 = r().X1();
        ArrayList arrayList = new ArrayList();
        for (Object obj : X1) {
            FileItemInfo fileItemInfo = (FileItemInfo) obj;
            if (fileItemInfo.getIsShow() && fileItemInfo.getIsChecked()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @NotNull
    public final ArrayList<Pair<ItemType, List<BaseItemInfo>>> p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ArrayList) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        ArrayList<Pair<ItemType, List<BaseItemInfo>>> arrayList = new ArrayList<>();
        arrayList.add(new Pair<>(ItemType.DIRECTORY, r().U1()));
        arrayList.add(new Pair<>(ItemType.FILE, r().X1()));
        return arrayList;
    }

    @Nullable
    public final BaseItemInfo q(@NotNull String fileId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (BaseItemInfo) iPatchRedirector.redirect((short) 9, (Object) this, (Object) fileId);
        }
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        return r().a2(fileId);
    }

    @NotNull
    public final FileListViewModel r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (FileListViewModel) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        FileListViewModel fileListViewModel = this.viewModel;
        if (fileListViewModel != null) {
            return fileListViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public final void s(@NotNull FileListViewModel fileListViewModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) fileListViewModel);
        } else {
            Intrinsics.checkNotNullParameter(fileListViewModel, "<set-?>");
            this.viewModel = fileListViewModel;
        }
    }

    public final void t(@NotNull ArrayList<Pair<ItemType, List<BaseItemInfo>>> dataList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) dataList);
        } else {
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            e().postValue(dataList);
        }
    }

    public final void u(@NotNull String fileId, @NotNull FileBridgeDownloadState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) fileId, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        Intrinsics.checkNotNullParameter(state, "state");
        QLog.d("ListViewManager", 1, "updateDownloadState fileId: " + fileId + ", state: " + state);
        BaseItemInfo q16 = q(fileId);
        if (q16 instanceof FileItemInfo) {
            FileItemInfo fileItemInfo = (FileItemInfo) q16;
            fileItemInfo.setDownloadState(r().P1(state));
            fileItemInfo.setFileTime(FileItemInfoExtKt.a(fileItemInfo));
            fileItemInfo.setDownloadProgress(FileItemInfoExtKt.i(fileItemInfo));
            i(q16);
        }
    }

    public final void v(@NotNull String fileId, @NotNull String path) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) fileId, (Object) path);
            return;
        }
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        Intrinsics.checkNotNullParameter(path, "path");
        QLog.d("ListViewManager", 1, "updateDownloadState fileId: " + fileId + ", path: " + path);
        BaseItemInfo q16 = q(fileId);
        if (q16 instanceof FileItemInfo) {
            FileItemInfo fileItemInfo = (FileItemInfo) q16;
            String localSavePath = fileItemInfo.getLocalSavePath();
            fileItemInfo.setLocalSavePath(path);
            if (q.p(path) ^ q.p(localSavePath)) {
                i(q16);
            }
        }
    }

    public final void w(@NotNull String fileId, @NotNull String thumbnailPath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) fileId, (Object) thumbnailPath);
            return;
        }
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        Intrinsics.checkNotNullParameter(thumbnailPath, "thumbnailPath");
        QLog.d("ListViewManager", 1, "updateLocalFileThumbnailPath fileId: " + fileId + ", thumbnailPath: " + thumbnailPath);
        BaseItemInfo q16 = q(fileId);
        if (q16 instanceof FileItemInfo) {
            FileItemInfo fileItemInfo = (FileItemInfo) q16;
            String iconPath = fileItemInfo.getIconPath();
            fileItemInfo.setIconPath(thumbnailPath);
            if (q.p(thumbnailPath) ^ q.p(iconPath)) {
                i(q16);
            }
        }
    }

    public final void x(@NotNull String fileId, int progress) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) fileId, progress);
            return;
        }
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        BaseItemInfo q16 = q(fileId);
        if (q16 instanceof FileItemInfo) {
            FileItemInfo fileItemInfo = (FileItemInfo) q16;
            fileItemInfo.setDownloadProgress(progress);
            fileItemInfo.setDownloadProgress(FileItemInfoExtKt.i(fileItemInfo));
            fileItemInfo.setFileTime(FileItemInfoExtKt.a(fileItemInfo));
            i(q16);
        }
    }

    public final void y(boolean isSelected, @NotNull String fileId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Boolean.valueOf(isSelected), fileId);
            return;
        }
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        BaseItemInfo q16 = q(fileId);
        if (q16 instanceof FileItemInfo) {
            ((FileItemInfo) q16).setChecked(isSelected);
            i(q16);
        }
    }

    public final void z(@NotNull String fileId, long speed) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, fileId, Long.valueOf(speed));
            return;
        }
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        BaseItemInfo q16 = q(fileId);
        if (q16 instanceof FileItemInfo) {
            FileItemInfo fileItemInfo = (FileItemInfo) q16;
            fileItemInfo.setDownloadSpeed(speed);
            fileItemInfo.setFileTime(FileItemInfoExtKt.a(fileItemInfo));
            i(q16);
        }
    }
}
