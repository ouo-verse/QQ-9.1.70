package com.tencent.mobileqq.zootopia.download.db;

import com.tencent.mobileqq.z1.download.db.ZootopiaDownloadEntity;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003H&J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/db/b;", "", "", "Lcom/tencent/mobileqq/z1/download/db/ZootopiaDownloadEntity;", "a", "data", "", "d", "c", "", "id", "", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public interface b {
    List<ZootopiaDownloadEntity> a();

    void b(String id5);

    boolean c(ZootopiaDownloadEntity data);

    boolean d(ZootopiaDownloadEntity data);
}
