package com.tencent.mobileqq.flock.share.action;

import android.app.Activity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import y45.n;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\t\u001a\u00020\bH\u0014\u00a2\u0006\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/flock/share/action/c;", "Lcom/tencent/mobileqq/flock/share/action/FlockShareBaseAction;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Ly45/n;", "shareInfo", "", "k", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "sheetItem", "Lcom/tencent/mobileqq/flock/share/e;", "shareParam", "g", "", "e", "(Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;)Ljava/lang/Integer;", "<init>", "()V", "a", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class c extends FlockShareBaseAction {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/flock/share/action/c$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flock.share.action.c$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49024);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void k(Activity activity, n shareInfo) {
        ArrayList<String> arrayListOf;
        QZoneShareData qZoneShareData = new QZoneShareData();
        qZoneShareData.mTitle = shareInfo.f449442a;
        qZoneShareData.mSummary = shareInfo.f449443b;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(shareInfo.f449444c.f449405c);
        qZoneShareData.mImageUrls = arrayListOf;
        qZoneShareData.from = 0;
        qZoneShareData.targetUrl = shareInfo.f449445d;
        QZoneShareManager.shareToQzone(activity, com.tencent.mobileqq.flock.utils.b.f210481a.a(), qZoneShareData, null, 0);
    }

    @Override // com.tencent.mobileqq.flock.share.action.FlockShareBaseAction
    @Nullable
    protected Integer e(@NotNull ShareActionSheetBuilder.ActionSheetItem sheetItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) sheetItem);
        }
        Intrinsics.checkNotNullParameter(sheetItem, "sheetItem");
        return 2;
    }

    @Override // com.tencent.mobileqq.flock.share.action.FlockShareBaseAction
    public void g(@NotNull Activity activity, @NotNull ShareActionSheetBuilder.ActionSheetItem sheetItem, @NotNull com.tencent.mobileqq.flock.share.e shareParam) {
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, activity, sheetItem, shareParam);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(sheetItem, "sheetItem");
        Intrinsics.checkNotNullParameter(shareParam, "shareParam");
        n n3 = shareParam.n();
        if (n3 != null) {
            k(activity, n3);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            FlockShareBaseAction.i(this, null, 1, null);
        }
    }
}
