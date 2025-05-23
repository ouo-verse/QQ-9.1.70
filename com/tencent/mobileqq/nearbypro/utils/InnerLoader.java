package com.tencent.mobileqq.nearbypro.utils;

import android.widget.ImageView;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.nearbypro.base.ILog;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.BaseApplication;
import fu4.v;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010!\u001a\u00020\u001c\u0012\b\u0010'\u001a\u0004\u0018\u00010\"\u00a2\u0006\u0004\b+\u0010,J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010\u000b\u001a\u00020\u0006*\u00020\b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0014\u0010\r\u001a\u00020\f*\u00020\b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\f\u0010\u0010\u001a\u00020\u0004*\u00020\tH\u0002J\u0006\u0010\u0011\u001a\u00020\u0006J\u0006\u0010\u0012\u001a\u00020\u0006R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\n\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010!\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0019\u0010'\u001a\u0004\u0018\u00010\"8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010(R\u0014\u0010*\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010$\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/utils/InnerLoader;", "", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "l", "", "url", "", "p", "Landroid/widget/ImageView;", "Lfu4/v;", "indexNode", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", DomainData.DOMAIN_NAME, "customKey", "j", "e", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "Landroid/widget/ImageView;", "i", "()Landroid/widget/ImageView;", "targetView", "b", "Lfu4/v;", "f", "()Lfu4/v;", "Lcom/tencent/libra/request/Option;", "c", "Lcom/tencent/libra/request/Option;", tl.h.F, "()Lcom/tencent/libra/request/Option;", "option", "Lcom/tencent/libra/listener/IPicLoadStateListener;", "d", "Lcom/tencent/libra/listener/IPicLoadStateListener;", "g", "()Lcom/tencent/libra/listener/IPicLoadStateListener;", "listener", "Ljava/lang/String;", "logPrefix", "picLoadListener", "<init>", "(Landroid/widget/ImageView;Lfu4/v;Lcom/tencent/libra/request/Option;Lcom/tencent/libra/listener/IPicLoadStateListener;)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class InnerLoader {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final ImageView targetView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final v indexNode;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Option option;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final IPicLoadStateListener listener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String logPrefix;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IPicLoadStateListener picLoadListener;

    public InnerLoader(@Nullable ImageView imageView, @NotNull v indexNode, @NotNull Option option, @Nullable IPicLoadStateListener iPicLoadStateListener) {
        AtomicInteger atomicInteger;
        int i3;
        Intrinsics.checkNotNullParameter(indexNode, "indexNode");
        Intrinsics.checkNotNullParameter(option, "option");
        this.targetView = imageView;
        this.indexNode = indexNode;
        this.option = option;
        this.listener = iPicLoadStateListener;
        atomicInteger = q.f253960a;
        int andIncrement = atomicInteger.getAndIncrement();
        if (imageView != null) {
            i3 = imageView.hashCode();
        } else {
            i3 = 0;
        }
        this.logPrefix = "seq:" + andIncrement + " view:" + (i3 % 10000) + " ";
        this.picLoadListener = new IPicLoadStateListener() { // from class: com.tencent.mobileqq.nearbypro.utils.j
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option2) {
                InnerLoader.o(InnerLoader.this, loadState, option2);
            }
        };
    }

    private final String e(v vVar) {
        String str;
        String absolutePath = BaseApplication.getContext().getCacheDir().getAbsolutePath();
        String str2 = File.separator;
        fu4.s sVar = vVar.f400818a;
        if (sVar != null) {
            str = sVar.f400804b;
        } else {
            str = null;
        }
        if (str == null) {
            str = String.valueOf(Random.INSTANCE.nextInt());
        }
        return absolutePath + str2 + str;
    }

    private final String j(String customKey) {
        String picLocalPath = com.tencent.mobileqq.nearbypro.base.j.f().a().getPicLocalPath(Option.obtain().setUrl(customKey));
        Intrinsics.checkNotNullExpressionValue(picLocalPath, "NBPPicLoader.extInterfac\u2026tain().setUrl(customKey))");
        return picLocalPath;
    }

    private final com.tencent.mobileqq.qcoroutine.api.coroutine.b l() {
        return CorountineFunKt.e(fa2.a.c(), "loadWithNet", null, null, null, new InnerLoader$loadWithNet$1(this, null), 14, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean n(ImageView imageView, v vVar) {
        return !Intrinsics.areEqual(imageView.getTag(R.id.zop), vVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(InnerLoader this$0, LoadState state, Option option) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(option, "option");
        CorountineFunKt.e(fa2.a.b(), "picLoadListener", null, null, null, new InnerLoader$picLoadListener$1$1(state, this$0, option, null), 14, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(String url) {
        this.option.setUrl(url);
        ILog.Level level = ILog.Level.INFO;
        com.tencent.mobileqq.nearbypro.base.j.c().b("StImageLoader", level, this.logPrefix + ((Object) ("realLoadImage url:" + getOption().getUrl())));
        com.tencent.mobileqq.nearbypro.base.j.f().b(this.option, this.picLoadListener);
    }

    private final void q(ImageView imageView, v vVar) {
        imageView.setTag(R.id.zop, vVar);
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final v getIndexNode() {
        return this.indexNode;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final IPicLoadStateListener getListener() {
        return this.listener;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final Option getOption() {
        return this.option;
    }

    @Nullable
    /* renamed from: i, reason: from getter */
    public final ImageView getTargetView() {
        return this.targetView;
    }

    public final void k() {
        ILog.Level level = ILog.Level.INFO;
        com.tencent.mobileqq.nearbypro.base.j.c().b("StImageLoader", level, this.logPrefix + ((Object) ("load indexNode:" + com.tencent.mobileqq.nearbypro.request.c.e(com.tencent.mobileqq.nearbypro.request.c.c(getIndexNode())))));
        this.option.setLocalPath(j(e(this.indexNode)));
        ImageView imageView = this.targetView;
        if (imageView != null) {
            q(imageView, this.indexNode);
        }
        String localPath = this.option.getLocalPath();
        Intrinsics.checkNotNullExpressionValue(localPath, "option.localPath");
        if (r.a(localPath)) {
            String localPath2 = this.option.getLocalPath();
            Intrinsics.checkNotNullExpressionValue(localPath2, "option.localPath");
            p(localPath2);
        } else {
            ImageView imageView2 = this.targetView;
            if (imageView2 != null) {
                imageView2.setImageDrawable(this.option.getLoadingDrawable());
            }
            l();
        }
    }

    public final void m() {
        ILog.Level level = ILog.Level.INFO;
        com.tencent.mobileqq.nearbypro.base.j.c().b("StImageLoader", level, this.logPrefix + ((Object) ("load indexNode:" + com.tencent.mobileqq.nearbypro.request.c.e(com.tencent.mobileqq.nearbypro.request.c.c(getIndexNode())))));
        this.option.setLocalPath(j(e(this.indexNode)));
        String localPath = this.option.getLocalPath();
        Intrinsics.checkNotNullExpressionValue(localPath, "option.localPath");
        if (r.a(localPath)) {
            String localPath2 = this.option.getLocalPath();
            Intrinsics.checkNotNullExpressionValue(localPath2, "option.localPath");
            p(localPath2);
            return;
        }
        l();
    }
}
