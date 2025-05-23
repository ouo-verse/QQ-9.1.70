package com.tencent.mobileqq.zootopia.helper;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ(\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\"\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0007j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001`\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zootopia/helper/SmallHomeHelper;", "", "", "sceneType", "homeownerUin", "", "a", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "b", "<init>", "()V", "SmallHomeSceneType", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SmallHomeHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final SmallHomeHelper f328312a = new SmallHomeHelper();

    /* compiled from: P */
    @Retention(RetentionPolicy.RUNTIME)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0086\u0002\u0018\u00002\u00020\u0001B\u0000\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/zootopia/helper/SmallHomeHelper$SmallHomeSceneType;", "", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public @interface SmallHomeSceneType {
    }

    SmallHomeHelper() {
    }

    public final Map<String, Object> a(@SmallHomeSceneType String sceneType, String homeownerUin) {
        Intrinsics.checkNotNullParameter(sceneType, "sceneType");
        HashMap hashMap = new HashMap();
        hashMap.put("SceneType", sceneType);
        if (homeownerUin != null) {
            hashMap.put("VisitUin", homeownerUin);
        }
        return hashMap;
    }

    public final HashMap<String, Object> b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("NeedUIGuide", 2);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("SceneParamJson", jSONObject.toString());
        return hashMap;
    }
}
