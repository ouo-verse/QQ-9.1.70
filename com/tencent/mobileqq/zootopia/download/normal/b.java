package com.tencent.mobileqq.zootopia.download.normal;

import android.text.TextUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b+\u0010,J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0015\u001a\u00020\u000fH\u0002J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0006H\u0002J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0006H\u0002J\b\u0010\u001a\u001a\u00020\u000fH\u0002J\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u001c2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u001cH\u0016J\u0010\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J\u0010\u0010 \u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J\u000e\u0010!\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0006J\u0018\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010$\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010#R\u0016\u0010&\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010%R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00060'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010(R\u0014\u0010*\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010%\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/normal/b;", "Lcom/tencent/mobileqq/zootopia/download/normal/h;", "", "category", "", "url", "Lcom/tencent/mobileqq/zootopia/download/normal/FileDownloadEntity;", "downloadEntity", "", "g", "left", "right", tl.h.F, "oldData", "newData", "", "r", "data", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "j", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "entity", "k", "o", "i", "e", "", "d", "a", "f", "c", DomainData.DOMAIN_NAME, "b", "Lcom/tencent/mobileqq/zootopia/download/normal/h;", "dbHelper", "Z", "isInitDBData", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "dbDataList", "enableLoadAllDBData", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class b implements h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final h dbHelper;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isInitDBData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final CopyOnWriteArrayList<FileDownloadEntity> dbDataList = new CopyOnWriteArrayList<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean enableLoadAllDBData;

    public b() {
        boolean enableFileManagerLoadAllDBData = ZPlanQQMC.INSTANCE.enableFileManagerLoadAllDBData();
        this.enableLoadAllDBData = enableFileManagerLoadAllDBData;
        this.dbHelper = new a();
        QLog.i("FileDownloadDBProxy", 1, "enableLoadAllDBData:" + enableFileManagerLoadAllDBData);
    }

    private final boolean g(int category, String url, FileDownloadEntity downloadEntity) {
        return category == downloadEntity.category && Intrinsics.areEqual(url, downloadEntity.url);
    }

    private final boolean h(FileDownloadEntity left, FileDownloadEntity right) {
        int i3 = left.category;
        String str = left.url;
        Intrinsics.checkNotNullExpressionValue(str, "left.url");
        return g(i3, str, right);
    }

    private final void j(int category, String url) {
        i();
        if (this.enableLoadAllDBData) {
            p();
        } else {
            q(category, url);
        }
    }

    private final void k(FileDownloadEntity entity) {
        if (o(entity)) {
            entity.downloadStatus = 8;
        }
    }

    private final boolean l(FileDownloadEntity data) {
        if (!this.dbHelper.f(data)) {
            return false;
        }
        this.dbDataList.add(data);
        return true;
    }

    private final boolean m(FileDownloadEntity data) {
        return this.dbHelper.c(data);
    }

    private final boolean o(FileDownloadEntity entity) {
        int i3 = entity.downloadStatus;
        return i3 == 2 || i3 == 1 || i3 == 3;
    }

    private final void p() {
        if (this.isInitDBData) {
            return;
        }
        this.isInitDBData = true;
        QLog.i("FileDownloadDBProxy", 1, "initFileDownloadDBData BEGIN");
        long currentTimeMillis = System.currentTimeMillis();
        CopyOnWriteArrayList<FileDownloadEntity> copyOnWriteArrayList = this.dbDataList;
        List<FileDownloadEntity> a16 = this.dbHelper.a();
        Iterator<T> it = a16.iterator();
        while (it.hasNext()) {
            k((FileDownloadEntity) it.next());
        }
        copyOnWriteArrayList.addAll(a16);
        QLog.i("FileDownloadDBProxy", 1, "initFileDownloadDBData, totalSize= " + this.dbDataList.size() + ", costTime= " + (System.currentTimeMillis() - currentTimeMillis));
    }

    private final void q(int category, String url) {
        FileDownloadEntity fileDownloadEntity;
        Object obj = null;
        if (TextUtils.isEmpty(url)) {
            Iterator<T> it = this.dbDataList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((FileDownloadEntity) next).category == category) {
                    obj = next;
                    break;
                }
            }
            fileDownloadEntity = (FileDownloadEntity) obj;
        } else {
            Iterator<T> it5 = this.dbDataList.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                Object next2 = it5.next();
                FileDownloadEntity it6 = (FileDownloadEntity) next2;
                Intrinsics.checkNotNullExpressionValue(it6, "it");
                if (g(category, url, it6)) {
                    obj = next2;
                    break;
                }
            }
            fileDownloadEntity = (FileDownloadEntity) obj;
        }
        if (fileDownloadEntity != null) {
            return;
        }
        if (TextUtils.isEmpty(url)) {
            CopyOnWriteArrayList<FileDownloadEntity> copyOnWriteArrayList = this.dbDataList;
            List<FileDownloadEntity> d16 = this.dbHelper.d(category);
            Iterator<T> it7 = d16.iterator();
            while (it7.hasNext()) {
                k((FileDownloadEntity) it7.next());
            }
            copyOnWriteArrayList.addAll(d16);
            return;
        }
        FileDownloadEntity e16 = this.dbHelper.e(category, url);
        if (e16 != null) {
            k(e16);
            this.dbDataList.add(e16);
        }
    }

    private final void r(FileDownloadEntity oldData, FileDownloadEntity newData) {
        if (Intrinsics.areEqual(oldData, newData)) {
            return;
        }
        oldData.url = newData.url;
        oldData.downloadStatus = newData.downloadStatus;
        oldData.category = newData.category;
        oldData.filePath = newData.filePath;
        oldData.progress = newData.progress;
        oldData.size = newData.size;
    }

    @Override // com.tencent.mobileqq.zootopia.download.normal.h
    public List<FileDownloadEntity> a() {
        if (this.enableLoadAllDBData) {
            j(-1, "");
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.dbDataList);
            return arrayList;
        }
        List<FileDownloadEntity> a16 = this.dbHelper.a();
        Iterator<T> it = a16.iterator();
        while (it.hasNext()) {
            k((FileDownloadEntity) it.next());
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(a16);
        return arrayList2;
    }

    @Override // com.tencent.mobileqq.zootopia.download.normal.h
    public void b(int category, String url) {
        Set set;
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            j(category, url);
            CopyOnWriteArrayList<FileDownloadEntity> copyOnWriteArrayList = this.dbDataList;
            ArrayList arrayList = new ArrayList();
            for (Object obj : copyOnWriteArrayList) {
                FileDownloadEntity it = (FileDownloadEntity) obj;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (g(category, url, it)) {
                    arrayList.add(obj);
                }
            }
            CopyOnWriteArrayList<FileDownloadEntity> copyOnWriteArrayList2 = this.dbDataList;
            set = CollectionsKt___CollectionsKt.toSet(arrayList);
            copyOnWriteArrayList2.removeAll(set);
            this.dbHelper.b(category, url);
        } catch (Exception e16) {
            QLog.e("FileDownloadDBProxy", 1, "deleteInfo error - " + url, e16);
        }
    }

    @Override // com.tencent.mobileqq.zootopia.download.normal.h
    public boolean c(FileDownloadEntity data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return n(data);
    }

    @Override // com.tencent.mobileqq.zootopia.download.normal.h
    public List<FileDownloadEntity> d(int category) {
        j(category, "");
        CopyOnWriteArrayList<FileDownloadEntity> copyOnWriteArrayList = this.dbDataList;
        ArrayList arrayList = new ArrayList();
        for (Object obj : copyOnWriteArrayList) {
            if (((FileDownloadEntity) obj).category == category) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.zootopia.download.normal.h
    public FileDownloadEntity e(int category, String url) {
        Object obj;
        Intrinsics.checkNotNullParameter(url, "url");
        j(category, url);
        Iterator<T> it = this.dbDataList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            FileDownloadEntity it5 = (FileDownloadEntity) obj;
            Intrinsics.checkNotNullExpressionValue(it5, "it");
            if (g(category, url, it5)) {
                break;
            }
        }
        return (FileDownloadEntity) obj;
    }

    @Override // com.tencent.mobileqq.zootopia.download.normal.h
    public boolean f(FileDownloadEntity data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return n(data);
    }

    public final boolean n(FileDownloadEntity data) {
        Object obj;
        Intrinsics.checkNotNullParameter(data, "data");
        int i3 = data.category;
        String str = data.url;
        Intrinsics.checkNotNullExpressionValue(str, "data.url");
        j(i3, str);
        Iterator<T> it = this.dbDataList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            FileDownloadEntity it5 = (FileDownloadEntity) obj;
            Intrinsics.checkNotNullExpressionValue(it5, "it");
            if (h(data, it5)) {
                break;
            }
        }
        FileDownloadEntity fileDownloadEntity = (FileDownloadEntity) obj;
        if (fileDownloadEntity != null) {
            r(fileDownloadEntity, data);
            return m(fileDownloadEntity);
        }
        return l(data);
    }

    private final void i() {
    }
}
