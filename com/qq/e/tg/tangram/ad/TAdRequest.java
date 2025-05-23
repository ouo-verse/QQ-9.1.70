package com.qq.e.tg.tangram.ad;

import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.util.StringUtil;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TAdRequest {
    public int adCount;
    public int adType;
    public String appId;
    public String ext;
    public LoadAdParams loadAdParams;
    public long loadDelay;
    public String posId;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private String f40878a;

        /* renamed from: b, reason: collision with root package name */
        private String f40879b;

        /* renamed from: c, reason: collision with root package name */
        private long f40880c;

        /* renamed from: d, reason: collision with root package name */
        private int f40881d = 1;

        /* renamed from: e, reason: collision with root package name */
        private String f40882e;

        /* renamed from: f, reason: collision with root package name */
        private int f40883f;

        /* renamed from: g, reason: collision with root package name */
        private LoadAdParams f40884g;

        public TAdRequest build() {
            return new TAdRequest(this);
        }

        public Builder setAdCount(int i3) {
            this.f40881d = i3;
            return this;
        }

        public Builder setAdType(int i3) {
            this.f40883f = i3;
            return this;
        }

        public Builder setAppId(String str) {
            this.f40878a = str;
            return this;
        }

        public Builder setExtData(String str) {
            this.f40882e = str;
            return this;
        }

        public Builder setLoadAdParams(LoadAdParams loadAdParams) {
            this.f40884g = loadAdParams;
            return this;
        }

        public Builder setLoadDelay(long j3) {
            this.f40880c = j3;
            return this;
        }

        public Builder setPosId(String str) {
            this.f40879b = str;
            return this;
        }
    }

    TAdRequest(Builder builder) {
        this.appId = builder.f40878a;
        this.posId = builder.f40879b;
        this.loadDelay = builder.f40880c;
        this.adCount = builder.f40881d;
        this.ext = builder.f40882e;
        this.adType = builder.f40883f;
        this.loadAdParams = builder.f40884g;
    }

    public boolean isValid() {
        if (!StringUtil.isEmpty(this.appId) && !StringUtil.isEmpty(this.posId)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "TAdRequest{super='" + super.toString() + "', appId=" + this.appId + ", posId=" + this.posId + ", loadDelay='" + this.loadDelay + "', adCount=" + this.adCount + "', ext=" + this.ext + '}';
    }
}
