package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import mqq.app.api.IRuntimeService;

@Service(process = {"all"})
/* loaded from: classes12.dex */
public interface IQQFavProxy extends IRuntimeService {
    public static final String DELETE_FAVIDS = "delete_favids";

    /* loaded from: classes12.dex */
    public static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        public long f207018a = 0;

        /* renamed from: b, reason: collision with root package name */
        public List<FavFileInfo> f207019b;

        public abstract void a(int i3, List<FavFileInfo> list, Bundle bundle);
    }

    /* loaded from: classes12.dex */
    public interface b {
        void a(long j3, int i3, String str);

        void onFileDownloaded(long j3, String str);

        void onFileListRefreshed(boolean z16, Bundle bundle);
    }

    void addListener(b bVar);

    void cancelGetFileList(long j3);

    void deleteListener(b bVar);

    void downloadThumb(FavFileInfo favFileInfo, int i3);

    void getFileList(long j3, boolean z16, Bundle bundle, a aVar);

    long getGettedPartList(long j3, List<FavFileInfo> list);

    void onFileDownloaded(long j3, String str);

    void onFileListRefreshed(boolean z16, Bundle bundle);

    void onFileThumbUpdated(long j3, String str, int i3);

    void onGettedFileList(long j3, List<FavFileInfo> list, Bundle bundle);

    boolean refreshList(Bundle bundle);

    void sendFavFiles(List<FavFileInfo> list, String str, String str2, int i3, Bundle bundle);
}
