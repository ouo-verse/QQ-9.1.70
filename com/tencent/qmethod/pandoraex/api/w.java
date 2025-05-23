package com.tencent.qmethod.pandoraex.api;

import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes22.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    public static final Set<String> f344006a;

    /* renamed from: b, reason: collision with root package name */
    public static final Set<String> f344007b;

    /* renamed from: c, reason: collision with root package name */
    public static final Map<String, Integer> f344008c;

    static {
        HashSet hashSet = new HashSet();
        f344006a = hashSet;
        HashSet hashSet2 = new HashSet();
        f344007b = hashSet2;
        HashMap hashMap = new HashMap();
        f344008c = hashMap;
        hashSet.add("before");
        hashSet.add("back");
        hashSet.add("silence");
        hashSet.add("high_freq");
        hashSet.add("illegal_scene");
        hashSet.add("deny_retry");
        hashSet.add("normal");
        hashSet.add("mod_no_perm");
        hashSet2.add("ban");
        hashSet2.add("memory");
        hashSet2.add(QQPermissionConstants.Permission.STORAGE_GROUP);
        hashSet2.add("normal");
        hashMap.put("ban", -1);
        hashMap.put(QQPermissionConstants.Permission.STORAGE_GROUP, 0);
        hashMap.put("memory", 1);
        hashMap.put("normal", 2);
        hashMap.put("cache_only", 3);
    }
}
