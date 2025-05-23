package com.tencent.qqnt.emotion.adapter.api;

import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B-\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0010\u00a2\u0006\u0004\b\u0017\u0010\u0018R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR.\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/emotion/adapter/api/a;", "", "Lcom/tencent/mobileqq/emoticonview/IPicEmoticonInfo;", "a", "Lcom/tencent/mobileqq/emoticonview/IPicEmoticonInfo;", "()Lcom/tencent/mobileqq/emoticonview/IPicEmoticonInfo;", "setEmoticonInfo", "(Lcom/tencent/mobileqq/emoticonview/IPicEmoticonInfo;)V", "emoticonInfo", "", "b", "I", "()I", "setJobType", "(I)V", "jobType", "Lkotlin/Pair;", "c", "Lkotlin/Pair;", "()Lkotlin/Pair;", "setSize", "(Lkotlin/Pair;)V", "size", "<init>", "(Lcom/tencent/mobileqq/emoticonview/IPicEmoticonInfo;ILkotlin/Pair;)V", "emotion_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IPicEmoticonInfo emoticonInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int jobType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Pair<Integer, Integer> size;

    public a(@Nullable IPicEmoticonInfo iPicEmoticonInfo, int i3, @NotNull Pair<Integer, Integer> size) {
        Intrinsics.checkNotNullParameter(size, "size");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, iPicEmoticonInfo, Integer.valueOf(i3), size);
            return;
        }
        this.emoticonInfo = iPicEmoticonInfo;
        this.jobType = i3;
        this.size = size;
    }

    @Nullable
    public final IPicEmoticonInfo a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IPicEmoticonInfo) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.emoticonInfo;
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.jobType;
    }

    @NotNull
    public final Pair<Integer, Integer> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Pair) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.size;
    }
}
