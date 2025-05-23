package com.dataline.qqnt.notification;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qqnt.kernel.nativeinterface.PeerUid;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.notification.struct.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@KeepClassConstructor
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u0000 \u00122\u00020\u0001:\u0001\u000bB\u0019\b\u0004\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/dataline/qqnt/notification/DataLineNotificationProcessor;", "Lcom/tencent/qqnt/notification/struct/b;", "", "r", "Landroid/graphics/Bitmap;", "j", "Landroid/content/Context;", "context", "", "drawableId", "t", "a", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "msgRecord", "<init>", "(Lmqq/app/AppRuntime;Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;)V", "e", "qq_nt_dataline_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes2.dex */
public class DataLineNotificationProcessor extends b {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected DataLineNotificationProcessor(@NotNull AppRuntime app, @NotNull RecentContactInfo msgRecord) {
        super(app, msgRecord);
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
    }

    @Override // com.tencent.qqnt.notification.struct.c
    public int a() {
        return 0;
    }

    @Override // com.tencent.qqnt.notification.struct.BaseUinTypeProcessor
    @Nullable
    public Bitmap j() {
        String str = d().peerUid;
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -1834626455) {
                if (hashCode != -1656358474) {
                    if (hashCode == 1930502276 && str.equals(PeerUid.DATALINE_PC_UID)) {
                        return t(MobileQQ.sMobileQQ, R.drawable.qfile_dataline_pc_recent);
                    }
                } else if (str.equals(PeerUid.DATALINE_PAD_UID)) {
                    return t(MobileQQ.sMobileQQ, R.drawable.qfile_dataline_ipad_recent);
                }
            } else if (str.equals(PeerUid.DATALINE_PHONE_UID)) {
                return t(MobileQQ.sMobileQQ, R.drawable.qfile_dataline_user_aio);
            }
        }
        return super.j();
    }

    @Override // com.tencent.qqnt.notification.struct.BaseUinTypeProcessor
    @NotNull
    public String r() {
        String str = d().peerUid;
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -1834626455) {
                if (hashCode != -1656358474) {
                    if (hashCode == 1930502276 && str.equals(PeerUid.DATALINE_PC_UID)) {
                        String qqStr = HardCodeUtil.qqStr(R.string.cf5);
                        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(com.tencent.mobile\u2026api.R.string.my_computer)");
                        return qqStr;
                    }
                } else if (str.equals(PeerUid.DATALINE_PAD_UID)) {
                    String qqStr2 = HardCodeUtil.qqStr(R.string.f16272217);
                    Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(com.tencent.mobile\u2026.R.string.lite_title_pad)");
                    return qqStr2;
                }
            } else if (str.equals(PeerUid.DATALINE_PHONE_UID)) {
                String qqStr3 = HardCodeUtil.qqStr(R.string.f169742j6);
                Intrinsics.checkNotNullExpressionValue(qqStr3, "qqStr(R.string.my_phone)");
                return qqStr3;
            }
        }
        return super.r();
    }

    @Nullable
    public Bitmap t(@Nullable Context context, int drawableId) {
        Drawable drawable;
        if (context != null) {
            drawable = context.getDrawable(drawableId);
        } else {
            drawable = null;
        }
        Intrinsics.checkNotNull(drawable);
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        if (drawable == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }
}
