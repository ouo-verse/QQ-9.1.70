package com.qzone.publish.business.task;

import com.qzone.publish.ui.model.MediaWrapper;
import cooperation.qzone.model.BusinessAlbumInfo;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public List<MediaWrapper> f51180a;

    /* renamed from: b, reason: collision with root package name */
    public BusinessAlbumInfo f51181b;

    /* renamed from: c, reason: collision with root package name */
    public String f51182c;

    /* renamed from: d, reason: collision with root package name */
    public long f51183d;

    /* renamed from: e, reason: collision with root package name */
    public Map<String, byte[]> f51184e;

    public b(List<MediaWrapper> list, String str, long j3, BusinessAlbumInfo businessAlbumInfo, Map<String, byte[]> map) {
        this.f51180a = list;
        this.f51182c = str;
        this.f51183d = j3;
        this.f51181b = businessAlbumInfo;
        this.f51184e = map;
    }

    public List<MediaWrapper> a() {
        return this.f51180a;
    }
}
