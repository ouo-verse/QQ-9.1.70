package bs2;

import com.tencent.qqnt.kernel.nativeinterface.VoiceItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lbs2/a;", "Lzv3/a;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/VoiceItem;", "a", "Ljava/util/List;", "()Ljava/util/List;", "voiceList", "<init>", "(Ljava/util/List;)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a implements zv3.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final List<VoiceItem> voiceList;

    public a(List<VoiceItem> voiceList) {
        Intrinsics.checkNotNullParameter(voiceList, "voiceList");
        this.voiceList = voiceList;
    }

    public final List<VoiceItem> a() {
        return this.voiceList;
    }
}
