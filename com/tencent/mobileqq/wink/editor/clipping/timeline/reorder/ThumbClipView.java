package com.tencent.mobileqq.wink.editor.clipping.timeline.reorder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\u000e\u001a\u00020\tH\u0014J\b\u0010\u000f\u001a\u00020\tH\u0014J$\u0010\u0015\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016R\u0016\u0010\u0017\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0016\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/ThumbClipView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/f;", "", "uuid", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "path", "", "selectedStart", "", "setClipUrl", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/d;", "provider", "setThumbnailProvider", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "", "tag", "startTimeMs", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "a", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/d;", "thumbnailProvider", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyleAttrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class ThumbClipView extends AppCompatImageView implements com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.f {

    @NotNull
    public Map<Integer, View> C;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.d thumbnailProvider;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ThumbClipView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final String m(String uuid) {
        return "ThumbClipView" + uuid;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(ThumbClipView this$0, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Resources resources = this$0.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        this$0.setImageDrawable(new o(resources, bitmap));
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.f
    public void a(@Nullable Object tag, long startTimeMs, @Nullable final Bitmap bitmap) {
        if (bitmap != null && Intrinsics.areEqual(tag, getTag()) && !bitmap.isRecycled()) {
            post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.q
                @Override // java.lang.Runnable
                public final void run() {
                    ThumbClipView.o(ThumbClipView.this, bitmap);
                }
            });
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.thumbnailProvider.b(this);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.thumbnailProvider.c(this);
    }

    public final void setClipUrl(@NotNull String uuid, @NotNull String path, long selectedStart) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(path, "path");
        setTag(m(uuid));
        Bitmap bitmapByTime = this.thumbnailProvider.getBitmapByTime(selectedStart, getTag(), path);
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        setImageDrawable(new o(resources, bitmapByTime));
    }

    public final void setThumbnailProvider(@NotNull com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.d provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        this.thumbnailProvider = provider;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ThumbClipView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ThumbClipView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.C = new LinkedHashMap();
        this.thumbnailProvider = new com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.c();
    }

    public /* synthetic */ ThumbClipView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }
}
