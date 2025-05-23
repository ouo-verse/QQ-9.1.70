package com.tencent.mobileqq.zootopia.download.normal;

import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\u0003\u001a\u00020\u0002H&J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\bH&J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0006H&J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0006H&J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/normal/h;", "", "", "category", "", "url", "Lcom/tencent/mobileqq/zootopia/download/normal/FileDownloadEntity;", "e", "", "d", "a", "data", "", "f", "c", "", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public interface h {
    List<FileDownloadEntity> a();

    void b(int category, String url);

    boolean c(FileDownloadEntity data);

    List<FileDownloadEntity> d(int category);

    FileDownloadEntity e(int category, String url);

    boolean f(FileDownloadEntity data);
}
