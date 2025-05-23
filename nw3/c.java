package nw3;

import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0001H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH&J\n\u0010\f\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\r\u001a\u00020\u0005H&J5\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2#\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\n\u0018\u00010\u0010H&\u00a8\u0006\u0017"}, d2 = {"Lnw3/c;", "Lnw3/a;", "c", "Landroid/widget/ImageView;", "d", "", "f", "getPendantView", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "e", "b", "g", "", "tag", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "listenerCb", "a", "chats_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface c extends nw3.a {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes24.dex */
    public static final class a {
        @NotNull
        public static ImageView a(@NotNull c cVar) {
            return cVar.c().getAvatarView();
        }
    }

    void a(@NotNull String tag, @Nullable Function1<? super View, Unit> listenerCb);

    @Nullable
    ImageView b();

    @NotNull
    nw3.a c();

    @Nullable
    ImageView d();

    void e(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.b item);

    boolean f();

    boolean g();

    @NotNull
    ImageView getPendantView();
}
