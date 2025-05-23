package com.tencent.qfsmonet.process;

import android.opengl.EGLContext;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qfsmonet.api.IMonetTextureIdInterceptor;
import com.tencent.qfsmonet.api.MonetContext;
import com.tencent.qfsmonet.api.outputstream.OnNewPacketAvailableListener;
import com.tencent.qfsmonet.process.core.MonetProcessData;
import com.tencent.qfsmonet.process.core.MonetProcessParams;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface a {
    void a(@Nullable String str);

    void b(@NonNull ArrayList<MonetProcessData> arrayList);

    void c(@Nullable MonetProcessParams monetProcessParams);

    boolean d(@Nullable String str);

    void destroy();

    void e(Runnable runnable);

    void f(@Nullable OnNewPacketAvailableListener onNewPacketAvailableListener);

    MonetContext g(@Nullable EGLContext eGLContext);

    void setDestroyFlag();

    void setTextureIdInterceptor(IMonetTextureIdInterceptor iMonetTextureIdInterceptor);
}
