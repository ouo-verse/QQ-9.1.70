package com.tencent.mobileqq.lightquic;

import com.tencent.lightquic.api.LightQUICEngineConfig;
import com.tencent.lightquic.api.LightQUICSDKMgr;
import com.tencent.lightquic.api.LightQUICSceneId;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0003\u001a\u00020\u0002R \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/lightquic/a;", "", "", "a", "", "Lcom/tencent/lightquic/api/LightQUICSceneId;", "Lcom/tencent/lightquic/api/LightQUICEngineConfig;", "b", "Ljava/util/Map;", "engineConfigMap", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f240848a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Map<LightQUICSceneId, LightQUICEngineConfig> engineConfigMap = new LinkedHashMap();

    a() {
    }

    public final void a() {
        for (Map.Entry<LightQUICSceneId, LightQUICEngineConfig> entry : engineConfigMap.entrySet()) {
            LightQUICSDKMgr.INSTANCE.configEngine(entry.getKey(), entry.getValue());
        }
    }
}
