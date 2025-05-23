package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProFeedSearchInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildSearchInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProLiveSearchInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProScheduleSearchInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUnionSearchResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class cc {

    /* renamed from: a, reason: collision with root package name */
    private GProUnionSearchResult f265804a;

    /* renamed from: b, reason: collision with root package name */
    private List<IGProSearchGuildInfo> f265805b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private List<Object> f265806c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private List<Object> f265807d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private List<Object> f265808e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private List<IGProSearchGuildInfo> f265809f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    private eq f265810g;

    public cc(GProUnionSearchResult gProUnionSearchResult) {
        this.f265804a = gProUnionSearchResult;
        if (gProUnionSearchResult.getGuildInfoList() != null) {
            Iterator<GProGuildSearchInfo> it = this.f265804a.getGuildInfoList().iterator();
            while (it.hasNext()) {
                this.f265805b.add(new GProGuildSearchDataInfo(it.next()));
            }
        }
        if (this.f265804a.getFeedInfoList() != null) {
            Iterator<GProFeedSearchInfo> it5 = this.f265804a.getFeedInfoList().iterator();
            while (it5.hasNext()) {
                this.f265806c.add(new af(it5.next()));
            }
        }
        if (this.f265804a.getLiveInfoList() != null) {
            Iterator<GProLiveSearchInfo> it6 = this.f265804a.getLiveInfoList().iterator();
            while (it6.hasNext()) {
                this.f265807d.add(new bb(it6.next()));
            }
        }
        if (this.f265804a.getScheduleInfoList() != null) {
            Iterator<GProScheduleSearchInfo> it7 = this.f265804a.getScheduleInfoList().iterator();
            while (it7.hasNext()) {
                this.f265808e.add(new bw(it7.next()));
            }
        }
        if (this.f265804a.getGuildRcdInfoList() != null) {
            Iterator<GProGuildSearchInfo> it8 = this.f265804a.getGuildRcdInfoList().iterator();
            while (it8.hasNext()) {
                this.f265809f.add(new GProGuildSearchDataInfo(it8.next()));
            }
        }
        this.f265810g = new cb(this.f265804a.getSuggestedContent());
    }
}
