package com.tencent.aio.api.list;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import at.b;
import com.tencent.aio.base.mvi.part.MsgListUiState;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u00020\u0005J \u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&J\b\u0010\u000e\u001a\u00020\rH&J\u001f\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00028\u00012\u0006\u0010\u000b\u001a\u00020\nH&\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0014\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0012H&J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nH&\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/aio/api/list/j;", "Lat/b;", "I", "Lcom/tencent/aio/base/mvi/part/MsgListUiState;", ExifInterface.LATITUDE_SOUTH, "", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "childView", "Lcom/tencent/aio/api/list/IListUIOperationApi;", "uiHelper", "T0", "", "S0", "state", "u0", "(Lcom/tencent/aio/base/mvi/part/MsgListUiState;Lcom/tencent/aio/api/list/IListUIOperationApi;)V", "Lcom/tencent/aio/base/mvvm/b;", "F0", "p", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public interface j<I extends at.b, S extends MsgListUiState> {
    @NotNull
    com.tencent.aio.base.mvvm.b<I, S> F0();

    void S0();

    @NotNull
    View T0(@NotNull com.tencent.mvi.api.help.a createViewParams, @NotNull View childView, @NotNull IListUIOperationApi uiHelper);

    void p(@NotNull IListUIOperationApi uiHelper);

    void u0(@NotNull S state, @NotNull IListUIOperationApi uiHelper);
}
