package com.tencent.mobileqq.qqvideoedit.zplan.export;

import android.content.Context;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.qphone.base.util.QLog;
import ik2.GifClipData;
import ik2.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0016\u0018\u0000 \u00172\u00020\u0001:\u0001\tB\u0019\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0015\u001a\u00020\u0011\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0004R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\f8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0015\u001a\u00020\u00118\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R$\u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/zplan/export/b;", "Lcom/tencent/mobileqq/qqvideoedit/zplan/export/a;", "", "d", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", QAdVrReportParams.ParamKey.MEDIA, "Lik2/d;", "clipData", "c", "a", "b", h.F, "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lik2/h;", "Lik2/h;", "getCallback", "()Lik2/h;", "callback", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "e", "()Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "g", "(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)V", "exportedVideo", "Lik2/d;", "getClipData", "()Lik2/d;", "f", "(Lik2/d;)V", "<init>", "(Landroid/content/Context;Lik2/h;)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public class b implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ik2.h callback;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LocalMediaInfo exportedVideo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GifClipData clipData;

    public b(@Nullable Context context, @NotNull ik2.h callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.context = context;
        this.callback = callback;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.zplan.export.a
    public void c(@Nullable LocalMediaInfo media, @Nullable GifClipData clipData) {
        this.exportedVideo = media;
        this.clipData = clipData;
        h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: e, reason: from getter */
    public final LocalMediaInfo getExportedVideo() {
        return this.exportedVideo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void f(@Nullable GifClipData gifClipData) {
        this.clipData = gifClipData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void g(@Nullable LocalMediaInfo localMediaInfo) {
        this.exportedVideo = localMediaInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void h() {
        LocalMediaInfo localMediaInfo = this.exportedVideo;
        GifClipData gifClipData = this.clipData;
        Context context = this.context;
        if (context != null && localMediaInfo != null && gifClipData != null) {
            g.f407918a.i(context, localMediaInfo, this.callback, gifClipData, 15);
            return;
        }
        QLog.e("VideoEditGifExportTask", 1, "startExportGif failed: context=" + context + ", info=" + localMediaInfo + ", clipData=" + gifClipData);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.zplan.export.a
    public void a() {
    }

    @Override // com.tencent.mobileqq.qqvideoedit.zplan.export.a
    public void b() {
    }

    @Override // com.tencent.mobileqq.qqvideoedit.zplan.export.a
    public void d() {
    }
}
