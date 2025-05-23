package com.tencent.mobileqq.zplan.api.impl;

import android.content.Context;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.api.IZPlanShareApi;
import com.tencent.mobileqq.zplan.meme.prerecord.ZPlanPreRecordManager;
import com.tencent.mobileqq.zplan.share.ZPlanShareLaunchParam;
import com.tencent.mobileqq.zplan.share.ZPlanShareTranslucentActivity;
import com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.ZPlanSharePreRecordUtil;
import com.tencent.zplan.meme.Priority;
import com.tencent.zplan.meme.model.AvatarCharacterInfo;
import com.tencent.zplan.proxy.api.IZPlanShareProxy;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b%\u0010&J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J,\u0010\r\u001a\u00020\u00062\"\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n`\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tH\u0016JB\u0010\u001a\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0018\u001a\u00020\u00172&\u0010\u0019\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bj\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bH\u0016J\u0012\u0010\u001d\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J7\u0010#\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\u001c\u001a\u0004\u0018\u00010\"H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b#\u0010$\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/zplan/api/impl/ZPlanShareApiImpl;", "Lcom/tencent/mobileqq/zplan/api/IZPlanShareApi;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/zplan/share/ZPlanShareLaunchParam;", "param", "", "launchForShareMedia", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "map", "setShareExtraParams", "clearShareExtraParams", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "setSource", "clearSource", "key", "value", "setReportExtraInfo", "uin", "Lcom/tencent/zplan/proxy/api/IZPlanShareProxy$ShareData;", "data", "customShareExtraParams", "doShare", "Lji3/h;", "listener", "setPreRecordShareListener", "Lcom/tencent/zplan/meme/Priority;", "priority", "Lcom/tencent/zplan/meme/model/a;", "avatarCharacterInfo", "Lji3/e;", "preRecordSharePics", "(Ljava/lang/String;Lcom/tencent/zplan/meme/Priority;Lcom/tencent/zplan/meme/model/a;Lji3/e;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanShareApiImpl implements IZPlanShareApi {
    @Override // com.tencent.mobileqq.zplan.api.IZPlanShareApi
    public void clearShareExtraParams() {
        com.tencent.mobileqq.zplan.proxy.w.INSTANCE.b();
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanShareApi
    public void clearSource() {
        com.tencent.mobileqq.zplan.proxy.w.INSTANCE.c();
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanShareApi
    public void doShare(String uin, IZPlanShareProxy.ShareData data, HashMap<String, Object> customShareExtraParams) {
        Intrinsics.checkNotNullParameter(data, "data");
        com.tencent.mobileqq.zplan.proxy.w.INSTANCE.d(uin, data, customShareExtraParams);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanShareApi
    public void launchForShareMedia(Context context, ZPlanShareLaunchParam param) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(param, "param");
        ZPlanShareTranslucentActivity.INSTANCE.a(context, param);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanShareApi
    public Object preRecordSharePics(String str, Priority priority, AvatarCharacterInfo avatarCharacterInfo, ji3.e eVar, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object f16 = ZPlanSharePreRecordUtil.f371750a.f(str, priority, avatarCharacterInfo, eVar, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return f16 == coroutine_suspended ? f16 : Unit.INSTANCE;
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanShareApi
    public void setPreRecordShareListener(ji3.h listener) {
        ZPlanPreRecordManager.f334206e.o(listener);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanShareApi
    public void setReportExtraInfo(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        com.tencent.mobileqq.zplan.proxy.w.INSTANCE.g().put(key, value);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanShareApi
    public void setShareExtraParams(HashMap<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        com.tencent.mobileqq.zplan.proxy.w.INSTANCE.h(map);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanShareApi
    public void setSource(ZootopiaSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        com.tencent.mobileqq.zplan.proxy.w.INSTANCE.i(source);
    }
}
