package com.tencent.qqlive.module.videoreport;

import java.util.Map;

/* loaded from: classes22.dex */
public class PageParams {
    private Map<String, ?> mBasicParams;
    private Map<String, ?> mRefElementParams;
    private Map<String, ?> mRootRefElementParams;

    /* loaded from: classes22.dex */
    public static class Builder {
        private Map<String, ?> mBasicParams;
        private Map<String, ?> mRefElementParams;
        private Map<String, ?> mRootRefElementParams;

        public PageParams build() {
            return new PageParams(this);
        }

        public Builder setBasicParams(Map<String, ?> map) {
            this.mBasicParams = map;
            return this;
        }

        public Builder setRefElementParams(Map<String, ?> map) {
            this.mRefElementParams = map;
            return this;
        }

        public Builder setRootRefElementParams(Map<String, ?> map) {
            this.mRootRefElementParams = map;
            return this;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public Map<String, ?> getBasicParams() {
        return this.mBasicParams;
    }

    public Map<String, ?> getRefElementParams() {
        return this.mRefElementParams;
    }

    public Map<String, ?> getRootRefElementParams() {
        return this.mRootRefElementParams;
    }

    public PageParams(Map<String, ?> map) {
        this.mBasicParams = map;
    }

    PageParams(Builder builder) {
        this.mBasicParams = builder.mBasicParams;
        this.mRefElementParams = builder.mRefElementParams;
        this.mRootRefElementParams = builder.mRootRefElementParams;
    }
}
