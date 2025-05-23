package com.tencent.mobileqq.minigame.va.downloadui;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.minigame.api.IMiniGameVAService;
import com.tencent.mobileqq.minigame.va.IMiniGameVA;
import com.tencent.mobileqq.minigame.va.MiniGameDownloadDataWrapper;
import com.tencent.mobileqq.minigame.va.StatusListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 -2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001-B\u0007\u00a2\u0006\u0004\b+\u0010,J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0005H\u0002J\b\u0010\u000f\u001a\u00020\tH\u0002J\b\u0010\u0010\u001a\u00020\tH\u0002J\u0006\u0010\u0011\u001a\u00020\tJ\u000e\u0010\u0012\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0005J\u000e\u0010\u0013\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0005J\u000e\u0010\u0014\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0005J\u000e\u0010\u0015\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0005J\u000e\u0010\u0016\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0005J\b\u0010\u0017\u001a\u00020\tH\u0014J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0005H\u0016R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001aR#\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR#\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u001b8\u0006\u00a2\u0006\f\n\u0004\b \u0010\u001d\u001a\u0004\b!\u0010\u001fR\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050\u001b8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u001fR\"\u0010%\u001a\u00020$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/minigame/va/downloadui/MiniGameVADownloadViewModel;", "Lcom/tencent/mobileqq/mvvm/c;", "Lcom/tencent/mobileqq/minigame/va/downloadui/MiniGameDownloadRepository;", "Lcom/tencent/mobileqq/minigame/va/StatusListener;", "", "Lcom/tencent/mobileqq/minigame/va/MiniGameDownloadDataWrapper;", "downloadDatas", "filterBaseVersionApk", "data", "", "addDownloadDataChange", "deleteDownloadDataChange", "gameData", "", "isInValidVersionApp", "postDownloadDataChange", "registerAllListen", "queryDownloadData", "startDownload", "pauseDownload", "cancelDownload", "openVAGame", "deleteVAGame", "onCleared", "onStatusChanged", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroidx/lifecycle/MutableLiveData;", "downloadingDatas", "Landroidx/lifecycle/MutableLiveData;", "getDownloadingDatas", "()Landroidx/lifecycle/MutableLiveData;", "downloadedDatas", "getDownloadedDatas", "curChangePayloadData", "getCurChangePayloadData", "Lcom/tencent/mobileqq/minigame/api/IMiniGameVAService;", "vaService", "Lcom/tencent/mobileqq/minigame/api/IMiniGameVAService;", "getVaService", "()Lcom/tencent/mobileqq/minigame/api/IMiniGameVAService;", "setVaService", "(Lcom/tencent/mobileqq/minigame/api/IMiniGameVAService;)V", "<init>", "()V", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class MiniGameVADownloadViewModel extends com.tencent.mobileqq.mvvm.c<MiniGameDownloadRepository> implements StatusListener {
    private static final String TAG = "MiniGameVADownloadViewModel";
    private final MutableLiveData<MiniGameDownloadDataWrapper> curChangePayloadData;
    private CopyOnWriteArrayList<MiniGameDownloadDataWrapper> downloadDatas;
    private final MutableLiveData<List<MiniGameDownloadDataWrapper>> downloadedDatas;
    private final MutableLiveData<List<MiniGameDownloadDataWrapper>> downloadingDatas;
    private IMiniGameVAService vaService;

    public MiniGameVADownloadViewModel() {
        super(new MiniGameDownloadRepository());
        this.downloadDatas = new CopyOnWriteArrayList<>();
        this.downloadingDatas = new MutableLiveData<>();
        this.downloadedDatas = new MutableLiveData<>();
        this.curChangePayloadData = new MutableLiveData<>();
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IMiniGameVAService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026va, ProcessConstant.MAIN)");
        this.vaService = (IMiniGameVAService) runtimeService;
    }

    private final void addDownloadDataChange(MiniGameDownloadDataWrapper data) {
        this.downloadDatas.add(data);
        this.vaService.registerStatusListener(data.getData().getGameId(), this);
        postDownloadDataChange();
    }

    private final void deleteDownloadDataChange(MiniGameDownloadDataWrapper data) {
        Iterator<MiniGameDownloadDataWrapper> it = this.downloadDatas.iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            } else if (Intrinsics.areEqual(it.next().getData().getGameId(), data.getData().getGameId())) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 >= 0) {
            this.downloadDatas.remove(i3);
            this.vaService.unregisterStatusListener(data.getData().getGameId(), this);
            postDownloadDataChange();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<MiniGameDownloadDataWrapper> filterBaseVersionApk(List<MiniGameDownloadDataWrapper> downloadDatas) {
        Set set;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(downloadDatas);
        List<MiniGameDownloadDataWrapper> list = downloadDatas;
        for (MiniGameDownloadDataWrapper miniGameDownloadDataWrapper : list) {
            if (miniGameDownloadDataWrapper.getDownloadStatus() == 7) {
                for (MiniGameDownloadDataWrapper miniGameDownloadDataWrapper2 : list) {
                    if (miniGameDownloadDataWrapper.getData().getDiffPatchInfo() == null && Intrinsics.areEqual(miniGameDownloadDataWrapper.getData().getGameId(), miniGameDownloadDataWrapper2.getData().getGameId())) {
                        arrayList.add(miniGameDownloadDataWrapper);
                        QLog.i(TAG, 1, "filterBaseVersionApk downloadData:" + miniGameDownloadDataWrapper);
                    }
                }
            }
        }
        set = CollectionsKt___CollectionsKt.toSet(arrayList);
        arrayList2.removeAll(set);
        return downloadDatas;
    }

    private final boolean isInValidVersionApp(MiniGameDownloadDataWrapper gameData) {
        boolean z16 = gameData.getDownloadStatus() == 7 && gameData.getData().getDiffPatchInfo() == null;
        QLog.i(TAG, 1, "gameData:" + gameData + " isInValidVersionApp:" + z16);
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void postDownloadDataChange() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (MiniGameDownloadDataWrapper it : this.downloadDatas) {
            if (it.getDownloadStatus() != 9) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (!isInValidVersionApp(it)) {
                    if (it.getDownloadStatus() != 0) {
                        arrayList.add(it);
                    }
                }
            }
            arrayList2.add(it);
        }
        this.downloadingDatas.postValue(arrayList);
        this.downloadedDatas.postValue(arrayList2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerAllListen() {
        Iterator<T> it = this.downloadDatas.iterator();
        while (it.hasNext()) {
            this.vaService.registerStatusListener(((MiniGameDownloadDataWrapper) it.next()).getData().getGameId(), this);
        }
    }

    public final void cancelDownload(MiniGameDownloadDataWrapper data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.vaService.cancelDownload(data.getData().getGameId());
    }

    public final void deleteVAGame(MiniGameDownloadDataWrapper data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.vaService.uninstallVA(data.getData().getGameId());
    }

    public final MutableLiveData<MiniGameDownloadDataWrapper> getCurChangePayloadData() {
        return this.curChangePayloadData;
    }

    public final MutableLiveData<List<MiniGameDownloadDataWrapper>> getDownloadedDatas() {
        return this.downloadedDatas;
    }

    public final MutableLiveData<List<MiniGameDownloadDataWrapper>> getDownloadingDatas() {
        return this.downloadingDatas;
    }

    public final IMiniGameVAService getVaService() {
        return this.vaService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.mvvm.c, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Iterator<T> it = this.downloadDatas.iterator();
        while (it.hasNext()) {
            this.vaService.unregisterStatusListener(((MiniGameDownloadDataWrapper) it.next()).getData().getGameId(), this);
        }
    }

    @Override // com.tencent.mobileqq.minigame.va.StatusListener
    public void onStatusChanged(MiniGameDownloadDataWrapper data) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(data, "data");
        Iterator<MiniGameDownloadDataWrapper> it = this.downloadDatas.iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            } else if (Intrinsics.areEqual(it.next().getData().getGameId(), data.getData().getGameId())) {
                break;
            } else {
                i3++;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onStatusChanged findIndex:" + i3 + " data:" + data);
        }
        if (i3 < 0 && data.getDownloadStatus() == 1) {
            addDownloadDataChange(data);
            return;
        }
        if (i3 >= 0 && data.getDownloadStatus() == 10) {
            deleteDownloadDataChange(data);
            return;
        }
        if (i3 >= 0) {
            CopyOnWriteArrayList<MiniGameDownloadDataWrapper> copyOnWriteArrayList = this.downloadDatas;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(copyOnWriteArrayList, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (MiniGameDownloadDataWrapper miniGameDownloadDataWrapper : copyOnWriteArrayList) {
                if (Intrinsics.areEqual(miniGameDownloadDataWrapper.getData().getGameId(), data.getData().getGameId())) {
                    miniGameDownloadDataWrapper = data;
                }
                arrayList.add(miniGameDownloadDataWrapper);
            }
            if (data.getDownloadStatus() == 9) {
                postDownloadDataChange();
                return;
            } else {
                this.curChangePayloadData.postValue(data);
                return;
            }
        }
        QLog.e(TAG, 1, "onStatusChanged not found");
    }

    public final void openVAGame(MiniGameDownloadDataWrapper data) {
        Intrinsics.checkNotNullParameter(data, "data");
        IMiniGameVA.DefaultImpls.launchVA$default(this.vaService, data, null, 2, null);
    }

    public final void pauseDownload(MiniGameDownloadDataWrapper data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.vaService.pauseDownload(data.getData().getGameId());
    }

    public final void queryDownloadData() {
        this.vaService.queryExistVAList(new Function2<Boolean, List<? extends MiniGameDownloadDataWrapper>, Unit>() { // from class: com.tencent.mobileqq.minigame.va.downloadui.MiniGameVADownloadViewModel$queryDownloadData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, List<? extends MiniGameDownloadDataWrapper> list) {
                invoke(bool.booleanValue(), (List<MiniGameDownloadDataWrapper>) list);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, List<MiniGameDownloadDataWrapper> list) {
                CopyOnWriteArrayList copyOnWriteArrayList;
                CopyOnWriteArrayList copyOnWriteArrayList2;
                List filterBaseVersionApk;
                QLog.i("MiniGameVADownloadViewModel", 1, "queryExistVAList isSuccess:" + z16 + " data:" + list);
                if (!z16 || list == null) {
                    return;
                }
                copyOnWriteArrayList = MiniGameVADownloadViewModel.this.downloadDatas;
                copyOnWriteArrayList.clear();
                copyOnWriteArrayList2 = MiniGameVADownloadViewModel.this.downloadDatas;
                filterBaseVersionApk = MiniGameVADownloadViewModel.this.filterBaseVersionApk(list);
                copyOnWriteArrayList2.addAll(filterBaseVersionApk);
                MiniGameVADownloadViewModel.this.postDownloadDataChange();
                MiniGameVADownloadViewModel.this.registerAllListen();
            }
        });
    }

    public final void setVaService(IMiniGameVAService iMiniGameVAService) {
        Intrinsics.checkNotNullParameter(iMiniGameVAService, "<set-?>");
        this.vaService = iMiniGameVAService;
    }

    public final void startDownload(MiniGameDownloadDataWrapper data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.vaService.startDownload(data.getData().getGameId(), Boolean.TRUE, null, data.getScene(), true);
    }
}
