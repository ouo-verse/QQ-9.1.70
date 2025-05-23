package com.tencent.mobileqq.troop.file.data;

import android.app.Activity;
import com.tencent.mobileqq.vas.api.RemoteProxy;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0006H&J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\tH&J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0004H&J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0004H&J\b\u0010\u0012\u001a\u00020\u0006H&J\b\u0010\u0013\u001a\u00020\u0006H&J\b\u0010\u0014\u001a\u00020\u0006H&J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\tH&\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/troop/file/data/c;", "Lcom/tencent/mobileqq/troop/file/data/b;", "Landroid/app/Activity;", "getActivity", "", "loadingOver", "", "Z2", "V", "", RemoteProxy.KEY_RESULT_TYPE, "f4", "headViewEnum", "I3", "isLoading", "loadingProgress", "show", "I5", "q8", "P2", "u0", "visibility", "L7", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public interface c extends b {
    void I3(int headViewEnum);

    void I5(boolean show);

    void L7(int visibility);

    void P2();

    void V();

    void Z2(boolean loadingOver);

    void f4(int resultType);

    Activity getActivity();

    void loadingProgress(boolean isLoading);

    void q8();

    void u0();
}
