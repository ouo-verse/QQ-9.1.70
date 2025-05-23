package com.tencent.mobileqq.wink.picker.core;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.wink.picker.Config;
import com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerChildFragment;
import com.tencent.mobileqq.wink.picker.core.universal.UniversalMediaPickerFactory;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b,\u0010-J\u0012\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0004J\f\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002R$\u0010\u0010\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\r0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001b\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\u0011\u0010\u001d\u001a\u00020\u00118F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u0014R\u0011\u0010 \u001a\u00020\u001e8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u001fR\u0013\u0010$\u001a\u0004\u0018\u00010!8F\u00a2\u0006\u0006\u001a\u0004\b\"\u0010#R\u0011\u0010(\u001a\u00020%8F\u00a2\u0006\u0006\u001a\u0004\b&\u0010'R\u0011\u0010+\u001a\u00020)8F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010*\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/c;", "", "Lcom/tencent/mobileqq/wink/picker/core/WinkMediaPickerMainBaseFragment;", "fragment", "", "j", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/wink/picker/core/fragment/WinkMediaPickerChildFragment;", "childFragment", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "f", "", "Ljava/lang/ref/WeakReference;", "b", "Ljava/util/List;", "stack", "", "c", "Z", "()Z", "k", "(Z)V", "inNewIndexActivity", "d", "g", "l", "isShowMemoryAlbum", tl.h.F, "isSingleSelectMode", "Lcom/tencent/mobileqq/wink/picker/Config;", "()Lcom/tencent/mobileqq/wink/picker/Config;", DownloadInfo.spKey_Config, "", "a", "()Ljava/lang/String;", PreDownloadConstants.RPORT_KEY_BUSINESS_NAME, "Lcom/tencent/mobileqq/wink/picker/core/d;", "e", "()Lcom/tencent/mobileqq/wink/picker/core/d;", "mediaPickerFactory", "Lcom/tencent/mobileqq/wink/picker/core/a;", "()Lcom/tencent/mobileqq/wink/picker/core/a;", "mediaItemClickListener", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f324480a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<WeakReference<WinkMediaPickerMainBaseFragment<?>>> stack = new ArrayList();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean inNewIndexActivity;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static boolean isShowMemoryAlbum;

    c() {
    }

    @Nullable
    public final String a() {
        WinkMediaPickerMainBaseFragment<?> f16 = f();
        if (f16 == null) {
            return "";
        }
        return f16.Mh();
    }

    @NotNull
    public final Config b() {
        WinkMediaPickerMainBaseFragment<?> f16 = f();
        if (f16 == null) {
            Config.Companion companion = Config.INSTANCE;
            return new Config.a().a();
        }
        return f16.Nh();
    }

    public final boolean c() {
        return inNewIndexActivity;
    }

    @NotNull
    public final a d() {
        return e().a();
    }

    @NotNull
    public final d e() {
        WinkMediaPickerMainBaseFragment<?> f16 = f();
        if (f16 == null) {
            return new UniversalMediaPickerFactory(false);
        }
        return f16.Rh();
    }

    @Nullable
    public final WinkMediaPickerMainBaseFragment<?> f() {
        Object m476constructorimpl;
        Object last;
        List<WeakReference<WinkMediaPickerMainBaseFragment<?>>> list = stack;
        Object obj = null;
        if (list.isEmpty()) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) list);
            m476constructorimpl = Result.m476constructorimpl((WinkMediaPickerMainBaseFragment) ((WeakReference) last).get());
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (!Result.m482isFailureimpl(m476constructorimpl)) {
            obj = m476constructorimpl;
        }
        return (WinkMediaPickerMainBaseFragment) obj;
    }

    public final boolean g() {
        return isShowMemoryAlbum;
    }

    public final boolean h() {
        return e().getSingleSelectMode();
    }

    public final void i(@NotNull WinkMediaPickerChildFragment childFragment) {
        Intrinsics.checkNotNullParameter(childFragment, "childFragment");
        WinkMediaPickerMainBaseFragment<?> f16 = f();
        if (f16 != null) {
            f16.ki(childFragment);
        }
    }

    public final void j(@NotNull WinkMediaPickerMainBaseFragment<?> fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        stack.add(new WeakReference<>(fragment));
    }

    public final void k(boolean z16) {
        inNewIndexActivity = z16;
    }

    public final void l(boolean z16) {
        isShowMemoryAlbum = z16;
    }

    public final void m() {
        e().e(!e().getSingleSelectMode());
    }

    public final void n(@NotNull WinkMediaPickerMainBaseFragment<?> fragment) {
        Object obj;
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Iterator<T> it = stack.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((WeakReference) obj).get(), fragment)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        WeakReference weakReference = (WeakReference) obj;
        if (weakReference != null) {
            stack.remove(weakReference);
        }
    }
}
