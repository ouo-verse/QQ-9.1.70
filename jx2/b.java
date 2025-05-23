package jx2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.tvideo.net.utils.TVideoConfig;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b implements com.tencent.paysdk.api.d {
    @Override // com.tencent.paysdk.api.d
    @Nullable
    public String a() {
        return null;
    }

    @Override // com.tencent.paysdk.api.d
    @Nullable
    public String getGuid() {
        return TVideoConfig.f304492a.g();
    }

    @Override // com.tencent.paysdk.api.d
    @Nullable
    public String getPlatform() {
        return TVideoConfig.f304492a.h() + "";
    }

    @Override // com.tencent.paysdk.api.d
    @NonNull
    public String getQimei36() {
        return TVideoConfig.f304492a.k();
    }
}
