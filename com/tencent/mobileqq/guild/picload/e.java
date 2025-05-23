package com.tencent.mobileqq.guild.picload;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.PageHierarchy;
import com.tencent.libra.IPicLoader;
import com.tencent.libra.LibraPicLoaderFactory;
import com.tencent.libra.LoadState;
import com.tencent.libra.cache.ICache;
import com.tencent.libra.cache.i;
import com.tencent.libra.decode.LibraRequestKey;
import com.tencent.libra.extension.gif.h;
import com.tencent.libra.listener.ILoaderResultListener;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.IpConnectConfig;
import com.tencent.libra.request.Option;
import com.tencent.libra.resource.IResourceDrawableFactory;
import com.tencent.libra.strategy.ILibraLibraryStrategy;
import com.tencent.libra.thread.ITaskExecutor;
import com.tencent.mobileqq.qcircle.picload.listener.RFWPicLoaderResultListener;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes14.dex */
public class e {

    /* renamed from: b, reason: collision with root package name */
    private static volatile e f231090b;

    /* renamed from: c, reason: collision with root package name */
    private static final Map<String, String> f231091c = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    private final IPicLoader f231092a = LibraPicLoaderFactory.getPicLoader(new a());

    /* compiled from: P */
    /* loaded from: classes14.dex */
    private static class a implements ILibraLibraryStrategy {

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.guild.picload.e$a$a, reason: collision with other inner class name */
        /* loaded from: classes14.dex */
        class C7861a implements com.tencent.libra.cache.c {
            C7861a() {
            }

            @Override // com.tencent.libra.cache.c
            @NonNull
            public Business getBusiness(@Nullable Option option) {
                return Business.Guild;
            }

            @Override // com.tencent.libra.cache.c
            public /* synthetic */ PageHierarchy getSubBusiness(Option option) {
                return com.tencent.libra.cache.b.b(this, option);
            }
        }

        a() {
        }

        @Override // com.tencent.libra.strategy.ILibraLibraryStrategy
        public String getBusinessName() {
            return "guild";
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public ICache getCustomCache() {
            return new i(new C7861a());
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public List<r01.a<?>> getCustomDecoder() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new h());
            arrayList.add(new z01.b());
            arrayList.add(new com.tencent.libra.extension.avif.b());
            return arrayList;
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public /* synthetic */ List getCustomDownloaders() {
            return g11.a.c(this);
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public /* synthetic */ IResourceDrawableFactory getDrawableFactory() {
            return g11.a.d(this);
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public ILoaderResultListener getGlobalResultListener() {
            return new RFWPicLoaderResultListener("4");
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public /* synthetic */ IpConnectConfig getIpConnectConfig(String str) {
            return g11.a.f(this, str);
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public /* synthetic */ w01.a getLibraIpStrategyBean() {
            return g11.a.g(this);
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public /* synthetic */ ITaskExecutor getTaskExecutor() {
            return g11.a.h(this);
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        @NonNull
        public String getUniKeyFromUrl(@NonNull String str) {
            return e.d(str);
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public /* synthetic */ Boolean isSupportActiveResources() {
            return g11.a.j(this);
        }
    }

    e() {
    }

    public static e a() {
        if (f231090b == null) {
            synchronized (e.class) {
                if (f231090b == null) {
                    f231090b = new e();
                }
            }
        }
        return f231090b;
    }

    public static String d(String str) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            if (RFWFileUtils.isLocalPath(str)) {
                return str;
            }
            Map<String, String> map = f231091c;
            if (map.containsKey(str)) {
                return map.get(str);
            }
            int indexOf = str.indexOf(QzoneWebViewOfflinePlugin.STR_DEVIDER);
            if (indexOf != -1) {
                str2 = str.substring(indexOf + 3);
            } else {
                str2 = str;
            }
            int indexOf2 = str2.indexOf("/");
            if (indexOf2 != -1) {
                str2 = str2.substring(indexOf2);
            }
            int lastIndexOf = str2.lastIndexOf("#");
            if (lastIndexOf != -1) {
                str2 = str2.substring(0, lastIndexOf);
            }
            int indexOf3 = str2.indexOf("tm=");
            if (indexOf3 != -1) {
                str2 = str2.substring(0, indexOf3);
            }
            int indexOf4 = str2.indexOf("ek=1");
            if (indexOf4 != -1) {
                str2 = str2.substring(0, indexOf4);
            }
            map.put(str, str2);
            return str2;
        }
        return "";
    }

    public LibraRequestKey b(Option option) {
        return this.f231092a.getRequestKey(option);
    }

    public String c(@NonNull Option option) {
        return this.f231092a.getPicLocalPath(option);
    }

    public void e(@NonNull Option option) {
        option.disableHardwareDecode();
        this.f231092a.loadImage(option, null);
    }

    public void f(@NonNull Option option, IPicLoadStateListener iPicLoadStateListener) {
        option.disableHardwareDecode();
        if (iPicLoadStateListener != null) {
            iPicLoadStateListener.onStateChange(LoadState.STATE_PREPARE, option);
        }
        this.f231092a.loadImage(option, iPicLoadStateListener);
    }

    public void g() {
        this.f231092a.release();
        f231091c.clear();
    }

    public void h(Option option) {
        this.f231092a.removeCache(option);
    }
}
