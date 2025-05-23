package com.tencent.mobileqq.zplan.aigc.share;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJh\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0002JH\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0002J\u0006\u0010\u0018\u001a\u00020\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/share/bl;", "", "", "prompt", "name", "", "ugcId", "subPageId", "Landroid/graphics/Bitmap;", "bgBitmap", "clothBitmap", "avatarBitmap", "Landroid/graphics/drawable/Drawable;", "qqHeadDrawable", "Lzd3/a;", "dtReporter", "", "gender", "source", "", "c", "posterBitmap", "d", "", "b", "Lcom/tencent/mobileqq/zplan/aigc/share/bj;", "a", "Lcom/tencent/mobileqq/zplan/aigc/share/bj;", "shareWithPicPresenter", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class bl {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final bj shareWithPicPresenter = new bj();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/aigc/share/bl$b", "Lcom/tencent/mobileqq/zplan/aigc/share/c;", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "onSuccess", "", "error", "onFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements c {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ak f330645b;

        b(ak akVar) {
            this.f330645b = akVar;
        }

        @Override // com.tencent.mobileqq.zplan.aigc.share.c
        public void onFailure(String error) {
            Intrinsics.checkNotNullParameter(error, "error");
            bl.this.shareWithPicPresenter.T(this.f330645b);
            bl.this.shareWithPicPresenter.U();
            QLog.d("SuitShareDialog", 1, " genPoster failed, \u751f\u6210\u6d77\u62a5\u5931\u8d25");
        }

        @Override // com.tencent.mobileqq.zplan.aigc.share.c
        public void onSuccess(Bitmap bitmap) {
            bl.this.shareWithPicPresenter.T(this.f330645b);
            bl.this.shareWithPicPresenter.U();
        }
    }

    public final boolean b() {
        return this.shareWithPicPresenter.N();
    }

    public final void c(String prompt, String name, long ugcId, String subPageId, Bitmap bgBitmap, Bitmap clothBitmap, Bitmap avatarBitmap, Drawable qqHeadDrawable, zd3.a dtReporter, int gender, String source) {
        ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] b16;
        Intrinsics.checkNotNullParameter(prompt, "prompt");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(subPageId, "subPageId");
        Intrinsics.checkNotNullParameter(source, "source");
        if (w84.a.f445029a.b()) {
            return;
        }
        Context topActivity = Foreground.getTopActivity();
        if (topActivity == null) {
            topActivity = BaseApplication.getContext();
        }
        if (topActivity != null) {
            QLog.d("SuitShareDialog", 1, " updateAvatarCharacter success, \u5f39\u51fa\u5206\u4eab\u5f39\u7a97\u6210\u529f\uff0c\u7279\u6027\u5f00\u5173\u83b7\u53d6\u6837\u5f0f\u7c7b\u578b");
            ak akVar = new ak(topActivity, dtReporter, gender, source);
            AppRuntime app = MobileQQ.sMobileQQ.peekAppRuntime();
            bj bjVar = this.shareWithPicPresenter;
            Intrinsics.checkNotNullExpressionValue(app, "app");
            bjVar.S(new SuitShareData(app, name, prompt, ugcId, subPageId, bgBitmap, clothBitmap, avatarBitmap, qqHeadDrawable));
            b16 = bm.b();
            akVar.y0(b16);
            akVar.z0(this.shareWithPicPresenter);
            akVar.u0(new b(akVar));
            return;
        }
        QLog.d("AvatarBugStoreRepo", 1, " updateAvatarCharacter success, \u5f39\u51fa\u5206\u4eab\u5f39\u7a97\u5931\u8d25\uff0ccontext\u4e3a\u7a7a");
    }

    public final void d(String prompt, String name, long ugcId, String subPageId, Bitmap posterBitmap, zd3.a dtReporter, int gender, String source) {
        ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] b16;
        Intrinsics.checkNotNullParameter(prompt, "prompt");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(subPageId, "subPageId");
        Intrinsics.checkNotNullParameter(posterBitmap, "posterBitmap");
        Intrinsics.checkNotNullParameter(source, "source");
        if (w84.a.f445029a.b()) {
            return;
        }
        Context topActivity = Foreground.getTopActivity();
        if (topActivity == null) {
            topActivity = BaseApplication.getContext();
        }
        if (topActivity != null) {
            QLog.d("SuitShareDialog", 1, " updateAvatarCharacter success, \u5f39\u51fa\u5206\u4eab\u5f39\u7a97\u6210\u529f\uff0c\u7279\u6027\u5f00\u5173\u83b7\u53d6\u6837\u5f0f\u7c7b\u578b");
            ak akVar = new ak(topActivity, dtReporter, gender, source);
            AppRuntime app = MobileQQ.sMobileQQ.peekAppRuntime();
            bj bjVar = this.shareWithPicPresenter;
            Intrinsics.checkNotNullExpressionValue(app, "app");
            bjVar.S(new SuitShareData(app, name, prompt, ugcId, subPageId, null, null, null, null));
            b16 = bm.b();
            akVar.y0(b16);
            akVar.z0(this.shareWithPicPresenter);
            this.shareWithPicPresenter.e(posterBitmap);
            this.shareWithPicPresenter.T(akVar);
            this.shareWithPicPresenter.U();
            return;
        }
        QLog.d("AvatarBugStoreRepo", 1, " updateAvatarCharacter success, \u5f39\u51fa\u5206\u4eab\u5f39\u7a97\u5931\u8d25\uff0ccontext\u4e3a\u7a7a");
    }
}
