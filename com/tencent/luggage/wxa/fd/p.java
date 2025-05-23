package com.tencent.luggage.wxa.fd;

import com.tencent.luggage.wxa.mc.t0;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.io.FilenameUtils;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J \u0010\u0005\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R$\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u000bj\b\u0012\u0004\u0012\u00020\u0002`\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\rR\u0016\u0010\u0011\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/luggage/wxa/fd/p;", "Lcom/tencent/luggage/wxa/xd/l;", "", "pluginAccessPrefix", "", "a", "Lcom/tencent/luggage/wxa/fd/b;", DownloadInfo.spKey_Config, "Lcom/tencent/luggage/wxa/mc/m;", "reader", "", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "mAccessPrefixSet", "b", "Lcom/tencent/luggage/wxa/fd/b;", "mAppConfig", "c", "Lcom/tencent/luggage/wxa/mc/m;", "mPkgFileReader", "<init>", "()V", "luggage-wxa-app_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class p implements com.tencent.luggage.wxa.xd.l {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final HashSet mAccessPrefixSet = new HashSet();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public b mAppConfig;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public com.tencent.luggage.wxa.mc.m mPkgFileReader;

    public final boolean a(String pluginAccessPrefix) {
        Intrinsics.checkNotNullParameter(pluginAccessPrefix, "pluginAccessPrefix");
        synchronized (this.mAccessPrefixSet) {
            boolean add = this.mAccessPrefixSet.add(pluginAccessPrefix);
            b bVar = this.mAppConfig;
            if (bVar == null) {
                return add;
            }
            com.tencent.luggage.wxa.mc.m mVar = this.mPkgFileReader;
            if (mVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPkgFileReader");
                mVar = null;
            }
            Unit unit = Unit.INSTANCE;
            a(bVar, mVar, pluginAccessPrefix);
            return add;
        }
    }

    public final void a(b config, com.tencent.luggage.wxa.mc.m reader, String pluginAccessPrefix) {
        t0.a aVar = t0.f134367k;
        config.a(pluginAccessPrefix, aVar.a(reader.b(FilenameUtils.concat(pluginAccessPrefix, "plugin.json"))), aVar.a(reader.b(FilenameUtils.concat(pluginAccessPrefix, "plugin-darkmode.json"))));
    }
}
