package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.repo;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonAlbumInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005\u00a2\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/repo/QZAlbumListRepo;", "", "()V", "allAlbumList", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonAlbumInfo;", "getAllAlbumList", "()Ljava/util/List;", "setAllAlbumList", "(Ljava/util/List;)V", "Companion", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public abstract class QZAlbumListRepo {
    public static final int LOAD_TYPE_DOWN = 2;
    public static final int LOAD_TYPE_REFRESH = 1;
    public static final int LOAD_TYPE_UP = 3;
    public static final String TAG = "QZAlbumListRepo";
    private List<CommonAlbumInfo> allAlbumList = new ArrayList();
    public static final int $stable = 8;

    public final List<CommonAlbumInfo> getAllAlbumList() {
        return this.allAlbumList;
    }

    public final void setAllAlbumList(List<CommonAlbumInfo> list) {
        this.allAlbumList = list;
    }
}
