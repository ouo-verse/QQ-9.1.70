package com.tencent.mobileqq.gamecenter.qa.metadream;

import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.mobileqq.app.FrameFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\b\u0010\n\u001a\u0004\u0018\u00010\u0007R\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\fR\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/metadream/a;", "", "Lcom/tencent/mobileqq/app/FrameFragment;", "frameFragment", "", "d", "b", "Lcom/tencent/mobileqq/gamecenter/qa/metadream/MetaDreamFrame;", AIInput.KEY_FRAME, "c", "a", "Lmqq/util/WeakReference;", "Lmqq/util/WeakReference;", "mFrameFragmentRef", "mMetaDreamFrameRef", "<init>", "()V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f212593a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static WeakReference<FrameFragment> mFrameFragmentRef;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static WeakReference<MetaDreamFrame> mMetaDreamFrameRef;

    a() {
    }

    @Nullable
    public final MetaDreamFrame a() {
        WeakReference<MetaDreamFrame> weakReference = mMetaDreamFrameRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Nullable
    public final FrameFragment b() {
        WeakReference<FrameFragment> weakReference = mFrameFragmentRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final void c(@NotNull MetaDreamFrame frame) {
        Intrinsics.checkNotNullParameter(frame, "frame");
        mMetaDreamFrameRef = new WeakReference<>(frame);
    }

    public final void d(@NotNull FrameFragment frameFragment) {
        Intrinsics.checkNotNullParameter(frameFragment, "frameFragment");
        mFrameFragmentRef = new WeakReference<>(frameFragment);
    }
}
