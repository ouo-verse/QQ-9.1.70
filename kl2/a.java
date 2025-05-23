package kl2;

import com.tencent.mobileqq.qwallet.preload.IPreloadResource;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public interface a {
    void deleteResFromLocal();

    String getBaseUrl();

    String getName();

    List<IPreloadResource> getResApiList();

    boolean resDownloaded();
}
