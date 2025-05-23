package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProFeedImageEntity;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProFeedSearchInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class af {

    /* renamed from: a, reason: collision with root package name */
    private GProFeedSearchInfo f265659a;

    /* renamed from: b, reason: collision with root package name */
    private el f265660b;

    /* renamed from: c, reason: collision with root package name */
    private List<dp> f265661c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private dp f265662d;

    /* renamed from: e, reason: collision with root package name */
    private final IRecallInfo f265663e;

    public af(GProFeedSearchInfo gProFeedSearchInfo) {
        this.f265659a = gProFeedSearchInfo;
        this.f265660b = new bx(gProFeedSearchInfo.getCreator());
        ArrayList<GProFeedImageEntity> images = gProFeedSearchInfo.getImages();
        if (images != null) {
            Iterator<GProFeedImageEntity> it = images.iterator();
            while (it.hasNext()) {
                this.f265661c.add(new ae(it.next()));
            }
        }
        this.f265662d = new ae(this.f265659a.getVideoCoverUrl());
        this.f265663e = new GProRecallInfoData(this.f265659a.getRecallInfo());
    }
}
