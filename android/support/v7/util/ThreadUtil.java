package android.support.v7.util;

import android.support.v7.util.TileList;

/* compiled from: P */
/* loaded from: classes.dex */
interface ThreadUtil<T> {

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface BackgroundCallback<T> {
        void loadTile(int i3, int i16);

        void recycleTile(TileList.Tile<T> tile);

        void refresh(int i3);

        void updateRange(int i3, int i16, int i17, int i18, int i19);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface MainThreadCallback<T> {
        void addTile(int i3, TileList.Tile<T> tile);

        void removeTile(int i3, int i16);

        void updateItemCount(int i3, int i16);
    }

    BackgroundCallback<T> getBackgroundProxy(BackgroundCallback<T> backgroundCallback);

    MainThreadCallback<T> getMainThreadProxy(MainThreadCallback<T> mainThreadCallback);
}
