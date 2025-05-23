package com.tencent.mobileqq.wink.lowthresholdltemplate;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.lowthresholdltemplate.p;
import com.tencent.tavcut.core.session.ICutSession;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0013\u0010\u0003\u001a\u00020\u0002H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004J#\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJ1\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b0\r2\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u000bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0017\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/wink/lowthresholdltemplate/r;", "", "", "d", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/wink/lowthresholdltemplate/p$c;", "templateConfig", "", "", "b", "(Lcom/tencent/mobileqq/wink/lowthresholdltemplate/p$c;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "qzoneFrom", "Lkotlin/Pair;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "a", "(Lcom/tencent/mobileqq/wink/lowthresholdltemplate/p$c;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/tavcut/core/session/ICutSession;", SessionDbHelper.SESSION_ID, "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;", "editDataWrapper", "", "coverTimeUs", "c", "(Lcom/tencent/tavcut/core/session/ICutSession;Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface r {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class a {
        public static /* synthetic */ Object a(r rVar, p.TemplateConfig templateConfig, boolean z16, Continuation continuation, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = false;
                }
                return rVar.a(templateConfig, z16, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: downloadMaterial");
        }
    }

    @Nullable
    Object a(@NotNull p.TemplateConfig templateConfig, boolean z16, @NotNull Continuation<? super Pair<MetaMaterial, Boolean>> continuation);

    @Nullable
    Object b(@NotNull p.TemplateConfig templateConfig, @NotNull Continuation<? super List<String>> continuation);

    @Nullable
    Object c(@NotNull ICutSession iCutSession, @NotNull WinkEditDataWrapper winkEditDataWrapper, long j3, @NotNull Continuation<? super String> continuation);

    @Nullable
    Object d(@NotNull Continuation<? super Unit> continuation);
}
