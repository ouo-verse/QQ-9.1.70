package com.tencent.mobileqq.zplan.aigc.helper;

import com.tencent.mobileqq.zplan.aigc.p011const.ZPlanAIGCStatusCode;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import nk3.b;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013JZ\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/helper/AIGCCreatePublishHelper;", "", "", "ugcId", "itemId", "", "resourcePath", "", "isOfficial", "name", "desc", "prompt", "", "shareType", "Lnk3/b;", "callback", "", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class AIGCCreatePublishHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final AIGCCreatePublishHelper f330226a = new AIGCCreatePublishHelper();

    AIGCCreatePublishHelper() {
    }

    public final void a(long ugcId, long itemId, String resourcePath, boolean isOfficial, String name, String desc, String prompt, int shareType, nk3.b callback) {
        Intrinsics.checkNotNullParameter(resourcePath, "resourcePath");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(prompt, "prompt");
        if ((resourcePath.length() == 0) || !new File(resourcePath).exists() || !new File(resourcePath).isDirectory()) {
            if (callback != null) {
                b.a.a(callback, ZPlanAIGCStatusCode.PUBLISH_RESOURCE_INVALID, null, 2, null);
                return;
            }
            return;
        }
        Pair<List<String>, List<yv4.a>> a16 = tg3.a.f436326a.a(resourcePath);
        List<String> component1 = a16.component1();
        List<yv4.a> component2 = a16.component2();
        List<String> list = component1;
        if (!(list == null || list.isEmpty())) {
            List<yv4.a> list2 = component2;
            if (!(list2 == null || list2.isEmpty())) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AIGCCreatePublishHelper$triggerPublish$1(component2, ugcId, itemId, name, desc, callback, component1, isOfficial, prompt, shareType, null), 3, null);
                return;
            }
        }
        QLog.e("AIGCCreatePublishHelper", 1, "prepare for preCreate failed, files for upload or cosFileHeaderInfo invalid.");
        if (callback != null) {
            b.a.a(callback, ZPlanAIGCStatusCode.COS_UPLOAD_PREPARE_FAILED, null, 2, null);
        }
    }
}
