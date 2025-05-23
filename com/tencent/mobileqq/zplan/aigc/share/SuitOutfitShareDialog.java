package com.tencent.mobileqq.zplan.aigc.share;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.QAdCardExtraData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u009b\u0001\u0010\u0016\u001a\u00020\u00152\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0019\u001a\u00020\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/share/SuitOutfitShareDialog;", "", "", "feedId", "Landroid/graphics/Bitmap;", "maskBitmap", "avatarBitmap", "backgroundBitmap", "", "itemsBitmaps", "itemBgBitmaps", "goodLookBubbleBitmap", "veryGoodLookBubbleBitmap", "", "createTs", "nickName", "", QAdCardExtraData.AdExtraInnerKey.AD_EXTRA_KEY_PAGE_PARAMS, "pageId", "Lzd3/a;", "dtReporter", "", "d", "(Ljava/lang/String;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Ljava/util/List;Ljava/util/List;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Ljava/lang/Long;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Lzd3/a;)V", "", "c", "Lcom/tencent/mobileqq/zplan/aigc/share/ag;", "a", "Lcom/tencent/mobileqq/zplan/aigc/share/ag;", "shareWithPicPresenter", "<init>", "()V", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SuitOutfitShareDialog {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ag shareWithPicPresenter = new ag();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(final l shareActionSheet, final SuitOutfitShareDialog this$0) {
        Intrinsics.checkNotNullParameter(shareActionSheet, "$shareActionSheet");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        shareActionSheet.t0(new c() { // from class: com.tencent.mobileqq.zplan.aigc.share.SuitOutfitShareDialog$showShareDialogIfNeed$1$1
            @Override // com.tencent.mobileqq.zplan.aigc.share.c
            public void onFailure(String error) {
                Intrinsics.checkNotNullParameter(error, "error");
                t74.l lVar = t74.l.f435563a;
                final SuitOutfitShareDialog suitOutfitShareDialog = SuitOutfitShareDialog.this;
                final l lVar2 = shareActionSheet;
                lVar.h(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.share.SuitOutfitShareDialog$showShareDialogIfNeed$1$1$onFailure$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        ag agVar;
                        ag agVar2;
                        agVar = SuitOutfitShareDialog.this.shareWithPicPresenter;
                        agVar.Q(lVar2);
                        agVar2 = SuitOutfitShareDialog.this.shareWithPicPresenter;
                        agVar2.R();
                        QLog.d("SuitOutfitShareDialog", 1, " genPoster failed, \u751f\u6210\u6d77\u62a5\u5931\u8d25");
                    }
                });
            }

            @Override // com.tencent.mobileqq.zplan.aigc.share.c
            public void onSuccess(Bitmap bitmap) {
                t74.l lVar = t74.l.f435563a;
                final SuitOutfitShareDialog suitOutfitShareDialog = SuitOutfitShareDialog.this;
                final l lVar2 = shareActionSheet;
                lVar.h(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.share.SuitOutfitShareDialog$showShareDialogIfNeed$1$1$onSuccess$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        ag agVar;
                        ag agVar2;
                        agVar = SuitOutfitShareDialog.this.shareWithPicPresenter;
                        agVar.Q(lVar2);
                        agVar2 = SuitOutfitShareDialog.this.shareWithPicPresenter;
                        agVar2.R();
                    }
                });
            }
        });
    }

    public final boolean c() {
        return this.shareWithPicPresenter.K();
    }

    public final void d(String feedId, Bitmap maskBitmap, Bitmap avatarBitmap, Bitmap backgroundBitmap, List<Bitmap> itemsBitmaps, List<Bitmap> itemBgBitmaps, Bitmap goodLookBubbleBitmap, Bitmap veryGoodLookBubbleBitmap, Long createTs, String nickName, Map<String, Object> pageParams, String pageId, zd3.a dtReporter) {
        Intrinsics.checkNotNullParameter(itemsBitmaps, "itemsBitmaps");
        Intrinsics.checkNotNullParameter(itemBgBitmaps, "itemBgBitmaps");
        Intrinsics.checkNotNullParameter(goodLookBubbleBitmap, "goodLookBubbleBitmap");
        Intrinsics.checkNotNullParameter(veryGoodLookBubbleBitmap, "veryGoodLookBubbleBitmap");
        Intrinsics.checkNotNullParameter(pageParams, "pageParams");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        if (w84.a.f445029a.b()) {
            return;
        }
        Context topActivity = Foreground.getTopActivity();
        if (topActivity == null) {
            topActivity = BaseApplication.getContext();
        }
        if (topActivity != null) {
            QLog.d("SuitOutfitShareDialog", 1, "\u5f39\u51fa\u5206\u4eab\u5f39\u7a97\u6210\u529f");
            final l lVar = new l(topActivity, pageParams, pageId, dtReporter);
            AppRuntime app = MobileQQ.sMobileQQ.peekAppRuntime();
            ag agVar = this.shareWithPicPresenter;
            Intrinsics.checkNotNullExpressionValue(app, "app");
            agVar.P(new SuitOutfitShareData(app, feedId, maskBitmap, avatarBitmap, backgroundBitmap, itemsBitmaps, itemBgBitmaps, goodLookBubbleBitmap, veryGoodLookBubbleBitmap, createTs, nickName));
            lVar.x0(o.a());
            lVar.z0(this.shareWithPicPresenter);
            t74.l.f435563a.f(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.n
                @Override // java.lang.Runnable
                public final void run() {
                    SuitOutfitShareDialog.e(l.this, this);
                }
            });
            return;
        }
        QLog.d("SuitOutfitShareDialog", 1, "\u5f39\u51fa\u5206\u4eab\u5f39\u7a97\u5931\u8d25\uff0ccontext\u4e3a\u7a7a");
    }
}
