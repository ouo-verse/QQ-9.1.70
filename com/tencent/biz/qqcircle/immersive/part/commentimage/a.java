package com.tencent.biz.qqcircle.immersive.part.commentimage;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import feedcloud.FeedCloudMeta$StUser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u001c\u0010\r\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/part/commentimage/a;", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "Landroid/text/TextPaint;", "ds", "updateDrawState", "Lcom/tencent/qqnt/avatar/meta/refresh/c;", "Lcom/tencent/biz/qqcircle/immersive/part/commentimage/b;", "d", "Lcom/tencent/qqnt/avatar/meta/refresh/c;", "weakListener", "Lcom/tencent/biz/qqcircle/immersive/part/commentimage/QFSCommentImageInfo;", "e", "Lcom/tencent/biz/qqcircle/immersive/part/commentimage/QFSCommentImageInfo;", "imageInfo", "<init>", "(Lcom/tencent/qqnt/avatar/meta/refresh/c;Lcom/tencent/biz/qqcircle/immersive/part/commentimage/QFSCommentImageInfo;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class a extends ClickableSpan {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final com.tencent.qqnt.avatar.meta.refresh.c<b> weakListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final QFSCommentImageInfo imageInfo;

    public a(@Nullable com.tencent.qqnt.avatar.meta.refresh.c<b> cVar, @Nullable QFSCommentImageInfo qFSCommentImageInfo) {
        this.weakListener = cVar;
        this.imageInfo = qFSCommentImageInfo;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(@NotNull View widget) {
        FeedCloudMeta$StUser q16;
        com.tencent.qqnt.avatar.meta.refresh.c<b> cVar;
        b bVar;
        Intrinsics.checkNotNullParameter(widget, "widget");
        QFSCommentImageInfo qFSCommentImageInfo = this.imageInfo;
        if (qFSCommentImageInfo != null && (q16 = qFSCommentImageInfo.q()) != null && (cVar = this.weakListener) != null && (bVar = cVar.get()) != null) {
            bVar.L5(q16);
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(@NotNull TextPaint ds5) {
        Intrinsics.checkNotNullParameter(ds5, "ds");
        super.updateDrawState(ds5);
        ds5.setColor(Color.parseColor("#999999"));
        ds5.setUnderlineText(false);
    }
}
