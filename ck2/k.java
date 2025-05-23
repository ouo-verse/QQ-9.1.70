package ck2;

import ak2.ac;
import com.tencent.mobileqq.qqvideoedit.zplan.parts.VideoEditExportGifPart;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016\u00a8\u0006\r"}, d2 = {"Lck2/k;", "Lck2/b;", "Lcom/tencent/mobileqq/qqvideoedit/editor/d;", "c", "a", "f", "Lck2/f;", "d", "e", "", "b", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class k implements b {
    @Override // ck2.b
    @NotNull
    public com.tencent.mobileqq.qqvideoedit.editor.d a() {
        return new zj2.f();
    }

    @Override // ck2.b
    @NotNull
    public List<com.tencent.mobileqq.qqvideoedit.editor.d> b() {
        List<com.tencent.mobileqq.qqvideoedit.editor.d> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.mobileqq.qqvideoedit.editor.d[]{new com.tencent.mobileqq.qqvideoedit.zplan.parts.c(), new com.tencent.mobileqq.qqvideoedit.zplan.parts.f()});
        return listOf;
    }

    @Override // ck2.b
    @NotNull
    public com.tencent.mobileqq.qqvideoedit.editor.d c() {
        return new ac();
    }

    @Override // ck2.b
    @NotNull
    public f d() {
        return new VideoEditExportGifPart();
    }

    @Override // ck2.b
    @NotNull
    public f e() {
        return new c();
    }

    @Override // ck2.b
    @Nullable
    public com.tencent.mobileqq.qqvideoedit.editor.d f() {
        return null;
    }
}
