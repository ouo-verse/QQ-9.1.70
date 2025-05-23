package com.qzone.album.business.photolist.ui;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.qzone.album.data.model.AlbumCacheData;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class AbsQZoneAlbumHeaderView extends FrameLayout {

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface a {
    }

    public AbsQZoneAlbumHeaderView(Context context) {
        super(context);
    }

    public abstract void setAlbumCacheData(AlbumCacheData albumCacheData);

    public abstract void setCoverImageUrl(String str);

    public abstract void setCoverText(String str);

    public abstract void setEditButtonClickListener(View.OnClickListener onClickListener);

    public abstract void setOnUploadPhotoButtonClickListener(View.OnClickListener onClickListener);

    public abstract void setOnVisitorButtonClickListener(a aVar);

    public abstract void setUploadPhotoButtonVisible(boolean z16);

    @Override // android.view.View
    public abstract void setVisibility(int i3);

    public abstract void setVisitorsCount(int i3, AlbumCacheData albumCacheData);
}
