package com.tencent.mobileqq.config.business.qlink;

import com.tencent.freesia.IConfigData;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a implements IConfigData {

    /* renamed from: d, reason: collision with root package name */
    public List<C7474a> f202790d = new ArrayList();

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.config.business.qlink.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C7474a {

        /* renamed from: a, reason: collision with root package name */
        public String f202791a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f202792b = "";

        /* renamed from: c, reason: collision with root package name */
        public List<Integer> f202793c = new ArrayList();

        public String toString() {
            return "BlockConfig{brand='" + this.f202791a + "'model='" + this.f202792b + "', blackSystemVersions=" + this.f202793c + '}';
        }
    }

    public String toString() {
        return "QLinkEntranceConfig{blockConfigList=" + this.f202790d + '}';
    }
}
