package com.tencent.mobileqq.wink.picker.interceptor;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.wink.picker.MediaPickerInput;
import com.tencent.mobileqq.wink.picker.MediaPickerOutput;
import com.tencent.mobileqq.wink.picker.MediaPickerScene;
import com.tencent.mobileqq.wink.picker.interceptor.c;
import com.tencent.mobileqq.winkpublish.report.MediaPickerErrorCode;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 \n2\u00020\u0001:\u0001\u0016B5\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010$\u001a\u00020 \u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001f\u0010\n\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\bH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u001bR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001dR\u0014\u0010\f\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u001eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001fR\u0017\u0010$\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001d\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/wink/picker/interceptor/d;", "Lcom/tencent/mobileqq/wink/picker/interceptor/c$a;", "Lcom/tencent/mobileqq/wink/picker/interceptor/c;", "interceptor", "", "i", "", "index", "Lcom/tencent/mobileqq/wink/picker/a;", "mediaPickerOutput", "g", "(ILcom/tencent/mobileqq/wink/picker/a;)Lcom/tencent/mobileqq/wink/picker/interceptor/d;", "mediaPickerInput", "Lcom/tencent/mobileqq/wink/picker/b;", "f", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isRunning", "d", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "e", "Lcom/tencent/mobileqq/wink/picker/MediaPickerScene;", "a", "", "c", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/b;", "b", "Ljava/util/List;", "interceptors", "I", "Lcom/tencent/mobileqq/wink/picker/a;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "", "J", tl.h.F, "()J", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "calls", "<init>", "(Ljava/util/List;ILcom/tencent/mobileqq/wink/picker/a;Ljava/util/concurrent/atomic/AtomicBoolean;J)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class d implements c.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<c> interceptors;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int index;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MediaPickerInput mediaPickerInput;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean isRunning;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final long taskId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int calls;

    /* JADX WARN: Multi-variable type inference failed */
    public d(@NotNull List<? extends c> interceptors, int i3, @NotNull MediaPickerInput mediaPickerInput, @NotNull AtomicBoolean isRunning, long j3) {
        Intrinsics.checkNotNullParameter(interceptors, "interceptors");
        Intrinsics.checkNotNullParameter(mediaPickerInput, "mediaPickerInput");
        Intrinsics.checkNotNullParameter(isRunning, "isRunning");
        this.interceptors = interceptors;
        this.index = i3;
        this.mediaPickerInput = mediaPickerInput;
        this.isRunning = isRunning;
        this.taskId = j3;
    }

    private final void i(c interceptor) {
        MediaInterceptorMonitor mediaInterceptorMonitor = MediaInterceptorMonitor.f324886a;
        mediaInterceptorMonitor.i(interceptor.name());
        int i3 = this.index;
        if (i3 > 0) {
            c cVar = this.interceptors.get(i3 - 1);
            mediaInterceptorMonitor.h(cVar.name());
            w53.b.f("MediaInterceptorChain", cVar.name() + " cost " + mediaInterceptorMonitor.e(cVar.name()));
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.interceptor.c.a
    @NotNull
    public MediaPickerScene a() {
        return this.mediaPickerInput.getMediaPickerScene();
    }

    @Override // com.tencent.mobileqq.wink.picker.interceptor.c.a
    @NotNull
    public com.tencent.mobileqq.wink.picker.core.viewmodel.b b() {
        return this.mediaPickerInput.getNextStepUIStateViewModel();
    }

    @Override // com.tencent.mobileqq.wink.picker.interceptor.c.a
    public boolean c() {
        return this.mediaPickerInput.getVideoTemplateData().getUseVideoTemplate();
    }

    @Override // com.tencent.mobileqq.wink.picker.interceptor.c.a
    @NotNull
    /* renamed from: d, reason: from getter */
    public MediaPickerInput getMediaPickerInput() {
        return this.mediaPickerInput;
    }

    @Override // com.tencent.mobileqq.wink.picker.interceptor.c.a
    @NotNull
    public List<LocalMediaInfo> e() {
        return this.mediaPickerInput.j();
    }

    @Override // com.tencent.mobileqq.wink.picker.interceptor.c.a
    @NotNull
    public MediaPickerOutput f(@NotNull MediaPickerInput mediaPickerInput) throws InterruptedException {
        boolean z16;
        Intrinsics.checkNotNullParameter(mediaPickerInput, "mediaPickerInput");
        if (this.index < this.interceptors.size()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.calls++;
            d g16 = g(this.index + 1, mediaPickerInput);
            c cVar = this.interceptors.get(this.index);
            i(cVar);
            if (this.isRunning.get()) {
                MediaPickerOutput a16 = cVar.a(g16);
                if (a16 != null) {
                    if (!a16.f().isEmpty()) {
                        return a16;
                    }
                    throw new InterceptException(cVar.name(), new MediaPickerErrorCode(MediaPickerErrorCode.ERROR_CODE_EMPTY_SELECTED_MEDIA, null, 2, null));
                }
                throw new NullPointerException("interceptor " + cVar + " returned null");
            }
            throw new InterceptException(cVar.name(), new MediaPickerErrorCode(MediaPickerErrorCode.ERROR_CODE_USER_CANCEL, null, 2, null));
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @NotNull
    public final d g(int index, @NotNull MediaPickerInput mediaPickerOutput) {
        Intrinsics.checkNotNullParameter(mediaPickerOutput, "mediaPickerOutput");
        return new d(this.interceptors, index, mediaPickerOutput, this.isRunning, this.taskId);
    }

    /* renamed from: h, reason: from getter */
    public final long getTaskId() {
        return this.taskId;
    }

    @Override // com.tencent.mobileqq.wink.picker.interceptor.c.a
    @NotNull
    /* renamed from: isRunning, reason: from getter */
    public AtomicBoolean getIsRunning() {
        return this.isRunning;
    }
}
