package com.tencent.mobileqq.guild.feed.video;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\u0007B\u0015\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0006R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\fR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/video/h;", "", "Landroid/content/Context;", "context", "", "b", "", "a", "c", "d", "", "Lcom/tencent/mobileqq/guild/feed/video/f;", "Ljava/util/List;", "guideList", "Lcom/tencent/mobileqq/guild/feed/video/f;", "matchedGuide", "<init>", "(Ljava/util/List;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<f> guideList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private f matchedGuide;

    /* JADX WARN: Multi-variable type inference failed */
    public h(@NotNull List<? extends f> guideList) {
        Intrinsics.checkNotNullParameter(guideList, "guideList");
        this.guideList = guideList;
    }

    private final String b(Context context) {
        CharSequence trim;
        String replace$default;
        CharSequence text;
        String obj;
        Object systemService = context.getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ClipData primaryClip = ClipboardMonitor.getPrimaryClip((ClipboardManager) systemService);
        String str = "";
        if (primaryClip == null || primaryClip.getItemCount() == 0) {
            return "";
        }
        ClipData.Item itemAt = primaryClip.getItemAt(0);
        if (itemAt != null && (text = itemAt.getText()) != null && (obj = text.toString()) != null) {
            str = obj;
        }
        trim = StringsKt__StringsKt.trim((CharSequence) str);
        replace$default = StringsKt__StringsJVMKt.replace$default(trim.toString(), "\n", "", false, 4, (Object) null);
        return replace$default;
    }

    public final void a(@Nullable Context context) {
        if (context == null) {
            QLog.i("ShortFeedLinkCheckAndGuideProcessor", 1, "checkAndGuide context == null");
            return;
        }
        String b16 = b(context);
        QLog.i("ShortFeedLinkCheckAndGuideProcessor", 1, "checkAndGuide clipContentStr=" + b16);
        for (f fVar : this.guideList) {
            if (fVar.match(b16)) {
                this.matchedGuide = fVar;
                fVar.a(fVar.b(b16));
                return;
            }
        }
    }

    public final void c() {
        f fVar = this.matchedGuide;
        if (fVar != null) {
            fVar.dismiss();
        }
    }

    public final void d() {
        QLog.i("ShortFeedLinkCheckAndGuideProcessor", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        c();
    }
}
