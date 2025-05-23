package om1;

import android.text.Editable;
import android.util.SparseArray;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import fm1.i;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0003\u001a\u00020\u0002J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0007R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\tR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lom1/b;", "", "Landroid/text/Editable;", "a", "", "Lfm1/i;", "b", "Landroid/text/Editable;", "mEditable", "Ljava/util/List;", "mMediaList", "Landroid/util/SparseArray;", "c", "Landroid/util/SparseArray;", DTParamKey.REPORT_KEY_VISUAL_ELEMENTS, "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Editable mEditable;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<i> mMediaList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SparseArray<Object> elements;

    public b() {
        Editable newEditable = Editable.Factory.getInstance().newEditable("");
        Intrinsics.checkNotNullExpressionValue(newEditable, "getInstance().newEditable(\"\")");
        this.mEditable = newEditable;
        this.mMediaList = new ArrayList();
        this.elements = new SparseArray<>();
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final Editable getMEditable() {
        return this.mEditable;
    }

    @NotNull
    public final List<i> b() {
        return this.mMediaList;
    }
}
