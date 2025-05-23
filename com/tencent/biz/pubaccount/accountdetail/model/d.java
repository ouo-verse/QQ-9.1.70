package com.tencent.biz.pubaccount.accountdetail.model;

import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import java.util.HashMap;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rRJ\u0010\u000b\u001a2\u0012\u0004\u0012\u00020\u0003\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u00040\u0002j\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0004`\u00068\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/biz/pubaccount/accountdetail/model/d;", "", "Ljava/util/HashMap;", "", "Ljava/lang/Class;", "Lcom/tencent/biz/pubaccount/accountdetail/model/c;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "a", "()Ljava/util/HashMap;", "businessConfigItemMap", "<init>", "()V", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f79120a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/PublicAccount/Inject_PublicAccountDataCardItemConfigMap.yml", version = 1)
    private static final HashMap<String, Class<? extends c>> businessConfigItemMap;

    static {
        HashMap<String, Class<? extends c>> hashMap = new HashMap<>();
        businessConfigItemMap = hashMap;
        hashMap.put(IPublicAccountUtil.UIN_FOR_HEALTH, m.class);
    }

    d() {
    }

    public final HashMap<String, Class<? extends c>> a() {
        return businessConfigItemMap;
    }
}
