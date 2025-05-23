package com.tencent.mobileqq.troop.troopnotification.render.richtext;

import android.view.View;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J0\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002H&J\b\u0010\t\u001a\u00020\bH&J \u0010\u000f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0006H&R\u0014\u0010\u0013\u001a\u00020\u00108&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/render/richtext/a;", "", "", "", "textData", "allData", "Lcom/tencent/mobileqq/troop/troopnotification/render/richtext/f;", "a", "", "isClickable", "Landroid/view/View;", "view", "Lcom/tencent/qqnt/notification/f;", "msg", "richText", "b", "", "getType", "()I", "type", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public interface a {
    @NotNull
    f a(@NotNull Map<String, ? extends Object> textData, @NotNull Map<String, ? extends Object> allData);

    boolean b(@NotNull View view, @NotNull com.tencent.qqnt.notification.f msg2, @NotNull f richText);

    int getType();

    boolean isClickable();
}
