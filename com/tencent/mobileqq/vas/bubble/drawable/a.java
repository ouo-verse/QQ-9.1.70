package com.tencent.mobileqq.vas.bubble.drawable;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.vas.bubble.IBubbleManager;
import com.tencent.mobileqq.vas.bubble.IBubbleTextColorManager;
import com.tencent.mobileqq.vas.bubble.drawable.shoot.ShootBubbleAnimDrawable;
import com.tencent.mobileqq.vas.bubble.report.VasBubbleReporter;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.business.BubbleBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.qphone.base.util.QLog;
import f03.b;
import f03.d;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\"\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J2\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016J*\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016J*\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/vas/bubble/drawable/a;", "", "", "messageType", "Lf03/b;", "bubbleConfig", "", "message", "Lf03/a;", "d", "bubbleId", "diyId", "uin", "", "isMirror", "Landroid/graphics/drawable/Drawable;", "b", "a", "startX", "startY", "c", "Ll03/a;", "Ll03/a;", "bubbleConfigManager", "Lcom/tencent/mobileqq/vas/updatesystem/business/BubbleBusiness;", "Lcom/tencent/mobileqq/vas/updatesystem/business/BubbleBusiness;", "bubbleBusiness", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final l03.a bubbleConfigManager = new l03.a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final BubbleBusiness bubbleBusiness;

    public a() {
        QQVasUpdateBusiness businessInstance = ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance((Class<QQVasUpdateBusiness>) BubbleBusiness.class);
        Intrinsics.checkNotNullExpressionValue(businessInstance, "api(IVasBusinessManager:\u2026bbleBusiness::class.java)");
        this.bubbleBusiness = (BubbleBusiness) businessInstance;
    }

    private final f03.a d(int messageType, b bubbleConfig, String message) {
        boolean contains$default;
        IBubbleManager.Companion companion = IBubbleManager.INSTANCE;
        if (messageType == companion.c()) {
            ArrayList<f03.a> f16 = bubbleConfig.f();
            if (!f16.isEmpty()) {
                Iterator<f03.a> it = f16.iterator();
                while (it.hasNext()) {
                    f03.a next = it.next();
                    Iterator<String> it5 = next.e().iterator();
                    while (it5.hasNext()) {
                        String key = it5.next();
                        Intrinsics.checkNotNullExpressionValue(key, "key");
                        contains$default = StringsKt__StringsKt.contains$default((CharSequence) message, (CharSequence) key, false, 2, (Object) null);
                        if (contains$default) {
                            return next;
                        }
                    }
                }
            }
            return bubbleConfig.getBubbleFrameAnimation();
        }
        if (messageType == companion.d()) {
            return bubbleConfig.getVoiceAnimation();
        }
        if (messageType == companion.e()) {
            return bubbleConfig.getVoicePrintAnimation();
        }
        companion.a();
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00c6, code lost:
    
        if (r1 != false) goto L26;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Drawable a(@NotNull String bubbleId, @NotNull String message, int messageType, boolean isMirror) {
        boolean z16;
        boolean z17;
        String replace$default;
        String replace$default2;
        Intrinsics.checkNotNullParameter(bubbleId, "bubbleId");
        Intrinsics.checkNotNullParameter(message, "message");
        if (!this.bubbleBusiness.isFileExists(Integer.parseInt(bubbleId))) {
            replace$default = StringsKt__StringsJVMKt.replace$default(VasBubbleReporter.ERROR_BUBBLE_CREATE, "{id}", bubbleId, false, 4, (Object) null);
            replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "{msg}", "bubble file not exists", false, 4, (Object) null);
            VasBubbleReporter.INSTANCE.report(replace$default2);
            return null;
        }
        b c16 = this.bubbleConfigManager.c(bubbleId, true);
        if (c16 == null) {
            return null;
        }
        f03.a d16 = d(messageType, c16, message);
        if (d16 == null) {
            if (com.tencent.qqnt.util.b.f362976b.isDebugVersion() || QLog.isColorLevel()) {
                QLog.e(IBubbleManager.INSTANCE.b() + "CONFIG", 1, "animationConfig == null : bubbleId = " + bubbleId);
            }
            return null;
        }
        String str = this.bubbleBusiness.getBubbleAnimPath(Integer.parseInt(bubbleId)) + File.separator + d16.getZipName();
        File file = new File(str);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                z16 = false;
                if (listFiles.length == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
            }
            z16 = true;
            if (!z16) {
                return new BubblePngsAnimDrawable(d16, c16, str, messageType, isMirror);
            }
        }
        if (com.tencent.qqnt.util.b.f362976b.isDebugVersion() || QLog.isColorLevel()) {
            QLog.d(IBubbleManager.INSTANCE.b() + "FILE", 1, "drawablePath file not exists : bubbleId = " + bubbleId);
        }
        return null;
    }

    @Nullable
    public Drawable b(@NotNull String bubbleId, @NotNull String diyId, @NotNull String uin, int messageType, boolean isMirror) {
        String str;
        HashMap<String, g03.a> c16;
        String str2;
        String replace$default;
        String replace$default2;
        Intrinsics.checkNotNullParameter(bubbleId, "bubbleId");
        Intrinsics.checkNotNullParameter(diyId, "diyId");
        Intrinsics.checkNotNullParameter(uin, "uin");
        int parseInt = Integer.parseInt(bubbleId);
        String bubbleStaticPath = this.bubbleBusiness.getBubbleStaticPath(parseInt);
        String str3 = File.separator;
        IBubbleManager.Companion companion = IBubbleManager.INSTANCE;
        if (messageType == companion.a()) {
            str = BubbleBusiness.AIO_USER_PIC_NOR;
        } else {
            str = BubbleBusiness.AIO_USER_BG_NOR;
        }
        String str4 = bubbleStaticPath + str3 + str;
        if (!new File(str4).exists()) {
            String bubbleStaticPath2 = this.bubbleBusiness.getBubbleStaticPath(parseInt);
            if (messageType == companion.a()) {
                str2 = BubbleBusiness.AIO_USER_PIC_NOR_OLD;
            } else {
                str2 = BubbleBusiness.AIO_USER_BG_NOR_OLD;
            }
            str4 = bubbleStaticPath2 + str3 + str2;
            if (!new File(str4).exists()) {
                replace$default = StringsKt__StringsJVMKt.replace$default(VasBubbleReporter.ERROR_BUBBLE_CREATE, "{id}", bubbleId, false, 4, (Object) null);
                replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "{msg}", "bubble bg file not exists", false, 4, (Object) null);
                VasBubbleReporter.INSTANCE.report(replace$default2);
                return null;
            }
        }
        QRouteApi api = QRoute.api(IBubbleTextColorManager.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IBubbleTextColorManager::class.java)");
        ((IBubbleTextColorManager) api).saveBubbleIsTransparent(str4, bubbleId);
        b c17 = this.bubbleConfigManager.c(bubbleId, true);
        BubbleBackGroundDrawable bubbleBackGroundDrawable = new BubbleBackGroundDrawable(str4, isMirror, c17);
        if (c17 != null && (c16 = c17.c()) != null) {
            return new DiyBubbleDrawable(bubbleBackGroundDrawable, c16, isMirror, uin, diyId);
        }
        return bubbleBackGroundDrawable;
    }

    @Nullable
    public Drawable c(@NotNull String bubbleId, int startX, int startY, boolean isMirror) {
        d dVar;
        Intrinsics.checkNotNullParameter(bubbleId, "bubbleId");
        if (!this.bubbleBusiness.isFileExists(Integer.parseInt(bubbleId))) {
            if (com.tencent.qqnt.util.b.f362976b.isDebugVersion() || QLog.isColorLevel()) {
                QLog.e(IBubbleManager.INSTANCE.b() + "FILE", 1, "bubble file not exists : bubbleId = " + bubbleId);
            }
            return null;
        }
        b c16 = this.bubbleConfigManager.c(bubbleId, false);
        if (c16 != null) {
            dVar = c16.getShootAnimation();
        } else {
            dVar = null;
        }
        if (dVar == null) {
            return null;
        }
        return new ShootBubbleAnimDrawable(startX, startY, dVar, isMirror);
    }
}
