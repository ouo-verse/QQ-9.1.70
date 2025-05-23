package com.tencent.mobileqq.qqecommerce.biz.nv.api;

import android.content.Context;
import android.view.View;
import androidx.annotation.WorkerThread;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u000fJ\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH'J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/nv/api/INVViewModel;", "", "getNVView", "Landroid/view/View;", "context", "Landroid/content/Context;", "init", "", "domJSON", "Lorg/json/JSONObject;", NodeProps.MAX_WIDTH, "", "skinType", "Lcom/tencent/mobileqq/qqecommerce/biz/nv/api/INVViewModel$SkinType;", "updateNVViewSkin", "SkinType", "qqecommerce-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public interface INVViewModel {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void init$default(INVViewModel iNVViewModel, JSONObject jSONObject, float f16, SkinType skinType, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    skinType = SkinType.DEFAULT;
                }
                iNVViewModel.init(jSONObject, f16, skinType);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: init");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/nv/api/INVViewModel$SkinType;", "", "value", "", "(Ljava/lang/String;II)V", "DEFAULT", "NIGHT", "qqecommerce-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public enum SkinType {
        DEFAULT(0),
        NIGHT(1);

        SkinType(int i3) {
        }
    }

    @Nullable
    View getNVView(@Nullable Context context);

    @WorkerThread
    void init(@NotNull JSONObject domJSON, float maxWidth, @NotNull SkinType skinType);

    void updateNVViewSkin(@NotNull SkinType skinType);
}
