package com.tencent.mobileqq.exportfile.fragment.filelist;

import android.text.TextUtils;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.exportfile.fragment.filelist.data.b;
import com.tencent.mobileqq.exportfile.fragment.filelist.manager.FileItemInfoExtKt;
import com.tencent.mobileqq.exportfile.global.QFileBridgeService;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.richmedialist.model.BaseItemInfo;
import com.tencent.mobileqq.richmedialist.model.DirectoryItemInfo;
import com.tencent.mobileqq.richmedialist.model.DownloadState;
import com.tencent.mobileqq.richmedialist.model.FileItemInfo;
import com.tencent.mobileqq.richmedialist.model.ItemType;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qqnt.base.mvi.BaseViewModel;
import com.tencent.qqnt.kernel.nativeinterface.FileBridgeDownloadState;
import com.tencent.qqnt.kernel.nativeinterface.FileBridgeFileType;
import com.tencent.qqnt.kernel.nativeinterface.FileBridgeNodeType;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 C2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u0005:\u0001DB\u000f\u0012\u0006\u0010@\u001a\u00020?\u00a2\u0006\u0004\bA\u0010BJ\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0012\u001a\u00020\u00062\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0002J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J\b\u0010\u001c\u001a\u00020\u0006H\u0007J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0003H\u0016J\u000e\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020\u001fJ\u0010\u0010#\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010(\u001a\u00020\u00062\u0006\u0010'\u001a\u00020&R2\u00101\u001a\u0012\u0012\u0004\u0012\u00020\u00140)j\b\u0012\u0004\u0012\u00020\u0014`*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R2\u00105\u001a\u0012\u0012\u0004\u0012\u00020\u00160)j\b\u0012\u0004\u0012\u00020\u0016`*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010,\u001a\u0004\b3\u0010.\"\u0004\b4\u00100R\u001b\u0010;\u001a\u0002068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u0014\u0010>\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b<\u0010=\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/exportfile/fragment/filelist/FileListViewModel;", "Lcom/tencent/qqnt/base/mvi/BaseViewModel;", "Lcom/tencent/mobileqq/exportfile/fragment/filelist/data/a;", "Lcom/tencent/mobileqq/exportfile/fragment/filelist/data/b;", "Landroidx/lifecycle/LifecycleObserver;", "", "", "g2", SemanticAttributes.DbSystemValues.H2, "i2", "f2", "j2", "", "fileId", "Z1", "", "Lcom/tencent/mobileqq/exportfile/fragment/filelist/data/c;", "recordList", "S1", "fileRecord", "Lcom/tencent/mobileqq/richmedialist/model/DirectoryItemInfo;", "O1", "Lcom/tencent/mobileqq/richmedialist/model/FileItemInfo;", "Q1", "", "W1", "Lcom/tencent/mobileqq/richmedialist/model/ItemType;", "R1", "onCreate", "userIntent", "e2", "Lcom/tencent/qqnt/kernel/nativeinterface/FileBridgeDownloadState;", "state", "Lcom/tencent/mobileqq/richmedialist/model/DownloadState;", "P1", "b2", "Lcom/tencent/mobileqq/richmedialist/model/BaseItemInfo;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "", "selectable", "T1", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/ArrayList;", "U1", "()Ljava/util/ArrayList;", "setDirectoryRecordList", "(Ljava/util/ArrayList;)V", "directoryRecordList", "D", "X1", "setFileRecordList", "fileRecordList", "Lcom/tencent/mobileqq/exportfile/fragment/filelist/FileListRepository;", "E", "Lkotlin/Lazy;", "d2", "()Lcom/tencent/mobileqq/exportfile/fragment/filelist/FileListRepository;", "repository", "c2", "()Lcom/tencent/mobileqq/exportfile/fragment/filelist/data/b;", "mNoneValueIntent", "Landroidx/lifecycle/LifecycleOwner;", "owner", "<init>", "(Landroidx/lifecycle/LifecycleOwner;)V", UserInfo.SEX_FEMALE, "a", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FileListViewModel extends BaseViewModel<com.tencent.mobileqq.exportfile.fragment.filelist.data.a, com.tencent.mobileqq.exportfile.fragment.filelist.data.b> implements LifecycleObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private ArrayList<DirectoryItemInfo> directoryRecordList;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private ArrayList<FileItemInfo> fileRecordList;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy repository;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/exportfile/fragment/filelist/FileListViewModel$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.exportfile.fragment.filelist.FileListViewModel$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f205406a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20893);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[FileBridgeDownloadState.values().length];
            try {
                iArr[FileBridgeDownloadState.KNULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FileBridgeDownloadState.KDOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FileBridgeDownloadState.KCOMPLETE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FileBridgeDownloadState.KWAITING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[FileBridgeDownloadState.KFAILED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f205406a = iArr;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21082);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public FileListViewModel(@NotNull LifecycleOwner owner) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(owner, "owner");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) owner);
            return;
        }
        this.directoryRecordList = new ArrayList<>();
        this.fileRecordList = new ArrayList<>();
        owner.getLifecycle().addObserver(this);
        lazy = LazyKt__LazyJVMKt.lazy(FileListViewModel$repository$2.INSTANCE);
        this.repository = lazy;
    }

    private final DirectoryItemInfo O1(com.tencent.mobileqq.exportfile.fragment.filelist.data.c fileRecord) {
        DirectoryItemInfo directoryItemInfo = new DirectoryItemInfo();
        String str = fileRecord.a().fileId;
        Intrinsics.checkNotNullExpressionValue(str, "fileRecord.nodeInfo.fileId");
        directoryItemInfo.setFileId(str);
        directoryItemInfo.setResId(R.drawable.filelook_floder);
        directoryItemInfo.setItemType(ItemType.DIRECTORY);
        directoryItemInfo.setFileName(fileRecord.a().name);
        directoryItemInfo.setFileTime(FileRecordExtKt.a(fileRecord));
        directoryItemInfo.setExtra(fileRecord.a().nodeType);
        return directoryItemInfo;
    }

    private final FileItemInfo Q1(com.tencent.mobileqq.exportfile.fragment.filelist.data.c fileRecord) {
        FileItemInfo fileItemInfo = new FileItemInfo();
        String str = fileRecord.a().fileId;
        Intrinsics.checkNotNullExpressionValue(str, "fileRecord.nodeInfo.fileId");
        fileItemInfo.setFileId(str);
        fileItemInfo.setItemType(ItemType.FILE);
        fileItemInfo.setFileName(fileRecord.a().name);
        fileItemInfo.setIconPath(fileRecord.b());
        fileItemInfo.setLocalSavePath(fileRecord.a().localSavePath);
        fileItemInfo.setCreateTime(fileRecord.a().creationTime);
        fileItemInfo.setKFileSize(fileRecord.a().fileSize);
        fileItemInfo.setDownloadSpeed(fileRecord.a().downloadSpeed);
        FileBridgeDownloadState fileBridgeDownloadState = fileRecord.a().downloadState;
        Intrinsics.checkNotNullExpressionValue(fileBridgeDownloadState, "fileRecord.nodeInfo.downloadState");
        fileItemInfo.setDownloadState(P1(fileBridgeDownloadState));
        fileItemInfo.setDownloadProgress(FileItemInfoExtKt.i(fileItemInfo));
        fileItemInfo.setFileTime(FileItemInfoExtKt.a(fileItemInfo));
        fileItemInfo.setKFileType(R1(fileRecord));
        fileItemInfo.setResId(W1(fileRecord));
        fileItemInfo.setExtra(fileRecord.a().fileType);
        return fileItemInfo;
    }

    private final ItemType R1(com.tencent.mobileqq.exportfile.fragment.filelist.data.c fileRecord) {
        ItemType itemType = ItemType.FILE;
        if (fileRecord.a().nodeType == FileBridgeNodeType.KDIRECTORY) {
            return ItemType.DIRECTORY;
        }
        if (fileRecord.a().fileType == FileBridgeFileType.KPIC) {
            return ItemType.PICTURE;
        }
        if (fileRecord.a().fileType == FileBridgeFileType.KVIDEO) {
            return ItemType.VIDEO;
        }
        if (fileRecord.a().nodeType != FileBridgeNodeType.KFILE && fileRecord.a().nodeType == FileBridgeNodeType.KNULL) {
            return ItemType.NULL;
        }
        return itemType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S1(List<com.tencent.mobileqq.exportfile.fragment.filelist.data.c> recordList) {
        this.fileRecordList.clear();
        this.directoryRecordList.clear();
        if (recordList != null) {
            for (com.tencent.mobileqq.exportfile.fragment.filelist.data.c cVar : recordList) {
                if (FileRecordExtKt.e(cVar)) {
                    this.fileRecordList.add(Q1(cVar));
                } else {
                    this.directoryRecordList.add(O1(cVar));
                }
            }
        }
    }

    private final int W1(com.tencent.mobileqq.exportfile.fragment.filelist.data.c fileRecord) {
        if (fileRecord.a().fileType != FileBridgeFileType.KPIC && fileRecord.a().fileType != FileBridgeFileType.KVIDEO) {
            return ah.f0(fileRecord.a().name);
        }
        return 0;
    }

    private final void Z1(String fileId) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new FileListViewModel$getFirstViewRecords$1(this, fileId, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FileListRepository d2() {
        return (FileListRepository) this.repository.getValue();
    }

    private final void f2() {
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(QFileBridgeService.f205517a.s(), new FileListViewModel$observeDownloadFinish$1(this, null)), Dispatchers.getMain()), ViewModelKt.getViewModelScope(this));
    }

    private final void g2() {
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(QFileBridgeService.f205517a.t(), new FileListViewModel$observeProgress$1(this, null)), Dispatchers.getMain()), ViewModelKt.getViewModelScope(this));
    }

    private final void h2() {
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(QFileBridgeService.f205517a.u(), new FileListViewModel$observeSpeed$1(this, null)), Dispatchers.getMain()), ViewModelKt.getViewModelScope(this));
    }

    private final void i2() {
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(QFileBridgeService.f205517a.v(), new FileListViewModel$observeState$1(this, null)), Dispatchers.getMain()), ViewModelKt.getViewModelScope(this));
    }

    private final void j2() {
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(QFileBridgeService.f205517a.w(), new FileListViewModel$observeThumbnailDownloadFinish$1(this, null)), Dispatchers.getMain()), ViewModelKt.getViewModelScope(this));
    }

    @NotNull
    public final DownloadState P1(@NotNull FileBridgeDownloadState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (DownloadState) iPatchRedirector.redirect((short) 9, (Object) this, (Object) state);
        }
        Intrinsics.checkNotNullParameter(state, "state");
        DownloadState downloadState = DownloadState.INIT;
        int i3 = b.f205406a[state.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            return DownloadState.FAIL;
                        }
                        return downloadState;
                    }
                    return DownloadState.PAUSE;
                }
                return DownloadState.COMPLETE;
            }
            return DownloadState.DOWNLOADING;
        }
        return downloadState;
    }

    public final void T1(boolean selectable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, selectable);
            return;
        }
        for (FileItemInfo fileItemInfo : this.fileRecordList) {
            fileItemInfo.setShow(selectable);
            fileItemInfo.setChecked(false);
        }
    }

    @NotNull
    public final ArrayList<DirectoryItemInfo> U1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.directoryRecordList;
    }

    @NotNull
    public final ArrayList<FileItemInfo> X1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.fileRecordList;
    }

    @Nullable
    public final BaseItemInfo a2(@NotNull String fileId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (BaseItemInfo) iPatchRedirector.redirect((short) 11, (Object) this, (Object) fileId);
        }
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        for (DirectoryItemInfo directoryItemInfo : this.directoryRecordList) {
            if (TextUtils.equals(fileId, directoryItemInfo.getFileId())) {
                return directoryItemInfo;
            }
        }
        for (FileItemInfo fileItemInfo : this.fileRecordList) {
            if (TextUtils.equals(fileId, fileItemInfo.getFileId())) {
                return fileItemInfo;
            }
        }
        return null;
    }

    public int b2(@NotNull String fileId) {
        Iterable<IndexedValue> withIndex;
        Iterable<IndexedValue> withIndex2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, (Object) fileId)).intValue();
        }
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        withIndex = CollectionsKt___CollectionsKt.withIndex(this.directoryRecordList);
        for (IndexedValue indexedValue : withIndex) {
            int index = indexedValue.getIndex();
            if (TextUtils.equals(fileId, ((DirectoryItemInfo) indexedValue.component2()).getFileId())) {
                return index;
            }
        }
        withIndex2 = CollectionsKt___CollectionsKt.withIndex(this.fileRecordList);
        for (IndexedValue indexedValue2 : withIndex2) {
            int index2 = indexedValue2.getIndex();
            if (TextUtils.equals(fileId, ((FileItemInfo) indexedValue2.component2()).getFileId())) {
                return index2;
            }
        }
        return 0;
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    @NotNull
    /* renamed from: c2, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.exportfile.fragment.filelist.data.b getMNoneValueIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.mobileqq.exportfile.fragment.filelist.data.b) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return b.C7511b.f205425a;
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    /* renamed from: e2, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull com.tencent.mobileqq.exportfile.fragment.filelist.data.b userIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) userIntent);
            return;
        }
        Intrinsics.checkNotNullParameter(userIntent, "userIntent");
        if (userIntent instanceof b.a) {
            Z1(((b.a) userIntent).a());
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        g2();
        h2();
        f2();
        j2();
        i2();
    }
}
