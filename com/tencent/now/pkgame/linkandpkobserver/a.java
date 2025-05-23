package com.tencent.now.pkgame.linkandpkobserver;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import qo3.SeiConfig;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&J2\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u0007H&J\b\u0010\u000f\u001a\u00020\u0004H&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/now/pkgame/linkandpkobserver/a;", "", "Lqo3/a;", "seiConfig", "", "b", "a", "", "pkStatus", "Le55/c;", "anchorInfo", "", "pkId", "pkType", "e", "d", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public interface a {
    void a();

    void b(@Nullable SeiConfig seiConfig);

    void d();

    void e(int pkStatus, @Nullable e55.c anchorInfo, long pkId, int pkType);
}
