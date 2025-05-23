package com.tencent.mobileqq.activity.aio.intimate.reborn.model;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\r\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/intimate/reborn/model/DoLIAAnimViewEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Landroid/view/View;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/b$a;", "aniListener", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/b$a;", "getAniListener", "()Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/b$a;", "<init>", "(Landroid/view/View;Landroid/graphics/Bitmap;Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/b$a;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class DoLIAAnimViewEvent extends SimpleBaseEvent {

    @NotNull
    private final b.a aniListener;

    @NotNull
    private final Bitmap bitmap;

    @NotNull
    private final View view;

    public DoLIAAnimViewEvent(@NotNull View view, @NotNull Bitmap bitmap, @NotNull b.a aniListener) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(aniListener, "aniListener");
        this.view = view;
        this.bitmap = bitmap;
        this.aniListener = aniListener;
    }

    @NotNull
    public final b.a getAniListener() {
        return this.aniListener;
    }

    @NotNull
    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    @NotNull
    public final View getView() {
        return this.view;
    }
}
