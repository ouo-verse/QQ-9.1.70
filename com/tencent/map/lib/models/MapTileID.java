package com.tencent.map.lib.models;

import android.support.annotation.Keep;

/* compiled from: P */
@Keep
/* loaded from: classes9.dex */
public class MapTileID {
    private int dataSource;
    private int priority;
    private int tileTag;
    private String url;

    /* renamed from: x, reason: collision with root package name */
    private int f147590x;

    /* renamed from: y, reason: collision with root package name */
    private int f147591y;

    /* renamed from: z, reason: collision with root package name */
    private int f147592z;

    public DataSource getDataSource() {
        return DataSource.get(this.dataSource);
    }

    public DownloadPriority getPriority() {
        return DownloadPriority.get(this.priority);
    }

    public int getTileTag() {
        return this.tileTag;
    }

    public String getUrl() {
        return this.url;
    }

    public int getX() {
        return this.f147590x;
    }

    public int getY() {
        return this.f147591y;
    }

    public int getZ() {
        return this.f147592z;
    }

    public String toString() {
        return "MapTileID{x=" + this.f147590x + ", y=" + this.f147591y + ", z=" + this.f147592z + ", url='" + this.url + "', priority=" + this.priority + ", dataSource=" + this.dataSource + ", tileTag=" + this.tileTag + '}';
    }
}
