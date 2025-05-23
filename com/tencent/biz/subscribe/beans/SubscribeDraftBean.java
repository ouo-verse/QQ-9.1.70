package com.tencent.biz.subscribe.beans;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import android.support.annotation.NonNull;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SubscribeDraftBean implements Serializable, Comparable<SubscribeDraftBean> {
    public static int TYPE_IMAGES = 2;
    public static int TYPE_VIDEO = 1;
    private static final long serialVersionUID = -7113155010157016109L;
    private int height;
    private String mCoverUrl;
    private String mDescribe;
    private String mDescribeSource;
    private transient CertifiedAccountMeta$StFeed mDraftFeed;
    private long mDraftId;
    private int mDraftType = TYPE_VIDEO;
    private long mDuration;
    private String mTitle;
    private int width;

    public String getCoverUrl() {
        return this.mCoverUrl;
    }

    public String getDescirbe() {
        return this.mDescribe;
    }

    public String getDescirbeSource() {
        return this.mDescribeSource;
    }

    public int getDrafTtype() {
        return this.mDraftType;
    }

    public long getDraftId() {
        return this.mDraftId;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public int getHeight() {
        return this.height;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public int getWidth() {
        return this.width;
    }

    public SubscribeDraftBean setCoverUrl(String str) {
        this.mCoverUrl = str;
        return this;
    }

    public SubscribeDraftBean setDescirbe(String str) {
        this.mDescribe = str;
        return this;
    }

    public void setDescribeSource(String str) {
        this.mDescribeSource = str;
    }

    public SubscribeDraftBean setDrafTtype(int i3) {
        this.mDraftType = i3;
        return this;
    }

    public SubscribeDraftBean setDraftId(long j3) {
        this.mDraftId = j3;
        return this;
    }

    public void setDuration(long j3) {
        this.mDuration = j3;
    }

    public void setHeight(int i3) {
        this.height = i3;
    }

    public SubscribeDraftBean setTitle(String str) {
        this.mTitle = str;
        return this;
    }

    public void setWidth(int i3) {
        this.width = i3;
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull SubscribeDraftBean subscribeDraftBean) {
        return (int) (subscribeDraftBean.getDraftId() - getDraftId());
    }
}
