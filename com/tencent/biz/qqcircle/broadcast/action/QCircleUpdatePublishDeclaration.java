package com.tencent.biz.qqcircle.broadcast.action;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.wink.event.WinkUpdatePublishDeclarationEvent;
import com.tencent.mobileqq.wink.model.DeclarationParams;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$ShootLBS;
import feedcloud.FeedCloudMeta$SourceInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/biz/qqcircle/broadcast/action/QCircleUpdatePublishDeclaration;", "Lcom/tencent/biz/qqcircle/broadcast/action/QCircleBaseBroadcastAction;", "Landroid/os/Parcelable;", "parcelable", "", "b", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "", "a", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QCircleUpdatePublishDeclaration extends QCircleBaseBroadcastAction {
    private final byte[] b(Parcelable parcelable) {
        Parcel obtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
        parcelable.writeToParcel(obtain, 0);
        byte[] bytes = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        Intrinsics.checkNotNullExpressionValue(bytes, "bytes");
        return bytes;
    }

    @Override // com.tencent.biz.qqcircle.broadcast.action.QCircleBaseBroadcastAction
    @NotNull
    public String a() {
        return "action_update_publish_declaration";
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        String str;
        String str2;
        long j3;
        String str3;
        String str4;
        String str5;
        String str6;
        FeedCloudMeta$ShootLBS shootLbs;
        String str7 = null;
        if (intent != null) {
            str = intent.getStringExtra("id");
        } else {
            str = null;
        }
        if (intent != null) {
            str2 = intent.getStringExtra("name");
        } else {
            str2 = null;
        }
        if (intent != null) {
            j3 = intent.getLongExtra("shoot_time", -1L);
        } else {
            j3 = -1;
        }
        if (intent != null) {
            str3 = intent.getStringExtra("country");
        } else {
            str3 = null;
        }
        if (intent != null) {
            str4 = intent.getStringExtra("province");
        } else {
            str4 = null;
        }
        if (intent != null) {
            str5 = intent.getStringExtra("city");
        } else {
            str5 = null;
        }
        if (intent != null) {
            str6 = intent.getStringExtra("feed_id");
        } else {
            str6 = null;
        }
        if (intent != null) {
            str7 = intent.getStringExtra("ec_uid");
        }
        QLog.d("QCircleUpdatePublishDeclaration", 1, "id:" + str + " name:" + str2 + " shootTime:" + j3 + " country:" + str3 + " province:" + str4 + " city:" + str5 + " feedId:" + str6 + " uid:" + str7);
        if (str != null && str2 != null) {
            String str8 = str6;
            DeclarationParams declarationParams = new DeclarationParams(str, str2, null, null, 12, null);
            if (j3 != -1) {
                FeedCloudMeta$ShootLBS feedCloudMeta$ShootLBS = new FeedCloudMeta$ShootLBS();
                feedCloudMeta$ShootLBS.shoot_time.set(j3);
                declarationParams.setShootLbs(feedCloudMeta$ShootLBS);
                if (str3 != null && (shootLbs = declarationParams.getShootLbs()) != null) {
                    shootLbs.country.set(str3);
                    if (str4 != null) {
                        shootLbs.province.set(str4);
                    }
                    if (str5 != null) {
                        shootLbs.city.set(str5);
                    }
                }
            }
            if (str8 != null) {
                FeedCloudMeta$SourceInfo feedCloudMeta$SourceInfo = new FeedCloudMeta$SourceInfo();
                feedCloudMeta$SourceInfo.feed_id.set(str8);
                if (str7 != null) {
                    feedCloudMeta$SourceInfo.ec_uid.set(str7);
                }
                declarationParams.setSourceInfo(feedCloudMeta$SourceInfo);
            }
            SimpleEventBus.getInstance().dispatchEvent(new WinkUpdatePublishDeclarationEvent(b(declarationParams)), true);
        }
    }
}
