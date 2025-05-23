package f03;

import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.bubble.IBubbleManager;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.business.BubbleBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lf03/c;", "", "", "bubbleId", "", FavEmoConstant.ROAMING_TYPE_PANEL, "c", "b", "Lf03/b;", "a", "Lh03/a;", "Lh03/a;", "mBubbleConfigParser", "Lh03/c;", "Lh03/c;", "mShootAnimationConfigParser", "Lcom/tencent/mobileqq/vas/updatesystem/business/BubbleBusiness;", "Lcom/tencent/mobileqq/vas/updatesystem/business/BubbleBusiness;", "bubbleBusiness", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final h03.a mBubbleConfigParser = new h03.a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final h03.c mShootAnimationConfigParser = new h03.c();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final BubbleBusiness bubbleBusiness;

    public c() {
        QQVasUpdateBusiness businessInstance = ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance((Class<QQVasUpdateBusiness>) BubbleBusiness.class);
        Intrinsics.checkNotNullExpressionValue(businessInstance, "api(IVasBusinessManager:\u2026bbleBusiness::class.java)");
        this.bubbleBusiness = (BubbleBusiness) businessInstance;
    }

    private final String b(String bubbleId) {
        try {
            if (!this.bubbleBusiness.isFileExists(Integer.parseInt(bubbleId))) {
                QLog.e(l03.a.INSTANCE.a(), 1, "getConfigContent not isFileExists ! bubbleId : " + bubbleId);
                return null;
            }
            String bubbleJsonPath = this.bubbleBusiness.getBubbleJsonPath(Integer.parseInt(bubbleId));
            Intrinsics.checkNotNullExpressionValue(bubbleJsonPath, "bubbleBusiness.getBubbleJsonPath(bubbleId.toInt())");
            File file = new File(bubbleJsonPath);
            if (!file.exists()) {
                QLog.e(l03.a.INSTANCE.a(), 1, "getConfigContent file not exist ! bubbleId : " + bubbleId);
                return null;
            }
            return FileUtils.readFileToString(file);
        } catch (Exception e16) {
            QLog.e(l03.a.INSTANCE.a(), 1, e16, new Object[0]);
            return null;
        } catch (OutOfMemoryError e17) {
            QLog.e(l03.a.INSTANCE.a(), 1, e17, new Object[0]);
            return null;
        }
    }

    private final String c(String bubbleId, boolean needDownload) {
        String bubbleShootJsonPath = this.bubbleBusiness.getBubbleShootJsonPath(Integer.parseInt(bubbleId));
        Intrinsics.checkNotNullExpressionValue(bubbleShootJsonPath, "bubbleBusiness.getBubble\u2026sonPath(bubbleId.toInt())");
        File file = new File(bubbleShootJsonPath);
        if (file.exists()) {
            try {
                return FileUtils.readFileToString(file);
            } catch (IOException e16) {
                QLog.e(l03.a.INSTANCE.a(), 1, e16, new Object[0]);
                return null;
            } catch (OutOfMemoryError e17) {
                QLog.e(l03.a.INSTANCE.a(), 2, e17, new Object[0]);
                return null;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001b A[Catch: JSONException -> 0x0041, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0041, blocks: (B:3:0x0008, B:5:0x000f, B:10:0x001b, B:21:0x002c, B:23:0x0032, B:26:0x003b), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x002c A[Catch: JSONException -> 0x0041, TRY_ENTER, TryCatch #0 {JSONException -> 0x0041, blocks: (B:3:0x0008, B:5:0x000f, B:10:0x001b, B:21:0x002c, B:23:0x0032, B:26:0x003b), top: B:2:0x0008 }] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b a(@NotNull String bubbleId, boolean needDownload) {
        String b16;
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(bubbleId, "bubbleId");
        b bVar = null;
        try {
            b16 = b(bubbleId);
            z16 = false;
        } catch (JSONException e16) {
            e = e16;
        }
        if (b16 != null && b16.length() != 0) {
            z17 = false;
            if (!z17) {
                b bVar2 = new b();
                try {
                    this.mBubbleConfigParser.r(bVar2, b16);
                    bVar = bVar2;
                } catch (JSONException e17) {
                    e = e17;
                    bVar = bVar2;
                    QLog.e(IBubbleManager.INSTANCE.b(), 1, "createBubbleConfig error : bubbleId = " + bubbleId + " ", e);
                    return bVar;
                }
            }
            if (bVar != null) {
                String c16 = c(bubbleId, needDownload);
                if (c16 == null || c16.length() == 0) {
                    z16 = true;
                }
                if (!z16) {
                    this.mShootAnimationConfigParser.b(bVar, c16, bubbleId);
                }
            }
            return bVar;
        }
        z17 = true;
        if (!z17) {
        }
        if (bVar != null) {
        }
        return bVar;
    }
}
