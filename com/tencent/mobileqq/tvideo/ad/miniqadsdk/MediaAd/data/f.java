package com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data;

import android.app.Activity;
import com.tencent.tvideo.protocol.pb.ADVideoInfo;
import com.tencent.tvideo.protocol.pb.RewardAdSceneType;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes19.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private RewardAdSceneType f303610a;

    /* renamed from: b, reason: collision with root package name */
    private Activity f303611b;

    /* renamed from: c, reason: collision with root package name */
    private ADVideoInfo f303612c;

    /* renamed from: d, reason: collision with root package name */
    private String f303613d;

    /* renamed from: e, reason: collision with root package name */
    private Map<String, Object> f303614e;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private RewardAdSceneType f303615a;

        /* renamed from: b, reason: collision with root package name */
        private Activity f303616b;

        /* renamed from: c, reason: collision with root package name */
        private ADVideoInfo f303617c;

        /* renamed from: d, reason: collision with root package name */
        private String f303618d;

        /* renamed from: e, reason: collision with root package name */
        private Map<String, Object> f303619e;

        public a a(Activity activity) {
            this.f303616b = activity;
            return this;
        }

        public f b() {
            f fVar = new f();
            fVar.f303610a = this.f303615a;
            fVar.f303611b = this.f303616b;
            fVar.f303612c = this.f303617c;
            fVar.f303613d = this.f303618d;
            fVar.f303614e = this.f303619e;
            return fVar;
        }

        public a c(Map<String, Object> map) {
            this.f303619e = map;
            return this;
        }

        public a d(String str) {
            this.f303618d = str;
            return this;
        }

        public a e(RewardAdSceneType rewardAdSceneType) {
            this.f303615a = rewardAdSceneType;
            return this;
        }

        public a f(ADVideoInfo aDVideoInfo) {
            this.f303617c = aDVideoInfo;
            return this;
        }
    }

    public Activity f() {
        return this.f303611b;
    }

    public Map<String, Object> g() {
        return this.f303614e;
    }

    public String h() {
        return this.f303613d;
    }

    public RewardAdSceneType i() {
        return this.f303610a;
    }

    public ADVideoInfo j() {
        return this.f303612c;
    }
}
