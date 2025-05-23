package com.tencent.aelight.camera.zplan.api.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.aelight.camera.aioeditor.takevideo.ai;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tribe.async.async.JobContext;
import fs.o;
import fs.s;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u001b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0014\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u001c\u0010\n\u001a\u00020\u00052\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0014R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/aelight/camera/zplan/api/impl/h;", "Lfs/o;", "Lfs/b;", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "b", "Lcom/tribe/async/async/JobContext;", "jobContext", "context", "a", "Lcom/tencent/aelight/camera/zplan/api/impl/l;", tl.h.F, "Lcom/tencent/aelight/camera/zplan/api/impl/l;", "editBackgroundExport", "Lcom/tencent/aelight/camera/aioeditor/takevideo/ai;", "i", "Lcom/tencent/aelight/camera/aioeditor/takevideo/ai;", "editPicRawImageExport", "<init>", "(Lcom/tencent/aelight/camera/zplan/api/impl/l;Lcom/tencent/aelight/camera/aioeditor/takevideo/ai;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class h extends o<fs.b, fs.b> {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final l editBackgroundExport;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final ai editPicRawImageExport;

    public h(l lVar, ai aiVar) {
        this.editBackgroundExport = lVar;
        this.editPicRawImageExport = aiVar;
    }

    private final void b(fs.b bVar, Bitmap bitmap) {
        String a16 = s.a(bVar.f400385b, bVar.f400399p, ".png");
        Intrinsics.checkNotNullExpressionValue(a16, "generateCacheFilePath(bu\u2026, mUploadTempDir, \".png\")");
        if (com.tencent.biz.qqstory.utils.b.a(bitmap, Bitmap.CompressFormat.PNG, 100, a16)) {
            bVar.f400395l.f400416b = a16;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tribe.async.async.JobSegment
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void runSegment(JobContext<?> jobContext, fs.b context) {
        Rect rect;
        ZPlanPortraitImageView e06;
        RectF mRestrictInRect;
        Intrinsics.checkNotNullParameter(jobContext, "jobContext");
        Intrinsics.checkNotNullParameter(context, "context");
        l lVar = this.editBackgroundExport;
        b background = lVar != null ? lVar.getBackground() : null;
        if (background == null) {
            notifyResult(context);
            return;
        }
        Bitmap decodeFile = SafeBitmapFactory.decodeFile(context.f400395l.f400416b);
        if (decodeFile == null) {
            notifyError(new Error("[MergeBackgroundSegment] fail decode dest pic when merge background."));
            return;
        }
        ai aiVar = this.editPicRawImageExport;
        if (aiVar != null && (e06 = aiVar.e0()) != null && (mRestrictInRect = e06.getMRestrictInRect()) != null) {
            rect = new Rect();
            mRestrictInRect.round(rect);
        } else {
            rect = new Rect(0, 0, decodeFile.getWidth(), decodeFile.getHeight());
        }
        Bitmap bottomBitmap = Bitmap.createScaledBitmap(n.e(background, rect), decodeFile.getWidth(), decodeFile.getHeight(), true);
        new Canvas(bottomBitmap).drawBitmap(decodeFile, 0.0f, 0.0f, (Paint) null);
        Intrinsics.checkNotNullExpressionValue(bottomBitmap, "bottomBitmap");
        b(context, bottomBitmap);
        notifyResult(context);
    }
}
