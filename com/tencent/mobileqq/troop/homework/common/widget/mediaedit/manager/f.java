package com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager;

import android.app.Activity;
import androidx.lifecycle.LiveData;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.BaseItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.h;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qs2.a;
import qs2.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0014\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H&J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0003H&R\u0014\u0010\u000b\u001a\u00020\b8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\b8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0014\u0010\u000f\u001a\u00020\b8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\nR\u0014\u0010\u0011\u001a\u00020\b8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\nR\u0014\u0010\u0013\u001a\u00020\b8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\nR\u0014\u0010\u0015\u001a\u00020\b8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\n\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/manager/f;", "Lqs2/a;", "Lqs2/c;", "Landroidx/lifecycle/LiveData;", "", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/BaseItem;", "p", "t", "", "o", "()I", "imgOrVideoNumLimit", "g", "audioNumLimit", "v", "fileNumLimit", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "canAddImgOrVideoSize", "u", "canAddAudioSize", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "canAddFileSize", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public interface f extends qs2.a, qs2.c {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class a {
        public static void a(@NotNull f fVar, @Nullable Activity activity) {
            a.C11097a.a(fVar, activity);
        }

        public static void b(@NotNull f fVar, @NotNull BaseItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            a.C11097a.b(fVar, item);
        }

        public static void c(@NotNull f fVar, @NotNull com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.a data) {
            Intrinsics.checkNotNullParameter(data, "data");
            c.a.a(fVar, data);
        }

        public static void d(@NotNull f fVar, @NotNull com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.b result) {
            Intrinsics.checkNotNullParameter(result, "result");
            c.a.b(fVar, result);
        }

        public static void e(@NotNull f fVar, @NotNull List<com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.f> data) {
            Intrinsics.checkNotNullParameter(data, "data");
            c.a.c(fVar, data);
        }

        public static void f(@NotNull f fVar, @NotNull List<h> data) {
            Intrinsics.checkNotNullParameter(data, "data");
            c.a.d(fVar, data);
        }

        public static void g(@NotNull f fVar, int i3) {
            a.C11097a.c(fVar, i3);
        }

        public static void h(@NotNull f fVar, @NotNull BaseItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            a.C11097a.d(fVar, item);
        }
    }

    int g();

    int o();

    @NotNull
    LiveData<List<BaseItem>> p();

    int q();

    @NotNull
    LiveData<BaseItem> t();

    int u();

    int v();

    int z();
}
