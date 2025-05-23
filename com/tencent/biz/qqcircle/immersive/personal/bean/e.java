package com.tencent.biz.qqcircle.immersive.personal.bean;

import androidx.annotation.Nullable;
import feedcloud.FeedCloudMeta$PushBoxViewInfo;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StPushList;
import qqcircle.QQCircleFeedBase$StFeedBusiReqData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    protected e30.b f88462a;

    /* renamed from: b, reason: collision with root package name */
    protected String f88463b;

    /* renamed from: c, reason: collision with root package name */
    private FeedCloudMeta$PushBoxViewInfo f88464c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public QFSCheckBoxStatus f88465d;

    public e(e30.b bVar) {
        FeedCloudMeta$StPushList feedCloudMeta$StPushList;
        this.f88463b = "";
        this.f88462a = bVar;
        if (bVar != null && bVar.g() != null) {
            this.f88463b = bVar.g().cover.picUrl.get();
            QQCircleFeedBase$StFeedBusiReqData qQCircleFeedBase$StFeedBusiReqData = (QQCircleFeedBase$StFeedBusiReqData) bVar.b("DITTO_FEED_BUSI_REQ_DATA");
            if (qQCircleFeedBase$StFeedBusiReqData != null && (feedCloudMeta$StPushList = qQCircleFeedBase$StFeedBusiReqData.pushList) != null) {
                this.f88464c = feedCloudMeta$StPushList.pushBoxViewInfo;
            }
        }
    }

    public String a() {
        return this.f88463b;
    }

    public FeedCloudMeta$StFeed b() {
        e30.b bVar = this.f88462a;
        if (bVar == null) {
            return null;
        }
        return bVar.g();
    }

    public e30.b c() {
        return this.f88462a;
    }

    public String d() {
        if (b() == null) {
            return "";
        }
        return b().f398449id.get();
    }

    public int e() {
        if (b() == null) {
            return 0;
        }
        return b().type.get();
    }

    public FeedCloudMeta$PushBoxViewInfo f() {
        return this.f88464c;
    }

    public void g(String str) {
        this.f88463b = str;
    }

    public void h(FeedCloudMeta$PushBoxViewInfo feedCloudMeta$PushBoxViewInfo) {
        this.f88464c = feedCloudMeta$PushBoxViewInfo;
    }
}
