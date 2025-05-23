package com.tencent.mobileqq.wink.picker.report;

import com.tencent.mobileqq.wink.picker.MediaType;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes21.dex */
public class AlbumSelectionData {

    /* renamed from: b, reason: collision with root package name */
    private static volatile AlbumSelectionData f325259b;

    /* renamed from: a, reason: collision with root package name */
    private HashMap<MediaType, ArrayList<Long>> f325260a;

    AlbumSelectionData() {
        d();
    }

    public static void a() {
        f325259b = null;
    }

    public static AlbumSelectionData b() {
        if (f325259b == null) {
            synchronized (AlbumSelectionData.class) {
                if (f325259b == null) {
                    f325259b = new AlbumSelectionData();
                }
            }
        }
        return f325259b;
    }

    public HashMap<MediaType, ArrayList<Long>> c() {
        return this.f325260a;
    }

    public void d() {
        this.f325260a = new HashMap<MediaType, ArrayList<Long>>() { // from class: com.tencent.mobileqq.wink.picker.report.AlbumSelectionData.1
            {
                put(MediaType.LOCAL_ALL, new ArrayList());
                put(MediaType.LOCAL_IMAGE, new ArrayList());
                put(MediaType.LOCAL_VIDEO, new ArrayList());
            }
        };
    }
}
