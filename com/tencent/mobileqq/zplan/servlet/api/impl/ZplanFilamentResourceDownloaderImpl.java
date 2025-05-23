package com.tencent.mobileqq.zplan.servlet.api.impl;

import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.zplan.lite.ZPlanFilamentResourceDownloader;
import com.tencent.mobileqq.zplan.lite.b;
import com.tencent.mobileqq.zplan.servlet.api.IZplanFilamentResourceDownloader;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016JH\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\b2\"\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\bH\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/zplan/servlet/api/impl/ZplanFilamentResourceDownloaderImpl;", "Lcom/tencent/mobileqq/zplan/servlet/api/IZplanFilamentResourceDownloader;", "()V", "getAvatarInfo", "", "uin", "getAvatarResource", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "avatarMap", "getTemplateConfig", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class ZplanFilamentResourceDownloaderImpl implements IZplanFilamentResourceDownloader {
    @Override // com.tencent.mobileqq.zplan.servlet.api.IZplanFilamentResourceDownloader
    public String getAvatarInfo(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        String str = (String) CorountineFunKt.g(i.b.f261780e, "ZplanFilamentResourceDownloaderImpl_getAvatarInfo", null, new ZplanFilamentResourceDownloaderImpl$getAvatarInfo$1(uin, null), 4, null);
        if (str != null) {
            return str;
        }
        String jSONObject = new JSONObject().toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject().toString()");
        return jSONObject;
    }

    @Override // com.tencent.mobileqq.zplan.servlet.api.IZplanFilamentResourceDownloader
    public HashMap<String, String> getAvatarResource(HashMap<String, String> avatarMap) {
        Intrinsics.checkNotNullParameter(avatarMap, "avatarMap");
        return ZPlanFilamentResourceDownloader.f333782a.i(avatarMap);
    }

    @Override // com.tencent.mobileqq.zplan.servlet.api.IZplanFilamentResourceDownloader
    public String getTemplateConfig() {
        return b.f333795a.d();
    }
}
