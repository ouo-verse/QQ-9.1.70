package com.tencent.mobileqq.zootopia.download.db;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.z1.download.db.ZootopiaDownloadEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b \u0010!J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0002H\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u000eJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013H\u0016J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u000e\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u0014\u0010\u001a\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u001bR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/db/ZootopiaDownloadDBProxy;", "Lcom/tencent/mobileqq/zootopia/download/db/b;", "Lcom/tencent/mobileqq/z1/download/db/ZootopiaDownloadEntity;", "oldData", "newData", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "data", "", h.F, "g", "f", "entity", "j", "", "id", "k", "l", "e", "", "a", "d", "c", "i", "b", "Lcom/tencent/mobileqq/zootopia/download/db/b;", "dbHelper", "Z", "isInitDBData", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "dbDataList", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaDownloadDBProxy implements b {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isInitDBData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final CopyOnWriteArrayList<ZootopiaDownloadEntity> dbDataList = new CopyOnWriteArrayList<>();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final b dbHelper = new c();

    private final void f() {
        if (this.isInitDBData) {
            return;
        }
        this.isInitDBData = true;
        this.dbDataList.clear();
        CopyOnWriteArrayList<ZootopiaDownloadEntity> copyOnWriteArrayList = this.dbDataList;
        List<ZootopiaDownloadEntity> a16 = this.dbHelper.a();
        for (ZootopiaDownloadEntity zootopiaDownloadEntity : a16) {
            if (j(zootopiaDownloadEntity)) {
                zootopiaDownloadEntity.downloadStatus = 8;
            }
        }
        copyOnWriteArrayList.addAll(a16);
    }

    private final boolean g(ZootopiaDownloadEntity data) {
        if (!this.dbHelper.d(data)) {
            return false;
        }
        this.dbDataList.add(data);
        return true;
    }

    private final boolean h(ZootopiaDownloadEntity data) {
        return this.dbHelper.c(data);
    }

    private final boolean j(ZootopiaDownloadEntity entity) {
        int i3 = entity.downloadStatus;
        return i3 == 2 || i3 == 1 || i3 == 3;
    }

    private final void m(ZootopiaDownloadEntity oldData, ZootopiaDownloadEntity newData) {
        if (Intrinsics.areEqual(oldData, newData)) {
            return;
        }
        oldData.zootopiaId = newData.zootopiaId;
        oldData.type = newData.type;
        oldData.title = newData.title;
        oldData.cover = newData.cover;
        oldData.buttonText = newData.buttonText;
        oldData.typeIcon = newData.typeIcon;
        oldData.typeName = newData.typeName;
        oldData.url = newData.url;
        oldData.version = newData.version;
        oldData.filePath = newData.filePath;
        oldData.downloadStatus = newData.downloadStatus;
        oldData.size = newData.size;
        String str = newData.md5;
        if (str == null) {
            str = "";
        }
        oldData.md5 = str;
        String str2 = newData.pakMd5;
        oldData.pakMd5 = str2 != null ? str2 : "";
        oldData.packType = newData.packType;
        oldData.projectName = newData.projectName;
        oldData.icon = newData.icon;
        oldData.scriptType = newData.scriptType;
        oldData.runScript = newData.runScript;
        oldData.sceneType = newData.sceneType;
        oldData.showGameHealthyLoading = newData.showGameHealthyLoading;
        oldData.progress = newData.progress;
        oldData.completeTime = newData.completeTime;
        oldData.startTime = newData.startTime;
        oldData.isAutoDownload = newData.isAutoDownload;
        oldData.isUpdate = newData.isUpdate;
        oldData.isSilentDownload = newData.isSilentDownload;
        oldData.needNotification = newData.needNotification;
        oldData.loadingBackgroundMaterialBytes = newData.loadingBackgroundMaterialBytes;
        oldData.isUseNewLoading = newData.isUseNewLoading;
        oldData.isDiffUpdate = newData.isDiffUpdate;
        oldData.diffPatchInfoBytes = newData.diffPatchInfoBytes;
    }

    @Override // com.tencent.mobileqq.zootopia.download.db.b
    public List<ZootopiaDownloadEntity> a() {
        f();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.dbDataList);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.zootopia.download.db.b
    public void b(final String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        f();
        CollectionsKt__MutableCollectionsKt.removeAll((List) this.dbDataList, (Function1) new Function1<ZootopiaDownloadEntity, Boolean>() { // from class: com.tencent.mobileqq.zootopia.download.db.ZootopiaDownloadDBProxy$deleteInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(ZootopiaDownloadEntity zootopiaDownloadEntity) {
                return Boolean.valueOf(Intrinsics.areEqual(zootopiaDownloadEntity.zootopiaId, id5));
            }
        });
        this.dbHelper.b(id5);
    }

    @Override // com.tencent.mobileqq.zootopia.download.db.b
    public boolean c(ZootopiaDownloadEntity data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return i(data);
    }

    @Override // com.tencent.mobileqq.zootopia.download.db.b
    public boolean d(ZootopiaDownloadEntity data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return i(data);
    }

    public final ZootopiaDownloadEntity e(String id5) {
        Object obj;
        Intrinsics.checkNotNullParameter(id5, "id");
        List<ZootopiaDownloadEntity> a16 = this.dbHelper.a();
        for (ZootopiaDownloadEntity zootopiaDownloadEntity : a16) {
            if (j(zootopiaDownloadEntity)) {
                zootopiaDownloadEntity.downloadStatus = 8;
            }
        }
        Iterator<T> it = a16.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((ZootopiaDownloadEntity) obj).zootopiaId, id5)) {
                break;
            }
        }
        return (ZootopiaDownloadEntity) obj;
    }

    public final boolean i(ZootopiaDownloadEntity data) {
        Object obj;
        Intrinsics.checkNotNullParameter(data, "data");
        f();
        Iterator<T> it = this.dbDataList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(data.zootopiaId, ((ZootopiaDownloadEntity) obj).zootopiaId)) {
                break;
            }
        }
        ZootopiaDownloadEntity zootopiaDownloadEntity = (ZootopiaDownloadEntity) obj;
        if (zootopiaDownloadEntity != null) {
            m(zootopiaDownloadEntity, data);
            return h(zootopiaDownloadEntity);
        }
        return g(data);
    }

    public ZootopiaDownloadEntity k(String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        f();
        return l(id5);
    }

    public final ZootopiaDownloadEntity l(String id5) {
        Object obj;
        Intrinsics.checkNotNullParameter(id5, "id");
        Iterator<T> it = this.dbDataList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((ZootopiaDownloadEntity) obj).zootopiaId, id5)) {
                break;
            }
        }
        return (ZootopiaDownloadEntity) obj;
    }
}
