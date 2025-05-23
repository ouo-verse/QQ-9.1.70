package com.tencent.mobileqq.filebrowser.richmedia.share;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.filebrowser.richmedia.share.FileShareActionManager;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&J\b\u0010\u000e\u001a\u00020\rH&J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH&R\u001b\u0010\u0016\u001a\u00020\u00128FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/filebrowser/richmedia/share/FileAbsShareAction;", "", "Lcom/tencent/mobileqq/filebrowser/richmedia/share/m;", "shareContext", "", "e", "d", NodeProps.VISIBLE, "", "f", "", "", "c", "Lcom/tencent/mobileqq/filebrowser/richmedia/share/FileShareActionManager$ShareLine;", "b", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "a", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Lazy;", "getMainScope", "()Lkotlinx/coroutines/CoroutineScope;", "mainScope", "<init>", "()V", "qqfile-filebrowser-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public abstract class FileAbsShareAction {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mainScope;

    public FileAbsShareAction() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<CoroutineScope>() { // from class: com.tencent.mobileqq.filebrowser.richmedia.share.FileAbsShareAction$mainScope$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CoroutineScope invoke() {
                return CoroutineScopeKt.MainScope();
            }
        });
        this.mainScope = lazy;
    }

    public abstract void a(@NotNull FileShareContext shareContext, @NotNull ShareActionSheetBuilder.ActionSheetItem item);

    @NotNull
    public abstract FileShareActionManager.ShareLine b();

    @NotNull
    public abstract List<Integer> c();

    public boolean d() {
        return true;
    }

    public boolean e(@NotNull FileShareContext shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        return true;
    }

    public void f(@NotNull FileShareContext shareContext, boolean visible) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
    }
}
