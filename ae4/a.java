package ae4;

import com.tencent.tavcut.rendermodel.RenderModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J.\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006H&\u00a8\u0006\u000b"}, d2 = {"Lae4/a;", "", "", "templatePath", "Lcom/tencent/tavcut/rendermodel/RenderModel;", "renderModel", "", "isInit", "isUE4Template", "Lae4/c;", "a", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public interface a {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* renamed from: ae4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static final class C0030a {
        public static /* synthetic */ MediaBuilderOutput a(a aVar, String str, RenderModel renderModel, boolean z16, boolean z17, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    z16 = false;
                }
                if ((i3 & 8) != 0) {
                    z17 = false;
                }
                return aVar.a(str, renderModel, z16, z17);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildComposition");
        }
    }

    @Nullable
    MediaBuilderOutput a(@NotNull String templatePath, @NotNull RenderModel renderModel, boolean isInit, boolean isUE4Template);
}
