package com.tencent.mobileqq.matchfriend.reborn.kuikly;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.Part;
import com.tencent.kuikly.core.render.android.expand.module.l;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/kuikly/QQStrangerKuiklyReceiverPart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onPartCreate", "onPartDestroy", "Landroid/content/BroadcastReceiver;", "d", "Landroid/content/BroadcastReceiver;", "kuiklyBroadcastReceiver", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerKuiklyReceiverPart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private BroadcastReceiver kuiklyBroadcastReceiver;

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.matchfriend.reborn.kuikly.QQStrangerKuiklyReceiverPart$onPartCreate$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String a16 = intent != null ? l.a(intent) : null;
                JSONObject b16 = intent != null ? l.b(intent) : null;
                if (a16 == null || a16.length() == 0) {
                    return;
                }
                SimpleEventBus.getInstance().dispatchEvent(new QQStrangerKuiklyEvent(a16, b16));
            }
        };
        this.kuiklyBroadcastReceiver = broadcastReceiver;
        Context context = getContext();
        if (context != null) {
            Intrinsics.checkNotNullExpressionValue(context, "context");
            l.c(context, broadcastReceiver);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        BroadcastReceiver broadcastReceiver = this.kuiklyBroadcastReceiver;
        if (broadcastReceiver != null) {
            Context context = getContext();
            if (context != null) {
                context.unregisterReceiver(broadcastReceiver);
            }
            this.kuiklyBroadcastReceiver = null;
        }
    }
}
